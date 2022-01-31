import android.os.Handler;
import com.tencent.mobileqq.app.ThreadExcutor.IThreadListener;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.FeedsManager;
import com.tencent.mobileqq.data.FeedsManager.2.1;

public class aozp
  implements ThreadExcutor.IThreadListener
{
  public aozp(FeedsManager paramFeedsManager) {}
  
  public void onAdded() {}
  
  public void onPostRun()
  {
    FeedsManager.access$102(this.a, true);
    ThreadManagerV2.getUIHandlerV2().post(new FeedsManager.2.1(this));
    if (FeedsManager.access$300(this.a))
    {
      FeedsManager.access$302(this.a, false);
      this.a.updateQzoneFeeds();
    }
  }
  
  public void onPreRun() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aozp
 * JD-Core Version:    0.7.0.1
 */