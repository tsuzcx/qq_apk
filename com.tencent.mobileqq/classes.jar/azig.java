import android.graphics.Bitmap;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.DownloadListener;
import com.tencent.mobileqq.troop.activity.TroopCreateLogicActivity;

public class azig
  implements URLDrawable.DownloadListener
{
  public azig(TroopCreateLogicActivity paramTroopCreateLogicActivity, URLDrawable paramURLDrawable, azih paramazih) {}
  
  public void onFileDownloadFailed(int paramInt)
  {
    this.jdField_a_of_type_Azih.a(null);
  }
  
  public void onFileDownloadStarted() {}
  
  public void onFileDownloadSucceed(long paramLong)
  {
    Bitmap localBitmap = bdig.a(this.jdField_a_of_type_ComTencentImageURLDrawable, 100, 100);
    this.jdField_a_of_type_Azih.a(localBitmap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     azig
 * JD-Core Version:    0.7.0.1
 */