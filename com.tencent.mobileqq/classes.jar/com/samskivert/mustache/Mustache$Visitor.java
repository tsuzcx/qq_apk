package com.samskivert.mustache;

public abstract interface Mustache$Visitor
{
  public abstract boolean visitInclude(String paramString);
  
  public abstract boolean visitInvertedSection(String paramString);
  
  public abstract boolean visitSection(String paramString);
  
  public abstract void visitText(String paramString);
  
  public abstract void visitVariable(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.samskivert.mustache.Mustache.Visitor
 * JD-Core Version:    0.7.0.1
 */