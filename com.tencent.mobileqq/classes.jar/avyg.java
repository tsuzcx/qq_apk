import android.os.IBinder;
import android.os.IInterface;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class avyg
  implements InvocationHandler
{
  IBinder jdField_a_of_type_AndroidOsIBinder;
  Class<?> jdField_a_of_type_JavaLangClass;
  Class<?> b;
  
  public avyg(IBinder paramIBinder)
  {
    this.jdField_a_of_type_AndroidOsIBinder = paramIBinder;
    try
    {
      this.jdField_a_of_type_JavaLangClass = Class.forName("android.location.ILocationManager$Stub");
      this.b = Class.forName("android.location.ILocationManager");
      return;
    }
    catch (Exception paramIBinder)
    {
      QLog.d("BGLocateMonitor", 1, "LocationBinderProxy init", paramIBinder);
    }
  }
  
  public Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
  {
    if ("queryLocalInterface".equals(paramMethod.getName()))
    {
      paramObject = paramObject.getClass().getClassLoader();
      paramMethod = this.b;
      paramArrayOfObject = new avye(this.jdField_a_of_type_AndroidOsIBinder, this.jdField_a_of_type_JavaLangClass);
      return Proxy.newProxyInstance(paramObject, new Class[] { IBinder.class, IInterface.class, paramMethod }, paramArrayOfObject);
    }
    return paramMethod.invoke(this.jdField_a_of_type_AndroidOsIBinder, paramArrayOfObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avyg
 * JD-Core Version:    0.7.0.1
 */