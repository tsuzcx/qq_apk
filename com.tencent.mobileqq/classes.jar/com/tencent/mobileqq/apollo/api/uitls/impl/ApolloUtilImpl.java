package com.tencent.mobileqq.apollo.api.uitls.impl;

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
import com.tencent.biz.common.util.ZipUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.ToolAppRuntime;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ArkFullScreenAppActivity;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.apollo.ApolloRender;
import com.tencent.mobileqq.apollo.ApolloTextureView;
import com.tencent.mobileqq.apollo.api.IApolloCmdChannel;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.api.aio.CmShowAioMatcher;
import com.tencent.mobileqq.apollo.api.data.IApolloDaoManagerService;
import com.tencent.mobileqq.apollo.api.data.impl.ApolloDaoManagerServiceImpl;
import com.tencent.mobileqq.apollo.api.impl.ApolloManagerServiceImpl;
import com.tencent.mobileqq.apollo.api.impl.model.App3DConfig;
import com.tencent.mobileqq.apollo.api.model.Apollo3DMessage;
import com.tencent.mobileqq.apollo.api.model.ApolloActionData;
import com.tencent.mobileqq.apollo.api.model.ApolloActionPackage;
import com.tencent.mobileqq.apollo.api.model.ApolloBaseInfo;
import com.tencent.mobileqq.apollo.api.model.ApolloDrawableExtraInfo;
import com.tencent.mobileqq.apollo.api.model.ApolloGameData;
import com.tencent.mobileqq.apollo.api.model.ApolloMessage;
import com.tencent.mobileqq.apollo.api.model.ApolloSkeletonBounding;
import com.tencent.mobileqq.apollo.api.model.MessageForApollo;
import com.tencent.mobileqq.apollo.api.script.ISpriteContext;
import com.tencent.mobileqq.apollo.api.uitls.ApolloConstant;
import com.tencent.mobileqq.apollo.api.uitls.IApolloUtil;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.StartCheckParam;
import com.tencent.mobileqq.apollo.drawer.PushDrawerStatus;
import com.tencent.mobileqq.apollo.script.SpriteUtil;
import com.tencent.mobileqq.apollo.statistics.trace.TraceReportUtil;
import com.tencent.mobileqq.apollo.store.ApolloStoreActivity;
import com.tencent.mobileqq.apollo.utils.ApolloConfigUtils;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForLongMsg;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.mobileqq.emoticonview.EmoticonImageView;
import com.tencent.mobileqq.emoticonview.SystemEmoticonInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.graytip.UniteGrayTipParam;
import com.tencent.mobileqq.graytip.UniteGrayTipUtil;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.pic.compress.Utils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.text.style.EmoticonSpan;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.PackageUtil;
import com.tencent.mobileqq.utils.TimeFormatterUtils;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.vas.VasH5PayUtil;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.widget.AnimationTextView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mqq.shared_file_accessor.SharedPreferencesProxyManager;
import com.tencent.open.base.MD5Utils;
import com.tencent.pb.apollousertrace.ApolloUserTrace.STClickInfo;
import com.tencent.pb.apollousertrace.ApolloUserTrace.STUserClickTrack;
import com.tencent.pb.apollousertrace.ApolloUserTrace.STUserTrackReq;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.URLUtil;
import cooperation.qzone.QZoneVipInfoManager;
import java.io.File;
import java.lang.reflect.Method;
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
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONObject;

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
  public static final int FADE_BOTTOM = 1;
  public static final int FADE_LEFT = 4;
  public static final int FADE_RIGHT = 0;
  public static final int MAX_LOG_SEGMENT_SIZE = 2048;
  private static final int NEW_ICON_MAX_SHOW_TIMES = 3;
  public static final int[] QZONE_BUBBLE_ID_LIST = { 308, 309, 310, 318, 319, 320 };
  public static final String TAG = "ApolloUtil";
  private static boolean mNeedGrayTip;
  public static Comparator<File> mResPriorityComparator;
  public static long sCurrentTimeStamp;
  public static ApolloUtilImpl.HardwareInfo sHardwareInfo;
  private static boolean sHasSmartBar;
  private static SharedPreferences sHttpProxyPreferences;
  private static boolean sIsLowDevices;
  private static int sMsAALevel;
  private static int sNewIconShowTimes;
  private static boolean sNewIconShowTimesLoaded;
  static final Pattern sPetNodeNamePattern = Pattern.compile("\\d+_pet");
  private static boolean sPopupGuideFlagLoaded;
  private static boolean sPopupGuideShown;
  public static long sRenderRunnableTimeOut;
  private static int sShownNewEmoticonSize;
  private static boolean sTestLowDevices;
  private static boolean sTestSmartBar;
  static long sid_action;
  static long sid_bubble;
  static long sid_dress;
  
  static
  {
    mNeedGrayTip = true;
    mResPriorityComparator = new ApolloUtilImpl.7();
    sTestSmartBar = false;
    sHasSmartBar = false;
    sRenderRunnableTimeOut = 100L;
    sTestLowDevices = false;
    sIsLowDevices = false;
    sMsAALevel = -2147483648;
  }
  
  public static void addApolloGrayTip(BaseChatPie paramBaseChatPie, int paramInt)
  {
    if (paramBaseChatPie == null) {}
    SessionInfo localSessionInfo;
    String str2;
    String str3;
    label119:
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
          if (((IApolloManagerService)paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IApolloManagerService.class, "all")).queryApolloSwitchSet("gameSwitch") == 1) {}
          for (int i = 1; (!bool) && (i != 0) && (paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (paramBaseChatPie.jdField_a_of_type_AndroidContentContext != null); i = 0)
          {
            str2 = localSessionInfo.jdField_a_of_type_JavaLangString;
            str3 = paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin();
            if ((!android.text.TextUtils.isEmpty(str2)) && (!android.text.TextUtils.isEmpty(str3))) {
              break label119;
            }
            QLog.d("ApolloUtil", 1, " friendUin or currentUin is null");
            return;
          }
        }
      }
      str1 = "apollo_invite_game_gray_tip_" + str3;
      localSharedPreferences = SharedPreferencesProxyManager.getInstance().getProxy("apollo_sp", 0);
      List localList = paramBaseChatPie.a().getMessageFacade().a(localSessionInfo.jdField_a_of_type_JavaLangString, localSessionInfo.jdField_a_of_type_Int, null, 1);
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
    } while ((!((Boolean)localObject1).booleanValue()) || ((paramInt != 1) && ((paramInt != 0) || (!localSharedPreferences.getBoolean(str1, true)))) || ((ApolloManagerServiceImpl)paramBaseChatPie.a().getRuntimeService(IApolloManagerService.class, "all") == null));
    long l = MessageCache.a();
    Object localObject2 = HardCodeUtil.a(2131700613);
    paramInt = ((String)localObject2).indexOf(HardCodeUtil.a(2131700616));
    Object localObject1 = new Bundle();
    ((Bundle)localObject1).putInt("key_action", 1);
    ((Bundle)localObject1).putString("textColor", "#40A0FF");
    ((Bundle)localObject1).putString("key_action_DATA", ApolloConstant.i + "&adTag=gametips");
    localObject2 = new UniteGrayTipParam(str2, str3, (String)localObject2, localSessionInfo.jdField_a_of_type_Int, -5040, 2359298, l);
    ((UniteGrayTipParam)localObject2).a(paramInt, paramInt + 7, (Bundle)localObject1);
    localObject1 = new MessageForUniteGrayTip();
    ((MessageForUniteGrayTip)localObject1).initGrayTipMsg(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (UniteGrayTipParam)localObject2);
    UniteGrayTipUtil.a(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageForUniteGrayTip)localObject1);
    if (QLog.isColorLevel()) {
      QLog.d("ApolloUtil", 2, "send apollo gray tip");
    }
    localSharedPreferences.edit().putBoolean(str1, false).commit();
    VipUtils.a(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "intro_show", ((IApolloUtil)QRoute.api(IApolloUtil.class)).getReportSessiontype(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), 0, new String[0]);
  }
  
  public static void addWhiteFaceUnSupportTips(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    if ((paramQQAppInterface == null) || (paramSessionInfo == null) || (!mNeedGrayTip)) {}
    String str2;
    String str1;
    SharedPreferences localSharedPreferences;
    do
    {
      return;
      mNeedGrayTip = false;
      localObject = paramSessionInfo.jdField_a_of_type_JavaLangString;
      str2 = paramQQAppInterface.getCurrentUin();
      str1 = "apollo_white_face_unsupport_gray_tip" + str2;
      localSharedPreferences = SharedPreferencesProxyManager.getInstance().getProxy("apollo_sp", 0);
    } while (!localSharedPreferences.getBoolean(str1, true));
    long l = MessageCache.a();
    paramSessionInfo = new UniteGrayTipParam((String)localObject, str2, HardCodeUtil.a(2131700615), paramSessionInfo.jdField_a_of_type_Int, -5040, 2359299, l);
    Object localObject = new MessageForUniteGrayTip();
    ((MessageForUniteGrayTip)localObject).initGrayTipMsg(paramQQAppInterface, paramSessionInfo);
    UniteGrayTipUtil.a(paramQQAppInterface, (MessageForUniteGrayTip)localObject);
    if (QLog.isColorLevel()) {
      QLog.d("ApolloUtil", 2, "addWhiteFaceUnSupportTips send white face unsupport gray tip");
    }
    localSharedPreferences.edit().putBoolean(str1, false).commit();
    VipUtils.a(paramQQAppInterface, "cmshow", "Apollo", "graystripe_3Demotion_view", 0, 0, new String[] { "" });
  }
  
  public static String autoSplitQzoneText(Paint paramPaint, float paramFloat, String paramString, int paramInt)
  {
    int m = 0;
    if ((android.text.TextUtils.isEmpty(paramString)) || (paramPaint == null) || (paramFloat <= 0.0F)) {
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
        char c = str.charAt(i);
        f += paramPaint.measureText(String.valueOf(c));
        if (f <= paramFloat) {
          localStringBuilder.append(c);
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
        label414:
        for (;;)
        {
          return paramString.toString();
          paramInt = i;
          for (;;)
          {
            if (paramInt < 1) {
              break label414;
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
  
  public static String autoSplitText(Paint paramPaint, float paramFloat, String paramString, int paramInt)
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
      label119:
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
      char c = str.charAt(j);
      f += paramPaint.measureText(String.valueOf(c));
      if (f <= paramFloat) {
        localStringBuilder.append(c);
      }
      for (;;)
      {
        j += 1;
        break label119;
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
  
  /* Error */
  public static String calcMd5FromAccess(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: invokestatic 430	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   5: invokevirtual 434	com/tencent/common/app/BaseApplicationImpl:getAssets	()Landroid/content/res/AssetManager;
    //   8: aload_0
    //   9: invokevirtual 440	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   12: astore_0
    //   13: aload_0
    //   14: ifnull +37 -> 51
    //   17: aload_0
    //   18: aload_0
    //   19: invokevirtual 445	java/io/InputStream:available	()I
    //   22: i2l
    //   23: invokestatic 451	com/tencent/qphone/base/util/MD5:toMD5Byte	(Ljava/io/InputStream;J)[B
    //   26: invokestatic 457	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   29: astore_1
    //   30: aload_1
    //   31: astore_2
    //   32: aload_0
    //   33: ifnull +9 -> 42
    //   36: aload_0
    //   37: invokevirtual 460	java/io/InputStream:close	()V
    //   40: aload_1
    //   41: astore_2
    //   42: aload_2
    //   43: areturn
    //   44: astore_0
    //   45: aload_0
    //   46: invokevirtual 463	java/io/IOException:printStackTrace	()V
    //   49: aload_1
    //   50: areturn
    //   51: aload_0
    //   52: ifnull -10 -> 42
    //   55: aload_0
    //   56: invokevirtual 460	java/io/InputStream:close	()V
    //   59: aconst_null
    //   60: areturn
    //   61: astore_0
    //   62: aload_0
    //   63: invokevirtual 463	java/io/IOException:printStackTrace	()V
    //   66: aconst_null
    //   67: areturn
    //   68: astore_0
    //   69: aconst_null
    //   70: astore_0
    //   71: aload_0
    //   72: ifnull -30 -> 42
    //   75: aload_0
    //   76: invokevirtual 460	java/io/InputStream:close	()V
    //   79: aconst_null
    //   80: areturn
    //   81: astore_0
    //   82: aload_0
    //   83: invokevirtual 463	java/io/IOException:printStackTrace	()V
    //   86: aconst_null
    //   87: areturn
    //   88: astore_1
    //   89: aconst_null
    //   90: astore_0
    //   91: aload_0
    //   92: ifnull +7 -> 99
    //   95: aload_0
    //   96: invokevirtual 460	java/io/InputStream:close	()V
    //   99: aload_1
    //   100: athrow
    //   101: astore_0
    //   102: aload_0
    //   103: invokevirtual 463	java/io/IOException:printStackTrace	()V
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
  
  public static boolean check3DFaceRes(String paramString)
  {
    if (android.text.TextUtils.isEmpty(paramString)) {}
    do
    {
      return true;
      paramString = MD5Utils.toMD5(paramString);
      paramString = new File("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/dress//face/" + paramString + File.separator + paramString + ".zip");
    } while (paramString.exists());
    toastDebugError(paramString + HardCodeUtil.a(2131700607));
    if (QLog.isColorLevel()) {
      QLog.d("ApolloUtil", 2, "ErrorInfo-> " + paramString + " NOT exist.");
    }
    return false;
  }
  
  public static boolean checkDressRes(int paramInt)
  {
    boolean bool = true;
    if (QLog.isColorLevel()) {
      QLog.d("ApolloUtil", 2, "[checkDressRes], dressId:" + paramInt);
    }
    File localFile = new File("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/dress/" + paramInt);
    if (paramInt < 21) {
      localFile = new File(ApolloConstant.jdField_a_of_type_JavaLangString, "/def/basic/dress/" + paramInt);
    }
    if (!localFile.exists())
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloUtil", 2, "dir NOT exist." + localFile.getPath());
      }
      return false;
    }
    if (paramInt >= ApolloConstant.b)
    {
      if ((isFileExistAndLenNot0(localFile.getAbsolutePath() + "/" + "dress.bin")) || (isFileExistAndLenNot0(localFile.getAbsolutePath() + "/" + "face.json"))) {}
      for (bool = true;; bool = false) {
        return bool;
      }
    }
    if ((isFileExistAndLenNot0(localFile.getAbsolutePath() + "/" + "dress.json")) && (isFileExistAndLenNot0(localFile.getAbsolutePath() + "/" + "dress.atlas")) && (isFileExistAndLenNot0(localFile.getAbsolutePath() + "/" + "dress.png"))) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public static void checkJsonParse(AppInterface paramAppInterface)
  {
    ThreadManager.getFileThreadHandler().post(new ApolloUtilImpl.11(paramAppInterface));
  }
  
  public static boolean checkNotFullScreen()
  {
    String str = Build.MODEL;
    if (QLog.isColorLevel()) {
      QLog.d("ApolloUtil", 2, "checkNotFullScreen model:" + str);
    }
    if (android.text.TextUtils.isEmpty(str)) {}
    do
    {
      return false;
      if (!android.text.TextUtils.isEmpty(ApolloConfigUtils.jdField_a_of_type_JavaLangString)) {
        return ApolloConfigUtils.jdField_a_of_type_JavaLangString.contains(str);
      }
    } while (!str.contains("SM-G8870"));
    return true;
  }
  
  public static boolean checkRoleRes(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloUtil", 2, "[checkRoleRes], roleId:" + paramInt);
    }
    File localFile1;
    if (paramInt == 0)
    {
      localFile1 = new File(ApolloConstant.jdField_a_of_type_JavaLangString, "/def/basic/skeleton/" + paramInt);
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
      localFile1 = new File("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/role/" + paramInt);
      break;
      localFile2 = new File(localFile1, "config.json");
      if ((paramInt == 0) || (localFile2.exists())) {
        break label252;
      }
      toastDebugError(localFile2.getPath() + HardCodeUtil.a(2131700627));
      SpriteUtil.a(0, new Object[] { "ROLE_FILE_CONFIG_NAME NOT exist.", localFile2.getPath() });
    } while (!QLog.isColorLevel());
    QLog.d("ApolloUtil", 2, "ROLE_FILE_CONFIG_NAME NOT exist." + localFile2.getPath());
    return false;
    label252:
    if (paramInt >= ApolloConstant.b) {
      return isFileExistAndLenNot0(localFile1.getAbsolutePath() + "/" + "skeleton.bin");
    }
    if ((isFileExistAndLenNot0(localFile1.getAbsolutePath() + "/" + "role.json")) && (isFileExistAndLenNot0(localFile1.getAbsolutePath() + "/" + "role.atlas")) && (isFileExistAndLenNot0(localFile1.getAbsolutePath() + "/" + "role.png"))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public static boolean checkRoomRes(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloUtil", 2, "[checkRoomRes], roomId:" + paramInt);
    }
    File localFile = new File("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/room/" + paramInt);
    if (!localFile.exists())
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloUtil", 2, "dir NOT exist." + localFile.getPath());
      }
      return false;
    }
    return isFileExistAndLenNot0(localFile.getAbsolutePath() + "/dress");
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
  
  private static int convertEmoticonActionId(int paramInt)
  {
    if (paramInt < 229) {
      return paramInt + 10000;
    }
    return paramInt + 20000;
  }
  
  private static int convertEmoticonActionId(ApolloDaoManagerServiceImpl paramApolloDaoManagerServiceImpl, int paramInt1, int paramInt2)
  {
    if (((paramApolloDaoManagerServiceImpl.mWhiteFaceIdMapping == null) || (paramApolloDaoManagerServiceImpl.mWhiteFaceIdMapping.size() == 0)) && (paramInt2 == 1)) {
      return convertEmoticonActionId(paramInt1);
    }
    return paramApolloDaoManagerServiceImpl.getWhiteFaceIdMapping(paramInt1, paramInt2);
  }
  
  public static ApolloUserTrace.STUserTrackReq convertJson2JavaObj(String paramString)
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
  
  public static void dealUnzip(String paramString1, String paramString2, ApolloUtilImpl.DownLoadHandler paramDownLoadHandler) {}
  
  public static void deleteGameResIfNeed()
  {
    ThreadManager.post(new ApolloUtilImpl.6(), 5, null, true);
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
      QLog.e("ApolloUtil", 1, paramString.getMessage());
    }
    return "";
  }
  
  public static void endTrace(String paramString)
  {
    if (QLog.isColorLevel())
    {
      long l = System.currentTimeMillis();
      QLog.d("ApolloUtil", 2, "[endTrace] " + paramString + " cost:" + (l - sCurrentTimeStamp));
      sCurrentTimeStamp = l;
    }
  }
  
  public static void forwardImage_Common(Activity paramActivity, String paramString1, String paramString2, int paramInt)
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
  
  public static String getAPolloTabUrl(ApolloActionPackage paramApolloActionPackage)
  {
    return null;
  }
  
  public static boolean getActionListFormMessage(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, MessageRecord paramMessageRecord, List<Integer> paramList)
  {
    if (paramMessageRecord == null) {
      return false;
    }
    Object localObject;
    int j;
    if ((paramMessageRecord instanceof MessageForText))
    {
      localObject = paramMessageRecord.msg;
      j = getWhiteFacePlayModel(paramQQAppInterface, paramMessageRecord);
      paramMessageRecord = (IApolloManagerService)paramQQAppInterface.getRuntimeService(IApolloManagerService.class, "all");
      if (paramMessageRecord.queryApolloSwitchSet("whiteFace3D") != 1) {
        break label269;
      }
      i = 1;
      label54:
      if ((j != 2) || (i != 0)) {
        break label315;
      }
    }
    label269:
    label315:
    for (int i = 0;; i = 1)
    {
      if (j == 0) {
        QLog.w("ApolloUtil", 1, "getActionListFormMessage err user status");
      }
      ApolloDaoManagerServiceImpl localApolloDaoManagerServiceImpl = (ApolloDaoManagerServiceImpl)paramQQAppInterface.getRuntimeService(IApolloDaoManagerService.class, "all");
      localObject = new QQText((CharSequence)localObject, 2);
      EmoticonSpan[] arrayOfEmoticonSpan = (EmoticonSpan[])((QQText)localObject).getSpans(0, ((QQText)localObject).length(), EmoticonSpan.class);
      if ((arrayOfEmoticonSpan != null) && (arrayOfEmoticonSpan.length > 0) && (i != 0))
      {
        int k = arrayOfEmoticonSpan.length;
        i = 0;
        for (;;)
        {
          if (i < k)
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
            continue;
            if (!(paramMessageRecord instanceof MessageForLongMsg)) {
              break;
            }
            localObject = (MessageForLongMsg)paramMessageRecord;
            if (android.text.TextUtils.isEmpty(((MessageForLongMsg)localObject).sb2)) {}
            for (localObject = ((MessageForLongMsg)localObject).sb;; localObject = ((MessageForLongMsg)localObject).sb2) {
              break;
            }
            i = 0;
            break label54;
          }
        }
      }
      if ((paramList.size() == 0) && (1 == paramMessageRecord.getApolloUserStatus(paramQQAppInterface))) {
        getKeywordsActionList(paramQQAppInterface, paramSessionInfo, (QQText)localObject, paramList);
      }
      for (boolean bool = true;; bool = false) {
        return bool;
      }
    }
  }
  
  public static ArrayList<Integer> getAddedFaceList(QQAppInterface paramQQAppInterface)
  {
    int i = 0;
    if (paramQQAppInterface == null) {
      paramQQAppInterface = null;
    }
    for (;;)
    {
      return paramQQAppInterface;
      localArrayList = new ArrayList();
      Object localObject = BaseApplicationImpl.getContext().getSharedPreferences("apollo_sp", 0).getString("sp_key_apollo_game_life" + paramQQAppInterface.getCurrentUin(), "");
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
  
  public static String getApolloDrawerPath(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder(50);
    localStringBuilder.append("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/drawer_action/").append(paramInt);
    return localStringBuilder.toString();
  }
  
  public static String getApolloDrawerUrl(int paramInt)
  {
    if (paramInt == -1) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder("https://cmshow.gtimg.cn/qqshow/admindata/comdata/vipApollo_drawerAction_");
    localStringBuilder.append(paramInt).append("/d.zip");
    return localStringBuilder.toString();
  }
  
  public static String getApolloFileDir(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo";
    case 1: 
      return ApolloConstant.jdField_a_of_type_JavaLangString;
    }
    return BaseApplicationImpl.getApplication().getFilesDir() + "";
  }
  
  public static String getApolloGameLuaPath(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder(100);
    if ((paramInt == 1) || (paramInt == 2)) {
      localStringBuilder.append("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/game/").append(paramInt).append(File.separator).append("main.lua");
    }
    for (;;)
    {
      return localStringBuilder.toString();
      localStringBuilder.append("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/game/").append(paramInt).append(File.separator).append("main.js");
    }
  }
  
  public static String getApolloGameResPath(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder(100);
    localStringBuilder.append("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/game/").append(paramInt);
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
    QQAppInterface localQQAppInterface = ((IApolloUtil)QRoute.api(IApolloUtil.class)).getQQApp();
    if (localQQAppInterface != null) {
      return (ApolloManagerServiceImpl)localQQAppInterface.getRuntimeService(IApolloManagerService.class, "all");
    }
    return null;
  }
  
  public static long getApolloPanelBattleGameLastRequestTime(QQAppInterface paramQQAppInterface, int paramInt)
  {
    if (paramQQAppInterface == null)
    {
      QLog.e("ApolloUtil", 1, "[getApolloPanelBattleGameLastRequestTime] app is null!");
      return -1L;
    }
    return BaseApplicationImpl.getContext().getSharedPreferences("apollo_sp", 0).getLong("sp_key_apollo_panel_battle_game_last_request_time" + paramQQAppInterface.getCurrentUin() + paramInt, 300000L);
  }
  
  public static long getApolloPanelBattleGameRequestInterval(QQAppInterface paramQQAppInterface, int paramInt)
  {
    if (paramQQAppInterface == null)
    {
      QLog.e("ApolloUtil", 1, "[getApolloPanelBattleGameRequestInterval] app is null!");
      return -1L;
    }
    return BaseApplicationImpl.getContext().getSharedPreferences("apollo_sp", 0).getLong("sp_key_apollo_panel_battle_game_request_interval" + paramQQAppInterface.getCurrentUin() + paramInt, 0L);
  }
  
  public static String getApolloPanelFramePath(int paramInt)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/action/").append(paramInt).append("/panelAction");
    return localStringBuffer.toString();
  }
  
  public static String getApolloResPath(ApolloActionData paramApolloActionData, int paramInt)
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
      localStringBuilder.append("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/action/").append(paramApolloActionData.actionId).append(File.separator).append("panelView.png");
      continue;
      localStringBuilder.append("https://cmshow.gtimg.cn/qqshow/admindata/comdata/vipApollo_action_").append(paramApolloActionData.actionId).append("/preview.png");
      continue;
      localStringBuilder.append("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/action/").append(paramApolloActionData.actionId).append(File.separator).append("panelGif.gif");
      continue;
      localStringBuilder.append("https://cmshow.gtimg.cn/qqshow/admindata/comdata/vipApollo_action_").append(paramApolloActionData.actionId).append("/preview.gif");
      continue;
      localStringBuilder.append("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/action/").append(paramApolloActionData.actionId).append(File.separator).append("actionRes.zip");
      continue;
      localStringBuilder.append("https://cmshow.gtimg.cn/qqshow/admindata/comdata/vipApollo_action_").append(paramApolloActionData.actionId).append("/d.zip");
      continue;
      localStringBuilder.append("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/action/").append(paramApolloActionData.actionId).append(File.separator);
      continue;
      localStringBuilder.append("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/action/").append(paramApolloActionData.actionId).append(File.separator).append("config.json");
      continue;
      localStringBuilder.append("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/ai/action/").append(paramApolloActionData.actionId);
      continue;
      localStringBuilder.append("https://cmshow.gtimg.cn/qqshow/admindata/comdata/vipApollo_drawerAction_").append(paramApolloActionData.actionId).append("/d.zip");
      continue;
      localStringBuilder.append("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/frame/").append(paramApolloActionData.actionId).append(File.separator).append(getCurrentUin()).append("_frame.png");
    }
  }
  
  public static String getApolloTabResPath(ApolloActionPackage paramApolloActionPackage)
  {
    if (paramApolloActionPackage == null) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder(100);
    localStringBuilder.append("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/action/packages/").append(paramApolloActionPackage.packageId).append(File.separator).append("tab.png");
    return localStringBuilder.toString();
  }
  
  public static String getAudioPathForAction(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/action/").append(paramInt).append(File.separator).append("action/").append("music.amr");
    String str = localStringBuilder.toString();
    Object localObject = str;
    if (!FileUtils.a(str))
    {
      int i = str.length();
      localStringBuilder.delete(str.length() - "music.amr".length(), i);
      localStringBuilder.append("music/");
      localObject = localStringBuilder.toString();
      if (!FileUtils.a((String)localObject)) {
        break label284;
      }
      localObject = new File((String)localObject).list(new ApolloUtilImpl.5());
      if (localObject == null) {
        break label268;
      }
      switch (localObject.length)
      {
      default: 
        Arrays.sort((Object[])localObject);
        i = getPositiveRandomInteger(localObject.length);
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
      label268:
      localObject = "";
      QLog.e("ApolloUtil", 1, "[getAudioPathForAction] file not found even one");
      continue;
      label284:
      localObject = "";
      QLog.e("ApolloUtil", 1, "[getAudioPathForAction] file dir not found ");
    }
  }
  
  public static IApolloCmdChannel getCmdChannel()
  {
    Object localObject = ((IApolloUtil)QRoute.api(IApolloUtil.class)).getAppInterface();
    if (localObject != null) {}
    for (localObject = (IApolloCmdChannel)((AppRuntime)localObject).getRuntimeService(IApolloCmdChannel.class, "all"); localObject == null; localObject = null) {
      throw new RuntimeException("Apollo getCmdChannel return null Exception");
    }
    return localObject;
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
    Drawable localDrawable = BaseApplicationImpl.getContext().getResources().getDrawable(2130838628);
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
  
  public static String getDisplayActionName(QQAppInterface paramQQAppInterface, MessageForApollo paramMessageForApollo)
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
  
  public static final byte[] getFakeMsgText()
  {
    try
    {
      byte[] arrayOfByte = HardCodeUtil.a(2131700619).getBytes();
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
  
  public static File getFile(String paramString1, String paramString2)
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
  
  public static long getFirstIntegerFromStr(String paramString)
  {
    int i = 0;
    if (android.text.TextUtils.isEmpty(paramString)) {
      return 0L;
    }
    String str = paramString;
    if (paramString.contains("def/role/0/")) {
      str = matchLastIntegerStr(paramString);
    }
    paramString = new StringBuilder(8);
    int j = 0;
    if (i < str.length())
    {
      char c = str.charAt(i);
      int k;
      if ((c > '/') && (c < ':'))
      {
        paramString.append(c);
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
  
  public static Bitmap getGameIcon(AppInterface paramAppInterface, CmGameStartChecker.StartCheckParam paramStartCheckParam)
  {
    if ((paramStartCheckParam == null) || (paramAppInterface == null)) {
      return null;
    }
    if (paramStartCheckParam.game != null) {}
    for (Object localObject1 = paramStartCheckParam.game.logoUrl;; localObject1 = null)
    {
      Object localObject2 = localObject1;
      if (android.text.TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject2 = String.format(Locale.getDefault(), "https://i.hudongcdn.com/%1$d/sp_main_1_1.png", new Object[] { Integer.valueOf(paramStartCheckParam.gameId) });
      }
      localObject1 = new File("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/game/" + paramStartCheckParam.gameId + File.separator + "apollo_dwonload_game_icon.png");
      if (!((File)localObject1).exists())
      {
        ((File)localObject1).getParentFile().mkdir();
        localObject2 = new DownloadTask((String)localObject2, (File)localObject1);
        ((DownloadTask)localObject2).p = false;
        ((DownloadTask)localObject2).n = true;
        ((DownloadTask)localObject2).f = "apollo_res";
        ((DownloadTask)localObject2).b = 1;
        ((DownloadTask)localObject2).q = true;
        ((DownloadTask)localObject2).r = true;
        int i = DownloaderFactory.a((DownloadTask)localObject2, paramAppInterface);
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
  
  public static SharedPreferences getGameResSp()
  {
    int i = 0;
    if (BaseApplicationImpl.sProcessId != 1) {
      i = 4;
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
      QLog.e("ApolloUtil", 1, "getHardwareInfo e:", localException);
    }
    return null;
  }
  
  public static long getJsonLongValue(String paramString1, String paramString2)
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
  
  public static String getJsonStrValue(String paramString1, String paramString2)
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
  
  public static String getKapuPkgName()
  {
    String str2 = App3DConfig.jdField_a_of_type_JavaLangString;
    String str1 = str2;
    if (android.text.TextUtils.isEmpty(str2)) {
      str1 = "com.tencent.kapu";
    }
    return str1;
  }
  
  private static void getKeywordsActionList(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, QQText paramQQText, List<Integer> paramList)
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
      } while (!((ApolloManagerServiceImpl)paramQQAppInterface.getRuntimeService(IApolloManagerService.class, "all")).isApolloBackgroundActionSwitchOpen());
      l1 = System.currentTimeMillis();
      paramQQText = paramQQText.trim();
      localObject = (ApolloDaoManagerServiceImpl)paramQQAppInterface.getRuntimeService(IApolloDaoManagerService.class, "all");
      localHashMap = ((ApolloDaoManagerServiceImpl)localObject).getActionKeywordsMap();
    } while ((localHashMap == null) || (localHashMap.size() == 0));
    int i1 = ((ApolloDaoManagerServiceImpl)localObject).getMaxKeywordsLength();
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
              reportKeywordsAction(((Integer)localHashMap.get(localObject)).intValue(), (String)localObject, paramQQAppInterface, paramSessionInfo);
              n = m - 1 + i;
              k = j + 1;
            }
          }
        }
        else
        {
          if (k != 30) {
            break label277;
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
      label277:
      i = n + 1;
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
            break label177;
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
        label177:
        paramInt1 = m + 1;
      }
    }
    return j;
  }
  
  private static String getNewIconShowFlagKey()
  {
    if (SystemEmoticonInfo.sNewApolloEmoticonMap.containsKey("8.5.5"))
    {
      Object localObject = (List)SystemEmoticonInfo.sNewApolloEmoticonMap.get("8.5.5");
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
  
  public static int getPlayActionId(ISpriteContext paramISpriteContext, MessageForApollo paramMessageForApollo)
  {
    if ((paramMessageForApollo == null) || (paramMessageForApollo.mApolloMessage == null)) {
      throw new IllegalArgumentException("getPlayActionId, apolloMsg null");
    }
    int i = paramMessageForApollo.mApolloMessage.id;
    QQAppInterface localQQAppInterface = ((IApolloUtil)QRoute.api(IApolloUtil.class)).getQQApp();
    if ((localQQAppInterface != null) && (paramMessageForApollo.mApollo3DMessage != null) && (ApolloActionData.isAction3DModel(paramMessageForApollo.mApollo3DMessage.actionID_3D)) && ((((IApolloManagerService)localQQAppInterface.getRuntimeService(IApolloManagerService.class, "all")).is3dAvailable(localQQAppInterface)) || (paramISpriteContext.d()))) {
      return paramMessageForApollo.mApollo3DMessage.actionID_3D;
    }
    return i;
  }
  
  public static int getPlayActionType(ISpriteContext paramISpriteContext, MessageForApollo paramMessageForApollo)
  {
    if ((paramMessageForApollo == null) || (paramMessageForApollo.mApolloMessage == null)) {
      throw new IllegalArgumentException("getPlayActionType, apolloMsg null");
    }
    QQAppInterface localQQAppInterface = ((IApolloUtil)QRoute.api(IApolloUtil.class)).getQQApp();
    int i = paramMessageForApollo.actionType;
    if ((localQQAppInterface != null) && (paramMessageForApollo.mApollo3DMessage != null) && (ApolloActionData.isAction3DModel(paramMessageForApollo.mApollo3DMessage.actionID_3D)))
    {
      if ((((IApolloManagerService)localQQAppInterface.getRuntimeService(IApolloManagerService.class, "all")).is3dAvailable(localQQAppInterface)) || (paramISpriteContext.d())) {
        return paramMessageForApollo.mApollo3DMessage.actionType_3D;
      }
      paramISpriteContext = ((ApolloDaoManagerServiceImpl)localQQAppInterface.getRuntimeService(IApolloDaoManagerService.class, "all")).findActionById(paramMessageForApollo.mApolloMessage.id);
      if (paramISpriteContext != null) {
        return paramISpriteContext.actionType;
      }
    }
    return i;
  }
  
  private static String getPopupShowFlagKey()
  {
    if (SystemEmoticonInfo.sNewApolloEmoticonMap.containsKey("8.5.5"))
    {
      Object localObject = (List)SystemEmoticonInfo.sNewApolloEmoticonMap.get("8.5.5");
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
  
  public static int getPositiveRandomInteger(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= 2147483647))
    {
      QLog.e("ApolloUtil", 1, "[getRandomInteger] invalid " + paramInt);
      return 0;
    }
    return new Random().nextInt(paramInt);
  }
  
  public static int getQAioType(int paramInt)
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
  
  private static int getQzoneLineCount(float paramFloat, String paramString, int paramInt1, int paramInt2)
  {
    Object localObject = new TextView(BaseApplicationImpl.getContext());
    ((TextView)localObject).setTextSize(paramInt1 * 3 / DeviceInfoUtil.a);
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
  
  public static String getReportUserApolloModelType(long paramLong)
  {
    if (2L == paramLong) {
      return "3D";
    }
    if (1L == paramLong) {
      return "2D";
    }
    return "UNKNOWN";
  }
  
  public static String getRobotOpenId(MessageForApollo paramMessageForApollo)
  {
    if (paramMessageForApollo == null) {}
    while (android.text.TextUtils.isEmpty(paramMessageForApollo.extendJson)) {
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
  
  public static int getShareMsgActionId(QQAppInterface paramQQAppInterface, MessageForArkApp paramMessageForArkApp)
  {
    if ((paramMessageForArkApp == null) || (paramQQAppInterface == null)) {
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
    for (;;)
    {
      try
      {
        paramMessageForArkApp = new JSONObject(paramMessageForArkApp).optJSONObject("data");
        if (paramMessageForArkApp != null) {
          i = paramMessageForArkApp.optInt("actionId");
        }
        int i = 0;
      }
      catch (Exception paramQQAppInterface)
      {
        try
        {
          if ((i > ApolloConstant.b) && (!((IApolloManagerService)paramQQAppInterface.getRuntimeService(IApolloManagerService.class, "all")).is3dAvailable(paramQQAppInterface)))
          {
            if (QLog.isColorLevel()) {
              QLog.d("ApolloUtil", 2, new Object[] { "getShareMsgActionId 3d not available actionId:", Integer.valueOf(i) });
            }
            return 0;
          }
          return i;
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
    }
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
    if (android.text.TextUtils.isEmpty(paramString)) {}
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
    if ((paramQQAppInterface == null) || (paramMessageRecord == null)) {
      return 0;
    }
    IApolloManagerService localIApolloManagerService = (IApolloManagerService)paramQQAppInterface.getRuntimeService(IApolloManagerService.class, "all");
    int i = localIApolloManagerService.getApolloUserStatus(paramQQAppInterface);
    if (i == 0) {
      return 0;
    }
    int j = localIApolloManagerService.getCmShowStatus(paramQQAppInterface, paramMessageRecord.senderuin);
    if (((j == 2) && (localIApolloManagerService.is3dAvailable(paramQQAppInterface))) || ((j == 0) && (i == 2))) {
      return 2;
    }
    return 1;
  }
  
  public static int handleAITextType(float paramFloat, String paramString)
  {
    if ((android.text.TextUtils.isEmpty(paramString)) || (paramFloat <= 0.0F)) {}
    int i;
    do
    {
      return 43;
      i = getLineCount(paramFloat, paramString, 8, 6);
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
      if (!android.text.TextUtils.isEmpty(ApolloRender.sNativeVersion)) {
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
      TraceReportUtil.a(20, 1, i, new Object[] { localStringBuilder.toString() });
      return;
      i = 30;
      if (paramString1.contains("NullPointerException")) {
        i = 31;
      }
    }
  }
  
  public static int handleBubbleType(float paramFloat, String paramString, int paramInt)
  {
    if ((android.text.TextUtils.isEmpty(paramString)) || (paramFloat <= 0.0F)) {}
    do
    {
      return 24;
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
    } while (paramInt != 2);
    return 73;
  }
  
  public static int handleQzoneBubbleType(float paramFloat, String paramString, int paramInt)
  {
    if ((android.text.TextUtils.isEmpty(paramString)) || (paramFloat <= 0.0F)) {
      return 24;
    }
    int i = getQzoneLineCount(paramFloat, paramString, 13, 3);
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
  
  public static boolean hasSmartBar()
  {
    if (sTestSmartBar) {
      return sHasSmartBar;
    }
    if (!Build.MANUFACTURER.equals("Meizu"))
    {
      sTestSmartBar = true;
      sHasSmartBar = false;
      return sHasSmartBar;
    }
    try
    {
      Method localMethod = Class.forName("android.os.Build").getMethod("hasSmartBar", new Class[0]);
      sTestSmartBar = true;
      sHasSmartBar = false;
      sHasSmartBar = ((Boolean)localMethod.invoke(null, new Object[0])).booleanValue();
      boolean bool = sHasSmartBar;
      return bool;
    }
    catch (Exception localException)
    {
      if (Build.DEVICE.equals("mx2"))
      {
        sTestSmartBar = true;
        sHasSmartBar = true;
        return sTestSmartBar;
      }
      if ((Build.DEVICE.equals("mx")) || (Build.DEVICE.equals("m9")))
      {
        sTestSmartBar = true;
        sHasSmartBar = false;
        return sHasSmartBar;
      }
    }
    return false;
  }
  
  public static ApolloUtilImpl.ClickInfo hitTest(float paramFloat1, float paramFloat2, List<ApolloSkeletonBounding> paramList)
  {
    ApolloUtilImpl.ClickInfo localClickInfo = new ApolloUtilImpl.ClickInfo();
    localClickInfo.jdField_a_of_type_Int = -1;
    localClickInfo.jdField_a_of_type_JavaLangString = "";
    if (QLog.isColorLevel()) {
      QLog.d("ApolloSkeletonBounding", 2, new Object[] { "all bounding:", paramList });
    }
    Object localObject1 = paramList.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (ApolloSkeletonBounding)((Iterator)localObject1).next();
      if ((((ApolloSkeletonBounding)localObject2).giftHeight > 0.0F) && (((ApolloSkeletonBounding)localObject2).giftWidth > 0.0F) && (paramFloat1 >= ((ApolloSkeletonBounding)localObject2).giftX) && (paramFloat1 <= ((ApolloSkeletonBounding)localObject2).giftX + ((ApolloSkeletonBounding)localObject2).giftWidth) && (paramFloat2 >= ((ApolloSkeletonBounding)localObject2).giftY) && (paramFloat2 <= ((ApolloSkeletonBounding)localObject2).giftY + ((ApolloSkeletonBounding)localObject2).giftHeight))
      {
        localClickInfo.jdField_a_of_type_Int = 2;
        if (android.text.TextUtils.isEmpty(((ApolloSkeletonBounding)localObject2).extendString)) {}
        for (paramList = ((ApolloSkeletonBounding)localObject2).name;; paramList = ((ApolloSkeletonBounding)localObject2).extendString)
        {
          localClickInfo.jdField_a_of_type_JavaLangString = paramList;
          if (QLog.isColorLevel()) {
            QLog.d("ApolloSkeletonBounding", 2, "gift mNode:" + localClickInfo.jdField_a_of_type_Int + ",mApolloId=" + localClickInfo.jdField_a_of_type_JavaLangString);
          }
          return localClickInfo;
        }
      }
    }
    localObject1 = new ArrayList();
    Object localObject2 = paramList.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      ApolloSkeletonBounding localApolloSkeletonBounding = (ApolloSkeletonBounding)((Iterator)localObject2).next();
      if (localApolloSkeletonBounding.brandMode != -1001)
      {
        if (((localApolloSkeletonBounding.brand2Width > 0.0F) && (localApolloSkeletonBounding.brand2Height > 0.0F) && (paramFloat1 >= localApolloSkeletonBounding.brand2X) && (paramFloat1 <= localApolloSkeletonBounding.brand2X + localApolloSkeletonBounding.brand2Width) && (paramFloat2 >= localApolloSkeletonBounding.brand2Y) && (paramFloat2 <= localApolloSkeletonBounding.brand2Y + localApolloSkeletonBounding.brand2Height)) || ((localApolloSkeletonBounding.brand1Width > 0.0F) && (localApolloSkeletonBounding.brand1Height > 0.0F) && (paramFloat1 >= localApolloSkeletonBounding.brand1X) && (paramFloat1 <= localApolloSkeletonBounding.brand1X + localApolloSkeletonBounding.brand1Width) && (paramFloat2 >= localApolloSkeletonBounding.brand1Y) && (paramFloat2 <= localApolloSkeletonBounding.brand1Y + localApolloSkeletonBounding.brand1Height)))
        {
          localClickInfo.jdField_a_of_type_Int = 3;
          if (android.text.TextUtils.isEmpty(localApolloSkeletonBounding.extendString)) {}
          for (paramList = localApolloSkeletonBounding.name;; paramList = localApolloSkeletonBounding.extendString)
          {
            localClickInfo.jdField_a_of_type_JavaLangString = paramList;
            if (QLog.isColorLevel()) {
              QLog.d("ApolloSkeletonBounding", 2, "sprite brand, mNode:" + localClickInfo.jdField_a_of_type_Int + ",mApolloId=" + localClickInfo.jdField_a_of_type_JavaLangString);
            }
            return localClickInfo;
          }
        }
      }
      else {
        ((List)localObject1).add(localApolloSkeletonBounding);
      }
    }
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (ApolloSkeletonBounding)((Iterator)localObject1).next();
      if ((((ApolloSkeletonBounding)localObject2).brandMode == -1001) && (((ApolloSkeletonBounding)localObject2).brand1Width > 0.0F) && (((ApolloSkeletonBounding)localObject2).brand1Height > 0.0F) && (paramFloat1 >= ((ApolloSkeletonBounding)localObject2).brand1X) && (paramFloat1 <= ((ApolloSkeletonBounding)localObject2).brand1X + ((ApolloSkeletonBounding)localObject2).brand1Width) && (paramFloat2 >= ((ApolloSkeletonBounding)localObject2).brand1Y) && (paramFloat2 <= ((ApolloSkeletonBounding)localObject2).brand1Y + ((ApolloSkeletonBounding)localObject2).brand1Height))
      {
        localClickInfo.jdField_a_of_type_Int = 4;
        if (android.text.TextUtils.isEmpty(((ApolloSkeletonBounding)localObject2).extendString)) {}
        for (paramList = ((ApolloSkeletonBounding)localObject2).name;; paramList = ((ApolloSkeletonBounding)localObject2).extendString)
        {
          localClickInfo.jdField_a_of_type_JavaLangString = paramList;
          if (QLog.isColorLevel()) {
            QLog.d("ApolloSkeletonBounding", 2, "pet brand, mNode:" + localClickInfo.jdField_a_of_type_Int + ",mApolloId=" + localClickInfo.jdField_a_of_type_JavaLangString);
          }
          return localClickInfo;
        }
      }
    }
    localObject1 = paramList.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (ApolloSkeletonBounding)((Iterator)localObject1).next();
      if ((((ApolloSkeletonBounding)localObject2).bubbleWidth > 0.0F) && (((ApolloSkeletonBounding)localObject2).bubbleHeight > 0.0F) && (paramFloat1 >= ((ApolloSkeletonBounding)localObject2).bubbleX) && (paramFloat1 <= ((ApolloSkeletonBounding)localObject2).bubbleX + ((ApolloSkeletonBounding)localObject2).bubbleWidth) && (paramFloat2 >= ((ApolloSkeletonBounding)localObject2).bubbleY) && (paramFloat2 <= ((ApolloSkeletonBounding)localObject2).bubbleY + ((ApolloSkeletonBounding)localObject2).bubbleHeight))
      {
        localClickInfo.jdField_a_of_type_Int = 1000;
        if (android.text.TextUtils.isEmpty(((ApolloSkeletonBounding)localObject2).extendString)) {}
        for (paramList = ((ApolloSkeletonBounding)localObject2).name;; paramList = ((ApolloSkeletonBounding)localObject2).extendString)
        {
          localClickInfo.jdField_a_of_type_JavaLangString = paramList;
          if (QLog.isColorLevel()) {
            QLog.d("ApolloSkeletonBounding", 2, "bubble, mNode:" + localClickInfo.jdField_a_of_type_Int + ",mApolloId=" + localClickInfo.jdField_a_of_type_JavaLangString);
          }
          return localClickInfo;
        }
      }
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      localObject1 = (ApolloSkeletonBounding)paramList.next();
      if ((paramFloat1 >= ((ApolloSkeletonBounding)localObject1).x) && (paramFloat1 <= ((ApolloSkeletonBounding)localObject1).x + ((ApolloSkeletonBounding)localObject1).width) && (paramFloat2 >= ((ApolloSkeletonBounding)localObject1).y) && (paramFloat2 <= ((ApolloSkeletonBounding)localObject1).y + ((ApolloSkeletonBounding)localObject1).height))
      {
        localClickInfo.jdField_a_of_type_Int = 1;
        if (android.text.TextUtils.isEmpty(((ApolloSkeletonBounding)localObject1).extendString)) {}
        for (paramList = ((ApolloSkeletonBounding)localObject1).name;; paramList = ((ApolloSkeletonBounding)localObject1).extendString)
        {
          localClickInfo.jdField_a_of_type_JavaLangString = paramList;
          if (!android.text.TextUtils.isEmpty(localClickInfo.jdField_a_of_type_JavaLangString))
          {
            paramList = sPetNodeNamePattern.matcher(localClickInfo.jdField_a_of_type_JavaLangString);
            if ((paramList != null) && (paramList.matches())) {
              localClickInfo.jdField_a_of_type_Int = 5;
            }
          }
          if (QLog.isColorLevel()) {
            QLog.d("ApolloSkeletonBounding", 2, "other cmshow area, mNode:" + localClickInfo.jdField_a_of_type_Int + ",mApolloId=" + localClickInfo.jdField_a_of_type_JavaLangString);
          }
          return localClickInfo;
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("ApolloSkeletonBounding", 2, "not cmshow area, mNode:" + localClickInfo.jdField_a_of_type_Int + ",mApolloId=" + localClickInfo.jdField_a_of_type_JavaLangString);
    }
    return localClickInfo;
  }
  
  public static boolean is3DActionPathRscDone(String paramString)
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
    return isFileExistAndLenNot0(paramString.getAbsolutePath() + "/action/" + "action.bin");
  }
  
  public static boolean isActionDone(ApolloActionData paramApolloActionData)
  {
    if (paramApolloActionData == null) {}
    boolean bool;
    do
    {
      return false;
      bool = true;
      if (!FileUtil.a(getApolloResPath(paramApolloActionData, 0))) {
        bool = false;
      }
    } while (!isActionResDone(paramApolloActionData.actionId, paramApolloActionData.personNum));
    return bool;
  }
  
  public static boolean isActionPanelFrameResDone(int paramInt1, int paramInt2)
  {
    boolean bool = true;
    File localFile = new File(getApolloPanelFramePath(paramInt1));
    if (!localFile.exists()) {
      QLog.e("ApolloUtil", 1, "isActionPanelFrameResDone, dir NOT exist." + localFile.getPath());
    }
    label181:
    do
    {
      for (;;)
      {
        return false;
        if (paramInt1 >= ApolloConstant.b) {
          break label298;
        }
        if ((isFileExistAndLenNot0(localFile.getAbsolutePath() + "/" + "action/action.json")) && (isFileExistAndLenNot0(localFile.getAbsolutePath() + "/" + "action/action.atlas")) && (isFileExistAndLenNot0(localFile.getAbsolutePath() + "/" + "action/action.png"))) {}
        for (paramInt1 = 1; paramInt1 != 0; paramInt1 = 0)
        {
          if (paramInt2 != 0) {
            break label181;
          }
          return true;
        }
      }
    } while (paramInt2 != 1);
    if ((isFileExistAndLenNot0(localFile.getAbsolutePath() + "/" + "action_peer/action.json")) && (isFileExistAndLenNot0(localFile.getAbsolutePath() + "/" + "action_peer/action.atlas")) && (isFileExistAndLenNot0(localFile.getAbsolutePath() + "/" + "action_peer/action.png"))) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
    label298:
    return isFileExistAndLenNot0(localFile.getAbsolutePath() + "/action/" + "action.bin");
  }
  
  public static boolean isActionPathRscDone(String paramString)
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
      if ((isFileExistAndLenNot0(paramString.getAbsolutePath() + "/" + "action/action.json")) && (isFileExistAndLenNot0(paramString.getAbsolutePath() + "/" + "action/action.atlas")) && (isFileExistAndLenNot0(paramString.getAbsolutePath() + "/" + "action/action.png"))) {}
      for (int i = 1; i != 0; i = 0) {
        return true;
      }
    }
  }
  
  public static boolean isActionResDone(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloUtil", 2, "[isActionResDone], actionId:" + paramInt1 + ",personNum:" + paramInt2);
    }
    File localFile = new File("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/action/" + paramInt1);
    if (paramInt1 < 21) {
      localFile = new File(ApolloConstant.jdField_a_of_type_JavaLangString, "/def/basic/action/" + paramInt1);
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
        if (paramInt1 >= ApolloConstant.b)
        {
          if (isFileExistAndLenNot0(localFile.getAbsolutePath() + "/action/" + "action.bin"))
          {
            if (paramInt2 == 0) {
              return true;
            }
            if (paramInt2 == 1) {
              return isFileExistAndLenNot0(localFile.getAbsolutePath() + "/action_peer/" + "action.bin");
            }
          }
        }
        else
        {
          if ((isFileExistAndLenNot0(localFile.getAbsolutePath() + "/" + "action/action.json")) && (isFileExistAndLenNot0(localFile.getAbsolutePath() + "/" + "action/action.atlas")) && (isFileExistAndLenNot0(localFile.getAbsolutePath() + "/" + "action/action.png"))) {}
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
    if ((isFileExistAndLenNot0(localFile.getAbsolutePath() + "/" + "action_peer/action.json")) && (isFileExistAndLenNot0(localFile.getAbsolutePath() + "/" + "action_peer/action.atlas")) && (isFileExistAndLenNot0(localFile.getAbsolutePath() + "/" + "action_peer/action.png"))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public static boolean isActionResDone(int paramInt1, int paramInt2, int paramInt3)
  {
    boolean bool = true;
    if (paramInt1 == 1) {
      bool = isActionResDone(paramInt2, paramInt3);
    }
    return bool;
  }
  
  public static boolean isAllowDisplayGame(QQAppInterface paramQQAppInterface, MessageForApollo paramMessageForApollo)
  {
    Object localObject2 = null;
    if ((paramMessageForApollo == null) || (paramQQAppInterface == null)) {
      return false;
    }
    Object localObject1 = (ApolloDaoManagerServiceImpl)paramQQAppInterface.getRuntimeService(IApolloDaoManagerService.class, "all");
    if (ApolloGameUtil.a(paramMessageForApollo.msgType)) {}
    for (localObject1 = ((ApolloDaoManagerServiceImpl)localObject1).findGameById(paramMessageForApollo.gameId);; localObject1 = null)
    {
      IApolloManagerService localIApolloManagerService = (IApolloManagerService)paramQQAppInterface.getRuntimeService(IApolloManagerService.class, "all");
      if ((localIApolloManagerService.queryApolloSwitchSet("gameSwitch") != 1) || ((localObject1 != null) && (!ApolloConfigUtils.a("8.5.5", ((ApolloGameData)localObject1).minVer, ((ApolloGameData)localObject1).maxVer))))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ApolloUtil", 2, "play apollo game msg but switch is 0 or version is incorrect");
        }
        return false;
      }
      if (paramQQAppInterface.getApp() == null) {}
      for (paramQQAppInterface = localObject2; (localIApolloManagerService.isApolloFuncOpen(paramQQAppInterface)) && (paramMessageForApollo.istroop == 3000) && (localIApolloManagerService.queryApolloSwitchSet("discuss") == 0); paramQQAppInterface = paramQQAppInterface.getApp().getApplicationContext()) {
        return false;
      }
      return true;
    }
  }
  
  public static boolean isApolloPanelCacheExpired(QQAppInterface paramQQAppInterface, int paramInt)
  {
    long l1 = getApolloPanelBattleGameLastRequestTime(paramQQAppInterface, paramInt);
    long l2 = getApolloPanelBattleGameRequestInterval(paramQQAppInterface, paramInt);
    long l3 = System.currentTimeMillis();
    if (l3 > l1 + l2) {}
    for (boolean bool = true;; bool = false)
    {
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append("[isApolloPanelCacheExpired] ").append(bool).append(", currentTime: ").append(l3).append(", battleGameLastRequestTime: ").append(l1).append(", battleGameRequestInterval: ").append(l2);
      QLog.d("ApolloUtil", 1, new Object[] { paramQQAppInterface });
      return bool;
    }
  }
  
  public static boolean isApolloStatusOpen(ApolloBaseInfo paramApolloBaseInfo)
  {
    boolean bool = true;
    if (paramApolloBaseInfo == null) {
      return false;
    }
    if (paramApolloBaseInfo.apolloStatus == 1) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public static boolean isBubbleRscExist(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloUtil", 2, "[isBubbleRscExist], roleId:" + paramInt1 + ",bubbleId:" + paramInt2);
    }
    if (paramInt1 == 0) {}
    for (File localFile1 = new File(ApolloConstant.jdField_a_of_type_JavaLangString, "/def/role/" + paramInt1);; localFile1 = new File("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/role/" + paramInt1))
    {
      localFile1 = new File(localFile1, "Bubble/" + paramInt2);
      if (localFile1.exists()) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ApolloUtil", 2, "dir NOT exist." + localFile1.getPath());
      }
      return false;
    }
    File localFile2 = new File(localFile1, "dress.json");
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
    localFile2 = new File(localFile1, "dress.atlas");
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
    localFile1 = new File(localFile1, "dress.png");
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
  
  public static boolean isFileExistAndLenNot0(String paramString)
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
      toastDebugError(paramString + HardCodeUtil.a(2131700625));
    } while (!QLog.isColorLevel());
    QLog.d("ApolloUtil", 2, "ErrorInfo-> " + paramString + " NOT exist.");
    return false;
    if (localFile.length() == 0L)
    {
      toastDebugError(paramString + HardCodeUtil.a(2131700621));
      SpriteUtil.a(0, new Object[] { "ErrorInfo-> ", paramString, ",lenght is 0." });
      if (QLog.isColorLevel()) {
        QLog.d("ApolloUtil", 2, "ErrorInfo-> " + paramString + ",lenght is 0.");
      }
      localFile.delete();
      return false;
    }
    return true;
  }
  
  public static boolean isGameRscExist(int paramInt)
  {
    String str = getApolloGameLuaPath(paramInt);
    return (!android.text.TextUtils.isEmpty(str)) && (FileUtils.a(str));
  }
  
  public static boolean isKapuInstalled(Context paramContext)
  {
    if (paramContext == null) {
      return false;
    }
    return PackageUtil.a(paramContext, getKapuPkgName());
  }
  
  public static boolean isNewApolloEmotion(int paramInt)
  {
    if (SystemEmoticonInfo.sNewApolloEmoticonMap.containsKey("8.5.5"))
    {
      Object localObject = (List)SystemEmoticonInfo.sNewApolloEmoticonMap.get("8.5.5");
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
  
  public static boolean isQZoneBubbleId(int paramInt)
  {
    boolean bool2 = false;
    int[] arrayOfInt = QZONE_BUBBLE_ID_LIST;
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
  
  public static boolean isQzoneActionRscDone(int paramInt)
  {
    int i = 1;
    if (QLog.isColorLevel()) {
      QLog.d("ApolloUtil", 2, new Object[] { "[isWhiteFaceActionRscDone], actionId:", Integer.valueOf(paramInt) });
    }
    Object localObject = new File("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/action/" + paramInt + "/action");
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
        if (paramInt < ApolloConstant.b) {
          break;
        }
        k = isFileExistAndLenNot0((String)localObject + "/main/action/" + "action.bin");
        j = k;
      } while (k == 0);
      k &= isFileExistAndLenNot0((String)localObject + "/pre/action/" + "action.bin");
      j = k;
    } while (k == 0);
    return k & isFileExistAndLenNot0((String)localObject + "/post/action/" + "action.bin");
    int m;
    if ((isFileExistAndLenNot0((String)localObject + "/pre/" + "action/action.json")) && (isFileExistAndLenNot0((String)localObject + "/pre/" + "action/action.atlas")) && (isFileExistAndLenNot0((String)localObject + "/pre/" + "action/action.png")))
    {
      j = 1;
      m = j;
      if (j == 0) {
        return m;
      }
      if ((!isFileExistAndLenNot0((String)localObject + "/main/" + "action/action.json")) || (!isFileExistAndLenNot0((String)localObject + "/main/" + "action/action.atlas")) || (!isFileExistAndLenNot0((String)localObject + "/main/" + "action/action.png"))) {
        break label565;
      }
      paramInt = 1;
      label445:
      j &= paramInt;
      m = j;
      if (j == 0) {
        return m;
      }
      if ((!isFileExistAndLenNot0((String)localObject + "/post/" + "action/action.json")) || (!isFileExistAndLenNot0((String)localObject + "/post/" + "action/action.atlas")) || (!isFileExistAndLenNot0((String)localObject + "/post/" + "action/action.png"))) {
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
  
  public static boolean isRandomSubActionDone(int paramInt1, boolean paramBoolean1, int paramInt2, boolean paramBoolean2)
  {
    boolean bool = true;
    Object localObject = new StringBuilder("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/action/" + paramInt1);
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
    if ((isFileExistAndLenNot0(((File)localObject).getAbsolutePath() + File.separator + "action.json")) && (isFileExistAndLenNot0(((File)localObject).getAbsolutePath() + File.separator + "action.atlas")) && (isFileExistAndLenNot0(((File)localObject).getAbsolutePath() + File.separator + "action.png"))) {}
    for (paramBoolean1 = bool;; paramBoolean1 = false) {
      return paramBoolean1;
    }
  }
  
  public static boolean isResExist(ApolloActionData paramApolloActionData, int paramInt)
  {
    if (paramApolloActionData == null) {
      return false;
    }
    String str = "";
    if ((paramInt & 0x1) == 1) {
      str = getApolloResPath(paramApolloActionData, 0);
    }
    for (;;)
    {
      return FileUtil.a(str);
      if ((paramInt & 0x2) == 2) {
        str = getApolloResPath(paramApolloActionData, 2);
      }
    }
  }
  
  public static boolean isResourceDone(int paramInt1, int paramInt2)
  {
    switch (paramInt1)
    {
    default: 
      return false;
    case 1: 
      return checkRoleRes(paramInt2);
    }
    return checkDressRes(paramInt2);
  }
  
  public static boolean isRoleRelatedActionExist(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloUtil", 2, "[isRoleRelatedActionExist], roleId:" + paramInt);
    }
    String str;
    int i;
    if (paramInt == 0)
    {
      str = ApolloConstant.jdField_a_of_type_JavaLangString + "/def/role/";
      i = 1;
    }
    for (;;)
    {
      if (i >= 5) {
        break label312;
      }
      File localFile = new File(str, paramInt + "/" + i);
      if (!localFile.exists())
      {
        if (QLog.isColorLevel()) {
          QLog.d("ApolloUtil", 2, "dir NOT exist." + localFile.getPath());
        }
        return false;
        str = "/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/role/";
        break;
      }
      if (paramInt > ApolloConstant.b)
      {
        if (!isFileExistAndLenNot0(localFile.getAbsolutePath() + "/action/" + "action.bin")) {
          return false;
        }
      }
      else
      {
        if (!isFileExistAndLenNot0(localFile.getAbsolutePath() + "/" + "action/action.json")) {
          return false;
        }
        if (!isFileExistAndLenNot0(localFile.getAbsolutePath() + "/" + "action/action.atlas")) {
          return false;
        }
        if (!isFileExistAndLenNot0(localFile.getAbsolutePath() + "/" + "action/action.png")) {
          return false;
        }
      }
      i += 1;
    }
    label312:
    return true;
  }
  
  public static boolean isSameDress(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
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
  
  public static boolean isSpecialActionResDone(int paramInt1, int paramInt2)
  {
    String str = "";
    int i;
    if (paramInt2 > ApolloConstant.b)
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
      return is3DActionPathRscDone(str);
      i = 0;
      break;
      str = getApolloDrawerPath(paramInt2);
    }
    label54:
    return isActionPathRscDone(str);
  }
  
  public static boolean isTabExist(ApolloActionPackage paramApolloActionPackage)
  {
    if (paramApolloActionPackage == null) {
      return false;
    }
    return FileUtil.a(getApolloTabResPath(paramApolloActionPackage));
  }
  
  public static boolean isValideToDoAction(long paramLong1, long paramLong2)
  {
    return Math.abs(paramLong2 - paramLong1) > 500L;
  }
  
  public static boolean isWhiteFaceActionRscDone(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloUtil", 2, new Object[] { "[isWhiteFaceActionRscDone], actionId:", Integer.valueOf(paramInt1), ",subType:", Integer.valueOf(paramInt2), ",personNum:", Integer.valueOf(paramInt3), ",isGroup:", Boolean.valueOf(paramBoolean) });
    }
    Object localObject1 = new File("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/action/" + paramInt1 + "/action");
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
          if (paramInt1 >= ApolloConstant.b)
          {
            if (!isFileExistAndLenNot0((String)localObject1 + "action/" + "action.bin")) {
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
              return isFileExistAndLenNot0((String)localObject1 + "action_peer/" + "action.bin");
            }
          }
        }
        if ((isFileExistAndLenNot0((String)localObject1 + "action/action.json")) && (isFileExistAndLenNot0((String)localObject1 + "action/action.atlas")) && (isFileExistAndLenNot0((String)localObject1 + "action/action.png"))) {}
        for (paramInt1 = 1; paramInt1 != 0; paramInt1 = 0)
        {
          if (paramInt3 != 0) {
            break label463;
          }
          return true;
        }
      }
    } while (paramInt3 != 1);
    if ((isFileExistAndLenNot0((String)localObject1 + "action_peer/action.json")) && (isFileExistAndLenNot0((String)localObject1 + "action_peer/action.atlas")) && (isFileExistAndLenNot0((String)localObject1 + "action_peer/action.png"))) {}
    for (paramBoolean = true;; paramBoolean = false) {
      return paramBoolean;
    }
  }
  
  public static void jumpToH5PreviewAction(Activity paramActivity, String paramString1, String paramString2)
  {
    QZoneVipInfoManager.jumpToH5PreviewAction(paramActivity, paramString1, paramString2);
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
      if (QLog.isColorLevel()) {
        QLog.d("ApolloUtil", 2, "[launchGameDetailView] mate:" + localJSONObject1.toString());
      }
      ArkFullScreenAppActivity.a(paramActivity, "com.tencent.cmgame.intent", "GameCard", localJSONObject1.toString());
      return;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        QLog.e("ApolloUtil", 1, "[launchGameDetailView] error:", paramString);
      }
    }
  }
  
  public static String logFilter(String paramString)
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
  
  private static String matchLastIntegerStr(String paramString)
  {
    Matcher localMatcher = Pattern.compile("/\\d+/").matcher(paramString);
    for (paramString = ""; localMatcher.find(); paramString = localMatcher.group()) {}
    return paramString;
  }
  
  public static void mergeJSON(JSONObject paramJSONObject1, JSONObject paramJSONObject2)
  {
    if ((paramJSONObject1 == null) || (paramJSONObject2 == null)) {}
    for (;;)
    {
      return;
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
          QLog.d("ApolloUtil", 1, "mergeJSONData error!  msg=" + localException);
        }
      }
    }
  }
  
  public static boolean openBoxByH5()
  {
    if (ApolloConfigUtils.b == null) {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloUtil", 2, "queryApolloSwitchSet sSwitchSet = null");
      }
    }
    do
    {
      do
      {
        return false;
        if (!ApolloConfigUtils.b.has("autoOpenBox")) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("ApolloUtil", 2, new Object[] { "openBoxByH5 autoOpenBox:", Integer.valueOf(ApolloConfigUtils.b.optInt("autoOpenBox")) });
        }
      } while (ApolloConfigUtils.b.optInt("autoOpenBox") != 0);
      return true;
    } while (!QLog.isColorLevel());
    QLog.d("ApolloUtil", 2, "openBoxByH5 not autoOpenBox");
    return false;
  }
  
  public static void openCollectCard(Context paramContext, String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(ApolloConstant.o).append(paramString1).append("&adtag=").append(paramString2);
    paramString1 = new Intent(paramContext, QQBrowserActivity.class);
    paramString1.putExtra("big_brother_source_key", "biz_src_zf_lmx");
    VasWebviewUtil.openQQBrowserActivity(paramContext, localStringBuilder.toString(), -1L, paramString1, false, -1);
    if (QLog.isColorLevel()) {
      QLog.d("ApolloUtil", 2, new Object[] { "openCollectCard:", localStringBuilder.toString() });
    }
  }
  
  public static void openStoreByTabScheme(QQAppInterface paramQQAppInterface, Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    if ((paramQQAppInterface == null) || (paramContext == null))
    {
      QLog.e("ApolloUtil", 1, "openStoreByTabScheme context is null");
      return;
    }
    IApolloUtil localIApolloUtil = (IApolloUtil)QRoute.api(IApolloUtil.class);
    String str = localIApolloUtil.getStoreTabUrl(paramString1, true);
    if (!android.text.TextUtils.isEmpty(str))
    {
      paramString2 = new Intent();
      if ("interact".equals(paramString1)) {
        paramString2.putExtra("extra_key_url_append", "&tab=interactive&suin=" + paramQQAppInterface.getCurrentAccountUin());
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
    QLog.w("ApolloUtil", 1, "openStoreByTabScheme params is error");
  }
  
  public static void openVipPage(Context paramContext)
  {
    VasH5PayUtil.a(null, paramContext, "mvip.c.a.cs_limix", 3, "1450000515", "CJCLUBT", paramContext.getString(2131719674), "", false, true);
  }
  
  public static void openYellowPage(Activity paramActivity, String paramString1, String paramString2)
  {
    QZoneVipInfoManager.cmJumpToYellowPlayDialog(paramActivity, paramString1, paramString2);
  }
  
  public static int parseToInt(String paramString)
  {
    int i = 0;
    try
    {
      if (!android.text.TextUtils.isEmpty(paramString)) {
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
      QLog.e("ApolloUtil", 1, paramString, new Object[0]);
    }
    return 0L;
  }
  
  public static int queryApolloGameIdByHotChatCode(String paramString)
  {
    paramString = BaseApplicationImpl.getApplication();
    if (paramString != null)
    {
      paramString = paramString.getRuntime();
      if ((paramString != null) && ((paramString instanceof AppInterface))) {
        paramString = (AppInterface)paramString;
      }
    }
    for (;;)
    {
      if (paramString == null) {}
      return 0;
      if ((paramString instanceof ToolAppRuntime))
      {
        paramString = paramString.getAppRuntime("modular_web");
        if ((paramString instanceof AppInterface))
        {
          paramString = (AppInterface)paramString;
          continue;
        }
      }
      paramString = null;
    }
  }
  
  private static void reportKeywordsAction(int paramInt, String paramString, QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    if ((paramQQAppInterface != null) && (paramSessionInfo != null)) {
      VipUtils.a(paramQQAppInterface, "cmshow", "Apollo", "eggaction", ((IApolloUtil)QRoute.api(IApolloUtil.class)).getReportSessiontype(paramSessionInfo.jdField_a_of_type_Int), 0, new String[] { String.valueOf(paramInt), paramString });
    }
  }
  
  public static void saveAddedFaceList(QQAppInterface paramQQAppInterface, ArrayList<Integer> paramArrayList)
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
    BaseApplicationImpl.getContext().getSharedPreferences("apollo_sp", 0).edit().putString("sp_key_apollo_game_life" + paramQQAppInterface.getCurrentUin(), localStringBuilder.toString()).commit();
  }
  
  public static void saveApolloPanelBattleGameLastRequestTime(QQAppInterface paramQQAppInterface, int paramInt, long paramLong)
  {
    if (paramQQAppInterface == null)
    {
      QLog.e("ApolloUtil", 1, "[saveApolloPanelBattleGameLastRequestTime] app is null!");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ApolloUtil", 1, "[saveApolloPanelBattleGameLastRequestTime] " + paramLong);
    }
    BaseApplicationImpl.getContext().getSharedPreferences("apollo_sp", 0).edit().putLong("sp_key_apollo_panel_battle_game_last_request_time" + paramQQAppInterface.getCurrentUin() + paramInt, paramLong).commit();
  }
  
  public static void saveApolloPanelBattleGameRequestInterval(QQAppInterface paramQQAppInterface, int paramInt, long paramLong)
  {
    if (paramQQAppInterface == null)
    {
      QLog.e("ApolloUtil", 1, "[saveApolloPanelBattleGameRequestInterval] app is null!");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ApolloUtil", 1, "[saveApolloPanelBattleGameRequestInterval] " + paramLong);
    }
    BaseApplicationImpl.getContext().getSharedPreferences("apollo_sp", 0).edit().putLong("sp_key_apollo_panel_battle_game_request_interval" + paramQQAppInterface.getCurrentUin() + paramInt, paramLong).commit();
  }
  
  public static void saveDeviceMSAALevel(int paramInt)
  {
    sMsAALevel = paramInt;
    BaseApplicationImpl.getApplication().getSharedPreferences("apollo_user_config", 4).edit().putInt("MSAA_level", paramInt).commit();
  }
  
  public static void setActivityFadeIn(Context paramContext, int paramInt1, int paramInt2)
  {
    if ((paramContext instanceof Activity)) {}
  }
  
  public static void setApolloLv(ImageView paramImageView, int paramInt)
  {
    if (paramImageView == null) {
      return;
    }
    paramImageView.setImageResource(2130838732);
  }
  
  public static void setApolloNotObtainedLv(ImageView paramImageView, int paramInt)
  {
    if (paramImageView == null) {
      return;
    }
    switch (paramInt)
    {
    default: 
      paramImageView.setImageResource(2130838700);
      return;
    case 1: 
      paramImageView.setImageResource(2130838700);
      return;
    case 2: 
      paramImageView.setImageResource(2130838701);
      return;
    case 3: 
      paramImageView.setImageResource(2130838702);
      return;
    case 4: 
      paramImageView.setImageResource(2130838703);
      return;
    case 5: 
      paramImageView.setImageResource(2130838704);
      return;
    case 6: 
      paramImageView.setImageResource(2130838705);
      return;
    }
    paramImageView.setImageResource(2130838706);
  }
  
  public static void setApolloVipIcon(ImageView paramImageView, boolean paramBoolean1, boolean paramBoolean2)
  {
    paramImageView.setImageResource(2130838692);
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
    catch (Exception paramView) {}catch (OutOfMemoryError paramView) {}
  }
  
  public static void showDebugTipsToast(String paramString) {}
  
  public static void showTipsToast(String paramString)
  {
    ThreadManager.getUIHandler().post(new ApolloUtilImpl.9(paramString));
  }
  
  public static ArrayList sparseArrayToList(SparseArray paramSparseArray)
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
  
  public static void toastDebugError(String paramString) {}
  
  public static int transStype2Rtype(int paramInt)
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
  
  public static void updateObtainedAction(ApolloActionData paramApolloActionData, Bundle paramBundle)
  {
    int i = paramBundle.getInt("way");
    if (i == 1) {
      paramApolloActionData.feeType = 6;
    }
    while (i == 6)
    {
      paramApolloActionData.limitFree = 1;
      paramApolloActionData.limitStart = paramBundle.getLong("beginTs");
      paramApolloActionData.limitEnd = paramBundle.getLong("endts");
      return;
      if (i == 2) {
        paramApolloActionData.feeType = 7;
      } else if (i == 4) {
        paramApolloActionData.feeType = 2;
      }
    }
    paramApolloActionData.limitFree = 0;
    paramApolloActionData.obtainedTime = paramBundle.getLong("beginTs");
  }
  
  public void addDebugMenu(View paramView, QQAppInterface paramQQAppInterface, QQCustomMenu paramQQCustomMenu) {}
  
  public void checkApolloUrl(DownloadTask paramDownloadTask)
  {
    if ((paramDownloadTask != null) && (paramDownloadTask.a != null))
    {
      int i = 0;
      if (i < paramDownloadTask.a.size())
      {
        String str = (String)paramDownloadTask.a.get(i);
        if (!android.text.TextUtils.isEmpty(str))
        {
          if (!str.contains("http://cmshow.qq.com")) {
            break label85;
          }
          paramDownloadTask.a.set(i, str.replace("http://cmshow.qq.com", "https://cmshow.qq.com"));
        }
        for (;;)
        {
          i += 1;
          break;
          label85:
          if (str.contains("http://cmshow.gtimg.com")) {
            paramDownloadTask.a.set(i, str.replace("http://cmshow.gtimg.com", "https://cmshow.gtimg.com"));
          }
        }
      }
    }
  }
  
  public boolean checkPreloadOnSettingMe(QQAppInterface paramQQAppInterface, View paramView)
  {
    if ((paramView != null) && (paramView.getVisibility() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloUtil", 2, "apollo_client view is visible preloadWebProcess apolloOpen:true");
      }
      return true;
    }
    if (paramQQAppInterface == null) {
      return false;
    }
    paramView = (IApolloManagerService)paramQQAppInterface.getRuntimeService(IApolloManagerService.class, "all");
    if ((paramView.queryStatusInConfig(paramQQAppInterface, "drawer", null) > 0) && (paramView.isApolloFuncOpen(BaseApplicationImpl.getContext(), Boolean.valueOf(false)))) {}
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloUtil", 2, "apollo_client preloadWebProcess apolloOpen:" + bool);
      }
      return bool;
    }
  }
  
  public void checkWrapApolloDownload(DownloadTask paramDownloadTask) {}
  
  public String checkWrapApolloUrl(String paramString)
  {
    if (android.text.TextUtils.isEmpty(paramString)) {}
    while (!((IApolloUtil)QRoute.api(IApolloUtil.class)).isApolloProxyEnable()) {
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
        break label237;
      }
      j = str.indexOf("_bid=");
    }
    label224:
    label231:
    label234:
    label237:
    for (int i = 0;; i = 1)
    {
      paramString = str;
      if (j > 0)
      {
        paramString = str.substring(0, j);
        str = str.substring(j + "_bid=".length());
        if (android.text.TextUtils.isEmpty(str)) {
          break label234;
        }
        j = str.indexOf("&");
        if (j < 0) {
          break label231;
        }
        if (i == 0) {
          break label224;
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
  
  public void deleteApolloResource(boolean paramBoolean, QQAppInterface paramQQAppInterface)
  {
    ThreadManager.getSubThreadHandler().post(new ApolloUtilImpl.10(this, paramBoolean));
  }
  
  public String getApolloDescMsg(MessageForApollo paramMessageForApollo)
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
    return HardCodeUtil.a(2131700635);
  }
  
  public String getApolloImageUrl(String paramString)
  {
    return "https://cmshow.gtimg.cn/client/img/" + paramString;
  }
  
  public int getApolloPanelJsonVer(int paramInt)
  {
    Object localObject = null;
    if (1 == paramInt) {
      localObject = new File("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/action/action_v730.json");
    }
    if ((localObject != null) && (((File)localObject).exists()) && (((File)localObject).isFile()))
    {
      localObject = FileUtils.a((File)localObject);
      if (!android.text.TextUtils.isEmpty((CharSequence)localObject)) {
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
    if (paramInt1 == 3) {
      return "https://cmshow.gtimg.cn/qqshow/admindata/comdata/vipApollo_action_" + paramInt2 + "/task_detail.gif";
    }
    return "https://cmshow.gtimg.cn/qqshow/admindata/comdata/vipApollo_item_" + paramInt2 + "/task_detail.png";
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
    if (android.text.TextUtils.isEmpty(paramString1)) {
      return null;
    }
    if (!paramBoolean1) {}
    for (String str = "/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/image_cache/boxcard/" + paramString1;; str = paramString1)
    {
      File localFile = new File(str);
      URLDrawable.URLDrawableOptions localURLDrawableOptions = paramURLDrawableOptions;
      if (paramURLDrawableOptions == null)
      {
        localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        localURLDrawableOptions.mExtraInfo = null;
      }
      if (localURLDrawableOptions.mLoadingDrawable == null) {
        localURLDrawableOptions.mLoadingDrawable = URLDrawableHelper.TRANSPARENT;
      }
      if (localURLDrawableOptions.mFailedDrawable == null) {
        localURLDrawableOptions.mFailedDrawable = URLDrawableHelper.TRANSPARENT;
      }
      if (localURLDrawableOptions.mExtraInfo == null) {
        localURLDrawableOptions.mExtraInfo = new ApolloDrawableExtraInfo();
      }
      paramBoolean1 = paramBoolean2;
      if ((localURLDrawableOptions.mExtraInfo instanceof ApolloDrawableExtraInfo))
      {
        paramURLDrawableOptions = (ApolloDrawableExtraInfo)localURLDrawableOptions.mExtraInfo;
        if (!android.text.TextUtils.isEmpty(str)) {
          paramURLDrawableOptions.mLocalPath = str;
        }
        if (!android.text.TextUtils.isEmpty(paramString2)) {
          paramURLDrawableOptions.mDownloadUrl = paramString2;
        }
        if (paramURLDrawableOptions.mDrawableType != ApolloConstant.jdField_h_of_type_Int)
        {
          paramBoolean1 = paramBoolean2;
          if (!paramURLDrawableOptions.mNoUseFileDrawable) {}
        }
        else
        {
          paramBoolean1 = true;
        }
      }
      if ((!paramBoolean1) && (localFile.exists()))
      {
        paramURLDrawableOptions = URLDrawable.getDrawable(localFile, localURLDrawableOptions);
        paramString1 = paramURLDrawableOptions;
        if (QLog.isColorLevel())
        {
          QLog.d("ApolloUtil", 2, "getDrawable file exsit path->" + str + ",url:" + paramString2);
          paramString1 = paramURLDrawableOptions;
        }
      }
      for (;;)
      {
        return paramString1;
        try
        {
          paramString1 = URLDrawable.getDrawable(new URL("apollo_image", "", paramString1), localURLDrawableOptions);
        }
        catch (Exception paramString1)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ApolloUtil", 2, paramString1.getMessage());
          }
          paramString1 = null;
        }
      }
    }
  }
  
  public int getJsonIntValue(String paramString1, String paramString2)
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
  
  public String getMsgTranDec(QQAppInterface paramQQAppInterface, MessageForApollo paramMessageForApollo)
  {
    if (paramMessageForApollo == null) {
      return HardCodeUtil.a(2131700628);
    }
    if ((ApolloGameUtil.a(paramMessageForApollo.msgType)) && (isAllowDisplayGame(paramQQAppInterface, paramMessageForApollo)))
    {
      String str = HardCodeUtil.a(2131700626);
      if (!android.text.TextUtils.isEmpty(paramMessageForApollo.gameName)) {
        return str + paramMessageForApollo.gameName;
      }
      if (paramQQAppInterface != null)
      {
        paramQQAppInterface = ((ApolloDaoManagerServiceImpl)paramQQAppInterface.getRuntimeService(IApolloDaoManagerService.class, "all")).findGameById(paramMessageForApollo.gameId);
        if (paramQQAppInterface != null) {
          return str + paramQQAppInterface.name;
        }
        return str + HardCodeUtil.a(2131700622);
      }
      return str + HardCodeUtil.a(2131700610);
    }
    paramQQAppInterface = getDisplayActionName(paramQQAppInterface, paramMessageForApollo);
    if (ApolloGameUtil.b(paramMessageForApollo.msgType)) {
      return HardCodeUtil.a(2131690156) + paramQQAppInterface;
    }
    return HardCodeUtil.a(2131700629) + paramQQAppInterface;
  }
  
  public QQAppInterface getQQApp()
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
  
  public int getReportSessionTypeByContext(SessionInfo paramSessionInfo, AppInterface paramAppInterface)
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
        paramAppInterface = (HotChatManager)paramAppInterface.getManager(QQManagerFactory.HOT_CHAT_MANAGER);
        if (paramAppInterface != null)
        {
          if (paramAppInterface.b(paramSessionInfo.b)) {
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
  
  public int getReportSessiontype(int paramInt)
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
  
  public int getReportUserResult(int paramInt)
  {
    if (paramInt == 2) {
      return 1;
    }
    return 0;
  }
  
  public String getStoreTabUrl(String paramString, boolean paramBoolean)
  {
    String str1 = "";
    String str2;
    if ("mall".equals(paramString))
    {
      str1 = ApolloConstant.u;
      str2 = str1;
      if (paramBoolean)
      {
        if (!"game_city".equals(paramString)) {
          break label114;
        }
        str2 = ApolloConstant.z;
      }
    }
    label114:
    do
    {
      return str2;
      if (("interact".equals(paramString)) || ("interactive".equals(paramString)))
      {
        str1 = ApolloConstant.v;
        break;
      }
      if ("3d_mall".equals(paramString))
      {
        str1 = ApolloConstant.A;
        break;
      }
      if ((!"3d_interact".equals(paramString)) && (!"3d_interactive".equals(paramString))) {
        break;
      }
      str1 = ApolloConstant.B;
      break;
      str2 = str1;
    } while (!"3d_game_city".equals(paramString));
    return ApolloConstant.C;
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
  
  public void importDebugFile(View paramView, FileManagerEntity paramFileManagerEntity, QQAppInterface paramQQAppInterface) {}
  
  public boolean isApolloProxyEnable()
  {
    if (QLog.isColorLevel()) {
      QLog.e("ApolloUtil", 1, "isApolloProxyEnable isPublicVersion");
    }
    return false;
  }
  
  public boolean isFemale(@NonNull QQAppInterface paramQQAppInterface, String paramString)
  {
    paramQQAppInterface = ((FriendsManager)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).b(paramString);
    if (paramQQAppInterface != null) {
      return paramQQAppInterface.gender == 2;
    }
    return false;
  }
  
  public void onEmoticonNewIconShown(int paramInt)
  {
    if (!isNewApolloEmotion(paramInt)) {
      return;
    }
    if (SystemEmoticonInfo.sNewApolloEmoticonMap.containsKey("8.5.5"))
    {
      Object localObject = (List)SystemEmoticonInfo.sNewApolloEmoticonMap.get("8.5.5");
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
  
  public void openApolloGameCenter(Context paramContext)
  {
    Intent localIntent = new Intent(paramContext, QQBrowserActivity.class);
    localIntent.putExtra("big_brother_source_key", "biz_src_zf_lmx");
    VasWebviewUtil.openQQBrowserActivity(paramContext, ApolloConstant.x, -1L, localIntent, false, -1);
  }
  
  public void openApolloGameCity(Context paramContext, int paramInt, Intent paramIntent)
  {
    openApolloStore(paramContext, paramIntent, null, ApolloConstant.z + "&adSrc=" + paramInt, null);
  }
  
  public void openApolloStore(Context paramContext, Intent paramIntent, String paramString1, String paramString2, AppInterface paramAppInterface)
  {
    openApolloStore(paramContext, paramIntent, paramString1, paramString2, paramAppInterface, 0);
  }
  
  public void openApolloStore(Context paramContext, Intent paramIntent, String paramString1, String paramString2, AppInterface paramAppInterface, int paramInt)
  {
    if (paramContext == null) {
      return;
    }
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
      ApolloManagerServiceImpl localApolloManagerServiceImpl = (ApolloManagerServiceImpl)paramAppInterface.getRuntimeService(IApolloManagerService.class, "all");
      if (!localApolloManagerServiceImpl.isHardwareSupport(paramContext))
      {
        paramIntent = new Intent(paramContext, QQBrowserActivity.class);
        paramIntent.putExtra("big_brother_source_key", "biz_src_zf_lmx");
        VasWebviewUtil.openQQBrowserActivity(paramContext, ApolloConstant.jdField_h_of_type_JavaLangString, -1L, paramIntent, false, -1);
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
        if ((1 != localApolloManagerServiceImpl.getWhiteListStatus(paramAppInterface)) || ((paramAppInterface != null) && ((paramAppInterface instanceof QQAppInterface)) && (!ApolloGameUtil.a((QQAppInterface)paramAppInterface))))
        {
          paramIntent = new Intent(paramContext, QQBrowserActivity.class);
          paramIntent.putExtra("big_brother_source_key", "biz_src_zf_lmx");
          VasWebviewUtil.openQQBrowserActivity(paramContext, ApolloConstant.i + "0", -1L, paramIntent, false, -1);
          return;
        }
        localObject = paramIntent;
        if (paramIntent == null) {
          localObject = new Intent();
        }
        if ((paramAppInterface != null) && ((paramAppInterface instanceof QQAppInterface)) && (localApolloManagerServiceImpl.is3dAvailable((QQAppInterface)paramAppInterface))) {}
        for (int i = 1;; i = 0)
        {
          paramIntent = paramString2;
          if (!android.text.TextUtils.isEmpty(paramString2))
          {
            paramIntent = paramString2;
            if (paramString2.contains("tab=3d"))
            {
              paramIntent = paramString2;
              if (i == 0) {
                paramIntent = ApolloConstant.v;
              }
            }
          }
          paramString2 = paramIntent;
          if (!android.text.TextUtils.isEmpty(ApolloConstant.v))
          {
            paramString2 = paramIntent;
            if (ApolloConstant.v.equals(paramIntent))
            {
              paramString2 = paramIntent;
              if (i != 0) {
                paramString2 = ApolloConstant.D;
              }
            }
          }
          if (((Intent)localObject).getIntExtra("key_box_type", 0) != 3) {
            break;
          }
          paramIntent = ApolloConstant.q;
          paramString1 = new Intent(paramContext, QQBrowserActivity.class);
          ((Intent)localObject).putExtra("big_brother_source_key", "biz_src_zf_lmx");
          VasWebviewUtil.openQQBrowserActivity(paramContext, paramIntent, -1L, paramString1, false, -1);
          return;
        }
        if (paramAppInterface != null)
        {
          paramIntent = paramAppInterface.getCurrentNickname();
          paramAppInterface.getLongAccountUin();
        }
        for (;;)
        {
          ((Intent)localObject).putExtra("extra_key_nickname", paramIntent);
          if (!android.text.TextUtils.isEmpty(paramString1)) {
            ((Intent)localObject).putExtra("extra_key_adtag", paramString1);
          }
          ((Intent)localObject).putExtra("extra_key_click_time", System.currentTimeMillis());
          ((Intent)localObject).putExtra("startOpenPageTime", System.currentTimeMillis());
          if (QLog.isColorLevel()) {
            QLog.d("ApolloUtil", 2, "apollo_client, clickTime:" + TimeFormatterUtils.a(System.currentTimeMillis(), "dd-MMM-yyyy HH:mm:ss:SSS") + ",url:" + paramString2);
          }
          if (!android.text.TextUtils.isEmpty(paramString2))
          {
            paramString1 = paramString2.replace("_bid=2423&", "");
            paramIntent = paramString1;
            if (PushDrawerStatus.jdField_d_of_type_Boolean)
            {
              if (android.text.TextUtils.isEmpty(PushDrawerStatus.c)) {
                break label821;
              }
              paramIntent = URLUtil.a(paramString1, "wording", PushDrawerStatus.c);
              paramString1 = paramIntent;
              if (!android.text.TextUtils.isEmpty(PushDrawerStatus.jdField_d_of_type_JavaLangString)) {
                paramString1 = URLUtil.a(paramIntent, "bubble_id", PushDrawerStatus.jdField_d_of_type_JavaLangString);
              }
              paramIntent = paramString1;
              if (!android.text.TextUtils.isEmpty(PushDrawerStatus.b)) {
                paramIntent = URLUtil.a(paramString1, "tip_url", PushDrawerStatus.b);
              }
            }
            if (localApolloManagerServiceImpl == null) {
              break label1076;
            }
            if (localApolloManagerServiceImpl.mIsNewStoreUser)
            {
              paramString1 = "1";
              label640:
              paramString1 = URLUtil.a(paramIntent, "is_new_store_user", paramString1);
              if (i == 0) {
                break label853;
              }
              paramIntent = "1";
              label657:
              paramIntent = URLUtil.a(paramString1, "is_3d_available", paramIntent);
            }
          }
          label769:
          label914:
          label931:
          label1064:
          label1071:
          label1076:
          for (;;)
          {
            if (((Intent)localObject).getBooleanExtra("extra_key_open_box", false)) {
              if (openBoxByH5()) {
                ((Intent)localObject).putExtra("extra_key_open_box", false);
              }
            }
            for (paramIntent = URLUtil.a(paramIntent, "boxReady", "1");; paramIntent = URLUtil.a(paramIntent, "boxReady", "0"))
            {
              ((Intent)localObject).putExtra("url", paramIntent);
              ((Intent)localObject).putExtra("url", paramIntent);
              if ((!paramIntent.contains("webviewCheckType=1")) && (!paramIntent.contains("webviewCheckType=2"))) {
                break label1036;
              }
              ((Intent)localObject).setClass(paramContext, ApolloStoreActivity.class);
              if (QLog.isColorLevel()) {
                QLog.d("ApolloUtil", 2, "apollo_client, ApolloStoreActivity");
              }
              if (!(paramContext instanceof Activity)) {
                ((Intent)localObject).addFlags(268435456);
              }
              ((Intent)localObject).putExtra("big_brother_source_key", "biz_src_zf_lmx");
              if ((!(paramContext instanceof Activity)) || (paramInt <= 0)) {
                break label1064;
              }
              ((Activity)paramContext).startActivityForResult((Intent)localObject, paramInt);
              return;
              label821:
              paramIntent = paramString1;
              if (android.text.TextUtils.isEmpty(PushDrawerStatus.jdField_a_of_type_JavaLangString)) {
                break;
              }
              paramIntent = URLUtil.a(paramString1, "wording", PushDrawerStatus.jdField_a_of_type_JavaLangString);
              break;
              paramString1 = "0";
              break label640;
              label853:
              paramIntent = "0";
              break label657;
            }
            if (!android.text.TextUtils.isEmpty(ApolloConstant.u))
            {
              paramIntent = ApolloConstant.u;
              label887:
              paramString1 = paramIntent.replace("_bid=2423&", "");
              if (localApolloManagerServiceImpl == null) {
                break label1071;
              }
              if (!localApolloManagerServiceImpl.mIsNewStoreUser) {
                break label1008;
              }
              paramIntent = "1";
              paramString1 = URLUtil.a(paramString1, "is_new_store_user", paramIntent);
              if (i == 0) {
                break label1015;
              }
              paramIntent = "1";
            }
            for (paramIntent = URLUtil.a(paramString1, "is_3d_available", paramIntent);; paramIntent = paramString1)
            {
              if (((Intent)localObject).getBooleanExtra("extra_key_open_box", false)) {
                if (openBoxByH5()) {
                  ((Intent)localObject).putExtra("extra_key_open_box", false);
                }
              }
              for (paramIntent = URLUtil.a(paramIntent, "boxReady", "1");; paramIntent = URLUtil.a(paramIntent, "boxReady", "0"))
              {
                ((Intent)localObject).putExtra("url", paramIntent);
                ((Intent)localObject).putExtra("url", paramIntent);
                break;
                paramIntent = ApolloConstant.j;
                break label887;
                label1008:
                paramIntent = "0";
                break label914;
                label1015:
                paramIntent = "0";
                break label931;
              }
              ((Intent)localObject).setClass(paramContext, ApolloStoreActivity.class);
              if (!QLog.isColorLevel()) {
                break label769;
              }
              QLog.d("ApolloUtil", 2, "apollo_client, ApolloStoreActivity");
              break label769;
              paramContext.startActivity((Intent)localObject);
              return;
            }
          }
          label1036:
          paramIntent = "";
        }
      }
    }
  }
  
  public void openWebViewActivity(Context paramContext, String paramString)
  {
    Intent localIntent = new Intent(paramContext, QQBrowserActivity.class);
    localIntent.putExtra("big_brother_source_key", "biz_src_zf_lmx");
    VasWebviewUtil.openQQBrowserActivity(paramContext, paramString, -1L, localIntent, false, -1);
  }
  
  public void playApolloEmoticonAction(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, ChatMessage paramChatMessage, AnimationTextView paramAnimationTextView, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if ((paramQQAppInterface == null) || (paramSessionInfo == null) || (paramChatMessage == null) || (paramAnimationTextView == null)) {
      QLog.e("ApolloUtil", 1, "[playApolloEmoticonAction] param null, abort");
    }
    while (!CmShowAioMatcher.a(paramSessionInfo.jdField_a_of_type_Int)) {
      return;
    }
    ApolloDaoManagerServiceImpl localApolloDaoManagerServiceImpl = null;
    Object localObject1;
    if (paramBoolean)
    {
      localObject1 = localApolloDaoManagerServiceImpl;
      if (android.text.TextUtils.isEmpty(paramChatMessage.extStr)) {}
    }
    for (;;)
    {
      try
      {
        localObject1 = new JSONObject(paramChatMessage.extStr).optString("is_apollo_emoticon_action_checked");
        if ((android.text.TextUtils.isEmpty((CharSequence)localObject1)) || (!"1".equals(localObject1))) {
          break label432;
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
        ThreadManager.post(new ApolloUtilImpl.2(this, paramChatMessage), 5, null, false);
        if (paramInt1 != paramInt2 - 1) {
          break;
        }
        localObject1 = (ApolloManagerServiceImpl)paramQQAppInterface.getRuntimeService(IApolloManagerService.class, "all");
        if (localObject1 == null) {
          break;
        }
        if (((ApolloManagerServiceImpl)localObject1).queryApolloSwitchSet("whiteFace3D") != 1) {
          break label438;
        }
        paramBoolean = true;
        paramInt1 = getWhiteFacePlayModel(paramQQAppInterface, paramChatMessage);
        if (paramInt1 == 0) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("ApolloUtil", 2, new Object[] { "[playApolloEmoticonAction] apollo status open, grab action playModel:", Integer.valueOf(paramInt1), ",is3DWhiteFaceOpen:", Boolean.valueOf(paramBoolean) });
        }
        localApolloDaoManagerServiceImpl = (ApolloDaoManagerServiceImpl)paramQQAppInterface.getRuntimeService(IApolloDaoManagerService.class, "all");
        paramAnimationTextView = paramAnimationTextView.getText();
        if (!(paramAnimationTextView instanceof QQText)) {
          break;
        }
        paramChatMessage.saveExtInfoToExtStr("is_apollo_emoticon_action_played", "2");
        ThreadManager.post(new ApolloUtilImpl.3(this, paramInt1, paramBoolean, paramAnimationTextView, localApolloDaoManagerServiceImpl, paramQQAppInterface, paramSessionInfo, (ApolloManagerServiceImpl)localObject1, paramChatMessage), 5, null, false);
        return;
      }
      catch (Exception localException)
      {
        QLog.e("ApolloUtil", 1, "[playApolloEmoticonAction] json error, ", localException);
        localObject2 = localApolloDaoManagerServiceImpl;
        continue;
      }
      Object localObject2 = paramChatMessage.getExtInfoFromExtStr("is_apollo_emoticon_action_checked");
      continue;
      label432:
      boolean bool = false;
      continue;
      label438:
      paramBoolean = false;
    }
  }
  
  public void playShareMsgAction(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, ChatMessage paramChatMessage, int paramInt1, int paramInt2)
  {
    if ((paramQQAppInterface == null) || (paramSessionInfo == null) || (paramChatMessage == null)) {
      QLog.e("ApolloUtil", 1, "[playShareMsgAction] param null, abort");
    }
    while ((paramSessionInfo.jdField_a_of_type_Int != 0) && (paramSessionInfo.jdField_a_of_type_Int != 1) && (paramSessionInfo.jdField_a_of_type_Int != 3000)) {
      return;
    }
    paramSessionInfo = paramChatMessage.getExtInfoFromExtStr("is_share_ark_message_action_checked");
    if ((!android.text.TextUtils.isEmpty(paramSessionInfo)) && ("1".equals(paramSessionInfo))) {}
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloUtil", 2, new Object[] { "[playShareMsgAction] share ark action isChecked:", Boolean.valueOf(bool), ", uniseq=", Long.valueOf(paramChatMessage.uniseq) });
      }
      if (bool) {
        break;
      }
      paramChatMessage.saveExtInfoToExtStr("is_share_ark_message_action_checked", "1");
      ThreadManager.excute(new ApolloUtilImpl.4(this, paramChatMessage, paramInt1, paramInt2, paramQQAppInterface), 96, null, false);
      return;
    }
  }
  
  public void replaceCmshow3dResource(String paramString)
  {
    if ((android.text.TextUtils.isEmpty(paramString)) || (!new File(paramString).exists()))
    {
      QQToast.a(BaseActivity.sTopActivity, HardCodeUtil.a(2131700617), 1).a();
      return;
    }
    QLog.d("ApolloUtil", 1, new Object[] { "replaceCmshow3dResource, filePath=", paramString });
    Object localObject1;
    int j;
    int i;
    long l1;
    label139:
    Object localObject2;
    Object localObject3;
    try
    {
      localObject1 = new File("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/tempReplace/");
      if (((File)localObject1).exists()) {
        FileUtil.a((File)localObject1);
      }
      ZipUtils.unZipFile(new File(paramString), "/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/tempReplace/");
      j = 0;
      i = 0;
      l1 = -1L;
      paramString = ((File)localObject1).listFiles();
      l2 = l1;
      k = j;
      if (paramString == null) {
        break label563;
      }
      l2 = l1;
      k = j;
      if (paramString.length <= 0) {
        break label563;
      }
      j = 0;
      l2 = l1;
      k = i;
      if (j >= paramString.length) {
        break label563;
      }
      localObject2 = paramString[j];
      if ((((File)localObject2).isFile()) && (((File)localObject2).getName().equals("skeleton.bin")))
      {
        k = 1;
        FileUtils.a((File)localObject2, new File("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/role/" + 3100045L + "/skeleton.bin"));
        l2 = l1;
      }
      else if ((((File)localObject2).isDirectory()) && (((File)localObject2).getName().equals("action")))
      {
        localObject2 = new File((File)localObject2, "action.bin");
        localObject3 = new File("/data/data/com.tencent.mobileqq/files/apollo/def/role/0/3D/sayhi/1/action.bin");
        if (((File)localObject3).exists()) {
          ((File)localObject3).delete();
        }
        FileUtils.a((File)localObject2, (File)localObject3);
        l2 = l1;
        k = i;
      }
    }
    catch (Exception paramString)
    {
      QLog.e("ApolloUtil", 1, "replaceCmshow3dResource, error=", paramString);
      QQToast.a(BaseActivity.sTopActivity, HardCodeUtil.a(2131700620), 0).a();
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
            label418:
            l2 = l1;
            k = i;
            if (m < localObject2.length)
            {
              localObject3 = localObject2[m];
              l2 = l1;
              if (!((File)localObject3).isFile()) {
                break label1086;
              }
              l2 = l1;
              if (!((File)localObject3).getName().endsWith(".zip")) {
                break label1086;
              }
              if (!((File)localObject3).getName().equals("face.zip")) {
                break label1099;
              }
              ZipUtils.unZipFile((File)localObject3, "/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/role/" + 3100045L + "/");
              l2 = l1;
              break label1086;
            }
          }
        }
      }
    }
    for (;;)
    {
      ZipUtils.unZipFile((File)localObject3, "/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/dress/" + l1 + "/");
      l2 = l1;
      break label1086;
      label563:
      FileUtil.a((File)localObject1);
      if (k == 0)
      {
        QQToast.a(BaseActivity.sTopActivity, HardCodeUtil.a(2131700618), 0).a();
        return;
      }
      Object localObject4;
      long l4;
      if (l2 != -1L)
      {
        QLog.d("ApolloUtil", 1, new Object[] { "replaceCmshow3dResource, dressEndId=", Long.valueOf(l2) });
        paramString = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
        localObject1 = (ApolloManagerServiceImpl)paramString.getRuntimeService(IApolloManagerService.class, "all");
        localObject4 = paramString.getCurrentAccountUin();
        localObject2 = ((ApolloManagerServiceImpl)localObject1).getApolloBaseInfo((String)localObject4);
        if (localObject2 == null) {
          break;
        }
        l1 = 0L;
        if (((ApolloBaseInfo)localObject2).mApollo3DDataBuffer == null) {
          break label1066;
        }
        localObject3 = new JSONObject(((ApolloBaseInfo)localObject2).mApollo3DDataBuffer);
        l3 = ((JSONObject)localObject3).optLong("ts");
        localObject3 = ((JSONObject)localObject3).optJSONObject("role");
        l1 = l3;
        if (localObject3 == null) {
          break label1066;
        }
        l4 = ((JSONObject)localObject3).optLong("id");
        l1 = l3;
      }
      label1066:
      for (long l3 = l4;; l3 = 0L)
      {
        if (l3 != 0L)
        {
          FileUtils.a(new File("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/role/" + l3 + "/config.json"), new File("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/role/" + 3100045L + "/config.json"));
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
          QQToast.a(BaseActivity.sTopActivity, HardCodeUtil.a(2131700614), 0).a();
          return;
        }
        QQToast.a(BaseActivity.sTopActivity, HardCodeUtil.a(2131700624), 0).a();
        return;
        ((JSONObject)localObject3).put("dresslist", localObject4);
        ((ApolloBaseInfo)localObject2).setApolloDress3D(paramString, (JSONObject)localObject3);
        ((ApolloManagerServiceImpl)localObject1).saveOrUpdateApolloBaseInfo((ApolloBaseInfo)localObject2);
        QQToast.a(BaseActivity.sTopActivity, HardCodeUtil.a(2131700632), 0).a();
        return;
      }
      j += 1;
      l1 = l2;
      i = k;
      break label139;
      label1086:
      m += 1;
      l1 = l2;
      break label418;
      label1099:
      if (l1 == -1L) {
        l1 = 3100145L;
      } else {
        l1 += 1L;
      }
    }
  }
  
  public void reportCrash(boolean paramBoolean, String paramString1, String paramString2)
  {
    try
    {
      if (1 != BaseApplicationImpl.sProcessId) {
        return;
      }
      if ((!android.text.TextUtils.isEmpty(paramString2)) && (paramString2.contains("Apollo")))
      {
        handleApolloNoCatchCrash(paramBoolean, paramString1, paramString2);
        return;
      }
    }
    catch (Throwable paramString1)
    {
      paramString1.printStackTrace();
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
  
  public void setReaded(MessageForApollo paramMessageForApollo, QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    if ((paramMessageForApollo != null) && (paramQQAppInterface != null)) {
      ThreadManager.getFileThreadHandler().post(new ApolloUtilImpl.1(this, paramMessageForApollo, paramQQAppInterface, paramString, paramInt));
    }
  }
  
  public boolean shouldShowNewIcon(int paramInt)
  {
    boolean bool = true;
    if (!isNewApolloEmotion(paramInt)) {
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
    if (sNewIconShowTimes < 3) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public boolean shouldShowPopupGuide()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (SystemEmoticonInfo.sNewApolloEmoticonMap.containsKey("8.5.5"))
    {
      List localList = (List)SystemEmoticonInfo.sNewApolloEmoticonMap.get("8.5.5");
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
          if (sPopupGuideShown) {
            break label88;
          }
        }
      }
    }
    label88:
    for (bool1 = true;; bool1 = false) {
      return bool1;
    }
  }
  
  public String wrapLogUin(String paramString)
  {
    if ((android.text.TextUtils.isEmpty(paramString)) || (paramString.length() < 4)) {
      return paramString;
    }
    return paramString.substring(0, 4) + "*";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.uitls.impl.ApolloUtilImpl
 * JD-Core Version:    0.7.0.1
 */