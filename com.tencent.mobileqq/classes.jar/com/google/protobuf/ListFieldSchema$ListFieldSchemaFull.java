package com.google.protobuf;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

final class ListFieldSchema$ListFieldSchemaFull
  extends ListFieldSchema
{
  private static final Class<?> a = Collections.unmodifiableList(Collections.emptyList()).getClass();
  
  private ListFieldSchema$ListFieldSchemaFull()
  {
    super(null);
  }
  
  private static <L> List<L> a(Object paramObject, long paramLong, int paramInt)
  {
    List localList = c(paramObject, paramLong);
    if (localList.isEmpty())
    {
      if ((localList instanceof LazyStringList)) {
        localObject = new LazyStringArrayList(paramInt);
      } else if (((localList instanceof PrimitiveNonBoxingCollection)) && ((localList instanceof Internal.ProtobufList))) {
        localObject = ((Internal.ProtobufList)localList).e(paramInt);
      } else {
        localObject = new ArrayList(paramInt);
      }
      UnsafeUtil.a(paramObject, paramLong, localObject);
      return localObject;
    }
    if (a.isAssignableFrom(localList.getClass()))
    {
      localObject = new ArrayList(localList.size() + paramInt);
      ((ArrayList)localObject).addAll(localList);
      UnsafeUtil.a(paramObject, paramLong, localObject);
    }
    for (paramObject = localObject;; paramObject = localObject)
    {
      return paramObject;
      if (!(localList instanceof UnmodifiableLazyStringList)) {
        break;
      }
      localObject = new LazyStringArrayList(localList.size() + paramInt);
      ((LazyStringArrayList)localObject).addAll((UnmodifiableLazyStringList)localList);
      UnsafeUtil.a(paramObject, paramLong, localObject);
    }
    Object localObject = localList;
    if ((localList instanceof PrimitiveNonBoxingCollection))
    {
      localObject = localList;
      if ((localList instanceof Internal.ProtobufList))
      {
        Internal.ProtobufList localProtobufList = (Internal.ProtobufList)localList;
        localObject = localList;
        if (!localProtobufList.a())
        {
          localObject = localProtobufList.e(localList.size() + paramInt);
          UnsafeUtil.a(paramObject, paramLong, localObject);
        }
      }
    }
    return localObject;
  }
  
  static <E> List<E> c(Object paramObject, long paramLong)
  {
    return (List)UnsafeUtil.f(paramObject, paramLong);
  }
  
  <L> List<L> a(Object paramObject, long paramLong)
  {
    return a(paramObject, paramLong, 10);
  }
  
  <E> void a(Object paramObject1, Object paramObject2, long paramLong)
  {
    paramObject2 = c(paramObject2, paramLong);
    List localList = a(paramObject1, paramLong, paramObject2.size());
    int i = localList.size();
    int j = paramObject2.size();
    if ((i > 0) && (j > 0)) {
      localList.addAll(paramObject2);
    }
    if (i > 0) {
      paramObject2 = localList;
    }
    UnsafeUtil.a(paramObject1, paramLong, paramObject2);
  }
  
  void b(Object paramObject, long paramLong)
  {
    Object localObject = (List)UnsafeUtil.f(paramObject, paramLong);
    if ((localObject instanceof LazyStringList))
    {
      localObject = ((LazyStringList)localObject).e();
    }
    else
    {
      if (a.isAssignableFrom(localObject.getClass())) {
        return;
      }
      if (((localObject instanceof PrimitiveNonBoxingCollection)) && ((localObject instanceof Internal.ProtobufList)))
      {
        paramObject = (Internal.ProtobufList)localObject;
        if (paramObject.a()) {
          paramObject.b();
        }
        return;
      }
      localObject = Collections.unmodifiableList((List)localObject);
    }
    UnsafeUtil.a(paramObject, paramLong, localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.ListFieldSchema.ListFieldSchemaFull
 * JD-Core Version:    0.7.0.1
 */