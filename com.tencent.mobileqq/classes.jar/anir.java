import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.ark.open.ArkAppCacheMgr.OnGetAppIcon;
import com.tencent.mobileqq.ark.API.ArkAppDeviceModule.ObserverMethod.6;

public class anir
  implements ArkAppCacheMgr.OnGetAppIcon
{
  public anir(ArkAppDeviceModule.ObserverMethod.6 param6, bdjz parambdjz) {}
  
  public void callback(String paramString, Bitmap paramBitmap)
  {
    if (paramBitmap != null) {
      ((ImageView)this.jdField_a_of_type_Bdjz.findViewById(2131365192)).setImageBitmap(paramBitmap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anir
 * JD-Core Version:    0.7.0.1
 */