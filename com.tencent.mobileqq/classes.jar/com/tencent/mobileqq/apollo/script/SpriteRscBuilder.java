package com.tencent.mobileqq.apollo.script;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.api.impl.ApolloManagerServiceImpl;
import com.tencent.mobileqq.apollo.handler.ApolloContentUpdateHandler;
import com.tencent.mobileqq.apollo.handler.ApolloExtensionHandler;
import com.tencent.mobileqq.apollo.model.ApolloActionData;
import com.tencent.mobileqq.apollo.model.ApolloBaseInfo;
import com.tencent.mobileqq.apollo.persistence.api.IApolloDaoManagerService;
import com.tencent.mobileqq.apollo.persistence.api.impl.ApolloDaoManagerServiceImpl;
import com.tencent.mobileqq.apollo.utils.api.IApolloUtil;
import com.tencent.mobileqq.apollo.utils.api.impl.ApolloActionHelperImpl;
import com.tencent.mobileqq.apollo.utils.api.impl.ApolloUtilImpl;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.cmshow.engine.action.PlayActionScript;
import com.tencent.mobileqq.cmshow.engine.resource.ApolloResManagerFacade;
import com.tencent.mobileqq.cmshow.engine.resource.IApolloResDownloader;
import com.tencent.mobileqq.cmshow.engine.resource.IApolloResManager;
import com.tencent.mobileqq.cmshow.engine.scene.Scene;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.List<Ljava.lang.String;>;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.util.LogUtil;
import org.json.JSONArray;
import org.json.JSONObject;

@Deprecated
public class SpriteRscBuilder
{
  private static Map<String, Integer> d = new HashMap();
  Map<String, Integer> a = new HashMap();
  private SpriteContext b;
  private IApolloResManager c;
  private Map<String, Long> e = new HashMap();
  private int f = -1;
  private int g = -1;
  
  public SpriteRscBuilder(SpriteContext paramSpriteContext)
  {
    this.b = paramSpriteContext;
    paramSpriteContext = this.b;
    if (paramSpriteContext != null) {
      this.c = paramSpriteContext.q();
    }
  }
  
  private SpriteTaskParam a(SpriteRscBuilder.ApolloAppearAction paramApolloAppearAction)
  {
    SpriteTaskParam localSpriteTaskParam = new SpriteTaskParam();
    if (paramApolloAppearAction == null)
    {
      localSpriteTaskParam.f = 4;
      localSpriteTaskParam.v = 2;
      localSpriteTaskParam.g = 5;
      localSpriteTaskParam.h = 1000000L;
      return localSpriteTaskParam;
    }
    localSpriteTaskParam.a = 1;
    localSpriteTaskParam.f = paramApolloAppearAction.a;
    localSpriteTaskParam.v = 12;
    localSpriteTaskParam.g = 5;
    localSpriteTaskParam.h = 1000000L;
    if (paramApolloAppearAction.b == 4) {
      localSpriteTaskParam.c = 7;
    }
    return localSpriteTaskParam;
  }
  
  public static String a(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((!ApolloUtilImpl.isBubbleRscExist(paramInt1, paramInt2)) && (!ApolloUtilImpl.isBubbleRscExist(0, paramInt2))) {
      return "";
    }
    return ApolloActionHelperImpl.getBubbleRscName(paramInt1, paramInt2, paramInt3);
  }
  
  public static String a(int paramInt, IApolloResManager paramIApolloResManager)
  {
    if ((ApolloUtilImpl.getQQApp() != null) && (paramIApolloResManager != null))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      paramInt = ((ApolloManagerServiceImpl)ApolloUtilImpl.getQQApp().getRuntimeService(IApolloManagerService.class, "all")).getPetRandomAction(paramInt);
      if ((paramInt != -1) && (!paramIApolloResManager.c(paramInt, 0)))
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
        Object localObject1 = paramIApolloResManager.a((ApolloActionData)localObject2, 5);
        localObject2 = paramIApolloResManager.a((ApolloActionData)localObject2, 4);
        paramIApolloResManager.a().a(ApolloUtilImpl.getQQApp(), (String)localObject2, (String)localObject1);
      }
      else if (paramInt != -1)
      {
        localStringBuilder.append(paramInt);
        localStringBuilder.append("/action/action");
      }
      return localStringBuilder.toString();
    }
    QLog.e("[cmshow]ApolloPet", 1, "getPetRandomActionPath return, invalid params!");
    return null;
  }
  
  public static String a(int paramInt, String paramString, IApolloResManager paramIApolloResManager)
  {
    if ((ApolloUtilImpl.getQQApp() != null) && (!TextUtils.isEmpty(paramString)) && (paramIApolloResManager != null))
    {
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
            if (paramIApolloResManager.c(paramInt, 0))
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
            paramIApolloResManager.a(paramString, 4, null);
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
    QLog.e("[cmshow]ApolloPet", 1, "getPetBasicActions return, invalid params!");
    return null;
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
      QLog.d("[cmshow][scripted]SpriteRscBuilder", 2, new Object[] { "getNicknamePath uin:", LogUtil.wrapLogUin(paramString), ", isMe:", Boolean.valueOf(bool2), ",isYellowVip:", Boolean.valueOf(bool1), ",isRight:", Boolean.valueOf(paramBoolean), ",bubbleId:", Integer.valueOf(i) });
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
            break label133;
          }
          if (!paramBoolean) {
            break label126;
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
      label126:
      paramString = "namePlateIdLeft";
      continue;
      label133:
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
        IApolloResManager localIApolloResManager = ApolloResManagerFacade.a.a(Scene.WEB_STORE_OR_GAME);
        int i = 0;
        int j = 0;
        if (i < localJSONArray2.length())
        {
          paramJSONObject = localJSONArray2.getJSONObject(i);
          if (paramJSONObject == null) {
            break label518;
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
                break label518;
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
          bool2 = localIApolloResManager.c(k, paramJSONObject.personNum);
          if (bool2) {
            break label521;
          }
          bool1 = localIApolloResManager.a(paramJSONObject, 4, null);
          if (!QLog.isColorLevel()) {
            break label527;
          }
          QLog.d("[cmshow][scripted]SpriteRscBuilder", 2, new Object[] { "ReqAction,isActionDone:", Boolean.valueOf(bool2), ",ret:", Boolean.valueOf(bool1) });
          break label527;
          label376:
          Object localObject = new JSONObject();
          String[] arrayOfString = ApolloActionHelperImpl.getActionRscPath(1, k, 0, true);
          ((JSONObject)localObject).put("actionId", k);
          ((JSONObject)localObject).put("actionPath", ApolloActionHelperImpl.getResAddPrefixPath(arrayOfString[0], 3));
          if (paramJSONObject.personNum == 1) {
            ((JSONObject)localObject).put("peerPath", ApolloActionHelperImpl.getResAddPrefixPath(ApolloActionHelperImpl.getActionRscPath(1, k, 0, false)[0], 3));
          }
          localJSONArray1.put(localObject);
          if (!QLog.isColorLevel()) {
            break label518;
          }
          QLog.d("[cmshow][scripted]SpriteRscBuilder", 2, new Object[] { "ReqAction,put into array, id:", Integer.valueOf(k) });
          label492:
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
      label518:
      label521:
      label527:
      do
      {
        break label492;
        bool1 = false;
        break;
        if (bool2) {
          break label376;
        }
      } while (!bool1);
    }
  }
  
  private SpriteRscBuilder.ApolloAppearAction b(QQAppInterface paramQQAppInterface, String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramQQAppInterface != null))
    {
      int i;
      if (this.a.containsKey(paramString)) {
        i = ((Integer)this.a.get(paramString)).intValue();
      } else {
        i = 0;
      }
      Object localObject2 = (ApolloManagerServiceImpl)this.b.l().getRuntimeService(IApolloManagerService.class, "all");
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
        ((SpriteRscBuilder.ApolloAppearAction)localObject2).b = ((JSONObject)localObject3).getInt("type");
        ((SpriteRscBuilder.ApolloAppearAction)localObject2).a = ((JSONObject)localObject3).getInt("id");
        localObject3 = ((ApolloDaoManagerServiceImpl)localObject1).getApolloBaseInfo(paramString);
        if (localObject3 == null) {
          return null;
        }
        if ((((SpriteRscBuilder.ApolloAppearAction)localObject2).b == 4) && (!((ApolloBaseInfo)localObject3).hasPet))
        {
          ((ApolloBaseInfo)localObject3).appearAction = null;
          ((ApolloDaoManagerServiceImpl)localObject1).saveOrUpdateApolloBaseInfo((ApolloBaseInfo)localObject3);
          return null;
        }
        if (QLog.isColorLevel()) {
          QLog.d("[cmshow][scripted]SpriteRscBuilder", 2, new Object[] { "[hasAppearAction] index:", Integer.valueOf(j), ",id:", Integer.valueOf(((SpriteRscBuilder.ApolloAppearAction)localObject2).a), ",standType:", Integer.valueOf(((SpriteRscBuilder.ApolloAppearAction)localObject2).b) });
        }
        if (((SpriteRscBuilder.ApolloAppearAction)localObject2).a <= 0)
        {
          QLog.e("[cmshow][scripted]SpriteRscBuilder", 1, new Object[] { "appearAction not correct,actionId:", Integer.valueOf(((SpriteRscBuilder.ApolloAppearAction)localObject2).a) });
          return null;
        }
        localObject1 = this.c;
        if ((localObject1 != null) && (!((IApolloResManager)localObject1).c(((SpriteRscBuilder.ApolloAppearAction)localObject2).a, 0)))
        {
          if (QLog.isColorLevel()) {
            QLog.i("[cmshow][scripted]SpriteRscBuilder", 2, "hasAppearAction isActionResDone is false.");
          }
          paramString = new ApolloActionData();
          paramString.actionId = ((SpriteRscBuilder.ApolloAppearAction)localObject2).a;
          localObject2 = ((IApolloResManager)localObject1).a(paramString, 5);
          paramString = ((IApolloResManager)localObject1).a(paramString, 4);
          ((IApolloResManager)localObject1).a().a(paramQQAppInterface, paramString, (String)localObject2);
          return null;
        }
        this.a.put(paramString, Integer.valueOf(j + 1));
        return localObject2;
      }
      catch (Exception paramQQAppInterface)
      {
        QLog.e("[cmshow][scripted]SpriteRscBuilder", 2, "hasAppearAction error:", paramQQAppInterface);
        return null;
      }
    }
    QLog.e("[cmshow][scripted]SpriteRscBuilder", 2, "[hasAppearAction] return, invalid params!");
    return null;
  }
  
  public static void b(String paramString)
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
  
  public Pair<String, Integer> a(String paramString)
  {
    int j = 0;
    Object localObject1 = new Pair("def/basic/action/4/action/action", Integer.valueOf(0));
    if (TextUtils.isEmpty(paramString)) {
      return localObject1;
    }
    if ((((IApolloManagerService)this.b.l().getRuntimeService(IApolloManagerService.class, "all")).getCmShowStatus(paramString) != 2) && (a(this.b.l(), paramString)))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.g);
      localStringBuilder.append("/action/action");
      Object localObject2 = this.b.l().getApp().getSharedPreferences("apollo_sp", 0);
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("stand_type_");
      ((StringBuilder)localObject1).append(this.f);
      if (!((SharedPreferences)localObject2).getBoolean(((StringBuilder)localObject1).toString(), false))
      {
        localObject1 = null;
        i = this.f;
        if (i != 1)
        {
          if (i != 2)
          {
            if (i == 3) {
              localObject1 = HardCodeUtil.a(2131911660);
            }
          }
          else {
            localObject1 = HardCodeUtil.a(2131911666);
          }
        }
        else {
          localObject1 = HardCodeUtil.a(2131911662);
        }
        SpriteActionScript localSpriteActionScript = SpriteUtil.i(this.b.l());
        if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (localSpriteActionScript != null)) {
          localSpriteActionScript.b(paramString, (String)localObject1);
        }
        localObject1 = ((SharedPreferences)localObject2).edit();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("stand_type_");
        ((StringBuilder)localObject2).append(this.f);
        ((SharedPreferences.Editor)localObject1).putBoolean(((StringBuilder)localObject2).toString(), true).commit();
        if (QLog.isColorLevel()) {
          QLog.d("[cmshow][scripted]SpriteRscBuilder", 2, new Object[] { "getSpriteShowPath stand:", Integer.valueOf(this.f), ", uin:", LogUtil.wrapLogUin(paramString) });
        }
      }
      if (this.b.a == 3000) {
        i = 2;
      } else {
        i = this.b.a;
      }
      VipUtils.a(null, "cmshow", "Apollo", "appearanceaction", i, this.f, new String[] { String.valueOf(this.g) });
      int i = j;
      if (this.f == 4) {
        i = 7;
      }
      return new Pair(localStringBuilder.toString(), Integer.valueOf(i));
    }
    return localObject1;
  }
  
  public PlayActionScript a(SpriteTaskParam paramSpriteTaskParam, String paramString)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public JSONArray a(JSONArray paramJSONArray)
  {
    JSONArray localJSONArray = new JSONArray();
    Object localObject1 = this.b;
    if ((localObject1 != null) && (((SpriteContext)localObject1).l() != null) && (paramJSONArray != null))
    {
      localObject1 = new StringBuilder();
      int j = paramJSONArray.length();
      int i = 0;
      for (;;)
      {
        if (i < j) {
          try
          {
            int k = ((Integer)paramJSONArray.get(i)).intValue();
            if (k != 0)
            {
              IApolloResManager localIApolloResManager = this.c;
              if ((localIApolloResManager != null) && (!localIApolloResManager.c(k, 0)))
              {
                Object localObject2 = new StringBuilder();
                ((StringBuilder)localObject2).append("getPetActions download:");
                ((StringBuilder)localObject2).append(k);
                QLog.e("[cmshow]ApolloPet", 1, ((StringBuilder)localObject2).toString());
                Object localObject3 = new ApolloActionData();
                ((ApolloActionData)localObject3).actionId = k;
                localObject2 = localIApolloResManager.a((ApolloActionData)localObject3, 5);
                localObject3 = localIApolloResManager.a((ApolloActionData)localObject3, 4);
                localIApolloResManager.a().a(this.b.l(), (String)localObject3, (String)localObject2);
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
      return localJSONArray;
    }
    QLog.e("[cmshow]ApolloPet", 1, "getPetActions return, invalid params!");
    return localJSONArray;
  }
  
  /* Error */
  public JSONObject a(String paramString, SpriteContext paramSpriteContext, boolean paramBoolean)
  {
    // Byte code:
    //   0: new 192	org/json/JSONObject
    //   3: dup
    //   4: invokespecial 340	org/json/JSONObject:<init>	()V
    //   7: astore 11
    //   9: new 562	java/util/ArrayList
    //   12: dup
    //   13: invokespecial 563	java/util/ArrayList:<init>	()V
    //   16: astore 14
    //   18: aload_2
    //   19: invokevirtual 46	com/tencent/mobileqq/apollo/script/SpriteContext:q	()Lcom/tencent/mobileqq/cmshow/engine/resource/IApolloResManager;
    //   22: astore 13
    //   24: iconst_0
    //   25: istore 4
    //   27: aload_2
    //   28: invokevirtual 383	com/tencent/mobileqq/apollo/script/SpriteContext:l	()Lcom/tencent/mobileqq/app/QQAppInterface;
    //   31: astore 12
    //   33: aload 12
    //   35: ldc 96
    //   37: ldc 98
    //   39: invokevirtual 104	com/tencent/mobileqq/app/QQAppInterface:getRuntimeService	(Ljava/lang/Class;Ljava/lang/String;)Lmqq/app/api/IRuntimeService;
    //   42: checkcast 106	com/tencent/mobileqq/apollo/api/impl/ApolloManagerServiceImpl
    //   45: astore 10
    //   47: aload 12
    //   49: ldc_w 296
    //   52: ldc 98
    //   54: invokevirtual 104	com/tencent/mobileqq/app/QQAppInterface:getRuntimeService	(Ljava/lang/Class;Ljava/lang/String;)Lmqq/app/api/IRuntimeService;
    //   57: checkcast 298	com/tencent/mobileqq/apollo/persistence/api/impl/ApolloDaoManagerServiceImpl
    //   60: aload_1
    //   61: invokevirtual 396	com/tencent/mobileqq/apollo/persistence/api/impl/ApolloDaoManagerServiceImpl:getApolloBaseInfo	(Ljava/lang/String;)Lcom/tencent/mobileqq/apollo/model/ApolloBaseInfo;
    //   64: astore 12
    //   66: aload 12
    //   68: ifnonnull +5 -> 73
    //   71: aconst_null
    //   72: areturn
    //   73: aload 12
    //   75: invokevirtual 567	com/tencent/mobileqq/apollo/model/ApolloBaseInfo:getApolloPetDress	()Lcom/tencent/mobileqq/apollo/model/ApolloDress;
    //   78: astore 15
    //   80: aload 15
    //   82: ifnull +825 -> 907
    //   85: aload 12
    //   87: getfield 402	com/tencent/mobileqq/apollo/model/ApolloBaseInfo:hasPet	Z
    //   90: ifeq +817 -> 907
    //   93: aload 15
    //   95: getfield 573	com/tencent/mobileqq/apollo/model/ApolloDress:dressMap	Ljava/util/HashMap;
    //   98: ifnull +809 -> 907
    //   101: aload 15
    //   103: getfield 573	com/tencent/mobileqq/apollo/model/ApolloDress:dressMap	Ljava/util/HashMap;
    //   106: invokevirtual 575	java/util/HashMap:isEmpty	()Z
    //   109: ifne +798 -> 907
    //   112: aload 11
    //   114: ldc_w 577
    //   117: iconst_0
    //   118: aload 15
    //   120: getfield 579	com/tencent/mobileqq/apollo/model/ApolloDress:roleId	I
    //   123: invokestatic 583	com/tencent/mobileqq/apollo/utils/api/impl/ApolloActionHelperImpl:getApolloRsc	(II)Ljava/lang/String;
    //   126: invokevirtual 357	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   129: pop
    //   130: aload 13
    //   132: iconst_1
    //   133: aload 15
    //   135: getfield 579	com/tencent/mobileqq/apollo/model/ApolloDress:roleId	I
    //   138: invokeinterface 585 3 0
    //   143: istore 9
    //   145: iload 9
    //   147: ifne +33 -> 180
    //   150: aload 15
    //   152: getfield 579	com/tencent/mobileqq/apollo/model/ApolloDress:roleId	I
    //   155: istore 5
    //   157: iconst_0
    //   158: istore 4
    //   160: goto +26 -> 186
    //   163: astore 11
    //   165: iconst_0
    //   166: istore 4
    //   168: goto +767 -> 935
    //   171: astore 11
    //   173: aload 10
    //   175: astore 12
    //   177: goto +780 -> 957
    //   180: iconst_1
    //   181: istore 4
    //   183: iconst_m1
    //   184: istore 5
    //   186: aload 15
    //   188: getfield 573	com/tencent/mobileqq/apollo/model/ApolloDress:dressMap	Ljava/util/HashMap;
    //   191: invokevirtual 588	java/util/HashMap:size	()I
    //   194: newarray int
    //   196: astore 16
    //   198: aload 15
    //   200: getfield 573	com/tencent/mobileqq/apollo/model/ApolloDress:dressMap	Ljava/util/HashMap;
    //   203: invokevirtual 592	java/util/HashMap:entrySet	()Ljava/util/Set;
    //   206: invokeinterface 598 1 0
    //   211: astore 17
    //   213: iconst_0
    //   214: istore 6
    //   216: aload 17
    //   218: invokeinterface 603 1 0
    //   223: ifeq +38 -> 261
    //   226: aload 16
    //   228: iload 6
    //   230: aload 17
    //   232: invokeinterface 607 1 0
    //   237: checkcast 609	java/util/Map$Entry
    //   240: invokeinterface 612 1 0
    //   245: checkcast 257	java/lang/Integer
    //   248: invokevirtual 380	java/lang/Integer:intValue	()I
    //   251: iastore
    //   252: iload 6
    //   254: iconst_1
    //   255: iadd
    //   256: istore 6
    //   258: goto -42 -> 216
    //   261: new 177	org/json/JSONArray
    //   264: dup
    //   265: invokespecial 287	org/json/JSONArray:<init>	()V
    //   268: astore 17
    //   270: aload 16
    //   272: arraylength
    //   273: istore 6
    //   275: iconst_0
    //   276: istore 7
    //   278: iload 7
    //   280: iload 6
    //   282: if_icmpge +83 -> 365
    //   285: aload 16
    //   287: iload 7
    //   289: iaload
    //   290: istore 8
    //   292: aload 17
    //   294: iconst_1
    //   295: iload 8
    //   297: invokestatic 583	com/tencent/mobileqq/apollo/utils/api/impl/ApolloActionHelperImpl:getApolloRsc	(II)Ljava/lang/String;
    //   300: invokevirtual 362	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   303: pop
    //   304: aload 13
    //   306: iconst_2
    //   307: iload 8
    //   309: invokeinterface 585 3 0
    //   314: istore 9
    //   316: iload 9
    //   318: ifne +38 -> 356
    //   321: aload 14
    //   323: iload 8
    //   325: invokestatic 260	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   328: invokeinterface 617 2 0
    //   333: pop
    //   334: iconst_0
    //   335: istore 4
    //   337: goto +19 -> 356
    //   340: astore 11
    //   342: iconst_0
    //   343: istore 4
    //   345: goto +793 -> 1138
    //   348: astore 11
    //   350: iconst_0
    //   351: istore 4
    //   353: goto +611 -> 964
    //   356: iload 7
    //   358: iconst_1
    //   359: iadd
    //   360: istore 7
    //   362: goto -84 -> 278
    //   365: aload 11
    //   367: ldc_w 619
    //   370: aload 17
    //   372: invokevirtual 357	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   375: pop
    //   376: aload 11
    //   378: ldc 190
    //   380: aload 15
    //   382: getfield 579	com/tencent/mobileqq/apollo/model/ApolloDress:roleId	I
    //   385: invokevirtual 348	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   388: pop
    //   389: aload 15
    //   391: getfield 579	com/tencent/mobileqq/apollo/model/ApolloDress:roleId	I
    //   394: ldc_w 621
    //   397: aload 13
    //   399: invokestatic 623	com/tencent/mobileqq/apollo/script/SpriteRscBuilder:a	(ILjava/lang/String;Lcom/tencent/mobileqq/cmshow/engine/resource/IApolloResManager;)Ljava/lang/String;
    //   402: astore 16
    //   404: aload 15
    //   406: getfield 579	com/tencent/mobileqq/apollo/model/ApolloDress:roleId	I
    //   409: ldc_w 625
    //   412: aload 13
    //   414: invokestatic 623	com/tencent/mobileqq/apollo/script/SpriteRscBuilder:a	(ILjava/lang/String;Lcom/tencent/mobileqq/cmshow/engine/resource/IApolloResManager;)Ljava/lang/String;
    //   417: astore 17
    //   419: aload 16
    //   421: invokestatic 171	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   424: ifne +33 -> 457
    //   427: aload 17
    //   429: invokestatic 171	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   432: ifne +25 -> 457
    //   435: aload 11
    //   437: ldc_w 627
    //   440: aload 17
    //   442: invokevirtual 357	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   445: pop
    //   446: aload 11
    //   448: ldc_w 629
    //   451: aload 16
    //   453: invokevirtual 357	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   456: pop
    //   457: aload 15
    //   459: getfield 579	com/tencent/mobileqq/apollo/model/ApolloDress:roleId	I
    //   462: aload 13
    //   464: invokestatic 631	com/tencent/mobileqq/apollo/script/SpriteRscBuilder:a	(ILcom/tencent/mobileqq/cmshow/engine/resource/IApolloResManager;)Ljava/lang/String;
    //   467: astore 16
    //   469: aload 16
    //   471: invokestatic 171	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   474: ifne +14 -> 488
    //   477: aload 11
    //   479: ldc_w 633
    //   482: aload 16
    //   484: invokevirtual 357	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   487: pop
    //   488: aload 12
    //   490: getfield 636	com/tencent/mobileqq/apollo/model/ApolloBaseInfo:petNick	Ljava/lang/String;
    //   493: invokestatic 171	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   496: ifne +37 -> 533
    //   499: aload_2
    //   500: getfield 638	com/tencent/mobileqq/apollo/script/SpriteContext:i	I
    //   503: ifne +30 -> 533
    //   506: aload 11
    //   508: ldc_w 640
    //   511: aload 12
    //   513: getfield 636	com/tencent/mobileqq/apollo/model/ApolloBaseInfo:petNick	Ljava/lang/String;
    //   516: ldc_w 642
    //   519: invokevirtual 646	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   522: iconst_0
    //   523: invokestatic 652	com/tencent/mobileqq/utils/Base64Util:encodeToString	([BI)Ljava/lang/String;
    //   526: invokestatic 654	com/tencent/mobileqq/apollo/script/SpriteUtil:a	(Ljava/lang/String;)Ljava/lang/String;
    //   529: invokevirtual 357	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   532: pop
    //   533: aload 12
    //   535: getfield 657	com/tencent/mobileqq/apollo/model/ApolloBaseInfo:mBgImgPath	Ljava/lang/String;
    //   538: invokestatic 171	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   541: ifne +24 -> 565
    //   544: aload_2
    //   545: getfield 638	com/tencent/mobileqq/apollo/script/SpriteContext:i	I
    //   548: ifne +17 -> 565
    //   551: aload 11
    //   553: ldc_w 659
    //   556: aload 12
    //   558: getfield 657	com/tencent/mobileqq/apollo/model/ApolloBaseInfo:mBgImgPath	Ljava/lang/String;
    //   561: invokevirtual 357	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   564: pop
    //   565: aload 12
    //   567: getfield 662	com/tencent/mobileqq/apollo/model/ApolloBaseInfo:mBallImgPath	Ljava/lang/String;
    //   570: invokestatic 171	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   573: ifne +24 -> 597
    //   576: aload_2
    //   577: getfield 638	com/tencent/mobileqq/apollo/script/SpriteContext:i	I
    //   580: ifne +17 -> 597
    //   583: aload 11
    //   585: ldc_w 664
    //   588: aload 12
    //   590: getfield 662	com/tencent/mobileqq/apollo/model/ApolloBaseInfo:mBallImgPath	Ljava/lang/String;
    //   593: invokevirtual 357	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   596: pop
    //   597: aload 12
    //   599: getfield 667	com/tencent/mobileqq/apollo/model/ApolloBaseInfo:mLevel	Ljava/lang/String;
    //   602: invokestatic 171	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   605: ifne +24 -> 629
    //   608: aload_2
    //   609: getfield 638	com/tencent/mobileqq/apollo/script/SpriteContext:i	I
    //   612: ifne +17 -> 629
    //   615: aload 11
    //   617: ldc_w 669
    //   620: aload 12
    //   622: getfield 667	com/tencent/mobileqq/apollo/model/ApolloBaseInfo:mLevel	Ljava/lang/String;
    //   625: invokevirtual 357	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   628: pop
    //   629: aload 11
    //   631: ldc_w 671
    //   634: aload 10
    //   636: getfield 175	com/tencent/mobileqq/apollo/api/impl/ApolloManagerServiceImpl:mPetConfig	Ljava/lang/String;
    //   639: aload 15
    //   641: getfield 579	com/tencent/mobileqq/apollo/model/ApolloDress:roleId	I
    //   644: iload_3
    //   645: invokestatic 673	com/tencent/mobileqq/apollo/script/SpriteRscBuilder:a	(Ljava/lang/String;IZ)Ljava/lang/String;
    //   648: invokevirtual 357	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   651: pop
    //   652: aload_0
    //   653: getfield 40	com/tencent/mobileqq/apollo/script/SpriteRscBuilder:b	Lcom/tencent/mobileqq/apollo/script/SpriteContext;
    //   656: getfield 677	com/tencent/mobileqq/apollo/script/SpriteContext:k	Lcom/tencent/mobileqq/apollo/model/ApolloRoleInfo;
    //   659: ifnull +63 -> 722
    //   662: aload 11
    //   664: ldc_w 679
    //   667: aload_0
    //   668: getfield 40	com/tencent/mobileqq/apollo/script/SpriteRscBuilder:b	Lcom/tencent/mobileqq/apollo/script/SpriteContext;
    //   671: getfield 677	com/tencent/mobileqq/apollo/script/SpriteContext:k	Lcom/tencent/mobileqq/apollo/model/ApolloRoleInfo;
    //   674: getfield 684	com/tencent/mobileqq/apollo/model/ApolloRoleInfo:scale	F
    //   677: f2d
    //   678: invokevirtual 687	org/json/JSONObject:put	(Ljava/lang/String;D)Lorg/json/JSONObject;
    //   681: pop
    //   682: aload 11
    //   684: ldc_w 689
    //   687: aload_0
    //   688: getfield 40	com/tencent/mobileqq/apollo/script/SpriteRscBuilder:b	Lcom/tencent/mobileqq/apollo/script/SpriteContext;
    //   691: getfield 677	com/tencent/mobileqq/apollo/script/SpriteContext:k	Lcom/tencent/mobileqq/apollo/model/ApolloRoleInfo;
    //   694: getfield 691	com/tencent/mobileqq/apollo/model/ApolloRoleInfo:xPos	F
    //   697: f2d
    //   698: invokevirtual 687	org/json/JSONObject:put	(Ljava/lang/String;D)Lorg/json/JSONObject;
    //   701: pop
    //   702: aload 11
    //   704: ldc_w 693
    //   707: aload_0
    //   708: getfield 40	com/tencent/mobileqq/apollo/script/SpriteRscBuilder:b	Lcom/tencent/mobileqq/apollo/script/SpriteContext;
    //   711: getfield 677	com/tencent/mobileqq/apollo/script/SpriteContext:k	Lcom/tencent/mobileqq/apollo/model/ApolloRoleInfo;
    //   714: getfield 695	com/tencent/mobileqq/apollo/model/ApolloRoleInfo:yPos	F
    //   717: f2d
    //   718: invokevirtual 687	org/json/JSONObject:put	(Ljava/lang/String;D)Lorg/json/JSONObject;
    //   721: pop
    //   722: iload 4
    //   724: ifeq +6 -> 730
    //   727: goto +6 -> 733
    //   730: aconst_null
    //   731: astore 11
    //   733: iload 4
    //   735: ifne +149 -> 884
    //   738: aload_2
    //   739: ifnull +145 -> 884
    //   742: aload_2
    //   743: invokevirtual 383	com/tencent/mobileqq/apollo/script/SpriteContext:l	()Lcom/tencent/mobileqq/app/QQAppInterface;
    //   746: ifnull +138 -> 884
    //   749: new 93	java/lang/StringBuilder
    //   752: dup
    //   753: invokespecial 94	java/lang/StringBuilder:<init>	()V
    //   756: astore 12
    //   758: aload 12
    //   760: ldc_w 697
    //   763: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   766: pop
    //   767: aload 12
    //   769: aload_1
    //   770: invokestatic 241	mqq/util/LogUtil:wrapLogUin	(Ljava/lang/String;)Ljava/lang/String;
    //   773: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   776: pop
    //   777: ldc 131
    //   779: iconst_1
    //   780: aload 12
    //   782: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   785: invokestatic 162	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   788: aload 10
    //   790: ifnull +94 -> 884
    //   793: aload 14
    //   795: invokeinterface 698 1 0
    //   800: newarray int
    //   802: astore 10
    //   804: aload 14
    //   806: invokeinterface 699 1 0
    //   811: astore 12
    //   813: iconst_0
    //   814: istore 4
    //   816: aload 12
    //   818: invokeinterface 603 1 0
    //   823: ifeq +30 -> 853
    //   826: aload 10
    //   828: iload 4
    //   830: aload 12
    //   832: invokeinterface 607 1 0
    //   837: checkcast 257	java/lang/Integer
    //   840: invokevirtual 380	java/lang/Integer:intValue	()I
    //   843: iastore
    //   844: iload 4
    //   846: iconst_1
    //   847: iadd
    //   848: istore 4
    //   850: goto -34 -> 816
    //   853: aload 13
    //   855: invokeinterface 151 1 0
    //   860: aload_2
    //   861: invokevirtual 383	com/tencent/mobileqq/apollo/script/SpriteContext:l	()Lcom/tencent/mobileqq/app/QQAppInterface;
    //   864: aload_1
    //   865: aload 13
    //   867: invokeinterface 702 1 0
    //   872: iload 5
    //   874: aload 10
    //   876: iconst_m1
    //   877: iconst_m1
    //   878: iconst_1
    //   879: invokeinterface 705 9 0
    //   884: aload 11
    //   886: areturn
    //   887: astore 11
    //   889: goto +10 -> 899
    //   892: astore 11
    //   894: goto +70 -> 964
    //   897: astore 11
    //   899: goto +239 -> 1138
    //   902: astore 11
    //   904: goto +60 -> 964
    //   907: aconst_null
    //   908: areturn
    //   909: astore 11
    //   911: goto +21 -> 932
    //   914: astore 12
    //   916: aload 10
    //   918: astore 11
    //   920: aload 12
    //   922: astore 10
    //   924: goto +22 -> 946
    //   927: astore 11
    //   929: aconst_null
    //   930: astore 10
    //   932: iconst_1
    //   933: istore 4
    //   935: iconst_m1
    //   936: istore 5
    //   938: goto +200 -> 1138
    //   941: astore 10
    //   943: aconst_null
    //   944: astore 11
    //   946: iconst_1
    //   947: istore 4
    //   949: aload 11
    //   951: astore 12
    //   953: aload 10
    //   955: astore 11
    //   957: iconst_m1
    //   958: istore 5
    //   960: aload 12
    //   962: astore 10
    //   964: iconst_0
    //   965: istore 6
    //   967: ldc 233
    //   969: iconst_1
    //   970: aload 11
    //   972: iconst_0
    //   973: anewarray 4	java/lang/Object
    //   976: invokestatic 367	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   979: iload 4
    //   981: ifne +150 -> 1131
    //   984: aload_2
    //   985: ifnull +146 -> 1131
    //   988: aload_2
    //   989: invokevirtual 383	com/tencent/mobileqq/apollo/script/SpriteContext:l	()Lcom/tencent/mobileqq/app/QQAppInterface;
    //   992: ifnull +139 -> 1131
    //   995: new 93	java/lang/StringBuilder
    //   998: dup
    //   999: invokespecial 94	java/lang/StringBuilder:<init>	()V
    //   1002: astore 11
    //   1004: aload 11
    //   1006: ldc_w 697
    //   1009: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1012: pop
    //   1013: aload 11
    //   1015: aload_1
    //   1016: invokestatic 241	mqq/util/LogUtil:wrapLogUin	(Ljava/lang/String;)Ljava/lang/String;
    //   1019: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1022: pop
    //   1023: ldc 131
    //   1025: iconst_1
    //   1026: aload 11
    //   1028: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1031: invokestatic 162	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1034: aload 10
    //   1036: ifnull +95 -> 1131
    //   1039: aload 14
    //   1041: invokeinterface 698 1 0
    //   1046: newarray int
    //   1048: astore 10
    //   1050: aload 14
    //   1052: invokeinterface 699 1 0
    //   1057: astore 11
    //   1059: iload 6
    //   1061: istore 4
    //   1063: aload 11
    //   1065: invokeinterface 603 1 0
    //   1070: ifeq +30 -> 1100
    //   1073: aload 10
    //   1075: iload 4
    //   1077: aload 11
    //   1079: invokeinterface 607 1 0
    //   1084: checkcast 257	java/lang/Integer
    //   1087: invokevirtual 380	java/lang/Integer:intValue	()I
    //   1090: iastore
    //   1091: iload 4
    //   1093: iconst_1
    //   1094: iadd
    //   1095: istore 4
    //   1097: goto -34 -> 1063
    //   1100: aload 13
    //   1102: invokeinterface 151 1 0
    //   1107: aload_2
    //   1108: invokevirtual 383	com/tencent/mobileqq/apollo/script/SpriteContext:l	()Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1111: aload_1
    //   1112: aload 13
    //   1114: invokeinterface 702 1 0
    //   1119: iload 5
    //   1121: aload 10
    //   1123: iconst_m1
    //   1124: iconst_m1
    //   1125: iconst_1
    //   1126: invokeinterface 705 9 0
    //   1131: aconst_null
    //   1132: areturn
    //   1133: astore 11
    //   1135: goto +3 -> 1138
    //   1138: iconst_0
    //   1139: istore 6
    //   1141: iload 4
    //   1143: ifne +150 -> 1293
    //   1146: aload_2
    //   1147: ifnull +146 -> 1293
    //   1150: aload_2
    //   1151: invokevirtual 383	com/tencent/mobileqq/apollo/script/SpriteContext:l	()Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1154: ifnull +139 -> 1293
    //   1157: new 93	java/lang/StringBuilder
    //   1160: dup
    //   1161: invokespecial 94	java/lang/StringBuilder:<init>	()V
    //   1164: astore 12
    //   1166: aload 12
    //   1168: ldc_w 697
    //   1171: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1174: pop
    //   1175: aload 12
    //   1177: aload_1
    //   1178: invokestatic 241	mqq/util/LogUtil:wrapLogUin	(Ljava/lang/String;)Ljava/lang/String;
    //   1181: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1184: pop
    //   1185: ldc 131
    //   1187: iconst_1
    //   1188: aload 12
    //   1190: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1193: invokestatic 162	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1196: aload 10
    //   1198: ifnull +95 -> 1293
    //   1201: aload 14
    //   1203: invokeinterface 698 1 0
    //   1208: newarray int
    //   1210: astore 10
    //   1212: aload 14
    //   1214: invokeinterface 699 1 0
    //   1219: astore 12
    //   1221: iload 6
    //   1223: istore 4
    //   1225: aload 12
    //   1227: invokeinterface 603 1 0
    //   1232: ifeq +30 -> 1262
    //   1235: aload 10
    //   1237: iload 4
    //   1239: aload 12
    //   1241: invokeinterface 607 1 0
    //   1246: checkcast 257	java/lang/Integer
    //   1249: invokevirtual 380	java/lang/Integer:intValue	()I
    //   1252: iastore
    //   1253: iload 4
    //   1255: iconst_1
    //   1256: iadd
    //   1257: istore 4
    //   1259: goto -34 -> 1225
    //   1262: aload 13
    //   1264: invokeinterface 151 1 0
    //   1269: aload_2
    //   1270: invokevirtual 383	com/tencent/mobileqq/apollo/script/SpriteContext:l	()Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1273: aload_1
    //   1274: aload 13
    //   1276: invokeinterface 702 1 0
    //   1281: iload 5
    //   1283: aload 10
    //   1285: iconst_m1
    //   1286: iconst_m1
    //   1287: iconst_1
    //   1288: invokeinterface 705 9 0
    //   1293: goto +6 -> 1299
    //   1296: aload 11
    //   1298: athrow
    //   1299: goto -3 -> 1296
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1302	0	this	SpriteRscBuilder
    //   0	1302	1	paramString	String
    //   0	1302	2	paramSpriteContext	SpriteContext
    //   0	1302	3	paramBoolean	boolean
    //   25	1233	4	i	int
    //   155	1127	5	j	int
    //   214	1008	6	k	int
    //   276	85	7	m	int
    //   290	34	8	n	int
    //   143	174	9	bool	boolean
    //   45	886	10	localObject1	Object
    //   941	13	10	localThrowable1	Throwable
    //   962	322	10	localObject2	Object
    //   7	106	11	localJSONObject1	JSONObject
    //   163	1	11	localObject3	Object
    //   171	1	11	localThrowable2	Throwable
    //   340	1	11	localObject4	Object
    //   348	355	11	localThrowable3	Throwable
    //   731	154	11	localJSONObject2	JSONObject
    //   887	1	11	localObject5	Object
    //   892	1	11	localThrowable4	Throwable
    //   897	1	11	localObject6	Object
    //   902	1	11	localThrowable5	Throwable
    //   909	1	11	localObject7	Object
    //   918	1	11	localObject8	Object
    //   927	1	11	localObject9	Object
    //   944	134	11	localObject10	Object
    //   1133	164	11	localObject11	Object
    //   31	800	12	localObject12	Object
    //   914	7	12	localThrowable6	Throwable
    //   951	289	12	localObject13	Object
    //   22	1253	13	localIApolloResManager	IApolloResManager
    //   16	1197	14	localArrayList	ArrayList
    //   78	562	15	localApolloDress	com.tencent.mobileqq.apollo.model.ApolloDress
    //   196	287	16	localObject14	Object
    //   211	230	17	localObject15	Object
    // Exception table:
    //   from	to	target	type
    //   150	157	163	finally
    //   150	157	171	java/lang/Throwable
    //   321	334	340	finally
    //   321	334	348	java/lang/Throwable
    //   292	316	887	finally
    //   365	457	887	finally
    //   457	488	887	finally
    //   488	533	887	finally
    //   533	565	887	finally
    //   565	597	887	finally
    //   597	629	887	finally
    //   629	722	887	finally
    //   292	316	892	java/lang/Throwable
    //   365	457	892	java/lang/Throwable
    //   457	488	892	java/lang/Throwable
    //   488	533	892	java/lang/Throwable
    //   533	565	892	java/lang/Throwable
    //   565	597	892	java/lang/Throwable
    //   597	629	892	java/lang/Throwable
    //   629	722	892	java/lang/Throwable
    //   186	213	897	finally
    //   216	252	897	finally
    //   261	275	897	finally
    //   186	213	902	java/lang/Throwable
    //   216	252	902	java/lang/Throwable
    //   261	275	902	java/lang/Throwable
    //   47	66	909	finally
    //   73	80	909	finally
    //   85	145	909	finally
    //   47	66	914	java/lang/Throwable
    //   73	80	914	java/lang/Throwable
    //   85	145	914	java/lang/Throwable
    //   27	47	927	finally
    //   27	47	941	java/lang/Throwable
    //   967	979	1133	finally
  }
  
  public void a()
  {
    Map localMap = this.a;
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
        paramList = b(this.b.l(), str);
        if (str.equals(this.b.c))
        {
          localObject1 = a(paramList);
        }
        else
        {
          localObject3 = a(paramList);
          paramList = (List<String>)localObject1;
          localObject1 = localObject3;
        }
        ((SpriteTaskParam)localObject1).a = i;
        ((SpriteTaskParam)localObject1).l = true;
        ((SpriteTaskParam)localObject1).j = str;
        localArrayList.add(localObject1);
        if (QLog.isColorLevel()) {
          QLog.d("[cmshow][scripted]SpriteRscBuilder", 2, new Object[] { "playAppearAction task action:", Integer.valueOf(((SpriteTaskParam)localObject1).f), ",uin:", str.substring(0, 4) });
        }
        i += 1;
        localObject1 = paramList;
      }
      SpriteUtil.a(this.b, localArrayList);
      if (localObject1 != null)
      {
        localObject3 = this.b.l().getApp().getSharedPreferences("apollo_sp", 0);
        paramList = new StringBuilder();
        paramList.append("stand_type_");
        paramList.append(((SpriteRscBuilder.ApolloAppearAction)localObject1).b);
        if (!((SharedPreferences)localObject3).getBoolean(paramList.toString(), false))
        {
          i = ((SpriteRscBuilder.ApolloAppearAction)localObject1).b;
          if (i != 1)
          {
            if (i != 2)
            {
              if (i != 3) {
                paramList = (List<String>)localObject2;
              } else {
                paramList = HardCodeUtil.a(2131911664);
              }
            }
            else {
              paramList = HardCodeUtil.a(2131911657);
            }
          }
          else {
            paramList = HardCodeUtil.a(2131911661);
          }
          localObject2 = SpriteUtil.i(this.b.l());
          if ((!TextUtils.isEmpty(paramList)) && (localObject2 != null)) {
            ((SpriteActionScript)localObject2).b(this.b.c, paramList);
          }
          paramList = ((SharedPreferences)localObject3).edit();
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("stand_type_");
          ((StringBuilder)localObject2).append(((SpriteRscBuilder.ApolloAppearAction)localObject1).b);
          paramList.putBoolean(((StringBuilder)localObject2).toString(), true).commit();
        }
        if (this.b.a == 3000) {
          i = 2;
        } else {
          i = this.b.a;
        }
        VipUtils.a(null, "cmshow", "Apollo", "appearanceaction", i, ((SpriteRscBuilder.ApolloAppearAction)localObject1).b, new String[] { String.valueOf(((SpriteRscBuilder.ApolloAppearAction)localObject1).a) });
      }
    }
  }
  
  boolean a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramQQAppInterface != null))
    {
      int i;
      if (this.a.containsKey(paramString)) {
        i = ((Integer)this.a.get(paramString)).intValue();
      } else {
        i = 0;
      }
      int j;
      if (d.containsKey(paramString)) {
        j = ((Integer)d.get(paramString)).intValue();
      } else {
        j = 0;
      }
      Object localObject1 = ((IApolloManagerService)this.b.l().getRuntimeService(IApolloManagerService.class, "all")).getStandUpSp();
      Object localObject2 = (ApolloExtensionHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.APOLLO_EXTENSION_HANDLER);
      try
      {
        if (this.e.get(paramString) == null) {
          l = 0L;
        } else {
          l = ((Long)this.e.get(paramString)).longValue();
        }
        boolean bool = ((SharedPreferences)localObject1).contains(paramString);
        if ((!bool) && (NetConnInfoCenter.getServerTime() - l > 180L))
        {
          paramQQAppInterface = new JSONObject();
          paramQQAppInterface.put("lastRequestTime", NetConnInfoCenter.getServerTimeMillis());
          ((SharedPreferences)localObject1).edit().putString(paramString, paramQQAppInterface.toString()).commit();
          ((ApolloExtensionHandler)localObject2).a(new long[] { Long.parseLong(paramString) });
          this.e.put(paramString, Long.valueOf(NetConnInfoCenter.getServerTime()));
          return false;
        }
        JSONObject localJSONObject = new JSONObject(((SharedPreferences)localObject1).getString(paramString, "{}"));
        JSONArray localJSONArray = localJSONObject.optJSONArray("action");
        long l = localJSONObject.optLong("lastRequestTime");
        if ((j < 5) && (NetConnInfoCenter.getServerTime() - l <= 10800000L))
        {
          d.put(paramString, Integer.valueOf(j + 1));
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.d("[cmshow][scripted]SpriteRscBuilder", 2, new Object[] { "hasSpecialStandAction getApolloStandAction openCount:", Integer.valueOf(j), ",lastRequestSpTime:", Long.valueOf(l) });
          }
          d.put(paramString, Integer.valueOf(0));
          ((ApolloExtensionHandler)localObject2).a(new long[] { Long.parseLong(paramString) });
          localJSONObject.put("lastRequestTime", NetConnInfoCenter.getServerTimeMillis());
          ((SharedPreferences)localObject1).edit().putString(paramString, localJSONObject.toString()).commit();
        }
        if ((localJSONArray != null) && (localJSONArray.length() > 0))
        {
          j = i;
          if (i >= localJSONArray.length()) {
            j = 0;
          }
          localObject1 = localJSONArray.getJSONObject(j);
          this.f = ((JSONObject)localObject1).getInt("type");
          this.g = ((JSONObject)localObject1).getInt("id");
          if (this.f == 4)
          {
            localObject1 = (ApolloManagerServiceImpl)this.b.l().getRuntimeService(IApolloManagerService.class, "all");
            if (!((ApolloDaoManagerServiceImpl)paramQQAppInterface.getRuntimeService(IApolloDaoManagerService.class, "all")).getApolloBaseInfo(paramString).hasPet)
            {
              b(paramString);
              return false;
            }
          }
          if (QLog.isColorLevel()) {
            QLog.d("[cmshow][scripted]SpriteRscBuilder", 2, new Object[] { "[hasSpecialStandAction] uin:", paramString, ",index:", Integer.valueOf(j), ",id:", Integer.valueOf(this.g), ",standType:", Integer.valueOf(this.f) });
          }
          localObject1 = this.c;
          if ((localObject1 != null) && (!((IApolloResManager)localObject1).c(this.g, 0)))
          {
            if (QLog.isColorLevel()) {
              QLog.i("[cmshow][scripted]SpriteRscBuilder", 2, "hasSpecialStandAction isActionResDone is false.");
            }
            localObject2 = new ApolloActionData();
            ((ApolloActionData)localObject2).actionId = this.g;
            paramString = ((IApolloResManager)localObject1).a((ApolloActionData)localObject2, 5);
            localObject2 = ((IApolloResManager)localObject1).a((ApolloActionData)localObject2, 4);
            ((IApolloResManager)localObject1).a().a(paramQQAppInterface, (String)localObject2, paramString);
            return false;
          }
          this.a.put(paramString, Integer.valueOf(j + 1));
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
    QLog.d("[cmshow][scripted]SpriteRscBuilder", 2, "hasSpecialStandAction return , invalid params!");
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.script.SpriteRscBuilder
 * JD-Core Version:    0.7.0.1
 */