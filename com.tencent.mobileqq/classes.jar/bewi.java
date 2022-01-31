import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.qqmini.sdk.core.MiniAppEnv;

class bewi
  implements DialogInterface.OnDismissListener
{
  bewi(bewh parambewh, String paramString1, String paramString2, bewo parambewo) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    paramDialogInterface = (bemx)paramDialogInterface;
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
      bewh.a(this.jdField_a_of_type_Bewh, null);
      if (this.jdField_a_of_type_Bewo != null)
      {
        if (!bool1) {
          break;
        }
        this.jdField_a_of_type_Bewo.a(true);
      }
      return;
      label81:
      if (bool2) {
        MiniAppEnv.g().getAuthSate(this.jdField_a_of_type_JavaLangString).a(this.b, false);
      }
    }
    if (bool2)
    {
      this.jdField_a_of_type_Bewo.a(false);
      return;
    }
    betc.a("MiniGameAuthorizeManager", "showDialog, onDismiss: just dismiss");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bewi
 * JD-Core Version:    0.7.0.1
 */