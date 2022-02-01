import android.os.Bundle;
import com.tencent.mobileqq.config.business.QQComicConfBean.IPExpressionConfig;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

final class bkfa
  implements EIPCResultCallback
{
  bkfa(bkfc parambkfc) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    if ((paramEIPCResult == null) || (paramEIPCResult.data == null)) {}
    do
    {
      return;
      bkey.a = (QQComicConfBean.IPExpressionConfig)paramEIPCResult.data.getSerializable("ipExpressionConfig");
      if (this.a != null) {
        this.a.a(bkey.a);
      }
    } while (!QLog.isColorLevel());
    QLog.d("VipComicConfigHelper", 2, " ipExpressionConfig" + bkey.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkfa
 * JD-Core Version:    0.7.0.1
 */