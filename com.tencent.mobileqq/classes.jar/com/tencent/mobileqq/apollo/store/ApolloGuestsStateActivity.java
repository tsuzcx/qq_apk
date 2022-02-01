package com.tencent.mobileqq.apollo.store;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.annotation.TargetApi;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.apollo.ApolloRender;
import com.tencent.mobileqq.apollo.ApolloRenderInterfaceImpl;
import com.tencent.mobileqq.apollo.ApolloTextureView;
import com.tencent.mobileqq.apollo.IRenderCallback;
import com.tencent.mobileqq.apollo.api.res.IApolloResDownloader;
import com.tencent.mobileqq.apollo.api.uitls.ApolloConstant;
import com.tencent.mobileqq.apollo.api.uitls.IApolloUtil;
import com.tencent.mobileqq.apollo.api.uitls.impl.ApolloActionHelperImpl;
import com.tencent.mobileqq.apollo.api.uitls.impl.ApolloUtilImpl;
import com.tencent.mobileqq.apollo.statistics.product.ApolloDtReportUtil;
import com.tencent.mobileqq.apollo.statistics.product.ApolloDtReportUtil.DtReportParamsBuilder;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.GlobalImageCache;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.magicface.drawable.IMessageHandler;
import com.tencent.mobileqq.magicface.drawable.PngFrameManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.annotation.RoutePage;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.webview.swift.WebUiBaseInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.immersive.SystemBarCompact;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

@RoutePage(desc="厘米秀商店GuestsStateActivity", path="/cmshow/store/guestStateActivity")
public class ApolloGuestsStateActivity
  extends BaseActivity
  implements View.OnClickListener, IApolloGuestsView, IMessageHandler, WebUiBaseInterface
{
  public static final String APOLLO_TODAY_HAS_VOTE = "apollo_today_has_vote";
  public static final String CARD_BG_URL = "https://cmshow.gtimg.cn/client/img/apollo_aio_bg_v3.png";
  public static final int MSG_INIT_DRESS_TAG = 1;
  public static final int MSG_SET_ROLE_BACKGROUND = 5;
  public static final int MSG_VISIBLE_PAAISENUM = 2;
  public static final int MSG_ZAN_COUNT_GET = 0;
  public static final String SP_KEY = "cmshow_zan";
  public static final String TAG = "ApolloGuestsStateActivity";
  protected ActionSheet actionSheet;
  List<View> dressTag = new ArrayList();
  TextView mAddNumber;
  float mApolloWidth = 0.0F;
  RelativeLayout mApprovalLayout;
  LinearLayout mBottomLayout;
  Button mButtonRight;
  private ImageView mCloseImageView;
  float mDensity = 0.0F;
  View mDialog;
  float mDialogHeight = 0.0F;
  private SparseArray<DressDescriptionItem> mDressDescriptionMaps = new SparseArray();
  private ObjectAnimator mFlowScaleAnimator;
  private ObjectAnimator mFlowShrinkAnimator;
  int mFrom;
  Handler mHandler;
  boolean mHasPraised;
  boolean mIsActionPlay = false;
  boolean mIsClosing;
  boolean mIsDesdroy = false;
  boolean mIsMyCard = false;
  int mManWidth = 0;
  String mNick;
  TextView mPraiseNumberText;
  private ApolloGuestsPresenter mPresenter;
  ImageView mProgress;
  public IRenderCallback mRenderCallback = new ApolloGuestsStateActivity.4(this);
  int mRoleId = 0;
  private RelativeLayout mRootView;
  RelativeLayout mSurfaceLayout;
  ApolloTextureView mSurfaceView;
  String mUin;
  int praiseNumber;
  
  private void ApolloDtReport(String paramString)
  {
    int i = 0;
    ApolloDtReportUtil.DtReportParamsBuilder localDtReportParamsBuilder = new ApolloDtReportUtil.DtReportParamsBuilder().a(0).b(ApolloDtReportUtil.a(this.mFrom));
    if (this.mIsMyCard) {}
    for (;;)
    {
      ApolloDtReportUtil.a("aio", "sprite_flower", paramString, localDtReportParamsBuilder.d(i).b(this.mUin).a());
      return;
      i = 1;
    }
  }
  
  private void addDressDescriptions(List<DressDescriptionItem> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return;
    }
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    int i;
    if ((this.dressTag != null) && (this.dressTag.size() > 0))
    {
      i = 0;
      while (i < this.dressTag.size())
      {
        this.mSurfaceLayout.removeView((View)this.dressTag.get(i));
        i += 1;
      }
      this.dressTag.clear();
    }
    DisplayMetrics localDisplayMetrics = super.getResources().getDisplayMetrics();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      DressDescriptionItem localDressDescriptionItem = (DressDescriptionItem)paramList.next();
      if (!TextUtils.isEmpty(localDressDescriptionItem.jdField_a_of_type_JavaLangString))
      {
        this.mDressDescriptionMaps.put(localDressDescriptionItem.jdField_a_of_type_Int, localDressDescriptionItem);
        TextView localTextView = new TextView(this);
        localTextView.setId(localDressDescriptionItem.jdField_a_of_type_Int);
        localTextView.setText(localDressDescriptionItem.jdField_a_of_type_JavaLangString);
        localTextView.setTextSize(10.0F);
        localTextView.setTextColor(-1);
        localTextView.setGravity(17);
        label230:
        RelativeLayout.LayoutParams localLayoutParams;
        int j;
        if (localDressDescriptionItem.jdField_a_of_type_Boolean)
        {
          localTextView.setTag("isRole");
          localTextView.setOnClickListener(this);
          localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
          localLayoutParams.addRule(15, -1);
          i = 0;
          Drawable localDrawable = getTagByType(localDressDescriptionItem.g);
          if (localDressDescriptionItem.g != 0)
          {
            localDrawable.setBounds(0, 0, localDrawable.getMinimumWidth(), localDrawable.getMinimumHeight());
            localTextView.setCompoundDrawables(localDrawable, null, null, null);
          }
          if (localDressDescriptionItem.b != 0) {
            break label553;
          }
          ApolloUtilImpl.setBackgroundSafety(localTextView, 2130838667);
          localTextView.setPadding((int)(5.0F * localDisplayMetrics.density), 0, (int)(19.0F * localDisplayMetrics.density), 0);
          localTextView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
          j = localTextView.getMeasuredWidth();
          i = localTextView.getMeasuredHeight();
          if (QLog.isColorLevel()) {
            QLog.d("ApolloGuestsStateActivity", 2, "textview measure wiidth=" + localTextView.getMeasuredWidth());
          }
          localArrayList2.add(localTextView);
          localLayoutParams.addRule(9, -1);
          localLayoutParams.leftMargin = Math.max(localDressDescriptionItem.c - j, 0);
        }
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ApolloGuestsStateActivity", 2, "tag textview height = " + i);
          }
          localLayoutParams.addRule(12, -1);
          localLayoutParams.bottomMargin = Math.max(localDressDescriptionItem.d - i / 2, 0);
          if (this.mSurfaceView == null) {
            break;
          }
          this.mSurfaceLayout.addView(localTextView, localLayoutParams);
          localTextView.setVisibility(0);
          this.dressTag.add(localTextView);
          break;
          localTextView.setTag("isDress");
          break label230;
          label553:
          if (localDressDescriptionItem.b == 1)
          {
            ApolloUtilImpl.setBackgroundSafety(localTextView, 2130838668);
            localTextView.setPadding((int)(19.0F * localDisplayMetrics.density), 0, (int)(5.0F * localDisplayMetrics.density), 0);
            localTextView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            j = localTextView.getMeasuredWidth();
            i = localTextView.getMeasuredHeight();
            localArrayList1.add(localTextView);
            localLayoutParams.addRule(11, -1);
            localLayoutParams.rightMargin = Math.max(localDressDescriptionItem.c - j, 0);
          }
        }
      }
    }
    checkTagLocation(localArrayList1);
    checkTagLocation(localArrayList2);
  }
  
  private Drawable getTagByType(int paramInt)
  {
    int j = 2130838736;
    int i;
    if (paramInt == 1) {
      i = 2130838735;
    }
    for (;;)
    {
      return super.getResources().getDrawable(i);
      i = j;
      if (paramInt == 2) {
        i = j;
      }
    }
  }
  
  private void playSendFlowerAnimation()
  {
    PropertyValuesHolder localPropertyValuesHolder1 = PropertyValuesHolder.ofFloat("scaleX", new float[] { 1.0F, 1.8F, 1.2F });
    PropertyValuesHolder localPropertyValuesHolder2 = PropertyValuesHolder.ofFloat("scaleY", new float[] { 1.0F, 1.8F, 1.2F });
    this.mFlowScaleAnimator = ObjectAnimator.ofPropertyValuesHolder(this.mButtonRight, new PropertyValuesHolder[] { localPropertyValuesHolder1, localPropertyValuesHolder2 });
    this.mFlowScaleAnimator.setDuration(500L);
    this.mFlowScaleAnimator.addListener(new ApolloGuestsStateActivity.3(this));
    this.mFlowScaleAnimator.start();
  }
  
  public void checkTagLocation(List<TextView> paramList)
  {
    if ((paramList == null) || (paramList.size() <= 0)) {}
    for (;;)
    {
      return;
      int i = 0;
      while (i < paramList.size() - 1)
      {
        TextView localTextView1 = (TextView)paramList.get(i);
        TextView localTextView2 = (TextView)paramList.get(i + 1);
        RelativeLayout.LayoutParams localLayoutParams1 = (RelativeLayout.LayoutParams)localTextView1.getLayoutParams();
        RelativeLayout.LayoutParams localLayoutParams2 = (RelativeLayout.LayoutParams)localTextView2.getLayoutParams();
        if (localLayoutParams1.bottomMargin - localLayoutParams2.bottomMargin < localTextView1.getMeasuredHeight())
        {
          int j = localTextView1.getMeasuredHeight();
          localLayoutParams2.bottomMargin -= j;
          localTextView2.requestLayout();
          if (QLog.isColorLevel()) {
            QLog.d("ApolloGuestsStateActivity", 2, "tag location modify move distence=" + j);
          }
        }
        i += 1;
      }
    }
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    switch (paramInt1)
    {
    }
    do
    {
      return;
    } while (paramInt2 != -1);
    Intent localIntent = AIOUtils.a(new Intent(this, SplashActivity.class), null);
    localIntent.putExtras(new Bundle(paramIntent.getExtras()));
    super.startActivity(localIntent);
    super.finish();
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    getWindow().addFlags(16777216);
    super.doOnCreate(paramBundle);
    this.mHandler = PngFrameManager.a(this);
    this.mDensity = super.getResources().getDisplayMetrics().density;
    initUI();
    this.mPresenter = new ApolloGuestsPresenter(this, (QQAppInterface)super.getAppInterface(), this, this.mUin, this.mSurfaceView);
    this.mPresenter.a();
    super.setContentView(this.mRootView);
    super.setImmersiveStatus();
    if (this.mSystemBarComp != null)
    {
      this.mSystemBarComp.init();
      this.mSystemBarComp.setStatusColor(0);
      this.mSystemBarComp.setStatusBarColor(0);
    }
    return false;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if ((this.mSurfaceView != null) && (this.mSurfaceView.getRenderImpl() != null))
    {
      this.mSurfaceView.getRenderImpl().a();
      this.mSurfaceView.getRenderImpl().c();
    }
    if (this.mPresenter != null)
    {
      this.mPresenter.e();
      this.mPresenter = null;
    }
    this.dressTag.clear();
    this.dressTag = null;
    if (this.mHandler != null) {
      this.mHandler.removeCallbacksAndMessages(null);
    }
    this.mHandler = null;
    this.mRenderCallback = null;
    if (this.mFlowScaleAnimator != null)
    {
      this.mFlowScaleAnimator.cancel();
      this.mFlowScaleAnimator = null;
    }
    if (this.mFlowShrinkAnimator != null)
    {
      this.mFlowShrinkAnimator.cancel();
      this.mFlowShrinkAnimator = null;
    }
  }
  
  public void handleMsg(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      do
      {
        int i;
        int j;
        do
        {
          do
          {
            return;
            this.mPraiseNumberText.setText("" + paramMessage.arg1);
          } while (paramMessage.arg1 >= paramMessage.arg2);
          i = paramMessage.arg1;
          j = paramMessage.arg2;
          String str = String.valueOf(j);
          paramMessage = str;
          if (j == 99999) {
            paramMessage = str + "+";
          }
          this.mPraiseNumberText.setText(paramMessage);
          j -= i;
        } while ((j <= 0) || (i == 0));
        this.mAddNumber = ((TextView)this.mDialog.findViewById(2131362798));
        this.mAddNumber.setText("+" + j);
        this.mAddNumber.setVisibility(0);
        return;
        addDressDescriptions((List)paramMessage.obj);
      } while (!QLog.isColorLevel());
      QLog.d("ApolloGuestsStateActivity", 2, "dress tag list=" + ((List)paramMessage.obj).toString());
      return;
      paramMessage = (Bitmap)paramMessage.obj;
    } while (paramMessage == null);
    paramMessage = new BitmapDrawable(paramMessage);
    this.mDialog.setBackgroundDrawable(paramMessage);
    GlobalImageCache.a.put(this.mRoleId + "apollo_cmshow_background", paramMessage);
  }
  
  @TargetApi(11)
  public void initBottomBtn()
  {
    this.mButtonRight = ((Button)this.mDialog.findViewById(2131362797));
    this.mButtonRight.setOnClickListener(this);
    this.mButtonRight.setOnTouchListener(new ApolloGuestsStateActivity.1(this));
  }
  
  public void initCommonView()
  {
    Object localObject = (TextView)this.mDialog.findViewById(2131372265);
    this.mNick = super.getIntent().getStringExtra("extra_guest_nick");
    this.mUin = super.getIntent().getStringExtra("extra_guest_uin");
    this.mFrom = super.getIntent().getIntExtra("extra_guest_from", 0);
    if (QLog.isColorLevel()) {
      QLog.d("ApolloGuestsStateActivity", 2, "nickname = " + this.mNick + " uin=" + this.mUin);
    }
    if (this.mUin.equals(super.getAppInterface().getCurrentAccountUin())) {
      this.mIsMyCard = true;
    }
    QQAppInterface localQQAppInterface = this.app;
    int j = this.mFrom;
    int i;
    if (this.mIsMyCard)
    {
      i = 0;
      VipUtils.a(localQQAppInterface, "cmshow", "Apollo", "yy_dresscheck", j, i, new String[0]);
      if (TextUtils.isEmpty(this.mNick)) {
        break label354;
      }
      ((TextView)localObject).setText(this.mNick);
    }
    for (;;)
    {
      this.mPraiseNumberText = ((TextView)this.mDialog.findViewById(2131362778));
      this.mProgress = ((ImageView)this.mDialog.findViewById(2131379428));
      this.mApprovalLayout = ((RelativeLayout)this.mDialog.findViewById(2131362934));
      initBottomBtn();
      localObject = Calendar.getInstance();
      if ((BaseApplicationImpl.getApplication().getSharedPreferences("cmshow_zan", 0).getBoolean(super.getAppInterface().getCurrentAccountUin() + "apollo_today_has_vote" + this.mUin + ((Calendar)localObject).get(1) + ((Calendar)localObject).get(2) + ((Calendar)localObject).get(5), false)) && (Build.VERSION.SDK_INT >= 11))
      {
        this.mHasPraised = true;
        this.mButtonRight.setAlpha(0.5F);
      }
      ApolloDtReport("expose");
      return;
      i = 1;
      break;
      label354:
      ((TextView)localObject).setText(" ");
    }
  }
  
  public void initNoAIUI()
  {
    this.mDialog = super.getLayoutInflater().inflate(2131558720, null, false);
    this.mRootView = new RelativeLayout(this);
    this.mRootView.setBackgroundColor(super.getResources().getColor(2131166942));
    long l1 = Math.max(DeviceInfoUtil.h(), DeviceInfoUtil.g());
    long l2 = Math.min(DeviceInfoUtil.h(), DeviceInfoUtil.g());
    float f1 = (float)(l1 / 1.52D);
    float f2 = (float)(l2 / 1.27D);
    this.mDialogHeight = f1;
    Object localObject = new RelativeLayout.LayoutParams((int)f2, (int)f1);
    ((RelativeLayout.LayoutParams)localObject).addRule(13);
    this.mRootView.addView(this.mDialog, (ViewGroup.LayoutParams)localObject);
    localObject = new ImageView(this);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams((int)(l1 / 16.68D + 0.5D), (int)(l1 / 16.68D + 0.5D));
    localLayoutParams.addRule(12);
    localLayoutParams.addRule(14);
    localLayoutParams.bottomMargin = ((int)(l1 / 19.899999999999999D + 0.5D));
    this.mCloseImageView = ((ImageView)localObject);
    this.mCloseImageView.setOnClickListener(this);
    ((ImageView)localObject).setBackgroundResource(2130838570);
    this.mRootView.addView((View)localObject, localLayoutParams);
    localObject = AnimationUtils.loadAnimation(this, 2130772012);
    this.mDialog.startAnimation((Animation)localObject);
    localObject = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = ((int)(this.mDialogHeight + 0.5F));
    ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = ((int)(f2 + 0.5F));
    localObject = ((IApolloUtil)QRoute.api(IApolloUtil.class)).getDrawable(true, "/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/image_cache/apollo_aio_bg_v3.png", (URLDrawable.URLDrawableOptions)localObject, "https://cmshow.gtimg.cn/client/img/apollo_aio_bg_v3.png");
    this.mDialog.setBackgroundDrawable((Drawable)localObject);
    this.mSurfaceView = new ApolloTextureView(this, null);
    localObject = new RelativeLayout.LayoutParams(-1, -1);
    this.mSurfaceLayout = ((RelativeLayout)this.mDialog.findViewById(2131368126));
    ((RelativeLayout.LayoutParams)this.mSurfaceLayout.getLayoutParams()).bottomMargin = ((int)((float)l1 / 5.03F + 0.5F));
    this.mSurfaceLayout.requestLayout();
    ((RelativeLayout.LayoutParams)localObject).addRule(14);
    this.mSurfaceLayout.addView(this.mSurfaceView, (ViewGroup.LayoutParams)localObject);
    this.mSurfaceView.init(new ApolloGuestsStateActivity.CMShowOnApolloViewListener(this));
    if (BaseApplicationImpl.sProcessId == 7) {
      this.mSurfaceView.setDumplicateCreateRenderThread(true);
    }
    initCommonView();
  }
  
  @TargetApi(11)
  public void initUI()
  {
    initNoAIUI();
  }
  
  public void onApprovalGet(String paramString, int paramInt1, int paramInt2)
  {
    this.praiseNumber = paramInt1;
    if (this.mIsMyCard) {
      updateZan(this.praiseNumber, paramInt2);
    }
    for (;;)
    {
      this.praiseNumber = paramInt2;
      return;
      this.mPraiseNumberText.setText(paramString);
    }
  }
  
  public void onApprovalSet(int paramInt)
  {
    postFresh(paramInt);
  }
  
  @TargetApi(14)
  public boolean onBackEvent()
  {
    if (!isFinishing())
    {
      finish();
      overridePendingTransition(0, 0);
    }
    return true;
  }
  
  @TargetApi(14)
  public void onClick(View paramView)
  {
    if (paramView == this.mCloseImageView)
    {
      if ((this.mSurfaceView != null) && (this.mSurfaceView.getRenderImpl() != null))
      {
        this.mSurfaceView.getRenderImpl().a();
        this.mIsDesdroy = true;
        this.mSurfaceView.setVisibility(8);
      }
      if (!isFinishing())
      {
        finish();
        overridePendingTransition(0, 0);
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (paramView.getId() != 2131362797) {
        break;
      }
      if (this.mIsMyCard)
      {
        if (this.mAddNumber != null) {
          this.mAddNumber.setVisibility(8);
        }
        VipUtils.a(this.app, "cmshow", "Apollo", "y_dresscheckflower", this.mFrom, 0, new String[0]);
        localObject = new Intent(this, QQBrowserActivity.class);
        ((Intent)localObject).putExtra("url", "https://cmshow.qq.com/apollo/html/details.html?_bid=2282&_wv=3&seq=-1");
        startActivity((Intent)localObject);
      }
      else
      {
        ApolloDtReport("click_flower");
        if (this.mHasPraised)
        {
          QQToast.a(this, 1, HardCodeUtil.a(2131700469), 0).b(super.getResources().getDimensionPixelSize(2131299166));
          if (QLog.isColorLevel()) {
            QLog.d("ApolloGuestsStateActivity", 2, "today is flowered");
          }
        }
        else
        {
          VipUtils.a(this.app, "cmshow", "Apollo", "y_dresscheckflower", this.mFrom, 1, new String[0]);
          this.mHasPraised = true;
          playSendFlowerAnimation();
          this.mPresenter.b();
        }
      }
    }
    int i = paramView.getId();
    Object localObject = (DressDescriptionItem)this.mDressDescriptionMaps.get(i);
    VipUtils.a(this.app, "cmshow", "Apollo", "dresscheckclick", this.mFrom, 0, new String[] { "" + i });
    ApolloDtReport("click_store");
    if ("isRole".equals((String)paramView.getTag())) {}
    for (localObject = "&view=role," + this.mRoleId;; localObject = "&dressId=" + i + "&roleId=" + this.mRoleId)
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("extra_key_url_append", (String)localObject);
      ((IApolloUtil)QRoute.api(IApolloUtil.class)).openApolloStore(this, localIntent, "mycmshow", ApolloConstant.u, null);
      break;
      if ((((DressDescriptionItem)localObject).i > 0) && (((DressDescriptionItem)localObject).j == 1))
      {
        ApolloUtilImpl.openCollectCard(this, "&id=" + ((DressDescriptionItem)localObject).i + "&type=" + 4, "aio");
        break;
      }
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onDressChange()
  {
    if (this.mSurfaceView.getRenderImpl() != null) {
      this.mSurfaceView.getRenderImpl().a();
    }
  }
  
  public void onLoadApolloInfo(int[] paramArrayOfInt, int paramInt)
  {
    float f = (float)Math.max(DeviceInfoUtil.h(), DeviceInfoUtil.g()) / 3.25F / 368.0F;
    if (this.mSurfaceView == null) {}
    ApolloRenderInterfaceImpl localApolloRenderInterfaceImpl;
    do
    {
      return;
      localApolloRenderInterfaceImpl = this.mSurfaceView.getRenderImpl();
    } while (localApolloRenderInterfaceImpl == null);
    localApolloRenderInterfaceImpl.a(1, null, paramInt, f, this.mApolloWidth, 0.0F);
    if (paramInt == 0) {
      localApolloRenderInterfaceImpl.a(1, null, ((IApolloResDownloader)QRoute.api(IApolloResDownloader.class)).readRoleDefaultDressIds(paramInt), null);
    }
    for (;;)
    {
      this.mRoleId = paramInt;
      if ((this.mIsActionPlay) || (this.mSurfaceView.getRender() == null)) {
        break;
      }
      this.mSurfaceView.getRender().setRenderCallback(this.mRenderCallback);
      paramArrayOfInt = ApolloActionHelperImpl.getActionRscPath(4, -1, this.mRoleId, true);
      localApolloRenderInterfaceImpl.a(1, null, 5, 0, paramArrayOfInt[0], paramArrayOfInt[1]);
      this.mIsActionPlay = true;
      return;
      if ((paramInt > 0) && (paramArrayOfInt != null)) {
        localApolloRenderInterfaceImpl.a(1, null, paramArrayOfInt, this.mPresenter);
      }
    }
  }
  
  public void onTagLoad(List<DressDescriptionItem> paramList)
  {
    if ((this.mHandler != null) && (paramList != null))
    {
      Message localMessage = this.mHandler.obtainMessage(1);
      localMessage.obj = paramList;
      localMessage.sendToTarget();
    }
  }
  
  void postFresh(int paramInt)
  {
    super.runOnUiThread(new ApolloGuestsStateActivity.2(this, paramInt));
  }
  
  void updateZan(int paramInt1, int paramInt2)
  {
    if (this.mHandler != null)
    {
      Message localMessage = this.mHandler.obtainMessage(0);
      localMessage.arg1 = paramInt1;
      localMessage.arg2 = paramInt2;
      localMessage.sendToTarget();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.store.ApolloGuestsStateActivity
 * JD-Core Version:    0.7.0.1
 */