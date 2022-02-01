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
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.NearbyGrayTipsManager;
import com.tencent.mobileqq.app.QQAppInterface;
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
import com.tencent.mobileqq.pluspanel.loader.c2c.C2CPlusPanelAppConfigHelper;
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

public class aqlw
  extends MSFServlet
{
  public static String a;
  private static final int[] jdField_a_of_type_ArrayOfInt = { 1, 2, 3, 5, 10, 13, 23, 31, 38, 42, 44, 46, 47, 49, 50, 53, 55, 56, 57, 61, 62, 63, 64, 65, 66, 69, 206, 205, 72, 73, 74, 75, 385, 94, 78, 79, 80, 84, 223, 82, 101, 102, 147, 86, 93, 88, 90, 96, 97, 108, 146, 111, 109, 115, 286, 118, 119, 116, 130, 142, 121, 157, 211, 201, 129, 143, 140, 257, 232, 233, 148, 139, 145, 153, 149, 155, 165, 185, 167, 166, 171, 180, 182, 177, 371, 181, 184, 187, 191, 193, 188, 195, 227, 202, 190, 210, 199, 212, 407, vpl.a(2131427352), vpl.a(2131427353), vpl.a(2131427354), vpl.a(2131427349), vpl.a(2131427350), 218, 226, 225, 222, 256, 228, 235, 234, 238, 247, 244, 245, 253, 295, 254, 259, 260, 262, 204, 271, 267, 275, 358, 268, 269, 272, 274, 279, 308, 281, 283, 284, 280, 360, 289, 314, 297, 301, 296, 330, 347, 313, 312, 397, 321, 326, 320, 328, 331, 336, 329, 337, 345, 351, 349, 355, 372, 384, 379, 357, 378, 381, 273, 364, 365, 369, 387, 386, 392, 393, 394, 401, 400, 403, 404, 405, 408, 410, 194, 596, 604 };
  private static String b;
  private boolean jdField_a_of_type_Boolean;
  
  static
  {
    jdField_a_of_type_JavaLangString = "";
    jdField_b_of_type_JavaLangString = amtj.a(2131701577);
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
        j = bfyz.P(localQQAppInterface.getApp(), localQQAppInterface.getAccount());
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
        paramConfig = (awcg)localQQAppInterface.getManager(166);
        paramConfig.jdField_b_of_type_Boolean = true;
        paramConfig.c = bool3;
        localQQAppInterface.isMsfPullFilterConfigInited = true;
        localQQAppInterface.msfPullFilterSwitch = bool4;
        bfyz.b(localQQAppInterface.getApp(), localQQAppInterface.getAccount(), i, bool3, bool4);
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
    bjni localbjni = (bjni)((QQAppInterface)localObject).getBusinessHandler(146);
    int i = localbjni.b(BaseApplicationImpl.getContext(), ((QQAppInterface)localObject).getAccount());
    if (localbjni.a(BaseApplicationImpl.getContext(), ((QQAppInterface)localObject).getAccount()) != k) {
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
          paramConfig = localbjni.a(paramConfig.content.get().toByteArray());
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
          localbjni.a(paramConfig, j, k);
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
        localbjni.a(jdField_a_of_type_JavaLangString);
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
    //   1: invokevirtual 47	aqlw:getAppRuntime	()Lmqq/app/AppRuntime;
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
    //   27: invokestatic 294	bfyz:aU	(Landroid/content/Context;Ljava/lang/String;)I
    //   30: istore_2
    //   31: aload 8
    //   33: invokevirtual 65	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   36: aload 8
    //   38: invokevirtual 69	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   41: invokestatic 297	bfyz:aV	(Landroid/content/Context;Ljava/lang/String;)I
    //   44: istore 4
    //   46: invokestatic 204	com/tencent/common/config/AppSetting:a	()I
    //   49: istore 5
    //   51: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   54: ifeq +50 -> 104
    //   57: ldc_w 299
    //   60: iconst_2
    //   61: ldc_w 301
    //   64: iconst_4
    //   65: anewarray 303	java/lang/Object
    //   68: dup
    //   69: iconst_0
    //   70: iload_3
    //   71: invokestatic 307	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   74: aastore
    //   75: dup
    //   76: iconst_1
    //   77: iload_2
    //   78: invokestatic 307	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   81: aastore
    //   82: dup
    //   83: iconst_2
    //   84: iload 4
    //   86: invokestatic 307	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   89: aastore
    //   90: dup
    //   91: iconst_3
    //   92: iload 5
    //   94: invokestatic 307	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   97: aastore
    //   98: invokestatic 311	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   101: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   104: iload 4
    //   106: iload 5
    //   108: if_icmpeq +20 -> 128
    //   111: aload 8
    //   113: invokevirtual 65	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   116: iload 5
    //   118: aload 8
    //   120: invokevirtual 69	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   123: invokestatic 314	bfyz:A	(Landroid/content/Context;ILjava/lang/String;)V
    //   126: iconst_0
    //   127: istore_2
    //   128: iload_3
    //   129: iload_2
    //   130: if_icmpeq +66 -> 196
    //   133: aload_1
    //   134: getfield 223	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   137: ifnull +275 -> 412
    //   140: aload_1
    //   141: getfield 223	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   144: invokevirtual 316	com/tencent/mobileqq/pb/PBRepeatMessageField:isEmpty	()Z
    //   147: ifne +265 -> 412
    //   150: aload_1
    //   151: getfield 223	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   154: iconst_0
    //   155: invokevirtual 319	com/tencent/mobileqq/pb/PBRepeatMessageField:get	(I)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   158: checkcast 246	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content
    //   161: astore 7
    //   163: aload 7
    //   165: getfield 250	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content:compress	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   168: invokevirtual 253	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   171: iconst_1
    //   172: if_icmpne +207 -> 379
    //   175: aload 7
    //   177: getfield 257	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content:content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   180: invokevirtual 262	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   183: invokevirtual 268	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   186: invokestatic 322	axsb:a	([B)[B
    //   189: astore 7
    //   191: aload 7
    //   193: ifnonnull +4 -> 197
    //   196: return
    //   197: new 118	java/lang/String
    //   200: dup
    //   201: aload 7
    //   203: ldc_w 324
    //   206: invokespecial 327	java/lang/String:<init>	([BLjava/lang/String;)V
    //   209: astore 7
    //   211: new 128	org/json/JSONObject
    //   214: dup
    //   215: aload 7
    //   217: invokespecial 131	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   220: ldc_w 329
    //   223: invokevirtual 333	org/json/JSONObject:getBoolean	(Ljava/lang/String;)Z
    //   226: istore 6
    //   228: aload 8
    //   230: invokevirtual 65	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   233: ldc_w 335
    //   236: iconst_4
    //   237: invokevirtual 341	com/tencent/qphone/base/util/BaseApplication:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   240: invokeinterface 347 1 0
    //   245: ldc_w 349
    //   248: iload 6
    //   250: invokeinterface 355 3 0
    //   255: invokeinterface 358 1 0
    //   260: aload 8
    //   262: invokevirtual 65	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   265: aload_1
    //   266: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   269: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   272: getstatic 15	aqlw:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   275: invokestatic 361	bfyz:z	(Landroid/content/Context;ILjava/lang/String;)V
    //   278: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   281: ifeq +30 -> 311
    //   284: ldc 183
    //   286: iconst_2
    //   287: new 85	java/lang/StringBuilder
    //   290: dup
    //   291: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   294: ldc_w 363
    //   297: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   300: iload 6
    //   302: invokevirtual 152	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   305: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   308: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   311: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   314: ifeq -118 -> 196
    //   317: ldc 183
    //   319: iconst_2
    //   320: new 85	java/lang/StringBuilder
    //   323: dup
    //   324: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   327: ldc_w 365
    //   330: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   333: aload 7
    //   335: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   338: ldc_w 367
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
    //   368: ldc 183
    //   370: iconst_2
    //   371: aload_1
    //   372: invokestatic 371	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   375: invokestatic 374	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   378: return
    //   379: aload 7
    //   381: getfield 257	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content:content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   384: invokevirtual 262	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   387: invokevirtual 282	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   390: astore 7
    //   392: goto -181 -> 211
    //   395: astore 8
    //   397: ldc 183
    //   399: iconst_1
    //   400: aload 8
    //   402: iconst_0
    //   403: anewarray 303	java/lang/Object
    //   406: invokestatic 377	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   409: goto -98 -> 311
    //   412: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   415: ifeq +35 -> 450
    //   418: ldc 183
    //   420: iconst_2
    //   421: new 85	java/lang/StringBuilder
    //   424: dup
    //   425: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   428: ldc_w 379
    //   431: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   434: aload_1
    //   435: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   438: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   441: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   444: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   447: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   450: aload 8
    //   452: invokevirtual 65	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   455: ldc_w 335
    //   458: iconst_4
    //   459: invokevirtual 341	com/tencent/qphone/base/util/BaseApplication:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   462: invokeinterface 347 1 0
    //   467: astore_1
    //   468: aload_1
    //   469: ldc_w 335
    //   472: invokeinterface 383 2 0
    //   477: pop
    //   478: aload_1
    //   479: invokeinterface 358 1 0
    //   484: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	485	0	this	aqlw
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
    int j = bfyz.aR(BaseApplication.getContext(), jdField_a_of_type_JavaLangString);
    if (QLog.isColorLevel()) {
      QLog.i("SPLASH_ConfigServlet", 2, "handleWeiYunMiniAppConfig: ,version: " + paramConfig.version.get() + "| localVersion: " + j);
    }
    if (i != j)
    {
      bfyz.ah(BaseApplication.getContext(), jdField_a_of_type_JavaLangString, i);
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
              bfyz.x(BaseApplication.getContext(), i, paramQQAppInterface.getCurrentAccountUin());
              if (QLog.isColorLevel()) {
                QLog.d("SPLASH_ConfigServlet", 2, "handleWeiYunMiniAppConfig, enableMiniApp = " + i);
              }
            }
            if (((JSONObject)localObject).has("apkgUrl"))
            {
              String str = ((JSONObject)localObject).getString("apkgUrl");
              bfyz.v(BaseApplication.getContext(), str, paramQQAppInterface.getCurrentAccountUin());
              if (QLog.isColorLevel()) {
                QLog.d("SPLASH_ConfigServlet", 2, "handleWeiYunMiniAppConfig, apkgUrl = " + str);
              }
            }
            if (((JSONObject)localObject).has("miniVersion"))
            {
              i = ((JSONObject)localObject).getInt("miniVersion");
              bfyz.y(BaseApplication.getContext(), i, paramQQAppInterface.getCurrentAccountUin());
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
    int j = bfyz.aX(BaseApplication.getContext(), jdField_a_of_type_JavaLangString);
    if (QLog.isColorLevel()) {
      QLog.i("SPLASH_ConfigServlet", 2, "handleAIOConfig: ,version: " + paramConfig.version.get() + "| localVersion: " + j);
    }
    if (i != j)
    {
      bfyz.aj(BaseApplication.getContext(), jdField_a_of_type_JavaLangString, i);
      paramConfig = a(paramConfig);
      if ((paramConfig == null) || (paramConfig.size() <= 0)) {}
    }
    while (!QLog.isColorLevel()) {
      try
      {
        paramConfig = (String)paramConfig.get(paramConfig.size() - 1);
        bfyz.c(BaseApplication.getContext(), jdField_a_of_type_JavaLangString, "aio_config_key", paramConfig);
        aewr.a(paramQQAppInterface);
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
    int j = bfyz.aY(BaseApplication.getContext(), jdField_a_of_type_JavaLangString);
    if (QLog.isColorLevel()) {
      QLog.i("SPLASH_ConfigServlet", 2, "handleMultiMsgConfig: ,version: " + paramConfig.version.get() + "| localVersion: " + j);
    }
    if (i != j)
    {
      bfyz.ak(BaseApplication.getContext(), jdField_a_of_type_JavaLangString, i);
      paramConfig = a(paramConfig);
      if ((paramConfig == null) || (paramConfig.size() <= 0)) {}
    }
    while (!QLog.isColorLevel()) {
      try
      {
        i = new JSONObject((String)paramConfig.get(paramConfig.size() - 1)).optInt("max_multimsg_totalcount");
        bfyz.g(BaseApplication.getContext(), jdField_a_of_type_JavaLangString, "multimsg_config", i);
        if (QLog.isColorLevel()) {
          QLog.i("SPLASH_ConfigServlet", 2, "handleMultiMsgConfig:limitTotal =  " + i);
        }
        awcm.a().a(paramQQAppInterface);
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
    int j = bfyz.aA(BaseApplication.getContext(), jdField_a_of_type_JavaLangString);
    if (QLog.isColorLevel()) {
      QLog.i("SPLASH_ConfigServlet", 2, "handleConversationPublicAccConfig: ,version: " + paramConfig.version.get() + "| localVersion: " + j);
    }
    if (i != j)
    {
      bfyz.U(BaseApplication.getContext(), jdField_a_of_type_JavaLangString, i);
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
            localObject3 = akmi.a();
            if (i == 1)
            {
              bool = true;
              ((akmi)localObject3).a(paramQQAppInterface, bool);
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
        akmi.a().a(paramQQAppInterface, false);
        continue;
        if (QLog.isColorLevel()) {
          QLog.i("SPLASH_ConfigServlet", 2, "handleConversationPublicAccConfig  error =" + localJSONException1.getMessage());
        }
        akmi.a().a(paramQQAppInterface, false);
        akmi.a().a(paramQQAppInterface, null);
      }
    }
    label406:
    label417:
    label443:
    label444:
    for (;;)
    {
      break;
      akmi.a().a(paramQQAppInterface, localJSONException1);
      paramConfig = localJSONException1;
      continue;
      Object localObject2;
      akmi.a().a(paramQQAppInterface, paramConfig);
      break label444;
      akmi.a().a(paramQQAppInterface, paramConfig);
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
    int j = bfyz.a();
    if (QLog.isColorLevel()) {
      QLog.i("SPLASH_ConfigServlet", 2, "handleBeancurdConfig: ,version: " + paramConfig.version.get() + "| localVersion: " + j);
    }
    if (i != j)
    {
      bfyz.a(i);
      paramConfig = a(paramConfig);
      if ((paramConfig != null) && (paramConfig.size() > 0))
      {
        paramConfig = (String)paramConfig.get(paramConfig.size() - 1);
        if (QLog.isColorLevel()) {
          QLog.i("SPLASH_ConfigServlet", 2, "handleBeancurdConfigStr: " + paramConfig);
        }
        bfyz.b(paramConfig);
        ((aezm)paramQQAppInterface.getManager(282)).a(paramConfig);
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
    int j = bfyz.az(BaseApplication.getContext(), jdField_a_of_type_JavaLangString);
    if (QLog.isColorLevel()) {
      QLog.i("SPLASH_ConfigServlet", 2, "handleZhituConfig: ,version: " + paramConfig.version.get() + "| localVersion: " + j);
    }
    if (i != j)
    {
      bfyz.T(BaseApplication.getContext(), jdField_a_of_type_JavaLangString, i);
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
              ahtj localahtj;
              if (((JSONObject)localObject).has("kMarioConfigEnable"))
              {
                i = ((JSONObject)localObject).getInt("kMarioConfigEnable");
                localahtj = ahtj.a(paramQQAppInterface);
                if (i != 1) {
                  break label324;
                }
                bool = true;
                localahtj.a(bool);
              }
              if (((JSONObject)localObject).has("kMarioPageLen"))
              {
                i = ((JSONObject)localObject).getInt("kMarioPageLen");
                ahtj.a(paramQQAppInterface).b(i);
              }
              if (((JSONObject)localObject).has("kMarioSaveAndShareEnable"))
              {
                i = ((JSONObject)localObject).getInt("kMarioSaveAndShareEnable");
                localahtj = ahtj.a(paramQQAppInterface);
                if (i != 1) {
                  break label330;
                }
                bool = true;
                localahtj.b(bool);
              }
              if (!((JSONObject)localObject).has("kMarioSafeGateRequestInterval")) {
                break;
              }
              i = ((JSONObject)localObject).getInt("kMarioSafeGateRequestInterval");
              ahtj.a(paramQQAppInterface).a(i);
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
    a(paramQQAppInterface, paramConfig, "handleShortVideoMsgTailConfig", new aqlx(this, paramQQAppInterface));
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
            if ((j == bfyz.a(paramQQAppInterface.getApp(), "readinjoy_interested_push_config", jdField_a_of_type_JavaLangString)) || (TextUtils.isEmpty((CharSequence)localObject))) {
              break label412;
            }
            localObject = ((String)localObject).split("=");
            if (localObject.length >= 2)
            {
              if (!"xqh_insert_into_feeds".equals(localObject[0])) {
                continue;
              }
              bkwm.c(paramQQAppInterface, "1".equals(localObject[1]));
              if (QLog.isColorLevel()) {
                QLog.d("SPLASH_ConfigServlet", 2, "update KANDIAN_INTERESTED_PUSH_CONFiG config , switch : " + "1".equals(localObject[1]));
              }
            }
            bfyz.a(paramQQAppInterface.getApp(), "readinjoy_interested_push_config", jdField_a_of_type_JavaLangString, j);
            break label469;
            if ("simple_switch_fm".equals(localObject[0]))
            {
              bkwm.c(paramQQAppInterface, "1".equals(localObject[1]));
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
        ptc.a(paramQQAppInterface, "1".equals(localObject[1]));
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
            if (k != bfyz.a(paramQQAppInterface.getApp(), "now_entrance_action_version", jdField_a_of_type_JavaLangString))
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
                    bfyz.c(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin(), localJSONObject.optInt("bid"), localJSONObject.optInt("actionType"));
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
                  bfyz.a(paramQQAppInterface.getApp(), "now_entrance_action_version", jdField_a_of_type_JavaLangString, k);
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
            if (j == bfyz.a(paramQQAppInterface.getApp(), "troop_common_config_version", jdField_a_of_type_JavaLangString)) {
              break label625;
            }
            boolean bool = TextUtils.isEmpty((CharSequence)localObject);
            if (bool) {
              break label625;
            }
            try
            {
              JSONObject localJSONObject = new JSONObject((String)localObject);
              bfyz.e(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin(), localJSONObject.optString("hot_chat_link"));
              bfyz.v(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin(), localJSONObject.optInt("aio_post_tab_plugin"));
              ((bfdm)paramQQAppInterface.getManager(203)).a(localJSONObject);
              ((anwj)paramQQAppInterface.getManager(126)).a(localJSONObject);
              bfyz.u(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin(), localJSONObject.optInt("create_troop_max_invite_num"));
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
            }
            catch (JSONException localJSONException)
            {
              if (!QLog.isColorLevel()) {
                continue;
              }
              QLog.e("SPLASH_ConfigServlet.troop_common_config", 2, "received JSONException ");
              continue;
            }
            bfyz.a(paramQQAppInterface.getApp(), "troop_common_config_version", jdField_a_of_type_JavaLangString, j);
          }
        }
      }
      catch (Exception paramQQAppInterface)
      {
        if (QLog.isColorLevel()) {
          QLog.e("SPLASH_ConfigServlet.troop_common_config", 2, "received change machine config error,cmd : 142" + paramQQAppInterface.toString());
        }
      }
      label625:
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
            if (j != bfyz.a(paramQQAppInterface.getApp(), "nearby_config_version", jdField_a_of_type_JavaLangString))
            {
              boolean bool = TextUtils.isEmpty((CharSequence)localObject);
              if (!bool) {
                try
                {
                  localObject = new JSONObject((String)localObject);
                  bfyz.a(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin(), (JSONObject)localObject);
                  bfyz.a(paramQQAppInterface.getApp(), "nearby_config_version", jdField_a_of_type_JavaLangString, j);
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
          if (j != bfyz.a(paramQQAppInterface.getApp(), "nearby_nowlive_tab_config_version", jdField_a_of_type_JavaLangString))
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
                bfyz.a(paramQQAppInterface.getApp(), "nearby_nowlive_tab_config_version", jdField_a_of_type_JavaLangString, j);
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
        k = bfyz.a(paramQQAppInterface.getApp(), "change_machine_version", jdField_a_of_type_JavaLangString);
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
        bezh localbezh;
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
        localbezh.a("");
        if (!QLog.isColorLevel()) {
          break label261;
        }
        QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 195,content_list is empty ,version: " + paramConfig.version.get());
        return;
        if (j != k) {
          continue;
        }
      }
      localbezh = (bezh)paramQQAppInterface.getManager(224);
      if (i > 0)
      {
        paramConfig = b(paramConfig, k, 195);
        localbezh.a(paramConfig);
        if (!TextUtils.isEmpty(paramConfig))
        {
          bfyz.a(paramQQAppInterface.getApp(), "change_machine_version", jdField_a_of_type_JavaLangString, j);
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
              paramConfig = axsb.a(paramConfig.content.get().toByteArray());
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
    //   2: invokestatic 921	javax/xml/parsers/DocumentBuilderFactory:newInstance	()Ljavax/xml/parsers/DocumentBuilderFactory;
    //   5: invokevirtual 925	javax/xml/parsers/DocumentBuilderFactory:newDocumentBuilder	()Ljavax/xml/parsers/DocumentBuilder;
    //   8: new 927	java/io/ByteArrayInputStream
    //   11: dup
    //   12: aload_1
    //   13: ldc_w 929
    //   16: invokevirtual 933	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   19: invokespecial 934	java/io/ByteArrayInputStream:<init>	([B)V
    //   22: invokevirtual 939	javax/xml/parsers/DocumentBuilder:parse	(Ljava/io/InputStream;)Lorg/w3c/dom/Document;
    //   25: astore_1
    //   26: aload_1
    //   27: ldc_w 941
    //   30: invokeinterface 947 2 0
    //   35: astore 4
    //   37: aload 4
    //   39: ifnull +1254 -> 1293
    //   42: aload 4
    //   44: invokeinterface 952 1 0
    //   49: ifle +1244 -> 1293
    //   52: aload_1
    //   53: ldc_w 954
    //   56: invokeinterface 947 2 0
    //   61: astore 4
    //   63: aload 4
    //   65: ifnull +45 -> 110
    //   68: aload 4
    //   70: invokeinterface 952 1 0
    //   75: ifle +35 -> 110
    //   78: aload_2
    //   79: aload_1
    //   80: ldc_w 954
    //   83: invokeinterface 947 2 0
    //   88: iconst_0
    //   89: invokeinterface 958 2 0
    //   94: invokeinterface 964 1 0
    //   99: invokeinterface 967 1 0
    //   104: invokestatic 143	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   107: putfield 970	com/tencent/mobileqq/config/operation/QQOperationViopTipTask:taskid	I
    //   110: aload_1
    //   111: ldc_w 972
    //   114: invokeinterface 947 2 0
    //   119: astore 4
    //   121: aload 4
    //   123: ifnull +45 -> 168
    //   126: aload 4
    //   128: invokeinterface 952 1 0
    //   133: ifle +35 -> 168
    //   136: aload_2
    //   137: aload_1
    //   138: ldc_w 972
    //   141: invokeinterface 947 2 0
    //   146: iconst_0
    //   147: invokeinterface 958 2 0
    //   152: invokeinterface 964 1 0
    //   157: invokeinterface 967 1 0
    //   162: invokestatic 143	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   165: putfield 975	com/tencent/mobileqq/config/operation/QQOperationViopTipTask:limitDayAIOCount	I
    //   168: aload_1
    //   169: ldc_w 977
    //   172: invokeinterface 947 2 0
    //   177: astore 4
    //   179: aload 4
    //   181: ifnull +45 -> 226
    //   184: aload 4
    //   186: invokeinterface 952 1 0
    //   191: ifle +35 -> 226
    //   194: aload_2
    //   195: aload_1
    //   196: ldc_w 977
    //   199: invokeinterface 947 2 0
    //   204: iconst_0
    //   205: invokeinterface 958 2 0
    //   210: invokeinterface 964 1 0
    //   215: invokeinterface 967 1 0
    //   220: invokestatic 143	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   223: putfield 980	com/tencent/mobileqq/config/operation/QQOperationViopTipTask:limitDayAIOShowCount	I
    //   226: aload_1
    //   227: ldc_w 982
    //   230: invokeinterface 947 2 0
    //   235: astore 4
    //   237: aload 4
    //   239: ifnull +45 -> 284
    //   242: aload 4
    //   244: invokeinterface 952 1 0
    //   249: ifle +35 -> 284
    //   252: aload_2
    //   253: aload_1
    //   254: ldc_w 982
    //   257: invokeinterface 947 2 0
    //   262: iconst_0
    //   263: invokeinterface 958 2 0
    //   268: invokeinterface 964 1 0
    //   273: invokeinterface 967 1 0
    //   278: invokestatic 143	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   281: putfield 985	com/tencent/mobileqq/config/operation/QQOperationViopTipTask:limitTotalAIOCount	I
    //   284: aload_1
    //   285: ldc_w 987
    //   288: invokeinterface 947 2 0
    //   293: astore 4
    //   295: aload 4
    //   297: ifnull +45 -> 342
    //   300: aload 4
    //   302: invokeinterface 952 1 0
    //   307: ifle +35 -> 342
    //   310: aload_2
    //   311: aload_1
    //   312: ldc_w 987
    //   315: invokeinterface 947 2 0
    //   320: iconst_0
    //   321: invokeinterface 958 2 0
    //   326: invokeinterface 964 1 0
    //   331: invokeinterface 967 1 0
    //   336: invokestatic 143	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   339: putfield 990	com/tencent/mobileqq/config/operation/QQOperationViopTipTask:limitTotalShowCount	I
    //   342: aload_1
    //   343: ldc_w 992
    //   346: invokeinterface 947 2 0
    //   351: astore 4
    //   353: aload 4
    //   355: ifnull +42 -> 397
    //   358: aload 4
    //   360: invokeinterface 952 1 0
    //   365: ifle +32 -> 397
    //   368: aload_2
    //   369: aload_1
    //   370: ldc_w 992
    //   373: invokeinterface 947 2 0
    //   378: iconst_0
    //   379: invokeinterface 958 2 0
    //   384: invokeinterface 964 1 0
    //   389: invokeinterface 967 1 0
    //   394: invokevirtual 995	com/tencent/mobileqq/config/operation/QQOperationViopTipTask:setKeywordString	(Ljava/lang/String;)V
    //   397: invokestatic 998	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   400: ifeq +33 -> 433
    //   403: ldc_w 1000
    //   406: iconst_4
    //   407: new 85	java/lang/StringBuilder
    //   410: dup
    //   411: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   414: ldc_w 1002
    //   417: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   420: aload_2
    //   421: invokevirtual 1006	com/tencent/mobileqq/config/operation/QQOperationViopTipTask:getKeywordList	()Ljava/util/ArrayList;
    //   424: invokevirtual 800	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   427: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   430: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   433: aload_1
    //   434: ldc_w 1008
    //   437: invokeinterface 947 2 0
    //   442: astore 4
    //   444: aload 4
    //   446: ifnull +42 -> 488
    //   449: aload 4
    //   451: invokeinterface 952 1 0
    //   456: ifle +32 -> 488
    //   459: aload_2
    //   460: aload_1
    //   461: ldc_w 1008
    //   464: invokeinterface 947 2 0
    //   469: iconst_0
    //   470: invokeinterface 958 2 0
    //   475: invokeinterface 964 1 0
    //   480: invokeinterface 967 1 0
    //   485: invokevirtual 1011	com/tencent/mobileqq/config/operation/QQOperationViopTipTask:setBeginTime	(Ljava/lang/String;)V
    //   488: aload_1
    //   489: ldc_w 1013
    //   492: invokeinterface 947 2 0
    //   497: astore 4
    //   499: aload 4
    //   501: ifnull +42 -> 543
    //   504: aload 4
    //   506: invokeinterface 952 1 0
    //   511: ifle +32 -> 543
    //   514: aload_2
    //   515: aload_1
    //   516: ldc_w 1013
    //   519: invokeinterface 947 2 0
    //   524: iconst_0
    //   525: invokeinterface 958 2 0
    //   530: invokeinterface 964 1 0
    //   535: invokeinterface 967 1 0
    //   540: invokevirtual 1016	com/tencent/mobileqq/config/operation/QQOperationViopTipTask:setEndTime	(Ljava/lang/String;)V
    //   543: aload_1
    //   544: ldc_w 1018
    //   547: invokeinterface 947 2 0
    //   552: astore 4
    //   554: aload 4
    //   556: ifnull +50 -> 606
    //   559: aload 4
    //   561: invokeinterface 952 1 0
    //   566: ifle +40 -> 606
    //   569: aload_1
    //   570: ldc_w 1018
    //   573: invokeinterface 947 2 0
    //   578: iconst_0
    //   579: invokeinterface 958 2 0
    //   584: invokeinterface 964 1 0
    //   589: invokeinterface 967 1 0
    //   594: invokestatic 143	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   597: iconst_1
    //   598: if_icmpne +697 -> 1295
    //   601: aload_2
    //   602: iload_3
    //   603: putfield 1021	com/tencent/mobileqq/config/operation/QQOperationViopTipTask:uinType	I
    //   606: aload_1
    //   607: ldc_w 1023
    //   610: invokeinterface 947 2 0
    //   615: astore 4
    //   617: aload 4
    //   619: ifnull +197 -> 816
    //   622: aload 4
    //   624: invokeinterface 952 1 0
    //   629: ifle +187 -> 816
    //   632: aload_1
    //   633: ldc_w 1023
    //   636: invokeinterface 947 2 0
    //   641: iconst_0
    //   642: invokeinterface 958 2 0
    //   647: checkcast 1025	org/w3c/dom/Element
    //   650: ldc_w 1027
    //   653: invokeinterface 1028 2 0
    //   658: astore 4
    //   660: aload 4
    //   662: ifnull +62 -> 724
    //   665: aload 4
    //   667: invokeinterface 952 1 0
    //   672: ifle +52 -> 724
    //   675: aload_2
    //   676: aload_1
    //   677: ldc_w 1023
    //   680: invokeinterface 947 2 0
    //   685: iconst_0
    //   686: invokeinterface 958 2 0
    //   691: checkcast 1025	org/w3c/dom/Element
    //   694: ldc_w 1027
    //   697: invokeinterface 1028 2 0
    //   702: iconst_0
    //   703: invokeinterface 958 2 0
    //   708: invokeinterface 964 1 0
    //   713: invokeinterface 967 1 0
    //   718: invokestatic 143	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   721: putfield 1031	com/tencent/mobileqq/config/operation/QQOperationViopTipTask:frequencyTime	I
    //   724: aload_1
    //   725: ldc_w 1023
    //   728: invokeinterface 947 2 0
    //   733: iconst_0
    //   734: invokeinterface 958 2 0
    //   739: checkcast 1025	org/w3c/dom/Element
    //   742: ldc_w 1033
    //   745: invokeinterface 1028 2 0
    //   750: astore 4
    //   752: aload 4
    //   754: ifnull +62 -> 816
    //   757: aload 4
    //   759: invokeinterface 952 1 0
    //   764: ifle +52 -> 816
    //   767: aload_2
    //   768: aload_1
    //   769: ldc_w 1023
    //   772: invokeinterface 947 2 0
    //   777: iconst_0
    //   778: invokeinterface 958 2 0
    //   783: checkcast 1025	org/w3c/dom/Element
    //   786: ldc_w 1033
    //   789: invokeinterface 1028 2 0
    //   794: iconst_0
    //   795: invokeinterface 958 2 0
    //   800: invokeinterface 964 1 0
    //   805: invokeinterface 967 1 0
    //   810: invokestatic 143	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   813: putfield 1036	com/tencent/mobileqq/config/operation/QQOperationViopTipTask:frequencyMessage	I
    //   816: aload_1
    //   817: ldc_w 1038
    //   820: invokeinterface 947 2 0
    //   825: astore 4
    //   827: aload 4
    //   829: ifnull +464 -> 1293
    //   832: aload 4
    //   834: invokeinterface 952 1 0
    //   839: ifle +454 -> 1293
    //   842: aload_1
    //   843: ldc_w 1038
    //   846: invokeinterface 947 2 0
    //   851: iconst_0
    //   852: invokeinterface 958 2 0
    //   857: checkcast 1025	org/w3c/dom/Element
    //   860: ldc_w 1040
    //   863: invokeinterface 1028 2 0
    //   868: astore 4
    //   870: aload 4
    //   872: ifnull +62 -> 934
    //   875: aload 4
    //   877: invokeinterface 952 1 0
    //   882: ifle +52 -> 934
    //   885: aload_2
    //   886: aload_1
    //   887: ldc_w 1038
    //   890: invokeinterface 947 2 0
    //   895: iconst_0
    //   896: invokeinterface 958 2 0
    //   901: checkcast 1025	org/w3c/dom/Element
    //   904: ldc_w 1040
    //   907: invokeinterface 1028 2 0
    //   912: iconst_0
    //   913: invokeinterface 958 2 0
    //   918: invokeinterface 964 1 0
    //   923: invokeinterface 967 1 0
    //   928: invokestatic 143	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   931: putfield 1043	com/tencent/mobileqq/config/operation/QQOperationViopTipTask:tipType	I
    //   934: aload_1
    //   935: ldc_w 1038
    //   938: invokeinterface 947 2 0
    //   943: iconst_0
    //   944: invokeinterface 958 2 0
    //   949: checkcast 1025	org/w3c/dom/Element
    //   952: ldc_w 1033
    //   955: invokeinterface 1028 2 0
    //   960: astore 4
    //   962: aload 4
    //   964: ifnull +59 -> 1023
    //   967: aload 4
    //   969: invokeinterface 952 1 0
    //   974: ifle +49 -> 1023
    //   977: aload_2
    //   978: aload_1
    //   979: ldc_w 1038
    //   982: invokeinterface 947 2 0
    //   987: iconst_0
    //   988: invokeinterface 958 2 0
    //   993: checkcast 1025	org/w3c/dom/Element
    //   996: ldc_w 1033
    //   999: invokeinterface 1028 2 0
    //   1004: iconst_0
    //   1005: invokeinterface 958 2 0
    //   1010: invokeinterface 964 1 0
    //   1015: invokeinterface 967 1 0
    //   1020: putfield 1046	com/tencent/mobileqq/config/operation/QQOperationViopTipTask:adwords	Ljava/lang/String;
    //   1023: aload_1
    //   1024: ldc_w 1038
    //   1027: invokeinterface 947 2 0
    //   1032: iconst_0
    //   1033: invokeinterface 958 2 0
    //   1038: checkcast 1025	org/w3c/dom/Element
    //   1041: ldc_w 1048
    //   1044: invokeinterface 1028 2 0
    //   1049: astore 4
    //   1051: aload 4
    //   1053: ifnull +62 -> 1115
    //   1056: aload 4
    //   1058: invokeinterface 952 1 0
    //   1063: ifle +52 -> 1115
    //   1066: aload_2
    //   1067: aload_1
    //   1068: ldc_w 1038
    //   1071: invokeinterface 947 2 0
    //   1076: iconst_0
    //   1077: invokeinterface 958 2 0
    //   1082: checkcast 1025	org/w3c/dom/Element
    //   1085: ldc_w 1048
    //   1088: invokeinterface 1028 2 0
    //   1093: iconst_0
    //   1094: invokeinterface 958 2 0
    //   1099: invokeinterface 964 1 0
    //   1104: invokeinterface 967 1 0
    //   1109: invokestatic 143	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   1112: putfield 1051	com/tencent/mobileqq/config/operation/QQOperationViopTipTask:linkOffset	I
    //   1115: aload_1
    //   1116: ldc_w 1038
    //   1119: invokeinterface 947 2 0
    //   1124: iconst_0
    //   1125: invokeinterface 958 2 0
    //   1130: checkcast 1025	org/w3c/dom/Element
    //   1133: ldc_w 1053
    //   1136: invokeinterface 1028 2 0
    //   1141: astore 4
    //   1143: aload 4
    //   1145: ifnull +59 -> 1204
    //   1148: aload 4
    //   1150: invokeinterface 952 1 0
    //   1155: ifle +49 -> 1204
    //   1158: aload_2
    //   1159: aload_1
    //   1160: ldc_w 1038
    //   1163: invokeinterface 947 2 0
    //   1168: iconst_0
    //   1169: invokeinterface 958 2 0
    //   1174: checkcast 1025	org/w3c/dom/Element
    //   1177: ldc_w 1053
    //   1180: invokeinterface 1028 2 0
    //   1185: iconst_0
    //   1186: invokeinterface 958 2 0
    //   1191: invokeinterface 964 1 0
    //   1196: invokeinterface 967 1 0
    //   1201: putfield 1056	com/tencent/mobileqq/config/operation/QQOperationViopTipTask:clickableWord	Ljava/lang/String;
    //   1204: aload_1
    //   1205: ldc_w 1038
    //   1208: invokeinterface 947 2 0
    //   1213: iconst_0
    //   1214: invokeinterface 958 2 0
    //   1219: checkcast 1025	org/w3c/dom/Element
    //   1222: ldc_w 781
    //   1225: invokeinterface 1028 2 0
    //   1230: astore 4
    //   1232: aload 4
    //   1234: ifnull +59 -> 1293
    //   1237: aload 4
    //   1239: invokeinterface 952 1 0
    //   1244: ifle +49 -> 1293
    //   1247: aload_2
    //   1248: aload_1
    //   1249: ldc_w 1038
    //   1252: invokeinterface 947 2 0
    //   1257: iconst_0
    //   1258: invokeinterface 958 2 0
    //   1263: checkcast 1025	org/w3c/dom/Element
    //   1266: ldc_w 781
    //   1269: invokeinterface 1028 2 0
    //   1274: iconst_0
    //   1275: invokeinterface 958 2 0
    //   1280: invokeinterface 964 1 0
    //   1285: invokeinterface 967 1 0
    //   1290: putfield 1058	com/tencent/mobileqq/config/operation/QQOperationViopTipTask:url	Ljava/lang/String;
    //   1293: aload_2
    //   1294: areturn
    //   1295: sipush 3000
    //   1298: istore_3
    //   1299: goto -698 -> 601
    //   1302: astore_1
    //   1303: aload_1
    //   1304: invokevirtual 1059	javax/xml/parsers/ParserConfigurationException:printStackTrace	()V
    //   1307: aconst_null
    //   1308: areturn
    //   1309: astore_1
    //   1310: aload_1
    //   1311: invokevirtual 1060	org/xml/sax/SAXException:printStackTrace	()V
    //   1314: goto -7 -> 1307
    //   1317: astore_1
    //   1318: aload_1
    //   1319: invokevirtual 1061	java/io/IOException:printStackTrace	()V
    //   1322: goto -15 -> 1307
    //   1325: astore_1
    //   1326: aload_1
    //   1327: invokevirtual 461	java/lang/Exception:printStackTrace	()V
    //   1330: goto -23 -> 1307
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1333	0	this	aqlw
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
      byte[] arrayOfByte = aocu.a((byte[])localObject);
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
        localObject2 = aocu.a((byte[])localObject1);
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
    //   0: getstatic 1177	cooperation/readinjoy/content/ReadInJoyDataProvider:e	Landroid/net/Uri;
    //   3: invokevirtual 1183	android/net/Uri:buildUpon	()Landroid/net/Uri$Builder;
    //   6: astore 5
    //   8: aload 5
    //   10: ldc_w 1185
    //   13: getstatic 15	aqlw:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   16: invokevirtual 1191	android/net/Uri$Builder:appendQueryParameter	(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;
    //   19: pop
    //   20: aload 5
    //   22: invokevirtual 1195	android/net/Uri$Builder:build	()Landroid/net/Uri;
    //   25: astore 5
    //   27: new 1197	android/content/ContentValues
    //   30: dup
    //   31: invokespecial 1198	android/content/ContentValues:<init>	()V
    //   34: astore 6
    //   36: aload 6
    //   38: ldc_w 1200
    //   41: iload_1
    //   42: invokestatic 307	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   45: invokevirtual 1204	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   48: aload 6
    //   50: ldc_w 1206
    //   53: aload_2
    //   54: invokevirtual 1209	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   57: aload 6
    //   59: ldc_w 1211
    //   62: aload_3
    //   63: invokevirtual 1209	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   66: ldc_w 1213
    //   69: iconst_2
    //   70: anewarray 303	java/lang/Object
    //   73: dup
    //   74: iconst_0
    //   75: ldc_w 1206
    //   78: aastore
    //   79: dup
    //   80: iconst_1
    //   81: aload_2
    //   82: aastore
    //   83: invokestatic 311	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   86: astore_2
    //   87: aload 4
    //   89: invokevirtual 65	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   92: invokevirtual 1217	com/tencent/qphone/base/util/BaseApplication:getContentResolver	()Landroid/content/ContentResolver;
    //   95: aload 5
    //   97: aconst_null
    //   98: aload_2
    //   99: aconst_null
    //   100: aconst_null
    //   101: invokevirtual 1223	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   104: astore_2
    //   105: aload_2
    //   106: ifnull +148 -> 254
    //   109: aload_2
    //   110: invokeinterface 1228 1 0
    //   115: ifle +61 -> 176
    //   118: aload 4
    //   120: invokevirtual 65	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   123: invokevirtual 1217	com/tencent/qphone/base/util/BaseApplication:getContentResolver	()Landroid/content/ContentResolver;
    //   126: aload 5
    //   128: aload 6
    //   130: aconst_null
    //   131: aconst_null
    //   132: invokevirtual 1232	android/content/ContentResolver:update	(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   135: pop
    //   136: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   139: ifeq +12 -> 151
    //   142: ldc 183
    //   144: iconst_2
    //   145: ldc_w 1234
    //   148: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   151: aload 4
    //   153: invokevirtual 65	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   156: invokevirtual 1217	com/tencent/qphone/base/util/BaseApplication:getContentResolver	()Landroid/content/ContentResolver;
    //   159: aload 5
    //   161: aconst_null
    //   162: invokevirtual 1238	android/content/ContentResolver:notifyChange	(Landroid/net/Uri;Landroid/database/ContentObserver;)V
    //   165: aload_2
    //   166: ifnull +9 -> 175
    //   169: aload_2
    //   170: invokeinterface 1239 1 0
    //   175: return
    //   176: aload 4
    //   178: invokevirtual 65	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   181: invokevirtual 1217	com/tencent/qphone/base/util/BaseApplication:getContentResolver	()Landroid/content/ContentResolver;
    //   184: aload 5
    //   186: aload 6
    //   188: invokevirtual 1243	android/content/ContentResolver:insert	(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    //   191: pop
    //   192: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   195: ifeq -44 -> 151
    //   198: ldc 183
    //   200: iconst_2
    //   201: ldc_w 1245
    //   204: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   207: goto -56 -> 151
    //   210: astore_3
    //   211: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   214: ifeq +29 -> 243
    //   217: ldc 183
    //   219: iconst_2
    //   220: new 85	java/lang/StringBuilder
    //   223: dup
    //   224: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   227: ldc_w 1247
    //   230: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   233: aload_3
    //   234: invokevirtual 800	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   237: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   240: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   243: aload_2
    //   244: ifnull -69 -> 175
    //   247: aload_2
    //   248: invokeinterface 1239 1 0
    //   253: return
    //   254: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   257: ifeq -106 -> 151
    //   260: ldc 183
    //   262: iconst_2
    //   263: ldc_w 1249
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
    //   284: invokeinterface 1239 1 0
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
    //   0	313	0	this	aqlw
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
    NewIntent localNewIntent = new NewIntent(paramQQAppInterface.getApp(), aqlw.class);
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
            if (apub.a().b(i1))
            {
              localObject2 = apub.a();
              localObject7 = ((apub)localObject2).a(i1);
              i = j;
              if (localObject7 != null)
              {
                i = ((aptq)localObject7).onSend(((apub)localObject2).a(i1, jdField_a_of_type_JavaLangString));
                bool = ((apub)localObject2).a(paramQQAppInterface, i1);
                if (bool)
                {
                  ((apub)localObject2).a(i1, 0);
                  i = 0;
                }
                if (QLog.isColorLevel()) {
                  QLog.d("QConfigManager", 2, "[Send] t=" + i1 + " v=" + i + " up=" + bool);
                }
                localConfigSeq.version.set(i);
                if (!((apub)localObject2).a(i1)) {
                  break label9204;
                }
                localConfigSeq.compress.set(1);
                break label9204;
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
            label3458:
            int i2;
            QLog.d("QConfigManager", 1, "exception " + i1, localException2);
            continue;
          }
          localArrayList1.add(localConfigSeq);
          localArrayList2.add(Integer.valueOf(i1));
          k += 1;
          break;
          localConfigSeq.version.set(bfyz.c(paramQQAppInterface.getApp()));
          continue;
          localConfigSeq.version.set(bfyz.g(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
          continue;
          bfyz.a(paramQQAppInterface.getApplication(), paramQQAppInterface.getCurrentAccountUin());
          if (paramQQAppInterface.getCurrentAccountUin() != null)
          {
            jdField_b_of_type_JavaLangString = paramQQAppInterface.getCurrentNickname();
            localObject2 = bfrj.a(paramQQAppInterface, paramQQAppInterface.getCurrentAccountUin());
            if (localObject2 != null)
            {
              if (QLog.isColorLevel()) {
                QLog.i("SPLASH_ConfigServlet_birth", 2, "card!=null");
              }
              j = (int)((Card)localObject2).lBirthday;
              i = bbnp.a(j);
              j = bbnp.b(j);
              bfyz.b(paramQQAppInterface.getApp(), a(i, j));
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
            localConfigSeq.version.set(bfyz.h(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
            continue;
            localObject2 = (aqmg)paramQQAppInterface.getManager(74);
            localConfigSeq.version.set(((aqmg)localObject2).a());
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
            localConfigSeq.version.set(bfyz.i(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin()));
            continue;
            localConfigSeq.version.set(bfyz.j(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin()));
            continue;
            localConfigSeq.version.set(bfyz.b(paramQQAppInterface.getApp()));
            continue;
            localConfigSeq.version.set(PatchSharedPreUtil.getPatchConfigVersion(paramQQAppInterface.getApp()));
            localConfigSeq.compress.set(1);
            continue;
            BridgeHelper.a(BaseApplication.getContext(), jdField_a_of_type_JavaLangString).a();
            localConfigSeq.version.set(bfyz.a(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount()));
            continue;
            i = aqmy.a(BaseApplicationImpl.getContext());
            if (SettingCloneUtil.readValueForInt(BaseApplicationImpl.getContext(), jdField_a_of_type_JavaLangString, null, "qqsetting_calltab_show_key_version", 0) < i)
            {
              localConfigSeq.version.set(0);
            }
            else
            {
              localConfigSeq.version.set(bfyz.l(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount()));
              continue;
              i = aqmy.a(BaseApplicationImpl.getContext());
              if (SettingCloneUtil.readValueForInt(BaseApplicationImpl.getContext(), jdField_a_of_type_JavaLangString, null, "qqsetting_calltab_show_key_version", 0) < i)
              {
                localConfigSeq.version.set(0);
                paramIntent.putExtra("update101Version", i);
              }
              else
              {
                localConfigSeq.version.set(bfyz.k(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount()));
                continue;
                localObject2 = (aihp)paramQQAppInterface.getManager(102);
                localConfigSeq.version.set(((aihp)localObject2).a());
                continue;
                localConfigSeq.version.set(bfyz.o(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
                continue;
                localConfigSeq.version.set(bfyz.p(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
                continue;
                localConfigSeq.version.set(bfyz.e(paramQQAppInterface.getApp()));
                continue;
                localConfigSeq.version.set(bfyz.q(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
                continue;
                localConfigSeq.version.set(bfyz.r(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
                continue;
                if (!PtvTemplateManager.a())
                {
                  localConfigSeq.version.set(0);
                }
                else
                {
                  localConfigSeq.version.set(bfyz.g(paramQQAppInterface.getApp()));
                  continue;
                  if (!PtvTemplateManager.b())
                  {
                    localConfigSeq.version.set(0);
                    localConfigSeq.compress.set(1);
                  }
                  else
                  {
                    localConfigSeq.version.set(bfyz.i(paramQQAppInterface.getApp()));
                    continue;
                    if (!azzx.a())
                    {
                      localConfigSeq.version.set(0);
                      localConfigSeq.compress.set(1);
                    }
                    else
                    {
                      localConfigSeq.version.set(bfyz.h(paramQQAppInterface.getApp()));
                      continue;
                      i = 0;
                      if (PtvTemplateManager.c()) {
                        i = bfyz.j(paramQQAppInterface.getApp());
                      }
                      localConfigSeq.version.set(i);
                      localConfigSeq.compress.set(1);
                      if (QLog.isDevelopLevel())
                      {
                        QLog.d("Doodle_Strokes_SPLASH_ConfigServlet", 4, String.format("个性笔触配置版本号[%s]", new Object[] { Integer.valueOf(i) }));
                        continue;
                        i = bfyz.E(paramQQAppInterface.getApp());
                        localConfigSeq.version.set(i);
                        localConfigSeq.compress.set(1);
                        if (QLog.isDevelopLevel())
                        {
                          QLog.d("QQSTORY_FOLLOW_CAPTURE_SPLASH_ConfigServlet", 4, String.format("日迹合拍版本号[%s]", new Object[] { Integer.valueOf(i) }));
                          continue;
                          i = bfyz.aQ(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
                          localConfigSeq.version.set(i);
                          localConfigSeq.compress.set(1);
                          if (QLog.isDevelopLevel())
                          {
                            QLog.d("QQSTORY_QUESTION_TAB_SPLASH_ConfigServlet", 4, String.format("日迹问答版本号[%s]", new Object[] { Integer.valueOf(i) }));
                            continue;
                            BusinessCommonConfig.getInstance(paramQQAppInterface).fillConfigVersion(i1, localConfigSeq);
                            continue;
                            localConfigSeq.version.set(bfyz.b(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount()));
                            continue;
                            localConfigSeq.version.set(bfyz.c(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount()));
                            continue;
                            localConfigSeq.version.set(bfyz.m(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
                            continue;
                            localConfigSeq.version.set(bfyz.n(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
                            continue;
                            localConfigSeq.version.set(bfyz.d(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
                            continue;
                            localConfigSeq.version.set(bfyz.G(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
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
                            bool = aaxd.a();
                            if (QLog.isColorLevel()) {
                              QLog.d("SPLASH_ConfigServlet", 2, "addAllConfigs, support ble=" + bool);
                            }
                            if (bool)
                            {
                              localConfigSeq.version.set(bfyz.e(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
                              continue;
                              bool = aaxd.a();
                              if (QLog.isColorLevel()) {
                                QLog.d("SPLASH_ConfigServlet", 2, "addAllConfigs, support ble=" + bool);
                              }
                              if (bool)
                              {
                                localConfigSeq.version.set(bfyz.f(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
                                continue;
                                localConfigSeq.version.set(bfyz.r(paramQQAppInterface.getApp()));
                                continue;
                                i = bfyz.x(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
                                j = AppSetting.a();
                                if (i != j)
                                {
                                  bfyz.i(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, 0);
                                  bfyz.k(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, j);
                                  SearchConfigManager.a(paramQQAppInterface, jdField_a_of_type_JavaLangString);
                                }
                                localConfigSeq.version.set(bfyz.w(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
                                continue;
                                localConfigSeq.version.set(bfyz.H(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
                                continue;
                                localConfigSeq.version.set(bfyz.f(paramQQAppInterface.getApp()));
                                localConfigSeq.compress.set(1);
                                continue;
                                localConfigSeq.version.set(bfyz.s(paramQQAppInterface.getApp()));
                                continue;
                                localConfigSeq.version.set(bfyz.t(paramQQAppInterface.getApp()));
                                continue;
                                localConfigSeq.version.set(bfyz.u(paramQQAppInterface.getApp()));
                                continue;
                                localConfigSeq.version.set(bfyz.v(paramQQAppInterface.getApp()));
                                continue;
                                localConfigSeq.version.set(bfyz.A(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
                                continue;
                                localConfigSeq.version.set(bfyz.L(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentUin()));
                                continue;
                                localConfigSeq.version.set(bfyz.w(paramQQAppInterface.getApp()));
                                continue;
                                i = bfyz.B(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
                                localConfigSeq.version.set(i);
                                continue;
                                localConfigSeq.version.set(((amvo)paramQQAppInterface.getManager(159)).b());
                                continue;
                                i = bfyz.C(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
                                if (bfyz.y(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount()) != AppSetting.a()) {
                                  i = 0;
                                }
                                localConfigSeq.version.set(i);
                                continue;
                                localObject2 = (bjni)paramQQAppInterface.getBusinessHandler(146);
                                i = ((bjni)localObject2).b(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
                                j = ((bjni)localObject2).a(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
                                m = AppSetting.a();
                                if (j != m)
                                {
                                  i = 0;
                                  QLog.i("NCtr", 1, String.format("request NOTIFICATION_LIMIT_CONFIG localVersion: %d ,originalAppId:%d, currentAppId:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(m) }));
                                  localConfigSeq.version.set(i);
                                  continue;
                                  i = bfyz.av(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
                                  if (bfyz.aw(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount()) != AppSetting.a()) {
                                    i = 0;
                                  }
                                  localConfigSeq.version.set(i);
                                  continue;
                                  i = bfyz.ax(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
                                  if (bfyz.ay(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount()) != AppSetting.a()) {
                                    i = 0;
                                  }
                                  localConfigSeq.version.set(i);
                                  continue;
                                  localObject1 = DeviceProfileManager.a(paramQQAppInterface);
                                  continue;
                                  localConfigSeq.version.set(bfyz.F(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
                                  continue;
                                  localConfigSeq.version.set(ayjo.a(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
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
                                  localConfigSeq.version.set(bfyz.n(paramQQAppInterface.getApp()));
                                  continue;
                                  localConfigSeq.version.set(bfyz.o(paramQQAppInterface.getApp()));
                                  continue;
                                  localConfigSeq.version.set(bfyz.M(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin()));
                                  continue;
                                  localConfigSeq.version.set(bfyz.P(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
                                  continue;
                                  localConfigSeq.version.set(bfyz.K(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin()));
                                  continue;
                                  localConfigSeq.version.set(bfyz.a(paramQQAppInterface.getApp(), "shop_tab", jdField_a_of_type_JavaLangString));
                                  continue;
                                  localObject2 = (OlympicManager)paramQQAppInterface.getManager(167);
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
                                  if (!axsb.a(BaseApplicationImpl.getContext(), "olympic_config_act_get")) {
                                    continue;
                                  }
                                  if (QLog.isColorLevel()) {
                                    QLog.d("Olympic.configServlet", 2, new Object[] { "check24Hour, result=true, do Report, key=", "olympic_config_act_get" });
                                  }
                                  StatisticCollector.getInstance(BaseApplicationImpl.getContext()).collectPerformance("", "olympic_config_act_get", true, 0L, 0L, null, "", false);
                                  axsb.a(BaseApplicationImpl.getContext(), "olympic_config_act_get");
                                  continue;
                                  localObject2 = (aodg)paramQQAppInterface.getManager(168);
                                  if (localObject2 == null) {
                                    continue;
                                  }
                                  i2 = ((aodg)localObject2).b();
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
            m = ((aodg)localObject2).a();
            if ((m == 0) || (i3 != m)) {
              break label9210;
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
          Object localObject3 = (anyd)paramQQAppInterface.getManager(220);
          if (localObject3 == null) {
            break;
          }
          i = ((anyd)localObject3).b();
          if (QLog.isColorLevel()) {
            QLog.d("handleResp_GetArGlobalConfig", 2, " local version = " + i);
          }
          if (((anyd)localObject3).a()) {
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
          localObject3 = (anyd)paramQQAppInterface.getManager(220);
          if (localObject3 == null) {
            break;
          }
          i = ((anyd)localObject3).c();
          localConfigSeq.version.set(i);
          localConfigSeq.compress.set(1);
          paramIntent.putExtra("ar_scan_star_face_config_version", i);
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("SPLASH_ConfigServlet", 2, " get AR_SCAN_STAR_FACE_CONFIG, version = " + i);
          break;
          i = aodk.a(paramQQAppInterface);
          localConfigSeq.version.set(i);
          localConfigSeq.compress.set(1);
          paramIntent.putExtra("key_download_cfg_version", i);
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("SPLASH_ConfigServlet", 2, " get AR_SCAN_FACE_PRE_DOWN_CONFIG, version = " + i);
          break;
          localObject3 = (aodg)paramQQAppInterface.getManager(168);
          if (localObject3 == null) {
            break;
          }
          i = ((aodg)localObject3).c();
          localConfigSeq.version.set(i);
          localConfigSeq.compress.set(1);
          paramIntent.putExtra("key_ar_entrance_effect_version", i);
          break;
          i = bfyz.a(paramQQAppInterface.getApp(), "readinjoy_interested_push_config", jdField_a_of_type_JavaLangString);
          localConfigSeq.version.set(i);
          break;
          localObject3 = (PhoneContactManagerImp)paramQQAppInterface.getManager(11);
          localConfigSeq.version.set(((PhoneContactManagerImp)localObject3).e());
          break;
          lbs.a(i1, jdField_a_of_type_JavaLangString, localConfigSeq);
          break;
          i = apju.a(BaseApplicationImpl.getContext());
          localConfigSeq.version.set(i);
          localConfigSeq.compress.set(1);
          paramIntent.putExtra("qcamera_conf_version", i);
          paramIntent.putExtra("uin", paramQQAppInterface.getCurrentAccountUin());
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.i("Q.camera.configServlet", 2, "request QCAMERA_PHONE_CONFIG version: " + i);
          break;
          i = bfyz.I(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
          if (QLog.isColorLevel()) {
            QLog.d("SPLASH_ConfigServlet", 2, "addAllConfigs|GET_CONFIG_UPGRADE version=" + i);
          }
          localConfigSeq.version.set(i);
          paramQQAppInterface.getPreloadSwitch();
          biar.a(paramQQAppInterface.getApp(), String.valueOf(AppSetting.a()));
          ((ampt)paramQQAppInterface.getBusinessHandler(4)).c();
          break;
          i = bfyz.J(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
          localConfigSeq.version.set(i);
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("UpgradeTIMWrapper", 2, "ConfigServlet req :193, version: " + i);
          break;
          i = bfyz.a(paramQQAppInterface.getApp(), "now_entrance_action_version", jdField_a_of_type_JavaLangString);
          localConfigSeq.version.set(i);
          break;
          i = bfyz.a(paramQQAppInterface.getApp(), "troop_common_config_version", jdField_a_of_type_JavaLangString);
          localConfigSeq.version.set(i);
          break;
          i = bfyz.a(paramQQAppInterface.getApp(), "nearby_config_version", jdField_a_of_type_JavaLangString);
          localConfigSeq.version.set(i);
          break;
          i = bfyz.a(paramQQAppInterface.getApp(), "nearby_nowlive_tab_config_version", jdField_a_of_type_JavaLangString);
          localConfigSeq.version.set(i);
          break;
          localConfigSeq.version.set(bfyz.Q(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount()));
          localConfigSeq.compress.set(1);
          break;
          localObject3 = (amoa)paramQQAppInterface.getBusinessHandler(53);
          if (localObject3 == null) {
            break;
          }
          i = AppSetting.a();
          if (i != ((amoa)localObject3).b(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString))
          {
            ((amoa)localObject3).a(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, 0);
            ((amoa)localObject3).b(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, i);
            ((amoa)localObject3).a(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, true);
            ((amoa)localObject3).c();
          }
          localConfigSeq.version.set(((amoa)localObject3).a(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
          break;
          localConfigSeq.version.set(bfyz.S(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
          localConfigSeq.version.set(bfyz.T(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
          localConfigSeq.compress.set(1);
          break;
          localConfigSeq.version.set(bfyz.D(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
          break;
          localConfigSeq.version.set(bbgh.a());
          break;
          i = bass.a(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin());
          localConfigSeq.version.set(i);
          break;
          i = bfyz.a(paramQQAppInterface.getApp(), "nearby_glamour_level_config_version", jdField_a_of_type_JavaLangString);
          localConfigSeq.version.set(i);
          localConfigSeq.compress.set(1);
          break;
          localConfigSeq.version.set(bfyz.V(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
          break;
          if (bfyz.a(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, 1) != AppSetting.a())
          {
            bfyz.d(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, 1, AppSetting.a());
            bfyz.d(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, 2, 0);
            localConfigSeq.version.set(0);
            break;
          }
          localConfigSeq.version.set(bfyz.a(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, 2));
          break;
          try
          {
            if (((Integer)bfyz.a(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, 1)).intValue() == AppSetting.a()) {
              break label5509;
            }
            bfyz.a(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, 1, Integer.valueOf(AppSetting.a()));
            bfyz.a(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, 2, Integer.valueOf(0));
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
        label5509:
        i = ((Integer)bfyz.a(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, 2)).intValue();
        localConfigSeq.version.set(i);
        break;
        localConfigSeq.version.set(bfyz.Y(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
        break;
        if (!PtvTemplateManager.d()) {
          localConfigSeq.version.set(0);
        }
        for (;;)
        {
          localConfigSeq.compress.set(1);
          break;
          localConfigSeq.version.set(bfyz.l(paramQQAppInterface.getApp()));
        }
        localConfigSeq.version.set(bfyz.W(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
        break;
        localConfigSeq.version.set(bfyz.ac(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
        localConfigSeq.compress.set(1);
        break;
        localConfigSeq.version.set(bfyz.ae(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
        localConfigSeq.compress.set(1);
        break;
        Object localObject4 = (ynq)paramQQAppInterface.getManager(208);
        localConfigSeq.version.set(((ynq)localObject4).a.a(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
        break;
        localConfigSeq.version.set(bfyz.aa(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
        localConfigSeq.compress.set(1);
        break;
        localConfigSeq.version.set(uex.c(paramQQAppInterface));
        break;
        localConfigSeq.version.set(bfyz.ab(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
        break;
        i = bfyz.am(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
        j = AppSetting.a();
        if (i != j)
        {
          bfyz.J(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, 0);
          bfyz.K(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, j);
        }
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("SPLASH_ConfigServlet", 2, "[Doutu]onsend : appIdRecord = " + i + ", appId = " + j + ", DOUTU_CONFI version = " + bfyz.aj(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
          }
          localConfigSeq.version.set(bfyz.aj(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
          localConfigSeq.compress.set(1);
          break;
          localObject4 = (aqwg)getAppRuntime().getManager(214);
          if (localObject4 != null) {
            ((aqwg)localObject4).b(false);
          }
        }
        i = bfyz.s(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
        j = AppSetting.a();
        if (i != j)
        {
          bfyz.f(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, 0);
          bfyz.e(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, j);
        }
        if (QLog.isColorLevel()) {
          QLog.d("SPLASH_ConfigServlet", 2, "[GreenVideo]onsend : appIdRecord = " + i + ", appId = " + j + ", GREEN_VIDEO_CONFI version = " + bfyz.t(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
        }
        localConfigSeq.version.set(bfyz.t(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
        localConfigSeq.compress.set(1);
        break;
        i = bfyz.u(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
        j = AppSetting.a();
        if (i != j)
        {
          bfyz.h(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, 0);
          bfyz.g(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, j);
        }
        if (QLog.isColorLevel()) {
          QLog.d("SPLASH_ConfigServlet", 2, "[VideoCompress]onsend : appIdRecord = " + i + ", appId = " + j + ", VIDEO_REDBAG_CONFI version = " + bfyz.ao(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
        }
        localConfigSeq.version.set(bfyz.v(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
        localConfigSeq.compress.set(1);
        break;
        if (((Integer)awka.a(jdField_a_of_type_JavaLangString, "key_app_id", Integer.valueOf(0))).intValue() != AppSetting.a())
        {
          awka.a(jdField_a_of_type_JavaLangString, "key_tabs_config_version", Integer.valueOf(0));
          awka.a(jdField_a_of_type_JavaLangString, "key_app_id", Integer.valueOf(AppSetting.a()));
        }
        i = ((Integer)awka.a(jdField_a_of_type_JavaLangString, "key_tabs_config_version", Integer.valueOf(0))).intValue();
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
        i = zsm.a(jdField_a_of_type_JavaLangString);
        localConfigSeq.version.set(i);
        localConfigSeq.compress.set(1);
        break;
        localConfigSeq.version.set(bcmt.a(paramQQAppInterface));
        localConfigSeq.compress.set(1);
        break;
        localConfigSeq.version.set(bfyz.ah(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
        localConfigSeq.compress.set(1);
        break;
        localConfigSeq.version.set(bfyz.ad(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
        localConfigSeq.compress.set(1);
        break;
        localConfigSeq.version.set(ahbd.a(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
        localConfigSeq.compress.set(1);
        break;
        i = bfyz.a(paramQQAppInterface.getApp(), "change_machine_version", jdField_a_of_type_JavaLangString);
        localConfigSeq.version.set(i);
        break;
        i = bfyz.a(paramQQAppInterface.getApp(), "nearby_auth_video_config_version", jdField_a_of_type_JavaLangString);
        localConfigSeq.version.set(i);
        break;
        localConfigSeq.version.set(bfyz.ar(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
        break;
        localConfigSeq.version.set(bfyz.y(paramQQAppInterface.getApp()));
        break;
        localConfigSeq.version.set(bfyz.as(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
        break;
        localConfigSeq.version.set(akus.a(paramQQAppInterface.getApp()));
        localConfigSeq.compress.set(1);
        break;
        localConfigSeq.version.set(baah.a(paramQQAppInterface.getApp()));
        localConfigSeq.compress.set(1);
        break;
        a((ConfigurationService.ReqGetConfig)localObject1, localConfigSeq, paramQQAppInterface);
        break;
        i = bfyz.a(paramQQAppInterface.getApp(), "search_function_config_version", jdField_a_of_type_JavaLangString);
        localConfigSeq.version.set(i);
        localConfigSeq.compress.set(1);
        break;
        i = ((axlb)paramQQAppInterface.getManager(228)).a();
        localConfigSeq.version.set(i);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("SPLASH_ConfigServlet", 2, "ConfigServlet OCR_CONFIG ocrVersion:" + i);
        break;
        i = bfyz.au(BaseApplicationImpl.getContext(), jdField_a_of_type_JavaLangString);
        localConfigSeq.version.set(i);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("SPLASH_ConfigServlet", 2, "ConfigServlet receipt ,receiptVersion:" + i);
        break;
        i = bfyz.aX(BaseApplicationImpl.getContext(), jdField_a_of_type_JavaLangString);
        localConfigSeq.version.set(i);
        break;
        i = bfyz.aY(BaseApplicationImpl.getContext(), jdField_a_of_type_JavaLangString);
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
        localObject4 = (arhi)paramQQAppInterface.getManager(264);
        try
        {
          ((arhi)localObject4).a();
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
      i = bbvz.a(paramQQAppInterface.getApp());
      localConfigSeq.version.set(i);
      localConfigSeq.compress.set(1);
      break label1593;
      i = paramQQAppInterface.getPreferences().getInt("data_migration_tim_version", 0);
      localConfigSeq.version.set(i);
      localConfigSeq.compress.set(1);
      break label1593;
      i = bfyz.a(paramQQAppInterface.getApp(), "nearby_videochat_dialog_config_version", jdField_a_of_type_JavaLangString);
      localConfigSeq.version.set(i);
      break label1593;
      i = bfyz.a(paramQQAppInterface.getApp(), "nearby_videochat_banner_config_version", jdField_a_of_type_JavaLangString);
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
      Object localObject5 = (TroopManager)paramQQAppInterface.getManager(52);
      localConfigSeq.version.set(((TroopManager)localObject5).jdField_a_of_type_Beir.a(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
      localConfigSeq.compress.set(1);
      break label1593;
      i = paramQQAppInterface.getPreferences().getInt("new_troop_recommend", 0);
      localConfigSeq.version.set(i);
      localConfigSeq.compress.set(1);
      break label1593;
      localObject5 = (TroopManager)paramQQAppInterface.getManager(52);
      localConfigSeq.version.set(((TroopManager)localObject5).jdField_a_of_type_Beky.a(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
      localConfigSeq.compress.set(1);
      break label1593;
      i = RecentDanceConfigMgr.a();
      localConfigSeq.version.set(i);
      localConfigSeq.compress.set(1);
      break label1593;
      i = audj.a().a.a();
      localConfigSeq.version.set(i);
      localConfigSeq.compress.set(1);
      break label1593;
      i = LightVideoConfigMgr.a();
      localConfigSeq.version.set(i);
      localConfigSeq.compress.set(1);
      break label1593;
      localConfigSeq.version.set(bfyz.a(paramQQAppInterface.getApp(), "sport_config", jdField_a_of_type_JavaLangString));
      localConfigSeq.compress.set(1);
      break label1593;
      i = bfyz.a(paramQQAppInterface.getApplication(), "troop_gift_anim_limit", "0");
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
      localConfigSeq.version.set(bfyz.aE(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
      break label1593;
      i = bfyz.aG(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
      if (bfyz.aH(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount()) != AppSetting.a()) {
        i = 0;
      }
      localConfigSeq.version.set(i);
      break label1593;
      i = bnxr.a().a(paramQQAppInterface.getApp());
      localConfigSeq.version.set(i);
      localConfigSeq.compress.set(1);
      break label1593;
      i = boaz.a().a(paramQQAppInterface.getApp());
      localConfigSeq.version.set(i);
      localConfigSeq.compress.set(1);
      break label1593;
      localObject5 = (vla)paramQQAppInterface.getManager(181);
      localConfigSeq.version.set(((vla)localObject5).a.a(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
      localConfigSeq.compress.set(1);
      break label1593;
      localConfigSeq.version.set(bfyz.a());
      localConfigSeq.compress.set(1);
      break label1593;
      i = bfyz.aI(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
      if (bfyz.aJ(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount()) != AppSetting.a()) {
        i = 0;
      }
      localConfigSeq.version.set(i);
      break label1593;
      localConfigSeq.version.set(bfyz.R(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount()));
      localConfigSeq.compress.set(1);
      break label1593;
      i = bfyz.a(paramQQAppInterface.getApp(), "wifi_connect_config_version", jdField_a_of_type_JavaLangString);
      localConfigSeq.version.set(i);
      break label1593;
      localObject5 = (TroopManager)paramQQAppInterface.getManager(52);
      localConfigSeq.version.set(((TroopManager)localObject5).jdField_a_of_type_Zsi.a(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
      localConfigSeq.compress.set(1);
      break label1593;
      i = bfyz.aR(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
      localConfigSeq.version.set(i);
      break label1593;
      localConfigSeq.version.set(bfyz.aA(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
      localConfigSeq.compress.set(1);
      break label1593;
      i = bfyz.aU(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
      if (bfyz.aV(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount()) != AppSetting.a()) {
        i = 0;
      }
      localConfigSeq.version.set(i);
      break label1593;
      i = bfwf.a();
      localConfigSeq.version.set(i);
      localConfigSeq.compress.set(1);
      if (!QLog.isColorLevel()) {
        break label1593;
      }
      QLog.i("JumpForwardPkgManager", 2, "JUMP_PKG_TOAST_CONFIG  ,version:" + i);
      break label1593;
      i = bkwl.a(paramQQAppInterface);
      localConfigSeq.version.set(i);
      localConfigSeq.compress.set(1);
      break label1593;
      i = ahns.a(paramQQAppInterface);
      localConfigSeq.version.set(i);
      localConfigSeq.compress.set(1);
      break label1593;
      localConfigSeq.version.set(((Integer)bfyz.a(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin(), "config_tim_team_version_code", Integer.valueOf(0))).intValue());
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
          break label9186;
        }
      }
      label9186:
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
      break label3458;
      label9204:
      i = 1;
      break;
      label9210:
      i = 1;
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig, int paramInt)
  {
    int i = paramConfig.version.get();
    int j = bkwl.a(paramQQAppInterface);
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
      bkwl.a(paramQQAppInterface, new JSONObject(paramConfig).optInt("hot_video_enable", 0));
      bkwl.b(paramQQAppInterface, i);
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
    NewIntent localNewIntent = new NewIntent(paramQQAppInterface.getApp(), aqlw.class);
    int[] arrayOfInt1 = a();
    int[] arrayOfInt2 = new int[jdField_a_of_type_ArrayOfInt.length + apub.jdField_a_of_type_ArrayOfInt.length + arrayOfInt1.length];
    System.arraycopy(jdField_a_of_type_ArrayOfInt, 0, arrayOfInt2, 0, jdField_a_of_type_ArrayOfInt.length);
    System.arraycopy(apub.jdField_a_of_type_ArrayOfInt, 0, arrayOfInt2, jdField_a_of_type_ArrayOfInt.length, apub.jdField_a_of_type_ArrayOfInt.length);
    System.arraycopy(arrayOfInt1, 0, arrayOfInt2, jdField_a_of_type_ArrayOfInt.length + apub.jdField_a_of_type_ArrayOfInt.length, arrayOfInt1.length);
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
        if ((paramInt == -1) || (bfyz.r(paramQQAppInterface.getApp()) != paramInt)) {
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
    //   4: getstatic 15	aqlw:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   7: invokestatic 2342	bfyz:ak	(Landroid/content/Context;Ljava/lang/String;)I
    //   10: invokestatic 204	com/tencent/common/config/AppSetting:a	()I
    //   13: if_icmpeq +114 -> 127
    //   16: aload_3
    //   17: invokevirtual 65	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   20: getstatic 15	aqlw:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   23: invokestatic 204	com/tencent/common/config/AppSetting:a	()I
    //   26: invokestatic 2344	bfyz:H	(Landroid/content/Context;Ljava/lang/String;I)V
    //   29: aload_3
    //   30: invokevirtual 65	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   33: getstatic 15	aqlw:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   36: iconst_0
    //   37: invokestatic 2346	bfyz:I	(Landroid/content/Context;Ljava/lang/String;I)V
    //   40: iconst_0
    //   41: istore 4
    //   43: aload_2
    //   44: getfield 1335	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$ConfigSeq:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   47: iload 4
    //   49: invokevirtual 1301	com/tencent/mobileqq/pb/PBInt32Field:set	(I)V
    //   52: invokestatic 2349	com/tencent/mobileqq/utils/DeviceInfoUtil:getCarrierList	()Ljava/util/ArrayList;
    //   55: astore 5
    //   57: aload 5
    //   59: ifnull +119 -> 178
    //   62: aload 5
    //   64: invokevirtual 2350	java/util/ArrayList:size	()I
    //   67: ifle +111 -> 178
    //   70: aload 5
    //   72: invokevirtual 2351	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   75: astore_2
    //   76: aload_2
    //   77: invokeinterface 240 1 0
    //   82: ifeq +96 -> 178
    //   85: aload_2
    //   86: invokeinterface 244 1 0
    //   91: checkcast 139	java/lang/Integer
    //   94: astore 6
    //   96: aload_1
    //   97: getfield 2354	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$ReqGetConfig:carriers	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   100: aload 6
    //   102: invokevirtual 2357	com/tencent/mobileqq/pb/PBRepeatField:add	(Ljava/lang/Object;)V
    //   105: goto -29 -> 76
    //   108: astore_1
    //   109: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   112: ifeq +14 -> 126
    //   115: ldc_w 2359
    //   118: iconst_2
    //   119: ldc_w 2361
    //   122: aload_1
    //   123: invokestatic 1850	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   126: return
    //   127: aload_3
    //   128: invokevirtual 65	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   131: getstatic 15	aqlw:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   134: invokestatic 2364	bfyz:al	(Landroid/content/Context;Ljava/lang/String;)I
    //   137: istore 4
    //   139: goto -96 -> 43
    //   142: astore_2
    //   143: ldc 183
    //   145: iconst_2
    //   146: new 85	java/lang/StringBuilder
    //   149: dup
    //   150: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   153: ldc_w 2366
    //   156: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: aload_2
    //   160: invokevirtual 871	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   163: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   169: invokestatic 644	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   172: aconst_null
    //   173: astore 5
    //   175: goto -118 -> 57
    //   178: aload_3
    //   179: bipush 11
    //   181: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   184: checkcast 2368	avsy
    //   187: invokeinterface 2371 1 0
    //   192: astore 6
    //   194: aload 6
    //   196: ifnull +229 -> 425
    //   199: aload 6
    //   201: getfield 2376	SecurityAccountServer/RespondQueryQQBindingStat:nationCode	Ljava/lang/String;
    //   204: astore_3
    //   205: aload_3
    //   206: astore_2
    //   207: aload_3
    //   208: ifnull +21 -> 229
    //   211: aload_3
    //   212: astore_2
    //   213: aload_3
    //   214: ldc_w 2378
    //   217: invokevirtual 2381	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   220: ifeq +9 -> 229
    //   223: aload_3
    //   224: iconst_1
    //   225: invokevirtual 2384	java/lang/String:substring	(I)Ljava/lang/String;
    //   228: astore_2
    //   229: aload_2
    //   230: invokestatic 126	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   233: ifeq +130 -> 363
    //   236: aload 6
    //   238: getfield 2387	SecurityAccountServer/RespondQueryQQBindingStat:mobileNo	Ljava/lang/String;
    //   241: invokestatic 126	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   244: ifeq +119 -> 363
    //   247: ldc 13
    //   249: astore_2
    //   250: aload_2
    //   251: invokestatic 126	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   254: ifne +11 -> 265
    //   257: aload_1
    //   258: getfield 2390	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$ReqGetConfig:bind_phone_no	Lcom/tencent/mobileqq/pb/PBStringField;
    //   261: aload_2
    //   262: invokevirtual 1420	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   265: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   268: ifeq -142 -> 126
    //   271: new 85	java/lang/StringBuilder
    //   274: dup
    //   275: bipush 100
    //   277: invokespecial 2391	java/lang/StringBuilder:<init>	(I)V
    //   280: astore_1
    //   281: aload_1
    //   282: ldc_w 2393
    //   285: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   288: iload 4
    //   290: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   293: ldc_w 2395
    //   296: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   299: aload_2
    //   300: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   303: pop
    //   304: aload_1
    //   305: ldc_w 2397
    //   308: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   311: pop
    //   312: aload 5
    //   314: ifnull +91 -> 405
    //   317: aload 5
    //   319: invokevirtual 2350	java/util/ArrayList:size	()I
    //   322: ifle +83 -> 405
    //   325: aload 5
    //   327: invokevirtual 2351	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   330: astore_2
    //   331: aload_2
    //   332: invokeinterface 240 1 0
    //   337: ifeq +68 -> 405
    //   340: aload_1
    //   341: aload_2
    //   342: invokeinterface 244 1 0
    //   347: checkcast 139	java/lang/Integer
    //   350: invokevirtual 800	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   353: ldc_w 2399
    //   356: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   359: pop
    //   360: goto -29 -> 331
    //   363: invokestatic 1093	java/util/Locale:getDefault	()Ljava/util/Locale;
    //   366: astore 7
    //   368: aload_2
    //   369: astore_3
    //   370: aload_2
    //   371: ifnonnull +6 -> 377
    //   374: ldc 13
    //   376: astore_3
    //   377: aload 7
    //   379: ldc_w 2401
    //   382: iconst_2
    //   383: anewarray 303	java/lang/Object
    //   386: dup
    //   387: iconst_0
    //   388: aload_3
    //   389: aastore
    //   390: dup
    //   391: iconst_1
    //   392: aload 6
    //   394: getfield 2387	SecurityAccountServer/RespondQueryQQBindingStat:mobileNo	Ljava/lang/String;
    //   397: aastore
    //   398: invokestatic 1098	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   401: astore_2
    //   402: goto -152 -> 250
    //   405: aload_1
    //   406: ldc_w 2234
    //   409: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   412: pop
    //   413: ldc_w 2359
    //   416: iconst_2
    //   417: aload_1
    //   418: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   421: invokestatic 200	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   424: return
    //   425: ldc 13
    //   427: astore_2
    //   428: goto -178 -> 250
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	431	0	this	aqlw
    //   0	431	1	paramReqGetConfig	ConfigurationService.ReqGetConfig
    //   0	431	2	paramConfigSeq	ConfigurationService.ConfigSeq
    //   0	431	3	paramQQAppInterface	QQAppInterface
    //   41	248	4	i	int
    //   55	271	5	localArrayList	ArrayList
    //   94	299	6	localObject	Object
    //   366	12	7	localLocale	Locale
    // Exception table:
    //   from	to	target	type
    //   0	40	108	java/lang/Exception
    //   43	52	108	java/lang/Exception
    //   52	57	108	java/lang/Exception
    //   62	76	108	java/lang/Exception
    //   76	105	108	java/lang/Exception
    //   127	139	108	java/lang/Exception
    //   143	172	108	java/lang/Exception
    //   178	194	108	java/lang/Exception
    //   199	205	108	java/lang/Exception
    //   213	229	108	java/lang/Exception
    //   229	247	108	java/lang/Exception
    //   250	265	108	java/lang/Exception
    //   265	312	108	java/lang/Exception
    //   317	331	108	java/lang/Exception
    //   331	360	108	java/lang/Exception
    //   363	368	108	java/lang/Exception
    //   377	402	108	java/lang/Exception
    //   405	424	108	java/lang/Exception
    //   52	57	142	java/lang/Throwable
  }
  
  /* Error */
  private void a(ConfigurationService.RespGetConfig paramRespGetConfig, QQAppInterface paramQQAppInterface, Intent paramIntent, int[] paramArrayOfInt, boolean paramBoolean)
  {
    // Byte code:
    //   0: iload 5
    //   2: ifeq +30 -> 32
    //   5: aload_1
    //   6: getfield 2409	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:result	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   9: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   12: ifne +20 -> 32
    //   15: aload_1
    //   16: getfield 2412	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:config_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   19: ifnull +13 -> 32
    //   22: aload_1
    //   23: getfield 2412	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:config_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   26: invokevirtual 226	com/tencent/mobileqq/pb/PBRepeatMessageField:size	()I
    //   29: ifne +1966 -> 1995
    //   32: iload 5
    //   34: ifne +418 -> 452
    //   37: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   40: ifeq +12 -> 52
    //   43: ldc 183
    //   45: iconst_2
    //   46: ldc_w 2414
    //   49: invokestatic 200	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   52: iconst_0
    //   53: istore 7
    //   55: iload 7
    //   57: aload 4
    //   59: arraylength
    //   60: if_icmpge +11658 -> 11718
    //   63: aload 4
    //   65: iload 7
    //   67: iaload
    //   68: istore 9
    //   70: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   73: ifeq +30 -> 103
    //   76: ldc 183
    //   78: iconst_2
    //   79: new 85	java/lang/StringBuilder
    //   82: dup
    //   83: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   86: ldc_w 2416
    //   89: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: iload 9
    //   94: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   97: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   100: invokestatic 200	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   103: iload 9
    //   105: lookupswitch	default:+251->356, 46:+510->615, 69:+573->678, 86:+990->1095, 87:+812->917, 88:+655->760, 113:+1199->1304, 116:+421->526, 119:+1176->1281, 140:+1347->1452, 149:+410->515, 156:+338->443, 165:+1536->1641, 174:+1613->1718, 180:+410->515, 185:+1704->1809, 188:+1257->1362, 202:+1758->1863, 206:+1302->1407, 210:+1804->1909, 215:+1860->1965, 218:+410->515, 223:+1241->1346, 257:+1446->1551, 260:+1491->1596, 273:+1658->1763, 283:+567->672, 321:+1713->1818, 364:+1241->1346, 365:+1241->1346, 604:+1581->1686
    //   357: istore 8
    //   359: iload 8
    //   361: istore 6
    //   363: invokestatic 1306	apub:a	()Lapub;
    //   366: iload 9
    //   368: invokevirtual 1309	apub:b	(I)Z
    //   371: ifeq +48 -> 419
    //   374: invokestatic 1306	apub:a	()Lapub;
    //   377: iload 9
    //   379: invokevirtual 1312	apub:a	(I)Laptq;
    //   382: astore_3
    //   383: iload 8
    //   385: istore 6
    //   387: aload_3
    //   388: ifnull +31 -> 419
    //   391: aload_1
    //   392: getfield 2409	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:result	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   395: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   398: ifeq +1580 -> 1978
    //   401: bipush 254
    //   403: istore 6
    //   405: iload 6
    //   407: ifeq +9 -> 416
    //   410: aload_3
    //   411: iload 6
    //   413: invokevirtual 2419	aptq:onReqFailed	(I)V
    //   416: iconst_1
    //   417: istore 6
    //   419: iload 6
    //   421: ifne +22 -> 443
    //   424: aload_2
    //   425: invokevirtual 1343	com/tencent/mobileqq/app/QQAppInterface:getConfigProcess	()Laptd;
    //   428: aload_2
    //   429: iload 9
    //   431: iload 5
    //   433: aload_1
    //   434: getfield 2409	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:result	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   437: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   440: invokevirtual 2422	aptd:a	(Lcom/tencent/mobileqq/app/QQAppInterface;IZI)V
    //   443: iload 7
    //   445: iconst_1
    //   446: iadd
    //   447: istore 7
    //   449: goto -394 -> 55
    //   452: aload_1
    //   453: getfield 2409	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:result	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   456: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   459: ifeq +21 -> 480
    //   462: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   465: ifeq -413 -> 52
    //   468: ldc 183
    //   470: iconst_2
    //   471: ldc_w 2424
    //   474: invokestatic 200	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   477: goto -425 -> 52
    //   480: aload_1
    //   481: getfield 2412	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:config_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   484: ifnull +13 -> 497
    //   487: aload_1
    //   488: getfield 2412	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:config_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   491: invokevirtual 226	com/tencent/mobileqq/pb/PBRepeatMessageField:size	()I
    //   494: ifne -442 -> 52
    //   497: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   500: ifeq -448 -> 52
    //   503: ldc 183
    //   505: iconst_2
    //   506: ldc_w 2426
    //   509: invokestatic 200	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   512: goto -460 -> 52
    //   515: iload 9
    //   517: iload 5
    //   519: aload_1
    //   520: invokestatic 2429	lbs:a	(IZLcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig;)V
    //   523: goto -80 -> 443
    //   526: iload 5
    //   528: ifeq +13 -> 541
    //   531: aload_1
    //   532: getfield 2409	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:result	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   535: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   538: ifeq -95 -> 443
    //   541: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   544: ifeq +12 -> 556
    //   547: ldc 183
    //   549: iconst_2
    //   550: ldc_w 2431
    //   553: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   556: aload_0
    //   557: getfield 2433	aqlw:jdField_a_of_type_Boolean	Z
    //   560: ifne +35 -> 595
    //   563: aload_2
    //   564: ldc_w 2435
    //   567: ldc 13
    //   569: ldc 13
    //   571: ldc_w 2437
    //   574: ldc_w 2437
    //   577: iconst_0
    //   578: iconst_0
    //   579: ldc 13
    //   581: ldc 13
    //   583: ldc 13
    //   585: ldc 13
    //   587: invokestatic 2442	bcef:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   590: aload_0
    //   591: iconst_1
    //   592: putfield 2433	aqlw:jdField_a_of_type_Boolean	Z
    //   595: aload_2
    //   596: iconst_4
    //   597: invokevirtual 208	com/tencent/mobileqq/app/QQAppInterface:getBusinessHandler	(I)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   600: checkcast 1795	ampt
    //   603: invokestatic 2447	bfng:a	()Lbfng;
    //   606: invokevirtual 2450	bfng:a	()Lcom/tencent/mobileqq/upgrade/UpgradeDetailWrapper;
    //   609: invokevirtual 2453	ampt:a	(Lcom/tencent/mobileqq/upgrade/UpgradeDetailWrapper;)V
    //   612: goto -169 -> 443
    //   615: aload_1
    //   616: getfield 2409	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:result	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   619: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   622: ifeq +26 -> 648
    //   625: getstatic 2457	com/tencent/common/app/BaseApplicationImpl:sApplication	Lcom/tencent/common/app/BaseApplicationImpl;
    //   628: aload_2
    //   629: invokevirtual 1604	com/tencent/mobileqq/app/QQAppInterface:getCurrentUin	()Ljava/lang/String;
    //   632: ldc_w 2459
    //   635: bipush 101
    //   637: ldc 13
    //   639: invokestatic 2465	com/tencent/mobileqq/msf/core/net/patch/PatchReporter:reportPatchEvent	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)V
    //   642: invokestatic 2468	aafi:c	()V
    //   645: goto -202 -> 443
    //   648: aload_1
    //   649: getfield 2412	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:config_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   652: ifnull +13 -> 665
    //   655: aload_1
    //   656: getfield 2412	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:config_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   659: invokevirtual 226	com/tencent/mobileqq/pb/PBRepeatMessageField:size	()I
    //   662: ifne -20 -> 642
    //   665: aload_2
    //   666: invokestatic 2471	abvj:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   669: goto -27 -> 642
    //   672: invokestatic 2468	aafi:c	()V
    //   675: goto -232 -> 443
    //   678: iload 5
    //   680: ifeq +13 -> 693
    //   683: aload_1
    //   684: getfield 2409	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:result	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   687: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   690: ifeq -247 -> 443
    //   693: aload_2
    //   694: bipush 125
    //   696: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   699: checkcast 2473	ajul
    //   702: astore_3
    //   703: aload_3
    //   704: iconst_1
    //   705: putfield 2474	ajul:jdField_b_of_type_Boolean	Z
    //   708: aload_3
    //   709: getstatic 2479	com/tencent/mobileqq/data/MessageForFoldMsgGrayTips:PASSWD_REDBAG_MSG_SWITCH_DEFAULT	Z
    //   712: putfield 2480	ajul:c	Z
    //   715: aload_3
    //   716: getstatic 2483	com/tencent/mobileqq/data/MessageForFoldMsgGrayTips:PASSWD_REDBAG_MSG_DISPLAY_NUM_DEFAULT	I
    //   719: putfield 2485	ajul:jdField_a_of_type_Int	I
    //   722: aload_3
    //   723: getstatic 2488	com/tencent/mobileqq/data/MessageForFoldMsgGrayTips:PASSWD_REDBAG_MSG_INDEX_WITH_ID	Z
    //   726: putfield 2490	ajul:e	Z
    //   729: aload_2
    //   730: invokevirtual 65	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   733: aload_2
    //   734: invokevirtual 69	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   737: iconst_0
    //   738: aload_3
    //   739: getfield 2480	ajul:c	Z
    //   742: aload_3
    //   743: getfield 2485	ajul:jdField_a_of_type_Int	I
    //   746: aload_3
    //   747: getfield 2492	ajul:d	Z
    //   750: aload_3
    //   751: getfield 2490	ajul:e	Z
    //   754: invokestatic 2495	bfyz:a	(Landroid/content/Context;Ljava/lang/String;IZIZZ)V
    //   757: goto -314 -> 443
    //   760: iload 5
    //   762: ifne +51 -> 813
    //   765: aload_2
    //   766: bipush 88
    //   768: iconst_0
    //   769: iconst_0
    //   770: iconst_1
    //   771: iconst_1
    //   772: iconst_0
    //   773: invokestatic 2500	com/tencent/mobileqq/olympic/OlympicServlet:a	(Lmqq/app/AppRuntime;IIIIII)V
    //   776: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   779: ifeq -336 -> 443
    //   782: ldc_w 1723
    //   785: iconst_2
    //   786: new 85	java/lang/StringBuilder
    //   789: dup
    //   790: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   793: ldc_w 2502
    //   796: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   799: iload 5
    //   801: invokevirtual 152	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   804: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   807: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   810: goto -367 -> 443
    //   813: aload_1
    //   814: getfield 2409	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:result	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   817: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   820: ifeq +61 -> 881
    //   823: aload_1
    //   824: getfield 2409	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:result	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   827: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   830: istore 6
    //   832: aload_2
    //   833: bipush 88
    //   835: iconst_0
    //   836: iconst_0
    //   837: iconst_1
    //   838: iload 6
    //   840: iconst_0
    //   841: invokestatic 2500	com/tencent/mobileqq/olympic/OlympicServlet:a	(Lmqq/app/AppRuntime;IIIIII)V
    //   844: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   847: ifeq -404 -> 443
    //   850: ldc_w 1723
    //   853: iconst_2
    //   854: new 85	java/lang/StringBuilder
    //   857: dup
    //   858: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   861: ldc_w 2504
    //   864: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   867: iload 6
    //   869: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   872: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   875: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   878: goto -435 -> 443
    //   881: aload_1
    //   882: getfield 2412	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:config_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   885: ifnull +13 -> 898
    //   888: aload_1
    //   889: getfield 2412	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:config_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   892: invokevirtual 226	com/tencent/mobileqq/pb/PBRepeatMessageField:size	()I
    //   895: ifne -452 -> 443
    //   898: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   901: ifeq -458 -> 443
    //   904: ldc_w 1723
    //   907: iconst_2
    //   908: ldc_w 2506
    //   911: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   914: goto -471 -> 443
    //   917: iload 5
    //   919: ifne +72 -> 991
    //   922: aload_2
    //   923: bipush 87
    //   925: iconst_0
    //   926: iconst_0
    //   927: iconst_1
    //   928: iconst_1
    //   929: iconst_0
    //   930: invokestatic 2500	com/tencent/mobileqq/olympic/OlympicServlet:a	(Lmqq/app/AppRuntime;IIIIII)V
    //   933: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   936: ifeq +31 -> 967
    //   939: ldc_w 1723
    //   942: iconst_2
    //   943: new 85	java/lang/StringBuilder
    //   946: dup
    //   947: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   950: ldc_w 2508
    //   953: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   956: iload 5
    //   958: invokevirtual 152	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   961: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   964: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   967: aload_2
    //   968: sipush 168
    //   971: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   974: checkcast 1696	aodg
    //   977: astore_3
    //   978: aload_3
    //   979: ifnull -536 -> 443
    //   982: aload_3
    //   983: iconst_1
    //   984: iconst_0
    //   985: invokevirtual 2511	aodg:a	(ZZ)V
    //   988: goto -545 -> 443
    //   991: aload_1
    //   992: getfield 2409	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:result	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   995: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   998: ifeq +61 -> 1059
    //   1001: aload_1
    //   1002: getfield 2409	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:result	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   1005: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   1008: istore 6
    //   1010: aload_2
    //   1011: bipush 87
    //   1013: iconst_0
    //   1014: iconst_0
    //   1015: iconst_1
    //   1016: iload 6
    //   1018: iconst_0
    //   1019: invokestatic 2500	com/tencent/mobileqq/olympic/OlympicServlet:a	(Lmqq/app/AppRuntime;IIIIII)V
    //   1022: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1025: ifeq -58 -> 967
    //   1028: ldc_w 1723
    //   1031: iconst_2
    //   1032: new 85	java/lang/StringBuilder
    //   1035: dup
    //   1036: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   1039: ldc_w 2513
    //   1042: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1045: iload 6
    //   1047: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1050: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1053: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1056: goto -89 -> 967
    //   1059: aload_1
    //   1060: getfield 2412	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:config_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   1063: ifnull +13 -> 1076
    //   1066: aload_1
    //   1067: getfield 2412	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:config_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   1070: invokevirtual 226	com/tencent/mobileqq/pb/PBRepeatMessageField:size	()I
    //   1073: ifne -106 -> 967
    //   1076: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1079: ifeq -112 -> 967
    //   1082: ldc_w 1723
    //   1085: iconst_2
    //   1086: ldc_w 2515
    //   1089: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1092: goto -125 -> 967
    //   1095: iload 5
    //   1097: ifne +77 -> 1174
    //   1100: aload_0
    //   1101: invokevirtual 47	aqlw:getAppRuntime	()Lmqq/app/AppRuntime;
    //   1104: bipush 86
    //   1106: iconst_0
    //   1107: iconst_0
    //   1108: iconst_1
    //   1109: iconst_1
    //   1110: iconst_0
    //   1111: invokestatic 2500	com/tencent/mobileqq/olympic/OlympicServlet:a	(Lmqq/app/AppRuntime;IIIIII)V
    //   1114: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1117: ifeq +31 -> 1148
    //   1120: ldc_w 1682
    //   1123: iconst_2
    //   1124: new 85	java/lang/StringBuilder
    //   1127: dup
    //   1128: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   1131: ldc_w 2517
    //   1134: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1137: iload 5
    //   1139: invokevirtual 152	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1142: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1145: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1148: aload_2
    //   1149: sipush 167
    //   1152: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   1155: checkcast 1658	com/tencent/mobileqq/olympic/OlympicManager
    //   1158: astore_3
    //   1159: aload_3
    //   1160: ifnull -717 -> 443
    //   1163: aload_3
    //   1164: invokevirtual 2519	com/tencent/mobileqq/olympic/OlympicManager:f	()V
    //   1167: aload_3
    //   1168: invokevirtual 2521	com/tencent/mobileqq/olympic/OlympicManager:g	()V
    //   1171: goto -728 -> 443
    //   1174: aload_1
    //   1175: getfield 2409	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:result	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   1178: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   1181: ifeq +64 -> 1245
    //   1184: aload_1
    //   1185: getfield 2409	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:result	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   1188: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   1191: istore 6
    //   1193: aload_0
    //   1194: invokevirtual 47	aqlw:getAppRuntime	()Lmqq/app/AppRuntime;
    //   1197: bipush 86
    //   1199: iconst_0
    //   1200: iconst_0
    //   1201: iconst_1
    //   1202: iload 6
    //   1204: iconst_0
    //   1205: invokestatic 2500	com/tencent/mobileqq/olympic/OlympicServlet:a	(Lmqq/app/AppRuntime;IIIIII)V
    //   1208: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1211: ifeq -63 -> 1148
    //   1214: ldc_w 1682
    //   1217: iconst_2
    //   1218: new 85	java/lang/StringBuilder
    //   1221: dup
    //   1222: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   1225: ldc_w 2523
    //   1228: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1231: iload 6
    //   1233: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1236: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1239: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1242: goto -94 -> 1148
    //   1245: aload_1
    //   1246: getfield 2412	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:config_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   1249: ifnull +13 -> 1262
    //   1252: aload_1
    //   1253: getfield 2412	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:config_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   1256: invokevirtual 226	com/tencent/mobileqq/pb/PBRepeatMessageField:size	()I
    //   1259: ifne -111 -> 1148
    //   1262: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1265: ifeq -117 -> 1148
    //   1268: ldc_w 1682
    //   1271: iconst_2
    //   1272: ldc_w 2525
    //   1275: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1278: goto -130 -> 1148
    //   1281: aload_2
    //   1282: bipush 53
    //   1284: invokevirtual 208	com/tencent/mobileqq/app/QQAppInterface:getBusinessHandler	(I)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   1287: checkcast 1806	amoa
    //   1290: astore_3
    //   1291: aload_3
    //   1292: ifnull -849 -> 443
    //   1295: aload_3
    //   1296: iconst_0
    //   1297: iconst_0
    //   1298: invokevirtual 2526	amoa:a	(ZZ)V
    //   1301: goto -858 -> 443
    //   1304: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1307: ifeq +12 -> 1319
    //   1310: ldc 183
    //   1312: iconst_2
    //   1313: ldc_w 2528
    //   1316: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1319: aload_2
    //   1320: sipush 179
    //   1323: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   1326: checkcast 2530	ayji
    //   1329: astore_3
    //   1330: aload_3
    //   1331: ifnull -888 -> 443
    //   1334: aload_3
    //   1335: invokevirtual 2531	ayji:a	()V
    //   1338: aload_3
    //   1339: iconst_0
    //   1340: invokevirtual 2532	ayji:a	(Z)V
    //   1343: goto -900 -> 443
    //   1346: aload_2
    //   1347: invokestatic 1526	com/tencent/mobileqq/utils/BusinessCommonConfig:getInstance	(Lmqq/app/AppRuntime;)Lcom/tencent/mobileqq/utils/BusinessCommonConfig;
    //   1350: aload_2
    //   1351: iload 9
    //   1353: iload 5
    //   1355: aload_1
    //   1356: invokevirtual 2536	com/tencent/mobileqq/utils/BusinessCommonConfig:handleResp_Config_Fail	(Lcom/tencent/mobileqq/app/QQAppInterface;IZLcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig;)V
    //   1359: goto -916 -> 443
    //   1362: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1365: ifeq -922 -> 443
    //   1368: aload_1
    //   1369: getfield 2409	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:result	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   1372: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   1375: istore 6
    //   1377: ldc 183
    //   1379: iconst_2
    //   1380: new 85	java/lang/StringBuilder
    //   1383: dup
    //   1384: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   1387: ldc_w 2538
    //   1390: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1393: iload 6
    //   1395: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1398: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1401: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1404: goto -961 -> 443
    //   1407: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1410: ifeq -967 -> 443
    //   1413: aload_1
    //   1414: getfield 2409	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:result	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   1417: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   1420: istore 6
    //   1422: ldc 183
    //   1424: iconst_2
    //   1425: new 85	java/lang/StringBuilder
    //   1428: dup
    //   1429: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   1432: ldc_w 2540
    //   1435: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1438: iload 6
    //   1440: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1443: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1446: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1449: goto -1006 -> 443
    //   1452: aload_1
    //   1453: getfield 2409	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:result	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   1456: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   1459: istore 6
    //   1461: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1464: ifeq +30 -> 1494
    //   1467: ldc 183
    //   1469: iconst_2
    //   1470: new 85	java/lang/StringBuilder
    //   1473: dup
    //   1474: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   1477: ldc_w 2542
    //   1480: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1483: iload 6
    //   1485: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1488: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1491: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1494: new 2544	java/util/HashMap
    //   1497: dup
    //   1498: invokespecial 2545	java/util/HashMap:<init>	()V
    //   1501: astore_3
    //   1502: aload_3
    //   1503: ldc_w 2547
    //   1506: new 85	java/lang/StringBuilder
    //   1509: dup
    //   1510: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   1513: iload 6
    //   1515: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1518: ldc 13
    //   1520: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1523: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1526: invokevirtual 2550	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1529: pop
    //   1530: invokestatic 386	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1533: invokestatic 1689	com/tencent/mobileqq/statistics/StatisticCollector:getInstance	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   1536: aconst_null
    //   1537: ldc_w 2552
    //   1540: iconst_0
    //   1541: lconst_0
    //   1542: lconst_0
    //   1543: aload_3
    //   1544: aconst_null
    //   1545: invokevirtual 2555	com/tencent/mobileqq/statistics/StatisticCollector:collectPerformance	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;)V
    //   1548: goto -1105 -> 443
    //   1551: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1554: ifeq -1111 -> 443
    //   1557: aload_1
    //   1558: getfield 2409	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:result	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   1561: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   1564: istore 6
    //   1566: ldc 183
    //   1568: iconst_2
    //   1569: invokestatic 1093	java/util/Locale:getDefault	()Ljava/util/Locale;
    //   1572: ldc_w 2557
    //   1575: iconst_1
    //   1576: anewarray 303	java/lang/Object
    //   1579: dup
    //   1580: iconst_0
    //   1581: iload 6
    //   1583: invokestatic 307	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1586: aastore
    //   1587: invokestatic 1098	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   1590: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1593: goto -1150 -> 443
    //   1596: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1599: ifeq -1156 -> 443
    //   1602: aload_1
    //   1603: getfield 2409	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:result	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   1606: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   1609: istore 6
    //   1611: ldc 183
    //   1613: iconst_2
    //   1614: invokestatic 1093	java/util/Locale:getDefault	()Ljava/util/Locale;
    //   1617: ldc_w 2559
    //   1620: iconst_1
    //   1621: anewarray 303	java/lang/Object
    //   1624: dup
    //   1625: iconst_0
    //   1626: iload 6
    //   1628: invokestatic 307	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1631: aastore
    //   1632: invokestatic 1098	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   1635: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1638: goto -1195 -> 443
    //   1641: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1644: ifeq -1201 -> 443
    //   1647: aload_1
    //   1648: getfield 2409	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:result	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   1651: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   1654: istore 6
    //   1656: ldc 183
    //   1658: iconst_2
    //   1659: new 85	java/lang/StringBuilder
    //   1662: dup
    //   1663: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   1666: ldc_w 2561
    //   1669: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1672: iload 6
    //   1674: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1677: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1680: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1683: goto -1240 -> 443
    //   1686: ldc 183
    //   1688: iconst_1
    //   1689: iconst_2
    //   1690: anewarray 303	java/lang/Object
    //   1693: dup
    //   1694: iconst_0
    //   1695: ldc_w 2563
    //   1698: aastore
    //   1699: dup
    //   1700: iconst_1
    //   1701: aload_1
    //   1702: getfield 2409	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:result	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   1705: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   1708: invokestatic 307	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1711: aastore
    //   1712: invokestatic 2565	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   1715: goto -1272 -> 443
    //   1718: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1721: ifeq -1278 -> 443
    //   1724: aload_1
    //   1725: getfield 2409	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:result	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   1728: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   1731: istore 6
    //   1733: ldc 183
    //   1735: iconst_2
    //   1736: new 85	java/lang/StringBuilder
    //   1739: dup
    //   1740: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   1743: ldc_w 2567
    //   1746: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1749: iload 6
    //   1751: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1754: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1757: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1760: goto -1317 -> 443
    //   1763: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1766: ifeq -1323 -> 443
    //   1769: aload_1
    //   1770: getfield 2409	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:result	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   1773: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   1776: istore 6
    //   1778: ldc_w 2569
    //   1781: iconst_2
    //   1782: new 85	java/lang/StringBuilder
    //   1785: dup
    //   1786: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   1789: ldc_w 2571
    //   1792: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1795: iload 6
    //   1797: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1800: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1803: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1806: goto -1363 -> 443
    //   1809: invokestatic 2576	com/tencent/mobileqq/scribble/ScribbleResMgr:a	()Lcom/tencent/mobileqq/scribble/ScribbleResMgr;
    //   1812: invokevirtual 2578	com/tencent/mobileqq/scribble/ScribbleResMgr:b	()V
    //   1815: goto -1372 -> 443
    //   1818: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1821: ifeq -1378 -> 443
    //   1824: aload_1
    //   1825: getfield 2409	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:result	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   1828: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   1831: istore 6
    //   1833: ldc 183
    //   1835: iconst_2
    //   1836: new 85	java/lang/StringBuilder
    //   1839: dup
    //   1840: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   1843: ldc_w 2580
    //   1846: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1849: iload 6
    //   1851: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1854: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1857: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1860: goto -1417 -> 443
    //   1863: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1866: ifeq -1423 -> 443
    //   1869: aload_1
    //   1870: getfield 2409	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:result	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   1873: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   1876: istore 6
    //   1878: ldc_w 2359
    //   1881: iconst_2
    //   1882: new 85	java/lang/StringBuilder
    //   1885: dup
    //   1886: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   1889: ldc_w 2582
    //   1892: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1895: iload 6
    //   1897: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1900: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1903: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1906: goto -1463 -> 443
    //   1909: aload_2
    //   1910: sipush 228
    //   1913: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   1916: checkcast 1980	axlb
    //   1919: astore_3
    //   1920: aload_1
    //   1921: getfield 2409	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:result	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   1924: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   1927: istore 6
    //   1929: ldc 183
    //   1931: iconst_1
    //   1932: new 85	java/lang/StringBuilder
    //   1935: dup
    //   1936: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   1939: ldc_w 2584
    //   1942: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1945: iload 6
    //   1947: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1950: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1953: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1956: aload_3
    //   1957: iconst_0
    //   1958: aconst_null
    //   1959: invokevirtual 2587	axlb:a	(ZLcom/tencent/mobileqq/ocr/data/OcrConfig;)V
    //   1962: goto -1519 -> 443
    //   1965: aload_1
    //   1966: getfield 2409	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:result	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   1969: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   1972: invokestatic 2588	com/tencent/mobileqq/shortvideo/ShortVideoResourceManager:a	(I)V
    //   1975: goto -1532 -> 443
    //   1978: iload 5
    //   1980: ifne +9 -> 1989
    //   1983: iconst_m1
    //   1984: istore 6
    //   1986: goto -1581 -> 405
    //   1989: iconst_0
    //   1990: istore 6
    //   1992: goto -1587 -> 405
    //   1995: invokestatic 2591	java/lang/System:currentTimeMillis	()J
    //   1998: lstore 12
    //   2000: aload_1
    //   2001: getfield 2412	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:config_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   2004: invokevirtual 226	com/tencent/mobileqq/pb/PBRepeatMessageField:size	()I
    //   2007: istore 9
    //   2009: new 1132	java/util/ArrayList
    //   2012: dup
    //   2013: aload 4
    //   2015: arraylength
    //   2016: invokespecial 1163	java/util/ArrayList:<init>	(I)V
    //   2019: astore 18
    //   2021: iconst_0
    //   2022: istore 6
    //   2024: iload 6
    //   2026: aload 4
    //   2028: arraylength
    //   2029: if_icmpge +28 -> 2057
    //   2032: aload 18
    //   2034: aload 4
    //   2036: iload 6
    //   2038: iaload
    //   2039: invokestatic 307	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2042: invokeinterface 1142 2 0
    //   2047: pop
    //   2048: iload 6
    //   2050: iconst_1
    //   2051: iadd
    //   2052: istore 6
    //   2054: goto -30 -> 2024
    //   2057: aconst_null
    //   2058: astore 4
    //   2060: iconst_0
    //   2061: istore 10
    //   2063: iconst_0
    //   2064: istore 6
    //   2066: iload 6
    //   2068: iload 9
    //   2070: if_icmpge +7935 -> 10005
    //   2073: aload_1
    //   2074: getfield 2412	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:config_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   2077: iload 6
    //   2079: invokevirtual 319	com/tencent/mobileqq/pb/PBRepeatMessageField:get	(I)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   2082: checkcast 51	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config
    //   2085: astore 19
    //   2087: aload 19
    //   2089: ifnonnull +28 -> 2117
    //   2092: iload 10
    //   2094: istore 11
    //   2096: aload 4
    //   2098: astore 16
    //   2100: iload 6
    //   2102: iconst_1
    //   2103: iadd
    //   2104: istore 6
    //   2106: aload 16
    //   2108: astore 4
    //   2110: iload 11
    //   2112: istore 10
    //   2114: goto -48 -> 2066
    //   2117: aload 4
    //   2119: astore 16
    //   2121: iload 10
    //   2123: istore 11
    //   2125: aload 19
    //   2127: getfield 2592	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:type	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   2130: invokevirtual 2593	com/tencent/mobileqq/pb/PBInt32Field:has	()Z
    //   2133: ifeq -33 -> 2100
    //   2136: new 139	java/lang/Integer
    //   2139: dup
    //   2140: aload 19
    //   2142: getfield 2592	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:type	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   2145: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   2148: invokespecial 2594	java/lang/Integer:<init>	(I)V
    //   2151: astore 16
    //   2153: aload 18
    //   2155: aload 16
    //   2157: invokeinterface 2596 2 0
    //   2162: pop
    //   2163: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2166: ifeq +41 -> 2207
    //   2169: ldc 183
    //   2171: iconst_2
    //   2172: new 85	java/lang/StringBuilder
    //   2175: dup
    //   2176: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   2179: ldc_w 2598
    //   2182: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2185: aload 16
    //   2187: invokevirtual 800	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2190: ldc_w 2600
    //   2193: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2196: iload 9
    //   2198: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2201: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2204: invokestatic 200	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   2207: aload 16
    //   2209: invokevirtual 1842	java/lang/Integer:intValue	()I
    //   2212: lookupswitch	default:+9538->11750, 1:+2897->5109, 2:+3301->5513, 3:+3791->6003, 5:+4029->6241, 6:+6258->8470, 10:+4882->7094, 12:+4254->6466, 13:+5157->7369, 23:+5547->7759, 31:+5223->7435, 34:+5205->7417, 38:+5656->7868, 42:+6078->8290, 43:+6240->8452, 44:+2474->4686, 46:+6096->8308, 47:+2662->4874, 49:+6087->8299, 50:+6105->8317, 53:+5557->7769, 55:+4570->6782, 56:+6114->8326, 61:+6123->8335, 63:+6141->8353, 64:+6150->8362, 65:+2851->5063, 66:+6159->8371, 69:+6186->8398, 72:+6168->8380, 73:+6177->8389, 74:+6195->8407, 75:+6204->8416, 78:+5567->7779, 79:+6289->8501, 80:+6271->8483, 82:+6298->8510, 84:+5577->7789, 86:+6516->8728, 87:+6535->8747, 88:+6545->8757, 90:+6307->8519, 93:+5867->8079, 94:+5373->7585, 96:+6586->8798, 97:+6596->8808, 101:+5175->7387, 102:+5214->7426, 109:+6633->8845, 111:+6280->8492, 113:+6249->8461, 115:+5185->7397, 116:+1837->4049, 118:+6652->8864, 119:+6702->8914, 121:+6712->8924, 129:+6682->8894, 130:+6732->8944, 139:+5608->7820, 140:+6760->8972, 142:+6662->8874, 143:+6692->8904, 145:+6800->9012, 146:+6623->8835, 147:+6506->8718, 148:+6132->8344, 149:+6606->8818, 153:+6790->9002, 155:+6810->9022, 156:+9636->11848, 157:+6722->8934, 165:+6830->9042, 166:+6840->9052, 167:+5598->7810, 171:+6862->9074, 174:+6912->9124, 177:+6961->9173, 180:+6606->8818, 181:+6882->9094, 182:+6941->9153, 184:+6872->9084, 185:+7011->9223, 187:+6971->9183, 188:+6555->8767, 190:+7127->9339, 191:+7001->9213, 193:+1431->3643, 194:+6820->9032, 195:+6981->9193, 199:+7030->9242, 201:+6672->8884, 202:+7117->9329, 204:+7352->9564, 205:+6575->8787, 206:+6565->8777, 210:+7137->9349, 211:+6750->8962, 212:+7147->9359, 215:+7184->9396, 218:+6606->8818, 222:+7204->9416, 223:+5636->7848, 225:+7072->9284, 226:+5587->7799, 227:+6991->9203, 228:+6222->8434, 232:+6742->8954, 234:+7232->9444, 235:+7242->9454, 238:+7252->9464, 244:+7262->9474, 245:+7272->9484, 247:+6892->9104, 253:+7282->9494, 254:+7302->9514, 256:+6231->8443, 257:+6770->8982, 259:+7312->9524, 260:+6780->8992, 262:+7322->9534, 267:+7362->9574, 268:+7332->9544, 269:+7342->9554, 272:+6902->9114, 273:+6922->9134, 274:+7372->9584, 279:+7381->9593, 280:+7477->9689, 281:+7497->9709, 283:+7507->9719, 284:+7517->9729, 286:+5195->7407, 289:+7544->9756, 295:+7292->9504, 297:+7554->9766, 301:+7527->9739, 308:+7402->9614, 312:+7435->9647, 313:+7423->9635, 314:+7583->9795, 320:+7603->9815, 321:+7021->9233, 328:+6931->9143, 329:+5617->7829, 331:+7625->9837, 336:+7635->9847, 337:+7568->9780, 345:+7644->9856, 347:+7593->9805, 349:+7658->9870, 351:+5626->7838, 360:+7487->9699, 364:+5636->7848, 365:+5636->7848, 371:+6951->9163, 384:+7694->9906, 385:+6213->8425, 386:+7713->9925, 387:+7703->9915, 392:+7731->9943, 393:+7740->9952, 394:+7758->9970, 397:+7453->9665, 400:+7679->9891, 403:+7156->9368, 404:+7175->9387, 410:+7768->9980, 596:+7783->9995, 604:+7165->9377
    //   3569: istore 7
    //   3571: invokestatic 1306	apub:a	()Lapub;
    //   3574: aload 16
    //   3576: invokevirtual 1842	java/lang/Integer:intValue	()I
    //   3579: invokevirtual 1309	apub:b	(I)Z
    //   3582: ifeq +38 -> 3620
    //   3585: invokestatic 1306	apub:a	()Lapub;
    //   3588: astore 17
    //   3590: aload 19
    //   3592: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   3595: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   3598: istore 7
    //   3600: aload 17
    //   3602: aload 16
    //   3604: invokevirtual 1842	java/lang/Integer:intValue	()I
    //   3607: iload 7
    //   3609: aload 19
    //   3611: getstatic 15	aqlw:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   3614: invokevirtual 2603	apub:a	(IILcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;Ljava/lang/String;)V
    //   3617: iconst_1
    //   3618: istore 7
    //   3620: iload 7
    //   3622: ifne +8131 -> 11753
    //   3625: aload_2
    //   3626: invokevirtual 1343	com/tencent/mobileqq/app/QQAppInterface:getConfigProcess	()Laptd;
    //   3629: aload_2
    //   3630: aload 19
    //   3632: aload 16
    //   3634: invokevirtual 1842	java/lang/Integer:intValue	()I
    //   3637: invokevirtual 2605	aptd:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;I)V
    //   3640: goto +8113 -> 11753
    //   3643: aload 19
    //   3645: getfield 223	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   3648: ifnull +8105 -> 11753
    //   3651: aload 19
    //   3653: getfield 223	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   3656: invokevirtual 226	com/tencent/mobileqq/pb/PBRepeatMessageField:size	()I
    //   3659: ifle +8094 -> 11753
    //   3662: aload 19
    //   3664: getfield 223	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   3667: iconst_0
    //   3668: invokevirtual 319	com/tencent/mobileqq/pb/PBRepeatMessageField:get	(I)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   3671: checkcast 246	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content
    //   3674: astore 16
    //   3676: aload 16
    //   3678: ifnull +344 -> 4022
    //   3681: aload 16
    //   3683: getfield 250	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content:compress	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   3686: invokevirtual 253	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   3689: iconst_1
    //   3690: if_icmpne +232 -> 3922
    //   3693: aload 16
    //   3695: getfield 257	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content:content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   3698: invokevirtual 262	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   3701: invokevirtual 268	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   3704: invokestatic 322	axsb:a	([B)[B
    //   3707: astore 17
    //   3709: aload 17
    //   3711: ifnull +8033 -> 11744
    //   3714: new 118	java/lang/String
    //   3717: dup
    //   3718: aload 17
    //   3720: ldc_w 324
    //   3723: invokespecial 327	java/lang/String:<init>	([BLjava/lang/String;)V
    //   3726: astore 16
    //   3728: aload 16
    //   3730: ifnull +8007 -> 11737
    //   3733: aload 19
    //   3735: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   3738: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   3741: istore 7
    //   3743: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3746: ifeq +42 -> 3788
    //   3749: ldc_w 1800
    //   3752: iconst_2
    //   3753: new 85	java/lang/StringBuilder
    //   3756: dup
    //   3757: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   3760: ldc_w 2607
    //   3763: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3766: iload 7
    //   3768: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3771: ldc_w 2609
    //   3774: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3777: aload 16
    //   3779: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3782: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3785: invokestatic 200	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   3788: aload 16
    //   3790: invokestatic 2614	com/tencent/mobileqq/upgrade/UpgradeTIMWrapper:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/upgrade/UpgradeTIMWrapper;
    //   3793: astore 17
    //   3795: aload 17
    //   3797: astore 4
    //   3799: aload_0
    //   3800: invokevirtual 47	aqlw:getAppRuntime	()Lmqq/app/AppRuntime;
    //   3803: invokevirtual 2615	mqq/app/AppRuntime:getApplication	()Lmqq/app/MobileQQ;
    //   3806: getstatic 15	aqlw:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   3809: iload 7
    //   3811: invokestatic 2617	bfyz:q	(Landroid/content/Context;Ljava/lang/String;I)V
    //   3814: aload_2
    //   3815: invokevirtual 65	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   3818: ldc_w 2619
    //   3821: invokestatic 2622	bfwv:a	(Landroid/content/Context;Ljava/lang/String;)Z
    //   3824: ifne +114 -> 3938
    //   3827: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3830: ifeq +13 -> 3843
    //   3833: ldc_w 1800
    //   3836: iconst_2
    //   3837: ldc_w 2624
    //   3840: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3843: aload 16
    //   3845: invokestatic 2625	com/tencent/mobileqq/upgrade/UpgradeTIMWrapper:a	(Ljava/lang/String;)V
    //   3848: aload_2
    //   3849: aload 4
    //   3851: invokestatic 2628	com/tencent/mobileqq/upgrade/UpgradeTIMWrapper:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/upgrade/UpgradeTIMWrapper;)V
    //   3854: aload 4
    //   3856: astore 16
    //   3858: aload 16
    //   3860: astore 4
    //   3862: goto +7891 -> 11753
    //   3865: astore 16
    //   3867: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3870: ifeq +7894 -> 11764
    //   3873: aload 16
    //   3875: invokevirtual 2629	java/io/UnsupportedEncodingException:printStackTrace	()V
    //   3878: goto +7886 -> 11764
    //   3881: astore 16
    //   3883: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3886: ifeq +8 -> 3894
    //   3889: aload 16
    //   3891: invokevirtual 2630	java/lang/OutOfMemoryError:printStackTrace	()V
    //   3894: invokestatic 2633	java/lang/System:gc	()V
    //   3897: new 118	java/lang/String
    //   3900: dup
    //   3901: aload 17
    //   3903: ldc_w 324
    //   3906: invokespecial 327	java/lang/String:<init>	([BLjava/lang/String;)V
    //   3909: astore 16
    //   3911: goto -183 -> 3728
    //   3914: astore 16
    //   3916: aconst_null
    //   3917: astore 16
    //   3919: goto -191 -> 3728
    //   3922: aload 16
    //   3924: getfield 257	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content:content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   3927: invokevirtual 262	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   3930: invokevirtual 282	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   3933: astore 16
    //   3935: goto -207 -> 3728
    //   3938: aload 4
    //   3940: astore 16
    //   3942: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3945: ifeq -87 -> 3858
    //   3948: ldc_w 1800
    //   3951: iconst_2
    //   3952: ldc_w 2635
    //   3955: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3958: aload 4
    //   3960: astore 16
    //   3962: goto -104 -> 3858
    //   3965: astore 17
    //   3967: aload 4
    //   3969: astore 16
    //   3971: iload 10
    //   3973: istore 11
    //   3975: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3978: ifeq -1878 -> 2100
    //   3981: ldc 183
    //   3983: iconst_2
    //   3984: new 85	java/lang/StringBuilder
    //   3987: dup
    //   3988: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   3991: ldc_w 2637
    //   3994: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3997: aload 17
    //   3999: invokevirtual 2302	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   4002: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4005: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4008: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4011: aload 4
    //   4013: astore 16
    //   4015: iload 10
    //   4017: istore 11
    //   4019: goto -1919 -> 2100
    //   4022: aload 4
    //   4024: astore 16
    //   4026: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4029: ifeq -171 -> 3858
    //   4032: ldc_w 1800
    //   4035: iconst_2
    //   4036: ldc_w 2639
    //   4039: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4042: aload 4
    //   4044: astore 16
    //   4046: goto -188 -> 3858
    //   4049: aload_0
    //   4050: invokevirtual 47	aqlw:getAppRuntime	()Lmqq/app/AppRuntime;
    //   4053: invokevirtual 2615	mqq/app/AppRuntime:getApplication	()Lmqq/app/MobileQQ;
    //   4056: getstatic 15	aqlw:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   4059: invokestatic 1781	bfyz:I	(Landroid/content/Context;Ljava/lang/String;)I
    //   4062: istore 7
    //   4064: aload 19
    //   4066: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   4069: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   4072: istore 8
    //   4074: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4077: ifeq +35 -> 4112
    //   4080: ldc 183
    //   4082: iconst_2
    //   4083: ldc_w 2641
    //   4086: iconst_2
    //   4087: anewarray 303	java/lang/Object
    //   4090: dup
    //   4091: iconst_0
    //   4092: iload 7
    //   4094: invokestatic 307	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   4097: aastore
    //   4098: dup
    //   4099: iconst_1
    //   4100: iload 8
    //   4102: invokestatic 307	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   4105: aastore
    //   4106: invokestatic 311	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   4109: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4112: aconst_null
    //   4113: astore 17
    //   4115: iload 7
    //   4117: iload 8
    //   4119: if_icmpeq +386 -> 4505
    //   4122: aload 19
    //   4124: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   4127: ifnull +14 -> 4141
    //   4130: aload 19
    //   4132: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   4135: invokevirtual 2642	com/tencent/mobileqq/pb/PBRepeatField:isEmpty	()Z
    //   4138: ifeq +285 -> 4423
    //   4141: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4144: ifeq +12 -> 4156
    //   4147: ldc 183
    //   4149: iconst_2
    //   4150: ldc_w 2644
    //   4153: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4156: ldc_w 2646
    //   4159: getstatic 15	aqlw:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   4162: invokestatic 2651	bfne:a	(Ljava/lang/String;Ljava/lang/String;)Z
    //   4165: pop
    //   4166: aconst_null
    //   4167: astore 16
    //   4169: aload_0
    //   4170: invokevirtual 47	aqlw:getAppRuntime	()Lmqq/app/AppRuntime;
    //   4173: invokevirtual 2615	mqq/app/AppRuntime:getApplication	()Lmqq/app/MobileQQ;
    //   4176: getstatic 15	aqlw:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   4179: iload 8
    //   4181: invokestatic 2653	bfyz:p	(Landroid/content/Context;Ljava/lang/String;I)V
    //   4184: aload_2
    //   4185: iconst_4
    //   4186: invokevirtual 208	com/tencent/mobileqq/app/QQAppInterface:getBusinessHandler	(I)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   4189: checkcast 1795	ampt
    //   4192: astore 19
    //   4194: aload 16
    //   4196: invokestatic 126	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4199: ifne +468 -> 4667
    //   4202: invokestatic 2447	bfng:a	()Lbfng;
    //   4205: invokevirtual 2450	bfng:a	()Lcom/tencent/mobileqq/upgrade/UpgradeDetailWrapper;
    //   4208: astore 17
    //   4210: aload 17
    //   4212: aload 16
    //   4214: invokevirtual 2656	com/tencent/mobileqq/upgrade/UpgradeDetailWrapper:a	(Ljava/lang/String;)V
    //   4217: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4220: ifeq +42 -> 4262
    //   4223: ldc 183
    //   4225: iconst_2
    //   4226: ldc_w 2658
    //   4229: iconst_2
    //   4230: anewarray 303	java/lang/Object
    //   4233: dup
    //   4234: iconst_0
    //   4235: invokestatic 204	com/tencent/common/config/AppSetting:a	()I
    //   4238: invokestatic 307	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   4241: aastore
    //   4242: dup
    //   4243: iconst_1
    //   4244: aload 17
    //   4246: getfield 2661	com/tencent/mobileqq/upgrade/UpgradeDetailWrapper:jdField_b_of_type_ProtocolKQQConfigUpgradeInfo	Lprotocol/KQQConfig/UpgradeInfo;
    //   4249: getfield 2666	protocol/KQQConfig/UpgradeInfo:iUpgradeSdkId	I
    //   4252: invokestatic 307	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   4255: aastore
    //   4256: invokestatic 311	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   4259: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4262: aload_2
    //   4263: invokevirtual 65	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   4266: getstatic 15	aqlw:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   4269: invokestatic 2669	bfyz:aN	(Landroid/content/Context;Ljava/lang/String;)I
    //   4272: aload 17
    //   4274: getfield 2661	com/tencent/mobileqq/upgrade/UpgradeDetailWrapper:jdField_b_of_type_ProtocolKQQConfigUpgradeInfo	Lprotocol/KQQConfig/UpgradeInfo;
    //   4277: getfield 2666	protocol/KQQConfig/UpgradeInfo:iUpgradeSdkId	I
    //   4280: if_icmpeq +69 -> 4349
    //   4283: aload_2
    //   4284: invokevirtual 65	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   4287: aload_2
    //   4288: invokevirtual 1604	com/tencent/mobileqq/app/QQAppInterface:getCurrentUin	()Ljava/lang/String;
    //   4291: iconst_0
    //   4292: invokestatic 2671	bfyz:ae	(Landroid/content/Context;Ljava/lang/String;I)V
    //   4295: aload_2
    //   4296: invokevirtual 65	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   4299: aload_2
    //   4300: invokevirtual 1604	com/tencent/mobileqq/app/QQAppInterface:getCurrentUin	()Ljava/lang/String;
    //   4303: lconst_0
    //   4304: invokestatic 2674	bfyz:i	(Landroid/content/Context;Ljava/lang/String;J)V
    //   4307: aload_2
    //   4308: invokevirtual 65	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   4311: aload_2
    //   4312: invokevirtual 1604	com/tencent/mobileqq/app/QQAppInterface:getCurrentUin	()Ljava/lang/String;
    //   4315: iconst_0
    //   4316: invokestatic 2677	bfyz:af	(Landroid/content/Context;Ljava/lang/String;I)V
    //   4319: aload_2
    //   4320: invokevirtual 65	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   4323: aload_2
    //   4324: invokevirtual 1604	com/tencent/mobileqq/app/QQAppInterface:getCurrentUin	()Ljava/lang/String;
    //   4327: lconst_0
    //   4328: invokestatic 2679	bfyz:j	(Landroid/content/Context;Ljava/lang/String;J)V
    //   4331: aload_2
    //   4332: invokevirtual 65	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   4335: getstatic 15	aqlw:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   4338: aload 17
    //   4340: getfield 2661	com/tencent/mobileqq/upgrade/UpgradeDetailWrapper:jdField_b_of_type_ProtocolKQQConfigUpgradeInfo	Lprotocol/KQQConfig/UpgradeInfo;
    //   4343: getfield 2666	protocol/KQQConfig/UpgradeInfo:iUpgradeSdkId	I
    //   4346: invokestatic 2681	bfyz:ad	(Landroid/content/Context;Ljava/lang/String;I)V
    //   4349: invokestatic 204	com/tencent/common/config/AppSetting:a	()I
    //   4352: aload 17
    //   4354: getfield 2661	com/tencent/mobileqq/upgrade/UpgradeDetailWrapper:jdField_b_of_type_ProtocolKQQConfigUpgradeInfo	Lprotocol/KQQConfig/UpgradeInfo;
    //   4357: getfield 2666	protocol/KQQConfig/UpgradeInfo:iUpgradeSdkId	I
    //   4360: if_icmplt +171 -> 4531
    //   4363: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4366: ifeq +12 -> 4378
    //   4369: ldc 183
    //   4371: iconst_2
    //   4372: ldc_w 2683
    //   4375: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4378: aload_2
    //   4379: invokevirtual 65	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   4382: getstatic 15	aqlw:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   4385: iconst_0
    //   4386: invokestatic 2653	bfyz:p	(Landroid/content/Context;Ljava/lang/String;I)V
    //   4389: ldc_w 2646
    //   4392: getstatic 15	aqlw:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   4395: invokestatic 2651	bfne:a	(Ljava/lang/String;Ljava/lang/String;)Z
    //   4398: pop
    //   4399: aload 17
    //   4401: getfield 2661	com/tencent/mobileqq/upgrade/UpgradeDetailWrapper:jdField_b_of_type_ProtocolKQQConfigUpgradeInfo	Lprotocol/KQQConfig/UpgradeInfo;
    //   4404: iconst_0
    //   4405: putfield 2686	protocol/KQQConfig/UpgradeInfo:iUpgradeType	I
    //   4408: aload 19
    //   4410: aload 17
    //   4412: invokevirtual 2453	ampt:a	(Lcom/tencent/mobileqq/upgrade/UpgradeDetailWrapper;)V
    //   4415: aload 19
    //   4417: invokevirtual 2688	ampt:d	()V
    //   4420: goto +7333 -> 11753
    //   4423: aload 19
    //   4425: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   4428: iconst_0
    //   4429: invokevirtual 116	com/tencent/mobileqq/pb/PBRepeatField:get	(I)Ljava/lang/Object;
    //   4432: checkcast 118	java/lang/String
    //   4435: astore 16
    //   4437: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4440: ifeq +30 -> 4470
    //   4443: ldc 183
    //   4445: iconst_2
    //   4446: new 85	java/lang/StringBuilder
    //   4449: dup
    //   4450: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   4453: ldc_w 2690
    //   4456: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4459: aload 16
    //   4461: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4464: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4467: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4470: aload 16
    //   4472: invokestatic 126	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4475: ifeq +16 -> 4491
    //   4478: ldc_w 2646
    //   4481: getstatic 15	aqlw:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   4484: invokestatic 2651	bfne:a	(Ljava/lang/String;Ljava/lang/String;)Z
    //   4487: pop
    //   4488: goto -319 -> 4169
    //   4491: ldc_w 2646
    //   4494: getstatic 15	aqlw:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   4497: aload 16
    //   4499: invokestatic 2693	bfne:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   4502: goto -333 -> 4169
    //   4505: aload 17
    //   4507: astore 16
    //   4509: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4512: ifeq -328 -> 4184
    //   4515: ldc 183
    //   4517: iconst_2
    //   4518: ldc_w 2695
    //   4521: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4524: aload 17
    //   4526: astore 16
    //   4528: goto -344 -> 4184
    //   4531: aload_0
    //   4532: invokevirtual 47	aqlw:getAppRuntime	()Lmqq/app/AppRuntime;
    //   4535: invokevirtual 2615	mqq/app/AppRuntime:getApplication	()Lmqq/app/MobileQQ;
    //   4538: getstatic 15	aqlw:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   4541: invokestatic 2591	java/lang/System:currentTimeMillis	()J
    //   4544: invokestatic 2697	bfyz:a	(Landroid/content/Context;Ljava/lang/String;J)V
    //   4547: aload 17
    //   4549: monitorenter
    //   4550: aload 17
    //   4552: getfield 2698	com/tencent/mobileqq/upgrade/UpgradeDetailWrapper:jdField_a_of_type_Boolean	Z
    //   4555: ifne +27 -> 4582
    //   4558: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4561: ifeq +12 -> 4573
    //   4564: ldc 183
    //   4566: iconst_2
    //   4567: ldc_w 2700
    //   4570: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4573: aload 17
    //   4575: monitorexit
    //   4576: iconst_1
    //   4577: istore 10
    //   4579: goto +7174 -> 11753
    //   4582: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4585: ifeq +12 -> 4597
    //   4588: ldc 183
    //   4590: iconst_2
    //   4591: ldc_w 2702
    //   4594: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4597: aload 17
    //   4599: getfield 2704	com/tencent/mobileqq/upgrade/UpgradeDetailWrapper:jdField_b_of_type_Int	I
    //   4602: ifne +21 -> 4623
    //   4605: aload 17
    //   4607: getfield 2705	com/tencent/mobileqq/upgrade/UpgradeDetailWrapper:jdField_a_of_type_Int	I
    //   4610: iconst_1
    //   4611: if_icmpne +7164 -> 11775
    //   4614: iconst_1
    //   4615: istore 10
    //   4617: aload_2
    //   4618: iload 10
    //   4620: invokestatic 2706	ampt:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Z)V
    //   4623: aload 19
    //   4625: invokevirtual 2688	ampt:d	()V
    //   4628: invokestatic 2447	bfng:a	()Lbfng;
    //   4631: aload 17
    //   4633: getfield 2661	com/tencent/mobileqq/upgrade/UpgradeDetailWrapper:jdField_b_of_type_ProtocolKQQConfigUpgradeInfo	Lprotocol/KQQConfig/UpgradeInfo;
    //   4636: aload 19
    //   4638: invokevirtual 2709	bfng:a	(Lprotocol/KQQConfig/UpgradeInfo;Lbfni;)Z
    //   4641: pop
    //   4642: aload 17
    //   4644: monitorexit
    //   4645: iconst_1
    //   4646: istore 10
    //   4648: goto +7105 -> 11753
    //   4651: astore 16
    //   4653: aload 17
    //   4655: monitorexit
    //   4656: aload 16
    //   4658: athrow
    //   4659: astore 17
    //   4661: iconst_1
    //   4662: istore 10
    //   4664: goto -697 -> 3967
    //   4667: aload 19
    //   4669: invokevirtual 2688	ampt:d	()V
    //   4672: aload 19
    //   4674: invokestatic 2447	bfng:a	()Lbfng;
    //   4677: invokevirtual 2450	bfng:a	()Lcom/tencent/mobileqq/upgrade/UpgradeDetailWrapper;
    //   4680: invokevirtual 2453	ampt:a	(Lcom/tencent/mobileqq/upgrade/UpgradeDetailWrapper;)V
    //   4683: goto +7070 -> 11753
    //   4686: aload 19
    //   4688: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   4691: ifnull +141 -> 4832
    //   4694: aload 19
    //   4696: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   4699: invokevirtual 113	com/tencent/mobileqq/pb/PBRepeatField:size	()I
    //   4702: ifle +130 -> 4832
    //   4705: aload_0
    //   4706: invokevirtual 47	aqlw:getAppRuntime	()Lmqq/app/AppRuntime;
    //   4709: invokevirtual 2615	mqq/app/AppRuntime:getApplication	()Lmqq/app/MobileQQ;
    //   4712: aload 19
    //   4714: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   4717: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   4720: getstatic 15	aqlw:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   4723: invokestatic 2711	bfyz:f	(Landroid/content/Context;ILjava/lang/String;)V
    //   4726: iconst_0
    //   4727: istore 7
    //   4729: iload 7
    //   4731: aload 19
    //   4733: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   4736: invokevirtual 113	com/tencent/mobileqq/pb/PBRepeatField:size	()I
    //   4739: if_icmpge +7051 -> 11790
    //   4742: aload 19
    //   4744: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   4747: iload 7
    //   4749: invokevirtual 116	com/tencent/mobileqq/pb/PBRepeatField:get	(I)Ljava/lang/Object;
    //   4752: checkcast 118	java/lang/String
    //   4755: astore 16
    //   4757: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4760: ifeq +47 -> 4807
    //   4763: ldc 183
    //   4765: iconst_2
    //   4766: new 85	java/lang/StringBuilder
    //   4769: dup
    //   4770: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   4773: ldc_w 2713
    //   4776: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4779: aload 16
    //   4781: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4784: ldc_w 606
    //   4787: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4790: aload 19
    //   4792: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   4795: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   4798: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4801: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4804: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4807: aload 16
    //   4809: invokestatic 126	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4812: ifne +6969 -> 11781
    //   4815: aload_2
    //   4816: bipush 60
    //   4818: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   4821: checkcast 2715	com/tencent/mobileqq/app/HotChatManager
    //   4824: aload 16
    //   4826: invokevirtual 2717	com/tencent/mobileqq/app/HotChatManager:d	(Ljava/lang/String;)V
    //   4829: goto +6952 -> 11781
    //   4832: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4835: ifeq +6918 -> 11753
    //   4838: ldc 183
    //   4840: iconst_2
    //   4841: new 85	java/lang/StringBuilder
    //   4844: dup
    //   4845: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   4848: ldc_w 2719
    //   4851: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4854: aload 19
    //   4856: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   4859: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   4862: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4865: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4868: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4871: goto +6882 -> 11753
    //   4874: aload 19
    //   4876: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   4879: ifnull +142 -> 5021
    //   4882: aload 19
    //   4884: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   4887: invokevirtual 113	com/tencent/mobileqq/pb/PBRepeatField:size	()I
    //   4890: ifle +131 -> 5021
    //   4893: aload_0
    //   4894: invokevirtual 47	aqlw:getAppRuntime	()Lmqq/app/AppRuntime;
    //   4897: invokevirtual 2615	mqq/app/AppRuntime:getApplication	()Lmqq/app/MobileQQ;
    //   4900: aload 19
    //   4902: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   4905: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   4908: getstatic 15	aqlw:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   4911: invokestatic 2721	bfyz:d	(Landroid/content/Context;ILjava/lang/String;)V
    //   4914: iconst_0
    //   4915: istore 7
    //   4917: iload 7
    //   4919: aload 19
    //   4921: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   4924: invokevirtual 113	com/tencent/mobileqq/pb/PBRepeatField:size	()I
    //   4927: if_icmpge +6875 -> 11802
    //   4930: aload 19
    //   4932: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   4935: iload 7
    //   4937: invokevirtual 116	com/tencent/mobileqq/pb/PBRepeatField:get	(I)Ljava/lang/Object;
    //   4940: checkcast 118	java/lang/String
    //   4943: astore 16
    //   4945: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4948: ifeq +47 -> 4995
    //   4951: ldc 183
    //   4953: iconst_2
    //   4954: new 85	java/lang/StringBuilder
    //   4957: dup
    //   4958: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   4961: ldc_w 2723
    //   4964: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4967: aload 16
    //   4969: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4972: ldc_w 606
    //   4975: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4978: aload 19
    //   4980: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   4983: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   4986: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4989: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4992: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4995: aload 16
    //   4997: invokestatic 126	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   5000: ifne +6793 -> 11793
    //   5003: aload_2
    //   5004: bipush 51
    //   5006: invokevirtual 208	com/tencent/mobileqq/app/QQAppInterface:getBusinessHandler	(I)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   5009: checkcast 2725	aara
    //   5012: aload 16
    //   5014: iconst_0
    //   5015: invokevirtual 2728	aara:a	(Ljava/lang/String;Z)V
    //   5018: goto +6775 -> 11793
    //   5021: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5024: ifeq +6729 -> 11753
    //   5027: ldc 183
    //   5029: iconst_2
    //   5030: new 85	java/lang/StringBuilder
    //   5033: dup
    //   5034: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   5037: ldc_w 2730
    //   5040: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5043: aload 19
    //   5045: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   5048: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   5051: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5054: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5057: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   5060: goto +6693 -> 11753
    //   5063: aload 19
    //   5065: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   5068: ifnull +6685 -> 11753
    //   5071: aload_0
    //   5072: invokevirtual 47	aqlw:getAppRuntime	()Lmqq/app/AppRuntime;
    //   5075: invokevirtual 2615	mqq/app/AppRuntime:getApplication	()Lmqq/app/MobileQQ;
    //   5078: aload 19
    //   5080: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   5083: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   5086: getstatic 15	aqlw:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   5089: invokestatic 2732	bfyz:e	(Landroid/content/Context;ILjava/lang/String;)V
    //   5092: aload_2
    //   5093: bipush 51
    //   5095: invokevirtual 208	com/tencent/mobileqq/app/QQAppInterface:getBusinessHandler	(I)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   5098: checkcast 2725	aara
    //   5101: aload 19
    //   5103: invokevirtual 2734	aara:a	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   5106: goto +6647 -> 11753
    //   5109: aload 19
    //   5111: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   5114: ifnull +276 -> 5390
    //   5117: aload 19
    //   5119: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   5122: invokevirtual 113	com/tencent/mobileqq/pb/PBRepeatField:size	()I
    //   5125: ifle +265 -> 5390
    //   5128: new 2736	java/io/File
    //   5131: dup
    //   5132: new 85	java/lang/StringBuilder
    //   5135: dup
    //   5136: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   5139: aload_0
    //   5140: invokevirtual 47	aqlw:getAppRuntime	()Lmqq/app/AppRuntime;
    //   5143: invokevirtual 2615	mqq/app/AppRuntime:getApplication	()Lmqq/app/MobileQQ;
    //   5146: invokevirtual 2742	mqq/app/MobileQQ:getFilesDir	()Ljava/io/File;
    //   5149: invokevirtual 2745	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   5152: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5155: ldc_w 2747
    //   5158: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5161: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5164: invokespecial 2748	java/io/File:<init>	(Ljava/lang/String;)V
    //   5167: astore 16
    //   5169: aload 16
    //   5171: invokevirtual 2751	java/io/File:exists	()Z
    //   5174: ifne +152 -> 5326
    //   5177: aload 16
    //   5179: invokevirtual 2754	java/io/File:mkdirs	()Z
    //   5182: pop
    //   5183: aload 19
    //   5185: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   5188: invokevirtual 1154	com/tencent/mobileqq/pb/PBRepeatField:get	()Ljava/util/List;
    //   5191: invokeinterface 235 1 0
    //   5196: astore 16
    //   5198: aload 16
    //   5200: invokeinterface 240 1 0
    //   5205: ifeq +6609 -> 11814
    //   5208: aload 16
    //   5210: invokeinterface 244 1 0
    //   5215: checkcast 118	java/lang/String
    //   5218: astore 17
    //   5220: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5223: ifeq +47 -> 5270
    //   5226: ldc 183
    //   5228: iconst_2
    //   5229: new 85	java/lang/StringBuilder
    //   5232: dup
    //   5233: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   5236: ldc_w 2756
    //   5239: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5242: aload 17
    //   5244: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5247: ldc_w 606
    //   5250: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5253: aload 19
    //   5255: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   5258: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   5261: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5264: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5267: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   5270: aload_0
    //   5271: aload 17
    //   5273: aload 19
    //   5275: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   5278: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   5281: invokespecial 2759	aqlw:e	(Ljava/lang/String;I)V
    //   5284: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5287: ifeq -89 -> 5198
    //   5290: ldc 183
    //   5292: iconst_2
    //   5293: new 85	java/lang/StringBuilder
    //   5296: dup
    //   5297: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   5300: ldc_w 2761
    //   5303: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5306: aload 19
    //   5308: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   5311: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   5314: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5317: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5320: invokestatic 200	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   5323: goto -125 -> 5198
    //   5326: aload 16
    //   5328: ifnull -145 -> 5183
    //   5331: aload 16
    //   5333: invokevirtual 2764	java/io/File:isDirectory	()Z
    //   5336: ifeq -153 -> 5183
    //   5339: aload 16
    //   5341: invokevirtual 2768	java/io/File:listFiles	()[Ljava/io/File;
    //   5344: astore 16
    //   5346: aload 16
    //   5348: arraylength
    //   5349: istore 8
    //   5351: iconst_0
    //   5352: istore 7
    //   5354: iload 7
    //   5356: iload 8
    //   5358: if_icmpge -175 -> 5183
    //   5361: aload 16
    //   5363: iload 7
    //   5365: aaload
    //   5366: astore 17
    //   5368: aload 17
    //   5370: ifnull +6435 -> 11805
    //   5373: aload 17
    //   5375: invokevirtual 2751	java/io/File:exists	()Z
    //   5378: ifeq +6427 -> 11805
    //   5381: aload 17
    //   5383: invokevirtual 2771	java/io/File:delete	()Z
    //   5386: pop
    //   5387: goto +6418 -> 11805
    //   5390: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5393: ifeq +36 -> 5429
    //   5396: ldc 183
    //   5398: iconst_2
    //   5399: new 85	java/lang/StringBuilder
    //   5402: dup
    //   5403: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   5406: ldc_w 2773
    //   5409: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5412: aload 19
    //   5414: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   5417: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   5420: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5423: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5426: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   5429: new 2736	java/io/File
    //   5432: dup
    //   5433: new 85	java/lang/StringBuilder
    //   5436: dup
    //   5437: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   5440: aload_0
    //   5441: invokevirtual 47	aqlw:getAppRuntime	()Lmqq/app/AppRuntime;
    //   5444: invokevirtual 2615	mqq/app/AppRuntime:getApplication	()Lmqq/app/MobileQQ;
    //   5447: invokevirtual 2742	mqq/app/MobileQQ:getFilesDir	()Ljava/io/File;
    //   5450: invokevirtual 2745	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   5453: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5456: ldc_w 2775
    //   5459: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5462: ldc_w 2777
    //   5465: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5468: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5471: invokespecial 2748	java/io/File:<init>	(Ljava/lang/String;)V
    //   5474: astore 16
    //   5476: aload 16
    //   5478: ifnull +9 -> 5487
    //   5481: aload 16
    //   5483: invokevirtual 2771	java/io/File:delete	()Z
    //   5486: pop
    //   5487: aload_0
    //   5488: invokevirtual 47	aqlw:getAppRuntime	()Lmqq/app/AppRuntime;
    //   5491: invokevirtual 2615	mqq/app/AppRuntime:getApplication	()Lmqq/app/MobileQQ;
    //   5494: aload 19
    //   5496: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   5499: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   5502: ldc_w 2779
    //   5505: ldc 13
    //   5507: invokestatic 2782	bfyz:a	(Landroid/content/Context;ILjava/lang/String;Ljava/lang/String;)V
    //   5510: goto +6243 -> 11753
    //   5513: aload 19
    //   5515: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   5518: ifnull +323 -> 5841
    //   5521: aload 19
    //   5523: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   5526: invokevirtual 113	com/tencent/mobileqq/pb/PBRepeatField:size	()I
    //   5529: ifle +312 -> 5841
    //   5532: getstatic 2787	apth:a	Laqmi;
    //   5535: invokevirtual 2790	aqmi:b	()V
    //   5538: aload 19
    //   5540: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   5543: invokevirtual 1154	com/tencent/mobileqq/pb/PBRepeatField:get	()Ljava/util/List;
    //   5546: invokeinterface 235 1 0
    //   5551: astore 16
    //   5553: aload 16
    //   5555: invokeinterface 240 1 0
    //   5560: ifeq +82 -> 5642
    //   5563: aload 16
    //   5565: invokeinterface 244 1 0
    //   5570: checkcast 118	java/lang/String
    //   5573: astore 17
    //   5575: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5578: ifeq +47 -> 5625
    //   5581: ldc 183
    //   5583: iconst_2
    //   5584: new 85	java/lang/StringBuilder
    //   5587: dup
    //   5588: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   5591: ldc_w 2792
    //   5594: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5597: aload 17
    //   5599: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5602: ldc_w 606
    //   5605: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5608: aload 19
    //   5610: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   5613: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   5616: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5619: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5622: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   5625: aload_0
    //   5626: aload 17
    //   5628: aload 19
    //   5630: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   5633: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   5636: invokespecial 2794	aqlw:c	(Ljava/lang/String;I)V
    //   5639: goto -86 -> 5553
    //   5642: new 2796	aptj
    //   5645: dup
    //   5646: aload_0
    //   5647: invokevirtual 47	aqlw:getAppRuntime	()Lmqq/app/AppRuntime;
    //   5650: invokevirtual 2615	mqq/app/AppRuntime:getApplication	()Lmqq/app/MobileQQ;
    //   5653: getstatic 15	aqlw:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   5656: invokespecial 2798	aptj:<init>	(Landroid/content/Context;Ljava/lang/String;)V
    //   5659: astore 16
    //   5661: aload 16
    //   5663: ifnull +13 -> 5676
    //   5666: aload 16
    //   5668: invokevirtual 2799	aptj:b	()V
    //   5671: aload 16
    //   5673: invokevirtual 2800	aptj:c	()V
    //   5676: invokestatic 386	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   5679: ldc_w 2802
    //   5682: iconst_0
    //   5683: invokevirtual 341	com/tencent/qphone/base/util/BaseApplication:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   5686: astore 16
    //   5688: aload 16
    //   5690: invokeinterface 347 1 0
    //   5695: new 85	java/lang/StringBuilder
    //   5698: dup
    //   5699: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   5702: ldc_w 2804
    //   5705: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5708: aload_0
    //   5709: invokevirtual 47	aqlw:getAppRuntime	()Lmqq/app/AppRuntime;
    //   5712: invokevirtual 2805	mqq/app/AppRuntime:getAccount	()Ljava/lang/String;
    //   5715: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5718: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5721: iconst_1
    //   5722: invokeinterface 355 3 0
    //   5727: invokeinterface 728 1 0
    //   5732: pop
    //   5733: aload 16
    //   5735: invokeinterface 347 1 0
    //   5740: new 85	java/lang/StringBuilder
    //   5743: dup
    //   5744: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   5747: ldc_w 2807
    //   5750: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5753: aload_0
    //   5754: invokevirtual 47	aqlw:getAppRuntime	()Lmqq/app/AppRuntime;
    //   5757: invokevirtual 2805	mqq/app/AppRuntime:getAccount	()Ljava/lang/String;
    //   5760: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5763: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5766: iconst_1
    //   5767: invokeinterface 355 3 0
    //   5772: invokeinterface 728 1 0
    //   5777: pop
    //   5778: aload_0
    //   5779: invokevirtual 47	aqlw:getAppRuntime	()Lmqq/app/AppRuntime;
    //   5782: invokevirtual 2615	mqq/app/AppRuntime:getApplication	()Lmqq/app/MobileQQ;
    //   5785: aload 19
    //   5787: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   5790: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   5793: getstatic 15	aqlw:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   5796: invokestatic 2711	bfyz:f	(Landroid/content/Context;ILjava/lang/String;)V
    //   5799: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5802: ifeq +6015 -> 11817
    //   5805: ldc 183
    //   5807: iconst_2
    //   5808: new 85	java/lang/StringBuilder
    //   5811: dup
    //   5812: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   5815: ldc_w 2809
    //   5818: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5821: aload 19
    //   5823: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   5826: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   5829: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5832: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5835: invokestatic 200	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   5838: goto +5979 -> 11817
    //   5841: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5844: ifeq +36 -> 5880
    //   5847: ldc 183
    //   5849: iconst_2
    //   5850: new 85	java/lang/StringBuilder
    //   5853: dup
    //   5854: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   5857: ldc_w 2811
    //   5860: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5863: aload 19
    //   5865: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   5868: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   5871: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5874: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5877: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   5880: getstatic 2787	apth:a	Laqmi;
    //   5883: invokevirtual 2790	aqmi:b	()V
    //   5886: getstatic 2787	apth:a	Laqmi;
    //   5889: invokevirtual 2812	aqmi:c	()V
    //   5892: new 2796	aptj
    //   5895: dup
    //   5896: aload_0
    //   5897: invokevirtual 47	aqlw:getAppRuntime	()Lmqq/app/AppRuntime;
    //   5900: invokevirtual 2615	mqq/app/AppRuntime:getApplication	()Lmqq/app/MobileQQ;
    //   5903: getstatic 15	aqlw:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   5906: invokespecial 2798	aptj:<init>	(Landroid/content/Context;Ljava/lang/String;)V
    //   5909: astore 16
    //   5911: aload 16
    //   5913: ifnull +13 -> 5926
    //   5916: aload 16
    //   5918: invokevirtual 2799	aptj:b	()V
    //   5921: aload 16
    //   5923: invokevirtual 2800	aptj:c	()V
    //   5926: invokestatic 386	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   5929: ldc_w 2802
    //   5932: iconst_0
    //   5933: invokevirtual 341	com/tencent/qphone/base/util/BaseApplication:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   5936: invokeinterface 347 1 0
    //   5941: new 85	java/lang/StringBuilder
    //   5944: dup
    //   5945: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   5948: ldc_w 2807
    //   5951: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5954: aload_0
    //   5955: invokevirtual 47	aqlw:getAppRuntime	()Lmqq/app/AppRuntime;
    //   5958: invokevirtual 2805	mqq/app/AppRuntime:getAccount	()Ljava/lang/String;
    //   5961: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5964: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5967: iconst_0
    //   5968: invokeinterface 355 3 0
    //   5973: invokeinterface 728 1 0
    //   5978: pop
    //   5979: aload_0
    //   5980: invokevirtual 47	aqlw:getAppRuntime	()Lmqq/app/AppRuntime;
    //   5983: invokevirtual 2615	mqq/app/AppRuntime:getApplication	()Lmqq/app/MobileQQ;
    //   5986: aload 19
    //   5988: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   5991: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   5994: getstatic 15	aqlw:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   5997: invokestatic 2711	bfyz:f	(Landroid/content/Context;ILjava/lang/String;)V
    //   6000: goto +5753 -> 11753
    //   6003: aload 19
    //   6005: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   6008: ifnull +95 -> 6103
    //   6011: aload 19
    //   6013: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   6016: invokevirtual 113	com/tencent/mobileqq/pb/PBRepeatField:size	()I
    //   6019: ifle +84 -> 6103
    //   6022: aload 19
    //   6024: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   6027: iconst_0
    //   6028: invokevirtual 116	com/tencent/mobileqq/pb/PBRepeatField:get	(I)Ljava/lang/Object;
    //   6031: checkcast 118	java/lang/String
    //   6034: astore 16
    //   6036: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6039: ifeq +47 -> 6086
    //   6042: ldc 183
    //   6044: iconst_2
    //   6045: new 85	java/lang/StringBuilder
    //   6048: dup
    //   6049: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   6052: ldc_w 2814
    //   6055: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6058: aload 16
    //   6060: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6063: ldc_w 606
    //   6066: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6069: aload 19
    //   6071: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   6074: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   6077: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6080: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6083: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   6086: aload_0
    //   6087: aload 16
    //   6089: aload 19
    //   6091: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   6094: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   6097: invokespecial 2816	aqlw:d	(Ljava/lang/String;I)V
    //   6100: goto +5653 -> 11753
    //   6103: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6106: ifeq +36 -> 6142
    //   6109: ldc 183
    //   6111: iconst_2
    //   6112: new 85	java/lang/StringBuilder
    //   6115: dup
    //   6116: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   6119: ldc_w 2818
    //   6122: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6125: aload 19
    //   6127: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   6130: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   6133: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6136: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6139: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   6142: new 2736	java/io/File
    //   6145: dup
    //   6146: new 85	java/lang/StringBuilder
    //   6149: dup
    //   6150: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   6153: aload_0
    //   6154: invokevirtual 47	aqlw:getAppRuntime	()Lmqq/app/AppRuntime;
    //   6157: invokevirtual 2615	mqq/app/AppRuntime:getApplication	()Lmqq/app/MobileQQ;
    //   6160: invokevirtual 2742	mqq/app/MobileQQ:getFilesDir	()Ljava/io/File;
    //   6163: invokevirtual 2745	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   6166: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6169: ldc_w 2775
    //   6172: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6175: getstatic 15	aqlw:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   6178: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6181: ldc_w 2775
    //   6184: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6187: ldc_w 2820
    //   6190: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6193: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6196: invokespecial 2748	java/io/File:<init>	(Ljava/lang/String;)V
    //   6199: astore 16
    //   6201: aload 16
    //   6203: invokevirtual 2751	java/io/File:exists	()Z
    //   6206: ifeq +9 -> 6215
    //   6209: aload 16
    //   6211: invokevirtual 2771	java/io/File:delete	()Z
    //   6214: pop
    //   6215: aload_0
    //   6216: invokevirtual 47	aqlw:getAppRuntime	()Lmqq/app/AppRuntime;
    //   6219: invokevirtual 2615	mqq/app/AppRuntime:getApplication	()Lmqq/app/MobileQQ;
    //   6222: aload 19
    //   6224: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   6227: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   6230: ldc 13
    //   6232: getstatic 15	aqlw:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   6235: invokestatic 2822	bfyz:b	(Landroid/content/Context;ILjava/lang/String;Ljava/lang/String;)V
    //   6238: goto +5515 -> 11753
    //   6241: aload 19
    //   6243: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   6246: ifnull +178 -> 6424
    //   6249: aload 19
    //   6251: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   6254: invokevirtual 113	com/tencent/mobileqq/pb/PBRepeatField:size	()I
    //   6257: ifle +167 -> 6424
    //   6260: new 1132	java/util/ArrayList
    //   6263: dup
    //   6264: invokespecial 1133	java/util/ArrayList:<init>	()V
    //   6267: astore 16
    //   6269: iconst_0
    //   6270: istore 7
    //   6272: iload 7
    //   6274: aload 19
    //   6276: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   6279: invokevirtual 113	com/tencent/mobileqq/pb/PBRepeatField:size	()I
    //   6282: if_icmpge +92 -> 6374
    //   6285: aload 19
    //   6287: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   6290: iload 7
    //   6292: invokevirtual 116	com/tencent/mobileqq/pb/PBRepeatField:get	(I)Ljava/lang/Object;
    //   6295: checkcast 118	java/lang/String
    //   6298: astore 17
    //   6300: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6303: ifeq +47 -> 6350
    //   6306: ldc 183
    //   6308: iconst_2
    //   6309: new 85	java/lang/StringBuilder
    //   6312: dup
    //   6313: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   6316: ldc_w 2824
    //   6319: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6322: aload 17
    //   6324: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6327: ldc_w 606
    //   6330: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6333: aload 19
    //   6335: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   6338: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   6341: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6344: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6347: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   6350: aload_0
    //   6351: aload 17
    //   6353: invokespecial 2826	aqlw:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/config/operation/QQOperationViopTipTask;
    //   6356: astore 17
    //   6358: aload 17
    //   6360: ifnull +5460 -> 11820
    //   6363: aload 16
    //   6365: aload 17
    //   6367: invokevirtual 1166	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   6370: pop
    //   6371: goto +5449 -> 11820
    //   6374: aload_0
    //   6375: invokevirtual 47	aqlw:getAppRuntime	()Lmqq/app/AppRuntime;
    //   6378: checkcast 49	com/tencent/mobileqq/app/QQAppInterface
    //   6381: invokestatic 2831	aqlq:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)Laqlq;
    //   6384: aload_0
    //   6385: invokevirtual 47	aqlw:getAppRuntime	()Lmqq/app/AppRuntime;
    //   6388: checkcast 49	com/tencent/mobileqq/app/QQAppInterface
    //   6391: aload 16
    //   6393: invokevirtual 2834	aqlq:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/util/ArrayList;)V
    //   6396: aload_0
    //   6397: invokevirtual 47	aqlw:getAppRuntime	()Lmqq/app/AppRuntime;
    //   6400: invokevirtual 2615	mqq/app/AppRuntime:getApplication	()Lmqq/app/MobileQQ;
    //   6403: aload_0
    //   6404: invokevirtual 47	aqlw:getAppRuntime	()Lmqq/app/AppRuntime;
    //   6407: invokevirtual 2805	mqq/app/AppRuntime:getAccount	()Ljava/lang/String;
    //   6410: aload 19
    //   6412: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   6415: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   6418: invokestatic 2835	bfyz:a	(Landroid/content/Context;Ljava/lang/String;I)V
    //   6421: goto +5332 -> 11753
    //   6424: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6427: ifeq +5326 -> 11753
    //   6430: ldc 183
    //   6432: iconst_2
    //   6433: new 85	java/lang/StringBuilder
    //   6436: dup
    //   6437: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   6440: ldc_w 2837
    //   6443: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6446: aload 19
    //   6448: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   6451: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   6454: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6457: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6460: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   6463: goto +5290 -> 11753
    //   6466: aload_2
    //   6467: bipush 74
    //   6469: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   6472: checkcast 1402	aqmg
    //   6475: astore 16
    //   6477: aload 16
    //   6479: invokevirtual 2840	aqmg:a	()Ljava/util/Set;
    //   6482: astore 20
    //   6484: new 2789	aqmi
    //   6487: dup
    //   6488: bipush 21
    //   6490: iconst_2
    //   6491: invokespecial 2843	aqmi:<init>	(SB)V
    //   6494: astore 17
    //   6496: aload 19
    //   6498: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   6501: ifnull +129 -> 6630
    //   6504: aload 19
    //   6506: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   6509: invokevirtual 113	com/tencent/mobileqq/pb/PBRepeatField:size	()I
    //   6512: ifle +118 -> 6630
    //   6515: aload 19
    //   6517: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   6520: invokevirtual 1154	com/tencent/mobileqq/pb/PBRepeatField:get	()Ljava/util/List;
    //   6523: invokeinterface 235 1 0
    //   6528: astore 21
    //   6530: aload 21
    //   6532: invokeinterface 240 1 0
    //   6537: ifeq +132 -> 6669
    //   6540: aload 21
    //   6542: invokeinterface 244 1 0
    //   6547: checkcast 118	java/lang/String
    //   6550: astore 22
    //   6552: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6555: ifeq +47 -> 6602
    //   6558: ldc 183
    //   6560: iconst_2
    //   6561: new 85	java/lang/StringBuilder
    //   6564: dup
    //   6565: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   6568: ldc_w 2845
    //   6571: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6574: aload 22
    //   6576: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6579: ldc_w 606
    //   6582: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6585: aload 19
    //   6587: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   6590: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   6593: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6596: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6599: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   6602: aload 17
    //   6604: aload 22
    //   6606: aload 20
    //   6608: invokestatic 2848	aqlw:a	(Laqmi;Ljava/lang/String;Ljava/util/Set;)Z
    //   6611: pop
    //   6612: aload 16
    //   6614: aload 17
    //   6616: aload 19
    //   6618: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   6621: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   6624: invokevirtual 2851	aqmg:a	(Laqmi;I)V
    //   6627: goto -97 -> 6530
    //   6630: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6633: ifeq +36 -> 6669
    //   6636: ldc 183
    //   6638: iconst_2
    //   6639: new 85	java/lang/StringBuilder
    //   6642: dup
    //   6643: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   6646: ldc_w 2853
    //   6649: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6652: aload 19
    //   6654: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   6657: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   6660: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6663: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6666: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   6669: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6672: ifeq +76 -> 6748
    //   6675: new 85	java/lang/StringBuilder
    //   6678: dup
    //   6679: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   6682: ldc_w 2855
    //   6685: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6688: astore 20
    //   6690: aload 19
    //   6692: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   6695: ifnonnull +69 -> 6764
    //   6698: iconst_0
    //   6699: istore 7
    //   6701: ldc 183
    //   6703: iconst_2
    //   6704: aload 20
    //   6706: iload 7
    //   6708: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6711: ldc_w 2857
    //   6714: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6717: aload 17
    //   6719: invokevirtual 2858	aqmi:a	()I
    //   6722: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6725: ldc_w 2860
    //   6728: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6731: aload 19
    //   6733: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   6736: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   6739: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6742: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6745: invokestatic 200	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   6748: aload 16
    //   6750: aload 19
    //   6752: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   6755: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   6758: invokevirtual 2861	aqmg:a	(I)V
    //   6761: goto +4992 -> 11753
    //   6764: aload 19
    //   6766: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   6769: invokevirtual 1154	com/tencent/mobileqq/pb/PBRepeatField:get	()Ljava/util/List;
    //   6772: invokeinterface 401 1 0
    //   6777: istore 7
    //   6779: goto -78 -> 6701
    //   6782: aload_2
    //   6783: invokevirtual 65	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   6786: aload_2
    //   6787: invokevirtual 412	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   6790: invokestatic 1428	bfyz:j	(Landroid/content/Context;Ljava/lang/String;)I
    //   6793: istore 8
    //   6795: aload 19
    //   6797: ifnull +5032 -> 11829
    //   6800: aload 19
    //   6802: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   6805: ifnull +5024 -> 11829
    //   6808: aload 19
    //   6810: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   6813: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   6816: istore 7
    //   6818: aload 19
    //   6820: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   6823: ifnull +185 -> 7008
    //   6826: aload 19
    //   6828: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   6831: invokevirtual 113	com/tencent/mobileqq/pb/PBRepeatField:size	()I
    //   6834: ifle +174 -> 7008
    //   6837: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6840: ifeq +79 -> 6919
    //   6843: ldc 183
    //   6845: iconst_2
    //   6846: new 85	java/lang/StringBuilder
    //   6849: dup
    //   6850: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   6853: ldc_w 2863
    //   6856: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6859: iload 7
    //   6861: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6864: ldc_w 2865
    //   6867: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6870: iload 8
    //   6872: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6875: ldc_w 2867
    //   6878: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6881: aload 19
    //   6883: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   6886: invokevirtual 113	com/tencent/mobileqq/pb/PBRepeatField:size	()I
    //   6889: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6892: ldc_w 2869
    //   6895: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6898: aload 19
    //   6900: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   6903: iconst_0
    //   6904: invokevirtual 116	com/tencent/mobileqq/pb/PBRepeatField:get	(I)Ljava/lang/Object;
    //   6907: checkcast 118	java/lang/String
    //   6910: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6913: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6916: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   6919: new 524	java/util/HashSet
    //   6922: dup
    //   6923: invokespecial 525	java/util/HashSet:<init>	()V
    //   6926: astore 16
    //   6928: iconst_0
    //   6929: istore 8
    //   6931: iload 8
    //   6933: aload 19
    //   6935: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   6938: invokevirtual 113	com/tencent/mobileqq/pb/PBRepeatField:size	()I
    //   6941: if_icmpge +30 -> 6971
    //   6944: aload 16
    //   6946: aload 19
    //   6948: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   6951: iload 8
    //   6953: invokevirtual 116	com/tencent/mobileqq/pb/PBRepeatField:get	(I)Ljava/lang/Object;
    //   6956: invokeinterface 2872 2 0
    //   6961: pop
    //   6962: iload 8
    //   6964: iconst_1
    //   6965: iadd
    //   6966: istore 8
    //   6968: goto -37 -> 6931
    //   6971: aload_2
    //   6972: sipush 138
    //   6975: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   6978: checkcast 2874	ahux
    //   6981: aload 16
    //   6983: invokevirtual 2877	ahux:a	(Ljava/util/Set;)V
    //   6986: aload_0
    //   6987: invokevirtual 47	aqlw:getAppRuntime	()Lmqq/app/AppRuntime;
    //   6990: invokevirtual 2615	mqq/app/AppRuntime:getApplication	()Lmqq/app/MobileQQ;
    //   6993: aload_0
    //   6994: invokevirtual 47	aqlw:getAppRuntime	()Lmqq/app/AppRuntime;
    //   6997: invokevirtual 2805	mqq/app/AppRuntime:getAccount	()Ljava/lang/String;
    //   7000: iload 7
    //   7002: invokestatic 2878	bfyz:b	(Landroid/content/Context;Ljava/lang/String;I)V
    //   7005: goto +4831 -> 11836
    //   7008: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7011: ifeq +41 -> 7052
    //   7014: ldc 183
    //   7016: iconst_2
    //   7017: new 85	java/lang/StringBuilder
    //   7020: dup
    //   7021: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   7024: ldc_w 2880
    //   7027: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7030: iload 7
    //   7032: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7035: ldc_w 2865
    //   7038: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7041: iload 8
    //   7043: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7046: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7049: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   7052: iload 8
    //   7054: iload 7
    //   7056: if_icmpeq +4780 -> 11836
    //   7059: aload_2
    //   7060: sipush 138
    //   7063: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   7066: checkcast 2874	ahux
    //   7069: invokevirtual 2881	ahux:a	()V
    //   7072: aload_0
    //   7073: invokevirtual 47	aqlw:getAppRuntime	()Lmqq/app/AppRuntime;
    //   7076: invokevirtual 2615	mqq/app/AppRuntime:getApplication	()Lmqq/app/MobileQQ;
    //   7079: aload_0
    //   7080: invokevirtual 47	aqlw:getAppRuntime	()Lmqq/app/AppRuntime;
    //   7083: invokevirtual 2805	mqq/app/AppRuntime:getAccount	()Ljava/lang/String;
    //   7086: iload 7
    //   7088: invokestatic 2878	bfyz:b	(Landroid/content/Context;Ljava/lang/String;I)V
    //   7091: goto +4745 -> 11836
    //   7094: aload 19
    //   7096: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   7099: ifnull +4632 -> 11731
    //   7102: aload 19
    //   7104: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   7107: invokevirtual 113	com/tencent/mobileqq/pb/PBRepeatField:size	()I
    //   7110: ifle +4621 -> 11731
    //   7113: aload 19
    //   7115: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   7118: invokevirtual 1154	com/tencent/mobileqq/pb/PBRepeatField:get	()Ljava/util/List;
    //   7121: astore 16
    //   7123: aload 16
    //   7125: ifnull +195 -> 7320
    //   7128: aload 16
    //   7130: invokeinterface 401 1 0
    //   7135: ifle +185 -> 7320
    //   7138: aload 16
    //   7140: iconst_0
    //   7141: invokeinterface 450 2 0
    //   7146: checkcast 118	java/lang/String
    //   7149: astore 17
    //   7151: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7154: ifeq +47 -> 7201
    //   7157: ldc 183
    //   7159: iconst_2
    //   7160: new 85	java/lang/StringBuilder
    //   7163: dup
    //   7164: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   7167: ldc_w 2883
    //   7170: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7173: aload 17
    //   7175: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7178: ldc_w 606
    //   7181: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7184: aload 19
    //   7186: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   7189: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   7192: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7195: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7198: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   7201: aload 17
    //   7203: invokestatic 2886	nns:a	(Ljava/lang/String;)V
    //   7206: aload 16
    //   7208: invokeinterface 235 1 0
    //   7213: astore 16
    //   7215: aload 16
    //   7217: invokeinterface 240 1 0
    //   7222: ifeq +73 -> 7295
    //   7225: aload 16
    //   7227: invokeinterface 244 1 0
    //   7232: checkcast 118	java/lang/String
    //   7235: astore 17
    //   7237: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7240: ifeq +47 -> 7287
    //   7243: ldc 183
    //   7245: iconst_2
    //   7246: new 85	java/lang/StringBuilder
    //   7249: dup
    //   7250: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   7253: ldc_w 2883
    //   7256: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7259: aload 17
    //   7261: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7264: ldc_w 606
    //   7267: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7270: aload 19
    //   7272: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   7275: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   7278: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7281: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7284: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   7287: aload 17
    //   7289: invokestatic 2890	ahpe:a	(Ljava/lang/String;)Z
    //   7292: ifeq -77 -> 7215
    //   7295: aload 19
    //   7297: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   7300: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   7303: istore 7
    //   7305: aload_0
    //   7306: invokevirtual 47	aqlw:getAppRuntime	()Lmqq/app/AppRuntime;
    //   7309: invokevirtual 2615	mqq/app/AppRuntime:getApplication	()Lmqq/app/MobileQQ;
    //   7312: iload 7
    //   7314: invokestatic 2893	bfyz:b	(Landroid/content/Context;I)V
    //   7317: goto +4436 -> 11753
    //   7320: aconst_null
    //   7321: invokestatic 2886	nns:a	(Ljava/lang/String;)V
    //   7324: invokestatic 2894	ahpe:a	()V
    //   7327: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7330: ifeq -35 -> 7295
    //   7333: ldc 183
    //   7335: iconst_2
    //   7336: new 85	java/lang/StringBuilder
    //   7339: dup
    //   7340: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   7343: ldc_w 2896
    //   7346: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7349: aload 19
    //   7351: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   7354: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   7357: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7360: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7363: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   7366: goto -71 -> 7295
    //   7369: invokestatic 386	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   7372: aload_2
    //   7373: invokevirtual 69	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   7376: invokestatic 1440	cooperation/pluginbridge/BridgeHelper:a	(Landroid/content/Context;Ljava/lang/String;)Lcooperation/pluginbridge/BridgeHelper;
    //   7379: aload 19
    //   7381: invokevirtual 2897	cooperation/pluginbridge/BridgeHelper:a	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   7384: goto +4369 -> 11753
    //   7387: aload_0
    //   7388: aload_3
    //   7389: aload 19
    //   7391: invokespecial 2900	aqlw:l	(Landroid/content/Intent;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   7394: goto +4359 -> 11753
    //   7397: aload_0
    //   7398: aload_3
    //   7399: aload 19
    //   7401: invokespecial 2902	aqlw:j	(Landroid/content/Intent;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   7404: goto +4349 -> 11753
    //   7407: aload_0
    //   7408: aload_3
    //   7409: aload 19
    //   7411: invokespecial 2904	aqlw:k	(Landroid/content/Intent;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   7414: goto +4339 -> 11753
    //   7417: aload_0
    //   7418: aload 19
    //   7420: invokespecial 2906	aqlw:j	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   7423: goto +4330 -> 11753
    //   7426: aload_0
    //   7427: aload 19
    //   7429: invokespecial 2908	aqlw:i	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   7432: goto +4321 -> 11753
    //   7435: aload 19
    //   7437: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   7440: ifnull +103 -> 7543
    //   7443: aload 19
    //   7445: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   7448: invokevirtual 113	com/tencent/mobileqq/pb/PBRepeatField:size	()I
    //   7451: ifle +92 -> 7543
    //   7454: aload 19
    //   7456: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   7459: iconst_0
    //   7460: invokevirtual 116	com/tencent/mobileqq/pb/PBRepeatField:get	(I)Ljava/lang/Object;
    //   7463: checkcast 118	java/lang/String
    //   7466: astore 16
    //   7468: aload 19
    //   7470: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   7473: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   7476: istore 7
    //   7478: aload_2
    //   7479: invokevirtual 2912	com/tencent/mobileqq/app/QQAppInterface:getAVNotifyCenter	()Lcom/tencent/av/gaudio/AVNotifyCenter;
    //   7482: aload_2
    //   7483: aload 16
    //   7485: iload 7
    //   7487: invokevirtual 2916	com/tencent/av/gaudio/AVNotifyCenter:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;I)V
    //   7490: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7493: ifeq +4346 -> 11839
    //   7496: ldc 183
    //   7498: iconst_2
    //   7499: new 85	java/lang/StringBuilder
    //   7502: dup
    //   7503: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   7506: ldc_w 2918
    //   7509: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7512: aload 16
    //   7514: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7517: ldc_w 606
    //   7520: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7523: aload 19
    //   7525: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   7528: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   7531: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7534: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7537: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   7540: goto +4299 -> 11839
    //   7543: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7546: ifeq +4207 -> 11753
    //   7549: ldc 183
    //   7551: iconst_2
    //   7552: new 85	java/lang/StringBuilder
    //   7555: dup
    //   7556: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   7559: ldc_w 2920
    //   7562: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7565: aload 19
    //   7567: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   7570: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   7573: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7576: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7579: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   7582: goto +4171 -> 11753
    //   7585: aload_2
    //   7586: sipush 177
    //   7589: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   7592: checkcast 2922	bger
    //   7595: astore 16
    //   7597: aload 19
    //   7599: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   7602: ifnull +98 -> 7700
    //   7605: aload 19
    //   7607: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   7610: invokevirtual 113	com/tencent/mobileqq/pb/PBRepeatField:size	()I
    //   7613: ifle +87 -> 7700
    //   7616: aload 19
    //   7618: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   7621: iconst_0
    //   7622: invokevirtual 116	com/tencent/mobileqq/pb/PBRepeatField:get	(I)Ljava/lang/Object;
    //   7625: checkcast 118	java/lang/String
    //   7628: astore 17
    //   7630: aload 19
    //   7632: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   7635: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   7638: istore 7
    //   7640: aload 16
    //   7642: aload 17
    //   7644: aload_2
    //   7645: invokevirtual 412	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   7648: iload 7
    //   7650: invokevirtual 2925	bger:a	(Ljava/lang/String;Ljava/lang/String;I)V
    //   7653: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7656: ifeq +4186 -> 11842
    //   7659: ldc 183
    //   7661: iconst_2
    //   7662: new 85	java/lang/StringBuilder
    //   7665: dup
    //   7666: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   7669: ldc_w 2927
    //   7672: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7675: aload 17
    //   7677: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7680: ldc_w 606
    //   7683: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7686: iload 7
    //   7688: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7691: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7694: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   7697: goto +4145 -> 11842
    //   7700: aload 16
    //   7702: aload 19
    //   7704: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   7707: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   7710: aload_2
    //   7711: invokevirtual 412	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   7714: invokevirtual 2930	bger:a	(ILjava/lang/String;)V
    //   7717: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7720: ifeq +4125 -> 11845
    //   7723: ldc 183
    //   7725: iconst_2
    //   7726: new 85	java/lang/StringBuilder
    //   7729: dup
    //   7730: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   7733: ldc_w 2932
    //   7736: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7739: aload 19
    //   7741: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   7744: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   7747: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7750: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7753: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   7756: goto +4089 -> 11845
    //   7759: aload_0
    //   7760: aload_3
    //   7761: aload 19
    //   7763: invokespecial 2934	aqlw:i	(Landroid/content/Intent;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   7766: goto +3987 -> 11753
    //   7769: aload_0
    //   7770: aload_3
    //   7771: aload 19
    //   7773: invokespecial 2936	aqlw:e	(Landroid/content/Intent;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   7776: goto +3977 -> 11753
    //   7779: aload_0
    //   7780: aload_3
    //   7781: aload 19
    //   7783: invokespecial 2938	aqlw:f	(Landroid/content/Intent;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   7786: goto +3967 -> 11753
    //   7789: aload_0
    //   7790: aload_3
    //   7791: aload 19
    //   7793: invokespecial 2940	aqlw:g	(Landroid/content/Intent;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   7796: goto +3957 -> 11753
    //   7799: aload_0
    //   7800: aload_2
    //   7801: aload_3
    //   7802: aload 19
    //   7804: invokespecial 2943	aqlw:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Landroid/content/Intent;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   7807: goto +3946 -> 11753
    //   7810: aload_0
    //   7811: aload_3
    //   7812: aload 19
    //   7814: invokespecial 2945	aqlw:h	(Landroid/content/Intent;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   7817: goto +3936 -> 11753
    //   7820: aload_0
    //   7821: aload 19
    //   7823: invokespecial 2947	aqlw:g	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   7826: goto +3927 -> 11753
    //   7829: aload_0
    //   7830: aload 19
    //   7832: invokespecial 2949	aqlw:h	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   7835: goto +3918 -> 11753
    //   7838: aload_0
    //   7839: aload_2
    //   7840: aload 19
    //   7842: invokespecial 2951	aqlw:ad	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   7845: goto +3908 -> 11753
    //   7848: aload_2
    //   7849: invokestatic 1526	com/tencent/mobileqq/utils/BusinessCommonConfig:getInstance	(Lmqq/app/AppRuntime;)Lcom/tencent/mobileqq/utils/BusinessCommonConfig;
    //   7852: aload_2
    //   7853: aload 16
    //   7855: invokevirtual 1842	java/lang/Integer:intValue	()I
    //   7858: aload_3
    //   7859: aload 19
    //   7861: invokevirtual 2955	com/tencent/mobileqq/utils/BusinessCommonConfig:decodeConfig	(Lcom/tencent/mobileqq/app/QQAppInterface;ILandroid/content/Intent;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)Ljava/lang/Boolean;
    //   7864: pop
    //   7865: goto +3888 -> 11753
    //   7868: aload 19
    //   7870: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   7873: ifnull +164 -> 8037
    //   7876: aload 19
    //   7878: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   7881: invokevirtual 113	com/tencent/mobileqq/pb/PBRepeatField:size	()I
    //   7884: ifle +153 -> 8037
    //   7887: aload 19
    //   7889: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   7892: invokevirtual 1154	com/tencent/mobileqq/pb/PBRepeatField:get	()Ljava/util/List;
    //   7895: invokeinterface 235 1 0
    //   7900: astore 16
    //   7902: aload 16
    //   7904: invokeinterface 240 1 0
    //   7909: ifeq +167 -> 8076
    //   7912: aload 16
    //   7914: invokeinterface 244 1 0
    //   7919: checkcast 118	java/lang/String
    //   7922: astore 17
    //   7924: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7927: ifeq +47 -> 7974
    //   7930: ldc 183
    //   7932: iconst_2
    //   7933: new 85	java/lang/StringBuilder
    //   7936: dup
    //   7937: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   7940: ldc_w 2957
    //   7943: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7946: aload 17
    //   7948: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7951: ldc_w 606
    //   7954: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7957: aload 19
    //   7959: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   7962: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   7965: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7968: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7971: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   7974: aload_0
    //   7975: aload 17
    //   7977: aload 19
    //   7979: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   7982: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   7985: invokespecial 2959	aqlw:a	(Ljava/lang/String;I)V
    //   7988: goto -86 -> 7902
    //   7991: astore 16
    //   7993: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7996: ifeq +33 -> 8029
    //   7999: ldc 183
    //   8001: iconst_2
    //   8002: new 85	java/lang/StringBuilder
    //   8005: dup
    //   8006: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   8009: ldc_w 2961
    //   8012: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8015: aload 16
    //   8017: invokevirtual 642	java/lang/Exception:toString	()Ljava/lang/String;
    //   8020: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8023: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8026: invokestatic 644	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   8029: aload 16
    //   8031: invokevirtual 461	java/lang/Exception:printStackTrace	()V
    //   8034: goto +3719 -> 11753
    //   8037: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   8040: ifeq +36 -> 8076
    //   8043: ldc 183
    //   8045: iconst_2
    //   8046: new 85	java/lang/StringBuilder
    //   8049: dup
    //   8050: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   8053: ldc_w 2963
    //   8056: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8059: aload 19
    //   8061: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   8064: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   8067: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   8070: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8073: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   8076: goto +3677 -> 11753
    //   8079: aload 19
    //   8081: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   8084: ifnull +164 -> 8248
    //   8087: aload 19
    //   8089: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   8092: invokevirtual 113	com/tencent/mobileqq/pb/PBRepeatField:size	()I
    //   8095: ifle +153 -> 8248
    //   8098: aload 19
    //   8100: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   8103: invokevirtual 1154	com/tencent/mobileqq/pb/PBRepeatField:get	()Ljava/util/List;
    //   8106: invokeinterface 235 1 0
    //   8111: astore 16
    //   8113: aload 16
    //   8115: invokeinterface 240 1 0
    //   8120: ifeq +167 -> 8287
    //   8123: aload 16
    //   8125: invokeinterface 244 1 0
    //   8130: checkcast 118	java/lang/String
    //   8133: astore 17
    //   8135: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   8138: ifeq +47 -> 8185
    //   8141: ldc 183
    //   8143: iconst_2
    //   8144: new 85	java/lang/StringBuilder
    //   8147: dup
    //   8148: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   8151: ldc_w 2965
    //   8154: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8157: aload 17
    //   8159: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8162: ldc_w 606
    //   8165: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8168: aload 19
    //   8170: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   8173: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   8176: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   8179: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8182: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   8185: aload_0
    //   8186: aload 17
    //   8188: aload 19
    //   8190: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   8193: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   8196: invokespecial 2967	aqlw:b	(Ljava/lang/String;I)V
    //   8199: goto -86 -> 8113
    //   8202: astore 16
    //   8204: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   8207: ifeq +33 -> 8240
    //   8210: ldc 183
    //   8212: iconst_2
    //   8213: new 85	java/lang/StringBuilder
    //   8216: dup
    //   8217: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   8220: ldc_w 2969
    //   8223: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8226: aload 16
    //   8228: invokevirtual 642	java/lang/Exception:toString	()Ljava/lang/String;
    //   8231: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8234: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8237: invokestatic 644	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   8240: aload 16
    //   8242: invokevirtual 461	java/lang/Exception:printStackTrace	()V
    //   8245: goto +3508 -> 11753
    //   8248: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   8251: ifeq +36 -> 8287
    //   8254: ldc 183
    //   8256: iconst_2
    //   8257: new 85	java/lang/StringBuilder
    //   8260: dup
    //   8261: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   8264: ldc_w 2971
    //   8267: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8270: aload 19
    //   8272: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   8275: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   8278: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   8281: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8284: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   8287: goto +3466 -> 11753
    //   8290: aload_0
    //   8291: aload 19
    //   8293: invokespecial 2973	aqlw:p	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8296: goto +3457 -> 11753
    //   8299: aload_0
    //   8300: aload 19
    //   8302: invokespecial 2975	aqlw:m	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8305: goto +3448 -> 11753
    //   8308: aload_0
    //   8309: aload 19
    //   8311: invokespecial 2977	aqlw:n	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8314: goto +3439 -> 11753
    //   8317: aload_0
    //   8318: aload 19
    //   8320: invokespecial 2979	aqlw:o	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8323: goto +3430 -> 11753
    //   8326: aload_0
    //   8327: aload 19
    //   8329: invokespecial 2981	aqlw:t	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8332: goto +3421 -> 11753
    //   8335: aload_0
    //   8336: aload 19
    //   8338: invokespecial 2983	aqlw:r	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8341: goto +3412 -> 11753
    //   8344: aload_0
    //   8345: aload 19
    //   8347: invokespecial 2985	aqlw:d	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8350: goto +3403 -> 11753
    //   8353: aload_0
    //   8354: aload 19
    //   8356: invokespecial 2987	aqlw:q	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8359: goto +3394 -> 11753
    //   8362: aload_0
    //   8363: aload 19
    //   8365: invokespecial 2989	aqlw:s	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8368: goto +3385 -> 11753
    //   8371: aload_0
    //   8372: aload 19
    //   8374: invokespecial 2991	aqlw:k	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8377: goto +3376 -> 11753
    //   8380: aload_0
    //   8381: aload 19
    //   8383: invokevirtual 2993	aqlw:b	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8386: goto +3367 -> 11753
    //   8389: aload_0
    //   8390: aload 19
    //   8392: invokevirtual 2995	aqlw:c	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8395: goto +3358 -> 11753
    //   8398: aload_0
    //   8399: aload 19
    //   8401: invokespecial 2997	aqlw:v	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8404: goto +3349 -> 11753
    //   8407: aload_0
    //   8408: aload 19
    //   8410: invokespecial 2999	aqlw:w	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8413: goto +3340 -> 11753
    //   8416: aload_0
    //   8417: aload 19
    //   8419: invokespecial 3001	aqlw:z	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8422: goto +3331 -> 11753
    //   8425: aload_0
    //   8426: aload 19
    //   8428: invokespecial 3003	aqlw:B	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8431: goto +3322 -> 11753
    //   8434: aload_0
    //   8435: aload 19
    //   8437: invokespecial 3005	aqlw:x	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8440: goto +3313 -> 11753
    //   8443: aload_0
    //   8444: aload 19
    //   8446: invokespecial 3007	aqlw:y	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8449: goto +3304 -> 11753
    //   8452: aload_0
    //   8453: aload 19
    //   8455: invokespecial 3009	aqlw:l	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8458: goto +3295 -> 11753
    //   8461: aload_0
    //   8462: aload 19
    //   8464: invokespecial 3011	aqlw:u	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8467: goto +3286 -> 11753
    //   8470: invokestatic 3014	com/tencent/mobileqq/app/DeviceProfileManager:a	()Lcom/tencent/mobileqq/app/DeviceProfileManager;
    //   8473: aload_1
    //   8474: ldc 13
    //   8476: invokevirtual 3017	com/tencent/mobileqq/app/DeviceProfileManager:a	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig;Ljava/lang/String;)Z
    //   8479: pop
    //   8480: goto +3273 -> 11753
    //   8483: aload_0
    //   8484: aload 19
    //   8486: invokespecial 3019	aqlw:e	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8489: goto +3264 -> 11753
    //   8492: aload_0
    //   8493: aload 19
    //   8495: invokespecial 3021	aqlw:f	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8498: goto +3255 -> 11753
    //   8501: aload_0
    //   8502: aload 19
    //   8504: invokevirtual 3022	aqlw:a	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8507: goto +3246 -> 11753
    //   8510: aload_0
    //   8511: aload 19
    //   8513: invokespecial 3024	aqlw:A	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8516: goto +3237 -> 11753
    //   8519: aload 19
    //   8521: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   8524: ifnull +141 -> 8665
    //   8527: aload 19
    //   8529: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   8532: invokevirtual 113	com/tencent/mobileqq/pb/PBRepeatField:size	()I
    //   8535: ifle +130 -> 8665
    //   8538: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   8541: ifeq +68 -> 8609
    //   8544: ldc 183
    //   8546: iconst_2
    //   8547: new 85	java/lang/StringBuilder
    //   8550: dup
    //   8551: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   8554: ldc_w 3026
    //   8557: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8560: aload 16
    //   8562: invokevirtual 800	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   8565: ldc_w 2869
    //   8568: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8571: aload 19
    //   8573: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   8576: iconst_0
    //   8577: invokevirtual 116	com/tencent/mobileqq/pb/PBRepeatField:get	(I)Ljava/lang/Object;
    //   8580: checkcast 118	java/lang/String
    //   8583: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8586: ldc_w 606
    //   8589: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8592: aload 19
    //   8594: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   8597: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   8600: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   8603: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8606: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   8609: aload_2
    //   8610: sipush 169
    //   8613: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   8616: checkcast 3028	cooperation/photoplus/PhotoPlusManager
    //   8619: aload 19
    //   8621: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   8624: iconst_0
    //   8625: invokevirtual 116	com/tencent/mobileqq/pb/PBRepeatField:get	(I)Ljava/lang/Object;
    //   8628: checkcast 118	java/lang/String
    //   8631: invokevirtual 3029	cooperation/photoplus/PhotoPlusManager:a	(Ljava/lang/String;)Z
    //   8634: ifeq +3119 -> 11753
    //   8637: aload_0
    //   8638: invokevirtual 47	aqlw:getAppRuntime	()Lmqq/app/AppRuntime;
    //   8641: invokevirtual 2615	mqq/app/AppRuntime:getApplication	()Lmqq/app/MobileQQ;
    //   8644: aload_0
    //   8645: invokevirtual 47	aqlw:getAppRuntime	()Lmqq/app/AppRuntime;
    //   8648: invokevirtual 2805	mqq/app/AppRuntime:getAccount	()Ljava/lang/String;
    //   8651: aload 19
    //   8653: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   8656: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   8659: invokestatic 3031	bfyz:r	(Landroid/content/Context;Ljava/lang/String;I)V
    //   8662: goto +3091 -> 11753
    //   8665: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   8668: ifeq +3085 -> 11753
    //   8671: ldc 183
    //   8673: iconst_2
    //   8674: new 85	java/lang/StringBuilder
    //   8677: dup
    //   8678: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   8681: ldc_w 3026
    //   8684: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8687: aload 16
    //   8689: invokevirtual 800	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   8692: ldc_w 3033
    //   8695: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8698: aload 19
    //   8700: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   8703: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   8706: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   8709: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8712: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   8715: goto +3038 -> 11753
    //   8718: aload_0
    //   8719: aload_2
    //   8720: aload 19
    //   8722: invokevirtual 3035	aqlw:e	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8725: goto +3028 -> 11753
    //   8728: aload_0
    //   8729: aload_3
    //   8730: iload 5
    //   8732: aload 19
    //   8734: aload_1
    //   8735: getfield 2409	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:result	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   8738: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   8741: invokevirtual 3038	aqlw:a	(Landroid/content/Intent;ZLcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;I)V
    //   8744: goto +3009 -> 11753
    //   8747: aload_0
    //   8748: aload_3
    //   8749: aload 19
    //   8751: invokespecial 3040	aqlw:c	(Landroid/content/Intent;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8754: goto +2999 -> 11753
    //   8757: aload_0
    //   8758: aload_3
    //   8759: aload 19
    //   8761: invokespecial 3042	aqlw:b	(Landroid/content/Intent;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8764: goto +2989 -> 11753
    //   8767: aload_0
    //   8768: aload_3
    //   8769: aload 19
    //   8771: invokespecial 3044	aqlw:d	(Landroid/content/Intent;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8774: goto +2979 -> 11753
    //   8777: aload_0
    //   8778: aload_3
    //   8779: aload 19
    //   8781: invokevirtual 3046	aqlw:a	(Landroid/content/Intent;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8784: goto +2969 -> 11753
    //   8787: aload_0
    //   8788: aload_2
    //   8789: aload_3
    //   8790: aload 19
    //   8792: invokevirtual 3048	aqlw:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Landroid/content/Intent;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8795: goto +2958 -> 11753
    //   8798: aload_0
    //   8799: aload_2
    //   8800: aload 19
    //   8802: invokespecial 3050	aqlw:U	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8805: goto +2948 -> 11753
    //   8808: aload_0
    //   8809: aload_2
    //   8810: aload 19
    //   8812: invokespecial 3052	aqlw:ae	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8815: goto +2938 -> 11753
    //   8818: aload 16
    //   8820: invokevirtual 1842	java/lang/Integer:intValue	()I
    //   8823: aload_2
    //   8824: invokevirtual 1604	com/tencent/mobileqq/app/QQAppInterface:getCurrentUin	()Ljava/lang/String;
    //   8827: aload 19
    //   8829: invokestatic 3055	lbs:a	(ILjava/lang/String;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8832: goto +2921 -> 11753
    //   8835: aload_0
    //   8836: aload_2
    //   8837: aload 19
    //   8839: invokevirtual 3057	aqlw:d	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8842: goto +2911 -> 11753
    //   8845: aload_0
    //   8846: aload_3
    //   8847: iload 5
    //   8849: aload 19
    //   8851: aload_1
    //   8852: getfield 2409	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:result	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   8855: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   8858: invokevirtual 3059	aqlw:b	(Landroid/content/Intent;ZLcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;I)V
    //   8861: goto +2892 -> 11753
    //   8864: aload_0
    //   8865: aload_2
    //   8866: aload 19
    //   8868: invokespecial 3061	aqlw:V	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8871: goto +2882 -> 11753
    //   8874: aload_0
    //   8875: aload_2
    //   8876: aload 19
    //   8878: invokespecial 3063	aqlw:W	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8881: goto +2872 -> 11753
    //   8884: aload_0
    //   8885: aload_2
    //   8886: aload 19
    //   8888: invokespecial 3065	aqlw:X	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8891: goto +2862 -> 11753
    //   8894: aload_0
    //   8895: aload_2
    //   8896: aload 19
    //   8898: invokespecial 3067	aqlw:Y	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8901: goto +2852 -> 11753
    //   8904: aload_0
    //   8905: aload_2
    //   8906: aload 19
    //   8908: invokevirtual 3069	aqlw:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8911: goto +2842 -> 11753
    //   8914: aload_0
    //   8915: aload_2
    //   8916: aload 19
    //   8918: invokespecial 3071	aqlw:af	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8921: goto +2832 -> 11753
    //   8924: aload_0
    //   8925: aload_2
    //   8926: aload 19
    //   8928: invokespecial 3074	aqlw:ag	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8931: goto +2822 -> 11753
    //   8934: aload_0
    //   8935: aload_2
    //   8936: aload 19
    //   8938: invokespecial 3076	aqlw:ah	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8941: goto +2812 -> 11753
    //   8944: aload_0
    //   8945: aload_2
    //   8946: aload 19
    //   8948: invokespecial 3079	aqlw:ai	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8951: goto +2802 -> 11753
    //   8954: aload 19
    //   8956: invokestatic 3080	bbgh:a	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8959: goto +2794 -> 11753
    //   8962: aload_0
    //   8963: aload_2
    //   8964: aload 19
    //   8966: invokespecial 3082	aqlw:aj	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8969: goto +2784 -> 11753
    //   8972: aload_0
    //   8973: aload_2
    //   8974: aload 19
    //   8976: invokespecial 3084	aqlw:ak	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8979: goto +2774 -> 11753
    //   8982: aload_0
    //   8983: aload_2
    //   8984: aload 19
    //   8986: invokespecial 3086	aqlw:al	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8989: goto +2764 -> 11753
    //   8992: aload_0
    //   8993: aload_2
    //   8994: aload 19
    //   8996: invokespecial 3088	aqlw:am	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8999: goto +2754 -> 11753
    //   9002: aload_0
    //   9003: aload_2
    //   9004: aload 19
    //   9006: invokevirtual 3090	aqlw:f	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9009: goto +2744 -> 11753
    //   9012: aload_0
    //   9013: aload_3
    //   9014: aload 19
    //   9016: invokespecial 3092	aqlw:m	(Landroid/content/Intent;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9019: goto +2734 -> 11753
    //   9022: aload_0
    //   9023: aload_2
    //   9024: aload 19
    //   9026: invokespecial 3095	aqlw:an	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9029: goto +2724 -> 11753
    //   9032: aload_0
    //   9033: aload_2
    //   9034: aload 19
    //   9036: invokevirtual 3097	aqlw:l	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9039: goto +2714 -> 11753
    //   9042: aload_0
    //   9043: aload_2
    //   9044: aload 19
    //   9046: invokevirtual 3099	aqlw:i	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9049: goto +2704 -> 11753
    //   9052: aload_2
    //   9053: sipush 208
    //   9056: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   9059: checkcast 1866	ynq
    //   9062: getfield 1869	ynq:a	Lynp;
    //   9065: aload_2
    //   9066: aload 19
    //   9068: invokevirtual 3102	ynp:a	(Lcom/tencent/common/app/AppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9071: goto +2682 -> 11753
    //   9074: aload_0
    //   9075: aload_2
    //   9076: aload 19
    //   9078: invokevirtual 3104	aqlw:h	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9081: goto +2672 -> 11753
    //   9084: aload_0
    //   9085: aload_2
    //   9086: aload 19
    //   9088: invokevirtual 3106	aqlw:j	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9091: goto +2662 -> 11753
    //   9094: aload_0
    //   9095: aload_2
    //   9096: aload 19
    //   9098: invokevirtual 3108	aqlw:m	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9101: goto +2652 -> 11753
    //   9104: aload_0
    //   9105: aload_2
    //   9106: aload 19
    //   9108: invokevirtual 3110	aqlw:n	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9111: goto +2642 -> 11753
    //   9114: aload_0
    //   9115: aload_2
    //   9116: aload 19
    //   9118: invokevirtual 3112	aqlw:o	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9121: goto +2632 -> 11753
    //   9124: aload_0
    //   9125: aload_2
    //   9126: aload 19
    //   9128: invokevirtual 3114	aqlw:q	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9131: goto +2622 -> 11753
    //   9134: aload_2
    //   9135: aload 19
    //   9137: invokestatic 3115	zsm:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9140: goto +2613 -> 11753
    //   9143: aload_0
    //   9144: aload_2
    //   9145: aload 19
    //   9147: invokespecial 3117	aqlw:ao	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9150: goto +2603 -> 11753
    //   9153: aload_0
    //   9154: aload_2
    //   9155: aload 19
    //   9157: invokevirtual 3119	aqlw:p	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9160: goto +2593 -> 11753
    //   9163: aload_0
    //   9164: aload_2
    //   9165: aload 19
    //   9167: invokevirtual 3121	aqlw:r	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9170: goto +2583 -> 11753
    //   9173: aload_0
    //   9174: aload_2
    //   9175: aload 19
    //   9177: invokevirtual 3123	aqlw:g	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9180: goto +2573 -> 11753
    //   9183: aload_0
    //   9184: aload_2
    //   9185: aload 19
    //   9187: invokevirtual 3125	aqlw:s	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9190: goto +2563 -> 11753
    //   9193: aload_0
    //   9194: aload_2
    //   9195: aload 19
    //   9197: invokespecial 3127	aqlw:Z	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9200: goto +2553 -> 11753
    //   9203: aload_0
    //   9204: aload_2
    //   9205: aload 19
    //   9207: invokespecial 3129	aqlw:aa	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9210: goto +2543 -> 11753
    //   9213: aload_0
    //   9214: aload_2
    //   9215: aload 19
    //   9217: invokevirtual 3131	aqlw:k	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9220: goto +2533 -> 11753
    //   9223: aload_0
    //   9224: aload_2
    //   9225: aload 19
    //   9227: invokevirtual 3133	aqlw:u	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9230: goto +2523 -> 11753
    //   9233: aload_2
    //   9234: aload 19
    //   9236: invokestatic 3135	aqlw:t	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9239: goto +2514 -> 11753
    //   9242: aload 19
    //   9244: aload_2
    //   9245: invokevirtual 1357	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   9248: invokestatic 1970	akus:a	(Landroid/content/Context;)I
    //   9251: sipush 199
    //   9254: invokestatic 815	aqlw:b	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;II)Ljava/lang/String;
    //   9257: astore 16
    //   9259: aload 16
    //   9261: ifnull +2492 -> 11753
    //   9264: aload_2
    //   9265: invokevirtual 1357	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   9268: aload 16
    //   9270: aload 19
    //   9272: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   9275: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   9278: invokestatic 3136	akus:a	(Landroid/content/Context;Ljava/lang/String;I)V
    //   9281: goto +2472 -> 11753
    //   9284: aload 19
    //   9286: aload_2
    //   9287: invokevirtual 1357	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   9290: invokestatic 1973	baah:a	(Landroid/content/Context;)I
    //   9293: sipush 225
    //   9296: invokestatic 815	aqlw:b	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;II)Ljava/lang/String;
    //   9299: astore 16
    //   9301: aload 16
    //   9303: ifnull +2450 -> 11753
    //   9306: invokestatic 3139	baah:a	()Lbaah;
    //   9309: aload_2
    //   9310: invokevirtual 1357	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   9313: aload 16
    //   9315: aload 19
    //   9317: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   9320: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   9323: invokevirtual 3140	baah:a	(Landroid/content/Context;Ljava/lang/String;I)V
    //   9326: goto +2427 -> 11753
    //   9329: aload_0
    //   9330: aload_2
    //   9331: aload 19
    //   9333: invokevirtual 3142	aqlw:v	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9336: goto +2417 -> 11753
    //   9339: aload_0
    //   9340: aload_2
    //   9341: aload 19
    //   9343: invokevirtual 3144	aqlw:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9346: goto +2407 -> 11753
    //   9349: aload_0
    //   9350: aload_2
    //   9351: aload 19
    //   9353: invokespecial 3147	aqlw:ap	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9356: goto +2397 -> 11753
    //   9359: aload_2
    //   9360: aload 19
    //   9362: invokestatic 3149	aqlw:w	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9365: goto +2388 -> 11753
    //   9368: aload_2
    //   9369: aload 19
    //   9371: invokestatic 3151	aqlw:O	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9374: goto +2379 -> 11753
    //   9377: aload_0
    //   9378: aload_2
    //   9379: aload 19
    //   9381: invokespecial 3153	aqlw:ar	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9384: goto +2369 -> 11753
    //   9387: aload_2
    //   9388: aload 19
    //   9390: invokestatic 3155	aqlw:P	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9393: goto +2360 -> 11753
    //   9396: aload_0
    //   9397: aload_2
    //   9398: aload 19
    //   9400: aload_3
    //   9401: ldc_w 2283
    //   9404: invokevirtual 1410	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   9407: invokespecial 3157	aqlw:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;Ljava/lang/String;)I
    //   9410: invokestatic 3158	com/tencent/mobileqq/shortvideo/ShortVideoResourceManager:b	(I)V
    //   9413: goto +2340 -> 11753
    //   9416: aload_2
    //   9417: sipush 238
    //   9420: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   9423: checkcast 3160	nyd
    //   9426: astore 16
    //   9428: aload 16
    //   9430: ifnull +2323 -> 11753
    //   9433: aload 16
    //   9435: aload_2
    //   9436: aload 19
    //   9438: invokevirtual 3161	nyd:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9441: goto +2312 -> 11753
    //   9444: aload_0
    //   9445: aload_2
    //   9446: aload 19
    //   9448: invokevirtual 3163	aqlw:y	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9451: goto +2302 -> 11753
    //   9454: aload_0
    //   9455: aload_2
    //   9456: aload 19
    //   9458: invokespecial 3165	aqlw:T	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9461: goto +2292 -> 11753
    //   9464: aload_0
    //   9465: aload_2
    //   9466: aload 19
    //   9468: invokevirtual 3167	aqlw:x	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9471: goto +2282 -> 11753
    //   9474: aload_0
    //   9475: aload_2
    //   9476: aload 19
    //   9478: invokevirtual 3169	aqlw:F	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9481: goto +2272 -> 11753
    //   9484: aload_0
    //   9485: aload_2
    //   9486: aload 19
    //   9488: invokevirtual 3171	aqlw:z	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9491: goto +2262 -> 11753
    //   9494: aload_0
    //   9495: aload_2
    //   9496: aload 19
    //   9498: invokevirtual 3173	aqlw:A	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9501: goto +2252 -> 11753
    //   9504: aload_0
    //   9505: aload_2
    //   9506: aload 19
    //   9508: invokevirtual 3175	aqlw:B	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9511: goto +2242 -> 11753
    //   9514: aload_0
    //   9515: aload_2
    //   9516: aload 19
    //   9518: invokevirtual 3177	aqlw:C	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9521: goto +2232 -> 11753
    //   9524: aload_0
    //   9525: aload_2
    //   9526: aload 19
    //   9528: invokevirtual 3179	aqlw:D	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9531: goto +2222 -> 11753
    //   9534: aload_0
    //   9535: aload_2
    //   9536: aload 19
    //   9538: invokevirtual 3181	aqlw:E	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9541: goto +2212 -> 11753
    //   9544: aload_0
    //   9545: aload_2
    //   9546: aload 19
    //   9548: invokespecial 3183	aqlw:ab	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9551: goto +2202 -> 11753
    //   9554: aload_0
    //   9555: aload_2
    //   9556: aload 19
    //   9558: invokespecial 3185	aqlw:ac	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9561: goto +2192 -> 11753
    //   9564: aload_0
    //   9565: aload_2
    //   9566: aload 19
    //   9568: invokespecial 3187	aqlw:S	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9571: goto +2182 -> 11753
    //   9574: aload_0
    //   9575: aload_2
    //   9576: aload 19
    //   9578: invokevirtual 3189	aqlw:G	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9581: goto +2172 -> 11753
    //   9584: aload_2
    //   9585: aload 19
    //   9587: invokestatic 3192	beqp:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9590: goto +2163 -> 11753
    //   9593: aload_2
    //   9594: bipush 52
    //   9596: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   9599: checkcast 2035	com/tencent/mobileqq/app/TroopManager
    //   9602: getfield 2038	com/tencent/mobileqq/app/TroopManager:jdField_a_of_type_Beir	Lbeir;
    //   9605: aload_2
    //   9606: aload 19
    //   9608: invokevirtual 3193	beir:a	(Lcom/tencent/common/app/AppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9611: goto +2142 -> 11753
    //   9614: aload_2
    //   9615: bipush 52
    //   9617: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   9620: checkcast 2035	com/tencent/mobileqq/app/TroopManager
    //   9623: getfield 2046	com/tencent/mobileqq/app/TroopManager:jdField_a_of_type_Beky	Lbeky;
    //   9626: aload_2
    //   9627: aload 19
    //   9629: invokevirtual 3194	beky:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9632: goto +2121 -> 11753
    //   9635: aload_2
    //   9636: invokestatic 3199	vky:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)Lvky;
    //   9639: aload 19
    //   9641: invokevirtual 3200	vky:a	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9644: goto +2109 -> 11753
    //   9647: aload_2
    //   9648: sipush 197
    //   9651: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   9654: checkcast 3202	vlj
    //   9657: aload 19
    //   9659: invokevirtual 3203	vlj:a	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9662: goto +2091 -> 11753
    //   9665: invokestatic 2057	audj:a	()Laudj;
    //   9668: getfield 2060	audj:a	Laudl;
    //   9671: aload 19
    //   9673: invokevirtual 3204	audl:a	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9676: goto +2077 -> 11753
    //   9679: astore 16
    //   9681: aload 16
    //   9683: invokevirtual 1846	java/lang/Throwable:printStackTrace	()V
    //   9686: goto +2067 -> 11753
    //   9689: aload_2
    //   9690: aload 19
    //   9692: invokestatic 3207	com/tencent/mobileqq/shortvideo/util/RecentDanceConfigMgr:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)I
    //   9695: pop
    //   9696: goto +2057 -> 11753
    //   9699: aload_2
    //   9700: aload 19
    //   9702: invokestatic 3208	dov/com/qq/im/ptv/LightVideoConfigMgr:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)I
    //   9705: pop
    //   9706: goto +2047 -> 11753
    //   9709: aload_0
    //   9710: aload_2
    //   9711: aload 19
    //   9713: invokevirtual 3210	aqlw:H	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9716: goto +2037 -> 11753
    //   9719: aload_0
    //   9720: aload_2
    //   9721: aload 19
    //   9723: invokevirtual 3212	aqlw:I	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9726: goto +2027 -> 11753
    //   9729: aload_0
    //   9730: aload_2
    //   9731: aload 19
    //   9733: invokevirtual 3214	aqlw:J	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9736: goto +2017 -> 11753
    //   9739: aload_2
    //   9740: aload 19
    //   9742: aload 16
    //   9744: invokevirtual 1842	java/lang/Integer:intValue	()I
    //   9747: getstatic 15	aqlw:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   9750: invokestatic 3219	bcec:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;ILjava/lang/String;)V
    //   9753: goto +2000 -> 11753
    //   9756: aload_0
    //   9757: aload_2
    //   9758: aload 19
    //   9760: invokevirtual 3221	aqlw:M	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9763: goto +1990 -> 11753
    //   9766: aload_2
    //   9767: aload 16
    //   9769: invokevirtual 1842	java/lang/Integer:intValue	()I
    //   9772: aload 19
    //   9774: invokestatic 3226	aqsc:a	(Lcom/tencent/mobileqq/app/QQAppInterface;ILcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9777: goto +1976 -> 11753
    //   9780: aload_2
    //   9781: invokestatic 3231	atid:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)Latid;
    //   9784: aload_2
    //   9785: aload 16
    //   9787: aload 19
    //   9789: invokevirtual 3234	atid:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/Integer;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9792: goto +1961 -> 11753
    //   9795: aload_0
    //   9796: aload_2
    //   9797: aload 19
    //   9799: invokevirtual 3236	aqlw:K	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9802: goto +1951 -> 11753
    //   9805: aload_0
    //   9806: aload_2
    //   9807: aload 19
    //   9809: invokevirtual 3238	aqlw:L	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9812: goto +1941 -> 11753
    //   9815: aload_2
    //   9816: sipush 181
    //   9819: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   9822: checkcast 2101	vla
    //   9825: getfield 2104	vla:a	Lvtj;
    //   9828: aload_2
    //   9829: aload 19
    //   9831: invokevirtual 3239	vtj:a	(Lcom/tencent/common/app/AppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9834: goto +1919 -> 11753
    //   9837: aload_0
    //   9838: aload_2
    //   9839: aload 19
    //   9841: invokespecial 3241	aqlw:R	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9844: goto +1909 -> 11753
    //   9847: aload_2
    //   9848: aload 19
    //   9850: invokestatic 3243	aqlw:c	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9853: goto +1900 -> 11753
    //   9856: aload_2
    //   9857: aload 16
    //   9859: invokevirtual 1842	java/lang/Integer:intValue	()I
    //   9862: aload 19
    //   9864: invokestatic 3246	bhnb:a	(Lcom/tencent/mobileqq/app/QQAppInterface;ILcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9867: goto +1886 -> 11753
    //   9870: aload_2
    //   9871: bipush 52
    //   9873: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   9876: checkcast 2035	com/tencent/mobileqq/app/TroopManager
    //   9879: getfield 2120	com/tencent/mobileqq/app/TroopManager:jdField_a_of_type_Zsi	Lzsi;
    //   9882: aload_2
    //   9883: aload 19
    //   9885: invokevirtual 3247	zsi:a	(Lcom/tencent/common/app/AppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9888: goto +1865 -> 11753
    //   9891: aload_0
    //   9892: aload_2
    //   9893: aload 19
    //   9895: aload 16
    //   9897: invokevirtual 1842	java/lang/Integer:intValue	()I
    //   9900: invokespecial 3248	aqlw:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;I)V
    //   9903: goto +1850 -> 11753
    //   9906: aload_2
    //   9907: aload 19
    //   9909: invokestatic 3250	aqlw:N	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9912: goto +1841 -> 11753
    //   9915: aload_0
    //   9916: aload_2
    //   9917: aload 19
    //   9919: invokespecial 3252	aqlw:Q	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9922: goto +1831 -> 11753
    //   9925: aload_2
    //   9926: sipush 306
    //   9929: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   9932: checkcast 3254	aupc
    //   9935: aload 19
    //   9937: invokevirtual 3255	aupc:a	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9940: goto +1813 -> 11753
    //   9943: aload_0
    //   9944: aload 19
    //   9946: invokespecial 3257	aqlw:C	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9949: goto +1804 -> 11753
    //   9952: aload_2
    //   9953: sipush 236
    //   9956: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   9959: checkcast 3259	auna
    //   9962: aload 19
    //   9964: invokevirtual 3260	auna:a	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9967: goto +1786 -> 11753
    //   9970: aload_0
    //   9971: aload_2
    //   9972: aload 19
    //   9974: invokespecial 3263	aqlw:aq	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9977: goto +1776 -> 11753
    //   9980: aload_0
    //   9981: aload_2
    //   9982: aload 19
    //   9984: aload 16
    //   9986: invokevirtual 1842	java/lang/Integer:intValue	()I
    //   9989: invokespecial 3265	aqlw:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;I)V
    //   9992: goto +1761 -> 11753
    //   9995: aload_0
    //   9996: aload_2
    //   9997: aload 19
    //   9999: invokespecial 3267	aqlw:as	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   10002: goto +1751 -> 11753
    //   10005: aload 4
    //   10007: ifnull +309 -> 10316
    //   10010: iload 10
    //   10012: ifne +32 -> 10044
    //   10015: aload_2
    //   10016: invokevirtual 65	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   10019: ldc_w 2619
    //   10022: invokestatic 2622	bfwv:a	(Landroid/content/Context;Ljava/lang/String;)Z
    //   10025: ifne +19 -> 10044
    //   10028: aload_2
    //   10029: sipush 256
    //   10032: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   10035: checkcast 3269	com/tencent/mobileqq/upgrade/UpgradeTIMManager
    //   10038: aload_2
    //   10039: aload 4
    //   10041: invokevirtual 3270	com/tencent/mobileqq/upgrade/UpgradeTIMManager:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/upgrade/UpgradeTIMWrapper;)V
    //   10044: invokestatic 2591	java/lang/System:currentTimeMillis	()J
    //   10047: lstore 14
    //   10049: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   10052: ifeq +44 -> 10096
    //   10055: ldc 183
    //   10057: iconst_2
    //   10058: new 85	java/lang/StringBuilder
    //   10061: dup
    //   10062: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   10065: ldc_w 3272
    //   10068: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10071: lload 14
    //   10073: lload 12
    //   10075: lsub
    //   10076: invokevirtual 3275	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   10079: ldc_w 3277
    //   10082: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10085: iload 10
    //   10087: invokevirtual 152	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   10090: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   10093: invokestatic 374	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   10096: aconst_null
    //   10097: astore 4
    //   10099: aload_3
    //   10100: ifnull +1619 -> 11719
    //   10103: aload_3
    //   10104: ldc_w 2317
    //   10107: iconst_0
    //   10108: invokevirtual 2252	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   10111: istore 10
    //   10113: iload 10
    //   10115: ifeq +220 -> 10335
    //   10118: aload_3
    //   10119: ldc_w 3279
    //   10122: iconst_0
    //   10123: invokevirtual 3282	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   10126: istore 8
    //   10128: ldc 183
    //   10130: iconst_2
    //   10131: iconst_2
    //   10132: anewarray 303	java/lang/Object
    //   10135: dup
    //   10136: iconst_0
    //   10137: ldc_w 3284
    //   10140: aastore
    //   10141: dup
    //   10142: iconst_1
    //   10143: iload 8
    //   10145: invokestatic 307	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   10148: aastore
    //   10149: invokestatic 1675	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   10152: iload 8
    //   10154: istore 6
    //   10156: iload 10
    //   10158: istore 5
    //   10160: aload 4
    //   10162: astore_3
    //   10163: iload 8
    //   10165: iconst_3
    //   10166: if_icmpge +179 -> 10345
    //   10169: aload_1
    //   10170: getfield 3287	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:next_req_types	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   10173: invokevirtual 1154	com/tencent/mobileqq/pb/PBRepeatField:get	()Ljava/util/List;
    //   10176: astore 16
    //   10178: iload 8
    //   10180: istore 6
    //   10182: iload 10
    //   10184: istore 5
    //   10186: aload 4
    //   10188: astore_3
    //   10189: aload 16
    //   10191: ifnull +154 -> 10345
    //   10194: iload 8
    //   10196: istore 6
    //   10198: iload 10
    //   10200: istore 5
    //   10202: aload 4
    //   10204: astore_3
    //   10205: aload 16
    //   10207: invokeinterface 401 1 0
    //   10212: ifle +133 -> 10345
    //   10215: aload 16
    //   10217: invokeinterface 401 1 0
    //   10222: newarray int
    //   10224: astore 4
    //   10226: aload 16
    //   10228: invokeinterface 401 1 0
    //   10233: istore 9
    //   10235: iconst_0
    //   10236: istore 7
    //   10238: iload 8
    //   10240: istore 6
    //   10242: iload 10
    //   10244: istore 5
    //   10246: aload 4
    //   10248: astore_3
    //   10249: iload 7
    //   10251: iload 9
    //   10253: if_icmpge +92 -> 10345
    //   10256: aload 16
    //   10258: iload 7
    //   10260: invokeinterface 450 2 0
    //   10265: checkcast 139	java/lang/Integer
    //   10268: invokevirtual 1842	java/lang/Integer:intValue	()I
    //   10271: istore 6
    //   10273: aload 4
    //   10275: iload 7
    //   10277: iload 6
    //   10279: iastore
    //   10280: aload 18
    //   10282: invokeinterface 401 1 0
    //   10287: ifle +20 -> 10307
    //   10290: aload 18
    //   10292: new 139	java/lang/Integer
    //   10295: dup
    //   10296: iload 6
    //   10298: invokespecial 2594	java/lang/Integer:<init>	(I)V
    //   10301: invokeinterface 2596 2 0
    //   10306: pop
    //   10307: iload 7
    //   10309: iconst_1
    //   10310: iadd
    //   10311: istore 7
    //   10313: goto -75 -> 10238
    //   10316: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   10319: ifeq -275 -> 10044
    //   10322: ldc_w 1800
    //   10325: iconst_2
    //   10326: ldc_w 3289
    //   10329: invokestatic 200	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   10332: goto -288 -> 10044
    //   10335: iconst_0
    //   10336: istore 6
    //   10338: aload 4
    //   10340: astore_3
    //   10341: iload 10
    //   10343: istore 5
    //   10345: aload 18
    //   10347: invokeinterface 235 1 0
    //   10352: astore 4
    //   10354: aload 4
    //   10356: invokeinterface 240 1 0
    //   10361: ifeq +1153 -> 11514
    //   10364: aload 4
    //   10366: invokeinterface 244 1 0
    //   10371: checkcast 139	java/lang/Integer
    //   10374: astore 16
    //   10376: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   10379: ifeq +46 -> 10425
    //   10382: ldc 183
    //   10384: iconst_2
    //   10385: new 85	java/lang/StringBuilder
    //   10388: dup
    //   10389: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   10392: ldc_w 3291
    //   10395: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10398: aload 16
    //   10400: invokevirtual 800	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   10403: ldc_w 2147
    //   10406: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10409: aload 18
    //   10411: invokeinterface 401 1 0
    //   10416: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   10419: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   10422: invokestatic 374	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   10425: aload 16
    //   10427: invokevirtual 1842	java/lang/Integer:intValue	()I
    //   10430: lookupswitch	default:+186->10616, 1:+644->11074, 38:+590->11020, 42:+923->11353, 46:+583->11013, 86:+877->11307, 87:+779->11209, 113:+931->11361, 116:+217->10647, 119:+993->11423, 156:+-76->10354, 185:+1019->11449, 188:+822->11252, 191:+1047->11477, 202:+1028->11458, 205:+859->11289, 206:+841->11271, 215:+1063->11493, 223:+977->11407, 297:+1069->11499, 345:+1076->11506, 364:+977->11407, 365:+977->11407
    //   10617: iconst_2
    //   10618: iload_0
    //   10619: aload 16
    //   10621: invokevirtual 1842	java/lang/Integer:intValue	()I
    //   10624: invokevirtual 1309	apub:b	(I)Z
    //   10627: ifeq -273 -> 10354
    //   10630: invokestatic 1306	apub:a	()Lapub;
    //   10633: aload 16
    //   10635: invokevirtual 1842	java/lang/Integer:intValue	()I
    //   10638: getstatic 15	aqlw:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   10641: invokevirtual 3292	apub:a	(ILjava/lang/String;)V
    //   10644: goto -290 -> 10354
    //   10647: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   10650: ifeq +12 -> 10662
    //   10653: ldc 183
    //   10655: iconst_2
    //   10656: ldc_w 3294
    //   10659: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   10662: aload_2
    //   10663: iconst_4
    //   10664: invokevirtual 208	com/tencent/mobileqq/app/QQAppInterface:getBusinessHandler	(I)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   10667: checkcast 1795	ampt
    //   10670: astore 17
    //   10672: ldc_w 2646
    //   10675: getstatic 15	aqlw:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   10678: invokestatic 3296	bfne:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   10681: astore 19
    //   10683: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   10686: ifeq +30 -> 10716
    //   10689: ldc 183
    //   10691: iconst_2
    //   10692: new 85	java/lang/StringBuilder
    //   10695: dup
    //   10696: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   10699: ldc_w 2690
    //   10702: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10705: aload 19
    //   10707: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10710: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   10713: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   10716: aload 19
    //   10718: invokestatic 126	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   10721: ifeq +53 -> 10774
    //   10724: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   10727: ifeq +12 -> 10739
    //   10730: ldc 183
    //   10732: iconst_2
    //   10733: ldc_w 3298
    //   10736: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   10739: aload_2
    //   10740: invokevirtual 65	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   10743: getstatic 15	aqlw:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   10746: iconst_0
    //   10747: invokestatic 2653	bfyz:p	(Landroid/content/Context;Ljava/lang/String;I)V
    //   10750: ldc_w 2646
    //   10753: getstatic 15	aqlw:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   10756: invokestatic 2651	bfne:a	(Ljava/lang/String;Ljava/lang/String;)Z
    //   10759: pop
    //   10760: aload 17
    //   10762: invokestatic 2447	bfng:a	()Lbfng;
    //   10765: invokevirtual 2450	bfng:a	()Lcom/tencent/mobileqq/upgrade/UpgradeDetailWrapper;
    //   10768: invokevirtual 2453	ampt:a	(Lcom/tencent/mobileqq/upgrade/UpgradeDetailWrapper;)V
    //   10771: goto -417 -> 10354
    //   10774: invokestatic 2447	bfng:a	()Lbfng;
    //   10777: invokevirtual 2450	bfng:a	()Lcom/tencent/mobileqq/upgrade/UpgradeDetailWrapper;
    //   10780: astore 16
    //   10782: aload 16
    //   10784: aload 19
    //   10786: invokevirtual 2656	com/tencent/mobileqq/upgrade/UpgradeDetailWrapper:a	(Ljava/lang/String;)V
    //   10789: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   10792: ifeq +42 -> 10834
    //   10795: ldc 183
    //   10797: iconst_2
    //   10798: ldc_w 2658
    //   10801: iconst_2
    //   10802: anewarray 303	java/lang/Object
    //   10805: dup
    //   10806: iconst_0
    //   10807: invokestatic 204	com/tencent/common/config/AppSetting:a	()I
    //   10810: invokestatic 307	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   10813: aastore
    //   10814: dup
    //   10815: iconst_1
    //   10816: aload 16
    //   10818: getfield 2661	com/tencent/mobileqq/upgrade/UpgradeDetailWrapper:jdField_b_of_type_ProtocolKQQConfigUpgradeInfo	Lprotocol/KQQConfig/UpgradeInfo;
    //   10821: getfield 2666	protocol/KQQConfig/UpgradeInfo:iUpgradeSdkId	I
    //   10824: invokestatic 307	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   10827: aastore
    //   10828: invokestatic 311	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   10831: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   10834: invokestatic 204	com/tencent/common/config/AppSetting:a	()I
    //   10837: aload 16
    //   10839: getfield 2661	com/tencent/mobileqq/upgrade/UpgradeDetailWrapper:jdField_b_of_type_ProtocolKQQConfigUpgradeInfo	Lprotocol/KQQConfig/UpgradeInfo;
    //   10842: getfield 2666	protocol/KQQConfig/UpgradeInfo:iUpgradeSdkId	I
    //   10845: if_icmplt +63 -> 10908
    //   10848: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   10851: ifeq +12 -> 10863
    //   10854: ldc 183
    //   10856: iconst_2
    //   10857: ldc_w 3300
    //   10860: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   10863: aload_2
    //   10864: invokevirtual 65	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   10867: getstatic 15	aqlw:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   10870: iconst_0
    //   10871: invokestatic 2653	bfyz:p	(Landroid/content/Context;Ljava/lang/String;I)V
    //   10874: ldc_w 2646
    //   10877: getstatic 15	aqlw:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   10880: invokestatic 2651	bfne:a	(Ljava/lang/String;Ljava/lang/String;)Z
    //   10883: pop
    //   10884: aload 16
    //   10886: getfield 2661	com/tencent/mobileqq/upgrade/UpgradeDetailWrapper:jdField_b_of_type_ProtocolKQQConfigUpgradeInfo	Lprotocol/KQQConfig/UpgradeInfo;
    //   10889: iconst_0
    //   10890: putfield 2686	protocol/KQQConfig/UpgradeInfo:iUpgradeType	I
    //   10893: aload 17
    //   10895: aload 16
    //   10897: invokevirtual 2453	ampt:a	(Lcom/tencent/mobileqq/upgrade/UpgradeDetailWrapper;)V
    //   10900: aload 17
    //   10902: invokevirtual 2688	ampt:d	()V
    //   10905: goto -551 -> 10354
    //   10908: aload 16
    //   10910: monitorenter
    //   10911: aload 16
    //   10913: getfield 2698	com/tencent/mobileqq/upgrade/UpgradeDetailWrapper:jdField_a_of_type_Boolean	Z
    //   10916: ifne +30 -> 10946
    //   10919: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   10922: ifeq +12 -> 10934
    //   10925: ldc 183
    //   10927: iconst_2
    //   10928: ldc_w 2700
    //   10931: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   10934: aload 16
    //   10936: monitorexit
    //   10937: goto -583 -> 10354
    //   10940: astore_1
    //   10941: aload 16
    //   10943: monitorexit
    //   10944: aload_1
    //   10945: athrow
    //   10946: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   10949: ifeq +12 -> 10961
    //   10952: ldc 183
    //   10954: iconst_2
    //   10955: ldc_w 2702
    //   10958: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   10961: aload 16
    //   10963: getfield 2704	com/tencent/mobileqq/upgrade/UpgradeDetailWrapper:jdField_b_of_type_Int	I
    //   10966: ifne +21 -> 10987
    //   10969: aload 16
    //   10971: getfield 2705	com/tencent/mobileqq/upgrade/UpgradeDetailWrapper:jdField_a_of_type_Int	I
    //   10974: iconst_1
    //   10975: if_icmpne +32 -> 11007
    //   10978: iconst_1
    //   10979: istore 10
    //   10981: aload_2
    //   10982: iload 10
    //   10984: invokestatic 2706	ampt:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Z)V
    //   10987: invokestatic 2447	bfng:a	()Lbfng;
    //   10990: aload 16
    //   10992: getfield 2661	com/tencent/mobileqq/upgrade/UpgradeDetailWrapper:jdField_b_of_type_ProtocolKQQConfigUpgradeInfo	Lprotocol/KQQConfig/UpgradeInfo;
    //   10995: aload 17
    //   10997: invokevirtual 2709	bfng:a	(Lprotocol/KQQConfig/UpgradeInfo;Lbfni;)Z
    //   11000: pop
    //   11001: aload 16
    //   11003: monitorexit
    //   11004: goto -650 -> 10354
    //   11007: iconst_0
    //   11008: istore 10
    //   11010: goto -29 -> 10981
    //   11013: aload_2
    //   11014: invokestatic 2471	abvj:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   11017: goto -663 -> 10354
    //   11020: aload_2
    //   11021: invokevirtual 412	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   11024: invokestatic 3303	bfyz:b	(Ljava/lang/String;)Landroid/content/SharedPreferences;
    //   11027: astore 16
    //   11029: aload 16
    //   11031: invokeinterface 347 1 0
    //   11036: ldc_w 3305
    //   11039: invokeinterface 383 2 0
    //   11044: invokeinterface 728 1 0
    //   11049: pop
    //   11050: aload 16
    //   11052: invokeinterface 347 1 0
    //   11057: ldc_w 3307
    //   11060: invokeinterface 383 2 0
    //   11065: invokeinterface 728 1 0
    //   11070: pop
    //   11071: goto -717 -> 10354
    //   11074: new 85	java/lang/StringBuilder
    //   11077: dup
    //   11078: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   11081: aload_0
    //   11082: invokevirtual 47	aqlw:getAppRuntime	()Lmqq/app/AppRuntime;
    //   11085: invokevirtual 2615	mqq/app/AppRuntime:getApplication	()Lmqq/app/MobileQQ;
    //   11088: invokevirtual 2742	mqq/app/MobileQQ:getFilesDir	()Ljava/io/File;
    //   11091: invokevirtual 2745	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   11094: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11097: ldc_w 3309
    //   11100: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11103: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   11106: astore 16
    //   11108: new 2736	java/io/File
    //   11111: dup
    //   11112: aload 16
    //   11114: invokespecial 2748	java/io/File:<init>	(Ljava/lang/String;)V
    //   11117: astore 17
    //   11119: aload 17
    //   11121: ifnull -767 -> 10354
    //   11124: aload 17
    //   11126: invokevirtual 2751	java/io/File:exists	()Z
    //   11129: ifeq -775 -> 10354
    //   11132: aload 17
    //   11134: invokevirtual 2764	java/io/File:isDirectory	()Z
    //   11137: ifeq -783 -> 10354
    //   11140: aload 17
    //   11142: invokevirtual 2768	java/io/File:listFiles	()[Ljava/io/File;
    //   11145: astore 17
    //   11147: aload 17
    //   11149: ifnull -795 -> 10354
    //   11152: aload 17
    //   11154: arraylength
    //   11155: istore 8
    //   11157: iconst_0
    //   11158: istore 7
    //   11160: iload 7
    //   11162: iload 8
    //   11164: if_icmpge -810 -> 10354
    //   11167: aload 17
    //   11169: iload 7
    //   11171: aaload
    //   11172: astore 19
    //   11174: aload 19
    //   11176: ifnonnull +12 -> 11188
    //   11179: iload 7
    //   11181: iconst_1
    //   11182: iadd
    //   11183: istore 7
    //   11185: goto -25 -> 11160
    //   11188: new 3311	com/tencent/mobileqq/config/splashlogo/ConfigServlet$1
    //   11191: dup
    //   11192: aload_0
    //   11193: aload 19
    //   11195: aload 16
    //   11197: invokespecial 3314	com/tencent/mobileqq/config/splashlogo/ConfigServlet$1:<init>	(Laqlw;Ljava/io/File;Ljava/lang/String;)V
    //   11200: iconst_5
    //   11201: aconst_null
    //   11202: iconst_1
    //   11203: invokestatic 3320	com/tencent/mobileqq/app/ThreadManager:post	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   11206: goto -27 -> 11179
    //   11209: aload_2
    //   11210: sipush 168
    //   11213: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   11216: checkcast 1696	aodg
    //   11219: astore 16
    //   11221: aload 16
    //   11223: ifnull +10 -> 11233
    //   11226: aload 16
    //   11228: iconst_1
    //   11229: iconst_0
    //   11230: invokevirtual 2511	aodg:a	(ZZ)V
    //   11233: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11236: ifeq -882 -> 10354
    //   11239: ldc_w 1723
    //   11242: iconst_2
    //   11243: ldc_w 3322
    //   11246: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   11249: goto -895 -> 10354
    //   11252: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11255: ifeq -901 -> 10354
    //   11258: ldc_w 3324
    //   11261: iconst_2
    //   11262: ldc_w 3326
    //   11265: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   11268: goto -914 -> 10354
    //   11271: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11274: ifeq -920 -> 10354
    //   11277: ldc 183
    //   11279: iconst_2
    //   11280: ldc_w 3328
    //   11283: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   11286: goto -932 -> 10354
    //   11289: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11292: ifeq -938 -> 10354
    //   11295: ldc 183
    //   11297: iconst_2
    //   11298: ldc_w 3330
    //   11301: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   11304: goto -950 -> 10354
    //   11307: aload_2
    //   11308: sipush 167
    //   11311: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   11314: checkcast 1658	com/tencent/mobileqq/olympic/OlympicManager
    //   11317: astore 16
    //   11319: aload 16
    //   11321: ifnull +13 -> 11334
    //   11324: aload 16
    //   11326: invokevirtual 2519	com/tencent/mobileqq/olympic/OlympicManager:f	()V
    //   11329: aload 16
    //   11331: invokevirtual 2521	com/tencent/mobileqq/olympic/OlympicManager:g	()V
    //   11334: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11337: ifeq -983 -> 10354
    //   11340: ldc_w 1682
    //   11343: iconst_2
    //   11344: ldc_w 3332
    //   11347: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   11350: goto -996 -> 10354
    //   11353: aload_0
    //   11354: aconst_null
    //   11355: invokespecial 2973	aqlw:p	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   11358: goto -1004 -> 10354
    //   11361: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11364: ifeq +12 -> 11376
    //   11367: ldc 183
    //   11369: iconst_2
    //   11370: ldc_w 2528
    //   11373: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   11376: aload_2
    //   11377: sipush 179
    //   11380: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   11383: checkcast 2530	ayji
    //   11386: astore 16
    //   11388: aload 16
    //   11390: ifnull -1036 -> 10354
    //   11393: aload 16
    //   11395: invokevirtual 2531	ayji:a	()V
    //   11398: aload 16
    //   11400: iconst_1
    //   11401: invokevirtual 2532	ayji:a	(Z)V
    //   11404: goto -1050 -> 10354
    //   11407: aload_2
    //   11408: invokestatic 1526	com/tencent/mobileqq/utils/BusinessCommonConfig:getInstance	(Lmqq/app/AppRuntime;)Lcom/tencent/mobileqq/utils/BusinessCommonConfig;
    //   11411: aload_2
    //   11412: aload 16
    //   11414: invokevirtual 1842	java/lang/Integer:intValue	()I
    //   11417: invokevirtual 3335	com/tencent/mobileqq/utils/BusinessCommonConfig:handleResp_Config_NoResp	(Lcom/tencent/mobileqq/app/QQAppInterface;I)V
    //   11420: goto -1066 -> 10354
    //   11423: aload_2
    //   11424: bipush 53
    //   11426: invokevirtual 208	com/tencent/mobileqq/app/QQAppInterface:getBusinessHandler	(I)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   11429: checkcast 1806	amoa
    //   11432: astore 16
    //   11434: aload 16
    //   11436: ifnull -1082 -> 10354
    //   11439: aload 16
    //   11441: iconst_0
    //   11442: iconst_0
    //   11443: invokevirtual 2526	amoa:a	(ZZ)V
    //   11446: goto -1092 -> 10354
    //   11449: invokestatic 2576	com/tencent/mobileqq/scribble/ScribbleResMgr:a	()Lcom/tencent/mobileqq/scribble/ScribbleResMgr;
    //   11452: invokevirtual 3336	com/tencent/mobileqq/scribble/ScribbleResMgr:a	()V
    //   11455: goto -1101 -> 10354
    //   11458: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11461: ifeq -1107 -> 10354
    //   11464: ldc_w 2359
    //   11467: iconst_2
    //   11468: ldc_w 3338
    //   11471: invokestatic 200	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   11474: goto -1120 -> 10354
    //   11477: aload_2
    //   11478: sipush 218
    //   11481: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   11484: checkcast 3340	aeyb
    //   11487: invokevirtual 3341	aeyb:a	()V
    //   11490: goto -1136 -> 10354
    //   11493: invokestatic 3342	com/tencent/mobileqq/shortvideo/ShortVideoResourceManager:b	()V
    //   11496: goto -1142 -> 10354
    //   11499: iconst_1
    //   11500: invokestatic 3343	aqsc:a	(Z)V
    //   11503: goto -1149 -> 10354
    //   11506: aload_2
    //   11507: iconst_1
    //   11508: invokestatic 3344	bhnb:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Z)V
    //   11511: goto -1157 -> 10354
    //   11514: iload 5
    //   11516: ifeq +202 -> 11718
    //   11519: iload 6
    //   11521: iconst_3
    //   11522: if_icmpge +196 -> 11718
    //   11525: aload_3
    //   11526: ifnull +192 -> 11718
    //   11529: aload_3
    //   11530: arraylength
    //   11531: ifle +187 -> 11718
    //   11534: new 85	java/lang/StringBuilder
    //   11537: dup
    //   11538: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   11541: astore 4
    //   11543: aload 4
    //   11545: ldc_w 3346
    //   11548: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11551: pop
    //   11552: aload_3
    //   11553: arraylength
    //   11554: istore 8
    //   11556: iconst_0
    //   11557: istore 7
    //   11559: iload 7
    //   11561: iload 8
    //   11563: if_icmpge +28 -> 11591
    //   11566: aload 4
    //   11568: aload_3
    //   11569: iload 7
    //   11571: iaload
    //   11572: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   11575: ldc_w 3348
    //   11578: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11581: pop
    //   11582: iload 7
    //   11584: iconst_1
    //   11585: iadd
    //   11586: istore 7
    //   11588: goto -29 -> 11559
    //   11591: ldc 183
    //   11593: iconst_1
    //   11594: aload 4
    //   11596: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   11599: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   11602: new 1259	mqq/app/NewIntent
    //   11605: dup
    //   11606: aload_2
    //   11607: invokevirtual 65	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   11610: ldc 2
    //   11612: invokespecial 1262	mqq/app/NewIntent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   11615: astore 4
    //   11617: aload 4
    //   11619: ldc_w 1264
    //   11622: aload_3
    //   11623: invokevirtual 1268	mqq/app/NewIntent:putExtra	(Ljava/lang/String;[I)Landroid/content/Intent;
    //   11626: pop
    //   11627: aload 4
    //   11629: ldc_w 1274
    //   11632: getstatic 15	aqlw:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   11635: invokevirtual 1277	mqq/app/NewIntent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   11638: pop
    //   11639: aload 4
    //   11641: ldc_w 2248
    //   11644: iconst_1
    //   11645: invokevirtual 2320	mqq/app/NewIntent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   11648: pop
    //   11649: aload_1
    //   11650: getfield 3349	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:cookies	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   11653: invokevirtual 1137	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   11656: ifeq +22 -> 11678
    //   11659: aload 4
    //   11661: ldc_w 2257
    //   11664: aload_1
    //   11665: getfield 3349	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:cookies	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   11668: invokevirtual 262	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   11671: invokevirtual 268	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   11674: invokevirtual 3352	mqq/app/NewIntent:putExtra	(Ljava/lang/String;[B)Landroid/content/Intent;
    //   11677: pop
    //   11678: aload 4
    //   11680: ldc_w 2317
    //   11683: iload 5
    //   11685: invokevirtual 2320	mqq/app/NewIntent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   11688: pop
    //   11689: aload 4
    //   11691: ldc_w 3279
    //   11694: iload 6
    //   11696: iconst_1
    //   11697: iadd
    //   11698: invokevirtual 2315	mqq/app/NewIntent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   11701: pop
    //   11702: aload 4
    //   11704: ldc_w 2314
    //   11707: iconst_0
    //   11708: invokevirtual 2315	mqq/app/NewIntent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   11711: pop
    //   11712: aload_2
    //   11713: aload 4
    //   11715: invokevirtual 1287	com/tencent/mobileqq/app/QQAppInterface:startServlet	(Lmqq/app/NewIntent;)V
    //   11718: return
    //   11719: iconst_0
    //   11720: istore 5
    //   11722: iconst_0
    //   11723: istore 6
    //   11725: aload 4
    //   11727: astore_3
    //   11728: goto -1383 -> 10345
    //   11731: aconst_null
    //   11732: astore 16
    //   11734: goto -4611 -> 7123
    //   11737: aload 4
    //   11739: astore 16
    //   11741: goto -7883 -> 3858
    //   11744: aconst_null
    //   11745: astore 16
    //   11747: goto -8019 -> 3728
    //   11750: goto -8182 -> 3568
    //   11753: aload 4
    //   11755: astore 16
    //   11757: iload 10
    //   11759: istore 11
    //   11761: goto -9661 -> 2100
    //   11764: aconst_null
    //   11765: astore 16
    //   11767: goto -8039 -> 3728
    //   11770: astore 17
    //   11772: goto -7805 -> 3967
    //   11775: iconst_0
    //   11776: istore 10
    //   11778: goto -7161 -> 4617
    //   11781: iload 7
    //   11783: iconst_1
    //   11784: iadd
    //   11785: istore 7
    //   11787: goto -7058 -> 4729
    //   11790: goto -37 -> 11753
    //   11793: iload 7
    //   11795: iconst_1
    //   11796: iadd
    //   11797: istore 7
    //   11799: goto -6882 -> 4917
    //   11802: goto -49 -> 11753
    //   11805: iload 7
    //   11807: iconst_1
    //   11808: iadd
    //   11809: istore 7
    //   11811: goto -6457 -> 5354
    //   11814: goto -61 -> 11753
    //   11817: goto -64 -> 11753
    //   11820: iload 7
    //   11822: iconst_1
    //   11823: iadd
    //   11824: istore 7
    //   11826: goto -5554 -> 6272
    //   11829: iload 8
    //   11831: istore 7
    //   11833: goto -5015 -> 6818
    //   11836: goto -83 -> 11753
    //   11839: goto -86 -> 11753
    //   11842: goto -89 -> 11753
    //   11845: goto -92 -> 11753
    //   11848: goto -95 -> 11753
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	11851	0	this	aqlw
    //   0	11851	1	paramRespGetConfig	ConfigurationService.RespGetConfig
    //   0	11851	2	paramQQAppInterface	QQAppInterface
    //   0	11851	3	paramIntent	Intent
    //   0	11851	4	paramArrayOfInt	int[]
    //   0	11851	5	paramBoolean	boolean
    //   361	11363	6	i	int
    //   53	11779	7	j	int
    //   357	11473	8	k	int
    //   68	10186	9	m	int
    //   2061	9716	10	bool1	boolean
    //   2094	9666	11	bool2	boolean
    //   1998	8076	12	l1	long
    //   10047	25	14	l2	long
    //   2098	1761	16	localObject1	Object
    //   3865	9	16	localUnsupportedEncodingException	UnsupportedEncodingException
    //   3881	9	16	localOutOfMemoryError	OutOfMemoryError
    //   3909	1	16	str1	String
    //   3914	1	16	localThrowable1	Throwable
    //   3917	610	16	localObject2	Object
    //   4651	6	16	localObject3	Object
    //   4755	3158	16	localObject4	Object
    //   7991	39	16	localException1	Exception
    //   8111	13	16	localIterator1	Iterator
    //   8202	617	16	localException2	Exception
    //   9257	177	16	localObject5	Object
    //   9679	306	16	localThrowable2	Throwable
    //   10176	1590	16	localObject6	Object
    //   3588	314	17	localObject7	Object
    //   3965	33	17	localException3	Exception
    //   4113	541	17	localUpgradeDetailWrapper	com.tencent.mobileqq.upgrade.UpgradeDetailWrapper
    //   4659	1	17	localException4	Exception
    //   5218	5950	17	localObject8	Object
    //   11770	1	17	localException5	Exception
    //   2019	8391	18	localArrayList	ArrayList
    //   2085	9109	19	localObject9	Object
    //   6482	223	20	localObject10	Object
    //   6528	13	21	localIterator2	Iterator
    //   6550	55	22	str2	String
    // Exception table:
    //   from	to	target	type
    //   3714	3728	3865	java/io/UnsupportedEncodingException
    //   3714	3728	3881	java/lang/OutOfMemoryError
    //   3897	3911	3914	java/lang/Throwable
    //   3799	3843	3965	java/lang/Exception
    //   3843	3854	3965	java/lang/Exception
    //   3942	3958	3965	java/lang/Exception
    //   4550	4573	4651	finally
    //   4573	4576	4651	finally
    //   4582	4597	4651	finally
    //   4597	4614	4651	finally
    //   4617	4623	4651	finally
    //   4623	4645	4651	finally
    //   4653	4656	4651	finally
    //   4531	4550	4659	java/lang/Exception
    //   4656	4659	4659	java/lang/Exception
    //   7868	7902	7991	java/lang/Exception
    //   7902	7974	7991	java/lang/Exception
    //   7974	7988	7991	java/lang/Exception
    //   8037	8076	7991	java/lang/Exception
    //   8079	8113	8202	java/lang/Exception
    //   8113	8185	8202	java/lang/Exception
    //   8185	8199	8202	java/lang/Exception
    //   8248	8287	8202	java/lang/Exception
    //   9665	9676	9679	java/lang/Throwable
    //   10911	10934	10940	finally
    //   10934	10937	10940	finally
    //   10941	10944	10940	finally
    //   10946	10961	10940	finally
    //   10961	10978	10940	finally
    //   10981	10987	10940	finally
    //   10987	11004	10940	finally
    //   2207	3568	11770	java/lang/Exception
    //   3571	3617	11770	java/lang/Exception
    //   3625	3640	11770	java/lang/Exception
    //   3643	3676	11770	java/lang/Exception
    //   3681	3709	11770	java/lang/Exception
    //   3714	3728	11770	java/lang/Exception
    //   3733	3788	11770	java/lang/Exception
    //   3788	3795	11770	java/lang/Exception
    //   3867	3878	11770	java/lang/Exception
    //   3883	3894	11770	java/lang/Exception
    //   3894	3897	11770	java/lang/Exception
    //   3897	3911	11770	java/lang/Exception
    //   3922	3935	11770	java/lang/Exception
    //   4026	4042	11770	java/lang/Exception
    //   4049	4112	11770	java/lang/Exception
    //   4122	4141	11770	java/lang/Exception
    //   4141	4156	11770	java/lang/Exception
    //   4156	4166	11770	java/lang/Exception
    //   4169	4184	11770	java/lang/Exception
    //   4184	4262	11770	java/lang/Exception
    //   4262	4349	11770	java/lang/Exception
    //   4349	4378	11770	java/lang/Exception
    //   4378	4420	11770	java/lang/Exception
    //   4423	4470	11770	java/lang/Exception
    //   4470	4488	11770	java/lang/Exception
    //   4491	4502	11770	java/lang/Exception
    //   4509	4524	11770	java/lang/Exception
    //   4667	4683	11770	java/lang/Exception
    //   4686	4726	11770	java/lang/Exception
    //   4729	4807	11770	java/lang/Exception
    //   4807	4829	11770	java/lang/Exception
    //   4832	4871	11770	java/lang/Exception
    //   4874	4914	11770	java/lang/Exception
    //   4917	4995	11770	java/lang/Exception
    //   4995	5018	11770	java/lang/Exception
    //   5021	5060	11770	java/lang/Exception
    //   5063	5106	11770	java/lang/Exception
    //   5109	5183	11770	java/lang/Exception
    //   5183	5198	11770	java/lang/Exception
    //   5198	5270	11770	java/lang/Exception
    //   5270	5323	11770	java/lang/Exception
    //   5331	5351	11770	java/lang/Exception
    //   5373	5387	11770	java/lang/Exception
    //   5390	5429	11770	java/lang/Exception
    //   5429	5476	11770	java/lang/Exception
    //   5481	5487	11770	java/lang/Exception
    //   5487	5510	11770	java/lang/Exception
    //   5513	5553	11770	java/lang/Exception
    //   5553	5625	11770	java/lang/Exception
    //   5625	5639	11770	java/lang/Exception
    //   5642	5661	11770	java/lang/Exception
    //   5666	5676	11770	java/lang/Exception
    //   5676	5838	11770	java/lang/Exception
    //   5841	5880	11770	java/lang/Exception
    //   5880	5911	11770	java/lang/Exception
    //   5916	5926	11770	java/lang/Exception
    //   5926	6000	11770	java/lang/Exception
    //   6003	6086	11770	java/lang/Exception
    //   6086	6100	11770	java/lang/Exception
    //   6103	6142	11770	java/lang/Exception
    //   6142	6215	11770	java/lang/Exception
    //   6215	6238	11770	java/lang/Exception
    //   6241	6269	11770	java/lang/Exception
    //   6272	6350	11770	java/lang/Exception
    //   6350	6358	11770	java/lang/Exception
    //   6363	6371	11770	java/lang/Exception
    //   6374	6421	11770	java/lang/Exception
    //   6424	6463	11770	java/lang/Exception
    //   6466	6530	11770	java/lang/Exception
    //   6530	6602	11770	java/lang/Exception
    //   6602	6627	11770	java/lang/Exception
    //   6630	6669	11770	java/lang/Exception
    //   6669	6698	11770	java/lang/Exception
    //   6701	6748	11770	java/lang/Exception
    //   6748	6761	11770	java/lang/Exception
    //   6764	6779	11770	java/lang/Exception
    //   6782	6795	11770	java/lang/Exception
    //   6800	6818	11770	java/lang/Exception
    //   6818	6919	11770	java/lang/Exception
    //   6919	6928	11770	java/lang/Exception
    //   6931	6962	11770	java/lang/Exception
    //   6971	7005	11770	java/lang/Exception
    //   7008	7052	11770	java/lang/Exception
    //   7059	7091	11770	java/lang/Exception
    //   7094	7123	11770	java/lang/Exception
    //   7128	7201	11770	java/lang/Exception
    //   7201	7215	11770	java/lang/Exception
    //   7215	7287	11770	java/lang/Exception
    //   7287	7295	11770	java/lang/Exception
    //   7295	7317	11770	java/lang/Exception
    //   7320	7366	11770	java/lang/Exception
    //   7369	7384	11770	java/lang/Exception
    //   7387	7394	11770	java/lang/Exception
    //   7397	7404	11770	java/lang/Exception
    //   7407	7414	11770	java/lang/Exception
    //   7417	7423	11770	java/lang/Exception
    //   7426	7432	11770	java/lang/Exception
    //   7435	7540	11770	java/lang/Exception
    //   7543	7582	11770	java/lang/Exception
    //   7585	7697	11770	java/lang/Exception
    //   7700	7756	11770	java/lang/Exception
    //   7759	7766	11770	java/lang/Exception
    //   7769	7776	11770	java/lang/Exception
    //   7779	7786	11770	java/lang/Exception
    //   7789	7796	11770	java/lang/Exception
    //   7799	7807	11770	java/lang/Exception
    //   7810	7817	11770	java/lang/Exception
    //   7820	7826	11770	java/lang/Exception
    //   7829	7835	11770	java/lang/Exception
    //   7838	7845	11770	java/lang/Exception
    //   7848	7865	11770	java/lang/Exception
    //   7993	8029	11770	java/lang/Exception
    //   8029	8034	11770	java/lang/Exception
    //   8204	8240	11770	java/lang/Exception
    //   8240	8245	11770	java/lang/Exception
    //   8290	8296	11770	java/lang/Exception
    //   8299	8305	11770	java/lang/Exception
    //   8308	8314	11770	java/lang/Exception
    //   8317	8323	11770	java/lang/Exception
    //   8326	8332	11770	java/lang/Exception
    //   8335	8341	11770	java/lang/Exception
    //   8344	8350	11770	java/lang/Exception
    //   8353	8359	11770	java/lang/Exception
    //   8362	8368	11770	java/lang/Exception
    //   8371	8377	11770	java/lang/Exception
    //   8380	8386	11770	java/lang/Exception
    //   8389	8395	11770	java/lang/Exception
    //   8398	8404	11770	java/lang/Exception
    //   8407	8413	11770	java/lang/Exception
    //   8416	8422	11770	java/lang/Exception
    //   8425	8431	11770	java/lang/Exception
    //   8434	8440	11770	java/lang/Exception
    //   8443	8449	11770	java/lang/Exception
    //   8452	8458	11770	java/lang/Exception
    //   8461	8467	11770	java/lang/Exception
    //   8470	8480	11770	java/lang/Exception
    //   8483	8489	11770	java/lang/Exception
    //   8492	8498	11770	java/lang/Exception
    //   8501	8507	11770	java/lang/Exception
    //   8510	8516	11770	java/lang/Exception
    //   8519	8609	11770	java/lang/Exception
    //   8609	8662	11770	java/lang/Exception
    //   8665	8715	11770	java/lang/Exception
    //   8718	8725	11770	java/lang/Exception
    //   8728	8744	11770	java/lang/Exception
    //   8747	8754	11770	java/lang/Exception
    //   8757	8764	11770	java/lang/Exception
    //   8767	8774	11770	java/lang/Exception
    //   8777	8784	11770	java/lang/Exception
    //   8787	8795	11770	java/lang/Exception
    //   8798	8805	11770	java/lang/Exception
    //   8808	8815	11770	java/lang/Exception
    //   8818	8832	11770	java/lang/Exception
    //   8835	8842	11770	java/lang/Exception
    //   8845	8861	11770	java/lang/Exception
    //   8864	8871	11770	java/lang/Exception
    //   8874	8881	11770	java/lang/Exception
    //   8884	8891	11770	java/lang/Exception
    //   8894	8901	11770	java/lang/Exception
    //   8904	8911	11770	java/lang/Exception
    //   8914	8921	11770	java/lang/Exception
    //   8924	8931	11770	java/lang/Exception
    //   8934	8941	11770	java/lang/Exception
    //   8944	8951	11770	java/lang/Exception
    //   8954	8959	11770	java/lang/Exception
    //   8962	8969	11770	java/lang/Exception
    //   8972	8979	11770	java/lang/Exception
    //   8982	8989	11770	java/lang/Exception
    //   8992	8999	11770	java/lang/Exception
    //   9002	9009	11770	java/lang/Exception
    //   9012	9019	11770	java/lang/Exception
    //   9022	9029	11770	java/lang/Exception
    //   9032	9039	11770	java/lang/Exception
    //   9042	9049	11770	java/lang/Exception
    //   9052	9071	11770	java/lang/Exception
    //   9074	9081	11770	java/lang/Exception
    //   9084	9091	11770	java/lang/Exception
    //   9094	9101	11770	java/lang/Exception
    //   9104	9111	11770	java/lang/Exception
    //   9114	9121	11770	java/lang/Exception
    //   9124	9131	11770	java/lang/Exception
    //   9134	9140	11770	java/lang/Exception
    //   9143	9150	11770	java/lang/Exception
    //   9153	9160	11770	java/lang/Exception
    //   9163	9170	11770	java/lang/Exception
    //   9173	9180	11770	java/lang/Exception
    //   9183	9190	11770	java/lang/Exception
    //   9193	9200	11770	java/lang/Exception
    //   9203	9210	11770	java/lang/Exception
    //   9213	9220	11770	java/lang/Exception
    //   9223	9230	11770	java/lang/Exception
    //   9233	9239	11770	java/lang/Exception
    //   9242	9259	11770	java/lang/Exception
    //   9264	9281	11770	java/lang/Exception
    //   9284	9301	11770	java/lang/Exception
    //   9306	9326	11770	java/lang/Exception
    //   9329	9336	11770	java/lang/Exception
    //   9339	9346	11770	java/lang/Exception
    //   9349	9356	11770	java/lang/Exception
    //   9359	9365	11770	java/lang/Exception
    //   9368	9374	11770	java/lang/Exception
    //   9377	9384	11770	java/lang/Exception
    //   9387	9393	11770	java/lang/Exception
    //   9396	9413	11770	java/lang/Exception
    //   9416	9428	11770	java/lang/Exception
    //   9433	9441	11770	java/lang/Exception
    //   9444	9451	11770	java/lang/Exception
    //   9454	9461	11770	java/lang/Exception
    //   9464	9471	11770	java/lang/Exception
    //   9474	9481	11770	java/lang/Exception
    //   9484	9491	11770	java/lang/Exception
    //   9494	9501	11770	java/lang/Exception
    //   9504	9511	11770	java/lang/Exception
    //   9514	9521	11770	java/lang/Exception
    //   9524	9531	11770	java/lang/Exception
    //   9534	9541	11770	java/lang/Exception
    //   9544	9551	11770	java/lang/Exception
    //   9554	9561	11770	java/lang/Exception
    //   9564	9571	11770	java/lang/Exception
    //   9574	9581	11770	java/lang/Exception
    //   9584	9590	11770	java/lang/Exception
    //   9593	9611	11770	java/lang/Exception
    //   9614	9632	11770	java/lang/Exception
    //   9635	9644	11770	java/lang/Exception
    //   9647	9662	11770	java/lang/Exception
    //   9665	9676	11770	java/lang/Exception
    //   9681	9686	11770	java/lang/Exception
    //   9689	9696	11770	java/lang/Exception
    //   9699	9706	11770	java/lang/Exception
    //   9709	9716	11770	java/lang/Exception
    //   9719	9726	11770	java/lang/Exception
    //   9729	9736	11770	java/lang/Exception
    //   9739	9753	11770	java/lang/Exception
    //   9756	9763	11770	java/lang/Exception
    //   9766	9777	11770	java/lang/Exception
    //   9780	9792	11770	java/lang/Exception
    //   9795	9802	11770	java/lang/Exception
    //   9805	9812	11770	java/lang/Exception
    //   9815	9834	11770	java/lang/Exception
    //   9837	9844	11770	java/lang/Exception
    //   9847	9853	11770	java/lang/Exception
    //   9856	9867	11770	java/lang/Exception
    //   9870	9888	11770	java/lang/Exception
    //   9891	9903	11770	java/lang/Exception
    //   9906	9912	11770	java/lang/Exception
    //   9915	9922	11770	java/lang/Exception
    //   9925	9940	11770	java/lang/Exception
    //   9943	9949	11770	java/lang/Exception
    //   9952	9967	11770	java/lang/Exception
    //   9970	9977	11770	java/lang/Exception
    //   9980	9992	11770	java/lang/Exception
    //   9995	10002	11770	java/lang/Exception
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
        localObject = bfyz.b(((QQAppInterface)getAppRuntime()).getCurrentAccountUin());
        ((SharedPreferences)localObject).edit().putString("qav_upgrade_invite_video", paramString).commit();
        ((SharedPreferences)localObject).edit().putString("qav_upgrade_invite_multi", str).commit();
        bfyz.i(getAppRuntime().getApplication(), paramInt, jdField_a_of_type_JavaLangString);
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
  
  public static boolean a(aqmi paramaqmi, String paramString, Set<String> paramSet)
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
      catch (Exception paramaqmi)
      {
        bool1 = bool2;
        if (QLog.isColorLevel())
        {
          QLog.i("SPLASH_ConfigServlet", 2, "parseXML | NearbyBanner parse exception,", paramaqmi);
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
        paramaqmi.a(paramaqmi.a(l1, str3, (byte)3, str2, ((StringBuffer)localObject).toString(), BaseApplication.getContext().getFilesDir().getAbsolutePath() + "/" + "NearbyBannerPic" + "/" + str1, l3 + "|" + l2, (short)k, str1));
        awka.a(jdField_a_of_type_JavaLangString, "has_new_banner", Boolean.valueOf(true));
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
        k = bfyz.a(paramQQAppInterface.getApp(), "nearby_auth_video_config_version", jdField_a_of_type_JavaLangString);
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
          awkl.a(paramConfig);
          bfyz.a(paramQQAppInterface.getApp(), "nearby_auth_video_config_version", jdField_a_of_type_JavaLangString, j);
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
        k = bfyz.a(paramQQAppInterface.getApp(), "nearby_videochat_dialog_config_version", jdField_a_of_type_JavaLangString);
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
          ((bezh)paramQQAppInterface.getManager(224)).c(paramConfig);
          bfyz.a(paramQQAppInterface.getApp(), "nearby_videochat_dialog_config_version", jdField_a_of_type_JavaLangString, j);
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
        k = bfyz.a(paramQQAppInterface.getApp(), "nearby_videochat_banner_config_version", jdField_a_of_type_JavaLangString);
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
          ((bezh)paramQQAppInterface.getManager(224)).b(paramConfig);
          bfyz.a(paramQQAppInterface.getApp(), "nearby_videochat_banner_config_version", jdField_a_of_type_JavaLangString, j);
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
    int i = bfyz.aQ(((QQAppInterface)getAppRuntime()).getApp(), paramQQAppInterface);
    if (!bmsa.a()) {
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
        bfyz.ag(((QQAppInterface)getAppRuntime()).getApp(), paramQQAppInterface, k);
        new bmxg().a(paramConfig, bmsa.a.getAbsolutePath(), "temp_template_zip", new aqly(this));
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.d("QQSTORY_QUESTION_TAB_SPLASH_ConfigServlet", 2, "GetQQStoryQuestionTabConfig|type: 问答Tab配置回包内容为空");
    return;
    label229:
    if (QLog.isColorLevel()) {
      QLog.d("QQSTORY_QUESTION_TAB_SPLASH_ConfigServlet", 2, "GetQQStoryQuestionTabConfig|type: 问答Tab配置回包为空");
    }
    bmsa.c();
  }
  
  private void ae(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    if ((paramConfig.content_list != null) && (paramConfig.content_list.size() > 0))
    {
      paramQQAppInterface = (PhoneContactManagerImp)paramQQAppInterface.getManager(11);
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
      localamoa = (amoa)paramQQAppInterface.getBusinessHandler(53);
      j = localamoa.a(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount());
      if ((paramConfig.content_list != null) && (paramConfig.content_list.size() > 0))
      {
        paramQQAppInterface = (String)paramConfig.content_list.get(0);
        if (QLog.isColorLevel()) {
          QLog.d("babyqConfig", 2, "received BabyQPlusPanelConfig configVersion:" + i + " ,localVersion:" + j + " ,configContent" + paramQQAppInterface);
        }
        if (i != j)
        {
          localamoa.a(i, paramQQAppInterface);
          return;
        }
        localamoa.a(false, false);
        return;
      }
    }
    catch (Exception paramQQAppInterface)
    {
      int i;
      amoa localamoa;
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
          localamoa.a(false, false);
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
    if (j == bfyz.S(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin())) {
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
          bfyz.c(paramQQAppInterface.getApp(), j, paramQQAppInterface.getCurrentAccountUin(), localConfig);
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
    if (j == bfyz.T(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin())) {
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
      paramConfig = axsb.a(paramConfig.content.get().toByteArray());
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
              bfyz.d(paramQQAppInterface.getApp(), j, paramQQAppInterface.getCurrentAccountUin(), localConfig);
              paramQQAppInterface = (anwp)paramQQAppInterface.getManager(199);
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
      j = bfyz.D(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount());
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
    bfyz.a(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount(), i, true, bool);
    return;
    if (i != j)
    {
      bfyz.a(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount(), i, false, true);
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
    bass.jdField_a_of_type_JavaLangString = paramQQAppInterface.getCurrentAccountUin();
    int i = paramConfig.version.get();
    int j = bass.a(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin());
    if (QLog.isColorLevel()) {
      QLog.d("Q.uniteSearch.SearchNetEntryConfig", 2, "handleSearchNetEntryConfig, version: " + i + " localVersion: " + j);
    }
    if (i == j) {
      return;
    }
    bass.a(paramQQAppInterface.getApp(), i, paramQQAppInterface.getCurrentAccountUin());
    bass.a(paramQQAppInterface.getApp(), paramConfig, paramQQAppInterface.getCurrentUin());
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
              ((MedalWallMng)paramQQAppInterface.getManager(250)).a(i, paramConfig, str1, str2);
              bfyz.v(paramQQAppInterface.getApp(), j, paramQQAppInterface.getCurrentAccountUin());
              bfyz.w(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin(), i);
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
    int i1 = bfyz.a(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, 2);
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
          bfyz.d(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, 3, k);
          if (paramQQAppInterface.isCreateManager(250)) {
            ((MedalWallMng)paramQQAppInterface.getManager(250)).a(k);
          }
        }
        bfyz.d(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, 2, n);
        localObject1 = paramConfig;
        if (QLog.isColorLevel()) {
          QLog.i("SPLASH_ConfigServlet", 2, String.format(Locale.getDefault(), "handleMedalStrongReminderConfig localVersion: %s, version: %s, result: %s, value: %s, strContent: %s", new Object[] { Integer.valueOf(i1), Integer.valueOf(n), Integer.valueOf(j), Integer.valueOf(k), localObject1 }));
        }
        return;
        if (paramConfig.compress.get() != 1) {
          continue;
        }
        paramConfig = axsb.a(paramConfig.content.get().toByteArray());
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
        int m = ((Integer)bfyz.a(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, 2)).intValue();
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
              bfyz.a(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, 3, localObject1);
              if (paramQQAppInterface.isCreateManager(159)) {
                ((amvo)paramQQAppInterface.getManager(159)).a((String)localObject1);
              }
            }
            bfyz.a(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, 2, Integer.valueOf(k));
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
          paramConfig = axsb.a(paramConfig.content.get().toByteArray());
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
          localObject3 = axsb.a(((ConfigurationService.Content)localObject4).content.get().toByteArray());
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
        akus.a();
        akus.a((String)localObject1);
        bfyz.u(paramQQAppInterface.getApp(), paramConfig.version.get(), jdField_a_of_type_JavaLangString);
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
        break label230;
      }
      paramConfig = (ConfigurationService.Content)paramConfig.msg_content_list.get(0);
      if (paramConfig == null) {
        break label220;
      }
      if (paramConfig.compress.get() != 1) {
        break label196;
      }
      paramConfig = axsb.a(paramConfig.content.get().toByteArray());
      if (paramConfig == null) {
        break label240;
      }
    }
    for (;;)
    {
      try
      {
        paramConfig = new String(paramConfig, "UTF-8");
        if (TextUtils.isEmpty(paramConfig)) {
          break label210;
        }
        ((amzp)paramQQAppInterface.getManager(22)).a(paramConfig, j);
        return;
      }
      catch (Exception paramConfig)
      {
        QLog.e("Q.lebanew", 1, "handleNewTroopRecommend uncompress failed" + paramConfig);
        paramConfig = null;
        continue;
      }
      label196:
      paramConfig = paramConfig.content.get().toStringUtf8();
      continue;
      label210:
      QLog.w("SPLASH_ConfigServlet", 1, "handleNewTroopRecommend config_content is empty!");
      return;
      label220:
      QLog.w("SPLASH_ConfigServlet", 1, "handleNewTroopRecommend content is empty!");
      return;
      label230:
      QLog.w("SPLASH_ConfigServlet", 1, "handleNewTroopRecommend msg_content_list is empty!");
      return;
      label240:
      paramConfig = null;
    }
  }
  
  private void ap(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    boolean bool2 = true;
    axlb localaxlb = (axlb)paramQQAppInterface.getManager(228);
    int i = localaxlb.a();
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
          paramQQAppInterface = axsb.a(paramConfig.content.get().toByteArray());
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
        localaxlb.a(bool1, paramQQAppInterface);
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
    int i = bfwf.a();
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
      paramConfig = axsb.a(paramConfig.content.get().toByteArray());
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
          bfwf.a().a(paramQQAppInterface.getApp(), paramConfig, j);
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
    bfwf.a().a(j);
  }
  
  private void ar(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    int i = paramConfig.version.get();
    int j = bfyz.ab(BaseApplication.getContext(), jdField_a_of_type_JavaLangString);
    QLog.i("SPLASH_ConfigServlet", 1, "handleDevConfig: ,version: " + paramConfig.version.get() + "| localVersion: " + j);
    if (i != j)
    {
      bfyz.z(BaseApplication.getContext(), jdField_a_of_type_JavaLangString, i);
      paramQQAppInterface = a(paramConfig);
      if ((paramQQAppInterface != null) && (paramQQAppInterface.size() > 0)) {}
      try
      {
        paramQQAppInterface = (String)paramQQAppInterface.get(paramQQAppInterface.size() - 1);
        QLog.d("SPLASH_ConfigServlet", 1, new Object[] { "devConfig is ", paramQQAppInterface });
        bfyz.l(BaseApplication.getContext(), jdField_a_of_type_JavaLangString, paramQQAppInterface);
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
    int j = ((Integer)bfyz.a(localBaseApplication, str, "config_tim_team_version_code", Integer.valueOf(0))).intValue();
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
      bfyz.a(localBaseApplication, str, false, "config_tim_team_is_web", Boolean.valueOf(bool));
      bfyz.a(localBaseApplication, str, false, "config_tim_team_url", paramQQAppInterface);
      bfyz.a(localBaseApplication, str, true, "config_tim_team_version_code", Integer.valueOf(i));
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
        localObject2 = aocu.a((byte[])localObject1);
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
    aodg localaodg = (aodg)localQQAppInterface.getManager(168);
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
          paramIntent = aocu.a(paramIntent.content.get().toByteArray());
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
        if (localaodg != null) {
          localaodg.a(paramIntent);
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
      if (localaodg != null) {
        localaodg.b();
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
    paramIntent = azzx.a();
    int j = paramConfig.version.get();
    int i = bfyz.h(((QQAppInterface)getAppRuntime()).getApp());
    if (!azzx.a()) {
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
      bfyz.f(((QQAppInterface)getAppRuntime()).getApp(), j);
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
    int j = ahns.a(paramQQAppInterface);
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
        ahns.a(paramQQAppInterface, paramConfig.getBoolean("useRecommendedSticker"));
        ahns.a(localBaseApplication, str, paramConfig.getInt("maxMatchLength"));
      }
      for (;;)
      {
        ahns.a(paramQQAppInterface, i);
        return;
        ahns.a(paramQQAppInterface, false);
      }
    }
    catch (Exception paramConfig)
    {
      for (;;)
      {
        ahns.a(paramQQAppInterface, false);
        if (QLog.isColorLevel()) {
          QLog.d("SPLASH_ConfigServlet", 2, paramConfig.getMessage());
        }
      }
    }
  }
  
  public static void b(QQAppInterface paramQQAppInterface, String paramString)
  {
    jdField_a_of_type_JavaLangString = paramString;
    NewIntent localNewIntent = new NewIntent(paramQQAppInterface.getApp(), aqlw.class);
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
        bfyz.d(((QQAppInterface)getAppRuntime()).getCurrentAccountUin()).edit().putString("qav_anychat_time_value", paramString).commit();
        bfyz.j(getAppRuntime().getApplication(), paramInt, jdField_a_of_type_JavaLangString);
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
    aodg localaodg = (aodg)localQQAppInterface.getManager(168);
    if (localaodg == null)
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
      localaodg.a(i);
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
          paramIntent = aocu.a((byte[])localObject2);
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
      localaodg.b(j);
      localaodg.a(localNameNotFoundException);
      if (QLog.isColorLevel()) {
        QLog.d("ArConfig_configServlet", 2, "maxEndTimeArConfigInfo|| maxEndtime=" + localNameNotFoundException.aREnd);
      }
      OlympicServlet.a(localQQAppInterface, 87, j, 0, 0, 0, 0);
    }
    for (;;)
    {
      i = 0;
      label648:
      if ((i == 0) || (localaodg == null)) {
        break;
      }
      QLog.d("ArConfig_configServlet", 1, "arManager.downloadArResource");
      localaodg.a(true, false);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ArConfig_configServlet", 2, "handleResp_GetArResource|combineArConfigInfo is null");
      }
      OlympicServlet.a(localQQAppInterface, 87, j, 0, 0, 5, 0);
      continue;
      label707:
      localaodg.a();
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
    int j = bfyz.R(BaseApplication.getContext(), jdField_a_of_type_JavaLangString);
    if (QLog.isColorLevel()) {
      QLog.i("SPLASH_ConfigServlet", 2, "handleRespNewBoatConfig: ,version: " + paramConfig.version.get() + "| localVersion: " + j);
    }
    if (i != j)
    {
      bfyz.t(BaseApplication.getContext(), i, jdField_a_of_type_JavaLangString);
      paramConfig = a(paramConfig);
      if ((paramConfig != null) && (paramConfig.size() > 0)) {
        awgw.a(paramQQAppInterface, (String)paramConfig.get(0));
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
      if (!aptl.a(paramString)) {
        ThreadManager.executeOnNetWorkThread(new ConfigServlet.4(this, (String)localObject1));
      }
      apth.a.a(apth.a.a(l1, (String)localObject2, (byte)3, (String)localObject1, (String)localObject4, (String)localObject5, l3 + "|" + l2, (short)k, paramString));
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
        bcef.b((QQAppInterface)getAppRuntime(), "dc00898", "", "", "0X80087C0", "0X80087C0", (int)l1, 0, "", "", "", "");
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
    anyd localanyd = (anyd)((QQAppInterface)getAppRuntime()).getManager(220);
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
      arrayOfByte = axsb.a(paramIntent.content.get().toByteArray());
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
          if (localanyd.a(paramIntent))
          {
            localanyd.a(i);
            localanyd.a();
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
        if (localanyd != null) {
          localanyd.b();
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
    int j = bfyz.f(((QQAppInterface)getAppRuntime()).getApp());
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
        arrayOfByte = axsb.a(paramConfig.content.get().toByteArray());
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
          boolean bool = beda.a(paramConfig);
          if (bool) {
            bfyz.d(((QQAppInterface)getAppRuntime()).getApp(), i);
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
    //   0: invokestatic 921	javax/xml/parsers/DocumentBuilderFactory:newInstance	()Ljavax/xml/parsers/DocumentBuilderFactory;
    //   3: invokevirtual 925	javax/xml/parsers/DocumentBuilderFactory:newDocumentBuilder	()Ljavax/xml/parsers/DocumentBuilder;
    //   6: new 927	java/io/ByteArrayInputStream
    //   9: dup
    //   10: aload_1
    //   11: ldc_w 929
    //   14: invokevirtual 933	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   17: invokespecial 934	java/io/ByteArrayInputStream:<init>	([B)V
    //   20: invokevirtual 939	javax/xml/parsers/DocumentBuilder:parse	(Ljava/io/InputStream;)Lorg/w3c/dom/Document;
    //   23: astore 14
    //   25: aload 14
    //   27: ldc_w 4142
    //   30: invokeinterface 947 2 0
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
    //   59: ldc_w 4144
    //   62: astore_1
    //   63: ldc 13
    //   65: astore 13
    //   67: iconst_0
    //   68: istore 9
    //   70: iload 9
    //   72: aload 15
    //   74: invokeinterface 952 1 0
    //   79: if_icmpge +480 -> 559
    //   82: aload 14
    //   84: ldc_w 3390
    //   87: invokeinterface 947 2 0
    //   92: iload 9
    //   94: invokeinterface 958 2 0
    //   99: invokeinterface 964 1 0
    //   104: invokeinterface 967 1 0
    //   109: astore 13
    //   111: aload 14
    //   113: ldc_w 3396
    //   116: invokeinterface 947 2 0
    //   121: iload 9
    //   123: invokeinterface 958 2 0
    //   128: invokeinterface 964 1 0
    //   133: invokeinterface 967 1 0
    //   138: astore 12
    //   140: aload 14
    //   142: ldc_w 4145
    //   145: invokeinterface 947 2 0
    //   150: iload 9
    //   152: invokeinterface 958 2 0
    //   157: invokeinterface 964 1 0
    //   162: invokeinterface 967 1 0
    //   167: invokestatic 4151	java/lang/Float:parseFloat	(Ljava/lang/String;)F
    //   170: fstore 4
    //   172: aload 14
    //   174: ldc_w 4152
    //   177: invokeinterface 947 2 0
    //   182: iload 9
    //   184: invokeinterface 958 2 0
    //   189: invokeinterface 964 1 0
    //   194: invokeinterface 967 1 0
    //   199: invokestatic 4151	java/lang/Float:parseFloat	(Ljava/lang/String;)F
    //   202: fstore_3
    //   203: iconst_1
    //   204: istore 10
    //   206: aload 14
    //   208: ldc_w 4153
    //   211: invokeinterface 947 2 0
    //   216: iload 9
    //   218: invokeinterface 958 2 0
    //   223: invokeinterface 964 1 0
    //   228: invokeinterface 967 1 0
    //   233: invokestatic 4151	java/lang/Float:parseFloat	(Ljava/lang/String;)F
    //   236: fstore 5
    //   238: aload 14
    //   240: ldc_w 4154
    //   243: invokeinterface 947 2 0
    //   248: iload 9
    //   250: invokeinterface 958 2 0
    //   255: invokeinterface 964 1 0
    //   260: invokeinterface 967 1 0
    //   265: invokestatic 4151	java/lang/Float:parseFloat	(Ljava/lang/String;)F
    //   268: fstore 8
    //   270: aload 14
    //   272: ldc_w 4156
    //   275: invokeinterface 947 2 0
    //   280: iload 9
    //   282: invokeinterface 958 2 0
    //   287: invokeinterface 964 1 0
    //   292: invokeinterface 967 1 0
    //   297: astore 11
    //   299: aload 14
    //   301: ldc_w 4157
    //   304: invokeinterface 947 2 0
    //   309: iload 9
    //   311: invokeinterface 958 2 0
    //   316: invokeinterface 964 1 0
    //   321: invokeinterface 967 1 0
    //   326: invokestatic 4151	java/lang/Float:parseFloat	(Ljava/lang/String;)F
    //   329: fstore 7
    //   331: aload 14
    //   333: ldc_w 4153
    //   336: invokeinterface 947 2 0
    //   341: iload 9
    //   343: invokeinterface 958 2 0
    //   348: invokeinterface 964 1 0
    //   353: invokeinterface 967 1 0
    //   358: invokestatic 4151	java/lang/Float:parseFloat	(Ljava/lang/String;)F
    //   361: fstore 6
    //   363: aload 14
    //   365: ldc_w 4159
    //   368: invokeinterface 947 2 0
    //   373: iload 9
    //   375: invokeinterface 958 2 0
    //   380: invokeinterface 964 1 0
    //   385: invokeinterface 967 1 0
    //   390: astore_1
    //   391: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   394: ifeq +296 -> 690
    //   397: ldc 183
    //   399: iconst_2
    //   400: new 85	java/lang/StringBuilder
    //   403: dup
    //   404: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   407: ldc_w 4161
    //   410: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   413: aload 13
    //   415: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   418: ldc_w 4163
    //   421: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   424: aload 12
    //   426: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   429: ldc_w 4165
    //   432: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   435: fload 4
    //   437: invokevirtual 4168	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   440: ldc_w 4170
    //   443: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   446: fload_3
    //   447: invokevirtual 4168	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   450: ldc_w 4172
    //   453: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   456: iload 10
    //   458: invokevirtual 152	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   461: ldc_w 4174
    //   464: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   467: fload 5
    //   469: invokevirtual 4168	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   472: ldc_w 4176
    //   475: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   478: fload 8
    //   480: invokevirtual 4168	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   483: ldc_w 4178
    //   486: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   489: aload 11
    //   491: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   494: ldc_w 4180
    //   497: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   500: fload 7
    //   502: invokevirtual 4168	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   505: ldc_w 4182
    //   508: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   511: aload_1
    //   512: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   515: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   518: invokestatic 200	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   521: goto +169 -> 690
    //   524: astore_1
    //   525: aload 14
    //   527: ldc_w 4183
    //   530: invokeinterface 947 2 0
    //   535: iload 9
    //   537: invokeinterface 958 2 0
    //   542: invokeinterface 964 1 0
    //   547: invokeinterface 967 1 0
    //   552: invokestatic 4151	java/lang/Float:parseFloat	(Ljava/lang/String;)F
    //   555: fstore_3
    //   556: goto -350 -> 206
    //   559: aload 13
    //   561: ifnull +126 -> 687
    //   564: aload 13
    //   566: invokevirtual 602	java/lang/String:trim	()Ljava/lang/String;
    //   569: ldc 13
    //   571: invokevirtual 622	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   574: ifne +113 -> 687
    //   577: new 85	java/lang/StringBuilder
    //   580: dup
    //   581: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   584: aload_0
    //   585: invokevirtual 47	aqlw:getAppRuntime	()Lmqq/app/AppRuntime;
    //   588: invokevirtual 2615	mqq/app/AppRuntime:getApplication	()Lmqq/app/MobileQQ;
    //   591: invokevirtual 2742	mqq/app/MobileQQ:getFilesDir	()Ljava/io/File;
    //   594: invokevirtual 2745	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   597: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   600: ldc_w 2775
    //   603: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   606: getstatic 15	aqlw:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   609: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   612: ldc_w 2775
    //   615: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   618: ldc_w 2820
    //   621: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   624: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   627: astore 14
    //   629: ldc_w 4185
    //   632: aload 13
    //   634: invokestatic 4190	com/tencent/mobileqq/msf/sdk/MsfSdkUtils:insertMtype	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   637: astore 13
    //   639: fload_3
    //   640: fstore 7
    //   642: fload_3
    //   643: fconst_0
    //   644: fcmpg
    //   645: ifge +8 -> 653
    //   648: ldc_w 826
    //   651: fstore 7
    //   653: new 4192	com/tencent/mobileqq/config/splashlogo/ConfigServlet$5
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
    //   678: invokespecial 4195	com/tencent/mobileqq/config/splashlogo/ConfigServlet$5:<init>	(Laqlw;Ljava/lang/String;Ljava/lang/String;FFFLjava/lang/String;Ljava/lang/String;FZILjava/lang/String;)V
    //   681: iconst_2
    //   682: aconst_null
    //   683: iconst_0
    //   684: invokestatic 3320	com/tencent/mobileqq/app/ThreadManager:post	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
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
    //   710: ldc_w 4144
    //   713: astore_1
    //   714: goto -323 -> 391
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	717	0	this	aqlw
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
      int j = bfyz.q(((QQAppInterface)getAppRuntime()).getApp(), paramIntent);
      if (QLog.isColorLevel()) {
        QLog.d("nearby_flower_operation_gray_tips", 2, "serverVersion=" + i + "|localVersion=" + j);
      }
      if (i != j)
      {
        bfyz.c(((QQAppInterface)getAppRuntime()).getApp(), paramIntent, i);
        amxb localamxb = (amxb)((QQAppInterface)getAppRuntime()).getManager(124);
        if ((!paramConfig.content_list.has()) || (paramConfig.content_list.get().size() <= 0)) {
          break label246;
        }
        localList = paramConfig.content_list.get();
        if ((localList != null) && (localList.size() > 0))
        {
          localamxb.a(paramIntent, (String)localList.get(0));
          if (QLog.isColorLevel()) {
            QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 53,content: " + (String)localList.get(0) + ",version: " + paramConfig.version.get());
          }
        }
      }
    }
    label246:
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
      awkj.a("GENERAL_LBS_CONFIGS_CMD", new Object[] { "getGeneralLBSConfigs", paramString, Long.valueOf(l) });
    }
    paramString = new NewIntent(paramQQAppInterface.getApp(), aqlw.class);
    paramString.putExtra("k_cmd_type", new int[] { 87, 12, 174, 189 });
    paramQQAppInterface.startServlet(paramString);
  }
  
  private void e(ConfigurationService.Config paramConfig)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)getAppRuntime();
    int i = paramConfig.version.get();
    int j = bfyz.n(localQQAppInterface.getApp());
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
      bfyz.m(localQQAppInterface.getApp(), i, str);
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
          bfyz.a(getAppRuntime().getApplication(), paramInt, str2, paramString);
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
      int j = bfyz.r(((QQAppInterface)getAppRuntime()).getApp(), paramIntent);
      if (QLog.isColorLevel()) {
        QLog.d("HotChatManager", 2, "serverVersion=" + i + "|localVersion=" + j);
      }
      if (i != j)
      {
        bfyz.d(((QQAppInterface)getAppRuntime()).getApp(), paramIntent, i);
        HotChatManager localHotChatManager = (HotChatManager)((QQAppInterface)getAppRuntime()).getManager(60);
        if ((!paramConfig.content_list.has()) || (paramConfig.content_list.get().size() <= 0)) {
          break label246;
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
    label246:
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
    paramString = (ayji)paramQQAppInterface.getManager(179);
    if ((paramString != null) && (paramString.a() != null) && (paramString.a().d * 1000L <= 0L)) {}
    paramString = new NewIntent(paramQQAppInterface.getApp(), aqlw.class);
    paramString.putExtra("k_cmd_type", new int[] { 113 });
    paramQQAppInterface.startServlet(paramString);
  }
  
  private void f(ConfigurationService.Config paramConfig)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)getAppRuntime();
    int i = paramConfig.version.get();
    int j = bfyz.o(localQQAppInterface.getApp());
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
      bfyz.n(localQQAppInterface.getApp(), i, str);
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
    int i = bfyz.g(((QQAppInterface)getAppRuntime()).getApp());
    if (!PtvTemplateManager.a()) {
      i = 0;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PtvTemplateManager", 2, "serverVersion=" + j + "|localVersion=" + i);
    }
    if (j != i)
    {
      bfyz.e(((QQAppInterface)getAppRuntime()).getApp(), j);
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
    int i = bfyz.j(((QQAppInterface)getAppRuntime()).getApp());
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
        bfyz.h(((QQAppInterface)getAppRuntime()).getApp(), k);
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
    int i = bfyz.i(((QQAppInterface)getAppRuntime()).getApp());
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
        bfyz.g(((QQAppInterface)getAppRuntime()).getApp(), j);
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
    bobd localbobd = bobd.a();
    int k = paramConfig.version.get();
    int i = bfyz.E(((QQAppInterface)getAppRuntime()).getApp());
    if (!localbobd.a()) {
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
      } while (!localbobd.a(paramConfig, (QQAppInterface)getAppRuntime()));
      bfyz.t(((QQAppInterface)getAppRuntime()).getApp(), k);
      return;
    } while (!QLog.isColorLevel());
    label195:
    QLog.d("QQSTORY_FOLLOW_CAPTURE_SPLASH_ConfigServlet", 2, "GetQQStoryFollowCaptureConfig|type: 合拍配置回包内容为空");
    return;
    label212:
    if (QLog.isColorLevel()) {
      QLog.d("QQSTORY_FOLLOW_CAPTURE_SPLASH_ConfigServlet", 2, "GetQQStoryFollowCaptureConfig|type: 合拍配置回包为空");
    }
    localbobd.a();
  }
  
  private void i(Intent paramIntent, ConfigurationService.Config paramConfig)
  {
    NearbyGrayTipsManager localNearbyGrayTipsManager;
    String str2;
    if (!TextUtils.isEmpty(paramIntent.getStringExtra("key_uin")))
    {
      int i = paramConfig.version.get();
      int j = bfyz.e(((QQAppInterface)getAppRuntime()).getApp());
      if (QLog.isColorLevel()) {
        QLog.d("nearby_aio_operation_gray_tips", 2, "serverVersion=" + i + "|localVersion=" + j);
      }
      if (i != j)
      {
        bfyz.c(((QQAppInterface)getAppRuntime()).getApp(), i);
        localNearbyGrayTipsManager = (NearbyGrayTipsManager)((QQAppInterface)getAppRuntime()).getManager(93);
        if ((!paramConfig.content_list.has()) || (paramConfig.content_list.get().size() <= 0)) {
          break label481;
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
          break label531;
        }
        str1 = ((JSONObject)localObject).getString("MD5");
        paramIntent = str1;
        if (!TextUtils.isEmpty(str1)) {
          paramIntent = str1.toLowerCase();
        }
        if (((JSONObject)localObject).isNull("URL")) {
          break label525;
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
      label481:
      if (QLog.isColorLevel()) {
        QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 23,content_list is empty ,version: " + paramConfig.version.get());
      }
      localNearbyGrayTipsManager.b();
      return;
      label525:
      String str1 = null;
      continue;
      label531:
      paramIntent = null;
    }
  }
  
  private void i(ConfigurationService.Config paramConfig)
  {
    int i = paramConfig.version.get();
    bfyz.h(getAppRuntime().getApplication(), i, jdField_a_of_type_JavaLangString);
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
    if (i == bfyz.o(((QQAppInterface)getAppRuntime()).getApp(), jdField_a_of_type_JavaLangString)) {}
    for (;;)
    {
      return;
      bfyz.k(((QQAppInterface)getAppRuntime()).getApp(), i, jdField_a_of_type_JavaLangString);
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
                ((vla)paramIntent.getManager(181)).h(Boolean.parseBoolean(paramConfig));
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
    aihp localaihp = (aihp)localQQAppInterface.getManager(102);
    i = localaihp.a();
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
        localaiho2 = new aiho();
      }
      catch (Throwable localThrowable2)
      {
        aiho localaiho2;
        XmlPullParser localXmlPullParser;
        int k;
        Object localObject3;
        aiho localaiho1 = null;
        i = 0;
        paramConfig = null;
        localObject1 = null;
        continue;
        localaiho1 = null;
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
        localaiho1 = localaiho2;
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
            localaiho2.jdField_b_of_type_JavaLangString = localXmlPullParser.getAttributeValue(j);
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
          localaiho2.jdField_a_of_type_JavaLangString = localXmlPullParser.getAttributeValue(j);
          continue;
          QLog.e("PhoneContact.Manager", 1, "", localThrowable1);
        }
        catch (Throwable localThrowable1)
        {
          localaiho1 = localaiho2;
        }
      }
      catch (Throwable localThrowable3)
      {
        i = 0;
        paramConfig = null;
        localObject1 = null;
        localaiho1 = localaiho2;
        continue;
        continue;
        continue;
      }
      localObject5 = localObject1;
      localObject3 = paramConfig;
      j = i;
      localaihp.a(m, localObject6, localaiho1);
      ((PhoneContactManagerImp)localQQAppInterface.getManager(11)).a(j, localObject5, (String)localObject3);
      return;
      if ("dayNum".equals(localObject3)) {
        localaiho2.jdField_a_of_type_Int = Integer.valueOf(localXmlPullParser.getAttributeValue(j)).intValue();
      } else if ("dayIntervalNum".equals(localObject3)) {
        localaiho2.jdField_b_of_type_Int = Integer.valueOf(localXmlPullParser.getAttributeValue(j)).intValue();
      } else if ("totalNum".equals(localObject3)) {
        localaiho2.c = Integer.valueOf(localXmlPullParser.getAttributeValue(j)).intValue();
      } else if ("loginNum".equals(localObject3)) {
        localaiho2.e = Integer.valueOf(localXmlPullParser.getAttributeValue(j)).intValue();
      } else if ("banner".equals(localObject3)) {
        localaiho2.jdField_a_of_type_Boolean = "1".equals(localXmlPullParser.getAttributeValue(j));
      } else if ("setEntry".equals(localObject3)) {
        localaiho2.jdField_b_of_type_Boolean = "1".equals(localXmlPullParser.getAttributeValue(j));
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
        localaiho1 = localaiho2;
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
          break label836;
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
    int j = bfyz.p(((QQAppInterface)getAppRuntime()).getApp(), jdField_a_of_type_JavaLangString);
    if (i == j) {}
    label179:
    label195:
    do
    {
      do
      {
        return;
        bfyz.l(((QQAppInterface)getAppRuntime()).getApp(), i, jdField_a_of_type_JavaLangString);
        for (;;)
        {
          try
          {
            if (paramConfig.msg_content_list != null)
            {
              i = paramConfig.msg_content_list.size();
              paramIntent = (auov)paramIntent.getManager(267);
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
            int k = bfyz.A(localQQAppInterface.getApp(), localQQAppInterface.getAccount());
            if (QLog.isColorLevel()) {
              QLog.d("SPLASH_ConfigServlet", 2, "received SUBSCRIPT_RECOMMEND_CMD remote version: " + j + " | localVersion: " + k);
            }
            if ((j != k) || (paramConfig.content_list.size() > 0))
            {
              if ((uex.a((QQAppInterface)getAppRuntime(), str)) && (QLog.isColorLevel())) {
                QLog.d("SPLASH_ConfigServlet", 2, "received SUBSCRIPT_RECOMMEND_CMD save version: " + j);
              }
              bfyz.l(getAppRuntime().getApplication(), localQQAppInterface.getAccount(), j);
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
              break label2075;
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
                break label2104;
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
            ucp.d(localQQAppInterface, "1".equals(localObject3));
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
            bkwm.a((String)localObject2, localQQAppInterface);
          }
          localObject2 = (String)localHashMap.get("synchronize_to_qzone");
          if (localObject2 != null) {
            bkwm.b((String)localObject2, localQQAppInterface);
          }
          localObject2 = (String)localHashMap.get("merge_feeds");
          if (localObject2 != null) {
            bkwm.d((String)localObject2, localQQAppInterface);
          }
          localObject2 = (String)localHashMap.get("kandian_feeds");
          if (localObject2 != null) {
            bkwm.e((String)localObject2, localQQAppInterface);
          }
          i = paramConfig.version.get();
          bfyz.g(getAppRuntime().getApplication(), i, jdField_a_of_type_JavaLangString);
          if ((paramIntent != null) && (paramIntent.hasExtra("update101Version"))) {
            SettingCloneUtil.writeValueForInt(getAppRuntime().getApplication(), jdField_a_of_type_JavaLangString, null, "qqsetting_calltab_show_key_version", paramIntent.getIntExtra("update101Version", 0));
          }
          ArkAppCenter.a((String)localHashMap.get("arkapp_pa_nshow"));
          awka.a(localQQAppInterface.getAccount(), "supportHotChatDemo", Boolean.valueOf("1".equals(localHashMap.get("hotchat_demo"))));
          paramIntent = (azbw)localQQAppInterface.getManager(89);
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
            break label2109;
          }
          i = 4;
          label1377:
          paramConfig = paramConfig.getSharedPreferences("qwallet_multi", i);
          if (paramConfig != null)
          {
            paramConfig = paramConfig.edit();
            if ((!TextUtils.isEmpty(paramIntent)) && (!"1".equals(paramIntent))) {
              break label2114;
            }
            bool = true;
            label1417:
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
            bbub.a(paramIntent, true);
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
                paramConfig = bbgd.a();
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
              bbgk.jdField_b_of_type_Int = Integer.valueOf(paramIntent).intValue();
              alce.a((String)localHashMap.get("shortvideo_progressive_enable"));
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
              bcdo.a("pic_thumb_400Enable", paramIntent);
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
              aukc.a();
              return;
              i = 0;
              break;
              label2075:
              if (((String)localObject2).equals("1"))
              {
                i = 1;
                localObject3[1] = Integer.valueOf(i);
                break label863;
              }
              i = 0;
              continue;
              label2104:
              i = 0;
              break label881;
              label2109:
              i = 0;
              break label1377;
              label2114:
              bool = false;
              break label1417;
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
      j = bfyz.F(localQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
      if (QLog.isColorLevel()) {
        QLog.d("SPLASH_ConfigServlet", 2, "received READINJOY_LOCAL_CHANNEL_CONFIG_CMD remote version: " + i + " | localVersion: " + j);
      }
      if (i != j)
      {
        bfyz.m(localQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, i);
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
    int i = bfyz.l(((QQAppInterface)getAppRuntime()).getApp());
    if (!PtvTemplateManager.d()) {
      i = 0;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PtvTemplateManager", 2, "GetBlessSpecialPendantConfig serverVersion=" + j + "|localVersion=" + i);
    }
    if (j != i)
    {
      bfyz.i(((QQAppInterface)getAppRuntime()).getApp(), j);
      if ((paramConfig.msg_content_list == null) || (paramConfig.msg_content_list.size() <= 0)) {
        break label269;
      }
      paramIntent = (ConfigurationService.Content)paramConfig.msg_content_list.get(0);
      if (paramIntent != null)
      {
        if (paramIntent.compress.get() != 1) {
          break label255;
        }
        paramIntent = axsb.a(paramIntent.content.get().toByteArray());
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
      int i = bfyz.r(((QQAppInterface)getAppRuntime()).getApp());
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
          abvr.a(BaseApplicationImpl.sApplication, paramConfig);
          i += 1;
          continue;
          if ((paramConfig.content_list != null) && (paramConfig.content_list.size() > 0)) {
            i = 0;
          }
          while (i < paramConfig.content_list.size())
          {
            localObject = (String)paramConfig.content_list.get(i);
            QLog.d("PatchLogTag", 1, "handlePatchConfigCmd content_list index=" + i + ", content=" + (String)localObject);
            abvr.a(BaseApplicationImpl.sApplication, (String)localObject);
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
        abvj.a(localQQAppInterface);
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
      j = bfyz.w(localQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
      if (QLog.isColorLevel()) {
        QLog.d("SPLASH_ConfigServlet", 2, "received SEARCH_CONFIG_CMD remote version: " + i + " | localVersion: " + j);
      }
      if (i != j)
      {
        bfyz.i(localQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, i);
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
      j = bfyz.s(localQQAppInterface.getApp());
      if (QLog.isColorLevel()) {
        QLog.d("SPLASH_ConfigServlet", 2, "received CAMERA_COMPATIBLE_LIST_CONFIG remote version: " + i + " | localVersion: " + j);
      }
      if (i != j)
      {
        bfyz.l(localQQAppInterface.getApp(), i);
        if (QLog.isColorLevel()) {
          QLog.d("SPLASH_ConfigServlet", 2, "received CAMERA_COMPATIBLE_LIST_CONFIG save version: " + i);
        }
        bbub.a(str, true);
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
      if (i != bfyz.u(localQQAppInterface.getApp()))
      {
        bfyz.m(localQQAppInterface.getApp(), i);
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
    int j = bfyz.as(paramQQAppInterface.getApp().getBaseContext(), jdField_a_of_type_JavaLangString);
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
          arrayOfByte = axsb.a(((ConfigurationService.Content)localObject1).content.get().toByteArray());
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
      bfyz.w(paramQQAppInterface.getApp().getBaseContext(), k, jdField_a_of_type_JavaLangString);
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
            localObject = ayjo.a((ConfigurationService.Content)localObject);
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
      ayjo.a(localQQAppInterface.getApp(), paramConfig.version.get(), jdField_a_of_type_JavaLangString);
      paramConfig = (ayji)localQQAppInterface.getManager(179);
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
    int j = bfyz.B(localQQAppInterface.getApp(), localQQAppInterface.getAccount());
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
        ajul.a(localQQAppInterface, i, str);
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
    paramConfig = (ajul)localQQAppInterface.getManager(125);
    paramConfig.jdField_b_of_type_Boolean = true;
    paramConfig.c = MessageForFoldMsgGrayTips.PASSWD_REDBAG_MSG_SWITCH_DEFAULT;
    paramConfig.jdField_a_of_type_Int = MessageForFoldMsgGrayTips.PASSWD_REDBAG_MSG_DISPLAY_NUM_DEFAULT;
    paramConfig.d = MessageForFoldMsgGrayTips.PASSWD_REDBAG_MSG_SWITCH_INDEX;
    paramConfig.e = MessageForFoldMsgGrayTips.PASSWD_REDBAG_MSG_INDEX_WITH_ID;
    bfyz.a(localQQAppInterface.getApp(), localQQAppInterface.getAccount(), i, paramConfig.c, paramConfig.jdField_a_of_type_Int, paramConfig.d, paramConfig.e);
  }
  
  public static void w(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    int i = paramConfig.version.get();
    int j = bfyz.au(BaseApplication.getContext(), jdField_a_of_type_JavaLangString);
    if (QLog.isColorLevel()) {
      QLog.i("SPLASH_ConfigServlet", 2, "handleReceiptConfig: ,version: " + paramConfig.version.get() + "| localVersion: " + j);
    }
    if (i != j)
    {
      bfyz.Q(BaseApplication.getContext(), jdField_a_of_type_JavaLangString, i);
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
              bfyz.e(BaseApplication.getContext(), jdField_a_of_type_JavaLangString, "receipt_kReceiptMsgEnable", i);
            }
            if (((JSONObject)localObject).has("kReceiptMsgMaxSendTimes"))
            {
              i = ((JSONObject)localObject).getInt("kReceiptMsgMaxSendTimes");
              bfyz.e(BaseApplication.getContext(), jdField_a_of_type_JavaLangString, "receipt_kReceiptMsgSendTimes", i);
            }
          }
          catch (JSONException localJSONException)
          {
            localJSONException.printStackTrace();
          }
        }
        aewr.a(paramQQAppInterface);
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
      localObject = (amvo)((QQAppInterface)localObject).getManager(159);
      if (paramConfig.content_list.size() < 0)
      {
        str = (String)paramConfig.content_list.get(0);
        i = paramConfig.version.get();
        j = ((amvo)localObject).b();
        if (QLog.isColorLevel()) {
          QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 74,content: " + str + ",version: " + paramConfig.version.get());
        }
        if ((i != j) || (paramConfig.content_list.size() > 0)) {
          ((amvo)localObject).a(i, str);
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
    //   1: invokevirtual 47	aqlw:getAppRuntime	()Lmqq/app/AppRuntime;
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
    //   28: invokestatic 1624	bfyz:av	(Landroid/content/Context;Ljava/lang/String;)I
    //   31: istore_2
    //   32: aload 71
    //   34: invokevirtual 65	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   37: aload 71
    //   39: invokevirtual 69	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   42: invokestatic 1627	bfyz:aw	(Landroid/content/Context;Ljava/lang/String;)I
    //   45: istore_3
    //   46: invokestatic 204	com/tencent/common/config/AppSetting:a	()I
    //   49: istore 4
    //   51: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   54: ifeq +49 -> 103
    //   57: ldc 183
    //   59: iconst_2
    //   60: ldc_w 4947
    //   63: iconst_4
    //   64: anewarray 303	java/lang/Object
    //   67: dup
    //   68: iconst_0
    //   69: iload 34
    //   71: invokestatic 307	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   74: aastore
    //   75: dup
    //   76: iconst_1
    //   77: iload_2
    //   78: invokestatic 307	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   81: aastore
    //   82: dup
    //   83: iconst_2
    //   84: iload_3
    //   85: invokestatic 307	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   88: aastore
    //   89: dup
    //   90: iconst_3
    //   91: iload 4
    //   93: invokestatic 307	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   96: aastore
    //   97: invokestatic 311	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   100: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   103: iload_3
    //   104: iload 4
    //   106: if_icmpeq +20 -> 126
    //   109: aload 71
    //   111: invokevirtual 65	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   114: aload 71
    //   116: invokevirtual 69	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   119: iload 4
    //   121: invokestatic 4949	bfyz:R	(Landroid/content/Context;Ljava/lang/String;I)V
    //   124: iconst_0
    //   125: istore_2
    //   126: iload 34
    //   128: iload_2
    //   129: if_icmpeq +3257 -> 3386
    //   132: aload_1
    //   133: iload_2
    //   134: sipush 228
    //   137: invokestatic 815	aqlw:b	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;II)Ljava/lang/String;
    //   140: astore 72
    //   142: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   145: ifeq +12 -> 157
    //   148: ldc_w 4951
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
    //   377: invokestatic 921	javax/xml/parsers/DocumentBuilderFactory:newInstance	()Ljavax/xml/parsers/DocumentBuilderFactory;
    //   380: invokevirtual 925	javax/xml/parsers/DocumentBuilderFactory:newDocumentBuilder	()Ljavax/xml/parsers/DocumentBuilder;
    //   383: new 927	java/io/ByteArrayInputStream
    //   386: dup
    //   387: aload 72
    //   389: ldc_w 929
    //   392: invokevirtual 933	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   395: invokespecial 934	java/io/ByteArrayInputStream:<init>	([B)V
    //   398: invokevirtual 939	javax/xml/parsers/DocumentBuilder:parse	(Ljava/io/InputStream;)Lorg/w3c/dom/Document;
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
    //   523: ldc_w 4953
    //   526: invokeinterface 947 2 0
    //   531: iconst_0
    //   532: invokeinterface 958 2 0
    //   537: invokeinterface 964 1 0
    //   542: invokeinterface 967 1 0
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
    //   669: ldc_w 4955
    //   672: invokeinterface 947 2 0
    //   677: iconst_0
    //   678: invokeinterface 958 2 0
    //   683: invokeinterface 964 1 0
    //   688: invokeinterface 967 1 0
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
    //   815: ldc_w 4957
    //   818: invokeinterface 947 2 0
    //   823: iconst_0
    //   824: invokeinterface 958 2 0
    //   829: invokeinterface 964 1 0
    //   834: invokeinterface 967 1 0
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
    //   961: ldc_w 4959
    //   964: invokeinterface 947 2 0
    //   969: iconst_0
    //   970: invokeinterface 958 2 0
    //   975: invokeinterface 964 1 0
    //   980: invokeinterface 967 1 0
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
    //   1102: ldc_w 4961
    //   1105: invokeinterface 947 2 0
    //   1110: iconst_0
    //   1111: invokeinterface 958 2 0
    //   1116: invokeinterface 964 1 0
    //   1121: invokeinterface 967 1 0
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
    //   1244: ldc_w 4963
    //   1247: invokeinterface 947 2 0
    //   1252: iconst_0
    //   1253: invokeinterface 958 2 0
    //   1258: invokeinterface 964 1 0
    //   1263: invokeinterface 967 1 0
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
    //   1398: ldc_w 4965
    //   1401: invokeinterface 947 2 0
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
    //   1549: invokeinterface 952 1 0
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
    //   1686: invokeinterface 958 2 0
    //   1691: invokeinterface 964 1 0
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
    //   1835: invokeinterface 967 1 0
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
    //   2863: invokestatic 4413	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   2866: invokevirtual 1842	java/lang/Integer:intValue	()I
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
    //   2992: invokestatic 4413	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   2995: invokevirtual 1842	java/lang/Integer:intValue	()I
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
    //   3116: invokestatic 4413	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   3119: invokevirtual 1842	java/lang/Integer:intValue	()I
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
    //   3292: invokestatic 4970	ahcd:a	()Lahcd;
    //   3295: aload 71
    //   3297: invokevirtual 4973	ahcd:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)Ljava/lang/String;
    //   3300: astore 39
    //   3302: invokestatic 4970	ahcd:a	()Lahcd;
    //   3305: aload 71
    //   3307: invokevirtual 4975	ahcd:c	(Lcom/tencent/mobileqq/app/QQAppInterface;)Ljava/lang/String;
    //   3310: astore 40
    //   3312: iconst_0
    //   3313: istore 35
    //   3315: aload 39
    //   3317: aload_1
    //   3318: invokevirtual 622	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3321: ifeq +13 -> 3334
    //   3324: aload 40
    //   3326: aload 38
    //   3328: invokevirtual 622	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3331: ifne +6 -> 3337
    //   3334: iconst_1
    //   3335: istore 35
    //   3337: invokestatic 4970	ahcd:a	()Lahcd;
    //   3340: iload_3
    //   3341: iload 4
    //   3343: aload_1
    //   3344: aload 36
    //   3346: aload 38
    //   3348: aload 37
    //   3350: iload 35
    //   3352: iload 5
    //   3354: invokevirtual 4978	ahcd:a	(IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZI)V
    //   3357: aload 71
    //   3359: invokevirtual 65	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   3362: aload 71
    //   3364: invokevirtual 412	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   3367: iload 34
    //   3369: iload_3
    //   3370: iload 4
    //   3372: aload_1
    //   3373: aload 38
    //   3375: aload 36
    //   3377: aload 37
    //   3379: iload 35
    //   3381: iload 5
    //   3383: invokestatic 4981	bfyz:a	(Landroid/content/Context;Ljava/lang/String;IIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZI)V
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
    //   3411: ldc_w 4951
    //   3414: iconst_2
    //   3415: aload 39
    //   3417: iconst_0
    //   3418: anewarray 303	java/lang/Object
    //   3421: invokestatic 377	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
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
    //   3460: ldc_w 4951
    //   3463: iconst_2
    //   3464: aload_1
    //   3465: iconst_0
    //   3466: anewarray 303	java/lang/Object
    //   3469: invokestatic 377	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
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
    //   3509: ldc_w 4951
    //   3512: iconst_2
    //   3513: aload_1
    //   3514: iconst_0
    //   3515: anewarray 303	java/lang/Object
    //   3518: invokestatic 377	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
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
    //   3558: ldc_w 4951
    //   3561: iconst_2
    //   3562: aload_1
    //   3563: iconst_0
    //   3564: anewarray 303	java/lang/Object
    //   3567: invokestatic 377	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
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
    //   3607: ldc_w 4951
    //   3610: iconst_2
    //   3611: aload_1
    //   3612: iconst_0
    //   3613: anewarray 303	java/lang/Object
    //   3616: invokestatic 377	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
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
    //   3656: ldc_w 4951
    //   3659: iconst_2
    //   3660: aload_1
    //   3661: iconst_0
    //   3662: anewarray 303	java/lang/Object
    //   3665: invokestatic 377	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
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
    //   3700: ldc 183
    //   3702: iconst_2
    //   3703: new 85	java/lang/StringBuilder
    //   3706: dup
    //   3707: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   3710: ldc_w 4983
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
    //   0	3805	0	this	aqlw
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
    int i = bfyz.ax(localQQAppInterface.getApp(), localQQAppInterface.getAccount());
    int j = bfyz.ay(localQQAppInterface.getApp(), localQQAppInterface.getAccount());
    int k = AppSetting.a();
    if (QLog.isColorLevel()) {
      QLog.d("SPLASH_ConfigServlet", 2, String.format("received TimUserSpecial remote version: %d, localVersion: %d ,originalAppId:%d, currentAppId:%d", new Object[] { Integer.valueOf(n), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) }));
    }
    if (j != k)
    {
      bfyz.S(localQQAppInterface.getApp(), localQQAppInterface.getAccount(), k);
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
          paramConfig = ahov.a().a(localQQAppInterface);
          localObject = ahov.a().b(localQQAppInterface);
          bool = false;
          if ((!paramConfig.equals(localConfig)) || (!((String)localObject).equals(str))) {
            break label490;
          }
          ahov.a().a(0, m, localConfig, "", str, "", bool, 0);
          bfyz.b(localQQAppInterface.getApp(), localQQAppInterface.getCurrentAccountUin(), n, 0, m, localConfig, str, "", "", bool, 0);
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
    int i = bfyz.C(localQQAppInterface.getApp(), localQQAppInterface.getAccount());
    int j = bfyz.y(localQQAppInterface.getApp(), localQQAppInterface.getAccount());
    int k = AppSetting.a();
    if (QLog.isColorLevel()) {
      QLog.d("pokeMsg", 2, String.format("handlePokeMsgConfig.received PokeMsgConfig remote version: %d, localVersion: %d ,originalAppId:%d, currentAppId:%d", new Object[] { Integer.valueOf(i58), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) }));
    }
    if (j != k)
    {
      bfyz.j(localQQAppInterface.getApp(), localQQAppInterface.getAccount(), k);
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
          break label7091;
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
            localObject5 = agkg.a(localQQAppInterface, 5);
            localObject9 = agkg.a(localQQAppInterface, 6);
            if ((localObject4 == null) || (!((String)localObject4).equals(localObject5)) || (localObject3 == null) || (!((String)localObject3).equals(localObject9)))
            {
              agkg.jdField_b_of_type_Boolean = false;
              agkg.c = false;
              bfyz.a(false);
              agkg.a(localQQAppInterface, (String)localObject4, (String)localObject3, agkg.d);
            }
            bfyz.a(localQQAppInterface.getApp(), localQQAppInterface.getAccount(), k, (String)localObject4, (String)localObject3, (String)localObject1, (String)localObject7, j, m, n, i1);
            agkg.a(localQQAppInterface, k, (String)localObject4, (String)localObject3, (String)localObject1, (String)localObject7, j, n, i1);
            agkg.b(m);
          }
          if ((i10 != 0) && (i23 != 0) && (i8 != 0) && (i7 != 0) && (i6 != 0))
          {
            localQQAppInterface.getApp().getSharedPreferences(localQQAppInterface.getCurrentAccountUin(), 0).edit().putBoolean("chat_tool_poke_clicked", false).commit();
            agkg.b(localQQAppInterface, false);
            agkg.a(localQQAppInterface, false);
            agkg.a(i19, i25, i14, i13);
            bfyz.a(localQQAppInterface.getApp(), localQQAppInterface.getAccount(), i58, true, i19, i25, i14, i13);
            agkg.a((String)localObject2);
            bfyz.b(localQQAppInterface.getApp(), localQQAppInterface.getAccount(), i58, (String)localObject2);
            agkg.a(i3);
            bfyz.a(localQQAppInterface.getApp(), localQQAppInterface.getAccount(), i58, i3);
            agkg.c(i2);
            bfyz.b(localQQAppInterface.getApp(), localQQAppInterface.getAccount(), i58, i2);
            agkg.a(i35, i4);
            bfyz.a(localQQAppInterface.getApp(), localQQAppInterface.getAccount(), i58, i35, i4);
          }
          if ((i5 != 0) && (i36 != 0) && (i36 != 0))
          {
            localObject1 = PreferenceManager.getDefaultSharedPreferences(localQQAppInterface.getApp()).getString(localQQAppInterface.getAccount() + "_" + "aio_poke_res_url", "");
            bfyz.a(localQQAppInterface.getApp(), localQQAppInterface.getAccount(), i58, l2, (String)localObject13, (String)localObject17);
            if ((localObject13 != null) && (!((String)localObject13).equals(localObject1))) {
              ((PokeBigResHandler)localQQAppInterface.getBusinessHandler(117)).a(true);
            }
          }
          agkg.c(i2);
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
                  break label7520;
                }
                i6 = i7;
                if (i7 == 1) {
                  break label7520;
                }
                i6 = i7;
                if (i7 == 2) {
                  break label7520;
                }
                i6 = i7;
                if (i7 == 3) {
                  break label7520;
                }
                if (i7 != 4) {
                  break label7560;
                }
                i6 = i7;
                break label7520;
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
            break label7530;
          }
          i7 = i8;
          if (i8 == 1) {
            break label7530;
          }
          if (i8 != 2) {
            break label7566;
          }
          i7 = i8;
          break label7530;
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
            break label7540;
          }
        }
        else
        {
          label5286:
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
              break label6783;
            }
            break label7550;
          }
          label5530:
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
          localObject9 = agkg.a(localObject19[1]);
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
          i16 = agkg.c(localObject19[1]);
        }
        try
        {
          i17 = agkg.b(localObject19[1]);
        }
        catch (Exception localException6)
        {
          label6783:
          localObject12 = localObject8;
          label7091:
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
          i19 = agkg.a(localObject19[1]);
          if ((i16 == 1) || (i16 == 2)) {
            break label7513;
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
          i15 = agkg.d(localObject19[1]);
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
            break label7506;
          }
          k = 0;
          if (i19 > 0) {
            break label7499;
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
      i8 = agkg.h;
      break label7540;
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
      i9 = agkg.i;
      break label7550;
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
      label7499:
      label7506:
      label7513:
      label7520:
      i10 = i6;
      i6 = 1;
    }
    for (;;)
    {
      label7530:
      i11 = i7;
      i7 = 1;
      break;
      label7540:
      i12 = i8;
      i8 = 1;
      break label5286;
      label7550:
      i13 = i9;
      i9 = 1;
      break label5530;
      label7560:
      i6 = 0;
      break label7520;
      label7566:
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
        if (bfcx.a().a(paramConfig)) {
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
      ((aeyb)paramQQAppInterface.getManager(218)).d();
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
    paramQQAppInterface = (aeyb)paramQQAppInterface.getManager(218);
    paramQQAppInterface.a(paramConfig);
    paramQQAppInterface.c();
  }
  
  public void D(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    int i = paramConfig.version.get();
    if (i != bbvz.a(paramQQAppInterface.getApp()))
    {
      paramConfig = a(paramConfig);
      if ((paramConfig != null) && (paramConfig.size() > 0)) {
        bbvz.a((String)paramConfig.get(0), i, paramQQAppInterface.getApp());
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
      i = bfyz.a(paramQQAppInterface.getApp(), "sport_config", jdField_a_of_type_JavaLangString);
      j = paramConfig.version.get();
    } while (i == j);
    ((bgmp)paramQQAppInterface.getManager(260)).a(paramConfig);
    bfyz.a(paramQQAppInterface.getApp(), "sport_config", jdField_a_of_type_JavaLangString, j);
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
        str = a(paramConfig, bfyz.a(paramQQAppInterface.getApp(), "troop_gift_anim_limit", "0"), 281);
      } while (TextUtils.isEmpty(str));
      if (QLog.isColorLevel()) {
        QLog.d("SPLASH_ConfigServlet", 2, "handleTroopGiftLimitConfig content: " + str);
      }
      int i = paramConfig.version.get();
      bfyz.a(paramQQAppInterface.getApp(), "troop_gift_anim_limit", "0", i);
      try
      {
        i = new JSONObject(str).getInt("limitGiftAnimCount");
        beyh.jdField_b_of_type_Int = i;
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
      aafi.c();
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
      i = bfyz.a(paramQQAppInterface.getApp(), "task_entry_config_version", jdField_a_of_type_JavaLangString);
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
          bfyz.a(paramQQAppInterface.getApp(), "task_entry_config_version", jdField_a_of_type_JavaLangString, j);
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
    if (i != bnxr.a().a(paramQQAppInterface.getApp()))
    {
      paramConfig = a(paramConfig);
      if ((paramConfig != null) && (paramConfig.size() > 0))
      {
        paramConfig = (String)paramConfig.get(paramConfig.size() - 1);
        bnxr.a().a(paramConfig, i, paramQQAppInterface.getApp());
      }
    }
  }
  
  public void L(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    int i = paramConfig.version.get();
    if (i != boaz.a().a(paramQQAppInterface.getApp()))
    {
      paramConfig = a(paramConfig);
      if ((paramConfig != null) && (paramConfig.size() > 0))
      {
        paramConfig = (String)paramConfig.get(0);
        boaz.a().a(paramConfig, i, paramQQAppInterface.getApp());
      }
    }
  }
  
  public void M(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    int i = paramConfig.version.get();
    int j = bfyz.a(paramQQAppInterface.getApp(), "buluo_enter_config_version", jdField_a_of_type_JavaLangString);
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
                paramConfig = paramConfig + bfuc.encodeToString(((String)localObject2).getBytes(), 0);
                bfyz.c(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin(), paramConfig);
                if (QLog.isColorLevel()) {
                  QLog.e("SPLASH_ConfigServlet", 2, new Object[] { "handleBuluoEnterConfig. buluoEntryUrl: ", paramConfig });
                }
              }
            }
          }
          for (;;)
          {
            bfyz.a(paramQQAppInterface.getApp(), "buluo_enter_config_version", jdField_a_of_type_JavaLangString, i);
            return;
            if (paramConfig.has("tribe_summary_url"))
            {
              paramConfig = paramConfig.optJSONObject("tribe_summary_url");
              if (paramConfig.has("android"))
              {
                paramConfig = paramConfig.optString("android");
                bfyz.d(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin(), paramConfig);
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
    anyd localanyd = (anyd)((QQAppInterface)getAppRuntime()).getManager(220);
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
      arrayOfByte = axsb.a(paramIntent.content.get().toByteArray());
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
          if (localanyd.b(paramIntent)) {
            localanyd.b(i);
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
        if (localanyd != null) {
          localanyd.c();
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
                paramConfig = axsb.a(paramIntent.content.get().toByteArray());
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
                  paramIntent = (OlympicManager)((QQAppInterface)getAppRuntime()).getManager(167);
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
        paramIntent = (OlympicManager)((QQAppInterface)getAppRuntime()).getManager(167);
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
      paramConfig = (OlympicManager)paramIntent.getManager(167);
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
      arrayOfByte = axsb.a(paramIntent.content.get().toByteArray());
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
        aodk.a(paramQQAppInterface, paramIntent, paramConfig.version.get());
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
      aodk.b(paramQQAppInterface);
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
          byte[] arrayOfByte = axsb.a(((ConfigurationService.Content)localObject1).content.get().toByteArray());
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
            if ((i == bfyz.a(paramQQAppInterface.getApp(), "nearby_glamour_level_config_version", jdField_a_of_type_JavaLangString)) || (TextUtils.isEmpty((CharSequence)localObject1))) {
              continue;
            }
            awig.a((String)localObject1);
            awig.b((String)localObject1);
            bfyz.h(paramQQAppInterface.getApp(), (String)localObject1);
            bfyz.a(paramQQAppInterface.getApp(), "nearby_glamour_level_config_version", jdField_a_of_type_JavaLangString, i);
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
  
  protected void a(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig, String paramString, aqlz paramaqlz)
  {
    int j = paramConfig.version.get();
    int i = paramaqlz.a();
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
          arrayOfByte = axsb.a(paramQQAppInterface.content.get().toByteArray());
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
      paramaqlz.a(j);
      paramaqlz.a(localArrayList);
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
            if ((j != bfyz.M(localQQAppInterface.getApp(), localQQAppInterface.getCurrentAccountUin())) || (paramConfig.content_list.size() > 0))
            {
              str = str.split("=")[1];
              if (!TextUtils.isEmpty(str)) {
                bkwm.c(str, localQQAppInterface);
              }
              bfyz.p(localQQAppInterface.getApp(), j, localQQAppInterface.getCurrentAccountUin());
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
          apju.a(BaseApplicationImpl.getContext(), k);
          if (QLog.isColorLevel()) {
            QLog.d("Q.camera.configServlet", 2, "[handleRespQCameraPhoneConfig] save version: " + k + " and check config version: " + apju.a(BaseApplicationImpl.getContext()));
          }
          if ((paramConfig.msg_content_list == null) || (paramConfig.msg_content_list.size() <= 0)) {
            break label560;
          }
          paramIntent = (ConfigurationService.Content)paramConfig.msg_content_list.get(0);
          i = paramIntent.task_id.get();
          if (paramIntent.compress.get() != 1) {
            break label506;
          }
          paramIntent = apju.a(paramIntent.content.get().toByteArray());
          if (paramIntent == null)
          {
            paramInt = 4;
            apju.a(BaseApplicationImpl.getContext(), true);
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
            apju.a(BaseApplicationImpl.getContext(), paramIntent, k);
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
          apju.a(BaseApplicationImpl.getContext(), paramIntent, k);
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
      QLog.w("Q.camera.configServlet", 1, "[handleRespQCameraPhoneConfig] no data, current disableCameraSDK=" + apju.a(BaseApplicationImpl.getContext()));
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
        barw localbarw = (barw)paramQQAppInterface.getManager(222);
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
                byte[] arrayOfByte = axsb.a(((ConfigurationService.Content)localObject1).content.get().toByteArray());
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
                  if ((j == bfyz.a(paramQQAppInterface.getApp(), "search_function_config_version", jdField_a_of_type_JavaLangString)) || (TextUtils.isEmpty((CharSequence)localObject1))) {
                    continue;
                  }
                  localbarw.b(new JSONObject((String)localObject1).optString("kFTSFunctionListUrlKey"));
                  bfyz.a(paramQQAppInterface.getApp(), "search_function_config_version", jdField_a_of_type_JavaLangString, j);
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
            if ((j != bfyz.L(localQQAppInterface.getApp(), localQQAppInterface.getCurrentUin())) || (paramConfig.content_list.size() > 0))
            {
              if (bkwm.a(localQQAppInterface, str))
              {
                if (QLog.isColorLevel()) {
                  QLog.d("SPLASH_ConfigServlet", 2, "received 72 ark config");
                }
                bfyz.s(getAppRuntime().getApplication(), localQQAppInterface.getCurrentUin(), j);
                break label304;
              }
              if ((!uex.b((QQAppInterface)getAppRuntime(), str)) || (!QLog.isColorLevel())) {
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
            if ((j != bfyz.w(localQQAppInterface.getApp())) || (paramConfig.content_list.size() > 0))
            {
              Object localObject2 = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new ByteArrayInputStream(((String)localObject1).getBytes("utf-8")));
              localObject1 = (Element)((Document)localObject2).getElementsByTagName("kandian_setting").item(0);
              localObject2 = (Element)((Document)localObject2).getElementsByTagName("url").item(0);
              localObject1 = ((Element)localObject1).getFirstChild().getNodeValue();
              localObject2 = ((Element)localObject2).getFirstChild().getNodeValue();
              if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!TextUtils.isEmpty((CharSequence)localObject2))) {
                bfyz.b(localQQAppInterface.getApp(), (String)localObject2, "1".equals(localObject1));
              }
              bfyz.n(localQQAppInterface.getApp(), j);
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
            byte[] arrayOfByte = axsb.a(((ConfigurationService.Content)localObject1).content.get().toByteArray());
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
              awgw.a(paramQQAppInterface, (String)localObject1, paramConfig.version.get());
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
      int i = bfyz.a(paramQQAppInterface.getApp(), "shop_tab", jdField_a_of_type_JavaLangString);
      int j = paramConfig.version.get();
      if ((i != j) && (paramConfig.content_list != null) && (paramConfig.content_list.size() > 0)) {
        try
        {
          paramConfig = new JSONObject((String)paramConfig.content_list.get(0));
          boolean bool = paramConfig.getBoolean("android");
          bfyz.a(paramQQAppInterface.getApp(), "shop_tab", jdField_a_of_type_JavaLangString, j);
          paramQQAppInterface = (ofx)paramQQAppInterface.getManager(88);
          paramQQAppInterface.b(bool);
          paramQQAppInterface.c = paramConfig.optBoolean("preload_web_process", false);
          paramQQAppInterface.a = paramConfig.optLong("stay_time", 5000L);
          paramQQAppInterface.d = paramConfig.optInt("day_limit", 3);
          ofx.a().edit().putBoolean("preload_web", paramQQAppInterface.c).putLong("stayTime", paramQQAppInterface.a).putInt("dayLimit", paramQQAppInterface.d).commit();
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
    int i = bfyz.Y(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentUin());
    int j = paramConfig.version.get();
    if (i == j)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SPLASH_ConfigServlet", 2, "handleQuickShotShareToStoryConfig version code not changed .");
      }
      return;
    }
    bfyz.x(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentUin(), j);
    if ((paramConfig.msg_content_list == null) || (paramConfig.msg_content_list.size() < 1) || (paramConfig.msg_content_list.get(0) == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SPLASH_ConfigServlet", 2, "handleQuickShotShareToStoryConfig data is null!!!");
      }
      bfyz.h(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentUin(), null);
      return;
    }
    paramConfig = (ConfigurationService.Content)paramConfig.msg_content_list.get(0);
    byte[] arrayOfByte;
    if (paramConfig.compress.get() == 1)
    {
      arrayOfByte = axsb.a(paramConfig.content.get().toByteArray());
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
        bfyz.h(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentUin(), paramConfig);
        ((vla)paramQQAppInterface.getManager(181)).a(paramConfig);
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
      bfyz.h(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentUin(), null);
    }
  }
  
  void g(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    int i = bfyz.ad(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
    int j = paramConfig.version.get();
    if ((i != j) && (paramConfig.msg_content_list != null) && (paramConfig.msg_content_list.size() > 0))
    {
      paramConfig = (ConfigurationService.Content)paramConfig.msg_content_list.get(0);
      if (paramConfig != null)
      {
        if (paramConfig.compress.get() != 1) {
          break label219;
        }
        paramConfig = axsb.a(paramConfig.content.get().toByteArray());
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
          bfyz.m(paramQQAppInterface.getApp(), "wifiAutoPreDown", "" + bool1);
          bfyz.m(paramQQAppInterface.getApp(), "noSafeDown", "" + bool2);
          bfyz.C(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, j);
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
    int i = bfyz.aa(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
    int j = paramConfig.version.get();
    if ((i != j) && (paramConfig.msg_content_list != null) && (paramConfig.msg_content_list.size() > 0))
    {
      paramConfig = (ConfigurationService.Content)paramConfig.msg_content_list.get(0);
      if (paramConfig != null)
      {
        if (paramConfig.compress.get() != 1) {
          break label206;
        }
        paramConfig = axsb.a(paramConfig.content.get().toByteArray());
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
          bfyz.k(paramQQAppInterface.getApp(), "url", paramConfig);
          bfyz.k(paramQQAppInterface.getApp(), "thxWord", (String)localObject);
          bfyz.k(paramQQAppInterface.getApp(), "wantWord", str);
          bfyz.B(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, j);
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
        i = bfyz.ae(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
        j = paramConfig.version.get();
      } while ((i == j) || (paramConfig.msg_content_list == null) || (paramConfig.msg_content_list.size() <= 0));
      paramConfig = (ConfigurationService.Content)paramConfig.msg_content_list.get(0);
    } while (paramConfig == null);
    if (paramConfig.compress.get() == 1)
    {
      paramConfig = axsb.a(paramConfig.content.get().toByteArray());
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
          bfyz.D(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, j);
          bfyz.e(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, bool);
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
          int k = uex.c(paramQQAppInterface);
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
                  localObject = axsb.a(((ConfigurationService.Content)localObject).content.get().toByteArray());
                  if (localObject == null) {
                    break label310;
                  }
                  try
                  {
                    localObject = new String((byte[])localObject, "UTF-8");
                    if (QLog.isColorLevel()) {
                      QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 184, version:" + paramConfig.version.get() + ", content:" + (String)localObject);
                    }
                    uex.a(paramQQAppInterface, (String)localObject, j);
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
    //   1: getfield 2592	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:type	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   4: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   7: sipush 191
    //   10: if_icmpeq +4 -> 14
    //   13: return
    //   14: aload_1
    //   15: invokevirtual 65	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   18: getstatic 15	aqlw:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   21: invokestatic 1962	bfyz:ar	(Landroid/content/Context;Ljava/lang/String;)I
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
    //   46: ldc 183
    //   48: iconst_2
    //   49: new 85	java/lang/StringBuilder
    //   52: dup
    //   53: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   56: ldc_w 5649
    //   59: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: iload 4
    //   64: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   67: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   70: invokestatic 200	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   73: aload_2
    //   74: getfield 223	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   77: ifnull -64 -> 13
    //   80: aload_2
    //   81: getfield 223	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   84: invokevirtual 226	com/tencent/mobileqq/pb/PBRepeatMessageField:size	()I
    //   87: ifle -74 -> 13
    //   90: aload_2
    //   91: getfield 223	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   94: iconst_0
    //   95: invokevirtual 319	com/tencent/mobileqq/pb/PBRepeatMessageField:get	(I)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   98: checkcast 246	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content
    //   101: astore_2
    //   102: aload_2
    //   103: ifnull -90 -> 13
    //   106: aload_2
    //   107: getfield 250	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content:compress	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   110: invokevirtual 253	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   113: iconst_1
    //   114: if_icmpne +349 -> 463
    //   117: aload_2
    //   118: getfield 257	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content:content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   121: invokevirtual 262	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   124: invokevirtual 268	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   127: invokestatic 322	axsb:a	([B)[B
    //   130: astore_2
    //   131: aload_2
    //   132: ifnull +442 -> 574
    //   135: new 118	java/lang/String
    //   138: dup
    //   139: aload_2
    //   140: ldc_w 324
    //   143: invokespecial 327	java/lang/String:<init>	([BLjava/lang/String;)V
    //   146: astore_2
    //   147: aload_2
    //   148: ifnull -135 -> 13
    //   151: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   154: ifeq +29 -> 183
    //   157: ldc 183
    //   159: iconst_2
    //   160: new 85	java/lang/StringBuilder
    //   163: dup
    //   164: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   167: ldc_w 5651
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
    //   200: invokevirtual 5652	org/json/JSONObject:length	()I
    //   203: ifle -190 -> 13
    //   206: new 1132	java/util/ArrayList
    //   209: dup
    //   210: invokespecial 1133	java/util/ArrayList:<init>	()V
    //   213: astore_2
    //   214: aload 5
    //   216: invokevirtual 5655	org/json/JSONObject:keys	()Ljava/util/Iterator;
    //   219: astore 6
    //   221: aload 6
    //   223: invokeinterface 240 1 0
    //   228: ifeq +310 -> 538
    //   231: aload 6
    //   233: invokeinterface 244 1 0
    //   238: checkcast 118	java/lang/String
    //   241: astore 7
    //   243: aload 5
    //   245: aload 7
    //   247: invokevirtual 734	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   250: astore 8
    //   252: new 5183	com/tencent/mobileqq/data/AppGuideTipsConfig
    //   255: dup
    //   256: invokespecial 5184	com/tencent/mobileqq/data/AppGuideTipsConfig:<init>	()V
    //   259: astore 9
    //   261: aload 9
    //   263: aload 7
    //   265: putfield 5658	com/tencent/mobileqq/data/AppGuideTipsConfig:tipsType	Ljava/lang/String;
    //   268: aload 9
    //   270: aload 8
    //   272: ldc_w 5192
    //   275: invokevirtual 422	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   278: putfield 5195	com/tencent/mobileqq/data/AppGuideTipsConfig:switchKey	Ljava/lang/String;
    //   281: aload 9
    //   283: aload 8
    //   285: ldc_w 5197
    //   288: invokevirtual 422	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   291: invokestatic 4413	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   294: invokevirtual 1842	java/lang/Integer:intValue	()I
    //   297: putfield 5200	com/tencent/mobileqq/data/AppGuideTipsConfig:maxCount	I
    //   300: aload 9
    //   302: aload 8
    //   304: ldc_w 5202
    //   307: invokevirtual 422	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   310: invokestatic 5122	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   313: invokevirtual 5125	java/lang/Long:longValue	()J
    //   316: putfield 5204	com/tencent/mobileqq/data/AppGuideTipsConfig:duration	J
    //   319: aload 9
    //   321: aload 8
    //   323: ldc_w 781
    //   326: invokevirtual 422	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   329: putfield 5209	com/tencent/mobileqq/data/AppGuideTipsConfig:tipsUrl	Ljava/lang/String;
    //   332: aload 9
    //   334: aload 8
    //   336: ldc_w 5660
    //   339: invokevirtual 422	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   342: putfield 5662	com/tencent/mobileqq/data/AppGuideTipsConfig:opkey	Ljava/lang/String;
    //   345: aload 9
    //   347: aload 8
    //   349: ldc_w 5214
    //   352: invokevirtual 422	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   355: putfield 5217	com/tencent/mobileqq/data/AppGuideTipsConfig:msgTypeStr	Ljava/lang/String;
    //   358: ldc_w 624
    //   361: aload 7
    //   363: invokevirtual 622	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   366: ifeq +143 -> 509
    //   369: aload 8
    //   371: ldc_w 1033
    //   374: invokevirtual 406	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   377: ifeq +100 -> 477
    //   380: aload 9
    //   382: aload 8
    //   384: ldc_w 1033
    //   387: invokevirtual 422	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   390: putfield 5212	com/tencent/mobileqq/data/AppGuideTipsConfig:tipsMsg	Ljava/lang/String;
    //   393: aload 8
    //   395: ldc_w 736
    //   398: invokevirtual 406	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   401: ifeq +92 -> 493
    //   404: aload 9
    //   406: aload 8
    //   408: ldc_w 736
    //   411: invokevirtual 422	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   414: putfield 5665	com/tencent/mobileqq/data/AppGuideTipsConfig:tipsHighLight	Ljava/lang/String;
    //   417: aload_2
    //   418: aload 9
    //   420: invokeinterface 1142 2 0
    //   425: pop
    //   426: goto -205 -> 221
    //   429: astore_1
    //   430: ldc 183
    //   432: iconst_1
    //   433: new 85	java/lang/StringBuilder
    //   436: dup
    //   437: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   440: ldc_w 5667
    //   443: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   446: aload_1
    //   447: invokevirtual 800	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   450: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   453: invokestatic 644	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   456: return
    //   457: astore_2
    //   458: aconst_null
    //   459: astore_2
    //   460: goto -313 -> 147
    //   463: aload_2
    //   464: getfield 257	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content:content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   467: invokevirtual 262	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   470: invokevirtual 282	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   473: astore_2
    //   474: goto -327 -> 147
    //   477: aload 9
    //   479: aload 8
    //   481: ldc_w 5669
    //   484: invokevirtual 422	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   487: putfield 5212	com/tencent/mobileqq/data/AppGuideTipsConfig:tipsMsg	Ljava/lang/String;
    //   490: goto -97 -> 393
    //   493: aload 9
    //   495: aload 8
    //   497: ldc_w 5671
    //   500: invokevirtual 422	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   503: putfield 5665	com/tencent/mobileqq/data/AppGuideTipsConfig:tipsHighLight	Ljava/lang/String;
    //   506: goto -89 -> 417
    //   509: aload 9
    //   511: aload 8
    //   513: ldc_w 5669
    //   516: invokevirtual 422	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   519: putfield 5212	com/tencent/mobileqq/data/AppGuideTipsConfig:tipsMsg	Ljava/lang/String;
    //   522: aload 9
    //   524: aload 8
    //   526: ldc_w 5671
    //   529: invokevirtual 422	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   532: putfield 5665	com/tencent/mobileqq/data/AppGuideTipsConfig:tipsHighLight	Ljava/lang/String;
    //   535: goto -118 -> 417
    //   538: aload_1
    //   539: sipush 218
    //   542: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   545: checkcast 3340	aeyb
    //   548: astore 5
    //   550: aload 5
    //   552: aload_2
    //   553: invokevirtual 5672	aeyb:a	(Ljava/util/List;)V
    //   556: aload 5
    //   558: invokevirtual 3341	aeyb:a	()V
    //   561: aload_1
    //   562: invokevirtual 65	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   565: getstatic 15	aqlw:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   568: iload 4
    //   570: invokestatic 5674	bfyz:O	(Landroid/content/Context;Ljava/lang/String;I)V
    //   573: return
    //   574: aconst_null
    //   575: astore_2
    //   576: goto -429 -> 147
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	579	0	this	aqlw
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
    int i = bfyz.ac(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
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
        paramConfig = axsb.a(paramConfig.content.get().toByteArray());
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
        bfyz.A(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, j);
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
          i = bfyz.aj(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
          j = paramConfig.version.get();
          if (QLog.isColorLevel()) {
            QLog.d("DoutuSPLASH_ConfigServlet", 2, "handleDoutuConfig reqVersion = " + i + ", version=" + j);
          }
        } while (i == j);
        bfyz.J(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, j);
      } while ((paramConfig.msg_content_list == null) || (paramConfig.msg_content_list.size() <= 0));
      paramConfig = (ConfigurationService.Content)paramConfig.msg_content_list.get(0);
    } while (paramConfig == null);
    if (paramConfig.compress.get() == 1)
    {
      paramConfig = axsb.a(paramConfig.content.get().toByteArray());
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
            bfyz.g((Context)localObject, str2, bool1);
            bfyz.b(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, l1);
            bfyz.N(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, j);
            localObject = paramQQAppInterface.getApp();
            str2 = jdField_a_of_type_JavaLangString;
            if (k != 1) {
              break label1224;
            }
            bool1 = true;
            bfyz.i((Context)localObject, str2, bool1);
            localObject = paramQQAppInterface.getApp();
            str2 = jdField_a_of_type_JavaLangString;
            if (m != 1) {
              break label1230;
            }
            bool1 = true;
            bfyz.j((Context)localObject, str2, bool1);
            if (paramConfig != null) {
              bfyz.o(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, paramConfig);
            }
            if (str1 != null) {
              bfyz.p(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, str1);
            }
            bfyz.c(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, l2);
            bfyz.d(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, l3);
            bfyz.L(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, n);
            paramQQAppInterface = (aqwg)getAppRuntime().getManager(214);
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
        bfyz.k(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
        bfyz.r(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
        bfyz.l(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
        bfyz.m(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
        bfyz.o(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
        bfyz.p(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
        bfyz.t(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
        bfyz.u(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
        bfyz.n(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
        bfyz.m(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
        bfyz.s(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
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
          i = bfyz.t(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
          j = paramConfig.version.get();
          if (QLog.isColorLevel()) {
            QLog.d("GreenVideoSPLASH_ConfigServlet", 2, "handleGreenVideoConfig reqVersion = " + i + ", version=" + j);
          }
        } while (i == j);
        bfyz.f(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, j);
      } while ((paramConfig.msg_content_list == null) || (paramConfig.msg_content_list.size() <= 0));
      paramConfig = (ConfigurationService.Content)paramConfig.msg_content_list.get(0);
    } while (paramConfig == null);
    if (paramConfig.compress.get() == 1)
    {
      paramConfig = axsb.a(paramConfig.content.get().toByteArray());
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
        bfyz.e(paramQQAppInterface.getApp(), paramConfig);
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
      bfyz.a(paramQQAppInterface.getApp());
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
    //   1: getfield 2592	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:type	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   4: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   7: sipush 272
    //   10: if_icmpeq +4 -> 14
    //   13: return
    //   14: aload_1
    //   15: invokevirtual 65	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   18: getstatic 15	aqlw:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   21: invokestatic 1930	bfyz:v	(Landroid/content/Context;Ljava/lang/String;)I
    //   24: istore_3
    //   25: aload_2
    //   26: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   29: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   32: istore 4
    //   34: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   37: ifeq +40 -> 77
    //   40: ldc 183
    //   42: iconst_2
    //   43: new 85	java/lang/StringBuilder
    //   46: dup
    //   47: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   50: ldc_w 5804
    //   53: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: iload_3
    //   57: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   60: ldc_w 5708
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
    //   87: getstatic 15	aqlw:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   90: iload 4
    //   92: invokestatic 1919	bfyz:h	(Landroid/content/Context;Ljava/lang/String;I)V
    //   95: aload_2
    //   96: getfield 223	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   99: ifnull -86 -> 13
    //   102: aload_2
    //   103: getfield 223	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   106: invokevirtual 226	com/tencent/mobileqq/pb/PBRepeatMessageField:size	()I
    //   109: ifle -96 -> 13
    //   112: aload_2
    //   113: getfield 223	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   116: iconst_0
    //   117: invokevirtual 319	com/tencent/mobileqq/pb/PBRepeatMessageField:get	(I)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   120: checkcast 246	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content
    //   123: astore_2
    //   124: aload_2
    //   125: ifnull -112 -> 13
    //   128: aload_2
    //   129: getfield 250	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content:compress	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   132: invokevirtual 253	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   135: iconst_1
    //   136: if_icmpne +716 -> 852
    //   139: aload_2
    //   140: getfield 257	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content:content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   143: invokevirtual 262	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   146: invokevirtual 268	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   149: invokestatic 322	axsb:a	([B)[B
    //   152: astore_2
    //   153: aload_2
    //   154: ifnull +782 -> 936
    //   157: new 118	java/lang/String
    //   160: dup
    //   161: aload_2
    //   162: ldc_w 324
    //   165: invokespecial 327	java/lang/String:<init>	([BLjava/lang/String;)V
    //   168: astore_2
    //   169: aload_2
    //   170: ifnull +696 -> 866
    //   173: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   176: ifeq +29 -> 205
    //   179: ldc 183
    //   181: iconst_2
    //   182: new 85	java/lang/StringBuilder
    //   185: dup
    //   186: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   189: ldc_w 5806
    //   192: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   195: aload_2
    //   196: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   199: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   202: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   205: invokestatic 921	javax/xml/parsers/DocumentBuilderFactory:newInstance	()Ljavax/xml/parsers/DocumentBuilderFactory;
    //   208: invokevirtual 925	javax/xml/parsers/DocumentBuilderFactory:newDocumentBuilder	()Ljavax/xml/parsers/DocumentBuilder;
    //   211: new 927	java/io/ByteArrayInputStream
    //   214: dup
    //   215: aload_2
    //   216: ldc_w 929
    //   219: invokevirtual 933	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   222: invokespecial 934	java/io/ByteArrayInputStream:<init>	([B)V
    //   225: invokevirtual 939	javax/xml/parsers/DocumentBuilder:parse	(Ljava/io/InputStream;)Lorg/w3c/dom/Document;
    //   228: astore_2
    //   229: aload_2
    //   230: ldc_w 5808
    //   233: invokeinterface 947 2 0
    //   238: astore 5
    //   240: aload 5
    //   242: ifnull -229 -> 13
    //   245: aload 5
    //   247: invokeinterface 952 1 0
    //   252: ifle -239 -> 13
    //   255: new 85	java/lang/StringBuilder
    //   258: dup
    //   259: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   262: astore 5
    //   264: aload_2
    //   265: ldc_w 5810
    //   268: invokeinterface 947 2 0
    //   273: ifnull +42 -> 315
    //   276: aload 5
    //   278: aload_2
    //   279: ldc_w 5810
    //   282: invokeinterface 947 2 0
    //   287: iconst_0
    //   288: invokeinterface 958 2 0
    //   293: invokeinterface 964 1 0
    //   298: invokeinterface 967 1 0
    //   303: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   306: pop
    //   307: aload 5
    //   309: bipush 124
    //   311: invokevirtual 1065	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   314: pop
    //   315: aload_2
    //   316: ldc_w 5812
    //   319: invokeinterface 947 2 0
    //   324: ifnull +42 -> 366
    //   327: aload 5
    //   329: aload_2
    //   330: ldc_w 5812
    //   333: invokeinterface 947 2 0
    //   338: iconst_0
    //   339: invokeinterface 958 2 0
    //   344: invokeinterface 964 1 0
    //   349: invokeinterface 967 1 0
    //   354: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   357: pop
    //   358: aload 5
    //   360: bipush 124
    //   362: invokevirtual 1065	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   365: pop
    //   366: aload_2
    //   367: ldc_w 5814
    //   370: invokeinterface 947 2 0
    //   375: ifnull +42 -> 417
    //   378: aload 5
    //   380: aload_2
    //   381: ldc_w 5814
    //   384: invokeinterface 947 2 0
    //   389: iconst_0
    //   390: invokeinterface 958 2 0
    //   395: invokeinterface 964 1 0
    //   400: invokeinterface 967 1 0
    //   405: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   408: pop
    //   409: aload 5
    //   411: bipush 124
    //   413: invokevirtual 1065	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   416: pop
    //   417: aload_2
    //   418: ldc_w 5816
    //   421: invokeinterface 947 2 0
    //   426: ifnull +42 -> 468
    //   429: aload 5
    //   431: aload_2
    //   432: ldc_w 5816
    //   435: invokeinterface 947 2 0
    //   440: iconst_0
    //   441: invokeinterface 958 2 0
    //   446: invokeinterface 964 1 0
    //   451: invokeinterface 967 1 0
    //   456: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   459: pop
    //   460: aload 5
    //   462: bipush 124
    //   464: invokevirtual 1065	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   467: pop
    //   468: aload_2
    //   469: ldc_w 5818
    //   472: invokeinterface 947 2 0
    //   477: ifnull +42 -> 519
    //   480: aload 5
    //   482: aload_2
    //   483: ldc_w 5818
    //   486: invokeinterface 947 2 0
    //   491: iconst_0
    //   492: invokeinterface 958 2 0
    //   497: invokeinterface 964 1 0
    //   502: invokeinterface 967 1 0
    //   507: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   510: pop
    //   511: aload 5
    //   513: bipush 124
    //   515: invokevirtual 1065	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   518: pop
    //   519: aload_2
    //   520: ldc_w 5820
    //   523: invokeinterface 947 2 0
    //   528: ifnull +60 -> 588
    //   531: aload_2
    //   532: ldc_w 5820
    //   535: invokeinterface 947 2 0
    //   540: iconst_0
    //   541: invokeinterface 958 2 0
    //   546: ifnull +42 -> 588
    //   549: aload 5
    //   551: aload_2
    //   552: ldc_w 5820
    //   555: invokeinterface 947 2 0
    //   560: iconst_0
    //   561: invokeinterface 958 2 0
    //   566: invokeinterface 964 1 0
    //   571: invokeinterface 967 1 0
    //   576: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   579: pop
    //   580: aload 5
    //   582: bipush 124
    //   584: invokevirtual 1065	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   587: pop
    //   588: aload_2
    //   589: ldc_w 5822
    //   592: invokeinterface 947 2 0
    //   597: ifnull +60 -> 657
    //   600: aload_2
    //   601: ldc_w 5822
    //   604: invokeinterface 947 2 0
    //   609: iconst_0
    //   610: invokeinterface 958 2 0
    //   615: ifnull +42 -> 657
    //   618: aload 5
    //   620: aload_2
    //   621: ldc_w 5822
    //   624: invokeinterface 947 2 0
    //   629: iconst_0
    //   630: invokeinterface 958 2 0
    //   635: invokeinterface 964 1 0
    //   640: invokeinterface 967 1 0
    //   645: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   648: pop
    //   649: aload 5
    //   651: bipush 124
    //   653: invokevirtual 1065	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   656: pop
    //   657: aload_2
    //   658: ldc_w 5824
    //   661: invokeinterface 947 2 0
    //   666: ifnull +60 -> 726
    //   669: aload_2
    //   670: ldc_w 5824
    //   673: invokeinterface 947 2 0
    //   678: iconst_0
    //   679: invokeinterface 958 2 0
    //   684: ifnull +42 -> 726
    //   687: aload 5
    //   689: aload_2
    //   690: ldc_w 5824
    //   693: invokeinterface 947 2 0
    //   698: iconst_0
    //   699: invokeinterface 958 2 0
    //   704: invokeinterface 964 1 0
    //   709: invokeinterface 967 1 0
    //   714: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   717: pop
    //   718: aload 5
    //   720: bipush 124
    //   722: invokevirtual 1065	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   725: pop
    //   726: aload_2
    //   727: ldc_w 5826
    //   730: invokeinterface 947 2 0
    //   735: ifnull +52 -> 787
    //   738: aload_2
    //   739: ldc_w 5826
    //   742: invokeinterface 947 2 0
    //   747: iconst_0
    //   748: invokeinterface 958 2 0
    //   753: ifnull +34 -> 787
    //   756: aload 5
    //   758: aload_2
    //   759: ldc_w 5826
    //   762: invokeinterface 947 2 0
    //   767: iconst_0
    //   768: invokeinterface 958 2 0
    //   773: invokeinterface 964 1 0
    //   778: invokeinterface 967 1 0
    //   783: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   786: pop
    //   787: aload_1
    //   788: invokevirtual 65	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   791: getstatic 15	aqlw:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   794: aload 5
    //   796: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   799: invokestatic 5828	bfyz:q	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    //   802: return
    //   803: astore_1
    //   804: ldc 183
    //   806: iconst_1
    //   807: new 85	java/lang/StringBuilder
    //   810: dup
    //   811: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   814: ldc_w 5830
    //   817: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   820: aload_1
    //   821: invokevirtual 800	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   824: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   827: invokestatic 644	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   830: return
    //   831: astore_2
    //   832: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   835: ifeq +12 -> 847
    //   838: ldc 183
    //   840: iconst_2
    //   841: ldc_w 5832
    //   844: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   847: aconst_null
    //   848: astore_2
    //   849: goto -680 -> 169
    //   852: aload_2
    //   853: getfield 257	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content:content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   856: invokevirtual 262	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   859: invokevirtual 282	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   862: astore_2
    //   863: goto -694 -> 169
    //   866: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   869: ifeq +12 -> 881
    //   872: ldc 183
    //   874: iconst_2
    //   875: ldc_w 5834
    //   878: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   881: aload_1
    //   882: invokevirtual 65	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   885: getstatic 15	aqlw:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   888: invokestatic 5836	bfyz:q	(Landroid/content/Context;Ljava/lang/String;)V
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
    //   0	941	0	this	aqlw
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
        aqma.a("0", arrayOfInt, paramFromServiceMsg.getResultCode());
        bbzv.a(arrayOfInt, paramFromServiceMsg);
        int k = arrayOfInt.length;
        i = j;
        while (i < k)
        {
          if (arrayOfInt[i] == 215)
          {
            ShortVideoResourceManager.a(-5);
            bmbx.d("SPLASH_ConfigServlet", "【SHORT_VIDEO_RESOURCE_CONFIG】RES_OVERTIME");
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
            abvt.a(((ConfigurationService.RespGetConfig)localObject).min_req_interval_for_reconnect.get());
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
    //   1: invokestatic 1949	bcmt:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)I
    //   4: istore 4
    //   6: aload_2
    //   7: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   10: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   13: istore_3
    //   14: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   17: ifeq +40 -> 57
    //   20: ldc 183
    //   22: iconst_2
    //   23: new 85	java/lang/StringBuilder
    //   26: dup
    //   27: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   30: ldc_w 5901
    //   33: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: iload 4
    //   38: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   41: ldc_w 5903
    //   44: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: iload_3
    //   48: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   51: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   54: invokestatic 200	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   57: iload 4
    //   59: iload_3
    //   60: if_icmpeq +157 -> 217
    //   63: aload_1
    //   64: bipush 17
    //   66: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   69: checkcast 1948	bcmt
    //   72: astore 5
    //   74: aload_2
    //   75: getfield 223	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   78: ifnull +216 -> 294
    //   81: aload_2
    //   82: getfield 223	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   85: invokevirtual 226	com/tencent/mobileqq/pb/PBRepeatMessageField:size	()I
    //   88: ifle +206 -> 294
    //   91: aload_2
    //   92: getfield 223	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   95: iconst_0
    //   96: invokevirtual 319	com/tencent/mobileqq/pb/PBRepeatMessageField:get	(I)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   99: checkcast 246	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content
    //   102: astore_2
    //   103: aload_2
    //   104: ifnull +108 -> 212
    //   107: aload_2
    //   108: getfield 250	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content:compress	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   111: invokevirtual 253	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   114: iconst_1
    //   115: if_icmpne +135 -> 250
    //   118: aload_2
    //   119: getfield 257	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content:content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   122: invokevirtual 262	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   125: invokevirtual 268	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   128: invokestatic 322	axsb:a	([B)[B
    //   131: astore_2
    //   132: aload_2
    //   133: ifnull +179 -> 312
    //   136: new 118	java/lang/String
    //   139: dup
    //   140: aload_2
    //   141: ldc_w 324
    //   144: invokespecial 327	java/lang/String:<init>	([BLjava/lang/String;)V
    //   147: astore_2
    //   148: aload_2
    //   149: ifnull +63 -> 212
    //   152: new 128	org/json/JSONObject
    //   155: dup
    //   156: aload_2
    //   157: invokespecial 131	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   160: ldc_w 5905
    //   163: invokevirtual 409	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   166: istore 4
    //   168: aload 5
    //   170: iload 4
    //   172: invokevirtual 5906	bcmt:a	(I)V
    //   175: ldc 183
    //   177: iconst_1
    //   178: new 85	java/lang/StringBuilder
    //   181: dup
    //   182: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   185: ldc_w 5908
    //   188: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   191: aload_2
    //   192: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   195: ldc_w 5910
    //   198: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   201: iload 4
    //   203: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   206: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   209: invokestatic 200	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   212: aload_1
    //   213: iload_3
    //   214: invokestatic 5911	bcmt:a	(Lcom/tencent/mobileqq/app/QQAppInterface;I)V
    //   217: return
    //   218: astore_2
    //   219: ldc 183
    //   221: iconst_1
    //   222: new 85	java/lang/StringBuilder
    //   225: dup
    //   226: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   229: ldc_w 5913
    //   232: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   235: aload_2
    //   236: invokevirtual 800	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   239: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   242: invokestatic 644	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   245: aconst_null
    //   246: astore_2
    //   247: goto -99 -> 148
    //   250: aload_2
    //   251: getfield 257	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content:content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   254: invokevirtual 262	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   257: invokevirtual 282	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   260: astore_2
    //   261: goto -113 -> 148
    //   264: astore_2
    //   265: ldc 183
    //   267: iconst_1
    //   268: new 85	java/lang/StringBuilder
    //   271: dup
    //   272: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   275: ldc_w 5915
    //   278: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   281: aload_2
    //   282: invokevirtual 800	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   285: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   288: invokestatic 644	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   291: goto -79 -> 212
    //   294: ldc 183
    //   296: iconst_1
    //   297: ldc_w 5917
    //   300: invokestatic 200	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   303: aload 5
    //   305: iconst_0
    //   306: invokevirtual 5906	bcmt:a	(I)V
    //   309: goto -97 -> 212
    //   312: aconst_null
    //   313: astore_2
    //   314: goto -166 -> 148
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	317	0	this	aqlw
    //   0	317	1	paramQQAppInterface	QQAppInterface
    //   0	317	2	paramConfig	ConfigurationService.Config
    //   13	201	3	i	int
    //   4	198	4	j	int
    //   72	232	5	localbcmt	bcmt
    // Exception table:
    //   from	to	target	type
    //   136	148	218	java/lang/Exception
    //   152	212	264	java/lang/Exception
  }
  
  /* Error */
  protected void q(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: getstatic 15	aqlw:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   6: ldc_w 1939
    //   9: iconst_0
    //   10: invokestatic 307	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   13: invokestatic 1937	awka:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   16: checkcast 139	java/lang/Integer
    //   19: invokevirtual 1842	java/lang/Integer:intValue	()I
    //   22: istore 5
    //   24: aload_2
    //   25: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   28: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   31: istore 6
    //   33: new 85	java/lang/StringBuilder
    //   36: dup
    //   37: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   40: ldc_w 5919
    //   43: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: iload 5
    //   48: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   51: ldc_w 5903
    //   54: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: iload 6
    //   59: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   62: ldc_w 5921
    //   65: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: astore 7
    //   70: aload_2
    //   71: getfield 223	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   74: ifnonnull +109 -> 183
    //   77: iconst_0
    //   78: istore_3
    //   79: ldc_w 5923
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
    //   103: getfield 223	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   106: ifnull +614 -> 720
    //   109: aload_2
    //   110: getfield 223	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   113: invokevirtual 226	com/tencent/mobileqq/pb/PBRepeatMessageField:size	()I
    //   116: ifle +604 -> 720
    //   119: iload 4
    //   121: istore_3
    //   122: iload_3
    //   123: aload_2
    //   124: getfield 223	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   127: invokevirtual 226	com/tencent/mobileqq/pb/PBRepeatMessageField:size	()I
    //   130: if_icmpge +64 -> 194
    //   133: ldc_w 5923
    //   136: iconst_1
    //   137: new 85	java/lang/StringBuilder
    //   140: dup
    //   141: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   144: ldc_w 5925
    //   147: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: aload_2
    //   151: getfield 223	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   154: iload_3
    //   155: invokevirtual 319	com/tencent/mobileqq/pb/PBRepeatMessageField:get	(I)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   158: checkcast 246	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content
    //   161: getfield 3877	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content:task_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   164: invokevirtual 253	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   167: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   170: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   173: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   176: iload_3
    //   177: iconst_1
    //   178: iadd
    //   179: istore_3
    //   180: goto -58 -> 122
    //   183: aload_2
    //   184: getfield 223	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   187: invokevirtual 226	com/tencent/mobileqq/pb/PBRepeatMessageField:size	()I
    //   190: istore_3
    //   191: goto -112 -> 79
    //   194: aload_2
    //   195: getfield 223	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   198: iconst_0
    //   199: invokevirtual 319	com/tencent/mobileqq/pb/PBRepeatMessageField:get	(I)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   202: checkcast 246	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content
    //   205: astore 7
    //   207: aload 7
    //   209: ifnull +511 -> 720
    //   212: aload 7
    //   214: getfield 250	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content:compress	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   217: invokevirtual 253	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   220: iconst_1
    //   221: if_icmpne +536 -> 757
    //   224: aload 7
    //   226: getfield 257	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content:content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   229: invokevirtual 262	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   232: invokevirtual 268	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   235: invokestatic 322	axsb:a	([B)[B
    //   238: astore 7
    //   240: aload 7
    //   242: ifnull +588 -> 830
    //   245: new 118	java/lang/String
    //   248: dup
    //   249: aload 7
    //   251: ldc_w 324
    //   254: invokespecial 327	java/lang/String:<init>	([BLjava/lang/String;)V
    //   257: astore 7
    //   259: aload 7
    //   261: ifnull +459 -> 720
    //   264: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   267: ifeq +31 -> 298
    //   270: ldc_w 5923
    //   273: iconst_1
    //   274: new 85	java/lang/StringBuilder
    //   277: dup
    //   278: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   281: ldc_w 5927
    //   284: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   287: aload 7
    //   289: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   292: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   295: invokestatic 200	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   298: new 128	org/json/JSONObject
    //   301: dup
    //   302: aload 7
    //   304: invokespecial 131	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   307: astore 7
    //   309: aload 7
    //   311: ldc_w 5929
    //   314: invokevirtual 5932	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   317: astore 8
    //   319: aload 8
    //   321: invokevirtual 522	org/json/JSONArray:length	()I
    //   324: ifle +18 -> 342
    //   327: getstatic 15	aqlw:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   330: ldc_w 5934
    //   333: aload 8
    //   335: invokevirtual 5935	org/json/JSONArray:toString	()Ljava/lang/String;
    //   338: invokestatic 1942	awka:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)Z
    //   341: pop
    //   342: aload 7
    //   344: ldc_w 5937
    //   347: invokevirtual 734	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   350: astore 8
    //   352: aload 8
    //   354: ifnull +18 -> 372
    //   357: getstatic 15	aqlw:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   360: ldc_w 5939
    //   363: aload 8
    //   365: invokevirtual 5940	org/json/JSONObject:toString	()Ljava/lang/String;
    //   368: invokestatic 1942	awka:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)Z
    //   371: pop
    //   372: aload 7
    //   374: ldc_w 5942
    //   377: invokevirtual 476	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   380: istore_3
    //   381: aload 8
    //   383: ifnull +17 -> 400
    //   386: getstatic 15	aqlw:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   389: ldc_w 5944
    //   392: iload_3
    //   393: invokestatic 307	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   396: invokestatic 1942	awka:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)Z
    //   399: pop
    //   400: aload 7
    //   402: ldc_w 5946
    //   405: invokevirtual 734	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   408: astore 8
    //   410: aload 8
    //   412: ifnull +76 -> 488
    //   415: aload 8
    //   417: ldc_w 5948
    //   420: invokevirtual 476	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   423: istore_3
    //   424: aload 8
    //   426: ldc_w 5950
    //   429: invokevirtual 476	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   432: istore 4
    //   434: aload 8
    //   436: ldc_w 5952
    //   439: invokevirtual 476	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   442: istore 5
    //   444: getstatic 15	aqlw:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   447: ldc_w 5954
    //   450: iload_3
    //   451: invokestatic 307	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   454: invokestatic 1942	awka:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)Z
    //   457: pop
    //   458: getstatic 15	aqlw:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   461: ldc_w 5956
    //   464: iload 4
    //   466: invokestatic 307	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   469: invokestatic 1942	awka:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)Z
    //   472: pop
    //   473: getstatic 15	aqlw:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   476: ldc_w 5958
    //   479: iload 5
    //   481: invokestatic 307	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   484: invokestatic 1942	awka:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)Z
    //   487: pop
    //   488: aload 7
    //   490: ldc_w 5960
    //   493: invokevirtual 5932	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   496: astore 8
    //   498: aload 8
    //   500: ifnull +273 -> 773
    //   503: getstatic 15	aqlw:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   506: ldc_w 5962
    //   509: aload 8
    //   511: invokevirtual 5935	org/json/JSONArray:toString	()Ljava/lang/String;
    //   514: invokestatic 1942	awka:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)Z
    //   517: pop
    //   518: getstatic 15	aqlw:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   521: ldc_w 1939
    //   524: aload_2
    //   525: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   528: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   531: invokestatic 307	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   534: invokestatic 1942	awka:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)Z
    //   537: pop
    //   538: aload 7
    //   540: ldc_w 5964
    //   543: iconst_0
    //   544: invokevirtual 2298	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   547: istore_3
    //   548: aload 7
    //   550: ldc_w 5966
    //   553: iconst_m1
    //   554: invokevirtual 2298	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   557: istore 4
    //   559: aload 7
    //   561: ldc_w 5968
    //   564: iconst_0
    //   565: invokevirtual 2298	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   568: istore 5
    //   570: aload 7
    //   572: ldc_w 5970
    //   575: iconst_0
    //   576: invokevirtual 2298	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   579: istore 6
    //   581: aload 7
    //   583: ldc_w 5972
    //   586: invokevirtual 137	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   589: astore_2
    //   590: getstatic 15	aqlw:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   593: ldc_w 5964
    //   596: iload_3
    //   597: invokestatic 307	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   600: invokestatic 1942	awka:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)Z
    //   603: pop
    //   604: getstatic 15	aqlw:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   607: ldc_w 5966
    //   610: iload 4
    //   612: invokestatic 307	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   615: invokestatic 1942	awka:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)Z
    //   618: pop
    //   619: getstatic 15	aqlw:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   622: ldc_w 5968
    //   625: iload 5
    //   627: invokestatic 307	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   630: invokestatic 1942	awka:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)Z
    //   633: pop
    //   634: getstatic 15	aqlw:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   637: ldc_w 5970
    //   640: iload 6
    //   642: invokestatic 307	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   645: invokestatic 1942	awka:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)Z
    //   648: pop
    //   649: getstatic 15	aqlw:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   652: ldc_w 5974
    //   655: aload_2
    //   656: invokestatic 1942	awka:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)Z
    //   659: pop
    //   660: aload 7
    //   662: ldc_w 5976
    //   665: invokevirtual 476	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   668: istore_3
    //   669: getstatic 15	aqlw:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   672: ldc_w 5976
    //   675: iload_3
    //   676: invokestatic 307	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   679: invokestatic 1942	awka:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)Z
    //   682: pop
    //   683: aload 7
    //   685: ldc_w 5978
    //   688: invokevirtual 734	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   691: astore_2
    //   692: aload_2
    //   693: ifnull +17 -> 710
    //   696: getstatic 15	aqlw:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   699: ldc_w 5980
    //   702: aload_2
    //   703: invokevirtual 5940	org/json/JSONObject:toString	()Ljava/lang/String;
    //   706: invokestatic 1942	awka:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)Z
    //   709: pop
    //   710: aload_1
    //   711: ldc_w 5982
    //   714: iconst_1
    //   715: iconst_1
    //   716: aconst_null
    //   717: invokevirtual 5986	com/tencent/mobileqq/app/QQAppInterface:notifyObservers	(Ljava/lang/Class;IZLandroid/os/Bundle;)V
    //   720: return
    //   721: astore 7
    //   723: ldc_w 5923
    //   726: iconst_1
    //   727: new 85	java/lang/StringBuilder
    //   730: dup
    //   731: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   734: ldc_w 5988
    //   737: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   740: aload 7
    //   742: invokevirtual 800	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   745: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   748: invokestatic 644	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   751: aconst_null
    //   752: astore 7
    //   754: goto -495 -> 259
    //   757: aload 7
    //   759: getfield 257	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content:content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   762: invokevirtual 262	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   765: invokevirtual 282	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   768: astore 7
    //   770: goto -511 -> 259
    //   773: getstatic 15	aqlw:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   776: ldc_w 5962
    //   779: ldc 13
    //   781: invokestatic 1942	awka:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)Z
    //   784: pop
    //   785: goto -267 -> 518
    //   788: astore_1
    //   789: ldc_w 5923
    //   792: iconst_1
    //   793: new 85	java/lang/StringBuilder
    //   796: dup
    //   797: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   800: ldc_w 5990
    //   803: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   806: aload_1
    //   807: invokevirtual 800	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   810: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   813: invokestatic 644	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   816: return
    //   817: astore_1
    //   818: ldc_w 5923
    //   821: iconst_1
    //   822: ldc_w 5992
    //   825: aload_1
    //   826: invokestatic 188	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   829: return
    //   830: aconst_null
    //   831: astore 7
    //   833: goto -574 -> 259
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	836	0	this	aqlw
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
    int i = bfyz.ah(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
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
          arrayOfByte = axsb.a(paramConfig.content.get().toByteArray());
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
        bfyz.n(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, paramConfig);
        bfyz.G(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, j);
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
    //   9: ldc_w 6012
    //   12: iconst_1
    //   13: ldc_w 6014
    //   16: iconst_0
    //   17: anewarray 303	java/lang/Object
    //   20: invokestatic 311	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   23: invokestatic 200	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   26: aload_1
    //   27: invokevirtual 65	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   30: getstatic 15	aqlw:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   33: invokestatic 1957	ahbd:a	(Landroid/content/Context;Ljava/lang/String;)I
    //   36: istore_3
    //   37: aload_2
    //   38: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   41: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   44: istore 6
    //   46: iload_3
    //   47: iload 6
    //   49: if_icmpeq +396 -> 445
    //   52: aload_2
    //   53: getfield 223	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   56: ifnull +365 -> 421
    //   59: aload_2
    //   60: getfield 223	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   63: invokevirtual 226	com/tencent/mobileqq/pb/PBRepeatMessageField:size	()I
    //   66: ifle +355 -> 421
    //   69: aload_2
    //   70: getfield 223	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   73: iconst_0
    //   74: invokevirtual 319	com/tencent/mobileqq/pb/PBRepeatMessageField:get	(I)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   77: checkcast 246	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content
    //   80: astore_2
    //   81: aload_2
    //   82: ifnull +326 -> 408
    //   85: aload_2
    //   86: getfield 257	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content:content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   89: invokevirtual 1137	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   92: ifeq +316 -> 408
    //   95: aload_2
    //   96: getfield 250	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content:compress	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   99: invokevirtual 253	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   102: iconst_1
    //   103: if_icmpne +217 -> 320
    //   106: aload_2
    //   107: getfield 257	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content:content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   110: invokevirtual 262	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   113: invokevirtual 268	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   116: invokestatic 322	axsb:a	([B)[B
    //   119: astore_2
    //   120: aload_2
    //   121: ifnull +393 -> 514
    //   124: new 118	java/lang/String
    //   127: dup
    //   128: aload_2
    //   129: ldc_w 324
    //   132: invokespecial 327	java/lang/String:<init>	([BLjava/lang/String;)V
    //   135: astore_2
    //   136: aload_2
    //   137: ifnull +215 -> 352
    //   140: new 128	org/json/JSONObject
    //   143: dup
    //   144: aload_2
    //   145: invokespecial 131	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   148: astore 9
    //   150: ldc_w 6012
    //   153: iconst_1
    //   154: new 85	java/lang/StringBuilder
    //   157: dup
    //   158: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   161: ldc_w 6016
    //   164: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   167: aload_2
    //   168: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   174: invokestatic 200	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   177: aload 9
    //   179: ldc_w 6018
    //   182: invokevirtual 409	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   185: istore_3
    //   186: aload 9
    //   188: ldc_w 6020
    //   191: invokevirtual 409	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   194: istore 4
    //   196: aload 9
    //   198: ldc_w 6022
    //   201: invokevirtual 517	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   204: astore 9
    //   206: aload 8
    //   208: astore_2
    //   209: aload 9
    //   211: ifnull +123 -> 334
    //   214: aload 8
    //   216: astore_2
    //   217: aload 9
    //   219: invokevirtual 522	org/json/JSONArray:length	()I
    //   222: ifle +112 -> 334
    //   225: new 524	java/util/HashSet
    //   228: dup
    //   229: invokespecial 525	java/util/HashSet:<init>	()V
    //   232: astore_2
    //   233: iload 5
    //   235: aload 9
    //   237: invokevirtual 522	org/json/JSONArray:length	()I
    //   240: if_icmpge +94 -> 334
    //   243: aload 9
    //   245: iload 5
    //   247: invokevirtual 6023	org/json/JSONArray:get	(I)Ljava/lang/Object;
    //   250: checkcast 128	org/json/JSONObject
    //   253: ldc_w 6025
    //   256: invokevirtual 422	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   259: astore 7
    //   261: aload 7
    //   263: invokestatic 126	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   266: ifne +12 -> 278
    //   269: aload_2
    //   270: aload 7
    //   272: invokeinterface 2872 2 0
    //   277: pop
    //   278: iload 5
    //   280: iconst_1
    //   281: iadd
    //   282: istore 5
    //   284: goto -51 -> 233
    //   287: astore_2
    //   288: ldc_w 6012
    //   291: iconst_1
    //   292: new 85	java/lang/StringBuilder
    //   295: dup
    //   296: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   299: ldc_w 6027
    //   302: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   305: aload_2
    //   306: invokevirtual 800	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   309: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   312: invokestatic 644	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   315: aconst_null
    //   316: astore_2
    //   317: goto -181 -> 136
    //   320: aload_2
    //   321: getfield 257	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content:content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   324: invokevirtual 262	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   327: invokevirtual 282	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   330: astore_2
    //   331: goto -195 -> 136
    //   334: iload_3
    //   335: istore 5
    //   337: iload 4
    //   339: istore_3
    //   340: aload_1
    //   341: invokestatic 6030	ahbd:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)Lahbd;
    //   344: aload_1
    //   345: iload 5
    //   347: iload_3
    //   348: aload_2
    //   349: invokevirtual 6033	ahbd:a	(Lcom/tencent/mobileqq/app/QQAppInterface;IILjava/util/Set;)V
    //   352: aload_1
    //   353: invokevirtual 65	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   356: getstatic 15	aqlw:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   359: iload 6
    //   361: invokestatic 6034	ahbd:a	(Landroid/content/Context;Ljava/lang/String;I)V
    //   364: return
    //   365: astore_2
    //   366: iconst_0
    //   367: istore 4
    //   369: iconst_0
    //   370: istore_3
    //   371: ldc_w 6012
    //   374: iconst_1
    //   375: new 85	java/lang/StringBuilder
    //   378: dup
    //   379: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   382: ldc_w 5915
    //   385: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   388: aload_2
    //   389: invokevirtual 800	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   392: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   395: invokestatic 644	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   398: aload 7
    //   400: astore_2
    //   401: iload 4
    //   403: istore 5
    //   405: goto -65 -> 340
    //   408: ldc_w 6012
    //   411: iconst_1
    //   412: ldc_w 6036
    //   415: invokestatic 200	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   418: goto -66 -> 352
    //   421: ldc_w 6012
    //   424: iconst_1
    //   425: ldc_w 6038
    //   428: invokestatic 200	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   431: aload_1
    //   432: invokestatic 6030	ahbd:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)Lahbd;
    //   435: aload_1
    //   436: iconst_0
    //   437: iconst_0
    //   438: aconst_null
    //   439: invokevirtual 6033	ahbd:a	(Lcom/tencent/mobileqq/app/QQAppInterface;IILjava/util/Set;)V
    //   442: goto -90 -> 352
    //   445: ldc_w 6012
    //   448: iconst_1
    //   449: ldc_w 6040
    //   452: iconst_1
    //   453: anewarray 303	java/lang/Object
    //   456: dup
    //   457: iconst_0
    //   458: iload_3
    //   459: invokestatic 307	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   462: aastore
    //   463: invokestatic 311	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   466: invokestatic 644	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
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
    //   0	519	0	this	aqlw
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
    int i = bfyz.al(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
    int j = paramConfig.version.get();
    if (i != j) {
      if ((paramConfig.msg_content_list != null) && (paramConfig.msg_content_list.size() > 0))
      {
        paramConfig = (ConfigurationService.Content)paramConfig.msg_content_list.get(0);
        if ((paramConfig != null) && (paramConfig.content.has())) {
          if (paramConfig.compress.get() == 1)
          {
            paramConfig = axsb.a(paramConfig.content.get().toByteArray());
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
        bfyz.I(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, j);
        ((avmx)paramQQAppInterface.getManager(221)).a(paramConfig);
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
      bool = bfwv.a(paramQQAppInterface.getApp(), "com.tencent.tim");
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
          ((UpgradeTIMManager)paramQQAppInterface.getManager(256)).a((String)localObject);
        }
        paramConfig.commit();
        paramQQAppInterface = paramQQAppInterface.getPreferences().edit();
        paramQQAppInterface.putInt("tim_upgrade_hongdian_version", i);
        paramQQAppInterface.apply();
        return;
      }
      ((avnt)paramQQAppInterface.getManager(244)).a();
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
 * Qualified Name:     aqlw
 * JD-Core Version:    0.7.0.1
 */