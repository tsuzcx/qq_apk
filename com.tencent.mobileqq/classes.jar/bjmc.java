import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import cooperation.qzone.music.QzoneWebMusicJsPlugin;

public class bjmc
  implements DialogInterface.OnClickListener
{
  public bjmc(QzoneWebMusicJsPlugin paramQzoneWebMusicJsPlugin) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.stopPlay();
    QzoneWebMusicJsPlugin.access$300(this.a, "cancel");
    paramDialogInterface.dismiss();
    QzoneWebMusicJsPlugin.access$902(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bjmc
 * JD-Core Version:    0.7.0.1
 */