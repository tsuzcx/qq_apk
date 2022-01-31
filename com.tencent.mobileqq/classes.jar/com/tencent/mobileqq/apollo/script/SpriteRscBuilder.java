package com.tencent.mobileqq.apollo.script;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.mobileqq.apollo.ApolloManager;
import com.tencent.mobileqq.apollo.data.ApolloRoleInfo;
import com.tencent.mobileqq.apollo.store.ApolloResDownloader;
import com.tencent.mobileqq.apollo.task.ApolloActionHelper;
import com.tencent.mobileqq.apollo.utils.ApolloConstant;
import com.tencent.mobileqq.apollo.utils.ApolloDaoManager;
import com.tencent.mobileqq.apollo.utils.ApolloGameBasicEventUtil;
import com.tencent.mobileqq.apollo.utils.ApolloGameBasicEventUtil.NotifyDressReady;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.utils.ApolloContentUpdateHandler;
import com.tencent.mobileqq.data.ApolloActionData;
import com.tencent.mobileqq.data.ApolloBaseInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vas.VasExtensionHandler;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

public class SpriteRscBuilder
{
  static Map jdField_a_of_type_JavaUtilMap = new HashMap();
  int jdField_a_of_type_Int = -1;
  private SpriteContext jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext;
  int jdField_b_of_type_Int = -1;
  Map jdField_b_of_type_JavaUtilMap = new HashMap();
  Map c = new ConcurrentHashMap(2);
  private Map d = new HashMap();
  
  public SpriteRscBuilder(SpriteContext paramSpriteContext)
  {
    this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext = paramSpriteContext;
  }
  
  private SpriteRscBuilder.ApolloAppearAction a(QQAppInterface paramQQAppInterface, String paramString)
  {
    int j = 0;
    if ((TextUtils.isEmpty(paramString)) || (paramQQAppInterface == null)) {
      return null;
    }
    if (this.jdField_b_of_type_JavaUtilMap.containsKey(paramString)) {}
    Object localObject1;
    Object localObject2;
    for (int i = ((Integer)this.jdField_b_of_type_JavaUtilMap.get(paramString)).intValue();; i = 0)
    {
      localObject1 = (ApolloManager)paramQQAppInterface.getManager(152);
      localObject2 = ((ApolloManager)localObject1).a(paramQQAppInterface, paramString);
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        break;
      }
      return null;
    }
    for (;;)
    {
      try
      {
        Object localObject3 = new JSONArray((String)localObject2);
        if (((JSONArray)localObject3).length() <= 0) {
          return null;
        }
        if (i >= ((JSONArray)localObject3).length())
        {
          i = j;
          localObject2 = new SpriteRscBuilder.ApolloAppearAction(this);
          localObject3 = ((JSONArray)localObject3).getJSONObject(i);
          ((SpriteRscBuilder.ApolloAppearAction)localObject2).jdField_b_of_type_Int = ((JSONObject)localObject3).getInt("type");
          ((SpriteRscBuilder.ApolloAppearAction)localObject2).jdField_a_of_type_Int = ((JSONObject)localObject3).getInt("id");
          localObject3 = ((ApolloManager)localObject1).b(paramString);
          if (localObject3 == null) {
            return null;
          }
          if ((((SpriteRscBuilder.ApolloAppearAction)localObject2).jdField_b_of_type_Int == 4) && (!((ApolloBaseInfo)localObject3).hasPet))
          {
            ((ApolloBaseInfo)localObject3).appearAction = null;
            ((ApolloManager)localObject1).a((ApolloBaseInfo)localObject3);
            return null;
          }
          if (QLog.isColorLevel()) {
            QLog.d("cmshow_scripted_SpriteRscBuilder", 2, new Object[] { "[hasAppearAction] index:", Integer.valueOf(i), ",id:", Integer.valueOf(((SpriteRscBuilder.ApolloAppearAction)localObject2).jdField_a_of_type_Int), ",standType:", Integer.valueOf(((SpriteRscBuilder.ApolloAppearAction)localObject2).jdField_b_of_type_Int) });
          }
          if (((SpriteRscBuilder.ApolloAppearAction)localObject2).jdField_a_of_type_Int <= 0)
          {
            QLog.e("cmshow_scripted_SpriteRscBuilder", 1, new Object[] { "appearAction not correct,actionId:", Integer.valueOf(((SpriteRscBuilder.ApolloAppearAction)localObject2).jdField_a_of_type_Int) });
            return null;
          }
          if (!ApolloUtil.a(((SpriteRscBuilder.ApolloAppearAction)localObject2).jdField_a_of_type_Int, 0))
          {
            if (QLog.isColorLevel()) {
              QLog.i("cmshow_scripted_SpriteRscBuilder", 2, "hasAppearAction isActionResDone is false.");
            }
            paramString = new ApolloActionData();
            paramString.actionId = ((SpriteRscBuilder.ApolloAppearAction)localObject2).jdField_a_of_type_Int;
            localObject1 = ApolloUtil.a(paramString, 5);
            ApolloResDownloader.a(paramQQAppInterface, ApolloUtil.a(paramString, 4), (String)localObject1);
            return null;
          }
          this.jdField_b_of_type_JavaUtilMap.put(paramString, Integer.valueOf(i + 1));
          return localObject2;
        }
      }
      catch (Exception paramQQAppInterface)
      {
        QLog.e("cmshow_scripted_SpriteRscBuilder", 2, "hasAppearAction error:", paramQQAppInterface);
        return null;
      }
    }
  }
  
  private SpriteTaskParam a(SpriteRscBuilder.ApolloAppearAction paramApolloAppearAction)
  {
    SpriteTaskParam localSpriteTaskParam = new SpriteTaskParam();
    if (paramApolloAppearAction == null)
    {
      localSpriteTaskParam.f = 4;
      localSpriteTaskParam.k = 2;
      localSpriteTaskParam.g = 5;
      localSpriteTaskParam.jdField_a_of_type_Long = 1000000L;
    }
    do
    {
      return localSpriteTaskParam;
      localSpriteTaskParam.jdField_a_of_type_Int = 1;
      localSpriteTaskParam.f = paramApolloAppearAction.jdField_a_of_type_Int;
      localSpriteTaskParam.k = 12;
      localSpriteTaskParam.g = 5;
      localSpriteTaskParam.jdField_a_of_type_Long = 1000000L;
    } while (paramApolloAppearAction.jdField_b_of_type_Int != 4);
    localSpriteTaskParam.jdField_c_of_type_Int = 7;
    return localSpriteTaskParam;
  }
  
  private String a(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext == null) || (this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a() == null)) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    paramInt = ((ApolloManager)this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a().getManager(152)).a(paramInt);
    if ((paramInt != -1) && (!ApolloUtil.a(paramInt, 0)))
    {
      if (QLog.isColorLevel()) {
        QLog.i("ApolloPet", 2, "download random pet action:" + paramInt);
      }
      Object localObject = new ApolloActionData();
      ((ApolloActionData)localObject).actionId = paramInt;
      String str = ApolloUtil.a((ApolloActionData)localObject, 5);
      localObject = ApolloUtil.a((ApolloActionData)localObject, 4);
      ApolloResDownloader.a(this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a(), (String)localObject, str);
    }
    for (;;)
    {
      return localStringBuilder.toString();
      if (paramInt != -1) {
        localStringBuilder.append("action/").append(paramInt).append("/action/action");
      }
    }
  }
  
  public static String a(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    if (paramQQAppInterface == null) {
      return "";
    }
    ApolloManager localApolloManager = (ApolloManager)paramQQAppInterface.getManager(152);
    int i;
    if (paramString.equals(paramQQAppInterface.getCurrentAccountUin())) {
      if ((localApolloManager != null) && (localApolloManager.a(paramString)))
      {
        if ((!ApolloUtil.c(0, 28)) && (!ApolloUtil.c(paramInt, 28))) {
          break label121;
        }
        i = 28;
      }
    }
    for (;;)
    {
      return ApolloActionHelper.b(paramInt, i);
      i = 25;
      continue;
      if ((localApolloManager != null) && (localApolloManager.a(paramString)))
      {
        if ((ApolloUtil.c(0, 30)) || (ApolloUtil.c(paramInt, 30))) {
          i = 30;
        }
      }
      else
      {
        i = 26;
        continue;
      }
      label121:
      i = 0;
    }
  }
  
  public static String a(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    int i = ApolloUtil.a(208.0F, paramString);
    if ((!ApolloUtil.c(paramInt, i)) && (!ApolloUtil.c(0, i))) {
      return "";
    }
    return ApolloActionHelper.b(paramInt, i);
  }
  
  public static String a(String paramString, int paramInt1, int paramInt2)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    if ((!ApolloUtil.c(paramInt1, paramInt2)) && (!ApolloUtil.c(0, paramInt2))) {
      return "";
    }
    return ApolloActionHelper.b(paramInt1, paramInt2);
  }
  
  static String a(String paramString, int paramInt, boolean paramBoolean)
  {
    int i = 0;
    StringBuilder localStringBuilder = new StringBuilder("def/role/0/Bubble/");
    if (paramString == null) {
      return null;
    }
    for (;;)
    {
      try
      {
        paramString = new JSONArray(paramString);
        int j = paramString.length();
        if (i < j)
        {
          JSONObject localJSONObject = paramString.getJSONObject(i);
          int k = localJSONObject.optInt("roleId", -1);
          if ((k == -1) || (k != paramInt)) {
            continue;
          }
          if (!paramBoolean) {
            continue;
          }
          paramString = "namePlateIdRight";
          localStringBuilder.append(localJSONObject.optInt(paramString, 0));
        }
        localStringBuilder.append("/dress");
      }
      catch (Exception paramString)
      {
        QLog.e("ApolloPet", 1, "getPetNamePlate error:", paramString);
        continue;
      }
      return localStringBuilder.toString();
      paramString = "namePlateIdLeft";
      continue;
      i += 1;
    }
  }
  
  private JSONArray a(SpriteTaskParam paramSpriteTaskParam)
  {
    if ((paramSpriteTaskParam == null) || (this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext == null)) {
      return null;
    }
    long l1 = System.currentTimeMillis();
    for (;;)
    {
      try
      {
        JSONArray localJSONArray = new JSONArray();
        JSONObject localJSONObject2 = a(paramSpriteTaskParam.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext, paramSpriteTaskParam, true, false);
        if ((this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.jdField_a_of_type_Int == 0) || (paramSpriteTaskParam.e == 1))
        {
          localJSONObject1 = a(paramSpriteTaskParam.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext, paramSpriteTaskParam, false, false);
          if (localJSONObject2 != null)
          {
            localJSONArray.put(localJSONObject2);
            JSONObject localJSONObject3 = a(paramSpriteTaskParam.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext, true);
            if (localJSONObject3 != null) {
              localJSONObject2.put("pet", localJSONObject3);
            }
          }
          if (localJSONObject1 != null)
          {
            localJSONArray.put(localJSONObject1);
            paramSpriteTaskParam = a(paramSpriteTaskParam.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext, false);
            if (paramSpriteTaskParam != null) {
              localJSONObject1.put("pet", paramSpriteTaskParam);
            }
          }
          return localJSONArray;
        }
      }
      catch (Throwable paramSpriteTaskParam)
      {
        QLog.e("cmshow_scripted_SpriteRscBuilder", 1, "[getBasicActionJs],", paramSpriteTaskParam);
        return null;
      }
      finally
      {
        long l2 = System.currentTimeMillis();
        if (QLog.isColorLevel()) {
          QLog.d("cmshow_scripted_SpriteRscBuilder", 2, new Object[] { "[getBasicActionJs], cost:", Long.valueOf(l2 - l1) });
        }
      }
      JSONObject localJSONObject1 = null;
    }
  }
  
  public static JSONArray a(QQAppInterface paramQQAppInterface, JSONObject paramJSONObject)
  {
    if ((paramJSONObject == null) || (paramQQAppInterface == null)) {
      return null;
    }
    if (QLog.isColorLevel()) {
      QLog.d("cmshow_scripted_SpriteRscBuilder", 2, "[getActionJson]");
    }
    for (;;)
    {
      JSONArray localJSONArray1;
      int j;
      boolean bool2;
      try
      {
        localJSONArray1 = new JSONArray();
        paramJSONObject = paramJSONObject.optString("actionList");
        JSONArray localJSONArray2 = new JSONArray(paramJSONObject);
        if ((localJSONArray2 == null) || (localJSONArray2.length() == 0)) {
          break label496;
        }
        if (QLog.isColorLevel()) {
          QLog.d("cmshow_scripted_SpriteRscBuilder", 2, new Object[] { "ReqAction,", paramJSONObject });
        }
        ApolloDaoManager localApolloDaoManager = (ApolloDaoManager)paramQQAppInterface.getManager(154);
        int i = 0;
        j = 0;
        if (j < localJSONArray2.length())
        {
          paramJSONObject = localJSONArray2.getJSONObject(j);
          if (paramJSONObject == null) {
            break label499;
          }
          int k = paramJSONObject.optInt("actionId");
          int m = paramJSONObject.optInt("perNum");
          if (QLog.isColorLevel()) {
            QLog.d("cmshow_scripted_SpriteRscBuilder", 2, new Object[] { "ReqAction,actId:", Integer.valueOf(k), ",perNum:", Integer.valueOf(m) });
          }
          if (-1 == m)
          {
            paramJSONObject = localApolloDaoManager.a(k);
            if (paramJSONObject != null) {
              break label493;
            }
            QLog.i("cmshow_scripted_SpriteRscBuilder", 1, "ReqAction,[getActionsPath], warning: data is null. call checkApolloPanelJsonVer, id:" + k);
            if (i == 0)
            {
              ApolloContentUpdateHandler.a(paramQQAppInterface, 1);
              i = 1;
              break label499;
            }
          }
          else
          {
            paramJSONObject = new ApolloActionData();
            paramJSONObject.actionId = k;
            paramJSONObject.personNum = m;
            bool2 = ApolloUtil.a(k, paramJSONObject.personNum);
            Object localObject = (ApolloManager)paramQQAppInterface.getManager(152);
            if (bool2) {
              break label487;
            }
            bool1 = ((ApolloManager)localObject).a(paramJSONObject, 4, null);
            if (!QLog.isColorLevel()) {
              break label506;
            }
            QLog.d("cmshow_scripted_SpriteRscBuilder", 2, new Object[] { "ReqAction,isActionDone:", Boolean.valueOf(bool2), ",ret:", Boolean.valueOf(bool1) });
            break label506;
            localObject = new JSONObject();
            String[] arrayOfString = ApolloActionHelper.a(1, k, 0, true);
            ((JSONObject)localObject).put("actionId", k);
            ((JSONObject)localObject).put("actionPath", arrayOfString[0]);
            if (paramJSONObject.personNum == 1) {
              ((JSONObject)localObject).put("peerPath", ApolloActionHelper.a(1, k, 0, false)[0]);
            }
            localJSONArray1.put(localObject);
            if (QLog.isColorLevel()) {
              QLog.d("cmshow_scripted_SpriteRscBuilder", 2, new Object[] { "ReqAction,put into array, id:", Integer.valueOf(k) });
            }
          }
          break label499;
        }
        else
        {
          return localJSONArray1;
        }
      }
      catch (Throwable paramQQAppInterface)
      {
        QLog.e("cmshow_scripted_SpriteRscBuilder", 1, paramQQAppInterface, new Object[0]);
        return null;
      }
      label487:
      boolean bool1 = false;
      continue;
      label493:
      continue;
      label496:
      return localJSONArray1;
      label499:
      j += 1;
      continue;
      label506:
      if (!bool2) {
        if (!bool1) {}
      }
    }
  }
  
  private JSONObject a(int paramInt1, int paramInt2)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      Object localObject = new SpriteTaskParam();
      ((SpriteTaskParam)localObject).f = paramInt1;
      ((SpriteTaskParam)localObject).jdField_d_of_type_Int = paramInt2;
      ((SpriteTaskParam)localObject).h = this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.jdField_a_of_type_Int;
      ((SpriteTaskParam)localObject).jdField_c_of_type_Int = 1;
      if (!a((SpriteTaskParam)localObject)) {
        return null;
      }
      localObject = ((ApolloDaoManager)this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a().getManager(154)).a(paramInt1);
      if (localObject == null) {
        return null;
      }
      localJSONObject.put("actionId", paramInt1);
      localJSONObject.put("action", ApolloActionHelper.a(paramInt1, paramInt2, true, this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a())[0]);
      if (((ApolloActionData)localObject).personNum == 1) {
        localJSONObject.put("actionPeer", ApolloActionHelper.a(paramInt1, paramInt2, false, this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a())[0]);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.jdField_a_of_type_Int == 0)
      {
        localJSONObject.put("actionDis", ((ApolloActionData)localObject).actionMoveDis * (float)DeviceInfoUtil.k() / 7.0F / 368.0F);
        localJSONObject.put("actionPeerDis", ((ApolloActionData)localObject).peerMoveDis * (float)DeviceInfoUtil.k() / 7.0F / 368.0F);
      }
      else
      {
        localJSONObject.put("posType", ((ApolloActionData)localObject).playArea);
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("cmshow_scripted_SpriteRscBuilder", 1, "[getWhiteFaceSingleAction],", localThrowable);
      return null;
    }
    return localThrowable;
  }
  
  private JSONObject a(String paramString, SpriteContext paramSpriteContext)
  {
    JSONObject localJSONObject;
    try
    {
      localJSONObject = new JSONObject();
      localJSONObject.put("uin", paramString);
      Object localObject = ApolloActionHelper.a(paramString, paramSpriteContext.a());
      if ((localObject != null) && (localObject.length == 2))
      {
        int j = ((Integer)localObject[0]).intValue();
        localObject = (int[])localObject[1];
        if ((localObject != null) && (localObject.length != 0))
        {
          JSONArray localJSONArray = new JSONArray();
          int k = localObject.length;
          int i = 0;
          while (i < k)
          {
            localJSONArray.put(ApolloActionHelper.a(1, Integer.valueOf(localObject[i]).intValue()));
            i += 1;
          }
          localJSONObject.put("dress", localJSONArray);
          localJSONObject.put("role", ApolloActionHelper.a(0, j));
          if (((paramSpriteContext.jdField_a_of_type_Int == 1) || (paramSpriteContext.jdField_a_of_type_Int == 3000)) && (!"-1".equals(paramString)) && (!"-2".equals(paramString)))
          {
            localJSONObject.put("nameplate", a(paramSpriteContext.a(), paramString, j));
            localObject = paramSpriteContext.jdField_b_of_type_JavaLangString;
            if ((TextUtils.isEmpty((CharSequence)localObject)) || (!((String)localObject).equals(paramString))) {
              break label344;
            }
          }
          label344:
          for (paramString = "我";; paramString = SpriteUtil.a(paramSpriteContext.a(), paramSpriteContext.jdField_a_of_type_Int, paramString, paramSpriteContext.jdField_a_of_type_JavaLangString, true))
          {
            if (!TextUtils.isEmpty(paramString)) {
              localJSONObject.put("nickname", SpriteUtil.a(Base64Util.encodeToString(paramString.getBytes("utf-8"), 0)));
            }
            if (this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.jdField_a_of_type_ComTencentMobileqqApolloDataApolloRoleInfo == null) {
              break;
            }
            localJSONObject.put("scale", this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.jdField_a_of_type_ComTencentMobileqqApolloDataApolloRoleInfo.jdField_a_of_type_Float);
            localJSONObject.put("xPos", this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.jdField_a_of_type_ComTencentMobileqqApolloDataApolloRoleInfo.b);
            localJSONObject.put("yPos", this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.jdField_a_of_type_ComTencentMobileqqApolloDataApolloRoleInfo.c);
            break;
          }
        }
      }
      else
      {
        return null;
      }
    }
    catch (Throwable paramString)
    {
      QLog.e("cmshow_scripted_SpriteRscBuilder", 1, paramString, new Object[0]);
      return null;
    }
    return null;
    return localJSONObject;
  }
  
  private JSONObject a(String paramString, SpriteContext paramSpriteContext, SpriteTaskParam paramSpriteTaskParam, boolean paramBoolean1, boolean paramBoolean2)
  {
    JSONObject localJSONObject;
    for (;;)
    {
      try
      {
        localJSONObject = a(paramString, paramSpriteContext);
        if (!a(paramSpriteTaskParam)) {
          return localJSONObject;
        }
        paramString = ApolloActionHelper.a(paramString, paramSpriteContext.a());
        if ((paramString == null) || (paramString.length != 2)) {
          break label249;
        }
        int j = ((Integer)paramString[0]).intValue();
        if (paramSpriteTaskParam == null) {
          break;
        }
        if (!paramBoolean1) {
          break label253;
        }
        i = 1;
        localJSONObject.put("isMaster", i);
        if ((paramBoolean1) && (!TextUtils.isEmpty(paramSpriteTaskParam.jdField_c_of_type_JavaLangString)))
        {
          localJSONObject.put("text", SpriteUtil.a(Base64Util.encodeToString(paramSpriteTaskParam.jdField_c_of_type_JavaLangString.getBytes("utf-8"), 0)));
          if (!paramSpriteTaskParam.jdField_b_of_type_Boolean)
          {
            localJSONObject.put("bubbleType", 0);
            localJSONObject.put("bubble", a(paramSpriteTaskParam.jdField_c_of_type_JavaLangString, j));
          }
        }
        else
        {
          paramString = ApolloActionHelper.a(paramSpriteTaskParam.k, paramSpriteTaskParam.f, j, paramBoolean1);
          if (paramString == null) {
            break label251;
          }
          if (paramString.length >= 2) {
            break label207;
          }
          break label251;
        }
        localJSONObject.put("bubbleType", 1);
        continue;
        if (paramSpriteTaskParam.e != 0) {
          break label234;
        }
      }
      catch (Throwable paramString)
      {
        QLog.e("cmshow_scripted_SpriteRscBuilder", 1, paramString, new Object[0]);
        return null;
      }
      label207:
      if ((paramSpriteContext.jdField_a_of_type_Int == 0) && (!paramBoolean1) && (!paramBoolean2)) {
        break;
      }
      label234:
      localJSONObject.put("action", paramString[0]);
      break;
      label249:
      return null;
      label251:
      return null;
      label253:
      int i = 0;
    }
    return localJSONObject;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt, int[] paramArrayOfInt, ApolloGameBasicEventUtil.NotifyDressReady paramNotifyDressReady)
  {
    if (paramArrayOfInt == null) {
      return;
    }
    int i;
    if (paramInt == 0)
    {
      QLog.i("cmshow_scripted_SpriteRscBuilder", 1, "role id is 0, uin:" + ApolloUtil.d(paramString));
      i = 1;
    }
    for (;;)
    {
      if (i != 0)
      {
        ApolloGameBasicEventUtil.a(-1L, paramQQAppInterface, paramString, "", 0, "", paramNotifyDressReady);
        return;
        i = 0;
        for (;;)
        {
          if (i >= paramArrayOfInt.length) {
            break label152;
          }
          if (!ApolloUtil.b(paramArrayOfInt[i]))
          {
            QLog.w("cmshow_scripted_SpriteRscBuilder", 2, "dress rsc NOT exist, id:" + paramArrayOfInt[i]);
            i = 1;
            break;
          }
          i += 1;
        }
      }
      if (paramNotifyDressReady == null) {
        break;
      }
      paramNotifyDressReady.a(-1L, paramQQAppInterface, paramString, "", "", paramInt, paramArrayOfInt, 10);
      return;
      label152:
      i = 0;
    }
  }
  
  public static void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      Object localObject = ApolloManager.a();
      if (localObject != null)
      {
        localObject = ((SharedPreferences)localObject).edit();
        if (localObject != null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("cmshow_scripted_SpriteRscBuilder", 2, "[clearAction] clear action success ");
          }
          ((SharedPreferences.Editor)localObject).remove(paramString).apply();
        }
      }
    }
  }
  
  private JSONArray b(SpriteTaskParam paramSpriteTaskParam)
  {
    if ((paramSpriteTaskParam == null) || (this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext == null)) {
      return null;
    }
    long l1 = System.currentTimeMillis();
    for (;;)
    {
      int k;
      int m;
      try
      {
        localJSONArray = new JSONArray();
        paramSpriteTaskParam = paramSpriteTaskParam.jdField_a_of_type_JavaUtilArrayList;
        localApolloDaoManager = (ApolloDaoManager)this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a().getManager(154);
        i = 0;
        k = 0;
        j = -1;
        if (k < paramSpriteTaskParam.size())
        {
          m = ((Integer)paramSpriteTaskParam.get(k)).intValue();
          if (-1 != j)
          {
            localObject = localApolloDaoManager.a(j);
            if ((localObject != null) && (((ApolloActionData)localObject).isHasPostAction()) && (j != m))
            {
              localObject = a(j, 2);
              if (localObject != null) {
                localJSONArray.put(localObject);
              }
            }
          }
          Object localObject = localApolloDaoManager.a(m);
          if (localObject != null)
          {
            if ((m != j) && (((ApolloActionData)localObject).isHasPreAction()))
            {
              localObject = a(m, 0);
              if (localObject != null) {
                localJSONArray.put(localObject);
              }
            }
            localObject = a(m, 1);
            if (localObject == null) {
              break label431;
            }
            localJSONArray.put(localObject);
            break label431;
          }
          j = -1;
          i = 1;
          QLog.i("cmshow_scripted_SpriteRscBuilder", 1, "[insertPrePost], action NOT exist locally, id:" + m);
        }
      }
      catch (Throwable paramSpriteTaskParam)
      {
        JSONArray localJSONArray;
        ApolloDaoManager localApolloDaoManager;
        int i;
        QLog.e("cmshow_scripted_SpriteRscBuilder", 1, "[getWhiteFaceActions],", paramSpriteTaskParam);
        return null;
        if (-1 != j)
        {
          paramSpriteTaskParam = localApolloDaoManager.a(j);
          if ((paramSpriteTaskParam != null) && (paramSpriteTaskParam.isHasPostAction()))
          {
            paramSpriteTaskParam = a(j, 2);
            if (paramSpriteTaskParam != null) {
              localJSONArray.put(paramSpriteTaskParam);
            }
          }
        }
        if (i != 0) {
          ApolloContentUpdateHandler.a(this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a(), 1);
        }
        return localJSONArray;
      }
      finally
      {
        long l2 = System.currentTimeMillis();
        if (QLog.isColorLevel()) {
          QLog.d("cmshow_scripted_SpriteRscBuilder", 2, new Object[] { "[getWhiteFaceActions], cost:", Long.valueOf(l2 - l1) });
        }
      }
      label431:
      int j = m;
      k += 1;
    }
  }
  
  /* Error */
  private JSONArray c(SpriteTaskParam paramSpriteTaskParam)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +10 -> 11
    //   4: aload_0
    //   5: getfield 40	com/tencent/mobileqq/apollo/script/SpriteRscBuilder:jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext	Lcom/tencent/mobileqq/apollo/script/SpriteContext;
    //   8: ifnonnull +7 -> 15
    //   11: aconst_null
    //   12: astore_1
    //   13: aload_1
    //   14: areturn
    //   15: invokestatic 287	java/lang/System:currentTimeMillis	()J
    //   18: lstore_2
    //   19: new 78	org/json/JSONArray
    //   22: dup
    //   23: invokespecial 288	org/json/JSONArray:<init>	()V
    //   26: astore 6
    //   28: aload_0
    //   29: getfield 40	com/tencent/mobileqq/apollo/script/SpriteRscBuilder:jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext	Lcom/tencent/mobileqq/apollo/script/SpriteContext;
    //   32: getfield 294	com/tencent/mobileqq/apollo/script/SpriteContext:jdField_a_of_type_Int	I
    //   35: ifne +161 -> 196
    //   38: aload_0
    //   39: aload_0
    //   40: getfield 40	com/tencent/mobileqq/apollo/script/SpriteRscBuilder:jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext	Lcom/tencent/mobileqq/apollo/script/SpriteContext;
    //   43: getfield 451	com/tencent/mobileqq/apollo/script/SpriteContext:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   46: aload_0
    //   47: getfield 40	com/tencent/mobileqq/apollo/script/SpriteRscBuilder:jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext	Lcom/tencent/mobileqq/apollo/script/SpriteContext;
    //   50: invokespecial 494	com/tencent/mobileqq/apollo/script/SpriteRscBuilder:a	(Ljava/lang/String;Lcom/tencent/mobileqq/apollo/script/SpriteContext;)Lorg/json/JSONObject;
    //   53: astore_1
    //   54: aload_0
    //   55: aload_0
    //   56: getfield 40	com/tencent/mobileqq/apollo/script/SpriteRscBuilder:jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext	Lcom/tencent/mobileqq/apollo/script/SpriteContext;
    //   59: getfield 489	com/tencent/mobileqq/apollo/script/SpriteContext:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   62: aload_0
    //   63: getfield 40	com/tencent/mobileqq/apollo/script/SpriteRscBuilder:jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext	Lcom/tencent/mobileqq/apollo/script/SpriteContext;
    //   66: invokespecial 494	com/tencent/mobileqq/apollo/script/SpriteRscBuilder:a	(Ljava/lang/String;Lcom/tencent/mobileqq/apollo/script/SpriteContext;)Lorg/json/JSONObject;
    //   69: astore 7
    //   71: aload_0
    //   72: aload_0
    //   73: getfield 40	com/tencent/mobileqq/apollo/script/SpriteRscBuilder:jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext	Lcom/tencent/mobileqq/apollo/script/SpriteContext;
    //   76: getfield 451	com/tencent/mobileqq/apollo/script/SpriteContext:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   79: aload_0
    //   80: getfield 40	com/tencent/mobileqq/apollo/script/SpriteRscBuilder:jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext	Lcom/tencent/mobileqq/apollo/script/SpriteContext;
    //   83: iconst_1
    //   84: invokevirtual 304	com/tencent/mobileqq/apollo/script/SpriteRscBuilder:a	(Ljava/lang/String;Lcom/tencent/mobileqq/apollo/script/SpriteContext;Z)Lorg/json/JSONObject;
    //   87: astore 8
    //   89: aload_0
    //   90: aload_0
    //   91: getfield 40	com/tencent/mobileqq/apollo/script/SpriteRscBuilder:jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext	Lcom/tencent/mobileqq/apollo/script/SpriteContext;
    //   94: getfield 489	com/tencent/mobileqq/apollo/script/SpriteContext:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   97: aload_0
    //   98: getfield 40	com/tencent/mobileqq/apollo/script/SpriteRscBuilder:jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext	Lcom/tencent/mobileqq/apollo/script/SpriteContext;
    //   101: iconst_0
    //   102: invokevirtual 304	com/tencent/mobileqq/apollo/script/SpriteRscBuilder:a	(Ljava/lang/String;Lcom/tencent/mobileqq/apollo/script/SpriteContext;Z)Lorg/json/JSONObject;
    //   105: astore 9
    //   107: aload 8
    //   109: ifnull +13 -> 122
    //   112: aload_1
    //   113: ldc_w 306
    //   116: aload 8
    //   118: invokevirtual 309	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   121: pop
    //   122: aload 9
    //   124: ifnull +14 -> 138
    //   127: aload 7
    //   129: ldc_w 306
    //   132: aload 9
    //   134: invokevirtual 309	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   137: pop
    //   138: aload 6
    //   140: aload_1
    //   141: invokevirtual 301	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   144: pop
    //   145: aload 6
    //   147: aload 7
    //   149: invokevirtual 301	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   152: pop
    //   153: invokestatic 287	java/lang/System:currentTimeMillis	()J
    //   156: lstore 4
    //   158: aload 6
    //   160: astore_1
    //   161: invokestatic 127	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   164: ifeq -151 -> 13
    //   167: ldc 129
    //   169: iconst_2
    //   170: iconst_2
    //   171: anewarray 4	java/lang/Object
    //   174: dup
    //   175: iconst_0
    //   176: ldc_w 580
    //   179: aastore
    //   180: dup
    //   181: iconst_1
    //   182: lload 4
    //   184: lload_2
    //   185: lsub
    //   186: invokestatic 316	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   189: aastore
    //   190: invokestatic 142	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   193: aload 6
    //   195: areturn
    //   196: aload_0
    //   197: aload_1
    //   198: getfield 290	com/tencent/mobileqq/apollo/script/SpriteTaskParam:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   201: aload_0
    //   202: getfield 40	com/tencent/mobileqq/apollo/script/SpriteRscBuilder:jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext	Lcom/tencent/mobileqq/apollo/script/SpriteContext;
    //   205: invokespecial 494	com/tencent/mobileqq/apollo/script/SpriteRscBuilder:a	(Ljava/lang/String;Lcom/tencent/mobileqq/apollo/script/SpriteContext;)Lorg/json/JSONObject;
    //   208: astore_1
    //   209: aload_0
    //   210: aload_0
    //   211: getfield 40	com/tencent/mobileqq/apollo/script/SpriteRscBuilder:jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext	Lcom/tencent/mobileqq/apollo/script/SpriteContext;
    //   214: getfield 451	com/tencent/mobileqq/apollo/script/SpriteContext:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   217: aload_0
    //   218: getfield 40	com/tencent/mobileqq/apollo/script/SpriteRscBuilder:jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext	Lcom/tencent/mobileqq/apollo/script/SpriteContext;
    //   221: iconst_1
    //   222: invokevirtual 304	com/tencent/mobileqq/apollo/script/SpriteRscBuilder:a	(Ljava/lang/String;Lcom/tencent/mobileqq/apollo/script/SpriteContext;Z)Lorg/json/JSONObject;
    //   225: astore 7
    //   227: aload 7
    //   229: ifnull +13 -> 242
    //   232: aload_1
    //   233: ldc_w 306
    //   236: aload 7
    //   238: invokevirtual 309	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   241: pop
    //   242: aload 6
    //   244: aload_1
    //   245: invokevirtual 301	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   248: pop
    //   249: goto -96 -> 153
    //   252: astore_1
    //   253: ldc 129
    //   255: iconst_1
    //   256: ldc_w 582
    //   259: aload_1
    //   260: invokestatic 181	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   263: invokestatic 287	java/lang/System:currentTimeMillis	()J
    //   266: lstore 4
    //   268: invokestatic 127	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   271: ifeq +29 -> 300
    //   274: ldc 129
    //   276: iconst_2
    //   277: iconst_2
    //   278: anewarray 4	java/lang/Object
    //   281: dup
    //   282: iconst_0
    //   283: ldc_w 580
    //   286: aastore
    //   287: dup
    //   288: iconst_1
    //   289: lload 4
    //   291: lload_2
    //   292: lsub
    //   293: invokestatic 316	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   296: aastore
    //   297: invokestatic 142	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   300: aconst_null
    //   301: areturn
    //   302: astore_1
    //   303: invokestatic 287	java/lang/System:currentTimeMillis	()J
    //   306: lstore 4
    //   308: invokestatic 127	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   311: ifeq +29 -> 340
    //   314: ldc 129
    //   316: iconst_2
    //   317: iconst_2
    //   318: anewarray 4	java/lang/Object
    //   321: dup
    //   322: iconst_0
    //   323: ldc_w 580
    //   326: aastore
    //   327: dup
    //   328: iconst_1
    //   329: lload 4
    //   331: lload_2
    //   332: lsub
    //   333: invokestatic 316	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   336: aastore
    //   337: invokestatic 142	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   340: aload_1
    //   341: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	342	0	this	SpriteRscBuilder
    //   0	342	1	paramSpriteTaskParam	SpriteTaskParam
    //   18	314	2	l1	long
    //   156	174	4	l2	long
    //   26	217	6	localJSONArray	JSONArray
    //   69	168	7	localJSONObject1	JSONObject
    //   87	30	8	localJSONObject2	JSONObject
    //   105	28	9	localJSONObject3	JSONObject
    // Exception table:
    //   from	to	target	type
    //   19	107	252	java/lang/Throwable
    //   112	122	252	java/lang/Throwable
    //   127	138	252	java/lang/Throwable
    //   138	153	252	java/lang/Throwable
    //   196	227	252	java/lang/Throwable
    //   232	242	252	java/lang/Throwable
    //   242	249	252	java/lang/Throwable
    //   19	107	302	finally
    //   112	122	302	finally
    //   127	138	302	finally
    //   138	153	302	finally
    //   196	227	302	finally
    //   232	242	302	finally
    //   242	249	302	finally
    //   253	263	302	finally
  }
  
  public Pair a(String paramString)
  {
    Object localObject = new Pair("def/basic/action/4/action/action", Integer.valueOf(0));
    if (TextUtils.isEmpty(paramString)) {
      return localObject;
    }
    StringBuilder localStringBuilder;
    if (a(this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a(), paramString))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("action").append("/").append(this.jdField_b_of_type_Int).append("/action/action");
      SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a().getApp().getSharedPreferences("apollo_sp", 0);
      if (!localSharedPreferences.getBoolean("stand_type_" + this.jdField_a_of_type_Int, false)) {}
      switch (this.jdField_a_of_type_Int)
      {
      default: 
        localObject = null;
        SpriteActionScript localSpriteActionScript = SpriteUtil.a(this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a());
        if ((!TextUtils.isEmpty((CharSequence)localObject)) && (localSpriteActionScript != null)) {
          localSpriteActionScript.a(paramString, (String)localObject);
        }
        localSharedPreferences.edit().putBoolean("stand_type_" + this.jdField_a_of_type_Int, true).commit();
        if (this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.jdField_a_of_type_Int == 3000)
        {
          i = 2;
          label250:
          VipUtils.a(null, "cmshow", "Apollo", "appearanceaction", i, this.jdField_a_of_type_Int, new String[] { String.valueOf(this.jdField_b_of_type_Int) });
          if (this.jdField_a_of_type_Int != 4) {
            break label344;
          }
        }
        break;
      }
    }
    label344:
    for (int i = 7;; i = 0)
    {
      return new Pair(localStringBuilder.toString(), Integer.valueOf(i));
      localObject = "这是我的小钻出场动作哦~";
      break;
      localObject = "这是我的炫卡出场动作哦~";
      break;
      localObject = "这是我的炫物出场动作哦~";
      break;
      i = this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.jdField_a_of_type_Int;
      break label250;
      return localObject;
    }
  }
  
  public String a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext == null) {
      return null;
    }
    try
    {
      JSONObject localJSONObject1 = new JSONObject();
      JSONArray localJSONArray = new JSONArray();
      JSONObject localJSONObject2;
      JSONObject localJSONObject3;
      if (this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.jdField_a_of_type_Int == 0)
      {
        localJSONObject2 = a(this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext);
        localJSONObject3 = a(this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext);
        JSONObject localJSONObject4 = a(this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext, true);
        JSONObject localJSONObject5 = a(this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext, false);
        if (localJSONObject4 != null) {
          localJSONObject2.put("pet", localJSONObject4);
        }
        if (localJSONObject5 != null) {
          localJSONObject3.put("pet", localJSONObject5);
        }
        localJSONArray.put(localJSONObject2);
        localJSONArray.put(localJSONObject3);
      }
      for (;;)
      {
        localJSONObject1.put("sprites", localJSONArray);
        return localJSONObject1.toString();
        localJSONObject2 = a(this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext);
        localJSONObject3 = a(this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext, true);
        if (localJSONObject3 != null) {
          localJSONObject2.put("pet", localJSONObject3);
        }
        localJSONArray.put(localJSONObject2);
      }
      return null;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("cmshow_scripted_SpriteRscBuilder", 1, "[getSpriteJsParam],", localThrowable);
    }
  }
  
  String a(int paramInt, String paramString)
  {
    int i = 0;
    if ((this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext == null) || (this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a() == null) || (TextUtils.isEmpty(paramString))) {
      return null;
    }
    Object localObject = paramInt + "_" + paramString;
    if (this.c.containsKey(localObject)) {
      return (String)this.c.get(localObject);
    }
    localObject = (ApolloManager)this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a().getManager(152);
    if (TextUtils.isEmpty(((ApolloManager)localObject).h)) {
      return null;
    }
    for (;;)
    {
      try
      {
        JSONArray localJSONArray = new JSONArray(((ApolloManager)localObject).h);
        int j = localJSONArray.length();
        if (i < j)
        {
          JSONObject localJSONObject = localJSONArray.getJSONObject(i);
          int k = localJSONObject.optInt("roleId", -1);
          if ((k == -1) || (k != paramInt)) {
            continue;
          }
          paramInt = localJSONObject.getInt(paramString);
          if (ApolloUtil.a(paramInt, 0)) {
            return "action/" + paramInt + "/action/action";
          }
          QLog.e("ApolloPet", 1, "getPetBasicActions download action:" + paramInt);
          paramString = new ApolloActionData();
          paramString.actionId = paramInt;
          ((ApolloManager)localObject).a(paramString, 4);
        }
      }
      catch (Exception paramString)
      {
        QLog.e("ApolloPet", 1, "getPetBasicActions error:", paramString);
        continue;
      }
      return null;
      i += 1;
    }
  }
  
  public String a(SpriteTaskParam paramSpriteTaskParam)
  {
    int j = 0;
    if ((paramSpriteTaskParam == null) || (this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext == null)) {
      return null;
    }
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("actionId", paramSpriteTaskParam.f);
        localJSONObject.put("taskId", paramSpriteTaskParam.jdField_a_of_type_Int);
        localJSONObject.put("actionType", paramSpriteTaskParam.jdField_c_of_type_Int);
        localJSONObject.put("from", paramSpriteTaskParam.g);
        if (SpriteUtil.a(this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a()))
        {
          i = 1;
          localJSONObject.put("isHide", i);
          i = j;
          if (paramSpriteTaskParam.jdField_a_of_type_Boolean) {
            i = 1;
          }
          localJSONObject.put("isSender", i);
          if (paramSpriteTaskParam.jdField_c_of_type_Int == 1)
          {
            localObject = c(paramSpriteTaskParam);
            JSONArray localJSONArray = b(paramSpriteTaskParam);
            localJSONObject.put("sprites", localObject);
            localJSONObject.put("actions", localJSONArray);
            localObject = a(paramSpriteTaskParam);
            if (localObject != null) {
              localJSONObject.put("audio", localObject);
            }
            if (!TextUtils.isEmpty(paramSpriteTaskParam.jdField_d_of_type_JavaLangString)) {
              localJSONObject.put("extraMsg", new JSONObject(paramSpriteTaskParam.jdField_d_of_type_JavaLangString));
            }
            return localJSONObject.toString();
          }
          Object localObject = a(paramSpriteTaskParam);
          if (localObject == null) {
            continue;
          }
          localJSONObject.put("sprites", localObject);
          continue;
        }
        int i = 0;
      }
      catch (Throwable paramSpriteTaskParam)
      {
        QLog.e("cmshow_scripted_SpriteRscBuilder", 1, "[getActionJsParam],", paramSpriteTaskParam);
        return null;
      }
    }
  }
  
  public JSONArray a(JSONArray paramJSONArray)
  {
    JSONArray localJSONArray = new JSONArray();
    if ((this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext == null) || (this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a() == null) || (paramJSONArray == null)) {
      return localJSONArray;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    int j = paramJSONArray.length();
    int i = 0;
    for (;;)
    {
      int k;
      if (i < j) {
        try
        {
          k = ((Integer)paramJSONArray.get(i)).intValue();
          if (k == 0) {
            break label209;
          }
          if (ApolloUtil.a(k, 0)) {
            break label174;
          }
          QLog.e("ApolloPet", 1, "getPetActions download:" + k);
          Object localObject = new ApolloActionData();
          ((ApolloActionData)localObject).actionId = k;
          String str = ApolloUtil.a((ApolloActionData)localObject, 5);
          localObject = ApolloUtil.a((ApolloActionData)localObject, 4);
          ApolloResDownloader.a(this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a(), (String)localObject, str);
        }
        catch (Exception paramJSONArray)
        {
          QLog.e("ApolloPet", 1, "getPetActions error:", paramJSONArray);
        }
      } else {
        return localJSONArray;
      }
      label174:
      localStringBuilder.setLength(0);
      localStringBuilder.append("action/").append(k).append("/action/action");
      localJSONArray.put(localStringBuilder.toString());
      label209:
      i += 1;
    }
  }
  
  public JSONObject a(SpriteTaskParam paramSpriteTaskParam)
  {
    label361:
    for (;;)
    {
      try
      {
        Object localObject2;
        Object localObject1;
        if ((paramSpriteTaskParam.k == 12) && (paramSpriteTaskParam.f > 0))
        {
          localObject2 = ApolloUtil.e(paramSpriteTaskParam.f);
          localObject1 = localObject2;
          if (!new File((String)localObject2).exists())
          {
            localObject1 = localObject2;
            if (QLog.isColorLevel())
            {
              QLog.d("cmshow_scripted_SpriteRscBuilder", 1, new Object[] { "[getAudioParam] audio not found for " + (String)localObject2, ",action:", Integer.valueOf(paramSpriteTaskParam.f) });
              localObject1 = localObject2;
            }
          }
          int i = ((String)localObject1).indexOf(".apollo");
          if (-1 != i)
          {
            localObject1 = ((String)localObject1).substring(i + 8);
            localObject2 = new JSONObject();
            ((JSONObject)localObject2).put("path", localObject1);
            ((JSONObject)localObject2).put("delayMill", paramSpriteTaskParam.jdField_a_of_type_Float * 1000.0F);
            return localObject2;
          }
        }
        else
        {
          localObject2 = (ApolloManager)this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a().getManager(152);
          ApolloActionData localApolloActionData = ((ApolloDaoManager)this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a().getManager(154)).a(paramSpriteTaskParam.f);
          if ((localApolloActionData != null) && (localApolloActionData.hasSound))
          {
            localObject1 = ApolloConstant.jdField_c_of_type_JavaLangString + paramSpriteTaskParam.f + "/" + "music.amr";
            if (new File((String)localObject1).exists()) {
              break label361;
            }
            ((ApolloManager)localObject2).a(localApolloActionData, 4, null);
            continue;
          }
          if (paramSpriteTaskParam.i > 0)
          {
            localObject2 = ApolloResDownloader.b(paramSpriteTaskParam.i);
            localObject1 = localObject2;
            if (new File((String)localObject2).exists()) {
              continue;
            }
            ApolloResDownloader.a(this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a(), null, paramSpriteTaskParam.i, false);
            localObject1 = localObject2;
            continue;
          }
          return null;
        }
      }
      catch (Exception paramSpriteTaskParam)
      {
        QLog.e("cmshow_scripted_SpriteRscBuilder", 1, paramSpriteTaskParam, new Object[0]);
        return null;
      }
    }
  }
  
  /* Error */
  public JSONObject a(String paramString, SpriteContext paramSpriteContext, boolean paramBoolean)
  {
    // Byte code:
    //   0: new 97	org/json/JSONObject
    //   3: dup
    //   4: invokespecial 368	org/json/JSONObject:<init>	()V
    //   7: astore 14
    //   9: iconst_1
    //   10: istore 11
    //   12: iconst_1
    //   13: istore 12
    //   15: iconst_1
    //   16: istore 6
    //   18: iconst_m1
    //   19: istore 5
    //   21: new 558	java/util/ArrayList
    //   24: dup
    //   25: invokespecial 753	java/util/ArrayList:<init>	()V
    //   28: astore 15
    //   30: aload_2
    //   31: invokevirtual 208	com/tencent/mobileqq/apollo/script/SpriteContext:a	()Lcom/tencent/mobileqq/app/QQAppInterface;
    //   34: sipush 152
    //   37: invokevirtual 71	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   40: checkcast 73	com/tencent/mobileqq/apollo/ApolloManager
    //   43: astore 13
    //   45: iload 5
    //   47: istore 9
    //   49: iload 11
    //   51: istore 7
    //   53: iload 5
    //   55: istore 10
    //   57: iload 12
    //   59: istore 8
    //   61: aload 13
    //   63: aload_1
    //   64: invokevirtual 108	com/tencent/mobileqq/apollo/ApolloManager:b	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/ApolloBaseInfo;
    //   67: astore 16
    //   69: iload 5
    //   71: istore 9
    //   73: iload 11
    //   75: istore 7
    //   77: iload 5
    //   79: istore 10
    //   81: iload 12
    //   83: istore 8
    //   85: aload 16
    //   87: invokevirtual 757	com/tencent/mobileqq/data/ApolloBaseInfo:getApolloPetDress	()Lcom/tencent/mobileqq/apollo/data/ApolloDress;
    //   90: astore 17
    //   92: aload 17
    //   94: ifnull +988 -> 1082
    //   97: iload 5
    //   99: istore 9
    //   101: iload 11
    //   103: istore 7
    //   105: iload 5
    //   107: istore 10
    //   109: iload 12
    //   111: istore 8
    //   113: aload 16
    //   115: getfield 114	com/tencent/mobileqq/data/ApolloBaseInfo:hasPet	Z
    //   118: ifeq +964 -> 1082
    //   121: iload 5
    //   123: istore 9
    //   125: iload 11
    //   127: istore 7
    //   129: iload 5
    //   131: istore 10
    //   133: iload 12
    //   135: istore 8
    //   137: aload 17
    //   139: getfield 762	com/tencent/mobileqq/apollo/data/ApolloDress:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   142: ifnull +940 -> 1082
    //   145: iload 5
    //   147: istore 9
    //   149: iload 11
    //   151: istore 7
    //   153: iload 5
    //   155: istore 10
    //   157: iload 12
    //   159: istore 8
    //   161: aload 17
    //   163: getfield 762	com/tencent/mobileqq/apollo/data/ApolloDress:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   166: invokevirtual 764	java/util/HashMap:isEmpty	()Z
    //   169: ifne +913 -> 1082
    //   172: iload 5
    //   174: istore 9
    //   176: iload 11
    //   178: istore 7
    //   180: iload 5
    //   182: istore 10
    //   184: iload 12
    //   186: istore 8
    //   188: aload 14
    //   190: ldc_w 442
    //   193: iconst_0
    //   194: aload 17
    //   196: getfield 765	com/tencent/mobileqq/apollo/data/ApolloDress:jdField_a_of_type_Int	I
    //   199: invokestatic 438	com/tencent/mobileqq/apollo/task/ApolloActionHelper:a	(II)Ljava/lang/String;
    //   202: invokevirtual 309	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   205: pop
    //   206: iload 5
    //   208: istore 4
    //   210: iload 5
    //   212: istore 9
    //   214: iload 11
    //   216: istore 7
    //   218: iload 5
    //   220: istore 10
    //   222: iload 12
    //   224: istore 8
    //   226: iconst_1
    //   227: aload 17
    //   229: getfield 765	com/tencent/mobileqq/apollo/data/ApolloDress:jdField_a_of_type_Int	I
    //   232: invokestatic 767	com/tencent/mobileqq/apollo/utils/ApolloUtil:b	(II)Z
    //   235: ifne +27 -> 262
    //   238: iconst_0
    //   239: istore 7
    //   241: iconst_0
    //   242: istore 8
    //   244: iconst_0
    //   245: istore 6
    //   247: iload 5
    //   249: istore 9
    //   251: iload 5
    //   253: istore 10
    //   255: aload 17
    //   257: getfield 765	com/tencent/mobileqq/apollo/data/ApolloDress:jdField_a_of_type_Int	I
    //   260: istore 4
    //   262: iload 4
    //   264: istore 9
    //   266: iload 6
    //   268: istore 7
    //   270: iload 4
    //   272: istore 10
    //   274: iload 6
    //   276: istore 8
    //   278: aload 17
    //   280: getfield 762	com/tencent/mobileqq/apollo/data/ApolloDress:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   283: invokevirtual 768	java/util/HashMap:size	()I
    //   286: newarray int
    //   288: astore 18
    //   290: iload 4
    //   292: istore 9
    //   294: iload 6
    //   296: istore 7
    //   298: iload 4
    //   300: istore 10
    //   302: iload 6
    //   304: istore 8
    //   306: aload 17
    //   308: getfield 762	com/tencent/mobileqq/apollo/data/ApolloDress:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   311: invokevirtual 772	java/util/HashMap:entrySet	()Ljava/util/Set;
    //   314: invokeinterface 778 1 0
    //   319: astore 19
    //   321: iconst_0
    //   322: istore 5
    //   324: iload 4
    //   326: istore 9
    //   328: iload 6
    //   330: istore 7
    //   332: iload 4
    //   334: istore 10
    //   336: iload 6
    //   338: istore 8
    //   340: aload 19
    //   342: invokeinterface 783 1 0
    //   347: ifeq +54 -> 401
    //   350: iload 4
    //   352: istore 9
    //   354: iload 6
    //   356: istore 7
    //   358: iload 4
    //   360: istore 10
    //   362: iload 6
    //   364: istore 8
    //   366: aload 18
    //   368: iload 5
    //   370: aload 19
    //   372: invokeinterface 787 1 0
    //   377: checkcast 789	java/util/Map$Entry
    //   380: invokeinterface 792 1 0
    //   385: checkcast 61	java/lang/Integer
    //   388: invokevirtual 65	java/lang/Integer:intValue	()I
    //   391: iastore
    //   392: iload 5
    //   394: iconst_1
    //   395: iadd
    //   396: istore 5
    //   398: goto -74 -> 324
    //   401: iload 4
    //   403: istore 9
    //   405: iload 6
    //   407: istore 7
    //   409: iload 4
    //   411: istore 10
    //   413: iload 6
    //   415: istore 8
    //   417: new 78	org/json/JSONArray
    //   420: dup
    //   421: invokespecial 288	org/json/JSONArray:<init>	()V
    //   424: astore 19
    //   426: iload 4
    //   428: istore 9
    //   430: iload 6
    //   432: istore 7
    //   434: iload 4
    //   436: istore 10
    //   438: iload 6
    //   440: istore 8
    //   442: aload 18
    //   444: arraylength
    //   445: istore 11
    //   447: iload 6
    //   449: istore 5
    //   451: iconst_0
    //   452: istore 8
    //   454: iload 8
    //   456: iload 11
    //   458: if_icmpge +72 -> 530
    //   461: aload 18
    //   463: iload 8
    //   465: iaload
    //   466: istore 9
    //   468: iload 5
    //   470: istore 6
    //   472: iload 5
    //   474: istore 7
    //   476: aload 19
    //   478: iconst_1
    //   479: iload 9
    //   481: invokestatic 438	com/tencent/mobileqq/apollo/task/ApolloActionHelper:a	(II)Ljava/lang/String;
    //   484: invokevirtual 301	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   487: pop
    //   488: iload 5
    //   490: istore 6
    //   492: iload 5
    //   494: istore 7
    //   496: iconst_2
    //   497: iload 9
    //   499: invokestatic 767	com/tencent/mobileqq/apollo/utils/ApolloUtil:b	(II)Z
    //   502: ifne +934 -> 1436
    //   505: iconst_0
    //   506: istore 7
    //   508: iconst_0
    //   509: istore 5
    //   511: iconst_0
    //   512: istore 6
    //   514: aload 15
    //   516: iload 9
    //   518: invokestatic 135	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   521: invokeinterface 797 2 0
    //   526: pop
    //   527: goto +909 -> 1436
    //   530: iload 5
    //   532: istore 6
    //   534: iload 5
    //   536: istore 7
    //   538: aload 14
    //   540: ldc_w 440
    //   543: aload 19
    //   545: invokevirtual 309	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   548: pop
    //   549: iload 5
    //   551: istore 6
    //   553: iload 5
    //   555: istore 7
    //   557: aload 14
    //   559: ldc_w 266
    //   562: aload 17
    //   564: getfield 765	com/tencent/mobileqq/apollo/data/ApolloDress:jdField_a_of_type_Int	I
    //   567: invokevirtual 374	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   570: pop
    //   571: iload 5
    //   573: istore 6
    //   575: iload 5
    //   577: istore 7
    //   579: aload_0
    //   580: aload 17
    //   582: getfield 765	com/tencent/mobileqq/apollo/data/ApolloDress:jdField_a_of_type_Int	I
    //   585: ldc_w 799
    //   588: invokevirtual 801	com/tencent/mobileqq/apollo/script/SpriteRscBuilder:a	(ILjava/lang/String;)Ljava/lang/String;
    //   591: astore 18
    //   593: iload 5
    //   595: istore 6
    //   597: iload 5
    //   599: istore 7
    //   601: aload_0
    //   602: aload 17
    //   604: getfield 765	com/tencent/mobileqq/apollo/data/ApolloDress:jdField_a_of_type_Int	I
    //   607: ldc_w 803
    //   610: invokevirtual 801	com/tencent/mobileqq/apollo/script/SpriteRscBuilder:a	(ILjava/lang/String;)Ljava/lang/String;
    //   613: astore 19
    //   615: iload 5
    //   617: istore 6
    //   619: iload 5
    //   621: istore 7
    //   623: aload 18
    //   625: invokestatic 49	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   628: ifne +57 -> 685
    //   631: iload 5
    //   633: istore 6
    //   635: iload 5
    //   637: istore 7
    //   639: aload 19
    //   641: invokestatic 49	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   644: ifne +41 -> 685
    //   647: iload 5
    //   649: istore 6
    //   651: iload 5
    //   653: istore 7
    //   655: aload 14
    //   657: ldc_w 805
    //   660: aload 19
    //   662: invokevirtual 309	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   665: pop
    //   666: iload 5
    //   668: istore 6
    //   670: iload 5
    //   672: istore 7
    //   674: aload 14
    //   676: ldc_w 807
    //   679: aload 18
    //   681: invokevirtual 309	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   684: pop
    //   685: iload 5
    //   687: istore 6
    //   689: iload 5
    //   691: istore 7
    //   693: aload_0
    //   694: aload 17
    //   696: getfield 765	com/tencent/mobileqq/apollo/data/ApolloDress:jdField_a_of_type_Int	I
    //   699: invokespecial 809	com/tencent/mobileqq/apollo/script/SpriteRscBuilder:a	(I)Ljava/lang/String;
    //   702: astore 18
    //   704: iload 5
    //   706: istore 6
    //   708: iload 5
    //   710: istore 7
    //   712: aload 18
    //   714: invokestatic 49	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   717: ifne +22 -> 739
    //   720: iload 5
    //   722: istore 6
    //   724: iload 5
    //   726: istore 7
    //   728: aload 14
    //   730: ldc_w 811
    //   733: aload 18
    //   735: invokevirtual 309	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   738: pop
    //   739: iload 5
    //   741: istore 6
    //   743: iload 5
    //   745: istore 7
    //   747: aload 16
    //   749: getfield 814	com/tencent/mobileqq/data/ApolloBaseInfo:petNick	Ljava/lang/String;
    //   752: invokestatic 49	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   755: ifne +53 -> 808
    //   758: iload 5
    //   760: istore 6
    //   762: iload 5
    //   764: istore 7
    //   766: aload_2
    //   767: getfield 815	com/tencent/mobileqq/apollo/script/SpriteContext:jdField_d_of_type_Int	I
    //   770: ifne +38 -> 808
    //   773: iload 5
    //   775: istore 6
    //   777: iload 5
    //   779: istore 7
    //   781: aload 14
    //   783: ldc_w 455
    //   786: aload 16
    //   788: getfield 814	com/tencent/mobileqq/data/ApolloBaseInfo:petNick	Ljava/lang/String;
    //   791: ldc_w 457
    //   794: invokevirtual 461	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   797: iconst_0
    //   798: invokestatic 467	com/tencent/mobileqq/utils/Base64Util:encodeToString	([BI)Ljava/lang/String;
    //   801: invokestatic 471	com/tencent/mobileqq/apollo/script/SpriteUtil:a	(Ljava/lang/String;)Ljava/lang/String;
    //   804: invokevirtual 309	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   807: pop
    //   808: iload 5
    //   810: istore 6
    //   812: iload 5
    //   814: istore 7
    //   816: aload 14
    //   818: ldc_w 448
    //   821: aload 13
    //   823: getfield 657	com/tencent/mobileqq/apollo/ApolloManager:h	Ljava/lang/String;
    //   826: aload 17
    //   828: getfield 765	com/tencent/mobileqq/apollo/data/ApolloDress:jdField_a_of_type_Int	I
    //   831: iload_3
    //   832: invokestatic 817	com/tencent/mobileqq/apollo/script/SpriteRscBuilder:a	(Ljava/lang/String;IZ)Ljava/lang/String;
    //   835: invokevirtual 309	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   838: pop
    //   839: iload 5
    //   841: istore 6
    //   843: iload 5
    //   845: istore 7
    //   847: aload_0
    //   848: getfield 40	com/tencent/mobileqq/apollo/script/SpriteRscBuilder:jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext	Lcom/tencent/mobileqq/apollo/script/SpriteContext;
    //   851: getfield 474	com/tencent/mobileqq/apollo/script/SpriteContext:jdField_a_of_type_ComTencentMobileqqApolloDataApolloRoleInfo	Lcom/tencent/mobileqq/apollo/data/ApolloRoleInfo;
    //   854: ifnull +87 -> 941
    //   857: iload 5
    //   859: istore 6
    //   861: iload 5
    //   863: istore 7
    //   865: aload 14
    //   867: ldc_w 476
    //   870: aload_0
    //   871: getfield 40	com/tencent/mobileqq/apollo/script/SpriteRscBuilder:jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext	Lcom/tencent/mobileqq/apollo/script/SpriteContext;
    //   874: getfield 474	com/tencent/mobileqq/apollo/script/SpriteContext:jdField_a_of_type_ComTencentMobileqqApolloDataApolloRoleInfo	Lcom/tencent/mobileqq/apollo/data/ApolloRoleInfo;
    //   877: getfield 480	com/tencent/mobileqq/apollo/data/ApolloRoleInfo:jdField_a_of_type_Float	F
    //   880: f2d
    //   881: invokevirtual 416	org/json/JSONObject:put	(Ljava/lang/String;D)Lorg/json/JSONObject;
    //   884: pop
    //   885: iload 5
    //   887: istore 6
    //   889: iload 5
    //   891: istore 7
    //   893: aload 14
    //   895: ldc_w 482
    //   898: aload_0
    //   899: getfield 40	com/tencent/mobileqq/apollo/script/SpriteRscBuilder:jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext	Lcom/tencent/mobileqq/apollo/script/SpriteContext;
    //   902: getfield 474	com/tencent/mobileqq/apollo/script/SpriteContext:jdField_a_of_type_ComTencentMobileqqApolloDataApolloRoleInfo	Lcom/tencent/mobileqq/apollo/data/ApolloRoleInfo;
    //   905: getfield 484	com/tencent/mobileqq/apollo/data/ApolloRoleInfo:b	F
    //   908: f2d
    //   909: invokevirtual 416	org/json/JSONObject:put	(Ljava/lang/String;D)Lorg/json/JSONObject;
    //   912: pop
    //   913: iload 5
    //   915: istore 6
    //   917: iload 5
    //   919: istore 7
    //   921: aload 14
    //   923: ldc_w 486
    //   926: aload_0
    //   927: getfield 40	com/tencent/mobileqq/apollo/script/SpriteRscBuilder:jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext	Lcom/tencent/mobileqq/apollo/script/SpriteContext;
    //   930: getfield 474	com/tencent/mobileqq/apollo/script/SpriteContext:jdField_a_of_type_ComTencentMobileqqApolloDataApolloRoleInfo	Lcom/tencent/mobileqq/apollo/data/ApolloRoleInfo;
    //   933: getfield 488	com/tencent/mobileqq/apollo/data/ApolloRoleInfo:c	F
    //   936: f2d
    //   937: invokevirtual 416	org/json/JSONObject:put	(Ljava/lang/String;D)Lorg/json/JSONObject;
    //   940: pop
    //   941: iload 5
    //   943: ifeq +110 -> 1053
    //   946: iload 5
    //   948: ifne +131 -> 1079
    //   951: aload_2
    //   952: ifnull +127 -> 1079
    //   955: aload_2
    //   956: invokevirtual 208	com/tencent/mobileqq/apollo/script/SpriteContext:a	()Lcom/tencent/mobileqq/app/QQAppInterface;
    //   959: ifnull +120 -> 1079
    //   962: ldc 216
    //   964: iconst_1
    //   965: new 210	java/lang/StringBuilder
    //   968: dup
    //   969: invokespecial 211	java/lang/StringBuilder:<init>	()V
    //   972: ldc_w 819
    //   975: invokevirtual 222	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   978: aload_1
    //   979: invokevirtual 222	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   982: invokevirtual 229	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   985: invokestatic 661	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   988: aload 13
    //   990: ifnull +89 -> 1079
    //   993: aload 15
    //   995: invokeinterface 820 1 0
    //   1000: newarray int
    //   1002: astore 16
    //   1004: aload 15
    //   1006: invokeinterface 821 1 0
    //   1011: astore 15
    //   1013: iconst_0
    //   1014: istore 5
    //   1016: aload 15
    //   1018: invokeinterface 783 1 0
    //   1023: ifeq +36 -> 1059
    //   1026: aload 16
    //   1028: iload 5
    //   1030: aload 15
    //   1032: invokeinterface 787 1 0
    //   1037: checkcast 61	java/lang/Integer
    //   1040: invokevirtual 65	java/lang/Integer:intValue	()I
    //   1043: iastore
    //   1044: iload 5
    //   1046: iconst_1
    //   1047: iadd
    //   1048: istore 5
    //   1050: goto -34 -> 1016
    //   1053: aconst_null
    //   1054: astore 14
    //   1056: goto -110 -> 946
    //   1059: aload_2
    //   1060: invokevirtual 208	com/tencent/mobileqq/apollo/script/SpriteContext:a	()Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1063: aload_1
    //   1064: aload 13
    //   1066: invokevirtual 824	com/tencent/mobileqq/apollo/ApolloManager:a	()Lcom/tencent/mobileqq/apollo/store/ApolloResDownloader$OnApolloDownLoadListener;
    //   1069: iload 4
    //   1071: aload 16
    //   1073: iconst_m1
    //   1074: iconst_m1
    //   1075: iconst_1
    //   1076: invokestatic 827	com/tencent/mobileqq/apollo/store/ApolloResDownloader:a	(Lcom/tencent/common/app/AppInterface;Ljava/lang/String;Lcom/tencent/mobileqq/apollo/store/ApolloResDownloader$OnApolloDownLoadListener;I[IIIZ)V
    //   1079: aload 14
    //   1081: areturn
    //   1082: aconst_null
    //   1083: areturn
    //   1084: astore 14
    //   1086: aconst_null
    //   1087: astore 13
    //   1089: iconst_1
    //   1090: istore 6
    //   1092: iload 5
    //   1094: istore 4
    //   1096: iload 6
    //   1098: istore 5
    //   1100: ldc 129
    //   1102: iconst_1
    //   1103: aload 14
    //   1105: iconst_0
    //   1106: anewarray 4	java/lang/Object
    //   1109: invokestatic 383	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   1112: iload 5
    //   1114: ifne +125 -> 1239
    //   1117: aload_2
    //   1118: ifnull +121 -> 1239
    //   1121: aload_2
    //   1122: invokevirtual 208	com/tencent/mobileqq/apollo/script/SpriteContext:a	()Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1125: ifnull +114 -> 1239
    //   1128: ldc 216
    //   1130: iconst_1
    //   1131: new 210	java/lang/StringBuilder
    //   1134: dup
    //   1135: invokespecial 211	java/lang/StringBuilder:<init>	()V
    //   1138: ldc_w 819
    //   1141: invokevirtual 222	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1144: aload_1
    //   1145: invokevirtual 222	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1148: invokevirtual 229	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1151: invokestatic 661	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1154: aload 13
    //   1156: ifnull +83 -> 1239
    //   1159: aload 15
    //   1161: invokeinterface 820 1 0
    //   1166: newarray int
    //   1168: astore 14
    //   1170: aload 15
    //   1172: invokeinterface 821 1 0
    //   1177: astore 15
    //   1179: iconst_0
    //   1180: istore 5
    //   1182: aload 15
    //   1184: invokeinterface 783 1 0
    //   1189: ifeq +30 -> 1219
    //   1192: aload 14
    //   1194: iload 5
    //   1196: aload 15
    //   1198: invokeinterface 787 1 0
    //   1203: checkcast 61	java/lang/Integer
    //   1206: invokevirtual 65	java/lang/Integer:intValue	()I
    //   1209: iastore
    //   1210: iload 5
    //   1212: iconst_1
    //   1213: iadd
    //   1214: istore 5
    //   1216: goto -34 -> 1182
    //   1219: aload_2
    //   1220: invokevirtual 208	com/tencent/mobileqq/apollo/script/SpriteContext:a	()Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1223: aload_1
    //   1224: aload 13
    //   1226: invokevirtual 824	com/tencent/mobileqq/apollo/ApolloManager:a	()Lcom/tencent/mobileqq/apollo/store/ApolloResDownloader$OnApolloDownLoadListener;
    //   1229: iload 4
    //   1231: aload 14
    //   1233: iconst_m1
    //   1234: iconst_m1
    //   1235: iconst_1
    //   1236: invokestatic 827	com/tencent/mobileqq/apollo/store/ApolloResDownloader:a	(Lcom/tencent/common/app/AppInterface;Ljava/lang/String;Lcom/tencent/mobileqq/apollo/store/ApolloResDownloader$OnApolloDownLoadListener;I[IIIZ)V
    //   1239: aconst_null
    //   1240: areturn
    //   1241: astore 14
    //   1243: aconst_null
    //   1244: astore 13
    //   1246: iconst_1
    //   1247: istore 6
    //   1249: iload 5
    //   1251: istore 4
    //   1253: iload 6
    //   1255: istore 5
    //   1257: iload 5
    //   1259: ifne +125 -> 1384
    //   1262: aload_2
    //   1263: ifnull +121 -> 1384
    //   1266: aload_2
    //   1267: invokevirtual 208	com/tencent/mobileqq/apollo/script/SpriteContext:a	()Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1270: ifnull +114 -> 1384
    //   1273: ldc 216
    //   1275: iconst_1
    //   1276: new 210	java/lang/StringBuilder
    //   1279: dup
    //   1280: invokespecial 211	java/lang/StringBuilder:<init>	()V
    //   1283: ldc_w 819
    //   1286: invokevirtual 222	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1289: aload_1
    //   1290: invokevirtual 222	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1293: invokevirtual 229	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1296: invokestatic 661	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1299: aload 13
    //   1301: ifnull +83 -> 1384
    //   1304: aload 15
    //   1306: invokeinterface 820 1 0
    //   1311: newarray int
    //   1313: astore 16
    //   1315: aload 15
    //   1317: invokeinterface 821 1 0
    //   1322: astore 15
    //   1324: iconst_0
    //   1325: istore 5
    //   1327: aload 15
    //   1329: invokeinterface 783 1 0
    //   1334: ifeq +30 -> 1364
    //   1337: aload 16
    //   1339: iload 5
    //   1341: aload 15
    //   1343: invokeinterface 787 1 0
    //   1348: checkcast 61	java/lang/Integer
    //   1351: invokevirtual 65	java/lang/Integer:intValue	()I
    //   1354: iastore
    //   1355: iload 5
    //   1357: iconst_1
    //   1358: iadd
    //   1359: istore 5
    //   1361: goto -34 -> 1327
    //   1364: aload_2
    //   1365: invokevirtual 208	com/tencent/mobileqq/apollo/script/SpriteContext:a	()Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1368: aload_1
    //   1369: aload 13
    //   1371: invokevirtual 824	com/tencent/mobileqq/apollo/ApolloManager:a	()Lcom/tencent/mobileqq/apollo/store/ApolloResDownloader$OnApolloDownLoadListener;
    //   1374: iload 4
    //   1376: aload 16
    //   1378: iconst_m1
    //   1379: iconst_m1
    //   1380: iconst_1
    //   1381: invokestatic 827	com/tencent/mobileqq/apollo/store/ApolloResDownloader:a	(Lcom/tencent/common/app/AppInterface;Ljava/lang/String;Lcom/tencent/mobileqq/apollo/store/ApolloResDownloader$OnApolloDownLoadListener;I[IIIZ)V
    //   1384: aload 14
    //   1386: athrow
    //   1387: astore 14
    //   1389: iload 7
    //   1391: istore 5
    //   1393: iload 9
    //   1395: istore 4
    //   1397: goto -140 -> 1257
    //   1400: astore 14
    //   1402: iload 6
    //   1404: istore 5
    //   1406: goto -149 -> 1257
    //   1409: astore 14
    //   1411: goto -154 -> 1257
    //   1414: astore 14
    //   1416: iload 8
    //   1418: istore 5
    //   1420: iload 10
    //   1422: istore 4
    //   1424: goto -324 -> 1100
    //   1427: astore 14
    //   1429: iload 7
    //   1431: istore 5
    //   1433: goto -333 -> 1100
    //   1436: iload 8
    //   1438: iconst_1
    //   1439: iadd
    //   1440: istore 8
    //   1442: goto -988 -> 454
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1445	0	this	SpriteRscBuilder
    //   0	1445	1	paramString	String
    //   0	1445	2	paramSpriteContext	SpriteContext
    //   0	1445	3	paramBoolean	boolean
    //   208	1215	4	i	int
    //   19	1413	5	j	int
    //   16	1387	6	k	int
    //   51	1379	7	m	int
    //   59	1382	8	n	int
    //   47	1347	9	i1	int
    //   55	1366	10	i2	int
    //   10	449	11	i3	int
    //   13	210	12	i4	int
    //   43	1327	13	localApolloManager	ApolloManager
    //   7	1073	14	localJSONObject	JSONObject
    //   1084	20	14	localThrowable1	Throwable
    //   1168	64	14	arrayOfInt	int[]
    //   1241	144	14	localObject1	Object
    //   1387	1	14	localObject2	Object
    //   1400	1	14	localObject3	Object
    //   1409	1	14	localObject4	Object
    //   1414	1	14	localThrowable2	Throwable
    //   1427	1	14	localThrowable3	Throwable
    //   28	1314	15	localObject5	Object
    //   67	1310	16	localObject6	Object
    //   90	737	17	localApolloDress	com.tencent.mobileqq.apollo.data.ApolloDress
    //   288	446	18	localObject7	Object
    //   319	342	19	localObject8	Object
    // Exception table:
    //   from	to	target	type
    //   30	45	1084	java/lang/Throwable
    //   30	45	1241	finally
    //   61	69	1387	finally
    //   85	92	1387	finally
    //   113	121	1387	finally
    //   137	145	1387	finally
    //   161	172	1387	finally
    //   188	206	1387	finally
    //   226	238	1387	finally
    //   255	262	1387	finally
    //   278	290	1387	finally
    //   306	321	1387	finally
    //   340	350	1387	finally
    //   366	392	1387	finally
    //   417	426	1387	finally
    //   442	447	1387	finally
    //   476	488	1400	finally
    //   496	505	1400	finally
    //   514	527	1400	finally
    //   538	549	1400	finally
    //   557	571	1400	finally
    //   579	593	1400	finally
    //   601	615	1400	finally
    //   623	631	1400	finally
    //   639	647	1400	finally
    //   655	666	1400	finally
    //   674	685	1400	finally
    //   693	704	1400	finally
    //   712	720	1400	finally
    //   728	739	1400	finally
    //   747	758	1400	finally
    //   766	773	1400	finally
    //   781	808	1400	finally
    //   816	839	1400	finally
    //   847	857	1400	finally
    //   865	885	1400	finally
    //   893	913	1400	finally
    //   921	941	1400	finally
    //   1100	1112	1409	finally
    //   61	69	1414	java/lang/Throwable
    //   85	92	1414	java/lang/Throwable
    //   113	121	1414	java/lang/Throwable
    //   137	145	1414	java/lang/Throwable
    //   161	172	1414	java/lang/Throwable
    //   188	206	1414	java/lang/Throwable
    //   226	238	1414	java/lang/Throwable
    //   255	262	1414	java/lang/Throwable
    //   278	290	1414	java/lang/Throwable
    //   306	321	1414	java/lang/Throwable
    //   340	350	1414	java/lang/Throwable
    //   366	392	1414	java/lang/Throwable
    //   417	426	1414	java/lang/Throwable
    //   442	447	1414	java/lang/Throwable
    //   476	488	1427	java/lang/Throwable
    //   496	505	1427	java/lang/Throwable
    //   514	527	1427	java/lang/Throwable
    //   538	549	1427	java/lang/Throwable
    //   557	571	1427	java/lang/Throwable
    //   579	593	1427	java/lang/Throwable
    //   601	615	1427	java/lang/Throwable
    //   623	631	1427	java/lang/Throwable
    //   639	647	1427	java/lang/Throwable
    //   655	666	1427	java/lang/Throwable
    //   674	685	1427	java/lang/Throwable
    //   693	704	1427	java/lang/Throwable
    //   712	720	1427	java/lang/Throwable
    //   728	739	1427	java/lang/Throwable
    //   747	758	1427	java/lang/Throwable
    //   766	773	1427	java/lang/Throwable
    //   781	808	1427	java/lang/Throwable
    //   816	839	1427	java/lang/Throwable
    //   847	857	1427	java/lang/Throwable
    //   865	885	1427	java/lang/Throwable
    //   893	913	1427	java/lang/Throwable
    //   921	941	1427	java/lang/Throwable
  }
  
  public void a()
  {
    if (this.jdField_b_of_type_JavaUtilMap != null) {
      this.jdField_b_of_type_JavaUtilMap.clear();
    }
  }
  
  public void a(List paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {}
    Object localObject3;
    Object localObject1;
    do
    {
      return;
      localObject3 = new ArrayList();
      Iterator localIterator = paramList.iterator();
      i = 1;
      localObject1 = null;
      if (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        paramList = a(this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a(), str);
        if (str.equals(this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.jdField_b_of_type_JavaLangString)) {}
        for (localObject1 = a(paramList);; localObject1 = localObject2)
        {
          ((SpriteTaskParam)localObject1).jdField_a_of_type_Int = i;
          ((SpriteTaskParam)localObject1).jdField_a_of_type_Boolean = true;
          ((SpriteTaskParam)localObject1).jdField_a_of_type_JavaLangString = str;
          ((List)localObject3).add(localObject1);
          if (QLog.isColorLevel()) {
            QLog.d("cmshow_scripted_SpriteRscBuilder", 2, new Object[] { "playAppearAction task action:", Integer.valueOf(((SpriteTaskParam)localObject1).f), ",uin:", str.substring(0, 4) });
          }
          i += 1;
          localObject1 = paramList;
          break;
          localObject2 = a(paramList);
          paramList = (List)localObject1;
        }
      }
      SpriteUtil.a(this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext, (List)localObject3);
    } while (localObject1 == null);
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a().getApp().getSharedPreferences("apollo_sp", 0);
    if (!((SharedPreferences)localObject2).getBoolean("stand_type_" + ((SpriteRscBuilder.ApolloAppearAction)localObject1).jdField_b_of_type_Int, false)) {}
    switch (((SpriteRscBuilder.ApolloAppearAction)localObject1).jdField_b_of_type_Int)
    {
    default: 
      paramList = null;
      localObject3 = SpriteUtil.a(this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a());
      if ((!TextUtils.isEmpty(paramList)) && (localObject3 != null)) {
        ((SpriteActionScript)localObject3).a(this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.jdField_b_of_type_JavaLangString, paramList);
      }
      ((SharedPreferences)localObject2).edit().putBoolean("stand_type_" + ((SpriteRscBuilder.ApolloAppearAction)localObject1).jdField_b_of_type_Int, true).commit();
      if (this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.jdField_a_of_type_Int != 3000) {
        break;
      }
    }
    for (int i = 2;; i = this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.jdField_a_of_type_Int)
    {
      VipUtils.a(null, "cmshow", "Apollo", "appearanceaction", i, ((SpriteRscBuilder.ApolloAppearAction)localObject1).jdField_b_of_type_Int, new String[] { String.valueOf(((SpriteRscBuilder.ApolloAppearAction)localObject1).jdField_a_of_type_Int) });
      return;
      paramList = "这是我的小钻出场动作哦~";
      break;
      paramList = "这是我的炫卡出场动作哦~";
      break;
      paramList = "这是我的炫物出场动作哦~";
      break;
    }
  }
  
  public boolean a(SpriteTaskParam paramSpriteTaskParam)
  {
    if ((paramSpriteTaskParam == null) || (this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext == null) || (this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a() == null)) {
      return false;
    }
    if (paramSpriteTaskParam.k == 1) {
      return b(paramSpriteTaskParam);
    }
    if (paramSpriteTaskParam.k == 6)
    {
      if (!ApolloUtil.a(ApolloUtil.b(paramSpriteTaskParam.f)))
      {
        ApolloResDownloader.a(this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a(), ApolloUtil.b(paramSpriteTaskParam.f) + "/d.zip", ApolloUtil.c(paramSpriteTaskParam.f));
        return false;
      }
    }
    else if (paramSpriteTaskParam.k == 12)
    {
      if (!ApolloUtil.a(paramSpriteTaskParam.f, 0))
      {
        Object localObject = new ApolloActionData();
        ((ApolloActionData)localObject).actionId = paramSpriteTaskParam.f;
        paramSpriteTaskParam = ApolloUtil.a((ApolloActionData)localObject, 5);
        localObject = ApolloUtil.a((ApolloActionData)localObject, 4);
        ApolloResDownloader.a(this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a(), (String)localObject, paramSpriteTaskParam);
        return false;
      }
    }
    else if ((paramSpriteTaskParam.k == 11) || (paramSpriteTaskParam.k == 7))
    {
      paramSpriteTaskParam = ApolloActionHelper.a(paramSpriteTaskParam.k, paramSpriteTaskParam.f, 0, true);
      if ((paramSpriteTaskParam.length > 0) && (!TextUtils.isEmpty(paramSpriteTaskParam[0])) && (paramSpriteTaskParam[0].length() - "action".length() > 0) && (!ApolloUtil.a(paramSpriteTaskParam[0].substring(0, paramSpriteTaskParam[0].length() - "action".length()))))
      {
        ApolloResDownloader.a(this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a(), this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a().getCurrentAccountUin(), null, 0, null, -1, -1, true);
        return false;
      }
    }
    return true;
  }
  
  boolean a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramQQAppInterface == null)) {
      return false;
    }
    int i;
    if (this.jdField_b_of_type_JavaUtilMap.containsKey(paramString))
    {
      i = ((Integer)this.jdField_b_of_type_JavaUtilMap.get(paramString)).intValue();
      if (!jdField_a_of_type_JavaUtilMap.containsKey(paramString)) {
        break label682;
      }
    }
    label682:
    for (int j = ((Integer)jdField_a_of_type_JavaUtilMap.get(paramString)).intValue();; j = 0)
    {
      Object localObject = ApolloManager.a();
      VasExtensionHandler localVasExtensionHandler = (VasExtensionHandler)paramQQAppInterface.a(71);
      JSONArray localJSONArray;
      try
      {
        if (this.d.get(paramString) == null) {}
        for (long l = 0L; (!((SharedPreferences)localObject).contains(paramString)) && (NetConnInfoCenter.getServerTime() - l > 180L); l = ((Long)this.d.get(paramString)).longValue())
        {
          paramQQAppInterface = new JSONObject();
          paramQQAppInterface.put("lastRequestTime", NetConnInfoCenter.getServerTimeMillis());
          ((SharedPreferences)localObject).edit().putString(paramString, paramQQAppInterface.toString()).commit();
          localVasExtensionHandler.a(new long[] { Long.parseLong(paramString) });
          this.d.put(paramString, Long.valueOf(NetConnInfoCenter.getServerTime()));
          return false;
        }
        JSONObject localJSONObject = new JSONObject(((SharedPreferences)localObject).getString(paramString, "{}"));
        localJSONArray = localJSONObject.optJSONArray("action");
        l = localJSONObject.optLong("lastRequestTime");
        if ((j >= 5) || (NetConnInfoCenter.getServerTime() - l > 10800000L))
        {
          if (QLog.isColorLevel()) {
            QLog.d("cmshow_scripted_SpriteRscBuilder", 2, new Object[] { "hasSpecialStandAction getApolloStandAction openCount:", Integer.valueOf(j), ",lastRequestSpTime:", Long.valueOf(l) });
          }
          jdField_a_of_type_JavaUtilMap.put(paramString, Integer.valueOf(0));
          localVasExtensionHandler.a(new long[] { Long.parseLong(paramString) });
          localJSONObject.put("lastRequestTime", NetConnInfoCenter.getServerTimeMillis());
          ((SharedPreferences)localObject).edit().putString(paramString, localJSONObject.toString()).commit();
        }
        for (;;)
        {
          if (localJSONArray == null) {
            break label688;
          }
          if (localJSONArray.length() > 0) {
            break;
          }
          break label688;
          jdField_a_of_type_JavaUtilMap.put(paramString, Integer.valueOf(j + 1));
        }
        j = i;
      }
      catch (Exception paramQQAppInterface)
      {
        QLog.e("cmshow_scripted_SpriteRscBuilder", 2, "hasSpecialStandAction error:", paramQQAppInterface);
        return false;
      }
      if (i >= localJSONArray.length()) {
        j = 0;
      }
      localObject = localJSONArray.getJSONObject(j);
      this.jdField_a_of_type_Int = ((JSONObject)localObject).getInt("type");
      this.jdField_b_of_type_Int = ((JSONObject)localObject).getInt("id");
      if ((this.jdField_a_of_type_Int == 4) && (!((ApolloManager)paramQQAppInterface.getManager(152)).b(paramString).hasPet))
      {
        a(paramString);
        return false;
      }
      if (QLog.isColorLevel()) {
        QLog.d("cmshow_scripted_SpriteRscBuilder", 2, new Object[] { "[hasSpecialStandAction] uin:", paramString, ",index:", Integer.valueOf(j), ",id:", Integer.valueOf(this.jdField_b_of_type_Int), ",standType:", Integer.valueOf(this.jdField_a_of_type_Int) });
      }
      if (!ApolloUtil.a(this.jdField_b_of_type_Int, 0))
      {
        if (QLog.isColorLevel()) {
          QLog.i("cmshow_scripted_SpriteRscBuilder", 2, "hasSpecialStandAction isActionResDone is false.");
        }
        paramString = new ApolloActionData();
        paramString.actionId = this.jdField_b_of_type_Int;
        localObject = ApolloUtil.a(paramString, 5);
        ApolloResDownloader.a(paramQQAppInterface, ApolloUtil.a(paramString, 4), (String)localObject);
        return false;
      }
      this.jdField_b_of_type_JavaUtilMap.put(paramString, Integer.valueOf(j + 1));
      return true;
      i = 0;
      break;
    }
    label688:
    return false;
  }
  
  public boolean b(SpriteTaskParam paramSpriteTaskParam)
  {
    if ((paramSpriteTaskParam == null) || (this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext == null) || (this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a() == null)) {
      return false;
    }
    long l1 = System.currentTimeMillis();
    ApolloManager localApolloManager = (ApolloManager)this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a().getManager(152);
    ApolloActionData localApolloActionData = ((ApolloDaoManager)this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a().getManager(154)).a(paramSpriteTaskParam.f);
    if (localApolloActionData == null)
    {
      QLog.i("cmshow_scripted_SpriteRscBuilder", 1, "warning: data is null. call checkApolloPanelJsonVer, id:" + paramSpriteTaskParam.f);
      ApolloContentUpdateHandler.a(this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a(), 1);
      return false;
    }
    boolean bool;
    label154:
    label165:
    SpriteUIHandler localSpriteUIHandler;
    if (paramSpriteTaskParam.jdField_c_of_type_Int == 1) {
      if (paramSpriteTaskParam.h != 0)
      {
        bool = true;
        int j = paramSpriteTaskParam.f;
        int k = paramSpriteTaskParam.jdField_d_of_type_Int;
        if (!bool) {
          break label340;
        }
        i = 0;
        bool = ApolloUtil.a(j, k, i, bool);
        localSpriteUIHandler = ((SpriteScriptManager)this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a().getManager(248)).a();
        if (!bool)
        {
          if (localSpriteUIHandler != null) {
            localSpriteUIHandler.a(0, 0, paramSpriteTaskParam.jdField_a_of_type_Long);
          }
          bool = localApolloManager.a(localApolloActionData, 4, null);
          if (localSpriteUIHandler != null) {
            if (!bool) {
              break label366;
            }
          }
        }
      }
    }
    label340:
    label366:
    for (int i = 0;; i = 6)
    {
      localSpriteUIHandler.a(i, 1, paramSpriteTaskParam.jdField_a_of_type_Long);
      long l2 = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d("cmshow_scripted_SpriteRscBuilder", 2, new Object[] { "[downloadIfActionNotExist end, actionId:", Integer.valueOf(paramSpriteTaskParam.f), ",costT:", Long.valueOf(l2 - l1), ",threadId:", Long.valueOf(Thread.currentThread().getId()), ",actionType:", Integer.valueOf(paramSpriteTaskParam.jdField_c_of_type_Int) });
      }
      return true;
      bool = false;
      break;
      i = localApolloActionData.personNum;
      break label154;
      bool = ApolloUtil.a(paramSpriteTaskParam.f, localApolloActionData.personNum);
      break label165;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.script.SpriteRscBuilder
 * JD-Core Version:    0.7.0.1
 */