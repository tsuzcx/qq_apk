import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.colornote.smallscreen.ColorNoteSmallScreenPermissionDialogFragment;

public class amjp
  implements DialogInterface.OnClickListener
{
  public amjp(ColorNoteSmallScreenPermissionDialogFragment paramColorNoteSmallScreenPermissionDialogFragment) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    paramDialogInterface = bbdj.a(this.a.getActivity(), 230).setMessage(2131690869).setNegativeButton(2131690857, new amjr(this)).setPositiveButton(2131690859, new amjq(this));
    paramDialogInterface.setOnDismissListener(new amjs(this));
    paramDialogInterface.setCancelable(false);
    paramDialogInterface.setCanceledOnTouchOutside(false);
    paramDialogInterface.show();
    axqy.b(null, "dc00898", "", "", "0X800AB3B", "0X800AB3B", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     amjp
 * JD-Core Version:    0.7.0.1
 */