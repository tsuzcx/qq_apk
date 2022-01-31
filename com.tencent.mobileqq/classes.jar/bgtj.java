import com.tencent.mobileqq.msf.sdk.handler.INetEventHandler;
import com.tencent.weiyun.transmission.WeiyunTransmissionStatus;

final class bgtj
  implements INetEventHandler
{
  public void onNetChangeEvent(boolean paramBoolean)
  {
    WeiyunTransmissionStatus.getInstance().onReceiveNetChanged(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgtj
 * JD-Core Version:    0.7.0.1
 */