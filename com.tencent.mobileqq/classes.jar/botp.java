import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import dov.com.qq.im.capture.view.MusicProviderView;

public class botp
  implements DialogInterface.OnClickListener
{
  public botp(MusicProviderView paramMusicProviderView) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     botp
 * JD-Core Version:    0.7.0.1
 */