import android.app.Activity;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.PhoneUnityBindInfoActivity;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.identity.AccountPhoneUnityManager.2;
import com.tencent.mobileqq.app.identity.AccountPhoneUnityManager.4;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.widget.TipsBar;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;
import tencent.im.oidb.cmd0x9ae.cmd0x9ae.AuthTips;
import tencent.im.oidb.cmd0x9ae.cmd0x9ae.RspBody;
import tencent.im.oidb.cmd0x9ae.cmd0x9ae.SmallTips;

public class aoms
  extends aona
{
  private long jdField_a_of_type_Long;
  private Dialog jdField_a_of_type_AndroidAppDialog;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  
  public static TipsBar a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AccountPhoneUnityManager", 2, "init phone unity banner");
    }
    String str = (String)bhhr.a(paramContext, paramQQAppInterface.getAccount(), "phone_unity_banner_tips", "");
    TipsBar localTipsBar = new TipsBar(paramContext);
    localTipsBar.setVisibility(8);
    localTipsBar.a().setText(str);
    localTipsBar.setTipsIcon(paramContext.getResources().getDrawable(2130839340));
    localTipsBar.setOriginalOnClickListener(new aomt(paramContext, paramQQAppInterface));
    bdla.b(paramQQAppInterface, "dc00898", "", "", "0X800B3E9", "0X800B3E9", 0, 0, "", "", "", "");
    return localTipsBar;
  }
  
  /* Error */
  private void b(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: astore_2
    //   4: aload_1
    //   5: ifnonnull +15 -> 20
    //   8: ldc 30
    //   10: iconst_1
    //   11: ldc 114
    //   13: invokestatic 36	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   16: invokestatic 120	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   19: astore_2
    //   20: aload_0
    //   21: getfield 122	aoms:jdField_a_of_type_AndroidContentBroadcastReceiver	Landroid/content/BroadcastReceiver;
    //   24: astore_1
    //   25: aload_1
    //   26: ifnull +24 -> 50
    //   29: ldc 30
    //   31: iconst_1
    //   32: ldc 124
    //   34: invokestatic 36	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   37: aload_2
    //   38: aload_0
    //   39: getfield 122	aoms:jdField_a_of_type_AndroidContentBroadcastReceiver	Landroid/content/BroadcastReceiver;
    //   42: invokevirtual 127	android/content/Context:unregisterReceiver	(Landroid/content/BroadcastReceiver;)V
    //   45: aload_0
    //   46: aconst_null
    //   47: putfield 122	aoms:jdField_a_of_type_AndroidContentBroadcastReceiver	Landroid/content/BroadcastReceiver;
    //   50: aload_0
    //   51: monitorexit
    //   52: return
    //   53: astore_1
    //   54: ldc 30
    //   56: iconst_1
    //   57: iconst_2
    //   58: anewarray 129	java/lang/Object
    //   61: dup
    //   62: iconst_0
    //   63: ldc 131
    //   65: aastore
    //   66: dup
    //   67: iconst_1
    //   68: aload_1
    //   69: invokevirtual 134	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   72: aastore
    //   73: invokestatic 137	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   76: goto -31 -> 45
    //   79: astore_1
    //   80: aload_0
    //   81: monitorexit
    //   82: aload_1
    //   83: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	84	0	this	aoms
    //   0	84	1	paramContext	Context
    //   3	35	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   29	45	53	java/lang/Exception
    //   8	20	79	finally
    //   20	25	79	finally
    //   29	45	79	finally
    //   45	50	79	finally
    //   54	76	79	finally
  }
  
  private boolean c()
  {
    return BaseActivity.sTopActivity instanceof PhoneUnityBindInfoActivity;
  }
  
  private void e()
  {
    QQAppInterface localQQAppInterface = a();
    if (localQQAppInterface == null) {
      QLog.d("AccountPhoneUnityManager", 1, "refresh, app is null");
    }
    do
    {
      return;
      ThreadManager.getUIHandler().postDelayed(new AccountPhoneUnityManager.2(this, localQQAppInterface), 800L);
    } while (!a());
    d();
  }
  
  QQAppInterface a()
  {
    Object localObject = BaseApplicationImpl.sApplication.getRuntime();
    if ((localObject instanceof QQAppInterface))
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)localObject;
      localObject = localQQAppInterface;
      if (!localQQAppInterface.isLogin())
      {
        QLog.e("AccountPhoneUnityManager", 1, "getAppInterface, but not login");
        localObject = null;
      }
      return localObject;
    }
    if (localObject == null) {}
    for (boolean bool = true;; bool = false)
    {
      QLog.e("AccountPhoneUnityManager", 1, new Object[] { "appRuntime is not QQAppInterface, appRuntime is null[", Boolean.valueOf(bool), "]" });
      return null;
    }
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AccountPhoneUnityManager", 2, "onAccountLoginOrSwitch");
    }
    e();
  }
  
  public void a(Activity paramActivity)
  {
    if ((aonc.a(this.jdField_a_of_type_AndroidAppDialog)) && (!(paramActivity instanceof PhoneUnityBindInfoActivity)))
    {
      boolean bool = aonc.a(this.jdField_a_of_type_AndroidAppDialog, paramActivity);
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
      if (QLog.isColorLevel()) {
        QLog.d("AccountPhoneUnityManager", 2, new Object[] { "dialog is showing, current activity is dialog context [", Boolean.valueOf(bool), "] activity : ", paramActivity.getClass().getSimpleName() });
      }
      if ((!bool) && (BaseActivity.sTopActivity != null)) {
        d();
      }
    }
  }
  
  void a(Context paramContext)
  {
    if (paramContext == null) {}
    for (;;)
    {
      try
      {
        QLog.d("AccountPhoneUnityManager", 1, "registerReceiver, context is null");
        return;
      }
      finally {}
      if (this.jdField_a_of_type_AndroidContentBroadcastReceiver == null)
      {
        QLog.d("AccountPhoneUnityManager", 1, "registerReceiver");
        IntentFilter localIntentFilter = new IntentFilter("com.tencent.mobileqq.InvitationWebViewPlugin.accountIdentityNotify");
        this.jdField_a_of_type_AndroidContentBroadcastReceiver = new aomz(null);
        paramContext.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
      }
    }
  }
  
  /* Error */
  public void a(QQAppInterface paramQQAppInterface)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual 255	aoms:b	()Z
    //   6: ifne +21 -> 27
    //   9: invokestatic 28	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   12: ifeq +12 -> 24
    //   15: ldc 30
    //   17: iconst_1
    //   18: ldc_w 257
    //   21: invokestatic 36	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   24: aload_0
    //   25: monitorexit
    //   26: return
    //   27: ldc 30
    //   29: iconst_1
    //   30: ldc_w 259
    //   33: invokestatic 36	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   36: aload_1
    //   37: ldc_w 261
    //   40: invokevirtual 265	com/tencent/mobileqq/app/QQAppInterface:getHandler	(Ljava/lang/Class;)Lmqq/os/MqqHandler;
    //   43: astore_1
    //   44: aload_1
    //   45: ifnull -21 -> 24
    //   48: aload_1
    //   49: ldc_w 266
    //   52: invokevirtual 270	mqq/os/MqqHandler:sendEmptyMessage	(I)Z
    //   55: pop
    //   56: aload_0
    //   57: getstatic 144	com/tencent/mobileqq/app/BaseActivity:sTopActivity	Lcom/tencent/mobileqq/app/BaseActivity;
    //   60: invokevirtual 272	aoms:a	(Landroid/content/Context;)V
    //   63: goto -39 -> 24
    //   66: astore_1
    //   67: aload_0
    //   68: monitorexit
    //   69: aload_1
    //   70: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	71	0	this	aoms
    //   0	71	1	paramQQAppInterface	QQAppInterface
    // Exception table:
    //   from	to	target	type
    //   2	24	66	finally
    //   27	44	66	finally
    //   48	63	66	finally
  }
  
  void a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    try
    {
      QLog.d("AccountPhoneUnityManager", 1, "hideBanner");
      paramQQAppInterface.getHandler(Conversation.class).sendEmptyMessage(1134074);
      paramQQAppInterface = paramQQAppInterface.getAccount();
      bhhr.a(paramContext, paramQQAppInterface, true, "phone_unity_banner_tips", "");
      bhhr.a(paramContext, paramQQAppInterface, true, "phone_unity_banner_tips_need_show", Boolean.valueOf(false));
      return;
    }
    finally
    {
      paramQQAppInterface = finally;
      throw paramQQAppInterface;
    }
  }
  
  void a(QQAppInterface paramQQAppInterface, cmd0x9ae.RspBody paramRspBody)
  {
    boolean bool1 = paramRspBody.bool_need_auth_tips.get();
    Object localObject1 = (cmd0x9ae.AuthTips)paramRspBody.msg_auth_tips.get();
    String str1 = ((cmd0x9ae.AuthTips)localObject1).string_lbutton.get();
    String str2 = ((cmd0x9ae.AuthTips)localObject1).string_rbutton.get();
    String str5 = ((cmd0x9ae.AuthTips)localObject1).string_tips_action.get();
    Object localObject2 = ((cmd0x9ae.AuthTips)localObject1).string_tips_action_url.get();
    String str3 = ((cmd0x9ae.AuthTips)localObject1).string_tips_context.get();
    localObject1 = ((cmd0x9ae.AuthTips)localObject1).string_tips_title.get();
    String str4 = paramRspBody.bytes_jwt.get().toStringUtf8();
    paramRspBody = paramRspBody.msg_small_tips.string_tips_context.get();
    if (QLog.isColorLevel()) {
      QLog.d("AccountPhoneUnityManager", 2, new Object[] { "success, needAuth : ", Boolean.valueOf(bool1), " leftText : ", str1, " rightText : ", str2, " tipsAction : ", str5, " url : ", localObject2, " content : ", str3, " title : ", localObject1, " jwt : ", str4, "tips : ", paramRspBody });
    }
    if (TextUtils.isEmpty(str4))
    {
      QLog.e("AccountPhoneUnityManager", 1, "error : jwt is empty");
      return;
    }
    str5 = aonc.a(str4);
    if (TextUtils.isEmpty(str5))
    {
      QLog.e("AccountPhoneUnityManager", 1, "error : jwt parse error");
      return;
    }
    localObject2 = BaseActivity.sTopActivity;
    if (localObject2 == null)
    {
      QLog.e("AccountPhoneUnityManager", 1, "onPhoneUnityDataResp, but activity is null");
      return;
    }
    String str6 = paramQQAppInterface.getAccount();
    bhhr.a((Context)localObject2, str6, true, "phone_unity_jwt", str4);
    boolean bool2 = aonc.a(this.jdField_a_of_type_AndroidAppDialog);
    if (!bool1)
    {
      QLog.d("AccountPhoneUnityManager", 1, new Object[] { "need auth false, isShowing : ", Boolean.valueOf(bool2) });
      if (bool2) {
        this.jdField_a_of_type_AndroidAppDialog.dismiss();
      }
      a(paramQQAppInterface, (Context)localObject2);
      return;
    }
    if (bool2)
    {
      if ((aonc.a(this.jdField_a_of_type_AndroidAppDialog, (Activity)localObject2)) || (c())) {}
      for (int i = 1; i != 0; i = 0)
      {
        QLog.d("AccountPhoneUnityManager", 1, "dialog is invalid");
        return;
      }
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
    }
    bhhr.a((Context)localObject2, str6, true, "phone_unity_banner_tips", paramRspBody);
    bhhr.a((Context)localObject2, str6, true, "phone_unity_banner_tips_need_show", Boolean.valueOf(true));
    ThreadManager.getUIHandler().postDelayed(new AccountPhoneUnityManager.4(this, str5, str1, str2, str3, (String)localObject1, paramQQAppInterface, (Activity)localObject2), 700L);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, QQAppInterface paramQQAppInterface, Activity paramActivity)
  {
    BaseActivity localBaseActivity;
    try
    {
      if (aonc.a(this.jdField_a_of_type_AndroidAppDialog)) {
        QLog.d("AccountPhoneUnityManager", 1, "dialog is showing");
      }
      for (;;)
      {
        return;
        localBaseActivity = BaseActivity.sTopActivity;
        if ((localBaseActivity != null) && (!localBaseActivity.isFinishing())) {
          break;
        }
        QLog.e("AccountPhoneUnityManager", 1, "create dialog, but activity is finishing or null");
      }
      bool = aonc.a(paramString1);
    }
    finally {}
    boolean bool;
    this.jdField_a_of_type_AndroidAppDialog = aonc.a(localBaseActivity, paramString2, paramString3, paramString4, paramString5, false, new aomv(this, bool, localBaseActivity, paramQQAppInterface), new aomw(this, paramActivity, bool, paramQQAppInterface));
    this.jdField_a_of_type_AndroidAppDialog.show();
    this.jdField_a_of_type_AndroidAppDialog.setOnDismissListener(new aomx(this));
    this.jdField_a_of_type_AndroidAppDialog.setOnCancelListener(new aomy(this));
    if (bool) {}
    for (paramString1 = "0X800B3E6";; paramString1 = "0X800B3E3")
    {
      a(localBaseActivity);
      bdla.b(paramQQAppInterface, "dc00898", "", "", paramString1, paramString1, 0, 0, "", "", "", "");
      break;
    }
  }
  
  boolean a()
  {
    boolean bool1 = true;
    Object localObject = a();
    if (localObject == null) {
      return false;
    }
    if (aonc.a(this.jdField_a_of_type_AndroidAppDialog))
    {
      if (c())
      {
        QLog.d("AccountPhoneUnityManager", 1, new Object[] { "current top activity : ", BaseActivity.sTopActivity.getActivityName(), " is in white list" });
        return false;
      }
      bool1 = aonc.a(this.jdField_a_of_type_AndroidAppDialog, BaseActivity.sTopActivity);
      QLog.d("AccountPhoneUnityManager", 1, new Object[] { "dialog is showing, dialog is top activity[", Boolean.valueOf(bool1), "]" });
      if (!bool1) {
        this.jdField_a_of_type_AndroidAppDialog.dismiss();
      }
      if (!bool1) {}
      for (bool1 = true;; bool1 = false) {
        return bool1;
      }
    }
    localObject = ((QQAppInterface)localObject).getAccount();
    boolean bool2 = aonc.a((String)bhhr.a(BaseApplicationImpl.getContext(), (String)localObject, "phone_unity_jwt", ""), NetConnInfoCenter.getServerTime());
    if (bool2) {
      QLog.d("AccountPhoneUnityManager", 1, "dont need refresh, not time");
    }
    if (!bool2) {}
    for (;;)
    {
      return bool1;
      bool1 = false;
    }
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AccountPhoneUnityManager", 2, "onForegroundSwitch");
    }
    e();
  }
  
  /* Error */
  boolean b()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: invokevirtual 150	aoms:a	()Lcom/tencent/mobileqq/app/QQAppInterface;
    //   8: astore_2
    //   9: aload_2
    //   10: ifnonnull +7 -> 17
    //   13: aload_0
    //   14: monitorexit
    //   15: iload_1
    //   16: ireturn
    //   17: aload_2
    //   18: invokevirtual 42	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   21: astore_2
    //   22: invokestatic 458	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   25: aload_2
    //   26: ldc_w 281
    //   29: iconst_0
    //   30: invokestatic 198	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   33: invokestatic 51	bhhr:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   36: checkcast 194	java/lang/Boolean
    //   39: invokevirtual 474	java/lang/Boolean:booleanValue	()Z
    //   42: istore_1
    //   43: goto -30 -> 13
    //   46: astore_2
    //   47: aload_0
    //   48: monitorexit
    //   49: aload_2
    //   50: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	51	0	this	aoms
    //   1	42	1	bool	boolean
    //   8	18	2	localObject1	Object
    //   46	4	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   4	9	46	finally
    //   17	43	46	finally
  }
  
  public void c()
  {
    b(BaseActivity.sTopActivity);
  }
  
  void d()
  {
    QQAppInterface localQQAppInterface = a();
    if (localQQAppInterface == null) {
      return;
    }
    bcvh.c(localQQAppInterface, new aomu(this, localQQAppInterface));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aoms
 * JD-Core Version:    0.7.0.1
 */