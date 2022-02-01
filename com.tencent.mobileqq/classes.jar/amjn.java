import android.graphics.Bitmap;
import com.tencent.mobileqq.app.face.FaceDecoder;

class amjn
  extends aofu
{
  amjn(amjm paramamjm) {}
  
  protected void onUpdateNewTroopFaceIcon(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    Bitmap localBitmap = this.a.a.getBitmapFromCache(113, paramString);
    if (localBitmap != null) {
      this.a.a(paramString, localBitmap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amjn
 * JD-Core Version:    0.7.0.1
 */