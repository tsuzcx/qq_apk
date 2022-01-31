package com.tencent.image;

import java.net.URLStreamHandler;
import java.net.URLStreamHandlerFactory;

final class URLDrawable$1
  implements URLStreamHandlerFactory
{
  URLStreamHandler handler = new URLDrawable.1.1(this);
  
  public URLStreamHandler createURLStreamHandler(String paramString)
  {
    if (("http".equalsIgnoreCase(paramString)) || ("https".equalsIgnoreCase(paramString)) || ("file".equalsIgnoreCase(paramString))) {}
    while ("jar".equalsIgnoreCase(paramString)) {
      return null;
    }
    return this.handler;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.image.URLDrawable.1
 * JD-Core Version:    0.7.0.1
 */