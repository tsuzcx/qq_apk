import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.ark.open.ArkAppCacheMgr.OnGetAppIcon;
import com.tencent.mobileqq.ark.API.ArkAppModuleBase.APIAuthority.1;
import com.tencent.mobileqq.utils.QQCustomDialog;

public class aopm
  implements ArkAppCacheMgr.OnGetAppIcon
{
  public aopm(ArkAppModuleBase.APIAuthority.1 param1, QQCustomDialog paramQQCustomDialog) {}
  
  public void callback(String paramString, Bitmap paramBitmap)
  {
    if (paramBitmap != null) {
      ((ImageView)this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.findViewById(2131365510)).setImageBitmap(paramBitmap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aopm
 * JD-Core Version:    0.7.0.1
 */