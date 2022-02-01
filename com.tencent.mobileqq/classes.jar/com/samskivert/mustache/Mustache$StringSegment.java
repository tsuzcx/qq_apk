package com.samskivert.mustache;

import java.io.Writer;

public class Mustache$StringSegment
  extends Template.Segment
{
  protected final int _leadBlank;
  protected final String _text;
  protected final int _trailBlank;
  
  static
  {
    if (!Mustache.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public Mustache$StringSegment(String paramString, int paramInt1, int paramInt2)
  {
    assert (paramInt1 >= -1);
    assert (paramInt2 >= -1);
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
    int n = -1;
    int j = paramString.length();
    int i;
    label20:
    int k;
    label27:
    char c;
    label51:
    int m;
    if (paramBoolean1)
    {
      i = 0;
      if (!paramBoolean1) {
        break label67;
      }
      if (!paramBoolean1) {
        break label73;
      }
      k = 1;
      if (i == j) {
        break label109;
      }
      c = paramString.charAt(i);
      if (c != '\n') {
        break label88;
      }
      if (!paramBoolean1) {
        break label79;
      }
      m = i;
    }
    label67:
    label73:
    label79:
    label88:
    label109:
    do
    {
      do
      {
        do
        {
          return m;
          i = j - 1;
          break;
          j = -1;
          break label20;
          k = -1;
          break label27;
          i += 1;
          break label51;
          m = n;
        } while (!Character.isWhitespace(c));
        i += k;
        break label27;
        m = n;
      } while (paramBoolean1);
      m = n;
    } while (!paramBoolean2);
    return 0;
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
    return "Text(" + this._text.replace("\r", "\\r").replace("\n", "\\n") + ")" + this._leadBlank + "/" + this._trailBlank;
  }
  
  public boolean trailsBlank()
  {
    return this._trailBlank != -1;
  }
  
  public StringSegment trimLeadBlank()
  {
    if (this._leadBlank == -1) {
      return this;
    }
    int j = this._leadBlank + 1;
    if (this._trailBlank == -1) {}
    for (int i = -1;; i = this._trailBlank - j) {
      return new StringSegment(this._text.substring(j), -1, i);
    }
  }
  
  public StringSegment trimTrailBlank()
  {
    if (this._trailBlank == -1) {
      return this;
    }
    return new StringSegment(this._text.substring(0, this._trailBlank), this._leadBlank, -1);
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