import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import java.util.Iterator;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onDismiss"}, k=3, mv={1, 1, 16})
final class baay
  implements DialogInterface.OnDismissListener
{
  baay(baau parambaau, int paramInt1, int paramInt2) {}
  
  public final void onDismiss(DialogInterface paramDialogInterface)
  {
    paramDialogInterface = ((Iterable)baau.a(this.jdField_a_of_type_Baau)).iterator();
    while (paramDialogInterface.hasNext()) {
      ((baav)paramDialogInterface.next()).c(this.jdField_a_of_type_Int, this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     baay
 * JD-Core Version:    0.7.0.1
 */