import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import cooperation.qzone.music.QzoneWebMusicJsPlugin;

public class amwd
  implements DialogInterface.OnClickListener
{
  public amwd(QzoneWebMusicJsPlugin paramQzoneWebMusicJsPlugin) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    this.a.isFlowWarningVisible = false;
    QzoneWebMusicJsPlugin.access$300(this.a, "cancel");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amwd
 * JD-Core Version:    0.7.0.1
 */