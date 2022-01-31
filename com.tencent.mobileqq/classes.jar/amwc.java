import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.music.QzoneWebMusicJsPlugin;

public class amwc
  implements DialogInterface.OnClickListener
{
  public amwc(QzoneWebMusicJsPlugin paramQzoneWebMusicJsPlugin, amwl paramamwl) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    LocalMultiProcConfig.putBool("qzbg_music_mobinet_tips", true);
    if (this.jdField_a_of_type_Amwl != null) {
      this.jdField_a_of_type_Amwl.a();
    }
    paramDialogInterface.dismiss();
    this.jdField_a_of_type_CooperationQzoneMusicQzoneWebMusicJsPlugin.isFlowWarningVisible = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amwc
 * JD-Core Version:    0.7.0.1
 */