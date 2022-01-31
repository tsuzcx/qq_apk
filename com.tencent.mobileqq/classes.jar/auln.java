import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.uniqueConstraints;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class auln
{
  public static final Map<Class<?>, String> a;
  private static Class[] a;
  private static final Map<Class<? extends aukm>, List<Field>> b;
  private static final Map<Class<? extends aukm>, List<Field>> c;
  private static final Map<String, String> d;
  private static final Map<Class<? extends aukm>, aukm> e;
  
  static
  {
    jdField_a_of_type_JavaUtilMap = new HashMap();
    b = new ConcurrentHashMap();
    c = new ConcurrentHashMap();
    d = new ConcurrentHashMap();
    e = new ConcurrentHashMap();
    jdField_a_of_type_JavaUtilMap.put(Byte.TYPE, "INTEGER");
    jdField_a_of_type_JavaUtilMap.put(Boolean.TYPE, "INTEGER");
    jdField_a_of_type_JavaUtilMap.put(Short.TYPE, "INTEGER");
    jdField_a_of_type_JavaUtilMap.put(Integer.TYPE, "INTEGER");
    jdField_a_of_type_JavaUtilMap.put(Long.TYPE, "INTEGER");
    jdField_a_of_type_JavaUtilMap.put(String.class, "TEXT");
    jdField_a_of_type_JavaUtilMap.put([B.class, "BLOB");
    jdField_a_of_type_JavaUtilMap.put(Float.TYPE, "REAL");
    jdField_a_of_type_JavaUtilMap.put(Double.TYPE, "REAL");
    jdField_a_of_type_ArrayOfJavaLangClass = new Class[] { RecentUser.class };
  }
  
  public static aukm a(Class<? extends aukm> paramClass)
  {
    aukm localaukm2 = (aukm)e.get(paramClass);
    aukm localaukm1 = localaukm2;
    if (localaukm2 == null)
    {
      localaukm1 = (aukm)paramClass.newInstance();
      e.put(paramClass, localaukm1);
    }
    return localaukm1;
  }
  
  public static String a(aukm paramaukm)
  {
    String str1 = paramaukm.getTableName();
    if (d.containsKey(str1)) {
      return (String)d.get(str1);
    }
    Object localObject1 = aukz.a().a(paramaukm.getClass());
    if (localObject1 != null)
    {
      localObject2 = ((auky)localObject1).a(str1);
      if (localObject2 != null)
      {
        d.put(str1, localObject2);
        ((auky)localObject1).a = true;
        return localObject2;
      }
    }
    localObject1 = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    ((StringBuilder)localObject1).append(str1);
    ((StringBuilder)localObject1).append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT");
    paramaukm = paramaukm.getClassForTable();
    Object localObject2 = a(paramaukm);
    int j = ((List)localObject2).size();
    int i = 0;
    if (i < j)
    {
      Field localField = (Field)((List)localObject2).get(i);
      String str2 = localField.getName();
      Object localObject3 = localField.getType();
      localObject3 = (String)jdField_a_of_type_JavaUtilMap.get(localObject3);
      if (localObject3 != null)
      {
        ((StringBuilder)localObject1).append(',');
        ((StringBuilder)localObject1).append(str2 + " " + (String)localObject3);
        if (!localField.isAnnotationPresent(auma.class)) {
          break label244;
        }
        ((StringBuilder)localObject1).append(" UNIQUE");
      }
      for (;;)
      {
        i += 1;
        break;
        label244:
        if (localField.isAnnotationPresent(aulu.class)) {
          ((StringBuilder)localObject1).append(" default 0");
        } else if (localField.isAnnotationPresent(ault.class)) {
          ((StringBuilder)localObject1).append(" default " + ((ault)localField.getAnnotation(ault.class)).a());
        }
      }
    }
    if (paramaukm.isAnnotationPresent(uniqueConstraints.class))
    {
      paramaukm = (uniqueConstraints)paramaukm.getAnnotation(uniqueConstraints.class);
      localObject2 = paramaukm.columnNames();
      ((StringBuilder)localObject1).append(",UNIQUE(" + (String)localObject2 + ")");
      paramaukm = paramaukm.clause().toString();
      ((StringBuilder)localObject1).append(" ON CONFLICT " + paramaukm);
    }
    ((StringBuilder)localObject1).append(')');
    paramaukm = ((StringBuilder)localObject1).toString();
    d.put(str1, paramaukm);
    return paramaukm;
  }
  
  public static String a(Class<? extends aukm> paramClass)
  {
    return a(paramClass).getTableName();
  }
  
  public static String a(String paramString)
  {
    return "DROP TABLE IF EXISTS " + paramString;
  }
  
  public static String a(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    return a(paramString1, paramString2, paramString3, paramBoolean, 0);
  }
  
  public static String a(String paramString1, String paramString2, String paramString3, boolean paramBoolean, int paramInt)
  {
    if (paramBoolean) {
      return "alter table " + paramString1 + " add " + paramString2 + " " + paramString3 + " default " + paramInt;
    }
    return "alter table " + paramString1 + " add " + paramString2 + " " + paramString3;
  }
  
  public static List<Field> a(aukm paramaukm)
  {
    Class localClass = paramaukm.getClassForTable();
    Object localObject1 = (List)b.get(localClass);
    paramaukm = (aukm)localObject1;
    if (localObject1 == null)
    {
      localObject1 = localClass.getFields();
      paramaukm = new ArrayList(localObject1.length);
      int j = localObject1.length;
      int i = 0;
      while (i < j)
      {
        Object localObject2 = localObject1[i];
        if ((!Modifier.isStatic(localObject2.getModifiers())) && (!localObject2.isAnnotationPresent(aulx.class))) {
          paramaukm.add(localObject2);
        }
        i += 1;
      }
      a(localClass, paramaukm);
      b.put(localClass, paramaukm);
    }
    return paramaukm;
  }
  
  public static List<Field> a(Class<? extends aukm> paramClass)
  {
    Object localObject1;
    try
    {
      paramClass = a(paramClass).getClassForTable();
      Object localObject2 = (List)b.get(paramClass);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject2 = paramClass.getFields();
        localObject1 = new ArrayList(localObject2.length);
        int j = localObject2.length;
        int i = 0;
        while (i < j)
        {
          Object localObject3 = localObject2[i];
          if ((!Modifier.isStatic(localObject3.getModifiers())) && (!localObject3.isAnnotationPresent(aulx.class))) {
            ((List)localObject1).add(localObject3);
          }
          i += 1;
        }
      }
    }
    catch (InstantiationException paramClass)
    {
      for (;;)
      {
        paramClass.printStackTrace();
        paramClass = null;
      }
    }
    catch (IllegalAccessException paramClass)
    {
      for (;;)
      {
        paramClass.printStackTrace();
        paramClass = null;
      }
      a(paramClass, (List)localObject1);
      b.put(paramClass, localObject1);
    }
    return localObject1;
  }
  
  private static void a(Class<? extends aukm> paramClass, List<Field> paramList)
  {
    int j = 0;
    Class[] arrayOfClass = jdField_a_of_type_ArrayOfJavaLangClass;
    int k = arrayOfClass.length;
    int i = 0;
    if (i < k) {
      if (arrayOfClass[i] != paramClass) {}
    }
    for (i = 1;; i = 0)
    {
      if (i != 0)
      {
        paramClass = paramClass.getDeclaredFields();
        k = paramClass.length;
        i = j;
        for (;;)
        {
          if (i < k)
          {
            arrayOfClass = paramClass[i];
            if ((!Modifier.isStatic(arrayOfClass.getModifiers())) && (arrayOfClass.isAnnotationPresent(aulv.class)))
            {
              QLog.i("DB", 1, "add forceColumn field " + arrayOfClass);
              paramList.add(arrayOfClass);
            }
            i += 1;
            continue;
            i += 1;
            break;
          }
        }
      }
      return;
    }
  }
  
  public static String b(aukm paramaukm)
  {
    if ((paramaukm instanceof MessageRecord))
    {
      MessageRecord localMessageRecord = (MessageRecord)paramaukm;
      paramaukm = localMessageRecord.getTableName();
      StringBuilder localStringBuilder = new StringBuilder("CREATE INDEX IF NOT EXISTS ");
      localStringBuilder.append(paramaukm).append("_idx");
      localStringBuilder.append(" ON ");
      localStringBuilder.append(paramaukm);
      paramaukm = "time";
      switch (localMessageRecord.istroop)
      {
      }
      for (;;)
      {
        localStringBuilder.append("(").append(paramaukm).append(", _id)");
        return localStringBuilder.toString();
        paramaukm = "shmsgseq";
      }
    }
    return null;
  }
  
  public static String b(Class<? extends aukm> paramClass)
  {
    try
    {
      paramClass = a(paramClass);
      return paramClass;
    }
    catch (InstantiationException paramClass)
    {
      paramClass.printStackTrace();
      return null;
    }
    catch (IllegalAccessException paramClass)
    {
      for (;;)
      {
        paramClass.printStackTrace();
      }
    }
  }
  
  public static List<Field> b(aukm paramaukm)
  {
    Class localClass = paramaukm.getClassForTable();
    Object localObject1 = (List)c.get(localClass);
    paramaukm = (aukm)localObject1;
    if (localObject1 == null)
    {
      localObject1 = localClass.getFields();
      paramaukm = new ArrayList(localObject1.length);
      int j = localObject1.length;
      int i = 0;
      while (i < j)
      {
        Object localObject2 = localObject1[i];
        if (!Modifier.isStatic(localObject2.getModifiers())) {
          paramaukm.add(localObject2);
        }
        i += 1;
      }
      c.put(localClass, paramaukm);
    }
    return paramaukm;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     auln
 * JD-Core Version:    0.7.0.1
 */