import com.tencent.qphone.base.util.QLog;
import cooperation.qqpim.QQPimGetTipsInfoIPC;
import cooperation.qqpim.QQPimPluginProxyService;

public class bgsk
  implements bgsq
{
  public bgsk(QQPimGetTipsInfoIPC paramQQPimGetTipsInfoIPC) {}
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.i(bgsj.a, 2, "QQPimGetTipsInfoIPC.hasInstalled() ");
    }
    QQPimPluginProxyService.a(QQPimGetTipsInfoIPC.a(this.a));
  }
  
  public void a(float paramFloat)
  {
    if (QLog.isColorLevel()) {
      QLog.i(bgsj.a, 2, "QQPimGetTipsInfoIPC.downloading() " + paramFloat);
    }
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i(bgsj.a, 2, "QQPimGetTipsInfoIPC.downloadError() " + paramInt);
    }
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.i(bgsj.a, 2, "QQPimGetTipsInfoIPC.downloadBegin()");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bgsk
 * JD-Core Version:    0.7.0.1
 */