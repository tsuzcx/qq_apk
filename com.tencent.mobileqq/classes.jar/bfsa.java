import android.view.View;
import android.view.View.OnClickListener;
import cooperation.qzone.QzoneVerticalVideoDownloadActivity;

public class bfsa
  implements View.OnClickListener
{
  public bfsa(QzoneVerticalVideoDownloadActivity paramQzoneVerticalVideoDownloadActivity) {}
  
  public void onClick(View paramView)
  {
    QzoneVerticalVideoDownloadActivity.access$502(this.a, true);
    QzoneVerticalVideoDownloadActivity.access$600(this.a);
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bfsa
 * JD-Core Version:    0.7.0.1
 */