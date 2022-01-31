import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.videoshelf.model.player.IVideoShelfPlayer;
import com.tencent.ttpic.videoshelf.model.player.IVideoShelfPlayerListener;
import dov.com.qq.im.ae.play.AETemplateInfoFragment;
import java.lang.ref.WeakReference;

public class blcp
  implements IVideoShelfPlayerListener
{
  private WeakReference<AETemplateInfoFragment> a;
  
  public blcp(AETemplateInfoFragment paramAETemplateInfoFragment)
  {
    this.a = new WeakReference(paramAETemplateInfoFragment);
  }
  
  public void onChangVideoSize(int paramInt1, int paramInt2) {}
  
  public void onCompletion()
  {
    QLog.i("AETemplateInfoFragment", 1, "[player lifecycle]---PlayerListener onCompletion");
    if ((this.a != null) && (this.a.get() != null)) {
      ((AETemplateInfoFragment)this.a.get()).a();
    }
  }
  
  public boolean onError(int paramInt, String paramString, Object paramObject)
  {
    QLog.i("AETemplateInfoFragment", 1, "[player lifecycle]---PlayerListener onError errCode=" + paramInt + ", msg=" + paramString);
    if ((this.a != null) && (this.a.get() != null)) {
      AETemplateInfoFragment.b((AETemplateInfoFragment)this.a.get());
    }
    return true;
  }
  
  public void onPrepared(IVideoShelfPlayer paramIVideoShelfPlayer) {}
  
  public void onUpdateRate(long paramLong)
  {
    if ((this.a != null) && (this.a.get() != null)) {
      ((AETemplateInfoFragment)this.a.get()).a(paramLong);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blcp
 * JD-Core Version:    0.7.0.1
 */