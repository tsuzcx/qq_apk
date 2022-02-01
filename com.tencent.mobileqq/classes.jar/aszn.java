import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.filemanager.activity.UniformDownloadActivity;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aszn
  implements View.OnClickListener
{
  public aszn(UniformDownloadActivity paramUniformDownloadActivity) {}
  
  public void onClick(View paramView)
  {
    if (NetworkUtil.isNetSupport(this.a.getActivity()))
    {
      UniformDownloadActivity.a(this.a).setVisibility(8);
      if (auea.a()) {
        audn.a(this.a.getActivity(), 2131692476, 2131719760, new aszo(this));
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      UniformDownloadActivity.a(this.a);
      this.a.finish();
      this.a.overridePendingTransition(0, 0);
      continue;
      audr.a(2131692469);
      this.a.finish();
      this.a.overridePendingTransition(0, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aszn
 * JD-Core Version:    0.7.0.1
 */