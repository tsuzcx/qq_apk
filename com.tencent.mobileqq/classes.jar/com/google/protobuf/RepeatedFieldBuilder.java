package com.google.protobuf;

import java.util.ArrayList;
import java.util.List;

public class RepeatedFieldBuilder<MType extends GeneratedMessage, BType extends GeneratedMessage.Builder, IType extends MessageOrBuilder>
  implements GeneratedMessage.BuilderParent
{
  private GeneratedMessage.BuilderParent a;
  private List<MType> b;
  private List<SingleFieldBuilder<MType, BType, IType>> c;
  private boolean d;
  
  private MType a(int paramInt, boolean paramBoolean)
  {
    Object localObject = this.c;
    if (localObject == null) {
      return (GeneratedMessage)this.b.get(paramInt);
    }
    localObject = (SingleFieldBuilder)((List)localObject).get(paramInt);
    if (localObject == null) {
      return (GeneratedMessage)this.b.get(paramInt);
    }
    if (paramBoolean) {
      return ((SingleFieldBuilder)localObject).c();
    }
    return ((SingleFieldBuilder)localObject).b();
  }
  
  private void c()
  {
    if (this.c == null)
    {
      this.c = new ArrayList(this.b.size());
      int i = 0;
      while (i < this.b.size())
      {
        this.c.add(null);
        i += 1;
      }
    }
  }
  
  private void d()
  {
    if (this.d)
    {
      GeneratedMessage.BuilderParent localBuilderParent = this.a;
      if (localBuilderParent != null)
      {
        localBuilderParent.a();
        this.d = false;
      }
    }
  }
  
  public MType a(int paramInt)
  {
    return a(paramInt, false);
  }
  
  public void a()
  {
    d();
  }
  
  public int b()
  {
    return this.b.size();
  }
  
  public BType b(int paramInt)
  {
    c();
    SingleFieldBuilder localSingleFieldBuilder2 = (SingleFieldBuilder)this.c.get(paramInt);
    SingleFieldBuilder localSingleFieldBuilder1 = localSingleFieldBuilder2;
    if (localSingleFieldBuilder2 == null)
    {
      localSingleFieldBuilder1 = new SingleFieldBuilder((GeneratedMessage)this.b.get(paramInt), this, this.d);
      this.c.set(paramInt, localSingleFieldBuilder1);
    }
    return localSingleFieldBuilder1.d();
  }
  
  public IType c(int paramInt)
  {
    Object localObject = this.c;
    if (localObject == null) {
      return (MessageOrBuilder)this.b.get(paramInt);
    }
    localObject = (SingleFieldBuilder)((List)localObject).get(paramInt);
    if (localObject == null) {
      return (MessageOrBuilder)this.b.get(paramInt);
    }
    return ((SingleFieldBuilder)localObject).e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.RepeatedFieldBuilder
 * JD-Core Version:    0.7.0.1
 */