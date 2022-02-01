import android.media.AudioManager.OnAudioFocusChangeListener;
import com.tencent.mobileqq.filemanager.fileviewer.FileBrowserActivity;
import com.tencent.mobileqq.videoplatform.view.BaseVideoView;
import com.tencent.qphone.base.util.QLog;

class aswa
  implements AudioManager.OnAudioFocusChangeListener
{
  aswa(asvt paramasvt) {}
  
  public void onAudioFocusChange(int paramInt)
  {
    if (asvt.a(this.a) != null) {
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
          bool = asvt.a(this.a).isPlaying();
          if (paramInt != -2) {
            break;
          }
        } while (!bool);
        asvt.a(this.a);
        return;
        if (paramInt != 1) {
          break;
        }
      } while ((bool) || (this.a.a == null) || (!(this.a.a instanceof FileBrowserActivity)) || (!((FileBrowserActivity)this.a.a).isResume()));
      asvt.c(this.a);
      return;
    } while ((paramInt != -1) || (!bool));
    asvt.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aswa
 * JD-Core Version:    0.7.0.1
 */