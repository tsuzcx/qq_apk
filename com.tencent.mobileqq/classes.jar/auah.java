import android.media.AudioManager.OnAudioFocusChangeListener;
import com.tencent.mobileqq.filemanager.fileviewer.FileBrowserActivity;
import com.tencent.mobileqq.videoplatform.view.BaseVideoView;
import com.tencent.qphone.base.util.QLog;

class auah
  implements AudioManager.OnAudioFocusChangeListener
{
  auah(auaa paramauaa) {}
  
  public void onAudioFocusChange(int paramInt)
  {
    if (auaa.a(this.a) != null) {
      QLog.w("FileBrowserPresenter<FileAssistant>", 1, "onAudioFocusChange:mVideoView null!");
    }
    boolean bool;
    do
    {
      do
      {
        do
        {
          return;
          bool = auaa.a(this.a).isPlaying();
          if (paramInt != -2) {
            break;
          }
        } while (!bool);
        auaa.a(this.a);
        return;
        if (paramInt != 1) {
          break;
        }
      } while ((bool) || (this.a.a == null) || (!(this.a.a instanceof FileBrowserActivity)) || (!((FileBrowserActivity)this.a.a).isResume()));
      auaa.c(this.a);
      return;
    } while ((paramInt != -1) || (!bool));
    auaa.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auah
 * JD-Core Version:    0.7.0.1
 */