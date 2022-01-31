import com.tencent.ttpic.videoshelf.model.VideoShelfEngine.Callback;
import dov.com.qq.im.ae.play.AEVideoShelfEditFragment;
import java.lang.ref.WeakReference;

public class blda
  implements VideoShelfEngine.Callback
{
  private WeakReference<AEVideoShelfEditFragment> a;
  
  public blda(AEVideoShelfEditFragment paramAEVideoShelfEditFragment)
  {
    this.a = new WeakReference(paramAEVideoShelfEditFragment);
  }
  
  public void onCancelCompleted()
  {
    if ((this.a != null) && (this.a.get() != null)) {
      ((AEVideoShelfEditFragment)this.a.get()).e();
    }
  }
  
  public void onCompleted()
  {
    if ((this.a != null) && (this.a.get() != null)) {
      ((AEVideoShelfEditFragment)this.a.get()).d();
    }
  }
  
  public void onError(int paramInt1, int paramInt2, String paramString)
  {
    if ((this.a != null) && (this.a.get() != null)) {
      ((AEVideoShelfEditFragment)this.a.get()).a(paramInt1, paramInt2, paramString);
    }
  }
  
  public void onProgress(int paramInt)
  {
    if ((this.a != null) && (this.a.get() != null)) {
      ((AEVideoShelfEditFragment)this.a.get()).a(paramInt);
    }
  }
  
  public void onStartGenerate()
  {
    if ((this.a != null) && (this.a.get() != null)) {
      ((AEVideoShelfEditFragment)this.a.get()).c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blda
 * JD-Core Version:    0.7.0.1
 */