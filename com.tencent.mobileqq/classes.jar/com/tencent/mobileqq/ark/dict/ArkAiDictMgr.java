package com.tencent.mobileqq.ark.dict;

import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.ark.config.bean.ArkAIDictConfBean;
import com.tencent.mobileqq.ark.config.processor.ArkConfProcessor;
import com.tencent.mobileqq.ark.env.ArkAppEnvConfig;
import com.tencent.mobileqq.ark.env.Environment;
import com.tencent.mobileqq.ark.util.NativeLibLoader;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.wordsegment.WordSegment;
import java.io.File;
import mqq.app.AppRuntime;

public class ArkAiDictMgr
{
  private static String jdField_a_of_type_JavaLangString;
  private static volatile boolean jdField_a_of_type_Boolean = false;
  
  public static WordSegmentResult a(AppRuntime paramAppRuntime, String paramString)
  {
    WordSegmentResult localWordSegmentResult = new WordSegmentResult();
    localWordSegmentResult.jdField_a_of_type_JavaLangString = paramString;
    ArkRecommendLogic.a().a(new ArkAiDictMgr.3(paramAppRuntime, localWordSegmentResult, paramString));
    return localWordSegmentResult;
  }
  
  static String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(ArkAppEnvConfig.a().b());
    localStringBuilder.append("/WordData/");
    return localStringBuilder.toString();
  }
  
  static String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(a());
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  public static void a(AppRuntime paramAppRuntime)
  {
    if (a())
    {
      QLog.i("ArkDict.DictMgr", 1, "initWordData, already inited.");
      return;
    }
    new File(a()).mkdirs();
    if (!jdField_a_of_type_Boolean) {
      ArkRecommendLogic.a().a(new ArkAiDictMgr.1());
    }
    b(paramAppRuntime);
  }
  
  public static boolean a()
  {
    return (jdField_a_of_type_Boolean) && (!TextUtils.isEmpty(jdField_a_of_type_JavaLangString));
  }
  
  public static void b(AppRuntime paramAppRuntime)
  {
    if (!jdField_a_of_type_Boolean)
    {
      QLog.i("ArkDict.DictMgr", 1, "reloadWordData, sIsSoLoaded is false");
      return;
    }
    ArkRecommendLogic.a().post(new ArkAiDictMgr.4(paramAppRuntime));
  }
  
  private static boolean b(AppRuntime paramAppRuntime)
  {
    if (paramAppRuntime == null) {
      return true;
    }
    paramAppRuntime = (ArkAIDictConfBean)ArkConfProcessor.a(ArkAIDictConfBean.class);
    if ((paramAppRuntime != null) && (paramAppRuntime.a() != null))
    {
      paramAppRuntime = paramAppRuntime.a().d;
      if (paramAppRuntime != null)
      {
        QLog.i("ArkDict.DictMgr", 1, String.format("getWordInitState, wordInitState=%s", new Object[] { paramAppRuntime }));
        return paramAppRuntime.equals("false") ^ true;
      }
      QLog.i("ArkDict.DictMgr", 1, "getWordInitState, ark_dict_init is empty");
      return true;
    }
    QLog.i("ArkDict.DictMgr", 1, "getWordInitState, confBean is empty");
    return true;
  }
  
  private static void d()
  {
    try
    {
      if ((Environment.jdField_a_of_type_Boolean) && (!jdField_a_of_type_Boolean))
      {
        jdField_a_of_type_Boolean = NativeLibLoader.c(BaseApplication.getContext(), "WordSegment");
        QLog.i("ArkDict.DictMgr", 1, String.format("loadWordSegmentSo, result=%s", new Object[] { Boolean.toString(jdField_a_of_type_Boolean) }));
        if (jdField_a_of_type_Boolean) {
          WordSegment.setLogCallback(new ArkAiDictMgr.2());
        }
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void a()
  {
    if (!jdField_a_of_type_Boolean)
    {
      QLog.i("ArkDict.DictMgr", 1, "loadTestDict, sIsSoLoaded is false");
      return;
    }
    ArkRecommendLogic.a().post(new ArkAiDictMgr.5(this));
  }
  
  public void b()
  {
    QLog.i("ArkDict.DictMgr", 1, "clearDict");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ark.dict.ArkAiDictMgr
 * JD-Core Version:    0.7.0.1
 */