package com.tencent.mobileqq.addfriend.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import androidx.fragment.app.FragmentActivity;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.QPublicFragmentActivity.Launcher;
import com.tencent.mobileqq.activity.QPublicTransFragmentActivity;
import com.tencent.mobileqq.activity.selectmember.api.IForwardApi;
import com.tencent.mobileqq.addfriend.api.IAddFriendApi;
import com.tencent.mobileqq.addfriend.helper.InjectHelper;
import com.tencent.mobileqq.addfriend.helper.OpenIdHelper;
import com.tencent.mobileqq.addfriend.processor.BaseAddFriendProcessor;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.data.OpenID;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.friend.api.IFriendDataService;
import com.tencent.mobileqq.friend.api.IFriendHandlerService;
import com.tencent.mobileqq.friend.observer.FriendObserver;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.utils.ProfileUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.relation.api.IAddFriendTempApi;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import mqq.app.MobileQQ;

public class AddFriendCheckFragment
  extends QPublicBaseFragment
{
  private static String jdField_a_of_type_JavaLangString = "";
  private static boolean jdField_b_of_type_Boolean = false;
  private int jdField_a_of_type_Int;
  DialogInterface.OnClickListener jdField_a_of_type_AndroidContentDialogInterface$OnClickListener = new AddFriendCheckFragment.6(this);
  protected Handler a;
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  FriendObserver jdField_a_of_type_ComTencentMobileqqFriendObserverFriendObserver = new AddFriendCheckFragment.8(this);
  protected QQCustomDialog a;
  private QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  private ArrayList<BaseAddFriendProcessor> jdField_a_of_type_JavaUtilArrayList;
  protected boolean a;
  private int jdField_b_of_type_Int;
  DialogInterface.OnClickListener jdField_b_of_type_AndroidContentDialogInterface$OnClickListener = new AddFriendCheckFragment.7(this);
  private QQCustomDialog jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog;
  private String jdField_b_of_type_JavaLangString;
  private int jdField_c_of_type_Int;
  private String jdField_c_of_type_JavaLangString;
  private int jdField_d_of_type_Int = -1;
  private String jdField_d_of_type_JavaLangString;
  private int jdField_e_of_type_Int;
  private String jdField_e_of_type_JavaLangString;
  private int f = -1;
  
  public AddFriendCheckFragment()
  {
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
  }
  
  public static Intent a(Context paramContext, int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    if (QLog.isColorLevel()) {
      QLog.i("addFriendTag", 2, String.format(Locale.getDefault(), "AddFriendCheckFragment.startAddFriend [type:%s, uin: %s, extUin: %s, source:%s, subSource:%s]", new Object[] { Integer.valueOf(paramInt1), Utils.a(paramString1), paramString2, Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) }));
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("uin", paramString1);
    localIntent.putExtra("k_uin_type", paramInt1);
    localIntent.putExtra("extra", paramString2);
    localIntent.putExtra("source_id", paramInt2);
    localIntent.putExtra("sub_source_id", paramInt3);
    localIntent.putExtra("is_from_game", JumpAction.n);
    JumpAction.n = null;
    if (!TextUtils.isEmpty(paramString3)) {
      paramString3 = ((IAddFriendApi)QRoute.api(IAddFriendApi.class)).getRemark(paramString3);
    }
    localIntent.putExtra("nick_name", paramString3);
    if ((paramString4 != null) && (paramString4.length() > 30)) {
      paramString4 = paramString4.substring(0, 28);
    }
    localIntent.putExtra("msg", paramString4);
    localIntent.putExtra("param_return_addr", paramString5);
    localIntent.putExtra("last_activity", paramString6);
    localIntent.putExtra("src_name", paramString7);
    if (paramInt2 == 3999)
    {
      paramString2 = new HashMap(4);
      paramString2.put("act", paramContext.getClass().getSimpleName());
      if (QBaseActivity.sTopActivity == null) {
        paramString1 = "null";
      } else {
        paramString1 = QBaseActivity.sTopActivity.toString();
      }
      paramString2.put("top", paramString1);
      if ((paramContext instanceof Activity))
      {
        paramString1 = ((Activity)paramContext).getIntent();
        if (paramString1 != null)
        {
          paramString2.put("intent", paramString1.toString());
          paramString1 = paramString1.getExtras();
          if (paramString1 != null) {
            paramString2.put("extra", paramString1.toString());
          }
        }
      }
      StatisticCollector.getInstance(paramContext).collectPerformance(null, "addFriendSource", true, 0L, 0L, paramString2, null);
    }
    if (QLog.isColorLevel())
    {
      paramContext = new StringBuilder();
      paramContext.append("startAddFriend Extras = ");
      paramContext.append(localIntent.getExtras().toString());
      QLog.d("AddFriendCheckFragment", 2, paramContext.toString());
    }
    if (QLog.isDebugVersion())
    {
      paramContext = new StringBuilder();
      paramContext.append("source =  ");
      paramContext.append(paramInt2);
      paramContext.append("subSource= ");
      paramContext.append(paramInt3);
      QLog.d("addfriend", 2, paramContext.toString());
    }
    return localIntent;
  }
  
  public static Intent a(Context paramContext, List<PhoneContact> paramList, int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("k_uin_type", 2);
    localIntent.putExtra("contacts", (Serializable)paramList);
    localIntent.putExtra("source_id", paramInt1);
    paramContext = paramString1;
    if (paramString1 != null)
    {
      paramContext = paramString1;
      if (paramString1.length() > 30) {
        paramContext = paramString1.substring(0, 28);
      }
    }
    localIntent.putExtra("msg", paramContext);
    localIntent.putExtra("last_activity", paramString2);
    localIntent.putExtra("src_name", paramString3);
    localIntent.putExtra("contact_from_type", paramInt2);
    if (QLog.isColorLevel())
    {
      paramContext = new StringBuilder();
      paramContext.append("startMultiAddFriend Extras = ");
      paramContext.append(localIntent.getExtras().toString());
      QLog.d("AddFriendCheckFragment", 2, paramContext.toString());
    }
    return localIntent;
  }
  
  public static String a()
  {
    return jdField_a_of_type_JavaLangString;
  }
  
  private void a(int paramInt, String paramString)
  {
    if (d()) {
      return;
    }
    if (getActivity().getIntent() != null)
    {
      if (getActivity().getIntent().getIntExtra("source_id", 3999) != 3090) {
        return;
      }
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
        QLog.e("AddFriendCheckFragment", 1, ((StringBuilder)localObject).toString());
        return;
      }
    }
    QLog.e("AddFriendCheckFragment", 1, "feedBackToGameSDK intent = null");
  }
  
  public static void a(Activity paramActivity, Intent paramIntent, int paramInt)
  {
    paramIntent.putExtra("public_fragment_window_feature", 1);
    QPublicFragmentActivity.Launcher.a(paramActivity, paramIntent, QPublicTransFragmentActivity.class, AddFriendCheckFragment.class, paramInt);
  }
  
  public static void a(Context paramContext, Intent paramIntent)
  {
    if (!(paramContext instanceof Activity)) {
      paramIntent.addFlags(268435456);
    }
    paramIntent.putExtra("public_fragment_window_feature", 1);
    QPublicFragmentActivity.Launcher.a(paramContext, paramIntent, QPublicTransFragmentActivity.class, AddFriendCheckFragment.class);
  }
  
  public static void a(String paramString)
  {
    jdField_a_of_type_JavaLangString = paramString;
  }
  
  public static void a(boolean paramBoolean)
  {
    jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public static boolean a()
  {
    return jdField_b_of_type_Boolean;
  }
  
  private boolean a(int paramInt, String paramString)
  {
    if (d()) {
      return false;
    }
    if (paramInt != 1) {
      if (paramInt != 2)
      {
        if (paramInt != 3)
        {
          getActivity().finish();
          return false;
        }
        if (this.jdField_c_of_type_Int == 3999)
        {
          this.jdField_c_of_type_Int = 3016;
          if (QLog.isColorLevel()) {
            QLog.d("Q.contacts.", 2, "openId source id is default!");
          }
        }
      }
      else if (this.jdField_c_of_type_Int == 3999)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.contacts.", 2, "mobile source id is default!");
        }
        this.jdField_c_of_type_Int = 3006;
      }
    }
    try
    {
      Long.parseLong(paramString);
      if (((IFriendDataService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IFriendDataService.class, "")).isFriend(paramString))
      {
        QQToast.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication(), 2131689998, 0).b(getQBaseActivity().getTitleBarHeight());
        getActivity().finish();
        return false;
      }
      if (!NetworkUtil.isNetSupport(getActivity()))
      {
        QQToast.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication(), 2131694424, 0).b(getQBaseActivity().getTitleBarHeight());
        getActivity().finish();
        return false;
      }
      return true;
    }
    catch (Throwable paramString) {}
    return false;
  }
  
  private void b()
  {
    if (d()) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("AddFriendCheckFragment", 2, "showProgress");
    }
    if (!getActivity().isFinishing())
    {
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(getActivity(), getQBaseActivity().getTitleBarHeight());
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(new AddFriendCheckFragment.1(this));
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(2131692930);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.getWindow().setDimAmount(0.0F);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
    }
  }
  
  private void b(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("dismissOrHideProgress hide: ");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.i("AddFriendCheckFragment", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
    if (localObject != null)
    {
      if (!((QQProgressDialog)localObject).isShowing()) {
        return;
      }
      if (paramBoolean)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.hide();
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
  }
  
  private boolean b()
  {
    if (d()) {
      return false;
    }
    if (!NetworkUtil.isNetSupport(getActivity()))
    {
      QQToast.a(BaseApplication.getContext(), 2131694424, 0).b(getQBaseActivity().getTitleBarHeight());
      getActivity().finish();
      return false;
    }
    Intent localIntent = new Intent();
    localIntent.putExtras(getActivity().getIntent());
    localIntent.putExtra("param_mode", 0);
    localIntent.putExtra("contact_bothway", true);
    if (getActivity().getIntent().getStringExtra("param_return_addr") != null)
    {
      QPublicFragmentActivity.start(getActivity(), localIntent, AddFriendVerifyFragment.class);
      getActivity().finish();
      return true;
    }
    QPublicFragmentActivity.startForResult(getActivity(), localIntent, AddFriendVerifyFragment.class, 1);
    return true;
  }
  
  private void c()
  {
    if (d()) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("AddFriendCheckFragment", 2, "getAddFriendSetting");
    }
    b();
    int i = getActivity().getIntent().getIntExtra("sub_source_id", 0);
    ((IFriendHandlerService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IFriendHandlerService.class, "")).requestUserAddFriendSetting(this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_Int, i, this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Int);
  }
  
  private boolean c()
  {
    if (d()) {
      return false;
    }
    Object localObject1 = getActivity().getIntent();
    this.jdField_c_of_type_Int = ((Intent)localObject1).getIntExtra("source_id", 3999);
    this.jdField_c_of_type_JavaLangString = ((Intent)localObject1).getStringExtra("extra");
    if (!a(this.jdField_b_of_type_Int, this.jdField_b_of_type_JavaLangString)) {
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.i("AddFriendCheckFragment", 2, "addFriend");
    }
    localObject1 = ((Intent)localObject1).getStringExtra("nick_name");
    if ((this.jdField_c_of_type_Int == 3004) && (localObject1 == null) && (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)))
    {
      localObject1 = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getEntityManagerFactory().createEntityManager();
      Object localObject2 = (TroopMemberInfo)((EntityManager)localObject1).find(TroopMemberInfo.class, new String[] { this.jdField_c_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString });
      if (localObject2 != null)
      {
        localObject2 = ((TroopMemberInfo)localObject2).friendnick;
        getActivity().getIntent().putExtra("nick_name", (String)localObject2);
      }
      ((EntityManager)localObject1).close();
    }
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqFriendObserverFriendObserver);
    if (this.jdField_b_of_type_Int == 1)
    {
      if (QLog.isColorLevel()) {
        QLog.i("AddFriendCheckFragment", 2, "queryUinSafetyFlag");
      }
      b();
      ((IFriendHandlerService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IFriendHandlerService.class, "")).requestUinSafetyFlag(Long.parseLong(this.jdField_b_of_type_JavaLangString));
      return true;
    }
    if (this.jdField_c_of_type_Int == 3024)
    {
      c();
      return true;
    }
    if (!TextUtils.isEmpty(a()))
    {
      d();
      return true;
    }
    c();
    return true;
  }
  
  private void d()
  {
    if (QLog.isColorLevel()) {
      QLog.i("addFriendTag", 2, "checkAccountDiff");
    }
    if (!TextUtils.isEmpty(a()))
    {
      OpenID localOpenID;
      if (this.jdField_c_of_type_JavaLangString == null) {
        localOpenID = null;
      } else {
        localOpenID = OpenIdHelper.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface).a(this.jdField_c_of_type_JavaLangString);
      }
      if ((localOpenID != null) && (!TextUtils.isEmpty(localOpenID.openID)))
      {
        if (!a().equals(localOpenID.openID))
        {
          a();
          return;
        }
        c();
        return;
      }
      b();
      this.jdField_a_of_type_AndroidOsHandler = new Handler();
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(new AddFriendCheckFragment.2(this), 3000L);
      if (this.jdField_c_of_type_JavaLangString != null) {
        OpenIdHelper.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface).a(this.jdField_c_of_type_JavaLangString, new AddFriendCheckFragment.3(this));
      }
    }
  }
  
  private boolean d()
  {
    return (getActivity() == null) || (getActivity().isFinishing());
  }
  
  private void e()
  {
    if ((this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) && (this.jdField_e_of_type_Int != 0))
    {
      Object localObject1 = (Bundle)((IAddFriendTempApi)QRoute.api(IAddFriendTempApi.class)).getValue("SecWarningCfg", "AlertTitle", 147, this.jdField_e_of_type_Int);
      if (localObject1 != null) {
        localObject1 = ((Bundle)localObject1).getString("AlertTitle");
      } else {
        localObject1 = null;
      }
      Object localObject2 = (Bundle)((IAddFriendTempApi)QRoute.api(IAddFriendTempApi.class)).getValue("SecWarningCfg", "AlertText", 147, this.jdField_e_of_type_Int);
      Object localObject4;
      if (localObject2 != null) {
        localObject4 = ((Bundle)localObject2).getString("AlertText");
      } else {
        localObject4 = null;
      }
      localObject2 = (Bundle)((IAddFriendTempApi)QRoute.api(IAddFriendTempApi.class)).getValue("SecWarningCfg", "AlertLeftBtnText", 147, this.jdField_e_of_type_Int);
      if (localObject2 != null) {
        localObject2 = ((Bundle)localObject2).getString("AlertLeftBtnText");
      } else {
        localObject2 = null;
      }
      Object localObject3 = (Bundle)((IAddFriendTempApi)QRoute.api(IAddFriendTempApi.class)).getValue("SecWarningCfg", "AlertRightBtnText", 147, this.jdField_e_of_type_Int);
      if (localObject3 != null) {
        localObject3 = ((Bundle)localObject3).getString("AlertRightBtnText");
      } else {
        localObject3 = null;
      }
      Object localObject5 = localObject1;
      int i;
      if (localObject1 == null)
      {
        if (this.jdField_e_of_type_Int == 1) {
          i = 2131718638;
        } else {
          i = 2131718642;
        }
        localObject5 = getString(i);
      }
      localObject1 = localObject4;
      if (localObject4 == null)
      {
        i = this.jdField_e_of_type_Int;
        if (i == 1) {
          localObject1 = getString(2131718639);
        } else if (i == 2) {
          localObject1 = getString(2131718637);
        } else if (i == 3) {
          localObject1 = getString(2131718641);
        } else if (i == 4) {
          localObject1 = getString(2131718640);
        } else if (i == 5) {
          localObject1 = getString(2131718635);
        } else {
          localObject1 = getString(2131718636);
        }
      }
      if (localObject2 == null)
      {
        if (this.jdField_e_of_type_Int == 1)
        {
          this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener = null;
          localObject4 = localObject2;
        }
        else
        {
          localObject4 = getString(2131718634);
        }
      }
      else
      {
        localObject4 = localObject2;
        if (TextUtils.isEmpty(((String)localObject2).trim()))
        {
          this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener = null;
          localObject4 = localObject2;
        }
      }
      if (localObject3 == null)
      {
        if (this.jdField_e_of_type_Int == 1) {
          localObject2 = getString(2131718633);
        } else {
          localObject2 = getString(2131718632);
        }
      }
      else
      {
        localObject2 = localObject3;
        if (TextUtils.isEmpty(((String)localObject3).trim()))
        {
          this.jdField_b_of_type_AndroidContentDialogInterface$OnClickListener = null;
          localObject2 = localObject3;
        }
      }
      this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.setTitle((String)localObject5);
      this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.setMessage((CharSequence)localObject1);
      this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.setNegativeButton((String)localObject4, this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener);
      this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.setPositiveButton((String)localObject2, this.jdField_b_of_type_AndroidContentDialogInterface$OnClickListener);
      if ((this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener == null) || (this.jdField_b_of_type_AndroidContentDialogInterface$OnClickListener == null)) {
        this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.findViewById(2131363829).setVisibility(8);
      }
    }
  }
  
  private void f()
  {
    if (d())
    {
      if (QLog.isColorLevel()) {
        QLog.d("AddFriendCheckFragment", 2, "showRefuseAddFriendDialog is finishing return");
      }
      return;
    }
    QQCustomDialog localQQCustomDialog = DialogUtil.a(getActivity(), 230);
    localQQCustomDialog.setTitle(getString(2131689611));
    localQQCustomDialog.setMessage(getString(2131718172));
    localQQCustomDialog.setCancelable(false);
    localQQCustomDialog.setCanceledOnTouchOutside(false);
    Window localWindow = localQQCustomDialog.getWindow();
    if (localWindow != null)
    {
      localWindow.setDimAmount(0.5F);
      localWindow.addFlags(2);
    }
    localQQCustomDialog.setPositiveButton(2131694583, new AddFriendCheckFragment.5(this)).setNegativeButton(null, null).show();
  }
  
  protected void a()
  {
    if (d()) {
      return;
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
    if ((localObject != null) && (!((QQCustomDialog)localObject).isShowing()) && (!getActivity().isFinishing()))
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(getActivity(), 230);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setMessage(2131695206);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setTitle(2131692113);
    localObject = new AddFriendCheckFragment.4(this);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setNegativeButton(2131690728, (DialogInterface.OnClickListener)localObject);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setPositiveButton(2131695174, (DialogInterface.OnClickListener)localObject);
    if (!getActivity().isFinishing()) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
    }
  }
  
  void a(int paramInt1, boolean paramBoolean, ArrayList<String> paramArrayList, int paramInt2)
  {
    if (d()) {
      return;
    }
    this.jdField_d_of_type_Int = paramInt1;
    if ((this.jdField_c_of_type_Int == 3024) && (paramInt1 == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("AddFriendCheckFragment", 2, "startVerifyActivity() from applets add friend and friendSetting is 0 ");
      }
      if (NetworkUtil.isNetSupport(getActivity()))
      {
        paramInt2 = getActivity().getIntent().getIntExtra("sub_source_id", 0);
        ((IFriendHandlerService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IFriendHandlerService.class, "")).requestAddFriend(this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, paramInt1, (byte)0, "", this.jdField_c_of_type_Int, paramInt2, false, null, false, null, this.jdField_e_of_type_JavaLangString, getActivity().getIntent().getBundleExtra("flc_extra_param"), false);
        return;
      }
      QQToast.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication(), 2131694424, 0).b(getQBaseActivity().getTitleBarHeight());
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtras(getActivity().getIntent());
    localIntent.putExtra("param_mode", 0);
    localIntent.putExtra("friend_setting", paramInt1);
    localIntent.putExtra("contact_bothway", paramBoolean);
    localIntent.putExtra("user_question", paramArrayList);
    localIntent.putExtra("sort_id", this.jdField_c_of_type_Int);
    localIntent.putExtra("extra", this.jdField_c_of_type_JavaLangString);
    localIntent.putExtra("entrance", this.f);
    paramArrayList = this.jdField_a_of_type_JavaUtilArrayList;
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      paramArrayList = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (paramArrayList.hasNext()) {
        ((BaseAddFriendProcessor)paramArrayList.next()).a(localIntent, getActivity(), this.jdField_b_of_type_JavaLangString, paramInt2);
      }
    }
    if (getActivity().getIntent().getStringExtra("param_return_addr") != null)
    {
      QPublicFragmentActivity.start(getActivity(), localIntent, AddFriendVerifyFragment.class);
      getActivity().finish();
      return;
    }
    QPublicFragmentActivity.startForResult(getActivity(), localIntent, AddFriendVerifyFragment.class, 1);
  }
  
  public void a(String paramString1, String paramString2, Activity paramActivity)
  {
    if (paramActivity != null)
    {
      if (paramActivity.getIntent() == null) {
        return;
      }
      paramString1 = new AllInOne(paramString1, 1);
      paramString1.profileEntryType = 115;
      Intent localIntent = ProfileUtils.getIntent(paramActivity, paramString1);
      localIntent.putExtra("AllInOne", paramString1);
      localIntent.putExtra("src_name", paramString2);
      localIntent.putExtra("source_id", paramActivity.getIntent().getIntExtra("source_id", 3999));
      localIntent.putExtra("extra", paramActivity.getIntent().getStringExtra("extra"));
      localIntent.addFlags(536870912);
      localIntent.addFlags(268435456);
      paramActivity.startActivity(localIntent);
    }
  }
  
  public boolean needImmersive()
  {
    return false;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (d()) {
      return;
    }
    Intent localIntent = getActivity().getIntent();
    boolean bool = false;
    if (localIntent != null) {
      bool = localIntent.getBooleanExtra("need_result_uin", false);
    }
    localIntent = paramIntent;
    if (bool)
    {
      localIntent = paramIntent;
      if (paramIntent == null) {
        localIntent = new Intent();
      }
      localIntent.putExtra("uin", this.jdField_b_of_type_JavaLangString);
    }
    getActivity().setResult(paramInt2, localIntent);
    getActivity().finish();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = ((AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null));
    this.jdField_a_of_type_JavaUtilArrayList = new InjectHelper().a(this.jdField_a_of_type_ComTencentCommonAppAppInterface);
    if (d()) {
      return;
    }
    paramBundle = getActivity().getIntent();
    this.jdField_b_of_type_Int = paramBundle.getIntExtra("k_uin_type", 0);
    this.jdField_b_of_type_JavaLangString = paramBundle.getStringExtra("uin");
    this.jdField_d_of_type_JavaLangString = paramBundle.getStringExtra("last_activity");
    this.jdField_e_of_type_JavaLangString = paramBundle.getStringExtra("src_name");
    this.f = paramBundle.getIntExtra("entrance", -1);
    String str = this.jdField_b_of_type_JavaLangString;
    if ((str != null) && (str.length() >= 5))
    {
      this.jdField_a_of_type_Int = hashCode();
      if (this.jdField_b_of_type_Int == 4)
      {
        QLog.e("AddFriendCheckFragment", 1, "AddFriendCheckFragment call error");
        return;
      }
      c();
      return;
    }
    this.jdField_c_of_type_Int = paramBundle.getIntExtra("source_id", 3999);
    int i = this.jdField_c_of_type_Int;
    if ((i != 3078) && (i != 3079))
    {
      if (QLog.isColorLevel()) {
        QLog.d("AddFriendCheckFragment", 2, "uin should not be null, activity finish");
      }
      getActivity().finish();
      return;
    }
    b();
  }
  
  public void onDestroy()
  {
    b(false);
    FriendObserver localFriendObserver = this.jdField_a_of_type_ComTencentMobileqqFriendObserverFriendObserver;
    if (localFriendObserver != null) {
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.removeObserver(localFriendObserver);
    }
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.addfriend.ui.AddFriendCheckFragment
 * JD-Core Version:    0.7.0.1
 */