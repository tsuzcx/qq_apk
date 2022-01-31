import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.webprocess.WebAccelerateHelper;
import com.tencent.mobileqq.webview.swift.SwiftReuseTouchWebView;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserCookieMonster;
import com.tencent.mobileqq.webview.swift.utils.SwiftWebAccelerator.2;
import com.tencent.mobileqq.webview.swift.utils.SwiftWebAccelerator.3;
import com.tencent.mobileqq.webview.swift.utils.SwiftWebAccelerator.4;
import com.tencent.mobileqq.webview.swift.utils.SwiftWebAccelerator.5;
import com.tencent.mobileqq.webview.swift.utils.SwiftWebAccelerator.6;
import com.tencent.mobileqq.webview.swift.utils.SwiftWebAccelerator.7;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class bcfz
{
  private static bcfz jdField_a_of_type_Bcfz;
  public static final Object a;
  public int a;
  final bcfq jdField_a_of_type_Bcfq = new bcfq(new bcga(this));
  public boolean a;
  public int b = 0;
  
  static
  {
    jdField_a_of_type_JavaLangObject = new Object();
  }
  
  public static bcfz a()
  {
    if (jdField_a_of_type_Bcfz == null) {}
    try
    {
      if (jdField_a_of_type_Bcfz == null) {
        jdField_a_of_type_Bcfz = new bcfz();
      }
      return jdField_a_of_type_Bcfz;
    }
    finally {}
  }
  
  public static void b()
  {
    long l = System.currentTimeMillis();
    if (WebViewPluginEngine.a == null) {
      ThreadManager.postImmediately(new SwiftWebAccelerator.7(l), null, false);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("WebLog_SwiftWebAccelerator", 2, "preCreateWebViewPluginEngine preload success");
  }
  
  public int a()
  {
    return this.b;
  }
  
  public int a(Bundle paramBundle)
  {
    this.jdField_a_of_type_Int |= 0x1;
    Object localObject = BaseApplicationImpl.sApplication.getRuntime();
    if (localObject != null) {
      localObject = ((AppRuntime)localObject).getAccount();
    }
    for (boolean bool = BaseApplicationImpl.sApplication.getSharedPreferences("sp_x5_config_" + (String)localObject, 4).getBoolean("key_x5_init_sub_thread", true);; bool = true)
    {
      long l = System.currentTimeMillis();
      QLog.i("WebLog_SwiftWebAccelerator", 1, "initX5Environment start! " + bool);
      if (bool)
      {
        ThreadManager.postImmediately(new SwiftWebAccelerator.3(this, l, paramBundle), null, false);
        return -1;
      }
      bcgb.b();
      bcfa.X = System.currentTimeMillis() - l;
      QLog.i("WebLog_SwiftWebAccelerator", 1, "initX5Environment on main thread, cost " + bcfa.X + "ms.");
      return 1;
    }
  }
  
  public void a()
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      QLog.i("WebLog_SwiftWebAccelerator", 1, "switch 2 RealWorld and cancel state machine schedule.");
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_Bcfq.b();
    }
  }
  
  public void a(Bundle paramBundle)
  {
    if (Looper.getMainLooper() == Looper.myLooper())
    {
      if (!this.jdField_a_of_type_Boolean)
      {
        Bundle localBundle = paramBundle;
        if (paramBundle == null) {
          localBundle = new Bundle();
        }
        this.b = localBundle.getInt("_accelerator_mode_", 0);
        this.jdField_a_of_type_Bcfq.b();
        this.jdField_a_of_type_Bcfq.a(localBundle);
        QLog.i("WebLog_SwiftWebAccelerator", 1, "smartSchedule restart and new mode is " + this.b + ".");
        return;
      }
      QLog.i("WebLog_SwiftWebAccelerator", 1, "smartSchedule say no because is in real world now.");
      return;
    }
    new Handler(Looper.getMainLooper()).post(new SwiftWebAccelerator.2(this, paramBundle));
  }
  
  public int b(Bundle paramBundle)
  {
    this.jdField_a_of_type_Int |= 0x2;
    long l = System.currentTimeMillis();
    SwiftReuseTouchWebView.a(BaseApplicationImpl.sApplication).a(true);
    bcfa.Y = System.currentTimeMillis() - l;
    QLog.i("WebLog_SwiftWebAccelerator", 1, "doMainStep_CreateWebView:create webview cost " + bcfa.Y + "ms.");
    return 1;
  }
  
  public void b(Bundle paramBundle)
  {
    this.jdField_a_of_type_Int |= 0x400;
    ThreadManager.postImmediately(new SwiftWebAccelerator.5(this, System.currentTimeMillis(), paramBundle), null, false);
  }
  
  public int c(Bundle paramBundle)
  {
    this.jdField_a_of_type_Int |= 0x4;
    long l = System.currentTimeMillis();
    Object localObject = (String)WebAccelerateHelper.getInstance().getWebViewFeatureConfigs().get("preloadUrl");
    paramBundle = (Bundle)localObject;
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      if (!((String)localObject).startsWith("http:"))
      {
        paramBundle = (Bundle)localObject;
        if (!((String)localObject).startsWith("https:")) {}
      }
      else
      {
        paramBundle = (Bundle)localObject;
        if (((String)localObject).startsWith("http:"))
        {
          localObject = ((String)localObject).replace("http:", "https:");
          paramBundle = (Bundle)localObject;
          if (QLog.isColorLevel())
          {
            QLog.d("WebLog_SwiftWebAccelerator", 2, "WarnUpWebView replace https");
            paramBundle = (Bundle)localObject;
          }
        }
        localObject = SwiftReuseTouchWebView.a(BaseApplicationImpl.sApplication);
        Intent localIntent = new Intent();
        localIntent.putExtra("ignoreLoginWeb", true);
        ((SwiftReuseTouchWebView)localObject).setIntent(localIntent);
        ((SwiftReuseTouchWebView)localObject).loadUrlOriginal(paramBundle);
        new Handler(Looper.getMainLooper()).postDelayed(new SwiftWebAccelerator.4(this, (SwiftReuseTouchWebView)localObject), 300L);
      }
    }
    bcfa.Z = System.currentTimeMillis() - l;
    QLog.i("WebLog_SwiftWebAccelerator", 1, "tendocpreload doMainStep_WarnUpWebView:load " + paramBundle + ", cost " + bcfa.Z + "ms.");
    return 1;
  }
  
  public void c(Bundle paramBundle)
  {
    this.jdField_a_of_type_Int |= 0x800;
    ThreadManager.postImmediately(new SwiftWebAccelerator.6(this, System.currentTimeMillis()), null, false);
  }
  
  public int d(Bundle paramBundle)
  {
    this.jdField_a_of_type_Int |= 0x10;
    long l = System.currentTimeMillis();
    Object localObject2 = (String)WebAccelerateHelper.getInstance().getWebViewFeatureConfigs().get("preloadUrl");
    Object localObject1 = localObject2;
    if (!TextUtils.isEmpty((CharSequence)localObject2)) {
      if (!((String)localObject2).startsWith("http:"))
      {
        localObject1 = localObject2;
        if (!((String)localObject2).startsWith("https:")) {}
      }
      else
      {
        paramBundle = (Bundle)localObject2;
        if (((String)localObject2).startsWith("http:"))
        {
          localObject1 = ((String)localObject2).replace("http:", "https:");
          paramBundle = (Bundle)localObject1;
          if (QLog.isColorLevel())
          {
            QLog.d("WebLog_SwiftWebAccelerator", 2, "SetCookie replace https");
            paramBundle = (Bundle)localObject1;
          }
        }
        localObject2 = SwiftBrowserCookieMonster.a(paramBundle);
        localObject1 = paramBundle;
        if (localObject2 != null)
        {
          ((SwiftBrowserCookieMonster)localObject2).a(paramBundle, null, null, null);
          localObject1 = paramBundle;
        }
      }
    }
    QLog.i("WebLog_SwiftWebAccelerator", 1, "doMainStep_SetCookie:pre set cookie(" + (String)localObject1 + "), cost " + (System.currentTimeMillis() - l) + "ms.");
    return 1;
  }
  
  public void d(Bundle paramBundle)
  {
    this.jdField_a_of_type_Int |= 0x1000;
    b();
  }
  
  public int e(Bundle paramBundle)
  {
    this.jdField_a_of_type_Int |= 0x8;
    long l = System.currentTimeMillis();
    if (WebAccelerateHelper.preloadBrowserView == null)
    {
      WebAccelerateHelper.preInflaterBrowserView();
      bcfa.aa = System.currentTimeMillis() - l;
      QLog.i("WebLog_SwiftWebAccelerator", 1, "doMainStep_CreateBrowserView, cost = " + bcfa.aa + "ms.");
      return 1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bcfz
 * JD-Core Version:    0.7.0.1
 */