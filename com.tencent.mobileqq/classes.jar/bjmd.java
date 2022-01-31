import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.music.QzoneWebMusicJsPlugin;

public class bjmd
  implements DialogInterface.OnClickListener
{
  public bjmd(QzoneWebMusicJsPlugin paramQzoneWebMusicJsPlugin, bjmi parambjmi) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    LocalMultiProcConfig.putBool("qzbg_music_mobinet_tips", true);
    if (this.jdField_a_of_type_Bjmi != null) {
      this.jdField_a_of_type_Bjmi.a();
    }
    paramDialogInterface.dismiss();
    this.jdField_a_of_type_CooperationQzoneMusicQzoneWebMusicJsPlugin.isFlowWarningVisible = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bjmd
 * JD-Core Version:    0.7.0.1
 */