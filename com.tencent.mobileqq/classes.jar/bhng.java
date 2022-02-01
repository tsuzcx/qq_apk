import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.ui.WebViewTopTabView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bhng
  implements RadioGroup.OnCheckedChangeListener
{
  bhng(bhnf parambhnf) {}
  
  public void onCheckedChanged(RadioGroup paramRadioGroup, int paramInt)
  {
    int i = this.a.a(paramRadioGroup);
    if (((QQBrowserActivity)this.a.a.a).b != i)
    {
      WebViewFragment localWebViewFragment = QQBrowserActivity.a(i, (QQBrowserActivity)this.a.a.a);
      ((QQBrowserActivity)this.a.a.a).b = i;
      if ((localWebViewFragment.mSwiftTitleUI != null) && (localWebViewFragment.mSwiftTitleUI.a != null)) {
        localWebViewFragment.mSwiftTitleUI.a.setSelectedTab(i);
      }
    }
    EventCollector.getInstance().onCheckedChanged(paramRadioGroup, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhng
 * JD-Core Version:    0.7.0.1
 */