package com.tencent.mobileqq.apollo.script;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import android.util.Pair;
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
import com.tencent.mobileqq.apollo.api.model.ApolloRoleInfo;
import com.tencent.mobileqq.apollo.api.res.IApolloResDownloader;
import com.tencent.mobileqq.apollo.api.res.IApolloResDownloader.OnFaceDataDownloadListener;
import com.tencent.mobileqq.apollo.api.script.ISpriteUIHandler;
import com.tencent.mobileqq.apollo.api.script.SpriteTaskParam;
import com.tencent.mobileqq.apollo.api.uitls.ApolloConstant;
import com.tencent.mobileqq.apollo.api.uitls.IApolloUtil;
import com.tencent.mobileqq.apollo.api.uitls.impl.ApolloActionHelperImpl;
import com.tencent.mobileqq.apollo.api.uitls.impl.ApolloUtilImpl;
import com.tencent.mobileqq.apollo.handler.ApolloContentUpdateHandler;
import com.tencent.mobileqq.apollo.utils.ApolloGameBasicEventUtil;
import com.tencent.mobileqq.apollo.utils.ApolloGameBasicEventUtil.NotifyDressReady;
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
import java.util.Iterator;
import java.util.List;
import java.util.List<Ljava.lang.String;>;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import org.json.JSONArray;
import org.json.JSONObject;

public class SpriteRscBuilder
{
  static Map<String, Integer> jdField_a_of_type_JavaUtilMap = new HashMap();
  int jdField_a_of_type_Int = -1;
  private SpriteContext jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext;
  int jdField_b_of_type_Int = -1;
  Map<String, Integer> jdField_b_of_type_JavaUtilMap = new HashMap();
  Map<String, String> c = new ConcurrentHashMap(2);
  private Map<String, Long> d = new HashMap();
  
  public SpriteRscBuilder(SpriteContext paramSpriteContext)
  {
    this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext = paramSpriteContext;
  }
  
  public static Pair<String, Integer> a(String paramString, int paramInt)
  {
    Pair localPair = null;
    if (TextUtils.isEmpty(paramString)) {
      paramString = localPair;
    }
    int i;
    String str;
    do
    {
      do
      {
        return paramString;
        i = ApolloUtilImpl.handleQzoneBubbleType(248.0F, paramString, paramInt);
        if (ApolloUtilImpl.isBubbleRscExist(0, i)) {
          break;
        }
        paramString = localPair;
      } while (!QLog.isColorLevel());
      QLog.d("cmshow_scripted_SpriteRscBuilder", 2, new Object[] { "getQzoneBubbleRsc, bubble res not exist bubbleId=", Integer.valueOf(i) });
      return null;
      str = ApolloActionHelperImpl.getBubbleRscName(0, i, paramInt);
      localPair = new Pair(str, Integer.valueOf(i));
      paramString = localPair;
    } while (!QLog.isColorLevel());
    QLog.d("cmshow_scripted_SpriteRscBuilder", 2, new Object[] { "getQzoneBubbleRsc, bubbleId=", Integer.valueOf(i), ", bubbleRsc=", str });
    return localPair;
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
      localObject1 = (ApolloManagerServiceImpl)this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a().getRuntimeService(IApolloManagerService.class, "all");
      localObject2 = ((ApolloManagerServiceImpl)localObject1).getApolloAppearAction(paramQQAppInterface, paramString);
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
          localObject2 = new SpriteRscBuilder.ApolloAppearAction();
          localObject3 = ((JSONArray)localObject3).getJSONObject(i);
          ((SpriteRscBuilder.ApolloAppearAction)localObject2).jdField_b_of_type_Int = ((JSONObject)localObject3).getInt("type");
          ((SpriteRscBuilder.ApolloAppearAction)localObject2).jdField_a_of_type_Int = ((JSONObject)localObject3).getInt("id");
          localObject3 = ((ApolloManagerServiceImpl)localObject1).getApolloBaseInfo(paramString);
          if (localObject3 == null) {
            return null;
          }
          if ((((SpriteRscBuilder.ApolloAppearAction)localObject2).jdField_b_of_type_Int == 4) && (!((ApolloBaseInfo)localObject3).hasPet))
          {
            ((ApolloBaseInfo)localObject3).appearAction = null;
            ((ApolloManagerServiceImpl)localObject1).saveOrUpdateApolloBaseInfo((ApolloBaseInfo)localObject3);
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
          if (!ApolloUtilImpl.isActionResDone(((SpriteRscBuilder.ApolloAppearAction)localObject2).jdField_a_of_type_Int, 0))
          {
            if (QLog.isColorLevel()) {
              QLog.i("cmshow_scripted_SpriteRscBuilder", 2, "hasAppearAction isActionResDone is false.");
            }
            paramString = new ApolloActionData();
            paramString.actionId = ((SpriteRscBuilder.ApolloAppearAction)localObject2).jdField_a_of_type_Int;
            localObject1 = ApolloUtilImpl.getApolloResPath(paramString, 5);
            paramString = ApolloUtilImpl.getApolloResPath(paramString, 4);
            ((IApolloResDownloader)QRoute.api(IApolloResDownloader.class)).downLoadSpecialAction(paramQQAppInterface, paramString, (String)localObject1);
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
  
  private String a(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext == null) || (this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a() == null)) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    paramInt = ((ApolloManagerServiceImpl)this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a().getRuntimeService(IApolloManagerService.class, "all")).getPetRandomAction(paramInt);
    if ((paramInt != -1) && (!ApolloUtilImpl.isActionResDone(paramInt, 0)))
    {
      if (QLog.isColorLevel()) {
        QLog.i("ApolloPet", 2, "download random pet action:" + paramInt);
      }
      Object localObject = new ApolloActionData();
      ((ApolloActionData)localObject).actionId = paramInt;
      String str = ApolloUtilImpl.getApolloResPath((ApolloActionData)localObject, 5);
      localObject = ApolloUtilImpl.getApolloResPath((ApolloActionData)localObject, 4);
      ((IApolloResDownloader)QRoute.api(IApolloResDownloader.class)).downLoadSpecialAction(this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a(), (String)localObject, str);
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
      QLog.d("cmshow_scripted_SpriteRscBuilder", 2, new Object[] { "getNicknamePath uin:", ((IApolloUtil)QRoute.api(IApolloUtil.class)).wrapLogUin(paramString), ", isMe:", Boolean.valueOf(bool2), ",isYellowVip:", Boolean.valueOf(bool1), ",isRight:", Boolean.valueOf(paramBoolean), ",bubbleId:", Integer.valueOf(i) });
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
  
  private String a(boolean paramBoolean, String paramString, int paramInt)
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
          break label249;
        }
        bool1 = true;
        break label246;
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
      QLog.e("cmshow_scripted_SpriteRscBuilder", 1, "[random] the json is not right," + paramString);
    }
    for (;;)
    {
      label246:
      break;
      label249:
      bool1 = false;
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
        if ((CmShowAioMatcher.a(this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.jdField_a_of_type_Int, 1)) || (paramSpriteTaskParam.e == 1))
        {
          localJSONObject1 = a(paramSpriteTaskParam.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext, paramSpriteTaskParam, false, false);
          if (localJSONObject2 != null)
          {
            localJSONArray.put(localJSONObject2);
            if (!this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.jdField_c_of_type_Boolean)
            {
              JSONObject localJSONObject3 = a(paramSpriteTaskParam.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext, true);
              if (localJSONObject3 != null) {
                localJSONObject2.put("pet", localJSONObject3);
              }
            }
          }
          if (localJSONObject1 != null)
          {
            localJSONArray.put(localJSONObject1);
            if (!this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.jdField_c_of_type_Boolean)
            {
              paramSpriteTaskParam = a(paramSpriteTaskParam.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext, false);
              if (paramSpriteTaskParam != null) {
                localJSONObject1.put("pet", paramSpriteTaskParam);
              }
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
          break label507;
        }
        if (QLog.isColorLevel()) {
          QLog.d("cmshow_scripted_SpriteRscBuilder", 2, new Object[] { "ReqAction,", paramJSONObject });
        }
        ApolloDaoManagerServiceImpl localApolloDaoManagerServiceImpl = (ApolloDaoManagerServiceImpl)paramQQAppInterface.getRuntimeService(IApolloDaoManagerService.class, "all");
        int i = 0;
        j = 0;
        if (j < localJSONArray2.length())
        {
          paramJSONObject = localJSONArray2.getJSONObject(j);
          if (paramJSONObject == null) {
            break label510;
          }
          int k = paramJSONObject.optInt("actionId");
          int m = paramJSONObject.optInt("perNum");
          if (QLog.isColorLevel()) {
            QLog.d("cmshow_scripted_SpriteRscBuilder", 2, new Object[] { "ReqAction,actId:", Integer.valueOf(k), ",perNum:", Integer.valueOf(m) });
          }
          if (-1 == m)
          {
            paramJSONObject = localApolloDaoManagerServiceImpl.findActionById(k);
            if (paramJSONObject != null) {
              break label504;
            }
            QLog.i("cmshow_scripted_SpriteRscBuilder", 1, "ReqAction,[getActionsPath], warning: data is null. call checkApolloPanelJsonVer, id:" + k);
            if (i == 0)
            {
              ApolloContentUpdateHandler.a(paramQQAppInterface, 1);
              i = 1;
              break label510;
            }
          }
          else
          {
            paramJSONObject = new ApolloActionData();
            paramJSONObject.actionId = k;
            paramJSONObject.personNum = m;
            bool2 = ApolloUtilImpl.isActionResDone(k, paramJSONObject.personNum);
            Object localObject = (ApolloManagerServiceImpl)paramQQAppInterface.getRuntimeService(IApolloManagerService.class, "all");
            if (bool2) {
              break label498;
            }
            bool1 = ((ApolloManagerServiceImpl)localObject).downloadApolloRes(paramJSONObject, 4, null);
            if (!QLog.isColorLevel()) {
              break label517;
            }
            QLog.d("cmshow_scripted_SpriteRscBuilder", 2, new Object[] { "ReqAction,isActionDone:", Boolean.valueOf(bool2), ",ret:", Boolean.valueOf(bool1) });
            break label517;
            localObject = new JSONObject();
            String[] arrayOfString = ApolloActionHelperImpl.getActionRscPath(1, k, 0, true);
            ((JSONObject)localObject).put("actionId", k);
            ((JSONObject)localObject).put("actionPath", ApolloActionHelperImpl.getResAddPrefixPath(arrayOfString[0], 3));
            if (paramJSONObject.personNum == 1) {
              ((JSONObject)localObject).put("peerPath", ApolloActionHelperImpl.getResAddPrefixPath(ApolloActionHelperImpl.getActionRscPath(1, k, 0, false)[0], 3));
            }
            localJSONArray1.put(localObject);
            if (QLog.isColorLevel()) {
              QLog.d("cmshow_scripted_SpriteRscBuilder", 2, new Object[] { "ReqAction,put into array, id:", Integer.valueOf(k) });
            }
          }
          break label510;
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
      label498:
      boolean bool1 = false;
      continue;
      label504:
      continue;
      label507:
      return localJSONArray1;
      label510:
      j += 1;
      continue;
      label517:
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
      localObject = ((ApolloDaoManagerServiceImpl)this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a().getRuntimeService(IApolloDaoManagerService.class, "all")).findActionById(paramInt1);
      if (localObject == null) {
        return null;
      }
      localJSONObject.put("actionId", paramInt1);
      localJSONObject.put("action", ApolloActionHelperImpl.getWhiteFaceRscPath(paramInt1, paramInt2, true, this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.e())[0]);
      if (((ApolloActionData)localObject).personNum == 1) {
        localJSONObject.put("actionPeer", ApolloActionHelperImpl.getWhiteFaceRscPath(paramInt1, paramInt2, false, this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.e())[0]);
      }
      while (CmShowAioMatcher.a(this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.jdField_a_of_type_Int, 1))
      {
        localJSONObject.put("actionDis", ((ApolloActionData)localObject).actionMoveDis * (float)DeviceInfoUtil.j() / 7.0F / 368.0F);
        localJSONObject.put("actionPeerDis", ((ApolloActionData)localObject).peerMoveDis * (float)DeviceInfoUtil.j() / 7.0F / 368.0F);
        return localJSONObject;
        localJSONObject.put("actionPeer", new String[0]);
      }
      localThrowable.put("posType", ((ApolloActionData)localObject).playArea);
    }
    catch (Throwable localThrowable)
    {
      QLog.e("cmshow_scripted_SpriteRscBuilder", 1, "[getWhiteFaceSingleAction],", localThrowable);
      return null;
    }
    return localThrowable;
  }
  
  private JSONObject a(String paramString, SpriteContext paramSpriteContext, SpriteTaskParam paramSpriteTaskParam, boolean paramBoolean1, boolean paramBoolean2)
  {
    JSONObject localJSONObject = null;
    for (;;)
    {
      Object localObject1;
      int j;
      try
      {
        Object localObject2 = ApolloActionData.getModelString(paramSpriteTaskParam.f);
        localObject1 = localJSONObject;
        if (paramSpriteContext.d())
        {
          localObject1 = localJSONObject;
          if (paramSpriteTaskParam.f > 0) {
            localObject1 = localObject2;
          }
        }
        localJSONObject = a(paramString, paramSpriteContext, SpriteUtil.a(paramString, paramSpriteTaskParam, paramSpriteContext, paramBoolean1), (String)localObject1, paramSpriteTaskParam.jdField_d_of_type_Boolean);
        if ((paramSpriteContext.jdField_c_of_type_Boolean) && (localJSONObject != null)) {
          localJSONObject.put("model", localObject2);
        }
        if ((paramSpriteTaskParam.jdField_d_of_type_Boolean) && (!a(paramSpriteTaskParam))) {
          return localJSONObject;
        }
        localObject2 = (ApolloManagerServiceImpl)this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a().getRuntimeService(IApolloManagerService.class, "all");
        j = ((ApolloManagerServiceImpl)localObject2).getCmShowStatus(paramSpriteContext.a(), paramString);
        int k = ((Integer)ApolloActionHelperImpl.get3DRoleDressIdByUin(paramString, j, paramSpriteContext.a(), true)[0]).intValue();
        localObject1 = paramString;
        if (((ApolloManagerServiceImpl)localObject2).getCmShowStatus(paramSpriteContext.a(), paramString, false) == 0)
        {
          localObject1 = paramString;
          if (paramSpriteContext.d())
          {
            if (!((IApolloUtil)QRoute.api(IApolloUtil.class)).isFemale(paramSpriteContext.a(), paramString)) {
              break label610;
            }
            paramString = "-2";
            break label602;
          }
        }
        paramString = ApolloActionHelperImpl.getRoleDressIdByUin((String)localObject1, paramSpriteContext.a(), true);
        if ((paramString == null) || (paramString.length != 2)) {
          break label608;
        }
        int m = ((Integer)paramString[0]).intValue();
        if (localJSONObject == null) {
          break;
        }
        if (!paramBoolean1) {
          break label619;
        }
        i = 1;
        localJSONObject.put("isMaster", i);
        if ((paramBoolean1) && (!TextUtils.isEmpty(paramSpriteTaskParam.jdField_c_of_type_JavaLangString)))
        {
          localJSONObject.put("text", SpriteUtil.a(Base64Util.encodeToString(paramSpriteTaskParam.jdField_c_of_type_JavaLangString.getBytes("utf-8"), 0)));
          if (paramSpriteTaskParam.jdField_b_of_type_Boolean) {
            continue;
          }
          localJSONObject.put("bubbleType", 0);
          if ((j == 1) && (paramSpriteTaskParam.f > ApolloConstant.jdField_b_of_type_Int) && (((ApolloManagerServiceImpl)localObject2).is3dAvailable(paramSpriteContext.a())))
          {
            i = 2;
            localJSONObject.put("bubble", a(paramSpriteTaskParam.jdField_c_of_type_JavaLangString, m, i));
          }
        }
        else
        {
          int n = paramSpriteTaskParam.k;
          int i1 = paramSpriteTaskParam.f;
          if (k < 0) {
            break label474;
          }
          i = k;
          paramString = ApolloActionHelperImpl.getActionRscPath(n, i1, i, paramBoolean1, j);
          if (paramString == null) {
            break label617;
          }
          if (paramString.length >= 2) {
            break label481;
          }
          break label617;
        }
        if ((j != 2) || (paramSpriteTaskParam.f >= ApolloConstant.jdField_b_of_type_Int)) {
          break label595;
        }
        i = 1;
        continue;
        localJSONObject.put("bubbleType", 1);
        continue;
        i = m;
      }
      catch (Throwable paramString)
      {
        QLog.e("cmshow_scripted_SpriteRscBuilder", 1, paramString, new Object[0]);
        return null;
      }
      label474:
      continue;
      label481:
      if ((paramSpriteTaskParam.e == 0) && (CmShowAioMatcher.a(paramSpriteTaskParam.jdField_c_of_type_Int, 1)) && (!paramBoolean1) && (!paramBoolean2)) {
        break;
      }
      paramSpriteContext = paramString[0];
      paramString = paramSpriteContext;
      if (8 == paramSpriteTaskParam.jdField_c_of_type_Int)
      {
        paramString = paramSpriteContext;
        if (!TextUtils.isEmpty(paramSpriteTaskParam.jdField_d_of_type_JavaLangString))
        {
          paramSpriteTaskParam = a(paramBoolean1, paramSpriteTaskParam.jdField_d_of_type_JavaLangString, paramSpriteTaskParam.f);
          paramString = paramSpriteContext;
          if (!TextUtils.isEmpty(paramSpriteTaskParam)) {
            paramString = paramSpriteContext + paramSpriteTaskParam;
          }
        }
      }
      localJSONObject.put("action", paramString);
      break;
      label595:
      int i = j;
      continue;
      for (;;)
      {
        label602:
        localObject1 = paramString;
        break;
        label608:
        return null;
        label610:
        paramString = "-1";
      }
      label617:
      return null;
      label619:
      i = 0;
    }
    return localJSONObject;
  }
  
  private JSONObject a(String paramString1, SpriteContext paramSpriteContext, boolean paramBoolean1, String paramString2, boolean paramBoolean2)
  {
    JSONObject localJSONObject;
    for (;;)
    {
      try
      {
        localJSONObject = new JSONObject();
        localJSONObject.put("uin", paramString1);
        ApolloActionHelperImpl.attach3DInfoToJson(paramString1, paramSpriteContext.a(), localJSONObject, paramString2);
        if ((((ApolloManagerServiceImpl)this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a().getRuntimeService(IApolloManagerService.class, "all")).getCmShowStatus(paramSpriteContext.a(), paramString1, false) == 0) && (paramSpriteContext.d()))
        {
          if (!((IApolloUtil)QRoute.api(IApolloUtil.class)).isFemale(paramSpriteContext.a(), paramString1)) {
            break label510;
          }
          paramString2 = "-2";
          paramString2 = ApolloActionHelperImpl.getRoleDressIdByUin(paramString2, paramSpriteContext.a(), paramBoolean2);
          if ((paramString2 == null) || (paramString2.length != 2))
          {
            SpriteUtil.a(301, new Object[] { "roleInfos is null" });
            return null;
          }
          int j = ((Integer)paramString2[0]).intValue();
          paramString2 = (int[])paramString2[1];
          if ((paramString2 == null) || (paramString2.length == 0))
          {
            SpriteUtil.a(301, new Object[] { "dressInfo is null" });
            return null;
          }
          JSONArray localJSONArray = new JSONArray();
          int k = paramString2.length;
          int i = 0;
          if (i < k)
          {
            localJSONArray.put(ApolloActionHelperImpl.getApolloRsc(1, Integer.valueOf(paramString2[i]).intValue()));
            i += 1;
            continue;
          }
          localJSONObject.put("dress", localJSONArray);
          localJSONObject.put("role", ApolloActionHelperImpl.getApolloRsc(0, j));
          if (((paramSpriteContext.jdField_a_of_type_Int == 1) || (paramSpriteContext.jdField_a_of_type_Int == 3000)) && (!"-1".equals(paramString1)) && (!"-2".equals(paramString1)) && (!paramSpriteContext.jdField_c_of_type_Boolean))
          {
            localJSONObject.put("nameplate", a(paramSpriteContext.a(), paramString1, j, paramBoolean1));
            paramString2 = paramSpriteContext.jdField_b_of_type_JavaLangString;
            if ((TextUtils.isEmpty(paramString2)) || (!paramString2.equals(paramString1))) {
              continue;
            }
            paramString1 = HardCodeUtil.a(2131714199);
            if (!TextUtils.isEmpty(paramString1)) {
              localJSONObject.put("nickname", SpriteUtil.a(Base64Util.encodeToString(paramString1.getBytes("utf-8"), 0)));
            }
          }
          if (this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloRoleInfo == null) {
            break;
          }
          localJSONObject.put("scale", this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloRoleInfo.scale);
          localJSONObject.put("xPos", this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloRoleInfo.xPos);
          localJSONObject.put("yPos", this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloRoleInfo.yPos);
          break;
          paramString1 = SpriteUtil.a(paramSpriteContext.a(), paramSpriteContext.jdField_a_of_type_Int, paramString1, paramSpriteContext.jdField_a_of_type_JavaLangString, true);
          continue;
        }
        paramString2 = paramString1;
      }
      catch (Throwable paramString1)
      {
        QLog.e("cmshow_scripted_SpriteRscBuilder", 1, paramString1, new Object[0]);
        return null;
      }
      continue;
      label510:
      paramString2 = "-1";
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
      QLog.i("cmshow_scripted_SpriteRscBuilder", 1, "role id is 0, uin:" + ((IApolloUtil)QRoute.api(IApolloUtil.class)).wrapLogUin(paramString));
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
            break label167;
          }
          if (!ApolloUtilImpl.checkDressRes(paramArrayOfInt[i]))
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
      label167:
      i = 0;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, IApolloResDownloader.OnFaceDataDownloadListener paramOnFaceDataDownloadListener)
  {
    int i;
    if (!ApolloUtilImpl.check3DFaceRes(paramString))
    {
      i = 1;
      if (i == 0) {
        break label35;
      }
      ((IApolloResDownloader)QRoute.api(IApolloResDownloader.class)).checkDownloadFaceData(paramQQAppInterface, paramString, paramOnFaceDataDownloadListener);
    }
    label35:
    while (paramOnFaceDataDownloadListener == null)
    {
      return;
      i = 0;
      break;
    }
    paramOnFaceDataDownloadListener.a(true, 0);
  }
  
  public static void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      localObject = ((IApolloUtil)QRoute.api(IApolloUtil.class)).getAppInterface();
      if (localObject == null) {
        break label86;
      }
    }
    label86:
    for (Object localObject = ((IApolloManagerService)((AppRuntime)localObject).getRuntimeService(IApolloManagerService.class, "all")).getStandUpSp();; localObject = null)
    {
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
      return;
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
        localApolloDaoManagerServiceImpl = (ApolloDaoManagerServiceImpl)this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a().getRuntimeService(IApolloDaoManagerService.class, "all");
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
              localObject = a(j, 2);
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
              localObject = a(m, 0);
              if (localObject != null) {
                localJSONArray.put(localObject);
              }
            }
            localObject = a(m, 1);
            if (localObject == null) {
              break label433;
            }
            localJSONArray.put(localObject);
            break label433;
          }
          j = -1;
          i = 1;
          QLog.i("cmshow_scripted_SpriteRscBuilder", 1, "[insertPrePost], action NOT exist locally, id:" + m);
        }
      }
      catch (Throwable paramSpriteTaskParam)
      {
        JSONArray localJSONArray;
        ApolloDaoManagerServiceImpl localApolloDaoManagerServiceImpl;
        int i;
        QLog.e("cmshow_scripted_SpriteRscBuilder", 1, "[getWhiteFaceActions],", paramSpriteTaskParam);
        return null;
        if (-1 != j)
        {
          paramSpriteTaskParam = localApolloDaoManagerServiceImpl.findActionById(j);
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
      label433:
      int j = m;
      k += 1;
    }
  }
  
  private JSONObject b(String paramString, SpriteContext paramSpriteContext, boolean paramBoolean)
  {
    return a(paramString, paramSpriteContext, paramBoolean, null, true);
  }
  
  public static void b(QQAppInterface paramQQAppInterface, String paramString, int paramInt, int[] paramArrayOfInt, ApolloGameBasicEventUtil.NotifyDressReady paramNotifyDressReady)
  {
    int k = 0;
    if (paramArrayOfInt == null) {}
    do
    {
      return;
      int i = 0;
      for (;;)
      {
        int j = k;
        if (i < paramArrayOfInt.length)
        {
          if (!ApolloUtilImpl.checkDressRes(paramArrayOfInt[i]))
          {
            QLog.w("cmshow_scripted_SpriteRscBuilder", 2, "checkThreeDressRsc rsc NOT exist, id:" + paramArrayOfInt[i]);
            j = 1;
          }
        }
        else
        {
          if (j == 0) {
            break;
          }
          c(paramQQAppInterface, paramString, paramInt, paramArrayOfInt, paramNotifyDressReady);
          return;
        }
        i += 1;
      }
    } while (paramNotifyDressReady == null);
    paramNotifyDressReady.a(-1L, paramQQAppInterface, paramString, "", "", paramInt, paramArrayOfInt, 10);
  }
  
  /* Error */
  private JSONArray c(SpriteTaskParam paramSpriteTaskParam)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +10 -> 11
    //   4: aload_0
    //   5: getfield 43	com/tencent/mobileqq/apollo/script/SpriteRscBuilder:jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext	Lcom/tencent/mobileqq/apollo/script/SpriteContext;
    //   8: ifnonnull +7 -> 15
    //   11: aconst_null
    //   12: astore_1
    //   13: aload_1
    //   14: areturn
    //   15: invokestatic 393	java/lang/System:currentTimeMillis	()J
    //   18: lstore_2
    //   19: new 162	org/json/JSONArray
    //   22: dup
    //   23: invokespecial 394	org/json/JSONArray:<init>	()V
    //   26: astore 6
    //   28: aload_0
    //   29: getfield 43	com/tencent/mobileqq/apollo/script/SpriteRscBuilder:jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext	Lcom/tencent/mobileqq/apollo/script/SpriteContext;
    //   32: getfield 400	com/tencent/mobileqq/apollo/script/SpriteContext:jdField_a_of_type_Int	I
    //   35: iconst_1
    //   36: invokestatic 404	com/tencent/mobileqq/apollo/api/aio/CmShowAioMatcher:a	(II)Z
    //   39: ifeq +173 -> 212
    //   42: aload_0
    //   43: aload_0
    //   44: getfield 43	com/tencent/mobileqq/apollo/script/SpriteRscBuilder:jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext	Lcom/tencent/mobileqq/apollo/script/SpriteContext;
    //   47: getfield 641	com/tencent/mobileqq/apollo/script/SpriteContext:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   50: aload_0
    //   51: getfield 43	com/tencent/mobileqq/apollo/script/SpriteRscBuilder:jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext	Lcom/tencent/mobileqq/apollo/script/SpriteContext;
    //   54: iconst_1
    //   55: invokespecial 765	com/tencent/mobileqq/apollo/script/SpriteRscBuilder:b	(Ljava/lang/String;Lcom/tencent/mobileqq/apollo/script/SpriteContext;Z)Lorg/json/JSONObject;
    //   58: astore_1
    //   59: aload_0
    //   60: aload_0
    //   61: getfield 43	com/tencent/mobileqq/apollo/script/SpriteRscBuilder:jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext	Lcom/tencent/mobileqq/apollo/script/SpriteContext;
    //   64: getfield 666	com/tencent/mobileqq/apollo/script/SpriteContext:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   67: aload_0
    //   68: getfield 43	com/tencent/mobileqq/apollo/script/SpriteRscBuilder:jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext	Lcom/tencent/mobileqq/apollo/script/SpriteContext;
    //   71: iconst_0
    //   72: invokespecial 765	com/tencent/mobileqq/apollo/script/SpriteRscBuilder:b	(Ljava/lang/String;Lcom/tencent/mobileqq/apollo/script/SpriteContext;Z)Lorg/json/JSONObject;
    //   75: astore 7
    //   77: aload_0
    //   78: getfield 43	com/tencent/mobileqq/apollo/script/SpriteRscBuilder:jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext	Lcom/tencent/mobileqq/apollo/script/SpriteContext;
    //   81: getfield 413	com/tencent/mobileqq/apollo/script/SpriteContext:jdField_c_of_type_Boolean	Z
    //   84: ifne +70 -> 154
    //   87: aload_0
    //   88: aload_0
    //   89: getfield 43	com/tencent/mobileqq/apollo/script/SpriteRscBuilder:jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext	Lcom/tencent/mobileqq/apollo/script/SpriteContext;
    //   92: getfield 641	com/tencent/mobileqq/apollo/script/SpriteContext:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   95: aload_0
    //   96: getfield 43	com/tencent/mobileqq/apollo/script/SpriteRscBuilder:jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext	Lcom/tencent/mobileqq/apollo/script/SpriteContext;
    //   99: iconst_1
    //   100: invokevirtual 416	com/tencent/mobileqq/apollo/script/SpriteRscBuilder:a	(Ljava/lang/String;Lcom/tencent/mobileqq/apollo/script/SpriteContext;Z)Lorg/json/JSONObject;
    //   103: astore 8
    //   105: aload_0
    //   106: aload_0
    //   107: getfield 43	com/tencent/mobileqq/apollo/script/SpriteRscBuilder:jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext	Lcom/tencent/mobileqq/apollo/script/SpriteContext;
    //   110: getfield 666	com/tencent/mobileqq/apollo/script/SpriteContext:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   113: aload_0
    //   114: getfield 43	com/tencent/mobileqq/apollo/script/SpriteRscBuilder:jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext	Lcom/tencent/mobileqq/apollo/script/SpriteContext;
    //   117: iconst_0
    //   118: invokevirtual 416	com/tencent/mobileqq/apollo/script/SpriteRscBuilder:a	(Ljava/lang/String;Lcom/tencent/mobileqq/apollo/script/SpriteContext;Z)Lorg/json/JSONObject;
    //   121: astore 9
    //   123: aload 8
    //   125: ifnull +13 -> 138
    //   128: aload_1
    //   129: ldc_w 418
    //   132: aload 8
    //   134: invokevirtual 421	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   137: pop
    //   138: aload 9
    //   140: ifnull +14 -> 154
    //   143: aload 7
    //   145: ldc_w 418
    //   148: aload 9
    //   150: invokevirtual 421	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   153: pop
    //   154: aload 6
    //   156: aload_1
    //   157: invokevirtual 411	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   160: pop
    //   161: aload 6
    //   163: aload 7
    //   165: invokevirtual 411	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   168: pop
    //   169: invokestatic 393	java/lang/System:currentTimeMillis	()J
    //   172: lstore 4
    //   174: aload 6
    //   176: astore_1
    //   177: invokestatic 67	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   180: ifeq -167 -> 13
    //   183: ldc 69
    //   185: iconst_2
    //   186: iconst_2
    //   187: anewarray 4	java/lang/Object
    //   190: dup
    //   191: iconst_0
    //   192: ldc_w 767
    //   195: aastore
    //   196: dup
    //   197: iconst_1
    //   198: lload 4
    //   200: lload_2
    //   201: lsub
    //   202: invokestatic 428	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   205: aastore
    //   206: invokestatic 80	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   209: aload 6
    //   211: areturn
    //   212: aload_0
    //   213: aload_1
    //   214: getfield 396	com/tencent/mobileqq/apollo/api/script/SpriteTaskParam:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   217: aload_0
    //   218: getfield 43	com/tencent/mobileqq/apollo/script/SpriteRscBuilder:jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext	Lcom/tencent/mobileqq/apollo/script/SpriteContext;
    //   221: iconst_1
    //   222: invokespecial 765	com/tencent/mobileqq/apollo/script/SpriteRscBuilder:b	(Ljava/lang/String;Lcom/tencent/mobileqq/apollo/script/SpriteContext;Z)Lorg/json/JSONObject;
    //   225: astore_1
    //   226: aload_0
    //   227: getfield 43	com/tencent/mobileqq/apollo/script/SpriteRscBuilder:jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext	Lcom/tencent/mobileqq/apollo/script/SpriteContext;
    //   230: getfield 413	com/tencent/mobileqq/apollo/script/SpriteContext:jdField_c_of_type_Boolean	Z
    //   233: ifne +36 -> 269
    //   236: aload_0
    //   237: aload_0
    //   238: getfield 43	com/tencent/mobileqq/apollo/script/SpriteRscBuilder:jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext	Lcom/tencent/mobileqq/apollo/script/SpriteContext;
    //   241: getfield 641	com/tencent/mobileqq/apollo/script/SpriteContext:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   244: aload_0
    //   245: getfield 43	com/tencent/mobileqq/apollo/script/SpriteRscBuilder:jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext	Lcom/tencent/mobileqq/apollo/script/SpriteContext;
    //   248: iconst_1
    //   249: invokevirtual 416	com/tencent/mobileqq/apollo/script/SpriteRscBuilder:a	(Ljava/lang/String;Lcom/tencent/mobileqq/apollo/script/SpriteContext;Z)Lorg/json/JSONObject;
    //   252: astore 7
    //   254: aload 7
    //   256: ifnull +13 -> 269
    //   259: aload_1
    //   260: ldc_w 418
    //   263: aload 7
    //   265: invokevirtual 421	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   268: pop
    //   269: aload 6
    //   271: aload_1
    //   272: invokevirtual 411	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   275: pop
    //   276: goto -107 -> 169
    //   279: astore_1
    //   280: ldc 69
    //   282: iconst_1
    //   283: ldc_w 769
    //   286: aload_1
    //   287: invokestatic 252	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   290: invokestatic 393	java/lang/System:currentTimeMillis	()J
    //   293: lstore 4
    //   295: invokestatic 67	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   298: ifeq +29 -> 327
    //   301: ldc 69
    //   303: iconst_2
    //   304: iconst_2
    //   305: anewarray 4	java/lang/Object
    //   308: dup
    //   309: iconst_0
    //   310: ldc_w 767
    //   313: aastore
    //   314: dup
    //   315: iconst_1
    //   316: lload 4
    //   318: lload_2
    //   319: lsub
    //   320: invokestatic 428	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   323: aastore
    //   324: invokestatic 80	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   327: aconst_null
    //   328: areturn
    //   329: astore_1
    //   330: invokestatic 393	java/lang/System:currentTimeMillis	()J
    //   333: lstore 4
    //   335: invokestatic 67	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   338: ifeq +29 -> 367
    //   341: ldc 69
    //   343: iconst_2
    //   344: iconst_2
    //   345: anewarray 4	java/lang/Object
    //   348: dup
    //   349: iconst_0
    //   350: ldc_w 767
    //   353: aastore
    //   354: dup
    //   355: iconst_1
    //   356: lload 4
    //   358: lload_2
    //   359: lsub
    //   360: invokestatic 428	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   363: aastore
    //   364: invokestatic 80	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   367: aload_1
    //   368: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	369	0	this	SpriteRscBuilder
    //   0	369	1	paramSpriteTaskParam	SpriteTaskParam
    //   18	341	2	l1	long
    //   172	185	4	l2	long
    //   26	244	6	localJSONArray	JSONArray
    //   75	189	7	localJSONObject1	JSONObject
    //   103	30	8	localJSONObject2	JSONObject
    //   121	28	9	localJSONObject3	JSONObject
    // Exception table:
    //   from	to	target	type
    //   19	123	279	java/lang/Throwable
    //   128	138	279	java/lang/Throwable
    //   143	154	279	java/lang/Throwable
    //   154	169	279	java/lang/Throwable
    //   212	254	279	java/lang/Throwable
    //   259	269	279	java/lang/Throwable
    //   269	276	279	java/lang/Throwable
    //   19	123	329	finally
    //   128	138	329	finally
    //   143	154	329	finally
    //   154	169	329	finally
    //   212	254	329	finally
    //   259	269	329	finally
    //   269	276	329	finally
    //   280	290	329	finally
  }
  
  public static void c(QQAppInterface paramQQAppInterface, String paramString, int paramInt, int[] paramArrayOfInt, ApolloGameBasicEventUtil.NotifyDressReady paramNotifyDressReady)
  {
    if ((ApolloActionHelperImpl.isRscValid(paramString, paramInt, paramArrayOfInt, paramQQAppInterface, new SpriteRscBuilder.4(paramNotifyDressReady, paramQQAppInterface, paramInt, paramArrayOfInt))) && (paramNotifyDressReady != null)) {
      paramNotifyDressReady.a(-1L, paramQQAppInterface, paramString, "", "", paramInt, paramArrayOfInt, 22);
    }
  }
  
  private boolean c(SpriteTaskParam paramSpriteTaskParam)
  {
    ApolloManagerServiceImpl localApolloManagerServiceImpl = (ApolloManagerServiceImpl)this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a().getRuntimeService(IApolloManagerService.class, "all");
    ApolloActionData localApolloActionData = ((ApolloDaoManagerServiceImpl)this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a().getRuntimeService(IApolloDaoManagerService.class, "all")).findActionById(paramSpriteTaskParam.f);
    if (localApolloActionData == null)
    {
      QLog.i("cmshow_scripted_SpriteRscBuilder", 1, "downloadIfActionPanelFrameNotExist warning: data is null. call checkApolloPanelJsonVer, id:" + paramSpriteTaskParam.f);
      ApolloContentUpdateHandler.a(this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a(), 1);
      return false;
    }
    if (!ApolloUtilImpl.isActionPanelFrameResDone(paramSpriteTaskParam.f, localApolloActionData.personNum)) {
      return localApolloManagerServiceImpl.downloadApolloRes(localApolloActionData, 4, null);
    }
    return true;
  }
  
  public Pair<String, Integer> a(String paramString)
  {
    int i = 2;
    Object localObject = new Pair("def/basic/action/4/action/action", Integer.valueOf(0));
    if (TextUtils.isEmpty(paramString)) {
      return localObject;
    }
    StringBuilder localStringBuilder;
    if ((((IApolloManagerService)this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a().getRuntimeService(IApolloManagerService.class, "all")).getCmShowStatus(this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a(), paramString) != 2) && (a(this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a(), paramString)))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.jdField_b_of_type_Int).append("/action/action");
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
        if (QLog.isColorLevel()) {
          QLog.d("cmshow_scripted_SpriteRscBuilder", 2, new Object[] { "getSpriteShowPath stand:", Integer.valueOf(this.jdField_a_of_type_Int), ", uin:", ((IApolloUtil)QRoute.api(IApolloUtil.class)).wrapLogUin(paramString) });
        }
        if (this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.jdField_a_of_type_Int == 3000)
        {
          label328:
          VipUtils.a(null, "cmshow", "Apollo", "appearanceaction", i, this.jdField_a_of_type_Int, new String[] { String.valueOf(this.jdField_b_of_type_Int) });
          if (this.jdField_a_of_type_Int != 4) {
            break label431;
          }
        }
        break;
      }
    }
    label431:
    for (i = 7;; i = 0)
    {
      return new Pair(localStringBuilder.toString(), Integer.valueOf(i));
      localObject = HardCodeUtil.a(2131714203);
      break;
      localObject = HardCodeUtil.a(2131714207);
      break;
      localObject = HardCodeUtil.a(2131714201);
      break;
      i = this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.jdField_a_of_type_Int;
      break label328;
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
      Object localObject = (IApolloManagerService)this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a().getRuntimeService(IApolloManagerService.class, "all");
      JSONObject localJSONObject2;
      if (CmShowAioMatcher.a(this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.jdField_a_of_type_Int, 1))
      {
        localJSONObject2 = b(this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext, true);
        JSONObject localJSONObject3 = b(this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext, false);
        if ((((IApolloManagerService)localObject).getCmShowStatus(this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a(), this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.jdField_b_of_type_JavaLangString) != 2) && (!this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.jdField_c_of_type_Boolean))
        {
          JSONObject localJSONObject4 = a(this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext, true);
          if (localJSONObject4 != null) {
            localJSONObject2.put("pet", localJSONObject4);
          }
        }
        if ((((IApolloManagerService)localObject).getCmShowStatus(this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a(), this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.jdField_a_of_type_JavaLangString) != 2) && (!this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.jdField_c_of_type_Boolean))
        {
          localObject = a(this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext, false);
          if (localObject != null) {
            localJSONObject3.put("pet", localObject);
          }
        }
        localJSONArray.put(localJSONObject2);
        localJSONArray.put(localJSONObject3);
      }
      for (;;)
      {
        localJSONObject1.put("sprites", localJSONArray);
        return localJSONObject1.toString();
        localJSONObject2 = b(this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext, true);
        if ((((IApolloManagerService)localObject).getCmShowStatus(this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a(), this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.jdField_b_of_type_JavaLangString) != 2) && (!this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.jdField_c_of_type_Boolean))
        {
          localObject = a(this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext, true);
          if (localObject != null) {
            localJSONObject2.put("pet", localObject);
          }
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
    localObject = (ApolloManagerServiceImpl)this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a().getRuntimeService(IApolloManagerService.class, "all");
    if (TextUtils.isEmpty(((ApolloManagerServiceImpl)localObject).mPetConfig)) {
      return null;
    }
    for (;;)
    {
      try
      {
        JSONArray localJSONArray = new JSONArray(((ApolloManagerServiceImpl)localObject).mPetConfig);
        int j = localJSONArray.length();
        if (i < j)
        {
          JSONObject localJSONObject = localJSONArray.getJSONObject(i);
          int k = localJSONObject.optInt("roleId", -1);
          if ((k == -1) || (k != paramInt)) {
            continue;
          }
          paramInt = localJSONObject.getInt(paramString);
          if (ApolloUtilImpl.isActionResDone(paramInt, 0)) {
            return paramInt + "/action/action";
          }
          QLog.e("ApolloPet", 1, "getPetBasicActions download action:" + paramInt);
          paramString = new ApolloActionData();
          paramString.actionId = paramInt;
          ((ApolloManagerServiceImpl)localObject).downloadApolloRes(paramString, 4, null);
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
    paramSpriteTaskParam = a(paramSpriteTaskParam);
    if (paramSpriteTaskParam != null) {
      return paramSpriteTaskParam.toString();
    }
    return null;
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
            break label217;
          }
          if (ApolloUtilImpl.isActionResDone(k, 0)) {
            break label186;
          }
          QLog.e("ApolloPet", 1, "getPetActions download:" + k);
          Object localObject = new ApolloActionData();
          ((ApolloActionData)localObject).actionId = k;
          String str = ApolloUtilImpl.getApolloResPath((ApolloActionData)localObject, 5);
          localObject = ApolloUtilImpl.getApolloResPath((ApolloActionData)localObject, 4);
          ((IApolloResDownloader)QRoute.api(IApolloResDownloader.class)).downLoadSpecialAction(this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a(), (String)localObject, str);
        }
        catch (Exception paramJSONArray)
        {
          QLog.e("ApolloPet", 1, "getPetActions error:", paramJSONArray);
        }
      } else {
        return localJSONArray;
      }
      label186:
      localStringBuilder.setLength(0);
      localStringBuilder.append(k).append("/action/action");
      localJSONArray.put(localStringBuilder.toString());
      label217:
      i += 1;
    }
  }
  
  public JSONObject a(SpriteTaskParam paramSpriteTaskParam)
  {
    int j = 0;
    if ((paramSpriteTaskParam == null) || (this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext == null)) {
      return null;
    }
    for (;;)
    {
      JSONObject localJSONObject;
      Object localObject;
      int i;
      try
      {
        localJSONObject = new JSONObject();
        if (this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.e == 0)
        {
          localObject = ApolloActionData.getModelString(paramSpriteTaskParam.f);
          localJSONObject.put("model", localObject);
          localJSONObject.put("actionId", paramSpriteTaskParam.f);
          localJSONObject.put("taskId", paramSpriteTaskParam.jdField_a_of_type_Int);
          localJSONObject.put("actionType", paramSpriteTaskParam.jdField_c_of_type_Int);
          localJSONObject.put("from", paramSpriteTaskParam.g);
          if (!SpriteUtil.a(this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a())) {
            break label373;
          }
          i = 1;
          localJSONObject.put("isHide", i);
          i = j;
          if (paramSpriteTaskParam.jdField_a_of_type_Boolean) {
            i = 1;
          }
          localJSONObject.put("isSender", i);
          if (paramSpriteTaskParam.jdField_c_of_type_Int != 1) {
            break label347;
          }
          localObject = c(paramSpriteTaskParam);
          JSONArray localJSONArray = b(paramSpriteTaskParam);
          localJSONObject.put("sprites", localObject);
          localJSONObject.put("actions", localJSONArray);
          localObject = b(paramSpriteTaskParam);
          if (localObject != null) {
            localJSONObject.put("audio", localObject);
          }
          if (!TextUtils.isEmpty(paramSpriteTaskParam.jdField_d_of_type_JavaLangString)) {
            localJSONObject.put("extraMsg", new JSONObject(paramSpriteTaskParam.jdField_d_of_type_JavaLangString));
          }
          localJSONObject.put("needRecordFrame", paramSpriteTaskParam.jdField_c_of_type_Boolean);
          localJSONObject.put("frameTime", paramSpriteTaskParam.jdField_b_of_type_Float);
          return localJSONObject;
        }
      }
      catch (Throwable paramSpriteTaskParam)
      {
        QLog.e("cmshow_scripted_SpriteRscBuilder", 1, "[getActionJsParamJSON],", paramSpriteTaskParam);
        return null;
      }
      if (paramSpriteTaskParam.f > 0)
      {
        localObject = ApolloActionData.getModelString(paramSpriteTaskParam.f);
      }
      else if (paramSpriteTaskParam.k == 14)
      {
        localObject = "3D";
      }
      else
      {
        localObject = ApolloActionHelperImpl.getModelByUin(paramSpriteTaskParam.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a());
        continue;
        label347:
        localObject = a(paramSpriteTaskParam);
        if (localObject != null)
        {
          localJSONObject.put("sprites", localObject);
          continue;
          label373:
          i = 0;
        }
      }
    }
  }
  
  /* Error */
  public JSONObject a(String paramString, SpriteContext paramSpriteContext, boolean paramBoolean)
  {
    // Byte code:
    //   0: new 177	org/json/JSONObject
    //   3: dup
    //   4: invokespecial 472	org/json/JSONObject:<init>	()V
    //   7: astore 14
    //   9: iconst_1
    //   10: istore 11
    //   12: iconst_1
    //   13: istore 12
    //   15: iconst_1
    //   16: istore 6
    //   18: iconst_m1
    //   19: istore 5
    //   21: new 739	java/util/ArrayList
    //   24: dup
    //   25: invokespecial 919	java/util/ArrayList:<init>	()V
    //   28: astore 15
    //   30: aload_2
    //   31: invokevirtual 144	com/tencent/mobileqq/apollo/script/SpriteContext:a	()Lcom/tencent/mobileqq/app/QQAppInterface;
    //   34: pop
    //   35: aload_0
    //   36: getfield 43	com/tencent/mobileqq/apollo/script/SpriteRscBuilder:jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext	Lcom/tencent/mobileqq/apollo/script/SpriteContext;
    //   39: invokevirtual 144	com/tencent/mobileqq/apollo/script/SpriteContext:a	()Lcom/tencent/mobileqq/app/QQAppInterface;
    //   42: ldc 146
    //   44: ldc 148
    //   46: invokevirtual 154	com/tencent/mobileqq/app/QQAppInterface:getRuntimeService	(Ljava/lang/Class;Ljava/lang/String;)Lmqq/app/api/IRuntimeService;
    //   49: checkcast 156	com/tencent/mobileqq/apollo/api/impl/ApolloManagerServiceImpl
    //   52: astore 13
    //   54: iload 11
    //   56: istore 7
    //   58: iload 5
    //   60: istore 9
    //   62: iload 12
    //   64: istore 8
    //   66: iload 5
    //   68: istore 10
    //   70: aload 13
    //   72: aload_1
    //   73: invokevirtual 187	com/tencent/mobileqq/apollo/api/impl/ApolloManagerServiceImpl:getApolloBaseInfo	(Ljava/lang/String;)Lcom/tencent/mobileqq/apollo/api/model/ApolloBaseInfo;
    //   76: astore 16
    //   78: aload 16
    //   80: ifnonnull +5 -> 85
    //   83: aconst_null
    //   84: areturn
    //   85: iload 11
    //   87: istore 7
    //   89: iload 5
    //   91: istore 9
    //   93: iload 12
    //   95: istore 8
    //   97: iload 5
    //   99: istore 10
    //   101: aload 16
    //   103: invokevirtual 923	com/tencent/mobileqq/apollo/api/model/ApolloBaseInfo:getApolloPetDress	()Lcom/tencent/mobileqq/apollo/api/model/ApolloDress;
    //   106: astore 17
    //   108: aload 17
    //   110: ifnull +999 -> 1109
    //   113: iload 11
    //   115: istore 7
    //   117: iload 5
    //   119: istore 9
    //   121: iload 12
    //   123: istore 8
    //   125: iload 5
    //   127: istore 10
    //   129: aload 16
    //   131: getfield 193	com/tencent/mobileqq/apollo/api/model/ApolloBaseInfo:hasPet	Z
    //   134: ifeq +975 -> 1109
    //   137: iload 11
    //   139: istore 7
    //   141: iload 5
    //   143: istore 9
    //   145: iload 12
    //   147: istore 8
    //   149: iload 5
    //   151: istore 10
    //   153: aload 17
    //   155: getfield 929	com/tencent/mobileqq/apollo/api/model/ApolloDress:dressMap	Ljava/util/HashMap;
    //   158: ifnull +951 -> 1109
    //   161: iload 11
    //   163: istore 7
    //   165: iload 5
    //   167: istore 9
    //   169: iload 12
    //   171: istore 8
    //   173: iload 5
    //   175: istore 10
    //   177: aload 17
    //   179: getfield 929	com/tencent/mobileqq/apollo/api/model/ApolloDress:dressMap	Ljava/util/HashMap;
    //   182: invokevirtual 931	java/util/HashMap:isEmpty	()Z
    //   185: ifne +924 -> 1109
    //   188: iload 11
    //   190: istore 7
    //   192: iload 5
    //   194: istore 9
    //   196: iload 12
    //   198: istore 8
    //   200: iload 5
    //   202: istore 10
    //   204: aload 14
    //   206: ldc_w 636
    //   209: iconst_0
    //   210: aload 17
    //   212: getfield 933	com/tencent/mobileqq/apollo/api/model/ApolloDress:roleId	I
    //   215: invokestatic 632	com/tencent/mobileqq/apollo/api/uitls/impl/ApolloActionHelperImpl:getApolloRsc	(II)Ljava/lang/String;
    //   218: invokevirtual 421	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   221: pop
    //   222: iload 5
    //   224: istore 4
    //   226: iload 11
    //   228: istore 7
    //   230: iload 5
    //   232: istore 9
    //   234: iload 12
    //   236: istore 8
    //   238: iload 5
    //   240: istore 10
    //   242: iconst_1
    //   243: aload 17
    //   245: getfield 933	com/tencent/mobileqq/apollo/api/model/ApolloDress:roleId	I
    //   248: invokestatic 936	com/tencent/mobileqq/apollo/api/uitls/impl/ApolloUtilImpl:isResourceDone	(II)Z
    //   251: ifne +27 -> 278
    //   254: iconst_0
    //   255: istore 7
    //   257: iconst_0
    //   258: istore 8
    //   260: iconst_0
    //   261: istore 6
    //   263: iload 5
    //   265: istore 9
    //   267: iload 5
    //   269: istore 10
    //   271: aload 17
    //   273: getfield 933	com/tencent/mobileqq/apollo/api/model/ApolloDress:roleId	I
    //   276: istore 4
    //   278: iload 6
    //   280: istore 7
    //   282: iload 4
    //   284: istore 9
    //   286: iload 6
    //   288: istore 8
    //   290: iload 4
    //   292: istore 10
    //   294: aload 17
    //   296: getfield 929	com/tencent/mobileqq/apollo/api/model/ApolloDress:dressMap	Ljava/util/HashMap;
    //   299: invokevirtual 937	java/util/HashMap:size	()I
    //   302: newarray int
    //   304: astore 18
    //   306: iload 6
    //   308: istore 7
    //   310: iload 4
    //   312: istore 9
    //   314: iload 6
    //   316: istore 8
    //   318: iload 4
    //   320: istore 10
    //   322: aload 17
    //   324: getfield 929	com/tencent/mobileqq/apollo/api/model/ApolloDress:dressMap	Ljava/util/HashMap;
    //   327: invokevirtual 941	java/util/HashMap:entrySet	()Ljava/util/Set;
    //   330: invokeinterface 947 1 0
    //   335: astore 19
    //   337: iconst_0
    //   338: istore 5
    //   340: iload 6
    //   342: istore 7
    //   344: iload 4
    //   346: istore 9
    //   348: iload 6
    //   350: istore 8
    //   352: iload 4
    //   354: istore 10
    //   356: aload 19
    //   358: invokeinterface 952 1 0
    //   363: ifeq +54 -> 417
    //   366: iload 6
    //   368: istore 7
    //   370: iload 4
    //   372: istore 9
    //   374: iload 6
    //   376: istore 8
    //   378: iload 4
    //   380: istore 10
    //   382: aload 18
    //   384: iload 5
    //   386: aload 19
    //   388: invokeinterface 956 1 0
    //   393: checkcast 958	java/util/Map$Entry
    //   396: invokeinterface 961 1 0
    //   401: checkcast 73	java/lang/Integer
    //   404: invokevirtual 139	java/lang/Integer:intValue	()I
    //   407: iastore
    //   408: iload 5
    //   410: iconst_1
    //   411: iadd
    //   412: istore 5
    //   414: goto -74 -> 340
    //   417: iload 6
    //   419: istore 7
    //   421: iload 4
    //   423: istore 9
    //   425: iload 6
    //   427: istore 8
    //   429: iload 4
    //   431: istore 10
    //   433: new 162	org/json/JSONArray
    //   436: dup
    //   437: invokespecial 394	org/json/JSONArray:<init>	()V
    //   440: astore 19
    //   442: iload 6
    //   444: istore 7
    //   446: iload 4
    //   448: istore 9
    //   450: iload 6
    //   452: istore 8
    //   454: iload 4
    //   456: istore 10
    //   458: aload 18
    //   460: arraylength
    //   461: istore 11
    //   463: iload 6
    //   465: istore 5
    //   467: iconst_0
    //   468: istore 8
    //   470: iload 8
    //   472: iload 11
    //   474: if_icmpge +72 -> 546
    //   477: aload 18
    //   479: iload 8
    //   481: iaload
    //   482: istore 9
    //   484: iload 5
    //   486: istore 6
    //   488: iload 5
    //   490: istore 7
    //   492: aload 19
    //   494: iconst_1
    //   495: iload 9
    //   497: invokestatic 632	com/tencent/mobileqq/apollo/api/uitls/impl/ApolloActionHelperImpl:getApolloRsc	(II)Ljava/lang/String;
    //   500: invokevirtual 411	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   503: pop
    //   504: iload 5
    //   506: istore 6
    //   508: iload 5
    //   510: istore 7
    //   512: iconst_2
    //   513: iload 9
    //   515: invokestatic 936	com/tencent/mobileqq/apollo/api/uitls/impl/ApolloUtilImpl:isResourceDone	(II)Z
    //   518: ifne +970 -> 1488
    //   521: iconst_0
    //   522: istore 7
    //   524: iconst_0
    //   525: istore 5
    //   527: iconst_0
    //   528: istore 6
    //   530: aload 15
    //   532: iload 9
    //   534: invokestatic 77	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   537: invokeinterface 966 2 0
    //   542: pop
    //   543: goto +945 -> 1488
    //   546: iload 5
    //   548: istore 6
    //   550: iload 5
    //   552: istore 7
    //   554: aload 14
    //   556: ldc_w 634
    //   559: aload 19
    //   561: invokevirtual 421	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   564: pop
    //   565: iload 5
    //   567: istore 6
    //   569: iload 5
    //   571: istore 7
    //   573: aload 14
    //   575: ldc_w 334
    //   578: aload 17
    //   580: getfield 933	com/tencent/mobileqq/apollo/api/model/ApolloDress:roleId	I
    //   583: invokevirtual 479	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   586: pop
    //   587: iload 5
    //   589: istore 6
    //   591: iload 5
    //   593: istore 7
    //   595: aload_0
    //   596: aload 17
    //   598: getfield 933	com/tencent/mobileqq/apollo/api/model/ApolloDress:roleId	I
    //   601: ldc_w 968
    //   604: invokevirtual 970	com/tencent/mobileqq/apollo/script/SpriteRscBuilder:a	(ILjava/lang/String;)Ljava/lang/String;
    //   607: astore 18
    //   609: iload 5
    //   611: istore 6
    //   613: iload 5
    //   615: istore 7
    //   617: aload_0
    //   618: aload 17
    //   620: getfield 933	com/tencent/mobileqq/apollo/api/model/ApolloDress:roleId	I
    //   623: ldc_w 972
    //   626: invokevirtual 970	com/tencent/mobileqq/apollo/script/SpriteRscBuilder:a	(ILjava/lang/String;)Ljava/lang/String;
    //   629: astore 19
    //   631: iload 5
    //   633: istore 6
    //   635: iload 5
    //   637: istore 7
    //   639: aload 18
    //   641: invokestatic 50	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   644: ifne +57 -> 701
    //   647: iload 5
    //   649: istore 6
    //   651: iload 5
    //   653: istore 7
    //   655: aload 19
    //   657: invokestatic 50	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   660: ifne +41 -> 701
    //   663: iload 5
    //   665: istore 6
    //   667: iload 5
    //   669: istore 7
    //   671: aload 14
    //   673: ldc_w 974
    //   676: aload 19
    //   678: invokevirtual 421	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   681: pop
    //   682: iload 5
    //   684: istore 6
    //   686: iload 5
    //   688: istore 7
    //   690: aload 14
    //   692: ldc_w 976
    //   695: aload 18
    //   697: invokevirtual 421	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   700: pop
    //   701: iload 5
    //   703: istore 6
    //   705: iload 5
    //   707: istore 7
    //   709: aload_0
    //   710: aload 17
    //   712: getfield 933	com/tencent/mobileqq/apollo/api/model/ApolloDress:roleId	I
    //   715: invokespecial 977	com/tencent/mobileqq/apollo/script/SpriteRscBuilder:a	(I)Ljava/lang/String;
    //   718: astore 18
    //   720: iload 5
    //   722: istore 6
    //   724: iload 5
    //   726: istore 7
    //   728: aload 18
    //   730: invokestatic 50	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   733: ifne +22 -> 755
    //   736: iload 5
    //   738: istore 6
    //   740: iload 5
    //   742: istore 7
    //   744: aload 14
    //   746: ldc_w 979
    //   749: aload 18
    //   751: invokevirtual 421	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   754: pop
    //   755: iload 5
    //   757: istore 6
    //   759: iload 5
    //   761: istore 7
    //   763: aload 16
    //   765: getfield 982	com/tencent/mobileqq/apollo/api/model/ApolloBaseInfo:petNick	Ljava/lang/String;
    //   768: invokestatic 50	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   771: ifne +53 -> 824
    //   774: iload 5
    //   776: istore 6
    //   778: iload 5
    //   780: istore 7
    //   782: aload_2
    //   783: getfield 872	com/tencent/mobileqq/apollo/script/SpriteContext:e	I
    //   786: ifne +38 -> 824
    //   789: iload 5
    //   791: istore 6
    //   793: iload 5
    //   795: istore 7
    //   797: aload 14
    //   799: ldc_w 648
    //   802: aload 16
    //   804: getfield 982	com/tencent/mobileqq/apollo/api/model/ApolloBaseInfo:petNick	Ljava/lang/String;
    //   807: ldc_w 577
    //   810: invokevirtual 581	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   813: iconst_0
    //   814: invokestatic 587	com/tencent/mobileqq/utils/Base64Util:encodeToString	([BI)Ljava/lang/String;
    //   817: invokestatic 589	com/tencent/mobileqq/apollo/script/SpriteUtil:a	(Ljava/lang/String;)Ljava/lang/String;
    //   820: invokevirtual 421	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   823: pop
    //   824: iload 5
    //   826: istore 6
    //   828: iload 5
    //   830: istore 7
    //   832: aload 14
    //   834: ldc_w 638
    //   837: aload 13
    //   839: getfield 854	com/tencent/mobileqq/apollo/api/impl/ApolloManagerServiceImpl:mPetConfig	Ljava/lang/String;
    //   842: aload 17
    //   844: getfield 933	com/tencent/mobileqq/apollo/api/model/ApolloDress:roleId	I
    //   847: iload_3
    //   848: invokestatic 984	com/tencent/mobileqq/apollo/script/SpriteRscBuilder:a	(Ljava/lang/String;IZ)Ljava/lang/String;
    //   851: invokevirtual 421	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   854: pop
    //   855: iload 5
    //   857: istore 6
    //   859: iload 5
    //   861: istore 7
    //   863: aload_0
    //   864: getfield 43	com/tencent/mobileqq/apollo/script/SpriteRscBuilder:jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext	Lcom/tencent/mobileqq/apollo/script/SpriteContext;
    //   867: getfield 651	com/tencent/mobileqq/apollo/script/SpriteContext:jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloRoleInfo	Lcom/tencent/mobileqq/apollo/api/model/ApolloRoleInfo;
    //   870: ifnull +87 -> 957
    //   873: iload 5
    //   875: istore 6
    //   877: iload 5
    //   879: istore 7
    //   881: aload 14
    //   883: ldc_w 653
    //   886: aload_0
    //   887: getfield 43	com/tencent/mobileqq/apollo/script/SpriteRscBuilder:jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext	Lcom/tencent/mobileqq/apollo/script/SpriteContext;
    //   890: getfield 651	com/tencent/mobileqq/apollo/script/SpriteContext:jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloRoleInfo	Lcom/tencent/mobileqq/apollo/api/model/ApolloRoleInfo;
    //   893: getfield 657	com/tencent/mobileqq/apollo/api/model/ApolloRoleInfo:scale	F
    //   896: f2d
    //   897: invokevirtual 525	org/json/JSONObject:put	(Ljava/lang/String;D)Lorg/json/JSONObject;
    //   900: pop
    //   901: iload 5
    //   903: istore 6
    //   905: iload 5
    //   907: istore 7
    //   909: aload 14
    //   911: ldc_w 659
    //   914: aload_0
    //   915: getfield 43	com/tencent/mobileqq/apollo/script/SpriteRscBuilder:jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext	Lcom/tencent/mobileqq/apollo/script/SpriteContext;
    //   918: getfield 651	com/tencent/mobileqq/apollo/script/SpriteContext:jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloRoleInfo	Lcom/tencent/mobileqq/apollo/api/model/ApolloRoleInfo;
    //   921: getfield 661	com/tencent/mobileqq/apollo/api/model/ApolloRoleInfo:xPos	F
    //   924: f2d
    //   925: invokevirtual 525	org/json/JSONObject:put	(Ljava/lang/String;D)Lorg/json/JSONObject;
    //   928: pop
    //   929: iload 5
    //   931: istore 6
    //   933: iload 5
    //   935: istore 7
    //   937: aload 14
    //   939: ldc_w 663
    //   942: aload_0
    //   943: getfield 43	com/tencent/mobileqq/apollo/script/SpriteRscBuilder:jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext	Lcom/tencent/mobileqq/apollo/script/SpriteContext;
    //   946: getfield 651	com/tencent/mobileqq/apollo/script/SpriteContext:jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloRoleInfo	Lcom/tencent/mobileqq/apollo/api/model/ApolloRoleInfo;
    //   949: getfield 665	com/tencent/mobileqq/apollo/api/model/ApolloRoleInfo:yPos	F
    //   952: f2d
    //   953: invokevirtual 525	org/json/JSONObject:put	(Ljava/lang/String;D)Lorg/json/JSONObject;
    //   956: pop
    //   957: iload 5
    //   959: ifeq +111 -> 1070
    //   962: iload 5
    //   964: ifne +521 -> 1485
    //   967: aload_2
    //   968: ifnull +517 -> 1485
    //   971: aload_2
    //   972: invokevirtual 144	com/tencent/mobileqq/apollo/script/SpriteContext:a	()Lcom/tencent/mobileqq/app/QQAppInterface;
    //   975: ifnull +510 -> 1485
    //   978: ldc_w 262
    //   981: iconst_1
    //   982: new 255	java/lang/StringBuilder
    //   985: dup
    //   986: invokespecial 256	java/lang/StringBuilder:<init>	()V
    //   989: ldc_w 986
    //   992: invokevirtual 268	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   995: aload_1
    //   996: invokevirtual 268	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   999: invokevirtual 275	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1002: invokestatic 384	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1005: aload 13
    //   1007: ifnull +478 -> 1485
    //   1010: aload 15
    //   1012: invokeinterface 987 1 0
    //   1017: newarray int
    //   1019: astore 16
    //   1021: aload 15
    //   1023: invokeinterface 988 1 0
    //   1028: astore 15
    //   1030: iconst_0
    //   1031: istore 5
    //   1033: aload 15
    //   1035: invokeinterface 952 1 0
    //   1040: ifeq +36 -> 1076
    //   1043: aload 16
    //   1045: iload 5
    //   1047: aload 15
    //   1049: invokeinterface 956 1 0
    //   1054: checkcast 73	java/lang/Integer
    //   1057: invokevirtual 139	java/lang/Integer:intValue	()I
    //   1060: iastore
    //   1061: iload 5
    //   1063: iconst_1
    //   1064: iadd
    //   1065: istore 5
    //   1067: goto -34 -> 1033
    //   1070: aconst_null
    //   1071: astore 14
    //   1073: goto -111 -> 962
    //   1076: ldc 233
    //   1078: invokestatic 239	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   1081: checkcast 233	com/tencent/mobileqq/apollo/api/res/IApolloResDownloader
    //   1084: aload_2
    //   1085: invokevirtual 144	com/tencent/mobileqq/apollo/script/SpriteContext:a	()Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1088: aload_1
    //   1089: aload 13
    //   1091: invokevirtual 992	com/tencent/mobileqq/apollo/api/impl/ApolloManagerServiceImpl:getResDownloadListener	()Lcom/tencent/mobileqq/apollo/api/res/IApolloResDownloader$OnApolloDownLoadListener;
    //   1094: iload 4
    //   1096: aload 16
    //   1098: iconst_m1
    //   1099: iconst_m1
    //   1100: iconst_1
    //   1101: invokeinterface 996 9 0
    //   1106: aload 14
    //   1108: areturn
    //   1109: aconst_null
    //   1110: areturn
    //   1111: astore 14
    //   1113: iconst_1
    //   1114: istore 6
    //   1116: aconst_null
    //   1117: astore 13
    //   1119: iload 5
    //   1121: istore 4
    //   1123: iload 6
    //   1125: istore 5
    //   1127: ldc 69
    //   1129: iconst_1
    //   1130: aload 14
    //   1132: iconst_0
    //   1133: anewarray 4	java/lang/Object
    //   1136: invokestatic 492	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   1139: iload 5
    //   1141: ifne +136 -> 1277
    //   1144: aload_2
    //   1145: ifnull +132 -> 1277
    //   1148: aload_2
    //   1149: invokevirtual 144	com/tencent/mobileqq/apollo/script/SpriteContext:a	()Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1152: ifnull +125 -> 1277
    //   1155: ldc_w 262
    //   1158: iconst_1
    //   1159: new 255	java/lang/StringBuilder
    //   1162: dup
    //   1163: invokespecial 256	java/lang/StringBuilder:<init>	()V
    //   1166: ldc_w 986
    //   1169: invokevirtual 268	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1172: aload_1
    //   1173: invokevirtual 268	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1176: invokevirtual 275	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1179: invokestatic 384	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1182: aload 13
    //   1184: ifnull +93 -> 1277
    //   1187: aload 15
    //   1189: invokeinterface 987 1 0
    //   1194: newarray int
    //   1196: astore 14
    //   1198: aload 15
    //   1200: invokeinterface 988 1 0
    //   1205: astore 15
    //   1207: iconst_0
    //   1208: istore 5
    //   1210: aload 15
    //   1212: invokeinterface 952 1 0
    //   1217: ifeq +30 -> 1247
    //   1220: aload 14
    //   1222: iload 5
    //   1224: aload 15
    //   1226: invokeinterface 956 1 0
    //   1231: checkcast 73	java/lang/Integer
    //   1234: invokevirtual 139	java/lang/Integer:intValue	()I
    //   1237: iastore
    //   1238: iload 5
    //   1240: iconst_1
    //   1241: iadd
    //   1242: istore 5
    //   1244: goto -34 -> 1210
    //   1247: ldc 233
    //   1249: invokestatic 239	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   1252: checkcast 233	com/tencent/mobileqq/apollo/api/res/IApolloResDownloader
    //   1255: aload_2
    //   1256: invokevirtual 144	com/tencent/mobileqq/apollo/script/SpriteContext:a	()Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1259: aload_1
    //   1260: aload 13
    //   1262: invokevirtual 992	com/tencent/mobileqq/apollo/api/impl/ApolloManagerServiceImpl:getResDownloadListener	()Lcom/tencent/mobileqq/apollo/api/res/IApolloResDownloader$OnApolloDownLoadListener;
    //   1265: iload 4
    //   1267: aload 14
    //   1269: iconst_m1
    //   1270: iconst_m1
    //   1271: iconst_1
    //   1272: invokeinterface 996 9 0
    //   1277: aconst_null
    //   1278: areturn
    //   1279: astore 14
    //   1281: iconst_1
    //   1282: istore 6
    //   1284: aconst_null
    //   1285: astore 13
    //   1287: iload 5
    //   1289: istore 4
    //   1291: iload 6
    //   1293: istore 5
    //   1295: iload 5
    //   1297: ifne +136 -> 1433
    //   1300: aload_2
    //   1301: ifnull +132 -> 1433
    //   1304: aload_2
    //   1305: invokevirtual 144	com/tencent/mobileqq/apollo/script/SpriteContext:a	()Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1308: ifnull +125 -> 1433
    //   1311: ldc_w 262
    //   1314: iconst_1
    //   1315: new 255	java/lang/StringBuilder
    //   1318: dup
    //   1319: invokespecial 256	java/lang/StringBuilder:<init>	()V
    //   1322: ldc_w 986
    //   1325: invokevirtual 268	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1328: aload_1
    //   1329: invokevirtual 268	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1332: invokevirtual 275	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1335: invokestatic 384	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1338: aload 13
    //   1340: ifnull +93 -> 1433
    //   1343: aload 15
    //   1345: invokeinterface 987 1 0
    //   1350: newarray int
    //   1352: astore 16
    //   1354: aload 15
    //   1356: invokeinterface 988 1 0
    //   1361: astore 15
    //   1363: iconst_0
    //   1364: istore 5
    //   1366: aload 15
    //   1368: invokeinterface 952 1 0
    //   1373: ifeq +30 -> 1403
    //   1376: aload 16
    //   1378: iload 5
    //   1380: aload 15
    //   1382: invokeinterface 956 1 0
    //   1387: checkcast 73	java/lang/Integer
    //   1390: invokevirtual 139	java/lang/Integer:intValue	()I
    //   1393: iastore
    //   1394: iload 5
    //   1396: iconst_1
    //   1397: iadd
    //   1398: istore 5
    //   1400: goto -34 -> 1366
    //   1403: ldc 233
    //   1405: invokestatic 239	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   1408: checkcast 233	com/tencent/mobileqq/apollo/api/res/IApolloResDownloader
    //   1411: aload_2
    //   1412: invokevirtual 144	com/tencent/mobileqq/apollo/script/SpriteContext:a	()Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1415: aload_1
    //   1416: aload 13
    //   1418: invokevirtual 992	com/tencent/mobileqq/apollo/api/impl/ApolloManagerServiceImpl:getResDownloadListener	()Lcom/tencent/mobileqq/apollo/api/res/IApolloResDownloader$OnApolloDownLoadListener;
    //   1421: iload 4
    //   1423: aload 16
    //   1425: iconst_m1
    //   1426: iconst_m1
    //   1427: iconst_1
    //   1428: invokeinterface 996 9 0
    //   1433: aload 14
    //   1435: athrow
    //   1436: astore 14
    //   1438: iload 7
    //   1440: istore 5
    //   1442: iload 9
    //   1444: istore 4
    //   1446: goto -151 -> 1295
    //   1449: astore 14
    //   1451: iload 6
    //   1453: istore 5
    //   1455: goto -160 -> 1295
    //   1458: astore 14
    //   1460: goto -165 -> 1295
    //   1463: astore 14
    //   1465: iload 8
    //   1467: istore 5
    //   1469: iload 10
    //   1471: istore 4
    //   1473: goto -346 -> 1127
    //   1476: astore 14
    //   1478: iload 7
    //   1480: istore 5
    //   1482: goto -355 -> 1127
    //   1485: aload 14
    //   1487: areturn
    //   1488: iload 8
    //   1490: iconst_1
    //   1491: iadd
    //   1492: istore 8
    //   1494: goto -1024 -> 470
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1497	0	this	SpriteRscBuilder
    //   0	1497	1	paramString	String
    //   0	1497	2	paramSpriteContext	SpriteContext
    //   0	1497	3	paramBoolean	boolean
    //   224	1248	4	i	int
    //   19	1462	5	j	int
    //   16	1436	6	k	int
    //   56	1423	7	m	int
    //   64	1429	8	n	int
    //   60	1383	9	i1	int
    //   68	1402	10	i2	int
    //   10	465	11	i3	int
    //   13	222	12	i4	int
    //   52	1365	13	localApolloManagerServiceImpl	ApolloManagerServiceImpl
    //   7	1100	14	localJSONObject	JSONObject
    //   1111	20	14	localThrowable1	Throwable
    //   1196	72	14	arrayOfInt	int[]
    //   1279	155	14	localObject1	Object
    //   1436	1	14	localObject2	Object
    //   1449	1	14	localObject3	Object
    //   1458	1	14	localObject4	Object
    //   1463	1	14	localThrowable2	Throwable
    //   1476	10	14	localThrowable3	Throwable
    //   28	1353	15	localObject5	Object
    //   76	1348	16	localObject6	Object
    //   106	737	17	localApolloDress	com.tencent.mobileqq.apollo.api.model.ApolloDress
    //   304	446	18	localObject7	Object
    //   335	342	19	localObject8	Object
    // Exception table:
    //   from	to	target	type
    //   30	54	1111	java/lang/Throwable
    //   30	54	1279	finally
    //   70	78	1436	finally
    //   101	108	1436	finally
    //   129	137	1436	finally
    //   153	161	1436	finally
    //   177	188	1436	finally
    //   204	222	1436	finally
    //   242	254	1436	finally
    //   271	278	1436	finally
    //   294	306	1436	finally
    //   322	337	1436	finally
    //   356	366	1436	finally
    //   382	408	1436	finally
    //   433	442	1436	finally
    //   458	463	1436	finally
    //   492	504	1449	finally
    //   512	521	1449	finally
    //   530	543	1449	finally
    //   554	565	1449	finally
    //   573	587	1449	finally
    //   595	609	1449	finally
    //   617	631	1449	finally
    //   639	647	1449	finally
    //   655	663	1449	finally
    //   671	682	1449	finally
    //   690	701	1449	finally
    //   709	720	1449	finally
    //   728	736	1449	finally
    //   744	755	1449	finally
    //   763	774	1449	finally
    //   782	789	1449	finally
    //   797	824	1449	finally
    //   832	855	1449	finally
    //   863	873	1449	finally
    //   881	901	1449	finally
    //   909	929	1449	finally
    //   937	957	1449	finally
    //   1127	1139	1458	finally
    //   70	78	1463	java/lang/Throwable
    //   101	108	1463	java/lang/Throwable
    //   129	137	1463	java/lang/Throwable
    //   153	161	1463	java/lang/Throwable
    //   177	188	1463	java/lang/Throwable
    //   204	222	1463	java/lang/Throwable
    //   242	254	1463	java/lang/Throwable
    //   271	278	1463	java/lang/Throwable
    //   294	306	1463	java/lang/Throwable
    //   322	337	1463	java/lang/Throwable
    //   356	366	1463	java/lang/Throwable
    //   382	408	1463	java/lang/Throwable
    //   433	442	1463	java/lang/Throwable
    //   458	463	1463	java/lang/Throwable
    //   492	504	1476	java/lang/Throwable
    //   512	521	1476	java/lang/Throwable
    //   530	543	1476	java/lang/Throwable
    //   554	565	1476	java/lang/Throwable
    //   573	587	1476	java/lang/Throwable
    //   595	609	1476	java/lang/Throwable
    //   617	631	1476	java/lang/Throwable
    //   639	647	1476	java/lang/Throwable
    //   655	663	1476	java/lang/Throwable
    //   671	682	1476	java/lang/Throwable
    //   690	701	1476	java/lang/Throwable
    //   709	720	1476	java/lang/Throwable
    //   728	736	1476	java/lang/Throwable
    //   744	755	1476	java/lang/Throwable
    //   763	774	1476	java/lang/Throwable
    //   782	789	1476	java/lang/Throwable
    //   797	824	1476	java/lang/Throwable
    //   832	855	1476	java/lang/Throwable
    //   863	873	1476	java/lang/Throwable
    //   881	901	1476	java/lang/Throwable
    //   909	929	1476	java/lang/Throwable
    //   937	957	1476	java/lang/Throwable
  }
  
  public void a()
  {
    if (this.jdField_b_of_type_JavaUtilMap != null) {
      this.jdField_b_of_type_JavaUtilMap.clear();
    }
  }
  
  public void a(List<String> paramList)
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
          paramList = (List<String>)localObject1;
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
      paramList = HardCodeUtil.a(2131714202);
      break;
      paramList = HardCodeUtil.a(2131714198);
      break;
      paramList = HardCodeUtil.a(2131714205);
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
      if (!ApolloUtilImpl.isSpecialActionResDone(5, paramSpriteTaskParam.f))
      {
        ((IApolloResDownloader)QRoute.api(IApolloResDownloader.class)).downLoadSpecialAction(this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a(), ApolloUtilImpl.getApolloDrawerPath(paramSpriteTaskParam.f) + "/d.zip", ApolloUtilImpl.getApolloDrawerUrl(paramSpriteTaskParam.f));
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
        ((IApolloResDownloader)QRoute.api(IApolloResDownloader.class)).downLoadSpecialAction(this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a(), (String)localObject, paramSpriteTaskParam);
        return false;
      }
    }
    else if ((paramSpriteTaskParam.k == 11) || (paramSpriteTaskParam.k == 7))
    {
      paramSpriteTaskParam = ApolloActionHelperImpl.getActionRscPath(paramSpriteTaskParam.k, paramSpriteTaskParam.f, 0, true);
      if ((paramSpriteTaskParam.length > 0) && (!TextUtils.isEmpty(paramSpriteTaskParam[0])) && (!new File(ApolloRender.getRscStaticPath(paramSpriteTaskParam[0], "json")).exists()))
      {
        ((IApolloResDownloader)QRoute.api(IApolloResDownloader.class)).downloadApolloResOrder(this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a(), this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a().getCurrentAccountUin(), null, 0, null, -1, -1, true);
        return false;
      }
    }
    else if (paramSpriteTaskParam.k == 15)
    {
      return c(paramSpriteTaskParam);
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
        break label725;
      }
    }
    label725:
    for (int j = ((Integer)jdField_a_of_type_JavaUtilMap.get(paramString)).intValue();; j = 0)
    {
      Object localObject = ((IApolloManagerService)this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a().getRuntimeService(IApolloManagerService.class, "all")).getStandUpSp();
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
            QLog.d("cmshow_scripted_SpriteRscBuilder", 2, new Object[] { "hasSpecialStandAction getApolloStandAction openCount:", Integer.valueOf(j), ",lastRequestSpTime:", Long.valueOf(l) });
          }
          jdField_a_of_type_JavaUtilMap.put(paramString, Integer.valueOf(0));
          localApolloExtensionHandlerImpl.a(new long[] { Long.parseLong(paramString) });
          localJSONObject.put("lastRequestTime", NetConnInfoCenter.getServerTimeMillis());
          ((SharedPreferences)localObject).edit().putString(paramString, localJSONObject.toString()).commit();
        }
        for (;;)
        {
          if (localJSONArray == null) {
            break label731;
          }
          if (localJSONArray.length() > 0) {
            break;
          }
          break label731;
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
      if ((this.jdField_a_of_type_Int == 4) && (!((ApolloManagerServiceImpl)this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a().getRuntimeService(IApolloManagerService.class, "all")).getApolloBaseInfo(paramString).hasPet))
      {
        a(paramString);
        return false;
      }
      if (QLog.isColorLevel()) {
        QLog.d("cmshow_scripted_SpriteRscBuilder", 2, new Object[] { "[hasSpecialStandAction] uin:", paramString, ",index:", Integer.valueOf(j), ",id:", Integer.valueOf(this.jdField_b_of_type_Int), ",standType:", Integer.valueOf(this.jdField_a_of_type_Int) });
      }
      if (!ApolloUtilImpl.isActionResDone(this.jdField_b_of_type_Int, 0))
      {
        if (QLog.isColorLevel()) {
          QLog.i("cmshow_scripted_SpriteRscBuilder", 2, "hasSpecialStandAction isActionResDone is false.");
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
    label731:
    return false;
  }
  
  public JSONObject b(SpriteTaskParam paramSpriteTaskParam)
  {
    label408:
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
              QLog.d("cmshow_scripted_SpriteRscBuilder", 1, new Object[] { "[getAudioParam] audio not found for " + (String)localObject2, ",action:", Integer.valueOf(paramSpriteTaskParam.f) });
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
          ApolloManagerServiceImpl localApolloManagerServiceImpl = (ApolloManagerServiceImpl)this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a().getRuntimeService(IApolloManagerService.class, "all");
          ApolloActionData localApolloActionData = ((ApolloDaoManagerServiceImpl)this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a().getRuntimeService(IApolloDaoManagerService.class, "all")).findActionById(paramSpriteTaskParam.f);
          if ((localApolloActionData != null) && (localApolloActionData.hasSound))
          {
            localObject2 = "/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/action/" + paramSpriteTaskParam.f + "/" + "music.amr";
            localObject1 = localObject2;
            if (new File((String)localObject2).exists()) {
              break label408;
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
              break label408;
            }
            ((IApolloResDownloader)QRoute.api(IApolloResDownloader.class)).downloadApolloAudio(this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a(), null, paramSpriteTaskParam.i, false);
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
  
  public boolean b(SpriteTaskParam paramSpriteTaskParam)
  {
    if ((paramSpriteTaskParam == null) || (this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext == null) || (this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a() == null)) {
      return false;
    }
    long l1 = System.currentTimeMillis();
    ApolloManagerServiceImpl localApolloManagerServiceImpl = (ApolloManagerServiceImpl)this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a().getRuntimeService(IApolloManagerService.class, "all");
    ApolloActionData localApolloActionData = ((ApolloDaoManagerServiceImpl)this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a().getRuntimeService(IApolloDaoManagerService.class, "all")).findActionById(paramSpriteTaskParam.f);
    if (localApolloActionData == null)
    {
      QLog.i("cmshow_scripted_SpriteRscBuilder", 1, "warning: data is null. call checkApolloPanelJsonVer, id:" + paramSpriteTaskParam.f);
      ApolloContentUpdateHandler.a(this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a(), 1);
      return false;
    }
    int j;
    int k;
    int i;
    if (paramSpriteTaskParam.jdField_c_of_type_Int == 1)
    {
      bool1 = CmShowAioMatcher.a(paramSpriteTaskParam.h, 2);
      j = paramSpriteTaskParam.f;
      k = paramSpriteTaskParam.jdField_d_of_type_Int;
      if (bool1) {
        i = 0;
      }
    }
    boolean bool3;
    label649:
    label655:
    label699:
    label705:
    for (boolean bool1 = ApolloUtilImpl.isWhiteFaceActionRscDone(j, k, i, bool1);; bool1 = bool3)
    {
      Object localObject = ((ISpriteScriptManager)this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a().getRuntimeService(ISpriteScriptManager.class, "all")).getUIHandler();
      if (!bool1)
      {
        if (localObject != null) {
          ((ISpriteUIHandler)localObject).a(0, 0, paramSpriteTaskParam.jdField_a_of_type_Long);
        }
        bool1 = localApolloManagerServiceImpl.downloadApolloRes(localApolloActionData, 4, null);
        if (localObject != null) {
          if (!bool1) {
            break label699;
          }
        }
      }
      for (i = 0;; i = 6) {
        for (;;)
        {
          ((ISpriteUIHandler)localObject).a(i, 1, paramSpriteTaskParam.jdField_a_of_type_Long);
          long l2 = System.currentTimeMillis();
          if (QLog.isColorLevel()) {
            QLog.d("cmshow_scripted_SpriteRscBuilder", 2, new Object[] { "[downloadIfActionNotExist end, actionId:", Integer.valueOf(paramSpriteTaskParam.f), ",costT:", Long.valueOf(l2 - l1), ",threadId:", Long.valueOf(Thread.currentThread().getId()), ",actionType:", Integer.valueOf(paramSpriteTaskParam.jdField_c_of_type_Int) });
          }
          return true;
          i = localApolloActionData.personNum;
          break;
          bool3 = ApolloUtilImpl.isActionResDone(paramSpriteTaskParam.f, localApolloActionData.personNum);
          if ((8 != paramSpriteTaskParam.jdField_c_of_type_Int) || (paramSpriteTaskParam.jdField_d_of_type_JavaLangString == null) || (!bool3)) {
            break label705;
          }
          boolean bool2 = bool3;
          try
          {
            localObject = new JSONObject(paramSpriteTaskParam.jdField_d_of_type_JavaLangString).optJSONObject("action");
            bool2 = bool3;
            String str = ((JSONObject)localObject).optString("actionId");
            bool1 = bool3;
            bool2 = bool3;
            if (!TextUtils.isEmpty(str))
            {
              bool2 = bool3;
              i = Integer.parseInt(str);
              bool2 = bool3;
              if (((JSONObject)localObject).optInt("actionPlatform") <= 0) {
                break label649;
              }
              bool4 = true;
              label470:
              bool1 = bool3;
              bool2 = bool3;
              if (!ApolloUtilImpl.isRandomSubActionDone(paramSpriteTaskParam.f, false, i, bool4)) {
                bool1 = false;
              }
            }
            bool3 = bool1;
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
                  i = Integer.parseInt(str);
                  bool2 = bool1;
                  if (((JSONObject)localObject).optInt("actionPeerPlatform") <= 0) {
                    break label655;
                  }
                }
              }
            }
            for (boolean bool4 = true;; bool4 = false)
            {
              bool3 = bool1;
              bool2 = bool1;
              if (!ApolloUtilImpl.isRandomSubActionDone(paramSpriteTaskParam.f, true, i, bool4)) {
                bool3 = false;
              }
              if (!bool3)
              {
                bool2 = bool3;
                QLog.e("cmshow_scripted_SpriteRscBuilder", 1, "[random] action nis not exist," + paramSpriteTaskParam.jdField_d_of_type_JavaLangString);
              }
              bool1 = bool3;
              break;
              bool4 = false;
              break label470;
            }
          }
          catch (Exception localException)
          {
            QLog.e("cmshow_scripted_SpriteRscBuilder", 1, "[random] the json is not right," + paramSpriteTaskParam.jdField_d_of_type_JavaLangString);
            bool1 = bool2;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.script.SpriteRscBuilder
 * JD-Core Version:    0.7.0.1
 */