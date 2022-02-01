import android.os.MessageQueue.IdleHandler;
import com.tencent.mobileqq.richmediabrowser.model.AIOPictureData;

class bbrp
  implements MessageQueue.IdleHandler
{
  bbrp(bbrl parambbrl) {}
  
  public boolean queueIdle()
  {
    AIOPictureData localAIOPictureData = this.a.a();
    bbpx localbbpx = new bbpx();
    if ((localAIOPictureData != null) && (localbbpx.a(localAIOPictureData, 4)) && (localbbpx.a(localAIOPictureData, 4) == null))
    {
      this.a.f(true);
      this.a.updateUI();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbrp
 * JD-Core Version:    0.7.0.1
 */