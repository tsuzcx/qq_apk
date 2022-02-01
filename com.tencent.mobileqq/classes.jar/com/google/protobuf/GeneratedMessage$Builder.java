package com.google.protobuf;

public abstract class GeneratedMessage$Builder<BuilderType extends Builder<BuilderType>>
  extends AbstractMessage.Builder<BuilderType>
{
  private GeneratedMessage.BuilderParent a;
  private boolean b;
  private UnknownFieldSet c = UnknownFieldSet.b();
  
  protected GeneratedMessage$Builder()
  {
    this(null);
  }
  
  protected GeneratedMessage$Builder(GeneratedMessage.BuilderParent paramBuilderParent)
  {
    this.a = paramBuilderParent;
  }
  
  public BuilderType a()
  {
    Builder localBuilder = (Builder)getDefaultInstanceForType().newBuilderForType();
    localBuilder.mergeFrom(buildPartial());
    return localBuilder;
  }
  
  protected final void b()
  {
    if (this.b)
    {
      GeneratedMessage.BuilderParent localBuilderParent = this.a;
      if (localBuilderParent != null)
      {
        localBuilderParent.a();
        this.b = false;
      }
    }
  }
  
  public final UnknownFieldSet getUnknownFields()
  {
    return this.c;
  }
  
  protected void markClean()
  {
    this.b = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.GeneratedMessage.Builder
 * JD-Core Version:    0.7.0.1
 */