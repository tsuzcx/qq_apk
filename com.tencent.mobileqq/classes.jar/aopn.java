import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.filemanager.activity.UniformDownloadActivity;

public class aopn
  implements View.OnClickListener
{
  public aopn(UniformDownloadActivity paramUniformDownloadActivity) {}
  
  public void onClick(View paramView)
  {
    if (bbfj.d(this.a.getActivity()))
    {
      UniformDownloadActivity.a(this.a).setVisibility(8);
      if (apug.a())
      {
        aptt.a(this.a.getActivity(), 2131692673, 2131720614, new aopo(this));
        return;
      }
      UniformDownloadActivity.a(this.a);
      this.a.finish();
      this.a.overridePendingTransition(0, 0);
      return;
    }
    aptx.a(2131692666);
    this.a.finish();
    this.a.overridePendingTransition(0, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aopn
 * JD-Core Version:    0.7.0.1
 */