import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build.VERSION;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.Xml;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.aio.pluspanel.C2CPlusPanelAppConfigHelper;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.NearbyGrayTipsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.utils.PokeBigResHandler;
import com.tencent.mobileqq.ar.aidl.ArConfigInfo;
import com.tencent.mobileqq.ar.aidl.ArEffectConfig;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.config.operation.QQOperationViopTipTask;
import com.tencent.mobileqq.config.splashlogo.ConfigServlet.10;
import com.tencent.mobileqq.config.splashlogo.ConfigServlet.11;
import com.tencent.mobileqq.config.splashlogo.ConfigServlet.12;
import com.tencent.mobileqq.config.splashlogo.ConfigServlet.13;
import com.tencent.mobileqq.config.splashlogo.ConfigServlet.4;
import com.tencent.mobileqq.config.splashlogo.ConfigServlet.6;
import com.tencent.mobileqq.config.splashlogo.ConfigServlet.8;
import com.tencent.mobileqq.config.splashlogo.ConfigServlet.9;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Config;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.ConfigSeq;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Content;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.DeviceInfo;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.OS;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.ReqGetConfig;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.RespGetConfig;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Screen;
import com.tencent.mobileqq.data.AppGuideTipsConfig;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.ExpiredPushBanner;
import com.tencent.mobileqq.data.MessageForFoldMsgGrayTips;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.data.ReportedBanner;
import com.tencent.mobileqq.medalwall.MedalWallMng;
import com.tencent.mobileqq.msf.core.net.patch.PatchReporter;
import com.tencent.mobileqq.msf.core.net.patch.PatchSharedPreUtil;
import com.tencent.mobileqq.msf.core.net.utils.MsfCmdConfig;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.ocr.data.OcrConfig;
import com.tencent.mobileqq.olympic.OlympicActConfig;
import com.tencent.mobileqq.olympic.OlympicManager;
import com.tencent.mobileqq.olympic.OlympicServlet;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.scribble.ScribbleResMgr;
import com.tencent.mobileqq.search.util.SearchConfigManager;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager;
import com.tencent.mobileqq.shortvideo.util.RecentDanceConfigMgr;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.upgrade.UpgradeTIMManager;
import com.tencent.mobileqq.utils.BusinessCommonConfig;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import cooperation.pluginbridge.BridgeHelper;
import cooperation.qwallet.plugin.QWalletHelper;
import dov.com.qq.im.ptv.LightVideoConfigMgr;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.zip.InflaterInputStream;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import mqq.app.AppRuntime;
import mqq.app.MSFServlet;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.app.Packet;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xmlpull.v1.XmlPullParser;

public class arph
  extends MSFServlet
{
  public static String a;
  private static final int[] jdField_a_of_type_ArrayOfInt = { 1, 2, 3, 5, 10, 13, 23, 31, 38, 42, 44, 46, 47, 49, 50, 53, 55, 56, 57, 61, 62, 63, 64, 65, 66, 69, 206, 205, 72, 73, 74, 75, 385, 94, 78, 79, 80, 84, 223, 82, 101, 102, 147, 86, 93, 88, 90, 96, 97, 108, 146, 111, 109, 115, 286, 118, 119, 116, 130, 142, 121, 157, 211, 201, 129, 143, 140, 257, 232, 233, 148, 139, 145, 153, 149, 155, 165, 185, 167, 166, 171, 180, 182, 177, 371, 181, 184, 187, 191, 193, 188, 195, 227, 202, 190, 210, 199, 212, 407, weg.a(2131427352), weg.a(2131427353), weg.a(2131427354), weg.a(2131427349), weg.a(2131427350), 218, 226, 225, 222, 256, 228, 235, 234, 238, 247, 244, 245, 253, 295, 254, 259, 260, 262, 204, 271, 267, 275, 358, 268, 269, 272, 274, 279, 308, 281, 283, 284, 280, 360, 289, 314, 297, 301, 296, 330, 347, 313, 312, 397, 321, 326, 320, 328, 331, 336, 329, 337, 345, 351, 349, 355, 372, 384, 379, 357, 378, 381, 273, 364, 365, 369, 387, 386, 392, 393, 394, 401, 400, 403, 404, 405, 408, 410, 194, 596, 604 };
  private static String b;
  private boolean jdField_a_of_type_Boolean;
  
  static
  {
    jdField_a_of_type_JavaLangString = "";
    jdField_b_of_type_JavaLangString = anvx.a(2131701928);
  }
  
  private void A(ConfigurationService.Config paramConfig)
  {
    boolean bool2 = true;
    for (;;)
    {
      try
      {
        localQQAppInterface = (QQAppInterface)getAppRuntime();
        i = paramConfig.version.get();
        j = bhhr.P(localQQAppInterface.getApp(), localQQAppInterface.getAccount());
        if (QLog.isColorLevel()) {
          QLog.d("longText", 2, "received LongTextMsgConfig configVersion:" + i + " ,localVersion:" + j);
        }
        if ((paramConfig.content_list != null) && (paramConfig.content_list.size() > 0))
        {
          paramConfig = (String)paramConfig.content_list.get(0);
          if (QLog.isColorLevel()) {
            QLog.d("longText", 2, "received LongTextMsgConfig configContent" + paramConfig);
          }
          if (i == j) {
            break label435;
          }
        }
      }
      catch (Exception paramConfig)
      {
        QQAppInterface localQQAppInterface;
        int i;
        int j;
        int k;
        boolean bool3;
        boolean bool4;
        if (QLog.isColorLevel())
        {
          QLog.e("SPLASH_ConfigServlet", 2, "received LongTextMsgConfig error", paramConfig);
          return;
          if (i == j)
          {
            if (QLog.isColorLevel()) {
              QLog.d("longText", 2, "received LongTextMsgConfig, content_list is empty, ignored because of SAME VERSION");
            }
          }
          else if (QLog.isColorLevel())
          {
            QLog.d("longText", 2, "received LongTextMsgConfig, content_list is empty, use default config");
            return;
            bool1 = false;
            continue;
            bool2 = true;
            bool1 = false;
            continue;
          }
        }
      }
      try
      {
        if (TextUtils.isEmpty(paramConfig)) {
          continue;
        }
        paramConfig = new JSONObject(paramConfig);
        if (paramConfig == null) {
          continue;
        }
        j = Integer.parseInt(paramConfig.optString("largeMsgOp"));
        if (j != 1) {
          continue;
        }
        bool1 = true;
      }
      catch (Exception paramConfig)
      {
        bool1 = false;
        continue;
      }
      try
      {
        k = Integer.parseInt(paramConfig.optString("msfPullFilter"));
        if (k != 0) {
          continue;
        }
        bool2 = false;
      }
      catch (Exception paramConfig)
      {
        continue;
        bool2 = true;
        continue;
      }
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("longText", 2, "received LongTextMsgConfig, parse content ltValue:" + j + ",ltSwitch:" + bool1 + ",mpfValue:" + k + ",mpfSwitch:" + bool2);
        }
        bool3 = bool1;
        bool4 = bool2;
        paramConfig = (axii)localQQAppInterface.getManager(QQManagerFactory.LONG_TEXT_MSG_MANAGER);
        paramConfig.jdField_b_of_type_Boolean = true;
        paramConfig.c = bool3;
        localQQAppInterface.isMsfPullFilterConfigInited = true;
        localQQAppInterface.msfPullFilterSwitch = bool4;
        bhhr.b(localQQAppInterface.getApp(), localQQAppInterface.getAccount(), i, bool3, bool4);
        return;
      }
      catch (Exception paramConfig)
      {
        continue;
      }
      bool4 = bool2;
      bool3 = bool1;
      if (QLog.isColorLevel())
      {
        QLog.d("longText", 2, "received LongTextMsgConfig, parse content error!", paramConfig);
        bool4 = bool2;
        bool3 = bool1;
      }
    }
    label435:
  }
  
  private void B(ConfigurationService.Config paramConfig)
  {
    QLog.i("NCtr", 1, "[handleLimitNotifyConfig]");
    Object localObject = (QQAppInterface)getAppRuntime();
    int j = paramConfig.version.get();
    int k = AppSetting.a();
    bkyu localbkyu = (bkyu)((QQAppInterface)localObject).getBusinessHandler(BusinessHandlerFactory.NOTIFICATION_CONTROLLER_HANDLER);
    int i = localbkyu.b(BaseApplicationImpl.getContext(), ((QQAppInterface)localObject).getAccount());
    if (localbkyu.a(BaseApplicationImpl.getContext(), ((QQAppInterface)localObject).getAccount()) != k) {
      i = 0;
    }
    for (;;)
    {
      if (j != i)
      {
        if ((paramConfig.msg_content_list == null) || (paramConfig.msg_content_list.size() <= 0)) {
          break label212;
        }
        localObject = paramConfig.msg_content_list.get().iterator();
        if (((Iterator)localObject).hasNext())
        {
          paramConfig = (ConfigurationService.Content)((Iterator)localObject).next();
          if (paramConfig.compress.get() != 1) {
            break label198;
          }
          paramConfig = localbkyu.a(paramConfig.content.get().toByteArray());
          if (paramConfig == null) {
            break label230;
          }
          paramConfig = new String(paramConfig);
        }
      }
      for (;;)
      {
        try
        {
          localbkyu.a(paramConfig, j, k);
        }
        catch (Exception paramConfig)
        {
          QLog.e("NCtr", 1, "[handleLimitNotifyConfig] parse fail", paramConfig);
        }
        return;
        label198:
        paramConfig = paramConfig.content.get().toStringUtf8();
        continue;
        label212:
        QLog.i("NCtr", 1, "[hangleLimitNotifyConfig] config has no data");
        localbkyu.a(jdField_a_of_type_JavaLangString);
        return;
        label230:
        paramConfig = null;
      }
    }
  }
  
  /* Error */
  private void C(ConfigurationService.Config paramConfig)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 47	arph:getAppRuntime	()Lmqq/app/AppRuntime;
    //   4: checkcast 49	com/tencent/mobileqq/app/QQAppInterface
    //   7: astore 8
    //   9: aload_1
    //   10: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   13: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   16: istore_3
    //   17: aload 8
    //   19: invokevirtual 65	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   22: aload 8
    //   24: invokevirtual 69	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   27: invokestatic 305	bhhr:aU	(Landroid/content/Context;Ljava/lang/String;)I
    //   30: istore_2
    //   31: aload 8
    //   33: invokevirtual 65	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   36: aload 8
    //   38: invokevirtual 69	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   41: invokestatic 308	bhhr:aV	(Landroid/content/Context;Ljava/lang/String;)I
    //   44: istore 4
    //   46: invokestatic 210	com/tencent/common/config/AppSetting:a	()I
    //   49: istore 5
    //   51: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   54: ifeq +50 -> 104
    //   57: ldc_w 310
    //   60: iconst_2
    //   61: ldc_w 312
    //   64: iconst_4
    //   65: anewarray 314	java/lang/Object
    //   68: dup
    //   69: iconst_0
    //   70: iload_3
    //   71: invokestatic 318	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   74: aastore
    //   75: dup
    //   76: iconst_1
    //   77: iload_2
    //   78: invokestatic 318	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   81: aastore
    //   82: dup
    //   83: iconst_2
    //   84: iload 4
    //   86: invokestatic 318	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   89: aastore
    //   90: dup
    //   91: iconst_3
    //   92: iload 5
    //   94: invokestatic 318	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   97: aastore
    //   98: invokestatic 322	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   101: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   104: iload 4
    //   106: iload 5
    //   108: if_icmpeq +20 -> 128
    //   111: aload 8
    //   113: invokevirtual 65	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   116: iload 5
    //   118: aload 8
    //   120: invokevirtual 69	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   123: invokestatic 325	bhhr:A	(Landroid/content/Context;ILjava/lang/String;)V
    //   126: iconst_0
    //   127: istore_2
    //   128: iload_3
    //   129: iload_2
    //   130: if_icmpeq +66 -> 196
    //   133: aload_1
    //   134: getfield 234	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   137: ifnull +275 -> 412
    //   140: aload_1
    //   141: getfield 234	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   144: invokevirtual 327	com/tencent/mobileqq/pb/PBRepeatMessageField:isEmpty	()Z
    //   147: ifne +265 -> 412
    //   150: aload_1
    //   151: getfield 234	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   154: iconst_0
    //   155: invokevirtual 330	com/tencent/mobileqq/pb/PBRepeatMessageField:get	(I)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   158: checkcast 257	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content
    //   161: astore 7
    //   163: aload 7
    //   165: getfield 261	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content:compress	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   168: invokevirtual 264	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   171: iconst_1
    //   172: if_icmpne +207 -> 379
    //   175: aload 7
    //   177: getfield 268	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content:content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   180: invokevirtual 273	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   183: invokevirtual 279	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   186: invokestatic 333	ayym:a	([B)[B
    //   189: astore 7
    //   191: aload 7
    //   193: ifnonnull +4 -> 197
    //   196: return
    //   197: new 118	java/lang/String
    //   200: dup
    //   201: aload 7
    //   203: ldc_w 335
    //   206: invokespecial 338	java/lang/String:<init>	([BLjava/lang/String;)V
    //   209: astore 7
    //   211: new 128	org/json/JSONObject
    //   214: dup
    //   215: aload 7
    //   217: invokespecial 131	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   220: ldc_w 340
    //   223: invokevirtual 344	org/json/JSONObject:getBoolean	(Ljava/lang/String;)Z
    //   226: istore 6
    //   228: aload 8
    //   230: invokevirtual 65	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   233: ldc_w 346
    //   236: iconst_4
    //   237: invokevirtual 352	com/tencent/qphone/base/util/BaseApplication:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   240: invokeinterface 358 1 0
    //   245: ldc_w 360
    //   248: iload 6
    //   250: invokeinterface 366 3 0
    //   255: invokeinterface 369 1 0
    //   260: aload 8
    //   262: invokevirtual 65	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   265: aload_1
    //   266: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   269: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   272: getstatic 15	arph:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   275: invokestatic 372	bhhr:z	(Landroid/content/Context;ILjava/lang/String;)V
    //   278: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   281: ifeq +30 -> 311
    //   284: ldc 189
    //   286: iconst_2
    //   287: new 85	java/lang/StringBuilder
    //   290: dup
    //   291: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   294: ldc_w 374
    //   297: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   300: iload 6
    //   302: invokevirtual 152	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   305: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   308: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   311: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   314: ifeq -118 -> 196
    //   317: ldc 189
    //   319: iconst_2
    //   320: new 85	java/lang/StringBuilder
    //   323: dup
    //   324: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   327: ldc_w 376
    //   330: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   333: aload 7
    //   335: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   338: ldc_w 378
    //   341: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   344: aload_1
    //   345: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   348: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   351: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   354: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   357: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   360: return
    //   361: astore_1
    //   362: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   365: ifeq -169 -> 196
    //   368: ldc 189
    //   370: iconst_2
    //   371: aload_1
    //   372: invokestatic 382	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   375: invokestatic 385	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   378: return
    //   379: aload 7
    //   381: getfield 268	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content:content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   384: invokevirtual 273	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   387: invokevirtual 293	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   390: astore 7
    //   392: goto -181 -> 211
    //   395: astore 8
    //   397: ldc 189
    //   399: iconst_1
    //   400: aload 8
    //   402: iconst_0
    //   403: anewarray 314	java/lang/Object
    //   406: invokestatic 388	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   409: goto -98 -> 311
    //   412: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   415: ifeq +35 -> 450
    //   418: ldc 189
    //   420: iconst_2
    //   421: new 85	java/lang/StringBuilder
    //   424: dup
    //   425: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   428: ldc_w 390
    //   431: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   434: aload_1
    //   435: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   438: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   441: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   444: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   447: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   450: aload 8
    //   452: invokevirtual 65	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   455: ldc_w 346
    //   458: iconst_4
    //   459: invokevirtual 352	com/tencent/qphone/base/util/BaseApplication:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   462: invokeinterface 358 1 0
    //   467: astore_1
    //   468: aload_1
    //   469: ldc_w 346
    //   472: invokeinterface 394 2 0
    //   477: pop
    //   478: aload_1
    //   479: invokeinterface 369 1 0
    //   484: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	485	0	this	arph
    //   0	485	1	paramConfig	ConfigurationService.Config
    //   30	101	2	i	int
    //   16	115	3	j	int
    //   44	65	4	k	int
    //   49	68	5	m	int
    //   226	75	6	bool	boolean
    //   161	230	7	localObject	Object
    //   7	254	8	localQQAppInterface	QQAppInterface
    //   395	56	8	localJSONException	JSONException
    // Exception table:
    //   from	to	target	type
    //   197	211	361	java/lang/Throwable
    //   211	311	395	org/json/JSONException
  }
  
  public static void N(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    int i = paramConfig.version.get();
    int j = bhhr.aR(BaseApplication.getContext(), jdField_a_of_type_JavaLangString);
    if (QLog.isColorLevel()) {
      QLog.i("SPLASH_ConfigServlet", 2, "handleWeiYunMiniAppConfig: ,version: " + paramConfig.version.get() + "| localVersion: " + j);
    }
    if (i != j)
    {
      bhhr.ah(BaseApplication.getContext(), jdField_a_of_type_JavaLangString, i);
      paramConfig = a(paramConfig);
      if ((paramConfig != null) && (paramConfig.size() > 0))
      {
        paramConfig = paramConfig.iterator();
        while (paramConfig.hasNext())
        {
          Object localObject = (String)paramConfig.next();
          try
          {
            localObject = new JSONObject((String)localObject);
            if (((JSONObject)localObject).has("isWeiYunMiniApp"))
            {
              i = ((JSONObject)localObject).getInt("isWeiYunMiniApp");
              bhhr.x(BaseApplication.getContext(), i, paramQQAppInterface.getCurrentAccountUin());
              if (QLog.isColorLevel()) {
                QLog.d("SPLASH_ConfigServlet", 2, "handleWeiYunMiniAppConfig, enableMiniApp = " + i);
              }
            }
            if (((JSONObject)localObject).has("apkgUrl"))
            {
              String str = ((JSONObject)localObject).getString("apkgUrl");
              bhhr.v(BaseApplication.getContext(), str, paramQQAppInterface.getCurrentAccountUin());
              if (QLog.isColorLevel()) {
                QLog.d("SPLASH_ConfigServlet", 2, "handleWeiYunMiniAppConfig, apkgUrl = " + str);
              }
            }
            if (((JSONObject)localObject).has("miniVersion"))
            {
              i = ((JSONObject)localObject).getInt("miniVersion");
              bhhr.y(BaseApplication.getContext(), i, paramQQAppInterface.getCurrentAccountUin());
              if (QLog.isColorLevel()) {
                QLog.d("SPLASH_ConfigServlet", 2, "handleWeiYunMiniAppConfig, miniVersion = " + i);
              }
            }
          }
          catch (JSONException localJSONException)
          {
            localJSONException.printStackTrace();
          }
        }
      }
    }
    else if (QLog.isColorLevel())
    {
      QLog.i("SPLASH_ConfigServlet", 2, "handleWeiYunMiniAppConfig:localVersiont == version ");
    }
  }
  
  public static void O(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    int i = paramConfig.version.get();
    int j = bhhr.aX(BaseApplication.getContext(), jdField_a_of_type_JavaLangString);
    if (QLog.isColorLevel()) {
      QLog.i("SPLASH_ConfigServlet", 2, "handleAIOConfig: ,version: " + paramConfig.version.get() + "| localVersion: " + j);
    }
    if (i != j)
    {
      bhhr.aj(BaseApplication.getContext(), jdField_a_of_type_JavaLangString, i);
      paramConfig = a(paramConfig);
      if ((paramConfig == null) || (paramConfig.size() <= 0)) {}
    }
    while (!QLog.isColorLevel()) {
      try
      {
        paramConfig = (String)paramConfig.get(paramConfig.size() - 1);
        bhhr.c(BaseApplication.getContext(), jdField_a_of_type_JavaLangString, "aio_config_key", paramConfig);
        afoc.a(paramQQAppInterface);
        return;
      }
      catch (Exception paramQQAppInterface)
      {
        paramQQAppInterface.printStackTrace();
        return;
      }
    }
    QLog.i("SPLASH_ConfigServlet", 2, "handleReceiptConfig:localVersiont == version ");
  }
  
  public static void P(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    int i = paramConfig.version.get();
    int j = bhhr.aY(BaseApplication.getContext(), jdField_a_of_type_JavaLangString);
    if (QLog.isColorLevel()) {
      QLog.i("SPLASH_ConfigServlet", 2, "handleMultiMsgConfig: ,version: " + paramConfig.version.get() + "| localVersion: " + j);
    }
    if (i != j)
    {
      bhhr.ak(BaseApplication.getContext(), jdField_a_of_type_JavaLangString, i);
      paramConfig = a(paramConfig);
      if ((paramConfig == null) || (paramConfig.size() <= 0)) {}
    }
    while (!QLog.isColorLevel()) {
      try
      {
        i = new JSONObject((String)paramConfig.get(paramConfig.size() - 1)).optInt("max_multimsg_totalcount");
        bhhr.g(BaseApplication.getContext(), jdField_a_of_type_JavaLangString, "multimsg_config", i);
        if (QLog.isColorLevel()) {
          QLog.i("SPLASH_ConfigServlet", 2, "handleMultiMsgConfig:limitTotal =  " + i);
        }
        axio.a().a(paramQQAppInterface);
        return;
      }
      catch (Exception paramQQAppInterface)
      {
        paramQQAppInterface.printStackTrace();
        return;
      }
    }
    QLog.i("SPLASH_ConfigServlet", 2, "handleReceiptConfig:localVersiont == version ");
  }
  
  private void Q(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    int i = paramConfig.version.get();
    int j = bhhr.aA(BaseApplication.getContext(), jdField_a_of_type_JavaLangString);
    if (QLog.isColorLevel()) {
      QLog.i("SPLASH_ConfigServlet", 2, "handleConversationPublicAccConfig: ,version: " + paramConfig.version.get() + "| localVersion: " + j);
    }
    if (i != j)
    {
      bhhr.U(BaseApplication.getContext(), jdField_a_of_type_JavaLangString, i);
      paramConfig = a(paramConfig);
      if ((paramConfig == null) || (paramConfig.size() <= 0)) {
        break label443;
      }
      Iterator localIterator = paramConfig.iterator();
      paramConfig = null;
      if (!localIterator.hasNext()) {
        break label443;
      }
      Object localObject1 = (String)localIterator.next();
      if (QLog.isColorLevel()) {
        QLog.i("SPLASH_ConfigServlet", 2, "handleConversationPublicAccConfig: config_content =" + (String)localObject1);
      }
      for (;;)
      {
        Object localObject3;
        try
        {
          localObject1 = new JSONObject((String)localObject1);
          if (((JSONObject)localObject1).has("enable"))
          {
            i = ((JSONObject)localObject1).getInt("enable");
            localObject3 = alia.a();
            if (i == 1)
            {
              bool = true;
              ((alia)localObject3).a(paramQQAppInterface, bool);
              if (!((JSONObject)localObject1).has("list")) {
                break label417;
              }
              localObject3 = ((JSONObject)localObject1).getJSONArray("list");
              if ((localObject3 == null) || (((JSONArray)localObject3).length() <= 0)) {
                break label406;
              }
              j = ((JSONArray)localObject3).length();
              localObject1 = new HashSet();
              i = 0;
              if (i >= j) {
                break;
              }
            }
          }
        }
        catch (JSONException localJSONException1) {}
        try
        {
          paramConfig = ((JSONArray)localObject3).optString(i);
          if (!TextUtils.isEmpty(paramConfig)) {
            ((HashSet)localObject1).add(paramConfig);
          }
          i += 1;
        }
        catch (JSONException localJSONException2)
        {
          for (;;)
          {
            paramConfig = localJSONException1;
            localObject2 = localJSONException2;
          }
        }
        boolean bool = false;
        continue;
        alia.a().a(paramQQAppInterface, false);
        continue;
        if (QLog.isColorLevel()) {
          QLog.i("SPLASH_ConfigServlet", 2, "handleConversationPublicAccConfig  error =" + localJSONException1.getMessage());
        }
        alia.a().a(paramQQAppInterface, false);
        alia.a().a(paramQQAppInterface, null);
      }
    }
    label406:
    label417:
    label443:
    label444:
    for (;;)
    {
      break;
      alia.a().a(paramQQAppInterface, localJSONException1);
      paramConfig = localJSONException1;
      continue;
      Object localObject2;
      alia.a().a(paramQQAppInterface, paramConfig);
      break label444;
      alia.a().a(paramQQAppInterface, paramConfig);
      break label444;
      if (QLog.isColorLevel()) {
        QLog.i("SPLASH_ConfigServlet", 2, "handleConversationPublicAccConfig:localVersiont == version ");
      }
      return;
    }
  }
  
  private void R(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    int i = paramConfig.version.get();
    int j = bhhr.a();
    if (QLog.isColorLevel()) {
      QLog.i("SPLASH_ConfigServlet", 2, "handleBeancurdConfig: ,version: " + paramConfig.version.get() + "| localVersion: " + j);
    }
    if (i != j)
    {
      bhhr.a(i);
      paramConfig = a(paramConfig);
      if ((paramConfig != null) && (paramConfig.size() > 0))
      {
        paramConfig = (String)paramConfig.get(paramConfig.size() - 1);
        if (QLog.isColorLevel()) {
          QLog.i("SPLASH_ConfigServlet", 2, "handleBeancurdConfigStr: " + paramConfig);
        }
        bhhr.b(paramConfig);
        ((afqy)paramQQAppInterface.getManager(QQManagerFactory.BEANCURD_MANAGER)).a(paramConfig);
      }
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.i("SPLASH_ConfigServlet", 2, "handleZhituConfig:localVersiont == version ");
  }
  
  private void S(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    int i = paramConfig.version.get();
    int j = bhhr.az(BaseApplication.getContext(), jdField_a_of_type_JavaLangString);
    if (QLog.isColorLevel()) {
      QLog.i("SPLASH_ConfigServlet", 2, "handleZhituConfig: ,version: " + paramConfig.version.get() + "| localVersion: " + j);
    }
    if (i != j)
    {
      bhhr.T(BaseApplication.getContext(), jdField_a_of_type_JavaLangString, i);
      paramConfig = a(paramConfig);
      if ((paramConfig != null) && (paramConfig.size() > 0))
      {
        paramConfig = paramConfig.iterator();
        if (paramConfig.hasNext())
        {
          Object localObject = (String)paramConfig.next();
          if (QLog.isColorLevel()) {
            QLog.i("SPLASH_ConfigServlet", 2, "handleZhituConfig: config_content =" + (String)localObject);
          }
          for (;;)
          {
            try
            {
              localObject = new JSONObject((String)localObject);
              aioi localaioi;
              if (((JSONObject)localObject).has("kMarioConfigEnable"))
              {
                i = ((JSONObject)localObject).getInt("kMarioConfigEnable");
                localaioi = aioi.a(paramQQAppInterface);
                if (i != 1) {
                  break label324;
                }
                bool = true;
                localaioi.a(bool);
              }
              if (((JSONObject)localObject).has("kMarioPageLen"))
              {
                i = ((JSONObject)localObject).getInt("kMarioPageLen");
                aioi.a(paramQQAppInterface).b(i);
              }
              if (((JSONObject)localObject).has("kMarioSaveAndShareEnable"))
              {
                i = ((JSONObject)localObject).getInt("kMarioSaveAndShareEnable");
                localaioi = aioi.a(paramQQAppInterface);
                if (i != 1) {
                  break label330;
                }
                bool = true;
                localaioi.b(bool);
              }
              if (!((JSONObject)localObject).has("kMarioSafeGateRequestInterval")) {
                break;
              }
              i = ((JSONObject)localObject).getInt("kMarioSafeGateRequestInterval");
              aioi.a(paramQQAppInterface).a(i);
            }
            catch (JSONException localJSONException)
            {
              localJSONException.printStackTrace();
            }
            break;
            label324:
            boolean bool = false;
            continue;
            label330:
            bool = false;
          }
        }
      }
    }
    else if (QLog.isColorLevel())
    {
      QLog.i("SPLASH_ConfigServlet", 2, "handleZhituConfig:localVersiont == version ");
    }
  }
  
  private void T(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    a(paramQQAppInterface, paramConfig, "handleShortVideoMsgTailConfig", new arpi(this, paramQQAppInterface));
  }
  
  private void U(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    for (;;)
    {
      int i;
      Object localObject;
      try
      {
        if ((paramConfig.content_list != null) && (paramConfig.content_list.size() > 0))
        {
          i = 0;
          if (i < paramConfig.content_list.size())
          {
            localObject = ((String)paramConfig.content_list.get(i)).trim();
            if (QLog.isColorLevel()) {
              QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 96,content: " + (String)localObject + ",version: " + paramConfig.version.get());
            }
            int j = paramConfig.version.get();
            if ((j == bhhr.a(paramQQAppInterface.getApp(), "readinjoy_interested_push_config", jdField_a_of_type_JavaLangString)) || (TextUtils.isEmpty((CharSequence)localObject))) {
              break label412;
            }
            localObject = ((String)localObject).split("=");
            if (localObject.length >= 2)
            {
              if (!"xqh_insert_into_feeds".equals(localObject[0])) {
                continue;
              }
              bmhv.c(paramQQAppInterface, "1".equals(localObject[1]));
              if (QLog.isColorLevel()) {
                QLog.d("SPLASH_ConfigServlet", 2, "update KANDIAN_INTERESTED_PUSH_CONFiG config , switch : " + "1".equals(localObject[1]));
              }
            }
            bhhr.a(paramQQAppInterface.getApp(), "readinjoy_interested_push_config", jdField_a_of_type_JavaLangString, j);
            break label469;
            if ("simple_switch_fm".equals(localObject[0]))
            {
              bmhv.c(paramQQAppInterface, "1".equals(localObject[1]));
              if (!QLog.isColorLevel()) {
                continue;
              }
              QLog.d("SPLASH_ConfigServlet", 2, "update READINJOY_SIMPLE_SWITCH_FM config , switch : " + "1".equals(localObject[1]));
              continue;
            }
          }
          else
          {
            return;
          }
        }
      }
      catch (Exception paramQQAppInterface)
      {
        if (QLog.isColorLevel()) {
          QLog.e("SPLASH_ConfigServlet", 2, "received readinjoy interested push config error,cmd : 96" + paramQQAppInterface.toString());
        }
      }
      label412:
      do
      {
        if (!"simple_force_report_once".equals(localObject[0])) {
          break;
        }
        qdz.a(paramQQAppInterface, "1".equals(localObject[1]));
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("SPLASH_ConfigServlet", 2, "update simple_force_report_once config , switch : " + "1".equals(localObject[1]));
        break;
        if (!QLog.isColorLevel()) {
          break label469;
        }
        QLog.d("SPLASH_ConfigServlet", 2, "received KANDIAN_INTERESTED_PUSH_CONFiG IGNORE THIS ACTION  because of SAME VERSION ");
        break label469;
      } while (!QLog.isColorLevel());
      QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 96,content_list is empty ,version: " + paramConfig.version.get());
      return;
      label469:
      i += 1;
    }
  }
  
  private void V(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    for (;;)
    {
      int i;
      try
      {
        if ((paramConfig.content_list != null) && (paramConfig.content_list.size() > 0))
        {
          i = 0;
          if (i < paramConfig.content_list.size())
          {
            Object localObject = ((String)paramConfig.content_list.get(i)).trim();
            if (QLog.isColorLevel()) {
              QLog.d("SPLASH_ConfigServletQ.qqstory.TAG_NOW_ENTRANCE_ACTION_CONFIG", 2, "receiveAllConfigs|type: 118,content: " + (String)localObject + ",version: " + paramConfig.version.get());
            }
            int k = paramConfig.version.get();
            if (k != bhhr.a(paramQQAppInterface.getApp(), "now_entrance_action_version", jdField_a_of_type_JavaLangString))
            {
              boolean bool = TextUtils.isEmpty((CharSequence)localObject);
              if (!bool) {
                try
                {
                  localObject = new JSONArray((String)localObject);
                  int m = ((JSONArray)localObject).length();
                  int j = 0;
                  if (j < m)
                  {
                    JSONObject localJSONObject = ((JSONArray)localObject).getJSONObject(j);
                    bhhr.c(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin(), localJSONObject.optInt("bid"), localJSONObject.optInt("actionType"));
                    j += 1;
                    continue;
                  }
                  if (!QLog.isColorLevel()) {
                    break label341;
                  }
                }
                catch (JSONException localJSONException)
                {
                  if (QLog.isColorLevel()) {
                    QLog.e("SPLASH_ConfigServletQ.qqstory.TAG_NOW_ENTRANCE_ACTION_CONFIG", 2, "received JSONException ");
                  }
                  bhhr.a(paramQQAppInterface.getApp(), "now_entrance_action_version", jdField_a_of_type_JavaLangString, k);
                }
              }
            }
            QLog.d("SPLASH_ConfigServletQ.qqstory.TAG_NOW_ENTRANCE_ACTION_CONFIG", 2, "received CHNAGE_MACHINE_CONFIG IGNORE THIS ACTION  because of SAME VERSION ");
          }
        }
      }
      catch (Exception paramQQAppInterface)
      {
        if (QLog.isColorLevel()) {
          QLog.e("SPLASH_ConfigServletQ.qqstory.TAG_NOW_ENTRANCE_ACTION_CONFIG", 2, "received change machine config error,cmd : 118" + paramQQAppInterface.toString());
        }
      }
      while (!QLog.isColorLevel()) {
        return;
      }
      QLog.d("SPLASH_ConfigServletQ.qqstory.TAG_NOW_ENTRANCE_ACTION_CONFIG", 2, "receiveAllConfigs|type: 118,content_list is empty ,version: " + paramConfig.version.get());
      return;
      label341:
      i += 1;
    }
  }
  
  private void W(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    for (;;)
    {
      int i;
      try
      {
        if ((paramConfig.content_list != null) && (paramConfig.content_list.size() > 0))
        {
          i = 0;
          if (i < paramConfig.content_list.size())
          {
            Object localObject = ((String)paramConfig.content_list.get(i)).trim();
            if (QLog.isColorLevel()) {
              QLog.d("SPLASH_ConfigServlet.troop_common_config", 2, "receiveAllConfigs|type: 142,content: " + (String)localObject + ",version: " + paramConfig.version.get());
            }
            int j = paramConfig.version.get();
            if (j == bhhr.a(paramQQAppInterface.getApp(), "troop_common_config_version", jdField_a_of_type_JavaLangString)) {
              break label641;
            }
            boolean bool = TextUtils.isEmpty((CharSequence)localObject);
            if (bool) {
              break label641;
            }
            try
            {
              JSONObject localJSONObject = new JSONObject((String)localObject);
              bhhr.e(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin(), localJSONObject.optString("hot_chat_link"));
              bhhr.v(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin(), localJSONObject.optInt("aio_post_tab_plugin"));
              ((bgls)paramQQAppInterface.getManager(QQManagerFactory.TROOP_ROBOT_MANAGER)).a(localJSONObject);
              ((aozl)paramQQAppInterface.getManager(QQManagerFactory.LBS_REPORT_MANAGER)).a(localJSONObject);
              bhhr.u(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin(), localJSONObject.optInt("create_troop_max_invite_num"));
              String str1 = localJSONObject.optString("nearby_faceVideo_show");
              String str2 = localJSONObject.optString("nearby_faceVideo_LV");
              String str3 = localJSONObject.optString("nearby_heart_switch");
              SharedPreferences localSharedPreferences = BaseApplicationImpl.getContext().getSharedPreferences("nearby_enters", 4);
              localSharedPreferences.edit().putString("config_content", (String)localObject).commit();
              localSharedPreferences.edit().putString("nearby_faceVideo_show", str1).commit();
              localSharedPreferences.edit().putString("nearby_heart_switch", str3).commit();
              localSharedPreferences.edit().putString("nearby_faceVideo_LV", str2).commit();
              localObject = localJSONObject.optJSONObject("face_score_enter_config");
              if (!TextUtils.isEmpty(((JSONObject)localObject).optString("title"))) {
                localSharedPreferences.edit().putString("face_title", ((JSONObject)localObject).optString("title")).commit();
              }
              if (!TextUtils.isEmpty(((JSONObject)localObject).optString("detail_default"))) {
                localSharedPreferences.edit().putString("face_detail_default", ((JSONObject)localObject).optString("detail_default")).commit();
              }
              if (!TextUtils.isEmpty(((JSONObject)localObject).optString("jump_url"))) {
                localSharedPreferences.edit().putString("face_jump_url", ((JSONObject)localObject).optString("jump_url")).commit();
              }
              if (!TextUtils.isEmpty(((JSONObject)localObject).optString("detail_num"))) {
                localSharedPreferences.edit().putString("face_detail_num", ((JSONObject)localObject).optString("detail_num")).commit();
              }
              bhhr.E(paramQQAppInterface.getApp(), localJSONObject.optString("group_houseKeeper_switch"));
            }
            catch (JSONException localJSONException)
            {
              if (!QLog.isColorLevel()) {
                continue;
              }
              QLog.e("SPLASH_ConfigServlet.troop_common_config", 2, "received JSONException ");
              continue;
            }
            bhhr.a(paramQQAppInterface.getApp(), "troop_common_config_version", jdField_a_of_type_JavaLangString, j);
          }
        }
      }
      catch (Exception paramQQAppInterface)
      {
        if (QLog.isColorLevel()) {
          QLog.e("SPLASH_ConfigServlet.troop_common_config", 2, "received change machine config error,cmd : 142" + paramQQAppInterface.toString());
        }
      }
      label641:
      do
      {
        return;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("SPLASH_ConfigServlet.troop_common_config", 2, "received CHNAGE_MACHINE_CONFIG IGNORE THIS ACTION  because of SAME VERSION ");
        break;
      } while (!QLog.isColorLevel());
      QLog.d("SPLASH_ConfigServlet.troop_common_config", 2, "receiveAllConfigs|type: 142,content_list is empty ,version: " + paramConfig.version.get());
      return;
      i += 1;
    }
  }
  
  private void X(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    for (;;)
    {
      int i;
      try
      {
        if ((paramConfig.content_list != null) && (paramConfig.content_list.size() > 0))
        {
          i = 0;
          if (i < paramConfig.content_list.size())
          {
            Object localObject = ((String)paramConfig.content_list.get(i)).trim();
            if (QLog.isColorLevel()) {
              QLog.d("SPLASH_ConfigServletQ.nearby.tag_nearby_config", 2, "receiveAllConfigs|type: 201,content: " + (String)localObject + ",version: " + paramConfig.version.get());
            }
            int j = paramConfig.version.get();
            if (j != bhhr.a(paramQQAppInterface.getApp(), "nearby_config_version", jdField_a_of_type_JavaLangString))
            {
              boolean bool = TextUtils.isEmpty((CharSequence)localObject);
              if (!bool) {
                try
                {
                  localObject = new JSONObject((String)localObject);
                  bhhr.a(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin(), (JSONObject)localObject);
                  bhhr.a(paramQQAppInterface.getApp(), "nearby_config_version", jdField_a_of_type_JavaLangString, j);
                }
                catch (JSONException localJSONException)
                {
                  if (!QLog.isColorLevel()) {
                    continue;
                  }
                  QLog.e("SPLASH_ConfigServletQ.nearby.tag_nearby_config", 2, "received JSONException ");
                  continue;
                }
              }
            }
          }
          else
          {
            return;
          }
        }
      }
      catch (Exception paramQQAppInterface)
      {
        if (QLog.isColorLevel()) {
          QLog.e("SPLASH_ConfigServletQ.nearby.tag_nearby_config", 2, "received change machine config error,cmd : 201" + paramQQAppInterface.toString());
        }
      }
      while (QLog.isColorLevel())
      {
        QLog.d("SPLASH_ConfigServletQ.nearby.tag_nearby_config", 2, "received CHNAGE_MACHINE_CONFIG IGNORE THIS ACTION  because of SAME VERSION ");
        break;
        if (QLog.isColorLevel())
        {
          QLog.d("SPLASH_ConfigServletQ.nearby.tag_nearby_config", 2, "receiveAllConfigs|type: 201,content_list is empty ,version: " + paramConfig.version.get());
          return;
        }
      }
      i += 1;
    }
  }
  
  private void Y(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    try
    {
      SharedPreferences.Editor localEditor = paramQQAppInterface.getApp().getSharedPreferences("NearbyActivity.nearByTabUrl", 4).edit();
      if ((paramConfig.content_list != null) && (paramConfig.content_list.size() > 0))
      {
        int i = 0;
        if (i < paramConfig.content_list.size())
        {
          Object localObject = ((String)paramConfig.content_list.get(i)).trim();
          if (QLog.isColorLevel()) {
            QLog.d("SPLASH_ConfigServletQ.nearby.tag_nearby_config", 2, "receiveAllConfigs|type: 129,content: " + (String)localObject + ",version: " + paramConfig.version.get());
          }
          int j = paramConfig.version.get();
          if (j != bhhr.a(paramQQAppInterface.getApp(), "nearby_nowlive_tab_config_version", jdField_a_of_type_JavaLangString))
          {
            boolean bool = TextUtils.isEmpty((CharSequence)localObject);
            if (!bool) {
              for (;;)
              {
                try
                {
                  localObject = new JSONObject((String)localObject);
                  String str1 = ((JSONObject)localObject).getJSONObject("android").getString("url");
                  String str2 = ((JSONObject)localObject).getJSONObject("android").getString("menuCell_startLive");
                  String str3 = ((JSONObject)localObject).getJSONObject("android").getString("menuCell_personalCenter");
                  String str4 = ((JSONObject)localObject).getJSONObject("android").getString("menuCell_help");
                  localEditor.putString("nearByTabUrl", str1);
                  localEditor.putString("menuCell_startLive", str2);
                  localEditor.putString("menuCell_personalCenter", str3);
                  localEditor.putString("menuCell_help", str4);
                  if (Build.VERSION.SDK_INT >= 9) {
                    continue;
                  }
                  localEditor.commit();
                  if (QLog.isColorLevel()) {
                    QLog.e("SPLASH_ConfigServletQ.nearby.tag_nearby_config", 2, "received NearbyActivity.nearByTabUrl " + ((JSONObject)localObject).getJSONObject("android"));
                  }
                }
                catch (JSONException localJSONException)
                {
                  if (!QLog.isColorLevel()) {
                    continue;
                  }
                  QLog.e("SPLASH_ConfigServletQ.nearby.tag_nearby_config", 2, "received JSONException in get NearbyActivity.nearByTabUrl");
                  continue;
                }
                bhhr.a(paramQQAppInterface.getApp(), "nearby_nowlive_tab_config_version", jdField_a_of_type_JavaLangString, j);
                i += 1;
                break;
                localEditor.apply();
              }
            }
          }
        }
        else
        {
          return;
        }
      }
    }
    catch (Exception paramQQAppInterface)
    {
      if (QLog.isColorLevel()) {
        QLog.e("SPLASH_ConfigServletQ.nearby.tag_nearby_config", 2, "received change machine config error,cmd : 129" + paramQQAppInterface.toString());
      }
    }
    do
    {
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("SPLASH_ConfigServletQ.nearby.tag_nearby_config", 2, "received CHNAGE_MACHINE_CONFIG IGNORE THIS ACTION  because of SAME VERSION ");
      break;
    } while (!QLog.isColorLevel());
    QLog.d("SPLASH_ConfigServletQ.nearby.tag_nearby_config", 2, "receiveAllConfigs|type: 129,content_list is empty ,version: " + paramConfig.version.get());
  }
  
  private void Z(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    for (;;)
    {
      try
      {
        j = paramConfig.version.get();
        k = bhhr.a(paramQQAppInterface.getApp(), "change_machine_version", jdField_a_of_type_JavaLangString);
        if (paramConfig.msg_content_list == null) {
          break label262;
        }
        i = paramConfig.msg_content_list.size();
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("SPLASH_ConfigServlet", 2, String.format("handleNearbyVideoChatConfig, serverVersion[%s], localVersion[%s], size[%s]", new Object[] { Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(i) }));
      }
      catch (Exception paramQQAppInterface)
      {
        int j;
        int k;
        bghm localbghm;
        if (!QLog.isColorLevel()) {
          break label261;
        }
        QLog.e("SPLASH_ConfigServlet", 2, "received handleNearbyVideoChatConfig error,cmd : 195", paramQQAppInterface);
        return;
        if (!QLog.isColorLevel()) {
          break label261;
        }
        QLog.d("SPLASH_ConfigServlet", 2, "GetDoodleTemplateConfig|type: handleNearbyVideoChatConfig null");
        return;
        localbghm.a("");
        if (!QLog.isColorLevel()) {
          break label261;
        }
        QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 195,content_list is empty ,version: " + paramConfig.version.get());
        return;
        if (j != k) {
          continue;
        }
      }
      localbghm = (bghm)paramQQAppInterface.getManager(QQManagerFactory.NEARBY_VIDEO_CHAT);
      if (i > 0)
      {
        paramConfig = b(paramConfig, k, 195);
        localbghm.a(paramConfig);
        if (!TextUtils.isEmpty(paramConfig))
        {
          bhhr.a(paramQQAppInterface.getApp(), "change_machine_version", jdField_a_of_type_JavaLangString, j);
          if (!QLog.isColorLevel()) {
            break label261;
          }
          QLog.d("SPLASH_ConfigServlet", 2, "GetDoodleTemplateConfig|type: handleNearbyVideoChatConfig, content: \n" + paramConfig);
          return;
        }
      }
      label261:
      return;
      label262:
      int i = -1;
    }
  }
  
  private float a(float paramFloat)
  {
    return paramFloat / (50.0F * 2.0F) * (float)DeviceInfoUtil.getDispalyWidth();
  }
  
  private float a(float paramFloat1, float paramFloat2)
  {
    return (50.0F + paramFloat1) / (50.0F * 2.0F) * paramFloat2;
  }
  
  private float a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return paramFloat2 / 2.0F - paramFloat1 * paramFloat3 / (50.0F * 2.0F);
  }
  
  private int a(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig, String paramString)
  {
    ShortVideoResourceManager localShortVideoResourceManager = paramQQAppInterface.getShortVideoResourceManager();
    if ((localShortVideoResourceManager == null) && ("ConfigurationService.ReqGetConfigNoLogin".equals(paramString))) {
      localShortVideoResourceManager = new ShortVideoResourceManager(paramQQAppInterface);
    }
    for (int j = 1;; j = 0)
    {
      int i = ShortVideoResourceManager.a();
      int k = paramConfig.version.get();
      QLog.d("ShortVideoResourceManager", 1, "receiveAllConfigs[handleShortVideoResourceConfig]|received remote version: " + k + " | localVersion: " + i);
      if (k != i) {
        if ((paramConfig.msg_content_list != null) && (paramConfig.msg_content_list.size() > 0))
        {
          paramConfig = (ConfigurationService.Content)paramConfig.msg_content_list.get(paramConfig.msg_content_list.size() - 1);
          if (paramConfig != null) {
            if (paramConfig.compress.get() == 1)
            {
              paramConfig = ayym.a(paramConfig.content.get().toByteArray());
              if (paramConfig == null) {}
            }
          }
        }
      }
      for (;;)
      {
        try
        {
          paramConfig = new String(paramConfig, "UTF-8");
          QLog.d("SPLASH_ConfigServlet", 1, "receiveAllConfigs[handleShortVideoResourceConfig]|config_content " + paramConfig);
          if (!"ConfigurationService.ReqGetConfigNoLogin".equals(paramString)) {
            break label300;
          }
          i = localShortVideoResourceManager.a(paramConfig, k);
          if (j != 0) {
            localShortVideoResourceManager.c();
          }
          return i;
        }
        catch (Throwable paramConfig)
        {
          QLog.d("SPLASH_ConfigServlet", 1, "receiveAllConfigs[handleShortVideoResourceConfig]|Throwable:" + paramConfig.getMessage());
          paramConfig = "";
          continue;
        }
        QLog.d("SPLASH_ConfigServlet", 1, "receiveAllConfigs[handleShortVideoResourceConfig]|inflateConfigString error!");
        paramConfig = "";
        continue;
        paramConfig = paramConfig.content.get().toStringUtf8();
        continue;
        label300:
        i = localShortVideoResourceManager.a(paramQQAppInterface.getApp(), paramConfig, k);
        continue;
        QLog.d("ShortVideoResourceManager", 1, "receiveAllConfigs[handleShortVideoResourceConfig]| content==null");
        i = -125;
        continue;
        QLog.d("ShortVideoResourceManager", 1, "receiveAllConfigs[handleShortVideoResourceConfig]| msg_content_list is empty ,version: " + k + ",localVersion:" + i);
        i = -125;
        continue;
        i = 0;
      }
    }
  }
  
  private static int a(String paramString1, String paramString2)
  {
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("MM-dd");
    try
    {
      long l = (localSimpleDateFormat.parse(paramString2).getTime() - localSimpleDateFormat.parse(paramString1).getTime()) / 86400000L;
      return (int)l;
    }
    catch (ParseException paramString1)
    {
      paramString1.printStackTrace();
    }
    return -1;
  }
  
  private QQOperationViopTipTask a(String paramString)
  {
    return a(paramString, new QQOperationViopTipTask());
  }
  
  /* Error */
  private QQOperationViopTipTask a(String paramString, QQOperationViopTipTask paramQQOperationViopTipTask)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: invokestatic 949	javax/xml/parsers/DocumentBuilderFactory:newInstance	()Ljavax/xml/parsers/DocumentBuilderFactory;
    //   5: invokevirtual 953	javax/xml/parsers/DocumentBuilderFactory:newDocumentBuilder	()Ljavax/xml/parsers/DocumentBuilder;
    //   8: new 955	java/io/ByteArrayInputStream
    //   11: dup
    //   12: aload_1
    //   13: ldc_w 957
    //   16: invokevirtual 961	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   19: invokespecial 962	java/io/ByteArrayInputStream:<init>	([B)V
    //   22: invokevirtual 967	javax/xml/parsers/DocumentBuilder:parse	(Ljava/io/InputStream;)Lorg/w3c/dom/Document;
    //   25: astore_1
    //   26: aload_1
    //   27: ldc_w 969
    //   30: invokeinterface 975 2 0
    //   35: astore 4
    //   37: aload 4
    //   39: ifnull +1254 -> 1293
    //   42: aload 4
    //   44: invokeinterface 980 1 0
    //   49: ifle +1244 -> 1293
    //   52: aload_1
    //   53: ldc_w 982
    //   56: invokeinterface 975 2 0
    //   61: astore 4
    //   63: aload 4
    //   65: ifnull +45 -> 110
    //   68: aload 4
    //   70: invokeinterface 980 1 0
    //   75: ifle +35 -> 110
    //   78: aload_2
    //   79: aload_1
    //   80: ldc_w 982
    //   83: invokeinterface 975 2 0
    //   88: iconst_0
    //   89: invokeinterface 986 2 0
    //   94: invokeinterface 992 1 0
    //   99: invokeinterface 995 1 0
    //   104: invokestatic 143	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   107: putfield 998	com/tencent/mobileqq/config/operation/QQOperationViopTipTask:taskid	I
    //   110: aload_1
    //   111: ldc_w 1000
    //   114: invokeinterface 975 2 0
    //   119: astore 4
    //   121: aload 4
    //   123: ifnull +45 -> 168
    //   126: aload 4
    //   128: invokeinterface 980 1 0
    //   133: ifle +35 -> 168
    //   136: aload_2
    //   137: aload_1
    //   138: ldc_w 1000
    //   141: invokeinterface 975 2 0
    //   146: iconst_0
    //   147: invokeinterface 986 2 0
    //   152: invokeinterface 992 1 0
    //   157: invokeinterface 995 1 0
    //   162: invokestatic 143	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   165: putfield 1003	com/tencent/mobileqq/config/operation/QQOperationViopTipTask:limitDayAIOCount	I
    //   168: aload_1
    //   169: ldc_w 1005
    //   172: invokeinterface 975 2 0
    //   177: astore 4
    //   179: aload 4
    //   181: ifnull +45 -> 226
    //   184: aload 4
    //   186: invokeinterface 980 1 0
    //   191: ifle +35 -> 226
    //   194: aload_2
    //   195: aload_1
    //   196: ldc_w 1005
    //   199: invokeinterface 975 2 0
    //   204: iconst_0
    //   205: invokeinterface 986 2 0
    //   210: invokeinterface 992 1 0
    //   215: invokeinterface 995 1 0
    //   220: invokestatic 143	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   223: putfield 1008	com/tencent/mobileqq/config/operation/QQOperationViopTipTask:limitDayAIOShowCount	I
    //   226: aload_1
    //   227: ldc_w 1010
    //   230: invokeinterface 975 2 0
    //   235: astore 4
    //   237: aload 4
    //   239: ifnull +45 -> 284
    //   242: aload 4
    //   244: invokeinterface 980 1 0
    //   249: ifle +35 -> 284
    //   252: aload_2
    //   253: aload_1
    //   254: ldc_w 1010
    //   257: invokeinterface 975 2 0
    //   262: iconst_0
    //   263: invokeinterface 986 2 0
    //   268: invokeinterface 992 1 0
    //   273: invokeinterface 995 1 0
    //   278: invokestatic 143	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   281: putfield 1013	com/tencent/mobileqq/config/operation/QQOperationViopTipTask:limitTotalAIOCount	I
    //   284: aload_1
    //   285: ldc_w 1015
    //   288: invokeinterface 975 2 0
    //   293: astore 4
    //   295: aload 4
    //   297: ifnull +45 -> 342
    //   300: aload 4
    //   302: invokeinterface 980 1 0
    //   307: ifle +35 -> 342
    //   310: aload_2
    //   311: aload_1
    //   312: ldc_w 1015
    //   315: invokeinterface 975 2 0
    //   320: iconst_0
    //   321: invokeinterface 986 2 0
    //   326: invokeinterface 992 1 0
    //   331: invokeinterface 995 1 0
    //   336: invokestatic 143	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   339: putfield 1018	com/tencent/mobileqq/config/operation/QQOperationViopTipTask:limitTotalShowCount	I
    //   342: aload_1
    //   343: ldc_w 1020
    //   346: invokeinterface 975 2 0
    //   351: astore 4
    //   353: aload 4
    //   355: ifnull +42 -> 397
    //   358: aload 4
    //   360: invokeinterface 980 1 0
    //   365: ifle +32 -> 397
    //   368: aload_2
    //   369: aload_1
    //   370: ldc_w 1020
    //   373: invokeinterface 975 2 0
    //   378: iconst_0
    //   379: invokeinterface 986 2 0
    //   384: invokeinterface 992 1 0
    //   389: invokeinterface 995 1 0
    //   394: invokevirtual 1023	com/tencent/mobileqq/config/operation/QQOperationViopTipTask:setKeywordString	(Ljava/lang/String;)V
    //   397: invokestatic 1026	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   400: ifeq +33 -> 433
    //   403: ldc_w 1028
    //   406: iconst_4
    //   407: new 85	java/lang/StringBuilder
    //   410: dup
    //   411: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   414: ldc_w 1030
    //   417: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   420: aload_2
    //   421: invokevirtual 1034	com/tencent/mobileqq/config/operation/QQOperationViopTipTask:getKeywordList	()Ljava/util/ArrayList;
    //   424: invokevirtual 825	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   427: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   430: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   433: aload_1
    //   434: ldc_w 1036
    //   437: invokeinterface 975 2 0
    //   442: astore 4
    //   444: aload 4
    //   446: ifnull +42 -> 488
    //   449: aload 4
    //   451: invokeinterface 980 1 0
    //   456: ifle +32 -> 488
    //   459: aload_2
    //   460: aload_1
    //   461: ldc_w 1036
    //   464: invokeinterface 975 2 0
    //   469: iconst_0
    //   470: invokeinterface 986 2 0
    //   475: invokeinterface 992 1 0
    //   480: invokeinterface 995 1 0
    //   485: invokevirtual 1039	com/tencent/mobileqq/config/operation/QQOperationViopTipTask:setBeginTime	(Ljava/lang/String;)V
    //   488: aload_1
    //   489: ldc_w 1041
    //   492: invokeinterface 975 2 0
    //   497: astore 4
    //   499: aload 4
    //   501: ifnull +42 -> 543
    //   504: aload 4
    //   506: invokeinterface 980 1 0
    //   511: ifle +32 -> 543
    //   514: aload_2
    //   515: aload_1
    //   516: ldc_w 1041
    //   519: invokeinterface 975 2 0
    //   524: iconst_0
    //   525: invokeinterface 986 2 0
    //   530: invokeinterface 992 1 0
    //   535: invokeinterface 995 1 0
    //   540: invokevirtual 1044	com/tencent/mobileqq/config/operation/QQOperationViopTipTask:setEndTime	(Ljava/lang/String;)V
    //   543: aload_1
    //   544: ldc_w 1046
    //   547: invokeinterface 975 2 0
    //   552: astore 4
    //   554: aload 4
    //   556: ifnull +50 -> 606
    //   559: aload 4
    //   561: invokeinterface 980 1 0
    //   566: ifle +40 -> 606
    //   569: aload_1
    //   570: ldc_w 1046
    //   573: invokeinterface 975 2 0
    //   578: iconst_0
    //   579: invokeinterface 986 2 0
    //   584: invokeinterface 992 1 0
    //   589: invokeinterface 995 1 0
    //   594: invokestatic 143	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   597: iconst_1
    //   598: if_icmpne +697 -> 1295
    //   601: aload_2
    //   602: iload_3
    //   603: putfield 1049	com/tencent/mobileqq/config/operation/QQOperationViopTipTask:uinType	I
    //   606: aload_1
    //   607: ldc_w 1051
    //   610: invokeinterface 975 2 0
    //   615: astore 4
    //   617: aload 4
    //   619: ifnull +197 -> 816
    //   622: aload 4
    //   624: invokeinterface 980 1 0
    //   629: ifle +187 -> 816
    //   632: aload_1
    //   633: ldc_w 1051
    //   636: invokeinterface 975 2 0
    //   641: iconst_0
    //   642: invokeinterface 986 2 0
    //   647: checkcast 1053	org/w3c/dom/Element
    //   650: ldc_w 1055
    //   653: invokeinterface 1056 2 0
    //   658: astore 4
    //   660: aload 4
    //   662: ifnull +62 -> 724
    //   665: aload 4
    //   667: invokeinterface 980 1 0
    //   672: ifle +52 -> 724
    //   675: aload_2
    //   676: aload_1
    //   677: ldc_w 1051
    //   680: invokeinterface 975 2 0
    //   685: iconst_0
    //   686: invokeinterface 986 2 0
    //   691: checkcast 1053	org/w3c/dom/Element
    //   694: ldc_w 1055
    //   697: invokeinterface 1056 2 0
    //   702: iconst_0
    //   703: invokeinterface 986 2 0
    //   708: invokeinterface 992 1 0
    //   713: invokeinterface 995 1 0
    //   718: invokestatic 143	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   721: putfield 1059	com/tencent/mobileqq/config/operation/QQOperationViopTipTask:frequencyTime	I
    //   724: aload_1
    //   725: ldc_w 1051
    //   728: invokeinterface 975 2 0
    //   733: iconst_0
    //   734: invokeinterface 986 2 0
    //   739: checkcast 1053	org/w3c/dom/Element
    //   742: ldc_w 1061
    //   745: invokeinterface 1056 2 0
    //   750: astore 4
    //   752: aload 4
    //   754: ifnull +62 -> 816
    //   757: aload 4
    //   759: invokeinterface 980 1 0
    //   764: ifle +52 -> 816
    //   767: aload_2
    //   768: aload_1
    //   769: ldc_w 1051
    //   772: invokeinterface 975 2 0
    //   777: iconst_0
    //   778: invokeinterface 986 2 0
    //   783: checkcast 1053	org/w3c/dom/Element
    //   786: ldc_w 1061
    //   789: invokeinterface 1056 2 0
    //   794: iconst_0
    //   795: invokeinterface 986 2 0
    //   800: invokeinterface 992 1 0
    //   805: invokeinterface 995 1 0
    //   810: invokestatic 143	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   813: putfield 1064	com/tencent/mobileqq/config/operation/QQOperationViopTipTask:frequencyMessage	I
    //   816: aload_1
    //   817: ldc_w 1066
    //   820: invokeinterface 975 2 0
    //   825: astore 4
    //   827: aload 4
    //   829: ifnull +464 -> 1293
    //   832: aload 4
    //   834: invokeinterface 980 1 0
    //   839: ifle +454 -> 1293
    //   842: aload_1
    //   843: ldc_w 1066
    //   846: invokeinterface 975 2 0
    //   851: iconst_0
    //   852: invokeinterface 986 2 0
    //   857: checkcast 1053	org/w3c/dom/Element
    //   860: ldc_w 1068
    //   863: invokeinterface 1056 2 0
    //   868: astore 4
    //   870: aload 4
    //   872: ifnull +62 -> 934
    //   875: aload 4
    //   877: invokeinterface 980 1 0
    //   882: ifle +52 -> 934
    //   885: aload_2
    //   886: aload_1
    //   887: ldc_w 1066
    //   890: invokeinterface 975 2 0
    //   895: iconst_0
    //   896: invokeinterface 986 2 0
    //   901: checkcast 1053	org/w3c/dom/Element
    //   904: ldc_w 1068
    //   907: invokeinterface 1056 2 0
    //   912: iconst_0
    //   913: invokeinterface 986 2 0
    //   918: invokeinterface 992 1 0
    //   923: invokeinterface 995 1 0
    //   928: invokestatic 143	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   931: putfield 1071	com/tencent/mobileqq/config/operation/QQOperationViopTipTask:tipType	I
    //   934: aload_1
    //   935: ldc_w 1066
    //   938: invokeinterface 975 2 0
    //   943: iconst_0
    //   944: invokeinterface 986 2 0
    //   949: checkcast 1053	org/w3c/dom/Element
    //   952: ldc_w 1061
    //   955: invokeinterface 1056 2 0
    //   960: astore 4
    //   962: aload 4
    //   964: ifnull +59 -> 1023
    //   967: aload 4
    //   969: invokeinterface 980 1 0
    //   974: ifle +49 -> 1023
    //   977: aload_2
    //   978: aload_1
    //   979: ldc_w 1066
    //   982: invokeinterface 975 2 0
    //   987: iconst_0
    //   988: invokeinterface 986 2 0
    //   993: checkcast 1053	org/w3c/dom/Element
    //   996: ldc_w 1061
    //   999: invokeinterface 1056 2 0
    //   1004: iconst_0
    //   1005: invokeinterface 986 2 0
    //   1010: invokeinterface 992 1 0
    //   1015: invokeinterface 995 1 0
    //   1020: putfield 1074	com/tencent/mobileqq/config/operation/QQOperationViopTipTask:adwords	Ljava/lang/String;
    //   1023: aload_1
    //   1024: ldc_w 1066
    //   1027: invokeinterface 975 2 0
    //   1032: iconst_0
    //   1033: invokeinterface 986 2 0
    //   1038: checkcast 1053	org/w3c/dom/Element
    //   1041: ldc_w 1076
    //   1044: invokeinterface 1056 2 0
    //   1049: astore 4
    //   1051: aload 4
    //   1053: ifnull +62 -> 1115
    //   1056: aload 4
    //   1058: invokeinterface 980 1 0
    //   1063: ifle +52 -> 1115
    //   1066: aload_2
    //   1067: aload_1
    //   1068: ldc_w 1066
    //   1071: invokeinterface 975 2 0
    //   1076: iconst_0
    //   1077: invokeinterface 986 2 0
    //   1082: checkcast 1053	org/w3c/dom/Element
    //   1085: ldc_w 1076
    //   1088: invokeinterface 1056 2 0
    //   1093: iconst_0
    //   1094: invokeinterface 986 2 0
    //   1099: invokeinterface 992 1 0
    //   1104: invokeinterface 995 1 0
    //   1109: invokestatic 143	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   1112: putfield 1079	com/tencent/mobileqq/config/operation/QQOperationViopTipTask:linkOffset	I
    //   1115: aload_1
    //   1116: ldc_w 1066
    //   1119: invokeinterface 975 2 0
    //   1124: iconst_0
    //   1125: invokeinterface 986 2 0
    //   1130: checkcast 1053	org/w3c/dom/Element
    //   1133: ldc_w 1081
    //   1136: invokeinterface 1056 2 0
    //   1141: astore 4
    //   1143: aload 4
    //   1145: ifnull +59 -> 1204
    //   1148: aload 4
    //   1150: invokeinterface 980 1 0
    //   1155: ifle +49 -> 1204
    //   1158: aload_2
    //   1159: aload_1
    //   1160: ldc_w 1066
    //   1163: invokeinterface 975 2 0
    //   1168: iconst_0
    //   1169: invokeinterface 986 2 0
    //   1174: checkcast 1053	org/w3c/dom/Element
    //   1177: ldc_w 1081
    //   1180: invokeinterface 1056 2 0
    //   1185: iconst_0
    //   1186: invokeinterface 986 2 0
    //   1191: invokeinterface 992 1 0
    //   1196: invokeinterface 995 1 0
    //   1201: putfield 1084	com/tencent/mobileqq/config/operation/QQOperationViopTipTask:clickableWord	Ljava/lang/String;
    //   1204: aload_1
    //   1205: ldc_w 1066
    //   1208: invokeinterface 975 2 0
    //   1213: iconst_0
    //   1214: invokeinterface 986 2 0
    //   1219: checkcast 1053	org/w3c/dom/Element
    //   1222: ldc_w 807
    //   1225: invokeinterface 1056 2 0
    //   1230: astore 4
    //   1232: aload 4
    //   1234: ifnull +59 -> 1293
    //   1237: aload 4
    //   1239: invokeinterface 980 1 0
    //   1244: ifle +49 -> 1293
    //   1247: aload_2
    //   1248: aload_1
    //   1249: ldc_w 1066
    //   1252: invokeinterface 975 2 0
    //   1257: iconst_0
    //   1258: invokeinterface 986 2 0
    //   1263: checkcast 1053	org/w3c/dom/Element
    //   1266: ldc_w 807
    //   1269: invokeinterface 1056 2 0
    //   1274: iconst_0
    //   1275: invokeinterface 986 2 0
    //   1280: invokeinterface 992 1 0
    //   1285: invokeinterface 995 1 0
    //   1290: putfield 1086	com/tencent/mobileqq/config/operation/QQOperationViopTipTask:url	Ljava/lang/String;
    //   1293: aload_2
    //   1294: areturn
    //   1295: sipush 3000
    //   1298: istore_3
    //   1299: goto -698 -> 601
    //   1302: astore_1
    //   1303: aload_1
    //   1304: invokevirtual 1087	javax/xml/parsers/ParserConfigurationException:printStackTrace	()V
    //   1307: aconst_null
    //   1308: areturn
    //   1309: astore_1
    //   1310: aload_1
    //   1311: invokevirtual 1088	org/xml/sax/SAXException:printStackTrace	()V
    //   1314: goto -7 -> 1307
    //   1317: astore_1
    //   1318: aload_1
    //   1319: invokevirtual 1089	java/io/IOException:printStackTrace	()V
    //   1322: goto -15 -> 1307
    //   1325: astore_1
    //   1326: aload_1
    //   1327: invokevirtual 472	java/lang/Exception:printStackTrace	()V
    //   1330: goto -23 -> 1307
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1333	0	this	arph
    //   0	1333	1	paramString	String
    //   0	1333	2	paramQQOperationViopTipTask	QQOperationViopTipTask
    //   1	1298	3	i	int
    //   35	1203	4	localNodeList	NodeList
    // Exception table:
    //   from	to	target	type
    //   2	37	1302	javax/xml/parsers/ParserConfigurationException
    //   42	63	1302	javax/xml/parsers/ParserConfigurationException
    //   68	110	1302	javax/xml/parsers/ParserConfigurationException
    //   110	121	1302	javax/xml/parsers/ParserConfigurationException
    //   126	168	1302	javax/xml/parsers/ParserConfigurationException
    //   168	179	1302	javax/xml/parsers/ParserConfigurationException
    //   184	226	1302	javax/xml/parsers/ParserConfigurationException
    //   226	237	1302	javax/xml/parsers/ParserConfigurationException
    //   242	284	1302	javax/xml/parsers/ParserConfigurationException
    //   284	295	1302	javax/xml/parsers/ParserConfigurationException
    //   300	342	1302	javax/xml/parsers/ParserConfigurationException
    //   342	353	1302	javax/xml/parsers/ParserConfigurationException
    //   358	397	1302	javax/xml/parsers/ParserConfigurationException
    //   397	433	1302	javax/xml/parsers/ParserConfigurationException
    //   433	444	1302	javax/xml/parsers/ParserConfigurationException
    //   449	488	1302	javax/xml/parsers/ParserConfigurationException
    //   488	499	1302	javax/xml/parsers/ParserConfigurationException
    //   504	543	1302	javax/xml/parsers/ParserConfigurationException
    //   543	554	1302	javax/xml/parsers/ParserConfigurationException
    //   559	601	1302	javax/xml/parsers/ParserConfigurationException
    //   601	606	1302	javax/xml/parsers/ParserConfigurationException
    //   606	617	1302	javax/xml/parsers/ParserConfigurationException
    //   622	660	1302	javax/xml/parsers/ParserConfigurationException
    //   665	724	1302	javax/xml/parsers/ParserConfigurationException
    //   724	752	1302	javax/xml/parsers/ParserConfigurationException
    //   757	816	1302	javax/xml/parsers/ParserConfigurationException
    //   816	827	1302	javax/xml/parsers/ParserConfigurationException
    //   832	870	1302	javax/xml/parsers/ParserConfigurationException
    //   875	934	1302	javax/xml/parsers/ParserConfigurationException
    //   934	962	1302	javax/xml/parsers/ParserConfigurationException
    //   967	1023	1302	javax/xml/parsers/ParserConfigurationException
    //   1023	1051	1302	javax/xml/parsers/ParserConfigurationException
    //   1056	1115	1302	javax/xml/parsers/ParserConfigurationException
    //   1115	1143	1302	javax/xml/parsers/ParserConfigurationException
    //   1148	1204	1302	javax/xml/parsers/ParserConfigurationException
    //   1204	1232	1302	javax/xml/parsers/ParserConfigurationException
    //   1237	1293	1302	javax/xml/parsers/ParserConfigurationException
    //   2	37	1309	org/xml/sax/SAXException
    //   42	63	1309	org/xml/sax/SAXException
    //   68	110	1309	org/xml/sax/SAXException
    //   110	121	1309	org/xml/sax/SAXException
    //   126	168	1309	org/xml/sax/SAXException
    //   168	179	1309	org/xml/sax/SAXException
    //   184	226	1309	org/xml/sax/SAXException
    //   226	237	1309	org/xml/sax/SAXException
    //   242	284	1309	org/xml/sax/SAXException
    //   284	295	1309	org/xml/sax/SAXException
    //   300	342	1309	org/xml/sax/SAXException
    //   342	353	1309	org/xml/sax/SAXException
    //   358	397	1309	org/xml/sax/SAXException
    //   397	433	1309	org/xml/sax/SAXException
    //   433	444	1309	org/xml/sax/SAXException
    //   449	488	1309	org/xml/sax/SAXException
    //   488	499	1309	org/xml/sax/SAXException
    //   504	543	1309	org/xml/sax/SAXException
    //   543	554	1309	org/xml/sax/SAXException
    //   559	601	1309	org/xml/sax/SAXException
    //   601	606	1309	org/xml/sax/SAXException
    //   606	617	1309	org/xml/sax/SAXException
    //   622	660	1309	org/xml/sax/SAXException
    //   665	724	1309	org/xml/sax/SAXException
    //   724	752	1309	org/xml/sax/SAXException
    //   757	816	1309	org/xml/sax/SAXException
    //   816	827	1309	org/xml/sax/SAXException
    //   832	870	1309	org/xml/sax/SAXException
    //   875	934	1309	org/xml/sax/SAXException
    //   934	962	1309	org/xml/sax/SAXException
    //   967	1023	1309	org/xml/sax/SAXException
    //   1023	1051	1309	org/xml/sax/SAXException
    //   1056	1115	1309	org/xml/sax/SAXException
    //   1115	1143	1309	org/xml/sax/SAXException
    //   1148	1204	1309	org/xml/sax/SAXException
    //   1204	1232	1309	org/xml/sax/SAXException
    //   1237	1293	1309	org/xml/sax/SAXException
    //   2	37	1317	java/io/IOException
    //   42	63	1317	java/io/IOException
    //   68	110	1317	java/io/IOException
    //   110	121	1317	java/io/IOException
    //   126	168	1317	java/io/IOException
    //   168	179	1317	java/io/IOException
    //   184	226	1317	java/io/IOException
    //   226	237	1317	java/io/IOException
    //   242	284	1317	java/io/IOException
    //   284	295	1317	java/io/IOException
    //   300	342	1317	java/io/IOException
    //   342	353	1317	java/io/IOException
    //   358	397	1317	java/io/IOException
    //   397	433	1317	java/io/IOException
    //   433	444	1317	java/io/IOException
    //   449	488	1317	java/io/IOException
    //   488	499	1317	java/io/IOException
    //   504	543	1317	java/io/IOException
    //   543	554	1317	java/io/IOException
    //   559	601	1317	java/io/IOException
    //   601	606	1317	java/io/IOException
    //   606	617	1317	java/io/IOException
    //   622	660	1317	java/io/IOException
    //   665	724	1317	java/io/IOException
    //   724	752	1317	java/io/IOException
    //   757	816	1317	java/io/IOException
    //   816	827	1317	java/io/IOException
    //   832	870	1317	java/io/IOException
    //   875	934	1317	java/io/IOException
    //   934	962	1317	java/io/IOException
    //   967	1023	1317	java/io/IOException
    //   1023	1051	1317	java/io/IOException
    //   1056	1115	1317	java/io/IOException
    //   1115	1143	1317	java/io/IOException
    //   1148	1204	1317	java/io/IOException
    //   1204	1232	1317	java/io/IOException
    //   1237	1293	1317	java/io/IOException
    //   2	37	1325	java/lang/Exception
    //   42	63	1325	java/lang/Exception
    //   68	110	1325	java/lang/Exception
    //   110	121	1325	java/lang/Exception
    //   126	168	1325	java/lang/Exception
    //   168	179	1325	java/lang/Exception
    //   184	226	1325	java/lang/Exception
    //   226	237	1325	java/lang/Exception
    //   242	284	1325	java/lang/Exception
    //   284	295	1325	java/lang/Exception
    //   300	342	1325	java/lang/Exception
    //   342	353	1325	java/lang/Exception
    //   358	397	1325	java/lang/Exception
    //   397	433	1325	java/lang/Exception
    //   433	444	1325	java/lang/Exception
    //   449	488	1325	java/lang/Exception
    //   488	499	1325	java/lang/Exception
    //   504	543	1325	java/lang/Exception
    //   543	554	1325	java/lang/Exception
    //   559	601	1325	java/lang/Exception
    //   601	606	1325	java/lang/Exception
    //   606	617	1325	java/lang/Exception
    //   622	660	1325	java/lang/Exception
    //   665	724	1325	java/lang/Exception
    //   724	752	1325	java/lang/Exception
    //   757	816	1325	java/lang/Exception
    //   816	827	1325	java/lang/Exception
    //   832	870	1325	java/lang/Exception
    //   875	934	1325	java/lang/Exception
    //   934	962	1325	java/lang/Exception
    //   967	1023	1325	java/lang/Exception
    //   1023	1051	1325	java/lang/Exception
    //   1056	1115	1325	java/lang/Exception
    //   1115	1143	1325	java/lang/Exception
    //   1148	1204	1325	java/lang/Exception
    //   1204	1232	1325	java/lang/Exception
    //   1237	1293	1325	java/lang/Exception
  }
  
  public static String a(int paramInt1, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt1).append('-').append(paramInt2);
    return localStringBuilder.toString();
  }
  
  public static String a(SharedPreferences paramSharedPreferences, String paramString, boolean paramBoolean)
  {
    int i = 0;
    paramSharedPreferences = paramSharedPreferences.getString("data_migration_tim_uins", "");
    if (TextUtils.isEmpty(paramSharedPreferences))
    {
      if (paramBoolean) {
        return paramString;
      }
      return paramSharedPreferences;
    }
    if (paramBoolean)
    {
      localObject = paramSharedPreferences.split(";");
      j = localObject.length;
      while (i < j)
      {
        if (localObject[i].equals(paramString)) {
          return paramSharedPreferences;
        }
        i += 1;
      }
      return paramSharedPreferences + ";" + paramString;
    }
    paramSharedPreferences = paramSharedPreferences.split(";");
    Object localObject = new StringBuilder();
    int j = paramSharedPreferences.length;
    i = 0;
    while (i < j)
    {
      String str = paramSharedPreferences[i];
      if (!str.equals(paramString)) {
        ((StringBuilder)localObject).append(str).append(";");
      }
      i += 1;
    }
    if ((((StringBuilder)localObject).length() > 0) && (((StringBuilder)localObject).charAt(((StringBuilder)localObject).length() - 1) == ';')) {
      ((StringBuilder)localObject).deleteCharAt(((StringBuilder)localObject).length() - 1);
    }
    return ((StringBuilder)localObject).toString();
  }
  
  public static String a(ConfigurationService.Config paramConfig, int paramInt1, int paramInt2)
  {
    if (paramConfig.version.get() == paramInt1)
    {
      QLog.e("SPLASH_ConfigServlet", 1, "extractConfigContent| config content will be null localVersion is same as config.version(" + paramInt1 + "). type=" + paramInt2);
      return null;
    }
    if (paramConfig.content_list.size() > 0) {
      return (String)paramConfig.content_list.get(0);
    }
    if (paramConfig.msg_content_list.size() == 0)
    {
      QLog.i("SPLASH_ConfigServlet", 1, String.format(Locale.getDefault(), "extractConfigContent| version is update but config content is null. newVersion=%d, oldVersion=%d, type=%d", new Object[] { Integer.valueOf(paramConfig.version.get()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
      return "";
    }
    Object localObject = ((ConfigurationService.Content)paramConfig.msg_content_list.get(0)).content.get().toByteArray();
    if (((ConfigurationService.Content)paramConfig.msg_content_list.get(0)).compress.get() == 1)
    {
      byte[] arrayOfByte = apfw.a((byte[])localObject);
      localObject = arrayOfByte;
      if (arrayOfByte == null)
      {
        QLog.e("SPLASH_ConfigServlet", 1, "extractConfigContent| decompress is failed. type=" + paramInt2 + ", data=null");
        return null;
      }
    }
    for (;;)
    {
      try
      {
        localObject = new String((byte[])localObject, "utf-8");
        paramConfig = String.format(Locale.getDefault(), "extractConfigContent| config is update. version=%d, type=%d", new Object[] { Integer.valueOf(paramConfig.version.get()), Integer.valueOf(paramInt2) });
        if (QLog.isColorLevel())
        {
          QLog.i("SPLASH_ConfigServlet", 2, paramConfig + "content=" + (String)localObject);
          return localObject;
        }
      }
      catch (UnsupportedEncodingException paramConfig)
      {
        QLog.e("SPLASH_ConfigServlet", 1, "extractConfigContent| data[] to String failed. type=" + paramInt2, paramConfig);
        return null;
      }
      QLog.i("SPLASH_ConfigServlet", 1, paramConfig);
    }
  }
  
  private String a(InputStream paramInputStream)
  {
    BufferedReader localBufferedReader = new BufferedReader(new InputStreamReader(paramInputStream));
    StringBuilder localStringBuilder = new StringBuilder();
    try
    {
      for (;;)
      {
        String str = localBufferedReader.readLine();
        if (str == null) {
          break;
        }
        localStringBuilder.append(str);
      }
      try
      {
        paramInputStream.close();
        throw localObject;
      }
      catch (IOException paramInputStream)
      {
        for (;;)
        {
          paramInputStream.printStackTrace();
        }
      }
    }
    catch (IOException localIOException)
    {
      localIOException = localIOException;
      localIOException.printStackTrace();
      try
      {
        paramInputStream.close();
        for (;;)
        {
          return localStringBuilder.toString();
          try
          {
            paramInputStream.close();
          }
          catch (IOException paramInputStream)
          {
            paramInputStream.printStackTrace();
          }
        }
      }
      catch (IOException paramInputStream)
      {
        for (;;)
        {
          paramInputStream.printStackTrace();
        }
      }
    }
    finally {}
  }
  
  public static List<String> a(ConfigurationService.Config paramConfig)
  {
    ArrayList localArrayList = null;
    if ((paramConfig.msg_content_list != null) && (paramConfig.msg_content_list.size() > 0))
    {
      localArrayList = new ArrayList();
      if (QLog.isColorLevel()) {
        QLog.i("SPLASH_ConfigServlet", 2, "parseCommonConfig: list.size() " + paramConfig.msg_content_list.size());
      }
      Iterator localIterator = paramConfig.msg_content_list.get().iterator();
      if (localIterator.hasNext())
      {
        paramConfig = (ConfigurationService.Content)localIterator.next();
        if ((paramConfig != null) && (paramConfig.content.has())) {
          if (paramConfig.compress.get() == 1)
          {
            paramConfig = b(paramConfig.content.get().toByteArray());
            if (paramConfig == null) {
              break label302;
            }
          }
        }
      }
    }
    for (;;)
    {
      try
      {
        paramConfig = new String(paramConfig, "UTF-8");
        if (QLog.isColorLevel()) {
          QLog.i("SPLASH_ConfigServlet", 2, "parseCommonConfig: contentitem.content =  " + paramConfig);
        }
        if (TextUtils.isEmpty(paramConfig)) {
          break;
        }
        localArrayList.add(paramConfig);
      }
      catch (Exception paramConfig)
      {
        QLog.e("SPLASH_ConfigServlet", 1, "parseCommonConfig|uncompress failed" + paramConfig);
        paramConfig = null;
        continue;
      }
      paramConfig = paramConfig.content.get().toStringUtf8();
      continue;
      QLog.i("SPLASH_ConfigServlet", 1, "empty contentitem");
      break;
      do
      {
        return localArrayList;
      } while (!QLog.isColorLevel());
      QLog.i("SPLASH_ConfigServlet", 2, "parseCommonConfig:msg_content_list is empty ,version: " + paramConfig.version.get());
      return null;
      label302:
      paramConfig = null;
    }
  }
  
  public static List<String> a(ConfigurationService.Config paramConfig, int paramInt1, int paramInt2)
  {
    if (paramConfig.version.get() == paramInt1)
    {
      QLog.e("SPLASH_ConfigServlet", 1, "extractConfigContentList| config content is null. type=" + paramInt2);
      return null;
    }
    if (paramConfig.content_list.size() > 0) {
      return paramConfig.content_list.get();
    }
    int i = paramConfig.msg_content_list.size();
    if (i == 0)
    {
      QLog.i("SPLASH_ConfigServlet", 1, String.format(Locale.getDefault(), "extractConfigContentList| version is update but config content is null. newVersion=%d, oldVersion=%d, type=%d", new Object[] { Integer.valueOf(paramConfig.version.get()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
      return Collections.emptyList();
    }
    ArrayList localArrayList = new ArrayList(i);
    paramInt1 = 0;
    if (paramInt1 < i)
    {
      Object localObject1 = ((ConfigurationService.Content)paramConfig.msg_content_list.get(0)).content.get().toByteArray();
      Object localObject2;
      if (((ConfigurationService.Content)paramConfig.msg_content_list.get(0)).compress.get() == 1)
      {
        localObject2 = apfw.a((byte[])localObject1);
        localObject1 = localObject2;
        if (localObject2 == null) {
          QLog.e("SPLASH_ConfigServlet", 1, paramInt1 + ": extractConfigContentList| decompress is failed. type=" + paramInt2 + ", data=null");
        }
      }
      for (;;)
      {
        paramInt1 += 1;
        break;
        try
        {
          localObject1 = new String((byte[])localObject1, "utf-8");
          localArrayList.add(localObject1);
          localObject2 = String.format(Locale.getDefault(), "%d: extractConfigContent| config is update. version=%d, type=%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramConfig.version.get()), Integer.valueOf(paramInt2) });
          if (!QLog.isColorLevel()) {
            break label380;
          }
          QLog.i("SPLASH_ConfigServlet", 2, (String)localObject2 + "content=" + (String)localObject1);
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException)
        {
          QLog.e("SPLASH_ConfigServlet", 1, paramInt1 + ": extractConfigContentList| data[] to String failed. type=" + paramInt2, localUnsupportedEncodingException);
        }
        continue;
        label380:
        QLog.i("SPLASH_ConfigServlet", 1, (String)localObject2);
      }
    }
    return localArrayList;
  }
  
  /* Error */
  private void a(int paramInt, String paramString1, String paramString2, QQAppInterface paramQQAppInterface)
  {
    // Byte code:
    //   0: getstatic 1205	cooperation/readinjoy/content/ReadInJoyDataProvider:e	Landroid/net/Uri;
    //   3: invokevirtual 1211	android/net/Uri:buildUpon	()Landroid/net/Uri$Builder;
    //   6: astore 5
    //   8: aload 5
    //   10: ldc_w 1213
    //   13: getstatic 15	arph:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   16: invokevirtual 1219	android/net/Uri$Builder:appendQueryParameter	(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;
    //   19: pop
    //   20: aload 5
    //   22: invokevirtual 1223	android/net/Uri$Builder:build	()Landroid/net/Uri;
    //   25: astore 5
    //   27: new 1225	android/content/ContentValues
    //   30: dup
    //   31: invokespecial 1226	android/content/ContentValues:<init>	()V
    //   34: astore 6
    //   36: aload 6
    //   38: ldc_w 1228
    //   41: iload_1
    //   42: invokestatic 318	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   45: invokevirtual 1232	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   48: aload 6
    //   50: ldc_w 1234
    //   53: aload_2
    //   54: invokevirtual 1237	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   57: aload 6
    //   59: ldc_w 1239
    //   62: aload_3
    //   63: invokevirtual 1237	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   66: ldc_w 1241
    //   69: iconst_2
    //   70: anewarray 314	java/lang/Object
    //   73: dup
    //   74: iconst_0
    //   75: ldc_w 1234
    //   78: aastore
    //   79: dup
    //   80: iconst_1
    //   81: aload_2
    //   82: aastore
    //   83: invokestatic 322	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   86: astore_2
    //   87: aload 4
    //   89: invokevirtual 65	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   92: invokevirtual 1245	com/tencent/qphone/base/util/BaseApplication:getContentResolver	()Landroid/content/ContentResolver;
    //   95: aload 5
    //   97: aconst_null
    //   98: aload_2
    //   99: aconst_null
    //   100: aconst_null
    //   101: invokevirtual 1251	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   104: astore_2
    //   105: aload_2
    //   106: ifnull +148 -> 254
    //   109: aload_2
    //   110: invokeinterface 1256 1 0
    //   115: ifle +61 -> 176
    //   118: aload 4
    //   120: invokevirtual 65	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   123: invokevirtual 1245	com/tencent/qphone/base/util/BaseApplication:getContentResolver	()Landroid/content/ContentResolver;
    //   126: aload 5
    //   128: aload 6
    //   130: aconst_null
    //   131: aconst_null
    //   132: invokevirtual 1260	android/content/ContentResolver:update	(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   135: pop
    //   136: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   139: ifeq +12 -> 151
    //   142: ldc 189
    //   144: iconst_2
    //   145: ldc_w 1262
    //   148: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   151: aload 4
    //   153: invokevirtual 65	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   156: invokevirtual 1245	com/tencent/qphone/base/util/BaseApplication:getContentResolver	()Landroid/content/ContentResolver;
    //   159: aload 5
    //   161: aconst_null
    //   162: invokevirtual 1266	android/content/ContentResolver:notifyChange	(Landroid/net/Uri;Landroid/database/ContentObserver;)V
    //   165: aload_2
    //   166: ifnull +9 -> 175
    //   169: aload_2
    //   170: invokeinterface 1267 1 0
    //   175: return
    //   176: aload 4
    //   178: invokevirtual 65	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   181: invokevirtual 1245	com/tencent/qphone/base/util/BaseApplication:getContentResolver	()Landroid/content/ContentResolver;
    //   184: aload 5
    //   186: aload 6
    //   188: invokevirtual 1271	android/content/ContentResolver:insert	(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    //   191: pop
    //   192: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   195: ifeq -44 -> 151
    //   198: ldc 189
    //   200: iconst_2
    //   201: ldc_w 1273
    //   204: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   207: goto -56 -> 151
    //   210: astore_3
    //   211: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   214: ifeq +29 -> 243
    //   217: ldc 189
    //   219: iconst_2
    //   220: new 85	java/lang/StringBuilder
    //   223: dup
    //   224: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   227: ldc_w 1275
    //   230: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   233: aload_3
    //   234: invokevirtual 825	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   237: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   240: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   243: aload_2
    //   244: ifnull -69 -> 175
    //   247: aload_2
    //   248: invokeinterface 1267 1 0
    //   253: return
    //   254: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   257: ifeq -106 -> 151
    //   260: ldc 189
    //   262: iconst_2
    //   263: ldc_w 1277
    //   266: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   269: goto -118 -> 151
    //   272: astore 4
    //   274: aload_2
    //   275: astore_3
    //   276: aload 4
    //   278: astore_2
    //   279: aload_3
    //   280: ifnull +9 -> 289
    //   283: aload_3
    //   284: invokeinterface 1267 1 0
    //   289: aload_2
    //   290: athrow
    //   291: astore_2
    //   292: aconst_null
    //   293: astore_3
    //   294: goto -15 -> 279
    //   297: astore 4
    //   299: aload_2
    //   300: astore_3
    //   301: aload 4
    //   303: astore_2
    //   304: goto -25 -> 279
    //   307: astore_3
    //   308: aconst_null
    //   309: astore_2
    //   310: goto -99 -> 211
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	313	0	this	arph
    //   0	313	1	paramInt	int
    //   0	313	2	paramString1	String
    //   0	313	3	paramString2	String
    //   0	313	4	paramQQAppInterface	QQAppInterface
    //   6	179	5	localObject	Object
    //   34	153	6	localContentValues	android.content.ContentValues
    // Exception table:
    //   from	to	target	type
    //   109	151	210	java/lang/Exception
    //   151	165	210	java/lang/Exception
    //   176	207	210	java/lang/Exception
    //   254	269	210	java/lang/Exception
    //   109	151	272	finally
    //   151	165	272	finally
    //   176	207	272	finally
    //   254	269	272	finally
    //   27	105	291	finally
    //   211	243	297	finally
    //   27	105	307	java/lang/Exception
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    a(paramQQAppInterface, 5);
    if (QLog.isDevelopLevel()) {
      QLog.d("QQOperateVoIP", 4, "onSend configXml request");
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    a(paramQQAppInterface, paramInt, null);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt, String paramString)
  {
    NewIntent localNewIntent = new NewIntent(paramQQAppInterface.getApp(), arph.class);
    localNewIntent.putExtra("k_cmd_type", new int[] { paramInt });
    if (!StringUtil.isEmpty(paramString)) {
      localNewIntent.putExtra("key_uin", paramString);
    }
    if ((!paramQQAppInterface.isLogin()) && (paramInt == 215)) {
      localNewIntent.setWithouLogin(true);
    }
    paramQQAppInterface.startServlet(localNewIntent);
  }
  
  private void a(QQAppInterface paramQQAppInterface, Intent paramIntent, int[] paramArrayOfInt, Packet paramPacket)
  {
    Object localObject1 = new ConfigurationService.ReqGetConfig();
    int n = paramArrayOfInt.length;
    ArrayList localArrayList1 = new ArrayList(n);
    ArrayList localArrayList2 = new ArrayList(n);
    int k = 0;
    ConfigurationService.ConfigSeq localConfigSeq;
    int i1;
    int j;
    int i;
    Object localObject7;
    boolean bool;
    if (k < n)
    {
      localConfigSeq = new ConfigurationService.ConfigSeq();
      i1 = paramArrayOfInt[k];
      localConfigSeq.type.set(i1);
      switch (i1)
      {
      default: 
        j = 0;
        i = j;
      case 1: 
      case 2: 
      case 3: 
      case 12: 
      case 5: 
      case 55: 
      case 10: 
      case 46: 
      case 13: 
      case 102: 
      case 101: 
      case 34: 
      case 115: 
      case 286: 
      case 23: 
      case 53: 
      case 78: 
      case 84: 
      case 167: 
      case 226: 
      case 139: 
      case 329: 
      case 351: 
      case 223: 
      case 364: 
      case 365: 
      case 31: 
      case 94: 
      case 38: 
      case 93: 
      case 44: 
      case 42: 
      case 47: 
      case 65: 
      case 49: 
      case 50: 
      case 56: 
      case 148: 
      case 61: 
      case 63: 
      case 64: 
      case 57: 
      case 66: 
      case 72: 
      case 73: 
      case 69: 
      case 74: 
      case 75: 
      case 385: 
      case 228: 
      case 256: 
      case 6: 
      case 43: 
      case 113: 
      case 80: 
      case 111: 
      case 79: 
      case 82: 
      case 90: 
      case 147: 
      case 86: 
      case 87: 
        for (;;)
        {
          try
          {
            if (aqxe.a().b(i1))
            {
              localObject2 = aqxe.a();
              localObject7 = ((aqxe)localObject2).a(i1);
              i = j;
              if (localObject7 != null)
              {
                i = ((aqwt)localObject7).onSend(((aqxe)localObject2).a(i1, jdField_a_of_type_JavaLangString));
                bool = ((aqxe)localObject2).a(paramQQAppInterface, i1);
                if (bool)
                {
                  ((aqxe)localObject2).a(i1, 0);
                  i = 0;
                }
                if (QLog.isColorLevel()) {
                  QLog.d("QConfigManager", 2, "[Send] t=" + i1 + " v=" + i + " up=" + bool);
                }
                localConfigSeq.version.set(i);
                if (!((aqxe)localObject2).a(i1)) {
                  break label9213;
                }
                localConfigSeq.compress.set(1);
                break label9213;
              }
            }
            if (i == 0) {
              paramQQAppInterface.getConfigProcess().a(localConfigSeq, paramQQAppInterface, i1);
            }
          }
          catch (Exception localException2)
          {
            Object localObject2;
            label1593:
            String str;
            long l;
            int m;
            label3460:
            int i2;
            QLog.d("QConfigManager", 1, "exception " + i1, localException2);
            continue;
          }
          localArrayList1.add(localConfigSeq);
          localArrayList2.add(Integer.valueOf(i1));
          k += 1;
          break;
          localConfigSeq.version.set(bhhr.c(paramQQAppInterface.getApp()));
          continue;
          localConfigSeq.version.set(bhhr.g(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
          continue;
          bhhr.a(paramQQAppInterface.getApplication(), paramQQAppInterface.getCurrentAccountUin());
          if (paramQQAppInterface.getCurrentAccountUin() != null)
          {
            jdField_b_of_type_JavaLangString = paramQQAppInterface.getCurrentNickname();
            localObject2 = bhaa.a(paramQQAppInterface, paramQQAppInterface.getCurrentAccountUin());
            if (localObject2 != null)
            {
              if (QLog.isColorLevel()) {
                QLog.i("SPLASH_ConfigServlet_birth", 2, "card!=null");
              }
              j = (int)((Card)localObject2).lBirthday;
              i = bcuj.a(j);
              j = bcuj.b(j);
              bhhr.b(paramQQAppInterface.getApp(), a(i, j));
              i = a(new SimpleDateFormat("MM-dd").format(new Date()), a(i, j));
              if (QLog.isColorLevel()) {
                QLog.i("SPLASH_ConfigServlet_birth", 2, "birthday date diff is " + i);
              }
              if (i < 0) {
                continue;
              }
              if (i <= 3) {}
            }
            else
            {
              if (!QLog.isColorLevel()) {
                continue;
              }
              QLog.i("SPLASH_ConfigServlet_birth", 2, "card===null");
              continue;
            }
            localConfigSeq.version.set(bhhr.h(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
            continue;
            localObject2 = (arpr)paramQQAppInterface.getManager(QQManagerFactory.NEARBY_BANNER_MANAGER);
            localConfigSeq.version.set(((arpr)localObject2).a());
            localObject7 = paramIntent.getStringExtra("key_province");
            localObject2 = localObject7;
            if (localObject7 == null) {
              localObject2 = "";
            }
            str = paramIntent.getStringExtra("key_city");
            localObject7 = str;
            if (str == null) {
              localObject7 = "";
            }
            ((ConfigurationService.ReqGetConfig)localObject1).province.set((String)localObject2);
            ((ConfigurationService.ReqGetConfig)localObject1).city.set((String)localObject7);
            continue;
            localConfigSeq.version.set(bhhr.i(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin()));
            continue;
            localConfigSeq.version.set(bhhr.j(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin()));
            continue;
            localConfigSeq.version.set(bhhr.b(paramQQAppInterface.getApp()));
            continue;
            localConfigSeq.version.set(PatchSharedPreUtil.getPatchConfigVersion(paramQQAppInterface.getApp()));
            localConfigSeq.compress.set(1);
            continue;
            BridgeHelper.a(BaseApplication.getContext(), jdField_a_of_type_JavaLangString).a();
            localConfigSeq.version.set(bhhr.a(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount()));
            continue;
            i = arqj.a(BaseApplicationImpl.getContext());
            if (SettingCloneUtil.readValueForInt(BaseApplicationImpl.getContext(), jdField_a_of_type_JavaLangString, null, "qqsetting_calltab_show_key_version", 0) < i)
            {
              localConfigSeq.version.set(0);
            }
            else
            {
              localConfigSeq.version.set(bhhr.l(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount()));
              continue;
              i = arqj.a(BaseApplicationImpl.getContext());
              if (SettingCloneUtil.readValueForInt(BaseApplicationImpl.getContext(), jdField_a_of_type_JavaLangString, null, "qqsetting_calltab_show_key_version", 0) < i)
              {
                localConfigSeq.version.set(0);
                paramIntent.putExtra("update101Version", i);
              }
              else
              {
                localConfigSeq.version.set(bhhr.k(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount()));
                continue;
                localObject2 = (ajco)paramQQAppInterface.getManager(QQManagerFactory.PHONE_UNITY_MANAGER);
                localConfigSeq.version.set(((ajco)localObject2).a());
                continue;
                localConfigSeq.version.set(bhhr.o(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
                continue;
                localConfigSeq.version.set(bhhr.p(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
                continue;
                localConfigSeq.version.set(bhhr.e(paramQQAppInterface.getApp()));
                continue;
                localConfigSeq.version.set(bhhr.q(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
                continue;
                localConfigSeq.version.set(bhhr.r(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
                continue;
                if (!PtvTemplateManager.a())
                {
                  localConfigSeq.version.set(0);
                }
                else
                {
                  localConfigSeq.version.set(bhhr.g(paramQQAppInterface.getApp()));
                  continue;
                  if (!PtvTemplateManager.b())
                  {
                    localConfigSeq.version.set(0);
                    localConfigSeq.compress.set(1);
                  }
                  else
                  {
                    localConfigSeq.version.set(bhhr.i(paramQQAppInterface.getApp()));
                    continue;
                    if (!bbgg.a())
                    {
                      localConfigSeq.version.set(0);
                      localConfigSeq.compress.set(1);
                    }
                    else
                    {
                      localConfigSeq.version.set(bhhr.h(paramQQAppInterface.getApp()));
                      continue;
                      i = 0;
                      if (PtvTemplateManager.c()) {
                        i = bhhr.j(paramQQAppInterface.getApp());
                      }
                      localConfigSeq.version.set(i);
                      localConfigSeq.compress.set(1);
                      if (QLog.isDevelopLevel())
                      {
                        QLog.d("Doodle_Strokes_SPLASH_ConfigServlet", 4, String.format("个性笔触配置版本号[%s]", new Object[] { Integer.valueOf(i) }));
                        continue;
                        i = bhhr.E(paramQQAppInterface.getApp());
                        localConfigSeq.version.set(i);
                        localConfigSeq.compress.set(1);
                        if (QLog.isDevelopLevel())
                        {
                          QLog.d("QQSTORY_FOLLOW_CAPTURE_SPLASH_ConfigServlet", 4, String.format("日迹合拍版本号[%s]", new Object[] { Integer.valueOf(i) }));
                          continue;
                          i = bhhr.aQ(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
                          localConfigSeq.version.set(i);
                          localConfigSeq.compress.set(1);
                          if (QLog.isDevelopLevel())
                          {
                            QLog.d("QQSTORY_QUESTION_TAB_SPLASH_ConfigServlet", 4, String.format("日迹问答版本号[%s]", new Object[] { Integer.valueOf(i) }));
                            continue;
                            BusinessCommonConfig.getInstance(paramQQAppInterface).fillConfigVersion(i1, localConfigSeq);
                            continue;
                            localConfigSeq.version.set(bhhr.b(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount()));
                            continue;
                            localConfigSeq.version.set(bhhr.c(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount()));
                            continue;
                            localConfigSeq.version.set(bhhr.m(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
                            continue;
                            localConfigSeq.version.set(bhhr.n(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
                            continue;
                            localConfigSeq.version.set(bhhr.d(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
                            continue;
                            localConfigSeq.version.set(bhhr.G(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
                            l = paramIntent.getLongExtra("k_adcode", 0L);
                            localObject7 = paramIntent.getStringExtra("key_province");
                            localObject2 = localObject7;
                            if (localObject7 == null) {
                              localObject2 = "";
                            }
                            str = paramIntent.getStringExtra("key_city");
                            localObject7 = str;
                            if (str == null) {
                              localObject7 = "";
                            }
                            ((ConfigurationService.ReqGetConfig)localObject1).province.set((String)localObject2);
                            ((ConfigurationService.ReqGetConfig)localObject1).city.set((String)localObject7);
                            ((ConfigurationService.ReqGetConfig)localObject1).adcode.set(l);
                            continue;
                            bool = abmp.a();
                            if (QLog.isColorLevel()) {
                              QLog.d("SPLASH_ConfigServlet", 2, "addAllConfigs, support ble=" + bool);
                            }
                            if (bool)
                            {
                              localConfigSeq.version.set(bhhr.e(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
                              continue;
                              bool = abmp.a();
                              if (QLog.isColorLevel()) {
                                QLog.d("SPLASH_ConfigServlet", 2, "addAllConfigs, support ble=" + bool);
                              }
                              if (bool)
                              {
                                localConfigSeq.version.set(bhhr.f(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
                                continue;
                                localConfigSeq.version.set(bhhr.r(paramQQAppInterface.getApp()));
                                continue;
                                i = bhhr.x(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
                                j = AppSetting.a();
                                if (i != j)
                                {
                                  bhhr.i(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, 0);
                                  bhhr.k(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, j);
                                  SearchConfigManager.a(paramQQAppInterface, jdField_a_of_type_JavaLangString);
                                }
                                localConfigSeq.version.set(bhhr.w(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
                                continue;
                                localConfigSeq.version.set(bhhr.H(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
                                continue;
                                localConfigSeq.version.set(bhhr.f(paramQQAppInterface.getApp()));
                                localConfigSeq.compress.set(1);
                                continue;
                                localConfigSeq.version.set(bhhr.s(paramQQAppInterface.getApp()));
                                continue;
                                localConfigSeq.version.set(bhhr.t(paramQQAppInterface.getApp()));
                                continue;
                                localConfigSeq.version.set(bhhr.u(paramQQAppInterface.getApp()));
                                continue;
                                localConfigSeq.version.set(bhhr.v(paramQQAppInterface.getApp()));
                                continue;
                                localConfigSeq.version.set(bhhr.A(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
                                continue;
                                localConfigSeq.version.set(bhhr.L(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentUin()));
                                continue;
                                localConfigSeq.version.set(bhhr.w(paramQQAppInterface.getApp()));
                                continue;
                                i = bhhr.B(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
                                localConfigSeq.version.set(i);
                                continue;
                                localConfigSeq.version.set(((anyb)paramQQAppInterface.getManager(QQManagerFactory.MAYKNOW_RECOMMEND_MANAGER)).b());
                                continue;
                                i = bhhr.C(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
                                if (bhhr.y(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount()) != AppSetting.a()) {
                                  i = 0;
                                }
                                localConfigSeq.version.set(i);
                                continue;
                                localObject2 = (bkyu)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.NOTIFICATION_CONTROLLER_HANDLER);
                                i = ((bkyu)localObject2).b(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
                                j = ((bkyu)localObject2).a(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
                                m = AppSetting.a();
                                if (j != m)
                                {
                                  i = 0;
                                  QLog.i("NCtr", 1, String.format("request NOTIFICATION_LIMIT_CONFIG localVersion: %d ,originalAppId:%d, currentAppId:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(m) }));
                                  localConfigSeq.version.set(i);
                                  continue;
                                  i = bhhr.av(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
                                  if (bhhr.aw(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount()) != AppSetting.a()) {
                                    i = 0;
                                  }
                                  localConfigSeq.version.set(i);
                                  continue;
                                  i = bhhr.ax(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
                                  if (bhhr.ay(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount()) != AppSetting.a()) {
                                    i = 0;
                                  }
                                  localConfigSeq.version.set(i);
                                  continue;
                                  localObject1 = DeviceProfileManager.a(paramQQAppInterface);
                                  continue;
                                  localConfigSeq.version.set(bhhr.F(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
                                  continue;
                                  localConfigSeq.version.set(azoj.a(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
                                  localConfigSeq.compress.set(1);
                                  localObject7 = paramIntent.getStringExtra("key_province");
                                  localObject2 = localObject7;
                                  if (localObject7 == null) {
                                    localObject2 = "";
                                  }
                                  str = paramIntent.getStringExtra("key_city");
                                  localObject7 = str;
                                  if (str == null) {
                                    localObject7 = "";
                                  }
                                  ((ConfigurationService.ReqGetConfig)localObject1).province.set((String)localObject2);
                                  ((ConfigurationService.ReqGetConfig)localObject1).city.set((String)localObject7);
                                  continue;
                                  localConfigSeq.version.set(bhhr.n(paramQQAppInterface.getApp()));
                                  continue;
                                  localConfigSeq.version.set(bhhr.o(paramQQAppInterface.getApp()));
                                  continue;
                                  localConfigSeq.version.set(bhhr.M(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin()));
                                  continue;
                                  localConfigSeq.version.set(bhhr.P(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
                                  continue;
                                  localConfigSeq.version.set(bhhr.K(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin()));
                                  continue;
                                  localConfigSeq.version.set(bhhr.a(paramQQAppInterface.getApp(), "shop_tab", jdField_a_of_type_JavaLangString));
                                  continue;
                                  localObject2 = (OlympicManager)paramQQAppInterface.getManager(QQManagerFactory.OLYMPIC_MANAGER);
                                  if (localObject2 == null) {
                                    continue;
                                  }
                                  ((OlympicManager)localObject2).c();
                                  localObject2 = ((OlympicManager)localObject2).a();
                                  i = 0;
                                  if (localObject2 != null) {
                                    i = ((OlympicActConfig)localObject2).version;
                                  }
                                  localConfigSeq.version.set(i);
                                  localConfigSeq.compress.set(1);
                                  paramIntent.putExtra("config_version", i);
                                  if (QLog.isColorLevel()) {
                                    QLog.d("Olympic.OLYMPIC_ACT_RESOURCE_CONFIG_INFO", 2, new Object[] { "oldVersion=", Integer.valueOf(i) });
                                  }
                                  if (!ayym.a(BaseApplicationImpl.getContext(), "olympic_config_act_get")) {
                                    continue;
                                  }
                                  if (QLog.isColorLevel()) {
                                    QLog.d("Olympic.configServlet", 2, new Object[] { "check24Hour, result=true, do Report, key=", "olympic_config_act_get" });
                                  }
                                  StatisticCollector.getInstance(BaseApplicationImpl.getContext()).collectPerformance("", "olympic_config_act_get", true, 0L, 0L, null, "", false);
                                  ayym.a(BaseApplicationImpl.getContext(), "olympic_config_act_get");
                                  continue;
                                  localObject2 = (apgi)paramQQAppInterface.getManager(QQManagerFactory.AR_RESOURCE_MANAGER);
                                  if (localObject2 == null) {
                                    continue;
                                  }
                                  i2 = ((apgi)localObject2).b();
                                  m = 0;
                                  i = 0;
                                  localObject7 = BaseApplicationImpl.getApplication();
                                  j = m;
                                }
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      for (;;)
      {
        for (;;)
        {
          try
          {
            int i3 = ((Context)localObject7).getPackageManager().getPackageInfo(((Context)localObject7).getPackageName(), 0).versionCode;
            j = m;
            m = ((apgi)localObject2).a();
            if ((m == 0) || (i3 != m)) {
              break label9219;
            }
            j = i;
            QLog.d("ArConfig_configServlet", 1, "handleResp_GetArResourceConfig|type= 1 version code is  " + i3 + "local version type is " + m);
          }
          catch (PackageManager.NameNotFoundException localNameNotFoundException)
          {
            localNameNotFoundException.printStackTrace();
            QLog.d("ArConfig_configServlet", 1, "handleResp_GetArResourceConfig|type= 1 error happen");
            i = j;
            continue;
            localConfigSeq.version.set(i2);
            continue;
          }
          if (i == 1)
          {
            localConfigSeq.version.set(0);
            localConfigSeq.compress.set(1);
            localObject7 = paramIntent.getStringExtra("key_province");
            localObject2 = localObject7;
            if (localObject7 == null) {
              localObject2 = "";
            }
            str = paramIntent.getStringExtra("key_city");
            localObject7 = str;
            if (str == null) {
              localObject7 = "";
            }
            ((ConfigurationService.ReqGetConfig)localObject1).province.set((String)localObject2);
            ((ConfigurationService.ReqGetConfig)localObject1).city.set((String)localObject7);
            paramIntent.putExtra("key_config_version", i2);
            break;
          }
          Object localObject3 = (apbf)paramQQAppInterface.getManager(QQManagerFactory.AR_CLOBAL_CONFIG_MANAGER);
          if (localObject3 == null) {
            break;
          }
          i = ((apbf)localObject3).b();
          if (QLog.isColorLevel()) {
            QLog.d("handleResp_GetArGlobalConfig", 2, " local version = " + i);
          }
          if (((apbf)localObject3).a()) {
            localConfigSeq.version.set(i);
          }
          for (;;)
          {
            localConfigSeq.compress.set(1);
            paramIntent.putExtra("ar_global_key_config_version", i);
            break;
            i = 0;
            localConfigSeq.version.set(0);
          }
          localObject3 = (apbf)paramQQAppInterface.getManager(QQManagerFactory.AR_CLOBAL_CONFIG_MANAGER);
          if (localObject3 == null) {
            break;
          }
          i = ((apbf)localObject3).c();
          localConfigSeq.version.set(i);
          localConfigSeq.compress.set(1);
          paramIntent.putExtra("ar_scan_star_face_config_version", i);
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("SPLASH_ConfigServlet", 2, " get AR_SCAN_STAR_FACE_CONFIG, version = " + i);
          break;
          i = apgm.a(paramQQAppInterface);
          localConfigSeq.version.set(i);
          localConfigSeq.compress.set(1);
          paramIntent.putExtra("key_download_cfg_version", i);
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("SPLASH_ConfigServlet", 2, " get AR_SCAN_FACE_PRE_DOWN_CONFIG, version = " + i);
          break;
          localObject3 = (apgi)paramQQAppInterface.getManager(QQManagerFactory.AR_RESOURCE_MANAGER);
          if (localObject3 == null) {
            break;
          }
          i = ((apgi)localObject3).c();
          localConfigSeq.version.set(i);
          localConfigSeq.compress.set(1);
          paramIntent.putExtra("key_ar_entrance_effect_version", i);
          break;
          i = bhhr.a(paramQQAppInterface.getApp(), "readinjoy_interested_push_config", jdField_a_of_type_JavaLangString);
          localConfigSeq.version.set(i);
          break;
          localObject3 = (PhoneContactManagerImp)paramQQAppInterface.getManager(QQManagerFactory.CONTACT_MANAGER);
          localConfigSeq.version.set(((PhoneContactManagerImp)localObject3).e());
          break;
          lbx.a(i1, jdField_a_of_type_JavaLangString, localConfigSeq);
          break;
          i = aqmy.a(BaseApplicationImpl.getContext());
          localConfigSeq.version.set(i);
          localConfigSeq.compress.set(1);
          paramIntent.putExtra("qcamera_conf_version", i);
          paramIntent.putExtra("uin", paramQQAppInterface.getCurrentAccountUin());
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.i("Q.camera.configServlet", 2, "request QCAMERA_PHONE_CONFIG version: " + i);
          break;
          i = bhhr.I(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
          if (QLog.isColorLevel()) {
            QLog.d("SPLASH_ConfigServlet", 2, "addAllConfigs|GET_CONFIG_UPGRADE version=" + i);
          }
          localConfigSeq.version.set(i);
          paramQQAppInterface.getPreloadSwitch();
          bjlt.a(paramQQAppInterface.getApp(), String.valueOf(AppSetting.a()));
          ((ansg)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.CONFIG_HANDLER)).c();
          break;
          i = bhhr.J(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
          localConfigSeq.version.set(i);
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("UpgradeTIMWrapper", 2, "ConfigServlet req :193, version: " + i);
          break;
          i = bhhr.a(paramQQAppInterface.getApp(), "now_entrance_action_version", jdField_a_of_type_JavaLangString);
          localConfigSeq.version.set(i);
          break;
          i = bhhr.a(paramQQAppInterface.getApp(), "troop_common_config_version", jdField_a_of_type_JavaLangString);
          localConfigSeq.version.set(i);
          break;
          i = bhhr.a(paramQQAppInterface.getApp(), "nearby_config_version", jdField_a_of_type_JavaLangString);
          localConfigSeq.version.set(i);
          break;
          i = bhhr.a(paramQQAppInterface.getApp(), "nearby_nowlive_tab_config_version", jdField_a_of_type_JavaLangString);
          localConfigSeq.version.set(i);
          break;
          localConfigSeq.version.set(bhhr.Q(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount()));
          localConfigSeq.compress.set(1);
          break;
          localObject3 = (anqn)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.BABY_Q_HANDLER);
          if (localObject3 == null) {
            break;
          }
          i = AppSetting.a();
          if (i != ((anqn)localObject3).b(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString))
          {
            ((anqn)localObject3).a(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, 0);
            ((anqn)localObject3).b(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, i);
            ((anqn)localObject3).a(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, true);
            ((anqn)localObject3).c();
          }
          localConfigSeq.version.set(((anqn)localObject3).a(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
          break;
          localConfigSeq.version.set(bhhr.S(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
          localConfigSeq.version.set(bhhr.T(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
          localConfigSeq.compress.set(1);
          break;
          localConfigSeq.version.set(bhhr.D(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
          break;
          localConfigSeq.version.set(bcmz.a());
          break;
          i = bbzh.a(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin());
          localConfigSeq.version.set(i);
          break;
          i = bhhr.a(paramQQAppInterface.getApp(), "nearby_glamour_level_config_version", jdField_a_of_type_JavaLangString);
          localConfigSeq.version.set(i);
          localConfigSeq.compress.set(1);
          break;
          localConfigSeq.version.set(bhhr.V(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
          break;
          if (bhhr.a(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, 1) != AppSetting.a())
          {
            bhhr.d(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, 1, AppSetting.a());
            bhhr.d(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, 2, 0);
            localConfigSeq.version.set(0);
            break;
          }
          localConfigSeq.version.set(bhhr.a(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, 2));
          break;
          try
          {
            if (((Integer)bhhr.a(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, 1)).intValue() == AppSetting.a()) {
              break label5515;
            }
            bhhr.a(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, 1, Integer.valueOf(AppSetting.a()));
            bhhr.a(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, 2, Integer.valueOf(0));
            localConfigSeq.version.set(0);
          }
          catch (Throwable localThrowable)
          {
            localThrowable.printStackTrace();
          }
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("SPLASH_ConfigServlet", 2, "PUSH_RECOMMEND_SHIELD_CONFIG", localThrowable);
        break;
        label5515:
        i = ((Integer)bhhr.a(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, 2)).intValue();
        localConfigSeq.version.set(i);
        break;
        localConfigSeq.version.set(bhhr.Y(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
        break;
        if (!PtvTemplateManager.d()) {
          localConfigSeq.version.set(0);
        }
        for (;;)
        {
          localConfigSeq.compress.set(1);
          break;
          localConfigSeq.version.set(bhhr.l(paramQQAppInterface.getApp()));
        }
        localConfigSeq.version.set(bhhr.W(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
        break;
        localConfigSeq.version.set(bhhr.ac(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
        localConfigSeq.compress.set(1);
        break;
        localConfigSeq.version.set(bhhr.ae(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
        localConfigSeq.compress.set(1);
        break;
        Object localObject4 = (zcj)paramQQAppInterface.getManager(QQManagerFactory.TROOP_STORY_MANAGER);
        localConfigSeq.version.set(((zcj)localObject4).a.a(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
        break;
        localConfigSeq.version.set(bhhr.aa(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
        localConfigSeq.compress.set(1);
        break;
        localConfigSeq.version.set(usu.c(paramQQAppInterface));
        break;
        localConfigSeq.version.set(bhhr.ab(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
        break;
        i = bhhr.am(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
        j = AppSetting.a();
        if (i != j)
        {
          bhhr.J(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, 0);
          bhhr.K(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, j);
        }
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("SPLASH_ConfigServlet", 2, "[Doutu]onsend : appIdRecord = " + i + ", appId = " + j + ", DOUTU_CONFI version = " + bhhr.aj(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
          }
          localConfigSeq.version.set(bhhr.aj(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
          localConfigSeq.compress.set(1);
          break;
          localObject4 = (asaa)getAppRuntime().getManager(QQManagerFactory.DOUTU_MAGAGER);
          if (localObject4 != null) {
            ((asaa)localObject4).b(false);
          }
        }
        i = bhhr.s(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
        j = AppSetting.a();
        if (i != j)
        {
          bhhr.f(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, 0);
          bhhr.e(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, j);
        }
        if (QLog.isColorLevel()) {
          QLog.d("SPLASH_ConfigServlet", 2, "[GreenVideo]onsend : appIdRecord = " + i + ", appId = " + j + ", GREEN_VIDEO_CONFI version = " + bhhr.t(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
        }
        localConfigSeq.version.set(bhhr.t(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
        localConfigSeq.compress.set(1);
        break;
        i = bhhr.u(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
        j = AppSetting.a();
        if (i != j)
        {
          bhhr.h(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, 0);
          bhhr.g(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, j);
        }
        if (QLog.isColorLevel()) {
          QLog.d("SPLASH_ConfigServlet", 2, "[VideoCompress]onsend : appIdRecord = " + i + ", appId = " + j + ", VIDEO_REDBAG_CONFI version = " + bhhr.ao(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
        }
        localConfigSeq.version.set(bhhr.v(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
        localConfigSeq.compress.set(1);
        break;
        if (((Integer)axqc.a(jdField_a_of_type_JavaLangString, "key_app_id", Integer.valueOf(0))).intValue() != AppSetting.a())
        {
          axqc.a(jdField_a_of_type_JavaLangString, "key_tabs_config_version", Integer.valueOf(0));
          axqc.a(jdField_a_of_type_JavaLangString, "key_app_id", Integer.valueOf(AppSetting.a()));
        }
        i = ((Integer)axqc.a(jdField_a_of_type_JavaLangString, "key_tabs_config_version", Integer.valueOf(0))).intValue();
        localConfigSeq.version.set(i);
        localConfigSeq.compress.set(1);
        localObject7 = paramIntent.getStringExtra("key_province");
        localObject4 = localObject7;
        if (localObject7 == null) {
          localObject4 = "";
        }
        str = paramIntent.getStringExtra("key_city");
        localObject7 = str;
        if (str == null) {
          localObject7 = "";
        }
        ((ConfigurationService.ReqGetConfig)localObject1).province.set((String)localObject4);
        ((ConfigurationService.ReqGetConfig)localObject1).city.set((String)localObject7);
        break;
        i = aahy.a(jdField_a_of_type_JavaLangString);
        localConfigSeq.version.set(i);
        localConfigSeq.compress.set(1);
        break;
        localConfigSeq.version.set(bdtt.a(paramQQAppInterface));
        localConfigSeq.compress.set(1);
        break;
        localConfigSeq.version.set(bhhr.ah(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
        localConfigSeq.compress.set(1);
        break;
        localConfigSeq.version.set(bhhr.ad(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
        localConfigSeq.compress.set(1);
        break;
        localConfigSeq.version.set(ahud.a(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
        localConfigSeq.compress.set(1);
        break;
        i = bhhr.a(paramQQAppInterface.getApp(), "change_machine_version", jdField_a_of_type_JavaLangString);
        localConfigSeq.version.set(i);
        break;
        i = bhhr.a(paramQQAppInterface.getApp(), "nearby_auth_video_config_version", jdField_a_of_type_JavaLangString);
        localConfigSeq.version.set(i);
        break;
        localConfigSeq.version.set(bhhr.ar(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
        break;
        localConfigSeq.version.set(bhhr.y(paramQQAppInterface.getApp()));
        break;
        localConfigSeq.version.set(bhhr.as(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
        break;
        localConfigSeq.version.set(also.a(paramQQAppInterface.getApp()));
        localConfigSeq.compress.set(1);
        break;
        localConfigSeq.version.set(bbgq.a(paramQQAppInterface.getApp()));
        localConfigSeq.compress.set(1);
        break;
        a((ConfigurationService.ReqGetConfig)localObject1, localConfigSeq, paramQQAppInterface);
        break;
        i = bhhr.a(paramQQAppInterface.getApp(), "search_function_config_version", jdField_a_of_type_JavaLangString);
        localConfigSeq.version.set(i);
        localConfigSeq.compress.set(1);
        break;
        i = ((ayrg)paramQQAppInterface.getManager(QQManagerFactory.OCR_MANAGER)).a();
        localConfigSeq.version.set(i);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("SPLASH_ConfigServlet", 2, "ConfigServlet OCR_CONFIG ocrVersion:" + i);
        break;
        i = bhhr.au(BaseApplicationImpl.getContext(), jdField_a_of_type_JavaLangString);
        localConfigSeq.version.set(i);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("SPLASH_ConfigServlet", 2, "ConfigServlet receipt ,receiptVersion:" + i);
        break;
        i = bhhr.aX(BaseApplicationImpl.getContext(), jdField_a_of_type_JavaLangString);
        localConfigSeq.version.set(i);
        break;
        i = bhhr.aY(BaseApplicationImpl.getContext(), jdField_a_of_type_JavaLangString);
        localConfigSeq.version.set(i);
        break;
        i = ShortVideoResourceManager.a();
        localConfigSeq.version.set(i);
        localConfigSeq.compress.set(1);
        if (QLog.isColorLevel()) {
          QLog.i("ShortVideoResourceManager", 2, "SHORT_VIDEO_RESOURCE_CONFIG  ,versionRes:" + i);
        }
        ShortVideoResourceManager.a();
        break;
        i = paramQQAppInterface.getPreferences().getInt("public_account_ad_preload_task", 0);
        localConfigSeq.version.set(i);
        localConfigSeq.compress.set(1);
        break;
        i = paramQQAppInterface.getPreferences().getInt("tim_login_jump", 0);
        localConfigSeq.version.set(i);
        localConfigSeq.compress.set(1);
        break;
        i = paramQQAppInterface.getPreferences().getInt("tim_upgrade_hongdian_version", 0);
        localConfigSeq.version.set(i);
        localConfigSeq.compress.set(1);
        break;
        localConfigSeq.version.set(paramQQAppInterface.getPreferences().getInt("call_tim_config_version", 0));
        break;
        i = paramQQAppInterface.getPreferences().getInt("tim_pc_banner", 0);
        localConfigSeq.version.set(i);
        localConfigSeq.compress.set(1);
        break;
        i = paramQQAppInterface.getPreferences().getInt("troop_link_config_version", 0);
        localConfigSeq.version.set(i);
        localConfigSeq.compress.set(1);
        break;
        i = paramQQAppInterface.getPreferences().getInt("key_game_troop_bind_config_version", 0);
        localConfigSeq.version.set(i);
        localConfigSeq.compress.set(1);
        break;
        paramQQAppInterface.getConfigProcess().a(localConfigSeq, paramQQAppInterface, i1);
        localObject4 = (aslo)paramQQAppInterface.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER);
        try
        {
          ((aslo)localObject4).a();
        }
        catch (Exception localException1)
        {
          QLog.e("SPLASH_ConfigServlet", 1, "get local extend friend exception:", localException1);
        }
      }
      break label1593;
      i = paramQQAppInterface.getPreferences().getInt("tim_aio_tips_bar_version", 0);
      localConfigSeq.version.set(i);
      localConfigSeq.compress.set(1);
      break label1593;
      i = bdcu.a(paramQQAppInterface.getApp());
      localConfigSeq.version.set(i);
      localConfigSeq.compress.set(1);
      break label1593;
      i = paramQQAppInterface.getPreferences().getInt("data_migration_tim_version", 0);
      localConfigSeq.version.set(i);
      localConfigSeq.compress.set(1);
      break label1593;
      i = bhhr.a(paramQQAppInterface.getApp(), "nearby_videochat_dialog_config_version", jdField_a_of_type_JavaLangString);
      localConfigSeq.version.set(i);
      break label1593;
      i = bhhr.a(paramQQAppInterface.getApp(), "nearby_videochat_banner_config_version", jdField_a_of_type_JavaLangString);
      localConfigSeq.version.set(i);
      break label1593;
      i = paramQQAppInterface.getPreferences().getInt("zhitu_config_version", 0);
      localConfigSeq.version.set(i);
      localConfigSeq.compress.set(1);
      break label1593;
      i = paramQQAppInterface.getPreferences().getInt("homework_troop_config_version", 0);
      localConfigSeq.version.set(i);
      localConfigSeq.compress.set(1);
      break label1593;
      Object localObject5 = (TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
      localConfigSeq.version.set(((TroopManager)localObject5).jdField_a_of_type_Bfpu.a(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
      localConfigSeq.compress.set(1);
      break label1593;
      i = paramQQAppInterface.getPreferences().getInt("new_troop_recommend", 0);
      localConfigSeq.version.set(i);
      localConfigSeq.compress.set(1);
      break label1593;
      localObject5 = (TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
      localConfigSeq.version.set(((TroopManager)localObject5).jdField_a_of_type_Bfsb.a(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
      localConfigSeq.compress.set(1);
      break label1593;
      i = RecentDanceConfigMgr.a();
      localConfigSeq.version.set(i);
      localConfigSeq.compress.set(1);
      break label1593;
      i = avjd.a().a.a();
      localConfigSeq.version.set(i);
      localConfigSeq.compress.set(1);
      break label1593;
      i = LightVideoConfigMgr.a();
      localConfigSeq.version.set(i);
      localConfigSeq.compress.set(1);
      break label1593;
      localConfigSeq.version.set(bhhr.a(paramQQAppInterface.getApp(), "sport_config", jdField_a_of_type_JavaLangString));
      localConfigSeq.compress.set(1);
      break label1593;
      i = bhhr.a(paramQQAppInterface.getApplication(), "troop_gift_anim_limit", "0");
      localConfigSeq.version.set(i);
      break label1593;
      localConfigSeq.version.set(0);
      localConfigSeq.compress.set(1);
      break label1593;
      i = paramQQAppInterface.getPreferences().getInt("task_entry_config_version", 0);
      localConfigSeq.version.set(i);
      localConfigSeq.compress.set(1);
      break label1593;
      i = paramQQAppInterface.getPreferences().getInt("qzone_xp_config_version", 0);
      localConfigSeq.version.set(i);
      break label1593;
      i = paramQQAppInterface.getPreferences().getInt("buluo_enter_config_version" + paramQQAppInterface.getCurrentUin(), 0);
      localConfigSeq.version.set(i);
      localConfigSeq.compress.set(1);
      break label1593;
      localConfigSeq.version.set(bhhr.aE(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
      break label1593;
      i = bhhr.aG(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
      if (bhhr.aH(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount()) != AppSetting.a()) {
        i = 0;
      }
      localConfigSeq.version.set(i);
      break label1593;
      i = bpnj.a().a(paramQQAppInterface.getApp());
      localConfigSeq.version.set(i);
      localConfigSeq.compress.set(1);
      break label1593;
      i = bpqr.a().a(paramQQAppInterface.getApp());
      localConfigSeq.version.set(i);
      localConfigSeq.compress.set(1);
      break label1593;
      localObject5 = (vzv)paramQQAppInterface.getManager(QQManagerFactory.QQSTORY_MANAGER);
      localConfigSeq.version.set(((vzv)localObject5).a.a(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
      localConfigSeq.compress.set(1);
      break label1593;
      localConfigSeq.version.set(bhhr.a());
      localConfigSeq.compress.set(1);
      break label1593;
      i = bhhr.aI(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
      if (bhhr.aJ(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount()) != AppSetting.a()) {
        i = 0;
      }
      localConfigSeq.version.set(i);
      break label1593;
      localConfigSeq.version.set(bhhr.R(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount()));
      localConfigSeq.compress.set(1);
      break label1593;
      i = bhhr.a(paramQQAppInterface.getApp(), "wifi_connect_config_version", jdField_a_of_type_JavaLangString);
      localConfigSeq.version.set(i);
      break label1593;
      localObject5 = (TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
      localConfigSeq.version.set(((TroopManager)localObject5).jdField_a_of_type_Aahu.a(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
      localConfigSeq.compress.set(1);
      break label1593;
      i = bhhr.aR(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
      localConfigSeq.version.set(i);
      break label1593;
      localConfigSeq.version.set(bhhr.aA(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
      localConfigSeq.compress.set(1);
      break label1593;
      i = bhhr.aU(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
      if (bhhr.aV(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount()) != AppSetting.a()) {
        i = 0;
      }
      localConfigSeq.version.set(i);
      break label1593;
      i = bhex.a();
      localConfigSeq.version.set(i);
      localConfigSeq.compress.set(1);
      if (!QLog.isColorLevel()) {
        break label1593;
      }
      QLog.i("JumpForwardPkgManager", 2, "JUMP_PKG_TOAST_CONFIG  ,version:" + i);
      break label1593;
      i = bmhu.a(paramQQAppInterface);
      localConfigSeq.version.set(i);
      localConfigSeq.compress.set(1);
      break label1593;
      i = aiin.a(paramQQAppInterface);
      localConfigSeq.version.set(i);
      localConfigSeq.compress.set(1);
      break label1593;
      localConfigSeq.version.set(((Integer)bhhr.a(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin(), "config_tim_team_version_code", Integer.valueOf(0))).intValue());
      break label1593;
      if (QLog.isColorLevel())
      {
        i = localArrayList2.size();
        localObject6 = localArrayList2.iterator();
        while (((Iterator)localObject6).hasNext())
        {
          localObject7 = (Integer)((Iterator)localObject6).next();
          QLog.d("SPLASH_ConfigServlet", 2, "addAllConfigs|send type: " + localObject7 + ",length: " + i);
        }
      }
      Object localObject6 = new ConfigurationService.DeviceInfo();
      if ((localArrayList2.contains(Integer.valueOf(1))) || (localArrayList2.contains(Integer.valueOf(2))) || (localArrayList2.contains(Integer.valueOf(3))) || (localArrayList2.contains(Integer.valueOf(12))))
      {
        localObject7 = new ConfigurationService.Screen();
        ((ConfigurationService.Screen)localObject7).setHasFlag(true);
        ((ConfigurationService.Screen)localObject7).width.set((int)DeviceInfoUtil.getPortraitWidth());
        ((ConfigurationService.Screen)localObject7).height.set((int)DeviceInfoUtil.getPortraitHeight());
        ((ConfigurationService.DeviceInfo)localObject6).screen = ((ConfigurationService.Screen)localObject7);
        ((ConfigurationService.DeviceInfo)localObject6).setHasFlag(true);
        ((ConfigurationService.ReqGetConfig)localObject1).device_info = ((ConfigurationService.DeviceInfo)localObject6);
      }
      if ((localArrayList2.contains(Integer.valueOf(47))) || (localArrayList2.contains(Integer.valueOf(65))) || (localArrayList2.contains(Integer.valueOf(156))) || (localArrayList2.contains(Integer.valueOf(297))))
      {
        localObject7 = new ConfigurationService.OS();
        ((ConfigurationService.OS)localObject7).setHasFlag(true);
        ((ConfigurationService.OS)localObject7).type.set(2);
        ((ConfigurationService.OS)localObject7).kernel.set(DeviceInfoUtil.getKernelVersion());
        ((ConfigurationService.OS)localObject7).sdk.set(String.valueOf(DeviceInfoUtil.getOsVersion()));
        ((ConfigurationService.OS)localObject7).version.set(DeviceInfoUtil.getDeviceOSVersion());
        ((ConfigurationService.OS)localObject7).rom.set(DeviceInfoUtil.getRomInfo());
        ((ConfigurationService.DeviceInfo)localObject6).brand.set(DeviceInfoUtil.getManufactureInfo());
        ((ConfigurationService.DeviceInfo)localObject6).model.set(DeviceInfoUtil.getDeviceModel());
        if (QLog.isDevelopLevel()) {
          QLog.w("SPLASH_ConfigServlet", 1, "addAllConfigs, brand[" + ((ConfigurationService.DeviceInfo)localObject6).brand.get() + "], model[" + ((ConfigurationService.DeviceInfo)localObject6).model.get() + "]");
        }
        ((ConfigurationService.DeviceInfo)localObject6).os = ((ConfigurationService.OS)localObject7);
        ((ConfigurationService.DeviceInfo)localObject6).setHasFlag(true);
        ((ConfigurationService.ReqGetConfig)localObject1).device_info = ((ConfigurationService.DeviceInfo)localObject6);
      }
      ((ConfigurationService.ReqGetConfig)localObject1).setHasFlag(true);
      ((ConfigurationService.ReqGetConfig)localObject1).seq_list.addAll(localArrayList1);
      if (paramIntent != null)
      {
        bool = paramIntent.getBooleanExtra("key_is_page_req", false);
        localObject6 = ((ConfigurationService.ReqGetConfig)localObject1).is_page_req;
        if (!bool) {
          break label9195;
        }
      }
      label9195:
      for (i = 1;; i = 0)
      {
        ((PBInt32Field)localObject6).set(i);
        localObject6 = paramIntent.getByteArrayExtra("key_cookies");
        if (localObject6 != null) {
          ((ConfigurationService.ReqGetConfig)localObject1).cookies.set(ByteStringMicro.copyFrom((byte[])localObject6));
        }
        localObject1 = a((ConfigurationService.ReqGetConfig)localObject1);
        if ((localObject1 != null) && (localObject1.length > 0)) {
          paramPacket.putSendData((byte[])localObject1);
        }
        if ((paramArrayOfInt == null) || (paramArrayOfInt.length != 1) || (paramArrayOfInt[0] != 215) || (paramQQAppInterface.isLogin())) {
          break;
        }
        paramPacket.setSSOCommand("ConfigurationService.ReqGetConfigNoLogin");
        paramIntent.putExtra("k_cmd_name", "ConfigurationService.ReqGetConfigNoLogin");
        return;
      }
      paramPacket.setSSOCommand("ConfigurationService.ReqGetConfig");
      return;
      break label3460;
      label9213:
      i = 1;
      break;
      label9219:
      i = 1;
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig, int paramInt)
  {
    int i = paramConfig.version.get();
    int j = bmhu.a(paramQQAppInterface);
    if (QLog.isColorLevel()) {
      QLog.d("AioReadInJoyConfigManager", 2, "received  Config remote version:" + i + " localversion= " + j);
    }
    if (i != j)
    {
      paramConfig = b(paramConfig, j, paramInt);
      if (QLog.isColorLevel()) {
        QLog.d("AioReadInJoyConfigManager", 2, "config content : " + paramConfig);
      }
      if (TextUtils.isEmpty(paramConfig)) {}
    }
    try
    {
      bmhu.a(paramQQAppInterface, new JSONObject(paramConfig).optInt("hot_video_enable", 0));
      bmhu.b(paramQQAppInterface, i);
      return;
    }
    catch (Exception paramConfig)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("AioReadInJoyConfigManager", 2, paramConfig.getMessage());
        }
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    jdField_a_of_type_JavaLangString = paramString;
    NewIntent localNewIntent = new NewIntent(paramQQAppInterface.getApp(), arph.class);
    int[] arrayOfInt1 = a();
    int[] arrayOfInt2 = new int[jdField_a_of_type_ArrayOfInt.length + aqxe.jdField_a_of_type_ArrayOfInt.length + arrayOfInt1.length];
    System.arraycopy(jdField_a_of_type_ArrayOfInt, 0, arrayOfInt2, 0, jdField_a_of_type_ArrayOfInt.length);
    System.arraycopy(aqxe.jdField_a_of_type_ArrayOfInt, 0, arrayOfInt2, jdField_a_of_type_ArrayOfInt.length, aqxe.jdField_a_of_type_ArrayOfInt.length);
    System.arraycopy(arrayOfInt1, 0, arrayOfInt2, jdField_a_of_type_ArrayOfInt.length + aqxe.jdField_a_of_type_ArrayOfInt.length, arrayOfInt1.length);
    localNewIntent.putExtra("k_cmd_type", arrayOfInt2);
    localNewIntent.putExtra("key_uin", paramString);
    localNewIntent.putExtra("k_req_occasion", 0);
    localNewIntent.putExtra("key_is_all_config", true);
    paramQQAppInterface.startServlet(localNewIntent);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString))) {
      if (QLog.isColorLevel()) {
        QLog.d("Q.nearby", 2, "HOTCHAT_SCENE_CONFIGS_CMD, app is null, or uin is empty");
      }
    }
    do
    {
      do
      {
        return;
        if ((paramInt == -1) || (bhhr.r(paramQQAppInterface.getApp()) != paramInt)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("Q.nearby", 2, "HOTCHAT_SCENE_CONFIGS_CMD, same version " + paramInt);
      return;
      jdField_a_of_type_JavaLangString = paramString;
      a(paramQQAppInterface, 49);
    } while (!QLog.isColorLevel());
    QLog.d("Q.nearby", 2, "HOTCHAT_SCENE_CONFIGS_CMD, " + paramInt);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, int paramInt, String paramString2)
  {
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString1)))
    {
      QLog.d("PatchLogTag", 1, "getPatchConfig app is null or uin is empty");
      return;
    }
    if ((paramInt != -1) && (PatchSharedPreUtil.getPatchConfigVersion(paramQQAppInterface.getApplication()) == paramInt))
    {
      QLog.d("PatchLogTag", 1, "getPatchConfig same version=" + paramInt + ", reason=" + paramString2);
      return;
    }
    jdField_a_of_type_JavaLangString = paramString1;
    a(paramQQAppInterface, 46);
    QLog.d("PatchLogTag", 1, "getPatchConfig version=" + paramInt + ", reason=" + paramString2);
  }
  
  /* Error */
  private void a(ConfigurationService.ReqGetConfig paramReqGetConfig, ConfigurationService.ConfigSeq paramConfigSeq, QQAppInterface paramQQAppInterface)
  {
    // Byte code:
    //   0: aload_3
    //   1: invokevirtual 65	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   4: getstatic 15	arph:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   7: invokestatic 2413	bhhr:ak	(Landroid/content/Context;Ljava/lang/String;)I
    //   10: invokestatic 210	com/tencent/common/config/AppSetting:a	()I
    //   13: if_icmpeq +114 -> 127
    //   16: aload_3
    //   17: invokevirtual 65	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   20: getstatic 15	arph:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   23: invokestatic 210	com/tencent/common/config/AppSetting:a	()I
    //   26: invokestatic 2415	bhhr:H	(Landroid/content/Context;Ljava/lang/String;I)V
    //   29: aload_3
    //   30: invokevirtual 65	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   33: getstatic 15	arph:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   36: iconst_0
    //   37: invokestatic 2417	bhhr:I	(Landroid/content/Context;Ljava/lang/String;I)V
    //   40: iconst_0
    //   41: istore 4
    //   43: aload_2
    //   44: getfield 1363	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$ConfigSeq:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   47: iload 4
    //   49: invokevirtual 1329	com/tencent/mobileqq/pb/PBInt32Field:set	(I)V
    //   52: invokestatic 2420	com/tencent/mobileqq/utils/DeviceInfoUtil:getCarrierList	()Ljava/util/ArrayList;
    //   55: astore 5
    //   57: aload 5
    //   59: ifnull +119 -> 178
    //   62: aload 5
    //   64: invokevirtual 2421	java/util/ArrayList:size	()I
    //   67: ifle +111 -> 178
    //   70: aload 5
    //   72: invokevirtual 2422	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   75: astore_2
    //   76: aload_2
    //   77: invokeinterface 251 1 0
    //   82: ifeq +96 -> 178
    //   85: aload_2
    //   86: invokeinterface 255 1 0
    //   91: checkcast 139	java/lang/Integer
    //   94: astore 6
    //   96: aload_1
    //   97: getfield 2425	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$ReqGetConfig:carriers	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   100: aload 6
    //   102: invokevirtual 2428	com/tencent/mobileqq/pb/PBRepeatField:add	(Ljava/lang/Object;)V
    //   105: goto -29 -> 76
    //   108: astore_1
    //   109: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   112: ifeq +14 -> 126
    //   115: ldc_w 2430
    //   118: iconst_2
    //   119: ldc_w 2432
    //   122: aload_1
    //   123: invokestatic 1903	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   126: return
    //   127: aload_3
    //   128: invokevirtual 65	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   131: getstatic 15	arph:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   134: invokestatic 2435	bhhr:al	(Landroid/content/Context;Ljava/lang/String;)I
    //   137: istore 4
    //   139: goto -96 -> 43
    //   142: astore_2
    //   143: ldc 189
    //   145: iconst_2
    //   146: new 85	java/lang/StringBuilder
    //   149: dup
    //   150: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   153: ldc_w 2437
    //   156: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: aload_2
    //   160: invokevirtual 899	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   163: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   169: invokestatic 658	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   172: aconst_null
    //   173: astore 5
    //   175: goto -118 -> 57
    //   178: aload_3
    //   179: getstatic 1807	com/tencent/mobileqq/app/QQManagerFactory:CONTACT_MANAGER	I
    //   182: invokevirtual 166	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   185: checkcast 2439	awyz
    //   188: invokeinterface 2442 1 0
    //   193: astore 6
    //   195: aload 6
    //   197: ifnull +229 -> 426
    //   200: aload 6
    //   202: getfield 2447	SecurityAccountServer/RespondQueryQQBindingStat:nationCode	Ljava/lang/String;
    //   205: astore_3
    //   206: aload_3
    //   207: astore_2
    //   208: aload_3
    //   209: ifnull +21 -> 230
    //   212: aload_3
    //   213: astore_2
    //   214: aload_3
    //   215: ldc_w 2449
    //   218: invokevirtual 2452	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   221: ifeq +9 -> 230
    //   224: aload_3
    //   225: iconst_1
    //   226: invokevirtual 2455	java/lang/String:substring	(I)Ljava/lang/String;
    //   229: astore_2
    //   230: aload_2
    //   231: invokestatic 126	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   234: ifeq +130 -> 364
    //   237: aload 6
    //   239: getfield 2458	SecurityAccountServer/RespondQueryQQBindingStat:mobileNo	Ljava/lang/String;
    //   242: invokestatic 126	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   245: ifeq +119 -> 364
    //   248: ldc 13
    //   250: astore_2
    //   251: aload_2
    //   252: invokestatic 126	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   255: ifne +11 -> 266
    //   258: aload_1
    //   259: getfield 2461	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$ReqGetConfig:bind_phone_no	Lcom/tencent/mobileqq/pb/PBStringField;
    //   262: aload_2
    //   263: invokevirtual 1450	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   266: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   269: ifeq -143 -> 126
    //   272: new 85	java/lang/StringBuilder
    //   275: dup
    //   276: bipush 100
    //   278: invokespecial 2462	java/lang/StringBuilder:<init>	(I)V
    //   281: astore_1
    //   282: aload_1
    //   283: ldc_w 2464
    //   286: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   289: iload 4
    //   291: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   294: ldc_w 2466
    //   297: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   300: aload_2
    //   301: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   304: pop
    //   305: aload_1
    //   306: ldc_w 2468
    //   309: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   312: pop
    //   313: aload 5
    //   315: ifnull +91 -> 406
    //   318: aload 5
    //   320: invokevirtual 2421	java/util/ArrayList:size	()I
    //   323: ifle +83 -> 406
    //   326: aload 5
    //   328: invokevirtual 2422	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   331: astore_2
    //   332: aload_2
    //   333: invokeinterface 251 1 0
    //   338: ifeq +68 -> 406
    //   341: aload_1
    //   342: aload_2
    //   343: invokeinterface 255 1 0
    //   348: checkcast 139	java/lang/Integer
    //   351: invokevirtual 825	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   354: ldc_w 2470
    //   357: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   360: pop
    //   361: goto -29 -> 332
    //   364: invokestatic 1121	java/util/Locale:getDefault	()Ljava/util/Locale;
    //   367: astore 7
    //   369: aload_2
    //   370: astore_3
    //   371: aload_2
    //   372: ifnonnull +6 -> 378
    //   375: ldc 13
    //   377: astore_3
    //   378: aload 7
    //   380: ldc_w 2472
    //   383: iconst_2
    //   384: anewarray 314	java/lang/Object
    //   387: dup
    //   388: iconst_0
    //   389: aload_3
    //   390: aastore
    //   391: dup
    //   392: iconst_1
    //   393: aload 6
    //   395: getfield 2458	SecurityAccountServer/RespondQueryQQBindingStat:mobileNo	Ljava/lang/String;
    //   398: aastore
    //   399: invokestatic 1126	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   402: astore_2
    //   403: goto -152 -> 251
    //   406: aload_1
    //   407: ldc_w 2305
    //   410: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   413: pop
    //   414: ldc_w 2430
    //   417: iconst_2
    //   418: aload_1
    //   419: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   422: invokestatic 206	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   425: return
    //   426: ldc 13
    //   428: astore_2
    //   429: goto -178 -> 251
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	432	0	this	arph
    //   0	432	1	paramReqGetConfig	ConfigurationService.ReqGetConfig
    //   0	432	2	paramConfigSeq	ConfigurationService.ConfigSeq
    //   0	432	3	paramQQAppInterface	QQAppInterface
    //   41	249	4	i	int
    //   55	272	5	localArrayList	ArrayList
    //   94	300	6	localObject	Object
    //   367	12	7	localLocale	Locale
    // Exception table:
    //   from	to	target	type
    //   0	40	108	java/lang/Exception
    //   43	52	108	java/lang/Exception
    //   52	57	108	java/lang/Exception
    //   62	76	108	java/lang/Exception
    //   76	105	108	java/lang/Exception
    //   127	139	108	java/lang/Exception
    //   143	172	108	java/lang/Exception
    //   178	195	108	java/lang/Exception
    //   200	206	108	java/lang/Exception
    //   214	230	108	java/lang/Exception
    //   230	248	108	java/lang/Exception
    //   251	266	108	java/lang/Exception
    //   266	313	108	java/lang/Exception
    //   318	332	108	java/lang/Exception
    //   332	361	108	java/lang/Exception
    //   364	369	108	java/lang/Exception
    //   378	403	108	java/lang/Exception
    //   406	425	108	java/lang/Exception
    //   52	57	142	java/lang/Throwable
  }
  
  /* Error */
  private void a(ConfigurationService.RespGetConfig paramRespGetConfig, QQAppInterface paramQQAppInterface, Intent paramIntent, int[] paramArrayOfInt, boolean paramBoolean)
  {
    // Byte code:
    //   0: iload 5
    //   2: ifeq +30 -> 32
    //   5: aload_1
    //   6: getfield 2480	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:result	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   9: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   12: ifne +20 -> 32
    //   15: aload_1
    //   16: getfield 2483	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:config_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   19: ifnull +13 -> 32
    //   22: aload_1
    //   23: getfield 2483	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:config_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   26: invokevirtual 237	com/tencent/mobileqq/pb/PBRepeatMessageField:size	()I
    //   29: ifne +1970 -> 1999
    //   32: iload 5
    //   34: ifne +418 -> 452
    //   37: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   40: ifeq +12 -> 52
    //   43: ldc 189
    //   45: iconst_2
    //   46: ldc_w 2485
    //   49: invokestatic 206	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   52: iconst_0
    //   53: istore 7
    //   55: iload 7
    //   57: aload 4
    //   59: arraylength
    //   60: if_icmpge +11673 -> 11733
    //   63: aload 4
    //   65: iload 7
    //   67: iaload
    //   68: istore 9
    //   70: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   73: ifeq +30 -> 103
    //   76: ldc 189
    //   78: iconst_2
    //   79: new 85	java/lang/StringBuilder
    //   82: dup
    //   83: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   86: ldc_w 2487
    //   89: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: iload 9
    //   94: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   97: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   100: invokestatic 206	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   103: iload 9
    //   105: lookupswitch	default:+251->356, 46:+512->617, 69:+575->680, 86:+993->1098, 87:+815->920, 88:+658->763, 113:+1203->1308, 116:+421->526, 119:+1179->1284, 140:+1351->1456, 149:+410->515, 156:+338->443, 165:+1540->1645, 174:+1617->1722, 180:+410->515, 185:+1708->1813, 188:+1261->1366, 202:+1762->1867, 206:+1306->1411, 210:+1808->1913, 215:+1864->1969, 218:+410->515, 223:+1245->1350, 257:+1450->1555, 260:+1495->1600, 273:+1662->1767, 283:+569->674, 321:+1717->1822, 364:+1245->1350, 365:+1245->1350, 604:+1585->1690
    //   357: istore 8
    //   359: iload 8
    //   361: istore 6
    //   363: invokestatic 1334	aqxe:a	()Laqxe;
    //   366: iload 9
    //   368: invokevirtual 1337	aqxe:b	(I)Z
    //   371: ifeq +48 -> 419
    //   374: invokestatic 1334	aqxe:a	()Laqxe;
    //   377: iload 9
    //   379: invokevirtual 1340	aqxe:a	(I)Laqwt;
    //   382: astore_3
    //   383: iload 8
    //   385: istore 6
    //   387: aload_3
    //   388: ifnull +31 -> 419
    //   391: aload_1
    //   392: getfield 2480	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:result	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   395: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   398: ifeq +1584 -> 1982
    //   401: bipush 254
    //   403: istore 6
    //   405: iload 6
    //   407: ifeq +9 -> 416
    //   410: aload_3
    //   411: iload 6
    //   413: invokevirtual 2490	aqwt:onReqFailed	(I)V
    //   416: iconst_1
    //   417: istore 6
    //   419: iload 6
    //   421: ifne +22 -> 443
    //   424: aload_2
    //   425: invokevirtual 1371	com/tencent/mobileqq/app/QQAppInterface:getConfigProcess	()Laqwg;
    //   428: aload_2
    //   429: iload 9
    //   431: iload 5
    //   433: aload_1
    //   434: getfield 2480	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:result	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   437: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   440: invokevirtual 2493	aqwg:a	(Lcom/tencent/mobileqq/app/QQAppInterface;IZI)V
    //   443: iload 7
    //   445: iconst_1
    //   446: iadd
    //   447: istore 7
    //   449: goto -394 -> 55
    //   452: aload_1
    //   453: getfield 2480	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:result	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   456: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   459: ifeq +21 -> 480
    //   462: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   465: ifeq -413 -> 52
    //   468: ldc 189
    //   470: iconst_2
    //   471: ldc_w 2495
    //   474: invokestatic 206	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   477: goto -425 -> 52
    //   480: aload_1
    //   481: getfield 2483	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:config_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   484: ifnull +13 -> 497
    //   487: aload_1
    //   488: getfield 2483	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:config_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   491: invokevirtual 237	com/tencent/mobileqq/pb/PBRepeatMessageField:size	()I
    //   494: ifne -442 -> 52
    //   497: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   500: ifeq -448 -> 52
    //   503: ldc 189
    //   505: iconst_2
    //   506: ldc_w 2497
    //   509: invokestatic 206	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   512: goto -460 -> 52
    //   515: iload 9
    //   517: iload 5
    //   519: aload_1
    //   520: invokestatic 2500	lbx:a	(IZLcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig;)V
    //   523: goto -80 -> 443
    //   526: iload 5
    //   528: ifeq +13 -> 541
    //   531: aload_1
    //   532: getfield 2480	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:result	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   535: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   538: ifeq -95 -> 443
    //   541: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   544: ifeq +12 -> 556
    //   547: ldc 189
    //   549: iconst_2
    //   550: ldc_w 2502
    //   553: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   556: aload_0
    //   557: getfield 2504	arph:jdField_a_of_type_Boolean	Z
    //   560: ifne +35 -> 595
    //   563: aload_2
    //   564: ldc_w 2506
    //   567: ldc 13
    //   569: ldc 13
    //   571: ldc_w 2508
    //   574: ldc_w 2508
    //   577: iconst_0
    //   578: iconst_0
    //   579: ldc 13
    //   581: ldc 13
    //   583: ldc 13
    //   585: ldc 13
    //   587: invokestatic 2513	bdla:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   590: aload_0
    //   591: iconst_1
    //   592: putfield 2504	arph:jdField_a_of_type_Boolean	Z
    //   595: aload_2
    //   596: getstatic 1843	com/tencent/mobileqq/app/BusinessHandlerFactory:CONFIG_HANDLER	I
    //   599: invokevirtual 219	com/tencent/mobileqq/app/QQAppInterface:getBusinessHandler	(I)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   602: checkcast 1845	ansg
    //   605: invokestatic 2518	bgvx:a	()Lbgvx;
    //   608: invokevirtual 2521	bgvx:a	()Lcom/tencent/mobileqq/upgrade/UpgradeDetailWrapper;
    //   611: invokevirtual 2524	ansg:a	(Lcom/tencent/mobileqq/upgrade/UpgradeDetailWrapper;)V
    //   614: goto -171 -> 443
    //   617: aload_1
    //   618: getfield 2480	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:result	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   621: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   624: ifeq +26 -> 650
    //   627: getstatic 2528	com/tencent/common/app/BaseApplicationImpl:sApplication	Lcom/tencent/common/app/BaseApplicationImpl;
    //   630: aload_2
    //   631: invokevirtual 1636	com/tencent/mobileqq/app/QQAppInterface:getCurrentUin	()Ljava/lang/String;
    //   634: ldc_w 2530
    //   637: bipush 101
    //   639: ldc 13
    //   641: invokestatic 2536	com/tencent/mobileqq/msf/core/net/patch/PatchReporter:reportPatchEvent	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)V
    //   644: invokestatic 2539	aauu:c	()V
    //   647: goto -204 -> 443
    //   650: aload_1
    //   651: getfield 2483	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:config_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   654: ifnull +13 -> 667
    //   657: aload_1
    //   658: getfield 2483	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:config_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   661: invokevirtual 237	com/tencent/mobileqq/pb/PBRepeatMessageField:size	()I
    //   664: ifne -20 -> 644
    //   667: aload_2
    //   668: invokestatic 2542	aclq:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   671: goto -27 -> 644
    //   674: invokestatic 2539	aauu:c	()V
    //   677: goto -234 -> 443
    //   680: iload 5
    //   682: ifeq +13 -> 695
    //   685: aload_1
    //   686: getfield 2480	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:result	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   689: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   692: ifeq -249 -> 443
    //   695: aload_2
    //   696: getstatic 2545	com/tencent/mobileqq/app/QQManagerFactory:PASSWD_RED_BAG_MANAGER	I
    //   699: invokevirtual 166	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   702: checkcast 2547	akqe
    //   705: astore_3
    //   706: aload_3
    //   707: iconst_1
    //   708: putfield 2548	akqe:jdField_b_of_type_Boolean	Z
    //   711: aload_3
    //   712: getstatic 2553	com/tencent/mobileqq/data/MessageForFoldMsgGrayTips:PASSWD_REDBAG_MSG_SWITCH_DEFAULT	Z
    //   715: putfield 2554	akqe:c	Z
    //   718: aload_3
    //   719: getstatic 2557	com/tencent/mobileqq/data/MessageForFoldMsgGrayTips:PASSWD_REDBAG_MSG_DISPLAY_NUM_DEFAULT	I
    //   722: putfield 2559	akqe:jdField_a_of_type_Int	I
    //   725: aload_3
    //   726: getstatic 2562	com/tencent/mobileqq/data/MessageForFoldMsgGrayTips:PASSWD_REDBAG_MSG_INDEX_WITH_ID	Z
    //   729: putfield 2564	akqe:e	Z
    //   732: aload_2
    //   733: invokevirtual 65	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   736: aload_2
    //   737: invokevirtual 69	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   740: iconst_0
    //   741: aload_3
    //   742: getfield 2554	akqe:c	Z
    //   745: aload_3
    //   746: getfield 2559	akqe:jdField_a_of_type_Int	I
    //   749: aload_3
    //   750: getfield 2566	akqe:d	Z
    //   753: aload_3
    //   754: getfield 2564	akqe:e	Z
    //   757: invokestatic 2569	bhhr:a	(Landroid/content/Context;Ljava/lang/String;IZIZZ)V
    //   760: goto -317 -> 443
    //   763: iload 5
    //   765: ifne +51 -> 816
    //   768: aload_2
    //   769: bipush 88
    //   771: iconst_0
    //   772: iconst_0
    //   773: iconst_1
    //   774: iconst_1
    //   775: iconst_0
    //   776: invokestatic 2574	com/tencent/mobileqq/olympic/OlympicServlet:a	(Lmqq/app/AppRuntime;IIIIII)V
    //   779: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   782: ifeq -339 -> 443
    //   785: ldc_w 1764
    //   788: iconst_2
    //   789: new 85	java/lang/StringBuilder
    //   792: dup
    //   793: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   796: ldc_w 2576
    //   799: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   802: iload 5
    //   804: invokevirtual 152	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   807: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   810: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   813: goto -370 -> 443
    //   816: aload_1
    //   817: getfield 2480	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:result	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   820: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   823: ifeq +61 -> 884
    //   826: aload_1
    //   827: getfield 2480	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:result	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   830: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   833: istore 6
    //   835: aload_2
    //   836: bipush 88
    //   838: iconst_0
    //   839: iconst_0
    //   840: iconst_1
    //   841: iload 6
    //   843: iconst_0
    //   844: invokestatic 2574	com/tencent/mobileqq/olympic/OlympicServlet:a	(Lmqq/app/AppRuntime;IIIIII)V
    //   847: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   850: ifeq -407 -> 443
    //   853: ldc_w 1764
    //   856: iconst_2
    //   857: new 85	java/lang/StringBuilder
    //   860: dup
    //   861: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   864: ldc_w 2578
    //   867: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   870: iload 6
    //   872: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   875: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   878: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   881: goto -438 -> 443
    //   884: aload_1
    //   885: getfield 2483	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:config_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   888: ifnull +13 -> 901
    //   891: aload_1
    //   892: getfield 2483	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:config_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   895: invokevirtual 237	com/tencent/mobileqq/pb/PBRepeatMessageField:size	()I
    //   898: ifne -455 -> 443
    //   901: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   904: ifeq -461 -> 443
    //   907: ldc_w 1764
    //   910: iconst_2
    //   911: ldc_w 2580
    //   914: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   917: goto -474 -> 443
    //   920: iload 5
    //   922: ifne +72 -> 994
    //   925: aload_2
    //   926: bipush 87
    //   928: iconst_0
    //   929: iconst_0
    //   930: iconst_1
    //   931: iconst_1
    //   932: iconst_0
    //   933: invokestatic 2574	com/tencent/mobileqq/olympic/OlympicServlet:a	(Lmqq/app/AppRuntime;IIIIII)V
    //   936: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   939: ifeq +31 -> 970
    //   942: ldc_w 1764
    //   945: iconst_2
    //   946: new 85	java/lang/StringBuilder
    //   949: dup
    //   950: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   953: ldc_w 2582
    //   956: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   959: iload 5
    //   961: invokevirtual 152	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   964: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   967: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   970: aload_2
    //   971: getstatic 1735	com/tencent/mobileqq/app/QQManagerFactory:AR_RESOURCE_MANAGER	I
    //   974: invokevirtual 166	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   977: checkcast 1737	apgi
    //   980: astore_3
    //   981: aload_3
    //   982: ifnull -539 -> 443
    //   985: aload_3
    //   986: iconst_1
    //   987: iconst_0
    //   988: invokevirtual 2585	apgi:a	(ZZ)V
    //   991: goto -548 -> 443
    //   994: aload_1
    //   995: getfield 2480	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:result	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   998: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   1001: ifeq +61 -> 1062
    //   1004: aload_1
    //   1005: getfield 2480	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:result	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   1008: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   1011: istore 6
    //   1013: aload_2
    //   1014: bipush 87
    //   1016: iconst_0
    //   1017: iconst_0
    //   1018: iconst_1
    //   1019: iload 6
    //   1021: iconst_0
    //   1022: invokestatic 2574	com/tencent/mobileqq/olympic/OlympicServlet:a	(Lmqq/app/AppRuntime;IIIIII)V
    //   1025: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1028: ifeq -58 -> 970
    //   1031: ldc_w 1764
    //   1034: iconst_2
    //   1035: new 85	java/lang/StringBuilder
    //   1038: dup
    //   1039: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   1042: ldc_w 2587
    //   1045: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1048: iload 6
    //   1050: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1053: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1056: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1059: goto -89 -> 970
    //   1062: aload_1
    //   1063: getfield 2483	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:config_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   1066: ifnull +13 -> 1079
    //   1069: aload_1
    //   1070: getfield 2483	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:config_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   1073: invokevirtual 237	com/tencent/mobileqq/pb/PBRepeatMessageField:size	()I
    //   1076: ifne -106 -> 970
    //   1079: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1082: ifeq -112 -> 970
    //   1085: ldc_w 1764
    //   1088: iconst_2
    //   1089: ldc_w 2589
    //   1092: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1095: goto -125 -> 970
    //   1098: iload 5
    //   1100: ifne +77 -> 1177
    //   1103: aload_0
    //   1104: invokevirtual 47	arph:getAppRuntime	()Lmqq/app/AppRuntime;
    //   1107: bipush 86
    //   1109: iconst_0
    //   1110: iconst_0
    //   1111: iconst_1
    //   1112: iconst_1
    //   1113: iconst_0
    //   1114: invokestatic 2574	com/tencent/mobileqq/olympic/OlympicServlet:a	(Lmqq/app/AppRuntime;IIIIII)V
    //   1117: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1120: ifeq +31 -> 1151
    //   1123: ldc_w 1720
    //   1126: iconst_2
    //   1127: new 85	java/lang/StringBuilder
    //   1130: dup
    //   1131: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   1134: ldc_w 2591
    //   1137: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1140: iload 5
    //   1142: invokevirtual 152	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1145: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1148: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1151: aload_2
    //   1152: getstatic 1694	com/tencent/mobileqq/app/QQManagerFactory:OLYMPIC_MANAGER	I
    //   1155: invokevirtual 166	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   1158: checkcast 1696	com/tencent/mobileqq/olympic/OlympicManager
    //   1161: astore_3
    //   1162: aload_3
    //   1163: ifnull -720 -> 443
    //   1166: aload_3
    //   1167: invokevirtual 2593	com/tencent/mobileqq/olympic/OlympicManager:f	()V
    //   1170: aload_3
    //   1171: invokevirtual 2595	com/tencent/mobileqq/olympic/OlympicManager:g	()V
    //   1174: goto -731 -> 443
    //   1177: aload_1
    //   1178: getfield 2480	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:result	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   1181: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   1184: ifeq +64 -> 1248
    //   1187: aload_1
    //   1188: getfield 2480	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:result	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   1191: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   1194: istore 6
    //   1196: aload_0
    //   1197: invokevirtual 47	arph:getAppRuntime	()Lmqq/app/AppRuntime;
    //   1200: bipush 86
    //   1202: iconst_0
    //   1203: iconst_0
    //   1204: iconst_1
    //   1205: iload 6
    //   1207: iconst_0
    //   1208: invokestatic 2574	com/tencent/mobileqq/olympic/OlympicServlet:a	(Lmqq/app/AppRuntime;IIIIII)V
    //   1211: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1214: ifeq -63 -> 1151
    //   1217: ldc_w 1720
    //   1220: iconst_2
    //   1221: new 85	java/lang/StringBuilder
    //   1224: dup
    //   1225: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   1228: ldc_w 2597
    //   1231: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1234: iload 6
    //   1236: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1239: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1242: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1245: goto -94 -> 1151
    //   1248: aload_1
    //   1249: getfield 2483	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:config_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   1252: ifnull +13 -> 1265
    //   1255: aload_1
    //   1256: getfield 2483	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:config_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   1259: invokevirtual 237	com/tencent/mobileqq/pb/PBRepeatMessageField:size	()I
    //   1262: ifne -111 -> 1151
    //   1265: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1268: ifeq -117 -> 1151
    //   1271: ldc_w 1720
    //   1274: iconst_2
    //   1275: ldc_w 2599
    //   1278: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1281: goto -130 -> 1151
    //   1284: aload_2
    //   1285: getstatic 1857	com/tencent/mobileqq/app/BusinessHandlerFactory:BABY_Q_HANDLER	I
    //   1288: invokevirtual 219	com/tencent/mobileqq/app/QQAppInterface:getBusinessHandler	(I)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   1291: checkcast 1859	anqn
    //   1294: astore_3
    //   1295: aload_3
    //   1296: ifnull -853 -> 443
    //   1299: aload_3
    //   1300: iconst_0
    //   1301: iconst_0
    //   1302: invokevirtual 2600	anqn:a	(ZZ)V
    //   1305: goto -862 -> 443
    //   1308: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1311: ifeq +12 -> 1323
    //   1314: ldc 189
    //   1316: iconst_2
    //   1317: ldc_w 2602
    //   1320: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1323: aload_2
    //   1324: getstatic 2605	com/tencent/mobileqq/app/QQManagerFactory:PRECOVER_MANAGER	I
    //   1327: invokevirtual 166	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   1330: checkcast 2607	azod
    //   1333: astore_3
    //   1334: aload_3
    //   1335: ifnull -892 -> 443
    //   1338: aload_3
    //   1339: invokevirtual 2608	azod:a	()V
    //   1342: aload_3
    //   1343: iconst_0
    //   1344: invokevirtual 2609	azod:a	(Z)V
    //   1347: goto -904 -> 443
    //   1350: aload_2
    //   1351: invokestatic 1558	com/tencent/mobileqq/utils/BusinessCommonConfig:getInstance	(Lmqq/app/AppRuntime;)Lcom/tencent/mobileqq/utils/BusinessCommonConfig;
    //   1354: aload_2
    //   1355: iload 9
    //   1357: iload 5
    //   1359: aload_1
    //   1360: invokevirtual 2613	com/tencent/mobileqq/utils/BusinessCommonConfig:handleResp_Config_Fail	(Lcom/tencent/mobileqq/app/QQAppInterface;IZLcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig;)V
    //   1363: goto -920 -> 443
    //   1366: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1369: ifeq -926 -> 443
    //   1372: aload_1
    //   1373: getfield 2480	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:result	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   1376: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   1379: istore 6
    //   1381: ldc 189
    //   1383: iconst_2
    //   1384: new 85	java/lang/StringBuilder
    //   1387: dup
    //   1388: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   1391: ldc_w 2615
    //   1394: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1397: iload 6
    //   1399: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1402: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1405: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1408: goto -965 -> 443
    //   1411: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1414: ifeq -971 -> 443
    //   1417: aload_1
    //   1418: getfield 2480	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:result	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   1421: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   1424: istore 6
    //   1426: ldc 189
    //   1428: iconst_2
    //   1429: new 85	java/lang/StringBuilder
    //   1432: dup
    //   1433: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   1436: ldc_w 2617
    //   1439: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1442: iload 6
    //   1444: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1447: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1450: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1453: goto -1010 -> 443
    //   1456: aload_1
    //   1457: getfield 2480	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:result	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   1460: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   1463: istore 6
    //   1465: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1468: ifeq +30 -> 1498
    //   1471: ldc 189
    //   1473: iconst_2
    //   1474: new 85	java/lang/StringBuilder
    //   1477: dup
    //   1478: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   1481: ldc_w 2619
    //   1484: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1487: iload 6
    //   1489: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1492: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1495: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1498: new 2621	java/util/HashMap
    //   1501: dup
    //   1502: invokespecial 2622	java/util/HashMap:<init>	()V
    //   1505: astore_3
    //   1506: aload_3
    //   1507: ldc_w 2624
    //   1510: new 85	java/lang/StringBuilder
    //   1513: dup
    //   1514: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   1517: iload 6
    //   1519: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1522: ldc 13
    //   1524: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1527: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1530: invokevirtual 2627	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1533: pop
    //   1534: invokestatic 397	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1537: invokestatic 1727	com/tencent/mobileqq/statistics/StatisticCollector:getInstance	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   1540: aconst_null
    //   1541: ldc_w 2629
    //   1544: iconst_0
    //   1545: lconst_0
    //   1546: lconst_0
    //   1547: aload_3
    //   1548: aconst_null
    //   1549: invokevirtual 2632	com/tencent/mobileqq/statistics/StatisticCollector:collectPerformance	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;)V
    //   1552: goto -1109 -> 443
    //   1555: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1558: ifeq -1115 -> 443
    //   1561: aload_1
    //   1562: getfield 2480	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:result	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   1565: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   1568: istore 6
    //   1570: ldc 189
    //   1572: iconst_2
    //   1573: invokestatic 1121	java/util/Locale:getDefault	()Ljava/util/Locale;
    //   1576: ldc_w 2634
    //   1579: iconst_1
    //   1580: anewarray 314	java/lang/Object
    //   1583: dup
    //   1584: iconst_0
    //   1585: iload 6
    //   1587: invokestatic 318	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1590: aastore
    //   1591: invokestatic 1126	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   1594: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1597: goto -1154 -> 443
    //   1600: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1603: ifeq -1160 -> 443
    //   1606: aload_1
    //   1607: getfield 2480	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:result	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   1610: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   1613: istore 6
    //   1615: ldc 189
    //   1617: iconst_2
    //   1618: invokestatic 1121	java/util/Locale:getDefault	()Ljava/util/Locale;
    //   1621: ldc_w 2636
    //   1624: iconst_1
    //   1625: anewarray 314	java/lang/Object
    //   1628: dup
    //   1629: iconst_0
    //   1630: iload 6
    //   1632: invokestatic 318	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1635: aastore
    //   1636: invokestatic 1126	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   1639: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1642: goto -1199 -> 443
    //   1645: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1648: ifeq -1205 -> 443
    //   1651: aload_1
    //   1652: getfield 2480	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:result	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   1655: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   1658: istore 6
    //   1660: ldc 189
    //   1662: iconst_2
    //   1663: new 85	java/lang/StringBuilder
    //   1666: dup
    //   1667: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   1670: ldc_w 2638
    //   1673: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1676: iload 6
    //   1678: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1681: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1684: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1687: goto -1244 -> 443
    //   1690: ldc 189
    //   1692: iconst_1
    //   1693: iconst_2
    //   1694: anewarray 314	java/lang/Object
    //   1697: dup
    //   1698: iconst_0
    //   1699: ldc_w 2640
    //   1702: aastore
    //   1703: dup
    //   1704: iconst_1
    //   1705: aload_1
    //   1706: getfield 2480	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:result	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   1709: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   1712: invokestatic 318	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1715: aastore
    //   1716: invokestatic 2642	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   1719: goto -1276 -> 443
    //   1722: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1725: ifeq -1282 -> 443
    //   1728: aload_1
    //   1729: getfield 2480	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:result	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   1732: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   1735: istore 6
    //   1737: ldc 189
    //   1739: iconst_2
    //   1740: new 85	java/lang/StringBuilder
    //   1743: dup
    //   1744: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   1747: ldc_w 2644
    //   1750: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1753: iload 6
    //   1755: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1758: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1761: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1764: goto -1321 -> 443
    //   1767: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1770: ifeq -1327 -> 443
    //   1773: aload_1
    //   1774: getfield 2480	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:result	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   1777: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   1780: istore 6
    //   1782: ldc_w 2646
    //   1785: iconst_2
    //   1786: new 85	java/lang/StringBuilder
    //   1789: dup
    //   1790: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   1793: ldc_w 2648
    //   1796: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1799: iload 6
    //   1801: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1804: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1807: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1810: goto -1367 -> 443
    //   1813: invokestatic 2653	com/tencent/mobileqq/scribble/ScribbleResMgr:a	()Lcom/tencent/mobileqq/scribble/ScribbleResMgr;
    //   1816: invokevirtual 2655	com/tencent/mobileqq/scribble/ScribbleResMgr:b	()V
    //   1819: goto -1376 -> 443
    //   1822: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1825: ifeq -1382 -> 443
    //   1828: aload_1
    //   1829: getfield 2480	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:result	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   1832: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   1835: istore 6
    //   1837: ldc 189
    //   1839: iconst_2
    //   1840: new 85	java/lang/StringBuilder
    //   1843: dup
    //   1844: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   1847: ldc_w 2657
    //   1850: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1853: iload 6
    //   1855: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1858: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1861: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1864: goto -1421 -> 443
    //   1867: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1870: ifeq -1427 -> 443
    //   1873: aload_1
    //   1874: getfield 2480	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:result	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   1877: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   1880: istore 6
    //   1882: ldc_w 2430
    //   1885: iconst_2
    //   1886: new 85	java/lang/StringBuilder
    //   1889: dup
    //   1890: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   1893: ldc_w 2659
    //   1896: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1899: iload 6
    //   1901: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1904: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1907: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1910: goto -1467 -> 443
    //   1913: aload_2
    //   1914: getstatic 2040	com/tencent/mobileqq/app/QQManagerFactory:OCR_MANAGER	I
    //   1917: invokevirtual 166	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   1920: checkcast 2042	ayrg
    //   1923: astore_3
    //   1924: aload_1
    //   1925: getfield 2480	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:result	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   1928: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   1931: istore 6
    //   1933: ldc 189
    //   1935: iconst_1
    //   1936: new 85	java/lang/StringBuilder
    //   1939: dup
    //   1940: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   1943: ldc_w 2661
    //   1946: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1949: iload 6
    //   1951: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1954: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1957: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1960: aload_3
    //   1961: iconst_0
    //   1962: aconst_null
    //   1963: invokevirtual 2664	ayrg:a	(ZLcom/tencent/mobileqq/ocr/data/OcrConfig;)V
    //   1966: goto -1523 -> 443
    //   1969: aload_1
    //   1970: getfield 2480	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:result	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   1973: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   1976: invokestatic 2665	com/tencent/mobileqq/shortvideo/ShortVideoResourceManager:a	(I)V
    //   1979: goto -1536 -> 443
    //   1982: iload 5
    //   1984: ifne +9 -> 1993
    //   1987: iconst_m1
    //   1988: istore 6
    //   1990: goto -1585 -> 405
    //   1993: iconst_0
    //   1994: istore 6
    //   1996: goto -1591 -> 405
    //   1999: invokestatic 2668	java/lang/System:currentTimeMillis	()J
    //   2002: lstore 12
    //   2004: aload_1
    //   2005: getfield 2483	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:config_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   2008: invokevirtual 237	com/tencent/mobileqq/pb/PBRepeatMessageField:size	()I
    //   2011: istore 9
    //   2013: new 1160	java/util/ArrayList
    //   2016: dup
    //   2017: aload 4
    //   2019: arraylength
    //   2020: invokespecial 1191	java/util/ArrayList:<init>	(I)V
    //   2023: astore 18
    //   2025: iconst_0
    //   2026: istore 6
    //   2028: iload 6
    //   2030: aload 4
    //   2032: arraylength
    //   2033: if_icmpge +28 -> 2061
    //   2036: aload 18
    //   2038: aload 4
    //   2040: iload 6
    //   2042: iaload
    //   2043: invokestatic 318	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2046: invokeinterface 1170 2 0
    //   2051: pop
    //   2052: iload 6
    //   2054: iconst_1
    //   2055: iadd
    //   2056: istore 6
    //   2058: goto -30 -> 2028
    //   2061: aconst_null
    //   2062: astore 4
    //   2064: iconst_0
    //   2065: istore 10
    //   2067: iconst_0
    //   2068: istore 6
    //   2070: iload 6
    //   2072: iload 9
    //   2074: if_icmpge +7944 -> 10018
    //   2077: aload_1
    //   2078: getfield 2483	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:config_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   2081: iload 6
    //   2083: invokevirtual 330	com/tencent/mobileqq/pb/PBRepeatMessageField:get	(I)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   2086: checkcast 51	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config
    //   2089: astore 19
    //   2091: aload 19
    //   2093: ifnonnull +28 -> 2121
    //   2096: iload 10
    //   2098: istore 11
    //   2100: aload 4
    //   2102: astore 16
    //   2104: iload 6
    //   2106: iconst_1
    //   2107: iadd
    //   2108: istore 6
    //   2110: aload 16
    //   2112: astore 4
    //   2114: iload 11
    //   2116: istore 10
    //   2118: goto -48 -> 2070
    //   2121: aload 4
    //   2123: astore 16
    //   2125: iload 10
    //   2127: istore 11
    //   2129: aload 19
    //   2131: getfield 2669	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:type	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   2134: invokevirtual 2670	com/tencent/mobileqq/pb/PBInt32Field:has	()Z
    //   2137: ifeq -33 -> 2104
    //   2140: new 139	java/lang/Integer
    //   2143: dup
    //   2144: aload 19
    //   2146: getfield 2669	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:type	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   2149: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   2152: invokespecial 2671	java/lang/Integer:<init>	(I)V
    //   2155: astore 16
    //   2157: aload 18
    //   2159: aload 16
    //   2161: invokeinterface 2673 2 0
    //   2166: pop
    //   2167: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2170: ifeq +41 -> 2211
    //   2173: ldc 189
    //   2175: iconst_2
    //   2176: new 85	java/lang/StringBuilder
    //   2179: dup
    //   2180: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   2183: ldc_w 2675
    //   2186: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2189: aload 16
    //   2191: invokevirtual 825	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2194: ldc_w 2677
    //   2197: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2200: iload 9
    //   2202: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2205: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2208: invokestatic 206	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   2211: aload 16
    //   2213: invokevirtual 1895	java/lang/Integer:intValue	()I
    //   2216: lookupswitch	default:+9549->11765, 1:+2902->5118, 2:+3306->5522, 3:+3796->6012, 5:+4034->6250, 6:+6264->8480, 10:+4888->7104, 12:+4259->6475, 13:+5163->7379, 23:+5553->7769, 31:+5229->7445, 34:+5211->7427, 38:+5662->7878, 42:+6084->8300, 43:+6246->8462, 44:+2476->4692, 46:+6102->8318, 47:+2665->4881, 49:+6093->8309, 50:+6111->8327, 53:+5563->7779, 55:+4576->6792, 56:+6120->8336, 61:+6129->8345, 63:+6147->8363, 64:+6156->8372, 65:+2855->5071, 66:+6165->8381, 69:+6192->8408, 72:+6174->8390, 73:+6183->8399, 74:+6201->8417, 75:+6210->8426, 78:+5573->7789, 79:+6295->8511, 80:+6277->8493, 82:+6304->8520, 84:+5583->7799, 86:+6522->8738, 87:+6541->8757, 88:+6551->8767, 90:+6313->8529, 93:+5873->8089, 94:+5379->7595, 96:+6592->8808, 97:+6602->8818, 101:+5181->7397, 102:+5220->7436, 109:+6639->8855, 111:+6286->8502, 113:+6255->8471, 115:+5191->7407, 116:+1837->4053, 118:+6658->8874, 119:+6708->8924, 121:+6718->8934, 129:+6688->8904, 130:+6738->8954, 139:+5614->7830, 140:+6766->8982, 142:+6668->8884, 143:+6698->8914, 145:+6806->9022, 146:+6629->8845, 147:+6512->8728, 148:+6138->8354, 149:+6612->8828, 153:+6796->9012, 155:+6816->9032, 156:+9647->11863, 157:+6728->8944, 165:+6836->9052, 166:+6846->9062, 167:+5604->7820, 171:+6868->9084, 174:+6918->9134, 177:+6967->9183, 180:+6612->8828, 181:+6888->9104, 182:+6947->9163, 184:+6878->9094, 185:+7017->9233, 187:+6977->9193, 188:+6561->8777, 190:+7133->9349, 191:+7007->9223, 193:+1431->3647, 194:+6826->9042, 195:+6987->9203, 199:+7036->9252, 201:+6678->8894, 202:+7123->9339, 204:+7358->9574, 205:+6581->8797, 206:+6571->8787, 210:+7143->9359, 211:+6756->8972, 212:+7153->9369, 215:+7190->9406, 218:+6612->8828, 222:+7210->9426, 223:+5642->7858, 225:+7078->9294, 226:+5593->7809, 227:+6997->9213, 228:+6228->8444, 232:+6748->8964, 234:+7238->9454, 235:+7248->9464, 238:+7258->9474, 244:+7268->9484, 245:+7278->9494, 247:+6898->9114, 253:+7288->9504, 254:+7308->9524, 256:+6237->8453, 257:+6776->8992, 259:+7318->9534, 260:+6786->9002, 262:+7328->9544, 267:+7368->9584, 268:+7338->9554, 269:+7348->9564, 272:+6908->9124, 273:+6928->9144, 274:+7378->9594, 279:+7387->9603, 280:+7485->9701, 281:+7505->9721, 283:+7515->9731, 284:+7525->9741, 286:+5201->7417, 289:+7552->9768, 295:+7298->9514, 297:+7562->9778, 301:+7535->9751, 308:+7409->9625, 312:+7443->9659, 313:+7431->9647, 314:+7591->9807, 320:+7611->9827, 321:+7027->9243, 328:+6937->9153, 329:+5623->7839, 331:+7633->9849, 336:+7643->9859, 337:+7576->9792, 345:+7652->9868, 347:+7601->9817, 349:+7666->9882, 351:+5632->7848, 360:+7495->9711, 364:+5642->7858, 365:+5642->7858, 371:+6957->9173, 384:+7703->9919, 385:+6219->8435, 386:+7722->9938, 387:+7712->9928, 392:+7740->9956, 393:+7749->9965, 394:+7767->9983, 397:+7461->9677, 400:+7688->9904, 403:+7162->9378, 404:+7181->9397, 410:+7777->9993, 596:+7792->10008, 604:+7171->9387
    //   3573: istore 7
    //   3575: invokestatic 1334	aqxe:a	()Laqxe;
    //   3578: aload 16
    //   3580: invokevirtual 1895	java/lang/Integer:intValue	()I
    //   3583: invokevirtual 1337	aqxe:b	(I)Z
    //   3586: ifeq +38 -> 3624
    //   3589: invokestatic 1334	aqxe:a	()Laqxe;
    //   3592: astore 17
    //   3594: aload 19
    //   3596: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   3599: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   3602: istore 7
    //   3604: aload 17
    //   3606: aload 16
    //   3608: invokevirtual 1895	java/lang/Integer:intValue	()I
    //   3611: iload 7
    //   3613: aload 19
    //   3615: getstatic 15	arph:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   3618: invokevirtual 2680	aqxe:a	(IILcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;Ljava/lang/String;)V
    //   3621: iconst_1
    //   3622: istore 7
    //   3624: iload 7
    //   3626: ifne +8142 -> 11768
    //   3629: aload_2
    //   3630: invokevirtual 1371	com/tencent/mobileqq/app/QQAppInterface:getConfigProcess	()Laqwg;
    //   3633: aload_2
    //   3634: aload 19
    //   3636: aload 16
    //   3638: invokevirtual 1895	java/lang/Integer:intValue	()I
    //   3641: invokevirtual 2682	aqwg:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;I)V
    //   3644: goto +8124 -> 11768
    //   3647: aload 19
    //   3649: getfield 234	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   3652: ifnull +8116 -> 11768
    //   3655: aload 19
    //   3657: getfield 234	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   3660: invokevirtual 237	com/tencent/mobileqq/pb/PBRepeatMessageField:size	()I
    //   3663: ifle +8105 -> 11768
    //   3666: aload 19
    //   3668: getfield 234	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   3671: iconst_0
    //   3672: invokevirtual 330	com/tencent/mobileqq/pb/PBRepeatMessageField:get	(I)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   3675: checkcast 257	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content
    //   3678: astore 16
    //   3680: aload 16
    //   3682: ifnull +344 -> 4026
    //   3685: aload 16
    //   3687: getfield 261	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content:compress	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   3690: invokevirtual 264	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   3693: iconst_1
    //   3694: if_icmpne +232 -> 3926
    //   3697: aload 16
    //   3699: getfield 268	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content:content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   3702: invokevirtual 273	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   3705: invokevirtual 279	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   3708: invokestatic 333	ayym:a	([B)[B
    //   3711: astore 17
    //   3713: aload 17
    //   3715: ifnull +8044 -> 11759
    //   3718: new 118	java/lang/String
    //   3721: dup
    //   3722: aload 17
    //   3724: ldc_w 335
    //   3727: invokespecial 338	java/lang/String:<init>	([BLjava/lang/String;)V
    //   3730: astore 16
    //   3732: aload 16
    //   3734: ifnull +8018 -> 11752
    //   3737: aload 19
    //   3739: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   3742: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   3745: istore 7
    //   3747: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3750: ifeq +42 -> 3792
    //   3753: ldc_w 1850
    //   3756: iconst_2
    //   3757: new 85	java/lang/StringBuilder
    //   3760: dup
    //   3761: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   3764: ldc_w 2684
    //   3767: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3770: iload 7
    //   3772: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3775: ldc_w 2686
    //   3778: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3781: aload 16
    //   3783: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3786: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3789: invokestatic 206	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   3792: aload 16
    //   3794: invokestatic 2691	com/tencent/mobileqq/upgrade/UpgradeTIMWrapper:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/upgrade/UpgradeTIMWrapper;
    //   3797: astore 17
    //   3799: aload 17
    //   3801: astore 4
    //   3803: aload_0
    //   3804: invokevirtual 47	arph:getAppRuntime	()Lmqq/app/AppRuntime;
    //   3807: invokevirtual 2692	mqq/app/AppRuntime:getApplication	()Lmqq/app/MobileQQ;
    //   3810: getstatic 15	arph:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   3813: iload 7
    //   3815: invokestatic 2694	bhhr:q	(Landroid/content/Context;Ljava/lang/String;I)V
    //   3818: aload_2
    //   3819: invokevirtual 65	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   3822: ldc_w 2696
    //   3825: invokestatic 2699	bhfn:a	(Landroid/content/Context;Ljava/lang/String;)Z
    //   3828: ifne +114 -> 3942
    //   3831: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3834: ifeq +13 -> 3847
    //   3837: ldc_w 1850
    //   3840: iconst_2
    //   3841: ldc_w 2701
    //   3844: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3847: aload 16
    //   3849: invokestatic 2702	com/tencent/mobileqq/upgrade/UpgradeTIMWrapper:a	(Ljava/lang/String;)V
    //   3852: aload_2
    //   3853: aload 4
    //   3855: invokestatic 2705	com/tencent/mobileqq/upgrade/UpgradeTIMWrapper:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/upgrade/UpgradeTIMWrapper;)V
    //   3858: aload 4
    //   3860: astore 16
    //   3862: aload 16
    //   3864: astore 4
    //   3866: goto +7902 -> 11768
    //   3869: astore 16
    //   3871: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3874: ifeq +7905 -> 11779
    //   3877: aload 16
    //   3879: invokevirtual 2706	java/io/UnsupportedEncodingException:printStackTrace	()V
    //   3882: goto +7897 -> 11779
    //   3885: astore 16
    //   3887: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3890: ifeq +8 -> 3898
    //   3893: aload 16
    //   3895: invokevirtual 2707	java/lang/OutOfMemoryError:printStackTrace	()V
    //   3898: invokestatic 2710	java/lang/System:gc	()V
    //   3901: new 118	java/lang/String
    //   3904: dup
    //   3905: aload 17
    //   3907: ldc_w 335
    //   3910: invokespecial 338	java/lang/String:<init>	([BLjava/lang/String;)V
    //   3913: astore 16
    //   3915: goto -183 -> 3732
    //   3918: astore 16
    //   3920: aconst_null
    //   3921: astore 16
    //   3923: goto -191 -> 3732
    //   3926: aload 16
    //   3928: getfield 268	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content:content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   3931: invokevirtual 273	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   3934: invokevirtual 293	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   3937: astore 16
    //   3939: goto -207 -> 3732
    //   3942: aload 4
    //   3944: astore 16
    //   3946: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3949: ifeq -87 -> 3862
    //   3952: ldc_w 1850
    //   3955: iconst_2
    //   3956: ldc_w 2712
    //   3959: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3962: aload 4
    //   3964: astore 16
    //   3966: goto -104 -> 3862
    //   3969: astore 17
    //   3971: aload 4
    //   3973: astore 16
    //   3975: iload 10
    //   3977: istore 11
    //   3979: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3982: ifeq -1878 -> 2104
    //   3985: ldc 189
    //   3987: iconst_2
    //   3988: new 85	java/lang/StringBuilder
    //   3991: dup
    //   3992: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   3995: ldc_w 2714
    //   3998: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4001: aload 17
    //   4003: invokevirtual 2373	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   4006: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4009: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4012: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4015: aload 4
    //   4017: astore 16
    //   4019: iload 10
    //   4021: istore 11
    //   4023: goto -1919 -> 2104
    //   4026: aload 4
    //   4028: astore 16
    //   4030: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4033: ifeq -171 -> 3862
    //   4036: ldc_w 1850
    //   4039: iconst_2
    //   4040: ldc_w 2716
    //   4043: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4046: aload 4
    //   4048: astore 16
    //   4050: goto -188 -> 3862
    //   4053: aload_0
    //   4054: invokevirtual 47	arph:getAppRuntime	()Lmqq/app/AppRuntime;
    //   4057: invokevirtual 2692	mqq/app/AppRuntime:getApplication	()Lmqq/app/MobileQQ;
    //   4060: getstatic 15	arph:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   4063: invokestatic 1828	bhhr:I	(Landroid/content/Context;Ljava/lang/String;)I
    //   4066: istore 7
    //   4068: aload 19
    //   4070: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   4073: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   4076: istore 8
    //   4078: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4081: ifeq +35 -> 4116
    //   4084: ldc 189
    //   4086: iconst_2
    //   4087: ldc_w 2718
    //   4090: iconst_2
    //   4091: anewarray 314	java/lang/Object
    //   4094: dup
    //   4095: iconst_0
    //   4096: iload 7
    //   4098: invokestatic 318	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   4101: aastore
    //   4102: dup
    //   4103: iconst_1
    //   4104: iload 8
    //   4106: invokestatic 318	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   4109: aastore
    //   4110: invokestatic 322	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   4113: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4116: aconst_null
    //   4117: astore 17
    //   4119: iload 7
    //   4121: iload 8
    //   4123: if_icmpeq +388 -> 4511
    //   4126: aload 19
    //   4128: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   4131: ifnull +14 -> 4145
    //   4134: aload 19
    //   4136: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   4139: invokevirtual 2719	com/tencent/mobileqq/pb/PBRepeatField:isEmpty	()Z
    //   4142: ifeq +287 -> 4429
    //   4145: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4148: ifeq +12 -> 4160
    //   4151: ldc 189
    //   4153: iconst_2
    //   4154: ldc_w 2721
    //   4157: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4160: ldc_w 2723
    //   4163: getstatic 15	arph:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   4166: invokestatic 2728	bgvv:a	(Ljava/lang/String;Ljava/lang/String;)Z
    //   4169: pop
    //   4170: aconst_null
    //   4171: astore 16
    //   4173: aload_0
    //   4174: invokevirtual 47	arph:getAppRuntime	()Lmqq/app/AppRuntime;
    //   4177: invokevirtual 2692	mqq/app/AppRuntime:getApplication	()Lmqq/app/MobileQQ;
    //   4180: getstatic 15	arph:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   4183: iload 8
    //   4185: invokestatic 2730	bhhr:p	(Landroid/content/Context;Ljava/lang/String;I)V
    //   4188: aload_2
    //   4189: getstatic 1843	com/tencent/mobileqq/app/BusinessHandlerFactory:CONFIG_HANDLER	I
    //   4192: invokevirtual 219	com/tencent/mobileqq/app/QQAppInterface:getBusinessHandler	(I)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   4195: checkcast 1845	ansg
    //   4198: astore 19
    //   4200: aload 16
    //   4202: invokestatic 126	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4205: ifne +468 -> 4673
    //   4208: invokestatic 2518	bgvx:a	()Lbgvx;
    //   4211: invokevirtual 2521	bgvx:a	()Lcom/tencent/mobileqq/upgrade/UpgradeDetailWrapper;
    //   4214: astore 17
    //   4216: aload 17
    //   4218: aload 16
    //   4220: invokevirtual 2733	com/tencent/mobileqq/upgrade/UpgradeDetailWrapper:a	(Ljava/lang/String;)V
    //   4223: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4226: ifeq +42 -> 4268
    //   4229: ldc 189
    //   4231: iconst_2
    //   4232: ldc_w 2735
    //   4235: iconst_2
    //   4236: anewarray 314	java/lang/Object
    //   4239: dup
    //   4240: iconst_0
    //   4241: invokestatic 210	com/tencent/common/config/AppSetting:a	()I
    //   4244: invokestatic 318	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   4247: aastore
    //   4248: dup
    //   4249: iconst_1
    //   4250: aload 17
    //   4252: getfield 2738	com/tencent/mobileqq/upgrade/UpgradeDetailWrapper:jdField_b_of_type_ProtocolKQQConfigUpgradeInfo	Lprotocol/KQQConfig/UpgradeInfo;
    //   4255: getfield 2743	protocol/KQQConfig/UpgradeInfo:iUpgradeSdkId	I
    //   4258: invokestatic 318	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   4261: aastore
    //   4262: invokestatic 322	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   4265: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4268: aload_2
    //   4269: invokevirtual 65	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   4272: getstatic 15	arph:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   4275: invokestatic 2746	bhhr:aN	(Landroid/content/Context;Ljava/lang/String;)I
    //   4278: aload 17
    //   4280: getfield 2738	com/tencent/mobileqq/upgrade/UpgradeDetailWrapper:jdField_b_of_type_ProtocolKQQConfigUpgradeInfo	Lprotocol/KQQConfig/UpgradeInfo;
    //   4283: getfield 2743	protocol/KQQConfig/UpgradeInfo:iUpgradeSdkId	I
    //   4286: if_icmpeq +69 -> 4355
    //   4289: aload_2
    //   4290: invokevirtual 65	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   4293: aload_2
    //   4294: invokevirtual 1636	com/tencent/mobileqq/app/QQAppInterface:getCurrentUin	()Ljava/lang/String;
    //   4297: iconst_0
    //   4298: invokestatic 2748	bhhr:ae	(Landroid/content/Context;Ljava/lang/String;I)V
    //   4301: aload_2
    //   4302: invokevirtual 65	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   4305: aload_2
    //   4306: invokevirtual 1636	com/tencent/mobileqq/app/QQAppInterface:getCurrentUin	()Ljava/lang/String;
    //   4309: lconst_0
    //   4310: invokestatic 2751	bhhr:i	(Landroid/content/Context;Ljava/lang/String;J)V
    //   4313: aload_2
    //   4314: invokevirtual 65	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   4317: aload_2
    //   4318: invokevirtual 1636	com/tencent/mobileqq/app/QQAppInterface:getCurrentUin	()Ljava/lang/String;
    //   4321: iconst_0
    //   4322: invokestatic 2754	bhhr:af	(Landroid/content/Context;Ljava/lang/String;I)V
    //   4325: aload_2
    //   4326: invokevirtual 65	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   4329: aload_2
    //   4330: invokevirtual 1636	com/tencent/mobileqq/app/QQAppInterface:getCurrentUin	()Ljava/lang/String;
    //   4333: lconst_0
    //   4334: invokestatic 2756	bhhr:j	(Landroid/content/Context;Ljava/lang/String;J)V
    //   4337: aload_2
    //   4338: invokevirtual 65	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   4341: getstatic 15	arph:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   4344: aload 17
    //   4346: getfield 2738	com/tencent/mobileqq/upgrade/UpgradeDetailWrapper:jdField_b_of_type_ProtocolKQQConfigUpgradeInfo	Lprotocol/KQQConfig/UpgradeInfo;
    //   4349: getfield 2743	protocol/KQQConfig/UpgradeInfo:iUpgradeSdkId	I
    //   4352: invokestatic 2758	bhhr:ad	(Landroid/content/Context;Ljava/lang/String;I)V
    //   4355: invokestatic 210	com/tencent/common/config/AppSetting:a	()I
    //   4358: aload 17
    //   4360: getfield 2738	com/tencent/mobileqq/upgrade/UpgradeDetailWrapper:jdField_b_of_type_ProtocolKQQConfigUpgradeInfo	Lprotocol/KQQConfig/UpgradeInfo;
    //   4363: getfield 2743	protocol/KQQConfig/UpgradeInfo:iUpgradeSdkId	I
    //   4366: if_icmplt +171 -> 4537
    //   4369: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4372: ifeq +12 -> 4384
    //   4375: ldc 189
    //   4377: iconst_2
    //   4378: ldc_w 2760
    //   4381: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4384: aload_2
    //   4385: invokevirtual 65	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   4388: getstatic 15	arph:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   4391: iconst_0
    //   4392: invokestatic 2730	bhhr:p	(Landroid/content/Context;Ljava/lang/String;I)V
    //   4395: ldc_w 2723
    //   4398: getstatic 15	arph:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   4401: invokestatic 2728	bgvv:a	(Ljava/lang/String;Ljava/lang/String;)Z
    //   4404: pop
    //   4405: aload 17
    //   4407: getfield 2738	com/tencent/mobileqq/upgrade/UpgradeDetailWrapper:jdField_b_of_type_ProtocolKQQConfigUpgradeInfo	Lprotocol/KQQConfig/UpgradeInfo;
    //   4410: iconst_0
    //   4411: putfield 2763	protocol/KQQConfig/UpgradeInfo:iUpgradeType	I
    //   4414: aload 19
    //   4416: aload 17
    //   4418: invokevirtual 2524	ansg:a	(Lcom/tencent/mobileqq/upgrade/UpgradeDetailWrapper;)V
    //   4421: aload 19
    //   4423: invokevirtual 2765	ansg:d	()V
    //   4426: goto +7342 -> 11768
    //   4429: aload 19
    //   4431: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   4434: iconst_0
    //   4435: invokevirtual 116	com/tencent/mobileqq/pb/PBRepeatField:get	(I)Ljava/lang/Object;
    //   4438: checkcast 118	java/lang/String
    //   4441: astore 16
    //   4443: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4446: ifeq +30 -> 4476
    //   4449: ldc 189
    //   4451: iconst_2
    //   4452: new 85	java/lang/StringBuilder
    //   4455: dup
    //   4456: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   4459: ldc_w 2767
    //   4462: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4465: aload 16
    //   4467: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4470: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4473: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4476: aload 16
    //   4478: invokestatic 126	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4481: ifeq +16 -> 4497
    //   4484: ldc_w 2723
    //   4487: getstatic 15	arph:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   4490: invokestatic 2728	bgvv:a	(Ljava/lang/String;Ljava/lang/String;)Z
    //   4493: pop
    //   4494: goto -321 -> 4173
    //   4497: ldc_w 2723
    //   4500: getstatic 15	arph:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   4503: aload 16
    //   4505: invokestatic 2770	bgvv:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   4508: goto -335 -> 4173
    //   4511: aload 17
    //   4513: astore 16
    //   4515: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4518: ifeq -330 -> 4188
    //   4521: ldc 189
    //   4523: iconst_2
    //   4524: ldc_w 2772
    //   4527: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4530: aload 17
    //   4532: astore 16
    //   4534: goto -346 -> 4188
    //   4537: aload_0
    //   4538: invokevirtual 47	arph:getAppRuntime	()Lmqq/app/AppRuntime;
    //   4541: invokevirtual 2692	mqq/app/AppRuntime:getApplication	()Lmqq/app/MobileQQ;
    //   4544: getstatic 15	arph:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   4547: invokestatic 2668	java/lang/System:currentTimeMillis	()J
    //   4550: invokestatic 2774	bhhr:a	(Landroid/content/Context;Ljava/lang/String;J)V
    //   4553: aload 17
    //   4555: monitorenter
    //   4556: aload 17
    //   4558: getfield 2775	com/tencent/mobileqq/upgrade/UpgradeDetailWrapper:jdField_a_of_type_Boolean	Z
    //   4561: ifne +27 -> 4588
    //   4564: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4567: ifeq +12 -> 4579
    //   4570: ldc 189
    //   4572: iconst_2
    //   4573: ldc_w 2777
    //   4576: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4579: aload 17
    //   4581: monitorexit
    //   4582: iconst_1
    //   4583: istore 10
    //   4585: goto +7183 -> 11768
    //   4588: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4591: ifeq +12 -> 4603
    //   4594: ldc 189
    //   4596: iconst_2
    //   4597: ldc_w 2779
    //   4600: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4603: aload 17
    //   4605: getfield 2781	com/tencent/mobileqq/upgrade/UpgradeDetailWrapper:jdField_b_of_type_Int	I
    //   4608: ifne +21 -> 4629
    //   4611: aload 17
    //   4613: getfield 2782	com/tencent/mobileqq/upgrade/UpgradeDetailWrapper:jdField_a_of_type_Int	I
    //   4616: iconst_1
    //   4617: if_icmpne +7173 -> 11790
    //   4620: iconst_1
    //   4621: istore 10
    //   4623: aload_2
    //   4624: iload 10
    //   4626: invokestatic 2783	ansg:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Z)V
    //   4629: aload 19
    //   4631: invokevirtual 2765	ansg:d	()V
    //   4634: invokestatic 2518	bgvx:a	()Lbgvx;
    //   4637: aload 17
    //   4639: getfield 2738	com/tencent/mobileqq/upgrade/UpgradeDetailWrapper:jdField_b_of_type_ProtocolKQQConfigUpgradeInfo	Lprotocol/KQQConfig/UpgradeInfo;
    //   4642: aload 19
    //   4644: invokevirtual 2786	bgvx:a	(Lprotocol/KQQConfig/UpgradeInfo;Lbgvz;)Z
    //   4647: pop
    //   4648: aload 17
    //   4650: monitorexit
    //   4651: iconst_1
    //   4652: istore 10
    //   4654: goto +7114 -> 11768
    //   4657: astore 16
    //   4659: aload 17
    //   4661: monitorexit
    //   4662: aload 16
    //   4664: athrow
    //   4665: astore 17
    //   4667: iconst_1
    //   4668: istore 10
    //   4670: goto -699 -> 3971
    //   4673: aload 19
    //   4675: invokevirtual 2765	ansg:d	()V
    //   4678: aload 19
    //   4680: invokestatic 2518	bgvx:a	()Lbgvx;
    //   4683: invokevirtual 2521	bgvx:a	()Lcom/tencent/mobileqq/upgrade/UpgradeDetailWrapper;
    //   4686: invokevirtual 2524	ansg:a	(Lcom/tencent/mobileqq/upgrade/UpgradeDetailWrapper;)V
    //   4689: goto +7079 -> 11768
    //   4692: aload 19
    //   4694: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   4697: ifnull +142 -> 4839
    //   4700: aload 19
    //   4702: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   4705: invokevirtual 113	com/tencent/mobileqq/pb/PBRepeatField:size	()I
    //   4708: ifle +131 -> 4839
    //   4711: aload_0
    //   4712: invokevirtual 47	arph:getAppRuntime	()Lmqq/app/AppRuntime;
    //   4715: invokevirtual 2692	mqq/app/AppRuntime:getApplication	()Lmqq/app/MobileQQ;
    //   4718: aload 19
    //   4720: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   4723: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   4726: getstatic 15	arph:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   4729: invokestatic 2788	bhhr:f	(Landroid/content/Context;ILjava/lang/String;)V
    //   4732: iconst_0
    //   4733: istore 7
    //   4735: iload 7
    //   4737: aload 19
    //   4739: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   4742: invokevirtual 113	com/tencent/mobileqq/pb/PBRepeatField:size	()I
    //   4745: if_icmpge +7060 -> 11805
    //   4748: aload 19
    //   4750: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   4753: iload 7
    //   4755: invokevirtual 116	com/tencent/mobileqq/pb/PBRepeatField:get	(I)Ljava/lang/Object;
    //   4758: checkcast 118	java/lang/String
    //   4761: astore 16
    //   4763: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4766: ifeq +47 -> 4813
    //   4769: ldc 189
    //   4771: iconst_2
    //   4772: new 85	java/lang/StringBuilder
    //   4775: dup
    //   4776: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   4779: ldc_w 2790
    //   4782: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4785: aload 16
    //   4787: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4790: ldc_w 620
    //   4793: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4796: aload 19
    //   4798: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   4801: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   4804: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4807: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4810: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4813: aload 16
    //   4815: invokestatic 126	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4818: ifne +6978 -> 11796
    //   4821: aload_2
    //   4822: getstatic 2793	com/tencent/mobileqq/app/QQManagerFactory:HOT_CHAT_MANAGER	I
    //   4825: invokevirtual 166	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   4828: checkcast 2795	com/tencent/mobileqq/app/HotChatManager
    //   4831: aload 16
    //   4833: invokevirtual 2797	com/tencent/mobileqq/app/HotChatManager:d	(Ljava/lang/String;)V
    //   4836: goto +6960 -> 11796
    //   4839: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4842: ifeq +6926 -> 11768
    //   4845: ldc 189
    //   4847: iconst_2
    //   4848: new 85	java/lang/StringBuilder
    //   4851: dup
    //   4852: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   4855: ldc_w 2799
    //   4858: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4861: aload 19
    //   4863: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   4866: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   4869: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4872: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4875: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4878: goto +6890 -> 11768
    //   4881: aload 19
    //   4883: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   4886: ifnull +143 -> 5029
    //   4889: aload 19
    //   4891: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   4894: invokevirtual 113	com/tencent/mobileqq/pb/PBRepeatField:size	()I
    //   4897: ifle +132 -> 5029
    //   4900: aload_0
    //   4901: invokevirtual 47	arph:getAppRuntime	()Lmqq/app/AppRuntime;
    //   4904: invokevirtual 2692	mqq/app/AppRuntime:getApplication	()Lmqq/app/MobileQQ;
    //   4907: aload 19
    //   4909: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   4912: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   4915: getstatic 15	arph:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   4918: invokestatic 2801	bhhr:d	(Landroid/content/Context;ILjava/lang/String;)V
    //   4921: iconst_0
    //   4922: istore 7
    //   4924: iload 7
    //   4926: aload 19
    //   4928: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   4931: invokevirtual 113	com/tencent/mobileqq/pb/PBRepeatField:size	()I
    //   4934: if_icmpge +6883 -> 11817
    //   4937: aload 19
    //   4939: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   4942: iload 7
    //   4944: invokevirtual 116	com/tencent/mobileqq/pb/PBRepeatField:get	(I)Ljava/lang/Object;
    //   4947: checkcast 118	java/lang/String
    //   4950: astore 16
    //   4952: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4955: ifeq +47 -> 5002
    //   4958: ldc 189
    //   4960: iconst_2
    //   4961: new 85	java/lang/StringBuilder
    //   4964: dup
    //   4965: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   4968: ldc_w 2803
    //   4971: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4974: aload 16
    //   4976: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4979: ldc_w 620
    //   4982: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4985: aload 19
    //   4987: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   4990: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   4993: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4996: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4999: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   5002: aload 16
    //   5004: invokestatic 126	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   5007: ifne +6801 -> 11808
    //   5010: aload_2
    //   5011: getstatic 2806	com/tencent/mobileqq/app/BusinessHandlerFactory:DEVICEPROXYMGR_HANDLER	I
    //   5014: invokevirtual 219	com/tencent/mobileqq/app/QQAppInterface:getBusinessHandler	(I)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   5017: checkcast 2808	abgm
    //   5020: aload 16
    //   5022: iconst_0
    //   5023: invokevirtual 2811	abgm:a	(Ljava/lang/String;Z)V
    //   5026: goto +6782 -> 11808
    //   5029: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5032: ifeq +6736 -> 11768
    //   5035: ldc 189
    //   5037: iconst_2
    //   5038: new 85	java/lang/StringBuilder
    //   5041: dup
    //   5042: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   5045: ldc_w 2813
    //   5048: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5051: aload 19
    //   5053: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   5056: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   5059: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5062: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5065: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   5068: goto +6700 -> 11768
    //   5071: aload 19
    //   5073: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   5076: ifnull +6692 -> 11768
    //   5079: aload_0
    //   5080: invokevirtual 47	arph:getAppRuntime	()Lmqq/app/AppRuntime;
    //   5083: invokevirtual 2692	mqq/app/AppRuntime:getApplication	()Lmqq/app/MobileQQ;
    //   5086: aload 19
    //   5088: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   5091: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   5094: getstatic 15	arph:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   5097: invokestatic 2815	bhhr:e	(Landroid/content/Context;ILjava/lang/String;)V
    //   5100: aload_2
    //   5101: getstatic 2806	com/tencent/mobileqq/app/BusinessHandlerFactory:DEVICEPROXYMGR_HANDLER	I
    //   5104: invokevirtual 219	com/tencent/mobileqq/app/QQAppInterface:getBusinessHandler	(I)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   5107: checkcast 2808	abgm
    //   5110: aload 19
    //   5112: invokevirtual 2817	abgm:a	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   5115: goto +6653 -> 11768
    //   5118: aload 19
    //   5120: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   5123: ifnull +276 -> 5399
    //   5126: aload 19
    //   5128: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   5131: invokevirtual 113	com/tencent/mobileqq/pb/PBRepeatField:size	()I
    //   5134: ifle +265 -> 5399
    //   5137: new 2819	java/io/File
    //   5140: dup
    //   5141: new 85	java/lang/StringBuilder
    //   5144: dup
    //   5145: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   5148: aload_0
    //   5149: invokevirtual 47	arph:getAppRuntime	()Lmqq/app/AppRuntime;
    //   5152: invokevirtual 2692	mqq/app/AppRuntime:getApplication	()Lmqq/app/MobileQQ;
    //   5155: invokevirtual 2825	mqq/app/MobileQQ:getFilesDir	()Ljava/io/File;
    //   5158: invokevirtual 2828	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   5161: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5164: ldc_w 2830
    //   5167: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5170: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5173: invokespecial 2831	java/io/File:<init>	(Ljava/lang/String;)V
    //   5176: astore 16
    //   5178: aload 16
    //   5180: invokevirtual 2834	java/io/File:exists	()Z
    //   5183: ifne +152 -> 5335
    //   5186: aload 16
    //   5188: invokevirtual 2837	java/io/File:mkdirs	()Z
    //   5191: pop
    //   5192: aload 19
    //   5194: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   5197: invokevirtual 1182	com/tencent/mobileqq/pb/PBRepeatField:get	()Ljava/util/List;
    //   5200: invokeinterface 246 1 0
    //   5205: astore 16
    //   5207: aload 16
    //   5209: invokeinterface 251 1 0
    //   5214: ifeq +6615 -> 11829
    //   5217: aload 16
    //   5219: invokeinterface 255 1 0
    //   5224: checkcast 118	java/lang/String
    //   5227: astore 17
    //   5229: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5232: ifeq +47 -> 5279
    //   5235: ldc 189
    //   5237: iconst_2
    //   5238: new 85	java/lang/StringBuilder
    //   5241: dup
    //   5242: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   5245: ldc_w 2839
    //   5248: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5251: aload 17
    //   5253: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5256: ldc_w 620
    //   5259: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5262: aload 19
    //   5264: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   5267: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   5270: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5273: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5276: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   5279: aload_0
    //   5280: aload 17
    //   5282: aload 19
    //   5284: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   5287: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   5290: invokespecial 2842	arph:e	(Ljava/lang/String;I)V
    //   5293: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5296: ifeq -89 -> 5207
    //   5299: ldc 189
    //   5301: iconst_2
    //   5302: new 85	java/lang/StringBuilder
    //   5305: dup
    //   5306: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   5309: ldc_w 2844
    //   5312: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5315: aload 19
    //   5317: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   5320: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   5323: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5326: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5329: invokestatic 206	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   5332: goto -125 -> 5207
    //   5335: aload 16
    //   5337: ifnull -145 -> 5192
    //   5340: aload 16
    //   5342: invokevirtual 2847	java/io/File:isDirectory	()Z
    //   5345: ifeq -153 -> 5192
    //   5348: aload 16
    //   5350: invokevirtual 2851	java/io/File:listFiles	()[Ljava/io/File;
    //   5353: astore 16
    //   5355: aload 16
    //   5357: arraylength
    //   5358: istore 8
    //   5360: iconst_0
    //   5361: istore 7
    //   5363: iload 7
    //   5365: iload 8
    //   5367: if_icmpge -175 -> 5192
    //   5370: aload 16
    //   5372: iload 7
    //   5374: aaload
    //   5375: astore 17
    //   5377: aload 17
    //   5379: ifnull +6441 -> 11820
    //   5382: aload 17
    //   5384: invokevirtual 2834	java/io/File:exists	()Z
    //   5387: ifeq +6433 -> 11820
    //   5390: aload 17
    //   5392: invokevirtual 2854	java/io/File:delete	()Z
    //   5395: pop
    //   5396: goto +6424 -> 11820
    //   5399: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5402: ifeq +36 -> 5438
    //   5405: ldc 189
    //   5407: iconst_2
    //   5408: new 85	java/lang/StringBuilder
    //   5411: dup
    //   5412: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   5415: ldc_w 2856
    //   5418: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5421: aload 19
    //   5423: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   5426: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   5429: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5432: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5435: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   5438: new 2819	java/io/File
    //   5441: dup
    //   5442: new 85	java/lang/StringBuilder
    //   5445: dup
    //   5446: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   5449: aload_0
    //   5450: invokevirtual 47	arph:getAppRuntime	()Lmqq/app/AppRuntime;
    //   5453: invokevirtual 2692	mqq/app/AppRuntime:getApplication	()Lmqq/app/MobileQQ;
    //   5456: invokevirtual 2825	mqq/app/MobileQQ:getFilesDir	()Ljava/io/File;
    //   5459: invokevirtual 2828	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   5462: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5465: ldc_w 2858
    //   5468: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5471: ldc_w 2860
    //   5474: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5477: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5480: invokespecial 2831	java/io/File:<init>	(Ljava/lang/String;)V
    //   5483: astore 16
    //   5485: aload 16
    //   5487: ifnull +9 -> 5496
    //   5490: aload 16
    //   5492: invokevirtual 2854	java/io/File:delete	()Z
    //   5495: pop
    //   5496: aload_0
    //   5497: invokevirtual 47	arph:getAppRuntime	()Lmqq/app/AppRuntime;
    //   5500: invokevirtual 2692	mqq/app/AppRuntime:getApplication	()Lmqq/app/MobileQQ;
    //   5503: aload 19
    //   5505: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   5508: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   5511: ldc_w 2862
    //   5514: ldc 13
    //   5516: invokestatic 2865	bhhr:a	(Landroid/content/Context;ILjava/lang/String;Ljava/lang/String;)V
    //   5519: goto +6249 -> 11768
    //   5522: aload 19
    //   5524: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   5527: ifnull +323 -> 5850
    //   5530: aload 19
    //   5532: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   5535: invokevirtual 113	com/tencent/mobileqq/pb/PBRepeatField:size	()I
    //   5538: ifle +312 -> 5850
    //   5541: getstatic 2870	aqwk:a	Larpt;
    //   5544: invokevirtual 2873	arpt:b	()V
    //   5547: aload 19
    //   5549: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   5552: invokevirtual 1182	com/tencent/mobileqq/pb/PBRepeatField:get	()Ljava/util/List;
    //   5555: invokeinterface 246 1 0
    //   5560: astore 16
    //   5562: aload 16
    //   5564: invokeinterface 251 1 0
    //   5569: ifeq +82 -> 5651
    //   5572: aload 16
    //   5574: invokeinterface 255 1 0
    //   5579: checkcast 118	java/lang/String
    //   5582: astore 17
    //   5584: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5587: ifeq +47 -> 5634
    //   5590: ldc 189
    //   5592: iconst_2
    //   5593: new 85	java/lang/StringBuilder
    //   5596: dup
    //   5597: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   5600: ldc_w 2875
    //   5603: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5606: aload 17
    //   5608: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5611: ldc_w 620
    //   5614: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5617: aload 19
    //   5619: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   5622: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   5625: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5628: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5631: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   5634: aload_0
    //   5635: aload 17
    //   5637: aload 19
    //   5639: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   5642: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   5645: invokespecial 2877	arph:c	(Ljava/lang/String;I)V
    //   5648: goto -86 -> 5562
    //   5651: new 2879	aqwm
    //   5654: dup
    //   5655: aload_0
    //   5656: invokevirtual 47	arph:getAppRuntime	()Lmqq/app/AppRuntime;
    //   5659: invokevirtual 2692	mqq/app/AppRuntime:getApplication	()Lmqq/app/MobileQQ;
    //   5662: getstatic 15	arph:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   5665: invokespecial 2881	aqwm:<init>	(Landroid/content/Context;Ljava/lang/String;)V
    //   5668: astore 16
    //   5670: aload 16
    //   5672: ifnull +13 -> 5685
    //   5675: aload 16
    //   5677: invokevirtual 2882	aqwm:b	()V
    //   5680: aload 16
    //   5682: invokevirtual 2883	aqwm:c	()V
    //   5685: invokestatic 397	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   5688: ldc_w 2885
    //   5691: iconst_0
    //   5692: invokevirtual 352	com/tencent/qphone/base/util/BaseApplication:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   5695: astore 16
    //   5697: aload 16
    //   5699: invokeinterface 358 1 0
    //   5704: new 85	java/lang/StringBuilder
    //   5707: dup
    //   5708: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   5711: ldc_w 2887
    //   5714: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5717: aload_0
    //   5718: invokevirtual 47	arph:getAppRuntime	()Lmqq/app/AppRuntime;
    //   5721: invokevirtual 2888	mqq/app/AppRuntime:getAccount	()Ljava/lang/String;
    //   5724: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5727: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5730: iconst_1
    //   5731: invokeinterface 366 3 0
    //   5736: invokeinterface 748 1 0
    //   5741: pop
    //   5742: aload 16
    //   5744: invokeinterface 358 1 0
    //   5749: new 85	java/lang/StringBuilder
    //   5752: dup
    //   5753: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   5756: ldc_w 2890
    //   5759: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5762: aload_0
    //   5763: invokevirtual 47	arph:getAppRuntime	()Lmqq/app/AppRuntime;
    //   5766: invokevirtual 2888	mqq/app/AppRuntime:getAccount	()Ljava/lang/String;
    //   5769: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5772: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5775: iconst_1
    //   5776: invokeinterface 366 3 0
    //   5781: invokeinterface 748 1 0
    //   5786: pop
    //   5787: aload_0
    //   5788: invokevirtual 47	arph:getAppRuntime	()Lmqq/app/AppRuntime;
    //   5791: invokevirtual 2692	mqq/app/AppRuntime:getApplication	()Lmqq/app/MobileQQ;
    //   5794: aload 19
    //   5796: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   5799: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   5802: getstatic 15	arph:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   5805: invokestatic 2788	bhhr:f	(Landroid/content/Context;ILjava/lang/String;)V
    //   5808: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5811: ifeq +6021 -> 11832
    //   5814: ldc 189
    //   5816: iconst_2
    //   5817: new 85	java/lang/StringBuilder
    //   5820: dup
    //   5821: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   5824: ldc_w 2892
    //   5827: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5830: aload 19
    //   5832: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   5835: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   5838: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5841: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5844: invokestatic 206	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   5847: goto +5985 -> 11832
    //   5850: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5853: ifeq +36 -> 5889
    //   5856: ldc 189
    //   5858: iconst_2
    //   5859: new 85	java/lang/StringBuilder
    //   5862: dup
    //   5863: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   5866: ldc_w 2894
    //   5869: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5872: aload 19
    //   5874: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   5877: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   5880: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5883: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5886: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   5889: getstatic 2870	aqwk:a	Larpt;
    //   5892: invokevirtual 2873	arpt:b	()V
    //   5895: getstatic 2870	aqwk:a	Larpt;
    //   5898: invokevirtual 2895	arpt:c	()V
    //   5901: new 2879	aqwm
    //   5904: dup
    //   5905: aload_0
    //   5906: invokevirtual 47	arph:getAppRuntime	()Lmqq/app/AppRuntime;
    //   5909: invokevirtual 2692	mqq/app/AppRuntime:getApplication	()Lmqq/app/MobileQQ;
    //   5912: getstatic 15	arph:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   5915: invokespecial 2881	aqwm:<init>	(Landroid/content/Context;Ljava/lang/String;)V
    //   5918: astore 16
    //   5920: aload 16
    //   5922: ifnull +13 -> 5935
    //   5925: aload 16
    //   5927: invokevirtual 2882	aqwm:b	()V
    //   5930: aload 16
    //   5932: invokevirtual 2883	aqwm:c	()V
    //   5935: invokestatic 397	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   5938: ldc_w 2885
    //   5941: iconst_0
    //   5942: invokevirtual 352	com/tencent/qphone/base/util/BaseApplication:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   5945: invokeinterface 358 1 0
    //   5950: new 85	java/lang/StringBuilder
    //   5953: dup
    //   5954: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   5957: ldc_w 2890
    //   5960: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5963: aload_0
    //   5964: invokevirtual 47	arph:getAppRuntime	()Lmqq/app/AppRuntime;
    //   5967: invokevirtual 2888	mqq/app/AppRuntime:getAccount	()Ljava/lang/String;
    //   5970: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5973: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5976: iconst_0
    //   5977: invokeinterface 366 3 0
    //   5982: invokeinterface 748 1 0
    //   5987: pop
    //   5988: aload_0
    //   5989: invokevirtual 47	arph:getAppRuntime	()Lmqq/app/AppRuntime;
    //   5992: invokevirtual 2692	mqq/app/AppRuntime:getApplication	()Lmqq/app/MobileQQ;
    //   5995: aload 19
    //   5997: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   6000: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   6003: getstatic 15	arph:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   6006: invokestatic 2788	bhhr:f	(Landroid/content/Context;ILjava/lang/String;)V
    //   6009: goto +5759 -> 11768
    //   6012: aload 19
    //   6014: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   6017: ifnull +95 -> 6112
    //   6020: aload 19
    //   6022: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   6025: invokevirtual 113	com/tencent/mobileqq/pb/PBRepeatField:size	()I
    //   6028: ifle +84 -> 6112
    //   6031: aload 19
    //   6033: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   6036: iconst_0
    //   6037: invokevirtual 116	com/tencent/mobileqq/pb/PBRepeatField:get	(I)Ljava/lang/Object;
    //   6040: checkcast 118	java/lang/String
    //   6043: astore 16
    //   6045: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6048: ifeq +47 -> 6095
    //   6051: ldc 189
    //   6053: iconst_2
    //   6054: new 85	java/lang/StringBuilder
    //   6057: dup
    //   6058: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   6061: ldc_w 2897
    //   6064: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6067: aload 16
    //   6069: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6072: ldc_w 620
    //   6075: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6078: aload 19
    //   6080: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   6083: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   6086: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6089: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6092: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   6095: aload_0
    //   6096: aload 16
    //   6098: aload 19
    //   6100: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   6103: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   6106: invokespecial 2899	arph:d	(Ljava/lang/String;I)V
    //   6109: goto +5659 -> 11768
    //   6112: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6115: ifeq +36 -> 6151
    //   6118: ldc 189
    //   6120: iconst_2
    //   6121: new 85	java/lang/StringBuilder
    //   6124: dup
    //   6125: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   6128: ldc_w 2901
    //   6131: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6134: aload 19
    //   6136: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   6139: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   6142: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6145: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6148: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   6151: new 2819	java/io/File
    //   6154: dup
    //   6155: new 85	java/lang/StringBuilder
    //   6158: dup
    //   6159: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   6162: aload_0
    //   6163: invokevirtual 47	arph:getAppRuntime	()Lmqq/app/AppRuntime;
    //   6166: invokevirtual 2692	mqq/app/AppRuntime:getApplication	()Lmqq/app/MobileQQ;
    //   6169: invokevirtual 2825	mqq/app/MobileQQ:getFilesDir	()Ljava/io/File;
    //   6172: invokevirtual 2828	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   6175: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6178: ldc_w 2858
    //   6181: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6184: getstatic 15	arph:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   6187: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6190: ldc_w 2858
    //   6193: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6196: ldc_w 2903
    //   6199: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6202: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6205: invokespecial 2831	java/io/File:<init>	(Ljava/lang/String;)V
    //   6208: astore 16
    //   6210: aload 16
    //   6212: invokevirtual 2834	java/io/File:exists	()Z
    //   6215: ifeq +9 -> 6224
    //   6218: aload 16
    //   6220: invokevirtual 2854	java/io/File:delete	()Z
    //   6223: pop
    //   6224: aload_0
    //   6225: invokevirtual 47	arph:getAppRuntime	()Lmqq/app/AppRuntime;
    //   6228: invokevirtual 2692	mqq/app/AppRuntime:getApplication	()Lmqq/app/MobileQQ;
    //   6231: aload 19
    //   6233: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   6236: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   6239: ldc 13
    //   6241: getstatic 15	arph:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   6244: invokestatic 2905	bhhr:b	(Landroid/content/Context;ILjava/lang/String;Ljava/lang/String;)V
    //   6247: goto +5521 -> 11768
    //   6250: aload 19
    //   6252: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   6255: ifnull +178 -> 6433
    //   6258: aload 19
    //   6260: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   6263: invokevirtual 113	com/tencent/mobileqq/pb/PBRepeatField:size	()I
    //   6266: ifle +167 -> 6433
    //   6269: new 1160	java/util/ArrayList
    //   6272: dup
    //   6273: invokespecial 1161	java/util/ArrayList:<init>	()V
    //   6276: astore 16
    //   6278: iconst_0
    //   6279: istore 7
    //   6281: iload 7
    //   6283: aload 19
    //   6285: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   6288: invokevirtual 113	com/tencent/mobileqq/pb/PBRepeatField:size	()I
    //   6291: if_icmpge +92 -> 6383
    //   6294: aload 19
    //   6296: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   6299: iload 7
    //   6301: invokevirtual 116	com/tencent/mobileqq/pb/PBRepeatField:get	(I)Ljava/lang/Object;
    //   6304: checkcast 118	java/lang/String
    //   6307: astore 17
    //   6309: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6312: ifeq +47 -> 6359
    //   6315: ldc 189
    //   6317: iconst_2
    //   6318: new 85	java/lang/StringBuilder
    //   6321: dup
    //   6322: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   6325: ldc_w 2907
    //   6328: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6331: aload 17
    //   6333: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6336: ldc_w 620
    //   6339: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6342: aload 19
    //   6344: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   6347: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   6350: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6353: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6356: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   6359: aload_0
    //   6360: aload 17
    //   6362: invokespecial 2909	arph:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/config/operation/QQOperationViopTipTask;
    //   6365: astore 17
    //   6367: aload 17
    //   6369: ifnull +5466 -> 11835
    //   6372: aload 16
    //   6374: aload 17
    //   6376: invokevirtual 1194	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   6379: pop
    //   6380: goto +5455 -> 11835
    //   6383: aload_0
    //   6384: invokevirtual 47	arph:getAppRuntime	()Lmqq/app/AppRuntime;
    //   6387: checkcast 49	com/tencent/mobileqq/app/QQAppInterface
    //   6390: invokestatic 2914	arpb:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)Larpb;
    //   6393: aload_0
    //   6394: invokevirtual 47	arph:getAppRuntime	()Lmqq/app/AppRuntime;
    //   6397: checkcast 49	com/tencent/mobileqq/app/QQAppInterface
    //   6400: aload 16
    //   6402: invokevirtual 2917	arpb:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/util/ArrayList;)V
    //   6405: aload_0
    //   6406: invokevirtual 47	arph:getAppRuntime	()Lmqq/app/AppRuntime;
    //   6409: invokevirtual 2692	mqq/app/AppRuntime:getApplication	()Lmqq/app/MobileQQ;
    //   6412: aload_0
    //   6413: invokevirtual 47	arph:getAppRuntime	()Lmqq/app/AppRuntime;
    //   6416: invokevirtual 2888	mqq/app/AppRuntime:getAccount	()Ljava/lang/String;
    //   6419: aload 19
    //   6421: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   6424: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   6427: invokestatic 2918	bhhr:a	(Landroid/content/Context;Ljava/lang/String;I)V
    //   6430: goto +5338 -> 11768
    //   6433: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6436: ifeq +5332 -> 11768
    //   6439: ldc 189
    //   6441: iconst_2
    //   6442: new 85	java/lang/StringBuilder
    //   6445: dup
    //   6446: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   6449: ldc_w 2920
    //   6452: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6455: aload 19
    //   6457: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   6460: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   6463: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6466: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6469: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   6472: goto +5296 -> 11768
    //   6475: aload_2
    //   6476: getstatic 1430	com/tencent/mobileqq/app/QQManagerFactory:NEARBY_BANNER_MANAGER	I
    //   6479: invokevirtual 166	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   6482: checkcast 1432	arpr
    //   6485: astore 16
    //   6487: aload 16
    //   6489: invokevirtual 2923	arpr:a	()Ljava/util/Set;
    //   6492: astore 20
    //   6494: new 2872	arpt
    //   6497: dup
    //   6498: bipush 21
    //   6500: iconst_2
    //   6501: invokespecial 2926	arpt:<init>	(SB)V
    //   6504: astore 17
    //   6506: aload 19
    //   6508: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   6511: ifnull +129 -> 6640
    //   6514: aload 19
    //   6516: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   6519: invokevirtual 113	com/tencent/mobileqq/pb/PBRepeatField:size	()I
    //   6522: ifle +118 -> 6640
    //   6525: aload 19
    //   6527: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   6530: invokevirtual 1182	com/tencent/mobileqq/pb/PBRepeatField:get	()Ljava/util/List;
    //   6533: invokeinterface 246 1 0
    //   6538: astore 21
    //   6540: aload 21
    //   6542: invokeinterface 251 1 0
    //   6547: ifeq +132 -> 6679
    //   6550: aload 21
    //   6552: invokeinterface 255 1 0
    //   6557: checkcast 118	java/lang/String
    //   6560: astore 22
    //   6562: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6565: ifeq +47 -> 6612
    //   6568: ldc 189
    //   6570: iconst_2
    //   6571: new 85	java/lang/StringBuilder
    //   6574: dup
    //   6575: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   6578: ldc_w 2928
    //   6581: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6584: aload 22
    //   6586: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6589: ldc_w 620
    //   6592: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6595: aload 19
    //   6597: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   6600: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   6603: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6606: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6609: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   6612: aload 17
    //   6614: aload 22
    //   6616: aload 20
    //   6618: invokestatic 2931	arph:a	(Larpt;Ljava/lang/String;Ljava/util/Set;)Z
    //   6621: pop
    //   6622: aload 16
    //   6624: aload 17
    //   6626: aload 19
    //   6628: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   6631: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   6634: invokevirtual 2934	arpr:a	(Larpt;I)V
    //   6637: goto -97 -> 6540
    //   6640: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6643: ifeq +36 -> 6679
    //   6646: ldc 189
    //   6648: iconst_2
    //   6649: new 85	java/lang/StringBuilder
    //   6652: dup
    //   6653: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   6656: ldc_w 2936
    //   6659: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6662: aload 19
    //   6664: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   6667: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   6670: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6673: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6676: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   6679: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6682: ifeq +76 -> 6758
    //   6685: new 85	java/lang/StringBuilder
    //   6688: dup
    //   6689: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   6692: ldc_w 2938
    //   6695: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6698: astore 20
    //   6700: aload 19
    //   6702: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   6705: ifnonnull +69 -> 6774
    //   6708: iconst_0
    //   6709: istore 7
    //   6711: ldc 189
    //   6713: iconst_2
    //   6714: aload 20
    //   6716: iload 7
    //   6718: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6721: ldc_w 2940
    //   6724: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6727: aload 17
    //   6729: invokevirtual 2941	arpt:a	()I
    //   6732: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6735: ldc_w 2943
    //   6738: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6741: aload 19
    //   6743: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   6746: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   6749: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6752: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6755: invokestatic 206	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   6758: aload 16
    //   6760: aload 19
    //   6762: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   6765: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   6768: invokevirtual 2944	arpr:a	(I)V
    //   6771: goto +4997 -> 11768
    //   6774: aload 19
    //   6776: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   6779: invokevirtual 1182	com/tencent/mobileqq/pb/PBRepeatField:get	()Ljava/util/List;
    //   6782: invokeinterface 412 1 0
    //   6787: istore 7
    //   6789: goto -78 -> 6711
    //   6792: aload_2
    //   6793: invokevirtual 65	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   6796: aload_2
    //   6797: invokevirtual 423	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   6800: invokestatic 1458	bhhr:j	(Landroid/content/Context;Ljava/lang/String;)I
    //   6803: istore 8
    //   6805: aload 19
    //   6807: ifnull +5037 -> 11844
    //   6810: aload 19
    //   6812: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   6815: ifnull +5029 -> 11844
    //   6818: aload 19
    //   6820: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   6823: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   6826: istore 7
    //   6828: aload 19
    //   6830: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   6833: ifnull +185 -> 7018
    //   6836: aload 19
    //   6838: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   6841: invokevirtual 113	com/tencent/mobileqq/pb/PBRepeatField:size	()I
    //   6844: ifle +174 -> 7018
    //   6847: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6850: ifeq +79 -> 6929
    //   6853: ldc 189
    //   6855: iconst_2
    //   6856: new 85	java/lang/StringBuilder
    //   6859: dup
    //   6860: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   6863: ldc_w 2946
    //   6866: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6869: iload 7
    //   6871: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6874: ldc_w 2948
    //   6877: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6880: iload 8
    //   6882: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6885: ldc_w 2950
    //   6888: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6891: aload 19
    //   6893: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   6896: invokevirtual 113	com/tencent/mobileqq/pb/PBRepeatField:size	()I
    //   6899: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6902: ldc_w 2952
    //   6905: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6908: aload 19
    //   6910: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   6913: iconst_0
    //   6914: invokevirtual 116	com/tencent/mobileqq/pb/PBRepeatField:get	(I)Ljava/lang/Object;
    //   6917: checkcast 118	java/lang/String
    //   6920: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6923: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6926: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   6929: new 535	java/util/HashSet
    //   6932: dup
    //   6933: invokespecial 536	java/util/HashSet:<init>	()V
    //   6936: astore 16
    //   6938: iconst_0
    //   6939: istore 8
    //   6941: iload 8
    //   6943: aload 19
    //   6945: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   6948: invokevirtual 113	com/tencent/mobileqq/pb/PBRepeatField:size	()I
    //   6951: if_icmpge +30 -> 6981
    //   6954: aload 16
    //   6956: aload 19
    //   6958: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   6961: iload 8
    //   6963: invokevirtual 116	com/tencent/mobileqq/pb/PBRepeatField:get	(I)Ljava/lang/Object;
    //   6966: invokeinterface 2955 2 0
    //   6971: pop
    //   6972: iload 8
    //   6974: iconst_1
    //   6975: iadd
    //   6976: istore 8
    //   6978: goto -37 -> 6941
    //   6981: aload_2
    //   6982: getstatic 2958	com/tencent/mobileqq/app/QQManagerFactory:SEND_BLESS_CONFIG_MANAGER	I
    //   6985: invokevirtual 166	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   6988: checkcast 2960	aipw
    //   6991: aload 16
    //   6993: invokevirtual 2963	aipw:a	(Ljava/util/Set;)V
    //   6996: aload_0
    //   6997: invokevirtual 47	arph:getAppRuntime	()Lmqq/app/AppRuntime;
    //   7000: invokevirtual 2692	mqq/app/AppRuntime:getApplication	()Lmqq/app/MobileQQ;
    //   7003: aload_0
    //   7004: invokevirtual 47	arph:getAppRuntime	()Lmqq/app/AppRuntime;
    //   7007: invokevirtual 2888	mqq/app/AppRuntime:getAccount	()Ljava/lang/String;
    //   7010: iload 7
    //   7012: invokestatic 2964	bhhr:b	(Landroid/content/Context;Ljava/lang/String;I)V
    //   7015: goto +4836 -> 11851
    //   7018: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7021: ifeq +41 -> 7062
    //   7024: ldc 189
    //   7026: iconst_2
    //   7027: new 85	java/lang/StringBuilder
    //   7030: dup
    //   7031: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   7034: ldc_w 2966
    //   7037: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7040: iload 7
    //   7042: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7045: ldc_w 2948
    //   7048: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7051: iload 8
    //   7053: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7056: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7059: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   7062: iload 8
    //   7064: iload 7
    //   7066: if_icmpeq +4785 -> 11851
    //   7069: aload_2
    //   7070: getstatic 2958	com/tencent/mobileqq/app/QQManagerFactory:SEND_BLESS_CONFIG_MANAGER	I
    //   7073: invokevirtual 166	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   7076: checkcast 2960	aipw
    //   7079: invokevirtual 2967	aipw:a	()V
    //   7082: aload_0
    //   7083: invokevirtual 47	arph:getAppRuntime	()Lmqq/app/AppRuntime;
    //   7086: invokevirtual 2692	mqq/app/AppRuntime:getApplication	()Lmqq/app/MobileQQ;
    //   7089: aload_0
    //   7090: invokevirtual 47	arph:getAppRuntime	()Lmqq/app/AppRuntime;
    //   7093: invokevirtual 2888	mqq/app/AppRuntime:getAccount	()Ljava/lang/String;
    //   7096: iload 7
    //   7098: invokestatic 2964	bhhr:b	(Landroid/content/Context;Ljava/lang/String;I)V
    //   7101: goto +4750 -> 11851
    //   7104: aload 19
    //   7106: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   7109: ifnull +4637 -> 11746
    //   7112: aload 19
    //   7114: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   7117: invokevirtual 113	com/tencent/mobileqq/pb/PBRepeatField:size	()I
    //   7120: ifle +4626 -> 11746
    //   7123: aload 19
    //   7125: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   7128: invokevirtual 1182	com/tencent/mobileqq/pb/PBRepeatField:get	()Ljava/util/List;
    //   7131: astore 16
    //   7133: aload 16
    //   7135: ifnull +195 -> 7330
    //   7138: aload 16
    //   7140: invokeinterface 412 1 0
    //   7145: ifle +185 -> 7330
    //   7148: aload 16
    //   7150: iconst_0
    //   7151: invokeinterface 461 2 0
    //   7156: checkcast 118	java/lang/String
    //   7159: astore 17
    //   7161: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7164: ifeq +47 -> 7211
    //   7167: ldc 189
    //   7169: iconst_2
    //   7170: new 85	java/lang/StringBuilder
    //   7173: dup
    //   7174: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   7177: ldc_w 2969
    //   7180: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7183: aload 17
    //   7185: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7188: ldc_w 620
    //   7191: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7194: aload 19
    //   7196: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   7199: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   7202: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7205: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7208: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   7211: aload 17
    //   7213: invokestatic 2972	nut:a	(Ljava/lang/String;)V
    //   7216: aload 16
    //   7218: invokeinterface 246 1 0
    //   7223: astore 16
    //   7225: aload 16
    //   7227: invokeinterface 251 1 0
    //   7232: ifeq +73 -> 7305
    //   7235: aload 16
    //   7237: invokeinterface 255 1 0
    //   7242: checkcast 118	java/lang/String
    //   7245: astore 17
    //   7247: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7250: ifeq +47 -> 7297
    //   7253: ldc 189
    //   7255: iconst_2
    //   7256: new 85	java/lang/StringBuilder
    //   7259: dup
    //   7260: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   7263: ldc_w 2969
    //   7266: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7269: aload 17
    //   7271: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7274: ldc_w 620
    //   7277: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7280: aload 19
    //   7282: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   7285: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   7288: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7291: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7294: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   7297: aload 17
    //   7299: invokestatic 2976	aijz:a	(Ljava/lang/String;)Z
    //   7302: ifeq -77 -> 7225
    //   7305: aload 19
    //   7307: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   7310: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   7313: istore 7
    //   7315: aload_0
    //   7316: invokevirtual 47	arph:getAppRuntime	()Lmqq/app/AppRuntime;
    //   7319: invokevirtual 2692	mqq/app/AppRuntime:getApplication	()Lmqq/app/MobileQQ;
    //   7322: iload 7
    //   7324: invokestatic 2979	bhhr:b	(Landroid/content/Context;I)V
    //   7327: goto +4441 -> 11768
    //   7330: aconst_null
    //   7331: invokestatic 2972	nut:a	(Ljava/lang/String;)V
    //   7334: invokestatic 2980	aijz:a	()V
    //   7337: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7340: ifeq -35 -> 7305
    //   7343: ldc 189
    //   7345: iconst_2
    //   7346: new 85	java/lang/StringBuilder
    //   7349: dup
    //   7350: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   7353: ldc_w 2982
    //   7356: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7359: aload 19
    //   7361: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   7364: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   7367: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7370: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7373: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   7376: goto -71 -> 7305
    //   7379: invokestatic 397	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   7382: aload_2
    //   7383: invokevirtual 69	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   7386: invokestatic 1470	cooperation/pluginbridge/BridgeHelper:a	(Landroid/content/Context;Ljava/lang/String;)Lcooperation/pluginbridge/BridgeHelper;
    //   7389: aload 19
    //   7391: invokevirtual 2983	cooperation/pluginbridge/BridgeHelper:a	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   7394: goto +4374 -> 11768
    //   7397: aload_0
    //   7398: aload_3
    //   7399: aload 19
    //   7401: invokespecial 2986	arph:l	(Landroid/content/Intent;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   7404: goto +4364 -> 11768
    //   7407: aload_0
    //   7408: aload_3
    //   7409: aload 19
    //   7411: invokespecial 2988	arph:j	(Landroid/content/Intent;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   7414: goto +4354 -> 11768
    //   7417: aload_0
    //   7418: aload_3
    //   7419: aload 19
    //   7421: invokespecial 2990	arph:k	(Landroid/content/Intent;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   7424: goto +4344 -> 11768
    //   7427: aload_0
    //   7428: aload 19
    //   7430: invokespecial 2992	arph:j	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   7433: goto +4335 -> 11768
    //   7436: aload_0
    //   7437: aload 19
    //   7439: invokespecial 2994	arph:i	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   7442: goto +4326 -> 11768
    //   7445: aload 19
    //   7447: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   7450: ifnull +103 -> 7553
    //   7453: aload 19
    //   7455: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   7458: invokevirtual 113	com/tencent/mobileqq/pb/PBRepeatField:size	()I
    //   7461: ifle +92 -> 7553
    //   7464: aload 19
    //   7466: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   7469: iconst_0
    //   7470: invokevirtual 116	com/tencent/mobileqq/pb/PBRepeatField:get	(I)Ljava/lang/Object;
    //   7473: checkcast 118	java/lang/String
    //   7476: astore 16
    //   7478: aload 19
    //   7480: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   7483: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   7486: istore 7
    //   7488: aload_2
    //   7489: invokevirtual 2998	com/tencent/mobileqq/app/QQAppInterface:getAVNotifyCenter	()Lcom/tencent/av/gaudio/AVNotifyCenter;
    //   7492: aload_2
    //   7493: aload 16
    //   7495: iload 7
    //   7497: invokevirtual 3002	com/tencent/av/gaudio/AVNotifyCenter:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;I)V
    //   7500: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7503: ifeq +4351 -> 11854
    //   7506: ldc 189
    //   7508: iconst_2
    //   7509: new 85	java/lang/StringBuilder
    //   7512: dup
    //   7513: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   7516: ldc_w 3004
    //   7519: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7522: aload 16
    //   7524: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7527: ldc_w 620
    //   7530: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7533: aload 19
    //   7535: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   7538: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   7541: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7544: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7547: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   7550: goto +4304 -> 11854
    //   7553: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7556: ifeq +4212 -> 11768
    //   7559: ldc 189
    //   7561: iconst_2
    //   7562: new 85	java/lang/StringBuilder
    //   7565: dup
    //   7566: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   7569: ldc_w 3006
    //   7572: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7575: aload 19
    //   7577: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   7580: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   7583: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7586: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7589: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   7592: goto +4176 -> 11768
    //   7595: aload_2
    //   7596: getstatic 3009	com/tencent/mobileqq/app/QQManagerFactory:INDIVIDUATION_ABTEST_MANAGER	I
    //   7599: invokevirtual 166	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   7602: checkcast 3011	bhnl
    //   7605: astore 16
    //   7607: aload 19
    //   7609: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   7612: ifnull +98 -> 7710
    //   7615: aload 19
    //   7617: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   7620: invokevirtual 113	com/tencent/mobileqq/pb/PBRepeatField:size	()I
    //   7623: ifle +87 -> 7710
    //   7626: aload 19
    //   7628: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   7631: iconst_0
    //   7632: invokevirtual 116	com/tencent/mobileqq/pb/PBRepeatField:get	(I)Ljava/lang/Object;
    //   7635: checkcast 118	java/lang/String
    //   7638: astore 17
    //   7640: aload 19
    //   7642: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   7645: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   7648: istore 7
    //   7650: aload 16
    //   7652: aload 17
    //   7654: aload_2
    //   7655: invokevirtual 423	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   7658: iload 7
    //   7660: invokevirtual 3014	bhnl:a	(Ljava/lang/String;Ljava/lang/String;I)V
    //   7663: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7666: ifeq +4191 -> 11857
    //   7669: ldc 189
    //   7671: iconst_2
    //   7672: new 85	java/lang/StringBuilder
    //   7675: dup
    //   7676: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   7679: ldc_w 3016
    //   7682: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7685: aload 17
    //   7687: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7690: ldc_w 620
    //   7693: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7696: iload 7
    //   7698: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7701: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7704: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   7707: goto +4150 -> 11857
    //   7710: aload 16
    //   7712: aload 19
    //   7714: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   7717: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   7720: aload_2
    //   7721: invokevirtual 423	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   7724: invokevirtual 3019	bhnl:a	(ILjava/lang/String;)V
    //   7727: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7730: ifeq +4130 -> 11860
    //   7733: ldc 189
    //   7735: iconst_2
    //   7736: new 85	java/lang/StringBuilder
    //   7739: dup
    //   7740: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   7743: ldc_w 3021
    //   7746: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7749: aload 19
    //   7751: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   7754: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   7757: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7760: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7763: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   7766: goto +4094 -> 11860
    //   7769: aload_0
    //   7770: aload_3
    //   7771: aload 19
    //   7773: invokespecial 3023	arph:i	(Landroid/content/Intent;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   7776: goto +3992 -> 11768
    //   7779: aload_0
    //   7780: aload_3
    //   7781: aload 19
    //   7783: invokespecial 3025	arph:e	(Landroid/content/Intent;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   7786: goto +3982 -> 11768
    //   7789: aload_0
    //   7790: aload_3
    //   7791: aload 19
    //   7793: invokespecial 3027	arph:f	(Landroid/content/Intent;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   7796: goto +3972 -> 11768
    //   7799: aload_0
    //   7800: aload_3
    //   7801: aload 19
    //   7803: invokespecial 3029	arph:g	(Landroid/content/Intent;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   7806: goto +3962 -> 11768
    //   7809: aload_0
    //   7810: aload_2
    //   7811: aload_3
    //   7812: aload 19
    //   7814: invokespecial 3032	arph:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Landroid/content/Intent;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   7817: goto +3951 -> 11768
    //   7820: aload_0
    //   7821: aload_3
    //   7822: aload 19
    //   7824: invokespecial 3034	arph:h	(Landroid/content/Intent;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   7827: goto +3941 -> 11768
    //   7830: aload_0
    //   7831: aload 19
    //   7833: invokespecial 3036	arph:g	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   7836: goto +3932 -> 11768
    //   7839: aload_0
    //   7840: aload 19
    //   7842: invokespecial 3038	arph:h	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   7845: goto +3923 -> 11768
    //   7848: aload_0
    //   7849: aload_2
    //   7850: aload 19
    //   7852: invokespecial 3040	arph:ad	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   7855: goto +3913 -> 11768
    //   7858: aload_2
    //   7859: invokestatic 1558	com/tencent/mobileqq/utils/BusinessCommonConfig:getInstance	(Lmqq/app/AppRuntime;)Lcom/tencent/mobileqq/utils/BusinessCommonConfig;
    //   7862: aload_2
    //   7863: aload 16
    //   7865: invokevirtual 1895	java/lang/Integer:intValue	()I
    //   7868: aload_3
    //   7869: aload 19
    //   7871: invokevirtual 3044	com/tencent/mobileqq/utils/BusinessCommonConfig:decodeConfig	(Lcom/tencent/mobileqq/app/QQAppInterface;ILandroid/content/Intent;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)Ljava/lang/Boolean;
    //   7874: pop
    //   7875: goto +3893 -> 11768
    //   7878: aload 19
    //   7880: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   7883: ifnull +164 -> 8047
    //   7886: aload 19
    //   7888: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   7891: invokevirtual 113	com/tencent/mobileqq/pb/PBRepeatField:size	()I
    //   7894: ifle +153 -> 8047
    //   7897: aload 19
    //   7899: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   7902: invokevirtual 1182	com/tencent/mobileqq/pb/PBRepeatField:get	()Ljava/util/List;
    //   7905: invokeinterface 246 1 0
    //   7910: astore 16
    //   7912: aload 16
    //   7914: invokeinterface 251 1 0
    //   7919: ifeq +167 -> 8086
    //   7922: aload 16
    //   7924: invokeinterface 255 1 0
    //   7929: checkcast 118	java/lang/String
    //   7932: astore 17
    //   7934: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7937: ifeq +47 -> 7984
    //   7940: ldc 189
    //   7942: iconst_2
    //   7943: new 85	java/lang/StringBuilder
    //   7946: dup
    //   7947: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   7950: ldc_w 3046
    //   7953: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7956: aload 17
    //   7958: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7961: ldc_w 620
    //   7964: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7967: aload 19
    //   7969: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   7972: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   7975: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7978: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7981: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   7984: aload_0
    //   7985: aload 17
    //   7987: aload 19
    //   7989: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   7992: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   7995: invokespecial 3048	arph:a	(Ljava/lang/String;I)V
    //   7998: goto -86 -> 7912
    //   8001: astore 16
    //   8003: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   8006: ifeq +33 -> 8039
    //   8009: ldc 189
    //   8011: iconst_2
    //   8012: new 85	java/lang/StringBuilder
    //   8015: dup
    //   8016: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   8019: ldc_w 3050
    //   8022: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8025: aload 16
    //   8027: invokevirtual 656	java/lang/Exception:toString	()Ljava/lang/String;
    //   8030: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8033: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8036: invokestatic 658	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   8039: aload 16
    //   8041: invokevirtual 472	java/lang/Exception:printStackTrace	()V
    //   8044: goto +3724 -> 11768
    //   8047: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   8050: ifeq +36 -> 8086
    //   8053: ldc 189
    //   8055: iconst_2
    //   8056: new 85	java/lang/StringBuilder
    //   8059: dup
    //   8060: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   8063: ldc_w 3052
    //   8066: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8069: aload 19
    //   8071: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   8074: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   8077: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   8080: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8083: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   8086: goto +3682 -> 11768
    //   8089: aload 19
    //   8091: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   8094: ifnull +164 -> 8258
    //   8097: aload 19
    //   8099: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   8102: invokevirtual 113	com/tencent/mobileqq/pb/PBRepeatField:size	()I
    //   8105: ifle +153 -> 8258
    //   8108: aload 19
    //   8110: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   8113: invokevirtual 1182	com/tencent/mobileqq/pb/PBRepeatField:get	()Ljava/util/List;
    //   8116: invokeinterface 246 1 0
    //   8121: astore 16
    //   8123: aload 16
    //   8125: invokeinterface 251 1 0
    //   8130: ifeq +167 -> 8297
    //   8133: aload 16
    //   8135: invokeinterface 255 1 0
    //   8140: checkcast 118	java/lang/String
    //   8143: astore 17
    //   8145: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   8148: ifeq +47 -> 8195
    //   8151: ldc 189
    //   8153: iconst_2
    //   8154: new 85	java/lang/StringBuilder
    //   8157: dup
    //   8158: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   8161: ldc_w 3054
    //   8164: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8167: aload 17
    //   8169: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8172: ldc_w 620
    //   8175: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8178: aload 19
    //   8180: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   8183: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   8186: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   8189: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8192: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   8195: aload_0
    //   8196: aload 17
    //   8198: aload 19
    //   8200: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   8203: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   8206: invokespecial 3056	arph:b	(Ljava/lang/String;I)V
    //   8209: goto -86 -> 8123
    //   8212: astore 16
    //   8214: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   8217: ifeq +33 -> 8250
    //   8220: ldc 189
    //   8222: iconst_2
    //   8223: new 85	java/lang/StringBuilder
    //   8226: dup
    //   8227: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   8230: ldc_w 3058
    //   8233: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8236: aload 16
    //   8238: invokevirtual 656	java/lang/Exception:toString	()Ljava/lang/String;
    //   8241: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8244: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8247: invokestatic 658	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   8250: aload 16
    //   8252: invokevirtual 472	java/lang/Exception:printStackTrace	()V
    //   8255: goto +3513 -> 11768
    //   8258: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   8261: ifeq +36 -> 8297
    //   8264: ldc 189
    //   8266: iconst_2
    //   8267: new 85	java/lang/StringBuilder
    //   8270: dup
    //   8271: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   8274: ldc_w 3060
    //   8277: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8280: aload 19
    //   8282: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   8285: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   8288: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   8291: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8294: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   8297: goto +3471 -> 11768
    //   8300: aload_0
    //   8301: aload 19
    //   8303: invokespecial 3062	arph:p	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8306: goto +3462 -> 11768
    //   8309: aload_0
    //   8310: aload 19
    //   8312: invokespecial 3064	arph:m	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8315: goto +3453 -> 11768
    //   8318: aload_0
    //   8319: aload 19
    //   8321: invokespecial 3066	arph:n	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8324: goto +3444 -> 11768
    //   8327: aload_0
    //   8328: aload 19
    //   8330: invokespecial 3068	arph:o	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8333: goto +3435 -> 11768
    //   8336: aload_0
    //   8337: aload 19
    //   8339: invokespecial 3070	arph:t	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8342: goto +3426 -> 11768
    //   8345: aload_0
    //   8346: aload 19
    //   8348: invokespecial 3072	arph:r	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8351: goto +3417 -> 11768
    //   8354: aload_0
    //   8355: aload 19
    //   8357: invokespecial 3074	arph:d	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8360: goto +3408 -> 11768
    //   8363: aload_0
    //   8364: aload 19
    //   8366: invokespecial 3076	arph:q	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8369: goto +3399 -> 11768
    //   8372: aload_0
    //   8373: aload 19
    //   8375: invokespecial 3078	arph:s	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8378: goto +3390 -> 11768
    //   8381: aload_0
    //   8382: aload 19
    //   8384: invokespecial 3080	arph:k	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8387: goto +3381 -> 11768
    //   8390: aload_0
    //   8391: aload 19
    //   8393: invokevirtual 3082	arph:b	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8396: goto +3372 -> 11768
    //   8399: aload_0
    //   8400: aload 19
    //   8402: invokevirtual 3084	arph:c	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8405: goto +3363 -> 11768
    //   8408: aload_0
    //   8409: aload 19
    //   8411: invokespecial 3086	arph:v	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8414: goto +3354 -> 11768
    //   8417: aload_0
    //   8418: aload 19
    //   8420: invokespecial 3088	arph:w	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8423: goto +3345 -> 11768
    //   8426: aload_0
    //   8427: aload 19
    //   8429: invokespecial 3090	arph:z	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8432: goto +3336 -> 11768
    //   8435: aload_0
    //   8436: aload 19
    //   8438: invokespecial 3092	arph:B	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8441: goto +3327 -> 11768
    //   8444: aload_0
    //   8445: aload 19
    //   8447: invokespecial 3094	arph:x	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8450: goto +3318 -> 11768
    //   8453: aload_0
    //   8454: aload 19
    //   8456: invokespecial 3096	arph:y	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8459: goto +3309 -> 11768
    //   8462: aload_0
    //   8463: aload 19
    //   8465: invokespecial 3098	arph:l	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8468: goto +3300 -> 11768
    //   8471: aload_0
    //   8472: aload 19
    //   8474: invokespecial 3100	arph:u	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8477: goto +3291 -> 11768
    //   8480: invokestatic 3103	com/tencent/mobileqq/app/DeviceProfileManager:a	()Lcom/tencent/mobileqq/app/DeviceProfileManager;
    //   8483: aload_1
    //   8484: ldc 13
    //   8486: invokevirtual 3106	com/tencent/mobileqq/app/DeviceProfileManager:a	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig;Ljava/lang/String;)Z
    //   8489: pop
    //   8490: goto +3278 -> 11768
    //   8493: aload_0
    //   8494: aload 19
    //   8496: invokespecial 3108	arph:e	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8499: goto +3269 -> 11768
    //   8502: aload_0
    //   8503: aload 19
    //   8505: invokespecial 3110	arph:f	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8508: goto +3260 -> 11768
    //   8511: aload_0
    //   8512: aload 19
    //   8514: invokevirtual 3111	arph:a	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8517: goto +3251 -> 11768
    //   8520: aload_0
    //   8521: aload 19
    //   8523: invokespecial 3113	arph:A	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8526: goto +3242 -> 11768
    //   8529: aload 19
    //   8531: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   8534: ifnull +141 -> 8675
    //   8537: aload 19
    //   8539: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   8542: invokevirtual 113	com/tencent/mobileqq/pb/PBRepeatField:size	()I
    //   8545: ifle +130 -> 8675
    //   8548: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   8551: ifeq +68 -> 8619
    //   8554: ldc 189
    //   8556: iconst_2
    //   8557: new 85	java/lang/StringBuilder
    //   8560: dup
    //   8561: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   8564: ldc_w 3115
    //   8567: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8570: aload 16
    //   8572: invokevirtual 825	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   8575: ldc_w 2952
    //   8578: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8581: aload 19
    //   8583: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   8586: iconst_0
    //   8587: invokevirtual 116	com/tencent/mobileqq/pb/PBRepeatField:get	(I)Ljava/lang/Object;
    //   8590: checkcast 118	java/lang/String
    //   8593: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8596: ldc_w 620
    //   8599: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8602: aload 19
    //   8604: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   8607: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   8610: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   8613: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8616: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   8619: aload_2
    //   8620: getstatic 3118	com/tencent/mobileqq/app/QQManagerFactory:PHOTO_PLUS_MANAGER	I
    //   8623: invokevirtual 166	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   8626: checkcast 3120	cooperation/photoplus/PhotoPlusManager
    //   8629: aload 19
    //   8631: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   8634: iconst_0
    //   8635: invokevirtual 116	com/tencent/mobileqq/pb/PBRepeatField:get	(I)Ljava/lang/Object;
    //   8638: checkcast 118	java/lang/String
    //   8641: invokevirtual 3121	cooperation/photoplus/PhotoPlusManager:a	(Ljava/lang/String;)Z
    //   8644: ifeq +3124 -> 11768
    //   8647: aload_0
    //   8648: invokevirtual 47	arph:getAppRuntime	()Lmqq/app/AppRuntime;
    //   8651: invokevirtual 2692	mqq/app/AppRuntime:getApplication	()Lmqq/app/MobileQQ;
    //   8654: aload_0
    //   8655: invokevirtual 47	arph:getAppRuntime	()Lmqq/app/AppRuntime;
    //   8658: invokevirtual 2888	mqq/app/AppRuntime:getAccount	()Ljava/lang/String;
    //   8661: aload 19
    //   8663: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   8666: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   8669: invokestatic 3123	bhhr:r	(Landroid/content/Context;Ljava/lang/String;I)V
    //   8672: goto +3096 -> 11768
    //   8675: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   8678: ifeq +3090 -> 11768
    //   8681: ldc 189
    //   8683: iconst_2
    //   8684: new 85	java/lang/StringBuilder
    //   8687: dup
    //   8688: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   8691: ldc_w 3115
    //   8694: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8697: aload 16
    //   8699: invokevirtual 825	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   8702: ldc_w 3125
    //   8705: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8708: aload 19
    //   8710: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   8713: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   8716: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   8719: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8722: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   8725: goto +3043 -> 11768
    //   8728: aload_0
    //   8729: aload_2
    //   8730: aload 19
    //   8732: invokevirtual 3127	arph:e	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8735: goto +3033 -> 11768
    //   8738: aload_0
    //   8739: aload_3
    //   8740: iload 5
    //   8742: aload 19
    //   8744: aload_1
    //   8745: getfield 2480	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:result	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   8748: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   8751: invokevirtual 3130	arph:a	(Landroid/content/Intent;ZLcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;I)V
    //   8754: goto +3014 -> 11768
    //   8757: aload_0
    //   8758: aload_3
    //   8759: aload 19
    //   8761: invokespecial 3132	arph:c	(Landroid/content/Intent;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8764: goto +3004 -> 11768
    //   8767: aload_0
    //   8768: aload_3
    //   8769: aload 19
    //   8771: invokespecial 3134	arph:b	(Landroid/content/Intent;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8774: goto +2994 -> 11768
    //   8777: aload_0
    //   8778: aload_3
    //   8779: aload 19
    //   8781: invokespecial 3136	arph:d	(Landroid/content/Intent;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8784: goto +2984 -> 11768
    //   8787: aload_0
    //   8788: aload_3
    //   8789: aload 19
    //   8791: invokevirtual 3138	arph:a	(Landroid/content/Intent;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8794: goto +2974 -> 11768
    //   8797: aload_0
    //   8798: aload_2
    //   8799: aload_3
    //   8800: aload 19
    //   8802: invokevirtual 3140	arph:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Landroid/content/Intent;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8805: goto +2963 -> 11768
    //   8808: aload_0
    //   8809: aload_2
    //   8810: aload 19
    //   8812: invokespecial 3142	arph:U	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8815: goto +2953 -> 11768
    //   8818: aload_0
    //   8819: aload_2
    //   8820: aload 19
    //   8822: invokespecial 3144	arph:ae	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8825: goto +2943 -> 11768
    //   8828: aload 16
    //   8830: invokevirtual 1895	java/lang/Integer:intValue	()I
    //   8833: aload_2
    //   8834: invokevirtual 1636	com/tencent/mobileqq/app/QQAppInterface:getCurrentUin	()Ljava/lang/String;
    //   8837: aload 19
    //   8839: invokestatic 3147	lbx:a	(ILjava/lang/String;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8842: goto +2926 -> 11768
    //   8845: aload_0
    //   8846: aload_2
    //   8847: aload 19
    //   8849: invokevirtual 3149	arph:d	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8852: goto +2916 -> 11768
    //   8855: aload_0
    //   8856: aload_3
    //   8857: iload 5
    //   8859: aload 19
    //   8861: aload_1
    //   8862: getfield 2480	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:result	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   8865: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   8868: invokevirtual 3151	arph:b	(Landroid/content/Intent;ZLcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;I)V
    //   8871: goto +2897 -> 11768
    //   8874: aload_0
    //   8875: aload_2
    //   8876: aload 19
    //   8878: invokespecial 3153	arph:V	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8881: goto +2887 -> 11768
    //   8884: aload_0
    //   8885: aload_2
    //   8886: aload 19
    //   8888: invokespecial 3155	arph:W	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8891: goto +2877 -> 11768
    //   8894: aload_0
    //   8895: aload_2
    //   8896: aload 19
    //   8898: invokespecial 3157	arph:X	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8901: goto +2867 -> 11768
    //   8904: aload_0
    //   8905: aload_2
    //   8906: aload 19
    //   8908: invokespecial 3159	arph:Y	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8911: goto +2857 -> 11768
    //   8914: aload_0
    //   8915: aload_2
    //   8916: aload 19
    //   8918: invokevirtual 3161	arph:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8921: goto +2847 -> 11768
    //   8924: aload_0
    //   8925: aload_2
    //   8926: aload 19
    //   8928: invokespecial 3163	arph:af	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8931: goto +2837 -> 11768
    //   8934: aload_0
    //   8935: aload_2
    //   8936: aload 19
    //   8938: invokespecial 3166	arph:ag	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8941: goto +2827 -> 11768
    //   8944: aload_0
    //   8945: aload_2
    //   8946: aload 19
    //   8948: invokespecial 3168	arph:ah	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8951: goto +2817 -> 11768
    //   8954: aload_0
    //   8955: aload_2
    //   8956: aload 19
    //   8958: invokespecial 3171	arph:ai	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8961: goto +2807 -> 11768
    //   8964: aload 19
    //   8966: invokestatic 3172	bcmz:a	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8969: goto +2799 -> 11768
    //   8972: aload_0
    //   8973: aload_2
    //   8974: aload 19
    //   8976: invokespecial 3174	arph:aj	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8979: goto +2789 -> 11768
    //   8982: aload_0
    //   8983: aload_2
    //   8984: aload 19
    //   8986: invokespecial 3176	arph:ak	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8989: goto +2779 -> 11768
    //   8992: aload_0
    //   8993: aload_2
    //   8994: aload 19
    //   8996: invokespecial 3178	arph:al	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8999: goto +2769 -> 11768
    //   9002: aload_0
    //   9003: aload_2
    //   9004: aload 19
    //   9006: invokespecial 3180	arph:am	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9009: goto +2759 -> 11768
    //   9012: aload_0
    //   9013: aload_2
    //   9014: aload 19
    //   9016: invokevirtual 3182	arph:f	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9019: goto +2749 -> 11768
    //   9022: aload_0
    //   9023: aload_3
    //   9024: aload 19
    //   9026: invokespecial 3184	arph:m	(Landroid/content/Intent;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9029: goto +2739 -> 11768
    //   9032: aload_0
    //   9033: aload_2
    //   9034: aload 19
    //   9036: invokespecial 3187	arph:an	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9039: goto +2729 -> 11768
    //   9042: aload_0
    //   9043: aload_2
    //   9044: aload 19
    //   9046: invokevirtual 3189	arph:l	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9049: goto +2719 -> 11768
    //   9052: aload_0
    //   9053: aload_2
    //   9054: aload 19
    //   9056: invokevirtual 3191	arph:i	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9059: goto +2709 -> 11768
    //   9062: aload_2
    //   9063: getstatic 1920	com/tencent/mobileqq/app/QQManagerFactory:TROOP_STORY_MANAGER	I
    //   9066: invokevirtual 166	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   9069: checkcast 1922	zcj
    //   9072: getfield 1925	zcj:a	Lzci;
    //   9075: aload_2
    //   9076: aload 19
    //   9078: invokevirtual 3194	zci:a	(Lcom/tencent/common/app/AppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9081: goto +2687 -> 11768
    //   9084: aload_0
    //   9085: aload_2
    //   9086: aload 19
    //   9088: invokevirtual 3196	arph:h	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9091: goto +2677 -> 11768
    //   9094: aload_0
    //   9095: aload_2
    //   9096: aload 19
    //   9098: invokevirtual 3198	arph:j	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9101: goto +2667 -> 11768
    //   9104: aload_0
    //   9105: aload_2
    //   9106: aload 19
    //   9108: invokevirtual 3200	arph:m	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9111: goto +2657 -> 11768
    //   9114: aload_0
    //   9115: aload_2
    //   9116: aload 19
    //   9118: invokevirtual 3202	arph:n	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9121: goto +2647 -> 11768
    //   9124: aload_0
    //   9125: aload_2
    //   9126: aload 19
    //   9128: invokevirtual 3204	arph:o	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9131: goto +2637 -> 11768
    //   9134: aload_0
    //   9135: aload_2
    //   9136: aload 19
    //   9138: invokevirtual 3206	arph:q	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9141: goto +2627 -> 11768
    //   9144: aload_2
    //   9145: aload 19
    //   9147: invokestatic 3207	aahy:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9150: goto +2618 -> 11768
    //   9153: aload_0
    //   9154: aload_2
    //   9155: aload 19
    //   9157: invokespecial 3209	arph:ao	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9160: goto +2608 -> 11768
    //   9163: aload_0
    //   9164: aload_2
    //   9165: aload 19
    //   9167: invokevirtual 3211	arph:p	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9170: goto +2598 -> 11768
    //   9173: aload_0
    //   9174: aload_2
    //   9175: aload 19
    //   9177: invokevirtual 3213	arph:r	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9180: goto +2588 -> 11768
    //   9183: aload_0
    //   9184: aload_2
    //   9185: aload 19
    //   9187: invokevirtual 3215	arph:g	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9190: goto +2578 -> 11768
    //   9193: aload_0
    //   9194: aload_2
    //   9195: aload 19
    //   9197: invokevirtual 3217	arph:s	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9200: goto +2568 -> 11768
    //   9203: aload_0
    //   9204: aload_2
    //   9205: aload 19
    //   9207: invokespecial 3219	arph:Z	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9210: goto +2558 -> 11768
    //   9213: aload_0
    //   9214: aload_2
    //   9215: aload 19
    //   9217: invokespecial 3221	arph:aa	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9220: goto +2548 -> 11768
    //   9223: aload_0
    //   9224: aload_2
    //   9225: aload 19
    //   9227: invokevirtual 3223	arph:k	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9230: goto +2538 -> 11768
    //   9233: aload_0
    //   9234: aload_2
    //   9235: aload 19
    //   9237: invokevirtual 3225	arph:u	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9240: goto +2528 -> 11768
    //   9243: aload_2
    //   9244: aload 19
    //   9246: invokestatic 3227	arph:t	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9249: goto +2519 -> 11768
    //   9252: aload 19
    //   9254: aload_2
    //   9255: invokevirtual 1385	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   9258: invokestatic 2029	also:a	(Landroid/content/Context;)I
    //   9261: sipush 199
    //   9264: invokestatic 843	arph:b	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;II)Ljava/lang/String;
    //   9267: astore 16
    //   9269: aload 16
    //   9271: ifnull +2497 -> 11768
    //   9274: aload_2
    //   9275: invokevirtual 1385	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   9278: aload 16
    //   9280: aload 19
    //   9282: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   9285: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   9288: invokestatic 3228	also:a	(Landroid/content/Context;Ljava/lang/String;I)V
    //   9291: goto +2477 -> 11768
    //   9294: aload 19
    //   9296: aload_2
    //   9297: invokevirtual 1385	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   9300: invokestatic 2032	bbgq:a	(Landroid/content/Context;)I
    //   9303: sipush 225
    //   9306: invokestatic 843	arph:b	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;II)Ljava/lang/String;
    //   9309: astore 16
    //   9311: aload 16
    //   9313: ifnull +2455 -> 11768
    //   9316: invokestatic 3231	bbgq:a	()Lbbgq;
    //   9319: aload_2
    //   9320: invokevirtual 1385	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   9323: aload 16
    //   9325: aload 19
    //   9327: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   9330: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   9333: invokevirtual 3232	bbgq:a	(Landroid/content/Context;Ljava/lang/String;I)V
    //   9336: goto +2432 -> 11768
    //   9339: aload_0
    //   9340: aload_2
    //   9341: aload 19
    //   9343: invokevirtual 3234	arph:v	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9346: goto +2422 -> 11768
    //   9349: aload_0
    //   9350: aload_2
    //   9351: aload 19
    //   9353: invokevirtual 3236	arph:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9356: goto +2412 -> 11768
    //   9359: aload_0
    //   9360: aload_2
    //   9361: aload 19
    //   9363: invokespecial 3239	arph:ap	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9366: goto +2402 -> 11768
    //   9369: aload_2
    //   9370: aload 19
    //   9372: invokestatic 3241	arph:w	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9375: goto +2393 -> 11768
    //   9378: aload_2
    //   9379: aload 19
    //   9381: invokestatic 3243	arph:O	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9384: goto +2384 -> 11768
    //   9387: aload_0
    //   9388: aload_2
    //   9389: aload 19
    //   9391: invokespecial 3245	arph:ar	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9394: goto +2374 -> 11768
    //   9397: aload_2
    //   9398: aload 19
    //   9400: invokestatic 3247	arph:P	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9403: goto +2365 -> 11768
    //   9406: aload_0
    //   9407: aload_2
    //   9408: aload 19
    //   9410: aload_3
    //   9411: ldc_w 2354
    //   9414: invokevirtual 1440	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   9417: invokespecial 3249	arph:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;Ljava/lang/String;)I
    //   9420: invokestatic 3250	com/tencent/mobileqq/shortvideo/ShortVideoResourceManager:b	(I)V
    //   9423: goto +2345 -> 11768
    //   9426: aload_2
    //   9427: getstatic 3253	com/tencent/mobileqq/app/QQManagerFactory:PUBLIC_ACCOUNT_VIDEO_PRELOAD_MANAGER	I
    //   9430: invokevirtual 166	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   9433: checkcast 3255	ofd
    //   9436: astore 16
    //   9438: aload 16
    //   9440: ifnull +2328 -> 11768
    //   9443: aload 16
    //   9445: aload_2
    //   9446: aload 19
    //   9448: invokevirtual 3256	ofd:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9451: goto +2317 -> 11768
    //   9454: aload_0
    //   9455: aload_2
    //   9456: aload 19
    //   9458: invokevirtual 3258	arph:y	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9461: goto +2307 -> 11768
    //   9464: aload_0
    //   9465: aload_2
    //   9466: aload 19
    //   9468: invokespecial 3260	arph:T	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9471: goto +2297 -> 11768
    //   9474: aload_0
    //   9475: aload_2
    //   9476: aload 19
    //   9478: invokevirtual 3262	arph:x	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9481: goto +2287 -> 11768
    //   9484: aload_0
    //   9485: aload_2
    //   9486: aload 19
    //   9488: invokevirtual 3264	arph:F	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9491: goto +2277 -> 11768
    //   9494: aload_0
    //   9495: aload_2
    //   9496: aload 19
    //   9498: invokevirtual 3266	arph:z	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9501: goto +2267 -> 11768
    //   9504: aload_0
    //   9505: aload_2
    //   9506: aload 19
    //   9508: invokevirtual 3268	arph:A	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9511: goto +2257 -> 11768
    //   9514: aload_0
    //   9515: aload_2
    //   9516: aload 19
    //   9518: invokevirtual 3270	arph:B	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9521: goto +2247 -> 11768
    //   9524: aload_0
    //   9525: aload_2
    //   9526: aload 19
    //   9528: invokevirtual 3272	arph:C	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9531: goto +2237 -> 11768
    //   9534: aload_0
    //   9535: aload_2
    //   9536: aload 19
    //   9538: invokevirtual 3274	arph:D	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9541: goto +2227 -> 11768
    //   9544: aload_0
    //   9545: aload_2
    //   9546: aload 19
    //   9548: invokevirtual 3276	arph:E	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9551: goto +2217 -> 11768
    //   9554: aload_0
    //   9555: aload_2
    //   9556: aload 19
    //   9558: invokespecial 3278	arph:ab	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9561: goto +2207 -> 11768
    //   9564: aload_0
    //   9565: aload_2
    //   9566: aload 19
    //   9568: invokespecial 3280	arph:ac	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9571: goto +2197 -> 11768
    //   9574: aload_0
    //   9575: aload_2
    //   9576: aload 19
    //   9578: invokespecial 3282	arph:S	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9581: goto +2187 -> 11768
    //   9584: aload_0
    //   9585: aload_2
    //   9586: aload 19
    //   9588: invokevirtual 3284	arph:G	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9591: goto +2177 -> 11768
    //   9594: aload_2
    //   9595: aload 19
    //   9597: invokestatic 3287	bfxr:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9600: goto +2168 -> 11768
    //   9603: aload_2
    //   9604: getstatic 2101	com/tencent/mobileqq/app/QQManagerFactory:TROOP_MANAGER	I
    //   9607: invokevirtual 166	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   9610: checkcast 2103	com/tencent/mobileqq/app/TroopManager
    //   9613: getfield 2106	com/tencent/mobileqq/app/TroopManager:jdField_a_of_type_Bfpu	Lbfpu;
    //   9616: aload_2
    //   9617: aload 19
    //   9619: invokevirtual 3288	bfpu:a	(Lcom/tencent/common/app/AppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9622: goto +2146 -> 11768
    //   9625: aload_2
    //   9626: getstatic 2101	com/tencent/mobileqq/app/QQManagerFactory:TROOP_MANAGER	I
    //   9629: invokevirtual 166	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   9632: checkcast 2103	com/tencent/mobileqq/app/TroopManager
    //   9635: getfield 2114	com/tencent/mobileqq/app/TroopManager:jdField_a_of_type_Bfsb	Lbfsb;
    //   9638: aload_2
    //   9639: aload 19
    //   9641: invokevirtual 3289	bfsb:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9644: goto +2124 -> 11768
    //   9647: aload_2
    //   9648: invokestatic 3294	vzt:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)Lvzt;
    //   9651: aload 19
    //   9653: invokevirtual 3295	vzt:a	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9656: goto +2112 -> 11768
    //   9659: aload_2
    //   9660: getstatic 3298	com/tencent/mobileqq/app/QQManagerFactory:STORY_HALO_MANAGER	I
    //   9663: invokevirtual 166	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   9666: checkcast 3300	wae
    //   9669: aload 19
    //   9671: invokevirtual 3301	wae:a	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9674: goto +2094 -> 11768
    //   9677: invokestatic 2125	avjd:a	()Lavjd;
    //   9680: getfield 2128	avjd:a	Lavjf;
    //   9683: aload 19
    //   9685: invokevirtual 3302	avjf:a	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9688: goto +2080 -> 11768
    //   9691: astore 16
    //   9693: aload 16
    //   9695: invokevirtual 1899	java/lang/Throwable:printStackTrace	()V
    //   9698: goto +2070 -> 11768
    //   9701: aload_2
    //   9702: aload 19
    //   9704: invokestatic 3305	com/tencent/mobileqq/shortvideo/util/RecentDanceConfigMgr:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)I
    //   9707: pop
    //   9708: goto +2060 -> 11768
    //   9711: aload_2
    //   9712: aload 19
    //   9714: invokestatic 3306	dov/com/qq/im/ptv/LightVideoConfigMgr:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)I
    //   9717: pop
    //   9718: goto +2050 -> 11768
    //   9721: aload_0
    //   9722: aload_2
    //   9723: aload 19
    //   9725: invokevirtual 3308	arph:H	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9728: goto +2040 -> 11768
    //   9731: aload_0
    //   9732: aload_2
    //   9733: aload 19
    //   9735: invokevirtual 3310	arph:I	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9738: goto +2030 -> 11768
    //   9741: aload_0
    //   9742: aload_2
    //   9743: aload 19
    //   9745: invokevirtual 3312	arph:J	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9748: goto +2020 -> 11768
    //   9751: aload_2
    //   9752: aload 19
    //   9754: aload 16
    //   9756: invokevirtual 1895	java/lang/Integer:intValue	()I
    //   9759: getstatic 15	arph:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   9762: invokestatic 3317	bdkx:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;ILjava/lang/String;)V
    //   9765: goto +2003 -> 11768
    //   9768: aload_0
    //   9769: aload_2
    //   9770: aload 19
    //   9772: invokevirtual 3319	arph:M	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9775: goto +1993 -> 11768
    //   9778: aload_2
    //   9779: aload 16
    //   9781: invokevirtual 1895	java/lang/Integer:intValue	()I
    //   9784: aload 19
    //   9786: invokestatic 3324	arvo:a	(Lcom/tencent/mobileqq/app/QQAppInterface;ILcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9789: goto +1979 -> 11768
    //   9792: aload_2
    //   9793: invokestatic 3329	aumk:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)Laumk;
    //   9796: aload_2
    //   9797: aload 16
    //   9799: aload 19
    //   9801: invokevirtual 3332	aumk:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/Integer;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9804: goto +1964 -> 11768
    //   9807: aload_0
    //   9808: aload_2
    //   9809: aload 19
    //   9811: invokevirtual 3334	arph:K	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9814: goto +1954 -> 11768
    //   9817: aload_0
    //   9818: aload_2
    //   9819: aload 19
    //   9821: invokevirtual 3336	arph:L	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9824: goto +1944 -> 11768
    //   9827: aload_2
    //   9828: getstatic 2170	com/tencent/mobileqq/app/QQManagerFactory:QQSTORY_MANAGER	I
    //   9831: invokevirtual 166	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   9834: checkcast 2172	vzv
    //   9837: getfield 2175	vzv:a	Lwie;
    //   9840: aload_2
    //   9841: aload 19
    //   9843: invokevirtual 3337	wie:a	(Lcom/tencent/common/app/AppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9846: goto +1922 -> 11768
    //   9849: aload_0
    //   9850: aload_2
    //   9851: aload 19
    //   9853: invokespecial 3339	arph:R	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9856: goto +1912 -> 11768
    //   9859: aload_2
    //   9860: aload 19
    //   9862: invokestatic 3341	arph:c	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9865: goto +1903 -> 11768
    //   9868: aload_2
    //   9869: aload 16
    //   9871: invokevirtual 1895	java/lang/Integer:intValue	()I
    //   9874: aload 19
    //   9876: invokestatic 3344	bixr:a	(Lcom/tencent/mobileqq/app/QQAppInterface;ILcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9879: goto +1889 -> 11768
    //   9882: aload_2
    //   9883: getstatic 2101	com/tencent/mobileqq/app/QQManagerFactory:TROOP_MANAGER	I
    //   9886: invokevirtual 166	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   9889: checkcast 2103	com/tencent/mobileqq/app/TroopManager
    //   9892: getfield 2191	com/tencent/mobileqq/app/TroopManager:jdField_a_of_type_Aahu	Laahu;
    //   9895: aload_2
    //   9896: aload 19
    //   9898: invokevirtual 3345	aahu:a	(Lcom/tencent/common/app/AppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9901: goto +1867 -> 11768
    //   9904: aload_0
    //   9905: aload_2
    //   9906: aload 19
    //   9908: aload 16
    //   9910: invokevirtual 1895	java/lang/Integer:intValue	()I
    //   9913: invokespecial 3346	arph:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;I)V
    //   9916: goto +1852 -> 11768
    //   9919: aload_2
    //   9920: aload 19
    //   9922: invokestatic 3348	arph:N	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9925: goto +1843 -> 11768
    //   9928: aload_0
    //   9929: aload_2
    //   9930: aload 19
    //   9932: invokespecial 3350	arph:Q	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9935: goto +1833 -> 11768
    //   9938: aload_2
    //   9939: getstatic 3353	com/tencent/mobileqq/app/QQManagerFactory:NOW_DYNAMIC_MANAGER	I
    //   9942: invokevirtual 166	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   9945: checkcast 3355	avux
    //   9948: aload 19
    //   9950: invokevirtual 3356	avux:a	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9953: goto +1815 -> 11768
    //   9956: aload_0
    //   9957: aload 19
    //   9959: invokespecial 3358	arph:C	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9962: goto +1806 -> 11768
    //   9965: aload_2
    //   9966: getstatic 3361	com/tencent/mobileqq/app/QQManagerFactory:GROUP_VIDEO_PLUGIN_MANAGER	I
    //   9969: invokevirtual 166	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   9972: checkcast 3363	avsv
    //   9975: aload 19
    //   9977: invokevirtual 3364	avsv:a	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9980: goto +1788 -> 11768
    //   9983: aload_0
    //   9984: aload_2
    //   9985: aload 19
    //   9987: invokespecial 3367	arph:aq	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9990: goto +1778 -> 11768
    //   9993: aload_0
    //   9994: aload_2
    //   9995: aload 19
    //   9997: aload 16
    //   9999: invokevirtual 1895	java/lang/Integer:intValue	()I
    //   10002: invokespecial 3369	arph:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;I)V
    //   10005: goto +1763 -> 11768
    //   10008: aload_0
    //   10009: aload_2
    //   10010: aload 19
    //   10012: invokespecial 3371	arph:as	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   10015: goto +1753 -> 11768
    //   10018: aload 4
    //   10020: ifnull +309 -> 10329
    //   10023: iload 10
    //   10025: ifne +32 -> 10057
    //   10028: aload_2
    //   10029: invokevirtual 65	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   10032: ldc_w 2696
    //   10035: invokestatic 2699	bhfn:a	(Landroid/content/Context;Ljava/lang/String;)Z
    //   10038: ifne +19 -> 10057
    //   10041: aload_2
    //   10042: getstatic 3374	com/tencent/mobileqq/app/QQManagerFactory:TIM_UPGRADE_DOWNLOAD_MANAGER	I
    //   10045: invokevirtual 166	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   10048: checkcast 3376	com/tencent/mobileqq/upgrade/UpgradeTIMManager
    //   10051: aload_2
    //   10052: aload 4
    //   10054: invokevirtual 3377	com/tencent/mobileqq/upgrade/UpgradeTIMManager:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/upgrade/UpgradeTIMWrapper;)V
    //   10057: invokestatic 2668	java/lang/System:currentTimeMillis	()J
    //   10060: lstore 14
    //   10062: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   10065: ifeq +44 -> 10109
    //   10068: ldc 189
    //   10070: iconst_2
    //   10071: new 85	java/lang/StringBuilder
    //   10074: dup
    //   10075: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   10078: ldc_w 3379
    //   10081: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10084: lload 14
    //   10086: lload 12
    //   10088: lsub
    //   10089: invokevirtual 3382	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   10092: ldc_w 3384
    //   10095: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10098: iload 10
    //   10100: invokevirtual 152	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   10103: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   10106: invokestatic 385	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   10109: aconst_null
    //   10110: astore 4
    //   10112: aload_3
    //   10113: ifnull +1621 -> 11734
    //   10116: aload_3
    //   10117: ldc_w 2388
    //   10120: iconst_0
    //   10121: invokevirtual 2323	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   10124: istore 10
    //   10126: iload 10
    //   10128: ifeq +220 -> 10348
    //   10131: aload_3
    //   10132: ldc_w 3386
    //   10135: iconst_0
    //   10136: invokevirtual 3389	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   10139: istore 8
    //   10141: ldc 189
    //   10143: iconst_2
    //   10144: iconst_2
    //   10145: anewarray 314	java/lang/Object
    //   10148: dup
    //   10149: iconst_0
    //   10150: ldc_w 3391
    //   10153: aastore
    //   10154: dup
    //   10155: iconst_1
    //   10156: iload 8
    //   10158: invokestatic 318	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   10161: aastore
    //   10162: invokestatic 1713	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   10165: iload 8
    //   10167: istore 6
    //   10169: iload 10
    //   10171: istore 5
    //   10173: aload 4
    //   10175: astore_3
    //   10176: iload 8
    //   10178: iconst_3
    //   10179: if_icmpge +179 -> 10358
    //   10182: aload_1
    //   10183: getfield 3394	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:next_req_types	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   10186: invokevirtual 1182	com/tencent/mobileqq/pb/PBRepeatField:get	()Ljava/util/List;
    //   10189: astore 16
    //   10191: iload 8
    //   10193: istore 6
    //   10195: iload 10
    //   10197: istore 5
    //   10199: aload 4
    //   10201: astore_3
    //   10202: aload 16
    //   10204: ifnull +154 -> 10358
    //   10207: iload 8
    //   10209: istore 6
    //   10211: iload 10
    //   10213: istore 5
    //   10215: aload 4
    //   10217: astore_3
    //   10218: aload 16
    //   10220: invokeinterface 412 1 0
    //   10225: ifle +133 -> 10358
    //   10228: aload 16
    //   10230: invokeinterface 412 1 0
    //   10235: newarray int
    //   10237: astore 4
    //   10239: aload 16
    //   10241: invokeinterface 412 1 0
    //   10246: istore 9
    //   10248: iconst_0
    //   10249: istore 7
    //   10251: iload 8
    //   10253: istore 6
    //   10255: iload 10
    //   10257: istore 5
    //   10259: aload 4
    //   10261: astore_3
    //   10262: iload 7
    //   10264: iload 9
    //   10266: if_icmpge +92 -> 10358
    //   10269: aload 16
    //   10271: iload 7
    //   10273: invokeinterface 461 2 0
    //   10278: checkcast 139	java/lang/Integer
    //   10281: invokevirtual 1895	java/lang/Integer:intValue	()I
    //   10284: istore 6
    //   10286: aload 4
    //   10288: iload 7
    //   10290: iload 6
    //   10292: iastore
    //   10293: aload 18
    //   10295: invokeinterface 412 1 0
    //   10300: ifle +20 -> 10320
    //   10303: aload 18
    //   10305: new 139	java/lang/Integer
    //   10308: dup
    //   10309: iload 6
    //   10311: invokespecial 2671	java/lang/Integer:<init>	(I)V
    //   10314: invokeinterface 2673 2 0
    //   10319: pop
    //   10320: iload 7
    //   10322: iconst_1
    //   10323: iadd
    //   10324: istore 7
    //   10326: goto -75 -> 10251
    //   10329: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   10332: ifeq -275 -> 10057
    //   10335: ldc_w 1850
    //   10338: iconst_2
    //   10339: ldc_w 3396
    //   10342: invokestatic 206	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   10345: goto -288 -> 10057
    //   10348: iconst_0
    //   10349: istore 6
    //   10351: aload 4
    //   10353: astore_3
    //   10354: iload 10
    //   10356: istore 5
    //   10358: aload 18
    //   10360: invokeinterface 246 1 0
    //   10365: astore 4
    //   10367: aload 4
    //   10369: invokeinterface 251 1 0
    //   10374: ifeq +1155 -> 11529
    //   10377: aload 4
    //   10379: invokeinterface 255 1 0
    //   10384: checkcast 139	java/lang/Integer
    //   10387: astore 16
    //   10389: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   10392: ifeq +46 -> 10438
    //   10395: ldc 189
    //   10397: iconst_2
    //   10398: new 85	java/lang/StringBuilder
    //   10401: dup
    //   10402: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   10405: ldc_w 3398
    //   10408: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10411: aload 16
    //   10413: invokevirtual 825	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   10416: ldc_w 2218
    //   10419: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10422: aload 18
    //   10424: invokeinterface 412 1 0
    //   10429: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   10432: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   10435: invokestatic 385	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   10438: aload 16
    //   10440: invokevirtual 1895	java/lang/Integer:intValue	()I
    //   10443: lookupswitch	default:+185->10628, 1:+645->11088, 38:+591->11034, 42:+924->11367, 46:+584->11027, 86:+878->11321, 87:+780->11223, 113:+932->11375, 116:+216->10659, 119:+994->11437, 156:+-76->10367, 185:+1021->11464, 188:+823->11266, 191:+1049->11492, 202:+1030->11473, 205:+860->11303, 206:+842->11285, 215:+1065->11508, 223:+978->11421, 297:+1071->11514, 345:+1078->11521, 364:+978->11421, 365:+978->11421
    //   10629: iconst_2
    //   10630: istore 25
    //   10632: bipush 182
    //   10634: iconst_4
    //   10635: dsub
    //   10636: invokevirtual 1337	aqxe:b	(I)Z
    //   10639: ifeq -272 -> 10367
    //   10642: invokestatic 1334	aqxe:a	()Laqxe;
    //   10645: aload 16
    //   10647: invokevirtual 1895	java/lang/Integer:intValue	()I
    //   10650: getstatic 15	arph:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   10653: invokevirtual 3399	aqxe:a	(ILjava/lang/String;)V
    //   10656: goto -289 -> 10367
    //   10659: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   10662: ifeq +12 -> 10674
    //   10665: ldc 189
    //   10667: iconst_2
    //   10668: ldc_w 3401
    //   10671: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   10674: aload_2
    //   10675: getstatic 1843	com/tencent/mobileqq/app/BusinessHandlerFactory:CONFIG_HANDLER	I
    //   10678: invokevirtual 219	com/tencent/mobileqq/app/QQAppInterface:getBusinessHandler	(I)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   10681: checkcast 1845	ansg
    //   10684: astore 17
    //   10686: ldc_w 2723
    //   10689: getstatic 15	arph:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   10692: invokestatic 3403	bgvv:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   10695: astore 19
    //   10697: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   10700: ifeq +30 -> 10730
    //   10703: ldc 189
    //   10705: iconst_2
    //   10706: new 85	java/lang/StringBuilder
    //   10709: dup
    //   10710: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   10713: ldc_w 2767
    //   10716: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10719: aload 19
    //   10721: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10724: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   10727: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   10730: aload 19
    //   10732: invokestatic 126	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   10735: ifeq +53 -> 10788
    //   10738: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   10741: ifeq +12 -> 10753
    //   10744: ldc 189
    //   10746: iconst_2
    //   10747: ldc_w 3405
    //   10750: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   10753: aload_2
    //   10754: invokevirtual 65	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   10757: getstatic 15	arph:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   10760: iconst_0
    //   10761: invokestatic 2730	bhhr:p	(Landroid/content/Context;Ljava/lang/String;I)V
    //   10764: ldc_w 2723
    //   10767: getstatic 15	arph:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   10770: invokestatic 2728	bgvv:a	(Ljava/lang/String;Ljava/lang/String;)Z
    //   10773: pop
    //   10774: aload 17
    //   10776: invokestatic 2518	bgvx:a	()Lbgvx;
    //   10779: invokevirtual 2521	bgvx:a	()Lcom/tencent/mobileqq/upgrade/UpgradeDetailWrapper;
    //   10782: invokevirtual 2524	ansg:a	(Lcom/tencent/mobileqq/upgrade/UpgradeDetailWrapper;)V
    //   10785: goto -418 -> 10367
    //   10788: invokestatic 2518	bgvx:a	()Lbgvx;
    //   10791: invokevirtual 2521	bgvx:a	()Lcom/tencent/mobileqq/upgrade/UpgradeDetailWrapper;
    //   10794: astore 16
    //   10796: aload 16
    //   10798: aload 19
    //   10800: invokevirtual 2733	com/tencent/mobileqq/upgrade/UpgradeDetailWrapper:a	(Ljava/lang/String;)V
    //   10803: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   10806: ifeq +42 -> 10848
    //   10809: ldc 189
    //   10811: iconst_2
    //   10812: ldc_w 2735
    //   10815: iconst_2
    //   10816: anewarray 314	java/lang/Object
    //   10819: dup
    //   10820: iconst_0
    //   10821: invokestatic 210	com/tencent/common/config/AppSetting:a	()I
    //   10824: invokestatic 318	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   10827: aastore
    //   10828: dup
    //   10829: iconst_1
    //   10830: aload 16
    //   10832: getfield 2738	com/tencent/mobileqq/upgrade/UpgradeDetailWrapper:jdField_b_of_type_ProtocolKQQConfigUpgradeInfo	Lprotocol/KQQConfig/UpgradeInfo;
    //   10835: getfield 2743	protocol/KQQConfig/UpgradeInfo:iUpgradeSdkId	I
    //   10838: invokestatic 318	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   10841: aastore
    //   10842: invokestatic 322	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   10845: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   10848: invokestatic 210	com/tencent/common/config/AppSetting:a	()I
    //   10851: aload 16
    //   10853: getfield 2738	com/tencent/mobileqq/upgrade/UpgradeDetailWrapper:jdField_b_of_type_ProtocolKQQConfigUpgradeInfo	Lprotocol/KQQConfig/UpgradeInfo;
    //   10856: getfield 2743	protocol/KQQConfig/UpgradeInfo:iUpgradeSdkId	I
    //   10859: if_icmplt +63 -> 10922
    //   10862: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   10865: ifeq +12 -> 10877
    //   10868: ldc 189
    //   10870: iconst_2
    //   10871: ldc_w 3407
    //   10874: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   10877: aload_2
    //   10878: invokevirtual 65	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   10881: getstatic 15	arph:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   10884: iconst_0
    //   10885: invokestatic 2730	bhhr:p	(Landroid/content/Context;Ljava/lang/String;I)V
    //   10888: ldc_w 2723
    //   10891: getstatic 15	arph:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   10894: invokestatic 2728	bgvv:a	(Ljava/lang/String;Ljava/lang/String;)Z
    //   10897: pop
    //   10898: aload 16
    //   10900: getfield 2738	com/tencent/mobileqq/upgrade/UpgradeDetailWrapper:jdField_b_of_type_ProtocolKQQConfigUpgradeInfo	Lprotocol/KQQConfig/UpgradeInfo;
    //   10903: iconst_0
    //   10904: putfield 2763	protocol/KQQConfig/UpgradeInfo:iUpgradeType	I
    //   10907: aload 17
    //   10909: aload 16
    //   10911: invokevirtual 2524	ansg:a	(Lcom/tencent/mobileqq/upgrade/UpgradeDetailWrapper;)V
    //   10914: aload 17
    //   10916: invokevirtual 2765	ansg:d	()V
    //   10919: goto -552 -> 10367
    //   10922: aload 16
    //   10924: monitorenter
    //   10925: aload 16
    //   10927: getfield 2775	com/tencent/mobileqq/upgrade/UpgradeDetailWrapper:jdField_a_of_type_Boolean	Z
    //   10930: ifne +30 -> 10960
    //   10933: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   10936: ifeq +12 -> 10948
    //   10939: ldc 189
    //   10941: iconst_2
    //   10942: ldc_w 2777
    //   10945: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   10948: aload 16
    //   10950: monitorexit
    //   10951: goto -584 -> 10367
    //   10954: astore_1
    //   10955: aload 16
    //   10957: monitorexit
    //   10958: aload_1
    //   10959: athrow
    //   10960: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   10963: ifeq +12 -> 10975
    //   10966: ldc 189
    //   10968: iconst_2
    //   10969: ldc_w 2779
    //   10972: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   10975: aload 16
    //   10977: getfield 2781	com/tencent/mobileqq/upgrade/UpgradeDetailWrapper:jdField_b_of_type_Int	I
    //   10980: ifne +21 -> 11001
    //   10983: aload 16
    //   10985: getfield 2782	com/tencent/mobileqq/upgrade/UpgradeDetailWrapper:jdField_a_of_type_Int	I
    //   10988: iconst_1
    //   10989: if_icmpne +32 -> 11021
    //   10992: iconst_1
    //   10993: istore 10
    //   10995: aload_2
    //   10996: iload 10
    //   10998: invokestatic 2783	ansg:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Z)V
    //   11001: invokestatic 2518	bgvx:a	()Lbgvx;
    //   11004: aload 16
    //   11006: getfield 2738	com/tencent/mobileqq/upgrade/UpgradeDetailWrapper:jdField_b_of_type_ProtocolKQQConfigUpgradeInfo	Lprotocol/KQQConfig/UpgradeInfo;
    //   11009: aload 17
    //   11011: invokevirtual 2786	bgvx:a	(Lprotocol/KQQConfig/UpgradeInfo;Lbgvz;)Z
    //   11014: pop
    //   11015: aload 16
    //   11017: monitorexit
    //   11018: goto -651 -> 10367
    //   11021: iconst_0
    //   11022: istore 10
    //   11024: goto -29 -> 10995
    //   11027: aload_2
    //   11028: invokestatic 2542	aclq:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   11031: goto -664 -> 10367
    //   11034: aload_2
    //   11035: invokevirtual 423	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   11038: invokestatic 3410	bhhr:b	(Ljava/lang/String;)Landroid/content/SharedPreferences;
    //   11041: astore 16
    //   11043: aload 16
    //   11045: invokeinterface 358 1 0
    //   11050: ldc_w 3412
    //   11053: invokeinterface 394 2 0
    //   11058: invokeinterface 748 1 0
    //   11063: pop
    //   11064: aload 16
    //   11066: invokeinterface 358 1 0
    //   11071: ldc_w 3414
    //   11074: invokeinterface 394 2 0
    //   11079: invokeinterface 748 1 0
    //   11084: pop
    //   11085: goto -718 -> 10367
    //   11088: new 85	java/lang/StringBuilder
    //   11091: dup
    //   11092: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   11095: aload_0
    //   11096: invokevirtual 47	arph:getAppRuntime	()Lmqq/app/AppRuntime;
    //   11099: invokevirtual 2692	mqq/app/AppRuntime:getApplication	()Lmqq/app/MobileQQ;
    //   11102: invokevirtual 2825	mqq/app/MobileQQ:getFilesDir	()Ljava/io/File;
    //   11105: invokevirtual 2828	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   11108: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11111: ldc_w 3416
    //   11114: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11117: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   11120: astore 16
    //   11122: new 2819	java/io/File
    //   11125: dup
    //   11126: aload 16
    //   11128: invokespecial 2831	java/io/File:<init>	(Ljava/lang/String;)V
    //   11131: astore 17
    //   11133: aload 17
    //   11135: ifnull -768 -> 10367
    //   11138: aload 17
    //   11140: invokevirtual 2834	java/io/File:exists	()Z
    //   11143: ifeq -776 -> 10367
    //   11146: aload 17
    //   11148: invokevirtual 2847	java/io/File:isDirectory	()Z
    //   11151: ifeq -784 -> 10367
    //   11154: aload 17
    //   11156: invokevirtual 2851	java/io/File:listFiles	()[Ljava/io/File;
    //   11159: astore 17
    //   11161: aload 17
    //   11163: ifnull -796 -> 10367
    //   11166: aload 17
    //   11168: arraylength
    //   11169: istore 8
    //   11171: iconst_0
    //   11172: istore 7
    //   11174: iload 7
    //   11176: iload 8
    //   11178: if_icmpge -811 -> 10367
    //   11181: aload 17
    //   11183: iload 7
    //   11185: aaload
    //   11186: astore 19
    //   11188: aload 19
    //   11190: ifnonnull +12 -> 11202
    //   11193: iload 7
    //   11195: iconst_1
    //   11196: iadd
    //   11197: istore 7
    //   11199: goto -25 -> 11174
    //   11202: new 3418	com/tencent/mobileqq/config/splashlogo/ConfigServlet$1
    //   11205: dup
    //   11206: aload_0
    //   11207: aload 19
    //   11209: aload 16
    //   11211: invokespecial 3421	com/tencent/mobileqq/config/splashlogo/ConfigServlet$1:<init>	(Larph;Ljava/io/File;Ljava/lang/String;)V
    //   11214: iconst_5
    //   11215: aconst_null
    //   11216: iconst_1
    //   11217: invokestatic 3427	com/tencent/mobileqq/app/ThreadManager:post	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   11220: goto -27 -> 11193
    //   11223: aload_2
    //   11224: getstatic 1735	com/tencent/mobileqq/app/QQManagerFactory:AR_RESOURCE_MANAGER	I
    //   11227: invokevirtual 166	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   11230: checkcast 1737	apgi
    //   11233: astore 16
    //   11235: aload 16
    //   11237: ifnull +10 -> 11247
    //   11240: aload 16
    //   11242: iconst_1
    //   11243: iconst_0
    //   11244: invokevirtual 2585	apgi:a	(ZZ)V
    //   11247: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11250: ifeq -883 -> 10367
    //   11253: ldc_w 1764
    //   11256: iconst_2
    //   11257: ldc_w 3429
    //   11260: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   11263: goto -896 -> 10367
    //   11266: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11269: ifeq -902 -> 10367
    //   11272: ldc_w 3431
    //   11275: iconst_2
    //   11276: ldc_w 3433
    //   11279: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   11282: goto -915 -> 10367
    //   11285: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11288: ifeq -921 -> 10367
    //   11291: ldc 189
    //   11293: iconst_2
    //   11294: ldc_w 3435
    //   11297: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   11300: goto -933 -> 10367
    //   11303: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11306: ifeq -939 -> 10367
    //   11309: ldc 189
    //   11311: iconst_2
    //   11312: ldc_w 3437
    //   11315: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   11318: goto -951 -> 10367
    //   11321: aload_2
    //   11322: getstatic 1694	com/tencent/mobileqq/app/QQManagerFactory:OLYMPIC_MANAGER	I
    //   11325: invokevirtual 166	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   11328: checkcast 1696	com/tencent/mobileqq/olympic/OlympicManager
    //   11331: astore 16
    //   11333: aload 16
    //   11335: ifnull +13 -> 11348
    //   11338: aload 16
    //   11340: invokevirtual 2593	com/tencent/mobileqq/olympic/OlympicManager:f	()V
    //   11343: aload 16
    //   11345: invokevirtual 2595	com/tencent/mobileqq/olympic/OlympicManager:g	()V
    //   11348: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11351: ifeq -984 -> 10367
    //   11354: ldc_w 1720
    //   11357: iconst_2
    //   11358: ldc_w 3439
    //   11361: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   11364: goto -997 -> 10367
    //   11367: aload_0
    //   11368: aconst_null
    //   11369: invokespecial 3062	arph:p	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   11372: goto -1005 -> 10367
    //   11375: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11378: ifeq +12 -> 11390
    //   11381: ldc 189
    //   11383: iconst_2
    //   11384: ldc_w 2602
    //   11387: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   11390: aload_2
    //   11391: getstatic 2605	com/tencent/mobileqq/app/QQManagerFactory:PRECOVER_MANAGER	I
    //   11394: invokevirtual 166	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   11397: checkcast 2607	azod
    //   11400: astore 16
    //   11402: aload 16
    //   11404: ifnull -1037 -> 10367
    //   11407: aload 16
    //   11409: invokevirtual 2608	azod:a	()V
    //   11412: aload 16
    //   11414: iconst_1
    //   11415: invokevirtual 2609	azod:a	(Z)V
    //   11418: goto -1051 -> 10367
    //   11421: aload_2
    //   11422: invokestatic 1558	com/tencent/mobileqq/utils/BusinessCommonConfig:getInstance	(Lmqq/app/AppRuntime;)Lcom/tencent/mobileqq/utils/BusinessCommonConfig;
    //   11425: aload_2
    //   11426: aload 16
    //   11428: invokevirtual 1895	java/lang/Integer:intValue	()I
    //   11431: invokevirtual 3442	com/tencent/mobileqq/utils/BusinessCommonConfig:handleResp_Config_NoResp	(Lcom/tencent/mobileqq/app/QQAppInterface;I)V
    //   11434: goto -1067 -> 10367
    //   11437: aload_2
    //   11438: getstatic 1857	com/tencent/mobileqq/app/BusinessHandlerFactory:BABY_Q_HANDLER	I
    //   11441: invokevirtual 219	com/tencent/mobileqq/app/QQAppInterface:getBusinessHandler	(I)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   11444: checkcast 1859	anqn
    //   11447: astore 16
    //   11449: aload 16
    //   11451: ifnull -1084 -> 10367
    //   11454: aload 16
    //   11456: iconst_0
    //   11457: iconst_0
    //   11458: invokevirtual 2600	anqn:a	(ZZ)V
    //   11461: goto -1094 -> 10367
    //   11464: invokestatic 2653	com/tencent/mobileqq/scribble/ScribbleResMgr:a	()Lcom/tencent/mobileqq/scribble/ScribbleResMgr;
    //   11467: invokevirtual 3443	com/tencent/mobileqq/scribble/ScribbleResMgr:a	()V
    //   11470: goto -1103 -> 10367
    //   11473: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11476: ifeq -1109 -> 10367
    //   11479: ldc_w 2430
    //   11482: iconst_2
    //   11483: ldc_w 3445
    //   11486: invokestatic 206	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   11489: goto -1122 -> 10367
    //   11492: aload_2
    //   11493: getstatic 3448	com/tencent/mobileqq/app/QQManagerFactory:APP_GUIDE_TIPS_MANAGER	I
    //   11496: invokevirtual 166	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   11499: checkcast 3450	afpn
    //   11502: invokevirtual 3451	afpn:a	()V
    //   11505: goto -1138 -> 10367
    //   11508: invokestatic 3452	com/tencent/mobileqq/shortvideo/ShortVideoResourceManager:b	()V
    //   11511: goto -1144 -> 10367
    //   11514: iconst_1
    //   11515: invokestatic 3453	arvo:a	(Z)V
    //   11518: goto -1151 -> 10367
    //   11521: aload_2
    //   11522: iconst_1
    //   11523: invokestatic 3454	bixr:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Z)V
    //   11526: goto -1159 -> 10367
    //   11529: iload 5
    //   11531: ifeq +202 -> 11733
    //   11534: iload 6
    //   11536: iconst_3
    //   11537: if_icmpge +196 -> 11733
    //   11540: aload_3
    //   11541: ifnull +192 -> 11733
    //   11544: aload_3
    //   11545: arraylength
    //   11546: ifle +187 -> 11733
    //   11549: new 85	java/lang/StringBuilder
    //   11552: dup
    //   11553: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   11556: astore 4
    //   11558: aload 4
    //   11560: ldc_w 3456
    //   11563: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11566: pop
    //   11567: aload_3
    //   11568: arraylength
    //   11569: istore 8
    //   11571: iconst_0
    //   11572: istore 7
    //   11574: iload 7
    //   11576: iload 8
    //   11578: if_icmpge +28 -> 11606
    //   11581: aload 4
    //   11583: aload_3
    //   11584: iload 7
    //   11586: iaload
    //   11587: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   11590: ldc_w 3458
    //   11593: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11596: pop
    //   11597: iload 7
    //   11599: iconst_1
    //   11600: iadd
    //   11601: istore 7
    //   11603: goto -29 -> 11574
    //   11606: ldc 189
    //   11608: iconst_1
    //   11609: aload 4
    //   11611: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   11614: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   11617: new 1287	mqq/app/NewIntent
    //   11620: dup
    //   11621: aload_2
    //   11622: invokevirtual 65	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   11625: ldc 2
    //   11627: invokespecial 1290	mqq/app/NewIntent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   11630: astore 4
    //   11632: aload 4
    //   11634: ldc_w 1292
    //   11637: aload_3
    //   11638: invokevirtual 1296	mqq/app/NewIntent:putExtra	(Ljava/lang/String;[I)Landroid/content/Intent;
    //   11641: pop
    //   11642: aload 4
    //   11644: ldc_w 1302
    //   11647: getstatic 15	arph:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   11650: invokevirtual 1305	mqq/app/NewIntent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   11653: pop
    //   11654: aload 4
    //   11656: ldc_w 2319
    //   11659: iconst_1
    //   11660: invokevirtual 2391	mqq/app/NewIntent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   11663: pop
    //   11664: aload_1
    //   11665: getfield 3459	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:cookies	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   11668: invokevirtual 1165	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   11671: ifeq +22 -> 11693
    //   11674: aload 4
    //   11676: ldc_w 2328
    //   11679: aload_1
    //   11680: getfield 3459	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:cookies	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   11683: invokevirtual 273	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   11686: invokevirtual 279	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   11689: invokevirtual 3462	mqq/app/NewIntent:putExtra	(Ljava/lang/String;[B)Landroid/content/Intent;
    //   11692: pop
    //   11693: aload 4
    //   11695: ldc_w 2388
    //   11698: iload 5
    //   11700: invokevirtual 2391	mqq/app/NewIntent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   11703: pop
    //   11704: aload 4
    //   11706: ldc_w 3386
    //   11709: iload 6
    //   11711: iconst_1
    //   11712: iadd
    //   11713: invokevirtual 2386	mqq/app/NewIntent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   11716: pop
    //   11717: aload 4
    //   11719: ldc_w 2385
    //   11722: iconst_0
    //   11723: invokevirtual 2386	mqq/app/NewIntent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   11726: pop
    //   11727: aload_2
    //   11728: aload 4
    //   11730: invokevirtual 1315	com/tencent/mobileqq/app/QQAppInterface:startServlet	(Lmqq/app/NewIntent;)V
    //   11733: return
    //   11734: iconst_0
    //   11735: istore 5
    //   11737: iconst_0
    //   11738: istore 6
    //   11740: aload 4
    //   11742: astore_3
    //   11743: goto -1385 -> 10358
    //   11746: aconst_null
    //   11747: astore 16
    //   11749: goto -4616 -> 7133
    //   11752: aload 4
    //   11754: astore 16
    //   11756: goto -7894 -> 3862
    //   11759: aconst_null
    //   11760: astore 16
    //   11762: goto -8030 -> 3732
    //   11765: goto -8193 -> 3572
    //   11768: aload 4
    //   11770: astore 16
    //   11772: iload 10
    //   11774: istore 11
    //   11776: goto -9672 -> 2104
    //   11779: aconst_null
    //   11780: astore 16
    //   11782: goto -8050 -> 3732
    //   11785: astore 17
    //   11787: goto -7816 -> 3971
    //   11790: iconst_0
    //   11791: istore 10
    //   11793: goto -7170 -> 4623
    //   11796: iload 7
    //   11798: iconst_1
    //   11799: iadd
    //   11800: istore 7
    //   11802: goto -7067 -> 4735
    //   11805: goto -37 -> 11768
    //   11808: iload 7
    //   11810: iconst_1
    //   11811: iadd
    //   11812: istore 7
    //   11814: goto -6890 -> 4924
    //   11817: goto -49 -> 11768
    //   11820: iload 7
    //   11822: iconst_1
    //   11823: iadd
    //   11824: istore 7
    //   11826: goto -6463 -> 5363
    //   11829: goto -61 -> 11768
    //   11832: goto -64 -> 11768
    //   11835: iload 7
    //   11837: iconst_1
    //   11838: iadd
    //   11839: istore 7
    //   11841: goto -5560 -> 6281
    //   11844: iload 8
    //   11846: istore 7
    //   11848: goto -5020 -> 6828
    //   11851: goto -83 -> 11768
    //   11854: goto -86 -> 11768
    //   11857: goto -89 -> 11768
    //   11860: goto -92 -> 11768
    //   11863: goto -95 -> 11768
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	11866	0	this	arph
    //   0	11866	1	paramRespGetConfig	ConfigurationService.RespGetConfig
    //   0	11866	2	paramQQAppInterface	QQAppInterface
    //   0	11866	3	paramIntent	Intent
    //   0	11866	4	paramArrayOfInt	int[]
    //   0	11866	5	paramBoolean	boolean
    //   361	11378	6	i	int
    //   53	11794	7	j	int
    //   357	11488	8	k	int
    //   68	10199	9	m	int
    //   2065	9727	10	bool1	boolean
    //   2098	9677	11	bool2	boolean
    //   2002	8085	12	l1	long
    //   10060	25	14	l2	long
    //   2102	1761	16	localObject1	Object
    //   3869	9	16	localUnsupportedEncodingException	UnsupportedEncodingException
    //   3885	9	16	localOutOfMemoryError	OutOfMemoryError
    //   3913	1	16	str1	String
    //   3918	1	16	localThrowable1	Throwable
    //   3921	612	16	localObject2	Object
    //   4657	6	16	localObject3	Object
    //   4761	3162	16	localObject4	Object
    //   8001	39	16	localException1	Exception
    //   8121	13	16	localIterator1	Iterator
    //   8212	617	16	localException2	Exception
    //   9267	177	16	localObject5	Object
    //   9691	307	16	localThrowable2	Throwable
    //   10189	1592	16	localObject6	Object
    //   3592	314	17	localObject7	Object
    //   3969	33	17	localException3	Exception
    //   4117	543	17	localUpgradeDetailWrapper	com.tencent.mobileqq.upgrade.UpgradeDetailWrapper
    //   4665	1	17	localException4	Exception
    //   5227	5955	17	localObject8	Object
    //   11785	1	17	localException5	Exception
    //   2023	8400	18	localArrayList	ArrayList
    //   2089	9119	19	localObject9	Object
    //   6492	223	20	localObject10	Object
    //   6538	13	21	localIterator2	Iterator
    //   6560	55	22	str2	String
    // Exception table:
    //   from	to	target	type
    //   3718	3732	3869	java/io/UnsupportedEncodingException
    //   3718	3732	3885	java/lang/OutOfMemoryError
    //   3901	3915	3918	java/lang/Throwable
    //   3803	3847	3969	java/lang/Exception
    //   3847	3858	3969	java/lang/Exception
    //   3946	3962	3969	java/lang/Exception
    //   4556	4579	4657	finally
    //   4579	4582	4657	finally
    //   4588	4603	4657	finally
    //   4603	4620	4657	finally
    //   4623	4629	4657	finally
    //   4629	4651	4657	finally
    //   4659	4662	4657	finally
    //   4537	4556	4665	java/lang/Exception
    //   4662	4665	4665	java/lang/Exception
    //   7878	7912	8001	java/lang/Exception
    //   7912	7984	8001	java/lang/Exception
    //   7984	7998	8001	java/lang/Exception
    //   8047	8086	8001	java/lang/Exception
    //   8089	8123	8212	java/lang/Exception
    //   8123	8195	8212	java/lang/Exception
    //   8195	8209	8212	java/lang/Exception
    //   8258	8297	8212	java/lang/Exception
    //   9677	9688	9691	java/lang/Throwable
    //   10925	10948	10954	finally
    //   10948	10951	10954	finally
    //   10955	10958	10954	finally
    //   10960	10975	10954	finally
    //   10975	10992	10954	finally
    //   10995	11001	10954	finally
    //   11001	11018	10954	finally
    //   2211	3572	11785	java/lang/Exception
    //   3575	3621	11785	java/lang/Exception
    //   3629	3644	11785	java/lang/Exception
    //   3647	3680	11785	java/lang/Exception
    //   3685	3713	11785	java/lang/Exception
    //   3718	3732	11785	java/lang/Exception
    //   3737	3792	11785	java/lang/Exception
    //   3792	3799	11785	java/lang/Exception
    //   3871	3882	11785	java/lang/Exception
    //   3887	3898	11785	java/lang/Exception
    //   3898	3901	11785	java/lang/Exception
    //   3901	3915	11785	java/lang/Exception
    //   3926	3939	11785	java/lang/Exception
    //   4030	4046	11785	java/lang/Exception
    //   4053	4116	11785	java/lang/Exception
    //   4126	4145	11785	java/lang/Exception
    //   4145	4160	11785	java/lang/Exception
    //   4160	4170	11785	java/lang/Exception
    //   4173	4188	11785	java/lang/Exception
    //   4188	4268	11785	java/lang/Exception
    //   4268	4355	11785	java/lang/Exception
    //   4355	4384	11785	java/lang/Exception
    //   4384	4426	11785	java/lang/Exception
    //   4429	4476	11785	java/lang/Exception
    //   4476	4494	11785	java/lang/Exception
    //   4497	4508	11785	java/lang/Exception
    //   4515	4530	11785	java/lang/Exception
    //   4673	4689	11785	java/lang/Exception
    //   4692	4732	11785	java/lang/Exception
    //   4735	4813	11785	java/lang/Exception
    //   4813	4836	11785	java/lang/Exception
    //   4839	4878	11785	java/lang/Exception
    //   4881	4921	11785	java/lang/Exception
    //   4924	5002	11785	java/lang/Exception
    //   5002	5026	11785	java/lang/Exception
    //   5029	5068	11785	java/lang/Exception
    //   5071	5115	11785	java/lang/Exception
    //   5118	5192	11785	java/lang/Exception
    //   5192	5207	11785	java/lang/Exception
    //   5207	5279	11785	java/lang/Exception
    //   5279	5332	11785	java/lang/Exception
    //   5340	5360	11785	java/lang/Exception
    //   5382	5396	11785	java/lang/Exception
    //   5399	5438	11785	java/lang/Exception
    //   5438	5485	11785	java/lang/Exception
    //   5490	5496	11785	java/lang/Exception
    //   5496	5519	11785	java/lang/Exception
    //   5522	5562	11785	java/lang/Exception
    //   5562	5634	11785	java/lang/Exception
    //   5634	5648	11785	java/lang/Exception
    //   5651	5670	11785	java/lang/Exception
    //   5675	5685	11785	java/lang/Exception
    //   5685	5847	11785	java/lang/Exception
    //   5850	5889	11785	java/lang/Exception
    //   5889	5920	11785	java/lang/Exception
    //   5925	5935	11785	java/lang/Exception
    //   5935	6009	11785	java/lang/Exception
    //   6012	6095	11785	java/lang/Exception
    //   6095	6109	11785	java/lang/Exception
    //   6112	6151	11785	java/lang/Exception
    //   6151	6224	11785	java/lang/Exception
    //   6224	6247	11785	java/lang/Exception
    //   6250	6278	11785	java/lang/Exception
    //   6281	6359	11785	java/lang/Exception
    //   6359	6367	11785	java/lang/Exception
    //   6372	6380	11785	java/lang/Exception
    //   6383	6430	11785	java/lang/Exception
    //   6433	6472	11785	java/lang/Exception
    //   6475	6540	11785	java/lang/Exception
    //   6540	6612	11785	java/lang/Exception
    //   6612	6637	11785	java/lang/Exception
    //   6640	6679	11785	java/lang/Exception
    //   6679	6708	11785	java/lang/Exception
    //   6711	6758	11785	java/lang/Exception
    //   6758	6771	11785	java/lang/Exception
    //   6774	6789	11785	java/lang/Exception
    //   6792	6805	11785	java/lang/Exception
    //   6810	6828	11785	java/lang/Exception
    //   6828	6929	11785	java/lang/Exception
    //   6929	6938	11785	java/lang/Exception
    //   6941	6972	11785	java/lang/Exception
    //   6981	7015	11785	java/lang/Exception
    //   7018	7062	11785	java/lang/Exception
    //   7069	7101	11785	java/lang/Exception
    //   7104	7133	11785	java/lang/Exception
    //   7138	7211	11785	java/lang/Exception
    //   7211	7225	11785	java/lang/Exception
    //   7225	7297	11785	java/lang/Exception
    //   7297	7305	11785	java/lang/Exception
    //   7305	7327	11785	java/lang/Exception
    //   7330	7376	11785	java/lang/Exception
    //   7379	7394	11785	java/lang/Exception
    //   7397	7404	11785	java/lang/Exception
    //   7407	7414	11785	java/lang/Exception
    //   7417	7424	11785	java/lang/Exception
    //   7427	7433	11785	java/lang/Exception
    //   7436	7442	11785	java/lang/Exception
    //   7445	7550	11785	java/lang/Exception
    //   7553	7592	11785	java/lang/Exception
    //   7595	7707	11785	java/lang/Exception
    //   7710	7766	11785	java/lang/Exception
    //   7769	7776	11785	java/lang/Exception
    //   7779	7786	11785	java/lang/Exception
    //   7789	7796	11785	java/lang/Exception
    //   7799	7806	11785	java/lang/Exception
    //   7809	7817	11785	java/lang/Exception
    //   7820	7827	11785	java/lang/Exception
    //   7830	7836	11785	java/lang/Exception
    //   7839	7845	11785	java/lang/Exception
    //   7848	7855	11785	java/lang/Exception
    //   7858	7875	11785	java/lang/Exception
    //   8003	8039	11785	java/lang/Exception
    //   8039	8044	11785	java/lang/Exception
    //   8214	8250	11785	java/lang/Exception
    //   8250	8255	11785	java/lang/Exception
    //   8300	8306	11785	java/lang/Exception
    //   8309	8315	11785	java/lang/Exception
    //   8318	8324	11785	java/lang/Exception
    //   8327	8333	11785	java/lang/Exception
    //   8336	8342	11785	java/lang/Exception
    //   8345	8351	11785	java/lang/Exception
    //   8354	8360	11785	java/lang/Exception
    //   8363	8369	11785	java/lang/Exception
    //   8372	8378	11785	java/lang/Exception
    //   8381	8387	11785	java/lang/Exception
    //   8390	8396	11785	java/lang/Exception
    //   8399	8405	11785	java/lang/Exception
    //   8408	8414	11785	java/lang/Exception
    //   8417	8423	11785	java/lang/Exception
    //   8426	8432	11785	java/lang/Exception
    //   8435	8441	11785	java/lang/Exception
    //   8444	8450	11785	java/lang/Exception
    //   8453	8459	11785	java/lang/Exception
    //   8462	8468	11785	java/lang/Exception
    //   8471	8477	11785	java/lang/Exception
    //   8480	8490	11785	java/lang/Exception
    //   8493	8499	11785	java/lang/Exception
    //   8502	8508	11785	java/lang/Exception
    //   8511	8517	11785	java/lang/Exception
    //   8520	8526	11785	java/lang/Exception
    //   8529	8619	11785	java/lang/Exception
    //   8619	8672	11785	java/lang/Exception
    //   8675	8725	11785	java/lang/Exception
    //   8728	8735	11785	java/lang/Exception
    //   8738	8754	11785	java/lang/Exception
    //   8757	8764	11785	java/lang/Exception
    //   8767	8774	11785	java/lang/Exception
    //   8777	8784	11785	java/lang/Exception
    //   8787	8794	11785	java/lang/Exception
    //   8797	8805	11785	java/lang/Exception
    //   8808	8815	11785	java/lang/Exception
    //   8818	8825	11785	java/lang/Exception
    //   8828	8842	11785	java/lang/Exception
    //   8845	8852	11785	java/lang/Exception
    //   8855	8871	11785	java/lang/Exception
    //   8874	8881	11785	java/lang/Exception
    //   8884	8891	11785	java/lang/Exception
    //   8894	8901	11785	java/lang/Exception
    //   8904	8911	11785	java/lang/Exception
    //   8914	8921	11785	java/lang/Exception
    //   8924	8931	11785	java/lang/Exception
    //   8934	8941	11785	java/lang/Exception
    //   8944	8951	11785	java/lang/Exception
    //   8954	8961	11785	java/lang/Exception
    //   8964	8969	11785	java/lang/Exception
    //   8972	8979	11785	java/lang/Exception
    //   8982	8989	11785	java/lang/Exception
    //   8992	8999	11785	java/lang/Exception
    //   9002	9009	11785	java/lang/Exception
    //   9012	9019	11785	java/lang/Exception
    //   9022	9029	11785	java/lang/Exception
    //   9032	9039	11785	java/lang/Exception
    //   9042	9049	11785	java/lang/Exception
    //   9052	9059	11785	java/lang/Exception
    //   9062	9081	11785	java/lang/Exception
    //   9084	9091	11785	java/lang/Exception
    //   9094	9101	11785	java/lang/Exception
    //   9104	9111	11785	java/lang/Exception
    //   9114	9121	11785	java/lang/Exception
    //   9124	9131	11785	java/lang/Exception
    //   9134	9141	11785	java/lang/Exception
    //   9144	9150	11785	java/lang/Exception
    //   9153	9160	11785	java/lang/Exception
    //   9163	9170	11785	java/lang/Exception
    //   9173	9180	11785	java/lang/Exception
    //   9183	9190	11785	java/lang/Exception
    //   9193	9200	11785	java/lang/Exception
    //   9203	9210	11785	java/lang/Exception
    //   9213	9220	11785	java/lang/Exception
    //   9223	9230	11785	java/lang/Exception
    //   9233	9240	11785	java/lang/Exception
    //   9243	9249	11785	java/lang/Exception
    //   9252	9269	11785	java/lang/Exception
    //   9274	9291	11785	java/lang/Exception
    //   9294	9311	11785	java/lang/Exception
    //   9316	9336	11785	java/lang/Exception
    //   9339	9346	11785	java/lang/Exception
    //   9349	9356	11785	java/lang/Exception
    //   9359	9366	11785	java/lang/Exception
    //   9369	9375	11785	java/lang/Exception
    //   9378	9384	11785	java/lang/Exception
    //   9387	9394	11785	java/lang/Exception
    //   9397	9403	11785	java/lang/Exception
    //   9406	9423	11785	java/lang/Exception
    //   9426	9438	11785	java/lang/Exception
    //   9443	9451	11785	java/lang/Exception
    //   9454	9461	11785	java/lang/Exception
    //   9464	9471	11785	java/lang/Exception
    //   9474	9481	11785	java/lang/Exception
    //   9484	9491	11785	java/lang/Exception
    //   9494	9501	11785	java/lang/Exception
    //   9504	9511	11785	java/lang/Exception
    //   9514	9521	11785	java/lang/Exception
    //   9524	9531	11785	java/lang/Exception
    //   9534	9541	11785	java/lang/Exception
    //   9544	9551	11785	java/lang/Exception
    //   9554	9561	11785	java/lang/Exception
    //   9564	9571	11785	java/lang/Exception
    //   9574	9581	11785	java/lang/Exception
    //   9584	9591	11785	java/lang/Exception
    //   9594	9600	11785	java/lang/Exception
    //   9603	9622	11785	java/lang/Exception
    //   9625	9644	11785	java/lang/Exception
    //   9647	9656	11785	java/lang/Exception
    //   9659	9674	11785	java/lang/Exception
    //   9677	9688	11785	java/lang/Exception
    //   9693	9698	11785	java/lang/Exception
    //   9701	9708	11785	java/lang/Exception
    //   9711	9718	11785	java/lang/Exception
    //   9721	9728	11785	java/lang/Exception
    //   9731	9738	11785	java/lang/Exception
    //   9741	9748	11785	java/lang/Exception
    //   9751	9765	11785	java/lang/Exception
    //   9768	9775	11785	java/lang/Exception
    //   9778	9789	11785	java/lang/Exception
    //   9792	9804	11785	java/lang/Exception
    //   9807	9814	11785	java/lang/Exception
    //   9817	9824	11785	java/lang/Exception
    //   9827	9846	11785	java/lang/Exception
    //   9849	9856	11785	java/lang/Exception
    //   9859	9865	11785	java/lang/Exception
    //   9868	9879	11785	java/lang/Exception
    //   9882	9901	11785	java/lang/Exception
    //   9904	9916	11785	java/lang/Exception
    //   9919	9925	11785	java/lang/Exception
    //   9928	9935	11785	java/lang/Exception
    //   9938	9953	11785	java/lang/Exception
    //   9956	9962	11785	java/lang/Exception
    //   9965	9980	11785	java/lang/Exception
    //   9983	9990	11785	java/lang/Exception
    //   9993	10005	11785	java/lang/Exception
    //   10008	10015	11785	java/lang/Exception
  }
  
  private void a(String paramString, int paramInt)
  {
    try
    {
      Object localObject = a(new ByteArrayInputStream(paramString.getBytes("utf-8")));
      if (localObject != null)
      {
        paramString = ((String)localObject).substring(((String)localObject).indexOf("<?xml"), ((String)localObject).indexOf("</msg><msg")) + "</msg>";
        if (QLog.isColorLevel()) {
          QLog.d("SPLASH_ConfigServlet", 2, "qav_upgrade_invite msg1 = " + paramString);
        }
        String str = ((String)localObject).substring(((String)localObject).indexOf("<?xml"), ((String)localObject).indexOf("?>")) + "?>";
        localObject = ((String)localObject).substring(((String)localObject).indexOf("</msg><msg"), ((String)localObject).lastIndexOf("</msg>"));
        str = str + ((String)localObject).substring(6) + "</msg>";
        if (QLog.isColorLevel()) {
          QLog.d("SPLASH_ConfigServlet", 2, "qav_upgrade_invite msg2 = " + str);
        }
        localObject = bhhr.b(((QQAppInterface)getAppRuntime()).getCurrentAccountUin());
        ((SharedPreferences)localObject).edit().putString("qav_upgrade_invite_video", paramString).commit();
        ((SharedPreferences)localObject).edit().putString("qav_upgrade_invite_multi", str).commit();
        bhhr.i(getAppRuntime().getApplication(), paramInt, jdField_a_of_type_JavaLangString);
      }
      return;
    }
    catch (Exception paramString)
    {
      do
      {
        paramString.printStackTrace();
      } while (!QLog.isColorLevel());
      QLog.i("SPLASH_ConfigServlet", 2, "parse qav_upgrade_invite xml  exception : " + paramString.getMessage());
    }
  }
  
  public static boolean a(arpt paramarpt, String paramString, Set<String> paramSet)
  {
    boolean bool2 = false;
    for (;;)
    {
      Document localDocument;
      String str1;
      int i;
      long l1;
      String str2;
      String str3;
      int k;
      Object localObject;
      long l2;
      long l3;
      boolean bool1;
      try
      {
        localDocument = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new ByteArrayInputStream(paramString.getBytes("utf-8")));
        NodeList localNodeList = localDocument.getElementsByTagName("pushbanner");
        str1 = "";
        i = 0;
        if (i < localNodeList.getLength())
        {
          l1 = Long.parseLong(localDocument.getElementsByTagName("channel").item(i).getFirstChild().getNodeValue());
          str2 = localDocument.getElementsByTagName("img").item(i).getFirstChild().getNodeValue();
          str3 = localDocument.getElementsByTagName("digest").item(i).getFirstChild().getNodeValue();
          k = Integer.parseInt(localDocument.getElementsByTagName("weight").item(i).getFirstChild().getNodeValue());
          localObject = localDocument.getElementsByTagName("md5").item(i).getFirstChild();
          if (localObject != null) {
            str1 = ((Node)localObject).getNodeValue();
          }
          localObject = localDocument.getElementsByTagName("end").item(i).getFirstChild().getNodeValue();
          SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
          l2 = localSimpleDateFormat.parse((String)localObject).getTime();
          l3 = localSimpleDateFormat.parse(localDocument.getElementsByTagName("begin").item(i).getFirstChild().getNodeValue()).getTime();
          if (System.currentTimeMillis() > l2)
          {
            if (QLog.isColorLevel()) {
              QLog.i("SPLASH_ConfigServlet", 2, "parseXML | NearbyBanner out of date, cid = " + l1 + ", endTime = " + (String)localObject);
            }
          }
          else if (str1.length() < 15)
          {
            if (!QLog.isColorLevel()) {
              break label758;
            }
            QLog.i("SPLASH_ConfigServlet", 2, "parseXML | NearbyBanner md5 length < 15, cid = " + l1);
          }
        }
      }
      catch (Exception paramarpt)
      {
        bool1 = bool2;
        if (QLog.isColorLevel())
        {
          QLog.i("SPLASH_ConfigServlet", 2, "parseXML | NearbyBanner parse exception,", paramarpt);
          bool1 = bool2;
        }
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SPLASH_ConfigServlet", 2, "parseNearbyBannerXml,result = " + bool1 + ",bannerContent =" + paramString);
        }
        return bool1;
        if ((paramSet != null) && (paramSet.contains(l1 + str1)))
        {
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.i("SPLASH_ConfigServlet", 2, "parseXML | NearbyBanner " + l1 + " had been closed, throw it");
          break;
        }
        localObject = new StringBuffer();
        int j = 0;
        while (j < localDocument.getElementsByTagName("url").item(i).getChildNodes().getLength())
        {
          ((StringBuffer)localObject).append(localDocument.getElementsByTagName("url").item(i).getChildNodes().item(j).getNodeValue());
          j += 1;
        }
        paramarpt.a(paramarpt.a(l1, str3, (byte)3, str2, ((StringBuffer)localObject).toString(), BaseApplication.getContext().getFilesDir().getAbsolutePath() + "/" + "NearbyBannerPic" + "/" + str1, l3 + "|" + l2, (short)k, str1));
        axqc.a(jdField_a_of_type_JavaLangString, "has_new_banner", Boolean.valueOf(true));
        break;
        bool1 = true;
      }
      label758:
      i += 1;
    }
  }
  
  private static byte[] a(ConfigurationService.ReqGetConfig paramReqGetConfig)
  {
    paramReqGetConfig = paramReqGetConfig.toByteArray();
    long l = paramReqGetConfig.length;
    byte[] arrayOfByte = new byte[(int)l + 4];
    PkgTools.DWord2Byte(arrayOfByte, 0, 4L + l);
    PkgTools.copyData(arrayOfByte, 4, paramReqGetConfig, (int)l);
    return arrayOfByte;
  }
  
  public static byte[] a(byte[] paramArrayOfByte)
  {
    int i = paramArrayOfByte.length - 4;
    byte[] arrayOfByte = new byte[i];
    PkgTools.copyData(arrayOfByte, 0, paramArrayOfByte, 4, i);
    return arrayOfByte;
  }
  
  public static int[] a()
  {
    return C2CPlusPanelAppConfigHelper.INSTANCE.getConfigTypes();
  }
  
  private void aa(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    for (;;)
    {
      try
      {
        j = paramConfig.version.get();
        k = bhhr.a(paramQQAppInterface.getApp(), "nearby_auth_video_config_version", jdField_a_of_type_JavaLangString);
        if (paramConfig.msg_content_list == null) {
          break label241;
        }
        i = paramConfig.msg_content_list.size();
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("SPLASH_ConfigServlet", 2, String.format("handleNearbyAuthVideoConfig, serverVersion[%s], localVersion[%s], size[%s]", new Object[] { Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(i) }));
      }
      catch (Exception paramQQAppInterface)
      {
        int j;
        int k;
        if (!QLog.isColorLevel()) {
          break label240;
        }
        QLog.e("SPLASH_ConfigServlet", 2, "received handleNearbyAuthVideoConfig error,cmd : 227", paramQQAppInterface);
        return;
        if (!QLog.isColorLevel()) {
          break label240;
        }
        QLog.d("SPLASH_ConfigServlet", 2, "GetDoodleTemplateConfig|type: handleNearbyAuthVideoConfig null");
        return;
        if (!QLog.isColorLevel()) {
          break label240;
        }
        QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 227,content_list is empty ,version: " + paramConfig.version.get());
        return;
        if (j != k) {
          continue;
        }
      }
      if (i > 0)
      {
        paramConfig = b(paramConfig, k, 227);
        if (!TextUtils.isEmpty(paramConfig))
        {
          axqn.a(paramConfig);
          bhhr.a(paramQQAppInterface.getApp(), "nearby_auth_video_config_version", jdField_a_of_type_JavaLangString, j);
          if (!QLog.isColorLevel()) {
            break label240;
          }
          QLog.d("SPLASH_ConfigServlet", 2, "GetDoodleTemplateConfig|type: handleNearbyAuthVideoConfig, content: \n" + paramConfig);
          return;
        }
      }
      label240:
      return;
      label241:
      int i = -1;
    }
  }
  
  private void ab(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    for (;;)
    {
      try
      {
        j = paramConfig.version.get();
        k = bhhr.a(paramQQAppInterface.getApp(), "nearby_videochat_dialog_config_version", jdField_a_of_type_JavaLangString);
        if (paramConfig.msg_content_list == null) {
          break label251;
        }
        i = paramConfig.msg_content_list.size();
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("SPLASH_ConfigServlet", 2, String.format("handleNearbyVideoChatDialogConfig, serverVersion[%s], localVersion[%s], size[%s]", new Object[] { Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(i) }));
      }
      catch (Exception paramQQAppInterface)
      {
        int j;
        int k;
        if (!QLog.isColorLevel()) {
          break label250;
        }
        QLog.e("SPLASH_ConfigServlet", 2, "received handleNearbyVideoChatDialogConfig error,cmd : 268", paramQQAppInterface);
        return;
        if (!QLog.isColorLevel()) {
          break label250;
        }
        QLog.d("SPLASH_ConfigServlet", 2, "GetDoodleTemplateConfig|type: handleNearbyVideoChatDialogConfig null");
        return;
        if (!QLog.isColorLevel()) {
          break label250;
        }
        QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 268,content_list is empty ,version: " + paramConfig.version.get());
        return;
        if (j != k) {
          continue;
        }
      }
      if (i > 0)
      {
        paramConfig = b(paramConfig, k, 268);
        if (!TextUtils.isEmpty(paramConfig))
        {
          ((bghm)paramQQAppInterface.getManager(QQManagerFactory.NEARBY_VIDEO_CHAT)).c(paramConfig);
          bhhr.a(paramQQAppInterface.getApp(), "nearby_videochat_dialog_config_version", jdField_a_of_type_JavaLangString, j);
          if (!QLog.isColorLevel()) {
            break label250;
          }
          QLog.d("SPLASH_ConfigServlet", 2, "GetDoodleTemplateConfig|type: handleNearbyVideoChatDialogConfig, content: \n" + paramConfig);
          return;
        }
      }
      label250:
      return;
      label251:
      int i = -1;
    }
  }
  
  private void ac(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    for (;;)
    {
      try
      {
        j = paramConfig.version.get();
        k = bhhr.a(paramQQAppInterface.getApp(), "nearby_videochat_banner_config_version", jdField_a_of_type_JavaLangString);
        if (paramConfig.msg_content_list == null) {
          break label251;
        }
        i = paramConfig.msg_content_list.size();
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("SPLASH_ConfigServlet", 2, String.format("handleNearbyVideoChatBannerConfig, serverVersion[%s], localVersion[%s], size[%s]", new Object[] { Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(i) }));
      }
      catch (Exception paramQQAppInterface)
      {
        int j;
        int k;
        if (!QLog.isColorLevel()) {
          break label250;
        }
        QLog.e("SPLASH_ConfigServlet", 2, "received handleNearbyVideoChatBannerConfig error,cmd : 269", paramQQAppInterface);
        return;
        if (!QLog.isColorLevel()) {
          break label250;
        }
        QLog.d("SPLASH_ConfigServlet", 2, "GetDoodleTemplateConfig|type: handleNearbyVideoChatBannerConfig null");
        return;
        if (!QLog.isColorLevel()) {
          break label250;
        }
        QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 269,content_list is empty ,version: " + paramConfig.version.get());
        return;
        if (j != k) {
          continue;
        }
      }
      if (i > 0)
      {
        paramConfig = b(paramConfig, k, 269);
        if (!TextUtils.isEmpty(paramConfig))
        {
          ((bghm)paramQQAppInterface.getManager(QQManagerFactory.NEARBY_VIDEO_CHAT)).b(paramConfig);
          bhhr.a(paramQQAppInterface.getApp(), "nearby_videochat_banner_config_version", jdField_a_of_type_JavaLangString, j);
          if (!QLog.isColorLevel()) {
            break label250;
          }
          QLog.d("SPLASH_ConfigServlet", 2, "GetDoodleTemplateConfig|type: handleNearbyVideoChatBannerConfig, content: \n" + paramConfig);
          return;
        }
      }
      label250:
      return;
      label251:
      int i = -1;
    }
  }
  
  private void ad(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    int k = paramConfig.version.get();
    paramQQAppInterface = paramQQAppInterface.getAccount();
    int i = bhhr.aQ(((QQAppInterface)getAppRuntime()).getApp(), paramQQAppInterface);
    if (!bohs.a()) {
      i = 0;
    }
    int j;
    if (paramConfig.msg_content_list != null)
    {
      j = paramConfig.msg_content_list.size();
      if (QLog.isColorLevel()) {
        QLog.d("QQSTORY_QUESTION_TAB_SPLASH_ConfigServlet", 2, String.format("问答Tab配置回包, serverVersion[%s], localVersion[%s], size[%s]", new Object[] { Integer.valueOf(k), Integer.valueOf(i), Integer.valueOf(j) }));
      }
      if (k != i) {
        break label112;
      }
    }
    label112:
    do
    {
      return;
      j = -1;
      break;
      if (j <= 0) {
        break label229;
      }
      paramConfig = b(paramConfig, i, 351);
      if (!TextUtils.isEmpty(paramConfig))
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQSTORY_QUESTION_TAB_SPLASH_ConfigServlet", 2, "GetQQStoryQuestionTabConfig|type: 问答Tab配置内容, content: \n" + paramConfig);
        }
        bhhr.ag(((QQAppInterface)getAppRuntime()).getApp(), paramQQAppInterface, k);
        new bomy().a(paramConfig, bohs.a.getAbsolutePath(), "temp_template_zip", new arpj(this));
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.d("QQSTORY_QUESTION_TAB_SPLASH_ConfigServlet", 2, "GetQQStoryQuestionTabConfig|type: 问答Tab配置回包内容为空");
    return;
    label229:
    if (QLog.isColorLevel()) {
      QLog.d("QQSTORY_QUESTION_TAB_SPLASH_ConfigServlet", 2, "GetQQStoryQuestionTabConfig|type: 问答Tab配置回包为空");
    }
    bohs.c();
  }
  
  private void ae(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    if ((paramConfig.content_list != null) && (paramConfig.content_list.size() > 0))
    {
      paramQQAppInterface = (PhoneContactManagerImp)paramQQAppInterface.getManager(QQManagerFactory.CONTACT_MANAGER);
      if (paramConfig.content_list.size() < 0)
      {
        str = (String)paramConfig.content_list.get(0);
        i = paramConfig.version.get();
        j = paramQQAppInterface.e();
        if (QLog.isColorLevel()) {
          QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 97,content: " + str + ",version: " + paramConfig.version.get());
        }
        if ((i != j) || (paramConfig.content_list.size() > 0)) {
          paramQQAppInterface.a(i, str);
        }
      }
    }
    while (!QLog.isColorLevel())
    {
      String str;
      int i;
      int j;
      return;
    }
    QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 97,content_list is empty ,version: " + paramConfig.version.get());
  }
  
  private void af(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    try
    {
      i = paramConfig.version.get();
      localanqn = (anqn)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.BABY_Q_HANDLER);
      j = localanqn.a(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount());
      if ((paramConfig.content_list != null) && (paramConfig.content_list.size() > 0))
      {
        paramQQAppInterface = (String)paramConfig.content_list.get(0);
        if (QLog.isColorLevel()) {
          QLog.d("babyqConfig", 2, "received BabyQPlusPanelConfig configVersion:" + i + " ,localVersion:" + j + " ,configContent" + paramQQAppInterface);
        }
        if (i != j)
        {
          localanqn.a(i, paramQQAppInterface);
          return;
        }
        localanqn.a(false, false);
        return;
      }
    }
    catch (Exception paramQQAppInterface)
    {
      int i;
      anqn localanqn;
      int j;
      if (QLog.isColorLevel())
      {
        QLog.e("babyqConfig", 2, "received BabyQPlusPanelConfig error", paramQQAppInterface);
        return;
        if (i == j) {
          if (QLog.isColorLevel()) {
            QLog.d("babyqConfig", 2, "received BabyQPlusPanelConfig, content_list is empty, ignored because of SAME VERSION");
          }
        }
        for (;;)
        {
          localanqn.a(false, false);
          return;
          if (QLog.isColorLevel()) {
            QLog.d("babyqConfig", 2, "received BabyQPlusPanelConfig, content_list is empty, use default config");
          }
        }
      }
    }
  }
  
  private void ag(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SPLASH_ConfigServlet", 2, "handleRespAddContactsViewConfig|type= " + paramConfig.type.get());
    }
    int j = paramConfig.version.get();
    if (j == bhhr.S(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin())) {
      if (QLog.isColorLevel()) {
        QLog.d("SPLASH_ConfigServlet", 2, "AddContactsViewConfig serverVersion is equals to localVersion ");
      }
    }
    do
    {
      do
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.d("SPLASH_ConfigServlet", 2, "AddContactsViewConfig contentlist:" + paramConfig.content_list);
        }
      } while ((paramConfig.content_list == null) || (paramConfig.content_list.size() <= 0));
      paramConfig = (String)paramConfig.content_list.get(0);
    } while (paramConfig == null);
    XmlPullParser localXmlPullParser = Xml.newPullParser();
    ConfigurationService.Config localConfig = null;
    for (;;)
    {
      try
      {
        localXmlPullParser.setInput(new ByteArrayInputStream(paramConfig.getBytes()), "utf-8");
        i = localXmlPullParser.getEventType();
      }
      catch (Exception paramQQAppInterface) {}
      int i = localXmlPullParser.next();
      localConfig = paramConfig;
      break label357;
      String str = localXmlPullParser.getName();
      paramConfig = localConfig;
      if (str != null)
      {
        paramConfig = localConfig;
        if (str.equalsIgnoreCase("entrencelist"))
        {
          paramConfig = localXmlPullParser.nextText();
          continue;
          if (QLog.isColorLevel()) {
            QLog.d("SPLASH_ConfigServlet", 2, "AddContactsView entrencelist:" + localConfig);
          }
          if ((localConfig == null) || (localConfig.length() <= 0)) {
            break;
          }
          if (QLog.isColorLevel()) {
            QLog.d("SPLASH_ConfigServlet", 2, "success");
          }
          bhhr.c(paramQQAppInterface.getApp(), j, paramQQAppInterface.getCurrentAccountUin(), localConfig);
          return;
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.e("SPLASH_ConfigServlet", 2, "AddContactsViewConfig appear exception:" + paramQQAppInterface.toString());
          return;
          label357:
          if (i != 1)
          {
            paramConfig = localConfig;
            switch (i)
            {
            }
            paramConfig = localConfig;
          }
        }
      }
    }
  }
  
  private void ah(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    ConfigurationService.Config localConfig = null;
    if (QLog.isColorLevel()) {
      QLog.d("SPLASH_ConfigServlet", 2, "handleRespClassicHeadConfig|type= " + paramConfig.type.get());
    }
    int j = paramConfig.version.get();
    if (j == bhhr.T(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin())) {
      if (QLog.isColorLevel()) {
        QLog.d("SPLASH_ConfigServlet", 2, "ClassicHeadConfig serverVersion is equals to localVersion ");
      }
    }
    label81:
    do
    {
      break label81;
      break label81;
      do
      {
        return;
      } while ((paramConfig.msg_content_list == null) || (paramConfig.msg_content_list.size() <= 0));
      if (QLog.isColorLevel()) {
        QLog.d("SPLASH_ConfigServlet", 2, "ClassicHeadConfig size:" + paramConfig.msg_content_list.size() + "ClassicHeadConfig content:" + paramConfig.msg_content_list.get(0));
      }
      paramConfig = (ConfigurationService.Content)paramConfig.msg_content_list.get(0);
    } while (paramConfig == null);
    if (paramConfig.compress.get() == 1)
    {
      paramConfig = ayym.a(paramConfig.content.get().toByteArray());
      if (paramConfig == null) {}
    }
    for (;;)
    {
      XmlPullParser localXmlPullParser;
      int i;
      try
      {
        paramConfig = new String(paramConfig, "UTF-8");
        if (paramConfig == null) {
          break label81;
        }
        if (QLog.isColorLevel()) {
          QLog.d("SPLASH_ConfigServlet", 2, "ClassicHead xmlContent = " + paramConfig);
        }
        localXmlPullParser = Xml.newPullParser();
        try
        {
          localXmlPullParser.setInput(new ByteArrayInputStream(paramConfig.getBytes()), "utf-8");
          i = localXmlPullParser.getEventType();
        }
        catch (Exception paramQQAppInterface) {}
        i = localXmlPullParser.next();
        localConfig = paramConfig;
      }
      catch (Throwable paramConfig)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SPLASH_ConfigServlet", 2, "Throwable:" + paramConfig.getMessage());
        }
        paramConfig = null;
        continue;
      }
      if (QLog.isColorLevel()) {
        QLog.d("SPLASH_ConfigServlet", 2, "inflateConfigString error!");
      }
      paramConfig = null;
      continue;
      paramConfig = paramConfig.content.get().toStringUtf8();
      continue;
      String str = localXmlPullParser.getName();
      if ((str != null) && (str.equalsIgnoreCase("beginTime")))
      {
        paramConfig = localXmlPullParser.nextText();
      }
      else
      {
        paramConfig = localConfig;
        if (str != null)
        {
          paramConfig = localConfig;
          if (str.equalsIgnoreCase("endTime"))
          {
            paramConfig = localConfig + "|" + localXmlPullParser.nextText();
            continue;
            do
            {
              if (QLog.isColorLevel()) {
                QLog.d("SPLASH_ConfigServlet", 2, "ClassicHead entrence:" + localConfig);
              }
              if ((localConfig == null) || (localConfig.length() <= 0)) {
                break;
              }
              if (QLog.isColorLevel()) {
                QLog.d("SPLASH_ConfigServlet", 2, "ClassicHead getContent success");
              }
              bhhr.d(paramQQAppInterface.getApp(), j, paramQQAppInterface.getCurrentAccountUin(), localConfig);
              paramQQAppInterface = (aozr)paramQQAppInterface.getManager(QQManagerFactory.CLASSIC_HEAD_ACIVITY_MANAGER);
              if (paramQQAppInterface == null) {
                break;
              }
              paramQQAppInterface.a();
              return;
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.e("SPLASH_ConfigServlet", 2, "ClassicHeadConfig appear exception:", paramQQAppInterface);
              return;
            } while (i == 1);
            paramConfig = localConfig;
            switch (i)
            {
            }
            paramConfig = localConfig;
          }
        }
      }
    }
  }
  
  private void ai(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    try
    {
      i = paramConfig.version.get();
      j = bhhr.D(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount());
      if ((paramConfig.content_list == null) || (paramConfig.content_list.size() <= 0)) {
        break label155;
      }
      paramConfig = (String)paramConfig.content_list.get(0);
      if (QLog.isColorLevel()) {
        QLog.d("HeadsUp", 2, "received Headsup Notify configVersion:" + i + " ,localVersion:" + j + " ,configContent" + paramConfig);
      }
      if (i == j) {
        return;
      }
      if (!paramConfig.contains("headsup_switch")) {
        break label246;
      }
      bool = paramConfig.split("=")[1].trim().equals("true");
    }
    catch (Exception paramQQAppInterface)
    {
      int i;
      int j;
      boolean bool;
      label155:
      while (QLog.isColorLevel())
      {
        QLog.e("HeadsUp", 2, "received Headsup Notify error", paramQQAppInterface);
        return;
        label246:
        bool = false;
      }
    }
    bhhr.a(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount(), i, true, bool);
    return;
    if (i != j)
    {
      bhhr.a(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount(), i, false, true);
      paramQQAppInterface.mqqService.jdField_a_of_type_Boolean = false;
    }
    if (QLog.isColorLevel())
    {
      QLog.d("HeadsUp", 2, "received Headsup Notify configVersion:" + i + " ,localVersion:" + j);
      return;
    }
  }
  
  private void aj(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    bbzh.jdField_a_of_type_JavaLangString = paramQQAppInterface.getCurrentAccountUin();
    int i = paramConfig.version.get();
    int j = bbzh.a(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin());
    if (QLog.isColorLevel()) {
      QLog.d("Q.uniteSearch.SearchNetEntryConfig", 2, "handleSearchNetEntryConfig, version: " + i + " localVersion: " + j);
    }
    if (i == j) {
      return;
    }
    bbzh.a(paramQQAppInterface.getApp(), i, paramQQAppInterface.getCurrentAccountUin());
    bbzh.a(paramQQAppInterface.getApp(), paramConfig, paramQQAppInterface.getCurrentUin());
  }
  
  private void ak(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Medal_SPLASH_ConfigServlet", 2, "handleMedalConfig|type= " + paramConfig.type.get());
    }
    int j = paramConfig.version.get();
    if ((paramConfig.content_list != null) && (paramConfig.content_list.size() > 0))
    {
      Object localObject = (String)paramConfig.content_list.get(0);
      if (QLog.isColorLevel()) {
        QLog.d("Medal_SPLASH_ConfigServlet", 2, "content" + (String)localObject);
      }
      if (localObject != null)
      {
        String str3 = "";
        String str4 = "";
        String str5 = "";
        String str2 = str5;
        String str1 = str4;
        paramConfig = str3;
        try
        {
          localObject = new JSONObject((String)localObject);
          str2 = str5;
          str1 = str4;
          paramConfig = str3;
          str3 = ((JSONObject)localObject).optString("hosturl", "");
          str2 = str5;
          str1 = str4;
          paramConfig = str3;
          str4 = ((JSONObject)localObject).optString("customurl", "");
          str2 = str5;
          str1 = str4;
          paramConfig = str3;
          str5 = ((JSONObject)localObject).optString("shareurl", "");
          str2 = str5;
          str1 = str4;
          paramConfig = str3;
          int i = ((JSONObject)localObject).optInt("entrance_visibility", 0);
          paramConfig = str3;
          str1 = str4;
          str2 = str5;
          return;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            try
            {
              ((MedalWallMng)paramQQAppInterface.getManager(QQManagerFactory.MEDAL_WALL_MNG)).a(i, paramConfig, str1, str2);
              bhhr.v(paramQQAppInterface.getApp(), j, paramQQAppInterface.getCurrentAccountUin());
              bhhr.w(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin(), i);
              return;
            }
            catch (Exception paramQQAppInterface)
            {
              if (!QLog.isColorLevel()) {
                return;
              }
              QLog.e("SPLASH_ConfigServlet", 2, paramQQAppInterface, new Object[0]);
            }
            localException = localException;
            if (QLog.isColorLevel()) {
              QLog.i("SPLASH_ConfigServlet", 2, localException.getMessage(), localException);
            }
            i = 0;
          }
        }
      }
    }
  }
  
  private void al(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    j = 0;
    int i = 0;
    k = 0;
    m = 0;
    Object localObject1 = null;
    Object localObject2 = null;
    int n = paramConfig.version.get();
    int i1 = bhhr.a(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, 2);
    if (n != i1)
    {
      if (paramConfig.msg_content_list.size() <= 0) {
        break label391;
      }
      paramConfig = (ConfigurationService.Content)paramConfig.msg_content_list.get(0);
      if (paramConfig != null) {
        break label266;
      }
      if (QLog.isColorLevel()) {
        QLog.d("SPLASH_ConfigServlet", 2, " handleMedalStrongReminderConfig content is null !");
      }
      i = 1;
      paramConfig = localObject2;
      j = i;
      k = m;
      if (TextUtils.isEmpty(paramConfig)) {}
    }
    for (;;)
    {
      for (;;)
      {
        try
        {
          localObject1 = new JSONObject(paramConfig);
          if (!((JSONObject)localObject1).has("medal_strong_reminder_off")) {
            continue;
          }
          j = ((JSONObject)localObject1).getInt("medal_strong_reminder_off");
          k = j;
          j = i;
        }
        catch (Exception localException)
        {
          label266:
          localException.printStackTrace();
          j = 5;
          k = m;
          continue;
        }
        if (j == 0)
        {
          bhhr.d(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, 3, k);
          if (paramQQAppInterface.isCreateManager(QQManagerFactory.MEDAL_WALL_MNG)) {
            ((MedalWallMng)paramQQAppInterface.getManager(QQManagerFactory.MEDAL_WALL_MNG)).a(k);
          }
        }
        bhhr.d(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, 2, n);
        localObject1 = paramConfig;
        if (QLog.isColorLevel()) {
          QLog.i("SPLASH_ConfigServlet", 2, String.format(Locale.getDefault(), "handleMedalStrongReminderConfig localVersion: %s, version: %s, result: %s, value: %s, strContent: %s", new Object[] { Integer.valueOf(i1), Integer.valueOf(n), Integer.valueOf(j), Integer.valueOf(k), localObject1 }));
        }
        return;
        if (paramConfig.compress.get() != 1) {
          continue;
        }
        paramConfig = ayym.a(paramConfig.content.get().toByteArray());
        if (paramConfig != null) {
          try
          {
            paramConfig = new String(paramConfig, "UTF-8");
            i = 0;
          }
          catch (Throwable paramConfig)
          {
            if (QLog.isColorLevel()) {
              QLog.d("SPLASH_ConfigServlet", 2, " handleMedalStrongReminderConfig Throwable:" + paramConfig.getMessage());
            }
            i = 2;
            paramConfig = null;
          }
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("SPLASH_ConfigServlet", 2, " handleMedalStrongReminderConfig inflateConfigString error!");
      }
      i = 3;
      paramConfig = null;
      continue;
      paramConfig = paramConfig.content.get().toStringUtf8();
      break;
      label391:
      i = 4;
      paramConfig = localObject2;
      break;
      i = 6;
      j = 0;
    }
  }
  
  private void am(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    int j = 0;
    int i = 0;
    Object localObject2 = null;
    Object localObject1 = null;
    for (;;)
    {
      try
      {
        int k = paramConfig.version.get();
        int m = ((Integer)bhhr.a(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, 2)).intValue();
        if (k != m)
        {
          if (paramConfig.msg_content_list.size() <= 0) {
            continue;
          }
          paramConfig = (ConfigurationService.Content)paramConfig.msg_content_list.get(0);
          if (paramConfig == null)
          {
            if (!QLog.isColorLevel()) {
              break label336;
            }
            QLog.d("SPLASH_ConfigServlet", 2, " handlePushRecommendShieldConfig content is null !");
            break label336;
            if (i == 0)
            {
              bhhr.a(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, 3, localObject1);
              if (paramQQAppInterface.isCreateManager(QQManagerFactory.MAYKNOW_RECOMMEND_MANAGER)) {
                ((anyb)paramQQAppInterface.getManager(QQManagerFactory.MAYKNOW_RECOMMEND_MANAGER)).a((String)localObject1);
              }
            }
            bhhr.a(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, 2, Integer.valueOf(k));
          }
        }
        else
        {
          if (!QLog.isColorLevel()) {
            break label355;
          }
          QLog.i("SPLASH_ConfigServlet", 2, String.format(Locale.getDefault(), "handlePushRecommendShieldConfig localVersion: %s, version: %s, result: %s, strContent: %s", new Object[] { Integer.valueOf(m), Integer.valueOf(k), Integer.valueOf(i), localObject1 }));
          return;
        }
        if (paramConfig.compress.get() == 1)
        {
          paramConfig = ayym.a(paramConfig.content.get().toByteArray());
          if (paramConfig != null)
          {
            try
            {
              paramConfig = new String(paramConfig, "UTF-8");
              i = 0;
            }
            catch (Throwable paramConfig)
            {
              if (!QLog.isColorLevel()) {
                break label356;
              }
            }
            QLog.d("SPLASH_ConfigServlet", 2, " handlePushRecommendShieldConfig Throwable:" + paramConfig.getMessage());
            break label356;
          }
          else
          {
            if (!QLog.isColorLevel()) {
              break label363;
            }
            QLog.d("SPLASH_ConfigServlet", 2, " handlePushRecommendShieldConfig inflateConfigString error!");
            break label363;
          }
        }
        else
        {
          paramConfig = paramConfig.content.get().toStringUtf8();
          i = j;
          break label341;
          i = 4;
          paramConfig = localObject2;
        }
      }
      catch (Throwable paramQQAppInterface)
      {
        paramQQAppInterface.printStackTrace();
        return;
      }
      label336:
      i = 1;
      paramConfig = localObject2;
      label341:
      localObject1 = paramConfig;
      if (paramConfig == null)
      {
        localObject1 = "";
        continue;
        label355:
        return;
        label356:
        paramConfig = null;
        i = 2;
        continue;
        label363:
        paramConfig = null;
        i = 3;
      }
    }
  }
  
  private void an(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    Object localObject3 = null;
    Object localObject1 = localObject3;
    Object localObject4;
    if (paramConfig.msg_content_list != null)
    {
      localObject1 = localObject3;
      if (paramConfig.msg_content_list.size() > 0)
      {
        localObject4 = (ConfigurationService.Content)paramConfig.msg_content_list.get(0);
        localObject1 = localObject3;
        if (localObject4 != null)
        {
          if (((ConfigurationService.Content)localObject4).compress.get() != 1) {
            break label460;
          }
          localObject3 = ayym.a(((ConfigurationService.Content)localObject4).content.get().toByteArray());
          if (localObject3 == null) {
            break label521;
          }
        }
      }
    }
    for (;;)
    {
      try
      {
        localObject1 = new String((byte[])localObject3, "UTF-8");
        localObject3 = BaseApplicationImpl.getApplication().getSharedPreferences("DynamicAdjustment", 4).edit();
        try
        {
          if (!TextUtils.isEmpty((CharSequence)localObject1))
          {
            if (QLog.isColorLevel()) {
              QLog.d("SPLASH_ConfigServlet", 2, "SVDNAdjustment config : " + (String)localObject1);
            }
            localObject4 = new JSONObject((String)localObject1).getJSONObject("SVDNAdjustment").getJSONArray("configs").getJSONObject(0).getJSONObject("config");
            ((SharedPreferences.Editor)localObject3).putFloat("SVDNAdjustment_data_type", (float)((JSONObject)localObject4).optDouble("data_type", 0.5D));
            ((SharedPreferences.Editor)localObject3).putInt("SVDNAdjustment_max_downmark", ((JSONObject)localObject4).optInt("max_downmark", 2));
            ((SharedPreferences.Editor)localObject3).putInt("SVDNAdjustment_max_upmark", ((JSONObject)localObject4).optInt("max_upmark", 2));
            ((SharedPreferences.Editor)localObject3).putInt("SVDNAdjustment_up_threshold_base", ((JSONObject)localObject4).optInt("up_threshold_base", 11));
            ((SharedPreferences.Editor)localObject3).putInt("SVDNAdjustment_down_threshold_base", ((JSONObject)localObject4).optInt("down_threshold_base", 25));
            ((SharedPreferences.Editor)localObject3).putInt("SVDNAdjustment_quality_up_threshold", ((JSONObject)localObject4).optInt("up_threshold_base", 11));
            ((SharedPreferences.Editor)localObject3).putInt("SVDNAdjustment_quality_down_threshold", ((JSONObject)localObject4).optInt("down_threshold_base", 25));
            ((SharedPreferences.Editor)localObject3).putFloat("SVDNAdjustment_up_threshold_coefficient", (float)((JSONObject)localObject4).optDouble("up_threshold_coefficient", 0.7D));
            ((SharedPreferences.Editor)localObject3).putFloat("SVDNAdjustment_down_threshold_coefficient", (float)((JSONObject)localObject4).optDouble("down_threshold_coefficient", 1.3D));
            ((SharedPreferences.Editor)localObject3).commit();
          }
        }
        catch (Exception localException)
        {
          Object localObject2;
          String str1;
          if (!QLog.isColorLevel()) {
            break label513;
          }
          QLog.e("SPLASH_ConfigServlet", 2, "error: " + localException.toString());
          localException.printStackTrace();
          continue;
        }
        also.a();
        also.a((String)localObject1);
        bhhr.u(paramQQAppInterface.getApp(), paramConfig.version.get(), jdField_a_of_type_JavaLangString);
        return;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        if (QLog.isColorLevel()) {
          localUnsupportedEncodingException.printStackTrace();
        }
        localObject2 = null;
        continue;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        if (QLog.isColorLevel()) {
          localOutOfMemoryError.printStackTrace();
        }
        System.gc();
        try
        {
          str1 = new String((byte[])localObject3, "UTF-8");
        }
        catch (Throwable localThrowable)
        {
          str2 = null;
        }
        continue;
      }
      label460:
      String str2 = ((ConfigurationService.Content)localObject4).content.get().toStringUtf8();
      continue;
      label513:
      label521:
      str2 = null;
    }
  }
  
  private void ao(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    int i = paramQQAppInterface.getPreferences().getInt("new_troop_recommend", 0);
    int j = paramConfig.version.get();
    QLog.w("SPLASH_ConfigServlet", 1, "handleNewTroopRecommend, localVersion:" + i + ",serverVersion:" + j);
    if (i != j)
    {
      if ((paramConfig.msg_content_list == null) || (paramConfig.msg_content_list.size() <= 0)) {
        break label231;
      }
      paramConfig = (ConfigurationService.Content)paramConfig.msg_content_list.get(0);
      if (paramConfig == null) {
        break label221;
      }
      if (paramConfig.compress.get() != 1) {
        break label197;
      }
      paramConfig = ayym.a(paramConfig.content.get().toByteArray());
      if (paramConfig == null) {
        break label241;
      }
    }
    for (;;)
    {
      try
      {
        paramConfig = new String(paramConfig, "UTF-8");
        if (TextUtils.isEmpty(paramConfig)) {
          break label211;
        }
        ((aoce)paramQQAppInterface.getManager(QQManagerFactory.RECOMMEND_TROOP_MANAGER)).a(paramConfig, j);
        return;
      }
      catch (Exception paramConfig)
      {
        QLog.e("Q.lebanew", 1, "handleNewTroopRecommend uncompress failed" + paramConfig);
        paramConfig = null;
        continue;
      }
      label197:
      paramConfig = paramConfig.content.get().toStringUtf8();
      continue;
      label211:
      QLog.w("SPLASH_ConfigServlet", 1, "handleNewTroopRecommend config_content is empty!");
      return;
      label221:
      QLog.w("SPLASH_ConfigServlet", 1, "handleNewTroopRecommend content is empty!");
      return;
      label231:
      QLog.w("SPLASH_ConfigServlet", 1, "handleNewTroopRecommend msg_content_list is empty!");
      return;
      label241:
      paramConfig = null;
    }
  }
  
  private void ap(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    boolean bool2 = true;
    ayrg localayrg = (ayrg)paramQQAppInterface.getManager(QQManagerFactory.OCR_MANAGER);
    int i = localayrg.a();
    int j = paramConfig.version.get();
    QLog.d("SPLASH_ConfigServlet", 1, "handleGetOCRConfig, version:" + j + ",localVersion:" + i);
    if (i != j) {
      if ((paramConfig.msg_content_list != null) && (paramConfig.msg_content_list.size() > 0))
      {
        paramConfig = (ConfigurationService.Content)paramConfig.msg_content_list.get(0);
        paramQQAppInterface = localObject2;
        if (paramConfig == null) {
          break label343;
        }
        if (paramConfig.compress.get() == 1)
        {
          paramQQAppInterface = ayym.a(paramConfig.content.get().toByteArray());
          if (paramQQAppInterface == null) {}
        }
      }
    }
    for (;;)
    {
      try
      {
        paramQQAppInterface = new String(paramQQAppInterface, "UTF-8");
        paramConfig = OcrConfig.parse(paramQQAppInterface);
        paramQQAppInterface = paramConfig;
        if (paramConfig == null) {
          break label343;
        }
        paramConfig.version = j;
        bool1 = true;
        paramQQAppInterface = paramConfig;
        if (QLog.isColorLevel()) {
          QLog.d("SPLASH_ConfigServlet", 2, "handleGetOCRConfig, isSucc = " + bool1 + ", ocrConfig = " + paramQQAppInterface);
        }
        localayrg.a(bool1, paramQQAppInterface);
        return;
      }
      catch (Throwable paramQQAppInterface)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SPLASH_ConfigServlet", 2, "Throwable:" + paramQQAppInterface.getMessage());
        }
        paramQQAppInterface = null;
        continue;
      }
      if (QLog.isColorLevel()) {
        QLog.d("SPLASH_ConfigServlet", 2, "inflateConfigString error!");
      }
      paramQQAppInterface = null;
      continue;
      paramQQAppInterface = paramConfig.content.get().toStringUtf8();
      continue;
      OcrConfig.deleteLocalConfig(jdField_a_of_type_JavaLangString);
      paramQQAppInterface = localObject1;
      boolean bool1 = bool2;
      if (QLog.isColorLevel())
      {
        QLog.d("SPLASH_ConfigServlet", 2, "handleGetOCRConfig, msg_content_list is null");
        paramQQAppInterface = localObject1;
        bool1 = bool2;
        continue;
        label343:
        bool1 = false;
        continue;
        bool1 = false;
        paramQQAppInterface = localObject1;
      }
    }
  }
  
  private void aq(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    int i = bhex.a();
    int j = paramConfig.version.get();
    if (QLog.isColorLevel()) {
      QLog.d("JumpForwardPkgManager", 2, "receiveAllConfigs[handleJumpPkgConfig]|received remote version: " + j + " | localVersion: " + i);
    }
    if (j != i)
    {
      if ((paramConfig.msg_content_list == null) || (paramConfig.msg_content_list.size() <= 0)) {
        break label247;
      }
      paramConfig = (ConfigurationService.Content)paramConfig.msg_content_list.get(0);
      if (paramConfig == null) {
        break label230;
      }
      if (paramConfig.compress.get() != 1) {
        break label216;
      }
      paramConfig = ayym.a(paramConfig.content.get().toByteArray());
      if (paramConfig == null) {
        break label194;
      }
    }
    label194:
    label216:
    label230:
    while (!QLog.isColorLevel()) {
      for (;;)
      {
        try
        {
          paramConfig = new String(paramConfig, "UTF-8");
          bhex.a().a(paramQQAppInterface.getApp(), paramConfig, j);
          return;
        }
        catch (Throwable paramConfig)
        {
          if (QLog.isColorLevel()) {
            QLog.d("JumpForwardPkgManager", 2, "receiveAllConfigs[handleJumpPkgConfig]|Throwable:" + paramConfig.getMessage());
          }
          paramConfig = "";
          continue;
        }
        if (QLog.isColorLevel()) {
          QLog.d("JumpForwardPkgManager", 2, "receiveAllConfigs[handleJumpPkgConfig]|inflateConfigString error!");
        }
        paramConfig = "";
        continue;
        paramConfig = paramConfig.content.get().toStringUtf8();
      }
    }
    QLog.d("JumpForwardPkgManager", 2, "receiveAllConfigs[handleJumpPkgConfig]| content==null");
    return;
    label247:
    if (QLog.isColorLevel()) {
      QLog.d("JumpForwardPkgManager", 2, "receiveAllConfigs[handleJumpPkgConfig]| msg_content_list is empty ,version: " + j + ",localVersion:" + i);
    }
    bhex.a().a(j);
  }
  
  private void ar(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    int i = paramConfig.version.get();
    int j = bhhr.ab(BaseApplication.getContext(), jdField_a_of_type_JavaLangString);
    QLog.i("SPLASH_ConfigServlet", 1, "handleDevConfig: ,version: " + paramConfig.version.get() + "| localVersion: " + j);
    if (i != j)
    {
      bhhr.z(BaseApplication.getContext(), jdField_a_of_type_JavaLangString, i);
      paramQQAppInterface = a(paramConfig);
      if ((paramQQAppInterface != null) && (paramQQAppInterface.size() > 0)) {}
      try
      {
        paramQQAppInterface = (String)paramQQAppInterface.get(paramQQAppInterface.size() - 1);
        QLog.d("SPLASH_ConfigServlet", 1, new Object[] { "devConfig is ", paramQQAppInterface });
        bhhr.l(BaseApplication.getContext(), jdField_a_of_type_JavaLangString, paramQQAppInterface);
        return;
      }
      catch (Exception paramQQAppInterface)
      {
        QLog.e("SPLASH_ConfigServlet", 1, new Object[] { "get dev config error : ", paramQQAppInterface.getMessage() });
        return;
      }
    }
    QLog.e("SPLASH_ConfigServlet", 1, "handleDevConfig version is same of local version");
  }
  
  private void as(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    boolean bool = false;
    int i = paramConfig.version.get();
    BaseApplication localBaseApplication = paramQQAppInterface.getApp();
    String str = paramQQAppInterface.getCurrentUin();
    int j = ((Integer)bhhr.a(localBaseApplication, str, "config_tim_team_version_code", Integer.valueOf(0))).intValue();
    if (QLog.isColorLevel()) {
      QLog.d("SPLASH_ConfigServlet", 2, "handleTimTeamConfig received Config remote version:" + i + " localVersion= " + j);
    }
    if (i != j)
    {
      paramQQAppInterface = a(paramConfig);
      if ((paramQQAppInterface == null) || (paramQQAppInterface.size() <= 0)) {}
    }
    try
    {
      paramConfig = new JSONObject((String)paramQQAppInterface.get(0));
      paramQQAppInterface = "";
      if (paramConfig.has("isWeb")) {
        bool = paramConfig.getBoolean("isWeb");
      }
      if (paramConfig.has("url")) {
        paramQQAppInterface = paramConfig.getString("url");
      }
      if (QLog.isColorLevel()) {
        QLog.d("SPLASH_ConfigServlet", 2, "handleTimTeamConfig isWeb=" + bool + " url=" + paramQQAppInterface);
      }
      bhhr.a(localBaseApplication, str, false, "config_tim_team_is_web", Boolean.valueOf(bool));
      bhhr.a(localBaseApplication, str, false, "config_tim_team_url", paramQQAppInterface);
      bhhr.a(localBaseApplication, str, true, "config_tim_team_version_code", Integer.valueOf(i));
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("SPLASH_ConfigServlet", 2, paramQQAppInterface.getMessage());
    }
  }
  
  public static String b(ConfigurationService.Config paramConfig, int paramInt1, int paramInt2)
  {
    if (paramConfig.version.get() == paramInt1) {
      return null;
    }
    if ((paramConfig.msg_content_list == null) || (paramConfig.msg_content_list.size() == 0))
    {
      QLog.i("SPLASH_ConfigServlet", 1, String.format("handleCompressConfig| version is update but config content is null. newVersion=%d, oldVersion=%d, type=%d", new Object[] { Integer.valueOf(paramConfig.version.get()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
      return "";
    }
    if (paramConfig.msg_content_list.size() >= 2) {
      QLog.w("SPLASH_ConfigServlet", 1, "handleCompressConfig, 拉到了多份配置, type[" + paramInt2 + "], size[" + paramConfig.msg_content_list.size() + "]");
    }
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      Object localObject1 = ((ConfigurationService.Content)paramConfig.msg_content_list.get(paramInt1)).content.get().toByteArray();
      if (localObject1 == null)
      {
        QLog.e("SPLASH_ConfigServlet", 1, "handleCompressConfig| config content is null. type=" + paramInt2);
        return null;
      }
      Object localObject2;
      if (((ConfigurationService.Content)paramConfig.msg_content_list.get(0)).compress.get() == 1)
      {
        localObject2 = apfw.a((byte[])localObject1);
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          QLog.e("SPLASH_ConfigServlet", 1, "handleCompressConfig| decompress is failed. type=" + paramInt2 + ", data=null");
          return null;
        }
      }
      String str;
      try
      {
        localObject2 = new String((byte[])localObject1, "utf-8");
        if (localObject2 == null)
        {
          QLog.e("SPLASH_ConfigServlet", 1, "handleCompressConfig| switch data[] to String failed. type=" + paramInt2 + ", data=" + new String((byte[])localObject1));
          return null;
        }
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        for (;;)
        {
          localUnsupportedEncodingException.printStackTrace();
          str = null;
        }
        localObject1 = String.format("handleCompressConfig| config is update. version=%d, type=%d", new Object[] { Integer.valueOf(paramConfig.version.get()), Integer.valueOf(paramInt2) });
        if (!QLog.isColorLevel()) {
          break label432;
        }
      }
      if ((paramConfig.version.get() != 397) && (paramConfig.version.get() != 394)) {
        QLog.i("SPLASH_ConfigServlet", 2, (String)localObject1 + "content=" + str);
      }
      for (;;)
      {
        return str;
        label432:
        QLog.i("SPLASH_ConfigServlet", 1, (String)localObject1);
      }
    }
  }
  
  private void b(Intent paramIntent, ConfigurationService.Config paramConfig)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArConfig_configServlet", 2, "handleResp_GetArEntranceConfig|type= " + paramConfig.type.get());
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)getAppRuntime();
    apgi localapgi = (apgi)localQQAppInterface.getManager(QQManagerFactory.AR_RESOURCE_MANAGER);
    if (paramConfig.type.get() != 88)
    {
      OlympicServlet.a(localQQAppInterface, 88, 0, 0, 1, 3, 0);
      return;
    }
    int i = paramConfig.version.get();
    int j;
    if (paramIntent.getIntExtra("key_ar_entrance_effect_version", 0) != i) {
      if ((paramConfig.msg_content_list != null) && (paramConfig.msg_content_list.size() > 0))
      {
        paramIntent = (ConfigurationService.Content)paramConfig.msg_content_list.get(0);
        j = paramIntent.task_id.get();
        if (paramIntent.compress.get() == 1)
        {
          paramIntent = apfw.a(paramIntent.content.get().toByteArray());
          if (paramIntent == null)
          {
            OlympicServlet.a(localQQAppInterface, 88, i, j, 1, 4, 0);
            if (!QLog.isColorLevel()) {
              break label393;
            }
            QLog.d("ArConfig_configServlet", 2, "handleResp_GetArEntranceConfig||deCompress error!");
            paramIntent = null;
          }
        }
      }
    }
    for (;;)
    {
      paramIntent = ArEffectConfig.a(paramIntent);
      if (paramIntent != null)
      {
        paramIntent.jdField_a_of_type_Int = i;
        if (localapgi != null) {
          localapgi.a(paramIntent);
        }
        for (;;)
        {
          for (;;)
          {
            OlympicServlet.a(localQQAppInterface, 88, i, j, 1, 0, 0);
            return;
            try
            {
              paramIntent = new String(paramIntent, "utf-8");
            }
            catch (UnsupportedEncodingException localUnsupportedEncodingException)
            {
              paramConfig = null;
              paramIntent = paramConfig;
            }
          }
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("SPLASH_ConfigServlet", 2, localUnsupportedEncodingException.getMessage());
          paramIntent = paramConfig;
          break;
          paramIntent = paramIntent.content.get().toStringUtf8();
          break;
          if (QLog.isColorLevel()) {
            QLog.d("ArConfig_configServlet", 2, "handleResp_GetArEntranceConfig|arManager is null ");
          }
        }
      }
      OlympicServlet.a(localQQAppInterface, 88, i, j, 1, 5, 0);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("ArConfig_configServlet", 2, "handleResp_GetArEntranceConfig||parseArEffectConfig error!");
      return;
      if (localapgi != null) {
        localapgi.b();
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("ArConfig_configServlet", 2, "handleResp_GetArEntranceConfig || msg_content_list is null");
      return;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("ArConfig_configServlet", 2, "handleResp_GetArEntranceConfig || has same version");
      return;
      label393:
      paramIntent = null;
    }
  }
  
  public static void b(QQAppInterface paramQQAppInterface, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ShortVideoResourceManager", 2, "getShortVideoResourceConfig| getType=" + paramInt);
    }
    ShortVideoResourceManager.a = System.currentTimeMillis();
    a(paramQQAppInterface, 215, null);
  }
  
  private void b(QQAppInterface paramQQAppInterface, Intent paramIntent, ConfigurationService.Config paramConfig)
  {
    paramIntent = bbgg.a();
    int j = paramConfig.version.get();
    int i = bhhr.h(((QQAppInterface)getAppRuntime()).getApp());
    if (!bbgg.a()) {
      i = 0;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("CapturePtvTemplateManager_VideoRedbag", 2, "serverVersion=" + j + "|localVersion=" + i);
      }
      if (j == i) {
        break;
      }
      bhhr.f(((QQAppInterface)getAppRuntime()).getApp(), j);
      try
      {
        String str = b(paramConfig, i, 226);
        if (str != null)
        {
          paramIntent.a(paramQQAppInterface, str, 1);
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("CapturePtvTemplateManager", 2, "receiveAllConfigs|type: 226,content: " + str + ",version: " + paramConfig.version.get());
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d("CapturePtvTemplateManager", 2, "receiveAllConfigs|type: 226,content_list is empty ,version: " + paramConfig.version.get());
        }
        paramIntent.a(paramQQAppInterface, "", 1);
        return;
      }
      catch (OutOfMemoryError paramQQAppInterface)
      {
        if (!QLog.isColorLevel()) {
          break;
        }
      }
      QLog.e("CapturePtvTemplateManager", 2, "receiveAllConfigs|exception:" + paramQQAppInterface.getMessage());
      return;
    }
  }
  
  private void b(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig, int paramInt)
  {
    int i = paramConfig.version.get();
    BaseApplication localBaseApplication = paramQQAppInterface.getApp();
    String str = paramQQAppInterface.getCurrentUin();
    int j = aiin.a(paramQQAppInterface);
    if (QLog.isColorLevel()) {
      QLog.d("SPLASH_ConfigServlet", 2, "RecommendedSticker received Config remote version:" + i + " localVersion= " + j);
    }
    if (i != j)
    {
      paramConfig = b(paramConfig, j, paramInt);
      if (TextUtils.isEmpty(paramConfig)) {}
    }
    try
    {
      paramConfig = new JSONObject(paramConfig);
      if ((paramConfig.has("useRecommendedSticker")) && (paramConfig.has("maxMatchLength")))
      {
        aiin.a(paramQQAppInterface, paramConfig.getBoolean("useRecommendedSticker"));
        aiin.a(localBaseApplication, str, paramConfig.getInt("maxMatchLength"));
      }
      for (;;)
      {
        aiin.a(paramQQAppInterface, i);
        return;
        aiin.a(paramQQAppInterface, false);
      }
    }
    catch (Exception paramConfig)
    {
      for (;;)
      {
        aiin.a(paramQQAppInterface, false);
        if (QLog.isColorLevel()) {
          QLog.d("SPLASH_ConfigServlet", 2, paramConfig.getMessage());
        }
      }
    }
  }
  
  public static void b(QQAppInterface paramQQAppInterface, String paramString)
  {
    jdField_a_of_type_JavaLangString = paramString;
    NewIntent localNewIntent = new NewIntent(paramQQAppInterface.getApp(), arph.class);
    localNewIntent.putExtra("k_cmd_type", new int[] { 34 });
    localNewIntent.putExtra("key_uin", paramString);
    paramQQAppInterface.startServlet(localNewIntent);
  }
  
  private void b(String paramString, int paramInt)
  {
    try
    {
      paramString = a(new ByteArrayInputStream(paramString.getBytes("utf-8")));
      if (paramString != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SPLASH_ConfigServlet", 2, "qav_anychat_time_limit stream = " + paramString);
        }
        bhhr.d(((QQAppInterface)getAppRuntime()).getCurrentAccountUin()).edit().putString("qav_anychat_time_value", paramString).commit();
        bhhr.j(getAppRuntime().getApplication(), paramInt, jdField_a_of_type_JavaLangString);
      }
      return;
    }
    catch (Exception paramString)
    {
      do
      {
        paramString.printStackTrace();
      } while (!QLog.isColorLevel());
      QLog.i("SPLASH_ConfigServlet", 2, "parse qav_anychat_time_limit  exception : " + paramString.getMessage());
    }
  }
  
  public static byte[] b(byte[] paramArrayOfByte)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    try
    {
      paramArrayOfByte = new InflaterInputStream(new ByteArrayInputStream(paramArrayOfByte));
      byte[] arrayOfByte = new byte[256];
      for (;;)
      {
        int i = paramArrayOfByte.read(arrayOfByte);
        if (-1 == i) {
          break;
        }
        localByteArrayOutputStream.write(arrayOfByte, 0, i);
      }
      paramArrayOfByte = localByteArrayOutputStream.toByteArray();
    }
    catch (Throwable paramArrayOfByte)
    {
      if (QLog.isColorLevel())
      {
        QLog.d("OlympicUtil", 2, "inflateConfigString");
        paramArrayOfByte.printStackTrace();
      }
      return null;
    }
    return paramArrayOfByte;
  }
  
  private void c(Intent paramIntent, ConfigurationService.Config paramConfig)
  {
    QLog.d("ArConfig_configServlet", 1, "handleResp_GetArResourceConfig| 2 type= " + paramConfig.type.get());
    QQAppInterface localQQAppInterface = (QQAppInterface)getAppRuntime();
    apgi localapgi = (apgi)localQQAppInterface.getManager(QQManagerFactory.AR_RESOURCE_MANAGER);
    if (localapgi == null)
    {
      QLog.d("ArConfig_configServlet", 1, "handleResp_GetArResourceConfig| manager is null");
      return;
    }
    Object localObject1 = BaseApplicationImpl.getApplication();
    int i;
    int j;
    ArrayList localArrayList;
    try
    {
      i = ((Context)localObject1).getPackageManager().getPackageInfo(((Context)localObject1).getPackageName(), 0).versionCode;
      localapgi.a(i);
      QLog.d("ArConfig_configServlet", 1, "handleResp_GetArResourceConfig| 3 type= version code is " + i);
      if (paramConfig.type.get() != 87) {
        break label752;
      }
      j = paramConfig.version.get();
      i = paramIntent.getIntExtra("key_config_version", 0);
      if (QLog.isColorLevel()) {
        QLog.d("handleResp_GetArResourceConfig", 2, "handleResp_GetArResource|server-Version is " + j);
      }
      if (i == j) {
        break label731;
      }
      if (paramConfig.msg_content_list == null) {
        break label707;
      }
      int k = paramConfig.msg_content_list.size();
      if (k <= 0) {
        break label707;
      }
      localObject1 = null;
      localArrayList = new ArrayList();
      i = 0;
      if (i < k)
      {
        localObject3 = (ConfigurationService.Content)paramConfig.msg_content_list.get(i);
        m = ((ConfigurationService.Content)localObject3).task_id.get();
        localObject2 = ((ConfigurationService.Content)localObject3).content.get().toByteArray();
        paramIntent = (Intent)localObject2;
        if (((ConfigurationService.Content)localObject3).compress.get() == 1) {
          paramIntent = apfw.a((byte[])localObject2);
        }
        if (paramIntent == null) {}
      }
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      for (;;)
      {
        int m;
        try
        {
          localObject2 = new String(paramIntent, "utf-8");
          localObject3 = ArConfigInfo.parseArConfig((String)localObject2);
          if (localObject3 != null) {
            if (localObject1 == null)
            {
              paramIntent = (Intent)localObject3;
              localArrayList.addAll(((ArConfigInfo)localObject3).mArCloudConfigInfos);
              QLog.i("ArConfig_configServlet", 1, "config loop|| taskid=" + m + ",endtime=" + ((ArConfigInfo)localObject3).aREnd + ",xmlcontent=" + (String)localObject2);
              OlympicServlet.a(localQQAppInterface, 87, j, m, 1, 0, 0);
              i += 1;
              localObject1 = paramIntent;
              continue;
              localNameNotFoundException = localNameNotFoundException;
              localNameNotFoundException.printStackTrace();
              QLog.d("ArConfig_configServlet", 1, "handleResp_GetArResourceConfig| 3 type= error happen");
            }
          }
        }
        catch (UnsupportedEncodingException paramIntent)
        {
          Object localObject3;
          if (QLog.isColorLevel()) {
            QLog.d("SPLASH_ConfigServlet", 2, paramIntent.getMessage());
          }
          Object localObject2 = null;
          continue;
          paramIntent = localNameNotFoundException;
          if (localNameNotFoundException.aREnd >= ((ArConfigInfo)localObject3).aREnd) {
            continue;
          }
          paramIntent = (Intent)localObject3;
          continue;
          OlympicServlet.a(localQQAppInterface, 87, j, m, 1, 5, 0);
          paramIntent = localNameNotFoundException;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("ArConfig_configServlet", 2, "handleResp_GetArResource||parseArConfig error!");
          paramIntent = localNameNotFoundException;
          continue;
        }
        OlympicServlet.a(localQQAppInterface, 87, j, m, 1, 4, 0);
        paramIntent = localNameNotFoundException;
        if (QLog.isColorLevel())
        {
          QLog.d("ArConfig_configServlet", 2, "handleResp_GetArResource||deCompress error!");
          paramIntent = localNameNotFoundException;
        }
      }
    }
    if (localNameNotFoundException != null)
    {
      localNameNotFoundException.mArCloudConfigInfos = localArrayList;
      localNameNotFoundException.version = 2;
      localapgi.b(j);
      localapgi.a(localNameNotFoundException);
      if (QLog.isColorLevel()) {
        QLog.d("ArConfig_configServlet", 2, "maxEndTimeArConfigInfo|| maxEndtime=" + localNameNotFoundException.aREnd);
      }
      OlympicServlet.a(localQQAppInterface, 87, j, 0, 0, 0, 0);
    }
    for (;;)
    {
      i = 0;
      label648:
      if ((i == 0) || (localapgi == null)) {
        break;
      }
      QLog.d("ArConfig_configServlet", 1, "arManager.downloadArResource");
      localapgi.a(true, false);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ArConfig_configServlet", 2, "handleResp_GetArResource|combineArConfigInfo is null");
      }
      OlympicServlet.a(localQQAppInterface, 87, j, 0, 0, 5, 0);
      continue;
      label707:
      localapgi.a();
      if (QLog.isColorLevel()) {
        QLog.d("ArConfig_configServlet", 2, "handleResp_GetArResource||msg_content_list is null!");
      }
    }
    label731:
    if (QLog.isColorLevel()) {
      QLog.d("ArConfig_configServlet", 2, "handleResp_GetArResource || has same version");
    }
    for (;;)
    {
      i = 1;
      break label648;
      break;
      label752:
      QLog.d("ArConfig_configServlet", 2, "handleResp_GetArResource || fail");
      OlympicServlet.a(localQQAppInterface, 87, 0, 0, 1, 3, 0);
    }
  }
  
  public static void c(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    int i = paramConfig.version.get();
    int j = bhhr.R(BaseApplication.getContext(), jdField_a_of_type_JavaLangString);
    if (QLog.isColorLevel()) {
      QLog.i("SPLASH_ConfigServlet", 2, "handleRespNewBoatConfig: ,version: " + paramConfig.version.get() + "| localVersion: " + j);
    }
    if (i != j)
    {
      bhhr.t(BaseApplication.getContext(), i, jdField_a_of_type_JavaLangString);
      paramConfig = a(paramConfig);
      if ((paramConfig != null) && (paramConfig.size() > 0)) {
        axmy.a(paramQQAppInterface, (String)paramConfig.get(0));
      }
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.i("SPLASH_ConfigServlet", 2, "handleRespNewBoatConfig:localVersiont == version ");
  }
  
  public static void c(QQAppInterface paramQQAppInterface, String paramString)
  {
    QLog.d("SPLASH_ConfigServlet", 1, " call  getServiceAccountFolderConfig ");
    jdField_a_of_type_JavaLangString = paramString;
    a(paramQQAppInterface, 81);
  }
  
  private void c(String paramString, int paramInt)
  {
    int i;
    long l1;
    Object localObject1;
    Object localObject2;
    int k;
    Object localObject3;
    Object localObject4;
    long l2;
    long l3;
    Object localObject5;
    int j;
    try
    {
      Document localDocument = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new ByteArrayInputStream(paramString.getBytes("utf-8")));
      NodeList localNodeList = localDocument.getElementsByTagName("pushbanner");
      paramString = "";
      i = 0;
      if (i < localNodeList.getLength())
      {
        l1 = Long.parseLong(localDocument.getElementsByTagName("channel").item(i).getFirstChild().getNodeValue());
        localObject1 = localDocument.getElementsByTagName("img").item(i).getFirstChild().getNodeValue();
        localObject2 = localDocument.getElementsByTagName("digest").item(i).getFirstChild().getNodeValue();
        k = Integer.parseInt(localDocument.getElementsByTagName("weight").item(i).getFirstChild().getNodeValue());
        localObject3 = localDocument.getElementsByTagName("md5").item(i).getFirstChild();
        if (localObject3 != null) {
          paramString = ((Node)localObject3).getNodeValue();
        }
        localObject3 = localDocument.getElementsByTagName("end").item(i).getFirstChild().getNodeValue();
        localObject4 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        l2 = ((SimpleDateFormat)localObject4).parse((String)localObject3).getTime();
        l3 = ((SimpleDateFormat)localObject4).parse(localDocument.getElementsByTagName("begin").item(i).getFirstChild().getNodeValue()).getTime();
        if (System.currentTimeMillis() > l2)
        {
          if (QLog.isColorLevel()) {
            QLog.i("SPLASH_ConfigServlet", 2, "this pushbanner is outdate , throw it");
          }
        }
        else
        {
          localObject3 = new StringBuffer();
          paramInt = 0;
          while (paramInt < localDocument.getElementsByTagName("url").item(i).getChildNodes().getLength())
          {
            ((StringBuffer)localObject3).append(localDocument.getElementsByTagName("url").item(i).getChildNodes().item(paramInt).getNodeValue());
            paramInt += 1;
          }
          localObject4 = ((StringBuffer)localObject3).toString();
          localObject3 = ((QQAppInterface)getAppRuntime()).getEntityManagerFactory().createEntityManager();
          localObject5 = ((EntityManager)localObject3).query(ExpiredPushBanner.class);
          j = 0;
          paramInt = 0;
          if (localObject5 != null)
          {
            localObject5 = ((List)localObject5).iterator();
            label459:
            j = paramInt;
            if (((Iterator)localObject5).hasNext())
            {
              if (((ExpiredPushBanner)((Iterator)localObject5).next()).cid != l1) {
                break label1051;
              }
              paramInt = 1;
              break label1061;
            }
          }
          if (j != 0)
          {
            if (!QLog.isColorLevel()) {
              break label1054;
            }
            QLog.i("SPLASH_ConfigServlet", 2, "this pushbanner had been close or click , throw it");
          }
        }
      }
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      if (QLog.isColorLevel()) {
        QLog.i("SPLASH_ConfigServlet", 2, "push exception : " + paramString.getMessage());
      }
    }
    return;
    if (paramString.length() < 15)
    {
      if (QLog.isColorLevel()) {
        QLog.i("SPLASH_ConfigServlet", 2, "this pushbanner md5 length < 15 .throw");
      }
    }
    else
    {
      localObject5 = BaseApplication.getContext().getFilesDir().getAbsolutePath() + "/ADPic/" + paramString;
      if (!aqwo.a(paramString)) {
        ThreadManager.executeOnNetWorkThread(new ConfigServlet.4(this, (String)localObject1));
      }
      aqwk.a.a(aqwk.a.a(l1, (String)localObject2, (byte)3, (String)localObject1, (String)localObject4, (String)localObject5, l3 + "|" + l2, (short)k, paramString));
      paramInt = 1;
      k = 1;
    }
    for (;;)
    {
      try
      {
        localObject1 = ((EntityManager)localObject3).query(ReportedBanner.class, false, null, null, null, null, "endtime DESC", null);
        j = paramInt;
        if (localObject1 != null)
        {
          j = paramInt;
          if (((List)localObject1).size() > 0)
          {
            localObject2 = ((List)localObject1).iterator();
            paramInt = k;
            if (((Iterator)localObject2).hasNext())
            {
              localObject4 = (ReportedBanner)((Iterator)localObject2).next();
              if ((localObject4 == null) || (((ReportedBanner)localObject4).cid != l1)) {
                continue;
              }
              paramInt = 0;
            }
            j = paramInt;
            if (((List)localObject1).size() > 18)
            {
              k = ((List)localObject1).size() - 1;
              j = paramInt;
              if (k >= 9)
              {
                localObject2 = (ReportedBanner)((List)localObject1).get(k);
                if ((localObject2 == null) || (((ReportedBanner)localObject2).cid == l1)) {
                  break label1064;
                }
                ((EntityManager)localObject3).remove((Entity)localObject2);
                break label1064;
              }
            }
          }
        }
        if (j == 0) {
          break label1015;
        }
        bdla.b((QQAppInterface)getAppRuntime(), "dc00898", "", "", "0X80087C0", "0X80087C0", (int)l1, 0, "", "", "", "");
        localObject1 = new ReportedBanner();
        ((ReportedBanner)localObject1).cid = l1;
        ((ReportedBanner)localObject1).md5 = paramString;
        ((ReportedBanner)localObject1).endtime = l2;
        ((EntityManager)localObject3).persist((Entity)localObject1);
        if (!QLog.isColorLevel()) {
          break label1054;
        }
        QLog.i("SPLASH_ConfigServlet", 2, String.format(Locale.getDefault(), "push banner report cid: %d", new Object[] { Long.valueOf(l1) }));
      }
      catch (Throwable localThrowable)
      {
        if (!QLog.isColorLevel()) {
          break label1054;
        }
      }
      QLog.i("SPLASH_ConfigServlet", 2, String.format(Locale.getDefault(), "push banner report exception t: %s", new Object[] { localThrowable }));
      break label1054;
      label1015:
      if (QLog.isColorLevel())
      {
        QLog.i("SPLASH_ConfigServlet", 2, String.format(Locale.getDefault(), "push banner report repeat cid: %d", new Object[] { Long.valueOf(l1) }));
        break label1054;
        break label1061;
      }
      label1051:
      label1054:
      i += 1;
      break;
      label1061:
      break label459;
      label1064:
      k -= 1;
    }
  }
  
  private void d(Intent paramIntent, ConfigurationService.Config paramConfig)
  {
    if (QLog.isColorLevel()) {
      QLog.d("handleResp_GetArGlobalConfig", 2, "handleResp_GetArGlobalConfig |  type= " + paramConfig.type.get());
    }
    apbf localapbf = (apbf)((QQAppInterface)getAppRuntime()).getManager(QQManagerFactory.AR_CLOBAL_CONFIG_MANAGER);
    int i;
    byte[] arrayOfByte;
    if (paramConfig.type.get() == 188)
    {
      i = paramConfig.version.get();
      if (paramIntent.getIntExtra("ar_global_key_config_version", 0) == i) {
        break label363;
      }
      if ((paramConfig.msg_content_list == null) || (paramConfig.msg_content_list.size() <= 0)) {
        break label334;
      }
      paramIntent = (ConfigurationService.Content)paramConfig.msg_content_list.get(0);
      if (paramIntent == null) {
        break label315;
      }
      if (paramIntent.compress.get() != 1) {
        break label301;
      }
      arrayOfByte = ayym.a(paramIntent.content.get().toByteArray());
      if (arrayOfByte == null) {
        break label382;
      }
    }
    for (;;)
    {
      try
      {
        paramIntent = new String(arrayOfByte, "UTF-8");
        if (paramIntent != null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("handleResp_GetArGlobalConfigSPLASH_ConfigServlet", 2, "handleRespGetHotDaysConfig, config_content is " + paramIntent);
          }
          i = paramConfig.version.get();
          if (localapbf.a(paramIntent))
          {
            localapbf.a(i);
            localapbf.a();
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d("handleResp_GetArGlobalConfigSPLASH_ConfigServlet", 2, "handleRespGetHotDaysConfig, config type 188");
        }
        return;
      }
      catch (UnsupportedEncodingException paramIntent)
      {
        if (QLog.isColorLevel()) {
          paramIntent.printStackTrace();
        }
        paramIntent = null;
        continue;
      }
      catch (OutOfMemoryError paramIntent)
      {
        if (QLog.isColorLevel()) {
          paramIntent.printStackTrace();
        }
        System.gc();
        try
        {
          paramIntent = new String(arrayOfByte, "UTF-8");
        }
        catch (Throwable paramIntent)
        {
          paramIntent = null;
        }
        continue;
      }
      label301:
      paramIntent = paramIntent.content.get().toStringUtf8();
      continue;
      label315:
      if (QLog.isColorLevel())
      {
        QLog.d("handleResp_GetArGlobalConfigSPLASH_ConfigServlet", 2, "handleRespGetHotDaysConfig, content is null");
        continue;
        label334:
        if (localapbf != null) {
          localapbf.b();
        }
        if (QLog.isColorLevel())
        {
          QLog.d("handleResp_GetArGlobalConfigSPLASH_ConfigServlet", 2, "we delete ARConfig info here");
          continue;
          label363:
          if (QLog.isColorLevel())
          {
            QLog.d("handleResp_GetArGlobalConfigSPLASH_ConfigServlet", 2, "handleRespGetHotDaysConfig, version same");
            continue;
            label382:
            paramIntent = null;
          }
        }
      }
    }
  }
  
  public static void d(QQAppInterface paramQQAppInterface, String paramString)
  {
    jdField_a_of_type_JavaLangString = paramString;
    a(paramQQAppInterface, 43);
  }
  
  private void d(ConfigurationService.Config paramConfig)
  {
    int i = paramConfig.version.get();
    int j = bhhr.f(((QQAppInterface)getAppRuntime()).getApp());
    if (QLog.isColorLevel()) {
      QLog.d("TroopRankConfig", 2, "handleTroopRankConfigCmd, serverVersion=" + i + "|localVersion=" + j);
    }
    byte[] arrayOfByte;
    if ((i != j) && (paramConfig.msg_content_list != null) && (paramConfig.msg_content_list.size() > 0))
    {
      paramConfig = (ConfigurationService.Content)paramConfig.msg_content_list.get(0);
      if (paramConfig != null)
      {
        if (paramConfig.compress.get() != 1) {
          break label297;
        }
        arrayOfByte = ayym.a(paramConfig.content.get().toByteArray());
        if (arrayOfByte == null) {
          break label292;
        }
      }
    }
    label292:
    label297:
    do
    {
      for (;;)
      {
        try
        {
          paramConfig = new String(arrayOfByte, "UTF-8");
          if (TextUtils.isEmpty(paramConfig)) {
            break;
          }
          boolean bool = bfkd.a(paramConfig);
          if (bool) {
            bhhr.d(((QQAppInterface)getAppRuntime()).getApp(), i);
          }
          if (QLog.isColorLevel()) {
            QLog.d("TroopRankConfig", 2, "refreshConfig ret=" + bool);
          }
          return;
        }
        catch (Exception paramConfig)
        {
          if (QLog.isColorLevel()) {
            QLog.w("TroopRankConfig", 2, "handleTroopRankConfigCmd", paramConfig);
          }
          paramConfig = null;
          continue;
        }
        catch (OutOfMemoryError paramConfig)
        {
          if (QLog.isColorLevel()) {
            QLog.w("TroopRankConfig", 2, "handleTroopRankConfigCmd", paramConfig);
          }
          System.gc();
          try
          {
            paramConfig = new String(arrayOfByte, "UTF-8");
          }
          catch (Throwable paramConfig)
          {
            if (QLog.isColorLevel()) {
              QLog.w("TroopRankConfig", 2, "handleTroopRankConfigCmd", paramConfig);
            }
          }
        }
        paramConfig = null;
        continue;
        paramConfig = paramConfig.content.get().toStringUtf8();
      }
    } while (!QLog.isColorLevel());
    QLog.d("TroopRankConfig", 2, "handleTroopRankConfigCmd, config_content is empty");
  }
  
  /* Error */
  private void d(String paramString, int paramInt)
  {
    // Byte code:
    //   0: invokestatic 949	javax/xml/parsers/DocumentBuilderFactory:newInstance	()Ljavax/xml/parsers/DocumentBuilderFactory;
    //   3: invokevirtual 953	javax/xml/parsers/DocumentBuilderFactory:newDocumentBuilder	()Ljavax/xml/parsers/DocumentBuilder;
    //   6: new 955	java/io/ByteArrayInputStream
    //   9: dup
    //   10: aload_1
    //   11: ldc_w 957
    //   14: invokevirtual 961	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   17: invokespecial 962	java/io/ByteArrayInputStream:<init>	([B)V
    //   20: invokevirtual 967	javax/xml/parsers/DocumentBuilder:parse	(Ljava/io/InputStream;)Lorg/w3c/dom/Document;
    //   23: astore 14
    //   25: aload 14
    //   27: ldc_w 4261
    //   30: invokeinterface 975 2 0
    //   35: astore 15
    //   37: ldc 13
    //   39: astore 12
    //   41: fconst_0
    //   42: fstore 4
    //   44: fconst_0
    //   45: fstore 5
    //   47: iconst_0
    //   48: istore 10
    //   50: ldc 13
    //   52: astore 11
    //   54: fconst_0
    //   55: fstore 6
    //   57: fconst_0
    //   58: fstore_3
    //   59: ldc_w 4263
    //   62: astore_1
    //   63: ldc 13
    //   65: astore 13
    //   67: iconst_0
    //   68: istore 9
    //   70: iload 9
    //   72: aload 15
    //   74: invokeinterface 980 1 0
    //   79: if_icmpge +480 -> 559
    //   82: aload 14
    //   84: ldc_w 3500
    //   87: invokeinterface 975 2 0
    //   92: iload 9
    //   94: invokeinterface 986 2 0
    //   99: invokeinterface 992 1 0
    //   104: invokeinterface 995 1 0
    //   109: astore 13
    //   111: aload 14
    //   113: ldc_w 3506
    //   116: invokeinterface 975 2 0
    //   121: iload 9
    //   123: invokeinterface 986 2 0
    //   128: invokeinterface 992 1 0
    //   133: invokeinterface 995 1 0
    //   138: astore 12
    //   140: aload 14
    //   142: ldc_w 4264
    //   145: invokeinterface 975 2 0
    //   150: iload 9
    //   152: invokeinterface 986 2 0
    //   157: invokeinterface 992 1 0
    //   162: invokeinterface 995 1 0
    //   167: invokestatic 4270	java/lang/Float:parseFloat	(Ljava/lang/String;)F
    //   170: fstore 4
    //   172: aload 14
    //   174: ldc_w 4271
    //   177: invokeinterface 975 2 0
    //   182: iload 9
    //   184: invokeinterface 986 2 0
    //   189: invokeinterface 992 1 0
    //   194: invokeinterface 995 1 0
    //   199: invokestatic 4270	java/lang/Float:parseFloat	(Ljava/lang/String;)F
    //   202: fstore_3
    //   203: iconst_1
    //   204: istore 10
    //   206: aload 14
    //   208: ldc_w 4272
    //   211: invokeinterface 975 2 0
    //   216: iload 9
    //   218: invokeinterface 986 2 0
    //   223: invokeinterface 992 1 0
    //   228: invokeinterface 995 1 0
    //   233: invokestatic 4270	java/lang/Float:parseFloat	(Ljava/lang/String;)F
    //   236: fstore 5
    //   238: aload 14
    //   240: ldc_w 4273
    //   243: invokeinterface 975 2 0
    //   248: iload 9
    //   250: invokeinterface 986 2 0
    //   255: invokeinterface 992 1 0
    //   260: invokeinterface 995 1 0
    //   265: invokestatic 4270	java/lang/Float:parseFloat	(Ljava/lang/String;)F
    //   268: fstore 8
    //   270: aload 14
    //   272: ldc_w 4275
    //   275: invokeinterface 975 2 0
    //   280: iload 9
    //   282: invokeinterface 986 2 0
    //   287: invokeinterface 992 1 0
    //   292: invokeinterface 995 1 0
    //   297: astore 11
    //   299: aload 14
    //   301: ldc_w 4276
    //   304: invokeinterface 975 2 0
    //   309: iload 9
    //   311: invokeinterface 986 2 0
    //   316: invokeinterface 992 1 0
    //   321: invokeinterface 995 1 0
    //   326: invokestatic 4270	java/lang/Float:parseFloat	(Ljava/lang/String;)F
    //   329: fstore 7
    //   331: aload 14
    //   333: ldc_w 4272
    //   336: invokeinterface 975 2 0
    //   341: iload 9
    //   343: invokeinterface 986 2 0
    //   348: invokeinterface 992 1 0
    //   353: invokeinterface 995 1 0
    //   358: invokestatic 4270	java/lang/Float:parseFloat	(Ljava/lang/String;)F
    //   361: fstore 6
    //   363: aload 14
    //   365: ldc_w 4278
    //   368: invokeinterface 975 2 0
    //   373: iload 9
    //   375: invokeinterface 986 2 0
    //   380: invokeinterface 992 1 0
    //   385: invokeinterface 995 1 0
    //   390: astore_1
    //   391: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   394: ifeq +296 -> 690
    //   397: ldc 189
    //   399: iconst_2
    //   400: new 85	java/lang/StringBuilder
    //   403: dup
    //   404: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   407: ldc_w 4280
    //   410: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   413: aload 13
    //   415: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   418: ldc_w 4282
    //   421: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   424: aload 12
    //   426: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   429: ldc_w 4284
    //   432: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   435: fload 4
    //   437: invokevirtual 4287	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   440: ldc_w 4289
    //   443: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   446: fload_3
    //   447: invokevirtual 4287	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   450: ldc_w 4291
    //   453: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   456: iload 10
    //   458: invokevirtual 152	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   461: ldc_w 4293
    //   464: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   467: fload 5
    //   469: invokevirtual 4287	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   472: ldc_w 4295
    //   475: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   478: fload 8
    //   480: invokevirtual 4287	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   483: ldc_w 4297
    //   486: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   489: aload 11
    //   491: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   494: ldc_w 4299
    //   497: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   500: fload 7
    //   502: invokevirtual 4287	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   505: ldc_w 4301
    //   508: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   511: aload_1
    //   512: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   515: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   518: invokestatic 206	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   521: goto +169 -> 690
    //   524: astore_1
    //   525: aload 14
    //   527: ldc_w 4302
    //   530: invokeinterface 975 2 0
    //   535: iload 9
    //   537: invokeinterface 986 2 0
    //   542: invokeinterface 992 1 0
    //   547: invokeinterface 995 1 0
    //   552: invokestatic 4270	java/lang/Float:parseFloat	(Ljava/lang/String;)F
    //   555: fstore_3
    //   556: goto -350 -> 206
    //   559: aload 13
    //   561: ifnull +126 -> 687
    //   564: aload 13
    //   566: invokevirtual 616	java/lang/String:trim	()Ljava/lang/String;
    //   569: ldc 13
    //   571: invokevirtual 636	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   574: ifne +113 -> 687
    //   577: new 85	java/lang/StringBuilder
    //   580: dup
    //   581: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   584: aload_0
    //   585: invokevirtual 47	arph:getAppRuntime	()Lmqq/app/AppRuntime;
    //   588: invokevirtual 2692	mqq/app/AppRuntime:getApplication	()Lmqq/app/MobileQQ;
    //   591: invokevirtual 2825	mqq/app/MobileQQ:getFilesDir	()Ljava/io/File;
    //   594: invokevirtual 2828	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   597: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   600: ldc_w 2858
    //   603: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   606: getstatic 15	arph:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   609: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   612: ldc_w 2858
    //   615: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   618: ldc_w 2903
    //   621: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   624: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   627: astore 14
    //   629: ldc_w 4304
    //   632: aload 13
    //   634: invokestatic 4309	com/tencent/mobileqq/msf/sdk/MsfSdkUtils:insertMtype	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   637: astore 13
    //   639: fload_3
    //   640: fstore 7
    //   642: fload_3
    //   643: fconst_0
    //   644: fcmpg
    //   645: ifge +8 -> 653
    //   648: ldc_w 854
    //   651: fstore 7
    //   653: new 4311	com/tencent/mobileqq/config/splashlogo/ConfigServlet$5
    //   656: dup
    //   657: aload_0
    //   658: aload 14
    //   660: aload 13
    //   662: fload 4
    //   664: fload 5
    //   666: fload 7
    //   668: aload 11
    //   670: aload_1
    //   671: fload 6
    //   673: iload 10
    //   675: iload_2
    //   676: aload 12
    //   678: invokespecial 4314	com/tencent/mobileqq/config/splashlogo/ConfigServlet$5:<init>	(Larph;Ljava/lang/String;Ljava/lang/String;FFFLjava/lang/String;Ljava/lang/String;FZILjava/lang/String;)V
    //   681: iconst_2
    //   682: aconst_null
    //   683: iconst_0
    //   684: invokestatic 3427	com/tencent/mobileqq/app/ThreadManager:post	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   687: return
    //   688: astore_1
    //   689: return
    //   690: iload 9
    //   692: iconst_1
    //   693: iadd
    //   694: istore 9
    //   696: fload_3
    //   697: fstore 5
    //   699: fload 6
    //   701: fstore_3
    //   702: fload 7
    //   704: fstore 6
    //   706: goto -636 -> 70
    //   709: astore_1
    //   710: ldc_w 4263
    //   713: astore_1
    //   714: goto -323 -> 391
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	717	0	this	arph
    //   0	717	1	paramString	String
    //   0	717	2	paramInt	int
    //   58	644	3	f1	float
    //   42	621	4	f2	float
    //   45	653	5	f3	float
    //   55	650	6	f4	float
    //   329	374	7	f5	float
    //   268	211	8	f6	float
    //   68	627	9	i	int
    //   48	626	10	bool	boolean
    //   52	617	11	str1	String
    //   39	638	12	str2	String
    //   65	596	13	str3	String
    //   23	636	14	localObject	Object
    //   35	38	15	localNodeList	NodeList
    // Exception table:
    //   from	to	target	type
    //   172	203	524	java/lang/Exception
    //   0	37	688	java/lang/Exception
    //   70	172	688	java/lang/Exception
    //   206	363	688	java/lang/Exception
    //   391	521	688	java/lang/Exception
    //   525	556	688	java/lang/Exception
    //   564	639	688	java/lang/Exception
    //   653	687	688	java/lang/Exception
    //   363	391	709	java/lang/Exception
  }
  
  private void e(Intent paramIntent, ConfigurationService.Config paramConfig)
  {
    paramIntent = paramIntent.getStringExtra("key_uin");
    if (!TextUtils.isEmpty(paramIntent))
    {
      int i = paramConfig.version.get();
      int j = bhhr.q(((QQAppInterface)getAppRuntime()).getApp(), paramIntent);
      if (QLog.isColorLevel()) {
        QLog.d("nearby_flower_operation_gray_tips", 2, "serverVersion=" + i + "|localVersion=" + j);
      }
      if (i != j)
      {
        bhhr.c(((QQAppInterface)getAppRuntime()).getApp(), paramIntent, i);
        anzp localanzp = (anzp)((QQAppInterface)getAppRuntime()).getManager(QQManagerFactory.NEARBY_FLOWER_MANAGER);
        if ((!paramConfig.content_list.has()) || (paramConfig.content_list.get().size() <= 0)) {
          break label247;
        }
        localList = paramConfig.content_list.get();
        if ((localList != null) && (localList.size() > 0))
        {
          localanzp.a(paramIntent, (String)localList.get(0));
          if (QLog.isColorLevel()) {
            QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 53,content: " + (String)localList.get(0) + ",version: " + paramConfig.version.get());
          }
        }
      }
    }
    label247:
    while (!QLog.isColorLevel())
    {
      List localList;
      return;
    }
    QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 53,content_list is empty ,version: " + paramConfig.version.get());
  }
  
  public static void e(QQAppInterface paramQQAppInterface, String paramString)
  {
    long l = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      axql.a("GENERAL_LBS_CONFIGS_CMD", new Object[] { "getGeneralLBSConfigs", paramString, Long.valueOf(l) });
    }
    paramString = new NewIntent(paramQQAppInterface.getApp(), arph.class);
    paramString.putExtra("k_cmd_type", new int[] { 87, 12, 174, 189 });
    paramQQAppInterface.startServlet(paramString);
  }
  
  private void e(ConfigurationService.Config paramConfig)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)getAppRuntime();
    int i = paramConfig.version.get();
    int j = bhhr.n(localQQAppInterface.getApp());
    if (QLog.isColorLevel()) {
      QLog.d("VideoDownCTWhiteList", 2, String.format("received VideoDownCTWhiteList remote version: %d, localVersion: %d, cmd: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(80) }));
    }
    if (i != j)
    {
      if ((paramConfig.content_list == null) || (paramConfig.content_list.size() <= 0)) {
        break label167;
      }
      str = (String)paramConfig.content_list.get(0);
      if (QLog.isColorLevel()) {
        QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 80,content: " + str + ",version: " + paramConfig.version.get());
      }
      bhhr.m(localQQAppInterface.getApp(), i, str);
    }
    label167:
    while (!QLog.isColorLevel())
    {
      String str;
      return;
    }
    QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 80,content_list is empty ,version: " + paramConfig.version.get());
  }
  
  private void e(String paramString, int paramInt)
  {
    for (;;)
    {
      int i;
      try
      {
        String str4 = getAppRuntime().getApplication().getFilesDir().getAbsolutePath() + "/splashpic/";
        Object localObject2 = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new ByteArrayInputStream(paramString.getBytes("utf-8")));
        NodeList localNodeList = ((Document)localObject2).getElementsByTagName("splash");
        String str3 = null;
        String str2 = null;
        Object localObject1 = null;
        paramString = "";
        String str1 = "";
        i = 0;
        if (i < localNodeList.getLength())
        {
          str3 = ((Document)localObject2).getElementsByTagName("img").item(i).getFirstChild().getNodeValue();
          str2 = ((Document)localObject2).getElementsByTagName("begin").item(i).getFirstChild().getNodeValue();
          localObject1 = ((Document)localObject2).getElementsByTagName("end").item(i).getFirstChild().getNodeValue();
          paramString = ((Document)localObject2).getElementsByTagName("md5").item(i).getFirstChild().getNodeValue();
          str1 = ((Document)localObject2).getElementsByTagName("channel").item(i).getFirstChild().getNodeValue();
          String str5 = ((Document)localObject2).getElementsByTagName("title").item(i).getFirstChild().getNodeValue();
          if (QLog.isColorLevel()) {
            QLog.i("SPLASH_ConfigServlet", 2, "parse result,img == " + str3 + " ,begin = " + str2 + " ,end=" + (String)localObject1 + ",md5=" + paramString + " title = " + str5);
          }
        }
        else
        {
          if ((str3 == null) || (str3.trim().equals(""))) {
            break;
          }
          str3 = MsfSdkUtils.insertMtype("ConfigCheck", str3);
          localObject2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
          str2 = ((SimpleDateFormat)localObject2).parse(str2).getTime() + "|" + ((SimpleDateFormat)localObject2).parse((String)localObject1).getTime();
          bhhr.a(getAppRuntime().getApplication(), paramInt, str2, paramString);
          new File(getAppRuntime().getApplication().getFilesDir().getAbsolutePath() + "/splashpic");
          if (((SimpleDateFormat)localObject2).parse((String)localObject1).getTime() < System.currentTimeMillis())
          {
            paramString = new File(str4 + paramString);
            if (paramString.exists()) {
              paramString.delete();
            }
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.i("SPLASH_ConfigServlet", 2, "this splash is outdate, throw it");
            return;
          }
          localObject1 = new File(str4 + paramString);
          localObject2 = new File(str4 + str2 + "_" + paramString + "_" + str1);
          if (((File)localObject2).exists()) {
            break;
          }
          if (QLog.isColorLevel()) {
            QLog.i("SPLASH_ConfigServlet", 2, "begin a thread try to download");
          }
          ThreadManager.post(new ConfigServlet.6(this, (File)localObject1, str3, paramString, (File)localObject2, str4, str2, str1, str3), 5, null, true);
          return;
        }
      }
      catch (Exception paramString)
      {
        return;
      }
      i += 1;
    }
  }
  
  private void f(Intent paramIntent, ConfigurationService.Config paramConfig)
  {
    paramIntent = paramIntent.getStringExtra("key_uin");
    if (!TextUtils.isEmpty(paramIntent))
    {
      int i = paramConfig.version.get();
      int j = bhhr.r(((QQAppInterface)getAppRuntime()).getApp(), paramIntent);
      if (QLog.isColorLevel()) {
        QLog.d("HotChatManager", 2, "serverVersion=" + i + "|localVersion=" + j);
      }
      if (i != j)
      {
        bhhr.d(((QQAppInterface)getAppRuntime()).getApp(), paramIntent, i);
        HotChatManager localHotChatManager = (HotChatManager)((QQAppInterface)getAppRuntime()).getManager(QQManagerFactory.HOT_CHAT_MANAGER);
        if ((!paramConfig.content_list.has()) || (paramConfig.content_list.get().size() <= 0)) {
          break label247;
        }
        localList = paramConfig.content_list.get();
        if ((localList != null) && (localList.size() > 0))
        {
          localHotChatManager.a(paramIntent, (String)localList.get(0));
          if (QLog.isColorLevel()) {
            QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 78,content: " + (String)localList.get(0) + ",version: " + paramConfig.version.get());
          }
        }
      }
    }
    label247:
    while (!QLog.isColorLevel())
    {
      List localList;
      return;
    }
    QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 78,content_list is empty ,version: " + paramConfig.version.get());
  }
  
  public static void f(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SPLASH_ConfigServlet", 2, "getPrecoverConfig, PRECOVER_CONFIG_CMD, uin=" + paramString);
    }
    paramString = (azod)paramQQAppInterface.getManager(QQManagerFactory.PRECOVER_MANAGER);
    if ((paramString != null) && (paramString.a() != null) && (paramString.a().d * 1000L <= 0L)) {}
    paramString = new NewIntent(paramQQAppInterface.getApp(), arph.class);
    paramString.putExtra("k_cmd_type", new int[] { 113 });
    paramQQAppInterface.startServlet(paramString);
  }
  
  private void f(ConfigurationService.Config paramConfig)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)getAppRuntime();
    int i = paramConfig.version.get();
    int j = bhhr.o(localQQAppInterface.getApp());
    if (QLog.isColorLevel()) {
      QLog.d("MixMsgForwardConfig", 2, String.format("received MixMsgForwardConfig remote version: %d, localVersion: %d, cmd: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(111) }));
    }
    if (i != j)
    {
      if ((paramConfig.content_list == null) || (paramConfig.content_list.size() <= 0)) {
        break label167;
      }
      str = (String)paramConfig.content_list.get(0);
      if (QLog.isColorLevel()) {
        QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 111,content: " + str + ",version: " + paramConfig.version.get());
      }
      bhhr.n(localQQAppInterface.getApp(), i, str);
    }
    label167:
    while (!QLog.isColorLevel())
    {
      String str;
      return;
    }
    QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 111,content_list is empty ,version:" + paramConfig.version.get());
  }
  
  private void g(Intent paramIntent, ConfigurationService.Config paramConfig)
  {
    paramIntent = PtvTemplateManager.a((QQAppInterface)getAppRuntime());
    int j = paramConfig.version.get();
    int i = bhhr.g(((QQAppInterface)getAppRuntime()).getApp());
    if (!PtvTemplateManager.a()) {
      i = 0;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PtvTemplateManager", 2, "serverVersion=" + j + "|localVersion=" + i);
    }
    if (j != i)
    {
      bhhr.e(((QQAppInterface)getAppRuntime()).getApp(), j);
      if ((!paramConfig.content_list.has()) || (paramConfig.content_list.get().size() <= 0)) {
        break label239;
      }
      localList = paramConfig.content_list.get();
      if ((localList != null) && (localList.size() > 0))
      {
        paramIntent.a((String)localList.get(0), (QQAppInterface)getAppRuntime(), 1);
        if (QLog.isColorLevel()) {
          QLog.d("PtvTemplateManager", 2, "receiveAllConfigs|type: 84,content: " + (String)localList.get(0) + ",version: " + paramConfig.version.get());
        }
      }
    }
    label239:
    while (!QLog.isColorLevel())
    {
      List localList;
      return;
    }
    QLog.d("PtvTemplateManager", 2, "receiveAllConfigs|type: 84,content_list is empty ,version: " + paramConfig.version.get());
  }
  
  public static void g(QQAppInterface paramQQAppInterface, String paramString)
  {
    jdField_a_of_type_JavaLangString = paramString;
    a(paramQQAppInterface, 185);
  }
  
  private void g(ConfigurationService.Config paramConfig)
  {
    PtvTemplateManager localPtvTemplateManager = PtvTemplateManager.a((QQAppInterface)getAppRuntime());
    int k = paramConfig.version.get();
    int i = bhhr.j(((QQAppInterface)getAppRuntime()).getApp());
    if (!PtvTemplateManager.c()) {
      i = 0;
    }
    int j;
    if (paramConfig.msg_content_list != null)
    {
      j = paramConfig.msg_content_list.size();
      if (QLog.isColorLevel()) {
        QLog.d("Doodle_Strokes_SPLASH_ConfigServlet", 2, String.format("个性笔触配置回包, serverVersion[%s], localVersion[%s], size[%s]", new Object[] { Integer.valueOf(k), Integer.valueOf(i), Integer.valueOf(j) }));
      }
      if (k != i) {
        break label115;
      }
    }
    label115:
    do
    {
      do
      {
        return;
        j = -1;
        break;
        if (j <= 0) {
          break label214;
        }
        paramConfig = b(paramConfig, i, 139);
        if (TextUtils.isEmpty(paramConfig)) {
          break label197;
        }
        localPtvTemplateManager.a(paramConfig, (QQAppInterface)getAppRuntime());
        bhhr.h(((QQAppInterface)getAppRuntime()).getApp(), k);
      } while (!QLog.isColorLevel());
      QLog.d("SPLASH_ConfigServletDoodle_Strokes_", 2, "GetDoodleTemplateConfig|type: 个性笔触配置回包内容, content: \n" + paramConfig);
      return;
    } while (!QLog.isColorLevel());
    label197:
    QLog.d("Doodle_Strokes_SPLASH_ConfigServlet", 2, "GetDoodleTemplateConfig|type: 个性笔触配置回包内容为空");
    return;
    label214:
    if (QLog.isColorLevel()) {
      QLog.d("Doodle_Strokes_SPLASH_ConfigServlet", 2, "GetDoodleTemplateConfig|type: 个性笔触配置回包为空");
    }
    localPtvTemplateManager.c();
  }
  
  private void h(Intent paramIntent, ConfigurationService.Config paramConfig)
  {
    paramIntent = PtvTemplateManager.a((QQAppInterface)getAppRuntime());
    int j = paramConfig.version.get();
    int i = bhhr.i(((QQAppInterface)getAppRuntime()).getApp());
    if (!PtvTemplateManager.b()) {
      i = 0;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PtvTemplateManager", 2, "serverVersion=" + j + "|localVersion=" + i);
      }
      if (j != i)
      {
        bhhr.g(((QQAppInterface)getAppRuntime()).getApp(), j);
        String str = b(paramConfig, i, 167);
        if (str == null) {
          break label187;
        }
        paramIntent.a(str, (QQAppInterface)getAppRuntime(), 2);
        if (QLog.isColorLevel()) {
          QLog.d("PtvTemplateManager", 2, "receiveAllConfigs|type: 167,content: " + str + ",version: " + paramConfig.version.get());
        }
      }
      label187:
      while (!QLog.isColorLevel()) {
        return;
      }
      QLog.d("PtvTemplateManager", 2, "receiveAllConfigs|type: 167,content_list is empty ,version: " + paramConfig.version.get());
      return;
    }
  }
  
  private void h(ConfigurationService.Config paramConfig)
  {
    bpqv localbpqv = bpqv.a();
    int k = paramConfig.version.get();
    int i = bhhr.E(((QQAppInterface)getAppRuntime()).getApp());
    if (!localbpqv.a()) {
      i = 0;
    }
    int j;
    if (paramConfig.msg_content_list != null)
    {
      j = paramConfig.msg_content_list.size();
      if (QLog.isColorLevel()) {
        QLog.d("QQSTORY_FOLLOW_CAPTURE_SPLASH_ConfigServlet", 2, String.format("合拍配置回包, serverVersion[%s], localVersion[%s], size[%s]", new Object[] { Integer.valueOf(k), Integer.valueOf(i), Integer.valueOf(j) }));
      }
      if (k != i) {
        break label110;
      }
    }
    label110:
    do
    {
      do
      {
        return;
        j = -1;
        break;
        if (j <= 0) {
          break label212;
        }
        paramConfig = b(paramConfig, i, 329);
        if (TextUtils.isEmpty(paramConfig)) {
          break label195;
        }
        if (QLog.isColorLevel()) {
          QLog.d("QQSTORY_FOLLOW_CAPTURE_SPLASH_ConfigServlet", 2, "GetQQStoryFollowCaptureConfig|type: 合拍配置内容, content: \n" + paramConfig);
        }
      } while (!localbpqv.a(paramConfig, (QQAppInterface)getAppRuntime()));
      bhhr.t(((QQAppInterface)getAppRuntime()).getApp(), k);
      return;
    } while (!QLog.isColorLevel());
    label195:
    QLog.d("QQSTORY_FOLLOW_CAPTURE_SPLASH_ConfigServlet", 2, "GetQQStoryFollowCaptureConfig|type: 合拍配置回包内容为空");
    return;
    label212:
    if (QLog.isColorLevel()) {
      QLog.d("QQSTORY_FOLLOW_CAPTURE_SPLASH_ConfigServlet", 2, "GetQQStoryFollowCaptureConfig|type: 合拍配置回包为空");
    }
    localbpqv.a();
  }
  
  private void i(Intent paramIntent, ConfigurationService.Config paramConfig)
  {
    NearbyGrayTipsManager localNearbyGrayTipsManager;
    String str2;
    if (!TextUtils.isEmpty(paramIntent.getStringExtra("key_uin")))
    {
      int i = paramConfig.version.get();
      int j = bhhr.e(((QQAppInterface)getAppRuntime()).getApp());
      if (QLog.isColorLevel()) {
        QLog.d("nearby_aio_operation_gray_tips", 2, "serverVersion=" + i + "|localVersion=" + j);
      }
      if (i != j)
      {
        bhhr.c(((QQAppInterface)getAppRuntime()).getApp(), i);
        localNearbyGrayTipsManager = (NearbyGrayTipsManager)((QQAppInterface)getAppRuntime()).getManager(QQManagerFactory.NEARBY_GRAY_TIPS_MANAGER);
        if ((!paramConfig.content_list.has()) || (paramConfig.content_list.get().size() <= 0)) {
          break label482;
        }
        paramIntent = paramConfig.content_list.get();
        if (QLog.isColorLevel()) {
          QLog.d("nearby_aio_operation_gray_tips", 2, "config.content_list size=" + paramIntent.size());
        }
        if ((paramIntent != null) && (paramIntent.size() > 0))
        {
          localNearbyGrayTipsManager.b();
          Iterator localIterator = paramIntent.iterator();
          do
          {
            if (!localIterator.hasNext()) {
              break;
            }
            str2 = (String)localIterator.next();
            if (QLog.isColorLevel()) {
              QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 23,content: " + str2 + ",version: " + paramConfig.version.get());
            }
          } while (StringUtil.isEmpty(str2));
        }
      }
    }
    for (;;)
    {
      try
      {
        Object localObject = new JSONObject(str2);
        if (((JSONObject)localObject).isNull("MD5")) {
          break label532;
        }
        str1 = ((JSONObject)localObject).getString("MD5");
        paramIntent = str1;
        if (!TextUtils.isEmpty(str1)) {
          paramIntent = str1.toLowerCase();
        }
        if (((JSONObject)localObject).isNull("URL")) {
          break label526;
        }
        str1 = ((JSONObject)localObject).getString("URL");
        if (StringUtil.isEmpty(str1)) {
          break;
        }
        localObject = NearbyGrayTipsManager.a();
        ThreadManager.post(new ConfigServlet.8(this, str1, new File((String)localObject + "temp.txt"), paramIntent, localNearbyGrayTipsManager), 8, null, false);
      }
      catch (JSONException paramIntent)
      {
        if (QLog.isColorLevel()) {
          QLog.d("nearby_aio_operation_gray_tips", 2, "JSONException was thrown when parse json!!! string=" + str2);
        }
        paramIntent.printStackTrace();
      }
      break;
      localNearbyGrayTipsManager.a();
      localNearbyGrayTipsManager.a(true);
      return;
      label482:
      if (QLog.isColorLevel()) {
        QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 23,content_list is empty ,version: " + paramConfig.version.get());
      }
      localNearbyGrayTipsManager.b();
      return;
      label526:
      String str1 = null;
      continue;
      label532:
      paramIntent = null;
    }
  }
  
  private void i(ConfigurationService.Config paramConfig)
  {
    int i = paramConfig.version.get();
    bhhr.h(getAppRuntime().getApplication(), i, jdField_a_of_type_JavaLangString);
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramConfig.content_list != null)
    {
      localObject1 = localObject2;
      if (paramConfig.content_list.size() > 0) {
        localObject1 = paramConfig.content_list.get();
      }
    }
    if ((localObject1 != null) && (((List)localObject1).size() > 0))
    {
      localObject1 = (String)((List)localObject1).get(0);
      if (QLog.isColorLevel()) {
        QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 102,content: " + (String)localObject1 + ",version: " + paramConfig.version.get());
      }
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {}
      try
      {
        paramConfig = Xml.newPullParser();
        paramConfig.setInput(new ByteArrayInputStream(((String)localObject1).getBytes()), "UTF-8");
        for (i = 0; i != 1; i = paramConfig.next()) {
          if ((i == 2) && (paramConfig.getName().equalsIgnoreCase("JA_Switch"))) {
            JumpActivity.a(paramConfig.nextText(), true);
          }
        }
        while (!QLog.isColorLevel()) {}
      }
      catch (Exception paramConfig)
      {
        paramConfig = paramConfig;
        paramConfig.printStackTrace();
        return;
      }
      finally {}
    }
    QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 102,content_list is empty ,version: " + paramConfig.version.get());
  }
  
  private void j(Intent paramIntent, ConfigurationService.Config paramConfig)
  {
    int j = 0;
    paramIntent = (QQAppInterface)getAppRuntime();
    int i = paramConfig.version.get();
    if (i == bhhr.o(((QQAppInterface)getAppRuntime()).getApp(), jdField_a_of_type_JavaLangString)) {}
    for (;;)
    {
      return;
      bhhr.k(((QQAppInterface)getAppRuntime()).getApp(), i, jdField_a_of_type_JavaLangString);
      if ((paramConfig.content_list == null) || (paramConfig.content_list.size() <= 0)) {
        continue;
      }
      Object localObject1 = paramConfig.content_list.get();
      if ((localObject1 == null) || (((List)localObject1).size() <= 0)) {
        continue;
      }
      HashMap localHashMap = new HashMap();
      i = 0;
      if (i < ((List)localObject1).size())
      {
        Object localObject2 = (String)((List)localObject1).get(i);
        if (QLog.isColorLevel()) {
          QLog.d("Q.qqstory.fourTab", 2, "receiveAllConfigs|type: 115,content: " + (String)localObject2 + ",version: " + paramConfig.version.get());
        }
        if (TextUtils.isEmpty((CharSequence)localObject2)) {}
        for (;;)
        {
          i += 1;
          break;
          localObject2 = ((String)localObject2).split("=");
          if ((localObject2 != null) && (localObject2.length == 2))
          {
            localHashMap.put(localObject2[0], localObject2[1]);
            if (QLog.isColorLevel()) {
              QLog.i("Q.qqstory.fourTab", 2, "NowTabConfigCmd, name=" + localObject2[0] + ", val=" + localObject2[1]);
            }
          }
        }
      }
      paramConfig = (String)localHashMap.get("mqq_nowtab_plan");
      if (QLog.isColorLevel()) {
        QLog.i("nowtabPlan", 2, "nowtabPlan=" + paramConfig);
      }
      if (paramConfig != null) {}
      try
      {
        localObject1 = paramIntent.getNowLiveManager().a();
        i = Integer.valueOf("" + ((String)localObject1).charAt(2)).intValue();
        k = Integer.valueOf(paramConfig).intValue();
        if (i != k)
        {
          localObject1 = new Integer[5];
          i = j;
        }
        switch (k)
        {
        case 0: 
          paramIntent.getNowLiveManager().a = paramConfig.charAt(0);
          paramConfig = (String)localHashMap.get("mqq_nowtab_index");
          if (QLog.isColorLevel()) {
            QLog.i("Q.qqstory.fourTab:nowtabIndex", 2, "nowtabIndex=" + paramConfig);
          }
          if (paramConfig == null) {}
          break;
        }
      }
      catch (Exception paramConfig)
      {
        for (;;)
        {
          try
          {
            int k;
            for (;;)
            {
              paramIntent.getApp().getSharedPreferences("now_tab_sp", 0).edit().putInt("now_index_key", Integer.valueOf(paramConfig).intValue());
              paramIntent.getNowLiveManager().c = Integer.valueOf(paramConfig).intValue();
              paramConfig = (String)localHashMap.get("mqq_open_myvideo");
              if (QLog.isColorLevel()) {
                QLog.i("Q.qqstory:IsOpenMyVideo", 2, "IsOpenMyVideo=" + paramConfig);
              }
              try
              {
                if (TextUtils.isEmpty(paramConfig)) {
                  break;
                }
                ((vzv)paramIntent.getManager(QQManagerFactory.QQSTORY_MANAGER)).h(Boolean.parseBoolean(paramConfig));
                return;
              }
              catch (Exception paramIntent)
              {
                QLog.w("Q.qqstory:drawerMyVideoItem", 2, "drawerMyVideoItem is not value of Int!");
                return;
              }
            }
            if (i < localObject1.length)
            {
              localObject1[i] = Integer.valueOf(0);
              i += 1;
            }
            else
            {
              localObject1[2] = Integer.valueOf(k);
              if (QLog.isColorLevel()) {
                QLog.i("Q.qqstory.fourTab:nowtabPlan", 2, "case 0 1 nowtabPlan=" + paramConfig);
              }
              paramIntent.getNowLiveManager().a((Integer[])localObject1);
              continue;
              paramConfig = paramConfig;
              QLog.w("Q.qqstory.fourTab:nowtabPlan", 2, "" + paramConfig.getMessage(), paramConfig);
              continue;
              localObject1[1] = Integer.valueOf(0);
              localObject1[2] = Integer.valueOf(k);
              paramIntent.getNowLiveManager().a((Integer[])localObject1);
              if (QLog.isColorLevel())
              {
                QLog.i("Q.qqstory.fourTab:nowtabPlan", 2, "case 2 nowtabPlan=" + paramConfig);
                continue;
                localObject1[2] = Integer.valueOf(k);
                localObject1[1] = Integer.valueOf(1);
                paramIntent.getNowLiveManager().a((Integer[])localObject1);
                if (QLog.isColorLevel()) {
                  QLog.i("Q.qqstory.fourTab:nowtabPlan", 2, "case 3 nowtabPlan=" + paramConfig);
                }
              }
            }
          }
          catch (Exception paramConfig)
          {
            QLog.w("Q.qqstory.fourTab:nowtabIndex", 2, "nowtabIndex is not value of Int!");
          }
        }
      }
    }
  }
  
  private void j(ConfigurationService.Config paramConfig)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)getAppRuntime();
    if (QLog.isColorLevel()) {
      QLog.d("MobileUnityManager", 2, "CMD_PHONE_UNITY_BANNER_CONFIG");
    }
    ajco localajco = (ajco)localQQAppInterface.getManager(QQManagerFactory.PHONE_UNITY_MANAGER);
    i = localajco.a();
    int m = paramConfig.version.get();
    if (QLog.isColorLevel()) {
      QLog.d("SPLASH_ConfigServlet", 2, "newVersion " + m);
    }
    if (i == m) {
      return;
    }
    localObject1 = null;
    Object localObject2;
    Object localObject6;
    if ((paramConfig.content_list != null) && (paramConfig.content_list.size() > 0))
    {
      localObject2 = paramConfig.content_list.get();
      localObject6 = localObject1;
      if (localObject2 != null)
      {
        localObject6 = localObject1;
        if (((List)localObject2).size() > 0)
        {
          localObject1 = (String)((List)localObject2).get(0);
          localObject6 = localObject1;
          if (QLog.isColorLevel())
          {
            QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 34,content: " + (String)localObject1 + ",version: " + paramConfig.version.get());
            localObject6 = localObject1;
          }
        }
      }
    }
    for (;;)
    {
      try
      {
        if (TextUtils.isEmpty(localObject6)) {
          continue;
        }
        localajcn2 = new ajcn();
      }
      catch (Throwable localThrowable2)
      {
        ajcn localajcn2;
        XmlPullParser localXmlPullParser;
        int k;
        Object localObject3;
        ajcn localajcn1 = null;
        i = 0;
        paramConfig = null;
        localObject1 = null;
        continue;
        localajcn1 = null;
        int j = 0;
        Object localObject4 = null;
        Object localObject5 = null;
        continue;
      }
      try
      {
        localXmlPullParser = Xml.newPullParser();
        localXmlPullParser.setInput(new ByteArrayInputStream(localObject6.getBytes()), "UTF-8");
        i = 0;
        paramConfig = null;
        localObject1 = null;
        k = 0;
        localajcn1 = localajcn2;
        j = i;
        localObject2 = paramConfig;
        localObject5 = localObject1;
        if (k == 1) {
          continue;
        }
        if (k != 2) {
          continue;
        }
        try
        {
          localObject2 = localXmlPullParser.getName();
          if (!((String)localObject2).equalsIgnoreCase("banner")) {
            continue;
          }
          k = localXmlPullParser.getAttributeCount();
          j = 0;
          if (j >= k) {
            continue;
          }
          localObject2 = localXmlPullParser.getAttributeName(j);
          if ("text".equals(localObject2))
          {
            localajcn2.jdField_b_of_type_JavaLangString = localXmlPullParser.getAttributeValue(j);
            j += 1;
            continue;
            localObject6 = localObject1;
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 34,content_list is empty ,version: " + paramConfig.version.get());
            localObject6 = localObject1;
            continue;
          }
          if (!"url".equals(localObject2)) {
            continue;
          }
          localajcn2.jdField_a_of_type_JavaLangString = localXmlPullParser.getAttributeValue(j);
          continue;
          QLog.e("PhoneContact.Manager", 1, "", localThrowable1);
        }
        catch (Throwable localThrowable1)
        {
          localajcn1 = localajcn2;
        }
      }
      catch (Throwable localThrowable3)
      {
        i = 0;
        paramConfig = null;
        localObject1 = null;
        localajcn1 = localajcn2;
        continue;
        continue;
        continue;
      }
      localObject5 = localObject1;
      localObject3 = paramConfig;
      j = i;
      localajco.a(m, localObject6, localajcn1);
      ((PhoneContactManagerImp)localQQAppInterface.getManager(QQManagerFactory.CONTACT_MANAGER)).a(j, localObject5, (String)localObject3);
      return;
      if ("dayNum".equals(localObject3)) {
        localajcn2.jdField_a_of_type_Int = Integer.valueOf(localXmlPullParser.getAttributeValue(j)).intValue();
      } else if ("dayIntervalNum".equals(localObject3)) {
        localajcn2.jdField_b_of_type_Int = Integer.valueOf(localXmlPullParser.getAttributeValue(j)).intValue();
      } else if ("totalNum".equals(localObject3)) {
        localajcn2.c = Integer.valueOf(localXmlPullParser.getAttributeValue(j)).intValue();
      } else if ("loginNum".equals(localObject3)) {
        localajcn2.e = Integer.valueOf(localXmlPullParser.getAttributeValue(j)).intValue();
      } else if ("banner".equals(localObject3)) {
        localajcn2.jdField_a_of_type_Boolean = "1".equals(localXmlPullParser.getAttributeValue(j));
      } else if ("setEntry".equals(localObject3)) {
        localajcn2.jdField_b_of_type_Boolean = "1".equals(localXmlPullParser.getAttributeValue(j));
      }
    }
    for (;;)
    {
      try
      {
        k = localXmlPullParser.next();
      }
      catch (Throwable localThrowable4)
      {
        localajcn1 = localajcn2;
      }
      if (((String)localObject3).equalsIgnoreCase("bindGuideWording"))
      {
        localObject3 = localXmlPullParser.nextText();
        localObject1 = localObject3;
      }
      else if (((String)localObject3).equalsIgnoreCase("bindGuideStyle"))
      {
        j = Integer.valueOf(localXmlPullParser.nextText()).intValue();
        i = j;
      }
      else
      {
        if (!((String)localObject3).equalsIgnoreCase("guideWording")) {
          break label838;
        }
        localObject3 = localXmlPullParser.nextText();
        paramConfig = (ConfigurationService.Config)localObject3;
      }
    }
  }
  
  private void k(Intent paramIntent, ConfigurationService.Config paramConfig)
  {
    paramIntent = (QQAppInterface)getAppRuntime();
    int i = paramConfig.version.get();
    int j = bhhr.p(((QQAppInterface)getAppRuntime()).getApp(), jdField_a_of_type_JavaLangString);
    if (i == j) {}
    label179:
    label195:
    do
    {
      do
      {
        return;
        bhhr.l(((QQAppInterface)getAppRuntime()).getApp(), i, jdField_a_of_type_JavaLangString);
        for (;;)
        {
          try
          {
            if (paramConfig.msg_content_list != null)
            {
              i = paramConfig.msg_content_list.size();
              paramIntent = (avuq)paramIntent.getManager(QQManagerFactory.NOW_DOWNLOAD_ENGINE_MANAGER);
              if (i <= 0) {
                break label195;
              }
              paramConfig = b(paramConfig, j, 286);
              paramIntent.a(paramConfig);
              if (TextUtils.isEmpty(paramConfig)) {
                break label179;
              }
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.d("SPLASH_ConfigServlet", 2, "GetDoodleTemplateConfig|type: handleNowDownloadEngineConfigCmd, content: \n" + paramConfig);
              return;
            }
          }
          catch (Exception paramIntent)
          {
            QLog.e("SPLASH_ConfigServlet", 2, "Exception e = " + paramIntent.toString());
            return;
          }
          i = -1;
        }
      } while (!QLog.isColorLevel());
      QLog.d("SPLASH_ConfigServlet", 2, "GetDoodleTemplateConfig|type: handleNowDownloadEngineConfigCmd null");
      return;
      paramIntent.a("");
    } while (!QLog.isColorLevel());
    QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 286,content_list is empty ,version: " + paramConfig.version.get());
  }
  
  private void k(ConfigurationService.Config paramConfig)
  {
    for (;;)
    {
      int i;
      try
      {
        QQAppInterface localQQAppInterface = (QQAppInterface)getAppRuntime();
        if ((paramConfig.content_list != null) && (paramConfig.content_list.size() > 0))
        {
          i = 0;
          if (i < paramConfig.content_list.size())
          {
            String str = (String)paramConfig.content_list.get(i);
            if (QLog.isColorLevel()) {
              QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 66,content: " + str + ",version: " + paramConfig.version.get());
            }
            int j = paramConfig.version.get();
            int k = bhhr.A(localQQAppInterface.getApp(), localQQAppInterface.getAccount());
            if (QLog.isColorLevel()) {
              QLog.d("SPLASH_ConfigServlet", 2, "received SUBSCRIPT_RECOMMEND_CMD remote version: " + j + " | localVersion: " + k);
            }
            if ((j != k) || (paramConfig.content_list.size() > 0))
            {
              if ((usu.a((QQAppInterface)getAppRuntime(), str)) && (QLog.isColorLevel())) {
                QLog.d("SPLASH_ConfigServlet", 2, "received SUBSCRIPT_RECOMMEND_CMD save version: " + j);
              }
              bhhr.l(getAppRuntime().getApplication(), localQQAppInterface.getAccount(), j);
            }
            else if (QLog.isColorLevel())
            {
              QLog.d("SPLASH_ConfigServlet", 2, "received SUBSCRIPT_RECOMMEND_CMD IGNORE THIS ACTION  because of SAME VERSION");
            }
          }
        }
      }
      catch (Exception paramConfig)
      {
        if (QLog.isColorLevel()) {
          QLog.e("SPLASH_ConfigServlet", 2, "received subscript recommend config error,cmd : 66");
        }
      }
      while (!QLog.isColorLevel()) {
        return;
      }
      QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 66,content_list is empty ,version: " + paramConfig.version.get());
      return;
      i += 1;
    }
  }
  
  private void l(Intent paramIntent, ConfigurationService.Config paramConfig)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)getAppRuntime();
    if ((paramConfig.content_list != null) && (paramConfig.content_list.size() > 0)) {}
    for (Object localObject1 = paramConfig.content_list.get();; localObject1 = null)
    {
      HashMap localHashMap;
      int i;
      Object localObject2;
      Object localObject3;
      label863:
      label881:
      boolean bool;
      if ((localObject1 != null) && (((List)localObject1).size() > 0))
      {
        localHashMap = new HashMap();
        i = 0;
        if (i < ((List)localObject1).size())
        {
          localObject2 = (String)((List)localObject1).get(i);
          if (QLog.isColorLevel()) {
            QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 101,content: " + (String)localObject2 + ",version: " + paramConfig.version.get());
          }
          if (TextUtils.isEmpty((CharSequence)localObject2)) {}
          for (;;)
          {
            i += 1;
            break;
            localObject2 = ((String)localObject2).split("=");
            if ((localObject2 != null) && (localObject2.length == 2))
            {
              localHashMap.put(localObject2[0], localObject2[1]);
              if (QLog.isColorLevel()) {
                QLog.i("SPLASH_ConfigServlet", 2, "GENERAL_CONFIGS_CMD, name=" + localObject2[0] + ", val=" + localObject2[1]);
              }
            }
          }
        }
        localObject2 = (String)localHashMap.get("ptlogin_flag");
        localObject1 = BaseApplication.getContext().getSharedPreferences("mobileQQ", 4);
        ((SharedPreferences)localObject1).edit().putBoolean("ptlogin_flag" + getAppRuntime().getAccount(), "1".equalsIgnoreCase((String)localObject2)).commit();
        localObject2 = (String)localHashMap.get("lmr_block");
        if (QLog.isColorLevel()) {
          QLog.i("new_regprxy_switch", 2, "GENERAL_CONFIGS_CMD, new_regprxy_switch=" + (String)localObject2);
        }
        if (localObject2 != null) {
          BaseApplication.getContext().getSharedPreferences("mobileQQ", 0).edit().putBoolean("new_regprxy_switch", "1".equalsIgnoreCase((String)localObject2)).commit();
        }
        localObject2 = (String)localHashMap.get("qfind_report_gps_bt_stat");
        String str = (String)localHashMap.get("qfind_searching");
        localObject3 = ((SharedPreferences)localObject1).edit();
        ((SharedPreferences.Editor)localObject3).putBoolean("qfind_searching" + getAppRuntime().getAccount(), "1".equals(str));
        ((SharedPreferences.Editor)localObject3).putBoolean("qfind_report_gps_bt_stat" + getAppRuntime().getAccount(), "1".equals(localObject2));
        ((SharedPreferences.Editor)localObject3).commit();
        if (QLog.isColorLevel()) {
          QLog.w("QFind", 2, "qfind flags qfindStatFlag=" + (String)localObject2 + ", qfind_searching=" + str);
        }
        localObject2 = (String)localHashMap.get("enable_public_device");
        if (localObject2 != null) {
          BaseApplication.getContext().getSharedPreferences("smartdevice_entry", 4).edit().putBoolean("enable_public_device" + "_" + getAppRuntime().getAccount(), "1".equalsIgnoreCase((String)localObject2)).commit();
        }
        localObject2 = (String)localHashMap.get("search_device_enable_https");
        if (localObject2 != null)
        {
          BaseApplication.getContext().getSharedPreferences("smartdevice_entry", 4).edit().putBoolean("search_device_enable_https" + "_" + getAppRuntime().getAccount(), "1".equalsIgnoreCase((String)localObject2)).commit();
          if (QLog.isColorLevel()) {
            QLog.w("smartdevice", 2, "search_device_enable_https=" + (String)localObject2);
          }
        }
        localObject2 = (String)localHashMap.get("mqq_calltab");
        str = (String)localHashMap.get("mqq_calltab_setting");
        if ((localObject2 != null) || (str != null))
        {
          localObject3 = new Integer[7];
          if (localObject2 != null)
          {
            if (((String)localObject2).indexOf('|') <= 0) {
              break label2076;
            }
            if (localObject2.split("|")[0].equals("1"))
            {
              i = 1;
              localObject3[1] = Integer.valueOf(i);
            }
          }
          else
          {
            if (str != null)
            {
              if (!str.equals("1")) {
                break label2105;
              }
              i = 1;
              localObject3[5] = Integer.valueOf(i);
            }
            localQQAppInterface.writeCallTabStateVal((Integer[])localObject3);
          }
        }
        else
        {
          localObject3 = (String)localHashMap.get("subscribe_discovery");
          if (!TextUtils.isEmpty((CharSequence)localObject3))
          {
            uqm.d(localQQAppInterface, "1".equals(localObject3));
            if (QLog.isColorLevel()) {
              QLog.d("SPLASH_ConfigServlet", 2, "subscribe discovery btn config : " + (String)localObject3);
            }
          }
          if ((localObject2 == null) || (str == null))
          {
            localObject3 = new Integer[7];
            if (localObject2 == null)
            {
              localObject3[1] = Integer.valueOf("0111100".charAt(1) - '0');
              localObject3[2] = Integer.valueOf("0111100".charAt(2) - '0');
            }
            if (str == null)
            {
              localObject3[5] = Integer.valueOf("0111100".charAt(5) - '0');
              localObject3[6] = Integer.valueOf("0111100".charAt(6) - '0');
            }
            localQQAppInterface.writeCallTabStateVal((Integer[])localObject3);
          }
          localObject2 = (String)localHashMap.get("share_to_news");
          if (localObject2 != null) {
            bmhv.a((String)localObject2, localQQAppInterface);
          }
          localObject2 = (String)localHashMap.get("synchronize_to_qzone");
          if (localObject2 != null) {
            bmhv.b((String)localObject2, localQQAppInterface);
          }
          localObject2 = (String)localHashMap.get("merge_feeds");
          if (localObject2 != null) {
            bmhv.d((String)localObject2, localQQAppInterface);
          }
          localObject2 = (String)localHashMap.get("kandian_feeds");
          if (localObject2 != null) {
            bmhv.e((String)localObject2, localQQAppInterface);
          }
          i = paramConfig.version.get();
          bhhr.g(getAppRuntime().getApplication(), i, jdField_a_of_type_JavaLangString);
          if ((paramIntent != null) && (paramIntent.hasExtra("update101Version"))) {
            SettingCloneUtil.writeValueForInt(getAppRuntime().getApplication(), jdField_a_of_type_JavaLangString, null, "qqsetting_calltab_show_key_version", paramIntent.getIntExtra("update101Version", 0));
          }
          ArkAppCenter.a((String)localHashMap.get("arkapp_pa_nshow"));
          axqc.a(localQQAppInterface.getAccount(), "supportHotChatDemo", Boolean.valueOf("1".equals(localHashMap.get("hotchat_demo"))));
          paramIntent = (bahk)localQQAppInterface.getManager(QQManagerFactory.PTT_CFG_MANAGER);
          paramIntent.a((String)localHashMap.get("ptt_stream_slice_cfg"));
          paramIntent.b((String)localHashMap.get("ptt_optimize_cfg_v2"));
          paramIntent.c((String)localHashMap.get("ptt_pre_download"));
          paramIntent = (String)localHashMap.get("splashpic_charm_requirement");
          if (paramIntent != null) {
            HotChatManager.a(localQQAppInterface, paramIntent);
          }
          paramIntent = (String)localHashMap.get("kFreezeTipsShow");
          paramConfig = localQQAppInterface.getApp();
          if (Build.VERSION.SDK_INT <= 10) {
            break label2110;
          }
          i = 4;
          label1378:
          paramConfig = paramConfig.getSharedPreferences("qwallet_multi", i);
          if (paramConfig != null)
          {
            paramConfig = paramConfig.edit();
            if ((!TextUtils.isEmpty(paramIntent)) && (!"1".equals(paramIntent))) {
              break label2115;
            }
            bool = true;
            label1418:
            paramConfig.putBoolean("is_tenpay_yellowtip_valid", bool);
            paramIntent = (String)localHashMap.get("publicWhiteList");
            QWalletHelper.updatePublicAccWhiteMap(paramIntent);
            paramConfig.putString("publicAcc_white_list", paramIntent);
            paramConfig.commit();
          }
          QWalletHelper.updateHongBaoSpeedWitch(localQQAppInterface, (String)localHashMap.get("hongbao_speed"));
          paramIntent = (String)localHashMap.get("shortvideo_predownload_strategy");
          if (paramIntent == null) {}
        }
      }
      for (;;)
      {
        try
        {
          i = Integer.valueOf(paramIntent).intValue();
          localQQAppInterface.getShortVideoPredownloer().a.set(i);
          paramIntent = (String)localHashMap.get("camera_compatible_list");
          if (paramIntent == null) {}
        }
        catch (Exception paramIntent)
        {
          try
          {
            bdaw.a(paramIntent, true);
            paramIntent = (String)localHashMap.get("qqwifi_provider_mask");
            if (paramIntent != null) {
              ((SharedPreferences)localObject1).edit().putString("qqwifi_provider_mask", paramIntent).commit();
            }
            paramIntent = (String)localHashMap.get("signalling_switch");
            if (QLog.isColorLevel()) {
              QLog.i("signalling_switch", 2, "GENERAL_CONFIGS_CMD, signalling_switch=" + paramIntent);
            }
            if (paramIntent != null)
            {
              paramConfig = localQQAppInterface.getMsgCache();
              if ("1".equals(paramIntent))
              {
                i = 1;
                paramConfig.b(i);
              }
            }
            else
            {
              paramIntent = (String)localHashMap.get("public_offline_search_enable");
              if (QLog.isColorLevel()) {
                QLog.i("PAOfflineSearchManager", 2, "GENERAL_CONFIGS_CMD, public_offline_search_enable=" + paramIntent);
              }
              if (paramIntent != null)
              {
                paramConfig = bcmv.a();
                if (!"1".equals(paramIntent)) {
                  continue;
                }
                bool = true;
                paramConfig.jdField_b_of_type_Boolean = bool;
              }
              paramIntent = (String)localHashMap.get("public_advance_search_freq");
              if (QLog.isColorLevel()) {
                QLog.i("searchutils", 2, "GENERAL_CONFIGS_CMD, netsearchlevel=" + paramIntent);
              }
              if (paramIntent == null) {}
            }
          }
          catch (Exception paramIntent)
          {
            try
            {
              bcnc.jdField_b_of_type_Int = Integer.valueOf(paramIntent).intValue();
              amaa.a((String)localHashMap.get("shortvideo_progressive_enable"));
              paramIntent = (String)localHashMap.get("aio_autoinput_time");
              if (paramIntent != null) {
                i = 900;
              }
              try
              {
                int j = Integer.parseInt(paramIntent);
                i = j;
              }
              catch (NumberFormatException paramConfig)
              {
                QLog.i("inputx", 2, "GENERAL_CONFIGS_CMD, aio_autoinput_time not a int");
                continue;
              }
              if (QLog.isColorLevel()) {
                QLog.i("inputx", 2, "GENERAL_CONFIGS_CMD, aio_autoinput_time=" + paramIntent);
              }
              BaseApplication.getContext().getSharedPreferences("mobileQQ", 0).edit().putInt("aio_autoinput_time", i).commit();
              paramIntent = (String)localHashMap.get("pic_thumb_400");
              if (QLog.isColorLevel()) {
                QLog.i("inputx", 2, "GENERAL_CONFIGS_CMD, pic_thumb_400=" + paramIntent);
              }
              bdkj.a("pic_thumb_400Enable", paramIntent);
              paramIntent = (String)localHashMap.get("Show_Business_Card");
              if (QLog.isColorLevel()) {
                QLog.d("BusinessCara_Manager", 2, "Show_Business_Card= " + paramIntent);
              }
              paramIntent = (String)localHashMap.get("TIMDocLimitSettingFlag");
              if (QLog.isColorLevel()) {
                QLog.i("TIMDocLimitSettingFlag", 2, "GENERAL_CONFIGS_CMD, TIMDocLimitSettingFlag = " + paramIntent);
              }
              if (paramIntent != null) {
                BaseApplication.getContext().getSharedPreferences("mobileQQ", 4).edit().putBoolean("TIMDocLimitSettingFlag", "1".equalsIgnoreCase(paramIntent)).commit();
              }
              avpw.a();
              return;
              i = 0;
              break;
              label2076:
              if (((String)localObject2).equals("1"))
              {
                i = 1;
                localObject3[1] = Integer.valueOf(i);
                break label863;
              }
              i = 0;
              continue;
              label2105:
              i = 0;
              break label881;
              label2110:
              i = 0;
              break label1378;
              label2115:
              bool = false;
              break label1418;
              paramIntent = paramIntent;
              if (!QLog.isColorLevel()) {
                continue;
              }
              QLog.i("SPLASH_ConfigServlet", 2, paramIntent.getMessage());
              continue;
              paramIntent = paramIntent;
              if (!QLog.isColorLevel()) {
                continue;
              }
              QLog.i("SPLASH_ConfigServlet", 2, "camera_compatible_list ERROR = " + paramIntent.getMessage());
              continue;
              i = 0;
              continue;
              bool = false;
            }
            catch (Exception paramIntent)
            {
              paramIntent.printStackTrace();
              continue;
            }
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 101,content_list is empty ,version: " + paramConfig.version.get());
        }
      }
    }
  }
  
  private void l(ConfigurationService.Config paramConfig)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)getAppRuntime();
    if ((paramConfig.content_list != null) && (paramConfig.content_list.size() > 0))
    {
      str = (String)paramConfig.content_list.get(0);
      if (QLog.isColorLevel()) {
        QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 43,content: " + str + ",version: " + paramConfig.version.get());
      }
      i = paramConfig.version.get();
      j = bhhr.F(localQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
      if (QLog.isColorLevel()) {
        QLog.d("SPLASH_ConfigServlet", 2, "received READINJOY_LOCAL_CHANNEL_CONFIG_CMD remote version: " + i + " | localVersion: " + j);
      }
      if (i != j)
      {
        bhhr.m(localQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, i);
        if (QLog.isColorLevel()) {
          QLog.d("SPLASH_ConfigServlet", 2, "received READINJOY_LOCAL_CHANNEL_CONFIG_CMD save version: " + i);
        }
        a(i, "LocalChannelCity", str, localQQAppInterface);
        if (QLog.isColorLevel()) {
          QLog.d("SPLASH_ConfigServlet", 2, "received READINJOY_LOCAL_CHANNEL_CONFIG_CMD save to database");
        }
      }
    }
    while (!QLog.isColorLevel())
    {
      String str;
      int i;
      int j;
      return;
    }
    QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 43,content_list is empty ,version: " + paramConfig.version.get());
  }
  
  private void m(Intent paramIntent, ConfigurationService.Config paramConfig)
  {
    PtvTemplateManager localPtvTemplateManager = PtvTemplateManager.a((QQAppInterface)getAppRuntime());
    int j = paramConfig.version.get();
    int i = bhhr.l(((QQAppInterface)getAppRuntime()).getApp());
    if (!PtvTemplateManager.d()) {
      i = 0;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PtvTemplateManager", 2, "GetBlessSpecialPendantConfig serverVersion=" + j + "|localVersion=" + i);
    }
    if (j != i)
    {
      bhhr.i(((QQAppInterface)getAppRuntime()).getApp(), j);
      if ((paramConfig.msg_content_list == null) || (paramConfig.msg_content_list.size() <= 0)) {
        break label269;
      }
      paramIntent = (ConfigurationService.Content)paramConfig.msg_content_list.get(0);
      if (paramIntent != null)
      {
        if (paramIntent.compress.get() != 1) {
          break label255;
        }
        paramIntent = ayym.a(paramIntent.content.get().toByteArray());
        if (paramIntent == null) {
          break label250;
        }
      }
    }
    label250:
    label255:
    while (!QLog.isColorLevel()) {
      for (;;)
      {
        try
        {
          paramIntent = new String(paramIntent, "UTF-8");
          localPtvTemplateManager.b(paramIntent, (QQAppInterface)getAppRuntime());
          if (QLog.isColorLevel()) {
            QLog.d("PtvTemplateManager", 2, "receiveAllConfigs|type: 145,content: " + paramIntent + ",version: " + paramConfig.version.get());
          }
          return;
        }
        catch (Exception paramIntent)
        {
          paramIntent.printStackTrace();
        }
        paramIntent = null;
        continue;
        paramIntent = paramIntent.content.get().toStringUtf8();
      }
    }
    label269:
    QLog.d("PtvTemplateManager", 2, "receiveAllConfigs|type: 145,content_list is empty ,version: " + paramConfig.version.get());
  }
  
  private void m(ConfigurationService.Config paramConfig)
  {
    try
    {
      int i = bhhr.r(((QQAppInterface)getAppRuntime()).getApp());
      int j = paramConfig.version.get();
      if (i != j)
      {
        ThreadManager.post(new ConfigServlet.9(this, paramConfig), 8, null, false);
        return;
      }
      if (QLog.isColorLevel())
      {
        QLog.d("SPLASH_ConfigServlet", 2, "received HOTCHAT_SCENE_CONFIGS_CMD same version, " + j);
        return;
      }
    }
    catch (Exception paramConfig)
    {
      paramConfig.printStackTrace();
      if (QLog.isColorLevel()) {
        QLog.d("SPLASH_ConfigServlet", 2, "received HOTCHAT_SCENE_CONFIGS_CMD, EXCEPTION" + paramConfig.toString());
      }
    }
  }
  
  private void n(ConfigurationService.Config paramConfig)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)getAppRuntime();
    try
    {
      int i = PatchSharedPreUtil.getPatchConfigVersion(BaseApplicationImpl.sApplication);
      int j = paramConfig.version.get();
      QLog.d("PatchLogTag", 1, "handlePatchConfigCmd server version: " + j + " | localVersion: " + i);
      if (j != i)
      {
        Object localObject = a(paramConfig);
        if ((localObject != null) && (((List)localObject).size() > 0)) {
          i = 0;
        }
        while (i < ((List)localObject).size())
        {
          paramConfig = (String)((List)localObject).get(i);
          QLog.d("PatchLogTag", 1, "handlePatchConfigCmd msg_content_list index=" + i + ", content=" + paramConfig);
          acly.a(BaseApplicationImpl.sApplication, paramConfig);
          i += 1;
          continue;
          if ((paramConfig.content_list != null) && (paramConfig.content_list.size() > 0)) {
            i = 0;
          }
          while (i < paramConfig.content_list.size())
          {
            localObject = (String)paramConfig.content_list.get(i);
            QLog.d("PatchLogTag", 1, "handlePatchConfigCmd content_list index=" + i + ", content=" + (String)localObject);
            acly.a(BaseApplicationImpl.sApplication, (String)localObject);
            i += 1;
            continue;
            QLog.d("PatchLogTag", 1, "handlePatchConfigCmd msg_content_list and content_list are empty");
          }
        }
        PatchSharedPreUtil.updatePatchConfigVersion(BaseApplicationImpl.sApplication, j);
        PatchReporter.reportPatchEvent(BaseApplicationImpl.sApplication, localQQAppInterface.getCurrentUin(), "actPatchConfig", 100, "");
      }
      for (;;)
      {
        aclq.a(localQQAppInterface);
        if (PatchSharedPreUtil.getPatchConfigVersion(BaseApplicationImpl.sApplication) == j) {
          break;
        }
        PatchSharedPreUtil.updatePatchConfigVersion(BaseApplicationImpl.sApplication, 0);
        return;
        QLog.d("PatchLogTag", 1, "handlePatchConfigCmd not update config as same version");
      }
      return;
    }
    catch (Throwable paramConfig)
    {
      QLog.e("PatchLogTag", 1, "handlePatchConfigCmd throwable=" + paramConfig);
      PatchReporter.reportPatchEvent(BaseApplicationImpl.sApplication, localQQAppInterface.getCurrentUin(), "actPatchConfig", 102, "");
    }
  }
  
  private void o(ConfigurationService.Config paramConfig)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)getAppRuntime();
    if ((paramConfig.content_list != null) && (paramConfig.content_list.size() > 0))
    {
      str1 = (String)paramConfig.content_list.get(0);
      if (QLog.isColorLevel()) {
        QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 50,content: " + str1 + ",version: " + paramConfig.version.get());
      }
      i = paramConfig.version.get();
      j = bhhr.w(localQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
      if (QLog.isColorLevel()) {
        QLog.d("SPLASH_ConfigServlet", 2, "received SEARCH_CONFIG_CMD remote version: " + i + " | localVersion: " + j);
      }
      if (i != j)
      {
        bhhr.i(localQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, i);
        if (QLog.isColorLevel()) {
          QLog.d("SPLASH_ConfigServlet", 2, "received SEARCH_CONFIG_CMD save version: " + i);
        }
        localIterator = paramConfig.content_list.get().iterator();
        while (localIterator.hasNext())
        {
          str2 = (String)localIterator.next();
          SearchConfigManager.a(localQQAppInterface, jdField_a_of_type_JavaLangString, str2);
          if (QLog.isColorLevel()) {
            QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 50,config_content_item: " + str1 + ",version: " + paramConfig.version.get());
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d("SPLASH_ConfigServlet", 2, "received SEARCH_CONFIG_CMD save to sps");
        }
      }
    }
    while (!QLog.isColorLevel())
    {
      String str1;
      int i;
      int j;
      Iterator localIterator;
      String str2;
      return;
    }
    QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 50,content_list is empty ,version: " + paramConfig.version.get());
  }
  
  private void p(ConfigurationService.Config paramConfig)
  {
    ThreadManager.getSubThreadHandler().post(new ConfigServlet.10(this, paramConfig));
  }
  
  private void q(ConfigurationService.Config paramConfig)
  {
    ThreadManager.post(new ConfigServlet.11(this, paramConfig), 5, null, false);
  }
  
  private void r(ConfigurationService.Config paramConfig)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)getAppRuntime();
    if ((paramConfig.content_list != null) && (paramConfig.content_list.size() > 0))
    {
      str = (String)paramConfig.content_list.get(0);
      if (QLog.isColorLevel()) {
        QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 61,content: " + str + ",version: " + paramConfig.version.get());
      }
      i = paramConfig.version.get();
      j = bhhr.s(localQQAppInterface.getApp());
      if (QLog.isColorLevel()) {
        QLog.d("SPLASH_ConfigServlet", 2, "received CAMERA_COMPATIBLE_LIST_CONFIG remote version: " + i + " | localVersion: " + j);
      }
      if (i != j)
      {
        bhhr.l(localQQAppInterface.getApp(), i);
        if (QLog.isColorLevel()) {
          QLog.d("SPLASH_ConfigServlet", 2, "received CAMERA_COMPATIBLE_LIST_CONFIG save version: " + i);
        }
        bdaw.a(str, true);
        if (QLog.isColorLevel()) {
          QLog.d("SPLASH_ConfigServlet", 2, "received CAMERA_COMPATIBLE_LIST_CONFIG save to sps");
        }
      }
    }
    while (!QLog.isColorLevel())
    {
      String str;
      int i;
      int j;
      return;
    }
    QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 61,content_list is empty ,version: " + paramConfig.version.get());
  }
  
  private void s(ConfigurationService.Config paramConfig)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)getAppRuntime();
    if ((paramConfig.content_list != null) && (paramConfig.content_list.size() > 0))
    {
      str = (String)paramConfig.content_list.get(0);
      i = paramConfig.version.get();
      if (QLog.isColorLevel()) {
        QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 64,content: " + str + ",version: " + paramConfig.version.get());
      }
      if (i != bhhr.u(localQQAppInterface.getApp()))
      {
        bhhr.m(localQQAppInterface.getApp(), i);
        if (QLog.isColorLevel()) {
          QLog.d("SPLASH_ConfigServlet", 2, "received SHORTVIDEO_PROGRESSIVE_BLACKLIST_CONFIG save version: " + i);
        }
        if (QLog.isColorLevel()) {
          QLog.d("SPLASH_ConfigServlet", 2, "received SHORTVIDEO_PROGRESSIVE_BLACKLIST_CONFIG save to sps");
        }
      }
    }
    while (!QLog.isColorLevel())
    {
      String str;
      int i;
      return;
    }
    QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 64,content_list is empty ,version: " + paramConfig.version.get());
  }
  
  public static void t(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    boolean bool = false;
    int k = paramConfig.version.get();
    int j = bhhr.as(paramQQAppInterface.getApp().getBaseContext(), jdField_a_of_type_JavaLangString);
    if (paramConfig.msg_content_list != null) {}
    for (int i = paramConfig.msg_content_list.size();; i = -1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("handleScribbleRedSwitchConfigSPLASH_ConfigServlet", 2, String.format("scribble回包, serverVersion[%s], localVersion[%s], size[%s]", new Object[] { Integer.valueOf(k), Integer.valueOf(j), Integer.valueOf(i) }));
      }
      if (k != j) {
        break;
      }
      return;
    }
    Object localObject1;
    byte[] arrayOfByte;
    if (i > 0)
    {
      j = 0;
      if (j < i)
      {
        localObject1 = (ConfigurationService.Content)paramConfig.msg_content_list.get(j);
        if (localObject1 == null) {
          break label336;
        }
        if (((ConfigurationService.Content)localObject1).compress.get() == 1)
        {
          arrayOfByte = ayym.a(((ConfigurationService.Content)localObject1).content.get().toByteArray());
          if (arrayOfByte == null)
          {
            QLog.e("handleScribbleRedSwitchConfigSPLASH_ConfigServlet", 2, "解压错误");
            localObject1 = null;
            label173:
            if (TextUtils.isEmpty((CharSequence)localObject1)) {
              break label336;
            }
            bool = ScribbleResMgr.a((String)localObject1, paramQQAppInterface.getApp().getBaseContext(), jdField_a_of_type_JavaLangString);
          }
        }
      }
    }
    label336:
    for (;;)
    {
      for (;;)
      {
        j += 1;
        break;
        try
        {
          localObject1 = new String(arrayOfByte, "UTF-8");
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException)
        {
          if (QLog.isColorLevel()) {
            localUnsupportedEncodingException.printStackTrace();
          }
          Object localObject2 = null;
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              localOutOfMemoryError.printStackTrace();
            }
            System.gc();
            try
            {
              String str1 = new String(arrayOfByte, "UTF-8");
            }
            catch (Throwable localThrowable)
            {
              str2 = null;
            }
          }
        }
      }
      break label173;
      String str2 = str2.content.get().toStringUtf8();
      break label173;
      if (!bool) {
        break;
      }
      bhhr.w(paramQQAppInterface.getApp().getBaseContext(), k, jdField_a_of_type_JavaLangString);
      return;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("handleScribbleRedSwitchConfigSPLASH_ConfigServlet", 2, "回包为空");
      return;
    }
  }
  
  private void t(ConfigurationService.Config paramConfig)
  {
    ThreadManager.getSubThreadHandler().post(new ConfigServlet.12(this, paramConfig));
  }
  
  private void u(ConfigurationService.Config paramConfig)
  {
    int i = 0;
    if (QLog.isDevelopLevel()) {
      QLog.d("SPLASH_ConfigServlet", 2, new Object[] { "handlePrecoverConfig, version=", Integer.valueOf(paramConfig.version.get()), ", type=", Integer.valueOf(paramConfig.type.get()), ", msg_content_list=", paramConfig.msg_content_list.get() });
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)getAppRuntime();
    ArrayList localArrayList = new ArrayList();
    if ((paramConfig.msg_content_list != null) && (paramConfig.msg_content_list.size() > 0)) {}
    for (List localList = paramConfig.msg_content_list.get();; localList = null)
    {
      StringBuilder localStringBuilder;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder().append("handlePrecoverConfig, configList.size=");
        if (localList != null) {
          break label257;
        }
      }
      label257:
      for (Object localObject = "null";; localObject = Integer.valueOf(localList.size()))
      {
        QLog.d("SPLASH_ConfigServlet", 2, localObject);
        if ((localList == null) || (localList.size() <= 0)) {
          break;
        }
        while (i < localList.size())
        {
          localObject = (ConfigurationService.Content)paramConfig.msg_content_list.get(i);
          if (localObject != null)
          {
            int j = ((ConfigurationService.Content)localObject).task_id.get();
            localObject = azoj.a((ConfigurationService.Content)localObject);
            if (localObject != null) {
              localArrayList.add(new Pair(Integer.valueOf(j), localObject));
            }
          }
          i += 1;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("SPLASH_ConfigServlet", 2, "handlePrecoverConfig, configList is empty");
      }
      azoj.a(localQQAppInterface.getApp(), paramConfig.version.get(), jdField_a_of_type_JavaLangString);
      paramConfig = (azod)localQQAppInterface.getManager(QQManagerFactory.PRECOVER_MANAGER);
      if (paramConfig != null)
      {
        paramConfig.a(localArrayList);
        paramConfig.a();
        paramConfig.a(true);
      }
      return;
    }
  }
  
  private void v(ConfigurationService.Config paramConfig)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)getAppRuntime();
    int i = paramConfig.version.get();
    int j = bhhr.B(localQQAppInterface.getApp(), localQQAppInterface.getAccount());
    if (QLog.isColorLevel()) {
      QLog.d("msgFold", 2, "received RedBagFoldMsgConfig remote version: " + i + " | localVersion: " + j);
    }
    if ((paramConfig.content_list != null) && (paramConfig.content_list.size() > 0))
    {
      String str = (String)paramConfig.content_list.get(0);
      if (QLog.isColorLevel()) {
        QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 69,content: " + str + ",version: " + paramConfig.version.get());
      }
      if (QLog.isColorLevel()) {
        QLog.d("msgFold", 2, "received RedBagFoldMsgConfig content: " + str);
      }
      if (i != j) {
        akqe.a(localQQAppInterface, i, str);
      }
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 69,content_list is empty ,version: " + paramConfig.version.get());
      }
      if (i != j) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("msgFold", 2, "received RedBagFoldMsgConfig, content_list is empty, ignored because of SAME VERSION");
    return;
    if (QLog.isColorLevel()) {
      QLog.d("msgFold", 2, "received RedBagFoldMsgConfig, content_list is empty, use default config");
    }
    paramConfig = (akqe)localQQAppInterface.getManager(QQManagerFactory.PASSWD_RED_BAG_MANAGER);
    paramConfig.jdField_b_of_type_Boolean = true;
    paramConfig.c = MessageForFoldMsgGrayTips.PASSWD_REDBAG_MSG_SWITCH_DEFAULT;
    paramConfig.jdField_a_of_type_Int = MessageForFoldMsgGrayTips.PASSWD_REDBAG_MSG_DISPLAY_NUM_DEFAULT;
    paramConfig.d = MessageForFoldMsgGrayTips.PASSWD_REDBAG_MSG_SWITCH_INDEX;
    paramConfig.e = MessageForFoldMsgGrayTips.PASSWD_REDBAG_MSG_INDEX_WITH_ID;
    bhhr.a(localQQAppInterface.getApp(), localQQAppInterface.getAccount(), i, paramConfig.c, paramConfig.jdField_a_of_type_Int, paramConfig.d, paramConfig.e);
  }
  
  public static void w(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    int i = paramConfig.version.get();
    int j = bhhr.au(BaseApplication.getContext(), jdField_a_of_type_JavaLangString);
    if (QLog.isColorLevel()) {
      QLog.i("SPLASH_ConfigServlet", 2, "handleReceiptConfig: ,version: " + paramConfig.version.get() + "| localVersion: " + j);
    }
    if (i != j)
    {
      bhhr.Q(BaseApplication.getContext(), jdField_a_of_type_JavaLangString, i);
      paramConfig = a(paramConfig);
      if ((paramConfig != null) && (paramConfig.size() > 0))
      {
        paramConfig = paramConfig.iterator();
        while (paramConfig.hasNext())
        {
          localObject = (String)paramConfig.next();
          try
          {
            localObject = new JSONObject((String)localObject);
            if (((JSONObject)localObject).has("kReceiptMsgEnable"))
            {
              i = ((JSONObject)localObject).getInt("kReceiptMsgEnable");
              bhhr.e(BaseApplication.getContext(), jdField_a_of_type_JavaLangString, "receipt_kReceiptMsgEnable", i);
            }
            if (((JSONObject)localObject).has("kReceiptMsgMaxSendTimes"))
            {
              i = ((JSONObject)localObject).getInt("kReceiptMsgMaxSendTimes");
              bhhr.e(BaseApplication.getContext(), jdField_a_of_type_JavaLangString, "receipt_kReceiptMsgSendTimes", i);
            }
          }
          catch (JSONException localJSONException)
          {
            localJSONException.printStackTrace();
          }
        }
        afoc.a(paramQQAppInterface);
      }
    }
    while (!QLog.isColorLevel())
    {
      Object localObject;
      return;
    }
    QLog.i("SPLASH_ConfigServlet", 2, "handleReceiptConfig:localVersiont == version ");
  }
  
  private void w(ConfigurationService.Config paramConfig)
  {
    Object localObject = (QQAppInterface)getAppRuntime();
    if ((paramConfig.content_list != null) && (paramConfig.content_list.size() > 0))
    {
      localObject = (anyb)((QQAppInterface)localObject).getManager(QQManagerFactory.MAYKNOW_RECOMMEND_MANAGER);
      if (paramConfig.content_list.size() < 0)
      {
        str = (String)paramConfig.content_list.get(0);
        i = paramConfig.version.get();
        j = ((anyb)localObject).b();
        if (QLog.isColorLevel()) {
          QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 74,content: " + str + ",version: " + paramConfig.version.get());
        }
        if ((i != j) || (paramConfig.content_list.size() > 0)) {
          ((anyb)localObject).a(i, str);
        }
      }
    }
    while (!QLog.isColorLevel())
    {
      String str;
      int i;
      int j;
      return;
    }
    QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 74,content_list is empty ,version: " + paramConfig.version.get());
  }
  
  /* Error */
  private void x(ConfigurationService.Config paramConfig)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 47	arph:getAppRuntime	()Lmqq/app/AppRuntime;
    //   4: checkcast 49	com/tencent/mobileqq/app/QQAppInterface
    //   7: astore 71
    //   9: aload_1
    //   10: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   13: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   16: istore 34
    //   18: aload 71
    //   20: invokevirtual 65	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   23: aload 71
    //   25: invokevirtual 69	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   28: invokestatic 1659	bhhr:av	(Landroid/content/Context;Ljava/lang/String;)I
    //   31: istore_2
    //   32: aload 71
    //   34: invokevirtual 65	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   37: aload 71
    //   39: invokevirtual 69	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   42: invokestatic 1662	bhhr:aw	(Landroid/content/Context;Ljava/lang/String;)I
    //   45: istore_3
    //   46: invokestatic 210	com/tencent/common/config/AppSetting:a	()I
    //   49: istore 4
    //   51: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   54: ifeq +49 -> 103
    //   57: ldc 189
    //   59: iconst_2
    //   60: ldc_w 5078
    //   63: iconst_4
    //   64: anewarray 314	java/lang/Object
    //   67: dup
    //   68: iconst_0
    //   69: iload 34
    //   71: invokestatic 318	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   74: aastore
    //   75: dup
    //   76: iconst_1
    //   77: iload_2
    //   78: invokestatic 318	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   81: aastore
    //   82: dup
    //   83: iconst_2
    //   84: iload_3
    //   85: invokestatic 318	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   88: aastore
    //   89: dup
    //   90: iconst_3
    //   91: iload 4
    //   93: invokestatic 318	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   96: aastore
    //   97: invokestatic 322	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   100: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   103: iload_3
    //   104: iload 4
    //   106: if_icmpeq +20 -> 126
    //   109: aload 71
    //   111: invokevirtual 65	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   114: aload 71
    //   116: invokevirtual 69	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   119: iload 4
    //   121: invokestatic 5080	bhhr:R	(Landroid/content/Context;Ljava/lang/String;I)V
    //   124: iconst_0
    //   125: istore_2
    //   126: iload 34
    //   128: iload_2
    //   129: if_icmpeq +3257 -> 3386
    //   132: aload_1
    //   133: iload_2
    //   134: sipush 228
    //   137: invokestatic 843	arph:b	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;II)Ljava/lang/String;
    //   140: astore 72
    //   142: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   145: ifeq +12 -> 157
    //   148: ldc_w 5082
    //   151: iconst_2
    //   152: aload 72
    //   154: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   157: aload 72
    //   159: invokestatic 126	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   162: ifne +3532 -> 3694
    //   165: iconst_0
    //   166: istore 20
    //   168: iconst_0
    //   169: istore 28
    //   171: iconst_0
    //   172: istore 29
    //   174: iconst_0
    //   175: istore 30
    //   177: iconst_0
    //   178: istore 31
    //   180: iconst_0
    //   181: istore 32
    //   183: iconst_0
    //   184: istore 33
    //   186: iconst_0
    //   187: istore_2
    //   188: iconst_0
    //   189: istore_3
    //   190: iconst_0
    //   191: istore 21
    //   193: iconst_0
    //   194: istore 22
    //   196: iconst_0
    //   197: istore 23
    //   199: iconst_0
    //   200: istore 24
    //   202: iconst_0
    //   203: istore 25
    //   205: iconst_0
    //   206: istore 26
    //   208: iconst_0
    //   209: istore 27
    //   211: aconst_null
    //   212: astore 67
    //   214: aconst_null
    //   215: astore 68
    //   217: aconst_null
    //   218: astore 69
    //   220: aconst_null
    //   221: astore 70
    //   223: aconst_null
    //   224: astore_1
    //   225: aconst_null
    //   226: astore 63
    //   228: aconst_null
    //   229: astore 64
    //   231: aconst_null
    //   232: astore 65
    //   234: aconst_null
    //   235: astore 66
    //   237: aconst_null
    //   238: astore 36
    //   240: ldc 13
    //   242: astore 39
    //   244: aconst_null
    //   245: astore 38
    //   247: aconst_null
    //   248: astore 60
    //   250: aconst_null
    //   251: astore 61
    //   253: aconst_null
    //   254: astore 62
    //   256: aconst_null
    //   257: astore 37
    //   259: iload_3
    //   260: istore 14
    //   262: iload 28
    //   264: istore 7
    //   266: aload 37
    //   268: astore 40
    //   270: aload 39
    //   272: astore 55
    //   274: aload 36
    //   276: astore 45
    //   278: aload_1
    //   279: astore 50
    //   281: iload 21
    //   283: istore 15
    //   285: iload 29
    //   287: istore 8
    //   289: aload 38
    //   291: astore 41
    //   293: aload 39
    //   295: astore 56
    //   297: aload 63
    //   299: astore 46
    //   301: aload 67
    //   303: astore 51
    //   305: iload 22
    //   307: istore 16
    //   309: iload 30
    //   311: istore 9
    //   313: aload 60
    //   315: astore 42
    //   317: aload 39
    //   319: astore 57
    //   321: aload 64
    //   323: astore 47
    //   325: aload 68
    //   327: astore 52
    //   329: iload 23
    //   331: istore 17
    //   333: iload 31
    //   335: istore 10
    //   337: aload 61
    //   339: astore 43
    //   341: aload 39
    //   343: astore 58
    //   345: aload 65
    //   347: astore 48
    //   349: aload 69
    //   351: astore 53
    //   353: iload 24
    //   355: istore 18
    //   357: iload 32
    //   359: istore 11
    //   361: aload 62
    //   363: astore 44
    //   365: aload 39
    //   367: astore 59
    //   369: aload 66
    //   371: astore 49
    //   373: aload 70
    //   375: astore 54
    //   377: invokestatic 949	javax/xml/parsers/DocumentBuilderFactory:newInstance	()Ljavax/xml/parsers/DocumentBuilderFactory;
    //   380: invokevirtual 953	javax/xml/parsers/DocumentBuilderFactory:newDocumentBuilder	()Ljavax/xml/parsers/DocumentBuilder;
    //   383: new 955	java/io/ByteArrayInputStream
    //   386: dup
    //   387: aload 72
    //   389: ldc_w 957
    //   392: invokevirtual 961	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   395: invokespecial 962	java/io/ByteArrayInputStream:<init>	([B)V
    //   398: invokevirtual 967	javax/xml/parsers/DocumentBuilder:parse	(Ljava/io/InputStream;)Lorg/w3c/dom/Document;
    //   401: astore 75
    //   403: iload_3
    //   404: istore 14
    //   406: iload 28
    //   408: istore 7
    //   410: aload 37
    //   412: astore 40
    //   414: aload 39
    //   416: astore 55
    //   418: aload 36
    //   420: astore 45
    //   422: aload_1
    //   423: astore 50
    //   425: iload 21
    //   427: istore 15
    //   429: iload 29
    //   431: istore 8
    //   433: aload 38
    //   435: astore 41
    //   437: aload 39
    //   439: astore 56
    //   441: aload 63
    //   443: astore 46
    //   445: aload 67
    //   447: astore 51
    //   449: iload 22
    //   451: istore 16
    //   453: iload 30
    //   455: istore 9
    //   457: aload 60
    //   459: astore 42
    //   461: aload 39
    //   463: astore 57
    //   465: aload 64
    //   467: astore 47
    //   469: aload 68
    //   471: astore 52
    //   473: iload 23
    //   475: istore 17
    //   477: iload 31
    //   479: istore 10
    //   481: aload 61
    //   483: astore 43
    //   485: aload 39
    //   487: astore 58
    //   489: aload 65
    //   491: astore 48
    //   493: aload 69
    //   495: astore 53
    //   497: iload 24
    //   499: istore 18
    //   501: iload 32
    //   503: istore 11
    //   505: aload 62
    //   507: astore 44
    //   509: aload 39
    //   511: astore 59
    //   513: aload 66
    //   515: astore 49
    //   517: aload 70
    //   519: astore 54
    //   521: aload 75
    //   523: ldc_w 5084
    //   526: invokeinterface 975 2 0
    //   531: iconst_0
    //   532: invokeinterface 986 2 0
    //   537: invokeinterface 992 1 0
    //   542: invokeinterface 995 1 0
    //   547: astore 72
    //   549: iload_3
    //   550: istore 14
    //   552: iload 28
    //   554: istore 7
    //   556: aload 37
    //   558: astore 40
    //   560: aload 39
    //   562: astore 55
    //   564: aload 36
    //   566: astore 45
    //   568: aload_1
    //   569: astore 50
    //   571: iload 21
    //   573: istore 15
    //   575: iload 29
    //   577: istore 8
    //   579: aload 38
    //   581: astore 41
    //   583: aload 39
    //   585: astore 56
    //   587: aload 63
    //   589: astore 46
    //   591: aload 67
    //   593: astore 51
    //   595: iload 22
    //   597: istore 16
    //   599: iload 30
    //   601: istore 9
    //   603: aload 60
    //   605: astore 42
    //   607: aload 39
    //   609: astore 57
    //   611: aload 64
    //   613: astore 47
    //   615: aload 68
    //   617: astore 52
    //   619: iload 23
    //   621: istore 17
    //   623: iload 31
    //   625: istore 10
    //   627: aload 61
    //   629: astore 43
    //   631: aload 39
    //   633: astore 58
    //   635: aload 65
    //   637: astore 48
    //   639: aload 69
    //   641: astore 53
    //   643: iload 24
    //   645: istore 18
    //   647: iload 32
    //   649: istore 11
    //   651: aload 62
    //   653: astore 44
    //   655: aload 39
    //   657: astore 59
    //   659: aload 66
    //   661: astore 49
    //   663: aload 70
    //   665: astore 54
    //   667: aload 75
    //   669: ldc_w 5086
    //   672: invokeinterface 975 2 0
    //   677: iconst_0
    //   678: invokeinterface 986 2 0
    //   683: invokeinterface 992 1 0
    //   688: invokeinterface 995 1 0
    //   693: astore 73
    //   695: iload_3
    //   696: istore 14
    //   698: iload 28
    //   700: istore 7
    //   702: aload 37
    //   704: astore 40
    //   706: aload 39
    //   708: astore 55
    //   710: aload 36
    //   712: astore 45
    //   714: aload_1
    //   715: astore 50
    //   717: iload 21
    //   719: istore 15
    //   721: iload 29
    //   723: istore 8
    //   725: aload 38
    //   727: astore 41
    //   729: aload 39
    //   731: astore 56
    //   733: aload 63
    //   735: astore 46
    //   737: aload 67
    //   739: astore 51
    //   741: iload 22
    //   743: istore 16
    //   745: iload 30
    //   747: istore 9
    //   749: aload 60
    //   751: astore 42
    //   753: aload 39
    //   755: astore 57
    //   757: aload 64
    //   759: astore 47
    //   761: aload 68
    //   763: astore 52
    //   765: iload 23
    //   767: istore 17
    //   769: iload 31
    //   771: istore 10
    //   773: aload 61
    //   775: astore 43
    //   777: aload 39
    //   779: astore 58
    //   781: aload 65
    //   783: astore 48
    //   785: aload 69
    //   787: astore 53
    //   789: iload 24
    //   791: istore 18
    //   793: iload 32
    //   795: istore 11
    //   797: aload 62
    //   799: astore 44
    //   801: aload 39
    //   803: astore 59
    //   805: aload 66
    //   807: astore 49
    //   809: aload 70
    //   811: astore 54
    //   813: aload 75
    //   815: ldc_w 5088
    //   818: invokeinterface 975 2 0
    //   823: iconst_0
    //   824: invokeinterface 986 2 0
    //   829: invokeinterface 992 1 0
    //   834: invokeinterface 995 1 0
    //   839: astore 74
    //   841: iload_3
    //   842: istore 14
    //   844: iload 28
    //   846: istore 7
    //   848: aload 37
    //   850: astore 40
    //   852: aload 39
    //   854: astore 55
    //   856: aload 36
    //   858: astore 45
    //   860: aload_1
    //   861: astore 50
    //   863: iload 21
    //   865: istore 15
    //   867: iload 29
    //   869: istore 8
    //   871: aload 38
    //   873: astore 41
    //   875: aload 39
    //   877: astore 56
    //   879: aload 63
    //   881: astore 46
    //   883: aload 67
    //   885: astore 51
    //   887: iload 22
    //   889: istore 16
    //   891: iload 30
    //   893: istore 9
    //   895: aload 60
    //   897: astore 42
    //   899: aload 39
    //   901: astore 57
    //   903: aload 64
    //   905: astore 47
    //   907: aload 68
    //   909: astore 52
    //   911: iload 23
    //   913: istore 17
    //   915: iload 31
    //   917: istore 10
    //   919: aload 61
    //   921: astore 43
    //   923: aload 39
    //   925: astore 58
    //   927: aload 65
    //   929: astore 48
    //   931: aload 69
    //   933: astore 53
    //   935: iload 24
    //   937: istore 18
    //   939: iload 32
    //   941: istore 11
    //   943: aload 62
    //   945: astore 44
    //   947: aload 39
    //   949: astore 59
    //   951: aload 66
    //   953: astore 49
    //   955: aload 70
    //   957: astore 54
    //   959: aload 75
    //   961: ldc_w 5090
    //   964: invokeinterface 975 2 0
    //   969: iconst_0
    //   970: invokeinterface 986 2 0
    //   975: invokeinterface 992 1 0
    //   980: invokeinterface 995 1 0
    //   985: astore_1
    //   986: iload_3
    //   987: istore 14
    //   989: iload 28
    //   991: istore 7
    //   993: aload 37
    //   995: astore 40
    //   997: aload 39
    //   999: astore 55
    //   1001: aload 36
    //   1003: astore 45
    //   1005: aload_1
    //   1006: astore 50
    //   1008: iload 21
    //   1010: istore 15
    //   1012: iload 29
    //   1014: istore 8
    //   1016: aload 38
    //   1018: astore 41
    //   1020: aload 39
    //   1022: astore 56
    //   1024: aload 63
    //   1026: astore 46
    //   1028: aload_1
    //   1029: astore 51
    //   1031: iload 22
    //   1033: istore 16
    //   1035: iload 30
    //   1037: istore 9
    //   1039: aload 60
    //   1041: astore 42
    //   1043: aload 39
    //   1045: astore 57
    //   1047: aload 64
    //   1049: astore 47
    //   1051: aload_1
    //   1052: astore 52
    //   1054: iload 23
    //   1056: istore 17
    //   1058: iload 31
    //   1060: istore 10
    //   1062: aload 61
    //   1064: astore 43
    //   1066: aload 39
    //   1068: astore 58
    //   1070: aload 65
    //   1072: astore 48
    //   1074: aload_1
    //   1075: astore 53
    //   1077: iload 24
    //   1079: istore 18
    //   1081: iload 32
    //   1083: istore 11
    //   1085: aload 62
    //   1087: astore 44
    //   1089: aload 39
    //   1091: astore 59
    //   1093: aload 66
    //   1095: astore 49
    //   1097: aload_1
    //   1098: astore 54
    //   1100: aload 75
    //   1102: ldc_w 5092
    //   1105: invokeinterface 975 2 0
    //   1110: iconst_0
    //   1111: invokeinterface 986 2 0
    //   1116: invokeinterface 992 1 0
    //   1121: invokeinterface 995 1 0
    //   1126: astore 36
    //   1128: iload_3
    //   1129: istore 14
    //   1131: iload 28
    //   1133: istore 7
    //   1135: aload 37
    //   1137: astore 40
    //   1139: aload 39
    //   1141: astore 55
    //   1143: aload 36
    //   1145: astore 45
    //   1147: aload_1
    //   1148: astore 50
    //   1150: iload 21
    //   1152: istore 15
    //   1154: iload 29
    //   1156: istore 8
    //   1158: aload 38
    //   1160: astore 41
    //   1162: aload 39
    //   1164: astore 56
    //   1166: aload 36
    //   1168: astore 46
    //   1170: aload_1
    //   1171: astore 51
    //   1173: iload 22
    //   1175: istore 16
    //   1177: iload 30
    //   1179: istore 9
    //   1181: aload 60
    //   1183: astore 42
    //   1185: aload 39
    //   1187: astore 57
    //   1189: aload 36
    //   1191: astore 47
    //   1193: aload_1
    //   1194: astore 52
    //   1196: iload 23
    //   1198: istore 17
    //   1200: iload 31
    //   1202: istore 10
    //   1204: aload 61
    //   1206: astore 43
    //   1208: aload 39
    //   1210: astore 58
    //   1212: aload 36
    //   1214: astore 48
    //   1216: aload_1
    //   1217: astore 53
    //   1219: iload 24
    //   1221: istore 18
    //   1223: iload 32
    //   1225: istore 11
    //   1227: aload 62
    //   1229: astore 44
    //   1231: aload 39
    //   1233: astore 59
    //   1235: aload 36
    //   1237: astore 49
    //   1239: aload_1
    //   1240: astore 54
    //   1242: aload 75
    //   1244: ldc_w 5094
    //   1247: invokeinterface 975 2 0
    //   1252: iconst_0
    //   1253: invokeinterface 986 2 0
    //   1258: invokeinterface 992 1 0
    //   1263: invokeinterface 995 1 0
    //   1268: astore 38
    //   1270: iload_3
    //   1271: istore 14
    //   1273: iload 28
    //   1275: istore 7
    //   1277: aload 38
    //   1279: astore 40
    //   1281: aload 39
    //   1283: astore 55
    //   1285: aload 36
    //   1287: astore 45
    //   1289: aload_1
    //   1290: astore 50
    //   1292: iload 21
    //   1294: istore 15
    //   1296: iload 29
    //   1298: istore 8
    //   1300: aload 38
    //   1302: astore 41
    //   1304: aload 39
    //   1306: astore 56
    //   1308: aload 36
    //   1310: astore 46
    //   1312: aload_1
    //   1313: astore 51
    //   1315: iload 22
    //   1317: istore 16
    //   1319: iload 30
    //   1321: istore 9
    //   1323: aload 38
    //   1325: astore 42
    //   1327: aload 39
    //   1329: astore 57
    //   1331: aload 36
    //   1333: astore 47
    //   1335: aload_1
    //   1336: astore 52
    //   1338: iload 23
    //   1340: istore 17
    //   1342: iload 31
    //   1344: istore 10
    //   1346: aload 38
    //   1348: astore 43
    //   1350: aload 39
    //   1352: astore 58
    //   1354: aload 36
    //   1356: astore 48
    //   1358: aload_1
    //   1359: astore 53
    //   1361: iload 24
    //   1363: istore 18
    //   1365: iload 32
    //   1367: istore 11
    //   1369: aload 38
    //   1371: astore 44
    //   1373: aload 39
    //   1375: astore 59
    //   1377: aload 36
    //   1379: astore 49
    //   1381: aload_1
    //   1382: astore 54
    //   1384: iload 25
    //   1386: istore 12
    //   1388: iload 33
    //   1390: istore 19
    //   1392: aload 39
    //   1394: astore 60
    //   1396: aload 75
    //   1398: ldc_w 5096
    //   1401: invokeinterface 975 2 0
    //   1406: astore 61
    //   1408: aload 39
    //   1410: astore 37
    //   1412: aload 61
    //   1414: ifnull +428 -> 1842
    //   1417: aload 39
    //   1419: astore 37
    //   1421: iload_3
    //   1422: istore 14
    //   1424: iload 28
    //   1426: istore 7
    //   1428: aload 38
    //   1430: astore 40
    //   1432: aload 39
    //   1434: astore 55
    //   1436: aload 36
    //   1438: astore 45
    //   1440: aload_1
    //   1441: astore 50
    //   1443: iload 21
    //   1445: istore 15
    //   1447: iload 29
    //   1449: istore 8
    //   1451: aload 38
    //   1453: astore 41
    //   1455: aload 39
    //   1457: astore 56
    //   1459: aload 36
    //   1461: astore 46
    //   1463: aload_1
    //   1464: astore 51
    //   1466: iload 22
    //   1468: istore 16
    //   1470: iload 30
    //   1472: istore 9
    //   1474: aload 38
    //   1476: astore 42
    //   1478: aload 39
    //   1480: astore 57
    //   1482: aload 36
    //   1484: astore 47
    //   1486: aload_1
    //   1487: astore 52
    //   1489: iload 23
    //   1491: istore 17
    //   1493: iload 31
    //   1495: istore 10
    //   1497: aload 38
    //   1499: astore 43
    //   1501: aload 39
    //   1503: astore 58
    //   1505: aload 36
    //   1507: astore 48
    //   1509: aload_1
    //   1510: astore 53
    //   1512: iload 24
    //   1514: istore 18
    //   1516: iload 32
    //   1518: istore 11
    //   1520: aload 38
    //   1522: astore 44
    //   1524: aload 39
    //   1526: astore 59
    //   1528: aload 36
    //   1530: astore 49
    //   1532: aload_1
    //   1533: astore 54
    //   1535: iload 25
    //   1537: istore 12
    //   1539: iload 33
    //   1541: istore 19
    //   1543: aload 39
    //   1545: astore 60
    //   1547: aload 61
    //   1549: invokeinterface 980 1 0
    //   1554: ifle +288 -> 1842
    //   1557: iload_3
    //   1558: istore 14
    //   1560: iload 28
    //   1562: istore 7
    //   1564: aload 38
    //   1566: astore 40
    //   1568: aload 39
    //   1570: astore 55
    //   1572: aload 36
    //   1574: astore 45
    //   1576: aload_1
    //   1577: astore 50
    //   1579: iload 21
    //   1581: istore 15
    //   1583: iload 29
    //   1585: istore 8
    //   1587: aload 38
    //   1589: astore 41
    //   1591: aload 39
    //   1593: astore 56
    //   1595: aload 36
    //   1597: astore 46
    //   1599: aload_1
    //   1600: astore 51
    //   1602: iload 22
    //   1604: istore 16
    //   1606: iload 30
    //   1608: istore 9
    //   1610: aload 38
    //   1612: astore 42
    //   1614: aload 39
    //   1616: astore 57
    //   1618: aload 36
    //   1620: astore 47
    //   1622: aload_1
    //   1623: astore 52
    //   1625: iload 23
    //   1627: istore 17
    //   1629: iload 31
    //   1631: istore 10
    //   1633: aload 38
    //   1635: astore 43
    //   1637: aload 39
    //   1639: astore 58
    //   1641: aload 36
    //   1643: astore 48
    //   1645: aload_1
    //   1646: astore 53
    //   1648: iload 24
    //   1650: istore 18
    //   1652: iload 32
    //   1654: istore 11
    //   1656: aload 38
    //   1658: astore 44
    //   1660: aload 39
    //   1662: astore 59
    //   1664: aload 36
    //   1666: astore 49
    //   1668: aload_1
    //   1669: astore 54
    //   1671: iload 25
    //   1673: istore 12
    //   1675: iload 33
    //   1677: istore 19
    //   1679: aload 39
    //   1681: astore 60
    //   1683: aload 61
    //   1685: iconst_0
    //   1686: invokeinterface 986 2 0
    //   1691: invokeinterface 992 1 0
    //   1696: astore 61
    //   1698: aload 39
    //   1700: astore 37
    //   1702: aload 61
    //   1704: ifnull +138 -> 1842
    //   1707: iload_3
    //   1708: istore 14
    //   1710: iload 28
    //   1712: istore 7
    //   1714: aload 38
    //   1716: astore 40
    //   1718: aload 39
    //   1720: astore 55
    //   1722: aload 36
    //   1724: astore 45
    //   1726: aload_1
    //   1727: astore 50
    //   1729: iload 21
    //   1731: istore 15
    //   1733: iload 29
    //   1735: istore 8
    //   1737: aload 38
    //   1739: astore 41
    //   1741: aload 39
    //   1743: astore 56
    //   1745: aload 36
    //   1747: astore 46
    //   1749: aload_1
    //   1750: astore 51
    //   1752: iload 22
    //   1754: istore 16
    //   1756: iload 30
    //   1758: istore 9
    //   1760: aload 38
    //   1762: astore 42
    //   1764: aload 39
    //   1766: astore 57
    //   1768: aload 36
    //   1770: astore 47
    //   1772: aload_1
    //   1773: astore 52
    //   1775: iload 23
    //   1777: istore 17
    //   1779: iload 31
    //   1781: istore 10
    //   1783: aload 38
    //   1785: astore 43
    //   1787: aload 39
    //   1789: astore 58
    //   1791: aload 36
    //   1793: astore 48
    //   1795: aload_1
    //   1796: astore 53
    //   1798: iload 24
    //   1800: istore 18
    //   1802: iload 32
    //   1804: istore 11
    //   1806: aload 38
    //   1808: astore 44
    //   1810: aload 39
    //   1812: astore 59
    //   1814: aload 36
    //   1816: astore 49
    //   1818: aload_1
    //   1819: astore 54
    //   1821: iload 25
    //   1823: istore 12
    //   1825: iload 33
    //   1827: istore 19
    //   1829: aload 39
    //   1831: astore 60
    //   1833: aload 61
    //   1835: invokeinterface 995 1 0
    //   1840: astore 37
    //   1842: iload 27
    //   1844: istore 13
    //   1846: iload 26
    //   1848: istore 5
    //   1850: iload_2
    //   1851: istore 4
    //   1853: iload 20
    //   1855: istore 6
    //   1857: iload_3
    //   1858: istore 14
    //   1860: iload 28
    //   1862: istore 7
    //   1864: aload 38
    //   1866: astore 40
    //   1868: aload 37
    //   1870: astore 55
    //   1872: aload 36
    //   1874: astore 45
    //   1876: aload_1
    //   1877: astore 50
    //   1879: iload 21
    //   1881: istore 15
    //   1883: iload 29
    //   1885: istore 8
    //   1887: aload 38
    //   1889: astore 41
    //   1891: aload 37
    //   1893: astore 56
    //   1895: aload 36
    //   1897: astore 46
    //   1899: aload_1
    //   1900: astore 51
    //   1902: iload 22
    //   1904: istore 16
    //   1906: iload 30
    //   1908: istore 9
    //   1910: aload 38
    //   1912: astore 42
    //   1914: aload 37
    //   1916: astore 57
    //   1918: aload 36
    //   1920: astore 47
    //   1922: aload_1
    //   1923: astore 52
    //   1925: iload 23
    //   1927: istore 17
    //   1929: iload 31
    //   1931: istore 10
    //   1933: aload 38
    //   1935: astore 43
    //   1937: aload 37
    //   1939: astore 58
    //   1941: aload 36
    //   1943: astore 48
    //   1945: aload_1
    //   1946: astore 53
    //   1948: iload 24
    //   1950: istore 18
    //   1952: iload 32
    //   1954: istore 11
    //   1956: aload 38
    //   1958: astore 44
    //   1960: aload 37
    //   1962: astore 59
    //   1964: aload 36
    //   1966: astore 49
    //   1968: aload_1
    //   1969: astore 54
    //   1971: iload 25
    //   1973: istore 12
    //   1975: iload 33
    //   1977: istore 19
    //   1979: aload 37
    //   1981: astore 60
    //   1983: aload 72
    //   1985: invokestatic 126	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1988: ifne +1266 -> 3254
    //   1991: iload 27
    //   1993: istore 13
    //   1995: iload 26
    //   1997: istore 5
    //   1999: iload_2
    //   2000: istore 4
    //   2002: iload 20
    //   2004: istore 6
    //   2006: iload_3
    //   2007: istore 14
    //   2009: iload 28
    //   2011: istore 7
    //   2013: aload 38
    //   2015: astore 40
    //   2017: aload 37
    //   2019: astore 55
    //   2021: aload 36
    //   2023: astore 45
    //   2025: aload_1
    //   2026: astore 50
    //   2028: iload 21
    //   2030: istore 15
    //   2032: iload 29
    //   2034: istore 8
    //   2036: aload 38
    //   2038: astore 41
    //   2040: aload 37
    //   2042: astore 56
    //   2044: aload 36
    //   2046: astore 46
    //   2048: aload_1
    //   2049: astore 51
    //   2051: iload 22
    //   2053: istore 16
    //   2055: iload 30
    //   2057: istore 9
    //   2059: aload 38
    //   2061: astore 42
    //   2063: aload 37
    //   2065: astore 57
    //   2067: aload 36
    //   2069: astore 47
    //   2071: aload_1
    //   2072: astore 52
    //   2074: iload 23
    //   2076: istore 17
    //   2078: iload 31
    //   2080: istore 10
    //   2082: aload 38
    //   2084: astore 43
    //   2086: aload 37
    //   2088: astore 58
    //   2090: aload 36
    //   2092: astore 48
    //   2094: aload_1
    //   2095: astore 53
    //   2097: iload 24
    //   2099: istore 18
    //   2101: iload 32
    //   2103: istore 11
    //   2105: aload 38
    //   2107: astore 44
    //   2109: aload 37
    //   2111: astore 59
    //   2113: aload 36
    //   2115: astore 49
    //   2117: aload_1
    //   2118: astore 54
    //   2120: iload 25
    //   2122: istore 12
    //   2124: iload 33
    //   2126: istore 19
    //   2128: aload 37
    //   2130: astore 60
    //   2132: aload 73
    //   2134: invokestatic 126	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2137: ifne +1117 -> 3254
    //   2140: iload 27
    //   2142: istore 13
    //   2144: iload 26
    //   2146: istore 5
    //   2148: iload_2
    //   2149: istore 4
    //   2151: iload 20
    //   2153: istore 6
    //   2155: iload_3
    //   2156: istore 14
    //   2158: iload 28
    //   2160: istore 7
    //   2162: aload 38
    //   2164: astore 40
    //   2166: aload 37
    //   2168: astore 55
    //   2170: aload 36
    //   2172: astore 45
    //   2174: aload_1
    //   2175: astore 50
    //   2177: iload 21
    //   2179: istore 15
    //   2181: iload 29
    //   2183: istore 8
    //   2185: aload 38
    //   2187: astore 41
    //   2189: aload 37
    //   2191: astore 56
    //   2193: aload 36
    //   2195: astore 46
    //   2197: aload_1
    //   2198: astore 51
    //   2200: iload 22
    //   2202: istore 16
    //   2204: iload 30
    //   2206: istore 9
    //   2208: aload 38
    //   2210: astore 42
    //   2212: aload 37
    //   2214: astore 57
    //   2216: aload 36
    //   2218: astore 47
    //   2220: aload_1
    //   2221: astore 52
    //   2223: iload 23
    //   2225: istore 17
    //   2227: iload 31
    //   2229: istore 10
    //   2231: aload 38
    //   2233: astore 43
    //   2235: aload 37
    //   2237: astore 58
    //   2239: aload 36
    //   2241: astore 48
    //   2243: aload_1
    //   2244: astore 53
    //   2246: iload 24
    //   2248: istore 18
    //   2250: iload 32
    //   2252: istore 11
    //   2254: aload 38
    //   2256: astore 44
    //   2258: aload 37
    //   2260: astore 59
    //   2262: aload 36
    //   2264: astore 49
    //   2266: aload_1
    //   2267: astore 54
    //   2269: iload 25
    //   2271: istore 12
    //   2273: iload 33
    //   2275: istore 19
    //   2277: aload 37
    //   2279: astore 60
    //   2281: aload 36
    //   2283: invokestatic 126	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2286: ifne +968 -> 3254
    //   2289: iload 27
    //   2291: istore 13
    //   2293: iload 26
    //   2295: istore 5
    //   2297: iload_2
    //   2298: istore 4
    //   2300: iload 20
    //   2302: istore 6
    //   2304: iload_3
    //   2305: istore 14
    //   2307: iload 28
    //   2309: istore 7
    //   2311: aload 38
    //   2313: astore 40
    //   2315: aload 37
    //   2317: astore 55
    //   2319: aload 36
    //   2321: astore 45
    //   2323: aload_1
    //   2324: astore 50
    //   2326: iload 21
    //   2328: istore 15
    //   2330: iload 29
    //   2332: istore 8
    //   2334: aload 38
    //   2336: astore 41
    //   2338: aload 37
    //   2340: astore 56
    //   2342: aload 36
    //   2344: astore 46
    //   2346: aload_1
    //   2347: astore 51
    //   2349: iload 22
    //   2351: istore 16
    //   2353: iload 30
    //   2355: istore 9
    //   2357: aload 38
    //   2359: astore 42
    //   2361: aload 37
    //   2363: astore 57
    //   2365: aload 36
    //   2367: astore 47
    //   2369: aload_1
    //   2370: astore 52
    //   2372: iload 23
    //   2374: istore 17
    //   2376: iload 31
    //   2378: istore 10
    //   2380: aload 38
    //   2382: astore 43
    //   2384: aload 37
    //   2386: astore 58
    //   2388: aload 36
    //   2390: astore 48
    //   2392: aload_1
    //   2393: astore 53
    //   2395: iload 24
    //   2397: istore 18
    //   2399: iload 32
    //   2401: istore 11
    //   2403: aload 38
    //   2405: astore 44
    //   2407: aload 37
    //   2409: astore 59
    //   2411: aload 36
    //   2413: astore 49
    //   2415: aload_1
    //   2416: astore 54
    //   2418: iload 25
    //   2420: istore 12
    //   2422: iload 33
    //   2424: istore 19
    //   2426: aload 37
    //   2428: astore 60
    //   2430: aload 38
    //   2432: invokestatic 126	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2435: ifne +819 -> 3254
    //   2438: iload 27
    //   2440: istore 13
    //   2442: iload 26
    //   2444: istore 5
    //   2446: iload_2
    //   2447: istore 4
    //   2449: iload 20
    //   2451: istore 6
    //   2453: iload_3
    //   2454: istore 14
    //   2456: iload 28
    //   2458: istore 7
    //   2460: aload 38
    //   2462: astore 40
    //   2464: aload 37
    //   2466: astore 55
    //   2468: aload 36
    //   2470: astore 45
    //   2472: aload_1
    //   2473: astore 50
    //   2475: iload 21
    //   2477: istore 15
    //   2479: iload 29
    //   2481: istore 8
    //   2483: aload 38
    //   2485: astore 41
    //   2487: aload 37
    //   2489: astore 56
    //   2491: aload 36
    //   2493: astore 46
    //   2495: aload_1
    //   2496: astore 51
    //   2498: iload 22
    //   2500: istore 16
    //   2502: iload 30
    //   2504: istore 9
    //   2506: aload 38
    //   2508: astore 42
    //   2510: aload 37
    //   2512: astore 57
    //   2514: aload 36
    //   2516: astore 47
    //   2518: aload_1
    //   2519: astore 52
    //   2521: iload 23
    //   2523: istore 17
    //   2525: iload 31
    //   2527: istore 10
    //   2529: aload 38
    //   2531: astore 43
    //   2533: aload 37
    //   2535: astore 58
    //   2537: aload 36
    //   2539: astore 48
    //   2541: aload_1
    //   2542: astore 53
    //   2544: iload 24
    //   2546: istore 18
    //   2548: iload 32
    //   2550: istore 11
    //   2552: aload 38
    //   2554: astore 44
    //   2556: aload 37
    //   2558: astore 59
    //   2560: aload 36
    //   2562: astore 49
    //   2564: aload_1
    //   2565: astore 54
    //   2567: iload 25
    //   2569: istore 12
    //   2571: iload 33
    //   2573: istore 19
    //   2575: aload 37
    //   2577: astore 60
    //   2579: aload_1
    //   2580: invokestatic 126	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2583: ifne +671 -> 3254
    //   2586: iload 27
    //   2588: istore 13
    //   2590: iload 26
    //   2592: istore 5
    //   2594: iload_2
    //   2595: istore 4
    //   2597: iload 20
    //   2599: istore 6
    //   2601: iload_3
    //   2602: istore 14
    //   2604: iload 28
    //   2606: istore 7
    //   2608: aload 38
    //   2610: astore 40
    //   2612: aload 37
    //   2614: astore 55
    //   2616: aload 36
    //   2618: astore 45
    //   2620: aload_1
    //   2621: astore 50
    //   2623: iload 21
    //   2625: istore 15
    //   2627: iload 29
    //   2629: istore 8
    //   2631: aload 38
    //   2633: astore 41
    //   2635: aload 37
    //   2637: astore 56
    //   2639: aload 36
    //   2641: astore 46
    //   2643: aload_1
    //   2644: astore 51
    //   2646: iload 22
    //   2648: istore 16
    //   2650: iload 30
    //   2652: istore 9
    //   2654: aload 38
    //   2656: astore 42
    //   2658: aload 37
    //   2660: astore 57
    //   2662: aload 36
    //   2664: astore 47
    //   2666: aload_1
    //   2667: astore 52
    //   2669: iload 23
    //   2671: istore 17
    //   2673: iload 31
    //   2675: istore 10
    //   2677: aload 38
    //   2679: astore 43
    //   2681: aload 37
    //   2683: astore 58
    //   2685: aload 36
    //   2687: astore 48
    //   2689: aload_1
    //   2690: astore 53
    //   2692: iload 24
    //   2694: istore 18
    //   2696: iload 32
    //   2698: istore 11
    //   2700: aload 38
    //   2702: astore 44
    //   2704: aload 37
    //   2706: astore 59
    //   2708: aload 36
    //   2710: astore 49
    //   2712: aload_1
    //   2713: astore 54
    //   2715: iload 25
    //   2717: istore 12
    //   2719: iload 33
    //   2721: istore 19
    //   2723: aload 37
    //   2725: astore 60
    //   2727: aload 74
    //   2729: invokestatic 126	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2732: ifne +522 -> 3254
    //   2735: iload_3
    //   2736: istore 14
    //   2738: iload 28
    //   2740: istore 7
    //   2742: aload 38
    //   2744: astore 40
    //   2746: aload 37
    //   2748: astore 55
    //   2750: aload 36
    //   2752: astore 45
    //   2754: aload_1
    //   2755: astore 50
    //   2757: iload 21
    //   2759: istore 15
    //   2761: iload 29
    //   2763: istore 8
    //   2765: aload 38
    //   2767: astore 41
    //   2769: aload 37
    //   2771: astore 56
    //   2773: aload 36
    //   2775: astore 46
    //   2777: aload_1
    //   2778: astore 51
    //   2780: iload 22
    //   2782: istore 16
    //   2784: iload 30
    //   2786: istore 9
    //   2788: aload 38
    //   2790: astore 42
    //   2792: aload 37
    //   2794: astore 57
    //   2796: aload 36
    //   2798: astore 47
    //   2800: aload_1
    //   2801: astore 52
    //   2803: iload 23
    //   2805: istore 17
    //   2807: iload 31
    //   2809: istore 10
    //   2811: aload 38
    //   2813: astore 43
    //   2815: aload 37
    //   2817: astore 58
    //   2819: aload 36
    //   2821: astore 48
    //   2823: aload_1
    //   2824: astore 53
    //   2826: iload 24
    //   2828: istore 18
    //   2830: iload 32
    //   2832: istore 11
    //   2834: aload 38
    //   2836: astore 44
    //   2838: aload 37
    //   2840: astore 59
    //   2842: aload 36
    //   2844: astore 49
    //   2846: aload_1
    //   2847: astore 54
    //   2849: iload 25
    //   2851: istore 12
    //   2853: iload 33
    //   2855: istore 19
    //   2857: aload 37
    //   2859: astore 60
    //   2861: aload 72
    //   2863: invokestatic 4538	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   2866: invokevirtual 1895	java/lang/Integer:intValue	()I
    //   2869: istore_2
    //   2870: iload_3
    //   2871: istore 14
    //   2873: iload_2
    //   2874: istore 7
    //   2876: aload 38
    //   2878: astore 40
    //   2880: aload 37
    //   2882: astore 55
    //   2884: aload 36
    //   2886: astore 45
    //   2888: aload_1
    //   2889: astore 50
    //   2891: iload 21
    //   2893: istore 15
    //   2895: iload_2
    //   2896: istore 8
    //   2898: aload 38
    //   2900: astore 41
    //   2902: aload 37
    //   2904: astore 56
    //   2906: aload 36
    //   2908: astore 46
    //   2910: aload_1
    //   2911: astore 51
    //   2913: iload 22
    //   2915: istore 16
    //   2917: iload_2
    //   2918: istore 9
    //   2920: aload 38
    //   2922: astore 42
    //   2924: aload 37
    //   2926: astore 57
    //   2928: aload 36
    //   2930: astore 47
    //   2932: aload_1
    //   2933: astore 52
    //   2935: iload 23
    //   2937: istore 17
    //   2939: iload_2
    //   2940: istore 10
    //   2942: aload 38
    //   2944: astore 43
    //   2946: aload 37
    //   2948: astore 58
    //   2950: aload 36
    //   2952: astore 48
    //   2954: aload_1
    //   2955: astore 53
    //   2957: iload 24
    //   2959: istore 18
    //   2961: iload_2
    //   2962: istore 11
    //   2964: aload 38
    //   2966: astore 44
    //   2968: aload 37
    //   2970: astore 59
    //   2972: aload 36
    //   2974: astore 49
    //   2976: aload_1
    //   2977: astore 54
    //   2979: iload 25
    //   2981: istore 12
    //   2983: iload_2
    //   2984: istore 19
    //   2986: aload 37
    //   2988: astore 60
    //   2990: aload 73
    //   2992: invokestatic 4538	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   2995: invokevirtual 1895	java/lang/Integer:intValue	()I
    //   2998: istore_3
    //   2999: iload_3
    //   3000: istore 14
    //   3002: iload_2
    //   3003: istore 7
    //   3005: aload 38
    //   3007: astore 40
    //   3009: aload 37
    //   3011: astore 55
    //   3013: aload 36
    //   3015: astore 45
    //   3017: aload_1
    //   3018: astore 50
    //   3020: iload_3
    //   3021: istore 15
    //   3023: iload_2
    //   3024: istore 8
    //   3026: aload 38
    //   3028: astore 41
    //   3030: aload 37
    //   3032: astore 56
    //   3034: aload 36
    //   3036: astore 46
    //   3038: aload_1
    //   3039: astore 51
    //   3041: iload_3
    //   3042: istore 16
    //   3044: iload_2
    //   3045: istore 9
    //   3047: aload 38
    //   3049: astore 42
    //   3051: aload 37
    //   3053: astore 57
    //   3055: aload 36
    //   3057: astore 47
    //   3059: aload_1
    //   3060: astore 52
    //   3062: iload_3
    //   3063: istore 17
    //   3065: iload_2
    //   3066: istore 10
    //   3068: aload 38
    //   3070: astore 43
    //   3072: aload 37
    //   3074: astore 58
    //   3076: aload 36
    //   3078: astore 48
    //   3080: aload_1
    //   3081: astore 53
    //   3083: iload_3
    //   3084: istore 18
    //   3086: iload_2
    //   3087: istore 11
    //   3089: aload 38
    //   3091: astore 44
    //   3093: aload 37
    //   3095: astore 59
    //   3097: aload 36
    //   3099: astore 49
    //   3101: aload_1
    //   3102: astore 54
    //   3104: iload_3
    //   3105: istore 12
    //   3107: iload_2
    //   3108: istore 19
    //   3110: aload 37
    //   3112: astore 60
    //   3114: aload 74
    //   3116: invokestatic 4538	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   3119: invokevirtual 1895	java/lang/Integer:intValue	()I
    //   3122: istore 4
    //   3124: iload 4
    //   3126: istore 7
    //   3128: iload 7
    //   3130: istore 13
    //   3132: iload_3
    //   3133: istore 5
    //   3135: iload_2
    //   3136: istore 4
    //   3138: iload 20
    //   3140: istore 6
    //   3142: iload_2
    //   3143: iflt +111 -> 3254
    //   3146: iload 7
    //   3148: istore 13
    //   3150: iload_3
    //   3151: istore 5
    //   3153: iload_2
    //   3154: istore 4
    //   3156: iload 20
    //   3158: istore 6
    //   3160: iload_2
    //   3161: iconst_1
    //   3162: if_icmpgt +92 -> 3254
    //   3165: iload 7
    //   3167: istore 13
    //   3169: iload_3
    //   3170: istore 5
    //   3172: iload_2
    //   3173: istore 4
    //   3175: iload 20
    //   3177: istore 6
    //   3179: iload_3
    //   3180: iflt +74 -> 3254
    //   3183: iload 7
    //   3185: istore 13
    //   3187: iload_3
    //   3188: istore 5
    //   3190: iload_2
    //   3191: istore 4
    //   3193: iload 20
    //   3195: istore 6
    //   3197: iload_3
    //   3198: iconst_1
    //   3199: if_icmpgt +55 -> 3254
    //   3202: iload 7
    //   3204: istore 13
    //   3206: iload_3
    //   3207: istore 5
    //   3209: iload_2
    //   3210: istore 4
    //   3212: iload 20
    //   3214: istore 6
    //   3216: iload 7
    //   3218: iflt +36 -> 3254
    //   3221: iload 7
    //   3223: istore 13
    //   3225: iload_3
    //   3226: istore 5
    //   3228: iload_2
    //   3229: istore 4
    //   3231: iload 20
    //   3233: istore 6
    //   3235: iload 7
    //   3237: iconst_1
    //   3238: if_icmpgt +16 -> 3254
    //   3241: iconst_1
    //   3242: istore 6
    //   3244: iload_2
    //   3245: istore 4
    //   3247: iload_3
    //   3248: istore 5
    //   3250: iload 7
    //   3252: istore 13
    //   3254: aload 37
    //   3256: astore 39
    //   3258: aload_1
    //   3259: astore 37
    //   3261: iload 6
    //   3263: istore_2
    //   3264: aload 36
    //   3266: astore_1
    //   3267: iload 5
    //   3269: istore_3
    //   3270: iload 4
    //   3272: istore 6
    //   3274: iload 13
    //   3276: istore 5
    //   3278: aload 39
    //   3280: astore 36
    //   3282: iload_3
    //   3283: istore 4
    //   3285: iload 6
    //   3287: istore_3
    //   3288: iload_2
    //   3289: ifeq +97 -> 3386
    //   3292: invokestatic 5101	ahwv:a	()Lahwv;
    //   3295: aload 71
    //   3297: invokevirtual 5104	ahwv:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)Ljava/lang/String;
    //   3300: astore 39
    //   3302: invokestatic 5101	ahwv:a	()Lahwv;
    //   3305: aload 71
    //   3307: invokevirtual 5106	ahwv:c	(Lcom/tencent/mobileqq/app/QQAppInterface;)Ljava/lang/String;
    //   3310: astore 40
    //   3312: iconst_0
    //   3313: istore 35
    //   3315: aload 39
    //   3317: aload_1
    //   3318: invokevirtual 636	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3321: ifeq +13 -> 3334
    //   3324: aload 40
    //   3326: aload 38
    //   3328: invokevirtual 636	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3331: ifne +6 -> 3337
    //   3334: iconst_1
    //   3335: istore 35
    //   3337: invokestatic 5101	ahwv:a	()Lahwv;
    //   3340: iload_3
    //   3341: iload 4
    //   3343: aload_1
    //   3344: aload 36
    //   3346: aload 38
    //   3348: aload 37
    //   3350: iload 35
    //   3352: iload 5
    //   3354: invokevirtual 5109	ahwv:a	(IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZI)V
    //   3357: aload 71
    //   3359: invokevirtual 65	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   3362: aload 71
    //   3364: invokevirtual 423	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   3367: iload 34
    //   3369: iload_3
    //   3370: iload 4
    //   3372: aload_1
    //   3373: aload 38
    //   3375: aload 36
    //   3377: aload 37
    //   3379: iload 35
    //   3381: iload 5
    //   3383: invokestatic 5112	bhhr:a	(Landroid/content/Context;Ljava/lang/String;IIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZI)V
    //   3386: return
    //   3387: astore 39
    //   3389: ldc 13
    //   3391: astore 36
    //   3393: aconst_null
    //   3394: astore 37
    //   3396: iconst_0
    //   3397: istore_3
    //   3398: aconst_null
    //   3399: astore_1
    //   3400: aconst_null
    //   3401: astore 38
    //   3403: iconst_0
    //   3404: istore_2
    //   3405: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3408: ifeq +16 -> 3424
    //   3411: ldc_w 5082
    //   3414: iconst_2
    //   3415: aload 39
    //   3417: iconst_0
    //   3418: anewarray 314	java/lang/Object
    //   3421: invokestatic 388	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   3424: iconst_0
    //   3425: istore 5
    //   3427: iconst_0
    //   3428: istore 6
    //   3430: aload 38
    //   3432: astore 39
    //   3434: aload_1
    //   3435: astore 38
    //   3437: iload_2
    //   3438: istore 4
    //   3440: iload 6
    //   3442: istore_2
    //   3443: aload 39
    //   3445: astore_1
    //   3446: goto -158 -> 3288
    //   3449: astore_1
    //   3450: iload 14
    //   3452: istore 4
    //   3454: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3457: ifeq +15 -> 3472
    //   3460: ldc_w 5082
    //   3463: iconst_2
    //   3464: aload_1
    //   3465: iconst_0
    //   3466: anewarray 314	java/lang/Object
    //   3469: invokestatic 388	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   3472: iload 7
    //   3474: istore_3
    //   3475: aload 55
    //   3477: astore 36
    //   3479: aload 50
    //   3481: astore 37
    //   3483: iconst_0
    //   3484: istore 5
    //   3486: iconst_0
    //   3487: istore_2
    //   3488: aload 45
    //   3490: astore_1
    //   3491: aload 40
    //   3493: astore 38
    //   3495: goto -207 -> 3288
    //   3498: astore_1
    //   3499: iload 15
    //   3501: istore 4
    //   3503: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3506: ifeq +15 -> 3521
    //   3509: ldc_w 5082
    //   3512: iconst_2
    //   3513: aload_1
    //   3514: iconst_0
    //   3515: anewarray 314	java/lang/Object
    //   3518: invokestatic 388	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   3521: iload 8
    //   3523: istore_3
    //   3524: aload 56
    //   3526: astore 36
    //   3528: aload 51
    //   3530: astore 37
    //   3532: iconst_0
    //   3533: istore 5
    //   3535: iconst_0
    //   3536: istore_2
    //   3537: aload 46
    //   3539: astore_1
    //   3540: aload 41
    //   3542: astore 38
    //   3544: goto -256 -> 3288
    //   3547: astore_1
    //   3548: iload 16
    //   3550: istore 4
    //   3552: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3555: ifeq +15 -> 3570
    //   3558: ldc_w 5082
    //   3561: iconst_2
    //   3562: aload_1
    //   3563: iconst_0
    //   3564: anewarray 314	java/lang/Object
    //   3567: invokestatic 388	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   3570: iload 9
    //   3572: istore_3
    //   3573: aload 57
    //   3575: astore 36
    //   3577: aload 52
    //   3579: astore 37
    //   3581: iconst_0
    //   3582: istore 5
    //   3584: iconst_0
    //   3585: istore_2
    //   3586: aload 47
    //   3588: astore_1
    //   3589: aload 42
    //   3591: astore 38
    //   3593: goto -305 -> 3288
    //   3596: astore_1
    //   3597: iload 17
    //   3599: istore 4
    //   3601: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3604: ifeq +15 -> 3619
    //   3607: ldc_w 5082
    //   3610: iconst_2
    //   3611: aload_1
    //   3612: iconst_0
    //   3613: anewarray 314	java/lang/Object
    //   3616: invokestatic 388	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   3619: iload 10
    //   3621: istore_3
    //   3622: aload 58
    //   3624: astore 36
    //   3626: aload 53
    //   3628: astore 37
    //   3630: iconst_0
    //   3631: istore 5
    //   3633: iconst_0
    //   3634: istore_2
    //   3635: aload 48
    //   3637: astore_1
    //   3638: aload 43
    //   3640: astore 38
    //   3642: goto -354 -> 3288
    //   3645: astore_1
    //   3646: iload 18
    //   3648: istore 4
    //   3650: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3653: ifeq +15 -> 3668
    //   3656: ldc_w 5082
    //   3659: iconst_2
    //   3660: aload_1
    //   3661: iconst_0
    //   3662: anewarray 314	java/lang/Object
    //   3665: invokestatic 388	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   3668: iload 11
    //   3670: istore_3
    //   3671: aload 59
    //   3673: astore 36
    //   3675: aload 54
    //   3677: astore 37
    //   3679: iconst_0
    //   3680: istore 5
    //   3682: iconst_0
    //   3683: istore_2
    //   3684: aload 49
    //   3686: astore_1
    //   3687: aload 44
    //   3689: astore 38
    //   3691: goto -403 -> 3288
    //   3694: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3697: ifeq -311 -> 3386
    //   3700: ldc 189
    //   3702: iconst_2
    //   3703: new 85	java/lang/StringBuilder
    //   3706: dup
    //   3707: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   3710: ldc_w 5114
    //   3713: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3716: aload_1
    //   3717: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   3720: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   3723: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3726: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3729: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3732: return
    //   3733: astore 39
    //   3735: ldc 13
    //   3737: astore 36
    //   3739: aload_1
    //   3740: astore 37
    //   3742: iconst_0
    //   3743: istore_3
    //   3744: aconst_null
    //   3745: astore_1
    //   3746: aconst_null
    //   3747: astore 38
    //   3749: iconst_0
    //   3750: istore_2
    //   3751: goto -346 -> 3405
    //   3754: astore 39
    //   3756: ldc 13
    //   3758: astore 40
    //   3760: aload_1
    //   3761: astore 37
    //   3763: iconst_0
    //   3764: istore_3
    //   3765: aconst_null
    //   3766: astore_1
    //   3767: aload 36
    //   3769: astore 38
    //   3771: iconst_0
    //   3772: istore_2
    //   3773: aload 40
    //   3775: astore 36
    //   3777: goto -372 -> 3405
    //   3780: astore 39
    //   3782: aload_1
    //   3783: astore 37
    //   3785: iload 19
    //   3787: istore_3
    //   3788: aload 38
    //   3790: astore_1
    //   3791: aload 36
    //   3793: astore 38
    //   3795: iload 12
    //   3797: istore_2
    //   3798: aload 60
    //   3800: astore 36
    //   3802: goto -397 -> 3405
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	3805	0	this	arph
    //   0	3805	1	paramConfig	ConfigurationService.Config
    //   31	3767	2	i	int
    //   45	3743	3	j	int
    //   49	3600	4	k	int
    //   1848	1833	5	m	int
    //   1855	1586	6	n	int
    //   264	3209	7	i1	int
    //   287	3235	8	i2	int
    //   311	3260	9	i3	int
    //   335	3285	10	i4	int
    //   359	3310	11	i5	int
    //   1386	2410	12	i6	int
    //   1844	1431	13	i7	int
    //   260	3191	14	i8	int
    //   283	3217	15	i9	int
    //   307	3242	16	i10	int
    //   331	3267	17	i11	int
    //   355	3292	18	i12	int
    //   1390	2396	19	i13	int
    //   166	3066	20	i14	int
    //   191	2701	21	i15	int
    //   194	2720	22	i16	int
    //   197	2739	23	i17	int
    //   200	2758	24	i18	int
    //   203	2777	25	i19	int
    //   206	2385	26	i20	int
    //   209	2378	27	i21	int
    //   169	2570	28	i22	int
    //   172	2590	29	i23	int
    //   175	2610	30	i24	int
    //   178	2630	31	i25	int
    //   181	2650	32	i26	int
    //   184	2670	33	i27	int
    //   16	3352	34	i28	int
    //   3313	67	35	bool	boolean
    //   238	3563	36	localObject1	Object
    //   257	3527	37	localObject2	Object
    //   245	3549	38	localObject3	Object
    //   242	3074	39	localObject4	Object
    //   3387	29	39	localParserConfigurationException1	javax.xml.parsers.ParserConfigurationException
    //   3432	12	39	localObject5	Object
    //   3733	1	39	localParserConfigurationException2	javax.xml.parsers.ParserConfigurationException
    //   3754	1	39	localParserConfigurationException3	javax.xml.parsers.ParserConfigurationException
    //   3780	1	39	localParserConfigurationException4	javax.xml.parsers.ParserConfigurationException
    //   268	3506	40	localObject6	Object
    //   291	3250	41	localObject7	Object
    //   315	3275	42	localObject8	Object
    //   339	3300	43	localObject9	Object
    //   363	3325	44	localObject10	Object
    //   276	3213	45	localObject11	Object
    //   299	3239	46	localObject12	Object
    //   323	3264	47	localObject13	Object
    //   347	3289	48	localObject14	Object
    //   371	3314	49	localObject15	Object
    //   279	3201	50	localConfig	ConfigurationService.Config
    //   303	3226	51	localObject16	Object
    //   327	3251	52	localObject17	Object
    //   351	3276	53	localObject18	Object
    //   375	3301	54	localObject19	Object
    //   272	3204	55	localObject20	Object
    //   295	3230	56	localObject21	Object
    //   319	3255	57	localObject22	Object
    //   343	3280	58	localObject23	Object
    //   367	3305	59	localObject24	Object
    //   248	3551	60	localObject25	Object
    //   251	1583	61	localObject26	Object
    //   254	974	62	localObject27	Object
    //   226	799	63	localObject28	Object
    //   229	819	64	localObject29	Object
    //   232	839	65	localObject30	Object
    //   235	859	66	localObject31	Object
    //   212	672	67	localObject32	Object
    //   215	693	68	localObject33	Object
    //   218	714	69	localObject34	Object
    //   221	735	70	localObject35	Object
    //   7	3356	71	localQQAppInterface	QQAppInterface
    //   140	2722	72	str1	String
    //   693	2298	73	str2	String
    //   839	2276	74	str3	String
    //   401	996	75	localDocument	Document
    // Exception table:
    //   from	to	target	type
    //   377	403	3387	javax/xml/parsers/ParserConfigurationException
    //   521	549	3387	javax/xml/parsers/ParserConfigurationException
    //   667	695	3387	javax/xml/parsers/ParserConfigurationException
    //   813	841	3387	javax/xml/parsers/ParserConfigurationException
    //   959	986	3387	javax/xml/parsers/ParserConfigurationException
    //   377	403	3449	java/lang/NumberFormatException
    //   521	549	3449	java/lang/NumberFormatException
    //   667	695	3449	java/lang/NumberFormatException
    //   813	841	3449	java/lang/NumberFormatException
    //   959	986	3449	java/lang/NumberFormatException
    //   1100	1128	3449	java/lang/NumberFormatException
    //   1242	1270	3449	java/lang/NumberFormatException
    //   1396	1408	3449	java/lang/NumberFormatException
    //   1547	1557	3449	java/lang/NumberFormatException
    //   1683	1698	3449	java/lang/NumberFormatException
    //   1833	1842	3449	java/lang/NumberFormatException
    //   1983	1991	3449	java/lang/NumberFormatException
    //   2132	2140	3449	java/lang/NumberFormatException
    //   2281	2289	3449	java/lang/NumberFormatException
    //   2430	2438	3449	java/lang/NumberFormatException
    //   2579	2586	3449	java/lang/NumberFormatException
    //   2727	2735	3449	java/lang/NumberFormatException
    //   2861	2870	3449	java/lang/NumberFormatException
    //   2990	2999	3449	java/lang/NumberFormatException
    //   3114	3124	3449	java/lang/NumberFormatException
    //   377	403	3498	java/io/UnsupportedEncodingException
    //   521	549	3498	java/io/UnsupportedEncodingException
    //   667	695	3498	java/io/UnsupportedEncodingException
    //   813	841	3498	java/io/UnsupportedEncodingException
    //   959	986	3498	java/io/UnsupportedEncodingException
    //   1100	1128	3498	java/io/UnsupportedEncodingException
    //   1242	1270	3498	java/io/UnsupportedEncodingException
    //   1396	1408	3498	java/io/UnsupportedEncodingException
    //   1547	1557	3498	java/io/UnsupportedEncodingException
    //   1683	1698	3498	java/io/UnsupportedEncodingException
    //   1833	1842	3498	java/io/UnsupportedEncodingException
    //   1983	1991	3498	java/io/UnsupportedEncodingException
    //   2132	2140	3498	java/io/UnsupportedEncodingException
    //   2281	2289	3498	java/io/UnsupportedEncodingException
    //   2430	2438	3498	java/io/UnsupportedEncodingException
    //   2579	2586	3498	java/io/UnsupportedEncodingException
    //   2727	2735	3498	java/io/UnsupportedEncodingException
    //   2861	2870	3498	java/io/UnsupportedEncodingException
    //   2990	2999	3498	java/io/UnsupportedEncodingException
    //   3114	3124	3498	java/io/UnsupportedEncodingException
    //   377	403	3547	java/io/IOException
    //   521	549	3547	java/io/IOException
    //   667	695	3547	java/io/IOException
    //   813	841	3547	java/io/IOException
    //   959	986	3547	java/io/IOException
    //   1100	1128	3547	java/io/IOException
    //   1242	1270	3547	java/io/IOException
    //   1396	1408	3547	java/io/IOException
    //   1547	1557	3547	java/io/IOException
    //   1683	1698	3547	java/io/IOException
    //   1833	1842	3547	java/io/IOException
    //   1983	1991	3547	java/io/IOException
    //   2132	2140	3547	java/io/IOException
    //   2281	2289	3547	java/io/IOException
    //   2430	2438	3547	java/io/IOException
    //   2579	2586	3547	java/io/IOException
    //   2727	2735	3547	java/io/IOException
    //   2861	2870	3547	java/io/IOException
    //   2990	2999	3547	java/io/IOException
    //   3114	3124	3547	java/io/IOException
    //   377	403	3596	org/xml/sax/SAXException
    //   521	549	3596	org/xml/sax/SAXException
    //   667	695	3596	org/xml/sax/SAXException
    //   813	841	3596	org/xml/sax/SAXException
    //   959	986	3596	org/xml/sax/SAXException
    //   1100	1128	3596	org/xml/sax/SAXException
    //   1242	1270	3596	org/xml/sax/SAXException
    //   1396	1408	3596	org/xml/sax/SAXException
    //   1547	1557	3596	org/xml/sax/SAXException
    //   1683	1698	3596	org/xml/sax/SAXException
    //   1833	1842	3596	org/xml/sax/SAXException
    //   1983	1991	3596	org/xml/sax/SAXException
    //   2132	2140	3596	org/xml/sax/SAXException
    //   2281	2289	3596	org/xml/sax/SAXException
    //   2430	2438	3596	org/xml/sax/SAXException
    //   2579	2586	3596	org/xml/sax/SAXException
    //   2727	2735	3596	org/xml/sax/SAXException
    //   2861	2870	3596	org/xml/sax/SAXException
    //   2990	2999	3596	org/xml/sax/SAXException
    //   3114	3124	3596	org/xml/sax/SAXException
    //   377	403	3645	java/lang/NullPointerException
    //   521	549	3645	java/lang/NullPointerException
    //   667	695	3645	java/lang/NullPointerException
    //   813	841	3645	java/lang/NullPointerException
    //   959	986	3645	java/lang/NullPointerException
    //   1100	1128	3645	java/lang/NullPointerException
    //   1242	1270	3645	java/lang/NullPointerException
    //   1396	1408	3645	java/lang/NullPointerException
    //   1547	1557	3645	java/lang/NullPointerException
    //   1683	1698	3645	java/lang/NullPointerException
    //   1833	1842	3645	java/lang/NullPointerException
    //   1983	1991	3645	java/lang/NullPointerException
    //   2132	2140	3645	java/lang/NullPointerException
    //   2281	2289	3645	java/lang/NullPointerException
    //   2430	2438	3645	java/lang/NullPointerException
    //   2579	2586	3645	java/lang/NullPointerException
    //   2727	2735	3645	java/lang/NullPointerException
    //   2861	2870	3645	java/lang/NullPointerException
    //   2990	2999	3645	java/lang/NullPointerException
    //   3114	3124	3645	java/lang/NullPointerException
    //   1100	1128	3733	javax/xml/parsers/ParserConfigurationException
    //   1242	1270	3754	javax/xml/parsers/ParserConfigurationException
    //   1396	1408	3780	javax/xml/parsers/ParserConfigurationException
    //   1547	1557	3780	javax/xml/parsers/ParserConfigurationException
    //   1683	1698	3780	javax/xml/parsers/ParserConfigurationException
    //   1833	1842	3780	javax/xml/parsers/ParserConfigurationException
    //   1983	1991	3780	javax/xml/parsers/ParserConfigurationException
    //   2132	2140	3780	javax/xml/parsers/ParserConfigurationException
    //   2281	2289	3780	javax/xml/parsers/ParserConfigurationException
    //   2430	2438	3780	javax/xml/parsers/ParserConfigurationException
    //   2579	2586	3780	javax/xml/parsers/ParserConfigurationException
    //   2727	2735	3780	javax/xml/parsers/ParserConfigurationException
    //   2861	2870	3780	javax/xml/parsers/ParserConfigurationException
    //   2990	2999	3780	javax/xml/parsers/ParserConfigurationException
    //   3114	3124	3780	javax/xml/parsers/ParserConfigurationException
  }
  
  private void y(ConfigurationService.Config paramConfig)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)getAppRuntime();
    int n = paramConfig.version.get();
    int i = bhhr.ax(localQQAppInterface.getApp(), localQQAppInterface.getAccount());
    int j = bhhr.ay(localQQAppInterface.getApp(), localQQAppInterface.getAccount());
    int k = AppSetting.a();
    if (QLog.isColorLevel()) {
      QLog.d("SPLASH_ConfigServlet", 2, String.format("received TimUserSpecial remote version: %d, localVersion: %d ,originalAppId:%d, currentAppId:%d", new Object[] { Integer.valueOf(n), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) }));
    }
    if (j != k)
    {
      bhhr.S(localQQAppInterface.getApp(), localQQAppInterface.getAccount(), k);
      i = 0;
    }
    Object localObject;
    int m;
    ConfigurationService.Config localConfig;
    String str;
    if (n != i)
    {
      localObject = a(paramConfig);
      if ((localObject == null) || (((List)localObject).size() <= 0)) {
        break label440;
      }
      m = 0;
      j = 0;
      localConfig = null;
      paramConfig = null;
      str = null;
    }
    for (;;)
    {
      boolean bool;
      try
      {
        localObject = new JSONObject((String)((List)localObject).get(0));
        if (!((JSONObject)localObject).has("TIMPersonality")) {
          break label484;
        }
        localObject = ((JSONObject)localObject).getJSONObject("TIMPersonality");
        if (!((JSONObject)localObject).has("aioTitleBgSwitch")) {
          break label479;
        }
        j = ((JSONObject)localObject).getInt("aioTitleBgSwitch");
        i = 1;
        if (((JSONObject)localObject).has("androidResourceURL")) {
          paramConfig = ((JSONObject)localObject).getString("androidResourceURL");
        }
        k = i;
        m = j;
        localConfig = paramConfig;
        if (((JSONObject)localObject).has("androidMD5"))
        {
          str = ((JSONObject)localObject).getString("androidMD5");
          localConfig = paramConfig;
          m = j;
          k = i;
        }
        if ((k != 0) && (!TextUtils.isEmpty(localConfig)) && (!TextUtils.isEmpty(str)))
        {
          paramConfig = aijq.a().a(localQQAppInterface);
          localObject = aijq.a().b(localQQAppInterface);
          bool = false;
          if ((!paramConfig.equals(localConfig)) || (!((String)localObject).equals(str))) {
            break label490;
          }
          aijq.a().a(0, m, localConfig, "", str, "", bool, 0);
          bhhr.b(localQQAppInterface.getApp(), localQQAppInterface.getCurrentAccountUin(), n, 0, m, localConfig, str, "", "", bool, 0);
        }
        return;
      }
      catch (JSONException paramConfig)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 256 exception =" + paramConfig.toString());
        return;
      }
      label440:
      if (QLog.isColorLevel())
      {
        QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 256,configStrList is empty ,version: " + paramConfig.version.get());
        return;
        label479:
        i = 0;
        continue;
        label484:
        k = 0;
        continue;
        label490:
        bool = true;
      }
    }
  }
  
  private void z(ConfigurationService.Config paramConfig)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)getAppRuntime();
    int i58 = paramConfig.version.get();
    int i = bhhr.C(localQQAppInterface.getApp(), localQQAppInterface.getAccount());
    int j = bhhr.y(localQQAppInterface.getApp(), localQQAppInterface.getAccount());
    int k = AppSetting.a();
    if (QLog.isColorLevel()) {
      QLog.d("pokeMsg", 2, String.format("handlePokeMsgConfig.received PokeMsgConfig remote version: %d, localVersion: %d ,originalAppId:%d, currentAppId:%d", new Object[] { Integer.valueOf(i58), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) }));
    }
    if (j != k)
    {
      bhhr.j(localQQAppInterface.getApp(), localQQAppInterface.getAccount(), k);
      i = 0;
    }
    Object localObject1;
    long l1;
    Object localObject9;
    int i16;
    int i15;
    int i14;
    int i13;
    Object localObject5;
    int i12;
    int i11;
    int i10;
    int i9;
    int i8;
    int i7;
    int i6;
    int i5;
    int i4;
    int i3;
    int i2;
    Object localObject4;
    Object localObject3;
    Object localObject2;
    int i1;
    int n;
    int m;
    int i17;
    int i19;
    label1770:
    Object localObject8;
    if (i58 != i) {
      if ((paramConfig.content_list != null) && (paramConfig.content_list.size() > 0))
      {
        localObject1 = paramConfig.content_list.get();
        if (QLog.isColorLevel()) {
          QLog.d("SPLASH_ConfigServlet", 2, String.format("handlePokeMsgConfig.receiveAllConfigs|size:%d,content:%s ", new Object[] { Integer.valueOf(paramConfig.content_list.size()), "test" }));
        }
        Iterator localIterator = ((List)localObject1).iterator();
        if (!localIterator.hasNext()) {
          break label7092;
        }
        Object localObject10 = (String)localIterator.next();
        if (QLog.isColorLevel()) {
          QLog.d("SPLASH_ConfigServlet", 2, "handlePokeMsgConfig.receiveAllConfigs|type: 75,content: " + (String)localObject10 + ",version: " + paramConfig.version.get() + ",configSize = " + paramConfig.content_list.size());
        }
        l1 = -1L;
        localObject9 = "";
        Object localObject6 = "";
        i16 = -1;
        i15 = -1;
        i14 = -1;
        i13 = -1;
        localObject5 = null;
        i12 = 0;
        i11 = 0;
        i10 = 0;
        i9 = 0;
        i8 = 0;
        i7 = 0;
        i6 = 0;
        i5 = 0;
        i4 = 0;
        i3 = 0;
        i2 = 0;
        localObject4 = null;
        localObject3 = null;
        localObject2 = null;
        localObject1 = null;
        i1 = 0;
        n = 0;
        m = 50;
        k = 0;
        j = 0;
        i = 0;
        for (;;)
        {
          try
          {
            String[] arrayOfString = ((String)localObject10).split("\\|");
            if (arrayOfString == null) {
              continue;
            }
            int i59 = arrayOfString.length;
            int i38 = 0;
            m = 0;
            n = 0;
            i1 = 0;
            i2 = 50;
            i = 0;
            j = 0;
            localObject1 = null;
            localObject2 = null;
            localObject3 = null;
            localObject4 = null;
            i14 = 0;
            i15 = 0;
            k = 0;
            i18 = 0;
            i3 = 0;
            i17 = 0;
            i13 = 0;
            i12 = 0;
            i11 = 0;
            i6 = 0;
            i4 = 0;
            localObject10 = null;
            i16 = -1;
            i9 = -1;
            i8 = -1;
            i7 = -1;
            localObject9 = "";
            localObject5 = "";
            i33 = m;
            i34 = n;
            i20 = i1;
            i27 = i2;
            i21 = i;
            i22 = j;
            localObject6 = localObject1;
            localObject16 = localObject2;
            localObject12 = localObject3;
            localObject14 = localObject4;
            i37 = i14;
            i28 = i15;
            i24 = k;
            i35 = i18;
            i32 = i3;
            i30 = i17;
            i26 = i13;
            i23 = i12;
            i10 = i11;
            i36 = i6;
            i5 = i4;
            localObject15 = localObject10;
            i31 = i16;
            i29 = i9;
            i25 = i8;
            i19 = i7;
            localObject17 = localObject9;
            localObject13 = localObject5;
            l2 = l1;
            if (i38 >= i59) {
              continue;
            }
            str2 = arrayOfString[i38];
            i21 = i;
            i22 = j;
            localObject12 = localObject1;
            localObject13 = localObject2;
            localObject14 = localObject3;
            localObject15 = localObject4;
            i23 = i14;
            i24 = i15;
            i25 = k;
            i26 = i18;
            i27 = i3;
            i28 = i17;
            i29 = i13;
            i30 = i12;
            i31 = i11;
            i32 = i6;
            i33 = i4;
            localObject16 = localObject10;
            i19 = i16;
            i20 = i9;
            i34 = i8;
            i35 = i7;
            localObject17 = localObject9;
            localObject18 = localObject5;
            l3 = l1;
            try
            {
              if (!str2.contains("aio_pe_view_type")) {
                continue;
              }
              i21 = i;
              i22 = j;
              localObject12 = localObject1;
              localObject13 = localObject2;
              localObject14 = localObject3;
              localObject15 = localObject4;
              i23 = i14;
              i24 = i15;
              i25 = k;
              i26 = i18;
              i27 = i3;
              i28 = i17;
              i29 = i13;
              i30 = i12;
              i31 = i11;
              i32 = i6;
              i33 = i4;
              localObject16 = localObject10;
              i19 = i16;
              i20 = i9;
              i34 = i8;
              i35 = i7;
              localObject17 = localObject9;
              localObject18 = localObject5;
              l3 = l1;
              localObject6 = str2.split("=")[1].trim();
              i21 = i;
              i22 = j;
              localObject12 = localObject1;
              localObject13 = localObject2;
              localObject14 = localObject3;
              localObject15 = localObject4;
              i23 = i14;
              i24 = i15;
              i25 = k;
              i26 = i18;
              i27 = i3;
              i28 = i17;
              i29 = i13;
              i30 = i12;
              i31 = i11;
              i32 = i6;
              i33 = i4;
              localObject16 = localObject10;
              i19 = i16;
              i20 = i9;
              i34 = i8;
              i35 = i7;
              localObject17 = localObject9;
              localObject18 = localObject5;
              l3 = l1;
              bool = TextUtils.isEmpty((CharSequence)localObject6);
              i39 = m;
              i40 = n;
              i41 = i1;
              i42 = i2;
              i36 = i;
              i37 = j;
              localObject19 = localObject1;
              localObject20 = localObject2;
              localObject21 = localObject3;
              localObject22 = localObject4;
              i43 = i14;
              i44 = i15;
              i45 = k;
              i46 = i18;
              i47 = i3;
              i48 = i17;
              i49 = i13;
              i50 = i12;
              i51 = i11;
              i52 = i6;
              i53 = i4;
              localObject23 = localObject10;
              i54 = i16;
              i55 = i9;
              i56 = i8;
              i57 = i7;
              localObject24 = localObject9;
              localObject25 = localObject5;
              l4 = l1;
              if (!bool) {}
              try
              {
                i40 = Integer.parseInt((String)localObject6);
                l4 = l1;
                localObject25 = localObject5;
                localObject24 = localObject9;
                i57 = i7;
                i56 = i8;
                i55 = i9;
                i54 = i16;
                localObject23 = localObject10;
                i53 = i4;
                i52 = i6;
                i51 = i11;
                i50 = i12;
                i49 = i13;
                i48 = i17;
                i47 = i3;
                i46 = i18;
                i45 = k;
                i44 = i15;
                i43 = i14;
                localObject22 = localObject4;
                localObject21 = localObject3;
                localObject20 = localObject2;
                localObject19 = localObject1;
                i37 = j;
                i36 = i;
                i42 = i2;
                i41 = i1;
                i39 = m;
              }
              catch (Exception localException1)
              {
                i21 = i;
                i22 = j;
                localObject12 = localObject1;
                localObject13 = localObject2;
                localObject14 = localObject3;
                localObject15 = localObject4;
                i23 = i14;
                i24 = i15;
                i25 = k;
                i26 = i18;
                i27 = i3;
                i28 = i17;
                i29 = i13;
                i30 = i12;
                i31 = i11;
                i32 = i6;
                i33 = i4;
                localObject16 = localObject10;
                i19 = i16;
                i20 = i9;
                i34 = i8;
                i35 = i7;
                localObject17 = localObject9;
                localObject18 = localObject5;
                l3 = l1;
                localException1.printStackTrace();
                i39 = m;
                i40 = n;
                i41 = i1;
                i42 = i2;
                i36 = i;
                i37 = j;
                localObject19 = localObject1;
                localObject20 = localObject2;
                localObject21 = localObject3;
                localObject22 = localObject4;
                i43 = i14;
                i44 = i15;
                i45 = k;
                i46 = i18;
                i47 = i3;
                i48 = i17;
                i49 = i13;
                i50 = i12;
                i51 = i11;
                i52 = i6;
                i53 = i4;
                localObject23 = localObject10;
                i54 = i16;
                i55 = i9;
                i56 = i8;
                i57 = i7;
                localObject24 = localObject9;
                localObject25 = localObject5;
                l4 = l1;
                continue;
              }
              i38 += 1;
              m = i39;
              n = i40;
              i1 = i41;
              i2 = i42;
              i = i36;
              j = i37;
              localObject1 = localObject19;
              localObject2 = localObject20;
              localObject3 = localObject21;
              localObject4 = localObject22;
              i14 = i43;
              i15 = i44;
              k = i45;
              i18 = i46;
              i3 = i47;
              i17 = i48;
              i13 = i49;
              i12 = i50;
              i11 = i51;
              i6 = i52;
              i4 = i53;
              localObject10 = localObject23;
              i16 = i54;
              i9 = i55;
              i8 = i56;
              i7 = i57;
              localObject9 = localObject24;
              localObject5 = localObject25;
              l1 = l4;
            }
            catch (Exception localException4)
            {
              localObject9 = localObject18;
              localObject7 = localObject17;
              i16 = i35;
              i15 = i34;
              i14 = i20;
              i13 = i19;
              localObject5 = localObject16;
              i12 = i33;
              i11 = i32;
              i10 = i31;
              i9 = i30;
              i8 = i29;
              i7 = i28;
              i6 = i27;
              i5 = i26;
              i4 = i25;
              i3 = i24;
              localObject4 = localObject15;
              localObject3 = localObject14;
              localObject2 = localObject13;
              localObject1 = localObject12;
              i = i2;
              k = i1;
              j = n;
              i17 = m;
              l2 = l3;
              i2 = i23;
              i1 = i22;
              n = i21;
              m = i;
              i = i17;
            }
          }
          catch (Exception localException5)
          {
            int i18;
            int i33;
            int i34;
            int i20;
            int i27;
            int i21;
            int i22;
            Object localObject16;
            Object localObject12;
            Object localObject14;
            int i37;
            int i28;
            int i24;
            int i35;
            int i32;
            int i30;
            int i26;
            int i23;
            int i36;
            Object localObject15;
            int i31;
            int i29;
            int i25;
            Object localObject17;
            Object localObject13;
            String str2;
            Object localObject18;
            long l3;
            boolean bool;
            int i39;
            int i40;
            int i41;
            int i42;
            Object localObject19;
            Object localObject20;
            Object localObject21;
            Object localObject22;
            int i43;
            int i44;
            int i45;
            int i46;
            int i47;
            int i48;
            int i49;
            int i50;
            int i51;
            int i52;
            int i53;
            Object localObject23;
            int i54;
            int i55;
            int i56;
            int i57;
            Object localObject24;
            Object localObject25;
            long l4;
            Object localObject7;
            Object localObject11;
            long l2 = l1;
            continue;
            continue;
            continue;
            continue;
          }
          localException4.printStackTrace();
          if (QLog.isColorLevel()) {
            QLog.e("PokeMsg", 2, "PokeMsgConfig parse erro.fight " + localException4.getMessage());
          }
          i36 = i11;
          i17 = i12;
          i35 = i5;
          i12 = j;
          localObject11 = localObject2;
          j = n;
          i11 = i1;
          localObject13 = localObject9;
          localObject17 = localObject7;
          i19 = i16;
          i25 = i15;
          localObject2 = localObject5;
          i5 = i17;
          i23 = i9;
          i1 = i12;
          n = m;
          m = j;
          j = i11;
          localObject7 = localObject1;
          localObject1 = localObject11;
          if (i != 0)
          {
            if (QLog.isColorLevel()) {
              QLog.d("PokeEmo", 2, String.format("PokeEmoConfig.got.the value is %s,%s,%s,%s", new Object[] { localObject4, localObject3, localObject1, localObject7 }));
            }
            localObject5 = ahcw.a(localQQAppInterface, 5);
            localObject9 = ahcw.a(localQQAppInterface, 6);
            if ((localObject4 == null) || (!((String)localObject4).equals(localObject5)) || (localObject3 == null) || (!((String)localObject3).equals(localObject9)))
            {
              ahcw.jdField_b_of_type_Boolean = false;
              ahcw.c = false;
              bhhr.a(false);
              ahcw.a(localQQAppInterface, (String)localObject4, (String)localObject3, ahcw.d);
            }
            bhhr.a(localQQAppInterface.getApp(), localQQAppInterface.getAccount(), k, (String)localObject4, (String)localObject3, (String)localObject1, (String)localObject7, j, m, n, i1);
            ahcw.a(localQQAppInterface, k, (String)localObject4, (String)localObject3, (String)localObject1, (String)localObject7, j, n, i1);
            ahcw.b(m);
          }
          if ((i10 != 0) && (i23 != 0) && (i8 != 0) && (i7 != 0) && (i6 != 0))
          {
            localQQAppInterface.getApp().getSharedPreferences(localQQAppInterface.getCurrentAccountUin(), 0).edit().putBoolean("chat_tool_poke_clicked", false).commit();
            ahcw.b(localQQAppInterface, false);
            ahcw.a(localQQAppInterface, false);
            ahcw.a(i19, i25, i14, i13);
            bhhr.a(localQQAppInterface.getApp(), localQQAppInterface.getAccount(), i58, true, i19, i25, i14, i13);
            ahcw.a((String)localObject2);
            bhhr.b(localQQAppInterface.getApp(), localQQAppInterface.getAccount(), i58, (String)localObject2);
            ahcw.a(i3);
            bhhr.a(localQQAppInterface.getApp(), localQQAppInterface.getAccount(), i58, i3);
            ahcw.c(i2);
            bhhr.b(localQQAppInterface.getApp(), localQQAppInterface.getAccount(), i58, i2);
            ahcw.a(i35, i4);
            bhhr.a(localQQAppInterface.getApp(), localQQAppInterface.getAccount(), i58, i35, i4);
          }
          if ((i5 != 0) && (i36 != 0) && (i36 != 0))
          {
            localObject1 = PreferenceManager.getDefaultSharedPreferences(localQQAppInterface.getApp()).getString(localQQAppInterface.getAccount() + "_" + "aio_poke_res_url", "");
            bhhr.a(localQQAppInterface.getApp(), localQQAppInterface.getAccount(), i58, l2, (String)localObject13, (String)localObject17);
            if ((localObject13 != null) && (!((String)localObject13).equals(localObject1))) {
              ((PokeBigResHandler)localQQAppInterface.getBusinessHandler(BusinessHandlerFactory.POKE_BIG_RES_HANDLER)).a(true);
            }
          }
          ahcw.c(i2);
          break;
          i21 = i;
          i22 = j;
          localObject12 = localObject1;
          localObject13 = localObject2;
          localObject14 = localObject3;
          localObject15 = localObject4;
          i23 = i14;
          i24 = i15;
          i25 = k;
          i26 = i18;
          i27 = i3;
          i28 = i17;
          i29 = i13;
          i30 = i12;
          i31 = i11;
          i32 = i6;
          i33 = i4;
          localObject16 = localObject11;
          i19 = i16;
          i20 = i9;
          i34 = i8;
          i35 = i7;
          localObject17 = localObject9;
          localObject18 = localObject5;
          l3 = l1;
          if (str2.contains("aio_entry_type"))
          {
            i21 = i;
            i22 = j;
            localObject12 = localObject1;
            localObject13 = localObject2;
            localObject14 = localObject3;
            localObject15 = localObject4;
            i23 = i14;
            i24 = i15;
            i25 = k;
            i26 = i18;
            i27 = i3;
            i28 = i17;
            i29 = i13;
            i30 = i12;
            i31 = i11;
            i32 = i6;
            i33 = i4;
            localObject16 = localObject11;
            i19 = i16;
            i20 = i9;
            i34 = i8;
            i35 = i7;
            localObject17 = localObject9;
            localObject18 = localObject5;
            l3 = l1;
            localObject7 = str2.split("=")[1].trim();
            i21 = i;
            i22 = j;
            localObject12 = localObject1;
            localObject13 = localObject2;
            localObject14 = localObject3;
            localObject15 = localObject4;
            i23 = i14;
            i24 = i15;
            i25 = k;
            i26 = i18;
            i27 = i3;
            i28 = i17;
            i29 = i13;
            i30 = i12;
            i31 = i11;
            i32 = i6;
            i33 = i4;
            localObject16 = localObject11;
            i19 = i16;
            i20 = i9;
            i34 = i8;
            i35 = i7;
            localObject17 = localObject9;
            localObject18 = localObject5;
            l3 = l1;
            bool = TextUtils.isEmpty((CharSequence)localObject7);
            i39 = m;
            i40 = n;
            i41 = i1;
            i42 = i2;
            i36 = i;
            i37 = j;
            localObject19 = localObject1;
            localObject20 = localObject2;
            localObject21 = localObject3;
            localObject22 = localObject4;
            i43 = i14;
            i44 = i15;
            i45 = k;
            i46 = i18;
            i47 = i3;
            i48 = i17;
            i49 = i13;
            i50 = i12;
            i51 = i11;
            i52 = i6;
            i53 = i4;
            localObject23 = localObject11;
            i54 = i16;
            i55 = i9;
            i56 = i8;
            i57 = i7;
            localObject24 = localObject9;
            localObject25 = localObject5;
            l4 = l1;
            if (!bool) {
              try
              {
                i41 = Integer.parseInt((String)localObject7);
                i39 = m;
                i40 = n;
                i42 = i2;
                i36 = i;
                i37 = j;
                localObject19 = localObject1;
                localObject20 = localObject2;
                localObject21 = localObject3;
                localObject22 = localObject4;
                i43 = i14;
                i44 = i15;
                i45 = k;
                i46 = i18;
                i47 = i3;
                i48 = i17;
                i49 = i13;
                i50 = i12;
                i51 = i11;
                i52 = i6;
                i53 = i4;
                localObject23 = localObject11;
                i54 = i16;
                i55 = i9;
                i56 = i8;
                i57 = i7;
                localObject24 = localObject9;
                localObject25 = localObject5;
                l4 = l1;
              }
              catch (Exception localException2)
              {
                i21 = i;
                i22 = j;
                localObject12 = localObject1;
                localObject13 = localObject2;
                localObject14 = localObject3;
                localObject15 = localObject4;
                i23 = i14;
                i24 = i15;
                i25 = k;
                i26 = i18;
                i27 = i3;
                i28 = i17;
                i29 = i13;
                i30 = i12;
                i31 = i11;
                i32 = i6;
                i33 = i4;
                localObject16 = localObject11;
                i19 = i16;
                i20 = i9;
                i34 = i8;
                i35 = i7;
                localObject17 = localObject9;
                localObject18 = localObject5;
                l3 = l1;
                localException2.printStackTrace();
                i39 = m;
                i40 = n;
                i41 = i1;
                i42 = i2;
                i36 = i;
                i37 = j;
                localObject19 = localObject1;
                localObject20 = localObject2;
                localObject21 = localObject3;
                localObject22 = localObject4;
                i43 = i14;
                i44 = i15;
                i45 = k;
                i46 = i18;
                i47 = i3;
                i48 = i17;
                i49 = i13;
                i50 = i12;
                i51 = i11;
                i52 = i6;
                i53 = i4;
                localObject23 = localObject11;
                i54 = i16;
                i55 = i9;
                i56 = i8;
                i57 = i7;
                localObject24 = localObject9;
                localObject25 = localObject5;
                l4 = l1;
              }
            }
          }
          else
          {
            i21 = i;
            i22 = j;
            localObject12 = localObject1;
            localObject13 = localObject2;
            localObject14 = localObject3;
            localObject15 = localObject4;
            i23 = i14;
            i24 = i15;
            i25 = k;
            i26 = i18;
            i27 = i3;
            i28 = i17;
            i29 = i13;
            i30 = i12;
            i31 = i11;
            i32 = i6;
            i33 = i4;
            localObject16 = localObject11;
            i19 = i16;
            i20 = i9;
            i34 = i8;
            i35 = i7;
            localObject17 = localObject9;
            localObject18 = localObject5;
            l3 = l1;
            bool = str2.contains("aio_panel_pe");
            if (bool)
            {
              i5 = i;
              i10 = j;
              localObject12 = localObject1;
              localObject13 = localObject2;
              localObject14 = localObject3;
              localObject15 = localObject4;
              try
              {
                localObject16 = new JSONObject(str2.split("=")[1]);
                i5 = i;
                i10 = j;
                localObject12 = localObject1;
                localObject13 = localObject2;
                localObject14 = localObject3;
                localObject15 = localObject4;
                str1 = ((JSONObject)localObject16).optString("pe_res_url");
                i5 = i;
                i10 = j;
                localObject12 = localObject1;
                localObject13 = localObject2;
                localObject14 = localObject3;
                localObject15 = str1;
                localObject4 = ((JSONObject)localObject16).optString("pe_res_md5");
                i5 = i;
                i10 = j;
                localObject12 = localObject1;
                localObject13 = localObject2;
                localObject14 = localObject4;
                localObject15 = str1;
                localObject2 = ((JSONObject)localObject16).optString("pe_surprise_indexes");
              }
              catch (Exception localException3)
              {
                try
                {
                  localObject3 = ((JSONObject)localObject16).optString("pe_orders");
                }
                catch (Exception localException9)
                {
                  String str1;
                  localObject3 = localObject8;
                  localObject8 = localException9;
                  continue;
                }
                try
                {
                  localObject1 = ((String)localObject2).substring(1, ((String)localObject2).length() - 1);
                  localObject2 = localObject1;
                }
                catch (Exception localException10)
                {
                  localObject1 = localObject3;
                  localObject3 = localObject8;
                  localObject8 = localException10;
                  continue;
                }
                try
                {
                  localObject19 = ((String)localObject3).substring(1, ((String)localObject3).length() - 1);
                  i5 = i;
                  i10 = j;
                  localObject12 = localObject19;
                  localObject13 = localObject2;
                  localObject14 = localObject4;
                  localObject15 = str1;
                  i37 = ((JSONObject)localObject16).optInt("aio_pe_input_switch");
                  i5 = i;
                  i10 = i37;
                  localObject12 = localObject19;
                  localObject13 = localObject2;
                  localObject14 = localObject4;
                  localObject15 = str1;
                  i36 = ((JSONObject)localObject16).optInt("aio_pe_feed_back_switch");
                  i5 = i36;
                  i10 = i37;
                  localObject12 = localObject19;
                  localObject13 = localObject2;
                  localObject14 = localObject4;
                  localObject15 = str1;
                  i42 = ((JSONObject)localObject16).optInt("aio_pe_bubble_limit_count");
                  i39 = 1;
                  i40 = n;
                  i41 = i1;
                  localObject20 = localObject2;
                  localObject21 = localObject4;
                  localObject22 = str1;
                  i43 = i14;
                  i44 = i15;
                  i45 = k;
                  i46 = i18;
                  i47 = i3;
                  i48 = i17;
                  i49 = i13;
                  i50 = i12;
                  i51 = i11;
                  i52 = i6;
                  i53 = i4;
                  localObject23 = localObject11;
                  i54 = i16;
                  i55 = i9;
                  i56 = i8;
                  i57 = i7;
                  localObject24 = localObject9;
                  localObject25 = localObject5;
                  l4 = l1;
                }
                catch (Exception localException11)
                {
                  localObject1 = localObject3;
                  localObject3 = localObject8;
                  localObject8 = localException11;
                  continue;
                  i3 = i19;
                  continue;
                  k = i17;
                  continue;
                  i14 = i16;
                  continue;
                }
                localException3 = localException3;
                localObject3 = localObject15;
                localObject4 = localObject14;
                localObject2 = localObject13;
                localObject1 = localObject12;
                j = i10;
                i = i5;
              }
              i21 = i;
              i22 = j;
              localObject12 = localObject1;
              localObject13 = localObject2;
              localObject14 = localObject4;
              localObject15 = localObject3;
              i23 = i14;
              i24 = i15;
              i25 = k;
              i26 = i18;
              i27 = i3;
              i28 = i17;
              i29 = i13;
              i30 = i12;
              i31 = i11;
              i32 = i6;
              i33 = i4;
              localObject16 = localObject11;
              i19 = i16;
              i20 = i9;
              i34 = i8;
              i35 = i7;
              localObject17 = localObject9;
              localObject18 = localObject5;
              l3 = l1;
              localException3.printStackTrace();
              i39 = m;
              i40 = n;
              i41 = i1;
              i42 = i2;
              i36 = i;
              i37 = j;
              localObject19 = localObject1;
              localObject20 = localObject2;
              localObject21 = localObject4;
              localObject22 = localObject3;
              i43 = i14;
              i44 = i15;
              i45 = k;
              i46 = i18;
              i47 = i3;
              i48 = i17;
              i49 = i13;
              i50 = i12;
              i51 = i11;
              i52 = i6;
              i53 = i4;
              localObject23 = localObject11;
              i54 = i16;
              i55 = i9;
              i56 = i8;
              i57 = i7;
              localObject24 = localObject9;
              localObject25 = localObject5;
              l4 = l1;
            }
            else
            {
              i21 = i;
              i22 = j;
              localObject12 = localObject1;
              localObject13 = localObject2;
              localObject14 = localObject3;
              localObject15 = localObject4;
              i23 = i14;
              i24 = i15;
              i25 = k;
              i26 = i18;
              i27 = i3;
              i28 = i17;
              i29 = i13;
              i30 = i12;
              i31 = i11;
              i32 = i6;
              i33 = i4;
              localObject16 = localObject11;
              i19 = i16;
              i20 = i9;
              i34 = i8;
              i35 = i7;
              localObject17 = localObject9;
              localObject18 = localObject5;
              l3 = l1;
              i5 = i4;
              l2 = l1;
              if (str2.contains("aio_poke_strength_rule_interval"))
              {
                i21 = i;
                i22 = j;
                localObject12 = localObject1;
                localObject13 = localObject2;
                localObject14 = localObject3;
                localObject15 = localObject4;
                i23 = i14;
                i24 = i15;
                i25 = k;
                i26 = i18;
                i27 = i3;
                i28 = i17;
                i29 = i13;
                i30 = i12;
                i31 = i11;
                i32 = i6;
                i33 = i4;
                localObject16 = localObject11;
                i19 = i16;
                i20 = i9;
                i34 = i8;
                i35 = i7;
                localObject17 = localObject9;
                localObject18 = localObject5;
                l3 = l1;
                l2 = Long.valueOf(str2.split("=")[1].trim()).longValue();
                i5 = 1;
              }
              i21 = i;
              i22 = j;
              localObject12 = localObject1;
              localObject13 = localObject2;
              localObject14 = localObject3;
              localObject15 = localObject4;
              i23 = i14;
              i24 = i15;
              i25 = k;
              i26 = i18;
              i27 = i3;
              i28 = i17;
              i29 = i13;
              i30 = i12;
              i31 = i11;
              i32 = i6;
              i33 = i5;
              localObject16 = localObject11;
              i19 = i16;
              i20 = i9;
              i34 = i8;
              i35 = i7;
              localObject17 = localObject9;
              localObject18 = localObject5;
              l3 = l2;
              i4 = i6;
              localObject8 = localObject5;
              if (str2.contains("aio_poke_res_url"))
              {
                i21 = i;
                i22 = j;
                localObject12 = localObject1;
                localObject13 = localObject2;
                localObject14 = localObject3;
                localObject15 = localObject4;
                i23 = i14;
                i24 = i15;
                i25 = k;
                i26 = i18;
                i27 = i3;
                i28 = i17;
                i29 = i13;
                i30 = i12;
                i31 = i11;
                i32 = i6;
                i33 = i5;
                localObject16 = localObject11;
                i19 = i16;
                i20 = i9;
                i34 = i8;
                i35 = i7;
                localObject17 = localObject9;
                localObject18 = localObject5;
                l3 = l2;
                localObject8 = str2.split("=")[1].trim();
                i4 = 1;
              }
              i21 = i;
              i22 = j;
              localObject12 = localObject1;
              localObject13 = localObject2;
              localObject14 = localObject3;
              localObject15 = localObject4;
              i23 = i14;
              i24 = i15;
              i25 = k;
              i26 = i18;
              i27 = i3;
              i28 = i17;
              i29 = i13;
              i30 = i12;
              i31 = i11;
              i32 = i4;
              i33 = i5;
              localObject16 = localObject11;
              i19 = i16;
              i20 = i9;
              i34 = i8;
              i35 = i7;
              localObject17 = localObject9;
              localObject18 = localObject8;
              l3 = l2;
              localObject5 = localObject9;
              if (str2.contains("aio_poke_res_md5"))
              {
                i21 = i;
                i22 = j;
                localObject12 = localObject1;
                localObject13 = localObject2;
                localObject14 = localObject3;
                localObject15 = localObject4;
                i23 = i14;
                i24 = i15;
                i25 = k;
                i26 = i18;
                i27 = i3;
                i28 = i17;
                i29 = i13;
                i30 = i12;
                i31 = i11;
                i32 = i4;
                i33 = i5;
                localObject16 = localObject11;
                i19 = i16;
                i20 = i9;
                i34 = i8;
                i35 = i7;
                localObject17 = localObject9;
                localObject18 = localObject8;
                l3 = l2;
                localObject5 = str2.split("=")[1].trim();
              }
              i21 = i;
              i22 = j;
              localObject12 = localObject1;
              localObject13 = localObject2;
              localObject14 = localObject3;
              localObject15 = localObject4;
              i23 = i14;
              i24 = i15;
              i25 = k;
              i26 = i18;
              i27 = i3;
              i28 = i17;
              i29 = i13;
              i30 = i12;
              i31 = i11;
              i32 = i4;
              i33 = i5;
              localObject16 = localObject11;
              i19 = i16;
              i20 = i9;
              i34 = i8;
              i35 = i7;
              localObject17 = localObject5;
              localObject18 = localObject8;
              l3 = l2;
              i6 = i11;
              i10 = i7;
              if (str2.contains("aio_bar_poke"))
              {
                i21 = i;
                i22 = j;
                localObject12 = localObject1;
                localObject13 = localObject2;
                localObject14 = localObject3;
                localObject15 = localObject4;
                i23 = i14;
                i24 = i15;
                i25 = k;
                i26 = i18;
                i27 = i3;
                i28 = i17;
                i29 = i13;
                i30 = i12;
                i31 = i11;
                i32 = i4;
                i33 = i5;
                localObject16 = localObject11;
                i19 = i16;
                i20 = i9;
                i34 = i8;
                i35 = i7;
                localObject17 = localObject5;
                localObject18 = localObject8;
                l3 = l2;
                i7 = Integer.valueOf(str2.split("=")[1].trim()).intValue();
                i6 = i7;
                if (i7 == 0) {
                  break label7521;
                }
                i6 = i7;
                if (i7 == 1) {
                  break label7521;
                }
                i6 = i7;
                if (i7 == 2) {
                  break label7521;
                }
                i6 = i7;
                if (i7 == 3) {
                  break label7521;
                }
                if (i7 != 4) {
                  break label7561;
                }
                i6 = i7;
                break label7521;
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      for (;;)
      {
        i21 = i;
        i22 = j;
        localObject12 = localObject1;
        localObject13 = localObject2;
        localObject14 = localObject3;
        localObject15 = localObject4;
        i23 = i14;
        i24 = i15;
        i25 = k;
        i26 = i18;
        i27 = i3;
        i28 = i17;
        i29 = i13;
        i30 = i12;
        i31 = i6;
        i32 = i4;
        i33 = i5;
        localObject16 = localObject11;
        i19 = i16;
        i20 = i9;
        i34 = i8;
        i35 = i10;
        localObject17 = localObject5;
        localObject18 = localObject8;
        l3 = l2;
        i7 = i12;
        i11 = i8;
        if (str2.contains("aio_pad_poke"))
        {
          i21 = i;
          i22 = j;
          localObject12 = localObject1;
          localObject13 = localObject2;
          localObject14 = localObject3;
          localObject15 = localObject4;
          i23 = i14;
          i24 = i15;
          i25 = k;
          i26 = i18;
          i27 = i3;
          i28 = i17;
          i29 = i13;
          i30 = i12;
          i31 = i6;
          i32 = i4;
          i33 = i5;
          localObject16 = localObject11;
          i19 = i16;
          i20 = i9;
          i34 = i8;
          i35 = i10;
          localObject17 = localObject5;
          localObject18 = localObject8;
          l3 = l2;
          i8 = Integer.valueOf(str2.split("=")[1].trim()).intValue();
          i7 = i8;
          if (i8 == 0) {
            break label7531;
          }
          i7 = i8;
          if (i8 == 1) {
            break label7531;
          }
          if (i8 != 2) {
            break label7567;
          }
          i7 = i8;
          break label7531;
        }
        i21 = i;
        i22 = j;
        localObject12 = localObject1;
        localObject13 = localObject2;
        localObject14 = localObject3;
        localObject15 = localObject4;
        i23 = i14;
        i24 = i15;
        i25 = k;
        i26 = i18;
        i27 = i3;
        i28 = i17;
        i29 = i13;
        i30 = i7;
        i31 = i6;
        i32 = i4;
        i33 = i5;
        localObject16 = localObject11;
        i19 = i16;
        i20 = i9;
        i34 = i11;
        i35 = i10;
        localObject17 = localObject5;
        localObject18 = localObject8;
        l3 = l2;
        i8 = i13;
        i12 = i9;
        if (str2.contains("aio_poke_unitcount"))
        {
          i21 = i;
          i22 = j;
          localObject12 = localObject1;
          localObject13 = localObject2;
          localObject14 = localObject3;
          localObject15 = localObject4;
          i23 = i14;
          i24 = i15;
          i25 = k;
          i26 = i18;
          i27 = i3;
          i28 = i17;
          i29 = i13;
          i30 = i7;
          i31 = i6;
          i32 = i4;
          i33 = i5;
          localObject16 = localObject11;
          i19 = i16;
          i20 = i9;
          i34 = i11;
          i35 = i10;
          localObject17 = localObject5;
          localObject18 = localObject8;
          l3 = l2;
          i8 = Integer.valueOf(str2.split("=")[1].trim()).intValue();
          if (i8 > 0) {
            break label7541;
          }
        }
        else
        {
          label5287:
          i21 = i;
          i22 = j;
          localObject12 = localObject1;
          localObject13 = localObject2;
          localObject14 = localObject3;
          localObject15 = localObject4;
          i23 = i14;
          i24 = i15;
          i25 = k;
          i26 = i18;
          i27 = i3;
          i28 = i17;
          i29 = i8;
          i30 = i7;
          i31 = i6;
          i32 = i4;
          i33 = i5;
          localObject16 = localObject11;
          i19 = i16;
          i20 = i12;
          i34 = i11;
          i35 = i10;
          localObject17 = localObject5;
          localObject18 = localObject8;
          l3 = l2;
          i9 = i17;
          i13 = i16;
          if (str2.contains("aio_poke_unittime"))
          {
            i21 = i;
            i22 = j;
            localObject12 = localObject1;
            localObject13 = localObject2;
            localObject14 = localObject3;
            localObject15 = localObject4;
            i23 = i14;
            i24 = i15;
            i25 = k;
            i26 = i18;
            i27 = i3;
            i28 = i17;
            i29 = i8;
            i30 = i7;
            i31 = i6;
            i32 = i4;
            i33 = i5;
            localObject16 = localObject11;
            i19 = i16;
            i20 = i12;
            i34 = i11;
            i35 = i10;
            localObject17 = localObject5;
            localObject18 = localObject8;
            l3 = l2;
            i9 = Integer.valueOf(str2.split("=")[1].trim()).intValue();
            if (i9 <= 0) {
              break label6784;
            }
            break label7551;
          }
          label5531:
          i39 = m;
          i40 = n;
          i41 = i1;
          i42 = i2;
          i36 = i;
          i37 = j;
          localObject19 = localObject1;
          localObject20 = localObject2;
          localObject21 = localObject3;
          localObject22 = localObject4;
          i43 = i14;
          i44 = i15;
          i45 = k;
          i46 = i18;
          i47 = i3;
          i48 = i9;
          i49 = i8;
          i50 = i7;
          i51 = i6;
          i52 = i4;
          i53 = i5;
          localObject23 = localObject11;
          i54 = i13;
          i55 = i12;
          i56 = i11;
          i57 = i10;
          localObject24 = localObject5;
          localObject25 = localObject8;
          l4 = l2;
          i21 = i;
          i22 = j;
          localObject12 = localObject1;
          localObject13 = localObject2;
          localObject14 = localObject3;
          localObject15 = localObject4;
          i23 = i14;
          i24 = i15;
          i25 = k;
          i26 = i18;
          i27 = i3;
          i28 = i9;
          i29 = i8;
          i30 = i7;
          i31 = i6;
          i32 = i4;
          i33 = i5;
          localObject16 = localObject11;
          i19 = i13;
          i20 = i12;
          i34 = i11;
          i35 = i10;
          localObject17 = localObject5;
          localObject18 = localObject8;
          l3 = l2;
          if (!str2.contains("aio_panel")) {
            break;
          }
          i21 = i;
          i22 = j;
          localObject12 = localObject1;
          localObject13 = localObject2;
          localObject14 = localObject3;
          localObject15 = localObject4;
          i23 = i14;
          i24 = i15;
          i25 = k;
          i26 = i18;
          i27 = i3;
          i28 = i9;
          i29 = i8;
          i30 = i7;
          i31 = i6;
          i32 = i4;
          i33 = i5;
          localObject16 = localObject11;
          i19 = i13;
          i20 = i12;
          i34 = i11;
          i35 = i10;
          localObject17 = localObject5;
          localObject18 = localObject8;
          l3 = l2;
          localObject19 = str2.split("=");
          i21 = i;
          i22 = j;
          localObject12 = localObject1;
          localObject13 = localObject2;
          localObject14 = localObject3;
          localObject15 = localObject4;
          i23 = i14;
          i24 = i15;
          i25 = k;
          i26 = i18;
          i27 = i3;
          i28 = i9;
          i29 = i8;
          i30 = i7;
          i31 = i6;
          i32 = i4;
          i33 = i5;
          localObject16 = localObject11;
          i19 = i13;
          i20 = i12;
          i34 = i11;
          i35 = i10;
          localObject17 = localObject5;
          localObject18 = localObject8;
          l3 = l2;
          localObject9 = ahcw.a(localObject19[1]);
          i21 = i;
          i22 = j;
          localObject12 = localObject1;
          localObject13 = localObject2;
          localObject14 = localObject3;
          localObject15 = localObject4;
          i23 = i14;
          i24 = i15;
          i25 = k;
          i26 = i18;
          i27 = i3;
          i28 = i9;
          i29 = i8;
          i30 = i7;
          i31 = i6;
          i32 = i4;
          i33 = i5;
          localObject16 = localObject9;
          i19 = i13;
          i20 = i12;
          i34 = i11;
          i35 = i10;
          localObject17 = localObject5;
          localObject18 = localObject8;
          l3 = l2;
          i16 = ahcw.c(localObject19[1]);
        }
        try
        {
          i17 = ahcw.b(localObject19[1]);
        }
        catch (Exception localException6)
        {
          label6784:
          label7092:
          localObject12 = localObject8;
          localObject8 = localObject5;
          i17 = i10;
          i18 = i11;
          i19 = i12;
          localObject5 = localObject9;
          i12 = i5;
          i11 = i4;
          i10 = i6;
          i20 = i7;
          i7 = i9;
          i6 = i3;
          i5 = i16;
          i3 = i15;
          i4 = j;
          i9 = i;
          j = n;
          i = m;
          i15 = k;
          k = i1;
          m = i2;
          n = i9;
          i1 = i4;
          i2 = i14;
          i4 = i15;
          i9 = i20;
          i14 = i19;
          i15 = i18;
          i16 = i17;
          localObject9 = localObject12;
        }
        try
        {
          i19 = ahcw.a(localObject19[1]);
          if ((i16 == 1) || (i16 == 2)) {
            break label7514;
          }
          i14 = 0;
          i15 = k;
          if (i14 == 0) {}
        }
        catch (Exception localException7)
        {
          i19 = k;
          localObject12 = localObject8;
          i20 = i17;
          localObject8 = localObject5;
          i17 = i10;
          i15 = i11;
          i18 = i12;
          localObject5 = localObject9;
          i12 = i5;
          i11 = i4;
          i10 = i6;
          i21 = i7;
          i7 = i9;
          i6 = i3;
          i5 = i16;
          i3 = j;
          i4 = i;
          k = i1;
          j = n;
          i = m;
          m = i2;
          n = i4;
          i1 = i3;
          i2 = i14;
          i3 = i20;
          i4 = i19;
          i9 = i21;
          i14 = i18;
          i16 = i17;
          localObject9 = localObject12;
        }
        try
        {
          i15 = ahcw.d(localObject19[1]);
          k = i15;
          if (k > 0)
          {
            i15 = k;
            if (k <= 6) {}
          }
          else
          {
            i15 = 1;
          }
          if (i17 == 1) {
            break label7507;
          }
          k = 0;
          if (i19 > 0) {
            break label7500;
          }
          i3 = 3;
          i17 = 1;
          i16 = 1;
          i39 = m;
          i40 = n;
          i41 = i1;
          i42 = i2;
          i36 = i;
          i37 = j;
          localObject19 = localObject1;
          localObject20 = localObject2;
          localObject21 = localObject3;
          localObject22 = localObject4;
          i43 = i3;
          i44 = k;
          i45 = i15;
          i46 = i14;
          i47 = i16;
          i48 = i9;
          i49 = i8;
          i50 = i7;
          i51 = i6;
          i52 = i4;
          i53 = i5;
          localObject23 = localObject9;
          i54 = i13;
          i55 = i12;
          i56 = i11;
          i57 = i10;
          localObject24 = localObject5;
          localObject25 = localObject8;
          l4 = l2;
          i21 = i;
          i22 = j;
          localObject12 = localObject1;
          localObject13 = localObject2;
          localObject14 = localObject3;
          localObject15 = localObject4;
          i23 = i3;
          i24 = k;
          i25 = i15;
          i26 = i14;
          i27 = i17;
          i28 = i9;
          i29 = i8;
          i30 = i7;
          i31 = i6;
          i32 = i4;
          i33 = i5;
          localObject16 = localObject9;
          i19 = i13;
          i20 = i12;
          i34 = i11;
          i35 = i10;
          localObject17 = localObject5;
          localObject18 = localObject8;
          l3 = l2;
          if (!QLog.isColorLevel()) {
            break;
          }
          i21 = i;
          i22 = j;
          localObject12 = localObject1;
          localObject13 = localObject2;
          localObject14 = localObject3;
          localObject15 = localObject4;
          i23 = i3;
          i24 = k;
          i25 = i15;
          i26 = i14;
          i27 = i17;
          i28 = i9;
          i29 = i8;
          i30 = i7;
          i31 = i6;
          i32 = i4;
          i33 = i5;
          localObject16 = localObject9;
          i19 = i13;
          i20 = i12;
          i34 = i11;
          i35 = i10;
          localObject17 = localObject5;
          localObject18 = localObject8;
          l3 = l2;
          QLog.d("pokeMsg", 2, "[parsed value] pokePanelInfo:" + (String)localObject9 + " showUniquePokeFlag:" + i14 + " showUniquePokeType:" + i15 + " touchEffect:" + k + " comboNum:" + i3);
          i39 = m;
          i40 = n;
          i41 = i1;
          i42 = i2;
          i36 = i;
          i37 = j;
          localObject19 = localObject1;
          localObject20 = localObject2;
          localObject21 = localObject3;
          localObject22 = localObject4;
          i43 = i3;
          i44 = k;
          i45 = i15;
          i46 = i14;
          i47 = i16;
          i48 = i9;
          i49 = i8;
          i50 = i7;
          i51 = i6;
          i52 = i4;
          i53 = i5;
          localObject23 = localObject9;
          i54 = i13;
          i55 = i12;
          i56 = i11;
          i57 = i10;
          localObject24 = localObject5;
          localObject25 = localObject8;
          l4 = l2;
        }
        catch (Exception localException8)
        {
          localObject12 = localObject8;
          localObject8 = localObject5;
          i16 = i10;
          i15 = i11;
          i18 = i12;
          localObject5 = localObject9;
          i12 = i5;
          i11 = i4;
          i10 = i6;
          i20 = i7;
          i7 = i9;
          i6 = i3;
          i5 = i14;
          i4 = k;
          i3 = i17;
          i9 = j;
          i14 = i;
          k = i1;
          j = n;
          i = m;
          m = i2;
          n = i14;
          i1 = i9;
          i2 = i19;
          i9 = i20;
          i14 = i18;
          localObject9 = localObject12;
        }
      }
      i21 = i;
      i22 = j;
      localObject12 = localObject1;
      localObject13 = localObject2;
      localObject14 = localObject3;
      localObject15 = localObject4;
      i23 = i14;
      i24 = i15;
      i25 = k;
      i26 = i18;
      i27 = i3;
      i28 = i17;
      i29 = i13;
      i30 = i7;
      i31 = i6;
      i32 = i4;
      i33 = i5;
      localObject16 = localObject11;
      i19 = i16;
      i20 = i8;
      i34 = i11;
      i35 = i10;
      localObject17 = localObject5;
      localObject18 = localObject8;
      l3 = l2;
      i8 = ahcw.h;
      break label7541;
      i21 = i;
      i22 = j;
      localObject12 = localObject1;
      localObject13 = localObject2;
      localObject14 = localObject3;
      localObject15 = localObject4;
      i23 = i14;
      i24 = i15;
      i25 = k;
      i26 = i18;
      i27 = i3;
      i28 = i17;
      i29 = i8;
      i30 = i7;
      i31 = i6;
      i32 = i4;
      i33 = i5;
      localObject16 = localObject11;
      i19 = i9;
      i20 = i12;
      i34 = i11;
      i35 = i10;
      localObject17 = localObject5;
      localObject18 = localObject8;
      l3 = l2;
      i9 = ahcw.i;
      break label7551;
      i33 = 0;
      i34 = 0;
      i20 = 0;
      i27 = 50;
      i21 = 0;
      i22 = 0;
      localObject8 = null;
      localObject16 = null;
      localObject12 = null;
      localObject14 = null;
      i37 = 0;
      i28 = 0;
      i24 = 0;
      i35 = 0;
      i32 = 0;
      i30 = 0;
      i26 = 0;
      i23 = 0;
      i10 = 0;
      i36 = 0;
      i5 = 0;
      localObject15 = null;
      i31 = -1;
      i29 = -1;
      i25 = -1;
      i19 = -1;
      localObject17 = "";
      localObject13 = "";
      l2 = l1;
      i2 = i37;
      localObject2 = localObject15;
      i3 = i28;
      i4 = i24;
      i1 = i34;
      i = i33;
      localObject4 = localObject14;
      n = i27;
      localObject1 = localObject16;
      j = i22;
      m = i21;
      localObject3 = localObject12;
      k = i20;
      i6 = i32;
      i7 = i30;
      i8 = i26;
      i13 = i31;
      i14 = i29;
      break label1770;
      if (QLog.isColorLevel()) {
        QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 75,content_list is empty ,version: " + paramConfig.version.get());
      }
      return;
      label7500:
      label7507:
      label7514:
      label7521:
      i10 = i6;
      i6 = 1;
    }
    for (;;)
    {
      label7531:
      i11 = i7;
      i7 = 1;
      break;
      label7541:
      i12 = i8;
      i8 = 1;
      break label5287;
      label7551:
      i13 = i9;
      i9 = 1;
      break label5531;
      label7561:
      i6 = 0;
      break label7521;
      label7567:
      i7 = 0;
    }
  }
  
  public void A(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    int i = paramConfig.version.get();
    if (i != paramQQAppInterface.getPreferences().getInt("troop_link_config_version", 0))
    {
      paramConfig = a(paramConfig);
      if ((paramConfig != null) && (paramConfig.size() > 0))
      {
        paramConfig = (String)paramConfig.get(0);
        if (bgld.a().a(paramConfig)) {
          paramQQAppInterface.getPreferences().edit().putInt("troop_link_config_version", i).commit();
        }
      }
    }
  }
  
  public void B(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    int i = paramConfig.version.get();
    paramQQAppInterface = paramQQAppInterface.getPreferences();
    if (paramQQAppInterface == null) {}
    label17:
    do
    {
      break label17;
      do
      {
        return;
      } while (paramQQAppInterface.getInt("key_game_troop_bind_config_version", 0) == i);
      paramConfig = a(paramConfig);
      if ((paramConfig == null) || (paramConfig.size() <= 0)) {
        break;
      }
      paramConfig = (String)paramConfig.get(0);
    } while (paramConfig == null);
    for (;;)
    {
      try
      {
        paramConfig = new JSONObject(paramConfig);
        if ((!paramConfig.has("showBindGameEntry")) || (paramConfig.getInt("showBindGameEntry") != 1)) {
          break label266;
        }
        bool = true;
        paramQQAppInterface.edit().putBoolean("key_game_troop_bind_config_switch", bool).apply();
        paramQQAppInterface.edit().putInt("key_game_troop_bind_config_version", i).apply();
        if (!QLog.isColorLevel()) {
          break label17;
        }
        QLog.d("SPLASH_ConfigServlet", 2, "game troop config set:" + bool);
        return;
      }
      catch (Exception paramQQAppInterface) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("SPLASH_ConfigServlet", 2, "game troop config parse error:" + paramQQAppInterface.toString());
      return;
      paramQQAppInterface.edit().putBoolean("key_game_troop_bind_config_switch", false).apply();
      paramQQAppInterface.edit().putInt("key_game_troop_bind_config_version", i).apply();
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("SPLASH_ConfigServlet", 2, "game troop config empty content get");
      return;
      label266:
      boolean bool = false;
    }
  }
  
  public void C(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    int i = paramConfig.version.get();
    int j = paramQQAppInterface.getPreferences().getInt("tim_aio_tips_bar_version", 0);
    if ((paramConfig.msg_content_list == null) || (paramConfig.msg_content_list.isEmpty()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SPLASH_ConfigServlet", 2, new Object[] { "handleTimAIOTipsBar| config empty, delete config, version=", Integer.valueOf(i) });
      }
      paramQQAppInterface.getPreferences().edit().remove("tim_aio_tips_bar_version").apply();
      ((afpn)paramQQAppInterface.getManager(QQManagerFactory.APP_GUIDE_TIPS_MANAGER)).d();
    }
    Object localObject;
    do
    {
      do
      {
        return;
      } while (i == j);
      paramQQAppInterface.getPreferences().edit().putInt("tim_aio_tips_bar_version", i).apply();
      localObject = a(paramConfig);
    } while ((localObject == null) || (((List)localObject).size() <= 0));
    paramConfig = new AppGuideTipsConfig();
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("SPLASH_ConfigServlet", 2, new Object[] { "handleTimAIOTipsBar| Get Config ", Integer.valueOf(254), ": ", ((List)localObject).get(0) });
      }
      localObject = new JSONObject((String)((List)localObject).get(0));
      if (((JSONObject)localObject).has("SendMessageAIOTopTip"))
      {
        localObject = ((JSONObject)localObject).getJSONObject("SendMessageAIOTopTip");
        paramConfig.switchKey = ((JSONObject)localObject).getString("switch");
        paramConfig.maxCount = Integer.valueOf(((JSONObject)localObject).getString("total")).intValue();
        paramConfig.duration = Long.valueOf(((JSONObject)localObject).getString("duration")).longValue();
        paramConfig.tipsUrl = ((JSONObject)localObject).getString("androidURL");
        paramConfig.tipsMsg = ((JSONObject)localObject).getString("title");
        paramConfig.msgTypeStr = ((JSONObject)localObject).getString("androidtypes");
        paramConfig.aioTypeStr = ((JSONObject)localObject).getString("androidAIOTypes");
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
    paramQQAppInterface = (afpn)paramQQAppInterface.getManager(QQManagerFactory.APP_GUIDE_TIPS_MANAGER);
    paramQQAppInterface.a(paramConfig);
    paramQQAppInterface.c();
  }
  
  public void D(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    int i = paramConfig.version.get();
    if (i != bdcu.a(paramQQAppInterface.getApp()))
    {
      paramConfig = a(paramConfig);
      if ((paramConfig != null) && (paramConfig.size() > 0)) {
        bdcu.a((String)paramConfig.get(0), i, paramQQAppInterface.getApp());
      }
    }
  }
  
  public void E(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    boolean bool4 = true;
    boolean bool5 = false;
    int i = paramConfig.version.get();
    Object localObject2;
    SharedPreferences.Editor localEditor;
    Object localObject1;
    boolean bool1;
    if (i != paramQQAppInterface.getPreferences().getInt("data_migration_tim_version", 0))
    {
      paramConfig = a(paramConfig);
      localObject2 = paramQQAppInterface.getApp().getSharedPreferences("data_migration_tim", 0);
      localEditor = ((SharedPreferences)localObject2).edit();
      if ((paramConfig == null) || (paramConfig.size() <= 0)) {}
    }
    else
    {
      try
      {
        paramConfig = new JSONObject((String)paramConfig.get(0));
        if (!paramConfig.has("DataMigration")) {
          break label334;
        }
        localObject1 = paramConfig.getJSONObject("DataMigration");
        paramConfig = "";
        str1 = "";
        if (!((JSONObject)localObject1).has("switch")) {
          break label567;
        }
        if (((JSONObject)localObject1).getInt("switch") != 1) {
          break label369;
        }
        bool1 = true;
      }
      catch (JSONException paramConfig)
      {
        for (;;)
        {
          String str1;
          label173:
          paramConfig.printStackTrace();
        }
      }
      if (!((JSONObject)localObject1).has("uninstall")) {
        break label561;
      }
      if (((JSONObject)localObject1).getInt("uninstall") == 1)
      {
        bool1 = true;
        break label580;
        if (((JSONObject)localObject1).has("title")) {
          paramConfig = ((JSONObject)localObject1).getString("title");
        }
        if (((JSONObject)localObject1).has("content")) {
          str1 = ((JSONObject)localObject1).getString("content");
        }
        bool1 = bool5;
        if (((JSONObject)localObject1).has("uninstallNotify"))
        {
          if (((JSONObject)localObject1).getInt("uninstallNotify") != 1) {
            break label381;
          }
          bool1 = bool4;
          break label587;
        }
      }
    }
    label561:
    label567:
    label580:
    label587:
    for (;;)
    {
      if (((JSONObject)localObject1).has("uninstallTitle")) {}
      for (String str2 = ((JSONObject)localObject1).getString("uninstallTitle");; str2 = "")
      {
        if (((JSONObject)localObject1).has("uninstallContent")) {}
        for (localObject1 = ((JSONObject)localObject1).getString("uninstallContent");; localObject1 = "")
        {
          localObject2 = a((SharedPreferences)localObject2, paramQQAppInterface.getCurrentAccountUin(), bool2);
          if (TextUtils.isEmpty((CharSequence)localObject2))
          {
            if (QLog.isColorLevel()) {
              QLog.d("SPLASH_ConfigServlet", 2, "handleDataMigrationForTIM| remove all uins");
            }
            localEditor.clear();
          }
          for (;;)
          {
            label334:
            localEditor.apply();
            paramQQAppInterface = paramQQAppInterface.getPreferences().edit();
            paramQQAppInterface.putInt("data_migration_tim_version", i);
            paramQQAppInterface.apply();
            return;
            label369:
            bool1 = false;
            break;
            bool1 = false;
            break label580;
            label381:
            bool1 = false;
            break label587;
            localEditor.putString("data_migration_tim_uins", (String)localObject2);
            localEditor.putBoolean("data_migration_tim_uninstall_flag", bool3);
            localEditor.putString("data_migration_tim_title", paramConfig);
            localEditor.putString("data_migration_tim_content", str1);
            localEditor.putBoolean("data_migration_tim_uninstall_notify", bool1);
            localEditor.putString("data_migration_tim_uninstall_title", str2);
            localEditor.putString("data_migration_tim_uninstall_content", (String)localObject1);
            continue;
            paramConfig = a((SharedPreferences)localObject2, paramQQAppInterface.getCurrentAccountUin(), false);
            if (TextUtils.isEmpty(paramConfig))
            {
              if (QLog.isColorLevel()) {
                QLog.d("SPLASH_ConfigServlet", 2, "handleDataMigrationForTIM| remove all uins");
              }
              localEditor.clear();
            }
            else
            {
              localEditor.putString("data_migration_tim_uins", paramConfig);
            }
          }
        }
      }
      boolean bool3 = false;
      break label173;
      boolean bool2 = false;
      break;
      bool2 = bool1;
      break;
      bool3 = bool1;
      break label173;
    }
  }
  
  public void F(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    int i = paramConfig.version.get();
    Object localObject;
    if (i != paramQQAppInterface.getPreferences().getInt("call_tim_config_version", 0))
    {
      localObject = a(paramConfig);
      paramConfig = paramQQAppInterface.getApp().getSharedPreferences("call_tim_config_pre" + paramQQAppInterface.getCurrentUin(), 0).edit();
      if ((localObject == null) || (((List)localObject).size() <= 0)) {
        break label262;
      }
    }
    for (;;)
    {
      try
      {
        localObject = new JSONObject((String)((List)localObject).get(0));
        if (((JSONObject)localObject).has("TIMFreeCloud"))
        {
          localObject = ((JSONObject)localObject).getJSONObject("TIMFreeCloud");
          if (((JSONObject)localObject).has("On")) {
            paramConfig.putBoolean("call_tim_config_switch", "1".equals(((JSONObject)localObject).getString("On")));
          }
          if (((JSONObject)localObject).has("Title")) {
            paramConfig.putString("call_tim_config_title", ((JSONObject)localObject).getString("Title"));
          }
          if (((JSONObject)localObject).has("androidURL")) {
            paramConfig.putString("call_tim_config_url", ((JSONObject)localObject).getString("androidURL"));
          }
        }
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
        continue;
      }
      paramConfig.commit();
      paramQQAppInterface = paramQQAppInterface.getPreferences().edit();
      paramQQAppInterface.putInt("call_tim_config_version", i);
      paramQQAppInterface.apply();
      return;
      label262:
      paramConfig.putBoolean("call_tim_config_switch", false);
    }
  }
  
  void G(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    if ((paramConfig.type.get() != 267) || (paramQQAppInterface == null)) {}
    int i;
    int j;
    do
    {
      return;
      i = bhhr.a(paramQQAppInterface.getApp(), "sport_config", jdField_a_of_type_JavaLangString);
      j = paramConfig.version.get();
    } while (i == j);
    ((bhwz)paramQQAppInterface.getManager(QQManagerFactory.SPORT_MANAGER)).a(paramConfig);
    bhhr.a(paramQQAppInterface.getApp(), "sport_config", jdField_a_of_type_JavaLangString, j);
  }
  
  public void H(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    if ((paramConfig.type.get() != 281) || (paramQQAppInterface == null)) {}
    do
    {
      String str;
      do
      {
        return;
        str = a(paramConfig, bhhr.a(paramQQAppInterface.getApp(), "troop_gift_anim_limit", "0"), 281);
      } while (TextUtils.isEmpty(str));
      if (QLog.isColorLevel()) {
        QLog.d("SPLASH_ConfigServlet", 2, "handleTroopGiftLimitConfig content: " + str);
      }
      int i = paramConfig.version.get();
      bhhr.a(paramQQAppInterface.getApp(), "troop_gift_anim_limit", "0", i);
      try
      {
        i = new JSONObject(str).getInt("limitGiftAnimCount");
        bggl.jdField_b_of_type_Int = i;
        paramQQAppInterface = PreferenceManager.getDefaultSharedPreferences(paramQQAppInterface.getApp()).edit();
        paramQQAppInterface.putInt("AIOAnimationControlManager_limit_gif_count_MAX", i);
        paramQQAppInterface.commit();
        return;
      }
      catch (JSONException paramQQAppInterface) {}
    } while (!QLog.isColorLevel());
    QLog.w("SPLASH_ConfigServlet", 2, "handleTroopGiftLimitConfig error" + paramQQAppInterface.getMessage());
  }
  
  public void I(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    if ((paramConfig == null) || (paramConfig.type.get() != 283)) {
      return;
    }
    paramQQAppInterface = a(paramConfig);
    if ((paramQQAppInterface != null) && (paramQQAppInterface.size() > 0))
    {
      paramQQAppInterface = (String)paramQQAppInterface.get(0);
      QLog.d("SafeModeUtil", 1, "handleSafeModeCmd configJson = " + paramQQAppInterface);
      MsfCmdConfig.executeSafeModeCmd(paramConfig.version.get(), paramQQAppInterface);
    }
    for (;;)
    {
      aauu.c();
      return;
      QLog.d("SafeModeUtil", 1, "handleSafeModeCmd null");
    }
  }
  
  public void J(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    if ((paramConfig.type.get() != 284) || (paramQQAppInterface == null)) {}
    int i;
    int j;
    do
    {
      return;
      i = bhhr.a(paramQQAppInterface.getApp(), "task_entry_config_version", jdField_a_of_type_JavaLangString);
      j = paramConfig.version.get();
      if (QLog.isColorLevel()) {
        QLog.w("zivonchen", 2, "handleTaskEntryConfig reqVersion = " + i);
      }
    } while (i == j);
    SharedPreferences.Editor localEditor = paramQQAppInterface.getApp().getSharedPreferences("task_entry_config" + jdField_a_of_type_JavaLangString, 0).edit();
    paramConfig = a(paramConfig);
    String str1;
    if ((paramConfig != null) && (paramConfig.size() > 0))
    {
      str1 = (String)paramConfig.get(0);
      if (QLog.isColorLevel()) {
        QLog.w("zivonchen", 2, "handleTaskEntryConfig configJson = " + str1);
      }
    }
    for (;;)
    {
      try
      {
        Object localObject = new JSONObject(str1);
        paramConfig = ((JSONObject)localObject).optString("icon_url");
        String str2 = ((JSONObject)localObject).optString("night_icon_url");
        String str3 = ((JSONObject)localObject).optString("jump_url");
        localObject = ((JSONObject)localObject).optString("word");
        if ((!TextUtils.isEmpty(paramConfig)) && (!TextUtils.isEmpty(str3)))
        {
          localEditor.putBoolean("open", true);
          localEditor.putString("icon_url", paramConfig);
          localEditor.putString("night_icon_url", str2);
          localEditor.putString("jump_url", str3);
          localEditor.putString("word", (String)localObject);
          bhhr.a(paramQQAppInterface.getApp(), "task_entry_config_version", jdField_a_of_type_JavaLangString, j);
          localEditor.commit();
          return;
        }
        localEditor.putBoolean("open", false);
        localEditor.remove("icon_url");
        localEditor.remove("night_icon_url");
        localEditor.remove("jump_url");
        localEditor.remove("word");
        continue;
      }
      catch (JSONException paramConfig)
      {
        localEditor.clear();
        if (!QLog.isColorLevel()) {
          continue;
        }
        paramConfig = str1;
        if (str1 == null) {
          paramConfig = "";
        }
        QLog.e("zivonchen", 2, new Object[] { "handleTaskEntryConfig json fail. content: ", paramConfig });
        continue;
      }
      localEditor.clear();
    }
  }
  
  public void K(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    int i = paramConfig.version.get();
    if (i != bpnj.a().a(paramQQAppInterface.getApp()))
    {
      paramConfig = a(paramConfig);
      if ((paramConfig != null) && (paramConfig.size() > 0))
      {
        paramConfig = (String)paramConfig.get(paramConfig.size() - 1);
        bpnj.a().a(paramConfig, i, paramQQAppInterface.getApp());
      }
    }
  }
  
  public void L(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    int i = paramConfig.version.get();
    if (i != bpqr.a().a(paramQQAppInterface.getApp()))
    {
      paramConfig = a(paramConfig);
      if ((paramConfig != null) && (paramConfig.size() > 0))
      {
        paramConfig = (String)paramConfig.get(0);
        bpqr.a().a(paramConfig, i, paramQQAppInterface.getApp());
      }
    }
  }
  
  public void M(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    int i = paramConfig.version.get();
    int j = bhhr.a(paramQQAppInterface.getApp(), "buluo_enter_config_version", jdField_a_of_type_JavaLangString);
    if (QLog.isColorLevel()) {
      QLog.i("SPLASH_ConfigServlet", 2, "handleBuluoEnterConfig: ,version: " + paramConfig.version.get() + "| localVersion: " + j);
    }
    if (i != j)
    {
      localObject1 = a(paramConfig);
      if ((localObject1 != null) && (((List)localObject1).size() > 0)) {
        localObject1 = (String)((List)localObject1).get(0);
      }
    }
    while (!QLog.isColorLevel())
    {
      do
      {
        try
        {
          paramConfig = new JSONObject((String)localObject1);
          if (paramConfig.has("jump_url"))
          {
            paramConfig = paramConfig.getJSONObject("jump_url");
            if (paramConfig.has("android"))
            {
              Object localObject2 = new JSONObject(paramConfig.getString("android"));
              if ((((JSONObject)localObject2).has("url")) && (((JSONObject)localObject2).has("scheme")))
              {
                paramConfig = ((JSONObject)localObject2).getString("scheme");
                localObject2 = ((JSONObject)localObject2).getString("url");
                paramConfig = paramConfig + bhcu.encodeToString(((String)localObject2).getBytes(), 0);
                bhhr.c(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin(), paramConfig);
                if (QLog.isColorLevel()) {
                  QLog.e("SPLASH_ConfigServlet", 2, new Object[] { "handleBuluoEnterConfig. buluoEntryUrl: ", paramConfig });
                }
              }
            }
          }
          for (;;)
          {
            bhhr.a(paramQQAppInterface.getApp(), "buluo_enter_config_version", jdField_a_of_type_JavaLangString, i);
            return;
            if (paramConfig.has("tribe_summary_url"))
            {
              paramConfig = paramConfig.optJSONObject("tribe_summary_url");
              if (paramConfig.has("android"))
              {
                paramConfig = paramConfig.optString("android");
                bhhr.d(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin(), paramConfig);
              }
            }
          }
        }
        catch (JSONException paramConfig)
        {
          for (;;)
          {
            Object localObject1;
            if (QLog.isColorLevel())
            {
              paramConfig = (ConfigurationService.Config)localObject1;
              if (localObject1 == null) {
                paramConfig = "";
              }
              QLog.e("SPLASH_ConfigServlet", 2, new Object[] { "handleBuluoEnterConfig json fail. content: ", paramConfig });
            }
          }
        }
      } while (!QLog.isColorLevel());
      QLog.d("SPLASH_ConfigServlet", 2, "handleBuluoEnterConfig json fail. configContent is empty ,version: " + paramConfig.version.get());
      return;
    }
    QLog.i("SPLASH_ConfigServlet", 2, "handleBuluoEnterConfig:localVersion == version = " + i);
  }
  
  void a(Intent paramIntent, ConfigurationService.Config paramConfig)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SPLASH_ConfigServlet", 2, "handleResp_GetArScanStarFaceConfig |  type= " + paramConfig.type.get());
    }
    apbf localapbf = (apbf)((QQAppInterface)getAppRuntime()).getManager(QQManagerFactory.AR_CLOBAL_CONFIG_MANAGER);
    int i;
    byte[] arrayOfByte;
    if (paramConfig.type.get() == 206)
    {
      i = paramConfig.version.get();
      if (paramIntent.getIntExtra("ar_scan_star_face_config_version", 0) == i) {
        break label353;
      }
      if ((paramConfig.msg_content_list == null) || (paramConfig.msg_content_list.size() <= 0)) {
        break label325;
      }
      paramIntent = (ConfigurationService.Content)paramConfig.msg_content_list.get(0);
      if (paramIntent == null) {
        break label307;
      }
      if (paramIntent.compress.get() != 1) {
        break label293;
      }
      arrayOfByte = ayym.a(paramIntent.content.get().toByteArray());
      if (arrayOfByte == null) {
        break label371;
      }
    }
    for (;;)
    {
      try
      {
        paramIntent = new String(arrayOfByte, "UTF-8");
        if (paramIntent != null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("SPLASH_ConfigServlet", 2, "handleResp_GetArScanStarFaceConfig, config_content is " + paramIntent);
          }
          i = paramConfig.version.get();
          if (localapbf.b(paramIntent)) {
            localapbf.b(i);
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d("SPLASH_ConfigServlet", 2, "handleResp_GetArScanStarFaceConfig, config type 206");
        }
        return;
      }
      catch (UnsupportedEncodingException paramIntent)
      {
        if (QLog.isColorLevel()) {
          paramIntent.printStackTrace();
        }
        paramIntent = null;
        continue;
      }
      catch (OutOfMemoryError paramIntent)
      {
        if (QLog.isColorLevel()) {
          paramIntent.printStackTrace();
        }
        System.gc();
        try
        {
          paramIntent = new String(arrayOfByte, "UTF-8");
        }
        catch (Throwable paramIntent)
        {
          paramIntent = null;
        }
        continue;
      }
      label293:
      paramIntent = paramIntent.content.get().toStringUtf8();
      continue;
      label307:
      if (QLog.isColorLevel())
      {
        QLog.d("SPLASH_ConfigServlet", 2, "handleResp_GetArScanStarFaceConfig, content is null");
        continue;
        label325:
        if (localapbf != null) {
          localapbf.c();
        }
        if (QLog.isColorLevel())
        {
          QLog.d("SPLASH_ConfigServlet", 2, "handleResp_GetArScanStarFaceConfig we delete ARConfig info here");
          continue;
          label353:
          if (QLog.isColorLevel())
          {
            QLog.d("SPLASH_ConfigServlet", 2, "handleResp_GetArScanStarFaceConfig, version same");
            continue;
            label371:
            paramIntent = null;
          }
        }
      }
    }
  }
  
  public void a(Intent paramIntent, boolean paramBoolean, ConfigurationService.Config paramConfig, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Olympic.configServlet", 2, new Object[] { "handleResp_GetOlympicActConfig, success=", Boolean.valueOf(paramBoolean) });
    }
    int m = 0;
    int i = 0;
    int j = 2;
    int k;
    OlympicActConfig localOlympicActConfig;
    if ((paramBoolean) && (paramConfig != null) && (paramConfig.type.get() == 86))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Olympic.configServlet", 2, new Object[] { "handleResp_GetOlympicActConfig, result=", Integer.valueOf(paramInt) });
      }
      if (paramInt == 0)
      {
        k = paramConfig.version.get();
        paramInt = paramIntent.getIntExtra("config_version", 0);
        if (QLog.isColorLevel()) {
          QLog.d("Olympic.configServlet", 2, new Object[] { "handleResp_GetOlympicActConfig, reqVersion=", Integer.valueOf(paramInt), ", receiveVersion=", Integer.valueOf(k) });
        }
        if (k != paramInt) {
          if ((paramConfig.msg_content_list != null) && (paramConfig.msg_content_list.size() > 0))
          {
            paramIntent = (ConfigurationService.Content)paramConfig.msg_content_list.get(0);
            if (paramIntent != null)
            {
              j = paramIntent.task_id.get();
              if (paramIntent.compress.get() == 1)
              {
                paramConfig = ayym.a(paramIntent.content.get().toByteArray());
                if (paramConfig == null)
                {
                  paramInt = 4;
                  paramIntent = null;
                  if (QLog.isColorLevel()) {
                    QLog.d("Olympic.configServlet", 2, new Object[] { "handleResp_GetOlympicActConfig, xmlContent=", paramIntent });
                  }
                  localOlympicActConfig = OlympicActConfig.parse(getAppRuntime(), paramIntent);
                  if (QLog.isColorLevel())
                  {
                    if (localOlympicActConfig != null) {
                      break label523;
                    }
                    paramConfig = "null";
                    label294:
                    QLog.d("Olympic.configServlet", 2, new Object[] { "handleResp_GetOlympicActConfig, newConfig=", paramConfig });
                  }
                  if (localOlympicActConfig == null) {
                    break label556;
                  }
                  i = 0;
                  localOlympicActConfig.version = k;
                  paramIntent = (OlympicManager)((QQAppInterface)getAppRuntime()).getManager(QQManagerFactory.OLYMPIC_MANAGER);
                  if (paramIntent == null) {
                    break label529;
                  }
                  paramIntent.a(localOlympicActConfig);
                  paramInt = i;
                  label361:
                  i = j;
                  label365:
                  j = k;
                  k = i;
                  i = paramInt;
                  paramInt = k;
                }
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      for (;;)
      {
        OlympicServlet.a(getAppRuntime(), 86, j, paramInt, 1, i, -1);
        paramIntent = (OlympicManager)((QQAppInterface)getAppRuntime()).getManager(QQManagerFactory.OLYMPIC_MANAGER);
        if (paramIntent != null)
        {
          paramIntent.g();
          paramIntent.f();
        }
        return;
        try
        {
          paramIntent = new String(paramConfig, "UTF-8");
          paramInt = 2;
        }
        catch (UnsupportedEncodingException paramIntent)
        {
          if (QLog.isColorLevel()) {
            paramIntent.printStackTrace();
          }
          paramIntent = null;
          paramInt = 2;
        }
        catch (OutOfMemoryError paramIntent)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              paramIntent.printStackTrace();
            }
            System.gc();
            try
            {
              paramIntent = new String(paramConfig, "UTF-8");
              paramInt = 2;
            }
            catch (Throwable paramIntent)
            {
              paramIntent = null;
              paramInt = 2;
            }
          }
        }
      }
      break;
      paramIntent = paramIntent.content.get().toStringUtf8();
      paramInt = 2;
      break;
      label523:
      paramConfig = localOlympicActConfig;
      break label294;
      label529:
      paramInt = i;
      if (!QLog.isColorLevel()) {
        break label361;
      }
      QLog.d("Olympic.configServlet", 2, "handleResp_GetOlympicActConfig, manager is null!");
      paramInt = i;
      break label361;
      label556:
      i = paramInt;
      if (paramIntent != null) {
        i = 5;
      }
      paramInt = i;
      if (!QLog.isColorLevel()) {
        break label361;
      }
      QLog.d("Olympic.configServlet", 2, "handleResp_GetOlympicActConfig, parse failed, newConfig is null!");
      paramInt = i;
      break label361;
      if (QLog.isColorLevel()) {
        QLog.d("Olympic.configServlet", 2, "handleResp_GetOlympicActConfig, content is null");
      }
      i = 0;
      paramInt = j;
      break label365;
      if (QLog.isColorLevel()) {
        QLog.d("Olympic.configServlet", 2, "handleResp_GetOlympicActConfig, msg_content_list is null");
      }
      paramIntent = (QQAppInterface)getAppRuntime();
      paramConfig = (OlympicManager)paramIntent.getManager(QQManagerFactory.OLYMPIC_MANAGER);
      if (paramConfig != null) {
        paramConfig.e();
      }
      OlympicActConfig.deleteFile(paramIntent, BaseApplicationImpl.getContext());
      paramInt = j;
      i = m;
      break label365;
      paramInt = j;
      i = m;
      if (!QLog.isColorLevel()) {
        break label365;
      }
      QLog.d("Olympic.configServlet", 2, "handleResp_GetOlympicActConfig, has same version");
      paramInt = j;
      i = m;
      break label365;
      paramInt = 0;
      k = 1;
      j = i;
      i = k;
      continue;
      paramInt = 0;
      k = 1;
      j = i;
      i = k;
    }
  }
  
  void a(QQAppInterface paramQQAppInterface, Intent paramIntent, ConfigurationService.Config paramConfig)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SPLASH_ConfigServlet", 2, "handleResp_GetArScanFacePreDownConfig |  type= " + paramConfig.type.get());
    }
    if (paramConfig.type.get() != 205) {}
    do
    {
      do
      {
        do
        {
          return;
          int i = paramConfig.version.get();
          if (paramIntent.getIntExtra("key_download_cfg_version", 0) != i) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d("SPLASH_ConfigServlet", 2, "handleResp_GetArScanFacePreDownConfig, version same");
        return;
        if ((paramConfig.msg_content_list != null) && (paramConfig.msg_content_list.size() > 0)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("SPLASH_ConfigServlet", 2, "handleResp_GetArScanFacePreDownConfig we delete ARConfig info here");
      return;
      paramIntent = (ConfigurationService.Content)paramConfig.msg_content_list.get(0);
      if (paramIntent != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("SPLASH_ConfigServlet", 2, "handleResp_GetArScanFacePreDownConfig, content is null");
    return;
    byte[] arrayOfByte;
    if (paramIntent.compress.get() == 1)
    {
      arrayOfByte = ayym.a(paramIntent.content.get().toByteArray());
      if (arrayOfByte == null) {
        break label351;
      }
    }
    for (;;)
    {
      try
      {
        paramIntent = new String(arrayOfByte, "UTF-8");
        if (paramIntent == null) {
          break label329;
        }
        if (QLog.isColorLevel()) {
          QLog.d("SPLASH_ConfigServlet", 2, "handleResp_GetArScanFacePreDownConfig, config_content is " + paramIntent);
        }
        apgm.a(paramQQAppInterface, paramIntent, paramConfig.version.get());
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("SPLASH_ConfigServlet", 2, "handleResp_GetArScanFacePreDownConfig, config type 205");
        return;
      }
      catch (UnsupportedEncodingException paramIntent)
      {
        if (QLog.isColorLevel()) {
          paramIntent.printStackTrace();
        }
        paramIntent = null;
        continue;
      }
      catch (OutOfMemoryError paramIntent)
      {
        if (QLog.isColorLevel()) {
          paramIntent.printStackTrace();
        }
        System.gc();
        try
        {
          paramIntent = new String(arrayOfByte, "UTF-8");
        }
        catch (Throwable paramIntent)
        {
          paramIntent = null;
        }
        continue;
      }
      paramIntent = paramIntent.content.get().toStringUtf8();
      continue;
      label329:
      apgm.b(paramQQAppInterface);
      if (QLog.isColorLevel())
      {
        QLog.d("SPLASH_ConfigServlet", 2, "handleResp_GetArScanFacePreDownConfig we delete ARConfig info here");
        continue;
        label351:
        paramIntent = null;
      }
    }
  }
  
  protected void a(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    if (paramConfig != null) {}
    for (;;)
    {
      try
      {
        if (paramConfig.type.get() != 143) {
          break label366;
        }
        if ((paramConfig.msg_content_list == null) || (paramConfig.msg_content_list.size() <= 0)) {
          break label431;
        }
        Object localObject1 = (ConfigurationService.Content)paramConfig.msg_content_list.get(0);
        if (localObject1 == null) {
          break label349;
        }
        if (((ConfigurationService.Content)localObject1).compress.get() == 1)
        {
          byte[] arrayOfByte = ayym.a(((ConfigurationService.Content)localObject1).content.get().toByteArray());
          if (arrayOfByte == null) {
            break label425;
          }
          try
          {
            localObject1 = new String(arrayOfByte, "UTF-8");
            if (localObject1 == null) {
              break label431;
            }
            if (QLog.isColorLevel()) {
              QLog.d("SPLASH_ConfigServletQ.nearby.tag_nearby_glamour_level_config", 2, "receiveAllConfigs|type: 143,content: " + (String)localObject1 + ",version: " + paramConfig.version.get());
            }
            int i = paramConfig.version.get();
            if ((i == bhhr.a(paramQQAppInterface.getApp(), "nearby_glamour_level_config_version", jdField_a_of_type_JavaLangString)) || (TextUtils.isEmpty((CharSequence)localObject1))) {
              continue;
            }
            axoi.a((String)localObject1);
            axoi.b((String)localObject1);
            bhhr.h(paramQQAppInterface.getApp(), (String)localObject1);
            bhhr.a(paramQQAppInterface.getApp(), "nearby_glamour_level_config_version", jdField_a_of_type_JavaLangString, i);
            return;
          }
          catch (UnsupportedEncodingException localUnsupportedEncodingException)
          {
            if (!QLog.isColorLevel()) {
              break label432;
            }
            localUnsupportedEncodingException.printStackTrace();
          }
          catch (OutOfMemoryError localOutOfMemoryError)
          {
            if (QLog.isColorLevel()) {
              localOutOfMemoryError.printStackTrace();
            }
            System.gc();
            try
            {
              String str = new String(arrayOfByte, "UTF-8");
            }
            catch (Throwable localThrowable)
            {
              localObject2 = null;
            }
            continue;
          }
        }
        else
        {
          localObject2 = ((ConfigurationService.Content)localObject2).content.get().toStringUtf8();
          continue;
        }
        if (!QLog.isColorLevel()) {
          break label431;
        }
        QLog.d("SPLASH_ConfigServletQ.nearby.tag_nearby_glamour_level_config", 2, "received CHNAGE_MACHINE_CONFIG IGNORE THIS ACTION  because of SAME VERSION ");
        return;
      }
      catch (Exception paramQQAppInterface)
      {
        if (!QLog.isColorLevel()) {
          break label431;
        }
      }
      QLog.e("SPLASH_ConfigServletQ.nearby.tag_nearby_glamour_level_config", 2, "received change machine config error,cmd : 143" + paramQQAppInterface.toString());
      return;
      label349:
      if (QLog.isColorLevel())
      {
        QLog.d("SPLASH_ConfigServletQ.nearby.tag_nearby_glamour_level_config", 2, "handleNearbyGlamourLevelConfig, content is null");
        return;
        label366:
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder().append("receiveAllConfigs|type: 143,content_list is empty ,version: ");
          if (paramConfig != null) {}
          for (paramQQAppInterface = Integer.valueOf(paramConfig.version.get());; paramQQAppInterface = "")
          {
            QLog.d("SPLASH_ConfigServletQ.nearby.tag_nearby_glamour_level_config", 2, paramQQAppInterface);
            return;
          }
          localObject2 = null;
          continue;
        }
      }
      label425:
      label431:
      return;
      label432:
      Object localObject2 = null;
    }
  }
  
  protected void a(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig, String paramString, arpk paramarpk)
  {
    int j = paramConfig.version.get();
    int i = paramarpk.a();
    if (QLog.isColorLevel()) {
      QLog.d("TroopRankConfig", 2, paramString + ", serverVersion=" + j + "|localVersion=" + i);
    }
    if ((j != i) && (paramConfig.msg_content_list.size() > 0))
    {
      ArrayList localArrayList = new ArrayList();
      int k = paramConfig.msg_content_list.size();
      i = 0;
      if (i < k)
      {
        paramQQAppInterface = (ConfigurationService.Content)paramConfig.msg_content_list.get(0);
        byte[] arrayOfByte;
        if (paramQQAppInterface != null)
        {
          if (paramQQAppInterface.compress.get() != 1) {
            break label271;
          }
          arrayOfByte = ayym.a(paramQQAppInterface.content.get().toByteArray());
          if (arrayOfByte == null) {
            break label266;
          }
        }
        for (;;)
        {
          try
          {
            paramQQAppInterface = new String(arrayOfByte, "UTF-8");
            if (!TextUtils.isEmpty(paramQQAppInterface)) {
              localArrayList.add(paramQQAppInterface);
            }
            i += 1;
          }
          catch (Exception paramQQAppInterface)
          {
            if (QLog.isColorLevel()) {
              QLog.w("SPLASH_ConfigServlet", 2, paramString, paramQQAppInterface);
            }
            paramQQAppInterface = null;
            continue;
          }
          catch (OutOfMemoryError paramQQAppInterface)
          {
            if (QLog.isColorLevel()) {
              QLog.w("SPLASH_ConfigServlet", 2, paramString, paramQQAppInterface);
            }
            System.gc();
            try
            {
              paramQQAppInterface = new String(arrayOfByte, "UTF-8");
            }
            catch (Throwable paramQQAppInterface)
            {
              if (QLog.isColorLevel()) {
                QLog.w("SPLASH_ConfigServlet", 2, paramString, paramQQAppInterface);
              }
            }
          }
          label266:
          paramQQAppInterface = null;
          continue;
          label271:
          paramQQAppInterface = paramQQAppInterface.content.get().toStringUtf8();
        }
      }
      if (localArrayList.size() <= 0) {
        break label314;
      }
      paramarpk.a(j);
      paramarpk.a(localArrayList);
    }
    label314:
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("SPLASH_ConfigServlet", 2, paramString + ", config_content is empty");
  }
  
  public void a(ConfigurationService.Config paramConfig)
  {
    for (;;)
    {
      int i;
      try
      {
        QQAppInterface localQQAppInterface = (QQAppInterface)getAppRuntime();
        if ((paramConfig.content_list != null) && (paramConfig.content_list.size() > 0))
        {
          i = 0;
          if (i < paramConfig.content_list.size())
          {
            String str = ((String)paramConfig.content_list.get(i)).trim();
            if (QLog.isColorLevel()) {
              QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 79,content: " + str + ",version: " + paramConfig.version.get());
            }
            int j = paramConfig.version.get();
            if ((j != bhhr.M(localQQAppInterface.getApp(), localQQAppInterface.getCurrentAccountUin())) || (paramConfig.content_list.size() > 0))
            {
              str = str.split("=")[1];
              if (!TextUtils.isEmpty(str)) {
                bmhv.c(str, localQQAppInterface);
              }
              bhhr.p(localQQAppInterface.getApp(), j, localQQAppInterface.getCurrentAccountUin());
            }
            else if (QLog.isColorLevel())
            {
              QLog.d("SPLASH_ConfigServlet", 2, "received READINJOY_MERGE_CONFIG_CMD IGNORE THIS ACTION  because of SAME VERSION");
            }
          }
        }
      }
      catch (Exception paramConfig)
      {
        if (QLog.isColorLevel()) {
          QLog.e("SPLASH_ConfigServlet", 2, "received readinjoy merge config error,cmd : 79" + paramConfig.toString());
        }
      }
      while (!QLog.isColorLevel()) {
        return;
      }
      QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 79,content_list is empty ,version: " + paramConfig.version.get());
      return;
      i += 1;
    }
  }
  
  public void b(Intent paramIntent, boolean paramBoolean, ConfigurationService.Config paramConfig, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.camera.configServlet", 2, "[handleRespQCameraPhoneConfig] ENTER success=" + paramBoolean + " result=" + paramInt);
    }
    int j = 0;
    int i = 2;
    String str = paramIntent.getStringExtra("uin");
    int k;
    if ((paramBoolean) && (paramConfig != null) && (paramConfig.type.get() == 109)) {
      if (paramInt == 0)
      {
        k = paramConfig.version.get();
        int m = paramIntent.getIntExtra("qcamera_conf_version", 0);
        QLog.i("Q.camera.configServlet", 1, "[handleRespQCameraPhoneConfig] reqVersion=" + m + " receiveVersion=" + k);
        paramInt = i;
        i = j;
        if (k != m)
        {
          aqmy.a(BaseApplicationImpl.getContext(), k);
          if (QLog.isColorLevel()) {
            QLog.d("Q.camera.configServlet", 2, "[handleRespQCameraPhoneConfig] save version: " + k + " and check config version: " + aqmy.a(BaseApplicationImpl.getContext()));
          }
          if ((paramConfig.msg_content_list == null) || (paramConfig.msg_content_list.size() <= 0)) {
            break label560;
          }
          paramIntent = (ConfigurationService.Content)paramConfig.msg_content_list.get(0);
          i = paramIntent.task_id.get();
          if (paramIntent.compress.get() != 1) {
            break label506;
          }
          paramIntent = aqmy.a(paramIntent.content.get().toByteArray());
          if (paramIntent == null)
          {
            paramInt = 4;
            aqmy.a(BaseApplicationImpl.getContext(), true);
            QLog.w("Q.camera.configServlet", 1, "[handleRespQCameraPhoneConfig] uncompress failed");
          }
        }
        else
        {
          j = paramInt;
          paramInt = k;
          k = i;
          i = m;
        }
      }
    }
    for (;;)
    {
      for (;;)
      {
        for (;;)
        {
          QLog.i("Q.camera.configServlet", 1, "[handleRespQCameraPhoneConfig] rptResult=" + j);
          paramIntent = new HashMap();
          paramIntent.put("rpt_type", String.valueOf(109));
          paramIntent.put("rpt_task_id", String.valueOf(k));
          paramIntent.put("rpt_req_version", String.valueOf(i));
          paramIntent.put("rpt_version", String.valueOf(paramInt));
          paramIntent.put("rpt_report_type", String.valueOf(1));
          paramIntent.put("rpt_result", String.valueOf(j));
          StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(str, "qcamera_phone_config_pull_event", paramBoolean, 0L, 0L, paramIntent, String.valueOf(j));
          return;
          paramInt = 0;
          paramIntent = new String(paramIntent);
          if (QLog.isColorLevel()) {
            QLog.d("Q.camera.configServlet", 4, "[handleRespQCameraPhoneConfig] zip");
          }
          try
          {
            aqmy.a(BaseApplicationImpl.getContext(), paramIntent, k);
          }
          catch (Exception paramIntent)
          {
            paramIntent.printStackTrace();
            paramInt = 3;
          }
        }
        break;
        label506:
        paramIntent = paramIntent.content.get().toStringUtf8();
        if (QLog.isColorLevel()) {
          QLog.d("Q.camera.configServlet", 4, "[handleRespQCameraPhoneConfig]");
        }
        try
        {
          aqmy.a(BaseApplicationImpl.getContext(), paramIntent, k);
          paramInt = 0;
        }
        catch (Exception paramIntent)
        {
          paramIntent.printStackTrace();
          paramInt = 3;
        }
      }
      break;
      label560:
      paramInt = 5;
      QLog.w("Q.camera.configServlet", 1, "[handleRespQCameraPhoneConfig] no data, current disableCameraSDK=" + aqmy.a(BaseApplicationImpl.getContext()));
      i = j;
      break;
      paramInt = 0;
      j = 1;
      k = 0;
      i = 0;
      continue;
      paramInt = 0;
      j = 1;
      k = 0;
      i = 0;
    }
  }
  
  protected void b(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    for (;;)
    {
      int i;
      try
      {
        bbyl localbbyl = (bbyl)paramQQAppInterface.getManager(QQManagerFactory.FUNCTION_MODULE_MANAGER);
        if ((paramConfig != null) && (paramConfig.type.get() == 190)) {
          if ((paramConfig.msg_content_list != null) && (paramConfig.msg_content_list.size() > 0))
          {
            i = 0;
            if (i < paramConfig.msg_content_list.size())
            {
              Object localObject1 = (ConfigurationService.Content)paramConfig.msg_content_list.get(i);
              if (localObject1 == null) {
                break label382;
              }
              if (((ConfigurationService.Content)localObject1).compress.get() == 1)
              {
                byte[] arrayOfByte = ayym.a(((ConfigurationService.Content)localObject1).content.get().toByteArray());
                if (arrayOfByte == null) {
                  break label460;
                }
                try
                {
                  localObject1 = new String(arrayOfByte, "UTF-8");
                  if (localObject1 == null) {
                    break label466;
                  }
                  if (QLog.isColorLevel()) {
                    QLog.d("SPLASH_ConfigServletQ.uniteSearch.tag_search_function_module", 2, "receiveAllConfigs|type: 190,content: " + (String)localObject1 + ",version: " + paramConfig.version.get());
                  }
                  int j = paramConfig.version.get();
                  if ((j == bhhr.a(paramQQAppInterface.getApp(), "search_function_config_version", jdField_a_of_type_JavaLangString)) || (TextUtils.isEmpty((CharSequence)localObject1))) {
                    continue;
                  }
                  localbbyl.b(new JSONObject((String)localObject1).optString("kFTSFunctionListUrlKey"));
                  bhhr.a(paramQQAppInterface.getApp(), "search_function_config_version", jdField_a_of_type_JavaLangString, j);
                }
                catch (UnsupportedEncodingException localUnsupportedEncodingException)
                {
                  if (!QLog.isColorLevel()) {
                    break label473;
                  }
                  localUnsupportedEncodingException.printStackTrace();
                  break label473;
                }
                catch (OutOfMemoryError localOutOfMemoryError)
                {
                  if (QLog.isColorLevel()) {
                    localOutOfMemoryError.printStackTrace();
                  }
                  System.gc();
                  try
                  {
                    String str = new String(arrayOfByte, "UTF-8");
                  }
                  catch (Throwable localThrowable)
                  {
                    localObject2 = null;
                  }
                  continue;
                }
              }
              else
              {
                localObject2 = ((ConfigurationService.Content)localObject2).content.get().toStringUtf8();
                continue;
              }
              if (!QLog.isColorLevel()) {
                break label466;
              }
              QLog.d("SPLASH_ConfigServletQ.uniteSearch.tag_search_function_module", 2, "received SEARCH_FUNCTION_MODULE_CONFIG IGNORE THIS ACTION  because of SAME VERSION ");
            }
          }
        }
      }
      catch (Exception paramQQAppInterface)
      {
        if (QLog.isColorLevel()) {
          QLog.e("SPLASH_ConfigServletQ.uniteSearch.tag_search_function_module", 2, "received search function module error,cmd : 190" + paramQQAppInterface.toString());
        }
      }
      label382:
      do
      {
        return;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("SPLASH_ConfigServletQ.uniteSearch.tag_search_function_module", 2, "handleFunctionModuleConfig, content is null");
        break;
      } while (!QLog.isColorLevel());
      Object localObject2 = new StringBuilder().append("receiveAllConfigs|type: 190,msg_content_list is empty ,version: ");
      if (paramConfig != null) {}
      for (paramQQAppInterface = Integer.valueOf(paramConfig.version.get());; paramQQAppInterface = "")
      {
        QLog.d("SPLASH_ConfigServletQ.uniteSearch.tag_search_function_module", 2, paramQQAppInterface);
        return;
      }
      label460:
      localObject2 = null;
      continue;
      label466:
      i += 1;
      continue;
      label473:
      localObject2 = null;
    }
  }
  
  public void b(ConfigurationService.Config paramConfig)
  {
    for (;;)
    {
      int i;
      try
      {
        QQAppInterface localQQAppInterface = (QQAppInterface)getAppRuntime();
        if ((paramConfig.content_list != null) && (paramConfig.content_list.size() > 0))
        {
          i = 0;
          if (i < paramConfig.content_list.size())
          {
            String str = (String)paramConfig.content_list.get(i);
            if (QLog.isColorLevel()) {
              QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 72,content: " + str + ",version: " + paramConfig.version.get());
            }
            int j = paramConfig.version.get();
            if ((j != bhhr.L(localQQAppInterface.getApp(), localQQAppInterface.getCurrentUin())) || (paramConfig.content_list.size() > 0))
            {
              if (bmhv.a(localQQAppInterface, str))
              {
                if (QLog.isColorLevel()) {
                  QLog.d("SPLASH_ConfigServlet", 2, "received 72 ark config");
                }
                bhhr.s(getAppRuntime().getApplication(), localQQAppInterface.getCurrentUin(), j);
                break label304;
              }
              if ((!usu.b((QQAppInterface)getAppRuntime(), str)) || (!QLog.isColorLevel())) {
                continue;
              }
              QLog.d("SPLASH_ConfigServlet", 2, "received READINJOY_FOLDER_CONFIG_CMD save version: " + j);
              continue;
            }
          }
          else
          {
            return;
          }
        }
      }
      catch (Exception paramConfig)
      {
        if (QLog.isColorLevel()) {
          QLog.e("SPLASH_ConfigServlet", 2, "received readinjoy folder config error,cmd : 72");
        }
      }
      while (QLog.isColorLevel())
      {
        QLog.d("SPLASH_ConfigServlet", 2, "received READINJOY_FOLDER_CONFIG_CMD IGNORE THIS ACTION  because of SAME VERSION");
        break;
        if (QLog.isColorLevel())
        {
          QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 72,content_list is empty ,version: " + paramConfig.version.get());
          return;
        }
      }
      label304:
      i += 1;
    }
  }
  
  public void c(ConfigurationService.Config paramConfig)
  {
    for (;;)
    {
      int i;
      try
      {
        QQAppInterface localQQAppInterface = (QQAppInterface)getAppRuntime();
        if ((paramConfig.content_list != null) && (paramConfig.content_list.size() > 0))
        {
          i = 0;
          if (i < paramConfig.content_list.size())
          {
            Object localObject1 = ((String)paramConfig.content_list.get(i)).trim();
            if (QLog.isColorLevel()) {
              QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 73,content: " + (String)localObject1 + ",version: " + paramConfig.version.get());
            }
            int j = paramConfig.version.get();
            if ((j != bhhr.w(localQQAppInterface.getApp())) || (paramConfig.content_list.size() > 0))
            {
              Object localObject2 = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new ByteArrayInputStream(((String)localObject1).getBytes("utf-8")));
              localObject1 = (Element)((Document)localObject2).getElementsByTagName("kandian_setting").item(0);
              localObject2 = (Element)((Document)localObject2).getElementsByTagName("url").item(0);
              localObject1 = ((Element)localObject1).getFirstChild().getNodeValue();
              localObject2 = ((Element)localObject2).getFirstChild().getNodeValue();
              if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!TextUtils.isEmpty((CharSequence)localObject2))) {
                bhhr.b(localQQAppInterface.getApp(), (String)localObject2, "1".equals(localObject1));
              }
              bhhr.n(localQQAppInterface.getApp(), j);
            }
            else if (QLog.isColorLevel())
            {
              QLog.d("SPLASH_ConfigServlet", 2, "received READINJOY_FOLDER_SETTING_CMD IGNORE THIS ACTION  because of SAME VERSION");
            }
          }
        }
      }
      catch (Exception paramConfig)
      {
        if (QLog.isColorLevel()) {
          QLog.e("SPLASH_ConfigServlet", 2, "received readinjoy folder setting config error,cmd : 73");
        }
      }
      while (!QLog.isColorLevel()) {
        return;
      }
      QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 73,content_list is empty ,version: " + paramConfig.version.get());
      return;
      i += 1;
    }
  }
  
  public void d(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    if (QLog.isColorLevel()) {
      QLog.d("HotFriend_SPLASH_ConfigServlet", 2, "handleRespGetHotDaysConfig|type= " + paramConfig.type.get());
    }
    if (paramConfig != null) {}
    for (;;)
    {
      Object localObject2;
      try
      {
        if (paramConfig.type.get() != 146) {
          break label283;
        }
        if ((paramConfig.msg_content_list == null) || (paramConfig.msg_content_list.size() <= 0)) {
          break label345;
        }
        Object localObject1 = (ConfigurationService.Content)paramConfig.msg_content_list.get(0);
        if (localObject1 != null)
        {
          if (((ConfigurationService.Content)localObject1).compress.get() == 1)
          {
            byte[] arrayOfByte = ayym.a(((ConfigurationService.Content)localObject1).content.get().toByteArray());
            if (arrayOfByte == null) {
              break label340;
            }
            try
            {
              localObject1 = new String(arrayOfByte, "UTF-8");
              if (localObject1 == null) {
                break label345;
              }
              if (QLog.isColorLevel()) {
                QLog.d("HotFriend_SPLASH_ConfigServlet", 2, "handleRespGetHotDaysConfig, config_content is " + (String)localObject1);
              }
              axmy.a(paramQQAppInterface, (String)localObject1, paramConfig.version.get());
              return;
            }
            catch (UnsupportedEncodingException localUnsupportedEncodingException)
            {
              if (!QLog.isColorLevel()) {
                break label346;
              }
              localUnsupportedEncodingException.printStackTrace();
            }
            catch (OutOfMemoryError localOutOfMemoryError)
            {
              if (QLog.isColorLevel()) {
                localOutOfMemoryError.printStackTrace();
              }
              System.gc();
              try
              {
                String str = new String(arrayOfByte, "UTF-8");
              }
              catch (Throwable localThrowable)
              {
                localObject2 = null;
              }
              continue;
            }
          }
          localObject2 = ((ConfigurationService.Content)localObject2).content.get().toStringUtf8();
          continue;
        }
        if (!QLog.isColorLevel()) {
          break label345;
        }
        QLog.d("HotFriend_SPLASH_ConfigServlet", 2, "handleRespGetHotDaysConfig, content is null");
        return;
      }
      catch (Exception paramQQAppInterface)
      {
        if (!QLog.isColorLevel()) {
          break label345;
        }
      }
      QLog.e("HotFriend_SPLASH_ConfigServlet", 2, paramQQAppInterface.toString());
      return;
      label283:
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder().append("content_list is empty ,version: ");
        if (paramConfig != null) {}
        for (paramQQAppInterface = Integer.valueOf(paramConfig.version.get());; paramQQAppInterface = "")
        {
          QLog.d("HotFriend_SPLASH_ConfigServlet", 2, paramQQAppInterface);
          return;
        }
        label340:
        localObject2 = null;
      }
      else
      {
        label345:
        return;
        label346:
        localObject2 = null;
      }
    }
  }
  
  void e(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    if (paramConfig.type.get() != 147) {}
    for (;;)
    {
      return;
      int i = bhhr.a(paramQQAppInterface.getApp(), "shop_tab", jdField_a_of_type_JavaLangString);
      int j = paramConfig.version.get();
      if ((i != j) && (paramConfig.content_list != null) && (paramConfig.content_list.size() > 0)) {
        try
        {
          paramConfig = new JSONObject((String)paramConfig.content_list.get(0));
          boolean bool = paramConfig.getBoolean("android");
          bhhr.a(paramQQAppInterface.getApp(), "shop_tab", jdField_a_of_type_JavaLangString, j);
          paramQQAppInterface = (onq)paramQQAppInterface.getManager(QQManagerFactory.EC_SHOP_ASSISTANT_MANAGER);
          paramQQAppInterface.b(bool);
          paramQQAppInterface.c = paramConfig.optBoolean("preload_web_process", false);
          paramQQAppInterface.a = paramConfig.optLong("stay_time", 5000L);
          paramQQAppInterface.d = paramConfig.optInt("day_limit", 3);
          onq.a().edit().putBoolean("preload_web", paramQQAppInterface.c).putLong("stayTime", paramQQAppInterface.a).putInt("dayLimit", paramQQAppInterface.d).commit();
          if (QLog.isColorLevel())
          {
            QLog.i("Ecshop", 2, "current config set tab show:" + bool + ",preload:" + paramQQAppInterface.c + ",stayTime:" + paramQQAppInterface.a + ",dayLimit:" + paramQQAppInterface.d);
            return;
          }
        }
        catch (Exception paramQQAppInterface) {}
      }
    }
  }
  
  protected void f(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SPLASH_ConfigServlet", 2, "handleQuickShotShareToStoryConfig type = " + paramConfig.type.get());
    }
    int i = bhhr.Y(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentUin());
    int j = paramConfig.version.get();
    if (i == j)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SPLASH_ConfigServlet", 2, "handleQuickShotShareToStoryConfig version code not changed .");
      }
      return;
    }
    bhhr.x(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentUin(), j);
    if ((paramConfig.msg_content_list == null) || (paramConfig.msg_content_list.size() < 1) || (paramConfig.msg_content_list.get(0) == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SPLASH_ConfigServlet", 2, "handleQuickShotShareToStoryConfig data is null!!!");
      }
      bhhr.h(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentUin(), null);
      return;
    }
    paramConfig = (ConfigurationService.Content)paramConfig.msg_content_list.get(0);
    byte[] arrayOfByte;
    if (paramConfig.compress.get() == 1)
    {
      arrayOfByte = ayym.a(paramConfig.content.get().toByteArray());
      if (arrayOfByte == null) {}
    }
    for (;;)
    {
      try
      {
        paramConfig = new String(arrayOfByte, "UTF-8");
        if (TextUtils.isEmpty(paramConfig)) {
          break label367;
        }
        bhhr.h(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentUin(), paramConfig);
        ((vzv)paramQQAppInterface.getManager(QQManagerFactory.QQSTORY_MANAGER)).a(paramConfig);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("SPLASH_ConfigServlet", 2, "handleQuickShotShareToStoryConfig() configContent = " + paramConfig);
        return;
      }
      catch (Exception paramConfig)
      {
        if (QLog.isColorLevel()) {
          QLog.w("SPLASH_ConfigServlet", 2, QLog.getStackTraceString(paramConfig));
        }
        paramConfig = null;
        continue;
      }
      catch (OutOfMemoryError paramConfig)
      {
        if (QLog.isColorLevel()) {
          QLog.w("SPLASH_ConfigServlet", 2, QLog.getStackTraceString(paramConfig));
        }
        System.gc();
        try
        {
          paramConfig = new String(arrayOfByte, "UTF-8");
        }
        catch (Throwable paramConfig)
        {
          if (QLog.isColorLevel()) {
            QLog.w("SPLASH_ConfigServlet", 2, QLog.getStackTraceString(paramConfig));
          }
        }
      }
      paramConfig = null;
      continue;
      paramConfig = paramConfig.content.get().toStringUtf8();
      continue;
      label367:
      bhhr.h(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentUin(), null);
    }
  }
  
  void g(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    int i = bhhr.ad(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
    int j = paramConfig.version.get();
    if ((i != j) && (paramConfig.msg_content_list != null) && (paramConfig.msg_content_list.size() > 0))
    {
      paramConfig = (ConfigurationService.Content)paramConfig.msg_content_list.get(0);
      if (paramConfig != null)
      {
        if (paramConfig.compress.get() != 1) {
          break label219;
        }
        paramConfig = ayym.a(paramConfig.content.get().toByteArray());
        if (paramConfig == null) {
          break label239;
        }
      }
    }
    for (;;)
    {
      try
      {
        paramConfig = new String(paramConfig, "UTF-8");
        if (paramConfig == null) {}
      }
      catch (Exception paramConfig)
      {
        try
        {
          paramConfig = new JSONObject(paramConfig);
          boolean bool1 = paramConfig.getBoolean("wifiAutoPreDown");
          boolean bool2 = paramConfig.getBoolean("noSafeDown");
          bhhr.m(paramQQAppInterface.getApp(), "wifiAutoPreDown", "" + bool1);
          bhhr.m(paramQQAppInterface.getApp(), "noSafeDown", "" + bool2);
          bhhr.C(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, j);
          return;
        }
        catch (Exception paramQQAppInterface)
        {
          paramQQAppInterface.printStackTrace();
          return;
        }
        paramConfig = paramConfig;
        QLog.d("SPLASH_ConfigServlet", 2, "handleQQPreDownYYBConfig|uncompress failed");
        paramConfig = null;
        continue;
      }
      label219:
      paramConfig = paramConfig.content.get().toStringUtf8();
      continue;
      label239:
      paramConfig = null;
    }
  }
  
  void h(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    int i = bhhr.aa(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
    int j = paramConfig.version.get();
    if ((i != j) && (paramConfig.msg_content_list != null) && (paramConfig.msg_content_list.size() > 0))
    {
      paramConfig = (ConfigurationService.Content)paramConfig.msg_content_list.get(0);
      if (paramConfig != null)
      {
        if (paramConfig.compress.get() != 1) {
          break label206;
        }
        paramConfig = ayym.a(paramConfig.content.get().toByteArray());
        if (paramConfig == null) {
          break label226;
        }
      }
    }
    for (;;)
    {
      try
      {
        paramConfig = new String(paramConfig, "UTF-8");
        if (paramConfig == null) {}
      }
      catch (Exception paramConfig)
      {
        try
        {
          Object localObject = new JSONObject(paramConfig);
          paramConfig = ((JSONObject)localObject).getString("url");
          String str = ((JSONObject)localObject).getString("wantWord");
          localObject = ((JSONObject)localObject).getString("thxWord");
          bhhr.k(paramQQAppInterface.getApp(), "url", paramConfig);
          bhhr.k(paramQQAppInterface.getApp(), "thxWord", (String)localObject);
          bhhr.k(paramQQAppInterface.getApp(), "wantWord", str);
          bhhr.B(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, j);
          return;
        }
        catch (Exception paramQQAppInterface)
        {
          paramQQAppInterface.printStackTrace();
          return;
        }
        paramConfig = paramConfig;
        QLog.d("SPLASH_ConfigServlet", 2, "handleBuluoConfig|uncompress failed");
        paramConfig = null;
        continue;
      }
      label206:
      paramConfig = paramConfig.content.get().toStringUtf8();
      continue;
      label226:
      paramConfig = null;
    }
  }
  
  void i(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    if (paramConfig.type.get() != 165) {}
    int j;
    do
    {
      int i;
      do
      {
        return;
        i = bhhr.ae(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
        j = paramConfig.version.get();
      } while ((i == j) || (paramConfig.msg_content_list == null) || (paramConfig.msg_content_list.size() <= 0));
      paramConfig = (ConfigurationService.Content)paramConfig.msg_content_list.get(0);
    } while (paramConfig == null);
    if (paramConfig.compress.get() == 1)
    {
      paramConfig = ayym.a(paramConfig.content.get().toByteArray());
      if (paramConfig == null) {
        break label194;
      }
    }
    for (;;)
    {
      try
      {
        paramConfig = new String(paramConfig, "UTF-8");
        if (paramConfig == null) {
          break;
        }
        try
        {
          boolean bool = new JSONObject(paramConfig).getBoolean("isShowBuluoNumRedDot");
          bhhr.D(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, j);
          bhhr.e(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, bool);
          return;
        }
        catch (Exception paramQQAppInterface)
        {
          paramQQAppInterface.printStackTrace();
          return;
        }
      }
      catch (Exception paramConfig)
      {
        QLog.d("SPLASH_ConfigServlet", 2, "handleBuluoConfig|uncompress failed");
        paramConfig = null;
        continue;
      }
      paramConfig = paramConfig.content.get().toStringUtf8();
      continue;
      label194:
      paramConfig = null;
    }
  }
  
  void j(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SPLASH_ConfigServlet", 2, "received PUBLIC_ACCOUNT_QQ_MAIL_CONFIG response");
    }
    for (;;)
    {
      int i;
      try
      {
        if ((paramConfig.msg_content_list != null) && (paramConfig.msg_content_list.size() > 0))
        {
          int j = paramConfig.version.get();
          int k = usu.c(paramQQAppInterface);
          if (j != k)
          {
            i = 0;
            if (i < paramConfig.msg_content_list.size())
            {
              Object localObject = (ConfigurationService.Content)paramConfig.msg_content_list.get(i);
              if (localObject != null)
              {
                if (((ConfigurationService.Content)localObject).compress.get() == 1)
                {
                  localObject = ayym.a(((ConfigurationService.Content)localObject).content.get().toByteArray());
                  if (localObject == null) {
                    break label310;
                  }
                  try
                  {
                    localObject = new String((byte[])localObject, "UTF-8");
                    if (QLog.isColorLevel()) {
                      QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 184, version:" + paramConfig.version.get() + ", content:" + (String)localObject);
                    }
                    usu.a(paramQQAppInterface, (String)localObject, j);
                  }
                  catch (Exception localException)
                  {
                    localException.printStackTrace();
                    break label310;
                  }
                }
                else
                {
                  str = localException.content.get().toStringUtf8();
                  continue;
                }
              }
              else if (QLog.isColorLevel()) {
                QLog.d("SPLASH_ConfigServlet", 2, "received PUBLIC_ACCOUNT_QQ_MAIL_CONFIG remote version: " + j + " | localVersion: " + k);
              }
            }
          }
        }
      }
      catch (Exception paramQQAppInterface)
      {
        if (QLog.isColorLevel()) {
          QLog.e("SPLASH_ConfigServlet", 2, "received PUBLIC_ACCOUNT_QQ_MAIL_CONFIG error", paramQQAppInterface);
        }
        paramQQAppInterface.printStackTrace();
      }
      while (!QLog.isColorLevel()) {
        return;
      }
      QLog.d("SPLASH_ConfigServlet", 2, "received PUBLIC_ACCOUNT_QQ_MAIL_CONFIG content_list is empty");
      return;
      i += 1;
      continue;
      label310:
      String str = null;
    }
  }
  
  /* Error */
  void k(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    // Byte code:
    //   0: aload_2
    //   1: getfield 2669	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:type	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   4: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   7: sipush 191
    //   10: if_icmpeq +4 -> 14
    //   13: return
    //   14: aload_1
    //   15: invokevirtual 65	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   18: getstatic 15	arph:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   21: invokestatic 2021	bhhr:ar	(Landroid/content/Context;Ljava/lang/String;)I
    //   24: istore_3
    //   25: aload_2
    //   26: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   29: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   32: istore 4
    //   34: iload 4
    //   36: iload_3
    //   37: if_icmpeq -24 -> 13
    //   40: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   43: ifeq +30 -> 73
    //   46: ldc 189
    //   48: iconst_2
    //   49: new 85	java/lang/StringBuilder
    //   52: dup
    //   53: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   56: ldc_w 5792
    //   59: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: iload 4
    //   64: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   67: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   70: invokestatic 206	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   73: aload_2
    //   74: getfield 234	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   77: ifnull -64 -> 13
    //   80: aload_2
    //   81: getfield 234	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   84: invokevirtual 237	com/tencent/mobileqq/pb/PBRepeatMessageField:size	()I
    //   87: ifle -74 -> 13
    //   90: aload_2
    //   91: getfield 234	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   94: iconst_0
    //   95: invokevirtual 330	com/tencent/mobileqq/pb/PBRepeatMessageField:get	(I)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   98: checkcast 257	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content
    //   101: astore_2
    //   102: aload_2
    //   103: ifnull -90 -> 13
    //   106: aload_2
    //   107: getfield 261	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content:compress	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   110: invokevirtual 264	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   113: iconst_1
    //   114: if_icmpne +349 -> 463
    //   117: aload_2
    //   118: getfield 268	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content:content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   121: invokevirtual 273	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   124: invokevirtual 279	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   127: invokestatic 333	ayym:a	([B)[B
    //   130: astore_2
    //   131: aload_2
    //   132: ifnull +442 -> 574
    //   135: new 118	java/lang/String
    //   138: dup
    //   139: aload_2
    //   140: ldc_w 335
    //   143: invokespecial 338	java/lang/String:<init>	([BLjava/lang/String;)V
    //   146: astore_2
    //   147: aload_2
    //   148: ifnull -135 -> 13
    //   151: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   154: ifeq +29 -> 183
    //   157: ldc 189
    //   159: iconst_2
    //   160: new 85	java/lang/StringBuilder
    //   163: dup
    //   164: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   167: ldc_w 5794
    //   170: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   173: aload_2
    //   174: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   180: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   183: new 128	org/json/JSONObject
    //   186: dup
    //   187: aload_2
    //   188: invokespecial 131	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   191: astore 5
    //   193: aload 5
    //   195: ifnull -182 -> 13
    //   198: aload 5
    //   200: invokevirtual 5795	org/json/JSONObject:length	()I
    //   203: ifle -190 -> 13
    //   206: new 1160	java/util/ArrayList
    //   209: dup
    //   210: invokespecial 1161	java/util/ArrayList:<init>	()V
    //   213: astore_2
    //   214: aload 5
    //   216: invokevirtual 5798	org/json/JSONObject:keys	()Ljava/util/Iterator;
    //   219: astore 6
    //   221: aload 6
    //   223: invokeinterface 251 1 0
    //   228: ifeq +310 -> 538
    //   231: aload 6
    //   233: invokeinterface 255 1 0
    //   238: checkcast 118	java/lang/String
    //   241: astore 7
    //   243: aload 5
    //   245: aload 7
    //   247: invokevirtual 754	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   250: astore 8
    //   252: new 5317	com/tencent/mobileqq/data/AppGuideTipsConfig
    //   255: dup
    //   256: invokespecial 5318	com/tencent/mobileqq/data/AppGuideTipsConfig:<init>	()V
    //   259: astore 9
    //   261: aload 9
    //   263: aload 7
    //   265: putfield 5801	com/tencent/mobileqq/data/AppGuideTipsConfig:tipsType	Ljava/lang/String;
    //   268: aload 9
    //   270: aload 8
    //   272: ldc_w 5326
    //   275: invokevirtual 433	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   278: putfield 5329	com/tencent/mobileqq/data/AppGuideTipsConfig:switchKey	Ljava/lang/String;
    //   281: aload 9
    //   283: aload 8
    //   285: ldc_w 5331
    //   288: invokevirtual 433	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   291: invokestatic 4538	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   294: invokevirtual 1895	java/lang/Integer:intValue	()I
    //   297: putfield 5334	com/tencent/mobileqq/data/AppGuideTipsConfig:maxCount	I
    //   300: aload 9
    //   302: aload 8
    //   304: ldc_w 5336
    //   307: invokevirtual 433	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   310: invokestatic 5256	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   313: invokevirtual 5259	java/lang/Long:longValue	()J
    //   316: putfield 5338	com/tencent/mobileqq/data/AppGuideTipsConfig:duration	J
    //   319: aload 9
    //   321: aload 8
    //   323: ldc_w 807
    //   326: invokevirtual 433	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   329: putfield 5343	com/tencent/mobileqq/data/AppGuideTipsConfig:tipsUrl	Ljava/lang/String;
    //   332: aload 9
    //   334: aload 8
    //   336: ldc_w 5803
    //   339: invokevirtual 433	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   342: putfield 5805	com/tencent/mobileqq/data/AppGuideTipsConfig:opkey	Ljava/lang/String;
    //   345: aload 9
    //   347: aload 8
    //   349: ldc_w 5348
    //   352: invokevirtual 433	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   355: putfield 5351	com/tencent/mobileqq/data/AppGuideTipsConfig:msgTypeStr	Ljava/lang/String;
    //   358: ldc_w 638
    //   361: aload 7
    //   363: invokevirtual 636	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   366: ifeq +143 -> 509
    //   369: aload 8
    //   371: ldc_w 1061
    //   374: invokevirtual 417	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   377: ifeq +100 -> 477
    //   380: aload 9
    //   382: aload 8
    //   384: ldc_w 1061
    //   387: invokevirtual 433	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   390: putfield 5346	com/tencent/mobileqq/data/AppGuideTipsConfig:tipsMsg	Ljava/lang/String;
    //   393: aload 8
    //   395: ldc_w 756
    //   398: invokevirtual 417	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   401: ifeq +92 -> 493
    //   404: aload 9
    //   406: aload 8
    //   408: ldc_w 756
    //   411: invokevirtual 433	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   414: putfield 5808	com/tencent/mobileqq/data/AppGuideTipsConfig:tipsHighLight	Ljava/lang/String;
    //   417: aload_2
    //   418: aload 9
    //   420: invokeinterface 1170 2 0
    //   425: pop
    //   426: goto -205 -> 221
    //   429: astore_1
    //   430: ldc 189
    //   432: iconst_1
    //   433: new 85	java/lang/StringBuilder
    //   436: dup
    //   437: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   440: ldc_w 5810
    //   443: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   446: aload_1
    //   447: invokevirtual 825	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   450: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   453: invokestatic 658	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   456: return
    //   457: astore_2
    //   458: aconst_null
    //   459: astore_2
    //   460: goto -313 -> 147
    //   463: aload_2
    //   464: getfield 268	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content:content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   467: invokevirtual 273	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   470: invokevirtual 293	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   473: astore_2
    //   474: goto -327 -> 147
    //   477: aload 9
    //   479: aload 8
    //   481: ldc_w 5812
    //   484: invokevirtual 433	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   487: putfield 5346	com/tencent/mobileqq/data/AppGuideTipsConfig:tipsMsg	Ljava/lang/String;
    //   490: goto -97 -> 393
    //   493: aload 9
    //   495: aload 8
    //   497: ldc_w 5814
    //   500: invokevirtual 433	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   503: putfield 5808	com/tencent/mobileqq/data/AppGuideTipsConfig:tipsHighLight	Ljava/lang/String;
    //   506: goto -89 -> 417
    //   509: aload 9
    //   511: aload 8
    //   513: ldc_w 5812
    //   516: invokevirtual 433	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   519: putfield 5346	com/tencent/mobileqq/data/AppGuideTipsConfig:tipsMsg	Ljava/lang/String;
    //   522: aload 9
    //   524: aload 8
    //   526: ldc_w 5814
    //   529: invokevirtual 433	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   532: putfield 5808	com/tencent/mobileqq/data/AppGuideTipsConfig:tipsHighLight	Ljava/lang/String;
    //   535: goto -118 -> 417
    //   538: aload_1
    //   539: getstatic 3448	com/tencent/mobileqq/app/QQManagerFactory:APP_GUIDE_TIPS_MANAGER	I
    //   542: invokevirtual 166	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   545: checkcast 3450	afpn
    //   548: astore 5
    //   550: aload 5
    //   552: aload_2
    //   553: invokevirtual 5815	afpn:a	(Ljava/util/List;)V
    //   556: aload 5
    //   558: invokevirtual 3451	afpn:a	()V
    //   561: aload_1
    //   562: invokevirtual 65	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   565: getstatic 15	arph:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   568: iload 4
    //   570: invokestatic 5817	bhhr:O	(Landroid/content/Context;Ljava/lang/String;I)V
    //   573: return
    //   574: aconst_null
    //   575: astore_2
    //   576: goto -429 -> 147
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	579	0	this	arph
    //   0	579	1	paramQQAppInterface	QQAppInterface
    //   0	579	2	paramConfig	ConfigurationService.Config
    //   24	14	3	i	int
    //   32	537	4	j	int
    //   191	366	5	localObject	Object
    //   219	13	6	localIterator	Iterator
    //   241	121	7	str	String
    //   250	275	8	localJSONObject	JSONObject
    //   259	264	9	localAppGuideTipsConfig	AppGuideTipsConfig
    // Exception table:
    //   from	to	target	type
    //   183	193	429	java/lang/Exception
    //   198	221	429	java/lang/Exception
    //   221	393	429	java/lang/Exception
    //   393	417	429	java/lang/Exception
    //   417	426	429	java/lang/Exception
    //   477	490	429	java/lang/Exception
    //   493	506	429	java/lang/Exception
    //   509	535	429	java/lang/Exception
    //   538	573	429	java/lang/Exception
    //   135	147	457	java/lang/Exception
  }
  
  void l(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    if (paramConfig.type.get() != 194) {
      return;
    }
    int i = bhhr.ac(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
    int j = paramConfig.version.get();
    if (QLog.isColorLevel()) {
      QLog.d("PobingSPLASH_ConfigServlet", 2, "handleTroopPobingConfig reqVersion=" + i + "version=" + j);
    }
    if (i != j)
    {
      if ((paramConfig.msg_content_list == null) || (paramConfig.msg_content_list.size() <= 0)) {
        break label399;
      }
      paramConfig = (ConfigurationService.Content)paramConfig.msg_content_list.get(0);
      if (paramConfig != null)
      {
        if (paramConfig.compress.get() != 1) {
          break label355;
        }
        paramConfig = ayym.a(paramConfig.content.get().toByteArray());
        if (paramConfig == null) {
          break label428;
        }
      }
    }
    for (;;)
    {
      try
      {
        paramConfig = new String(paramConfig, "UTF-8");
        if (paramConfig != null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("Pobing", 1, "handleTroopPobingConfig content" + paramConfig);
          }
          if (paramConfig == null) {}
        }
        try
        {
          Object localObject = new JSONObject(paramConfig);
          JSONArray localJSONArray = ((JSONObject)localObject).getJSONArray("left");
          localObject = ((JSONObject)localObject).getJSONArray("right");
          if (QLog.isColorLevel())
          {
            QLog.d("SPLASH_ConfigServlet", 1, "handleTroopPobingConfig content" + paramConfig + " left: " + localJSONArray);
            QLog.d("SPLASH_ConfigServlet", 1, "handleTroopPobingConfig content" + paramConfig + " right: " + localObject);
          }
          TroopManager.a(paramQQAppInterface, jdField_a_of_type_JavaLangString, localJSONArray, (JSONArray)localObject);
        }
        catch (Exception paramConfig)
        {
          QLog.e("SPLASH_ConfigServlet", 1, "handleTroopPobingConfig failed" + paramConfig);
          continue;
        }
        bhhr.A(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, j);
        return;
      }
      catch (Exception paramConfig)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PobingSPLASH_ConfigServlet", 2, "handleTroopPobingConfig|uncompress failed");
        }
        paramConfig = null;
        continue;
      }
      label355:
      paramConfig = paramConfig.content.get().toStringUtf8();
      continue;
      label399:
      paramConfig = new JSONArray();
      TroopManager.a(paramQQAppInterface, jdField_a_of_type_JavaLangString, paramConfig, paramConfig);
      QLog.i("SPLASH_ConfigServlet", 1, "handleTroopPobingConfig, empty config clear local");
      continue;
      label428:
      paramConfig = null;
    }
  }
  
  void m(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    if (paramConfig.type.get() != 181) {}
    int i;
    int j;
    do
    {
      do
      {
        do
        {
          return;
          i = bhhr.aj(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
          j = paramConfig.version.get();
          if (QLog.isColorLevel()) {
            QLog.d("DoutuSPLASH_ConfigServlet", 2, "handleDoutuConfig reqVersion = " + i + ", version=" + j);
          }
        } while (i == j);
        bhhr.J(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, j);
      } while ((paramConfig.msg_content_list == null) || (paramConfig.msg_content_list.size() <= 0));
      paramConfig = (ConfigurationService.Content)paramConfig.msg_content_list.get(0);
    } while (paramConfig == null);
    if (paramConfig.compress.get() == 1)
    {
      paramConfig = ayym.a(paramConfig.content.get().toByteArray());
      if (paramConfig == null) {
        break label1415;
      }
    }
    for (;;)
    {
      label318:
      label455:
      int k;
      label518:
      label577:
      String str1;
      label637:
      int m;
      try
      {
        for (;;)
        {
          paramConfig = new String(paramConfig, "UTF-8");
          if (paramConfig == null) {
            break label1254;
          }
          if (QLog.isColorLevel()) {
            QLog.d("Doutu", 1, "handleDoutuConfig content" + paramConfig);
          }
          try
          {
            Object localObject = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new ByteArrayInputStream(paramConfig.getBytes("utf-8")));
            paramConfig = ((Document)localObject).getElementsByTagName("doutu_config");
            if ((paramConfig == null) || (paramConfig.getLength() <= 0)) {
              break;
            }
            if ((((Document)localObject).getElementsByTagName("entry") == null) || (((Document)localObject).getElementsByTagName("entry").item(0) == null)) {
              break label1410;
            }
            i = Integer.parseInt(((Document)localObject).getElementsByTagName("entry").item(0).getFirstChild().getNodeValue());
            l2 = 0L;
            l1 = l2;
            if (((Document)localObject).getElementsByTagName("timeGap") != null)
            {
              l1 = l2;
              if (((Document)localObject).getElementsByTagName("timeGap").item(0) != null) {
                l1 = Long.parseLong(((Document)localObject).getElementsByTagName("timeGap").item(0).getFirstChild().getNodeValue());
              }
            }
            if ((((Document)localObject).getElementsByTagName("duiTimes") == null) || (((Document)localObject).getElementsByTagName("duiTimes").item(0) == null)) {
              break label1404;
            }
            j = Integer.parseInt(((Document)localObject).getElementsByTagName("duiTimes").item(0).getFirstChild().getNodeValue());
            if ((((Document)localObject).getElementsByTagName("entryCombo") == null) || (((Document)localObject).getElementsByTagName("entryCombo").item(0) == null)) {
              break label1398;
            }
            k = Integer.parseInt(((Document)localObject).getElementsByTagName("entryCombo").item(0).getFirstChild().getNodeValue());
            if ((((Document)localObject).getElementsByTagName("resUrl") == null) || (((Document)localObject).getElementsByTagName("resUrl").item(0) == null)) {
              break label1393;
            }
            paramConfig = ((Document)localObject).getElementsByTagName("resUrl").item(0).getFirstChild().getNodeValue();
            if ((((Document)localObject).getElementsByTagName("resMd5") == null) || (((Document)localObject).getElementsByTagName("resMd5").item(0) == null)) {
              break label1387;
            }
            str1 = ((Document)localObject).getElementsByTagName("resMd5").item(0).getFirstChild().getNodeValue();
            l3 = 0L;
            l2 = l3;
            if (((Document)localObject).getElementsByTagName("comboDuration") != null)
            {
              l2 = l3;
              if (((Document)localObject).getElementsByTagName("comboDuration").item(0) != null) {
                l2 = Long.parseLong(((Document)localObject).getElementsByTagName("comboDuration").item(0).getFirstChild().getNodeValue());
              }
            }
            long l4 = 0L;
            l3 = l4;
            if (((Document)localObject).getElementsByTagName("comboKeep") != null)
            {
              l3 = l4;
              if (((Document)localObject).getElementsByTagName("comboKeep").item(0) != null) {
                l3 = Long.parseLong(((Document)localObject).getElementsByTagName("comboKeep").item(0).getFirstChild().getNodeValue());
              }
            }
            if ((((Document)localObject).getElementsByTagName("recommendSwitch") == null) || (((Document)localObject).getElementsByTagName("recommendSwitch").item(0) == null)) {
              break label1381;
            }
            m = Integer.parseInt(((Document)localObject).getElementsByTagName("recommendSwitch").item(0).getFirstChild().getNodeValue());
            label848:
            int i1 = 0;
            n = i1;
            if (((Document)localObject).getElementsByTagName("smartHeadPicCount") != null)
            {
              n = i1;
              if (((Document)localObject).getElementsByTagName("smartHeadPicCount").item(0) != null) {
                n = Integer.parseInt(((Document)localObject).getElementsByTagName("smartHeadPicCount").item(0).getFirstChild().getNodeValue());
              }
            }
            localObject = paramQQAppInterface.getApp();
            String str2 = jdField_a_of_type_JavaLangString;
            if (i != 1) {
              break label1218;
            }
            bool1 = true;
            bhhr.g((Context)localObject, str2, bool1);
            bhhr.b(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, l1);
            bhhr.N(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, j);
            localObject = paramQQAppInterface.getApp();
            str2 = jdField_a_of_type_JavaLangString;
            if (k != 1) {
              break label1224;
            }
            bool1 = true;
            bhhr.i((Context)localObject, str2, bool1);
            localObject = paramQQAppInterface.getApp();
            str2 = jdField_a_of_type_JavaLangString;
            if (m != 1) {
              break label1230;
            }
            bool1 = true;
            bhhr.j((Context)localObject, str2, bool1);
            if (paramConfig != null) {
              bhhr.o(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, paramConfig);
            }
            if (str1 != null) {
              bhhr.p(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, str1);
            }
            bhhr.c(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, l2);
            bhhr.d(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, l3);
            bhhr.L(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, n);
            paramQQAppInterface = (asaa)getAppRuntime().getManager(QQManagerFactory.DOUTU_MAGAGER);
            if (paramQQAppInterface == null) {
              break;
            }
            if (i != 1) {
              break label1236;
            }
            bool1 = true;
          }
          catch (Exception paramQQAppInterface)
          {
            long l2;
            long l1;
            long l3;
            int n;
            label1129:
            QLog.e("HotPicManager", 1, "handleDoutuConfig failed" + paramQQAppInterface);
            return;
          }
        }
        paramQQAppInterface.a(bool1, bool2, l1, l2, l3, bool3, n);
        paramQQAppInterface.b(true);
        return;
      }
      catch (Exception paramConfig)
      {
        if (QLog.isColorLevel()) {
          QLog.d("DoutuSPLASH_ConfigServlet", 2, "handleDoutuConfig|uncompress failed");
        }
        paramConfig = null;
        continue;
      }
      paramConfig = paramConfig.content.get().toStringUtf8();
      continue;
      label1218:
      boolean bool1 = false;
      continue;
      label1224:
      bool1 = false;
      continue;
      label1230:
      bool1 = false;
      continue;
      label1236:
      bool1 = false;
      label1242:
      for (boolean bool2 = false; m != 1; bool2 = true)
      {
        bool3 = false;
        break label1129;
        label1254:
        if (QLog.isColorLevel()) {
          QLog.d("Doutu", 1, "handleDoutuConfig content is null");
        }
        bhhr.k(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
        bhhr.r(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
        bhhr.l(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
        bhhr.m(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
        bhhr.o(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
        bhhr.p(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
        bhhr.t(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
        bhhr.u(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
        bhhr.n(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
        bhhr.m(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
        bhhr.s(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
        return;
        label1381:
        m = 0;
        break label848;
        label1387:
        str1 = null;
        break label637;
        label1393:
        paramConfig = null;
        break label577;
        label1398:
        k = 0;
        break label518;
        label1404:
        j = 0;
        break label455;
        i = 0;
        break label318;
        paramConfig = null;
        break;
        if (k != 1) {
          break label1242;
        }
      }
      label1410:
      label1415:
      boolean bool3 = true;
    }
  }
  
  void n(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    if (paramConfig.type.get() != 247) {}
    do
    {
      do
      {
        int i;
        int j;
        do
        {
          return;
          i = bhhr.t(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
          j = paramConfig.version.get();
          if (QLog.isColorLevel()) {
            QLog.d("GreenVideoSPLASH_ConfigServlet", 2, "handleGreenVideoConfig reqVersion = " + i + ", version=" + j);
          }
        } while (i == j);
        bhhr.f(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, j);
      } while ((paramConfig.msg_content_list == null) || (paramConfig.msg_content_list.size() <= 0));
      paramConfig = (ConfigurationService.Content)paramConfig.msg_content_list.get(0);
    } while (paramConfig == null);
    if (paramConfig.compress.get() == 1)
    {
      paramConfig = ayym.a(paramConfig.content.get().toByteArray());
      if (paramConfig == null) {
        break label276;
      }
    }
    for (;;)
    {
      try
      {
        paramConfig = new String(paramConfig, "UTF-8");
        if (paramConfig == null) {
          break label252;
        }
        if (QLog.isColorLevel()) {
          QLog.d("GreenVideo", 1, "handleGreenVideoConfig content : " + paramConfig);
        }
        bhhr.e(paramQQAppInterface.getApp(), paramConfig);
        return;
      }
      catch (Exception paramConfig)
      {
        if (QLog.isColorLevel()) {
          QLog.d("GreenVideoSPLASH_ConfigServlet", 2, "handleGreenVideoConfig|uncompress failed");
        }
        paramConfig = null;
        continue;
      }
      paramConfig = paramConfig.content.get().toStringUtf8();
      continue;
      label252:
      if (QLog.isColorLevel()) {
        QLog.d("GreenVideo", 1, "handleGreenVideoConfig content is null");
      }
      bhhr.a(paramQQAppInterface.getApp());
      return;
      label276:
      paramConfig = null;
    }
  }
  
  /* Error */
  void o(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    // Byte code:
    //   0: aload_2
    //   1: getfield 2669	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:type	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   4: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   7: sipush 272
    //   10: if_icmpeq +4 -> 14
    //   13: return
    //   14: aload_1
    //   15: invokevirtual 65	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   18: getstatic 15	arph:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   21: invokestatic 1989	bhhr:v	(Landroid/content/Context;Ljava/lang/String;)I
    //   24: istore_3
    //   25: aload_2
    //   26: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   29: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   32: istore 4
    //   34: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   37: ifeq +40 -> 77
    //   40: ldc 189
    //   42: iconst_2
    //   43: new 85	java/lang/StringBuilder
    //   46: dup
    //   47: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   50: ldc_w 5947
    //   53: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: iload_3
    //   57: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   60: ldc_w 5851
    //   63: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: iload 4
    //   68: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   71: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   74: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   77: iload_3
    //   78: iload 4
    //   80: if_icmpeq -67 -> 13
    //   83: aload_1
    //   84: invokevirtual 65	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   87: getstatic 15	arph:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   90: iload 4
    //   92: invokestatic 1978	bhhr:h	(Landroid/content/Context;Ljava/lang/String;I)V
    //   95: aload_2
    //   96: getfield 234	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   99: ifnull -86 -> 13
    //   102: aload_2
    //   103: getfield 234	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   106: invokevirtual 237	com/tencent/mobileqq/pb/PBRepeatMessageField:size	()I
    //   109: ifle -96 -> 13
    //   112: aload_2
    //   113: getfield 234	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   116: iconst_0
    //   117: invokevirtual 330	com/tencent/mobileqq/pb/PBRepeatMessageField:get	(I)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   120: checkcast 257	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content
    //   123: astore_2
    //   124: aload_2
    //   125: ifnull -112 -> 13
    //   128: aload_2
    //   129: getfield 261	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content:compress	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   132: invokevirtual 264	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   135: iconst_1
    //   136: if_icmpne +716 -> 852
    //   139: aload_2
    //   140: getfield 268	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content:content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   143: invokevirtual 273	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   146: invokevirtual 279	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   149: invokestatic 333	ayym:a	([B)[B
    //   152: astore_2
    //   153: aload_2
    //   154: ifnull +782 -> 936
    //   157: new 118	java/lang/String
    //   160: dup
    //   161: aload_2
    //   162: ldc_w 335
    //   165: invokespecial 338	java/lang/String:<init>	([BLjava/lang/String;)V
    //   168: astore_2
    //   169: aload_2
    //   170: ifnull +696 -> 866
    //   173: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   176: ifeq +29 -> 205
    //   179: ldc 189
    //   181: iconst_2
    //   182: new 85	java/lang/StringBuilder
    //   185: dup
    //   186: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   189: ldc_w 5949
    //   192: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   195: aload_2
    //   196: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   199: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   202: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   205: invokestatic 949	javax/xml/parsers/DocumentBuilderFactory:newInstance	()Ljavax/xml/parsers/DocumentBuilderFactory;
    //   208: invokevirtual 953	javax/xml/parsers/DocumentBuilderFactory:newDocumentBuilder	()Ljavax/xml/parsers/DocumentBuilder;
    //   211: new 955	java/io/ByteArrayInputStream
    //   214: dup
    //   215: aload_2
    //   216: ldc_w 957
    //   219: invokevirtual 961	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   222: invokespecial 962	java/io/ByteArrayInputStream:<init>	([B)V
    //   225: invokevirtual 967	javax/xml/parsers/DocumentBuilder:parse	(Ljava/io/InputStream;)Lorg/w3c/dom/Document;
    //   228: astore_2
    //   229: aload_2
    //   230: ldc_w 5951
    //   233: invokeinterface 975 2 0
    //   238: astore 5
    //   240: aload 5
    //   242: ifnull -229 -> 13
    //   245: aload 5
    //   247: invokeinterface 980 1 0
    //   252: ifle -239 -> 13
    //   255: new 85	java/lang/StringBuilder
    //   258: dup
    //   259: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   262: astore 5
    //   264: aload_2
    //   265: ldc_w 5953
    //   268: invokeinterface 975 2 0
    //   273: ifnull +42 -> 315
    //   276: aload 5
    //   278: aload_2
    //   279: ldc_w 5953
    //   282: invokeinterface 975 2 0
    //   287: iconst_0
    //   288: invokeinterface 986 2 0
    //   293: invokeinterface 992 1 0
    //   298: invokeinterface 995 1 0
    //   303: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   306: pop
    //   307: aload 5
    //   309: bipush 124
    //   311: invokevirtual 1093	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   314: pop
    //   315: aload_2
    //   316: ldc_w 5955
    //   319: invokeinterface 975 2 0
    //   324: ifnull +42 -> 366
    //   327: aload 5
    //   329: aload_2
    //   330: ldc_w 5955
    //   333: invokeinterface 975 2 0
    //   338: iconst_0
    //   339: invokeinterface 986 2 0
    //   344: invokeinterface 992 1 0
    //   349: invokeinterface 995 1 0
    //   354: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   357: pop
    //   358: aload 5
    //   360: bipush 124
    //   362: invokevirtual 1093	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   365: pop
    //   366: aload_2
    //   367: ldc_w 5957
    //   370: invokeinterface 975 2 0
    //   375: ifnull +42 -> 417
    //   378: aload 5
    //   380: aload_2
    //   381: ldc_w 5957
    //   384: invokeinterface 975 2 0
    //   389: iconst_0
    //   390: invokeinterface 986 2 0
    //   395: invokeinterface 992 1 0
    //   400: invokeinterface 995 1 0
    //   405: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   408: pop
    //   409: aload 5
    //   411: bipush 124
    //   413: invokevirtual 1093	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   416: pop
    //   417: aload_2
    //   418: ldc_w 5959
    //   421: invokeinterface 975 2 0
    //   426: ifnull +42 -> 468
    //   429: aload 5
    //   431: aload_2
    //   432: ldc_w 5959
    //   435: invokeinterface 975 2 0
    //   440: iconst_0
    //   441: invokeinterface 986 2 0
    //   446: invokeinterface 992 1 0
    //   451: invokeinterface 995 1 0
    //   456: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   459: pop
    //   460: aload 5
    //   462: bipush 124
    //   464: invokevirtual 1093	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   467: pop
    //   468: aload_2
    //   469: ldc_w 5961
    //   472: invokeinterface 975 2 0
    //   477: ifnull +42 -> 519
    //   480: aload 5
    //   482: aload_2
    //   483: ldc_w 5961
    //   486: invokeinterface 975 2 0
    //   491: iconst_0
    //   492: invokeinterface 986 2 0
    //   497: invokeinterface 992 1 0
    //   502: invokeinterface 995 1 0
    //   507: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   510: pop
    //   511: aload 5
    //   513: bipush 124
    //   515: invokevirtual 1093	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   518: pop
    //   519: aload_2
    //   520: ldc_w 5963
    //   523: invokeinterface 975 2 0
    //   528: ifnull +60 -> 588
    //   531: aload_2
    //   532: ldc_w 5963
    //   535: invokeinterface 975 2 0
    //   540: iconst_0
    //   541: invokeinterface 986 2 0
    //   546: ifnull +42 -> 588
    //   549: aload 5
    //   551: aload_2
    //   552: ldc_w 5963
    //   555: invokeinterface 975 2 0
    //   560: iconst_0
    //   561: invokeinterface 986 2 0
    //   566: invokeinterface 992 1 0
    //   571: invokeinterface 995 1 0
    //   576: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   579: pop
    //   580: aload 5
    //   582: bipush 124
    //   584: invokevirtual 1093	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   587: pop
    //   588: aload_2
    //   589: ldc_w 5965
    //   592: invokeinterface 975 2 0
    //   597: ifnull +60 -> 657
    //   600: aload_2
    //   601: ldc_w 5965
    //   604: invokeinterface 975 2 0
    //   609: iconst_0
    //   610: invokeinterface 986 2 0
    //   615: ifnull +42 -> 657
    //   618: aload 5
    //   620: aload_2
    //   621: ldc_w 5965
    //   624: invokeinterface 975 2 0
    //   629: iconst_0
    //   630: invokeinterface 986 2 0
    //   635: invokeinterface 992 1 0
    //   640: invokeinterface 995 1 0
    //   645: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   648: pop
    //   649: aload 5
    //   651: bipush 124
    //   653: invokevirtual 1093	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   656: pop
    //   657: aload_2
    //   658: ldc_w 5967
    //   661: invokeinterface 975 2 0
    //   666: ifnull +60 -> 726
    //   669: aload_2
    //   670: ldc_w 5967
    //   673: invokeinterface 975 2 0
    //   678: iconst_0
    //   679: invokeinterface 986 2 0
    //   684: ifnull +42 -> 726
    //   687: aload 5
    //   689: aload_2
    //   690: ldc_w 5967
    //   693: invokeinterface 975 2 0
    //   698: iconst_0
    //   699: invokeinterface 986 2 0
    //   704: invokeinterface 992 1 0
    //   709: invokeinterface 995 1 0
    //   714: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   717: pop
    //   718: aload 5
    //   720: bipush 124
    //   722: invokevirtual 1093	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   725: pop
    //   726: aload_2
    //   727: ldc_w 5969
    //   730: invokeinterface 975 2 0
    //   735: ifnull +52 -> 787
    //   738: aload_2
    //   739: ldc_w 5969
    //   742: invokeinterface 975 2 0
    //   747: iconst_0
    //   748: invokeinterface 986 2 0
    //   753: ifnull +34 -> 787
    //   756: aload 5
    //   758: aload_2
    //   759: ldc_w 5969
    //   762: invokeinterface 975 2 0
    //   767: iconst_0
    //   768: invokeinterface 986 2 0
    //   773: invokeinterface 992 1 0
    //   778: invokeinterface 995 1 0
    //   783: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   786: pop
    //   787: aload_1
    //   788: invokevirtual 65	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   791: getstatic 15	arph:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   794: aload 5
    //   796: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   799: invokestatic 5971	bhhr:q	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    //   802: return
    //   803: astore_1
    //   804: ldc 189
    //   806: iconst_1
    //   807: new 85	java/lang/StringBuilder
    //   810: dup
    //   811: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   814: ldc_w 5973
    //   817: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   820: aload_1
    //   821: invokevirtual 825	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   824: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   827: invokestatic 658	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   830: return
    //   831: astore_2
    //   832: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   835: ifeq +12 -> 847
    //   838: ldc 189
    //   840: iconst_2
    //   841: ldc_w 5975
    //   844: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   847: aconst_null
    //   848: astore_2
    //   849: goto -680 -> 169
    //   852: aload_2
    //   853: getfield 268	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content:content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   856: invokevirtual 273	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   859: invokevirtual 293	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   862: astore_2
    //   863: goto -694 -> 169
    //   866: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   869: ifeq +12 -> 881
    //   872: ldc 189
    //   874: iconst_2
    //   875: ldc_w 5977
    //   878: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   881: aload_1
    //   882: invokevirtual 65	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   885: getstatic 15	arph:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   888: invokestatic 5979	bhhr:q	(Landroid/content/Context;Ljava/lang/String;)V
    //   891: return
    //   892: astore_2
    //   893: goto -106 -> 787
    //   896: astore 6
    //   898: goto -172 -> 726
    //   901: astore 6
    //   903: goto -246 -> 657
    //   906: astore 6
    //   908: goto -320 -> 588
    //   911: astore 6
    //   913: goto -394 -> 519
    //   916: astore 6
    //   918: goto -450 -> 468
    //   921: astore 6
    //   923: goto -506 -> 417
    //   926: astore 6
    //   928: goto -562 -> 366
    //   931: astore 6
    //   933: goto -618 -> 315
    //   936: aconst_null
    //   937: astore_2
    //   938: goto -769 -> 169
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	941	0	this	arph
    //   0	941	1	paramQQAppInterface	QQAppInterface
    //   0	941	2	paramConfig	ConfigurationService.Config
    //   24	57	3	i	int
    //   32	59	4	j	int
    //   238	557	5	localObject	Object
    //   896	1	6	localThrowable1	Throwable
    //   901	1	6	localThrowable2	Throwable
    //   906	1	6	localThrowable3	Throwable
    //   911	1	6	localThrowable4	Throwable
    //   916	1	6	localThrowable5	Throwable
    //   921	1	6	localThrowable6	Throwable
    //   926	1	6	localThrowable7	Throwable
    //   931	1	6	localThrowable8	Throwable
    // Exception table:
    //   from	to	target	type
    //   205	240	803	java/lang/Exception
    //   245	264	803	java/lang/Exception
    //   264	315	803	java/lang/Exception
    //   315	366	803	java/lang/Exception
    //   366	417	803	java/lang/Exception
    //   417	468	803	java/lang/Exception
    //   468	519	803	java/lang/Exception
    //   519	588	803	java/lang/Exception
    //   588	657	803	java/lang/Exception
    //   657	726	803	java/lang/Exception
    //   726	787	803	java/lang/Exception
    //   787	802	803	java/lang/Exception
    //   157	169	831	java/lang/Exception
    //   726	787	892	java/lang/Throwable
    //   657	726	896	java/lang/Throwable
    //   588	657	901	java/lang/Throwable
    //   519	588	906	java/lang/Throwable
    //   468	519	911	java/lang/Throwable
    //   417	468	916	java/lang/Throwable
    //   366	417	921	java/lang/Throwable
    //   315	366	926	java/lang/Throwable
    //   264	315	931	java/lang/Throwable
  }
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    int j = 0;
    QQAppInterface localQQAppInterface = (QQAppInterface)getAppRuntime();
    int[] arrayOfInt = paramIntent.getIntArrayExtra("k_cmd_type");
    boolean bool = paramFromServiceMsg.isSuccess();
    if ((arrayOfInt == null) || (arrayOfInt.length == 0)) {}
    for (;;)
    {
      return;
      int i;
      if (QLog.isColorLevel())
      {
        i = 0;
        while (i < arrayOfInt.length)
        {
          QLog.i("SPLASH_ConfigServlet", 2, "onReceive|shouldReceive cmd: " + arrayOfInt[i] + ",length: " + arrayOfInt.length);
          i += 1;
        }
      }
      Object localObject = paramFromServiceMsg.getWupBuffer();
      if ((localObject == null) || (localObject.length < 4))
      {
        if (QLog.isColorLevel()) {
          QLog.d("SPLASH_ConfigServlet", 2, "wup buf is null!!!");
        }
        arpl.a("0", arrayOfInt, paramFromServiceMsg.getResultCode());
        bdgq.a(arrayOfInt, paramFromServiceMsg);
        int k = arrayOfInt.length;
        i = j;
        while (i < k)
        {
          if (arrayOfInt[i] == 215)
          {
            ShortVideoResourceManager.a(-5);
            bnrh.d("SPLASH_ConfigServlet", "【SHORT_VIDEO_RESOURCE_CONFIG】RES_OVERTIME");
          }
          i += 1;
        }
      }
      else
      {
        paramFromServiceMsg.putWupBuffer(a((byte[])localObject));
        localObject = new ConfigurationService.RespGetConfig();
        try
        {
          ((ConfigurationService.RespGetConfig)localObject).mergeFrom(paramFromServiceMsg.getWupBuffer());
          try
          {
            acma.a(((ConfigurationService.RespGetConfig)localObject).min_req_interval_for_reconnect.get());
            a((ConfigurationService.RespGetConfig)localObject, localQQAppInterface, paramIntent, arrayOfInt, bool);
            return;
          }
          catch (Exception paramIntent) {}
          if (QLog.isColorLevel())
          {
            QLog.w("SPLASH_ConfigServlet", 2, paramIntent.toString());
            return;
          }
        }
        catch (InvalidProtocolBufferMicroException paramIntent)
        {
          if (QLog.isColorLevel()) {
            QLog.d("SPLASH_ConfigServlet", 2, "error: " + paramIntent.toString());
          }
          paramIntent.printStackTrace();
        }
      }
    }
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)getAppRuntime();
    int[] arrayOfInt = paramIntent.getIntArrayExtra("k_cmd_type");
    if ((arrayOfInt == null) || (arrayOfInt.length == 0)) {
      return;
    }
    if (QLog.isColorLevel())
    {
      int i = 0;
      while (i < arrayOfInt.length)
      {
        QLog.i("SPLASH_ConfigServlet", 2, "onSend. cmd: " + arrayOfInt[i] + ",length: " + arrayOfInt.length);
        i += 1;
      }
    }
    a(localQQAppInterface, paramIntent, arrayOfInt, paramPacket);
  }
  
  /* Error */
  void p(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 2008	bdtt:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)I
    //   4: istore 4
    //   6: aload_2
    //   7: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   10: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   13: istore_3
    //   14: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   17: ifeq +40 -> 57
    //   20: ldc 189
    //   22: iconst_2
    //   23: new 85	java/lang/StringBuilder
    //   26: dup
    //   27: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   30: ldc_w 6044
    //   33: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: iload 4
    //   38: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   41: ldc_w 6046
    //   44: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: iload_3
    //   48: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   51: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   54: invokestatic 206	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   57: iload 4
    //   59: iload_3
    //   60: if_icmpeq +158 -> 218
    //   63: aload_1
    //   64: getstatic 6049	com/tencent/mobileqq/app/QQManagerFactory:STT_MANAGER	I
    //   67: invokevirtual 166	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   70: checkcast 2007	bdtt
    //   73: astore 5
    //   75: aload_2
    //   76: getfield 234	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   79: ifnull +216 -> 295
    //   82: aload_2
    //   83: getfield 234	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   86: invokevirtual 237	com/tencent/mobileqq/pb/PBRepeatMessageField:size	()I
    //   89: ifle +206 -> 295
    //   92: aload_2
    //   93: getfield 234	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   96: iconst_0
    //   97: invokevirtual 330	com/tencent/mobileqq/pb/PBRepeatMessageField:get	(I)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   100: checkcast 257	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content
    //   103: astore_2
    //   104: aload_2
    //   105: ifnull +108 -> 213
    //   108: aload_2
    //   109: getfield 261	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content:compress	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   112: invokevirtual 264	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   115: iconst_1
    //   116: if_icmpne +135 -> 251
    //   119: aload_2
    //   120: getfield 268	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content:content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   123: invokevirtual 273	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   126: invokevirtual 279	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   129: invokestatic 333	ayym:a	([B)[B
    //   132: astore_2
    //   133: aload_2
    //   134: ifnull +179 -> 313
    //   137: new 118	java/lang/String
    //   140: dup
    //   141: aload_2
    //   142: ldc_w 335
    //   145: invokespecial 338	java/lang/String:<init>	([BLjava/lang/String;)V
    //   148: astore_2
    //   149: aload_2
    //   150: ifnull +63 -> 213
    //   153: new 128	org/json/JSONObject
    //   156: dup
    //   157: aload_2
    //   158: invokespecial 131	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   161: ldc_w 6051
    //   164: invokevirtual 420	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   167: istore 4
    //   169: aload 5
    //   171: iload 4
    //   173: invokevirtual 6052	bdtt:a	(I)V
    //   176: ldc 189
    //   178: iconst_1
    //   179: new 85	java/lang/StringBuilder
    //   182: dup
    //   183: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   186: ldc_w 6054
    //   189: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   192: aload_2
    //   193: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   196: ldc_w 6056
    //   199: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   202: iload 4
    //   204: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   207: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   210: invokestatic 206	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   213: aload_1
    //   214: iload_3
    //   215: invokestatic 6057	bdtt:a	(Lcom/tencent/mobileqq/app/QQAppInterface;I)V
    //   218: return
    //   219: astore_2
    //   220: ldc 189
    //   222: iconst_1
    //   223: new 85	java/lang/StringBuilder
    //   226: dup
    //   227: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   230: ldc_w 6059
    //   233: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   236: aload_2
    //   237: invokevirtual 825	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   240: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   243: invokestatic 658	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   246: aconst_null
    //   247: astore_2
    //   248: goto -99 -> 149
    //   251: aload_2
    //   252: getfield 268	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content:content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   255: invokevirtual 273	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   258: invokevirtual 293	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   261: astore_2
    //   262: goto -113 -> 149
    //   265: astore_2
    //   266: ldc 189
    //   268: iconst_1
    //   269: new 85	java/lang/StringBuilder
    //   272: dup
    //   273: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   276: ldc_w 6061
    //   279: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   282: aload_2
    //   283: invokevirtual 825	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   286: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   289: invokestatic 658	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   292: goto -79 -> 213
    //   295: ldc 189
    //   297: iconst_1
    //   298: ldc_w 6063
    //   301: invokestatic 206	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   304: aload 5
    //   306: iconst_0
    //   307: invokevirtual 6052	bdtt:a	(I)V
    //   310: goto -97 -> 213
    //   313: aconst_null
    //   314: astore_2
    //   315: goto -166 -> 149
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	318	0	this	arph
    //   0	318	1	paramQQAppInterface	QQAppInterface
    //   0	318	2	paramConfig	ConfigurationService.Config
    //   13	202	3	i	int
    //   4	199	4	j	int
    //   73	232	5	localbdtt	bdtt
    // Exception table:
    //   from	to	target	type
    //   137	149	219	java/lang/Exception
    //   153	213	265	java/lang/Exception
  }
  
  /* Error */
  protected void q(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: getstatic 15	arph:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   6: ldc_w 1998
    //   9: iconst_0
    //   10: invokestatic 318	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   13: invokestatic 1996	axqc:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   16: checkcast 139	java/lang/Integer
    //   19: invokevirtual 1895	java/lang/Integer:intValue	()I
    //   22: istore 5
    //   24: aload_2
    //   25: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   28: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   31: istore 6
    //   33: new 85	java/lang/StringBuilder
    //   36: dup
    //   37: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   40: ldc_w 6065
    //   43: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: iload 5
    //   48: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   51: ldc_w 6046
    //   54: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: iload 6
    //   59: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   62: ldc_w 6067
    //   65: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: astore 7
    //   70: aload_2
    //   71: getfield 234	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   74: ifnonnull +109 -> 183
    //   77: iconst_0
    //   78: istore_3
    //   79: ldc_w 6069
    //   82: iconst_1
    //   83: aload 7
    //   85: iload_3
    //   86: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   89: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   92: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   95: iload 5
    //   97: iload 6
    //   99: if_icmpeq +621 -> 720
    //   102: aload_2
    //   103: getfield 234	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   106: ifnull +614 -> 720
    //   109: aload_2
    //   110: getfield 234	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   113: invokevirtual 237	com/tencent/mobileqq/pb/PBRepeatMessageField:size	()I
    //   116: ifle +604 -> 720
    //   119: iload 4
    //   121: istore_3
    //   122: iload_3
    //   123: aload_2
    //   124: getfield 234	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   127: invokevirtual 237	com/tencent/mobileqq/pb/PBRepeatMessageField:size	()I
    //   130: if_icmpge +64 -> 194
    //   133: ldc_w 6069
    //   136: iconst_1
    //   137: new 85	java/lang/StringBuilder
    //   140: dup
    //   141: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   144: ldc_w 6071
    //   147: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: aload_2
    //   151: getfield 234	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   154: iload_3
    //   155: invokevirtual 330	com/tencent/mobileqq/pb/PBRepeatMessageField:get	(I)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   158: checkcast 257	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content
    //   161: getfield 3996	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content:task_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   164: invokevirtual 264	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   167: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   170: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   173: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   176: iload_3
    //   177: iconst_1
    //   178: iadd
    //   179: istore_3
    //   180: goto -58 -> 122
    //   183: aload_2
    //   184: getfield 234	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   187: invokevirtual 237	com/tencent/mobileqq/pb/PBRepeatMessageField:size	()I
    //   190: istore_3
    //   191: goto -112 -> 79
    //   194: aload_2
    //   195: getfield 234	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   198: iconst_0
    //   199: invokevirtual 330	com/tencent/mobileqq/pb/PBRepeatMessageField:get	(I)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   202: checkcast 257	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content
    //   205: astore 7
    //   207: aload 7
    //   209: ifnull +511 -> 720
    //   212: aload 7
    //   214: getfield 261	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content:compress	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   217: invokevirtual 264	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   220: iconst_1
    //   221: if_icmpne +536 -> 757
    //   224: aload 7
    //   226: getfield 268	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content:content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   229: invokevirtual 273	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   232: invokevirtual 279	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   235: invokestatic 333	ayym:a	([B)[B
    //   238: astore 7
    //   240: aload 7
    //   242: ifnull +588 -> 830
    //   245: new 118	java/lang/String
    //   248: dup
    //   249: aload 7
    //   251: ldc_w 335
    //   254: invokespecial 338	java/lang/String:<init>	([BLjava/lang/String;)V
    //   257: astore 7
    //   259: aload 7
    //   261: ifnull +459 -> 720
    //   264: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   267: ifeq +31 -> 298
    //   270: ldc_w 6069
    //   273: iconst_1
    //   274: new 85	java/lang/StringBuilder
    //   277: dup
    //   278: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   281: ldc_w 6073
    //   284: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   287: aload 7
    //   289: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   292: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   295: invokestatic 206	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   298: new 128	org/json/JSONObject
    //   301: dup
    //   302: aload 7
    //   304: invokespecial 131	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   307: astore 7
    //   309: aload 7
    //   311: ldc_w 6075
    //   314: invokevirtual 6078	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   317: astore 8
    //   319: aload 8
    //   321: invokevirtual 533	org/json/JSONArray:length	()I
    //   324: ifle +18 -> 342
    //   327: getstatic 15	arph:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   330: ldc_w 6080
    //   333: aload 8
    //   335: invokevirtual 6081	org/json/JSONArray:toString	()Ljava/lang/String;
    //   338: invokestatic 2001	axqc:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)Z
    //   341: pop
    //   342: aload 7
    //   344: ldc_w 6083
    //   347: invokevirtual 754	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   350: astore 8
    //   352: aload 8
    //   354: ifnull +18 -> 372
    //   357: getstatic 15	arph:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   360: ldc_w 6085
    //   363: aload 8
    //   365: invokevirtual 6086	org/json/JSONObject:toString	()Ljava/lang/String;
    //   368: invokestatic 2001	axqc:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)Z
    //   371: pop
    //   372: aload 7
    //   374: ldc_w 6088
    //   377: invokevirtual 487	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   380: istore_3
    //   381: aload 8
    //   383: ifnull +17 -> 400
    //   386: getstatic 15	arph:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   389: ldc_w 6090
    //   392: iload_3
    //   393: invokestatic 318	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   396: invokestatic 2001	axqc:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)Z
    //   399: pop
    //   400: aload 7
    //   402: ldc_w 6092
    //   405: invokevirtual 754	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   408: astore 8
    //   410: aload 8
    //   412: ifnull +76 -> 488
    //   415: aload 8
    //   417: ldc_w 6094
    //   420: invokevirtual 487	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   423: istore_3
    //   424: aload 8
    //   426: ldc_w 6096
    //   429: invokevirtual 487	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   432: istore 4
    //   434: aload 8
    //   436: ldc_w 6098
    //   439: invokevirtual 487	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   442: istore 5
    //   444: getstatic 15	arph:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   447: ldc_w 6100
    //   450: iload_3
    //   451: invokestatic 318	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   454: invokestatic 2001	axqc:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)Z
    //   457: pop
    //   458: getstatic 15	arph:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   461: ldc_w 6102
    //   464: iload 4
    //   466: invokestatic 318	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   469: invokestatic 2001	axqc:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)Z
    //   472: pop
    //   473: getstatic 15	arph:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   476: ldc_w 6104
    //   479: iload 5
    //   481: invokestatic 318	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   484: invokestatic 2001	axqc:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)Z
    //   487: pop
    //   488: aload 7
    //   490: ldc_w 6106
    //   493: invokevirtual 6078	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   496: astore 8
    //   498: aload 8
    //   500: ifnull +273 -> 773
    //   503: getstatic 15	arph:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   506: ldc_w 6108
    //   509: aload 8
    //   511: invokevirtual 6081	org/json/JSONArray:toString	()Ljava/lang/String;
    //   514: invokestatic 2001	axqc:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)Z
    //   517: pop
    //   518: getstatic 15	arph:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   521: ldc_w 1998
    //   524: aload_2
    //   525: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   528: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   531: invokestatic 318	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   534: invokestatic 2001	axqc:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)Z
    //   537: pop
    //   538: aload 7
    //   540: ldc_w 6110
    //   543: iconst_0
    //   544: invokevirtual 2369	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   547: istore_3
    //   548: aload 7
    //   550: ldc_w 6112
    //   553: iconst_m1
    //   554: invokevirtual 2369	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   557: istore 4
    //   559: aload 7
    //   561: ldc_w 6114
    //   564: iconst_0
    //   565: invokevirtual 2369	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   568: istore 5
    //   570: aload 7
    //   572: ldc_w 6116
    //   575: iconst_0
    //   576: invokevirtual 2369	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   579: istore 6
    //   581: aload 7
    //   583: ldc_w 6118
    //   586: invokevirtual 137	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   589: astore_2
    //   590: getstatic 15	arph:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   593: ldc_w 6110
    //   596: iload_3
    //   597: invokestatic 318	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   600: invokestatic 2001	axqc:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)Z
    //   603: pop
    //   604: getstatic 15	arph:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   607: ldc_w 6112
    //   610: iload 4
    //   612: invokestatic 318	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   615: invokestatic 2001	axqc:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)Z
    //   618: pop
    //   619: getstatic 15	arph:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   622: ldc_w 6114
    //   625: iload 5
    //   627: invokestatic 318	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   630: invokestatic 2001	axqc:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)Z
    //   633: pop
    //   634: getstatic 15	arph:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   637: ldc_w 6116
    //   640: iload 6
    //   642: invokestatic 318	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   645: invokestatic 2001	axqc:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)Z
    //   648: pop
    //   649: getstatic 15	arph:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   652: ldc_w 6120
    //   655: aload_2
    //   656: invokestatic 2001	axqc:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)Z
    //   659: pop
    //   660: aload 7
    //   662: ldc_w 6122
    //   665: invokevirtual 487	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   668: istore_3
    //   669: getstatic 15	arph:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   672: ldc_w 6122
    //   675: iload_3
    //   676: invokestatic 318	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   679: invokestatic 2001	axqc:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)Z
    //   682: pop
    //   683: aload 7
    //   685: ldc_w 6124
    //   688: invokevirtual 754	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   691: astore_2
    //   692: aload_2
    //   693: ifnull +17 -> 710
    //   696: getstatic 15	arph:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   699: ldc_w 6126
    //   702: aload_2
    //   703: invokevirtual 6086	org/json/JSONObject:toString	()Ljava/lang/String;
    //   706: invokestatic 2001	axqc:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)Z
    //   709: pop
    //   710: aload_1
    //   711: ldc_w 6128
    //   714: iconst_1
    //   715: iconst_1
    //   716: aconst_null
    //   717: invokevirtual 6132	com/tencent/mobileqq/app/QQAppInterface:notifyObservers	(Ljava/lang/Class;IZLandroid/os/Bundle;)V
    //   720: return
    //   721: astore 7
    //   723: ldc_w 6069
    //   726: iconst_1
    //   727: new 85	java/lang/StringBuilder
    //   730: dup
    //   731: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   734: ldc_w 6134
    //   737: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   740: aload 7
    //   742: invokevirtual 825	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   745: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   748: invokestatic 658	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   751: aconst_null
    //   752: astore 7
    //   754: goto -495 -> 259
    //   757: aload 7
    //   759: getfield 268	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content:content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   762: invokevirtual 273	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   765: invokevirtual 293	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   768: astore 7
    //   770: goto -511 -> 259
    //   773: getstatic 15	arph:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   776: ldc_w 6108
    //   779: ldc 13
    //   781: invokestatic 2001	axqc:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)Z
    //   784: pop
    //   785: goto -267 -> 518
    //   788: astore_1
    //   789: ldc_w 6069
    //   792: iconst_1
    //   793: new 85	java/lang/StringBuilder
    //   796: dup
    //   797: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   800: ldc_w 6136
    //   803: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   806: aload_1
    //   807: invokevirtual 825	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   810: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   813: invokestatic 658	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   816: return
    //   817: astore_1
    //   818: ldc_w 6069
    //   821: iconst_1
    //   822: ldc_w 6138
    //   825: aload_1
    //   826: invokestatic 194	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   829: return
    //   830: aconst_null
    //   831: astore 7
    //   833: goto -574 -> 259
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	836	0	this	arph
    //   0	836	1	paramQQAppInterface	QQAppInterface
    //   0	836	2	paramConfig	ConfigurationService.Config
    //   78	598	3	i	int
    //   1	610	4	j	int
    //   22	604	5	k	int
    //   31	610	6	m	int
    //   68	616	7	localObject1	Object
    //   721	20	7	localException	Exception
    //   752	80	7	str	String
    //   317	193	8	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   245	259	721	java/lang/Exception
    //   298	342	788	java/lang/Exception
    //   342	352	788	java/lang/Exception
    //   357	372	788	java/lang/Exception
    //   372	381	788	java/lang/Exception
    //   386	400	788	java/lang/Exception
    //   400	410	788	java/lang/Exception
    //   415	488	788	java/lang/Exception
    //   488	498	788	java/lang/Exception
    //   503	518	788	java/lang/Exception
    //   518	692	788	java/lang/Exception
    //   696	710	788	java/lang/Exception
    //   710	720	788	java/lang/Exception
    //   773	785	788	java/lang/Exception
    //   3	77	817	java/lang/Exception
    //   79	95	817	java/lang/Exception
    //   102	119	817	java/lang/Exception
    //   122	176	817	java/lang/Exception
    //   183	191	817	java/lang/Exception
    //   194	207	817	java/lang/Exception
    //   212	240	817	java/lang/Exception
    //   264	298	817	java/lang/Exception
    //   723	751	817	java/lang/Exception
    //   757	770	817	java/lang/Exception
    //   789	816	817	java/lang/Exception
  }
  
  void r(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    QLog.i("Contact.RecommendTabConfig", 1, String.format("receive handleContactRecommendTabConfig", new Object[0]));
    if (paramConfig.type.get() != 371) {
      return;
    }
    int i = bhhr.ah(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
    int j = paramConfig.version.get();
    if (i == j)
    {
      QLog.i("Contact.RecommendTabConfig", 1, String.format("handleContactRecommendTabConfig, req-version equals to rsp-version, ver=%d", new Object[] { Integer.valueOf(i) }));
      return;
    }
    byte[] arrayOfByte;
    if (paramConfig.msg_content_list.size() > 0)
    {
      paramConfig = (ConfigurationService.Content)paramConfig.msg_content_list.get(0);
      if (paramConfig != null) {
        if (paramConfig.compress.get() == 1)
        {
          arrayOfByte = ayym.a(paramConfig.content.get().toByteArray());
          if (arrayOfByte == null) {
            break label296;
          }
        }
      }
    }
    for (;;)
    {
      try
      {
        paramConfig = new String(arrayOfByte, "UTF-8");
        if (QLog.isColorLevel()) {
          QLog.i("SPLASH_ConfigServlet", 2, "handleContactRecommendTabConfig config_content:" + paramConfig);
        }
        bhhr.n(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, paramConfig);
        bhhr.G(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, j);
        return;
      }
      catch (Exception paramConfig)
      {
        QLog.i("Contact.RecommendTabConfig", 1, String.format("handleContactRecommendTabConfig, uncompress failed, buf-len=%d", new Object[] { Integer.valueOf(arrayOfByte.length) }));
        paramConfig = null;
        continue;
      }
      paramConfig = paramConfig.content.get().toStringUtf8();
      continue;
      QLog.i("Contact.RecommendTabConfig", 1, String.format("handleContactRecommendTabConfig, content is null", new Object[0]));
      for (;;)
      {
        paramConfig = null;
        break;
        QLog.i("Contact.RecommendTabConfig", 1, String.format("handleContactRecommendTabConfig, msg content list is empty", new Object[0]));
      }
      label296:
      paramConfig = null;
    }
  }
  
  /* Error */
  void s(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aconst_null
    //   4: astore 8
    //   6: iconst_0
    //   7: istore 5
    //   9: ldc_w 6158
    //   12: iconst_1
    //   13: ldc_w 6160
    //   16: iconst_0
    //   17: anewarray 314	java/lang/Object
    //   20: invokestatic 322	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   23: invokestatic 206	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   26: aload_1
    //   27: invokevirtual 65	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   30: getstatic 15	arph:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   33: invokestatic 2016	ahud:a	(Landroid/content/Context;Ljava/lang/String;)I
    //   36: istore_3
    //   37: aload_2
    //   38: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   41: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   44: istore 6
    //   46: iload_3
    //   47: iload 6
    //   49: if_icmpeq +396 -> 445
    //   52: aload_2
    //   53: getfield 234	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   56: ifnull +365 -> 421
    //   59: aload_2
    //   60: getfield 234	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   63: invokevirtual 237	com/tencent/mobileqq/pb/PBRepeatMessageField:size	()I
    //   66: ifle +355 -> 421
    //   69: aload_2
    //   70: getfield 234	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   73: iconst_0
    //   74: invokevirtual 330	com/tencent/mobileqq/pb/PBRepeatMessageField:get	(I)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   77: checkcast 257	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content
    //   80: astore_2
    //   81: aload_2
    //   82: ifnull +326 -> 408
    //   85: aload_2
    //   86: getfield 268	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content:content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   89: invokevirtual 1165	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   92: ifeq +316 -> 408
    //   95: aload_2
    //   96: getfield 261	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content:compress	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   99: invokevirtual 264	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   102: iconst_1
    //   103: if_icmpne +217 -> 320
    //   106: aload_2
    //   107: getfield 268	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content:content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   110: invokevirtual 273	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   113: invokevirtual 279	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   116: invokestatic 333	ayym:a	([B)[B
    //   119: astore_2
    //   120: aload_2
    //   121: ifnull +393 -> 514
    //   124: new 118	java/lang/String
    //   127: dup
    //   128: aload_2
    //   129: ldc_w 335
    //   132: invokespecial 338	java/lang/String:<init>	([BLjava/lang/String;)V
    //   135: astore_2
    //   136: aload_2
    //   137: ifnull +215 -> 352
    //   140: new 128	org/json/JSONObject
    //   143: dup
    //   144: aload_2
    //   145: invokespecial 131	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   148: astore 9
    //   150: ldc_w 6158
    //   153: iconst_1
    //   154: new 85	java/lang/StringBuilder
    //   157: dup
    //   158: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   161: ldc_w 6162
    //   164: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   167: aload_2
    //   168: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   174: invokestatic 206	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   177: aload 9
    //   179: ldc_w 6164
    //   182: invokevirtual 420	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   185: istore_3
    //   186: aload 9
    //   188: ldc_w 6166
    //   191: invokevirtual 420	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   194: istore 4
    //   196: aload 9
    //   198: ldc_w 6168
    //   201: invokevirtual 528	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   204: astore 9
    //   206: aload 8
    //   208: astore_2
    //   209: aload 9
    //   211: ifnull +123 -> 334
    //   214: aload 8
    //   216: astore_2
    //   217: aload 9
    //   219: invokevirtual 533	org/json/JSONArray:length	()I
    //   222: ifle +112 -> 334
    //   225: new 535	java/util/HashSet
    //   228: dup
    //   229: invokespecial 536	java/util/HashSet:<init>	()V
    //   232: astore_2
    //   233: iload 5
    //   235: aload 9
    //   237: invokevirtual 533	org/json/JSONArray:length	()I
    //   240: if_icmpge +94 -> 334
    //   243: aload 9
    //   245: iload 5
    //   247: invokevirtual 6169	org/json/JSONArray:get	(I)Ljava/lang/Object;
    //   250: checkcast 128	org/json/JSONObject
    //   253: ldc_w 6171
    //   256: invokevirtual 433	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   259: astore 7
    //   261: aload 7
    //   263: invokestatic 126	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   266: ifne +12 -> 278
    //   269: aload_2
    //   270: aload 7
    //   272: invokeinterface 2955 2 0
    //   277: pop
    //   278: iload 5
    //   280: iconst_1
    //   281: iadd
    //   282: istore 5
    //   284: goto -51 -> 233
    //   287: astore_2
    //   288: ldc_w 6158
    //   291: iconst_1
    //   292: new 85	java/lang/StringBuilder
    //   295: dup
    //   296: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   299: ldc_w 6173
    //   302: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   305: aload_2
    //   306: invokevirtual 825	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   309: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   312: invokestatic 658	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   315: aconst_null
    //   316: astore_2
    //   317: goto -181 -> 136
    //   320: aload_2
    //   321: getfield 268	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content:content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   324: invokevirtual 273	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   327: invokevirtual 293	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   330: astore_2
    //   331: goto -195 -> 136
    //   334: iload_3
    //   335: istore 5
    //   337: iload 4
    //   339: istore_3
    //   340: aload_1
    //   341: invokestatic 6176	ahud:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)Lahud;
    //   344: aload_1
    //   345: iload 5
    //   347: iload_3
    //   348: aload_2
    //   349: invokevirtual 6179	ahud:a	(Lcom/tencent/mobileqq/app/QQAppInterface;IILjava/util/Set;)V
    //   352: aload_1
    //   353: invokevirtual 65	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   356: getstatic 15	arph:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   359: iload 6
    //   361: invokestatic 6180	ahud:a	(Landroid/content/Context;Ljava/lang/String;I)V
    //   364: return
    //   365: astore_2
    //   366: iconst_0
    //   367: istore 4
    //   369: iconst_0
    //   370: istore_3
    //   371: ldc_w 6158
    //   374: iconst_1
    //   375: new 85	java/lang/StringBuilder
    //   378: dup
    //   379: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   382: ldc_w 6061
    //   385: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   388: aload_2
    //   389: invokevirtual 825	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   392: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   395: invokestatic 658	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   398: aload 7
    //   400: astore_2
    //   401: iload 4
    //   403: istore 5
    //   405: goto -65 -> 340
    //   408: ldc_w 6158
    //   411: iconst_1
    //   412: ldc_w 6182
    //   415: invokestatic 206	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   418: goto -66 -> 352
    //   421: ldc_w 6158
    //   424: iconst_1
    //   425: ldc_w 6184
    //   428: invokestatic 206	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   431: aload_1
    //   432: invokestatic 6176	ahud:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)Lahud;
    //   435: aload_1
    //   436: iconst_0
    //   437: iconst_0
    //   438: aconst_null
    //   439: invokevirtual 6179	ahud:a	(Lcom/tencent/mobileqq/app/QQAppInterface;IILjava/util/Set;)V
    //   442: goto -90 -> 352
    //   445: ldc_w 6158
    //   448: iconst_1
    //   449: ldc_w 6186
    //   452: iconst_1
    //   453: anewarray 314	java/lang/Object
    //   456: dup
    //   457: iconst_0
    //   458: iload_3
    //   459: invokestatic 318	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   462: aastore
    //   463: invokestatic 322	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   466: invokestatic 658	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   469: return
    //   470: astore_2
    //   471: iload_3
    //   472: istore 4
    //   474: iconst_0
    //   475: istore_3
    //   476: goto -105 -> 371
    //   479: astore_2
    //   480: iload_3
    //   481: istore 5
    //   483: iload 4
    //   485: istore_3
    //   486: iload 5
    //   488: istore 4
    //   490: goto -119 -> 371
    //   493: astore 8
    //   495: iload_3
    //   496: istore 5
    //   498: iload 4
    //   500: istore_3
    //   501: aload_2
    //   502: astore 7
    //   504: iload 5
    //   506: istore 4
    //   508: aload 8
    //   510: astore_2
    //   511: goto -140 -> 371
    //   514: aconst_null
    //   515: astore_2
    //   516: goto -380 -> 136
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	519	0	this	arph
    //   0	519	1	paramQQAppInterface	QQAppInterface
    //   0	519	2	paramConfig	ConfigurationService.Config
    //   36	465	3	i	int
    //   194	313	4	j	int
    //   7	498	5	k	int
    //   44	316	6	m	int
    //   1	502	7	localObject1	Object
    //   4	211	8	localObject2	Object
    //   493	16	8	localException	Exception
    //   148	96	9	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   124	136	287	java/lang/Exception
    //   140	186	365	java/lang/Exception
    //   186	196	470	java/lang/Exception
    //   196	206	479	java/lang/Exception
    //   217	233	479	java/lang/Exception
    //   233	278	493	java/lang/Exception
  }
  
  void u(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    ThreadManager.getSubThreadHandler().post(new ConfigServlet.13(this, paramConfig, paramQQAppInterface));
  }
  
  void v(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    int i = bhhr.al(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
    int j = paramConfig.version.get();
    if (i != j) {
      if ((paramConfig.msg_content_list != null) && (paramConfig.msg_content_list.size() > 0))
      {
        paramConfig = (ConfigurationService.Content)paramConfig.msg_content_list.get(0);
        if ((paramConfig != null) && (paramConfig.content.has())) {
          if (paramConfig.compress.get() == 1)
          {
            paramConfig = ayym.a(paramConfig.content.get().toByteArray());
            if (paramConfig == null) {
              break label339;
            }
          }
        }
      }
    }
    for (;;)
    {
      try
      {
        paramConfig = new String(paramConfig, "UTF-8");
        bhhr.I(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, j);
        ((awtc)paramQQAppInterface.getManager(QQManagerFactory.CU_OPEN_CARD_GUIDE_MANAGER)).a(paramConfig);
        if (QLog.isColorLevel()) {
          QLog.i("CU_OPEN_CARD_GUIDE", 2, String.format(Locale.getDefault(), "handleCUOpenCardGuideConfig reqVer: %d rspVer: %d config: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), paramConfig }));
        }
        return;
      }
      catch (Exception paramConfig)
      {
        QLog.e("SPLASH_ConfigServlet", 1, "handleCUOpenCardGuideConfig|uncompress failed" + paramConfig);
        paramConfig = null;
        continue;
      }
      paramConfig = paramConfig.content.get().toStringUtf8();
      continue;
      paramConfig = localObject1;
      if (QLog.isColorLevel())
      {
        QLog.i("CU_OPEN_CARD_GUIDE", 2, String.format(Locale.getDefault(), "handleCUOpenCardGuideConfig empty content", new Object[0]));
        paramConfig = localObject1;
        continue;
        paramConfig = localObject1;
        if (QLog.isColorLevel())
        {
          QLog.i("CU_OPEN_CARD_GUIDE", 2, String.format(Locale.getDefault(), "handleCUOpenCardGuideConfig empty config", new Object[0]));
          paramConfig = localObject1;
          continue;
          paramConfig = localObject2;
          if (QLog.isColorLevel())
          {
            QLog.i("CU_OPEN_CARD_GUIDE", 2, String.format(Locale.getDefault(), "handleCUOpenCardGuideConfig same version, no need to update", new Object[0]));
            paramConfig = localObject2;
            continue;
            label339:
            paramConfig = null;
          }
        }
      }
    }
  }
  
  public void x(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    int i = paramConfig.version.get();
    boolean bool;
    if (i != paramQQAppInterface.getPreferences().getInt("tim_upgrade_hongdian_version", 0))
    {
      long l1 = System.currentTimeMillis();
      bool = bhfn.a(paramQQAppInterface.getApp(), "com.tencent.tim");
      long l2 = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d("TimUpgradeHondianManager", 2, "is install TIM = " + bool + " time cost = " + (l2 - l1));
      }
      if (bool) {
        break label386;
      }
      paramConfig = a(paramConfig);
      if ((paramConfig == null) || (paramConfig.size() <= 0)) {}
    }
    try
    {
      Object localObject = new JSONObject((String)paramConfig.get(0));
      if (((JSONObject)localObject).has("AboutTIMRedDot"))
      {
        paramConfig = paramQQAppInterface.getApp().getSharedPreferences("tim_upgrade_hongdian_pre_" + paramQQAppInterface.getCurrentUin(), 0).edit();
        localObject = ((JSONObject)localObject).getJSONObject("AboutTIMRedDot");
        if (((JSONObject)localObject).has("On")) {
          if (((JSONObject)localObject).getInt("On") != 1) {
            break label374;
          }
        }
      }
      label374:
      for (bool = true;; bool = false)
      {
        paramConfig.putBoolean("tim_upgrade_hongdian_switch", bool);
        if (((JSONObject)localObject).has("AboutTitle")) {
          paramConfig.putString("tim_upgrade_hongdian_title", ((JSONObject)localObject).getString("AboutTitle"));
        }
        if (((JSONObject)localObject).has("AboutSubtitle")) {
          paramConfig.putString("tim_upgrade_hongdian_sub_title", ((JSONObject)localObject).getString("AboutSubtitle"));
        }
        if (((JSONObject)localObject).has("AndroidAboutURL"))
        {
          localObject = ((JSONObject)localObject).getString("AndroidAboutURL");
          paramConfig.putString("tim_upgrade_hongdian_url", (String)localObject);
          ((UpgradeTIMManager)paramQQAppInterface.getManager(QQManagerFactory.TIM_UPGRADE_DOWNLOAD_MANAGER)).a((String)localObject);
        }
        paramConfig.commit();
        paramQQAppInterface = paramQQAppInterface.getPreferences().edit();
        paramQQAppInterface.putInt("tim_upgrade_hongdian_version", i);
        paramQQAppInterface.apply();
        return;
      }
      ((awty)paramQQAppInterface.getManager(QQManagerFactory.TIM_UPGRADE_HONGDIAN_MANAGER)).a();
    }
    catch (JSONException paramQQAppInterface)
    {
      paramQQAppInterface.printStackTrace();
      return;
    }
    label386:
  }
  
  public void y(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    int i = paramConfig.version.get();
    if (i != paramQQAppInterface.getPreferences().getInt("tim_login_jump", 0))
    {
      paramConfig = a(paramConfig);
      if ((paramConfig == null) || (paramConfig.size() <= 0)) {}
    }
    try
    {
      JSONObject localJSONObject = new JSONObject((String)paramConfig.get(0));
      if (localJSONObject.has("LoginedTipForTIM"))
      {
        paramConfig = paramQQAppInterface.getApp().getSharedPreferences("tim_login_shared_pre_" + paramQQAppInterface.getCurrentUin(), 0).edit();
        localJSONObject = localJSONObject.getJSONObject("LoginedTipForTIM");
        if (localJSONObject.has("On")) {
          if (localJSONObject.getInt("On") != 1) {
            break label463;
          }
        }
      }
      label463:
      for (boolean bool = true;; bool = false)
      {
        paramConfig.putBoolean("tim_login_s", bool);
        if (localJSONObject.has("ShowTipTimeIntervalAfterLogined")) {
          paramConfig.putInt("tim_login_tal", localJSONObject.getInt("ShowTipTimeIntervalAfterLogined"));
        }
        if (localJSONObject.has("ShowTipDay")) {
          paramConfig.putString("tim_login_sd", localJSONObject.getJSONArray("ShowTipDay").toString());
        }
        if (localJSONObject.has("ShowTipTime")) {
          paramConfig.putString("tim_login_st", localJSONObject.getJSONArray("ShowTipTime").toString());
        }
        if (localJSONObject.has("AndroidLimit")) {
          paramConfig.putInt("tim_login_l", localJSONObject.getInt("AndroidLimit"));
        }
        if (localJSONObject.has("ShowTipTotalCount")) {
          paramConfig.putInt("tim_login_tc", localJSONObject.getInt("ShowTipTotalCount"));
        }
        if (localJSONObject.has("ShowTipHourInterval")) {
          paramConfig.putInt("tim_login_sti", localJSONObject.getInt("ShowTipHourInterval"));
        }
        if (localJSONObject.has("Title")) {
          paramConfig.putString("tim_login_t", localJSONObject.getString("Title"));
        }
        if (localJSONObject.has("Message")) {
          paramConfig.putString("tim_login_c", localJSONObject.getString("Message"));
        }
        if (localJSONObject.has("Buttons")) {
          paramConfig.putString("tim_login_btns", localJSONObject.getJSONArray("Buttons").toString());
        }
        paramConfig.commit();
        paramQQAppInterface = paramQQAppInterface.getPreferences().edit();
        paramQQAppInterface.putInt("tim_login_jump", i);
        paramQQAppInterface.apply();
        return;
      }
      return;
    }
    catch (JSONException paramQQAppInterface)
    {
      paramQQAppInterface.printStackTrace();
    }
  }
  
  public void z(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    int i = paramConfig.version.get();
    if (i != paramQQAppInterface.getPreferences().getInt("tim_pc_banner", 0))
    {
      paramConfig = a(paramConfig);
      if ((paramConfig == null) || (paramConfig.size() <= 0)) {}
    }
    try
    {
      JSONObject localJSONObject = new JSONObject((String)paramConfig.get(0));
      if (localJSONObject.has("PCTIMLoginBanner"))
      {
        paramConfig = paramQQAppInterface.getApp().getSharedPreferences("tim_pc_banner_shared_pre_" + paramQQAppInterface.getCurrentUin(), 0).edit();
        localJSONObject = localJSONObject.getJSONObject("PCTIMLoginBanner");
        if (localJSONObject.has("On")) {
          if (localJSONObject.getInt("On") != 1) {
            break label338;
          }
        }
      }
      label338:
      for (boolean bool = true;; bool = false)
      {
        paramConfig.putBoolean("tim_pc_banner_switch", bool);
        if (localJSONObject.has("bannerURL")) {
          paramConfig.putString("tim_pc_banner_image_url", localJSONObject.getString("bannerURL"));
        }
        if (localJSONObject.has("bannerVersion")) {
          paramConfig.putInt("tim_pc_banner_image_ver", localJSONObject.getInt("bannerVersion"));
        }
        if (localJSONObject.has("androidURL")) {
          paramConfig.putString("tim_pc_banner_click_url", localJSONObject.getString("androidURL"));
        }
        if (localJSONObject.has("linkText")) {
          paramConfig.putString("tim_pc_banner_link_text", localJSONObject.getString("linkText"));
        }
        if (localJSONObject.has("androidLinkURL")) {
          paramConfig.putString("tim_pc_banner_link_url", localJSONObject.getString("androidLinkURL"));
        }
        paramConfig.commit();
        paramQQAppInterface = paramQQAppInterface.getPreferences().edit();
        paramQQAppInterface.putInt("tim_pc_banner", i);
        paramQQAppInterface.apply();
        return;
      }
      return;
    }
    catch (JSONException paramQQAppInterface)
    {
      paramQQAppInterface.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arph
 * JD-Core Version:    0.7.0.1
 */