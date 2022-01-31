import android.view.View;
import android.view.View.OnClickListener;
import cooperation.qzone.QzoneVerticalVideoDownloadActivity;

public class amtg
  implements View.OnClickListener
{
  public amtg(QzoneVerticalVideoDownloadActivity paramQzoneVerticalVideoDownloadActivity) {}
  
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
 * Qualified Name:     amtg
 * JD-Core Version:    0.7.0.1
 */