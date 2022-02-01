import android.os.IBinder;
import com.tencent.mobileqq.javahook.BGLocateMonitor;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class avye
  implements InvocationHandler
{
  Object a;
  
  avye(IBinder paramIBinder, Class<?> paramClass)
  {
    try
    {
      this.a = paramClass.getDeclaredMethod("asInterface", new Class[] { IBinder.class }).invoke(null, new Object[] { paramIBinder });
      return;
    }
    catch (Exception paramIBinder)
    {
      QLog.d("BGLocateMonitor", 1, "FixBinder init", paramIBinder);
    }
  }
  
  public Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
  {
    if (BGLocateMonitor.access$100(paramMethod.getName(), BGLocateMonitor.access$000())) {
      BGLocateMonitor.access$200(paramMethod.getName());
    }
    return paramMethod.invoke(this.a, paramArrayOfObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avye
 * JD-Core Version:    0.7.0.1
 */