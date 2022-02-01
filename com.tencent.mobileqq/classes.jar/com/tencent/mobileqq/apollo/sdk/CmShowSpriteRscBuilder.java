package com.tencent.mobileqq.apollo.sdk;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.apollo.ApolloRender;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.api.ISpriteScriptManager;
import com.tencent.mobileqq.apollo.api.aio.CmShowAioMatcher;
import com.tencent.mobileqq.apollo.api.data.IApolloDaoManagerService;
import com.tencent.mobileqq.apollo.api.data.impl.ApolloDaoManagerServiceImpl;
import com.tencent.mobileqq.apollo.api.handler.impl.ApolloExtensionHandlerImpl;
import com.tencent.mobileqq.apollo.api.impl.ApolloManagerServiceImpl;
import com.tencent.mobileqq.apollo.api.model.ApolloActionData;
import com.tencent.mobileqq.apollo.api.model.ApolloBaseInfo;
import com.tencent.mobileqq.apollo.api.res.IApolloResDownloader;
import com.tencent.mobileqq.apollo.api.script.ISpriteUIHandler;
import com.tencent.mobileqq.apollo.api.script.SpriteTaskParam;
import com.tencent.mobileqq.apollo.api.sdk.PlayActionConfig;
import com.tencent.mobileqq.apollo.api.uitls.ApolloConstant;
import com.tencent.mobileqq.apollo.api.uitls.IApolloUtil;
import com.tencent.mobileqq.apollo.api.uitls.impl.ApolloActionHelperImpl;
import com.tencent.mobileqq.apollo.api.uitls.impl.ApolloUtilImpl;
import com.tencent.mobileqq.apollo.handler.ApolloContentUpdateHandler;
import com.tencent.mobileqq.apollo.script.SpriteActionScript;
import com.tencent.mobileqq.apollo.script.SpriteUtil;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

public class CmShowSpriteRscBuilder
{
  static Map<String, Integer> jdField_a_of_type_JavaUtilMap = new HashMap();
  int jdField_a_of_type_Int = -1;
  private CmShowSpriteContext jdField_a_of_type_ComTencentMobileqqApolloSdkCmShowSpriteContext;
  int jdField_b_of_type_Int = -1;
  Map<String, Integer> jdField_b_of_type_JavaUtilMap = new HashMap();
  Map<String, String> c = new ConcurrentHashMap(2);
  private Map<String, Long> d = new HashMap();
  
  public CmShowSpriteRscBuilder(CmShowSpriteContext paramCmShowSpriteContext)
  {
    this.jdField_a_of_type_ComTencentMobileqqApolloSdkCmShowSpriteContext = paramCmShowSpriteContext;
  }
  
  static String a(int paramInt, String paramString)
  {
    return null;
  }
  
  public static String a(SpriteTaskParam paramSpriteTaskParam, IPCSpriteContext paramIPCSpriteContext, PlayActionConfig paramPlayActionConfig)
  {
    if ((paramSpriteTaskParam == null) || (paramIPCSpriteContext == null) || (paramPlayActionConfig == null)) {
      return null;
    }
    for (;;)
    {
      try
      {
        QQAppInterface localQQAppInterface = ((IApolloUtil)QRoute.api(IApolloUtil.class)).getQQApp();
        JSONObject localJSONObject = new JSONObject();
        String str;
        if (paramIPCSpriteContext.jdField_b_of_type_Int == 0)
        {
          str = ApolloActionData.getModelString(paramSpriteTaskParam.f);
          localJSONObject.put("loop", paramPlayActionConfig.jdField_a_of_type_Boolean);
          localJSONObject.put("needRestore", paramPlayActionConfig.jdField_b_of_type_Boolean);
          localJSONObject.put("model", str);
          localJSONObject.put("actionId", paramSpriteTaskParam.f);
          localJSONObject.put("taskId", paramSpriteTaskParam.jdField_a_of_type_Int);
          localJSONObject.put("actionType", paramSpriteTaskParam.jdField_c_of_type_Int);
          localJSONObject.put("from", paramSpriteTaskParam.g);
          if (!SpriteUtil.a(localQQAppInterface)) {
            break label348;
          }
          i = 1;
          localJSONObject.put("isHide", i);
          if (!paramSpriteTaskParam.jdField_a_of_type_Boolean) {
            break label353;
          }
          i = 1;
          localJSONObject.put("isSender", i);
          if (paramSpriteTaskParam.jdField_c_of_type_Int == 1)
          {
            paramPlayActionConfig = b(paramSpriteTaskParam, paramIPCSpriteContext);
            paramIPCSpriteContext = a(paramSpriteTaskParam, paramIPCSpriteContext);
            localJSONObject.put("sprites", paramPlayActionConfig);
            localJSONObject.put("actions", paramIPCSpriteContext);
            paramIPCSpriteContext = a(paramSpriteTaskParam);
            if (paramIPCSpriteContext != null) {
              localJSONObject.put("audio", paramIPCSpriteContext);
            }
            if (!TextUtils.isEmpty(paramSpriteTaskParam.jdField_d_of_type_JavaLangString)) {
              localJSONObject.put("extraMsg", new JSONObject(paramSpriteTaskParam.jdField_d_of_type_JavaLangString));
            }
            return localJSONObject.toString();
          }
        }
        else
        {
          if (paramSpriteTaskParam.f > 0)
          {
            str = ApolloActionData.getModelString(paramSpriteTaskParam.f);
            continue;
          }
          if (paramSpriteTaskParam.k == 14)
          {
            str = "3D";
            continue;
          }
          str = ApolloActionHelperImpl.getModelByUin(paramSpriteTaskParam.jdField_a_of_type_JavaLangString, localQQAppInterface);
          continue;
        }
        paramIPCSpriteContext = a(paramSpriteTaskParam, paramIPCSpriteContext, paramPlayActionConfig);
        if (paramIPCSpriteContext == null) {
          continue;
        }
        localJSONObject.put("sprites", paramIPCSpriteContext);
        continue;
        i = 0;
      }
      catch (Throwable paramSpriteTaskParam)
      {
        QLog.e("CmShow_SpriteRscBuilder", 1, "[getActionJsParam],", paramSpriteTaskParam);
        return null;
      }
      label348:
      continue;
      label353:
      int i = 0;
    }
  }
  
  public static String a(IPCSpriteContext paramIPCSpriteContext)
  {
    if (paramIPCSpriteContext == null) {
      return null;
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      JSONArray localJSONArray = new JSONArray();
      if (!TextUtils.isEmpty(paramIPCSpriteContext.jdField_b_of_type_JavaLangString)) {
        localJSONArray.put(b(paramIPCSpriteContext.jdField_b_of_type_JavaLangString, paramIPCSpriteContext, true));
      }
      if (!TextUtils.isEmpty(paramIPCSpriteContext.jdField_a_of_type_JavaLangString)) {
        localJSONArray.put(b(paramIPCSpriteContext.jdField_a_of_type_JavaLangString, paramIPCSpriteContext, false));
      }
      localJSONObject.put("sprites", localJSONArray);
      paramIPCSpriteContext = localJSONObject.toString();
      return paramIPCSpriteContext;
    }
    catch (Throwable paramIPCSpriteContext)
    {
      QLog.e("CmShow_SpriteRscBuilder", 1, "[getSpriteJsParam],", paramIPCSpriteContext);
    }
    return null;
  }
  
  private static String a(@NonNull QQAppInterface paramQQAppInterface, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    paramInt = ((ApolloManagerServiceImpl)paramQQAppInterface.getRuntimeService(IApolloManagerService.class, "all")).getPetRandomAction(paramInt);
    if ((paramInt != -1) && (!ApolloUtilImpl.isActionResDone(paramInt, 0)))
    {
      if (QLog.isColorLevel()) {
        QLog.i("ApolloPet", 2, "download random pet action:" + paramInt);
      }
      Object localObject = new ApolloActionData();
      ((ApolloActionData)localObject).actionId = paramInt;
      String str = ApolloUtilImpl.getApolloResPath((ApolloActionData)localObject, 5);
      localObject = ApolloUtilImpl.getApolloResPath((ApolloActionData)localObject, 4);
      ((IApolloResDownloader)QRoute.api(IApolloResDownloader.class)).downLoadSpecialAction(paramQQAppInterface, (String)localObject, str);
    }
    for (;;)
    {
      return localStringBuilder.toString();
      if (paramInt != -1) {
        localStringBuilder.append(paramInt).append("/action/action");
      }
    }
  }
  
  public static String a(QQAppInterface paramQQAppInterface, String paramString, int paramInt, boolean paramBoolean)
  {
    if (paramQQAppInterface == null) {
      return "";
    }
    ApolloManagerServiceImpl localApolloManagerServiceImpl = (ApolloManagerServiceImpl)paramQQAppInterface.getRuntimeService(IApolloManagerService.class, "all");
    boolean bool1 = localApolloManagerServiceImpl.isSuperYellow(paramString);
    boolean bool2 = paramString.equals(paramQQAppInterface.getCurrentAccountUin());
    int i = SpriteUtil.a(paramInt, bool2, bool1, paramBoolean);
    if (QLog.isColorLevel()) {
      QLog.d("CmShow_SpriteRscBuilder", 2, new Object[] { "getNicknamePath uin:", ((IApolloUtil)QRoute.api(IApolloUtil.class)).wrapLogUin(paramString), ", isMe:", Boolean.valueOf(bool2), ",isYellowVip:", Boolean.valueOf(bool1), ",isRight:", Boolean.valueOf(paramBoolean), ",bubbleId:", Integer.valueOf(i) });
    }
    return ApolloActionHelperImpl.getBubbleRscName(paramInt, i, localApolloManagerServiceImpl.getCmShowStatus(paramQQAppInterface, paramString));
  }
  
  public static String a(String paramString, int paramInt1, int paramInt2)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    int i = ApolloUtilImpl.handleBubbleType(208.0F, paramString, paramInt2);
    if ((!ApolloUtilImpl.isBubbleRscExist(paramInt1, i)) && (!ApolloUtilImpl.isBubbleRscExist(0, i))) {
      return "";
    }
    return ApolloActionHelperImpl.getBubbleRscName(paramInt1, i, paramInt2);
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
  
  private static String a(boolean paramBoolean, String paramString, int paramInt)
  {
    boolean bool2 = false;
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    boolean bool1;
    try
    {
      Object localObject2 = new JSONObject(paramString).optJSONObject("action");
      Object localObject1;
      if (paramBoolean)
      {
        localObject1 = ((JSONObject)localObject2).optString("actionId");
        if (((JSONObject)localObject2).optInt("actionPlatform") <= 0) {
          break label246;
        }
        bool1 = true;
        break label243;
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          if (!paramBoolean) {
            bool2 = true;
          }
          if (ApolloUtilImpl.isRandomSubActionDone(paramInt, bool2, Integer.parseInt((String)localObject1), bool1))
          {
            localObject2 = File.separator + (String)localObject1;
            localObject1 = localObject2;
            if (bool1) {
              localObject1 = (String)localObject2 + File.separator + "android";
            }
            return (String)localObject1 + File.separator + "action";
          }
        }
      }
      else
      {
        localObject1 = ((JSONObject)localObject2).optString("actionPeerId");
        int i = ((JSONObject)localObject2).optInt("actionPeerPlatform");
        if (i > 0) {}
        for (bool1 = true;; bool1 = false) {
          break;
        }
      }
      return null;
    }
    catch (Exception localException)
    {
      QLog.e("CmShow_SpriteRscBuilder", 1, "[random] the json is not right," + paramString);
    }
    for (;;)
    {
      label243:
      break;
      label246:
      bool1 = false;
    }
  }
  
  private static JSONArray a(SpriteTaskParam paramSpriteTaskParam, IPCSpriteContext paramIPCSpriteContext)
  {
    if ((paramSpriteTaskParam == null) || (paramIPCSpriteContext == null)) {
      return null;
    }
    long l1 = System.currentTimeMillis();
    for (;;)
    {
      int k;
      int m;
      try
      {
        localQQAppInterface = ((IApolloUtil)QRoute.api(IApolloUtil.class)).getQQApp();
        localJSONArray = new JSONArray();
        paramSpriteTaskParam = paramSpriteTaskParam.jdField_a_of_type_JavaUtilArrayList;
        localApolloDaoManagerServiceImpl = (ApolloDaoManagerServiceImpl)localQQAppInterface.getRuntimeService(IApolloDaoManagerService.class, "all");
        i = 0;
        k = 0;
        j = -1;
        if (k < paramSpriteTaskParam.size())
        {
          m = ((Integer)paramSpriteTaskParam.get(k)).intValue();
          if (-1 != j)
          {
            localObject = localApolloDaoManagerServiceImpl.findActionById(j);
            if ((localObject != null) && (((ApolloActionData)localObject).isHasPostAction()) && (j != m))
            {
              localObject = a(j, 2, paramIPCSpriteContext);
              if (localObject != null) {
                localJSONArray.put(localObject);
              }
            }
          }
          Object localObject = localApolloDaoManagerServiceImpl.findActionById(m);
          if (localObject != null)
          {
            if ((m != j) && (((ApolloActionData)localObject).isHasPreAction()))
            {
              localObject = a(m, 0, paramIPCSpriteContext);
              if (localObject != null) {
                localJSONArray.put(localObject);
              }
            }
            localObject = a(m, 1, paramIPCSpriteContext);
            if (localObject == null) {
              break label435;
            }
            localJSONArray.put(localObject);
            break label435;
          }
          j = -1;
          i = 1;
          QLog.i("CmShow_SpriteRscBuilder", 1, "[insertPrePost], action NOT exist locally, id:" + m);
        }
      }
      catch (Throwable paramSpriteTaskParam)
      {
        QQAppInterface localQQAppInterface;
        JSONArray localJSONArray;
        ApolloDaoManagerServiceImpl localApolloDaoManagerServiceImpl;
        int i;
        QLog.e("CmShow_SpriteRscBuilder", 1, "[getWhiteFaceActions],", paramSpriteTaskParam);
        return null;
        if (-1 != j)
        {
          paramSpriteTaskParam = localApolloDaoManagerServiceImpl.findActionById(j);
          if ((paramSpriteTaskParam != null) && (paramSpriteTaskParam.isHasPostAction()))
          {
            paramSpriteTaskParam = a(j, 2, paramIPCSpriteContext);
            if (paramSpriteTaskParam != null) {
              localJSONArray.put(paramSpriteTaskParam);
            }
          }
        }
        if (i != 0) {
          ApolloContentUpdateHandler.a(localQQAppInterface, 1);
        }
        return localJSONArray;
      }
      finally
      {
        long l2 = System.currentTimeMillis();
        if (QLog.isColorLevel()) {
          QLog.d("CmShow_SpriteRscBuilder", 2, new Object[] { "[getWhiteFaceActions], cost:", Long.valueOf(l2 - l1) });
        }
      }
      label435:
      int j = m;
      k += 1;
    }
  }
  
  private static JSONArray a(SpriteTaskParam paramSpriteTaskParam, IPCSpriteContext paramIPCSpriteContext, PlayActionConfig paramPlayActionConfig)
  {
    if ((paramSpriteTaskParam == null) || (paramIPCSpriteContext == null)) {
      return null;
    }
    long l1 = System.currentTimeMillis();
    for (;;)
    {
      try
      {
        JSONArray localJSONArray = new JSONArray();
        JSONObject localJSONObject = a(paramSpriteTaskParam.jdField_a_of_type_JavaLangString, paramIPCSpriteContext, paramSpriteTaskParam, true, false, paramPlayActionConfig);
        if ((CmShowAioMatcher.a(paramSpriteTaskParam.h, 1)) || (paramSpriteTaskParam.e == 1))
        {
          paramSpriteTaskParam = a(paramSpriteTaskParam.jdField_b_of_type_JavaLangString, paramIPCSpriteContext, paramSpriteTaskParam, false, false, paramPlayActionConfig);
          if (localJSONObject != null) {
            localJSONArray.put(localJSONObject);
          }
          if (paramSpriteTaskParam != null) {
            localJSONArray.put(paramSpriteTaskParam);
          }
          return localJSONArray;
        }
      }
      catch (Throwable paramSpriteTaskParam)
      {
        QLog.e("CmShow_SpriteRscBuilder", 1, "[getBasicActionJs],", paramSpriteTaskParam);
        return null;
      }
      finally
      {
        long l2 = System.currentTimeMillis();
        if (QLog.isColorLevel()) {
          QLog.d("CmShow_SpriteRscBuilder", 2, new Object[] { "[getBasicActionJs], cost:", Long.valueOf(l2 - l1) });
        }
      }
      paramSpriteTaskParam = null;
    }
  }
  
  private static JSONObject a(int paramInt1, int paramInt2, IPCSpriteContext paramIPCSpriteContext)
  {
    JSONObject localJSONObject;
    try
    {
      Object localObject = ((IApolloUtil)QRoute.api(IApolloUtil.class)).getQQApp();
      localJSONObject = new JSONObject();
      SpriteTaskParam localSpriteTaskParam = new SpriteTaskParam();
      localSpriteTaskParam.f = paramInt1;
      localSpriteTaskParam.jdField_d_of_type_Int = paramInt2;
      localSpriteTaskParam.h = paramIPCSpriteContext.jdField_a_of_type_Int;
      localSpriteTaskParam.jdField_c_of_type_Int = 1;
      if (!a(localSpriteTaskParam)) {
        return null;
      }
      localObject = ((ApolloDaoManagerServiceImpl)((QQAppInterface)localObject).getRuntimeService(IApolloDaoManagerService.class, "all")).findActionById(paramInt1);
      if (localObject == null) {
        return null;
      }
      localJSONObject.put("actionId", paramInt1);
      localJSONObject.put("action", ApolloActionHelperImpl.getWhiteFaceRscPath(paramInt1, paramInt2, true, paramIPCSpriteContext.a())[0]);
      if (((ApolloActionData)localObject).personNum == 1) {
        localJSONObject.put("actionPeer", ApolloActionHelperImpl.getWhiteFaceRscPath(paramInt1, paramInt2, false, paramIPCSpriteContext.a())[0]);
      }
      while (CmShowAioMatcher.a(paramIPCSpriteContext.jdField_a_of_type_Int, 1))
      {
        localJSONObject.put("actionDis", ((ApolloActionData)localObject).actionMoveDis * (float)DeviceInfoUtil.j() / 7.0F / 368.0F);
        localJSONObject.put("actionPeerDis", ((ApolloActionData)localObject).peerMoveDis * (float)DeviceInfoUtil.j() / 7.0F / 368.0F);
        return localJSONObject;
        localJSONObject.put("actionPeer", new String[0]);
      }
      localJSONObject.put("posType", ((ApolloActionData)localObject).playArea);
    }
    catch (Throwable paramIPCSpriteContext)
    {
      QLog.e("CmShow_SpriteRscBuilder", 1, "[getWhiteFaceSingleAction],", paramIPCSpriteContext);
      return null;
    }
    return localJSONObject;
  }
  
  public static JSONObject a(SpriteTaskParam paramSpriteTaskParam)
  {
    label397:
    for (;;)
    {
      try
      {
        Object localObject2;
        Object localObject1;
        if ((paramSpriteTaskParam.k == 12) && (paramSpriteTaskParam.f > 0))
        {
          localObject2 = ApolloUtilImpl.getAudioPathForAction(paramSpriteTaskParam.f);
          if (!new File((String)localObject2).exists())
          {
            localObject1 = localObject2;
            if (QLog.isColorLevel())
            {
              QLog.d("CmShow_SpriteRscBuilder", 1, new Object[] { "[getAudioParam] audio not found for " + (String)localObject2, ",action:", Integer.valueOf(paramSpriteTaskParam.f) });
              localObject1 = localObject2;
            }
            int i = ((String)localObject1).indexOf(".apollo");
            if (-1 != i)
            {
              localObject1 = ((String)localObject1).substring(i + ".apollo/action/".length());
              localObject2 = new JSONObject();
              ((JSONObject)localObject2).put("path", localObject1);
              ((JSONObject)localObject2).put("delayMill", paramSpriteTaskParam.jdField_a_of_type_Float * 1000.0F);
              return localObject2;
            }
          }
          else
          {
            localObject1 = ((String)localObject2).substring("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/action/".length());
            continue;
          }
        }
        else
        {
          QQAppInterface localQQAppInterface = ((IApolloUtil)QRoute.api(IApolloUtil.class)).getQQApp();
          if (localQQAppInterface == null) {
            return null;
          }
          ApolloManagerServiceImpl localApolloManagerServiceImpl = (ApolloManagerServiceImpl)localQQAppInterface.getRuntimeService(IApolloManagerService.class, "all");
          ApolloActionData localApolloActionData = ((ApolloDaoManagerServiceImpl)localQQAppInterface.getRuntimeService(IApolloDaoManagerService.class, "all")).findActionById(paramSpriteTaskParam.f);
          if ((localApolloActionData != null) && (localApolloActionData.hasSound))
          {
            localObject2 = "/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/action/" + paramSpriteTaskParam.f + "/" + "music.amr";
            localObject1 = localObject2;
            if (new File((String)localObject2).exists()) {
              break label397;
            }
            localApolloManagerServiceImpl.downloadApolloRes(localApolloActionData, 4, null);
            localObject1 = localObject2;
            continue;
          }
          if (paramSpriteTaskParam.i > 0)
          {
            localObject2 = ((IApolloResDownloader)QRoute.api(IApolloResDownloader.class)).getAudioFilePath(paramSpriteTaskParam.i);
            localObject1 = localObject2;
            if (new File((String)localObject2).exists()) {
              break label397;
            }
            ((IApolloResDownloader)QRoute.api(IApolloResDownloader.class)).downloadApolloAudio(localQQAppInterface, null, paramSpriteTaskParam.i, false);
            localObject1 = localObject2;
            continue;
          }
          return null;
        }
      }
      catch (Exception paramSpriteTaskParam)
      {
        QLog.e("CmShow_SpriteRscBuilder", 1, paramSpriteTaskParam, new Object[0]);
        return null;
      }
    }
  }
  
  private static JSONObject a(String paramString, IPCSpriteContext paramIPCSpriteContext, SpriteTaskParam paramSpriteTaskParam, boolean paramBoolean1, boolean paramBoolean2, PlayActionConfig paramPlayActionConfig)
  {
    JSONObject localJSONObject;
    for (;;)
    {
      Object localObject;
      int m;
      int i;
      int j;
      int n;
      try
      {
        localJSONObject = b(paramString, paramIPCSpriteContext, false);
        if (!a(paramSpriteTaskParam)) {
          return localJSONObject;
        }
        localObject = ((IApolloUtil)QRoute.api(IApolloUtil.class)).getQQApp();
        if (localObject == null) {
          return null;
        }
        ApolloManagerServiceImpl localApolloManagerServiceImpl = (ApolloManagerServiceImpl)((QQAppInterface)localObject).getRuntimeService(IApolloManagerService.class, "all");
        m = localApolloManagerServiceImpl.getCmShowStatus((QQAppInterface)localObject, paramString);
        boolean bool = localApolloManagerServiceImpl.is3dAvailable((QQAppInterface)localObject);
        i = ((Integer)ApolloActionHelperImpl.get3DRoleDressIdByUin(paramString, m, localObject, true)[0]).intValue();
        paramString = ApolloActionHelperImpl.getRoleDressIdByUin(paramString, (QQAppInterface)localObject, true);
        if ((paramString == null) || (paramString.length != 2)) {
          break label643;
        }
        j = ((Integer)paramString[0]).intValue();
        if (paramSpriteTaskParam == null) {
          break;
        }
        if (!paramBoolean1) {
          break label647;
        }
        k = 1;
        localJSONObject.put("isMaster", k);
        if ((paramBoolean1) && (!TextUtils.isEmpty(paramSpriteTaskParam.jdField_c_of_type_JavaLangString)))
        {
          localJSONObject.put("text", SpriteUtil.a(Base64Util.encodeToString(paramSpriteTaskParam.jdField_c_of_type_JavaLangString.getBytes("utf-8"), 0)));
          if (paramSpriteTaskParam.jdField_b_of_type_Boolean) {
            continue;
          }
          localJSONObject.put("bubbleType", 0);
          if ((m == 1) && (paramSpriteTaskParam.f > ApolloConstant.jdField_b_of_type_Int) && (bool))
          {
            k = 2;
            localJSONObject.put("bubble", a(paramSpriteTaskParam.jdField_c_of_type_JavaLangString, j, k));
          }
        }
        else
        {
          n = paramSpriteTaskParam.k;
          i1 = paramSpriteTaskParam.f;
          if (i < 0) {
            break label345;
          }
          k = i;
          paramString = ApolloActionHelperImpl.getActionRscPathByPlayConfig(n, i1, k, paramBoolean1, m, paramPlayActionConfig);
          if (paramString == null) {
            break label645;
          }
          if (paramString.length >= 2) {
            break label352;
          }
          break label645;
        }
        if ((m != 2) || (paramSpriteTaskParam.f >= ApolloConstant.jdField_b_of_type_Int)) {
          break label636;
        }
        k = 1;
        continue;
        localJSONObject.put("bubbleType", 1);
        continue;
        k = j;
      }
      catch (Throwable paramString)
      {
        QLog.e("CmShow_SpriteRscBuilder", 1, paramString, new Object[0]);
        return null;
      }
      label345:
      continue;
      label352:
      if ((paramSpriteTaskParam.e == 0) && (paramIPCSpriteContext.jdField_a_of_type_Int == 0) && (!paramBoolean1) && (!paramBoolean2)) {
        break;
      }
      paramIPCSpriteContext = paramString[0];
      paramString = paramIPCSpriteContext;
      if (8 == paramSpriteTaskParam.jdField_c_of_type_Int)
      {
        paramString = paramIPCSpriteContext;
        if (!TextUtils.isEmpty(paramSpriteTaskParam.jdField_d_of_type_JavaLangString))
        {
          localObject = a(paramBoolean1, paramSpriteTaskParam.jdField_d_of_type_JavaLangString, paramSpriteTaskParam.f);
          paramString = paramIPCSpriteContext;
          if (!TextUtils.isEmpty((CharSequence)localObject)) {
            paramString = paramIPCSpriteContext + (String)localObject;
          }
        }
      }
      localJSONObject.put("action", paramString);
      if (paramPlayActionConfig == null) {
        break;
      }
      int i1 = paramPlayActionConfig.jdField_c_of_type_Int;
      paramPlayActionConfig.jdField_c_of_type_Int = 1;
      int i2 = paramSpriteTaskParam.f;
      if (i >= 0)
      {
        k = i;
        localJSONObject.put("preAction", ApolloActionHelperImpl.getActionRscPathByPlayConfig(n, i2, k, paramBoolean1, m, paramPlayActionConfig)[0]);
        paramPlayActionConfig.jdField_c_of_type_Int = 2;
        i2 = paramSpriteTaskParam.f;
        if (i < 0) {
          break label622;
        }
        k = i;
        label538:
        localJSONObject.put("mainAction", ApolloActionHelperImpl.getActionRscPathByPlayConfig(n, i2, k, paramBoolean1, m, paramPlayActionConfig)[0]);
        paramPlayActionConfig.jdField_c_of_type_Int = 3;
        k = paramSpriteTaskParam.f;
        if (i < 0) {
          break label629;
        }
      }
      for (;;)
      {
        localJSONObject.put("postAction", ApolloActionHelperImpl.getActionRscPathByPlayConfig(n, k, i, paramBoolean1, m, paramPlayActionConfig)[0]);
        paramPlayActionConfig.jdField_c_of_type_Int = i1;
        break label653;
        k = j;
        break;
        label622:
        k = j;
        break label538;
        label629:
        i = j;
      }
      label636:
      int k = m;
      continue;
      label643:
      return null;
      label645:
      return null;
      label647:
      k = 0;
    }
    label653:
    return localJSONObject;
  }
  
  /* Error */
  public static JSONObject a(String paramString, IPCSpriteContext paramIPCSpriteContext, boolean paramBoolean)
  {
    // Byte code:
    //   0: new 61	org/json/JSONObject
    //   3: dup
    //   4: invokespecial 62	org/json/JSONObject:<init>	()V
    //   7: astore 13
    //   9: iconst_1
    //   10: istore 10
    //   12: iconst_1
    //   13: istore 11
    //   15: iconst_1
    //   16: istore 5
    //   18: iconst_m1
    //   19: istore 4
    //   21: new 404	java/util/ArrayList
    //   24: dup
    //   25: invokespecial 615	java/util/ArrayList:<init>	()V
    //   28: astore 16
    //   30: ldc 49
    //   32: invokestatic 55	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   35: checkcast 49	com/tencent/mobileqq/apollo/api/uitls/IApolloUtil
    //   38: invokeinterface 59 1 0
    //   43: astore 15
    //   45: aload 15
    //   47: ifnonnull +9 -> 56
    //   50: aconst_null
    //   51: astore 14
    //   53: aload 14
    //   55: areturn
    //   56: aload 15
    //   58: ldc 203
    //   60: ldc 205
    //   62: invokevirtual 211	com/tencent/mobileqq/app/QQAppInterface:getRuntimeService	(Ljava/lang/Class;Ljava/lang/String;)Lmqq/app/api/IRuntimeService;
    //   65: checkcast 213	com/tencent/mobileqq/apollo/api/impl/ApolloManagerServiceImpl
    //   68: astore 12
    //   70: iload 4
    //   72: istore 8
    //   74: iload 10
    //   76: istore 6
    //   78: iload 4
    //   80: istore 9
    //   82: iload 11
    //   84: istore 7
    //   86: aload 12
    //   88: aload_0
    //   89: invokevirtual 619	com/tencent/mobileqq/apollo/api/impl/ApolloManagerServiceImpl:getApolloBaseInfo	(Ljava/lang/String;)Lcom/tencent/mobileqq/apollo/api/model/ApolloBaseInfo;
    //   92: astore 14
    //   94: aload 14
    //   96: ifnonnull +5 -> 101
    //   99: aconst_null
    //   100: areturn
    //   101: iload 4
    //   103: istore 8
    //   105: iload 10
    //   107: istore 6
    //   109: iload 4
    //   111: istore 9
    //   113: iload 11
    //   115: istore 7
    //   117: aload 14
    //   119: invokevirtual 625	com/tencent/mobileqq/apollo/api/model/ApolloBaseInfo:getApolloPetDress	()Lcom/tencent/mobileqq/apollo/api/model/ApolloDress;
    //   122: astore 17
    //   124: aload 17
    //   126: ifnull +984 -> 1110
    //   129: iload 4
    //   131: istore 8
    //   133: iload 10
    //   135: istore 6
    //   137: iload 4
    //   139: istore 9
    //   141: iload 11
    //   143: istore 7
    //   145: aload 14
    //   147: getfield 628	com/tencent/mobileqq/apollo/api/model/ApolloBaseInfo:hasPet	Z
    //   150: ifeq +960 -> 1110
    //   153: iload 4
    //   155: istore 8
    //   157: iload 10
    //   159: istore 6
    //   161: iload 4
    //   163: istore 9
    //   165: iload 11
    //   167: istore 7
    //   169: aload 17
    //   171: getfield 634	com/tencent/mobileqq/apollo/api/model/ApolloDress:dressMap	Ljava/util/HashMap;
    //   174: ifnull +936 -> 1110
    //   177: iload 4
    //   179: istore 8
    //   181: iload 10
    //   183: istore 6
    //   185: iload 4
    //   187: istore 9
    //   189: iload 11
    //   191: istore 7
    //   193: aload 17
    //   195: getfield 634	com/tencent/mobileqq/apollo/api/model/ApolloDress:dressMap	Ljava/util/HashMap;
    //   198: invokevirtual 636	java/util/HashMap:isEmpty	()Z
    //   201: ifne +909 -> 1110
    //   204: iload 4
    //   206: istore 8
    //   208: iload 10
    //   210: istore 6
    //   212: iload 4
    //   214: istore 9
    //   216: iload 11
    //   218: istore 7
    //   220: aload 13
    //   222: ldc_w 638
    //   225: iconst_0
    //   226: aload 17
    //   228: getfield 640	com/tencent/mobileqq/apollo/api/model/ApolloDress:roleId	I
    //   231: invokestatic 644	com/tencent/mobileqq/apollo/api/uitls/impl/ApolloActionHelperImpl:getApolloRsc	(II)Ljava/lang/String;
    //   234: invokevirtual 96	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   237: pop
    //   238: iload 4
    //   240: istore_3
    //   241: iload 4
    //   243: istore 8
    //   245: iload 10
    //   247: istore 6
    //   249: iload 4
    //   251: istore 9
    //   253: iload 11
    //   255: istore 7
    //   257: iconst_1
    //   258: aload 17
    //   260: getfield 640	com/tencent/mobileqq/apollo/api/model/ApolloDress:roleId	I
    //   263: invokestatic 647	com/tencent/mobileqq/apollo/api/uitls/impl/ApolloUtilImpl:isResourceDone	(II)Z
    //   266: ifne +26 -> 292
    //   269: iconst_0
    //   270: istore 6
    //   272: iconst_0
    //   273: istore 7
    //   275: iconst_0
    //   276: istore 5
    //   278: iload 4
    //   280: istore 8
    //   282: iload 4
    //   284: istore 9
    //   286: aload 17
    //   288: getfield 640	com/tencent/mobileqq/apollo/api/model/ApolloDress:roleId	I
    //   291: istore_3
    //   292: iload_3
    //   293: istore 8
    //   295: iload 5
    //   297: istore 6
    //   299: iload_3
    //   300: istore 9
    //   302: iload 5
    //   304: istore 7
    //   306: aload 17
    //   308: getfield 634	com/tencent/mobileqq/apollo/api/model/ApolloDress:dressMap	Ljava/util/HashMap;
    //   311: invokevirtual 648	java/util/HashMap:size	()I
    //   314: newarray int
    //   316: astore 18
    //   318: iload_3
    //   319: istore 8
    //   321: iload 5
    //   323: istore 6
    //   325: iload_3
    //   326: istore 9
    //   328: iload 5
    //   330: istore 7
    //   332: aload 17
    //   334: getfield 634	com/tencent/mobileqq/apollo/api/model/ApolloDress:dressMap	Ljava/util/HashMap;
    //   337: invokevirtual 652	java/util/HashMap:entrySet	()Ljava/util/Set;
    //   340: invokeinterface 658 1 0
    //   345: astore 19
    //   347: iconst_0
    //   348: istore 4
    //   350: iload_3
    //   351: istore 8
    //   353: iload 5
    //   355: istore 6
    //   357: iload_3
    //   358: istore 9
    //   360: iload 5
    //   362: istore 7
    //   364: aload 19
    //   366: invokeinterface 663 1 0
    //   371: ifeq +52 -> 423
    //   374: iload_3
    //   375: istore 8
    //   377: iload 5
    //   379: istore 6
    //   381: iload_3
    //   382: istore 9
    //   384: iload 5
    //   386: istore 7
    //   388: aload 18
    //   390: iload 4
    //   392: aload 19
    //   394: invokeinterface 667 1 0
    //   399: checkcast 669	java/util/Map$Entry
    //   402: invokeinterface 672 1 0
    //   407: checkcast 300	java/lang/Integer
    //   410: invokevirtual 414	java/lang/Integer:intValue	()I
    //   413: iastore
    //   414: iload 4
    //   416: iconst_1
    //   417: iadd
    //   418: istore 4
    //   420: goto -70 -> 350
    //   423: iload_3
    //   424: istore 8
    //   426: iload 5
    //   428: istore 6
    //   430: iload_3
    //   431: istore 9
    //   433: iload 5
    //   435: istore 7
    //   437: new 184	org/json/JSONArray
    //   440: dup
    //   441: invokespecial 185	org/json/JSONArray:<init>	()V
    //   444: astore 19
    //   446: iload_3
    //   447: istore 8
    //   449: iload 5
    //   451: istore 6
    //   453: iload_3
    //   454: istore 9
    //   456: iload 5
    //   458: istore 7
    //   460: aload 18
    //   462: arraylength
    //   463: istore 10
    //   465: iload 5
    //   467: istore 4
    //   469: iconst_0
    //   470: istore 7
    //   472: iload 7
    //   474: iload 10
    //   476: if_icmpge +72 -> 548
    //   479: aload 18
    //   481: iload 7
    //   483: iaload
    //   484: istore 8
    //   486: iload 4
    //   488: istore 5
    //   490: iload 4
    //   492: istore 6
    //   494: aload 19
    //   496: iconst_1
    //   497: iload 8
    //   499: invokestatic 644	com/tencent/mobileqq/apollo/api/uitls/impl/ApolloActionHelperImpl:getApolloRsc	(II)Ljava/lang/String;
    //   502: invokevirtual 193	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   505: pop
    //   506: iload 4
    //   508: istore 5
    //   510: iload 4
    //   512: istore 6
    //   514: iconst_2
    //   515: iload 8
    //   517: invokestatic 647	com/tencent/mobileqq/apollo/api/uitls/impl/ApolloUtilImpl:isResourceDone	(II)Z
    //   520: ifne +934 -> 1454
    //   523: iconst_0
    //   524: istore 6
    //   526: iconst_0
    //   527: istore 4
    //   529: iconst_0
    //   530: istore 5
    //   532: aload 16
    //   534: iload 8
    //   536: invokestatic 303	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   539: invokeinterface 677 2 0
    //   544: pop
    //   545: goto +909 -> 1454
    //   548: iload 4
    //   550: istore 5
    //   552: iload 4
    //   554: istore 6
    //   556: aload 13
    //   558: ldc_w 679
    //   561: aload 19
    //   563: invokevirtual 96	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   566: pop
    //   567: iload 4
    //   569: istore 5
    //   571: iload 4
    //   573: istore 6
    //   575: aload 13
    //   577: ldc_w 340
    //   580: aload 17
    //   582: getfield 640	com/tencent/mobileqq/apollo/api/model/ApolloDress:roleId	I
    //   585: invokevirtual 101	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   588: pop
    //   589: iload 4
    //   591: istore 5
    //   593: iload 4
    //   595: istore 6
    //   597: aload 17
    //   599: getfield 640	com/tencent/mobileqq/apollo/api/model/ApolloDress:roleId	I
    //   602: ldc_w 681
    //   605: invokestatic 683	com/tencent/mobileqq/apollo/sdk/CmShowSpriteRscBuilder:a	(ILjava/lang/String;)Ljava/lang/String;
    //   608: astore 18
    //   610: iload 4
    //   612: istore 5
    //   614: iload 4
    //   616: istore 6
    //   618: aload 17
    //   620: getfield 640	com/tencent/mobileqq/apollo/api/model/ApolloDress:roleId	I
    //   623: ldc_w 685
    //   626: invokestatic 683	com/tencent/mobileqq/apollo/sdk/CmShowSpriteRscBuilder:a	(ILjava/lang/String;)Ljava/lang/String;
    //   629: astore 19
    //   631: iload 4
    //   633: istore 5
    //   635: iload 4
    //   637: istore 6
    //   639: aload 18
    //   641: invokestatic 146	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   644: ifne +57 -> 701
    //   647: iload 4
    //   649: istore 5
    //   651: iload 4
    //   653: istore 6
    //   655: aload 19
    //   657: invokestatic 146	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   660: ifne +41 -> 701
    //   663: iload 4
    //   665: istore 5
    //   667: iload 4
    //   669: istore 6
    //   671: aload 13
    //   673: ldc_w 687
    //   676: aload 19
    //   678: invokevirtual 96	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   681: pop
    //   682: iload 4
    //   684: istore 5
    //   686: iload 4
    //   688: istore 6
    //   690: aload 13
    //   692: ldc_w 689
    //   695: aload 18
    //   697: invokevirtual 96	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   700: pop
    //   701: iload 4
    //   703: istore 5
    //   705: iload 4
    //   707: istore 6
    //   709: aload 15
    //   711: aload 17
    //   713: getfield 640	com/tencent/mobileqq/apollo/api/model/ApolloDress:roleId	I
    //   716: invokestatic 691	com/tencent/mobileqq/apollo/sdk/CmShowSpriteRscBuilder:a	(Lcom/tencent/mobileqq/app/QQAppInterface;I)Ljava/lang/String;
    //   719: astore 18
    //   721: iload 4
    //   723: istore 5
    //   725: iload 4
    //   727: istore 6
    //   729: aload 18
    //   731: invokestatic 146	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   734: ifne +22 -> 756
    //   737: iload 4
    //   739: istore 5
    //   741: iload 4
    //   743: istore 6
    //   745: aload 13
    //   747: ldc_w 693
    //   750: aload 18
    //   752: invokevirtual 96	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   755: pop
    //   756: iload 4
    //   758: istore 5
    //   760: iload 4
    //   762: istore 6
    //   764: aload 14
    //   766: getfield 696	com/tencent/mobileqq/apollo/api/model/ApolloBaseInfo:petNick	Ljava/lang/String;
    //   769: invokestatic 146	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   772: ifne +53 -> 825
    //   775: iload 4
    //   777: istore 5
    //   779: iload 4
    //   781: istore 6
    //   783: aload_1
    //   784: getfield 65	com/tencent/mobileqq/apollo/sdk/IPCSpriteContext:jdField_b_of_type_Int	I
    //   787: ifne +38 -> 825
    //   790: iload 4
    //   792: istore 5
    //   794: iload 4
    //   796: istore 6
    //   798: aload 13
    //   800: ldc_w 698
    //   803: aload 14
    //   805: getfield 696	com/tencent/mobileqq/apollo/api/model/ApolloBaseInfo:petNick	Ljava/lang/String;
    //   808: ldc_w 579
    //   811: invokevirtual 583	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   814: iconst_0
    //   815: invokestatic 589	com/tencent/mobileqq/utils/Base64Util:encodeToString	([BI)Ljava/lang/String;
    //   818: invokestatic 591	com/tencent/mobileqq/apollo/script/SpriteUtil:a	(Ljava/lang/String;)Ljava/lang/String;
    //   821: invokevirtual 96	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   824: pop
    //   825: iload 4
    //   827: istore 5
    //   829: iload 4
    //   831: istore 6
    //   833: aload 13
    //   835: ldc_w 700
    //   838: aload 12
    //   840: getfield 703	com/tencent/mobileqq/apollo/api/impl/ApolloManagerServiceImpl:mPetConfig	Ljava/lang/String;
    //   843: aload 17
    //   845: getfield 640	com/tencent/mobileqq/apollo/api/model/ApolloDress:roleId	I
    //   848: iload_2
    //   849: invokestatic 705	com/tencent/mobileqq/apollo/sdk/CmShowSpriteRscBuilder:a	(Ljava/lang/String;IZ)Ljava/lang/String;
    //   852: invokevirtual 96	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   855: pop
    //   856: iload 4
    //   858: istore 5
    //   860: iload 4
    //   862: istore 6
    //   864: aload 13
    //   866: ldc_w 707
    //   869: aload_1
    //   870: getfield 708	com/tencent/mobileqq/apollo/sdk/IPCSpriteContext:jdField_a_of_type_Float	F
    //   873: f2d
    //   874: invokevirtual 494	org/json/JSONObject:put	(Ljava/lang/String;D)Lorg/json/JSONObject;
    //   877: pop
    //   878: iload 4
    //   880: istore 5
    //   882: iload 4
    //   884: istore 6
    //   886: aload_1
    //   887: getfield 710	com/tencent/mobileqq/apollo/sdk/IPCSpriteContext:jdField_b_of_type_Float	F
    //   890: ldc_w 711
    //   893: fcmpl
    //   894: ifeq +25 -> 919
    //   897: iload 4
    //   899: istore 5
    //   901: iload 4
    //   903: istore 6
    //   905: aload 13
    //   907: ldc_w 713
    //   910: aload_1
    //   911: getfield 710	com/tencent/mobileqq/apollo/sdk/IPCSpriteContext:jdField_b_of_type_Float	F
    //   914: f2d
    //   915: invokevirtual 494	org/json/JSONObject:put	(Ljava/lang/String;D)Lorg/json/JSONObject;
    //   918: pop
    //   919: iload 4
    //   921: istore 5
    //   923: iload 4
    //   925: istore 6
    //   927: aload_1
    //   928: getfield 715	com/tencent/mobileqq/apollo/sdk/IPCSpriteContext:c	F
    //   931: ldc_w 711
    //   934: fcmpl
    //   935: ifeq +25 -> 960
    //   938: iload 4
    //   940: istore 5
    //   942: iload 4
    //   944: istore 6
    //   946: aload 13
    //   948: ldc_w 717
    //   951: aload_1
    //   952: getfield 715	com/tencent/mobileqq/apollo/sdk/IPCSpriteContext:c	F
    //   955: f2d
    //   956: invokevirtual 494	org/json/JSONObject:put	(Ljava/lang/String;D)Lorg/json/JSONObject;
    //   959: pop
    //   960: iload 4
    //   962: ifeq +113 -> 1075
    //   965: aload 13
    //   967: astore 14
    //   969: iload 4
    //   971: ifne -918 -> 53
    //   974: aload 13
    //   976: astore 14
    //   978: aload_1
    //   979: ifnull -926 -> 53
    //   982: ldc 229
    //   984: iconst_1
    //   985: new 200	java/lang/StringBuilder
    //   988: dup
    //   989: invokespecial 201	java/lang/StringBuilder:<init>	()V
    //   992: ldc_w 719
    //   995: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   998: aload_0
    //   999: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1002: invokevirtual 239	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1005: invokestatic 389	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1008: aload 13
    //   1010: astore 14
    //   1012: aload 12
    //   1014: ifnull -961 -> 53
    //   1017: aload 16
    //   1019: invokeinterface 720 1 0
    //   1024: newarray int
    //   1026: astore_1
    //   1027: aload 16
    //   1029: invokeinterface 721 1 0
    //   1034: astore 14
    //   1036: iconst_0
    //   1037: istore 4
    //   1039: aload 14
    //   1041: invokeinterface 663 1 0
    //   1046: ifeq +35 -> 1081
    //   1049: aload_1
    //   1050: iload 4
    //   1052: aload 14
    //   1054: invokeinterface 667 1 0
    //   1059: checkcast 300	java/lang/Integer
    //   1062: invokevirtual 414	java/lang/Integer:intValue	()I
    //   1065: iastore
    //   1066: iload 4
    //   1068: iconst_1
    //   1069: iadd
    //   1070: istore 4
    //   1072: goto -33 -> 1039
    //   1075: aconst_null
    //   1076: astore 13
    //   1078: goto -113 -> 965
    //   1081: ldc 252
    //   1083: invokestatic 55	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   1086: checkcast 252	com/tencent/mobileqq/apollo/api/res/IApolloResDownloader
    //   1089: aload 15
    //   1091: aload_0
    //   1092: aload 12
    //   1094: invokevirtual 725	com/tencent/mobileqq/apollo/api/impl/ApolloManagerServiceImpl:getResDownloadListener	()Lcom/tencent/mobileqq/apollo/api/res/IApolloResDownloader$OnApolloDownLoadListener;
    //   1097: iload_3
    //   1098: aload_1
    //   1099: iconst_m1
    //   1100: iconst_m1
    //   1101: iconst_1
    //   1102: invokeinterface 729 9 0
    //   1107: aload 13
    //   1109: areturn
    //   1110: aconst_null
    //   1111: areturn
    //   1112: astore 13
    //   1114: aconst_null
    //   1115: astore 12
    //   1117: iconst_1
    //   1118: istore 5
    //   1120: iload 4
    //   1122: istore_3
    //   1123: iload 5
    //   1125: istore 4
    //   1127: ldc 173
    //   1129: iconst_1
    //   1130: aload 13
    //   1132: iconst_0
    //   1133: anewarray 4	java/lang/Object
    //   1136: invokestatic 560	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   1139: iload 4
    //   1141: ifne +122 -> 1263
    //   1144: aload_1
    //   1145: ifnull +118 -> 1263
    //   1148: ldc 229
    //   1150: iconst_1
    //   1151: new 200	java/lang/StringBuilder
    //   1154: dup
    //   1155: invokespecial 201	java/lang/StringBuilder:<init>	()V
    //   1158: ldc_w 719
    //   1161: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1164: aload_0
    //   1165: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1168: invokevirtual 239	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1171: invokestatic 389	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1174: aload 12
    //   1176: ifnull +87 -> 1263
    //   1179: aload 16
    //   1181: invokeinterface 720 1 0
    //   1186: newarray int
    //   1188: astore_1
    //   1189: aload 16
    //   1191: invokeinterface 721 1 0
    //   1196: astore 13
    //   1198: iconst_0
    //   1199: istore 4
    //   1201: aload 13
    //   1203: invokeinterface 663 1 0
    //   1208: ifeq +29 -> 1237
    //   1211: aload_1
    //   1212: iload 4
    //   1214: aload 13
    //   1216: invokeinterface 667 1 0
    //   1221: checkcast 300	java/lang/Integer
    //   1224: invokevirtual 414	java/lang/Integer:intValue	()I
    //   1227: iastore
    //   1228: iload 4
    //   1230: iconst_1
    //   1231: iadd
    //   1232: istore 4
    //   1234: goto -33 -> 1201
    //   1237: ldc 252
    //   1239: invokestatic 55	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   1242: checkcast 252	com/tencent/mobileqq/apollo/api/res/IApolloResDownloader
    //   1245: aload 15
    //   1247: aload_0
    //   1248: aload 12
    //   1250: invokevirtual 725	com/tencent/mobileqq/apollo/api/impl/ApolloManagerServiceImpl:getResDownloadListener	()Lcom/tencent/mobileqq/apollo/api/res/IApolloResDownloader$OnApolloDownLoadListener;
    //   1253: iload_3
    //   1254: aload_1
    //   1255: iconst_m1
    //   1256: iconst_m1
    //   1257: iconst_1
    //   1258: invokeinterface 729 9 0
    //   1263: aconst_null
    //   1264: areturn
    //   1265: astore 13
    //   1267: aconst_null
    //   1268: astore 12
    //   1270: iconst_1
    //   1271: istore 5
    //   1273: iload 4
    //   1275: istore_3
    //   1276: iload 5
    //   1278: istore 4
    //   1280: iload 4
    //   1282: ifne +122 -> 1404
    //   1285: aload_1
    //   1286: ifnull +118 -> 1404
    //   1289: ldc 229
    //   1291: iconst_1
    //   1292: new 200	java/lang/StringBuilder
    //   1295: dup
    //   1296: invokespecial 201	java/lang/StringBuilder:<init>	()V
    //   1299: ldc_w 719
    //   1302: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1305: aload_0
    //   1306: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1309: invokevirtual 239	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1312: invokestatic 389	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1315: aload 12
    //   1317: ifnull +87 -> 1404
    //   1320: aload 16
    //   1322: invokeinterface 720 1 0
    //   1327: newarray int
    //   1329: astore_1
    //   1330: aload 16
    //   1332: invokeinterface 721 1 0
    //   1337: astore 14
    //   1339: iconst_0
    //   1340: istore 4
    //   1342: aload 14
    //   1344: invokeinterface 663 1 0
    //   1349: ifeq +29 -> 1378
    //   1352: aload_1
    //   1353: iload 4
    //   1355: aload 14
    //   1357: invokeinterface 667 1 0
    //   1362: checkcast 300	java/lang/Integer
    //   1365: invokevirtual 414	java/lang/Integer:intValue	()I
    //   1368: iastore
    //   1369: iload 4
    //   1371: iconst_1
    //   1372: iadd
    //   1373: istore 4
    //   1375: goto -33 -> 1342
    //   1378: ldc 252
    //   1380: invokestatic 55	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   1383: checkcast 252	com/tencent/mobileqq/apollo/api/res/IApolloResDownloader
    //   1386: aload 15
    //   1388: aload_0
    //   1389: aload 12
    //   1391: invokevirtual 725	com/tencent/mobileqq/apollo/api/impl/ApolloManagerServiceImpl:getResDownloadListener	()Lcom/tencent/mobileqq/apollo/api/res/IApolloResDownloader$OnApolloDownLoadListener;
    //   1394: iload_3
    //   1395: aload_1
    //   1396: iconst_m1
    //   1397: iconst_m1
    //   1398: iconst_1
    //   1399: invokeinterface 729 9 0
    //   1404: aload 13
    //   1406: athrow
    //   1407: astore 13
    //   1409: iload 6
    //   1411: istore 4
    //   1413: iload 8
    //   1415: istore_3
    //   1416: goto -136 -> 1280
    //   1419: astore 13
    //   1421: iload 5
    //   1423: istore 4
    //   1425: goto -145 -> 1280
    //   1428: astore 13
    //   1430: goto -150 -> 1280
    //   1433: astore 13
    //   1435: iload 7
    //   1437: istore 4
    //   1439: iload 9
    //   1441: istore_3
    //   1442: goto -315 -> 1127
    //   1445: astore 13
    //   1447: iload 6
    //   1449: istore 4
    //   1451: goto -324 -> 1127
    //   1454: iload 7
    //   1456: iconst_1
    //   1457: iadd
    //   1458: istore 7
    //   1460: goto -988 -> 472
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1463	0	paramString	String
    //   0	1463	1	paramIPCSpriteContext	IPCSpriteContext
    //   0	1463	2	paramBoolean	boolean
    //   240	1202	3	i	int
    //   19	1431	4	j	int
    //   16	1406	5	k	int
    //   76	1372	6	m	int
    //   84	1375	7	n	int
    //   72	1342	8	i1	int
    //   80	1360	9	i2	int
    //   10	467	10	i3	int
    //   13	241	11	i4	int
    //   68	1322	12	localApolloManagerServiceImpl	ApolloManagerServiceImpl
    //   7	1101	13	localJSONObject	JSONObject
    //   1112	19	13	localThrowable1	Throwable
    //   1196	19	13	localIterator	java.util.Iterator
    //   1265	140	13	localObject1	Object
    //   1407	1	13	localObject2	Object
    //   1419	1	13	localObject3	Object
    //   1428	1	13	localObject4	Object
    //   1433	1	13	localThrowable2	Throwable
    //   1445	1	13	localThrowable3	Throwable
    //   51	1305	14	localObject5	Object
    //   43	1344	15	localQQAppInterface	QQAppInterface
    //   28	1303	16	localArrayList	ArrayList
    //   122	722	17	localApolloDress	com.tencent.mobileqq.apollo.api.model.ApolloDress
    //   316	435	18	localObject6	Object
    //   345	332	19	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   56	70	1112	java/lang/Throwable
    //   56	70	1265	finally
    //   86	94	1407	finally
    //   117	124	1407	finally
    //   145	153	1407	finally
    //   169	177	1407	finally
    //   193	204	1407	finally
    //   220	238	1407	finally
    //   257	269	1407	finally
    //   286	292	1407	finally
    //   306	318	1407	finally
    //   332	347	1407	finally
    //   364	374	1407	finally
    //   388	414	1407	finally
    //   437	446	1407	finally
    //   460	465	1407	finally
    //   494	506	1419	finally
    //   514	523	1419	finally
    //   532	545	1419	finally
    //   556	567	1419	finally
    //   575	589	1419	finally
    //   597	610	1419	finally
    //   618	631	1419	finally
    //   639	647	1419	finally
    //   655	663	1419	finally
    //   671	682	1419	finally
    //   690	701	1419	finally
    //   709	721	1419	finally
    //   729	737	1419	finally
    //   745	756	1419	finally
    //   764	775	1419	finally
    //   783	790	1419	finally
    //   798	825	1419	finally
    //   833	856	1419	finally
    //   864	878	1419	finally
    //   886	897	1419	finally
    //   905	919	1419	finally
    //   927	938	1419	finally
    //   946	960	1419	finally
    //   1127	1139	1428	finally
    //   86	94	1433	java/lang/Throwable
    //   117	124	1433	java/lang/Throwable
    //   145	153	1433	java/lang/Throwable
    //   169	177	1433	java/lang/Throwable
    //   193	204	1433	java/lang/Throwable
    //   220	238	1433	java/lang/Throwable
    //   257	269	1433	java/lang/Throwable
    //   286	292	1433	java/lang/Throwable
    //   306	318	1433	java/lang/Throwable
    //   332	347	1433	java/lang/Throwable
    //   364	374	1433	java/lang/Throwable
    //   388	414	1433	java/lang/Throwable
    //   437	446	1433	java/lang/Throwable
    //   460	465	1433	java/lang/Throwable
    //   494	506	1445	java/lang/Throwable
    //   514	523	1445	java/lang/Throwable
    //   532	545	1445	java/lang/Throwable
    //   556	567	1445	java/lang/Throwable
    //   575	589	1445	java/lang/Throwable
    //   597	610	1445	java/lang/Throwable
    //   618	631	1445	java/lang/Throwable
    //   639	647	1445	java/lang/Throwable
    //   655	663	1445	java/lang/Throwable
    //   671	682	1445	java/lang/Throwable
    //   690	701	1445	java/lang/Throwable
    //   709	721	1445	java/lang/Throwable
    //   729	737	1445	java/lang/Throwable
    //   745	756	1445	java/lang/Throwable
    //   764	775	1445	java/lang/Throwable
    //   783	790	1445	java/lang/Throwable
    //   798	825	1445	java/lang/Throwable
    //   833	856	1445	java/lang/Throwable
    //   864	878	1445	java/lang/Throwable
    //   886	897	1445	java/lang/Throwable
    //   905	919	1445	java/lang/Throwable
    //   927	938	1445	java/lang/Throwable
    //   946	960	1445	java/lang/Throwable
  }
  
  public static void a(String paramString)
  {
    Object localObject = ((IApolloUtil)QRoute.api(IApolloUtil.class)).getQQApp();
    if ((!TextUtils.isEmpty(paramString)) && (localObject != null))
    {
      localObject = ((IApolloManagerService)((QQAppInterface)localObject).getRuntimeService(IApolloManagerService.class, "all")).getStandUpSp();
      if (localObject != null)
      {
        localObject = ((SharedPreferences)localObject).edit();
        if (localObject != null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("CmShow_SpriteRscBuilder", 2, "[clearAction] clear action success ");
          }
          ((SharedPreferences.Editor)localObject).remove(paramString).apply();
        }
      }
    }
  }
  
  public static boolean a(SpriteTaskParam paramSpriteTaskParam)
  {
    QQAppInterface localQQAppInterface = ((IApolloUtil)QRoute.api(IApolloUtil.class)).getQQApp();
    if ((paramSpriteTaskParam == null) || (localQQAppInterface == null)) {
      return false;
    }
    if (paramSpriteTaskParam.k == 1) {
      return b(paramSpriteTaskParam);
    }
    if (paramSpriteTaskParam.k == 6)
    {
      if (!ApolloUtilImpl.isSpecialActionResDone(5, paramSpriteTaskParam.f))
      {
        ((IApolloResDownloader)QRoute.api(IApolloResDownloader.class)).downLoadSpecialAction(localQQAppInterface, ApolloUtilImpl.getApolloDrawerPath(paramSpriteTaskParam.f) + "/d.zip", ApolloUtilImpl.getApolloDrawerUrl(paramSpriteTaskParam.f));
        return false;
      }
    }
    else if (paramSpriteTaskParam.k == 12)
    {
      if (!ApolloUtilImpl.isActionResDone(paramSpriteTaskParam.f, 0))
      {
        Object localObject = new ApolloActionData();
        ((ApolloActionData)localObject).actionId = paramSpriteTaskParam.f;
        paramSpriteTaskParam = ApolloUtilImpl.getApolloResPath((ApolloActionData)localObject, 5);
        localObject = ApolloUtilImpl.getApolloResPath((ApolloActionData)localObject, 4);
        ((IApolloResDownloader)QRoute.api(IApolloResDownloader.class)).downLoadSpecialAction(localQQAppInterface, (String)localObject, paramSpriteTaskParam);
        return false;
      }
    }
    else if ((paramSpriteTaskParam.k == 11) || (paramSpriteTaskParam.k == 7))
    {
      paramSpriteTaskParam = ApolloActionHelperImpl.getActionRscPath(paramSpriteTaskParam.k, paramSpriteTaskParam.f, 0, true);
      if ((paramSpriteTaskParam.length > 0) && (!TextUtils.isEmpty(paramSpriteTaskParam[0])) && (!new File(ApolloRender.getRscStaticPath(paramSpriteTaskParam[0], "json")).exists()))
      {
        ((IApolloResDownloader)QRoute.api(IApolloResDownloader.class)).downloadApolloResOrder(localQQAppInterface, localQQAppInterface.getCurrentAccountUin(), null, 0, null, -1, -1, true);
        return false;
      }
    }
    return true;
  }
  
  /* Error */
  private static JSONArray b(SpriteTaskParam paramSpriteTaskParam, IPCSpriteContext paramIPCSpriteContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +7 -> 8
    //   4: aload_1
    //   5: ifnonnull +7 -> 12
    //   8: aconst_null
    //   9: astore_0
    //   10: aload_0
    //   11: areturn
    //   12: invokestatic 395	java/lang/System:currentTimeMillis	()J
    //   15: lstore_2
    //   16: new 184	org/json/JSONArray
    //   19: dup
    //   20: invokespecial 185	org/json/JSONArray:<init>	()V
    //   23: astore 6
    //   25: aload_1
    //   26: getfield 464	com/tencent/mobileqq/apollo/sdk/IPCSpriteContext:jdField_a_of_type_Int	I
    //   29: ifne +132 -> 161
    //   32: aload_1
    //   33: getfield 187	com/tencent/mobileqq/apollo/sdk/IPCSpriteContext:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   36: aload_1
    //   37: iconst_1
    //   38: invokestatic 190	com/tencent/mobileqq/apollo/sdk/CmShowSpriteRscBuilder:b	(Ljava/lang/String;Lcom/tencent/mobileqq/apollo/sdk/IPCSpriteContext;Z)Lorg/json/JSONObject;
    //   41: astore_0
    //   42: aload_1
    //   43: getfield 194	com/tencent/mobileqq/apollo/sdk/IPCSpriteContext:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   46: aload_1
    //   47: iconst_0
    //   48: invokestatic 190	com/tencent/mobileqq/apollo/sdk/CmShowSpriteRscBuilder:b	(Ljava/lang/String;Lcom/tencent/mobileqq/apollo/sdk/IPCSpriteContext;Z)Lorg/json/JSONObject;
    //   51: astore 7
    //   53: aload_1
    //   54: getfield 187	com/tencent/mobileqq/apollo/sdk/IPCSpriteContext:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   57: aload_1
    //   58: iconst_1
    //   59: invokestatic 779	com/tencent/mobileqq/apollo/sdk/CmShowSpriteRscBuilder:a	(Ljava/lang/String;Lcom/tencent/mobileqq/apollo/sdk/IPCSpriteContext;Z)Lorg/json/JSONObject;
    //   62: astore 8
    //   64: aload_1
    //   65: getfield 194	com/tencent/mobileqq/apollo/sdk/IPCSpriteContext:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   68: aload_1
    //   69: iconst_0
    //   70: invokestatic 779	com/tencent/mobileqq/apollo/sdk/CmShowSpriteRscBuilder:a	(Ljava/lang/String;Lcom/tencent/mobileqq/apollo/sdk/IPCSpriteContext;Z)Lorg/json/JSONObject;
    //   73: astore_1
    //   74: aload 8
    //   76: ifnull +13 -> 89
    //   79: aload_0
    //   80: ldc_w 781
    //   83: aload 8
    //   85: invokevirtual 96	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   88: pop
    //   89: aload_1
    //   90: ifnull +13 -> 103
    //   93: aload 7
    //   95: ldc_w 781
    //   98: aload_1
    //   99: invokevirtual 96	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   102: pop
    //   103: aload 6
    //   105: aload_0
    //   106: invokevirtual 193	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   109: pop
    //   110: aload 6
    //   112: aload 7
    //   114: invokevirtual 193	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   117: pop
    //   118: invokestatic 395	java/lang/System:currentTimeMillis	()J
    //   121: lstore 4
    //   123: aload 6
    //   125: astore_0
    //   126: invokestatic 227	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   129: ifeq -119 -> 10
    //   132: ldc 173
    //   134: iconst_2
    //   135: iconst_2
    //   136: anewarray 4	java/lang/Object
    //   139: dup
    //   140: iconst_0
    //   141: ldc_w 783
    //   144: aastore
    //   145: dup
    //   146: iconst_1
    //   147: lload 4
    //   149: lload_2
    //   150: lsub
    //   151: invokestatic 438	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   154: aastore
    //   155: invokestatic 306	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   158: aload 6
    //   160: areturn
    //   161: aload_0
    //   162: getfield 162	com/tencent/mobileqq/apollo/api/script/SpriteTaskParam:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   165: aload_1
    //   166: iconst_1
    //   167: invokestatic 190	com/tencent/mobileqq/apollo/sdk/CmShowSpriteRscBuilder:b	(Ljava/lang/String;Lcom/tencent/mobileqq/apollo/sdk/IPCSpriteContext;Z)Lorg/json/JSONObject;
    //   170: astore_0
    //   171: aload_1
    //   172: getfield 187	com/tencent/mobileqq/apollo/sdk/IPCSpriteContext:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   175: aload_1
    //   176: iconst_1
    //   177: invokestatic 779	com/tencent/mobileqq/apollo/sdk/CmShowSpriteRscBuilder:a	(Ljava/lang/String;Lcom/tencent/mobileqq/apollo/sdk/IPCSpriteContext;Z)Lorg/json/JSONObject;
    //   180: astore_1
    //   181: aload_1
    //   182: ifnull +12 -> 194
    //   185: aload_0
    //   186: ldc_w 781
    //   189: aload_1
    //   190: invokevirtual 96	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   193: pop
    //   194: aload 6
    //   196: aload_0
    //   197: invokevirtual 193	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   200: pop
    //   201: goto -83 -> 118
    //   204: astore_0
    //   205: ldc 173
    //   207: iconst_1
    //   208: ldc_w 785
    //   211: aload_0
    //   212: invokestatic 181	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   215: invokestatic 395	java/lang/System:currentTimeMillis	()J
    //   218: lstore 4
    //   220: invokestatic 227	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   223: ifeq +29 -> 252
    //   226: ldc 173
    //   228: iconst_2
    //   229: iconst_2
    //   230: anewarray 4	java/lang/Object
    //   233: dup
    //   234: iconst_0
    //   235: ldc_w 783
    //   238: aastore
    //   239: dup
    //   240: iconst_1
    //   241: lload 4
    //   243: lload_2
    //   244: lsub
    //   245: invokestatic 438	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   248: aastore
    //   249: invokestatic 306	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   252: aconst_null
    //   253: areturn
    //   254: astore_0
    //   255: invokestatic 395	java/lang/System:currentTimeMillis	()J
    //   258: lstore 4
    //   260: invokestatic 227	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   263: ifeq +29 -> 292
    //   266: ldc 173
    //   268: iconst_2
    //   269: iconst_2
    //   270: anewarray 4	java/lang/Object
    //   273: dup
    //   274: iconst_0
    //   275: ldc_w 783
    //   278: aastore
    //   279: dup
    //   280: iconst_1
    //   281: lload 4
    //   283: lload_2
    //   284: lsub
    //   285: invokestatic 438	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   288: aastore
    //   289: invokestatic 306	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   292: aload_0
    //   293: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	294	0	paramSpriteTaskParam	SpriteTaskParam
    //   0	294	1	paramIPCSpriteContext	IPCSpriteContext
    //   15	269	2	l1	long
    //   121	161	4	l2	long
    //   23	172	6	localJSONArray	JSONArray
    //   51	62	7	localJSONObject1	JSONObject
    //   62	22	8	localJSONObject2	JSONObject
    // Exception table:
    //   from	to	target	type
    //   16	74	204	java/lang/Throwable
    //   79	89	204	java/lang/Throwable
    //   93	103	204	java/lang/Throwable
    //   103	118	204	java/lang/Throwable
    //   161	181	204	java/lang/Throwable
    //   185	194	204	java/lang/Throwable
    //   194	201	204	java/lang/Throwable
    //   16	74	254	finally
    //   79	89	254	finally
    //   93	103	254	finally
    //   103	118	254	finally
    //   161	181	254	finally
    //   185	194	254	finally
    //   194	201	254	finally
    //   205	215	254	finally
  }
  
  private static JSONObject b(String paramString, IPCSpriteContext paramIPCSpriteContext, boolean paramBoolean)
  {
    JSONObject localJSONObject;
    try
    {
      Object localObject1 = ((IApolloUtil)QRoute.api(IApolloUtil.class)).getQQApp();
      localJSONObject = new JSONObject();
      localJSONObject.put("uin", paramString);
      ApolloActionHelperImpl.attach3DInfoToJson(paramString, (QQAppInterface)localObject1, localJSONObject, null);
      Object localObject2 = ApolloActionHelperImpl.getRoleDressIdByUin(paramString, (QQAppInterface)localObject1, true);
      if ((localObject2 == null) || (localObject2.length != 2))
      {
        SpriteUtil.a(301, new Object[] { "roleInfos is null" });
        return null;
      }
      int j = ((Integer)localObject2[0]).intValue();
      localObject2 = (int[])localObject2[1];
      if ((localObject2 == null) || (localObject2.length == 0))
      {
        SpriteUtil.a(301, new Object[] { "dressInfo is null" });
        return null;
      }
      JSONArray localJSONArray = new JSONArray();
      int k = localObject2.length;
      int i = 0;
      while (i < k)
      {
        localJSONArray.put(ApolloActionHelperImpl.getApolloRsc(1, Integer.valueOf(localObject2[i]).intValue()));
        i += 1;
      }
      localJSONObject.put("dress", localJSONArray);
      localJSONObject.put("role", ApolloActionHelperImpl.getApolloRsc(0, j));
      if (((paramIPCSpriteContext.jdField_a_of_type_Int == 1) || (paramIPCSpriteContext.jdField_a_of_type_Int == 3000)) && (!"-1".equals(paramString)) && (!"-2".equals(paramString)))
      {
        localJSONObject.put("nameplate", a((QQAppInterface)localObject1, paramString, j, paramBoolean));
        localObject2 = paramIPCSpriteContext.jdField_b_of_type_JavaLangString;
        if ((TextUtils.isEmpty((CharSequence)localObject2)) || (!((String)localObject2).equals(paramString))) {
          break label431;
        }
      }
      label431:
      for (localObject1 = HardCodeUtil.a(2131714199);; localObject1 = SpriteUtil.a((QQAppInterface)localObject1, paramIPCSpriteContext.jdField_a_of_type_Int, paramString, paramIPCSpriteContext.jdField_a_of_type_JavaLangString, true))
      {
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          localJSONObject.put("nickname", SpriteUtil.a(Base64Util.encodeToString(((String)localObject1).getBytes("utf-8"), 0)));
        }
        localJSONObject.put("scale", paramIPCSpriteContext.jdField_a_of_type_Float);
        if (paramIPCSpriteContext.jdField_b_of_type_Float != -2.147484E+009F) {
          localJSONObject.put("xPos", paramIPCSpriteContext.jdField_b_of_type_Float);
        }
        if (paramIPCSpriteContext.c != -2.147484E+009F) {
          localJSONObject.put("yPos", paramIPCSpriteContext.c);
        }
        if ((TextUtils.isEmpty(paramIPCSpriteContext.jdField_b_of_type_JavaLangString)) || (!paramIPCSpriteContext.jdField_b_of_type_JavaLangString.equals(paramString))) {
          break;
        }
        localJSONObject.put("rotate", paramIPCSpriteContext.jdField_d_of_type_Int);
        break label481;
      }
      localJSONObject.put("rotate", paramIPCSpriteContext.e);
    }
    catch (Throwable paramString)
    {
      QLog.e("CmShow_SpriteRscBuilder", 1, paramString, new Object[0]);
      return null;
    }
    label481:
    return localJSONObject;
  }
  
  public static boolean b(SpriteTaskParam paramSpriteTaskParam)
  {
    if (paramSpriteTaskParam == null) {
      return false;
    }
    Object localObject = ((IApolloUtil)QRoute.api(IApolloUtil.class)).getQQApp();
    if (localObject == null)
    {
      QLog.e("CmShow_SpriteRscBuilder", 1, "CmShow downloadIfAIOActionNotExist taskParam:" + paramSpriteTaskParam);
      return false;
    }
    long l1 = System.currentTimeMillis();
    ApolloManagerServiceImpl localApolloManagerServiceImpl = (ApolloManagerServiceImpl)((QQAppInterface)localObject).getRuntimeService(IApolloManagerService.class, "all");
    ApolloActionData localApolloActionData = ((ApolloDaoManagerServiceImpl)((QQAppInterface)localObject).getRuntimeService(IApolloDaoManagerService.class, "all")).findActionById(paramSpriteTaskParam.f);
    if (localApolloActionData == null)
    {
      QLog.i("CmShow_SpriteRscBuilder", 1, "warning: data is null. call checkApolloPanelJsonVer, id:" + paramSpriteTaskParam.f);
      ApolloContentUpdateHandler.a((QQAppInterface)localObject, 1);
      return false;
    }
    boolean bool1;
    if (paramSpriteTaskParam.jdField_c_of_type_Int == 1) {
      if (paramSpriteTaskParam.h != 0)
      {
        bool1 = true;
        int j = paramSpriteTaskParam.f;
        int k = paramSpriteTaskParam.jdField_d_of_type_Int;
        if (!bool1) {
          break label360;
        }
        i = 0;
        label172:
        bool1 = ApolloUtilImpl.isWhiteFaceActionRscDone(j, k, i, bool1);
        label182:
        localObject = ((ISpriteScriptManager)((QQAppInterface)localObject).getRuntimeService(ISpriteScriptManager.class, "all")).getUIHandler();
        if (!bool1)
        {
          if (localObject != null) {
            ((ISpriteUIHandler)localObject).a(0, 0, paramSpriteTaskParam.jdField_a_of_type_Long);
          }
          bool1 = localApolloManagerServiceImpl.downloadApolloRes(localApolloActionData, 4, null);
          if (localObject != null) {
            if (!bool1) {
              break label741;
            }
          }
        }
      }
    }
    label397:
    label691:
    label697:
    label741:
    for (int i = 0;; i = 6)
    {
      label360:
      boolean bool3;
      for (;;)
      {
        ((ISpriteUIHandler)localObject).a(i, 1, paramSpriteTaskParam.jdField_a_of_type_Long);
        long l2 = System.currentTimeMillis();
        if (QLog.isColorLevel()) {
          QLog.d("CmShow_SpriteRscBuilder", 2, new Object[] { "[downloadIfActionNotExist end, actionId:", Integer.valueOf(paramSpriteTaskParam.f), ",costT:", Long.valueOf(l2 - l1), ",threadId:", Long.valueOf(Thread.currentThread().getId()), ",actionType:", Integer.valueOf(paramSpriteTaskParam.jdField_c_of_type_Int) });
        }
        return true;
        bool1 = false;
        break;
        i = localApolloActionData.personNum;
        break label172;
        if ((ApolloUtilImpl.isActionResDone(paramSpriteTaskParam.f, localApolloActionData.personNum)) || (ApolloUtilImpl.isQzoneActionRscDone(paramSpriteTaskParam.f)))
        {
          bool1 = true;
          bool3 = bool1;
          if (8 == paramSpriteTaskParam.jdField_c_of_type_Int)
          {
            bool3 = bool1;
            if (paramSpriteTaskParam.jdField_d_of_type_JavaLangString != null)
            {
              bool3 = bool1;
              if (bool1) {
                bool3 = bool1;
              }
            }
          }
        }
        else
        {
          try
          {
            JSONObject localJSONObject = new JSONObject(paramSpriteTaskParam.jdField_d_of_type_JavaLangString).optJSONObject("action");
            bool3 = bool1;
            String str = localJSONObject.optString("actionId");
            boolean bool2 = bool1;
            bool3 = bool1;
            if (!TextUtils.isEmpty(str))
            {
              bool3 = bool1;
              i = Integer.parseInt(str);
              bool3 = bool1;
              if (localJSONObject.optInt("actionPlatform") <= 0) {
                break label691;
              }
              bool4 = true;
              label510:
              bool2 = bool1;
              bool3 = bool1;
              if (!ApolloUtilImpl.isRandomSubActionDone(paramSpriteTaskParam.f, false, i, bool4)) {
                bool2 = false;
              }
            }
            bool1 = bool2;
            bool3 = bool2;
            if (1 == localApolloActionData.personNum)
            {
              bool1 = bool2;
              if (bool2)
              {
                bool3 = bool2;
                str = localJSONObject.optString("actionPeerId");
                bool1 = bool2;
                bool3 = bool2;
                if (!TextUtils.isEmpty(str))
                {
                  bool3 = bool2;
                  i = Integer.parseInt(str);
                  bool3 = bool2;
                  if (localJSONObject.optInt("actionPeerPlatform") <= 0) {
                    break label697;
                  }
                }
              }
            }
            for (boolean bool4 = true;; bool4 = false)
            {
              bool1 = bool2;
              bool3 = bool2;
              if (!ApolloUtilImpl.isRandomSubActionDone(paramSpriteTaskParam.f, true, i, bool4)) {
                bool1 = false;
              }
              if (!bool1)
              {
                bool3 = bool1;
                QLog.e("CmShow_SpriteRscBuilder", 1, "[random] action nis not exist," + paramSpriteTaskParam.jdField_d_of_type_JavaLangString);
              }
              break;
              bool1 = false;
              break label397;
              bool4 = false;
              break label510;
            }
            bool1 = bool3;
          }
          catch (Exception localException)
          {
            QLog.e("CmShow_SpriteRscBuilder", 1, "[random] the json is not right," + paramSpriteTaskParam.jdField_d_of_type_JavaLangString);
          }
        }
      }
      break label182;
    }
  }
  
  public Pair<String, Integer> a(String paramString)
  {
    int i = 2;
    Object localObject1 = new Pair("def/basic/action/4/action/action", Integer.valueOf(0));
    if (TextUtils.isEmpty(paramString)) {
      return localObject1;
    }
    Object localObject2 = ((IApolloUtil)QRoute.api(IApolloUtil.class)).getQQApp();
    if (localObject2 == null) {
      return localObject1;
    }
    StringBuilder localStringBuilder;
    if ((((IApolloManagerService)((QQAppInterface)localObject2).getRuntimeService(IApolloManagerService.class, "all")).getCmShowStatus((QQAppInterface)localObject2, paramString) != 2) && (a((QQAppInterface)localObject2, paramString)))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.jdField_b_of_type_Int).append("/action/action");
      SharedPreferences localSharedPreferences = ((QQAppInterface)localObject2).getApp().getSharedPreferences("apollo_sp", 0);
      if (!localSharedPreferences.getBoolean("stand_type_" + this.jdField_a_of_type_Int, false)) {}
      switch (this.jdField_a_of_type_Int)
      {
      case 4: 
      default: 
        localObject1 = null;
        localObject2 = SpriteUtil.a((QQAppInterface)localObject2);
        if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (localObject2 != null)) {
          ((SpriteActionScript)localObject2).a(paramString, (String)localObject1);
        }
        localSharedPreferences.edit().putBoolean("stand_type_" + this.jdField_a_of_type_Int, true).commit();
        if (this.jdField_a_of_type_ComTencentMobileqqApolloSdkCmShowSpriteContext.jdField_a_of_type_Int == 3000)
        {
          label275:
          VipUtils.a(null, "cmshow", "Apollo", "appearanceaction", i, this.jdField_a_of_type_Int, new String[] { String.valueOf(this.jdField_b_of_type_Int) });
          if (this.jdField_a_of_type_Int != 4) {
            break label388;
          }
        }
        break;
      }
    }
    label388:
    for (i = 7;; i = 0)
    {
      return new Pair(localStringBuilder.toString(), Integer.valueOf(i));
      localObject1 = HardCodeUtil.a(2131714200);
      break;
      localObject1 = HardCodeUtil.a(2131714207);
      break;
      localObject1 = HardCodeUtil.a(2131714201);
      break;
      localObject1 = HardCodeUtil.a(2131714203);
      break;
      i = this.jdField_a_of_type_ComTencentMobileqqApolloSdkCmShowSpriteContext.jdField_a_of_type_Int;
      break label275;
      return localObject1;
    }
  }
  
  public JSONArray a(JSONArray paramJSONArray)
  {
    int i = 0;
    JSONArray localJSONArray = new JSONArray();
    QQAppInterface localQQAppInterface = ((IApolloUtil)QRoute.api(IApolloUtil.class)).getQQApp();
    if ((this.jdField_a_of_type_ComTencentMobileqqApolloSdkCmShowSpriteContext == null) || (localQQAppInterface == null) || (paramJSONArray == null)) {
      return localJSONArray;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    int j = paramJSONArray.length();
    for (;;)
    {
      int k;
      if (i < j) {
        try
        {
          k = ((Integer)paramJSONArray.get(i)).intValue();
          if (k == 0) {
            break label220;
          }
          if (ApolloUtilImpl.isActionResDone(k, 0)) {
            break label189;
          }
          QLog.e("ApolloPet", 1, "getPetActions download:" + k);
          Object localObject = new ApolloActionData();
          ((ApolloActionData)localObject).actionId = k;
          String str = ApolloUtilImpl.getApolloResPath((ApolloActionData)localObject, 5);
          localObject = ApolloUtilImpl.getApolloResPath((ApolloActionData)localObject, 4);
          ((IApolloResDownloader)QRoute.api(IApolloResDownloader.class)).downLoadSpecialAction(localQQAppInterface, (String)localObject, str);
        }
        catch (Exception paramJSONArray)
        {
          QLog.e("ApolloPet", 1, "getPetActions error:", paramJSONArray);
        }
      } else {
        return localJSONArray;
      }
      label189:
      localStringBuilder.setLength(0);
      localStringBuilder.append(k).append("/action/action");
      localJSONArray.put(localStringBuilder.toString());
      label220:
      i += 1;
    }
  }
  
  public void a()
  {
    if (this.jdField_b_of_type_JavaUtilMap != null) {
      this.jdField_b_of_type_JavaUtilMap.clear();
    }
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
        break label717;
      }
    }
    label717:
    for (int j = ((Integer)jdField_a_of_type_JavaUtilMap.get(paramString)).intValue();; j = 0)
    {
      Object localObject = ((IApolloManagerService)paramQQAppInterface.getRuntimeService(IApolloManagerService.class, "all")).getStandUpSp();
      ApolloExtensionHandlerImpl localApolloExtensionHandlerImpl = (ApolloExtensionHandlerImpl)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.APOLLO_EXTENSION_HANDLER);
      JSONArray localJSONArray;
      try
      {
        if (this.d.get(paramString) == null) {}
        for (long l = 0L; (!((SharedPreferences)localObject).contains(paramString)) && (NetConnInfoCenter.getServerTime() - l > 180L); l = ((Long)this.d.get(paramString)).longValue())
        {
          paramQQAppInterface = new JSONObject();
          paramQQAppInterface.put("lastRequestTime", NetConnInfoCenter.getServerTimeMillis());
          ((SharedPreferences)localObject).edit().putString(paramString, paramQQAppInterface.toString()).commit();
          localApolloExtensionHandlerImpl.a(new long[] { Long.parseLong(paramString) });
          this.d.put(paramString, Long.valueOf(NetConnInfoCenter.getServerTime()));
          return false;
        }
        JSONObject localJSONObject = new JSONObject(((SharedPreferences)localObject).getString(paramString, "{}"));
        localJSONArray = localJSONObject.optJSONArray("action");
        l = localJSONObject.optLong("lastRequestTime");
        if ((j >= 5) || (NetConnInfoCenter.getServerTime() - l > 10800000L))
        {
          if (QLog.isColorLevel()) {
            QLog.d("CmShow_SpriteRscBuilder", 2, new Object[] { "hasSpecialStandAction getApolloStandAction openCount:", Integer.valueOf(j), ",lastRequestSpTime:", Long.valueOf(l) });
          }
          jdField_a_of_type_JavaUtilMap.put(paramString, Integer.valueOf(0));
          localApolloExtensionHandlerImpl.a(new long[] { Long.parseLong(paramString) });
          localJSONObject.put("lastRequestTime", NetConnInfoCenter.getServerTimeMillis());
          ((SharedPreferences)localObject).edit().putString(paramString, localJSONObject.toString()).commit();
        }
        for (;;)
        {
          if (localJSONArray == null) {
            break label723;
          }
          if (localJSONArray.length() > 0) {
            break;
          }
          break label723;
          jdField_a_of_type_JavaUtilMap.put(paramString, Integer.valueOf(j + 1));
        }
        j = i;
      }
      catch (Exception paramQQAppInterface)
      {
        QLog.e("CmShow_SpriteRscBuilder", 2, "hasSpecialStandAction error:", paramQQAppInterface);
        return false;
      }
      if (i >= localJSONArray.length()) {
        j = 0;
      }
      localObject = localJSONArray.getJSONObject(j);
      this.jdField_a_of_type_Int = ((JSONObject)localObject).getInt("type");
      this.jdField_b_of_type_Int = ((JSONObject)localObject).getInt("id");
      if ((this.jdField_a_of_type_Int == 4) && (!((ApolloManagerServiceImpl)paramQQAppInterface.getRuntimeService(IApolloManagerService.class, "all")).getApolloBaseInfo(paramString).hasPet))
      {
        a(paramString);
        return false;
      }
      if (QLog.isColorLevel()) {
        QLog.d("CmShow_SpriteRscBuilder", 2, new Object[] { "[hasSpecialStandAction] uin:", paramString, ",index:", Integer.valueOf(j), ",id:", Integer.valueOf(this.jdField_b_of_type_Int), ",standType:", Integer.valueOf(this.jdField_a_of_type_Int) });
      }
      if (!ApolloUtilImpl.isActionResDone(this.jdField_b_of_type_Int, 0))
      {
        if (QLog.isColorLevel()) {
          QLog.i("CmShow_SpriteRscBuilder", 2, "hasSpecialStandAction isActionResDone is false.");
        }
        localObject = new ApolloActionData();
        ((ApolloActionData)localObject).actionId = this.jdField_b_of_type_Int;
        paramString = ApolloUtilImpl.getApolloResPath((ApolloActionData)localObject, 5);
        localObject = ApolloUtilImpl.getApolloResPath((ApolloActionData)localObject, 4);
        ((IApolloResDownloader)QRoute.api(IApolloResDownloader.class)).downLoadSpecialAction(paramQQAppInterface, (String)localObject, paramString);
        return false;
      }
      this.jdField_b_of_type_JavaUtilMap.put(paramString, Integer.valueOf(j + 1));
      return true;
      i = 0;
      break;
    }
    label723:
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.sdk.CmShowSpriteRscBuilder
 * JD-Core Version:    0.7.0.1
 */