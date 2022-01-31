import com.tencent.mobileqq.msf.sdk.handler.INetEventHandler;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.util.NetworkState;

public final class aniq
  implements INetEventHandler
{
  public void onNetChangeEvent(boolean paramBoolean)
  {
    QLog.i("NetworkState", 1, "--onNetChangeEvent isNetEffective:" + paramBoolean);
    NetworkState.access$000(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aniq
 * JD-Core Version:    0.7.0.1
 */