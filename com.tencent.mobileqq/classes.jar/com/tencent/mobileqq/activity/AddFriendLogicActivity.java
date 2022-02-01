package com.tencent.mobileqq.activity;

import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import com.tencent.biz.common.util.OpenIdObserver;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.handler.GetOpenID;
import com.tencent.mobileqq.data.KplHelper;
import com.tencent.mobileqq.data.KplRoleInfo.WZRYUIinfo;
import com.tencent.mobileqq.data.OpenID;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.forward.ForwardSdkShareOption;
import com.tencent.mobileqq.friend.api.IFriendHandlerService;
import com.tencent.mobileqq.friend.observer.FriendObserver;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import com.tencent.mobileqq.utils.AntiFraudConfigFileUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.Serializable;
import java.util.ArrayList;

public class AddFriendLogicActivity
  extends BaseActivity
{
  public static String a = "";
  public static boolean d = false;
  protected Handler b;
  protected boolean c;
  FriendObserver e = new AddFriendLogicActivity.3(this);
  DialogInterface.OnClickListener f = new AddFriendLogicActivity.4(this);
  DialogInterface.OnClickListener g = new AddFriendLogicActivity.5(this);
  DialogInterface.OnDismissListener h = new AddFriendLogicActivity.6(this);
  protected QQCustomDialog i = null;
  protected OpenIdObserver j = new AddFriendLogicActivity.9(this);
  private int k;
  private String l;
  private String m;
  private int n = -1;
  private int o;
  private String p;
  private String q;
  private int r;
  private QQProgressDialog s;
  private int t = -1;
  private QQCustomDialog u;
  private int v;
  
  public static Intent a(Context paramContext, String paramString1, String paramString2, short paramShort, int paramInt, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    return a(paramContext, paramString1, paramString2, paramShort, paramInt, paramString3, paramString4, paramString5, paramString6, null, paramString7, null);
  }
  
  public static Intent a(Context paramContext, String paramString1, String paramString2, short paramShort, int paramInt, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9)
  {
    paramContext = new Intent(paramContext, AddFriendLogicActivity.class);
    paramContext.putExtra("uin", paramString1);
    paramContext.putExtra("k_uin_type", 4);
    paramContext.putExtra("group_option", paramShort);
    paramContext.putExtra("troop_question", paramString3);
    paramContext.putExtra("troop_answer", paramString4);
    paramContext.putExtra("nick_name", paramString2);
    paramContext.putExtra("stat_option", paramInt);
    paramContext.putExtra("param_return_addr", paramString5);
    paramContext.putExtra("last_activity", paramString6);
    paramContext.putExtra("authKey", paramString7);
    paramContext.putExtra("authSig", paramString8);
    paramContext.putExtra("key_param_homework_intro_str", paramString9);
    return paramContext;
  }
  
  private void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("dismissOrHideProgress hide: ");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.i("qqBaseActivity", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.s;
    if (localObject != null)
    {
      if (!((QQProgressDialog)localObject).isShowing()) {
        return;
      }
      if (paramBoolean)
      {
        this.s.hide();
        return;
      }
      this.s.dismiss();
    }
  }
  
  private boolean a(int paramInt, String paramString)
  {
    if (paramInt != 1) {
      if (paramInt != 2)
      {
        if (paramInt != 3)
        {
          finish();
          return false;
        }
        if (this.r == 3999)
        {
          this.r = 3016;
          if (QLog.isColorLevel()) {
            QLog.d("Q.contacts.", 2, "openId source id is default!");
          }
        }
      }
      else if (this.r == 3999)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.contacts.", 2, "mobile source id is default!");
        }
        this.r = 3006;
      }
    }
    try
    {
      Long.parseLong(paramString);
      if (((FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).n(paramString))
      {
        QQToast.makeText(this.app.getApplication(), 2131886641, 0).show(getTitleBarHeight());
        finish();
        return false;
      }
      if (!NetworkUtil.isNetSupport(this))
      {
        QQToast.makeText(this.app.getApplication(), 2131892104, 0).show(getTitleBarHeight());
        finish();
        return false;
      }
      return true;
    }
    catch (Throwable paramString) {}
    return false;
  }
  
  private void b(int paramInt, String paramString)
  {
    if (getIntent() != null)
    {
      if (getIntent().getIntExtra("source_id", 3999) != 3090) {
        return;
      }
      try
      {
        ForwardSdkShareOption.a(this, true, "action_game_make_friend", Long.valueOf(getIntent().getStringExtra("extra")).longValue(), paramInt, paramString);
        return;
      }
      catch (Exception paramString)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("feedBackToGameSDK error = ");
        localStringBuilder.append(paramString);
        QLog.e("AddFriendLogicActivity", 1, localStringBuilder.toString());
        return;
      }
    }
    QLog.e("AddFriendLogicActivity", 1, "feedBackToGameSDK intent = null");
  }
  
  private boolean b()
  {
    Object localObject1 = getIntent();
    this.r = ((Intent)localObject1).getIntExtra("source_id", 3999);
    this.q = ((Intent)localObject1).getStringExtra("extra");
    if (!a(this.o, this.p)) {
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.i("qqBaseActivity", 2, "addFriend");
    }
    localObject1 = ((Intent)localObject1).getStringExtra("nick_name");
    if ((this.r == 3004) && (localObject1 == null) && (!TextUtils.isEmpty(this.q)))
    {
      localObject1 = this.app.getEntityManagerFactory().createEntityManager();
      Object localObject2 = (TroopMemberInfo)((EntityManager)localObject1).find(TroopMemberInfo.class, new String[] { this.q, this.p });
      if (localObject2 != null)
      {
        localObject2 = ((TroopMemberInfo)localObject2).friendnick;
        getIntent().putExtra("nick_name", (String)localObject2);
      }
      ((EntityManager)localObject1).close();
    }
    addObserver(this.e);
    if (this.o == 1)
    {
      if (QLog.isColorLevel()) {
        QLog.i("qqBaseActivity", 2, "queryUinSafetyFlag");
      }
      c();
      ((IFriendHandlerService)this.app.getRuntimeService(IFriendHandlerService.class)).requestUinSafetyFlag(Long.parseLong(this.p));
      return true;
    }
    if (this.r == 3024)
    {
      d();
      return true;
    }
    if (!TextUtils.isEmpty(a))
    {
      e();
      return true;
    }
    d();
    return true;
  }
  
  private void c()
  {
    if (QLog.isColorLevel()) {
      QLog.i("qqBaseActivity", 2, "showProgress");
    }
    if (this.s == null)
    {
      this.s = new QQProgressDialog(this, getTitleBarHeight());
      this.s.a(new AddFriendLogicActivity.1(this));
    }
    this.s.c(2131890041);
    if (!isFinishing()) {
      this.s.show();
    }
  }
  
  private void d()
  {
    if (QLog.isColorLevel()) {
      QLog.i("qqBaseActivity", 2, "getAddFriendSetting");
    }
    c();
    int i1 = getIntent().getIntExtra("sub_source_id", 0);
    ((IFriendHandlerService)this.app.getRuntimeService(IFriendHandlerService.class)).requestUserAddFriendSetting(this.p, this.r, i1, this.q, this.k);
  }
  
  private void e()
  {
    if (QLog.isColorLevel()) {
      QLog.i("addFriendTag", 2, "checkAccountDiff");
    }
    if (!TextUtils.isEmpty(a))
    {
      OpenID localOpenID;
      if (this.q == null) {
        localOpenID = null;
      } else {
        localOpenID = this.app.getMsgHandler().e(this.q);
      }
      if ((localOpenID != null) && (!TextUtils.isEmpty(localOpenID.openID)))
      {
        if (!a.equals(localOpenID.openID))
        {
          a();
          return;
        }
        d();
        return;
      }
      c();
      this.b = new Handler();
      this.b.postDelayed(new AddFriendLogicActivity.2(this), 3000L);
      this.app.addObserver(this.j);
      if (this.q != null) {
        GetOpenID.a(this.app.getMsgHandler(), this.q);
      }
    }
  }
  
  private boolean f()
  {
    if (!NetworkUtil.isNetSupport(this))
    {
      QQToast.makeText(this.app.getApplication(), 2131892104, 0).show(getTitleBarHeight());
      finish();
      return false;
    }
    Intent localIntent = new Intent(this, AddFriendVerifyActivity.class);
    localIntent.putExtras(getIntent());
    localIntent.putExtra("param_mode", 0);
    localIntent.putExtra("contact_bothway", true);
    if (getIntent().getStringExtra("param_return_addr") != null)
    {
      startActivity(localIntent);
      finish();
      return true;
    }
    startActivityForResult(localIntent, 1);
    return true;
  }
  
  private void g()
  {
    if ((this.u != null) && (this.v != 0))
    {
      Object localObject1 = (Bundle)AntiFraudConfigFileUtil.a().a("SecWarningCfg", "AlertTitle", 147, this.v);
      if (localObject1 != null) {
        localObject1 = ((Bundle)localObject1).getString("AlertTitle");
      } else {
        localObject1 = null;
      }
      Object localObject2 = (Bundle)AntiFraudConfigFileUtil.a().a("SecWarningCfg", "AlertText", 147, this.v);
      Object localObject4;
      if (localObject2 != null) {
        localObject4 = ((Bundle)localObject2).getString("AlertText");
      } else {
        localObject4 = null;
      }
      localObject2 = (Bundle)AntiFraudConfigFileUtil.a().a("SecWarningCfg", "AlertLeftBtnText", 147, this.v);
      if (localObject2 != null) {
        localObject2 = ((Bundle)localObject2).getString("AlertLeftBtnText");
      } else {
        localObject2 = null;
      }
      Object localObject3 = (Bundle)AntiFraudConfigFileUtil.a().a("SecWarningCfg", "AlertRightBtnText", 147, this.v);
      if (localObject3 != null) {
        localObject3 = ((Bundle)localObject3).getString("AlertRightBtnText");
      } else {
        localObject3 = null;
      }
      Object localObject5 = localObject1;
      int i1;
      if (localObject1 == null)
      {
        if (this.v == 1) {
          i1 = 2131916139;
        } else {
          i1 = 2131916143;
        }
        localObject5 = getString(i1);
      }
      localObject1 = localObject4;
      if (localObject4 == null)
      {
        i1 = this.v;
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
        if (this.v == 1)
        {
          this.f = null;
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
          this.f = null;
          localObject4 = localObject2;
        }
      }
      if (localObject3 == null)
      {
        if (this.v == 1) {
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
          this.g = null;
          localObject2 = localObject3;
        }
      }
      this.u.setTitle((String)localObject5);
      this.u.setMessage((CharSequence)localObject1);
      this.u.setNegativeButton((String)localObject4, this.f);
      this.u.setPositiveButton((String)localObject2, this.g);
      if ((this.f == null) || (this.g == null)) {
        this.u.findViewById(2131429769).setVisibility(8);
      }
    }
  }
  
  private boolean h()
  {
    Object localObject = getIntent();
    String str = ((Intent)localObject).getStringExtra("uin");
    int i1 = ((Intent)localObject).getShortExtra("group_option", (short)2);
    if (((TroopManager)this.app.getManager(QQManagerFactory.TROOP_MANAGER)).f(str) != null)
    {
      QQToast.makeText(this.app.getApplication(), 2131886638, 0).show(getTitleBarHeight());
      finish();
      return false;
    }
    if (i1 == 3)
    {
      localObject = getIntent().getStringExtra("nick_name");
      if ((localObject == null) || (((String)localObject).length() == 0)) {
        getString(2131891071);
      }
      QQToast.makeText(this.app.getApplication(), 2131917537, 0).show(getTitleBarHeight());
      finish();
      return false;
    }
    localObject = new Intent(this, AddFriendVerifyActivity.class);
    ((Intent)localObject).putExtras(getIntent());
    ((Intent)localObject).putExtra("friend_setting", 9);
    if (getIntent().getStringExtra("param_return_addr") != null)
    {
      ((Intent)localObject).putExtra("param_return_addr", getIntent().getStringExtra("param_return_addr"));
      startActivity((Intent)localObject);
      finish();
      return false;
    }
    startActivityForResult((Intent)localObject, 1);
    return true;
  }
  
  private void i()
  {
    if (isFinishing())
    {
      if (QLog.isColorLevel()) {
        QLog.d("qqBaseActivity", 2, "showRefuseAddFriendDialog is finishing return");
      }
      return;
    }
    QQCustomDialog localQQCustomDialog = DialogUtil.a(this, 230);
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
    localQQCustomDialog.setPositiveButton(2131892267, new AddFriendLogicActivity.8(this)).setNegativeButton(null, null).show();
  }
  
  protected void a()
  {
    Object localObject = this.i;
    if ((localObject != null) && (!((QQCustomDialog)localObject).isShowing()) && (!isFinishing()))
    {
      this.i.show();
      return;
    }
    this.i = DialogUtil.a(this, 230);
    this.i.setMessage(2131892939);
    this.i.setTitle(2131889094);
    localObject = new AddFriendLogicActivity.7(this);
    this.i.setNegativeButton(2131887648, (DialogInterface.OnClickListener)localObject);
    this.i.setPositiveButton(2131892907, (DialogInterface.OnClickListener)localObject);
    if (!isFinishing()) {
      this.i.show();
    }
  }
  
  void a(int paramInt1, boolean paramBoolean, ArrayList<String> paramArrayList, Class<?> paramClass, int paramInt2)
  {
    this.t = paramInt1;
    if ((this.r == 3024) && (paramInt1 == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("AddFriendLogicActivity", 2, "startVerifyActivity() from applets add friend and friendSetting is 0 ");
      }
      if (NetworkUtil.isNetSupport(this))
      {
        paramInt2 = getIntent().getIntExtra("sub_source_id", 0);
        ((IFriendHandlerService)this.app.getRuntimeService(IFriendHandlerService.class)).requestAddFriend(this.p, this.q, paramInt1, (byte)0, "", this.r, paramInt2, false, null, false, null, this.m, getIntent().getBundleExtra("flc_extra_param"), false);
        return;
      }
      QQToast.makeText(this.app.getApplication(), 2131892104, 0).show(getTitleBarHeight());
      return;
    }
    paramClass = new Intent(this, paramClass);
    paramClass.putExtras(getIntent());
    paramClass.putExtra("param_mode", 0);
    paramClass.putExtra("friend_setting", paramInt1);
    paramClass.putExtra("contact_bothway", paramBoolean);
    paramClass.putExtra("user_question", paramArrayList);
    paramClass.putExtra("sort_id", this.r);
    paramClass.putExtra("extra", this.q);
    paramClass.putExtra("entrance", this.n);
    if (this.r == 3094) {
      paramClass.putExtra("sub_source_id", getIntent().getIntExtra("sub_source_id", 8));
    }
    if ((!paramClass.hasExtra("param_wzry_data")) && (KplHelper.a(this.app, this, this.p, paramInt2)))
    {
      paramArrayList = KplRoleInfo.WZRYUIinfo.buildNickName(getIntent().getStringExtra("nick_name"), KplHelper.a(this.app, this.p));
      Object localObject = KplHelper.a(this.app);
      localObject = KplRoleInfo.WZRYUIinfo.createInfo(this.p, paramArrayList, (String)localObject, 0, 0);
      if (localObject != null)
      {
        paramClass.putExtra("param_wzry_data", (Serializable)localObject);
        paramClass.putExtra("nick_name", paramArrayList);
      }
    }
    if (getIntent().getStringExtra("param_return_addr") != null)
    {
      startActivity(paramClass);
      finish();
      return;
    }
    startActivityForResult(paramClass, 1);
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Intent localIntent = getIntent();
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
      localIntent.putExtra("uin", this.p);
    }
    setResult(paramInt2, localIntent);
    finish();
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    this.mActNeedImmersive = false;
    super.doOnCreate(paramBundle);
    paramBundle = getIntent();
    this.o = paramBundle.getIntExtra("k_uin_type", 0);
    this.p = paramBundle.getStringExtra("uin");
    this.l = paramBundle.getStringExtra("last_activity");
    this.m = paramBundle.getStringExtra("src_name");
    this.n = paramBundle.getIntExtra("entrance", -1);
    String str = this.p;
    if ((str != null) && (str.length() >= 5))
    {
      this.k = hashCode();
      if (this.o == 4) {
        return h();
      }
      return b();
    }
    this.r = paramBundle.getIntExtra("source_id", 3999);
    int i1 = this.r;
    if ((i1 != 3078) && (i1 != 3079))
    {
      if (QLog.isColorLevel()) {
        QLog.d("qqBaseActivity", 2, "uin should not be null, activity finish");
      }
      super.finish();
      return false;
    }
    return f();
  }
  
  protected void doOnDestroy()
  {
    a(false);
    Object localObject = this.e;
    if (localObject != null) {
      removeObserver((BusinessObserver)localObject);
    }
    localObject = this.j;
    if (localObject != null) {
      removeObserver((BusinessObserver)localObject);
    }
    super.doOnDestroy();
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  protected String setLastActivityName()
  {
    String str = this.l;
    if (str != null) {
      return str;
    }
    return super.setLastActivityName();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AddFriendLogicActivity
 * JD-Core Version:    0.7.0.1
 */