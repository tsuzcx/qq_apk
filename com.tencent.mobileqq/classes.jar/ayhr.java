import android.graphics.Bitmap;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.DownloadListener;
import com.tencent.mobileqq.troop.activity.TroopCreateLogicActivity;

public class ayhr
  implements URLDrawable.DownloadListener
{
  public ayhr(TroopCreateLogicActivity paramTroopCreateLogicActivity, URLDrawable paramURLDrawable, ayhs paramayhs) {}
  
  public void onFileDownloadFailed(int paramInt)
  {
    this.jdField_a_of_type_Ayhs.a(null);
  }
  
  public void onFileDownloadStarted() {}
  
  public void onFileDownloadSucceed(long paramLong)
  {
    Bitmap localBitmap = bcdq.a(this.jdField_a_of_type_ComTencentImageURLDrawable, 100, 100);
    this.jdField_a_of_type_Ayhs.a(localBitmap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     ayhr
 * JD-Core Version:    0.7.0.1
 */