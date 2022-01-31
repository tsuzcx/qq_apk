import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.ark.open.ArkAppCacheMgr.OnGetAppIcon;
import com.tencent.mobileqq.ark.API.ArkAppDeviceModule.ObserverMethod.3;

public class anec
  implements ArkAppCacheMgr.OnGetAppIcon
{
  public anec(ArkAppDeviceModule.ObserverMethod.3 param3, bdfq parambdfq) {}
  
  public void callback(String paramString, Bitmap paramBitmap)
  {
    if (paramBitmap != null) {
      ((ImageView)this.jdField_a_of_type_Bdfq.findViewById(2131365190)).setImageBitmap(paramBitmap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anec
 * JD-Core Version:    0.7.0.1
 */