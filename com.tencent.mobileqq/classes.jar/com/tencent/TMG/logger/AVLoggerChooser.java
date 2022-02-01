package com.tencent.TMG.logger;

public class AVLoggerChooser
{
  private static Logger sLogger;
  private static boolean sUseImsdk = true;
  
  public static Logger getLogger()
  {
    try
    {
      Object localObject1;
      if (sLogger != null)
      {
        localObject1 = sLogger;
        return localObject1;
      }
      boolean bool = sUseImsdk;
      if (bool)
      {
        Object localObject5 = null;
        Logger localLogger;
        try
        {
          localObject1 = Class.forName("com.tencent.TMG.logger.IMLogger");
        }
        catch (ClassNotFoundException localClassNotFoundException)
        {
          localClassNotFoundException.printStackTrace();
          localLogger = null;
        }
        if (localLogger == null) {
          return null;
        }
        try
        {
          localLogger = (Logger)localLogger.newInstance();
        }
        catch (IllegalAccessException localIllegalAccessException)
        {
          localIllegalAccessException.printStackTrace();
          Object localObject2 = localObject5;
        }
        catch (InstantiationException localInstantiationException)
        {
          localInstantiationException.printStackTrace();
          localObject3 = localObject5;
        }
        sLogger = (Logger)localObject3;
      }
      Object localObject3 = sLogger;
      return localObject3;
    }
    finally {}
  }
  
  public static void setLoger(Logger paramLogger)
  {
    try
    {
      sLogger = paramLogger;
      return;
    }
    finally
    {
      paramLogger = finally;
      throw paramLogger;
    }
  }
  
  public static void setUseImsdk(boolean paramBoolean)
  {
    try
    {
      sUseImsdk = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.TMG.logger.AVLoggerChooser
 * JD-Core Version:    0.7.0.1
 */