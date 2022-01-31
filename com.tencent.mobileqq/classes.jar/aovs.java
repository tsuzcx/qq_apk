import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetEventHandler;
import com.tencent.qphone.base.util.QLog;

class aovs
  implements INetEventHandler
{
  aovs(aovq paramaovq) {}
  
  public void onNetChangeEvent(boolean paramBoolean)
  {
    if (AppNetConnInfo.isWifiConn())
    {
      if (QLog.isColorLevel()) {
        QLog.d("MPcFileModel<FileAssistant>[MPFile]", 2, "网络切换到Wifi网络");
      }
      bbmy.a(this.a.a, 2131628684, 0).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aovs
 * JD-Core Version:    0.7.0.1
 */