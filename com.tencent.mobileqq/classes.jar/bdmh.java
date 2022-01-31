import android.util.SparseArray;
import com.tencent.qqmini.sdk.launcher.dynamic.ReflectException;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class bdmh
{
  private static SparseArray<Class> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private static SparseArray<Method> b = new SparseArray();
  private static SparseArray<Constructor> c = new SparseArray();
  private static SparseArray<Field> d = new SparseArray();
  private final Object jdField_a_of_type_JavaLangObject;
  private final boolean jdField_a_of_type_Boolean;
  
  private bdmh(Class<?> paramClass)
  {
    this.jdField_a_of_type_JavaLangObject = paramClass;
    this.jdField_a_of_type_Boolean = true;
  }
  
  private bdmh(Object paramObject)
  {
    this.jdField_a_of_type_JavaLangObject = paramObject;
    this.jdField_a_of_type_Boolean = false;
  }
  
  public static bdmh a(Class<?> paramClass)
  {
    return new bdmh(paramClass);
  }
  
  public static bdmh a(Object paramObject)
  {
    return new bdmh(paramObject);
  }
  
  public static bdmh a(String paramString, ClassLoader paramClassLoader)
  {
    return a(a(paramString, paramClassLoader));
  }
  
  private static bdmh a(Constructor<?> paramConstructor, Object... paramVarArgs)
  {
    try
    {
      paramConstructor = a(paramConstructor.newInstance(paramVarArgs));
      return paramConstructor;
    }
    catch (Exception paramConstructor)
    {
      throw new ReflectException(paramConstructor);
    }
  }
  
  public static Class<?> a(Class<?> paramClass)
  {
    Class<?> localClass;
    if (paramClass == null) {
      localClass = null;
    }
    do
    {
      do
      {
        return localClass;
        localClass = paramClass;
      } while (!paramClass.isPrimitive());
      if (Boolean.TYPE == paramClass) {
        return Boolean.class;
      }
      if (Integer.TYPE == paramClass) {
        return Integer.class;
      }
      if (Long.TYPE == paramClass) {
        return Long.class;
      }
      if (Short.TYPE == paramClass) {
        return Short.class;
      }
      if (Byte.TYPE == paramClass) {
        return Byte.class;
      }
      if (Double.TYPE == paramClass) {
        return Double.class;
      }
      if (Float.TYPE == paramClass) {
        return Float.class;
      }
      if (Character.TYPE == paramClass) {
        return Character.class;
      }
      localClass = paramClass;
    } while (Void.TYPE != paramClass);
    return Void.class;
  }
  
  private static Class<?> a(String paramString, ClassLoader paramClassLoader)
  {
    try
    {
      paramString = Class.forName(paramString, true, paramClassLoader);
      return paramString;
    }
    catch (Exception paramString)
    {
      throw new ReflectException(paramString);
    }
  }
  
  public static <T extends AccessibleObject> T a(T paramT)
  {
    T ?;
    if (paramT == null) {
      ? = null;
    }
    do
    {
      Member localMember;
      do
      {
        return ?;
        if (!(paramT instanceof Member)) {
          break;
        }
        localMember = (Member)paramT;
        if (!Modifier.isPublic(localMember.getModifiers())) {
          break;
        }
        ? = paramT;
      } while (Modifier.isPublic(localMember.getDeclaringClass().getModifiers()));
      ? = paramT;
    } while (paramT.isAccessible());
    paramT.setAccessible(true);
    return paramT;
  }
  
  private boolean a(Class<?>[] paramArrayOfClass1, Class<?>[] paramArrayOfClass2)
  {
    if (paramArrayOfClass1.length == paramArrayOfClass2.length)
    {
      int i = 0;
      if (i < paramArrayOfClass2.length)
      {
        if (paramArrayOfClass2[i] == bdmi.class) {}
        while (a(paramArrayOfClass1[i]).isAssignableFrom(a(paramArrayOfClass2[i])))
        {
          i += 1;
          break;
        }
      }
    }
    else
    {
      return false;
    }
    return true;
  }
  
  private static Class<?>[] a(Object... paramVarArgs)
  {
    int i = 0;
    if (paramVarArgs == null) {
      return new Class[0];
    }
    Class[] arrayOfClass = new Class[paramVarArgs.length];
    if (i < paramVarArgs.length)
    {
      Object localObject = paramVarArgs[i];
      if (localObject == null) {}
      for (localObject = bdmi.class;; localObject = localObject.getClass())
      {
        arrayOfClass[i] = localObject;
        i += 1;
        break;
      }
    }
    return arrayOfClass;
  }
  
  public bdmh a()
  {
    return a(new Object[0]);
  }
  
  /* Error */
  public bdmh a(Object... paramVarArgs)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 164	bdmh:a	([Ljava/lang/Object;)[Ljava/lang/Class;
    //   4: astore 5
    //   6: aload_0
    //   7: invokevirtual 166	bdmh:a	()Ljava/lang/Class;
    //   10: astore 4
    //   12: aload 5
    //   14: invokevirtual 169	java/lang/Object:hashCode	()I
    //   17: aload_1
    //   18: invokestatic 174	java/util/Arrays:hashCode	([Ljava/lang/Object;)I
    //   21: iadd
    //   22: istore_2
    //   23: getstatic 28	bdmh:c	Landroid/util/SparseArray;
    //   26: iload_2
    //   27: invokevirtual 178	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   30: ifnull +22 -> 52
    //   33: getstatic 28	bdmh:c	Landroid/util/SparseArray;
    //   36: iload_2
    //   37: invokevirtual 178	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   40: checkcast 58	java/lang/reflect/Constructor
    //   43: astore 4
    //   45: aload 4
    //   47: aload_1
    //   48: invokestatic 180	bdmh:a	(Ljava/lang/reflect/Constructor;[Ljava/lang/Object;)Lbdmh;
    //   51: areturn
    //   52: aload 4
    //   54: aload 5
    //   56: invokevirtual 184	java/lang/Class:getDeclaredConstructor	([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;
    //   59: invokestatic 186	bdmh:a	(Ljava/lang/reflect/AccessibleObject;)Ljava/lang/reflect/AccessibleObject;
    //   62: checkcast 58	java/lang/reflect/Constructor
    //   65: astore 4
    //   67: getstatic 28	bdmh:c	Landroid/util/SparseArray;
    //   70: iload_2
    //   71: aload 4
    //   73: invokevirtual 190	android/util/SparseArray:put	(ILjava/lang/Object;)V
    //   76: goto -31 -> 45
    //   79: astore 4
    //   81: aload_0
    //   82: invokevirtual 166	bdmh:a	()Ljava/lang/Class;
    //   85: invokevirtual 194	java/lang/Class:getDeclaredConstructors	()[Ljava/lang/reflect/Constructor;
    //   88: astore 6
    //   90: aload 6
    //   92: arraylength
    //   93: istore_3
    //   94: iconst_0
    //   95: istore_2
    //   96: iload_2
    //   97: iload_3
    //   98: if_icmpge +43 -> 141
    //   101: aload 6
    //   103: iload_2
    //   104: aaload
    //   105: astore 7
    //   107: aload_0
    //   108: aload 7
    //   110: invokevirtual 198	java/lang/reflect/Constructor:getParameterTypes	()[Ljava/lang/Class;
    //   113: aload 5
    //   115: invokespecial 200	bdmh:a	([Ljava/lang/Class;[Ljava/lang/Class;)Z
    //   118: ifeq +16 -> 134
    //   121: aload 7
    //   123: invokestatic 186	bdmh:a	(Ljava/lang/reflect/AccessibleObject;)Ljava/lang/reflect/AccessibleObject;
    //   126: checkcast 58	java/lang/reflect/Constructor
    //   129: aload_1
    //   130: invokestatic 180	bdmh:a	(Ljava/lang/reflect/Constructor;[Ljava/lang/Object;)Lbdmh;
    //   133: areturn
    //   134: iload_2
    //   135: iconst_1
    //   136: iadd
    //   137: istore_2
    //   138: goto -42 -> 96
    //   141: new 66	com/tencent/qqmini/sdk/launcher/dynamic/ReflectException
    //   144: dup
    //   145: aload 4
    //   147: invokespecial 69	com/tencent/qqmini/sdk/launcher/dynamic/ReflectException:<init>	(Ljava/lang/Throwable;)V
    //   150: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	151	0	this	bdmh
    //   0	151	1	paramVarArgs	Object[]
    //   22	116	2	i	int
    //   93	6	3	j	int
    //   10	62	4	localObject	Object
    //   79	67	4	localNoSuchMethodException	java.lang.NoSuchMethodException
    //   4	110	5	arrayOfClass	Class[]
    //   88	14	6	arrayOfConstructor	Constructor[]
    //   105	17	7	localConstructor	Constructor
    // Exception table:
    //   from	to	target	type
    //   6	45	79	java/lang/NoSuchMethodException
    //   45	52	79	java/lang/NoSuchMethodException
    //   52	76	79	java/lang/NoSuchMethodException
  }
  
  public Class<?> a()
  {
    if (this.jdField_a_of_type_Boolean) {
      return (Class)this.jdField_a_of_type_JavaLangObject;
    }
    return this.jdField_a_of_type_JavaLangObject.getClass();
  }
  
  public <T> T a()
  {
    return this.jdField_a_of_type_JavaLangObject;
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof bdmh)) {
      return this.jdField_a_of_type_JavaLangObject.equals(((bdmh)paramObject).a());
    }
    return false;
  }
  
  public int hashCode()
  {
    return this.jdField_a_of_type_JavaLangObject.hashCode();
  }
  
  public String toString()
  {
    return this.jdField_a_of_type_JavaLangObject.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bdmh
 * JD-Core Version:    0.7.0.1
 */