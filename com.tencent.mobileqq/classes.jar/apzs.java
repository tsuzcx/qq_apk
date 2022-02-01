import android.graphics.Bitmap;
import com.tencent.ark.open.ArkAppCacheMgr.OnGetAppIcon;

class apzs
  implements ArkAppCacheMgr.OnGetAppIcon
{
  apzs(apzr paramapzr) {}
  
  public void callback(String paramString, Bitmap paramBitmap)
  {
    if (paramBitmap != null) {
      apzo.a(this.a.jdField_a_of_type_Apzo, paramBitmap, this.a.jdField_a_of_type_AndroidContentContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apzs
 * JD-Core Version:    0.7.0.1
 */