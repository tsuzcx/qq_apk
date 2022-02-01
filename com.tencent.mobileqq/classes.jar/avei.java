import android.os.Bundle;
import com.tencent.mobileqq.gamecenter.protocol.ReportTypeRsp;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

class avei
  implements BusinessObserver
{
  avei(aveh paramaveh) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    paramBundle = (ReportTypeRsp)paramBundle.getSerializable("rsp");
    if (QLog.isColorLevel()) {
      QLog.d("GameShare.NetHelper", 2, "ReportTypeRsp reportObserver:" + paramBoolean + "|" + paramBundle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avei
 * JD-Core Version:    0.7.0.1
 */