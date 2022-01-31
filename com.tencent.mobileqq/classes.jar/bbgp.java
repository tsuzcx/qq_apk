import android.graphics.Bitmap;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.DownloadListener;
import com.tencent.mobileqq.troop.activity.TroopCreateLogicActivity;

public class bbgp
  implements URLDrawable.DownloadListener
{
  public bbgp(TroopCreateLogicActivity paramTroopCreateLogicActivity, URLDrawable paramURLDrawable, bbgq parambbgq) {}
  
  public void onFileDownloadFailed(int paramInt)
  {
    this.jdField_a_of_type_Bbgq.a(null);
  }
  
  public void onFileDownloadStarted() {}
  
  public void onFileDownloadSucceed(long paramLong)
  {
    Bitmap localBitmap = bfhe.a(this.jdField_a_of_type_ComTencentImageURLDrawable, 100, 100);
    this.jdField_a_of_type_Bbgq.a(localBitmap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbgp
 * JD-Core Version:    0.7.0.1
 */