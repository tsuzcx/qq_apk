import android.graphics.Bitmap;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;

class aury
  implements bcwt
{
  aury(auru paramauru) {}
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    synchronized (this.a.a)
    {
      if (this.a.a.contains(paramString))
      {
        if (QLog.isColorLevel()) {
          QLog.d("NearbyProxy", 2, "onDecodeTaskCompleted: reqUin=" + paramString + ", avatar=" + paramBitmap);
        }
        this.a.a.remove(paramString);
        auru.a(this.a, 4161, new Object[] { Integer.valueOf(paramInt2), paramString, paramBitmap });
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aury
 * JD-Core Version:    0.7.0.1
 */