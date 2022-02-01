import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QzoneVerticalVideoDownloadActivity;

public class bmvt
  implements URLDrawable.URLDrawableListener
{
  public bmvt(QzoneVerticalVideoDownloadActivity paramQzoneVerticalVideoDownloadActivity) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable) {}
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    QLog.w("QzoneVerticalVideoDownloadActivity", 1, "onLoadFialed");
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    QzoneVerticalVideoDownloadActivity.access$100(this.a).setImageDrawable(paramURLDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmvt
 * JD-Core Version:    0.7.0.1
 */