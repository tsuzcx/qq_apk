import android.graphics.Bitmap;
import com.qq.im.poi.LbsPackListAdapter;
import com.tencent.mobileqq.armap.NonMainAppHeadLoader.FaceObserver;

public class anc
  implements NonMainAppHeadLoader.FaceObserver
{
  public anc(LbsPackListAdapter paramLbsPackListAdapter) {}
  
  public void onFaceUpdate(String paramString1, String paramString2, Bitmap paramBitmap)
  {
    this.a.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     anc
 * JD-Core Version:    0.7.0.1
 */