package com.google.protobuf;

import java.lang.reflect.Constructor;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

final class SchemaUtil
{
  private static final Class<?> a = ;
  private static final UnknownFieldSchema<?, ?> b = a(false);
  private static final UnknownFieldSchema<?, ?> c = a(true);
  private static final UnknownFieldSchema<?, ?> d = new UnknownFieldSetLiteSchema();
  
  static int a(int paramInt, Object paramObject, Schema paramSchema)
  {
    if ((paramObject instanceof LazyFieldLite)) {
      return CodedOutputStream.a(paramInt, (LazyFieldLite)paramObject);
    }
    return CodedOutputStream.b(paramInt, (MessageLite)paramObject, paramSchema);
  }
  
  static int a(int paramInt, List<?> paramList)
  {
    int m = paramList.size();
    int i = 0;
    int k = 0;
    if (m == 0) {
      return 0;
    }
    int j = CodedOutputStream.h(paramInt) * m;
    paramInt = j;
    Object localObject;
    if ((paramList instanceof LazyStringList))
    {
      paramList = (LazyStringList)paramList;
      paramInt = j;
      i = k;
      for (;;)
      {
        j = paramInt;
        if (i >= m) {
          break;
        }
        localObject = paramList.d(i);
        if ((localObject instanceof ByteString)) {
          j = CodedOutputStream.b((ByteString)localObject);
        } else {
          j = CodedOutputStream.b((String)localObject);
        }
        paramInt += j;
        i += 1;
      }
    }
    for (;;)
    {
      j = paramInt;
      if (i >= m) {
        break;
      }
      localObject = paramList.get(i);
      if ((localObject instanceof ByteString)) {
        j = CodedOutputStream.b((ByteString)localObject);
      } else {
        j = CodedOutputStream.b((String)localObject);
      }
      paramInt += j;
      i += 1;
    }
    return j;
  }
  
  static int a(int paramInt, List<?> paramList, Schema paramSchema)
  {
    int k = paramList.size();
    int j = 0;
    if (k == 0) {
      return 0;
    }
    int i = CodedOutputStream.h(paramInt) * k;
    paramInt = j;
    while (paramInt < k)
    {
      Object localObject = paramList.get(paramInt);
      if ((localObject instanceof LazyFieldLite)) {
        j = CodedOutputStream.a((LazyFieldLite)localObject);
      } else {
        j = CodedOutputStream.b((MessageLite)localObject, paramSchema);
      }
      i += j;
      paramInt += 1;
    }
    return i;
  }
  
  static int a(int paramInt, List<Long> paramList, boolean paramBoolean)
  {
    if (paramList.size() == 0) {
      return 0;
    }
    int i = a(paramList);
    if (paramBoolean) {
      return CodedOutputStream.h(paramInt) + CodedOutputStream.o(i);
    }
    return i + paramList.size() * CodedOutputStream.h(paramInt);
  }
  
  static int a(List<Long> paramList)
  {
    int m = paramList.size();
    int j = 0;
    int k = 0;
    if (m == 0) {
      return 0;
    }
    if ((paramList instanceof LongArrayList))
    {
      paramList = (LongArrayList)paramList;
      i = 0;
      for (;;)
      {
        j = i;
        if (k >= m) {
          break;
        }
        i += CodedOutputStream.f(paramList.c(k));
        k += 1;
      }
    }
    int i = 0;
    k = j;
    for (;;)
    {
      j = i;
      if (k >= m) {
        break;
      }
      i += CodedOutputStream.f(((Long)paramList.get(k)).longValue());
      k += 1;
    }
    return j;
  }
  
  public static UnknownFieldSchema<?, ?> a()
  {
    return b;
  }
  
  private static UnknownFieldSchema<?, ?> a(boolean paramBoolean)
  {
    try
    {
      Object localObject = e();
      if (localObject == null) {
        return null;
      }
      localObject = (UnknownFieldSchema)((Class)localObject).getConstructor(new Class[] { Boolean.TYPE }).newInstance(new Object[] { Boolean.valueOf(paramBoolean) });
      return localObject;
    }
    catch (Throwable localThrowable) {}
    return null;
  }
  
  static <UT, UB> UB a(int paramInt1, int paramInt2, UB paramUB, UnknownFieldSchema<UT, UB> paramUnknownFieldSchema)
  {
    Object localObject = paramUB;
    if (paramUB == null) {
      localObject = paramUnknownFieldSchema.a();
    }
    paramUnknownFieldSchema.a(localObject, paramInt1, paramInt2);
    return localObject;
  }
  
  static <UT, UB> UB a(int paramInt, List<Integer> paramList, Internal.EnumLiteMap<?> paramEnumLiteMap, UB paramUB, UnknownFieldSchema<UT, UB> paramUnknownFieldSchema)
  {
    if (paramEnumLiteMap == null) {
      return paramUB;
    }
    int i;
    UB ?;
    if ((paramList instanceof RandomAccess))
    {
      int k = paramList.size();
      i = 0;
      int j = 0;
      while (i < k)
      {
        int m = ((Integer)paramList.get(i)).intValue();
        if (paramEnumLiteMap.findValueByNumber(m) != null)
        {
          if (i != j) {
            paramList.set(j, Integer.valueOf(m));
          }
          j += 1;
        }
        else
        {
          paramUB = a(paramInt, m, paramUB, paramUnknownFieldSchema);
        }
        i += 1;
      }
      ? = paramUB;
      if (j != k)
      {
        paramList.subList(j, k).clear();
        return paramUB;
      }
    }
    else
    {
      paramList = paramList.iterator();
      for (;;)
      {
        ? = paramUB;
        if (!paramList.hasNext()) {
          break;
        }
        i = ((Integer)paramList.next()).intValue();
        if (paramEnumLiteMap.findValueByNumber(i) == null)
        {
          paramUB = a(paramInt, i, paramUB, paramUnknownFieldSchema);
          paramList.remove();
        }
      }
    }
    return ?;
  }
  
  static <UT, UB> UB a(int paramInt, List<Integer> paramList, Internal.EnumVerifier paramEnumVerifier, UB paramUB, UnknownFieldSchema<UT, UB> paramUnknownFieldSchema)
  {
    if (paramEnumVerifier == null) {
      return paramUB;
    }
    int i;
    UB ?;
    if ((paramList instanceof RandomAccess))
    {
      int k = paramList.size();
      i = 0;
      int j = 0;
      while (i < k)
      {
        int m = ((Integer)paramList.get(i)).intValue();
        if (paramEnumVerifier.a(m))
        {
          if (i != j) {
            paramList.set(j, Integer.valueOf(m));
          }
          j += 1;
        }
        else
        {
          paramUB = a(paramInt, m, paramUB, paramUnknownFieldSchema);
        }
        i += 1;
      }
      ? = paramUB;
      if (j != k)
      {
        paramList.subList(j, k).clear();
        return paramUB;
      }
    }
    else
    {
      paramList = paramList.iterator();
      for (;;)
      {
        ? = paramUB;
        if (!paramList.hasNext()) {
          break;
        }
        i = ((Integer)paramList.next()).intValue();
        if (!paramEnumVerifier.a(i))
        {
          paramUB = a(paramInt, i, paramUB, paramUnknownFieldSchema);
          paramList.remove();
        }
      }
    }
    return ?;
  }
  
  static Object a(Class<?> paramClass, String paramString)
  {
    try
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramClass.getName());
      ((StringBuilder)localObject).append("$");
      ((StringBuilder)localObject).append(a(paramString, true));
      ((StringBuilder)localObject).append("DefaultEntryHolder");
      localObject = Class.forName(((StringBuilder)localObject).toString()).getDeclaredFields();
      if (localObject.length == 1) {
        return UnsafeUtil.b(localObject[0]);
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Unable to look up map field default entry holder class for ");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(" in ");
      ((StringBuilder)localObject).append(paramClass.getName());
      throw new IllegalStateException(((StringBuilder)localObject).toString());
    }
    catch (Throwable paramClass)
    {
      throw new RuntimeException(paramClass);
    }
  }
  
  static String a(String paramString, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < paramString.length())
    {
      char c1 = paramString.charAt(i);
      if (('a' <= c1) && (c1 <= 'z')) {
        if (paramBoolean) {
          localStringBuilder.append((char)(c1 - ' '));
        } else {
          localStringBuilder.append(c1);
        }
      }
      for (;;)
      {
        paramBoolean = false;
        break label132;
        if (('A' > c1) || (c1 > 'Z')) {
          break;
        }
        if ((i == 0) && (!paramBoolean)) {
          localStringBuilder.append((char)(c1 + ' '));
        } else {
          localStringBuilder.append(c1);
        }
      }
      if (('0' <= c1) && (c1 <= '9')) {
        localStringBuilder.append(c1);
      }
      paramBoolean = true;
      label132:
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public static void a(int paramInt, List<String> paramList, Writer paramWriter)
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      paramWriter.a(paramInt, paramList);
    }
  }
  
  public static void a(int paramInt, List<?> paramList, Writer paramWriter, Schema paramSchema)
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      paramWriter.a(paramInt, paramList, paramSchema);
    }
  }
  
  public static void a(int paramInt, List<Double> paramList, Writer paramWriter, boolean paramBoolean)
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      paramWriter.g(paramInt, paramList, paramBoolean);
    }
  }
  
  static <T, FT extends FieldSet.FieldDescriptorLite<FT>> void a(ExtensionSchema<FT> paramExtensionSchema, T paramT1, T paramT2)
  {
    paramT2 = paramExtensionSchema.a(paramT2);
    if (!paramT2.c()) {
      paramExtensionSchema.b(paramT1).a(paramT2);
    }
  }
  
  static <T> void a(MapFieldSchema paramMapFieldSchema, T paramT1, T paramT2, long paramLong)
  {
    UnsafeUtil.a(paramT1, paramLong, paramMapFieldSchema.a(UnsafeUtil.f(paramT1, paramLong), UnsafeUtil.f(paramT2, paramLong)));
  }
  
  static <T, UT, UB> void a(UnknownFieldSchema<UT, UB> paramUnknownFieldSchema, T paramT1, T paramT2)
  {
    paramUnknownFieldSchema.a(paramT1, paramUnknownFieldSchema.c(paramUnknownFieldSchema.b(paramT1), paramUnknownFieldSchema.b(paramT2)));
  }
  
  public static void a(Class<?> paramClass)
  {
    if (!GeneratedMessageLite.class.isAssignableFrom(paramClass))
    {
      Class localClass = a;
      if (localClass != null)
      {
        if (localClass.isAssignableFrom(paramClass)) {
          return;
        }
        throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
      }
    }
  }
  
  static boolean a(Object paramObject1, Object paramObject2)
  {
    return (paramObject1 == paramObject2) || ((paramObject1 != null) && (paramObject1.equals(paramObject2)));
  }
  
  static int b(int paramInt, List<ByteString> paramList)
  {
    int j = paramList.size();
    int i = 0;
    if (j == 0) {
      return 0;
    }
    j *= CodedOutputStream.h(paramInt);
    paramInt = i;
    i = j;
    while (paramInt < paramList.size())
    {
      i += CodedOutputStream.b((ByteString)paramList.get(paramInt));
      paramInt += 1;
    }
    return i;
  }
  
  static int b(int paramInt, List<MessageLite> paramList, Schema paramSchema)
  {
    int k = paramList.size();
    int i = 0;
    if (k == 0) {
      return 0;
    }
    int j = 0;
    while (i < k)
    {
      j += CodedOutputStream.d(paramInt, (MessageLite)paramList.get(i), paramSchema);
      i += 1;
    }
    return j;
  }
  
  static int b(int paramInt, List<Long> paramList, boolean paramBoolean)
  {
    int i = paramList.size();
    if (i == 0) {
      return 0;
    }
    int j = b(paramList);
    if (paramBoolean) {
      return CodedOutputStream.h(paramInt) + CodedOutputStream.o(j);
    }
    return j + i * CodedOutputStream.h(paramInt);
  }
  
  static int b(List<Long> paramList)
  {
    int m = paramList.size();
    int j = 0;
    int k = 0;
    if (m == 0) {
      return 0;
    }
    if ((paramList instanceof LongArrayList))
    {
      paramList = (LongArrayList)paramList;
      i = 0;
      for (;;)
      {
        j = i;
        if (k >= m) {
          break;
        }
        i += CodedOutputStream.g(paramList.c(k));
        k += 1;
      }
    }
    int i = 0;
    k = j;
    for (;;)
    {
      j = i;
      if (k >= m) {
        break;
      }
      i += CodedOutputStream.g(((Long)paramList.get(k)).longValue());
      k += 1;
    }
    return j;
  }
  
  public static UnknownFieldSchema<?, ?> b()
  {
    return c;
  }
  
  public static void b(int paramInt, List<ByteString> paramList, Writer paramWriter)
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      paramWriter.b(paramInt, paramList);
    }
  }
  
  public static void b(int paramInt, List<?> paramList, Writer paramWriter, Schema paramSchema)
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      paramWriter.b(paramInt, paramList, paramSchema);
    }
  }
  
  public static void b(int paramInt, List<Float> paramList, Writer paramWriter, boolean paramBoolean)
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      paramWriter.f(paramInt, paramList, paramBoolean);
    }
  }
  
  static int c(int paramInt, List<Long> paramList, boolean paramBoolean)
  {
    int i = paramList.size();
    if (i == 0) {
      return 0;
    }
    int j = c(paramList);
    if (paramBoolean) {
      return CodedOutputStream.h(paramInt) + CodedOutputStream.o(j);
    }
    return j + i * CodedOutputStream.h(paramInt);
  }
  
  static int c(List<Long> paramList)
  {
    int m = paramList.size();
    int j = 0;
    int k = 0;
    if (m == 0) {
      return 0;
    }
    if ((paramList instanceof LongArrayList))
    {
      paramList = (LongArrayList)paramList;
      i = 0;
      for (;;)
      {
        j = i;
        if (k >= m) {
          break;
        }
        i += CodedOutputStream.h(paramList.c(k));
        k += 1;
      }
    }
    int i = 0;
    k = j;
    for (;;)
    {
      j = i;
      if (k >= m) {
        break;
      }
      i += CodedOutputStream.h(((Long)paramList.get(k)).longValue());
      k += 1;
    }
    return j;
  }
  
  public static UnknownFieldSchema<?, ?> c()
  {
    return d;
  }
  
  public static void c(int paramInt, List<?> paramList, Writer paramWriter)
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      paramWriter.c(paramInt, paramList);
    }
  }
  
  public static void c(int paramInt, List<Long> paramList, Writer paramWriter, boolean paramBoolean)
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      paramWriter.c(paramInt, paramList, paramBoolean);
    }
  }
  
  static int d(int paramInt, List<Integer> paramList, boolean paramBoolean)
  {
    int i = paramList.size();
    if (i == 0) {
      return 0;
    }
    int j = d(paramList);
    if (paramBoolean) {
      return CodedOutputStream.h(paramInt) + CodedOutputStream.o(j);
    }
    return j + i * CodedOutputStream.h(paramInt);
  }
  
  static int d(List<Integer> paramList)
  {
    int m = paramList.size();
    int j = 0;
    int k = 0;
    if (m == 0) {
      return 0;
    }
    if ((paramList instanceof IntArrayList))
    {
      paramList = (IntArrayList)paramList;
      i = 0;
      for (;;)
      {
        j = i;
        if (k >= m) {
          break;
        }
        i += CodedOutputStream.n(paramList.c(k));
        k += 1;
      }
    }
    int i = 0;
    k = j;
    for (;;)
    {
      j = i;
      if (k >= m) {
        break;
      }
      i += CodedOutputStream.n(((Integer)paramList.get(k)).intValue());
      k += 1;
    }
    return j;
  }
  
  private static Class<?> d()
  {
    try
    {
      Class localClass = Class.forName("com.google.protobuf.GeneratedMessageV3");
      return localClass;
    }
    catch (Throwable localThrowable)
    {
      label9:
      break label9;
    }
    return null;
  }
  
  public static void d(int paramInt, List<?> paramList, Writer paramWriter)
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      paramWriter.d(paramInt, paramList);
    }
  }
  
  public static void d(int paramInt, List<Long> paramList, Writer paramWriter, boolean paramBoolean)
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      paramWriter.d(paramInt, paramList, paramBoolean);
    }
  }
  
  static int e(int paramInt, List<Integer> paramList, boolean paramBoolean)
  {
    int i = paramList.size();
    if (i == 0) {
      return 0;
    }
    int j = e(paramList);
    if (paramBoolean) {
      return CodedOutputStream.h(paramInt) + CodedOutputStream.o(j);
    }
    return j + i * CodedOutputStream.h(paramInt);
  }
  
  static int e(List<Integer> paramList)
  {
    int m = paramList.size();
    int j = 0;
    int k = 0;
    if (m == 0) {
      return 0;
    }
    if ((paramList instanceof IntArrayList))
    {
      paramList = (IntArrayList)paramList;
      i = 0;
      for (;;)
      {
        j = i;
        if (k >= m) {
          break;
        }
        i += CodedOutputStream.i(paramList.c(k));
        k += 1;
      }
    }
    int i = 0;
    k = j;
    for (;;)
    {
      j = i;
      if (k >= m) {
        break;
      }
      i += CodedOutputStream.i(((Integer)paramList.get(k)).intValue());
      k += 1;
    }
    return j;
  }
  
  private static Class<?> e()
  {
    try
    {
      Class localClass = Class.forName("com.google.protobuf.UnknownFieldSetSchema");
      return localClass;
    }
    catch (Throwable localThrowable)
    {
      label9:
      break label9;
    }
    return null;
  }
  
  public static void e(int paramInt, List<Long> paramList, Writer paramWriter, boolean paramBoolean)
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      paramWriter.n(paramInt, paramList, paramBoolean);
    }
  }
  
  static int f(int paramInt, List<Integer> paramList, boolean paramBoolean)
  {
    int i = paramList.size();
    if (i == 0) {
      return 0;
    }
    int j = f(paramList);
    if (paramBoolean) {
      return CodedOutputStream.h(paramInt) + CodedOutputStream.o(j);
    }
    return j + i * CodedOutputStream.h(paramInt);
  }
  
  static int f(List<Integer> paramList)
  {
    int m = paramList.size();
    int j = 0;
    int k = 0;
    if (m == 0) {
      return 0;
    }
    if ((paramList instanceof IntArrayList))
    {
      paramList = (IntArrayList)paramList;
      i = 0;
      for (;;)
      {
        j = i;
        if (k >= m) {
          break;
        }
        i += CodedOutputStream.j(paramList.c(k));
        k += 1;
      }
    }
    int i = 0;
    k = j;
    for (;;)
    {
      j = i;
      if (k >= m) {
        break;
      }
      i += CodedOutputStream.j(((Integer)paramList.get(k)).intValue());
      k += 1;
    }
    return j;
  }
  
  public static void f(int paramInt, List<Long> paramList, Writer paramWriter, boolean paramBoolean)
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      paramWriter.e(paramInt, paramList, paramBoolean);
    }
  }
  
  static int g(int paramInt, List<Integer> paramList, boolean paramBoolean)
  {
    int i = paramList.size();
    if (i == 0) {
      return 0;
    }
    int j = g(paramList);
    if (paramBoolean) {
      return CodedOutputStream.h(paramInt) + CodedOutputStream.o(j);
    }
    return j + i * CodedOutputStream.h(paramInt);
  }
  
  static int g(List<Integer> paramList)
  {
    int m = paramList.size();
    int j = 0;
    int k = 0;
    if (m == 0) {
      return 0;
    }
    if ((paramList instanceof IntArrayList))
    {
      paramList = (IntArrayList)paramList;
      i = 0;
      for (;;)
      {
        j = i;
        if (k >= m) {
          break;
        }
        i += CodedOutputStream.k(paramList.c(k));
        k += 1;
      }
    }
    int i = 0;
    k = j;
    for (;;)
    {
      j = i;
      if (k >= m) {
        break;
      }
      i += CodedOutputStream.k(((Integer)paramList.get(k)).intValue());
      k += 1;
    }
    return j;
  }
  
  public static void g(int paramInt, List<Long> paramList, Writer paramWriter, boolean paramBoolean)
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      paramWriter.l(paramInt, paramList, paramBoolean);
    }
  }
  
  static int h(int paramInt, List<?> paramList, boolean paramBoolean)
  {
    int i = paramList.size();
    if (i == 0) {
      return 0;
    }
    if (paramBoolean) {
      return CodedOutputStream.h(paramInt) + CodedOutputStream.o(i * 4);
    }
    return i * CodedOutputStream.k(paramInt, 0);
  }
  
  static int h(List<?> paramList)
  {
    return paramList.size() * 4;
  }
  
  public static void h(int paramInt, List<Integer> paramList, Writer paramWriter, boolean paramBoolean)
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      paramWriter.a(paramInt, paramList, paramBoolean);
    }
  }
  
  static int i(int paramInt, List<?> paramList, boolean paramBoolean)
  {
    int i = paramList.size();
    if (i == 0) {
      return 0;
    }
    if (paramBoolean) {
      return CodedOutputStream.h(paramInt) + CodedOutputStream.o(i * 8);
    }
    return i * CodedOutputStream.i(paramInt, 0L);
  }
  
  static int i(List<?> paramList)
  {
    return paramList.size() * 8;
  }
  
  public static void i(int paramInt, List<Integer> paramList, Writer paramWriter, boolean paramBoolean)
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      paramWriter.j(paramInt, paramList, paramBoolean);
    }
  }
  
  static int j(int paramInt, List<?> paramList, boolean paramBoolean)
  {
    int i = paramList.size();
    if (i == 0) {
      return 0;
    }
    if (paramBoolean) {
      return CodedOutputStream.h(paramInt) + CodedOutputStream.o(i);
    }
    return i * CodedOutputStream.b(paramInt, true);
  }
  
  static int j(List<?> paramList)
  {
    return paramList.size();
  }
  
  public static void j(int paramInt, List<Integer> paramList, Writer paramWriter, boolean paramBoolean)
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      paramWriter.m(paramInt, paramList, paramBoolean);
    }
  }
  
  public static void k(int paramInt, List<Integer> paramList, Writer paramWriter, boolean paramBoolean)
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      paramWriter.b(paramInt, paramList, paramBoolean);
    }
  }
  
  public static void l(int paramInt, List<Integer> paramList, Writer paramWriter, boolean paramBoolean)
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      paramWriter.k(paramInt, paramList, paramBoolean);
    }
  }
  
  public static void m(int paramInt, List<Integer> paramList, Writer paramWriter, boolean paramBoolean)
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      paramWriter.h(paramInt, paramList, paramBoolean);
    }
  }
  
  public static void n(int paramInt, List<Boolean> paramList, Writer paramWriter, boolean paramBoolean)
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      paramWriter.i(paramInt, paramList, paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.SchemaUtil
 * JD-Core Version:    0.7.0.1
 */