import android.graphics.Bitmap;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.DownloadListener;
import com.tencent.mobileqq.troop.activity.TroopCreateLogicActivity;

public class azie
  implements URLDrawable.DownloadListener
{
  public azie(TroopCreateLogicActivity paramTroopCreateLogicActivity, URLDrawable paramURLDrawable, azif paramazif) {}
  
  public void onFileDownloadFailed(int paramInt)
  {
    this.jdField_a_of_type_Azif.a(null);
  }
  
  public void onFileDownloadStarted() {}
  
  public void onFileDownloadSucceed(long paramLong)
  {
    Bitmap localBitmap = bdhr.a(this.jdField_a_of_type_ComTencentImageURLDrawable, 100, 100);
    this.jdField_a_of_type_Azif.a(localBitmap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     azie
 * JD-Core Version:    0.7.0.1
 */