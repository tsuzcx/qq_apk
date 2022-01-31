import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

final class aocs
  implements DialogInterface.OnClickListener
{
  aocs(bdjz parambdjz, Context paramContext) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.jdField_a_of_type_Bdjz.isShowing()) {
      this.jdField_a_of_type_Bdjz.dismiss();
    }
    aofm.a(this.jdField_a_of_type_AndroidContentContext, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aocs
 * JD-Core Version:    0.7.0.1
 */