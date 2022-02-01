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
      int i = nextChar();
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
    switch (this.state)
    {
    }
    for (;;)
    {
      this.accum.addTextSegment(this.text);
      return this.accum;
      Mustache.restoreStartTag(this.text, this.delims);
      continue;
      Mustache.restoreStartTag(this.text, this.delims);
      this.text.append(this.delims.end1);
      continue;
      this.text.append(this.delims.start1);
    }
  }
  
  protected void parseChar(char paramChar)
  {
    switch (this.state)
    {
    default: 
    case 0: 
    case 1: 
    case 3: 
      do
      {
        do
        {
          return;
          if (paramChar != this.delims.start1) {
            break;
          }
          this.state = 1;
          this.tagStartColumn = this.column;
        } while (this.delims.start2 != 0);
        parseChar('\000');
        return;
        this.text.append(paramChar);
        return;
        if (paramChar == this.delims.start2)
        {
          this.accum.addTextSegment(this.text);
          this.state = 3;
          return;
        }
        this.text.append(this.delims.start1);
        this.state = 0;
        parseChar(paramChar);
        return;
        if (paramChar != this.delims.end1) {
          break;
        }
        this.state = 2;
      } while (this.delims.end2 != 0);
      parseChar('\000');
      return;
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
      return;
    }
    if (paramChar == this.delims.end2)
    {
      if (this.text.charAt(0) == '=')
      {
        this.delims.updateDelims(this.text.substring(1, this.text.length() - 1));
        this.text.setLength(0);
        this.accum.addFauxSegment();
      }
      for (;;)
      {
        this.state = 0;
        return;
        if ((this.delims.isStaches()) && (this.text.charAt(0) == this.delims.start1))
        {
          int i = nextChar();
          if (i != 125)
          {
            if (i == -1) {}
            for (String str = "";; str = String.valueOf((char)i)) {
              throw new MustacheParseException("Invalid triple-mustache tag: {{" + this.text + "}}" + str, this.line);
            }
          }
          this.text.replace(0, 1, "&");
        }
        this.accum = this.accum.addTagSegment(this.text, this.line);
      }
    }
    this.text.append(this.delims.end1);
    this.state = 3;
    parseChar(paramChar);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.samskivert.mustache.Mustache.Parser
 * JD-Core Version:    0.7.0.1
 */