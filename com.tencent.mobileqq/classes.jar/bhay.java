import android.view.View;
import android.view.View.OnClickListener;
import cooperation.qzone.QzoneVerticalVideoDownloadActivity;

public class bhay
  implements View.OnClickListener
{
  public bhay(QzoneVerticalVideoDownloadActivity paramQzoneVerticalVideoDownloadActivity) {}
  
  public void onClick(View paramView)
  {
    QzoneVerticalVideoDownloadActivity.access$502(this.a, true);
    QzoneVerticalVideoDownloadActivity.access$600(this.a);
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bhay
 * JD-Core Version:    0.7.0.1
 */