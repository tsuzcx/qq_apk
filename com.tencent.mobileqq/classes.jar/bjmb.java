import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.music.QzoneWebMusicJsPlugin;

public class bjmb
  implements DialogInterface.OnClickListener
{
  public bjmb(QzoneWebMusicJsPlugin paramQzoneWebMusicJsPlugin) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.resumePlay();
    LocalMultiProcConfig.putBool("qzbg_music_mobinet_tips", true);
    paramDialogInterface.dismiss();
    QzoneWebMusicJsPlugin.access$902(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bjmb
 * JD-Core Version:    0.7.0.1
 */