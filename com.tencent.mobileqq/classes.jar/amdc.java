import android.view.View;
import android.view.View.OnClickListener;
import cooperation.qzone.QzoneVerticalVideoDownloadActivity;

public class amdc
  implements View.OnClickListener
{
  public amdc(QzoneVerticalVideoDownloadActivity paramQzoneVerticalVideoDownloadActivity) {}
  
  public void onClick(View paramView)
  {
    if (!QzoneVerticalVideoDownloadActivity.a(this.a))
    {
      QzoneVerticalVideoDownloadActivity.a(this.a, false, false);
      QzoneVerticalVideoDownloadActivity.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amdc
 * JD-Core Version:    0.7.0.1
 */