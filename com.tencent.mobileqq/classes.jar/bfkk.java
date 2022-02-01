import android.graphics.Bitmap;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.DownloadListener;
import com.tencent.mobileqq.troop.activity.TroopCreateLogicActivity;

public class bfkk
  implements URLDrawable.DownloadListener
{
  public bfkk(TroopCreateLogicActivity paramTroopCreateLogicActivity, URLDrawable paramURLDrawable, bfkl parambfkl) {}
  
  public void onFileDownloadFailed(int paramInt)
  {
    this.jdField_a_of_type_Bfkl.a(null);
  }
  
  public void onFileDownloadStarted() {}
  
  public void onFileDownloadSucceed(long paramLong)
  {
    Bitmap localBitmap = bjtv.a(this.jdField_a_of_type_ComTencentImageURLDrawable, 100, 100);
    this.jdField_a_of_type_Bfkl.a(localBitmap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfkk
 * JD-Core Version:    0.7.0.1
 */