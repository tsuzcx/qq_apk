import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import java.util.concurrent.ConcurrentHashMap;

class aveq
  implements EIPCResultCallback
{
  aveq(avep paramavep) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    if (paramEIPCResult.data == null) {}
    do
    {
      do
      {
        do
        {
          return;
          switch (paramEIPCResult.data.getInt("notify_type"))
          {
          default: 
            return;
          }
        } while (paramEIPCResult.code != 0);
        i = paramEIPCResult.data.getInt("id");
        paramEIPCResult = paramEIPCResult.data.getString("url");
        if (QLog.isColorLevel()) {
          QLog.d("Signature.TOOL", 2, "mSignatureManagerIPCCallback get action id = " + i + " url = " + paramEIPCResult);
        }
      } while (TextUtils.isEmpty(paramEIPCResult));
      avep.b(this.a).put(Integer.valueOf(i), paramEIPCResult);
      avep.b(this.a);
      this.a.notifyObservers(Integer.valueOf(4));
      return;
    } while (paramEIPCResult.code != 0);
    int i = paramEIPCResult.data.getInt("id");
    this.a.a(i, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aveq
 * JD-Core Version:    0.7.0.1
 */