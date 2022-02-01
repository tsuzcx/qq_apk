import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.fragment.CustomHeightFragment;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserUIStyleHandler;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;

public class auvv
  extends SwiftBrowserUIStyleHandler
{
  auvv(CustomHeightFragment paramCustomHeightFragment) {}
  
  public void initWebViewInContentView()
  {
    WebView localWebView;
    Object localObject;
    if (this.mComponentContext.a() != null)
    {
      localWebView = this.mComponentContext.a();
      localWebView.setId(2131381402);
      if (this.mBrowserWebviewColor != -1) {
        localWebView.setBackgroundColor(this.mBrowserWebviewColor);
      }
      localObject = (Activity)localWebView.getContext();
      if ((((Activity)localObject).getIntent() == null) || (((Activity)localObject).getIntent().getExtras() == null)) {
        break label210;
      }
    }
    label210:
    for (int i = ((Activity)localObject).getIntent().getExtras().getInt("customheight", 0);; i = 0)
    {
      if (QLog.isColorLevel()) {
        QLog.i("SwiftBrowserUIStyleHandler", 2, "initWebViewInContentView height=" + i);
      }
      if (i != 0)
      {
        if ((this.webviewWrapper instanceof RelativeLayout))
        {
          localObject = new RelativeLayout.LayoutParams(-1, i);
          ((RelativeLayout.LayoutParams)localObject).addRule(12);
          this.webviewWrapper.addView(localWebView, 0, (ViewGroup.LayoutParams)localObject);
        }
        for (;;)
        {
          this.webviewWrapper.setOnClickListener(new auvw(this));
          return;
          this.webviewWrapper.addView(localWebView, 0, new ViewGroup.LayoutParams(-1, i));
        }
      }
      this.webviewWrapper.addView(localWebView, 0, new ViewGroup.LayoutParams(-1, -1));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auvv
 * JD-Core Version:    0.7.0.1
 */