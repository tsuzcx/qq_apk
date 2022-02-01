package com.samskivert.mustache;

import java.util.ArrayList;
import java.util.List;

public class Mustache$Accumulator
{
  protected final Mustache.Compiler _comp;
  protected final List<Template.Segment> _segs = new ArrayList();
  protected final boolean _topLevel;
  
  public Mustache$Accumulator(Mustache.Compiler paramCompiler, boolean paramBoolean)
  {
    this._comp = paramCompiler;
    this._topLevel = paramBoolean;
  }
  
  protected static void requireNoNewlines(String paramString, int paramInt)
  {
    if ((paramString.indexOf('\n') == -1) && (paramString.indexOf('\r') == -1)) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Invalid tag name: contains newline '");
    localStringBuilder.append(paramString);
    localStringBuilder.append("'");
    throw new MustacheParseException(localStringBuilder.toString(), paramInt);
  }
  
  protected static void requireSameName(String paramString1, String paramString2, int paramInt)
  {
    if (paramString1.equals(paramString2)) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Section close tag with mismatched open tag '");
    localStringBuilder.append(paramString2);
    localStringBuilder.append("' != '");
    localStringBuilder.append(paramString1);
    localStringBuilder.append("'");
    throw new MustacheParseException(localStringBuilder.toString(), paramInt);
  }
  
  protected Accumulator addCloseSectionSegment(String paramString, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Section close tag with no open tag '");
    localStringBuilder.append(paramString);
    localStringBuilder.append("'");
    throw new MustacheParseException(localStringBuilder.toString(), paramInt);
  }
  
  public void addFauxSegment()
  {
    this._segs.add(new Mustache.FauxSegment());
  }
  
  public Accumulator addTagSegment(StringBuilder paramStringBuilder, int paramInt)
  {
    String str1 = paramStringBuilder.toString().trim();
    String str2 = str1.substring(1).trim();
    paramStringBuilder.setLength(0);
    int i = str1.charAt(0);
    if (i != 33)
    {
      if (i != 35)
      {
        if (i != 38)
        {
          if (i != 47)
          {
            if (i != 62)
            {
              if (i != 94)
              {
                requireNoNewlines(str1, paramInt);
                this._segs.add(new Mustache.VariableSegment(str1, paramInt, this._comp.formatter, this._comp.escaper));
                return this;
              }
              requireNoNewlines(str1, paramInt);
              return new Mustache.Accumulator.2(this, this._comp, false, str2, paramInt, this);
            }
            this._segs.add(new Mustache.IncludedTemplateSegment(this._comp, str2));
            return this;
          }
          requireNoNewlines(str1, paramInt);
          return addCloseSectionSegment(str2, paramInt);
        }
        requireNoNewlines(str1, paramInt);
        this._segs.add(new Mustache.VariableSegment(str2, paramInt, this._comp.formatter, Escapers.NONE));
        return this;
      }
      requireNoNewlines(str1, paramInt);
      return new Mustache.Accumulator.1(this, this._comp, false, str2, paramInt, this);
    }
    this._segs.add(new Mustache.FauxSegment());
    return this;
  }
  
  public void addTextSegment(StringBuilder paramStringBuilder)
  {
    if (paramStringBuilder.length() > 0)
    {
      List localList = this._segs;
      String str = paramStringBuilder.toString();
      boolean bool;
      if ((this._segs.isEmpty()) && (this._topLevel)) {
        bool = true;
      } else {
        bool = false;
      }
      localList.add(new Mustache.StringSegment(str, bool));
      paramStringBuilder.setLength(0);
    }
  }
  
  public Template.Segment[] finish()
  {
    List localList = this._segs;
    return (Template.Segment[])localList.toArray(new Template.Segment[localList.size()]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.samskivert.mustache.Mustache.Accumulator
 * JD-Core Version:    0.7.0.1
 */