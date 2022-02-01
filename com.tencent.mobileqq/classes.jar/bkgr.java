import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserUIStyleHandler;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bkgr
  implements View.OnClickListener
{
  bkgr(bkgq parambkgq) {}
  
  public void onClick(View paramView)
  {
    if ((this.a.mUIStyleHandler.mHostActivity != null) && (!this.a.mUIStyleHandler.mHostActivity.isFinishing())) {
      this.a.mUIStyleHandler.mHostActivity.finish();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkgr
 * JD-Core Version:    0.7.0.1
 */