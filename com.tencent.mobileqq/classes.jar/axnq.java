import android.content.Context;
import android.os.SystemClock;
import com.tencent.image.URLDrawable.DownloadListener;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.nearby.ImgDownloadListener.1;
import com.tencent.mobileqq.nearby.ImgDownloadListener.2;

public class axnq
  implements URLDrawable.DownloadListener
{
  private long jdField_a_of_type_Long;
  private Context jdField_a_of_type_AndroidContentContext;
  private String jdField_a_of_type_JavaLangString = "freshnews.small_pic_download";
  
  public axnq(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public axnq(Context paramContext, String paramString)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void onFileDownloadFailed(int paramInt)
  {
    ThreadManager.postImmediately(new ImgDownloadListener.2(this, paramInt), null, true);
  }
  
  public void onFileDownloadStarted()
  {
    this.jdField_a_of_type_Long = SystemClock.elapsedRealtime();
  }
  
  public void onFileDownloadSucceed(long paramLong)
  {
    ThreadManager.postImmediately(new ImgDownloadListener.1(this, paramLong), null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axnq
 * JD-Core Version:    0.7.0.1
 */