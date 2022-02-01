import android.graphics.Bitmap;
import com.tencent.ark.open.ArkAppCacheMgr.OnGetAppIcon;

class appn
  implements ArkAppCacheMgr.OnGetAppIcon
{
  appn(appm paramappm) {}
  
  public void callback(String paramString, Bitmap paramBitmap)
  {
    if (paramBitmap != null) {
      appj.a(this.a.jdField_a_of_type_Appj, paramBitmap, this.a.jdField_a_of_type_AndroidContentContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     appn
 * JD-Core Version:    0.7.0.1
 */