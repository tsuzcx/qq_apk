package com.google.protobuf;

public class SingleFieldBuilderV3<MType extends AbstractMessage, BType extends AbstractMessage.Builder, IType extends MessageOrBuilder>
  implements AbstractMessage.BuilderParent
{
  private AbstractMessage.BuilderParent a;
  private BType b;
  private MType c;
  private boolean d;
  
  public SingleFieldBuilderV3(MType paramMType, AbstractMessage.BuilderParent paramBuilderParent, boolean paramBoolean)
  {
    this.c = ((AbstractMessage)Internal.a(paramMType));
    this.a = paramBuilderParent;
    this.d = paramBoolean;
  }
  
  private void h()
  {
    if (this.b != null) {
      this.c = null;
    }
    if (this.d)
    {
      AbstractMessage.BuilderParent localBuilderParent = this.a;
      if (localBuilderParent != null)
      {
        localBuilderParent.a();
        this.d = false;
      }
    }
  }
  
  public SingleFieldBuilderV3<MType, BType, IType> a(MType paramMType)
  {
    this.c = ((AbstractMessage)Internal.a(paramMType));
    paramMType = this.b;
    if (paramMType != null)
    {
      paramMType.dispose();
      this.b = null;
    }
    h();
    return this;
  }
  
  public void a()
  {
    h();
  }
  
  public SingleFieldBuilderV3<MType, BType, IType> b(MType paramMType)
  {
    if (this.b == null)
    {
      AbstractMessage localAbstractMessage = this.c;
      if (localAbstractMessage == localAbstractMessage.getDefaultInstanceForType())
      {
        this.c = paramMType;
        break label37;
      }
    }
    e().mergeFrom(paramMType);
    label37:
    h();
    return this;
  }
  
  public void b()
  {
    this.a = null;
  }
  
  public MType c()
  {
    if (this.c == null) {
      this.c = ((AbstractMessage)this.b.buildPartial());
    }
    return this.c;
  }
  
  public MType d()
  {
    this.d = true;
    return c();
  }
  
  public BType e()
  {
    if (this.b == null)
    {
      this.b = ((AbstractMessage.Builder)this.c.newBuilderForType(this));
      this.b.mergeFrom(this.c);
      this.b.markClean();
    }
    return this.b;
  }
  
  public IType f()
  {
    AbstractMessage.Builder localBuilder = this.b;
    if (localBuilder != null) {
      return localBuilder;
    }
    return this.c;
  }
  
  public SingleFieldBuilderV3<MType, BType, IType> g()
  {
    Object localObject = this.c;
    if (localObject != null) {
      localObject = ((AbstractMessage)localObject).getDefaultInstanceForType();
    } else {
      localObject = this.b.getDefaultInstanceForType();
    }
    this.c = ((AbstractMessage)localObject);
    localObject = this.b;
    if (localObject != null)
    {
      ((AbstractMessage.Builder)localObject).dispose();
      this.b = null;
    }
    h();
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.SingleFieldBuilderV3
 * JD-Core Version:    0.7.0.1
 */