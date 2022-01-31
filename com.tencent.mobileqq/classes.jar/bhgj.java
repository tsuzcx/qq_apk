import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.music.QzoneWebMusicJsPlugin;

public class bhgj
  implements DialogInterface.OnClickListener
{
  public bhgj(QzoneWebMusicJsPlugin paramQzoneWebMusicJsPlugin) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.resumePlay();
    LocalMultiProcConfig.putBool("qzbg_music_mobinet_tips", true);
    paramDialogInterface.dismiss();
    QzoneWebMusicJsPlugin.access$902(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bhgj
 * JD-Core Version:    0.7.0.1
 */