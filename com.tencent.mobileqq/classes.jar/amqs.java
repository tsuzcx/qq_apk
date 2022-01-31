import com.tencent.mobileqq.msf.sdk.handler.INetEventHandler;
import com.tencent.weiyun.transmission.WeiyunTransmissionStatus;

public final class amqs
  implements INetEventHandler
{
  public void onNetChangeEvent(boolean paramBoolean)
  {
    WeiyunTransmissionStatus.getInstance().onReceiveNetChanged(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amqs
 * JD-Core Version:    0.7.0.1
 */