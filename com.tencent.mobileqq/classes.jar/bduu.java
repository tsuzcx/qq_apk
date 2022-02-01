import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onClick"}, k=3, mv={1, 1, 16})
final class bduu
  implements DialogInterface.OnClickListener
{
  bduu(bdup parambdup, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if ((paramDialogInterface instanceof bhpc)) {
      ((bhpc)paramDialogInterface).setOnDismissListener(null);
    }
    bdup.a(this.jdField_a_of_type_Bdup, this.jdField_a_of_type_Int, this.b, this.c, this.jdField_a_of_type_Boolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bduu
 * JD-Core Version:    0.7.0.1
 */