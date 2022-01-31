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

public class bceg
  extends bcds
  implements Handler.Callback
{
  public Handler a;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private bbop jdField_a_of_type_Bbop;
  private QQBrowserActivity jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity;
  private WebViewFragment jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment;
  public boolean a;
  
  public bceg()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidOsHandler = new bfnk(Looper.getMainLooper(), this);
  }
  
  public void a(int paramInt1, int paramInt2, bcei parambcei)
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
    } while (parambcei == null);
    parambcei.a("");
    return;
    ThreadManager.post(new SwiftBrowserMiscHandler.3(this, bbac.a(localCustomWebView, paramInt1, paramInt2), parambcei), 8, null, true);
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
        } while (this.jdField_a_of_type_Bbop == null);
        this.jdField_a_of_type_Bbop.f();
        return;
      } while (this.jdField_a_of_type_Bbop == null);
      this.jdField_a_of_type_Bbop.g();
      return;
      if (this.jdField_a_of_type_Bbop != null) {
        this.jdField_a_of_type_Bbop.e();
      }
    } while (!this.jdField_a_of_type_Boolean);
    ThreadManager.executeOnFileThread(new SwiftBrowserMiscHandler.2(this));
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_Bcdt.a() instanceof QQBrowserActivity))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity = ((QQBrowserActivity)this.jdField_a_of_type_Bcdt.a());
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment = this.jdField_a_of_type_Bcdt.a();
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
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.jdField_a_of_type_Bcbv.a.setVisibility(0);
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
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.jdField_a_of_type_Bcbv.a.setVisibility(8);
      continue;
      if ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment != null) && (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.jdField_a_of_type_Bcfj != null) && (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.jdField_a_of_type_Bcfj.d != null))
      {
        if (this.jdField_a_of_type_AndroidViewViewGroup == null)
        {
          RelativeLayout localRelativeLayout = (RelativeLayout)this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.jdField_a_of_type_Bcfj.d.findViewById(2131363419);
          this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)LayoutInflater.from(BaseApplicationImpl.getContext()).inflate(2131561486, null));
          RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
          localLayoutParams.addRule(12);
          localRelativeLayout.addView(this.jdField_a_of_type_AndroidViewViewGroup, localLayoutParams);
          this.jdField_a_of_type_AndroidViewViewGroup.setOnTouchListener(new bceh(this));
        }
        if (this.jdField_a_of_type_Bbop == null) {
          this.jdField_a_of_type_Bbop = new bbop(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity, this.jdField_a_of_type_AndroidViewViewGroup);
        }
        this.jdField_a_of_type_Bbop.h();
        paramMessage = (Bundle)paramMessage.obj;
        this.jdField_a_of_type_Bbop.a(paramMessage.getLong("id"), paramMessage.getString("type"), paramMessage.getString("callbackId"));
        continue;
        paramMessage = (Bundle)paramMessage.obj;
        if (this.jdField_a_of_type_Bbop != null)
        {
          this.jdField_a_of_type_Bbop.a(paramMessage.getLong("id"), paramMessage.getString("type"), paramMessage.getInt("status"), paramMessage.getString("callbackId"));
          continue;
          if (this.jdField_a_of_type_Bbop != null)
          {
            paramMessage = (Bundle)paramMessage.obj;
            this.jdField_a_of_type_Bbop.a(paramMessage.getString("callbackId"));
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bceg
 * JD-Core Version:    0.7.0.1
 */