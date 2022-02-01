package com.google.protobuf;

import java.util.List;

final class ListFieldSchema$ListFieldSchemaLite
  extends ListFieldSchema
{
  private ListFieldSchema$ListFieldSchemaLite()
  {
    super(null);
  }
  
  static <E> Internal.ProtobufList<E> c(Object paramObject, long paramLong)
  {
    return (Internal.ProtobufList)UnsafeUtil.f(paramObject, paramLong);
  }
  
  <L> List<L> a(Object paramObject, long paramLong)
  {
    Internal.ProtobufList localProtobufList2 = c(paramObject, paramLong);
    Internal.ProtobufList localProtobufList1 = localProtobufList2;
    if (!localProtobufList2.a())
    {
      int i = localProtobufList2.size();
      if (i == 0) {
        i = 10;
      } else {
        i *= 2;
      }
      localProtobufList1 = localProtobufList2.e(i);
      UnsafeUtil.a(paramObject, paramLong, localProtobufList1);
    }
    return localProtobufList1;
  }
  
  <E> void a(Object paramObject1, Object paramObject2, long paramLong)
  {
    Object localObject = c(paramObject1, paramLong);
    Internal.ProtobufList localProtobufList = c(paramObject2, paramLong);
    int i = ((Internal.ProtobufList)localObject).size();
    int j = localProtobufList.size();
    paramObject2 = localObject;
    if (i > 0)
    {
      paramObject2 = localObject;
      if (j > 0)
      {
        paramObject2 = localObject;
        if (!((Internal.ProtobufList)localObject).a()) {
          paramObject2 = ((Internal.ProtobufList)localObject).e(j + i);
        }
        paramObject2.addAll(localProtobufList);
      }
    }
    localObject = localProtobufList;
    if (i > 0) {
      localObject = paramObject2;
    }
    UnsafeUtil.a(paramObject1, paramLong, localObject);
  }
  
  void b(Object paramObject, long paramLong)
  {
    c(paramObject, paramLong).b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.ListFieldSchema.ListFieldSchemaLite
 * JD-Core Version:    0.7.0.1
 */