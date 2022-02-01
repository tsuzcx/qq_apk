package com.samskivert.mustache;

import java.io.IOException;
import java.io.Writer;
import java.util.Arrays;
import java.util.Iterator;

public class Mustache$InvertedSegment
  extends Mustache.BlockSegment
{
  protected final Mustache.Compiler _comp;
  
  public Mustache$InvertedSegment(Mustache.Compiler paramCompiler, String paramString, Template.Segment[] paramArrayOfSegment, int paramInt)
  {
    super(paramString, paramArrayOfSegment, paramInt);
    this._comp = paramCompiler;
  }
  
  public void decompile(Mustache.Delims paramDelims, StringBuilder paramStringBuilder)
  {
    paramDelims.addTag('^', this._name, paramStringBuilder);
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
    if (localIterator != null) {
      if (!localIterator.hasNext()) {
        executeSegs(paramTemplate, paramContext, paramWriter);
      }
    }
    do
    {
      do
      {
        return;
        if (!(localObject instanceof Boolean)) {
          break;
        }
      } while (((Boolean)localObject).booleanValue());
      executeSegs(paramTemplate, paramContext, paramWriter);
      return;
      if ((localObject instanceof Mustache.InvertibleLambda)) {
        try
        {
          ((Mustache.InvertibleLambda)localObject).executeInverse(paramTemplate.createFragment(this._segs, paramContext), paramWriter);
          return;
        }
        catch (IOException paramTemplate)
        {
          throw new MustacheException(paramTemplate);
        }
      }
    } while (!this._comp.isFalsey(localObject));
    executeSegs(paramTemplate, paramContext, paramWriter);
  }
  
  public String toString()
  {
    return "Inverted(" + this._name + ":" + this._line + "): " + Arrays.toString(this._segs);
  }
  
  public void visit(Mustache.Visitor paramVisitor)
  {
    if (paramVisitor.visitInvertedSection(this._name))
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
 * Qualified Name:     com.samskivert.mustache.Mustache.InvertedSegment
 * JD-Core Version:    0.7.0.1
 */