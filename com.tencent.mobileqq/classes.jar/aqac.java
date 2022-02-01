import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.ark.open.ArkAppCacheMgr.OnGetAppIcon;

class aqac
  implements ArkAppCacheMgr.OnGetAppIcon
{
  aqac(aqab paramaqab, aqad paramaqad) {}
  
  public void callback(String paramString, Bitmap paramBitmap)
  {
    if (paramBitmap != null) {
      this.jdField_a_of_type_Aqad.a.setImageBitmap(paramBitmap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqac
 * JD-Core Version:    0.7.0.1
 */