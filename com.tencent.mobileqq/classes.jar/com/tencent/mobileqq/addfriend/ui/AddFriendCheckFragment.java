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
  private static String h = "";
  private static boolean j = false;
  protected Handler a;
  protected boolean b;
  protected QQCustomDialog c = null;
  DialogInterface.OnClickListener d = new AddFriendCheckFragment.6(this);
  DialogInterface.OnClickListener e = new AddFriendCheckFragment.7(this);
  FriendObserver f = new AddFriendCheckFragment.8(this);
  private AppInterface g;
  private int i;
  private int k;
  private String l;
  private String m;
  private int n;
  private QQProgressDialog o;
  private int p = -1;
  private String q;
  private String r;
  private QQCustomDialog s;
  private int t;
  private int u = -1;
  private ArrayList<BaseAddFriendProcessor> v;
  
  public static Intent a(Context paramContext, int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    if (QLog.isColorLevel()) {
      QLog.i("addFriendTag", 2, String.format(Locale.getDefault(), "AddFriendCheckFragment.startAddFriend [type:%s, uin: %s, extUin: %s, source:%s, subSource:%s]", new Object[] { Integer.valueOf(paramInt1), Utils.i(paramString1), paramString2, Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) }));
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("uin", paramString1);
    localIntent.putExtra("k_uin_type", paramInt1);
    localIntent.putExtra("extra", paramString2);
    localIntent.putExtra("source_id", paramInt2);
    localIntent.putExtra("sub_source_id", paramInt3);
    localIntent.putExtra("is_from_game", JumpAction.A);
    JumpAction.A = null;
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
    h = paramString;
  }
  
  public static void a(boolean paramBoolean)
  {
    j = paramBoolean;
  }
  
  public static boolean a()
  {
    return j;
  }
  
  private boolean a(int paramInt, String paramString)
  {
    if (k()) {
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
        if (this.n == 3999)
        {
          this.n = 3016;
          if (QLog.isColorLevel()) {
            QLog.d("Q.contacts.", 2, "openId source id is default!");
          }
        }
      }
      else if (this.n == 3999)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.contacts.", 2, "mobile source id is default!");
        }
        this.n = 3006;
      }
    }
    try
    {
      Long.parseLong(paramString);
      if (((IFriendDataService)this.g.getRuntimeService(IFriendDataService.class, "")).isFriend(paramString))
      {
        QQToast.makeText(this.g.getApplication(), 2131886641, 0).show(getQBaseActivity().getTitleBarHeight());
        getActivity().finish();
        return false;
      }
      if (!NetworkUtil.isNetSupport(getActivity()))
      {
        QQToast.makeText(this.g.getApplication(), 2131892104, 0).show(getQBaseActivity().getTitleBarHeight());
        getActivity().finish();
        return false;
      }
      return true;
    }
    catch (Throwable paramString) {}
    return false;
  }
  
  public static String b()
  {
    return h;
  }
  
  private void b(int paramInt, String paramString)
  {
    if (k()) {
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
  
  private void b(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("dismissOrHideProgress hide: ");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.i("AddFriendCheckFragment", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.o;
    if (localObject != null)
    {
      if (!((QQProgressDialog)localObject).isShowing()) {
        return;
      }
      if (paramBoolean)
      {
        this.o.hide();
        return;
      }
      this.o.dismiss();
    }
  }
  
  private boolean d()
  {
    if (k()) {
      return false;
    }
    if (!NetworkUtil.isNetSupport(getActivity()))
    {
      QQToast.makeText(BaseApplication.getContext(), 2131892104, 0).show(getQBaseActivity().getTitleBarHeight());
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
  
  private boolean e()
  {
    if (k()) {
      return false;
    }
    Object localObject1 = getActivity().getIntent();
    this.n = ((Intent)localObject1).getIntExtra("source_id", 3999);
    this.m = ((Intent)localObject1).getStringExtra("extra");
    if (!a(this.k, this.l)) {
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.i("AddFriendCheckFragment", 2, "addFriend");
    }
    localObject1 = ((Intent)localObject1).getStringExtra("nick_name");
    if ((this.n == 3004) && (localObject1 == null) && (!TextUtils.isEmpty(this.m)))
    {
      localObject1 = this.g.getEntityManagerFactory().createEntityManager();
      Object localObject2 = (TroopMemberInfo)((EntityManager)localObject1).find(TroopMemberInfo.class, new String[] { this.m, this.l });
      if (localObject2 != null)
      {
        localObject2 = ((TroopMemberInfo)localObject2).friendnick;
        getActivity().getIntent().putExtra("nick_name", (String)localObject2);
      }
      ((EntityManager)localObject1).close();
    }
    this.g.addObserver(this.f);
    if (this.k == 1)
    {
      if (QLog.isColorLevel()) {
        QLog.i("AddFriendCheckFragment", 2, "queryUinSafetyFlag");
      }
      f();
      ((IFriendHandlerService)this.g.getRuntimeService(IFriendHandlerService.class, "")).requestUinSafetyFlag(Long.parseLong(this.l));
      return true;
    }
    if (this.n == 3024)
    {
      g();
      return true;
    }
    if (!TextUtils.isEmpty(b()))
    {
      h();
      return true;
    }
    g();
    return true;
  }
  
  private void f()
  {
    if (k()) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("AddFriendCheckFragment", 2, "showProgress");
    }
    if (!getActivity().isFinishing())
    {
      if (this.o == null)
      {
        this.o = new QQProgressDialog(getActivity(), getQBaseActivity().getTitleBarHeight());
        this.o.a(new AddFriendCheckFragment.1(this));
      }
      this.o.c(2131890041);
      this.o.getWindow().setDimAmount(0.0F);
      this.o.show();
    }
  }
  
  private void g()
  {
    if (k()) {
      return;
    }
    f();
    int i1 = getActivity().getIntent().getIntExtra("sub_source_id", 0);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getAddFriendSetting, mUin = ");
      localStringBuilder.append(this.l);
      localStringBuilder.append(" mFriendSource = ");
      localStringBuilder.append(this.n);
      localStringBuilder.append(" subSource = ");
      localStringBuilder.append(i1);
      localStringBuilder.append(" mExtUin = ");
      localStringBuilder.append(this.m);
      localStringBuilder.append(" rankey = ");
      localStringBuilder.append(this.i);
      QLog.i("AddFriendCheckFragment", 2, localStringBuilder.toString());
    }
    ((IFriendHandlerService)this.g.getRuntimeService(IFriendHandlerService.class, "")).requestUserAddFriendSetting(this.l, this.n, i1, this.m, this.i);
  }
  
  private void h()
  {
    if (QLog.isColorLevel()) {
      QLog.i("addFriendTag", 2, "checkAccountDiff");
    }
    if (!TextUtils.isEmpty(b()))
    {
      OpenID localOpenID;
      if (this.m == null) {
        localOpenID = null;
      } else {
        localOpenID = OpenIdHelper.a(this.g).a(this.m);
      }
      if ((localOpenID != null) && (!TextUtils.isEmpty(localOpenID.openID)))
      {
        if (!b().equals(localOpenID.openID))
        {
          c();
          return;
        }
        g();
        return;
      }
      f();
      this.a = new Handler();
      this.a.postDelayed(new AddFriendCheckFragment.2(this), 3000L);
      if (this.m != null) {
        OpenIdHelper.a(this.g).a(this.m, new AddFriendCheckFragment.3(this));
      }
    }
  }
  
  private void i()
  {
    if ((this.s != null) && (this.t != 0))
    {
      Object localObject1 = (Bundle)((IAddFriendTempApi)QRoute.api(IAddFriendTempApi.class)).getValue("SecWarningCfg", "AlertTitle", 147, this.t);
      if (localObject1 != null) {
        localObject1 = ((Bundle)localObject1).getString("AlertTitle");
      } else {
        localObject1 = null;
      }
      Object localObject2 = (Bundle)((IAddFriendTempApi)QRoute.api(IAddFriendTempApi.class)).getValue("SecWarningCfg", "AlertText", 147, this.t);
      Object localObject4;
      if (localObject2 != null) {
        localObject4 = ((Bundle)localObject2).getString("AlertText");
      } else {
        localObject4 = null;
      }
      localObject2 = (Bundle)((IAddFriendTempApi)QRoute.api(IAddFriendTempApi.class)).getValue("SecWarningCfg", "AlertLeftBtnText", 147, this.t);
      if (localObject2 != null) {
        localObject2 = ((Bundle)localObject2).getString("AlertLeftBtnText");
      } else {
        localObject2 = null;
      }
      Object localObject3 = (Bundle)((IAddFriendTempApi)QRoute.api(IAddFriendTempApi.class)).getValue("SecWarningCfg", "AlertRightBtnText", 147, this.t);
      if (localObject3 != null) {
        localObject3 = ((Bundle)localObject3).getString("AlertRightBtnText");
      } else {
        localObject3 = null;
      }
      Object localObject5 = localObject1;
      int i1;
      if (localObject1 == null)
      {
        if (this.t == 1) {
          i1 = 2131916139;
        } else {
          i1 = 2131916143;
        }
        localObject5 = getString(i1);
      }
      localObject1 = localObject4;
      if (localObject4 == null)
      {
        i1 = this.t;
        if (i1 == 1) {
          localObject1 = getString(2131916140);
        } else if (i1 == 2) {
          localObject1 = getString(2131916138);
        } else if (i1 == 3) {
          localObject1 = getString(2131916142);
        } else if (i1 == 4) {
          localObject1 = getString(2131916141);
        } else if (i1 == 5) {
          localObject1 = getString(2131916136);
        } else {
          localObject1 = getString(2131916137);
        }
      }
      if (localObject2 == null)
      {
        if (this.t == 1)
        {
          this.d = null;
          localObject4 = localObject2;
        }
        else
        {
          localObject4 = getString(2131916135);
        }
      }
      else
      {
        localObject4 = localObject2;
        if (TextUtils.isEmpty(((String)localObject2).trim()))
        {
          this.d = null;
          localObject4 = localObject2;
        }
      }
      if (localObject3 == null)
      {
        if (this.t == 1) {
          localObject2 = getString(2131916134);
        } else {
          localObject2 = getString(2131916133);
        }
      }
      else
      {
        localObject2 = localObject3;
        if (TextUtils.isEmpty(((String)localObject3).trim()))
        {
          this.e = null;
          localObject2 = localObject3;
        }
      }
      this.s.setTitle((String)localObject5);
      this.s.setMessage((CharSequence)localObject1);
      this.s.setNegativeButton((String)localObject4, this.d);
      this.s.setPositiveButton((String)localObject2, this.e);
      if ((this.d == null) || (this.e == null)) {
        this.s.findViewById(2131429769).setVisibility(8);
      }
    }
  }
  
  private void j()
  {
    if (k())
    {
      if (QLog.isColorLevel()) {
        QLog.d("AddFriendCheckFragment", 2, "showRefuseAddFriendDialog is finishing return");
      }
      return;
    }
    QQCustomDialog localQQCustomDialog = DialogUtil.a(getActivity(), 230);
    localQQCustomDialog.setTitle(getString(2131886222));
    localQQCustomDialog.setMessage(getString(2131915651));
    localQQCustomDialog.setCancelable(false);
    localQQCustomDialog.setCanceledOnTouchOutside(false);
    Window localWindow = localQQCustomDialog.getWindow();
    if (localWindow != null)
    {
      localWindow.setDimAmount(0.5F);
      localWindow.addFlags(2);
    }
    localQQCustomDialog.setPositiveButton(2131892267, new AddFriendCheckFragment.5(this)).setNegativeButton(null, null).show();
  }
  
  private boolean k()
  {
    return (getActivity() == null) || (getActivity().isFinishing());
  }
  
  void a(int paramInt1, boolean paramBoolean, ArrayList<String> paramArrayList, int paramInt2)
  {
    if (k()) {
      return;
    }
    this.p = paramInt1;
    if ((this.n == 3024) && (paramInt1 == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("AddFriendCheckFragment", 2, "startVerifyActivity() from applets add friend and friendSetting is 0 ");
      }
      if (NetworkUtil.isNetSupport(getActivity()))
      {
        paramInt2 = getActivity().getIntent().getIntExtra("sub_source_id", 0);
        ((IFriendHandlerService)this.g.getRuntimeService(IFriendHandlerService.class, "")).requestAddFriend(this.l, this.m, paramInt1, (byte)0, "", this.n, paramInt2, false, null, false, null, this.r, getActivity().getIntent().getBundleExtra("flc_extra_param"), false);
        return;
      }
      QQToast.makeText(this.g.getApplication(), 2131892104, 0).show(getQBaseActivity().getTitleBarHeight());
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtras(getActivity().getIntent());
    localIntent.putExtra("param_mode", 0);
    localIntent.putExtra("friend_setting", paramInt1);
    localIntent.putExtra("contact_bothway", paramBoolean);
    localIntent.putExtra("user_question", paramArrayList);
    localIntent.putExtra("sort_id", this.n);
    localIntent.putExtra("extra", this.m);
    localIntent.putExtra("entrance", this.u);
    paramArrayList = this.v;
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      paramArrayList = this.v.iterator();
      while (paramArrayList.hasNext()) {
        ((BaseAddFriendProcessor)paramArrayList.next()).a(localIntent, getActivity(), this.l, paramInt2);
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
  
  protected void c()
  {
    if (k()) {
      return;
    }
    Object localObject = this.c;
    if ((localObject != null) && (!((QQCustomDialog)localObject).isShowing()) && (!getActivity().isFinishing()))
    {
      this.c.show();
      return;
    }
    this.c = DialogUtil.a(getActivity(), 230);
    this.c.setMessage(2131892939);
    this.c.setTitle(2131889094);
    localObject = new AddFriendCheckFragment.4(this);
    this.c.setNegativeButton(2131887648, (DialogInterface.OnClickListener)localObject);
    this.c.setPositiveButton(2131892907, (DialogInterface.OnClickListener)localObject);
    if (!getActivity().isFinishing()) {
      this.c.show();
    }
  }
  
  public boolean needImmersive()
  {
    return false;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (k()) {
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
      localIntent.putExtra("uin", this.l);
    }
    getActivity().setResult(paramInt2, localIntent);
    getActivity().finish();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.g = ((AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null));
    this.v = new InjectHelper().a(this.g);
    if (k()) {
      return;
    }
    paramBundle = getActivity().getIntent();
    this.k = paramBundle.getIntExtra("k_uin_type", 0);
    this.l = paramBundle.getStringExtra("uin");
    this.q = paramBundle.getStringExtra("last_activity");
    this.r = paramBundle.getStringExtra("src_name");
    this.u = paramBundle.getIntExtra("entrance", -1);
    String str = this.l;
    if ((str != null) && (str.length() >= 5))
    {
      this.i = hashCode();
      if (this.k == 4)
      {
        QLog.e("AddFriendCheckFragment", 1, "AddFriendCheckFragment call error");
        return;
      }
      e();
      return;
    }
    this.n = paramBundle.getIntExtra("source_id", 3999);
    int i1 = this.n;
    if ((i1 != 3078) && (i1 != 3079))
    {
      if (QLog.isColorLevel()) {
        QLog.d("AddFriendCheckFragment", 2, "uin should not be null, activity finish");
      }
      getActivity().finish();
      return;
    }
    d();
  }
  
  public void onDestroy()
  {
    b(false);
    FriendObserver localFriendObserver = this.f;
    if (localFriendObserver != null) {
      this.g.removeObserver(localFriendObserver);
    }
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.addfriend.ui.AddFriendCheckFragment
 * JD-Core Version:    0.7.0.1
 */