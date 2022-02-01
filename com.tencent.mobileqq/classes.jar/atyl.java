import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.qphone.base.util.QLog;

public class atyl
  extends abwx
{
  public atyl(QQAppInterface paramQQAppInterface, ProxyManager paramProxyManager, abww paramabww)
  {
    super(paramQQAppInterface, paramProxyManager, paramabww);
    if (QLog.isColorLevel()) {
      QLog.d("TinyIdMsgProxy", 2, "TinyIdMsgProxy() called with: _app = [" + paramQQAppInterface + "], pm = [" + paramProxyManager + "], msgPool = [" + paramabww + "]");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atyl
 * JD-Core Version:    0.7.0.1
 */