import android.graphics.Bitmap;
import com.tencent.ark.open.ArkAppCacheMgr.OnGetAppIcon;

class aqdd
  implements ArkAppCacheMgr.OnGetAppIcon
{
  aqdd(aqdc paramaqdc) {}
  
  public void callback(String paramString, Bitmap paramBitmap)
  {
    if (paramBitmap != null) {
      aqcz.a(this.a.jdField_a_of_type_Aqcz, paramBitmap, this.a.jdField_a_of_type_AndroidContentContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqdd
 * JD-Core Version:    0.7.0.1
 */