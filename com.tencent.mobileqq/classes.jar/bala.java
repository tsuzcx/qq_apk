import android.os.MessageQueue.IdleHandler;
import com.tencent.mobileqq.richmediabrowser.model.AIOPictureData;

class bala
  implements MessageQueue.IdleHandler
{
  bala(bakw parambakw) {}
  
  public boolean queueIdle()
  {
    AIOPictureData localAIOPictureData = this.a.a();
    baji localbaji = new baji();
    if ((localAIOPictureData != null) && (localbaji.a(localAIOPictureData, 4)) && (localbaji.a(localAIOPictureData, 4) == null))
    {
      this.a.f(true);
      this.a.updateUI();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bala
 * JD-Core Version:    0.7.0.1
 */