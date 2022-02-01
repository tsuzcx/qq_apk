package com.tencent.mobileqq.addfriend.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.selectmember.api.IForwardApi;
import com.tencent.mobileqq.addfriend.api.IAddFriendApi;
import com.tencent.mobileqq.addfriend.api.IAddFriendServiceApi;
import com.tencent.mobileqq.addfriend.helper.InjectHelper;
import com.tencent.mobileqq.addfriend.processor.BaseAddFriendProcessor;
import com.tencent.mobileqq.addfriend.utils.AddFriendUtil;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.avatar.utils.AvatarUtil;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.KplRoleInfo.WZRYUIinfo;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.fragment.QIphoneTitleBarFragment;
import com.tencent.mobileqq.friend.api.IFriendDataService;
import com.tencent.mobileqq.friend.api.IFriendHandlerService;
import com.tencent.mobileqq.friend.observer.FriendObserver;
import com.tencent.mobileqq.newfriend.api.INewFriendVerificationService;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolService;
import com.tencent.mobileqq.profilecard.observer.ProfileCardObserver;
import com.tencent.mobileqq.qcircle.api.IQCircleReportApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.relation.api.IAddFriendTempApi;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.utils.HttpWebCgiAsyncTask.Callback;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.mobileqq.widget.FormItemRelativeLayout;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qidian.controller.QidianBusinessObserverExpose;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.Switch;
import com.tencent.widget.immersive.ImmersiveUtils;
import friendlist.EAddFriendSourceID;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONObject;

public class AddFriendVerifyFragment
  extends QIphoneTitleBarFragment
  implements TextWatcher, View.OnClickListener, View.OnTouchListener, CompoundButton.OnCheckedChangeListener, HttpWebCgiAsyncTask.Callback
{
  public static final boolean a;
  private int jdField_a_of_type_Int;
  private Dialog jdField_a_of_type_AndroidAppDialog;
  private Bundle jdField_a_of_type_AndroidOsBundle;
  private ViewTreeObserver.OnGlobalLayoutListener jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener = new AddFriendVerifyFragment.19(this);
  protected InputMethodManager a;
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private InjectHelper jdField_a_of_type_ComTencentMobileqqAddfriendHelperInjectHelper;
  AddFriendVerifyFragment.MaxBytesTextWatcher jdField_a_of_type_ComTencentMobileqqAddfriendUiAddFriendVerifyFragment$MaxBytesTextWatcher;
  KplRoleInfo.WZRYUIinfo jdField_a_of_type_ComTencentMobileqqDataKplRoleInfo$WZRYUIinfo;
  private final FriendObserver jdField_a_of_type_ComTencentMobileqqFriendObserverFriendObserver = new AddFriendVerifyFragment.21(this);
  private ProfileCardObserver jdField_a_of_type_ComTencentMobileqqProfilecardObserverProfileCardObserver = new AddFriendVerifyFragment.20(this);
  protected QQCustomDialog a;
  private BounceScrollView jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView;
  private FormItemRelativeLayout jdField_a_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout = null;
  private QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  private QidianBusinessObserverExpose jdField_a_of_type_ComTencentQidianControllerQidianBusinessObserverExpose = new AddFriendVerifyFragment.22(this);
  private Switch jdField_a_of_type_ComTencentWidgetSwitch;
  String jdField_a_of_type_JavaLangString = "";
  private ArrayList<EditText> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private int jdField_b_of_type_Int;
  private EditText jdField_b_of_type_AndroidWidgetEditText = null;
  private LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  AddFriendVerifyFragment.MaxBytesTextWatcher jdField_b_of_type_ComTencentMobileqqAddfriendUiAddFriendVerifyFragment$MaxBytesTextWatcher;
  private FormItemRelativeLayout jdField_b_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout = null;
  private Switch jdField_b_of_type_ComTencentWidgetSwitch;
  private String jdField_b_of_type_JavaLangString;
  private ArrayList<PhoneContact> jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  private int jdField_c_of_type_Int;
  private View jdField_c_of_type_AndroidViewView;
  private ImageView jdField_c_of_type_AndroidWidgetImageView = null;
  private LinearLayout jdField_c_of_type_AndroidWidgetLinearLayout;
  private String jdField_c_of_type_JavaLangString = "";
  private ArrayList<BaseAddFriendProcessor> jdField_c_of_type_JavaUtilArrayList;
  private boolean jdField_c_of_type_Boolean = true;
  private int jdField_d_of_type_Int;
  private View jdField_d_of_type_AndroidViewView;
  private int e = -1;
  private TextView g;
  private TextView h;
  private TextView i;
  private TextView j;
  private TextView k = null;
  
  static
  {
    jdField_a_of_type_Boolean = AppSetting.d;
  }
  
  public AddFriendVerifyFragment()
  {
    this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager = null;
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
  }
  
  private <T extends View> T a(int paramInt)
  {
    return this.jdField_b_of_type_AndroidViewView.findViewById(paramInt);
  }
  
  private String a(boolean paramBoolean)
  {
    if (getActivity() == null) {
      return null;
    }
    SharedPreferences localSharedPreferences = getActivity().getSharedPreferences("last_verify_msg", 0);
    if (paramBoolean)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("last_add_troop_verfity_");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getAccount());
      return localSharedPreferences.getString(localStringBuilder.toString(), null);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("last_add_friend_verify_");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getAccount());
    return localSharedPreferences.getString(localStringBuilder.toString(), null);
  }
  
  private void a(int paramInt, String paramString)
  {
    if (c()) {
      return;
    }
    if (this.jdField_c_of_type_Int == 3090) {
      try
      {
        localObject = getActivity().getIntent().getStringExtra("extra");
        ((IForwardApi)QRoute.api(IForwardApi.class)).startGameSdkCallback(getActivity(), true, "action_game_make_friend", Long.parseLong((String)localObject), paramInt, paramString);
        return;
      }
      catch (Exception paramString)
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("feedBackToGameSDK error = ");
        ((StringBuilder)localObject).append(paramString);
        QLog.e("IphoneTitleBarFragment", 1, ((StringBuilder)localObject).toString());
      }
    }
  }
  
  private void a(URLDrawable paramURLDrawable)
  {
    if ((paramURLDrawable != null) && (this.jdField_a_of_type_ComTencentCommonAppAppInterface != null))
    {
      if (this.jdField_c_of_type_AndroidWidgetImageView == null) {
        return;
      }
      Bitmap localBitmap = BaseImageUtil.a(paramURLDrawable);
      if (paramURLDrawable.getStatus() == 1)
      {
        paramURLDrawable = AvatarUtil.a(localBitmap, 50, 50);
        this.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable(new BitmapDrawable(paramURLDrawable));
        return;
      }
      paramURLDrawable.setURLDrawableListener(new AddFriendVerifyFragment.12(this));
    }
  }
  
  private void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    if (c()) {
      return;
    }
    e();
    this.jdField_a_of_type_AndroidAppDialog = DialogUtil.a(getActivity(), 230, null, paramString1, paramString2, paramString3, new AddFriendVerifyFragment.14(this, paramString5, paramString4), new AddFriendVerifyFragment.15(this));
    try
    {
      this.jdField_a_of_type_AndroidAppDialog.show();
      return;
    }
    catch (Throwable paramString1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("IphoneTitleBarFragment", 2, "showErrorTipsDialogWithHandleAbility, tips dialog show failed", paramString1);
      }
    }
  }
  
  private void b(String paramString)
  {
    if (c()) {
      return;
    }
    e();
    this.jdField_a_of_type_AndroidAppDialog = DialogUtil.a(getActivity(), paramString, 0, 2131694331, null, new AddFriendVerifyFragment.13(this, paramString));
    try
    {
      this.jdField_a_of_type_AndroidAppDialog.show();
      return;
    }
    catch (Throwable paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d("IphoneTitleBarFragment", 2, "showErrorTipsDlg, tips dialog show failed", paramString);
      }
    }
  }
  
  private boolean b()
  {
    if (getActivity() == null) {
      return false;
    }
    SharedPreferences localSharedPreferences = getActivity().getSharedPreferences("last_verify_msg", 0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("add_friend_verify_msg_modify_flag");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getAccount());
    return localSharedPreferences.getBoolean(localStringBuilder.toString(), false);
  }
  
  private void c()
  {
    if (getActivity() == null) {
      return;
    }
    ((IAddFriendTempApi)QRoute.api(IAddFriendTempApi.class)).reportExtendFriend(this.jdField_c_of_type_Int, this.jdField_b_of_type_JavaLangString, getActivity().getIntent());
  }
  
  private void c(String paramString)
  {
    ReportController.b(null, "dc00898", "", "", "0X800B991", "0X800B991", 0, 0, "", "", "", "");
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("showSecurityTipsDialog errorStr = ");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("IphoneTitleBarFragment", 2, ((StringBuilder)localObject).toString());
    }
    e();
    FragmentActivity localFragmentActivity = getActivity();
    String str = getString(2131718651);
    Object localObject = paramString;
    if (TextUtils.isEmpty(paramString)) {
      localObject = getString(2131718648);
    }
    this.jdField_a_of_type_AndroidAppDialog = DialogUtil.a(localFragmentActivity, 230, str, (String)localObject, 2131718649, 2131718650, new AddFriendVerifyFragment.16(this), new AddFriendVerifyFragment.17(this));
    try
    {
      this.jdField_a_of_type_AndroidAppDialog.show();
      return;
    }
    catch (Throwable paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d("IphoneTitleBarFragment", 2, "showSecurityTipsDialog, tips dialog show failed", paramString);
      }
    }
  }
  
  private boolean c()
  {
    return (getActivity() == null) || (getActivity().isFinishing());
  }
  
  private void d()
  {
    if (getActivity() == null) {
      return;
    }
    SharedPreferences.Editor localEditor = getActivity().getSharedPreferences("last_verify_msg", 0).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("add_friend_verify_msg_modify_flag");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getAccount());
    localEditor.putBoolean(localStringBuilder.toString(), true);
  }
  
  private boolean d()
  {
    FragmentActivity localFragmentActivity = getActivity();
    boolean bool2 = true;
    if (localFragmentActivity == null) {
      return true;
    }
    int m = getActivity().getIntent().getExtras().getInt("source_id", 3999);
    boolean bool1 = bool2;
    if (m != 3003)
    {
      bool1 = bool2;
      if (m != 3006)
      {
        bool1 = bool2;
        if (m != 3007)
        {
          bool1 = bool2;
          if (m != 3009)
          {
            if (m == 3013) {
              return true;
            }
            bool1 = false;
          }
        }
      }
    }
    return bool1;
  }
  
  private void e()
  {
    Dialog localDialog = this.jdField_a_of_type_AndroidAppDialog;
    if ((localDialog != null) && (localDialog.isShowing()) && (this.jdField_a_of_type_AndroidAppDialog.getWindow() != null)) {}
    try
    {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  private void f()
  {
    if (c()) {
      return;
    }
    getActivity().runOnUiThread(new AddFriendVerifyFragment.18(this));
  }
  
  private void g()
  {
    INewFriendVerificationService localINewFriendVerificationService = (INewFriendVerificationService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(INewFriendVerificationService.class, "");
    if ((localINewFriendVerificationService != null) && (getActivity() != null) && (getActivity().getIntent() != null))
    {
      int m = getActivity().getIntent().getIntExtra("friend_setting", 0);
      int n = getActivity().getIntent().getIntExtra("source_id", 3999);
      String str = getActivity().getIntent().getExtras().getString("extra");
      int i1 = getActivity().getIntent().getIntExtra("sub_source_id", 0);
      localINewFriendVerificationService.reportAddFriendBlocked(this.jdField_b_of_type_JavaLangString, m, n, i1, str);
    }
  }
  
  protected int a()
  {
    return 2131561583;
  }
  
  public Friends a(String paramString)
  {
    if (!Friends.isValidUin(paramString)) {
      return null;
    }
    return ((IFriendDataService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IFriendDataService.class, "")).getFriend(paramString, true, true);
  }
  
  public String a(String paramString)
  {
    Friends localFriends = a(paramString);
    String str = paramString;
    if (localFriends != null)
    {
      str = paramString;
      if (localFriends.alias != null)
      {
        str = paramString;
        if (localFriends.alias.length() > 0) {
          str = localFriends.alias;
        }
      }
    }
    return str;
  }
  
  void a()
  {
    if (c()) {
      return;
    }
    if (getActivity().getIntent().getBooleanExtra("need_jumpto_splash", false))
    {
      ((IAddFriendTempApi)QRoute.api(IAddFriendTempApi.class)).jumpToSplash(getActivity());
      getActivity().finish();
      return;
    }
    Object localObject = getActivity().getIntent().getStringExtra("param_return_addr");
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("goBack | retAddr = ");
      localStringBuilder.append((String)localObject);
      QLog.d("IphoneTitleBarFragment", 2, localStringBuilder.toString());
    }
    if (localObject != null) {
      try
      {
        localObject = Class.forName((String)localObject);
        startActivity(((IAddFriendTempApi)QRoute.api(IAddFriendTempApi.class)).composeReturnIntent((Class)localObject, this.jdField_b_of_type_JavaLangString, getActivity()));
        return;
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        if (QLog.isColorLevel()) {
          QLog.d("IphoneTitleBarFragment", 2, "goBack | exception = ", localClassNotFoundException);
        }
        localClassNotFoundException.printStackTrace();
        getActivity().setResult(-1);
        getActivity().finish();
        return;
      }
    }
    if (getActivity().getIntent().getBooleanExtra("from_newer_guide", false))
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("has_operation", true);
      localIntent.putExtra("uin", this.jdField_b_of_type_JavaLangString);
      getActivity().setResult(-1, localIntent);
    }
    else
    {
      a(0, "");
      getActivity().setResult(-1);
    }
    getActivity().finish();
  }
  
  void a(int paramInt1, int paramInt2)
  {
    if (getActivity() == null) {
      return;
    }
    boolean bool = getActivity().getIntent().getBooleanExtra("select_multi_mode", false);
    String str = getActivity().getIntent().getStringExtra("troop_uin");
    ThreadManager.post(new AddFriendVerifyFragment.9(this, paramInt1, getActivity().getIntent().getIntExtra("sub_source_id", 0), bool, str, paramInt2), 5, null, true);
  }
  
  protected void a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.a(paramLayoutInflater, paramViewGroup, paramBundle);
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = ((AppInterface)getQBaseActivity().getAppRuntime());
    this.jdField_a_of_type_ComTencentMobileqqAddfriendHelperInjectHelper = new InjectHelper();
    this.jdField_c_of_type_JavaUtilArrayList = this.jdField_a_of_type_ComTencentMobileqqAddfriendHelperInjectHelper.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface);
    if (c()) {
      return;
    }
    Intent localIntent = getActivity().getIntent();
    this.jdField_b_of_type_JavaLangString = localIntent.getStringExtra("uin");
    this.jdField_a_of_type_Int = localIntent.getIntExtra("k_uin_type", 1);
    this.e = localIntent.getIntExtra("entrance", -1);
    this.jdField_d_of_type_Int = localIntent.getIntExtra("sub_source_id", 0);
    this.jdField_c_of_type_Int = localIntent.getIntExtra("source_id", 3999);
    if (localIntent.hasExtra("param_wzry_data")) {
      this.jdField_a_of_type_ComTencentMobileqqDataKplRoleInfo$WZRYUIinfo = ((KplRoleInfo.WZRYUIinfo)localIntent.getSerializableExtra("param_wzry_data"));
    }
    if (AddFriendUtil.a(this.jdField_c_of_type_Int))
    {
      this.jdField_c_of_type_JavaLangString = localIntent.getStringExtra("nick_name");
    }
    else if (this.jdField_a_of_type_ComTencentMobileqqDataKplRoleInfo$WZRYUIinfo != null)
    {
      this.jdField_c_of_type_JavaLangString = localIntent.getStringExtra("nick_name");
    }
    else if (this.jdField_c_of_type_Int == 3004)
    {
      m = this.jdField_d_of_type_Int;
      if ((m == 5) || (m == 6) || (m == 7) || (m == 8)) {
        this.jdField_c_of_type_JavaLangString = localIntent.getStringExtra("nick_name");
      }
    }
    if (QLog.isColorLevel())
    {
      paramLayoutInflater = new StringBuilder();
      paramLayoutInflater.append("AddFriendVerifyActivity remark = ");
      paramLayoutInflater.append(this.jdField_c_of_type_JavaLangString);
      paramLayoutInflater.append(", source id=");
      paramLayoutInflater.append(this.jdField_c_of_type_Int);
      paramLayoutInflater.append(", mTargetGroupId = ");
      paramLayoutInflater.append(this.jdField_b_of_type_Int);
      QLog.i("IphoneTitleBarFragment", 2, paramLayoutInflater.toString());
    }
    if ((paramBundle == null) && (NetworkUtil.isNetSupport(getActivity())) && (AddFriendUtil.a(this.jdField_c_of_type_Int, this.jdField_b_of_type_JavaLangString))) {
      ((IFriendHandlerService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IFriendHandlerService.class, "")).requestAutoInfo(this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_Int, localIntent.getIntExtra("sub_source_id", 0));
    }
    getActivity().getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener);
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView = ((BounceScrollView)a(2131363786));
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.setOnTouchListener(new AddFriendVerifyFragment.1(this));
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)a(2131376446));
    this.h = ((TextView)a(2131376447));
    this.jdField_a_of_type_ComTencentMobileqqAddfriendUiAddFriendVerifyFragment$MaxBytesTextWatcher = new AddFriendVerifyFragment.MaxBytesTextWatcher(100, this.jdField_a_of_type_AndroidWidgetEditText);
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(this.jdField_a_of_type_ComTencentMobileqqAddfriendUiAddFriendVerifyFragment$MaxBytesTextWatcher);
    this.i = ((TextView)a(2131362295));
    this.i.setVisibility(0);
    paramLayoutInflater = getActivity().getIntent().getStringExtra("key_param_age_area");
    if (!TextUtils.isEmpty(paramLayoutInflater))
    {
      this.i.setText(paramLayoutInflater);
      if (AppSetting.d) {
        this.i.setContentDescription(paramLayoutInflater);
      }
    }
    this.jdField_a_of_type_AndroidWidgetEditText.setOnTouchListener(this);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)a(2131371747));
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)a(2131362709));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)a(2131372959));
    this.g = ((TextView)a(2131371877));
    this.j = ((TextView)a(2131378853));
    this.jdField_c_of_type_AndroidWidgetLinearLayout = ((LinearLayout)a(2131367825));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout = ((FormItemRelativeLayout)a(2131376728));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout.setBGType(1);
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout = ((FormItemRelativeLayout)a(2131376688));
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout.setBGType(3);
    this.jdField_b_of_type_AndroidWidgetEditText = ((EditText)a(2131366329));
    this.k = ((TextView)a(2131379709));
    this.jdField_b_of_type_AndroidWidgetEditText.addTextChangedListener(this);
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetEditText.setText(this.jdField_c_of_type_JavaLangString);
    if (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) {
      this.jdField_b_of_type_AndroidWidgetEditText.setSelection(this.jdField_c_of_type_JavaLangString.length());
    }
    this.k.setText(AddFriendUtil.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_b_of_type_Int));
    paramLayoutInflater = this.jdField_b_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout;
    paramViewGroup = new StringBuilder();
    paramViewGroup.append(HardCodeUtil.a(2131700086));
    paramViewGroup.append(AddFriendUtil.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_b_of_type_Int));
    paramLayoutInflater.setContentDescription(paramViewGroup.toString());
    if (Utils.b(this.jdField_b_of_type_JavaLangString))
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout.setVisibility(8);
      this.j.setText(getString(2131689614));
    }
    else
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout.setVisibility(0);
      this.j.setText(getString(2131689613));
    }
    if ((!EAddFriendSourceID.a(this.jdField_c_of_type_Int)) && (this.jdField_c_of_type_Int != 3016)) {
      m = 0;
    } else {
      m = 1;
    }
    if (m == 0)
    {
      this.jdField_c_of_type_AndroidViewView = a(2131375610);
      this.jdField_c_of_type_AndroidViewView.setVisibility(0);
      this.jdField_a_of_type_ComTencentWidgetSwitch = ((Switch)a(2131375611));
      this.jdField_a_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(this);
    }
    if ((this.jdField_c_of_type_Int == 3050) && (this.jdField_d_of_type_Int == 3))
    {
      if (!localIntent.getBooleanExtra("qcircle_isfollow", false))
      {
        this.jdField_d_of_type_AndroidViewView = a(2131373902);
        this.jdField_d_of_type_AndroidViewView.setVisibility(0);
        this.jdField_b_of_type_ComTencentWidgetSwitch = ((Switch)a(2131373903));
        this.jdField_b_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(this);
        paramLayoutInflater = new HashMap();
        paramLayoutInflater.put("ext3", "1");
        ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504(this.jdField_b_of_type_JavaLangString, 79, 1, 0, paramLayoutInflater, null, null);
      }
      else
      {
        paramLayoutInflater = new HashMap();
        paramLayoutInflater.put("ext3", "2");
        ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504(this.jdField_b_of_type_JavaLangString, 79, 1, 0, paramLayoutInflater, null, null);
      }
      if (localIntent.getBooleanExtra("key_qcircle_stick", false)) {
        ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504(this.jdField_b_of_type_JavaLangString, 93, 1, 1);
      }
    }
    if (AppSetting.d)
    {
      this.jdField_c_of_type_AndroidWidgetImageView.setContentDescription(getString(2131692138));
      if (!Utils.b(this.jdField_b_of_type_JavaLangString)) {
        this.j.setContentDescription(getString(2131718187));
      } else {
        this.j.setContentDescription(getString(2131718186));
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout.setFocusable(true);
      paramLayoutInflater = this.jdField_a_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout;
      paramViewGroup = new StringBuilder();
      paramViewGroup.append(getResources().getString(2131693375));
      paramViewGroup.append(this.jdField_b_of_type_AndroidWidgetEditText.getText().toString());
      paramLayoutInflater.setContentDescription(paramViewGroup.toString());
      this.jdField_b_of_type_AndroidWidgetEditText.setContentDescription(null);
      if (m == 0)
      {
        this.jdField_c_of_type_AndroidViewView.setFocusable(true);
        this.jdField_c_of_type_AndroidViewView.setContentDescription(getResources().getString(2131717421));
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(getActivity(), getQBaseActivity().getTitleBarHeight());
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(2131690785);
    paramLayoutInflater = getActivity().getIntent().getExtras().getString("nick_name");
    a(getString(2131689609));
    a(HardCodeUtil.a(2131700057), null);
    int i1 = getActivity().getIntent().getExtras().getInt("source_id", 3999);
    int i2 = getActivity().getIntent().getIntExtra("sub_source_id", 0);
    paramViewGroup = (IProfileProtocolService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IProfileProtocolService.class, "");
    if (EAddFriendSourceID.a(getActivity().getIntent().getIntExtra("sort_id", 0)))
    {
      paramBundle = this.jdField_b_of_type_JavaLangString;
      paramViewGroup.requestProfileCard(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), "0", 16, 0L, (byte)0, 0L, 0L, null, paramBundle, 0L, 10004, null, (byte)0);
    }
    else
    {
      paramViewGroup.requestProfileCard(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), this.jdField_b_of_type_JavaLangString, 12, 0L, (byte)0, 0L, 0L, null, "", 0L, 10004, null, (byte)0);
    }
    getQBaseActivity().addObserver(this.jdField_a_of_type_ComTencentMobileqqProfilecardObserverProfileCardObserver);
    getQBaseActivity().addObserver(this.jdField_a_of_type_ComTencentMobileqqFriendObserverFriendObserver);
    getQBaseActivity().addObserver(this.jdField_a_of_type_ComTencentQidianControllerQidianBusinessObserverExpose);
    int m = this.jdField_a_of_type_Int;
    if (m == 2)
    {
      this.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable(FaceDrawable.getFaceDrawable(this.jdField_a_of_type_ComTencentCommonAppAppInterface, 11, this.jdField_b_of_type_JavaLangString));
      paramBundle = this.g;
      if (TextUtils.isEmpty(paramLayoutInflater)) {
        paramViewGroup = this.jdField_b_of_type_JavaLangString;
      } else {
        paramViewGroup = paramLayoutInflater;
      }
      paramBundle.setText(paramViewGroup);
      if (AppSetting.d)
      {
        paramBundle = this.g;
        paramViewGroup = paramLayoutInflater;
        if (TextUtils.isEmpty(paramLayoutInflater)) {
          paramViewGroup = this.jdField_b_of_type_JavaLangString;
        }
        paramBundle.setContentDescription(paramViewGroup);
      }
    }
    else if (m == 3)
    {
      paramViewGroup = localIntent.getStringExtra("extra");
      paramViewGroup = URLDrawable.getDrawable(FaceDrawable.getOpenIdUrl(this.jdField_b_of_type_JavaLangString, paramViewGroup), URLDrawable.URLDrawableOptions.obtain());
      if (QQTheme.f()) {
        this.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable(paramViewGroup);
      } else {
        a(paramViewGroup);
      }
      this.g.setText(paramLayoutInflater);
      if (AppSetting.d) {
        this.g.setContentDescription(paramLayoutInflater);
      }
      ((IFriendHandlerService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IFriendHandlerService.class, "")).requestInfoWithOpenId(this.jdField_b_of_type_JavaLangString, getActivity().getIntent().getStringExtra("extra"));
    }
    else
    {
      if ((i1 != 3007) && (i1 != 2007) && (i1 != 4007) && (i1 != 3019) && (i1 != 2019)) {
        this.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable(FaceDrawable.getFaceDrawable(this.jdField_a_of_type_ComTencentCommonAppAppInterface, 1, this.jdField_b_of_type_JavaLangString));
      } else {
        this.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable(FaceDrawable.getStrangerFaceDrawable(this.jdField_a_of_type_ComTencentCommonAppAppInterface, 200, this.jdField_b_of_type_JavaLangString, true));
      }
      if (d())
      {
        if (paramLayoutInflater != null)
        {
          this.g.setText(paramLayoutInflater);
          if (AppSetting.d) {
            this.g.setContentDescription(paramLayoutInflater);
          }
        }
      }
      else {
        ThreadManager.getSubThreadHandler().post(new AddFriendVerifyFragment.2(this, paramLayoutInflater));
      }
    }
    int i3 = localIntent.getIntExtra("friend_setting", 0);
    Object localObject1 = getActivity().getIntent().getExtras().getStringArrayList("user_question");
    paramViewGroup = " subSourceId = ";
    paramBundle = "reportClickEvent action: 0X80077AF  sourceId = ";
    if (i3 != 0)
    {
      if (i3 == 1) {
        break label3084;
      }
      if (i3 != 2) {
        if (i3 != 3) {
          if (i3 != 4) {
            break label3663;
          }
        }
      }
    }
    for (;;)
    {
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      StringBuffer localStringBuffer = new StringBuffer();
      if ((localObject1 != null) && (((ArrayList)localObject1).size() == 1)) {
        m = 1;
      } else {
        m = 0;
      }
      int n = 0;
      while (n < ((ArrayList)localObject1).size())
      {
        if (n != 0)
        {
          if (n != 1)
          {
            if (n != 2)
            {
              if (n != 3)
              {
                if (n != 4) {
                  paramLayoutInflater = getResources().getString(2131716737);
                } else {
                  paramLayoutInflater = getResources().getString(2131716743);
                }
              }
              else {
                paramLayoutInflater = getResources().getString(2131716742);
              }
            }
            else {
              paramLayoutInflater = getResources().getString(2131716741);
            }
          }
          else {
            paramLayoutInflater = getResources().getString(2131716740);
          }
        }
        else if (m != 0) {
          paramLayoutInflater = getResources().getString(2131716738);
        } else {
          paramLayoutInflater = getResources().getString(2131716739);
        }
        Object localObject4 = getActivity().getWindow().getLayoutInflater().inflate(2131561582, this.jdField_b_of_type_AndroidWidgetLinearLayout, false);
        Object localObject3 = getActivity().getWindow().getLayoutInflater().inflate(2131561581, this.jdField_b_of_type_AndroidWidgetLinearLayout, false);
        if (n > 0)
        {
          localObject2 = (LinearLayout.LayoutParams)((View)localObject4).getLayoutParams();
          if (localObject2 != null)
          {
            ((LinearLayout.LayoutParams)localObject2).topMargin = ((int)DisplayUtils.a(getActivity().getApplication(), 19.0F));
            ((View)localObject4).setLayoutParams((ViewGroup.LayoutParams)localObject2);
          }
        }
        this.jdField_b_of_type_AndroidWidgetLinearLayout.addView((View)localObject4);
        this.jdField_b_of_type_AndroidWidgetLinearLayout.addView((View)localObject3);
        Object localObject2 = (String)((ArrayList)localObject1).get(n);
        localObject4 = (TextView)((View)localObject4).findViewById(2131378476);
        ((TextView)localObject4).setText(String.format("%s%s", new Object[] { paramLayoutInflater, localObject2 }));
        localObject3 = (EditText)((View)localObject3).findViewById(2131368891);
        ((EditText)localObject3).addTextChangedListener(new AddFriendVerifyFragment.MaxBytesTextWatcher(50, (EditText)localObject3));
        this.jdField_a_of_type_JavaUtilArrayList.add(localObject3);
        if (jdField_a_of_type_Boolean)
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append(paramLayoutInflater);
          ((StringBuilder)localObject3).append((String)localObject2);
          ((TextView)localObject4).setContentDescription(((StringBuilder)localObject3).toString());
          ((EditText)this.jdField_a_of_type_JavaUtilArrayList.get(n)).setContentDescription(getString(2131689612));
        }
        n += 1;
        paramLayoutInflater = new StringBuilder();
        paramLayoutInflater.append(getString(2131716737));
        paramLayoutInflater.append(n);
        paramLayoutInflater.append(":");
        paramLayoutInflater.append((String)localObject2);
        localStringBuffer.append(paramLayoutInflater.toString());
        localStringBuffer.append("\n");
        paramLayoutInflater = new StringBuilder();
        paramLayoutInflater.append(getString(2131690014));
        paramLayoutInflater.append(":${answer}");
        localStringBuffer.append(paramLayoutInflater.toString());
        if (n != ((ArrayList)localObject1).size()) {
          localStringBuffer.append("\n");
        }
      }
      b(2131690820, new AddFriendVerifyFragment.7(this, localStringBuffer, i1, i2, i3));
      a(2131376732).setOnTouchListener(new AddFriendVerifyFragment.8(this));
      getActivity().getWindow().setSoftInputMode(4);
      paramLayoutInflater = (RelativeLayout.LayoutParams)this.jdField_c_of_type_AndroidWidgetLinearLayout.getLayoutParams();
      paramLayoutInflater.addRule(3, this.jdField_b_of_type_AndroidWidgetLinearLayout.getId());
      paramLayoutInflater.topMargin = ImmersiveUtils.dpToPx(20.0F);
      this.jdField_c_of_type_AndroidWidgetLinearLayout.setLayoutParams(paramLayoutInflater);
      ReportController.b(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "dc00898", "", "", "0X80077AF", "0X80077AF", 4, 0, String.valueOf(i1), String.valueOf(i2), "", "");
      if (QLog.isColorLevel())
      {
        paramLayoutInflater = new StringBuilder();
        paramLayoutInflater.append(paramBundle);
        paramLayoutInflater.append(i1);
        paramLayoutInflater.append(paramViewGroup);
        paramLayoutInflater.append(i2);
        QLog.d("IphoneTitleBarFragment", 2, paramLayoutInflater.toString());
        continue;
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        paramLayoutInflater = (String)((ArrayList)localObject1).get(0);
        paramViewGroup = (TextView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131378476);
        paramBundle = (EditText)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131368891);
        this.jdField_b_of_type_ComTencentMobileqqAddfriendUiAddFriendVerifyFragment$MaxBytesTextWatcher = new AddFriendVerifyFragment.MaxBytesTextWatcher(50, paramBundle);
        paramBundle.addTextChangedListener(this.jdField_b_of_type_ComTencentMobileqqAddfriendUiAddFriendVerifyFragment$MaxBytesTextWatcher);
        paramViewGroup.setText(String.format("%s:%s", new Object[] { getString(2131716737), paramLayoutInflater }));
        paramBundle.setSingleLine(true);
        if (jdField_a_of_type_Boolean)
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(getString(2131716737));
          ((StringBuilder)localObject1).append(":");
          ((StringBuilder)localObject1).append(paramLayoutInflater);
          paramViewGroup.setContentDescription(((StringBuilder)localObject1).toString());
          paramBundle.setContentDescription(getString(2131689612));
        }
        b(2131690820, new AddFriendVerifyFragment.6(this, paramBundle, i3, i1, i2));
        getActivity().getWindow().setSoftInputMode(5);
        paramLayoutInflater = (RelativeLayout.LayoutParams)this.jdField_c_of_type_AndroidWidgetLinearLayout.getLayoutParams();
        paramLayoutInflater.addRule(3, this.jdField_a_of_type_AndroidWidgetLinearLayout.getId());
        paramLayoutInflater.topMargin = ImmersiveUtils.dpToPx(20.0F);
        this.jdField_c_of_type_AndroidWidgetLinearLayout.setLayoutParams(paramLayoutInflater);
        ReportController.b(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "dc00898", "", "", "0X80077AF", "0X80077AF", 3, 0, String.valueOf(i1), String.valueOf(i2), "", "");
        if (QLog.isColorLevel())
        {
          paramLayoutInflater = new StringBuilder();
          paramLayoutInflater.append("reportClickEvent action: 0X80077AF  sourceId = ");
          paramLayoutInflater.append(i1);
          paramLayoutInflater.append(" subSourceId = ");
          paramLayoutInflater.append(i2);
          QLog.d("IphoneTitleBarFragment", 2, paramLayoutInflater.toString());
          continue;
          break label3291;
          label3084:
          this.jdField_a_of_type_AndroidWidgetEditText.setVisibility(0);
          this.h.setVisibility(0);
          if (AppSetting.d)
          {
            paramLayoutInflater = this.jdField_a_of_type_AndroidWidgetEditText;
            paramLayoutInflater.setContentDescription(paramLayoutInflater.getText().toString());
            this.h.setContentDescription(getString(2131689615));
          }
          b(2131690820, new AddFriendVerifyFragment.5(this, i1, i2, i3));
          paramLayoutInflater = (RelativeLayout.LayoutParams)this.jdField_c_of_type_AndroidWidgetLinearLayout.getLayoutParams();
          paramLayoutInflater.addRule(3, this.jdField_a_of_type_AndroidWidgetEditText.getId());
          paramLayoutInflater.topMargin = ImmersiveUtils.dpToPx(20.0F);
          this.jdField_c_of_type_AndroidWidgetLinearLayout.setLayoutParams(paramLayoutInflater);
          ReportController.b(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "dc00898", "", "", "0X80077AF", "0X80077AF", 1, 0, String.valueOf(i1), String.valueOf(i2), "", "");
          if (QLog.isColorLevel())
          {
            paramLayoutInflater = new StringBuilder();
            paramLayoutInflater.append("reportClickEvent action: 0X80077AF  sourceId = ");
            paramLayoutInflater.append(i1);
            paramLayoutInflater.append(" subSourceId = ");
            paramLayoutInflater.append(i2);
            QLog.d("IphoneTitleBarFragment", 2, paramLayoutInflater.toString());
            continue;
            label3291:
            if ((i1 == 3078) || (i1 == 3079)) {
              break;
            }
            b(2131690820, new AddFriendVerifyFragment.4(this, i1, i2));
            paramLayoutInflater = (RelativeLayout.LayoutParams)this.jdField_c_of_type_AndroidWidgetLinearLayout.getLayoutParams();
            paramLayoutInflater.addRule(3, this.jdField_c_of_type_AndroidWidgetImageView.getId());
            paramLayoutInflater.topMargin = ImmersiveUtils.dpToPx(20.0F);
            this.jdField_c_of_type_AndroidWidgetLinearLayout.setLayoutParams(paramLayoutInflater);
            ReportController.b(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "dc00898", "", "", "0X80077AF", "0X80077AF", 2, 0, String.valueOf(i1), String.valueOf(i2), "", "");
            if (QLog.isColorLevel())
            {
              paramLayoutInflater = new StringBuilder();
              paramLayoutInflater.append("reportClickEvent action: 0X80077AF  sourceId = ");
              paramLayoutInflater.append(i1);
              paramLayoutInflater.append(" subSourceId = ");
              paramLayoutInflater.append(i2);
              QLog.d("IphoneTitleBarFragment", 2, paramLayoutInflater.toString());
            }
            a(i1, i3);
          }
        }
      }
    }
    this.jdField_a_of_type_AndroidWidgetEditText.setVisibility(0);
    this.h.setVisibility(0);
    this.h.setText(getString(2131689597));
    this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
    this.g.setVisibility(8);
    this.i.setVisibility(8);
    if (AppSetting.d)
    {
      paramLayoutInflater = this.jdField_a_of_type_AndroidWidgetEditText;
      paramLayoutInflater.setContentDescription(paramLayoutInflater.getText().toString());
      this.h.setContentDescription(getString(2131689615));
    }
    this.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    if (getActivity().getIntent() != null) {
      m = getActivity().getIntent().getIntExtra("contact_from_type", 1);
    } else {
      m = 1;
    }
    b(2131690820, new AddFriendVerifyFragment.3(this, m));
    paramLayoutInflater = (RelativeLayout.LayoutParams)this.jdField_c_of_type_AndroidWidgetLinearLayout.getLayoutParams();
    paramLayoutInflater.addRule(3, this.jdField_a_of_type_AndroidWidgetEditText.getId());
    paramLayoutInflater.topMargin = ImmersiveUtils.dpToPx(20.0F);
    this.jdField_c_of_type_AndroidWidgetLinearLayout.setLayoutParams(paramLayoutInflater);
    label3663:
    if (this.jdField_a_of_type_Int == 3)
    {
      paramLayoutInflater = localIntent.getStringExtra("is_from_game");
      paramViewGroup = localIntent.getStringExtra("extra");
      try
      {
        boolean bool = ((IAddFriendTempApi)QRoute.api(IAddFriendTempApi.class)).enableCheckPermission();
        if ((("true".equals(paramLayoutInflater)) || (bool)) && (!TextUtils.isEmpty(paramViewGroup)))
        {
          AddFriendUtil.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, getActivity().getApplicationContext(), paramViewGroup, this, 1003, null);
          if (QLog.isColorLevel())
          {
            paramBundle = new StringBuilder();
            paramBundle.append("AddFriend enableCheckPermission = ");
            paramBundle.append(bool);
            QLog.d("IphoneTitleBarFragment", 2, paramBundle.toString());
          }
        }
      }
      catch (Exception paramBundle)
      {
        if (("true".equals(paramLayoutInflater)) && (!TextUtils.isEmpty(paramViewGroup))) {
          AddFriendUtil.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, getActivity().getApplicationContext(), paramViewGroup, this, 1003, null);
        }
        paramLayoutInflater = new StringBuilder();
        paramLayoutInflater.append("AddFriend loadConfig exception = ");
        paramLayoutInflater.append(paramBundle);
        QLog.d("IphoneTitleBarFragment", 1, paramLayoutInflater.toString());
      }
      this.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    }
    b(true);
    if (((IAddFriendTempApi)QRoute.api(IAddFriendTempApi.class)).isQidianMaster(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_b_of_type_JavaLangString)) {
      this.i.setVisibility(8);
    }
    this.jdField_a_of_type_JavaLangString = getActivity().getIntent().getStringExtra("webImVisitId");
  }
  
  void a(String paramString)
  {
    if (c()) {
      return;
    }
    if (!NetworkUtil.isNetSupport(getActivity()))
    {
      QQToast.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp(), 1, getString(2131718220), 0).b(getQBaseActivity().getTitleBarHeight());
      return;
    }
    if (getActivity().getIntent().hasExtra("contacts"))
    {
      ArrayList localArrayList = (ArrayList)getActivity().getIntent().getSerializableExtra("contacts");
      if ((localArrayList != null) && (localArrayList.size() > 0))
      {
        if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null)
        {
          this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(getActivity(), getQBaseActivity().getTitleBarHeight());
          this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.setOnDismissListener(new AddFriendVerifyFragment.11(this));
        }
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.setCancelable(true);
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.setCanceledOnTouchOutside(false);
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(2131718766);
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
        this.jdField_b_of_type_JavaUtilArrayList.clear();
        this.jdField_b_of_type_JavaUtilArrayList.addAll(localArrayList);
        ((IFriendHandlerService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IFriendHandlerService.class, "")).requestAddBatchPhoneFriend(this.jdField_b_of_type_JavaUtilArrayList, paramString, 0, this.jdField_c_of_type_Int, new ArrayList());
      }
    }
  }
  
  void a(String paramString, boolean paramBoolean)
  {
    if (getActivity() == null) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDataKplRoleInfo$WZRYUIinfo != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("IphoneTitleBarFragment", 2, "saveVerifyMsg return from wzry");
      }
      return;
    }
    Object localObject = getActivity().getSharedPreferences("last_verify_msg", 0);
    if (paramBoolean)
    {
      localObject = ((SharedPreferences)localObject).edit();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("last_add_troop_verfity_");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getAccount());
      ((SharedPreferences.Editor)localObject).putString(localStringBuilder.toString(), paramString).commit();
      return;
    }
    localObject = ((SharedPreferences)localObject).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("last_add_friend_verify_");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getAccount());
    ((SharedPreferences.Editor)localObject).putString(localStringBuilder.toString(), paramString).commit();
  }
  
  void a(String paramString1, byte[] paramArrayOfByte, String paramString2)
  {
    if (c()) {
      return;
    }
    if (!NetworkUtil.isNetSupport(getActivity()))
    {
      QQToast.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp(), 1, getString(2131694475), 0).b(getQBaseActivity().getTitleBarHeight());
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(getActivity(), getQBaseActivity().getTitleBarHeight());
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.setOnDismissListener(new AddFriendVerifyFragment.10(this));
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(2131718766);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.setCancelable(true);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.setCanceledOnTouchOutside(false);
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("IphoneTitleBarFragment", 2, localException.toString());
      }
    }
    Intent localIntent = getActivity().getIntent();
    int n = localIntent.getIntExtra("sub_source_id", 0);
    int m = localIntent.getIntExtra("friend_setting", 0);
    if (m == 3) {
      m = 100;
    }
    boolean bool = localIntent.getBooleanExtra("contact_bothway", false);
    String str = localIntent.getStringExtra("src_name");
    ((IFriendHandlerService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IFriendHandlerService.class, "")).requestAddFriendWithMyCard(this.jdField_b_of_type_JavaLangString, localIntent.getStringExtra("extra"), m, (byte)this.jdField_b_of_type_Int, paramString1, this.jdField_c_of_type_Int, n, true, paramArrayOfByte, bool, this.jdField_b_of_type_AndroidWidgetEditText.getText().toString(), str, localIntent.getByteExtra("show_my_card", (byte)0), paramString2, localIntent.getBundleExtra("flc_extra_param"), true);
    if (!AddFriendUtil.a(m, this.jdField_c_of_type_Int, bool)) {
      ((IAddFriendServiceApi)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IAddFriendServiceApi.class, "")).setAddFriendReqStatus(this.jdField_b_of_type_JavaLangString, true);
    }
    if (!this.jdField_b_of_type_AndroidWidgetEditText.getText().toString().equals(this.jdField_c_of_type_JavaLangString)) {
      ReportController.b(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "dc00898", "", "", "0X80077B1", "0X80077B1", 0, 0, "", "", "", "");
    }
    if (localIntent.getIntExtra("sort_id", 0) == 3090) {
      ReportController.b(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "CliOper", "", "", "0x80084AE", "0x80084AE", 0, 0, "", "", "", "");
    }
    if ((this.jdField_c_of_type_Int == 3050) && (this.jdField_d_of_type_Int == 3))
    {
      if ((this.jdField_b_of_type_ComTencentWidgetSwitch != null) && (this.jdField_c_of_type_Boolean))
      {
        ((IAddFriendTempApi)QRoute.api(IAddFriendTempApi.class)).followUser(this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_Boolean);
        paramString1 = new HashMap();
        paramString1.put("ext3", "1");
        ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504(this.jdField_b_of_type_JavaLangString, 79, 2, 0, paramString1, null, null);
      }
      else
      {
        paramString1 = new HashMap();
        paramString1.put("ext3", "2");
        ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504(this.jdField_b_of_type_JavaLangString, 79, 2, 0, paramString1, null, null);
      }
      if ((localIntent.getBooleanExtra("key_qcircle_stick", false)) && (TextUtils.isEmpty(paramString2))) {
        ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504(this.jdField_b_of_type_JavaLangString, 93, 2, 2);
      }
    }
    paramString1 = this.jdField_c_of_type_JavaUtilArrayList.iterator();
    while (paramString1.hasNext()) {
      ((BaseAddFriendProcessor)paramString1.next()).a(this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_Int, n, this.e);
    }
  }
  
  public void a(JSONObject paramJSONObject, int paramInt, Bundle paramBundle)
  {
    if ((paramInt == 1003) && (paramJSONObject != null)) {}
    for (;;)
    {
      try
      {
        paramInt = ((Integer)paramJSONObject.get("retcode")).intValue();
        Object localObject5 = (JSONObject)paramJSONObject.get("result");
        if ((paramInt == 0) && (localObject5 != null))
        {
          boolean bool = QLog.isColorLevel();
          if (bool)
          {
            paramJSONObject = new StringBuilder();
            paramJSONObject.append("checkApiState onResult. retCode = ");
            paramJSONObject.append(paramInt);
            paramJSONObject.append("\n");
            QLog.i("IphoneTitleBarFragment", 2, paramJSONObject.toString());
          }
          Object localObject1 = (JSONObject)((JSONObject)localObject5).get("basics");
          paramJSONObject = "msg";
          Object localObject3 = "api";
          paramBundle = paramJSONObject;
          Object localObject4;
          int m;
          StringBuilder localStringBuilder;
          if (localObject1 != null)
          {
            localObject1 = (JSONArray)((JSONObject)localObject1).get("datas");
            paramBundle = paramJSONObject;
            if (localObject1 != null)
            {
              paramInt = 0;
              paramBundle = paramJSONObject;
              if (paramInt < ((JSONArray)localObject1).length())
              {
                localObject4 = (JSONObject)((JSONArray)localObject1).get(paramInt);
                paramBundle = (String)((JSONObject)localObject4).get("name");
                m = ((Integer)((JSONObject)localObject4).get("state")).intValue();
                localObject2 = (String)((JSONObject)localObject4).get("api");
                localObject4 = (String)((JSONObject)localObject4).get(paramJSONObject);
                if (!QLog.isColorLevel()) {
                  break label923;
                }
                localStringBuilder = new StringBuilder();
                localStringBuilder.append("checkApiState onResult, basics name = ");
                localStringBuilder.append(paramBundle);
                localStringBuilder.append(" state = ");
                localStringBuilder.append(m);
                localStringBuilder.append(" api = ");
                localStringBuilder.append((String)localObject2);
                localStringBuilder.append(" msg = ");
                localStringBuilder.append((String)localObject4);
                localStringBuilder.append("\n");
                QLog.i("IphoneTitleBarFragment", 2, localStringBuilder.toString());
                break label923;
              }
            }
          }
          localObject1 = (JSONObject)((JSONObject)localObject5).get("friendlink");
          Object localObject2 = localObject3;
          paramJSONObject = paramBundle;
          if (localObject1 != null)
          {
            localObject4 = (JSONArray)((JSONObject)localObject1).get("datas");
            localObject2 = localObject3;
            paramJSONObject = paramBundle;
            if (localObject4 != null)
            {
              paramInt = 0;
              localObject1 = paramBundle;
              paramBundle = (Bundle)localObject3;
              localObject3 = localObject4;
              localObject2 = paramBundle;
              paramJSONObject = (JSONObject)localObject1;
              if (paramInt < ((JSONArray)localObject3).length())
              {
                localObject4 = (JSONObject)((JSONArray)localObject3).get(paramInt);
                paramJSONObject = (String)((JSONObject)localObject4).get("name");
                m = ((Integer)((JSONObject)localObject4).get("state")).intValue();
                localObject2 = (String)((JSONObject)localObject4).get(paramBundle);
                localObject4 = (String)((JSONObject)localObject4).get((String)localObject1);
                if (("add_friend".equals(localObject2)) && (m != 1)) {
                  f();
                }
                if (!QLog.isColorLevel()) {
                  break label930;
                }
                localStringBuilder = new StringBuilder();
                localStringBuilder.append("checkApiState onResult, friendlink name = ");
                localStringBuilder.append(paramJSONObject);
                localStringBuilder.append(" state = ");
                localStringBuilder.append(m);
                localStringBuilder.append(" api = ");
                localStringBuilder.append((String)localObject2);
                localStringBuilder.append(" msg= ");
                localStringBuilder.append((String)localObject4);
                localStringBuilder.append("\n");
                QLog.i("IphoneTitleBarFragment", 2, localStringBuilder.toString());
                break label930;
              }
            }
          }
          paramBundle = (Bundle)localObject2;
          paramInt = ((Integer)((JSONObject)localObject5).get("appid")).intValue();
          if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("checkApiState onResult, appid =");
            ((StringBuilder)localObject1).append(paramInt);
            ((StringBuilder)localObject1).append("\n");
            QLog.i("IphoneTitleBarFragment", 2, ((StringBuilder)localObject1).toString());
          }
          localObject1 = (JSONObject)((JSONObject)localObject5).get("qqpay");
          if (localObject1 != null)
          {
            localObject1 = (JSONArray)((JSONObject)localObject1).get("datas");
            if (localObject1 != null)
            {
              paramInt = 0;
              if (paramInt < ((JSONArray)localObject1).length())
              {
                localObject4 = (JSONObject)((JSONArray)localObject1).get(paramInt);
                localObject2 = (String)((JSONObject)localObject4).get("name");
                m = ((Integer)((JSONObject)localObject4).get("state")).intValue();
                localObject3 = (String)((JSONObject)localObject4).get(paramBundle);
                localObject4 = (String)((JSONObject)localObject4).get(paramJSONObject);
                if (QLog.isColorLevel())
                {
                  localObject5 = new StringBuilder();
                  ((StringBuilder)localObject5).append("checkApiState onResult, qqpay name = ");
                  ((StringBuilder)localObject5).append((String)localObject2);
                  ((StringBuilder)localObject5).append(" state = ");
                  ((StringBuilder)localObject5).append(m);
                  ((StringBuilder)localObject5).append(" api = ");
                  ((StringBuilder)localObject5).append((String)localObject3);
                  ((StringBuilder)localObject5).append(" msg= ");
                  ((StringBuilder)localObject5).append((String)localObject4);
                  ((StringBuilder)localObject5).append("\n");
                  QLog.i("IphoneTitleBarFragment", 2, ((StringBuilder)localObject5).toString());
                }
                paramInt += 1;
                continue;
              }
            }
          }
        }
        return;
      }
      catch (Exception paramJSONObject)
      {
        if (QLog.isColorLevel())
        {
          paramBundle = new StringBuilder();
          paramBundle.append("checkApiState onResult ");
          paramBundle.append(paramJSONObject.toString());
          QLog.d("IphoneTitleBarFragment", 2, paramBundle.toString());
        }
      }
      label923:
      paramInt += 1;
      continue;
      label930:
      paramInt += 1;
    }
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    paramEditable = this.jdField_b_of_type_AndroidWidgetEditText.getText().toString();
    if (AddFriendUtil.a(paramEditable) > 32)
    {
      int m = this.jdField_b_of_type_AndroidWidgetEditText.getSelectionStart();
      paramEditable = AddFriendUtil.a(paramEditable);
      this.jdField_b_of_type_AndroidWidgetEditText.setText(paramEditable);
      if (m >= paramEditable.length()) {
        this.jdField_b_of_type_AndroidWidgetEditText.setSelection(paramEditable.length());
      }
    }
    if (AppSetting.d)
    {
      paramEditable = this.jdField_a_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(getResources().getString(2131693375));
      localStringBuilder.append(this.jdField_b_of_type_AndroidWidgetEditText.getText().toString());
      paramEditable.setContentDescription(localStringBuilder.toString());
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    paramActivity.overridePendingTransition(2130771993, 2130771994);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    boolean bool1 = QLog.isColorLevel();
    boolean bool2 = false;
    Object localObject;
    if (bool1)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("doOnActivityResult, requestCode=");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(",resultCode=");
      ((StringBuilder)localObject).append(paramInt2);
      ((StringBuilder)localObject).append(",data=");
      if (paramIntent == null) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      ((StringBuilder)localObject).append(bool1);
      QLog.d("IphoneTitleBarFragment", 2, ((StringBuilder)localObject).toString());
    }
    if (c()) {
      return;
    }
    if ((paramInt1 == 0) && (paramInt2 == -1))
    {
      getActivity().setResult(paramInt2, paramIntent);
      getActivity().finish();
    }
    if (paramInt1 != 1002)
    {
      if (paramInt1 != 1004) {
        return;
      }
      if (paramIntent != null)
      {
        paramIntent = paramIntent.getStringExtra("ticket");
        localObject = this.jdField_a_of_type_AndroidOsBundle;
        if (localObject != null)
        {
          a(((Bundle)localObject).getString("msg", ""), this.jdField_a_of_type_AndroidOsBundle.getByteArray("sig"), paramIntent);
          bool1 = true;
        }
        else
        {
          paramIntent = this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
          if (paramIntent != null)
          {
            paramIntent.cancel();
            this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
          }
          b(getString(2131718220));
          g();
          bool1 = bool2;
        }
      }
      else
      {
        paramIntent = this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
        if (paramIntent != null)
        {
          paramIntent.cancel();
          this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
        }
        b(getString(2131718220));
        g();
        bool1 = bool2;
      }
      if (QLog.isColorLevel())
      {
        paramIntent = new StringBuilder();
        paramIntent.append("REQUEST_CODE_SECCHECK_H5_PAGE, isSuccess=");
        paramIntent.append(bool1);
        QLog.d("IphoneTitleBarFragment", 2, paramIntent.toString());
      }
    }
    else if (paramIntent != null)
    {
      paramInt1 = paramIntent.getByteExtra("result", (byte)0);
      this.jdField_b_of_type_Int = paramInt1;
      this.k.setText(((IAddFriendApi)QRoute.api(IAddFriendApi.class)).getGroupName(this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramInt1));
      paramIntent = this.jdField_b_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(HardCodeUtil.a(2131700086));
      ((StringBuilder)localObject).append(((IAddFriendApi)QRoute.api(IAddFriendApi.class)).getGroupName(this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramInt1));
      paramIntent.setContentDescription(((StringBuilder)localObject).toString());
    }
  }
  
  public boolean onBackEvent()
  {
    if (getActivity() == null) {
      return super.onBackEvent();
    }
    g();
    Object localObject = getActivity().getIntent();
    boolean bool = false;
    if (((Intent)localObject).getBooleanExtra("need_jumpto_splash", false))
    {
      ((IAddFriendTempApi)QRoute.api(IAddFriendTempApi.class)).jumpToSplash(getActivity());
      return super.onBackEvent();
    }
    if (this.jdField_a_of_type_Int != 4)
    {
      localObject = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
      if (4 == this.jdField_a_of_type_Int) {
        bool = true;
      }
      a((String)localObject, bool);
      if ((getString(2131691954).equals(localObject)) && (!b())) {
        d();
      }
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      ReportController.b(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "dc00899", "Qidian", this.jdField_b_of_type_JavaLangString, "0X8008802", "ClickAddFriendButton", 0, 0, "2", "", "", "");
    }
    return super.onBackEvent();
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (!c())
    {
      Switch localSwitch;
      if (!NetworkUtil.isNetSupport(getActivity()))
      {
        QQToast.a(getActivity(), 1, 2131694424, 0).b(getQBaseActivity().getTitleBarHeight());
        localSwitch = this.jdField_a_of_type_ComTencentWidgetSwitch;
        if (localSwitch != null)
        {
          localSwitch.setChecked(paramBoolean ^ true);
          this.jdField_a_of_type_ComTencentWidgetSwitch.setOnClickListener(null);
        }
        localSwitch = this.jdField_b_of_type_ComTencentWidgetSwitch;
        if (localSwitch != null)
        {
          localSwitch.setChecked(paramBoolean ^ true);
          this.jdField_b_of_type_ComTencentWidgetSwitch.setOnClickListener(null);
        }
      }
      else
      {
        localSwitch = this.jdField_a_of_type_ComTencentWidgetSwitch;
        if (localSwitch != null) {
          localSwitch.setOnClickListener(this);
        }
        localSwitch = this.jdField_b_of_type_ComTencentWidgetSwitch;
        if (localSwitch != null) {
          localSwitch.setOnClickListener(this);
        }
        if (paramCompoundButton == this.jdField_a_of_type_ComTencentWidgetSwitch)
        {
          if (AppSetting.d) {
            this.jdField_c_of_type_AndroidViewView.setContentDescription(getResources().getString(2131717421));
          }
          ((IAddFriendTempApi)QRoute.api(IAddFriendTempApi.class)).launchPluginBroadcastWhenToggleSwitch(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramBoolean);
          ReportController.b(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "dc00898", "", "", "0X80077B3", "0X80077B3", 0, 0, "", "", "", "");
        }
        else if (paramCompoundButton == this.jdField_b_of_type_ComTencentWidgetSwitch)
        {
          this.jdField_c_of_type_Boolean = paramBoolean;
        }
      }
    }
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
  
  public void onClick(View paramView)
  {
    if ((paramView.getId() == 2131376688) && (!c()))
    {
      ((IAddFriendTempApi)QRoute.api(IAddFriendTempApi.class)).jumpToMoveGroup(getActivity(), this, this.jdField_b_of_type_JavaLangString, this.jdField_b_of_type_Int, 1002);
      EditText localEditText = this.jdField_a_of_type_AndroidWidgetEditText;
      if (localEditText != null) {
        a(localEditText.getText().toString(), false);
      }
      ReportController.b(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "dc00898", "", "", "0X80077B2", "0X80077B2", 0, 0, "", "", "", "");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    e();
    if (getActivity() == null) {
      return;
    }
    if (Build.VERSION.SDK_INT >= 16)
    {
      getActivity().getWindow().getDecorView().getViewTreeObserver().removeOnGlobalLayoutListener(this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener);
      return;
    }
    getActivity().getWindow().getDecorView().getViewTreeObserver().removeGlobalOnLayoutListener(this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener);
  }
  
  public void onFinish()
  {
    super.onFinish();
    if (getActivity() == null) {
      return;
    }
    ((InputMethodManager)getActivity().getSystemService("input_method")).hideSoftInputFromWindow(this.jdField_a_of_type_AndroidWidgetTextView.getWindowToken(), 0);
    getActivity().getWindow().setSoftInputMode(2);
    if (this.jdField_a_of_type_Int != 4) {
      getActivity().overridePendingTransition(0, 2130772015);
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if (c()) {
      return;
    }
    Object localObject1;
    int n;
    String str;
    Object localObject2;
    Object localObject3;
    if (this.jdField_a_of_type_Int != 4)
    {
      localObject1 = getActivity().getIntent();
      n = 0;
      int i1 = 0;
      m = ((Intent)localObject1).getIntExtra("friend_setting", 0);
      if (m != 0)
      {
        if (m != 1) {
          return;
        }
        str = getString(2131691954);
        if (getActivity().getIntent().getBooleanExtra("_FROM_QLINK_", false))
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(str);
          ((StringBuilder)localObject1).append(getString(2131698401));
          ((StringBuilder)localObject1).append(" ");
          localObject2 = this.jdField_a_of_type_ComTencentCommonAppAppInterface;
          ((StringBuilder)localObject1).append(AddFriendUtil.a((AppInterface)localObject2, ((AppInterface)localObject2).getAccount()));
          localObject2 = ((StringBuilder)localObject1).toString();
          this.jdField_a_of_type_AndroidWidgetEditText.setHint((CharSequence)localObject2);
        }
        else
        {
          this.jdField_a_of_type_AndroidWidgetEditText.setHint("");
          localObject2 = str;
        }
        this.jdField_a_of_type_AndroidWidgetEditText.setVisibility(0);
        this.h.setVisibility(0);
        if (AppSetting.d)
        {
          localObject1 = this.jdField_a_of_type_AndroidWidgetEditText;
          ((EditText)localObject1).setContentDescription(((EditText)localObject1).getText().toString());
          this.h.setContentDescription(getString(2131689615));
        }
        localObject1 = null;
        if (this.jdField_a_of_type_Int == 3)
        {
          localObject1 = getActivity().getIntent().getStringExtra("msg");
        }
        else
        {
          localObject3 = this.jdField_a_of_type_ComTencentMobileqqDataKplRoleInfo$WZRYUIinfo;
          if (localObject3 != null)
          {
            localObject3 = ((KplRoleInfo.WZRYUIinfo)localObject3).verifyMsg;
            localObject1 = localObject3;
            if (!TextUtils.isEmpty((CharSequence)localObject3))
            {
              m = 0;
              localObject1 = localObject3;
              break label297;
            }
          }
        }
        m = 1;
        label297:
        localObject3 = localObject1;
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          localObject3 = a(false);
        }
        if (!TextUtils.isEmpty((CharSequence)localObject3)) {
          localObject2 = localObject3;
        }
        n = i1;
        localObject1 = localObject2;
        if (m != 0)
        {
          n = i1;
          localObject1 = localObject2;
          if (str.equals(localObject2))
          {
            n = i1;
            localObject1 = localObject2;
            if (!b())
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append((String)localObject2);
              localObject2 = this.jdField_a_of_type_ComTencentCommonAppAppInterface;
              ((StringBuilder)localObject1).append(AddFriendUtil.a((AppInterface)localObject2, ((AppInterface)localObject2).getAccount()));
              localObject1 = ((StringBuilder)localObject1).toString();
              n = 1;
            }
          }
        }
        this.jdField_a_of_type_AndroidWidgetEditText.setText((CharSequence)localObject1);
        if (n == 0) {}
      }
    }
    label650:
    try
    {
      this.jdField_a_of_type_AndroidWidgetEditText.setSelection(str.length(), ((String)localObject1).length());
    }
    catch (Throwable localThrowable1)
    {
      label463:
      break label463;
    }
    this.jdField_a_of_type_AndroidWidgetEditText.setSelection(((String)localObject1).length());
    getActivity().getWindow().setSoftInputMode(5);
    return;
    int m = this.jdField_c_of_type_Int;
    if ((m == 3078) || (m == 3079))
    {
      localObject3 = a(false);
      localObject2 = getString(2131691954);
      localObject1 = localObject3;
      m = n;
      if (TextUtils.isEmpty((CharSequence)localObject3)) {
        if (!b())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append((String)localObject2);
          localObject3 = this.jdField_a_of_type_ComTencentCommonAppAppInterface;
          ((StringBuilder)localObject1).append(AddFriendUtil.a((AppInterface)localObject3, ((AppInterface)localObject3).getAccount()));
          localObject1 = ((StringBuilder)localObject1).toString();
          m = 1;
        }
        else
        {
          localObject1 = localObject2;
          m = n;
        }
      }
      this.jdField_a_of_type_AndroidWidgetEditText.setHint("");
      this.jdField_a_of_type_AndroidWidgetEditText.setText((CharSequence)localObject1);
      if (m == 0) {}
    }
    try
    {
      this.jdField_a_of_type_AndroidWidgetEditText.setSelection(((String)localObject2).length(), ((String)localObject1).length());
    }
    catch (Throwable localThrowable2)
    {
      break label650;
    }
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {
      this.jdField_a_of_type_AndroidWidgetEditText.setSelection(((String)localObject1).length());
    }
    getActivity().getWindow().setSoftInputMode(5);
  }
  
  public void onStart()
  {
    super.onStart();
    if (getActivity() == null) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFriendObserverFriendObserver != null) {
      getQBaseActivity().addObserver(this.jdField_a_of_type_ComTencentMobileqqFriendObserverFriendObserver);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqProfilecardObserverProfileCardObserver != null) {
      getQBaseActivity().addObserver(this.jdField_a_of_type_ComTencentMobileqqProfilecardObserverProfileCardObserver);
    }
    if (this.jdField_a_of_type_ComTencentQidianControllerQidianBusinessObserverExpose != null) {
      getQBaseActivity().addObserver(this.jdField_a_of_type_ComTencentQidianControllerQidianBusinessObserverExpose);
    }
  }
  
  public void onStop()
  {
    super.onStop();
    if (this.jdField_a_of_type_ComTencentMobileqqFriendObserverFriendObserver != null) {
      getQBaseActivity().removeObserver(this.jdField_a_of_type_ComTencentMobileqqFriendObserverFriendObserver);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqProfilecardObserverProfileCardObserver != null) {
      getQBaseActivity().removeObserver(this.jdField_a_of_type_ComTencentMobileqqProfilecardObserverProfileCardObserver);
    }
    if (this.jdField_a_of_type_ComTencentQidianControllerQidianBusinessObserverExpose != null) {
      getQBaseActivity().removeObserver(this.jdField_a_of_type_ComTencentQidianControllerQidianBusinessObserverExpose);
    }
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramView.getId() == 2131368891)
    {
      int m = paramMotionEvent.getAction() & 0xFF;
      if (m != 0)
      {
        if ((m != 1) && (m != 3)) {
          return false;
        }
        paramView.getParent().requestDisallowInterceptTouchEvent(false);
        return false;
      }
      paramView.getParent().requestDisallowInterceptTouchEvent(true);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.addfriend.ui.AddFriendVerifyFragment
 * JD-Core Version:    0.7.0.1
 */