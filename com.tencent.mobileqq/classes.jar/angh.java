import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.ark.open.ArkAppCacheMgr.OnGetAppIcon;
import com.tencent.mobileqq.ark.API.ArkAppModuleReg.ModuleQQ.8;

public class angh
  implements ArkAppCacheMgr.OnGetAppIcon
{
  public angh(ArkAppModuleReg.ModuleQQ.8 param8, bdfq parambdfq) {}
  
  public void callback(String paramString, Bitmap paramBitmap)
  {
    if (paramBitmap != null) {
      ((ImageView)this.jdField_a_of_type_Bdfq.findViewById(2131365190)).setImageBitmap(paramBitmap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     angh
 * JD-Core Version:    0.7.0.1
 */