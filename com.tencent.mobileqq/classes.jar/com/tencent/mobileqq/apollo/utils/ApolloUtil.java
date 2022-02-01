package com.tencent.mobileqq.apollo.utils;

import amsx;
import amtk;
import amxr;
import amyq;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import anga;
import angi;
import anmq;
import annu;
import annv;
import annx;
import anpt;
import anpu;
import anpv;
import anpw;
import anzj;
import asle;
import assp;
import auog;
import avpd;
import avpe;
import azru;
import bcrg;
import begp;
import begw;
import behh;
import bhlo;
import bhmi;
import bhmq;
import bhny;
import bhsw;
import bhuk;
import bihu;
import bihw;
import bjtz;
import blhn;
import bmup;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.ToolAppRuntime;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.apollo.ApolloRender;
import com.tencent.mobileqq.apollo.ApolloTextureView;
import com.tencent.mobileqq.apollo.aioChannel.ApolloCmdChannel;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.StartCheckParam;
import com.tencent.mobileqq.apollo.store.ApolloStoreActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Apollo3DMessage;
import com.tencent.mobileqq.data.ApolloActionData;
import com.tencent.mobileqq.data.ApolloActionPackage;
import com.tencent.mobileqq.data.ApolloBaseInfo;
import com.tencent.mobileqq.data.ApolloGameData;
import com.tencent.mobileqq.data.ApolloMessage;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForApollo;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForLongMsg;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.emoticonview.EmoticonImageView;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.widget.AnimationTextView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mqq.shared_file_accessor.SharedPreferencesProxyManager;
import com.tencent.pb.apollousertrace.ApolloUserTrace.STClickInfo;
import com.tencent.pb.apollousertrace.ApolloUserTrace.STUserClickTrack;
import com.tencent.pb.apollousertrace.ApolloUserTrace.STUserTrackReq;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.nio.charset.UnsupportedCharsetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import nof;
import org.json.JSONArray;
import org.json.JSONObject;

public class ApolloUtil
{
  private static int jdField_a_of_type_Int;
  public static long a;
  public static anpw a;
  public static final String a;
  public static Comparator<File> a;
  private static boolean jdField_a_of_type_Boolean;
  public static final int[] a;
  private static int jdField_b_of_type_Int;
  public static long b;
  public static final String b;
  private static boolean jdField_b_of_type_Boolean;
  private static int jdField_c_of_type_Int;
  private static boolean jdField_c_of_type_Boolean;
  private static boolean d;
  
  static
  {
    jdField_a_of_type_JavaLangString = annv.jdField_d_of_type_JavaLangString + "action_v730.json";
    jdField_b_of_type_JavaLangString = annv.jdField_a_of_type_JavaLangString + "/apollo_report_config.json";
    jdField_a_of_type_Boolean = true;
    jdField_a_of_type_JavaUtilComparator = new anpu();
    jdField_b_of_type_Long = 100L;
    jdField_a_of_type_Int = -2147483648;
    jdField_a_of_type_ArrayOfInt = new int[] { 308, 309, 310, 318, 319, 320 };
  }
  
  public static float a(float paramFloat)
  {
    long l = bhlo.j();
    if (Float.compare(0.0F, paramFloat) == 0) {
      return (float)(l / 5L) / 368.0F;
    }
    return (float)l * paramFloat / 368.0F;
  }
  
  public static int a()
  {
    if (jdField_a_of_type_Int == -2147483648) {
      jdField_a_of_type_Int = BaseApplicationImpl.getApplication().getSharedPreferences("apollo_user_config", 4).getInt("MSAA_level", 0);
    }
    return jdField_a_of_type_Int;
  }
  
  public static final int a(float paramFloat1, float paramFloat2)
  {
    return (int)(paramFloat1 * paramFloat2 + 0.5F);
  }
  
  public static int a(float paramFloat, String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramFloat <= 0.0F)) {}
    int i;
    do
    {
      return 43;
      i = b(paramFloat, paramString, 8, 6);
      if (i == 0) {
        return 41;
      }
      if (i == 1) {
        return 42;
      }
    } while (i == 2);
    if (i == 3) {
      return 44;
    }
    if (i == 4) {
      return 45;
    }
    return 46;
  }
  
  public static int a(float paramFloat, String paramString, int paramInt)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramFloat <= 0.0F)) {
      return 24;
    }
    int i = a(paramFloat, paramString, 13, 3);
    if (i == 1)
    {
      if (paramInt == 2) {
        return 318;
      }
      return 308;
    }
    if (i == 2)
    {
      if (paramInt == 2) {
        return 319;
      }
      return 309;
    }
    if (paramInt == 2) {
      return 320;
    }
    return 310;
  }
  
  private static int a(float paramFloat, String paramString, int paramInt1, int paramInt2)
  {
    Object localObject = new TextView(BaseApplicationImpl.getContext());
    ((TextView)localObject).setTextSize(paramInt1 * 3 / bhlo.jdField_a_of_type_Float);
    ((TextView)localObject).setText(paramString);
    localObject = ((TextView)localObject).getPaint();
    paramString = paramString.replaceAll("\r", "").split("\n");
    int n = paramString.length;
    int j = 0;
    int k;
    for (paramInt1 = 0; j < n; paramInt1 = k + 1)
    {
      String str = paramString[j];
      if (((Paint)localObject).measureText(str) > paramFloat)
      {
        float f1 = 0.0F;
        k = 0;
        int i = paramInt1;
        paramInt1 = k;
        for (;;)
        {
          k = i;
          if (paramInt1 == str.length()) {
            break;
          }
          float f2 = f1 + ((Paint)localObject).measureText(String.valueOf(str.charAt(paramInt1)));
          int m = paramInt1;
          f1 = f2;
          k = i;
          if (f2 > paramFloat)
          {
            k = i + 1;
            m = paramInt1 - 1;
            f1 = 0.0F;
          }
          paramInt1 = m + 1;
          i = k;
        }
      }
      k = paramInt1;
      j += 1;
    }
    if (paramInt1 < paramInt2) {
      return paramInt1;
    }
    return paramInt2;
  }
  
  public static int a(int paramInt)
  {
    Object localObject = null;
    if (1 == paramInt) {
      localObject = new File(jdField_a_of_type_JavaLangString);
    }
    if ((localObject != null) && (((File)localObject).exists()) && (((File)localObject).isFile()))
    {
      localObject = bhmi.a((File)localObject);
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        try
        {
          localObject = new JSONObject((String)localObject);
          if (1 == paramInt)
          {
            if (((JSONObject)localObject).has("timeStamp")) {
              return (int)(((JSONObject)localObject).optLong("timeStamp") / 1000L);
            }
            if (((JSONObject)localObject).has("timestamp"))
            {
              long l = ((JSONObject)localObject).optLong("timestamp") / 1000L;
              return (int)l;
            }
          }
        }
        catch (Exception localException)
        {
          if (QLog.isColorLevel()) {
            QLog.e("ApolloUtil", 2, "getApolloPanelJsonVer fail", localException);
          }
        }
      }
    }
    return 0;
  }
  
  public static int a(anga paramanga, MessageForApollo paramMessageForApollo)
  {
    if ((paramMessageForApollo == null) || (paramMessageForApollo.mApolloMessage == null)) {
      throw new IllegalArgumentException("getPlayActionId, apolloMsg null");
    }
    int j = paramMessageForApollo.mApolloMessage.id;
    int i = j;
    if (paramMessageForApollo.mApollo3DMessage != null)
    {
      i = j;
      if (ApolloActionData.isAction3DModel(paramMessageForApollo.mApollo3DMessage.actionID_3D)) {
        if (!amsx.a(paramanga.a()))
        {
          i = j;
          if (!paramanga.g()) {}
        }
        else
        {
          i = paramMessageForApollo.mApollo3DMessage.actionID_3D;
        }
      }
    }
    return i;
  }
  
  public static int a(SessionInfo paramSessionInfo, AppInterface paramAppInterface)
  {
    if (paramSessionInfo == null) {
      return 0;
    }
    switch (paramSessionInfo.jdField_a_of_type_Int)
    {
    case 0: 
    default: 
      return 0;
    case 1: 
      if (paramAppInterface != null)
      {
        paramAppInterface = (HotChatManager)paramAppInterface.getManager(60);
        if (paramAppInterface != null)
        {
          if (paramAppInterface.b(paramSessionInfo.jdField_b_of_type_JavaLangString)) {
            return 3;
          }
          return 1;
        }
      }
      break;
    case 3000: 
      return 2;
    case 1036: 
      return 4;
    }
    return 1;
  }
  
  public static int a(QQAppInterface paramQQAppInterface, MessageForArkApp paramMessageForArkApp)
  {
    int j;
    if ((paramMessageForArkApp == null) || (paramQQAppInterface == null))
    {
      j = 0;
      return j;
    }
    paramMessageForArkApp = paramMessageForArkApp.ark_app_message;
    if ((!TextUtils.isEmpty(paramMessageForArkApp.appId)) && (!"101538890".equals(paramMessageForArkApp.appId))) {
      return 0;
    }
    paramMessageForArkApp = paramMessageForArkApp.metaList;
    if (paramMessageForArkApp == null) {
      return 0;
    }
    for (;;)
    {
      try
      {
        paramMessageForArkApp = new JSONObject(paramMessageForArkApp).optJSONObject("data");
        if (paramMessageForArkApp != null)
        {
          i = paramMessageForArkApp.optInt("actionId");
          j = i;
        }
      }
      catch (Exception paramQQAppInterface)
      {
        try
        {
          if (i <= annv.jdField_a_of_type_Int) {
            break;
          }
          j = i;
          if (amsx.a(paramQQAppInterface)) {
            break;
          }
          if (QLog.isColorLevel()) {
            QLog.d("ApolloUtil", 2, new Object[] { "getShareMsgActionId 3d not available actionId:", Integer.valueOf(i) });
          }
          return 0;
        }
        catch (Exception paramQQAppInterface)
        {
          continue;
        }
        paramQQAppInterface = paramQQAppInterface;
        i = 0;
        QLog.e("ApolloUtil", 1, paramQQAppInterface, new Object[0]);
        return i;
      }
      int i = 0;
    }
  }
  
  public static int a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord)
  {
    if ((paramQQAppInterface == null) || (paramMessageRecord == null)) {}
    int i;
    do
    {
      return 0;
      i = amsx.a(paramQQAppInterface);
    } while (i == 0);
    int j = amsx.a(paramQQAppInterface, paramMessageRecord.senderuin);
    if (((j == 2) && (amsx.a(paramQQAppInterface))) || ((j == 0) && (i == 2))) {
      return 2;
    }
    return 1;
  }
  
  public static int a(String paramString)
  {
    try
    {
      if (TextUtils.isEmpty(paramString)) {
        return -1;
      }
      if (paramString.length() > 8)
      {
        paramString = paramString.substring(paramString.length() - 8, paramString.length());
        return Color.parseColor("#" + paramString);
      }
      int i = Integer.parseInt(paramString);
      return i;
    }
    catch (Exception paramString)
    {
      QLog.e("ApolloUtil", 1, paramString.getMessage());
    }
    return -1;
  }
  
  public static int a(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return 0;
    }
    try
    {
      int i = new JSONObject(paramString1).optInt(paramString2);
      return i;
    }
    catch (Exception paramString1)
    {
      QLog.e("ApolloUtil", 2, paramString1.getMessage());
    }
    return 0;
  }
  
  public static long a(String paramString)
  {
    try
    {
      if (!TextUtils.isEmpty(paramString))
      {
        long l = Long.parseLong(paramString);
        return l;
      }
    }
    catch (Exception paramString)
    {
      QLog.e("ApolloUtil", 1, paramString, new Object[0]);
    }
    return 0L;
  }
  
  public static long a(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return 0L;
    }
    try
    {
      long l = new JSONObject(paramString1).optLong(paramString2);
      return l;
    }
    catch (Exception paramString1)
    {
      QLog.e("ApolloUtil", 2, paramString1.getMessage());
    }
    return 0L;
  }
  
  public static amsx a()
  {
    QQAppInterface localQQAppInterface = a();
    if (localQQAppInterface != null) {
      return (amsx)localQQAppInterface.getManager(153);
    }
    return null;
  }
  
  public static SharedPreferences a()
  {
    int i = 0;
    if (BaseApplicationImpl.sProcessId != 1) {
      i = 4;
    }
    return BaseApplicationImpl.getApplication().getSharedPreferences("apollo_game_res", i);
  }
  
  public static Bitmap a()
  {
    Drawable localDrawable = BaseApplicationImpl.getContext().getResources().getDrawable(2130838512);
    if ((localDrawable instanceof BitmapDrawable)) {
      return ((BitmapDrawable)localDrawable).getBitmap();
    }
    return null;
  }
  
  public static Bitmap a(AppInterface paramAppInterface, CmGameStartChecker.StartCheckParam paramStartCheckParam)
  {
    if ((paramStartCheckParam == null) || (paramAppInterface == null)) {
      return null;
    }
    if (paramStartCheckParam.game != null) {}
    for (Object localObject1 = paramStartCheckParam.game.logoUrl;; localObject1 = null)
    {
      Object localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject2 = String.format(Locale.getDefault(), "https://i.hudongcdn.com/%1$d/sp_main_1_1.png", new Object[] { Integer.valueOf(paramStartCheckParam.gameId) });
      }
      localObject1 = new File(annv.s + paramStartCheckParam.gameId + File.separator + annv.v);
      if (!((File)localObject1).exists())
      {
        ((File)localObject1).getParentFile().mkdir();
        localObject2 = new bihu((String)localObject2, (File)localObject1);
        ((bihu)localObject2).p = false;
        ((bihu)localObject2).n = true;
        ((bihu)localObject2).f = "apollo_res";
        ((bihu)localObject2).jdField_b_of_type_Int = 1;
        ((bihu)localObject2).q = true;
        ((bihu)localObject2).r = true;
        int i = bihw.a((bihu)localObject2, paramAppInterface);
        QLog.i("ApolloUtil", 1, "getGameIcon onDone gameId:" + paramStartCheckParam.gameId + " result:" + i);
        if (i != 0) {
          break;
        }
        return BitmapFactory.decodeFile(((File)localObject1).getAbsolutePath());
      }
      if (QLog.isColorLevel()) {
        QLog.i("ApolloUtil", 1, "getGameIcon file exists gameId:" + paramStartCheckParam.gameId);
      }
      return BitmapFactory.decodeFile(((File)localObject1).getAbsolutePath());
    }
  }
  
  public static anpv a(float paramFloat1, float paramFloat2, List<amxr> paramList)
  {
    anpv localanpv = new anpv();
    localanpv.jdField_a_of_type_Int = -1;
    localanpv.jdField_a_of_type_JavaLangString = "";
    if (QLog.isColorLevel()) {
      QLog.d("ApolloSkeletonBounding", 2, new Object[] { "all bounding:", paramList });
    }
    Object localObject1 = paramList.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (amxr)((Iterator)localObject1).next();
      if ((((amxr)localObject2).l > 0.0F) && (((amxr)localObject2).k > 0.0F) && (paramFloat1 >= ((amxr)localObject2).i) && (paramFloat1 <= ((amxr)localObject2).i + ((amxr)localObject2).k) && (paramFloat2 >= ((amxr)localObject2).j) && (paramFloat2 <= ((amxr)localObject2).j + ((amxr)localObject2).l))
      {
        localanpv.jdField_a_of_type_Int = 2;
        if (TextUtils.isEmpty(((amxr)localObject2).jdField_b_of_type_JavaLangString)) {}
        for (paramList = ((amxr)localObject2).jdField_a_of_type_JavaLangString;; paramList = ((amxr)localObject2).jdField_b_of_type_JavaLangString)
        {
          localanpv.jdField_a_of_type_JavaLangString = paramList;
          if (QLog.isColorLevel()) {
            QLog.d("ApolloSkeletonBounding", 2, "gift mNode:" + localanpv.jdField_a_of_type_Int + ",mApolloId=" + localanpv.jdField_a_of_type_JavaLangString);
          }
          return localanpv;
        }
      }
    }
    localObject1 = new ArrayList();
    Object localObject2 = paramList.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      amxr localamxr = (amxr)((Iterator)localObject2).next();
      if (localamxr.jdField_a_of_type_Int != -1001)
      {
        if (((localamxr.s > 0.0F) && (localamxr.t > 0.0F) && (paramFloat1 >= localamxr.q) && (paramFloat1 <= localamxr.q + localamxr.s) && (paramFloat2 >= localamxr.r) && (paramFloat2 <= localamxr.r + localamxr.t)) || ((localamxr.o > 0.0F) && (localamxr.p > 0.0F) && (paramFloat1 >= localamxr.m) && (paramFloat1 <= localamxr.m + localamxr.o) && (paramFloat2 >= localamxr.n) && (paramFloat2 <= localamxr.n + localamxr.p)))
        {
          localanpv.jdField_a_of_type_Int = 3;
          if (TextUtils.isEmpty(localamxr.jdField_b_of_type_JavaLangString)) {}
          for (paramList = localamxr.jdField_a_of_type_JavaLangString;; paramList = localamxr.jdField_b_of_type_JavaLangString)
          {
            localanpv.jdField_a_of_type_JavaLangString = paramList;
            if (QLog.isColorLevel()) {
              QLog.d("ApolloSkeletonBounding", 2, "sprite brand, mNode:" + localanpv.jdField_a_of_type_Int + ",mApolloId=" + localanpv.jdField_a_of_type_JavaLangString);
            }
            return localanpv;
          }
        }
      }
      else {
        ((List)localObject1).add(localamxr);
      }
    }
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (amxr)((Iterator)localObject1).next();
      if ((((amxr)localObject2).jdField_a_of_type_Int == -1001) && (((amxr)localObject2).o > 0.0F) && (((amxr)localObject2).p > 0.0F) && (paramFloat1 >= ((amxr)localObject2).m) && (paramFloat1 <= ((amxr)localObject2).m + ((amxr)localObject2).o) && (paramFloat2 >= ((amxr)localObject2).n) && (paramFloat2 <= ((amxr)localObject2).n + ((amxr)localObject2).p))
      {
        localanpv.jdField_a_of_type_Int = 4;
        if (TextUtils.isEmpty(((amxr)localObject2).jdField_b_of_type_JavaLangString)) {}
        for (paramList = ((amxr)localObject2).jdField_a_of_type_JavaLangString;; paramList = ((amxr)localObject2).jdField_b_of_type_JavaLangString)
        {
          localanpv.jdField_a_of_type_JavaLangString = paramList;
          if (QLog.isColorLevel()) {
            QLog.d("ApolloSkeletonBounding", 2, "pet brand, mNode:" + localanpv.jdField_a_of_type_Int + ",mApolloId=" + localanpv.jdField_a_of_type_JavaLangString);
          }
          return localanpv;
        }
      }
    }
    localObject1 = paramList.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (amxr)((Iterator)localObject1).next();
      if ((((amxr)localObject2).g > 0.0F) && (((amxr)localObject2).h > 0.0F) && (paramFloat1 >= ((amxr)localObject2).e) && (paramFloat1 <= ((amxr)localObject2).e + ((amxr)localObject2).g) && (paramFloat2 >= ((amxr)localObject2).f) && (paramFloat2 <= ((amxr)localObject2).f + ((amxr)localObject2).h))
      {
        localanpv.jdField_a_of_type_Int = 1000;
        if (TextUtils.isEmpty(((amxr)localObject2).jdField_b_of_type_JavaLangString)) {}
        for (paramList = ((amxr)localObject2).jdField_a_of_type_JavaLangString;; paramList = ((amxr)localObject2).jdField_b_of_type_JavaLangString)
        {
          localanpv.jdField_a_of_type_JavaLangString = paramList;
          if (QLog.isColorLevel()) {
            QLog.d("ApolloSkeletonBounding", 2, "bubble, mNode:" + localanpv.jdField_a_of_type_Int + ",mApolloId=" + localanpv.jdField_a_of_type_JavaLangString);
          }
          return localanpv;
        }
      }
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      localObject1 = (amxr)paramList.next();
      if ((paramFloat1 >= ((amxr)localObject1).jdField_a_of_type_Float) && (paramFloat1 <= ((amxr)localObject1).jdField_a_of_type_Float + ((amxr)localObject1).c) && (paramFloat2 >= ((amxr)localObject1).jdField_b_of_type_Float) && (paramFloat2 <= ((amxr)localObject1).jdField_b_of_type_Float + ((amxr)localObject1).d))
      {
        localanpv.jdField_a_of_type_Int = 1;
        if (TextUtils.isEmpty(((amxr)localObject1).jdField_b_of_type_JavaLangString)) {}
        for (paramList = ((amxr)localObject1).jdField_a_of_type_JavaLangString;; paramList = ((amxr)localObject1).jdField_b_of_type_JavaLangString)
        {
          localanpv.jdField_a_of_type_JavaLangString = paramList;
          if (QLog.isColorLevel()) {
            QLog.d("ApolloSkeletonBounding", 2, "other cmshow area, mNode:" + localanpv.jdField_a_of_type_Int + ",mApolloId=" + localanpv.jdField_a_of_type_JavaLangString);
          }
          return localanpv;
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("ApolloSkeletonBounding", 2, "not cmshow area, mNode:" + localanpv.jdField_a_of_type_Int + ",mApolloId=" + localanpv.jdField_a_of_type_JavaLangString);
    }
    return localanpv;
  }
  
  public static anpw a()
  {
    try
    {
      if (jdField_a_of_type_Anpw == null) {
        jdField_a_of_type_Anpw = new anpw();
      }
      jdField_a_of_type_Anpw.d = Runtime.getRuntime().freeMemory();
      jdField_a_of_type_Anpw.jdField_b_of_type_Long = Runtime.getRuntime().maxMemory();
      jdField_a_of_type_Anpw.c = Runtime.getRuntime().totalMemory();
      anpw localanpw = jdField_a_of_type_Anpw;
      return localanpw;
    }
    catch (Exception localException)
    {
      QLog.e("ApolloUtil", 1, "getHardwareInfo e:", localException);
    }
    return null;
  }
  
  public static ApolloCmdChannel a()
  {
    Object localObject = a();
    if (localObject != null) {
      return ApolloCmdChannel.getChannel((QQAppInterface)localObject);
    }
    localObject = a();
    if (localObject != null) {
      return ApolloCmdChannel.getChannelFromOtherProcess((AppRuntime)localObject);
    }
    QLog.e("ApolloUtil", 1, "getCmdChannel app is null");
    return null;
  }
  
  public static QQAppInterface a()
  {
    Object localObject = BaseApplicationImpl.getApplication();
    if (localObject != null)
    {
      localObject = ((BaseApplicationImpl)localObject).getRuntime();
      if ((localObject != null) && ((localObject instanceof QQAppInterface))) {
        return (QQAppInterface)localObject;
      }
    }
    return null;
  }
  
  public static ApolloUserTrace.STUserTrackReq a(String paramString)
  {
    ApolloUserTrace.STUserTrackReq localSTUserTrackReq = new ApolloUserTrace.STUserTrackReq();
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return localSTUserTrackReq;
      try
      {
        long l1 = System.currentTimeMillis();
        paramString = new JSONObject(paramString);
        localSTUserTrackReq.strFrom.set(paramString.optString("from"));
        localSTUserTrackReq.playts.set(paramString.optInt("playts"));
        localSTUserTrackReq.roomId.set(paramString.optLong("roomId"));
        localSTUserTrackReq.gameId.set(paramString.optInt("gameId"));
        if (paramString.has("userTrack"))
        {
          Object localObject = paramString.getJSONObject("userTrack");
          paramString = new ApolloUserTrace.STUserClickTrack();
          paramString.name.set(((JSONObject)localObject).optString("name"));
          paramString.screenScale.set(((JSONObject)localObject).optInt("screenscale"));
          paramString.screenX.set(((JSONObject)localObject).optInt("screenwidth"));
          paramString.screenY.set(((JSONObject)localObject).optInt("screenheight"));
          paramString.time.set(((JSONObject)localObject).optInt("time"));
          if (((JSONObject)localObject).has("record"))
          {
            localObject = ((JSONObject)localObject).getJSONArray("record");
            if ((localObject == null) || (((JSONArray)localObject).length() == 0)) {
              continue;
            }
            int i = 0;
            while (i < ((JSONArray)localObject).length())
            {
              JSONObject localJSONObject = ((JSONArray)localObject).getJSONObject(i);
              ApolloUserTrace.STClickInfo localSTClickInfo = new ApolloUserTrace.STClickInfo();
              localSTClickInfo.posx.set(localJSONObject.optInt("posx"));
              localSTClickInfo.angularvel.set(localJSONObject.optInt("angularvel"));
              localSTClickInfo.btnstate.set(localJSONObject.optInt("btnstate"));
              localSTClickInfo.time.set(localJSONObject.optInt("time"));
              localSTClickInfo.rotx.set(localJSONObject.optInt("rotx"));
              localSTClickInfo.velx.set(localJSONObject.optInt("velx"));
              localSTClickInfo.vely.set(localJSONObject.optInt("vely"));
              localSTClickInfo.roty.set(localJSONObject.optInt("roty"));
              localSTClickInfo.posy.set(localJSONObject.optInt("posy"));
              paramString.list.add(localSTClickInfo);
              i += 1;
            }
            if (QLog.isColorLevel()) {
              QLog.d("ApolloUtil", 2, "trace.len:" + paramString.list.size());
            }
          }
          localSTUserTrackReq.userClick.set(paramString);
        }
        else
        {
          long l2 = System.currentTimeMillis();
          if (QLog.isColorLevel())
          {
            QLog.d("ApolloUtil", 2, "trace parsing cost:" + (l2 - l1));
            return localSTUserTrackReq;
          }
        }
      }
      catch (Exception paramString)
      {
        QLog.e("ApolloUtil", 1, "errInfo->" + paramString.getMessage());
      }
    }
    return localSTUserTrackReq;
  }
  
  public static File a(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return null;
    }
    paramString1 = new File(paramString1);
    if ((paramString1 == null) || (!paramString1.isDirectory())) {
      return null;
    }
    paramString1 = paramString1.listFiles();
    if (paramString1 == null) {
      return null;
    }
    int i = 0;
    while (i < paramString1.length)
    {
      File localFile = paramString1[i];
      if ((localFile.isFile()) && (localFile.getPath().substring(localFile.getPath().length() - paramString2.length()).equals(paramString2))) {
        return localFile;
      }
      i += 1;
    }
    return null;
  }
  
  public static String a()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime instanceof QQAppInterface)) {
      return ((QQAppInterface)localAppRuntime).c();
    }
    return localAppRuntime.getAccount();
  }
  
  public static String a(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder(100);
    if ((paramInt == 1) || (paramInt == 2)) {
      localStringBuilder.append(annv.s).append(paramInt).append(File.separator).append("main.lua");
    }
    for (;;)
    {
      return localStringBuilder.toString();
      localStringBuilder.append(annv.s).append(paramInt).append(File.separator).append("main.js");
    }
  }
  
  public static String a(Paint paramPaint, float paramFloat, String paramString, int paramInt)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramPaint == null) || (paramFloat <= 0.0F)) {
      return "";
    }
    String[] arrayOfString = paramString.replaceAll("\r", "").split("\n");
    StringBuilder localStringBuilder = new StringBuilder();
    int n = arrayOfString.length;
    int m = 0;
    int i = 0;
    if (m < n)
    {
      String str = arrayOfString[m];
      if (paramPaint.measureText(str) <= paramFloat) {
        localStringBuilder.append(str);
      }
      float f;
      int k;
      label114:
      do
      {
        localStringBuilder.append("\n");
        m += 1;
        break;
        j = 0;
        f = 0.0F;
        k = 0;
        i = k;
      } while (j == str.length());
      char c1 = str.charAt(j);
      f += paramPaint.measureText(String.valueOf(c1));
      if (f <= paramFloat) {
        localStringBuilder.append(c1);
      }
      for (;;)
      {
        j += 1;
        break label114;
        k += 1;
        i = k;
        if (k >= paramInt) {
          break;
        }
        localStringBuilder.append("\n");
        j -= 1;
        f = 0.0F;
      }
    }
    if (!paramString.endsWith("\n")) {
      localStringBuilder.deleteCharAt(localStringBuilder.length() - 1);
    }
    int j = localStringBuilder.length();
    paramFloat = paramPaint.measureText(String.valueOf("…"));
    if (i >= paramInt) {
      paramInt = j;
    }
    for (;;)
    {
      if (paramInt >= 1)
      {
        if (paramPaint.measureText(localStringBuilder.substring(paramInt - 1, j)) >= paramFloat) {
          localStringBuilder.replace(paramInt - 1, j, "…");
        }
      }
      else {
        return localStringBuilder.toString();
      }
      paramInt -= 1;
    }
  }
  
  public static String a(QQAppInterface paramQQAppInterface, MessageForApollo paramMessageForApollo)
  {
    Object localObject;
    if (paramMessageForApollo == null) {
      localObject = anzj.a(2131699464);
    }
    String str2;
    do
    {
      String str1;
      do
      {
        return localObject;
        localObject = c(paramQQAppInterface, paramMessageForApollo);
        str1 = anzj.a(2131699465) + (String)localObject;
        str2 = anzj.a(2131699462);
        localObject = str1;
      } while (!ApolloGameUtil.a(paramMessageForApollo.msgType));
      localObject = str1;
    } while (!a(paramQQAppInterface, paramMessageForApollo));
    if (!TextUtils.isEmpty(paramMessageForApollo.gameName)) {
      return str2 + paramMessageForApollo.gameName;
    }
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface = ((annx)paramQQAppInterface.getManager(155)).a(paramMessageForApollo.gameId);
      if (paramQQAppInterface != null) {
        return str2 + paramQQAppInterface.name;
      }
      return str2 + anzj.a(2131699458);
    }
    return str2 + anzj.a(2131699446);
  }
  
  public static String a(ApolloActionData paramApolloActionData, int paramInt)
  {
    if (paramApolloActionData == null) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder(100);
    switch (paramInt)
    {
    }
    for (;;)
    {
      return localStringBuilder.toString();
      localStringBuilder.append(annv.jdField_d_of_type_JavaLangString).append(paramApolloActionData.actionId).append(File.separator).append("panelView.png");
      continue;
      localStringBuilder.append("https://cmshow.gtimg.cn/qqshow/admindata/comdata/vipApollo_action_").append(paramApolloActionData.actionId).append("/preview.png");
      continue;
      localStringBuilder.append(annv.jdField_d_of_type_JavaLangString).append(paramApolloActionData.actionId).append(File.separator).append("panelGif.gif");
      continue;
      localStringBuilder.append("https://cmshow.gtimg.cn/qqshow/admindata/comdata/vipApollo_action_").append(paramApolloActionData.actionId).append("/preview.gif");
      continue;
      localStringBuilder.append(annv.jdField_d_of_type_JavaLangString).append(paramApolloActionData.actionId).append(File.separator).append("actionRes.zip");
      continue;
      localStringBuilder.append("https://cmshow.gtimg.cn/qqshow/admindata/comdata/vipApollo_action_").append(paramApolloActionData.actionId).append("/d.zip");
      continue;
      localStringBuilder.append(annv.jdField_d_of_type_JavaLangString).append(paramApolloActionData.actionId).append(File.separator);
      continue;
      localStringBuilder.append(annv.jdField_d_of_type_JavaLangString).append(paramApolloActionData.actionId).append(File.separator).append("config.json");
      continue;
      localStringBuilder.append(annv.q).append(paramApolloActionData.actionId);
      continue;
      localStringBuilder.append("https://cmshow.gtimg.cn/qqshow/admindata/comdata/vipApollo_drawerAction_").append(paramApolloActionData.actionId).append("/d.zip");
    }
  }
  
  public static String a(ApolloActionPackage paramApolloActionPackage)
  {
    if (paramApolloActionPackage == null) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder(100);
    localStringBuilder.append(annv.n).append(paramApolloActionPackage.packageId).append(File.separator).append("tab.png");
    return localStringBuilder.toString();
  }
  
  public static String a(MessageForApollo paramMessageForApollo)
  {
    if ((paramMessageForApollo.mApolloMessage != null) && (paramMessageForApollo.mApolloMessage.name != null) && (paramMessageForApollo.mApolloMessage.name.length > 0))
    {
      StringBuilder localStringBuilder = new StringBuilder(new String(paramMessageForApollo.mApolloMessage.name));
      if ((paramMessageForApollo.mApolloMessage.text != null) && (paramMessageForApollo.mApolloMessage.text.length > 0))
      {
        localStringBuilder.append("：").append(new String(paramMessageForApollo.mApolloMessage.text));
        if (!TextUtils.isEmpty(paramMessageForApollo.inputText)) {
          localStringBuilder.append(" ").append(paramMessageForApollo.inputText);
        }
      }
      for (;;)
      {
        return localStringBuilder.toString();
        if (!TextUtils.isEmpty(paramMessageForApollo.inputText)) {
          localStringBuilder.append("：").append(paramMessageForApollo.inputText);
        }
      }
    }
    return anzj.a(2131699471);
  }
  
  public static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while (!a()) {
      return paramString;
    }
    QLog.d("ApolloUtil", 2, new Object[] { "checkWrapApolloUrl url:", paramString });
    String str = paramString;
    if (!paramString.contains("open.cmshow.qq.com")) {
      str = paramString.replace("//cmshow.qq.com", "//open.cmshow.qq.com").replace("//cmshow.gtimg.cn", "//open.cmshow.qq.com");
    }
    paramString = str;
    int j;
    if (str.contains("open.cmshow.qq.com"))
    {
      j = str.indexOf("&_bid=");
      if (j >= 0) {
        break label212;
      }
      j = str.indexOf("_bid=");
    }
    label199:
    label206:
    label209:
    label212:
    for (int i = 0;; i = 1)
    {
      paramString = str;
      if (j > 0)
      {
        paramString = str.substring(0, j);
        str = str.substring(j + "_bid=".length());
        if (TextUtils.isEmpty(str)) {
          break label209;
        }
        j = str.indexOf("&");
        if (j < 0) {
          break label206;
        }
        if (i == 0) {
          break label199;
        }
        i = j;
        str = str.substring(i);
        paramString = paramString + str;
      }
      for (;;)
      {
        QLog.d("ApolloUtil", 2, new Object[] { "checkWrapApolloUrl replaceUrl:", paramString });
        return paramString;
        i = j + 1;
        break;
      }
    }
  }
  
  public static String a(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return "";
    }
    try
    {
      paramString1 = new JSONObject(paramString1).optString(paramString2);
      return paramString1;
    }
    catch (Exception paramString1)
    {
      QLog.e("ApolloUtil", 2, paramString1.getMessage());
    }
    return "";
  }
  
  public static ArrayList a(SparseArray paramSparseArray)
  {
    Object localObject;
    if ((paramSparseArray == null) || (paramSparseArray.size() == 0))
    {
      localObject = new ArrayList();
      return localObject;
    }
    ArrayList localArrayList = new ArrayList();
    int j = paramSparseArray.size();
    int i = 0;
    for (;;)
    {
      localObject = localArrayList;
      if (i >= j) {
        break;
      }
      localArrayList.add(paramSparseArray.get(paramSparseArray.keyAt(i)));
      i += 1;
    }
  }
  
  public static ArrayList<Integer> a(QQAppInterface paramQQAppInterface)
  {
    int i = 0;
    if (paramQQAppInterface == null) {
      paramQQAppInterface = null;
    }
    for (;;)
    {
      return paramQQAppInterface;
      localArrayList = new ArrayList();
      Object localObject = BaseApplicationImpl.getContext().getSharedPreferences("apollo_sp", 0).getString("sp_key_apollo_game_life" + paramQQAppInterface.c(), "");
      paramQQAppInterface = localArrayList;
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        continue;
      }
      localObject = ((String)localObject).split(",");
      paramQQAppInterface = localArrayList;
      if (localObject == null) {
        continue;
      }
      paramQQAppInterface = localArrayList;
      if (localObject.length <= 0) {
        continue;
      }
      try
      {
        int j = localObject.length;
        for (;;)
        {
          paramQQAppInterface = localArrayList;
          if (i >= j) {
            break;
          }
          localArrayList.add(Integer.valueOf(Integer.parseInt(localObject[i])));
          i += 1;
        }
        return localArrayList;
      }
      catch (Exception paramQQAppInterface)
      {
        QLog.e("ApolloUtil", 1, "[getAddedFaceList] exception=", paramQQAppInterface);
      }
    }
  }
  
  public static AppRuntime a()
  {
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
    if (localBaseApplicationImpl != null) {
      return localBaseApplicationImpl.getRuntime();
    }
    return null;
  }
  
  public static void a()
  {
    ThreadManager.post(new ApolloUtil.6(), 5, null, true);
  }
  
  public static void a(int paramInt)
  {
    jdField_a_of_type_Int = paramInt;
    BaseApplicationImpl.getApplication().getSharedPreferences("apollo_user_config", 4).edit().putInt("MSAA_level", paramInt).commit();
  }
  
  private static void a(int paramInt, String paramString, QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    if ((paramQQAppInterface != null) && (paramSessionInfo != null)) {
      VipUtils.a(paramQQAppInterface, "cmshow", "Apollo", "eggaction", b(paramSessionInfo.jdField_a_of_type_Int), 0, new String[] { String.valueOf(paramInt), paramString });
    }
  }
  
  public static void a(Activity paramActivity, String paramString1, String paramString2)
  {
    bmup.a(paramActivity, paramString1, paramString2);
  }
  
  public static void a(Activity paramActivity, String paramString1, String paramString2, int paramInt)
  {
    Intent localIntent = new Intent(paramActivity, ForwardRecentActivity.class);
    Bundle localBundle = new Bundle();
    localBundle.putInt("forward_type", 1);
    if ((paramString1 == null) || (!new File(paramString1).exists())) {}
    for (;;)
    {
      return;
      String str;
      if (!TextUtils.isEmpty(paramString2))
      {
        str = paramString2;
        if (new File(paramString2).exists()) {}
      }
      else
      {
        str = bhmq.a(paramActivity, paramString1);
      }
      try
      {
        if ((azru.b()) && (bhmq.b(paramString1))) {
          azru.b(paramString1, str, true, "", 0);
        }
        while ((!TextUtils.isEmpty(str)) && (new File(str).exists()))
        {
          localBundle.putBoolean("isFromShare", true);
          localBundle.putString("forward_thumb", str);
          localBundle.putString("forward_filepath", paramString1);
          localBundle.putString("forward_extra", paramString1);
          localBundle.putBoolean("k_favorites", false);
          localBundle.putBoolean("isFromFavorites", true);
          localBundle.putInt("extra_key_from_apollo", paramInt);
          localIntent.putExtras(localBundle);
          paramActivity.startActivityForResult(localIntent, 103);
          return;
          azru.a(paramString1, str, true, "", 0);
        }
      }
      catch (Exception paramString2)
      {
        for (;;)
        {
          QLog.e("ApolloUtil", 2, paramString2.getMessage());
        }
      }
    }
  }
  
  public static void a(Context paramContext)
  {
    Intent localIntent = new Intent(paramContext, QQBrowserActivity.class);
    localIntent.putExtra("big_brother_source_key", "biz_src_zf_lmx");
    VasWebviewUtil.openQQBrowserActivity(paramContext, annv.ak, -1L, localIntent, false, -1);
  }
  
  public static void a(Context paramContext, int paramInt1, int paramInt2)
  {
    if ((paramContext instanceof Activity)) {}
  }
  
  public static void a(Context paramContext, int paramInt, Intent paramIntent)
  {
    a(paramContext, paramIntent, null, annv.am + "&adSrc=" + paramInt, null);
  }
  
  public static void a(Context paramContext, Intent paramIntent, String paramString1, String paramString2, AppInterface paramAppInterface)
  {
    a(paramContext, paramIntent, paramString1, paramString2, paramAppInterface, 0);
  }
  
  public static void a(Context paramContext, Intent paramIntent, String paramString1, String paramString2, AppInterface paramAppInterface, int paramInt)
  {
    if (paramContext == null) {
      return;
    }
    Intent localIntent = null;
    Object localObject;
    if (paramAppInterface == null)
    {
      localObject = BaseApplicationImpl.getApplication();
      if (localObject != null)
      {
        localObject = ((BaseApplicationImpl)localObject).getRuntime();
        if ((localObject != null) && ((localObject instanceof AppInterface))) {
          paramAppInterface = (AppInterface)localObject;
        }
      }
    }
    for (;;)
    {
      localObject = localIntent;
      if (paramAppInterface != null)
      {
        localObject = localIntent;
        if ((paramAppInterface instanceof QQAppInterface)) {
          localObject = (amsx)((QQAppInterface)paramAppInterface).getManager(153);
        }
      }
      if (!amsx.c(paramContext))
      {
        paramIntent = new Intent(paramContext, QQBrowserActivity.class);
        paramIntent.putExtra("big_brother_source_key", "biz_src_zf_lmx");
        VasWebviewUtil.openQQBrowserActivity(paramContext, annv.U, -1L, paramIntent, false, -1);
        return;
        if ((localObject instanceof ToolAppRuntime))
        {
          localObject = ((AppRuntime)localObject).getAppRuntime("modular_web");
          if ((localObject instanceof AppInterface)) {
            paramAppInterface = (AppInterface)localObject;
          }
        }
      }
      else
      {
        if ((1 != amsx.a(paramAppInterface)) || ((paramAppInterface != null) && ((paramAppInterface instanceof QQAppInterface)) && (!ApolloGameUtil.a((QQAppInterface)paramAppInterface))))
        {
          paramIntent = new Intent(paramContext, QQBrowserActivity.class);
          paramIntent.putExtra("big_brother_source_key", "biz_src_zf_lmx");
          VasWebviewUtil.openQQBrowserActivity(paramContext, annv.V + "0", -1L, paramIntent, false, -1);
          return;
        }
        localIntent = paramIntent;
        if (paramIntent == null) {
          localIntent = new Intent();
        }
        if ((paramAppInterface != null) && ((paramAppInterface instanceof QQAppInterface)) && (amsx.a((QQAppInterface)paramAppInterface))) {}
        for (int i = 1;; i = 0)
        {
          paramIntent = paramString2;
          if (!TextUtils.isEmpty(paramString2))
          {
            paramIntent = paramString2;
            if (paramString2.contains("tab=3d"))
            {
              paramIntent = paramString2;
              if (i == 0) {
                paramIntent = annv.ai;
              }
            }
          }
          paramString2 = paramIntent;
          if (!TextUtils.isEmpty(annv.ai))
          {
            paramString2 = paramIntent;
            if (annv.ai.equals(paramIntent))
            {
              paramString2 = paramIntent;
              if (i != 0) {
                paramString2 = annv.aq;
              }
            }
          }
          if (localIntent.getIntExtra("key_box_type", 0) != 3) {
            break;
          }
          paramIntent = annv.ad;
          paramString1 = new Intent(paramContext, QQBrowserActivity.class);
          localIntent.putExtra("big_brother_source_key", "biz_src_zf_lmx");
          VasWebviewUtil.openQQBrowserActivity(paramContext, paramIntent, -1L, paramString1, false, -1);
          return;
        }
        if (paramAppInterface != null)
        {
          paramIntent = paramAppInterface.getCurrentNickname();
          paramAppInterface.getLongAccountUin();
        }
        label897:
        label1027:
        for (;;)
        {
          localIntent.putExtra("extra_key_nickname", paramIntent);
          if (!TextUtils.isEmpty(paramString1)) {
            localIntent.putExtra("extra_key_adtag", paramString1);
          }
          localIntent.putExtra("extra_key_click_time", System.currentTimeMillis());
          localIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
          if (QLog.isColorLevel()) {
            QLog.d("ApolloUtil", 2, "apollo_client, clickTime:" + bhsw.a(System.currentTimeMillis(), "dd-MMM-yyyy HH:mm:ss:SSS") + ",url:" + paramString2);
          }
          if (!TextUtils.isEmpty(paramString2))
          {
            paramString1 = paramString2.replace("_bid=2423&", "");
            paramIntent = paramString1;
            if (!amyq.jdField_d_of_type_Boolean) {
              break label1091;
            }
            if (!TextUtils.isEmpty(amyq.c))
            {
              paramIntent = blhn.a(paramString1, "wording", amyq.c);
              paramString1 = paramIntent;
              if (!TextUtils.isEmpty(amyq.jdField_d_of_type_JavaLangString)) {
                paramString1 = blhn.a(paramIntent, "bubble_id", amyq.jdField_d_of_type_JavaLangString);
              }
              paramIntent = paramString1;
              if (TextUtils.isEmpty(amyq.jdField_b_of_type_JavaLangString)) {
                break label1091;
              }
              paramIntent = blhn.a(paramString1, "tip_url", amyq.jdField_b_of_type_JavaLangString);
            }
          }
          label648:
          label666:
          label924:
          label942:
          label1076:
          label1083:
          label1091:
          for (;;)
          {
            if (localObject != null) {
              if (((amsx)localObject).jdField_d_of_type_Boolean)
              {
                paramString1 = "1";
                paramString1 = blhn.a(paramIntent, "is_new_store_user", paramString1);
                if (i == 0) {
                  break label863;
                }
                paramIntent = "1";
                paramIntent = blhn.a(paramString1, "is_3d_available", paramIntent);
              }
            }
            for (;;)
            {
              if (localIntent.getBooleanExtra("extra_key_open_box", false)) {
                if (amsx.d()) {
                  localIntent.putExtra("extra_key_open_box", false);
                }
              }
              for (paramIntent = blhn.a(paramIntent, "boxReady", "1");; paramIntent = blhn.a(paramIntent, "boxReady", "0"))
              {
                localIntent.putExtra("url", paramIntent);
                localIntent.putExtra("url", paramIntent);
                if ((!paramIntent.contains("webviewCheckType=1")) && (!paramIntent.contains("webviewCheckType=2"))) {
                  break label1048;
                }
                localIntent.setClass(paramContext, ApolloStoreActivity.class);
                if (QLog.isColorLevel()) {
                  QLog.d("ApolloUtil", 2, "apollo_client, ApolloStoreActivity");
                }
                if (!(paramContext instanceof Activity)) {
                  localIntent.addFlags(268435456);
                }
                localIntent.putExtra("big_brother_source_key", "biz_src_zf_lmx");
                if ((!(paramContext instanceof Activity)) || (paramInt <= 0)) {
                  break label1076;
                }
                ((Activity)paramContext).startActivityForResult(localIntent, paramInt);
                return;
                paramIntent = paramString1;
                if (TextUtils.isEmpty(amyq.jdField_a_of_type_JavaLangString)) {
                  break;
                }
                paramIntent = blhn.a(paramString1, "wording", amyq.jdField_a_of_type_JavaLangString);
                break;
                paramString1 = "0";
                break label648;
                label863:
                paramIntent = "0";
                break label666;
              }
              if (!TextUtils.isEmpty(annv.ah))
              {
                paramIntent = annv.ah;
                paramString1 = paramIntent.replace("_bid=2423&", "");
                if (localObject == null) {
                  break label1083;
                }
                if (!((amsx)localObject).jdField_d_of_type_Boolean) {
                  break label1020;
                }
                paramIntent = "1";
                paramString1 = blhn.a(paramString1, "is_new_store_user", paramIntent);
                if (i == 0) {
                  break label1027;
                }
                paramIntent = "1";
              }
              for (paramIntent = blhn.a(paramString1, "is_3d_available", paramIntent);; paramIntent = paramString1)
              {
                if (localIntent.getBooleanExtra("extra_key_open_box", false)) {
                  if (amsx.d()) {
                    localIntent.putExtra("extra_key_open_box", false);
                  }
                }
                for (paramIntent = blhn.a(paramIntent, "boxReady", "1");; paramIntent = blhn.a(paramIntent, "boxReady", "0"))
                {
                  localIntent.putExtra("url", paramIntent);
                  localIntent.putExtra("url", paramIntent);
                  break;
                  paramIntent = annv.W;
                  break label897;
                  label1020:
                  paramIntent = "0";
                  break label924;
                  paramIntent = "0";
                  break label942;
                }
                localIntent.setClass(paramContext, ApolloStoreActivity.class);
                if (!QLog.isColorLevel()) {
                  break label779;
                }
                QLog.d("ApolloUtil", 2, "apollo_client, ApolloStoreActivity");
                break label779;
                paramContext.startActivity(localIntent);
                return;
              }
            }
          }
          label779:
          label1048:
          paramIntent = "";
        }
      }
    }
  }
  
  public static void a(Context paramContext, String paramString)
  {
    Intent localIntent = new Intent(paramContext, QQBrowserActivity.class);
    localIntent.putExtra("big_brother_source_key", "biz_src_zf_lmx");
    VasWebviewUtil.openQQBrowserActivity(paramContext, paramString, -1L, localIntent, false, -1);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(annv.ab).append(paramString1).append("&adtag=").append(paramString2);
    paramString1 = new Intent(paramContext, QQBrowserActivity.class);
    paramString1.putExtra("big_brother_source_key", "biz_src_zf_lmx");
    VasWebviewUtil.openQQBrowserActivity(paramContext, localStringBuilder.toString(), -1L, paramString1, false, -1);
    if (QLog.isColorLevel()) {
      QLog.d("ApolloUtil", 2, new Object[] { "openCollectCard:", localStringBuilder.toString() });
    }
  }
  
  public static void a(View paramView, int paramInt)
  {
    if (paramView == null) {
      return;
    }
    try
    {
      paramView.setBackgroundResource(paramInt);
      return;
    }
    catch (Exception paramView) {}catch (OutOfMemoryError paramView) {}
  }
  
  public static void a(View paramView, QQAppInterface paramQQAppInterface, bhuk parambhuk) {}
  
  public static void a(View paramView, FileManagerEntity paramFileManagerEntity, QQAppInterface paramQQAppInterface) {}
  
  public static void a(ImageView paramImageView, int paramInt)
  {
    if (paramImageView == null) {
      return;
    }
    paramImageView.setImageResource(2130838623);
  }
  
  public static void a(ImageView paramImageView, boolean paramBoolean1, boolean paramBoolean2)
  {
    paramImageView.setImageResource(2130838582);
  }
  
  public static void a(bhuk parambhuk, String paramString) {}
  
  public static void a(bihu parambihu)
  {
    if ((parambihu != null) && (parambihu.a != null))
    {
      int i = 0;
      if (i < parambihu.a.size())
      {
        String str = (String)parambihu.a.get(i);
        if (!TextUtils.isEmpty(str))
        {
          if (!str.contains("http://cmshow.qq.com")) {
            break label85;
          }
          parambihu.a.set(i, str.replace("http://cmshow.qq.com", "https://cmshow.qq.com"));
        }
        for (;;)
        {
          i += 1;
          break;
          label85:
          if (str.contains("http://cmshow.gtimg.com")) {
            parambihu.a.set(i, str.replace("http://cmshow.gtimg.com", "https://cmshow.gtimg.com"));
          }
        }
      }
    }
  }
  
  public static void a(BaseChatPie paramBaseChatPie, int paramInt)
  {
    if (paramBaseChatPie == null) {}
    SessionInfo localSessionInfo;
    String str2;
    String str3;
    label105:
    String str1;
    SharedPreferences localSharedPreferences;
    do
    {
      for (;;)
      {
        return;
        localSessionInfo = paramBaseChatPie.a();
        if (localSessionInfo != null)
        {
          boolean bool = ApolloGameUtil.a(paramBaseChatPie.a());
          if (amsx.c("gameSwitch") == 1) {}
          for (int i = 1; (!bool) && (i != 0) && (paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (paramBaseChatPie.jdField_a_of_type_AndroidContentContext != null); i = 0)
          {
            str2 = localSessionInfo.jdField_a_of_type_JavaLangString;
            str3 = paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c();
            if ((!TextUtils.isEmpty(str2)) && (!TextUtils.isEmpty(str3))) {
              break label105;
            }
            QLog.d("ApolloUtil", 1, " friendUin or currentUin is null");
            return;
          }
        }
      }
      str1 = "apollo_invite_game_gray_tip_" + str3;
      localSharedPreferences = SharedPreferencesProxyManager.getInstance().getProxy("apollo_sp", 0);
      List localList = paramBaseChatPie.a().a().a(localSessionInfo.jdField_a_of_type_JavaLangString, localSessionInfo.jdField_a_of_type_Int, null, 1);
      localObject2 = Boolean.valueOf(true);
      localObject1 = localObject2;
      if (localList != null)
      {
        localObject1 = localObject2;
        if (localList.size() > 0)
        {
          localObject1 = localObject2;
          if (localList.get(0) != null)
          {
            localObject1 = localObject2;
            if ((localList.get(0) instanceof MessageForUniteGrayTip)) {
              localObject1 = Boolean.valueOf(false);
            }
          }
        }
      }
    } while ((!((Boolean)localObject1).booleanValue()) || ((paramInt != 1) && ((paramInt != 0) || (!localSharedPreferences.getBoolean(str1, true)))) || ((amsx)paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153) == null));
    long l = bcrg.a();
    Object localObject2 = anzj.a(2131699449);
    paramInt = ((String)localObject2).indexOf(anzj.a(2131699452));
    Object localObject1 = new Bundle();
    ((Bundle)localObject1).putInt("key_action", 1);
    ((Bundle)localObject1).putString("textColor", "#40A0FF");
    ((Bundle)localObject1).putString("key_action_DATA", annv.V + "&adTag=gametips");
    localObject2 = new avpd(str2, str3, (String)localObject2, localSessionInfo.jdField_a_of_type_Int, -5040, 2359298, l);
    ((avpd)localObject2).a(paramInt, paramInt + 7, (Bundle)localObject1);
    localObject1 = new MessageForUniteGrayTip();
    ((MessageForUniteGrayTip)localObject1).initGrayTipMsg(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (avpd)localObject2);
    avpe.a(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageForUniteGrayTip)localObject1);
    if (QLog.isColorLevel()) {
      QLog.d("ApolloUtil", 2, "send apollo gray tip");
    }
    localSharedPreferences.edit().putBoolean(str1, false).commit();
    VipUtils.a(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "intro_show", b(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), 0, new String[0]);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    if ((paramQQAppInterface == null) || (paramSessionInfo == null) || (!jdField_a_of_type_Boolean)) {}
    String str2;
    String str1;
    SharedPreferences localSharedPreferences;
    do
    {
      return;
      jdField_a_of_type_Boolean = false;
      localObject = paramSessionInfo.jdField_a_of_type_JavaLangString;
      str2 = paramQQAppInterface.c();
      str1 = "apollo_white_face_unsupport_gray_tip" + str2;
      localSharedPreferences = SharedPreferencesProxyManager.getInstance().getProxy("apollo_sp", 0);
    } while (!localSharedPreferences.getBoolean(str1, true));
    long l = bcrg.a();
    paramSessionInfo = new avpd((String)localObject, str2, anzj.a(2131699451), paramSessionInfo.jdField_a_of_type_Int, -5040, 2359299, l);
    Object localObject = new MessageForUniteGrayTip();
    ((MessageForUniteGrayTip)localObject).initGrayTipMsg(paramQQAppInterface, paramSessionInfo);
    avpe.a(paramQQAppInterface, (MessageForUniteGrayTip)localObject);
    if (QLog.isColorLevel()) {
      QLog.d("ApolloUtil", 2, "addWhiteFaceUnSupportTips send white face unsupport gray tip");
    }
    localSharedPreferences.edit().putBoolean(str1, false).commit();
    VipUtils.a(paramQQAppInterface, "cmshow", "Apollo", "graystripe_3Demotion_view", 0, 0, new String[] { "" });
  }
  
  public static void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, ChatMessage paramChatMessage, int paramInt1, int paramInt2)
  {
    if ((paramQQAppInterface == null) || (paramSessionInfo == null) || (paramChatMessage == null)) {
      QLog.e("ApolloUtil", 1, "[playShareMsgAction] param null, abort");
    }
    while ((paramSessionInfo.jdField_a_of_type_Int != 0) && (paramSessionInfo.jdField_a_of_type_Int != 1) && (paramSessionInfo.jdField_a_of_type_Int != 3000)) {
      return;
    }
    paramSessionInfo = paramChatMessage.getExtInfoFromExtStr("is_share_ark_message_action_checked");
    if ((!TextUtils.isEmpty(paramSessionInfo)) && ("1".equals(paramSessionInfo))) {}
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloUtil", 2, new Object[] { "[playShareMsgAction] share ark action isChecked:", Boolean.valueOf(bool), ", uniseq=", Long.valueOf(paramChatMessage.uniseq) });
      }
      if (bool) {
        break;
      }
      paramChatMessage.saveExtInfoToExtStr("is_share_ark_message_action_checked", "1");
      ThreadManager.excute(new ApolloUtil.4(paramChatMessage, paramInt1, paramInt2, paramQQAppInterface), 96, null, false);
      return;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, ChatMessage paramChatMessage, AnimationTextView paramAnimationTextView, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if ((paramQQAppInterface == null) || (paramSessionInfo == null) || (paramChatMessage == null) || (paramAnimationTextView == null)) {
      QLog.e("ApolloUtil", 1, "[playApolloEmoticonAction] param null, abort");
    }
    while ((paramSessionInfo.jdField_a_of_type_Int != 0) && (paramSessionInfo.jdField_a_of_type_Int != 1) && (paramSessionInfo.jdField_a_of_type_Int != 3000)) {
      return;
    }
    Object localObject3 = null;
    Object localObject1;
    if (paramBoolean)
    {
      localObject1 = localObject3;
      if (TextUtils.isEmpty(paramChatMessage.extStr)) {}
    }
    for (;;)
    {
      try
      {
        localObject1 = new JSONObject(paramChatMessage.extStr).optString("is_apollo_emoticon_action_checked");
        if ((TextUtils.isEmpty((CharSequence)localObject1)) || (!"1".equals(localObject1))) {
          break label436;
        }
        bool = true;
        if (QLog.isColorLevel()) {
          QLog.d("ApolloUtil", 2, new Object[] { "[playApolloEmoticonAction] apollo emoticon action played=", Boolean.valueOf(bool), ", uniseq=", Long.valueOf(paramChatMessage.uniseq), ", position=", Integer.valueOf(paramInt1), ", itemCount=", Integer.valueOf(paramInt2), ", isLongMsg=", Boolean.valueOf(paramBoolean) });
        }
        if (bool) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("ApolloUtil", 2, "[playApolloEmoticonAction] set apollo emoticon action play status true");
        }
        paramChatMessage.saveExtInfoToExtStr("is_apollo_emoticon_action_checked", "1");
        ThreadManager.post(new ApolloUtil.2(paramChatMessage), 5, null, false);
        if (paramInt1 != paramInt2 - 1) {
          break;
        }
        if (amsx.c("whiteFace3D") != 1) {
          break label442;
        }
        paramBoolean = true;
        if ((amsx)paramQQAppInterface.getManager(153) == null) {
          break;
        }
        paramInt1 = a(paramQQAppInterface, paramChatMessage);
        if (paramInt1 == 0) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("ApolloUtil", 2, new Object[] { "[playApolloEmoticonAction] apollo status open, grab action playModel:", Integer.valueOf(paramInt1), ",is3DWhiteFaceOpen:", Boolean.valueOf(paramBoolean) });
        }
        localObject1 = (annx)paramQQAppInterface.getManager(155);
        paramAnimationTextView = paramAnimationTextView.getText();
        if ((paramAnimationTextView == null) || (!(paramAnimationTextView instanceof begp))) {
          break;
        }
        paramChatMessage.saveExtInfoToExtStr("is_apollo_emoticon_action_played", "2");
        ThreadManager.post(new ApolloUtil.3(paramInt1, paramBoolean, paramAnimationTextView, (annx)localObject1, paramQQAppInterface, paramSessionInfo, paramChatMessage), 5, null, false);
        return;
      }
      catch (Exception localException)
      {
        QLog.e("ApolloUtil", 1, "[playApolloEmoticonAction] json error, ", localException);
        localObject2 = localObject3;
        continue;
      }
      Object localObject2 = paramChatMessage.getExtInfoFromExtStr("is_apollo_emoticon_action_checked");
      continue;
      label436:
      boolean bool = false;
      continue;
      label442:
      paramBoolean = false;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, ArrayList<Integer> paramArrayList)
  {
    if ((paramQQAppInterface == null) || (paramArrayList == null) || (paramArrayList.size() == 0)) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    int j = paramArrayList.size();
    int i = 0;
    while (i < j)
    {
      localStringBuilder.append(paramArrayList.get(i));
      if (i != j - 1) {
        localStringBuilder.append(",");
      }
      i += 1;
    }
    BaseApplicationImpl.getContext().getSharedPreferences("apollo_sp", 0).edit().putString("sp_key_apollo_game_life" + paramQQAppInterface.c(), localStringBuilder.toString()).commit();
  }
  
  public static void a(MessageForApollo paramMessageForApollo, QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    if ((paramMessageForApollo != null) && (paramQQAppInterface != null)) {
      ThreadManager.getFileThreadHandler().post(new ApolloUtil.1(paramMessageForApollo, paramQQAppInterface, paramString, paramInt));
    }
  }
  
  public static void a(String paramString)
  {
    if (QLog.isColorLevel())
    {
      long l = System.currentTimeMillis();
      QLog.d("ApolloUtil", 2, "[endTrace] " + paramString + " cost:" + (l - jdField_a_of_type_Long));
      jdField_a_of_type_Long = l;
    }
  }
  
  public static void a(boolean paramBoolean)
  {
    try
    {
      File localFile = new File(annv.jdField_a_of_type_JavaLangString);
      if (!localFile.exists()) {
        return;
      }
      if (!localFile.isDirectory())
      {
        QLog.e("ApolloUtil", 1, "deleteApolloResource .apollo is not directory");
        bhmi.a(annv.jdField_a_of_type_JavaLangString, false);
        return;
      }
    }
    catch (Exception localException)
    {
      QLog.e("ApolloUtil", 1, localException, new Object[0]);
      return;
    }
    if (paramBoolean)
    {
      bhmi.a(annv.jdField_a_of_type_JavaLangString, false);
      return;
    }
    bhmi.a(annv.g, false);
    bhmi.a(annv.f, false);
    bhmi.a(annv.jdField_d_of_type_JavaLangString, false);
    bhmi.a(annv.av, false);
    amsx.e = null;
  }
  
  public static boolean a()
  {
    if (QLog.isColorLevel()) {
      QLog.e("ApolloUtil", 1, "isApolloProxyEnable isPublicVersion");
    }
    return false;
  }
  
  public static boolean a(int paramInt)
  {
    String str = a(paramInt);
    return (!TextUtils.isEmpty(str)) && (bhmi.a(str));
  }
  
  public static boolean a(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloUtil", 2, "[isActionResDone], actionId:" + paramInt1 + ",personNum:" + paramInt2);
    }
    File localFile = new File(annv.jdField_d_of_type_JavaLangString + paramInt1);
    if (paramInt1 < 21) {
      localFile = new File(annv.c, "/def/basic/action/" + paramInt1);
    }
    if (!localFile.exists()) {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloUtil", 2, "dir NOT exist." + localFile.getPath());
      }
    }
    label359:
    do
    {
      for (;;)
      {
        return false;
        if (paramInt1 >= annv.jdField_a_of_type_Int)
        {
          if (c(localFile.getAbsolutePath() + "/action/" + annv.R))
          {
            if (paramInt2 == 0) {
              return true;
            }
            if (paramInt2 == 1) {
              return c(localFile.getAbsolutePath() + "/action_peer/" + annv.R);
            }
          }
        }
        else
        {
          if ((c(localFile.getAbsolutePath() + "/" + annv.x)) && (c(localFile.getAbsolutePath() + "/" + annv.y)) && (c(localFile.getAbsolutePath() + "/" + annv.w))) {}
          for (paramInt1 = 1; paramInt1 != 0; paramInt1 = 0)
          {
            if (paramInt2 != 0) {
              break label359;
            }
            return true;
          }
        }
      }
    } while (paramInt2 != 1);
    if ((c(localFile.getAbsolutePath() + "/" + annv.A)) && (c(localFile.getAbsolutePath() + "/" + annv.B)) && (c(localFile.getAbsolutePath() + "/" + annv.z))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public static boolean a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloUtil", 2, new Object[] { "[isWhiteFaceActionRscDone], actionId:", Integer.valueOf(paramInt1), ",subType:", Integer.valueOf(paramInt2), ",personNum:", Integer.valueOf(paramInt3), ",isGroup:", Boolean.valueOf(paramBoolean) });
    }
    Object localObject1 = new File(annv.jdField_d_of_type_JavaLangString + paramInt1 + "/action");
    if (!((File)localObject1).exists()) {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloUtil", 2, "dir NOT exist." + ((File)localObject1).getPath());
      }
    }
    label463:
    do
    {
      for (;;)
      {
        return false;
        localObject1 = ((File)localObject1).getAbsolutePath();
        Object localObject2 = localObject1;
        if (paramBoolean) {
          localObject2 = (String)localObject1 + "/group";
        }
        if (paramInt2 == 1) {
          localObject1 = (String)localObject2 + "/main/";
        }
        for (;;)
        {
          if (paramInt1 >= annv.jdField_a_of_type_Int)
          {
            if (!c((String)localObject1 + "action/" + annv.R)) {
              break;
            }
            if (paramInt3 == 0)
            {
              return true;
              if (paramInt2 == 0)
              {
                localObject1 = (String)localObject2 + "/pre/";
              }
              else
              {
                localObject1 = localObject2;
                if (paramInt2 == 2) {
                  localObject1 = (String)localObject2 + "/post/";
                }
              }
            }
            else
            {
              if (paramInt3 != 1) {
                break;
              }
              return c((String)localObject1 + "action_peer/" + annv.R);
            }
          }
        }
        if ((c((String)localObject1 + annv.x)) && (c((String)localObject1 + annv.y)) && (c((String)localObject1 + annv.w))) {}
        for (paramInt1 = 1; paramInt1 != 0; paramInt1 = 0)
        {
          if (paramInt3 != 0) {
            break label463;
          }
          return true;
        }
      }
    } while (paramInt3 != 1);
    if ((c((String)localObject1 + annv.A)) && (c((String)localObject1 + annv.B)) && (c((String)localObject1 + annv.z))) {}
    for (paramBoolean = true;; paramBoolean = false) {
      return paramBoolean;
    }
  }
  
  public static boolean a(int paramInt1, boolean paramBoolean1, int paramInt2, boolean paramBoolean2)
  {
    boolean bool = true;
    Object localObject = new StringBuilder(annv.jdField_d_of_type_JavaLangString + paramInt1);
    ((StringBuilder)localObject).append(File.separator);
    if (paramBoolean1) {
      ((StringBuilder)localObject).append("action_peer");
    }
    for (;;)
    {
      ((StringBuilder)localObject).append(File.separator).append("action");
      ((StringBuilder)localObject).append(File.separator).append(paramInt2);
      if (paramBoolean2) {
        ((StringBuilder)localObject).append(File.separator).append("android");
      }
      localObject = new File(((StringBuilder)localObject).toString());
      if (((File)localObject).exists()) {
        break;
      }
      QLog.e("ApolloUtil", 1, "dir NOT exist." + ((File)localObject).getPath());
      return false;
      ((StringBuilder)localObject).append("action");
    }
    if ((c(((File)localObject).getAbsolutePath() + File.separator + "action.json")) && (c(((File)localObject).getAbsolutePath() + File.separator + "action.atlas")) && (c(((File)localObject).getAbsolutePath() + File.separator + "action.png"))) {}
    for (paramBoolean1 = bool;; paramBoolean1 = false) {
      return paramBoolean1;
    }
  }
  
  public static boolean a(Context paramContext)
  {
    if (paramContext == null) {
      return false;
    }
    return bhny.a(paramContext, c());
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    return (a(paramContext)) || ((amsx.a(paramQQAppInterface)) && (amtk.jdField_a_of_type_Boolean) && (!TextUtils.isEmpty(amtk.jdField_b_of_type_JavaLangString)));
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, View paramView)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    if ((paramView != null) && (paramView.getVisibility() == 0))
    {
      bool2 = bool1;
      if (QLog.isColorLevel())
      {
        QLog.d("ApolloUtil", 2, "apollo_client view is visible preloadWebProcess apolloOpen:true");
        bool2 = bool1;
      }
      return bool2;
    }
    if (paramQQAppInterface == null) {
      return false;
    }
    if ((amsx.a(paramQQAppInterface, "drawer", null) > 0) && (amsx.a(BaseApplicationImpl.getContext(), Boolean.valueOf(false)))) {}
    for (bool1 = bool2;; bool1 = false)
    {
      bool2 = bool1;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("ApolloUtil", 2, "apollo_client preloadWebProcess apolloOpen:" + bool1);
      return bool1;
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, MessageRecord paramMessageRecord, List<Integer> paramList)
  {
    if (paramMessageRecord == null) {
      return false;
    }
    Object localObject;
    int j;
    if ((paramMessageRecord instanceof MessageForText))
    {
      localObject = paramMessageRecord.msg;
      j = a(paramQQAppInterface, paramMessageRecord);
      if (amsx.c("whiteFace3D") != 1) {
        break label250;
      }
      i = 1;
      label39:
      if ((j != 2) || (i != 0)) {
        break label293;
      }
    }
    label293:
    for (int i = 0;; i = 1)
    {
      if (j == 0) {
        QLog.w("ApolloUtil", 1, "getActionListFormMessage err user status");
      }
      paramMessageRecord = (annx)paramQQAppInterface.getManager(155);
      localObject = new begp((CharSequence)localObject, 2);
      begw[] arrayOfbegw = (begw[])((begp)localObject).getSpans(0, ((begp)localObject).length(), begw.class);
      if ((arrayOfbegw != null) && (arrayOfbegw.length > 0) && (i != 0))
      {
        int k = arrayOfbegw.length;
        i = 0;
        for (;;)
        {
          if (i < k)
          {
            int m = arrayOfbegw[i].a();
            if (behh.a(m))
            {
              m = asle.a(m);
              if (m >= 0)
              {
                m = b(paramMessageRecord, m, j);
                if (m > 0) {
                  paramList.add(Integer.valueOf(m));
                }
              }
            }
            i += 1;
            continue;
            if (!(paramMessageRecord instanceof MessageForLongMsg)) {
              break;
            }
            localObject = (MessageForLongMsg)paramMessageRecord;
            if (TextUtils.isEmpty(((MessageForLongMsg)localObject).sb2)) {}
            for (localObject = ((MessageForLongMsg)localObject).sb;; localObject = ((MessageForLongMsg)localObject).sb2) {
              break;
            }
            label250:
            i = 0;
            break label39;
          }
        }
      }
      if ((paramList.size() == 0) && (1 == amsx.a(paramQQAppInterface))) {
        b(paramQQAppInterface, paramSessionInfo, (begp)localObject, paramList);
      }
      for (boolean bool = true;; bool = false) {
        return bool;
      }
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, MessageForApollo paramMessageForApollo)
  {
    Object localObject2 = null;
    if ((paramMessageForApollo == null) || (paramQQAppInterface == null)) {
      return false;
    }
    Object localObject1 = (annx)paramQQAppInterface.getManager(155);
    if (ApolloGameUtil.a(paramMessageForApollo.msgType)) {}
    for (localObject1 = ((annx)localObject1).a(paramMessageForApollo.gameId);; localObject1 = null)
    {
      if ((amsx.c("gameSwitch") != 1) || ((localObject1 != null) && (!annu.a("8.4.5", ((ApolloGameData)localObject1).minVer, ((ApolloGameData)localObject1).maxVer))))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ApolloUtil", 2, "play apollo game msg but switch is 0 or version is incorrect");
        }
        return false;
      }
      if (paramQQAppInterface.getApp() == null) {}
      for (paramQQAppInterface = localObject2; (amsx.a(paramQQAppInterface)) && (paramMessageForApollo.istroop == 3000) && (amsx.c("discuss") == 0); paramQQAppInterface = paramQQAppInterface.getApp().getApplicationContext()) {
        return false;
      }
      return true;
    }
  }
  
  public static boolean a(ApolloActionData paramApolloActionData)
  {
    if (paramApolloActionData == null) {}
    boolean bool;
    do
    {
      return false;
      bool = true;
      if (!auog.a(a(paramApolloActionData, 0))) {
        bool = false;
      }
    } while (!a(paramApolloActionData.actionId, paramApolloActionData.personNum));
    return bool;
  }
  
  public static boolean a(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null) {}
    while (1036 != paramMessageRecord.istroop) {
      return false;
    }
    return true;
  }
  
  public static boolean a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloUtil", 2, "[isSpecialActionResDone], actionPath:" + paramString);
    }
    paramString = new File(paramString);
    if (!paramString.exists()) {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloUtil", 2, "dir NOT exist." + paramString.getPath());
      }
    }
    for (;;)
    {
      return false;
      if ((c(paramString.getAbsolutePath() + "/" + annv.x)) && (c(paramString.getAbsolutePath() + "/" + annv.y)) && (c(paramString.getAbsolutePath() + "/" + annv.w))) {}
      for (int i = 1; i != 0; i = 0) {
        return true;
      }
    }
  }
  
  public static boolean a(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    int i;
    if ((paramArrayOfInt1 != null) && (paramArrayOfInt2 != null) && (paramArrayOfInt1.length == paramArrayOfInt2.length))
    {
      i = 0;
      if (i >= paramArrayOfInt1.length) {
        break label62;
      }
      j = 0;
      label25:
      if (j >= paramArrayOfInt2.length) {
        break label64;
      }
      if (paramArrayOfInt1[i] != paramArrayOfInt2[j]) {
        break label48;
      }
    }
    label48:
    label62:
    label64:
    for (int j = 1;; j = 0)
    {
      if (j == 0)
      {
        return false;
        j += 1;
        break label25;
      }
      i += 1;
      break;
      return true;
    }
  }
  
  public static final byte[] a()
  {
    try
    {
      byte[] arrayOfByte = anzj.a(2131699455).getBytes();
      return arrayOfByte;
    }
    catch (UnsupportedCharsetException localUnsupportedCharsetException)
    {
      QLog.e("ApolloUtil", 1, localUnsupportedCharsetException.getMessage());
      return null;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QLog.e("ApolloUtil", 1, localThrowable.getMessage());
      }
    }
  }
  
  public static int b(float paramFloat, String paramString, int paramInt)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramFloat <= 0.0F)) {}
    do
    {
      return 24;
      int i = b(paramFloat, paramString, 17, 3);
      if (i == 0)
      {
        if (paramInt == 2) {
          return 71;
        }
        return 22;
      }
      if (i == 1)
      {
        if (paramInt == 2) {
          return 72;
        }
        return 23;
      }
    } while (paramInt != 2);
    return 73;
  }
  
  private static int b(float paramFloat, String paramString, int paramInt1, int paramInt2)
  {
    Object localObject = new TextView(BaseApplicationImpl.getContext());
    ((TextView)localObject).setTextSize(paramInt1 * 3 / bhlo.jdField_a_of_type_Float);
    ((TextView)localObject).setText(paramString);
    localObject = ((TextView)localObject).getPaint();
    paramString = paramString.replaceAll("\r", "").split("\n");
    int n = paramString.length;
    int k = 0;
    int j = 0;
    if (k < n)
    {
      String str = paramString[k];
      float f1;
      if (((Paint)localObject).measureText(str) > paramFloat)
      {
        paramInt1 = 0;
        f1 = 0.0F;
      }
      for (int i = 0;; i = j)
      {
        j = i;
        if (paramInt1 != str.length())
        {
          float f2 = f1 + ((Paint)localObject).measureText(String.valueOf(str.charAt(paramInt1)));
          m = paramInt1;
          f1 = f2;
          j = i;
          if (f2 <= paramFloat) {
            break label174;
          }
          j = i + 1;
          if (j < paramInt2) {}
        }
        else
        {
          k += 1;
          break;
        }
        int m = paramInt1 - 1;
        f1 = 0.0F;
        label174:
        paramInt1 = m + 1;
      }
    }
    return j;
  }
  
  public static int b(int paramInt)
  {
    switch (paramInt)
    {
    case 0: 
    default: 
      return 0;
    case 1: 
      return 1;
    }
    return 2;
  }
  
  public static int b(anga paramanga, MessageForApollo paramMessageForApollo)
  {
    if ((paramMessageForApollo == null) || (paramMessageForApollo.mApolloMessage == null)) {
      throw new IllegalArgumentException("getPlayActionType, apolloMsg null");
    }
    int i = paramMessageForApollo.actionType;
    if ((paramMessageForApollo.mApollo3DMessage != null) && (ApolloActionData.isAction3DModel(paramMessageForApollo.mApollo3DMessage.actionID_3D)))
    {
      if ((amsx.a(paramanga.a())) || (paramanga.g())) {
        return paramMessageForApollo.mApollo3DMessage.actionType_3D;
      }
      paramanga = ((annx)paramanga.a().getManager(155)).a(paramMessageForApollo.mApolloMessage.id);
      if (paramanga != null) {
        return paramanga.actionType;
      }
    }
    return i;
  }
  
  private static int b(annx paramannx, int paramInt1, int paramInt2)
  {
    if (((paramannx.f == null) || (paramannx.f.size() == 0)) && (paramInt2 == 1)) {
      return i(paramInt1);
    }
    return paramannx.a(paramInt1, paramInt2);
  }
  
  public static int b(String paramString)
  {
    int i = 0;
    try
    {
      if (!TextUtils.isEmpty(paramString)) {
        i = Integer.parseInt(paramString);
      }
      return i;
    }
    catch (Exception paramString)
    {
      QLog.e("ApolloUtil", 1, paramString, new Object[0]);
    }
    return 0;
  }
  
  public static long b(String paramString)
  {
    int i = 0;
    if (TextUtils.isEmpty(paramString)) {
      return 0L;
    }
    String str = paramString;
    if (paramString.contains("def/role/0/")) {
      str = g(paramString);
    }
    paramString = new StringBuilder(8);
    int j = 0;
    if (i < str.length())
    {
      char c1 = str.charAt(i);
      int k;
      if ((c1 > '/') && (c1 < ':'))
      {
        paramString.append(c1);
        k = 1;
      }
      do
      {
        i += 1;
        j = k;
        break;
        k = j;
      } while (j == 0);
    }
    if (j != 0) {
      return Long.parseLong(paramString.toString());
    }
    return 0L;
  }
  
  public static String b()
  {
    long l = NetConnInfoCenter.getServerTimeMillis();
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(l);
    localCalendar.set(11, 0);
    localCalendar.set(12, 0);
    localCalendar.set(13, 0);
    localCalendar.set(14, 0);
    return String.valueOf(localCalendar.getTimeInMillis());
  }
  
  public static String b(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder(100);
    localStringBuilder.append(annv.s).append(paramInt);
    return localStringBuilder.toString();
  }
  
  public static String b(Paint paramPaint, float paramFloat, String paramString, int paramInt)
  {
    int m = 0;
    if ((TextUtils.isEmpty(paramString)) || (paramPaint == null) || (paramFloat <= 0.0F)) {
      return "";
    }
    Object localObject = paramString.replaceAll("\r", "").split("\n");
    StringBuilder localStringBuilder = new StringBuilder();
    int i1 = localObject.length;
    int k = 0;
    int i = 0;
    String str;
    if (k < i1)
    {
      str = localObject[k];
      if (paramPaint.measureText(str) <= paramFloat) {
        localStringBuilder.append(str);
      }
    }
    for (;;)
    {
      localStringBuilder.append("\n");
      k += 1;
      i += 1;
      break;
      float f = 0.0F;
      int n = 0;
      int j = i;
      i = n;
      if (i != str.length())
      {
        char c1 = str.charAt(i);
        f += paramPaint.measureText(String.valueOf(c1));
        if (f <= paramFloat) {
          localStringBuilder.append(c1);
        }
        for (;;)
        {
          i += 1;
          break;
          j += 1;
          localStringBuilder.append("\n");
          i -= 1;
          f = 0.0F;
        }
        if (!paramString.endsWith("\n")) {
          localStringBuilder.deleteCharAt(localStringBuilder.length() - 1);
        }
        if (i <= paramInt) {
          return localStringBuilder.toString();
        }
        paramString = new StringBuilder();
        localObject = localStringBuilder.toString().split("\n");
        i = m;
        while (i < paramInt)
        {
          paramString.append(localObject[i]);
          if (i != paramInt - 1) {
            paramString.append("\n");
          }
          i += 1;
        }
        localObject = localObject[(paramInt - 1)];
        i = paramString.length();
        f = paramPaint.measureText("…");
        if (paramPaint.measureText((String)localObject) < paramFloat) {
          paramString.append("…");
        }
        label405:
        for (;;)
        {
          return paramString.toString();
          paramInt = i;
          for (;;)
          {
            if (paramInt < 1) {
              break label405;
            }
            if (paramPaint.measureText(paramString.substring(paramInt - 1, i)) >= f)
            {
              localStringBuilder.replace(paramInt - 1, i, "…");
              break;
            }
            paramInt -= 1;
          }
        }
      }
      i = j;
    }
  }
  
  public static String b(QQAppInterface paramQQAppInterface, MessageForApollo paramMessageForApollo)
  {
    if (!TextUtils.isEmpty(paramMessageForApollo.gameName)) {
      return paramMessageForApollo.gameName;
    }
    paramQQAppInterface = ((annx)paramQQAppInterface.getManager(155)).a(paramMessageForApollo.gameId);
    if (paramQQAppInterface != null) {
      return paramQQAppInterface.name;
    }
    return "";
  }
  
  public static String b(ApolloActionPackage paramApolloActionPackage)
  {
    return null;
  }
  
  public static String b(MessageForApollo paramMessageForApollo)
  {
    if (paramMessageForApollo == null) {}
    while (TextUtils.isEmpty(paramMessageForApollo.extendJson)) {
      return null;
    }
    try
    {
      paramMessageForApollo = new JSONObject(paramMessageForApollo.extendJson).optString("robotOpenId");
      return paramMessageForApollo;
    }
    catch (Exception paramMessageForApollo)
    {
      QLog.e("ApolloUtil", 1, paramMessageForApollo, new Object[0]);
    }
    return null;
  }
  
  public static String b(String paramString)
  {
    try
    {
      if (!TextUtils.isEmpty(paramString))
      {
        paramString = Uri.encode(paramString);
        return paramString;
      }
    }
    catch (Exception paramString)
    {
      QLog.e("ApolloUtil", 1, paramString.getMessage());
    }
    return "";
  }
  
  public static void b()
  {
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("apollo_user_config", 0);
    String str = e();
    if (!TextUtils.isEmpty(str)) {
      localSharedPreferences.edit().putBoolean(str, true).apply();
    }
    jdField_d_of_type_Boolean = true;
  }
  
  public static void b(int paramInt)
  {
    if (!f(paramInt)) {
      return;
    }
    if (assp.a.containsKey("8.4.5"))
    {
      Object localObject = (List)assp.a.get("8.4.5");
      if ((localObject != null) && (((List)localObject).size() > 0))
      {
        jdField_c_of_type_Int += 1;
        if (jdField_c_of_type_Int >= ((List)localObject).size())
        {
          localObject = BaseApplicationImpl.getApplication().getSharedPreferences("apollo_user_config", 0);
          String str = d();
          if (!jdField_b_of_type_Boolean)
          {
            if (!TextUtils.isEmpty(str)) {
              jdField_b_of_type_Int = ((SharedPreferences)localObject).getInt(str, 0);
            }
            jdField_b_of_type_Boolean = true;
          }
          jdField_b_of_type_Int += 1;
          if (!TextUtils.isEmpty(str)) {
            ((SharedPreferences)localObject).edit().putInt(str, jdField_b_of_type_Int).apply();
          }
          jdField_c_of_type_Int = 0;
        }
      }
    }
    VipUtils.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), "cmshow", "Apollo", "expresstab_reddot_view", 0, 0, new String[] { String.valueOf(paramInt) });
  }
  
  public static void b(Activity paramActivity, String paramString1, String paramString2)
  {
    bmup.b(paramActivity, paramString1, paramString2);
  }
  
  public static void b(bihu parambihu) {}
  
  private static void b(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, begp parambegp, List<Integer> paramList)
  {
    if ((paramQQAppInterface == null) || (parambegp == null)) {}
    long l1;
    Object localObject;
    HashMap localHashMap;
    do
    {
      do
      {
        return;
      } while (!amsx.e());
      l1 = System.currentTimeMillis();
      parambegp = parambegp.c();
      localObject = (annx)paramQQAppInterface.getManager(155);
      localHashMap = ((annx)localObject).a();
    } while ((localHashMap == null) || (localHashMap.size() == 0));
    int i1 = ((annx)localObject).a();
    int i = 0;
    int k;
    for (int j = 0;; j = k)
    {
      int m;
      if (i < parambegp.length()) {
        m = i1;
      }
      int n;
      for (;;)
      {
        n = i;
        k = j;
        if (m > 0)
        {
          if (i + m <= parambegp.length())
          {
            localObject = parambegp.substring(i, i + m);
            if (localHashMap.containsKey(localObject))
            {
              paramList.add(localHashMap.get(localObject));
              a(((Integer)localHashMap.get(localObject)).intValue(), (String)localObject, paramQQAppInterface, paramSessionInfo);
              n = m - 1 + i;
              k = j + 1;
            }
          }
        }
        else
        {
          if (k != 30) {
            break label264;
          }
          long l2 = System.currentTimeMillis();
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("ApolloUtil", 2, new Object[] { "getKeywordsActionList costTime:", Long.valueOf(l2 - l1), ", actionList:", paramList, ", actionCount:", Integer.valueOf(paramList.size()) });
          return;
        }
        m -= 1;
      }
      label264:
      i = n + 1;
    }
  }
  
  public static void b(String paramString) {}
  
  public static boolean b()
  {
    String str = Build.MODEL;
    if (QLog.isColorLevel()) {
      QLog.d("ApolloUtil", 2, "checkNotFullScreen model:" + str);
    }
    if (TextUtils.isEmpty(str)) {}
    do
    {
      return false;
      if (!TextUtils.isEmpty(annu.jdField_a_of_type_JavaLangString)) {
        return annu.jdField_a_of_type_JavaLangString.contains(str);
      }
    } while (!str.contains("SM-G8870"));
    return true;
  }
  
  public static boolean b(int paramInt)
  {
    int i = 1;
    if (QLog.isColorLevel()) {
      QLog.d("ApolloUtil", 2, new Object[] { "[isWhiteFaceActionRscDone], actionId:", Integer.valueOf(paramInt) });
    }
    Object localObject = new File(annv.jdField_d_of_type_JavaLangString + paramInt + "/action");
    int j;
    if (!((File)localObject).exists())
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloUtil", 2, "dir NOT exist." + ((File)localObject).getPath());
      }
      j = 0;
    }
    int k;
    do
    {
      do
      {
        return j;
        localObject = ((File)localObject).getAbsolutePath();
        if (paramInt < annv.jdField_a_of_type_Int) {
          break;
        }
        k = c((String)localObject + "/main/action/" + annv.R);
        j = k;
      } while (k == 0);
      k &= c((String)localObject + "/pre/action/" + annv.R);
      j = k;
    } while (k == 0);
    return k & c((String)localObject + "/post/action/" + annv.R);
    int m;
    if ((c((String)localObject + "/pre/" + annv.x)) && (c((String)localObject + "/pre/" + annv.y)) && (c((String)localObject + "/pre/" + annv.w)))
    {
      j = 1;
      m = j;
      if (j == 0) {
        return m;
      }
      if ((!c((String)localObject + "/main/" + annv.x)) || (!c((String)localObject + "/main/" + annv.y)) || (!c((String)localObject + "/main/" + annv.w))) {
        break label565;
      }
      paramInt = 1;
      label445:
      j &= paramInt;
      m = j;
      if (j == 0) {
        return m;
      }
      if ((!c((String)localObject + "/post/" + annv.x)) || (!c((String)localObject + "/post/" + annv.y)) || (!c((String)localObject + "/post/" + annv.w))) {
        break label570;
      }
    }
    label565:
    label570:
    for (paramInt = i;; paramInt = 0)
    {
      return paramInt & j;
      j = 0;
      break;
      paramInt = 0;
      break label445;
    }
    return m;
  }
  
  public static boolean b(int paramInt1, int paramInt2)
  {
    switch (paramInt1)
    {
    default: 
      return false;
    case 1: 
      return d(paramInt2);
    }
    return c(paramInt2);
  }
  
  public static boolean b(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloUtil", 2, "[is3DActionPathRscDone], actionPath:" + paramString);
    }
    paramString = new File(paramString);
    if (!paramString.exists())
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloUtil", 2, "dir NOT exist." + paramString.getPath());
      }
      return false;
    }
    return c(paramString.getAbsolutePath() + "/action/" + annv.R);
  }
  
  public static int c(int paramInt)
  {
    switch (paramInt)
    {
    case 2: 
    case 3: 
    default: 
      return paramInt;
    case 1: 
      return 0;
    case 4: 
      return 1;
    }
    return 3000;
  }
  
  public static int c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return 0;
      if (paramString.contains("vipApollo_role_")) {
        return 11;
      }
      if (paramString.contains("vipApollo_item_")) {
        return 12;
      }
      if (paramString.contains("vipApollo_action_")) {
        return 13;
      }
      if (paramString.contains("apollo_audio_")) {
        return 14;
      }
      if (paramString.contains("vipList_apollo_data")) {
        return 15;
      }
      if (paramString.contains("clientScriptBaseConfig")) {
        return 16;
      }
      if (paramString.contains("terminalCmConfig")) {
        return 17;
      }
    } while (!paramString.contains("vipApollo_drawerAction_"));
    return 18;
  }
  
  public static String c()
  {
    String str2 = amtk.jdField_a_of_type_JavaLangString;
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = "com.tencent.kapu";
    }
    return str1;
  }
  
  public static String c(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder(50);
    localStringBuilder.append(annv.m).append(paramInt);
    return localStringBuilder.toString();
  }
  
  public static String c(QQAppInterface paramQQAppInterface, MessageForApollo paramMessageForApollo)
  {
    Object localObject3 = null;
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramQQAppInterface != null)
    {
      localObject1 = localObject2;
      if (paramMessageForApollo != null)
      {
        if (paramMessageForApollo.mApolloMessage != null) {
          break label28;
        }
        localObject1 = localObject2;
      }
    }
    label28:
    do
    {
      do
      {
        return localObject1;
        paramQQAppInterface = localObject3;
        if (paramMessageForApollo.mApolloMessage.name != null) {
          paramQQAppInterface = new String(paramMessageForApollo.mApolloMessage.name);
        }
        localObject1 = paramQQAppInterface;
      } while (paramMessageForApollo.mApollo3DMessage == null);
      localObject1 = paramQQAppInterface;
    } while (!ApolloActionData.isAction3DModel(paramMessageForApollo.mApollo3DMessage.actionID_3D));
    return paramMessageForApollo.mApollo3DMessage.actionName_3D;
  }
  
  /* Error */
  public static String c(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: invokestatic 85	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   5: invokevirtual 1913	com/tencent/common/app/BaseApplicationImpl:getAssets	()Landroid/content/res/AssetManager;
    //   8: aload_0
    //   9: invokevirtual 1919	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   12: astore_0
    //   13: aload_0
    //   14: ifnull +37 -> 51
    //   17: aload_0
    //   18: aload_0
    //   19: invokevirtual 1924	java/io/InputStream:available	()I
    //   22: i2l
    //   23: invokestatic 1930	com/tencent/qphone/base/util/MD5:toMD5Byte	(Ljava/io/InputStream;J)[B
    //   26: invokestatic 1936	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   29: astore_1
    //   30: aload_1
    //   31: astore_2
    //   32: aload_0
    //   33: ifnull +9 -> 42
    //   36: aload_0
    //   37: invokevirtual 1939	java/io/InputStream:close	()V
    //   40: aload_1
    //   41: astore_2
    //   42: aload_2
    //   43: areturn
    //   44: astore_0
    //   45: aload_0
    //   46: invokevirtual 1942	java/io/IOException:printStackTrace	()V
    //   49: aload_1
    //   50: areturn
    //   51: aload_0
    //   52: ifnull -10 -> 42
    //   55: aload_0
    //   56: invokevirtual 1939	java/io/InputStream:close	()V
    //   59: aconst_null
    //   60: areturn
    //   61: astore_0
    //   62: aload_0
    //   63: invokevirtual 1942	java/io/IOException:printStackTrace	()V
    //   66: aconst_null
    //   67: areturn
    //   68: astore_0
    //   69: aconst_null
    //   70: astore_0
    //   71: aload_0
    //   72: ifnull -30 -> 42
    //   75: aload_0
    //   76: invokevirtual 1939	java/io/InputStream:close	()V
    //   79: aconst_null
    //   80: areturn
    //   81: astore_0
    //   82: aload_0
    //   83: invokevirtual 1942	java/io/IOException:printStackTrace	()V
    //   86: aconst_null
    //   87: areturn
    //   88: astore_1
    //   89: aconst_null
    //   90: astore_0
    //   91: aload_0
    //   92: ifnull +7 -> 99
    //   95: aload_0
    //   96: invokevirtual 1939	java/io/InputStream:close	()V
    //   99: aload_1
    //   100: athrow
    //   101: astore_0
    //   102: aload_0
    //   103: invokevirtual 1942	java/io/IOException:printStackTrace	()V
    //   106: goto -7 -> 99
    //   109: astore_1
    //   110: goto -19 -> 91
    //   113: astore_1
    //   114: goto -43 -> 71
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	117	0	paramString	String
    //   29	21	1	str	String
    //   88	12	1	localObject1	Object
    //   109	1	1	localObject2	Object
    //   113	1	1	localIOException	java.io.IOException
    //   1	42	2	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   36	40	44	java/io/IOException
    //   55	59	61	java/io/IOException
    //   2	13	68	java/io/IOException
    //   75	79	81	java/io/IOException
    //   2	13	88	finally
    //   95	99	101	java/io/IOException
    //   17	30	109	finally
    //   17	30	113	java/io/IOException
  }
  
  public static void c()
  {
    jdField_b_of_type_Boolean = false;
    jdField_b_of_type_Int = 0;
    jdField_c_of_type_Int = 0;
    jdField_c_of_type_Boolean = false;
    jdField_d_of_type_Boolean = false;
    EmoticonImageView.a(false);
    jdField_a_of_type_Boolean = true;
  }
  
  public static void c(int paramInt)
  {
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("apollo_user_config", 0);
    String str = d();
    if (!TextUtils.isEmpty(str))
    {
      jdField_b_of_type_Int = 3;
      localSharedPreferences.edit().putInt(str, jdField_b_of_type_Int).apply();
    }
    jdField_c_of_type_Int = 0;
    VipUtils.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), "cmshow", "Apollo", "expresstab_reddot_click", 0, 0, new String[] { String.valueOf(paramInt) });
  }
  
  public static void c(String paramString)
  {
    ThreadManager.getUIHandler().post(new ApolloUtil.9(paramString));
  }
  
  public static boolean c()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (assp.a.containsKey("8.4.5"))
    {
      List localList = (List)assp.a.get("8.4.5");
      bool1 = bool2;
      if (localList != null)
      {
        bool1 = bool2;
        if (localList.size() > 0)
        {
          if (!jdField_c_of_type_Boolean)
          {
            jdField_d_of_type_Boolean = BaseApplicationImpl.getApplication().getSharedPreferences("apollo_user_config", 0).getBoolean(e(), false);
            jdField_c_of_type_Boolean = true;
          }
          if (jdField_d_of_type_Boolean) {
            break label87;
          }
        }
      }
    }
    label87:
    for (bool1 = true;; bool1 = false) {
      return bool1;
    }
  }
  
  public static boolean c(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloUtil", 2, "[checkDressRes], dressId:" + paramInt);
    }
    File localFile = new File(annv.f + paramInt);
    if (paramInt < 21) {
      localFile = new File(annv.c, "/def/basic/dress/" + paramInt);
    }
    if (!localFile.exists())
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloUtil", 2, "dir NOT exist." + localFile.getPath());
      }
      return false;
    }
    if (paramInt >= annv.jdField_a_of_type_Int) {
      return c(localFile.getAbsolutePath() + "/" + annv.Q);
    }
    if ((c(localFile.getAbsolutePath() + "/" + annv.D)) && (c(localFile.getAbsolutePath() + "/" + annv.E)) && (c(localFile.getAbsolutePath() + "/" + annv.C))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public static boolean c(int paramInt1, int paramInt2)
  {
    String str = "";
    int i;
    if (paramInt2 > annv.jdField_a_of_type_Int)
    {
      i = 1;
      switch (paramInt1)
      {
      }
    }
    for (;;)
    {
      if (i == 0) {
        break label54;
      }
      return b(str);
      i = 0;
      break;
      str = c(paramInt2);
    }
    label54:
    return a(str);
  }
  
  public static boolean c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    File localFile;
    do
    {
      return false;
      localFile = new File(paramString);
      if (localFile.exists()) {
        break;
      }
      e(paramString + anzj.a(2131699461));
    } while (!QLog.isColorLevel());
    QLog.d("ApolloUtil", 2, "ErrorInfo-> " + paramString + " NOT exist.");
    return false;
    if (localFile.length() == 0L)
    {
      e(paramString + anzj.a(2131699457));
      angi.a(0, new Object[] { "ErrorInfo-> ", paramString, ",lenght is 0." });
      if (QLog.isColorLevel()) {
        QLog.d("ApolloUtil", 2, "ErrorInfo-> " + paramString + ",lenght is 0.");
      }
      localFile.delete();
      return false;
    }
    return true;
  }
  
  public static int d(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= 2147483647))
    {
      QLog.e("ApolloUtil", 1, "[getRandomInteger] invalid " + paramInt);
      return 0;
    }
    return new Random().nextInt(paramInt);
  }
  
  private static String d()
  {
    if (assp.a.containsKey("8.4.5"))
    {
      Object localObject = (List)assp.a.get("8.4.5");
      if ((localObject != null) && (((List)localObject).size() > 0))
      {
        String str = ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getCurrentAccountUin();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("new_icon_show_times_").append(str);
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          int i = ((Integer)((Iterator)localObject).next()).intValue();
          localStringBuilder.append("_").append(i);
        }
        return localStringBuilder.toString();
      }
    }
    return null;
  }
  
  public static String d(int paramInt)
  {
    if (paramInt == -1) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder("https://cmshow.gtimg.cn/qqshow/admindata/comdata/vipApollo_drawerAction_");
    localStringBuilder.append(paramInt).append("/d.zip");
    return localStringBuilder.toString();
  }
  
  public static String d(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramString.length() < 4)) {
      return paramString;
    }
    return paramString.substring(0, 4) + "*";
  }
  
  public static void d(String paramString)
  {
    int i = c(paramString);
    if (i > 0)
    {
      long l = b(paramString);
      if (i == 17) {
        l = 1L;
      }
      anmq.a(30, paramString, 300, -100, 0L, i, l, new Object[0]);
    }
  }
  
  public static boolean d(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloUtil", 2, "[checkRoleRes], roleId:" + paramInt);
    }
    File localFile1;
    if (paramInt == 0)
    {
      localFile1 = new File(annv.c, "/def/basic/skeleton/" + paramInt);
      if (localFile1.exists()) {
        break label142;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ApolloUtil", 2, "dir NOT exist." + localFile1.getPath());
      }
    }
    label142:
    File localFile2;
    do
    {
      return false;
      localFile1 = new File(annv.g + paramInt);
      break;
      localFile2 = new File(localFile1, annv.O);
      if ((paramInt == 0) || (localFile2.exists())) {
        break label252;
      }
      e(localFile2.getPath() + anzj.a(2131699463));
      angi.a(0, new Object[] { "ROLE_FILE_CONFIG_NAME NOT exist.", localFile2.getPath() });
    } while (!QLog.isColorLevel());
    QLog.d("ApolloUtil", 2, "ROLE_FILE_CONFIG_NAME NOT exist." + localFile2.getPath());
    return false;
    label252:
    if (paramInt >= annv.jdField_a_of_type_Int) {
      return c(localFile1.getAbsolutePath() + "/" + annv.P);
    }
    if ((c(localFile1.getAbsolutePath() + "/" + annv.M)) && (c(localFile1.getAbsolutePath() + "/" + annv.N)) && (c(localFile1.getAbsolutePath() + "/" + annv.L))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public static boolean d(int paramInt1, int paramInt2)
  {
    boolean bool = false;
    if ((e(0, paramInt2)) || (e(paramInt1, paramInt2))) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean d(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return true;
      paramString = bjtz.d(paramString);
      paramString = new File(annv.j + paramString + File.separator + paramString + ".zip");
    } while (paramString.exists());
    e(paramString + anzj.a(2131699443));
    if (QLog.isColorLevel()) {
      QLog.d("ApolloUtil", 2, "ErrorInfo-> " + paramString + " NOT exist.");
    }
    return false;
  }
  
  public static int e(int paramInt)
  {
    int i;
    if (paramInt == 1) {
      i = 3;
    }
    do
    {
      return i;
      if (paramInt == 4) {
        return 1;
      }
      i = paramInt;
    } while (paramInt != 5);
    return 2;
  }
  
  private static String e()
  {
    if (assp.a.containsKey("8.4.5"))
    {
      Object localObject = (List)assp.a.get("8.4.5");
      if ((localObject != null) && (((List)localObject).size() > 0))
      {
        String str = ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getCurrentAccountUin();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("new_emoticon_popup_").append(str);
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          int i = ((Integer)((Iterator)localObject).next()).intValue();
          localStringBuilder.append("_").append(i);
        }
        return localStringBuilder.toString();
      }
    }
    return null;
  }
  
  public static String e(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return annv.jdField_a_of_type_JavaLangString;
    case 1: 
      return annv.c;
    }
    return BaseApplicationImpl.getApplication().getFilesDir() + "";
  }
  
  public static String e(String paramString)
  {
    String str;
    if (paramString == null) {
      str = "";
    }
    do
    {
      return str;
      str = paramString;
    } while (paramString.length() <= 2048);
    return paramString.substring(0, 2048);
  }
  
  public static void e(String paramString) {}
  
  public static boolean e(int paramInt)
  {
    boolean bool = true;
    if (!f(paramInt)) {
      return false;
    }
    if (!jdField_b_of_type_Boolean)
    {
      SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("apollo_user_config", 0);
      String str = d();
      if (!TextUtils.isEmpty(str)) {
        jdField_b_of_type_Int = localSharedPreferences.getInt(str, 0);
      }
      jdField_b_of_type_Boolean = true;
    }
    if (jdField_b_of_type_Int < 3) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public static boolean e(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloUtil", 2, "[isBubbleRscExist], roleId:" + paramInt1 + ",bubbleId:" + paramInt2);
    }
    if (paramInt1 == 0) {}
    for (File localFile1 = new File(annv.c, "/def/role/" + paramInt1);; localFile1 = new File(annv.g + paramInt1))
    {
      localFile1 = new File(localFile1, annv.F + "/" + paramInt2);
      if (localFile1.exists()) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ApolloUtil", 2, "dir NOT exist." + localFile1.getPath());
      }
      return false;
    }
    File localFile2 = new File(localFile1, annv.D);
    if (!localFile2.exists())
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloUtil", 2, "BUBBLE_FILE_ATLAS_NAME NOT exist. " + localFile2.getPath());
      }
      return false;
    }
    if (localFile2.length() == 0L)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloUtil", 2, "ErrorInfo-> " + localFile2.getPath() + ",lenght is 0.");
      }
      localFile2.delete();
      return false;
    }
    localFile2 = new File(localFile1, annv.E);
    if (!localFile2.exists())
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloUtil", 2, "BUBBLE_FILE_ATLAS_NAME NOT exist." + localFile2.getPath());
      }
      return false;
    }
    if (localFile2.length() == 0L)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloUtil", 2, "ErrorInfo-> " + localFile2.getPath() + ",lenght is 0.");
      }
      localFile2.delete();
      return false;
    }
    localFile1 = new File(localFile1, annv.C);
    if (!localFile1.exists())
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloUtil", 2, "BUBBLE_FILE_PNG_NAME NOT exist." + localFile1.getPath());
      }
      return false;
    }
    if (localFile1.length() == 0L)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloUtil", 2, "ErrorInfo-> " + localFile1.getPath() + ",lenght is 0.");
      }
      localFile1.delete();
      return false;
    }
    return true;
  }
  
  public static int f(int paramInt)
  {
    if (paramInt == 0) {
      return paramInt;
    }
    if (paramInt == -104) {
      return 2001;
    }
    if (paramInt == -103) {
      return 2002;
    }
    if (paramInt == -118) {
      return 2003;
    }
    if (paramInt == -111) {
      return 2004;
    }
    return 2000;
  }
  
  public static String f(int paramInt)
  {
    if (2 == paramInt) {
      return "friend";
    }
    return "me";
  }
  
  public static String f(String paramString)
  {
    Object localObject = paramString;
    if (!TextUtils.isEmpty(paramString))
    {
      String str = paramString;
      if (paramString.endsWith("_pet")) {
        str = paramString.substring(0, paramString.indexOf("_"));
      }
      localObject = str;
      if (str.endsWith("#")) {
        localObject = str.substring(0, str.indexOf("#"));
      }
    }
    return localObject;
  }
  
  public static void f(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (!new File(paramString).exists()))
    {
      QQToast.a(BaseActivity.sTopActivity, anzj.a(2131699453), 1).a();
      return;
    }
    QLog.d("ApolloUtil", 1, new Object[] { "replaceCmshow3dResource, filePath=", paramString });
    Object localObject2;
    Object localObject1;
    int j;
    int i;
    long l1;
    label159:
    Object localObject3;
    try
    {
      localObject2 = annv.jdField_a_of_type_JavaLangString + "/tempReplace/";
      localObject1 = new File((String)localObject2);
      if (((File)localObject1).exists()) {
        auog.a((File)localObject1);
      }
      nof.a(new File(paramString), (String)localObject2);
      j = 0;
      i = 0;
      l1 = -1L;
      paramString = ((File)localObject1).listFiles();
      l2 = l1;
      k = j;
      if (paramString == null) {
        break label575;
      }
      l2 = l1;
      k = j;
      if (paramString.length <= 0) {
        break label575;
      }
      j = 0;
      l2 = l1;
      k = i;
      if (j >= paramString.length) {
        break label575;
      }
      localObject2 = paramString[j];
      if ((((File)localObject2).isFile()) && (((File)localObject2).getName().equals("skeleton.bin")))
      {
        k = 1;
        bhmi.a((File)localObject2, new File(annv.g + 3100045L + "/skeleton.bin"));
        l2 = l1;
      }
      else if ((((File)localObject2).isDirectory()) && (((File)localObject2).getName().equals("action")))
      {
        localObject2 = new File((File)localObject2, "action.bin");
        localObject3 = new File("/data/data/com.tencent.mobileqq/files/apollo/def/role/0/3D/sayhi/1/action.bin");
        if (((File)localObject3).exists()) {
          ((File)localObject3).delete();
        }
        bhmi.a((File)localObject2, (File)localObject3);
        l2 = l1;
        k = i;
      }
    }
    catch (Exception paramString)
    {
      QLog.e("ApolloUtil", 1, "replaceCmshow3dResource, error=", paramString);
      QQToast.a(BaseActivity.sTopActivity, anzj.a(2131699456), 0).a();
      return;
    }
    long l2 = l1;
    int k = i;
    int m;
    if (((File)localObject2).isDirectory())
    {
      localObject2 = new File((File)localObject2, "android");
      l2 = l1;
      k = i;
      if (((File)localObject2).exists())
      {
        localObject2 = ((File)localObject2).listFiles();
        l2 = l1;
        k = i;
        if (localObject2 != null)
        {
          l2 = l1;
          k = i;
          if (localObject2.length > 0)
          {
            m = 0;
            label431:
            l2 = l1;
            k = i;
            if (m < localObject2.length)
            {
              localObject3 = localObject2[m];
              l2 = l1;
              if (!((File)localObject3).isFile()) {
                break label1095;
              }
              l2 = l1;
              if (!((File)localObject3).getName().endsWith(".zip")) {
                break label1095;
              }
              if (!((File)localObject3).getName().equals("face.zip")) {
                break label1108;
              }
              nof.a((File)localObject3, annv.g + 3100045L + "/");
              l2 = l1;
              break label1095;
            }
          }
        }
      }
    }
    for (;;)
    {
      nof.a((File)localObject3, annv.f + l1 + "/");
      l2 = l1;
      break label1095;
      label575:
      auog.a((File)localObject1);
      if (k == 0)
      {
        QQToast.a(BaseActivity.sTopActivity, anzj.a(2131699454), 0).a();
        return;
      }
      Object localObject4;
      long l4;
      if (l2 != -1L)
      {
        QLog.d("ApolloUtil", 1, new Object[] { "replaceCmshow3dResource, dressEndId=", Long.valueOf(l2) });
        paramString = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
        localObject1 = (amsx)paramString.getManager(153);
        localObject4 = paramString.getCurrentAccountUin();
        localObject2 = ((amsx)localObject1).b((String)localObject4);
        if (localObject2 == null) {
          break;
        }
        l1 = 0L;
        if (((ApolloBaseInfo)localObject2).mApollo3DDataBuffer == null) {
          break label1076;
        }
        localObject3 = new JSONObject(((ApolloBaseInfo)localObject2).mApollo3DDataBuffer);
        l3 = ((JSONObject)localObject3).optLong("ts");
        localObject3 = ((JSONObject)localObject3).optJSONObject("role");
        l1 = l3;
        if (localObject3 == null) {
          break label1076;
        }
        l4 = ((JSONObject)localObject3).optLong("id");
        l1 = l3;
      }
      label1076:
      for (long l3 = l4;; l3 = 0L)
      {
        if (l3 != 0L)
        {
          bhmi.a(new File(annv.g + l3 + "/config.json"), new File(annv.g + 3100045L + "/config.json"));
          localObject3 = new JSONObject();
          l3 = System.currentTimeMillis() / 1000L;
          ((JSONObject)localObject3).put("uin", Long.parseLong((String)localObject4));
          ((JSONObject)localObject3).put("ts", l1);
          ((JSONObject)localObject3).put("sex", 0);
          localObject4 = new JSONObject();
          ((JSONObject)localObject4).put("id", 3100045L);
          ((JSONObject)localObject4).put("ts", l1);
          ((JSONObject)localObject3).put("role", localObject4);
          localObject4 = new JSONArray();
          for (l3 = 3100145L; l3 <= l2; l3 += 1L)
          {
            JSONObject localJSONObject = new JSONObject();
            localJSONObject.put("id", l3);
            localJSONObject.put("ts", l1);
            ((JSONArray)localObject4).put(localJSONObject);
          }
          QQToast.a(BaseActivity.sTopActivity, anzj.a(2131699450), 0).a();
          return;
        }
        QQToast.a(BaseActivity.sTopActivity, anzj.a(2131699460), 0).a();
        return;
        ((JSONObject)localObject3).put("dresslist", localObject4);
        ((ApolloBaseInfo)localObject2).setApolloDress3D(paramString, (JSONObject)localObject3);
        ((amsx)localObject1).a((ApolloBaseInfo)localObject2);
        QQToast.a(BaseActivity.sTopActivity, anzj.a(2131699468), 0).a();
        return;
      }
      j += 1;
      l1 = l2;
      i = k;
      break label159;
      label1095:
      m += 1;
      l1 = l2;
      break label431;
      label1108:
      if (l1 == -1L) {
        l1 = 3100145L;
      } else {
        l1 += 1L;
      }
    }
  }
  
  public static boolean f(int paramInt)
  {
    if (assp.a.containsKey("8.4.5"))
    {
      Object localObject = (List)assp.a.get("8.4.5");
      if ((localObject != null) && (((List)localObject).size() > 0))
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          if (paramInt == ((Integer)((Iterator)localObject).next()).intValue()) {
            return true;
          }
        }
      }
    }
    return false;
  }
  
  public static int g(int paramInt)
  {
    int j = 1;
    if ((paramInt >= 500) && (paramInt < 600)) {
      return 1;
    }
    if ((paramInt >= 600) && (paramInt < 700)) {
      return 2;
    }
    int i;
    if (paramInt >= 700)
    {
      i = 1;
      if (paramInt >= 800) {
        break label65;
      }
    }
    label65:
    for (paramInt = j;; paramInt = 0)
    {
      if ((paramInt & i) == 0) {
        break label70;
      }
      return 3;
      i = 0;
      break;
    }
    label70:
    return 0;
  }
  
  public static String g(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(annv.jdField_d_of_type_JavaLangString).append(paramInt).append(File.separator).append("action/").append("music.amr");
    String str = localStringBuilder.toString();
    Object localObject = str;
    if (!bhmi.a(str))
    {
      int i = str.length();
      localStringBuilder.delete(str.length() - "music.amr".length(), i);
      localStringBuilder.append("music/");
      localObject = localStringBuilder.toString();
      if (!bhmi.a((String)localObject)) {
        break label281;
      }
      localObject = new File((String)localObject).list(new anpt());
      if (localObject == null) {
        break label266;
      }
      switch (localObject.length)
      {
      default: 
        Arrays.sort((Object[])localObject);
        i = d(localObject.length);
        if ((i >= 0) && (i < localObject.length))
        {
          localStringBuilder.append(localObject[i]);
          localObject = localStringBuilder.toString();
        }
        break;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloUtil", 2, "[getAudioPathForAction] " + paramInt + " " + (String)localObject);
      }
      return localObject;
      localObject = "";
      QLog.e("ApolloUtil", 1, "[getAudioPathForAction] file dir empty");
      continue;
      localStringBuilder.append(localObject[0]);
      localObject = localStringBuilder.toString();
      continue;
      localObject = "";
      continue;
      label266:
      localObject = "";
      QLog.e("ApolloUtil", 1, "[getAudioPathForAction] file not found even one");
      continue;
      label281:
      localObject = "";
      QLog.e("ApolloUtil", 1, "[getAudioPathForAction] file dir not found ");
    }
  }
  
  private static String g(String paramString)
  {
    Matcher localMatcher = Pattern.compile("/\\d+/").matcher(paramString);
    for (paramString = ""; localMatcher.find(); paramString = localMatcher.group()) {}
    return paramString;
  }
  
  public static boolean g(int paramInt)
  {
    boolean bool2 = false;
    int[] arrayOfInt = jdField_a_of_type_ArrayOfInt;
    int j = arrayOfInt.length;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < j)
      {
        if (arrayOfInt[i] == paramInt) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  public static int h(int paramInt)
  {
    if (paramInt == 2) {
      return 1;
    }
    return 0;
  }
  
  public static void handleApolloNoCatchCrash(boolean paramBoolean, String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString2)) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    anmq.a(20);
    int i;
    if (paramBoolean)
    {
      if (!TextUtils.isEmpty(ApolloRender.sNativeVersion)) {
        localStringBuilder.append("SO_VERSION:").append(ApolloRender.sNativeVersion).append(",");
      }
      i = 40;
      if (System.currentTimeMillis() - ApolloTextureView.sReAttachTime < 30000L) {
        i = 41;
      }
    }
    for (;;)
    {
      localStringBuilder.append("crashType=").append(paramString1).append(", crashStack=").append(paramString2);
      anmq.a(20, 1, i, new Object[] { localStringBuilder.toString() });
      return;
      i = 30;
      if (paramString1.contains("NullPointerException")) {
        i = 31;
      }
    }
  }
  
  private static int i(int paramInt)
  {
    if (paramInt < 229) {
      return paramInt + 10000;
    }
    return paramInt + 20000;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.utils.ApolloUtil
 * JD-Core Version:    0.7.0.1
 */