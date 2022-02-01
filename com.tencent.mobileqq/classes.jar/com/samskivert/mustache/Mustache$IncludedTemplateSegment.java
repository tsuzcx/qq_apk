package com.samskivert.mustache;

import java.io.Writer;

public class Mustache$IncludedTemplateSegment
  extends Template.Segment
{
  protected final Mustache.Compiler _comp;
  protected final String _name;
  private Template _template;
  
  public Mustache$IncludedTemplateSegment(Mustache.Compiler paramCompiler, String paramString)
  {
    this._comp = paramCompiler;
    this._name = paramString;
  }
  
  public void decompile(Mustache.Delims paramDelims, StringBuilder paramStringBuilder)
  {
    paramDelims.addTag('>', this._name, paramStringBuilder);
  }
  
  public void execute(Template paramTemplate, Template.Context paramContext, Writer paramWriter)
  {
    getTemplate().executeSegs(paramContext, paramWriter);
  }
  
  protected Template getTemplate()
  {
    if (this._template == null) {
      this._template = this._comp.loadTemplate(this._name);
    }
    return this._template;
  }
  
  public void visit(Mustache.Visitor paramVisitor)
  {
    if (paramVisitor.visitInclude(this._name)) {
      getTemplate().visit(paramVisitor);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.samskivert.mustache.Mustache.IncludedTemplateSegment
 * JD-Core Version:    0.7.0.1
 */