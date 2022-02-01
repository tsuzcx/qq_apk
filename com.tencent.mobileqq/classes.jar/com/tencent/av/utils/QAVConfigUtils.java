package com.tencent.av.utils;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.av.business.manager.EffectConfigBase;
import com.tencent.av.wtogether.util.WTogetherUtil;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONObject;

public class QAVConfigUtils
{
  private static int jdField_a_of_type_Int = -1;
  private static long jdField_a_of_type_Long = 1000L;
  private static Boolean jdField_a_of_type_JavaLangBoolean;
  private static Integer jdField_a_of_type_JavaLangInteger = null;
  private static final String jdField_a_of_type_JavaLangString;
  private static int jdField_b_of_type_Int = -1;
  private static volatile Boolean jdField_b_of_type_JavaLangBoolean;
  private static Integer jdField_b_of_type_JavaLangInteger = null;
  private static String jdField_b_of_type_JavaLangString;
  private static volatile int jdField_c_of_type_Int = -1;
  private static Integer jdField_c_of_type_JavaLangInteger = null;
  private static int jdField_d_of_type_Int = -1;
  private static Integer jdField_d_of_type_JavaLangInteger = null;
  private static int e = -1;
  private static int f;
  private static int g;
  private static int h;
  
  static
  {
    jdField_a_of_type_JavaLangBoolean = null;
    f = -1;
    jdField_a_of_type_JavaLangString = HardCodeUtil.a(2131708885);
    jdField_b_of_type_JavaLangBoolean = null;
    jdField_b_of_type_JavaLangString = null;
    g = -1;
    h = -1;
  }
  
  public static int a()
  {
    if (jdField_c_of_type_Int == -1)
    {
      jdField_c_of_type_Int = EffectConfigBase.a(287, EffectConfigBase.c).getInt("multiVideoSupportNumbers", -1);
      if (jdField_c_of_type_Int == -1) {
        jdField_c_of_type_Int = 5;
      }
      return jdField_c_of_type_Int;
    }
    return jdField_c_of_type_Int;
  }
  
  public static long a()
  {
    return jdField_a_of_type_Long;
  }
  
  public static QAVConfigUtils.MoreBtnTips a(int paramInt)
  {
    JSONArray localJSONArray = a();
    if (localJSONArray == null) {
      return null;
    }
    for (;;)
    {
      int i;
      try
      {
        QAVConfigUtils.MoreBtnTips localMoreBtnTips = new QAVConfigUtils.MoreBtnTips();
        localMoreBtnTips.jdField_b_of_type_Int = 2147483647;
        i = 0;
        if (i < localJSONArray.length())
        {
          JSONObject localJSONObject = localJSONArray.getJSONObject(i);
          if ((localJSONObject.getInt("type") == paramInt) && (localJSONObject.getInt("priority") < localMoreBtnTips.jdField_b_of_type_Int))
          {
            localMoreBtnTips.jdField_a_of_type_Int = localJSONObject.getInt("id");
            localMoreBtnTips.jdField_a_of_type_JavaLangString = localJSONObject.getString("url");
            localMoreBtnTips.jdField_b_of_type_Int = localJSONObject.getInt("priority");
            localMoreBtnTips.jdField_c_of_type_Int = localJSONObject.getInt("type");
          }
        }
        else if (localMoreBtnTips.jdField_b_of_type_Int < 2147483647)
        {
          QLog.i("QAVConfigUtils", 1, "MoreBtnTips. getHighestPriorityMoreBtnTips. highest. id = " + localMoreBtnTips.jdField_a_of_type_Int + ", url = " + localMoreBtnTips.jdField_a_of_type_JavaLangString + ", priority = " + localMoreBtnTips.jdField_b_of_type_Int + ", type = " + localMoreBtnTips.jdField_c_of_type_Int);
          return localMoreBtnTips;
        }
      }
      catch (Exception localException)
      {
        QLog.i("QAVConfigUtils", 1, "MoreBtnTips. getHighestPriorityMoreBtnTips failed. " + QLog.getStackTraceString(localException));
        QLog.i("QAVConfigUtils", 1, "MoreBtnTips. getHighestPriorityMoreBtnTips failed. moreBtnTips = null. sessionType = " + paramInt);
        return null;
      }
      i += 1;
    }
  }
  
  public static String a()
  {
    a();
    return jdField_b_of_type_JavaLangString;
  }
  
  public static String a(@NonNull String paramString)
  {
    return EffectConfigBase.a(287, EffectConfigBase.c).getString(paramString, "");
  }
  
  private static JSONArray a()
  {
    Object localObject = EffectConfigBase.a(287, EffectConfigBase.c).getString("moreBtnTips", "");
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      QLog.i("QAVConfigUtils", 1, "MoreBtnTips. readMoreBtnTipsJsonArray failed. TextUtils.isEmpty(moreBtnTipsJson) = " + TextUtils.isEmpty((CharSequence)localObject));
      return null;
    }
    try
    {
      QLog.i("QAVConfigUtils", 1, "MoreBtnTips. readMoreBtnTipsJsonArray. read moreBtnTipsJson = " + (String)localObject);
      localObject = new JSONArray((String)localObject);
      return localObject;
    }
    catch (Exception localException)
    {
      QLog.i("QAVConfigUtils", 1, "MoreBtnTips. readMoreBtnTipsJsonArray failed. " + QLog.getStackTraceString(localException));
    }
    return null;
  }
  
  private static void a()
  {
    if ((jdField_b_of_type_JavaLangBoolean == null) || (TextUtils.isEmpty(jdField_b_of_type_JavaLangString)))
    {
      SharedPreferences localSharedPreferences = EffectConfigBase.a(287, EffectConfigBase.c);
      jdField_b_of_type_JavaLangBoolean = Boolean.valueOf(localSharedPreferences.getBoolean("switchMultiForceUseGroup", false));
      jdField_b_of_type_JavaLangString = localSharedPreferences.getString("switchMultiForceUseGroupAlertTip", jdField_a_of_type_JavaLangString);
      if (TextUtils.isEmpty(jdField_b_of_type_JavaLangString)) {
        jdField_b_of_type_JavaLangString = jdField_a_of_type_JavaLangString;
      }
      if (QLog.isColorLevel()) {
        QLog.i("double_2_multi", 2, "initDouble2GroupConfig [" + jdField_b_of_type_JavaLangBoolean + "," + jdField_b_of_type_JavaLangString + "]");
      }
    }
  }
  
  public static void a(int paramInt)
  {
    JSONArray localJSONArray = a();
    if (localJSONArray == null) {
      return;
    }
    for (;;)
    {
      int i;
      Object localObject;
      try
      {
        new QAVConfigUtils.MoreBtnTips().jdField_b_of_type_Int = 2147483647;
        i = 0;
        if (i >= localJSONArray.length()) {
          break;
        }
        localObject = localJSONArray.getJSONObject(i);
        if (((JSONObject)localObject).getInt("id") != paramInt) {
          break label192;
        }
        QLog.i("QAVConfigUtils", 1, "MoreBtnTips. removeMoreBtnTips. id = " + paramInt);
        if (Build.VERSION.SDK_INT >= 19)
        {
          localJSONArray.remove(i);
          localObject = EffectConfigBase.a(287, EffectConfigBase.c).edit();
          QLog.i("QAVConfigUtils", 1, "MoreBtnTips. removeMoreBtnTips. saved moreBtnTipsJson = " + localJSONArray.toString());
          ((SharedPreferences.Editor)localObject).putString("moreBtnTips", localJSONArray.toString());
          ((SharedPreferences.Editor)localObject).commit();
          return;
        }
      }
      catch (Exception localException)
      {
        QLog.i("QAVConfigUtils", 1, "MoreBtnTips. removeMoreBtnTips failed. " + QLog.getStackTraceString(localException));
        return;
      }
      ((JSONObject)localObject).put("priority", 2147483647);
      continue;
      label192:
      i += 1;
    }
  }
  
  public static void a(String paramString)
  {
    int i5 = 1;
    int i = 1;
    long l2 = 1000L;
    boolean bool5 = true;
    boolean bool1 = true;
    int i6 = -1;
    int i7 = 0;
    int j = 0;
    boolean bool4 = false;
    boolean bool2 = false;
    Object localObject1 = jdField_a_of_type_JavaLangString;
    boolean bool9 = false;
    boolean bool3 = false;
    int i1 = 7;
    int i2 = -1;
    int i3 = -1;
    int i8 = -1;
    Object localObject3 = "";
    Object localObject4 = "";
    Object localObject5 = "";
    Object localObject7 = "";
    boolean bool7 = false;
    boolean bool8 = false;
    Object localObject8 = "";
    Object localObject15 = "";
    int i9 = -1;
    int i10 = -1;
    int i17 = 1;
    int i18 = 1;
    int i16 = 0;
    int i11 = 0;
    int i21 = -1;
    if (QLog.isColorLevel()) {
      QLog.i("QAVConfigUtils", 2, " parseAndSave parse json = " + paramString);
    }
    if (!TextUtils.isEmpty(paramString)) {}
    label5093:
    for (;;)
    {
      try
      {
        localObject16 = new JSONObject(paramString);
        if (((JSONObject)localObject16).has("isBlueToothSwitchForAndroid"))
        {
          i = ((JSONObject)localObject16).getInt("isBlueToothSwitchForAndroid");
          l1 = l2;
          l3 = l2;
        }
      }
      catch (Exception localException6)
      {
        try
        {
          long l1;
          if (((JSONObject)localObject16).has("bluetoothDelayTime"))
          {
            l3 = l2;
            l1 = ((JSONObject)localObject16).getLong("bluetoothDelayTime");
          }
          long l3 = l1;
          if (((JSONObject)localObject16).has("LowlightAndDenoiseDevice"))
          {
            l3 = l1;
            bool1 = ((JSONObject)localObject16).getBoolean("LowlightAndDenoiseDevice");
          }
          int k;
          Object localObject2;
          int m;
          Object localObject6;
          Object localObject10;
          int i4;
          int n;
          Object localObject9;
          i = 1;
        }
        catch (Exception localException6)
        {
          try
          {
            if (((JSONObject)localObject16).has("multiVideoSupportNumbers")) {
              j = ((JSONObject)localObject16).getInt("multiVideoSupportNumbers");
            }
          }
          catch (Exception localException6)
          {
            try
            {
              if (((JSONObject)localObject16).has("SpeedDialScreenStyle")) {
                k = ((JSONObject)localObject16).getInt("SpeedDialScreenStyle");
              }
            }
            catch (Exception localException6)
            {
              try
              {
                if (((JSONObject)localObject16).has("switchMultiForceUseGroup")) {
                  bool2 = ((JSONObject)localObject16).getBoolean("switchMultiForceUseGroup");
                }
              }
              catch (Exception localException6)
              {
                try
                {
                  if (((JSONObject)localObject16).has("switchMultiForceUseGroupAlertTip"))
                  {
                    localObject2 = ((JSONObject)localObject16).getString("switchMultiForceUseGroupAlertTip");
                    localObject1 = localObject2;
                  }
                  bool2 = false;
                }
                catch (Exception localException6)
                {
                  try
                  {
                    if (((JSONObject)localObject16).has("useRGB2I420Shader"))
                    {
                      m = ((JSONObject)localObject16).getInt("useRGB2I420Shader");
                      i7 = i16;
                      i6 = i17;
                      i15 = i10;
                      i14 = i9;
                      localObject14 = localObject15;
                      localObject13 = localObject8;
                      bool6 = bool7;
                      localObject12 = localObject7;
                      localObject11 = localObject5;
                      localObject6 = localObject4;
                      localObject10 = localObject3;
                      i13 = i8;
                      i5 = i3;
                      i4 = i2;
                      i12 = i1;
                      bool5 = bool9;
                      try
                      {
                        if (((JSONObject)localObject16).has("isSharpnessSwitch"))
                        {
                          i7 = i16;
                          i6 = i17;
                          i15 = i10;
                          i14 = i9;
                          localObject14 = localObject15;
                          localObject13 = localObject8;
                          bool6 = bool7;
                          localObject12 = localObject7;
                          localObject11 = localObject5;
                          localObject6 = localObject4;
                          localObject10 = localObject3;
                          i13 = i8;
                          i5 = i3;
                          i4 = i2;
                          i12 = i1;
                          bool5 = bool9;
                          if (((JSONObject)localObject16).getInt("isSharpnessSwitch") == 1)
                          {
                            bool3 = true;
                            break label5093;
                          }
                        }
                        else
                        {
                          n = i1;
                          i7 = i16;
                          i6 = i17;
                          i15 = i10;
                          i14 = i9;
                          localObject14 = localObject15;
                          localObject13 = localObject8;
                          bool6 = bool7;
                          localObject12 = localObject7;
                          localObject11 = localObject5;
                          localObject6 = localObject4;
                          localObject10 = localObject3;
                          i13 = i8;
                          i5 = i3;
                          i4 = i2;
                          i12 = i1;
                          bool5 = bool3;
                          if (((JSONObject)localObject16).has("sharpnessFPSThreshold"))
                          {
                            i7 = i16;
                            i6 = i17;
                            i15 = i10;
                            i14 = i9;
                            localObject14 = localObject15;
                            localObject13 = localObject8;
                            bool6 = bool7;
                            localObject12 = localObject7;
                            localObject11 = localObject5;
                            localObject6 = localObject4;
                            localObject10 = localObject3;
                            i13 = i8;
                            i5 = i3;
                            i4 = i2;
                            i12 = i1;
                            bool5 = bool3;
                            n = ((JSONObject)localObject16).getInt("sharpnessFPSThreshold");
                          }
                          i1 = i2;
                          i7 = i16;
                          i6 = i17;
                          i15 = i10;
                          i14 = i9;
                          localObject14 = localObject15;
                          localObject13 = localObject8;
                          bool6 = bool7;
                          localObject12 = localObject7;
                          localObject11 = localObject5;
                          localObject6 = localObject4;
                          localObject10 = localObject3;
                          i13 = i8;
                          i5 = i3;
                          i4 = i2;
                          i12 = n;
                          bool5 = bool3;
                          if (((JSONObject)localObject16).has("useAADSDeJitterAlgorithmUin"))
                          {
                            i7 = i16;
                            i6 = i17;
                            i15 = i10;
                            i14 = i9;
                            localObject14 = localObject15;
                            localObject13 = localObject8;
                            bool6 = bool7;
                            localObject12 = localObject7;
                            localObject11 = localObject5;
                            localObject6 = localObject4;
                            localObject10 = localObject3;
                            i13 = i8;
                            i5 = i3;
                            i4 = i2;
                            i12 = n;
                            bool5 = bool3;
                            i1 = ((JSONObject)localObject16).getInt("useAADSDeJitterAlgorithmUin");
                            i7 = i16;
                            i6 = i17;
                            i15 = i10;
                            i14 = i9;
                            localObject14 = localObject15;
                            localObject13 = localObject8;
                            bool6 = bool7;
                            localObject12 = localObject7;
                            localObject11 = localObject5;
                            localObject6 = localObject4;
                            localObject10 = localObject3;
                            i13 = i8;
                            i5 = i3;
                            i4 = i1;
                            i12 = n;
                            bool5 = bool3;
                            QLog.i("QAVConfigUtils", 1, "JTest. save useAADSDeJitterAlgorithmUin = " + i1);
                          }
                          i2 = i3;
                          i7 = i16;
                          i6 = i17;
                          i15 = i10;
                          i14 = i9;
                          localObject14 = localObject15;
                          localObject13 = localObject8;
                          bool6 = bool7;
                          localObject12 = localObject7;
                          localObject11 = localObject5;
                          localObject6 = localObject4;
                          localObject10 = localObject3;
                          i13 = i8;
                          i5 = i3;
                          i4 = i1;
                          i12 = n;
                          bool5 = bool3;
                          if (((JSONObject)localObject16).has("enableAADSDeJitterMaxJDelayUin"))
                          {
                            i7 = i16;
                            i6 = i17;
                            i15 = i10;
                            i14 = i9;
                            localObject14 = localObject15;
                            localObject13 = localObject8;
                            bool6 = bool7;
                            localObject12 = localObject7;
                            localObject11 = localObject5;
                            localObject6 = localObject4;
                            localObject10 = localObject3;
                            i13 = i8;
                            i5 = i3;
                            i4 = i1;
                            i12 = n;
                            bool5 = bool3;
                            i2 = ((JSONObject)localObject16).getInt("enableAADSDeJitterMaxJDelayUin");
                            i7 = i16;
                            i6 = i17;
                            i15 = i10;
                            i14 = i9;
                            localObject14 = localObject15;
                            localObject13 = localObject8;
                            bool6 = bool7;
                            localObject12 = localObject7;
                            localObject11 = localObject5;
                            localObject6 = localObject4;
                            localObject10 = localObject3;
                            i13 = i8;
                            i5 = i2;
                            i4 = i1;
                            i12 = n;
                            bool5 = bool3;
                            QLog.i("QAVConfigUtils", 1, "JTest. save enableAADSDeJitterMaxJDelayUin = " + i2);
                          }
                          i3 = i8;
                          i7 = i16;
                          i6 = i17;
                          i15 = i10;
                          i14 = i9;
                          localObject14 = localObject15;
                          localObject13 = localObject8;
                          bool6 = bool7;
                          localObject12 = localObject7;
                          localObject11 = localObject5;
                          localObject6 = localObject4;
                          localObject10 = localObject3;
                          i13 = i8;
                          i5 = i2;
                          i4 = i1;
                          i12 = n;
                          bool5 = bool3;
                          if (((JSONObject)localObject16).has("upLoadWhenGetNewData"))
                          {
                            i7 = i16;
                            i6 = i17;
                            i15 = i10;
                            i14 = i9;
                            localObject14 = localObject15;
                            localObject13 = localObject8;
                            bool6 = bool7;
                            localObject12 = localObject7;
                            localObject11 = localObject5;
                            localObject6 = localObject4;
                            localObject10 = localObject3;
                            i13 = i8;
                            i5 = i2;
                            i4 = i1;
                            i12 = n;
                            bool5 = bool3;
                            i3 = ((JSONObject)localObject16).getInt("upLoadWhenGetNewData");
                          }
                          localObject2 = localObject3;
                          i7 = i16;
                          i6 = i17;
                          i15 = i10;
                          i14 = i9;
                          localObject14 = localObject15;
                          localObject13 = localObject8;
                          bool6 = bool7;
                          localObject12 = localObject7;
                          localObject11 = localObject5;
                          localObject6 = localObject4;
                          localObject10 = localObject3;
                          i13 = i3;
                          i5 = i2;
                          i4 = i1;
                          i12 = n;
                          bool5 = bool3;
                          if (((JSONObject)localObject16).has("ptuNewRenderLimit"))
                          {
                            i7 = i16;
                            i6 = i17;
                            i15 = i10;
                            i14 = i9;
                            localObject14 = localObject15;
                            localObject13 = localObject8;
                            bool6 = bool7;
                            localObject12 = localObject7;
                            localObject11 = localObject5;
                            localObject6 = localObject4;
                            localObject10 = localObject3;
                            i13 = i3;
                            i5 = i2;
                            i4 = i1;
                            i12 = n;
                            bool5 = bool3;
                            localObject2 = ((JSONObject)localObject16).getString("ptuNewRenderLimit");
                          }
                          localObject3 = localObject4;
                          i7 = i16;
                          i6 = i17;
                          i15 = i10;
                          i14 = i9;
                          localObject14 = localObject15;
                          localObject13 = localObject8;
                          bool6 = bool7;
                          localObject12 = localObject7;
                          localObject11 = localObject5;
                          localObject6 = localObject4;
                          localObject10 = localObject2;
                          i13 = i3;
                          i5 = i2;
                          i4 = i1;
                          i12 = n;
                          bool5 = bool3;
                          if (((JSONObject)localObject16).has("moreBtnTips"))
                          {
                            i7 = i16;
                            i6 = i17;
                            i15 = i10;
                            i14 = i9;
                            localObject14 = localObject15;
                            localObject13 = localObject8;
                            bool6 = bool7;
                            localObject12 = localObject7;
                            localObject11 = localObject5;
                            localObject6 = localObject4;
                            localObject10 = localObject2;
                            i13 = i3;
                            i5 = i2;
                            i4 = i1;
                            i12 = n;
                            bool5 = bool3;
                            localObject3 = ((JSONObject)localObject16).getJSONArray("moreBtnTips").toString();
                            i7 = i16;
                            i6 = i17;
                            i15 = i10;
                            i14 = i9;
                            localObject14 = localObject15;
                            localObject13 = localObject8;
                            bool6 = bool7;
                            localObject12 = localObject7;
                            localObject11 = localObject5;
                            localObject6 = localObject3;
                            localObject10 = localObject2;
                            i13 = i3;
                            i5 = i2;
                            i4 = i1;
                            i12 = n;
                            bool5 = bool3;
                            QLog.i("QAVConfigUtils", 1, "MoreBtnTips. downloaded moreBtnTipsJson = " + (String)localObject3);
                          }
                          localObject4 = localObject5;
                          i7 = i16;
                          i6 = i17;
                          i15 = i10;
                          i14 = i9;
                          localObject14 = localObject15;
                          localObject13 = localObject8;
                          bool6 = bool7;
                          localObject12 = localObject7;
                          localObject11 = localObject5;
                          localObject6 = localObject3;
                          localObject10 = localObject2;
                          i13 = i3;
                          i5 = i2;
                          i4 = i1;
                          i12 = n;
                          bool5 = bool3;
                          if (((JSONObject)localObject16).has("ptuAfterTreamentLimit"))
                          {
                            i7 = i16;
                            i6 = i17;
                            i15 = i10;
                            i14 = i9;
                            localObject14 = localObject15;
                            localObject13 = localObject8;
                            bool6 = bool7;
                            localObject12 = localObject7;
                            localObject11 = localObject5;
                            localObject6 = localObject3;
                            localObject10 = localObject2;
                            i13 = i3;
                            i5 = i2;
                            i4 = i1;
                            i12 = n;
                            bool5 = bool3;
                            localObject4 = ((JSONObject)localObject16).getString("ptuAfterTreamentLimit");
                          }
                          localObject5 = localObject7;
                          i7 = i16;
                          i6 = i17;
                          i15 = i10;
                          i14 = i9;
                          localObject14 = localObject15;
                          localObject13 = localObject8;
                          bool6 = bool7;
                          localObject12 = localObject7;
                          localObject11 = localObject4;
                          localObject6 = localObject3;
                          localObject10 = localObject2;
                          i13 = i3;
                          i5 = i2;
                          i4 = i1;
                          i12 = n;
                          bool5 = bool3;
                          if (((JSONObject)localObject16).has("ptuAfterTreamentCanvas"))
                          {
                            i7 = i16;
                            i6 = i17;
                            i15 = i10;
                            i14 = i9;
                            localObject14 = localObject15;
                            localObject13 = localObject8;
                            bool6 = bool7;
                            localObject12 = localObject7;
                            localObject11 = localObject4;
                            localObject6 = localObject3;
                            localObject10 = localObject2;
                            i13 = i3;
                            i5 = i2;
                            i4 = i1;
                            i12 = n;
                            bool5 = bool3;
                            localObject5 = ((JSONObject)localObject16).getString("ptuAfterTreamentCanvas");
                          }
                          bool4 = bool8;
                          i7 = i16;
                          i6 = i17;
                          i15 = i10;
                          i14 = i9;
                          localObject14 = localObject15;
                          localObject13 = localObject8;
                          bool6 = bool7;
                          localObject12 = localObject5;
                          localObject11 = localObject4;
                          localObject6 = localObject3;
                          localObject10 = localObject2;
                          i13 = i3;
                          i5 = i2;
                          i4 = i1;
                          i12 = n;
                          bool5 = bool3;
                          if (((JSONObject)localObject16).has("isAllowedControlMicAfterBeMuted"))
                          {
                            i7 = i16;
                            i6 = i17;
                            i15 = i10;
                            i14 = i9;
                            localObject14 = localObject15;
                            localObject13 = localObject8;
                            bool6 = bool7;
                            localObject12 = localObject5;
                            localObject11 = localObject4;
                            localObject6 = localObject3;
                            localObject10 = localObject2;
                            i13 = i3;
                            i5 = i2;
                            i4 = i1;
                            i12 = n;
                            bool5 = bool3;
                            bool4 = ((JSONObject)localObject16).getBoolean("isAllowedControlMicAfterBeMuted");
                          }
                        }
                      }
                      catch (Exception localException8)
                      {
                        localObject2 = localObject13;
                        localObject3 = localObject12;
                        localObject4 = localObject11;
                        localObject5 = localObject6;
                        localObject6 = localObject10;
                        n = i13;
                        i1 = i5;
                        i2 = i4;
                        i3 = m;
                        i4 = i12;
                        localObject7 = localObject1;
                        bool4 = bool2;
                        i5 = k;
                        i8 = j;
                        bool3 = bool1;
                        i9 = i;
                        i = i7;
                        j = i6;
                        k = i15;
                        m = i14;
                        localObject1 = localObject14;
                        bool1 = bool6;
                        bool2 = bool5;
                        i7 = i5;
                        i6 = i8;
                        i5 = i9;
                        continue;
                      }
                      try
                      {
                        QLog.i("QAVConfigUtils", 1, "JTest. save isAllowedControlMicAfterBeMuted = " + bool4);
                        localObject7 = localObject8;
                        i7 = i16;
                        i6 = i17;
                        i15 = i10;
                        i14 = i9;
                        localObject14 = localObject15;
                        localObject13 = localObject8;
                        bool6 = bool4;
                        localObject12 = localObject5;
                        localObject11 = localObject4;
                        localObject6 = localObject3;
                        localObject10 = localObject2;
                        i13 = i3;
                        i5 = i2;
                        i4 = i1;
                        i12 = n;
                        bool5 = bool3;
                        if (((JSONObject)localObject16).has("machineMiddleLine"))
                        {
                          i7 = i16;
                          i6 = i17;
                          i15 = i10;
                          i14 = i9;
                          localObject14 = localObject15;
                          localObject13 = localObject8;
                          bool6 = bool4;
                          localObject12 = localObject5;
                          localObject11 = localObject4;
                          localObject6 = localObject3;
                          localObject10 = localObject2;
                          i13 = i3;
                          i5 = i2;
                          i4 = i1;
                          i12 = n;
                          bool5 = bool3;
                          localObject7 = ((JSONObject)localObject16).getString("machineMiddleLine");
                        }
                        localObject8 = localObject15;
                        i7 = i16;
                        i6 = i17;
                        i15 = i10;
                        i14 = i9;
                        localObject14 = localObject15;
                        localObject13 = localObject7;
                        bool6 = bool4;
                        localObject12 = localObject5;
                        localObject11 = localObject4;
                        localObject6 = localObject3;
                        localObject10 = localObject2;
                        i13 = i3;
                        i5 = i2;
                        i4 = i1;
                        i12 = n;
                        bool5 = bool3;
                        if (((JSONObject)localObject16).has("machineHighLine"))
                        {
                          i7 = i16;
                          i6 = i17;
                          i15 = i10;
                          i14 = i9;
                          localObject14 = localObject15;
                          localObject13 = localObject7;
                          bool6 = bool4;
                          localObject12 = localObject5;
                          localObject11 = localObject4;
                          localObject6 = localObject3;
                          localObject10 = localObject2;
                          i13 = i3;
                          i5 = i2;
                          i4 = i1;
                          i12 = n;
                          bool5 = bool3;
                          localObject8 = ((JSONObject)localObject16).getString("machineHighLine");
                        }
                        i8 = i9;
                        i7 = i16;
                        i6 = i17;
                        i15 = i10;
                        i14 = i9;
                        localObject14 = localObject8;
                        localObject13 = localObject7;
                        bool6 = bool4;
                        localObject12 = localObject5;
                        localObject11 = localObject4;
                        localObject6 = localObject3;
                        localObject10 = localObject2;
                        i13 = i3;
                        i5 = i2;
                        i4 = i1;
                        i12 = n;
                        bool5 = bool3;
                        if (((JSONObject)localObject16).has("allowMicLongPressSpeakInMute"))
                        {
                          i7 = i16;
                          i6 = i17;
                          i15 = i10;
                          i14 = i9;
                          localObject14 = localObject8;
                          localObject13 = localObject7;
                          bool6 = bool4;
                          localObject12 = localObject5;
                          localObject11 = localObject4;
                          localObject6 = localObject3;
                          localObject10 = localObject2;
                          i13 = i3;
                          i5 = i2;
                          i4 = i1;
                          i12 = n;
                          bool5 = bool3;
                          i8 = ((JSONObject)localObject16).getInt("allowMicLongPressSpeakInMute");
                        }
                        i9 = i10;
                        i7 = i16;
                        i6 = i17;
                        i15 = i10;
                        i14 = i8;
                        localObject14 = localObject8;
                        localObject13 = localObject7;
                        bool6 = bool4;
                        localObject12 = localObject5;
                        localObject11 = localObject4;
                        localObject6 = localObject3;
                        localObject10 = localObject2;
                        i13 = i3;
                        i5 = i2;
                        i4 = i1;
                        i12 = n;
                        bool5 = bool3;
                        if (((JSONObject)localObject16).has("qavWatchTogetherSwitch"))
                        {
                          i7 = i16;
                          i6 = i17;
                          i15 = i10;
                          i14 = i8;
                          localObject14 = localObject8;
                          localObject13 = localObject7;
                          bool6 = bool4;
                          localObject12 = localObject5;
                          localObject11 = localObject4;
                          localObject6 = localObject3;
                          localObject10 = localObject2;
                          i13 = i3;
                          i5 = i2;
                          i4 = i1;
                          i12 = n;
                          bool5 = bool3;
                          i9 = ((JSONObject)localObject16).getInt("qavWatchTogetherSwitch");
                        }
                        i10 = i18;
                        i7 = i16;
                        i6 = i17;
                        i15 = i9;
                        i14 = i8;
                        localObject14 = localObject8;
                        localObject13 = localObject7;
                        bool6 = bool4;
                        localObject12 = localObject5;
                        localObject11 = localObject4;
                        localObject6 = localObject3;
                        localObject10 = localObject2;
                        i13 = i3;
                        i5 = i2;
                        i4 = i1;
                        i12 = n;
                        bool5 = bool3;
                        if (((JSONObject)localObject16).has("ScreenShareSwitch"))
                        {
                          i7 = i16;
                          i6 = i17;
                          i15 = i9;
                          i14 = i8;
                          localObject14 = localObject8;
                          localObject13 = localObject7;
                          bool6 = bool4;
                          localObject12 = localObject5;
                          localObject11 = localObject4;
                          localObject6 = localObject3;
                          localObject10 = localObject2;
                          i13 = i3;
                          i5 = i2;
                          i4 = i1;
                          i12 = n;
                          bool5 = bool3;
                          i10 = ((JSONObject)localObject16).getInt("ScreenShareSwitch");
                          i7 = i16;
                          i6 = i10;
                          i15 = i9;
                          i14 = i8;
                          localObject14 = localObject8;
                          localObject13 = localObject7;
                          bool6 = bool4;
                          localObject12 = localObject5;
                          localObject11 = localObject4;
                          localObject6 = localObject3;
                          localObject10 = localObject2;
                          i13 = i3;
                          i5 = i2;
                          i4 = i1;
                          i12 = n;
                          bool5 = bool3;
                          QLog.d("handleGetQAVGeneralConfig", 2, " KEY_QAV_SCREEN_SHARE_SWITCH: " + i10);
                        }
                        i7 = i16;
                        i6 = i10;
                        i15 = i9;
                        i14 = i8;
                        localObject14 = localObject8;
                        localObject13 = localObject7;
                        bool6 = bool4;
                        localObject12 = localObject5;
                        localObject11 = localObject4;
                        localObject6 = localObject3;
                        localObject10 = localObject2;
                        i13 = i3;
                        i5 = i2;
                        i4 = i1;
                        i12 = n;
                        bool5 = bool3;
                        if (((JSONObject)localObject16).has("AskScreenShareSwitch"))
                        {
                          i7 = i16;
                          i6 = i10;
                          i15 = i9;
                          i14 = i8;
                          localObject14 = localObject8;
                          localObject13 = localObject7;
                          bool6 = bool4;
                          localObject12 = localObject5;
                          localObject11 = localObject4;
                          localObject6 = localObject3;
                          localObject10 = localObject2;
                          i13 = i3;
                          i5 = i2;
                          i4 = i1;
                          i12 = n;
                          bool5 = bool3;
                          i11 = ((JSONObject)localObject16).getInt("AskScreenShareSwitch");
                          i7 = i11;
                          i6 = i10;
                          i15 = i9;
                          i14 = i8;
                          localObject14 = localObject8;
                          localObject13 = localObject7;
                          bool6 = bool4;
                          localObject12 = localObject5;
                          localObject11 = localObject4;
                          localObject6 = localObject3;
                          localObject10 = localObject2;
                          i13 = i3;
                          i5 = i2;
                          i4 = i1;
                          i12 = n;
                          bool5 = bool3;
                          QLog.d("handleGetQAVGeneralConfig", 2, " KEY_QAV_SCREEN_SHARE_ASK_SWITCH: " + i11);
                        }
                        i7 = i11;
                        i6 = i10;
                        i15 = i9;
                        i14 = i8;
                        localObject14 = localObject8;
                        localObject13 = localObject7;
                        bool6 = bool4;
                        localObject12 = localObject5;
                        localObject11 = localObject4;
                        localObject6 = localObject3;
                        localObject10 = localObject2;
                        i13 = i3;
                        i5 = i2;
                        i4 = i1;
                        i12 = n;
                        bool5 = bool3;
                        if (!((JSONObject)localObject16).has("avGameResultUseWebSwitch")) {
                          continue;
                        }
                        i7 = i11;
                        i6 = i10;
                        i15 = i9;
                        i14 = i8;
                        localObject14 = localObject8;
                        localObject13 = localObject7;
                        bool6 = bool4;
                        localObject12 = localObject5;
                        localObject11 = localObject4;
                        localObject6 = localObject3;
                        localObject10 = localObject2;
                        i13 = i3;
                        i5 = i2;
                        i4 = i1;
                        i12 = n;
                        bool5 = bool3;
                        i16 = ((JSONObject)localObject16).getInt("avGameResultUseWebSwitch");
                        i4 = i16;
                      }
                      catch (Exception localException9)
                      {
                        i13 = 0;
                        i12 = 1;
                        i11 = -1;
                        i10 = -1;
                        localObject12 = "";
                        localObject11 = "";
                        localObject6 = localObject3;
                        localObject7 = localObject2;
                        i4 = i1;
                        i5 = m;
                        i6 = n;
                        localObject9 = localObject1;
                        bool5 = bool2;
                        i7 = k;
                        i8 = j;
                        bool6 = bool1;
                        i9 = i;
                        i = i13;
                        j = i12;
                        k = i11;
                        m = i10;
                        localObject1 = localObject12;
                        localObject2 = localObject11;
                        bool1 = bool4;
                        localObject3 = localObject5;
                        localObject5 = localObject6;
                        localObject6 = localObject7;
                        n = i3;
                        i1 = i2;
                        i2 = i4;
                        i3 = i5;
                        i4 = i6;
                        bool2 = bool3;
                        localObject7 = localObject9;
                        bool4 = bool5;
                        i6 = i8;
                        bool3 = bool6;
                        i5 = i9;
                        localObject9 = localException9;
                        continue;
                        i4 = -1;
                        continue;
                      }
                      i19 = i11;
                      i5 = i10;
                      l2 = l1;
                      i18 = i;
                      bool8 = bool1;
                      i17 = j;
                      i16 = k;
                      bool7 = bool2;
                      localObject16 = localObject1;
                      bool6 = bool3;
                      i15 = n;
                      i14 = m;
                      i13 = i1;
                      i12 = i2;
                      i11 = i3;
                      localObject15 = localObject2;
                      localObject14 = localObject3;
                      localObject13 = localObject4;
                      localObject12 = localObject5;
                      bool5 = bool4;
                      localObject11 = localObject7;
                      localObject10 = localObject8;
                      i10 = i8;
                      i8 = i5;
                      i20 = i4;
                      localObject1 = EffectConfigBase.a(287, EffectConfigBase.c).edit();
                      ((SharedPreferences.Editor)localObject1).putInt("isBlueToothSwitch", i18);
                      ((SharedPreferences.Editor)localObject1).putLong("bluetoothDelayTime", l2);
                      ((SharedPreferences.Editor)localObject1).putBoolean("LowlightAndDenoiseDevice", bool8);
                      ((SharedPreferences.Editor)localObject1).putInt("multiVideoSupportNumbers", i17);
                      ((SharedPreferences.Editor)localObject1).putInt("SpeedDialScreenStyle", i16);
                      ((SharedPreferences.Editor)localObject1).putBoolean("switchMultiForceUseGroup", bool7);
                      ((SharedPreferences.Editor)localObject1).putString("switchMultiForceUseGroupAlertTip", (String)localObject16);
                      ((SharedPreferences.Editor)localObject1).putInt("useRGB2I420Shader", i14);
                      ((SharedPreferences.Editor)localObject1).putBoolean("isSharpnessSwitch", bool6);
                      ((SharedPreferences.Editor)localObject1).putInt("sharpnessFPSThreshold", i15);
                      ((SharedPreferences.Editor)localObject1).putInt("useAADSDeJitterAlgorithmUin", i13);
                      ((SharedPreferences.Editor)localObject1).putInt("enableAADSDeJitterMaxJDelayUin", i12);
                      ((SharedPreferences.Editor)localObject1).putInt("upLoadWhenGetNewData", i11);
                      ((SharedPreferences.Editor)localObject1).putString("ptuNewRenderLimit", (String)localObject15);
                      ((SharedPreferences.Editor)localObject1).putString("moreBtnTips", (String)localObject14);
                      ((SharedPreferences.Editor)localObject1).putString("ptuAfterTreamentLimit", (String)localObject13);
                      ((SharedPreferences.Editor)localObject1).putString("ptuAfterTreamentCanvas", (String)localObject12);
                      ((SharedPreferences.Editor)localObject1).putBoolean("isAllowedControlMicAfterBeMuted", bool5);
                      ((SharedPreferences.Editor)localObject1).putString("machineMiddleLine", (String)localObject11);
                      ((SharedPreferences.Editor)localObject1).putString("machineHighLine", (String)localObject10);
                      ((SharedPreferences.Editor)localObject1).putInt("allowMicLongPressSpeakInMute", i10);
                      if (i9 != -1) {
                        ((SharedPreferences.Editor)localObject1).putInt("qavWatchTogetherSwitch", i9);
                      }
                      ((SharedPreferences.Editor)localObject1).putInt("ScreenShareSwitch", i8);
                      ((SharedPreferences.Editor)localObject1).putInt("AskScreenShareSwitch", i19);
                      if (i20 != -1) {
                        ((SharedPreferences.Editor)localObject1).putInt("avGameResultUseWebSwitch", i20);
                      }
                      ((SharedPreferences.Editor)localObject1).commit();
                      if (QLog.isColorLevel()) {
                        QLog.i("QAVConfigUtils", 2, "parseAndSave [" + paramString + "]");
                      }
                      return;
                      bool3 = false;
                      break label5093;
                      localException1 = localException1;
                      j = 1;
                      k = -1;
                      m = -1;
                      localObject10 = "";
                      localObject2 = "";
                      bool1 = false;
                      localObject3 = "";
                      localObject4 = "";
                      localObject5 = "";
                      localObject6 = "";
                      n = -1;
                      i1 = -1;
                      i2 = -1;
                      i3 = -1;
                      i = 0;
                      bool2 = false;
                      i4 = 7;
                      l1 = l2;
                      bool3 = bool5;
                      localObject7 = localObject1;
                      localObject1 = localObject10;
                      i19 = i;
                      i20 = i21;
                      i8 = j;
                      i9 = k;
                      i10 = m;
                      localObject10 = localObject1;
                      localObject11 = localObject2;
                      bool5 = bool1;
                      localObject12 = localObject3;
                      localObject13 = localObject4;
                      localObject14 = localObject5;
                      localObject15 = localObject6;
                      i11 = n;
                      i12 = i1;
                      i13 = i2;
                      i14 = i3;
                      i15 = i4;
                      bool6 = bool2;
                      localObject16 = localObject7;
                      bool7 = bool4;
                      i16 = i7;
                      i17 = i6;
                      bool8 = bool3;
                      i18 = i5;
                      l2 = l1;
                      if (!QLog.isColorLevel()) {
                        continue;
                      }
                      QLog.i("handleGetQAVGeneralConfig", 2, " parse json: " + QLog.getStackTraceString(localException1));
                      i19 = i;
                      i20 = i21;
                      i8 = j;
                      i9 = k;
                      i10 = m;
                      localObject10 = localObject1;
                      localObject11 = localObject2;
                      bool5 = bool1;
                      localObject12 = localObject3;
                      localObject13 = localObject4;
                      localObject14 = localObject5;
                      localObject15 = localObject6;
                      i11 = n;
                      i12 = i1;
                      i13 = i2;
                      i14 = i3;
                      i15 = i4;
                      bool6 = bool2;
                      localObject16 = localObject7;
                      bool7 = bool4;
                      i16 = i7;
                      i17 = i6;
                      bool8 = bool3;
                      i18 = i5;
                      l2 = l1;
                      continue;
                      localException2 = localException2;
                      i5 = i;
                      k = -1;
                      m = -1;
                      localObject10 = "";
                      localObject2 = "";
                      bool1 = false;
                      localObject3 = "";
                      localObject4 = "";
                      localObject5 = "";
                      localObject6 = "";
                      n = -1;
                      i1 = -1;
                      i2 = -1;
                      i3 = -1;
                      i = 0;
                      j = 1;
                      localObject7 = localObject1;
                      i4 = 7;
                      bool2 = false;
                      localObject1 = localObject10;
                      bool3 = bool5;
                      l1 = l3;
                      continue;
                      localException3 = localException3;
                      bool3 = bool1;
                      i5 = i;
                      m = -1;
                      localObject10 = "";
                      localObject2 = "";
                      bool1 = false;
                      localObject3 = "";
                      localObject4 = "";
                      localObject5 = "";
                      localObject6 = "";
                      n = -1;
                      i1 = -1;
                      i2 = -1;
                      i3 = -1;
                      i = 0;
                      j = 1;
                      k = -1;
                      i4 = 7;
                      bool2 = false;
                      localObject7 = localObject1;
                      localObject1 = localObject10;
                      continue;
                      localException4 = localException4;
                      i6 = j;
                      bool3 = bool1;
                      i5 = i;
                      localObject10 = "";
                      localObject2 = "";
                      bool1 = false;
                      localObject3 = "";
                      localObject4 = "";
                      localObject5 = "";
                      localObject6 = "";
                      n = -1;
                      i1 = -1;
                      i2 = -1;
                      i3 = -1;
                      i = 0;
                      j = 1;
                      k = -1;
                      m = -1;
                      localObject7 = localObject1;
                      i4 = 7;
                      bool2 = false;
                      localObject1 = localObject10;
                      continue;
                      localException5 = localException5;
                      i7 = k;
                      i6 = j;
                      bool3 = bool1;
                      i5 = i;
                      localObject2 = "";
                      bool1 = false;
                      localObject3 = "";
                      localObject4 = "";
                      localObject5 = "";
                      localObject6 = "";
                      n = -1;
                      i1 = -1;
                      i2 = -1;
                      i3 = -1;
                      i = 0;
                      j = 1;
                      k = -1;
                      m = -1;
                      localObject10 = "";
                      i4 = 7;
                      bool2 = false;
                      localObject7 = localObject1;
                      localObject1 = localObject10;
                      continue;
                      localException6 = localException6;
                      bool4 = bool2;
                      i7 = k;
                      i6 = j;
                      bool3 = bool1;
                      i5 = i;
                      bool1 = false;
                      localObject3 = "";
                      localObject4 = "";
                      localObject5 = "";
                      localObject6 = "";
                      n = -1;
                      i1 = -1;
                      i2 = -1;
                      i3 = -1;
                      i = 0;
                      j = 1;
                      k = -1;
                      m = -1;
                      localObject10 = "";
                      localObject2 = "";
                      bool2 = false;
                      localObject7 = localObject1;
                      i4 = 7;
                      localObject1 = localObject10;
                      continue;
                    }
                  }
                  catch (Exception localException7)
                  {
                    i4 = 7;
                    bool5 = false;
                    localObject7 = localObject1;
                    bool4 = bool2;
                    i7 = k;
                    i6 = j;
                    bool3 = bool1;
                    i5 = i;
                    localObject5 = "";
                    localObject6 = "";
                    n = -1;
                    i1 = -1;
                    i2 = -1;
                    i3 = -1;
                    i = 0;
                    j = 1;
                    k = -1;
                    m = -1;
                    localObject1 = "";
                    localObject2 = "";
                    bool1 = false;
                    localObject3 = "";
                    localObject4 = "";
                    bool2 = bool5;
                    continue;
                    m = -1;
                    continue;
                  }
                  continue;
                }
                continue;
              }
              k = 0;
              continue;
            }
            j = -1;
            continue;
          }
          bool1 = true;
          continue;
        }
        continue;
      }
      i8 = 1;
      i9 = -1;
      i10 = -1;
      String str = "";
      Object localObject11 = "";
      bool5 = false;
      Object localObject12 = "";
      Object localObject13 = "";
      Object localObject14 = "";
      localObject15 = "";
      i11 = -1;
      int i12 = -1;
      int i13 = -1;
      int i14 = -1;
      int i19 = 0;
      boolean bool6 = false;
      int i15 = 7;
      int i20 = i21;
      Object localObject16 = localObject1;
      bool7 = bool2;
      i16 = j;
      i17 = i6;
      bool8 = bool1;
      i18 = i;
    }
  }
  
  public static boolean a()
  {
    boolean bool2 = true;
    boolean bool1 = true;
    if (-1 != jdField_a_of_type_Int) {
      return jdField_a_of_type_Int == 1;
    }
    for (;;)
    {
      try
      {
        if (-1 == jdField_a_of_type_Int) {
          break;
        }
        if (jdField_a_of_type_Int == 1) {
          return bool1;
        }
      }
      finally {}
      bool1 = false;
    }
    SharedPreferences localSharedPreferences = EffectConfigBase.a(287, EffectConfigBase.c);
    jdField_a_of_type_Int = localSharedPreferences.getInt("isBlueToothSwitch", 1);
    jdField_a_of_type_Long = localSharedPreferences.getLong("bluetoothDelayTime", 1000L);
    if (jdField_a_of_type_Int == 1) {}
    for (bool1 = bool2;; bool1 = false) {
      return bool1;
    }
  }
  
  public static boolean a(long paramLong)
  {
    boolean bool = false;
    int i = EffectConfigBase.a(287, EffectConfigBase.c).getInt("useAADSDeJitterAlgorithmUin", -1);
    if (i <= -1) {}
    for (;;)
    {
      QLog.i("QAVConfigUtils", 1, "JTest. read useAADSDeJitterAlgorithmUin = " + i + ", useAADSDeJitterAlgorithm = " + bool);
      return bool;
      if (paramLong % 10L <= i) {
        bool = true;
      }
    }
  }
  
  public static int b()
  {
    if (f == -1) {
      f = EffectConfigBase.a(287, EffectConfigBase.c).getInt("sharpnessFPSThreshold", 7);
    }
    return f * 10;
  }
  
  public static boolean b()
  {
    if (jdField_b_of_type_Int == -1) {
      if (!EffectConfigBase.a(287, EffectConfigBase.c).getBoolean("LowlightAndDenoiseDevice", true)) {
        break label41;
      }
    }
    label41:
    for (jdField_b_of_type_Int = 1; jdField_b_of_type_Int == 1; jdField_b_of_type_Int = 0) {
      return true;
    }
    return false;
  }
  
  public static boolean b(long paramLong)
  {
    boolean bool = false;
    int i = EffectConfigBase.a(287, EffectConfigBase.c).getInt("enableAADSDeJitterMaxJDelayUin", -1);
    if (i <= -1) {}
    for (;;)
    {
      QLog.i("QAVConfigUtils", 1, "JTest. read enableAADSDeJitterMaxJDelayUin = " + i + ", enableAADSDeJitterMaxJDelay = " + bool);
      return bool;
      if (paramLong % 10L <= i) {
        bool = true;
      }
    }
  }
  
  public static boolean c()
  {
    boolean bool = false;
    if (jdField_d_of_type_Int == -1) {
      jdField_d_of_type_Int = EffectConfigBase.a(287, EffectConfigBase.c).getInt("SpeedDialScreenStyle", 0);
    }
    if (jdField_d_of_type_Int == 0) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean d()
  {
    if (e == -1) {
      e = EffectConfigBase.a(287, EffectConfigBase.c).getInt("allowMicLongPressSpeakInMute", 0);
    }
    return e == 1;
  }
  
  public static boolean e()
  {
    boolean bool2 = false;
    if (jdField_a_of_type_JavaLangBoolean == null)
    {
      SharedPreferences localSharedPreferences = EffectConfigBase.a(287, EffectConfigBase.c);
      boolean bool1 = bool2;
      if (Build.VERSION.SDK_INT >= 19)
      {
        bool1 = bool2;
        if (localSharedPreferences.getBoolean("isSharpnessSwitch", false)) {
          bool1 = true;
        }
      }
      jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(bool1);
    }
    return jdField_a_of_type_JavaLangBoolean.booleanValue();
  }
  
  public static boolean f()
  {
    a();
    return jdField_b_of_type_JavaLangBoolean.booleanValue();
  }
  
  public static boolean g()
  {
    if (g == -1) {
      g = EffectConfigBase.a(287, EffectConfigBase.c).getInt("useRGB2I420Shader", 0);
    }
    return g == 1;
  }
  
  public static boolean h()
  {
    if (h == -1) {
      h = EffectConfigBase.a(287, EffectConfigBase.c).getInt("upLoadWhenGetNewData", 0);
    }
    return h == 1;
  }
  
  public static boolean i()
  {
    boolean bool = EffectConfigBase.a(287, EffectConfigBase.c).getBoolean("isAllowedControlMicAfterBeMuted", false);
    QLog.i("QAVConfigUtils", 1, "JTest. read isAllowedControlMicAfterBeMuted = " + bool);
    return bool;
  }
  
  public static boolean j()
  {
    if (WTogetherUtil.a()) {
      if (jdField_a_of_type_JavaLangInteger == null)
      {
        jdField_a_of_type_JavaLangInteger = Integer.valueOf(EffectConfigBase.a(287, EffectConfigBase.c).getInt("qavWatchTogetherSwitch", 1));
        QLog.i("WTogether", 1, "isQavWatchTogetherOpen, switch[" + jdField_a_of_type_JavaLangInteger + "]");
      }
    }
    while (jdField_a_of_type_JavaLangInteger.intValue() != 0)
    {
      return true;
      jdField_a_of_type_JavaLangInteger = Integer.valueOf(0);
    }
    return false;
  }
  
  public static boolean k()
  {
    if (jdField_b_of_type_JavaLangInteger == null)
    {
      jdField_b_of_type_JavaLangInteger = Integer.valueOf(EffectConfigBase.a(287, EffectConfigBase.c).getInt("ScreenShareSwitch", 1));
      QLog.i("WTogether", 1, "isQavScreenShareOpen, switch[" + jdField_b_of_type_JavaLangInteger + "]");
    }
    return jdField_b_of_type_JavaLangInteger.intValue() != 0;
  }
  
  public static boolean l()
  {
    if (jdField_c_of_type_JavaLangInteger == null)
    {
      jdField_c_of_type_JavaLangInteger = Integer.valueOf(EffectConfigBase.a(287, EffectConfigBase.c).getInt("AskScreenShareSwitch", 1));
      QLog.i("WTogether", 1, "isQavScreenShareOpen, switch[" + jdField_c_of_type_JavaLangInteger + "]");
    }
    return jdField_c_of_type_JavaLangInteger.intValue() != 0;
  }
  
  public static boolean m()
  {
    if (jdField_d_of_type_JavaLangInteger == null)
    {
      jdField_d_of_type_JavaLangInteger = Integer.valueOf(EffectConfigBase.a(287, EffectConfigBase.c).getInt("avGameResultUseWebSwitch", 0));
      QLog.i("QAVConfigUtils", 1, "isAVGameResultWebOpen, switch[" + jdField_d_of_type_JavaLangInteger + "]");
    }
    return jdField_d_of_type_JavaLangInteger.intValue() != 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.utils.QAVConfigUtils
 * JD-Core Version:    0.7.0.1
 */