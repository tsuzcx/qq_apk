package com.tencent.mobileqq.ark;

import android.os.Handler;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.config.business.ArkConfBean;
import com.tencent.mobileqq.config.business.ArkConfBean.ArkAIDictConfBean;
import com.tencent.mobileqq.config.business.ArkConfProcessor;
import com.tencent.mobileqq.config.business.ArkManageConfig.AIDictConfig;
import com.tencent.mobileqq.startup.step.UpdateArkSo;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.wordsegment.WordSegment;
import java.io.File;

public class ArkAiDictMgr
{
  private static String jdField_a_of_type_JavaLangString = null;
  private static volatile boolean jdField_a_of_type_Boolean = false;
  private java.lang.ref.WeakReference<AppInterface> jdField_a_of_type_JavaLangRefWeakReference;
  
  public ArkAiDictMgr(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new mqq.util.WeakReference(paramAppInterface);
  }
  
  public static ArkAiDictMgr.WordSegmentResult a(AppInterface paramAppInterface, String paramString)
  {
    ArkAiDictMgr.WordSegmentResult localWordSegmentResult = new ArkAiDictMgr.WordSegmentResult();
    localWordSegmentResult.jdField_a_of_type_JavaLangString = paramString;
    ArkRecommendLogic.a().a(new ArkAiDictMgr.3(paramAppInterface, localWordSegmentResult, paramString));
    return localWordSegmentResult;
  }
  
  static String a()
  {
    return ArkAppCenter.b() + "/WordData/";
  }
  
  static String a(String paramString)
  {
    return a() + paramString;
  }
  
  public static void a()
  {
    Object localObject = new File(a());
    if (((File)localObject).isFile()) {
      ((File)localObject).delete();
    }
    for (;;)
    {
      return;
      localObject = ((File)localObject).listFiles();
      if (localObject != null)
      {
        int j = localObject.length;
        int i = 0;
        while (i < j)
        {
          localObject[i].delete();
          i += 1;
        }
      }
    }
  }
  
  public static void a(AppInterface paramAppInterface)
  {
    if (a())
    {
      ArkAppCenter.c("ArkApp.Dict", "initWordData, already inited.");
      return;
    }
    new File(a()).mkdirs();
    if (!jdField_a_of_type_Boolean) {
      ArkRecommendLogic.a().a(new ArkAiDictMgr.1());
    }
    b(paramAppInterface);
  }
  
  public static boolean a()
  {
    return (jdField_a_of_type_Boolean) && (!TextUtils.isEmpty(jdField_a_of_type_JavaLangString));
  }
  
  static void b(AppInterface paramAppInterface)
  {
    if (!jdField_a_of_type_Boolean)
    {
      ArkAppCenter.c("ArkApp.Dict", "reloadWordData, sIsSoLoaded is false");
      return;
    }
    ArkRecommendLogic.a().post(new ArkAiDictMgr.4(paramAppInterface));
  }
  
  private static boolean b(AppInterface paramAppInterface)
  {
    if (paramAppInterface == null) {}
    do
    {
      return true;
      paramAppInterface = ArkConfProcessor.b(170).a();
      if ((paramAppInterface == null) || (paramAppInterface.a() == null))
      {
        ArkAppCenter.c("ArkApp.Dict", "getWordInitState, confBean is empty");
        return true;
      }
      paramAppInterface = paramAppInterface.a().d;
      if (paramAppInterface == null) {
        break;
      }
      ArkAppCenter.c("ArkApp.Dict", String.format("getWordInitState, wordInitState=%s", new Object[] { paramAppInterface }));
    } while (!paramAppInterface.equals("false"));
    return false;
    ArkAppCenter.c("ArkApp.Dict", "getWordInitState, ark_dict_init is empty");
    return true;
  }
  
  private static void d()
  {
    try
    {
      if ((ArkAiAppCenter.b) && (!jdField_a_of_type_Boolean))
      {
        jdField_a_of_type_Boolean = UpdateArkSo.b(BaseApplicationImpl.getContext(), "WordSegment");
        ArkAppCenter.c("ArkApp.Dict", String.format("loadWordSegmentSo, result=%s", new Object[] { Boolean.toString(jdField_a_of_type_Boolean) }));
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
  
  public void b()
  {
    ArkAppCenter.c("ArkApp.Dict", "clearDict");
    AppInterface localAppInterface = (AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    SharedPreUtils.i(localAppInterface.getApp(), localAppInterface.getCurrentAccountUin());
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.ArkAiDictMgr
 * JD-Core Version:    0.7.0.1
 */