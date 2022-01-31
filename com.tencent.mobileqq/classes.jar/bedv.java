import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserMiscHandler.2;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserMiscHandler.3;

public class bedv
  extends bedh
  implements Handler.Callback
{
  public Handler a;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private bdnx jdField_a_of_type_Bdnx;
  private QQBrowserActivity jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity;
  private WebViewFragment jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment;
  public boolean a;
  
  public bedv()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidOsHandler = new bhow(Looper.getMainLooper(), this);
  }
  
  public void a(int paramInt1, int paramInt2, bedx parambedx)
  {
    if ((paramInt1 <= 0) || (paramInt2 <= 0) || (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment == null)) {}
    CustomWebView localCustomWebView;
    do
    {
      return;
      localCustomWebView = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.getWebView();
      if (localCustomWebView != null) {
        break;
      }
    } while (parambedx == null);
    parambedx.a("");
    return;
    ThreadManager.post(new SwiftBrowserMiscHandler.3(this, bczk.a(localCustomWebView, paramInt1, paramInt2), parambedx), 8, null, true);
  }
  
  public void a(int paramInt, Bundle paramBundle)
  {
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        do
        {
          return;
        } while (this.jdField_a_of_type_Bdnx == null);
        this.jdField_a_of_type_Bdnx.f();
        return;
      } while (this.jdField_a_of_type_Bdnx == null);
      this.jdField_a_of_type_Bdnx.g();
      return;
      if (this.jdField_a_of_type_Bdnx != null) {
        this.jdField_a_of_type_Bdnx.e();
      }
    } while (!this.jdField_a_of_type_Boolean);
    ThreadManager.executeOnFileThread(new SwiftBrowserMiscHandler.2(this));
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_Bedi.a() instanceof QQBrowserActivity))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity = ((QQBrowserActivity)this.jdField_a_of_type_Bedi.a());
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment = this.jdField_a_of_type_Bedi.a();
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i;
    boolean bool;
    switch (paramMessage.what)
    {
    case 1: 
    case 2: 
    default: 
      return false;
    case 0: 
      if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment != null)
      {
        i = paramMessage.arg1;
        if ((i & 0x1) != 0) {
          break label102;
        }
        bool = true;
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.a(bool);
        if ((i & 0x2) != 0) {
          break label107;
        }
        i = 1;
        label82:
        if (i == 0) {
          break label112;
        }
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.jdField_a_of_type_Bebk.a.setVisibility(0);
      }
      break;
    }
    for (;;)
    {
      return true;
      label102:
      bool = false;
      break;
      label107:
      i = 0;
      break label82;
      label112:
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.jdField_a_of_type_Bebk.a.setVisibility(8);
      continue;
      if ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment != null) && (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.jdField_a_of_type_Beey != null) && (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.jdField_a_of_type_Beey.d != null))
      {
        if (this.jdField_a_of_type_AndroidViewViewGroup == null)
        {
          RelativeLayout localRelativeLayout = (RelativeLayout)this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.jdField_a_of_type_Beey.d.findViewById(2131363457);
          this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)LayoutInflater.from(BaseApplicationImpl.getContext()).inflate(2131561675, null));
          RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
          localLayoutParams.addRule(12);
          localRelativeLayout.addView(this.jdField_a_of_type_AndroidViewViewGroup, localLayoutParams);
          this.jdField_a_of_type_AndroidViewViewGroup.setOnTouchListener(new bedw(this));
        }
        if (this.jdField_a_of_type_Bdnx == null) {
          this.jdField_a_of_type_Bdnx = new bdnx(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity, this.jdField_a_of_type_AndroidViewViewGroup);
        }
        this.jdField_a_of_type_Bdnx.h();
        paramMessage = (Bundle)paramMessage.obj;
        this.jdField_a_of_type_Bdnx.a(paramMessage.getLong("id"), paramMessage.getString("type"), paramMessage.getString("callbackId"));
        continue;
        paramMessage = (Bundle)paramMessage.obj;
        if (this.jdField_a_of_type_Bdnx != null)
        {
          this.jdField_a_of_type_Bdnx.a(paramMessage.getLong("id"), paramMessage.getString("type"), paramMessage.getInt("status"), paramMessage.getString("callbackId"));
          continue;
          if (this.jdField_a_of_type_Bdnx != null)
          {
            paramMessage = (Bundle)paramMessage.obj;
            this.jdField_a_of_type_Bdnx.a(paramMessage.getString("callbackId"));
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bedv
 * JD-Core Version:    0.7.0.1
 */