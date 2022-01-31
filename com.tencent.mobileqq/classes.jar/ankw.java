import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.ark.open.ArkAppCacheMgr.OnGetAppIcon;

class ankw
  implements ArkAppCacheMgr.OnGetAppIcon
{
  ankw(anku paramanku, Context paramContext) {}
  
  public void callback(String paramString, Bitmap paramBitmap)
  {
    if (paramBitmap != null) {
      anku.a(this.jdField_a_of_type_Anku, paramBitmap, this.jdField_a_of_type_AndroidContentContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ankw
 * JD-Core Version:    0.7.0.1
 */