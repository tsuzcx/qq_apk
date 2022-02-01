import android.graphics.Bitmap;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.DownloadListener;
import com.tencent.mobileqq.troop.activity.TroopCreateLogicActivity;

public class belm
  implements URLDrawable.DownloadListener
{
  public belm(TroopCreateLogicActivity paramTroopCreateLogicActivity, URLDrawable paramURLDrawable, beln parambeln) {}
  
  public void onFileDownloadFailed(int paramInt)
  {
    this.jdField_a_of_type_Beln.a(null);
  }
  
  public void onFileDownloadStarted() {}
  
  public void onFileDownloadSucceed(long paramLong)
  {
    Bitmap localBitmap = bisw.a(this.jdField_a_of_type_ComTencentImageURLDrawable, 100, 100);
    this.jdField_a_of_type_Beln.a(localBitmap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     belm
 * JD-Core Version:    0.7.0.1
 */