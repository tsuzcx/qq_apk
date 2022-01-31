import android.graphics.Bitmap;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.DownloadListener;
import com.tencent.mobileqq.troop.activity.TroopCreateLogicActivity;

public class bbky
  implements URLDrawable.DownloadListener
{
  public bbky(TroopCreateLogicActivity paramTroopCreateLogicActivity, URLDrawable paramURLDrawable, bbkz parambbkz) {}
  
  public void onFileDownloadFailed(int paramInt)
  {
    this.jdField_a_of_type_Bbkz.a(null);
  }
  
  public void onFileDownloadStarted() {}
  
  public void onFileDownloadSucceed(long paramLong)
  {
    Bitmap localBitmap = bfln.a(this.jdField_a_of_type_ComTencentImageURLDrawable, 100, 100);
    this.jdField_a_of_type_Bbkz.a(localBitmap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbky
 * JD-Core Version:    0.7.0.1
 */