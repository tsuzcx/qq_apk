import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onClick"}, k=3, mv={1, 1, 16})
final class bdcd
  implements DialogInterface.OnClickListener
{
  bdcd(bdby parambdby, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if ((paramDialogInterface instanceof bgpa)) {
      ((bgpa)paramDialogInterface).setOnDismissListener(null);
    }
    bdby.a(this.jdField_a_of_type_Bdby, this.jdField_a_of_type_Int, this.b, this.c, this.jdField_a_of_type_Boolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdcd
 * JD-Core Version:    0.7.0.1
 */