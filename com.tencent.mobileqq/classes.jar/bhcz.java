import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class bhcz
  implements InvocationHandler
{
  private Class a;
  public Object a;
  
  public bhcz(Class paramClass)
  {
    this.jdField_a_of_type_JavaLangClass = paramClass;
    try
    {
      this.jdField_a_of_type_JavaLangObject = paramClass.newInstance();
      return;
    }
    catch (IllegalAccessException paramClass)
    {
      paramClass.printStackTrace();
      return;
    }
    catch (InstantiationException paramClass)
    {
      paramClass.printStackTrace();
    }
  }
  
  Object a(String paramString, Bundle paramBundle)
  {
    paramString = bhcy.a(this.jdField_a_of_type_JavaLangClass.getName() + '$' + paramString, paramBundle);
    if ((paramString != null) && (paramString.data != null))
    {
      paramBundle = paramString.data.getString("resultType");
      return bhcy.a(paramString.data, paramBundle, "result");
    }
    return null;
  }
  
  void a(String paramString, Bundle paramBundle, EIPCResultCallback paramEIPCResultCallback)
  {
    bhcy.a(this.jdField_a_of_type_JavaLangClass.getName() + '$' + paramString, paramBundle, paramEIPCResultCallback);
  }
  
  void a(Method paramMethod, Object[] paramArrayOfObject, Bundle paramBundle)
  {
    paramMethod = paramMethod.getParameterTypes();
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramMethod.length)
    {
      String str1 = "__arg+" + i + "__";
      String str2 = paramMethod[i].getName();
      localArrayList.add(str2);
      bhcy.a(paramBundle, str2, str1, paramArrayOfObject[i]);
      i += 1;
    }
    paramBundle.putStringArrayList("__parameterTypes__", localArrayList);
  }
  
  public Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
  {
    paramObject = new Bundle();
    a(paramMethod, paramArrayOfObject, paramObject);
    if (QLog.isColorLevel()) {
      QLog.d("RemoteProxy", 2, "getReturnType:" + paramMethod.getReturnType());
    }
    if ((paramMethod.getReturnType().getName().equals("void")) && ((paramArrayOfObject[(paramArrayOfObject.length - 1)] instanceof EIPCResultCallback)))
    {
      a(paramMethod.getName(), paramObject, (EIPCResultCallback)paramArrayOfObject[(paramArrayOfObject.length - 1)]);
      return null;
    }
    return a(paramMethod.getName(), paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhcz
 * JD-Core Version:    0.7.0.1
 */