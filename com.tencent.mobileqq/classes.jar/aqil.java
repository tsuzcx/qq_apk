import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.filemanager.activity.UniformDownloadActivity;

public class aqil
  implements View.OnClickListener
{
  public aqil(UniformDownloadActivity paramUniformDownloadActivity) {}
  
  public void onClick(View paramView)
  {
    if (bdee.d(this.a.getActivity()))
    {
      UniformDownloadActivity.a(this.a).setVisibility(8);
      if (arni.a())
      {
        armv.a(this.a.getActivity(), 2131692752, 2131721154, new aqim(this));
        return;
      }
      UniformDownloadActivity.a(this.a);
      this.a.finish();
      this.a.overridePendingTransition(0, 0);
      return;
    }
    armz.a(2131692745);
    this.a.finish();
    this.a.overridePendingTransition(0, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqil
 * JD-Core Version:    0.7.0.1
 */