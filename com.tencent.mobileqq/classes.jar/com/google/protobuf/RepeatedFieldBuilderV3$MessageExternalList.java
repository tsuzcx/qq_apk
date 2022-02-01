package com.google.protobuf;

import java.util.AbstractList;
import java.util.List;

class RepeatedFieldBuilderV3$MessageExternalList<MType extends AbstractMessage, BType extends AbstractMessage.Builder, IType extends MessageOrBuilder>
  extends AbstractList<MType>
  implements List<MType>
{
  RepeatedFieldBuilderV3<MType, BType, IType> a;
  
  public MType a(int paramInt)
  {
    return this.a.a(paramInt);
  }
  
  void a()
  {
    this.modCount += 1;
  }
  
  public int size()
  {
    return this.a.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.RepeatedFieldBuilderV3.MessageExternalList
 * JD-Core Version:    0.7.0.1
 */