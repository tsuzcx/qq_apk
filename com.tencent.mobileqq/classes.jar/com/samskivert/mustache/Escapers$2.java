package com.samskivert.mustache;

final class Escapers$2
  implements Mustache.Escaper
{
  Escapers$2(String[][] paramArrayOfString) {}
  
  public String escape(String paramString)
  {
    String[][] arrayOfString = this.val$repls;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      String[] arrayOfString1 = arrayOfString[i];
      paramString = paramString.replace(arrayOfString1[0], arrayOfString1[1]);
      i += 1;
    }
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.samskivert.mustache.Escapers.2
 * JD-Core Version:    0.7.0.1
 */