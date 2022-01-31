import android.util.SparseArray;
import com.tencent.qqmini.sdk.launcher.dynamic.ReflectException;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class beqq
{
  private static SparseArray<Class> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private static SparseArray<Method> b = new SparseArray();
  private static SparseArray<Constructor> c = new SparseArray();
  private static SparseArray<Field> d = new SparseArray();
  private final Object jdField_a_of_type_JavaLangObject;
  private final boolean jdField_a_of_type_Boolean;
  
  private beqq(Class<?> paramClass)
  {
    this.jdField_a_of_type_JavaLangObject = paramClass;
    this.jdField_a_of_type_Boolean = true;
  }
  
  private beqq(Object paramObject)
  {
    this.jdField_a_of_type_JavaLangObject = paramObject;
    this.jdField_a_of_type_Boolean = false;
  }
  
  public static beqq a(Class<?> paramClass)
  {
    return new beqq(paramClass);
  }
  
  public static beqq a(Object paramObject)
  {
    return new beqq(paramObject);
  }
  
  public static beqq a(String paramString)
  {
    return a(a(paramString));
  }
  
  public static beqq a(String paramString, ClassLoader paramClassLoader)
  {
    return a(a(paramString, paramClassLoader));
  }
  
  private static beqq a(Constructor<?> paramConstructor, Object... paramVarArgs)
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
  
  private static Class<?> a(String paramString)
  {
    try
    {
      int i = paramString.hashCode();
      if (jdField_a_of_type_AndroidUtilSparseArray.get(i) != null) {
        return (Class)jdField_a_of_type_AndroidUtilSparseArray.get(i);
      }
      paramString = Class.forName(paramString);
      if (paramString != null)
      {
        jdField_a_of_type_AndroidUtilSparseArray.put(i, paramString);
        return paramString;
      }
    }
    catch (Exception paramString)
    {
      throw new ReflectException(paramString);
    }
    return paramString;
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
  
  private Field a(String paramString)
  {
    Class localClass = a();
    try
    {
      i = localClass.hashCode();
      i = paramString.hashCode() + i;
      if (d.get(i) != null) {
        return (Field)d.get(i);
      }
      localField2 = localClass.getField(paramString);
      localField1 = localField2;
      if (localField2 != null)
      {
        d.put(i, localField2);
        return localField2;
      }
    }
    catch (NoSuchFieldException localNoSuchFieldException2)
    {
      for (;;)
      {
        try
        {
          int i = localClass.hashCode();
          i = paramString.hashCode() + i;
          if (d.get(i) != null) {
            return (Field)d.get(i);
          }
          Field localField2 = (Field)a(localClass.getDeclaredField(paramString));
          Field localField1 = localField2;
          if (localField2 == null) {
            break;
          }
          d.put(i, localField2);
          return localField2;
        }
        catch (NoSuchFieldException localNoSuchFieldException1)
        {
          localClass = localClass.getSuperclass();
          if (localClass == null) {
            throw new ReflectException(localNoSuchFieldException2);
          }
        }
      }
      return localNoSuchFieldException1;
    }
  }
  
  private boolean a(Class<?>[] paramArrayOfClass1, Class<?>[] paramArrayOfClass2)
  {
    if (paramArrayOfClass1.length == paramArrayOfClass2.length)
    {
      int i = 0;
      if (i < paramArrayOfClass2.length)
      {
        if (paramArrayOfClass2[i] == beqr.class) {}
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
      for (localObject = beqr.class;; localObject = localObject.getClass())
      {
        arrayOfClass[i] = localObject;
        i += 1;
        break;
      }
    }
    return arrayOfClass;
  }
  
  public beqq a()
  {
    return a(new Object[0]);
  }
  
  /* Error */
  public beqq a(Object... paramVarArgs)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 203	beqq:a	([Ljava/lang/Object;)[Ljava/lang/Class;
    //   4: astore 5
    //   6: aload_0
    //   7: invokevirtual 166	beqq:a	()Ljava/lang/Class;
    //   10: astore 4
    //   12: aload 5
    //   14: invokevirtual 167	java/lang/Object:hashCode	()I
    //   17: aload_1
    //   18: invokestatic 208	java/util/Arrays:hashCode	([Ljava/lang/Object;)I
    //   21: iadd
    //   22: istore_2
    //   23: getstatic 28	beqq:c	Landroid/util/SparseArray;
    //   26: iload_2
    //   27: invokevirtual 122	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   30: ifnull +22 -> 52
    //   33: getstatic 28	beqq:c	Landroid/util/SparseArray;
    //   36: iload_2
    //   37: invokevirtual 122	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   40: checkcast 62	java/lang/reflect/Constructor
    //   43: astore 4
    //   45: aload 4
    //   47: aload_1
    //   48: invokestatic 210	beqq:a	(Ljava/lang/reflect/Constructor;[Ljava/lang/Object;)Lbeqq;
    //   51: areturn
    //   52: aload 4
    //   54: aload 5
    //   56: invokevirtual 214	java/lang/Class:getDeclaredConstructor	([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;
    //   59: invokestatic 177	beqq:a	(Ljava/lang/reflect/AccessibleObject;)Ljava/lang/reflect/AccessibleObject;
    //   62: checkcast 62	java/lang/reflect/Constructor
    //   65: astore 4
    //   67: getstatic 28	beqq:c	Landroid/util/SparseArray;
    //   70: iload_2
    //   71: aload 4
    //   73: invokevirtual 129	android/util/SparseArray:put	(ILjava/lang/Object;)V
    //   76: goto -31 -> 45
    //   79: astore 4
    //   81: aload_0
    //   82: invokevirtual 166	beqq:a	()Ljava/lang/Class;
    //   85: invokevirtual 218	java/lang/Class:getDeclaredConstructors	()[Ljava/lang/reflect/Constructor;
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
    //   110: invokevirtual 222	java/lang/reflect/Constructor:getParameterTypes	()[Ljava/lang/Class;
    //   113: aload 5
    //   115: invokespecial 224	beqq:a	([Ljava/lang/Class;[Ljava/lang/Class;)Z
    //   118: ifeq +16 -> 134
    //   121: aload 7
    //   123: invokestatic 177	beqq:a	(Ljava/lang/reflect/AccessibleObject;)Ljava/lang/reflect/AccessibleObject;
    //   126: checkcast 62	java/lang/reflect/Constructor
    //   129: aload_1
    //   130: invokestatic 210	beqq:a	(Ljava/lang/reflect/Constructor;[Ljava/lang/Object;)Lbeqq;
    //   133: areturn
    //   134: iload_2
    //   135: iconst_1
    //   136: iadd
    //   137: istore_2
    //   138: goto -42 -> 96
    //   141: new 70	com/tencent/qqmini/sdk/launcher/dynamic/ReflectException
    //   144: dup
    //   145: aload 4
    //   147: invokespecial 73	com/tencent/qqmini/sdk/launcher/dynamic/ReflectException:<init>	(Ljava/lang/Throwable;)V
    //   150: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	151	0	this	beqq
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
  
  public <T> T a(String paramString)
  {
    return b(paramString).a();
  }
  
  public beqq b(String paramString)
  {
    try
    {
      paramString = a(a(paramString).get(this.jdField_a_of_type_JavaLangObject));
      return paramString;
    }
    catch (Exception paramString)
    {
      throw new ReflectException(paramString);
    }
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof beqq)) {
      return this.jdField_a_of_type_JavaLangObject.equals(((beqq)paramObject).a());
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
 * Qualified Name:     beqq
 * JD-Core Version:    0.7.0.1
 */