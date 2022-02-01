package com.google.protobuf;

public class SingleFieldBuilder<MType extends GeneratedMessage, BType extends GeneratedMessage.Builder, IType extends MessageOrBuilder>
  implements GeneratedMessage.BuilderParent
{
  private GeneratedMessage.BuilderParent a;
  private BType b;
  private MType c;
  private boolean d;
  
  public SingleFieldBuilder(MType paramMType, GeneratedMessage.BuilderParent paramBuilderParent, boolean paramBoolean)
  {
    this.c = ((GeneratedMessage)Internal.a(paramMType));
    this.a = paramBuilderParent;
    this.d = paramBoolean;
  }
  
  private void f()
  {
    if (this.b != null) {
      this.c = null;
    }
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
  
  public void a()
  {
    f();
  }
  
  public MType b()
  {
    if (this.c == null) {
      this.c = ((GeneratedMessage)this.b.buildPartial());
    }
    return this.c;
  }
  
  public MType c()
  {
    this.d = true;
    return b();
  }
  
  public BType d()
  {
    if (this.b == null)
    {
      this.b = ((GeneratedMessage.Builder)this.c.newBuilderForType(this));
      this.b.mergeFrom(this.c);
      this.b.markClean();
    }
    return this.b;
  }
  
  public IType e()
  {
    GeneratedMessage.Builder localBuilder = this.b;
    if (localBuilder != null) {
      return localBuilder;
    }
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.SingleFieldBuilder
 * JD-Core Version:    0.7.0.1
 */