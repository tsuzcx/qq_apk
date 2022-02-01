import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.utils.QQCustomDialog;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onClick"}, k=3, mv={1, 1, 16})
final class bdvj
  implements DialogInterface.OnClickListener
{
  bdvj(bdve parambdve, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if ((paramDialogInterface instanceof QQCustomDialog)) {
      ((QQCustomDialog)paramDialogInterface).setOnDismissListener(null);
    }
    bdve.a(this.jdField_a_of_type_Bdve, this.jdField_a_of_type_Int, this.b, this.c, this.jdField_a_of_type_Boolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdvj
 * JD-Core Version:    0.7.0.1
 */