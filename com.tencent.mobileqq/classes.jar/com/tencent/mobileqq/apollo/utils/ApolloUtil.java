package com.tencent.mobileqq.apollo.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Color;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.ToolAppRuntime;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.apollo.ApolloManager;
import com.tencent.mobileqq.apollo.data.ApolloSkeletonBounding;
import com.tencent.mobileqq.apollo.drawer.PushDrawerStatus;
import com.tencent.mobileqq.apollo.store.ApolloStoreActivity;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.utils.ApolloContentUpdateHandler;
import com.tencent.mobileqq.data.ApolloActionData;
import com.tencent.mobileqq.data.ApolloActionPackage;
import com.tencent.mobileqq.data.ApolloBaseInfo;
import com.tencent.mobileqq.data.ApolloGameData;
import com.tencent.mobileqq.data.ApolloMessage;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForApollo;
import com.tencent.mobileqq.data.MessageForLongMsg;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.graytip.UniteGrayTipParam;
import com.tencent.mobileqq.graytip.UniteGrayTipUtil;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.pic.compress.Utils;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageUtils;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.text.QQText.EmoticonSpan;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.TimeFormatterUtils;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.widget.AnimationTextView;
import com.tencent.mqq.shared_file_accessor.SharedPreferencesProxyManager;
import com.tencent.pb.apollousertrace.ApolloUserTrace.STClickInfo;
import com.tencent.pb.apollousertrace.ApolloUserTrace.STUserClickTrack;
import com.tencent.pb.apollousertrace.ApolloUserTrace.STUserTrackReq;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.URLUtil;
import java.io.File;
import java.nio.charset.UnsupportedCharsetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONObject;
import yto;
import ytp;
import ytq;
import ytr;
import yts;
import ytt;

public class ApolloUtil
{
  public static long a;
  public static final String a;
  public static Comparator a;
  private static boolean a;
  public static final String b;
  private static boolean b;
  public static final String c;
  
  static
  {
    jdField_a_of_type_JavaLangString = ApolloConstant.jdField_c_of_type_JavaLangString + "action_v730.json";
    jdField_b_of_type_JavaLangString = ApolloConstant.n + "game_v2.json";
    jdField_c_of_type_JavaLangString = ApolloConstant.n + "pic";
    jdField_a_of_type_JavaUtilComparator = new ytt();
  }
  
  public static float a(float paramFloat)
  {
    long l = DeviceInfoUtil.k();
    if (Float.compare(0.0F, paramFloat) == 0) {
      return (float)(l / 5L) / 368.0F;
    }
    return (float)l * paramFloat / 368.0F;
  }
  
  public static final int a(float paramFloat1, float paramFloat2)
  {
    return (int)(paramFloat1 * paramFloat2 + 0.5F);
  }
  
  public static int a(float paramFloat, String paramString)
  {
    if ((android.text.TextUtils.isEmpty(paramString)) || (paramFloat <= 0.0F)) {}
    int i;
    do
    {
      return 24;
      i = a(paramFloat, paramString, 17, 3);
      if (i == 0) {
        return 22;
      }
    } while (i != 1);
    return 23;
  }
  
  private static int a(float paramFloat, String paramString, int paramInt1, int paramInt2)
  {
    Object localObject = new TextView(BaseApplicationImpl.getContext());
    ((TextView)localObject).setTextSize(paramInt1 * 3 / DeviceInfoUtil.jdField_a_of_type_Float);
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
  
  public static int a(int paramInt)
  {
    Object localObject = null;
    if (1 == paramInt) {
      localObject = new File(jdField_a_of_type_JavaLangString);
    }
    for (;;)
    {
      if ((localObject != null) && (((File)localObject).exists()) && (((File)localObject).isFile()))
      {
        localObject = FileUtils.a((File)localObject);
        if (!android.text.TextUtils.isEmpty((CharSequence)localObject)) {
          try
          {
            localObject = new JSONObject((String)localObject);
            long l;
            if (1 == paramInt)
            {
              if (((JSONObject)localObject).has("timeStamp"))
              {
                l = ((JSONObject)localObject).optLong("timeStamp") / 1000L;
                return (int)l;
                if (2 != paramInt) {
                  continue;
                }
                localObject = new File(jdField_b_of_type_JavaLangString);
                continue;
              }
              if (((JSONObject)localObject).has("timestamp")) {
                return (int)(((JSONObject)localObject).optLong("timestamp") / 1000L);
              }
            }
            else if (2 == paramInt)
            {
              l = ((JSONObject)localObject).optLong("timestamp");
              return (int)l;
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
    }
    return 0;
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
        paramAppInterface = (HotChatManager)paramAppInterface.getManager(59);
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
    }
    return 1;
  }
  
  public static int a(String paramString)
  {
    Object localObject = BaseApplicationImpl.getApplication();
    if (localObject != null)
    {
      localObject = ((BaseApplicationImpl)localObject).getRuntime();
      if ((localObject != null) && ((localObject instanceof AppInterface))) {
        localObject = (AppInterface)localObject;
      }
    }
    for (;;)
    {
      if (localObject == null)
      {
        return 0;
        if ((localObject instanceof ToolAppRuntime))
        {
          localObject = ((AppRuntime)localObject).getAppRuntime("modular_web");
          if ((localObject instanceof AppInterface)) {
            localObject = (AppInterface)localObject;
          }
        }
      }
      else
      {
        localObject = (ApolloDaoManager)((AppInterface)localObject).getManager(154);
        if (localObject != null)
        {
          localObject = ((ApolloDaoManager)localObject).a(paramString);
          if (localObject != null)
          {
            if (QLog.isColorLevel()) {
              QLog.d("ApolloUtil", 2, new Object[] { "findGameByHotChatCode from db gameId:", Integer.valueOf(((ApolloGameData)localObject).gameId) });
            }
            return ((ApolloGameData)localObject).gameId;
          }
          if (QLog.isColorLevel()) {
            QLog.d("ApolloUtil", 2, new Object[] { "not findGameByHotChatCode from db hotChatCode:", paramString });
          }
        }
        return 0;
      }
      localObject = null;
    }
  }
  
  public static int a(String paramString1, String paramString2)
  {
    if ((android.text.TextUtils.isEmpty(paramString1)) || (android.text.TextUtils.isEmpty(paramString2))) {
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
  
  public static long a(String paramString1, String paramString2)
  {
    if ((android.text.TextUtils.isEmpty(paramString1)) || (android.text.TextUtils.isEmpty(paramString2))) {
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
  
  public static SharedPreferences a()
  {
    return BaseApplicationImpl.getApplication().getSharedPreferences("apollo_game_res", 0);
  }
  
  public static ApolloUserTrace.STUserTrackReq a(String paramString)
  {
    ApolloUserTrace.STUserTrackReq localSTUserTrackReq = new ApolloUserTrace.STUserTrackReq();
    if (android.text.TextUtils.isEmpty(paramString)) {}
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
    if ((android.text.TextUtils.isEmpty(paramString1)) || (android.text.TextUtils.isEmpty(paramString2))) {
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
  
  public static String a(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder(100);
    if ((paramInt == 1) || (paramInt == 2)) {
      localStringBuilder.append(ApolloConstant.n).append(paramInt).append(File.separator).append("main.lua");
    }
    for (;;)
    {
      return localStringBuilder.toString();
      localStringBuilder.append(ApolloConstant.n).append(paramInt).append(File.separator).append("main.js");
    }
  }
  
  public static String a(Paint paramPaint, float paramFloat, String paramString, int paramInt)
  {
    if ((android.text.TextUtils.isEmpty(paramString)) || (paramPaint == null) || (paramFloat <= 0.0F)) {
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
      localObject = "[动作消息]";
    }
    do
    {
      String str;
      do
      {
        return localObject;
        str = "[动作消息]" + paramMessageForApollo.msg;
        localObject = str;
      } while (!ApolloGameUtil.a(paramMessageForApollo.msgType));
      localObject = str;
    } while (!a(paramQQAppInterface, paramMessageForApollo));
    if (!android.text.TextUtils.isEmpty(paramMessageForApollo.gameName)) {
      return "[轻游戏]" + paramMessageForApollo.gameName;
    }
    if (paramQQAppInterface != null)
    {
      paramMessageForApollo = ((ApolloDaoManager)paramQQAppInterface.getManager(154)).a(paramMessageForApollo.gameId);
      if (paramMessageForApollo != null) {
        return "[轻游戏]" + paramMessageForApollo.name;
      }
      paramMessageForApollo = "[轻游戏]" + "厘米互动";
      ApolloContentUpdateHandler.a(paramQQAppInterface, 2);
      return paramMessageForApollo;
    }
    return "[轻游戏]" + "厘米互动";
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
      localStringBuilder.append(ApolloConstant.jdField_c_of_type_JavaLangString).append(paramApolloActionData.actionId).append(File.separator).append("panelView.png");
      continue;
      localStringBuilder.append("http://cmshow.gtimg.cn/qqshow/admindata/comdata/vipApollo_action_").append(paramApolloActionData.actionId).append("/preview.png");
      continue;
      localStringBuilder.append(ApolloConstant.jdField_c_of_type_JavaLangString).append(paramApolloActionData.actionId).append(File.separator).append("panelGif.gif");
      continue;
      localStringBuilder.append("http://cmshow.gtimg.cn/qqshow/admindata/comdata/vipApollo_action_").append(paramApolloActionData.actionId).append("/preview.gif");
      continue;
      localStringBuilder.append(ApolloConstant.jdField_c_of_type_JavaLangString).append(paramApolloActionData.actionId).append(File.separator).append("actionRes.zip");
      continue;
      localStringBuilder.append("http://cmshow.gtimg.cn/qqshow/admindata/comdata/vipApollo_action_").append(paramApolloActionData.actionId).append("/d.zip");
      continue;
      localStringBuilder.append(ApolloConstant.jdField_c_of_type_JavaLangString).append(paramApolloActionData.actionId).append(File.separator);
      continue;
      localStringBuilder.append(ApolloConstant.jdField_c_of_type_JavaLangString).append(paramApolloActionData.actionId).append(File.separator).append("config.json");
      continue;
      localStringBuilder.append(ApolloConstant.l).append(paramApolloActionData.actionId);
      continue;
      localStringBuilder.append("http://cmshow.gtimg.cn/qqshow/admindata/comdata/vipApollo_drawerAction_").append(paramApolloActionData.actionId).append("/d.zip");
    }
  }
  
  public static String a(ApolloActionPackage paramApolloActionPackage)
  {
    if (paramApolloActionPackage == null) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder(100);
    localStringBuilder.append(ApolloConstant.i).append(paramApolloActionPackage.packageId).append(File.separator).append("tab.png");
    return localStringBuilder.toString();
  }
  
  public static String a(ApolloGameData paramApolloGameData)
  {
    StringBuilder localStringBuilder = new StringBuilder(100);
    localStringBuilder.append(ApolloConstant.n).append(paramApolloGameData.gameId);
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
        if (!android.text.TextUtils.isEmpty(paramMessageForApollo.inputText)) {
          localStringBuilder.append(" ").append(paramMessageForApollo.inputText);
        }
      }
      for (;;)
      {
        return localStringBuilder.toString();
        if (!android.text.TextUtils.isEmpty(paramMessageForApollo.inputText)) {
          localStringBuilder.append("：").append(paramMessageForApollo.inputText);
        }
      }
    }
    return "[动作消息]";
  }
  
  public static String a(String paramString)
  {
    if (android.text.TextUtils.isEmpty(paramString)) {}
    while (!a()) {
      return paramString;
    }
    QLog.d("ApolloUtil", 2, new Object[] { "checkWrapApolloUrl url:", paramString });
    String str = paramString;
    if (!paramString.contains("open.cmshow.qq.com")) {
      str = paramString.replace("cmshow.qq.com", "open.cmshow.qq.com").replace("cmshow.gtimg.cn", "open.cmshow.qq.com");
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
        if (android.text.TextUtils.isEmpty(str)) {
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
    if ((android.text.TextUtils.isEmpty(paramString1)) || (android.text.TextUtils.isEmpty(paramString2))) {
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
  
  public static ArrayList a(QQAppInterface paramQQAppInterface)
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
      if (android.text.TextUtils.isEmpty((CharSequence)localObject)) {
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
  
  public static void a()
  {
    ThreadManager.post(new yts(), 5, null, true);
  }
  
  private static void a(int paramInt, String paramString, QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    if ((paramQQAppInterface != null) && (paramSessionInfo != null)) {
      VipUtils.a(paramQQAppInterface, "cmshow", "Apollo", "eggaction", b(paramSessionInfo.jdField_a_of_type_Int), 0, new String[] { String.valueOf(paramInt), paramString });
    }
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
      if (!android.text.TextUtils.isEmpty(paramString2))
      {
        str = paramString2;
        if (new File(paramString2).exists()) {}
      }
      else
      {
        str = ImageUtil.a(paramActivity, paramString1);
      }
      try
      {
        if ((Utils.b()) && (ImageUtil.b(paramString1))) {
          Utils.b(paramString1, str, true, "", 0);
        }
        while ((!android.text.TextUtils.isEmpty(str)) && (new File(str).exists()))
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
          Utils.a(paramString1, str, true, "", 0);
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
    VasWebviewUtil.openQQBrowserActivity(paramContext, ApolloConstant.aa, -1L, localIntent, false, -1);
  }
  
  public static void a(Context paramContext, int paramInt1, int paramInt2)
  {
    if ((paramContext instanceof Activity)) {}
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
    Object localObject2 = null;
    Object localObject1 = localObject2;
    AppInterface localAppInterface = paramAppInterface;
    Object localObject3;
    if (paramAppInterface == null)
    {
      localObject3 = BaseApplicationImpl.getApplication();
      localObject1 = localObject2;
      localAppInterface = paramAppInterface;
      if (localObject3 != null)
      {
        localObject3 = ((BaseApplicationImpl)localObject3).getRuntime();
        if ((localObject3 == null) || (!(localObject3 instanceof AppInterface))) {
          break label127;
        }
        paramAppInterface = (AppInterface)localObject3;
        if (!(paramAppInterface instanceof QQAppInterface)) {
          break label902;
        }
        localObject1 = (ApolloManager)((QQAppInterface)paramAppInterface).getManager(152);
        localAppInterface = paramAppInterface;
      }
    }
    for (;;)
    {
      if (!ApolloManager.b(paramContext))
      {
        paramIntent = new Intent(paramContext, QQBrowserActivity.class);
        VasWebviewUtil.openQQBrowserActivity(paramContext, ApolloConstant.K, -1L, paramIntent, false, -1);
        return;
        label127:
        localObject1 = localObject2;
        localAppInterface = paramAppInterface;
        if ((localObject3 instanceof ToolAppRuntime))
        {
          localObject3 = ((AppRuntime)localObject3).getAppRuntime("modular_web");
          localObject1 = localObject2;
          localAppInterface = paramAppInterface;
          if ((localObject3 instanceof AppInterface))
          {
            localAppInterface = (AppInterface)localObject3;
            localObject1 = localObject2;
          }
        }
      }
      else
      {
        if (1 != ApolloManager.a(localAppInterface))
        {
          paramIntent = new Intent(paramContext, QQBrowserActivity.class);
          VasWebviewUtil.openQQBrowserActivity(paramContext, ApolloConstant.L + "0", -1L, paramIntent, false, -1);
          return;
        }
        paramAppInterface = paramIntent;
        if (paramIntent == null) {
          paramAppInterface = new Intent();
        }
        if (paramAppInterface.getIntExtra("key_box_type", 0) == 3)
        {
          VasWebviewUtil.openQQBrowserActivity(paramContext, ApolloConstant.T, -1L, new Intent(paramContext, QQBrowserActivity.class), false, -1);
          return;
        }
        paramIntent = "";
        if (localAppInterface != null)
        {
          paramIntent = localAppInterface.getCurrentNickname();
          localAppInterface.getLongAccountUin();
        }
        paramAppInterface.putExtra("extra_key_nickname", paramIntent);
        if (!android.text.TextUtils.isEmpty(paramString1)) {
          paramAppInterface.putExtra("extra_key_adtag", paramString1);
        }
        paramAppInterface.putExtra("extra_key_click_time", System.currentTimeMillis());
        paramAppInterface.putExtra("startOpenPageTime", System.currentTimeMillis());
        if (QLog.isColorLevel()) {
          QLog.d("ApolloUtil", 2, "apollo_client, clickTime:" + TimeFormatterUtils.a(System.currentTimeMillis(), "dd-MMM-yyyy HH:mm:ss:SSS") + ",url:" + paramString2);
        }
        if (!android.text.TextUtils.isEmpty(paramString2))
        {
          paramString1 = paramString2.replace("_bid=2423&", "");
          paramIntent = paramString1;
          if (PushDrawerStatus.jdField_c_of_type_Boolean)
          {
            if (android.text.TextUtils.isEmpty(PushDrawerStatus.jdField_c_of_type_JavaLangString))
            {
              paramIntent = URLUtil.a(paramString1, "wording", PushDrawerStatus.jdField_a_of_type_JavaLangString);
              paramIntent = URLUtil.a(URLUtil.a(paramIntent, "bubble_id", PushDrawerStatus.d), "tip_url", PushDrawerStatus.jdField_b_of_type_JavaLangString);
            }
          }
          else
          {
            if (localObject1 == null) {
              break label899;
            }
            if (!((ApolloManager)localObject1).d) {
              break label664;
            }
            paramString1 = "1";
            label492:
            paramString1 = URLUtil.a(paramIntent, "is_new_store_user", paramString1);
            if (!((ApolloManager)localObject1).e) {
              break label671;
            }
            paramIntent = "1";
            label513:
            paramIntent = URLUtil.a(paramString1, "is_game_box_user", paramIntent);
          }
        }
        label664:
        label671:
        label705:
        label838:
        label859:
        for (;;)
        {
          if (paramAppInterface.getBooleanExtra("extra_key_open_box", false)) {
            if (ApolloManager.d()) {
              paramAppInterface.putExtra("extra_key_open_box", false);
            }
          }
          for (paramIntent = URLUtil.a(paramIntent, "boxReady", "1");; paramIntent = URLUtil.a(paramIntent, "boxReady", "0"))
          {
            paramAppInterface.putExtra("url", paramIntent);
            paramAppInterface.putExtra("url", paramIntent);
            if ((!paramIntent.contains("webviewCheckType=1")) && (!paramIntent.contains("webviewCheckType=2"))) {
              break label859;
            }
            paramAppInterface.setClass(paramContext, ApolloStoreActivity.class);
            if (QLog.isColorLevel()) {
              QLog.d("ApolloUtil", 2, "apollo_client, ApolloStoreActivity");
            }
            label626:
            if ((!(paramContext instanceof Activity)) || (paramInt <= 0)) {
              break label887;
            }
            ((Activity)paramContext).startActivityForResult(paramAppInterface, paramInt);
            return;
            paramIntent = URLUtil.a(paramString1, "wording", PushDrawerStatus.jdField_c_of_type_JavaLangString);
            break;
            paramString1 = "0";
            break label492;
            paramIntent = "0";
            break label513;
          }
          if (!android.text.TextUtils.isEmpty(ApolloConstant.X))
          {
            paramIntent = ApolloConstant.X;
            paramString1 = paramIntent.replace("_bid=2423&", "");
            if (localObject1 == null) {
              break label894;
            }
            if (!((ApolloManager)localObject1).d) {
              break label831;
            }
            paramIntent = "1";
            label732:
            paramString1 = URLUtil.a(paramString1, "is_new_store_user", paramIntent);
            if (!((ApolloManager)localObject1).e) {
              break label838;
            }
            paramIntent = "1";
          }
          label753:
          label887:
          label894:
          for (paramIntent = URLUtil.a(paramString1, "is_game_box_user", paramIntent);; paramIntent = paramString1)
          {
            if (paramAppInterface.getBooleanExtra("extra_key_open_box", false)) {
              if (ApolloManager.d()) {
                paramAppInterface.putExtra("extra_key_open_box", false);
              }
            }
            for (paramIntent = URLUtil.a(paramIntent, "boxReady", "1");; paramIntent = URLUtil.a(paramIntent, "boxReady", "0"))
            {
              paramAppInterface.putExtra("url", paramIntent);
              paramAppInterface.putExtra("url", paramIntent);
              break;
              paramIntent = ApolloConstant.M;
              break label705;
              paramIntent = "0";
              break label732;
              paramIntent = "0";
              break label753;
            }
            paramAppInterface.setClass(paramContext, ApolloStoreActivity.class);
            if (!QLog.isColorLevel()) {
              break label626;
            }
            QLog.d("ApolloUtil", 2, "apollo_client, ApolloStoreActivity");
            break label626;
            paramContext.startActivity(paramAppInterface);
            return;
          }
        }
        label831:
        localObject1 = localObject2;
        label899:
        label902:
        localAppInterface = paramAppInterface;
      }
    }
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(ApolloConstant.R).append(paramString1).append("&adtag=").append(paramString2);
    paramString1 = new Intent(paramContext, QQBrowserActivity.class);
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
  
  public static void a(View paramView, QQAppInterface paramQQAppInterface, QQCustomMenu paramQQCustomMenu) {}
  
  public static void a(View paramView, FileManagerEntity paramFileManagerEntity, QQAppInterface paramQQAppInterface) {}
  
  public static void a(ImageView paramImageView, int paramInt)
  {
    if (paramImageView == null) {
      return;
    }
    switch (paramInt)
    {
    default: 
      paramImageView.setImageResource(2130838161);
      return;
    case 1: 
      paramImageView.setImageResource(2130838161);
      return;
    case 2: 
      paramImageView.setImageResource(2130838162);
      return;
    case 3: 
      paramImageView.setImageResource(2130838163);
      return;
    case 4: 
      paramImageView.setImageResource(2130838164);
      return;
    case 5: 
      paramImageView.setImageResource(2130838165);
      return;
    case 6: 
      paramImageView.setImageResource(2130838166);
      return;
    }
    paramImageView.setImageResource(2130838167);
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
          if (ApolloManager.c("gameSwitch") == 1) {}
          for (int i = 1; (!bool) && (i != 0) && (paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (paramBaseChatPie.jdField_a_of_type_AndroidContentContext != null); i = 0)
          {
            str2 = localSessionInfo.jdField_a_of_type_JavaLangString;
            str3 = paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c();
            if ((!android.text.TextUtils.isEmpty(str2)) && (!android.text.TextUtils.isEmpty(str3))) {
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
    } while ((!((Boolean)localObject1).booleanValue()) || ((paramInt != 1) && ((paramInt != 0) || (!localSharedPreferences.getBoolean(str1, true)))) || ((ApolloManager)paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(152) == null));
    long l = MessageCache.a();
    paramInt = "体验更多游戏，马上加入厘米秀".indexOf("马");
    Object localObject1 = new Bundle();
    ((Bundle)localObject1).putInt("key_action", 1);
    ((Bundle)localObject1).putString("textColor", "#00a5e0");
    ((Bundle)localObject1).putString("key_action_DATA", ApolloConstant.L + "&adTag=gametips");
    Object localObject2 = new UniteGrayTipParam(str2, str3, "体验更多游戏，马上加入厘米秀", localSessionInfo.jdField_a_of_type_Int, -5040, 2359298, l);
    ((UniteGrayTipParam)localObject2).a(paramInt, paramInt + 7, (Bundle)localObject1);
    localObject1 = new MessageForUniteGrayTip();
    ((MessageForUniteGrayTip)localObject1).initGrayTipMsg(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (UniteGrayTipParam)localObject2);
    UniteGrayTipUtil.a(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageForUniteGrayTip)localObject1);
    if (QLog.isColorLevel()) {
      QLog.d("ApolloUtil", 2, "send apollo gray tip");
    }
    localSharedPreferences.edit().putBoolean(str1, false).commit();
    VipUtils.a(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "intro_show", b(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), 0, new String[0]);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, ChatMessage paramChatMessage, AnimationTextView paramAnimationTextView, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloUtil", 2, new Object[] { "[playApolloEmoticonAction] position=", Integer.valueOf(paramInt1), ", itemCount=", Integer.valueOf(paramInt2), ", isLongMsg=", Boolean.valueOf(paramBoolean) });
    }
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
      if (android.text.TextUtils.isEmpty(paramChatMessage.extStr)) {}
    }
    for (;;)
    {
      try
      {
        localObject1 = new JSONObject(paramChatMessage.extStr).optString("is_apollo_emoticon_action_checked");
        if ((android.text.TextUtils.isEmpty((CharSequence)localObject1)) || (!"1".equals(localObject1))) {
          break label405;
        }
        paramBoolean = true;
        if (QLog.isColorLevel()) {
          QLog.d("ApolloUtil", 2, new Object[] { "[playApolloEmoticonAction] apollo emoticon action played=", Boolean.valueOf(paramBoolean), ", uniseq=", Long.valueOf(paramChatMessage.uniseq) });
        }
        if (paramBoolean) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("ApolloUtil", 2, "[playApolloEmoticonAction] set apollo emoticon action play status true");
        }
        paramChatMessage.saveExtInfoToExtStr("is_apollo_emoticon_action_checked", "1");
        ThreadManager.post(new ytp(paramChatMessage), 5, null, false);
        if (paramInt1 != paramInt2 - 1) {
          break;
        }
        localObject1 = (ApolloManager)paramQQAppInterface.getManager(152);
        if (localObject1 == null) {
          break;
        }
        localObject1 = ((ApolloManager)localObject1).a(paramQQAppInterface.getCurrentAccountUin());
        if ((localObject1 == null) || (((ApolloBaseInfo)localObject1).apolloStatus != 1)) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("ApolloUtil", 2, "[playApolloEmoticonAction] apollo status open, grab action");
        }
        paramAnimationTextView = paramAnimationTextView.getText();
        if ((paramAnimationTextView == null) || (!(paramAnimationTextView instanceof QQText))) {
          break;
        }
        paramChatMessage.saveExtInfoToExtStr("is_apollo_emoticon_action_played", "2");
        ThreadManager.post(new ytq(paramAnimationTextView, paramQQAppInterface, paramSessionInfo, paramChatMessage), 5, null, false);
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
      label405:
      paramBoolean = false;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, ArrayList paramArrayList)
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
      ThreadManager.getFileThreadHandler().post(new yto(paramMessageForApollo, paramQQAppInterface, paramString, paramInt));
    }
  }
  
  public static void a(DownloadTask paramDownloadTask) {}
  
  public static void a(String paramString)
  {
    if (QLog.isColorLevel())
    {
      long l = System.currentTimeMillis();
      QLog.d("ApolloUtil", 2, "[endTrace] " + paramString + " cost:" + (l - jdField_a_of_type_Long));
      jdField_a_of_type_Long = l;
    }
  }
  
  public static boolean a()
  {
    QLog.e("ApolloUtil", 1, "isApolloProxyEnable !AppSetting.isDebugVersion");
    return false;
  }
  
  public static boolean a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloUtil", 2, "[isRoleRelatedActionExist], roleId:" + paramInt);
    }
    String str;
    int i;
    if (paramInt == 0)
    {
      str = ApolloConstant.jdField_b_of_type_JavaLangString + "/def/role/";
      i = 1;
    }
    for (;;)
    {
      if (i >= 5) {
        break label331;
      }
      File localFile1 = new File(str, paramInt + "/" + i);
      if (!localFile1.exists())
      {
        if (QLog.isColorLevel()) {
          QLog.d("ApolloUtil", 2, "dir NOT exist." + localFile1.getPath());
        }
        return false;
        str = ApolloConstant.f;
        break;
      }
      File localFile2 = new File(localFile1, ApolloConstant.q);
      if (!localFile2.exists())
      {
        if (QLog.isColorLevel()) {
          QLog.d("ApolloUtil", 2, "ACTION_FILE_JSON_NAME NOT exist." + localFile2.getPath());
        }
        return false;
      }
      localFile2 = new File(localFile1, ApolloConstant.r);
      if (!localFile2.exists())
      {
        if (QLog.isColorLevel()) {
          QLog.d("ApolloUtil", 2, "ACTION_FILE_ATLAS_NAME NOT exist." + localFile2.getPath());
        }
        return false;
      }
      localFile1 = new File(localFile1, ApolloConstant.p);
      if (!localFile1.exists())
      {
        if (QLog.isColorLevel()) {
          QLog.d("ApolloUtil", 2, "ACTION_FILE_PNG_NAME NOT exist." + localFile1.getPath());
        }
        return false;
      }
      i += 1;
    }
    label331:
    return true;
  }
  
  public static boolean a(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloUtil", 2, "[isActionResDone], actionId:" + paramInt1 + ",personNum:" + paramInt2);
    }
    File localFile = new File(ApolloConstant.jdField_c_of_type_JavaLangString + paramInt1);
    if (paramInt1 < 21) {
      localFile = new File(ApolloConstant.jdField_b_of_type_JavaLangString, "/def/basic/action/" + paramInt1);
    }
    if (!localFile.exists()) {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloUtil", 2, "dir NOT exist." + localFile.getPath());
      }
    }
    label273:
    do
    {
      for (;;)
      {
        return false;
        if ((b(localFile.getAbsolutePath() + "/" + ApolloConstant.q)) && (b(localFile.getAbsolutePath() + "/" + ApolloConstant.r)) && (b(localFile.getAbsolutePath() + "/" + ApolloConstant.p))) {}
        for (paramInt1 = 1; paramInt1 != 0; paramInt1 = 0)
        {
          if (paramInt2 != 0) {
            break label273;
          }
          return true;
        }
      }
    } while (paramInt2 != 1);
    if ((b(localFile.getAbsolutePath() + "/" + ApolloConstant.t)) && (b(localFile.getAbsolutePath() + "/" + ApolloConstant.u)) && (b(localFile.getAbsolutePath() + "/" + ApolloConstant.s))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public static boolean a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloUtil", 2, new Object[] { "[isWhiteFaceActionRscDone], actionId:", Integer.valueOf(paramInt1), ",subType:", Integer.valueOf(paramInt2), ",personNum:", Integer.valueOf(paramInt3), ",isGroup:", Boolean.valueOf(paramBoolean) });
    }
    Object localObject1 = new File(ApolloConstant.jdField_c_of_type_JavaLangString + paramInt1 + "/action");
    if (!((File)localObject1).exists()) {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloUtil", 2, "dir NOT exist." + ((File)localObject1).getPath());
      }
    }
    label376:
    label379:
    label381:
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
        if (paramInt2 == 1)
        {
          localObject1 = (String)localObject2 + "/main/";
          if ((!b((String)localObject1 + ApolloConstant.q)) || (!b((String)localObject1 + ApolloConstant.r)) || (!b((String)localObject1 + ApolloConstant.p))) {
            break label376;
          }
        }
        for (paramInt1 = 1;; paramInt1 = 0)
        {
          if (paramInt1 == 0) {
            break label379;
          }
          if (paramInt3 != 0) {
            break label381;
          }
          return true;
          if (paramInt2 == 0)
          {
            localObject1 = (String)localObject2 + "/pre/";
            break;
          }
          localObject1 = localObject2;
          if (paramInt2 != 2) {
            break;
          }
          localObject1 = (String)localObject2 + "/post/";
          break;
        }
      }
    } while (paramInt3 != 1);
    if ((b((String)localObject1 + ApolloConstant.t)) && (b((String)localObject1 + ApolloConstant.u)) && (b((String)localObject1 + ApolloConstant.s))) {}
    for (paramBoolean = true;; paramBoolean = false) {
      return paramBoolean;
    }
  }
  
  public static boolean a(long paramLong1, long paramLong2)
  {
    return Math.abs(paramLong2 - paramLong1) > 500L;
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
    if ((ApolloManager.a(paramQQAppInterface, "drawer", null) > 0) && (ApolloManager.a(BaseApplicationImpl.getContext(), Boolean.valueOf(false)))) {}
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
  
  public static boolean a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, MessageRecord paramMessageRecord, List paramList)
  {
    if (paramMessageRecord == null) {
      return false;
    }
    if ((paramMessageRecord instanceof MessageForText)) {
      paramMessageRecord = paramMessageRecord.msg;
    }
    for (;;)
    {
      paramMessageRecord = new QQText(paramMessageRecord, 2);
      QQText.EmoticonSpan[] arrayOfEmoticonSpan = (QQText.EmoticonSpan[])paramMessageRecord.getSpans(0, paramMessageRecord.length(), QQText.EmoticonSpan.class);
      if ((arrayOfEmoticonSpan == null) || (arrayOfEmoticonSpan.length <= 0)) {
        break label169;
      }
      int j = arrayOfEmoticonSpan.length;
      int i = 0;
      while (i < j)
      {
        int k = arrayOfEmoticonSpan[i].a();
        if ((com.tencent.mobileqq.text.TextUtils.a(k)) && (k >= 0) && (k < MessageUtils.a.length)) {
          paramList.add(Integer.valueOf(f(MessageUtils.a[k])));
        }
        i += 1;
      }
      if (!(paramMessageRecord instanceof MessageForLongMsg)) {
        break;
      }
      paramMessageRecord = (MessageForLongMsg)paramMessageRecord;
      if (android.text.TextUtils.isEmpty(paramMessageRecord.sb2)) {
        paramMessageRecord = paramMessageRecord.sb;
      } else {
        paramMessageRecord = paramMessageRecord.sb2;
      }
    }
    label169:
    if (paramList.size() == 0) {
      b(paramQQAppInterface, paramSessionInfo, paramMessageRecord, paramList);
    }
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, MessageForApollo paramMessageForApollo)
  {
    Object localObject2 = null;
    if ((paramMessageForApollo == null) || (paramQQAppInterface == null)) {
      return false;
    }
    Object localObject1 = (ApolloDaoManager)paramQQAppInterface.getManager(154);
    if (ApolloGameUtil.a(paramMessageForApollo.msgType)) {}
    for (localObject1 = ((ApolloDaoManager)localObject1).a(paramMessageForApollo.gameId);; localObject1 = null)
    {
      if ((ApolloManager.c("gameSwitch") != 1) || ((localObject1 != null) && (!ApolloConfigUtils.a("7.6.0", ((ApolloGameData)localObject1).minVer, ((ApolloGameData)localObject1).maxVer))))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ApolloUtil", 2, "play apollo game msg but switch is 0 or version is incorrect");
        }
        return false;
      }
      if (paramQQAppInterface.getApp() == null) {}
      for (paramQQAppInterface = localObject2; (ApolloManager.a(paramQQAppInterface)) && (paramMessageForApollo.istroop == 3000) && (ApolloManager.c("discuss") == 0); paramQQAppInterface = paramQQAppInterface.getApp().getApplicationContext()) {
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
      if (!FileUtil.a(a(paramApolloActionData, 0))) {
        bool = false;
      }
    } while (!a(paramApolloActionData.actionId, paramApolloActionData.personNum));
    return bool;
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
      if ((b(paramString.getAbsolutePath() + "/" + ApolloConstant.q)) && (b(paramString.getAbsolutePath() + "/" + ApolloConstant.r)) && (b(paramString.getAbsolutePath() + "/" + ApolloConstant.p))) {}
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
      byte[] arrayOfByte = "[动作消息]消息接收失败".getBytes();
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
  
  public static String[] a(float paramFloat1, float paramFloat2, List paramList)
  {
    String[] arrayOfString = new String[2];
    arrayOfString[0] = "-1";
    arrayOfString[1] = "";
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      ApolloSkeletonBounding localApolloSkeletonBounding = (ApolloSkeletonBounding)paramList.next();
      if (QLog.isColorLevel()) {
        QLog.d("ApolloSkeletonBounding", 2, "x:" + localApolloSkeletonBounding.jdField_a_of_type_Float + ",y = " + localApolloSkeletonBounding.b + ",width = " + localApolloSkeletonBounding.c + ",heigth = " + localApolloSkeletonBounding.d);
      }
      if ((paramFloat1 >= localApolloSkeletonBounding.jdField_a_of_type_Float) && (paramFloat1 <= localApolloSkeletonBounding.jdField_a_of_type_Float + localApolloSkeletonBounding.c) && (paramFloat2 >= localApolloSkeletonBounding.b) && (paramFloat2 <= localApolloSkeletonBounding.b + localApolloSkeletonBounding.d))
      {
        arrayOfString[0] = "1";
        arrayOfString[1] = localApolloSkeletonBounding.jdField_a_of_type_JavaLangString;
        if ((paramFloat1 >= localApolloSkeletonBounding.e) && (paramFloat1 <= localApolloSkeletonBounding.e + localApolloSkeletonBounding.g) && (paramFloat2 >= localApolloSkeletonBounding.f))
        {
          paramFloat1 = localApolloSkeletonBounding.f;
          if (paramFloat2 <= localApolloSkeletonBounding.h + paramFloat1) {
            arrayOfString[0] = "1000";
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d("ApolloSkeletonBounding", 2, "mNode:" + arrayOfString[0] + ",mApolloId = " + arrayOfString[1]);
        }
      }
    }
    return arrayOfString;
  }
  
  public static int b(float paramFloat, String paramString)
  {
    if ((android.text.TextUtils.isEmpty(paramString)) || (paramFloat <= 0.0F)) {}
    int i;
    do
    {
      return 43;
      i = a(paramFloat, paramString, 8, 6);
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
  
  public static int b(String paramString)
  {
    try
    {
      if (android.text.TextUtils.isEmpty(paramString)) {
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
  
  public static String b(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder(50);
    localStringBuilder.append(ApolloConstant.h).append(paramInt);
    return localStringBuilder.toString();
  }
  
  public static String b(ApolloActionPackage paramApolloActionPackage)
  {
    return null;
  }
  
  public static String b(String paramString)
  {
    try
    {
      if (!android.text.TextUtils.isEmpty(paramString))
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
  
  public static void b(ImageView paramImageView, int paramInt)
  {
    if (paramImageView == null) {
      return;
    }
    switch (paramInt)
    {
    default: 
      paramImageView.setImageResource(2130838129);
      return;
    case 1: 
      paramImageView.setImageResource(2130838129);
      return;
    case 2: 
      paramImageView.setImageResource(2130838130);
      return;
    case 3: 
      paramImageView.setImageResource(2130838131);
      return;
    case 4: 
      paramImageView.setImageResource(2130838132);
      return;
    case 5: 
      paramImageView.setImageResource(2130838133);
      return;
    case 6: 
      paramImageView.setImageResource(2130838134);
      return;
    }
    paramImageView.setImageResource(2130838135);
  }
  
  private static void b(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, QQText paramQQText, List paramList)
  {
    if ((paramQQAppInterface == null) || (paramQQText == null)) {}
    long l1;
    Object localObject;
    HashMap localHashMap;
    do
    {
      do
      {
        return;
      } while (!ApolloManager.e());
      l1 = System.currentTimeMillis();
      paramQQText = paramQQText.b();
      localObject = (ApolloDaoManager)paramQQAppInterface.getManager(154);
      localHashMap = ((ApolloDaoManager)localObject).a();
    } while ((localHashMap == null) || (localHashMap.size() == 0));
    int i1 = ((ApolloDaoManager)localObject).a();
    int i = 0;
    int k;
    for (int j = 0;; j = k)
    {
      int m;
      if (i < paramQQText.length()) {
        m = i1;
      }
      int n;
      for (;;)
      {
        n = i;
        k = j;
        if (m > 0)
        {
          if (i + m <= paramQQText.length())
          {
            localObject = paramQQText.substring(i, i + m);
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
  
  public static boolean b()
  {
    boolean bool2 = true;
    if (jdField_a_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloUtil", 1, new Object[] { "isLowDevice sIsLowDevices:", Boolean.valueOf(jdField_b_of_type_Boolean) });
      }
      return jdField_b_of_type_Boolean;
    }
    long l1 = DeviceInfoUtil.a();
    int i = DeviceInfoUtil.b();
    long l2 = DeviceInfoUtil.e();
    if ((l1 > 1600L) && (i >= 4) && (l2 >= -1073741824L))
    {
      bool1 = true;
      QLog.d("ApolloUtil", 1, new Object[] { "isLowDevice cpuFreq:", Long.valueOf(l1), " cpuNumber:", Integer.valueOf(i), " totalMem:", Long.valueOf(l2), " highDevice:", Boolean.valueOf(bool1) });
      jdField_a_of_type_Boolean = true;
      if (bool1) {
        break label169;
      }
    }
    label169:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      jdField_b_of_type_Boolean = bool1;
      return jdField_b_of_type_Boolean;
      bool1 = false;
      break;
    }
  }
  
  public static boolean b(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloUtil", 2, "[checkDressRes], dressId:" + paramInt);
    }
    File localFile = new File(ApolloConstant.e + paramInt);
    if (paramInt < 21) {
      localFile = new File(ApolloConstant.jdField_b_of_type_JavaLangString, "/def/basic/dress/" + paramInt);
    }
    if (!localFile.exists())
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloUtil", 2, "dir NOT exist." + localFile.getPath());
      }
      return false;
    }
    if ((b(localFile.getAbsolutePath() + "/" + ApolloConstant.w)) && (b(localFile.getAbsolutePath() + "/" + ApolloConstant.x)) && (b(localFile.getAbsolutePath() + "/" + ApolloConstant.v))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public static boolean b(int paramInt1, int paramInt2)
  {
    boolean bool = true;
    switch (paramInt1)
    {
    default: 
      bool = false;
    }
    File localFile;
    do
    {
      do
      {
        return bool;
        localFile = new File(ApolloConstant.f + paramInt2);
      } while ((b(localFile.getAbsolutePath() + "/" + ApolloConstant.E)) && (b(localFile.getAbsolutePath() + "/" + ApolloConstant.F)) && (b(localFile.getAbsolutePath() + "/" + ApolloConstant.H)) && (b(localFile.getAbsolutePath() + "/" + ApolloConstant.G)));
      return false;
      localFile = new File(ApolloConstant.e + paramInt2);
    } while ((b(localFile.getAbsolutePath() + "/" + ApolloConstant.v)) && (b(localFile.getAbsolutePath() + "/" + ApolloConstant.w)) && (b(localFile.getAbsolutePath() + "/" + ApolloConstant.x)));
    return false;
  }
  
  public static boolean b(String paramString)
  {
    if (android.text.TextUtils.isEmpty(paramString)) {}
    File localFile;
    do
    {
      return false;
      localFile = new File(paramString);
      if (localFile.exists()) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("ApolloUtil", 2, "ErrorInfo-> " + paramString + " NOT exist.");
    return false;
    if (localFile.length() == 0L)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloUtil", 2, "ErrorInfo-> " + paramString + ",lenght is 0.");
      }
      localFile.delete();
      return false;
    }
    return true;
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
  
  public static String c(int paramInt)
  {
    if (paramInt == -1) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder("http://cmshow.gtimg.cn/qqshow/admindata/comdata/vipApollo_drawerAction_");
    localStringBuilder.append(paramInt).append("/d.zip");
    return localStringBuilder.toString();
  }
  
  /* Error */
  public static String c(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: invokestatic 210	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   5: invokevirtual 1504	com/tencent/common/app/BaseApplicationImpl:getAssets	()Landroid/content/res/AssetManager;
    //   8: aload_0
    //   9: invokevirtual 1510	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   12: astore_0
    //   13: aload_0
    //   14: ifnull +37 -> 51
    //   17: aload_0
    //   18: aload_0
    //   19: invokevirtual 1515	java/io/InputStream:available	()I
    //   22: i2l
    //   23: invokestatic 1521	com/tencent/qphone/base/util/MD5:toMD5Byte	(Ljava/io/InputStream;J)[B
    //   26: invokestatic 1527	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   29: astore_1
    //   30: aload_1
    //   31: astore_2
    //   32: aload_0
    //   33: ifnull +9 -> 42
    //   36: aload_0
    //   37: invokevirtual 1530	java/io/InputStream:close	()V
    //   40: aload_1
    //   41: astore_2
    //   42: aload_2
    //   43: areturn
    //   44: astore_0
    //   45: aload_0
    //   46: invokevirtual 1533	java/io/IOException:printStackTrace	()V
    //   49: aload_1
    //   50: areturn
    //   51: aload_0
    //   52: ifnull -10 -> 42
    //   55: aload_0
    //   56: invokevirtual 1530	java/io/InputStream:close	()V
    //   59: aconst_null
    //   60: areturn
    //   61: astore_0
    //   62: aload_0
    //   63: invokevirtual 1533	java/io/IOException:printStackTrace	()V
    //   66: aconst_null
    //   67: areturn
    //   68: astore_0
    //   69: aconst_null
    //   70: astore_0
    //   71: aload_0
    //   72: ifnull -30 -> 42
    //   75: aload_0
    //   76: invokevirtual 1530	java/io/InputStream:close	()V
    //   79: aconst_null
    //   80: areturn
    //   81: astore_0
    //   82: aload_0
    //   83: invokevirtual 1533	java/io/IOException:printStackTrace	()V
    //   86: aconst_null
    //   87: areturn
    //   88: astore_1
    //   89: aconst_null
    //   90: astore_0
    //   91: aload_0
    //   92: ifnull +7 -> 99
    //   95: aload_0
    //   96: invokevirtual 1530	java/io/InputStream:close	()V
    //   99: aload_1
    //   100: athrow
    //   101: astore_0
    //   102: aload_0
    //   103: invokevirtual 1533	java/io/IOException:printStackTrace	()V
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
  
  public static boolean c(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloUtil", 2, "[checkRoleRes], roleId:" + paramInt);
    }
    File localFile1;
    if (paramInt == 0)
    {
      localFile1 = new File(ApolloConstant.jdField_b_of_type_JavaLangString, "/def/basic/skeleton/" + paramInt);
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
      localFile1 = new File(ApolloConstant.f + paramInt);
      break;
      localFile2 = new File(localFile1, ApolloConstant.H);
      if ((paramInt == 0) || (localFile2.exists())) {
        break label202;
      }
    } while (!QLog.isColorLevel());
    QLog.d("ApolloUtil", 2, "ROLE_FILE_CONFIG_NAME NOT exist." + localFile2.getPath());
    return false;
    label202:
    if ((b(localFile1.getAbsolutePath() + "/" + ApolloConstant.F)) && (b(localFile1.getAbsolutePath() + "/" + ApolloConstant.G)) && (b(localFile1.getAbsolutePath() + "/" + ApolloConstant.E))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public static boolean c(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloUtil", 2, "[isBubbleRscExist], roleId:" + paramInt1 + ",bubbleId:" + paramInt2);
    }
    if (paramInt1 == 0) {}
    for (File localFile1 = new File(ApolloConstant.jdField_b_of_type_JavaLangString, "/def/role/" + paramInt1);; localFile1 = new File(ApolloConstant.f + paramInt1))
    {
      localFile1 = new File(localFile1, ApolloConstant.y + "/" + paramInt2);
      if (localFile1.exists()) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ApolloUtil", 2, "dir NOT exist." + localFile1.getPath());
      }
      return false;
    }
    File localFile2 = new File(localFile1, ApolloConstant.w);
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
    localFile2 = new File(localFile1, ApolloConstant.x);
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
    localFile1 = new File(localFile1, ApolloConstant.v);
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
  
  public static int d(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= 2147483647))
    {
      QLog.e("ApolloUtil", 1, "[getRandomInteger] invalid " + paramInt);
      return 0;
    }
    return new Random().nextInt(paramInt);
  }
  
  public static String d(int paramInt)
  {
    if (2 == paramInt) {
      return "friend";
    }
    return "me";
  }
  
  public static String d(String paramString)
  {
    if (android.text.TextUtils.isEmpty(paramString)) {
      return "";
    }
    if (paramString.length() > 5) {
      return paramString.substring(0, 5);
    }
    return "";
  }
  
  public static String e(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(ApolloConstant.jdField_c_of_type_JavaLangString).append(paramInt).append(File.separator).append("action/").append("music.amr");
    String str = localStringBuilder.toString();
    Object localObject = str;
    if (!FileUtils.a(str))
    {
      int i = str.length();
      localStringBuilder.delete(str.length() - "music.amr".length(), i);
      localStringBuilder.append("music/");
      localObject = localStringBuilder.toString();
      if (!FileUtils.a((String)localObject)) {
        break label281;
      }
      localObject = new File((String)localObject).list(new ytr());
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
  
  private static int f(int paramInt)
  {
    if (paramInt < 229) {
      return paramInt + 10000;
    }
    return paramInt + 20000;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.utils.ApolloUtil
 * JD-Core Version:    0.7.0.1
 */