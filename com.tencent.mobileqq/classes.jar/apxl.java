import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.ark.API.ArkAppSchemeCenter.TelSchemeHandler.1;

public class apxl
  implements DialogInterface.OnClickListener
{
  public apxl(ArkAppSchemeCenter.TelSchemeHandler.1 param1, bhpc parambhpc) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if ((this.jdField_a_of_type_Bhpc != null) && (this.jdField_a_of_type_Bhpc.isShowing())) {}
    try
    {
      this.jdField_a_of_type_Bhpc.dismiss();
      return;
    }
    catch (Exception paramDialogInterface) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apxl
 * JD-Core Version:    0.7.0.1
 */