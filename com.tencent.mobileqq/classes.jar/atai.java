import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.sdk.handler.INetEventHandler;
import com.tencent.qphone.base.util.QLog;

class atai
  implements INetEventHandler
{
  atai(atad paramatad) {}
  
  public void onNetChangeEvent(boolean paramBoolean)
  {
    if (atad.a(this.a) == null) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("GroupVideoManager", 2, "onNetChangeEvent connect:" + paramBoolean + " isMSFConnect:" + atad.a(this.a).e);
      }
    } while (!paramBoolean);
    this.a.a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atai
 * JD-Core Version:    0.7.0.1
 */