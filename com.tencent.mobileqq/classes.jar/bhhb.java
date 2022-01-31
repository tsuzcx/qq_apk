import android.graphics.Bitmap;
import com.tencent.qqmini.sdk.log.QMLog;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

class bhhb
  implements InvocationHandler
{
  private bhha a;
  
  public bhhb(bhha parambhha)
  {
    this.a = parambhha;
  }
  
  public Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
  {
    QMLog.e("TXLivePushListenerRefle", "ITXSnapshotListenerInvocationHandler invoke:" + paramMethod.getName());
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
    if (("onSnapshot".equals(paramMethod.getName())) && (paramArrayOfObject != null) && (paramArrayOfObject.length == 1) && ((paramArrayOfObject[0] instanceof Bitmap)) && (this.a != null)) {
      this.a.a((Bitmap)paramArrayOfObject[0]);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhhb
 * JD-Core Version:    0.7.0.1
 */