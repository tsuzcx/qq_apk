import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.filemanager.activity.UniformDownloadActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class atiy
  implements View.OnClickListener
{
  public atiy(UniformDownloadActivity paramUniformDownloadActivity) {}
  
  public void onClick(View paramView)
  {
    if (bhnv.d(this.a.getActivity()))
    {
      UniformDownloadActivity.a(this.a).setVisibility(8);
      if (aunj.a()) {
        aumw.a(this.a.getActivity(), 2131692326, 2131719052, new atiz(this));
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
      auna.a(2131692319);
      this.a.finish();
      this.a.overridePendingTransition(0, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atiy
 * JD-Core Version:    0.7.0.1
 */