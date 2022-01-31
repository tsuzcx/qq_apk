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
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.NearbyGrayTipsManager;
import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.upgrade.UpgradeTIMManager;
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
import com.tencent.mobileqq.scribble.ScribbleResMgr;
import com.tencent.mobileqq.search.util.SearchConfigManager;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager;
import com.tencent.mobileqq.shortvideo.util.RecentDanceConfigMgr;
import com.tencent.mobileqq.utils.BusinessCommonConfig;
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

public class amnh
  extends MSFServlet
{
  public static String a;
  private static final int[] jdField_a_of_type_ArrayOfInt = { 1, 2, 3, 5, 10, 13, 23, 31, 38, 42, 44, 46, 47, 49, 50, 53, 55, 56, 57, 61, 62, 63, 64, 65, 66, 69, 206, 205, 72, 73, 74, 75, 385, 94, 78, 79, 80, 84, 223, 82, 101, 102, 147, 86, 93, 88, 90, 96, 97, 108, 146, 111, 109, 115, 286, 118, 120, 119, 116, 130, 142, 121, 157, 211, 201, 129, 143, 140, 257, 232, 233, 231, 148, 139, 145, 153, 149, 155, 165, 185, 167, 166, 171, 180, 182, 177, 371, 181, 184, 187, 191, 193, 188, 195, 227, 202, 190, 210, 199, 212, 407, skt.a(2131361816), skt.a(2131361817), skt.a(2131361818), skt.a(2131361813), skt.a(2131361814), 218, 226, 225, 222, 256, 228, 235, 234, 238, 247, 244, 245, 253, 295, 255, 254, 259, 260, 262, 204, 271, 267, 275, 358, 268, 269, 272, 274, 279, 308, 281, 283, 284, 280, 360, 289, 314, 297, 301, 296, 330, 347, 313, 312, 397, 321, 326, 320, 328, 331, 336, 329, 337, 345, 351, 349, 355, 372, 384, 379, 357, 378, 381, 273, 364, 365, 369, 237, 387, 386, 392, 393, 394, 401, 400, 403, 404, 405, 408, 410, 194 };
  private static String b;
  private boolean jdField_a_of_type_Boolean;
  
  static
  {
    jdField_a_of_type_JavaLangString = "";
    jdField_b_of_type_JavaLangString = ajjy.a(2131636636);
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
        j = baig.O(localQQAppInterface.getApp(), localQQAppInterface.getAccount());
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
        paramConfig = (arxo)localQQAppInterface.getManager(166);
        paramConfig.jdField_b_of_type_Boolean = true;
        paramConfig.c = bool3;
        localQQAppInterface.h = true;
        localQQAppInterface.i = bool4;
        baig.b(localQQAppInterface.getApp(), localQQAppInterface.getAccount(), i, bool3, bool4);
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
    befs localbefs = (befs)((QQAppInterface)localObject).a(146);
    int i = localbefs.b(BaseApplicationImpl.getContext(), ((QQAppInterface)localObject).getAccount());
    if (localbefs.a(BaseApplicationImpl.getContext(), ((QQAppInterface)localObject).getAccount()) != k) {
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
          paramConfig = localbefs.a(paramConfig.content.get().toByteArray());
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
          localbefs.a(paramConfig, j, k);
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
        localbefs.a(jdField_a_of_type_JavaLangString);
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
    //   1: invokevirtual 47	amnh:getAppRuntime	()Lmqq/app/AppRuntime;
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
    //   27: invokestatic 292	baig:aT	(Landroid/content/Context;Ljava/lang/String;)I
    //   30: istore_2
    //   31: aload 8
    //   33: invokevirtual 65	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   36: aload 8
    //   38: invokevirtual 69	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   41: invokestatic 295	baig:aU	(Landroid/content/Context;Ljava/lang/String;)I
    //   44: istore 4
    //   46: invokestatic 203	com/tencent/common/config/AppSetting:a	()I
    //   49: istore 5
    //   51: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   54: ifeq +50 -> 104
    //   57: ldc_w 297
    //   60: iconst_2
    //   61: ldc_w 299
    //   64: iconst_4
    //   65: anewarray 301	java/lang/Object
    //   68: dup
    //   69: iconst_0
    //   70: iload_3
    //   71: invokestatic 305	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   74: aastore
    //   75: dup
    //   76: iconst_1
    //   77: iload_2
    //   78: invokestatic 305	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   81: aastore
    //   82: dup
    //   83: iconst_2
    //   84: iload 4
    //   86: invokestatic 305	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   89: aastore
    //   90: dup
    //   91: iconst_3
    //   92: iload 5
    //   94: invokestatic 305	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   97: aastore
    //   98: invokestatic 309	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   101: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   104: iload 4
    //   106: iload 5
    //   108: if_icmpeq +20 -> 128
    //   111: aload 8
    //   113: invokevirtual 65	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   116: iload 5
    //   118: aload 8
    //   120: invokevirtual 69	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   123: invokestatic 313	baig:z	(Landroid/content/Context;ILjava/lang/String;)V
    //   126: iconst_0
    //   127: istore_2
    //   128: iload_3
    //   129: iload_2
    //   130: if_icmpeq +66 -> 196
    //   133: aload_1
    //   134: getfield 221	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   137: ifnull +275 -> 412
    //   140: aload_1
    //   141: getfield 221	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   144: invokevirtual 315	com/tencent/mobileqq/pb/PBRepeatMessageField:isEmpty	()Z
    //   147: ifne +265 -> 412
    //   150: aload_1
    //   151: getfield 221	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   154: iconst_0
    //   155: invokevirtual 318	com/tencent/mobileqq/pb/PBRepeatMessageField:get	(I)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   158: checkcast 244	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content
    //   161: astore 7
    //   163: aload 7
    //   165: getfield 248	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content:compress	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   168: invokevirtual 251	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   171: iconst_1
    //   172: if_icmpne +207 -> 379
    //   175: aload 7
    //   177: getfield 255	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content:content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   180: invokevirtual 260	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   183: invokevirtual 266	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   186: invokestatic 321	atiu:a	([B)[B
    //   189: astore 7
    //   191: aload 7
    //   193: ifnonnull +4 -> 197
    //   196: return
    //   197: new 118	java/lang/String
    //   200: dup
    //   201: aload 7
    //   203: ldc_w 323
    //   206: invokespecial 326	java/lang/String:<init>	([BLjava/lang/String;)V
    //   209: astore 7
    //   211: new 128	org/json/JSONObject
    //   214: dup
    //   215: aload 7
    //   217: invokespecial 131	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   220: ldc_w 328
    //   223: invokevirtual 332	org/json/JSONObject:getBoolean	(Ljava/lang/String;)Z
    //   226: istore 6
    //   228: aload 8
    //   230: invokevirtual 65	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   233: ldc_w 334
    //   236: iconst_4
    //   237: invokevirtual 340	com/tencent/qphone/base/util/BaseApplication:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   240: invokeinterface 346 1 0
    //   245: ldc_w 348
    //   248: iload 6
    //   250: invokeinterface 354 3 0
    //   255: invokeinterface 357 1 0
    //   260: aload 8
    //   262: invokevirtual 65	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   265: aload_1
    //   266: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   269: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   272: getstatic 15	amnh:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   275: invokestatic 360	baig:y	(Landroid/content/Context;ILjava/lang/String;)V
    //   278: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   281: ifeq +30 -> 311
    //   284: ldc 183
    //   286: iconst_2
    //   287: new 85	java/lang/StringBuilder
    //   290: dup
    //   291: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   294: ldc_w 362
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
    //   327: ldc_w 364
    //   330: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   333: aload 7
    //   335: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   338: ldc_w 366
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
    //   372: invokestatic 370	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   375: invokestatic 373	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   378: return
    //   379: aload 7
    //   381: getfield 255	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content:content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   384: invokevirtual 260	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   387: invokevirtual 280	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   390: astore 7
    //   392: goto -181 -> 211
    //   395: astore 8
    //   397: ldc 183
    //   399: iconst_1
    //   400: aload 8
    //   402: iconst_0
    //   403: anewarray 301	java/lang/Object
    //   406: invokestatic 376	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   409: goto -98 -> 311
    //   412: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   415: ifeq +35 -> 450
    //   418: ldc 183
    //   420: iconst_2
    //   421: new 85	java/lang/StringBuilder
    //   424: dup
    //   425: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   428: ldc_w 378
    //   431: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   434: aload_1
    //   435: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   438: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   441: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   444: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   447: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   450: aload 8
    //   452: invokevirtual 65	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   455: ldc_w 334
    //   458: iconst_4
    //   459: invokevirtual 340	com/tencent/qphone/base/util/BaseApplication:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   462: invokeinterface 346 1 0
    //   467: astore_1
    //   468: aload_1
    //   469: ldc_w 334
    //   472: invokeinterface 382 2 0
    //   477: pop
    //   478: aload_1
    //   479: invokeinterface 357 1 0
    //   484: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	485	0	this	amnh
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
    int j = baig.aQ(BaseApplication.getContext(), jdField_a_of_type_JavaLangString);
    if (QLog.isColorLevel()) {
      QLog.i("SPLASH_ConfigServlet", 2, "handleWeiYunMiniAppConfig: ,version: " + paramConfig.version.get() + "| localVersion: " + j);
    }
    if (i != j)
    {
      baig.ag(BaseApplication.getContext(), jdField_a_of_type_JavaLangString, i);
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
              baig.w(BaseApplication.getContext(), i, paramQQAppInterface.getCurrentAccountUin());
              if (QLog.isColorLevel()) {
                QLog.d("SPLASH_ConfigServlet", 2, "handleWeiYunMiniAppConfig, enableMiniApp = " + i);
              }
            }
            if (((JSONObject)localObject).has("apkgUrl"))
            {
              String str = ((JSONObject)localObject).getString("apkgUrl");
              baig.u(BaseApplication.getContext(), str, paramQQAppInterface.getCurrentAccountUin());
              if (QLog.isColorLevel()) {
                QLog.d("SPLASH_ConfigServlet", 2, "handleWeiYunMiniAppConfig, apkgUrl = " + str);
              }
            }
            if (((JSONObject)localObject).has("miniVersion"))
            {
              i = ((JSONObject)localObject).getInt("miniVersion");
              baig.x(BaseApplication.getContext(), i, paramQQAppInterface.getCurrentAccountUin());
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
    int j = baig.aW(BaseApplication.getContext(), jdField_a_of_type_JavaLangString);
    if (QLog.isColorLevel()) {
      QLog.i("SPLASH_ConfigServlet", 2, "handleAIOConfig: ,version: " + paramConfig.version.get() + "| localVersion: " + j);
    }
    if (i != j)
    {
      baig.ai(BaseApplication.getContext(), jdField_a_of_type_JavaLangString, i);
      paramConfig = a(paramConfig);
      if ((paramConfig == null) || (paramConfig.size() <= 0)) {}
    }
    while (!QLog.isColorLevel()) {
      try
      {
        paramConfig = (String)paramConfig.get(paramConfig.size() - 1);
        baig.c(BaseApplication.getContext(), jdField_a_of_type_JavaLangString, "aio_config_key", paramConfig);
        acim.a(paramQQAppInterface);
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
    int j = baig.aX(BaseApplication.getContext(), jdField_a_of_type_JavaLangString);
    if (QLog.isColorLevel()) {
      QLog.i("SPLASH_ConfigServlet", 2, "handleMultiMsgConfig: ,version: " + paramConfig.version.get() + "| localVersion: " + j);
    }
    if (i != j)
    {
      baig.aj(BaseApplication.getContext(), jdField_a_of_type_JavaLangString, i);
      paramConfig = a(paramConfig);
      if ((paramConfig == null) || (paramConfig.size() <= 0)) {}
    }
    while (!QLog.isColorLevel()) {
      try
      {
        i = new JSONObject((String)paramConfig.get(paramConfig.size() - 1)).optInt("max_multimsg_totalcount");
        baig.g(BaseApplication.getContext(), jdField_a_of_type_JavaLangString, "multimsg_config", i);
        if (QLog.isColorLevel()) {
          QLog.i("SPLASH_ConfigServlet", 2, "handleMultiMsgConfig:limitTotal =  " + i);
        }
        arxu.a().a(paramQQAppInterface);
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
    int j = baig.ay(BaseApplication.getContext(), jdField_a_of_type_JavaLangString);
    if (QLog.isColorLevel()) {
      QLog.i("SPLASH_ConfigServlet", 2, "handleConversationPublicAccConfig: ,version: " + paramConfig.version.get() + "| localVersion: " + j);
    }
    if (i != j)
    {
      baig.T(BaseApplication.getContext(), jdField_a_of_type_JavaLangString, i);
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
            localObject3 = ahch.a();
            if (i == 1)
            {
              bool = true;
              ((ahch)localObject3).a(paramQQAppInterface, bool);
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
        ahch.a().a(paramQQAppInterface, false);
        continue;
        if (QLog.isColorLevel()) {
          QLog.i("SPLASH_ConfigServlet", 2, "handleConversationPublicAccConfig  error =" + localJSONException1.getMessage());
        }
        ahch.a().a(paramQQAppInterface, false);
        ahch.a().a(paramQQAppInterface, null);
      }
    }
    label406:
    label417:
    label443:
    label444:
    for (;;)
    {
      break;
      ahch.a().a(paramQQAppInterface, localJSONException1);
      paramConfig = localJSONException1;
      continue;
      Object localObject2;
      ahch.a().a(paramQQAppInterface, paramConfig);
      break label444;
      ahch.a().a(paramQQAppInterface, paramConfig);
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
    int j = baig.a();
    if (QLog.isColorLevel()) {
      QLog.i("SPLASH_ConfigServlet", 2, "handleBeancurdConfig: ,version: " + paramConfig.version.get() + "| localVersion: " + j);
    }
    if (i != j)
    {
      baig.a(i);
      paramConfig = a(paramConfig);
      if ((paramConfig != null) && (paramConfig.size() > 0))
      {
        paramConfig = (String)paramConfig.get(paramConfig.size() - 1);
        if (QLog.isColorLevel()) {
          QLog.i("SPLASH_ConfigServlet", 2, "handleBeancurdConfigStr: " + paramConfig);
        }
        baig.b(paramConfig);
        ((acjz)paramQQAppInterface.getManager(282)).a(paramConfig);
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
    int j = baig.ax(BaseApplication.getContext(), jdField_a_of_type_JavaLangString);
    if (QLog.isColorLevel()) {
      QLog.i("SPLASH_ConfigServlet", 2, "handleZhituConfig: ,version: " + paramConfig.version.get() + "| localVersion: " + j);
    }
    if (i != j)
    {
      baig.S(BaseApplication.getContext(), jdField_a_of_type_JavaLangString, i);
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
              aeor localaeor;
              if (((JSONObject)localObject).has("kMarioConfigEnable"))
              {
                i = ((JSONObject)localObject).getInt("kMarioConfigEnable");
                localaeor = aeor.a(paramQQAppInterface);
                if (i != 1) {
                  break label324;
                }
                bool = true;
                localaeor.a(bool);
              }
              if (((JSONObject)localObject).has("kMarioPageLen"))
              {
                i = ((JSONObject)localObject).getInt("kMarioPageLen");
                aeor.a(paramQQAppInterface).b(i);
              }
              if (((JSONObject)localObject).has("kMarioSaveAndShareEnable"))
              {
                i = ((JSONObject)localObject).getInt("kMarioSaveAndShareEnable");
                localaeor = aeor.a(paramQQAppInterface);
                if (i != 1) {
                  break label330;
                }
                bool = true;
                localaeor.b(bool);
              }
              if (!((JSONObject)localObject).has("kMarioSafeGateRequestInterval")) {
                break;
              }
              i = ((JSONObject)localObject).getInt("kMarioSafeGateRequestInterval");
              aeor.a(paramQQAppInterface).a(i);
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
    a(paramQQAppInterface, paramConfig, "handleShortVideoMsgTailConfig", new amni(this, paramQQAppInterface));
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
            if ((j == baig.a(paramQQAppInterface.getApp(), "readinjoy_interested_push_config", jdField_a_of_type_JavaLangString)) || (TextUtils.isEmpty((CharSequence)localObject))) {
              break label412;
            }
            localObject = ((String)localObject).split("=");
            if (localObject.length >= 2)
            {
              if (!"xqh_insert_into_feeds".equals(localObject[0])) {
                continue;
              }
              bgmq.c(paramQQAppInterface, "1".equals(localObject[1]));
              if (QLog.isColorLevel()) {
                QLog.d("SPLASH_ConfigServlet", 2, "update KANDIAN_INTERESTED_PUSH_CONFiG config , switch : " + "1".equals(localObject[1]));
              }
            }
            baig.a(paramQQAppInterface.getApp(), "readinjoy_interested_push_config", jdField_a_of_type_JavaLangString, j);
            break label469;
            if ("simple_switch_fm".equals(localObject[0]))
            {
              bgmq.c(paramQQAppInterface, "1".equals(localObject[1]));
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
        onm.a(paramQQAppInterface, "1".equals(localObject[1]));
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
            if (k != baig.a(paramQQAppInterface.getApp(), "now_entrance_action_version", jdField_a_of_type_JavaLangString))
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
                    baig.c(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin(), localJSONObject.optInt("bid"), localJSONObject.optInt("actionType"));
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
                  baig.a(paramQQAppInterface.getApp(), "now_entrance_action_version", jdField_a_of_type_JavaLangString, k);
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
            if (j == baig.a(paramQQAppInterface.getApp(), "troop_common_config_version", jdField_a_of_type_JavaLangString)) {
              break label625;
            }
            boolean bool = TextUtils.isEmpty((CharSequence)localObject);
            if (bool) {
              break label625;
            }
            try
            {
              JSONObject localJSONObject = new JSONObject((String)localObject);
              baig.e(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin(), localJSONObject.optString("hot_chat_link"));
              baig.v(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin(), localJSONObject.optInt("aio_post_tab_plugin"));
              ((azks)paramQQAppInterface.getManager(203)).a(localJSONObject);
              ((akft)paramQQAppInterface.getManager(126)).a(localJSONObject);
              baig.u(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin(), localJSONObject.optInt("create_troop_max_invite_num"));
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
            baig.a(paramQQAppInterface.getApp(), "troop_common_config_version", jdField_a_of_type_JavaLangString, j);
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
            if (j != baig.a(paramQQAppInterface.getApp(), "nearby_config_version", jdField_a_of_type_JavaLangString))
            {
              boolean bool = TextUtils.isEmpty((CharSequence)localObject);
              if (!bool) {
                try
                {
                  localObject = new JSONObject((String)localObject);
                  baig.a(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin(), (JSONObject)localObject);
                  baig.a(paramQQAppInterface.getApp(), "nearby_config_version", jdField_a_of_type_JavaLangString, j);
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
          if (j != baig.a(paramQQAppInterface.getApp(), "nearby_nowlive_tab_config_version", jdField_a_of_type_JavaLangString))
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
                baig.a(paramQQAppInterface.getApp(), "nearby_nowlive_tab_config_version", jdField_a_of_type_JavaLangString, j);
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
      int i;
      try
      {
        azgf localazgf = (azgf)paramQQAppInterface.getManager(183);
        if ((paramConfig.content_list != null) && (paramConfig.content_list.size() > 0))
        {
          i = 0;
          if (i < paramConfig.content_list.size())
          {
            String str = ((String)paramConfig.content_list.get(i)).trim();
            if (QLog.isColorLevel()) {
              QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 120,content: " + str + ",version: " + paramConfig.version.get());
            }
            int j = paramConfig.version.get();
            if ((j != baig.a(paramQQAppInterface.getApp(), "change_machine_version", jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty(str)))
            {
              if (BaseApplicationImpl.isFirstLogin) {
                localazgf.a(str);
              }
              baig.a(paramQQAppInterface.getApp(), "change_machine_version", jdField_a_of_type_JavaLangString, j);
            }
            else if (QLog.isColorLevel())
            {
              QLog.d("SPLASH_ConfigServlet", 2, "received CHNAGE_MACHINE_CONFIG IGNORE THIS ACTION  because of SAME VERSION ");
            }
          }
        }
      }
      catch (Exception paramQQAppInterface)
      {
        if (QLog.isColorLevel()) {
          QLog.e("SPLASH_ConfigServlet", 2, "received change machine config error,cmd : 120" + paramQQAppInterface.toString());
        }
      }
      while (!QLog.isColorLevel()) {
        return;
      }
      QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 120,content_list is empty ,version: " + paramConfig.version.get());
      return;
      i += 1;
    }
  }
  
  private float a(float paramFloat)
  {
    return paramFloat / (50.0F * 2.0F) * (float)babp.g();
  }
  
  private float a(float paramFloat1, float paramFloat2)
  {
    return (50.0F + paramFloat1) / (50.0F * 2.0F) * paramFloat2;
  }
  
  private float a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return paramFloat2 / 2.0F - paramFloat1 * paramFloat3 / (50.0F * 2.0F);
  }
  
  private int a(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    ShortVideoResourceManager localShortVideoResourceManager = paramQQAppInterface.a();
    if ((!paramQQAppInterface.isLogin()) && (localShortVideoResourceManager == null)) {
      localShortVideoResourceManager = new ShortVideoResourceManager(paramQQAppInterface);
    }
    for (;;)
    {
      int j = ShortVideoResourceManager.a();
      int k = paramConfig.version.get();
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoResourceManager", 2, "receiveAllConfigs[handleShortVideoResourceConfig]|received remote version: " + k + " | localVersion: " + j);
      }
      int i = 0;
      if (k != j)
      {
        if ((paramConfig.msg_content_list == null) || (paramConfig.msg_content_list.size() <= 0)) {
          break label321;
        }
        paramConfig = (ConfigurationService.Content)paramConfig.msg_content_list.get(paramConfig.msg_content_list.size() - 1);
        if (paramConfig == null) {
          break label302;
        }
        if (paramConfig.compress.get() != 1) {
          break label288;
        }
        paramConfig = atiu.a(paramConfig.content.get().toByteArray());
        if (paramConfig == null) {
          break label267;
        }
      }
      for (;;)
      {
        try
        {
          paramConfig = new String(paramConfig, "UTF-8");
          if (QLog.isColorLevel()) {
            QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs[handleShortVideoResourceConfig]|config_content " + paramConfig);
          }
          i = localShortVideoResourceManager.a(paramQQAppInterface.getApp(), paramConfig, k);
          return i;
        }
        catch (Throwable paramConfig)
        {
          if (QLog.isColorLevel()) {
            QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs[handleShortVideoResourceConfig]|Throwable:" + paramConfig.getMessage());
          }
          paramConfig = "";
          continue;
        }
        label267:
        if (QLog.isColorLevel()) {
          QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs[handleShortVideoResourceConfig]|inflateConfigString error!");
        }
        paramConfig = "";
        continue;
        label288:
        paramConfig = paramConfig.content.get().toStringUtf8();
      }
      label302:
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoResourceManager", 2, "receiveAllConfigs[handleShortVideoResourceConfig]| content==null");
      }
      return -125;
      label321:
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoResourceManager", 2, "receiveAllConfigs[handleShortVideoResourceConfig]| msg_content_list is empty ,version: " + k + ",localVersion:" + j);
      }
      return -125;
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
    //   2: invokestatic 909	javax/xml/parsers/DocumentBuilderFactory:newInstance	()Ljavax/xml/parsers/DocumentBuilderFactory;
    //   5: invokevirtual 913	javax/xml/parsers/DocumentBuilderFactory:newDocumentBuilder	()Ljavax/xml/parsers/DocumentBuilder;
    //   8: new 915	java/io/ByteArrayInputStream
    //   11: dup
    //   12: aload_1
    //   13: ldc_w 917
    //   16: invokevirtual 921	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   19: invokespecial 922	java/io/ByteArrayInputStream:<init>	([B)V
    //   22: invokevirtual 927	javax/xml/parsers/DocumentBuilder:parse	(Ljava/io/InputStream;)Lorg/w3c/dom/Document;
    //   25: astore_1
    //   26: aload_1
    //   27: ldc_w 929
    //   30: invokeinterface 935 2 0
    //   35: astore 4
    //   37: aload 4
    //   39: ifnull +1254 -> 1293
    //   42: aload 4
    //   44: invokeinterface 940 1 0
    //   49: ifle +1244 -> 1293
    //   52: aload_1
    //   53: ldc_w 942
    //   56: invokeinterface 935 2 0
    //   61: astore 4
    //   63: aload 4
    //   65: ifnull +45 -> 110
    //   68: aload 4
    //   70: invokeinterface 940 1 0
    //   75: ifle +35 -> 110
    //   78: aload_2
    //   79: aload_1
    //   80: ldc_w 942
    //   83: invokeinterface 935 2 0
    //   88: iconst_0
    //   89: invokeinterface 946 2 0
    //   94: invokeinterface 952 1 0
    //   99: invokeinterface 955 1 0
    //   104: invokestatic 143	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   107: putfield 958	com/tencent/mobileqq/config/operation/QQOperationViopTipTask:taskid	I
    //   110: aload_1
    //   111: ldc_w 960
    //   114: invokeinterface 935 2 0
    //   119: astore 4
    //   121: aload 4
    //   123: ifnull +45 -> 168
    //   126: aload 4
    //   128: invokeinterface 940 1 0
    //   133: ifle +35 -> 168
    //   136: aload_2
    //   137: aload_1
    //   138: ldc_w 960
    //   141: invokeinterface 935 2 0
    //   146: iconst_0
    //   147: invokeinterface 946 2 0
    //   152: invokeinterface 952 1 0
    //   157: invokeinterface 955 1 0
    //   162: invokestatic 143	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   165: putfield 963	com/tencent/mobileqq/config/operation/QQOperationViopTipTask:limitDayAIOCount	I
    //   168: aload_1
    //   169: ldc_w 965
    //   172: invokeinterface 935 2 0
    //   177: astore 4
    //   179: aload 4
    //   181: ifnull +45 -> 226
    //   184: aload 4
    //   186: invokeinterface 940 1 0
    //   191: ifle +35 -> 226
    //   194: aload_2
    //   195: aload_1
    //   196: ldc_w 965
    //   199: invokeinterface 935 2 0
    //   204: iconst_0
    //   205: invokeinterface 946 2 0
    //   210: invokeinterface 952 1 0
    //   215: invokeinterface 955 1 0
    //   220: invokestatic 143	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   223: putfield 968	com/tencent/mobileqq/config/operation/QQOperationViopTipTask:limitDayAIOShowCount	I
    //   226: aload_1
    //   227: ldc_w 970
    //   230: invokeinterface 935 2 0
    //   235: astore 4
    //   237: aload 4
    //   239: ifnull +45 -> 284
    //   242: aload 4
    //   244: invokeinterface 940 1 0
    //   249: ifle +35 -> 284
    //   252: aload_2
    //   253: aload_1
    //   254: ldc_w 970
    //   257: invokeinterface 935 2 0
    //   262: iconst_0
    //   263: invokeinterface 946 2 0
    //   268: invokeinterface 952 1 0
    //   273: invokeinterface 955 1 0
    //   278: invokestatic 143	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   281: putfield 973	com/tencent/mobileqq/config/operation/QQOperationViopTipTask:limitTotalAIOCount	I
    //   284: aload_1
    //   285: ldc_w 975
    //   288: invokeinterface 935 2 0
    //   293: astore 4
    //   295: aload 4
    //   297: ifnull +45 -> 342
    //   300: aload 4
    //   302: invokeinterface 940 1 0
    //   307: ifle +35 -> 342
    //   310: aload_2
    //   311: aload_1
    //   312: ldc_w 975
    //   315: invokeinterface 935 2 0
    //   320: iconst_0
    //   321: invokeinterface 946 2 0
    //   326: invokeinterface 952 1 0
    //   331: invokeinterface 955 1 0
    //   336: invokestatic 143	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   339: putfield 978	com/tencent/mobileqq/config/operation/QQOperationViopTipTask:limitTotalShowCount	I
    //   342: aload_1
    //   343: ldc_w 980
    //   346: invokeinterface 935 2 0
    //   351: astore 4
    //   353: aload 4
    //   355: ifnull +42 -> 397
    //   358: aload 4
    //   360: invokeinterface 940 1 0
    //   365: ifle +32 -> 397
    //   368: aload_2
    //   369: aload_1
    //   370: ldc_w 980
    //   373: invokeinterface 935 2 0
    //   378: iconst_0
    //   379: invokeinterface 946 2 0
    //   384: invokeinterface 952 1 0
    //   389: invokeinterface 955 1 0
    //   394: invokevirtual 983	com/tencent/mobileqq/config/operation/QQOperationViopTipTask:setKeywordString	(Ljava/lang/String;)V
    //   397: invokestatic 986	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   400: ifeq +33 -> 433
    //   403: ldc_w 988
    //   406: iconst_4
    //   407: new 85	java/lang/StringBuilder
    //   410: dup
    //   411: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   414: ldc_w 990
    //   417: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   420: aload_2
    //   421: invokevirtual 994	com/tencent/mobileqq/config/operation/QQOperationViopTipTask:getKeywordList	()Ljava/util/ArrayList;
    //   424: invokevirtual 798	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   427: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   430: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   433: aload_1
    //   434: ldc_w 996
    //   437: invokeinterface 935 2 0
    //   442: astore 4
    //   444: aload 4
    //   446: ifnull +42 -> 488
    //   449: aload 4
    //   451: invokeinterface 940 1 0
    //   456: ifle +32 -> 488
    //   459: aload_2
    //   460: aload_1
    //   461: ldc_w 996
    //   464: invokeinterface 935 2 0
    //   469: iconst_0
    //   470: invokeinterface 946 2 0
    //   475: invokeinterface 952 1 0
    //   480: invokeinterface 955 1 0
    //   485: invokevirtual 999	com/tencent/mobileqq/config/operation/QQOperationViopTipTask:setBeginTime	(Ljava/lang/String;)V
    //   488: aload_1
    //   489: ldc_w 1001
    //   492: invokeinterface 935 2 0
    //   497: astore 4
    //   499: aload 4
    //   501: ifnull +42 -> 543
    //   504: aload 4
    //   506: invokeinterface 940 1 0
    //   511: ifle +32 -> 543
    //   514: aload_2
    //   515: aload_1
    //   516: ldc_w 1001
    //   519: invokeinterface 935 2 0
    //   524: iconst_0
    //   525: invokeinterface 946 2 0
    //   530: invokeinterface 952 1 0
    //   535: invokeinterface 955 1 0
    //   540: invokevirtual 1004	com/tencent/mobileqq/config/operation/QQOperationViopTipTask:setEndTime	(Ljava/lang/String;)V
    //   543: aload_1
    //   544: ldc_w 1006
    //   547: invokeinterface 935 2 0
    //   552: astore 4
    //   554: aload 4
    //   556: ifnull +50 -> 606
    //   559: aload 4
    //   561: invokeinterface 940 1 0
    //   566: ifle +40 -> 606
    //   569: aload_1
    //   570: ldc_w 1006
    //   573: invokeinterface 935 2 0
    //   578: iconst_0
    //   579: invokeinterface 946 2 0
    //   584: invokeinterface 952 1 0
    //   589: invokeinterface 955 1 0
    //   594: invokestatic 143	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   597: iconst_1
    //   598: if_icmpne +697 -> 1295
    //   601: aload_2
    //   602: iload_3
    //   603: putfield 1009	com/tencent/mobileqq/config/operation/QQOperationViopTipTask:uinType	I
    //   606: aload_1
    //   607: ldc_w 1011
    //   610: invokeinterface 935 2 0
    //   615: astore 4
    //   617: aload 4
    //   619: ifnull +197 -> 816
    //   622: aload 4
    //   624: invokeinterface 940 1 0
    //   629: ifle +187 -> 816
    //   632: aload_1
    //   633: ldc_w 1011
    //   636: invokeinterface 935 2 0
    //   641: iconst_0
    //   642: invokeinterface 946 2 0
    //   647: checkcast 1013	org/w3c/dom/Element
    //   650: ldc_w 1015
    //   653: invokeinterface 1016 2 0
    //   658: astore 4
    //   660: aload 4
    //   662: ifnull +62 -> 724
    //   665: aload 4
    //   667: invokeinterface 940 1 0
    //   672: ifle +52 -> 724
    //   675: aload_2
    //   676: aload_1
    //   677: ldc_w 1011
    //   680: invokeinterface 935 2 0
    //   685: iconst_0
    //   686: invokeinterface 946 2 0
    //   691: checkcast 1013	org/w3c/dom/Element
    //   694: ldc_w 1015
    //   697: invokeinterface 1016 2 0
    //   702: iconst_0
    //   703: invokeinterface 946 2 0
    //   708: invokeinterface 952 1 0
    //   713: invokeinterface 955 1 0
    //   718: invokestatic 143	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   721: putfield 1019	com/tencent/mobileqq/config/operation/QQOperationViopTipTask:frequencyTime	I
    //   724: aload_1
    //   725: ldc_w 1011
    //   728: invokeinterface 935 2 0
    //   733: iconst_0
    //   734: invokeinterface 946 2 0
    //   739: checkcast 1013	org/w3c/dom/Element
    //   742: ldc_w 1021
    //   745: invokeinterface 1016 2 0
    //   750: astore 4
    //   752: aload 4
    //   754: ifnull +62 -> 816
    //   757: aload 4
    //   759: invokeinterface 940 1 0
    //   764: ifle +52 -> 816
    //   767: aload_2
    //   768: aload_1
    //   769: ldc_w 1011
    //   772: invokeinterface 935 2 0
    //   777: iconst_0
    //   778: invokeinterface 946 2 0
    //   783: checkcast 1013	org/w3c/dom/Element
    //   786: ldc_w 1021
    //   789: invokeinterface 1016 2 0
    //   794: iconst_0
    //   795: invokeinterface 946 2 0
    //   800: invokeinterface 952 1 0
    //   805: invokeinterface 955 1 0
    //   810: invokestatic 143	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   813: putfield 1024	com/tencent/mobileqq/config/operation/QQOperationViopTipTask:frequencyMessage	I
    //   816: aload_1
    //   817: ldc_w 1026
    //   820: invokeinterface 935 2 0
    //   825: astore 4
    //   827: aload 4
    //   829: ifnull +464 -> 1293
    //   832: aload 4
    //   834: invokeinterface 940 1 0
    //   839: ifle +454 -> 1293
    //   842: aload_1
    //   843: ldc_w 1026
    //   846: invokeinterface 935 2 0
    //   851: iconst_0
    //   852: invokeinterface 946 2 0
    //   857: checkcast 1013	org/w3c/dom/Element
    //   860: ldc_w 1028
    //   863: invokeinterface 1016 2 0
    //   868: astore 4
    //   870: aload 4
    //   872: ifnull +62 -> 934
    //   875: aload 4
    //   877: invokeinterface 940 1 0
    //   882: ifle +52 -> 934
    //   885: aload_2
    //   886: aload_1
    //   887: ldc_w 1026
    //   890: invokeinterface 935 2 0
    //   895: iconst_0
    //   896: invokeinterface 946 2 0
    //   901: checkcast 1013	org/w3c/dom/Element
    //   904: ldc_w 1028
    //   907: invokeinterface 1016 2 0
    //   912: iconst_0
    //   913: invokeinterface 946 2 0
    //   918: invokeinterface 952 1 0
    //   923: invokeinterface 955 1 0
    //   928: invokestatic 143	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   931: putfield 1031	com/tencent/mobileqq/config/operation/QQOperationViopTipTask:tipType	I
    //   934: aload_1
    //   935: ldc_w 1026
    //   938: invokeinterface 935 2 0
    //   943: iconst_0
    //   944: invokeinterface 946 2 0
    //   949: checkcast 1013	org/w3c/dom/Element
    //   952: ldc_w 1021
    //   955: invokeinterface 1016 2 0
    //   960: astore 4
    //   962: aload 4
    //   964: ifnull +59 -> 1023
    //   967: aload 4
    //   969: invokeinterface 940 1 0
    //   974: ifle +49 -> 1023
    //   977: aload_2
    //   978: aload_1
    //   979: ldc_w 1026
    //   982: invokeinterface 935 2 0
    //   987: iconst_0
    //   988: invokeinterface 946 2 0
    //   993: checkcast 1013	org/w3c/dom/Element
    //   996: ldc_w 1021
    //   999: invokeinterface 1016 2 0
    //   1004: iconst_0
    //   1005: invokeinterface 946 2 0
    //   1010: invokeinterface 952 1 0
    //   1015: invokeinterface 955 1 0
    //   1020: putfield 1034	com/tencent/mobileqq/config/operation/QQOperationViopTipTask:adwords	Ljava/lang/String;
    //   1023: aload_1
    //   1024: ldc_w 1026
    //   1027: invokeinterface 935 2 0
    //   1032: iconst_0
    //   1033: invokeinterface 946 2 0
    //   1038: checkcast 1013	org/w3c/dom/Element
    //   1041: ldc_w 1036
    //   1044: invokeinterface 1016 2 0
    //   1049: astore 4
    //   1051: aload 4
    //   1053: ifnull +62 -> 1115
    //   1056: aload 4
    //   1058: invokeinterface 940 1 0
    //   1063: ifle +52 -> 1115
    //   1066: aload_2
    //   1067: aload_1
    //   1068: ldc_w 1026
    //   1071: invokeinterface 935 2 0
    //   1076: iconst_0
    //   1077: invokeinterface 946 2 0
    //   1082: checkcast 1013	org/w3c/dom/Element
    //   1085: ldc_w 1036
    //   1088: invokeinterface 1016 2 0
    //   1093: iconst_0
    //   1094: invokeinterface 946 2 0
    //   1099: invokeinterface 952 1 0
    //   1104: invokeinterface 955 1 0
    //   1109: invokestatic 143	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   1112: putfield 1039	com/tencent/mobileqq/config/operation/QQOperationViopTipTask:linkOffset	I
    //   1115: aload_1
    //   1116: ldc_w 1026
    //   1119: invokeinterface 935 2 0
    //   1124: iconst_0
    //   1125: invokeinterface 946 2 0
    //   1130: checkcast 1013	org/w3c/dom/Element
    //   1133: ldc_w 1041
    //   1136: invokeinterface 1016 2 0
    //   1141: astore 4
    //   1143: aload 4
    //   1145: ifnull +59 -> 1204
    //   1148: aload 4
    //   1150: invokeinterface 940 1 0
    //   1155: ifle +49 -> 1204
    //   1158: aload_2
    //   1159: aload_1
    //   1160: ldc_w 1026
    //   1163: invokeinterface 935 2 0
    //   1168: iconst_0
    //   1169: invokeinterface 946 2 0
    //   1174: checkcast 1013	org/w3c/dom/Element
    //   1177: ldc_w 1041
    //   1180: invokeinterface 1016 2 0
    //   1185: iconst_0
    //   1186: invokeinterface 946 2 0
    //   1191: invokeinterface 952 1 0
    //   1196: invokeinterface 955 1 0
    //   1201: putfield 1044	com/tencent/mobileqq/config/operation/QQOperationViopTipTask:clickableWord	Ljava/lang/String;
    //   1204: aload_1
    //   1205: ldc_w 1026
    //   1208: invokeinterface 935 2 0
    //   1213: iconst_0
    //   1214: invokeinterface 946 2 0
    //   1219: checkcast 1013	org/w3c/dom/Element
    //   1222: ldc_w 779
    //   1225: invokeinterface 1016 2 0
    //   1230: astore 4
    //   1232: aload 4
    //   1234: ifnull +59 -> 1293
    //   1237: aload 4
    //   1239: invokeinterface 940 1 0
    //   1244: ifle +49 -> 1293
    //   1247: aload_2
    //   1248: aload_1
    //   1249: ldc_w 1026
    //   1252: invokeinterface 935 2 0
    //   1257: iconst_0
    //   1258: invokeinterface 946 2 0
    //   1263: checkcast 1013	org/w3c/dom/Element
    //   1266: ldc_w 779
    //   1269: invokeinterface 1016 2 0
    //   1274: iconst_0
    //   1275: invokeinterface 946 2 0
    //   1280: invokeinterface 952 1 0
    //   1285: invokeinterface 955 1 0
    //   1290: putfield 1046	com/tencent/mobileqq/config/operation/QQOperationViopTipTask:url	Ljava/lang/String;
    //   1293: aload_2
    //   1294: areturn
    //   1295: sipush 3000
    //   1298: istore_3
    //   1299: goto -698 -> 601
    //   1302: astore_1
    //   1303: aload_1
    //   1304: invokevirtual 1047	javax/xml/parsers/ParserConfigurationException:printStackTrace	()V
    //   1307: aconst_null
    //   1308: areturn
    //   1309: astore_1
    //   1310: aload_1
    //   1311: invokevirtual 1048	org/xml/sax/SAXException:printStackTrace	()V
    //   1314: goto -7 -> 1307
    //   1317: astore_1
    //   1318: aload_1
    //   1319: invokevirtual 1049	java/io/IOException:printStackTrace	()V
    //   1322: goto -15 -> 1307
    //   1325: astore_1
    //   1326: aload_1
    //   1327: invokevirtual 458	java/lang/Exception:printStackTrace	()V
    //   1330: goto -23 -> 1307
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1333	0	this	amnh
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
      byte[] arrayOfByte = aknk.a((byte[])localObject);
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
        localObject2 = aknk.a((byte[])localObject1);
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
    //   0: getstatic 1166	cooperation/readinjoy/content/ReadInJoyDataProvider:e	Landroid/net/Uri;
    //   3: invokevirtual 1172	android/net/Uri:buildUpon	()Landroid/net/Uri$Builder;
    //   6: astore 5
    //   8: aload 5
    //   10: ldc_w 1174
    //   13: getstatic 15	amnh:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   16: invokevirtual 1180	android/net/Uri$Builder:appendQueryParameter	(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;
    //   19: pop
    //   20: aload 5
    //   22: invokevirtual 1184	android/net/Uri$Builder:build	()Landroid/net/Uri;
    //   25: astore 5
    //   27: new 1186	android/content/ContentValues
    //   30: dup
    //   31: invokespecial 1187	android/content/ContentValues:<init>	()V
    //   34: astore 6
    //   36: aload 6
    //   38: ldc_w 1189
    //   41: iload_1
    //   42: invokestatic 305	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   45: invokevirtual 1193	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   48: aload 6
    //   50: ldc_w 1195
    //   53: aload_2
    //   54: invokevirtual 1198	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   57: aload 6
    //   59: ldc_w 1200
    //   62: aload_3
    //   63: invokevirtual 1198	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   66: ldc_w 1202
    //   69: iconst_2
    //   70: anewarray 301	java/lang/Object
    //   73: dup
    //   74: iconst_0
    //   75: ldc_w 1195
    //   78: aastore
    //   79: dup
    //   80: iconst_1
    //   81: aload_2
    //   82: aastore
    //   83: invokestatic 309	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   86: astore_2
    //   87: aload 4
    //   89: invokevirtual 65	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   92: invokevirtual 1206	com/tencent/qphone/base/util/BaseApplication:getContentResolver	()Landroid/content/ContentResolver;
    //   95: aload 5
    //   97: aconst_null
    //   98: aload_2
    //   99: aconst_null
    //   100: aconst_null
    //   101: invokevirtual 1212	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   104: astore_2
    //   105: aload_2
    //   106: ifnull +148 -> 254
    //   109: aload_2
    //   110: invokeinterface 1217 1 0
    //   115: ifle +61 -> 176
    //   118: aload 4
    //   120: invokevirtual 65	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   123: invokevirtual 1206	com/tencent/qphone/base/util/BaseApplication:getContentResolver	()Landroid/content/ContentResolver;
    //   126: aload 5
    //   128: aload 6
    //   130: aconst_null
    //   131: aconst_null
    //   132: invokevirtual 1221	android/content/ContentResolver:update	(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   135: pop
    //   136: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   139: ifeq +12 -> 151
    //   142: ldc 183
    //   144: iconst_2
    //   145: ldc_w 1223
    //   148: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   151: aload 4
    //   153: invokevirtual 65	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   156: invokevirtual 1206	com/tencent/qphone/base/util/BaseApplication:getContentResolver	()Landroid/content/ContentResolver;
    //   159: aload 5
    //   161: aconst_null
    //   162: invokevirtual 1227	android/content/ContentResolver:notifyChange	(Landroid/net/Uri;Landroid/database/ContentObserver;)V
    //   165: aload_2
    //   166: ifnull +9 -> 175
    //   169: aload_2
    //   170: invokeinterface 1228 1 0
    //   175: return
    //   176: aload 4
    //   178: invokevirtual 65	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   181: invokevirtual 1206	com/tencent/qphone/base/util/BaseApplication:getContentResolver	()Landroid/content/ContentResolver;
    //   184: aload 5
    //   186: aload 6
    //   188: invokevirtual 1232	android/content/ContentResolver:insert	(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    //   191: pop
    //   192: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   195: ifeq -44 -> 151
    //   198: ldc 183
    //   200: iconst_2
    //   201: ldc_w 1234
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
    //   227: ldc_w 1236
    //   230: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   233: aload_3
    //   234: invokevirtual 798	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   237: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   240: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   243: aload_2
    //   244: ifnull -69 -> 175
    //   247: aload_2
    //   248: invokeinterface 1228 1 0
    //   253: return
    //   254: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   257: ifeq -106 -> 151
    //   260: ldc 183
    //   262: iconst_2
    //   263: ldc_w 1238
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
    //   284: invokeinterface 1228 1 0
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
    //   0	313	0	this	amnh
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
    NewIntent localNewIntent = new NewIntent(paramQQAppInterface.getApp(), amnh.class);
    localNewIntent.putExtra("k_cmd_type", new int[] { paramInt });
    if (!baip.a(paramString)) {
      localNewIntent.putExtra("key_uin", paramString);
    }
    if ((!paramQQAppInterface.isLogin()) && (paramInt == 215)) {
      localNewIntent.setWithouLogin(true);
    }
    paramQQAppInterface.startServlet(localNewIntent);
  }
  
  private void a(QQAppInterface paramQQAppInterface, Intent paramIntent, int[] paramArrayOfInt, Packet paramPacket)
  {
    ConfigurationService.ReqGetConfig localReqGetConfig = new ConfigurationService.ReqGetConfig();
    int n = paramArrayOfInt.length;
    ArrayList localArrayList1 = new ArrayList(n);
    ArrayList localArrayList2 = new ArrayList(n);
    int k = 0;
    ConfigurationService.ConfigSeq localConfigSeq;
    int i1;
    int j;
    int i;
    Object localObject6;
    boolean bool;
    if (k < n)
    {
      localConfigSeq = new ConfigurationService.ConfigSeq();
      i1 = paramArrayOfInt[k];
      localConfigSeq.type.set(i1);
      switch (i1)
      {
      case 4: 
      case 7: 
      case 8: 
      case 9: 
      case 11: 
      case 14: 
      case 15: 
      case 16: 
      case 17: 
      case 18: 
      case 19: 
      case 20: 
      case 21: 
      case 22: 
      case 24: 
      case 25: 
      case 26: 
      case 27: 
      case 28: 
      case 29: 
      case 30: 
      case 32: 
      case 33: 
      case 35: 
      case 36: 
      case 37: 
      case 39: 
      case 40: 
      case 41: 
      case 45: 
      case 48: 
      case 51: 
      case 52: 
      case 54: 
      case 58: 
      case 59: 
      case 60: 
      case 62: 
      case 67: 
      case 68: 
      case 70: 
      case 71: 
      case 76: 
      case 77: 
      case 81: 
      case 83: 
      case 85: 
      case 89: 
      case 91: 
      case 92: 
      case 95: 
      case 98: 
      case 99: 
      case 100: 
      case 103: 
      case 104: 
      case 105: 
      case 106: 
      case 107: 
      case 108: 
      case 110: 
      case 112: 
      case 114: 
      case 117: 
      case 122: 
      case 123: 
      case 124: 
      case 125: 
      case 126: 
      case 127: 
      case 128: 
      case 131: 
      case 132: 
      case 133: 
      case 134: 
      case 135: 
      case 136: 
      case 137: 
      case 138: 
      case 141: 
      case 144: 
      case 150: 
      case 151: 
      case 152: 
      case 154: 
      case 156: 
      case 158: 
      case 159: 
      case 160: 
      case 161: 
      case 162: 
      case 163: 
      case 164: 
      case 168: 
      case 169: 
      case 170: 
      case 172: 
      case 173: 
      case 175: 
      case 176: 
      case 178: 
      case 179: 
      case 183: 
      case 186: 
      case 189: 
      case 192: 
      case 196: 
      case 197: 
      case 198: 
      case 200: 
      case 203: 
      case 207: 
      case 208: 
      case 209: 
      case 213: 
      case 214: 
      case 216: 
      case 217: 
      case 219: 
      case 220: 
      case 221: 
      case 224: 
      case 229: 
      case 230: 
      case 233: 
      case 235: 
      case 236: 
      case 239: 
      case 240: 
      case 241: 
      case 242: 
      case 243: 
      case 246: 
      case 248: 
      case 249: 
      case 250: 
      case 251: 
      case 252: 
      case 258: 
      case 261: 
      case 263: 
      case 264: 
      case 265: 
      case 266: 
      case 270: 
      case 271: 
      case 275: 
      case 276: 
      case 277: 
      case 278: 
      case 282: 
      case 285: 
      case 287: 
      case 288: 
      case 290: 
      case 291: 
      case 292: 
      case 293: 
      case 294: 
      case 298: 
      case 299: 
      case 300: 
      case 302: 
      case 303: 
      case 304: 
      case 305: 
      case 306: 
      case 307: 
      case 309: 
      case 310: 
      case 311: 
      case 312: 
      case 315: 
      case 316: 
      case 317: 
      case 318: 
      case 319: 
      case 322: 
      case 323: 
      case 324: 
      case 325: 
      case 326: 
      case 327: 
      case 330: 
      case 332: 
      case 333: 
      case 334: 
      case 335: 
      case 338: 
      case 339: 
      case 340: 
      case 341: 
      case 342: 
      case 343: 
      case 344: 
      case 346: 
      case 348: 
      case 350: 
      case 352: 
      case 353: 
      case 354: 
      case 355: 
      case 356: 
      case 357: 
      case 358: 
      case 359: 
      case 361: 
      case 362: 
      case 363: 
      case 366: 
      case 367: 
      case 368: 
      case 369: 
      case 370: 
      case 372: 
      case 373: 
      case 374: 
      case 375: 
      case 376: 
      case 377: 
      case 378: 
      case 379: 
      case 380: 
      case 381: 
      case 382: 
      case 383: 
      case 386: 
      case 388: 
      case 389: 
      case 390: 
      case 391: 
      case 393: 
      case 395: 
      case 396: 
      case 398: 
      case 399: 
      case 401: 
      case 402: 
      case 405: 
      case 406: 
      case 407: 
      case 408: 
      case 409: 
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
            if (alzw.a().b(i1))
            {
              localObject1 = alzw.a();
              localObject6 = ((alzw)localObject1).a(i1);
              i = j;
              if (localObject6 != null)
              {
                i = ((alzl)localObject6).b(((alzw)localObject1).a(i1, jdField_a_of_type_JavaLangString));
                bool = ((alzw)localObject1).a(paramQQAppInterface, i1);
                if (bool)
                {
                  ((alzw)localObject1).a(i1, 0);
                  i = 0;
                }
                if (QLog.isColorLevel()) {
                  QLog.d("QConfigManager", 2, "[Send] t=" + i1 + " v=" + i + " up=" + bool);
                }
                localConfigSeq.version.set(i);
                if (!((alzw)localObject1).a(i1)) {
                  break label9525;
                }
                localConfigSeq.compress.set(1);
                break label9525;
              }
            }
            if (i == 0) {
              paramQQAppInterface.a().a(localConfigSeq, paramQQAppInterface, i1);
            }
          }
          catch (Exception localException2)
          {
            Object localObject1;
            label1917:
            String str;
            long l;
            int m;
            label3782:
            int i2;
            QLog.d("QConfigManager", 1, "exception " + i1, localException2);
            continue;
          }
          localArrayList1.add(localConfigSeq);
          localArrayList2.add(Integer.valueOf(i1));
          k += 1;
          break;
          localConfigSeq.version.set(baig.c(paramQQAppInterface.getApp()));
          continue;
          localConfigSeq.version.set(baig.g(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
          continue;
          baig.a(paramQQAppInterface.getApplication(), paramQQAppInterface.getCurrentAccountUin());
          if (paramQQAppInterface.getCurrentAccountUin() != null)
          {
            jdField_b_of_type_JavaLangString = paramQQAppInterface.getCurrentNickname();
            localObject1 = azyk.a(paramQQAppInterface, paramQQAppInterface.getCurrentAccountUin());
            if (localObject1 != null)
            {
              if (QLog.isColorLevel()) {
                QLog.i("SPLASH_ConfigServlet_birth", 2, "card!=null");
              }
              j = (int)((Card)localObject1).lBirthday;
              i = awbr.b(j);
              j = awbr.c(j);
              baig.b(paramQQAppInterface.getApp(), a(i, j));
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
            localConfigSeq.version.set(baig.h(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
            continue;
            localObject1 = (amnr)paramQQAppInterface.getManager(74);
            localConfigSeq.version.set(((amnr)localObject1).a());
            localObject6 = paramIntent.getStringExtra("key_province");
            localObject1 = localObject6;
            if (localObject6 == null) {
              localObject1 = "";
            }
            str = paramIntent.getStringExtra("key_city");
            localObject6 = str;
            if (str == null) {
              localObject6 = "";
            }
            localReqGetConfig.province.set((String)localObject1);
            localReqGetConfig.city.set((String)localObject6);
            continue;
            localConfigSeq.version.set(baig.i(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin()));
            continue;
            localConfigSeq.version.set(baig.j(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin()));
            continue;
            localConfigSeq.version.set(baig.b(paramQQAppInterface.getApp()));
            continue;
            localConfigSeq.version.set(PatchSharedPreUtil.getPatchConfigVersion(paramQQAppInterface.getApp()));
            localConfigSeq.compress.set(1);
            continue;
            BridgeHelper.a(BaseApplication.getContext(), jdField_a_of_type_JavaLangString).a();
            localConfigSeq.version.set(baig.a(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount()));
            continue;
            i = amom.a(BaseApplicationImpl.getContext());
            if (SettingCloneUtil.readValueForInt(BaseApplicationImpl.getContext(), jdField_a_of_type_JavaLangString, null, "qqsetting_calltab_show_key_version", 0) < i)
            {
              localConfigSeq.version.set(0);
            }
            else
            {
              localConfigSeq.version.set(baig.l(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount()));
              continue;
              i = amom.a(BaseApplicationImpl.getContext());
              if (SettingCloneUtil.readValueForInt(BaseApplicationImpl.getContext(), jdField_a_of_type_JavaLangString, null, "qqsetting_calltab_show_key_version", 0) < i)
              {
                localConfigSeq.version.set(0);
                paramIntent.putExtra("update101Version", i);
              }
              else
              {
                localConfigSeq.version.set(baig.k(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount()));
                continue;
                localObject1 = (ajof)paramQQAppInterface.getManager(102);
                localConfigSeq.version.set(((ajof)localObject1).a());
                continue;
                localConfigSeq.version.set(baig.o(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
                continue;
                localConfigSeq.version.set(baig.p(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
                continue;
                localConfigSeq.version.set(baig.f(paramQQAppInterface.getApp()));
                continue;
                localConfigSeq.version.set(baig.q(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
                continue;
                localConfigSeq.version.set(baig.r(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
                continue;
                if (!PtvTemplateManager.a())
                {
                  localConfigSeq.version.set(0);
                }
                else
                {
                  localConfigSeq.version.set(baig.h(paramQQAppInterface.getApp()));
                  continue;
                  if (!PtvTemplateManager.b())
                  {
                    localConfigSeq.version.set(0);
                    localConfigSeq.compress.set(1);
                  }
                  else
                  {
                    localConfigSeq.version.set(baig.j(paramQQAppInterface.getApp()));
                    continue;
                    if (!ausk.a())
                    {
                      localConfigSeq.version.set(0);
                      localConfigSeq.compress.set(1);
                    }
                    else
                    {
                      localConfigSeq.version.set(baig.i(paramQQAppInterface.getApp()));
                      continue;
                      i = 0;
                      if (PtvTemplateManager.c()) {
                        i = baig.k(paramQQAppInterface.getApp());
                      }
                      localConfigSeq.version.set(i);
                      localConfigSeq.compress.set(1);
                      if (QLog.isDevelopLevel())
                      {
                        QLog.d("Doodle_Strokes_SPLASH_ConfigServlet", 4, String.format("个性笔触配置版本号[%s]", new Object[] { Integer.valueOf(i) }));
                        continue;
                        i = baig.F(paramQQAppInterface.getApp());
                        localConfigSeq.version.set(i);
                        localConfigSeq.compress.set(1);
                        if (QLog.isDevelopLevel())
                        {
                          QLog.d("QQSTORY_FOLLOW_CAPTURE_SPLASH_ConfigServlet", 4, String.format("日迹合拍版本号[%s]", new Object[] { Integer.valueOf(i) }));
                          continue;
                          i = baig.aP(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
                          localConfigSeq.version.set(i);
                          localConfigSeq.compress.set(1);
                          if (QLog.isDevelopLevel())
                          {
                            QLog.d("QQSTORY_QUESTION_TAB_SPLASH_ConfigServlet", 4, String.format("日迹问答版本号[%s]", new Object[] { Integer.valueOf(i) }));
                            continue;
                            BusinessCommonConfig.getInstance(paramQQAppInterface).fillConfigVersion(i1, localConfigSeq);
                            continue;
                            localConfigSeq.version.set(baig.b(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount()));
                            continue;
                            localConfigSeq.version.set(baig.c(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount()));
                            continue;
                            localConfigSeq.version.set(baig.m(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
                            continue;
                            localConfigSeq.version.set(baig.n(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
                            continue;
                            localConfigSeq.version.set(baig.d(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
                            continue;
                            localConfigSeq.version.set(baig.F(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
                            l = paramIntent.getLongExtra("k_adcode", 0L);
                            localObject6 = paramIntent.getStringExtra("key_province");
                            localObject1 = localObject6;
                            if (localObject6 == null) {
                              localObject1 = "";
                            }
                            str = paramIntent.getStringExtra("key_city");
                            localObject6 = str;
                            if (str == null) {
                              localObject6 = "";
                            }
                            localReqGetConfig.province.set((String)localObject1);
                            localReqGetConfig.city.set((String)localObject6);
                            localReqGetConfig.adcode.set(l);
                            continue;
                            bool = xxj.a();
                            if (QLog.isColorLevel()) {
                              QLog.d("SPLASH_ConfigServlet", 2, "addAllConfigs, support ble=" + bool);
                            }
                            if (bool)
                            {
                              localConfigSeq.version.set(baig.e(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
                              continue;
                              bool = xxj.a();
                              if (QLog.isColorLevel()) {
                                QLog.d("SPLASH_ConfigServlet", 2, "addAllConfigs, support ble=" + bool);
                              }
                              if (bool)
                              {
                                localConfigSeq.version.set(baig.f(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
                                continue;
                                localConfigSeq.version.set(baig.s(paramQQAppInterface.getApp()));
                                continue;
                                i = baig.x(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
                                j = AppSetting.a();
                                if (i != j)
                                {
                                  baig.i(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, 0);
                                  baig.k(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, j);
                                  SearchConfigManager.a(paramQQAppInterface, jdField_a_of_type_JavaLangString);
                                }
                                localConfigSeq.version.set(baig.w(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
                                continue;
                                localConfigSeq.version.set(baig.G(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
                                continue;
                                localConfigSeq.version.set(baig.g(paramQQAppInterface.getApp()));
                                localConfigSeq.compress.set(1);
                                continue;
                                localConfigSeq.version.set(baig.t(paramQQAppInterface.getApp()));
                                continue;
                                localConfigSeq.version.set(baig.u(paramQQAppInterface.getApp()));
                                continue;
                                localConfigSeq.version.set(baig.v(paramQQAppInterface.getApp()));
                                continue;
                                localConfigSeq.version.set(baig.w(paramQQAppInterface.getApp()));
                                continue;
                                localConfigSeq.version.set(baig.A(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
                                continue;
                                localConfigSeq.version.set(baig.K(paramQQAppInterface.getApp(), paramQQAppInterface.c()));
                                continue;
                                localConfigSeq.version.set(baig.x(paramQQAppInterface.getApp()));
                                continue;
                                i = baig.B(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
                                localConfigSeq.version.set(i);
                                continue;
                                localConfigSeq.version.set(((ajls)paramQQAppInterface.getManager(159)).b());
                                continue;
                                i = baig.C(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
                                if (baig.y(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount()) != AppSetting.a()) {
                                  i = 0;
                                }
                                localConfigSeq.version.set(i);
                                continue;
                                localObject1 = (befs)paramQQAppInterface.a(146);
                                i = ((befs)localObject1).b(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
                                j = ((befs)localObject1).a(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
                                m = AppSetting.a();
                                if (j != m)
                                {
                                  i = 0;
                                  QLog.i("NCtr", 1, String.format("request NOTIFICATION_LIMIT_CONFIG localVersion: %d ,originalAppId:%d, currentAppId:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(m) }));
                                  localConfigSeq.version.set(i);
                                  continue;
                                  i = baig.at(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
                                  if (baig.au(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount()) != AppSetting.a()) {
                                    i = 0;
                                  }
                                  localConfigSeq.version.set(i);
                                  continue;
                                  i = baig.av(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
                                  if (baig.aw(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount()) != AppSetting.a()) {
                                    i = 0;
                                  }
                                  localConfigSeq.version.set(i);
                                  continue;
                                  localReqGetConfig = DeviceProfileManager.a(paramQQAppInterface);
                                  continue;
                                  localConfigSeq.version.set(baig.E(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
                                  continue;
                                  localConfigSeq.version.set(atub.a(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
                                  localConfigSeq.compress.set(1);
                                  localObject6 = paramIntent.getStringExtra("key_province");
                                  localObject1 = localObject6;
                                  if (localObject6 == null) {
                                    localObject1 = "";
                                  }
                                  str = paramIntent.getStringExtra("key_city");
                                  localObject6 = str;
                                  if (str == null) {
                                    localObject6 = "";
                                  }
                                  localReqGetConfig.province.set((String)localObject1);
                                  localReqGetConfig.city.set((String)localObject6);
                                  continue;
                                  localConfigSeq.version.set(baig.o(paramQQAppInterface.getApp()));
                                  continue;
                                  localConfigSeq.version.set(baig.p(paramQQAppInterface.getApp()));
                                  continue;
                                  localConfigSeq.version.set(baig.L(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin()));
                                  continue;
                                  localConfigSeq.version.set(baig.O(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
                                  continue;
                                  localConfigSeq.version.set(baig.J(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin()));
                                  continue;
                                  localConfigSeq.version.set(baig.a(paramQQAppInterface.getApp(), "shop_tab", jdField_a_of_type_JavaLangString));
                                  continue;
                                  localObject1 = (OlympicManager)paramQQAppInterface.getManager(167);
                                  if (localObject1 == null) {
                                    continue;
                                  }
                                  ((OlympicManager)localObject1).c();
                                  localObject1 = ((OlympicManager)localObject1).a();
                                  i = 0;
                                  if (localObject1 != null) {
                                    i = ((OlympicActConfig)localObject1).version;
                                  }
                                  localConfigSeq.version.set(i);
                                  localConfigSeq.compress.set(1);
                                  paramIntent.putExtra("config_version", i);
                                  if (QLog.isColorLevel()) {
                                    QLog.d("Olympic.OLYMPIC_ACT_RESOURCE_CONFIG_INFO", 2, new Object[] { "oldVersion=", Integer.valueOf(i) });
                                  }
                                  if (!atiu.a(BaseApplicationImpl.getContext(), "olympic_config_act_get")) {
                                    continue;
                                  }
                                  if (QLog.isColorLevel()) {
                                    QLog.d("Olympic.configServlet", 2, new Object[] { "check24Hour, result=true, do Report, key=", "olympic_config_act_get" });
                                  }
                                  awrn.a(BaseApplicationImpl.getContext()).a("", "olympic_config_act_get", true, 0L, 0L, null, "", false);
                                  atiu.a(BaseApplicationImpl.getContext(), "olympic_config_act_get");
                                  continue;
                                  localObject1 = (aknw)paramQQAppInterface.getManager(168);
                                  if (localObject1 == null) {
                                    continue;
                                  }
                                  i2 = ((aknw)localObject1).b();
                                  m = 0;
                                  i = 0;
                                  localObject6 = BaseApplicationImpl.getApplication();
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
            int i3 = ((Context)localObject6).getPackageManager().getPackageInfo(((Context)localObject6).getPackageName(), 0).versionCode;
            j = m;
            m = ((aknw)localObject1).a();
            if ((m == 0) || (i3 != m)) {
              break label9531;
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
            localObject6 = paramIntent.getStringExtra("key_province");
            localObject1 = localObject6;
            if (localObject6 == null) {
              localObject1 = "";
            }
            str = paramIntent.getStringExtra("key_city");
            localObject6 = str;
            if (str == null) {
              localObject6 = "";
            }
            localReqGetConfig.province.set((String)localObject1);
            localReqGetConfig.city.set((String)localObject6);
            paramIntent.putExtra("key_config_version", i2);
            break;
          }
          Object localObject2 = (akiu)paramQQAppInterface.getManager(220);
          if (localObject2 == null) {
            break;
          }
          i = ((akiu)localObject2).b();
          if (QLog.isColorLevel()) {
            QLog.d("handleResp_GetArGlobalConfig", 2, " local version = " + i);
          }
          if (((akiu)localObject2).a()) {
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
          localObject2 = (akiu)paramQQAppInterface.getManager(220);
          if (localObject2 == null) {
            break;
          }
          i = ((akiu)localObject2).c();
          localConfigSeq.version.set(i);
          localConfigSeq.compress.set(1);
          paramIntent.putExtra("ar_scan_star_face_config_version", i);
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("SPLASH_ConfigServlet", 2, " get AR_SCAN_STAR_FACE_CONFIG, version = " + i);
          break;
          i = akoa.a(paramQQAppInterface);
          localConfigSeq.version.set(i);
          localConfigSeq.compress.set(1);
          paramIntent.putExtra("key_download_cfg_version", i);
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("SPLASH_ConfigServlet", 2, " get AR_SCAN_FACE_PRE_DOWN_CONFIG, version = " + i);
          break;
          localObject2 = (aknw)paramQQAppInterface.getManager(168);
          if (localObject2 == null) {
            break;
          }
          i = ((aknw)localObject2).c();
          localConfigSeq.version.set(i);
          localConfigSeq.compress.set(1);
          paramIntent.putExtra("key_ar_entrance_effect_version", i);
          break;
          i = baig.a(paramQQAppInterface.getApp(), "readinjoy_interested_push_config", jdField_a_of_type_JavaLangString);
          localConfigSeq.version.set(i);
          break;
          localObject2 = (PhoneContactManagerImp)paramQQAppInterface.getManager(11);
          localConfigSeq.version.set(((PhoneContactManagerImp)localObject2).f());
          break;
          ksm.a(i1, jdField_a_of_type_JavaLangString, localConfigSeq);
          break;
          i = alrg.a(BaseApplicationImpl.getContext());
          localConfigSeq.version.set(i);
          localConfigSeq.compress.set(1);
          paramIntent.putExtra("qcamera_conf_version", i);
          paramIntent.putExtra("uin", paramQQAppInterface.getCurrentAccountUin());
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.i("Q.camera.configServlet", 2, "request QCAMERA_PHONE_CONFIG version: " + i);
          break;
          i = baig.a(paramQQAppInterface.getApp(), "change_machine_version", jdField_a_of_type_JavaLangString);
          localConfigSeq.version.set(i);
          break;
          i = baig.H(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
          if (QLog.isColorLevel()) {
            QLog.d("SPLASH_ConfigServlet", 2, "addAllConfigs|GET_CONFIG_UPGRADE version=" + i);
          }
          localConfigSeq.version.set(i);
          paramQQAppInterface.o();
          bcfa.a(paramQQAppInterface.getApp(), String.valueOf(AppSetting.a()));
          ((ajgd)paramQQAppInterface.a(4)).b();
          break;
          i = baig.I(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
          localConfigSeq.version.set(i);
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("UpgradeTIMWrapper", 2, "ConfigServlet req :193, version: " + i);
          break;
          i = baig.a(paramQQAppInterface.getApp(), "now_entrance_action_version", jdField_a_of_type_JavaLangString);
          localConfigSeq.version.set(i);
          break;
          i = baig.a(paramQQAppInterface.getApp(), "troop_common_config_version", jdField_a_of_type_JavaLangString);
          localConfigSeq.version.set(i);
          break;
          i = baig.a(paramQQAppInterface.getApp(), "nearby_config_version", jdField_a_of_type_JavaLangString);
          localConfigSeq.version.set(i);
          break;
          i = baig.a(paramQQAppInterface.getApp(), "nearby_nowlive_tab_config_version", jdField_a_of_type_JavaLangString);
          localConfigSeq.version.set(i);
          break;
          localConfigSeq.version.set(baig.P(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount()));
          localConfigSeq.compress.set(1);
          break;
          localObject2 = (ajei)paramQQAppInterface.a(53);
          if (localObject2 == null) {
            break;
          }
          i = AppSetting.a();
          if (i != ((ajei)localObject2).b(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString))
          {
            ((ajei)localObject2).a(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, 0);
            ((ajei)localObject2).b(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, i);
            ((ajei)localObject2).a(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, true);
            ((ajei)localObject2).c();
          }
          localConfigSeq.version.set(((ajei)localObject2).a(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
          break;
          localConfigSeq.version.set(baig.R(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
          localConfigSeq.version.set(baig.S(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
          localConfigSeq.compress.set(1);
          break;
          localConfigSeq.version.set(baig.D(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
          break;
          localConfigSeq.version.set(avwc.a());
          break;
          i = avis.a(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin());
          localConfigSeq.version.set(i);
          break;
          i = baig.a(paramQQAppInterface.getApp(), "nearby_glamour_level_config_version", jdField_a_of_type_JavaLangString);
          localConfigSeq.version.set(i);
          localConfigSeq.compress.set(1);
          break;
          localConfigSeq.version.set(baig.U(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
          break;
          if (baig.a(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, 1) != AppSetting.a())
          {
            baig.d(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, 1, AppSetting.a());
            baig.d(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, 2, 0);
            localConfigSeq.version.set(0);
            break;
          }
          localConfigSeq.version.set(baig.a(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, 2));
          break;
          try
          {
            if (((Integer)baig.a(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, 1)).intValue() == AppSetting.a()) {
              break label5861;
            }
            baig.a(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, 1, Integer.valueOf(AppSetting.a()));
            baig.a(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, 2, Integer.valueOf(0));
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
        label5861:
        i = ((Integer)baig.a(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, 2)).intValue();
        localConfigSeq.version.set(i);
        break;
        localConfigSeq.version.set(baig.X(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
        break;
        if (!PtvTemplateManager.d()) {
          localConfigSeq.version.set(0);
        }
        for (;;)
        {
          localConfigSeq.compress.set(1);
          break;
          localConfigSeq.version.set(baig.m(paramQQAppInterface.getApp()));
        }
        localConfigSeq.version.set(baig.V(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
        break;
        localConfigSeq.version.set(baig.aa(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
        localConfigSeq.compress.set(1);
        break;
        localConfigSeq.version.set(baig.ac(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
        localConfigSeq.compress.set(1);
        break;
        Object localObject3 = (vju)paramQQAppInterface.getManager(208);
        localConfigSeq.version.set(((vju)localObject3).a.a(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
        break;
        localConfigSeq.version.set(baig.Z(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
        localConfigSeq.compress.set(1);
        break;
        localConfigSeq.version.set(rsp.c(paramQQAppInterface));
        break;
        i = baig.ak(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
        j = AppSetting.a();
        if (i != j)
        {
          baig.I(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, 0);
          baig.J(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, j);
        }
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("SPLASH_ConfigServlet", 2, "[Doutu]onsend : appIdRecord = " + i + ", appId = " + j + ", DOUTU_CONFI version = " + baig.ah(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
          }
          localConfigSeq.version.set(baig.ah(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
          localConfigSeq.compress.set(1);
          break;
          localObject3 = (amxv)getAppRuntime().getManager(214);
          if (localObject3 != null) {
            ((amxv)localObject3).b(false);
          }
        }
        i = baig.s(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
        j = AppSetting.a();
        if (i != j)
        {
          baig.f(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, 0);
          baig.e(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, j);
        }
        if (QLog.isColorLevel()) {
          QLog.d("SPLASH_ConfigServlet", 2, "[GreenVideo]onsend : appIdRecord = " + i + ", appId = " + j + ", GREEN_VIDEO_CONFI version = " + baig.t(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
        }
        localConfigSeq.version.set(baig.t(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
        localConfigSeq.compress.set(1);
        break;
        i = baig.u(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
        j = AppSetting.a();
        if (i != j)
        {
          baig.h(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, 0);
          baig.g(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, j);
        }
        if (QLog.isColorLevel()) {
          QLog.d("SPLASH_ConfigServlet", 2, "[VideoCompress]onsend : appIdRecord = " + i + ", appId = " + j + ", VIDEO_REDBAG_CONFI version = " + baig.am(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
        }
        localConfigSeq.version.set(baig.v(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
        localConfigSeq.compress.set(1);
        break;
        if (((Integer)asfc.a(jdField_a_of_type_JavaLangString, "key_app_id", Integer.valueOf(0))).intValue() != AppSetting.a())
        {
          asfc.a(jdField_a_of_type_JavaLangString, "key_tabs_config_version", Integer.valueOf(0));
          asfc.a(jdField_a_of_type_JavaLangString, "key_app_id", Integer.valueOf(AppSetting.a()));
        }
        i = ((Integer)asfc.a(jdField_a_of_type_JavaLangString, "key_tabs_config_version", Integer.valueOf(0))).intValue();
        localConfigSeq.version.set(i);
        localConfigSeq.compress.set(1);
        localObject6 = paramIntent.getStringExtra("key_province");
        localObject3 = localObject6;
        if (localObject6 == null) {
          localObject3 = "";
        }
        str = paramIntent.getStringExtra("key_city");
        localObject6 = str;
        if (str == null) {
          localObject6 = "";
        }
        localReqGetConfig.province.set((String)localObject3);
        localReqGetConfig.city.set((String)localObject6);
        break;
        i = wmp.a(jdField_a_of_type_JavaLangString);
        localConfigSeq.version.set(i);
        localConfigSeq.compress.set(1);
        break;
        localConfigSeq.version.set(axaf.a(paramQQAppInterface));
        localConfigSeq.compress.set(1);
        break;
        localConfigSeq.version.set(baig.af(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
        localConfigSeq.compress.set(1);
        break;
        localConfigSeq.version.set(baig.ab(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
        localConfigSeq.compress.set(1);
        break;
        localConfigSeq.version.set(adyt.a(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
        localConfigSeq.compress.set(1);
        break;
        i = baig.a(paramQQAppInterface.getApp(), "change_machine_version", jdField_a_of_type_JavaLangString);
        localConfigSeq.version.set(i);
        break;
        i = baig.a(paramQQAppInterface.getApp(), "nearby_auth_video_config_version", jdField_a_of_type_JavaLangString);
        localConfigSeq.version.set(i);
        break;
        localConfigSeq.version.set(baig.ap(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
        break;
        localConfigSeq.version.set(baig.z(paramQQAppInterface.getApp()));
        break;
        localConfigSeq.version.set(baig.aq(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
        break;
        localConfigSeq.version.set(ahkg.a(paramQQAppInterface.getApp()));
        localConfigSeq.compress.set(1);
        break;
        localConfigSeq.version.set(ausu.a(paramQQAppInterface.getApp()));
        localConfigSeq.compress.set(1);
        break;
        a(localReqGetConfig, localConfigSeq, paramQQAppInterface);
        break;
        i = baig.a(paramQQAppInterface.getApp(), "search_function_config_version", jdField_a_of_type_JavaLangString);
        localConfigSeq.version.set(i);
        localConfigSeq.compress.set(1);
        break;
        i = ((atdp)paramQQAppInterface.getManager(228)).a();
        localConfigSeq.version.set(i);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("SPLASH_ConfigServlet", 2, "ConfigServlet OCR_CONFIG ocrVersion:" + i);
        break;
        i = baig.as(BaseApplicationImpl.getContext(), jdField_a_of_type_JavaLangString);
        localConfigSeq.version.set(i);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("SPLASH_ConfigServlet", 2, "ConfigServlet receipt ,receiptVersion:" + i);
        break;
        i = baig.aW(BaseApplicationImpl.getContext(), jdField_a_of_type_JavaLangString);
        localConfigSeq.version.set(i);
        break;
        i = baig.aX(BaseApplicationImpl.getContext(), jdField_a_of_type_JavaLangString);
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
        ahml.a(paramQQAppInterface, localConfigSeq, true, jdField_a_of_type_JavaLangString);
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
        paramQQAppInterface.a().a(localConfigSeq, paramQQAppInterface, i1);
        localObject3 = (anoe)paramQQAppInterface.getManager(264);
        try
        {
          ((anoe)localObject3).a();
        }
        catch (Exception localException1)
        {
          QLog.e("SPLASH_ConfigServlet", 1, "get local extend friend exception:", localException1);
        }
      }
      break label1917;
      i = baig.d(paramQQAppInterface.getApp());
      localConfigSeq.version.set(i);
      break label1917;
      i = paramQQAppInterface.getPreferences().getInt("tim_aio_tips_bar_version", 0);
      localConfigSeq.version.set(i);
      localConfigSeq.compress.set(1);
      break label1917;
      i = awkj.a(paramQQAppInterface.getApp());
      localConfigSeq.version.set(i);
      localConfigSeq.compress.set(1);
      break label1917;
      i = paramQQAppInterface.getPreferences().getInt("data_migration_tim_version", 0);
      localConfigSeq.version.set(i);
      localConfigSeq.compress.set(1);
      break label1917;
      i = baig.a(paramQQAppInterface.getApp(), "nearby_videochat_dialog_config_version", jdField_a_of_type_JavaLangString);
      localConfigSeq.version.set(i);
      break label1917;
      i = baig.a(paramQQAppInterface.getApp(), "nearby_videochat_banner_config_version", jdField_a_of_type_JavaLangString);
      localConfigSeq.version.set(i);
      break label1917;
      i = paramQQAppInterface.getPreferences().getInt("zhitu_config_version", 0);
      localConfigSeq.version.set(i);
      localConfigSeq.compress.set(1);
      break label1917;
      i = paramQQAppInterface.getPreferences().getInt("homework_troop_config_version", 0);
      localConfigSeq.version.set(i);
      localConfigSeq.compress.set(1);
      break label1917;
      Object localObject4 = (TroopManager)paramQQAppInterface.getManager(52);
      localConfigSeq.version.set(((TroopManager)localObject4).jdField_a_of_type_Ayvu.a(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
      localConfigSeq.compress.set(1);
      break label1917;
      i = paramQQAppInterface.getPreferences().getInt("new_troop_recommend", 0);
      localConfigSeq.version.set(i);
      localConfigSeq.compress.set(1);
      break label1917;
      localObject4 = (TroopManager)paramQQAppInterface.getManager(52);
      localConfigSeq.version.set(((TroopManager)localObject4).jdField_a_of_type_Ayxk.a(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
      localConfigSeq.compress.set(1);
      break label1917;
      i = RecentDanceConfigMgr.a();
      localConfigSeq.version.set(i);
      localConfigSeq.compress.set(1);
      break label1917;
      i = aqcb.a().a.a();
      localConfigSeq.version.set(i);
      localConfigSeq.compress.set(1);
      break label1917;
      i = LightVideoConfigMgr.a();
      localConfigSeq.version.set(i);
      localConfigSeq.compress.set(1);
      break label1917;
      localConfigSeq.version.set(baig.a(paramQQAppInterface.getApp(), "sport_config", jdField_a_of_type_JavaLangString));
      localConfigSeq.compress.set(1);
      break label1917;
      i = baig.a(paramQQAppInterface.getApplication(), "troop_gift_anim_limit", "0");
      localConfigSeq.version.set(i);
      break label1917;
      localConfigSeq.version.set(0);
      localConfigSeq.compress.set(1);
      break label1917;
      i = paramQQAppInterface.getPreferences().getInt("task_entry_config_version", 0);
      localConfigSeq.version.set(i);
      localConfigSeq.compress.set(1);
      break label1917;
      i = paramQQAppInterface.getPreferences().getInt("qzone_xp_config_version", 0);
      localConfigSeq.version.set(i);
      break label1917;
      i = paramQQAppInterface.getPreferences().getInt("buluo_enter_config_version" + paramQQAppInterface.c(), 0);
      localConfigSeq.version.set(i);
      localConfigSeq.compress.set(1);
      break label1917;
      localConfigSeq.version.set(baig.aC(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
      break label1917;
      i = baig.aE(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
      if (baig.aF(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount()) != AppSetting.a()) {
        i = 0;
      }
      localConfigSeq.version.set(i);
      break label1917;
      i = bjef.a().a(paramQQAppInterface.getApp());
      localConfigSeq.version.set(i);
      localConfigSeq.compress.set(1);
      break label1917;
      i = bjim.a().a(paramQQAppInterface.getApp());
      localConfigSeq.version.set(i);
      localConfigSeq.compress.set(1);
      break label1917;
      localObject4 = (sga)paramQQAppInterface.getManager(181);
      localConfigSeq.version.set(((sga)localObject4).a.a(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
      localConfigSeq.compress.set(1);
      break label1917;
      localConfigSeq.version.set(baig.a());
      localConfigSeq.compress.set(1);
      break label1917;
      i = baig.aH(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
      if (baig.aI(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount()) != AppSetting.a()) {
        i = 0;
      }
      localConfigSeq.version.set(i);
      break label1917;
      localConfigSeq.version.set(baig.Q(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount()));
      localConfigSeq.compress.set(1);
      break label1917;
      i = baig.a(paramQQAppInterface.getApp(), "wifi_connect_config_version", jdField_a_of_type_JavaLangString);
      localConfigSeq.version.set(i);
      break label1917;
      localObject4 = (TroopManager)paramQQAppInterface.getManager(52);
      localConfigSeq.version.set(((TroopManager)localObject4).jdField_a_of_type_Wml.a(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
      localConfigSeq.compress.set(1);
      break label1917;
      yjx.a(localConfigSeq);
      break label1917;
      i = baig.aQ(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
      localConfigSeq.version.set(i);
      break label1917;
      localConfigSeq.version.set(baig.ay(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
      localConfigSeq.compress.set(1);
      break label1917;
      i = baig.aT(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
      if (baig.aU(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount()) != AppSetting.a()) {
        i = 0;
      }
      localConfigSeq.version.set(i);
      break label1917;
      i = badd.a();
      localConfigSeq.version.set(i);
      localConfigSeq.compress.set(1);
      if (!QLog.isColorLevel()) {
        break label1917;
      }
      QLog.i("JumpForwardPkgManager", 2, "JUMP_PKG_TOAST_CONFIG  ,version:" + i);
      break label1917;
      i = bgmp.a(paramQQAppInterface);
      localConfigSeq.version.set(i);
      localConfigSeq.compress.set(1);
      break label1917;
      i = aemi.a(paramQQAppInterface);
      localConfigSeq.version.set(i);
      localConfigSeq.compress.set(1);
      break label1917;
      if (QLog.isColorLevel())
      {
        i = localArrayList2.size();
        localObject5 = localArrayList2.iterator();
        while (((Iterator)localObject5).hasNext())
        {
          localObject6 = (Integer)((Iterator)localObject5).next();
          QLog.d("SPLASH_ConfigServlet", 2, "addAllConfigs|send type: " + localObject6 + ",length: " + i);
        }
      }
      Object localObject5 = new ConfigurationService.DeviceInfo();
      if ((localArrayList2.contains(Integer.valueOf(1))) || (localArrayList2.contains(Integer.valueOf(2))) || (localArrayList2.contains(Integer.valueOf(3))) || (localArrayList2.contains(Integer.valueOf(12))))
      {
        localObject6 = new ConfigurationService.Screen();
        ((ConfigurationService.Screen)localObject6).setHasFlag(true);
        ((ConfigurationService.Screen)localObject6).width.set((int)babp.i());
        ((ConfigurationService.Screen)localObject6).height.set((int)babp.j());
        ((ConfigurationService.DeviceInfo)localObject5).screen = ((ConfigurationService.Screen)localObject6);
        ((ConfigurationService.DeviceInfo)localObject5).setHasFlag(true);
        localReqGetConfig.device_info = ((ConfigurationService.DeviceInfo)localObject5);
      }
      if ((localArrayList2.contains(Integer.valueOf(47))) || (localArrayList2.contains(Integer.valueOf(65))) || (localArrayList2.contains(Integer.valueOf(156))) || (localArrayList2.contains(Integer.valueOf(297))))
      {
        localObject6 = new ConfigurationService.OS();
        ((ConfigurationService.OS)localObject6).setHasFlag(true);
        ((ConfigurationService.OS)localObject6).type.set(2);
        ((ConfigurationService.OS)localObject6).kernel.set(babp.m());
        ((ConfigurationService.OS)localObject6).sdk.set(String.valueOf(babp.a()));
        ((ConfigurationService.OS)localObject6).version.set(babp.e());
        ((ConfigurationService.OS)localObject6).rom.set(babp.j());
        ((ConfigurationService.DeviceInfo)localObject5).brand.set(babp.h());
        ((ConfigurationService.DeviceInfo)localObject5).model.set(babp.d());
        if (QLog.isDevelopLevel()) {
          QLog.w("SPLASH_ConfigServlet", 1, "addAllConfigs, brand[" + ((ConfigurationService.DeviceInfo)localObject5).brand.get() + "], model[" + ((ConfigurationService.DeviceInfo)localObject5).model.get() + "]");
        }
        ((ConfigurationService.DeviceInfo)localObject5).os = ((ConfigurationService.OS)localObject6);
        ((ConfigurationService.DeviceInfo)localObject5).setHasFlag(true);
        localReqGetConfig.device_info = ((ConfigurationService.DeviceInfo)localObject5);
      }
      localReqGetConfig.setHasFlag(true);
      localReqGetConfig.seq_list.addAll(localArrayList1);
      if (paramIntent != null)
      {
        bool = paramIntent.getBooleanExtra("key_is_page_req", false);
        localObject5 = localReqGetConfig.is_page_req;
        if (!bool) {
          break label9507;
        }
      }
      label9507:
      for (i = 1;; i = 0)
      {
        ((PBInt32Field)localObject5).set(i);
        paramIntent = paramIntent.getByteArrayExtra("key_cookies");
        if (paramIntent != null) {
          localReqGetConfig.cookies.set(ByteStringMicro.copyFrom(paramIntent));
        }
        paramIntent = a(localReqGetConfig);
        if ((paramIntent != null) && (paramIntent.length > 0)) {
          paramPacket.putSendData(paramIntent);
        }
        if ((paramArrayOfInt == null) || (paramArrayOfInt.length != 1) || (paramArrayOfInt[0] != 215) || (paramQQAppInterface.isLogin())) {
          break;
        }
        paramPacket.setSSOCommand("ConfigurationService.ReqGetConfigNoLogin");
        return;
      }
      paramPacket.setSSOCommand("ConfigurationService.ReqGetConfig");
      return;
      break label3782;
      label9525:
      i = 1;
      break;
      label9531:
      i = 1;
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig, int paramInt)
  {
    int i = paramConfig.version.get();
    int j = bgmp.a(paramQQAppInterface);
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
      bgmp.a(paramQQAppInterface, new JSONObject(paramConfig).optInt("hot_video_enable", 0));
      bgmp.b(paramQQAppInterface, i);
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
    NewIntent localNewIntent = new NewIntent(paramQQAppInterface.getApp(), amnh.class);
    int[] arrayOfInt = new int[jdField_a_of_type_ArrayOfInt.length + alzw.jdField_a_of_type_ArrayOfInt.length];
    System.arraycopy(jdField_a_of_type_ArrayOfInt, 0, arrayOfInt, 0, jdField_a_of_type_ArrayOfInt.length);
    System.arraycopy(alzw.jdField_a_of_type_ArrayOfInt, 0, arrayOfInt, jdField_a_of_type_ArrayOfInt.length, alzw.jdField_a_of_type_ArrayOfInt.length);
    localNewIntent.putExtra("k_cmd_type", arrayOfInt);
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
        if ((paramInt == -1) || (baig.s(paramQQAppInterface.getApp()) != paramInt)) {
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
    //   4: getstatic 15	amnh:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   7: invokestatic 2319	baig:ai	(Landroid/content/Context;Ljava/lang/String;)I
    //   10: invokestatic 203	com/tencent/common/config/AppSetting:a	()I
    //   13: if_icmpeq +114 -> 127
    //   16: aload_3
    //   17: invokevirtual 65	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   20: getstatic 15	amnh:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   23: invokestatic 203	com/tencent/common/config/AppSetting:a	()I
    //   26: invokestatic 2321	baig:G	(Landroid/content/Context;Ljava/lang/String;I)V
    //   29: aload_3
    //   30: invokevirtual 65	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   33: getstatic 15	amnh:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   36: iconst_0
    //   37: invokestatic 2323	baig:H	(Landroid/content/Context;Ljava/lang/String;I)V
    //   40: iconst_0
    //   41: istore 4
    //   43: aload_2
    //   44: getfield 1320	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$ConfigSeq:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   47: iload 4
    //   49: invokevirtual 1287	com/tencent/mobileqq/pb/PBInt32Field:set	(I)V
    //   52: invokestatic 2325	babp:a	()Ljava/util/ArrayList;
    //   55: astore 5
    //   57: aload 5
    //   59: ifnull +119 -> 178
    //   62: aload 5
    //   64: invokevirtual 2326	java/util/ArrayList:size	()I
    //   67: ifle +111 -> 178
    //   70: aload 5
    //   72: invokevirtual 2327	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   75: astore_2
    //   76: aload_2
    //   77: invokeinterface 238 1 0
    //   82: ifeq +96 -> 178
    //   85: aload_2
    //   86: invokeinterface 242 1 0
    //   91: checkcast 139	java/lang/Integer
    //   94: astore 6
    //   96: aload_1
    //   97: getfield 2330	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$ReqGetConfig:carriers	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   100: aload 6
    //   102: invokevirtual 2333	com/tencent/mobileqq/pb/PBRepeatField:add	(Ljava/lang/Object;)V
    //   105: goto -29 -> 76
    //   108: astore_1
    //   109: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   112: ifeq +14 -> 126
    //   115: ldc_w 2335
    //   118: iconst_2
    //   119: ldc_w 2337
    //   122: aload_1
    //   123: invokestatic 1831	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   126: return
    //   127: aload_3
    //   128: invokevirtual 65	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   131: getstatic 15	amnh:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   134: invokestatic 2339	baig:aj	(Landroid/content/Context;Ljava/lang/String;)I
    //   137: istore 4
    //   139: goto -96 -> 43
    //   142: astore_2
    //   143: ldc 183
    //   145: iconst_2
    //   146: new 85	java/lang/StringBuilder
    //   149: dup
    //   150: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   153: ldc_w 2341
    //   156: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: aload_2
    //   160: invokevirtual 862	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   163: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   169: invokestatic 642	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   172: aconst_null
    //   173: astore 5
    //   175: goto -118 -> 57
    //   178: aload_3
    //   179: bipush 11
    //   181: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   184: checkcast 2343	aroh
    //   187: invokeinterface 2346 1 0
    //   192: astore 6
    //   194: aload 6
    //   196: ifnull +229 -> 425
    //   199: aload 6
    //   201: getfield 2351	SecurityAccountServer/RespondQueryQQBindingStat:nationCode	Ljava/lang/String;
    //   204: astore_3
    //   205: aload_3
    //   206: astore_2
    //   207: aload_3
    //   208: ifnull +21 -> 229
    //   211: aload_3
    //   212: astore_2
    //   213: aload_3
    //   214: ldc_w 2353
    //   217: invokevirtual 2356	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   220: ifeq +9 -> 229
    //   223: aload_3
    //   224: iconst_1
    //   225: invokevirtual 2359	java/lang/String:substring	(I)Ljava/lang/String;
    //   228: astore_2
    //   229: aload_2
    //   230: invokestatic 126	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   233: ifeq +130 -> 363
    //   236: aload 6
    //   238: getfield 2362	SecurityAccountServer/RespondQueryQQBindingStat:mobileNo	Ljava/lang/String;
    //   241: invokestatic 126	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   244: ifeq +119 -> 363
    //   247: ldc 13
    //   249: astore_2
    //   250: aload_2
    //   251: invokestatic 126	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   254: ifne +11 -> 265
    //   257: aload_1
    //   258: getfield 2365	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$ReqGetConfig:bind_phone_no	Lcom/tencent/mobileqq/pb/PBStringField;
    //   261: aload_2
    //   262: invokevirtual 1403	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   265: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   268: ifeq -142 -> 126
    //   271: new 85	java/lang/StringBuilder
    //   274: dup
    //   275: bipush 100
    //   277: invokespecial 2366	java/lang/StringBuilder:<init>	(I)V
    //   280: astore_1
    //   281: aload_1
    //   282: ldc_w 2368
    //   285: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   288: iload 4
    //   290: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   293: ldc_w 2370
    //   296: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   299: aload_2
    //   300: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   303: pop
    //   304: aload_1
    //   305: ldc_w 2372
    //   308: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   311: pop
    //   312: aload 5
    //   314: ifnull +91 -> 405
    //   317: aload 5
    //   319: invokevirtual 2326	java/util/ArrayList:size	()I
    //   322: ifle +83 -> 405
    //   325: aload 5
    //   327: invokevirtual 2327	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   330: astore_2
    //   331: aload_2
    //   332: invokeinterface 238 1 0
    //   337: ifeq +68 -> 405
    //   340: aload_1
    //   341: aload_2
    //   342: invokeinterface 242 1 0
    //   347: checkcast 139	java/lang/Integer
    //   350: invokevirtual 798	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   353: ldc_w 2374
    //   356: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   359: pop
    //   360: goto -29 -> 331
    //   363: invokestatic 1082	java/util/Locale:getDefault	()Ljava/util/Locale;
    //   366: astore 7
    //   368: aload_2
    //   369: astore_3
    //   370: aload_2
    //   371: ifnonnull +6 -> 377
    //   374: ldc 13
    //   376: astore_3
    //   377: aload 7
    //   379: ldc_w 2376
    //   382: iconst_2
    //   383: anewarray 301	java/lang/Object
    //   386: dup
    //   387: iconst_0
    //   388: aload_3
    //   389: aastore
    //   390: dup
    //   391: iconst_1
    //   392: aload 6
    //   394: getfield 2362	SecurityAccountServer/RespondQueryQQBindingStat:mobileNo	Ljava/lang/String;
    //   397: aastore
    //   398: invokestatic 1087	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   401: astore_2
    //   402: goto -152 -> 250
    //   405: aload_1
    //   406: ldc_w 2212
    //   409: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   412: pop
    //   413: ldc_w 2335
    //   416: iconst_2
    //   417: aload_1
    //   418: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   421: invokestatic 199	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   424: return
    //   425: ldc 13
    //   427: astore_2
    //   428: goto -178 -> 250
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	431	0	this	amnh
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
    //   6: getfield 2384	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:result	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   9: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   12: ifne +20 -> 32
    //   15: aload_1
    //   16: getfield 2387	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:config_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   19: ifnull +13 -> 32
    //   22: aload_1
    //   23: getfield 2387	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:config_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   26: invokevirtual 224	com/tencent/mobileqq/pb/PBRepeatMessageField:size	()I
    //   29: ifne +2001 -> 2030
    //   32: iload 5
    //   34: ifne +426 -> 460
    //   37: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   40: ifeq +12 -> 52
    //   43: ldc 183
    //   45: iconst_2
    //   46: ldc_w 2389
    //   49: invokestatic 199	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   52: iconst_0
    //   53: istore 7
    //   55: iload 7
    //   57: aload 4
    //   59: arraylength
    //   60: if_icmpge +12409 -> 12469
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
    //   86: ldc_w 2391
    //   89: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: iload 9
    //   94: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   97: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   100: invokestatic 199	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   103: iload 9
    //   105: lookupswitch	default:+259->364, 46:+518->623, 69:+581->686, 86:+998->1103, 87:+820->925, 88:+663->768, 113:+1207->1312, 116:+429->534, 119:+1184->1289, 140:+1355->1460, 149:+418->523, 156:+346->451, 165:+1544->1649, 174:+1589->1694, 180:+418->523, 185:+1680->1785, 188:+1265->1370, 202:+1734->1839, 206:+1310->1415, 210:+1780->1885, 215:+1836->1941, 218:+418->523, 223:+1249->1354, 231:+1849->1954, 255:+1866->1971, 257:+1454->1559, 260:+1499->1604, 273:+1634->1739, 283:+575->680, 321:+1689->1794, 364:+1249->1354, 365:+1249->1354
    //   365: istore 8
    //   367: iload 8
    //   369: istore 6
    //   371: invokestatic 1292	alzw:a	()Lalzw;
    //   374: iload 9
    //   376: invokevirtual 1295	alzw:b	(I)Z
    //   379: ifeq +48 -> 427
    //   382: invokestatic 1292	alzw:a	()Lalzw;
    //   385: iload 9
    //   387: invokevirtual 1298	alzw:a	(I)Lalzl;
    //   390: astore_3
    //   391: iload 8
    //   393: istore 6
    //   395: aload_3
    //   396: ifnull +31 -> 427
    //   399: aload_1
    //   400: getfield 2384	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:result	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   403: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   406: ifeq +1607 -> 2013
    //   409: bipush 254
    //   411: istore 6
    //   413: iload 6
    //   415: ifeq +9 -> 424
    //   418: aload_3
    //   419: iload 6
    //   421: invokevirtual 2392	alzl:a	(I)V
    //   424: iconst_1
    //   425: istore 6
    //   427: iload 6
    //   429: ifne +22 -> 451
    //   432: aload_2
    //   433: invokevirtual 1327	com/tencent/mobileqq/app/QQAppInterface:a	()Lalzb;
    //   436: aload_2
    //   437: iload 9
    //   439: iload 5
    //   441: aload_1
    //   442: getfield 2384	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:result	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   445: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   448: invokevirtual 2395	alzb:a	(Lcom/tencent/mobileqq/app/QQAppInterface;IZI)V
    //   451: iload 7
    //   453: iconst_1
    //   454: iadd
    //   455: istore 7
    //   457: goto -402 -> 55
    //   460: aload_1
    //   461: getfield 2384	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:result	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   464: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   467: ifeq +21 -> 488
    //   470: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   473: ifeq -421 -> 52
    //   476: ldc 183
    //   478: iconst_2
    //   479: ldc_w 2397
    //   482: invokestatic 199	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   485: goto -433 -> 52
    //   488: aload_1
    //   489: getfield 2387	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:config_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   492: ifnull +13 -> 505
    //   495: aload_1
    //   496: getfield 2387	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:config_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   499: invokevirtual 224	com/tencent/mobileqq/pb/PBRepeatMessageField:size	()I
    //   502: ifne -450 -> 52
    //   505: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   508: ifeq -456 -> 52
    //   511: ldc 183
    //   513: iconst_2
    //   514: ldc_w 2399
    //   517: invokestatic 199	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   520: goto -468 -> 52
    //   523: iload 9
    //   525: iload 5
    //   527: aload_1
    //   528: invokestatic 2402	ksm:a	(IZLcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig;)V
    //   531: goto -80 -> 451
    //   534: iload 5
    //   536: ifeq +13 -> 549
    //   539: aload_1
    //   540: getfield 2384	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:result	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   543: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   546: ifeq -95 -> 451
    //   549: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   552: ifeq +12 -> 564
    //   555: ldc 183
    //   557: iconst_2
    //   558: ldc_w 2404
    //   561: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   564: aload_0
    //   565: getfield 2406	amnh:jdField_a_of_type_Boolean	Z
    //   568: ifne +35 -> 603
    //   571: aload_2
    //   572: ldc_w 2408
    //   575: ldc 13
    //   577: ldc 13
    //   579: ldc_w 2410
    //   582: ldc_w 2410
    //   585: iconst_0
    //   586: iconst_0
    //   587: ldc 13
    //   589: ldc 13
    //   591: ldc 13
    //   593: ldc 13
    //   595: invokestatic 2415	awqx:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   598: aload_0
    //   599: iconst_1
    //   600: putfield 2406	amnh:jdField_a_of_type_Boolean	Z
    //   603: aload_2
    //   604: iconst_4
    //   605: invokevirtual 206	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lajfb;
    //   608: checkcast 1775	ajgd
    //   611: invokestatic 2420	akgo:a	()Lakgo;
    //   614: invokevirtual 2423	akgo:a	()Lcom/tencent/mobileqq/app/upgrade/UpgradeDetailWrapper;
    //   617: invokevirtual 2426	ajgd:a	(Lcom/tencent/mobileqq/app/upgrade/UpgradeDetailWrapper;)V
    //   620: goto -169 -> 451
    //   623: aload_1
    //   624: getfield 2384	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:result	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   627: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   630: ifeq +26 -> 656
    //   633: getstatic 2430	com/tencent/common/app/BaseApplicationImpl:sApplication	Lcom/tencent/common/app/BaseApplicationImpl;
    //   636: aload_2
    //   637: invokevirtual 1585	com/tencent/mobileqq/app/QQAppInterface:c	()Ljava/lang/String;
    //   640: ldc_w 2432
    //   643: bipush 101
    //   645: ldc 13
    //   647: invokestatic 2438	com/tencent/mobileqq/msf/core/net/patch/PatchReporter:reportPatchEvent	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)V
    //   650: invokestatic 2441	xfs:c	()V
    //   653: goto -202 -> 451
    //   656: aload_1
    //   657: getfield 2387	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:config_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   660: ifnull +13 -> 673
    //   663: aload_1
    //   664: getfield 2387	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:config_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   667: invokevirtual 224	com/tencent/mobileqq/pb/PBRepeatMessageField:size	()I
    //   670: ifne -20 -> 650
    //   673: aload_2
    //   674: invokestatic 2444	ysv:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   677: goto -27 -> 650
    //   680: invokestatic 2441	xfs:c	()V
    //   683: goto -232 -> 451
    //   686: iload 5
    //   688: ifeq +13 -> 701
    //   691: aload_1
    //   692: getfield 2384	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:result	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   695: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   698: ifeq -247 -> 451
    //   701: aload_2
    //   702: bipush 125
    //   704: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   707: checkcast 2446	agjk
    //   710: astore_3
    //   711: aload_3
    //   712: iconst_1
    //   713: putfield 2447	agjk:jdField_b_of_type_Boolean	Z
    //   716: aload_3
    //   717: getstatic 2452	com/tencent/mobileqq/data/MessageForFoldMsgGrayTips:PASSWD_REDBAG_MSG_SWITCH_DEFAULT	Z
    //   720: putfield 2453	agjk:c	Z
    //   723: aload_3
    //   724: getstatic 2456	com/tencent/mobileqq/data/MessageForFoldMsgGrayTips:PASSWD_REDBAG_MSG_DISPLAY_NUM_DEFAULT	I
    //   727: putfield 2458	agjk:jdField_a_of_type_Int	I
    //   730: aload_3
    //   731: getstatic 2461	com/tencent/mobileqq/data/MessageForFoldMsgGrayTips:PASSWD_REDBAG_MSG_INDEX_WITH_ID	Z
    //   734: putfield 2463	agjk:e	Z
    //   737: aload_2
    //   738: invokevirtual 65	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   741: aload_2
    //   742: invokevirtual 69	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   745: iconst_0
    //   746: aload_3
    //   747: getfield 2453	agjk:c	Z
    //   750: aload_3
    //   751: getfield 2458	agjk:jdField_a_of_type_Int	I
    //   754: aload_3
    //   755: getfield 2465	agjk:d	Z
    //   758: aload_3
    //   759: getfield 2463	agjk:e	Z
    //   762: invokestatic 2468	baig:a	(Landroid/content/Context;Ljava/lang/String;IZIZZ)V
    //   765: goto -314 -> 451
    //   768: iload 5
    //   770: ifne +51 -> 821
    //   773: aload_2
    //   774: bipush 88
    //   776: iconst_0
    //   777: iconst_0
    //   778: iconst_1
    //   779: iconst_1
    //   780: iconst_0
    //   781: invokestatic 2473	com/tencent/mobileqq/olympic/OlympicServlet:a	(Lmqq/app/AppRuntime;IIIIII)V
    //   784: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   787: ifeq -336 -> 451
    //   790: ldc_w 1703
    //   793: iconst_2
    //   794: new 85	java/lang/StringBuilder
    //   797: dup
    //   798: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   801: ldc_w 2475
    //   804: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   807: iload 5
    //   809: invokevirtual 152	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   812: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   815: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   818: goto -367 -> 451
    //   821: aload_1
    //   822: getfield 2384	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:result	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   825: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   828: ifeq +61 -> 889
    //   831: aload_1
    //   832: getfield 2384	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:result	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   835: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   838: istore 6
    //   840: aload_2
    //   841: bipush 88
    //   843: iconst_0
    //   844: iconst_0
    //   845: iconst_1
    //   846: iload 6
    //   848: iconst_0
    //   849: invokestatic 2473	com/tencent/mobileqq/olympic/OlympicServlet:a	(Lmqq/app/AppRuntime;IIIIII)V
    //   852: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   855: ifeq -404 -> 451
    //   858: ldc_w 1703
    //   861: iconst_2
    //   862: new 85	java/lang/StringBuilder
    //   865: dup
    //   866: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   869: ldc_w 2477
    //   872: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   875: iload 6
    //   877: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   880: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   883: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   886: goto -435 -> 451
    //   889: aload_1
    //   890: getfield 2387	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:config_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   893: ifnull +13 -> 906
    //   896: aload_1
    //   897: getfield 2387	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:config_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   900: invokevirtual 224	com/tencent/mobileqq/pb/PBRepeatMessageField:size	()I
    //   903: ifne -452 -> 451
    //   906: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   909: ifeq -458 -> 451
    //   912: ldc_w 1703
    //   915: iconst_2
    //   916: ldc_w 2479
    //   919: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   922: goto -471 -> 451
    //   925: iload 5
    //   927: ifne +72 -> 999
    //   930: aload_2
    //   931: bipush 87
    //   933: iconst_0
    //   934: iconst_0
    //   935: iconst_1
    //   936: iconst_1
    //   937: iconst_0
    //   938: invokestatic 2473	com/tencent/mobileqq/olympic/OlympicServlet:a	(Lmqq/app/AppRuntime;IIIIII)V
    //   941: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   944: ifeq +31 -> 975
    //   947: ldc_w 1703
    //   950: iconst_2
    //   951: new 85	java/lang/StringBuilder
    //   954: dup
    //   955: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   958: ldc_w 2481
    //   961: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   964: iload 5
    //   966: invokevirtual 152	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   969: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   972: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   975: aload_2
    //   976: sipush 168
    //   979: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   982: checkcast 1676	aknw
    //   985: astore_3
    //   986: aload_3
    //   987: ifnull -536 -> 451
    //   990: aload_3
    //   991: iconst_1
    //   992: iconst_0
    //   993: invokevirtual 2484	aknw:a	(ZZ)V
    //   996: goto -545 -> 451
    //   999: aload_1
    //   1000: getfield 2384	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:result	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   1003: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   1006: ifeq +61 -> 1067
    //   1009: aload_1
    //   1010: getfield 2384	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:result	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   1013: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   1016: istore 6
    //   1018: aload_2
    //   1019: bipush 87
    //   1021: iconst_0
    //   1022: iconst_0
    //   1023: iconst_1
    //   1024: iload 6
    //   1026: iconst_0
    //   1027: invokestatic 2473	com/tencent/mobileqq/olympic/OlympicServlet:a	(Lmqq/app/AppRuntime;IIIIII)V
    //   1030: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1033: ifeq -58 -> 975
    //   1036: ldc_w 1703
    //   1039: iconst_2
    //   1040: new 85	java/lang/StringBuilder
    //   1043: dup
    //   1044: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   1047: ldc_w 2486
    //   1050: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1053: iload 6
    //   1055: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1058: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1061: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1064: goto -89 -> 975
    //   1067: aload_1
    //   1068: getfield 2387	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:config_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   1071: ifnull +13 -> 1084
    //   1074: aload_1
    //   1075: getfield 2387	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:config_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   1078: invokevirtual 224	com/tencent/mobileqq/pb/PBRepeatMessageField:size	()I
    //   1081: ifne -106 -> 975
    //   1084: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1087: ifeq -112 -> 975
    //   1090: ldc_w 1703
    //   1093: iconst_2
    //   1094: ldc_w 2488
    //   1097: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1100: goto -125 -> 975
    //   1103: iload 5
    //   1105: ifne +77 -> 1182
    //   1108: aload_0
    //   1109: invokevirtual 47	amnh:getAppRuntime	()Lmqq/app/AppRuntime;
    //   1112: bipush 86
    //   1114: iconst_0
    //   1115: iconst_0
    //   1116: iconst_1
    //   1117: iconst_1
    //   1118: iconst_0
    //   1119: invokestatic 2473	com/tencent/mobileqq/olympic/OlympicServlet:a	(Lmqq/app/AppRuntime;IIIIII)V
    //   1122: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1125: ifeq +31 -> 1156
    //   1128: ldc_w 1663
    //   1131: iconst_2
    //   1132: new 85	java/lang/StringBuilder
    //   1135: dup
    //   1136: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   1139: ldc_w 2490
    //   1142: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1145: iload 5
    //   1147: invokevirtual 152	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1150: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1153: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1156: aload_2
    //   1157: sipush 167
    //   1160: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   1163: checkcast 1638	com/tencent/mobileqq/olympic/OlympicManager
    //   1166: astore_3
    //   1167: aload_3
    //   1168: ifnull -717 -> 451
    //   1171: aload_3
    //   1172: invokevirtual 2492	com/tencent/mobileqq/olympic/OlympicManager:f	()V
    //   1175: aload_3
    //   1176: invokevirtual 2494	com/tencent/mobileqq/olympic/OlympicManager:g	()V
    //   1179: goto -728 -> 451
    //   1182: aload_1
    //   1183: getfield 2384	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:result	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   1186: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   1189: ifeq +64 -> 1253
    //   1192: aload_1
    //   1193: getfield 2384	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:result	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   1196: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   1199: istore 6
    //   1201: aload_0
    //   1202: invokevirtual 47	amnh:getAppRuntime	()Lmqq/app/AppRuntime;
    //   1205: bipush 86
    //   1207: iconst_0
    //   1208: iconst_0
    //   1209: iconst_1
    //   1210: iload 6
    //   1212: iconst_0
    //   1213: invokestatic 2473	com/tencent/mobileqq/olympic/OlympicServlet:a	(Lmqq/app/AppRuntime;IIIIII)V
    //   1216: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1219: ifeq -63 -> 1156
    //   1222: ldc_w 1663
    //   1225: iconst_2
    //   1226: new 85	java/lang/StringBuilder
    //   1229: dup
    //   1230: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   1233: ldc_w 2496
    //   1236: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1239: iload 6
    //   1241: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1244: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1247: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1250: goto -94 -> 1156
    //   1253: aload_1
    //   1254: getfield 2387	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:config_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   1257: ifnull +13 -> 1270
    //   1260: aload_1
    //   1261: getfield 2387	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:config_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   1264: invokevirtual 224	com/tencent/mobileqq/pb/PBRepeatMessageField:size	()I
    //   1267: ifne -111 -> 1156
    //   1270: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1273: ifeq -117 -> 1156
    //   1276: ldc_w 1663
    //   1279: iconst_2
    //   1280: ldc_w 2498
    //   1283: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1286: goto -130 -> 1156
    //   1289: aload_2
    //   1290: bipush 53
    //   1292: invokevirtual 206	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lajfb;
    //   1295: checkcast 1787	ajei
    //   1298: astore_3
    //   1299: aload_3
    //   1300: ifnull -849 -> 451
    //   1303: aload_3
    //   1304: iconst_0
    //   1305: iconst_0
    //   1306: invokevirtual 2499	ajei:a	(ZZ)V
    //   1309: goto -858 -> 451
    //   1312: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1315: ifeq +12 -> 1327
    //   1318: ldc 183
    //   1320: iconst_2
    //   1321: ldc_w 2501
    //   1324: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1327: aload_2
    //   1328: sipush 179
    //   1331: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   1334: checkcast 2503	attv
    //   1337: astore_3
    //   1338: aload_3
    //   1339: ifnull -888 -> 451
    //   1342: aload_3
    //   1343: invokevirtual 2504	attv:a	()V
    //   1346: aload_3
    //   1347: iconst_0
    //   1348: invokevirtual 2505	attv:a	(Z)V
    //   1351: goto -900 -> 451
    //   1354: aload_2
    //   1355: invokestatic 1510	com/tencent/mobileqq/utils/BusinessCommonConfig:getInstance	(Lmqq/app/AppRuntime;)Lcom/tencent/mobileqq/utils/BusinessCommonConfig;
    //   1358: aload_2
    //   1359: iload 9
    //   1361: iload 5
    //   1363: aload_1
    //   1364: invokevirtual 2509	com/tencent/mobileqq/utils/BusinessCommonConfig:handleResp_Config_Fail	(Lcom/tencent/mobileqq/app/QQAppInterface;IZLcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig;)V
    //   1367: goto -916 -> 451
    //   1370: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1373: ifeq -922 -> 451
    //   1376: aload_1
    //   1377: getfield 2384	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:result	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   1380: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   1383: istore 6
    //   1385: ldc 183
    //   1387: iconst_2
    //   1388: new 85	java/lang/StringBuilder
    //   1391: dup
    //   1392: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   1395: ldc_w 2511
    //   1398: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1401: iload 6
    //   1403: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1406: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1409: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1412: goto -961 -> 451
    //   1415: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1418: ifeq -967 -> 451
    //   1421: aload_1
    //   1422: getfield 2384	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:result	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   1425: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   1428: istore 6
    //   1430: ldc 183
    //   1432: iconst_2
    //   1433: new 85	java/lang/StringBuilder
    //   1436: dup
    //   1437: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   1440: ldc_w 2513
    //   1443: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1446: iload 6
    //   1448: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1451: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1454: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1457: goto -1006 -> 451
    //   1460: aload_1
    //   1461: getfield 2384	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:result	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   1464: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   1467: istore 6
    //   1469: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1472: ifeq +30 -> 1502
    //   1475: ldc 183
    //   1477: iconst_2
    //   1478: new 85	java/lang/StringBuilder
    //   1481: dup
    //   1482: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   1485: ldc_w 2515
    //   1488: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1491: iload 6
    //   1493: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1496: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1499: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1502: new 2517	java/util/HashMap
    //   1505: dup
    //   1506: invokespecial 2518	java/util/HashMap:<init>	()V
    //   1509: astore_3
    //   1510: aload_3
    //   1511: ldc_w 2520
    //   1514: new 85	java/lang/StringBuilder
    //   1517: dup
    //   1518: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   1521: iload 6
    //   1523: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1526: ldc 13
    //   1528: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1531: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1534: invokevirtual 2523	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1537: pop
    //   1538: invokestatic 385	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1541: invokestatic 1670	awrn:a	(Landroid/content/Context;)Lawrn;
    //   1544: aconst_null
    //   1545: ldc_w 2525
    //   1548: iconst_0
    //   1549: lconst_0
    //   1550: lconst_0
    //   1551: aload_3
    //   1552: aconst_null
    //   1553: invokevirtual 2528	awrn:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;)V
    //   1556: goto -1105 -> 451
    //   1559: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1562: ifeq -1111 -> 451
    //   1565: aload_1
    //   1566: getfield 2384	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:result	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   1569: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   1572: istore 6
    //   1574: ldc 183
    //   1576: iconst_2
    //   1577: invokestatic 1082	java/util/Locale:getDefault	()Ljava/util/Locale;
    //   1580: ldc_w 2530
    //   1583: iconst_1
    //   1584: anewarray 301	java/lang/Object
    //   1587: dup
    //   1588: iconst_0
    //   1589: iload 6
    //   1591: invokestatic 305	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1594: aastore
    //   1595: invokestatic 1087	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   1598: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1601: goto -1150 -> 451
    //   1604: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1607: ifeq -1156 -> 451
    //   1610: aload_1
    //   1611: getfield 2384	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:result	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   1614: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   1617: istore 6
    //   1619: ldc 183
    //   1621: iconst_2
    //   1622: invokestatic 1082	java/util/Locale:getDefault	()Ljava/util/Locale;
    //   1625: ldc_w 2532
    //   1628: iconst_1
    //   1629: anewarray 301	java/lang/Object
    //   1632: dup
    //   1633: iconst_0
    //   1634: iload 6
    //   1636: invokestatic 305	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1639: aastore
    //   1640: invokestatic 1087	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   1643: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1646: goto -1195 -> 451
    //   1649: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1652: ifeq -1201 -> 451
    //   1655: aload_1
    //   1656: getfield 2384	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:result	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   1659: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   1662: istore 6
    //   1664: ldc 183
    //   1666: iconst_2
    //   1667: new 85	java/lang/StringBuilder
    //   1670: dup
    //   1671: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   1674: ldc_w 2534
    //   1677: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1680: iload 6
    //   1682: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1685: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1688: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1691: goto -1240 -> 451
    //   1694: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1697: ifeq -1246 -> 451
    //   1700: aload_1
    //   1701: getfield 2384	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:result	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   1704: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   1707: istore 6
    //   1709: ldc 183
    //   1711: iconst_2
    //   1712: new 85	java/lang/StringBuilder
    //   1715: dup
    //   1716: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   1719: ldc_w 2536
    //   1722: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1725: iload 6
    //   1727: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1730: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1733: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1736: goto -1285 -> 451
    //   1739: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1742: ifeq -1291 -> 451
    //   1745: aload_1
    //   1746: getfield 2384	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:result	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   1749: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   1752: istore 6
    //   1754: ldc_w 2538
    //   1757: iconst_2
    //   1758: new 85	java/lang/StringBuilder
    //   1761: dup
    //   1762: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   1765: ldc_w 2540
    //   1768: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1771: iload 6
    //   1773: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1776: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1779: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1782: goto -1331 -> 451
    //   1785: invokestatic 2545	com/tencent/mobileqq/scribble/ScribbleResMgr:a	()Lcom/tencent/mobileqq/scribble/ScribbleResMgr;
    //   1788: invokevirtual 2546	com/tencent/mobileqq/scribble/ScribbleResMgr:b	()V
    //   1791: goto -1340 -> 451
    //   1794: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1797: ifeq -1346 -> 451
    //   1800: aload_1
    //   1801: getfield 2384	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:result	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   1804: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   1807: istore 6
    //   1809: ldc 183
    //   1811: iconst_2
    //   1812: new 85	java/lang/StringBuilder
    //   1815: dup
    //   1816: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   1819: ldc_w 2548
    //   1822: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1825: iload 6
    //   1827: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1830: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1833: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1836: goto -1385 -> 451
    //   1839: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1842: ifeq -1391 -> 451
    //   1845: aload_1
    //   1846: getfield 2384	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:result	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   1849: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   1852: istore 6
    //   1854: ldc_w 2335
    //   1857: iconst_2
    //   1858: new 85	java/lang/StringBuilder
    //   1861: dup
    //   1862: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   1865: ldc_w 2550
    //   1868: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1871: iload 6
    //   1873: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1876: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1879: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1882: goto -1431 -> 451
    //   1885: aload_2
    //   1886: sipush 228
    //   1889: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   1892: checkcast 1959	atdp
    //   1895: astore_3
    //   1896: aload_1
    //   1897: getfield 2384	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:result	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   1900: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   1903: istore 6
    //   1905: ldc 183
    //   1907: iconst_1
    //   1908: new 85	java/lang/StringBuilder
    //   1911: dup
    //   1912: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   1915: ldc_w 2552
    //   1918: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1921: iload 6
    //   1923: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1926: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1929: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1932: aload_3
    //   1933: iconst_0
    //   1934: aconst_null
    //   1935: invokevirtual 2555	atdp:a	(ZLcom/tencent/mobileqq/ocr/data/OcrConfig;)V
    //   1938: goto -1487 -> 451
    //   1941: aload_1
    //   1942: getfield 2384	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:result	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   1945: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   1948: invokestatic 2556	com/tencent/mobileqq/shortvideo/ShortVideoResourceManager:a	(I)V
    //   1951: goto -1500 -> 451
    //   1954: aload_2
    //   1955: sipush 231
    //   1958: aload_1
    //   1959: getfield 2384	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:result	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   1962: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   1965: invokestatic 2559	ahml:a	(Lcom/tencent/mobileqq/app/QQAppInterface;II)V
    //   1968: goto -1517 -> 451
    //   1971: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1974: ifeq -1523 -> 451
    //   1977: ldc_w 2561
    //   1980: iconst_2
    //   1981: new 85	java/lang/StringBuilder
    //   1984: dup
    //   1985: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   1988: ldc_w 2563
    //   1991: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1994: aload_1
    //   1995: getfield 2384	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:result	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   1998: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   2001: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2004: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2007: invokestatic 199	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   2010: goto -1559 -> 451
    //   2013: iload 5
    //   2015: ifne +9 -> 2024
    //   2018: iconst_m1
    //   2019: istore 6
    //   2021: goto -1608 -> 413
    //   2024: iconst_0
    //   2025: istore 6
    //   2027: goto -1614 -> 413
    //   2030: invokestatic 2566	java/lang/System:currentTimeMillis	()J
    //   2033: lstore 12
    //   2035: aload_1
    //   2036: getfield 2387	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:config_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   2039: invokevirtual 224	com/tencent/mobileqq/pb/PBRepeatMessageField:size	()I
    //   2042: istore 9
    //   2044: new 1121	java/util/ArrayList
    //   2047: dup
    //   2048: aload 4
    //   2050: arraylength
    //   2051: invokespecial 1152	java/util/ArrayList:<init>	(I)V
    //   2054: astore 18
    //   2056: iconst_0
    //   2057: istore 6
    //   2059: iload 6
    //   2061: aload 4
    //   2063: arraylength
    //   2064: if_icmpge +28 -> 2092
    //   2067: aload 18
    //   2069: aload 4
    //   2071: iload 6
    //   2073: iaload
    //   2074: invokestatic 305	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2077: invokeinterface 1131 2 0
    //   2082: pop
    //   2083: iload 6
    //   2085: iconst_1
    //   2086: iadd
    //   2087: istore 6
    //   2089: goto -30 -> 2059
    //   2092: aconst_null
    //   2093: astore 4
    //   2095: iconst_0
    //   2096: istore 10
    //   2098: iconst_0
    //   2099: istore 6
    //   2101: iload 6
    //   2103: iload 9
    //   2105: if_icmpge +8476 -> 10581
    //   2108: aload_1
    //   2109: getfield 2387	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:config_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   2112: iload 6
    //   2114: invokevirtual 318	com/tencent/mobileqq/pb/PBRepeatMessageField:get	(I)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   2117: checkcast 51	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config
    //   2120: astore 19
    //   2122: aload 19
    //   2124: ifnonnull +28 -> 2152
    //   2127: iload 10
    //   2129: istore 11
    //   2131: aload 4
    //   2133: astore 16
    //   2135: iload 6
    //   2137: iconst_1
    //   2138: iadd
    //   2139: istore 6
    //   2141: aload 16
    //   2143: astore 4
    //   2145: iload 11
    //   2147: istore 10
    //   2149: goto -48 -> 2101
    //   2152: aload 4
    //   2154: astore 16
    //   2156: iload 10
    //   2158: istore 11
    //   2160: aload 19
    //   2162: getfield 2567	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:type	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   2165: invokevirtual 2568	com/tencent/mobileqq/pb/PBInt32Field:has	()Z
    //   2168: ifeq -33 -> 2135
    //   2171: new 139	java/lang/Integer
    //   2174: dup
    //   2175: aload 19
    //   2177: getfield 2567	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:type	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   2180: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   2183: invokespecial 2569	java/lang/Integer:<init>	(I)V
    //   2186: astore 16
    //   2188: aload 18
    //   2190: aload 16
    //   2192: invokeinterface 2571 2 0
    //   2197: pop
    //   2198: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2201: ifeq +41 -> 2242
    //   2204: ldc 183
    //   2206: iconst_2
    //   2207: new 85	java/lang/StringBuilder
    //   2210: dup
    //   2211: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   2214: ldc_w 2573
    //   2217: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2220: aload 16
    //   2222: invokevirtual 798	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2225: ldc_w 2575
    //   2228: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2231: iload 9
    //   2233: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2236: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2239: invokestatic 199	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   2242: aload 16
    //   2244: invokevirtual 1823	java/lang/Integer:intValue	()I
    //   2247: tableswitch	default:+10121 -> 12368, 1:+3194->5441, 2:+3598->5845, 3:+4088->6335, 4:+1653->3900, 5:+4326->6573, 6:+6555->8802, 7:+1653->3900, 8:+1653->3900, 9:+1653->3900, 10:+5179->7426, 11:+1653->3900, 12:+4551->6798, 13:+5454->7701, 14:+1653->3900, 15:+1653->3900, 16:+1653->3900, 17:+1653->3900, 18:+1653->3900, 19:+1653->3900, 20:+1653->3900, 21:+1653->3900, 22:+1653->3900, 23:+5844->8091, 24:+1653->3900, 25:+1653->3900, 26:+1653->3900, 27:+1653->3900, 28:+1653->3900, 29:+1653->3900, 30:+1653->3900, 31:+5520->7767, 32:+1653->3900, 33:+1653->3900, 34:+5502->7749, 35:+1653->3900, 36:+1653->3900, 37:+1653->3900, 38:+5953->8200, 39:+1653->3900, 40:+1653->3900, 41:+1653->3900, 42:+6375->8622, 43:+6537->8784, 44:+2771->5018, 45:+1653->3900, 46:+6393->8640, 47:+2959->5206, 48:+1653->3900, 49:+6384->8631, 50:+6402->8649, 51:+1653->3900, 52:+1653->3900, 53:+5854->8101, 54:+1653->3900, 55:+4867->7114, 56:+6411->8658, 57:+1653->3900, 58:+1653->3900, 59:+1653->3900, 60:+1653->3900, 61:+6420->8667, 62:+1653->3900, 63:+6438->8685, 64:+6447->8694, 65:+3148->5395, 66:+6456->8703, 67:+1653->3900, 68:+1653->3900, 69:+6483->8730, 70:+1653->3900, 71:+1653->3900, 72:+6465->8712, 73:+6474->8721, 74:+6492->8739, 75:+6501->8748, 76:+1653->3900, 77:+1653->3900, 78:+5864->8111, 79:+6586->8833, 80:+6568->8815, 81:+1653->3900, 82:+6595->8842, 83:+1653->3900, 84:+5874->8121, 85:+1653->3900, 86:+6813->9060, 87:+6832->9079, 88:+6842->9089, 89:+1653->3900, 90:+6604->8851, 91:+1653->3900, 92:+1653->3900, 93:+6164->8411, 94:+5670->7917, 95:+1653->3900, 96:+6883->9130, 97:+6893->9140, 98:+1653->3900, 99:+1653->3900, 100:+1653->3900, 101:+5472->7719, 102:+5511->7758, 103:+1653->3900, 104:+1653->3900, 105:+1653->3900, 106:+1653->3900, 107:+1653->3900, 108:+1653->3900, 109:+6930->9177, 110:+1653->3900, 111:+6577->8824, 112:+1653->3900, 113:+6546->8793, 114:+1653->3900, 115:+5482->7729, 116:+2134->4381, 117:+1653->3900, 118:+6959->9206, 119:+7009->9256, 120:+6949->9196, 121:+7019->9266, 122:+1653->3900, 123:+1653->3900, 124:+1653->3900, 125:+1653->3900, 126:+1653->3900, 127:+1653->3900, 128:+1653->3900, 129:+6989->9236, 130:+7039->9286, 131:+1653->3900, 132:+1653->3900, 133:+1653->3900, 134:+1653->3900, 135:+1653->3900, 136:+1653->3900, 137:+1653->3900, 138:+1653->3900, 139:+5905->8152, 140:+7067->9314, 141:+1653->3900, 142:+6969->9216, 143:+6999->9246, 144:+1653->3900, 145:+7107->9354, 146:+6920->9167, 147:+6803->9050, 148:+6429->8676, 149:+6903->9150, 150:+1653->3900, 151:+1653->3900, 152:+1653->3900, 153:+7097->9344, 154:+1653->3900, 155:+7117->9364, 156:+10219->12466, 157:+7029->9276, 158:+1653->3900, 159:+1653->3900, 160:+1653->3900, 161:+1653->3900, 162:+1653->3900, 163:+1653->3900, 164:+1653->3900, 165:+7137->9384, 166:+7147->9394, 167:+5895->8142, 168:+1653->3900, 169:+1653->3900, 170:+1653->3900, 171:+7169->9416, 172:+1653->3900, 173:+1653->3900, 174:+7219->9466, 175:+1653->3900, 176:+1653->3900, 177:+7268->9515, 178:+1653->3900, 179:+1653->3900, 180:+6903->9150, 181:+7189->9436, 182:+7248->9495, 183:+1653->3900, 184:+7179->9426, 185:+7318->9565, 186:+1653->3900, 187:+7278->9525, 188:+6852->9099, 189:+1653->3900, 190:+7434->9681, 191:+7308->9555, 192:+1653->3900, 193:+1728->3975, 194:+7127->9374, 195:+7288->9535, 196:+1653->3900, 197:+1653->3900, 198:+1653->3900, 199:+7337->9584, 200:+1653->3900, 201:+6979->9226, 202:+7424->9671, 203:+1653->3900, 204:+7895->10142, 205:+6872->9119, 206:+6862->9109, 207:+1653->3900, 208:+1653->3900, 209:+1653->3900, 210:+7444->9691, 211:+7057->9304, 212:+7454->9701, 213:+1653->3900, 214:+1653->3900, 215:+7481->9728, 216:+1653->3900, 217:+1653->3900, 218:+6903->9150, 219:+1653->3900, 220:+1653->3900, 221:+1653->3900, 222:+7494->9741, 223:+5933->8180, 224:+1653->3900, 225:+7379->9626, 226:+5884->8131, 227:+7298->9545, 228:+6519->8766, 229:+1653->3900, 230:+1653->3900, 231:+7542->9789, 232:+7049->9296, 233:+1653->3900, 234:+7522->9769, 235:+7532->9779, 236:+1653->3900, 237:+8237->10484, 238:+7557->9804, 239:+1653->3900, 240:+1653->3900, 241:+1653->3900, 242:+1653->3900, 243:+1653->3900, 244:+7567->9814, 245:+7577->9824, 246:+1653->3900, 247:+7199->9446, 248:+1653->3900, 249:+1653->3900, 250:+1653->3900, 251:+1653->3900, 252:+1653->3900, 253:+7587->9834, 254:+7845->10092, 255:+7607->9854, 256:+6528->8775, 257:+7077->9324, 258:+1653->3900, 259:+7855->10102, 260:+7087->9334, 261:+1653->3900, 262:+7865->10112, 263:+1653->3900, 264:+1653->3900, 265:+1653->3900, 266:+1653->3900, 267:+7905->10152, 268:+7875->10122, 269:+7885->10132, 270:+1653->3900, 271:+1653->3900, 272:+7209->9456, 273:+7229->9476, 274:+7915->10162, 275:+1653->3900, 276:+1653->3900, 277:+1653->3900, 278:+1653->3900, 279:+7924->10171, 280:+8020->10267, 281:+8040->10287, 282:+1653->3900, 283:+8050->10297, 284:+8060->10307, 285:+1653->3900, 286:+5492->7739, 287:+1653->3900, 288:+1653->3900, 289:+8087->10334, 290:+1653->3900, 291:+1653->3900, 292:+1653->3900, 293:+1653->3900, 294:+1653->3900, 295:+7597->9844, 296:+1653->3900, 297:+8097->10344, 298:+1653->3900, 299:+1653->3900, 300:+1653->3900, 301:+8070->10317, 302:+1653->3900, 303:+1653->3900, 304:+1653->3900, 305:+1653->3900, 306:+1653->3900, 307:+1653->3900, 308:+7945->10192, 309:+1653->3900, 310:+1653->3900, 311:+1653->3900, 312:+7978->10225, 313:+7966->10213, 314:+8126->10373, 315:+1653->3900, 316:+1653->3900, 317:+1653->3900, 318:+1653->3900, 319:+1653->3900, 320:+8146->10393, 321:+7328->9575, 322:+1653->3900, 323:+1653->3900, 324:+1653->3900, 325:+1653->3900, 326:+1653->3900, 327:+1653->3900, 328:+7238->9485, 329:+5914->8161, 330:+1653->3900, 331:+8168->10415, 332:+1653->3900, 333:+1653->3900, 334:+1653->3900, 335:+1653->3900, 336:+8178->10425, 337:+8111->10358, 338:+1653->3900, 339:+1653->3900, 340:+1653->3900, 341:+1653->3900, 342:+1653->3900, 343:+1653->3900, 344:+1653->3900, 345:+8187->10434, 346:+1653->3900, 347:+8136->10383, 348:+1653->3900, 349:+8201->10448, 350:+1653->3900, 351:+5923->8170, 352:+1653->3900, 353:+1653->3900, 354:+1653->3900, 355:+1653->3900, 356:+1653->3900, 357:+1653->3900, 358:+1653->3900, 359:+1653->3900, 360:+8030->10277, 361:+1653->3900, 362:+1653->3900, 363:+1653->3900, 364:+5933->8180, 365:+5933->8180, 366:+1653->3900, 367:+1653->3900, 368:+1653->3900, 369:+1653->3900, 370:+1653->3900, 371:+7258->9505, 372:+1653->3900, 373:+1653->3900, 374:+1653->3900, 375:+1653->3900, 376:+1653->3900, 377:+1653->3900, 378:+1653->3900, 379:+1653->3900, 380:+1653->3900, 381:+1653->3900, 382:+1653->3900, 383:+1653->3900, 384:+8245->10492, 385:+6510->8757, 386:+8264->10511, 387:+8254->10501, 388:+1653->3900, 389:+1653->3900, 390:+1653->3900, 391:+1653->3900, 392:+8282->10529, 393:+8291->10538, 394:+8309->10556, 395:+1653->3900, 396:+1653->3900, 397:+7996->10243, 398:+1653->3900, 399:+1653->3900, 400:+8222->10469, 401:+1653->3900, 402:+1653->3900, 403:+7463->9710, 404:+7472->9719, 405:+1653->3900, 406:+1653->3900, 407:+1653->3900, 408:+1653->3900, 409:+1653->3900, 410:+8319->10566
    //   3901: istore 7
    //   3903: invokestatic 1292	alzw:a	()Lalzw;
    //   3906: aload 16
    //   3908: invokevirtual 1823	java/lang/Integer:intValue	()I
    //   3911: invokevirtual 1295	alzw:b	(I)Z
    //   3914: ifeq +38 -> 3952
    //   3917: invokestatic 1292	alzw:a	()Lalzw;
    //   3920: astore 17
    //   3922: aload 19
    //   3924: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   3927: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   3930: istore 7
    //   3932: aload 17
    //   3934: aload 16
    //   3936: invokevirtual 1823	java/lang/Integer:intValue	()I
    //   3939: iload 7
    //   3941: aload 19
    //   3943: getstatic 15	amnh:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   3946: invokevirtual 2578	alzw:a	(IILcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;Ljava/lang/String;)V
    //   3949: iconst_1
    //   3950: istore 7
    //   3952: iload 7
    //   3954: ifne +8417 -> 12371
    //   3957: aload_2
    //   3958: invokevirtual 1327	com/tencent/mobileqq/app/QQAppInterface:a	()Lalzb;
    //   3961: aload_2
    //   3962: aload 19
    //   3964: aload 16
    //   3966: invokevirtual 1823	java/lang/Integer:intValue	()I
    //   3969: invokevirtual 2580	alzb:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;I)V
    //   3972: goto +8399 -> 12371
    //   3975: aload 19
    //   3977: getfield 221	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   3980: ifnull +8391 -> 12371
    //   3983: aload 19
    //   3985: getfield 221	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   3988: invokevirtual 224	com/tencent/mobileqq/pb/PBRepeatMessageField:size	()I
    //   3991: ifle +8380 -> 12371
    //   3994: aload 19
    //   3996: getfield 221	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   3999: iconst_0
    //   4000: invokevirtual 318	com/tencent/mobileqq/pb/PBRepeatMessageField:get	(I)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   4003: checkcast 244	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content
    //   4006: astore 16
    //   4008: aload 16
    //   4010: ifnull +344 -> 4354
    //   4013: aload 16
    //   4015: getfield 248	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content:compress	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4018: invokevirtual 251	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   4021: iconst_1
    //   4022: if_icmpne +232 -> 4254
    //   4025: aload 16
    //   4027: getfield 255	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content:content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   4030: invokevirtual 260	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   4033: invokevirtual 266	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   4036: invokestatic 321	atiu:a	([B)[B
    //   4039: astore 17
    //   4041: aload 17
    //   4043: ifnull +8319 -> 12362
    //   4046: new 118	java/lang/String
    //   4049: dup
    //   4050: aload 17
    //   4052: ldc_w 323
    //   4055: invokespecial 326	java/lang/String:<init>	([BLjava/lang/String;)V
    //   4058: astore 16
    //   4060: aload 16
    //   4062: ifnull +8293 -> 12355
    //   4065: aload 19
    //   4067: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   4070: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   4073: istore 7
    //   4075: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4078: ifeq +42 -> 4120
    //   4081: ldc_w 1781
    //   4084: iconst_2
    //   4085: new 85	java/lang/StringBuilder
    //   4088: dup
    //   4089: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   4092: ldc_w 2582
    //   4095: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4098: iload 7
    //   4100: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4103: ldc_w 2584
    //   4106: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4109: aload 16
    //   4111: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4114: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4117: invokestatic 199	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   4120: aload 16
    //   4122: invokestatic 2589	com/tencent/mobileqq/app/upgrade/UpgradeTIMWrapper:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/app/upgrade/UpgradeTIMWrapper;
    //   4125: astore 17
    //   4127: aload 17
    //   4129: astore 4
    //   4131: aload_0
    //   4132: invokevirtual 47	amnh:getAppRuntime	()Lmqq/app/AppRuntime;
    //   4135: invokevirtual 2590	mqq/app/AppRuntime:getApplication	()Lmqq/app/MobileQQ;
    //   4138: getstatic 15	amnh:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   4141: iload 7
    //   4143: invokestatic 2592	baig:q	(Landroid/content/Context;Ljava/lang/String;I)V
    //   4146: aload_2
    //   4147: invokevirtual 65	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   4150: ldc_w 2594
    //   4153: invokestatic 2597	bady:a	(Landroid/content/Context;Ljava/lang/String;)Z
    //   4156: ifne +114 -> 4270
    //   4159: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4162: ifeq +13 -> 4175
    //   4165: ldc_w 1781
    //   4168: iconst_2
    //   4169: ldc_w 2599
    //   4172: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4175: aload 16
    //   4177: invokestatic 2600	com/tencent/mobileqq/app/upgrade/UpgradeTIMWrapper:a	(Ljava/lang/String;)V
    //   4180: aload_2
    //   4181: aload 4
    //   4183: invokestatic 2603	com/tencent/mobileqq/app/upgrade/UpgradeTIMWrapper:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/app/upgrade/UpgradeTIMWrapper;)V
    //   4186: aload 4
    //   4188: astore 16
    //   4190: aload 16
    //   4192: astore 4
    //   4194: goto +8177 -> 12371
    //   4197: astore 16
    //   4199: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4202: ifeq +8180 -> 12382
    //   4205: aload 16
    //   4207: invokevirtual 2604	java/io/UnsupportedEncodingException:printStackTrace	()V
    //   4210: goto +8172 -> 12382
    //   4213: astore 16
    //   4215: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4218: ifeq +8 -> 4226
    //   4221: aload 16
    //   4223: invokevirtual 2605	java/lang/OutOfMemoryError:printStackTrace	()V
    //   4226: invokestatic 2608	java/lang/System:gc	()V
    //   4229: new 118	java/lang/String
    //   4232: dup
    //   4233: aload 17
    //   4235: ldc_w 323
    //   4238: invokespecial 326	java/lang/String:<init>	([BLjava/lang/String;)V
    //   4241: astore 16
    //   4243: goto -183 -> 4060
    //   4246: astore 16
    //   4248: aconst_null
    //   4249: astore 16
    //   4251: goto -191 -> 4060
    //   4254: aload 16
    //   4256: getfield 255	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content:content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   4259: invokevirtual 260	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   4262: invokevirtual 280	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   4265: astore 16
    //   4267: goto -207 -> 4060
    //   4270: aload 4
    //   4272: astore 16
    //   4274: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4277: ifeq -87 -> 4190
    //   4280: ldc_w 1781
    //   4283: iconst_2
    //   4284: ldc_w 2610
    //   4287: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4290: aload 4
    //   4292: astore 16
    //   4294: goto -104 -> 4190
    //   4297: astore 17
    //   4299: aload 4
    //   4301: astore 16
    //   4303: iload 10
    //   4305: istore 11
    //   4307: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4310: ifeq -2175 -> 2135
    //   4313: ldc 183
    //   4315: iconst_2
    //   4316: new 85	java/lang/StringBuilder
    //   4319: dup
    //   4320: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   4323: ldc_w 2612
    //   4326: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4329: aload 17
    //   4331: invokevirtual 2282	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   4334: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4337: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4340: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4343: aload 4
    //   4345: astore 16
    //   4347: iload 10
    //   4349: istore 11
    //   4351: goto -2216 -> 2135
    //   4354: aload 4
    //   4356: astore 16
    //   4358: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4361: ifeq -171 -> 4190
    //   4364: ldc_w 1781
    //   4367: iconst_2
    //   4368: ldc_w 2614
    //   4371: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4374: aload 4
    //   4376: astore 16
    //   4378: goto -188 -> 4190
    //   4381: aload_0
    //   4382: invokevirtual 47	amnh:getAppRuntime	()Lmqq/app/AppRuntime;
    //   4385: invokevirtual 2590	mqq/app/AppRuntime:getApplication	()Lmqq/app/MobileQQ;
    //   4388: getstatic 15	amnh:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   4391: invokestatic 1762	baig:H	(Landroid/content/Context;Ljava/lang/String;)I
    //   4394: istore 7
    //   4396: aload 19
    //   4398: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   4401: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   4404: istore 8
    //   4406: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4409: ifeq +35 -> 4444
    //   4412: ldc 183
    //   4414: iconst_2
    //   4415: ldc_w 2616
    //   4418: iconst_2
    //   4419: anewarray 301	java/lang/Object
    //   4422: dup
    //   4423: iconst_0
    //   4424: iload 7
    //   4426: invokestatic 305	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   4429: aastore
    //   4430: dup
    //   4431: iconst_1
    //   4432: iload 8
    //   4434: invokestatic 305	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   4437: aastore
    //   4438: invokestatic 309	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   4441: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4444: aconst_null
    //   4445: astore 17
    //   4447: iload 7
    //   4449: iload 8
    //   4451: if_icmpeq +386 -> 4837
    //   4454: aload 19
    //   4456: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   4459: ifnull +14 -> 4473
    //   4462: aload 19
    //   4464: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   4467: invokevirtual 2617	com/tencent/mobileqq/pb/PBRepeatField:isEmpty	()Z
    //   4470: ifeq +285 -> 4755
    //   4473: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4476: ifeq +12 -> 4488
    //   4479: ldc 183
    //   4481: iconst_2
    //   4482: ldc_w 2619
    //   4485: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4488: ldc_w 2621
    //   4491: getstatic 15	amnh:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   4494: invokestatic 2626	akgm:a	(Ljava/lang/String;Ljava/lang/String;)Z
    //   4497: pop
    //   4498: aconst_null
    //   4499: astore 16
    //   4501: aload_0
    //   4502: invokevirtual 47	amnh:getAppRuntime	()Lmqq/app/AppRuntime;
    //   4505: invokevirtual 2590	mqq/app/AppRuntime:getApplication	()Lmqq/app/MobileQQ;
    //   4508: getstatic 15	amnh:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   4511: iload 8
    //   4513: invokestatic 2628	baig:p	(Landroid/content/Context;Ljava/lang/String;I)V
    //   4516: aload_2
    //   4517: iconst_4
    //   4518: invokevirtual 206	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lajfb;
    //   4521: checkcast 1775	ajgd
    //   4524: astore 19
    //   4526: aload 16
    //   4528: invokestatic 126	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4531: ifne +468 -> 4999
    //   4534: invokestatic 2420	akgo:a	()Lakgo;
    //   4537: invokevirtual 2423	akgo:a	()Lcom/tencent/mobileqq/app/upgrade/UpgradeDetailWrapper;
    //   4540: astore 17
    //   4542: aload 17
    //   4544: aload 16
    //   4546: invokevirtual 2631	com/tencent/mobileqq/app/upgrade/UpgradeDetailWrapper:a	(Ljava/lang/String;)V
    //   4549: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4552: ifeq +42 -> 4594
    //   4555: ldc 183
    //   4557: iconst_2
    //   4558: ldc_w 2633
    //   4561: iconst_2
    //   4562: anewarray 301	java/lang/Object
    //   4565: dup
    //   4566: iconst_0
    //   4567: invokestatic 203	com/tencent/common/config/AppSetting:a	()I
    //   4570: invokestatic 305	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   4573: aastore
    //   4574: dup
    //   4575: iconst_1
    //   4576: aload 17
    //   4578: getfield 2636	com/tencent/mobileqq/app/upgrade/UpgradeDetailWrapper:jdField_b_of_type_ProtocolKQQConfigUpgradeInfo	Lprotocol/KQQConfig/UpgradeInfo;
    //   4581: getfield 2641	protocol/KQQConfig/UpgradeInfo:iUpgradeSdkId	I
    //   4584: invokestatic 305	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   4587: aastore
    //   4588: invokestatic 309	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   4591: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4594: aload_2
    //   4595: invokevirtual 65	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   4598: getstatic 15	amnh:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   4601: invokestatic 2644	baig:aM	(Landroid/content/Context;Ljava/lang/String;)I
    //   4604: aload 17
    //   4606: getfield 2636	com/tencent/mobileqq/app/upgrade/UpgradeDetailWrapper:jdField_b_of_type_ProtocolKQQConfigUpgradeInfo	Lprotocol/KQQConfig/UpgradeInfo;
    //   4609: getfield 2641	protocol/KQQConfig/UpgradeInfo:iUpgradeSdkId	I
    //   4612: if_icmpeq +69 -> 4681
    //   4615: aload_2
    //   4616: invokevirtual 65	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   4619: aload_2
    //   4620: invokevirtual 1585	com/tencent/mobileqq/app/QQAppInterface:c	()Ljava/lang/String;
    //   4623: iconst_0
    //   4624: invokestatic 2647	baig:ad	(Landroid/content/Context;Ljava/lang/String;I)V
    //   4627: aload_2
    //   4628: invokevirtual 65	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   4631: aload_2
    //   4632: invokevirtual 1585	com/tencent/mobileqq/app/QQAppInterface:c	()Ljava/lang/String;
    //   4635: lconst_0
    //   4636: invokestatic 2650	baig:i	(Landroid/content/Context;Ljava/lang/String;J)V
    //   4639: aload_2
    //   4640: invokevirtual 65	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   4643: aload_2
    //   4644: invokevirtual 1585	com/tencent/mobileqq/app/QQAppInterface:c	()Ljava/lang/String;
    //   4647: iconst_0
    //   4648: invokestatic 2653	baig:ae	(Landroid/content/Context;Ljava/lang/String;I)V
    //   4651: aload_2
    //   4652: invokevirtual 65	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   4655: aload_2
    //   4656: invokevirtual 1585	com/tencent/mobileqq/app/QQAppInterface:c	()Ljava/lang/String;
    //   4659: lconst_0
    //   4660: invokestatic 2655	baig:j	(Landroid/content/Context;Ljava/lang/String;J)V
    //   4663: aload_2
    //   4664: invokevirtual 65	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   4667: getstatic 15	amnh:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   4670: aload 17
    //   4672: getfield 2636	com/tencent/mobileqq/app/upgrade/UpgradeDetailWrapper:jdField_b_of_type_ProtocolKQQConfigUpgradeInfo	Lprotocol/KQQConfig/UpgradeInfo;
    //   4675: getfield 2641	protocol/KQQConfig/UpgradeInfo:iUpgradeSdkId	I
    //   4678: invokestatic 2657	baig:ac	(Landroid/content/Context;Ljava/lang/String;I)V
    //   4681: invokestatic 203	com/tencent/common/config/AppSetting:a	()I
    //   4684: aload 17
    //   4686: getfield 2636	com/tencent/mobileqq/app/upgrade/UpgradeDetailWrapper:jdField_b_of_type_ProtocolKQQConfigUpgradeInfo	Lprotocol/KQQConfig/UpgradeInfo;
    //   4689: getfield 2641	protocol/KQQConfig/UpgradeInfo:iUpgradeSdkId	I
    //   4692: if_icmplt +171 -> 4863
    //   4695: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4698: ifeq +12 -> 4710
    //   4701: ldc 183
    //   4703: iconst_2
    //   4704: ldc_w 2659
    //   4707: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4710: aload_2
    //   4711: invokevirtual 65	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   4714: getstatic 15	amnh:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   4717: iconst_0
    //   4718: invokestatic 2628	baig:p	(Landroid/content/Context;Ljava/lang/String;I)V
    //   4721: ldc_w 2621
    //   4724: getstatic 15	amnh:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   4727: invokestatic 2626	akgm:a	(Ljava/lang/String;Ljava/lang/String;)Z
    //   4730: pop
    //   4731: aload 17
    //   4733: getfield 2636	com/tencent/mobileqq/app/upgrade/UpgradeDetailWrapper:jdField_b_of_type_ProtocolKQQConfigUpgradeInfo	Lprotocol/KQQConfig/UpgradeInfo;
    //   4736: iconst_0
    //   4737: putfield 2662	protocol/KQQConfig/UpgradeInfo:iUpgradeType	I
    //   4740: aload 19
    //   4742: aload 17
    //   4744: invokevirtual 2426	ajgd:a	(Lcom/tencent/mobileqq/app/upgrade/UpgradeDetailWrapper;)V
    //   4747: aload 19
    //   4749: invokevirtual 2663	ajgd:c	()V
    //   4752: goto +7619 -> 12371
    //   4755: aload 19
    //   4757: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   4760: iconst_0
    //   4761: invokevirtual 116	com/tencent/mobileqq/pb/PBRepeatField:get	(I)Ljava/lang/Object;
    //   4764: checkcast 118	java/lang/String
    //   4767: astore 16
    //   4769: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4772: ifeq +30 -> 4802
    //   4775: ldc 183
    //   4777: iconst_2
    //   4778: new 85	java/lang/StringBuilder
    //   4781: dup
    //   4782: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   4785: ldc_w 2665
    //   4788: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4791: aload 16
    //   4793: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4796: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4799: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4802: aload 16
    //   4804: invokestatic 126	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4807: ifeq +16 -> 4823
    //   4810: ldc_w 2621
    //   4813: getstatic 15	amnh:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   4816: invokestatic 2626	akgm:a	(Ljava/lang/String;Ljava/lang/String;)Z
    //   4819: pop
    //   4820: goto -319 -> 4501
    //   4823: ldc_w 2621
    //   4826: getstatic 15	amnh:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   4829: aload 16
    //   4831: invokestatic 2668	akgm:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   4834: goto -333 -> 4501
    //   4837: aload 17
    //   4839: astore 16
    //   4841: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4844: ifeq -328 -> 4516
    //   4847: ldc 183
    //   4849: iconst_2
    //   4850: ldc_w 2670
    //   4853: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4856: aload 17
    //   4858: astore 16
    //   4860: goto -344 -> 4516
    //   4863: aload_0
    //   4864: invokevirtual 47	amnh:getAppRuntime	()Lmqq/app/AppRuntime;
    //   4867: invokevirtual 2590	mqq/app/AppRuntime:getApplication	()Lmqq/app/MobileQQ;
    //   4870: getstatic 15	amnh:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   4873: invokestatic 2566	java/lang/System:currentTimeMillis	()J
    //   4876: invokestatic 2672	baig:a	(Landroid/content/Context;Ljava/lang/String;J)V
    //   4879: aload 17
    //   4881: monitorenter
    //   4882: aload 17
    //   4884: getfield 2673	com/tencent/mobileqq/app/upgrade/UpgradeDetailWrapper:jdField_a_of_type_Boolean	Z
    //   4887: ifne +27 -> 4914
    //   4890: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4893: ifeq +12 -> 4905
    //   4896: ldc 183
    //   4898: iconst_2
    //   4899: ldc_w 2675
    //   4902: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4905: aload 17
    //   4907: monitorexit
    //   4908: iconst_1
    //   4909: istore 10
    //   4911: goto +7460 -> 12371
    //   4914: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4917: ifeq +12 -> 4929
    //   4920: ldc 183
    //   4922: iconst_2
    //   4923: ldc_w 2677
    //   4926: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4929: aload 17
    //   4931: getfield 2679	com/tencent/mobileqq/app/upgrade/UpgradeDetailWrapper:jdField_b_of_type_Int	I
    //   4934: ifne +21 -> 4955
    //   4937: aload 17
    //   4939: getfield 2680	com/tencent/mobileqq/app/upgrade/UpgradeDetailWrapper:jdField_a_of_type_Int	I
    //   4942: iconst_1
    //   4943: if_icmpne +7450 -> 12393
    //   4946: iconst_1
    //   4947: istore 10
    //   4949: aload_2
    //   4950: iload 10
    //   4952: invokestatic 2681	ajgd:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Z)V
    //   4955: aload 19
    //   4957: invokevirtual 2663	ajgd:c	()V
    //   4960: invokestatic 2420	akgo:a	()Lakgo;
    //   4963: aload 17
    //   4965: getfield 2636	com/tencent/mobileqq/app/upgrade/UpgradeDetailWrapper:jdField_b_of_type_ProtocolKQQConfigUpgradeInfo	Lprotocol/KQQConfig/UpgradeInfo;
    //   4968: aload 19
    //   4970: invokevirtual 2684	akgo:a	(Lprotocol/KQQConfig/UpgradeInfo;Lakgq;)Z
    //   4973: pop
    //   4974: aload 17
    //   4976: monitorexit
    //   4977: iconst_1
    //   4978: istore 10
    //   4980: goto +7391 -> 12371
    //   4983: astore 16
    //   4985: aload 17
    //   4987: monitorexit
    //   4988: aload 16
    //   4990: athrow
    //   4991: astore 17
    //   4993: iconst_1
    //   4994: istore 10
    //   4996: goto -697 -> 4299
    //   4999: aload 19
    //   5001: invokevirtual 2663	ajgd:c	()V
    //   5004: aload 19
    //   5006: invokestatic 2420	akgo:a	()Lakgo;
    //   5009: invokevirtual 2423	akgo:a	()Lcom/tencent/mobileqq/app/upgrade/UpgradeDetailWrapper;
    //   5012: invokevirtual 2426	ajgd:a	(Lcom/tencent/mobileqq/app/upgrade/UpgradeDetailWrapper;)V
    //   5015: goto +7356 -> 12371
    //   5018: aload 19
    //   5020: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   5023: ifnull +141 -> 5164
    //   5026: aload 19
    //   5028: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   5031: invokevirtual 113	com/tencent/mobileqq/pb/PBRepeatField:size	()I
    //   5034: ifle +130 -> 5164
    //   5037: aload_0
    //   5038: invokevirtual 47	amnh:getAppRuntime	()Lmqq/app/AppRuntime;
    //   5041: invokevirtual 2590	mqq/app/AppRuntime:getApplication	()Lmqq/app/MobileQQ;
    //   5044: aload 19
    //   5046: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   5049: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   5052: getstatic 15	amnh:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   5055: invokestatic 2686	baig:f	(Landroid/content/Context;ILjava/lang/String;)V
    //   5058: iconst_0
    //   5059: istore 7
    //   5061: iload 7
    //   5063: aload 19
    //   5065: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   5068: invokevirtual 113	com/tencent/mobileqq/pb/PBRepeatField:size	()I
    //   5071: if_icmpge +7337 -> 12408
    //   5074: aload 19
    //   5076: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   5079: iload 7
    //   5081: invokevirtual 116	com/tencent/mobileqq/pb/PBRepeatField:get	(I)Ljava/lang/Object;
    //   5084: checkcast 118	java/lang/String
    //   5087: astore 16
    //   5089: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5092: ifeq +47 -> 5139
    //   5095: ldc 183
    //   5097: iconst_2
    //   5098: new 85	java/lang/StringBuilder
    //   5101: dup
    //   5102: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   5105: ldc_w 2688
    //   5108: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5111: aload 16
    //   5113: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5116: ldc_w 604
    //   5119: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5122: aload 19
    //   5124: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   5127: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   5130: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5133: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5136: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   5139: aload 16
    //   5141: invokestatic 126	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   5144: ifne +7255 -> 12399
    //   5147: aload_2
    //   5148: bipush 60
    //   5150: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   5153: checkcast 2690	com/tencent/mobileqq/app/HotChatManager
    //   5156: aload 16
    //   5158: invokevirtual 2692	com/tencent/mobileqq/app/HotChatManager:d	(Ljava/lang/String;)V
    //   5161: goto +7238 -> 12399
    //   5164: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5167: ifeq +7204 -> 12371
    //   5170: ldc 183
    //   5172: iconst_2
    //   5173: new 85	java/lang/StringBuilder
    //   5176: dup
    //   5177: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   5180: ldc_w 2694
    //   5183: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5186: aload 19
    //   5188: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   5191: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   5194: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5197: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5200: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   5203: goto +7168 -> 12371
    //   5206: aload 19
    //   5208: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   5211: ifnull +142 -> 5353
    //   5214: aload 19
    //   5216: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   5219: invokevirtual 113	com/tencent/mobileqq/pb/PBRepeatField:size	()I
    //   5222: ifle +131 -> 5353
    //   5225: aload_0
    //   5226: invokevirtual 47	amnh:getAppRuntime	()Lmqq/app/AppRuntime;
    //   5229: invokevirtual 2590	mqq/app/AppRuntime:getApplication	()Lmqq/app/MobileQQ;
    //   5232: aload 19
    //   5234: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   5237: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   5240: getstatic 15	amnh:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   5243: invokestatic 2696	baig:d	(Landroid/content/Context;ILjava/lang/String;)V
    //   5246: iconst_0
    //   5247: istore 7
    //   5249: iload 7
    //   5251: aload 19
    //   5253: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   5256: invokevirtual 113	com/tencent/mobileqq/pb/PBRepeatField:size	()I
    //   5259: if_icmpge +7161 -> 12420
    //   5262: aload 19
    //   5264: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   5267: iload 7
    //   5269: invokevirtual 116	com/tencent/mobileqq/pb/PBRepeatField:get	(I)Ljava/lang/Object;
    //   5272: checkcast 118	java/lang/String
    //   5275: astore 16
    //   5277: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5280: ifeq +47 -> 5327
    //   5283: ldc 183
    //   5285: iconst_2
    //   5286: new 85	java/lang/StringBuilder
    //   5289: dup
    //   5290: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   5293: ldc_w 2698
    //   5296: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5299: aload 16
    //   5301: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5304: ldc_w 604
    //   5307: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5310: aload 19
    //   5312: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   5315: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   5318: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5321: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5324: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   5327: aload 16
    //   5329: invokestatic 126	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   5332: ifne +7079 -> 12411
    //   5335: aload_2
    //   5336: bipush 51
    //   5338: invokevirtual 206	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lajfb;
    //   5341: checkcast 2700	xrh
    //   5344: aload 16
    //   5346: iconst_0
    //   5347: invokevirtual 2703	xrh:a	(Ljava/lang/String;Z)V
    //   5350: goto +7061 -> 12411
    //   5353: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5356: ifeq +7015 -> 12371
    //   5359: ldc 183
    //   5361: iconst_2
    //   5362: new 85	java/lang/StringBuilder
    //   5365: dup
    //   5366: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   5369: ldc_w 2705
    //   5372: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5375: aload 19
    //   5377: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   5380: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   5383: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5386: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5389: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   5392: goto +6979 -> 12371
    //   5395: aload 19
    //   5397: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   5400: ifnull +6971 -> 12371
    //   5403: aload_0
    //   5404: invokevirtual 47	amnh:getAppRuntime	()Lmqq/app/AppRuntime;
    //   5407: invokevirtual 2590	mqq/app/AppRuntime:getApplication	()Lmqq/app/MobileQQ;
    //   5410: aload 19
    //   5412: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   5415: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   5418: getstatic 15	amnh:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   5421: invokestatic 2707	baig:e	(Landroid/content/Context;ILjava/lang/String;)V
    //   5424: aload_2
    //   5425: bipush 51
    //   5427: invokevirtual 206	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lajfb;
    //   5430: checkcast 2700	xrh
    //   5433: aload 19
    //   5435: invokevirtual 2709	xrh:a	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   5438: goto +6933 -> 12371
    //   5441: aload 19
    //   5443: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   5446: ifnull +276 -> 5722
    //   5449: aload 19
    //   5451: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   5454: invokevirtual 113	com/tencent/mobileqq/pb/PBRepeatField:size	()I
    //   5457: ifle +265 -> 5722
    //   5460: new 2711	java/io/File
    //   5463: dup
    //   5464: new 85	java/lang/StringBuilder
    //   5467: dup
    //   5468: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   5471: aload_0
    //   5472: invokevirtual 47	amnh:getAppRuntime	()Lmqq/app/AppRuntime;
    //   5475: invokevirtual 2590	mqq/app/AppRuntime:getApplication	()Lmqq/app/MobileQQ;
    //   5478: invokevirtual 2717	mqq/app/MobileQQ:getFilesDir	()Ljava/io/File;
    //   5481: invokevirtual 2720	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   5484: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5487: ldc_w 2722
    //   5490: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5493: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5496: invokespecial 2723	java/io/File:<init>	(Ljava/lang/String;)V
    //   5499: astore 16
    //   5501: aload 16
    //   5503: invokevirtual 2726	java/io/File:exists	()Z
    //   5506: ifne +152 -> 5658
    //   5509: aload 16
    //   5511: invokevirtual 2729	java/io/File:mkdirs	()Z
    //   5514: pop
    //   5515: aload 19
    //   5517: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   5520: invokevirtual 1143	com/tencent/mobileqq/pb/PBRepeatField:get	()Ljava/util/List;
    //   5523: invokeinterface 233 1 0
    //   5528: astore 16
    //   5530: aload 16
    //   5532: invokeinterface 238 1 0
    //   5537: ifeq +6895 -> 12432
    //   5540: aload 16
    //   5542: invokeinterface 242 1 0
    //   5547: checkcast 118	java/lang/String
    //   5550: astore 17
    //   5552: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5555: ifeq +47 -> 5602
    //   5558: ldc 183
    //   5560: iconst_2
    //   5561: new 85	java/lang/StringBuilder
    //   5564: dup
    //   5565: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   5568: ldc_w 2731
    //   5571: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5574: aload 17
    //   5576: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5579: ldc_w 604
    //   5582: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5585: aload 19
    //   5587: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   5590: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   5593: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5596: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5599: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   5602: aload_0
    //   5603: aload 17
    //   5605: aload 19
    //   5607: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   5610: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   5613: invokespecial 2734	amnh:e	(Ljava/lang/String;I)V
    //   5616: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5619: ifeq -89 -> 5530
    //   5622: ldc 183
    //   5624: iconst_2
    //   5625: new 85	java/lang/StringBuilder
    //   5628: dup
    //   5629: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   5632: ldc_w 2736
    //   5635: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5638: aload 19
    //   5640: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   5643: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   5646: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5649: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5652: invokestatic 199	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   5655: goto -125 -> 5530
    //   5658: aload 16
    //   5660: ifnull -145 -> 5515
    //   5663: aload 16
    //   5665: invokevirtual 2739	java/io/File:isDirectory	()Z
    //   5668: ifeq -153 -> 5515
    //   5671: aload 16
    //   5673: invokevirtual 2743	java/io/File:listFiles	()[Ljava/io/File;
    //   5676: astore 16
    //   5678: aload 16
    //   5680: arraylength
    //   5681: istore 8
    //   5683: iconst_0
    //   5684: istore 7
    //   5686: iload 7
    //   5688: iload 8
    //   5690: if_icmpge -175 -> 5515
    //   5693: aload 16
    //   5695: iload 7
    //   5697: aaload
    //   5698: astore 17
    //   5700: aload 17
    //   5702: ifnull +6721 -> 12423
    //   5705: aload 17
    //   5707: invokevirtual 2726	java/io/File:exists	()Z
    //   5710: ifeq +6713 -> 12423
    //   5713: aload 17
    //   5715: invokevirtual 2746	java/io/File:delete	()Z
    //   5718: pop
    //   5719: goto +6704 -> 12423
    //   5722: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5725: ifeq +36 -> 5761
    //   5728: ldc 183
    //   5730: iconst_2
    //   5731: new 85	java/lang/StringBuilder
    //   5734: dup
    //   5735: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   5738: ldc_w 2748
    //   5741: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5744: aload 19
    //   5746: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   5749: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   5752: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5755: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5758: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   5761: new 2711	java/io/File
    //   5764: dup
    //   5765: new 85	java/lang/StringBuilder
    //   5768: dup
    //   5769: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   5772: aload_0
    //   5773: invokevirtual 47	amnh:getAppRuntime	()Lmqq/app/AppRuntime;
    //   5776: invokevirtual 2590	mqq/app/AppRuntime:getApplication	()Lmqq/app/MobileQQ;
    //   5779: invokevirtual 2717	mqq/app/MobileQQ:getFilesDir	()Ljava/io/File;
    //   5782: invokevirtual 2720	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   5785: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5788: ldc_w 2750
    //   5791: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5794: ldc_w 2752
    //   5797: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5800: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5803: invokespecial 2723	java/io/File:<init>	(Ljava/lang/String;)V
    //   5806: astore 16
    //   5808: aload 16
    //   5810: ifnull +9 -> 5819
    //   5813: aload 16
    //   5815: invokevirtual 2746	java/io/File:delete	()Z
    //   5818: pop
    //   5819: aload_0
    //   5820: invokevirtual 47	amnh:getAppRuntime	()Lmqq/app/AppRuntime;
    //   5823: invokevirtual 2590	mqq/app/AppRuntime:getApplication	()Lmqq/app/MobileQQ;
    //   5826: aload 19
    //   5828: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   5831: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   5834: ldc_w 2754
    //   5837: ldc 13
    //   5839: invokestatic 2757	baig:a	(Landroid/content/Context;ILjava/lang/String;Ljava/lang/String;)V
    //   5842: goto +6529 -> 12371
    //   5845: aload 19
    //   5847: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   5850: ifnull +323 -> 6173
    //   5853: aload 19
    //   5855: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   5858: invokevirtual 113	com/tencent/mobileqq/pb/PBRepeatField:size	()I
    //   5861: ifle +312 -> 6173
    //   5864: getstatic 2762	alzf:a	Lamnt;
    //   5867: invokevirtual 2765	amnt:b	()V
    //   5870: aload 19
    //   5872: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   5875: invokevirtual 1143	com/tencent/mobileqq/pb/PBRepeatField:get	()Ljava/util/List;
    //   5878: invokeinterface 233 1 0
    //   5883: astore 16
    //   5885: aload 16
    //   5887: invokeinterface 238 1 0
    //   5892: ifeq +82 -> 5974
    //   5895: aload 16
    //   5897: invokeinterface 242 1 0
    //   5902: checkcast 118	java/lang/String
    //   5905: astore 17
    //   5907: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5910: ifeq +47 -> 5957
    //   5913: ldc 183
    //   5915: iconst_2
    //   5916: new 85	java/lang/StringBuilder
    //   5919: dup
    //   5920: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   5923: ldc_w 2767
    //   5926: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5929: aload 17
    //   5931: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5934: ldc_w 604
    //   5937: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5940: aload 19
    //   5942: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   5945: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   5948: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5951: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5954: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   5957: aload_0
    //   5958: aload 17
    //   5960: aload 19
    //   5962: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   5965: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   5968: invokespecial 2769	amnh:c	(Ljava/lang/String;I)V
    //   5971: goto -86 -> 5885
    //   5974: new 2771	alzh
    //   5977: dup
    //   5978: aload_0
    //   5979: invokevirtual 47	amnh:getAppRuntime	()Lmqq/app/AppRuntime;
    //   5982: invokevirtual 2590	mqq/app/AppRuntime:getApplication	()Lmqq/app/MobileQQ;
    //   5985: getstatic 15	amnh:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   5988: invokespecial 2773	alzh:<init>	(Landroid/content/Context;Ljava/lang/String;)V
    //   5991: astore 16
    //   5993: aload 16
    //   5995: ifnull +13 -> 6008
    //   5998: aload 16
    //   6000: invokevirtual 2774	alzh:b	()V
    //   6003: aload 16
    //   6005: invokevirtual 2775	alzh:c	()V
    //   6008: invokestatic 385	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   6011: ldc_w 2777
    //   6014: iconst_0
    //   6015: invokevirtual 340	com/tencent/qphone/base/util/BaseApplication:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   6018: astore 16
    //   6020: aload 16
    //   6022: invokeinterface 346 1 0
    //   6027: new 85	java/lang/StringBuilder
    //   6030: dup
    //   6031: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   6034: ldc_w 2779
    //   6037: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6040: aload_0
    //   6041: invokevirtual 47	amnh:getAppRuntime	()Lmqq/app/AppRuntime;
    //   6044: invokevirtual 2780	mqq/app/AppRuntime:getAccount	()Ljava/lang/String;
    //   6047: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6050: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6053: iconst_1
    //   6054: invokeinterface 354 3 0
    //   6059: invokeinterface 726 1 0
    //   6064: pop
    //   6065: aload 16
    //   6067: invokeinterface 346 1 0
    //   6072: new 85	java/lang/StringBuilder
    //   6075: dup
    //   6076: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   6079: ldc_w 2782
    //   6082: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6085: aload_0
    //   6086: invokevirtual 47	amnh:getAppRuntime	()Lmqq/app/AppRuntime;
    //   6089: invokevirtual 2780	mqq/app/AppRuntime:getAccount	()Ljava/lang/String;
    //   6092: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6095: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6098: iconst_1
    //   6099: invokeinterface 354 3 0
    //   6104: invokeinterface 726 1 0
    //   6109: pop
    //   6110: aload_0
    //   6111: invokevirtual 47	amnh:getAppRuntime	()Lmqq/app/AppRuntime;
    //   6114: invokevirtual 2590	mqq/app/AppRuntime:getApplication	()Lmqq/app/MobileQQ;
    //   6117: aload 19
    //   6119: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   6122: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   6125: getstatic 15	amnh:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   6128: invokestatic 2686	baig:f	(Landroid/content/Context;ILjava/lang/String;)V
    //   6131: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6134: ifeq +6301 -> 12435
    //   6137: ldc 183
    //   6139: iconst_2
    //   6140: new 85	java/lang/StringBuilder
    //   6143: dup
    //   6144: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   6147: ldc_w 2784
    //   6150: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6153: aload 19
    //   6155: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   6158: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   6161: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6164: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6167: invokestatic 199	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   6170: goto +6265 -> 12435
    //   6173: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6176: ifeq +36 -> 6212
    //   6179: ldc 183
    //   6181: iconst_2
    //   6182: new 85	java/lang/StringBuilder
    //   6185: dup
    //   6186: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   6189: ldc_w 2786
    //   6192: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6195: aload 19
    //   6197: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   6200: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   6203: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6206: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6209: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   6212: getstatic 2762	alzf:a	Lamnt;
    //   6215: invokevirtual 2765	amnt:b	()V
    //   6218: getstatic 2762	alzf:a	Lamnt;
    //   6221: invokevirtual 2787	amnt:c	()V
    //   6224: new 2771	alzh
    //   6227: dup
    //   6228: aload_0
    //   6229: invokevirtual 47	amnh:getAppRuntime	()Lmqq/app/AppRuntime;
    //   6232: invokevirtual 2590	mqq/app/AppRuntime:getApplication	()Lmqq/app/MobileQQ;
    //   6235: getstatic 15	amnh:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   6238: invokespecial 2773	alzh:<init>	(Landroid/content/Context;Ljava/lang/String;)V
    //   6241: astore 16
    //   6243: aload 16
    //   6245: ifnull +13 -> 6258
    //   6248: aload 16
    //   6250: invokevirtual 2774	alzh:b	()V
    //   6253: aload 16
    //   6255: invokevirtual 2775	alzh:c	()V
    //   6258: invokestatic 385	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   6261: ldc_w 2777
    //   6264: iconst_0
    //   6265: invokevirtual 340	com/tencent/qphone/base/util/BaseApplication:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   6268: invokeinterface 346 1 0
    //   6273: new 85	java/lang/StringBuilder
    //   6276: dup
    //   6277: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   6280: ldc_w 2782
    //   6283: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6286: aload_0
    //   6287: invokevirtual 47	amnh:getAppRuntime	()Lmqq/app/AppRuntime;
    //   6290: invokevirtual 2780	mqq/app/AppRuntime:getAccount	()Ljava/lang/String;
    //   6293: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6296: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6299: iconst_0
    //   6300: invokeinterface 354 3 0
    //   6305: invokeinterface 726 1 0
    //   6310: pop
    //   6311: aload_0
    //   6312: invokevirtual 47	amnh:getAppRuntime	()Lmqq/app/AppRuntime;
    //   6315: invokevirtual 2590	mqq/app/AppRuntime:getApplication	()Lmqq/app/MobileQQ;
    //   6318: aload 19
    //   6320: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   6323: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   6326: getstatic 15	amnh:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   6329: invokestatic 2686	baig:f	(Landroid/content/Context;ILjava/lang/String;)V
    //   6332: goto +6039 -> 12371
    //   6335: aload 19
    //   6337: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   6340: ifnull +95 -> 6435
    //   6343: aload 19
    //   6345: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   6348: invokevirtual 113	com/tencent/mobileqq/pb/PBRepeatField:size	()I
    //   6351: ifle +84 -> 6435
    //   6354: aload 19
    //   6356: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   6359: iconst_0
    //   6360: invokevirtual 116	com/tencent/mobileqq/pb/PBRepeatField:get	(I)Ljava/lang/Object;
    //   6363: checkcast 118	java/lang/String
    //   6366: astore 16
    //   6368: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6371: ifeq +47 -> 6418
    //   6374: ldc 183
    //   6376: iconst_2
    //   6377: new 85	java/lang/StringBuilder
    //   6380: dup
    //   6381: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   6384: ldc_w 2789
    //   6387: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6390: aload 16
    //   6392: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6395: ldc_w 604
    //   6398: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6401: aload 19
    //   6403: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   6406: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   6409: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6412: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6415: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   6418: aload_0
    //   6419: aload 16
    //   6421: aload 19
    //   6423: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   6426: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   6429: invokespecial 2791	amnh:d	(Ljava/lang/String;I)V
    //   6432: goto +5939 -> 12371
    //   6435: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6438: ifeq +36 -> 6474
    //   6441: ldc 183
    //   6443: iconst_2
    //   6444: new 85	java/lang/StringBuilder
    //   6447: dup
    //   6448: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   6451: ldc_w 2793
    //   6454: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6457: aload 19
    //   6459: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   6462: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   6465: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6468: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6471: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   6474: new 2711	java/io/File
    //   6477: dup
    //   6478: new 85	java/lang/StringBuilder
    //   6481: dup
    //   6482: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   6485: aload_0
    //   6486: invokevirtual 47	amnh:getAppRuntime	()Lmqq/app/AppRuntime;
    //   6489: invokevirtual 2590	mqq/app/AppRuntime:getApplication	()Lmqq/app/MobileQQ;
    //   6492: invokevirtual 2717	mqq/app/MobileQQ:getFilesDir	()Ljava/io/File;
    //   6495: invokevirtual 2720	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   6498: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6501: ldc_w 2750
    //   6504: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6507: getstatic 15	amnh:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   6510: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6513: ldc_w 2750
    //   6516: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6519: ldc_w 2795
    //   6522: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6525: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6528: invokespecial 2723	java/io/File:<init>	(Ljava/lang/String;)V
    //   6531: astore 16
    //   6533: aload 16
    //   6535: invokevirtual 2726	java/io/File:exists	()Z
    //   6538: ifeq +9 -> 6547
    //   6541: aload 16
    //   6543: invokevirtual 2746	java/io/File:delete	()Z
    //   6546: pop
    //   6547: aload_0
    //   6548: invokevirtual 47	amnh:getAppRuntime	()Lmqq/app/AppRuntime;
    //   6551: invokevirtual 2590	mqq/app/AppRuntime:getApplication	()Lmqq/app/MobileQQ;
    //   6554: aload 19
    //   6556: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   6559: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   6562: ldc 13
    //   6564: getstatic 15	amnh:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   6567: invokestatic 2797	baig:b	(Landroid/content/Context;ILjava/lang/String;Ljava/lang/String;)V
    //   6570: goto +5801 -> 12371
    //   6573: aload 19
    //   6575: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   6578: ifnull +178 -> 6756
    //   6581: aload 19
    //   6583: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   6586: invokevirtual 113	com/tencent/mobileqq/pb/PBRepeatField:size	()I
    //   6589: ifle +167 -> 6756
    //   6592: new 1121	java/util/ArrayList
    //   6595: dup
    //   6596: invokespecial 1122	java/util/ArrayList:<init>	()V
    //   6599: astore 16
    //   6601: iconst_0
    //   6602: istore 7
    //   6604: iload 7
    //   6606: aload 19
    //   6608: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   6611: invokevirtual 113	com/tencent/mobileqq/pb/PBRepeatField:size	()I
    //   6614: if_icmpge +92 -> 6706
    //   6617: aload 19
    //   6619: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   6622: iload 7
    //   6624: invokevirtual 116	com/tencent/mobileqq/pb/PBRepeatField:get	(I)Ljava/lang/Object;
    //   6627: checkcast 118	java/lang/String
    //   6630: astore 17
    //   6632: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6635: ifeq +47 -> 6682
    //   6638: ldc 183
    //   6640: iconst_2
    //   6641: new 85	java/lang/StringBuilder
    //   6644: dup
    //   6645: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   6648: ldc_w 2799
    //   6651: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6654: aload 17
    //   6656: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6659: ldc_w 604
    //   6662: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6665: aload 19
    //   6667: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   6670: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   6673: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6676: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6679: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   6682: aload_0
    //   6683: aload 17
    //   6685: invokespecial 2801	amnh:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/config/operation/QQOperationViopTipTask;
    //   6688: astore 17
    //   6690: aload 17
    //   6692: ifnull +5746 -> 12438
    //   6695: aload 16
    //   6697: aload 17
    //   6699: invokevirtual 1155	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   6702: pop
    //   6703: goto +5735 -> 12438
    //   6706: aload_0
    //   6707: invokevirtual 47	amnh:getAppRuntime	()Lmqq/app/AppRuntime;
    //   6710: checkcast 49	com/tencent/mobileqq/app/QQAppInterface
    //   6713: invokestatic 2806	amnb:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)Lamnb;
    //   6716: aload_0
    //   6717: invokevirtual 47	amnh:getAppRuntime	()Lmqq/app/AppRuntime;
    //   6720: checkcast 49	com/tencent/mobileqq/app/QQAppInterface
    //   6723: aload 16
    //   6725: invokevirtual 2809	amnb:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/util/ArrayList;)V
    //   6728: aload_0
    //   6729: invokevirtual 47	amnh:getAppRuntime	()Lmqq/app/AppRuntime;
    //   6732: invokevirtual 2590	mqq/app/AppRuntime:getApplication	()Lmqq/app/MobileQQ;
    //   6735: aload_0
    //   6736: invokevirtual 47	amnh:getAppRuntime	()Lmqq/app/AppRuntime;
    //   6739: invokevirtual 2780	mqq/app/AppRuntime:getAccount	()Ljava/lang/String;
    //   6742: aload 19
    //   6744: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   6747: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   6750: invokestatic 2810	baig:a	(Landroid/content/Context;Ljava/lang/String;I)V
    //   6753: goto +5618 -> 12371
    //   6756: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6759: ifeq +5612 -> 12371
    //   6762: ldc 183
    //   6764: iconst_2
    //   6765: new 85	java/lang/StringBuilder
    //   6768: dup
    //   6769: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   6772: ldc_w 2812
    //   6775: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6778: aload 19
    //   6780: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   6783: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   6786: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6789: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6792: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   6795: goto +5576 -> 12371
    //   6798: aload_2
    //   6799: bipush 74
    //   6801: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   6804: checkcast 1385	amnr
    //   6807: astore 16
    //   6809: aload 16
    //   6811: invokevirtual 2815	amnr:a	()Ljava/util/Set;
    //   6814: astore 20
    //   6816: new 2764	amnt
    //   6819: dup
    //   6820: bipush 21
    //   6822: iconst_2
    //   6823: invokespecial 2818	amnt:<init>	(SB)V
    //   6826: astore 17
    //   6828: aload 19
    //   6830: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   6833: ifnull +129 -> 6962
    //   6836: aload 19
    //   6838: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   6841: invokevirtual 113	com/tencent/mobileqq/pb/PBRepeatField:size	()I
    //   6844: ifle +118 -> 6962
    //   6847: aload 19
    //   6849: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   6852: invokevirtual 1143	com/tencent/mobileqq/pb/PBRepeatField:get	()Ljava/util/List;
    //   6855: invokeinterface 233 1 0
    //   6860: astore 21
    //   6862: aload 21
    //   6864: invokeinterface 238 1 0
    //   6869: ifeq +132 -> 7001
    //   6872: aload 21
    //   6874: invokeinterface 242 1 0
    //   6879: checkcast 118	java/lang/String
    //   6882: astore 22
    //   6884: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6887: ifeq +47 -> 6934
    //   6890: ldc 183
    //   6892: iconst_2
    //   6893: new 85	java/lang/StringBuilder
    //   6896: dup
    //   6897: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   6900: ldc_w 2820
    //   6903: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6906: aload 22
    //   6908: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6911: ldc_w 604
    //   6914: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6917: aload 19
    //   6919: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   6922: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   6925: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6928: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6931: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   6934: aload 17
    //   6936: aload 22
    //   6938: aload 20
    //   6940: invokestatic 2823	amnh:a	(Lamnt;Ljava/lang/String;Ljava/util/Set;)Z
    //   6943: pop
    //   6944: aload 16
    //   6946: aload 17
    //   6948: aload 19
    //   6950: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   6953: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   6956: invokevirtual 2826	amnr:a	(Lamnt;I)V
    //   6959: goto -97 -> 6862
    //   6962: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6965: ifeq +36 -> 7001
    //   6968: ldc 183
    //   6970: iconst_2
    //   6971: new 85	java/lang/StringBuilder
    //   6974: dup
    //   6975: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   6978: ldc_w 2828
    //   6981: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6984: aload 19
    //   6986: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   6989: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   6992: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6995: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6998: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   7001: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7004: ifeq +76 -> 7080
    //   7007: new 85	java/lang/StringBuilder
    //   7010: dup
    //   7011: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   7014: ldc_w 2830
    //   7017: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7020: astore 20
    //   7022: aload 19
    //   7024: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   7027: ifnonnull +69 -> 7096
    //   7030: iconst_0
    //   7031: istore 7
    //   7033: ldc 183
    //   7035: iconst_2
    //   7036: aload 20
    //   7038: iload 7
    //   7040: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7043: ldc_w 2832
    //   7046: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7049: aload 17
    //   7051: invokevirtual 2833	amnt:a	()I
    //   7054: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7057: ldc_w 2835
    //   7060: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7063: aload 19
    //   7065: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   7068: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   7071: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7074: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7077: invokestatic 199	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   7080: aload 16
    //   7082: aload 19
    //   7084: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   7087: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   7090: invokevirtual 2836	amnr:a	(I)V
    //   7093: goto +5278 -> 12371
    //   7096: aload 19
    //   7098: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   7101: invokevirtual 1143	com/tencent/mobileqq/pb/PBRepeatField:get	()Ljava/util/List;
    //   7104: invokeinterface 400 1 0
    //   7109: istore 7
    //   7111: goto -78 -> 7033
    //   7114: aload_2
    //   7115: invokevirtual 65	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   7118: aload_2
    //   7119: invokevirtual 411	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   7122: invokestatic 1411	baig:j	(Landroid/content/Context;Ljava/lang/String;)I
    //   7125: istore 8
    //   7127: aload 19
    //   7129: ifnull +5318 -> 12447
    //   7132: aload 19
    //   7134: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   7137: ifnull +5310 -> 12447
    //   7140: aload 19
    //   7142: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   7145: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   7148: istore 7
    //   7150: aload 19
    //   7152: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   7155: ifnull +185 -> 7340
    //   7158: aload 19
    //   7160: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   7163: invokevirtual 113	com/tencent/mobileqq/pb/PBRepeatField:size	()I
    //   7166: ifle +174 -> 7340
    //   7169: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7172: ifeq +79 -> 7251
    //   7175: ldc 183
    //   7177: iconst_2
    //   7178: new 85	java/lang/StringBuilder
    //   7181: dup
    //   7182: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   7185: ldc_w 2838
    //   7188: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7191: iload 7
    //   7193: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7196: ldc_w 2840
    //   7199: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7202: iload 8
    //   7204: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7207: ldc_w 2842
    //   7210: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7213: aload 19
    //   7215: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   7218: invokevirtual 113	com/tencent/mobileqq/pb/PBRepeatField:size	()I
    //   7221: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7224: ldc_w 2844
    //   7227: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7230: aload 19
    //   7232: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   7235: iconst_0
    //   7236: invokevirtual 116	com/tencent/mobileqq/pb/PBRepeatField:get	(I)Ljava/lang/Object;
    //   7239: checkcast 118	java/lang/String
    //   7242: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7245: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7248: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   7251: new 522	java/util/HashSet
    //   7254: dup
    //   7255: invokespecial 523	java/util/HashSet:<init>	()V
    //   7258: astore 16
    //   7260: iconst_0
    //   7261: istore 8
    //   7263: iload 8
    //   7265: aload 19
    //   7267: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   7270: invokevirtual 113	com/tencent/mobileqq/pb/PBRepeatField:size	()I
    //   7273: if_icmpge +30 -> 7303
    //   7276: aload 16
    //   7278: aload 19
    //   7280: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   7283: iload 8
    //   7285: invokevirtual 116	com/tencent/mobileqq/pb/PBRepeatField:get	(I)Ljava/lang/Object;
    //   7288: invokeinterface 2847 2 0
    //   7293: pop
    //   7294: iload 8
    //   7296: iconst_1
    //   7297: iadd
    //   7298: istore 8
    //   7300: goto -37 -> 7263
    //   7303: aload_2
    //   7304: sipush 138
    //   7307: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   7310: checkcast 2849	aeqd
    //   7313: aload 16
    //   7315: invokevirtual 2852	aeqd:a	(Ljava/util/Set;)V
    //   7318: aload_0
    //   7319: invokevirtual 47	amnh:getAppRuntime	()Lmqq/app/AppRuntime;
    //   7322: invokevirtual 2590	mqq/app/AppRuntime:getApplication	()Lmqq/app/MobileQQ;
    //   7325: aload_0
    //   7326: invokevirtual 47	amnh:getAppRuntime	()Lmqq/app/AppRuntime;
    //   7329: invokevirtual 2780	mqq/app/AppRuntime:getAccount	()Ljava/lang/String;
    //   7332: iload 7
    //   7334: invokestatic 2853	baig:b	(Landroid/content/Context;Ljava/lang/String;I)V
    //   7337: goto +5117 -> 12454
    //   7340: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7343: ifeq +41 -> 7384
    //   7346: ldc 183
    //   7348: iconst_2
    //   7349: new 85	java/lang/StringBuilder
    //   7352: dup
    //   7353: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   7356: ldc_w 2855
    //   7359: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7362: iload 7
    //   7364: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7367: ldc_w 2840
    //   7370: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7373: iload 8
    //   7375: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7378: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7381: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   7384: iload 8
    //   7386: iload 7
    //   7388: if_icmpeq +5066 -> 12454
    //   7391: aload_2
    //   7392: sipush 138
    //   7395: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   7398: checkcast 2849	aeqd
    //   7401: invokevirtual 2856	aeqd:a	()V
    //   7404: aload_0
    //   7405: invokevirtual 47	amnh:getAppRuntime	()Lmqq/app/AppRuntime;
    //   7408: invokevirtual 2590	mqq/app/AppRuntime:getApplication	()Lmqq/app/MobileQQ;
    //   7411: aload_0
    //   7412: invokevirtual 47	amnh:getAppRuntime	()Lmqq/app/AppRuntime;
    //   7415: invokevirtual 2780	mqq/app/AppRuntime:getAccount	()Ljava/lang/String;
    //   7418: iload 7
    //   7420: invokestatic 2853	baig:b	(Landroid/content/Context;Ljava/lang/String;I)V
    //   7423: goto +5031 -> 12454
    //   7426: aload 19
    //   7428: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   7431: ifnull +4918 -> 12349
    //   7434: aload 19
    //   7436: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   7439: invokevirtual 113	com/tencent/mobileqq/pb/PBRepeatField:size	()I
    //   7442: ifle +4907 -> 12349
    //   7445: aload 19
    //   7447: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   7450: invokevirtual 1143	com/tencent/mobileqq/pb/PBRepeatField:get	()Ljava/util/List;
    //   7453: astore 16
    //   7455: aload 16
    //   7457: ifnull +195 -> 7652
    //   7460: aload 16
    //   7462: invokeinterface 400 1 0
    //   7467: ifle +185 -> 7652
    //   7470: aload 16
    //   7472: iconst_0
    //   7473: invokeinterface 447 2 0
    //   7478: checkcast 118	java/lang/String
    //   7481: astore 17
    //   7483: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7486: ifeq +47 -> 7533
    //   7489: ldc 183
    //   7491: iconst_2
    //   7492: new 85	java/lang/StringBuilder
    //   7495: dup
    //   7496: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   7499: ldc_w 2858
    //   7502: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7505: aload 17
    //   7507: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7510: ldc_w 604
    //   7513: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7516: aload 19
    //   7518: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   7521: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   7524: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7527: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7530: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   7533: aload 17
    //   7535: invokestatic 2861	mnz:a	(Ljava/lang/String;)V
    //   7538: aload 16
    //   7540: invokeinterface 233 1 0
    //   7545: astore 16
    //   7547: aload 16
    //   7549: invokeinterface 238 1 0
    //   7554: ifeq +73 -> 7627
    //   7557: aload 16
    //   7559: invokeinterface 242 1 0
    //   7564: checkcast 118	java/lang/String
    //   7567: astore 17
    //   7569: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7572: ifeq +47 -> 7619
    //   7575: ldc 183
    //   7577: iconst_2
    //   7578: new 85	java/lang/StringBuilder
    //   7581: dup
    //   7582: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   7585: ldc_w 2858
    //   7588: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7591: aload 17
    //   7593: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7596: ldc_w 604
    //   7599: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7602: aload 19
    //   7604: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   7607: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   7610: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7613: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7616: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   7619: aload 17
    //   7621: invokestatic 2864	aemt:a	(Ljava/lang/String;)Z
    //   7624: ifeq -77 -> 7547
    //   7627: aload 19
    //   7629: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   7632: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   7635: istore 7
    //   7637: aload_0
    //   7638: invokevirtual 47	amnh:getAppRuntime	()Lmqq/app/AppRuntime;
    //   7641: invokevirtual 2590	mqq/app/AppRuntime:getApplication	()Lmqq/app/MobileQQ;
    //   7644: iload 7
    //   7646: invokestatic 2867	baig:b	(Landroid/content/Context;I)V
    //   7649: goto +4722 -> 12371
    //   7652: aconst_null
    //   7653: invokestatic 2861	mnz:a	(Ljava/lang/String;)V
    //   7656: invokestatic 2868	aemt:a	()V
    //   7659: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7662: ifeq -35 -> 7627
    //   7665: ldc 183
    //   7667: iconst_2
    //   7668: new 85	java/lang/StringBuilder
    //   7671: dup
    //   7672: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   7675: ldc_w 2870
    //   7678: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7681: aload 19
    //   7683: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   7686: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   7689: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7692: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7695: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   7698: goto -71 -> 7627
    //   7701: invokestatic 385	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   7704: aload_2
    //   7705: invokevirtual 69	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   7708: invokestatic 1423	cooperation/pluginbridge/BridgeHelper:a	(Landroid/content/Context;Ljava/lang/String;)Lcooperation/pluginbridge/BridgeHelper;
    //   7711: aload 19
    //   7713: invokevirtual 2871	cooperation/pluginbridge/BridgeHelper:a	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   7716: goto +4655 -> 12371
    //   7719: aload_0
    //   7720: aload_3
    //   7721: aload 19
    //   7723: invokespecial 2874	amnh:l	(Landroid/content/Intent;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   7726: goto +4645 -> 12371
    //   7729: aload_0
    //   7730: aload_3
    //   7731: aload 19
    //   7733: invokespecial 2876	amnh:j	(Landroid/content/Intent;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   7736: goto +4635 -> 12371
    //   7739: aload_0
    //   7740: aload_3
    //   7741: aload 19
    //   7743: invokespecial 2878	amnh:k	(Landroid/content/Intent;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   7746: goto +4625 -> 12371
    //   7749: aload_0
    //   7750: aload 19
    //   7752: invokespecial 2880	amnh:j	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   7755: goto +4616 -> 12371
    //   7758: aload_0
    //   7759: aload 19
    //   7761: invokespecial 2882	amnh:i	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   7764: goto +4607 -> 12371
    //   7767: aload 19
    //   7769: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   7772: ifnull +103 -> 7875
    //   7775: aload 19
    //   7777: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   7780: invokevirtual 113	com/tencent/mobileqq/pb/PBRepeatField:size	()I
    //   7783: ifle +92 -> 7875
    //   7786: aload 19
    //   7788: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   7791: iconst_0
    //   7792: invokevirtual 116	com/tencent/mobileqq/pb/PBRepeatField:get	(I)Ljava/lang/Object;
    //   7795: checkcast 118	java/lang/String
    //   7798: astore 16
    //   7800: aload 19
    //   7802: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   7805: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   7808: istore 7
    //   7810: aload_2
    //   7811: invokevirtual 2885	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/av/gaudio/AVNotifyCenter;
    //   7814: aload_2
    //   7815: aload 16
    //   7817: iload 7
    //   7819: invokevirtual 2889	com/tencent/av/gaudio/AVNotifyCenter:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;I)V
    //   7822: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7825: ifeq +4632 -> 12457
    //   7828: ldc 183
    //   7830: iconst_2
    //   7831: new 85	java/lang/StringBuilder
    //   7834: dup
    //   7835: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   7838: ldc_w 2891
    //   7841: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7844: aload 16
    //   7846: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7849: ldc_w 604
    //   7852: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7855: aload 19
    //   7857: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   7860: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   7863: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7866: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7869: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   7872: goto +4585 -> 12457
    //   7875: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7878: ifeq +4493 -> 12371
    //   7881: ldc 183
    //   7883: iconst_2
    //   7884: new 85	java/lang/StringBuilder
    //   7887: dup
    //   7888: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   7891: ldc_w 2893
    //   7894: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7897: aload 19
    //   7899: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   7902: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   7905: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7908: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7911: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   7914: goto +4457 -> 12371
    //   7917: aload_2
    //   7918: sipush 177
    //   7921: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   7924: checkcast 2895	banp
    //   7927: astore 16
    //   7929: aload 19
    //   7931: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   7934: ifnull +98 -> 8032
    //   7937: aload 19
    //   7939: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   7942: invokevirtual 113	com/tencent/mobileqq/pb/PBRepeatField:size	()I
    //   7945: ifle +87 -> 8032
    //   7948: aload 19
    //   7950: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   7953: iconst_0
    //   7954: invokevirtual 116	com/tencent/mobileqq/pb/PBRepeatField:get	(I)Ljava/lang/Object;
    //   7957: checkcast 118	java/lang/String
    //   7960: astore 17
    //   7962: aload 19
    //   7964: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   7967: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   7970: istore 7
    //   7972: aload 16
    //   7974: aload 17
    //   7976: aload_2
    //   7977: invokevirtual 411	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   7980: iload 7
    //   7982: invokevirtual 2898	banp:a	(Ljava/lang/String;Ljava/lang/String;I)V
    //   7985: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7988: ifeq +4472 -> 12460
    //   7991: ldc 183
    //   7993: iconst_2
    //   7994: new 85	java/lang/StringBuilder
    //   7997: dup
    //   7998: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   8001: ldc_w 2900
    //   8004: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8007: aload 17
    //   8009: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8012: ldc_w 604
    //   8015: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8018: iload 7
    //   8020: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   8023: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8026: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   8029: goto +4431 -> 12460
    //   8032: aload 16
    //   8034: aload 19
    //   8036: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   8039: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   8042: aload_2
    //   8043: invokevirtual 411	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   8046: invokevirtual 2903	banp:a	(ILjava/lang/String;)V
    //   8049: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   8052: ifeq +4411 -> 12463
    //   8055: ldc 183
    //   8057: iconst_2
    //   8058: new 85	java/lang/StringBuilder
    //   8061: dup
    //   8062: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   8065: ldc_w 2905
    //   8068: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8071: aload 19
    //   8073: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   8076: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   8079: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   8082: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8085: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   8088: goto +4375 -> 12463
    //   8091: aload_0
    //   8092: aload_3
    //   8093: aload 19
    //   8095: invokespecial 2907	amnh:i	(Landroid/content/Intent;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8098: goto +4273 -> 12371
    //   8101: aload_0
    //   8102: aload_3
    //   8103: aload 19
    //   8105: invokespecial 2909	amnh:e	(Landroid/content/Intent;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8108: goto +4263 -> 12371
    //   8111: aload_0
    //   8112: aload_3
    //   8113: aload 19
    //   8115: invokespecial 2911	amnh:f	(Landroid/content/Intent;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8118: goto +4253 -> 12371
    //   8121: aload_0
    //   8122: aload_3
    //   8123: aload 19
    //   8125: invokespecial 2913	amnh:g	(Landroid/content/Intent;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8128: goto +4243 -> 12371
    //   8131: aload_0
    //   8132: aload_2
    //   8133: aload_3
    //   8134: aload 19
    //   8136: invokespecial 2916	amnh:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Landroid/content/Intent;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8139: goto +4232 -> 12371
    //   8142: aload_0
    //   8143: aload_3
    //   8144: aload 19
    //   8146: invokespecial 2918	amnh:h	(Landroid/content/Intent;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8149: goto +4222 -> 12371
    //   8152: aload_0
    //   8153: aload 19
    //   8155: invokespecial 2920	amnh:g	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8158: goto +4213 -> 12371
    //   8161: aload_0
    //   8162: aload 19
    //   8164: invokespecial 2922	amnh:h	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8167: goto +4204 -> 12371
    //   8170: aload_0
    //   8171: aload_2
    //   8172: aload 19
    //   8174: invokespecial 2924	amnh:ae	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8177: goto +4194 -> 12371
    //   8180: aload_2
    //   8181: invokestatic 1510	com/tencent/mobileqq/utils/BusinessCommonConfig:getInstance	(Lmqq/app/AppRuntime;)Lcom/tencent/mobileqq/utils/BusinessCommonConfig;
    //   8184: aload_2
    //   8185: aload 16
    //   8187: invokevirtual 1823	java/lang/Integer:intValue	()I
    //   8190: aload_3
    //   8191: aload 19
    //   8193: invokevirtual 2928	com/tencent/mobileqq/utils/BusinessCommonConfig:decodeConfig	(Lcom/tencent/mobileqq/app/QQAppInterface;ILandroid/content/Intent;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)Ljava/lang/Boolean;
    //   8196: pop
    //   8197: goto +4174 -> 12371
    //   8200: aload 19
    //   8202: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   8205: ifnull +164 -> 8369
    //   8208: aload 19
    //   8210: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   8213: invokevirtual 113	com/tencent/mobileqq/pb/PBRepeatField:size	()I
    //   8216: ifle +153 -> 8369
    //   8219: aload 19
    //   8221: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   8224: invokevirtual 1143	com/tencent/mobileqq/pb/PBRepeatField:get	()Ljava/util/List;
    //   8227: invokeinterface 233 1 0
    //   8232: astore 16
    //   8234: aload 16
    //   8236: invokeinterface 238 1 0
    //   8241: ifeq +167 -> 8408
    //   8244: aload 16
    //   8246: invokeinterface 242 1 0
    //   8251: checkcast 118	java/lang/String
    //   8254: astore 17
    //   8256: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   8259: ifeq +47 -> 8306
    //   8262: ldc 183
    //   8264: iconst_2
    //   8265: new 85	java/lang/StringBuilder
    //   8268: dup
    //   8269: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   8272: ldc_w 2930
    //   8275: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8278: aload 17
    //   8280: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8283: ldc_w 604
    //   8286: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8289: aload 19
    //   8291: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   8294: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   8297: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   8300: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8303: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   8306: aload_0
    //   8307: aload 17
    //   8309: aload 19
    //   8311: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   8314: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   8317: invokespecial 2932	amnh:a	(Ljava/lang/String;I)V
    //   8320: goto -86 -> 8234
    //   8323: astore 16
    //   8325: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   8328: ifeq +33 -> 8361
    //   8331: ldc 183
    //   8333: iconst_2
    //   8334: new 85	java/lang/StringBuilder
    //   8337: dup
    //   8338: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   8341: ldc_w 2934
    //   8344: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8347: aload 16
    //   8349: invokevirtual 640	java/lang/Exception:toString	()Ljava/lang/String;
    //   8352: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8355: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8358: invokestatic 642	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   8361: aload 16
    //   8363: invokevirtual 458	java/lang/Exception:printStackTrace	()V
    //   8366: goto +4005 -> 12371
    //   8369: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   8372: ifeq +36 -> 8408
    //   8375: ldc 183
    //   8377: iconst_2
    //   8378: new 85	java/lang/StringBuilder
    //   8381: dup
    //   8382: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   8385: ldc_w 2936
    //   8388: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8391: aload 19
    //   8393: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   8396: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   8399: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   8402: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8405: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   8408: goto +3963 -> 12371
    //   8411: aload 19
    //   8413: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   8416: ifnull +164 -> 8580
    //   8419: aload 19
    //   8421: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   8424: invokevirtual 113	com/tencent/mobileqq/pb/PBRepeatField:size	()I
    //   8427: ifle +153 -> 8580
    //   8430: aload 19
    //   8432: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   8435: invokevirtual 1143	com/tencent/mobileqq/pb/PBRepeatField:get	()Ljava/util/List;
    //   8438: invokeinterface 233 1 0
    //   8443: astore 16
    //   8445: aload 16
    //   8447: invokeinterface 238 1 0
    //   8452: ifeq +167 -> 8619
    //   8455: aload 16
    //   8457: invokeinterface 242 1 0
    //   8462: checkcast 118	java/lang/String
    //   8465: astore 17
    //   8467: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   8470: ifeq +47 -> 8517
    //   8473: ldc 183
    //   8475: iconst_2
    //   8476: new 85	java/lang/StringBuilder
    //   8479: dup
    //   8480: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   8483: ldc_w 2938
    //   8486: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8489: aload 17
    //   8491: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8494: ldc_w 604
    //   8497: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8500: aload 19
    //   8502: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   8505: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   8508: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   8511: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8514: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   8517: aload_0
    //   8518: aload 17
    //   8520: aload 19
    //   8522: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   8525: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   8528: invokespecial 2940	amnh:b	(Ljava/lang/String;I)V
    //   8531: goto -86 -> 8445
    //   8534: astore 16
    //   8536: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   8539: ifeq +33 -> 8572
    //   8542: ldc 183
    //   8544: iconst_2
    //   8545: new 85	java/lang/StringBuilder
    //   8548: dup
    //   8549: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   8552: ldc_w 2942
    //   8555: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8558: aload 16
    //   8560: invokevirtual 640	java/lang/Exception:toString	()Ljava/lang/String;
    //   8563: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8566: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8569: invokestatic 642	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   8572: aload 16
    //   8574: invokevirtual 458	java/lang/Exception:printStackTrace	()V
    //   8577: goto +3794 -> 12371
    //   8580: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   8583: ifeq +36 -> 8619
    //   8586: ldc 183
    //   8588: iconst_2
    //   8589: new 85	java/lang/StringBuilder
    //   8592: dup
    //   8593: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   8596: ldc_w 2944
    //   8599: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8602: aload 19
    //   8604: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   8607: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   8610: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   8613: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8616: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   8619: goto +3752 -> 12371
    //   8622: aload_0
    //   8623: aload 19
    //   8625: invokespecial 2946	amnh:p	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8628: goto +3743 -> 12371
    //   8631: aload_0
    //   8632: aload 19
    //   8634: invokespecial 2948	amnh:m	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8637: goto +3734 -> 12371
    //   8640: aload_0
    //   8641: aload 19
    //   8643: invokespecial 2950	amnh:n	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8646: goto +3725 -> 12371
    //   8649: aload_0
    //   8650: aload 19
    //   8652: invokespecial 2952	amnh:o	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8655: goto +3716 -> 12371
    //   8658: aload_0
    //   8659: aload 19
    //   8661: invokespecial 2954	amnh:t	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8664: goto +3707 -> 12371
    //   8667: aload_0
    //   8668: aload 19
    //   8670: invokespecial 2956	amnh:r	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8673: goto +3698 -> 12371
    //   8676: aload_0
    //   8677: aload 19
    //   8679: invokespecial 2958	amnh:d	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8682: goto +3689 -> 12371
    //   8685: aload_0
    //   8686: aload 19
    //   8688: invokespecial 2960	amnh:q	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8691: goto +3680 -> 12371
    //   8694: aload_0
    //   8695: aload 19
    //   8697: invokespecial 2962	amnh:s	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8700: goto +3671 -> 12371
    //   8703: aload_0
    //   8704: aload 19
    //   8706: invokespecial 2964	amnh:k	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8709: goto +3662 -> 12371
    //   8712: aload_0
    //   8713: aload 19
    //   8715: invokevirtual 2966	amnh:b	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8718: goto +3653 -> 12371
    //   8721: aload_0
    //   8722: aload 19
    //   8724: invokevirtual 2968	amnh:c	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8727: goto +3644 -> 12371
    //   8730: aload_0
    //   8731: aload 19
    //   8733: invokespecial 2970	amnh:v	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8736: goto +3635 -> 12371
    //   8739: aload_0
    //   8740: aload 19
    //   8742: invokespecial 2972	amnh:w	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8745: goto +3626 -> 12371
    //   8748: aload_0
    //   8749: aload 19
    //   8751: invokespecial 2974	amnh:z	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8754: goto +3617 -> 12371
    //   8757: aload_0
    //   8758: aload 19
    //   8760: invokespecial 2976	amnh:B	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8763: goto +3608 -> 12371
    //   8766: aload_0
    //   8767: aload 19
    //   8769: invokespecial 2978	amnh:x	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8772: goto +3599 -> 12371
    //   8775: aload_0
    //   8776: aload 19
    //   8778: invokespecial 2980	amnh:y	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8781: goto +3590 -> 12371
    //   8784: aload_0
    //   8785: aload 19
    //   8787: invokespecial 2982	amnh:l	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8790: goto +3581 -> 12371
    //   8793: aload_0
    //   8794: aload 19
    //   8796: invokespecial 2984	amnh:u	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8799: goto +3572 -> 12371
    //   8802: invokestatic 2987	com/tencent/mobileqq/app/DeviceProfileManager:a	()Lcom/tencent/mobileqq/app/DeviceProfileManager;
    //   8805: aload_1
    //   8806: ldc 13
    //   8808: invokevirtual 2990	com/tencent/mobileqq/app/DeviceProfileManager:a	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig;Ljava/lang/String;)Z
    //   8811: pop
    //   8812: goto +3559 -> 12371
    //   8815: aload_0
    //   8816: aload 19
    //   8818: invokespecial 2992	amnh:e	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8821: goto +3550 -> 12371
    //   8824: aload_0
    //   8825: aload 19
    //   8827: invokespecial 2994	amnh:f	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8830: goto +3541 -> 12371
    //   8833: aload_0
    //   8834: aload 19
    //   8836: invokevirtual 2995	amnh:a	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8839: goto +3532 -> 12371
    //   8842: aload_0
    //   8843: aload 19
    //   8845: invokespecial 2997	amnh:A	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8848: goto +3523 -> 12371
    //   8851: aload 19
    //   8853: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   8856: ifnull +141 -> 8997
    //   8859: aload 19
    //   8861: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   8864: invokevirtual 113	com/tencent/mobileqq/pb/PBRepeatField:size	()I
    //   8867: ifle +130 -> 8997
    //   8870: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   8873: ifeq +68 -> 8941
    //   8876: ldc 183
    //   8878: iconst_2
    //   8879: new 85	java/lang/StringBuilder
    //   8882: dup
    //   8883: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   8886: ldc_w 2999
    //   8889: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8892: aload 16
    //   8894: invokevirtual 798	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   8897: ldc_w 2844
    //   8900: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8903: aload 19
    //   8905: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   8908: iconst_0
    //   8909: invokevirtual 116	com/tencent/mobileqq/pb/PBRepeatField:get	(I)Ljava/lang/Object;
    //   8912: checkcast 118	java/lang/String
    //   8915: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8918: ldc_w 604
    //   8921: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8924: aload 19
    //   8926: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   8929: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   8932: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   8935: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8938: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   8941: aload_2
    //   8942: sipush 169
    //   8945: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   8948: checkcast 3001	cooperation/photoplus/PhotoPlusManager
    //   8951: aload 19
    //   8953: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   8956: iconst_0
    //   8957: invokevirtual 116	com/tencent/mobileqq/pb/PBRepeatField:get	(I)Ljava/lang/Object;
    //   8960: checkcast 118	java/lang/String
    //   8963: invokevirtual 3002	cooperation/photoplus/PhotoPlusManager:a	(Ljava/lang/String;)Z
    //   8966: ifeq +3405 -> 12371
    //   8969: aload_0
    //   8970: invokevirtual 47	amnh:getAppRuntime	()Lmqq/app/AppRuntime;
    //   8973: invokevirtual 2590	mqq/app/AppRuntime:getApplication	()Lmqq/app/MobileQQ;
    //   8976: aload_0
    //   8977: invokevirtual 47	amnh:getAppRuntime	()Lmqq/app/AppRuntime;
    //   8980: invokevirtual 2780	mqq/app/AppRuntime:getAccount	()Ljava/lang/String;
    //   8983: aload 19
    //   8985: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   8988: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   8991: invokestatic 3004	baig:r	(Landroid/content/Context;Ljava/lang/String;I)V
    //   8994: goto +3377 -> 12371
    //   8997: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   9000: ifeq +3371 -> 12371
    //   9003: ldc 183
    //   9005: iconst_2
    //   9006: new 85	java/lang/StringBuilder
    //   9009: dup
    //   9010: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   9013: ldc_w 2999
    //   9016: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9019: aload 16
    //   9021: invokevirtual 798	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   9024: ldc_w 3006
    //   9027: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9030: aload 19
    //   9032: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   9035: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   9038: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   9041: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   9044: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   9047: goto +3324 -> 12371
    //   9050: aload_0
    //   9051: aload_2
    //   9052: aload 19
    //   9054: invokevirtual 3008	amnh:e	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9057: goto +3314 -> 12371
    //   9060: aload_0
    //   9061: aload_3
    //   9062: iload 5
    //   9064: aload 19
    //   9066: aload_1
    //   9067: getfield 2384	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:result	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   9070: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   9073: invokevirtual 3011	amnh:a	(Landroid/content/Intent;ZLcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;I)V
    //   9076: goto +3295 -> 12371
    //   9079: aload_0
    //   9080: aload_3
    //   9081: aload 19
    //   9083: invokespecial 3013	amnh:c	(Landroid/content/Intent;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9086: goto +3285 -> 12371
    //   9089: aload_0
    //   9090: aload_3
    //   9091: aload 19
    //   9093: invokespecial 3015	amnh:b	(Landroid/content/Intent;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9096: goto +3275 -> 12371
    //   9099: aload_0
    //   9100: aload_3
    //   9101: aload 19
    //   9103: invokespecial 3017	amnh:d	(Landroid/content/Intent;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9106: goto +3265 -> 12371
    //   9109: aload_0
    //   9110: aload_3
    //   9111: aload 19
    //   9113: invokevirtual 3019	amnh:a	(Landroid/content/Intent;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9116: goto +3255 -> 12371
    //   9119: aload_0
    //   9120: aload_2
    //   9121: aload_3
    //   9122: aload 19
    //   9124: invokevirtual 3021	amnh:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Landroid/content/Intent;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9127: goto +3244 -> 12371
    //   9130: aload_0
    //   9131: aload_2
    //   9132: aload 19
    //   9134: invokespecial 3023	amnh:U	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9137: goto +3234 -> 12371
    //   9140: aload_0
    //   9141: aload_2
    //   9142: aload 19
    //   9144: invokespecial 3025	amnh:af	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9147: goto +3224 -> 12371
    //   9150: aload 16
    //   9152: invokevirtual 1823	java/lang/Integer:intValue	()I
    //   9155: aload_2
    //   9156: invokevirtual 1585	com/tencent/mobileqq/app/QQAppInterface:c	()Ljava/lang/String;
    //   9159: aload 19
    //   9161: invokestatic 3028	ksm:a	(ILjava/lang/String;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9164: goto +3207 -> 12371
    //   9167: aload_0
    //   9168: aload_2
    //   9169: aload 19
    //   9171: invokevirtual 3030	amnh:d	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9174: goto +3197 -> 12371
    //   9177: aload_0
    //   9178: aload_3
    //   9179: iload 5
    //   9181: aload 19
    //   9183: aload_1
    //   9184: getfield 2384	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:result	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   9187: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   9190: invokevirtual 3032	amnh:b	(Landroid/content/Intent;ZLcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;I)V
    //   9193: goto +3178 -> 12371
    //   9196: aload_0
    //   9197: aload_2
    //   9198: aload 19
    //   9200: invokespecial 3034	amnh:Z	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9203: goto +3168 -> 12371
    //   9206: aload_0
    //   9207: aload_2
    //   9208: aload 19
    //   9210: invokespecial 3036	amnh:V	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9213: goto +3158 -> 12371
    //   9216: aload_0
    //   9217: aload_2
    //   9218: aload 19
    //   9220: invokespecial 3038	amnh:W	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9223: goto +3148 -> 12371
    //   9226: aload_0
    //   9227: aload_2
    //   9228: aload 19
    //   9230: invokespecial 3040	amnh:X	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9233: goto +3138 -> 12371
    //   9236: aload_0
    //   9237: aload_2
    //   9238: aload 19
    //   9240: invokespecial 3042	amnh:Y	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9243: goto +3128 -> 12371
    //   9246: aload_0
    //   9247: aload_2
    //   9248: aload 19
    //   9250: invokevirtual 3044	amnh:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9253: goto +3118 -> 12371
    //   9256: aload_0
    //   9257: aload_2
    //   9258: aload 19
    //   9260: invokespecial 3046	amnh:ag	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9263: goto +3108 -> 12371
    //   9266: aload_0
    //   9267: aload_2
    //   9268: aload 19
    //   9270: invokespecial 3048	amnh:ah	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9273: goto +3098 -> 12371
    //   9276: aload_0
    //   9277: aload_2
    //   9278: aload 19
    //   9280: invokespecial 3050	amnh:ai	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9283: goto +3088 -> 12371
    //   9286: aload_0
    //   9287: aload_2
    //   9288: aload 19
    //   9290: invokespecial 3052	amnh:aj	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9293: goto +3078 -> 12371
    //   9296: aload 19
    //   9298: invokestatic 3053	avwc:a	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9301: goto +3070 -> 12371
    //   9304: aload_0
    //   9305: aload_2
    //   9306: aload 19
    //   9308: invokespecial 3055	amnh:ak	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9311: goto +3060 -> 12371
    //   9314: aload_0
    //   9315: aload_2
    //   9316: aload 19
    //   9318: invokespecial 3058	amnh:al	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9321: goto +3050 -> 12371
    //   9324: aload_0
    //   9325: aload_2
    //   9326: aload 19
    //   9328: invokespecial 3060	amnh:am	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9331: goto +3040 -> 12371
    //   9334: aload_0
    //   9335: aload_2
    //   9336: aload 19
    //   9338: invokespecial 3063	amnh:an	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9341: goto +3030 -> 12371
    //   9344: aload_0
    //   9345: aload_2
    //   9346: aload 19
    //   9348: invokevirtual 3065	amnh:f	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9351: goto +3020 -> 12371
    //   9354: aload_0
    //   9355: aload_3
    //   9356: aload 19
    //   9358: invokespecial 3067	amnh:m	(Landroid/content/Intent;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9361: goto +3010 -> 12371
    //   9364: aload_0
    //   9365: aload_2
    //   9366: aload 19
    //   9368: invokespecial 3070	amnh:ao	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9371: goto +3000 -> 12371
    //   9374: aload_0
    //   9375: aload_2
    //   9376: aload 19
    //   9378: invokevirtual 3072	amnh:l	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9381: goto +2990 -> 12371
    //   9384: aload_0
    //   9385: aload_2
    //   9386: aload 19
    //   9388: invokevirtual 3074	amnh:i	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9391: goto +2980 -> 12371
    //   9394: aload_2
    //   9395: sipush 208
    //   9398: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   9401: checkcast 1847	vju
    //   9404: getfield 1850	vju:a	Lvjt;
    //   9407: aload_2
    //   9408: aload 19
    //   9410: invokevirtual 3077	vjt:a	(Lcom/tencent/common/app/AppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9413: goto +2958 -> 12371
    //   9416: aload_0
    //   9417: aload_2
    //   9418: aload 19
    //   9420: invokevirtual 3079	amnh:h	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9423: goto +2948 -> 12371
    //   9426: aload_0
    //   9427: aload_2
    //   9428: aload 19
    //   9430: invokevirtual 3081	amnh:j	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9433: goto +2938 -> 12371
    //   9436: aload_0
    //   9437: aload_2
    //   9438: aload 19
    //   9440: invokevirtual 3083	amnh:m	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9443: goto +2928 -> 12371
    //   9446: aload_0
    //   9447: aload_2
    //   9448: aload 19
    //   9450: invokevirtual 3085	amnh:n	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9453: goto +2918 -> 12371
    //   9456: aload_0
    //   9457: aload_2
    //   9458: aload 19
    //   9460: invokevirtual 3087	amnh:o	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9463: goto +2908 -> 12371
    //   9466: aload_0
    //   9467: aload_2
    //   9468: aload 19
    //   9470: invokevirtual 3089	amnh:q	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9473: goto +2898 -> 12371
    //   9476: aload_2
    //   9477: aload 19
    //   9479: invokestatic 3090	wmp:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9482: goto +2889 -> 12371
    //   9485: aload_0
    //   9486: aload_2
    //   9487: aload 19
    //   9489: invokespecial 3092	amnh:ap	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9492: goto +2879 -> 12371
    //   9495: aload_0
    //   9496: aload_2
    //   9497: aload 19
    //   9499: invokevirtual 3094	amnh:p	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9502: goto +2869 -> 12371
    //   9505: aload_0
    //   9506: aload_2
    //   9507: aload 19
    //   9509: invokevirtual 3096	amnh:r	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9512: goto +2859 -> 12371
    //   9515: aload_0
    //   9516: aload_2
    //   9517: aload 19
    //   9519: invokevirtual 3098	amnh:g	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9522: goto +2849 -> 12371
    //   9525: aload_0
    //   9526: aload_2
    //   9527: aload 19
    //   9529: invokevirtual 3100	amnh:s	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9532: goto +2839 -> 12371
    //   9535: aload_0
    //   9536: aload_2
    //   9537: aload 19
    //   9539: invokespecial 3102	amnh:aa	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9542: goto +2829 -> 12371
    //   9545: aload_0
    //   9546: aload_2
    //   9547: aload 19
    //   9549: invokespecial 3104	amnh:ab	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9552: goto +2819 -> 12371
    //   9555: aload_0
    //   9556: aload_2
    //   9557: aload 19
    //   9559: invokevirtual 3106	amnh:k	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9562: goto +2809 -> 12371
    //   9565: aload_0
    //   9566: aload_2
    //   9567: aload 19
    //   9569: invokevirtual 3108	amnh:u	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9572: goto +2799 -> 12371
    //   9575: aload_2
    //   9576: aload 19
    //   9578: invokestatic 3110	amnh:t	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9581: goto +2790 -> 12371
    //   9584: aload 19
    //   9586: aload_2
    //   9587: invokevirtual 1341	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   9590: invokestatic 1949	ahkg:a	(Landroid/content/Context;)I
    //   9593: sipush 199
    //   9596: invokestatic 2272	amnh:b	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;II)Ljava/lang/String;
    //   9599: astore 16
    //   9601: aload 16
    //   9603: ifnull +2768 -> 12371
    //   9606: aload_2
    //   9607: invokevirtual 1341	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   9610: aload 16
    //   9612: aload 19
    //   9614: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   9617: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   9620: invokestatic 3111	ahkg:a	(Landroid/content/Context;Ljava/lang/String;I)V
    //   9623: goto +2748 -> 12371
    //   9626: aload 19
    //   9628: aload_2
    //   9629: invokevirtual 1341	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   9632: invokestatic 1952	ausu:a	(Landroid/content/Context;)I
    //   9635: sipush 225
    //   9638: invokestatic 2272	amnh:b	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;II)Ljava/lang/String;
    //   9641: astore 16
    //   9643: aload 16
    //   9645: ifnull +2726 -> 12371
    //   9648: invokestatic 3114	ausu:a	()Lausu;
    //   9651: aload_2
    //   9652: invokevirtual 1341	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   9655: aload 16
    //   9657: aload 19
    //   9659: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   9662: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   9665: invokevirtual 3115	ausu:a	(Landroid/content/Context;Ljava/lang/String;I)V
    //   9668: goto +2703 -> 12371
    //   9671: aload_0
    //   9672: aload_2
    //   9673: aload 19
    //   9675: invokevirtual 3117	amnh:v	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9678: goto +2693 -> 12371
    //   9681: aload_0
    //   9682: aload_2
    //   9683: aload 19
    //   9685: invokevirtual 3119	amnh:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9688: goto +2683 -> 12371
    //   9691: aload_0
    //   9692: aload_2
    //   9693: aload 19
    //   9695: invokespecial 3121	amnh:aq	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9698: goto +2673 -> 12371
    //   9701: aload_2
    //   9702: aload 19
    //   9704: invokestatic 3123	amnh:w	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9707: goto +2664 -> 12371
    //   9710: aload_2
    //   9711: aload 19
    //   9713: invokestatic 3125	amnh:O	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9716: goto +2655 -> 12371
    //   9719: aload_2
    //   9720: aload 19
    //   9722: invokestatic 3127	amnh:P	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9725: goto +2646 -> 12371
    //   9728: aload_0
    //   9729: aload_2
    //   9730: aload 19
    //   9732: invokespecial 3129	amnh:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)I
    //   9735: invokestatic 3130	com/tencent/mobileqq/shortvideo/ShortVideoResourceManager:b	(I)V
    //   9738: goto +2633 -> 12371
    //   9741: aload_2
    //   9742: sipush 238
    //   9745: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   9748: checkcast 3132	myh
    //   9751: astore 16
    //   9753: aload 16
    //   9755: ifnull +2616 -> 12371
    //   9758: aload 16
    //   9760: aload_2
    //   9761: aload 19
    //   9763: invokevirtual 3133	myh:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9766: goto +2605 -> 12371
    //   9769: aload_0
    //   9770: aload_2
    //   9771: aload 19
    //   9773: invokevirtual 3135	amnh:y	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9776: goto +2595 -> 12371
    //   9779: aload_0
    //   9780: aload_2
    //   9781: aload 19
    //   9783: invokespecial 3137	amnh:T	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9786: goto +2585 -> 12371
    //   9789: aload_2
    //   9790: sipush 231
    //   9793: getstatic 15	amnh:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   9796: aload 19
    //   9798: invokestatic 3140	ahml:a	(Lcom/tencent/mobileqq/app/QQAppInterface;ILjava/lang/String;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9801: goto +2570 -> 12371
    //   9804: aload_0
    //   9805: aload_2
    //   9806: aload 19
    //   9808: invokevirtual 3142	amnh:x	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9811: goto +2560 -> 12371
    //   9814: aload_0
    //   9815: aload_2
    //   9816: aload 19
    //   9818: invokevirtual 3144	amnh:F	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9821: goto +2550 -> 12371
    //   9824: aload_0
    //   9825: aload_2
    //   9826: aload 19
    //   9828: invokevirtual 3146	amnh:z	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9831: goto +2540 -> 12371
    //   9834: aload_0
    //   9835: aload_2
    //   9836: aload 19
    //   9838: invokevirtual 3148	amnh:A	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9841: goto +2530 -> 12371
    //   9844: aload_0
    //   9845: aload_2
    //   9846: aload 19
    //   9848: invokevirtual 3150	amnh:B	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9851: goto +2520 -> 12371
    //   9854: aload 19
    //   9856: ifnull +2613 -> 12469
    //   9859: aload 19
    //   9861: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   9864: ifnonnull +4 -> 9868
    //   9867: return
    //   9868: aload 19
    //   9870: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   9873: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   9876: aload_2
    //   9877: invokevirtual 65	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   9880: invokestatic 2005	baig:d	(Landroid/content/Context;)I
    //   9883: if_icmpeq +2586 -> 12469
    //   9886: aconst_null
    //   9887: astore 17
    //   9889: aload 17
    //   9891: astore 16
    //   9893: aload 19
    //   9895: getfield 221	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   9898: ifnull +79 -> 9977
    //   9901: aload 17
    //   9903: astore 16
    //   9905: aload 19
    //   9907: getfield 221	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   9910: invokevirtual 224	com/tencent/mobileqq/pb/PBRepeatMessageField:size	()I
    //   9913: ifle +64 -> 9977
    //   9916: aload 19
    //   9918: getfield 221	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   9921: iconst_0
    //   9922: invokevirtual 318	com/tencent/mobileqq/pb/PBRepeatMessageField:get	(I)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   9925: checkcast 244	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content
    //   9928: astore 16
    //   9930: aload 16
    //   9932: getfield 248	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content:compress	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   9935: invokevirtual 251	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   9938: iconst_1
    //   9939: if_icmpne +114 -> 10053
    //   9942: aload 16
    //   9944: getfield 255	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content:content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   9947: invokevirtual 260	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   9950: invokevirtual 266	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   9953: invokestatic 321	atiu:a	([B)[B
    //   9956: astore 17
    //   9958: aload 17
    //   9960: ifnull +2383 -> 12343
    //   9963: new 118	java/lang/String
    //   9966: dup
    //   9967: aload 17
    //   9969: ldc_w 323
    //   9972: invokespecial 326	java/lang/String:<init>	([BLjava/lang/String;)V
    //   9975: astore 16
    //   9977: aload 16
    //   9979: ifnull +33 -> 10012
    //   9982: new 128	org/json/JSONObject
    //   9985: dup
    //   9986: aload 16
    //   9988: invokespecial 131	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   9991: invokestatic 3153	zpy:a	(Lorg/json/JSONObject;)V
    //   9994: aload_0
    //   9995: invokevirtual 47	amnh:getAppRuntime	()Lmqq/app/AppRuntime;
    //   9998: invokevirtual 2590	mqq/app/AppRuntime:getApplication	()Lmqq/app/MobileQQ;
    //   10001: aload 19
    //   10003: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   10006: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   10009: invokestatic 3155	baig:c	(Landroid/content/Context;I)V
    //   10012: goto +2359 -> 12371
    //   10015: astore 16
    //   10017: aconst_null
    //   10018: astore 16
    //   10020: goto -43 -> 9977
    //   10023: astore 16
    //   10025: invokestatic 2608	java/lang/System:gc	()V
    //   10028: new 118	java/lang/String
    //   10031: dup
    //   10032: aload 17
    //   10034: ldc_w 323
    //   10037: invokespecial 326	java/lang/String:<init>	([BLjava/lang/String;)V
    //   10040: astore 16
    //   10042: goto -65 -> 9977
    //   10045: astore 16
    //   10047: aconst_null
    //   10048: astore 16
    //   10050: goto -73 -> 9977
    //   10053: aload 16
    //   10055: getfield 255	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content:content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   10058: invokevirtual 260	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   10061: invokevirtual 280	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   10064: astore 16
    //   10066: goto -89 -> 9977
    //   10069: astore 16
    //   10071: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   10074: ifeq +2396 -> 12470
    //   10077: ldc 183
    //   10079: iconst_2
    //   10080: aload 16
    //   10082: iconst_0
    //   10083: anewarray 301	java/lang/Object
    //   10086: invokestatic 3157	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   10089: goto +2381 -> 12470
    //   10092: aload_0
    //   10093: aload_2
    //   10094: aload 19
    //   10096: invokevirtual 3159	amnh:C	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   10099: goto +2272 -> 12371
    //   10102: aload_0
    //   10103: aload_2
    //   10104: aload 19
    //   10106: invokevirtual 3161	amnh:D	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   10109: goto +2262 -> 12371
    //   10112: aload_0
    //   10113: aload_2
    //   10114: aload 19
    //   10116: invokevirtual 3163	amnh:E	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   10119: goto +2252 -> 12371
    //   10122: aload_0
    //   10123: aload_2
    //   10124: aload 19
    //   10126: invokespecial 3165	amnh:ac	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   10129: goto +2242 -> 12371
    //   10132: aload_0
    //   10133: aload_2
    //   10134: aload 19
    //   10136: invokespecial 3167	amnh:ad	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   10139: goto +2232 -> 12371
    //   10142: aload_0
    //   10143: aload_2
    //   10144: aload 19
    //   10146: invokespecial 3169	amnh:S	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   10149: goto +2222 -> 12371
    //   10152: aload_0
    //   10153: aload_2
    //   10154: aload 19
    //   10156: invokevirtual 3171	amnh:G	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   10159: goto +2212 -> 12371
    //   10162: aload_2
    //   10163: aload 19
    //   10165: invokestatic 3174	azco:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   10168: goto +2203 -> 12371
    //   10171: aload_2
    //   10172: bipush 52
    //   10174: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   10177: checkcast 2022	com/tencent/mobileqq/app/TroopManager
    //   10180: getfield 2025	com/tencent/mobileqq/app/TroopManager:jdField_a_of_type_Ayvu	Layvu;
    //   10183: aload_2
    //   10184: aload 19
    //   10186: invokevirtual 3175	ayvu:a	(Lcom/tencent/common/app/AppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   10189: goto +2182 -> 12371
    //   10192: aload_2
    //   10193: bipush 52
    //   10195: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   10198: checkcast 2022	com/tencent/mobileqq/app/TroopManager
    //   10201: getfield 2033	com/tencent/mobileqq/app/TroopManager:jdField_a_of_type_Ayxk	Layxk;
    //   10204: aload_2
    //   10205: aload 19
    //   10207: invokevirtual 3176	ayxk:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   10210: goto +2161 -> 12371
    //   10213: aload_2
    //   10214: invokestatic 3181	sfy:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)Lsfy;
    //   10217: aload 19
    //   10219: invokevirtual 3182	sfy:a	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   10222: goto +2149 -> 12371
    //   10225: aload_2
    //   10226: sipush 197
    //   10229: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   10232: checkcast 3184	sgj
    //   10235: aload 19
    //   10237: invokevirtual 3185	sgj:a	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   10240: goto +2131 -> 12371
    //   10243: invokestatic 2044	aqcb:a	()Laqcb;
    //   10246: getfield 2047	aqcb:a	Laqcd;
    //   10249: aload 19
    //   10251: invokevirtual 3186	aqcd:a	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   10254: goto +2117 -> 12371
    //   10257: astore 16
    //   10259: aload 16
    //   10261: invokevirtual 1827	java/lang/Throwable:printStackTrace	()V
    //   10264: goto +2107 -> 12371
    //   10267: aload_2
    //   10268: aload 19
    //   10270: invokestatic 3187	com/tencent/mobileqq/shortvideo/util/RecentDanceConfigMgr:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)I
    //   10273: pop
    //   10274: goto +2097 -> 12371
    //   10277: aload_2
    //   10278: aload 19
    //   10280: invokestatic 3188	dov/com/qq/im/ptv/LightVideoConfigMgr:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)I
    //   10283: pop
    //   10284: goto +2087 -> 12371
    //   10287: aload_0
    //   10288: aload_2
    //   10289: aload 19
    //   10291: invokevirtual 3190	amnh:H	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   10294: goto +2077 -> 12371
    //   10297: aload_0
    //   10298: aload_2
    //   10299: aload 19
    //   10301: invokevirtual 3192	amnh:I	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   10304: goto +2067 -> 12371
    //   10307: aload_0
    //   10308: aload_2
    //   10309: aload 19
    //   10311: invokevirtual 3194	amnh:J	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   10314: goto +2057 -> 12371
    //   10317: aload_2
    //   10318: aload 19
    //   10320: aload 16
    //   10322: invokevirtual 1823	java/lang/Integer:intValue	()I
    //   10325: getstatic 15	amnh:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   10328: invokestatic 3199	awqu:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;ILjava/lang/String;)V
    //   10331: goto +2040 -> 12371
    //   10334: aload_0
    //   10335: aload_2
    //   10336: aload 19
    //   10338: invokevirtual 3202	amnh:M	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   10341: goto +2030 -> 12371
    //   10344: aload_2
    //   10345: aload 16
    //   10347: invokevirtual 1823	java/lang/Integer:intValue	()I
    //   10350: aload 19
    //   10352: invokestatic 3207	amts:a	(Lcom/tencent/mobileqq/app/QQAppInterface;ILcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   10355: goto +2016 -> 12371
    //   10358: aload_2
    //   10359: invokestatic 3212	apha:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)Lapha;
    //   10362: aload_2
    //   10363: aload 16
    //   10365: aload 19
    //   10367: invokevirtual 3215	apha:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/Integer;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   10370: goto +2001 -> 12371
    //   10373: aload_0
    //   10374: aload_2
    //   10375: aload 19
    //   10377: invokevirtual 3217	amnh:K	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   10380: goto +1991 -> 12371
    //   10383: aload_0
    //   10384: aload_2
    //   10385: aload 19
    //   10387: invokevirtual 3219	amnh:L	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   10390: goto +1981 -> 12371
    //   10393: aload_2
    //   10394: sipush 181
    //   10397: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   10400: checkcast 2088	sga
    //   10403: getfield 2091	sga:a	Lsor;
    //   10406: aload_2
    //   10407: aload 19
    //   10409: invokevirtual 3220	sor:a	(Lcom/tencent/common/app/AppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   10412: goto +1959 -> 12371
    //   10415: aload_0
    //   10416: aload_2
    //   10417: aload 19
    //   10419: invokespecial 3222	amnh:R	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   10422: goto +1949 -> 12371
    //   10425: aload_2
    //   10426: aload 19
    //   10428: invokestatic 3224	amnh:c	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   10431: goto +1940 -> 12371
    //   10434: aload_2
    //   10435: aload 16
    //   10437: invokevirtual 1823	java/lang/Integer:intValue	()I
    //   10440: aload 19
    //   10442: invokestatic 3227	bbrm:a	(Lcom/tencent/mobileqq/app/QQAppInterface;ILcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   10445: goto +1926 -> 12371
    //   10448: aload_2
    //   10449: bipush 52
    //   10451: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   10454: checkcast 2022	com/tencent/mobileqq/app/TroopManager
    //   10457: getfield 2107	com/tencent/mobileqq/app/TroopManager:jdField_a_of_type_Wml	Lwml;
    //   10460: aload_2
    //   10461: aload 19
    //   10463: invokevirtual 3228	wml:a	(Lcom/tencent/common/app/AppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   10466: goto +1905 -> 12371
    //   10469: aload_0
    //   10470: aload_2
    //   10471: aload 19
    //   10473: aload 16
    //   10475: invokevirtual 1823	java/lang/Integer:intValue	()I
    //   10478: invokespecial 3229	amnh:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;I)V
    //   10481: goto +1890 -> 12371
    //   10484: aload 19
    //   10486: invokestatic 3230	yjx:a	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   10489: goto +1882 -> 12371
    //   10492: aload_2
    //   10493: aload 19
    //   10495: invokestatic 3232	amnh:N	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   10498: goto +1873 -> 12371
    //   10501: aload_0
    //   10502: aload_2
    //   10503: aload 19
    //   10505: invokespecial 3234	amnh:Q	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   10508: goto +1863 -> 12371
    //   10511: aload_2
    //   10512: sipush 306
    //   10515: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   10518: checkcast 3236	aqod
    //   10521: aload 19
    //   10523: invokevirtual 3237	aqod:a	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   10526: goto +1845 -> 12371
    //   10529: aload_0
    //   10530: aload 19
    //   10532: invokespecial 3239	amnh:C	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   10535: goto +1836 -> 12371
    //   10538: aload_2
    //   10539: sipush 236
    //   10542: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   10545: checkcast 3241	aqkz
    //   10548: aload 19
    //   10550: invokevirtual 3242	aqkz:a	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   10553: goto +1818 -> 12371
    //   10556: aload_0
    //   10557: aload_2
    //   10558: aload 19
    //   10560: invokespecial 3245	amnh:ar	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   10563: goto +1808 -> 12371
    //   10566: aload_0
    //   10567: aload_2
    //   10568: aload 19
    //   10570: aload 16
    //   10572: invokevirtual 1823	java/lang/Integer:intValue	()I
    //   10575: invokespecial 3247	amnh:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;I)V
    //   10578: goto +1793 -> 12371
    //   10581: aload 4
    //   10583: ifnull +309 -> 10892
    //   10586: iload 10
    //   10588: ifne +32 -> 10620
    //   10591: aload_2
    //   10592: invokevirtual 65	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   10595: ldc_w 2594
    //   10598: invokestatic 2597	bady:a	(Landroid/content/Context;Ljava/lang/String;)Z
    //   10601: ifne +19 -> 10620
    //   10604: aload_2
    //   10605: sipush 256
    //   10608: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   10611: checkcast 3249	com/tencent/mobileqq/app/upgrade/UpgradeTIMManager
    //   10614: aload_2
    //   10615: aload 4
    //   10617: invokevirtual 3250	com/tencent/mobileqq/app/upgrade/UpgradeTIMManager:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/app/upgrade/UpgradeTIMWrapper;)V
    //   10620: invokestatic 2566	java/lang/System:currentTimeMillis	()J
    //   10623: lstore 14
    //   10625: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   10628: ifeq +44 -> 10672
    //   10631: ldc 183
    //   10633: iconst_2
    //   10634: new 85	java/lang/StringBuilder
    //   10637: dup
    //   10638: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   10641: ldc_w 3252
    //   10644: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10647: lload 14
    //   10649: lload 12
    //   10651: lsub
    //   10652: invokevirtual 3255	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   10655: ldc_w 3257
    //   10658: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10661: iload 10
    //   10663: invokevirtual 152	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   10666: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   10669: invokestatic 373	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   10672: aconst_null
    //   10673: astore 4
    //   10675: aload_3
    //   10676: ifnull +1655 -> 12331
    //   10679: aload_3
    //   10680: ldc_w 2294
    //   10683: iconst_0
    //   10684: invokevirtual 2230	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   10687: istore 10
    //   10689: iload 10
    //   10691: ifeq +220 -> 10911
    //   10694: aload_3
    //   10695: ldc_w 3259
    //   10698: iconst_0
    //   10699: invokevirtual 3262	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   10702: istore 8
    //   10704: ldc 183
    //   10706: iconst_2
    //   10707: iconst_2
    //   10708: anewarray 301	java/lang/Object
    //   10711: dup
    //   10712: iconst_0
    //   10713: ldc_w 3264
    //   10716: aastore
    //   10717: dup
    //   10718: iconst_1
    //   10719: iload 8
    //   10721: invokestatic 305	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   10724: aastore
    //   10725: invokestatic 1656	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   10728: iload 8
    //   10730: istore 6
    //   10732: iload 10
    //   10734: istore 5
    //   10736: aload 4
    //   10738: astore_3
    //   10739: iload 8
    //   10741: iconst_3
    //   10742: if_icmpge +179 -> 10921
    //   10745: aload_1
    //   10746: getfield 3267	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:next_req_types	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   10749: invokevirtual 1143	com/tencent/mobileqq/pb/PBRepeatField:get	()Ljava/util/List;
    //   10752: astore 16
    //   10754: iload 8
    //   10756: istore 6
    //   10758: iload 10
    //   10760: istore 5
    //   10762: aload 4
    //   10764: astore_3
    //   10765: aload 16
    //   10767: ifnull +154 -> 10921
    //   10770: iload 8
    //   10772: istore 6
    //   10774: iload 10
    //   10776: istore 5
    //   10778: aload 4
    //   10780: astore_3
    //   10781: aload 16
    //   10783: invokeinterface 400 1 0
    //   10788: ifle +133 -> 10921
    //   10791: aload 16
    //   10793: invokeinterface 400 1 0
    //   10798: newarray int
    //   10800: astore 4
    //   10802: aload 16
    //   10804: invokeinterface 400 1 0
    //   10809: istore 9
    //   10811: iconst_0
    //   10812: istore 7
    //   10814: iload 8
    //   10816: istore 6
    //   10818: iload 10
    //   10820: istore 5
    //   10822: aload 4
    //   10824: astore_3
    //   10825: iload 7
    //   10827: iload 9
    //   10829: if_icmpge +92 -> 10921
    //   10832: aload 16
    //   10834: iload 7
    //   10836: invokeinterface 447 2 0
    //   10841: checkcast 139	java/lang/Integer
    //   10844: invokevirtual 1823	java/lang/Integer:intValue	()I
    //   10847: istore 6
    //   10849: aload 4
    //   10851: iload 7
    //   10853: iload 6
    //   10855: iastore
    //   10856: aload 18
    //   10858: invokeinterface 400 1 0
    //   10863: ifle +20 -> 10883
    //   10866: aload 18
    //   10868: new 139	java/lang/Integer
    //   10871: dup
    //   10872: iload 6
    //   10874: invokespecial 2569	java/lang/Integer:<init>	(I)V
    //   10877: invokeinterface 2571 2 0
    //   10882: pop
    //   10883: iload 7
    //   10885: iconst_1
    //   10886: iadd
    //   10887: istore 7
    //   10889: goto -75 -> 10814
    //   10892: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   10895: ifeq -275 -> 10620
    //   10898: ldc_w 1781
    //   10901: iconst_2
    //   10902: ldc_w 3269
    //   10905: invokestatic 199	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   10908: goto -288 -> 10620
    //   10911: iconst_0
    //   10912: istore 6
    //   10914: aload 4
    //   10916: astore_3
    //   10917: iload 10
    //   10919: istore 5
    //   10921: aload 18
    //   10923: invokeinterface 233 1 0
    //   10928: astore 4
    //   10930: aload 4
    //   10932: invokeinterface 238 1 0
    //   10937: ifeq +1189 -> 12126
    //   10940: aload 4
    //   10942: invokeinterface 242 1 0
    //   10947: checkcast 139	java/lang/Integer
    //   10950: astore 16
    //   10952: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   10955: ifeq +46 -> 11001
    //   10958: ldc 183
    //   10960: iconst_2
    //   10961: new 85	java/lang/StringBuilder
    //   10964: dup
    //   10965: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   10968: ldc_w 3271
    //   10971: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10974: aload 16
    //   10976: invokevirtual 798	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   10979: ldc_w 2134
    //   10982: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10985: aload 18
    //   10987: invokeinterface 400 1 0
    //   10992: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   10995: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   10998: invokestatic 373	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   11001: aload 16
    //   11003: invokevirtual 1823	java/lang/Integer:intValue	()I
    //   11006: lookupswitch	default:+202->11208, 1:+660->11666, 38:+606->11612, 42:+939->11945, 46:+599->11605, 86:+893->11899, 87:+795->11801, 113:+947->11953, 116:+233->11239, 119:+1009->12015, 156:+-76->10930, 185:+1035->12041, 188:+838->11844, 191:+1063->12069, 202:+1044->12050, 205:+875->11881, 206:+857->11863, 215:+1079->12085, 223:+993->11999, 231:+1085->12091, 237:+1114->12120, 297:+1099->12105, 345:+1106->12112, 364:+993->11999, 365:+993->11999
    //   11209: iconst_2
    //   11210: fconst_1
    //   11211: aload 16
    //   11213: invokevirtual 1823	java/lang/Integer:intValue	()I
    //   11216: invokevirtual 1295	alzw:b	(I)Z
    //   11219: ifeq -289 -> 10930
    //   11222: invokestatic 1292	alzw:a	()Lalzw;
    //   11225: aload 16
    //   11227: invokevirtual 1823	java/lang/Integer:intValue	()I
    //   11230: getstatic 15	amnh:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   11233: invokevirtual 3272	alzw:a	(ILjava/lang/String;)V
    //   11236: goto -306 -> 10930
    //   11239: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11242: ifeq +12 -> 11254
    //   11245: ldc 183
    //   11247: iconst_2
    //   11248: ldc_w 3274
    //   11251: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   11254: aload_2
    //   11255: iconst_4
    //   11256: invokevirtual 206	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lajfb;
    //   11259: checkcast 1775	ajgd
    //   11262: astore 17
    //   11264: ldc_w 2621
    //   11267: getstatic 15	amnh:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   11270: invokestatic 3276	akgm:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   11273: astore 19
    //   11275: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11278: ifeq +30 -> 11308
    //   11281: ldc 183
    //   11283: iconst_2
    //   11284: new 85	java/lang/StringBuilder
    //   11287: dup
    //   11288: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   11291: ldc_w 2665
    //   11294: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11297: aload 19
    //   11299: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11302: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   11305: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   11308: aload 19
    //   11310: invokestatic 126	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   11313: ifeq +53 -> 11366
    //   11316: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11319: ifeq +12 -> 11331
    //   11322: ldc 183
    //   11324: iconst_2
    //   11325: ldc_w 3278
    //   11328: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   11331: aload_2
    //   11332: invokevirtual 65	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   11335: getstatic 15	amnh:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   11338: iconst_0
    //   11339: invokestatic 2628	baig:p	(Landroid/content/Context;Ljava/lang/String;I)V
    //   11342: ldc_w 2621
    //   11345: getstatic 15	amnh:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   11348: invokestatic 2626	akgm:a	(Ljava/lang/String;Ljava/lang/String;)Z
    //   11351: pop
    //   11352: aload 17
    //   11354: invokestatic 2420	akgo:a	()Lakgo;
    //   11357: invokevirtual 2423	akgo:a	()Lcom/tencent/mobileqq/app/upgrade/UpgradeDetailWrapper;
    //   11360: invokevirtual 2426	ajgd:a	(Lcom/tencent/mobileqq/app/upgrade/UpgradeDetailWrapper;)V
    //   11363: goto -433 -> 10930
    //   11366: invokestatic 2420	akgo:a	()Lakgo;
    //   11369: invokevirtual 2423	akgo:a	()Lcom/tencent/mobileqq/app/upgrade/UpgradeDetailWrapper;
    //   11372: astore 16
    //   11374: aload 16
    //   11376: aload 19
    //   11378: invokevirtual 2631	com/tencent/mobileqq/app/upgrade/UpgradeDetailWrapper:a	(Ljava/lang/String;)V
    //   11381: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11384: ifeq +42 -> 11426
    //   11387: ldc 183
    //   11389: iconst_2
    //   11390: ldc_w 2633
    //   11393: iconst_2
    //   11394: anewarray 301	java/lang/Object
    //   11397: dup
    //   11398: iconst_0
    //   11399: invokestatic 203	com/tencent/common/config/AppSetting:a	()I
    //   11402: invokestatic 305	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   11405: aastore
    //   11406: dup
    //   11407: iconst_1
    //   11408: aload 16
    //   11410: getfield 2636	com/tencent/mobileqq/app/upgrade/UpgradeDetailWrapper:jdField_b_of_type_ProtocolKQQConfigUpgradeInfo	Lprotocol/KQQConfig/UpgradeInfo;
    //   11413: getfield 2641	protocol/KQQConfig/UpgradeInfo:iUpgradeSdkId	I
    //   11416: invokestatic 305	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   11419: aastore
    //   11420: invokestatic 309	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   11423: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   11426: invokestatic 203	com/tencent/common/config/AppSetting:a	()I
    //   11429: aload 16
    //   11431: getfield 2636	com/tencent/mobileqq/app/upgrade/UpgradeDetailWrapper:jdField_b_of_type_ProtocolKQQConfigUpgradeInfo	Lprotocol/KQQConfig/UpgradeInfo;
    //   11434: getfield 2641	protocol/KQQConfig/UpgradeInfo:iUpgradeSdkId	I
    //   11437: if_icmplt +63 -> 11500
    //   11440: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11443: ifeq +12 -> 11455
    //   11446: ldc 183
    //   11448: iconst_2
    //   11449: ldc_w 3280
    //   11452: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   11455: aload_2
    //   11456: invokevirtual 65	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   11459: getstatic 15	amnh:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   11462: iconst_0
    //   11463: invokestatic 2628	baig:p	(Landroid/content/Context;Ljava/lang/String;I)V
    //   11466: ldc_w 2621
    //   11469: getstatic 15	amnh:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   11472: invokestatic 2626	akgm:a	(Ljava/lang/String;Ljava/lang/String;)Z
    //   11475: pop
    //   11476: aload 16
    //   11478: getfield 2636	com/tencent/mobileqq/app/upgrade/UpgradeDetailWrapper:jdField_b_of_type_ProtocolKQQConfigUpgradeInfo	Lprotocol/KQQConfig/UpgradeInfo;
    //   11481: iconst_0
    //   11482: putfield 2662	protocol/KQQConfig/UpgradeInfo:iUpgradeType	I
    //   11485: aload 17
    //   11487: aload 16
    //   11489: invokevirtual 2426	ajgd:a	(Lcom/tencent/mobileqq/app/upgrade/UpgradeDetailWrapper;)V
    //   11492: aload 17
    //   11494: invokevirtual 2663	ajgd:c	()V
    //   11497: goto -567 -> 10930
    //   11500: aload 16
    //   11502: monitorenter
    //   11503: aload 16
    //   11505: getfield 2673	com/tencent/mobileqq/app/upgrade/UpgradeDetailWrapper:jdField_a_of_type_Boolean	Z
    //   11508: ifne +30 -> 11538
    //   11511: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11514: ifeq +12 -> 11526
    //   11517: ldc 183
    //   11519: iconst_2
    //   11520: ldc_w 2675
    //   11523: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   11526: aload 16
    //   11528: monitorexit
    //   11529: goto -599 -> 10930
    //   11532: astore_1
    //   11533: aload 16
    //   11535: monitorexit
    //   11536: aload_1
    //   11537: athrow
    //   11538: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11541: ifeq +12 -> 11553
    //   11544: ldc 183
    //   11546: iconst_2
    //   11547: ldc_w 2677
    //   11550: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   11553: aload 16
    //   11555: getfield 2679	com/tencent/mobileqq/app/upgrade/UpgradeDetailWrapper:jdField_b_of_type_Int	I
    //   11558: ifne +21 -> 11579
    //   11561: aload 16
    //   11563: getfield 2680	com/tencent/mobileqq/app/upgrade/UpgradeDetailWrapper:jdField_a_of_type_Int	I
    //   11566: iconst_1
    //   11567: if_icmpne +32 -> 11599
    //   11570: iconst_1
    //   11571: istore 10
    //   11573: aload_2
    //   11574: iload 10
    //   11576: invokestatic 2681	ajgd:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Z)V
    //   11579: invokestatic 2420	akgo:a	()Lakgo;
    //   11582: aload 16
    //   11584: getfield 2636	com/tencent/mobileqq/app/upgrade/UpgradeDetailWrapper:jdField_b_of_type_ProtocolKQQConfigUpgradeInfo	Lprotocol/KQQConfig/UpgradeInfo;
    //   11587: aload 17
    //   11589: invokevirtual 2684	akgo:a	(Lprotocol/KQQConfig/UpgradeInfo;Lakgq;)Z
    //   11592: pop
    //   11593: aload 16
    //   11595: monitorexit
    //   11596: goto -666 -> 10930
    //   11599: iconst_0
    //   11600: istore 10
    //   11602: goto -29 -> 11573
    //   11605: aload_2
    //   11606: invokestatic 2444	ysv:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   11609: goto -679 -> 10930
    //   11612: aload_2
    //   11613: invokevirtual 411	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   11616: invokestatic 3283	baig:b	(Ljava/lang/String;)Landroid/content/SharedPreferences;
    //   11619: astore 16
    //   11621: aload 16
    //   11623: invokeinterface 346 1 0
    //   11628: ldc_w 3285
    //   11631: invokeinterface 382 2 0
    //   11636: invokeinterface 726 1 0
    //   11641: pop
    //   11642: aload 16
    //   11644: invokeinterface 346 1 0
    //   11649: ldc_w 3287
    //   11652: invokeinterface 382 2 0
    //   11657: invokeinterface 726 1 0
    //   11662: pop
    //   11663: goto -733 -> 10930
    //   11666: new 85	java/lang/StringBuilder
    //   11669: dup
    //   11670: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   11673: aload_0
    //   11674: invokevirtual 47	amnh:getAppRuntime	()Lmqq/app/AppRuntime;
    //   11677: invokevirtual 2590	mqq/app/AppRuntime:getApplication	()Lmqq/app/MobileQQ;
    //   11680: invokevirtual 2717	mqq/app/MobileQQ:getFilesDir	()Ljava/io/File;
    //   11683: invokevirtual 2720	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   11686: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11689: ldc_w 3289
    //   11692: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11695: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   11698: astore 16
    //   11700: new 2711	java/io/File
    //   11703: dup
    //   11704: aload 16
    //   11706: invokespecial 2723	java/io/File:<init>	(Ljava/lang/String;)V
    //   11709: astore 17
    //   11711: aload 17
    //   11713: ifnull -783 -> 10930
    //   11716: aload 17
    //   11718: invokevirtual 2726	java/io/File:exists	()Z
    //   11721: ifeq -791 -> 10930
    //   11724: aload 17
    //   11726: invokevirtual 2739	java/io/File:isDirectory	()Z
    //   11729: ifeq -799 -> 10930
    //   11732: aload 17
    //   11734: invokevirtual 2743	java/io/File:listFiles	()[Ljava/io/File;
    //   11737: astore 17
    //   11739: aload 17
    //   11741: ifnull -811 -> 10930
    //   11744: aload 17
    //   11746: arraylength
    //   11747: istore 8
    //   11749: iconst_0
    //   11750: istore 7
    //   11752: iload 7
    //   11754: iload 8
    //   11756: if_icmpge -826 -> 10930
    //   11759: aload 17
    //   11761: iload 7
    //   11763: aaload
    //   11764: astore 19
    //   11766: aload 19
    //   11768: ifnonnull +12 -> 11780
    //   11771: iload 7
    //   11773: iconst_1
    //   11774: iadd
    //   11775: istore 7
    //   11777: goto -25 -> 11752
    //   11780: new 3291	com/tencent/mobileqq/config/splashlogo/ConfigServlet$1
    //   11783: dup
    //   11784: aload_0
    //   11785: aload 19
    //   11787: aload 16
    //   11789: invokespecial 3294	com/tencent/mobileqq/config/splashlogo/ConfigServlet$1:<init>	(Lamnh;Ljava/io/File;Ljava/lang/String;)V
    //   11792: iconst_5
    //   11793: aconst_null
    //   11794: iconst_1
    //   11795: invokestatic 3300	com/tencent/mobileqq/app/ThreadManager:post	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   11798: goto -27 -> 11771
    //   11801: aload_2
    //   11802: sipush 168
    //   11805: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   11808: checkcast 1676	aknw
    //   11811: astore 16
    //   11813: aload 16
    //   11815: ifnull +10 -> 11825
    //   11818: aload 16
    //   11820: iconst_1
    //   11821: iconst_0
    //   11822: invokevirtual 2484	aknw:a	(ZZ)V
    //   11825: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11828: ifeq -898 -> 10930
    //   11831: ldc_w 1703
    //   11834: iconst_2
    //   11835: ldc_w 3302
    //   11838: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   11841: goto -911 -> 10930
    //   11844: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11847: ifeq -917 -> 10930
    //   11850: ldc_w 3304
    //   11853: iconst_2
    //   11854: ldc_w 3306
    //   11857: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   11860: goto -930 -> 10930
    //   11863: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11866: ifeq -936 -> 10930
    //   11869: ldc 183
    //   11871: iconst_2
    //   11872: ldc_w 3308
    //   11875: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   11878: goto -948 -> 10930
    //   11881: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11884: ifeq -954 -> 10930
    //   11887: ldc 183
    //   11889: iconst_2
    //   11890: ldc_w 3310
    //   11893: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   11896: goto -966 -> 10930
    //   11899: aload_2
    //   11900: sipush 167
    //   11903: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   11906: checkcast 1638	com/tencent/mobileqq/olympic/OlympicManager
    //   11909: astore 16
    //   11911: aload 16
    //   11913: ifnull +13 -> 11926
    //   11916: aload 16
    //   11918: invokevirtual 2492	com/tencent/mobileqq/olympic/OlympicManager:f	()V
    //   11921: aload 16
    //   11923: invokevirtual 2494	com/tencent/mobileqq/olympic/OlympicManager:g	()V
    //   11926: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11929: ifeq -999 -> 10930
    //   11932: ldc_w 1663
    //   11935: iconst_2
    //   11936: ldc_w 3312
    //   11939: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   11942: goto -1012 -> 10930
    //   11945: aload_0
    //   11946: aconst_null
    //   11947: invokespecial 2946	amnh:p	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   11950: goto -1020 -> 10930
    //   11953: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11956: ifeq +12 -> 11968
    //   11959: ldc 183
    //   11961: iconst_2
    //   11962: ldc_w 2501
    //   11965: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   11968: aload_2
    //   11969: sipush 179
    //   11972: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   11975: checkcast 2503	attv
    //   11978: astore 16
    //   11980: aload 16
    //   11982: ifnull -1052 -> 10930
    //   11985: aload 16
    //   11987: invokevirtual 2504	attv:a	()V
    //   11990: aload 16
    //   11992: iconst_1
    //   11993: invokevirtual 2505	attv:a	(Z)V
    //   11996: goto -1066 -> 10930
    //   11999: aload_2
    //   12000: invokestatic 1510	com/tencent/mobileqq/utils/BusinessCommonConfig:getInstance	(Lmqq/app/AppRuntime;)Lcom/tencent/mobileqq/utils/BusinessCommonConfig;
    //   12003: aload_2
    //   12004: aload 16
    //   12006: invokevirtual 1823	java/lang/Integer:intValue	()I
    //   12009: invokevirtual 3315	com/tencent/mobileqq/utils/BusinessCommonConfig:handleResp_Config_NoResp	(Lcom/tencent/mobileqq/app/QQAppInterface;I)V
    //   12012: goto -1082 -> 10930
    //   12015: aload_2
    //   12016: bipush 53
    //   12018: invokevirtual 206	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lajfb;
    //   12021: checkcast 1787	ajei
    //   12024: astore 16
    //   12026: aload 16
    //   12028: ifnull -1098 -> 10930
    //   12031: aload 16
    //   12033: iconst_0
    //   12034: iconst_0
    //   12035: invokevirtual 2499	ajei:a	(ZZ)V
    //   12038: goto -1108 -> 10930
    //   12041: invokestatic 2545	com/tencent/mobileqq/scribble/ScribbleResMgr:a	()Lcom/tencent/mobileqq/scribble/ScribbleResMgr;
    //   12044: invokevirtual 3316	com/tencent/mobileqq/scribble/ScribbleResMgr:a	()V
    //   12047: goto -1117 -> 10930
    //   12050: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   12053: ifeq -1123 -> 10930
    //   12056: ldc_w 2335
    //   12059: iconst_2
    //   12060: ldc_w 3318
    //   12063: invokestatic 199	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   12066: goto -1136 -> 10930
    //   12069: aload_2
    //   12070: sipush 218
    //   12073: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   12076: checkcast 3320	acjd
    //   12079: invokevirtual 3321	acjd:a	()V
    //   12082: goto -1152 -> 10930
    //   12085: invokestatic 3322	com/tencent/mobileqq/shortvideo/ShortVideoResourceManager:b	()V
    //   12088: goto -1158 -> 10930
    //   12091: aload_2
    //   12092: sipush 231
    //   12095: getstatic 15	amnh:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   12098: aconst_null
    //   12099: invokestatic 3140	ahml:a	(Lcom/tencent/mobileqq/app/QQAppInterface;ILjava/lang/String;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   12102: goto -1172 -> 10930
    //   12105: iconst_1
    //   12106: invokestatic 3323	amts:a	(Z)V
    //   12109: goto -1179 -> 10930
    //   12112: aload_2
    //   12113: iconst_1
    //   12114: invokestatic 3324	bbrm:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Z)V
    //   12117: goto -1187 -> 10930
    //   12120: invokestatic 3325	yjx:a	()V
    //   12123: goto -1193 -> 10930
    //   12126: iload 5
    //   12128: ifeq +341 -> 12469
    //   12131: iload 6
    //   12133: iconst_3
    //   12134: if_icmpge +335 -> 12469
    //   12137: aload_3
    //   12138: ifnull +331 -> 12469
    //   12141: aload_3
    //   12142: arraylength
    //   12143: ifle +326 -> 12469
    //   12146: new 85	java/lang/StringBuilder
    //   12149: dup
    //   12150: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   12153: astore 4
    //   12155: aload 4
    //   12157: ldc_w 3327
    //   12160: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12163: pop
    //   12164: aload_3
    //   12165: arraylength
    //   12166: istore 8
    //   12168: iconst_0
    //   12169: istore 7
    //   12171: iload 7
    //   12173: iload 8
    //   12175: if_icmpge +28 -> 12203
    //   12178: aload 4
    //   12180: aload_3
    //   12181: iload 7
    //   12183: iaload
    //   12184: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   12187: ldc_w 3329
    //   12190: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12193: pop
    //   12194: iload 7
    //   12196: iconst_1
    //   12197: iadd
    //   12198: istore 7
    //   12200: goto -29 -> 12171
    //   12203: ldc 183
    //   12205: iconst_1
    //   12206: aload 4
    //   12208: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   12211: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   12214: new 1248	mqq/app/NewIntent
    //   12217: dup
    //   12218: aload_2
    //   12219: invokevirtual 65	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   12222: ldc 2
    //   12224: invokespecial 1251	mqq/app/NewIntent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   12227: astore 4
    //   12229: aload 4
    //   12231: ldc_w 1253
    //   12234: aload_3
    //   12235: invokevirtual 1257	mqq/app/NewIntent:putExtra	(Ljava/lang/String;[I)Landroid/content/Intent;
    //   12238: pop
    //   12239: aload 4
    //   12241: ldc_w 1263
    //   12244: getstatic 15	amnh:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   12247: invokevirtual 1266	mqq/app/NewIntent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   12250: pop
    //   12251: aload 4
    //   12253: ldc_w 2226
    //   12256: iconst_1
    //   12257: invokevirtual 2297	mqq/app/NewIntent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   12260: pop
    //   12261: aload_1
    //   12262: getfield 3330	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:cookies	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   12265: invokevirtual 1126	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   12268: ifeq +22 -> 12290
    //   12271: aload 4
    //   12273: ldc_w 2235
    //   12276: aload_1
    //   12277: getfield 3330	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:cookies	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   12280: invokevirtual 260	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   12283: invokevirtual 266	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   12286: invokevirtual 3333	mqq/app/NewIntent:putExtra	(Ljava/lang/String;[B)Landroid/content/Intent;
    //   12289: pop
    //   12290: aload 4
    //   12292: ldc_w 2294
    //   12295: iload 5
    //   12297: invokevirtual 2297	mqq/app/NewIntent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   12300: pop
    //   12301: aload 4
    //   12303: ldc_w 3259
    //   12306: iload 6
    //   12308: iconst_1
    //   12309: iadd
    //   12310: invokevirtual 2292	mqq/app/NewIntent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   12313: pop
    //   12314: aload 4
    //   12316: ldc_w 2291
    //   12319: iconst_0
    //   12320: invokevirtual 2292	mqq/app/NewIntent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   12323: pop
    //   12324: aload_2
    //   12325: aload 4
    //   12327: invokevirtual 1273	com/tencent/mobileqq/app/QQAppInterface:startServlet	(Lmqq/app/NewIntent;)V
    //   12330: return
    //   12331: iconst_0
    //   12332: istore 5
    //   12334: iconst_0
    //   12335: istore 6
    //   12337: aload 4
    //   12339: astore_3
    //   12340: goto -1419 -> 10921
    //   12343: aconst_null
    //   12344: astore 16
    //   12346: goto -2369 -> 9977
    //   12349: aconst_null
    //   12350: astore 16
    //   12352: goto -4897 -> 7455
    //   12355: aload 4
    //   12357: astore 16
    //   12359: goto -8169 -> 4190
    //   12362: aconst_null
    //   12363: astore 16
    //   12365: goto -8305 -> 4060
    //   12368: goto -8468 -> 3900
    //   12371: aload 4
    //   12373: astore 16
    //   12375: iload 10
    //   12377: istore 11
    //   12379: goto -10244 -> 2135
    //   12382: aconst_null
    //   12383: astore 16
    //   12385: goto -8325 -> 4060
    //   12388: astore 17
    //   12390: goto -8091 -> 4299
    //   12393: iconst_0
    //   12394: istore 10
    //   12396: goto -7447 -> 4949
    //   12399: iload 7
    //   12401: iconst_1
    //   12402: iadd
    //   12403: istore 7
    //   12405: goto -7344 -> 5061
    //   12408: goto -37 -> 12371
    //   12411: iload 7
    //   12413: iconst_1
    //   12414: iadd
    //   12415: istore 7
    //   12417: goto -7168 -> 5249
    //   12420: goto -49 -> 12371
    //   12423: iload 7
    //   12425: iconst_1
    //   12426: iadd
    //   12427: istore 7
    //   12429: goto -6743 -> 5686
    //   12432: goto -61 -> 12371
    //   12435: goto -64 -> 12371
    //   12438: iload 7
    //   12440: iconst_1
    //   12441: iadd
    //   12442: istore 7
    //   12444: goto -5840 -> 6604
    //   12447: iload 8
    //   12449: istore 7
    //   12451: goto -5301 -> 7150
    //   12454: goto -83 -> 12371
    //   12457: goto -86 -> 12371
    //   12460: goto -89 -> 12371
    //   12463: goto -92 -> 12371
    //   12466: goto -95 -> 12371
    //   12469: return
    //   12470: goto -99 -> 12371
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	12473	0	this	amnh
    //   0	12473	1	paramRespGetConfig	ConfigurationService.RespGetConfig
    //   0	12473	2	paramQQAppInterface	QQAppInterface
    //   0	12473	3	paramIntent	Intent
    //   0	12473	4	paramArrayOfInt	int[]
    //   0	12473	5	paramBoolean	boolean
    //   369	11967	6	i	int
    //   53	12397	7	j	int
    //   365	12083	8	k	int
    //   68	10762	9	m	int
    //   2096	10299	10	bool1	boolean
    //   2129	10249	11	bool2	boolean
    //   2033	8617	12	l1	long
    //   10623	25	14	l2	long
    //   2133	2058	16	localObject1	Object
    //   4197	9	16	localUnsupportedEncodingException1	UnsupportedEncodingException
    //   4213	9	16	localOutOfMemoryError1	OutOfMemoryError
    //   4241	1	16	str1	String
    //   4246	1	16	localThrowable1	Throwable
    //   4249	610	16	localObject2	Object
    //   4983	6	16	localObject3	Object
    //   5087	3158	16	localObject4	Object
    //   8323	39	16	localException1	Exception
    //   8443	13	16	localIterator1	Iterator
    //   8534	617	16	localException2	Exception
    //   9599	388	16	localObject5	Object
    //   10015	1	16	localUnsupportedEncodingException2	UnsupportedEncodingException
    //   10018	1	16	localObject6	Object
    //   10023	1	16	localOutOfMemoryError2	OutOfMemoryError
    //   10040	1	16	str2	String
    //   10045	1	16	localThrowable2	Throwable
    //   10048	17	16	str3	String
    //   10069	12	16	localException3	Exception
    //   10257	314	16	localThrowable3	Throwable
    //   10752	1632	16	localObject7	Object
    //   3920	314	17	localObject8	Object
    //   4297	33	17	localException4	Exception
    //   4445	541	17	localUpgradeDetailWrapper	com.tencent.mobileqq.app.upgrade.UpgradeDetailWrapper
    //   4991	1	17	localException5	Exception
    //   5550	6210	17	localObject9	Object
    //   12388	1	17	localException6	Exception
    //   2054	8932	18	localArrayList	ArrayList
    //   2120	9666	19	localObject10	Object
    //   6814	223	20	localObject11	Object
    //   6860	13	21	localIterator2	Iterator
    //   6882	55	22	str4	String
    // Exception table:
    //   from	to	target	type
    //   4046	4060	4197	java/io/UnsupportedEncodingException
    //   4046	4060	4213	java/lang/OutOfMemoryError
    //   4229	4243	4246	java/lang/Throwable
    //   4131	4175	4297	java/lang/Exception
    //   4175	4186	4297	java/lang/Exception
    //   4274	4290	4297	java/lang/Exception
    //   4882	4905	4983	finally
    //   4905	4908	4983	finally
    //   4914	4929	4983	finally
    //   4929	4946	4983	finally
    //   4949	4955	4983	finally
    //   4955	4977	4983	finally
    //   4985	4988	4983	finally
    //   4863	4882	4991	java/lang/Exception
    //   4988	4991	4991	java/lang/Exception
    //   8200	8234	8323	java/lang/Exception
    //   8234	8306	8323	java/lang/Exception
    //   8306	8320	8323	java/lang/Exception
    //   8369	8408	8323	java/lang/Exception
    //   8411	8445	8534	java/lang/Exception
    //   8445	8517	8534	java/lang/Exception
    //   8517	8531	8534	java/lang/Exception
    //   8580	8619	8534	java/lang/Exception
    //   9963	9977	10015	java/io/UnsupportedEncodingException
    //   9963	9977	10023	java/lang/OutOfMemoryError
    //   10028	10042	10045	java/lang/Throwable
    //   9982	10012	10069	java/lang/Exception
    //   10243	10254	10257	java/lang/Throwable
    //   11503	11526	11532	finally
    //   11526	11529	11532	finally
    //   11533	11536	11532	finally
    //   11538	11553	11532	finally
    //   11553	11570	11532	finally
    //   11573	11579	11532	finally
    //   11579	11596	11532	finally
    //   2242	3900	12388	java/lang/Exception
    //   3903	3949	12388	java/lang/Exception
    //   3957	3972	12388	java/lang/Exception
    //   3975	4008	12388	java/lang/Exception
    //   4013	4041	12388	java/lang/Exception
    //   4046	4060	12388	java/lang/Exception
    //   4065	4120	12388	java/lang/Exception
    //   4120	4127	12388	java/lang/Exception
    //   4199	4210	12388	java/lang/Exception
    //   4215	4226	12388	java/lang/Exception
    //   4226	4229	12388	java/lang/Exception
    //   4229	4243	12388	java/lang/Exception
    //   4254	4267	12388	java/lang/Exception
    //   4358	4374	12388	java/lang/Exception
    //   4381	4444	12388	java/lang/Exception
    //   4454	4473	12388	java/lang/Exception
    //   4473	4488	12388	java/lang/Exception
    //   4488	4498	12388	java/lang/Exception
    //   4501	4516	12388	java/lang/Exception
    //   4516	4594	12388	java/lang/Exception
    //   4594	4681	12388	java/lang/Exception
    //   4681	4710	12388	java/lang/Exception
    //   4710	4752	12388	java/lang/Exception
    //   4755	4802	12388	java/lang/Exception
    //   4802	4820	12388	java/lang/Exception
    //   4823	4834	12388	java/lang/Exception
    //   4841	4856	12388	java/lang/Exception
    //   4999	5015	12388	java/lang/Exception
    //   5018	5058	12388	java/lang/Exception
    //   5061	5139	12388	java/lang/Exception
    //   5139	5161	12388	java/lang/Exception
    //   5164	5203	12388	java/lang/Exception
    //   5206	5246	12388	java/lang/Exception
    //   5249	5327	12388	java/lang/Exception
    //   5327	5350	12388	java/lang/Exception
    //   5353	5392	12388	java/lang/Exception
    //   5395	5438	12388	java/lang/Exception
    //   5441	5515	12388	java/lang/Exception
    //   5515	5530	12388	java/lang/Exception
    //   5530	5602	12388	java/lang/Exception
    //   5602	5655	12388	java/lang/Exception
    //   5663	5683	12388	java/lang/Exception
    //   5705	5719	12388	java/lang/Exception
    //   5722	5761	12388	java/lang/Exception
    //   5761	5808	12388	java/lang/Exception
    //   5813	5819	12388	java/lang/Exception
    //   5819	5842	12388	java/lang/Exception
    //   5845	5885	12388	java/lang/Exception
    //   5885	5957	12388	java/lang/Exception
    //   5957	5971	12388	java/lang/Exception
    //   5974	5993	12388	java/lang/Exception
    //   5998	6008	12388	java/lang/Exception
    //   6008	6170	12388	java/lang/Exception
    //   6173	6212	12388	java/lang/Exception
    //   6212	6243	12388	java/lang/Exception
    //   6248	6258	12388	java/lang/Exception
    //   6258	6332	12388	java/lang/Exception
    //   6335	6418	12388	java/lang/Exception
    //   6418	6432	12388	java/lang/Exception
    //   6435	6474	12388	java/lang/Exception
    //   6474	6547	12388	java/lang/Exception
    //   6547	6570	12388	java/lang/Exception
    //   6573	6601	12388	java/lang/Exception
    //   6604	6682	12388	java/lang/Exception
    //   6682	6690	12388	java/lang/Exception
    //   6695	6703	12388	java/lang/Exception
    //   6706	6753	12388	java/lang/Exception
    //   6756	6795	12388	java/lang/Exception
    //   6798	6862	12388	java/lang/Exception
    //   6862	6934	12388	java/lang/Exception
    //   6934	6959	12388	java/lang/Exception
    //   6962	7001	12388	java/lang/Exception
    //   7001	7030	12388	java/lang/Exception
    //   7033	7080	12388	java/lang/Exception
    //   7080	7093	12388	java/lang/Exception
    //   7096	7111	12388	java/lang/Exception
    //   7114	7127	12388	java/lang/Exception
    //   7132	7150	12388	java/lang/Exception
    //   7150	7251	12388	java/lang/Exception
    //   7251	7260	12388	java/lang/Exception
    //   7263	7294	12388	java/lang/Exception
    //   7303	7337	12388	java/lang/Exception
    //   7340	7384	12388	java/lang/Exception
    //   7391	7423	12388	java/lang/Exception
    //   7426	7455	12388	java/lang/Exception
    //   7460	7533	12388	java/lang/Exception
    //   7533	7547	12388	java/lang/Exception
    //   7547	7619	12388	java/lang/Exception
    //   7619	7627	12388	java/lang/Exception
    //   7627	7649	12388	java/lang/Exception
    //   7652	7698	12388	java/lang/Exception
    //   7701	7716	12388	java/lang/Exception
    //   7719	7726	12388	java/lang/Exception
    //   7729	7736	12388	java/lang/Exception
    //   7739	7746	12388	java/lang/Exception
    //   7749	7755	12388	java/lang/Exception
    //   7758	7764	12388	java/lang/Exception
    //   7767	7872	12388	java/lang/Exception
    //   7875	7914	12388	java/lang/Exception
    //   7917	8029	12388	java/lang/Exception
    //   8032	8088	12388	java/lang/Exception
    //   8091	8098	12388	java/lang/Exception
    //   8101	8108	12388	java/lang/Exception
    //   8111	8118	12388	java/lang/Exception
    //   8121	8128	12388	java/lang/Exception
    //   8131	8139	12388	java/lang/Exception
    //   8142	8149	12388	java/lang/Exception
    //   8152	8158	12388	java/lang/Exception
    //   8161	8167	12388	java/lang/Exception
    //   8170	8177	12388	java/lang/Exception
    //   8180	8197	12388	java/lang/Exception
    //   8325	8361	12388	java/lang/Exception
    //   8361	8366	12388	java/lang/Exception
    //   8536	8572	12388	java/lang/Exception
    //   8572	8577	12388	java/lang/Exception
    //   8622	8628	12388	java/lang/Exception
    //   8631	8637	12388	java/lang/Exception
    //   8640	8646	12388	java/lang/Exception
    //   8649	8655	12388	java/lang/Exception
    //   8658	8664	12388	java/lang/Exception
    //   8667	8673	12388	java/lang/Exception
    //   8676	8682	12388	java/lang/Exception
    //   8685	8691	12388	java/lang/Exception
    //   8694	8700	12388	java/lang/Exception
    //   8703	8709	12388	java/lang/Exception
    //   8712	8718	12388	java/lang/Exception
    //   8721	8727	12388	java/lang/Exception
    //   8730	8736	12388	java/lang/Exception
    //   8739	8745	12388	java/lang/Exception
    //   8748	8754	12388	java/lang/Exception
    //   8757	8763	12388	java/lang/Exception
    //   8766	8772	12388	java/lang/Exception
    //   8775	8781	12388	java/lang/Exception
    //   8784	8790	12388	java/lang/Exception
    //   8793	8799	12388	java/lang/Exception
    //   8802	8812	12388	java/lang/Exception
    //   8815	8821	12388	java/lang/Exception
    //   8824	8830	12388	java/lang/Exception
    //   8833	8839	12388	java/lang/Exception
    //   8842	8848	12388	java/lang/Exception
    //   8851	8941	12388	java/lang/Exception
    //   8941	8994	12388	java/lang/Exception
    //   8997	9047	12388	java/lang/Exception
    //   9050	9057	12388	java/lang/Exception
    //   9060	9076	12388	java/lang/Exception
    //   9079	9086	12388	java/lang/Exception
    //   9089	9096	12388	java/lang/Exception
    //   9099	9106	12388	java/lang/Exception
    //   9109	9116	12388	java/lang/Exception
    //   9119	9127	12388	java/lang/Exception
    //   9130	9137	12388	java/lang/Exception
    //   9140	9147	12388	java/lang/Exception
    //   9150	9164	12388	java/lang/Exception
    //   9167	9174	12388	java/lang/Exception
    //   9177	9193	12388	java/lang/Exception
    //   9196	9203	12388	java/lang/Exception
    //   9206	9213	12388	java/lang/Exception
    //   9216	9223	12388	java/lang/Exception
    //   9226	9233	12388	java/lang/Exception
    //   9236	9243	12388	java/lang/Exception
    //   9246	9253	12388	java/lang/Exception
    //   9256	9263	12388	java/lang/Exception
    //   9266	9273	12388	java/lang/Exception
    //   9276	9283	12388	java/lang/Exception
    //   9286	9293	12388	java/lang/Exception
    //   9296	9301	12388	java/lang/Exception
    //   9304	9311	12388	java/lang/Exception
    //   9314	9321	12388	java/lang/Exception
    //   9324	9331	12388	java/lang/Exception
    //   9334	9341	12388	java/lang/Exception
    //   9344	9351	12388	java/lang/Exception
    //   9354	9361	12388	java/lang/Exception
    //   9364	9371	12388	java/lang/Exception
    //   9374	9381	12388	java/lang/Exception
    //   9384	9391	12388	java/lang/Exception
    //   9394	9413	12388	java/lang/Exception
    //   9416	9423	12388	java/lang/Exception
    //   9426	9433	12388	java/lang/Exception
    //   9436	9443	12388	java/lang/Exception
    //   9446	9453	12388	java/lang/Exception
    //   9456	9463	12388	java/lang/Exception
    //   9466	9473	12388	java/lang/Exception
    //   9476	9482	12388	java/lang/Exception
    //   9485	9492	12388	java/lang/Exception
    //   9495	9502	12388	java/lang/Exception
    //   9505	9512	12388	java/lang/Exception
    //   9515	9522	12388	java/lang/Exception
    //   9525	9532	12388	java/lang/Exception
    //   9535	9542	12388	java/lang/Exception
    //   9545	9552	12388	java/lang/Exception
    //   9555	9562	12388	java/lang/Exception
    //   9565	9572	12388	java/lang/Exception
    //   9575	9581	12388	java/lang/Exception
    //   9584	9601	12388	java/lang/Exception
    //   9606	9623	12388	java/lang/Exception
    //   9626	9643	12388	java/lang/Exception
    //   9648	9668	12388	java/lang/Exception
    //   9671	9678	12388	java/lang/Exception
    //   9681	9688	12388	java/lang/Exception
    //   9691	9698	12388	java/lang/Exception
    //   9701	9707	12388	java/lang/Exception
    //   9710	9716	12388	java/lang/Exception
    //   9719	9725	12388	java/lang/Exception
    //   9728	9738	12388	java/lang/Exception
    //   9741	9753	12388	java/lang/Exception
    //   9758	9766	12388	java/lang/Exception
    //   9769	9776	12388	java/lang/Exception
    //   9779	9786	12388	java/lang/Exception
    //   9789	9801	12388	java/lang/Exception
    //   9804	9811	12388	java/lang/Exception
    //   9814	9821	12388	java/lang/Exception
    //   9824	9831	12388	java/lang/Exception
    //   9834	9841	12388	java/lang/Exception
    //   9844	9851	12388	java/lang/Exception
    //   9859	9867	12388	java/lang/Exception
    //   9868	9886	12388	java/lang/Exception
    //   9893	9901	12388	java/lang/Exception
    //   9905	9958	12388	java/lang/Exception
    //   9963	9977	12388	java/lang/Exception
    //   10025	10028	12388	java/lang/Exception
    //   10028	10042	12388	java/lang/Exception
    //   10053	10066	12388	java/lang/Exception
    //   10071	10089	12388	java/lang/Exception
    //   10092	10099	12388	java/lang/Exception
    //   10102	10109	12388	java/lang/Exception
    //   10112	10119	12388	java/lang/Exception
    //   10122	10129	12388	java/lang/Exception
    //   10132	10139	12388	java/lang/Exception
    //   10142	10149	12388	java/lang/Exception
    //   10152	10159	12388	java/lang/Exception
    //   10162	10168	12388	java/lang/Exception
    //   10171	10189	12388	java/lang/Exception
    //   10192	10210	12388	java/lang/Exception
    //   10213	10222	12388	java/lang/Exception
    //   10225	10240	12388	java/lang/Exception
    //   10243	10254	12388	java/lang/Exception
    //   10259	10264	12388	java/lang/Exception
    //   10267	10274	12388	java/lang/Exception
    //   10277	10284	12388	java/lang/Exception
    //   10287	10294	12388	java/lang/Exception
    //   10297	10304	12388	java/lang/Exception
    //   10307	10314	12388	java/lang/Exception
    //   10317	10331	12388	java/lang/Exception
    //   10334	10341	12388	java/lang/Exception
    //   10344	10355	12388	java/lang/Exception
    //   10358	10370	12388	java/lang/Exception
    //   10373	10380	12388	java/lang/Exception
    //   10383	10390	12388	java/lang/Exception
    //   10393	10412	12388	java/lang/Exception
    //   10415	10422	12388	java/lang/Exception
    //   10425	10431	12388	java/lang/Exception
    //   10434	10445	12388	java/lang/Exception
    //   10448	10466	12388	java/lang/Exception
    //   10469	10481	12388	java/lang/Exception
    //   10484	10489	12388	java/lang/Exception
    //   10492	10498	12388	java/lang/Exception
    //   10501	10508	12388	java/lang/Exception
    //   10511	10526	12388	java/lang/Exception
    //   10529	10535	12388	java/lang/Exception
    //   10538	10553	12388	java/lang/Exception
    //   10556	10563	12388	java/lang/Exception
    //   10566	10578	12388	java/lang/Exception
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
        localObject = baig.b(((QQAppInterface)getAppRuntime()).getCurrentAccountUin());
        ((SharedPreferences)localObject).edit().putString("qav_upgrade_invite_video", paramString).commit();
        ((SharedPreferences)localObject).edit().putString("qav_upgrade_invite_multi", str).commit();
        baig.i(getAppRuntime().getApplication(), paramInt, jdField_a_of_type_JavaLangString);
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
  
  public static boolean a(amnt paramamnt, String paramString, Set<String> paramSet)
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
      catch (Exception paramamnt)
      {
        bool1 = bool2;
        if (QLog.isColorLevel())
        {
          QLog.i("SPLASH_ConfigServlet", 2, "parseXML | NearbyBanner parse exception,", paramamnt);
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
        paramamnt.a(paramamnt.a(l1, str3, (byte)3, str2, ((StringBuffer)localObject).toString(), BaseApplication.getContext().getFilesDir().getAbsolutePath() + "/" + "NearbyBannerPic" + "/" + str1, l3 + "|" + l2, (short)k, str1));
        asfc.a(jdField_a_of_type_JavaLangString, "has_new_banner", Boolean.valueOf(true));
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
    bakz.a(arrayOfByte, 0, 4L + l);
    bakz.a(arrayOfByte, 4, paramReqGetConfig, (int)l);
    return arrayOfByte;
  }
  
  public static byte[] a(byte[] paramArrayOfByte)
  {
    int i = paramArrayOfByte.length - 4;
    byte[] arrayOfByte = new byte[i];
    bakz.a(arrayOfByte, 0, paramArrayOfByte, 4, i);
    return arrayOfByte;
  }
  
  private void aa(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    for (;;)
    {
      try
      {
        j = paramConfig.version.get();
        k = baig.a(paramQQAppInterface.getApp(), "change_machine_version", jdField_a_of_type_JavaLangString);
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
        azgp localazgp;
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
        localazgp.a("");
        if (!QLog.isColorLevel()) {
          break label261;
        }
        QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 195,content_list is empty ,version: " + paramConfig.version.get());
        return;
        if (j != k) {
          continue;
        }
      }
      localazgp = (azgp)paramQQAppInterface.getManager(224);
      if (i > 0)
      {
        paramConfig = b(paramConfig, k, 195);
        localazgp.a(paramConfig);
        if (!TextUtils.isEmpty(paramConfig))
        {
          baig.a(paramQQAppInterface.getApp(), "change_machine_version", jdField_a_of_type_JavaLangString, j);
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
  
  private void ab(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    for (;;)
    {
      try
      {
        j = paramConfig.version.get();
        k = baig.a(paramQQAppInterface.getApp(), "nearby_auth_video_config_version", jdField_a_of_type_JavaLangString);
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
          asfn.a(paramConfig);
          baig.a(paramQQAppInterface.getApp(), "nearby_auth_video_config_version", jdField_a_of_type_JavaLangString, j);
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
  
  private void ac(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    for (;;)
    {
      try
      {
        j = paramConfig.version.get();
        k = baig.a(paramQQAppInterface.getApp(), "nearby_videochat_dialog_config_version", jdField_a_of_type_JavaLangString);
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
          ((azgp)paramQQAppInterface.getManager(224)).c(paramConfig);
          baig.a(paramQQAppInterface.getApp(), "nearby_videochat_dialog_config_version", jdField_a_of_type_JavaLangString, j);
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
  
  private void ad(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    for (;;)
    {
      try
      {
        j = paramConfig.version.get();
        k = baig.a(paramQQAppInterface.getApp(), "nearby_videochat_banner_config_version", jdField_a_of_type_JavaLangString);
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
          ((azgp)paramQQAppInterface.getManager(224)).b(paramConfig);
          baig.a(paramQQAppInterface.getApp(), "nearby_videochat_banner_config_version", jdField_a_of_type_JavaLangString, j);
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
  
  private void ae(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    int k = paramConfig.version.get();
    paramQQAppInterface = paramQQAppInterface.getAccount();
    int i = baig.aP(((QQAppInterface)getAppRuntime()).getApp(), paramQQAppInterface);
    if (!bhhb.a()) {
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
        baig.af(((QQAppInterface)getAppRuntime()).getApp(), paramQQAppInterface, k);
        new bhnv().a(paramConfig, bhhb.a.getAbsolutePath(), "temp_template_zip", new amnj(this));
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.d("QQSTORY_QUESTION_TAB_SPLASH_ConfigServlet", 2, "GetQQStoryQuestionTabConfig|type: 问答Tab配置回包内容为空");
    return;
    label229:
    if (QLog.isColorLevel()) {
      QLog.d("QQSTORY_QUESTION_TAB_SPLASH_ConfigServlet", 2, "GetQQStoryQuestionTabConfig|type: 问答Tab配置回包为空");
    }
    bhhb.e();
  }
  
  private void af(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    if ((paramConfig.content_list != null) && (paramConfig.content_list.size() > 0))
    {
      paramQQAppInterface = (PhoneContactManagerImp)paramQQAppInterface.getManager(11);
      if (paramConfig.content_list.size() < 0)
      {
        str = (String)paramConfig.content_list.get(0);
        i = paramConfig.version.get();
        j = paramQQAppInterface.f();
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
  
  private void ag(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    try
    {
      i = paramConfig.version.get();
      localajei = (ajei)paramQQAppInterface.a(53);
      j = localajei.a(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount());
      if ((paramConfig.content_list != null) && (paramConfig.content_list.size() > 0))
      {
        paramQQAppInterface = (String)paramConfig.content_list.get(0);
        if (QLog.isColorLevel()) {
          QLog.d("babyqConfig", 2, "received BabyQPlusPanelConfig configVersion:" + i + " ,localVersion:" + j + " ,configContent" + paramQQAppInterface);
        }
        if (i != j)
        {
          localajei.a(i, paramQQAppInterface);
          return;
        }
        localajei.a(false, false);
        return;
      }
    }
    catch (Exception paramQQAppInterface)
    {
      int i;
      ajei localajei;
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
          localajei.a(false, false);
          return;
          if (QLog.isColorLevel()) {
            QLog.d("babyqConfig", 2, "received BabyQPlusPanelConfig, content_list is empty, use default config");
          }
        }
      }
    }
  }
  
  private void ah(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SPLASH_ConfigServlet", 2, "handleRespAddContactsViewConfig|type= " + paramConfig.type.get());
    }
    int j = paramConfig.version.get();
    if (j == baig.R(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin())) {
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
          baig.c(paramQQAppInterface.getApp(), j, paramQQAppInterface.getCurrentAccountUin(), localConfig);
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
  
  private void ai(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    ConfigurationService.Config localConfig = null;
    if (QLog.isColorLevel()) {
      QLog.d("SPLASH_ConfigServlet", 2, "handleRespClassicHeadConfig|type= " + paramConfig.type.get());
    }
    int j = paramConfig.version.get();
    if (j == baig.S(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin())) {
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
      paramConfig = atiu.a(paramConfig.content.get().toByteArray());
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
              baig.d(paramQQAppInterface.getApp(), j, paramQQAppInterface.getCurrentAccountUin(), localConfig);
              paramQQAppInterface = (akhf)paramQQAppInterface.getManager(199);
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
  
  private void aj(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    try
    {
      i = paramConfig.version.get();
      j = baig.D(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount());
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
    baig.a(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount(), i, true, bool);
    return;
    if (i != j)
    {
      baig.a(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount(), i, false, true);
      paramQQAppInterface.a.jdField_a_of_type_Boolean = false;
    }
    if (QLog.isColorLevel())
    {
      QLog.d("HeadsUp", 2, "received Headsup Notify configVersion:" + i + " ,localVersion:" + j);
      return;
    }
  }
  
  private void ak(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    avis.jdField_a_of_type_JavaLangString = paramQQAppInterface.getCurrentAccountUin();
    int i = paramConfig.version.get();
    int j = avis.a(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin());
    if (QLog.isColorLevel()) {
      QLog.d("Q.uniteSearch.SearchNetEntryConfig", 2, "handleSearchNetEntryConfig, version: " + i + " localVersion: " + j);
    }
    if (i == j) {
      return;
    }
    avis.a(paramQQAppInterface.getApp(), i, paramQQAppInterface.getCurrentAccountUin());
    avis.a(paramQQAppInterface.getApp(), paramConfig, paramQQAppInterface.c());
  }
  
  private void al(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
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
              baig.u(paramQQAppInterface.getApp(), j, paramQQAppInterface.getCurrentAccountUin());
              baig.w(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin(), i);
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
  
  private void am(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    j = 0;
    int i = 0;
    k = 0;
    m = 0;
    Object localObject1 = null;
    Object localObject2 = null;
    int n = paramConfig.version.get();
    int i1 = baig.a(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, 2);
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
          baig.d(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, 3, k);
          if (paramQQAppInterface.a(250)) {
            ((MedalWallMng)paramQQAppInterface.getManager(250)).a(k);
          }
        }
        baig.d(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, 2, n);
        localObject1 = paramConfig;
        if (QLog.isColorLevel()) {
          QLog.i("SPLASH_ConfigServlet", 2, String.format(Locale.getDefault(), "handleMedalStrongReminderConfig localVersion: %s, version: %s, result: %s, value: %s, strContent: %s", new Object[] { Integer.valueOf(i1), Integer.valueOf(n), Integer.valueOf(j), Integer.valueOf(k), localObject1 }));
        }
        return;
        if (paramConfig.compress.get() != 1) {
          continue;
        }
        paramConfig = atiu.a(paramConfig.content.get().toByteArray());
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
  
  private void an(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
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
        int m = ((Integer)baig.a(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, 2)).intValue();
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
              baig.a(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, 3, localObject1);
              if (paramQQAppInterface.a(159)) {
                ((ajls)paramQQAppInterface.getManager(159)).a((String)localObject1);
              }
            }
            baig.a(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, 2, Integer.valueOf(k));
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
          paramConfig = atiu.a(paramConfig.content.get().toByteArray());
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
  
  private void ao(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
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
          localObject3 = atiu.a(((ConfigurationService.Content)localObject4).content.get().toByteArray());
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
        ahkg.a();
        ahkg.a((String)localObject1);
        baig.t(paramQQAppInterface.getApp(), paramConfig.version.get(), jdField_a_of_type_JavaLangString);
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
  
  private void ap(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
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
      paramConfig = atiu.a(paramConfig.content.get().toByteArray());
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
        ((ajqt)paramQQAppInterface.getManager(22)).a(paramConfig, j);
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
  
  private void aq(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    boolean bool2 = true;
    atdp localatdp = (atdp)paramQQAppInterface.getManager(228);
    int i = localatdp.a();
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
          paramQQAppInterface = atiu.a(paramConfig.content.get().toByteArray());
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
        localatdp.a(bool1, paramQQAppInterface);
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
  
  private void ar(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    int i = badd.a();
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
      paramConfig = atiu.a(paramConfig.content.get().toByteArray());
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
          badd.a().a(paramQQAppInterface.getApp(), paramConfig, j);
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
    badd.a().a(j);
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
        localObject2 = aknk.a((byte[])localObject1);
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
    aknw localaknw = (aknw)localQQAppInterface.getManager(168);
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
          paramIntent = aknk.a(paramIntent.content.get().toByteArray());
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
        if (localaknw != null) {
          localaknw.a(paramIntent);
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
      if (localaknw != null) {
        localaknw.b();
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
    paramIntent = ausk.a();
    int j = paramConfig.version.get();
    int i = baig.i(((QQAppInterface)getAppRuntime()).getApp());
    if (!ausk.a()) {
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
      baig.g(((QQAppInterface)getAppRuntime()).getApp(), j);
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
    String str = paramQQAppInterface.c();
    int j = aemi.a(paramQQAppInterface);
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
        aemi.a(paramQQAppInterface, paramConfig.getBoolean("useRecommendedSticker"));
        aemi.a(localBaseApplication, str, paramConfig.getInt("maxMatchLength"));
      }
      for (;;)
      {
        aemi.a(paramQQAppInterface, i);
        return;
        aemi.a(paramQQAppInterface, false);
      }
    }
    catch (Exception paramConfig)
    {
      for (;;)
      {
        aemi.a(paramQQAppInterface, false);
        if (QLog.isColorLevel()) {
          QLog.d("SPLASH_ConfigServlet", 2, paramConfig.getMessage());
        }
      }
    }
  }
  
  public static void b(QQAppInterface paramQQAppInterface, String paramString)
  {
    jdField_a_of_type_JavaLangString = paramString;
    NewIntent localNewIntent = new NewIntent(paramQQAppInterface.getApp(), amnh.class);
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
        baig.d(((QQAppInterface)getAppRuntime()).getCurrentAccountUin()).edit().putString("qav_anychat_time_value", paramString).commit();
        baig.j(getAppRuntime().getApplication(), paramInt, jdField_a_of_type_JavaLangString);
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
    aknw localaknw = (aknw)localQQAppInterface.getManager(168);
    if (localaknw == null)
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
      localaknw.a(i);
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
          paramIntent = aknk.a((byte[])localObject2);
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
      localaknw.b(j);
      localaknw.a(localNameNotFoundException);
      if (QLog.isColorLevel()) {
        QLog.d("ArConfig_configServlet", 2, "maxEndTimeArConfigInfo|| maxEndtime=" + localNameNotFoundException.aREnd);
      }
      OlympicServlet.a(localQQAppInterface, 87, j, 0, 0, 0, 0);
    }
    for (;;)
    {
      i = 0;
      label648:
      if ((i == 0) || (localaknw == null)) {
        break;
      }
      QLog.d("ArConfig_configServlet", 1, "arManager.downloadArResource");
      localaknw.a(true, false);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ArConfig_configServlet", 2, "handleResp_GetArResource|combineArConfigInfo is null");
      }
      OlympicServlet.a(localQQAppInterface, 87, j, 0, 0, 5, 0);
      continue;
      label707:
      localaknw.a();
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
    int j = baig.Q(BaseApplication.getContext(), jdField_a_of_type_JavaLangString);
    if (QLog.isColorLevel()) {
      QLog.i("SPLASH_ConfigServlet", 2, "handleRespNewBoatConfig: ,version: " + paramConfig.version.get() + "| localVersion: " + j);
    }
    if (i != j)
    {
      baig.s(BaseApplication.getContext(), i, jdField_a_of_type_JavaLangString);
      paramConfig = a(paramConfig);
      if ((paramConfig != null) && (paramConfig.size() > 0)) {
        ascd.a(paramQQAppInterface, (String)paramConfig.get(0));
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
          localObject5 = ((atmp)localObject3).a(ExpiredPushBanner.class);
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
      if (!alzj.a(paramString)) {
        ThreadManager.executeOnNetWorkThread(new ConfigServlet.4(this, (String)localObject1));
      }
      alzf.a.a(alzf.a.a(l1, (String)localObject2, (byte)3, (String)localObject1, (String)localObject4, (String)localObject5, l3 + "|" + l2, (short)k, paramString));
      paramInt = 1;
      k = 1;
    }
    for (;;)
    {
      try
      {
        localObject1 = ((atmp)localObject3).a(ReportedBanner.class, false, null, null, null, null, "endtime DESC", null);
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
                ((atmp)localObject3).b((atmo)localObject2);
                break label1064;
              }
            }
          }
        }
        if (j == 0) {
          break label1015;
        }
        awqx.b((QQAppInterface)getAppRuntime(), "dc00898", "", "", "0X80087C0", "0X80087C0", (int)l1, 0, "", "", "", "");
        localObject1 = new ReportedBanner();
        ((ReportedBanner)localObject1).cid = l1;
        ((ReportedBanner)localObject1).md5 = paramString;
        ((ReportedBanner)localObject1).endtime = l2;
        ((atmp)localObject3).a((atmo)localObject1);
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
    akiu localakiu = (akiu)((QQAppInterface)getAppRuntime()).getManager(220);
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
      arrayOfByte = atiu.a(paramIntent.content.get().toByteArray());
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
          if (localakiu.a(paramIntent))
          {
            localakiu.a(i);
            localakiu.a();
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
        if (localakiu != null) {
          localakiu.b();
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
    int j = baig.g(((QQAppInterface)getAppRuntime()).getApp());
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
        arrayOfByte = atiu.a(paramConfig.content.get().toByteArray());
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
          boolean bool = ayqn.a(paramConfig);
          if (bool) {
            baig.e(((QQAppInterface)getAppRuntime()).getApp(), i);
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
    //   0: invokestatic 909	javax/xml/parsers/DocumentBuilderFactory:newInstance	()Ljavax/xml/parsers/DocumentBuilderFactory;
    //   3: invokevirtual 913	javax/xml/parsers/DocumentBuilderFactory:newDocumentBuilder	()Ljavax/xml/parsers/DocumentBuilder;
    //   6: new 915	java/io/ByteArrayInputStream
    //   9: dup
    //   10: aload_1
    //   11: ldc_w 917
    //   14: invokevirtual 921	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   17: invokespecial 922	java/io/ByteArrayInputStream:<init>	([B)V
    //   20: invokevirtual 927	javax/xml/parsers/DocumentBuilder:parse	(Ljava/io/InputStream;)Lorg/w3c/dom/Document;
    //   23: astore 14
    //   25: aload 14
    //   27: ldc_w 4093
    //   30: invokeinterface 935 2 0
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
    //   59: ldc_w 4095
    //   62: astore_1
    //   63: ldc 13
    //   65: astore 13
    //   67: iconst_0
    //   68: istore 9
    //   70: iload 9
    //   72: aload 15
    //   74: invokeinterface 940 1 0
    //   79: if_icmpge +480 -> 559
    //   82: aload 14
    //   84: ldc_w 3371
    //   87: invokeinterface 935 2 0
    //   92: iload 9
    //   94: invokeinterface 946 2 0
    //   99: invokeinterface 952 1 0
    //   104: invokeinterface 955 1 0
    //   109: astore 13
    //   111: aload 14
    //   113: ldc_w 3377
    //   116: invokeinterface 935 2 0
    //   121: iload 9
    //   123: invokeinterface 946 2 0
    //   128: invokeinterface 952 1 0
    //   133: invokeinterface 955 1 0
    //   138: astore 12
    //   140: aload 14
    //   142: ldc_w 4096
    //   145: invokeinterface 935 2 0
    //   150: iload 9
    //   152: invokeinterface 946 2 0
    //   157: invokeinterface 952 1 0
    //   162: invokeinterface 955 1 0
    //   167: invokestatic 4102	java/lang/Float:parseFloat	(Ljava/lang/String;)F
    //   170: fstore 4
    //   172: aload 14
    //   174: ldc_w 4103
    //   177: invokeinterface 935 2 0
    //   182: iload 9
    //   184: invokeinterface 946 2 0
    //   189: invokeinterface 952 1 0
    //   194: invokeinterface 955 1 0
    //   199: invokestatic 4102	java/lang/Float:parseFloat	(Ljava/lang/String;)F
    //   202: fstore_3
    //   203: iconst_1
    //   204: istore 10
    //   206: aload 14
    //   208: ldc_w 4104
    //   211: invokeinterface 935 2 0
    //   216: iload 9
    //   218: invokeinterface 946 2 0
    //   223: invokeinterface 952 1 0
    //   228: invokeinterface 955 1 0
    //   233: invokestatic 4102	java/lang/Float:parseFloat	(Ljava/lang/String;)F
    //   236: fstore 5
    //   238: aload 14
    //   240: ldc_w 4105
    //   243: invokeinterface 935 2 0
    //   248: iload 9
    //   250: invokeinterface 946 2 0
    //   255: invokeinterface 952 1 0
    //   260: invokeinterface 955 1 0
    //   265: invokestatic 4102	java/lang/Float:parseFloat	(Ljava/lang/String;)F
    //   268: fstore 8
    //   270: aload 14
    //   272: ldc_w 4107
    //   275: invokeinterface 935 2 0
    //   280: iload 9
    //   282: invokeinterface 946 2 0
    //   287: invokeinterface 952 1 0
    //   292: invokeinterface 955 1 0
    //   297: astore 11
    //   299: aload 14
    //   301: ldc_w 4108
    //   304: invokeinterface 935 2 0
    //   309: iload 9
    //   311: invokeinterface 946 2 0
    //   316: invokeinterface 952 1 0
    //   321: invokeinterface 955 1 0
    //   326: invokestatic 4102	java/lang/Float:parseFloat	(Ljava/lang/String;)F
    //   329: fstore 7
    //   331: aload 14
    //   333: ldc_w 4104
    //   336: invokeinterface 935 2 0
    //   341: iload 9
    //   343: invokeinterface 946 2 0
    //   348: invokeinterface 952 1 0
    //   353: invokeinterface 955 1 0
    //   358: invokestatic 4102	java/lang/Float:parseFloat	(Ljava/lang/String;)F
    //   361: fstore 6
    //   363: aload 14
    //   365: ldc_w 4110
    //   368: invokeinterface 935 2 0
    //   373: iload 9
    //   375: invokeinterface 946 2 0
    //   380: invokeinterface 952 1 0
    //   385: invokeinterface 955 1 0
    //   390: astore_1
    //   391: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   394: ifeq +296 -> 690
    //   397: ldc 183
    //   399: iconst_2
    //   400: new 85	java/lang/StringBuilder
    //   403: dup
    //   404: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   407: ldc_w 4112
    //   410: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   413: aload 13
    //   415: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   418: ldc_w 4114
    //   421: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   424: aload 12
    //   426: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   429: ldc_w 4116
    //   432: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   435: fload 4
    //   437: invokevirtual 4119	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   440: ldc_w 4121
    //   443: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   446: fload_3
    //   447: invokevirtual 4119	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   450: ldc_w 4123
    //   453: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   456: iload 10
    //   458: invokevirtual 152	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   461: ldc_w 4125
    //   464: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   467: fload 5
    //   469: invokevirtual 4119	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   472: ldc_w 4127
    //   475: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   478: fload 8
    //   480: invokevirtual 4119	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   483: ldc_w 4129
    //   486: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   489: aload 11
    //   491: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   494: ldc_w 4131
    //   497: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   500: fload 7
    //   502: invokevirtual 4119	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   505: ldc_w 4133
    //   508: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   511: aload_1
    //   512: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   515: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   518: invokestatic 199	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   521: goto +169 -> 690
    //   524: astore_1
    //   525: aload 14
    //   527: ldc_w 4134
    //   530: invokeinterface 935 2 0
    //   535: iload 9
    //   537: invokeinterface 946 2 0
    //   542: invokeinterface 952 1 0
    //   547: invokeinterface 955 1 0
    //   552: invokestatic 4102	java/lang/Float:parseFloat	(Ljava/lang/String;)F
    //   555: fstore_3
    //   556: goto -350 -> 206
    //   559: aload 13
    //   561: ifnull +126 -> 687
    //   564: aload 13
    //   566: invokevirtual 600	java/lang/String:trim	()Ljava/lang/String;
    //   569: ldc 13
    //   571: invokevirtual 620	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   574: ifne +113 -> 687
    //   577: new 85	java/lang/StringBuilder
    //   580: dup
    //   581: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   584: aload_0
    //   585: invokevirtual 47	amnh:getAppRuntime	()Lmqq/app/AppRuntime;
    //   588: invokevirtual 2590	mqq/app/AppRuntime:getApplication	()Lmqq/app/MobileQQ;
    //   591: invokevirtual 2717	mqq/app/MobileQQ:getFilesDir	()Ljava/io/File;
    //   594: invokevirtual 2720	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   597: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   600: ldc_w 2750
    //   603: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   606: getstatic 15	amnh:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   609: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   612: ldc_w 2750
    //   615: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   618: ldc_w 2795
    //   621: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   624: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   627: astore 14
    //   629: ldc_w 4136
    //   632: aload 13
    //   634: invokestatic 4141	com/tencent/mobileqq/msf/sdk/MsfSdkUtils:insertMtype	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   637: astore 13
    //   639: fload_3
    //   640: fstore 7
    //   642: fload_3
    //   643: fconst_0
    //   644: fcmpg
    //   645: ifge +8 -> 653
    //   648: ldc_w 820
    //   651: fstore 7
    //   653: new 4143	com/tencent/mobileqq/config/splashlogo/ConfigServlet$5
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
    //   678: invokespecial 4146	com/tencent/mobileqq/config/splashlogo/ConfigServlet$5:<init>	(Lamnh;Ljava/lang/String;Ljava/lang/String;FFFLjava/lang/String;Ljava/lang/String;FZILjava/lang/String;)V
    //   681: iconst_2
    //   682: aconst_null
    //   683: iconst_0
    //   684: invokestatic 3300	com/tencent/mobileqq/app/ThreadManager:post	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
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
    //   710: ldc_w 4095
    //   713: astore_1
    //   714: goto -323 -> 391
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	717	0	this	amnh
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
      int j = baig.q(((QQAppInterface)getAppRuntime()).getApp(), paramIntent);
      if (QLog.isColorLevel()) {
        QLog.d("nearby_flower_operation_gray_tips", 2, "serverVersion=" + i + "|localVersion=" + j);
      }
      if (i != j)
      {
        baig.c(((QQAppInterface)getAppRuntime()).getApp(), paramIntent, i);
        ajnb localajnb = (ajnb)((QQAppInterface)getAppRuntime()).getManager(124);
        if ((!paramConfig.content_list.has()) || (paramConfig.content_list.get().size() <= 0)) {
          break label246;
        }
        localList = paramConfig.content_list.get();
        if ((localList != null) && (localList.size() > 0))
        {
          localajnb.a(paramIntent, (String)localList.get(0));
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
      asfl.a("GENERAL_LBS_CONFIGS_CMD", new Object[] { "getGeneralLBSConfigs", paramString, Long.valueOf(l) });
    }
    paramString = new NewIntent(paramQQAppInterface.getApp(), amnh.class);
    paramString.putExtra("k_cmd_type", new int[] { 87, 12, 174, 189 });
    paramQQAppInterface.startServlet(paramString);
  }
  
  private void e(ConfigurationService.Config paramConfig)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)getAppRuntime();
    int i = paramConfig.version.get();
    int j = baig.o(localQQAppInterface.getApp());
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
      baig.m(localQQAppInterface.getApp(), i, str);
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
          baig.a(getAppRuntime().getApplication(), paramInt, str2, paramString);
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
      int j = baig.r(((QQAppInterface)getAppRuntime()).getApp(), paramIntent);
      if (QLog.isColorLevel()) {
        QLog.d("HotChatManager", 2, "serverVersion=" + i + "|localVersion=" + j);
      }
      if (i != j)
      {
        baig.d(((QQAppInterface)getAppRuntime()).getApp(), paramIntent, i);
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
    paramString = (attv)paramQQAppInterface.getManager(179);
    if ((paramString != null) && (paramString.a() != null) && (paramString.a().d * 1000L <= 0L)) {}
    paramString = new NewIntent(paramQQAppInterface.getApp(), amnh.class);
    paramString.putExtra("k_cmd_type", new int[] { 113 });
    paramQQAppInterface.startServlet(paramString);
  }
  
  private void f(ConfigurationService.Config paramConfig)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)getAppRuntime();
    int i = paramConfig.version.get();
    int j = baig.p(localQQAppInterface.getApp());
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
      baig.n(localQQAppInterface.getApp(), i, str);
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
    int i = baig.h(((QQAppInterface)getAppRuntime()).getApp());
    if (!PtvTemplateManager.a()) {
      i = 0;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PtvTemplateManager", 2, "serverVersion=" + j + "|localVersion=" + i);
    }
    if (j != i)
    {
      baig.f(((QQAppInterface)getAppRuntime()).getApp(), j);
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
    int i = baig.k(((QQAppInterface)getAppRuntime()).getApp());
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
        baig.i(((QQAppInterface)getAppRuntime()).getApp(), k);
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
    localPtvTemplateManager.b();
  }
  
  private void h(Intent paramIntent, ConfigurationService.Config paramConfig)
  {
    paramIntent = PtvTemplateManager.a((QQAppInterface)getAppRuntime());
    int j = paramConfig.version.get();
    int i = baig.j(((QQAppInterface)getAppRuntime()).getApp());
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
        baig.h(((QQAppInterface)getAppRuntime()).getApp(), j);
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
    bjiq localbjiq = bjiq.a();
    int k = paramConfig.version.get();
    int i = baig.F(((QQAppInterface)getAppRuntime()).getApp());
    if (!localbjiq.a()) {
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
      } while (!localbjiq.a(paramConfig, (QQAppInterface)getAppRuntime()));
      baig.u(((QQAppInterface)getAppRuntime()).getApp(), k);
      return;
    } while (!QLog.isColorLevel());
    label195:
    QLog.d("QQSTORY_FOLLOW_CAPTURE_SPLASH_ConfigServlet", 2, "GetQQStoryFollowCaptureConfig|type: 合拍配置回包内容为空");
    return;
    label212:
    if (QLog.isColorLevel()) {
      QLog.d("QQSTORY_FOLLOW_CAPTURE_SPLASH_ConfigServlet", 2, "GetQQStoryFollowCaptureConfig|type: 合拍配置回包为空");
    }
    localbjiq.a();
  }
  
  private void i(Intent paramIntent, ConfigurationService.Config paramConfig)
  {
    NearbyGrayTipsManager localNearbyGrayTipsManager;
    String str2;
    if (!TextUtils.isEmpty(paramIntent.getStringExtra("key_uin")))
    {
      int i = paramConfig.version.get();
      int j = baig.f(((QQAppInterface)getAppRuntime()).getApp());
      if (QLog.isColorLevel()) {
        QLog.d("nearby_aio_operation_gray_tips", 2, "serverVersion=" + i + "|localVersion=" + j);
      }
      if (i != j)
      {
        baig.d(((QQAppInterface)getAppRuntime()).getApp(), i);
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
          } while (baip.a(str2));
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
        if (baip.a(str1)) {
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
    baig.h(getAppRuntime().getApplication(), i, jdField_a_of_type_JavaLangString);
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
    if (i == baig.o(((QQAppInterface)getAppRuntime()).getApp(), jdField_a_of_type_JavaLangString)) {}
    for (;;)
    {
      return;
      baig.k(((QQAppInterface)getAppRuntime()).getApp(), i, jdField_a_of_type_JavaLangString);
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
        localObject1 = paramIntent.a().a();
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
          paramIntent.a().a = paramConfig.charAt(0);
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
              paramIntent.a().c = Integer.valueOf(paramConfig).intValue();
              paramConfig = (String)localHashMap.get("mqq_open_myvideo");
              if (QLog.isColorLevel()) {
                QLog.i("Q.qqstory:IsOpenMyVideo", 2, "IsOpenMyVideo=" + paramConfig);
              }
              try
              {
                if (TextUtils.isEmpty(paramConfig)) {
                  break;
                }
                ((sga)paramIntent.getManager(181)).h(Boolean.parseBoolean(paramConfig));
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
              paramIntent.a().a((Integer[])localObject1);
              continue;
              paramConfig = paramConfig;
              QLog.w("Q.qqstory.fourTab:nowtabPlan", 2, "" + paramConfig.getMessage(), paramConfig);
              continue;
              localObject1[1] = Integer.valueOf(0);
              localObject1[2] = Integer.valueOf(k);
              paramIntent.a().a((Integer[])localObject1);
              if (QLog.isColorLevel())
              {
                QLog.i("Q.qqstory.fourTab:nowtabPlan", 2, "case 2 nowtabPlan=" + paramConfig);
                continue;
                localObject1[2] = Integer.valueOf(k);
                localObject1[1] = Integer.valueOf(1);
                paramIntent.a().a((Integer[])localObject1);
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
    ajof localajof = (ajof)localQQAppInterface.getManager(102);
    i = localajof.a();
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
        localajoe2 = new ajoe();
      }
      catch (Throwable localThrowable2)
      {
        ajoe localajoe2;
        XmlPullParser localXmlPullParser;
        int k;
        Object localObject3;
        ajoe localajoe1 = null;
        i = 0;
        paramConfig = null;
        localObject1 = null;
        continue;
        localajoe1 = null;
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
        localajoe1 = localajoe2;
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
            localajoe2.jdField_b_of_type_JavaLangString = localXmlPullParser.getAttributeValue(j);
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
          localajoe2.jdField_a_of_type_JavaLangString = localXmlPullParser.getAttributeValue(j);
          continue;
          QLog.e("PhoneContact.Manager", 1, "", localThrowable1);
        }
        catch (Throwable localThrowable1)
        {
          localajoe1 = localajoe2;
        }
      }
      catch (Throwable localThrowable3)
      {
        i = 0;
        paramConfig = null;
        localObject1 = null;
        localajoe1 = localajoe2;
        continue;
        continue;
        continue;
      }
      localObject5 = localObject1;
      localObject3 = paramConfig;
      j = i;
      localajof.a(m, localObject6, localajoe1);
      ((PhoneContactManagerImp)localQQAppInterface.getManager(11)).a(j, localObject5, (String)localObject3);
      return;
      if ("dayNum".equals(localObject3)) {
        localajoe2.jdField_a_of_type_Int = Integer.valueOf(localXmlPullParser.getAttributeValue(j)).intValue();
      } else if ("dayIntervalNum".equals(localObject3)) {
        localajoe2.jdField_b_of_type_Int = Integer.valueOf(localXmlPullParser.getAttributeValue(j)).intValue();
      } else if ("totalNum".equals(localObject3)) {
        localajoe2.c = Integer.valueOf(localXmlPullParser.getAttributeValue(j)).intValue();
      } else if ("loginNum".equals(localObject3)) {
        localajoe2.e = Integer.valueOf(localXmlPullParser.getAttributeValue(j)).intValue();
      } else if ("banner".equals(localObject3)) {
        localajoe2.jdField_a_of_type_Boolean = "1".equals(localXmlPullParser.getAttributeValue(j));
      } else if ("setEntry".equals(localObject3)) {
        localajoe2.jdField_b_of_type_Boolean = "1".equals(localXmlPullParser.getAttributeValue(j));
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
        localajoe1 = localajoe2;
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
    int j = baig.p(((QQAppInterface)getAppRuntime()).getApp(), jdField_a_of_type_JavaLangString);
    if (i == j) {}
    label179:
    label195:
    do
    {
      do
      {
        return;
        baig.l(((QQAppInterface)getAppRuntime()).getApp(), i, jdField_a_of_type_JavaLangString);
        for (;;)
        {
          try
          {
            if (paramConfig.msg_content_list != null)
            {
              i = paramConfig.msg_content_list.size();
              paramIntent = (aqnw)paramIntent.getManager(267);
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
            int k = baig.A(localQQAppInterface.getApp(), localQQAppInterface.getAccount());
            if (QLog.isColorLevel()) {
              QLog.d("SPLASH_ConfigServlet", 2, "received SUBSCRIPT_RECOMMEND_CMD remote version: " + j + " | localVersion: " + k);
            }
            if ((j != k) || (paramConfig.content_list.size() > 0))
            {
              if ((rsp.a((QQAppInterface)getAppRuntime(), str)) && (QLog.isColorLevel())) {
                QLog.d("SPLASH_ConfigServlet", 2, "received SUBSCRIPT_RECOMMEND_CMD save version: " + j);
              }
              baig.l(getAppRuntime().getApplication(), localQQAppInterface.getAccount(), j);
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
            localQQAppInterface.a((Integer[])localObject3);
          }
        }
        else
        {
          localObject3 = (String)localHashMap.get("subscribe_discovery");
          if (!TextUtils.isEmpty((CharSequence)localObject3))
          {
            rqc.d(localQQAppInterface, "1".equals(localObject3));
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
            localQQAppInterface.a((Integer[])localObject3);
          }
          localObject2 = (String)localHashMap.get("share_to_news");
          if (localObject2 != null) {
            bgmq.a((String)localObject2, localQQAppInterface);
          }
          localObject2 = (String)localHashMap.get("synchronize_to_qzone");
          if (localObject2 != null) {
            bgmq.b((String)localObject2, localQQAppInterface);
          }
          localObject2 = (String)localHashMap.get("merge_feeds");
          if (localObject2 != null) {
            bgmq.d((String)localObject2, localQQAppInterface);
          }
          localObject2 = (String)localHashMap.get("kandian_feeds");
          if (localObject2 != null) {
            bgmq.e((String)localObject2, localQQAppInterface);
          }
          i = paramConfig.version.get();
          baig.g(getAppRuntime().getApplication(), i, jdField_a_of_type_JavaLangString);
          if ((paramIntent != null) && (paramIntent.hasExtra("update101Version"))) {
            SettingCloneUtil.writeValueForInt(getAppRuntime().getApplication(), jdField_a_of_type_JavaLangString, null, "qqsetting_calltab_show_key_version", paramIntent.getIntExtra("update101Version", 0));
          }
          ArkAppCenter.a((String)localHashMap.get("arkapp_pa_nshow"));
          asfc.a(localQQAppInterface.getAccount(), "supportHotChatDemo", Boolean.valueOf("1".equals(localHashMap.get("hotchat_demo"))));
          paramIntent = (aucn)localQQAppInterface.getManager(89);
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
          localQQAppInterface.a().a.set(i);
          paramIntent = (String)localHashMap.get("camera_compatible_list");
          if (paramIntent == null) {}
        }
        catch (Exception paramIntent)
        {
          try
          {
            awii.a(paramIntent, true);
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
              paramConfig = localQQAppInterface.a();
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
                paramConfig = avvy.a();
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
              avwf.jdField_b_of_type_Int = Integer.valueOf(paramIntent).intValue();
              ahud.a((String)localHashMap.get("shortvideo_progressive_enable"));
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
              awqg.a("pic_thumb_400Enable", paramIntent);
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
              aqid.a();
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
      j = baig.E(localQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
      if (QLog.isColorLevel()) {
        QLog.d("SPLASH_ConfigServlet", 2, "received READINJOY_LOCAL_CHANNEL_CONFIG_CMD remote version: " + i + " | localVersion: " + j);
      }
      if (i != j)
      {
        baig.m(localQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, i);
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
    int i = baig.m(((QQAppInterface)getAppRuntime()).getApp());
    if (!PtvTemplateManager.d()) {
      i = 0;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PtvTemplateManager", 2, "GetBlessSpecialPendantConfig serverVersion=" + j + "|localVersion=" + i);
    }
    if (j != i)
    {
      baig.j(((QQAppInterface)getAppRuntime()).getApp(), j);
      if ((paramConfig.msg_content_list == null) || (paramConfig.msg_content_list.size() <= 0)) {
        break label269;
      }
      paramIntent = (ConfigurationService.Content)paramConfig.msg_content_list.get(0);
      if (paramIntent != null)
      {
        if (paramIntent.compress.get() != 1) {
          break label255;
        }
        paramIntent = atiu.a(paramIntent.content.get().toByteArray());
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
          localPtvTemplateManager.a(paramIntent, (QQAppInterface)getAppRuntime());
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
      int i = baig.s(((QQAppInterface)getAppRuntime()).getApp());
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
          ytc.a(BaseApplicationImpl.sApplication, paramConfig);
          i += 1;
          continue;
          if ((paramConfig.content_list != null) && (paramConfig.content_list.size() > 0)) {
            i = 0;
          }
          while (i < paramConfig.content_list.size())
          {
            localObject = (String)paramConfig.content_list.get(i);
            QLog.d("PatchLogTag", 1, "handlePatchConfigCmd content_list index=" + i + ", content=" + (String)localObject);
            ytc.a(BaseApplicationImpl.sApplication, (String)localObject);
            i += 1;
            continue;
            QLog.d("PatchLogTag", 1, "handlePatchConfigCmd msg_content_list and content_list are empty");
          }
        }
        PatchSharedPreUtil.updatePatchConfigVersion(BaseApplicationImpl.sApplication, j);
        PatchReporter.reportPatchEvent(BaseApplicationImpl.sApplication, localQQAppInterface.c(), "actPatchConfig", 100, "");
      }
      for (;;)
      {
        ysv.a(localQQAppInterface);
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
      PatchReporter.reportPatchEvent(BaseApplicationImpl.sApplication, localQQAppInterface.c(), "actPatchConfig", 102, "");
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
      j = baig.w(localQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
      if (QLog.isColorLevel()) {
        QLog.d("SPLASH_ConfigServlet", 2, "received SEARCH_CONFIG_CMD remote version: " + i + " | localVersion: " + j);
      }
      if (i != j)
      {
        baig.i(localQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, i);
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
      j = baig.t(localQQAppInterface.getApp());
      if (QLog.isColorLevel()) {
        QLog.d("SPLASH_ConfigServlet", 2, "received CAMERA_COMPATIBLE_LIST_CONFIG remote version: " + i + " | localVersion: " + j);
      }
      if (i != j)
      {
        baig.m(localQQAppInterface.getApp(), i);
        if (QLog.isColorLevel()) {
          QLog.d("SPLASH_ConfigServlet", 2, "received CAMERA_COMPATIBLE_LIST_CONFIG save version: " + i);
        }
        awii.a(str, true);
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
      if (i != baig.v(localQQAppInterface.getApp()))
      {
        baig.n(localQQAppInterface.getApp(), i);
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
    int j = baig.aq(paramQQAppInterface.getApp().getBaseContext(), jdField_a_of_type_JavaLangString);
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
          arrayOfByte = atiu.a(((ConfigurationService.Content)localObject1).content.get().toByteArray());
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
      baig.v(paramQQAppInterface.getApp().getBaseContext(), k, jdField_a_of_type_JavaLangString);
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
            localObject = atub.a((ConfigurationService.Content)localObject);
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
      atub.a(localQQAppInterface.getApp(), paramConfig.version.get(), jdField_a_of_type_JavaLangString);
      paramConfig = (attv)localQQAppInterface.getManager(179);
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
    int j = baig.B(localQQAppInterface.getApp(), localQQAppInterface.getAccount());
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
        agjk.a(localQQAppInterface, i, str);
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
    paramConfig = (agjk)localQQAppInterface.getManager(125);
    paramConfig.jdField_b_of_type_Boolean = true;
    paramConfig.c = MessageForFoldMsgGrayTips.PASSWD_REDBAG_MSG_SWITCH_DEFAULT;
    paramConfig.jdField_a_of_type_Int = MessageForFoldMsgGrayTips.PASSWD_REDBAG_MSG_DISPLAY_NUM_DEFAULT;
    paramConfig.d = MessageForFoldMsgGrayTips.PASSWD_REDBAG_MSG_SWITCH_INDEX;
    paramConfig.e = MessageForFoldMsgGrayTips.PASSWD_REDBAG_MSG_INDEX_WITH_ID;
    baig.a(localQQAppInterface.getApp(), localQQAppInterface.getAccount(), i, paramConfig.c, paramConfig.jdField_a_of_type_Int, paramConfig.d, paramConfig.e);
  }
  
  public static void w(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    int i = paramConfig.version.get();
    int j = baig.as(BaseApplication.getContext(), jdField_a_of_type_JavaLangString);
    if (QLog.isColorLevel()) {
      QLog.i("SPLASH_ConfigServlet", 2, "handleReceiptConfig: ,version: " + paramConfig.version.get() + "| localVersion: " + j);
    }
    if (i != j)
    {
      baig.P(BaseApplication.getContext(), jdField_a_of_type_JavaLangString, i);
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
              baig.e(BaseApplication.getContext(), jdField_a_of_type_JavaLangString, "receipt_kReceiptMsgEnable", i);
            }
            if (((JSONObject)localObject).has("kReceiptMsgMaxSendTimes"))
            {
              i = ((JSONObject)localObject).getInt("kReceiptMsgMaxSendTimes");
              baig.e(BaseApplication.getContext(), jdField_a_of_type_JavaLangString, "receipt_kReceiptMsgSendTimes", i);
            }
          }
          catch (JSONException localJSONException)
          {
            localJSONException.printStackTrace();
          }
        }
        acim.a(paramQQAppInterface);
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
      localObject = (ajls)((QQAppInterface)localObject).getManager(159);
      if (paramConfig.content_list.size() < 0)
      {
        str = (String)paramConfig.content_list.get(0);
        i = paramConfig.version.get();
        j = ((ajls)localObject).b();
        if (QLog.isColorLevel()) {
          QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 74,content: " + str + ",version: " + paramConfig.version.get());
        }
        if ((i != j) || (paramConfig.content_list.size() > 0)) {
          ((ajls)localObject).a(i, str);
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
    //   1: invokevirtual 47	amnh:getAppRuntime	()Lmqq/app/AppRuntime;
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
    //   28: invokestatic 1605	baig:at	(Landroid/content/Context;Ljava/lang/String;)I
    //   31: istore_2
    //   32: aload 71
    //   34: invokevirtual 65	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   37: aload 71
    //   39: invokevirtual 69	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   42: invokestatic 1608	baig:au	(Landroid/content/Context;Ljava/lang/String;)I
    //   45: istore_3
    //   46: invokestatic 203	com/tencent/common/config/AppSetting:a	()I
    //   49: istore 4
    //   51: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   54: ifeq +49 -> 103
    //   57: ldc 183
    //   59: iconst_2
    //   60: ldc_w 4895
    //   63: iconst_4
    //   64: anewarray 301	java/lang/Object
    //   67: dup
    //   68: iconst_0
    //   69: iload 34
    //   71: invokestatic 305	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   74: aastore
    //   75: dup
    //   76: iconst_1
    //   77: iload_2
    //   78: invokestatic 305	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   81: aastore
    //   82: dup
    //   83: iconst_2
    //   84: iload_3
    //   85: invokestatic 305	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   88: aastore
    //   89: dup
    //   90: iconst_3
    //   91: iload 4
    //   93: invokestatic 305	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   96: aastore
    //   97: invokestatic 309	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   100: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   103: iload_3
    //   104: iload 4
    //   106: if_icmpeq +20 -> 126
    //   109: aload 71
    //   111: invokevirtual 65	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   114: aload 71
    //   116: invokevirtual 69	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   119: iload 4
    //   121: invokestatic 4897	baig:Q	(Landroid/content/Context;Ljava/lang/String;I)V
    //   124: iconst_0
    //   125: istore_2
    //   126: iload 34
    //   128: iload_2
    //   129: if_icmpeq +3257 -> 3386
    //   132: aload_1
    //   133: iload_2
    //   134: sipush 228
    //   137: invokestatic 2272	amnh:b	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;II)Ljava/lang/String;
    //   140: astore 72
    //   142: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   145: ifeq +12 -> 157
    //   148: ldc_w 4899
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
    //   377: invokestatic 909	javax/xml/parsers/DocumentBuilderFactory:newInstance	()Ljavax/xml/parsers/DocumentBuilderFactory;
    //   380: invokevirtual 913	javax/xml/parsers/DocumentBuilderFactory:newDocumentBuilder	()Ljavax/xml/parsers/DocumentBuilder;
    //   383: new 915	java/io/ByteArrayInputStream
    //   386: dup
    //   387: aload 72
    //   389: ldc_w 917
    //   392: invokevirtual 921	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   395: invokespecial 922	java/io/ByteArrayInputStream:<init>	([B)V
    //   398: invokevirtual 927	javax/xml/parsers/DocumentBuilder:parse	(Ljava/io/InputStream;)Lorg/w3c/dom/Document;
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
    //   523: ldc_w 4901
    //   526: invokeinterface 935 2 0
    //   531: iconst_0
    //   532: invokeinterface 946 2 0
    //   537: invokeinterface 952 1 0
    //   542: invokeinterface 955 1 0
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
    //   669: ldc_w 4903
    //   672: invokeinterface 935 2 0
    //   677: iconst_0
    //   678: invokeinterface 946 2 0
    //   683: invokeinterface 952 1 0
    //   688: invokeinterface 955 1 0
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
    //   815: ldc_w 4905
    //   818: invokeinterface 935 2 0
    //   823: iconst_0
    //   824: invokeinterface 946 2 0
    //   829: invokeinterface 952 1 0
    //   834: invokeinterface 955 1 0
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
    //   961: ldc_w 4907
    //   964: invokeinterface 935 2 0
    //   969: iconst_0
    //   970: invokeinterface 946 2 0
    //   975: invokeinterface 952 1 0
    //   980: invokeinterface 955 1 0
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
    //   1102: ldc_w 4909
    //   1105: invokeinterface 935 2 0
    //   1110: iconst_0
    //   1111: invokeinterface 946 2 0
    //   1116: invokeinterface 952 1 0
    //   1121: invokeinterface 955 1 0
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
    //   1244: ldc_w 4911
    //   1247: invokeinterface 935 2 0
    //   1252: iconst_0
    //   1253: invokeinterface 946 2 0
    //   1258: invokeinterface 952 1 0
    //   1263: invokeinterface 955 1 0
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
    //   1398: ldc_w 4913
    //   1401: invokeinterface 935 2 0
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
    //   1549: invokeinterface 940 1 0
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
    //   1686: invokeinterface 946 2 0
    //   1691: invokeinterface 952 1 0
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
    //   1835: invokeinterface 955 1 0
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
    //   2863: invokestatic 4363	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   2866: invokevirtual 1823	java/lang/Integer:intValue	()I
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
    //   2992: invokestatic 4363	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   2995: invokevirtual 1823	java/lang/Integer:intValue	()I
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
    //   3116: invokestatic 4363	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   3119: invokevirtual 1823	java/lang/Integer:intValue	()I
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
    //   3292: invokestatic 4918	adzs:a	()Ladzs;
    //   3295: aload 71
    //   3297: invokevirtual 4921	adzs:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)Ljava/lang/String;
    //   3300: astore 39
    //   3302: invokestatic 4918	adzs:a	()Ladzs;
    //   3305: aload 71
    //   3307: invokevirtual 4923	adzs:c	(Lcom/tencent/mobileqq/app/QQAppInterface;)Ljava/lang/String;
    //   3310: astore 40
    //   3312: iconst_0
    //   3313: istore 35
    //   3315: aload 39
    //   3317: aload_1
    //   3318: invokevirtual 620	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3321: ifeq +13 -> 3334
    //   3324: aload 40
    //   3326: aload 38
    //   3328: invokevirtual 620	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3331: ifne +6 -> 3337
    //   3334: iconst_1
    //   3335: istore 35
    //   3337: invokestatic 4918	adzs:a	()Ladzs;
    //   3340: iload_3
    //   3341: iload 4
    //   3343: aload_1
    //   3344: aload 36
    //   3346: aload 38
    //   3348: aload 37
    //   3350: iload 35
    //   3352: iload 5
    //   3354: invokevirtual 4926	adzs:a	(IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZI)V
    //   3357: aload 71
    //   3359: invokevirtual 65	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   3362: aload 71
    //   3364: invokevirtual 411	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   3367: iload 34
    //   3369: iload_3
    //   3370: iload 4
    //   3372: aload_1
    //   3373: aload 38
    //   3375: aload 36
    //   3377: aload 37
    //   3379: iload 35
    //   3381: iload 5
    //   3383: invokestatic 4929	baig:a	(Landroid/content/Context;Ljava/lang/String;IIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZI)V
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
    //   3411: ldc_w 4899
    //   3414: iconst_2
    //   3415: aload 39
    //   3417: iconst_0
    //   3418: anewarray 301	java/lang/Object
    //   3421: invokestatic 376	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
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
    //   3460: ldc_w 4899
    //   3463: iconst_2
    //   3464: aload_1
    //   3465: iconst_0
    //   3466: anewarray 301	java/lang/Object
    //   3469: invokestatic 376	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
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
    //   3509: ldc_w 4899
    //   3512: iconst_2
    //   3513: aload_1
    //   3514: iconst_0
    //   3515: anewarray 301	java/lang/Object
    //   3518: invokestatic 376	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
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
    //   3558: ldc_w 4899
    //   3561: iconst_2
    //   3562: aload_1
    //   3563: iconst_0
    //   3564: anewarray 301	java/lang/Object
    //   3567: invokestatic 376	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
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
    //   3607: ldc_w 4899
    //   3610: iconst_2
    //   3611: aload_1
    //   3612: iconst_0
    //   3613: anewarray 301	java/lang/Object
    //   3616: invokestatic 376	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
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
    //   3656: ldc_w 4899
    //   3659: iconst_2
    //   3660: aload_1
    //   3661: iconst_0
    //   3662: anewarray 301	java/lang/Object
    //   3665: invokestatic 376	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
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
    //   3710: ldc_w 4931
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
    //   0	3805	0	this	amnh
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
    int i = baig.av(localQQAppInterface.getApp(), localQQAppInterface.getAccount());
    int j = baig.aw(localQQAppInterface.getApp(), localQQAppInterface.getAccount());
    int k = AppSetting.a();
    if (QLog.isColorLevel()) {
      QLog.d("SPLASH_ConfigServlet", 2, String.format("received TimUserSpecial remote version: %d, localVersion: %d ,originalAppId:%d, currentAppId:%d", new Object[] { Integer.valueOf(n), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) }));
    }
    if (j != k)
    {
      baig.R(localQQAppInterface.getApp(), localQQAppInterface.getAccount(), k);
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
          paramConfig = aemp.a().a(localQQAppInterface);
          localObject = aemp.a().b(localQQAppInterface);
          bool = false;
          if ((!paramConfig.equals(localConfig)) || (!((String)localObject).equals(str))) {
            break label490;
          }
          aemp.a().a(0, m, localConfig, "", str, "", bool, 0);
          baig.b(localQQAppInterface.getApp(), localQQAppInterface.getCurrentAccountUin(), n, 0, m, localConfig, str, "", "", bool, 0);
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
    int i = baig.C(localQQAppInterface.getApp(), localQQAppInterface.getAccount());
    int j = baig.y(localQQAppInterface.getApp(), localQQAppInterface.getAccount());
    int k = AppSetting.a();
    if (QLog.isColorLevel()) {
      QLog.d("pokeMsg", 2, String.format("handlePokeMsgConfig.received PokeMsgConfig remote version: %d, localVersion: %d ,originalAppId:%d, currentAppId:%d", new Object[] { Integer.valueOf(i58), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) }));
    }
    if (j != k)
    {
      baig.j(localQQAppInterface.getApp(), localQQAppInterface.getAccount(), k);
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
            localObject5 = adll.a(localQQAppInterface, 5);
            localObject9 = adll.a(localQQAppInterface, 6);
            if ((localObject4 == null) || (!((String)localObject4).equals(localObject5)) || (localObject3 == null) || (!((String)localObject3).equals(localObject9)))
            {
              adll.jdField_b_of_type_Boolean = false;
              adll.c = false;
              baig.a(false);
              adll.a(localQQAppInterface, (String)localObject4, (String)localObject3, adll.d);
            }
            baig.a(localQQAppInterface.getApp(), localQQAppInterface.getAccount(), k, (String)localObject4, (String)localObject3, (String)localObject1, (String)localObject7, j, m, n, i1);
            adll.a(localQQAppInterface, k, (String)localObject4, (String)localObject3, (String)localObject1, (String)localObject7, j, n, i1);
            adll.b(m);
          }
          if ((i10 != 0) && (i23 != 0) && (i8 != 0) && (i7 != 0) && (i6 != 0))
          {
            localQQAppInterface.getApp().getSharedPreferences(localQQAppInterface.getCurrentAccountUin(), 0).edit().putBoolean("chat_tool_poke_clicked", false).commit();
            adll.b(localQQAppInterface, false);
            adll.a(localQQAppInterface, false);
            adll.a(i19, i25, i14, i13);
            baig.a(localQQAppInterface.getApp(), localQQAppInterface.getAccount(), i58, true, i19, i25, i14, i13);
            adll.a((String)localObject2);
            baig.b(localQQAppInterface.getApp(), localQQAppInterface.getAccount(), i58, (String)localObject2);
            adll.a(i3);
            baig.a(localQQAppInterface.getApp(), localQQAppInterface.getAccount(), i58, i3);
            adll.c(i2);
            baig.b(localQQAppInterface.getApp(), localQQAppInterface.getAccount(), i58, i2);
            adll.a(i35, i4);
            baig.a(localQQAppInterface.getApp(), localQQAppInterface.getAccount(), i58, i35, i4);
          }
          if ((i5 != 0) && (i36 != 0) && (i36 != 0))
          {
            localObject1 = PreferenceManager.getDefaultSharedPreferences(localQQAppInterface.getApp()).getString(localQQAppInterface.getAccount() + "_" + "aio_poke_res_url", "");
            baig.a(localQQAppInterface.getApp(), localQQAppInterface.getAccount(), i58, l2, (String)localObject13, (String)localObject17);
            if ((localObject13 != null) && (!((String)localObject13).equals(localObject1))) {
              ((PokeBigResHandler)localQQAppInterface.a(117)).a(true);
            }
          }
          adll.c(i2);
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
          localObject9 = adll.a(localObject19[1]);
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
          i16 = adll.c(localObject19[1]);
        }
        try
        {
          i17 = adll.b(localObject19[1]);
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
          i19 = adll.a(localObject19[1]);
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
          i15 = adll.d(localObject19[1]);
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
      i8 = adll.h;
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
      i9 = adll.i;
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
        if (azkf.a().a(paramConfig)) {
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
      ((acjd)paramQQAppInterface.getManager(218)).d();
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
    paramQQAppInterface = (acjd)paramQQAppInterface.getManager(218);
    paramQQAppInterface.a(paramConfig);
    paramQQAppInterface.c();
  }
  
  public void D(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    int i = paramConfig.version.get();
    if (i != awkj.a(paramQQAppInterface.getApp()))
    {
      paramConfig = a(paramConfig);
      if ((paramConfig != null) && (paramConfig.size() > 0)) {
        awkj.a((String)paramConfig.get(0), i, paramQQAppInterface.getApp());
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
      paramConfig = paramQQAppInterface.getApp().getSharedPreferences("call_tim_config_pre" + paramQQAppInterface.c(), 0).edit();
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
      i = baig.a(paramQQAppInterface.getApp(), "sport_config", jdField_a_of_type_JavaLangString);
      j = paramConfig.version.get();
    } while (i == j);
    ((basg)paramQQAppInterface.getManager(260)).a(paramConfig);
    baig.a(paramQQAppInterface.getApp(), "sport_config", jdField_a_of_type_JavaLangString, j);
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
        str = a(paramConfig, baig.a(paramQQAppInterface.getApp(), "troop_gift_anim_limit", "0"), 281);
      } while (TextUtils.isEmpty(str));
      if (QLog.isColorLevel()) {
        QLog.d("SPLASH_ConfigServlet", 2, "handleTroopGiftLimitConfig content: " + str);
      }
      int i = paramConfig.version.get();
      baig.a(paramQQAppInterface.getApp(), "troop_gift_anim_limit", "0", i);
      try
      {
        i = new JSONObject(str).getInt("limitGiftAnimCount");
        azfo.jdField_b_of_type_Int = i;
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
      xfs.c();
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
      i = baig.a(paramQQAppInterface.getApp(), "task_entry_config_version", jdField_a_of_type_JavaLangString);
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
          baig.a(paramQQAppInterface.getApp(), "task_entry_config_version", jdField_a_of_type_JavaLangString, j);
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
    if (i != bjef.a().a(paramQQAppInterface.getApp()))
    {
      paramConfig = a(paramConfig);
      if ((paramConfig != null) && (paramConfig.size() > 0))
      {
        paramConfig = (String)paramConfig.get(paramConfig.size() - 1);
        bjef.a().a(paramConfig, i, paramQQAppInterface.getApp());
      }
    }
  }
  
  public void L(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    int i = paramConfig.version.get();
    if (i != bjim.a().a(paramQQAppInterface.getApp()))
    {
      paramConfig = a(paramConfig);
      if ((paramConfig != null) && (paramConfig.size() > 0))
      {
        paramConfig = (String)paramConfig.get(0);
        bjim.a().a(paramConfig, i, paramQQAppInterface.getApp());
      }
    }
  }
  
  public void M(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    int i = paramConfig.version.get();
    int j = baig.a(paramQQAppInterface.getApp(), "buluo_enter_config_version", jdField_a_of_type_JavaLangString);
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
                paramConfig = paramConfig + baaw.encodeToString(((String)localObject2).getBytes(), 0);
                baig.c(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin(), paramConfig);
                if (QLog.isColorLevel()) {
                  QLog.e("SPLASH_ConfigServlet", 2, new Object[] { "handleBuluoEnterConfig. buluoEntryUrl: ", paramConfig });
                }
              }
            }
          }
          for (;;)
          {
            baig.a(paramQQAppInterface.getApp(), "buluo_enter_config_version", jdField_a_of_type_JavaLangString, i);
            return;
            if (paramConfig.has("tribe_summary_url"))
            {
              paramConfig = paramConfig.optJSONObject("tribe_summary_url");
              if (paramConfig.has("android"))
              {
                paramConfig = paramConfig.optString("android");
                baig.d(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin(), paramConfig);
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
    akiu localakiu = (akiu)((QQAppInterface)getAppRuntime()).getManager(220);
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
      arrayOfByte = atiu.a(paramIntent.content.get().toByteArray());
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
          if (localakiu.b(paramIntent)) {
            localakiu.b(i);
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
        if (localakiu != null) {
          localakiu.c();
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
                paramConfig = atiu.a(paramIntent.content.get().toByteArray());
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
      arrayOfByte = atiu.a(paramIntent.content.get().toByteArray());
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
        akoa.a(paramQQAppInterface, paramIntent, paramConfig.version.get());
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
      akoa.b(paramQQAppInterface);
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
          byte[] arrayOfByte = atiu.a(((ConfigurationService.Content)localObject1).content.get().toByteArray());
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
            if ((i == baig.a(paramQQAppInterface.getApp(), "nearby_glamour_level_config_version", jdField_a_of_type_JavaLangString)) || (TextUtils.isEmpty((CharSequence)localObject1))) {
              continue;
            }
            asdj.a((String)localObject1);
            asdj.b((String)localObject1);
            baig.h(paramQQAppInterface.getApp(), (String)localObject1);
            baig.a(paramQQAppInterface.getApp(), "nearby_glamour_level_config_version", jdField_a_of_type_JavaLangString, i);
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
  
  protected void a(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig, String paramString, amnk paramamnk)
  {
    int j = paramConfig.version.get();
    int i = paramamnk.a();
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
          arrayOfByte = atiu.a(paramQQAppInterface.content.get().toByteArray());
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
      paramamnk.a(j);
      paramamnk.a(localArrayList);
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
            if ((j != baig.L(localQQAppInterface.getApp(), localQQAppInterface.getCurrentAccountUin())) || (paramConfig.content_list.size() > 0))
            {
              str = str.split("=")[1];
              if (!TextUtils.isEmpty(str)) {
                bgmq.c(str, localQQAppInterface);
              }
              baig.o(localQQAppInterface.getApp(), j, localQQAppInterface.getCurrentAccountUin());
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
          alrg.a(BaseApplicationImpl.getContext(), k);
          if (QLog.isColorLevel()) {
            QLog.d("Q.camera.configServlet", 2, "[handleRespQCameraPhoneConfig] save version: " + k + " and check config version: " + alrg.a(BaseApplicationImpl.getContext()));
          }
          if ((paramConfig.msg_content_list == null) || (paramConfig.msg_content_list.size() <= 0)) {
            break label560;
          }
          paramIntent = (ConfigurationService.Content)paramConfig.msg_content_list.get(0);
          i = paramIntent.task_id.get();
          if (paramIntent.compress.get() != 1) {
            break label506;
          }
          paramIntent = alrg.a(paramIntent.content.get().toByteArray());
          if (paramIntent == null)
          {
            paramInt = 4;
            alrg.a(BaseApplicationImpl.getContext(), true);
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
          awrn.a(BaseApplication.getContext()).a(str, "qcamera_phone_config_pull_event", paramBoolean, 0L, 0L, paramIntent, String.valueOf(j));
          return;
          paramInt = 0;
          paramIntent = new String(paramIntent);
          if (QLog.isColorLevel()) {
            QLog.d("Q.camera.configServlet", 4, "[handleRespQCameraPhoneConfig] zip");
          }
          try
          {
            alrg.a(BaseApplicationImpl.getContext(), paramIntent, k);
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
          alrg.a(BaseApplicationImpl.getContext(), paramIntent, k);
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
      QLog.w("Q.camera.configServlet", 1, "[handleRespQCameraPhoneConfig] no data, current disableCameraSDK=" + alrg.a(BaseApplicationImpl.getContext()));
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
        avhs localavhs = (avhs)paramQQAppInterface.getManager(222);
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
                byte[] arrayOfByte = atiu.a(((ConfigurationService.Content)localObject1).content.get().toByteArray());
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
                  if ((j == baig.a(paramQQAppInterface.getApp(), "search_function_config_version", jdField_a_of_type_JavaLangString)) || (TextUtils.isEmpty((CharSequence)localObject1))) {
                    continue;
                  }
                  localavhs.b(new JSONObject((String)localObject1).optString("kFTSFunctionListUrlKey"));
                  baig.a(paramQQAppInterface.getApp(), "search_function_config_version", jdField_a_of_type_JavaLangString, j);
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
            if ((j != baig.K(localQQAppInterface.getApp(), localQQAppInterface.c())) || (paramConfig.content_list.size() > 0))
            {
              if (bgmq.a(localQQAppInterface, str))
              {
                if (QLog.isColorLevel()) {
                  QLog.d("SPLASH_ConfigServlet", 2, "received 72 ark config");
                }
                baig.s(getAppRuntime().getApplication(), localQQAppInterface.c(), j);
                break label304;
              }
              if ((!rsp.b((QQAppInterface)getAppRuntime(), str)) || (!QLog.isColorLevel())) {
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
            if ((j != baig.x(localQQAppInterface.getApp())) || (paramConfig.content_list.size() > 0))
            {
              Object localObject2 = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new ByteArrayInputStream(((String)localObject1).getBytes("utf-8")));
              localObject1 = (Element)((Document)localObject2).getElementsByTagName("kandian_setting").item(0);
              localObject2 = (Element)((Document)localObject2).getElementsByTagName("url").item(0);
              localObject1 = ((Element)localObject1).getFirstChild().getNodeValue();
              localObject2 = ((Element)localObject2).getFirstChild().getNodeValue();
              if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!TextUtils.isEmpty((CharSequence)localObject2))) {
                baig.b(localQQAppInterface.getApp(), (String)localObject2, "1".equals(localObject1));
              }
              baig.o(localQQAppInterface.getApp(), j);
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
            byte[] arrayOfByte = atiu.a(((ConfigurationService.Content)localObject1).content.get().toByteArray());
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
              ascd.a(paramQQAppInterface, (String)localObject1, paramConfig.version.get());
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
      int i = baig.a(paramQQAppInterface.getApp(), "shop_tab", jdField_a_of_type_JavaLangString);
      int j = paramConfig.version.get();
      if ((i != j) && (paramConfig.content_list != null) && (paramConfig.content_list.size() > 0)) {
        try
        {
          paramConfig = new JSONObject((String)paramConfig.content_list.get(0));
          boolean bool = paramConfig.getBoolean("android");
          baig.a(paramQQAppInterface.getApp(), "shop_tab", jdField_a_of_type_JavaLangString, j);
          paramQQAppInterface = (nfp)paramQQAppInterface.getManager(88);
          paramQQAppInterface.b(bool);
          paramQQAppInterface.c = paramConfig.optBoolean("preload_web_process", false);
          paramQQAppInterface.a = paramConfig.optLong("stay_time", 5000L);
          paramQQAppInterface.d = paramConfig.optInt("day_limit", 3);
          nfp.a().edit().putBoolean("preload_web", paramQQAppInterface.c).putLong("stayTime", paramQQAppInterface.a).putInt("dayLimit", paramQQAppInterface.d).commit();
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
    int i = baig.X(paramQQAppInterface.getApp(), paramQQAppInterface.c());
    int j = paramConfig.version.get();
    if (i == j)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SPLASH_ConfigServlet", 2, "handleQuickShotShareToStoryConfig version code not changed .");
      }
      return;
    }
    baig.x(paramQQAppInterface.getApp(), paramQQAppInterface.c(), j);
    if ((paramConfig.msg_content_list == null) || (paramConfig.msg_content_list.size() < 1) || (paramConfig.msg_content_list.get(0) == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SPLASH_ConfigServlet", 2, "handleQuickShotShareToStoryConfig data is null!!!");
      }
      baig.h(paramQQAppInterface.getApp(), paramQQAppInterface.c(), null);
      return;
    }
    paramConfig = (ConfigurationService.Content)paramConfig.msg_content_list.get(0);
    byte[] arrayOfByte;
    if (paramConfig.compress.get() == 1)
    {
      arrayOfByte = atiu.a(paramConfig.content.get().toByteArray());
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
        baig.h(paramQQAppInterface.getApp(), paramQQAppInterface.c(), paramConfig);
        ((sga)paramQQAppInterface.getManager(181)).a(paramConfig);
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
      baig.h(paramQQAppInterface.getApp(), paramQQAppInterface.c(), null);
    }
  }
  
  void g(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    int i = baig.ab(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
    int j = paramConfig.version.get();
    if ((i != j) && (paramConfig.msg_content_list != null) && (paramConfig.msg_content_list.size() > 0))
    {
      paramConfig = (ConfigurationService.Content)paramConfig.msg_content_list.get(0);
      if (paramConfig != null)
      {
        if (paramConfig.compress.get() != 1) {
          break label219;
        }
        paramConfig = atiu.a(paramConfig.content.get().toByteArray());
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
          baig.l(paramQQAppInterface.getApp(), "wifiAutoPreDown", "" + bool1);
          baig.l(paramQQAppInterface.getApp(), "noSafeDown", "" + bool2);
          baig.B(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, j);
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
    int i = baig.Z(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
    int j = paramConfig.version.get();
    if ((i != j) && (paramConfig.msg_content_list != null) && (paramConfig.msg_content_list.size() > 0))
    {
      paramConfig = (ConfigurationService.Content)paramConfig.msg_content_list.get(0);
      if (paramConfig != null)
      {
        if (paramConfig.compress.get() != 1) {
          break label206;
        }
        paramConfig = atiu.a(paramConfig.content.get().toByteArray());
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
          baig.k(paramQQAppInterface.getApp(), "url", paramConfig);
          baig.k(paramQQAppInterface.getApp(), "thxWord", (String)localObject);
          baig.k(paramQQAppInterface.getApp(), "wantWord", str);
          baig.A(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, j);
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
        i = baig.ac(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
        j = paramConfig.version.get();
      } while ((i == j) || (paramConfig.msg_content_list == null) || (paramConfig.msg_content_list.size() <= 0));
      paramConfig = (ConfigurationService.Content)paramConfig.msg_content_list.get(0);
    } while (paramConfig == null);
    if (paramConfig.compress.get() == 1)
    {
      paramConfig = atiu.a(paramConfig.content.get().toByteArray());
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
          baig.C(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, j);
          baig.d(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, bool);
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
          int k = rsp.c(paramQQAppInterface);
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
                  localObject = atiu.a(((ConfigurationService.Content)localObject).content.get().toByteArray());
                  if (localObject == null) {
                    break label310;
                  }
                  try
                  {
                    localObject = new String((byte[])localObject, "UTF-8");
                    if (QLog.isColorLevel()) {
                      QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 184, version:" + paramConfig.version.get() + ", content:" + (String)localObject);
                    }
                    rsp.a(paramQQAppInterface, (String)localObject, j);
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
    //   1: getfield 2567	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:type	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   4: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   7: sipush 191
    //   10: if_icmpeq +4 -> 14
    //   13: return
    //   14: aload_1
    //   15: invokevirtual 65	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   18: getstatic 15	amnh:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   21: invokestatic 1941	baig:ap	(Landroid/content/Context;Ljava/lang/String;)I
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
    //   56: ldc_w 5599
    //   59: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: iload 4
    //   64: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   67: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   70: invokestatic 199	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   73: aload_2
    //   74: getfield 221	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   77: ifnull -64 -> 13
    //   80: aload_2
    //   81: getfield 221	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   84: invokevirtual 224	com/tencent/mobileqq/pb/PBRepeatMessageField:size	()I
    //   87: ifle -74 -> 13
    //   90: aload_2
    //   91: getfield 221	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   94: iconst_0
    //   95: invokevirtual 318	com/tencent/mobileqq/pb/PBRepeatMessageField:get	(I)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   98: checkcast 244	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content
    //   101: astore_2
    //   102: aload_2
    //   103: ifnull -90 -> 13
    //   106: aload_2
    //   107: getfield 248	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content:compress	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   110: invokevirtual 251	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   113: iconst_1
    //   114: if_icmpne +349 -> 463
    //   117: aload_2
    //   118: getfield 255	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content:content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   121: invokevirtual 260	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   124: invokevirtual 266	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   127: invokestatic 321	atiu:a	([B)[B
    //   130: astore_2
    //   131: aload_2
    //   132: ifnull +442 -> 574
    //   135: new 118	java/lang/String
    //   138: dup
    //   139: aload_2
    //   140: ldc_w 323
    //   143: invokespecial 326	java/lang/String:<init>	([BLjava/lang/String;)V
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
    //   167: ldc_w 5601
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
    //   200: invokevirtual 5602	org/json/JSONObject:length	()I
    //   203: ifle -190 -> 13
    //   206: new 1121	java/util/ArrayList
    //   209: dup
    //   210: invokespecial 1122	java/util/ArrayList:<init>	()V
    //   213: astore_2
    //   214: aload 5
    //   216: invokevirtual 5605	org/json/JSONObject:keys	()Ljava/util/Iterator;
    //   219: astore 6
    //   221: aload 6
    //   223: invokeinterface 238 1 0
    //   228: ifeq +310 -> 538
    //   231: aload 6
    //   233: invokeinterface 242 1 0
    //   238: checkcast 118	java/lang/String
    //   241: astore 7
    //   243: aload 5
    //   245: aload 7
    //   247: invokevirtual 732	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   250: astore 8
    //   252: new 5132	com/tencent/mobileqq/data/AppGuideTipsConfig
    //   255: dup
    //   256: invokespecial 5133	com/tencent/mobileqq/data/AppGuideTipsConfig:<init>	()V
    //   259: astore 9
    //   261: aload 9
    //   263: aload 7
    //   265: putfield 5608	com/tencent/mobileqq/data/AppGuideTipsConfig:tipsType	Ljava/lang/String;
    //   268: aload 9
    //   270: aload 8
    //   272: ldc_w 5141
    //   275: invokevirtual 420	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   278: putfield 5144	com/tencent/mobileqq/data/AppGuideTipsConfig:switchKey	Ljava/lang/String;
    //   281: aload 9
    //   283: aload 8
    //   285: ldc_w 5146
    //   288: invokevirtual 420	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   291: invokestatic 4363	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   294: invokevirtual 1823	java/lang/Integer:intValue	()I
    //   297: putfield 5149	com/tencent/mobileqq/data/AppGuideTipsConfig:maxCount	I
    //   300: aload 9
    //   302: aload 8
    //   304: ldc_w 5151
    //   307: invokevirtual 420	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   310: invokestatic 5070	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   313: invokevirtual 5073	java/lang/Long:longValue	()J
    //   316: putfield 5153	com/tencent/mobileqq/data/AppGuideTipsConfig:duration	J
    //   319: aload 9
    //   321: aload 8
    //   323: ldc_w 779
    //   326: invokevirtual 420	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   329: putfield 5158	com/tencent/mobileqq/data/AppGuideTipsConfig:tipsUrl	Ljava/lang/String;
    //   332: aload 9
    //   334: aload 8
    //   336: ldc_w 5610
    //   339: invokevirtual 420	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   342: putfield 5612	com/tencent/mobileqq/data/AppGuideTipsConfig:opkey	Ljava/lang/String;
    //   345: aload 9
    //   347: aload 8
    //   349: ldc_w 5163
    //   352: invokevirtual 420	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   355: putfield 5166	com/tencent/mobileqq/data/AppGuideTipsConfig:msgTypeStr	Ljava/lang/String;
    //   358: ldc_w 622
    //   361: aload 7
    //   363: invokevirtual 620	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   366: ifeq +143 -> 509
    //   369: aload 8
    //   371: ldc_w 1021
    //   374: invokevirtual 405	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   377: ifeq +100 -> 477
    //   380: aload 9
    //   382: aload 8
    //   384: ldc_w 1021
    //   387: invokevirtual 420	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   390: putfield 5161	com/tencent/mobileqq/data/AppGuideTipsConfig:tipsMsg	Ljava/lang/String;
    //   393: aload 8
    //   395: ldc_w 734
    //   398: invokevirtual 405	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   401: ifeq +92 -> 493
    //   404: aload 9
    //   406: aload 8
    //   408: ldc_w 734
    //   411: invokevirtual 420	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   414: putfield 5615	com/tencent/mobileqq/data/AppGuideTipsConfig:tipsHighLight	Ljava/lang/String;
    //   417: aload_2
    //   418: aload 9
    //   420: invokeinterface 1131 2 0
    //   425: pop
    //   426: goto -205 -> 221
    //   429: astore_1
    //   430: ldc 183
    //   432: iconst_1
    //   433: new 85	java/lang/StringBuilder
    //   436: dup
    //   437: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   440: ldc_w 5617
    //   443: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   446: aload_1
    //   447: invokevirtual 798	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   450: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   453: invokestatic 642	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   456: return
    //   457: astore_2
    //   458: aconst_null
    //   459: astore_2
    //   460: goto -313 -> 147
    //   463: aload_2
    //   464: getfield 255	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content:content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   467: invokevirtual 260	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   470: invokevirtual 280	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   473: astore_2
    //   474: goto -327 -> 147
    //   477: aload 9
    //   479: aload 8
    //   481: ldc_w 5619
    //   484: invokevirtual 420	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   487: putfield 5161	com/tencent/mobileqq/data/AppGuideTipsConfig:tipsMsg	Ljava/lang/String;
    //   490: goto -97 -> 393
    //   493: aload 9
    //   495: aload 8
    //   497: ldc_w 5621
    //   500: invokevirtual 420	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   503: putfield 5615	com/tencent/mobileqq/data/AppGuideTipsConfig:tipsHighLight	Ljava/lang/String;
    //   506: goto -89 -> 417
    //   509: aload 9
    //   511: aload 8
    //   513: ldc_w 5619
    //   516: invokevirtual 420	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   519: putfield 5161	com/tencent/mobileqq/data/AppGuideTipsConfig:tipsMsg	Ljava/lang/String;
    //   522: aload 9
    //   524: aload 8
    //   526: ldc_w 5621
    //   529: invokevirtual 420	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   532: putfield 5615	com/tencent/mobileqq/data/AppGuideTipsConfig:tipsHighLight	Ljava/lang/String;
    //   535: goto -118 -> 417
    //   538: aload_1
    //   539: sipush 218
    //   542: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   545: checkcast 3320	acjd
    //   548: astore 5
    //   550: aload 5
    //   552: aload_2
    //   553: invokevirtual 5622	acjd:a	(Ljava/util/List;)V
    //   556: aload 5
    //   558: invokevirtual 3321	acjd:a	()V
    //   561: aload_1
    //   562: invokevirtual 65	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   565: getstatic 15	amnh:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   568: iload 4
    //   570: invokestatic 5624	baig:N	(Landroid/content/Context;Ljava/lang/String;I)V
    //   573: return
    //   574: aconst_null
    //   575: astore_2
    //   576: goto -429 -> 147
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	579	0	this	amnh
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
    int i = baig.aa(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
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
        paramConfig = atiu.a(paramConfig.content.get().toByteArray());
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
        baig.z(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, j);
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
          i = baig.ah(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
          j = paramConfig.version.get();
          if (QLog.isColorLevel()) {
            QLog.d("DoutuSPLASH_ConfigServlet", 2, "handleDoutuConfig reqVersion = " + i + ", version=" + j);
          }
        } while (i == j);
        baig.I(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, j);
      } while ((paramConfig.msg_content_list == null) || (paramConfig.msg_content_list.size() <= 0));
      paramConfig = (ConfigurationService.Content)paramConfig.msg_content_list.get(0);
    } while (paramConfig == null);
    if (paramConfig.compress.get() == 1)
    {
      paramConfig = atiu.a(paramConfig.content.get().toByteArray());
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
            baig.f((Context)localObject, str2, bool1);
            baig.b(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, l1);
            baig.M(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, j);
            localObject = paramQQAppInterface.getApp();
            str2 = jdField_a_of_type_JavaLangString;
            if (k != 1) {
              break label1224;
            }
            bool1 = true;
            baig.h((Context)localObject, str2, bool1);
            localObject = paramQQAppInterface.getApp();
            str2 = jdField_a_of_type_JavaLangString;
            if (m != 1) {
              break label1230;
            }
            bool1 = true;
            baig.i((Context)localObject, str2, bool1);
            if (paramConfig != null) {
              baig.n(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, paramConfig);
            }
            if (str1 != null) {
              baig.o(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, str1);
            }
            baig.c(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, l2);
            baig.d(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, l3);
            baig.K(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, n);
            paramQQAppInterface = (amxv)getAppRuntime().getManager(214);
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
        baig.k(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
        baig.r(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
        baig.l(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
        baig.m(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
        baig.o(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
        baig.p(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
        baig.t(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
        baig.u(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
        baig.n(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
        baig.m(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
        baig.s(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
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
          i = baig.t(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
          j = paramConfig.version.get();
          if (QLog.isColorLevel()) {
            QLog.d("GreenVideoSPLASH_ConfigServlet", 2, "handleGreenVideoConfig reqVersion = " + i + ", version=" + j);
          }
        } while (i == j);
        baig.f(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, j);
      } while ((paramConfig.msg_content_list == null) || (paramConfig.msg_content_list.size() <= 0));
      paramConfig = (ConfigurationService.Content)paramConfig.msg_content_list.get(0);
    } while (paramConfig == null);
    if (paramConfig.compress.get() == 1)
    {
      paramConfig = atiu.a(paramConfig.content.get().toByteArray());
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
        baig.e(paramQQAppInterface.getApp(), paramConfig);
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
      baig.a(paramQQAppInterface.getApp());
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
    //   1: getfield 2567	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:type	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   4: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   7: sipush 272
    //   10: if_icmpeq +4 -> 14
    //   13: return
    //   14: aload_1
    //   15: invokevirtual 65	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   18: getstatic 15	amnh:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   21: invokestatic 1908	baig:v	(Landroid/content/Context;Ljava/lang/String;)I
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
    //   50: ldc_w 5754
    //   53: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: iload_3
    //   57: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   60: ldc_w 5658
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
    //   87: getstatic 15	amnh:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   90: iload 4
    //   92: invokestatic 1897	baig:h	(Landroid/content/Context;Ljava/lang/String;I)V
    //   95: aload_2
    //   96: getfield 221	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   99: ifnull -86 -> 13
    //   102: aload_2
    //   103: getfield 221	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   106: invokevirtual 224	com/tencent/mobileqq/pb/PBRepeatMessageField:size	()I
    //   109: ifle -96 -> 13
    //   112: aload_2
    //   113: getfield 221	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   116: iconst_0
    //   117: invokevirtual 318	com/tencent/mobileqq/pb/PBRepeatMessageField:get	(I)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   120: checkcast 244	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content
    //   123: astore_2
    //   124: aload_2
    //   125: ifnull -112 -> 13
    //   128: aload_2
    //   129: getfield 248	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content:compress	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   132: invokevirtual 251	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   135: iconst_1
    //   136: if_icmpne +716 -> 852
    //   139: aload_2
    //   140: getfield 255	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content:content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   143: invokevirtual 260	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   146: invokevirtual 266	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   149: invokestatic 321	atiu:a	([B)[B
    //   152: astore_2
    //   153: aload_2
    //   154: ifnull +782 -> 936
    //   157: new 118	java/lang/String
    //   160: dup
    //   161: aload_2
    //   162: ldc_w 323
    //   165: invokespecial 326	java/lang/String:<init>	([BLjava/lang/String;)V
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
    //   189: ldc_w 5756
    //   192: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   195: aload_2
    //   196: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   199: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   202: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   205: invokestatic 909	javax/xml/parsers/DocumentBuilderFactory:newInstance	()Ljavax/xml/parsers/DocumentBuilderFactory;
    //   208: invokevirtual 913	javax/xml/parsers/DocumentBuilderFactory:newDocumentBuilder	()Ljavax/xml/parsers/DocumentBuilder;
    //   211: new 915	java/io/ByteArrayInputStream
    //   214: dup
    //   215: aload_2
    //   216: ldc_w 917
    //   219: invokevirtual 921	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   222: invokespecial 922	java/io/ByteArrayInputStream:<init>	([B)V
    //   225: invokevirtual 927	javax/xml/parsers/DocumentBuilder:parse	(Ljava/io/InputStream;)Lorg/w3c/dom/Document;
    //   228: astore_2
    //   229: aload_2
    //   230: ldc_w 5758
    //   233: invokeinterface 935 2 0
    //   238: astore 5
    //   240: aload 5
    //   242: ifnull -229 -> 13
    //   245: aload 5
    //   247: invokeinterface 940 1 0
    //   252: ifle -239 -> 13
    //   255: new 85	java/lang/StringBuilder
    //   258: dup
    //   259: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   262: astore 5
    //   264: aload_2
    //   265: ldc_w 5760
    //   268: invokeinterface 935 2 0
    //   273: ifnull +42 -> 315
    //   276: aload 5
    //   278: aload_2
    //   279: ldc_w 5760
    //   282: invokeinterface 935 2 0
    //   287: iconst_0
    //   288: invokeinterface 946 2 0
    //   293: invokeinterface 952 1 0
    //   298: invokeinterface 955 1 0
    //   303: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   306: pop
    //   307: aload 5
    //   309: bipush 124
    //   311: invokevirtual 1053	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   314: pop
    //   315: aload_2
    //   316: ldc_w 5762
    //   319: invokeinterface 935 2 0
    //   324: ifnull +42 -> 366
    //   327: aload 5
    //   329: aload_2
    //   330: ldc_w 5762
    //   333: invokeinterface 935 2 0
    //   338: iconst_0
    //   339: invokeinterface 946 2 0
    //   344: invokeinterface 952 1 0
    //   349: invokeinterface 955 1 0
    //   354: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   357: pop
    //   358: aload 5
    //   360: bipush 124
    //   362: invokevirtual 1053	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   365: pop
    //   366: aload_2
    //   367: ldc_w 5764
    //   370: invokeinterface 935 2 0
    //   375: ifnull +42 -> 417
    //   378: aload 5
    //   380: aload_2
    //   381: ldc_w 5764
    //   384: invokeinterface 935 2 0
    //   389: iconst_0
    //   390: invokeinterface 946 2 0
    //   395: invokeinterface 952 1 0
    //   400: invokeinterface 955 1 0
    //   405: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   408: pop
    //   409: aload 5
    //   411: bipush 124
    //   413: invokevirtual 1053	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   416: pop
    //   417: aload_2
    //   418: ldc_w 5766
    //   421: invokeinterface 935 2 0
    //   426: ifnull +42 -> 468
    //   429: aload 5
    //   431: aload_2
    //   432: ldc_w 5766
    //   435: invokeinterface 935 2 0
    //   440: iconst_0
    //   441: invokeinterface 946 2 0
    //   446: invokeinterface 952 1 0
    //   451: invokeinterface 955 1 0
    //   456: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   459: pop
    //   460: aload 5
    //   462: bipush 124
    //   464: invokevirtual 1053	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   467: pop
    //   468: aload_2
    //   469: ldc_w 5768
    //   472: invokeinterface 935 2 0
    //   477: ifnull +42 -> 519
    //   480: aload 5
    //   482: aload_2
    //   483: ldc_w 5768
    //   486: invokeinterface 935 2 0
    //   491: iconst_0
    //   492: invokeinterface 946 2 0
    //   497: invokeinterface 952 1 0
    //   502: invokeinterface 955 1 0
    //   507: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   510: pop
    //   511: aload 5
    //   513: bipush 124
    //   515: invokevirtual 1053	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   518: pop
    //   519: aload_2
    //   520: ldc_w 5770
    //   523: invokeinterface 935 2 0
    //   528: ifnull +60 -> 588
    //   531: aload_2
    //   532: ldc_w 5770
    //   535: invokeinterface 935 2 0
    //   540: iconst_0
    //   541: invokeinterface 946 2 0
    //   546: ifnull +42 -> 588
    //   549: aload 5
    //   551: aload_2
    //   552: ldc_w 5770
    //   555: invokeinterface 935 2 0
    //   560: iconst_0
    //   561: invokeinterface 946 2 0
    //   566: invokeinterface 952 1 0
    //   571: invokeinterface 955 1 0
    //   576: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   579: pop
    //   580: aload 5
    //   582: bipush 124
    //   584: invokevirtual 1053	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   587: pop
    //   588: aload_2
    //   589: ldc_w 5772
    //   592: invokeinterface 935 2 0
    //   597: ifnull +60 -> 657
    //   600: aload_2
    //   601: ldc_w 5772
    //   604: invokeinterface 935 2 0
    //   609: iconst_0
    //   610: invokeinterface 946 2 0
    //   615: ifnull +42 -> 657
    //   618: aload 5
    //   620: aload_2
    //   621: ldc_w 5772
    //   624: invokeinterface 935 2 0
    //   629: iconst_0
    //   630: invokeinterface 946 2 0
    //   635: invokeinterface 952 1 0
    //   640: invokeinterface 955 1 0
    //   645: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   648: pop
    //   649: aload 5
    //   651: bipush 124
    //   653: invokevirtual 1053	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   656: pop
    //   657: aload_2
    //   658: ldc_w 5774
    //   661: invokeinterface 935 2 0
    //   666: ifnull +60 -> 726
    //   669: aload_2
    //   670: ldc_w 5774
    //   673: invokeinterface 935 2 0
    //   678: iconst_0
    //   679: invokeinterface 946 2 0
    //   684: ifnull +42 -> 726
    //   687: aload 5
    //   689: aload_2
    //   690: ldc_w 5774
    //   693: invokeinterface 935 2 0
    //   698: iconst_0
    //   699: invokeinterface 946 2 0
    //   704: invokeinterface 952 1 0
    //   709: invokeinterface 955 1 0
    //   714: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   717: pop
    //   718: aload 5
    //   720: bipush 124
    //   722: invokevirtual 1053	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   725: pop
    //   726: aload_2
    //   727: ldc_w 5776
    //   730: invokeinterface 935 2 0
    //   735: ifnull +52 -> 787
    //   738: aload_2
    //   739: ldc_w 5776
    //   742: invokeinterface 935 2 0
    //   747: iconst_0
    //   748: invokeinterface 946 2 0
    //   753: ifnull +34 -> 787
    //   756: aload 5
    //   758: aload_2
    //   759: ldc_w 5776
    //   762: invokeinterface 935 2 0
    //   767: iconst_0
    //   768: invokeinterface 946 2 0
    //   773: invokeinterface 952 1 0
    //   778: invokeinterface 955 1 0
    //   783: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   786: pop
    //   787: aload_1
    //   788: invokevirtual 65	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   791: getstatic 15	amnh:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   794: aload 5
    //   796: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   799: invokestatic 5778	baig:p	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    //   802: return
    //   803: astore_1
    //   804: ldc 183
    //   806: iconst_1
    //   807: new 85	java/lang/StringBuilder
    //   810: dup
    //   811: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   814: ldc_w 5780
    //   817: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   820: aload_1
    //   821: invokevirtual 798	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   824: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   827: invokestatic 642	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   830: return
    //   831: astore_2
    //   832: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   835: ifeq +12 -> 847
    //   838: ldc 183
    //   840: iconst_2
    //   841: ldc_w 5782
    //   844: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   847: aconst_null
    //   848: astore_2
    //   849: goto -680 -> 169
    //   852: aload_2
    //   853: getfield 255	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content:content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   856: invokevirtual 260	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   859: invokevirtual 280	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   862: astore_2
    //   863: goto -694 -> 169
    //   866: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   869: ifeq +12 -> 881
    //   872: ldc 183
    //   874: iconst_2
    //   875: ldc_w 5784
    //   878: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   881: aload_1
    //   882: invokevirtual 65	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   885: getstatic 15	amnh:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   888: invokestatic 5786	baig:q	(Landroid/content/Context;Ljava/lang/String;)V
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
    //   0	941	0	this	amnh
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
        amnl.a("0", arrayOfInt, paramFromServiceMsg.getResultCode());
        besq.a(arrayOfInt, paramFromServiceMsg);
        int k = arrayOfInt.length;
        i = j;
        while (i < k)
        {
          if (arrayOfInt[i] == 215)
          {
            ShortVideoResourceManager.a(-5);
            bhcs.b("SPLASH_ConfigServlet", 1, "【SHORT_VIDEO_RESOURCE_CONFIG】RES_OVERTIME");
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
            yte.a(((ConfigurationService.RespGetConfig)localObject).min_req_interval_for_reconnect.get());
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
    //   1: invokestatic 1927	axaf:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)I
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
    //   30: ldc_w 5852
    //   33: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: iload 4
    //   38: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   41: ldc_w 5854
    //   44: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: iload_3
    //   48: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   51: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   54: invokestatic 199	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   57: iload 4
    //   59: iload_3
    //   60: if_icmpeq +157 -> 217
    //   63: aload_1
    //   64: bipush 17
    //   66: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   69: checkcast 1926	axaf
    //   72: astore 5
    //   74: aload_2
    //   75: getfield 221	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   78: ifnull +216 -> 294
    //   81: aload_2
    //   82: getfield 221	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   85: invokevirtual 224	com/tencent/mobileqq/pb/PBRepeatMessageField:size	()I
    //   88: ifle +206 -> 294
    //   91: aload_2
    //   92: getfield 221	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   95: iconst_0
    //   96: invokevirtual 318	com/tencent/mobileqq/pb/PBRepeatMessageField:get	(I)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   99: checkcast 244	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content
    //   102: astore_2
    //   103: aload_2
    //   104: ifnull +108 -> 212
    //   107: aload_2
    //   108: getfield 248	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content:compress	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   111: invokevirtual 251	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   114: iconst_1
    //   115: if_icmpne +135 -> 250
    //   118: aload_2
    //   119: getfield 255	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content:content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   122: invokevirtual 260	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   125: invokevirtual 266	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   128: invokestatic 321	atiu:a	([B)[B
    //   131: astore_2
    //   132: aload_2
    //   133: ifnull +179 -> 312
    //   136: new 118	java/lang/String
    //   139: dup
    //   140: aload_2
    //   141: ldc_w 323
    //   144: invokespecial 326	java/lang/String:<init>	([BLjava/lang/String;)V
    //   147: astore_2
    //   148: aload_2
    //   149: ifnull +63 -> 212
    //   152: new 128	org/json/JSONObject
    //   155: dup
    //   156: aload_2
    //   157: invokespecial 131	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   160: ldc_w 5856
    //   163: invokevirtual 408	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   166: istore 4
    //   168: aload 5
    //   170: iload 4
    //   172: invokevirtual 5857	axaf:a	(I)V
    //   175: ldc 183
    //   177: iconst_1
    //   178: new 85	java/lang/StringBuilder
    //   181: dup
    //   182: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   185: ldc_w 5859
    //   188: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   191: aload_2
    //   192: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   195: ldc_w 5861
    //   198: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   201: iload 4
    //   203: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   206: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   209: invokestatic 199	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   212: aload_1
    //   213: iload_3
    //   214: invokestatic 5862	axaf:a	(Lcom/tencent/mobileqq/app/QQAppInterface;I)V
    //   217: return
    //   218: astore_2
    //   219: ldc 183
    //   221: iconst_1
    //   222: new 85	java/lang/StringBuilder
    //   225: dup
    //   226: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   229: ldc_w 5864
    //   232: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   235: aload_2
    //   236: invokevirtual 798	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   239: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   242: invokestatic 642	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   245: aconst_null
    //   246: astore_2
    //   247: goto -99 -> 148
    //   250: aload_2
    //   251: getfield 255	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content:content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   254: invokevirtual 260	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   257: invokevirtual 280	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   260: astore_2
    //   261: goto -113 -> 148
    //   264: astore_2
    //   265: ldc 183
    //   267: iconst_1
    //   268: new 85	java/lang/StringBuilder
    //   271: dup
    //   272: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   275: ldc_w 5866
    //   278: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   281: aload_2
    //   282: invokevirtual 798	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   285: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   288: invokestatic 642	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   291: goto -79 -> 212
    //   294: ldc 183
    //   296: iconst_1
    //   297: ldc_w 5868
    //   300: invokestatic 199	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   303: aload 5
    //   305: iconst_0
    //   306: invokevirtual 5857	axaf:a	(I)V
    //   309: goto -97 -> 212
    //   312: aconst_null
    //   313: astore_2
    //   314: goto -166 -> 148
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	317	0	this	amnh
    //   0	317	1	paramQQAppInterface	QQAppInterface
    //   0	317	2	paramConfig	ConfigurationService.Config
    //   13	201	3	i	int
    //   4	198	4	j	int
    //   72	232	5	localaxaf	axaf
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
    //   3: getstatic 15	amnh:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   6: ldc_w 1917
    //   9: iconst_0
    //   10: invokestatic 305	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   13: invokestatic 1915	asfc:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   16: checkcast 139	java/lang/Integer
    //   19: invokevirtual 1823	java/lang/Integer:intValue	()I
    //   22: istore 5
    //   24: aload_2
    //   25: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   28: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   31: istore 6
    //   33: new 85	java/lang/StringBuilder
    //   36: dup
    //   37: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   40: ldc_w 5870
    //   43: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: iload 5
    //   48: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   51: ldc_w 5854
    //   54: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: iload 6
    //   59: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   62: ldc_w 5872
    //   65: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: astore 7
    //   70: aload_2
    //   71: getfield 221	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   74: ifnonnull +109 -> 183
    //   77: iconst_0
    //   78: istore_3
    //   79: ldc_w 5874
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
    //   103: getfield 221	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   106: ifnull +614 -> 720
    //   109: aload_2
    //   110: getfield 221	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   113: invokevirtual 224	com/tencent/mobileqq/pb/PBRepeatMessageField:size	()I
    //   116: ifle +604 -> 720
    //   119: iload 4
    //   121: istore_3
    //   122: iload_3
    //   123: aload_2
    //   124: getfield 221	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   127: invokevirtual 224	com/tencent/mobileqq/pb/PBRepeatMessageField:size	()I
    //   130: if_icmpge +64 -> 194
    //   133: ldc_w 5874
    //   136: iconst_1
    //   137: new 85	java/lang/StringBuilder
    //   140: dup
    //   141: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   144: ldc_w 5876
    //   147: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: aload_2
    //   151: getfield 221	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   154: iload_3
    //   155: invokevirtual 318	com/tencent/mobileqq/pb/PBRepeatMessageField:get	(I)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   158: checkcast 244	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content
    //   161: getfield 3827	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content:task_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   164: invokevirtual 251	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   167: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   170: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   173: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   176: iload_3
    //   177: iconst_1
    //   178: iadd
    //   179: istore_3
    //   180: goto -58 -> 122
    //   183: aload_2
    //   184: getfield 221	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   187: invokevirtual 224	com/tencent/mobileqq/pb/PBRepeatMessageField:size	()I
    //   190: istore_3
    //   191: goto -112 -> 79
    //   194: aload_2
    //   195: getfield 221	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   198: iconst_0
    //   199: invokevirtual 318	com/tencent/mobileqq/pb/PBRepeatMessageField:get	(I)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   202: checkcast 244	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content
    //   205: astore 7
    //   207: aload 7
    //   209: ifnull +511 -> 720
    //   212: aload 7
    //   214: getfield 248	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content:compress	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   217: invokevirtual 251	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   220: iconst_1
    //   221: if_icmpne +536 -> 757
    //   224: aload 7
    //   226: getfield 255	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content:content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   229: invokevirtual 260	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   232: invokevirtual 266	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   235: invokestatic 321	atiu:a	([B)[B
    //   238: astore 7
    //   240: aload 7
    //   242: ifnull +588 -> 830
    //   245: new 118	java/lang/String
    //   248: dup
    //   249: aload 7
    //   251: ldc_w 323
    //   254: invokespecial 326	java/lang/String:<init>	([BLjava/lang/String;)V
    //   257: astore 7
    //   259: aload 7
    //   261: ifnull +459 -> 720
    //   264: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   267: ifeq +31 -> 298
    //   270: ldc_w 5874
    //   273: iconst_1
    //   274: new 85	java/lang/StringBuilder
    //   277: dup
    //   278: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   281: ldc_w 5878
    //   284: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   287: aload 7
    //   289: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   292: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   295: invokestatic 199	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   298: new 128	org/json/JSONObject
    //   301: dup
    //   302: aload 7
    //   304: invokespecial 131	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   307: astore 7
    //   309: aload 7
    //   311: ldc_w 5880
    //   314: invokevirtual 5883	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   317: astore 8
    //   319: aload 8
    //   321: invokevirtual 520	org/json/JSONArray:length	()I
    //   324: ifle +18 -> 342
    //   327: getstatic 15	amnh:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   330: ldc_w 5885
    //   333: aload 8
    //   335: invokevirtual 5886	org/json/JSONArray:toString	()Ljava/lang/String;
    //   338: invokestatic 1920	asfc:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)Z
    //   341: pop
    //   342: aload 7
    //   344: ldc_w 5888
    //   347: invokevirtual 732	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   350: astore 8
    //   352: aload 8
    //   354: ifnull +18 -> 372
    //   357: getstatic 15	amnh:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   360: ldc_w 5890
    //   363: aload 8
    //   365: invokevirtual 5891	org/json/JSONObject:toString	()Ljava/lang/String;
    //   368: invokestatic 1920	asfc:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)Z
    //   371: pop
    //   372: aload 7
    //   374: ldc_w 5893
    //   377: invokevirtual 474	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   380: istore_3
    //   381: aload 8
    //   383: ifnull +17 -> 400
    //   386: getstatic 15	amnh:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   389: ldc_w 5895
    //   392: iload_3
    //   393: invokestatic 305	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   396: invokestatic 1920	asfc:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)Z
    //   399: pop
    //   400: aload 7
    //   402: ldc_w 5897
    //   405: invokevirtual 732	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   408: astore 8
    //   410: aload 8
    //   412: ifnull +76 -> 488
    //   415: aload 8
    //   417: ldc_w 5899
    //   420: invokevirtual 474	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   423: istore_3
    //   424: aload 8
    //   426: ldc_w 5901
    //   429: invokevirtual 474	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   432: istore 4
    //   434: aload 8
    //   436: ldc_w 5903
    //   439: invokevirtual 474	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   442: istore 5
    //   444: getstatic 15	amnh:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   447: ldc_w 5905
    //   450: iload_3
    //   451: invokestatic 305	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   454: invokestatic 1920	asfc:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)Z
    //   457: pop
    //   458: getstatic 15	amnh:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   461: ldc_w 5907
    //   464: iload 4
    //   466: invokestatic 305	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   469: invokestatic 1920	asfc:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)Z
    //   472: pop
    //   473: getstatic 15	amnh:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   476: ldc_w 5909
    //   479: iload 5
    //   481: invokestatic 305	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   484: invokestatic 1920	asfc:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)Z
    //   487: pop
    //   488: aload 7
    //   490: ldc_w 5911
    //   493: invokevirtual 5883	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   496: astore 8
    //   498: aload 8
    //   500: ifnull +273 -> 773
    //   503: getstatic 15	amnh:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   506: ldc_w 5913
    //   509: aload 8
    //   511: invokevirtual 5886	org/json/JSONArray:toString	()Ljava/lang/String;
    //   514: invokestatic 1920	asfc:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)Z
    //   517: pop
    //   518: getstatic 15	amnh:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   521: ldc_w 1917
    //   524: aload_2
    //   525: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   528: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   531: invokestatic 305	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   534: invokestatic 1920	asfc:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)Z
    //   537: pop
    //   538: aload 7
    //   540: ldc_w 5915
    //   543: iconst_0
    //   544: invokevirtual 2278	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   547: istore_3
    //   548: aload 7
    //   550: ldc_w 5917
    //   553: iconst_m1
    //   554: invokevirtual 2278	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   557: istore 4
    //   559: aload 7
    //   561: ldc_w 5919
    //   564: iconst_0
    //   565: invokevirtual 2278	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   568: istore 5
    //   570: aload 7
    //   572: ldc_w 5921
    //   575: iconst_0
    //   576: invokevirtual 2278	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   579: istore 6
    //   581: aload 7
    //   583: ldc_w 5923
    //   586: invokevirtual 137	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   589: astore_2
    //   590: getstatic 15	amnh:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   593: ldc_w 5915
    //   596: iload_3
    //   597: invokestatic 305	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   600: invokestatic 1920	asfc:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)Z
    //   603: pop
    //   604: getstatic 15	amnh:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   607: ldc_w 5917
    //   610: iload 4
    //   612: invokestatic 305	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   615: invokestatic 1920	asfc:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)Z
    //   618: pop
    //   619: getstatic 15	amnh:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   622: ldc_w 5919
    //   625: iload 5
    //   627: invokestatic 305	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   630: invokestatic 1920	asfc:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)Z
    //   633: pop
    //   634: getstatic 15	amnh:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   637: ldc_w 5921
    //   640: iload 6
    //   642: invokestatic 305	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   645: invokestatic 1920	asfc:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)Z
    //   648: pop
    //   649: getstatic 15	amnh:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   652: ldc_w 5925
    //   655: aload_2
    //   656: invokestatic 1920	asfc:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)Z
    //   659: pop
    //   660: aload 7
    //   662: ldc_w 5927
    //   665: invokevirtual 474	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   668: istore_3
    //   669: getstatic 15	amnh:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   672: ldc_w 5927
    //   675: iload_3
    //   676: invokestatic 305	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   679: invokestatic 1920	asfc:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)Z
    //   682: pop
    //   683: aload 7
    //   685: ldc_w 5929
    //   688: invokevirtual 732	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   691: astore_2
    //   692: aload_2
    //   693: ifnull +17 -> 710
    //   696: getstatic 15	amnh:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   699: ldc_w 5931
    //   702: aload_2
    //   703: invokevirtual 5891	org/json/JSONObject:toString	()Ljava/lang/String;
    //   706: invokestatic 1920	asfc:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)Z
    //   709: pop
    //   710: aload_1
    //   711: ldc_w 5933
    //   714: iconst_1
    //   715: iconst_1
    //   716: aconst_null
    //   717: invokevirtual 5937	com/tencent/mobileqq/app/QQAppInterface:notifyObservers	(Ljava/lang/Class;IZLandroid/os/Bundle;)V
    //   720: return
    //   721: astore 7
    //   723: ldc_w 5874
    //   726: iconst_1
    //   727: new 85	java/lang/StringBuilder
    //   730: dup
    //   731: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   734: ldc_w 5939
    //   737: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   740: aload 7
    //   742: invokevirtual 798	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   745: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   748: invokestatic 642	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   751: aconst_null
    //   752: astore 7
    //   754: goto -495 -> 259
    //   757: aload 7
    //   759: getfield 255	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content:content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   762: invokevirtual 260	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   765: invokevirtual 280	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   768: astore 7
    //   770: goto -511 -> 259
    //   773: getstatic 15	amnh:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   776: ldc_w 5913
    //   779: ldc 13
    //   781: invokestatic 1920	asfc:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)Z
    //   784: pop
    //   785: goto -267 -> 518
    //   788: astore_1
    //   789: ldc_w 5874
    //   792: iconst_1
    //   793: new 85	java/lang/StringBuilder
    //   796: dup
    //   797: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   800: ldc_w 5941
    //   803: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   806: aload_1
    //   807: invokevirtual 798	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   810: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   813: invokestatic 642	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   816: return
    //   817: astore_1
    //   818: ldc_w 5874
    //   821: iconst_1
    //   822: ldc_w 5943
    //   825: aload_1
    //   826: invokestatic 188	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   829: return
    //   830: aconst_null
    //   831: astore 7
    //   833: goto -574 -> 259
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	836	0	this	amnh
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
    int i = baig.af(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
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
          arrayOfByte = atiu.a(paramConfig.content.get().toByteArray());
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
        baig.m(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, paramConfig);
        baig.F(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, j);
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
    //   9: ldc_w 5963
    //   12: iconst_1
    //   13: ldc_w 5965
    //   16: iconst_0
    //   17: anewarray 301	java/lang/Object
    //   20: invokestatic 309	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   23: invokestatic 199	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   26: aload_1
    //   27: invokevirtual 65	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   30: getstatic 15	amnh:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   33: invokestatic 1936	adyt:a	(Landroid/content/Context;Ljava/lang/String;)I
    //   36: istore_3
    //   37: aload_2
    //   38: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   41: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   44: istore 6
    //   46: iload_3
    //   47: iload 6
    //   49: if_icmpeq +396 -> 445
    //   52: aload_2
    //   53: getfield 221	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   56: ifnull +365 -> 421
    //   59: aload_2
    //   60: getfield 221	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   63: invokevirtual 224	com/tencent/mobileqq/pb/PBRepeatMessageField:size	()I
    //   66: ifle +355 -> 421
    //   69: aload_2
    //   70: getfield 221	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   73: iconst_0
    //   74: invokevirtual 318	com/tencent/mobileqq/pb/PBRepeatMessageField:get	(I)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   77: checkcast 244	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content
    //   80: astore_2
    //   81: aload_2
    //   82: ifnull +326 -> 408
    //   85: aload_2
    //   86: getfield 255	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content:content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   89: invokevirtual 1126	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   92: ifeq +316 -> 408
    //   95: aload_2
    //   96: getfield 248	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content:compress	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   99: invokevirtual 251	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   102: iconst_1
    //   103: if_icmpne +217 -> 320
    //   106: aload_2
    //   107: getfield 255	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content:content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   110: invokevirtual 260	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   113: invokevirtual 266	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   116: invokestatic 321	atiu:a	([B)[B
    //   119: astore_2
    //   120: aload_2
    //   121: ifnull +393 -> 514
    //   124: new 118	java/lang/String
    //   127: dup
    //   128: aload_2
    //   129: ldc_w 323
    //   132: invokespecial 326	java/lang/String:<init>	([BLjava/lang/String;)V
    //   135: astore_2
    //   136: aload_2
    //   137: ifnull +215 -> 352
    //   140: new 128	org/json/JSONObject
    //   143: dup
    //   144: aload_2
    //   145: invokespecial 131	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   148: astore 9
    //   150: ldc_w 5963
    //   153: iconst_1
    //   154: new 85	java/lang/StringBuilder
    //   157: dup
    //   158: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   161: ldc_w 5967
    //   164: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   167: aload_2
    //   168: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   174: invokestatic 199	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   177: aload 9
    //   179: ldc_w 5969
    //   182: invokevirtual 408	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   185: istore_3
    //   186: aload 9
    //   188: ldc_w 5971
    //   191: invokevirtual 408	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   194: istore 4
    //   196: aload 9
    //   198: ldc_w 5973
    //   201: invokevirtual 515	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   204: astore 9
    //   206: aload 8
    //   208: astore_2
    //   209: aload 9
    //   211: ifnull +123 -> 334
    //   214: aload 8
    //   216: astore_2
    //   217: aload 9
    //   219: invokevirtual 520	org/json/JSONArray:length	()I
    //   222: ifle +112 -> 334
    //   225: new 522	java/util/HashSet
    //   228: dup
    //   229: invokespecial 523	java/util/HashSet:<init>	()V
    //   232: astore_2
    //   233: iload 5
    //   235: aload 9
    //   237: invokevirtual 520	org/json/JSONArray:length	()I
    //   240: if_icmpge +94 -> 334
    //   243: aload 9
    //   245: iload 5
    //   247: invokevirtual 5974	org/json/JSONArray:get	(I)Ljava/lang/Object;
    //   250: checkcast 128	org/json/JSONObject
    //   253: ldc_w 5976
    //   256: invokevirtual 420	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   259: astore 7
    //   261: aload 7
    //   263: invokestatic 126	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   266: ifne +12 -> 278
    //   269: aload_2
    //   270: aload 7
    //   272: invokeinterface 2847 2 0
    //   277: pop
    //   278: iload 5
    //   280: iconst_1
    //   281: iadd
    //   282: istore 5
    //   284: goto -51 -> 233
    //   287: astore_2
    //   288: ldc_w 5963
    //   291: iconst_1
    //   292: new 85	java/lang/StringBuilder
    //   295: dup
    //   296: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   299: ldc_w 5978
    //   302: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   305: aload_2
    //   306: invokevirtual 798	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   309: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   312: invokestatic 642	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   315: aconst_null
    //   316: astore_2
    //   317: goto -181 -> 136
    //   320: aload_2
    //   321: getfield 255	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content:content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   324: invokevirtual 260	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   327: invokevirtual 280	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   330: astore_2
    //   331: goto -195 -> 136
    //   334: iload_3
    //   335: istore 5
    //   337: iload 4
    //   339: istore_3
    //   340: aload_1
    //   341: invokestatic 5981	adyt:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)Ladyt;
    //   344: aload_1
    //   345: iload 5
    //   347: iload_3
    //   348: aload_2
    //   349: invokevirtual 5984	adyt:a	(Lcom/tencent/mobileqq/app/QQAppInterface;IILjava/util/Set;)V
    //   352: aload_1
    //   353: invokevirtual 65	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   356: getstatic 15	amnh:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   359: iload 6
    //   361: invokestatic 5985	adyt:a	(Landroid/content/Context;Ljava/lang/String;I)V
    //   364: return
    //   365: astore_2
    //   366: iconst_0
    //   367: istore 4
    //   369: iconst_0
    //   370: istore_3
    //   371: ldc_w 5963
    //   374: iconst_1
    //   375: new 85	java/lang/StringBuilder
    //   378: dup
    //   379: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   382: ldc_w 5866
    //   385: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   388: aload_2
    //   389: invokevirtual 798	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   392: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   395: invokestatic 642	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   398: aload 7
    //   400: astore_2
    //   401: iload 4
    //   403: istore 5
    //   405: goto -65 -> 340
    //   408: ldc_w 5963
    //   411: iconst_1
    //   412: ldc_w 5987
    //   415: invokestatic 199	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   418: goto -66 -> 352
    //   421: ldc_w 5963
    //   424: iconst_1
    //   425: ldc_w 5989
    //   428: invokestatic 199	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   431: aload_1
    //   432: invokestatic 5981	adyt:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)Ladyt;
    //   435: aload_1
    //   436: iconst_0
    //   437: iconst_0
    //   438: aconst_null
    //   439: invokevirtual 5984	adyt:a	(Lcom/tencent/mobileqq/app/QQAppInterface;IILjava/util/Set;)V
    //   442: goto -90 -> 352
    //   445: ldc_w 5963
    //   448: iconst_1
    //   449: ldc_w 5991
    //   452: iconst_1
    //   453: anewarray 301	java/lang/Object
    //   456: dup
    //   457: iconst_0
    //   458: iload_3
    //   459: invokestatic 305	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   462: aastore
    //   463: invokestatic 309	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   466: invokestatic 642	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
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
    //   0	519	0	this	amnh
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
    int i = baig.aj(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
    int j = paramConfig.version.get();
    if (i != j) {
      if ((paramConfig.msg_content_list != null) && (paramConfig.msg_content_list.size() > 0))
      {
        paramConfig = (ConfigurationService.Content)paramConfig.msg_content_list.get(0);
        if ((paramConfig != null) && (paramConfig.content.has())) {
          if (paramConfig.compress.get() == 1)
          {
            paramConfig = atiu.a(paramConfig.content.get().toByteArray());
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
        baig.H(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, j);
        ((aric)paramQQAppInterface.getManager(221)).a(paramConfig);
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
      bool = bady.a(paramQQAppInterface.getApp(), "com.tencent.tim");
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
        paramConfig = paramQQAppInterface.getApp().getSharedPreferences("tim_upgrade_hongdian_pre_" + paramQQAppInterface.c(), 0).edit();
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
      ((ariy)paramQQAppInterface.getManager(244)).a();
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
        paramConfig = paramQQAppInterface.getApp().getSharedPreferences("tim_login_shared_pre_" + paramQQAppInterface.c(), 0).edit();
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
        paramConfig = paramQQAppInterface.getApp().getSharedPreferences("tim_pc_banner_shared_pre_" + paramQQAppInterface.c(), 0).edit();
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
 * Qualified Name:     amnh
 * JD-Core Version:    0.7.0.1
 */