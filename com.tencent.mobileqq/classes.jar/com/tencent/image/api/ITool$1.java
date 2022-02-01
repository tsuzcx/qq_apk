package com.tencent.image.api;

import java.net.URLStreamHandler;
import java.net.URLStreamHandlerFactory;

class ITool$1
  implements URLStreamHandlerFactory
{
  URLStreamHandler handler = new ITool.1.1(this);
  
  ITool$1(ITool paramITool) {}
  
  public URLStreamHandler createURLStreamHandler(String paramString)
  {
    if ((!"http".equalsIgnoreCase(paramString)) && (!"https".equalsIgnoreCase(paramString)))
    {
      if ("file".equalsIgnoreCase(paramString)) {
        return null;
      }
      if ("jar".equalsIgnoreCase(paramString)) {
        return null;
      }
      return this.handler;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.image.api.ITool.1
 * JD-Core Version:    0.7.0.1
 */