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
import java.util.ArrayList;
import java.util.Arrays;
import mqq.app.AppRuntime;

public class ArkAiDictMgr
{
  private static volatile boolean a = false;
  private static String b;
  
  public static WordSegmentResult a(AppRuntime paramAppRuntime, String paramString)
  {
    WordSegmentResult localWordSegmentResult = new WordSegmentResult();
    localWordSegmentResult.b = paramString;
    ArkRecommendLogic.b().a(new ArkAiDictMgr.3(paramAppRuntime, localWordSegmentResult, paramString));
    return localWordSegmentResult;
  }
  
  static String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(ArkAppEnvConfig.a().d());
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
    if (b())
    {
      QLog.i("ArkDict.DictMgr", 1, "initWordData, already inited.");
      return;
    }
    new File(a()).mkdirs();
    if (!a) {
      ArkRecommendLogic.b().a(new ArkAiDictMgr.1());
    }
    b(paramAppRuntime);
  }
  
  static String[] a(String paramString, int paramInt)
  {
    if (paramString.length() < paramInt) {
      return WordSegment.segment(paramString);
    }
    ArrayList localArrayList = new ArrayList();
    StringSplitter localStringSplitter = new StringSplitter(paramString);
    for (paramString = localStringSplitter.a(paramInt); !TextUtils.isEmpty(paramString); paramString = localStringSplitter.a(paramInt))
    {
      paramString = WordSegment.segment(paramString);
      if (paramString != null) {
        localArrayList.addAll(Arrays.asList(paramString));
      }
    }
    return (String[])localArrayList.toArray(new String[0]);
  }
  
  public static void b(AppRuntime paramAppRuntime)
  {
    if (!a)
    {
      QLog.i("ArkDict.DictMgr", 1, "reloadWordData, sIsSoLoaded is false");
      return;
    }
    ArkRecommendLogic.a().post(new ArkAiDictMgr.4(paramAppRuntime));
  }
  
  public static boolean b()
  {
    return (a) && (!TextUtils.isEmpty(b));
  }
  
  private static boolean d(AppRuntime paramAppRuntime)
  {
    if (paramAppRuntime == null) {
      return true;
    }
    paramAppRuntime = (ArkAIDictConfBean)ArkConfProcessor.a(ArkAIDictConfBean.class);
    if ((paramAppRuntime != null) && (paramAppRuntime.b() != null))
    {
      paramAppRuntime = paramAppRuntime.b().d;
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
  
  private static void g()
  {
    try
    {
      if ((Environment.a) && (!a))
      {
        a = NativeLibLoader.c(BaseApplication.getContext(), "WordSegment");
        QLog.i("ArkDict.DictMgr", 1, String.format("loadWordSegmentSo, result=%s", new Object[] { Boolean.toString(a) }));
        if (a) {
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
  
  public void c()
  {
    if (!a)
    {
      QLog.i("ArkDict.DictMgr", 1, "loadTestDict, sIsSoLoaded is false");
      return;
    }
    ArkRecommendLogic.a().post(new ArkAiDictMgr.5(this));
  }
  
  public void d()
  {
    QLog.i("ArkDict.DictMgr", 1, "clearDict");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.dict.ArkAiDictMgr
 * JD-Core Version:    0.7.0.1
 */