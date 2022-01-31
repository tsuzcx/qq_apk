import com.tencent.qqmini.sdk.log.QMLog;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

class bhhd
  implements InvocationHandler
{
  private bhhc a;
  
  public bhhd(bhhc parambhhc)
  {
    this.a = parambhhc;
  }
  
  public Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
  {
    QMLog.e("TXLivePushListenerRefle", "OnBGMNotifyInvocationHandler invoke:" + paramMethod.getName());
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
    if ("onBGMStart".equals(paramMethod.getName())) {
      if (this.a != null) {
        this.a.a();
      }
    }
    for (;;)
    {
      if (("onBGMComplete".equals(paramMethod.getName())) && (paramArrayOfObject != null) && (paramArrayOfObject.length == 1) && ((paramArrayOfObject[0] instanceof Integer)) && (this.a != null)) {
        this.a.a(((Integer)paramArrayOfObject[0]).intValue());
      }
      return null;
      if (("onBGMProgress".equals(paramMethod.getName())) && (paramArrayOfObject != null) && (paramArrayOfObject.length == 2) && ((paramArrayOfObject[0] instanceof Long)) && ((paramArrayOfObject[1] instanceof Long)) && (this.a != null)) {
        this.a.a(((Long)paramArrayOfObject[0]).longValue(), ((Long)paramArrayOfObject[1]).longValue());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhhd
 * JD-Core Version:    0.7.0.1
 */