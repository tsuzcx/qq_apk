package com.samskivert.mustache;

public class Template$Context
{
  public final Object data;
  public final int index;
  public final boolean onFirst;
  public final boolean onLast;
  public final Context parent;
  
  public Template$Context(Object paramObject, Context paramContext, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.data = paramObject;
    this.parent = paramContext;
    this.index = paramInt;
    this.onFirst = paramBoolean1;
    this.onLast = paramBoolean2;
  }
  
  public Context nest(Object paramObject)
  {
    return new Context(paramObject, this, this.index, this.onFirst, this.onLast);
  }
  
  public Context nest(Object paramObject, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    return new Context(paramObject, this, paramInt, paramBoolean1, paramBoolean2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.samskivert.mustache.Template.Context
 * JD-Core Version:    0.7.0.1
 */