package com.samskivert.mustache;

public class Mustache$Delims
{
  public char end1 = '}';
  public char end2 = '}';
  public char start1 = '{';
  public char start2 = '{';
  
  private static String errmsg(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Invalid delimiter configuration '");
    localStringBuilder.append(paramString);
    localStringBuilder.append("'. Must be of the form {{=1 2=}} or {{=12 34=}} where 1, 2, 3 and 4 are delimiter chars.");
    return localStringBuilder.toString();
  }
  
  public void addTag(char paramChar, String paramString, StringBuilder paramStringBuilder)
  {
    paramStringBuilder.append(this.start1);
    paramStringBuilder.append(this.start2);
    if (paramChar != ' ') {
      paramStringBuilder.append(paramChar);
    }
    paramStringBuilder.append(paramString);
    paramStringBuilder.append(this.end1);
    paramStringBuilder.append(this.end2);
  }
  
  Delims copy()
  {
    Delims localDelims = new Delims();
    localDelims.start1 = this.start1;
    localDelims.start2 = this.start2;
    localDelims.end1 = this.end1;
    localDelims.end2 = this.end2;
    return localDelims;
  }
  
  public boolean isStaches()
  {
    return (this.start1 == '{') && (this.start2 == '{') && (this.end1 == '}') && (this.end2 == '}');
  }
  
  public Delims updateDelims(String paramString)
  {
    String[] arrayOfString = paramString.split(" ");
    if (arrayOfString.length == 2)
    {
      int i = arrayOfString[0].length();
      if (i != 1)
      {
        if (i == 2)
        {
          this.start1 = arrayOfString[0].charAt(0);
          this.start2 = arrayOfString[0].charAt(1);
        }
        else
        {
          throw new MustacheException(errmsg(paramString));
        }
      }
      else
      {
        this.start1 = arrayOfString[0].charAt(0);
        this.start2 = '\000';
      }
      i = arrayOfString[1].length();
      if (i != 1)
      {
        if (i == 2)
        {
          this.end1 = arrayOfString[1].charAt(0);
          this.end2 = arrayOfString[1].charAt(1);
          return this;
        }
        throw new MustacheException(errmsg(paramString));
      }
      this.end1 = arrayOfString[1].charAt(0);
      this.end2 = '\000';
      return this;
    }
    throw new MustacheException(errmsg(paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.samskivert.mustache.Mustache.Delims
 * JD-Core Version:    0.7.0.1
 */