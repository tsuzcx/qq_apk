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
    if ((paramString.indexOf('\n') != -1) || (paramString.indexOf('\r') != -1)) {
      throw new MustacheParseException("Invalid tag name: contains newline '" + paramString + "'", paramInt);
    }
  }
  
  protected static void requireSameName(String paramString1, String paramString2, int paramInt)
  {
    if (!paramString1.equals(paramString2)) {
      throw new MustacheParseException("Section close tag with mismatched open tag '" + paramString2 + "' != '" + paramString1 + "'", paramInt);
    }
  }
  
  protected Accumulator addCloseSectionSegment(String paramString, int paramInt)
  {
    throw new MustacheParseException("Section close tag with no open tag '" + paramString + "'", paramInt);
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
    switch (str1.charAt(0))
    {
    default: 
      requireNoNewlines(str1, paramInt);
      this._segs.add(new Mustache.VariableSegment(str1, paramInt, this._comp.formatter, this._comp.escaper));
      return this;
    case '#': 
      requireNoNewlines(str1, paramInt);
      return new Mustache.Accumulator.1(this, this._comp, false, str2, paramInt, this);
    case '>': 
      this._segs.add(new Mustache.IncludedTemplateSegment(this._comp, str2));
      return this;
    case '^': 
      requireNoNewlines(str1, paramInt);
      return new Mustache.Accumulator.2(this, this._comp, false, str2, paramInt, this);
    case '/': 
      requireNoNewlines(str1, paramInt);
      return addCloseSectionSegment(str2, paramInt);
    case '!': 
      this._segs.add(new Mustache.FauxSegment());
      return this;
    }
    requireNoNewlines(str1, paramInt);
    this._segs.add(new Mustache.VariableSegment(str2, paramInt, this._comp.formatter, Escapers.NONE));
    return this;
  }
  
  public void addTextSegment(StringBuilder paramStringBuilder)
  {
    List localList;
    String str;
    if (paramStringBuilder.length() > 0)
    {
      localList = this._segs;
      str = paramStringBuilder.toString();
      if ((!this._segs.isEmpty()) || (!this._topLevel)) {
        break label62;
      }
    }
    label62:
    for (boolean bool = true;; bool = false)
    {
      localList.add(new Mustache.StringSegment(str, bool));
      paramStringBuilder.setLength(0);
      return;
    }
  }
  
  public Template.Segment[] finish()
  {
    return (Template.Segment[])this._segs.toArray(new Template.Segment[this._segs.size()]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.samskivert.mustache.Mustache.Accumulator
 * JD-Core Version:    0.7.0.1
 */