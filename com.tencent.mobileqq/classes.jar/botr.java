import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import dov.com.qq.im.capture.view.MusicProviderView;

public class botr
  implements DialogInterface.OnClickListener
{
  public botr(MusicProviderView paramMusicProviderView) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     botr
 * JD-Core Version:    0.7.0.1
 */