package com.tencent.mobileqq.apollo.utils.api.impl;

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
import android.support.annotation.NonNull;
import android.util.SparseArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.ArkFullScreenAppActivity;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.panel.PanelManager;
import com.tencent.mobileqq.apollo.CmShowLauncher;
import com.tencent.mobileqq.apollo.aio.ChatPieApolloViewController;
import com.tencent.mobileqq.apollo.aio.api.IApolloAIOHelper;
import com.tencent.mobileqq.apollo.aio.api.impl.CmShowAioMatcherImpl;
import com.tencent.mobileqq.apollo.aio.panel.ApolloPanel;
import com.tencent.mobileqq.apollo.aio.panel.api.impl.ApolloPanelProviderImpl;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.api.impl.ApolloManagerServiceImpl;
import com.tencent.mobileqq.apollo.config.ApolloConfigUtils;
import com.tencent.mobileqq.apollo.config.CmShowWnsUtils;
import com.tencent.mobileqq.apollo.emotionview.EmoticonPanelCmShowHelper;
import com.tencent.mobileqq.apollo.game.utils.ApolloGameUtil;
import com.tencent.mobileqq.apollo.model.Apollo3DMessage;
import com.tencent.mobileqq.apollo.model.ApolloActionData;
import com.tencent.mobileqq.apollo.model.ApolloActionPackage;
import com.tencent.mobileqq.apollo.model.ApolloBaseInfo;
import com.tencent.mobileqq.apollo.model.ApolloBattleGameInfo;
import com.tencent.mobileqq.apollo.model.ApolloDrawableExtraInfo;
import com.tencent.mobileqq.apollo.model.ApolloGameData;
import com.tencent.mobileqq.apollo.model.ApolloMessage;
import com.tencent.mobileqq.apollo.model.App3DConfig;
import com.tencent.mobileqq.apollo.model.MessageForApollo;
import com.tencent.mobileqq.apollo.model.StartCheckParam;
import com.tencent.mobileqq.apollo.persistence.api.IApolloDaoManagerService;
import com.tencent.mobileqq.apollo.persistence.api.impl.ApolloDaoManagerServiceImpl;
import com.tencent.mobileqq.apollo.script.ISpriteContext;
import com.tencent.mobileqq.apollo.statistics.trace.TraceReportUtil;
import com.tencent.mobileqq.apollo.utils.ApolloConstant;
import com.tencent.mobileqq.apollo.utils.ApolloHttpUtil;
import com.tencent.mobileqq.apollo.utils.VersionUtil;
import com.tencent.mobileqq.apollo.utils.api.IApolloUtil;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloRender;
import com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloTextureView;
import com.tencent.mobileqq.cmshow.engine.util.CMGetResPathUtil;
import com.tencent.mobileqq.cmshow.engine.util.CMResUtil;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForLongMsg;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.mobileqq.emoticonview.EmoticonImageView;
import com.tencent.mobileqq.emoticonview.SystemEmoticonInfo;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.graytip.UniteGrayTipMsgUtil;
import com.tencent.mobileqq.graytip.UniteGrayTipParam;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.pic.api.ICompressOperator;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.text.style.EmoticonSpan;
import com.tencent.mobileqq.urldrawable.URLDrawableHelperConstants;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.ShareMsgHelper;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vas.VasH5PayUtil;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mqq.shared_file_accessor.SharedPreferencesProxyManager;
import com.tencent.pb.apollousertrace.ApolloUserTrace.STClickInfo;
import com.tencent.pb.apollousertrace.ApolloUserTrace.STUserClickTrack;
import com.tencent.pb.apollousertrace.ApolloUserTrace.STUserTrackReq;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.vip.manager.QZoneVipInfoManager;
import java.io.File;
import java.net.URL;
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
import javax.net.ssl.SSLContext;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONObject;
import trpc.cmshow.game.OpenGameBox.StBoxItem;

public class ApolloUtilImpl
  implements IApolloUtil
{
  public static final String APOLLO_EMOTICON_MSG_CHECKED_FLAG = "1";
  public static final String APOLLO_EMOTICON_MSG_PLAYED_FLAG = "2";
  public static final String APOLLO_GAME_RES_SP = "apollo_game_res";
  public static final String APOLLO_JSON_PATH = "/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/action/action_v730.json";
  public static final String APOLLO_JSON_URL = "https://cmshow.gtimg.cn/qqshow/admindata/comdata/vipList_apollo_data/tab_list_android_v730.json";
  public static final String APOLLO_REPORT_CONFIG_PAT = "/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/apollo_report_config.json";
  public static final String APOLLO_REPORT_CONFIG_URL = "https://cmshow.gtimg.cn/xydata/cmshow/app/terminalCmConfig/xydata.json";
  public static final String APOLLO_SHARE_ARK_MES_CHECKED_FLAG = "1";
  public static final String APOLLO_SHARE_ARK_MES_PLAYED_FLAG = "2";
  public static final int MAX_LOG_SEGMENT_SIZE = 2048;
  private static final int NEW_ICON_MAX_SHOW_TIMES = 3;
  public static final String TAG = "[cmshow]ApolloUtil";
  private static HashMap<String, String> dressTypeMap;
  private static boolean mNeedGrayTip = true;
  public static Comparator<File> mResPriorityComparator = new ApolloUtilImpl.6();
  public static long sCurrentTimeStamp;
  public static ApolloUtilImpl.HardwareInfo sHardwareInfo;
  private static SharedPreferences sHttpProxyPreferences;
  private static int sMsAALevel = -2147483648;
  private static int sNewIconShowTimes;
  private static boolean sNewIconShowTimesLoaded;
  private static boolean sPopupGuideFlagLoaded;
  private static boolean sPopupGuideShown;
  public static long sRenderRunnableTimeOut = 100L;
  private static int sShownNewEmoticonSize;
  
  public static void addWhiteFaceUnSupportTips(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    if ((paramQQAppInterface != null) && (paramSessionInfo != null))
    {
      if (!mNeedGrayTip) {
        return;
      }
      mNeedGrayTip = false;
      Object localObject2 = paramSessionInfo.jdField_a_of_type_JavaLangString;
      String str = paramQQAppInterface.getCurrentUin();
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("apollo_white_face_unsupport_gray_tip");
      ((StringBuilder)localObject1).append(str);
      localObject1 = ((StringBuilder)localObject1).toString();
      SharedPreferences localSharedPreferences = SharedPreferencesProxyManager.getInstance().getProxy("apollo_sp", 0);
      if (!localSharedPreferences.getBoolean((String)localObject1, true)) {
        return;
      }
      long l = MessageCache.a();
      paramSessionInfo = new UniteGrayTipParam((String)localObject2, str, HardCodeUtil.a(2131700756), paramSessionInfo.jdField_a_of_type_Int, -5040, 2359299, l);
      localObject2 = new MessageForUniteGrayTip();
      ((MessageForUniteGrayTip)localObject2).initGrayTipMsg(paramQQAppInterface, paramSessionInfo);
      UniteGrayTipMsgUtil.a(paramQQAppInterface, (MessageForUniteGrayTip)localObject2);
      if (QLog.isColorLevel()) {
        QLog.d("[cmshow]ApolloUtil", 2, "addWhiteFaceUnSupportTips send white face unsupport gray tip");
      }
      localSharedPreferences.edit().putBoolean((String)localObject1, false).commit();
      VipUtils.a(paramQQAppInterface, "cmshow", "Apollo", "graystripe_3Demotion_view", 0, 0, new String[] { "" });
    }
  }
  
  public static String autoSplitText(Paint paramPaint, float paramFloat, String paramString, int paramInt)
  {
    if ((!android.text.TextUtils.isEmpty(paramString)) && (paramPaint != null))
    {
      if (paramFloat <= 0.0F) {
        return "";
      }
      String[] arrayOfString = paramString.replaceAll("\r", "").split("\n");
      StringBuilder localStringBuilder = new StringBuilder();
      int n = arrayOfString.length;
      int m = 0;
      int i = 0;
      while (m < n)
      {
        String str = arrayOfString[m];
        if (paramPaint.measureText(str) <= paramFloat)
        {
          localStringBuilder.append(str);
        }
        else
        {
          i = 0;
          float f = 0.0F;
          j = 0;
          int k;
          for (;;)
          {
            k = j;
            if (i == str.length()) {
              break;
            }
            char c = str.charAt(i);
            f += paramPaint.measureText(String.valueOf(c));
            if (f <= paramFloat)
            {
              localStringBuilder.append(c);
            }
            else
            {
              j += 1;
              if (j >= paramInt)
              {
                k = j;
                break;
              }
              localStringBuilder.append("\n");
              i -= 1;
              f = 0.0F;
            }
            i += 1;
          }
          i = k;
        }
        localStringBuilder.append("\n");
        m += 1;
      }
      if (!paramString.endsWith("\n")) {
        localStringBuilder.deleteCharAt(localStringBuilder.length() - 1);
      }
      int j = localStringBuilder.length();
      paramFloat = paramPaint.measureText("…");
      if (i >= paramInt)
      {
        paramInt = j;
        while (paramInt >= 1)
        {
          i = paramInt - 1;
          if (paramPaint.measureText(localStringBuilder.substring(i, j)) >= paramFloat)
          {
            localStringBuilder.replace(i, j, "…");
            break;
          }
          paramInt -= 1;
        }
      }
      return localStringBuilder.toString();
    }
    return "";
  }
  
  /* Error */
  public static String calcMd5FromAccess(String paramString)
  {
    // Byte code:
    //   0: invokestatic 274	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   3: invokevirtual 278	com/tencent/common/app/BaseApplicationImpl:getAssets	()Landroid/content/res/AssetManager;
    //   6: aload_0
    //   7: invokevirtual 284	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   10: astore_1
    //   11: aload_1
    //   12: ifnull +45 -> 57
    //   15: aload_1
    //   16: astore_0
    //   17: aload_1
    //   18: aload_1
    //   19: invokevirtual 289	java/io/InputStream:available	()I
    //   22: i2l
    //   23: invokestatic 295	com/tencent/qphone/base/util/MD5:toMD5Byte	(Ljava/io/InputStream;J)[B
    //   26: invokestatic 301	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   29: astore_2
    //   30: aload_1
    //   31: ifnull +20 -> 51
    //   34: aload_1
    //   35: invokevirtual 304	java/io/InputStream:close	()V
    //   38: aload_2
    //   39: areturn
    //   40: astore_0
    //   41: ldc 38
    //   43: iconst_1
    //   44: aload_0
    //   45: invokevirtual 307	java/io/IOException:getMessage	()Ljava/lang/String;
    //   48: invokestatic 310	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   51: aload_2
    //   52: areturn
    //   53: astore_2
    //   54: goto +35 -> 89
    //   57: aload_1
    //   58: ifnull +51 -> 109
    //   61: aload_1
    //   62: invokevirtual 304	java/io/InputStream:close	()V
    //   65: aconst_null
    //   66: areturn
    //   67: astore_0
    //   68: ldc 38
    //   70: iconst_1
    //   71: aload_0
    //   72: invokevirtual 307	java/io/IOException:getMessage	()Ljava/lang/String;
    //   75: invokestatic 310	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   78: aconst_null
    //   79: areturn
    //   80: astore_0
    //   81: aconst_null
    //   82: astore_1
    //   83: goto +33 -> 116
    //   86: astore_2
    //   87: aconst_null
    //   88: astore_1
    //   89: aload_1
    //   90: astore_0
    //   91: ldc 38
    //   93: iconst_1
    //   94: aload_2
    //   95: invokevirtual 307	java/io/IOException:getMessage	()Ljava/lang/String;
    //   98: invokestatic 310	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   101: aload_1
    //   102: ifnull +7 -> 109
    //   105: aload_1
    //   106: invokevirtual 304	java/io/InputStream:close	()V
    //   109: aconst_null
    //   110: areturn
    //   111: astore_2
    //   112: aload_0
    //   113: astore_1
    //   114: aload_2
    //   115: astore_0
    //   116: aload_1
    //   117: ifnull +21 -> 138
    //   120: aload_1
    //   121: invokevirtual 304	java/io/InputStream:close	()V
    //   124: goto +14 -> 138
    //   127: astore_1
    //   128: ldc 38
    //   130: iconst_1
    //   131: aload_1
    //   132: invokevirtual 307	java/io/IOException:getMessage	()Ljava/lang/String;
    //   135: invokestatic 310	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   138: aload_0
    //   139: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	140	0	paramString	String
    //   10	111	1	localObject1	Object
    //   127	5	1	localIOException1	java.io.IOException
    //   29	23	2	str	String
    //   53	1	2	localIOException2	java.io.IOException
    //   86	9	2	localIOException3	java.io.IOException
    //   111	4	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   34	38	40	java/io/IOException
    //   17	30	53	java/io/IOException
    //   61	65	67	java/io/IOException
    //   105	109	67	java/io/IOException
    //   0	11	80	finally
    //   0	11	86	java/io/IOException
    //   17	30	111	finally
    //   91	101	111	finally
    //   120	124	127	java/io/IOException
  }
  
  public static void checkJsonParse(AppRuntime paramAppRuntime)
  {
    ThreadManager.getFileThreadHandler().post(new ApolloUtilImpl.10(paramAppRuntime));
  }
  
  public static boolean checkNotFullScreen()
  {
    String str = Build.MODEL;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("checkNotFullScreen model:");
      localStringBuilder.append(str);
      QLog.d("[cmshow]ApolloUtil", 2, localStringBuilder.toString());
    }
    if (android.text.TextUtils.isEmpty(str)) {
      return false;
    }
    if (!android.text.TextUtils.isEmpty(ApolloConfigUtils.jdField_a_of_type_JavaLangString)) {
      return ApolloConfigUtils.jdField_a_of_type_JavaLangString.contains(str);
    }
    return str.contains("SM-G8870");
  }
  
  public static void clearFlag()
  {
    sNewIconShowTimesLoaded = false;
    sNewIconShowTimes = 0;
    sShownNewEmoticonSize = 0;
    sPopupGuideFlagLoaded = false;
    sPopupGuideShown = false;
    EmoticonImageView.disableNewIcon(false);
    mNeedGrayTip = true;
  }
  
  public static int colorParse(String paramString)
  {
    try
    {
      if (android.text.TextUtils.isEmpty(paramString)) {
        return -1;
      }
      if (paramString.length() > 8)
      {
        paramString = paramString.substring(paramString.length() - 8, paramString.length());
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("#");
        localStringBuilder.append(paramString);
        return Color.parseColor(localStringBuilder.toString());
      }
      int i = Integer.parseInt(paramString);
      return i;
    }
    catch (Exception paramString)
    {
      QLog.e("[cmshow]ApolloUtil", 1, paramString.getMessage());
    }
    return -1;
  }
  
  private static int convertEmoticonActionId(int paramInt)
  {
    if (paramInt < 229) {
      return paramInt + 10000;
    }
    return paramInt + 20000;
  }
  
  private static int convertEmoticonActionId(ApolloDaoManagerServiceImpl paramApolloDaoManagerServiceImpl, int paramInt1, int paramInt2)
  {
    if ((paramApolloDaoManagerServiceImpl.mWhiteFaceIdMapping.size() == 0) && (paramInt2 == 1)) {
      return convertEmoticonActionId(paramInt1);
    }
    return paramApolloDaoManagerServiceImpl.getWhiteFaceIdMapping(paramInt1, paramInt2);
  }
  
  public static ApolloUserTrace.STUserTrackReq convertJson2JavaObj(String paramString)
  {
    ApolloUserTrace.STUserTrackReq localSTUserTrackReq = new ApolloUserTrace.STUserTrackReq();
    if (android.text.TextUtils.isEmpty(paramString)) {
      return localSTUserTrackReq;
    }
    for (;;)
    {
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
          localObject = paramString.getJSONObject("userTrack");
          paramString = new ApolloUserTrace.STUserClickTrack();
          paramString.name.set(((JSONObject)localObject).optString("name"));
          paramString.screenScale.set(((JSONObject)localObject).optInt("screenscale"));
          paramString.screenX.set(((JSONObject)localObject).optInt("screenwidth"));
          paramString.screenY.set(((JSONObject)localObject).optInt("screenheight"));
          paramString.time.set(((JSONObject)localObject).optInt("time"));
          if (((JSONObject)localObject).has("record"))
          {
            localObject = ((JSONObject)localObject).getJSONArray("record");
            if (localObject == null) {
              break;
            }
            if (((JSONArray)localObject).length() != 0) {
              break label569;
            }
            return localSTUserTrackReq;
            if (i < ((JSONArray)localObject).length())
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
              continue;
            }
            if (QLog.isColorLevel())
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("trace.len:");
              ((StringBuilder)localObject).append(paramString.list.size());
              QLog.d("[cmshow]ApolloUtil", 2, ((StringBuilder)localObject).toString());
            }
          }
          localSTUserTrackReq.userClick.set(paramString);
        }
        long l2 = System.currentTimeMillis();
        if (QLog.isColorLevel())
        {
          paramString = new StringBuilder();
          paramString.append("trace parsing cost:");
          paramString.append(l2 - l1);
          QLog.d("[cmshow]ApolloUtil", 2, paramString.toString());
          return localSTUserTrackReq;
        }
      }
      catch (Exception paramString)
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("errInfo->");
        ((StringBuilder)localObject).append(paramString.getMessage());
        QLog.e("[cmshow]ApolloUtil", 1, ((StringBuilder)localObject).toString());
      }
      return localSTUserTrackReq;
      label569:
      int i = 0;
    }
    return localSTUserTrackReq;
  }
  
  public static void deleteGameResIfNeed()
  {
    ThreadManager.post(new ApolloUtilImpl.5(), 5, null, true);
  }
  
  public static final int dp2px(float paramFloat1, float paramFloat2)
  {
    return (int)(paramFloat1 * paramFloat2 + 0.5F);
  }
  
  public static String encodeURL(String paramString)
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
      QLog.e("[cmshow]ApolloUtil", 1, paramString.getMessage());
    }
    return "";
  }
  
  public static void endTrace(String paramString)
  {
    if (QLog.isColorLevel())
    {
      long l = System.currentTimeMillis();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[endTrace] ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" cost:");
      localStringBuilder.append(l - sCurrentTimeStamp);
      QLog.d("[cmshow]ApolloUtil", 2, localStringBuilder.toString());
      sCurrentTimeStamp = l;
    }
  }
  
  public static void forwardImage_Common(Activity paramActivity, String paramString1, String paramString2, int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("forward_type", 1);
    if (paramString1 != null)
    {
      if (!new File(paramString1).exists()) {
        return;
      }
      String str;
      if (!android.text.TextUtils.isEmpty(paramString2))
      {
        str = paramString2;
        if (new File(paramString2).exists()) {}
      }
      else
      {
        str = ImageUtil.a(paramActivity, paramString1);
        try
        {
          if ((((ICompressOperator)QRoute.api(ICompressOperator.class)).decodeJpegByTrubo()) && (ImageUtil.c(paramString1))) {
            ((ICompressOperator)QRoute.api(ICompressOperator.class)).compressAIOThumbnailWithTrubo(paramString1, str, true, "", 0);
          } else {
            ((ICompressOperator)QRoute.api(ICompressOperator.class)).compressAIOThumbnail(paramString1, str, true, "", 0);
          }
        }
        catch (Exception paramString2)
        {
          QLog.e("[cmshow]ApolloUtil", 2, paramString2.getMessage());
        }
      }
      if (!android.text.TextUtils.isEmpty(str))
      {
        if (!new File(str).exists()) {
          return;
        }
        localBundle.putBoolean("isFromShare", true);
        localBundle.putString("forward_thumb", str);
        localBundle.putString("forward_filepath", paramString1);
        localBundle.putString("forward_extra", paramString1);
        localBundle.putBoolean("k_favorites", false);
        localBundle.putBoolean("isFromFavorites", true);
        localBundle.putInt("extra_key_from_apollo", paramInt);
        paramString1 = new Intent(paramActivity, ForwardRecentActivity.class);
        paramString1.putExtras(localBundle);
        paramActivity.startActivityForResult(paramString1, 103);
      }
    }
  }
  
  public static boolean getActionListFormMessage(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, MessageRecord paramMessageRecord, List<Integer> paramList)
  {
    boolean bool2 = false;
    if (paramMessageRecord == null) {
      return false;
    }
    if ((paramMessageRecord instanceof MessageForText))
    {
      localObject = paramMessageRecord.msg;
    }
    else
    {
      bool1 = bool2;
      if (!(paramMessageRecord instanceof MessageForLongMsg)) {
        break label329;
      }
      localObject = (MessageForLongMsg)paramMessageRecord;
      if (android.text.TextUtils.isEmpty(((MessageForLongMsg)localObject).sb2)) {
        localObject = ((MessageForLongMsg)localObject).sb;
      } else {
        localObject = ((MessageForLongMsg)localObject).sb2;
      }
    }
    int j = getWhiteFacePlayModel(paramQQAppInterface, paramMessageRecord);
    paramMessageRecord = (IApolloManagerService)paramQQAppInterface.getRuntimeService(IApolloManagerService.class, "all");
    int i;
    if (paramMessageRecord.queryApolloSwitchSet("whiteFace3D") == 1) {
      i = 1;
    } else {
      i = 0;
    }
    if ((j == 2) && (i == 0)) {
      i = 0;
    } else {
      i = 1;
    }
    if (j == 0) {
      QLog.w("[cmshow]ApolloUtil", 1, "getActionListFormMessage err user status");
    }
    ApolloDaoManagerServiceImpl localApolloDaoManagerServiceImpl = (ApolloDaoManagerServiceImpl)paramQQAppInterface.getRuntimeService(IApolloDaoManagerService.class, "all");
    Object localObject = new QQText((CharSequence)localObject, 2);
    EmoticonSpan[] arrayOfEmoticonSpan = (EmoticonSpan[])((QQText)localObject).getSpans(0, ((QQText)localObject).length(), EmoticonSpan.class);
    if ((arrayOfEmoticonSpan != null) && (arrayOfEmoticonSpan.length > 0) && (i != 0))
    {
      int k = arrayOfEmoticonSpan.length;
      i = 0;
      while (i < k)
      {
        int m = arrayOfEmoticonSpan[i].getIndex();
        if (com.tencent.mobileqq.text.TextUtils.isApolloEmoticon(m))
        {
          m = QQSysFaceUtil.convertToServer(m);
          if (m >= 0)
          {
            m = convertEmoticonActionId(localApolloDaoManagerServiceImpl, m, j);
            if (m > 0) {
              paramList.add(Integer.valueOf(m));
            }
          }
        }
        i += 1;
      }
    }
    boolean bool1 = bool2;
    if (paramList.size() == 0)
    {
      bool1 = bool2;
      if (1 == paramMessageRecord.getApolloUserStatus())
      {
        getKeywordsActionList(paramQQAppInterface, paramSessionInfo, (QQText)localObject, paramList);
        bool1 = true;
      }
    }
    label329:
    return bool1;
  }
  
  public static ArrayList<Integer> getAddedFaceList(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return null;
    }
    localArrayList = new ArrayList();
    Object localObject = BaseApplicationImpl.getContext();
    int i = 0;
    localObject = ((BaseApplication)localObject).getSharedPreferences("apollo_sp", 0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("sp_key_apollo_game_life");
    localStringBuilder.append(paramQQAppInterface.getCurrentUin());
    paramQQAppInterface = ((SharedPreferences)localObject).getString(localStringBuilder.toString(), "");
    if (!android.text.TextUtils.isEmpty(paramQQAppInterface))
    {
      paramQQAppInterface = paramQQAppInterface.split(",");
      if ((paramQQAppInterface != null) && (paramQQAppInterface.length > 0)) {
        try
        {
          int j = paramQQAppInterface.length;
          while (i < j)
          {
            localArrayList.add(Integer.valueOf(Integer.parseInt(paramQQAppInterface[i])));
            i += 1;
          }
          return localArrayList;
        }
        catch (Exception paramQQAppInterface)
        {
          QLog.e("[cmshow]ApolloUtil", 1, "[getAddedFaceList] exception=", paramQQAppInterface);
        }
      }
    }
  }
  
  public static String getApolloGameLuaPath(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder(100);
    if ((paramInt != 1) && (paramInt != 2))
    {
      localStringBuilder.append("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/game/");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(File.separator);
      localStringBuilder.append("main.js");
    }
    else
    {
      localStringBuilder.append("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/game/");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(File.separator);
      localStringBuilder.append("main.lua");
    }
    return localStringBuilder.toString();
  }
  
  public static String getApolloGameResPath(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder(100);
    localStringBuilder.append("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/game/");
    localStringBuilder.append(paramInt);
    return localStringBuilder.toString();
  }
  
  public static String getApolloId(int paramInt)
  {
    if (2 == paramInt) {
      return "friend";
    }
    return "me";
  }
  
  public static ApolloManagerServiceImpl getApolloManager()
  {
    AppRuntime localAppRuntime = ((IApolloUtil)QRoute.api(IApolloUtil.class)).getAppInterface();
    if (localAppRuntime != null) {
      return (ApolloManagerServiceImpl)localAppRuntime.getRuntimeService(IApolloManagerService.class, "all");
    }
    return null;
  }
  
  public static ApolloPanel getApolloPanel(BaseChatPie paramBaseChatPie)
  {
    if (paramBaseChatPie == null) {
      return null;
    }
    paramBaseChatPie = paramBaseChatPie.a();
    if (paramBaseChatPie == null) {
      return null;
    }
    return (ApolloPanel)paramBaseChatPie.b(21);
  }
  
  public static long getApolloPanelBattleGameLastRequestTime(AppRuntime paramAppRuntime, int paramInt)
  {
    if (paramAppRuntime == null)
    {
      QLog.e("[cmshow]ApolloUtil", 1, "[getApolloPanelBattleGameLastRequestTime] app is null!");
      return -1L;
    }
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getContext().getSharedPreferences("apollo_sp", 0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("sp_key_apollo_panel_battle_game_last_request_time");
    localStringBuilder.append(paramAppRuntime.getCurrentUin());
    localStringBuilder.append(paramInt);
    return localSharedPreferences.getLong(localStringBuilder.toString(), 0L);
  }
  
  public static long getApolloPanelBattleGameRequestInterval(AppRuntime paramAppRuntime, int paramInt)
  {
    if (paramAppRuntime == null)
    {
      QLog.e("[cmshow]ApolloUtil", 1, "[getApolloPanelBattleGameRequestInterval] app is null!");
      return -1L;
    }
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getContext().getSharedPreferences("apollo_sp", 0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("sp_key_apollo_panel_battle_game_request_interval");
    localStringBuilder.append(paramAppRuntime.getCurrentUin());
    localStringBuilder.append(paramInt);
    return localSharedPreferences.getLong(localStringBuilder.toString(), 300000L);
  }
  
  public static ApolloPanelProviderImpl getApolloPanelProvider(BaseChatPie paramBaseChatPie)
  {
    if (paramBaseChatPie == null) {
      return null;
    }
    paramBaseChatPie = paramBaseChatPie.a();
    if (paramBaseChatPie == null) {
      return null;
    }
    return (ApolloPanelProviderImpl)paramBaseChatPie.a(21);
  }
  
  public static String getAudioPathForAction(int paramInt)
  {
    Object localObject1 = CMGetResPathUtil.a(3, paramInt);
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append("music.amr");
    localObject2 = ((StringBuilder)localObject2).toString();
    if (FileUtil.b((String)localObject2))
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("[getAudioPathForAction] from root dir. actionId:");
        ((StringBuilder)localObject1).append(paramInt);
        ((StringBuilder)localObject1).append(", result:");
        ((StringBuilder)localObject1).append((String)localObject2);
        QLog.i("[cmshow]ApolloUtil", 2, ((StringBuilder)localObject1).toString());
      }
      return localObject2;
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append("action/");
    ((StringBuilder)localObject2).append("music.amr");
    localObject2 = ((StringBuilder)localObject2).toString();
    if (FileUtils.fileExists((String)localObject2))
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("[getAudioPathForAction] from action dir. actionId:");
        ((StringBuilder)localObject1).append(paramInt);
        ((StringBuilder)localObject1).append(", result:");
        ((StringBuilder)localObject1).append((String)localObject2);
        QLog.i("[cmshow]ApolloUtil", 2, ((StringBuilder)localObject1).toString());
      }
      return localObject2;
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append("action/music/");
    localObject1 = ((StringBuilder)localObject2).toString();
    if (FileUtils.fileExists((String)localObject1))
    {
      localObject2 = new File((String)localObject1).list(new ApolloUtilImpl.4());
      if ((localObject2 != null) && (localObject2.length > 0))
      {
        StringBuilder localStringBuilder;
        if (localObject2.length != 1)
        {
          Arrays.sort((Object[])localObject2);
          int i = getPositiveRandomInteger(localObject2.length);
          if ((i >= 0) && (i < localObject2.length))
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append((String)localObject1);
            localStringBuilder.append(localObject2[i]);
            localObject1 = localStringBuilder.toString();
          }
          else
          {
            localObject1 = "";
          }
        }
        else
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append((String)localObject1);
          localStringBuilder.append(localObject2[0]);
          localObject1 = localStringBuilder.toString();
        }
        if (FileUtil.b((String)localObject1))
        {
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("[getAudioPathForAction] from action/music dir. actionId:");
            ((StringBuilder)localObject2).append(paramInt);
            ((StringBuilder)localObject2).append(", result:");
            ((StringBuilder)localObject2).append((String)localObject1);
            QLog.i("[cmshow]ApolloUtil", 2, ((StringBuilder)localObject2).toString());
          }
          return localObject1;
        }
      }
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("[getAudioPathForAction] find no audio for actionId: ");
    ((StringBuilder)localObject1).append(paramInt);
    QLog.w("[cmshow]ApolloUtil", 1, ((StringBuilder)localObject1).toString());
    return "";
  }
  
  public static ChatPieApolloViewController getChatPieApolloViewController(BaseChatPie paramBaseChatPie)
  {
    if (paramBaseChatPie == null) {
      return null;
    }
    paramBaseChatPie = (IApolloAIOHelper)paramBaseChatPie.a(8);
    if (paramBaseChatPie == null) {
      return null;
    }
    return (ChatPieApolloViewController)paramBaseChatPie.getChatPieApolloViewController();
  }
  
  public static String getCrossEngineDressType(String paramString)
  {
    if (dressTypeMap == null)
    {
      dressTypeMap = new HashMap();
      dressTypeMap.put("hair", "hair");
      dressTypeMap.put("tops", "top");
      dressTypeMap.put("pants", "bottom");
      dressTypeMap.put("shoes", "foot");
      dressTypeMap.put("socks", "socks");
    }
    String str = (String)dressTypeMap.get(paramString);
    if (str == null) {
      return paramString;
    }
    return str;
  }
  
  public static String getCurrentUin()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime instanceof QQAppInterface)) {
      return ((QQAppInterface)localAppRuntime).getCurrentUin();
    }
    return localAppRuntime.getAccount();
  }
  
  public static Bitmap getDefaultGameIcon()
  {
    Drawable localDrawable = BaseApplicationImpl.getContext().getResources().getDrawable(2130838470);
    if ((localDrawable instanceof BitmapDrawable)) {
      return ((BitmapDrawable)localDrawable).getBitmap();
    }
    return null;
  }
  
  public static int getDeviceMSAALevel()
  {
    if (sMsAALevel == -2147483648) {
      sMsAALevel = BaseApplicationImpl.getApplication().getSharedPreferences("apollo_user_config", 4).getInt("MSAA_level", 0);
    }
    return sMsAALevel;
  }
  
  public static String getDisplayActionName(AppRuntime paramAppRuntime, MessageForApollo paramMessageForApollo)
  {
    Object localObject3 = null;
    Object localObject2 = null;
    Object localObject1 = localObject3;
    if (paramAppRuntime != null)
    {
      localObject1 = localObject3;
      if (paramMessageForApollo != null)
      {
        if (paramMessageForApollo.mApolloMessage == null) {
          return null;
        }
        paramAppRuntime = localObject2;
        if (paramMessageForApollo.mApolloMessage.name != null) {
          paramAppRuntime = new String(paramMessageForApollo.mApolloMessage.name);
        }
        localObject1 = paramAppRuntime;
        if (paramMessageForApollo.mApollo3DMessage != null)
        {
          localObject1 = paramAppRuntime;
          if (ApolloActionData.isAction3DModel(paramMessageForApollo.mApollo3DMessage.actionID3D)) {
            localObject1 = paramMessageForApollo.mApollo3DMessage.actionName3D;
          }
        }
      }
    }
    return localObject1;
  }
  
  public static final byte[] getFakeMsgText()
  {
    try
    {
      byte[] arrayOfByte = HardCodeUtil.a(2131700760).getBytes();
      return arrayOfByte;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("[cmshow]ApolloUtil", 1, localThrowable.getMessage());
    }
    catch (UnsupportedCharsetException localUnsupportedCharsetException)
    {
      QLog.e("[cmshow]ApolloUtil", 1, localUnsupportedCharsetException.getMessage());
    }
    return null;
  }
  
  public static File getFile(String paramString1, String paramString2)
  {
    if (!android.text.TextUtils.isEmpty(paramString1))
    {
      if (android.text.TextUtils.isEmpty(paramString2)) {
        return null;
      }
      paramString1 = new File(paramString1);
      if (!paramString1.isDirectory()) {
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
    }
    return null;
  }
  
  public static long getFirstIntegerFromStr(String paramString)
  {
    if (android.text.TextUtils.isEmpty(paramString)) {
      return 0L;
    }
    String str = paramString;
    if (paramString.contains("def/role/0/")) {
      str = matchLastIntegerStr(paramString);
    }
    paramString = new StringBuilder(8);
    int i = 0;
    int k;
    for (int j = 0; i < str.length(); j = k)
    {
      char c = str.charAt(i);
      if ((c > '/') && (c < ':'))
      {
        paramString.append(c);
        k = 1;
      }
      else
      {
        k = j;
        if (j != 0) {
          break;
        }
      }
      i += 1;
    }
    if (j != 0) {
      return Long.parseLong(paramString.toString());
    }
    return 0L;
  }
  
  public static Bitmap getGameIcon(AppInterface paramAppInterface, StartCheckParam paramStartCheckParam)
  {
    Object localObject3 = null;
    Object localObject1 = localObject3;
    if (paramStartCheckParam != null)
    {
      if (paramAppInterface == null) {
        return null;
      }
      if (paramStartCheckParam.game != null) {
        localObject1 = paramStartCheckParam.game.logoUrl;
      } else {
        localObject1 = null;
      }
      Object localObject2 = localObject1;
      if (android.text.TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject2 = String.format(Locale.getDefault(), "https://i.hudongcdn.com/%1$d/sp_main_1_1.png", new Object[] { Integer.valueOf(paramStartCheckParam.gameId) });
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/game/");
      ((StringBuilder)localObject1).append(paramStartCheckParam.gameId);
      ((StringBuilder)localObject1).append(File.separator);
      ((StringBuilder)localObject1).append("apollo_dwonload_game_icon.png");
      File localFile = new File(((StringBuilder)localObject1).toString());
      if (!localFile.exists())
      {
        localFile.getParentFile().mkdir();
        localObject1 = new DownloadTask((String)localObject2, localFile);
        ((DownloadTask)localObject1).p = false;
        ((DownloadTask)localObject1).n = true;
        ((DownloadTask)localObject1).f = "apollo_res";
        ((DownloadTask)localObject1).b = 1;
        ((DownloadTask)localObject1).q = true;
        ((DownloadTask)localObject1).r = true;
        int i = DownloaderFactory.a((DownloadTask)localObject1, paramAppInterface);
        paramAppInterface = new StringBuilder();
        paramAppInterface.append("getGameIcon onDone gameId:");
        paramAppInterface.append(paramStartCheckParam.gameId);
        paramAppInterface.append(" result:");
        paramAppInterface.append(i);
        QLog.i("[cmshow]ApolloUtil", 1, paramAppInterface.toString());
        localObject1 = localObject3;
        if (i == 0) {
          return BitmapFactory.decodeFile(localFile.getAbsolutePath());
        }
      }
      else
      {
        if (QLog.isColorLevel())
        {
          paramAppInterface = new StringBuilder();
          paramAppInterface.append("getGameIcon file exists gameId:");
          paramAppInterface.append(paramStartCheckParam.gameId);
          QLog.i("[cmshow]ApolloUtil", 1, paramAppInterface.toString());
        }
        localObject1 = BitmapFactory.decodeFile(localFile.getAbsolutePath());
      }
    }
    return localObject1;
  }
  
  public static SharedPreferences getGameResSp()
  {
    int i;
    if (BaseApplicationImpl.sProcessId != 1) {
      i = 4;
    } else {
      i = 0;
    }
    return BaseApplicationImpl.getApplication().getSharedPreferences("apollo_game_res", i);
  }
  
  public static ApolloUtilImpl.HardwareInfo getHardwareInfo()
  {
    try
    {
      if (sHardwareInfo == null) {
        sHardwareInfo = new ApolloUtilImpl.HardwareInfo();
      }
      sHardwareInfo.d = Runtime.getRuntime().freeMemory();
      sHardwareInfo.b = Runtime.getRuntime().maxMemory();
      sHardwareInfo.c = Runtime.getRuntime().totalMemory();
      ApolloUtilImpl.HardwareInfo localHardwareInfo = sHardwareInfo;
      return localHardwareInfo;
    }
    catch (Exception localException)
    {
      QLog.e("[cmshow]ApolloUtil", 1, "getHardwareInfo e:", localException);
    }
    return null;
  }
  
  public static long getJsonLongValue(String paramString1, String paramString2)
  {
    if (!android.text.TextUtils.isEmpty(paramString1))
    {
      if (android.text.TextUtils.isEmpty(paramString2)) {
        return 0L;
      }
      try
      {
        long l = new JSONObject(paramString1).optLong(paramString2);
        return l;
      }
      catch (Exception paramString1)
      {
        QLog.e("[cmshow]ApolloUtil", 2, paramString1.getMessage());
      }
    }
    return 0L;
  }
  
  public static String getJsonStrValue(String paramString1, String paramString2)
  {
    if (!android.text.TextUtils.isEmpty(paramString1))
    {
      if (android.text.TextUtils.isEmpty(paramString2)) {
        return "";
      }
      try
      {
        paramString1 = new JSONObject(paramString1).optString(paramString2);
        return paramString1;
      }
      catch (Exception paramString1)
      {
        QLog.e("[cmshow]ApolloUtil", 2, paramString1.getMessage());
      }
    }
    return "";
  }
  
  public static String getKapuPkgName()
  {
    String str2 = App3DConfig.sPackageName;
    String str1 = str2;
    if (android.text.TextUtils.isEmpty(str2)) {
      str1 = "com.tencent.kapu";
    }
    return str1;
  }
  
  private static void getKeywordsActionList(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, QQText paramQQText, List<Integer> paramList)
  {
    if (paramQQAppInterface != null)
    {
      if (paramQQText == null) {
        return;
      }
      if (!((ApolloManagerServiceImpl)paramQQAppInterface.getRuntimeService(IApolloManagerService.class, "all")).isApolloBackgroundActionSwitchOpen()) {
        return;
      }
      long l1 = System.currentTimeMillis();
      paramQQText = paramQQText.trim();
      Object localObject = (ApolloDaoManagerServiceImpl)paramQQAppInterface.getRuntimeService(IApolloDaoManagerService.class, "all");
      HashMap localHashMap = ((ApolloDaoManagerServiceImpl)localObject).getActionKeywordsMap();
      if (localHashMap != null)
      {
        if (localHashMap.size() == 0) {
          return;
        }
        int i1 = ((ApolloDaoManagerServiceImpl)localObject).getMaxKeywordsLength();
        int i = 0;
        int n;
        for (int j = 0; i < paramQQText.length(); j = n)
        {
          int k = i1;
          int m;
          for (;;)
          {
            m = i;
            n = j;
            if (k <= 0) {
              break;
            }
            m = i + k;
            if (m <= paramQQText.length())
            {
              localObject = paramQQText.substring(i, m);
              if (localHashMap.containsKey(localObject))
              {
                paramList.add(localHashMap.get(localObject));
                n = j + 1;
                m = i + (k - 1);
                reportKeywordsAction(((Integer)localHashMap.get(localObject)).intValue(), (String)localObject, paramQQAppInterface, paramSessionInfo);
                break;
              }
            }
            k -= 1;
          }
          if (n == 30) {
            break;
          }
          i = m + 1;
        }
        long l2 = System.currentTimeMillis();
        if (QLog.isColorLevel()) {
          QLog.d("[cmshow]ApolloUtil", 2, new Object[] { "getKeywordsActionList costTime:", Long.valueOf(l2 - l1), ", actionList:", paramList, ", actionCount:", Integer.valueOf(paramList.size()) });
        }
      }
    }
  }
  
  private static int getLineCount(float paramFloat, String paramString, int paramInt1, int paramInt2)
  {
    Object localObject = new TextView(BaseApplicationImpl.getContext());
    ((TextView)localObject).setTextSize(paramInt1 * 3 / DeviceInfoUtil.a);
    ((TextView)localObject).setText(paramString);
    localObject = ((TextView)localObject).getPaint();
    paramString = paramString.replaceAll("\r", "").split("\n");
    int n = paramString.length;
    int k = 0;
    paramInt1 = 0;
    while (k < n)
    {
      String str = paramString[k];
      if (((Paint)localObject).measureText(str) > paramFloat)
      {
        paramInt1 = 0;
        float f1 = 0.0F;
        int j;
        for (int i = 0;; i = j)
        {
          j = i;
          if (paramInt1 == str.length()) {
            break;
          }
          float f2 = f1 + ((Paint)localObject).measureText(String.valueOf(str.charAt(paramInt1)));
          int m = paramInt1;
          f1 = f2;
          j = i;
          if (f2 > paramFloat)
          {
            j = i + 1;
            if (j >= paramInt2) {
              break;
            }
            m = paramInt1 - 1;
            f1 = 0.0F;
          }
          paramInt1 = m + 1;
        }
        paramInt1 = j;
      }
      k += 1;
    }
    return paramInt1;
  }
  
  private static String getNewIconShowFlagKey()
  {
    if (SystemEmoticonInfo.sNewApolloEmoticonMap.containsKey("8.7.0"))
    {
      Object localObject = (List)SystemEmoticonInfo.sNewApolloEmoticonMap.get("8.7.0");
      if ((localObject != null) && (((List)localObject).size() > 0))
      {
        String str = ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getCurrentAccountUin();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("new_icon_show_times_");
        localStringBuilder.append(str);
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          int i = ((Integer)((Iterator)localObject).next()).intValue();
          localStringBuilder.append("_");
          localStringBuilder.append(i);
        }
        return localStringBuilder.toString();
      }
    }
    return null;
  }
  
  public static int getPlayActionId(ISpriteContext paramISpriteContext, MessageForApollo paramMessageForApollo)
  {
    if ((paramMessageForApollo != null) && (paramMessageForApollo.mApolloMessage != null))
    {
      int j = paramMessageForApollo.mApolloMessage.id;
      AppRuntime localAppRuntime = ((IApolloUtil)QRoute.api(IApolloUtil.class)).getAppInterface();
      int i = j;
      if (localAppRuntime != null)
      {
        i = j;
        if (paramMessageForApollo.mApollo3DMessage != null)
        {
          i = j;
          if (ApolloActionData.isAction3DModel(paramMessageForApollo.mApollo3DMessage.actionID3D)) {
            if (!((IApolloManagerService)localAppRuntime.getRuntimeService(IApolloManagerService.class, "all")).is3dAvailable())
            {
              i = j;
              if (!paramISpriteContext.d()) {}
            }
            else
            {
              i = paramMessageForApollo.mApollo3DMessage.actionID3D;
            }
          }
        }
      }
      return i;
    }
    throw new IllegalArgumentException("getPlayActionId, apolloMsg null");
  }
  
  public static int getPlayActionType(ISpriteContext paramISpriteContext, MessageForApollo paramMessageForApollo)
  {
    if ((paramMessageForApollo != null) && (paramMessageForApollo.mApolloMessage != null))
    {
      AppRuntime localAppRuntime = ((IApolloUtil)QRoute.api(IApolloUtil.class)).getAppInterface();
      int j = paramMessageForApollo.actionType;
      int i = j;
      if (localAppRuntime != null)
      {
        i = j;
        if (paramMessageForApollo.mApollo3DMessage != null)
        {
          i = j;
          if (ApolloActionData.isAction3DModel(paramMessageForApollo.mApollo3DMessage.actionID3D)) {
            if ((!((IApolloManagerService)localAppRuntime.getRuntimeService(IApolloManagerService.class, "all")).is3dAvailable()) && (!paramISpriteContext.d()))
            {
              paramISpriteContext = ((ApolloDaoManagerServiceImpl)localAppRuntime.getRuntimeService(IApolloDaoManagerService.class, "all")).findActionById(paramMessageForApollo.mApolloMessage.id);
              i = j;
              if (paramISpriteContext != null) {
                return paramISpriteContext.actionType;
              }
            }
            else
            {
              i = paramMessageForApollo.mApollo3DMessage.actionType3D;
            }
          }
        }
      }
      return i;
    }
    throw new IllegalArgumentException("getPlayActionType, apolloMsg null");
  }
  
  private static String getPopupShowFlagKey()
  {
    if (SystemEmoticonInfo.sNewApolloEmoticonMap.containsKey("8.7.0"))
    {
      Object localObject = (List)SystemEmoticonInfo.sNewApolloEmoticonMap.get("8.7.0");
      if ((localObject != null) && (((List)localObject).size() > 0))
      {
        String str = ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getCurrentAccountUin();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("new_emoticon_popup_");
        localStringBuilder.append(str);
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          int i = ((Integer)((Iterator)localObject).next()).intValue();
          localStringBuilder.append("_");
          localStringBuilder.append(i);
        }
        return localStringBuilder.toString();
      }
    }
    return null;
  }
  
  public static int getPositiveRandomInteger(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < 2147483647)) {
      return new Random().nextInt(paramInt);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[getRandomInteger] invalid ");
    localStringBuilder.append(paramInt);
    QLog.e("[cmshow]ApolloUtil", 1, localStringBuilder.toString());
    return 0;
  }
  
  public static int getQAioType(int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 4)
      {
        if (paramInt != 5) {
          return paramInt;
        }
        return 3000;
      }
      return 1;
    }
    return 0;
  }
  
  public static QQAppInterface getQQApp()
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
  
  public static String getRobotOpenId(MessageForApollo paramMessageForApollo)
  {
    if (paramMessageForApollo == null) {
      return null;
    }
    if (!android.text.TextUtils.isEmpty(paramMessageForApollo.extendJson)) {
      try
      {
        paramMessageForApollo = new JSONObject(paramMessageForApollo.extendJson).optString("robotOpenId");
        return paramMessageForApollo;
      }
      catch (Exception paramMessageForApollo)
      {
        QLog.e("[cmshow]ApolloUtil", 1, paramMessageForApollo, new Object[0]);
      }
    }
    return null;
  }
  
  public static int getShareMsgActionId(QQAppInterface paramQQAppInterface, MessageForArkApp paramMessageForArkApp)
  {
    if (paramMessageForArkApp != null)
    {
      if (paramQQAppInterface == null) {
        return 0;
      }
      paramMessageForArkApp = paramMessageForArkApp.ark_app_message;
      if ((!android.text.TextUtils.isEmpty(paramMessageForArkApp.appId)) && (!"101538890".equals(paramMessageForArkApp.appId))) {
        return 0;
      }
      paramMessageForArkApp = paramMessageForArkApp.metaList;
      if (paramMessageForArkApp == null) {
        return 0;
      }
      int i;
      try
      {
        paramMessageForArkApp = new JSONObject(paramMessageForArkApp).optJSONObject("data");
        if (paramMessageForArkApp != null) {
          i = paramMessageForArkApp.optInt("actionId");
        } else {
          i = 0;
        }
        j = i;
        try
        {
          if (i <= ApolloConstant.jdField_a_of_type_Int) {
            break label166;
          }
          j = i;
          if (((IApolloManagerService)paramQQAppInterface.getRuntimeService(IApolloManagerService.class, "all")).is3dAvailable()) {
            break label166;
          }
          if (QLog.isColorLevel()) {
            QLog.d("[cmshow]ApolloUtil", 2, new Object[] { "getShareMsgActionId 3d not available actionId:", Integer.valueOf(i) });
          }
          return 0;
        }
        catch (Exception paramQQAppInterface) {}
        QLog.e("[cmshow]ApolloUtil", 1, paramQQAppInterface, new Object[0]);
      }
      catch (Exception paramQQAppInterface)
      {
        i = 0;
      }
      int j = i;
      label166:
      return j;
    }
    return 0;
  }
  
  public static int getSpriteSpanExtKey(int paramInt)
  {
    int j = 1;
    if ((paramInt >= 500) && (paramInt < 600)) {
      return 1;
    }
    if ((paramInt >= 600) && (paramInt < 700)) {
      return 2;
    }
    int i;
    if (paramInt >= 700) {
      i = 1;
    } else {
      i = 0;
    }
    if (paramInt < 800) {
      paramInt = j;
    } else {
      paramInt = 0;
    }
    if ((i & paramInt) != 0) {
      return 3;
    }
    return 0;
  }
  
  public static float getSurfaceScale(float paramFloat)
  {
    long l = DeviceInfoUtil.j();
    if (Float.compare(0.0F, paramFloat) == 0) {
      return (float)(l / 5L) / 368.0F;
    }
    return (float)l * paramFloat / 368.0F;
  }
  
  public static String getTodayKey()
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
  
  public static int getTraceResourceExtKey(String paramString)
  {
    if (android.text.TextUtils.isEmpty(paramString)) {
      return 0;
    }
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
    if (paramString.contains("vipApollo_drawerAction_")) {
      return 18;
    }
    return 0;
  }
  
  public static String getUinFromApolloId(String paramString)
  {
    Object localObject = paramString;
    if (!android.text.TextUtils.isEmpty(paramString))
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
  
  public static int getWhiteFacePlayModel(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord)
  {
    if (paramQQAppInterface != null)
    {
      if (paramMessageRecord == null) {
        return 0;
      }
      paramQQAppInterface = (IApolloManagerService)paramQQAppInterface.getRuntimeService(IApolloManagerService.class, "all");
      int i = paramQQAppInterface.getApolloUserStatus();
      if (i == 0) {
        return 0;
      }
      int j = paramQQAppInterface.getCmShowStatus(paramMessageRecord.senderuin);
      if (((j == 2) && (paramQQAppInterface.is3dAvailable())) || ((j == 0) && (i == 2))) {
        return 2;
      }
      return 1;
    }
    return 0;
  }
  
  public static int handleAITextType(float paramFloat, String paramString)
  {
    boolean bool = android.text.TextUtils.isEmpty(paramString);
    int i = 43;
    if (!bool)
    {
      if (paramFloat <= 0.0F) {
        return 43;
      }
      i = getLineCount(paramFloat, paramString, 8, 6);
      if (i == 0) {
        return 41;
      }
      if (i == 1) {
        return 42;
      }
      if (i == 2) {
        return 43;
      }
      if (i == 3) {
        return 44;
      }
      if (i == 4) {
        return 45;
      }
      i = 46;
    }
    return i;
  }
  
  public static void handleApolloNoCatchCrash(boolean paramBoolean, String paramString1, String paramString2)
  {
    if (android.text.TextUtils.isEmpty(paramString2)) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    TraceReportUtil.a(20);
    int i;
    if (paramBoolean)
    {
      if (!android.text.TextUtils.isEmpty(ApolloRender.sNativeVersion))
      {
        localStringBuilder.append("SO_VERSION:");
        localStringBuilder.append(ApolloRender.sNativeVersion);
        localStringBuilder.append(",");
      }
      i = 40;
      if (System.currentTimeMillis() - ApolloTextureView.sReAttachTime < 30000L) {
        i = 41;
      }
    }
    else
    {
      i = 30;
      if (paramString1.contains("NullPointerException")) {
        i = 31;
      }
    }
    localStringBuilder.append("crashType=");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(", crashStack=");
    localStringBuilder.append(paramString2);
    TraceReportUtil.a(20, 1, i, new Object[] { localStringBuilder.toString() });
  }
  
  public static int handleBubbleType(float paramFloat, String paramString, int paramInt)
  {
    if (!android.text.TextUtils.isEmpty(paramString))
    {
      if (paramFloat <= 0.0F) {
        return 24;
      }
      int i = getLineCount(paramFloat, paramString, 17, 3);
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
      if (paramInt == 2) {
        return 73;
      }
      return 24;
    }
    return 24;
  }
  
  public static boolean isAllowDisplayGame(AppRuntime paramAppRuntime, MessageForApollo paramMessageForApollo)
  {
    if (paramMessageForApollo != null)
    {
      if (paramAppRuntime == null) {
        return false;
      }
      Object localObject1 = (ApolloDaoManagerServiceImpl)paramAppRuntime.getRuntimeService(IApolloDaoManagerService.class, "all");
      boolean bool = ApolloGameUtil.a(paramMessageForApollo.msgType);
      Object localObject2 = null;
      if (bool) {
        localObject1 = ((ApolloDaoManagerServiceImpl)localObject1).findGameById(paramMessageForApollo.gameId);
      } else {
        localObject1 = null;
      }
      IApolloManagerService localIApolloManagerService = (IApolloManagerService)paramAppRuntime.getRuntimeService(IApolloManagerService.class, "all");
      if ((localIApolloManagerService.queryApolloSwitchSet("gameSwitch") == 1) && ((localObject1 == null) || (VersionUtil.a("8.7.0", ((ApolloGameData)localObject1).minVer, ((ApolloGameData)localObject1).maxVer))))
      {
        if (paramAppRuntime.getApp() == null) {
          paramAppRuntime = localObject2;
        } else {
          paramAppRuntime = paramAppRuntime.getApp().getApplicationContext();
        }
        return (!localIApolloManagerService.isApolloSupport(paramAppRuntime)) || (paramMessageForApollo.istroop != 3000) || (localIApolloManagerService.queryApolloSwitchSet("discuss") != 0);
      }
      if (QLog.isColorLevel()) {
        QLog.d("[cmshow]ApolloUtil", 2, "play apollo game msg but switch is 0 or version is incorrect");
      }
    }
    return false;
  }
  
  public static boolean isApollo3DUser(AppRuntime paramAppRuntime)
  {
    return ApolloGameUtil.a(paramAppRuntime) == 2;
  }
  
  public static boolean isApolloAnimationBubble(int paramInt)
  {
    return paramInt == 10;
  }
  
  public static boolean isApolloPanelCacheExpired(AppRuntime paramAppRuntime, int paramInt)
  {
    long l1 = getApolloPanelBattleGameLastRequestTime(paramAppRuntime, paramInt);
    long l2 = getApolloPanelBattleGameRequestInterval(paramAppRuntime, paramInt);
    long l3 = System.currentTimeMillis();
    boolean bool;
    if (l3 > l1 + l2) {
      bool = true;
    } else {
      bool = false;
    }
    paramAppRuntime = new StringBuilder();
    paramAppRuntime.append("[isApolloPanelCacheExpired] ");
    paramAppRuntime.append(bool);
    paramAppRuntime.append(", currentTime: ");
    paramAppRuntime.append(l3);
    paramAppRuntime.append(", battleGameLastRequestTime: ");
    paramAppRuntime.append(l1);
    paramAppRuntime.append(", battleGameRequestInterval: ");
    paramAppRuntime.append(l2);
    QLog.d("[cmshow]ApolloUtil", 1, new Object[] { paramAppRuntime });
    return bool;
  }
  
  public static boolean isApolloStatusOpen(ApolloBaseInfo paramApolloBaseInfo)
  {
    boolean bool = false;
    if (paramApolloBaseInfo == null) {
      return false;
    }
    if (paramApolloBaseInfo.apolloStatus == 1) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean isApolloUser(AppRuntime paramAppRuntime)
  {
    if (paramAppRuntime == null) {
      return false;
    }
    if (!((ApolloManagerServiceImpl)paramAppRuntime.getRuntimeService(IApolloManagerService.class, "all")).isApolloSupport(paramAppRuntime.getApplication())) {
      return false;
    }
    paramAppRuntime = ((ApolloDaoManagerServiceImpl)paramAppRuntime.getRuntimeService(IApolloDaoManagerService.class, "all")).getApolloBaseInfoFromCache(paramAppRuntime.getCurrentUin());
    return (paramAppRuntime == null) || (paramAppRuntime.isApolloStatusOpen());
  }
  
  public static boolean isBubbleRscExist(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("[isBubbleRscExist], roleId:");
      ((StringBuilder)localObject1).append(paramInt1);
      ((StringBuilder)localObject1).append(",bubbleId:");
      ((StringBuilder)localObject1).append(paramInt2);
      QLog.d("[cmshow]ApolloUtil", 2, ((StringBuilder)localObject1).toString());
    }
    if (paramInt1 == 0)
    {
      localObject1 = ApolloConstant.jdField_a_of_type_JavaLangString;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("/def/role/");
      ((StringBuilder)localObject2).append(paramInt1);
      localObject1 = new File((String)localObject1, ((StringBuilder)localObject2).toString());
    }
    else
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/role/");
      ((StringBuilder)localObject1).append(paramInt1);
      localObject1 = new File(((StringBuilder)localObject1).toString());
    }
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("Bubble/");
    ((StringBuilder)localObject2).append(paramInt2);
    Object localObject1 = new File((File)localObject1, ((StringBuilder)localObject2).toString());
    if (!((File)localObject1).exists())
    {
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("dir NOT exist.");
        ((StringBuilder)localObject2).append(((File)localObject1).getPath());
        QLog.d("[cmshow]ApolloUtil", 2, ((StringBuilder)localObject2).toString());
      }
      return false;
    }
    localObject2 = new File((File)localObject1, "dress.json");
    if (!((File)localObject2).exists())
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("BUBBLE_FILE_ATLAS_NAME NOT exist. ");
        ((StringBuilder)localObject1).append(((File)localObject2).getPath());
        QLog.d("[cmshow]ApolloUtil", 2, ((StringBuilder)localObject1).toString());
      }
      return false;
    }
    if (((File)localObject2).length() == 0L)
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("ErrorInfo-> ");
        ((StringBuilder)localObject1).append(((File)localObject2).getPath());
        ((StringBuilder)localObject1).append(",lenght is 0.");
        QLog.d("[cmshow]ApolloUtil", 2, ((StringBuilder)localObject1).toString());
      }
      ((File)localObject2).delete();
      return false;
    }
    localObject2 = new File((File)localObject1, "dress.atlas");
    if (!((File)localObject2).exists())
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("BUBBLE_FILE_ATLAS_NAME NOT exist.");
        ((StringBuilder)localObject1).append(((File)localObject2).getPath());
        QLog.d("[cmshow]ApolloUtil", 2, ((StringBuilder)localObject1).toString());
      }
      return false;
    }
    if (((File)localObject2).length() == 0L)
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("ErrorInfo-> ");
        ((StringBuilder)localObject1).append(((File)localObject2).getPath());
        ((StringBuilder)localObject1).append(",lenght is 0.");
        QLog.d("[cmshow]ApolloUtil", 2, ((StringBuilder)localObject1).toString());
      }
      ((File)localObject2).delete();
      return false;
    }
    localObject1 = new File((File)localObject1, "dress.png");
    if (!((File)localObject1).exists())
    {
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("BUBBLE_FILE_PNG_NAME NOT exist.");
        ((StringBuilder)localObject2).append(((File)localObject1).getPath());
        QLog.d("[cmshow]ApolloUtil", 2, ((StringBuilder)localObject2).toString());
      }
      return false;
    }
    if (((File)localObject1).length() == 0L)
    {
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("ErrorInfo-> ");
        ((StringBuilder)localObject2).append(((File)localObject1).getPath());
        ((StringBuilder)localObject2).append(",lenght is 0.");
        QLog.d("[cmshow]ApolloUtil", 2, ((StringBuilder)localObject2).toString());
      }
      ((File)localObject1).delete();
      return false;
    }
    return true;
  }
  
  public static boolean isNewApolloEmotion(int paramInt)
  {
    if (SystemEmoticonInfo.sNewApolloEmoticonMap.containsKey("8.7.0"))
    {
      Object localObject = (List)SystemEmoticonInfo.sNewApolloEmoticonMap.get("8.7.0");
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
  
  public static boolean isNickBubbleRscExist(int paramInt1, int paramInt2)
  {
    boolean bool = false;
    if ((isBubbleRscExist(0, paramInt2)) || (isBubbleRscExist(paramInt1, paramInt2))) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean isResExist(ApolloActionData paramApolloActionData, int paramInt)
  {
    if (paramApolloActionData == null) {
      return false;
    }
    if ((paramInt & 0x1) == 1) {
      paramApolloActionData = CMGetResPathUtil.a(paramApolloActionData, 0);
    } else if ((paramInt & 0x2) == 2) {
      paramApolloActionData = CMGetResPathUtil.a(paramApolloActionData, 2);
    } else {
      paramApolloActionData = "";
    }
    return FileUtil.b(paramApolloActionData);
  }
  
  public static boolean isSameDress(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    if ((paramArrayOfInt1 != null) && (paramArrayOfInt2 != null) && (paramArrayOfInt1.length == paramArrayOfInt2.length))
    {
      int i = 0;
      for (;;)
      {
        int j = paramArrayOfInt1.length;
        int k = 1;
        if (i >= j) {
          break;
        }
        j = 0;
        while (j < paramArrayOfInt2.length)
        {
          if (paramArrayOfInt1[i] == paramArrayOfInt2[j])
          {
            j = k;
            break label60;
          }
          j += 1;
        }
        j = 0;
        label60:
        if (j == 0) {
          return false;
        }
        i += 1;
      }
      return true;
    }
    return false;
  }
  
  public static boolean isTabExist(ApolloActionPackage paramApolloActionPackage)
  {
    if (paramApolloActionPackage == null) {
      return false;
    }
    return FileUtil.b(CMGetResPathUtil.a(paramApolloActionPackage));
  }
  
  public static boolean isValideToDoAction(long paramLong1, long paramLong2)
  {
    return Math.abs(paramLong2 - paramLong1) > 500L;
  }
  
  public static void jumpToH5PreviewAction(Activity paramActivity, String paramString1, String paramString2)
  {
    QZoneVipInfoManager.b(paramActivity, paramString1, paramString2);
  }
  
  public static void launchGameDetailView(int paramInt, String paramString, Activity paramActivity)
  {
    JSONObject localJSONObject1 = new JSONObject();
    try
    {
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("CMShow.GameId", String.valueOf(paramInt));
      localJSONObject2.put("extraInfo", paramString);
      localJSONObject1.put("CMShow.Game", localJSONObject2);
    }
    catch (Exception paramString)
    {
      QLog.e("[cmshow]ApolloUtil", 1, "[launchGameDetailView] error:", paramString);
    }
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("[launchGameDetailView] mate:");
      paramString.append(localJSONObject1.toString());
      QLog.d("[cmshow]ApolloUtil", 2, paramString.toString());
    }
    ArkFullScreenAppActivity.a(paramActivity, "com.tencent.cmgame.intent", "GameCard", localJSONObject1.toString());
  }
  
  public static String logFilter(String paramString)
  {
    if (paramString == null) {
      return "";
    }
    if (paramString.length() <= 2048) {
      return paramString;
    }
    return paramString.substring(0, 2048);
  }
  
  private static String matchLastIntegerStr(String paramString)
  {
    Matcher localMatcher = Pattern.compile("/\\d+/").matcher(paramString);
    for (paramString = ""; localMatcher.find(); paramString = localMatcher.group()) {}
    return paramString;
  }
  
  public static void mergeJSON(JSONObject paramJSONObject1, JSONObject paramJSONObject2)
  {
    if (paramJSONObject1 != null)
    {
      if (paramJSONObject2 == null) {
        return;
      }
      Iterator localIterator = paramJSONObject2.keys();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        try
        {
          paramJSONObject1.put(str, paramJSONObject2.get(str));
        }
        catch (Exception localException)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("mergeJSONData error!  msg=");
          localStringBuilder.append(localException);
          QLog.d("[cmshow]ApolloUtil", 1, localStringBuilder.toString());
        }
      }
    }
  }
  
  public static void openCollectCard(Context paramContext, String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(ApolloConstant.t);
    localStringBuilder.append(paramString1);
    localStringBuilder.append("&adtag=");
    localStringBuilder.append(paramString2);
    paramString1 = new Intent(paramContext, QQBrowserActivity.class);
    paramString1.putExtra("big_brother_source_key", "biz_src_zf_lmx");
    VasWebviewUtil.a(paramContext, localStringBuilder.toString(), -1L, paramString1, false, -1);
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]ApolloUtil", 2, new Object[] { "openCollectCard:", localStringBuilder.toString() });
    }
  }
  
  public static void openStoreByTabScheme(QQAppInterface paramQQAppInterface, Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    if ((paramQQAppInterface != null) && (paramContext != null))
    {
      IApolloUtil localIApolloUtil = (IApolloUtil)QRoute.api(IApolloUtil.class);
      String str = localIApolloUtil.getStoreTabUrl(paramString1, true);
      if (!android.text.TextUtils.isEmpty(str))
      {
        paramString2 = new Intent();
        if ("interact".equals(paramString1))
        {
          paramString1 = new StringBuilder();
          paramString1.append("&tab=interactive&suin=");
          paramString1.append(paramQQAppInterface.getCurrentAccountUin());
          paramString2.putExtra("extra_key_url_append", paramString1.toString());
        }
        localIApolloUtil.openApolloStore(paramContext, paramString2, paramString3, str, null);
        return;
      }
      if (!android.text.TextUtils.isEmpty(paramString2))
      {
        paramQQAppInterface = new Intent(paramContext, QQBrowserActivity.class);
        paramQQAppInterface.putExtra("url", paramString2);
        paramQQAppInterface.putExtra("startOpenPageTime", System.currentTimeMillis());
        paramContext.startActivity(paramQQAppInterface);
        return;
      }
      QLog.w("[cmshow]ApolloUtil", 1, "openStoreByTabScheme params is error");
      return;
    }
    QLog.e("[cmshow]ApolloUtil", 1, "openStoreByTabScheme context is null");
  }
  
  public static void openVipPage(Context paramContext)
  {
    VasH5PayUtil.a(paramContext, "mvip.c.a.cs_limix", 3, "1450000515", "CJCLUBT", paramContext.getString(2131719393), "", false, true);
  }
  
  public static void openYellowPage(Activity paramActivity, String paramString1, String paramString2)
  {
    QZoneVipInfoManager.a(paramActivity, paramString1, paramString2);
  }
  
  public static int parseToInt(String paramString)
  {
    try
    {
      if (!android.text.TextUtils.isEmpty(paramString))
      {
        int i = Integer.parseInt(paramString);
        return i;
      }
    }
    catch (Exception paramString)
    {
      QLog.e("[cmshow]ApolloUtil", 1, paramString, new Object[0]);
    }
    return 0;
  }
  
  public static long parseToLong(String paramString)
  {
    try
    {
      if (!android.text.TextUtils.isEmpty(paramString))
      {
        long l = Long.parseLong(paramString);
        return l;
      }
    }
    catch (Exception paramString)
    {
      QLog.e("[cmshow]ApolloUtil", 1, paramString, new Object[0]);
    }
    return 0L;
  }
  
  private static void reportKeywordsAction(int paramInt, String paramString, QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    if ((paramQQAppInterface != null) && (paramSessionInfo != null)) {
      VipUtils.a(paramQQAppInterface, "cmshow", "Apollo", "eggaction", ((IApolloUtil)QRoute.api(IApolloUtil.class)).getReportSessiontype(paramSessionInfo.jdField_a_of_type_Int), 0, new String[] { String.valueOf(paramInt), paramString });
    }
  }
  
  public static void saveAddedFaceList(QQAppInterface paramQQAppInterface, ArrayList<Integer> paramArrayList)
  {
    if ((paramQQAppInterface != null) && (paramArrayList != null))
    {
      if (paramArrayList.size() == 0) {
        return;
      }
      StringBuilder localStringBuilder1 = new StringBuilder();
      int j = paramArrayList.size();
      int i = 0;
      while (i < j)
      {
        localStringBuilder1.append(paramArrayList.get(i));
        if (i != j - 1) {
          localStringBuilder1.append(",");
        }
        i += 1;
      }
      paramArrayList = BaseApplicationImpl.getContext().getSharedPreferences("apollo_sp", 0).edit();
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("sp_key_apollo_game_life");
      localStringBuilder2.append(paramQQAppInterface.getCurrentUin());
      paramArrayList.putString(localStringBuilder2.toString(), localStringBuilder1.toString()).commit();
    }
  }
  
  public static void saveApolloPanelBattleGameLastRequestTime(AppRuntime paramAppRuntime, int paramInt, long paramLong)
  {
    if (paramAppRuntime == null)
    {
      QLog.e("[cmshow]ApolloUtil", 1, "[saveApolloPanelBattleGameLastRequestTime] app is null!");
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[saveApolloPanelBattleGameLastRequestTime] ");
      ((StringBuilder)localObject).append(paramLong);
      QLog.d("[cmshow]ApolloUtil", 1, ((StringBuilder)localObject).toString());
    }
    Object localObject = BaseApplicationImpl.getContext().getSharedPreferences("apollo_sp", 0).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("sp_key_apollo_panel_battle_game_last_request_time");
    localStringBuilder.append(paramAppRuntime.getCurrentUin());
    localStringBuilder.append(paramInt);
    ((SharedPreferences.Editor)localObject).putLong(localStringBuilder.toString(), paramLong).commit();
  }
  
  public static void saveApolloPanelBattleGameRequestInterval(AppInterface paramAppInterface, int paramInt, long paramLong)
  {
    if (paramAppInterface == null)
    {
      QLog.e("[cmshow]ApolloUtil", 1, "[saveApolloPanelBattleGameRequestInterval] app is null!");
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[saveApolloPanelBattleGameRequestInterval] ");
      ((StringBuilder)localObject).append(paramLong);
      QLog.d("[cmshow]ApolloUtil", 1, ((StringBuilder)localObject).toString());
    }
    Object localObject = BaseApplicationImpl.getContext().getSharedPreferences("apollo_sp", 0).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("sp_key_apollo_panel_battle_game_request_interval");
    localStringBuilder.append(paramAppInterface.getCurrentUin());
    localStringBuilder.append(paramInt);
    ((SharedPreferences.Editor)localObject).putLong(localStringBuilder.toString(), paramLong).commit();
  }
  
  public static void saveDeviceMSAALevel(int paramInt)
  {
    sMsAALevel = paramInt;
    BaseApplicationImpl.getApplication().getSharedPreferences("apollo_user_config", 4).edit().putInt("MSAA_level", paramInt).commit();
  }
  
  public static void setApolloLv(ImageView paramImageView, int paramInt)
  {
    if (paramImageView == null) {
      return;
    }
    paramImageView.setImageResource(2130838577);
  }
  
  public static void setApolloVipIcon(ImageView paramImageView, boolean paramBoolean1, boolean paramBoolean2)
  {
    paramImageView.setImageResource(2130838537);
  }
  
  public static void setBackgroundSafety(View paramView, int paramInt)
  {
    if (paramView == null) {
      return;
    }
    try
    {
      paramView.setBackgroundResource(paramInt);
      return;
    }
    catch (Exception|OutOfMemoryError paramView) {}
  }
  
  public static void showDebugTipsToast(String paramString) {}
  
  public static void showTipsToast(String paramString)
  {
    ThreadManager.getUIHandler().post(new ApolloUtilImpl.8(paramString));
  }
  
  public static ArrayList sparseArrayToList(SparseArray paramSparseArray)
  {
    if ((paramSparseArray != null) && (paramSparseArray.size() != 0))
    {
      ArrayList localArrayList = new ArrayList();
      int j = paramSparseArray.size();
      int i = 0;
      while (i < j)
      {
        localArrayList.add(paramSparseArray.get(paramSparseArray.keyAt(i)));
        i += 1;
      }
      return localArrayList;
    }
    return new ArrayList();
  }
  
  public static ApolloBattleGameInfo stBoxItem2ApolloBattleGameInfo(int paramInt, OpenGameBox.StBoxItem paramStBoxItem)
  {
    if (paramStBoxItem == null) {
      return null;
    }
    ApolloBattleGameInfo localApolloBattleGameInfo = new ApolloBattleGameInfo();
    localApolloBattleGameInfo.sceneId = paramInt;
    localApolloBattleGameInfo.appid = paramStBoxItem.appid.get();
    localApolloBattleGameInfo.avatar = paramStBoxItem.avatar.get();
    localApolloBattleGameInfo.name = paramStBoxItem.name.get();
    localApolloBattleGameInfo.gamerRange = paramStBoxItem.gamer_range.get();
    localApolloBattleGameInfo.background = paramStBoxItem.background.get();
    localApolloBattleGameInfo.footerIcon = paramStBoxItem.footer_icon.get();
    localApolloBattleGameInfo.adId = paramStBoxItem.ad_id.get();
    localApolloBattleGameInfo.boxType = paramStBoxItem.box_type.get();
    localApolloBattleGameInfo.hallJumpUrl = paramStBoxItem.hall_jump_url.get();
    return localApolloBattleGameInfo;
  }
  
  public static int transStype2Rtype(int paramInt)
  {
    if (paramInt == 1) {
      return 3;
    }
    if (paramInt == 4) {
      return 1;
    }
    int i = paramInt;
    if (paramInt == 5) {
      i = 2;
    }
    return i;
  }
  
  public static void updateObtainedAction(ApolloActionData paramApolloActionData, Bundle paramBundle)
  {
    int i = paramBundle.getInt("way");
    if (i == 1) {
      paramApolloActionData.feeType = 6;
    } else if (i == 2) {
      paramApolloActionData.feeType = 7;
    } else if (i == 4) {
      paramApolloActionData.feeType = 2;
    }
    if (i == 6)
    {
      paramApolloActionData.limitFree = 1;
      paramApolloActionData.limitStart = paramBundle.getLong("beginTs");
      paramApolloActionData.limitEnd = paramBundle.getLong("endts");
      return;
    }
    paramApolloActionData.limitFree = 0;
    paramApolloActionData.obtainedTime = paramBundle.getLong("beginTs");
  }
  
  public static boolean verifyActionPackageVersion(ApolloActionPackage paramApolloActionPackage, String paramString)
  {
    if (paramApolloActionPackage == null) {
      return false;
    }
    return (android.text.TextUtils.isEmpty(paramApolloActionPackage.startVersion)) || (android.text.TextUtils.isEmpty(paramApolloActionPackage.endVersion)) || (VersionUtil.a(paramString, paramApolloActionPackage.startVersion, paramApolloActionPackage.endVersion));
  }
  
  public static boolean verifyActionVersion(ApolloActionData paramApolloActionData, String paramString)
  {
    boolean bool = false;
    if (paramApolloActionData == null) {
      return false;
    }
    if ((android.text.TextUtils.isEmpty(paramApolloActionData.minVer)) || (android.text.TextUtils.isEmpty(paramApolloActionData.maxVer)) || (VersionUtil.a(paramString, paramApolloActionData.minVer, paramApolloActionData.maxVer))) {
      bool = true;
    }
    return bool;
  }
  
  public void checkApolloUrl(DownloadTask paramDownloadTask)
  {
    if (paramDownloadTask != null)
    {
      if (paramDownloadTask.a == null) {
        return;
      }
      int i = 0;
      while (i < paramDownloadTask.a.size())
      {
        String str = (String)paramDownloadTask.a.get(i);
        if (!android.text.TextUtils.isEmpty(str)) {
          if (str.contains("http://cmshow.qq.com")) {
            paramDownloadTask.a.set(i, str.replace("http://cmshow.qq.com", "https://cmshow.qq.com"));
          } else if (str.contains("http://cmshow.gtimg.com")) {
            paramDownloadTask.a.set(i, str.replace("http://cmshow.gtimg.com", "https://cmshow.gtimg.com"));
          }
        }
        i += 1;
      }
    }
  }
  
  public boolean checkPreloadOnSettingMe(AppRuntime paramAppRuntime, View paramView)
  {
    if ((paramView != null) && (paramView.getVisibility() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("[cmshow]ApolloUtil", 2, "apollo_client view is visible preloadWebProcess apolloOpen:true");
      }
      return true;
    }
    boolean bool2 = false;
    if (paramAppRuntime == null) {
      return false;
    }
    paramAppRuntime = (IApolloManagerService)paramAppRuntime.getRuntimeService(IApolloManagerService.class, "all");
    boolean bool1 = bool2;
    if (paramAppRuntime.queryStatusInConfig("drawer", null) > 0)
    {
      bool1 = bool2;
      if (paramAppRuntime.isApolloSupport(BaseApplicationImpl.getContext(), Boolean.valueOf(false))) {
        bool1 = true;
      }
    }
    if (QLog.isColorLevel())
    {
      paramAppRuntime = new StringBuilder();
      paramAppRuntime.append("apollo_client preloadWebProcess apolloOpen:");
      paramAppRuntime.append(bool1);
      QLog.d("[cmshow]ApolloUtil", 2, paramAppRuntime.toString());
    }
    return bool1;
  }
  
  public void checkWrapApolloDownload(DownloadTask paramDownloadTask) {}
  
  public String checkWrapApolloUrl(String paramString)
  {
    if (android.text.TextUtils.isEmpty(paramString)) {
      return paramString;
    }
    if (!((IApolloUtil)QRoute.api(IApolloUtil.class)).isApolloProxyEnable()) {
      return paramString;
    }
    QLog.d("[cmshow]ApolloUtil", 2, new Object[] { "checkWrapApolloUrl url:", paramString });
    String str = paramString;
    if (!paramString.contains("open.cmshow.qq.com")) {
      str = paramString.replace("//cmshow.qq.com", "//open.cmshow.qq.com").replace("//h5.cmshow.qq.com", "//open.cmshow.qq.com").replace("//cmshow.gtimg.cn", "//open.cmshow.qq.com");
    }
    paramString = str;
    if (str.contains("open.cmshow.qq.com"))
    {
      int j = str.indexOf("&_bid=");
      int i;
      if (j < 0)
      {
        j = str.indexOf("_bid=");
        i = 0;
      }
      else
      {
        i = 1;
      }
      paramString = str;
      if (j > 0)
      {
        paramString = str.substring(0, j);
        str = str.substring(j + 5);
        if (!android.text.TextUtils.isEmpty(str))
        {
          j = str.indexOf("&");
          if (j >= 0)
          {
            if (i != 0) {
              i = j;
            } else {
              i = j + 1;
            }
            str = str.substring(i);
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append(paramString);
            localStringBuilder.append(str);
            paramString = localStringBuilder.toString();
          }
        }
      }
    }
    QLog.d("[cmshow]ApolloUtil", 2, new Object[] { "checkWrapApolloUrl replaceUrl:", paramString });
    return paramString;
  }
  
  public void deleteApolloResource(boolean paramBoolean, AppRuntime paramAppRuntime)
  {
    ThreadManager.getSubThreadHandler().post(new ApolloUtilImpl.9(this, paramBoolean));
  }
  
  public String getApolloImageUrl(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("https://cmshow.gtimg.cn/client/img/");
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  public int getApolloPanelJsonVer(int paramInt)
  {
    Object localObject;
    if (1 == paramInt) {
      localObject = new File("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/action/action_v730.json");
    } else {
      localObject = null;
    }
    if ((localObject != null) && (((File)localObject).exists()))
    {
      if (!((File)localObject).isFile()) {
        return 0;
      }
      localObject = FileUtils.readFileContent((File)localObject);
      if (android.text.TextUtils.isEmpty((CharSequence)localObject)) {
        return 0;
      }
      try
      {
        localObject = new JSONObject((String)localObject);
        if (((JSONObject)localObject).has("timeStamp")) {
          return (int)(((JSONObject)localObject).optLong("timeStamp") / 1000L);
        }
        if (((JSONObject)localObject).has("timestamp"))
        {
          long l = ((JSONObject)localObject).optLong("timestamp") / 1000L;
          return (int)l;
        }
      }
      catch (Exception localException)
      {
        QLog.e("[cmshow]ApolloUtil", 1, "getApolloPanelJsonVer fail", localException);
      }
    }
    return 0;
  }
  
  public AppRuntime getAppInterface()
  {
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
    if (localBaseApplicationImpl != null) {
      return localBaseApplicationImpl.getRuntime();
    }
    return null;
  }
  
  public String getBoxFloatUrl(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 3)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("https://cmshow.gtimg.cn/qqshow/admindata/comdata/vipApollo_action_");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append("/task_detail.gif");
      return localStringBuilder.toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("https://cmshow.gtimg.cn/qqshow/admindata/comdata/vipApollo_item_");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append("/task_detail.png");
    return localStringBuilder.toString();
  }
  
  public URLDrawable getDrawable(String paramString1, URLDrawable.URLDrawableOptions paramURLDrawableOptions, String paramString2)
  {
    return getDrawable(false, paramString1, paramURLDrawableOptions, paramString2);
  }
  
  public URLDrawable getDrawable(String paramString1, URLDrawable.URLDrawableOptions paramURLDrawableOptions, String paramString2, boolean paramBoolean)
  {
    return getDrawable(false, paramString1, paramURLDrawableOptions, paramString2, paramBoolean);
  }
  
  public URLDrawable getDrawable(boolean paramBoolean, String paramString1, URLDrawable.URLDrawableOptions paramURLDrawableOptions, String paramString2)
  {
    return getDrawable(paramBoolean, paramString1, paramURLDrawableOptions, paramString2, false);
  }
  
  public URLDrawable getDrawable(boolean paramBoolean1, String paramString1, URLDrawable.URLDrawableOptions paramURLDrawableOptions, String paramString2, boolean paramBoolean2)
  {
    boolean bool = android.text.TextUtils.isEmpty(paramString1);
    Object localObject2 = null;
    if (bool) {
      return null;
    }
    Object localObject1;
    if (!paramBoolean1)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/image_cache/boxcard/");
      ((StringBuilder)localObject1).append(paramString1);
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    else
    {
      localObject1 = paramString1;
    }
    URLDrawable.URLDrawableOptions localURLDrawableOptions = paramURLDrawableOptions;
    if (paramURLDrawableOptions == null)
    {
      localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mExtraInfo = null;
    }
    if (localURLDrawableOptions.mLoadingDrawable == null) {
      localURLDrawableOptions.mLoadingDrawable = URLDrawableHelperConstants.a;
    }
    if (localURLDrawableOptions.mFailedDrawable == null) {
      localURLDrawableOptions.mFailedDrawable = URLDrawableHelperConstants.a;
    }
    if (localURLDrawableOptions.mExtraInfo == null) {
      localURLDrawableOptions.mExtraInfo = new ApolloDrawableExtraInfo();
    }
    paramBoolean1 = paramBoolean2;
    if ((localURLDrawableOptions.mExtraInfo instanceof ApolloDrawableExtraInfo))
    {
      paramURLDrawableOptions = (ApolloDrawableExtraInfo)localURLDrawableOptions.mExtraInfo;
      if (!android.text.TextUtils.isEmpty((CharSequence)localObject1)) {
        paramURLDrawableOptions.mLocalPath = ((String)localObject1);
      }
      if (!android.text.TextUtils.isEmpty(paramString2)) {
        paramURLDrawableOptions.mDownloadUrl = paramString2;
      }
      if (paramURLDrawableOptions.mDrawableType != ApolloConstant.g)
      {
        paramBoolean1 = paramBoolean2;
        if (!paramURLDrawableOptions.mNoUseFileDrawable) {}
      }
      else
      {
        paramBoolean1 = true;
      }
    }
    paramURLDrawableOptions = new File((String)localObject1);
    if ((!paramBoolean1) && (paramURLDrawableOptions.exists()))
    {
      paramURLDrawableOptions = URLDrawable.getDrawable(paramURLDrawableOptions, localURLDrawableOptions);
      paramString1 = paramURLDrawableOptions;
      if (QLog.isColorLevel())
      {
        paramString1 = new StringBuilder();
        paramString1.append("getDrawable file exsit path->");
        paramString1.append((String)localObject1);
        paramString1.append(",url:");
        paramString1.append(paramString2);
        QLog.d("[cmshow]ApolloUtil", 2, paramString1.toString());
        return paramURLDrawableOptions;
      }
    }
    else
    {
      try
      {
        paramString1 = URLDrawable.getDrawable(new URL("apollo_image", "", paramString1), localURLDrawableOptions);
        return paramString1;
      }
      catch (Exception paramString1)
      {
        QLog.d("[cmshow]ApolloUtil", 1, paramString1.getMessage());
        paramString1 = localObject2;
      }
    }
    return paramString1;
  }
  
  public String getEmoticonPanelFromEntrance()
  {
    return EmoticonPanelCmShowHelper.a();
  }
  
  public int getJsonIntValue(String paramString1, String paramString2)
  {
    if (!android.text.TextUtils.isEmpty(paramString1))
    {
      if (android.text.TextUtils.isEmpty(paramString2)) {
        return 0;
      }
      try
      {
        int i = new JSONObject(paramString1).optInt(paramString2);
        return i;
      }
      catch (Exception paramString1)
      {
        QLog.e("[cmshow]ApolloUtil", 2, paramString1.getMessage());
      }
    }
    return 0;
  }
  
  public int getReportSessionTypeByContext(Object paramObject, AppRuntime paramAppRuntime)
  {
    boolean bool = paramObject instanceof SessionInfo;
    int i = 0;
    if (!bool) {
      return 0;
    }
    paramObject = (SessionInfo)paramObject;
    int k = paramObject.jdField_a_of_type_Int;
    int j = 1;
    if (k != 0)
    {
      if (k != 1)
      {
        if (k != 1036)
        {
          if (k != 3000) {
            return 0;
          }
          return 2;
        }
        return 4;
      }
      if (paramAppRuntime != null)
      {
        paramAppRuntime = (HotChatManager)paramAppRuntime.getManager(QQManagerFactory.HOT_CHAT_MANAGER);
        if (paramAppRuntime != null)
        {
          i = j;
          if (paramAppRuntime.b(paramObject.b)) {
            i = 3;
          }
          return i;
        }
      }
      i = 1;
    }
    return i;
  }
  
  public int getReportSessiontype(int paramInt)
  {
    int i = 0;
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 3000) {
          return 0;
        }
        return 2;
      }
      i = 1;
    }
    return i;
  }
  
  public int getReportUserResult(int paramInt)
  {
    if (paramInt == 2) {
      return 1;
    }
    return 0;
  }
  
  public SSLContext getSLLContext()
  {
    return ApolloHttpUtil.a();
  }
  
  public String getStoreTabUrl(String paramString, boolean paramBoolean)
  {
    String str1;
    if ("mall".equals(paramString)) {
      str1 = ApolloConstant.z;
    } else if ((!"interact".equals(paramString)) && (!"interactive".equals(paramString)))
    {
      if ("3d_mall".equals(paramString)) {
        str1 = ApolloConstant.F;
      } else if ((!"3d_interact".equals(paramString)) && (!"3d_interactive".equals(paramString))) {
        str1 = "";
      } else {
        str1 = ApolloConstant.G;
      }
    }
    else {
      str1 = ApolloConstant.A;
    }
    String str2 = str1;
    if (paramBoolean)
    {
      if ("game_city".equals(paramString)) {
        return ApolloConstant.E;
      }
      str2 = str1;
      if ("3d_game_city".equals(paramString)) {
        str2 = ApolloConstant.H;
      }
    }
    return str2;
  }
  
  public int getTraceDownloadErrCode(int paramInt)
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
  
  public boolean is3DFaceResExist(String paramString)
  {
    return CMResUtil.a(paramString);
  }
  
  public boolean isApolloProxyEnable()
  {
    if (QLog.isColorLevel()) {
      QLog.e("[cmshow]ApolloUtil", 1, "isApolloProxyEnable isPublicVersion");
    }
    return false;
  }
  
  public boolean isDressResExist(int paramInt)
  {
    return CMResUtil.a(paramInt);
  }
  
  public boolean isFemale(@NonNull AppRuntime paramAppRuntime, String paramString)
  {
    paramAppRuntime = ((FriendsManager)paramAppRuntime.getManager(QQManagerFactory.FRIENDS_MANAGER)).b(paramString);
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramAppRuntime != null)
    {
      bool1 = bool2;
      if (paramAppRuntime.gender == 2) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public boolean isRoleResExist(int paramInt)
  {
    return CMResUtil.b(paramInt);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramIntent != null) && (paramInt1 == 14002) && (paramInt2 == -1))
    {
      AbsStructMsg localAbsStructMsg = StructMsgFactory.a(paramIntent.getByteArrayExtra("stuctmsg_bytes"));
      if (localAbsStructMsg == null) {
        return;
      }
      String str = paramIntent.getStringExtra("uin");
      paramInt1 = paramIntent.getIntExtra("uintype", -1);
      paramInt2 = paramIntent.getIntExtra("cmshow_game_id", -1);
      ShareMsgHelper.a(getQQApp(), str, paramInt1, localAbsStructMsg, null);
      VipUtils.a(getQQApp(), "cmshow", "Apollo", "share_url_succeed", getReportSessiontype(paramInt1), 0, new String[] { Integer.toString(paramInt2) });
    }
  }
  
  public void onEmoticonNewIconShown(int paramInt)
  {
    if (!isNewApolloEmotion(paramInt)) {
      return;
    }
    if (SystemEmoticonInfo.sNewApolloEmoticonMap.containsKey("8.7.0"))
    {
      Object localObject = (List)SystemEmoticonInfo.sNewApolloEmoticonMap.get("8.7.0");
      if ((localObject != null) && (((List)localObject).size() > 0))
      {
        sShownNewEmoticonSize += 1;
        if (sShownNewEmoticonSize >= ((List)localObject).size())
        {
          localObject = BaseApplicationImpl.getApplication().getSharedPreferences("apollo_user_config", 0);
          String str = getNewIconShowFlagKey();
          if (!sNewIconShowTimesLoaded)
          {
            if (!android.text.TextUtils.isEmpty(str)) {
              sNewIconShowTimes = ((SharedPreferences)localObject).getInt(str, 0);
            }
            sNewIconShowTimesLoaded = true;
          }
          sNewIconShowTimes += 1;
          if (!android.text.TextUtils.isEmpty(str)) {
            ((SharedPreferences)localObject).edit().putInt(str, sNewIconShowTimes).apply();
          }
          sShownNewEmoticonSize = 0;
        }
      }
    }
    VipUtils.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), "cmshow", "Apollo", "expresstab_reddot_view", 0, 0, new String[] { String.valueOf(paramInt) });
  }
  
  public void onNewEmoticonClick(int paramInt)
  {
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("apollo_user_config", 0);
    String str = getNewIconShowFlagKey();
    if (!android.text.TextUtils.isEmpty(str))
    {
      sNewIconShowTimes = 3;
      localSharedPreferences.edit().putInt(str, sNewIconShowTimes).apply();
    }
    sShownNewEmoticonSize = 0;
    VipUtils.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), "cmshow", "Apollo", "expresstab_reddot_click", 0, 0, new String[] { String.valueOf(paramInt) });
  }
  
  public void onPopupGuideShown()
  {
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("apollo_user_config", 0);
    String str = getPopupShowFlagKey();
    if (!android.text.TextUtils.isEmpty(str)) {
      localSharedPreferences.edit().putBoolean(str, true).apply();
    }
    sPopupGuideShown = true;
  }
  
  public void openApolloStore(Context paramContext, Intent paramIntent, String paramString1, String paramString2, AppInterface paramAppInterface)
  {
    openApolloStore(paramContext, paramIntent, paramString1, paramString2, paramAppInterface, 0);
  }
  
  public void openApolloStore(Context paramContext, Intent paramIntent, String paramString1, String paramString2, AppInterface paramAppInterface, int paramInt)
  {
    CmShowLauncher.a(paramContext, paramIntent, paramString1, paramString2, paramAppInterface, paramInt);
  }
  
  public void openWebViewActivity(Context paramContext, String paramString)
  {
    Intent localIntent = new Intent(paramContext, QQBrowserActivity.class);
    localIntent.putExtra("big_brother_source_key", "biz_src_zf_lmx");
    VasWebviewUtil.a(paramContext, paramString, -1L, localIntent, false, -1);
  }
  
  public void playApolloEmoticonAction(AppRuntime paramAppRuntime, Object paramObject, MessageRecord paramMessageRecord, CharSequence paramCharSequence, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (((paramAppRuntime instanceof QQAppInterface)) && ((paramObject instanceof SessionInfo)) && (paramMessageRecord != null) && (paramCharSequence != null))
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)paramAppRuntime;
      paramObject = (SessionInfo)paramObject;
      if (!CmShowAioMatcherImpl.judgeSupported(paramObject.jdField_a_of_type_Int)) {
        return;
      }
      if (paramBoolean)
      {
        if (!android.text.TextUtils.isEmpty(paramMessageRecord.extStr)) {
          try
          {
            paramAppRuntime = new JSONObject(paramMessageRecord.extStr).optString("is_apollo_emoticon_action_checked");
          }
          catch (Exception paramAppRuntime)
          {
            QLog.e("[cmshow]ApolloUtil", 1, "[playApolloEmoticonAction] json error, ", paramAppRuntime);
          }
        } else {
          paramAppRuntime = null;
        }
      }
      else {
        paramAppRuntime = paramMessageRecord.getExtInfoFromExtStr("is_apollo_emoticon_action_checked");
      }
      boolean bool;
      if ((!android.text.TextUtils.isEmpty(paramAppRuntime)) && ("1".equals(paramAppRuntime))) {
        bool = true;
      } else {
        bool = false;
      }
      if (QLog.isColorLevel()) {
        QLog.d("[cmshow]ApolloUtil", 2, new Object[] { "[playApolloEmoticonAction] apollo emoticon action played=", Boolean.valueOf(bool), ", uniseq=", Long.valueOf(paramMessageRecord.uniseq), ", position=", Integer.valueOf(paramInt1), ", itemCount=", Integer.valueOf(paramInt2), ", isLongMsg=", Boolean.valueOf(paramBoolean) });
      }
      if (bool) {
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("[cmshow]ApolloUtil", 2, "[playApolloEmoticonAction] set apollo emoticon action play status true");
      }
      paramMessageRecord.saveExtInfoToExtStr("is_apollo_emoticon_action_checked", "1");
      ThreadManager.post(new ApolloUtilImpl.1(this, paramMessageRecord), 5, null, false);
      if (paramInt1 != paramInt2 - 1) {
        return;
      }
      paramAppRuntime = (ApolloManagerServiceImpl)localQQAppInterface.getRuntimeService(IApolloManagerService.class, "all");
      if (paramAppRuntime == null) {
        return;
      }
      paramBoolean = CmShowWnsUtils.a();
      paramInt1 = getWhiteFacePlayModel(localQQAppInterface, paramMessageRecord);
      if (paramInt1 == 0) {
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("[cmshow]ApolloUtil", 2, new Object[] { "[playApolloEmoticonAction] apollo status open, grab action playModel:", Integer.valueOf(paramInt1), ",is3DWhiteFaceOpen:", Boolean.valueOf(paramBoolean) });
      }
      ApolloDaoManagerServiceImpl localApolloDaoManagerServiceImpl = (ApolloDaoManagerServiceImpl)localQQAppInterface.getRuntimeService(IApolloDaoManagerService.class, "all");
      if (!(paramCharSequence instanceof QQText)) {
        return;
      }
      paramMessageRecord.saveExtInfoToExtStr("is_apollo_emoticon_action_played", "2");
      ThreadManager.post(new ApolloUtilImpl.2(this, paramInt1, paramBoolean, paramCharSequence, localApolloDaoManagerServiceImpl, localQQAppInterface, paramObject, paramAppRuntime, paramMessageRecord), 5, null, false);
      return;
    }
    QLog.e("[cmshow]ApolloUtil", 1, "[playApolloEmoticonAction] param null, abort");
  }
  
  public void playShareMsgAction(AppRuntime paramAppRuntime, Object paramObject, MessageRecord paramMessageRecord, int paramInt1, int paramInt2)
  {
    if (((paramAppRuntime instanceof QQAppInterface)) && ((paramObject instanceof SessionInfo)) && (paramMessageRecord != null))
    {
      paramAppRuntime = (QQAppInterface)paramAppRuntime;
      if (!CmShowAioMatcherImpl.judgeSupported(((SessionInfo)paramObject).jdField_a_of_type_Int)) {
        return;
      }
      paramObject = paramMessageRecord.getExtInfoFromExtStr("is_share_ark_message_action_checked");
      boolean bool;
      if ((!android.text.TextUtils.isEmpty(paramObject)) && ("1".equals(paramObject))) {
        bool = true;
      } else {
        bool = false;
      }
      if (QLog.isColorLevel()) {
        QLog.d("[cmshow]ApolloUtil", 2, new Object[] { "[playShareMsgAction] share ark action isChecked:", Boolean.valueOf(bool), ", uniseq=", Long.valueOf(paramMessageRecord.uniseq) });
      }
      if (bool) {
        return;
      }
      paramMessageRecord.saveExtInfoToExtStr("is_share_ark_message_action_checked", "1");
      ThreadManager.excute(new ApolloUtilImpl.3(this, paramMessageRecord, paramInt1, paramInt2, paramAppRuntime), 96, null, false);
      return;
    }
    QLog.e("[cmshow]ApolloUtil", 1, "[playShareMsgAction] param null, abort");
  }
  
  /* Error */
  public void replaceCmshow3dResource(String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 212	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifne +1184 -> 1188
    //   7: new 608	java/io/File
    //   10: dup
    //   11: aload_1
    //   12: invokespecial 609	java/io/File:<init>	(Ljava/lang/String;)V
    //   15: invokevirtual 612	java/io/File:exists	()Z
    //   18: ifne +6 -> 24
    //   21: goto +1167 -> 1188
    //   24: ldc 38
    //   26: iconst_1
    //   27: iconst_2
    //   28: anewarray 4	java/lang/Object
    //   31: dup
    //   32: iconst_0
    //   33: ldc_w 2338
    //   36: aastore
    //   37: dup
    //   38: iconst_1
    //   39: aload_1
    //   40: aastore
    //   41: invokestatic 1220	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   44: new 608	java/io/File
    //   47: dup
    //   48: ldc_w 2340
    //   51: invokespecial 609	java/io/File:<init>	(Ljava/lang/String;)V
    //   54: astore 13
    //   56: aload 13
    //   58: invokevirtual 612	java/io/File:exists	()Z
    //   61: ifeq +9 -> 70
    //   64: aload 13
    //   66: invokestatic 2343	com/tencent/mobileqq/filemanager/util/FileUtil:a	(Ljava/io/File;)Z
    //   69: pop
    //   70: new 608	java/io/File
    //   73: dup
    //   74: aload_1
    //   75: invokespecial 609	java/io/File:<init>	(Ljava/lang/String;)V
    //   78: ldc_w 2340
    //   81: invokestatic 2348	com/tencent/biz/common/util/ZipUtils:unZipFile	(Ljava/io/File;Ljava/lang/String;)V
    //   84: aload 13
    //   86: invokevirtual 1037	java/io/File:listFiles	()[Ljava/io/File;
    //   89: astore_1
    //   90: aload_1
    //   91: ifnull +1168 -> 1259
    //   94: aload_1
    //   95: arraylength
    //   96: ifle +1163 -> 1259
    //   99: ldc2_w 837
    //   102: lstore 6
    //   104: iconst_0
    //   105: istore_3
    //   106: iconst_0
    //   107: istore_2
    //   108: iload_2
    //   109: istore 4
    //   111: lload 6
    //   113: lstore 10
    //   115: iload_3
    //   116: aload_1
    //   117: arraylength
    //   118: if_icmpge +428 -> 546
    //   121: aload_1
    //   122: iload_3
    //   123: aaload
    //   124: astore 14
    //   126: aload 14
    //   128: invokevirtual 1040	java/io/File:isFile	()Z
    //   131: ifeq +81 -> 212
    //   134: aload 14
    //   136: invokevirtual 2351	java/io/File:getName	()Ljava/lang/String;
    //   139: ldc_w 2353
    //   142: invokevirtual 1048	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   145: ifeq +67 -> 212
    //   148: new 105	java/lang/StringBuilder
    //   151: dup
    //   152: invokespecial 106	java/lang/StringBuilder:<init>	()V
    //   155: astore 15
    //   157: aload 15
    //   159: ldc_w 1559
    //   162: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   165: pop
    //   166: aload 15
    //   168: ldc2_w 2354
    //   171: invokevirtual 570	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   174: pop
    //   175: aload 15
    //   177: ldc_w 2357
    //   180: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   183: pop
    //   184: aload 14
    //   186: new 608	java/io/File
    //   189: dup
    //   190: aload 15
    //   192: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   195: invokespecial 609	java/io/File:<init>	(Ljava/lang/String;)V
    //   198: invokestatic 2361	com/tencent/mobileqq/utils/FileUtils:copyFile	(Ljava/io/File;Ljava/io/File;)Z
    //   201: pop
    //   202: iconst_1
    //   203: istore 4
    //   205: lload 6
    //   207: lstore 8
    //   209: goto +1036 -> 1245
    //   212: aload 14
    //   214: invokevirtual 1033	java/io/File:isDirectory	()Z
    //   217: ifeq +75 -> 292
    //   220: aload 14
    //   222: invokevirtual 2351	java/io/File:getName	()Ljava/lang/String;
    //   225: ldc_w 2363
    //   228: invokevirtual 1048	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   231: ifeq +61 -> 292
    //   234: new 608	java/io/File
    //   237: dup
    //   238: aload 14
    //   240: ldc_w 2365
    //   243: invokespecial 1564	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   246: astore 14
    //   248: new 608	java/io/File
    //   251: dup
    //   252: ldc_w 2367
    //   255: invokespecial 609	java/io/File:<init>	(Ljava/lang/String;)V
    //   258: astore 15
    //   260: aload 15
    //   262: invokevirtual 612	java/io/File:exists	()Z
    //   265: ifeq +9 -> 274
    //   268: aload 15
    //   270: invokevirtual 1579	java/io/File:delete	()Z
    //   273: pop
    //   274: aload 14
    //   276: aload 15
    //   278: invokestatic 2361	com/tencent/mobileqq/utils/FileUtils:copyFile	(Ljava/io/File;Ljava/io/File;)Z
    //   281: pop
    //   282: iload_2
    //   283: istore 4
    //   285: lload 6
    //   287: lstore 8
    //   289: goto +956 -> 1245
    //   292: iload_2
    //   293: istore 4
    //   295: lload 6
    //   297: lstore 8
    //   299: aload 14
    //   301: invokevirtual 1033	java/io/File:isDirectory	()Z
    //   304: ifeq +941 -> 1245
    //   307: new 608	java/io/File
    //   310: dup
    //   311: aload 14
    //   313: ldc_w 2369
    //   316: invokespecial 1564	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   319: astore 14
    //   321: iload_2
    //   322: istore 4
    //   324: lload 6
    //   326: lstore 8
    //   328: aload 14
    //   330: invokevirtual 612	java/io/File:exists	()Z
    //   333: ifeq +912 -> 1245
    //   336: aload 14
    //   338: invokevirtual 1037	java/io/File:listFiles	()[Ljava/io/File;
    //   341: astore 14
    //   343: iload_2
    //   344: istore 4
    //   346: lload 6
    //   348: lstore 8
    //   350: aload 14
    //   352: ifnull +893 -> 1245
    //   355: iload_2
    //   356: istore 4
    //   358: lload 6
    //   360: lstore 8
    //   362: aload 14
    //   364: arraylength
    //   365: ifle +880 -> 1245
    //   368: iconst_0
    //   369: istore 5
    //   371: iload_2
    //   372: istore 4
    //   374: lload 6
    //   376: lstore 8
    //   378: iload 5
    //   380: aload 14
    //   382: arraylength
    //   383: if_icmpge +862 -> 1245
    //   386: aload 14
    //   388: iload 5
    //   390: aaload
    //   391: astore 15
    //   393: lload 6
    //   395: lstore 8
    //   397: aload 15
    //   399: invokevirtual 1040	java/io/File:isFile	()Z
    //   402: ifeq +830 -> 1232
    //   405: lload 6
    //   407: lstore 8
    //   409: aload 15
    //   411: invokevirtual 2351	java/io/File:getName	()Ljava/lang/String;
    //   414: ldc_w 2371
    //   417: invokevirtual 249	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   420: ifeq +812 -> 1232
    //   423: aload 15
    //   425: invokevirtual 2351	java/io/File:getName	()Ljava/lang/String;
    //   428: ldc_w 2373
    //   431: invokevirtual 1048	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   434: istore 12
    //   436: iload 12
    //   438: ifeq +768 -> 1206
    //   441: new 105	java/lang/StringBuilder
    //   444: dup
    //   445: invokespecial 106	java/lang/StringBuilder:<init>	()V
    //   448: astore 16
    //   450: aload 16
    //   452: ldc_w 1559
    //   455: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   458: pop
    //   459: aload 16
    //   461: ldc2_w 2354
    //   464: invokevirtual 570	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   467: pop
    //   468: aload 16
    //   470: ldc_w 2375
    //   473: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   476: pop
    //   477: aload 15
    //   479: aload 16
    //   481: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   484: invokestatic 2348	com/tencent/biz/common/util/ZipUtils:unZipFile	(Ljava/io/File;Ljava/lang/String;)V
    //   487: lload 6
    //   489: lstore 8
    //   491: goto +741 -> 1232
    //   494: new 105	java/lang/StringBuilder
    //   497: dup
    //   498: invokespecial 106	java/lang/StringBuilder:<init>	()V
    //   501: astore 16
    //   503: aload 16
    //   505: ldc_w 2377
    //   508: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   511: pop
    //   512: aload 16
    //   514: lload 6
    //   516: invokevirtual 570	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   519: pop
    //   520: aload 16
    //   522: ldc_w 2375
    //   525: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   528: pop
    //   529: aload 15
    //   531: aload 16
    //   533: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   536: invokestatic 2348	com/tencent/biz/common/util/ZipUtils:unZipFile	(Ljava/io/File;Ljava/lang/String;)V
    //   539: lload 6
    //   541: lstore 8
    //   543: goto +689 -> 1232
    //   546: aload 13
    //   548: invokestatic 2343	com/tencent/mobileqq/filemanager/util/FileUtil:a	(Ljava/io/File;)Z
    //   551: pop
    //   552: iload 4
    //   554: ifne +21 -> 575
    //   557: getstatic 2383	com/tencent/mobileqq/app/BaseActivity:sTopActivity	Lcom/tencent/mobileqq/app/BaseActivity;
    //   560: ldc_w 2384
    //   563: invokestatic 146	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   566: iconst_0
    //   567: invokestatic 2389	com/tencent/mobileqq/widget/QQToast:a	(Landroid/content/Context;Ljava/lang/CharSequence;I)Lcom/tencent/mobileqq/widget/QQToast;
    //   570: invokevirtual 2392	com/tencent/mobileqq/widget/QQToast:a	()Landroid/widget/Toast;
    //   573: pop
    //   574: return
    //   575: lload 10
    //   577: ldc2_w 837
    //   580: lcmp
    //   581: ifeq +548 -> 1129
    //   584: ldc 38
    //   586: iconst_1
    //   587: iconst_2
    //   588: anewarray 4	java/lang/Object
    //   591: dup
    //   592: iconst_0
    //   593: ldc_w 2394
    //   596: aastore
    //   597: dup
    //   598: iconst_1
    //   599: lload 10
    //   601: invokestatic 1213	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   604: aastore
    //   605: invokestatic 1220	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   608: invokestatic 274	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   611: invokevirtual 952	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   614: checkcast 99	com/tencent/mobileqq/app/QQAppInterface
    //   617: astore 14
    //   619: aload 14
    //   621: ldc_w 718
    //   624: ldc_w 702
    //   627: invokevirtual 706	com/tencent/mobileqq/app/QQAppInterface:getRuntimeService	(Ljava/lang/Class;Ljava/lang/String;)Lmqq/app/api/IRuntimeService;
    //   630: checkcast 382	com/tencent/mobileqq/apollo/persistence/api/impl/ApolloDaoManagerServiceImpl
    //   633: astore 15
    //   635: aload 14
    //   637: invokevirtual 1256	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   640: astore 17
    //   642: aload 15
    //   644: aload 17
    //   646: invokevirtual 2397	com/tencent/mobileqq/apollo/persistence/api/impl/ApolloDaoManagerServiceImpl:getApolloBaseInfo	(Ljava/lang/String;)Lcom/tencent/mobileqq/apollo/model/ApolloBaseInfo;
    //   649: astore 16
    //   651: aload 16
    //   653: ifnull +534 -> 1187
    //   656: aload 16
    //   658: getfield 2400	com/tencent/mobileqq/apollo/model/ApolloBaseInfo:mApollo3DDataBuffer	Ljava/lang/String;
    //   661: astore_1
    //   662: aload_1
    //   663: ifnull +55 -> 718
    //   666: new 409	org/json/JSONObject
    //   669: dup
    //   670: aload 16
    //   672: getfield 2400	com/tencent/mobileqq/apollo/model/ApolloBaseInfo:mApollo3DDataBuffer	Ljava/lang/String;
    //   675: invokespecial 412	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   678: astore_1
    //   679: aload_1
    //   680: ldc_w 2402
    //   683: invokevirtual 448	org/json/JSONObject:optLong	(Ljava/lang/String;)J
    //   686: lstore 6
    //   688: aload_1
    //   689: ldc_w 2404
    //   692: invokevirtual 1352	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   695: astore_1
    //   696: aload_1
    //   697: ifnull +15 -> 712
    //   700: aload_1
    //   701: ldc_w 2405
    //   704: invokevirtual 448	org/json/JSONObject:optLong	(Ljava/lang/String;)J
    //   707: lstore 8
    //   709: goto +16 -> 725
    //   712: lconst_0
    //   713: lstore 8
    //   715: goto +10 -> 725
    //   718: lconst_0
    //   719: lstore 6
    //   721: lload 6
    //   723: lstore 8
    //   725: lload 8
    //   727: lconst_0
    //   728: lcmp
    //   729: ifeq +379 -> 1108
    //   732: new 105	java/lang/StringBuilder
    //   735: dup
    //   736: invokespecial 106	java/lang/StringBuilder:<init>	()V
    //   739: astore_1
    //   740: aload_1
    //   741: ldc_w 1559
    //   744: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   747: pop
    //   748: aload_1
    //   749: lload 8
    //   751: invokevirtual 570	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   754: pop
    //   755: aload_1
    //   756: ldc_w 2407
    //   759: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   762: pop
    //   763: new 608	java/io/File
    //   766: dup
    //   767: aload_1
    //   768: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   771: invokespecial 609	java/io/File:<init>	(Ljava/lang/String;)V
    //   774: astore 18
    //   776: new 105	java/lang/StringBuilder
    //   779: dup
    //   780: invokespecial 106	java/lang/StringBuilder:<init>	()V
    //   783: astore 19
    //   785: aload 19
    //   787: ldc_w 1559
    //   790: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   793: pop
    //   794: ldc 38
    //   796: astore 13
    //   798: aload 13
    //   800: astore_1
    //   801: aload 19
    //   803: ldc2_w 2354
    //   806: invokevirtual 570	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   809: pop
    //   810: aload 13
    //   812: astore_1
    //   813: aload 19
    //   815: ldc_w 2407
    //   818: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   821: pop
    //   822: aload 13
    //   824: astore_1
    //   825: aload 18
    //   827: new 608	java/io/File
    //   830: dup
    //   831: aload 19
    //   833: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   836: invokespecial 609	java/io/File:<init>	(Ljava/lang/String;)V
    //   839: invokestatic 2361	com/tencent/mobileqq/utils/FileUtils:copyFile	(Ljava/io/File;Ljava/io/File;)Z
    //   842: pop
    //   843: aload 13
    //   845: astore_1
    //   846: new 409	org/json/JSONObject
    //   849: dup
    //   850: invokespecial 1622	org/json/JSONObject:<init>	()V
    //   853: astore 18
    //   855: aload 13
    //   857: astore_1
    //   858: invokestatic 407	java/lang/System:currentTimeMillis	()J
    //   861: ldc2_w 2027
    //   864: ldiv
    //   865: lstore 8
    //   867: aload 13
    //   869: astore_1
    //   870: aload 18
    //   872: ldc_w 2215
    //   875: aload 17
    //   877: invokestatic 1059	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   880: invokevirtual 2410	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   883: pop
    //   884: aload 13
    //   886: astore_1
    //   887: aload 18
    //   889: ldc_w 2402
    //   892: lload 6
    //   894: invokevirtual 2410	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   897: pop
    //   898: aload 13
    //   900: astore_1
    //   901: aload 18
    //   903: ldc_w 2412
    //   906: iconst_0
    //   907: invokevirtual 2415	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   910: pop
    //   911: aload 13
    //   913: astore_1
    //   914: new 409	org/json/JSONObject
    //   917: dup
    //   918: invokespecial 1622	org/json/JSONObject:<init>	()V
    //   921: astore 17
    //   923: aload 13
    //   925: astore_1
    //   926: aload 17
    //   928: ldc_w 2405
    //   931: ldc2_w 2354
    //   934: invokevirtual 2410	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   937: pop
    //   938: aload 13
    //   940: astore_1
    //   941: aload 17
    //   943: ldc_w 2402
    //   946: lload 6
    //   948: invokevirtual 2410	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   951: pop
    //   952: aload 13
    //   954: astore_1
    //   955: aload 18
    //   957: ldc_w 2404
    //   960: aload 17
    //   962: invokevirtual 1629	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   965: pop
    //   966: aload 13
    //   968: astore_1
    //   969: new 504	org/json/JSONArray
    //   972: dup
    //   973: invokespecial 2416	org/json/JSONArray:<init>	()V
    //   976: astore 17
    //   978: ldc2_w 2417
    //   981: lstore 8
    //   983: lload 8
    //   985: lload 10
    //   987: lcmp
    //   988: ifgt +63 -> 1051
    //   991: aload 13
    //   993: astore_1
    //   994: new 409	org/json/JSONObject
    //   997: dup
    //   998: invokespecial 1622	org/json/JSONObject:<init>	()V
    //   1001: astore 19
    //   1003: aload 13
    //   1005: astore_1
    //   1006: aload 19
    //   1008: ldc_w 2405
    //   1011: lload 8
    //   1013: invokevirtual 2410	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   1016: pop
    //   1017: aload 13
    //   1019: astore_1
    //   1020: aload 19
    //   1022: ldc_w 2402
    //   1025: lload 6
    //   1027: invokevirtual 2410	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   1030: pop
    //   1031: aload 13
    //   1033: astore_1
    //   1034: aload 17
    //   1036: aload 19
    //   1038: invokevirtual 2421	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   1041: pop
    //   1042: lload 8
    //   1044: lconst_1
    //   1045: ladd
    //   1046: lstore 8
    //   1048: goto -65 -> 983
    //   1051: aload 13
    //   1053: astore_1
    //   1054: aload 18
    //   1056: ldc_w 2423
    //   1059: aload 17
    //   1061: invokevirtual 1629	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1064: pop
    //   1065: aload 13
    //   1067: astore_1
    //   1068: aload 16
    //   1070: aload 14
    //   1072: aload 18
    //   1074: invokevirtual 2427	com/tencent/mobileqq/apollo/model/ApolloBaseInfo:setApolloDress3D	(Lcom/tencent/common/app/AppInterface;Lorg/json/JSONObject;)V
    //   1077: aload 13
    //   1079: astore_1
    //   1080: aload 15
    //   1082: aload 16
    //   1084: invokevirtual 2431	com/tencent/mobileqq/apollo/persistence/api/impl/ApolloDaoManagerServiceImpl:saveOrUpdateApolloBaseInfo	(Lcom/tencent/mobileqq/apollo/model/ApolloBaseInfo;)V
    //   1087: aload 13
    //   1089: astore_1
    //   1090: getstatic 2383	com/tencent/mobileqq/app/BaseActivity:sTopActivity	Lcom/tencent/mobileqq/app/BaseActivity;
    //   1093: ldc_w 2432
    //   1096: invokestatic 146	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   1099: iconst_0
    //   1100: invokestatic 2389	com/tencent/mobileqq/widget/QQToast:a	(Landroid/content/Context;Ljava/lang/CharSequence;I)Lcom/tencent/mobileqq/widget/QQToast;
    //   1103: invokevirtual 2392	com/tencent/mobileqq/widget/QQToast:a	()Landroid/widget/Toast;
    //   1106: pop
    //   1107: return
    //   1108: ldc 38
    //   1110: astore_1
    //   1111: getstatic 2383	com/tencent/mobileqq/app/BaseActivity:sTopActivity	Lcom/tencent/mobileqq/app/BaseActivity;
    //   1114: ldc_w 2433
    //   1117: invokestatic 146	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   1120: iconst_0
    //   1121: invokestatic 2389	com/tencent/mobileqq/widget/QQToast:a	(Landroid/content/Context;Ljava/lang/CharSequence;I)Lcom/tencent/mobileqq/widget/QQToast;
    //   1124: invokevirtual 2392	com/tencent/mobileqq/widget/QQToast:a	()Landroid/widget/Toast;
    //   1127: pop
    //   1128: return
    //   1129: ldc 38
    //   1131: astore_1
    //   1132: getstatic 2383	com/tencent/mobileqq/app/BaseActivity:sTopActivity	Lcom/tencent/mobileqq/app/BaseActivity;
    //   1135: ldc_w 2434
    //   1138: invokestatic 146	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   1141: iconst_0
    //   1142: invokestatic 2389	com/tencent/mobileqq/widget/QQToast:a	(Landroid/content/Context;Ljava/lang/CharSequence;I)Lcom/tencent/mobileqq/widget/QQToast;
    //   1145: invokevirtual 2392	com/tencent/mobileqq/widget/QQToast:a	()Landroid/widget/Toast;
    //   1148: pop
    //   1149: return
    //   1150: astore 13
    //   1152: goto +8 -> 1160
    //   1155: astore 13
    //   1157: ldc 38
    //   1159: astore_1
    //   1160: aload_1
    //   1161: iconst_1
    //   1162: ldc_w 2436
    //   1165: aload 13
    //   1167: invokestatic 787	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1170: getstatic 2383	com/tencent/mobileqq/app/BaseActivity:sTopActivity	Lcom/tencent/mobileqq/app/BaseActivity;
    //   1173: ldc_w 2437
    //   1176: invokestatic 146	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   1179: iconst_0
    //   1180: invokestatic 2389	com/tencent/mobileqq/widget/QQToast:a	(Landroid/content/Context;Ljava/lang/CharSequence;I)Lcom/tencent/mobileqq/widget/QQToast;
    //   1183: invokevirtual 2392	com/tencent/mobileqq/widget/QQToast:a	()Landroid/widget/Toast;
    //   1186: pop
    //   1187: return
    //   1188: getstatic 2383	com/tencent/mobileqq/app/BaseActivity:sTopActivity	Lcom/tencent/mobileqq/app/BaseActivity;
    //   1191: ldc_w 2438
    //   1194: invokestatic 146	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   1197: iconst_1
    //   1198: invokestatic 2389	com/tencent/mobileqq/widget/QQToast:a	(Landroid/content/Context;Ljava/lang/CharSequence;I)Lcom/tencent/mobileqq/widget/QQToast;
    //   1201: invokevirtual 2392	com/tencent/mobileqq/widget/QQToast:a	()Landroid/widget/Toast;
    //   1204: pop
    //   1205: return
    //   1206: lload 6
    //   1208: ldc2_w 837
    //   1211: lcmp
    //   1212: ifne +11 -> 1223
    //   1215: ldc2_w 2417
    //   1218: lstore 6
    //   1220: goto -726 -> 494
    //   1223: lload 6
    //   1225: lconst_1
    //   1226: ladd
    //   1227: lstore 6
    //   1229: goto -735 -> 494
    //   1232: iload 5
    //   1234: iconst_1
    //   1235: iadd
    //   1236: istore 5
    //   1238: lload 8
    //   1240: lstore 6
    //   1242: goto -871 -> 371
    //   1245: iload_3
    //   1246: iconst_1
    //   1247: iadd
    //   1248: istore_3
    //   1249: iload 4
    //   1251: istore_2
    //   1252: lload 8
    //   1254: lstore 6
    //   1256: goto -1148 -> 108
    //   1259: iconst_0
    //   1260: istore 4
    //   1262: ldc2_w 837
    //   1265: lstore 10
    //   1267: goto -721 -> 546
    //   1270: astore 13
    //   1272: ldc 38
    //   1274: astore_1
    //   1275: goto -115 -> 1160
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1278	0	this	ApolloUtilImpl
    //   0	1278	1	paramString	String
    //   107	1145	2	i	int
    //   105	1144	3	j	int
    //   109	1152	4	k	int
    //   369	868	5	m	int
    //   102	1153	6	l1	long
    //   207	1046	8	l2	long
    //   113	1153	10	l3	long
    //   434	3	12	bool	boolean
    //   54	1034	13	localObject1	Object
    //   1150	1	13	localException1	Exception
    //   1155	11	13	localException2	Exception
    //   1270	1	13	localException3	Exception
    //   124	947	14	localObject2	Object
    //   155	926	15	localObject3	Object
    //   448	635	16	localObject4	Object
    //   640	420	17	localObject5	Object
    //   774	299	18	localObject6	Object
    //   783	254	19	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   801	810	1150	java/lang/Exception
    //   813	822	1150	java/lang/Exception
    //   825	843	1150	java/lang/Exception
    //   846	855	1150	java/lang/Exception
    //   858	867	1150	java/lang/Exception
    //   870	884	1150	java/lang/Exception
    //   887	898	1150	java/lang/Exception
    //   901	911	1150	java/lang/Exception
    //   914	923	1150	java/lang/Exception
    //   926	938	1150	java/lang/Exception
    //   941	952	1150	java/lang/Exception
    //   955	966	1150	java/lang/Exception
    //   969	978	1150	java/lang/Exception
    //   994	1003	1150	java/lang/Exception
    //   1006	1017	1150	java/lang/Exception
    //   1020	1031	1150	java/lang/Exception
    //   1034	1042	1150	java/lang/Exception
    //   1054	1065	1150	java/lang/Exception
    //   1068	1077	1150	java/lang/Exception
    //   1080	1087	1150	java/lang/Exception
    //   1090	1107	1150	java/lang/Exception
    //   1111	1128	1150	java/lang/Exception
    //   1132	1149	1150	java/lang/Exception
    //   44	70	1155	java/lang/Exception
    //   70	90	1155	java/lang/Exception
    //   94	99	1155	java/lang/Exception
    //   115	121	1155	java/lang/Exception
    //   126	202	1155	java/lang/Exception
    //   212	274	1155	java/lang/Exception
    //   274	282	1155	java/lang/Exception
    //   299	321	1155	java/lang/Exception
    //   328	343	1155	java/lang/Exception
    //   362	368	1155	java/lang/Exception
    //   378	386	1155	java/lang/Exception
    //   397	405	1155	java/lang/Exception
    //   409	436	1155	java/lang/Exception
    //   441	487	1155	java/lang/Exception
    //   494	539	1155	java/lang/Exception
    //   546	552	1155	java/lang/Exception
    //   557	574	1155	java/lang/Exception
    //   584	651	1155	java/lang/Exception
    //   656	662	1155	java/lang/Exception
    //   666	696	1155	java/lang/Exception
    //   700	709	1155	java/lang/Exception
    //   732	794	1270	java/lang/Exception
  }
  
  public void reportCrash(boolean paramBoolean, String paramString1, String paramString2)
  {
    try
    {
      if (1 != BaseApplicationImpl.sProcessId) {
        return;
      }
      if (android.text.TextUtils.isEmpty(paramString2)) {
        return;
      }
      if (!paramString2.contains("Apollo")) {
        return;
      }
      handleApolloNoCatchCrash(paramBoolean, paramString1, paramString2);
      return;
    }
    catch (Throwable paramString1)
    {
      QLog.d("[cmshow]ApolloUtil", 1, paramString1.getMessage());
    }
  }
  
  public void reportTraceResourceSpanDesc(String paramString)
  {
    int i = getTraceResourceExtKey(paramString);
    if (i > 0)
    {
      long l = getFirstIntegerFromStr(paramString);
      if (i == 17) {
        l = 1L;
      }
      TraceReportUtil.a(30, paramString, 300, -100, 0L, i, l, new Object[0]);
    }
  }
  
  public void setApolloProxyEnable(boolean paramBoolean)
  {
    if (sHttpProxyPreferences == null) {
      sHttpProxyPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("apollo_http_proxy_sp", 4);
    }
    sHttpProxyPreferences.edit().putBoolean("key_proxy_enable", paramBoolean).commit();
  }
  
  public boolean shouldShowNewIcon(int paramInt)
  {
    boolean bool2 = isNewApolloEmotion(paramInt);
    boolean bool1 = false;
    if (!bool2) {
      return false;
    }
    if (!sNewIconShowTimesLoaded)
    {
      SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("apollo_user_config", 0);
      String str = getNewIconShowFlagKey();
      if (!android.text.TextUtils.isEmpty(str)) {
        sNewIconShowTimes = localSharedPreferences.getInt(str, 0);
      }
      sNewIconShowTimesLoaded = true;
    }
    if (sNewIconShowTimes < 3) {
      bool1 = true;
    }
    return bool1;
  }
  
  public boolean shouldShowPopupGuide()
  {
    boolean bool3 = SystemEmoticonInfo.sNewApolloEmoticonMap.containsKey("8.7.0");
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool3)
    {
      List localList = (List)SystemEmoticonInfo.sNewApolloEmoticonMap.get("8.7.0");
      bool1 = bool2;
      if (localList != null)
      {
        bool1 = bool2;
        if (localList.size() > 0)
        {
          if (!sPopupGuideFlagLoaded)
          {
            sPopupGuideShown = BaseApplicationImpl.getApplication().getSharedPreferences("apollo_user_config", 0).getBoolean(getPopupShowFlagKey(), false);
            sPopupGuideFlagLoaded = true;
          }
          bool1 = sPopupGuideShown ^ true;
        }
      }
    }
    return bool1;
  }
  
  public String wrapLogUin(String paramString)
  {
    Object localObject = paramString;
    if (!android.text.TextUtils.isEmpty(paramString))
    {
      if (paramString.length() < 4) {
        return paramString;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString.substring(0, 4));
      ((StringBuilder)localObject).append("*");
      localObject = ((StringBuilder)localObject).toString();
    }
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.utils.api.impl.ApolloUtilImpl
 * JD-Core Version:    0.7.0.1
 */