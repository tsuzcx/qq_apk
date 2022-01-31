import android.view.View;
import android.view.View.OnClickListener;
import cooperation.qzone.QzoneVerticalVideoDownloadActivity;

public class bjcf
  implements View.OnClickListener
{
  public bjcf(QzoneVerticalVideoDownloadActivity paramQzoneVerticalVideoDownloadActivity) {}
  
  public void onClick(View paramView)
  {
    QzoneVerticalVideoDownloadActivity.access$502(this.a, true);
    QzoneVerticalVideoDownloadActivity.access$600(this.a);
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bjcf
 * JD-Core Version:    0.7.0.1
 */