package com.tencent.biz.qcircleshadow.local;

import com.tencent.shadow.core.common.ILoggerFactory;
import com.tencent.shadow.core.common.Logger;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class QCircleLoggerFactory
  implements ILoggerFactory
{
  private static QCircleLoggerFactory jdField_a_of_type_ComTencentBizQcircleshadowLocalQCircleLoggerFactory = new QCircleLoggerFactory();
  private final ConcurrentMap<String, Logger> jdField_a_of_type_JavaUtilConcurrentConcurrentMap = new ConcurrentHashMap();
  
  public static ILoggerFactory a()
  {
    return jdField_a_of_type_ComTencentBizQcircleshadowLocalQCircleLoggerFactory;
  }
  
  public Logger getLogger(String paramString)
  {
    Object localObject = (Logger)this.jdField_a_of_type_JavaUtilConcurrentConcurrentMap.get(paramString);
    if (localObject != null) {
      return localObject;
    }
    localObject = new QCircleLoggerFactory.IVLogger(this, paramString);
    Logger localLogger = (Logger)this.jdField_a_of_type_JavaUtilConcurrentConcurrentMap.putIfAbsent(paramString, localObject);
    paramString = localLogger;
    if (localLogger == null) {
      paramString = (String)localObject;
    }
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qcircleshadow.local.QCircleLoggerFactory
 * JD-Core Version:    0.7.0.1
 */