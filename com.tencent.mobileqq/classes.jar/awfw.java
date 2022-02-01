import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

@Deprecated
public class awfw
{
  public void call(String paramString, List<String> paramList, awfv paramawfv)
  {
    Object localObject2 = null;
    Method[] arrayOfMethod = getClass().getDeclaredMethods();
    int j = arrayOfMethod.length;
    int i = 0;
    for (;;)
    {
      Object localObject1 = localObject2;
      if (i < j)
      {
        localObject1 = arrayOfMethod[i];
        if ((!((Method)localObject1).getName().equals(paramString)) || (((Method)localObject1).getParameterTypes().length != paramList.size())) {}
      }
      else
      {
        if (localObject1 != null) {}
        try
        {
          if (paramList.size() == 0) {}
          for (localObject2 = ((Method)localObject1).invoke(this, new Object[0]);; localObject2 = ((Method)localObject1).invoke(this, paramList.toArray()))
          {
            localObject1 = ((Method)localObject1).getReturnType();
            if ((localObject1 != Void.TYPE) && (localObject1 != Void.class)) {
              break;
            }
            if (paramawfv == null) {
              break label276;
            }
            paramawfv.a(null);
            return;
          }
          if (paramawfv != null) {
            if (customCallback())
            {
              paramawfv.a(localObject2.toString());
              return;
            }
          }
        }
        catch (IllegalAccessException localIllegalAccessException)
        {
          if (paramawfv != null) {
            paramawfv.a();
          }
          if (QLog.isDevelopLevel()) {
            QLog.d("JB", 4, "cannot found match method,maybe your method using args type is NO String? request method:class:" + getClass().getSimpleName() + paramString + " args:" + paramList);
          }
          if (paramawfv != null)
          {
            paramawfv.a();
            return;
            paramawfv.a(localObject2);
            return;
          }
        }
        catch (IllegalArgumentException localIllegalArgumentException)
        {
          for (;;)
          {
            if (paramawfv != null) {
              paramawfv.a();
            }
          }
        }
        catch (InvocationTargetException localInvocationTargetException)
        {
          for (;;)
          {
            if (paramawfv != null) {
              paramawfv.a();
            }
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            if (paramawfv != null) {
              paramawfv.a();
            }
          }
        }
        label276:
        return;
      }
      i += 1;
    }
  }
  
  public boolean customCallback()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awfw
 * JD-Core Version:    0.7.0.1
 */