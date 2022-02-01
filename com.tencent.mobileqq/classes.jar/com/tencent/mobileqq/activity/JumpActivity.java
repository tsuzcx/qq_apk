package com.tencent.mobileqq.activity;

import Override;
import aeen;
import aeeo;
import aeep;
import aeeq;
import aeer;
import aees;
import aeet;
import aeeu;
import aeev;
import aeew;
import aeey;
import aeez;
import aefa;
import aefb;
import aefc;
import aefd;
import aefe;
import aeff;
import aefg;
import aefh;
import aefi;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.RelativeLayout;
import aobq;
import aoud;
import avjl;
import bheh;
import bhfa;
import bkyc;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqprotect.qsec.QSecFramework;
import java.util.HashMap;
import mqq.observer.WtloginObserver;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;

public class JumpActivity
  extends BaseActivity
  implements DialogInterface.OnDismissListener, Handler.Callback, avjl
{
  public static int a;
  public static HashMap<String, Integer> a;
  public static String[] a;
  public static boolean e;
  public static boolean f;
  public static volatile boolean g;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  public Intent a;
  public HandlerThread a;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  public aobq a;
  private bhfa jdField_a_of_type_Bhfa;
  public String a;
  public WtloginObserver a;
  public final MqqHandler a;
  public boolean a;
  private BroadcastReceiver b;
  public Intent b;
  public String b;
  public MqqHandler b;
  public boolean b;
  public String c;
  public boolean c;
  public String d;
  public boolean d;
  
  static
  {
    jdField_a_of_type_Int = -1;
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "mqq", "mqqapi", "mqqmdpass", "mqqwpa", "mqqopensdkapi", "mqqflyticket", "wtloginmqq", "imto", "mqqtribe", "mqqvoipivr", "mqqverifycode", "mqqdevlock", "qapp", "qqwifi", "mqqconnect", "qqstory", "mqqconferenceflyticket", "mqqavshare" };
  }
  
  public JumpActivity()
  {
    this.jdField_d_of_type_JavaLangString = "";
    this.jdField_a_of_type_MqqOsMqqHandler = new bkyc(Looper.getMainLooper(), this, true);
    this.jdField_a_of_type_MqqObserverWtloginObserver = new aeen(this);
  }
  
  public static String a(Context paramContext)
  {
    return aoud.a(paramContext);
  }
  
  public static void a(Context paramContext, Intent paramIntent)
  {
    aoud.a(paramContext, paramIntent);
  }
  
  public static void a(String paramString, boolean paramBoolean)
  {
    try
    {
      aoud.a(paramString, paramBoolean);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  private void a(boolean paramBoolean, Intent paramIntent)
  {
    aoud.a(this, paramBoolean, paramIntent);
  }
  
  public static boolean a(String paramString)
  {
    return aoud.a(paramString);
  }
  
  private boolean b(Intent paramIntent)
  {
    return (aoud.c(this, paramIntent)) && (aoud.d(this, paramIntent)) && (aoud.e(this, paramIntent));
  }
  
  public static boolean b(String paramString)
  {
    if (jdField_a_of_type_JavaUtilHashMap != null) {
      return (1 << ((Integer)jdField_a_of_type_JavaUtilHashMap.get(paramString)).intValue() & jdField_a_of_type_Int) != 0;
    }
    return false;
  }
  
  public static void g(Intent paramIntent)
  {
    aoud.a(paramIntent);
  }
  
  private static void j(Intent paramIntent)
  {
    aoud.b(paramIntent);
  }
  
  public static void p()
  {
    a(BaseApplicationImpl.sApplication.getSharedPreferences("Jump_Action", 0).getString("JASwitch", "FFFFFFFF"), false);
  }
  
  private void r()
  {
    if (this.jdField_a_of_type_AndroidViewViewGroup != null) {
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
    }
  }
  
  public int a(Bundle paramBundle)
  {
    return aoud.a(this, paramBundle);
  }
  
  public int a(Bundle paramBundle, HashMap<String, String> paramHashMap)
  {
    return aoud.a(this, paramBundle, paramHashMap);
  }
  
  public int a(Bundle paramBundle, HashMap<String, String> paramHashMap, Uri paramUri, String paramString)
  {
    return aoud.a(this, paramBundle, paramHashMap, paramUri, paramString);
  }
  
  public int a(HashMap<String, String> paramHashMap)
  {
    return aoud.a(this, paramHashMap);
  }
  
  public aeer a(int paramInt)
  {
    QLog.d("JumpAction", 1, "createPlugin pluginKey: " + paramInt);
    switch (paramInt)
    {
    default: 
      QLog.d("JumpAction", 1, "createPlugin pluginKey: " + paramInt + " not match");
      return null;
    case 800: 
    case 880: 
      return new aeev(this);
    case 18: 
      return new aees(this);
    case 19: 
      return new aeew(this);
    case 20: 
      return new aeff(this);
    case 21: 
      return new aefh(this);
    case 22: 
      return new aefg(this);
    case 26: 
      return new aefe(this);
    case 27: 
      return new aefd(this);
    case 24: 
      return new aeet(this);
    case 1: 
      return new aeeu(this);
    case 2: 
      return new aefc(this);
    case 571: 
      return new aefa(this);
    case 572: 
      return new aeez(this);
    case 25: 
      return new aefi(this);
    case 570: 
      return new aeey(this);
    }
    return new aefb(this);
  }
  
  @NotNull
  public Boolean a()
  {
    return QSecFramework.a().a(1003);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver == null)
    {
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = new aeeo(this);
      IntentFilter localIntentFilter = new IntentFilter("ShareToQZoneAndFinishTheLastActivity");
      registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Object localObject = null;
    if (this.jdField_a_of_type_Aobq != null) {
      this.jdField_a_of_type_Aobq = null;
    }
    if (paramIntent != null) {
      localObject = paramIntent.getExtras();
    }
    if (localObject != null)
    {
      paramIntent = ((Bundle)localObject).getString("latitude");
      localObject = ((Bundle)localObject).getString("longitude");
      if (this.c) {
        aoud.a(this, "ret=0&lon=" + (String)localObject + "&lat=" + paramIntent);
      }
      finish();
    }
  }
  
  public void a(Intent paramIntent)
  {
    aoud.e(this, paramIntent);
  }
  
  public void a(Intent paramIntent, Bundle paramBundle)
  {
    aoud.a(this, paramIntent, paramBundle);
  }
  
  public void a(Bundle paramBundle)
  {
    aoud.b(this, paramBundle);
  }
  
  public void a(boolean paramBoolean)
  {
    aoud.a(this, paramBoolean);
  }
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    aoud.a(this, paramBoolean, paramInt1, paramInt2, paramString1, paramString2);
  }
  
  public void a(boolean paramBoolean1, String paramString, boolean paramBoolean2)
  {
    aoud.a(this, paramBoolean1, paramString, paramBoolean2);
  }
  
  protected boolean a(Intent paramIntent)
  {
    return (b(paramIntent)) && (aoud.f(this, paramIntent));
  }
  
  public boolean a(bheh parambheh)
  {
    return aoud.a(this.app, parambheh);
  }
  
  public void b()
  {
    if (this.jdField_b_of_type_AndroidContentBroadcastReceiver == null)
    {
      this.jdField_b_of_type_AndroidContentBroadcastReceiver = new aeep(this);
      IntentFilter localIntentFilter = new IntentFilter("BroadcastReceiverFinishActivity");
      registerReceiver(this.jdField_b_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
    }
  }
  
  public void b(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((-1 == paramInt2) && (paramIntent != null))
    {
      paramIntent = paramIntent.getStringExtra("roomId");
      if (paramIntent != null)
      {
        aeeq localaeeq = new aeeq(this);
        if (ChatActivityUtils.a(this.app, this, 3000, paramIntent, true, true, localaeeq, null)) {
          finish();
        }
      }
      return;
    }
    finish();
  }
  
  public void b(Intent paramIntent)
  {
    aoud.g(this, paramIntent);
  }
  
  public void b(boolean paramBoolean)
  {
    Intent localIntent = aoud.a(this, paramBoolean);
    if (localIntent == null) {
      return;
    }
    aoud.a(this, localIntent, 1);
  }
  
  public void b(boolean paramBoolean1, String paramString, boolean paramBoolean2)
  {
    aoud.b(this, paramBoolean1, paramString, paramBoolean2);
  }
  
  public boolean b(bheh parambheh)
  {
    return aoud.a(this, parambheh);
  }
  
  public void c()
  {
    aoud.b(this);
  }
  
  public void c(int paramInt1, int paramInt2, Intent paramIntent)
  {
    a(true, paramIntent);
  }
  
  public void c(Intent paramIntent)
  {
    aoud.h(this, paramIntent);
  }
  
  public void c(boolean paramBoolean)
  {
    aoud.c(this, paramBoolean);
  }
  
  public void d()
  {
    if (this.c) {
      aoud.a(this, "HexUtil.bytes2HexStr(fileKey)");
    }
    finish();
  }
  
  public void d(int paramInt1, int paramInt2, Intent paramIntent)
  {
    new MqqHandler(Looper.getMainLooper()).postDelayed(new JumpActivity.6(this, paramIntent), 10L);
  }
  
  public void d(Intent paramIntent)
  {
    aoud.i(this, paramIntent);
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
    StringBuilder localStringBuilder = new StringBuilder().append("JumpActivity onActivityResult,requestCode=").append(paramInt1).append(",resultCode=").append(paramInt2).append(",data=");
    Object localObject;
    if (paramIntent != null)
    {
      localObject = paramIntent.toString();
      QLog.d("JumpAction", 1, (String)localObject);
      super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
      if (paramInt2 != -1) {
        break label147;
      }
    }
    label147:
    do
    {
      try
      {
        localObject = a(paramInt1);
        if (localObject == null)
        {
          QLog.e("JumpAction", 1, "doOnActivityResult: result plugin not exist");
          finish();
          return;
          localObject = "null";
          break;
        }
        ((aeer)localObject).a(paramInt1, paramInt2, paramIntent);
        return;
      }
      catch (Exception paramIntent)
      {
        QLog.e("JumpAction", 1, "doOnActivityResult error: " + paramIntent.getMessage());
        return;
      }
      if (paramInt1 == 25)
      {
        a(false, paramIntent);
        return;
      }
    } while (paramInt1 == 23);
    finish();
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    this.mActNeedImmersive = false;
    this.mNeedStatusTrans = false;
    getWindow().addFlags(67108864);
    try
    {
      super.doOnCreate(paramBundle);
      QLog.d("JumpAction", 1, "JumpActivity doOnCreate()");
      paramBundle = getIntent();
      if (paramBundle == null)
      {
        QLog.d("JumpAction", 1, "onCreate intent is null");
        finish();
        return false;
      }
      j(paramBundle);
      this.jdField_a_of_type_Bhfa = new bhfa();
      this.jdField_a_of_type_Bhfa.a(this.app, this, paramBundle);
      boolean bool = a(paramBundle);
      return bool;
    }
    catch (Exception paramBundle)
    {
      QLog.e("JumpAction", 1, "doOnCreate|exp:" + paramBundle.getMessage());
      finish();
    }
    return false;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    e = false;
    f = false;
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null) {
      unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
    }
    if (this.jdField_b_of_type_AndroidContentBroadcastReceiver != null) {
      unregisterReceiver(this.jdField_b_of_type_AndroidContentBroadcastReceiver);
    }
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(2);
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(1);
    r();
    if (this.jdField_b_of_type_MqqOsMqqHandler != null)
    {
      this.jdField_b_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_AndroidOsHandlerThread.quit();
      this.jdField_a_of_type_AndroidOsHandlerThread = null;
    }
    if (this.jdField_a_of_type_Bhfa != null)
    {
      this.jdField_a_of_type_Bhfa.a(null);
      this.jdField_a_of_type_Bhfa = null;
    }
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    if (this.jdField_d_of_type_Boolean) {
      finish();
    }
  }
  
  public void e()
  {
    c(false);
  }
  
  public void e(Intent paramIntent)
  {
    aoud.a(this, paramIntent, this.mRuntime);
  }
  
  public void f()
  {
    b(false);
  }
  
  public void f(Intent paramIntent)
  {
    aoud.c(this, paramIntent);
  }
  
  public void g()
  {
    b(false, null, true);
  }
  
  public void h()
  {
    b(true, null, false);
  }
  
  public void h(Intent paramIntent)
  {
    aoud.j(this, paramIntent);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      r();
      continue;
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(2);
      if ((paramMessage.obj instanceof Intent))
      {
        int i = paramMessage.arg1;
        Intent localIntent = (Intent)paramMessage.obj;
        r();
        if (i == 0)
        {
          if (!aoud.a(this)) {
            a(localIntent.getExtras());
          }
        }
        else if (!aoud.a(this))
        {
          Bundle localBundle = localIntent.getExtras();
          paramMessage = localBundle;
          if (localBundle == null) {
            paramMessage = new Bundle();
          }
          a(localIntent, paramMessage);
        }
      }
    }
  }
  
  public void i()
  {
    a(false, null, true);
  }
  
  public void i(Intent paramIntent)
  {
    aoud.n(this, paramIntent);
  }
  
  public void j()
  {
    a(true, null, false);
  }
  
  public void k()
  {
    a(false);
  }
  
  public void l()
  {
    finish();
  }
  
  public void m()
  {
    if (this.jdField_a_of_type_AndroidContentIntent != null) {
      aoud.d(this, this.jdField_a_of_type_AndroidContentIntent);
    }
    finish();
  }
  
  public void n()
  {
    if (this.jdField_b_of_type_AndroidContentIntent != null) {
      aoud.f(this, this.jdField_b_of_type_AndroidContentIntent);
    }
    finish();
  }
  
  public void o()
  {
    new MqqHandler(Looper.getMainLooper()).postDelayed(new JumpActivity.5(this), 10L);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    finish();
  }
  
  public void q()
  {
    try
    {
      setContentView(2131561182);
      this.jdField_a_of_type_AndroidViewViewGroup = ((RelativeLayout)findViewById(2131369643));
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("JumpAction", 1, localThrowable, new Object[0]);
    }
  }
  
  public void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
  
  public boolean showPreview()
  {
    if (aoud.b(this)) {
      return true;
    }
    return super.showPreview();
  }
  
  public void startActivityForResult(Intent paramIntent, int paramInt, Bundle paramBundle)
  {
    super.startActivityForResult(paramIntent, paramInt, paramBundle);
    if (this.jdField_a_of_type_Bhfa != null)
    {
      this.jdField_a_of_type_Bhfa.a(paramIntent);
      this.jdField_a_of_type_Bhfa = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.JumpActivity
 * JD-Core Version:    0.7.0.1
 */