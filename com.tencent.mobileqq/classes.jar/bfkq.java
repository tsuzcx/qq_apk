import android.os.Message;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqpim.QQPimBridgeActivity;

public class bfkq
  implements bfky
{
  public bfkq(QQPimBridgeActivity paramQQPimBridgeActivity) {}
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.i(bfkr.a, 2, "QQPimBridgeActivity.hasInstalled()");
    }
    QQPimBridgeActivity.a(this.a).sendEmptyMessage(1);
  }
  
  public void a(float paramFloat) {}
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i(bfkr.a, 2, "QQPimBridgeActivity.downloadError()");
    }
    Message localMessage = Message.obtain();
    localMessage.what = 2;
    localMessage.arg1 = paramInt;
    QQPimBridgeActivity.a(this.a).sendMessage(localMessage);
  }
  
  public void b()
  {
    QQPimBridgeActivity.a(this.a).sendEmptyMessage(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bfkq
 * JD-Core Version:    0.7.0.1
 */