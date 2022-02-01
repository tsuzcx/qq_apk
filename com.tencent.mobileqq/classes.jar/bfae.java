import android.graphics.Bitmap;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.DownloadListener;
import com.tencent.mobileqq.troop.activity.TroopCreateLogicActivity;

public class bfae
  implements URLDrawable.DownloadListener
{
  public bfae(TroopCreateLogicActivity paramTroopCreateLogicActivity, URLDrawable paramURLDrawable, bfaf parambfaf) {}
  
  public void onFileDownloadFailed(int paramInt)
  {
    this.jdField_a_of_type_Bfaf.a(null);
  }
  
  public void onFileDownloadStarted() {}
  
  public void onFileDownloadSucceed(long paramLong)
  {
    Bitmap localBitmap = bjkm.a(this.jdField_a_of_type_ComTencentImageURLDrawable, 100, 100);
    this.jdField_a_of_type_Bfaf.a(localBitmap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bfae
 * JD-Core Version:    0.7.0.1
 */