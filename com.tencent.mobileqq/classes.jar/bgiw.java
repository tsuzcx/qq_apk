import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.qqmini.sdk.core.cache.MiniCacheFreeManager.1;

public class bgiw
  implements DialogInterface.OnClickListener
{
  public bgiw(MiniCacheFreeManager.1 param1) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    bgiv.a(this.a.b, this.a.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo);
    if (this.a.jdField_a_of_type_AndroidAppActivity != null) {
      this.a.jdField_a_of_type_AndroidAppActivity.finish();
    }
    if (paramDialogInterface != null) {
      paramDialogInterface.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgiw
 * JD-Core Version:    0.7.0.1
 */