import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.ThreadManager;
import dov.com.qq.im.capture.adapter.QIMPtvTemplateAdapter.5.1;

public class blms
  implements DialogInterface.OnClickListener
{
  blms(blmo paramblmo) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ThreadManager.excute(new QIMPtvTemplateAdapter.5.1(this), 128, null, true);
    blwn.a(this.a.a).a();
    bnck.a("shortvideo_download_effects", null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blms
 * JD-Core Version:    0.7.0.1
 */