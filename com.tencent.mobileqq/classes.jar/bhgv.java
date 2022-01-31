import com.tencent.qqmini.sdk.log.QMLog;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class bhgv
  implements InvocationHandler
{
  public bhgv(bhgr parambhgr) {}
  
  public Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
  {
    QMLog.e("TXLivePlayerJSAdapter", "InnerAudioVolumeEvaluationListenerImpl invoke:" + paramMethod.getName());
    if (Object.class.equals(paramMethod.getDeclaringClass())) {
      try
      {
        paramObject = paramMethod.invoke(this, paramArrayOfObject);
        return paramObject;
      }
      catch (Throwable paramObject)
      {
        paramObject.printStackTrace();
        return null;
      }
    }
    if (("onAudioVolumeEvaluationNotify".equals(paramMethod.getName())) && (paramArrayOfObject.length == 1) && ((paramArrayOfObject[0] instanceof Integer)))
    {
      int i = ((Integer)paramArrayOfObject[0]).intValue();
      if (bhgr.a(this.a) != null) {
        bhgr.a(this.a).a(i);
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhgv
 * JD-Core Version:    0.7.0.1
 */