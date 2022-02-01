import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserUIStyleHandler;
import com.tencent.mobileqq.webview.ui.WebViewTopTabView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bguh
  implements RadioGroup.OnCheckedChangeListener
{
  bguh(bgug parambgug) {}
  
  public void onCheckedChanged(RadioGroup paramRadioGroup, int paramInt)
  {
    int i = this.a.a(paramRadioGroup);
    if (((QQBrowserActivity)this.a.mUIStyleHandler.mHostActivity).c != i)
    {
      WebViewFragment localWebViewFragment = QQBrowserActivity.a(i, (QQBrowserActivity)this.a.mUIStyleHandler.mHostActivity);
      ((QQBrowserActivity)this.a.mUIStyleHandler.mHostActivity).c = i;
      if ((localWebViewFragment.mSwiftTitleUI != null) && (localWebViewFragment.mSwiftTitleUI.mTopSubTabView != null)) {
        localWebViewFragment.mSwiftTitleUI.mTopSubTabView.setSelectedTab(i);
      }
    }
    EventCollector.getInstance().onCheckedChanged(paramRadioGroup, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bguh
 * JD-Core Version:    0.7.0.1
 */