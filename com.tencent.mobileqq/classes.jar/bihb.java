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
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserUIStyleHandler;

public class bihb
  extends bign
  implements Handler.Callback
{
  public Handler a;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private bhmn jdField_a_of_type_Bhmn;
  private QQBrowserActivity jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity;
  private WebViewFragment jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment;
  public boolean a;
  
  public bihb()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidOsHandler = new bkys(Looper.getMainLooper(), this);
  }
  
  public void a(int paramInt1, int paramInt2, bihd parambihd)
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
    } while (parambihd == null);
    parambihd.a("");
    return;
    ThreadManager.post(new SwiftBrowserMiscHandler.3(this, bhao.a(localCustomWebView, paramInt1, paramInt2), parambihd), 8, null, true);
  }
  
  public void didBindContext()
  {
    if ((this.mComponentContext.a() instanceof QQBrowserActivity))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity = ((QQBrowserActivity)this.mComponentContext.a());
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment = this.mComponentContext.a();
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
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.mSwiftTitleUI.rightViewImg.setVisibility(0);
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
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.mSwiftTitleUI.rightViewImg.setVisibility(8);
      continue;
      if ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment != null) && (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.mUIStyleHandler != null) && (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.mUIStyleHandler.mRootView != null))
      {
        if (this.jdField_a_of_type_AndroidViewViewGroup == null)
        {
          RelativeLayout localRelativeLayout = (RelativeLayout)this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.mUIStyleHandler.mRootView.findViewById(2131363780);
          this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)LayoutInflater.from(BaseApplicationImpl.getContext()).inflate(2131561915, null));
          RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
          localLayoutParams.addRule(12);
          localRelativeLayout.addView(this.jdField_a_of_type_AndroidViewViewGroup, localLayoutParams);
          this.jdField_a_of_type_AndroidViewViewGroup.setOnTouchListener(new bihc(this));
        }
        if (this.jdField_a_of_type_Bhmn == null) {
          this.jdField_a_of_type_Bhmn = new bhmn(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity, this.jdField_a_of_type_AndroidViewViewGroup);
        }
        this.jdField_a_of_type_Bhmn.h();
        paramMessage = (Bundle)paramMessage.obj;
        this.jdField_a_of_type_Bhmn.a(paramMessage.getLong("id"), paramMessage.getString("type"), paramMessage.getString("callbackId"));
        continue;
        paramMessage = (Bundle)paramMessage.obj;
        if (this.jdField_a_of_type_Bhmn != null)
        {
          this.jdField_a_of_type_Bhmn.a(paramMessage.getLong("id"), paramMessage.getString("type"), paramMessage.getInt("status"), paramMessage.getString("callbackId"));
          continue;
          if (this.jdField_a_of_type_Bhmn != null)
          {
            paramMessage = (Bundle)paramMessage.obj;
            this.jdField_a_of_type_Bhmn.a(paramMessage.getString("callbackId"));
          }
        }
      }
    }
  }
  
  public void onLifeCycleStateChanged(int paramInt, Bundle paramBundle)
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
        } while (this.jdField_a_of_type_Bhmn == null);
        this.jdField_a_of_type_Bhmn.f();
        return;
      } while (this.jdField_a_of_type_Bhmn == null);
      this.jdField_a_of_type_Bhmn.g();
      return;
      if (this.jdField_a_of_type_Bhmn != null) {
        this.jdField_a_of_type_Bhmn.e();
      }
    } while (!this.jdField_a_of_type_Boolean);
    ThreadManager.executeOnFileThread(new SwiftBrowserMiscHandler.2(this));
    this.jdField_a_of_type_Boolean = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bihb
 * JD-Core Version:    0.7.0.1
 */