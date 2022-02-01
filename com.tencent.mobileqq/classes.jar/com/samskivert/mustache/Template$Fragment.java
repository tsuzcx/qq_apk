package com.samskivert.mustache;

import java.io.StringWriter;
import java.io.Writer;

public abstract class Template$Fragment
{
  public Template$Fragment(Template paramTemplate) {}
  
  public abstract Object context();
  
  public abstract Object context(int paramInt);
  
  public String decompile()
  {
    return decompile(new StringBuilder()).toString();
  }
  
  public abstract StringBuilder decompile(StringBuilder paramStringBuilder);
  
  public String execute()
  {
    StringWriter localStringWriter = new StringWriter();
    execute(localStringWriter);
    return localStringWriter.toString();
  }
  
  public String execute(Object paramObject)
  {
    StringWriter localStringWriter = new StringWriter();
    execute(paramObject, localStringWriter);
    return localStringWriter.toString();
  }
  
  public abstract void execute(Writer paramWriter);
  
  public abstract void execute(Object paramObject, Writer paramWriter);
  
  public abstract void executeTemplate(Template paramTemplate, Writer paramWriter);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.samskivert.mustache.Template.Fragment
 * JD-Core Version:    0.7.0.1
 */