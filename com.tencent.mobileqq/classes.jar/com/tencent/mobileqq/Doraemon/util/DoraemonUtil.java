package com.tencent.mobileqq.Doraemon.util;

import com.tencent.mobileqq.Doraemon.APICallback;
import com.tencent.mobileqq.Doraemon.APIParam;
import com.tencent.mobileqq.app.ThreadManager;
import java.io.Serializable;
import mqq.os.MqqHandler;
import rcm;
import rcn;
import rco;

public class DoraemonUtil
{
  public static Serializable a(APIParam paramAPIParam, String paramString, Serializable paramSerializable)
  {
    if (paramAPIParam == null) {}
    do
    {
      return paramSerializable;
      paramAPIParam = (Serializable)paramAPIParam.get(paramString);
    } while (paramAPIParam == null);
    return paramAPIParam;
  }
  
  public static Number a(APIParam paramAPIParam, String paramString, Number paramNumber)
  {
    return (Number)a(paramAPIParam, paramString, paramNumber);
  }
  
  public static void a(APICallback paramAPICallback, int paramInt)
  {
    ThreadManager.getUIHandler().post(new rco(paramAPICallback, paramInt));
  }
  
  public static void a(APICallback paramAPICallback, int paramInt, String paramString)
  {
    ThreadManager.getUIHandler().post(new rcn(paramAPICallback, paramInt, paramString));
  }
  
  public static void a(APICallback paramAPICallback, APIParam paramAPIParam)
  {
    ThreadManager.getUIHandler().post(new rcm(paramAPICallback, paramAPIParam));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\com33.jar
 * Qualified Name:     com.tencent.mobileqq.Doraemon.util.DoraemonUtil
 * JD-Core Version:    0.7.0.1
 */