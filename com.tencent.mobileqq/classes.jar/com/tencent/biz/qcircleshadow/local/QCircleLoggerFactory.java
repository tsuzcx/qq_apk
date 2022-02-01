package com.tencent.biz.qcircleshadow.local;

import com.tencent.shadow.core.common.ILoggerFactory;
import com.tencent.shadow.core.common.Logger;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class QCircleLoggerFactory
  implements ILoggerFactory
{
  private static QCircleLoggerFactory a = new QCircleLoggerFactory();
  private final ConcurrentMap<String, Logger> b = new ConcurrentHashMap();
  
  public Logger getLogger(String paramString)
  {
    Object localObject = (Logger)this.b.get(paramString);
    if (localObject != null) {
      return localObject;
    }
    localObject = new QCircleLoggerFactory.IVLogger(this, paramString);
    Logger localLogger = (Logger)this.b.putIfAbsent(paramString, localObject);
    paramString = localLogger;
    if (localLogger == null) {
      paramString = (String)localObject;
    }
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qcircleshadow.local.QCircleLoggerFactory
 * JD-Core Version:    0.7.0.1
 */