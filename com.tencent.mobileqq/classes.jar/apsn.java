import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.ark.open.ArkAppCacheMgr.OnGetAppIcon;
import com.tencent.mobileqq.ark.API.ArkAppModuleBase.APIAuthority.1;
import com.tencent.mobileqq.utils.QQCustomDialog;

public class apsn
  implements ArkAppCacheMgr.OnGetAppIcon
{
  public apsn(ArkAppModuleBase.APIAuthority.1 param1, QQCustomDialog paramQQCustomDialog) {}
  
  public void callback(String paramString, Bitmap paramBitmap)
  {
    if (paramBitmap != null) {
      ((ImageView)this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.findViewById(2131365602)).setImageBitmap(paramBitmap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apsn
 * JD-Core Version:    0.7.0.1
 */