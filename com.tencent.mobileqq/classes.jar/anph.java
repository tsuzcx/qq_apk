import android.graphics.Bitmap;
import com.tencent.ark.open.ArkAppCacheMgr.OnGetAppIcon;

class anph
  implements ArkAppCacheMgr.OnGetAppIcon
{
  anph(anpg paramanpg) {}
  
  public void callback(String paramString, Bitmap paramBitmap)
  {
    if (paramBitmap != null) {
      anpd.a(this.a.jdField_a_of_type_Anpd, paramBitmap, this.a.jdField_a_of_type_AndroidContentContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anph
 * JD-Core Version:    0.7.0.1
 */