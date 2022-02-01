package com.samskivert.mustache;

import java.io.Writer;

public class Mustache$VariableSegment
  extends Mustache.NamedSegment
{
  protected final Mustache.Escaper _escaper;
  protected final Mustache.Formatter _formatter;
  
  public Mustache$VariableSegment(String paramString, int paramInt, Mustache.Formatter paramFormatter, Mustache.Escaper paramEscaper)
  {
    super(paramString, paramInt);
    this._formatter = paramFormatter;
    this._escaper = paramEscaper;
  }
  
  public void decompile(Mustache.Delims paramDelims, StringBuilder paramStringBuilder)
  {
    paramDelims.addTag(' ', this._name, paramStringBuilder);
  }
  
  public void execute(Template paramTemplate, Template.Context paramContext, Writer paramWriter)
  {
    paramTemplate = paramTemplate.getValueOrDefault(paramContext, this._name, this._line);
    if (paramTemplate == null)
    {
      if (Template.isThisName(this._name)) {}
      for (paramTemplate = "Resolved '.' to null (which is disallowed), on line " + this._line;; paramTemplate = "No key, method or field with name '" + this._name + "' on line " + this._line) {
        throw new MustacheException.Context(paramTemplate, this._name, this._line);
      }
    }
    write(paramWriter, this._escaper.escape(this._formatter.format(paramTemplate)));
  }
  
  public String toString()
  {
    return "Var(" + this._name + ":" + this._line + ")";
  }
  
  public void visit(Mustache.Visitor paramVisitor)
  {
    paramVisitor.visitVariable(this._name);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.samskivert.mustache.Mustache.VariableSegment
 * JD-Core Version:    0.7.0.1
 */