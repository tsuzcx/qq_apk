import android.graphics.Bitmap;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.DownloadListener;
import com.tencent.mobileqq.troop.activity.TroopCreateLogicActivity;

public class bdtb
  implements URLDrawable.DownloadListener
{
  public bdtb(TroopCreateLogicActivity paramTroopCreateLogicActivity, URLDrawable paramURLDrawable, bdtc parambdtc) {}
  
  public void onFileDownloadFailed(int paramInt)
  {
    this.jdField_a_of_type_Bdtc.a(null);
  }
  
  public void onFileDownloadStarted() {}
  
  public void onFileDownloadSucceed(long paramLong)
  {
    Bitmap localBitmap = bhzk.a(this.jdField_a_of_type_ComTencentImageURLDrawable, 100, 100);
    this.jdField_a_of_type_Bdtc.a(localBitmap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdtb
 * JD-Core Version:    0.7.0.1
 */