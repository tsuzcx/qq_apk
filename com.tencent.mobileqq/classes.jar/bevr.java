import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.qqmini.sdk.core.MiniAppEnv;

class bevr
  implements DialogInterface.OnDismissListener
{
  bevr(bevq parambevq, String paramString1, String paramString2, bevx parambevx) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    paramDialogInterface = (bemg)paramDialogInterface;
    boolean bool1 = paramDialogInterface.a();
    boolean bool2 = paramDialogInterface.b();
    if (MiniAppEnv.g().getAuthSate(this.jdField_a_of_type_JavaLangString) != null)
    {
      if (!bool1) {
        break label81;
      }
      MiniAppEnv.g().getAuthSate(this.jdField_a_of_type_JavaLangString).a(this.b, true);
    }
    for (;;)
    {
      bevq.a(this.jdField_a_of_type_Bevq, null);
      if (this.jdField_a_of_type_Bevx != null)
      {
        if (!bool1) {
          break;
        }
        this.jdField_a_of_type_Bevx.a(true);
      }
      return;
      label81:
      if (bool2) {
        MiniAppEnv.g().getAuthSate(this.jdField_a_of_type_JavaLangString).a(this.b, false);
      }
    }
    if (bool2)
    {
      this.jdField_a_of_type_Bevx.a(false);
      return;
    }
    besl.a("MiniGameAuthorizeManager", "showDialog, onDismiss: just dismiss");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bevr
 * JD-Core Version:    0.7.0.1
 */