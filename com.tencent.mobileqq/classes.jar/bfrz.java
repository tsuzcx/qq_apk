import android.view.View;
import android.view.View.OnClickListener;
import cooperation.qzone.QzoneVerticalVideoDownloadActivity;

public class bfrz
  implements View.OnClickListener
{
  public bfrz(QzoneVerticalVideoDownloadActivity paramQzoneVerticalVideoDownloadActivity) {}
  
  public void onClick(View paramView)
  {
    if (!QzoneVerticalVideoDownloadActivity.access$200(this.a))
    {
      QzoneVerticalVideoDownloadActivity.access$300(this.a, false, false);
      QzoneVerticalVideoDownloadActivity.access$400(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bfrz
 * JD-Core Version:    0.7.0.1
 */