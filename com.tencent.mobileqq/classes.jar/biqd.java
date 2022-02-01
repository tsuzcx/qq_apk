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

public class biqd
  extends bipp
  implements Handler.Callback
{
  public Handler a;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private bhxk jdField_a_of_type_Bhxk;
  private QQBrowserActivity jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity;
  private WebViewFragment jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment;
  public boolean a;
  
  public biqd()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidOsHandler = new blhq(Looper.getMainLooper(), this);
  }
  
  public void a(int paramInt1, int paramInt2, biqf parambiqf)
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
    } while (parambiqf == null);
    parambiqf.a("");
    return;
    ThreadManager.post(new SwiftBrowserMiscHandler.3(this, bhin.a(localCustomWebView, paramInt1, paramInt2), parambiqf), 8, null, true);
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
        } while (this.jdField_a_of_type_Bhxk == null);
        this.jdField_a_of_type_Bhxk.f();
        return;
      } while (this.jdField_a_of_type_Bhxk == null);
      this.jdField_a_of_type_Bhxk.g();
      return;
      if (this.jdField_a_of_type_Bhxk != null) {
        this.jdField_a_of_type_Bhxk.e();
      }
    } while (!this.jdField_a_of_type_Boolean);
    ThreadManager.executeOnFileThread(new SwiftBrowserMiscHandler.2(this));
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_Bipq.a() instanceof QQBrowserActivity))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity = ((QQBrowserActivity)this.jdField_a_of_type_Bipq.a());
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment = this.jdField_a_of_type_Bipq.a();
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
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.setBottomBarVisible(bool);
        if ((i & 0x2) != 0) {
          break label107;
        }
        i = 1;
        label82:
        if (i == 0) {
          break label112;
        }
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.mSwiftTitleUI.a.setVisibility(0);
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
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.mSwiftTitleUI.a.setVisibility(8);
      continue;
      if ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment != null) && (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.mUIStyleHandler != null) && (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.mUIStyleHandler.d != null))
      {
        if (this.jdField_a_of_type_AndroidViewViewGroup == null)
        {
          RelativeLayout localRelativeLayout = (RelativeLayout)this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.mUIStyleHandler.d.findViewById(2131363678);
          this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)LayoutInflater.from(BaseApplicationImpl.getContext()).inflate(2131561970, null));
          RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
          localLayoutParams.addRule(12);
          localRelativeLayout.addView(this.jdField_a_of_type_AndroidViewViewGroup, localLayoutParams);
          this.jdField_a_of_type_AndroidViewViewGroup.setOnTouchListener(new biqe(this));
        }
        if (this.jdField_a_of_type_Bhxk == null) {
          this.jdField_a_of_type_Bhxk = new bhxk(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity, this.jdField_a_of_type_AndroidViewViewGroup);
        }
        this.jdField_a_of_type_Bhxk.h();
        paramMessage = (Bundle)paramMessage.obj;
        this.jdField_a_of_type_Bhxk.a(paramMessage.getLong("id"), paramMessage.getString("type"), paramMessage.getString("callbackId"));
        continue;
        paramMessage = (Bundle)paramMessage.obj;
        if (this.jdField_a_of_type_Bhxk != null)
        {
          this.jdField_a_of_type_Bhxk.a(paramMessage.getLong("id"), paramMessage.getString("type"), paramMessage.getInt("status"), paramMessage.getString("callbackId"));
          continue;
          if (this.jdField_a_of_type_Bhxk != null)
          {
            paramMessage = (Bundle)paramMessage.obj;
            this.jdField_a_of_type_Bhxk.a(paramMessage.getString("callbackId"));
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     biqd
 * JD-Core Version:    0.7.0.1
 */