package com.samskivert.mustache;

import java.io.IOException;
import java.io.Reader;

public class Mustache$Parser
{
  Mustache.Accumulator accum;
  int column = 0;
  final Mustache.Delims delims;
  int line = 1;
  Reader source;
  int state = 0;
  int tagStartColumn = -1;
  final StringBuilder text = new StringBuilder();
  
  public Mustache$Parser(Mustache.Compiler paramCompiler)
  {
    this.accum = new Mustache.Accumulator(paramCompiler, true);
    this.delims = paramCompiler.delims.copy();
  }
  
  protected int nextChar()
  {
    try
    {
      int i = this.source.read();
      return i;
    }
    catch (IOException localIOException)
    {
      throw new MustacheException(localIOException);
    }
  }
  
  public Mustache.Accumulator parse(Reader paramReader)
  {
    this.source = paramReader;
    for (;;)
    {
      i = nextChar();
      if (i == -1) {
        break;
      }
      char c = (char)i;
      this.column += 1;
      parseChar(c);
      if (c == '\n')
      {
        this.column = 0;
        this.line += 1;
      }
    }
    int i = this.state;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i == 3) {
          Mustache.restoreStartTag(this.text, this.delims);
        }
      }
      else
      {
        Mustache.restoreStartTag(this.text, this.delims);
        this.text.append(this.delims.end1);
      }
    }
    else {
      this.text.append(this.delims.start1);
    }
    this.accum.addTextSegment(this.text);
    return this.accum;
  }
  
  protected void parseChar(char paramChar)
  {
    int i = this.state;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3) {
            return;
          }
          if (paramChar == this.delims.end1)
          {
            this.state = 2;
            if (this.delims.end2 == 0) {
              parseChar('\000');
            }
          }
          else
          {
            if ((paramChar == this.delims.start1) && (this.text.length() > 0) && (this.text.charAt(0) != '!'))
            {
              Mustache.restoreStartTag(this.text, this.delims);
              this.accum.addTextSegment(this.text);
              this.tagStartColumn = this.column;
              if (this.delims.start2 == 0)
              {
                this.accum.addTextSegment(this.text);
                this.state = 3;
                return;
              }
              this.state = 1;
              return;
            }
            this.text.append(paramChar);
          }
        }
        else
        {
          if (paramChar == this.delims.end2)
          {
            Object localObject;
            StringBuilder localStringBuilder;
            if (this.text.charAt(0) == '=')
            {
              localObject = this.delims;
              localStringBuilder = this.text;
              ((Mustache.Delims)localObject).updateDelims(localStringBuilder.substring(1, localStringBuilder.length() - 1));
              this.text.setLength(0);
              this.accum.addFauxSegment();
            }
            else
            {
              if ((this.delims.isStaches()) && (this.text.charAt(0) == this.delims.start1))
              {
                i = nextChar();
                if (i != 125)
                {
                  if (i == -1) {
                    localObject = "";
                  } else {
                    localObject = String.valueOf((char)i);
                  }
                  localStringBuilder = new StringBuilder();
                  localStringBuilder.append("Invalid triple-mustache tag: {{");
                  localStringBuilder.append(this.text);
                  localStringBuilder.append("}}");
                  localStringBuilder.append((String)localObject);
                  throw new MustacheParseException(localStringBuilder.toString(), this.line);
                }
                this.text.replace(0, 1, "&");
              }
              this.accum = this.accum.addTagSegment(this.text, this.line);
            }
            this.state = 0;
            return;
          }
          this.text.append(this.delims.end1);
          this.state = 3;
          parseChar(paramChar);
        }
      }
      else
      {
        if (paramChar == this.delims.start2)
        {
          this.accum.addTextSegment(this.text);
          this.state = 3;
          return;
        }
        this.text.append(this.delims.start1);
        this.state = 0;
        parseChar(paramChar);
      }
    }
    else if (paramChar == this.delims.start1)
    {
      this.state = 1;
      this.tagStartColumn = this.column;
      if (this.delims.start2 == 0) {
        parseChar('\000');
      }
    }
    else
    {
      this.text.append(paramChar);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.samskivert.mustache.Mustache.Parser
 * JD-Core Version:    0.7.0.1
 */