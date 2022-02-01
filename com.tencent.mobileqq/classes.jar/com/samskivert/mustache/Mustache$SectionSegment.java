package com.samskivert.mustache;

import java.io.IOException;
import java.io.Writer;
import java.util.Arrays;
import java.util.Iterator;

public class Mustache$SectionSegment
  extends Mustache.BlockSegment
{
  protected final Mustache.Compiler _comp;
  
  public Mustache$SectionSegment(Mustache.Compiler paramCompiler, String paramString, Template.Segment[] paramArrayOfSegment, int paramInt)
  {
    super(paramString, paramArrayOfSegment, paramInt);
    this._comp = paramCompiler;
  }
  
  public void decompile(Mustache.Delims paramDelims, StringBuilder paramStringBuilder)
  {
    paramDelims.addTag('#', this._name, paramStringBuilder);
    Template.Segment[] arrayOfSegment = this._segs;
    int j = arrayOfSegment.length;
    int i = 0;
    while (i < j)
    {
      arrayOfSegment[i].decompile(paramDelims, paramStringBuilder);
      i += 1;
    }
    paramDelims.addTag('/', this._name, paramStringBuilder);
  }
  
  public void execute(Template paramTemplate, Template.Context paramContext, Writer paramWriter)
  {
    Object localObject = paramTemplate.getSectionValue(paramContext, this._name, this._line);
    Iterator localIterator = this._comp.collector.toIterator(localObject);
    if (localIterator != null)
    {
      int i = 0;
      while (localIterator.hasNext())
      {
        localObject = localIterator.next();
        boolean bool1;
        if (i == 0) {
          bool1 = true;
        } else {
          bool1 = false;
        }
        boolean bool2 = localIterator.hasNext();
        i += 1;
        executeSegs(paramTemplate, paramContext.nest(localObject, i, bool1, true ^ bool2), paramWriter);
      }
    }
    if ((localObject instanceof Boolean))
    {
      if (((Boolean)localObject).booleanValue()) {
        executeSegs(paramTemplate, paramContext, paramWriter);
      }
    }
    else
    {
      if ((localObject instanceof Mustache.Lambda)) {
        try
        {
          ((Mustache.Lambda)localObject).execute(paramTemplate.createFragment(this._segs, paramContext), paramWriter);
          return;
        }
        catch (IOException paramTemplate)
        {
          throw new MustacheException(paramTemplate);
        }
      }
      if (this._comp.isFalsey(localObject)) {
        return;
      }
      executeSegs(paramTemplate, paramContext.nest(localObject), paramWriter);
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Section(");
    localStringBuilder.append(this._name);
    localStringBuilder.append(":");
    localStringBuilder.append(this._line);
    localStringBuilder.append("): ");
    localStringBuilder.append(Arrays.toString(this._segs));
    return localStringBuilder.toString();
  }
  
  public void visit(Mustache.Visitor paramVisitor)
  {
    if (paramVisitor.visitSection(this._name))
    {
      Template.Segment[] arrayOfSegment = this._segs;
      int j = arrayOfSegment.length;
      int i = 0;
      while (i < j)
      {
        arrayOfSegment[i].visit(paramVisitor);
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.samskivert.mustache.Mustache.SectionSegment
 * JD-Core Version:    0.7.0.1
 */