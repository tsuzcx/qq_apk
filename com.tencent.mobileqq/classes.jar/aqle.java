import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.sdk.handler.INetEventHandler;
import com.tencent.qphone.base.util.QLog;

class aqle
  implements INetEventHandler
{
  aqle(aqkz paramaqkz) {}
  
  public void onNetChangeEvent(boolean paramBoolean)
  {
    if (aqkz.a(this.a) == null) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("GroupVideoManager", 2, "onNetChangeEvent connect:" + paramBoolean + " isMSFConnect:" + aqkz.a(this.a).e);
      }
    } while (!paramBoolean);
    this.a.a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     aqle
 * JD-Core Version:    0.7.0.1
 */