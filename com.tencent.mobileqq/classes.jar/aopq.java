import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.activity.UniformDownloadActivity;

public class aopq
  implements View.OnClickListener
{
  public aopq(UniformDownloadActivity paramUniformDownloadActivity) {}
  
  public void onClick(View paramView)
  {
    if (this.a.a != null)
    {
      this.a.a.dismiss();
      this.a.a = null;
    }
    if (UniformDownloadActivity.a(this.a)) {
      bdjo.a().a(UniformDownloadActivity.a(this.a), "1", "ANDROIDQQ.POPUP.YYBDOWNAPP", "3009", false);
    }
    for (;;)
    {
      this.a.finish();
      this.a.overridePendingTransition(0, 0);
      return;
      bdjo.a().a(UniformDownloadActivity.a(this.a), "1", "ANDROIDQQ.POPUP.YYBDOWNAPP", "3006", false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aopq
 * JD-Core Version:    0.7.0.1
 */