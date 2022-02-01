package com.bumptech.glide.load.model;

final class LazyHeaders$StringHeaderFactory
  implements LazyHeaderFactory
{
  private final String a;
  
  LazyHeaders$StringHeaderFactory(String paramString)
  {
    this.a = paramString;
  }
  
  public String a()
  {
    return this.a;
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof StringHeaderFactory))
    {
      paramObject = (StringHeaderFactory)paramObject;
      return this.a.equals(paramObject.a);
    }
    return false;
  }
  
  public int hashCode()
  {
    return this.a.hashCode();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("StringHeaderFactory{value='");
    localStringBuilder.append(this.a);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.model.LazyHeaders.StringHeaderFactory
 * JD-Core Version:    0.7.0.1
 */