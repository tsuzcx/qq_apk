package com.google.protobuf;

import TFieldDescriptorType;;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Map.Entry<TFieldDescriptorType;Ljava.lang.Object;>;
import java.util.Set;

final class FieldSet<FieldDescriptorType extends FieldSet.FieldDescriptorLite<FieldDescriptorType>>
{
  private static final FieldSet d = new FieldSet(true);
  private final SmallSortedMap<FieldDescriptorType, Object> a;
  private boolean b;
  private boolean c = false;
  
  private FieldSet()
  {
    this.a = SmallSortedMap.a(16);
  }
  
  private FieldSet(boolean paramBoolean)
  {
    this.a = SmallSortedMap.a(0);
    d();
  }
  
  static int a(WireFormat.FieldType paramFieldType, int paramInt, Object paramObject)
  {
    int i = CodedOutputStream.h(paramInt);
    paramInt = i;
    if (paramFieldType == WireFormat.FieldType.GROUP) {
      paramInt = i * 2;
    }
    return paramInt + a(paramFieldType, paramObject);
  }
  
  static int a(WireFormat.FieldType paramFieldType, Object paramObject)
  {
    switch (FieldSet.1.b[paramFieldType.ordinal()])
    {
    default: 
      throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
    case 18: 
      if ((paramObject instanceof Internal.EnumLite)) {
        return CodedOutputStream.n(((Internal.EnumLite)paramObject).getNumber());
      }
      return CodedOutputStream.n(((Integer)paramObject).intValue());
    case 17: 
      return CodedOutputStream.h(((Long)paramObject).longValue());
    case 16: 
      return CodedOutputStream.k(((Integer)paramObject).intValue());
    case 15: 
      return CodedOutputStream.j(((Long)paramObject).longValue());
    case 14: 
      return CodedOutputStream.m(((Integer)paramObject).intValue());
    case 13: 
      return CodedOutputStream.j(((Integer)paramObject).intValue());
    case 12: 
      if ((paramObject instanceof ByteString)) {
        return CodedOutputStream.b((ByteString)paramObject);
      }
      return CodedOutputStream.c((byte[])paramObject);
    case 11: 
      if ((paramObject instanceof ByteString)) {
        return CodedOutputStream.b((ByteString)paramObject);
      }
      return CodedOutputStream.b((String)paramObject);
    case 10: 
      if ((paramObject instanceof LazyField)) {
        return CodedOutputStream.a((LazyField)paramObject);
      }
      return CodedOutputStream.b((MessageLite)paramObject);
    case 9: 
      return CodedOutputStream.d((MessageLite)paramObject);
    case 8: 
      return CodedOutputStream.b(((Boolean)paramObject).booleanValue());
    case 7: 
      return CodedOutputStream.l(((Integer)paramObject).intValue());
    case 6: 
      return CodedOutputStream.i(((Long)paramObject).longValue());
    case 5: 
      return CodedOutputStream.i(((Integer)paramObject).intValue());
    case 4: 
      return CodedOutputStream.g(((Long)paramObject).longValue());
    case 3: 
      return CodedOutputStream.f(((Long)paramObject).longValue());
    case 2: 
      return CodedOutputStream.b(((Float)paramObject).floatValue());
    }
    return CodedOutputStream.b(((Double)paramObject).doubleValue());
  }
  
  static int a(WireFormat.FieldType paramFieldType, boolean paramBoolean)
  {
    if (paramBoolean) {
      return 2;
    }
    return paramFieldType.getWireType();
  }
  
  public static <T extends FieldSet.FieldDescriptorLite<T>> FieldSet<T> a()
  {
    return new FieldSet();
  }
  
  public static Object a(CodedInputStream paramCodedInputStream, WireFormat.FieldType paramFieldType, boolean paramBoolean)
  {
    if (paramBoolean) {
      return WireFormat.a(paramCodedInputStream, paramFieldType, WireFormat.Utf8Validation.STRICT);
    }
    return WireFormat.a(paramCodedInputStream, paramFieldType, WireFormat.Utf8Validation.LOOSE);
  }
  
  private Object a(Object paramObject)
  {
    if ((paramObject instanceof byte[]))
    {
      paramObject = (byte[])paramObject;
      byte[] arrayOfByte = new byte[paramObject.length];
      System.arraycopy(paramObject, 0, arrayOfByte, 0, paramObject.length);
      return arrayOfByte;
    }
    return paramObject;
  }
  
  static void a(CodedOutputStream paramCodedOutputStream, WireFormat.FieldType paramFieldType, int paramInt, Object paramObject)
  {
    if (paramFieldType == WireFormat.FieldType.GROUP)
    {
      paramCodedOutputStream.e(paramInt, (MessageLite)paramObject);
      return;
    }
    paramCodedOutputStream.a(paramInt, a(paramFieldType, false));
    a(paramCodedOutputStream, paramFieldType, paramObject);
  }
  
  static void a(CodedOutputStream paramCodedOutputStream, WireFormat.FieldType paramFieldType, Object paramObject)
  {
    switch (FieldSet.1.b[paramFieldType.ordinal()])
    {
    default: 
      return;
    case 18: 
      if ((paramObject instanceof Internal.EnumLite))
      {
        paramCodedOutputStream.g(((Internal.EnumLite)paramObject).getNumber());
        return;
      }
      paramCodedOutputStream.g(((Integer)paramObject).intValue());
      return;
    case 17: 
      paramCodedOutputStream.c(((Long)paramObject).longValue());
      return;
    case 16: 
      paramCodedOutputStream.d(((Integer)paramObject).intValue());
      return;
    case 15: 
      paramCodedOutputStream.e(((Long)paramObject).longValue());
      return;
    case 14: 
      paramCodedOutputStream.f(((Integer)paramObject).intValue());
      return;
    case 13: 
      paramCodedOutputStream.c(((Integer)paramObject).intValue());
      return;
    case 12: 
      if ((paramObject instanceof ByteString))
      {
        paramCodedOutputStream.a((ByteString)paramObject);
        return;
      }
      paramCodedOutputStream.b((byte[])paramObject);
      return;
    case 11: 
      if ((paramObject instanceof ByteString))
      {
        paramCodedOutputStream.a((ByteString)paramObject);
        return;
      }
      paramCodedOutputStream.a((String)paramObject);
      return;
    case 10: 
      paramCodedOutputStream.a((MessageLite)paramObject);
      return;
    case 9: 
      paramCodedOutputStream.c((MessageLite)paramObject);
      return;
    case 8: 
      paramCodedOutputStream.a(((Boolean)paramObject).booleanValue());
      return;
    case 7: 
      paramCodedOutputStream.e(((Integer)paramObject).intValue());
      return;
    case 6: 
      paramCodedOutputStream.d(((Long)paramObject).longValue());
      return;
    case 5: 
      paramCodedOutputStream.b(((Integer)paramObject).intValue());
      return;
    case 4: 
      paramCodedOutputStream.b(((Long)paramObject).longValue());
      return;
    case 3: 
      paramCodedOutputStream.a(((Long)paramObject).longValue());
      return;
    case 2: 
      paramCodedOutputStream.a(((Float)paramObject).floatValue());
      return;
    }
    paramCodedOutputStream.a(((Double)paramObject).doubleValue());
  }
  
  public static void a(FieldSet.FieldDescriptorLite<?> paramFieldDescriptorLite, Object paramObject, CodedOutputStream paramCodedOutputStream)
  {
    WireFormat.FieldType localFieldType = paramFieldDescriptorLite.j();
    int i = paramFieldDescriptorLite.f();
    if (paramFieldDescriptorLite.p())
    {
      paramObject = (List)paramObject;
      if (paramFieldDescriptorLite.q())
      {
        paramCodedOutputStream.a(i, 2);
        i = 0;
        paramFieldDescriptorLite = paramObject.iterator();
        while (paramFieldDescriptorLite.hasNext()) {
          i += a(localFieldType, paramFieldDescriptorLite.next());
        }
        paramCodedOutputStream.q(i);
        paramFieldDescriptorLite = paramObject.iterator();
        while (paramFieldDescriptorLite.hasNext()) {
          a(paramCodedOutputStream, localFieldType, paramFieldDescriptorLite.next());
        }
      }
      paramFieldDescriptorLite = paramObject.iterator();
      while (paramFieldDescriptorLite.hasNext()) {
        a(paramCodedOutputStream, localFieldType, i, paramFieldDescriptorLite.next());
      }
    }
    if ((paramObject instanceof LazyField))
    {
      a(paramCodedOutputStream, localFieldType, i, ((LazyField)paramObject).a());
      return;
    }
    a(paramCodedOutputStream, localFieldType, i, paramObject);
  }
  
  private void a(Map.Entry<FieldDescriptorType, Object> paramEntry, CodedOutputStream paramCodedOutputStream)
  {
    Object localObject1 = (FieldSet.FieldDescriptorLite)paramEntry.getKey();
    if ((((FieldSet.FieldDescriptorLite)localObject1).h() == WireFormat.JavaType.MESSAGE) && (!((FieldSet.FieldDescriptorLite)localObject1).p()) && (!((FieldSet.FieldDescriptorLite)localObject1).q()))
    {
      Object localObject2 = paramEntry.getValue();
      localObject1 = localObject2;
      if ((localObject2 instanceof LazyField)) {
        localObject1 = ((LazyField)localObject2).a();
      }
      paramCodedOutputStream.b(((FieldSet.FieldDescriptorLite)paramEntry.getKey()).f(), (MessageLite)localObject1);
      return;
    }
    a((FieldSet.FieldDescriptorLite)localObject1, paramEntry.getValue(), paramCodedOutputStream);
  }
  
  private void a(Map<FieldDescriptorType, Object> paramMap, Map.Entry<FieldDescriptorType, Object> paramEntry)
  {
    FieldSet.FieldDescriptorLite localFieldDescriptorLite = (FieldSet.FieldDescriptorLite)paramEntry.getKey();
    paramEntry = paramEntry.getValue();
    if ((paramEntry instanceof LazyField))
    {
      paramMap.put(localFieldDescriptorLite, ((LazyField)paramEntry).a());
      return;
    }
    paramMap.put(localFieldDescriptorLite, paramEntry);
  }
  
  private boolean a(Map.Entry<FieldDescriptorType, Object> paramEntry)
  {
    FieldSet.FieldDescriptorLite localFieldDescriptorLite = (FieldSet.FieldDescriptorLite)paramEntry.getKey();
    if (localFieldDescriptorLite.h() == WireFormat.JavaType.MESSAGE)
    {
      if (localFieldDescriptorLite.p())
      {
        paramEntry = ((List)paramEntry.getValue()).iterator();
        do
        {
          if (!paramEntry.hasNext()) {
            break;
          }
        } while (((MessageLite)paramEntry.next()).isInitialized());
        return false;
      }
      paramEntry = paramEntry.getValue();
      if ((paramEntry instanceof MessageLite))
      {
        if (!((MessageLite)paramEntry).isInitialized()) {
          return false;
        }
      }
      else
      {
        if ((paramEntry instanceof LazyField)) {
          return true;
        }
        throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
      }
    }
    return true;
  }
  
  public static <T extends FieldSet.FieldDescriptorLite<T>> FieldSet<T> b()
  {
    return d;
  }
  
  private static void b(WireFormat.FieldType paramFieldType, Object paramObject)
  {
    Internal.a(paramObject);
    int i = FieldSet.1.a[paramFieldType.getJavaType().ordinal()];
    boolean bool = false;
    switch (i)
    {
    default: 
      break;
    case 9: 
      if ((!(paramObject instanceof MessageLite)) && (!(paramObject instanceof LazyField))) {
        break;
      }
    case 8: 
    case 7: 
      for (;;)
      {
        bool = true;
        break;
        if (!(paramObject instanceof Integer))
        {
          if (!(paramObject instanceof Internal.EnumLite)) {
            break;
          }
          if ((goto 89) && (!(paramObject instanceof ByteString))) {
            if (!(paramObject instanceof byte[])) {
              break;
            }
          }
        }
      }
    case 6: 
      bool = paramObject instanceof String;
      break;
    case 5: 
      bool = paramObject instanceof Boolean;
      break;
    case 4: 
      bool = paramObject instanceof Double;
      break;
    case 3: 
      bool = paramObject instanceof Float;
      break;
    case 2: 
      bool = paramObject instanceof Long;
      break;
    case 1: 
      bool = paramObject instanceof Integer;
    }
    if (bool) {
      return;
    }
    paramFieldType = new IllegalArgumentException("Wrong object type used with protocol message reflection.");
    for (;;)
    {
      throw paramFieldType;
    }
  }
  
  private void b(Map.Entry<FieldDescriptorType, Object> paramEntry)
  {
    FieldSet.FieldDescriptorLite localFieldDescriptorLite = (FieldSet.FieldDescriptorLite)paramEntry.getKey();
    Object localObject1 = paramEntry.getValue();
    paramEntry = (Map.Entry<FieldDescriptorType, Object>)localObject1;
    if ((localObject1 instanceof LazyField)) {
      paramEntry = ((LazyField)localObject1).a();
    }
    if (localFieldDescriptorLite.p())
    {
      Object localObject2 = b(localFieldDescriptorLite);
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new ArrayList();
      }
      paramEntry = ((List)paramEntry).iterator();
      while (paramEntry.hasNext())
      {
        localObject2 = paramEntry.next();
        ((List)localObject1).add(a(localObject2));
      }
      this.a.a(localFieldDescriptorLite, localObject1);
      return;
    }
    if (localFieldDescriptorLite.h() == WireFormat.JavaType.MESSAGE)
    {
      localObject1 = b(localFieldDescriptorLite);
      if (localObject1 == null)
      {
        this.a.a(localFieldDescriptorLite, a(paramEntry));
        return;
      }
      paramEntry = localFieldDescriptorLite.a(((MessageLite)localObject1).toBuilder(), (MessageLite)paramEntry).build();
      this.a.a(localFieldDescriptorLite, paramEntry);
      return;
    }
    this.a.a(localFieldDescriptorLite, a(paramEntry));
  }
  
  public static int c(FieldSet.FieldDescriptorLite<?> paramFieldDescriptorLite, Object paramObject)
  {
    WireFormat.FieldType localFieldType = paramFieldDescriptorLite.j();
    int k = paramFieldDescriptorLite.f();
    if (paramFieldDescriptorLite.p())
    {
      boolean bool = paramFieldDescriptorLite.q();
      int j = 0;
      int i = 0;
      if (bool)
      {
        paramFieldDescriptorLite = ((List)paramObject).iterator();
        while (paramFieldDescriptorLite.hasNext()) {
          i += a(localFieldType, paramFieldDescriptorLite.next());
        }
        return CodedOutputStream.h(k) + i + CodedOutputStream.r(i);
      }
      paramFieldDescriptorLite = ((List)paramObject).iterator();
      i = j;
      while (paramFieldDescriptorLite.hasNext()) {
        i += a(localFieldType, k, paramFieldDescriptorLite.next());
      }
      return i;
    }
    return a(localFieldType, k, paramObject);
  }
  
  private int c(Map.Entry<FieldDescriptorType, Object> paramEntry)
  {
    FieldSet.FieldDescriptorLite localFieldDescriptorLite = (FieldSet.FieldDescriptorLite)paramEntry.getKey();
    Object localObject = paramEntry.getValue();
    if ((localFieldDescriptorLite.h() == WireFormat.JavaType.MESSAGE) && (!localFieldDescriptorLite.p()) && (!localFieldDescriptorLite.q()))
    {
      if ((localObject instanceof LazyField)) {
        return CodedOutputStream.b(((FieldSet.FieldDescriptorLite)paramEntry.getKey()).f(), (LazyField)localObject);
      }
      return CodedOutputStream.d(((FieldSet.FieldDescriptorLite)paramEntry.getKey()).f(), (MessageLite)localObject);
    }
    return c(localFieldDescriptorLite, localObject);
  }
  
  public Object a(FieldDescriptorType paramFieldDescriptorType, int paramInt)
  {
    if (paramFieldDescriptorType.p())
    {
      paramFieldDescriptorType = b(paramFieldDescriptorType);
      if (paramFieldDescriptorType != null) {
        return ((List)paramFieldDescriptorType).get(paramInt);
      }
      throw new IndexOutOfBoundsException();
    }
    throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
  }
  
  public void a(CodedOutputStream paramCodedOutputStream)
  {
    int i = 0;
    while (i < this.a.c())
    {
      localObject = this.a.b(i);
      a((FieldSet.FieldDescriptorLite)((Map.Entry)localObject).getKey(), ((Map.Entry)localObject).getValue(), paramCodedOutputStream);
      i += 1;
    }
    Object localObject = this.a.e().iterator();
    while (((Iterator)localObject).hasNext())
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
      a((FieldSet.FieldDescriptorLite)localEntry.getKey(), localEntry.getValue(), paramCodedOutputStream);
    }
  }
  
  public void a(FieldDescriptorType paramFieldDescriptorType, int paramInt, Object paramObject)
  {
    if (paramFieldDescriptorType.p())
    {
      Object localObject = b(paramFieldDescriptorType);
      if (localObject != null)
      {
        b(paramFieldDescriptorType.j(), paramObject);
        ((List)localObject).set(paramInt, paramObject);
        return;
      }
      throw new IndexOutOfBoundsException();
    }
    throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
  }
  
  public void a(FieldDescriptorType paramFieldDescriptorType, Object paramObject)
  {
    if (paramFieldDescriptorType.p())
    {
      if ((paramObject instanceof List))
      {
        ArrayList localArrayList = new ArrayList();
        localArrayList.addAll((List)paramObject);
        paramObject = localArrayList.iterator();
        while (paramObject.hasNext())
        {
          Object localObject = paramObject.next();
          b(paramFieldDescriptorType.j(), localObject);
        }
        paramObject = localArrayList;
      }
      else
      {
        throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
      }
    }
    else {
      b(paramFieldDescriptorType.j(), paramObject);
    }
    if ((paramObject instanceof LazyField)) {
      this.c = true;
    }
    this.a.a(paramFieldDescriptorType, paramObject);
  }
  
  public void a(FieldSet<FieldDescriptorType> paramFieldSet)
  {
    int i = 0;
    while (i < paramFieldSet.a.c())
    {
      b(paramFieldSet.a.b(i));
      i += 1;
    }
    paramFieldSet = paramFieldSet.a.e().iterator();
    while (paramFieldSet.hasNext()) {
      b((Map.Entry)paramFieldSet.next());
    }
  }
  
  public boolean a(FieldDescriptorType paramFieldDescriptorType)
  {
    if (!paramFieldDescriptorType.p()) {
      return this.a.get(paramFieldDescriptorType) != null;
    }
    throw new IllegalArgumentException("hasField() can only be called on non-repeated fields.");
  }
  
  public Object b(FieldDescriptorType paramFieldDescriptorType)
  {
    Object localObject = this.a.get(paramFieldDescriptorType);
    paramFieldDescriptorType = localObject;
    if ((localObject instanceof LazyField)) {
      paramFieldDescriptorType = ((LazyField)localObject).a();
    }
    return paramFieldDescriptorType;
  }
  
  public void b(CodedOutputStream paramCodedOutputStream)
  {
    int i = 0;
    while (i < this.a.c())
    {
      a(this.a.b(i), paramCodedOutputStream);
      i += 1;
    }
    Iterator localIterator = this.a.e().iterator();
    while (localIterator.hasNext()) {
      a((Map.Entry)localIterator.next(), paramCodedOutputStream);
    }
  }
  
  public void b(FieldDescriptorType paramFieldDescriptorType, Object paramObject)
  {
    if (paramFieldDescriptorType.p())
    {
      b(paramFieldDescriptorType.j(), paramObject);
      Object localObject = b(paramFieldDescriptorType);
      if (localObject == null)
      {
        localObject = new ArrayList();
        this.a.a(paramFieldDescriptorType, localObject);
        paramFieldDescriptorType = (TFieldDescriptorType)localObject;
      }
      else
      {
        paramFieldDescriptorType = (List)localObject;
      }
      paramFieldDescriptorType.add(paramObject);
      return;
    }
    throw new IllegalArgumentException("addRepeatedField() can only be called on repeated fields.");
  }
  
  public void c(FieldDescriptorType paramFieldDescriptorType)
  {
    this.a.remove(paramFieldDescriptorType);
    if (this.a.isEmpty()) {
      this.c = false;
    }
  }
  
  boolean c()
  {
    return this.a.isEmpty();
  }
  
  public int d(FieldDescriptorType paramFieldDescriptorType)
  {
    if (paramFieldDescriptorType.p())
    {
      paramFieldDescriptorType = b(paramFieldDescriptorType);
      if (paramFieldDescriptorType == null) {
        return 0;
      }
      return ((List)paramFieldDescriptorType).size();
    }
    throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
  }
  
  public void d()
  {
    if (this.b) {
      return;
    }
    this.a.a();
    this.b = true;
  }
  
  public boolean e()
  {
    return this.b;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof FieldSet)) {
      return false;
    }
    paramObject = (FieldSet)paramObject;
    return this.a.equals(paramObject.a);
  }
  
  public FieldSet<FieldDescriptorType> f()
  {
    FieldSet localFieldSet = a();
    int i = 0;
    while (i < this.a.c())
    {
      localObject = this.a.b(i);
      localFieldSet.a((FieldSet.FieldDescriptorLite)((Map.Entry)localObject).getKey(), ((Map.Entry)localObject).getValue());
      i += 1;
    }
    Object localObject = this.a.e().iterator();
    while (((Iterator)localObject).hasNext())
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
      localFieldSet.a((FieldSet.FieldDescriptorLite)localEntry.getKey(), localEntry.getValue());
    }
    localFieldSet.c = this.c;
    return localFieldSet;
  }
  
  public void g()
  {
    this.a.clear();
    this.c = false;
  }
  
  public Map<FieldDescriptorType, Object> h()
  {
    if (this.c)
    {
      SmallSortedMap localSmallSortedMap = SmallSortedMap.a(16);
      int i = 0;
      while (i < this.a.c())
      {
        a(localSmallSortedMap, this.a.b(i));
        i += 1;
      }
      Iterator localIterator = this.a.e().iterator();
      while (localIterator.hasNext()) {
        a(localSmallSortedMap, (Map.Entry)localIterator.next());
      }
      if (this.a.b()) {
        localSmallSortedMap.a();
      }
      return localSmallSortedMap;
    }
    if (this.a.b()) {
      return this.a;
    }
    return Collections.unmodifiableMap(this.a);
  }
  
  public int hashCode()
  {
    return this.a.hashCode();
  }
  
  public Iterator<Map.Entry<FieldDescriptorType, Object>> i()
  {
    if (this.c) {
      return new LazyField.LazyIterator(this.a.entrySet().iterator());
    }
    return this.a.entrySet().iterator();
  }
  
  Iterator<Map.Entry<FieldDescriptorType, Object>> j()
  {
    if (this.c) {
      return new LazyField.LazyIterator(this.a.f().iterator());
    }
    return this.a.f().iterator();
  }
  
  public boolean k()
  {
    int i = 0;
    while (i < this.a.c())
    {
      if (!a(this.a.b(i))) {
        return false;
      }
      i += 1;
    }
    Iterator localIterator = this.a.e().iterator();
    while (localIterator.hasNext()) {
      if (!a((Map.Entry)localIterator.next())) {
        return false;
      }
    }
    return true;
  }
  
  public int l()
  {
    int j = 0;
    int i = 0;
    while (j < this.a.c())
    {
      localObject = this.a.b(j);
      i += c((FieldSet.FieldDescriptorLite)((Map.Entry)localObject).getKey(), ((Map.Entry)localObject).getValue());
      j += 1;
    }
    Object localObject = this.a.e().iterator();
    while (((Iterator)localObject).hasNext())
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
      i += c((FieldSet.FieldDescriptorLite)localEntry.getKey(), localEntry.getValue());
    }
    return i;
  }
  
  public int m()
  {
    int j = 0;
    int i = 0;
    while (j < this.a.c())
    {
      i += c(this.a.b(j));
      j += 1;
    }
    Iterator localIterator = this.a.e().iterator();
    while (localIterator.hasNext()) {
      i += c((Map.Entry)localIterator.next());
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.FieldSet
 * JD-Core Version:    0.7.0.1
 */