import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.qphone.base.util.QLog;

public class autl
  extends acwf
{
  public autl(QQAppInterface paramQQAppInterface, ProxyManager paramProxyManager, acwe paramacwe)
  {
    super(paramQQAppInterface, paramProxyManager, paramacwe);
    if (QLog.isColorLevel()) {
      QLog.d("TinyIdMsgProxy", 2, "TinyIdMsgProxy() called with: _app = [" + paramQQAppInterface + "], pm = [" + paramProxyManager + "], msgPool = [" + paramacwe + "]");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     autl
 * JD-Core Version:    0.7.0.1
 */