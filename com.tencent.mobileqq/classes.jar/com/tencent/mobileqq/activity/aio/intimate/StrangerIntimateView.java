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
import android.support.v4.app.FragmentActivity;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.AddFriendLogicActivity;
import com.tencent.mobileqq.activity.FriendProfileMoreInfoActivity;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
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
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ViewUtils;
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
  public FragmentActivity a;
  private View jdField_a_of_type_AndroidViewView;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
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
  
  public StrangerIntimateView(QQAppInterface paramQQAppInterface, FragmentActivity paramFragmentActivity, Context paramContext, String paramString)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity = paramFragmentActivity;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaLangString = paramString;
    paramQQAppInterface = LayoutInflater.from(paramContext).inflate(2131559401, null);
    this.jdField_a_of_type_AndroidViewView = paramQQAppInterface.findViewById(2131377376);
    this.jdField_b_of_type_AndroidViewView = paramQQAppInterface.findViewById(2131379538);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramQQAppInterface.findViewById(2131363408));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramQQAppInterface.findViewById(2131379497));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramQQAppInterface.findViewById(2131377756));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramQQAppInterface.findViewById(2131367566));
    this.jdField_c_of_type_AndroidViewView = paramQQAppInterface.findViewById(2131365148);
    this.jdField_d_of_type_AndroidViewView = paramQQAppInterface.findViewById(2131365152);
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramQQAppInterface.findViewById(2131365151));
    this.jdField_e_of_type_AndroidViewView = paramQQAppInterface.findViewById(2131376687);
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramQQAppInterface.findViewById(2131376685));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)paramQQAppInterface.findViewById(2131376686));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)paramQQAppInterface.findViewById(2131376688));
    this.g = paramQQAppInterface.findViewById(2131366169);
    this.jdField_f_of_type_AndroidViewView = paramQQAppInterface.findViewById(2131367552);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramQQAppInterface.findViewById(2131367546));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)paramQQAppInterface.findViewById(2131362189));
    this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)paramQQAppInterface.findViewById(2131381791));
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView = ((BounceScrollView)paramQQAppInterface.findViewById(2131377562));
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
      this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(HardCodeUtil.a(2131714446));
      this.jdField_b_of_type_AndroidWidgetImageView.setContentDescription(HardCodeUtil.a(2131714444));
      this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(HardCodeUtil.a(2131714447));
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
    if (QLog.isColorLevel()) {
      QLog.d("intimate_relationship", 2, "updateIntimateInfo: " + paramIntimateInfo);
    }
    if (paramIntimateInfo == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo = paramIntimateInfo;
    this.jdField_a_of_type_Int = 5;
    g();
    Object localObject3;
    Object localObject4;
    Object localObject1;
    Object localObject2;
    if ((this.jdField_b_of_type_AndroidWidgetTextView != null) && (this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomViewDelegate != null))
    {
      localObject3 = this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomViewDelegate.a();
      localObject4 = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
      localObject1 = "";
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomViewDelegate.a();
      if (localObject2 != null) {
        localObject1 = ((CardContent)localObject2).b();
      }
      localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject2 = ((TroopManager)localObject4).a((String)localObject3, this.jdField_a_of_type_JavaLangString);
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
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
        if (this.jdField_b_of_type_Boolean)
        {
          ReportController.b(null, "dc00898", "", "", "0X800A21B ", "0X800A21B ", 0, 0, "", "", "", "");
          QLog.d("Intimate report test", 2, "REPORT_TAG_0X800A21B");
        }
        label339:
        if (this.jdField_b_of_type_Boolean) {
          j();
        }
        if ((paramIntimateInfo.dnaInfoList == null) || (paramIntimateInfo.dnaInfoList.size() <= 0)) {
          break label798;
        }
        this.jdField_f_of_type_AndroidViewView.setVisibility(0);
        if (this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomViewDelegate != null) {
          break label729;
        }
        this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
        label391:
        localObject2 = paramIntimateInfo.dnaInfoList.iterator();
        i = 0;
        label404:
        if (!((Iterator)localObject2).hasNext()) {
          break label807;
        }
        localObject3 = (IntimateInfo.DNAInfo)((Iterator)localObject2).next();
        paramIntimateInfo = null;
        if (this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomViewDelegate != null) {
          paramIntimateInfo = this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomViewDelegate.a();
        }
        if (paramIntimateInfo != null) {
          break label818;
        }
        paramIntimateInfo = IntimateUtil.a(this.jdField_a_of_type_AndroidContentContext);
      }
    }
    label798:
    label807:
    label818:
    for (;;)
    {
      localObject1 = (TextView)paramIntimateInfo.findViewById(2131379536);
      localObject4 = (TextView)paramIntimateInfo.findViewById(2131379416);
      ((TextView)localObject1).setText(((IntimateInfo.DNAInfo)localObject3).wording);
      int j;
      if (((IntimateInfo.DNAInfo)localObject3).viceTitle != null)
      {
        localObject1 = new SpannableString(((IntimateInfo.DNAInfo)localObject3).viceTitle);
        if (!TextUtils.isEmpty(((IntimateInfo.DNAInfo)localObject3).linkWording))
        {
          int m = ((IntimateInfo.DNAInfo)localObject3).viceTitle.indexOf(((IntimateInfo.DNAInfo)localObject3).linkWording);
          int k = ((IntimateInfo.DNAInfo)localObject3).linkWording.length() + m;
          j = m;
          if (m < 0)
          {
            String str = ((IntimateInfo.DNAInfo)localObject3).viceTitle + ((IntimateInfo.DNAInfo)localObject3).linkWording;
            localObject1 = new SpannableString(str);
            j = ((IntimateInfo.DNAInfo)localObject3).viceTitle.length();
            k = str.length();
          }
          ((SpannableString)localObject1).setSpan(new StrangerIntimateView.2(this, (IntimateInfo.DNAInfo)localObject3), j, k, 33);
          ((TextView)localObject4).setText((CharSequence)localObject1);
          ((TextView)localObject4).setMovementMethod(LinkMovementMethod.getInstance());
        }
      }
      for (;;)
      {
        localObject1 = new LinearLayout.LayoutParams(-1, -1);
        ((LinearLayout.LayoutParams)localObject1).topMargin = ViewUtils.a(16.0F);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(paramIntimateInfo, (ViewGroup.LayoutParams)localObject1);
        i += 1;
        break label404;
        this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(8);
        break;
        this.jdField_c_of_type_AndroidViewView.setVisibility(8);
        break label339;
        label729:
        j = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount();
        if (j <= 0) {
          break label391;
        }
        i = 0;
        while (i < j)
        {
          localObject1 = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(0);
          this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomViewDelegate.a(this.jdField_a_of_type_AndroidWidgetLinearLayout, (View)localObject1);
          i += 1;
        }
        break label391;
        ((TextView)localObject4).setText((CharSequence)localObject1);
        continue;
        ((TextView)localObject4).setVisibility(8);
      }
      this.jdField_f_of_type_AndroidViewView.setVisibility(8);
      QLog.d("Intimatetest2", 2, "ui ok");
      return;
    }
  }
  
  private void a(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getTitleBarHeight());
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(true);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(paramString);
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (!this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()) && (!this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.isFinishing())) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
    }
  }
  
  private void f()
  {
    if (ThemeUtil.isNowThemeIsNight(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true, null)) {}
    for (String str = ""; (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) && (str.equals(this.jdField_c_of_type_JavaLangString)); str = FriendIntimateRelationshipConfProcessor.a().jdField_c_of_type_JavaLangString) {
      return;
    }
    Object localObject = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130840654);
    if (!TextUtils.isEmpty(str))
    {
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mRequestWidth = ViewUtils.a();
      localURLDrawableOptions.mRequestHeight = ViewUtils.b();
      localURLDrawableOptions.mLoadingDrawable = ((Drawable)localObject);
      localURLDrawableOptions.mFailedDrawable = ((Drawable)localObject);
      localObject = URLDrawable.getDrawable(str, localURLDrawableOptions);
      ((URLDrawable)localObject).setDecodeHandler(URLDrawableDecodeHandler.z);
      this.jdField_a_of_type_AndroidViewView.setBackgroundDrawable((Drawable)localObject);
      this.jdField_c_of_type_JavaLangString = str;
      return;
    }
    this.jdField_a_of_type_AndroidViewView.setBackgroundDrawable((Drawable)localObject);
  }
  
  private void g()
  {
    QLog.d("Intimatetest2", 2, "updateAddFrdBtn begin");
    FriendsManager localFriendsManager;
    if ((this.jdField_a_of_type_AndroidWidgetButton != null) && (this.jdField_f_of_type_AndroidWidgetTextView != null))
    {
      localFriendsManager = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
      if (!localFriendsManager.b(this.jdField_a_of_type_JavaLangString)) {
        break label78;
      }
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    for (;;)
    {
      QLog.d("Intimatetest2", 2, "updateAddFrdBtn end");
      return;
      label78:
      if (!localFriendsManager.d(this.jdField_a_of_type_JavaLangString))
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
          this.jdField_f_of_type_AndroidWidgetTextView.setBackgroundResource(2130840639);
        } else {
          this.jdField_f_of_type_AndroidWidgetTextView.setBackgroundResource(2130840640);
        }
      }
    }
  }
  
  private void h()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {}
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
  
  private void j()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.dnaInfoList != null)
      {
        Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.dnaInfoList.iterator();
        while (localIterator.hasNext()) {
          if (!TextUtils.isEmpty(((IntimateInfo.DNAInfo)localIterator.next()).linkWording))
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
  
  public FragmentActivity a()
  {
    return this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity;
  }
  
  public View a()
  {
    return this.jdField_a_of_type_AndroidViewView;
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
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqFriendsIntimateIntimateInfoObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAvatarObserverAvatarObserver);
    }
    ThreadManager.getSubThreadHandler().post(new StrangerIntimateView.1(this));
  }
  
  public void a(CardContent paramCardContent, String paramString)
  {
    if (paramCardContent == null) {}
    do
    {
      do
      {
        return;
        this.jdField_a_of_type_JavaLangString = paramCardContent.a();
        this.jdField_b_of_type_JavaLangString = paramString;
      } while (paramCardContent.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo == null);
      if (this.jdField_a_of_type_AndroidOsHandler == null) {
        this.jdField_a_of_type_AndroidOsHandler = new Handler(this);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqFriendsIntimateIntimateInfoObserver);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAvatarObserverAvatarObserver);
      }
      this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo = paramCardContent.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo;
      paramString = this.jdField_a_of_type_AndroidOsHandler.obtainMessage();
      paramString.what = 0;
      paramString.obj = paramCardContent.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo;
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramString);
    } while (this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView == null);
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.scrollTo(0, 0);
  }
  
  public void a(MultiCardCustomViewDelegate paramMultiCardCustomViewDelegate)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomViewDelegate != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomViewDelegate.k();
      this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomViewDelegate = null;
      if (this.jdField_a_of_type_AndroidOsHandler != null) {
        this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      }
    }
    if (paramMultiCardCustomViewDelegate == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomViewDelegate = paramMultiCardCustomViewDelegate;
    if (this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomViewDelegate != null) {
      this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomViewDelegate.c(this.jdField_a_of_type_AndroidWidgetButton);
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
    Object localObject;
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      if (!NetworkUtil.g(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity)) {
        break label146;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqFriendsIntimateIntimateInfoHandler == null) {
        this.jdField_a_of_type_ComTencentMobileqqFriendsIntimateIntimateInfoHandler = ((IntimateInfoHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.INTIMATE_INFO_HANDLER));
      }
      localObject = new ArrayList();
    }
    for (;;)
    {
      try
      {
        l2 = Long.valueOf(this.jdField_a_of_type_JavaLangString).longValue();
        QLog.e("intimate_relationship", 2, "valueOf string err");
      }
      catch (NumberFormatException localNumberFormatException1)
      {
        try
        {
          l1 = Long.valueOf(this.jdField_b_of_type_JavaLangString).longValue();
          ((ArrayList)localObject).add(Long.valueOf(l2));
          this.jdField_a_of_type_ComTencentMobileqqFriendsIntimateIntimateInfoHandler.a(l1, (ArrayList)localObject, null);
          if (QLog.isColorLevel()) {
            QLog.d("intimate_relationship", 2, String.format("requestIntimateInfo, friendUin: %s", new Object[] { this.jdField_a_of_type_JavaLangString }));
          }
          return;
        }
        catch (NumberFormatException localNumberFormatException2)
        {
          for (;;)
          {
            long l2;
            long l1 = l2;
          }
        }
        localNumberFormatException1 = localNumberFormatException1;
        l1 = 0L;
      }
      l2 = l1;
      l1 = 0L;
      continue;
      label146:
      localObject = this.jdField_a_of_type_AndroidOsHandler.obtainMessage();
      ((Message)localObject).what = 1;
      ((Message)localObject).obj = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131719505);
      this.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject);
      QLog.d("intimate_relationship", 1, String.format("requestIntimateInfo network is not available, uin: %s", new Object[] { this.jdField_a_of_type_JavaLangString }));
    }
  }
  
  public void c(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_AndroidWidgetTextView != null)
    {
      if (paramBoolean) {
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomViewDelegate != null) {
      this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomViewDelegate.a();
    }
    while (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity == null) {
      return;
    }
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.finish();
  }
  
  public void e()
  {
    g();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return true;
    case 0: 
      a((IntimateInfo)paramMessage.obj);
      return true;
    case 1: 
      paramMessage = (String)paramMessage.obj;
      QQToast.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 1, paramMessage, 1).a();
      return true;
    case 2: 
      paramMessage = (String)paramMessage.obj;
      QQToast.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 2, paramMessage, 1).a();
      return true;
    case 3: 
      a((String)paramMessage.obj);
      return true;
    }
    h();
    return true;
  }
  
  public void i()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqFriendsIntimateIntimateInfoObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAvatarObserverAvatarObserver);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.destory();
      this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder = null;
    }
  }
  
  public void l() {}
  
  public void onClick(View paramView)
  {
    long l = SystemClock.elapsedRealtime();
    if ((this.jdField_a_of_type_JavaLangLong != null) && (l - this.jdField_a_of_type_JavaLangLong.longValue() < 500L)) {}
    do
    {
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        this.jdField_a_of_type_JavaLangLong = Long.valueOf(l);
        switch (paramView.getId())
        {
        }
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomViewDelegate != null) && (this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomViewDelegate.a() == 1)) {
        ReportController.b(null, "dc00898", "", "", "0X800A214", "0X800A214", 2, 0, "", "", "", "");
      }
      ReportController.b(null, "dc00898", "", "", "0X800A219 ", "0X800A219 ", 0, 0, "", "", "", "");
      QLog.d("Intimate report test", 2, "REPORT_TAG_0X800A219");
    } while (this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomViewDelegate == null);
    String str = this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomViewDelegate.a();
    Object localObject1 = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomViewDelegate.a();
    if (localObject2 != null) {}
    for (localObject1 = ((CardContent)localObject2).b();; localObject1 = ((TroopManager)localObject1).b(str, this.jdField_a_of_type_JavaLangString))
    {
      localObject2 = localObject1;
      if (localObject1 != null)
      {
        localObject2 = localObject1;
        if (((String)localObject1).equals(this.jdField_a_of_type_JavaLangString)) {
          localObject2 = "";
        }
      }
      localObject1 = AddFriendLogicActivity.a(this.jdField_a_of_type_AndroidContentContext, 1, this.jdField_a_of_type_JavaLangString, str, 3004, 17, (String)localObject2, null, null, this.jdField_a_of_type_AndroidContentContext.getString(2131689557), null);
      this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject1);
      break;
      d();
      break;
      if ((this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo == null) || (this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.commonTroopInfoList == null)) {
        break;
      }
      CommonTroopListActivity.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, (ArrayList)this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.commonTroopInfoList, this.jdField_a_of_type_Int);
      ReportController.b(null, "dc00898", "", "", "0X800A21A ", "0X800A21A ", this.jdField_a_of_type_Int, 0, "", "", "", "");
      QLog.d("Intimate report test", 2, "REPORT_TAG_0X800A21A");
      break;
      if ((this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo == null) || (this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.recentChatTroopInfo == null)) {
        break;
      }
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.recentChatTroopInfo;
      localObject2 = AIOUtils.a(new Intent(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, SplashActivity.class), null);
      ((Intent)localObject2).putExtra("uin", ((IntimateInfo.CommonTroopInfo)localObject1).troopCode);
      ((Intent)localObject2).putExtra("uintype", 1);
      ((Intent)localObject2).putExtra("uinname", ((IntimateInfo.CommonTroopInfo)localObject1).troopName);
      this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.startActivity((Intent)localObject2);
      break;
      if (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity == null) {
        break;
      }
      localObject1 = new Intent(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, FriendProfileMoreInfoActivity.class);
      this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.startActivity((Intent)localObject1);
      break;
      if (this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomViewDelegate == null)
      {
        localObject1 = new ProfileActivity.AllInOne(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0);
        ProfileActivity.b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, (ProfileActivity.AllInOne)localObject1);
        break;
      }
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomViewDelegate.a();
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        TroopMemberCardUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, (String)localObject1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0, -1);
        break;
      }
      QLog.e("intimate_relationship", 2, "open troop member card troop uin empty");
      break;
      if (this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomViewDelegate == null)
      {
        localObject1 = new ProfileActivity.AllInOne(this.jdField_a_of_type_JavaLangString, 19);
        ProfileActivity.b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, (ProfileActivity.AllInOne)localObject1);
        break;
      }
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomViewDelegate.a();
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        TroopMemberCardUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, (String)localObject1, this.jdField_a_of_type_JavaLangString, 0, -1);
        break;
      }
      QLog.e("intimate_relationship", 2, "open troop member card troop uin empty");
      break;
    }
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return false;
      if (Build.VERSION.SDK_INT >= 11)
      {
        paramView.setAlpha(0.5F);
        continue;
        if (Build.VERSION.SDK_INT >= 11) {
          paramView.setAlpha(1.0F);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.intimate.StrangerIntimateView
 * JD-Core Version:    0.7.0.1
 */