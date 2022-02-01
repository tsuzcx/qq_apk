import android.content.Intent;
import android.text.TextUtils;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserUIStyleHandler;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bguc
  implements RadioGroup.OnCheckedChangeListener
{
  bguc(bgtw parambgtw) {}
  
  public void onCheckedChanged(RadioGroup paramRadioGroup, int paramInt)
  {
    if ((this.a.mTopTabHelper != null) && (!TextUtils.isEmpty(this.a.mTopTabHelper.a))) {
      this.a.mTopTabHelper.a(paramInt);
    }
    for (;;)
    {
      EventCollector.getInstance().onCheckedChanged(paramRadioGroup, paramInt);
      return;
      TouchWebView localTouchWebView = this.a.mUIStyleHandler.getWebView();
      if (localTouchWebView != null)
      {
        String str2 = localTouchWebView.getUrl();
        String str1 = str2;
        if (TextUtils.isEmpty(str2))
        {
          str1 = str2;
          if (this.a.intent != null) {
            str1 = this.a.intent.getStringExtra("url");
          }
        }
        if (!TextUtils.isEmpty(str1)) {
          localTouchWebView.loadUrl(str1.replaceAll("(?<=[?&])subIndex=[^&]*", "subIndex=" + paramInt));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bguc
 * JD-Core Version:    0.7.0.1
 */