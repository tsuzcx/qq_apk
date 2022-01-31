import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.ark.open.ArkAppCacheMgr.OnGetAppIcon;
import com.tencent.mobileqq.ark.API.ArkAppModuleReg.ModuleQQ.7;

public class ankn
  implements ArkAppCacheMgr.OnGetAppIcon
{
  public ankn(ArkAppModuleReg.ModuleQQ.7 param7, bdjz parambdjz) {}
  
  public void callback(String paramString, Bitmap paramBitmap)
  {
    if (paramBitmap != null) {
      ((ImageView)this.jdField_a_of_type_Bdjz.findViewById(2131365192)).setImageBitmap(paramBitmap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ankn
 * JD-Core Version:    0.7.0.1
 */