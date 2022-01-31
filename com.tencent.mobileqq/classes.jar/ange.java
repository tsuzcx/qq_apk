import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.ark.open.ArkAppCacheMgr.OnGetAppIcon;
import com.tencent.mobileqq.ark.API.ArkAppModuleReg.ModuleQQ.7;

public class ange
  implements ArkAppCacheMgr.OnGetAppIcon
{
  public ange(ArkAppModuleReg.ModuleQQ.7 param7, bdfq parambdfq) {}
  
  public void callback(String paramString, Bitmap paramBitmap)
  {
    if (paramBitmap != null) {
      ((ImageView)this.jdField_a_of_type_Bdfq.findViewById(2131365190)).setImageBitmap(paramBitmap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ange
 * JD-Core Version:    0.7.0.1
 */