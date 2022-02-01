package com.samskivert.mustache;

import java.io.Writer;

class Template$1
  extends Template.Fragment
{
  Template$1(Template paramTemplate, Template.Context paramContext, Template.Segment[] paramArrayOfSegment)
  {
    super(paramTemplate);
  }
  
  private Object context(Template.Context paramContext, int paramInt)
  {
    if (paramInt == 0) {
      return paramContext.data;
    }
    return context(paramContext.parent, paramInt - 1);
  }
  
  private void execute(Template.Context paramContext, Writer paramWriter)
  {
    Template.Segment[] arrayOfSegment = this.val$segs;
    int j = arrayOfSegment.length;
    int i = 0;
    while (i < j)
    {
      arrayOfSegment[i].execute(this.this$0, paramContext, paramWriter);
      i += 1;
    }
  }
  
  public Object context()
  {
    return this.val$currentCtx.data;
  }
  
  public Object context(int paramInt)
  {
    return context(this.val$currentCtx, paramInt);
  }
  
  public StringBuilder decompile(StringBuilder paramStringBuilder)
  {
    Template.Segment[] arrayOfSegment = this.val$segs;
    int j = arrayOfSegment.length;
    int i = 0;
    while (i < j)
    {
      arrayOfSegment[i].decompile(this.this$0._compiler.delims, paramStringBuilder);
      i += 1;
    }
    return paramStringBuilder;
  }
  
  public void execute(Writer paramWriter)
  {
    execute(this.val$currentCtx, paramWriter);
  }
  
  public void execute(Object paramObject, Writer paramWriter)
  {
    execute(this.val$currentCtx.nest(paramObject), paramWriter);
  }
  
  public void executeTemplate(Template paramTemplate, Writer paramWriter)
  {
    paramTemplate.executeSegs(this.val$currentCtx, paramWriter);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.samskivert.mustache.Template.1
 * JD-Core Version:    0.7.0.1
 */