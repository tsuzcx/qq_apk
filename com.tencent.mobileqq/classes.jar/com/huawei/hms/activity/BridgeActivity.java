package com.huawei.hms.activity;

import Override;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.Window;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.ui.SafeIntent;
import com.huawei.hms.utils.ResourceLoaderUtil;
import com.huawei.hms.utils.UIUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class BridgeActivity
  extends Activity
{
  public static final String EXTRA_DELEGATE_CLASS_NAME = "intent.extra.DELEGATE_CLASS_OBJECT";
  public static final String EXTRA_DELEGATE_UPDATE_INFO = "intent.extra.update.info";
  public static final String EXTRA_INTENT = "intent.extra.intent";
  public static final String EXTRA_IS_FULLSCREEN = "intent.extra.isfullscreen";
  public static final String EXTRA_RESULT = "intent.extra.RESULT";
  private static final int b = a("ro.build.hw_emui_api_level", 0);
  private IBridgeActivityDelegate a;
  
  private static int a(String paramString, int paramInt)
  {
    try
    {
      Class localClass = Class.forName("android.os.SystemProperties");
      int i = ((Integer)localClass.getDeclaredMethod("getInt", new Class[] { String.class, Integer.TYPE }).invoke(localClass, new Object[] { paramString, Integer.valueOf(paramInt) })).intValue();
      return i;
    }
    catch (ClassNotFoundException paramString)
    {
      HMSLog.e("BridgeActivity", "An exception occurred while reading: EMUI_SDK_INT");
      return paramInt;
    }
    catch (ClassCastException paramString)
    {
      break label56;
    }
    catch (IllegalAccessException paramString)
    {
      break label56;
    }
    catch (IllegalArgumentException paramString)
    {
      break label56;
    }
    catch (NoSuchMethodException paramString)
    {
      break label56;
    }
    catch (InvocationTargetException paramString)
    {
      label56:
      break label56;
    }
  }
  
  private void a()
  {
    requestWindowFeature(1);
    if (b >= 9)
    {
      Window localWindow = getWindow();
      localWindow.addFlags(67108864);
      a(localWindow, true);
    }
  }
  
  private static void a(Window paramWindow, boolean paramBoolean)
  {
    try
    {
      paramWindow.getClass().getMethod("setHwFloating", new Class[] { Boolean.TYPE }).invoke(paramWindow, new Object[] { Boolean.valueOf(paramBoolean) });
      return;
    }
    catch (IllegalAccessException paramWindow)
    {
      HMSLog.e("BridgeActivity", "In setHwFloating, Failed to call Window.setHwFloating()." + paramWindow.getMessage());
      return;
    }
    catch (IllegalArgumentException paramWindow)
    {
      break label37;
    }
    catch (NoSuchMethodException paramWindow)
    {
      break label37;
    }
    catch (InvocationTargetException paramWindow)
    {
      label37:
      break label37;
    }
  }
  
  /* Error */
  private boolean b()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 157	com/huawei/hms/activity/BridgeActivity:getIntent	()Landroid/content/Intent;
    //   4: astore_1
    //   5: aload_1
    //   6: ifnonnull +12 -> 18
    //   9: ldc 89
    //   11: ldc 159
    //   13: invokestatic 97	com/huawei/hms/support/log/HMSLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   16: iconst_0
    //   17: ireturn
    //   18: aload_1
    //   19: ldc 17
    //   21: iconst_0
    //   22: invokevirtual 165	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   25: ifeq +16 -> 41
    //   28: aload_0
    //   29: invokevirtual 105	com/huawei/hms/activity/BridgeActivity:getWindow	()Landroid/view/Window;
    //   32: sipush 1024
    //   35: sipush 1024
    //   38: invokevirtual 169	android/view/Window:setFlags	(II)V
    //   41: aload_1
    //   42: ldc 8
    //   44: invokevirtual 173	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   47: astore_1
    //   48: aload_1
    //   49: ifnonnull +12 -> 61
    //   52: ldc 89
    //   54: ldc 175
    //   56: invokestatic 97	com/huawei/hms/support/log/HMSLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   59: iconst_0
    //   60: ireturn
    //   61: aload_0
    //   62: aload_1
    //   63: invokestatic 57	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   66: ldc 177
    //   68: invokevirtual 181	java/lang/Class:asSubclass	(Ljava/lang/Class;)Ljava/lang/Class;
    //   71: invokevirtual 185	java/lang/Class:newInstance	()Ljava/lang/Object;
    //   74: checkcast 177	com/huawei/hms/activity/IBridgeActivityDelegate
    //   77: putfield 187	com/huawei/hms/activity/BridgeActivity:a	Lcom/huawei/hms/activity/IBridgeActivityDelegate;
    //   80: aload_0
    //   81: getfield 187	com/huawei/hms/activity/BridgeActivity:a	Lcom/huawei/hms/activity/IBridgeActivityDelegate;
    //   84: aload_0
    //   85: invokeinterface 191 2 0
    //   90: iconst_1
    //   91: ireturn
    //   92: astore_1
    //   93: ldc 89
    //   95: new 132	java/lang/StringBuilder
    //   98: dup
    //   99: invokespecial 133	java/lang/StringBuilder:<init>	()V
    //   102: ldc 193
    //   104: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: aload_1
    //   108: invokevirtual 145	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   111: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: invokevirtual 148	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   117: invokestatic 97	com/huawei/hms/support/log/HMSLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   120: iconst_0
    //   121: ireturn
    //   122: astore_1
    //   123: ldc 89
    //   125: new 132	java/lang/StringBuilder
    //   128: dup
    //   129: invokespecial 133	java/lang/StringBuilder:<init>	()V
    //   132: ldc 195
    //   134: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: aload_1
    //   138: invokevirtual 196	java/lang/RuntimeException:getMessage	()Ljava/lang/String;
    //   141: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   144: invokevirtual 148	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   147: invokestatic 97	com/huawei/hms/support/log/HMSLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   150: iconst_0
    //   151: ireturn
    //   152: astore_1
    //   153: goto -60 -> 93
    //   156: astore_1
    //   157: goto -64 -> 93
    //   160: astore_1
    //   161: goto -68 -> 93
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	164	0	this	BridgeActivity
    //   4	59	1	localObject	Object
    //   92	16	1	localClassNotFoundException	ClassNotFoundException
    //   122	16	1	localRuntimeException	java.lang.RuntimeException
    //   152	1	1	localInstantiationException	java.lang.InstantiationException
    //   156	1	1	localClassCastException	ClassCastException
    //   160	1	1	localIllegalAccessException	IllegalAccessException
    // Exception table:
    //   from	to	target	type
    //   61	80	92	java/lang/ClassNotFoundException
    //   80	90	122	java/lang/RuntimeException
    //   61	80	152	java/lang/InstantiationException
    //   61	80	156	java/lang/ClassCastException
    //   61	80	160	java/lang/IllegalAccessException
  }
  
  public static Intent getIntentStartBridgeActivity(Activity paramActivity, String paramString)
  {
    Intent localIntent = new Intent(paramActivity, BridgeActivity.class);
    localIntent.putExtra("intent.extra.DELEGATE_CLASS_OBJECT", paramString);
    localIntent.putExtra("intent.extra.isfullscreen", UIUtil.isActivityFullscreen(paramActivity));
    return localIntent;
  }
  
  public static Intent getIntentStartBridgeActivity(Context paramContext, String paramString)
  {
    paramContext = new Intent(paramContext, BridgeActivity.class);
    paramContext.putExtra("intent.extra.DELEGATE_CLASS_OBJECT", paramString);
    paramContext.putExtra("intent.extra.isfullscreen", false);
    return paramContext;
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public void finish()
  {
    HMSLog.i("BridgeActivity", "Enter finish.");
    super.finish();
  }
  
  public Intent getIntent()
  {
    Intent localIntent = super.getIntent();
    if (localIntent != null) {
      return new SafeIntent(localIntent);
    }
    return localIntent;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Object localObject = paramIntent;
    if (paramIntent != null) {
      localObject = new SafeIntent(paramIntent);
    }
    super.onActivityResult(paramInt1, paramInt2, (Intent)localObject);
    if ((this.a != null) && (!this.a.onBridgeActivityResult(paramInt1, paramInt2, (Intent)localObject)) && (!isFinishing()))
    {
      setResult(paramInt2, (Intent)localObject);
      finish();
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    if (this.a != null) {
      this.a.onBridgeConfigurationChanged();
    }
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (getIntent() == null) {}
    do
    {
      return;
      a();
      if (ResourceLoaderUtil.getmContext() == null) {
        ResourceLoaderUtil.setmContext(getApplicationContext());
      }
    } while (b());
    setResult(1, null);
    finish();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if (this.a != null) {
      this.a.onBridgeActivityDestroy();
    }
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    if (this.a != null) {
      this.a.onKeyUp(paramInt, paramKeyEvent);
    }
    return super.onKeyUp(paramInt, paramKeyEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.huawei.hms.activity.BridgeActivity
 * JD-Core Version:    0.7.0.1
 */