package com.tencent.mobileqq.apollo.script;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.mobileqq.apollo.aio.api.impl.CmShowAioMatcherImpl;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.api.ISpriteScriptManager;
import com.tencent.mobileqq.apollo.api.impl.ApolloManagerServiceImpl;
import com.tencent.mobileqq.apollo.game.utils.ApolloGameBasicEventUtil;
import com.tencent.mobileqq.apollo.game.utils.ApolloGameBasicEventUtil.NotifyDressReady;
import com.tencent.mobileqq.apollo.handler.ApolloContentUpdateHandler;
import com.tencent.mobileqq.apollo.handler.ApolloExtensionHandler;
import com.tencent.mobileqq.apollo.model.ApolloActionData;
import com.tencent.mobileqq.apollo.model.ApolloBaseInfo;
import com.tencent.mobileqq.apollo.persistence.api.IApolloDaoManagerService;
import com.tencent.mobileqq.apollo.persistence.api.impl.ApolloDaoManagerServiceImpl;
import com.tencent.mobileqq.apollo.res.api.IApolloResDownloader;
import com.tencent.mobileqq.apollo.res.api.IApolloResDownloader.OnFaceDataDownloadListener;
import com.tencent.mobileqq.apollo.res.api.IApolloResManager;
import com.tencent.mobileqq.apollo.res.api.impl.ApolloResManagerImpl;
import com.tencent.mobileqq.apollo.utils.api.IApolloUtil;
import com.tencent.mobileqq.apollo.utils.api.impl.ApolloActionHelperImpl;
import com.tencent.mobileqq.apollo.utils.api.impl.ApolloUtilImpl;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.cmshow.engine.util.CMGetResPathUtil;
import com.tencent.mobileqq.cmshow.engine.util.CMResUtil;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.List<Ljava.lang.String;>;
import java.util.Map;
import mqq.app.AppRuntime;
import org.json.JSONArray;
import org.json.JSONObject;

@Deprecated
public class SpriteRscBuilder
{
  private static Map<String, Integer> jdField_b_of_type_JavaUtilMap = new HashMap();
  private int jdField_a_of_type_Int = -1;
  private SpriteContext jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext;
  Map<String, Integer> jdField_a_of_type_JavaUtilMap = new HashMap();
  private int jdField_b_of_type_Int = -1;
  private Map<String, Long> c = new HashMap();
  
  public SpriteRscBuilder(SpriteContext paramSpriteContext)
  {
    this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext = paramSpriteContext;
  }
  
  private SpriteRscBuilder.ApolloAppearAction a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (paramQQAppInterface == null) {
        return null;
      }
      int i;
      if (this.jdField_a_of_type_JavaUtilMap.containsKey(paramString)) {
        i = ((Integer)this.jdField_a_of_type_JavaUtilMap.get(paramString)).intValue();
      } else {
        i = 0;
      }
      Object localObject2 = (ApolloManagerServiceImpl)this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a().getRuntimeService(IApolloManagerService.class, "all");
      Object localObject1 = (ApolloDaoManagerServiceImpl)paramQQAppInterface.getRuntimeService(IApolloDaoManagerService.class, "all");
      localObject2 = ((ApolloManagerServiceImpl)localObject2).getApolloAppearAction(paramQQAppInterface, paramString);
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        return null;
      }
      try
      {
        Object localObject3 = new JSONArray((String)localObject2);
        if (((JSONArray)localObject3).length() <= 0) {
          return null;
        }
        int j = i;
        if (i >= ((JSONArray)localObject3).length()) {
          j = 0;
        }
        localObject2 = new SpriteRscBuilder.ApolloAppearAction();
        localObject3 = ((JSONArray)localObject3).getJSONObject(j);
        ((SpriteRscBuilder.ApolloAppearAction)localObject2).jdField_b_of_type_Int = ((JSONObject)localObject3).getInt("type");
        ((SpriteRscBuilder.ApolloAppearAction)localObject2).jdField_a_of_type_Int = ((JSONObject)localObject3).getInt("id");
        localObject3 = ((ApolloDaoManagerServiceImpl)localObject1).getApolloBaseInfo(paramString);
        if (localObject3 == null) {
          return null;
        }
        if ((((SpriteRscBuilder.ApolloAppearAction)localObject2).jdField_b_of_type_Int == 4) && (!((ApolloBaseInfo)localObject3).hasPet))
        {
          ((ApolloBaseInfo)localObject3).appearAction = null;
          ((ApolloDaoManagerServiceImpl)localObject1).saveOrUpdateApolloBaseInfo((ApolloBaseInfo)localObject3);
          return null;
        }
        if (QLog.isColorLevel()) {
          QLog.d("[cmshow][scripted]SpriteRscBuilder", 2, new Object[] { "[hasAppearAction] index:", Integer.valueOf(j), ",id:", Integer.valueOf(((SpriteRscBuilder.ApolloAppearAction)localObject2).jdField_a_of_type_Int), ",standType:", Integer.valueOf(((SpriteRscBuilder.ApolloAppearAction)localObject2).jdField_b_of_type_Int) });
        }
        if (((SpriteRscBuilder.ApolloAppearAction)localObject2).jdField_a_of_type_Int <= 0)
        {
          QLog.e("[cmshow][scripted]SpriteRscBuilder", 1, new Object[] { "appearAction not correct,actionId:", Integer.valueOf(((SpriteRscBuilder.ApolloAppearAction)localObject2).jdField_a_of_type_Int) });
          return null;
        }
        if (!CMResUtil.a(((SpriteRscBuilder.ApolloAppearAction)localObject2).jdField_a_of_type_Int, 0))
        {
          if (QLog.isColorLevel()) {
            QLog.i("[cmshow][scripted]SpriteRscBuilder", 2, "hasAppearAction isActionResDone is false.");
          }
          paramString = new ApolloActionData();
          paramString.actionId = ((SpriteRscBuilder.ApolloAppearAction)localObject2).jdField_a_of_type_Int;
          localObject1 = CMGetResPathUtil.a(paramString, 5);
          paramString = CMGetResPathUtil.a(paramString, 4);
          ((IApolloResDownloader)QRoute.api(IApolloResDownloader.class)).downLoadSpecialAction(paramQQAppInterface, paramString, (String)localObject1);
          return null;
        }
        this.jdField_a_of_type_JavaUtilMap.put(paramString, Integer.valueOf(j + 1));
        return localObject2;
      }
      catch (Exception paramQQAppInterface)
      {
        QLog.e("[cmshow][scripted]SpriteRscBuilder", 2, "hasAppearAction error:", paramQQAppInterface);
      }
    }
    return null;
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
      return localSpriteTaskParam;
    }
    localSpriteTaskParam.jdField_a_of_type_Int = 1;
    localSpriteTaskParam.f = paramApolloAppearAction.jdField_a_of_type_Int;
    localSpriteTaskParam.k = 12;
    localSpriteTaskParam.g = 5;
    localSpriteTaskParam.jdField_a_of_type_Long = 1000000L;
    if (paramApolloAppearAction.jdField_b_of_type_Int == 4) {
      localSpriteTaskParam.c = 7;
    }
    return localSpriteTaskParam;
  }
  
  public static String a(int paramInt)
  {
    if (ApolloUtilImpl.getQQApp() == null) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    paramInt = ((ApolloManagerServiceImpl)ApolloUtilImpl.getQQApp().getRuntimeService(IApolloManagerService.class, "all")).getPetRandomAction(paramInt);
    if ((paramInt != -1) && (!CMResUtil.a(paramInt, 0)))
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("download random pet action:");
        ((StringBuilder)localObject1).append(paramInt);
        QLog.i("[cmshow]ApolloPet", 2, ((StringBuilder)localObject1).toString());
      }
      Object localObject2 = new ApolloActionData();
      ((ApolloActionData)localObject2).actionId = paramInt;
      Object localObject1 = CMGetResPathUtil.a((ApolloActionData)localObject2, 5);
      localObject2 = CMGetResPathUtil.a((ApolloActionData)localObject2, 4);
      ((IApolloResDownloader)QRoute.api(IApolloResDownloader.class)).downLoadSpecialAction(ApolloUtilImpl.getQQApp(), (String)localObject2, (String)localObject1);
    }
    else if (paramInt != -1)
    {
      localStringBuilder.append(paramInt);
      localStringBuilder.append("/action/action");
    }
    return localStringBuilder.toString();
  }
  
  public static String a(int paramInt, String paramString)
  {
    if (ApolloUtilImpl.getQQApp() != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        return null;
      }
      Object localObject = (ApolloManagerServiceImpl)ApolloUtilImpl.getQQApp().getRuntimeService(IApolloManagerService.class, "all");
      if (TextUtils.isEmpty(((ApolloManagerServiceImpl)localObject).mPetConfig)) {
        return null;
      }
      try
      {
        localObject = new JSONArray(((ApolloManagerServiceImpl)localObject).mPetConfig);
        int j = ((JSONArray)localObject).length();
        int i = 0;
        while (i < j)
        {
          JSONObject localJSONObject = ((JSONArray)localObject).getJSONObject(i);
          int k = localJSONObject.optInt("roleId", -1);
          if ((k != -1) && (k == paramInt))
          {
            paramInt = localJSONObject.getInt(paramString);
            if (CMResUtil.a(paramInt, 0))
            {
              paramString = new StringBuilder();
              paramString.append(paramInt);
              paramString.append("/action/action");
              return paramString.toString();
            }
            paramString = new StringBuilder();
            paramString.append("getPetBasicActions download action:");
            paramString.append(paramInt);
            QLog.e("[cmshow]ApolloPet", 1, paramString.toString());
            paramString = new ApolloActionData();
            paramString.actionId = paramInt;
            ((ApolloResManagerImpl)ApolloUtilImpl.getQQApp().getRuntimeService(IApolloResManager.class, "all")).downloadApolloRes(paramString, 4, null);
            return null;
          }
          i += 1;
        }
        return null;
      }
      catch (Exception paramString)
      {
        QLog.e("[cmshow]ApolloPet", 1, "getPetBasicActions error:", paramString);
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
      QLog.d("[cmshow][scripted]SpriteRscBuilder", 2, new Object[] { "getNicknamePath uin:", ((IApolloUtil)QRoute.api(IApolloUtil.class)).wrapLogUin(paramString), ", isMe:", Boolean.valueOf(bool2), ",isYellowVip:", Boolean.valueOf(bool1), ",isRight:", Boolean.valueOf(paramBoolean), ",bubbleId:", Integer.valueOf(i) });
    }
    return ApolloActionHelperImpl.getBubbleRscName(paramInt, i, localApolloManagerServiceImpl.getCmShowStatus(paramString));
  }
  
  public static String a(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    if ((!ApolloUtilImpl.isBubbleRscExist(paramInt1, paramInt2)) && (!ApolloUtilImpl.isBubbleRscExist(0, paramInt2))) {
      return "";
    }
    return ApolloActionHelperImpl.getBubbleRscName(paramInt1, paramInt2, paramInt3);
  }
  
  public static String a(String paramString, int paramInt, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder("def/role/0/Bubble/");
    if (paramString == null) {
      return null;
    }
    for (;;)
    {
      int i;
      try
      {
        paramString = new JSONArray(paramString);
        int j = paramString.length();
        i = 0;
        if (i < j)
        {
          JSONObject localJSONObject = paramString.getJSONObject(i);
          int k = localJSONObject.optInt("roleId", -1);
          if ((k == -1) || (k != paramInt)) {
            break label134;
          }
          if (!paramBoolean) {
            break label127;
          }
          paramString = "namePlateIdRight";
          localStringBuilder.append(localJSONObject.optInt(paramString, 0));
        }
        localStringBuilder.append("/dress");
      }
      catch (Exception paramString)
      {
        QLog.e("[cmshow]ApolloPet", 1, "getPetNamePlate error:", paramString);
      }
      return localStringBuilder.toString();
      label127:
      paramString = "namePlateIdLeft";
      continue;
      label134:
      i += 1;
    }
  }
  
  public static JSONArray a(QQAppInterface paramQQAppInterface, JSONObject paramJSONObject)
  {
    if ((paramJSONObject != null) && (paramQQAppInterface != null)) {
      if (QLog.isColorLevel()) {
        QLog.d("[cmshow][scripted]SpriteRscBuilder", 2, "[getActionJson]");
      }
    }
    label513:
    label519:
    for (;;)
    {
      boolean bool2;
      boolean bool1;
      try
      {
        JSONArray localJSONArray1 = new JSONArray();
        paramJSONObject = paramJSONObject.optString("actionList");
        JSONArray localJSONArray2 = new JSONArray(paramJSONObject);
        if (localJSONArray2.length() == 0) {
          return localJSONArray1;
        }
        if (QLog.isColorLevel()) {
          QLog.d("[cmshow][scripted]SpriteRscBuilder", 2, new Object[] { "ReqAction,", paramJSONObject });
        }
        ApolloDaoManagerServiceImpl localApolloDaoManagerServiceImpl = (ApolloDaoManagerServiceImpl)paramQQAppInterface.getRuntimeService(IApolloDaoManagerService.class, "all");
        int i = 0;
        int j = 0;
        if (i < localJSONArray2.length())
        {
          paramJSONObject = localJSONArray2.getJSONObject(i);
          if (paramJSONObject == null) {
            break label510;
          }
          int k = paramJSONObject.optInt("actionId");
          int m = paramJSONObject.optInt("perNum");
          if (QLog.isColorLevel()) {
            QLog.d("[cmshow][scripted]SpriteRscBuilder", 2, new Object[] { "ReqAction,actId:", Integer.valueOf(k), ",perNum:", Integer.valueOf(m) });
          }
          if (-1 == m)
          {
            localObject = localApolloDaoManagerServiceImpl.findActionById(k);
            paramJSONObject = (JSONObject)localObject;
            if (localObject == null)
            {
              paramJSONObject = new StringBuilder();
              paramJSONObject.append("ReqAction,[getActionsPath], warning: data is null. call checkApolloPanelJsonVer, id:");
              paramJSONObject.append(k);
              QLog.i("[cmshow][scripted]SpriteRscBuilder", 1, paramJSONObject.toString());
              if (j != 0) {
                break label510;
              }
              ApolloContentUpdateHandler.a(paramQQAppInterface, 1);
              j = 1;
              continue;
            }
          }
          else
          {
            paramJSONObject = new ApolloActionData();
            paramJSONObject.actionId = k;
            paramJSONObject.personNum = m;
          }
          bool2 = CMResUtil.a(k, paramJSONObject.personNum);
          if (bool2) {
            break label513;
          }
          bool1 = ((ApolloResManagerImpl)paramQQAppInterface.getRuntimeService(IApolloResManager.class, "all")).downloadApolloRes(paramJSONObject, 4, null);
          if (!QLog.isColorLevel()) {
            break label519;
          }
          QLog.d("[cmshow][scripted]SpriteRscBuilder", 2, new Object[] { "ReqAction,isActionDone:", Boolean.valueOf(bool2), ",ret:", Boolean.valueOf(bool1) });
          break label519;
          label368:
          Object localObject = new JSONObject();
          String[] arrayOfString = ApolloActionHelperImpl.getActionRscPath(1, k, 0, true);
          ((JSONObject)localObject).put("actionId", k);
          ((JSONObject)localObject).put("actionPath", ApolloActionHelperImpl.getResAddPrefixPath(arrayOfString[0], 3));
          if (paramJSONObject.personNum == 1) {
            ((JSONObject)localObject).put("peerPath", ApolloActionHelperImpl.getResAddPrefixPath(ApolloActionHelperImpl.getActionRscPath(1, k, 0, false)[0], 3));
          }
          localJSONArray1.put(localObject);
          if (!QLog.isColorLevel()) {
            break label510;
          }
          QLog.d("[cmshow][scripted]SpriteRscBuilder", 2, new Object[] { "ReqAction,put into array, id:", Integer.valueOf(k) });
          label484:
          i += 1;
          continue;
        }
        return localJSONArray1;
      }
      catch (Throwable paramQQAppInterface)
      {
        QLog.e("[cmshow][scripted]SpriteRscBuilder", 1, paramQQAppInterface, new Object[0]);
        return null;
      }
      return null;
      label510:
      do
      {
        break label484;
        bool1 = false;
        break;
        if (bool2) {
          break label368;
        }
      } while (!bool1);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt, int[] paramArrayOfInt, ApolloGameBasicEventUtil.NotifyDressReady paramNotifyDressReady)
  {
    if (paramArrayOfInt == null) {
      return;
    }
    int j = 1;
    StringBuilder localStringBuilder;
    int i;
    if (paramInt == 0)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("role id is 0, uin:");
      localStringBuilder.append(((IApolloUtil)QRoute.api(IApolloUtil.class)).wrapLogUin(paramString));
      QLog.i("[cmshow][scripted]SpriteRscBuilder", 1, localStringBuilder.toString());
      i = j;
    }
    else
    {
      i = 0;
      while (i < paramArrayOfInt.length)
      {
        if (!CMResUtil.a(paramArrayOfInt[i]))
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("dress rsc NOT exist, id:");
          localStringBuilder.append(paramArrayOfInt[i]);
          QLog.w("[cmshow][scripted]SpriteRscBuilder", 2, localStringBuilder.toString());
          i = j;
          break label147;
        }
        i += 1;
      }
      i = 0;
    }
    label147:
    if (i != 0)
    {
      ApolloGameBasicEventUtil.a(paramQQAppInterface, paramString, "", 0, "", paramNotifyDressReady);
      return;
    }
    if (paramNotifyDressReady != null) {
      paramNotifyDressReady.a(paramQQAppInterface, paramString, "", "", paramInt, paramArrayOfInt, 10);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, IApolloResDownloader.OnFaceDataDownloadListener paramOnFaceDataDownloadListener)
  {
    if ((CMResUtil.a(paramString) ^ true))
    {
      ((IApolloResDownloader)QRoute.api(IApolloResDownloader.class)).checkDownloadFaceData(paramQQAppInterface, paramString, paramOnFaceDataDownloadListener);
      return;
    }
    if (paramOnFaceDataDownloadListener != null) {
      paramOnFaceDataDownloadListener.a(true, 0);
    }
  }
  
  public static void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      Object localObject = null;
      AppRuntime localAppRuntime = ((IApolloUtil)QRoute.api(IApolloUtil.class)).getAppInterface();
      if (localAppRuntime != null) {
        localObject = ((IApolloManagerService)localAppRuntime.getRuntimeService(IApolloManagerService.class, "all")).getStandUpSp();
      }
      if (localObject != null)
      {
        localObject = ((SharedPreferences)localObject).edit();
        if (localObject != null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("[cmshow][scripted]SpriteRscBuilder", 2, "[clearAction] clear action success ");
          }
          ((SharedPreferences.Editor)localObject).remove(paramString).apply();
        }
      }
    }
  }
  
  private static boolean a(int paramInt)
  {
    QQAppInterface localQQAppInterface = ApolloUtilImpl.getQQApp();
    if (localQQAppInterface == null) {
      return false;
    }
    Object localObject = ((ApolloDaoManagerServiceImpl)localQQAppInterface.getRuntimeService(IApolloDaoManagerService.class, "all")).findActionById(paramInt);
    if (localObject == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("downloadIfActionPanelFrameNotExist warning: data is null. call checkApolloPanelJsonVer, id:");
      ((StringBuilder)localObject).append(paramInt);
      QLog.i("[cmshow][scripted]SpriteRscBuilder", 1, ((StringBuilder)localObject).toString());
      ApolloContentUpdateHandler.a(localQQAppInterface, 1);
      return false;
    }
    if (!CMResUtil.b(paramInt, ((ApolloActionData)localObject).personNum)) {
      return ((ApolloResManagerImpl)localQQAppInterface.getRuntimeService(IApolloResManager.class, "all")).downloadApolloRes((ApolloActionData)localObject, 4, null);
    }
    return true;
  }
  
  public static boolean a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, String paramString, long paramLong)
  {
    QQAppInterface localQQAppInterface = ApolloUtilImpl.getQQApp();
    if (localQQAppInterface == null) {
      return false;
    }
    if (paramInt1 == 1) {
      return a(paramInt2, paramInt3, paramInt4, paramInt5, paramString, paramLong);
    }
    Object localObject;
    if (paramInt1 == 6)
    {
      if (!CMResUtil.d(5, paramInt2))
      {
        paramString = (IApolloResDownloader)QRoute.api(IApolloResDownloader.class);
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(CMGetResPathUtil.d(paramInt2));
        ((StringBuilder)localObject).append("/d.zip");
        paramString.downLoadSpecialAction(localQQAppInterface, ((StringBuilder)localObject).toString(), CMResUtil.b(paramInt2));
        return false;
      }
    }
    else if (paramInt1 == 12)
    {
      if (!CMResUtil.a(paramInt2, 0))
      {
        localObject = new ApolloActionData();
        ((ApolloActionData)localObject).actionId = paramInt2;
        paramString = CMGetResPathUtil.a((ApolloActionData)localObject, 5);
        localObject = CMGetResPathUtil.a((ApolloActionData)localObject, 4);
        ((IApolloResDownloader)QRoute.api(IApolloResDownloader.class)).downLoadSpecialAction(localQQAppInterface, (String)localObject, paramString);
        return false;
      }
    }
    else if ((paramInt1 != 11) && (paramInt1 != 7))
    {
      if (paramInt1 == 15) {
        return a(paramInt2);
      }
    }
    else
    {
      paramString = ApolloActionHelperImpl.getActionRscPath(paramInt1, paramInt2, 0, true);
      if ((paramString.length > 0) && (!TextUtils.isEmpty(paramString[0])) && (!new File(CMGetResPathUtil.a(paramString[0], "json")).exists()))
      {
        ((IApolloResDownloader)QRoute.api(IApolloResDownloader.class)).downloadApolloResOrder(localQQAppInterface, localQQAppInterface.getCurrentAccountUin(), null, 0, null, -1, -1, true);
        return false;
      }
    }
    return true;
  }
  
  private static boolean a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString, long paramLong)
  {
    QQAppInterface localQQAppInterface = ApolloUtilImpl.getQQApp();
    if (localQQAppInterface == null) {
      return false;
    }
    long l = System.currentTimeMillis();
    ApolloActionData localApolloActionData = ((ApolloDaoManagerServiceImpl)localQQAppInterface.getRuntimeService(IApolloDaoManagerService.class, "all")).findActionById(paramInt1);
    if (localApolloActionData == null)
    {
      paramString = new StringBuilder();
      paramString.append("warning: data is null. call checkApolloPanelJsonVer, id:");
      paramString.append(paramInt1);
      QLog.i("[cmshow][scripted]SpriteRscBuilder", 1, paramString.toString());
      ApolloContentUpdateHandler.a(localQQAppInterface, 1);
      return false;
    }
    if (paramInt2 == 1)
    {
      bool1 = CmShowAioMatcherImpl.judgeSupported(paramInt3, 2);
      if (bool1) {
        paramInt3 = 0;
      } else {
        paramInt3 = localApolloActionData.personNum;
      }
      bool2 = CMResUtil.a(paramInt1, paramInt4, paramInt3, bool1);
    }
    else
    {
      bool3 = CMResUtil.a(paramInt1, localApolloActionData.personNum);
      bool2 = bool3;
      if (8 == paramInt2)
      {
        bool2 = bool3;
        if (paramString != null)
        {
          bool2 = bool3;
          if (bool3) {
            bool2 = bool3;
          }
        }
      }
    }
    try
    {
      localObject = new JSONObject(paramString).optJSONObject("action");
      bool2 = bool3;
      str = ((JSONObject)localObject).optString("actionId");
      bool1 = bool3;
      bool2 = bool3;
      if (TextUtils.isEmpty(str)) {
        break label268;
      }
      bool2 = bool3;
      paramInt3 = Integer.parseInt(str);
      bool2 = bool3;
      if (((JSONObject)localObject).optInt("actionPlatform") <= 0) {
        break label667;
      }
      bool4 = true;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject;
        String str;
        continue;
        boolean bool4 = false;
        continue;
        bool4 = false;
      }
    }
    boolean bool1 = bool3;
    boolean bool2 = bool3;
    if (!CMResUtil.a(paramInt1, false, paramInt3, bool4)) {
      bool1 = false;
    }
    label268:
    boolean bool3 = bool1;
    bool2 = bool1;
    if (1 == localApolloActionData.personNum)
    {
      bool3 = bool1;
      if (bool1)
      {
        bool2 = bool1;
        str = ((JSONObject)localObject).optString("actionPeerId");
        bool3 = bool1;
        bool2 = bool1;
        if (!TextUtils.isEmpty(str))
        {
          bool2 = bool1;
          paramInt3 = Integer.parseInt(str);
          bool2 = bool1;
          if (((JSONObject)localObject).optInt("actionPeerPlatform") <= 0) {
            break label673;
          }
          bool4 = true;
          bool3 = bool1;
          bool2 = bool1;
          if (!CMResUtil.a(paramInt1, true, paramInt3, bool4)) {
            bool3 = false;
          }
        }
      }
    }
    bool2 = bool3;
    if (!bool3)
    {
      bool2 = bool3;
      localObject = new StringBuilder();
      bool2 = bool3;
      ((StringBuilder)localObject).append("[random] action nis not exist,");
      bool2 = bool3;
      ((StringBuilder)localObject).append(paramString);
      bool2 = bool3;
      QLog.e("[cmshow][scripted]SpriteRscBuilder", 1, ((StringBuilder)localObject).toString());
      bool2 = bool3;
      break label483;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[random] the json is not right,");
      ((StringBuilder)localObject).append(paramString);
      QLog.e("[cmshow][scripted]SpriteRscBuilder", 1, ((StringBuilder)localObject).toString());
    }
    label483:
    paramString = ((ISpriteScriptManager)localQQAppInterface.getRuntimeService(ISpriteScriptManager.class, "all")).getUIHandler();
    if (!bool2)
    {
      if (paramString != null) {
        paramString.a(0, 0, paramLong);
      }
      bool1 = ((ApolloResManagerImpl)localQQAppInterface.getRuntimeService(IApolloResManager.class, "all")).downloadApolloRes(localApolloActionData, 4, null);
      if (paramString != null)
      {
        if (bool1) {
          paramInt3 = 0;
        } else {
          paramInt3 = 6;
        }
        paramString.a(paramInt3, 1, paramLong);
      }
    }
    paramLong = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow][scripted]SpriteRscBuilder", 2, new Object[] { "[downloadIfActionNotExist end, actionId:", Integer.valueOf(paramInt1), ", costT:", Long.valueOf(paramLong - l), ", threadId:", Long.valueOf(Thread.currentThread().getId()), ", actionType:", Integer.valueOf(paramInt2) });
    }
    return true;
  }
  
  public static void b(QQAppInterface paramQQAppInterface, String paramString, int paramInt, int[] paramArrayOfInt, ApolloGameBasicEventUtil.NotifyDressReady paramNotifyDressReady)
  {
    if (paramArrayOfInt == null) {
      return;
    }
    int k = 0;
    int i = 0;
    int j;
    for (;;)
    {
      j = k;
      if (i >= paramArrayOfInt.length) {
        break;
      }
      if (!CMResUtil.a(paramArrayOfInt[i]))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("checkThreeDressRsc rsc NOT exist, id:");
        localStringBuilder.append(paramArrayOfInt[i]);
        QLog.w("[cmshow][scripted]SpriteRscBuilder", 2, localStringBuilder.toString());
        j = 1;
        break;
      }
      i += 1;
    }
    if (j != 0)
    {
      c(paramQQAppInterface, paramString, paramInt, paramArrayOfInt, paramNotifyDressReady);
      return;
    }
    if (paramNotifyDressReady != null) {
      paramNotifyDressReady.a(paramQQAppInterface, paramString, "", "", paramInt, paramArrayOfInt, 10);
    }
  }
  
  public static void c(QQAppInterface paramQQAppInterface, String paramString, int paramInt, int[] paramArrayOfInt, ApolloGameBasicEventUtil.NotifyDressReady paramNotifyDressReady)
  {
    if ((ApolloActionHelperImpl.isRscValid(paramString, paramInt, paramArrayOfInt, paramQQAppInterface, new SpriteRscBuilder.4(paramNotifyDressReady, paramQQAppInterface, paramInt, paramArrayOfInt))) && (paramNotifyDressReady != null)) {
      paramNotifyDressReady.a(paramQQAppInterface, paramString, "", "", paramInt, paramArrayOfInt, 22);
    }
  }
  
  public Pair<String, Integer> a(String paramString)
  {
    int j = 0;
    Object localObject1 = new Pair("def/basic/action/4/action/action", Integer.valueOf(0));
    if (TextUtils.isEmpty(paramString)) {
      return localObject1;
    }
    if ((((IApolloManagerService)this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a().getRuntimeService(IApolloManagerService.class, "all")).getCmShowStatus(paramString) != 2) && (a(this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a(), paramString)))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.jdField_b_of_type_Int);
      localStringBuilder.append("/action/action");
      Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a().getApp().getSharedPreferences("apollo_sp", 0);
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("stand_type_");
      ((StringBuilder)localObject1).append(this.jdField_a_of_type_Int);
      if (!((SharedPreferences)localObject2).getBoolean(((StringBuilder)localObject1).toString(), false))
      {
        localObject1 = null;
        i = this.jdField_a_of_type_Int;
        if (i != 1)
        {
          if (i != 2)
          {
            if (i == 3) {
              localObject1 = HardCodeUtil.a(2131714130);
            }
          }
          else {
            localObject1 = HardCodeUtil.a(2131714136);
          }
        }
        else {
          localObject1 = HardCodeUtil.a(2131714132);
        }
        SpriteActionScript localSpriteActionScript = SpriteUtil.a(this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a());
        if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (localSpriteActionScript != null)) {
          localSpriteActionScript.b(paramString, (String)localObject1);
        }
        localObject1 = ((SharedPreferences)localObject2).edit();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("stand_type_");
        ((StringBuilder)localObject2).append(this.jdField_a_of_type_Int);
        ((SharedPreferences.Editor)localObject1).putBoolean(((StringBuilder)localObject2).toString(), true).commit();
        if (QLog.isColorLevel()) {
          QLog.d("[cmshow][scripted]SpriteRscBuilder", 2, new Object[] { "getSpriteShowPath stand:", Integer.valueOf(this.jdField_a_of_type_Int), ", uin:", ((IApolloUtil)QRoute.api(IApolloUtil.class)).wrapLogUin(paramString) });
        }
      }
      if (this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.jdField_a_of_type_Int == 3000) {
        i = 2;
      } else {
        i = this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.jdField_a_of_type_Int;
      }
      VipUtils.a(null, "cmshow", "Apollo", "appearanceaction", i, this.jdField_a_of_type_Int, new String[] { String.valueOf(this.jdField_b_of_type_Int) });
      int i = j;
      if (this.jdField_a_of_type_Int == 4) {
        i = 7;
      }
      return new Pair(localStringBuilder.toString(), Integer.valueOf(i));
    }
    return localObject1;
  }
  
  public String a(SpriteTaskParam paramSpriteTaskParam, String paramString)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public JSONArray a(JSONArray paramJSONArray)
  {
    JSONArray localJSONArray = new JSONArray();
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext;
    if ((localObject1 != null) && (((SpriteContext)localObject1).a() != null))
    {
      if (paramJSONArray == null) {
        return localJSONArray;
      }
      localObject1 = new StringBuilder();
      int j = paramJSONArray.length();
      int i = 0;
      for (;;)
      {
        if (i < j) {
          try
          {
            int k = ((Integer)paramJSONArray.get(i)).intValue();
            if (k != 0) {
              if (!CMResUtil.a(k, 0))
              {
                Object localObject2 = new StringBuilder();
                ((StringBuilder)localObject2).append("getPetActions download:");
                ((StringBuilder)localObject2).append(k);
                QLog.e("[cmshow]ApolloPet", 1, ((StringBuilder)localObject2).toString());
                Object localObject3 = new ApolloActionData();
                ((ApolloActionData)localObject3).actionId = k;
                localObject2 = CMGetResPathUtil.a((ApolloActionData)localObject3, 5);
                localObject3 = CMGetResPathUtil.a((ApolloActionData)localObject3, 4);
                ((IApolloResDownloader)QRoute.api(IApolloResDownloader.class)).downLoadSpecialAction(this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a(), (String)localObject3, (String)localObject2);
              }
              else
              {
                ((StringBuilder)localObject1).setLength(0);
                ((StringBuilder)localObject1).append(k);
                ((StringBuilder)localObject1).append("/action/action");
                localJSONArray.put(((StringBuilder)localObject1).toString());
              }
            }
            i += 1;
          }
          catch (Exception paramJSONArray)
          {
            QLog.e("[cmshow]ApolloPet", 1, "getPetActions error:", paramJSONArray);
          }
        }
      }
    }
    return localJSONArray;
  }
  
  /* Error */
  public JSONObject a(String paramString, SpriteContext paramSpriteContext, boolean paramBoolean)
  {
    // Byte code:
    //   0: new 104	org/json/JSONObject
    //   3: dup
    //   4: invokespecial 384	org/json/JSONObject:<init>	()V
    //   7: astore 12
    //   9: new 683	java/util/ArrayList
    //   12: dup
    //   13: invokespecial 684	java/util/ArrayList:<init>	()V
    //   16: astore 13
    //   18: iconst_0
    //   19: istore 5
    //   21: aload_2
    //   22: invokevirtual 65	com/tencent/mobileqq/apollo/script/SpriteContext:a	()Lcom/tencent/mobileqq/app/QQAppInterface;
    //   25: astore 11
    //   27: aload 11
    //   29: ldc 67
    //   31: ldc 69
    //   33: invokevirtual 75	com/tencent/mobileqq/app/QQAppInterface:getRuntimeService	(Ljava/lang/Class;Ljava/lang/String;)Lmqq/app/api/IRuntimeService;
    //   36: checkcast 77	com/tencent/mobileqq/apollo/api/impl/ApolloManagerServiceImpl
    //   39: astore 10
    //   41: aload 11
    //   43: ldc 79
    //   45: ldc 69
    //   47: invokevirtual 75	com/tencent/mobileqq/app/QQAppInterface:getRuntimeService	(Ljava/lang/Class;Ljava/lang/String;)Lmqq/app/api/IRuntimeService;
    //   50: checkcast 81	com/tencent/mobileqq/apollo/persistence/api/impl/ApolloDaoManagerServiceImpl
    //   53: aload_1
    //   54: invokevirtual 116	com/tencent/mobileqq/apollo/persistence/api/impl/ApolloDaoManagerServiceImpl:getApolloBaseInfo	(Ljava/lang/String;)Lcom/tencent/mobileqq/apollo/model/ApolloBaseInfo;
    //   57: astore 14
    //   59: aload 14
    //   61: ifnonnull +5 -> 66
    //   64: aconst_null
    //   65: areturn
    //   66: aload 14
    //   68: invokevirtual 688	com/tencent/mobileqq/apollo/model/ApolloBaseInfo:getApolloPetDress	()Lcom/tencent/mobileqq/apollo/model/ApolloDress;
    //   71: astore 15
    //   73: aload 15
    //   75: ifnull +811 -> 886
    //   78: aload 14
    //   80: getfield 122	com/tencent/mobileqq/apollo/model/ApolloBaseInfo:hasPet	Z
    //   83: ifeq +803 -> 886
    //   86: aload 15
    //   88: getfield 694	com/tencent/mobileqq/apollo/model/ApolloDress:dressMap	Ljava/util/HashMap;
    //   91: ifnull +795 -> 886
    //   94: aload 15
    //   96: getfield 694	com/tencent/mobileqq/apollo/model/ApolloDress:dressMap	Ljava/util/HashMap;
    //   99: invokevirtual 696	java/util/HashMap:isEmpty	()Z
    //   102: ifne +784 -> 886
    //   105: aload 12
    //   107: ldc_w 698
    //   110: iconst_0
    //   111: aload 15
    //   113: getfield 700	com/tencent/mobileqq/apollo/model/ApolloDress:roleId	I
    //   116: invokestatic 704	com/tencent/mobileqq/apollo/utils/api/impl/ApolloActionHelperImpl:getApolloRsc	(II)Ljava/lang/String;
    //   119: invokevirtual 400	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   122: pop
    //   123: iconst_1
    //   124: aload 15
    //   126: getfield 700	com/tencent/mobileqq/apollo/model/ApolloDress:roleId	I
    //   129: invokestatic 706	com/tencent/mobileqq/cmshow/engine/util/CMResUtil:c	(II)Z
    //   132: istore 9
    //   134: iload 9
    //   136: ifne +35 -> 171
    //   139: aload 15
    //   141: getfield 700	com/tencent/mobileqq/apollo/model/ApolloDress:roleId	I
    //   144: istore 4
    //   146: iconst_0
    //   147: istore 5
    //   149: goto +28 -> 177
    //   152: astore 11
    //   154: iconst_m1
    //   155: istore 4
    //   157: iconst_0
    //   158: istore 5
    //   160: goto +939 -> 1099
    //   163: astore 11
    //   165: iconst_m1
    //   166: istore 4
    //   168: goto +761 -> 929
    //   171: iconst_1
    //   172: istore 5
    //   174: iconst_m1
    //   175: istore 4
    //   177: aload 15
    //   179: getfield 694	com/tencent/mobileqq/apollo/model/ApolloDress:dressMap	Ljava/util/HashMap;
    //   182: invokevirtual 709	java/util/HashMap:size	()I
    //   185: newarray int
    //   187: astore 11
    //   189: aload 15
    //   191: getfield 694	com/tencent/mobileqq/apollo/model/ApolloDress:dressMap	Ljava/util/HashMap;
    //   194: invokevirtual 713	java/util/HashMap:entrySet	()Ljava/util/Set;
    //   197: invokeinterface 719 1 0
    //   202: astore 16
    //   204: iconst_0
    //   205: istore 6
    //   207: aload 16
    //   209: invokeinterface 724 1 0
    //   214: ifeq +38 -> 252
    //   217: aload 11
    //   219: iload 6
    //   221: aload 16
    //   223: invokeinterface 728 1 0
    //   228: checkcast 730	java/util/Map$Entry
    //   231: invokeinterface 733 1 0
    //   236: checkcast 56	java/lang/Integer
    //   239: invokevirtual 60	java/lang/Integer:intValue	()I
    //   242: iastore
    //   243: iload 6
    //   245: iconst_1
    //   246: iadd
    //   247: istore 6
    //   249: goto -42 -> 207
    //   252: new 87	org/json/JSONArray
    //   255: dup
    //   256: invokespecial 349	org/json/JSONArray:<init>	()V
    //   259: astore 16
    //   261: aload 11
    //   263: arraylength
    //   264: istore 6
    //   266: iconst_0
    //   267: istore 7
    //   269: iload 7
    //   271: iload 6
    //   273: if_icmpge +76 -> 349
    //   276: aload 11
    //   278: iload 7
    //   280: iaload
    //   281: istore 8
    //   283: aload 16
    //   285: iconst_1
    //   286: iload 8
    //   288: invokestatic 704	com/tencent/mobileqq/apollo/utils/api/impl/ApolloActionHelperImpl:getApolloRsc	(II)Ljava/lang/String;
    //   291: invokevirtual 405	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   294: pop
    //   295: iconst_2
    //   296: iload 8
    //   298: invokestatic 706	com/tencent/mobileqq/cmshow/engine/util/CMResUtil:c	(II)Z
    //   301: istore 9
    //   303: iload 9
    //   305: ifne +35 -> 340
    //   308: aload 13
    //   310: iload 8
    //   312: invokestatic 144	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   315: invokeinterface 738 2 0
    //   320: pop
    //   321: iconst_0
    //   322: istore 5
    //   324: goto +16 -> 340
    //   327: astore 11
    //   329: goto -172 -> 157
    //   332: astore 11
    //   334: iconst_0
    //   335: istore 5
    //   337: goto +592 -> 929
    //   340: iload 7
    //   342: iconst_1
    //   343: iadd
    //   344: istore 7
    //   346: goto -77 -> 269
    //   349: aload 12
    //   351: ldc_w 740
    //   354: aload 16
    //   356: invokevirtual 400	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   359: pop
    //   360: aload 12
    //   362: ldc_w 257
    //   365: aload 15
    //   367: getfield 700	com/tencent/mobileqq/apollo/model/ApolloDress:roleId	I
    //   370: invokevirtual 391	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   373: pop
    //   374: aload 15
    //   376: getfield 700	com/tencent/mobileqq/apollo/model/ApolloDress:roleId	I
    //   379: ldc_w 742
    //   382: invokestatic 744	com/tencent/mobileqq/apollo/script/SpriteRscBuilder:a	(ILjava/lang/String;)Ljava/lang/String;
    //   385: astore 11
    //   387: aload 15
    //   389: getfield 700	com/tencent/mobileqq/apollo/model/ApolloDress:roleId	I
    //   392: ldc_w 746
    //   395: invokestatic 744	com/tencent/mobileqq/apollo/script/SpriteRscBuilder:a	(ILjava/lang/String;)Ljava/lang/String;
    //   398: astore 16
    //   400: aload 11
    //   402: invokestatic 44	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   405: ifne +33 -> 438
    //   408: aload 16
    //   410: invokestatic 44	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   413: ifne +25 -> 438
    //   416: aload 12
    //   418: ldc_w 748
    //   421: aload 16
    //   423: invokevirtual 400	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   426: pop
    //   427: aload 12
    //   429: ldc_w 750
    //   432: aload 11
    //   434: invokevirtual 400	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   437: pop
    //   438: aload 15
    //   440: getfield 700	com/tencent/mobileqq/apollo/model/ApolloDress:roleId	I
    //   443: invokestatic 751	com/tencent/mobileqq/apollo/script/SpriteRscBuilder:a	(I)Ljava/lang/String;
    //   446: astore 11
    //   448: aload 11
    //   450: invokestatic 44	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   453: ifne +14 -> 467
    //   456: aload 12
    //   458: ldc_w 753
    //   461: aload 11
    //   463: invokevirtual 400	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   466: pop
    //   467: aload 14
    //   469: getfield 756	com/tencent/mobileqq/apollo/model/ApolloBaseInfo:petNick	Ljava/lang/String;
    //   472: invokestatic 44	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   475: ifne +37 -> 512
    //   478: aload_2
    //   479: getfield 758	com/tencent/mobileqq/apollo/script/SpriteContext:d	I
    //   482: ifne +30 -> 512
    //   485: aload 12
    //   487: ldc_w 760
    //   490: aload 14
    //   492: getfield 756	com/tencent/mobileqq/apollo/model/ApolloBaseInfo:petNick	Ljava/lang/String;
    //   495: ldc_w 762
    //   498: invokevirtual 766	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   501: iconst_0
    //   502: invokestatic 772	com/tencent/mobileqq/utils/Base64Util:encodeToString	([BI)Ljava/lang/String;
    //   505: invokestatic 774	com/tencent/mobileqq/apollo/script/SpriteUtil:a	(Ljava/lang/String;)Ljava/lang/String;
    //   508: invokevirtual 400	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   511: pop
    //   512: aload 14
    //   514: getfield 777	com/tencent/mobileqq/apollo/model/ApolloBaseInfo:mBgImgPath	Ljava/lang/String;
    //   517: invokestatic 44	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   520: ifne +24 -> 544
    //   523: aload_2
    //   524: getfield 758	com/tencent/mobileqq/apollo/script/SpriteContext:d	I
    //   527: ifne +17 -> 544
    //   530: aload 12
    //   532: ldc_w 779
    //   535: aload 14
    //   537: getfield 777	com/tencent/mobileqq/apollo/model/ApolloBaseInfo:mBgImgPath	Ljava/lang/String;
    //   540: invokevirtual 400	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   543: pop
    //   544: aload 14
    //   546: getfield 782	com/tencent/mobileqq/apollo/model/ApolloBaseInfo:mBallImgPath	Ljava/lang/String;
    //   549: invokestatic 44	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   552: ifne +24 -> 576
    //   555: aload_2
    //   556: getfield 758	com/tencent/mobileqq/apollo/script/SpriteContext:d	I
    //   559: ifne +17 -> 576
    //   562: aload 12
    //   564: ldc_w 784
    //   567: aload 14
    //   569: getfield 782	com/tencent/mobileqq/apollo/model/ApolloBaseInfo:mBallImgPath	Ljava/lang/String;
    //   572: invokevirtual 400	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   575: pop
    //   576: aload 14
    //   578: getfield 787	com/tencent/mobileqq/apollo/model/ApolloBaseInfo:mLevel	Ljava/lang/String;
    //   581: invokestatic 44	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   584: ifne +24 -> 608
    //   587: aload_2
    //   588: getfield 758	com/tencent/mobileqq/apollo/script/SpriteContext:d	I
    //   591: ifne +17 -> 608
    //   594: aload 12
    //   596: ldc_w 789
    //   599: aload 14
    //   601: getfield 787	com/tencent/mobileqq/apollo/model/ApolloBaseInfo:mLevel	Ljava/lang/String;
    //   604: invokevirtual 400	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   607: pop
    //   608: aload 12
    //   610: ldc_w 791
    //   613: aload 10
    //   615: getfield 255	com/tencent/mobileqq/apollo/api/impl/ApolloManagerServiceImpl:mPetConfig	Ljava/lang/String;
    //   618: aload 15
    //   620: getfield 700	com/tencent/mobileqq/apollo/model/ApolloDress:roleId	I
    //   623: iload_3
    //   624: invokestatic 793	com/tencent/mobileqq/apollo/script/SpriteRscBuilder:a	(Ljava/lang/String;IZ)Ljava/lang/String;
    //   627: invokevirtual 400	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   630: pop
    //   631: aload_0
    //   632: getfield 35	com/tencent/mobileqq/apollo/script/SpriteRscBuilder:jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext	Lcom/tencent/mobileqq/apollo/script/SpriteContext;
    //   635: getfield 796	com/tencent/mobileqq/apollo/script/SpriteContext:jdField_a_of_type_ComTencentMobileqqApolloModelApolloRoleInfo	Lcom/tencent/mobileqq/apollo/model/ApolloRoleInfo;
    //   638: ifnull +63 -> 701
    //   641: aload 12
    //   643: ldc_w 798
    //   646: aload_0
    //   647: getfield 35	com/tencent/mobileqq/apollo/script/SpriteRscBuilder:jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext	Lcom/tencent/mobileqq/apollo/script/SpriteContext;
    //   650: getfield 796	com/tencent/mobileqq/apollo/script/SpriteContext:jdField_a_of_type_ComTencentMobileqqApolloModelApolloRoleInfo	Lcom/tencent/mobileqq/apollo/model/ApolloRoleInfo;
    //   653: getfield 803	com/tencent/mobileqq/apollo/model/ApolloRoleInfo:scale	F
    //   656: f2d
    //   657: invokevirtual 806	org/json/JSONObject:put	(Ljava/lang/String;D)Lorg/json/JSONObject;
    //   660: pop
    //   661: aload 12
    //   663: ldc_w 808
    //   666: aload_0
    //   667: getfield 35	com/tencent/mobileqq/apollo/script/SpriteRscBuilder:jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext	Lcom/tencent/mobileqq/apollo/script/SpriteContext;
    //   670: getfield 796	com/tencent/mobileqq/apollo/script/SpriteContext:jdField_a_of_type_ComTencentMobileqqApolloModelApolloRoleInfo	Lcom/tencent/mobileqq/apollo/model/ApolloRoleInfo;
    //   673: getfield 810	com/tencent/mobileqq/apollo/model/ApolloRoleInfo:xPos	F
    //   676: f2d
    //   677: invokevirtual 806	org/json/JSONObject:put	(Ljava/lang/String;D)Lorg/json/JSONObject;
    //   680: pop
    //   681: aload 12
    //   683: ldc_w 812
    //   686: aload_0
    //   687: getfield 35	com/tencent/mobileqq/apollo/script/SpriteRscBuilder:jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext	Lcom/tencent/mobileqq/apollo/script/SpriteContext;
    //   690: getfield 796	com/tencent/mobileqq/apollo/script/SpriteContext:jdField_a_of_type_ComTencentMobileqqApolloModelApolloRoleInfo	Lcom/tencent/mobileqq/apollo/model/ApolloRoleInfo;
    //   693: getfield 814	com/tencent/mobileqq/apollo/model/ApolloRoleInfo:yPos	F
    //   696: f2d
    //   697: invokevirtual 806	org/json/JSONObject:put	(Ljava/lang/String;D)Lorg/json/JSONObject;
    //   700: pop
    //   701: iload 5
    //   703: ifeq +10 -> 713
    //   706: aload 12
    //   708: astore 11
    //   710: goto +6 -> 716
    //   713: aconst_null
    //   714: astore 11
    //   716: iload 5
    //   718: ifne +145 -> 863
    //   721: aload_2
    //   722: ifnull +141 -> 863
    //   725: aload_2
    //   726: invokevirtual 65	com/tencent/mobileqq/apollo/script/SpriteContext:a	()Lcom/tencent/mobileqq/app/QQAppInterface;
    //   729: ifnull +134 -> 863
    //   732: new 229	java/lang/StringBuilder
    //   735: dup
    //   736: invokespecial 230	java/lang/StringBuilder:<init>	()V
    //   739: astore 12
    //   741: aload 12
    //   743: ldc_w 816
    //   746: invokevirtual 240	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   749: pop
    //   750: aload 12
    //   752: aload_1
    //   753: invokevirtual 240	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   756: pop
    //   757: ldc 245
    //   759: iconst_1
    //   760: aload 12
    //   762: invokevirtual 249	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   765: invokestatic 265	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   768: aload 10
    //   770: ifnull +93 -> 863
    //   773: aload 13
    //   775: invokeinterface 817 1 0
    //   780: newarray int
    //   782: astore 12
    //   784: aload 13
    //   786: invokeinterface 818 1 0
    //   791: astore 13
    //   793: iconst_0
    //   794: istore 5
    //   796: aload 13
    //   798: invokeinterface 724 1 0
    //   803: ifeq +30 -> 833
    //   806: aload 12
    //   808: iload 5
    //   810: aload 13
    //   812: invokeinterface 728 1 0
    //   817: checkcast 56	java/lang/Integer
    //   820: invokevirtual 60	java/lang/Integer:intValue	()I
    //   823: iastore
    //   824: iload 5
    //   826: iconst_1
    //   827: iadd
    //   828: istore 5
    //   830: goto -34 -> 796
    //   833: ldc 181
    //   835: invokestatic 187	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   838: checkcast 181	com/tencent/mobileqq/apollo/res/api/IApolloResDownloader
    //   841: aload_2
    //   842: invokevirtual 65	com/tencent/mobileqq/apollo/script/SpriteContext:a	()Lcom/tencent/mobileqq/app/QQAppInterface;
    //   845: aload_1
    //   846: aload 10
    //   848: invokevirtual 822	com/tencent/mobileqq/apollo/api/impl/ApolloManagerServiceImpl:getResDownloadListener	()Lcom/tencent/mobileqq/apollo/res/api/IApolloResDownloader$OnApolloDownLoadListener;
    //   851: iload 4
    //   853: aload 12
    //   855: iconst_m1
    //   856: iconst_m1
    //   857: iconst_1
    //   858: invokeinterface 503 9 0
    //   863: aload 11
    //   865: areturn
    //   866: astore 11
    //   868: goto +10 -> 878
    //   871: astore 11
    //   873: goto +56 -> 929
    //   876: astore 11
    //   878: goto +221 -> 1099
    //   881: astore 11
    //   883: goto +46 -> 929
    //   886: aconst_null
    //   887: areturn
    //   888: astore 11
    //   890: goto +19 -> 909
    //   893: astore 11
    //   895: iconst_m1
    //   896: istore 4
    //   898: iconst_1
    //   899: istore 5
    //   901: goto +28 -> 929
    //   904: astore 11
    //   906: aconst_null
    //   907: astore 10
    //   909: iconst_m1
    //   910: istore 4
    //   912: iconst_1
    //   913: istore 5
    //   915: goto +184 -> 1099
    //   918: astore 11
    //   920: iconst_m1
    //   921: istore 4
    //   923: iconst_1
    //   924: istore 5
    //   926: aconst_null
    //   927: astore 10
    //   929: iconst_0
    //   930: istore 6
    //   932: ldc 138
    //   934: iconst_1
    //   935: aload 11
    //   937: iconst_0
    //   938: anewarray 4	java/lang/Object
    //   941: invokestatic 410	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   944: iload 5
    //   946: ifne +146 -> 1092
    //   949: aload_2
    //   950: ifnull +142 -> 1092
    //   953: aload_2
    //   954: invokevirtual 65	com/tencent/mobileqq/apollo/script/SpriteContext:a	()Lcom/tencent/mobileqq/app/QQAppInterface;
    //   957: ifnull +135 -> 1092
    //   960: new 229	java/lang/StringBuilder
    //   963: dup
    //   964: invokespecial 230	java/lang/StringBuilder:<init>	()V
    //   967: astore 11
    //   969: aload 11
    //   971: ldc_w 816
    //   974: invokevirtual 240	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   977: pop
    //   978: aload 11
    //   980: aload_1
    //   981: invokevirtual 240	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   984: pop
    //   985: ldc 245
    //   987: iconst_1
    //   988: aload 11
    //   990: invokevirtual 249	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   993: invokestatic 265	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   996: aload 10
    //   998: ifnull +94 -> 1092
    //   1001: aload 13
    //   1003: invokeinterface 817 1 0
    //   1008: newarray int
    //   1010: astore 11
    //   1012: aload 13
    //   1014: invokeinterface 818 1 0
    //   1019: astore 12
    //   1021: iload 6
    //   1023: istore 5
    //   1025: aload 12
    //   1027: invokeinterface 724 1 0
    //   1032: ifeq +30 -> 1062
    //   1035: aload 11
    //   1037: iload 5
    //   1039: aload 12
    //   1041: invokeinterface 728 1 0
    //   1046: checkcast 56	java/lang/Integer
    //   1049: invokevirtual 60	java/lang/Integer:intValue	()I
    //   1052: iastore
    //   1053: iload 5
    //   1055: iconst_1
    //   1056: iadd
    //   1057: istore 5
    //   1059: goto -34 -> 1025
    //   1062: ldc 181
    //   1064: invokestatic 187	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   1067: checkcast 181	com/tencent/mobileqq/apollo/res/api/IApolloResDownloader
    //   1070: aload_2
    //   1071: invokevirtual 65	com/tencent/mobileqq/apollo/script/SpriteContext:a	()Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1074: aload_1
    //   1075: aload 10
    //   1077: invokevirtual 822	com/tencent/mobileqq/apollo/api/impl/ApolloManagerServiceImpl:getResDownloadListener	()Lcom/tencent/mobileqq/apollo/res/api/IApolloResDownloader$OnApolloDownLoadListener;
    //   1080: iload 4
    //   1082: aload 11
    //   1084: iconst_m1
    //   1085: iconst_m1
    //   1086: iconst_1
    //   1087: invokeinterface 503 9 0
    //   1092: aconst_null
    //   1093: areturn
    //   1094: astore 11
    //   1096: goto +3 -> 1099
    //   1099: iconst_0
    //   1100: istore 6
    //   1102: iload 5
    //   1104: ifne +146 -> 1250
    //   1107: aload_2
    //   1108: ifnull +142 -> 1250
    //   1111: aload_2
    //   1112: invokevirtual 65	com/tencent/mobileqq/apollo/script/SpriteContext:a	()Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1115: ifnull +135 -> 1250
    //   1118: new 229	java/lang/StringBuilder
    //   1121: dup
    //   1122: invokespecial 230	java/lang/StringBuilder:<init>	()V
    //   1125: astore 12
    //   1127: aload 12
    //   1129: ldc_w 816
    //   1132: invokevirtual 240	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1135: pop
    //   1136: aload 12
    //   1138: aload_1
    //   1139: invokevirtual 240	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1142: pop
    //   1143: ldc 245
    //   1145: iconst_1
    //   1146: aload 12
    //   1148: invokevirtual 249	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1151: invokestatic 265	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1154: aload 10
    //   1156: ifnull +94 -> 1250
    //   1159: aload 13
    //   1161: invokeinterface 817 1 0
    //   1166: newarray int
    //   1168: astore 12
    //   1170: aload 13
    //   1172: invokeinterface 818 1 0
    //   1177: astore 13
    //   1179: iload 6
    //   1181: istore 5
    //   1183: aload 13
    //   1185: invokeinterface 724 1 0
    //   1190: ifeq +30 -> 1220
    //   1193: aload 12
    //   1195: iload 5
    //   1197: aload 13
    //   1199: invokeinterface 728 1 0
    //   1204: checkcast 56	java/lang/Integer
    //   1207: invokevirtual 60	java/lang/Integer:intValue	()I
    //   1210: iastore
    //   1211: iload 5
    //   1213: iconst_1
    //   1214: iadd
    //   1215: istore 5
    //   1217: goto -34 -> 1183
    //   1220: ldc 181
    //   1222: invokestatic 187	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   1225: checkcast 181	com/tencent/mobileqq/apollo/res/api/IApolloResDownloader
    //   1228: aload_2
    //   1229: invokevirtual 65	com/tencent/mobileqq/apollo/script/SpriteContext:a	()Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1232: aload_1
    //   1233: aload 10
    //   1235: invokevirtual 822	com/tencent/mobileqq/apollo/api/impl/ApolloManagerServiceImpl:getResDownloadListener	()Lcom/tencent/mobileqq/apollo/res/api/IApolloResDownloader$OnApolloDownLoadListener;
    //   1238: iload 4
    //   1240: aload 12
    //   1242: iconst_m1
    //   1243: iconst_m1
    //   1244: iconst_1
    //   1245: invokeinterface 503 9 0
    //   1250: goto +6 -> 1256
    //   1253: aload 11
    //   1255: athrow
    //   1256: goto -3 -> 1253
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1259	0	this	SpriteRscBuilder
    //   0	1259	1	paramString	String
    //   0	1259	2	paramSpriteContext	SpriteContext
    //   0	1259	3	paramBoolean	boolean
    //   144	1095	4	i	int
    //   19	1197	5	j	int
    //   205	975	6	k	int
    //   267	78	7	m	int
    //   281	30	8	n	int
    //   132	172	9	bool	boolean
    //   39	1195	10	localApolloManagerServiceImpl	ApolloManagerServiceImpl
    //   25	17	11	localQQAppInterface	QQAppInterface
    //   152	1	11	localObject1	Object
    //   163	1	11	localThrowable1	Throwable
    //   187	90	11	arrayOfInt	int[]
    //   327	1	11	localObject2	Object
    //   332	1	11	localThrowable2	Throwable
    //   385	479	11	localObject3	Object
    //   866	1	11	localObject4	Object
    //   871	1	11	localThrowable3	Throwable
    //   876	1	11	localObject5	Object
    //   881	1	11	localThrowable4	Throwable
    //   888	1	11	localObject6	Object
    //   893	1	11	localThrowable5	Throwable
    //   904	1	11	localObject7	Object
    //   918	18	11	localThrowable6	Throwable
    //   967	116	11	localObject8	Object
    //   1094	160	11	localObject9	Object
    //   7	1234	12	localObject10	Object
    //   16	1182	13	localObject11	Object
    //   57	543	14	localApolloBaseInfo	ApolloBaseInfo
    //   71	548	15	localApolloDress	com.tencent.mobileqq.apollo.model.ApolloDress
    //   202	220	16	localObject12	Object
    // Exception table:
    //   from	to	target	type
    //   139	146	152	finally
    //   139	146	163	java/lang/Throwable
    //   308	321	327	finally
    //   308	321	332	java/lang/Throwable
    //   283	303	866	finally
    //   349	438	866	finally
    //   438	467	866	finally
    //   467	512	866	finally
    //   512	544	866	finally
    //   544	576	866	finally
    //   576	608	866	finally
    //   608	701	866	finally
    //   283	303	871	java/lang/Throwable
    //   349	438	871	java/lang/Throwable
    //   438	467	871	java/lang/Throwable
    //   467	512	871	java/lang/Throwable
    //   512	544	871	java/lang/Throwable
    //   544	576	871	java/lang/Throwable
    //   576	608	871	java/lang/Throwable
    //   608	701	871	java/lang/Throwable
    //   177	204	876	finally
    //   207	243	876	finally
    //   252	266	876	finally
    //   177	204	881	java/lang/Throwable
    //   207	243	881	java/lang/Throwable
    //   252	266	881	java/lang/Throwable
    //   41	59	888	finally
    //   66	73	888	finally
    //   78	134	888	finally
    //   41	59	893	java/lang/Throwable
    //   66	73	893	java/lang/Throwable
    //   78	134	893	java/lang/Throwable
    //   21	41	904	finally
    //   21	41	918	java/lang/Throwable
    //   932	944	1094	finally
  }
  
  public void a()
  {
    Map localMap = this.jdField_a_of_type_JavaUtilMap;
    if (localMap != null) {
      localMap.clear();
    }
  }
  
  public void a(List<String> paramList)
  {
    if (paramList != null)
    {
      if (paramList.size() == 0) {
        return;
      }
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = paramList.iterator();
      Object localObject2 = null;
      Object localObject1 = null;
      int i = 1;
      Object localObject3;
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        paramList = a(this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a(), str);
        if (str.equals(this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.b))
        {
          localObject1 = a(paramList);
        }
        else
        {
          localObject3 = a(paramList);
          paramList = (List<String>)localObject1;
          localObject1 = localObject3;
        }
        ((SpriteTaskParam)localObject1).jdField_a_of_type_Int = i;
        ((SpriteTaskParam)localObject1).jdField_a_of_type_Boolean = true;
        ((SpriteTaskParam)localObject1).jdField_a_of_type_JavaLangString = str;
        localArrayList.add(localObject1);
        if (QLog.isColorLevel()) {
          QLog.d("[cmshow][scripted]SpriteRscBuilder", 2, new Object[] { "playAppearAction task action:", Integer.valueOf(((SpriteTaskParam)localObject1).f), ",uin:", str.substring(0, 4) });
        }
        i += 1;
        localObject1 = paramList;
      }
      SpriteUtil.a(this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext, localArrayList);
      if (localObject1 != null)
      {
        localObject3 = this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a().getApp().getSharedPreferences("apollo_sp", 0);
        paramList = new StringBuilder();
        paramList.append("stand_type_");
        paramList.append(((SpriteRscBuilder.ApolloAppearAction)localObject1).jdField_b_of_type_Int);
        if (!((SharedPreferences)localObject3).getBoolean(paramList.toString(), false))
        {
          i = ((SpriteRscBuilder.ApolloAppearAction)localObject1).jdField_b_of_type_Int;
          if (i != 1)
          {
            if (i != 2)
            {
              if (i != 3) {
                paramList = (List<String>)localObject2;
              } else {
                paramList = HardCodeUtil.a(2131714134);
              }
            }
            else {
              paramList = HardCodeUtil.a(2131714127);
            }
          }
          else {
            paramList = HardCodeUtil.a(2131714131);
          }
          localObject2 = SpriteUtil.a(this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a());
          if ((!TextUtils.isEmpty(paramList)) && (localObject2 != null)) {
            ((SpriteActionScript)localObject2).b(this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.b, paramList);
          }
          paramList = ((SharedPreferences)localObject3).edit();
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("stand_type_");
          ((StringBuilder)localObject2).append(((SpriteRscBuilder.ApolloAppearAction)localObject1).jdField_b_of_type_Int);
          paramList.putBoolean(((StringBuilder)localObject2).toString(), true).commit();
        }
        if (this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.jdField_a_of_type_Int == 3000) {
          i = 2;
        } else {
          i = this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.jdField_a_of_type_Int;
        }
        VipUtils.a(null, "cmshow", "Apollo", "appearanceaction", i, ((SpriteRscBuilder.ApolloAppearAction)localObject1).jdField_b_of_type_Int, new String[] { String.valueOf(((SpriteRscBuilder.ApolloAppearAction)localObject1).jdField_a_of_type_Int) });
      }
    }
  }
  
  boolean a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramQQAppInterface != null))
    {
      int i;
      if (this.jdField_a_of_type_JavaUtilMap.containsKey(paramString)) {
        i = ((Integer)this.jdField_a_of_type_JavaUtilMap.get(paramString)).intValue();
      } else {
        i = 0;
      }
      int j;
      if (jdField_b_of_type_JavaUtilMap.containsKey(paramString)) {
        j = ((Integer)jdField_b_of_type_JavaUtilMap.get(paramString)).intValue();
      } else {
        j = 0;
      }
      Object localObject = ((IApolloManagerService)this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a().getRuntimeService(IApolloManagerService.class, "all")).getStandUpSp();
      ApolloExtensionHandler localApolloExtensionHandler = (ApolloExtensionHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.APOLLO_EXTENSION_HANDLER);
      try
      {
        if (this.c.get(paramString) == null) {
          l = 0L;
        } else {
          l = ((Long)this.c.get(paramString)).longValue();
        }
        boolean bool = ((SharedPreferences)localObject).contains(paramString);
        if ((!bool) && (NetConnInfoCenter.getServerTime() - l > 180L))
        {
          paramQQAppInterface = new JSONObject();
          paramQQAppInterface.put("lastRequestTime", NetConnInfoCenter.getServerTimeMillis());
          ((SharedPreferences)localObject).edit().putString(paramString, paramQQAppInterface.toString()).commit();
          localApolloExtensionHandler.a(new long[] { Long.parseLong(paramString) });
          this.c.put(paramString, Long.valueOf(NetConnInfoCenter.getServerTime()));
          return false;
        }
        JSONObject localJSONObject = new JSONObject(((SharedPreferences)localObject).getString(paramString, "{}"));
        JSONArray localJSONArray = localJSONObject.optJSONArray("action");
        long l = localJSONObject.optLong("lastRequestTime");
        if ((j < 5) && (NetConnInfoCenter.getServerTime() - l <= 10800000L))
        {
          jdField_b_of_type_JavaUtilMap.put(paramString, Integer.valueOf(j + 1));
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.d("[cmshow][scripted]SpriteRscBuilder", 2, new Object[] { "hasSpecialStandAction getApolloStandAction openCount:", Integer.valueOf(j), ",lastRequestSpTime:", Long.valueOf(l) });
          }
          jdField_b_of_type_JavaUtilMap.put(paramString, Integer.valueOf(0));
          localApolloExtensionHandler.a(new long[] { Long.parseLong(paramString) });
          localJSONObject.put("lastRequestTime", NetConnInfoCenter.getServerTimeMillis());
          ((SharedPreferences)localObject).edit().putString(paramString, localJSONObject.toString()).commit();
        }
        if ((localJSONArray != null) && (localJSONArray.length() > 0))
        {
          j = i;
          if (i >= localJSONArray.length()) {
            j = 0;
          }
          localObject = localJSONArray.getJSONObject(j);
          this.jdField_a_of_type_Int = ((JSONObject)localObject).getInt("type");
          this.jdField_b_of_type_Int = ((JSONObject)localObject).getInt("id");
          if (this.jdField_a_of_type_Int == 4)
          {
            localObject = (ApolloManagerServiceImpl)this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a().getRuntimeService(IApolloManagerService.class, "all");
            if (!((ApolloDaoManagerServiceImpl)paramQQAppInterface.getRuntimeService(IApolloDaoManagerService.class, "all")).getApolloBaseInfo(paramString).hasPet)
            {
              a(paramString);
              return false;
            }
          }
          if (QLog.isColorLevel()) {
            QLog.d("[cmshow][scripted]SpriteRscBuilder", 2, new Object[] { "[hasSpecialStandAction] uin:", paramString, ",index:", Integer.valueOf(j), ",id:", Integer.valueOf(this.jdField_b_of_type_Int), ",standType:", Integer.valueOf(this.jdField_a_of_type_Int) });
          }
          if (!CMResUtil.a(this.jdField_b_of_type_Int, 0))
          {
            if (QLog.isColorLevel()) {
              QLog.i("[cmshow][scripted]SpriteRscBuilder", 2, "hasSpecialStandAction isActionResDone is false.");
            }
            localObject = new ApolloActionData();
            ((ApolloActionData)localObject).actionId = this.jdField_b_of_type_Int;
            paramString = CMGetResPathUtil.a((ApolloActionData)localObject, 5);
            localObject = CMGetResPathUtil.a((ApolloActionData)localObject, 4);
            ((IApolloResDownloader)QRoute.api(IApolloResDownloader.class)).downLoadSpecialAction(paramQQAppInterface, (String)localObject, paramString);
            return false;
          }
          this.jdField_a_of_type_JavaUtilMap.put(paramString, Integer.valueOf(j + 1));
          return true;
        }
        return false;
      }
      catch (Exception paramQQAppInterface)
      {
        QLog.e("[cmshow][scripted]SpriteRscBuilder", 2, "hasSpecialStandAction error:", paramQQAppInterface);
        return false;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.script.SpriteRscBuilder
 * JD-Core Version:    0.7.0.1
 */