package com.tencent.mobileqq.ark;

import aarz;
import aasb;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.startup.step.UpdateArkSo;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

public class ArkAiDictMgr
{
  static final String a;
  public static volatile boolean a;
  public static boolean b;
  public java.lang.ref.WeakReference a;
  
  static
  {
    jdField_a_of_type_JavaLangString = ArkAppCenter.e() + "/WordData";
  }
  
  ArkAiDictMgr(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new mqq.util.WeakReference(paramQQAppInterface);
  }
  
  public static String a()
  {
    return jdField_a_of_type_JavaLangString;
  }
  
  public static void a()
  {
    try
    {
      if ((ArkAiAppCenter.h) && (!jdField_a_of_type_Boolean))
      {
        jdField_a_of_type_Boolean = UpdateArkSo.b(BaseApplicationImpl.getContext(), "WordSegment");
        ArkAppCenter.b("ArkApp.Dict", String.format("loadWordSegmentSo, result=%s", new Object[] { Boolean.toString(jdField_a_of_type_Boolean) }));
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    if (!jdField_a_of_type_Boolean)
    {
      ArkAppCenter.b("ArkApp.Dict", "reloadWordData, sIsSoLoaded is false");
      return;
    }
    ArkRecommendLogic.a().post(new aasb(paramQQAppInterface));
  }
  
  private static boolean b(QQAppInterface paramQQAppInterface)
  {
    boolean bool = false;
    if (paramQQAppInterface == null) {
      return false;
    }
    paramQQAppInterface = SharedPreUtils.h(paramQQAppInterface.getApp(), paramQQAppInterface.c());
    if (TextUtils.isEmpty(paramQQAppInterface))
    {
      ArkAppCenter.b("ArkApp.Dict", "getWordInitState, dictConfigJsonString is empty");
      return true;
    }
    try
    {
      paramQQAppInterface = new JSONObject(paramQQAppInterface).optString("ark_dict_init");
      if (paramQQAppInterface != null)
      {
        ArkAppCenter.b("ArkApp.Dict", String.format("getWordInitState, ark_dict_init=%s", new Object[] { paramQQAppInterface }));
        if (!paramQQAppInterface.equals("false")) {
          break label119;
        }
      }
      else
      {
        ArkAppCenter.b("ArkApp.Dict", "getWordInitState, ark_dict_init is empty");
        return true;
      }
    }
    catch (JSONException paramQQAppInterface)
    {
      ArkAppCenter.b("ArkApp.Dict", String.format("getWordInitState, parse json failed, err=%s", new Object[] { paramQQAppInterface.getMessage() }));
      return true;
    }
    for (;;)
    {
      return bool;
      label119:
      bool = true;
    }
  }
  
  public static void c()
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
  
  protected void b()
  {
    if (b == true) {
      ArkAppCenter.b("ArkApp.Dict", "initWordData, already inited.");
    }
    do
    {
      return;
      String str = a();
      a();
      new File(str).mkdirs();
      if (jdField_a_of_type_Boolean) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i("ark.ai", 2, "initWordData, loadWordSegmentSo failed.");
    return;
    ArkRecommendLogic.a().post(new aarz(this));
  }
  
  public void d()
  {
    ArkAppCenter.b("ArkApp.Dict", "clearDict");
    QQAppInterface localQQAppInterface = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    SharedPreUtils.i(localQQAppInterface.getApp(), localQQAppInterface.c());
    c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ark.ArkAiDictMgr
 * JD-Core Version:    0.7.0.1
 */