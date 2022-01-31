import com.tencent.ttpic.videoshelf.model.VideoShelfEngine.Callback;
import dov.com.qq.im.ae.play.AEVideoShelfPreviewFragment;
import java.lang.ref.WeakReference;

public class bixu
  implements VideoShelfEngine.Callback
{
  private WeakReference<AEVideoShelfPreviewFragment> a;
  
  public bixu(AEVideoShelfPreviewFragment paramAEVideoShelfPreviewFragment)
  {
    this.a = new WeakReference(paramAEVideoShelfPreviewFragment);
  }
  
  public void onCancelCompleted()
  {
    if ((this.a != null) && (this.a.get() != null)) {
      AEVideoShelfPreviewFragment.e((AEVideoShelfPreviewFragment)this.a.get());
    }
  }
  
  public void onCompleted()
  {
    if ((this.a != null) && (this.a.get() != null)) {
      ((AEVideoShelfPreviewFragment)this.a.get()).onCompletion();
    }
  }
  
  public void onError(int paramInt1, int paramInt2, String paramString)
  {
    if ((this.a != null) && (this.a.get() != null)) {
      AEVideoShelfPreviewFragment.a((AEVideoShelfPreviewFragment)this.a.get(), paramInt1, paramInt2, paramString);
    }
  }
  
  public void onProgress(int paramInt)
  {
    if ((this.a != null) && (this.a.get() != null)) {
      AEVideoShelfPreviewFragment.b((AEVideoShelfPreviewFragment)this.a.get(), paramInt);
    }
  }
  
  public void onStartGenerate()
  {
    if ((this.a != null) && (this.a.get() != null)) {
      AEVideoShelfPreviewFragment.d((AEVideoShelfPreviewFragment)this.a.get());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bixu
 * JD-Core Version:    0.7.0.1
 */