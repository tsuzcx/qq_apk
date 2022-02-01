package com.tencent.mobileqq.apollo.utils.api.impl;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.apollo.aio.api.impl.CmShowAioMatcherImpl;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.model.ApolloActionData;
import com.tencent.mobileqq.apollo.model.ApolloBaseInfo;
import com.tencent.mobileqq.apollo.model.ApolloDress;
import com.tencent.mobileqq.apollo.persistence.api.IApolloDaoManagerService;
import com.tencent.mobileqq.apollo.persistence.api.impl.ApolloDaoManagerServiceImpl;
import com.tencent.mobileqq.apollo.res.api.IApolloResHelper;
import com.tencent.mobileqq.apollo.script.SpriteTaskParam;
import com.tencent.mobileqq.apollo.script.SpriteUtil;
import com.tencent.mobileqq.apollo.statistics.product.ApolloDtReportUtil;
import com.tencent.mobileqq.apollo.statistics.product.DtReportParamsBuilder;
import com.tencent.mobileqq.apollo.utils.ApolloConstant;
import com.tencent.mobileqq.apollo.utils.api.IApolloActionHelper;
import com.tencent.mobileqq.apollo.utils.api.IApolloUtil;
import com.tencent.mobileqq.app.CheckPttListener;
import com.tencent.mobileqq.app.CheckPtvListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.cmshow.engine.resource.IApolloResManager;
import com.tencent.mobileqq.cmshow.engine.util.CMResUtil;
import com.tencent.mobileqq.magicface.drawable.PngFrameUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.utils.api.ITroopUtilsApi;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.StringTokenizer;
import mqq.app.AppRuntime;
import mqq.util.LogUtil;
import org.json.JSONObject;

public class ApolloActionHelperImpl
  implements IApolloActionHelper
{
  public static final int APOLLO_DEFAULT_ROLE_ID = 0;
  public static final int APOLLO_MARGIN_THINKING = 40;
  public static final int APOLLO_MARGIN_WAITING = 40;
  public static final int APOLLO_WEB_RSC_STARTS_ID = 21;
  public static final String TAG = "[cmshow]ApolloActionHelper";
  
  public static boolean attach3DInfoToJson(String paramString1, QQAppInterface paramQQAppInterface, JSONObject paramJSONObject, String paramString2)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[attach3DInfoToJson], uin:");
      ((StringBuilder)localObject).append(paramString1);
      QLog.d("[cmshow]ApolloActionHelper", 2, ((StringBuilder)localObject).toString());
    }
    boolean bool1 = false;
    if ((paramQQAppInterface != null) && (!TextUtils.isEmpty(paramString1)))
    {
      ApolloBaseInfo localApolloBaseInfo = ((ApolloDaoManagerServiceImpl)paramQQAppInterface.getRuntimeService(IApolloDaoManagerService.class, "all")).getApolloBaseInfo(paramString1);
      if (localApolloBaseInfo != null)
      {
        boolean bool2 = true;
        localObject = paramString2;
        try
        {
          if (TextUtils.isEmpty(paramString2)) {
            localObject = getModelByUin(paramString1, paramQQAppInterface);
          }
          paramJSONObject.put("model", localObject);
          paramString1 = new JSONObject();
          paramString2 = localApolloBaseInfo.getFaceModel(true, paramQQAppInterface);
          if (paramString2 != null) {
            paramString1.put("faceModel", paramString2);
          }
          paramString2 = localApolloBaseInfo.getDress3D(true, paramQQAppInterface);
          int i = localApolloBaseInfo.getRole3D(true, paramQQAppInterface);
          if ((paramString2 != null) && (i > 0))
          {
            paramString1.put("dress", paramString2);
            paramString1.put("role", String.valueOf(i));
          }
          paramJSONObject.put("3DObject", paramString1);
          bool1 = bool2;
          if (QLog.isColorLevel())
          {
            paramQQAppInterface = new StringBuilder();
            paramQQAppInterface.append("attach3DInfoToJson: obj3D:");
            paramQQAppInterface.append(paramString1.toString());
            QLog.d("[cmshow][scripted][cmshow]ApolloActionHelper", 2, paramQQAppInterface.toString());
            return true;
          }
        }
        catch (Exception paramString1)
        {
          paramQQAppInterface = new StringBuilder();
          paramQQAppInterface.append("attach3DInfoToJson e=");
          paramQQAppInterface.append(paramString1.toString());
          QLog.e("[cmshow]ApolloActionHelper", 1, paramQQAppInterface.toString());
          bool1 = bool2;
        }
      }
      return bool1;
    }
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]ApolloActionHelper", 2, "errInfo->null param.");
    }
    return false;
  }
  
  public static void doActionReport(QQAppInterface paramQQAppInterface, SpriteTaskParam paramSpriteTaskParam, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[doActionReport], isHasUsrText:");
      ((StringBuilder)localObject).append(paramBoolean1);
      ((StringBuilder)localObject).append(",isBarrage:");
      ((StringBuilder)localObject).append(paramBoolean2);
      QLog.d("[cmshow]ApolloActionHelper", 2, ((StringBuilder)localObject).toString());
    }
    if (paramSpriteTaskParam != null)
    {
      if (paramQQAppInterface == null) {
        return;
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("taskParam:");
        ((StringBuilder)localObject).append(paramSpriteTaskParam.toString());
        QLog.d("[cmshow]ApolloActionHelper", 2, ((StringBuilder)localObject).toString());
      }
      localObject = ((ApolloDaoManagerServiceImpl)paramQQAppInterface.getRuntimeService(IApolloDaoManagerService.class, "all")).findActionById(paramSpriteTaskParam.f);
      if (localObject == null) {
        return;
      }
      String str1 = getActionName(paramSpriteTaskParam.i);
      int i = getEntry(paramSpriteTaskParam.g, paramSpriteTaskParam.l);
      int j = paramSpriteTaskParam.p;
      String str2 = Integer.toString(paramSpriteTaskParam.f);
      String str3 = getR3(paramBoolean1, paramBoolean2);
      String str4 = getR4(paramQQAppInterface, paramSpriteTaskParam, (ApolloActionData)localObject);
      String str5 = getR5(paramQQAppInterface, paramSpriteTaskParam, (ApolloActionData)localObject);
      VipUtils.a(paramQQAppInterface, "cmshow", "Apollo", "actionnewuser_play", paramSpriteTaskParam.k, i, j, new String[] { str2, "", "", String.valueOf(System.currentTimeMillis() / 1000L) });
      VipUtils.a(paramQQAppInterface, "cmshow", "Apollo", str1, i, j, new String[] { str2, str3, str4, str5 });
      if (QLog.isColorLevel())
      {
        paramQQAppInterface = new StringBuilder();
        paramQQAppInterface.append("actionName:");
        paramQQAppInterface.append(str1);
        paramQQAppInterface.append(",entry:");
        paramQQAppInterface.append(i);
        paramQQAppInterface.append(",result:");
        paramQQAppInterface.append(j);
        paramQQAppInterface.append(",r2:");
        paramQQAppInterface.append(str2);
        paramQQAppInterface.append(",r3:");
        paramQQAppInterface.append(str3);
        paramQQAppInterface.append(",r4:");
        paramQQAppInterface.append(str4);
        paramQQAppInterface.append(",r5:");
        paramQQAppInterface.append(str5);
        QLog.d("[cmshow]ApolloActionHelper", 2, paramQQAppInterface.toString());
      }
      j = 2;
      paramQQAppInterface = new DtReportParamsBuilder();
      if (paramSpriteTaskParam.f > ApolloConstant.f) {
        i = 1;
      } else {
        i = 0;
      }
      paramQQAppInterface = paramQQAppInterface.a(i).b(ApolloDtReportUtil.a(paramSpriteTaskParam.i));
      if (paramSpriteTaskParam.d == 1) {
        i = j;
      } else {
        i = 0;
      }
      paramQQAppInterface = paramQQAppInterface.c(i).e(ApolloDtReportUtil.a(((ApolloActionData)localObject).personNum, paramSpriteTaskParam.c)).f(String.valueOf(paramSpriteTaskParam.f));
      j = paramSpriteTaskParam.g;
      i = 1;
      if (j != 1) {
        i = 0;
      }
      ApolloDtReportUtil.a("aio_bubble", "apollo_msg", "play", paramQQAppInterface.d(i).c(ApolloDtReportUtil.a()).g(ApolloDtReportUtil.c(paramSpriteTaskParam.f)).a());
    }
  }
  
  public static String get3DFaceDataByUin(String paramString, QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        return null;
      }
      paramString = ((ApolloDaoManagerServiceImpl)paramQQAppInterface.getRuntimeService(IApolloDaoManagerService.class, "all")).getApolloBaseInfo(paramString);
      if (paramString != null)
      {
        paramString = paramString.getApolloDress3D();
        if (paramString != null) {
          return paramString.faceData;
        }
      }
    }
    return null;
  }
  
  public static Object[] get3DRoleDressIdByUin(String paramString, int paramInt, QQAppInterface paramQQAppInterface, boolean paramBoolean, IApolloResManager paramIApolloResManager)
  {
    if ((paramQQAppInterface != null) && (!TextUtils.isEmpty(paramString)) && (paramInt == 2) && (paramIApolloResManager != null))
    {
      Object localObject = ((ApolloDaoManagerServiceImpl)paramQQAppInterface.getRuntimeService(IApolloDaoManagerService.class, "all")).getApolloBaseInfo(paramString);
      if (localObject != null)
      {
        localObject = ((ApolloBaseInfo)localObject).getApolloDress3D();
        if (localObject != null)
        {
          int i = ((ApolloDress)localObject).roleId;
          localObject = ((ApolloDress)localObject).getDressIds();
          if ((i > ApolloConstant.f) && (localObject != null) && (localObject.length > 0) && ((!paramBoolean) || (paramIApolloResManager.a(paramString, i, (int[])localObject, paramQQAppInterface))))
          {
            paramInt = i;
            paramString = (String)localObject;
            if (!QLog.isColorLevel()) {
              break label159;
            }
            QLog.d("[cmshow]ApolloActionHelper", 2, new Object[] { "get3DRoleDressIdByUin valid role and dress RSC, needVerify:", Boolean.valueOf(paramBoolean) });
            paramInt = i;
            paramString = (String)localObject;
            break label159;
          }
        }
      }
      paramString = null;
      paramInt = 0;
      label159:
      return new Object[] { Integer.valueOf(paramInt), paramString };
    }
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]ApolloActionHelper", 2, new Object[] { "get3DRoleIdByUin errInfo->null param, userStatus:", Integer.valueOf(paramInt) });
    }
    return new Object[] { Integer.valueOf(-1), null };
  }
  
  private static String getActionName(int paramInt)
  {
    if (paramInt == 0) {
      return "action_play";
    }
    if (paramInt == 1) {
      return "g_action_play";
    }
    if (paramInt == 3000) {
      return "d_action_play";
    }
    return "";
  }
  
  public static String[] getActionRscPath(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    return getActionRscPath(paramInt1, paramInt2, paramInt3, paramBoolean, 1);
  }
  
  public static String[] getActionRscPath(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, int paramInt4)
  {
    if (QLog.isColorLevel())
    {
      localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("[getActionRscPath], bid:");
      localStringBuilder1.append(paramInt1);
      localStringBuilder1.append(",activeId:");
      localStringBuilder1.append(paramInt2);
      localStringBuilder1.append(",roleId:");
      localStringBuilder1.append(paramInt3);
      localStringBuilder1.append(",isActionMaker:");
      localStringBuilder1.append(paramBoolean);
      QLog.d("[cmshow]ApolloActionHelper", 2, new Object[] { localStringBuilder1.toString(), ",userStatus:", Integer.valueOf(paramInt4) });
    }
    StringBuilder localStringBuilder1 = new StringBuilder();
    if (paramInt4 == 2) {
      paramInt4 = 1;
    } else {
      paramInt4 = 0;
    }
    switch (paramInt1)
    {
    case 3: 
    case 8: 
    case 9: 
    default: 
      break;
    case 14: 
      localStringBuilder1.append("def/role/0/3D/");
      localStringBuilder1.append("sayhi");
    case 13: 
    case 11: 
    case 10: 
    case 7: 
    case 6: 
    case 5: 
    case 4: 
      for (;;)
      {
        paramInt3 = 1;
        paramInt4 = 1;
        break label686;
        localStringBuilder1.append("action");
        break;
        if (paramInt4 != 0)
        {
          localStringBuilder1.append("def/role/0/3D/");
          localStringBuilder1.append("drawer");
          break;
        }
        localStringBuilder1.append("def/role/");
        localStringBuilder1.append(0);
        localStringBuilder1.append("/");
        localStringBuilder1.append("drawer");
        break;
        i = getRandomActionId(paramInt3, "interact");
        if (-1 != i)
        {
          localStringBuilder1.append("role/");
          localStringBuilder1.append(paramInt3);
          localStringBuilder1.append("/");
          localStringBuilder1.append("interact");
          paramInt3 = i;
          break label677;
        }
        if (paramInt4 != 0)
        {
          localStringBuilder1.append("def/role/0/3D/");
          localStringBuilder1.append("sayhi");
        }
        else
        {
          localStringBuilder1.append("def/basic/");
          localStringBuilder1.append("sayhi");
          continue;
          if (paramInt4 != 0)
          {
            localStringBuilder1.append("def/role/0/3D/");
            localStringBuilder1.append("friendcard");
            break;
          }
          localStringBuilder1.append("def/role/");
          localStringBuilder1.append(0);
          localStringBuilder1.append("/");
          localStringBuilder1.append("friendcard");
          break;
          localStringBuilder1.append("drawer_action/");
          break;
          i = getRandomActionId(paramInt3, "sayhi");
          if (-1 != i)
          {
            localStringBuilder1.append("role/");
            localStringBuilder1.append(paramInt3);
            localStringBuilder1.append("/");
            localStringBuilder1.append("sayhi");
            paramInt3 = i;
            break label677;
          }
          if (paramInt4 != 0)
          {
            localStringBuilder1.append("def/role/0/3D/");
            localStringBuilder1.append("sayhi");
          }
          else
          {
            localStringBuilder1.append("def/basic/");
            localStringBuilder1.append("sayhi");
            continue;
            if (paramInt4 != 0)
            {
              localStringBuilder1.append("def/role/0/3D/");
              localStringBuilder1.append("sayhi");
            }
            else
            {
              localStringBuilder1.append("def/basic/");
              localStringBuilder1.append("sayhi");
            }
          }
        }
      }
    case 2: 
      if (paramInt4 != 0) {
        localStringBuilder1.append("def/role/0/3D/");
      } else {
        localStringBuilder1.append("def/basic/action");
      }
      break;
    case 1: 
    case 12: 
      paramInt4 = paramInt2;
      paramInt3 = 0;
      break;
    }
    paramInt3 = paramInt2;
    label677:
    int i = 1;
    paramInt4 = paramInt3;
    paramInt3 = i;
    label686:
    if (paramInt3 != 0) {
      localStringBuilder1.append("/");
    }
    localStringBuilder1.append(paramInt4);
    if ((!paramBoolean) && (paramInt2 >= 21))
    {
      if (15 == paramInt1) {
        localStringBuilder1.append("/panelAction");
      }
      localStringBuilder1.append("/action_peer/action");
    }
    else
    {
      if (localStringBuilder1.indexOf("def/role/0/3D/") <= -1) {
        break label771;
      }
      localStringBuilder1.append("/action");
    }
    for (;;)
    {
      break;
      label771:
      if (15 == paramInt1) {
        localStringBuilder1.append("/panelAction");
      }
      localStringBuilder1.append("/action/action");
    }
    String str = localStringBuilder1.toString();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(Integer.toString(paramInt1));
    ((StringBuilder)localObject).append("_");
    ((StringBuilder)localObject).append(Integer.toString(paramInt4));
    localObject = ((StringBuilder)localObject).toString();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("action rsc path:");
      localStringBuilder2.append(localStringBuilder1.toString());
      localStringBuilder2.append(",actionId:");
      localStringBuilder2.append(paramInt4);
      QLog.d("[cmshow]ApolloActionHelper", 2, localStringBuilder2.toString());
    }
    return new String[] { str, localObject };
  }
  
  public static String[] getActionScriptString(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]ApolloActionHelper", 2, new Object[] { "[getActionLuaString] apolloId=", paramString1, ", actionId=", Integer.valueOf(paramInt1), ", taskId=", Integer.valueOf(paramInt2), ", animName=", paramString3, ", actionRscName=", paramString2 });
    }
    String[] arrayOfString = new String[2];
    Object localObject = paramString3;
    if (paramString2.contains("_peer"))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString3);
      ((StringBuilder)localObject).append("_peer");
      localObject = ((StringBuilder)localObject).toString();
    }
    paramString3 = paramString2;
    if (paramString2.startsWith("action")) {
      paramString3 = paramString2.substring(7);
    }
    arrayOfString[0] = String.format("setAccessoryAnimation(%s, '%s', '%s', '%s');", new Object[] { paramString1, paramString3, paramString3, localObject });
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]ApolloActionHelper", 2, arrayOfString[0]);
    }
    arrayOfString[1] = String.format("if(%s){%s.setAnimation(%d, '%s', false);}", new Object[] { paramString1, paramString1, Integer.valueOf(paramInt2), localObject });
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]ApolloActionHelper", 2, arrayOfString[1]);
    }
    return arrayOfString;
  }
  
  public static String getAddFrameScript()
  {
    return "if(\"undefined\" != typeof addFrame){addFrame();}else{if(renderTicker.paused){if(BK.Director.root){BK.Render.clear(0,0,0,0);BK.Render.treeRender( BK.Director.root,0);BK.Render.commit();}}}";
  }
  
  public static String getApolloRsc(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append(",id:");
      localStringBuilder1.append(paramInt2);
      QLog.d("[cmshow]ApolloActionHelper", 2, new Object[] { "[getApolloRsc],  rscType", Integer.valueOf(paramInt1), localStringBuilder1.toString() });
    }
    StringBuilder localStringBuilder1 = new StringBuilder();
    if (paramInt1 != 0)
    {
      if (paramInt1 == 1)
      {
        if (paramInt2 < 21) {
          localStringBuilder1.append("def/basic/dress/");
        }
        localStringBuilder1.append(paramInt2);
        localStringBuilder1.append("/dress");
      }
    }
    else
    {
      if (paramInt2 == 0) {
        localStringBuilder1.append("def/basic/skeleton/");
      }
      localStringBuilder1.append(paramInt2);
      localStringBuilder1.append("/role");
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("rsc:");
      localStringBuilder2.append(localStringBuilder1);
      QLog.d("[cmshow]ApolloActionHelper", 2, localStringBuilder2.toString());
    }
    return localStringBuilder1.toString();
  }
  
  public static String getBubbleRscName(int paramInt1, int paramInt2)
  {
    return getBubbleRscName(paramInt1, paramInt2, 1);
  }
  
  public static String getBubbleRscName(int paramInt1, int paramInt2, int paramInt3)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if ((paramInt1 != 0) && (ApolloUtilImpl.isBubbleRscExist(paramInt1, paramInt2)))
    {
      localStringBuilder.append("role/");
      localStringBuilder.append(paramInt1);
    }
    else
    {
      localStringBuilder.append("def/role/");
      localStringBuilder.append(0);
    }
    localStringBuilder.append("/");
    localStringBuilder.append("Bubble");
    localStringBuilder.append("/");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append("/dress");
    return localStringBuilder.toString();
  }
  
  public static String getBubbleScriptString(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[getBubbleLuaString], apolloId:");
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append(",bubbleId");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(",roleId:");
      ((StringBuilder)localObject).append(paramInt2);
      QLog.d("[cmshow]ApolloActionHelper", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = getBubbleRscName(paramInt2, paramInt1);
    paramString1 = String.format("setAccessoryWithInfo(%s, '%s', '%s', '%s');", new Object[] { paramString1, localObject, localObject, paramString2 });
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]ApolloActionHelper", 2, paramString1);
    }
    return paramString1;
  }
  
  public static String[] getDressScriptString(String paramString, int[] paramArrayOfInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]ApolloActionHelper", 2, new Object[] { "[getDressLuaString] apolloId=", paramString });
    }
    if (paramArrayOfInt == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("[cmshow]ApolloActionHelper", 2, "[getDressLuaString] no dressId, abort");
      }
      return null;
    }
    String[] arrayOfString = new String[paramArrayOfInt.length];
    int i = 0;
    while (i < paramArrayOfInt.length)
    {
      String str = getApolloRsc(1, paramArrayOfInt[i]);
      arrayOfString[i] = String.format("setAccessory(%s, '%s', '%s');", new Object[] { paramString, str, str });
      if (QLog.isColorLevel()) {
        QLog.d("[cmshow]ApolloActionHelper", 2, new Object[] { "[getDressLuaString] scriptStr", Integer.valueOf(i), "=", arrayOfString[i] });
      }
      i += 1;
    }
    return arrayOfString;
  }
  
  private static int getEntry(int paramInt, boolean paramBoolean)
  {
    if (paramInt == 2)
    {
      if (paramBoolean) {
        return 2;
      }
      return 3;
    }
    if (paramInt == 0) {
      return 0;
    }
    if (paramInt == 1) {
      return 1;
    }
    if (paramInt == 4) {
      return 4;
    }
    return 0;
  }
  
  public static String getModelByUin(String paramString, AppRuntime paramAppRuntime)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[getModelByUin], uin:");
      localStringBuilder.append(paramString);
      QLog.d("[cmshow]ApolloActionHelper", 2, localStringBuilder.toString());
    }
    if ((paramAppRuntime != null) && (!TextUtils.isEmpty(paramString)))
    {
      if (((IApolloManagerService)paramAppRuntime.getRuntimeService(IApolloManagerService.class, "all")).getCmShowStatus(paramString) == 2) {
        return "3D";
      }
      return "2D";
    }
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]ApolloActionHelper", 2, "errInfo->null param.");
    }
    return null;
  }
  
  private static String getR3(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      if (paramBoolean2) {
        return "2";
      }
      return "1";
    }
    return "0";
  }
  
  private static String getR4(QQAppInterface paramQQAppInterface, SpriteTaskParam paramSpriteTaskParam, ApolloActionData paramApolloActionData)
  {
    if ((!paramApolloActionData.hasSound) && (paramSpriteTaskParam.m <= 0)) {
      return "0";
    }
    if ((1 == paramQQAppInterface.getALLGeneralSettingRing()) && (paramQQAppInterface.isCallIdle()) && (isSupport(paramQQAppInterface, paramSpriteTaskParam)) && (isMediaIdle(paramQQAppInterface))) {
      return "1";
    }
    return "2";
  }
  
  private static String getR5(QQAppInterface paramQQAppInterface, SpriteTaskParam paramSpriteTaskParam, ApolloActionData paramApolloActionData)
  {
    if ((8 == paramSpriteTaskParam.c) && (!TextUtils.isEmpty(paramSpriteTaskParam.t))) {}
    try
    {
      paramQQAppInterface = new JSONObject(paramSpriteTaskParam.t).optString("subActionId", "0");
      return paramQQAppInterface;
    }
    catch (Exception paramQQAppInterface)
    {
      label42:
      break label42;
    }
    paramQQAppInterface = new StringBuilder();
    paramQQAppInterface.append("[random] the json is not right,");
    paramQQAppInterface.append(paramSpriteTaskParam.t);
    QLog.e("[cmshow]ApolloActionHelper", 1, paramQQAppInterface.toString());
    return "-1";
    if (getVibrateData(paramApolloActionData.vibrate) == null) {
      return "0";
    }
    if ((1 == paramQQAppInterface.getALLGeneralSettingVibrate()) && (((paramSpriteTaskParam.i != 1) && (paramSpriteTaskParam.i != 3000)) || (((1 == ((ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class)).getTroopGeneralSettingVibrate(paramQQAppInterface)) || (paramSpriteTaskParam.i == 0)) && (!paramQQAppInterface.isRingEqualsZero())))) {
      return "1";
    }
    return "2";
  }
  
  public static int getRandomActionId(int paramInt, String paramString)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[getRandomActionId], roleId:");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("[cmshow]ApolloActionHelper", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append("/");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("/");
    paramString = new File("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/role/", ((StringBuilder)localObject).toString());
    if (!paramString.exists()) {
      return -1;
    }
    localObject = paramString.list();
    int i;
    if ((localObject != null) && (localObject.length != 0))
    {
      i = PngFrameUtil.a(localObject.length);
      if (i < localObject.length)
      {
        if (i < 0) {
          return -1;
        }
        localObject = localObject[i];
      }
    }
    try
    {
      int j = Integer.parseInt((String)localObject);
      StringBuilder localStringBuilder;
      if (CMResUtil.a(paramInt))
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString.getAbsolutePath());
        localStringBuilder.append("/");
        localStringBuilder.append((String)localObject);
        localStringBuilder.append("/action/");
        localStringBuilder.append("action.bin");
        if (!CMResUtil.a(localStringBuilder.toString())) {
          return -1;
        }
      }
      else
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString.getAbsolutePath());
        localStringBuilder.append("/");
        localStringBuilder.append((String)localObject);
        localStringBuilder.append("/");
        localStringBuilder.append("action/action.json");
        if (!CMResUtil.a(localStringBuilder.toString())) {
          break label486;
        }
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString.getAbsolutePath());
        localStringBuilder.append("/");
        localStringBuilder.append((String)localObject);
        localStringBuilder.append("/");
        localStringBuilder.append("action/action.png");
        if (!CMResUtil.a(localStringBuilder.toString())) {
          break label486;
        }
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString.getAbsolutePath());
        localStringBuilder.append("/");
        localStringBuilder.append((String)localObject);
        localStringBuilder.append("/");
        localStringBuilder.append("action/action.atlas");
        if (!CMResUtil.a(localStringBuilder.toString())) {
          return -1;
        }
        if (QLog.isColorLevel())
        {
          paramString = new StringBuilder();
          paramString.append("value:");
          paramString.append(i);
          paramString.append(",actionId:");
          paramString.append((String)localObject);
          QLog.d("[cmshow]ApolloActionHelper", 2, paramString.toString());
        }
      }
      return j;
      label486:
      return -1;
    }
    catch (NumberFormatException paramString) {}
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]ApolloActionHelper", 2, "no any action file.");
    }
    return -1;
    return -1;
  }
  
  public static String getRandomBubbleText(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    paramString = new StringTokenizer(paramString, "@$");
    int i = PngFrameUtil.a(paramString.countTokens());
    while (paramString.hasMoreTokens())
    {
      i -= 1;
      if (i < 0) {
        return paramString.nextToken();
      }
      paramString.nextToken();
    }
    return "";
  }
  
  public static String getResAddPrefixPath(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    if (paramString.contains("def")) {
      return paramString;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt == 3) {
          localStringBuilder.append("ActionRes:");
        }
      }
      else {
        localStringBuilder.append("Dress:");
      }
    }
    else {
      localStringBuilder.append("Role:");
    }
    localStringBuilder.append("//");
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  public static Object[] getRoleDressIdByUin(String paramString, AppRuntime paramAppRuntime, boolean paramBoolean, IApolloResManager paramIApolloResManager)
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("[getRoldIdByUin], uin:");
      ((StringBuilder)localObject1).append(paramString);
      QLog.d("[cmshow]ApolloActionHelper", 2, ((StringBuilder)localObject1).toString());
    }
    if ((paramAppRuntime != null) && (!TextUtils.isEmpty(paramString)) && (paramIApolloResManager != null))
    {
      Object localObject2 = ((IApolloResHelper)QRoute.api(IApolloResHelper.class)).readRoleDefaultDressIds(0);
      if (!"-1".equals(paramString))
      {
        localObject1 = "-2";
        if (!"-2".equals(paramString))
        {
          if (((IApolloUtil)QRoute.api(IApolloUtil.class)).isFemale(paramAppRuntime, paramString)) {
            break label138;
          }
          localObject1 = "-1";
          break label138;
        }
      }
      localObject1 = paramString;
      label138:
      int i;
      if ("-1".equals(localObject1)) {
        i = 1;
      } else {
        i = 2;
      }
      Object localObject3 = ((IApolloResHelper)QRoute.api(IApolloResHelper.class)).readRoleDefaultDressIds(i);
      if ((paramBoolean) && (!paramIApolloResManager.a((String)localObject1, i, (int[])localObject3, paramAppRuntime)))
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("role and dress is not ready,uin:");
        ((StringBuilder)localObject1).append(paramString);
        ((StringBuilder)localObject1).append(",roleId:");
        ((StringBuilder)localObject1).append(0);
        QLog.w("[cmshow]ApolloActionHelper", 1, ((StringBuilder)localObject1).toString());
        i = 0;
        localObject1 = localObject2;
      }
      else
      {
        localObject1 = localObject3;
      }
      localObject2 = ((ApolloDaoManagerServiceImpl)paramAppRuntime.getRuntimeService(IApolloDaoManagerService.class, "all")).getApolloBaseInfo(paramString);
      int j;
      if (localObject2 != null)
      {
        j = ((ApolloBaseInfo)localObject2).apolloStatus;
        if (QLog.isColorLevel())
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("uin: ");
          ((StringBuilder)localObject3).append(((ApolloBaseInfo)localObject2).uin);
          ((StringBuilder)localObject3).append(", funcSwitch:");
          ((StringBuilder)localObject3).append(j);
          QLog.d("[cmshow]ApolloActionHelper", 2, ((StringBuilder)localObject3).toString());
        }
        if (!((ApolloBaseInfo)localObject2).isApolloStatusOpen()) {
          return new Object[] { Integer.valueOf(i), localObject1 };
        }
        if ((paramBoolean) && (((ApolloBaseInfo)localObject2).apolloLocalTS != ((ApolloBaseInfo)localObject2).apolloServerTS) && ((paramAppRuntime instanceof AppInterface)))
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("dress changed, uin:");
          ((StringBuilder)localObject3).append(LogUtil.wrapLogUin(paramString));
          QLog.i("[cmshow]ApolloActionHelper", 1, ((StringBuilder)localObject3).toString());
          paramIApolloResManager.a((AppInterface)paramAppRuntime, paramString, "getRoleDressIdByUin");
        }
        localObject3 = ((ApolloBaseInfo)localObject2).getApolloDress(false);
        if ((localObject3 != null) && (localObject3.length > 0))
        {
          int k = localObject3.length;
          j = 0;
          while (j < k)
          {
            Object localObject4 = localObject3[j];
            localObject2 = localObject4.getDressIds();
            if (paramIApolloResManager.a(paramString, localObject4.roleId, (int[])localObject2, paramAppRuntime))
            {
              if (QLog.isColorLevel()) {
                QLog.d("[cmshow]ApolloActionHelper", 2, "valid role and dress RSC.");
              }
              i = localObject4.roleId;
              j = 1;
              localObject1 = localObject2;
              break label586;
            }
            if (QLog.isColorLevel()) {
              QLog.d("[cmshow]ApolloActionHelper", 2, "try to get history dress ....");
            }
            j += 1;
          }
          j = 0;
          label586:
          if (j == 0)
          {
            localObject2 = ((IApolloResHelper)QRoute.api(IApolloResHelper.class)).readRoleDefaultDressIds(localObject3[0].roleId);
            if (paramIApolloResManager.a(paramString, localObject3[0].roleId, (int[])localObject2, paramAppRuntime))
            {
              if (QLog.isColorLevel()) {
                QLog.d("[cmshow]ApolloActionHelper", 2, "valid basic dress.");
              }
              j = localObject3[0].roleId;
              localObject1 = localObject2;
              i = j;
              if (QLog.isColorLevel())
              {
                QLog.d("[cmshow]ApolloActionHelper", 2, "current dress NOT downloaded, check basic dress");
                localObject1 = localObject2;
                i = j;
              }
            }
            else
            {
              SpriteUtil.a(110, new Object[] { "basicDresses is not vaild" });
            }
          }
        }
        else
        {
          paramAppRuntime = new StringBuilder();
          paramAppRuntime.append("uin: ");
          paramAppRuntime.append(LogUtil.wrapLogUin(paramString));
          paramAppRuntime.append(" dress is null");
          QLog.w("[cmshow]ApolloActionHelper", 1, paramAppRuntime.toString());
        }
      }
      else
      {
        paramString = new StringBuilder();
        paramString.append("warning: apolloBaseInfo or apolloBaseInfo.apolloDress is NULL, fail to get role info. apolloBaseInfo:");
        paramString.append(localObject2);
        QLog.w("[cmshow]ApolloActionHelper", 1, paramString.toString());
      }
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("******roleId:[");
        paramString.append(i);
        paramString.append("],");
        paramString.append("dress:[");
        j = 0;
        while (j < localObject1.length)
        {
          if (j != 0) {
            paramString.append(",");
          }
          paramString.append(localObject1[j]);
          j += 1;
        }
        paramString.append("]****");
        QLog.d("[cmshow]ApolloActionHelper", 2, paramString.toString());
      }
      return new Object[] { Integer.valueOf(i), localObject1 };
    }
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]ApolloActionHelper", 2, "errInfo->null param.");
    }
    return null;
  }
  
  public static String getRoleScriptString(String paramString, int paramInt, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]ApolloActionHelper", 2, new Object[] { "[getRoleLuaString] apolloId=", paramString, ", roleId=", Integer.valueOf(paramInt) });
    }
    String str = getApolloRsc(0, paramInt);
    float f = 0.0F;
    if ("friend".equals(paramString)) {
      f = 180.0F;
    }
    paramString = String.format("var %s = loadAnimation('%s', '%s', '%s', %f, %f, %f, %f, %f, '%s','%s');if(%s){%s.openAABBCallback()}", new Object[] { paramString, paramString, str, str, Float.valueOf(1.0F), Float.valueOf(paramFloat1), Float.valueOf(f), Float.valueOf(paramFloat2), Float.valueOf(paramFloat3), "null", "null", paramString, paramString });
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]ApolloActionHelper", 2, new Object[] { "[getRoleLuaString] scriptStr=", paramString });
    }
    return paramString;
  }
  
  public static String getTickerPauseString()
  {
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]ApolloActionHelper", 2, "[getTickerPauseString]");
    }
    return "BK.Director.tickerPause();";
  }
  
  private static long[] getVibrateData(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    paramString = paramString.split(",");
    if (paramString != null)
    {
      if (paramString.length == 0) {
        return null;
      }
      Object localObject = new long[paramString.length];
      int i = 0;
      try
      {
        while (i < paramString.length)
        {
          localObject[i] = Integer.parseInt(paramString[i].trim());
          i += 1;
        }
        i = paramString.length - 2;
        while (i >= 2)
        {
          localObject[i] = (localObject[i] - localObject[(i - 1)] - localObject[(i - 2)]);
          i -= 2;
        }
        return localObject;
      }
      catch (NumberFormatException paramString)
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("errInfo->NumberFormatException, e:");
          ((StringBuilder)localObject).append(paramString.getMessage());
          QLog.d("[cmshow]ApolloActionHelper", 2, ((StringBuilder)localObject).toString());
        }
      }
    }
    return null;
  }
  
  public static String[] getWhiteFaceRscPath(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append(paramInt1);
    localStringBuilder1.append("/action");
    if (paramBoolean2) {
      localStringBuilder1.append("/group");
    }
    if (paramInt2 != 0)
    {
      if (paramInt2 != 1)
      {
        if (paramInt2 == 2) {
          localStringBuilder1.append("/post");
        }
      }
      else {
        localStringBuilder1.append("/main");
      }
    }
    else {
      localStringBuilder1.append("/pre");
    }
    if (paramBoolean1) {
      localStringBuilder1.append("/action/action");
    } else {
      localStringBuilder1.append("/action_peer/action");
    }
    String str = localStringBuilder1.toString();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("whiteface_");
    ((StringBuilder)localObject).append(Integer.toString(paramInt2));
    ((StringBuilder)localObject).append("_");
    ((StringBuilder)localObject).append(Integer.toString(paramInt1));
    localObject = ((StringBuilder)localObject).toString();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("[whiteface] path:");
      localStringBuilder2.append(localStringBuilder1.toString());
      localStringBuilder2.append(",actionId:");
      localStringBuilder2.append(paramInt1);
      QLog.d("[cmshow]ApolloActionHelper", 2, localStringBuilder2.toString());
    }
    return new String[] { str, localObject };
  }
  
  private static boolean isMediaIdle(QQAppInterface paramQQAppInterface)
  {
    MediaPlayerManager localMediaPlayerManager = (MediaPlayerManager)paramQQAppInterface.getManager(QQManagerFactory.MGR_MEDIA_PLAYER);
    return (!paramQQAppInterface.isRingerVibrate()) && (!paramQQAppInterface.isRingEqualsZero()) && ((localMediaPlayerManager == null) || (!localMediaPlayerManager.g())) && ((paramQQAppInterface.getCheckPttListener() == null) || (!paramQQAppInterface.getCheckPttListener().ac())) && (!paramQQAppInterface.isVideoChatting()) && ((paramQQAppInterface.getCheckPtvListener() == null) || (!paramQQAppInterface.getCheckPtvListener().a()));
  }
  
  public static boolean isPlayerAction(ApolloActionData paramApolloActionData)
  {
    return (paramApolloActionData != null) && (paramApolloActionData.isForPlayerAction == 1);
  }
  
  private static boolean isSupport(QQAppInterface paramQQAppInterface, SpriteTaskParam paramSpriteTaskParam)
  {
    boolean bool2 = CmShowAioMatcherImpl.judgeSupported(paramSpriteTaskParam.i, 2);
    boolean bool1 = true;
    if ((!bool2) || (1 != ((ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class)).getTroopGeneralSettingRing(paramQQAppInterface)))
    {
      if (CmShowAioMatcherImpl.judgeSupported(paramSpriteTaskParam.i, 1)) {
        return true;
      }
      bool1 = false;
    }
    return bool1;
  }
  
  public String[] getActionResourcePath(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, int paramInt4)
  {
    return getActionRscPath(paramInt1, paramInt2, paramInt3, paramBoolean, paramInt4);
  }
  
  public int getApolloFuncSwitch(String paramString, AppRuntime paramAppRuntime)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[getApolloFuncSwitch], uin:");
      localStringBuilder.append(paramString);
      QLog.d("[cmshow]ApolloActionHelper", 2, localStringBuilder.toString());
    }
    paramString = ((ApolloDaoManagerServiceImpl)paramAppRuntime.getRuntimeService(IApolloDaoManagerService.class, "all")).getApolloBaseInfoFromCache(paramString);
    if (paramString == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("[cmshow]ApolloActionHelper", 2, "apolloBaseInfo is null. ret closed status");
      }
      return 2;
    }
    return paramString.apolloStatus;
  }
  
  public String getApolloResource(int paramInt1, int paramInt2)
  {
    return getApolloRsc(paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.utils.api.impl.ApolloActionHelperImpl
 * JD-Core Version:    0.7.0.1
 */