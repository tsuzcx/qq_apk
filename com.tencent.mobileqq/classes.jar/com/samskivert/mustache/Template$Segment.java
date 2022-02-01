package com.samskivert.mustache;

import java.io.IOException;
import java.io.Writer;

public abstract class Template$Segment
{
  protected static void write(Writer paramWriter, String paramString)
  {
    try
    {
      paramWriter.write(paramString);
      return;
    }
    catch (IOException paramWriter)
    {
      throw new MustacheException(paramWriter);
    }
  }
  
  abstract void decompile(Mustache.Delims paramDelims, StringBuilder paramStringBuilder);
  
  abstract void execute(Template paramTemplate, Template.Context paramContext, Writer paramWriter);
  
  abstract void visit(Mustache.Visitor paramVisitor);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.samskivert.mustache.Template.Segment
 * JD-Core Version:    0.7.0.1
 */