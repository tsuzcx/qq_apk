import com.tencent.mobileqq.msf.sdk.handler.INetEventHandler;
import com.tencent.weiyun.transmission.WeiyunTransmissionStatus;

final class bnzc
  implements INetEventHandler
{
  public void onNetChangeEvent(boolean paramBoolean)
  {
    WeiyunTransmissionStatus.getInstance().onReceiveNetChanged(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnzc
 * JD-Core Version:    0.7.0.1
 */