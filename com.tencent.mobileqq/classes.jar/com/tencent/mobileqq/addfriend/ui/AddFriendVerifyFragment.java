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
import com.tencent.mobileqq.qcircle.api.constant.QCircleLpReportDc05504DataBuilder;
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
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.widget.Switch;
import com.tencent.widget.immersive.ImmersiveUtils;
import friendlist.EAddFriendSourceID;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONObject;

public class AddFriendVerifyFragment
  extends QIphoneTitleBarFragment
  implements TextWatcher, View.OnClickListener, View.OnTouchListener, CompoundButton.OnCheckedChangeListener, HttpWebCgiAsyncTask.Callback
{
  public static final boolean a = AppSetting.e;
  private String A = "";
  private int B;
  private int C;
  private int D = -1;
  private Bundle E;
  private ArrayList<EditText> F = new ArrayList();
  private ArrayList<PhoneContact> G = new ArrayList();
  private boolean H = true;
  private View I;
  private View J;
  private Switch K;
  private Switch L;
  private TextView M;
  private TextView N;
  private TextView O;
  private TextView P;
  private TextView Q = null;
  private EditText R;
  private EditText S = null;
  private ImageView T = null;
  private Dialog U;
  private QQProgressDialog V;
  private BounceScrollView W;
  private LinearLayout X;
  private LinearLayout Y;
  private LinearLayout Z;
  private FormItemRelativeLayout aa = null;
  private FormItemRelativeLayout ab = null;
  private InjectHelper ac;
  private ArrayList<BaseAddFriendProcessor> ad;
  private ViewTreeObserver.OnGlobalLayoutListener ae = new AddFriendVerifyFragment.19(this);
  private ProfileCardObserver af = new AddFriendVerifyFragment.20(this);
  private final FriendObserver ag = new AddFriendVerifyFragment.21(this);
  private QidianBusinessObserverExpose ah = new AddFriendVerifyFragment.22(this);
  String b = "";
  AddFriendVerifyFragment.MaxBytesTextWatcher c;
  AddFriendVerifyFragment.MaxBytesTextWatcher d;
  KplRoleInfo.WZRYUIinfo e;
  protected InputMethodManager f = null;
  protected QQCustomDialog g = null;
  private AppInterface w;
  private String x;
  private int y;
  private int z;
  
  private <T extends View> T a(int paramInt)
  {
    return this.t.findViewById(paramInt);
  }
  
  private void a(int paramInt, String paramString)
  {
    if (f()) {
      return;
    }
    if (this.B == 3090) {
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
    if ((paramURLDrawable != null) && (this.w != null))
    {
      if (this.T == null) {
        return;
      }
      Bitmap localBitmap = BaseImageUtil.a(paramURLDrawable);
      if (paramURLDrawable.getStatus() == 1)
      {
        paramURLDrawable = AvatarUtil.a(localBitmap, 50, 50);
        this.T.setImageDrawable(new BitmapDrawable(paramURLDrawable));
        return;
      }
      paramURLDrawable.setURLDrawableListener(new AddFriendVerifyFragment.12(this));
    }
  }
  
  private void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    if (f()) {
      return;
    }
    h();
    this.U = DialogUtil.a(getActivity(), 230, null, paramString1, paramString2, paramString3, new AddFriendVerifyFragment.14(this, paramString5, paramString4), new AddFriendVerifyFragment.15(this));
    try
    {
      this.U.show();
      return;
    }
    catch (Throwable paramString1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("IphoneTitleBarFragment", 2, "showErrorTipsDialogWithHandleAbility, tips dialog show failed", paramString1);
      }
    }
  }
  
  private String c(boolean paramBoolean)
  {
    if (getActivity() == null) {
      return null;
    }
    SharedPreferences localSharedPreferences = getActivity().getSharedPreferences("last_verify_msg", 0);
    if (paramBoolean)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("last_add_troop_verfity_");
      localStringBuilder.append(this.w.getAccount());
      return localSharedPreferences.getString(localStringBuilder.toString(), null);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("last_add_friend_verify_");
    localStringBuilder.append(this.w.getAccount());
    return localSharedPreferences.getString(localStringBuilder.toString(), null);
  }
  
  private void c()
  {
    if (getActivity() == null) {
      return;
    }
    ((IAddFriendTempApi)QRoute.api(IAddFriendTempApi.class)).reportExtendFriend(this.B, this.x, getActivity().getIntent());
  }
  
  private void d(String paramString)
  {
    if (f()) {
      return;
    }
    h();
    this.U = DialogUtil.a(getActivity(), paramString, 0, 2131891969, null, new AddFriendVerifyFragment.13(this, paramString));
    try
    {
      this.U.show();
      return;
    }
    catch (Throwable paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d("IphoneTitleBarFragment", 2, "showErrorTipsDlg, tips dialog show failed", paramString);
      }
    }
  }
  
  private boolean d()
  {
    if (getActivity() == null) {
      return false;
    }
    SharedPreferences localSharedPreferences = getActivity().getSharedPreferences("last_verify_msg", 0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("add_friend_verify_msg_modify_flag");
    localStringBuilder.append(this.w.getAccount());
    return localSharedPreferences.getBoolean(localStringBuilder.toString(), false);
  }
  
  private void e()
  {
    if (getActivity() == null) {
      return;
    }
    SharedPreferences.Editor localEditor = getActivity().getSharedPreferences("last_verify_msg", 0).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("add_friend_verify_msg_modify_flag");
    localStringBuilder.append(this.w.getAccount());
    localEditor.putBoolean(localStringBuilder.toString(), true);
  }
  
  private void e(String paramString)
  {
    ReportController.b(null, "dc00898", "", "", "0X800B991", "0X800B991", 0, 0, "", "", "", "");
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("showSecurityTipsDialog errorStr = ");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("IphoneTitleBarFragment", 2, ((StringBuilder)localObject).toString());
    }
    h();
    FragmentActivity localFragmentActivity = getActivity();
    String str = getString(2131916152);
    Object localObject = paramString;
    if (TextUtils.isEmpty(paramString)) {
      localObject = getString(2131916149);
    }
    this.U = DialogUtil.a(localFragmentActivity, 230, str, (String)localObject, 2131916150, 2131916151, new AddFriendVerifyFragment.16(this), new AddFriendVerifyFragment.17(this));
    try
    {
      this.U.show();
      return;
    }
    catch (Throwable paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d("IphoneTitleBarFragment", 2, "showSecurityTipsDialog, tips dialog show failed", paramString);
      }
    }
  }
  
  private boolean f()
  {
    return (getActivity() == null) || (getActivity().isFinishing());
  }
  
  private boolean g()
  {
    FragmentActivity localFragmentActivity = getActivity();
    boolean bool2 = true;
    if (localFragmentActivity == null) {
      return true;
    }
    int i = getActivity().getIntent().getExtras().getInt("source_id", 3999);
    boolean bool1 = bool2;
    if (i != 3003)
    {
      bool1 = bool2;
      if (i != 3006)
      {
        bool1 = bool2;
        if (i != 3007)
        {
          bool1 = bool2;
          if (i != 3009)
          {
            if (i == 3013) {
              return true;
            }
            bool1 = false;
          }
        }
      }
    }
    return bool1;
  }
  
  private void h()
  {
    Dialog localDialog = this.U;
    if ((localDialog != null) && (localDialog.isShowing()) && (this.U.getWindow() != null)) {}
    try
    {
      this.U.dismiss();
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  private void p()
  {
    if (f()) {
      return;
    }
    getActivity().runOnUiThread(new AddFriendVerifyFragment.18(this));
  }
  
  private void q()
  {
    INewFriendVerificationService localINewFriendVerificationService = (INewFriendVerificationService)this.w.getRuntimeService(INewFriendVerificationService.class, "");
    if ((localINewFriendVerificationService != null) && (getActivity() != null) && (getActivity().getIntent() != null))
    {
      int i = getActivity().getIntent().getIntExtra("friend_setting", 0);
      int j = getActivity().getIntent().getIntExtra("source_id", 3999);
      String str = getActivity().getIntent().getExtras().getString("extra");
      int k = getActivity().getIntent().getIntExtra("sub_source_id", 0);
      localINewFriendVerificationService.reportAddFriendBlocked(this.x, i, j, k, str);
    }
  }
  
  private void r()
  {
    View localView = l();
    if (localView == null) {
      return;
    }
    VideoReport.setPageId(this.s, "pg_add_user");
    VideoReport.setElementId(localView, "em_add_user_send_request");
    VideoReport.setElementExposePolicy(localView, ExposurePolicy.REPORT_NONE);
    VideoReport.setElementClickPolicy(localView, ClickPolicy.REPORT_NONE);
  }
  
  private void s()
  {
    View localView = l();
    if (localView == null) {
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("add_user_to_uin", this.x);
    localHashMap.put("add_user_sourceid", Integer.valueOf(this.B));
    localHashMap.put("add_user_subsourceid", Integer.valueOf(this.C));
    VideoReport.setPageParams(this.s, new PageParams(localHashMap));
    VideoReport.reportEvent("dt_imp", localView, localHashMap);
  }
  
  private void t()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("add_user_to_uin", this.x);
    localHashMap.put("add_user_sourceid", Integer.valueOf(this.B));
    localHashMap.put("add_user_subsourceid", Integer.valueOf(this.C));
    if (this.y == 3)
    {
      localHashMap.put("add_user_appid", getActivity().getIntent().getStringExtra("extra"));
      localHashMap.put("add_user_to_openid", this.x);
    }
    View localView = l();
    VideoReport.setElementParams(localView, localHashMap);
    VideoReport.reportEvent("dt_clck", localView, localHashMap);
  }
  
  protected int a()
  {
    return 2131627946;
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
    this.w = ((AppInterface)getQBaseActivity().getAppRuntime());
    this.ac = new InjectHelper();
    this.ad = this.ac.a(this.w);
    if (f()) {
      return;
    }
    Intent localIntent = getActivity().getIntent();
    this.x = localIntent.getStringExtra("uin");
    this.y = localIntent.getIntExtra("k_uin_type", 1);
    this.D = localIntent.getIntExtra("entrance", -1);
    this.C = localIntent.getIntExtra("sub_source_id", 0);
    this.B = localIntent.getIntExtra("source_id", 3999);
    if (localIntent.hasExtra("param_wzry_data")) {
      this.e = ((KplRoleInfo.WZRYUIinfo)localIntent.getSerializableExtra("param_wzry_data"));
    }
    if (AddFriendUtil.a(this.B))
    {
      this.A = localIntent.getStringExtra("nick_name");
    }
    else if (this.e != null)
    {
      this.A = localIntent.getStringExtra("nick_name");
    }
    else if (this.B == 3004)
    {
      i = this.C;
      if ((i == 5) || (i == 6) || (i == 7) || (i == 8)) {
        this.A = localIntent.getStringExtra("nick_name");
      }
    }
    if (QLog.isColorLevel())
    {
      paramLayoutInflater = new StringBuilder();
      paramLayoutInflater.append("AddFriendVerifyActivity remark = ");
      paramLayoutInflater.append(this.A);
      paramLayoutInflater.append(", source id=");
      paramLayoutInflater.append(this.B);
      paramLayoutInflater.append(", mTargetGroupId = ");
      paramLayoutInflater.append(this.z);
      QLog.i("IphoneTitleBarFragment", 2, paramLayoutInflater.toString());
    }
    if ((paramBundle == null) && (NetworkUtil.isNetSupport(getActivity())) && (AddFriendUtil.a(this.B, this.x))) {
      ((IFriendHandlerService)this.w.getRuntimeService(IFriendHandlerService.class, "")).requestAutoInfo(this.x, this.B, localIntent.getIntExtra("sub_source_id", 0));
    }
    getActivity().getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(this.ae);
    this.W = ((BounceScrollView)a(2131429719));
    this.W.setOnTouchListener(new AddFriendVerifyFragment.1(this));
    this.R = ((EditText)a(2131444679));
    this.N = ((TextView)a(2131444680));
    this.c = new AddFriendVerifyFragment.MaxBytesTextWatcher(100, this.R);
    this.R.addTextChangedListener(this.c);
    this.O = ((TextView)a(2131427894));
    this.O.setVisibility(0);
    paramLayoutInflater = getActivity().getIntent().getStringExtra("key_param_age_area");
    if (!TextUtils.isEmpty(paramLayoutInflater))
    {
      this.O.setText(paramLayoutInflater);
      if (AppSetting.e) {
        this.O.setContentDescription(paramLayoutInflater);
      }
    }
    this.R.setOnTouchListener(this);
    this.X = ((LinearLayout)a(2131439178));
    this.Y = ((LinearLayout)a(2131428391));
    this.T = ((ImageView)a(2131440523));
    this.M = ((TextView)a(2131439320));
    this.P = ((TextView)a(2131447553));
    this.Z = ((LinearLayout)a(2131434404));
    this.aa = ((FormItemRelativeLayout)a(2131445011));
    this.aa.setBGType(1);
    this.ab = ((FormItemRelativeLayout)a(2131444961));
    this.ab.setBGType(3);
    this.S = ((EditText)a(2131432631));
    this.Q = ((TextView)a(2131448505));
    this.S.addTextChangedListener(this);
    this.ab.setOnClickListener(this);
    this.S.setText(this.A);
    if (!TextUtils.isEmpty(this.A)) {
      this.S.setSelection(this.A.length());
    }
    this.Q.setText(AddFriendUtil.a(this.w, this.z));
    paramLayoutInflater = this.ab;
    paramViewGroup = new StringBuilder();
    paramViewGroup.append(HardCodeUtil.a(2131898131));
    paramViewGroup.append(AddFriendUtil.a(this.w, this.z));
    paramLayoutInflater.setContentDescription(paramViewGroup.toString());
    if (Utils.c(this.x))
    {
      this.aa.setVisibility(8);
      this.P.setText(getString(2131886225));
    }
    else
    {
      this.aa.setVisibility(0);
      this.P.setText(getString(2131886224));
    }
    if ((!EAddFriendSourceID.a(this.B)) && (this.B != 3016)) {
      i = 0;
    } else {
      i = 1;
    }
    if (i == 0)
    {
      this.I = a(2131443801);
      this.I.setVisibility(0);
      this.K = ((Switch)a(2131443802));
      this.K.setOnCheckedChangeListener(this);
    }
    if ((this.B == 3050) && (this.C == 3))
    {
      paramLayoutInflater = new HashMap();
      if (!localIntent.getBooleanExtra("qcircle_isfollow", false))
      {
        this.J = a(2131441680);
        this.J.setVisibility(0);
        this.L = ((Switch)a(2131441681));
        this.L.setOnCheckedChangeListener(this);
        paramLayoutInflater.put("ext3", "1");
      }
      else
      {
        paramLayoutInflater.put("ext3", "2");
      }
      ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504(new QCircleLpReportDc05504DataBuilder().setToUin(this.x).setActionType(79).setSubActionType(1).setThrActionType(0).setExtras(paramLayoutInflater));
      if (localIntent.getBooleanExtra("key_qcircle_stick", false)) {
        ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504(new QCircleLpReportDc05504DataBuilder().setToUin(this.x).setActionType(93).setSubActionType(1).setThrActionType(1));
      }
    }
    if (AppSetting.e)
    {
      this.T.setContentDescription(getString(2131889121));
      if (!Utils.c(this.x)) {
        this.P.setContentDescription(getString(2131915666));
      } else {
        this.P.setContentDescription(getString(2131915665));
      }
      this.aa.setFocusable(true);
      paramLayoutInflater = this.aa;
      paramViewGroup = new StringBuilder();
      paramViewGroup.append(getResources().getString(2131890924));
      paramViewGroup.append(this.S.getText().toString());
      paramLayoutInflater.setContentDescription(paramViewGroup.toString());
      this.S.setContentDescription(null);
      if (i == 0)
      {
        this.I.setFocusable(true);
        this.I.setContentDescription(getResources().getString(2131914894));
      }
    }
    this.V = new QQProgressDialog(getActivity(), getQBaseActivity().getTitleBarHeight());
    this.V.c(2131887707);
    paramLayoutInflater = getActivity().getIntent().getExtras().getString("nick_name");
    a(getString(2131886219));
    a(HardCodeUtil.a(2131898103), null);
    int m = getActivity().getIntent().getExtras().getInt("source_id", 3999);
    int k = getActivity().getIntent().getIntExtra("sub_source_id", 0);
    paramViewGroup = (IProfileProtocolService)this.w.getRuntimeService(IProfileProtocolService.class, "");
    if (EAddFriendSourceID.a(getActivity().getIntent().getIntExtra("sort_id", 0)))
    {
      paramBundle = this.x;
      paramViewGroup.requestProfileCard(this.w.getCurrentAccountUin(), "0", 16, 0L, (byte)0, 0L, 0L, null, paramBundle, 0L, 10004, null, (byte)0);
    }
    else
    {
      paramViewGroup.requestProfileCard(this.w.getCurrentAccountUin(), this.x, 12, 0L, (byte)0, 0L, 0L, null, "", 0L, 10004, null, (byte)0);
    }
    getQBaseActivity().addObserver(this.af);
    getQBaseActivity().addObserver(this.ag);
    getQBaseActivity().addObserver(this.ah);
    int i = this.y;
    if (i == 2)
    {
      this.T.setImageDrawable(FaceDrawable.getFaceDrawable(this.w, 11, this.x));
      paramBundle = this.M;
      if (TextUtils.isEmpty(paramLayoutInflater)) {
        paramViewGroup = this.x;
      } else {
        paramViewGroup = paramLayoutInflater;
      }
      paramBundle.setText(paramViewGroup);
      if (AppSetting.e)
      {
        paramBundle = this.M;
        paramViewGroup = paramLayoutInflater;
        if (TextUtils.isEmpty(paramLayoutInflater)) {
          paramViewGroup = this.x;
        }
        paramBundle.setContentDescription(paramViewGroup);
      }
    }
    else if (i == 3)
    {
      paramViewGroup = localIntent.getStringExtra("extra");
      paramViewGroup = URLDrawable.getDrawable(FaceDrawable.getOpenIdUrl(this.x, paramViewGroup), URLDrawable.URLDrawableOptions.obtain());
      if (QQTheme.isNowSimpleUI()) {
        this.T.setImageDrawable(paramViewGroup);
      } else {
        a(paramViewGroup);
      }
      this.M.setText(paramLayoutInflater);
      if (AppSetting.e) {
        this.M.setContentDescription(paramLayoutInflater);
      }
      ((IFriendHandlerService)this.w.getRuntimeService(IFriendHandlerService.class, "")).requestInfoWithOpenId(this.x, getActivity().getIntent().getStringExtra("extra"));
    }
    else
    {
      if ((m != 3007) && (m != 2007) && (m != 4007) && (m != 3019) && (m != 2019)) {
        this.T.setImageDrawable(FaceDrawable.getFaceDrawable(this.w, 1, this.x));
      } else {
        this.T.setImageDrawable(FaceDrawable.getStrangerFaceDrawable(this.w, 200, this.x, true));
      }
      if (g())
      {
        if (paramLayoutInflater != null)
        {
          this.M.setText(paramLayoutInflater);
          if (AppSetting.e) {
            this.M.setContentDescription(paramLayoutInflater);
          }
        }
      }
      else {
        ThreadManager.getSubThreadHandler().post(new AddFriendVerifyFragment.2(this, paramLayoutInflater));
      }
    }
    int n = localIntent.getIntExtra("friend_setting", 0);
    Object localObject1 = getActivity().getIntent().getExtras().getStringArrayList("user_question");
    paramViewGroup = " subSourceId = ";
    paramBundle = "reportClickEvent action: 0X80077AF  sourceId = ";
    if (n != 0)
    {
      if (n == 1) {
        break label3090;
      }
      if (n != 2) {
        if (n != 3) {
          if (n != 4) {
            break label3669;
          }
        }
      }
    }
    for (;;)
    {
      this.Y.setVisibility(0);
      StringBuffer localStringBuffer = new StringBuffer();
      if ((localObject1 != null) && (((ArrayList)localObject1).size() == 1)) {
        i = 1;
      } else {
        i = 0;
      }
      int j = 0;
      while (j < ((ArrayList)localObject1).size())
      {
        if (j != 0)
        {
          if (j != 1)
          {
            if (j != 2)
            {
              if (j != 3)
              {
                if (j != 4) {
                  paramLayoutInflater = getResources().getString(2131914209);
                } else {
                  paramLayoutInflater = getResources().getString(2131914215);
                }
              }
              else {
                paramLayoutInflater = getResources().getString(2131914214);
              }
            }
            else {
              paramLayoutInflater = getResources().getString(2131914213);
            }
          }
          else {
            paramLayoutInflater = getResources().getString(2131914212);
          }
        }
        else if (i != 0) {
          paramLayoutInflater = getResources().getString(2131914210);
        } else {
          paramLayoutInflater = getResources().getString(2131914211);
        }
        Object localObject4 = getActivity().getWindow().getLayoutInflater().inflate(2131627945, this.Y, false);
        Object localObject3 = getActivity().getWindow().getLayoutInflater().inflate(2131627944, this.Y, false);
        if (j > 0)
        {
          localObject2 = (LinearLayout.LayoutParams)((View)localObject4).getLayoutParams();
          if (localObject2 != null)
          {
            ((LinearLayout.LayoutParams)localObject2).topMargin = ((int)DisplayUtils.a(getActivity().getApplication(), 19.0F));
            ((View)localObject4).setLayoutParams((ViewGroup.LayoutParams)localObject2);
          }
        }
        this.Y.addView((View)localObject4);
        this.Y.addView((View)localObject3);
        Object localObject2 = (String)((ArrayList)localObject1).get(j);
        localObject4 = (TextView)((View)localObject4).findViewById(2131447090);
        ((TextView)localObject4).setText(String.format("%s%s", new Object[] { paramLayoutInflater, localObject2 }));
        localObject3 = (EditText)((View)localObject3).findViewById(2131435831);
        ((EditText)localObject3).addTextChangedListener(new AddFriendVerifyFragment.MaxBytesTextWatcher(50, (EditText)localObject3));
        this.F.add(localObject3);
        if (a)
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append(paramLayoutInflater);
          ((StringBuilder)localObject3).append((String)localObject2);
          ((TextView)localObject4).setContentDescription(((StringBuilder)localObject3).toString());
          ((EditText)this.F.get(j)).setContentDescription(getString(2131886223));
        }
        j += 1;
        paramLayoutInflater = new StringBuilder();
        paramLayoutInflater.append(getString(2131914209));
        paramLayoutInflater.append(j);
        paramLayoutInflater.append(":");
        paramLayoutInflater.append((String)localObject2);
        localStringBuffer.append(paramLayoutInflater.toString());
        localStringBuffer.append("\n");
        paramLayoutInflater = new StringBuilder();
        paramLayoutInflater.append(getString(2131886663));
        paramLayoutInflater.append(":${answer}");
        localStringBuffer.append(paramLayoutInflater.toString());
        if (j != ((ArrayList)localObject1).size()) {
          localStringBuffer.append("\n");
        }
      }
      b(2131887750, new AddFriendVerifyFragment.7(this, localStringBuffer, m, k, n));
      a(2131445015).setOnTouchListener(new AddFriendVerifyFragment.8(this));
      getActivity().getWindow().setSoftInputMode(4);
      paramLayoutInflater = (RelativeLayout.LayoutParams)this.Z.getLayoutParams();
      paramLayoutInflater.addRule(3, this.Y.getId());
      paramLayoutInflater.topMargin = ImmersiveUtils.dpToPx(20.0F);
      this.Z.setLayoutParams(paramLayoutInflater);
      ReportController.b(this.w, "dc00898", "", "", "0X80077AF", "0X80077AF", 4, 0, String.valueOf(m), String.valueOf(k), "", "");
      if (QLog.isColorLevel())
      {
        paramLayoutInflater = new StringBuilder();
        paramLayoutInflater.append(paramBundle);
        paramLayoutInflater.append(m);
        paramLayoutInflater.append(paramViewGroup);
        paramLayoutInflater.append(k);
        QLog.d("IphoneTitleBarFragment", 2, paramLayoutInflater.toString());
        continue;
        this.X.setVisibility(0);
        paramLayoutInflater = (String)((ArrayList)localObject1).get(0);
        paramViewGroup = (TextView)this.X.findViewById(2131447090);
        paramBundle = (EditText)this.X.findViewById(2131435831);
        this.d = new AddFriendVerifyFragment.MaxBytesTextWatcher(50, paramBundle);
        paramBundle.addTextChangedListener(this.d);
        paramViewGroup.setText(String.format("%s:%s", new Object[] { getString(2131914209), paramLayoutInflater }));
        paramBundle.setSingleLine(true);
        if (a)
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(getString(2131914209));
          ((StringBuilder)localObject1).append(":");
          ((StringBuilder)localObject1).append(paramLayoutInflater);
          paramViewGroup.setContentDescription(((StringBuilder)localObject1).toString());
          paramBundle.setContentDescription(getString(2131886223));
        }
        b(2131887750, new AddFriendVerifyFragment.6(this, paramBundle, n, m, k));
        getActivity().getWindow().setSoftInputMode(5);
        paramLayoutInflater = (RelativeLayout.LayoutParams)this.Z.getLayoutParams();
        paramLayoutInflater.addRule(3, this.X.getId());
        paramLayoutInflater.topMargin = ImmersiveUtils.dpToPx(20.0F);
        this.Z.setLayoutParams(paramLayoutInflater);
        ReportController.b(this.w, "dc00898", "", "", "0X80077AF", "0X80077AF", 3, 0, String.valueOf(m), String.valueOf(k), "", "");
        if (QLog.isColorLevel())
        {
          paramLayoutInflater = new StringBuilder();
          paramLayoutInflater.append("reportClickEvent action: 0X80077AF  sourceId = ");
          paramLayoutInflater.append(m);
          paramLayoutInflater.append(" subSourceId = ");
          paramLayoutInflater.append(k);
          QLog.d("IphoneTitleBarFragment", 2, paramLayoutInflater.toString());
          continue;
          break label3297;
          label3090:
          this.R.setVisibility(0);
          this.N.setVisibility(0);
          if (AppSetting.e)
          {
            paramLayoutInflater = this.R;
            paramLayoutInflater.setContentDescription(paramLayoutInflater.getText().toString());
            this.N.setContentDescription(getString(2131886226));
          }
          b(2131887750, new AddFriendVerifyFragment.5(this, m, k, n));
          paramLayoutInflater = (RelativeLayout.LayoutParams)this.Z.getLayoutParams();
          paramLayoutInflater.addRule(3, this.R.getId());
          paramLayoutInflater.topMargin = ImmersiveUtils.dpToPx(20.0F);
          this.Z.setLayoutParams(paramLayoutInflater);
          ReportController.b(this.w, "dc00898", "", "", "0X80077AF", "0X80077AF", 1, 0, String.valueOf(m), String.valueOf(k), "", "");
          if (QLog.isColorLevel())
          {
            paramLayoutInflater = new StringBuilder();
            paramLayoutInflater.append("reportClickEvent action: 0X80077AF  sourceId = ");
            paramLayoutInflater.append(m);
            paramLayoutInflater.append(" subSourceId = ");
            paramLayoutInflater.append(k);
            QLog.d("IphoneTitleBarFragment", 2, paramLayoutInflater.toString());
            continue;
            label3297:
            if ((m == 3078) || (m == 3079)) {
              break;
            }
            b(2131887750, new AddFriendVerifyFragment.4(this, m, k));
            paramLayoutInflater = (RelativeLayout.LayoutParams)this.Z.getLayoutParams();
            paramLayoutInflater.addRule(3, this.T.getId());
            paramLayoutInflater.topMargin = ImmersiveUtils.dpToPx(20.0F);
            this.Z.setLayoutParams(paramLayoutInflater);
            ReportController.b(this.w, "dc00898", "", "", "0X80077AF", "0X80077AF", 2, 0, String.valueOf(m), String.valueOf(k), "", "");
            if (QLog.isColorLevel())
            {
              paramLayoutInflater = new StringBuilder();
              paramLayoutInflater.append("reportClickEvent action: 0X80077AF  sourceId = ");
              paramLayoutInflater.append(m);
              paramLayoutInflater.append(" subSourceId = ");
              paramLayoutInflater.append(k);
              QLog.d("IphoneTitleBarFragment", 2, paramLayoutInflater.toString());
            }
            a(m, n);
          }
        }
      }
    }
    this.R.setVisibility(0);
    this.N.setVisibility(0);
    this.N.setText(getString(2131886207));
    this.T.setVisibility(8);
    this.M.setVisibility(8);
    this.O.setVisibility(8);
    if (AppSetting.e)
    {
      paramLayoutInflater = this.R;
      paramLayoutInflater.setContentDescription(paramLayoutInflater.getText().toString());
      this.N.setContentDescription(getString(2131886226));
    }
    this.Z.setVisibility(8);
    if (getActivity().getIntent() != null) {
      i = getActivity().getIntent().getIntExtra("contact_from_type", 1);
    } else {
      i = 1;
    }
    b(2131887750, new AddFriendVerifyFragment.3(this, i));
    paramLayoutInflater = (RelativeLayout.LayoutParams)this.Z.getLayoutParams();
    paramLayoutInflater.addRule(3, this.R.getId());
    paramLayoutInflater.topMargin = ImmersiveUtils.dpToPx(20.0F);
    this.Z.setLayoutParams(paramLayoutInflater);
    label3669:
    if (this.y == 3)
    {
      paramLayoutInflater = localIntent.getStringExtra("is_from_game");
      paramViewGroup = localIntent.getStringExtra("extra");
      try
      {
        boolean bool = ((IAddFriendTempApi)QRoute.api(IAddFriendTempApi.class)).enableCheckPermission();
        if ((("true".equals(paramLayoutInflater)) || (bool)) && (!TextUtils.isEmpty(paramViewGroup)))
        {
          AddFriendUtil.a(this.w, getActivity().getApplicationContext(), paramViewGroup, this, 1003, null);
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
          AddFriendUtil.a(this.w, getActivity().getApplicationContext(), paramViewGroup, this, 1003, null);
        }
        paramLayoutInflater = new StringBuilder();
        paramLayoutInflater.append("AddFriend loadConfig exception = ");
        paramLayoutInflater.append(paramBundle);
        QLog.d("IphoneTitleBarFragment", 1, paramLayoutInflater.toString());
      }
      if (k != 101) {
        this.Z.setVisibility(8);
      }
    }
    b(true);
    if (((IAddFriendTempApi)QRoute.api(IAddFriendTempApi.class)).isQidianMaster(this.w, this.x)) {
      this.O.setVisibility(8);
    }
    if (this.B == 3094)
    {
      this.O.setVisibility(8);
      this.M.setVisibility(8);
      this.T.setVisibility(8);
    }
    this.b = getActivity().getIntent().getStringExtra("webImVisitId");
    r();
  }
  
  void a(String paramString)
  {
    if (f()) {
      return;
    }
    if (!NetworkUtil.isNetSupport(getActivity()))
    {
      QQToast.makeText(this.w.getApp(), 1, getString(2131915702), 0).show(getQBaseActivity().getTitleBarHeight());
      return;
    }
    if (getActivity().getIntent().hasExtra("contacts"))
    {
      ArrayList localArrayList = (ArrayList)getActivity().getIntent().getSerializableExtra("contacts");
      if ((localArrayList != null) && (localArrayList.size() > 0))
      {
        if (this.V == null)
        {
          this.V = new QQProgressDialog(getActivity(), getQBaseActivity().getTitleBarHeight());
          this.V.setOnDismissListener(new AddFriendVerifyFragment.11(this));
        }
        this.V.setCancelable(true);
        this.V.setCanceledOnTouchOutside(false);
        this.V.c(2131916272);
        this.V.show();
        this.G.clear();
        this.G.addAll(localArrayList);
        ((IFriendHandlerService)this.w.getRuntimeService(IFriendHandlerService.class, "")).requestAddBatchPhoneFriend(this.G, paramString, 0, this.B, new ArrayList());
      }
    }
  }
  
  void a(String paramString, boolean paramBoolean)
  {
    if (getActivity() == null) {
      return;
    }
    if (this.e != null)
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
      localStringBuilder.append(this.w.getAccount());
      ((SharedPreferences.Editor)localObject).putString(localStringBuilder.toString(), paramString).commit();
      return;
    }
    localObject = ((SharedPreferences)localObject).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("last_add_friend_verify_");
    localStringBuilder.append(this.w.getAccount());
    ((SharedPreferences.Editor)localObject).putString(localStringBuilder.toString(), paramString).commit();
  }
  
  void a(String paramString1, byte[] paramArrayOfByte, String paramString2)
  {
    if (f()) {
      return;
    }
    if (!NetworkUtil.isNetSupport(getActivity()))
    {
      QQToast.makeText(this.w.getApp(), 1, getString(2131892157), 0).show(getQBaseActivity().getTitleBarHeight());
      return;
    }
    if (this.V == null)
    {
      this.V = new QQProgressDialog(getActivity(), getQBaseActivity().getTitleBarHeight());
      this.V.setOnDismissListener(new AddFriendVerifyFragment.10(this));
    }
    this.V.c(2131916272);
    this.V.setCancelable(true);
    this.V.setCanceledOnTouchOutside(false);
    try
    {
      this.V.show();
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("IphoneTitleBarFragment", 2, localException.toString());
      }
    }
    Intent localIntent = getActivity().getIntent();
    int j = localIntent.getIntExtra("sub_source_id", 0);
    int i = localIntent.getIntExtra("friend_setting", 0);
    if (i == 3) {
      i = 100;
    }
    boolean bool = localIntent.getBooleanExtra("contact_bothway", false);
    String str = localIntent.getStringExtra("src_name");
    ((IFriendHandlerService)this.w.getRuntimeService(IFriendHandlerService.class, "")).requestAddFriendWithMyCard(this.x, localIntent.getStringExtra("extra"), i, (byte)this.z, paramString1, this.B, j, true, paramArrayOfByte, bool, this.S.getText().toString(), str, localIntent.getByteExtra("show_my_card", (byte)0), paramString2, localIntent.getBundleExtra("flc_extra_param"), true);
    if (!AddFriendUtil.a(i, this.B, bool)) {
      ((IAddFriendServiceApi)this.w.getRuntimeService(IAddFriendServiceApi.class, "")).setAddFriendReqStatus(this.x, true);
    }
    if (!this.S.getText().toString().equals(this.A)) {
      ReportController.b(this.w, "dc00898", "", "", "0X80077B1", "0X80077B1", 0, 0, "", "", "", "");
    }
    if (localIntent.getIntExtra("sort_id", 0) == 3090) {
      ReportController.b(this.w, "CliOper", "", "", "0x80084AE", "0x80084AE", 0, 0, "", "", "", "");
    }
    if ((this.B == 3050) && (this.C == 3))
    {
      paramString1 = new HashMap();
      if ((this.L != null) && (this.H))
      {
        ((IAddFriendTempApi)QRoute.api(IAddFriendTempApi.class)).followUser(this.x, this.H);
        paramString1.put("ext3", "1");
      }
      else
      {
        paramString1.put("ext3", "2");
      }
      ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504(new QCircleLpReportDc05504DataBuilder().setToUin(this.x).setActionType(79).setSubActionType(2).setThrActionType(0).setExtras(paramString1));
      if ((localIntent.getBooleanExtra("key_qcircle_stick", false)) && (TextUtils.isEmpty(paramString2))) {
        ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504(new QCircleLpReportDc05504DataBuilder().setToUin(this.x).setActionType(93).setSubActionType(2).setThrActionType(2));
      }
    }
    paramString1 = this.ad.iterator();
    while (paramString1.hasNext()) {
      ((BaseAddFriendProcessor)paramString1.next()).a(this.x, this.B, j, this.D);
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
          int i;
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
                i = ((Integer)((JSONObject)localObject4).get("state")).intValue();
                localObject2 = (String)((JSONObject)localObject4).get("api");
                localObject4 = (String)((JSONObject)localObject4).get(paramJSONObject);
                if (!QLog.isColorLevel()) {
                  break label923;
                }
                localStringBuilder = new StringBuilder();
                localStringBuilder.append("checkApiState onResult, basics name = ");
                localStringBuilder.append(paramBundle);
                localStringBuilder.append(" state = ");
                localStringBuilder.append(i);
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
                i = ((Integer)((JSONObject)localObject4).get("state")).intValue();
                localObject2 = (String)((JSONObject)localObject4).get(paramBundle);
                localObject4 = (String)((JSONObject)localObject4).get((String)localObject1);
                if (("add_friend".equals(localObject2)) && (i != 1)) {
                  p();
                }
                if (!QLog.isColorLevel()) {
                  break label930;
                }
                localStringBuilder = new StringBuilder();
                localStringBuilder.append("checkApiState onResult, friendlink name = ");
                localStringBuilder.append(paramJSONObject);
                localStringBuilder.append(" state = ");
                localStringBuilder.append(i);
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
                i = ((Integer)((JSONObject)localObject4).get("state")).intValue();
                localObject3 = (String)((JSONObject)localObject4).get(paramBundle);
                localObject4 = (String)((JSONObject)localObject4).get(paramJSONObject);
                if (QLog.isColorLevel())
                {
                  localObject5 = new StringBuilder();
                  ((StringBuilder)localObject5).append("checkApiState onResult, qqpay name = ");
                  ((StringBuilder)localObject5).append((String)localObject2);
                  ((StringBuilder)localObject5).append(" state = ");
                  ((StringBuilder)localObject5).append(i);
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
    paramEditable = this.S.getText().toString();
    if (AddFriendUtil.a(paramEditable) > 32)
    {
      int i = this.S.getSelectionStart();
      paramEditable = AddFriendUtil.b(paramEditable);
      this.S.setText(paramEditable);
      if (i >= paramEditable.length()) {
        this.S.setSelection(paramEditable.length());
      }
    }
    if (AppSetting.e)
    {
      paramEditable = this.aa;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(getResources().getString(2131890924));
      localStringBuilder.append(this.S.getText().toString());
      paramEditable.setContentDescription(localStringBuilder.toString());
    }
  }
  
  public String b(String paramString)
  {
    Friends localFriends = c(paramString);
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
  
  void b()
  {
    if (f()) {
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
        startActivity(((IAddFriendTempApi)QRoute.api(IAddFriendTempApi.class)).composeReturnIntent((Class)localObject, this.x, getActivity()));
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
      localIntent.putExtra("uin", this.x);
      getActivity().setResult(-1, localIntent);
    }
    else
    {
      a(0, "");
      getActivity().setResult(-1);
    }
    getActivity().finish();
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public Friends c(String paramString)
  {
    if (!Friends.isValidUin(paramString)) {
      return null;
    }
    return ((IFriendDataService)this.w.getRuntimeService(IFriendDataService.class, "")).getFriend(paramString, true, true);
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    paramActivity.overridePendingTransition(2130771996, 2130771997);
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
    if (f()) {
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
        localObject = this.E;
        if (localObject != null)
        {
          a(((Bundle)localObject).getString("msg", ""), this.E.getByteArray("sig"), paramIntent);
          bool1 = true;
        }
        else
        {
          paramIntent = this.V;
          if (paramIntent != null)
          {
            paramIntent.cancel();
            this.V = null;
          }
          d(getString(2131915702));
          q();
          bool1 = bool2;
        }
      }
      else
      {
        paramIntent = this.V;
        if (paramIntent != null)
        {
          paramIntent.cancel();
          this.V = null;
        }
        d(getString(2131915702));
        q();
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
      this.z = paramInt1;
      this.Q.setText(((IAddFriendApi)QRoute.api(IAddFriendApi.class)).getGroupName(this.w, paramInt1));
      paramIntent = this.ab;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(HardCodeUtil.a(2131898131));
      ((StringBuilder)localObject).append(((IAddFriendApi)QRoute.api(IAddFriendApi.class)).getGroupName(this.w, paramInt1));
      paramIntent.setContentDescription(((StringBuilder)localObject).toString());
    }
  }
  
  public boolean onBackEvent()
  {
    if (getActivity() == null) {
      return super.onBackEvent();
    }
    q();
    Object localObject = getActivity().getIntent();
    boolean bool = false;
    if (((Intent)localObject).getBooleanExtra("need_jumpto_splash", false))
    {
      ((IAddFriendTempApi)QRoute.api(IAddFriendTempApi.class)).jumpToSplash(getActivity());
      return super.onBackEvent();
    }
    if (this.y != 4)
    {
      localObject = this.R.getText().toString();
      if (4 == this.y) {
        bool = true;
      }
      a((String)localObject, bool);
      if ((getString(2131888921).equals(localObject)) && (!d())) {
        e();
      }
    }
    if (!TextUtils.isEmpty(this.b)) {
      ReportController.b(this.w, "dc00899", "Qidian", this.x, "0X8008802", "ClickAddFriendButton", 0, 0, "2", "", "", "");
    }
    return super.onBackEvent();
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (!f())
    {
      Switch localSwitch;
      if (!NetworkUtil.isNetSupport(getActivity()))
      {
        QQToast.makeText(getActivity(), 1, 2131892104, 0).show(getQBaseActivity().getTitleBarHeight());
        localSwitch = this.K;
        if (localSwitch != null)
        {
          localSwitch.setChecked(paramBoolean ^ true);
          this.K.setOnClickListener(null);
        }
        localSwitch = this.L;
        if (localSwitch != null)
        {
          localSwitch.setChecked(paramBoolean ^ true);
          this.L.setOnClickListener(null);
        }
      }
      else
      {
        localSwitch = this.K;
        if (localSwitch != null) {
          localSwitch.setOnClickListener(this);
        }
        localSwitch = this.L;
        if (localSwitch != null) {
          localSwitch.setOnClickListener(this);
        }
        if (paramCompoundButton == this.K)
        {
          if (AppSetting.e) {
            this.I.setContentDescription(getResources().getString(2131914894));
          }
          ((IAddFriendTempApi)QRoute.api(IAddFriendTempApi.class)).launchPluginBroadcastWhenToggleSwitch(this.x, this.w, paramBoolean);
          ReportController.b(this.w, "dc00898", "", "", "0X80077B3", "0X80077B3", 0, 0, "", "", "", "");
        }
        else if (paramCompoundButton == this.L)
        {
          this.H = paramBoolean;
        }
      }
    }
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
  
  public void onClick(View paramView)
  {
    if ((paramView.getId() == 2131444961) && (!f()))
    {
      ((IAddFriendTempApi)QRoute.api(IAddFriendTempApi.class)).jumpToMoveGroup(getActivity(), this, this.x, this.z, 1002);
      EditText localEditText = this.R;
      if (localEditText != null) {
        a(localEditText.getText().toString(), false);
      }
      ReportController.b(this.w, "dc00898", "", "", "0X80077B2", "0X80077B2", 0, 0, "", "", "", "");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    h();
    if (getActivity() == null) {
      return;
    }
    if (Build.VERSION.SDK_INT >= 16)
    {
      getActivity().getWindow().getDecorView().getViewTreeObserver().removeOnGlobalLayoutListener(this.ae);
      return;
    }
    getActivity().getWindow().getDecorView().getViewTreeObserver().removeGlobalOnLayoutListener(this.ae);
  }
  
  public void onFinish()
  {
    super.onFinish();
    if (getActivity() == null) {
      return;
    }
    ((InputMethodManager)getActivity().getSystemService("input_method")).hideSoftInputFromWindow(this.h.getWindowToken(), 0);
    getActivity().getWindow().setSoftInputMode(2);
    if (this.y != 4) {
      getActivity().overridePendingTransition(0, 2130772018);
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if (f()) {
      return;
    }
    Object localObject1;
    int j;
    String str;
    Object localObject2;
    Object localObject3;
    if (this.y != 4)
    {
      localObject1 = getActivity().getIntent();
      j = 0;
      int k = 0;
      i = ((Intent)localObject1).getIntExtra("friend_setting", 0);
      if (i != 0)
      {
        if (i != 1) {
          break label665;
        }
        str = getString(2131888921);
        if (getActivity().getIntent().getBooleanExtra("_FROM_QLINK_", false))
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(str);
          ((StringBuilder)localObject1).append(getString(2131896325));
          ((StringBuilder)localObject1).append(" ");
          localObject2 = this.w;
          ((StringBuilder)localObject1).append(AddFriendUtil.a((AppInterface)localObject2, ((AppInterface)localObject2).getAccount()));
          localObject2 = ((StringBuilder)localObject1).toString();
          this.R.setHint((CharSequence)localObject2);
        }
        else
        {
          this.R.setHint("");
          localObject2 = str;
        }
        this.R.setVisibility(0);
        this.N.setVisibility(0);
        if (AppSetting.e)
        {
          localObject1 = this.R;
          ((EditText)localObject1).setContentDescription(((EditText)localObject1).getText().toString());
          this.N.setContentDescription(getString(2131886226));
        }
        localObject1 = null;
        if (this.y == 3)
        {
          localObject1 = getActivity().getIntent().getStringExtra("msg");
        }
        else
        {
          localObject3 = this.e;
          if (localObject3 != null)
          {
            localObject3 = ((KplRoleInfo.WZRYUIinfo)localObject3).verifyMsg;
            localObject1 = localObject3;
            if (!TextUtils.isEmpty((CharSequence)localObject3))
            {
              i = 0;
              localObject1 = localObject3;
              break label299;
            }
          }
        }
        i = 1;
        label299:
        localObject3 = localObject1;
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          localObject3 = c(false);
        }
        if (!TextUtils.isEmpty((CharSequence)localObject3)) {
          localObject2 = localObject3;
        }
        j = k;
        localObject1 = localObject2;
        if (i != 0)
        {
          j = k;
          localObject1 = localObject2;
          if (str.equals(localObject2))
          {
            j = k;
            localObject1 = localObject2;
            if (!d())
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append((String)localObject2);
              localObject2 = this.w;
              ((StringBuilder)localObject1).append(AddFriendUtil.a((AppInterface)localObject2, ((AppInterface)localObject2).getAccount()));
              localObject1 = ((StringBuilder)localObject1).toString();
              j = 1;
            }
          }
        }
        this.R.setText((CharSequence)localObject1);
        if (j == 0) {}
      }
    }
    try
    {
      this.R.setSelection(str.length(), ((String)localObject1).length());
    }
    catch (Throwable localThrowable1)
    {
      break label465;
    }
    this.R.setSelection(((String)localObject1).length());
    label465:
    getActivity().getWindow().setSoftInputMode(5);
    break label665;
    int i = this.B;
    if ((i == 3078) || (i == 3079))
    {
      localObject3 = c(false);
      localObject2 = getString(2131888921);
      localObject1 = localObject3;
      i = j;
      if (TextUtils.isEmpty((CharSequence)localObject3)) {
        if (!d())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append((String)localObject2);
          localObject3 = this.w;
          ((StringBuilder)localObject1).append(AddFriendUtil.a((AppInterface)localObject3, ((AppInterface)localObject3).getAccount()));
          localObject1 = ((StringBuilder)localObject1).toString();
          i = 1;
        }
        else
        {
          localObject1 = localObject2;
          i = j;
        }
      }
      this.R.setHint("");
      this.R.setText((CharSequence)localObject1);
      if (i == 0) {}
    }
    try
    {
      this.R.setSelection(((String)localObject2).length(), ((String)localObject1).length());
    }
    catch (Throwable localThrowable2)
    {
      label654:
      label665:
      break label654;
    }
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {
      this.R.setSelection(((String)localObject1).length());
    }
    getActivity().getWindow().setSoftInputMode(5);
    s();
  }
  
  public void onStart()
  {
    super.onStart();
    if (getActivity() == null) {
      return;
    }
    if (this.ag != null) {
      getQBaseActivity().addObserver(this.ag);
    }
    if (this.af != null) {
      getQBaseActivity().addObserver(this.af);
    }
    if (this.ah != null) {
      getQBaseActivity().addObserver(this.ah);
    }
  }
  
  public void onStop()
  {
    super.onStop();
    if (this.ag != null) {
      getQBaseActivity().removeObserver(this.ag);
    }
    if (this.af != null) {
      getQBaseActivity().removeObserver(this.af);
    }
    if (this.ah != null) {
      getQBaseActivity().removeObserver(this.ah);
    }
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramView.getId() == 2131435831)
    {
      int i = paramMotionEvent.getAction() & 0xFF;
      if (i != 0)
      {
        if ((i != 1) && (i != 3)) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.addfriend.ui.AddFriendVerifyFragment
 * JD-Core Version:    0.7.0.1
 */