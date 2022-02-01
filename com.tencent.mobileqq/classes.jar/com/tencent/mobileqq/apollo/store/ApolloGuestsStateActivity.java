package com.tencent.mobileqq.apollo.store;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.annotation.TargetApi;
import android.content.Intent;
import android.content.SharedPreferences;
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
import com.tencent.mobileqq.apollo.res.api.IApolloResDownloader;
import com.tencent.mobileqq.apollo.statistics.product.ApolloDtReportUtil;
import com.tencent.mobileqq.apollo.statistics.product.DtReportParamsBuilder;
import com.tencent.mobileqq.apollo.utils.ApolloConstant;
import com.tencent.mobileqq.apollo.utils.api.IApolloUtil;
import com.tencent.mobileqq.apollo.utils.api.impl.ApolloActionHelperImpl;
import com.tencent.mobileqq.apollo.utils.api.impl.ApolloUtilImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.GlobalImageCache;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloRender;
import com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloRenderInterfaceImpl;
import com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloTextureView;
import com.tencent.mobileqq.cmshow.brickengine.apollo.IRenderCallback;
import com.tencent.mobileqq.magicface.drawable.IMessageHandler;
import com.tencent.mobileqq.magicface.drawable.PngFrameManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.annotation.RoutePage;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.webview.swift.WebUiBaseInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
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
  public static final String TAG = "[cmshow]ApolloGuestsStateActivity";
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
  
  private void addDressDescriptions(List<DressDescriptionItem> paramList)
  {
    if (paramList != null)
    {
      if (paramList.isEmpty()) {
        return;
      }
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      Object localObject1 = this.dressTag;
      int i;
      if ((localObject1 != null) && (((List)localObject1).size() > 0))
      {
        i = 0;
        while (i < this.dressTag.size())
        {
          this.mSurfaceLayout.removeView((View)this.dressTag.get(i));
          i += 1;
        }
        this.dressTag.clear();
      }
      localObject1 = super.getResources().getDisplayMetrics();
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
          if (localDressDescriptionItem.jdField_a_of_type_Boolean) {
            localTextView.setTag("isRole");
          } else {
            localTextView.setTag("isDress");
          }
          localTextView.setOnClickListener(this);
          RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
          localLayoutParams.addRule(15, -1);
          Object localObject2 = getTagByType(localDressDescriptionItem.g);
          if (localDressDescriptionItem.g != 0)
          {
            ((Drawable)localObject2).setBounds(0, 0, ((Drawable)localObject2).getMinimumWidth(), ((Drawable)localObject2).getMinimumHeight());
            localTextView.setCompoundDrawables((Drawable)localObject2, null, null, null);
          }
          int j;
          if (localDressDescriptionItem.b == 0)
          {
            ApolloUtilImpl.setBackgroundSafety(localTextView, 2130838506);
            localTextView.setPadding((int)(((DisplayMetrics)localObject1).density * 5.0F), 0, (int)(((DisplayMetrics)localObject1).density * 19.0F), 0);
            localTextView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            j = localTextView.getMeasuredWidth();
            i = localTextView.getMeasuredHeight();
            if (QLog.isColorLevel())
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("textview measure wiidth=");
              ((StringBuilder)localObject2).append(localTextView.getMeasuredWidth());
              QLog.d("[cmshow]ApolloGuestsStateActivity", 2, ((StringBuilder)localObject2).toString());
            }
            localArrayList2.add(localTextView);
            localLayoutParams.addRule(9, -1);
            localLayoutParams.leftMargin = Math.max(localDressDescriptionItem.c - j, 0);
          }
          else if (localDressDescriptionItem.b == 1)
          {
            ApolloUtilImpl.setBackgroundSafety(localTextView, 2130838507);
            localTextView.setPadding((int)(((DisplayMetrics)localObject1).density * 19.0F), 0, (int)(((DisplayMetrics)localObject1).density * 5.0F), 0);
            localTextView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            j = localTextView.getMeasuredWidth();
            i = localTextView.getMeasuredHeight();
            localArrayList1.add(localTextView);
            localLayoutParams.addRule(11, -1);
            localLayoutParams.rightMargin = Math.max(localDressDescriptionItem.c - j, 0);
          }
          else
          {
            i = 0;
          }
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("tag textview height = ");
            ((StringBuilder)localObject2).append(i);
            QLog.d("[cmshow]ApolloGuestsStateActivity", 2, ((StringBuilder)localObject2).toString());
          }
          localLayoutParams.addRule(12, -1);
          localLayoutParams.bottomMargin = Math.max(localDressDescriptionItem.d - i / 2, 0);
          if (this.mSurfaceView != null)
          {
            this.mSurfaceLayout.addView(localTextView, localLayoutParams);
            localTextView.setVisibility(0);
            this.dressTag.add(localTextView);
          }
        }
      }
      checkTagLocation(localArrayList1);
      checkTagLocation(localArrayList2);
    }
  }
  
  private void doApolloDtReport(String paramString)
  {
    ApolloDtReportUtil.a("aio", "sprite_flower", paramString, new DtReportParamsBuilder().a(0).b(ApolloDtReportUtil.a(this.mFrom)).d(this.mIsMyCard ^ true).b(this.mUin).a());
  }
  
  private Drawable getTagByType(int paramInt)
  {
    int i = 2130838581;
    if (paramInt == 1) {
      paramInt = 2130838580;
    } else {
      paramInt = i;
    }
    return super.getResources().getDrawable(paramInt);
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
    if (paramList != null)
    {
      if (paramList.size() <= 0) {
        return;
      }
      int i = 0;
      while (i < paramList.size() - 1)
      {
        Object localObject = (TextView)paramList.get(i);
        int j = i + 1;
        TextView localTextView = (TextView)paramList.get(j);
        RelativeLayout.LayoutParams localLayoutParams1 = (RelativeLayout.LayoutParams)((TextView)localObject).getLayoutParams();
        RelativeLayout.LayoutParams localLayoutParams2 = (RelativeLayout.LayoutParams)localTextView.getLayoutParams();
        i = j;
        if (localLayoutParams1.bottomMargin - localLayoutParams2.bottomMargin < ((TextView)localObject).getMeasuredHeight())
        {
          int k = ((TextView)localObject).getMeasuredHeight();
          localLayoutParams2.bottomMargin -= k;
          localTextView.requestLayout();
          i = j;
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("tag location modify move distence=");
            ((StringBuilder)localObject).append(k);
            QLog.d("[cmshow]ApolloGuestsStateActivity", 2, ((StringBuilder)localObject).toString());
            i = j;
          }
        }
      }
    }
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 != 3) {
      return;
    }
    if (paramInt2 != -1) {
      return;
    }
    Intent localIntent = AIOUtils.a(new Intent(this, SplashActivity.class), null);
    localIntent.putExtras(new Bundle(paramIntent.getExtras()));
    super.startActivity(localIntent);
    super.finish();
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
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
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    Object localObject = this.mSurfaceView;
    if ((localObject != null) && (((ApolloTextureView)localObject).getRenderImpl() != null))
    {
      this.mSurfaceView.getRenderImpl().a();
      this.mSurfaceView.getRenderImpl().c();
    }
    localObject = this.mPresenter;
    if (localObject != null)
    {
      ((ApolloGuestsPresenter)localObject).e();
      this.mPresenter = null;
    }
    this.dressTag.clear();
    this.dressTag = null;
    localObject = this.mHandler;
    if (localObject != null) {
      ((Handler)localObject).removeCallbacksAndMessages(null);
    }
    this.mHandler = null;
    this.mRenderCallback = null;
    localObject = this.mFlowScaleAnimator;
    if (localObject != null)
    {
      ((ObjectAnimator)localObject).cancel();
      this.mFlowScaleAnimator = null;
    }
    localObject = this.mFlowShrinkAnimator;
    if (localObject != null)
    {
      ((ObjectAnimator)localObject).cancel();
      this.mFlowShrinkAnimator = null;
    }
  }
  
  public void handleMsg(Message paramMessage)
  {
    int i = paramMessage.what;
    Object localObject;
    StringBuilder localStringBuilder;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 5) {
            return;
          }
          paramMessage = (Bitmap)paramMessage.obj;
          if (paramMessage != null)
          {
            paramMessage = new BitmapDrawable(paramMessage);
            this.mDialog.setBackgroundDrawable(paramMessage);
            localObject = GlobalImageCache.a;
            localStringBuilder = new StringBuilder();
            localStringBuilder.append(this.mRoleId);
            localStringBuilder.append("apollo_cmshow_background");
            ((MQLruCache)localObject).put(localStringBuilder.toString(), paramMessage);
          }
        }
      }
      else
      {
        addDressDescriptions((List)paramMessage.obj);
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("dress tag list=");
          ((StringBuilder)localObject).append(((List)paramMessage.obj).toString());
          QLog.d("[cmshow]ApolloGuestsStateActivity", 2, ((StringBuilder)localObject).toString());
        }
      }
    }
    else
    {
      localObject = this.mPraiseNumberText;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(paramMessage.arg1);
      ((TextView)localObject).setText(localStringBuilder.toString());
      if (paramMessage.arg1 < paramMessage.arg2)
      {
        i = paramMessage.arg1;
        int j = paramMessage.arg2;
        localObject = String.valueOf(j);
        paramMessage = (Message)localObject;
        if (j == 99999)
        {
          paramMessage = new StringBuilder();
          paramMessage.append((String)localObject);
          paramMessage.append("+");
          paramMessage = paramMessage.toString();
        }
        this.mPraiseNumberText.setText(paramMessage);
        j -= i;
        if ((j > 0) && (i != 0))
        {
          this.mAddNumber = ((TextView)this.mDialog.findViewById(2131362748));
          paramMessage = this.mAddNumber;
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("+");
          ((StringBuilder)localObject).append(j);
          paramMessage.setText(((StringBuilder)localObject).toString());
          this.mAddNumber.setVisibility(0);
        }
      }
    }
  }
  
  @TargetApi(11)
  public void initBottomBtn()
  {
    this.mButtonRight = ((Button)this.mDialog.findViewById(2131362747));
    this.mButtonRight.setOnClickListener(this);
    this.mButtonRight.setOnTouchListener(new ApolloGuestsStateActivity.1(this));
  }
  
  public void initCommonView()
  {
    Object localObject1 = (TextView)this.mDialog.findViewById(2131371854);
    this.mNick = super.getIntent().getStringExtra("extra_guest_nick");
    this.mUin = super.getIntent().getStringExtra("extra_guest_uin");
    this.mFrom = super.getIntent().getIntExtra("extra_guest_from", 0);
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("nickname = ");
      ((StringBuilder)localObject2).append(this.mNick);
      ((StringBuilder)localObject2).append(" uin=");
      ((StringBuilder)localObject2).append(this.mUin);
      QLog.d("[cmshow]ApolloGuestsStateActivity", 2, ((StringBuilder)localObject2).toString());
    }
    if (this.mUin.equals(super.getAppInterface().getCurrentAccountUin())) {
      this.mIsMyCard = true;
    }
    VipUtils.a(this.app, "cmshow", "Apollo", "yy_dresscheck", this.mFrom, this.mIsMyCard ^ true, new String[0]);
    if (!TextUtils.isEmpty(this.mNick)) {
      ((TextView)localObject1).setText(this.mNick);
    } else {
      ((TextView)localObject1).setText(" ");
    }
    this.mPraiseNumberText = ((TextView)this.mDialog.findViewById(2131362728));
    this.mProgress = ((ImageView)this.mDialog.findViewById(2131378780));
    this.mApprovalLayout = ((RelativeLayout)this.mDialog.findViewById(2131362885));
    initBottomBtn();
    localObject1 = Calendar.getInstance();
    Object localObject2 = BaseApplicationImpl.getApplication().getSharedPreferences("cmshow_zan", 0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(super.getAppInterface().getCurrentAccountUin());
    localStringBuilder.append("apollo_today_has_vote");
    localStringBuilder.append(this.mUin);
    localStringBuilder.append(((Calendar)localObject1).get(1));
    localStringBuilder.append(((Calendar)localObject1).get(2));
    localStringBuilder.append(((Calendar)localObject1).get(5));
    if ((((SharedPreferences)localObject2).getBoolean(localStringBuilder.toString(), false)) && (Build.VERSION.SDK_INT >= 11))
    {
      this.mHasPraised = true;
      this.mButtonRight.setAlpha(0.5F);
    }
    doApolloDtReport("expose");
  }
  
  public void initNoAIUI()
  {
    this.mDialog = super.getLayoutInflater().inflate(2131558619, null, false);
    this.mRootView = new RelativeLayout(this);
    this.mRootView.setBackgroundColor(super.getResources().getColor(2131166961));
    long l1 = Math.max(DeviceInfoUtil.h(), DeviceInfoUtil.g());
    long l2 = Math.min(DeviceInfoUtil.h(), DeviceInfoUtil.g());
    double d1 = l1;
    Double.isNaN(d1);
    float f1 = (float)(d1 / 1.52D);
    double d2 = l2;
    Double.isNaN(d2);
    float f2 = (float)(d2 / 1.27D);
    this.mDialogHeight = f1;
    Object localObject = new RelativeLayout.LayoutParams((int)f2, (int)f1);
    ((RelativeLayout.LayoutParams)localObject).addRule(13);
    this.mRootView.addView(this.mDialog, (ViewGroup.LayoutParams)localObject);
    localObject = new ImageView(this);
    Double.isNaN(d1);
    int i = (int)(d1 / 16.68D + 0.5D);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(i, i);
    localLayoutParams.addRule(12);
    localLayoutParams.addRule(14);
    Double.isNaN(d1);
    localLayoutParams.bottomMargin = ((int)(d1 / 19.899999999999999D + 0.5D));
    this.mCloseImageView = ((ImageView)localObject);
    this.mCloseImageView.setOnClickListener(this);
    ((ImageView)localObject).setBackgroundResource(2130838412);
    this.mRootView.addView((View)localObject, localLayoutParams);
    localObject = AnimationUtils.loadAnimation(this, 2130772021);
    this.mDialog.startAnimation((Animation)localObject);
    localObject = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = ((int)(this.mDialogHeight + 0.5F));
    ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = ((int)(f2 + 0.5F));
    localObject = ((IApolloUtil)QRoute.api(IApolloUtil.class)).getDrawable(true, "/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/image_cache/apollo_aio_bg_v3.png", (URLDrawable.URLDrawableOptions)localObject, "https://cmshow.gtimg.cn/client/img/apollo_aio_bg_v3.png");
    this.mDialog.setBackgroundDrawable((Drawable)localObject);
    this.mSurfaceView = new ApolloTextureView(this, null);
    this.mSurfaceLayout = ((RelativeLayout)this.mDialog.findViewById(2131367880));
    ((RelativeLayout.LayoutParams)this.mSurfaceLayout.getLayoutParams()).bottomMargin = ((int)((float)l1 / 5.03F + 0.5F));
    this.mSurfaceLayout.requestLayout();
    localObject = new RelativeLayout.LayoutParams(-1, -1);
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
    } else {
      this.mPraiseNumberText.setText(paramString);
    }
    this.praiseNumber = paramInt2;
  }
  
  public void onApprovalSet(int paramInt)
  {
    postFresh(paramInt);
  }
  
  @TargetApi(14)
  protected boolean onBackEvent()
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
      paramView = this.mSurfaceView;
      if ((paramView != null) && (paramView.getRenderImpl() != null))
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
    else
    {
      if (paramView.getId() == 2131362747)
      {
        if (this.mIsMyCard)
        {
          paramView = this.mAddNumber;
          if (paramView != null) {
            paramView.setVisibility(8);
          }
          VipUtils.a(this.app, "cmshow", "Apollo", "y_dresscheckflower", this.mFrom, 0, new String[0]);
          paramView = new Intent(this, QQBrowserActivity.class);
          paramView.putExtra("url", "https://cmshow.qq.com/apollo/html/details.html?_bid=2282&_wv=3&seq=-1");
          startActivity(paramView);
          return;
        }
        doApolloDtReport("click_flower");
        if (this.mHasPraised)
        {
          QQToast.a(this, 1, HardCodeUtil.a(2131700611), 0).b(super.getResources().getDimensionPixelSize(2131299168));
          if (QLog.isColorLevel()) {
            QLog.d("[cmshow]ApolloGuestsStateActivity", 2, "today is flowered");
          }
          return;
        }
        VipUtils.a(this.app, "cmshow", "Apollo", "y_dresscheckflower", this.mFrom, 1, new String[0]);
        this.mHasPraised = true;
        playSendFlowerAnimation();
        this.mPresenter.b();
        return;
      }
      int i = paramView.getId();
      Object localObject1 = (DressDescriptionItem)this.mDressDescriptionMaps.get(i);
      Object localObject2 = this.app;
      int j = this.mFrom;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(i);
      VipUtils.a((AppInterface)localObject2, "cmshow", "Apollo", "dresscheckclick", j, 0, new String[] { localStringBuilder.toString() });
      doApolloDtReport("click_store");
      if ("isRole".equals((String)paramView.getTag()))
      {
        paramView = new StringBuilder();
        paramView.append("&view=role,");
        paramView.append(this.mRoleId);
        paramView = paramView.toString();
      }
      else
      {
        if ((((DressDescriptionItem)localObject1).i > 0) && (((DressDescriptionItem)localObject1).j == 1))
        {
          paramView = new StringBuilder();
          paramView.append("&id=");
          paramView.append(((DressDescriptionItem)localObject1).i);
          paramView.append("&type=");
          paramView.append(4);
          ApolloUtilImpl.openCollectCard(this, paramView.toString(), "aio");
          return;
        }
        paramView = new StringBuilder();
        paramView.append("&dressId=");
        paramView.append(i);
        paramView.append("&roleId=");
        paramView.append(this.mRoleId);
        paramView = paramView.toString();
      }
      localObject1 = new Intent();
      ((Intent)localObject1).putExtra("extra_key_url_append", paramView);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("openApolloStore urlPara :");
      ((StringBuilder)localObject2).append(paramView);
      QLog.d("[cmshow]ApolloGuestsStateActivity", 1, ((StringBuilder)localObject2).toString());
      ((IApolloUtil)QRoute.api(IApolloUtil.class)).openApolloStore(this, (Intent)localObject1, "mycmshow", ApolloConstant.z, null);
    }
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
    Object localObject = this.mSurfaceView;
    if (localObject == null) {
      return;
    }
    localObject = ((ApolloTextureView)localObject).getRenderImpl();
    if (localObject == null) {
      return;
    }
    ((ApolloRenderInterfaceImpl)localObject).a(1, null, paramInt, f, this.mApolloWidth, 0.0F);
    if (paramInt == 0) {
      ((ApolloRenderInterfaceImpl)localObject).a(1, null, ((IApolloResDownloader)QRoute.api(IApolloResDownloader.class)).readRoleDefaultDressIds(paramInt), null);
    } else if ((paramInt > 0) && (paramArrayOfInt != null)) {
      ((ApolloRenderInterfaceImpl)localObject).a(1, null, paramArrayOfInt, this.mPresenter);
    }
    this.mRoleId = paramInt;
    if ((!this.mIsActionPlay) && (this.mSurfaceView.getRender() != null))
    {
      this.mSurfaceView.getRender().setRenderCallback(this.mRenderCallback);
      paramArrayOfInt = ApolloActionHelperImpl.getActionRscPath(4, -1, this.mRoleId, true);
      ((ApolloRenderInterfaceImpl)localObject).a(1, null, 5, 0, paramArrayOfInt[0], paramArrayOfInt[1]);
      this.mIsActionPlay = true;
    }
  }
  
  public void onTagLoad(List<DressDescriptionItem> paramList)
  {
    Object localObject = this.mHandler;
    if ((localObject != null) && (paramList != null))
    {
      localObject = ((Handler)localObject).obtainMessage(1);
      ((Message)localObject).obj = paramList;
      ((Message)localObject).sendToTarget();
    }
  }
  
  void postFresh(int paramInt)
  {
    super.runOnUiThread(new ApolloGuestsStateActivity.2(this, paramInt));
  }
  
  void updateZan(int paramInt1, int paramInt2)
  {
    Object localObject = this.mHandler;
    if (localObject != null)
    {
      localObject = ((Handler)localObject).obtainMessage(0);
      ((Message)localObject).arg1 = paramInt1;
      ((Message)localObject).arg2 = paramInt2;
      ((Message)localObject).sendToTarget();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.store.ApolloGuestsStateActivity
 * JD-Core Version:    0.7.0.1
 */