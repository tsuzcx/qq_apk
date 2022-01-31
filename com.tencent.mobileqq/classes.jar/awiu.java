import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.portal.PortalManager;
import com.tencent.mobileqq.portal.PortalManager.5.1;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;
import mqq.os.MqqHandler;

public class awiu
  extends alox
{
  public awiu(PortalManager paramPortalManager) {}
  
  protected void onUpdateCustomHead(boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PortalManagerhead", 2, "onUpdateCustomHead isSuccess = " + paramBoolean + ", mobileNumber = " + paramString);
    }
    if (this.a.a.containsKey(paramString)) {
      ThreadManager.getSubThreadHandler().post(new PortalManager.5.1(this, paramString, paramBoolean));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     awiu
 * JD-Core Version:    0.7.0.1
 */