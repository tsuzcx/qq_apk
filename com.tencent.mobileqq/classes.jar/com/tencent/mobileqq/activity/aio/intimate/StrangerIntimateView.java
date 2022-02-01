package com.tencent.mobileqq.activity.aio.intimate;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.SystemClock;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.FriendProfileMoreInfoActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.addfriend.api.IAddFriendApi;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.avatar.observer.AvatarObserver;
import com.tencent.mobileqq.config.business.FriendIntimateRelationshipBean;
import com.tencent.mobileqq.config.business.FriendIntimateRelationshipConfProcessor;
import com.tencent.mobileqq.data.IntimateInfo;
import com.tencent.mobileqq.data.IntimateInfo.CommonTroopInfo;
import com.tencent.mobileqq.data.IntimateInfo.DNAInfo;
import com.tencent.mobileqq.friends.intimate.CommonTroopListActivity;
import com.tencent.mobileqq.friends.intimate.IntimateInfoHandler;
import com.tencent.mobileqq.friends.intimate.IntimateInfoObserver;
import com.tencent.mobileqq.multicard.CardContent;
import com.tencent.mobileqq.multicard.MultiCardCustomViewDelegate;
import com.tencent.mobileqq.profile.TroopMemberCardUtils;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.utils.ProfileUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class StrangerIntimateView
  implements Handler.Callback, View.OnClickListener, View.OnTouchListener, BaseIntimateView
{
  private int jdField_a_of_type_Int = 1;
  public Context a;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private View jdField_a_of_type_AndroidViewView;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  public BaseActivity a;
  public QQAppInterface a;
  private IFaceDecoder jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder;
  DecodeTaskCompletionListener jdField_a_of_type_ComTencentMobileqqAvatarListenerDecodeTaskCompletionListener = new StrangerIntimateView.4(this);
  AvatarObserver jdField_a_of_type_ComTencentMobileqqAvatarObserverAvatarObserver = new StrangerIntimateView.3(this);
  private IntimateInfo jdField_a_of_type_ComTencentMobileqqDataIntimateInfo;
  private IntimateInfoHandler jdField_a_of_type_ComTencentMobileqqFriendsIntimateIntimateInfoHandler;
  IntimateInfoObserver jdField_a_of_type_ComTencentMobileqqFriendsIntimateIntimateInfoObserver = new StrangerIntimateView.5(this);
  MultiCardCustomViewDelegate jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomViewDelegate;
  private BounceScrollView jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView;
  private QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  private Long jdField_a_of_type_JavaLangLong;
  public String a;
  public boolean a;
  private View jdField_b_of_type_AndroidViewView;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  public String b;
  public boolean b;
  private View jdField_c_of_type_AndroidViewView;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean = false;
  private View jdField_d_of_type_AndroidViewView;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  private View jdField_e_of_type_AndroidViewView;
  private TextView jdField_e_of_type_AndroidWidgetTextView;
  private View jdField_f_of_type_AndroidViewView;
  private TextView jdField_f_of_type_AndroidWidgetTextView;
  private View g;
  
  public StrangerIntimateView(QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity, Context paramContext, String paramString)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaLangString = paramString;
    paramQQAppInterface = LayoutInflater.from(paramContext).inflate(2131559276, null);
    this.jdField_a_of_type_AndroidViewView = paramQQAppInterface.findViewById(2131376828);
    this.jdField_b_of_type_AndroidViewView = paramQQAppInterface.findViewById(2131378886);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramQQAppInterface.findViewById(2131363340));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramQQAppInterface.findViewById(2131378847));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramQQAppInterface.findViewById(2131377184));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramQQAppInterface.findViewById(2131367324));
    this.jdField_c_of_type_AndroidViewView = paramQQAppInterface.findViewById(2131365028);
    this.jdField_d_of_type_AndroidViewView = paramQQAppInterface.findViewById(2131365032);
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramQQAppInterface.findViewById(2131365031));
    this.jdField_e_of_type_AndroidViewView = paramQQAppInterface.findViewById(2131376191);
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramQQAppInterface.findViewById(2131376189));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)paramQQAppInterface.findViewById(2131376190));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)paramQQAppInterface.findViewById(2131376192));
    this.g = paramQQAppInterface.findViewById(2131366070);
    this.jdField_f_of_type_AndroidViewView = paramQQAppInterface.findViewById(2131367310);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramQQAppInterface.findViewById(2131367304));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)paramQQAppInterface.findViewById(2131362215));
    this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)paramQQAppInterface.findViewById(2131381013));
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView = ((BounceScrollView)paramQQAppInterface.findViewById(2131377006));
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.setOverScrollMode(0);
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.setEdgeEffectEnabled(false);
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.setVerticalScrollBarEnabled(false);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_d_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_e_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_f_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.g.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnTouchListener(this);
    this.jdField_d_of_type_AndroidViewView.setOnTouchListener(this);
    this.jdField_e_of_type_AndroidViewView.setOnTouchListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnTouchListener(this);
    this.jdField_b_of_type_AndroidWidgetImageView.setOnTouchListener(this);
    this.g.setOnTouchListener(this);
    if (AppSetting.d)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(HardCodeUtil.a(2131714367));
      this.jdField_b_of_type_AndroidWidgetImageView.setContentDescription(HardCodeUtil.a(2131714365));
      this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(HardCodeUtil.a(2131714368));
    }
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      paramQQAppInterface = (RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidViewView.getLayoutParams();
      paramQQAppInterface.setMargins(0, ImmersiveUtils.getStatusBarHeight(paramContext), 0, 0);
      this.jdField_b_of_type_AndroidViewView.setLayoutParams(paramQQAppInterface);
    }
    f();
  }
  
  private void a(IntimateInfo paramIntimateInfo)
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("updateIntimateInfo: ");
      ((StringBuilder)localObject1).append(paramIntimateInfo);
      QLog.d("intimate_relationship", 2, ((StringBuilder)localObject1).toString());
    }
    if (paramIntimateInfo == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo = paramIntimateInfo;
    this.jdField_a_of_type_Int = 5;
    g();
    Object localObject3;
    Object localObject4;
    Object localObject2;
    if (this.jdField_b_of_type_AndroidWidgetTextView != null)
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomViewDelegate;
      if (localObject1 != null)
      {
        localObject3 = ((MultiCardCustomViewDelegate)localObject1).a();
        localObject4 = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomViewDelegate.a();
        if (localObject1 != null) {
          localObject1 = ((CardContent)localObject1).b();
        } else {
          localObject1 = "";
        }
        localObject2 = localObject1;
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          localObject2 = ((TroopManager)localObject4).a((String)localObject3, this.jdField_a_of_type_JavaLangString);
        }
        this.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
      }
    }
    int i;
    if ((paramIntimateInfo.commonTroopInfoList != null) && (paramIntimateInfo.commonTroopInfoList.size() > 0))
    {
      i = paramIntimateInfo.commonTroopInfoList.size();
      this.jdField_c_of_type_AndroidViewView.setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetTextView.setText(String.valueOf(i));
      localObject1 = paramIntimateInfo.recentChatTroopInfo;
      if ((localObject1 != null) && (!TextUtils.isEmpty(((IntimateInfo.CommonTroopInfo)localObject1).troopUin)))
      {
        this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
        this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_d_of_type_AndroidWidgetTextView.setText(((IntimateInfo.CommonTroopInfo)localObject1).troopName);
        this.jdField_e_of_type_AndroidWidgetTextView.setText(paramIntimateInfo.commonTroopTips);
        localObject1 = FaceDrawable.getFaceDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 4, ((IntimateInfo.CommonTroopInfo)localObject1).troopCode);
        this.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject1);
      }
      else
      {
        this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      if (this.jdField_b_of_type_Boolean)
      {
        ReportController.b(null, "dc00898", "", "", "0X800A21B ", "0X800A21B ", 0, 0, "", "", "", "");
        QLog.d("Intimate report test", 2, "REPORT_TAG_0X800A21B");
      }
    }
    else
    {
      this.jdField_c_of_type_AndroidViewView.setVisibility(8);
    }
    if (this.jdField_b_of_type_Boolean) {
      j();
    }
    int j;
    if ((paramIntimateInfo.dnaInfoList != null) && (paramIntimateInfo.dnaInfoList.size() > 0))
    {
      this.jdField_f_of_type_AndroidViewView.setVisibility(0);
      if (this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomViewDelegate == null)
      {
        this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
      }
      else
      {
        j = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount();
        if (j > 0)
        {
          i = 0;
          while (i < j)
          {
            localObject1 = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(0);
            this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomViewDelegate.a(this.jdField_a_of_type_AndroidWidgetLinearLayout, (View)localObject1);
            i += 1;
          }
        }
      }
      localObject2 = paramIntimateInfo.dnaInfoList.iterator();
    }
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (IntimateInfo.DNAInfo)((Iterator)localObject2).next();
      paramIntimateInfo = null;
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomViewDelegate;
      if (localObject1 != null) {
        paramIntimateInfo = ((MultiCardCustomViewDelegate)localObject1).a();
      }
      localObject1 = paramIntimateInfo;
      if (paramIntimateInfo == null) {
        localObject1 = IntimateUtil.a(this.jdField_a_of_type_AndroidContentContext);
      }
      paramIntimateInfo = (TextView)((View)localObject1).findViewById(2131378884);
      localObject4 = (TextView)((View)localObject1).findViewById(2131378768);
      paramIntimateInfo.setText(((IntimateInfo.DNAInfo)localObject3).wording);
      if (((IntimateInfo.DNAInfo)localObject3).viceTitle != null)
      {
        paramIntimateInfo = new SpannableString(((IntimateInfo.DNAInfo)localObject3).viceTitle);
        if (!TextUtils.isEmpty(((IntimateInfo.DNAInfo)localObject3).linkWording))
        {
          int k = ((IntimateInfo.DNAInfo)localObject3).viceTitle.indexOf(((IntimateInfo.DNAInfo)localObject3).linkWording);
          j = ((IntimateInfo.DNAInfo)localObject3).linkWording.length() + k;
          i = k;
          if (k < 0)
          {
            paramIntimateInfo = new StringBuilder();
            paramIntimateInfo.append(((IntimateInfo.DNAInfo)localObject3).viceTitle);
            paramIntimateInfo.append(((IntimateInfo.DNAInfo)localObject3).linkWording);
            String str = paramIntimateInfo.toString();
            paramIntimateInfo = new SpannableString(str);
            i = ((IntimateInfo.DNAInfo)localObject3).viceTitle.length();
            j = str.length();
          }
          paramIntimateInfo.setSpan(new StrangerIntimateView.2(this, (IntimateInfo.DNAInfo)localObject3), i, j, 33);
          ((TextView)localObject4).setText(paramIntimateInfo);
          ((TextView)localObject4).setMovementMethod(LinkMovementMethod.getInstance());
        }
        else
        {
          ((TextView)localObject4).setText(paramIntimateInfo);
        }
      }
      else
      {
        ((TextView)localObject4).setVisibility(8);
      }
      paramIntimateInfo = new LinearLayout.LayoutParams(-1, -1);
      paramIntimateInfo.topMargin = ViewUtils.a(16.0F);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1, paramIntimateInfo);
      continue;
      this.jdField_f_of_type_AndroidViewView.setVisibility(8);
    }
    QLog.d("Intimatetest2", 2, "ui ok");
  }
  
  private void a(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null)
    {
      BaseActivity localBaseActivity = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(localBaseActivity, localBaseActivity.getTitleBarHeight());
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(true);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(paramString);
    paramString = this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
    if ((paramString != null) && (!paramString.isShowing()) && (!this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isFinishing())) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
    }
  }
  
  private void f()
  {
    String str;
    if (ThemeUtil.isNowThemeIsNight(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true, null)) {
      str = "";
    } else {
      str = FriendIntimateRelationshipConfProcessor.a().jdField_c_of_type_JavaLangString;
    }
    if ((!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) && (str.equals(this.jdField_c_of_type_JavaLangString))) {
      return;
    }
    Object localObject = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130840529);
    if (!TextUtils.isEmpty(str))
    {
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mRequestWidth = ViewUtils.a();
      localURLDrawableOptions.mRequestHeight = ViewUtils.b();
      localURLDrawableOptions.mLoadingDrawable = ((Drawable)localObject);
      localURLDrawableOptions.mFailedDrawable = ((Drawable)localObject);
      localObject = URLDrawable.getDrawable(str, localURLDrawableOptions);
      ((URLDrawable)localObject).setDecodeHandler(URLDrawableDecodeHandler.x);
      this.jdField_a_of_type_AndroidViewView.setBackgroundDrawable((Drawable)localObject);
      this.jdField_c_of_type_JavaLangString = str;
      return;
    }
    this.jdField_a_of_type_AndroidViewView.setBackgroundDrawable((Drawable)localObject);
  }
  
  private void g()
  {
    QLog.d("Intimatetest2", 2, "updateAddFrdBtn begin");
    if ((this.jdField_a_of_type_AndroidWidgetButton != null) && (this.jdField_f_of_type_AndroidWidgetTextView != null))
    {
      FriendsManager localFriendsManager = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
      if (localFriendsManager.b(this.jdField_a_of_type_JavaLangString))
      {
        this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
        this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      else if (!localFriendsManager.d(this.jdField_a_of_type_JavaLangString))
      {
        this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
        this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(8);
        if (this.jdField_b_of_type_Boolean)
        {
          ReportController.b(null, "dc00898", "", "", "0X800A218 ", "0X800A218 ", 0, 0, "", "", "", "");
          QLog.d("Intimate report test", 2, "REPORT_TAG_0X800A218");
        }
      }
      else
      {
        this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
        this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(0);
        if (ThemeUtil.isNowThemeIsNight(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, null)) {
          this.jdField_f_of_type_AndroidWidgetTextView.setBackgroundResource(2130840514);
        } else {
          this.jdField_f_of_type_AndroidWidgetTextView.setBackgroundResource(2130840515);
        }
      }
    }
    QLog.d("Intimatetest2", 2, "updateAddFrdBtn end");
  }
  
  private void h()
  {
    QQProgressDialog localQQProgressDialog = this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
    if ((localQQProgressDialog != null) && (localQQProgressDialog.isShowing())) {
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
  }
  
  private void j()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo;
    if (localObject != null)
    {
      if (((IntimateInfo)localObject).dnaInfoList != null)
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.dnaInfoList.iterator();
        while (((Iterator)localObject).hasNext()) {
          if (!TextUtils.isEmpty(((IntimateInfo.DNAInfo)((Iterator)localObject).next()).linkWording))
          {
            ReportController.b(null, "dc00898", "", "", "0X800A209 ", "0X800A209 ", 0, 0, "", "", "", "");
            QLog.d("Intimate report test", 2, "REPORT_TAG_0X800A209");
          }
        }
      }
    }
    else {
      QLog.d("intimate_relationship", 2, "DnaLinkReport info null");
    }
  }
  
  public Bitmap a(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder = ((IQQAvatarService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IQQAvatarService.class, "")).getInstance(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.setDecodeTaskCompletionListener(this.jdField_a_of_type_ComTencentMobileqqAvatarListenerDecodeTaskCompletionListener);
    }
    Bitmap localBitmap = this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.getBitmapFromCache(1, paramString, 0, (byte)4);
    if (localBitmap != null) {
      return localBitmap;
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.isPausing()) {
      this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.requestDecodeFace(paramString, 200, false, 1, true, (byte)0, 4);
    }
    return null;
  }
  
  public View a()
  {
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public BaseActivity a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  }
  
  public QQAppInterface a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  }
  
  public MultiCardCustomViewDelegate a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomViewDelegate;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidOsHandler = new Handler(this);
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (localQQAppInterface != null)
    {
      localQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqFriendsIntimateIntimateInfoObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAvatarObserverAvatarObserver);
    }
    ThreadManager.getSubThreadHandler().post(new StrangerIntimateView.1(this));
  }
  
  public void a(CardContent paramCardContent, String paramString)
  {
    if (paramCardContent == null) {
      return;
    }
    this.jdField_a_of_type_JavaLangString = paramCardContent.a();
    this.jdField_b_of_type_JavaLangString = paramString;
    if (paramCardContent.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo != null)
    {
      if (this.jdField_a_of_type_AndroidOsHandler == null) {
        this.jdField_a_of_type_AndroidOsHandler = new Handler(this);
      }
      paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      if (paramString != null)
      {
        paramString.addObserver(this.jdField_a_of_type_ComTencentMobileqqFriendsIntimateIntimateInfoObserver);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAvatarObserverAvatarObserver);
      }
      this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo = paramCardContent.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo;
      paramString = this.jdField_a_of_type_AndroidOsHandler.obtainMessage();
      paramString.what = 0;
      paramString.obj = paramCardContent.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo;
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramString);
      paramCardContent = this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView;
      if (paramCardContent != null) {
        paramCardContent.scrollTo(0, 0);
      }
    }
  }
  
  public void a(MultiCardCustomViewDelegate paramMultiCardCustomViewDelegate)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomViewDelegate;
    if (localObject != null)
    {
      ((MultiCardCustomViewDelegate)localObject).k();
      this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomViewDelegate = null;
      localObject = this.jdField_a_of_type_AndroidOsHandler;
      if (localObject != null) {
        ((Handler)localObject).removeCallbacksAndMessages(null);
      }
    }
    if (paramMultiCardCustomViewDelegate == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomViewDelegate = paramMultiCardCustomViewDelegate;
    paramMultiCardCustomViewDelegate = this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomViewDelegate;
    if (paramMultiCardCustomViewDelegate != null) {
      paramMultiCardCustomViewDelegate.c(this.jdField_a_of_type_AndroidWidgetButton);
    }
    this.jdField_c_of_type_Boolean = true;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void b()
  {
    Bitmap localBitmap = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    if (localBitmap != null) {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(localBitmap);
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      localBitmap = a(this.jdField_a_of_type_JavaLangString);
      if (localBitmap != null) {
        this.jdField_b_of_type_AndroidWidgetImageView.setImageBitmap(localBitmap);
      }
    }
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public void c()
  {
    long l2;
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      if (NetworkUtil.isNetworkAvailable(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity))
      {
        if (this.jdField_a_of_type_ComTencentMobileqqFriendsIntimateIntimateInfoHandler == null) {
          this.jdField_a_of_type_ComTencentMobileqqFriendsIntimateIntimateInfoHandler = ((IntimateInfoHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.INTIMATE_INFO_HANDLER));
        }
        localObject = new ArrayList();
        l2 = 0L;
      }
    }
    try
    {
      l1 = Long.valueOf(this.jdField_a_of_type_JavaLangString).longValue();
    }
    catch (NumberFormatException localNumberFormatException1)
    {
      long l1;
      long l3;
      label84:
      label86:
      break label84;
    }
    try
    {
      l3 = Long.valueOf(this.jdField_b_of_type_JavaLangString).longValue();
      l2 = l3;
    }
    catch (NumberFormatException localNumberFormatException2)
    {
      break label86;
    }
    l1 = 0L;
    QLog.e("intimate_relationship", 2, "valueOf string err");
    ((ArrayList)localObject).add(Long.valueOf(l1));
    this.jdField_a_of_type_ComTencentMobileqqFriendsIntimateIntimateInfoHandler.a(l2, (ArrayList)localObject, null);
    break label187;
    Object localObject = this.jdField_a_of_type_AndroidOsHandler.obtainMessage();
    ((Message)localObject).what = 1;
    ((Message)localObject).obj = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131719223);
    this.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject);
    QLog.d("intimate_relationship", 1, String.format("requestIntimateInfo network is not available, uin: %s", new Object[] { this.jdField_a_of_type_JavaLangString }));
    label187:
    if (QLog.isColorLevel()) {
      QLog.d("intimate_relationship", 2, String.format("requestIntimateInfo, friendUin: %s", new Object[] { this.jdField_a_of_type_JavaLangString }));
    }
  }
  
  public void c(boolean paramBoolean)
  {
    TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
    if (localTextView != null)
    {
      if (paramBoolean)
      {
        localTextView.setVisibility(0);
        return;
      }
      localTextView.setVisibility(4);
    }
  }
  
  public void d()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomViewDelegate;
    if (localObject != null)
    {
      ((MultiCardCustomViewDelegate)localObject).a();
      return;
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
    if (localObject != null) {
      ((BaseActivity)localObject).finish();
    }
  }
  
  public void e()
  {
    g();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3)
          {
            if (i != 4) {
              return true;
            }
            h();
            return true;
          }
          a((String)paramMessage.obj);
          return true;
        }
        paramMessage = (String)paramMessage.obj;
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2, paramMessage, 1).a();
        return true;
      }
      paramMessage = (String)paramMessage.obj;
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 1, paramMessage, 1).a();
      return true;
    }
    a((IntimateInfo)paramMessage.obj);
    return true;
  }
  
  public void i()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (localObject != null)
    {
      ((QQAppInterface)localObject).removeObserver(this.jdField_a_of_type_ComTencentMobileqqFriendsIntimateIntimateInfoObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAvatarObserverAvatarObserver);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder;
    if (localObject != null)
    {
      ((IFaceDecoder)localObject).destory();
      this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder = null;
    }
  }
  
  public void l() {}
  
  public void onClick(View paramView)
  {
    long l = SystemClock.elapsedRealtime();
    Object localObject1 = this.jdField_a_of_type_JavaLangLong;
    if ((localObject1 == null) || (l - ((Long)localObject1).longValue() >= 500L))
    {
      this.jdField_a_of_type_JavaLangLong = Long.valueOf(l);
      Object localObject2;
      switch (paramView.getId())
      {
      default: 
        break;
      case 2131377184: 
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomViewDelegate;
        if (localObject1 == null)
        {
          localObject1 = new AllInOne(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0);
          ProfileUtils.openProfileCard(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, (AllInOne)localObject1);
        }
        else
        {
          localObject1 = ((MultiCardCustomViewDelegate)localObject1).a();
          if (!TextUtils.isEmpty((CharSequence)localObject1))
          {
            localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
            TroopMemberCardUtils.a((QQAppInterface)localObject2, this.jdField_a_of_type_AndroidContentContext, (String)localObject1, ((QQAppInterface)localObject2).getCurrentAccountUin(), 0, -1);
          }
          else
          {
            QLog.e("intimate_relationship", 2, "open troop member card troop uin empty");
          }
        }
        break;
      case 2131376191: 
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo;
        if ((localObject1 != null) && (((IntimateInfo)localObject1).recentChatTroopInfo != null))
        {
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.recentChatTroopInfo;
          localObject2 = AIOUtils.a(new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, SplashActivity.class), null);
          ((Intent)localObject2).putExtra("uin", ((IntimateInfo.CommonTroopInfo)localObject1).troopCode);
          ((Intent)localObject2).putExtra("uintype", 1);
          ((Intent)localObject2).putExtra("uinname", ((IntimateInfo.CommonTroopInfo)localObject1).troopName);
          this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity((Intent)localObject2);
        }
        break;
      case 2131367324: 
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomViewDelegate;
        if (localObject1 == null)
        {
          localObject1 = new AllInOne(this.jdField_a_of_type_JavaLangString, 19);
          ProfileUtils.openProfileCard(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, (AllInOne)localObject1);
        }
        else
        {
          localObject1 = ((MultiCardCustomViewDelegate)localObject1).a();
          if (!TextUtils.isEmpty((CharSequence)localObject1)) {
            TroopMemberCardUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, (String)localObject1, this.jdField_a_of_type_JavaLangString, 0, -1);
          } else {
            QLog.e("intimate_relationship", 2, "open troop member card troop uin empty");
          }
        }
        break;
      case 2131366070: 
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
        if (localObject1 != null)
        {
          localObject1 = new Intent((Context)localObject1, FriendProfileMoreInfoActivity.class);
          this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity((Intent)localObject1);
        }
        break;
      case 2131365032: 
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo;
        if ((localObject1 != null) && (((IntimateInfo)localObject1).commonTroopInfoList != null))
        {
          CommonTroopListActivity.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, (ArrayList)this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.commonTroopInfoList, this.jdField_a_of_type_Int);
          ReportController.b(null, "dc00898", "", "", "0X800A21A ", "0X800A21A ", this.jdField_a_of_type_Int, 0, "", "", "", "");
          QLog.d("Intimate report test", 2, "REPORT_TAG_0X800A21A");
        }
        break;
      case 2131363340: 
        d();
        break;
      case 2131362215: 
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomViewDelegate;
        if ((localObject1 != null) && (((MultiCardCustomViewDelegate)localObject1).a() == 1)) {
          ReportController.b(null, "dc00898", "", "", "0X800A214", "0X800A214", 2, 0, "", "", "", "");
        }
        ReportController.b(null, "dc00898", "", "", "0X800A219 ", "0X800A219 ", 0, 0, "", "", "", "");
        QLog.d("Intimate report test", 2, "REPORT_TAG_0X800A219");
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomViewDelegate;
        if (localObject1 != null)
        {
          String str = ((MultiCardCustomViewDelegate)localObject1).a();
          localObject1 = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomViewDelegate.a();
          if (localObject2 != null) {
            localObject1 = ((CardContent)localObject2).b();
          } else {
            localObject1 = ((TroopManager)localObject1).b(str, this.jdField_a_of_type_JavaLangString);
          }
          localObject2 = localObject1;
          if (localObject1 != null)
          {
            localObject2 = localObject1;
            if (((String)localObject1).equals(this.jdField_a_of_type_JavaLangString)) {
              localObject2 = "";
            }
          }
          localObject1 = (IAddFriendApi)QRoute.api(IAddFriendApi.class);
          Context localContext = this.jdField_a_of_type_AndroidContentContext;
          localObject1 = ((IAddFriendApi)localObject1).startAddFriend(localContext, 1, this.jdField_a_of_type_JavaLangString, str, 3004, 17, (String)localObject2, null, null, localContext.getString(2131689589), null);
          ((IAddFriendApi)QRoute.api(IAddFriendApi.class)).launchAddFriend(this.jdField_a_of_type_AndroidContentContext, (Intent)localObject1);
        }
        break;
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if (i != 0)
    {
      if (((i == 1) || (i == 3)) && (Build.VERSION.SDK_INT >= 11)) {
        paramView.setAlpha(1.0F);
      }
    }
    else if (Build.VERSION.SDK_INT >= 11) {
      paramView.setAlpha(0.5F);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.intimate.StrangerIntimateView
 * JD-Core Version:    0.7.0.1
 */