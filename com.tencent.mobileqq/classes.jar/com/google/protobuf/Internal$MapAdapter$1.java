package com.google.protobuf;

final class Internal$MapAdapter$1
  implements Internal.MapAdapter.Converter<Integer, T>
{
  public T a(Integer paramInteger)
  {
    Internal.EnumLite localEnumLite = this.a.findValueByNumber(paramInteger.intValue());
    paramInteger = localEnumLite;
    if (localEnumLite == null) {
      paramInteger = this.b;
    }
    return paramInteger;
  }
  
  public Integer a(T paramT)
  {
    return Integer.valueOf(paramT.getNumber());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.Internal.MapAdapter.1
 * JD-Core Version:    0.7.0.1
 */