package com.google.protobuf;

import java.util.AbstractList;
import java.util.List;

class RepeatedFieldBuilder$MessageOrBuilderExternalList<MType extends GeneratedMessage, BType extends GeneratedMessage.Builder, IType extends MessageOrBuilder>
  extends AbstractList<IType>
  implements List<IType>
{
  RepeatedFieldBuilder<MType, BType, IType> a;
  
  public IType a(int paramInt)
  {
    return this.a.c(paramInt);
  }
  
  public int size()
  {
    return this.a.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.RepeatedFieldBuilder.MessageOrBuilderExternalList
 * JD-Core Version:    0.7.0.1
 */