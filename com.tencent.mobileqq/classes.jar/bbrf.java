import android.os.MessageQueue.IdleHandler;
import com.tencent.mobileqq.richmediabrowser.model.AIOPictureData;

class bbrf
  implements MessageQueue.IdleHandler
{
  bbrf(bbrb parambbrb) {}
  
  public boolean queueIdle()
  {
    AIOPictureData localAIOPictureData = this.a.a();
    bbpn localbbpn = new bbpn();
    if ((localAIOPictureData != null) && (localbbpn.a(localAIOPictureData, 4)) && (localbbpn.a(localAIOPictureData, 4) == null))
    {
      this.a.f(true);
      this.a.updateUI();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbrf
 * JD-Core Version:    0.7.0.1
 */