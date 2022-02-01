import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.ThreadManager;
import dov.com.tencent.mobileqq.activity.shortvideo.ShortVideoPlayActivity;
import dov.com.tencent.mobileqq.shortvideo.ShortVideoUtils.VideoFileSaveRunnable;
import mqq.os.MqqHandler;

class bpmc
  implements DialogInterface.OnClickListener
{
  bpmc(bpmb parambpmb) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ThreadManager.getFileThreadHandler().post(new ShortVideoUtils.VideoFileSaveRunnable(this.a.a.b, this.a.a.a, this.a.a.g + ".mp4", true));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpmc
 * JD-Core Version:    0.7.0.1
 */