package com.samskivert.mustache;

import java.io.Writer;

public class Mustache$StringSegment
  extends Template.Segment
{
  protected final int _leadBlank;
  protected final String _text;
  protected final int _trailBlank;
  
  public Mustache$StringSegment(String paramString, int paramInt1, int paramInt2)
  {
    this._text = paramString;
    this._leadBlank = paramInt1;
    this._trailBlank = paramInt2;
  }
  
  public Mustache$StringSegment(String paramString, boolean paramBoolean)
  {
    this(paramString, blankPos(paramString, true, paramBoolean), blankPos(paramString, false, paramBoolean));
  }
  
  private static int blankPos(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    int j = paramString.length();
    int m = 0;
    int i;
    if (paramBoolean1) {
      i = 0;
    } else {
      i = j - 1;
    }
    if (!paramBoolean1) {
      j = -1;
    }
    int k;
    if (paramBoolean1) {
      k = 1;
    } else {
      k = -1;
    }
    while (i != j)
    {
      char c = paramString.charAt(i);
      if (c == '\n')
      {
        if (paramBoolean1) {
          return i;
        }
        return i + 1;
      }
      if (!Character.isWhitespace(c)) {
        return -1;
      }
      i += k;
    }
    if (!paramBoolean1)
    {
      i = m;
      if (paramBoolean2) {}
    }
    else
    {
      i = -1;
    }
    return i;
  }
  
  public void decompile(Mustache.Delims paramDelims, StringBuilder paramStringBuilder)
  {
    paramStringBuilder.append(this._text);
  }
  
  public void execute(Template paramTemplate, Template.Context paramContext, Writer paramWriter)
  {
    write(paramWriter, this._text);
  }
  
  public boolean leadsBlank()
  {
    return this._leadBlank != -1;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Text(");
    localStringBuilder.append(this._text.replace("\r", "\\r").replace("\n", "\\n"));
    localStringBuilder.append(")");
    localStringBuilder.append(this._leadBlank);
    localStringBuilder.append("/");
    localStringBuilder.append(this._trailBlank);
    return localStringBuilder.toString();
  }
  
  public boolean trailsBlank()
  {
    return this._trailBlank != -1;
  }
  
  public StringSegment trimLeadBlank()
  {
    int i = this._leadBlank;
    if (i == -1) {
      return this;
    }
    int j = i + 1;
    i = this._trailBlank;
    if (i == -1) {
      i = -1;
    } else {
      i -= j;
    }
    return new StringSegment(this._text.substring(j), -1, i);
  }
  
  public StringSegment trimTrailBlank()
  {
    int i = this._trailBlank;
    if (i == -1) {
      return this;
    }
    return new StringSegment(this._text.substring(0, i), this._leadBlank, -1);
  }
  
  public void visit(Mustache.Visitor paramVisitor)
  {
    paramVisitor.visitText(this._text);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.samskivert.mustache.Mustache.StringSegment
 * JD-Core Version:    0.7.0.1
 */