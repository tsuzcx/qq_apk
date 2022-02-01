import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class bpfs
  implements DialogInterface.OnClickListener
{
  bpfs(bpfp parambpfp) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    bpfp.a(this.a);
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpfs
 * JD-Core Version:    0.7.0.1
 */