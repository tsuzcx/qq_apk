import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import cooperation.qzone.util.QZLog;
import cooperation.qzone.webviewplugin.QzonePersonalizeJsPlugin;
import cooperation.vip.webview.controller.BaseTranslucentController.2;

public class blco
{
  private long jdField_a_of_type_Long;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new blcp(this);
  protected Handler a;
  protected QQBrowserActivity a;
  private Runnable jdField_a_of_type_JavaLangRunnable = new BaseTranslucentController.2(this);
  private volatile boolean jdField_a_of_type_Boolean;
  private volatile boolean b;
  
  public blco(QQBrowserActivity paramQQBrowserActivity)
  {
    QZLog.i("BaseTranslucentControll", "current controller = " + getClass().getName());
    this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity = paramQQBrowserActivity;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_Boolean) {}
    for (;;)
    {
      return;
      try
      {
        QZLog.i("BaseTranslucentControll", "registerBroadcast");
        IntentFilter localIntentFilter = new IntentFilter();
        String[] arrayOfString = a();
        if (arrayOfString != null)
        {
          int j = arrayOfString.length;
          int i = 0;
          while (i < j)
          {
            localIntentFilter.addAction(arrayOfString[i]);
            i += 1;
          }
        }
        boolean bool = this.jdField_a_of_type_Boolean;
        if (bool) {
          continue;
        }
        try
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter, "com.tencent.msg.permission.pushnotify", null);
          this.jdField_a_of_type_Boolean = true;
          return;
        }
        catch (Exception localException1)
        {
          QZLog.e("BaseTranslucentControll", "regist receiver error:", localException1);
          return;
        }
        return;
      }
      catch (Exception localException2)
      {
        QZLog.e("BaseTranslucentControll", "registerBroadcast error", localException2);
      }
    }
  }
  
  private void g()
  {
    try
    {
      if (this.jdField_a_of_type_Boolean)
      {
        QZLog.i("BaseTranslucentControll", "removeBroadcast");
        try
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
          this.jdField_a_of_type_Boolean = false;
          return;
        }
        catch (Exception localException1)
        {
          for (;;)
          {
            QZLog.e("BaseTranslucentControll", "unregisterReceiver error ", localException1);
          }
        }
      }
      return;
    }
    catch (Exception localException2)
    {
      QZLog.e("BaseTranslucentControll", "removeBroadcast error", localException2);
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    a(false);
    f();
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 6100L);
  }
  
  public void a(Intent paramIntent) {}
  
  protected void a(View paramView)
  {
    if (!this.b)
    {
      this.b = true;
      QZLog.i("BaseTranslucentControll", "setAlpha(1)");
      if (paramView != null) {
        paramView.setAlpha(1.0F);
      }
    }
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.a() != null)
        {
          paramView = this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.a().getWebView();
          if (paramView != null)
          {
            Object localObject = paramView.getTag(2131375729);
            if ((localObject == null) || (!((Boolean)localObject).booleanValue())) {
              break label119;
            }
            i = 1;
            paramView.setTag(2131375726, Boolean.TRUE);
            if (i != 0)
            {
              QZLog.i("BaseTranslucentControll", "tiantai jsReady true,notify webview.");
              QzonePersonalizeJsPlugin.notifyWebviewStartAnimation(paramView);
              return;
            }
            QZLog.i("BaseTranslucentControll", "tiantai jsReady false,not notify webview.");
            return;
          }
        }
      }
      catch (Exception paramView)
      {
        QZLog.e("BaseTranslucentControll", "notify webview qzRoofStartAnimation fail.", paramView);
      }
      return;
      label119:
      int i = 0;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    View localView = this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.findViewById(2131365087);
    if (localView == null) {
      return;
    }
    if (!paramBoolean)
    {
      if (System.currentTimeMillis() - this.jdField_a_of_type_Long < 6000L)
      {
        localView.setAlpha(0.0F);
        this.b = false;
        QZLog.i("BaseTranslucentControll", "setAlpha(0)");
        return;
      }
      QZLog.i("BaseTranslucentControll", "isLoadSuccess = true，setAlpha(1)");
      a(localView);
      return;
    }
    QZLog.i("BaseTranslucentControll", "isLoadSuccess = false，setAlpha(1)");
    a(localView);
  }
  
  public boolean a()
  {
    return true;
  }
  
  public String[] a()
  {
    return null;
  }
  
  public void b() {}
  
  public void c() {}
  
  public void d()
  {
    g();
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
  }
  
  public void e()
  {
    a(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blco
 * JD-Core Version:    0.7.0.1
 */