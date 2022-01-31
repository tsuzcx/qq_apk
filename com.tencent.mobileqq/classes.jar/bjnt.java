import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public class bjnt
{
  private static Map<Class, Integer> a = new HashMap();
  private static Map<Class, List<Constructor<? extends bjnm>>> b = new HashMap();
  
  private static int a(Class<?> paramClass)
  {
    if (a.containsKey(paramClass)) {
      return ((Integer)a.get(paramClass)).intValue();
    }
    int i = b(paramClass);
    a.put(paramClass, Integer.valueOf(i));
    return i;
  }
  
  private static bjnm a(Constructor<? extends bjnm> paramConstructor, Object paramObject)
  {
    try
    {
      paramConstructor = (bjnm)paramConstructor.newInstance(new Object[] { paramObject });
      return paramConstructor;
    }
    catch (IllegalAccessException paramConstructor)
    {
      throw new RuntimeException(paramConstructor);
    }
    catch (InstantiationException paramConstructor)
    {
      throw new RuntimeException(paramConstructor);
    }
    catch (InvocationTargetException paramConstructor)
    {
      throw new RuntimeException(paramConstructor);
    }
  }
  
  @NonNull
  public static bjnn a(Object paramObject)
  {
    if ((paramObject instanceof bjnk)) {
      return new bjnl((bjnk)paramObject);
    }
    if ((paramObject instanceof bjnn)) {
      return (bjnn)paramObject;
    }
    Object localObject = paramObject.getClass();
    if (a((Class)localObject) == 2)
    {
      localObject = (List)b.get(localObject);
      if (((List)localObject).size() == 1) {
        return new bjnz(a((Constructor)((List)localObject).get(0), paramObject));
      }
      bjnm[] arrayOfbjnm = new bjnm[((List)localObject).size()];
      int i = 0;
      while (i < ((List)localObject).size())
      {
        arrayOfbjnm[i] = a((Constructor)((List)localObject).get(i), paramObject);
        i += 1;
      }
      return new bjnj(arrayOfbjnm);
    }
    return new bjnw(paramObject);
  }
  
  public static String a(String paramString)
  {
    return paramString.replace(".", "_") + "_LifecycleAdapter";
  }
  
  @Nullable
  private static Constructor<? extends bjnm> a(Class<?> paramClass)
  {
    for (;;)
    {
      try
      {
        localObject = paramClass.getPackage();
        String str = paramClass.getCanonicalName();
        if (localObject != null)
        {
          localObject = ((Package)localObject).getName();
          if (((String)localObject).isEmpty())
          {
            str = a(str);
            if (((String)localObject).isEmpty())
            {
              localObject = str;
              paramClass = Class.forName((String)localObject).getDeclaredConstructor(new Class[] { paramClass });
              if (paramClass.isAccessible()) {
                break label124;
              }
              paramClass.setAccessible(true);
              return paramClass;
            }
          }
          else
          {
            str = str.substring(((String)localObject).length() + 1);
            continue;
          }
          localObject = (String)localObject + "." + str;
          continue;
          return paramClass;
        }
      }
      catch (ClassNotFoundException paramClass)
      {
        return null;
      }
      catch (NoSuchMethodException paramClass)
      {
        throw new RuntimeException(paramClass);
      }
      label124:
      Object localObject = "";
    }
  }
  
  private static boolean a(Class<?> paramClass)
  {
    return (paramClass != null) && (bjnr.class.isAssignableFrom(paramClass));
  }
  
  private static int b(Class<?> paramClass)
  {
    if (paramClass.getCanonicalName() == null) {
      return 1;
    }
    Object localObject1 = a(paramClass);
    if (localObject1 != null)
    {
      b.put(paramClass, Collections.singletonList(localObject1));
      return 2;
    }
    if (bjng.a.a(paramClass)) {
      return 1;
    }
    Object localObject2 = paramClass.getSuperclass();
    localObject1 = null;
    if (a((Class)localObject2))
    {
      if (a((Class)localObject2) == 1) {
        return 1;
      }
      localObject1 = new ArrayList((Collection)b.get(localObject2));
    }
    localObject2 = paramClass.getInterfaces();
    int j = localObject2.length;
    int i = 0;
    Class localClass;
    while (i < j)
    {
      localClass = localObject2[i];
      if (!a(localClass))
      {
        i += 1;
      }
      else
      {
        if (a(localClass) == 1) {
          return 1;
        }
        if (localObject1 != null) {
          break label197;
        }
        localObject1 = new ArrayList();
      }
    }
    label197:
    for (;;)
    {
      ((List)localObject1).addAll((Collection)b.get(localClass));
      break;
      if (localObject1 != null)
      {
        b.put(paramClass, localObject1);
        return 2;
      }
      return 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjnt
 * JD-Core Version:    0.7.0.1
 */