package com.tencent.mobileqq.apollo.task;

import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.apollo.ApolloManager;
import com.tencent.mobileqq.apollo.ApolloRender;
import com.tencent.mobileqq.apollo.data.ApolloDress;
import com.tencent.mobileqq.apollo.script.SpriteTaskParam;
import com.tencent.mobileqq.apollo.store.ApolloResDownloader;
import com.tencent.mobileqq.apollo.store.ApolloResDownloader.OnApolloDownLoadListener;
import com.tencent.mobileqq.apollo.utils.ApolloConstant;
import com.tencent.mobileqq.apollo.utils.ApolloDaoManager;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.CheckPttListener;
import com.tencent.mobileqq.app.CheckPtvListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ApolloActionData;
import com.tencent.mobileqq.data.ApolloBaseInfo;
import com.tencent.mobileqq.magicface.drawable.PngFrameUtil;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class ApolloActionHelper
{
  public static int a = 1;
  public static boolean a;
  public static int b = 2;
  
  public static int a(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloActionHelper", 2, "[getRandomActionId], roleId:" + paramInt);
    }
    paramString = new File(ApolloConstant.f, paramInt + "/" + paramString + "/");
    if (!paramString.exists()) {}
    for (;;)
    {
      return -1;
      Object localObject = paramString.list();
      if ((localObject == null) || (localObject.length == 0))
      {
        if (QLog.isColorLevel())
        {
          QLog.d("ApolloActionHelper", 2, "no any action file.");
          return -1;
        }
      }
      else
      {
        paramInt = PngFrameUtil.a(localObject.length);
        if ((paramInt < localObject.length) && (paramInt >= 0))
        {
          localObject = localObject[paramInt];
          try
          {
            int i = Integer.parseInt((String)localObject);
            if (!new File(paramString.getPath(), (String)localObject + "/" + ApolloConstant.q).exists())
            {
              if (QLog.isColorLevel())
              {
                QLog.d("ApolloActionHelper", 2, "json not exist.");
                return -1;
              }
            }
            else if (!new File(paramString.getPath(), (String)localObject + "/" + ApolloConstant.p).exists())
            {
              if (QLog.isColorLevel())
              {
                QLog.d("ApolloActionHelper", 2, "png not exist.");
                return -1;
              }
            }
            else if (!new File(paramString.getPath(), (String)localObject + "/" + ApolloConstant.r).exists())
            {
              if (QLog.isColorLevel())
              {
                QLog.d("ApolloActionHelper", 2, "atlas not exist.");
                return -1;
              }
            }
            else
            {
              if (QLog.isColorLevel()) {
                QLog.d("ApolloActionHelper", 2, "value:" + paramInt + ",actionId:" + (String)localObject);
              }
              return i;
            }
          }
          catch (NumberFormatException paramString) {}
        }
      }
    }
    return -1;
  }
  
  public static int a(String paramString, QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloActionHelper", 2, "[getApolloFuncSwitch], uin:" + paramString);
    }
    paramString = ((ApolloManager)paramQQAppInterface.getManager(152)).a(paramString);
    if (paramString == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloActionHelper", 2, "apolloBaseInfo is null. ret closed status");
      }
      return 2;
    }
    return paramString.apolloStatus;
  }
  
  public static String a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloActionHelper", 2, "[getTickerPauseString]");
    }
    return "BK.Director.tickerPause();";
  }
  
  public static String a(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloActionHelper", 2, new Object[] { "[getApolloRsc],  rscType", Integer.valueOf(paramInt1), ",id:" + paramInt2 });
    }
    StringBuilder localStringBuilder = new StringBuilder();
    switch (paramInt1)
    {
    default: 
      if (QLog.isColorLevel()) {
        QLog.d("ApolloActionHelper", 2, "rsc:" + localStringBuilder);
      }
      return localStringBuilder.toString();
    case 1: 
      if (paramInt2 < 21) {
        localStringBuilder.append("def/basic/dress/");
      }
      for (;;)
      {
        localStringBuilder.append(paramInt2);
        localStringBuilder.append("/dress");
        break;
        localStringBuilder.append("dress/");
      }
    }
    if (paramInt2 == 0) {
      localStringBuilder.append("def/basic/skeleton/");
    }
    for (;;)
    {
      localStringBuilder.append(paramInt2);
      localStringBuilder.append("/role");
      break;
      localStringBuilder.append("role/");
    }
  }
  
  public static String a(int paramInt, String paramString)
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
  
  public static String a(String paramString)
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
  
  public static String a(String paramString, int paramInt, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloActionHelper", 2, new Object[] { "[getRoleLuaString] apolloId=", paramString, ", roleId=", Integer.valueOf(paramInt) });
    }
    String str = a(0, paramInt);
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
  
  public static String a(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloActionHelper", 2, "[getBubbleLuaString], apolloId:" + paramString1 + ",bubbleId" + paramInt1 + ",roleId:" + paramInt2);
    }
    String str = b(paramInt2, paramInt1);
    paramString1 = String.format("setAccessoryWithInfo(%s, '%s', '%s', '%s');", new Object[] { paramString1, str, str, paramString2 });
    if (QLog.isColorLevel()) {
      QLog.d("ApolloActionHelper", 2, paramString1);
    }
    return paramString1;
  }
  
  public static String a(String paramString1, String paramString2)
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
  
  public static void a(QQAppInterface paramQQAppInterface, SpriteTaskParam paramSpriteTaskParam, boolean paramBoolean1, boolean paramBoolean2)
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
      localApolloActionData = ((ApolloDaoManager)paramQQAppInterface.getManager(154)).a(paramSpriteTaskParam.f);
    } while (localApolloActionData == null);
    String str1 = "";
    int i = 0;
    int j = paramSpriteTaskParam.j;
    String str4 = Integer.toString(paramSpriteTaskParam.f);
    String str2;
    if (paramBoolean1) {
      if (paramBoolean2) {
        str2 = "2";
      }
    }
    for (;;)
    {
      label142:
      label154:
      label172:
      String str3;
      if (paramSpriteTaskParam.h == 0)
      {
        str1 = "action_play";
        if (paramSpriteTaskParam.g != 2) {
          break label393;
        }
        if (!paramSpriteTaskParam.a) {
          break label387;
        }
        i = 2;
        if ((localApolloActionData.hasSound) || (paramSpriteTaskParam.i > 0)) {
          break label434;
        }
        str3 = "0";
        label192:
        if (a(localApolloActionData.vibrate) != null) {
          break label567;
        }
        paramSpriteTaskParam = "0";
      }
      for (;;)
      {
        VipUtils.a(paramQQAppInterface, "cmshow", "Apollo", str1, i, j, new String[] { str4, str2, str3, paramSpriteTaskParam });
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("ApolloActionHelper", 2, "actionName:" + str1 + ",entry:" + i + ",result:" + j + ",r2:" + str4 + ",r3:" + str2 + ",r4:" + str3 + ",r5:" + paramSpriteTaskParam);
        return;
        str2 = "1";
        break label142;
        if (paramSpriteTaskParam.h == 1)
        {
          str1 = "g_action_play";
          break label154;
        }
        if (paramSpriteTaskParam.h != 3000) {
          break label154;
        }
        str1 = "d_action_play";
        break label154;
        label387:
        i = 3;
        break label172;
        label393:
        if (paramSpriteTaskParam.g == 0)
        {
          i = 0;
          break label172;
        }
        if (paramSpriteTaskParam.g == 1)
        {
          i = 1;
          break label172;
        }
        if (paramSpriteTaskParam.g != 4) {
          break label172;
        }
        i = 4;
        break label172;
        label434:
        if ((1 == paramQQAppInterface.c()) && (((paramSpriteTaskParam.h != 1) && (paramSpriteTaskParam.h != 3000)) || (((1 == paramQQAppInterface.a()) || (paramSpriteTaskParam.h == 0)) && (!paramQQAppInterface.k()) && (!paramQQAppInterface.l()) && (paramQQAppInterface.m()) && (!MediaPlayerManager.a(paramQQAppInterface).b()) && ((paramQQAppInterface.a() == null) || (!paramQQAppInterface.a().g())) && (!paramQQAppInterface.c()) && ((paramQQAppInterface.a() == null) || (!paramQQAppInterface.a().h())))))
        {
          str3 = "1";
          break label192;
        }
        str3 = "2";
        break label192;
        label567:
        if ((1 == paramQQAppInterface.d()) && (((paramSpriteTaskParam.h != 1) && (paramSpriteTaskParam.h != 3000)) || (((1 == paramQQAppInterface.b()) || (paramSpriteTaskParam.h == 0)) && (!paramQQAppInterface.l())))) {
          paramSpriteTaskParam = "1";
        } else {
          paramSpriteTaskParam = "2";
        }
      }
      str2 = "0";
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    if (paramQQAppInterface == null) {
      return false;
    }
    if (!new File(ApolloRender.getRscStaticPath(a(paramInt, 1, 0, true)[0], "json")).exists())
    {
      ApolloResDownloader.a(paramQQAppInterface, paramQQAppInterface.c(), null, 0, null, -1, -1, true);
      return false;
    }
    return true;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2)
  {
    if (paramQQAppInterface == null) {
      return false;
    }
    return new File(ApolloRender.getRscStaticPath(a(paramInt1, paramInt2, 0, true)[0], "json")).exists();
  }
  
  public static boolean a(String paramString, int paramInt, int[] paramArrayOfInt, QQAppInterface paramQQAppInterface)
  {
    return a(paramString, paramInt, paramArrayOfInt, paramQQAppInterface, null);
  }
  
  public static boolean a(String paramString, int paramInt, int[] paramArrayOfInt, QQAppInterface paramQQAppInterface, ApolloResDownloader.OnApolloDownLoadListener paramOnApolloDownLoadListener)
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
    if (!ApolloUtil.c(paramInt))
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
        if (ApolloUtil.b(paramArrayOfInt[i])) {
          break label328;
        }
        localArrayList.add(Integer.valueOf(paramArrayOfInt[i]));
        if (QLog.isColorLevel()) {
          QLog.d("ApolloActionHelper", 2, "need download dress id:" + paramArrayOfInt[i]);
        }
        bool = false;
      }
      label325:
      label328:
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
              break label325;
            }
            paramOnApolloDownLoadListener = ((ApolloManager)paramQQAppInterface.getManager(152)).a();
          }
        }
        for (;;)
        {
          ApolloResDownloader.a(paramQQAppInterface, paramString, paramOnApolloDownLoadListener, paramInt, paramArrayOfInt, -1, -1, false);
          if (QLog.isColorLevel()) {
            QLog.d("ApolloActionHelper", 2, "ret:" + bool);
          }
          return bool;
        }
      }
      paramInt = -1;
    }
  }
  
  public static long[] a(String paramString)
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
  
  public static Object[] a(String paramString, QQAppInterface paramQQAppInterface)
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
    Object localObject1 = ApolloResDownloader.a(0);
    int i;
    int j;
    if (("-1".equals(paramString)) || ("-2".equals(paramString)))
    {
      if ("-1".equals(paramString))
      {
        i = 1;
        localObject2 = ApolloResDownloader.a(i);
        if (!a(paramString, i, (int[])localObject2, paramQQAppInterface)) {
          break label201;
        }
        paramString = (String)localObject2;
      }
      for (;;)
      {
        localObject1 = paramString;
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
        i = 2;
        break;
        label201:
        if (QLog.isColorLevel()) {
          QLog.d("ApolloActionHelper", 2, new Object[] { "role and dress is not ready,uin:", paramString, ",roleId:", Integer.valueOf(0) });
        }
        paramString = (String)localObject1;
        i = 0;
      }
    }
    Object localObject2 = ((ApolloManager)paramQQAppInterface.getManager(152)).b(paramString);
    ApolloDress[] arrayOfApolloDress;
    if (localObject2 != null)
    {
      i = ((ApolloBaseInfo)localObject2).apolloStatus;
      if (QLog.isColorLevel()) {
        QLog.d("ApolloActionHelper", 2, "uin: " + ((ApolloBaseInfo)localObject2).uin + ", funcSwitch:" + i);
      }
      if (1 != i) {
        return new Object[] { Integer.valueOf(0), localObject1 };
      }
      if (((ApolloBaseInfo)localObject2).apolloLocalTS != ((ApolloBaseInfo)localObject2).apolloServerTS)
      {
        QLog.i("ApolloActionHelper", 1, "dress changed, uin:" + ApolloUtil.d(paramString));
        ApolloManager.a(paramQQAppInterface, paramString, "getRoleDressIdByUin");
      }
      arrayOfApolloDress = ((ApolloBaseInfo)localObject2).getApolloDress(false);
      if ((arrayOfApolloDress != null) && (arrayOfApolloDress.length > 0))
      {
        j = arrayOfApolloDress.length;
        i = 0;
        label418:
        if (i >= j) {
          break label713;
        }
        ApolloDress localApolloDress = arrayOfApolloDress[i];
        localObject2 = localApolloDress.a();
        if (a(paramString, localApolloDress.a, (int[])localObject2, paramQQAppInterface))
        {
          if (QLog.isColorLevel()) {
            QLog.d("ApolloActionHelper", 2, "valid role and dress RSC.");
          }
          i = localApolloDress.a;
          j = 1;
          localObject1 = localObject2;
        }
      }
    }
    for (;;)
    {
      if (j == 0)
      {
        localObject2 = ApolloResDownloader.a(arrayOfApolloDress[0].a);
        if (a(paramString, arrayOfApolloDress[0].a, (int[])localObject2, paramQQAppInterface))
        {
          if (QLog.isColorLevel()) {
            QLog.d("ApolloActionHelper", 2, "valid basic dress.");
          }
          j = arrayOfApolloDress[0].a;
          paramString = (String)localObject2;
          i = j;
          if (QLog.isColorLevel())
          {
            QLog.d("ApolloActionHelper", 2, "current dress NOT downloaded, check basic dress");
            i = j;
          }
        }
      }
      for (paramString = (String)localObject2;; paramString = (String)localObject1)
      {
        localObject1 = paramString;
        break;
        if (QLog.isColorLevel()) {
          QLog.d("ApolloActionHelper", 2, "try to get history dress ....");
        }
        i += 1;
        break label418;
        if (QLog.isColorLevel()) {
          QLog.d("ApolloActionHelper", 2, "uin: " + paramString + " dress is null");
        }
        for (;;)
        {
          i = 0;
          break;
          if (QLog.isColorLevel()) {
            QLog.d("ApolloActionHelper", 2, "warning: apolloBaseInfo or apolloBaseInfo.apolloDress is NULL, fail to get role info. apolloBaseInfo:" + localObject2);
          }
        }
        paramString.append("]****");
        if (QLog.isColorLevel()) {
          QLog.d("ApolloActionHelper", 2, paramString.toString());
        }
        return new Object[] { Integer.valueOf(i), localObject1 };
      }
      label713:
      j = 0;
      i = 0;
    }
  }
  
  public static String[] a(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("action/").append(paramInt);
    localStringBuilder.append("/action_background/action");
    String str1 = "background__" + Integer.toString(paramInt);
    String str2 = localStringBuilder.toString();
    if (QLog.isColorLevel()) {
      QLog.d("ApolloActionHelper", 2, "action rsc path:" + localStringBuilder.toString() + ",actionName:" + str1);
    }
    return new String[] { str2, str1 };
  }
  
  public static String[] a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloActionHelper", 2, "[getActionRscPath], bid:" + paramInt1 + ",activeId:" + paramInt2 + ",roleId:" + paramInt3 + ",isActionMaker:" + paramBoolean);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    switch (paramInt1)
    {
    default: 
      paramInt3 = paramInt2;
      localStringBuilder.append("/").append(paramInt3);
      if ((paramBoolean) || (paramInt2 < 21)) {
        localStringBuilder.append("/action/action");
      }
      break;
    }
    for (;;)
    {
      String str1 = localStringBuilder.toString();
      String str2 = Integer.toString(paramInt1) + "_" + Integer.toString(paramInt3);
      if (QLog.isColorLevel()) {
        QLog.d("ApolloActionHelper", 2, "action rsc path:" + localStringBuilder.toString() + ",actionId:" + paramInt3);
      }
      return new String[] { str1, str2 };
      localStringBuilder.append("action");
      paramInt3 = paramInt2;
      break;
      localStringBuilder.append("def/basic/action");
      paramInt3 = paramInt2;
      break;
      if (ApolloUtil.a(paramInt3))
      {
        localStringBuilder.append("role/").append(paramInt3);
        paramInt3 = paramInt2;
        break;
      }
      localStringBuilder.append("def/basic/action");
      paramInt3 = paramInt2;
      break;
      localStringBuilder.append("def/basic/").append(ApolloConstant.z);
      paramInt3 = 1;
      break;
      int i = a(paramInt3, ApolloConstant.z);
      if (-1 != i)
      {
        localStringBuilder.append("role/").append(paramInt3).append("/").append(ApolloConstant.z);
        paramInt3 = i;
        break;
      }
      localStringBuilder.append("def/basic/").append(ApolloConstant.z);
      paramInt3 = 1;
      break;
      localStringBuilder.append("drawer_action/");
      paramInt3 = paramInt2;
      break;
      localStringBuilder.append("def/role/").append(0).append("/").append(ApolloConstant.B);
      paramInt3 = paramInt2;
      break;
      localStringBuilder.append("def/role/").append(0).append("/").append(ApolloConstant.D);
      paramInt3 = paramInt2;
      break;
      localStringBuilder.append("def/role/").append(0).append("/").append(ApolloConstant.C);
      paramInt3 = paramInt2;
      break;
      localStringBuilder.append("ai/action");
      paramInt3 = paramInt2;
      break;
      i = a(paramInt3, ApolloConstant.A);
      if (-1 != i)
      {
        localStringBuilder.append("role/").append(paramInt3).append("/").append(ApolloConstant.A);
        paramInt3 = i;
        break;
      }
      localStringBuilder.append("def/basic/").append(ApolloConstant.z);
      paramInt3 = 1;
      break;
      localStringBuilder.append("/action_peer/action");
    }
  }
  
  public static String[] a(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("action");
    localStringBuilder.append("/").append(paramInt1).append("/action");
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
  
  public static String[] a(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloActionHelper", 2, new Object[] { "[getActionLuaString] apolloId=", paramString1, ", actionId=", Integer.valueOf(paramInt1), ", taskId=", Integer.valueOf(paramInt2), ", animName=", paramString3, ", actionRscName=", paramString2 });
    }
    String[] arrayOfString = new String[2];
    String str = paramString3;
    if (paramString2.contains("_peer")) {
      str = paramString3 + "_peer";
    }
    arrayOfString[0] = String.format("setAccessoryAnimation(%s, '%s', '%s', '%s');", new Object[] { paramString1, paramString2, paramString2, str });
    if (QLog.isColorLevel()) {
      QLog.d("ApolloActionHelper", 2, arrayOfString[0]);
    }
    arrayOfString[1] = String.format("if(%s){%s.setAnimation(%d, '%s', false);}", new Object[] { paramString1, paramString1, Integer.valueOf(paramInt2), str });
    if (QLog.isColorLevel()) {
      QLog.d("ApolloActionHelper", 2, arrayOfString[1]);
    }
    return arrayOfString;
  }
  
  public static String[] a(String paramString, int[] paramArrayOfInt)
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
      String str = a(1, paramArrayOfInt[i]);
      arrayOfString[i] = String.format("setAccessory(%s, '%s', '%s');", new Object[] { paramString, str, str });
      if (QLog.isColorLevel()) {
        QLog.d("ApolloActionHelper", 2, new Object[] { "[getDressLuaString] scriptStr", Integer.valueOf(i), "=", arrayOfString[i] });
      }
      i += 1;
    }
    return arrayOfString;
  }
  
  public static String b(int paramInt1, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if ((paramInt1 == 0) || (!ApolloUtil.c(paramInt1, paramInt2)))
    {
      localStringBuilder.append("def/role/");
      localStringBuilder.append(0);
    }
    for (;;)
    {
      localStringBuilder.append("/");
      localStringBuilder.append(ApolloConstant.y);
      localStringBuilder.append("/");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append("/dress");
      return localStringBuilder.toString();
      localStringBuilder.append("role/");
      localStringBuilder.append(paramInt1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.task.ApolloActionHelper
 * JD-Core Version:    0.7.0.1
 */