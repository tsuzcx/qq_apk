import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

@Deprecated
public class avnl
{
  public void call(String paramString, List<String> paramList, avnk paramavnk)
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
            if (paramavnk == null) {
              break label276;
            }
            paramavnk.a(null);
            return;
          }
          if (paramavnk != null) {
            if (customCallback())
            {
              paramavnk.a(localObject2.toString());
              return;
            }
          }
        }
        catch (IllegalAccessException localIllegalAccessException)
        {
          if (paramavnk != null) {
            paramavnk.a();
          }
          if (QLog.isDevelopLevel()) {
            QLog.d("JB", 4, "cannot found match method,maybe your method using args type is NO String? request method:class:" + getClass().getSimpleName() + paramString + " args:" + paramList);
          }
          if (paramavnk != null)
          {
            paramavnk.a();
            return;
            paramavnk.a(localObject2);
            return;
          }
        }
        catch (IllegalArgumentException localIllegalArgumentException)
        {
          for (;;)
          {
            if (paramavnk != null) {
              paramavnk.a();
            }
          }
        }
        catch (InvocationTargetException localInvocationTargetException)
        {
          for (;;)
          {
            if (paramavnk != null) {
              paramavnk.a();
            }
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            if (paramavnk != null) {
              paramavnk.a();
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
 * Qualified Name:     avnl
 * JD-Core Version:    0.7.0.1
 */