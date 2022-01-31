import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.qphone.base.util.QLog;

public class asnc
  extends abtg
{
  public asnc(QQAppInterface paramQQAppInterface, ProxyManager paramProxyManager, abtf paramabtf)
  {
    super(paramQQAppInterface, paramProxyManager, paramabtf);
    if (QLog.isColorLevel()) {
      QLog.d("TinyIdMsgProxy", 2, "TinyIdMsgProxy() called with: _app = [" + paramQQAppInterface + "], pm = [" + paramProxyManager + "], msgPool = [" + paramabtf + "]");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asnc
 * JD-Core Version:    0.7.0.1
 */