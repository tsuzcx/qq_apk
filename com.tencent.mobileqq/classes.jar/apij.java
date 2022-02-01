import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.ark.open.ArkAppCacheMgr.OnGetAppIcon;
import com.tencent.mobileqq.ark.API.ArkAppModuleBase.APIAuthority.1;

public class apij
  implements ArkAppCacheMgr.OnGetAppIcon
{
  public apij(ArkAppModuleBase.APIAuthority.1 param1, bgpa parambgpa) {}
  
  public void callback(String paramString, Bitmap paramBitmap)
  {
    if (paramBitmap != null) {
      ((ImageView)this.jdField_a_of_type_Bgpa.findViewById(2131365434)).setImageBitmap(paramBitmap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apij
 * JD-Core Version:    0.7.0.1
 */