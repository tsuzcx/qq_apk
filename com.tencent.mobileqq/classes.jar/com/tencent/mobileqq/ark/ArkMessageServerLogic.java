package com.tencent.mobileqq.ark;

import aaph;
import aapi;
import aapk;
import aapn;
import aapr;
import aapv;
import aapx;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.item.ArkAppLocationManager;
import com.tencent.mobileqq.activity.aio.item.ArkAppLocationManager.ArkGetLocationCallback;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.wordsegment.ContextItem;
import com.tencent.wordsegment.SemanticItem;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ArkMessageServerLogic
{
  public static double a;
  protected static long a;
  protected static ArkAppLocationManager a;
  public static String a;
  private static final ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  protected static HashMap a;
  private static final LinkedList jdField_a_of_type_JavaUtilLinkedList;
  protected static boolean a;
  public static double b;
  protected static long b;
  
  static
  {
    jdField_a_of_type_JavaLangString = null;
    jdField_a_of_type_Long = 0L;
    jdField_a_of_type_Double = 0.0D;
    jdField_b_of_type_Double = 0.0D;
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
    jdField_b_of_type_Long = 0L;
    jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppLocationManager = new ArkAppLocationManager(600000L);
    jdField_a_of_type_Boolean = false;
    jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
  }
  
  public static void a()
  {
    if (!jdField_a_of_type_Boolean)
    {
      jdField_a_of_type_Boolean = true;
      SharedPreferences localSharedPreferences = BaseApplicationImpl.sApplication.getSharedPreferences("PREF_ARK_SERVER_LOGIC", 0);
      if (localSharedPreferences != null)
      {
        String str = localSharedPreferences.getString("city", "");
        if (!TextUtils.isEmpty(str)) {
          jdField_a_of_type_JavaLangString = str;
        }
        double d = localSharedPreferences.getFloat("lat", 0.0F);
        if (Math.abs(d) > 1.0E-006D) {
          jdField_a_of_type_Double = d;
        }
        d = localSharedPreferences.getFloat("lon", 0.0F);
        if (Math.abs(d) > 1.0E-006D) {
          jdField_b_of_type_Double = d;
        }
      }
      ArkAppCenter.b("ArkApp.ArkMessageServerLogic", String.format("initEnvironment, city=%s, lat=%f, lon=%f", new Object[] { jdField_a_of_type_JavaLangString, Double.valueOf(jdField_a_of_type_Double), Double.valueOf(jdField_b_of_type_Double) }));
    }
  }
  
  private static void a(ArkAppLocationManager.ArkGetLocationCallback paramArkGetLocationCallback)
  {
    synchronized (new ArkMessageServerLogic())
    {
      if ((jdField_a_of_type_Long != 0L) && (jdField_a_of_type_JavaLangString != null) && (Math.abs(jdField_a_of_type_Double) > 1.0E-006D) && (Math.abs(jdField_b_of_type_Double) > 1.0E-006D))
      {
        paramArkGetLocationCallback.a(jdField_a_of_type_JavaLangString, jdField_a_of_type_Double, jdField_b_of_type_Double);
        ArkAppCenter.b("ArkApp.ArkMessageServerLogic", String.format("cache is exist, city=%s, lat=%f, lon=%f", new Object[] { jdField_a_of_type_JavaLangString, Double.valueOf(jdField_a_of_type_Double), Double.valueOf(jdField_b_of_type_Double) }));
        if (SystemClock.elapsedRealtime() - jdField_a_of_type_Long > 36000000L)
        {
          b(null);
          ArkAppCenter.b("ArkApp.ArkMessageServerLogic", String.format("getCurrentAddress,cache is out of date and need update", new Object[0]));
        }
        jdField_a_of_type_Long = SystemClock.elapsedRealtime();
        return;
      }
      b(paramArkGetLocationCallback);
      ArkAppCenter.b("ArkApp.ArkMessageServerLogic", String.format("getCurrentAddress,cache is not exist and get location", new Object[0]));
    }
  }
  
  public static void a(ArkMessageServerLogic.IRequestArkAppListHandler paramIRequestArkAppListHandler)
  {
    ThreadManager.post(new aapv(paramIRequestArkAppListHandler), 5, null, true);
  }
  
  private static void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    synchronized (jdField_a_of_type_JavaUtilLinkedList)
    {
      jdField_a_of_type_JavaUtilLinkedList.add(paramString);
      if (jdField_a_of_type_JavaUtilLinkedList.size() > 30) {
        jdField_a_of_type_JavaUtilLinkedList.remove(0);
      }
      return;
    }
  }
  
  public static void a(String paramString, Object paramObject, ArkMessageServerLogic.IAnalyzeArkBabyQReplyByServerHandler paramIAnalyzeArkBabyQReplyByServerHandler)
  {
    a(new aapn(paramString, paramObject, paramIAnalyzeArkBabyQReplyByServerHandler));
  }
  
  public static void a(String paramString, Object paramObject, ArkMessageServerLogic.IAnalyzeTextIntentByServerHandler paramIAnalyzeTextIntentByServerHandler)
  {
    a(new aapk(paramString, paramObject, paramIAnalyzeTextIntentByServerHandler));
  }
  
  public static void a(String paramString, Object paramObject, ArkMessageServerLogic.IPassiveSearchIntentByServerHandler paramIPassiveSearchIntentByServerHandler)
  {
    a(new aapr(paramString, paramObject, paramIPassiveSearchIntentByServerHandler));
  }
  
  public static void a(ArrayList paramArrayList, boolean paramBoolean, long paramLong, ArkMessageServerLogic.ServerCheckCallback paramServerCheckCallback)
  {
    a(new aapi(paramArrayList, paramBoolean, paramLong, paramServerCheckCallback));
  }
  
  private static boolean a()
  {
    return true;
  }
  
  private static String b(aapx paramaapx, String paramString)
  {
    if ((paramaapx == null) || (TextUtils.isEmpty(paramaapx.jdField_a_of_type_JavaLangString))) {
      return "";
    }
    for (;;)
    {
      try
      {
        JSONObject localJSONObject1 = new JSONObject();
        localJSONObject1.put("text", paramaapx.jdField_a_of_type_JavaLangString);
        JSONObject localJSONObject2 = new JSONObject();
        localJSONObject1.put("meta", localJSONObject2);
        paramaapx = ArkAppCenter.a();
        if (TextUtils.isEmpty(paramaapx))
        {
          if (!TextUtils.isEmpty(paramString)) {
            localJSONObject2.put("City.Name", paramString);
          }
          paramaapx = localJSONObject1.toString();
          return paramaapx;
        }
      }
      catch (Exception paramaapx)
      {
        ArkAppCenter.b("ArkApp.ArkMessageServerLogic", String.format("getAnalyzeTextIntentReq, exception=%s", new Object[] { paramaapx.getMessage() }));
        return "";
      }
      paramString = paramaapx;
    }
  }
  
  private static String b(aapx paramaapx, String paramString, double paramDouble1, double paramDouble2)
  {
    if (paramaapx == null) {
      return "";
    }
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("text", paramaapx.jdField_a_of_type_JavaLangString);
        paramaapx = ArkAppCenter.a();
        if (TextUtils.isEmpty(paramaapx))
        {
          if (!TextUtils.isEmpty(paramString)) {
            localJSONObject.put("City.Name", paramString);
          }
          paramString = ArkAppCenter.a();
          if (paramString == null)
          {
            paramaapx = new double[2];
            paramaapx[0] = paramDouble1;
            paramaapx[1] = paramDouble2;
            if ((paramaapx != null) && (Math.abs(paramaapx[0]) > 1.0E-006D) && (Math.abs(paramaapx[1]) > 1.0E-006D))
            {
              localJSONObject.put("Location.Longitude", paramaapx[1]);
              localJSONObject.put("Location.Latitude", paramaapx[0]);
            }
            return localJSONObject.toString();
          }
          if (Math.abs(paramString[0]) >= 1.0E-006D)
          {
            paramaapx = paramString;
            if (Math.abs(paramString[1]) >= 1.0E-006D) {
              continue;
            }
          }
          paramString[0] = paramDouble1;
          paramString[1] = paramDouble2;
          paramaapx = paramString;
          continue;
        }
        paramString = paramaapx;
      }
      catch (Exception paramaapx)
      {
        ArkAppCenter.b("ArkApp.ArkMessageServerLogic", String.format("getArkSearchReq, exception=%s", new Object[] { paramaapx.getMessage() }));
        return "";
      }
    }
  }
  
  private static String b(ArrayList paramArrayList, boolean paramBoolean, long paramLong, String paramString, double paramDouble1, double paramDouble2)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    for (;;)
    {
      Object localObject1;
      Object localObject2;
      JSONArray localJSONArray;
      Object localObject3;
      try
      {
        localObject1 = ArkAppCenter.a();
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          break label636;
        }
        localObject2 = ArkAppCenter.a();
        if (localObject2 == null)
        {
          localObject1 = new double[2];
          localObject1[0] = paramDouble1;
          localObject1[1] = paramDouble2;
          localObject2 = new JSONObject();
          localJSONArray = new JSONArray();
          ((JSONObject)localObject2).put("os", "android");
          ((JSONObject)localObject2).put("platformVer", Integer.parseInt(ArkAppCenter.g()));
          ((JSONObject)localObject2).put("minPlatformVer", Integer.parseInt(ArkAppCenter.h()));
          if (!TextUtils.isEmpty(paramString)) {
            ((JSONObject)localObject2).put("City.Name", paramString);
          }
          if ((localObject1 == null) || (Math.abs(localObject1[0]) <= 1.0E-006D) || (Math.abs(localObject1[1]) <= 1.0E-006D)) {
            break label643;
          }
          ((JSONObject)localObject2).put("Location.Longitude", String.valueOf(localObject1[1]));
          ((JSONObject)localObject2).put("Location.Latitude", String.valueOf(localObject1[0]));
          break label643;
          if (i >= paramArrayList.size()) {
            break label429;
          }
          localObject3 = ((ContextItem)paramArrayList.get(i)).contextName;
          if (TextUtils.isEmpty((CharSequence)localObject3))
          {
            ArkAppCenter.b("ArkApp.ArkMessageServerLogic", String.format("contextName is empty", new Object[0]));
            break label649;
          }
        }
        else
        {
          if (Math.abs(localObject2[0]) >= 1.0E-006D)
          {
            localObject1 = localObject2;
            if (Math.abs(localObject2[1]) >= 1.0E-006D) {
              continue;
            }
          }
          localObject2[0] = paramDouble1;
          localObject2[1] = paramDouble2;
          localObject1 = localObject2;
          continue;
        }
        localObject4 = (ContextItem)paramArrayList.get(i);
      }
      catch (JSONException paramArrayList)
      {
        ArkAppCenter.b("ArkApp.ArkMessageServerLogic", String.format("ArkRecommendLogic.getMetaList.jsonParseError", new Object[0]));
        return localStringBuffer.toString();
      }
      Object localObject4;
      if (paramBoolean)
      {
        ArkAppCenter.b("ArkApp.ArkMessageServerLogic", String.format(Locale.CHINA, "analyseChatMessage, %d, %s", new Object[] { Long.valueOf(paramLong), ArkRecommendLogic.a((ContextItem)localObject4) }));
        if (((ArkRecommendLogic.b) && (((ContextItem)localObject4).toUser == 2)) || ((!ArkRecommendLogic.b) && (((ContextItem)localObject4).toUser == 1)))
        {
          if (QLog.isColorLevel()) {
            QLog.i("ArkApp.ArkMessageServerLogic", 2, String.format(Locale.CHINA, "ArkRecommendLogic contextItem.toUser: %d", new Object[] { Integer.valueOf(((ContextItem)localObject4).toUser) }));
          }
          label429:
          if (localJSONArray.length() == 0)
          {
            ArkAppCenter.b("ArkApp.ArkMessageServerLogic", String.format("jsonIntentArray is empty and cancel send json", new Object[0]));
            return "";
          }
        }
        else
        {
          ArkRecommendLogic.c = true;
        }
      }
      else
      {
        paramString = new JSONObject();
        localObject1 = new JSONObject();
        paramString.put("intent", localObject3);
        paramString.put("position", ((ContextItem)localObject4).matchPosition);
        localObject3 = ((ContextItem)localObject4).semantic.iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (SemanticItem)((Iterator)localObject3).next();
          if ((!TextUtils.isEmpty(((SemanticItem)localObject4).key)) && (!TextUtils.isEmpty(((SemanticItem)localObject4).value))) {
            ((JSONObject)localObject1).put(((SemanticItem)localObject4).key, ((SemanticItem)localObject4).value);
          }
        }
        paramString.put("meta", localObject1);
        localJSONArray.put(paramString);
        break label649;
      }
      ArkAppCenter.b("ArkApp.ArkMessageServerLogic", String.format("jsonIntentArray is not empty and build json", new Object[0]));
      ((JSONObject)localObject2).put("intents", localJSONArray);
      localStringBuffer.append(((JSONObject)localObject2).toString());
      continue;
      label636:
      paramString = (String)localObject1;
      continue;
      label643:
      int i = 0;
      continue;
      label649:
      i += 1;
    }
  }
  
  private static ArrayList b(String paramString1, String paramString2)
  {
    for (;;)
    {
      int i;
      try
      {
        if (TextUtils.isEmpty(paramString2)) {
          return null;
        }
        paramString2 = new JSONObject(paramString2);
        if (paramString2 == null)
        {
          ArkAppCenter.b("ArkApp.ArkMessageServerLogic", String.format("parseAnalyzeTextIntentReply, invalid reply string", new Object[0]));
          return null;
        }
        i = paramString2.optInt("ret", -1);
        if (i != 0)
        {
          ArkAppCenter.b("ArkApp.ArkMessageServerLogic", String.format("parseAnalyzeTextIntentReply, server reply %d", new Object[] { Integer.valueOf(i) }));
          if (i != 1) {
            break label360;
          }
          a(paramString1);
          break label360;
        }
        paramString1 = paramString2.optJSONArray("data");
        if (paramString1 == null)
        {
          String.format("analyzeTextIntentByServer, 'data' is null", new Object[0]);
          return null;
        }
        paramString2 = new ArrayList();
        int j = paramString1.length();
        i = 0;
        if (i >= j) {
          break label358;
        }
        JSONObject localJSONObject = paramString1.optJSONObject(i);
        if (localJSONObject == null) {
          break label362;
        }
        ContextItem localContextItem = new ContextItem();
        localContextItem.contextId = 0;
        localContextItem.ignoreOldMeta = true;
        localContextItem.toUser = 0;
        localContextItem.semantic = new ArrayList();
        Object localObject = localJSONObject.optString("intent");
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          break label362;
        }
        localContextItem.contextName = ((String)localObject);
        localJSONObject = localJSONObject.optJSONObject("meta");
        if (localJSONObject != null)
        {
          localObject = localJSONObject.keys();
          if (((Iterator)localObject).hasNext())
          {
            String str1 = (String)((Iterator)localObject).next();
            String str2 = localJSONObject.optString(str1, "");
            if ((TextUtils.isEmpty(str1)) || (TextUtils.isEmpty(str2))) {
              continue;
            }
            SemanticItem localSemanticItem = new SemanticItem();
            localSemanticItem.key = str1;
            localSemanticItem.value = str2;
            localSemanticItem.isUnkownWord = false;
            localContextItem.semantic.add(localSemanticItem);
            continue;
          }
        }
        paramString2.add(localContextItem);
      }
      catch (Exception paramString1)
      {
        ArkAppCenter.b("ArkApp.ArkMessageServerLogic", String.format("parseAnalyzeTextIntentReply, exception, msg=%s", new Object[] { paramString1.getMessage() }));
        return null;
      }
      break label362;
      label358:
      return paramString2;
      label360:
      return null;
      label362:
      i += 1;
    }
  }
  
  private static void b(ArkAppLocationManager.ArkGetLocationCallback paramArkGetLocationCallback)
  {
    if (a())
    {
      jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppLocationManager.a(new aaph(paramArkGetLocationCallback));
      return;
    }
    if (paramArkGetLocationCallback != null) {
      paramArkGetLocationCallback.a("", 0.0D, 0.0D);
    }
    ArkAppCenter.b("ArkApp.ArkMessageServerLogic", String.format("getCurrentAddress,location authority is not permit", new Object[0]));
  }
  
  private static boolean b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return true;
    }
    synchronized (jdField_a_of_type_JavaUtilLinkedList)
    {
      Iterator localIterator = jdField_a_of_type_JavaUtilLinkedList.iterator();
      while (localIterator.hasNext()) {
        if (paramString.startsWith((String)localIterator.next())) {
          return true;
        }
      }
      return false;
    }
  }
  
  private static void c()
  {
    Object localObject = BaseApplicationImpl.sApplication.getSharedPreferences("PREF_ARK_SERVER_LOGIC", 0);
    if (localObject != null)
    {
      localObject = ((SharedPreferences)localObject).edit();
      ((SharedPreferences.Editor)localObject).putString("city", jdField_a_of_type_JavaLangString);
      ((SharedPreferences.Editor)localObject).putFloat("lat", (float)jdField_a_of_type_Double);
      ((SharedPreferences.Editor)localObject).putFloat("lon", (float)jdField_b_of_type_Double);
      ((SharedPreferences.Editor)localObject).commit();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ark.ArkMessageServerLogic
 * JD-Core Version:    0.7.0.1
 */