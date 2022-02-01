import android.text.TextUtils;
import com.tencent.mobileqq.fts.entity.FTSEntity;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class avid
{
  public static final Map<Class<?>, String> a;
  public static ConcurrentHashMap<Class, LinkedHashMap<String, Field>> a;
  public static ConcurrentHashMap<Class, LinkedHashSet<Field>> b;
  public static ConcurrentHashMap<Class, LinkedHashSet<Field>> c;
  public static ConcurrentHashMap<Class, FTSEntity> d;
  
  static
  {
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    b = new ConcurrentHashMap();
    c = new ConcurrentHashMap();
    d = new ConcurrentHashMap();
    jdField_a_of_type_JavaUtilMap = new HashMap();
    jdField_a_of_type_JavaUtilMap.put(Byte.TYPE, "INTEGER");
    jdField_a_of_type_JavaUtilMap.put(Boolean.TYPE, "INTEGER");
    jdField_a_of_type_JavaUtilMap.put(Short.TYPE, "INTEGER");
    jdField_a_of_type_JavaUtilMap.put(Integer.TYPE, "INTEGER");
    jdField_a_of_type_JavaUtilMap.put(Long.TYPE, "INTEGER");
    jdField_a_of_type_JavaUtilMap.put(String.class, "TEXT");
    jdField_a_of_type_JavaUtilMap.put([B.class, "BLOB");
    jdField_a_of_type_JavaUtilMap.put(Float.TYPE, "REAL");
    jdField_a_of_type_JavaUtilMap.put(Double.TYPE, "REAL");
  }
  
  public static FTSEntity a(Class<? extends FTSEntity> paramClass)
  {
    FTSEntity localFTSEntity2 = (FTSEntity)d.get(paramClass);
    FTSEntity localFTSEntity1 = localFTSEntity2;
    if (localFTSEntity2 == null) {}
    try
    {
      localFTSEntity1 = (FTSEntity)paramClass.newInstance();
      d.put(paramClass, localFTSEntity1);
      return localFTSEntity1;
    }
    catch (Exception localException)
    {
      throw new RuntimeException(paramClass.getSimpleName() + " must have an empty constructor. ", localException);
    }
  }
  
  public static FTSEntity a(Map paramMap, Class<? extends FTSEntity> paramClass)
  {
    FTSEntity localFTSEntity;
    label286:
    for (;;)
    {
      Field localField;
      Object localObject1;
      Object localObject2;
      try
      {
        localFTSEntity = (FTSEntity)paramClass.newInstance();
        Iterator localIterator = a(paramClass).values().iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        localField = (Field)localIterator.next();
        localObject1 = paramMap.get(localField.getName());
        if (localObject1 == null) {
          continue;
        }
        if (!((String)jdField_a_of_type_JavaUtilMap.get(localField.getType())).equals("INTEGER")) {
          break label286;
        }
        localObject2 = (Long)localObject1;
        if (localField.getType().equals(Byte.TYPE))
        {
          paramClass = Byte.valueOf(((Long)localObject2).byteValue());
          try
          {
            localField.set(localFTSEntity, paramClass);
          }
          catch (IllegalAccessException paramClass)
          {
            paramClass.printStackTrace();
          }
          continue;
        }
        if (!localField.getType().equals(Boolean.TYPE)) {
          break label206;
        }
      }
      catch (Exception paramMap)
      {
        throw new RuntimeException(paramClass.getSimpleName() + " must have an empty constructor. ", paramMap);
      }
      if (((Long)localObject2).longValue() == 1L) {}
      for (boolean bool = true;; bool = false)
      {
        paramClass = Boolean.valueOf(bool);
        break;
      }
      label206:
      if (localField.getType().equals(Short.TYPE))
      {
        paramClass = Short.valueOf(((Long)localObject2).shortValue());
      }
      else if (localField.getType().equals(Integer.TYPE))
      {
        paramClass = Integer.valueOf(((Long)localObject2).intValue());
      }
      else
      {
        paramClass = localObject1;
        if (localField.getType().equals(Long.TYPE))
        {
          paramClass = Long.valueOf(((Long)localObject2).longValue());
          continue;
          paramClass = localObject1;
          if (((String)jdField_a_of_type_JavaUtilMap.get(localField.getType())).equals("REAL"))
          {
            localObject2 = (Double)localObject1;
            if (localField.getType().equals(Float.TYPE))
            {
              paramClass = Float.valueOf(((Double)localObject2).floatValue());
            }
            else
            {
              paramClass = localObject1;
              if (localField.getType().equals(Double.TYPE)) {
                paramClass = Double.valueOf(((Double)localObject2).doubleValue());
              }
            }
          }
        }
      }
    }
    localFTSEntity.postRead();
    return localFTSEntity;
  }
  
  private static String a(avhm paramavhm)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (!TextUtils.isEmpty(paramavhm.jdField_b_of_type_JavaLangString))
    {
      localStringBuilder.append(" ORDER BY ");
      localStringBuilder.append(paramavhm.jdField_b_of_type_JavaLangString);
    }
    if (paramavhm.jdField_a_of_type_Int > 0)
    {
      localStringBuilder.append(" LIMIT ");
      localStringBuilder.append(paramavhm.jdField_a_of_type_Int);
    }
    return localStringBuilder.toString();
  }
  
  private static String a(avhm paramavhm, avho paramavho)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    paramavho = a(paramavhm.jdField_a_of_type_JavaLangClass, paramavho);
    if ((!TextUtils.isEmpty(paramavho)) || (!TextUtils.isEmpty(paramavhm.jdField_a_of_type_JavaLangString)))
    {
      localStringBuilder.append(" WHERE ");
      if (!TextUtils.isEmpty(paramavho)) {
        localStringBuilder.append(paramavho);
      }
      if ((!TextUtils.isEmpty(paramavho)) && (!TextUtils.isEmpty(paramavhm.jdField_a_of_type_JavaLangString))) {
        localStringBuilder.append(" AND ");
      }
      if (!TextUtils.isEmpty(paramavhm.jdField_a_of_type_JavaLangString)) {
        localStringBuilder.append(paramavhm.jdField_a_of_type_JavaLangString);
      }
    }
    return localStringBuilder.toString();
  }
  
  private static String a(avhm paramavhm, avho paramavho, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(d(paramavhm, paramBoolean));
    localStringBuilder.append(a(paramavhm, paramavho));
    if (!paramBoolean) {
      localStringBuilder.append(a(paramavhm));
    }
    return localStringBuilder.toString();
  }
  
  public static String a(avhm paramavhm, List<Integer> paramList)
  {
    String str = a(paramavhm, false);
    if ((paramList == null) || (paramList.size() > 0)) {
      throw new IllegalArgumentException("columnTyps must be empty and not null.");
    }
    paramavhm = a(paramavhm.jdField_a_of_type_JavaLangClass).values().iterator();
    while (paramavhm.hasNext())
    {
      Object localObject = (Field)paramavhm.next();
      localObject = (String)jdField_a_of_type_JavaUtilMap.get(((Field)localObject).getType());
      if (((String)localObject).equals("INTEGER")) {
        paramList.add(Integer.valueOf(1));
      } else if (((String)localObject).equals("REAL")) {
        paramList.add(Integer.valueOf(2));
      } else if (((String)localObject).equals("TEXT")) {
        paramList.add(Integer.valueOf(3));
      } else if (((String)localObject).equals("BLOB")) {
        paramList.add(Integer.valueOf(4));
      }
    }
    return str;
  }
  
  private static String a(avhm paramavhm, boolean paramBoolean)
  {
    if (paramavhm.jdField_a_of_type_ArrayOfAvho != null)
    {
      if (paramavhm.jdField_a_of_type_ArrayOfAvho.length == 1) {
        return a(paramavhm, paramavhm.jdField_a_of_type_ArrayOfAvho[0], paramBoolean);
      }
      if (paramavhm.jdField_a_of_type_ArrayOfAvho.length > 1)
      {
        if (paramavhm.jdField_a_of_type_Boolean) {
          return b(paramavhm, paramBoolean);
        }
        return c(paramavhm, paramBoolean);
      }
    }
    return a(paramavhm, null, paramBoolean);
  }
  
  public static String a(FTSEntity paramFTSEntity, List<Integer> paramList, List<byte[]> paramList1)
  {
    paramFTSEntity.preWrite();
    paramList1.clear();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("INSERT INTO ");
    localStringBuilder.append(paramFTSEntity.getTableName());
    localStringBuilder.append("(");
    Object localObject1 = a(paramFTSEntity.getClass());
    Set localSet = a(paramFTSEntity.getClass());
    Object localObject2 = ((Map)localObject1).values().iterator();
    Field localField;
    for (int i = 1; ((Iterator)localObject2).hasNext(); i = 0)
    {
      localField = (Field)((Iterator)localObject2).next();
      if (i == 0) {
        localStringBuilder.append(',');
      }
      localStringBuilder.append(localField.getName());
      if (localSet.contains(localField))
      {
        localStringBuilder.append(',');
        localStringBuilder.append(paramFTSEntity.getIndexColumnName(localField.getName()));
      }
    }
    localStringBuilder.append(") VALUES(");
    localObject2 = ((Map)localObject1).entrySet().iterator();
    i = 0;
    if (((Iterator)localObject2).hasNext())
    {
      localField = (Field)((Map.Entry)((Iterator)localObject2).next()).getValue();
      if (!localField.getType().equals([B.class)) {}
    }
    label522:
    label633:
    for (;;)
    {
      try
      {
        paramList.add(Integer.valueOf(i));
        paramList1.add((byte[])localField.get(paramFTSEntity));
        i += 1;
        if (!localSet.contains(localField)) {
          break label633;
        }
        i += 1;
      }
      catch (IllegalAccessException localIllegalAccessException5)
      {
        localIllegalAccessException5.printStackTrace();
        continue;
      }
      localObject1 = ((Map)localObject1).values().iterator();
      int j = 1;
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Field)((Iterator)localObject1).next();
        if (j == 0) {
          localStringBuilder.append(',');
        }
        if (((Field)localObject2).getType().equals(String.class)) {
          localStringBuilder.append("'");
        }
        for (;;)
        {
          try
          {
            localStringBuilder.append(((Field)localObject2).get(paramFTSEntity));
            localStringBuilder.append("'");
            if (localSet.contains(localObject2))
            {
              localStringBuilder.append(',');
              localStringBuilder.append("'");
              localStringBuilder.append((String)paramFTSEntity.indexContentMap.get(((Field)localObject2).getName()));
              localStringBuilder.append("'");
            }
            j = 0;
          }
          catch (IllegalAccessException localIllegalAccessException1)
          {
            localIllegalAccessException1.printStackTrace();
            continue;
          }
          if (((Field)localObject2).getType().equals(Boolean.TYPE)) {
            for (;;)
            {
              try
              {
                if (!((Boolean)((Field)localObject2).get(paramFTSEntity)).booleanValue()) {
                  break label522;
                }
                j = 1;
                localStringBuilder.append(j);
              }
              catch (IllegalAccessException localIllegalAccessException2)
              {
                localIllegalAccessException2.printStackTrace();
              }
              break;
              j = 0;
            }
          }
          if (((Field)localObject2).getType().equals([B.class))
          {
            localStringBuilder.append("?");
            try
            {
              paramList.add(Integer.valueOf(i));
              paramList1.add((byte[])((Field)localObject2).get(paramFTSEntity));
            }
            catch (IllegalAccessException localIllegalAccessException3)
            {
              localIllegalAccessException3.printStackTrace();
            }
          }
          else
          {
            try
            {
              localStringBuilder.append(((Field)localObject2).get(paramFTSEntity));
            }
            catch (IllegalAccessException localIllegalAccessException4)
            {
              localIllegalAccessException4.printStackTrace();
            }
          }
        }
      }
      localStringBuilder.append(")");
      return localStringBuilder.toString();
    }
  }
  
  private static String a(Class<? extends FTSEntity> paramClass, avho paramavho)
  {
    int j = 0;
    if (paramavho == null) {
      return "";
    }
    Object localObject2 = a(paramClass);
    String str = paramavho.jdField_a_of_type_JavaLangString;
    if ((TextUtils.isEmpty(str)) || (paramavho == null) || (TextUtils.isEmpty(paramavho.jdField_b_of_type_JavaLangString))) {
      return "";
    }
    Object localObject1 = a(paramClass);
    paramClass = a(paramClass);
    Field localField = (Field)((Map)localObject1).get(str);
    localObject1 = new StringBuilder(128);
    if (paramClass.contains(localField))
    {
      ((StringBuilder)localObject1).append(((FTSEntity)localObject2).getIndexColumnName(str));
      ((StringBuilder)localObject1).append(" MATCH '");
      if ((!paramClass.contains(localField)) && (!paramavho.jdField_b_of_type_Boolean)) {
        break label170;
      }
      paramClass = avie.b(paramavho.jdField_b_of_type_JavaLangString);
    }
    for (;;)
    {
      int i;
      if (paramClass != null)
      {
        i = j;
        if (paramClass.length != 0) {}
      }
      else
      {
        return "";
        ((StringBuilder)localObject1).append(str);
        break;
        label170:
        localObject2 = avie.a(paramavho.jdField_b_of_type_JavaLangString);
        if (localObject2 == null) {
          break label342;
        }
        paramClass = new String[((ArrayList)localObject2).size()];
        i = 0;
        while (i < ((ArrayList)localObject2).size())
        {
          str = (String)((ArrayList)localObject2).get(i);
          paramClass[i] = ("*" + str + "*");
          i += 1;
        }
      }
      if (i < paramClass.length)
      {
        if (i > 0)
        {
          if (!paramavho.jdField_a_of_type_Boolean) {
            break label312;
          }
          ((StringBuilder)localObject1).append(" OR ");
        }
        for (;;)
        {
          ((StringBuilder)localObject1).append("\"");
          ((StringBuilder)localObject1).append(paramClass[i]);
          ((StringBuilder)localObject1).append("\"");
          i += 1;
          break;
          label312:
          ((StringBuilder)localObject1).append(" ");
        }
      }
      ((StringBuilder)localObject1).append("'");
      return ((StringBuilder)localObject1).toString();
      continue;
      label342:
      paramClass = null;
    }
  }
  
  public static String a(Class<? extends FTSEntity> paramClass, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    FTSEntity localFTSEntity = a(paramClass);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("CREATE VIRTUAL TABLE ");
    if ((paramBoolean1) && (paramBoolean2)) {
      localStringBuilder.append("IF NOT EXISTS ");
    }
    localStringBuilder.append(localFTSEntity.getTableName());
    localStringBuilder.append(" USING ");
    if (paramBoolean1) {
      localStringBuilder.append("fts4");
    }
    Object localObject2;
    Object localObject1;
    for (;;)
    {
      localStringBuilder.append("(");
      localObject2 = a(paramClass);
      localObject1 = a(paramClass);
      localObject2 = ((Map)localObject2).values().iterator();
      for (int i = 1; ((Iterator)localObject2).hasNext(); i = 0)
      {
        Field localField = (Field)((Iterator)localObject2).next();
        String str = (String)jdField_a_of_type_JavaUtilMap.get(localField.getType());
        if (i == 0) {
          localStringBuilder.append(',');
        }
        localStringBuilder.append(localField.getName());
        localStringBuilder.append(" ");
        localStringBuilder.append(str);
        if (((Set)localObject1).contains(localField))
        {
          localStringBuilder.append(',');
          localStringBuilder.append(localFTSEntity.getIndexColumnName(localField.getName()));
          localStringBuilder.append(" ");
          localStringBuilder.append("TEXT");
        }
      }
      localStringBuilder.append("fts3");
    }
    if ((paramBoolean1) && (paramBoolean3))
    {
      localObject2 = new HashSet();
      ((Set)localObject2).addAll((Collection)localObject1);
      ((Set)localObject2).addAll(b(paramClass));
      paramClass = ((Set)localObject2).iterator();
      while (paramClass.hasNext())
      {
        localObject1 = (Field)paramClass.next();
        localStringBuilder.append(", notindexed=");
        localStringBuilder.append(((Field)localObject1).getName());
      }
    }
    if ((paramBoolean1) && (localFTSEntity.needCompress()) && (paramBoolean4)) {
      localStringBuilder.append(", compress=qqcompress, uncompress=qquncompress");
    }
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
  
  public static Map<String, Field> a(Class<? extends FTSEntity> paramClass)
  {
    Object localObject2 = (LinkedHashMap)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramClass);
    Object localObject1 = localObject2;
    Field[] arrayOfField;
    LinkedHashMap localLinkedHashMap;
    if (localObject2 == null)
    {
      arrayOfField = paramClass.getFields();
      localLinkedHashMap = new LinkedHashMap();
      localObject1 = (LinkedHashSet)b.get(paramClass);
      if (localObject1 != null) {
        break label389;
      }
      localObject1 = new LinkedHashSet();
      b.put(paramClass, localObject1);
    }
    label389:
    for (;;)
    {
      localObject2 = (LinkedHashSet)c.get(paramClass);
      if (localObject2 == null)
      {
        localObject2 = new LinkedHashSet();
        c.put(paramClass, localObject2);
      }
      for (;;)
      {
        int j = arrayOfField.length;
        int i = 0;
        if (i < j)
        {
          Field localField = arrayOfField[i];
          if (localField.isAnnotationPresent(avhr.class)) {}
          for (;;)
          {
            i += 1;
            break;
            if (!localField.getDeclaringClass().equals(FTSEntity.class))
            {
              localObject3 = localField.getName();
              if ((((String)localObject3).equals("ext1")) || (((String)localObject3).equals("ext2")) || (((String)localObject3).equals("ext3")) || (((String)localObject3).equals("exts"))) {
                throw new RuntimeException("Field '" + (String)localObject3 + "' cannot be declared in subclass. It is a reserved field in FTSEntity.");
              }
            }
            if (localField.isAnnotationPresent(avhq.class))
            {
              if (!localField.getType().equals(String.class)) {
                throw new RuntimeException(paramClass.getSimpleName() + "The type of Filed declared with @index must be String. Field is " + localField.getName());
              }
              ((LinkedHashSet)localObject1).add(localField);
            }
            if (localField.isAnnotationPresent(avhs.class)) {
              ((LinkedHashSet)localObject2).add(localField);
            }
            localField.getName();
            Object localObject3 = localField.getType();
            if ((String)jdField_a_of_type_JavaUtilMap.get(localObject3) != null) {
              localLinkedHashMap.put(localField.getName(), localField);
            }
          }
        }
        jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramClass, localLinkedHashMap);
        localObject1 = localLinkedHashMap;
        return localObject1;
      }
    }
  }
  
  public static Set<Field> a(Class<? extends FTSEntity> paramClass)
  {
    Set localSet2 = (Set)b.get(paramClass);
    Set localSet1 = localSet2;
    if (localSet2 == null)
    {
      a(paramClass);
      localSet1 = (Set)b.get(paramClass);
    }
    return localSet1;
  }
  
  private static String b(avhm paramavhm, boolean paramBoolean)
  {
    int j = 0;
    if ((paramavhm == null) || (paramavhm.jdField_a_of_type_ArrayOfAvho == null) || (paramavhm.jdField_a_of_type_ArrayOfAvho.length < 2)) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    int i = j;
    if (!paramBoolean)
    {
      localStringBuilder.append(d(paramavhm, false));
      localStringBuilder.append(" WHERE rowid in (");
      i = j;
    }
    while (i < paramavhm.jdField_a_of_type_ArrayOfAvho.length)
    {
      if (i > 0) {
        localStringBuilder.append(" UNION ");
      }
      localStringBuilder.append(a(paramavhm, paramavhm.jdField_a_of_type_ArrayOfAvho[i], true));
      i += 1;
    }
    if (!paramBoolean)
    {
      localStringBuilder.append(")");
      localStringBuilder.append(a(paramavhm));
    }
    return localStringBuilder.toString();
  }
  
  public static Set<Field> b(Class<? extends FTSEntity> paramClass)
  {
    Set localSet2 = (Set)c.get(paramClass);
    Set localSet1 = localSet2;
    if (localSet2 == null)
    {
      a(paramClass);
      localSet1 = (Set)c.get(paramClass);
    }
    return localSet1;
  }
  
  private static String c(avhm paramavhm, boolean paramBoolean)
  {
    if ((paramavhm == null) || (paramavhm.jdField_a_of_type_ArrayOfAvho == null) || (paramavhm.jdField_a_of_type_ArrayOfAvho.length < 2)) {
      return "";
    }
    StringBuilder localStringBuilder1 = new StringBuilder();
    if (!paramBoolean)
    {
      localStringBuilder1.append(d(paramavhm, false));
      localStringBuilder1.append(" WHERE rowid in (");
    }
    String str = a(paramavhm, paramavhm.jdField_a_of_type_ArrayOfAvho[0], true);
    int i = 1;
    while (i < paramavhm.jdField_a_of_type_ArrayOfAvho.length)
    {
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append(a(paramavhm, paramavhm.jdField_a_of_type_ArrayOfAvho[i], true));
      localStringBuilder2.append(" AND rowid in (");
      localStringBuilder2.append(str);
      localStringBuilder2.append(")");
      str = localStringBuilder2.toString();
      i += 1;
    }
    localStringBuilder1.append(str);
    if (!paramBoolean)
    {
      localStringBuilder1.append(")");
      localStringBuilder1.append(a(paramavhm));
    }
    return localStringBuilder1.toString();
  }
  
  private static String d(avhm paramavhm, boolean paramBoolean)
  {
    FTSEntity localFTSEntity = a(paramavhm.jdField_a_of_type_JavaLangClass);
    Object localObject = a(paramavhm.jdField_a_of_type_JavaLangClass);
    paramavhm = new StringBuilder();
    paramavhm.append("SELECT ");
    if (paramBoolean) {
      paramavhm.append("rowid");
    }
    for (;;)
    {
      paramavhm.append(" FROM ");
      paramavhm.append(localFTSEntity.getTableName());
      return paramavhm.toString();
      localObject = ((Map)localObject).keySet().iterator();
      for (int i = 1; ((Iterator)localObject).hasNext(); i = 0)
      {
        String str = (String)((Iterator)localObject).next();
        if (i == 0) {
          paramavhm.append(',');
        }
        paramavhm.append(str);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avid
 * JD-Core Version:    0.7.0.1
 */