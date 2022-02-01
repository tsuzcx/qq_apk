package com.tencent.luggage.wxa.ql;

import com.tencent.qqmusic.mediaplayer.ISoLibraryLoader;

final class a$2
  implements ISoLibraryLoader
{
  public String findLibPath(String paramString)
  {
    if (a.c() != null) {
      return a.c().b(paramString);
    }
    return null;
  }
  
  public boolean load(String paramString)
  {
    if (a.c() != null) {
      return a.c().c(paramString);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ql.a.2
 * JD-Core Version:    0.7.0.1
 */