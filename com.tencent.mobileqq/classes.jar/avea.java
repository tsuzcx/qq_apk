import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.qphone.base.util.QLog;

public class avea
  extends acnf
{
  public avea(QQAppInterface paramQQAppInterface, ProxyManager paramProxyManager, acne paramacne)
  {
    super(paramQQAppInterface, paramProxyManager, paramacne);
    if (QLog.isColorLevel()) {
      QLog.d("TinyIdMsgProxy", 2, "TinyIdMsgProxy() called with: _app = [" + paramQQAppInterface + "], pm = [" + paramProxyManager + "], msgPool = [" + paramacne + "]");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avea
 * JD-Core Version:    0.7.0.1
 */