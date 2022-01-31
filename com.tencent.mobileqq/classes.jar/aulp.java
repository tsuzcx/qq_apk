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

public class aulp
{
  public static final Map<Class<?>, String> a;
  private static Class[] a;
  private static final Map<Class<? extends auko>, List<Field>> b;
  private static final Map<Class<? extends auko>, List<Field>> c;
  private static final Map<String, String> d;
  private static final Map<Class<? extends auko>, auko> e;
  
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
  
  public static auko a(Class<? extends auko> paramClass)
  {
    auko localauko2 = (auko)e.get(paramClass);
    auko localauko1 = localauko2;
    if (localauko2 == null)
    {
      localauko1 = (auko)paramClass.newInstance();
      e.put(paramClass, localauko1);
    }
    return localauko1;
  }
  
  public static String a(auko paramauko)
  {
    String str1 = paramauko.getTableName();
    if (d.containsKey(str1)) {
      return (String)d.get(str1);
    }
    Object localObject1 = aulb.a().a(paramauko.getClass());
    if (localObject1 != null)
    {
      localObject2 = ((aula)localObject1).a(str1);
      if (localObject2 != null)
      {
        d.put(str1, localObject2);
        ((aula)localObject1).a = true;
        return localObject2;
      }
    }
    localObject1 = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    ((StringBuilder)localObject1).append(str1);
    ((StringBuilder)localObject1).append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT");
    paramauko = paramauko.getClassForTable();
    Object localObject2 = a(paramauko);
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
        if (!localField.isAnnotationPresent(aumc.class)) {
          break label244;
        }
        ((StringBuilder)localObject1).append(" UNIQUE");
      }
      for (;;)
      {
        i += 1;
        break;
        label244:
        if (localField.isAnnotationPresent(aulw.class)) {
          ((StringBuilder)localObject1).append(" default 0");
        } else if (localField.isAnnotationPresent(aulv.class)) {
          ((StringBuilder)localObject1).append(" default " + ((aulv)localField.getAnnotation(aulv.class)).a());
        }
      }
    }
    if (paramauko.isAnnotationPresent(uniqueConstraints.class))
    {
      paramauko = (uniqueConstraints)paramauko.getAnnotation(uniqueConstraints.class);
      localObject2 = paramauko.columnNames();
      ((StringBuilder)localObject1).append(",UNIQUE(" + (String)localObject2 + ")");
      paramauko = paramauko.clause().toString();
      ((StringBuilder)localObject1).append(" ON CONFLICT " + paramauko);
    }
    ((StringBuilder)localObject1).append(')');
    paramauko = ((StringBuilder)localObject1).toString();
    d.put(str1, paramauko);
    return paramauko;
  }
  
  public static String a(Class<? extends auko> paramClass)
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
  
  public static List<Field> a(auko paramauko)
  {
    Class localClass = paramauko.getClassForTable();
    Object localObject1 = (List)b.get(localClass);
    paramauko = (auko)localObject1;
    if (localObject1 == null)
    {
      localObject1 = localClass.getFields();
      paramauko = new ArrayList(localObject1.length);
      int j = localObject1.length;
      int i = 0;
      while (i < j)
      {
        Object localObject2 = localObject1[i];
        if ((!Modifier.isStatic(localObject2.getModifiers())) && (!localObject2.isAnnotationPresent(aulz.class))) {
          paramauko.add(localObject2);
        }
        i += 1;
      }
      a(localClass, paramauko);
      b.put(localClass, paramauko);
    }
    return paramauko;
  }
  
  public static List<Field> a(Class<? extends auko> paramClass)
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
          if ((!Modifier.isStatic(localObject3.getModifiers())) && (!localObject3.isAnnotationPresent(aulz.class))) {
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
  
  private static void a(Class<? extends auko> paramClass, List<Field> paramList)
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
            if ((!Modifier.isStatic(arrayOfClass.getModifiers())) && (arrayOfClass.isAnnotationPresent(aulx.class)))
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
  
  public static String b(auko paramauko)
  {
    if ((paramauko instanceof MessageRecord))
    {
      MessageRecord localMessageRecord = (MessageRecord)paramauko;
      paramauko = localMessageRecord.getTableName();
      StringBuilder localStringBuilder = new StringBuilder("CREATE INDEX IF NOT EXISTS ");
      localStringBuilder.append(paramauko).append("_idx");
      localStringBuilder.append(" ON ");
      localStringBuilder.append(paramauko);
      paramauko = "time";
      switch (localMessageRecord.istroop)
      {
      }
      for (;;)
      {
        localStringBuilder.append("(").append(paramauko).append(", _id)");
        return localStringBuilder.toString();
        paramauko = "shmsgseq";
      }
    }
    return null;
  }
  
  public static String b(Class<? extends auko> paramClass)
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
  
  public static List<Field> b(auko paramauko)
  {
    Class localClass = paramauko.getClassForTable();
    Object localObject1 = (List)c.get(localClass);
    paramauko = (auko)localObject1;
    if (localObject1 == null)
    {
      localObject1 = localClass.getFields();
      paramauko = new ArrayList(localObject1.length);
      int j = localObject1.length;
      int i = 0;
      while (i < j)
      {
        Object localObject2 = localObject1[i];
        if (!Modifier.isStatic(localObject2.getModifiers())) {
          paramauko.add(localObject2);
        }
        i += 1;
      }
      c.put(localClass, paramauko);
    }
    return paramauko;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aulp
 * JD-Core Version:    0.7.0.1
 */