package com.samskivert.mustache;

public class Template$Key
{
  public final Class<?> cclass;
  public final String name;
  
  public Template$Key(Class<?> paramClass, String paramString)
  {
    this.cclass = paramClass;
    this.name = paramString;
  }
  
  public boolean equals(Object paramObject)
  {
    paramObject = (Key)paramObject;
    return (paramObject.cclass == this.cclass) && (paramObject.name.equals(this.name));
  }
  
  public int hashCode()
  {
    return this.cclass.hashCode() * 31 + this.name.hashCode();
  }
  
  public String toString()
  {
    return this.cclass.getName() + ":" + this.name;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.samskivert.mustache.Template.Key
 * JD-Core Version:    0.7.0.1
 */