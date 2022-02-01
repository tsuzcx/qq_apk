import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.ark.open.ArkAppCacheMgr.OnGetAppIcon;

class aqdb
  implements ArkAppCacheMgr.OnGetAppIcon
{
  aqdb(aqcz paramaqcz, Context paramContext) {}
  
  public void callback(String paramString, Bitmap paramBitmap)
  {
    if (paramBitmap != null) {
      aqcz.a(this.jdField_a_of_type_Aqcz, paramBitmap, this.jdField_a_of_type_AndroidContentContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqdb
 * JD-Core Version:    0.7.0.1
 */