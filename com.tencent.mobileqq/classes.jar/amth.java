import android.view.View;
import android.view.View.OnClickListener;
import cooperation.qzone.QzoneVerticalVideoDownloadActivity;

public class amth
  implements View.OnClickListener
{
  public amth(QzoneVerticalVideoDownloadActivity paramQzoneVerticalVideoDownloadActivity) {}
  
  public void onClick(View paramView)
  {
    QzoneVerticalVideoDownloadActivity.a(this.a, true);
    QzoneVerticalVideoDownloadActivity.b(this.a);
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amth
 * JD-Core Version:    0.7.0.1
 */