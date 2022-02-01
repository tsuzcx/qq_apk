import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.ark.open.ArkAppCacheMgr.OnGetAppIcon;

class apzq
  implements ArkAppCacheMgr.OnGetAppIcon
{
  apzq(apzo paramapzo, Context paramContext) {}
  
  public void callback(String paramString, Bitmap paramBitmap)
  {
    if (paramBitmap != null) {
      apzo.a(this.jdField_a_of_type_Apzo, paramBitmap, this.jdField_a_of_type_AndroidContentContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apzq
 * JD-Core Version:    0.7.0.1
 */