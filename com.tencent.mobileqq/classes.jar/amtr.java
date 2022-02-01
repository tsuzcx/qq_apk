import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.ImageView;

class amtr
  implements DialogInterface.OnClickListener
{
  amtr(amtp paramamtp) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (amtp.a(this.a) != null)
    {
      amtp.b(this.a).setVisibility(8);
      amtp.c(this.a).setVisibility(8);
      amtp.b(this.a, false);
      amtp.a(this.a).a();
    }
    this.a.a(6, 3, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amtr
 * JD-Core Version:    0.7.0.1
 */