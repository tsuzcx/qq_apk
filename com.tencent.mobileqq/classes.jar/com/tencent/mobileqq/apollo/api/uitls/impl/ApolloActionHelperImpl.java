package com.tencent.mobileqq.apollo.api.uitls.impl;

import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.api.aio.CmShowAioMatcher;
import com.tencent.mobileqq.apollo.api.data.IApolloDaoManagerService;
import com.tencent.mobileqq.apollo.api.data.impl.ApolloDaoManagerServiceImpl;
import com.tencent.mobileqq.apollo.api.handler.impl.ApolloExtensionHandlerImpl;
import com.tencent.mobileqq.apollo.api.impl.ApolloManagerServiceImpl;
import com.tencent.mobileqq.apollo.api.model.ApolloActionData;
import com.tencent.mobileqq.apollo.api.model.ApolloBaseInfo;
import com.tencent.mobileqq.apollo.api.model.ApolloDress;
import com.tencent.mobileqq.apollo.api.res.IApolloResDownloader;
import com.tencent.mobileqq.apollo.api.res.IApolloResDownloader.OnApolloDownLoadListener;
import com.tencent.mobileqq.apollo.api.script.SpriteTaskParam;
import com.tencent.mobileqq.apollo.api.sdk.PlayActionConfig;
import com.tencent.mobileqq.apollo.api.uitls.ApolloConstant;
import com.tencent.mobileqq.apollo.api.uitls.IApolloActionHelper;
import com.tencent.mobileqq.apollo.api.uitls.IApolloUtil;
import com.tencent.mobileqq.apollo.script.SpriteUtil;
import com.tencent.mobileqq.apollo.statistics.product.ApolloDtReportUtil;
import com.tencent.mobileqq.apollo.statistics.product.ApolloDtReportUtil.DtReportParamsBuilder;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.CheckPttListener;
import com.tencent.mobileqq.app.CheckPtvListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.magicface.drawable.PngFrameUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;
import org.json.JSONObject;

public class ApolloActionHelperImpl
  implements IApolloActionHelper
{
  public static final int ACTION_TYPE_FROM_3D_SAYHI_DEFAULT = 14;
  public static final int ACTION_TYPE_FROM_4SHOW_DEFAULT = 2;
  public static final int ACTION_TYPE_FROM_4SHOW_ROLE_RELATED = 3;
  public static final int ACTION_TYPE_FROM_AIO_ADD_ACTION_DIR = 13;
  public static final int ACTION_TYPE_FROM_AIO_PANEL = 1;
  public static final int ACTION_TYPE_FROM_AI_DEFAULT = 8;
  public static final int ACTION_TYPE_FROM_AI_EMOTION = 9;
  public static final int ACTION_TYPE_FROM_CARD_PLAYHIDE = 7;
  public static final int ACTION_TYPE_FROM_CMSHOW_PANEL_FRAME = 15;
  public static final int ACTION_TYPE_FROM_DRAWER_PLAY_HIDE = 11;
  public static final int ACTION_TYPE_FROM_INTERACT_ROLE_RELATED = 10;
  public static final int ACTION_TYPE_FROM_SAYHI_DEFAULT = 4;
  public static final int ACTION_TYPE_FROM_SAYHI_ROLE_RELATED = 5;
  public static final int ACTION_TYPE_FROM_SHOW_STAND = 12;
  public static final int ACTION_TYPE_FROM_WEATHER = 6;
  public static final int APOLLO_DEFAULT_ROLE_ID = 0;
  public static final int APOLLO_MARGIN_THINKING = 40;
  public static final int APOLLO_MARGIN_WAITING = 40;
  public static final String APOLLO_SOUND_NAME = "music.amr";
  public static final int APOLLO_V1_ROLE_MAX_VALUE = 1000;
  public static final int APOLLO_WEB_RSC_STARTS_ID = 21;
  private static final String[] DEFAULT_ROLE_RSC_LIST = { "/def/role/0/sayhi/1/action/action.json", "/def/role/0/friendcard/1/action/action.json", "/def/role/0/3D/sayhi/1/action.bin", "/def/role/0/3D/3DConfig.json" };
  public static int FROM_CARD = 0;
  public static int FROM_DRAWER = 0;
  public static final String TAG = "ApolloActionHelper";
  public static boolean isCardPetLoaded = false;
  public static boolean isDrawerPetLoaded = false;
  
  static
  {
    FROM_DRAWER = 1;
    FROM_CARD = 2;
  }
  
  public static boolean attach3DInfoToJson(String paramString1, QQAppInterface paramQQAppInterface, JSONObject paramJSONObject, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloActionHelper", 2, "[attach3DInfoToJson], uin:" + paramString1);
    }
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString1)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloActionHelper", 2, "errInfo->null param.");
      }
      return false;
    }
    ApolloBaseInfo localApolloBaseInfo = ((ApolloManagerServiceImpl)paramQQAppInterface.getRuntimeService(IApolloManagerService.class, "all")).getApolloBaseInfo(paramString1);
    if (localApolloBaseInfo != null)
    {
      String str = paramString2;
      try
      {
        if (TextUtils.isEmpty(paramString2)) {
          str = getModelByUin(paramString1, paramQQAppInterface);
        }
        paramJSONObject.put("model", str);
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
        if (QLog.isColorLevel()) {
          QLog.d("cmshow_scripted_ApolloActionHelper", 2, "attach3DInfoToJson: obj3D:" + paramString1.toString());
        }
      }
      catch (Exception paramString1)
      {
        for (;;)
        {
          QLog.e("ApolloActionHelper", 1, "attach3DInfoToJson e=" + paramString1.toString());
        }
      }
      return true;
    }
    return false;
  }
  
  public static boolean checkBasicActionExit(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return false;
    }
    String[] arrayOfString = DEFAULT_ROLE_RSC_LIST;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      Object localObject = arrayOfString[i];
      localObject = new File(ApolloConstant.a + (String)localObject);
      if (!((File)localObject).exists())
      {
        QLog.d("ApolloActionHelper", 1, new Object[] { "[checkBasicActionExit] rsc file not exist:", ((File)localObject).toString() });
        ((IApolloResDownloader)QRoute.api(IApolloResDownloader.class)).downloadApolloResOrder(paramQQAppInterface, paramQQAppInterface.getCurrentUin(), null, 0, null, -1, -1, true);
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public static boolean checkDrawerBasicApolloAction(QQAppInterface paramQQAppInterface, int paramInt)
  {
    if (paramQQAppInterface == null) {
      return false;
    }
    return checkBasicActionExit(paramQQAppInterface);
  }
  
  public static boolean checkRoleDress(String paramString, QQAppInterface paramQQAppInterface, IApolloResDownloader.OnApolloDownLoadListener paramOnApolloDownLoadListener)
  {
    boolean bool = true;
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString)))
    {
      QLog.e("ApolloActionHelper", 1, "checkRoleDress " + paramString + paramQQAppInterface);
      bool = false;
      return bool;
    }
    Object localObject = (ApolloManagerServiceImpl)paramQQAppInterface.getRuntimeService(IApolloManagerService.class, "all");
    ApolloBaseInfo localApolloBaseInfo = ((ApolloManagerServiceImpl)localObject).getApolloBaseInfo(paramString);
    if (localApolloBaseInfo != null)
    {
      int i;
      if (ApolloUtilImpl.isApolloStatusOpen(localApolloBaseInfo))
      {
        if (localApolloBaseInfo.apolloLocalTS != localApolloBaseInfo.apolloServerTS)
        {
          QLog.i("ApolloActionHelper", 1, "[checkRoleDress]dress changed, uin:" + ((IApolloUtil)QRoute.api(IApolloUtil.class)).wrapLogUin(paramString));
          ((ApolloManagerServiceImpl)localObject).checkUserDress(paramQQAppInterface, paramString, "checkRoleDress");
        }
        localObject = localApolloBaseInfo.getApolloDress(false);
        if ((localObject != null) && (localObject.length > 0))
        {
          int j = localObject.length;
          i = 0;
          for (;;)
          {
            if (i >= j) {
              break label446;
            }
            localApolloBaseInfo = localObject[i];
            int[] arrayOfInt = localApolloBaseInfo.getDressIds();
            if (isRscValid(paramString, localApolloBaseInfo.roleId, arrayOfInt, paramQQAppInterface, paramOnApolloDownLoadListener))
            {
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.i("ApolloActionHelper", 2, "[checkRoleDress]user custom dress, uin:" + ((IApolloUtil)QRoute.api(IApolloUtil.class)).wrapLogUin(paramString));
              return true;
            }
            i += 1;
          }
        }
      }
      else
      {
        if (("-1".equals(paramString)) || ("-2".equals(paramString)))
        {
          localObject = paramString;
          if (!"-1".equals(localObject)) {
            break label402;
          }
        }
        label402:
        for (i = 1;; i = 2)
        {
          if (!isRscValid((String)localObject, i, ((IApolloResDownloader)QRoute.api(IApolloResDownloader.class)).readRoleDefaultDressIds(i), paramQQAppInterface, paramOnApolloDownLoadListener)) {
            break label446;
          }
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.i("ApolloActionHelper", 2, "[checkRoleDress]default dress, uin:" + ((IApolloUtil)QRoute.api(IApolloUtil.class)).wrapLogUin(paramString));
          return true;
          if (((IApolloUtil)QRoute.api(IApolloUtil.class)).isFemale(paramQQAppInterface, paramString)) {}
          for (localObject = "-2";; localObject = "-1") {
            break;
          }
        }
      }
    }
    else
    {
      QLog.e("ApolloActionHelper", 1, "[checkRoleDress]apolloBaseInfo is null, uin:" + ((IApolloUtil)QRoute.api(IApolloUtil.class)).wrapLogUin(paramString));
    }
    label446:
    QLog.e("ApolloActionHelper", 1, "[checkRoleDress]no dress, uin:" + ((IApolloUtil)QRoute.api(IApolloUtil.class)).wrapLogUin(paramString));
    return false;
  }
  
  public static void doActionReport(QQAppInterface paramQQAppInterface, SpriteTaskParam paramSpriteTaskParam, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloActionHelper", 2, "[doActionReport], isHasUsrText:" + paramBoolean1 + ",isBarrage:" + paramBoolean2);
    }
    if ((paramSpriteTaskParam == null) || (paramQQAppInterface == null)) {}
    ApolloActionData localApolloActionData;
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ApolloActionHelper", 2, "taskParam:" + paramSpriteTaskParam.toString());
      }
      localApolloActionData = ((ApolloDaoManagerServiceImpl)paramQQAppInterface.getRuntimeService(IApolloDaoManagerService.class, "all")).findActionById(paramSpriteTaskParam.f);
    } while (localApolloActionData == null);
    int i = 0;
    int j = paramSpriteTaskParam.j;
    String str6 = Integer.toString(paramSpriteTaskParam.f);
    if (paramBoolean1) {
      if (!paramBoolean2) {}
    }
    label899:
    for (String str4 = "2";; str4 = "0")
    {
      if (paramSpriteTaskParam.h == 0) {}
      label647:
      label905:
      label911:
      label917:
      for (String str3 = "action_play";; str3 = "")
      {
        label155:
        label173:
        String str5;
        if (paramSpriteTaskParam.g == 2) {
          if (paramSpriteTaskParam.a)
          {
            i = 2;
            if ((localApolloActionData.hasSound) || (paramSpriteTaskParam.i > 0)) {
              break label647;
            }
            str5 = "0";
            label193:
            if ((8 != paramSpriteTaskParam.c) || (TextUtils.isEmpty(paramSpriteTaskParam.jdField_d_of_type_JavaLangString))) {
              break label816;
            }
          }
        }
        for (;;)
        {
          String str2;
          try
          {
            String str1 = new JSONObject(paramSpriteTaskParam.jdField_d_of_type_JavaLangString).optString("subActionId", "0");
            VipUtils.a(paramQQAppInterface, "cmshow", "Apollo", "actionnewuser_play", paramSpriteTaskParam.b, i, j, new String[] { str6, "", "", String.valueOf(System.currentTimeMillis() / 1000L) });
            VipUtils.a(paramQQAppInterface, "cmshow", "Apollo", str3, i, j, new String[] { str6, str4, str5, str1 });
            if (QLog.isColorLevel()) {
              QLog.d("ApolloActionHelper", 2, "actionName:" + str3 + ",entry:" + i + ",result:" + j + ",r2:" + str6 + ",r3:" + str4 + ",r4:" + str5 + ",r5:" + str1);
            }
            paramQQAppInterface = new ApolloDtReportUtil.DtReportParamsBuilder();
            if (paramSpriteTaskParam.f <= ApolloConstant.b) {
              break label899;
            }
            i = 1;
            paramQQAppInterface = paramQQAppInterface.a(i).b(ApolloDtReportUtil.a(paramSpriteTaskParam.h));
            if (paramSpriteTaskParam.jdField_d_of_type_Int != 1) {
              break label905;
            }
            i = 2;
            paramQQAppInterface = paramQQAppInterface.c(i).e(ApolloDtReportUtil.a(localApolloActionData.personNum, paramSpriteTaskParam.c)).c(String.valueOf(paramSpriteTaskParam.f));
            if (paramSpriteTaskParam.g != 1) {
              break label911;
            }
            i = 1;
            ApolloDtReportUtil.a("aio_bubble", "apollo_msg", "play", paramQQAppInterface.d(i).b(ApolloDtReportUtil.a()).g(ApolloDtReportUtil.b(paramSpriteTaskParam.f)).a());
            return;
            str4 = "1";
            break;
            if (paramSpriteTaskParam.h == 1)
            {
              str3 = "g_action_play";
              break label155;
            }
            if (paramSpriteTaskParam.h != 3000) {
              break label917;
            }
            str3 = "d_action_play";
            break label155;
            i = 3;
            break label173;
            if (paramSpriteTaskParam.g == 0)
            {
              i = 0;
              break label173;
            }
            if (paramSpriteTaskParam.g == 1)
            {
              i = 1;
              break label173;
            }
            if (paramSpriteTaskParam.g != 4) {
              break label173;
            }
            i = 4;
            break label173;
            if ((1 == paramQQAppInterface.getALLGeneralSettingRing()) && (((CmShowAioMatcher.a(paramSpriteTaskParam.h, 2)) && (1 == paramQQAppInterface.getTroopGeneralSettingRing())) || ((CmShowAioMatcher.a(paramSpriteTaskParam.h, 1)) && (!paramQQAppInterface.isRingerVibrate()) && (!paramQQAppInterface.isRingEqualsZero()) && (paramQQAppInterface.isCallIdle()) && (!MediaPlayerManager.a(paramQQAppInterface).a()) && ((paramQQAppInterface.getCheckPttListener() == null) || (!paramQQAppInterface.getCheckPttListener().i())) && (!paramQQAppInterface.isVideoChatting()) && ((paramQQAppInterface.getCheckPtvListener() == null) || (!paramQQAppInterface.getCheckPtvListener().j())))))
            {
              str5 = "1";
              break label193;
            }
            str5 = "2";
          }
          catch (Exception localException)
          {
            QLog.e("ApolloActionHelper", 1, "[random] the json is not right," + paramSpriteTaskParam.jdField_d_of_type_JavaLangString);
            str2 = "-1";
            continue;
          }
          label816:
          if (getVibrateData(localApolloActionData.vibrate) == null)
          {
            str2 = "0";
          }
          else if ((1 == paramQQAppInterface.getALLGeneralSettingVibrate()) && (((paramSpriteTaskParam.h != 1) && (paramSpriteTaskParam.h != 3000)) || (((1 == paramQQAppInterface.getTroopGeneralSettingVibrate()) || (paramSpriteTaskParam.h == 0)) && (!paramQQAppInterface.isRingEqualsZero()))))
          {
            str2 = "1";
          }
          else
          {
            str2 = "2";
            continue;
            i = 0;
            continue;
            i = 0;
            continue;
            i = 0;
          }
        }
      }
    }
  }
  
  public static String get3DFaceDataByUin(String paramString, QQAppInterface paramQQAppInterface)
  {
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString))) {
      return null;
    }
    paramString = ((ApolloManagerServiceImpl)paramQQAppInterface.getRuntimeService(IApolloManagerService.class, "all")).getApolloBaseInfo(paramString);
    if (paramString != null)
    {
      paramString = paramString.getApolloDress3D();
      if (paramString != null) {
        return paramString.faceData;
      }
    }
    return null;
  }
  
  public static Object[] get3DRoleDressIdByUin(String paramString, int paramInt, QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString)) || (paramInt != 2))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloActionHelper", 2, new Object[] { "get3DRoleIdByUin errInfo->null param, userStatus:", Integer.valueOf(paramInt) });
      }
      return new Object[] { Integer.valueOf(-1), null };
    }
    Object localObject = ((ApolloManagerServiceImpl)paramQQAppInterface.getRuntimeService(IApolloManagerService.class, "all")).getApolloBaseInfo(paramString);
    if (localObject != null)
    {
      localObject = ((ApolloBaseInfo)localObject).getApolloDress3D();
      if (localObject != null)
      {
        paramInt = ((ApolloDress)localObject).roleId;
        localObject = ((ApolloDress)localObject).getDressIds();
        if ((paramInt > ApolloConstant.b) && (localObject != null) && (localObject.length > 0) && ((!paramBoolean) || (isRscValid(paramString, paramInt, (int[])localObject, paramQQAppInterface))))
        {
          if (QLog.isColorLevel()) {
            QLog.d("ApolloActionHelper", 2, new Object[] { "get3DRoleDressIdByUin valid role and dress RSC, needVerify:", Boolean.valueOf(paramBoolean) });
          }
          paramString = (String)localObject;
        }
      }
    }
    for (;;)
    {
      return new Object[] { Integer.valueOf(paramInt), paramString };
      paramString = null;
      paramInt = 0;
    }
  }
  
  public static String[] getActionLuaString(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloActionHelper", 2, new Object[] { "[getActionLuaString] apolloId=", paramString1, ", actionId=", Integer.valueOf(paramInt1), ", taskId=", Integer.valueOf(paramInt2), ", animName=", paramString3, ", actionRscName=", paramString2 });
    }
    String[] arrayOfString = new String[2];
    String str = paramString3;
    if (paramString2.contains("_peer")) {
      str = paramString3 + "_peer";
    }
    paramString3 = paramString2;
    if (paramString2.startsWith("action")) {
      paramString3 = paramString2.substring("action/".length());
    }
    arrayOfString[0] = String.format("setAccessoryAnimation(%s, '%s', '%s', '%s');", new Object[] { paramString1, paramString3, paramString3, str });
    if (QLog.isColorLevel()) {
      QLog.d("ApolloActionHelper", 2, arrayOfString[0]);
    }
    arrayOfString[1] = String.format("if(%s){%s.setAnimation(%d, '%s', false);}", new Object[] { paramString1, paramString1, Integer.valueOf(paramInt2), str });
    if (QLog.isColorLevel()) {
      QLog.d("ApolloActionHelper", 2, arrayOfString[1]);
    }
    return arrayOfString;
  }
  
  public static String[] getActionRscPath(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    return getActionRscPath(paramInt1, paramInt2, paramInt3, paramBoolean, 1);
  }
  
  public static String[] getActionRscPath(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, int paramInt4)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloActionHelper", 2, new Object[] { "[getActionRscPath], bid:" + paramInt1 + ",activeId:" + paramInt2 + ",roleId:" + paramInt3 + ",isActionMaker:" + paramBoolean, ",userStatus:", Integer.valueOf(paramInt4) });
    }
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramInt4 == 2)
    {
      paramInt4 = 1;
      switch (paramInt1)
      {
      case 3: 
      case 8: 
      case 9: 
      default: 
        paramInt3 = 1;
        paramInt4 = paramInt2;
        label177:
        if (paramInt3 != 0) {
          localStringBuilder.append("/");
        }
        localStringBuilder.append(paramInt4);
        if ((paramBoolean) || (paramInt2 < 21)) {
          if (localStringBuilder.indexOf("def/role/0/3D/") > -1) {
            localStringBuilder.append("/action");
          }
        }
        break;
      }
    }
    for (;;)
    {
      String str1 = localStringBuilder.toString();
      String str2 = Integer.toString(paramInt1) + "_" + Integer.toString(paramInt4);
      if (QLog.isColorLevel()) {
        QLog.d("ApolloActionHelper", 2, "action rsc path:" + localStringBuilder.toString() + ",actionId:" + paramInt4);
      }
      return new String[] { str1, str2 };
      paramInt4 = 0;
      break;
      paramInt3 = 0;
      paramInt4 = paramInt2;
      break label177;
      localStringBuilder.append("action");
      paramInt3 = 1;
      paramInt4 = paramInt2;
      break label177;
      if (paramInt4 != 0)
      {
        localStringBuilder.append("def/role/0/3D/");
        paramInt3 = 1;
        paramInt4 = paramInt2;
        break label177;
      }
      localStringBuilder.append("def/basic/action");
      paramInt3 = 1;
      paramInt4 = paramInt2;
      break label177;
      if (paramInt4 != 0) {
        localStringBuilder.append("def/role/0/3D/").append("sayhi");
      }
      for (;;)
      {
        paramInt3 = 1;
        paramInt4 = 1;
        break;
        localStringBuilder.append("def/basic/").append("sayhi");
      }
      localStringBuilder.append("def/role/0/3D/").append("sayhi");
      paramInt3 = 1;
      paramInt4 = 1;
      break label177;
      int i = getRandomActionId(paramInt3, "sayhi");
      if (-1 != i)
      {
        localStringBuilder.append("role/");
        localStringBuilder.append(paramInt3).append("/").append("sayhi");
        paramInt4 = i;
        paramInt3 = 1;
        break label177;
      }
      if (paramInt4 != 0)
      {
        localStringBuilder.append("def/role/0/3D/").append("sayhi");
        paramInt3 = 1;
        paramInt4 = 1;
        break label177;
      }
      localStringBuilder.append("def/basic/").append("sayhi");
      paramInt3 = 1;
      paramInt4 = 1;
      break label177;
      localStringBuilder.append("drawer_action/");
      paramInt3 = 1;
      paramInt4 = paramInt2;
      break label177;
      if (paramInt4 != 0)
      {
        localStringBuilder.append("def/role/0/3D/").append("friendcard");
        paramInt3 = 1;
        paramInt4 = paramInt2;
        break label177;
      }
      localStringBuilder.append("def/role/").append(0).append("/").append("friendcard");
      paramInt3 = 1;
      paramInt4 = paramInt2;
      break label177;
      if (paramInt4 != 0)
      {
        localStringBuilder.append("def/role/0/3D/").append("drawer");
        paramInt3 = 1;
        paramInt4 = paramInt2;
        break label177;
      }
      localStringBuilder.append("def/role/").append(0).append("/").append("drawer");
      paramInt3 = 1;
      paramInt4 = paramInt2;
      break label177;
      i = getRandomActionId(paramInt3, "interact");
      if (-1 != i)
      {
        localStringBuilder.append("role/");
        localStringBuilder.append(paramInt3).append("/").append("interact");
        paramInt4 = i;
        paramInt3 = 1;
        break label177;
      }
      if (paramInt4 != 0) {
        localStringBuilder.append("def/role/0/3D/").append("sayhi");
      }
      for (;;)
      {
        paramInt3 = 1;
        paramInt4 = 1;
        break;
        localStringBuilder.append("def/basic/").append("sayhi");
      }
      if (15 == paramInt1) {
        localStringBuilder.append("/panelAction");
      }
      localStringBuilder.append("/action/action");
      continue;
      if (15 == paramInt1) {
        localStringBuilder.append("/panelAction");
      }
      localStringBuilder.append("/action_peer/action");
    }
  }
  
  public static String[] getActionRscPathByPlayConfig(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, int paramInt4, PlayActionConfig paramPlayActionConfig)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloActionHelper", 2, new Object[] { "[getActionRscPath], bid:" + paramInt1 + ",activeId:" + paramInt2 + ",roleId:" + paramInt3 + ",isActionMaker:" + paramBoolean, ",userStatus:", Integer.valueOf(paramInt4) });
    }
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramInt4 == 2)
    {
      paramInt4 = 1;
      switch (paramInt1)
      {
      case 3: 
      case 8: 
      case 9: 
      default: 
        paramInt3 = 1;
        paramInt4 = paramInt2;
        label177:
        if (paramInt3 != 0) {
          localStringBuilder.append("/");
        }
        localStringBuilder.append(paramInt4);
        if ((paramBoolean) || (paramInt2 < 21)) {
          if (localStringBuilder.indexOf("def/role/0/3D/") > -1) {
            localStringBuilder.append("/action");
          }
        }
        break;
      }
    }
    for (;;)
    {
      paramPlayActionConfig = localStringBuilder.toString();
      String str = Integer.toString(paramInt1) + "_" + Integer.toString(paramInt4);
      if (QLog.isColorLevel()) {
        QLog.d("ApolloActionHelper", 2, "action rsc path:" + localStringBuilder.toString() + ",actionId:" + paramInt4);
      }
      return new String[] { paramPlayActionConfig, str };
      paramInt4 = 0;
      break;
      paramInt3 = 0;
      paramInt4 = paramInt2;
      break label177;
      localStringBuilder.append("action");
      paramInt3 = 1;
      paramInt4 = paramInt2;
      break label177;
      if (paramInt4 != 0)
      {
        localStringBuilder.append("def/role/0/3D/");
        paramInt3 = 1;
        paramInt4 = paramInt2;
        break label177;
      }
      localStringBuilder.append("def/basic/action");
      paramInt3 = 1;
      paramInt4 = paramInt2;
      break label177;
      if (paramInt4 != 0) {
        localStringBuilder.append("def/role/0/3D/").append("sayhi");
      }
      for (;;)
      {
        paramInt3 = 1;
        paramInt4 = 1;
        break;
        localStringBuilder.append("def/basic/").append("sayhi");
      }
      localStringBuilder.append("def/role/0/3D/").append("sayhi");
      paramInt3 = 1;
      paramInt4 = 1;
      break label177;
      int i = getRandomActionId(paramInt3, "sayhi");
      if (-1 != i)
      {
        localStringBuilder.append("role/");
        localStringBuilder.append(paramInt3).append("/").append("sayhi");
        paramInt4 = i;
        paramInt3 = 1;
        break label177;
      }
      if (paramInt4 != 0)
      {
        localStringBuilder.append("def/role/0/3D/").append("sayhi");
        paramInt3 = 1;
        paramInt4 = 1;
        break label177;
      }
      localStringBuilder.append("def/basic/").append("sayhi");
      paramInt3 = 1;
      paramInt4 = 1;
      break label177;
      localStringBuilder.append("drawer_action/");
      paramInt3 = 1;
      paramInt4 = paramInt2;
      break label177;
      if (paramInt4 != 0)
      {
        localStringBuilder.append("def/role/0/3D/").append("friendcard");
        paramInt3 = 1;
        paramInt4 = paramInt2;
        break label177;
      }
      localStringBuilder.append("def/role/").append(0).append("/").append("friendcard");
      paramInt3 = 1;
      paramInt4 = paramInt2;
      break label177;
      if (paramInt4 != 0)
      {
        localStringBuilder.append("def/role/0/3D/").append("drawer");
        paramInt3 = 1;
        paramInt4 = paramInt2;
        break label177;
      }
      localStringBuilder.append("def/role/").append(0).append("/").append("drawer");
      paramInt3 = 1;
      paramInt4 = paramInt2;
      break label177;
      i = getRandomActionId(paramInt3, "interact");
      if (-1 != i)
      {
        localStringBuilder.append("role/");
        localStringBuilder.append(paramInt3).append("/").append("interact");
        paramInt4 = i;
        paramInt3 = 1;
        break label177;
      }
      if (paramInt4 != 0) {
        localStringBuilder.append("def/role/0/3D/").append("sayhi");
      }
      for (;;)
      {
        paramInt3 = 1;
        paramInt4 = 1;
        break;
        localStringBuilder.append("def/basic/").append("sayhi");
      }
      if ((paramPlayActionConfig == null) || (paramPlayActionConfig.c == 0))
      {
        localStringBuilder.append("/action/action");
      }
      else if (paramPlayActionConfig.c == 1)
      {
        localStringBuilder.append("/action/pre/action/action");
      }
      else if (paramPlayActionConfig.c == 2)
      {
        localStringBuilder.append("/action/main/action/action");
      }
      else if (paramPlayActionConfig.c == 3)
      {
        localStringBuilder.append("/action/post/action/action");
      }
      else
      {
        localStringBuilder.append("/action/action");
        continue;
        if ((paramPlayActionConfig == null) || (paramPlayActionConfig.c == 0)) {
          localStringBuilder.append("/action_peer/action");
        } else if (paramPlayActionConfig.c == 1) {
          localStringBuilder.append("/action/pre/action_peer/action");
        } else if (paramPlayActionConfig.c == 2) {
          localStringBuilder.append("/action/main/action_peer/action");
        } else if (paramPlayActionConfig.c == 3) {
          localStringBuilder.append("/action/post/action_peer/action");
        } else {
          localStringBuilder.append("/action_peer/action");
        }
      }
    }
  }
  
  public static String getAddFrameScript()
  {
    return "if(\"undefined\" != typeof addFrame){addFrame();}else{if(renderTicker.paused){if(BK.Director.root){BK.Render.clear(0,0,0,0);BK.Render.treeRender( BK.Director.root,0);BK.Render.commit();}}}";
  }
  
  public static String getApolloRsc(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloActionHelper", 2, new Object[] { "[getApolloRsc],  rscType", Integer.valueOf(paramInt1), ",id:" + paramInt2 });
    }
    StringBuilder localStringBuilder = new StringBuilder();
    switch (paramInt1)
    {
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloActionHelper", 2, "rsc:" + localStringBuilder);
      }
      return localStringBuilder.toString();
      if (paramInt2 < 21) {
        localStringBuilder.append("def/basic/dress/");
      }
      localStringBuilder.append(paramInt2);
      localStringBuilder.append("/dress");
      continue;
      if (paramInt2 == 0) {
        localStringBuilder.append("def/basic/skeleton/");
      }
      localStringBuilder.append(paramInt2);
      localStringBuilder.append("/role");
    }
  }
  
  public static String[] getBackgroundRscPath(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("action/");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("/action_background/action");
    String str1 = "background__" + Integer.toString(paramInt);
    String str2 = localStringBuilder.toString();
    if (QLog.isColorLevel()) {
      QLog.d("ApolloActionHelper", 2, "action rsc path:" + localStringBuilder.toString() + ",actionName:" + str1);
    }
    return new String[] { str2, str1 };
  }
  
  public static String getBubbleLuaString(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloActionHelper", 2, "[getBubbleLuaString], apolloId:" + paramString1 + ",bubbleId" + paramInt1 + ",roleId:" + paramInt2);
    }
    String str = getBubbleRscName(paramInt2, paramInt1);
    paramString1 = String.format("setAccessoryWithInfo(%s, '%s', '%s', '%s');", new Object[] { paramString1, str, str, paramString2 });
    if (QLog.isColorLevel()) {
      QLog.d("ApolloActionHelper", 2, paramString1);
    }
    return paramString1;
  }
  
  public static String getBubbleRscName(int paramInt1, int paramInt2)
  {
    return getBubbleRscName(paramInt1, paramInt2, 1);
  }
  
  public static String getBubbleRscName(int paramInt1, int paramInt2, int paramInt3)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if ((paramInt1 == 0) || (!ApolloUtilImpl.isBubbleRscExist(paramInt1, paramInt2)))
    {
      localStringBuilder.append("def/role/");
      localStringBuilder.append(0);
    }
    for (;;)
    {
      localStringBuilder.append("/");
      localStringBuilder.append("Bubble");
      localStringBuilder.append("/");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append("/dress");
      return localStringBuilder.toString();
      localStringBuilder.append("role/");
      localStringBuilder.append(paramInt1);
    }
  }
  
  public static String[] getDressLuaString(String paramString, int[] paramArrayOfInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloActionHelper", 2, new Object[] { "[getDressLuaString] apolloId=", paramString });
    }
    if (paramArrayOfInt == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloActionHelper", 2, "[getDressLuaString] no dressId, abort");
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
        QLog.d("ApolloActionHelper", 2, new Object[] { "[getDressLuaString] scriptStr", Integer.valueOf(i), "=", arrayOfString[i] });
      }
      i += 1;
    }
    return arrayOfString;
  }
  
  public static String getFakePetShowScript(QQAppInterface paramQQAppInterface, boolean paramBoolean, float paramFloat1, float paramFloat2, float paramFloat3, String paramString)
  {
    paramQQAppInterface = ((ApolloManagerServiceImpl)paramQQAppInterface.getRuntimeService(IApolloManagerService.class, "all")).getApolloBaseInfo(paramString);
    if ((!paramBoolean) || (paramQQAppInterface == null)) {
      return "if(fake_pet){fake_pet.dispose();}";
    }
    paramString = paramQQAppInterface.getApolloPetDress();
    if ((!paramQQAppInterface.hasPet) || (paramString == null) || (paramString.dressMap == null) || (paramString.dressMap.isEmpty())) {
      return "if(fake_pet){fake_pet.dispose();}";
    }
    int i = 1;
    paramQQAppInterface = new StringBuilder();
    String str = getApolloRsc(0, paramString.roleId);
    if (!ApolloUtilImpl.isResourceDone(1, paramString.roleId)) {
      i = 0;
    }
    str = String.format("var fake_pet = loadAnimation('%s', '%s', '%s', %f, %f, %f, %f, %f, '%s','%s');", new Object[] { "fake_pet", str, str, Float.valueOf(1.0F), Float.valueOf(paramFloat3), Float.valueOf(0.0F), Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), "null", "null" });
    paramString = paramString.getDressIds();
    int k = paramString.length;
    paramQQAppInterface.append(str).append("\n");
    int j = 0;
    while (j < k)
    {
      str = getApolloRsc(1, paramString[j]);
      paramQQAppInterface.append(String.format("setAccessory(fake_pet, '%s', '%s');", new Object[] { str, str })).append("\n");
      if (!ApolloUtilImpl.isResourceDone(2, paramString[j])) {
        i = 0;
      }
      j += 1;
    }
    if (i != 0) {
      return paramQQAppInterface.toString();
    }
    return null;
  }
  
  public static String getInitViewScript(int paramInt1, int paramInt2, int paramInt3)
  {
    return "if(\"undefined\" != typeof comGlobalParam) { comGlobalParam.width=" + paramInt1 + ";comGlobalParam.vWidth=" + paramInt1 + ";comGlobalParam.vHeight=" + paramInt2 + ";if(comGlobalParam.height==0){comGlobalParam.height=" + paramInt3 + ";}}";
  }
  
  public static String getModelByUin(String paramString, QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloActionHelper", 2, "[getModelByUin], uin:" + paramString);
    }
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloActionHelper", 2, "errInfo->null param.");
      }
      return null;
    }
    if (((IApolloManagerService)paramQQAppInterface.getRuntimeService(IApolloManagerService.class, "all")).getCmShowStatus(paramQQAppInterface, paramString) == 2) {
      return "3D";
    }
    return "2D";
  }
  
  public static String getPetShowScript(QQAppInterface paramQQAppInterface, float paramFloat1, float paramFloat2, int paramInt, String paramString, float paramFloat3)
  {
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString))) {
      return null;
    }
    Object localObject1 = ((ApolloManagerServiceImpl)paramQQAppInterface.getRuntimeService(IApolloManagerService.class, "all")).getApolloBaseInfo(paramString);
    if (localObject1 == null) {
      return "if(pet){pet.dispose();}";
    }
    Object localObject2 = ((ApolloBaseInfo)localObject1).getApolloPetDress();
    if ((!((ApolloBaseInfo)localObject1).hasPet) || (localObject2 == null) || (((ApolloDress)localObject2).dressMap == null) || (((ApolloDress)localObject2).dressMap.isEmpty()))
    {
      isDrawerPetLoaded = false;
      isCardPetLoaded = false;
      return "if(pet){pet.dispose();}";
    }
    if (FROM_DRAWER == paramInt)
    {
      localObject1 = "drawerpetexposure";
      if (FROM_DRAWER != paramInt) {
        break label167;
      }
      i = 0;
    }
    for (;;)
    {
      VipUtils.a(null, "cmshow", "Apollo", (String)localObject1, 0, i, new String[] { String.valueOf(((ApolloDress)localObject2).roleId) });
      if ((FROM_CARD != paramInt) || (!isCardPetLoaded)) {
        break label191;
      }
      return null;
      localObject1 = "datapetexposure";
      break;
      label167:
      if (paramString.equals(paramQQAppInterface.getCurrentUin())) {
        i = 0;
      } else {
        i = 1;
      }
    }
    label191:
    if (FROM_CARD == paramInt) {
      isCardPetLoaded = true;
    }
    paramString = new StringBuilder();
    localObject1 = getApolloRsc(0, ((ApolloDress)localObject2).roleId);
    if (!ApolloUtilImpl.isResourceDone(1, ((ApolloDress)localObject2).roleId)) {}
    for (int i = 0;; i = 1)
    {
      localObject1 = String.format("var pet = loadAnimation('%s', '%s', '%s', %f, %f, %f, %f, %f, '%s','%s');", new Object[] { "pet", localObject1, localObject1, Float.valueOf(1.0F), Float.valueOf(paramFloat3), Float.valueOf(0.0F), Float.valueOf(30.0F + paramFloat1), Float.valueOf(paramFloat2), "null", "null" });
      localObject2 = ((ApolloDress)localObject2).getDressIds();
      int k = localObject2.length;
      paramString.append((String)localObject1).append("\n");
      int j = 0;
      if (j < k)
      {
        localObject1 = getApolloRsc(1, localObject2[j]);
        paramString.append(String.format("setAccessory(pet, '%s', '%s');", new Object[] { localObject1, localObject1 })).append("\n");
        if (ApolloUtilImpl.isResourceDone(2, localObject2[j])) {
          break label473;
        }
        i = 0;
      }
      label473:
      for (;;)
      {
        j += 1;
        break;
        if (i == 0) {
          ((ApolloExtensionHandlerImpl)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.APOLLO_EXTENSION_HANDLER)).a("SelfPetShow");
        }
        while (i != 0)
        {
          return paramString.toString();
          if (FROM_DRAWER == paramInt) {
            isDrawerPetLoaded = true;
          }
        }
        return null;
      }
    }
  }
  
  public static int getRandomActionId(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloActionHelper", 2, "[getRandomActionId], roleId:" + paramInt);
    }
    paramString = new File("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/role/", paramInt + "/" + paramString + "/");
    if (!paramString.exists()) {}
    for (;;)
    {
      return -1;
      Object localObject = paramString.list();
      if ((localObject == null) || (localObject.length == 0))
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("ApolloActionHelper", 2, "no any action file.");
        return -1;
      }
      int i = PngFrameUtil.a(localObject.length);
      if ((i >= localObject.length) || (i < 0)) {
        continue;
      }
      localObject = localObject[i];
      try
      {
        int j = Integer.parseInt((String)localObject);
        if (paramInt >= ApolloConstant.b) {
          if (!ApolloUtilImpl.isFileExistAndLenNot0(paramString.getAbsolutePath() + "/" + (String)localObject + "/action/" + "action.bin")) {
            continue;
          }
        }
        for (;;)
        {
          return j;
          if ((!ApolloUtilImpl.isFileExistAndLenNot0(paramString.getAbsolutePath() + "/" + (String)localObject + "/" + "action/action.json")) || (!ApolloUtilImpl.isFileExistAndLenNot0(paramString.getAbsolutePath() + "/" + (String)localObject + "/" + "action/action.png")) || (!ApolloUtilImpl.isFileExistAndLenNot0(paramString.getAbsolutePath() + "/" + (String)localObject + "/" + "action/action.atlas"))) {
            break;
          }
          if (QLog.isColorLevel()) {
            QLog.d("ApolloActionHelper", 2, "value:" + i + ",actionId:" + (String)localObject);
          }
        }
        return -1;
      }
      catch (NumberFormatException paramString) {}
    }
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
  
  public static String getRemoveActionLuaString(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloActionHelper", 2, "[getRemoveActionLuaString], roleType:" + paramInt + ",actionName" + paramString);
    }
    if (2 == paramInt) {}
    for (String str = "friend";; str = "me")
    {
      paramString = String.format("if(%s) {%s.removeAccessoryAnimation('%s')}; ", new Object[] { str, str, paramString });
      if (QLog.isColorLevel()) {
        QLog.d("ApolloActionHelper", 2, paramString);
      }
      return paramString;
    }
  }
  
  public static String getRemoveBubbleLuaString(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloActionHelper", 2, "[getRemoveBubbleLuaString], apolloId:" + paramString1 + ",bubbleName" + paramString2);
    }
    paramString1 = String.format("if(%s) {%s.removeAccessory('%s')};", new Object[] { paramString1, paramString1, paramString2 });
    if (QLog.isColorLevel()) {
      QLog.d("ApolloActionHelper", 2, paramString1);
    }
    return paramString1;
  }
  
  public static String getResAddPrefixPath(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {
      localObject = null;
    }
    do
    {
      return localObject;
      localObject = paramString;
    } while (paramString.contains("def"));
    Object localObject = new StringBuilder();
    switch (paramInt)
    {
    }
    for (;;)
    {
      ((StringBuilder)localObject).append("//").append(paramString);
      return ((StringBuilder)localObject).toString();
      ((StringBuilder)localObject).append("ActionRes:");
      continue;
      ((StringBuilder)localObject).append("Dress:");
      continue;
      ((StringBuilder)localObject).append("Role:");
    }
  }
  
  public static Object[] getRoleDressIdByUin(String paramString, QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloActionHelper", 2, "[getRoldIdByUin], uin:" + paramString);
    }
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloActionHelper", 2, "errInfo->null param.");
      }
      return null;
    }
    Object localObject2 = ((IApolloResDownloader)QRoute.api(IApolloResDownloader.class)).readRoleDefaultDressIds(0);
    Object localObject1;
    int i;
    if (("-1".equals(paramString)) || ("-2".equals(paramString)))
    {
      localObject1 = paramString;
      if (!"-1".equals(localObject1)) {
        break label286;
      }
      i = 1;
      label111:
      localObject3 = ((IApolloResDownloader)QRoute.api(IApolloResDownloader.class)).readRoleDefaultDressIds(i);
      if ((paramBoolean) && (!isRscValid((String)localObject1, i, (int[])localObject3, paramQQAppInterface))) {
        break label291;
      }
      localObject1 = localObject3;
    }
    int j;
    for (;;)
    {
      localObject3 = (ApolloManagerServiceImpl)paramQQAppInterface.getRuntimeService(IApolloManagerService.class, "all");
      localObject2 = ((ApolloManagerServiceImpl)localObject3).getApolloBaseInfo(paramString);
      if (localObject2 == null) {
        break label775;
      }
      j = ((ApolloBaseInfo)localObject2).apolloStatus;
      if (QLog.isColorLevel()) {
        QLog.d("ApolloActionHelper", 2, "uin: " + ((ApolloBaseInfo)localObject2).uin + ", funcSwitch:" + j);
      }
      if (ApolloUtilImpl.isApolloStatusOpen((ApolloBaseInfo)localObject2)) {
        break label339;
      }
      return new Object[] { Integer.valueOf(i), localObject1 };
      if (((IApolloUtil)QRoute.api(IApolloUtil.class)).isFemale(paramQQAppInterface, paramString)) {}
      for (localObject1 = "-2";; localObject1 = "-1") {
        break;
      }
      label286:
      i = 2;
      break label111;
      label291:
      if (QLog.isColorLevel()) {
        QLog.d("ApolloActionHelper", 2, new Object[] { "role and dress is not ready,uin:", paramString, ",roleId:", Integer.valueOf(0) });
      }
      localObject1 = localObject2;
      i = 0;
    }
    label339:
    if ((paramBoolean) && (((ApolloBaseInfo)localObject2).apolloLocalTS != ((ApolloBaseInfo)localObject2).apolloServerTS))
    {
      QLog.i("ApolloActionHelper", 1, "dress changed, uin:" + ((IApolloUtil)QRoute.api(IApolloUtil.class)).wrapLogUin(paramString));
      ((ApolloManagerServiceImpl)localObject3).checkUserDress(paramQQAppInterface, paramString, "getRoleDressIdByUin");
    }
    Object localObject3 = ((ApolloBaseInfo)localObject2).getApolloDress(false);
    if ((localObject3 != null) && (localObject3.length > 0))
    {
      int k = localObject3.length;
      j = 0;
      if (j >= k) {
        break label858;
      }
      Object localObject4 = localObject3[j];
      localObject2 = localObject4.getDressIds();
      if (isRscValid(paramString, localObject4.roleId, (int[])localObject2, paramQQAppInterface))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ApolloActionHelper", 2, "valid role and dress RSC.");
        }
        i = localObject4.roleId;
        j = 1;
        localObject1 = localObject2;
      }
    }
    for (;;)
    {
      if (j == 0)
      {
        localObject2 = ((IApolloResDownloader)QRoute.api(IApolloResDownloader.class)).readRoleDefaultDressIds(localObject3[0].roleId);
        if (isRscValid(paramString, localObject3[0].roleId, (int[])localObject2, paramQQAppInterface))
        {
          if (QLog.isColorLevel()) {
            QLog.d("ApolloActionHelper", 2, "valid basic dress.");
          }
          j = localObject3[0].roleId;
          paramString = (String)localObject2;
          i = j;
          if (QLog.isColorLevel())
          {
            QLog.d("ApolloActionHelper", 2, "current dress NOT downloaded, check basic dress");
            i = j;
            paramString = (String)localObject2;
          }
          label592:
          j = i;
          paramQQAppInterface = paramString;
        }
      }
      label775:
      for (;;)
      {
        label597:
        if (QLog.isColorLevel())
        {
          paramString = new StringBuilder();
          paramString.append("******roleId:[");
          paramString.append(j);
          paramString.append("],");
          paramString.append("dress:[");
          i = 0;
          for (;;)
          {
            if (i < paramQQAppInterface.length)
            {
              if (i != 0) {
                paramString.append(",");
              }
              paramString.append(paramQQAppInterface[i]);
              i += 1;
              continue;
              if (QLog.isColorLevel()) {
                QLog.d("ApolloActionHelper", 2, "try to get history dress ....");
              }
              j += 1;
              break;
              SpriteUtil.a(110, new Object[] { "basicDresses is not vaild" });
              paramString = (String)localObject1;
              break label592;
              paramQQAppInterface = (QQAppInterface)localObject1;
              j = i;
              if (!QLog.isColorLevel()) {
                break label597;
              }
              QLog.d("ApolloActionHelper", 2, "uin: " + paramString + " dress is null");
              paramQQAppInterface = (QQAppInterface)localObject1;
              j = i;
              break label597;
              paramQQAppInterface = (QQAppInterface)localObject1;
              j = i;
              if (!QLog.isColorLevel()) {
                break label597;
              }
              QLog.d("ApolloActionHelper", 2, "warning: apolloBaseInfo or apolloBaseInfo.apolloDress is NULL, fail to get role info. apolloBaseInfo:" + localObject2);
              paramQQAppInterface = (QQAppInterface)localObject1;
              j = i;
              break label597;
            }
          }
          paramString.append("]****");
          QLog.d("ApolloActionHelper", 2, paramString.toString());
        }
      }
      return new Object[] { Integer.valueOf(j), paramQQAppInterface };
      label858:
      j = 0;
    }
  }
  
  public static String getRoleLuaString(String paramString, int paramInt, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloActionHelper", 2, new Object[] { "[getRoleLuaString] apolloId=", paramString, ", roleId=", Integer.valueOf(paramInt) });
    }
    String str = getApolloRsc(0, paramInt);
    float f = 0.0F;
    if ("friend".equals(paramString)) {
      f = 180.0F;
    }
    paramString = String.format("var %s = loadAnimation('%s', '%s', '%s', %f, %f, %f, %f, %f, '%s','%s');if(%s){%s.openAABBCallback()}", new Object[] { paramString, paramString, str, str, Float.valueOf(1.0F), Float.valueOf(paramFloat1), Float.valueOf(f), Float.valueOf(paramFloat2), Float.valueOf(paramFloat3), "null", "null", paramString, paramString });
    if (QLog.isColorLevel()) {
      QLog.d("ApolloActionHelper", 2, new Object[] { "[getRoleLuaString] scriptStr=", paramString });
    }
    return paramString;
  }
  
  public static String getTickerPauseString()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloActionHelper", 2, "[getTickerPauseString]");
    }
    return "BK.Director.tickerPause();";
  }
  
  public static long[] getVibrateData(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    long[] arrayOfLong;
    for (;;)
    {
      return null;
      paramString = paramString.split(",");
      if ((paramString != null) && (paramString.length != 0))
      {
        arrayOfLong = new long[paramString.length];
        i = 0;
        try
        {
          while (i < paramString.length)
          {
            arrayOfLong[i] = Integer.parseInt(paramString[i].trim());
            i += 1;
          }
          if (!QLog.isColorLevel()) {}
        }
        catch (NumberFormatException paramString) {}
      }
    }
    QLog.d("ApolloActionHelper", 2, "errInfo->NumberFormatException, e:" + paramString.getMessage());
    return null;
    int i = paramString.length - 2;
    while (i >= 2)
    {
      arrayOfLong[i] = (arrayOfLong[i] - arrayOfLong[(i - 1)] - arrayOfLong[(i - 2)]);
      i -= 2;
    }
    return arrayOfLong;
  }
  
  public static String[] getWhiteFaceRscPath(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt1).append("/action");
    if (paramBoolean2) {
      localStringBuilder.append("/group");
    }
    switch (paramInt2)
    {
    default: 
      if (paramBoolean1) {
        localStringBuilder.append("/action/action");
      }
      break;
    }
    for (;;)
    {
      String str1 = localStringBuilder.toString();
      String str2 = "whiteface_" + Integer.toString(paramInt2) + "_" + Integer.toString(paramInt1);
      if (QLog.isColorLevel()) {
        QLog.d("ApolloActionHelper", 2, "[whiteface] path:" + localStringBuilder.toString() + ",actionId:" + paramInt1);
      }
      return new String[] { str1, str2 };
      localStringBuilder.append("/pre");
      break;
      localStringBuilder.append("/main");
      break;
      localStringBuilder.append("/post");
      break;
      localStringBuilder.append("/action_peer/action");
    }
  }
  
  public static boolean isRscValid(String paramString, int paramInt, int[] paramArrayOfInt, QQAppInterface paramQQAppInterface)
  {
    return isRscValid(paramString, paramInt, paramArrayOfInt, paramQQAppInterface, null);
  }
  
  public static boolean isRscValid(String paramString, int paramInt, int[] paramArrayOfInt, QQAppInterface paramQQAppInterface, IApolloResDownloader.OnApolloDownLoadListener paramOnApolloDownLoadListener)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloActionHelper", 2, "[isRscValid], roleId:" + paramInt + ",dressId:" + paramArrayOfInt);
    }
    if (paramArrayOfInt == null) {
      return false;
    }
    int[] arrayOfInt = null;
    ArrayList localArrayList = new ArrayList();
    boolean bool = true;
    if (!ApolloUtilImpl.checkRoleRes(paramInt))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloActionHelper", 2, "need download role id:" + paramInt);
      }
      bool = false;
    }
    for (;;)
    {
      int i = 0;
      if (i < paramArrayOfInt.length)
      {
        if (ApolloUtilImpl.checkDressRes(paramArrayOfInt[i])) {
          break label339;
        }
        localArrayList.add(Integer.valueOf(paramArrayOfInt[i]));
        if (QLog.isColorLevel()) {
          QLog.d("ApolloActionHelper", 2, "need download dress id:" + paramArrayOfInt[i]);
        }
        bool = false;
      }
      label336:
      label339:
      for (;;)
      {
        i += 1;
        break;
        if (!bool)
        {
          paramArrayOfInt = arrayOfInt;
          if (localArrayList.size() > 0)
          {
            arrayOfInt = new int[localArrayList.size()];
            i = 0;
            for (;;)
            {
              paramArrayOfInt = arrayOfInt;
              if (i >= localArrayList.size()) {
                break;
              }
              arrayOfInt[i] = ((Integer)localArrayList.get(i)).intValue();
              i += 1;
            }
          }
          if (paramQQAppInterface != null)
          {
            if (paramOnApolloDownLoadListener != null) {
              break label336;
            }
            paramOnApolloDownLoadListener = ((ApolloManagerServiceImpl)paramQQAppInterface.getRuntimeService(IApolloManagerService.class, "all")).getResDownloadListener();
          }
        }
        for (;;)
        {
          ((IApolloResDownloader)QRoute.api(IApolloResDownloader.class)).downloadApolloResOrder(paramQQAppInterface, paramString, paramOnApolloDownLoadListener, paramInt, paramArrayOfInt, -1, -1, false);
          if (QLog.isColorLevel()) {
            QLog.d("ApolloActionHelper", 2, "ret:" + bool);
          }
          return bool;
        }
      }
      paramInt = -1;
    }
  }
  
  public static void printAudioCondition(ApolloActionData paramApolloActionData, QQAppInterface paramQQAppInterface)
  {
    if ((paramApolloActionData == null) || (paramQQAppInterface == null)) {
      if (!QLog.isColorLevel()) {}
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    return;
                    if (paramApolloActionData.hasSound) {
                      break;
                    }
                  } while (!QLog.isColorLevel());
                  QLog.d("audio_switch", 2, "NO sound config.");
                  return;
                  if (1 == paramQQAppInterface.getALLGeneralSettingRing()) {
                    break;
                  }
                } while (!QLog.isColorLevel());
                QLog.d("audio_switch", 2, "getALLGeneralSettingRing == 1");
                return;
                if (!paramQQAppInterface.isRingerVibrate()) {
                  break;
                }
              } while (!QLog.isColorLevel());
              QLog.d("audio_switch", 2, "isRingerVibrate == true");
              return;
              if (paramQQAppInterface.isCallIdle()) {
                break;
              }
            } while (!QLog.isColorLevel());
            QLog.d("audio_switch", 2, "isCallIdle == false");
            return;
            if (!MediaPlayerManager.a(paramQQAppInterface).a()) {
              break;
            }
          } while (!QLog.isColorLevel());
          QLog.d("audio_switch", 2, "ptt is playing");
          return;
          if ((paramQQAppInterface.getCheckPttListener() == null) || (!paramQQAppInterface.getCheckPttListener().i())) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d("audio_switch", 2, "isRecordingOrPlaying == true");
        return;
        if ((paramQQAppInterface.getCheckPtvListener() == null) || (!paramQQAppInterface.getCheckPtvListener().j())) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("audio_switch", 2, "isPTVRecording == true");
      return;
      if (!paramQQAppInterface.isVideoChatting()) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("audio_switch", 2, "isVideoChatting == true");
    return;
    QLog.d("audio_switch", 2, "CM sound can be played now.");
  }
  
  /* Error */
  public static String readFileByLine(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aconst_null
    //   3: astore_3
    //   4: aconst_null
    //   5: astore 4
    //   7: new 1060	java/lang/StringBuffer
    //   10: dup
    //   11: ldc_w 380
    //   14: invokespecial 1061	java/lang/StringBuffer:<init>	(Ljava/lang/String;)V
    //   17: astore 5
    //   19: new 1063	java/io/FileReader
    //   22: dup
    //   23: aload_0
    //   24: invokespecial 1064	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   27: astore_0
    //   28: aload_0
    //   29: astore_1
    //   30: aload_3
    //   31: astore_2
    //   32: new 1066	java/io/BufferedReader
    //   35: dup
    //   36: aload_0
    //   37: invokespecial 1069	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   40: astore_3
    //   41: aload_3
    //   42: invokevirtual 1072	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   45: astore_1
    //   46: aload_1
    //   47: ifnull +61 -> 108
    //   50: aload 5
    //   52: aload_1
    //   53: invokevirtual 1075	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   56: pop
    //   57: aload 5
    //   59: ldc_w 1077
    //   62: invokevirtual 1075	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   65: pop
    //   66: goto -25 -> 41
    //   69: astore_1
    //   70: aload_3
    //   71: astore 4
    //   73: aload_1
    //   74: astore_3
    //   75: aload_0
    //   76: astore_1
    //   77: aload 4
    //   79: astore_2
    //   80: aload_3
    //   81: invokevirtual 1080	java/lang/Exception:printStackTrace	()V
    //   84: aload 4
    //   86: ifnull +8 -> 94
    //   89: aload 4
    //   91: invokevirtual 1083	java/io/BufferedReader:close	()V
    //   94: aload_0
    //   95: ifnull +7 -> 102
    //   98: aload_0
    //   99: invokevirtual 1084	java/io/FileReader:close	()V
    //   102: aload 5
    //   104: invokevirtual 1085	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   107: areturn
    //   108: aload_3
    //   109: ifnull +7 -> 116
    //   112: aload_3
    //   113: invokevirtual 1083	java/io/BufferedReader:close	()V
    //   116: aload_0
    //   117: ifnull -15 -> 102
    //   120: aload_0
    //   121: invokevirtual 1084	java/io/FileReader:close	()V
    //   124: goto -22 -> 102
    //   127: astore_0
    //   128: aload_0
    //   129: invokevirtual 1080	java/lang/Exception:printStackTrace	()V
    //   132: goto -30 -> 102
    //   135: astore_0
    //   136: aload_0
    //   137: invokevirtual 1080	java/lang/Exception:printStackTrace	()V
    //   140: goto -38 -> 102
    //   143: astore_3
    //   144: aconst_null
    //   145: astore_0
    //   146: aload_2
    //   147: ifnull +7 -> 154
    //   150: aload_2
    //   151: invokevirtual 1083	java/io/BufferedReader:close	()V
    //   154: aload_0
    //   155: ifnull +7 -> 162
    //   158: aload_0
    //   159: invokevirtual 1084	java/io/FileReader:close	()V
    //   162: aload_3
    //   163: athrow
    //   164: astore_0
    //   165: aload_0
    //   166: invokevirtual 1080	java/lang/Exception:printStackTrace	()V
    //   169: goto -7 -> 162
    //   172: astore_3
    //   173: aload_1
    //   174: astore_0
    //   175: goto -29 -> 146
    //   178: astore_1
    //   179: aload_3
    //   180: astore_2
    //   181: aload_1
    //   182: astore_3
    //   183: goto -37 -> 146
    //   186: astore_3
    //   187: aconst_null
    //   188: astore_0
    //   189: goto -114 -> 75
    //   192: astore_3
    //   193: goto -118 -> 75
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	196	0	paramString	String
    //   29	24	1	str1	String
    //   69	5	1	localException1	Exception
    //   76	98	1	str2	String
    //   178	4	1	localObject1	Object
    //   1	180	2	localObject2	Object
    //   3	110	3	localObject3	Object
    //   143	20	3	localObject4	Object
    //   172	8	3	localObject5	Object
    //   182	1	3	localObject6	Object
    //   186	1	3	localException2	Exception
    //   192	1	3	localException3	Exception
    //   5	85	4	localObject7	Object
    //   17	86	5	localStringBuffer	java.lang.StringBuffer
    // Exception table:
    //   from	to	target	type
    //   41	46	69	java/lang/Exception
    //   50	66	69	java/lang/Exception
    //   112	116	127	java/lang/Exception
    //   120	124	127	java/lang/Exception
    //   89	94	135	java/lang/Exception
    //   98	102	135	java/lang/Exception
    //   19	28	143	finally
    //   150	154	164	java/lang/Exception
    //   158	162	164	java/lang/Exception
    //   32	41	172	finally
    //   80	84	172	finally
    //   41	46	178	finally
    //   50	66	178	finally
    //   19	28	186	java/lang/Exception
    //   32	41	192	java/lang/Exception
  }
  
  public int getApolloFuncSwitch(String paramString, QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloActionHelper", 2, "[getApolloFuncSwitch], uin:" + paramString);
    }
    paramString = ((ApolloManagerServiceImpl)paramQQAppInterface.getRuntimeService(IApolloManagerService.class, "all")).getApolloBaseInfoFromCache(paramString);
    if (paramString == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloActionHelper", 2, "apolloBaseInfo is null. ret closed status");
      }
      return 2;
    }
    return paramString.apolloStatus;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.uitls.impl.ApolloActionHelperImpl
 * JD-Core Version:    0.7.0.1
 */