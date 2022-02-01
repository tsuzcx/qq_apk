import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.ark.open.ArkAppCacheMgr.OnGetAppIcon;
import com.tencent.mobileqq.ark.API.ArkAppModuleBase.APIAuthority.1;

public class apvz
  implements ArkAppCacheMgr.OnGetAppIcon
{
  public apvz(ArkAppModuleBase.APIAuthority.1 param1, bhpc parambhpc) {}
  
  public void callback(String paramString, Bitmap paramBitmap)
  {
    if (paramBitmap != null) {
      ((ImageView)this.jdField_a_of_type_Bhpc.findViewById(2131365478)).setImageBitmap(paramBitmap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apvz
 * JD-Core Version:    0.7.0.1
 */