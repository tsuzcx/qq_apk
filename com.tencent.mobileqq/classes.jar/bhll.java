import android.os.Bundle;
import com.tencent.qqmini.sdk.log.QMLog;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

class bhll
  implements InvocationHandler
{
  private bhlg a;
  
  public bhll(bhlg parambhlg)
  {
    this.a = parambhlg;
  }
  
  public Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
  {
    QMLog.e("TXLivePushListenerRefle", "TXLivePushListenerInvocationHandler invoke:" + paramMethod.getName());
    if (Object.class.equals(paramMethod.getDeclaringClass())) {
      try
      {
        paramObject = paramMethod.invoke(this, paramArrayOfObject);
        return paramObject;
      }
      catch (Throwable paramObject)
      {
        QMLog.e("TXLivePushListenerRefle", "invoke", paramObject);
      }
    }
    if ("onNetStatus".equals(paramMethod.getName())) {
      if ((paramArrayOfObject != null) && (paramArrayOfObject.length == 1) && ((paramArrayOfObject[0] instanceof Bundle)))
      {
        paramObject = (Bundle)paramArrayOfObject[0];
        if (QMLog.isColorLevel()) {
          QMLog.e("TXLivePushListenerRefle", "onNetStatus params:" + paramObject.toString());
        }
        if (this.a != null) {
          this.a.a(paramObject);
        }
      }
    }
    for (;;)
    {
      return null;
      if (("onPushEvent".equals(paramMethod.getName())) && (paramArrayOfObject != null) && (paramArrayOfObject.length == 2))
      {
        if (((paramArrayOfObject[0] instanceof Integer)) && ((paramArrayOfObject[1] instanceof Bundle)))
        {
          if (QMLog.isColorLevel()) {
            QMLog.e("TXLivePushListenerRefle", "onPushEvent code:" + paramArrayOfObject[0]);
          }
          if (this.a != null) {
            this.a.a(((Integer)paramArrayOfObject[0]).intValue(), (Bundle)paramArrayOfObject[1]);
          }
        }
        if ((paramArrayOfObject[1] instanceof Bundle))
        {
          paramObject = (Bundle)paramArrayOfObject[1];
          if (QMLog.isColorLevel()) {
            QMLog.e("TXLivePushListenerRefle", "onPushEvent params:" + paramObject.toString());
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhll
 * JD-Core Version:    0.7.0.1
 */