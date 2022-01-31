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

public class aova
  extends MSFServlet
{
  public static String a;
  private static final int[] jdField_a_of_type_ArrayOfInt = { 1, 2, 3, 5, 10, 13, 23, 31, 38, 42, 44, 46, 47, 49, 50, 53, 55, 56, 57, 61, 62, 63, 64, 65, 66, 69, 206, 205, 72, 73, 74, 75, 385, 94, 78, 79, 80, 84, 223, 82, 101, 102, 147, 86, 93, 88, 90, 96, 97, 108, 146, 111, 109, 115, 286, 118, 120, 119, 116, 130, 142, 121, 157, 211, 201, 129, 143, 140, 257, 232, 233, 231, 148, 139, 145, 153, 149, 155, 165, 185, 167, 166, 171, 180, 182, 177, 371, 181, 184, 187, 191, 193, 188, 195, 227, 202, 190, 210, 199, 212, 407, ume.a(2131427352), ume.a(2131427353), ume.a(2131427354), ume.a(2131427349), ume.a(2131427350), 218, 226, 225, 222, 256, 228, 235, 234, 238, 247, 244, 245, 253, 295, 255, 254, 259, 260, 262, 204, 271, 267, 275, 358, 268, 269, 272, 274, 279, 308, 281, 283, 284, 280, 360, 289, 314, 297, 301, 296, 330, 347, 313, 312, 397, 321, 326, 320, 328, 331, 336, 329, 337, 345, 351, 349, 355, 372, 384, 379, 357, 378, 381, 273, 364, 365, 369, 387, 386, 392, 393, 394, 401, 400, 403, 404, 405, 408, 410, 194, 596, 604 };
  private static String b;
  private boolean jdField_a_of_type_Boolean;
  
  static
  {
    jdField_a_of_type_JavaLangString = "";
    jdField_b_of_type_JavaLangString = alpo.a(2131702803);
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
        j = bdiv.O(localQQAppInterface.getApp(), localQQAppInterface.getAccount());
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
        paramConfig = (aukr)localQQAppInterface.getManager(166);
        paramConfig.jdField_b_of_type_Boolean = true;
        paramConfig.c = bool3;
        localQQAppInterface.h = true;
        localQQAppInterface.i = bool4;
        bdiv.b(localQQAppInterface.getApp(), localQQAppInterface.getAccount(), i, bool3, bool4);
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
    bhoy localbhoy = (bhoy)((QQAppInterface)localObject).a(146);
    int i = localbhoy.b(BaseApplicationImpl.getContext(), ((QQAppInterface)localObject).getAccount());
    if (localbhoy.a(BaseApplicationImpl.getContext(), ((QQAppInterface)localObject).getAccount()) != k) {
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
          paramConfig = localbhoy.a(paramConfig.content.get().toByteArray());
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
          localbhoy.a(paramConfig, j, k);
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
        localbhoy.a(jdField_a_of_type_JavaLangString);
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
    //   1: invokevirtual 47	aova:getAppRuntime	()Lmqq/app/AppRuntime;
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
    //   27: invokestatic 292	bdiv:aU	(Landroid/content/Context;Ljava/lang/String;)I
    //   30: istore_2
    //   31: aload 8
    //   33: invokevirtual 65	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   36: aload 8
    //   38: invokevirtual 69	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   41: invokestatic 295	bdiv:aV	(Landroid/content/Context;Ljava/lang/String;)I
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
    //   123: invokestatic 313	bdiv:z	(Landroid/content/Context;ILjava/lang/String;)V
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
    //   186: invokestatic 321	avxz:a	([B)[B
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
    //   272: getstatic 15	aova:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   275: invokestatic 360	bdiv:y	(Landroid/content/Context;ILjava/lang/String;)V
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
    //   0	485	0	this	aova
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
    int j = bdiv.aR(BaseApplication.getContext(), jdField_a_of_type_JavaLangString);
    if (QLog.isColorLevel()) {
      QLog.i("SPLASH_ConfigServlet", 2, "handleWeiYunMiniAppConfig: ,version: " + paramConfig.version.get() + "| localVersion: " + j);
    }
    if (i != j)
    {
      bdiv.ah(BaseApplication.getContext(), jdField_a_of_type_JavaLangString, i);
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
              bdiv.w(BaseApplication.getContext(), i, paramQQAppInterface.getCurrentAccountUin());
              if (QLog.isColorLevel()) {
                QLog.d("SPLASH_ConfigServlet", 2, "handleWeiYunMiniAppConfig, enableMiniApp = " + i);
              }
            }
            if (((JSONObject)localObject).has("apkgUrl"))
            {
              String str = ((JSONObject)localObject).getString("apkgUrl");
              bdiv.v(BaseApplication.getContext(), str, paramQQAppInterface.getCurrentAccountUin());
              if (QLog.isColorLevel()) {
                QLog.d("SPLASH_ConfigServlet", 2, "handleWeiYunMiniAppConfig, apkgUrl = " + str);
              }
            }
            if (((JSONObject)localObject).has("miniVersion"))
            {
              i = ((JSONObject)localObject).getInt("miniVersion");
              bdiv.x(BaseApplication.getContext(), i, paramQQAppInterface.getCurrentAccountUin());
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
    int j = bdiv.aX(BaseApplication.getContext(), jdField_a_of_type_JavaLangString);
    if (QLog.isColorLevel()) {
      QLog.i("SPLASH_ConfigServlet", 2, "handleAIOConfig: ,version: " + paramConfig.version.get() + "| localVersion: " + j);
    }
    if (i != j)
    {
      bdiv.aj(BaseApplication.getContext(), jdField_a_of_type_JavaLangString, i);
      paramConfig = a(paramConfig);
      if ((paramConfig == null) || (paramConfig.size() <= 0)) {}
    }
    while (!QLog.isColorLevel()) {
      try
      {
        paramConfig = (String)paramConfig.get(paramConfig.size() - 1);
        bdiv.c(BaseApplication.getContext(), jdField_a_of_type_JavaLangString, "aio_config_key", paramConfig);
        aekh.a(paramQQAppInterface);
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
    int j = bdiv.aY(BaseApplication.getContext(), jdField_a_of_type_JavaLangString);
    if (QLog.isColorLevel()) {
      QLog.i("SPLASH_ConfigServlet", 2, "handleMultiMsgConfig: ,version: " + paramConfig.version.get() + "| localVersion: " + j);
    }
    if (i != j)
    {
      bdiv.ak(BaseApplication.getContext(), jdField_a_of_type_JavaLangString, i);
      paramConfig = a(paramConfig);
      if ((paramConfig == null) || (paramConfig.size() <= 0)) {}
    }
    while (!QLog.isColorLevel()) {
      try
      {
        i = new JSONObject((String)paramConfig.get(paramConfig.size() - 1)).optInt("max_multimsg_totalcount");
        bdiv.g(BaseApplication.getContext(), jdField_a_of_type_JavaLangString, "multimsg_config", i);
        if (QLog.isColorLevel()) {
          QLog.i("SPLASH_ConfigServlet", 2, "handleMultiMsgConfig:limitTotal =  " + i);
        }
        aukx.a().a(paramQQAppInterface);
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
    int j = bdiv.az(BaseApplication.getContext(), jdField_a_of_type_JavaLangString);
    if (QLog.isColorLevel()) {
      QLog.i("SPLASH_ConfigServlet", 2, "handleConversationPublicAccConfig: ,version: " + paramConfig.version.get() + "| localVersion: " + j);
    }
    if (i != j)
    {
      bdiv.U(BaseApplication.getContext(), jdField_a_of_type_JavaLangString, i);
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
            localObject3 = ajgd.a();
            if (i == 1)
            {
              bool = true;
              ((ajgd)localObject3).a(paramQQAppInterface, bool);
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
        ajgd.a().a(paramQQAppInterface, false);
        continue;
        if (QLog.isColorLevel()) {
          QLog.i("SPLASH_ConfigServlet", 2, "handleConversationPublicAccConfig  error =" + localJSONException1.getMessage());
        }
        ajgd.a().a(paramQQAppInterface, false);
        ajgd.a().a(paramQQAppInterface, null);
      }
    }
    label406:
    label417:
    label443:
    label444:
    for (;;)
    {
      break;
      ajgd.a().a(paramQQAppInterface, localJSONException1);
      paramConfig = localJSONException1;
      continue;
      Object localObject2;
      ajgd.a().a(paramQQAppInterface, paramConfig);
      break label444;
      ajgd.a().a(paramQQAppInterface, paramConfig);
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
    int j = bdiv.a();
    if (QLog.isColorLevel()) {
      QLog.i("SPLASH_ConfigServlet", 2, "handleBeancurdConfig: ,version: " + paramConfig.version.get() + "| localVersion: " + j);
    }
    if (i != j)
    {
      bdiv.a(i);
      paramConfig = a(paramConfig);
      if ((paramConfig != null) && (paramConfig.size() > 0))
      {
        paramConfig = (String)paramConfig.get(paramConfig.size() - 1);
        if (QLog.isColorLevel()) {
          QLog.i("SPLASH_ConfigServlet", 2, "handleBeancurdConfigStr: " + paramConfig);
        }
        bdiv.b(paramConfig);
        ((aely)paramQQAppInterface.getManager(282)).a(paramConfig);
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
    int j = bdiv.ay(BaseApplication.getContext(), jdField_a_of_type_JavaLangString);
    if (QLog.isColorLevel()) {
      QLog.i("SPLASH_ConfigServlet", 2, "handleZhituConfig: ,version: " + paramConfig.version.get() + "| localVersion: " + j);
    }
    if (i != j)
    {
      bdiv.T(BaseApplication.getContext(), jdField_a_of_type_JavaLangString, i);
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
              agwq localagwq;
              if (((JSONObject)localObject).has("kMarioConfigEnable"))
              {
                i = ((JSONObject)localObject).getInt("kMarioConfigEnable");
                localagwq = agwq.a(paramQQAppInterface);
                if (i != 1) {
                  break label324;
                }
                bool = true;
                localagwq.a(bool);
              }
              if (((JSONObject)localObject).has("kMarioPageLen"))
              {
                i = ((JSONObject)localObject).getInt("kMarioPageLen");
                agwq.a(paramQQAppInterface).b(i);
              }
              if (((JSONObject)localObject).has("kMarioSaveAndShareEnable"))
              {
                i = ((JSONObject)localObject).getInt("kMarioSaveAndShareEnable");
                localagwq = agwq.a(paramQQAppInterface);
                if (i != 1) {
                  break label330;
                }
                bool = true;
                localagwq.b(bool);
              }
              if (!((JSONObject)localObject).has("kMarioSafeGateRequestInterval")) {
                break;
              }
              i = ((JSONObject)localObject).getInt("kMarioSafeGateRequestInterval");
              agwq.a(paramQQAppInterface).a(i);
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
    a(paramQQAppInterface, paramConfig, "handleShortVideoMsgTailConfig", new aovb(this, paramQQAppInterface));
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
            if ((j == bdiv.a(paramQQAppInterface.getApp(), "readinjoy_interested_push_config", jdField_a_of_type_JavaLangString)) || (TextUtils.isEmpty((CharSequence)localObject))) {
              break label412;
            }
            localObject = ((String)localObject).split("=");
            if (localObject.length >= 2)
            {
              if (!"xqh_insert_into_feeds".equals(localObject[0])) {
                continue;
              }
              bjxj.c(paramQQAppInterface, "1".equals(localObject[1]));
              if (QLog.isColorLevel()) {
                QLog.d("SPLASH_ConfigServlet", 2, "update KANDIAN_INTERESTED_PUSH_CONFiG config , switch : " + "1".equals(localObject[1]));
              }
            }
            bdiv.a(paramQQAppInterface.getApp(), "readinjoy_interested_push_config", jdField_a_of_type_JavaLangString, j);
            break label469;
            if ("simple_switch_fm".equals(localObject[0]))
            {
              bjxj.c(paramQQAppInterface, "1".equals(localObject[1]));
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
        peg.a(paramQQAppInterface, "1".equals(localObject[1]));
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
            if (k != bdiv.a(paramQQAppInterface.getApp(), "now_entrance_action_version", jdField_a_of_type_JavaLangString))
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
                    bdiv.c(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin(), localJSONObject.optInt("bid"), localJSONObject.optInt("actionType"));
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
                  bdiv.a(paramQQAppInterface.getApp(), "now_entrance_action_version", jdField_a_of_type_JavaLangString, k);
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
            if (j == bdiv.a(paramQQAppInterface.getApp(), "troop_common_config_version", jdField_a_of_type_JavaLangString)) {
              break label625;
            }
            boolean bool = TextUtils.isEmpty((CharSequence)localObject);
            if (bool) {
              break label625;
            }
            try
            {
              JSONObject localJSONObject = new JSONObject((String)localObject);
              bdiv.e(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin(), localJSONObject.optString("hot_chat_link"));
              bdiv.v(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin(), localJSONObject.optInt("aio_post_tab_plugin"));
              ((bckx)paramQQAppInterface.getManager(203)).a(localJSONObject);
              ((amku)paramQQAppInterface.getManager(126)).a(localJSONObject);
              bdiv.u(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin(), localJSONObject.optInt("create_troop_max_invite_num"));
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
            bdiv.a(paramQQAppInterface.getApp(), "troop_common_config_version", jdField_a_of_type_JavaLangString, j);
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
            if (j != bdiv.a(paramQQAppInterface.getApp(), "nearby_config_version", jdField_a_of_type_JavaLangString))
            {
              boolean bool = TextUtils.isEmpty((CharSequence)localObject);
              if (!bool) {
                try
                {
                  localObject = new JSONObject((String)localObject);
                  bdiv.a(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin(), (JSONObject)localObject);
                  bdiv.a(paramQQAppInterface.getApp(), "nearby_config_version", jdField_a_of_type_JavaLangString, j);
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
          if (j != bdiv.a(paramQQAppInterface.getApp(), "nearby_nowlive_tab_config_version", jdField_a_of_type_JavaLangString))
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
                bdiv.a(paramQQAppInterface.getApp(), "nearby_nowlive_tab_config_version", jdField_a_of_type_JavaLangString, j);
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
        bcgi localbcgi = (bcgi)paramQQAppInterface.getManager(183);
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
            if ((j != bdiv.a(paramQQAppInterface.getApp(), "change_machine_version", jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty(str)))
            {
              if (BaseApplicationImpl.isFirstLogin) {
                localbcgi.a(str);
              }
              bdiv.a(paramQQAppInterface.getApp(), "change_machine_version", jdField_a_of_type_JavaLangString, j);
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
    return paramFloat / (50.0F * 2.0F) * (float)bdcb.g();
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
    ShortVideoResourceManager localShortVideoResourceManager = paramQQAppInterface.a();
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
              paramConfig = avxz.a(paramConfig.content.get().toByteArray());
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
    //   2: invokestatic 913	javax/xml/parsers/DocumentBuilderFactory:newInstance	()Ljavax/xml/parsers/DocumentBuilderFactory;
    //   5: invokevirtual 917	javax/xml/parsers/DocumentBuilderFactory:newDocumentBuilder	()Ljavax/xml/parsers/DocumentBuilder;
    //   8: new 919	java/io/ByteArrayInputStream
    //   11: dup
    //   12: aload_1
    //   13: ldc_w 921
    //   16: invokevirtual 925	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   19: invokespecial 926	java/io/ByteArrayInputStream:<init>	([B)V
    //   22: invokevirtual 931	javax/xml/parsers/DocumentBuilder:parse	(Ljava/io/InputStream;)Lorg/w3c/dom/Document;
    //   25: astore_1
    //   26: aload_1
    //   27: ldc_w 933
    //   30: invokeinterface 939 2 0
    //   35: astore 4
    //   37: aload 4
    //   39: ifnull +1254 -> 1293
    //   42: aload 4
    //   44: invokeinterface 944 1 0
    //   49: ifle +1244 -> 1293
    //   52: aload_1
    //   53: ldc_w 946
    //   56: invokeinterface 939 2 0
    //   61: astore 4
    //   63: aload 4
    //   65: ifnull +45 -> 110
    //   68: aload 4
    //   70: invokeinterface 944 1 0
    //   75: ifle +35 -> 110
    //   78: aload_2
    //   79: aload_1
    //   80: ldc_w 946
    //   83: invokeinterface 939 2 0
    //   88: iconst_0
    //   89: invokeinterface 950 2 0
    //   94: invokeinterface 956 1 0
    //   99: invokeinterface 959 1 0
    //   104: invokestatic 143	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   107: putfield 962	com/tencent/mobileqq/config/operation/QQOperationViopTipTask:taskid	I
    //   110: aload_1
    //   111: ldc_w 964
    //   114: invokeinterface 939 2 0
    //   119: astore 4
    //   121: aload 4
    //   123: ifnull +45 -> 168
    //   126: aload 4
    //   128: invokeinterface 944 1 0
    //   133: ifle +35 -> 168
    //   136: aload_2
    //   137: aload_1
    //   138: ldc_w 964
    //   141: invokeinterface 939 2 0
    //   146: iconst_0
    //   147: invokeinterface 950 2 0
    //   152: invokeinterface 956 1 0
    //   157: invokeinterface 959 1 0
    //   162: invokestatic 143	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   165: putfield 967	com/tencent/mobileqq/config/operation/QQOperationViopTipTask:limitDayAIOCount	I
    //   168: aload_1
    //   169: ldc_w 969
    //   172: invokeinterface 939 2 0
    //   177: astore 4
    //   179: aload 4
    //   181: ifnull +45 -> 226
    //   184: aload 4
    //   186: invokeinterface 944 1 0
    //   191: ifle +35 -> 226
    //   194: aload_2
    //   195: aload_1
    //   196: ldc_w 969
    //   199: invokeinterface 939 2 0
    //   204: iconst_0
    //   205: invokeinterface 950 2 0
    //   210: invokeinterface 956 1 0
    //   215: invokeinterface 959 1 0
    //   220: invokestatic 143	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   223: putfield 972	com/tencent/mobileqq/config/operation/QQOperationViopTipTask:limitDayAIOShowCount	I
    //   226: aload_1
    //   227: ldc_w 974
    //   230: invokeinterface 939 2 0
    //   235: astore 4
    //   237: aload 4
    //   239: ifnull +45 -> 284
    //   242: aload 4
    //   244: invokeinterface 944 1 0
    //   249: ifle +35 -> 284
    //   252: aload_2
    //   253: aload_1
    //   254: ldc_w 974
    //   257: invokeinterface 939 2 0
    //   262: iconst_0
    //   263: invokeinterface 950 2 0
    //   268: invokeinterface 956 1 0
    //   273: invokeinterface 959 1 0
    //   278: invokestatic 143	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   281: putfield 977	com/tencent/mobileqq/config/operation/QQOperationViopTipTask:limitTotalAIOCount	I
    //   284: aload_1
    //   285: ldc_w 979
    //   288: invokeinterface 939 2 0
    //   293: astore 4
    //   295: aload 4
    //   297: ifnull +45 -> 342
    //   300: aload 4
    //   302: invokeinterface 944 1 0
    //   307: ifle +35 -> 342
    //   310: aload_2
    //   311: aload_1
    //   312: ldc_w 979
    //   315: invokeinterface 939 2 0
    //   320: iconst_0
    //   321: invokeinterface 950 2 0
    //   326: invokeinterface 956 1 0
    //   331: invokeinterface 959 1 0
    //   336: invokestatic 143	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   339: putfield 982	com/tencent/mobileqq/config/operation/QQOperationViopTipTask:limitTotalShowCount	I
    //   342: aload_1
    //   343: ldc_w 984
    //   346: invokeinterface 939 2 0
    //   351: astore 4
    //   353: aload 4
    //   355: ifnull +42 -> 397
    //   358: aload 4
    //   360: invokeinterface 944 1 0
    //   365: ifle +32 -> 397
    //   368: aload_2
    //   369: aload_1
    //   370: ldc_w 984
    //   373: invokeinterface 939 2 0
    //   378: iconst_0
    //   379: invokeinterface 950 2 0
    //   384: invokeinterface 956 1 0
    //   389: invokeinterface 959 1 0
    //   394: invokevirtual 987	com/tencent/mobileqq/config/operation/QQOperationViopTipTask:setKeywordString	(Ljava/lang/String;)V
    //   397: invokestatic 990	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   400: ifeq +33 -> 433
    //   403: ldc_w 992
    //   406: iconst_4
    //   407: new 85	java/lang/StringBuilder
    //   410: dup
    //   411: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   414: ldc_w 994
    //   417: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   420: aload_2
    //   421: invokevirtual 998	com/tencent/mobileqq/config/operation/QQOperationViopTipTask:getKeywordList	()Ljava/util/ArrayList;
    //   424: invokevirtual 798	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   427: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   430: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   433: aload_1
    //   434: ldc_w 1000
    //   437: invokeinterface 939 2 0
    //   442: astore 4
    //   444: aload 4
    //   446: ifnull +42 -> 488
    //   449: aload 4
    //   451: invokeinterface 944 1 0
    //   456: ifle +32 -> 488
    //   459: aload_2
    //   460: aload_1
    //   461: ldc_w 1000
    //   464: invokeinterface 939 2 0
    //   469: iconst_0
    //   470: invokeinterface 950 2 0
    //   475: invokeinterface 956 1 0
    //   480: invokeinterface 959 1 0
    //   485: invokevirtual 1003	com/tencent/mobileqq/config/operation/QQOperationViopTipTask:setBeginTime	(Ljava/lang/String;)V
    //   488: aload_1
    //   489: ldc_w 1005
    //   492: invokeinterface 939 2 0
    //   497: astore 4
    //   499: aload 4
    //   501: ifnull +42 -> 543
    //   504: aload 4
    //   506: invokeinterface 944 1 0
    //   511: ifle +32 -> 543
    //   514: aload_2
    //   515: aload_1
    //   516: ldc_w 1005
    //   519: invokeinterface 939 2 0
    //   524: iconst_0
    //   525: invokeinterface 950 2 0
    //   530: invokeinterface 956 1 0
    //   535: invokeinterface 959 1 0
    //   540: invokevirtual 1008	com/tencent/mobileqq/config/operation/QQOperationViopTipTask:setEndTime	(Ljava/lang/String;)V
    //   543: aload_1
    //   544: ldc_w 1010
    //   547: invokeinterface 939 2 0
    //   552: astore 4
    //   554: aload 4
    //   556: ifnull +50 -> 606
    //   559: aload 4
    //   561: invokeinterface 944 1 0
    //   566: ifle +40 -> 606
    //   569: aload_1
    //   570: ldc_w 1010
    //   573: invokeinterface 939 2 0
    //   578: iconst_0
    //   579: invokeinterface 950 2 0
    //   584: invokeinterface 956 1 0
    //   589: invokeinterface 959 1 0
    //   594: invokestatic 143	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   597: iconst_1
    //   598: if_icmpne +697 -> 1295
    //   601: aload_2
    //   602: iload_3
    //   603: putfield 1013	com/tencent/mobileqq/config/operation/QQOperationViopTipTask:uinType	I
    //   606: aload_1
    //   607: ldc_w 1015
    //   610: invokeinterface 939 2 0
    //   615: astore 4
    //   617: aload 4
    //   619: ifnull +197 -> 816
    //   622: aload 4
    //   624: invokeinterface 944 1 0
    //   629: ifle +187 -> 816
    //   632: aload_1
    //   633: ldc_w 1015
    //   636: invokeinterface 939 2 0
    //   641: iconst_0
    //   642: invokeinterface 950 2 0
    //   647: checkcast 1017	org/w3c/dom/Element
    //   650: ldc_w 1019
    //   653: invokeinterface 1020 2 0
    //   658: astore 4
    //   660: aload 4
    //   662: ifnull +62 -> 724
    //   665: aload 4
    //   667: invokeinterface 944 1 0
    //   672: ifle +52 -> 724
    //   675: aload_2
    //   676: aload_1
    //   677: ldc_w 1015
    //   680: invokeinterface 939 2 0
    //   685: iconst_0
    //   686: invokeinterface 950 2 0
    //   691: checkcast 1017	org/w3c/dom/Element
    //   694: ldc_w 1019
    //   697: invokeinterface 1020 2 0
    //   702: iconst_0
    //   703: invokeinterface 950 2 0
    //   708: invokeinterface 956 1 0
    //   713: invokeinterface 959 1 0
    //   718: invokestatic 143	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   721: putfield 1023	com/tencent/mobileqq/config/operation/QQOperationViopTipTask:frequencyTime	I
    //   724: aload_1
    //   725: ldc_w 1015
    //   728: invokeinterface 939 2 0
    //   733: iconst_0
    //   734: invokeinterface 950 2 0
    //   739: checkcast 1017	org/w3c/dom/Element
    //   742: ldc_w 1025
    //   745: invokeinterface 1020 2 0
    //   750: astore 4
    //   752: aload 4
    //   754: ifnull +62 -> 816
    //   757: aload 4
    //   759: invokeinterface 944 1 0
    //   764: ifle +52 -> 816
    //   767: aload_2
    //   768: aload_1
    //   769: ldc_w 1015
    //   772: invokeinterface 939 2 0
    //   777: iconst_0
    //   778: invokeinterface 950 2 0
    //   783: checkcast 1017	org/w3c/dom/Element
    //   786: ldc_w 1025
    //   789: invokeinterface 1020 2 0
    //   794: iconst_0
    //   795: invokeinterface 950 2 0
    //   800: invokeinterface 956 1 0
    //   805: invokeinterface 959 1 0
    //   810: invokestatic 143	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   813: putfield 1028	com/tencent/mobileqq/config/operation/QQOperationViopTipTask:frequencyMessage	I
    //   816: aload_1
    //   817: ldc_w 1030
    //   820: invokeinterface 939 2 0
    //   825: astore 4
    //   827: aload 4
    //   829: ifnull +464 -> 1293
    //   832: aload 4
    //   834: invokeinterface 944 1 0
    //   839: ifle +454 -> 1293
    //   842: aload_1
    //   843: ldc_w 1030
    //   846: invokeinterface 939 2 0
    //   851: iconst_0
    //   852: invokeinterface 950 2 0
    //   857: checkcast 1017	org/w3c/dom/Element
    //   860: ldc_w 1032
    //   863: invokeinterface 1020 2 0
    //   868: astore 4
    //   870: aload 4
    //   872: ifnull +62 -> 934
    //   875: aload 4
    //   877: invokeinterface 944 1 0
    //   882: ifle +52 -> 934
    //   885: aload_2
    //   886: aload_1
    //   887: ldc_w 1030
    //   890: invokeinterface 939 2 0
    //   895: iconst_0
    //   896: invokeinterface 950 2 0
    //   901: checkcast 1017	org/w3c/dom/Element
    //   904: ldc_w 1032
    //   907: invokeinterface 1020 2 0
    //   912: iconst_0
    //   913: invokeinterface 950 2 0
    //   918: invokeinterface 956 1 0
    //   923: invokeinterface 959 1 0
    //   928: invokestatic 143	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   931: putfield 1035	com/tencent/mobileqq/config/operation/QQOperationViopTipTask:tipType	I
    //   934: aload_1
    //   935: ldc_w 1030
    //   938: invokeinterface 939 2 0
    //   943: iconst_0
    //   944: invokeinterface 950 2 0
    //   949: checkcast 1017	org/w3c/dom/Element
    //   952: ldc_w 1025
    //   955: invokeinterface 1020 2 0
    //   960: astore 4
    //   962: aload 4
    //   964: ifnull +59 -> 1023
    //   967: aload 4
    //   969: invokeinterface 944 1 0
    //   974: ifle +49 -> 1023
    //   977: aload_2
    //   978: aload_1
    //   979: ldc_w 1030
    //   982: invokeinterface 939 2 0
    //   987: iconst_0
    //   988: invokeinterface 950 2 0
    //   993: checkcast 1017	org/w3c/dom/Element
    //   996: ldc_w 1025
    //   999: invokeinterface 1020 2 0
    //   1004: iconst_0
    //   1005: invokeinterface 950 2 0
    //   1010: invokeinterface 956 1 0
    //   1015: invokeinterface 959 1 0
    //   1020: putfield 1038	com/tencent/mobileqq/config/operation/QQOperationViopTipTask:adwords	Ljava/lang/String;
    //   1023: aload_1
    //   1024: ldc_w 1030
    //   1027: invokeinterface 939 2 0
    //   1032: iconst_0
    //   1033: invokeinterface 950 2 0
    //   1038: checkcast 1017	org/w3c/dom/Element
    //   1041: ldc_w 1040
    //   1044: invokeinterface 1020 2 0
    //   1049: astore 4
    //   1051: aload 4
    //   1053: ifnull +62 -> 1115
    //   1056: aload 4
    //   1058: invokeinterface 944 1 0
    //   1063: ifle +52 -> 1115
    //   1066: aload_2
    //   1067: aload_1
    //   1068: ldc_w 1030
    //   1071: invokeinterface 939 2 0
    //   1076: iconst_0
    //   1077: invokeinterface 950 2 0
    //   1082: checkcast 1017	org/w3c/dom/Element
    //   1085: ldc_w 1040
    //   1088: invokeinterface 1020 2 0
    //   1093: iconst_0
    //   1094: invokeinterface 950 2 0
    //   1099: invokeinterface 956 1 0
    //   1104: invokeinterface 959 1 0
    //   1109: invokestatic 143	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   1112: putfield 1043	com/tencent/mobileqq/config/operation/QQOperationViopTipTask:linkOffset	I
    //   1115: aload_1
    //   1116: ldc_w 1030
    //   1119: invokeinterface 939 2 0
    //   1124: iconst_0
    //   1125: invokeinterface 950 2 0
    //   1130: checkcast 1017	org/w3c/dom/Element
    //   1133: ldc_w 1045
    //   1136: invokeinterface 1020 2 0
    //   1141: astore 4
    //   1143: aload 4
    //   1145: ifnull +59 -> 1204
    //   1148: aload 4
    //   1150: invokeinterface 944 1 0
    //   1155: ifle +49 -> 1204
    //   1158: aload_2
    //   1159: aload_1
    //   1160: ldc_w 1030
    //   1163: invokeinterface 939 2 0
    //   1168: iconst_0
    //   1169: invokeinterface 950 2 0
    //   1174: checkcast 1017	org/w3c/dom/Element
    //   1177: ldc_w 1045
    //   1180: invokeinterface 1020 2 0
    //   1185: iconst_0
    //   1186: invokeinterface 950 2 0
    //   1191: invokeinterface 956 1 0
    //   1196: invokeinterface 959 1 0
    //   1201: putfield 1048	com/tencent/mobileqq/config/operation/QQOperationViopTipTask:clickableWord	Ljava/lang/String;
    //   1204: aload_1
    //   1205: ldc_w 1030
    //   1208: invokeinterface 939 2 0
    //   1213: iconst_0
    //   1214: invokeinterface 950 2 0
    //   1219: checkcast 1017	org/w3c/dom/Element
    //   1222: ldc_w 779
    //   1225: invokeinterface 1020 2 0
    //   1230: astore 4
    //   1232: aload 4
    //   1234: ifnull +59 -> 1293
    //   1237: aload 4
    //   1239: invokeinterface 944 1 0
    //   1244: ifle +49 -> 1293
    //   1247: aload_2
    //   1248: aload_1
    //   1249: ldc_w 1030
    //   1252: invokeinterface 939 2 0
    //   1257: iconst_0
    //   1258: invokeinterface 950 2 0
    //   1263: checkcast 1017	org/w3c/dom/Element
    //   1266: ldc_w 779
    //   1269: invokeinterface 1020 2 0
    //   1274: iconst_0
    //   1275: invokeinterface 950 2 0
    //   1280: invokeinterface 956 1 0
    //   1285: invokeinterface 959 1 0
    //   1290: putfield 1050	com/tencent/mobileqq/config/operation/QQOperationViopTipTask:url	Ljava/lang/String;
    //   1293: aload_2
    //   1294: areturn
    //   1295: sipush 3000
    //   1298: istore_3
    //   1299: goto -698 -> 601
    //   1302: astore_1
    //   1303: aload_1
    //   1304: invokevirtual 1051	javax/xml/parsers/ParserConfigurationException:printStackTrace	()V
    //   1307: aconst_null
    //   1308: areturn
    //   1309: astore_1
    //   1310: aload_1
    //   1311: invokevirtual 1052	org/xml/sax/SAXException:printStackTrace	()V
    //   1314: goto -7 -> 1307
    //   1317: astore_1
    //   1318: aload_1
    //   1319: invokevirtual 1053	java/io/IOException:printStackTrace	()V
    //   1322: goto -15 -> 1307
    //   1325: astore_1
    //   1326: aload_1
    //   1327: invokevirtual 458	java/lang/Exception:printStackTrace	()V
    //   1330: goto -23 -> 1307
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1333	0	this	aova
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
      byte[] arrayOfByte = amsl.a((byte[])localObject);
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
        localObject2 = amsl.a((byte[])localObject1);
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
    //   0: getstatic 1170	cooperation/readinjoy/content/ReadInJoyDataProvider:e	Landroid/net/Uri;
    //   3: invokevirtual 1176	android/net/Uri:buildUpon	()Landroid/net/Uri$Builder;
    //   6: astore 5
    //   8: aload 5
    //   10: ldc_w 1178
    //   13: getstatic 15	aova:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   16: invokevirtual 1184	android/net/Uri$Builder:appendQueryParameter	(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;
    //   19: pop
    //   20: aload 5
    //   22: invokevirtual 1188	android/net/Uri$Builder:build	()Landroid/net/Uri;
    //   25: astore 5
    //   27: new 1190	android/content/ContentValues
    //   30: dup
    //   31: invokespecial 1191	android/content/ContentValues:<init>	()V
    //   34: astore 6
    //   36: aload 6
    //   38: ldc_w 1193
    //   41: iload_1
    //   42: invokestatic 305	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   45: invokevirtual 1197	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   48: aload 6
    //   50: ldc_w 1199
    //   53: aload_2
    //   54: invokevirtual 1202	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   57: aload 6
    //   59: ldc_w 1204
    //   62: aload_3
    //   63: invokevirtual 1202	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   66: ldc_w 1206
    //   69: iconst_2
    //   70: anewarray 301	java/lang/Object
    //   73: dup
    //   74: iconst_0
    //   75: ldc_w 1199
    //   78: aastore
    //   79: dup
    //   80: iconst_1
    //   81: aload_2
    //   82: aastore
    //   83: invokestatic 309	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   86: astore_2
    //   87: aload 4
    //   89: invokevirtual 65	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   92: invokevirtual 1210	com/tencent/qphone/base/util/BaseApplication:getContentResolver	()Landroid/content/ContentResolver;
    //   95: aload 5
    //   97: aconst_null
    //   98: aload_2
    //   99: aconst_null
    //   100: aconst_null
    //   101: invokevirtual 1216	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   104: astore_2
    //   105: aload_2
    //   106: ifnull +148 -> 254
    //   109: aload_2
    //   110: invokeinterface 1221 1 0
    //   115: ifle +61 -> 176
    //   118: aload 4
    //   120: invokevirtual 65	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   123: invokevirtual 1210	com/tencent/qphone/base/util/BaseApplication:getContentResolver	()Landroid/content/ContentResolver;
    //   126: aload 5
    //   128: aload 6
    //   130: aconst_null
    //   131: aconst_null
    //   132: invokevirtual 1225	android/content/ContentResolver:update	(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   135: pop
    //   136: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   139: ifeq +12 -> 151
    //   142: ldc 183
    //   144: iconst_2
    //   145: ldc_w 1227
    //   148: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   151: aload 4
    //   153: invokevirtual 65	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   156: invokevirtual 1210	com/tencent/qphone/base/util/BaseApplication:getContentResolver	()Landroid/content/ContentResolver;
    //   159: aload 5
    //   161: aconst_null
    //   162: invokevirtual 1231	android/content/ContentResolver:notifyChange	(Landroid/net/Uri;Landroid/database/ContentObserver;)V
    //   165: aload_2
    //   166: ifnull +9 -> 175
    //   169: aload_2
    //   170: invokeinterface 1232 1 0
    //   175: return
    //   176: aload 4
    //   178: invokevirtual 65	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   181: invokevirtual 1210	com/tencent/qphone/base/util/BaseApplication:getContentResolver	()Landroid/content/ContentResolver;
    //   184: aload 5
    //   186: aload 6
    //   188: invokevirtual 1236	android/content/ContentResolver:insert	(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    //   191: pop
    //   192: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   195: ifeq -44 -> 151
    //   198: ldc 183
    //   200: iconst_2
    //   201: ldc_w 1238
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
    //   227: ldc_w 1240
    //   230: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   233: aload_3
    //   234: invokevirtual 798	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   237: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   240: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   243: aload_2
    //   244: ifnull -69 -> 175
    //   247: aload_2
    //   248: invokeinterface 1232 1 0
    //   253: return
    //   254: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   257: ifeq -106 -> 151
    //   260: ldc 183
    //   262: iconst_2
    //   263: ldc_w 1242
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
    //   284: invokeinterface 1232 1 0
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
    //   0	313	0	this	aova
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
    NewIntent localNewIntent = new NewIntent(paramQQAppInterface.getApp(), aova.class);
    localNewIntent.putExtra("k_cmd_type", new int[] { paramInt });
    if (!bdje.a(paramString)) {
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
            if (aogj.a().b(i1))
            {
              localObject2 = aogj.a();
              localObject7 = ((aogj)localObject2).a(i1);
              i = j;
              if (localObject7 != null)
              {
                i = ((aofy)localObject7).b(((aogj)localObject2).a(i1, jdField_a_of_type_JavaLangString));
                bool = ((aogj)localObject2).a(paramQQAppInterface, i1);
                if (bool)
                {
                  ((aogj)localObject2).a(i1, 0);
                  i = 0;
                }
                if (QLog.isColorLevel()) {
                  QLog.d("QConfigManager", 2, "[Send] t=" + i1 + " v=" + i + " up=" + bool);
                }
                localConfigSeq.version.set(i);
                if (!((aogj)localObject2).a(i1)) {
                  break label9291;
                }
                localConfigSeq.compress.set(1);
                break label9291;
              }
            }
            if (i == 0) {
              paramQQAppInterface.a().a(localConfigSeq, paramQQAppInterface, i1);
            }
          }
          catch (Exception localException2)
          {
            Object localObject2;
            label1617:
            String str;
            long l;
            int m;
            label3482:
            int i2;
            QLog.d("QConfigManager", 1, "exception " + i1, localException2);
            continue;
          }
          localArrayList1.add(localConfigSeq);
          localArrayList2.add(Integer.valueOf(i1));
          k += 1;
          break;
          localConfigSeq.version.set(bdiv.c(paramQQAppInterface.getApp()));
          continue;
          localConfigSeq.version.set(bdiv.g(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
          continue;
          bdiv.a(paramQQAppInterface.getApplication(), paramQQAppInterface.getCurrentAccountUin());
          if (paramQQAppInterface.getCurrentAccountUin() != null)
          {
            jdField_b_of_type_JavaLangString = paramQQAppInterface.getCurrentNickname();
            localObject2 = bcyw.a(paramQQAppInterface, paramQQAppInterface.getCurrentAccountUin());
            if (localObject2 != null)
            {
              if (QLog.isColorLevel()) {
                QLog.i("SPLASH_ConfigServlet_birth", 2, "card!=null");
              }
              j = (int)((Card)localObject2).lBirthday;
              i = aywf.b(j);
              j = aywf.c(j);
              bdiv.b(paramQQAppInterface.getApp(), a(i, j));
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
            localConfigSeq.version.set(bdiv.h(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
            continue;
            localObject2 = (aovk)paramQQAppInterface.getManager(74);
            localConfigSeq.version.set(((aovk)localObject2).a());
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
            localConfigSeq.version.set(bdiv.i(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin()));
            continue;
            localConfigSeq.version.set(bdiv.j(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin()));
            continue;
            localConfigSeq.version.set(bdiv.b(paramQQAppInterface.getApp()));
            continue;
            localConfigSeq.version.set(PatchSharedPreUtil.getPatchConfigVersion(paramQQAppInterface.getApp()));
            localConfigSeq.compress.set(1);
            continue;
            BridgeHelper.a(BaseApplication.getContext(), jdField_a_of_type_JavaLangString).a();
            localConfigSeq.version.set(bdiv.a(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount()));
            continue;
            i = aowf.a(BaseApplicationImpl.getContext());
            if (SettingCloneUtil.readValueForInt(BaseApplicationImpl.getContext(), jdField_a_of_type_JavaLangString, null, "qqsetting_calltab_show_key_version", 0) < i)
            {
              localConfigSeq.version.set(0);
            }
            else
            {
              localConfigSeq.version.set(bdiv.l(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount()));
              continue;
              i = aowf.a(BaseApplicationImpl.getContext());
              if (SettingCloneUtil.readValueForInt(BaseApplicationImpl.getContext(), jdField_a_of_type_JavaLangString, null, "qqsetting_calltab_show_key_version", 0) < i)
              {
                localConfigSeq.version.set(0);
                paramIntent.putExtra("update101Version", i);
              }
              else
              {
                localConfigSeq.version.set(bdiv.k(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount()));
                continue;
                localObject2 = (alud)paramQQAppInterface.getManager(102);
                localConfigSeq.version.set(((alud)localObject2).a());
                continue;
                localConfigSeq.version.set(bdiv.o(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
                continue;
                localConfigSeq.version.set(bdiv.p(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
                continue;
                localConfigSeq.version.set(bdiv.f(paramQQAppInterface.getApp()));
                continue;
                localConfigSeq.version.set(bdiv.q(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
                continue;
                localConfigSeq.version.set(bdiv.r(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
                continue;
                if (!PtvTemplateManager.a())
                {
                  localConfigSeq.version.set(0);
                }
                else
                {
                  localConfigSeq.version.set(bdiv.h(paramQQAppInterface.getApp()));
                  continue;
                  if (!PtvTemplateManager.b())
                  {
                    localConfigSeq.version.set(0);
                    localConfigSeq.compress.set(1);
                  }
                  else
                  {
                    localConfigSeq.version.set(bdiv.j(paramQQAppInterface.getApp()));
                    continue;
                    if (!axjt.a())
                    {
                      localConfigSeq.version.set(0);
                      localConfigSeq.compress.set(1);
                    }
                    else
                    {
                      localConfigSeq.version.set(bdiv.i(paramQQAppInterface.getApp()));
                      continue;
                      i = 0;
                      if (PtvTemplateManager.c()) {
                        i = bdiv.k(paramQQAppInterface.getApp());
                      }
                      localConfigSeq.version.set(i);
                      localConfigSeq.compress.set(1);
                      if (QLog.isDevelopLevel())
                      {
                        QLog.d("Doodle_Strokes_SPLASH_ConfigServlet", 4, String.format("个性笔触配置版本号[%s]", new Object[] { Integer.valueOf(i) }));
                        continue;
                        i = bdiv.F(paramQQAppInterface.getApp());
                        localConfigSeq.version.set(i);
                        localConfigSeq.compress.set(1);
                        if (QLog.isDevelopLevel())
                        {
                          QLog.d("QQSTORY_FOLLOW_CAPTURE_SPLASH_ConfigServlet", 4, String.format("日迹合拍版本号[%s]", new Object[] { Integer.valueOf(i) }));
                          continue;
                          i = bdiv.aQ(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
                          localConfigSeq.version.set(i);
                          localConfigSeq.compress.set(1);
                          if (QLog.isDevelopLevel())
                          {
                            QLog.d("QQSTORY_QUESTION_TAB_SPLASH_ConfigServlet", 4, String.format("日迹问答版本号[%s]", new Object[] { Integer.valueOf(i) }));
                            continue;
                            BusinessCommonConfig.getInstance(paramQQAppInterface).fillConfigVersion(i1, localConfigSeq);
                            continue;
                            localConfigSeq.version.set(bdiv.b(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount()));
                            continue;
                            localConfigSeq.version.set(bdiv.c(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount()));
                            continue;
                            localConfigSeq.version.set(bdiv.m(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
                            continue;
                            localConfigSeq.version.set(bdiv.n(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
                            continue;
                            localConfigSeq.version.set(bdiv.d(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
                            continue;
                            localConfigSeq.version.set(bdiv.F(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
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
                            bool = zvd.a();
                            if (QLog.isColorLevel()) {
                              QLog.d("SPLASH_ConfigServlet", 2, "addAllConfigs, support ble=" + bool);
                            }
                            if (bool)
                            {
                              localConfigSeq.version.set(bdiv.e(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
                              continue;
                              bool = zvd.a();
                              if (QLog.isColorLevel()) {
                                QLog.d("SPLASH_ConfigServlet", 2, "addAllConfigs, support ble=" + bool);
                              }
                              if (bool)
                              {
                                localConfigSeq.version.set(bdiv.f(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
                                continue;
                                localConfigSeq.version.set(bdiv.s(paramQQAppInterface.getApp()));
                                continue;
                                i = bdiv.x(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
                                j = AppSetting.a();
                                if (i != j)
                                {
                                  bdiv.i(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, 0);
                                  bdiv.k(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, j);
                                  SearchConfigManager.a(paramQQAppInterface, jdField_a_of_type_JavaLangString);
                                }
                                localConfigSeq.version.set(bdiv.w(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
                                continue;
                                localConfigSeq.version.set(bdiv.G(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
                                continue;
                                localConfigSeq.version.set(bdiv.g(paramQQAppInterface.getApp()));
                                localConfigSeq.compress.set(1);
                                continue;
                                localConfigSeq.version.set(bdiv.t(paramQQAppInterface.getApp()));
                                continue;
                                localConfigSeq.version.set(bdiv.u(paramQQAppInterface.getApp()));
                                continue;
                                localConfigSeq.version.set(bdiv.v(paramQQAppInterface.getApp()));
                                continue;
                                localConfigSeq.version.set(bdiv.w(paramQQAppInterface.getApp()));
                                continue;
                                localConfigSeq.version.set(bdiv.A(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
                                continue;
                                localConfigSeq.version.set(bdiv.K(paramQQAppInterface.getApp(), paramQQAppInterface.c()));
                                continue;
                                localConfigSeq.version.set(bdiv.x(paramQQAppInterface.getApp()));
                                continue;
                                i = bdiv.B(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
                                localConfigSeq.version.set(i);
                                continue;
                                localConfigSeq.version.set(((alro)paramQQAppInterface.getManager(159)).b());
                                continue;
                                i = bdiv.C(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
                                if (bdiv.y(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount()) != AppSetting.a()) {
                                  i = 0;
                                }
                                localConfigSeq.version.set(i);
                                continue;
                                localObject2 = (bhoy)paramQQAppInterface.a(146);
                                i = ((bhoy)localObject2).b(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
                                j = ((bhoy)localObject2).a(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
                                m = AppSetting.a();
                                if (j != m)
                                {
                                  i = 0;
                                  QLog.i("NCtr", 1, String.format("request NOTIFICATION_LIMIT_CONFIG localVersion: %d ,originalAppId:%d, currentAppId:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(m) }));
                                  localConfigSeq.version.set(i);
                                  continue;
                                  i = bdiv.au(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
                                  if (bdiv.av(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount()) != AppSetting.a()) {
                                    i = 0;
                                  }
                                  localConfigSeq.version.set(i);
                                  continue;
                                  i = bdiv.aw(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
                                  if (bdiv.ax(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount()) != AppSetting.a()) {
                                    i = 0;
                                  }
                                  localConfigSeq.version.set(i);
                                  continue;
                                  localObject1 = DeviceProfileManager.a(paramQQAppInterface);
                                  continue;
                                  localConfigSeq.version.set(bdiv.E(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
                                  continue;
                                  localConfigSeq.version.set(awjn.a(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
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
                                  localConfigSeq.version.set(bdiv.o(paramQQAppInterface.getApp()));
                                  continue;
                                  localConfigSeq.version.set(bdiv.p(paramQQAppInterface.getApp()));
                                  continue;
                                  localConfigSeq.version.set(bdiv.L(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin()));
                                  continue;
                                  localConfigSeq.version.set(bdiv.O(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
                                  continue;
                                  localConfigSeq.version.set(bdiv.J(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin()));
                                  continue;
                                  localConfigSeq.version.set(bdiv.a(paramQQAppInterface.getApp(), "shop_tab", jdField_a_of_type_JavaLangString));
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
                                  if (!avxz.a(BaseApplicationImpl.getContext(), "olympic_config_act_get")) {
                                    continue;
                                  }
                                  if (QLog.isColorLevel()) {
                                    QLog.d("Olympic.configServlet", 2, new Object[] { "check24Hour, result=true, do Report, key=", "olympic_config_act_get" });
                                  }
                                  azmz.a(BaseApplicationImpl.getContext()).a("", "olympic_config_act_get", true, 0L, 0L, null, "", false);
                                  avxz.a(BaseApplicationImpl.getContext(), "olympic_config_act_get");
                                  continue;
                                  localObject2 = (amsx)paramQQAppInterface.getManager(168);
                                  if (localObject2 == null) {
                                    continue;
                                  }
                                  i2 = ((amsx)localObject2).b();
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
            m = ((amsx)localObject2).a();
            if ((m == 0) || (i3 != m)) {
              break label9297;
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
          Object localObject3 = (amnv)paramQQAppInterface.getManager(220);
          if (localObject3 == null) {
            break;
          }
          i = ((amnv)localObject3).b();
          if (QLog.isColorLevel()) {
            QLog.d("handleResp_GetArGlobalConfig", 2, " local version = " + i);
          }
          if (((amnv)localObject3).a()) {
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
          localObject3 = (amnv)paramQQAppInterface.getManager(220);
          if (localObject3 == null) {
            break;
          }
          i = ((amnv)localObject3).c();
          localConfigSeq.version.set(i);
          localConfigSeq.compress.set(1);
          paramIntent.putExtra("ar_scan_star_face_config_version", i);
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("SPLASH_ConfigServlet", 2, " get AR_SCAN_STAR_FACE_CONFIG, version = " + i);
          break;
          i = amtb.a(paramQQAppInterface);
          localConfigSeq.version.set(i);
          localConfigSeq.compress.set(1);
          paramIntent.putExtra("key_download_cfg_version", i);
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("SPLASH_ConfigServlet", 2, " get AR_SCAN_FACE_PRE_DOWN_CONFIG, version = " + i);
          break;
          localObject3 = (amsx)paramQQAppInterface.getManager(168);
          if (localObject3 == null) {
            break;
          }
          i = ((amsx)localObject3).c();
          localConfigSeq.version.set(i);
          localConfigSeq.compress.set(1);
          paramIntent.putExtra("key_ar_entrance_effect_version", i);
          break;
          i = bdiv.a(paramQQAppInterface.getApp(), "readinjoy_interested_push_config", jdField_a_of_type_JavaLangString);
          localConfigSeq.version.set(i);
          break;
          localObject3 = (PhoneContactManagerImp)paramQQAppInterface.getManager(11);
          localConfigSeq.version.set(((PhoneContactManagerImp)localObject3).f());
          break;
          lfa.a(i1, jdField_a_of_type_JavaLangString, localConfigSeq);
          break;
          i = anwv.a(BaseApplicationImpl.getContext());
          localConfigSeq.version.set(i);
          localConfigSeq.compress.set(1);
          paramIntent.putExtra("qcamera_conf_version", i);
          paramIntent.putExtra("uin", paramQQAppInterface.getCurrentAccountUin());
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.i("Q.camera.configServlet", 2, "request QCAMERA_PHONE_CONFIG version: " + i);
          break;
          i = bdiv.a(paramQQAppInterface.getApp(), "change_machine_version", jdField_a_of_type_JavaLangString);
          localConfigSeq.version.set(i);
          break;
          i = bdiv.H(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
          if (QLog.isColorLevel()) {
            QLog.d("SPLASH_ConfigServlet", 2, "addAllConfigs|GET_CONFIG_UPGRADE version=" + i);
          }
          localConfigSeq.version.set(i);
          paramQQAppInterface.o();
          bfio.a(paramQQAppInterface.getApp(), String.valueOf(AppSetting.a()));
          ((allq)paramQQAppInterface.a(4)).b();
          break;
          i = bdiv.I(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
          localConfigSeq.version.set(i);
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("UpgradeTIMWrapper", 2, "ConfigServlet req :193, version: " + i);
          break;
          i = bdiv.a(paramQQAppInterface.getApp(), "now_entrance_action_version", jdField_a_of_type_JavaLangString);
          localConfigSeq.version.set(i);
          break;
          i = bdiv.a(paramQQAppInterface.getApp(), "troop_common_config_version", jdField_a_of_type_JavaLangString);
          localConfigSeq.version.set(i);
          break;
          i = bdiv.a(paramQQAppInterface.getApp(), "nearby_config_version", jdField_a_of_type_JavaLangString);
          localConfigSeq.version.set(i);
          break;
          i = bdiv.a(paramQQAppInterface.getApp(), "nearby_nowlive_tab_config_version", jdField_a_of_type_JavaLangString);
          localConfigSeq.version.set(i);
          break;
          localConfigSeq.version.set(bdiv.P(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount()));
          localConfigSeq.compress.set(1);
          break;
          localObject3 = (aljv)paramQQAppInterface.a(53);
          if (localObject3 == null) {
            break;
          }
          i = AppSetting.a();
          if (i != ((aljv)localObject3).b(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString))
          {
            ((aljv)localObject3).a(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, 0);
            ((aljv)localObject3).b(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, i);
            ((aljv)localObject3).a(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, true);
            ((aljv)localObject3).c();
          }
          localConfigSeq.version.set(((aljv)localObject3).a(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
          break;
          localConfigSeq.version.set(bdiv.R(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
          localConfigSeq.version.set(bdiv.S(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
          localConfigSeq.compress.set(1);
          break;
          localConfigSeq.version.set(bdiv.D(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
          break;
          localConfigSeq.version.set(ayra.a());
          break;
          i = aydn.a(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin());
          localConfigSeq.version.set(i);
          break;
          i = bdiv.a(paramQQAppInterface.getApp(), "nearby_glamour_level_config_version", jdField_a_of_type_JavaLangString);
          localConfigSeq.version.set(i);
          localConfigSeq.compress.set(1);
          break;
          localConfigSeq.version.set(bdiv.U(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
          break;
          if (bdiv.a(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, 1) != AppSetting.a())
          {
            bdiv.d(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, 1, AppSetting.a());
            bdiv.d(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, 2, 0);
            localConfigSeq.version.set(0);
            break;
          }
          localConfigSeq.version.set(bdiv.a(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, 2));
          break;
          try
          {
            if (((Integer)bdiv.a(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, 1)).intValue() == AppSetting.a()) {
              break label5561;
            }
            bdiv.a(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, 1, Integer.valueOf(AppSetting.a()));
            bdiv.a(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, 2, Integer.valueOf(0));
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
        label5561:
        i = ((Integer)bdiv.a(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, 2)).intValue();
        localConfigSeq.version.set(i);
        break;
        localConfigSeq.version.set(bdiv.X(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
        break;
        if (!PtvTemplateManager.d()) {
          localConfigSeq.version.set(0);
        }
        for (;;)
        {
          localConfigSeq.compress.set(1);
          break;
          localConfigSeq.version.set(bdiv.m(paramQQAppInterface.getApp()));
        }
        localConfigSeq.version.set(bdiv.V(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
        break;
        localConfigSeq.version.set(bdiv.ab(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
        localConfigSeq.compress.set(1);
        break;
        localConfigSeq.version.set(bdiv.ad(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
        localConfigSeq.compress.set(1);
        break;
        Object localObject4 = (xlf)paramQQAppInterface.getManager(208);
        localConfigSeq.version.set(((xlf)localObject4).a.a(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
        break;
        localConfigSeq.version.set(bdiv.Z(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
        localConfigSeq.compress.set(1);
        break;
        localConfigSeq.version.set(swy.c(paramQQAppInterface));
        break;
        localConfigSeq.version.set(bdiv.aa(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
        break;
        i = bdiv.al(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
        j = AppSetting.a();
        if (i != j)
        {
          bdiv.J(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, 0);
          bdiv.K(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, j);
        }
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("SPLASH_ConfigServlet", 2, "[Doutu]onsend : appIdRecord = " + i + ", appId = " + j + ", DOUTU_CONFI version = " + bdiv.ai(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
          }
          localConfigSeq.version.set(bdiv.ai(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
          localConfigSeq.compress.set(1);
          break;
          localObject4 = (apfp)getAppRuntime().getManager(214);
          if (localObject4 != null) {
            ((apfp)localObject4).b(false);
          }
        }
        i = bdiv.s(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
        j = AppSetting.a();
        if (i != j)
        {
          bdiv.f(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, 0);
          bdiv.e(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, j);
        }
        if (QLog.isColorLevel()) {
          QLog.d("SPLASH_ConfigServlet", 2, "[GreenVideo]onsend : appIdRecord = " + i + ", appId = " + j + ", GREEN_VIDEO_CONFI version = " + bdiv.t(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
        }
        localConfigSeq.version.set(bdiv.t(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
        localConfigSeq.compress.set(1);
        break;
        i = bdiv.u(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
        j = AppSetting.a();
        if (i != j)
        {
          bdiv.h(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, 0);
          bdiv.g(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, j);
        }
        if (QLog.isColorLevel()) {
          QLog.d("SPLASH_ConfigServlet", 2, "[VideoCompress]onsend : appIdRecord = " + i + ", appId = " + j + ", VIDEO_REDBAG_CONFI version = " + bdiv.an(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
        }
        localConfigSeq.version.set(bdiv.v(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
        localConfigSeq.compress.set(1);
        break;
        if (((Integer)aush.a(jdField_a_of_type_JavaLangString, "key_app_id", Integer.valueOf(0))).intValue() != AppSetting.a())
        {
          aush.a(jdField_a_of_type_JavaLangString, "key_tabs_config_version", Integer.valueOf(0));
          aush.a(jdField_a_of_type_JavaLangString, "key_app_id", Integer.valueOf(AppSetting.a()));
        }
        i = ((Integer)aush.a(jdField_a_of_type_JavaLangString, "key_tabs_config_version", Integer.valueOf(0))).intValue();
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
        i = yqi.a(jdField_a_of_type_JavaLangString);
        localConfigSeq.version.set(i);
        localConfigSeq.compress.set(1);
        break;
        localConfigSeq.version.set(azwd.a(paramQQAppInterface));
        localConfigSeq.compress.set(1);
        break;
        localConfigSeq.version.set(bdiv.ag(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
        localConfigSeq.compress.set(1);
        break;
        localConfigSeq.version.set(bdiv.ac(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
        localConfigSeq.compress.set(1);
        break;
        localConfigSeq.version.set(aggh.a(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
        localConfigSeq.compress.set(1);
        break;
        i = bdiv.a(paramQQAppInterface.getApp(), "change_machine_version", jdField_a_of_type_JavaLangString);
        localConfigSeq.version.set(i);
        break;
        i = bdiv.a(paramQQAppInterface.getApp(), "nearby_auth_video_config_version", jdField_a_of_type_JavaLangString);
        localConfigSeq.version.set(i);
        break;
        localConfigSeq.version.set(bdiv.aq(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
        break;
        localConfigSeq.version.set(bdiv.z(paramQQAppInterface.getApp()));
        break;
        localConfigSeq.version.set(bdiv.ar(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
        break;
        localConfigSeq.version.set(ajog.a(paramQQAppInterface.getApp()));
        localConfigSeq.compress.set(1);
        break;
        localConfigSeq.version.set(axkd.a(paramQQAppInterface.getApp()));
        localConfigSeq.compress.set(1);
        break;
        a((ConfigurationService.ReqGetConfig)localObject1, localConfigSeq, paramQQAppInterface);
        break;
        i = bdiv.a(paramQQAppInterface.getApp(), "search_function_config_version", jdField_a_of_type_JavaLangString);
        localConfigSeq.version.set(i);
        localConfigSeq.compress.set(1);
        break;
        i = ((avqz)paramQQAppInterface.getManager(228)).a();
        localConfigSeq.version.set(i);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("SPLASH_ConfigServlet", 2, "ConfigServlet OCR_CONFIG ocrVersion:" + i);
        break;
        i = bdiv.at(BaseApplicationImpl.getContext(), jdField_a_of_type_JavaLangString);
        localConfigSeq.version.set(i);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("SPLASH_ConfigServlet", 2, "ConfigServlet receipt ,receiptVersion:" + i);
        break;
        i = bdiv.aX(BaseApplicationImpl.getContext(), jdField_a_of_type_JavaLangString);
        localConfigSeq.version.set(i);
        break;
        i = bdiv.aY(BaseApplicationImpl.getContext(), jdField_a_of_type_JavaLangString);
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
        ajql.a(paramQQAppInterface, localConfigSeq, true, jdField_a_of_type_JavaLangString);
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
        localObject4 = (apwx)paramQQAppInterface.getManager(264);
        try
        {
          ((apwx)localObject4).a();
        }
        catch (Exception localException1)
        {
          QLog.e("SPLASH_ConfigServlet", 1, "get local extend friend exception:", localException1);
        }
      }
      break label1617;
      i = bdiv.d(paramQQAppInterface.getApp());
      localConfigSeq.version.set(i);
      break label1617;
      i = paramQQAppInterface.getPreferences().getInt("tim_aio_tips_bar_version", 0);
      localConfigSeq.version.set(i);
      localConfigSeq.compress.set(1);
      break label1617;
      i = azex.a(paramQQAppInterface.getApp());
      localConfigSeq.version.set(i);
      localConfigSeq.compress.set(1);
      break label1617;
      i = paramQQAppInterface.getPreferences().getInt("data_migration_tim_version", 0);
      localConfigSeq.version.set(i);
      localConfigSeq.compress.set(1);
      break label1617;
      i = bdiv.a(paramQQAppInterface.getApp(), "nearby_videochat_dialog_config_version", jdField_a_of_type_JavaLangString);
      localConfigSeq.version.set(i);
      break label1617;
      i = bdiv.a(paramQQAppInterface.getApp(), "nearby_videochat_banner_config_version", jdField_a_of_type_JavaLangString);
      localConfigSeq.version.set(i);
      break label1617;
      i = paramQQAppInterface.getPreferences().getInt("zhitu_config_version", 0);
      localConfigSeq.version.set(i);
      localConfigSeq.compress.set(1);
      break label1617;
      i = paramQQAppInterface.getPreferences().getInt("homework_troop_config_version", 0);
      localConfigSeq.version.set(i);
      localConfigSeq.compress.set(1);
      break label1617;
      Object localObject5 = (TroopManager)paramQQAppInterface.getManager(52);
      localConfigSeq.version.set(((TroopManager)localObject5).jdField_a_of_type_Bbuv.a(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
      localConfigSeq.compress.set(1);
      break label1617;
      i = paramQQAppInterface.getPreferences().getInt("new_troop_recommend", 0);
      localConfigSeq.version.set(i);
      localConfigSeq.compress.set(1);
      break label1617;
      localObject5 = (TroopManager)paramQQAppInterface.getManager(52);
      localConfigSeq.version.set(((TroopManager)localObject5).jdField_a_of_type_Bbwz.a(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
      localConfigSeq.compress.set(1);
      break label1617;
      i = RecentDanceConfigMgr.a();
      localConfigSeq.version.set(i);
      localConfigSeq.compress.set(1);
      break label1617;
      i = asmt.a().a.a();
      localConfigSeq.version.set(i);
      localConfigSeq.compress.set(1);
      break label1617;
      i = LightVideoConfigMgr.a();
      localConfigSeq.version.set(i);
      localConfigSeq.compress.set(1);
      break label1617;
      localConfigSeq.version.set(bdiv.a(paramQQAppInterface.getApp(), "sport_config", jdField_a_of_type_JavaLangString));
      localConfigSeq.compress.set(1);
      break label1617;
      i = bdiv.a(paramQQAppInterface.getApplication(), "troop_gift_anim_limit", "0");
      localConfigSeq.version.set(i);
      break label1617;
      localConfigSeq.version.set(0);
      localConfigSeq.compress.set(1);
      break label1617;
      i = paramQQAppInterface.getPreferences().getInt("task_entry_config_version", 0);
      localConfigSeq.version.set(i);
      localConfigSeq.compress.set(1);
      break label1617;
      i = paramQQAppInterface.getPreferences().getInt("qzone_xp_config_version", 0);
      localConfigSeq.version.set(i);
      break label1617;
      i = paramQQAppInterface.getPreferences().getInt("buluo_enter_config_version" + paramQQAppInterface.c(), 0);
      localConfigSeq.version.set(i);
      localConfigSeq.compress.set(1);
      break label1617;
      localConfigSeq.version.set(bdiv.aD(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
      break label1617;
      i = bdiv.aF(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
      if (bdiv.aG(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount()) != AppSetting.a()) {
        i = 0;
      }
      localConfigSeq.version.set(i);
      break label1617;
      i = bngq.a().a(paramQQAppInterface.getApp());
      localConfigSeq.version.set(i);
      localConfigSeq.compress.set(1);
      break label1617;
      i = bnky.a().a(paramQQAppInterface.getApp());
      localConfigSeq.version.set(i);
      localConfigSeq.compress.set(1);
      break label1617;
      localObject5 = (uhl)paramQQAppInterface.getManager(181);
      localConfigSeq.version.set(((uhl)localObject5).a.a(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
      localConfigSeq.compress.set(1);
      break label1617;
      localConfigSeq.version.set(bdiv.a());
      localConfigSeq.compress.set(1);
      break label1617;
      i = bdiv.aI(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
      if (bdiv.aJ(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount()) != AppSetting.a()) {
        i = 0;
      }
      localConfigSeq.version.set(i);
      break label1617;
      localConfigSeq.version.set(bdiv.Q(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount()));
      localConfigSeq.compress.set(1);
      break label1617;
      i = bdiv.a(paramQQAppInterface.getApp(), "wifi_connect_config_version", jdField_a_of_type_JavaLangString);
      localConfigSeq.version.set(i);
      break label1617;
      localObject5 = (TroopManager)paramQQAppInterface.getManager(52);
      localConfigSeq.version.set(((TroopManager)localObject5).jdField_a_of_type_Yqe.a(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
      localConfigSeq.compress.set(1);
      break label1617;
      i = bdiv.aR(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
      localConfigSeq.version.set(i);
      break label1617;
      localConfigSeq.version.set(bdiv.az(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
      localConfigSeq.compress.set(1);
      break label1617;
      i = bdiv.aU(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
      if (bdiv.aV(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount()) != AppSetting.a()) {
        i = 0;
      }
      localConfigSeq.version.set(i);
      break label1617;
      i = bddr.a();
      localConfigSeq.version.set(i);
      localConfigSeq.compress.set(1);
      if (!QLog.isColorLevel()) {
        break label1617;
      }
      QLog.i("JumpForwardPkgManager", 2, "JUMP_PKG_TOAST_CONFIG  ,version:" + i);
      break label1617;
      i = bjxi.a(paramQQAppInterface);
      localConfigSeq.version.set(i);
      localConfigSeq.compress.set(1);
      break label1617;
      i = agug.a(paramQQAppInterface);
      localConfigSeq.version.set(i);
      localConfigSeq.compress.set(1);
      break label1617;
      localConfigSeq.version.set(((Integer)bdiv.a(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin(), "config_tim_team_version_code", Integer.valueOf(0))).intValue());
      break label1617;
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
        ((ConfigurationService.Screen)localObject7).width.set((int)bdcb.i());
        ((ConfigurationService.Screen)localObject7).height.set((int)bdcb.j());
        ((ConfigurationService.DeviceInfo)localObject6).screen = ((ConfigurationService.Screen)localObject7);
        ((ConfigurationService.DeviceInfo)localObject6).setHasFlag(true);
        ((ConfigurationService.ReqGetConfig)localObject1).device_info = ((ConfigurationService.DeviceInfo)localObject6);
      }
      if ((localArrayList2.contains(Integer.valueOf(47))) || (localArrayList2.contains(Integer.valueOf(65))) || (localArrayList2.contains(Integer.valueOf(156))) || (localArrayList2.contains(Integer.valueOf(297))))
      {
        localObject7 = new ConfigurationService.OS();
        ((ConfigurationService.OS)localObject7).setHasFlag(true);
        ((ConfigurationService.OS)localObject7).type.set(2);
        ((ConfigurationService.OS)localObject7).kernel.set(bdcb.m());
        ((ConfigurationService.OS)localObject7).sdk.set(String.valueOf(bdcb.a()));
        ((ConfigurationService.OS)localObject7).version.set(bdcb.e());
        ((ConfigurationService.OS)localObject7).rom.set(bdcb.j());
        ((ConfigurationService.DeviceInfo)localObject6).brand.set(bdcb.h());
        ((ConfigurationService.DeviceInfo)localObject6).model.set(bdcb.d());
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
          break label9273;
        }
      }
      label9273:
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
      break label3482;
      label9291:
      i = 1;
      break;
      label9297:
      i = 1;
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig, int paramInt)
  {
    int i = paramConfig.version.get();
    int j = bjxi.a(paramQQAppInterface);
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
      bjxi.a(paramQQAppInterface, new JSONObject(paramConfig).optInt("hot_video_enable", 0));
      bjxi.b(paramQQAppInterface, i);
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
    NewIntent localNewIntent = new NewIntent(paramQQAppInterface.getApp(), aova.class);
    int[] arrayOfInt = new int[jdField_a_of_type_ArrayOfInt.length + aogj.jdField_a_of_type_ArrayOfInt.length];
    System.arraycopy(jdField_a_of_type_ArrayOfInt, 0, arrayOfInt, 0, jdField_a_of_type_ArrayOfInt.length);
    System.arraycopy(aogj.jdField_a_of_type_ArrayOfInt, 0, arrayOfInt, jdField_a_of_type_ArrayOfInt.length, aogj.jdField_a_of_type_ArrayOfInt.length);
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
        if ((paramInt == -1) || (bdiv.s(paramQQAppInterface.getApp()) != paramInt)) {
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
    //   4: getstatic 15	aova:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   7: invokestatic 2327	bdiv:aj	(Landroid/content/Context;Ljava/lang/String;)I
    //   10: invokestatic 203	com/tencent/common/config/AppSetting:a	()I
    //   13: if_icmpeq +114 -> 127
    //   16: aload_3
    //   17: invokevirtual 65	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   20: getstatic 15	aova:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   23: invokestatic 203	com/tencent/common/config/AppSetting:a	()I
    //   26: invokestatic 2329	bdiv:H	(Landroid/content/Context;Ljava/lang/String;I)V
    //   29: aload_3
    //   30: invokevirtual 65	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   33: getstatic 15	aova:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   36: iconst_0
    //   37: invokestatic 2331	bdiv:I	(Landroid/content/Context;Ljava/lang/String;I)V
    //   40: iconst_0
    //   41: istore 4
    //   43: aload_2
    //   44: getfield 1327	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$ConfigSeq:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   47: iload 4
    //   49: invokevirtual 1294	com/tencent/mobileqq/pb/PBInt32Field:set	(I)V
    //   52: invokestatic 2333	bdcb:a	()Ljava/util/ArrayList;
    //   55: astore 5
    //   57: aload 5
    //   59: ifnull +119 -> 178
    //   62: aload 5
    //   64: invokevirtual 2334	java/util/ArrayList:size	()I
    //   67: ifle +111 -> 178
    //   70: aload 5
    //   72: invokevirtual 2335	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   75: astore_2
    //   76: aload_2
    //   77: invokeinterface 238 1 0
    //   82: ifeq +96 -> 178
    //   85: aload_2
    //   86: invokeinterface 242 1 0
    //   91: checkcast 139	java/lang/Integer
    //   94: astore 6
    //   96: aload_1
    //   97: getfield 2338	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$ReqGetConfig:carriers	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   100: aload 6
    //   102: invokevirtual 2341	com/tencent/mobileqq/pb/PBRepeatField:add	(Ljava/lang/Object;)V
    //   105: goto -29 -> 76
    //   108: astore_1
    //   109: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   112: ifeq +14 -> 126
    //   115: ldc_w 2343
    //   118: iconst_2
    //   119: ldc_w 2345
    //   122: aload_1
    //   123: invokestatic 1837	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   126: return
    //   127: aload_3
    //   128: invokevirtual 65	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   131: getstatic 15	aova:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   134: invokestatic 2347	bdiv:ak	(Landroid/content/Context;Ljava/lang/String;)I
    //   137: istore 4
    //   139: goto -96 -> 43
    //   142: astore_2
    //   143: ldc 183
    //   145: iconst_2
    //   146: new 85	java/lang/StringBuilder
    //   149: dup
    //   150: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   153: ldc_w 2349
    //   156: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: aload_2
    //   160: invokevirtual 863	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   163: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   169: invokestatic 642	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   172: aconst_null
    //   173: astore 5
    //   175: goto -118 -> 57
    //   178: aload_3
    //   179: bipush 11
    //   181: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   184: checkcast 2351	aubm
    //   187: invokeinterface 2354 1 0
    //   192: astore 6
    //   194: aload 6
    //   196: ifnull +229 -> 425
    //   199: aload 6
    //   201: getfield 2359	SecurityAccountServer/RespondQueryQQBindingStat:nationCode	Ljava/lang/String;
    //   204: astore_3
    //   205: aload_3
    //   206: astore_2
    //   207: aload_3
    //   208: ifnull +21 -> 229
    //   211: aload_3
    //   212: astore_2
    //   213: aload_3
    //   214: ldc_w 2361
    //   217: invokevirtual 2364	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   220: ifeq +9 -> 229
    //   223: aload_3
    //   224: iconst_1
    //   225: invokevirtual 2367	java/lang/String:substring	(I)Ljava/lang/String;
    //   228: astore_2
    //   229: aload_2
    //   230: invokestatic 126	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   233: ifeq +130 -> 363
    //   236: aload 6
    //   238: getfield 2370	SecurityAccountServer/RespondQueryQQBindingStat:mobileNo	Ljava/lang/String;
    //   241: invokestatic 126	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   244: ifeq +119 -> 363
    //   247: ldc 13
    //   249: astore_2
    //   250: aload_2
    //   251: invokestatic 126	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   254: ifne +11 -> 265
    //   257: aload_1
    //   258: getfield 2373	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$ReqGetConfig:bind_phone_no	Lcom/tencent/mobileqq/pb/PBStringField;
    //   261: aload_2
    //   262: invokevirtual 1410	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   265: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   268: ifeq -142 -> 126
    //   271: new 85	java/lang/StringBuilder
    //   274: dup
    //   275: bipush 100
    //   277: invokespecial 2374	java/lang/StringBuilder:<init>	(I)V
    //   280: astore_1
    //   281: aload_1
    //   282: ldc_w 2376
    //   285: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   288: iload 4
    //   290: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   293: ldc_w 2378
    //   296: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   299: aload_2
    //   300: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   303: pop
    //   304: aload_1
    //   305: ldc_w 2380
    //   308: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   311: pop
    //   312: aload 5
    //   314: ifnull +91 -> 405
    //   317: aload 5
    //   319: invokevirtual 2334	java/util/ArrayList:size	()I
    //   322: ifle +83 -> 405
    //   325: aload 5
    //   327: invokevirtual 2335	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   330: astore_2
    //   331: aload_2
    //   332: invokeinterface 238 1 0
    //   337: ifeq +68 -> 405
    //   340: aload_1
    //   341: aload_2
    //   342: invokeinterface 242 1 0
    //   347: checkcast 139	java/lang/Integer
    //   350: invokevirtual 798	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   353: ldc_w 2382
    //   356: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   359: pop
    //   360: goto -29 -> 331
    //   363: invokestatic 1086	java/util/Locale:getDefault	()Ljava/util/Locale;
    //   366: astore 7
    //   368: aload_2
    //   369: astore_3
    //   370: aload_2
    //   371: ifnonnull +6 -> 377
    //   374: ldc 13
    //   376: astore_3
    //   377: aload 7
    //   379: ldc_w 2384
    //   382: iconst_2
    //   383: anewarray 301	java/lang/Object
    //   386: dup
    //   387: iconst_0
    //   388: aload_3
    //   389: aastore
    //   390: dup
    //   391: iconst_1
    //   392: aload 6
    //   394: getfield 2370	SecurityAccountServer/RespondQueryQQBindingStat:mobileNo	Ljava/lang/String;
    //   397: aastore
    //   398: invokestatic 1091	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   401: astore_2
    //   402: goto -152 -> 250
    //   405: aload_1
    //   406: ldc_w 2220
    //   409: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   412: pop
    //   413: ldc_w 2343
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
    //   0	431	0	this	aova
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
    //   6: getfield 2392	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:result	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   9: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   12: ifne +20 -> 32
    //   15: aload_1
    //   16: getfield 2395	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:config_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   19: ifnull +13 -> 32
    //   22: aload_1
    //   23: getfield 2395	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:config_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   26: invokevirtual 224	com/tencent/mobileqq/pb/PBRepeatMessageField:size	()I
    //   29: ifne +2041 -> 2070
    //   32: iload 5
    //   34: ifne +434 -> 468
    //   37: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   40: ifeq +12 -> 52
    //   43: ldc 183
    //   45: iconst_2
    //   46: ldc_w 2397
    //   49: invokestatic 199	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   52: iconst_0
    //   53: istore 7
    //   55: iload 7
    //   57: aload 4
    //   59: arraylength
    //   60: if_icmpge +12179 -> 12239
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
    //   86: ldc_w 2399
    //   89: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: iload 9
    //   94: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   97: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   100: invokestatic 199	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   103: iload 9
    //   105: lookupswitch	default:+267->372, 46:+526->631, 69:+589->694, 86:+1006->1111, 87:+828->933, 88:+671->776, 113:+1215->1320, 116:+437->542, 119:+1192->1297, 140:+1363->1468, 149:+426->531, 156:+354->459, 165:+1552->1657, 174:+1629->1734, 180:+426->531, 185:+1720->1825, 188:+1273->1378, 202:+1774->1879, 206:+1318->1423, 210:+1820->1925, 215:+1876->1981, 218:+426->531, 223:+1257->1362, 231:+1889->1994, 255:+1906->2011, 257:+1462->1567, 260:+1507->1612, 273:+1674->1779, 283:+583->688, 321:+1729->1834, 364:+1257->1362, 365:+1257->1362, 604:+1597->1702
    //   373: istore 8
    //   375: iload 8
    //   377: istore 6
    //   379: invokestatic 1299	aogj:a	()Laogj;
    //   382: iload 9
    //   384: invokevirtual 1302	aogj:b	(I)Z
    //   387: ifeq +48 -> 435
    //   390: invokestatic 1299	aogj:a	()Laogj;
    //   393: iload 9
    //   395: invokevirtual 1305	aogj:a	(I)Laofy;
    //   398: astore_3
    //   399: iload 8
    //   401: istore 6
    //   403: aload_3
    //   404: ifnull +31 -> 435
    //   407: aload_1
    //   408: getfield 2392	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:result	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   411: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   414: ifeq +1639 -> 2053
    //   417: bipush 254
    //   419: istore 6
    //   421: iload 6
    //   423: ifeq +9 -> 432
    //   426: aload_3
    //   427: iload 6
    //   429: invokevirtual 2400	aofy:a	(I)V
    //   432: iconst_1
    //   433: istore 6
    //   435: iload 6
    //   437: ifne +22 -> 459
    //   440: aload_2
    //   441: invokevirtual 1334	com/tencent/mobileqq/app/QQAppInterface:a	()Laofo;
    //   444: aload_2
    //   445: iload 9
    //   447: iload 5
    //   449: aload_1
    //   450: getfield 2392	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:result	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   453: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   456: invokevirtual 2403	aofo:a	(Lcom/tencent/mobileqq/app/QQAppInterface;IZI)V
    //   459: iload 7
    //   461: iconst_1
    //   462: iadd
    //   463: istore 7
    //   465: goto -410 -> 55
    //   468: aload_1
    //   469: getfield 2392	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:result	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   472: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   475: ifeq +21 -> 496
    //   478: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   481: ifeq -429 -> 52
    //   484: ldc 183
    //   486: iconst_2
    //   487: ldc_w 2405
    //   490: invokestatic 199	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   493: goto -441 -> 52
    //   496: aload_1
    //   497: getfield 2395	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:config_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   500: ifnull +13 -> 513
    //   503: aload_1
    //   504: getfield 2395	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:config_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   507: invokevirtual 224	com/tencent/mobileqq/pb/PBRepeatMessageField:size	()I
    //   510: ifne -458 -> 52
    //   513: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   516: ifeq -464 -> 52
    //   519: ldc 183
    //   521: iconst_2
    //   522: ldc_w 2407
    //   525: invokestatic 199	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   528: goto -476 -> 52
    //   531: iload 9
    //   533: iload 5
    //   535: aload_1
    //   536: invokestatic 2410	lfa:a	(IZLcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig;)V
    //   539: goto -80 -> 459
    //   542: iload 5
    //   544: ifeq +13 -> 557
    //   547: aload_1
    //   548: getfield 2392	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:result	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   551: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   554: ifeq -95 -> 459
    //   557: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   560: ifeq +12 -> 572
    //   563: ldc 183
    //   565: iconst_2
    //   566: ldc_w 2412
    //   569: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   572: aload_0
    //   573: getfield 2414	aova:jdField_a_of_type_Boolean	Z
    //   576: ifne +35 -> 611
    //   579: aload_2
    //   580: ldc_w 2416
    //   583: ldc 13
    //   585: ldc 13
    //   587: ldc_w 2418
    //   590: ldc_w 2418
    //   593: iconst_0
    //   594: iconst_0
    //   595: ldc 13
    //   597: ldc 13
    //   599: ldc 13
    //   601: ldc 13
    //   603: invokestatic 2423	azmj:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   606: aload_0
    //   607: iconst_1
    //   608: putfield 2414	aova:jdField_a_of_type_Boolean	Z
    //   611: aload_2
    //   612: iconst_4
    //   613: invokevirtual 206	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lalko;
    //   616: checkcast 1781	allq
    //   619: invokestatic 2428	amlp:a	()Lamlp;
    //   622: invokevirtual 2431	amlp:a	()Lcom/tencent/mobileqq/app/upgrade/UpgradeDetailWrapper;
    //   625: invokevirtual 2434	allq:a	(Lcom/tencent/mobileqq/app/upgrade/UpgradeDetailWrapper;)V
    //   628: goto -169 -> 459
    //   631: aload_1
    //   632: getfield 2392	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:result	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   635: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   638: ifeq +26 -> 664
    //   641: getstatic 2438	com/tencent/common/app/BaseApplicationImpl:sApplication	Lcom/tencent/common/app/BaseApplicationImpl;
    //   644: aload_2
    //   645: invokevirtual 1592	com/tencent/mobileqq/app/QQAppInterface:c	()Ljava/lang/String;
    //   648: ldc_w 2440
    //   651: bipush 101
    //   653: ldc 13
    //   655: invokestatic 2446	com/tencent/mobileqq/msf/core/net/patch/PatchReporter:reportPatchEvent	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)V
    //   658: invokestatic 2449	zdi:c	()V
    //   661: goto -202 -> 459
    //   664: aload_1
    //   665: getfield 2395	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:config_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   668: ifnull +13 -> 681
    //   671: aload_1
    //   672: getfield 2395	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:config_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   675: invokevirtual 224	com/tencent/mobileqq/pb/PBRepeatMessageField:size	()I
    //   678: ifne -20 -> 658
    //   681: aload_2
    //   682: invokestatic 2452	aarj:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   685: goto -27 -> 658
    //   688: invokestatic 2449	zdi:c	()V
    //   691: goto -232 -> 459
    //   694: iload 5
    //   696: ifeq +13 -> 709
    //   699: aload_1
    //   700: getfield 2392	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:result	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   703: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   706: ifeq -247 -> 459
    //   709: aload_2
    //   710: bipush 125
    //   712: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   715: checkcast 2454	aipw
    //   718: astore_3
    //   719: aload_3
    //   720: iconst_1
    //   721: putfield 2455	aipw:jdField_b_of_type_Boolean	Z
    //   724: aload_3
    //   725: getstatic 2460	com/tencent/mobileqq/data/MessageForFoldMsgGrayTips:PASSWD_REDBAG_MSG_SWITCH_DEFAULT	Z
    //   728: putfield 2461	aipw:c	Z
    //   731: aload_3
    //   732: getstatic 2464	com/tencent/mobileqq/data/MessageForFoldMsgGrayTips:PASSWD_REDBAG_MSG_DISPLAY_NUM_DEFAULT	I
    //   735: putfield 2466	aipw:jdField_a_of_type_Int	I
    //   738: aload_3
    //   739: getstatic 2469	com/tencent/mobileqq/data/MessageForFoldMsgGrayTips:PASSWD_REDBAG_MSG_INDEX_WITH_ID	Z
    //   742: putfield 2471	aipw:e	Z
    //   745: aload_2
    //   746: invokevirtual 65	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   749: aload_2
    //   750: invokevirtual 69	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   753: iconst_0
    //   754: aload_3
    //   755: getfield 2461	aipw:c	Z
    //   758: aload_3
    //   759: getfield 2466	aipw:jdField_a_of_type_Int	I
    //   762: aload_3
    //   763: getfield 2473	aipw:d	Z
    //   766: aload_3
    //   767: getfield 2471	aipw:e	Z
    //   770: invokestatic 2476	bdiv:a	(Landroid/content/Context;Ljava/lang/String;IZIZZ)V
    //   773: goto -314 -> 459
    //   776: iload 5
    //   778: ifne +51 -> 829
    //   781: aload_2
    //   782: bipush 88
    //   784: iconst_0
    //   785: iconst_0
    //   786: iconst_1
    //   787: iconst_1
    //   788: iconst_0
    //   789: invokestatic 2481	com/tencent/mobileqq/olympic/OlympicServlet:a	(Lmqq/app/AppRuntime;IIIIII)V
    //   792: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   795: ifeq -336 -> 459
    //   798: ldc_w 1709
    //   801: iconst_2
    //   802: new 85	java/lang/StringBuilder
    //   805: dup
    //   806: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   809: ldc_w 2483
    //   812: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   815: iload 5
    //   817: invokevirtual 152	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   820: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   823: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   826: goto -367 -> 459
    //   829: aload_1
    //   830: getfield 2392	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:result	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   833: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   836: ifeq +61 -> 897
    //   839: aload_1
    //   840: getfield 2392	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:result	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   843: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   846: istore 6
    //   848: aload_2
    //   849: bipush 88
    //   851: iconst_0
    //   852: iconst_0
    //   853: iconst_1
    //   854: iload 6
    //   856: iconst_0
    //   857: invokestatic 2481	com/tencent/mobileqq/olympic/OlympicServlet:a	(Lmqq/app/AppRuntime;IIIIII)V
    //   860: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   863: ifeq -404 -> 459
    //   866: ldc_w 1709
    //   869: iconst_2
    //   870: new 85	java/lang/StringBuilder
    //   873: dup
    //   874: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   877: ldc_w 2485
    //   880: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   883: iload 6
    //   885: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   888: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   891: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   894: goto -435 -> 459
    //   897: aload_1
    //   898: getfield 2395	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:config_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   901: ifnull +13 -> 914
    //   904: aload_1
    //   905: getfield 2395	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:config_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   908: invokevirtual 224	com/tencent/mobileqq/pb/PBRepeatMessageField:size	()I
    //   911: ifne -452 -> 459
    //   914: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   917: ifeq -458 -> 459
    //   920: ldc_w 1709
    //   923: iconst_2
    //   924: ldc_w 2487
    //   927: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   930: goto -471 -> 459
    //   933: iload 5
    //   935: ifne +72 -> 1007
    //   938: aload_2
    //   939: bipush 87
    //   941: iconst_0
    //   942: iconst_0
    //   943: iconst_1
    //   944: iconst_1
    //   945: iconst_0
    //   946: invokestatic 2481	com/tencent/mobileqq/olympic/OlympicServlet:a	(Lmqq/app/AppRuntime;IIIIII)V
    //   949: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   952: ifeq +31 -> 983
    //   955: ldc_w 1709
    //   958: iconst_2
    //   959: new 85	java/lang/StringBuilder
    //   962: dup
    //   963: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   966: ldc_w 2489
    //   969: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   972: iload 5
    //   974: invokevirtual 152	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   977: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   980: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   983: aload_2
    //   984: sipush 168
    //   987: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   990: checkcast 1682	amsx
    //   993: astore_3
    //   994: aload_3
    //   995: ifnull -536 -> 459
    //   998: aload_3
    //   999: iconst_1
    //   1000: iconst_0
    //   1001: invokevirtual 2492	amsx:a	(ZZ)V
    //   1004: goto -545 -> 459
    //   1007: aload_1
    //   1008: getfield 2392	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:result	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   1011: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   1014: ifeq +61 -> 1075
    //   1017: aload_1
    //   1018: getfield 2392	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:result	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   1021: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   1024: istore 6
    //   1026: aload_2
    //   1027: bipush 87
    //   1029: iconst_0
    //   1030: iconst_0
    //   1031: iconst_1
    //   1032: iload 6
    //   1034: iconst_0
    //   1035: invokestatic 2481	com/tencent/mobileqq/olympic/OlympicServlet:a	(Lmqq/app/AppRuntime;IIIIII)V
    //   1038: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1041: ifeq -58 -> 983
    //   1044: ldc_w 1709
    //   1047: iconst_2
    //   1048: new 85	java/lang/StringBuilder
    //   1051: dup
    //   1052: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   1055: ldc_w 2494
    //   1058: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1061: iload 6
    //   1063: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1066: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1069: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1072: goto -89 -> 983
    //   1075: aload_1
    //   1076: getfield 2395	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:config_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   1079: ifnull +13 -> 1092
    //   1082: aload_1
    //   1083: getfield 2395	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:config_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   1086: invokevirtual 224	com/tencent/mobileqq/pb/PBRepeatMessageField:size	()I
    //   1089: ifne -106 -> 983
    //   1092: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1095: ifeq -112 -> 983
    //   1098: ldc_w 1709
    //   1101: iconst_2
    //   1102: ldc_w 2496
    //   1105: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1108: goto -125 -> 983
    //   1111: iload 5
    //   1113: ifne +77 -> 1190
    //   1116: aload_0
    //   1117: invokevirtual 47	aova:getAppRuntime	()Lmqq/app/AppRuntime;
    //   1120: bipush 86
    //   1122: iconst_0
    //   1123: iconst_0
    //   1124: iconst_1
    //   1125: iconst_1
    //   1126: iconst_0
    //   1127: invokestatic 2481	com/tencent/mobileqq/olympic/OlympicServlet:a	(Lmqq/app/AppRuntime;IIIIII)V
    //   1130: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1133: ifeq +31 -> 1164
    //   1136: ldc_w 1669
    //   1139: iconst_2
    //   1140: new 85	java/lang/StringBuilder
    //   1143: dup
    //   1144: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   1147: ldc_w 2498
    //   1150: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1153: iload 5
    //   1155: invokevirtual 152	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1158: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1161: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1164: aload_2
    //   1165: sipush 167
    //   1168: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   1171: checkcast 1645	com/tencent/mobileqq/olympic/OlympicManager
    //   1174: astore_3
    //   1175: aload_3
    //   1176: ifnull -717 -> 459
    //   1179: aload_3
    //   1180: invokevirtual 2500	com/tencent/mobileqq/olympic/OlympicManager:f	()V
    //   1183: aload_3
    //   1184: invokevirtual 2502	com/tencent/mobileqq/olympic/OlympicManager:g	()V
    //   1187: goto -728 -> 459
    //   1190: aload_1
    //   1191: getfield 2392	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:result	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   1194: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   1197: ifeq +64 -> 1261
    //   1200: aload_1
    //   1201: getfield 2392	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:result	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   1204: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   1207: istore 6
    //   1209: aload_0
    //   1210: invokevirtual 47	aova:getAppRuntime	()Lmqq/app/AppRuntime;
    //   1213: bipush 86
    //   1215: iconst_0
    //   1216: iconst_0
    //   1217: iconst_1
    //   1218: iload 6
    //   1220: iconst_0
    //   1221: invokestatic 2481	com/tencent/mobileqq/olympic/OlympicServlet:a	(Lmqq/app/AppRuntime;IIIIII)V
    //   1224: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1227: ifeq -63 -> 1164
    //   1230: ldc_w 1669
    //   1233: iconst_2
    //   1234: new 85	java/lang/StringBuilder
    //   1237: dup
    //   1238: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   1241: ldc_w 2504
    //   1244: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1247: iload 6
    //   1249: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1252: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1255: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1258: goto -94 -> 1164
    //   1261: aload_1
    //   1262: getfield 2395	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:config_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   1265: ifnull +13 -> 1278
    //   1268: aload_1
    //   1269: getfield 2395	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:config_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   1272: invokevirtual 224	com/tencent/mobileqq/pb/PBRepeatMessageField:size	()I
    //   1275: ifne -111 -> 1164
    //   1278: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1281: ifeq -117 -> 1164
    //   1284: ldc_w 1669
    //   1287: iconst_2
    //   1288: ldc_w 2506
    //   1291: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1294: goto -130 -> 1164
    //   1297: aload_2
    //   1298: bipush 53
    //   1300: invokevirtual 206	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lalko;
    //   1303: checkcast 1793	aljv
    //   1306: astore_3
    //   1307: aload_3
    //   1308: ifnull -849 -> 459
    //   1311: aload_3
    //   1312: iconst_0
    //   1313: iconst_0
    //   1314: invokevirtual 2507	aljv:a	(ZZ)V
    //   1317: goto -858 -> 459
    //   1320: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1323: ifeq +12 -> 1335
    //   1326: ldc 183
    //   1328: iconst_2
    //   1329: ldc_w 2509
    //   1332: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1335: aload_2
    //   1336: sipush 179
    //   1339: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   1342: checkcast 2511	awjh
    //   1345: astore_3
    //   1346: aload_3
    //   1347: ifnull -888 -> 459
    //   1350: aload_3
    //   1351: invokevirtual 2512	awjh:a	()V
    //   1354: aload_3
    //   1355: iconst_0
    //   1356: invokevirtual 2513	awjh:a	(Z)V
    //   1359: goto -900 -> 459
    //   1362: aload_2
    //   1363: invokestatic 1517	com/tencent/mobileqq/utils/BusinessCommonConfig:getInstance	(Lmqq/app/AppRuntime;)Lcom/tencent/mobileqq/utils/BusinessCommonConfig;
    //   1366: aload_2
    //   1367: iload 9
    //   1369: iload 5
    //   1371: aload_1
    //   1372: invokevirtual 2517	com/tencent/mobileqq/utils/BusinessCommonConfig:handleResp_Config_Fail	(Lcom/tencent/mobileqq/app/QQAppInterface;IZLcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig;)V
    //   1375: goto -916 -> 459
    //   1378: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1381: ifeq -922 -> 459
    //   1384: aload_1
    //   1385: getfield 2392	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:result	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   1388: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   1391: istore 6
    //   1393: ldc 183
    //   1395: iconst_2
    //   1396: new 85	java/lang/StringBuilder
    //   1399: dup
    //   1400: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   1403: ldc_w 2519
    //   1406: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1409: iload 6
    //   1411: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1414: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1417: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1420: goto -961 -> 459
    //   1423: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1426: ifeq -967 -> 459
    //   1429: aload_1
    //   1430: getfield 2392	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:result	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   1433: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   1436: istore 6
    //   1438: ldc 183
    //   1440: iconst_2
    //   1441: new 85	java/lang/StringBuilder
    //   1444: dup
    //   1445: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   1448: ldc_w 2521
    //   1451: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1454: iload 6
    //   1456: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1459: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1462: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1465: goto -1006 -> 459
    //   1468: aload_1
    //   1469: getfield 2392	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:result	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   1472: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   1475: istore 6
    //   1477: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1480: ifeq +30 -> 1510
    //   1483: ldc 183
    //   1485: iconst_2
    //   1486: new 85	java/lang/StringBuilder
    //   1489: dup
    //   1490: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   1493: ldc_w 2523
    //   1496: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1499: iload 6
    //   1501: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1504: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1507: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1510: new 2525	java/util/HashMap
    //   1513: dup
    //   1514: invokespecial 2526	java/util/HashMap:<init>	()V
    //   1517: astore_3
    //   1518: aload_3
    //   1519: ldc_w 2528
    //   1522: new 85	java/lang/StringBuilder
    //   1525: dup
    //   1526: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   1529: iload 6
    //   1531: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1534: ldc 13
    //   1536: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1539: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1542: invokevirtual 2531	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1545: pop
    //   1546: invokestatic 385	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1549: invokestatic 1676	azmz:a	(Landroid/content/Context;)Lazmz;
    //   1552: aconst_null
    //   1553: ldc_w 2533
    //   1556: iconst_0
    //   1557: lconst_0
    //   1558: lconst_0
    //   1559: aload_3
    //   1560: aconst_null
    //   1561: invokevirtual 2536	azmz:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;)V
    //   1564: goto -1105 -> 459
    //   1567: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1570: ifeq -1111 -> 459
    //   1573: aload_1
    //   1574: getfield 2392	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:result	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   1577: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   1580: istore 6
    //   1582: ldc 183
    //   1584: iconst_2
    //   1585: invokestatic 1086	java/util/Locale:getDefault	()Ljava/util/Locale;
    //   1588: ldc_w 2538
    //   1591: iconst_1
    //   1592: anewarray 301	java/lang/Object
    //   1595: dup
    //   1596: iconst_0
    //   1597: iload 6
    //   1599: invokestatic 305	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1602: aastore
    //   1603: invokestatic 1091	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   1606: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1609: goto -1150 -> 459
    //   1612: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1615: ifeq -1156 -> 459
    //   1618: aload_1
    //   1619: getfield 2392	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:result	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   1622: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   1625: istore 6
    //   1627: ldc 183
    //   1629: iconst_2
    //   1630: invokestatic 1086	java/util/Locale:getDefault	()Ljava/util/Locale;
    //   1633: ldc_w 2540
    //   1636: iconst_1
    //   1637: anewarray 301	java/lang/Object
    //   1640: dup
    //   1641: iconst_0
    //   1642: iload 6
    //   1644: invokestatic 305	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1647: aastore
    //   1648: invokestatic 1091	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   1651: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1654: goto -1195 -> 459
    //   1657: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1660: ifeq -1201 -> 459
    //   1663: aload_1
    //   1664: getfield 2392	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:result	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   1667: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   1670: istore 6
    //   1672: ldc 183
    //   1674: iconst_2
    //   1675: new 85	java/lang/StringBuilder
    //   1678: dup
    //   1679: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   1682: ldc_w 2542
    //   1685: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1688: iload 6
    //   1690: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1693: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1696: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1699: goto -1240 -> 459
    //   1702: ldc 183
    //   1704: iconst_1
    //   1705: iconst_2
    //   1706: anewarray 301	java/lang/Object
    //   1709: dup
    //   1710: iconst_0
    //   1711: ldc_w 2544
    //   1714: aastore
    //   1715: dup
    //   1716: iconst_1
    //   1717: aload_1
    //   1718: getfield 2392	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:result	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   1721: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   1724: invokestatic 305	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1727: aastore
    //   1728: invokestatic 2546	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   1731: goto -1272 -> 459
    //   1734: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1737: ifeq -1278 -> 459
    //   1740: aload_1
    //   1741: getfield 2392	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:result	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   1744: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   1747: istore 6
    //   1749: ldc 183
    //   1751: iconst_2
    //   1752: new 85	java/lang/StringBuilder
    //   1755: dup
    //   1756: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   1759: ldc_w 2548
    //   1762: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1765: iload 6
    //   1767: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1770: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1773: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1776: goto -1317 -> 459
    //   1779: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1782: ifeq -1323 -> 459
    //   1785: aload_1
    //   1786: getfield 2392	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:result	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   1789: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   1792: istore 6
    //   1794: ldc_w 2550
    //   1797: iconst_2
    //   1798: new 85	java/lang/StringBuilder
    //   1801: dup
    //   1802: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   1805: ldc_w 2552
    //   1808: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1811: iload 6
    //   1813: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1816: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1819: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1822: goto -1363 -> 459
    //   1825: invokestatic 2557	com/tencent/mobileqq/scribble/ScribbleResMgr:a	()Lcom/tencent/mobileqq/scribble/ScribbleResMgr;
    //   1828: invokevirtual 2558	com/tencent/mobileqq/scribble/ScribbleResMgr:b	()V
    //   1831: goto -1372 -> 459
    //   1834: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1837: ifeq -1378 -> 459
    //   1840: aload_1
    //   1841: getfield 2392	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:result	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   1844: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   1847: istore 6
    //   1849: ldc 183
    //   1851: iconst_2
    //   1852: new 85	java/lang/StringBuilder
    //   1855: dup
    //   1856: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   1859: ldc_w 2560
    //   1862: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1865: iload 6
    //   1867: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1870: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1873: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1876: goto -1417 -> 459
    //   1879: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1882: ifeq -1423 -> 459
    //   1885: aload_1
    //   1886: getfield 2392	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:result	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   1889: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   1892: istore 6
    //   1894: ldc_w 2343
    //   1897: iconst_2
    //   1898: new 85	java/lang/StringBuilder
    //   1901: dup
    //   1902: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   1905: ldc_w 2562
    //   1908: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1911: iload 6
    //   1913: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1916: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1919: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1922: goto -1463 -> 459
    //   1925: aload_2
    //   1926: sipush 228
    //   1929: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   1932: checkcast 1968	avqz
    //   1935: astore_3
    //   1936: aload_1
    //   1937: getfield 2392	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:result	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   1940: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   1943: istore 6
    //   1945: ldc 183
    //   1947: iconst_1
    //   1948: new 85	java/lang/StringBuilder
    //   1951: dup
    //   1952: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   1955: ldc_w 2564
    //   1958: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1961: iload 6
    //   1963: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1966: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1969: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1972: aload_3
    //   1973: iconst_0
    //   1974: aconst_null
    //   1975: invokevirtual 2567	avqz:a	(ZLcom/tencent/mobileqq/ocr/data/OcrConfig;)V
    //   1978: goto -1519 -> 459
    //   1981: aload_1
    //   1982: getfield 2392	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:result	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   1985: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   1988: invokestatic 2568	com/tencent/mobileqq/shortvideo/ShortVideoResourceManager:a	(I)V
    //   1991: goto -1532 -> 459
    //   1994: aload_2
    //   1995: sipush 231
    //   1998: aload_1
    //   1999: getfield 2392	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:result	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   2002: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   2005: invokestatic 2571	ajql:a	(Lcom/tencent/mobileqq/app/QQAppInterface;II)V
    //   2008: goto -1549 -> 459
    //   2011: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2014: ifeq -1555 -> 459
    //   2017: ldc_w 2573
    //   2020: iconst_2
    //   2021: new 85	java/lang/StringBuilder
    //   2024: dup
    //   2025: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   2028: ldc_w 2575
    //   2031: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2034: aload_1
    //   2035: getfield 2392	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:result	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   2038: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   2041: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2044: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2047: invokestatic 199	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   2050: goto -1591 -> 459
    //   2053: iload 5
    //   2055: ifne +9 -> 2064
    //   2058: iconst_m1
    //   2059: istore 6
    //   2061: goto -1640 -> 421
    //   2064: iconst_0
    //   2065: istore 6
    //   2067: goto -1646 -> 421
    //   2070: invokestatic 2578	java/lang/System:currentTimeMillis	()J
    //   2073: lstore 12
    //   2075: aload_1
    //   2076: getfield 2395	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:config_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   2079: invokevirtual 224	com/tencent/mobileqq/pb/PBRepeatMessageField:size	()I
    //   2082: istore 9
    //   2084: new 1125	java/util/ArrayList
    //   2087: dup
    //   2088: aload 4
    //   2090: arraylength
    //   2091: invokespecial 1156	java/util/ArrayList:<init>	(I)V
    //   2094: astore 18
    //   2096: iconst_0
    //   2097: istore 6
    //   2099: iload 6
    //   2101: aload 4
    //   2103: arraylength
    //   2104: if_icmpge +28 -> 2132
    //   2107: aload 18
    //   2109: aload 4
    //   2111: iload 6
    //   2113: iaload
    //   2114: invokestatic 305	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2117: invokeinterface 1135 2 0
    //   2122: pop
    //   2123: iload 6
    //   2125: iconst_1
    //   2126: iadd
    //   2127: istore 6
    //   2129: goto -30 -> 2099
    //   2132: aconst_null
    //   2133: astore 4
    //   2135: iconst_0
    //   2136: istore 10
    //   2138: iconst_0
    //   2139: istore 6
    //   2141: iload 6
    //   2143: iload 9
    //   2145: if_icmpge +8219 -> 10364
    //   2148: aload_1
    //   2149: getfield 2395	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:config_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   2152: iload 6
    //   2154: invokevirtual 318	com/tencent/mobileqq/pb/PBRepeatMessageField:get	(I)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   2157: checkcast 51	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config
    //   2160: astore 19
    //   2162: aload 19
    //   2164: ifnonnull +28 -> 2192
    //   2167: iload 10
    //   2169: istore 11
    //   2171: aload 4
    //   2173: astore 16
    //   2175: iload 6
    //   2177: iconst_1
    //   2178: iadd
    //   2179: istore 6
    //   2181: aload 16
    //   2183: astore 4
    //   2185: iload 11
    //   2187: istore 10
    //   2189: goto -48 -> 2141
    //   2192: aload 4
    //   2194: astore 16
    //   2196: iload 10
    //   2198: istore 11
    //   2200: aload 19
    //   2202: getfield 2579	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:type	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   2205: invokevirtual 2580	com/tencent/mobileqq/pb/PBInt32Field:has	()Z
    //   2208: ifeq -33 -> 2175
    //   2211: new 139	java/lang/Integer
    //   2214: dup
    //   2215: aload 19
    //   2217: getfield 2579	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:type	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   2220: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   2223: invokespecial 2581	java/lang/Integer:<init>	(I)V
    //   2226: astore 16
    //   2228: aload 18
    //   2230: aload 16
    //   2232: invokeinterface 2583 2 0
    //   2237: pop
    //   2238: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2241: ifeq +41 -> 2282
    //   2244: ldc 183
    //   2246: iconst_2
    //   2247: new 85	java/lang/StringBuilder
    //   2250: dup
    //   2251: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   2254: ldc_w 2585
    //   2257: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2260: aload 16
    //   2262: invokevirtual 798	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2265: ldc_w 2587
    //   2268: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2271: iload 9
    //   2273: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2276: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2279: invokestatic 199	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   2282: aload 16
    //   2284: invokevirtual 1829	java/lang/Integer:intValue	()I
    //   2287: lookupswitch	default:+9851->12138, 1:+2918->5205, 2:+3322->5609, 3:+3812->6099, 5:+4050->6337, 6:+6279->8566, 10:+4903->7190, 12:+4275->6562, 13:+5178->7465, 23:+5568->7855, 31:+5244->7531, 34:+5226->7513, 38:+5677->7964, 42:+6099->8386, 43:+6261->8548, 44:+2495->4782, 46:+6117->8404, 47:+2683->4970, 49:+6108->8395, 50:+6126->8413, 53:+5578->7865, 55:+4591->6878, 56:+6135->8422, 61:+6144->8431, 63:+6162->8449, 64:+6171->8458, 65:+2872->5159, 66:+6180->8467, 69:+6207->8494, 72:+6189->8476, 73:+6198->8485, 74:+6216->8503, 75:+6225->8512, 78:+5588->7875, 79:+6310->8597, 80:+6292->8579, 82:+6319->8606, 84:+5598->7885, 86:+6537->8824, 87:+6556->8843, 88:+6566->8853, 90:+6328->8615, 93:+5888->8175, 94:+5394->7681, 96:+6607->8894, 97:+6617->8904, 101:+5196->7483, 102:+5235->7522, 109:+6654->8941, 111:+6301->8588, 113:+6270->8557, 115:+5206->7493, 116:+1858->4145, 118:+6683->8970, 119:+6733->9020, 120:+6673->8960, 121:+6743->9030, 129:+6713->9000, 130:+6763->9050, 139:+5629->7916, 140:+6791->9078, 142:+6693->8980, 143:+6723->9010, 145:+6831->9118, 146:+6644->8931, 147:+6527->8814, 148:+6153->8440, 149:+6627->8914, 153:+6821->9108, 155:+6841->9128, 156:+9949->12236, 157:+6753->9040, 165:+6861->9148, 166:+6871->9158, 167:+5619->7906, 171:+6893->9180, 174:+6943->9230, 177:+6992->9279, 180:+6627->8914, 181:+6913->9200, 182:+6972->9259, 184:+6903->9190, 185:+7042->9329, 187:+7002->9289, 188:+6576->8863, 190:+7158->9445, 191:+7032->9319, 193:+1452->3739, 194:+6851->9138, 195:+7012->9299, 199:+7061->9348, 201:+6703->8990, 202:+7148->9435, 204:+7636->9923, 205:+6596->8883, 206:+6586->8873, 210:+7168->9455, 211:+6781->9068, 212:+7178->9465, 215:+7215->9502, 218:+6627->8914, 222:+7235->9522, 223:+5657->7944, 225:+7103->9390, 226:+5608->7895, 227:+7022->9309, 228:+6243->8530, 231:+7283->9570, 232:+6773->9060, 234:+7263->9550, 235:+7273->9560, 238:+7298->9585, 244:+7308->9595, 245:+7318->9605, 247:+6923->9210, 253:+7328->9615, 254:+7586->9873, 255:+7348->9635, 256:+6252->8539, 257:+6801->9088, 259:+7596->9883, 260:+6811->9098, 262:+7606->9893, 267:+7646->9933, 268:+7616->9903, 269:+7626->9913, 272:+6933->9220, 273:+6953->9240, 274:+7656->9943, 279:+7665->9952, 280:+7761->10048, 281:+7781->10068, 283:+7791->10078, 284:+7801->10088, 286:+5216->7503, 289:+7828->10115, 295:+7338->9625, 297:+7838->10125, 301:+7811->10098, 308:+7686->9973, 312:+7719->10006, 313:+7707->9994, 314:+7867->10154, 320:+7887->10174, 321:+7052->9339, 328:+6962->9249, 329:+5638->7925, 331:+7909->10196, 336:+7919->10206, 337:+7852->10139, 345:+7928->10215, 347:+7877->10164, 349:+7942->10229, 351:+5647->7934, 360:+7771->10058, 364:+5657->7944, 365:+5657->7944, 371:+6982->9269, 384:+7978->10265, 385:+6234->8521, 386:+7997->10284, 387:+7987->10274, 392:+8015->10302, 393:+8024->10311, 394:+8042->10329, 397:+7737->10024, 400:+7963->10250, 403:+7187->9474, 404:+7206->9493, 410:+8052->10339, 596:+8067->10354, 604:+7196->9483
    //   3665: istore 7
    //   3667: invokestatic 1299	aogj:a	()Laogj;
    //   3670: aload 16
    //   3672: invokevirtual 1829	java/lang/Integer:intValue	()I
    //   3675: invokevirtual 1302	aogj:b	(I)Z
    //   3678: ifeq +38 -> 3716
    //   3681: invokestatic 1299	aogj:a	()Laogj;
    //   3684: astore 17
    //   3686: aload 19
    //   3688: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   3691: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   3694: istore 7
    //   3696: aload 17
    //   3698: aload 16
    //   3700: invokevirtual 1829	java/lang/Integer:intValue	()I
    //   3703: iload 7
    //   3705: aload 19
    //   3707: getstatic 15	aova:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   3710: invokevirtual 2590	aogj:a	(IILcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;Ljava/lang/String;)V
    //   3713: iconst_1
    //   3714: istore 7
    //   3716: iload 7
    //   3718: ifne +8423 -> 12141
    //   3721: aload_2
    //   3722: invokevirtual 1334	com/tencent/mobileqq/app/QQAppInterface:a	()Laofo;
    //   3725: aload_2
    //   3726: aload 19
    //   3728: aload 16
    //   3730: invokevirtual 1829	java/lang/Integer:intValue	()I
    //   3733: invokevirtual 2592	aofo:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;I)V
    //   3736: goto +8405 -> 12141
    //   3739: aload 19
    //   3741: getfield 221	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   3744: ifnull +8397 -> 12141
    //   3747: aload 19
    //   3749: getfield 221	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   3752: invokevirtual 224	com/tencent/mobileqq/pb/PBRepeatMessageField:size	()I
    //   3755: ifle +8386 -> 12141
    //   3758: aload 19
    //   3760: getfield 221	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   3763: iconst_0
    //   3764: invokevirtual 318	com/tencent/mobileqq/pb/PBRepeatMessageField:get	(I)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   3767: checkcast 244	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content
    //   3770: astore 16
    //   3772: aload 16
    //   3774: ifnull +344 -> 4118
    //   3777: aload 16
    //   3779: getfield 248	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content:compress	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   3782: invokevirtual 251	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   3785: iconst_1
    //   3786: if_icmpne +232 -> 4018
    //   3789: aload 16
    //   3791: getfield 255	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content:content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   3794: invokevirtual 260	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   3797: invokevirtual 266	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   3800: invokestatic 321	avxz:a	([B)[B
    //   3803: astore 17
    //   3805: aload 17
    //   3807: ifnull +8325 -> 12132
    //   3810: new 118	java/lang/String
    //   3813: dup
    //   3814: aload 17
    //   3816: ldc_w 323
    //   3819: invokespecial 326	java/lang/String:<init>	([BLjava/lang/String;)V
    //   3822: astore 16
    //   3824: aload 16
    //   3826: ifnull +8299 -> 12125
    //   3829: aload 19
    //   3831: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   3834: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   3837: istore 7
    //   3839: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3842: ifeq +42 -> 3884
    //   3845: ldc_w 1787
    //   3848: iconst_2
    //   3849: new 85	java/lang/StringBuilder
    //   3852: dup
    //   3853: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   3856: ldc_w 2594
    //   3859: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3862: iload 7
    //   3864: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3867: ldc_w 2596
    //   3870: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3873: aload 16
    //   3875: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3878: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3881: invokestatic 199	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   3884: aload 16
    //   3886: invokestatic 2601	com/tencent/mobileqq/app/upgrade/UpgradeTIMWrapper:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/app/upgrade/UpgradeTIMWrapper;
    //   3889: astore 17
    //   3891: aload 17
    //   3893: astore 4
    //   3895: aload_0
    //   3896: invokevirtual 47	aova:getAppRuntime	()Lmqq/app/AppRuntime;
    //   3899: invokevirtual 2602	mqq/app/AppRuntime:getApplication	()Lmqq/app/MobileQQ;
    //   3902: getstatic 15	aova:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   3905: iload 7
    //   3907: invokestatic 2604	bdiv:q	(Landroid/content/Context;Ljava/lang/String;I)V
    //   3910: aload_2
    //   3911: invokevirtual 65	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   3914: ldc_w 2606
    //   3917: invokestatic 2609	bdem:a	(Landroid/content/Context;Ljava/lang/String;)Z
    //   3920: ifne +114 -> 4034
    //   3923: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3926: ifeq +13 -> 3939
    //   3929: ldc_w 1787
    //   3932: iconst_2
    //   3933: ldc_w 2611
    //   3936: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3939: aload 16
    //   3941: invokestatic 2612	com/tencent/mobileqq/app/upgrade/UpgradeTIMWrapper:a	(Ljava/lang/String;)V
    //   3944: aload_2
    //   3945: aload 4
    //   3947: invokestatic 2615	com/tencent/mobileqq/app/upgrade/UpgradeTIMWrapper:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/app/upgrade/UpgradeTIMWrapper;)V
    //   3950: aload 4
    //   3952: astore 16
    //   3954: aload 16
    //   3956: astore 4
    //   3958: goto +8183 -> 12141
    //   3961: astore 16
    //   3963: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3966: ifeq +8186 -> 12152
    //   3969: aload 16
    //   3971: invokevirtual 2616	java/io/UnsupportedEncodingException:printStackTrace	()V
    //   3974: goto +8178 -> 12152
    //   3977: astore 16
    //   3979: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3982: ifeq +8 -> 3990
    //   3985: aload 16
    //   3987: invokevirtual 2617	java/lang/OutOfMemoryError:printStackTrace	()V
    //   3990: invokestatic 2620	java/lang/System:gc	()V
    //   3993: new 118	java/lang/String
    //   3996: dup
    //   3997: aload 17
    //   3999: ldc_w 323
    //   4002: invokespecial 326	java/lang/String:<init>	([BLjava/lang/String;)V
    //   4005: astore 16
    //   4007: goto -183 -> 3824
    //   4010: astore 16
    //   4012: aconst_null
    //   4013: astore 16
    //   4015: goto -191 -> 3824
    //   4018: aload 16
    //   4020: getfield 255	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content:content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   4023: invokevirtual 260	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   4026: invokevirtual 280	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   4029: astore 16
    //   4031: goto -207 -> 3824
    //   4034: aload 4
    //   4036: astore 16
    //   4038: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4041: ifeq -87 -> 3954
    //   4044: ldc_w 1787
    //   4047: iconst_2
    //   4048: ldc_w 2622
    //   4051: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4054: aload 4
    //   4056: astore 16
    //   4058: goto -104 -> 3954
    //   4061: astore 17
    //   4063: aload 4
    //   4065: astore 16
    //   4067: iload 10
    //   4069: istore 11
    //   4071: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4074: ifeq -1899 -> 2175
    //   4077: ldc 183
    //   4079: iconst_2
    //   4080: new 85	java/lang/StringBuilder
    //   4083: dup
    //   4084: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   4087: ldc_w 2624
    //   4090: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4093: aload 17
    //   4095: invokevirtual 2290	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   4098: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4101: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4104: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4107: aload 4
    //   4109: astore 16
    //   4111: iload 10
    //   4113: istore 11
    //   4115: goto -1940 -> 2175
    //   4118: aload 4
    //   4120: astore 16
    //   4122: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4125: ifeq -171 -> 3954
    //   4128: ldc_w 1787
    //   4131: iconst_2
    //   4132: ldc_w 2626
    //   4135: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4138: aload 4
    //   4140: astore 16
    //   4142: goto -188 -> 3954
    //   4145: aload_0
    //   4146: invokevirtual 47	aova:getAppRuntime	()Lmqq/app/AppRuntime;
    //   4149: invokevirtual 2602	mqq/app/AppRuntime:getApplication	()Lmqq/app/MobileQQ;
    //   4152: getstatic 15	aova:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   4155: invokestatic 1768	bdiv:H	(Landroid/content/Context;Ljava/lang/String;)I
    //   4158: istore 7
    //   4160: aload 19
    //   4162: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   4165: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   4168: istore 8
    //   4170: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4173: ifeq +35 -> 4208
    //   4176: ldc 183
    //   4178: iconst_2
    //   4179: ldc_w 2628
    //   4182: iconst_2
    //   4183: anewarray 301	java/lang/Object
    //   4186: dup
    //   4187: iconst_0
    //   4188: iload 7
    //   4190: invokestatic 305	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   4193: aastore
    //   4194: dup
    //   4195: iconst_1
    //   4196: iload 8
    //   4198: invokestatic 305	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   4201: aastore
    //   4202: invokestatic 309	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   4205: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4208: aconst_null
    //   4209: astore 17
    //   4211: iload 7
    //   4213: iload 8
    //   4215: if_icmpeq +386 -> 4601
    //   4218: aload 19
    //   4220: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   4223: ifnull +14 -> 4237
    //   4226: aload 19
    //   4228: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   4231: invokevirtual 2629	com/tencent/mobileqq/pb/PBRepeatField:isEmpty	()Z
    //   4234: ifeq +285 -> 4519
    //   4237: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4240: ifeq +12 -> 4252
    //   4243: ldc 183
    //   4245: iconst_2
    //   4246: ldc_w 2631
    //   4249: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4252: ldc_w 2633
    //   4255: getstatic 15	aova:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   4258: invokestatic 2638	amln:a	(Ljava/lang/String;Ljava/lang/String;)Z
    //   4261: pop
    //   4262: aconst_null
    //   4263: astore 16
    //   4265: aload_0
    //   4266: invokevirtual 47	aova:getAppRuntime	()Lmqq/app/AppRuntime;
    //   4269: invokevirtual 2602	mqq/app/AppRuntime:getApplication	()Lmqq/app/MobileQQ;
    //   4272: getstatic 15	aova:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   4275: iload 8
    //   4277: invokestatic 2640	bdiv:p	(Landroid/content/Context;Ljava/lang/String;I)V
    //   4280: aload_2
    //   4281: iconst_4
    //   4282: invokevirtual 206	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lalko;
    //   4285: checkcast 1781	allq
    //   4288: astore 19
    //   4290: aload 16
    //   4292: invokestatic 126	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4295: ifne +468 -> 4763
    //   4298: invokestatic 2428	amlp:a	()Lamlp;
    //   4301: invokevirtual 2431	amlp:a	()Lcom/tencent/mobileqq/app/upgrade/UpgradeDetailWrapper;
    //   4304: astore 17
    //   4306: aload 17
    //   4308: aload 16
    //   4310: invokevirtual 2643	com/tencent/mobileqq/app/upgrade/UpgradeDetailWrapper:a	(Ljava/lang/String;)V
    //   4313: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4316: ifeq +42 -> 4358
    //   4319: ldc 183
    //   4321: iconst_2
    //   4322: ldc_w 2645
    //   4325: iconst_2
    //   4326: anewarray 301	java/lang/Object
    //   4329: dup
    //   4330: iconst_0
    //   4331: invokestatic 203	com/tencent/common/config/AppSetting:a	()I
    //   4334: invokestatic 305	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   4337: aastore
    //   4338: dup
    //   4339: iconst_1
    //   4340: aload 17
    //   4342: getfield 2648	com/tencent/mobileqq/app/upgrade/UpgradeDetailWrapper:jdField_b_of_type_ProtocolKQQConfigUpgradeInfo	Lprotocol/KQQConfig/UpgradeInfo;
    //   4345: getfield 2653	protocol/KQQConfig/UpgradeInfo:iUpgradeSdkId	I
    //   4348: invokestatic 305	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   4351: aastore
    //   4352: invokestatic 309	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   4355: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4358: aload_2
    //   4359: invokevirtual 65	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   4362: getstatic 15	aova:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   4365: invokestatic 2656	bdiv:aN	(Landroid/content/Context;Ljava/lang/String;)I
    //   4368: aload 17
    //   4370: getfield 2648	com/tencent/mobileqq/app/upgrade/UpgradeDetailWrapper:jdField_b_of_type_ProtocolKQQConfigUpgradeInfo	Lprotocol/KQQConfig/UpgradeInfo;
    //   4373: getfield 2653	protocol/KQQConfig/UpgradeInfo:iUpgradeSdkId	I
    //   4376: if_icmpeq +69 -> 4445
    //   4379: aload_2
    //   4380: invokevirtual 65	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   4383: aload_2
    //   4384: invokevirtual 1592	com/tencent/mobileqq/app/QQAppInterface:c	()Ljava/lang/String;
    //   4387: iconst_0
    //   4388: invokestatic 2659	bdiv:ae	(Landroid/content/Context;Ljava/lang/String;I)V
    //   4391: aload_2
    //   4392: invokevirtual 65	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   4395: aload_2
    //   4396: invokevirtual 1592	com/tencent/mobileqq/app/QQAppInterface:c	()Ljava/lang/String;
    //   4399: lconst_0
    //   4400: invokestatic 2662	bdiv:i	(Landroid/content/Context;Ljava/lang/String;J)V
    //   4403: aload_2
    //   4404: invokevirtual 65	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   4407: aload_2
    //   4408: invokevirtual 1592	com/tencent/mobileqq/app/QQAppInterface:c	()Ljava/lang/String;
    //   4411: iconst_0
    //   4412: invokestatic 2665	bdiv:af	(Landroid/content/Context;Ljava/lang/String;I)V
    //   4415: aload_2
    //   4416: invokevirtual 65	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   4419: aload_2
    //   4420: invokevirtual 1592	com/tencent/mobileqq/app/QQAppInterface:c	()Ljava/lang/String;
    //   4423: lconst_0
    //   4424: invokestatic 2667	bdiv:j	(Landroid/content/Context;Ljava/lang/String;J)V
    //   4427: aload_2
    //   4428: invokevirtual 65	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   4431: getstatic 15	aova:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   4434: aload 17
    //   4436: getfield 2648	com/tencent/mobileqq/app/upgrade/UpgradeDetailWrapper:jdField_b_of_type_ProtocolKQQConfigUpgradeInfo	Lprotocol/KQQConfig/UpgradeInfo;
    //   4439: getfield 2653	protocol/KQQConfig/UpgradeInfo:iUpgradeSdkId	I
    //   4442: invokestatic 2669	bdiv:ad	(Landroid/content/Context;Ljava/lang/String;I)V
    //   4445: invokestatic 203	com/tencent/common/config/AppSetting:a	()I
    //   4448: aload 17
    //   4450: getfield 2648	com/tencent/mobileqq/app/upgrade/UpgradeDetailWrapper:jdField_b_of_type_ProtocolKQQConfigUpgradeInfo	Lprotocol/KQQConfig/UpgradeInfo;
    //   4453: getfield 2653	protocol/KQQConfig/UpgradeInfo:iUpgradeSdkId	I
    //   4456: if_icmplt +171 -> 4627
    //   4459: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4462: ifeq +12 -> 4474
    //   4465: ldc 183
    //   4467: iconst_2
    //   4468: ldc_w 2671
    //   4471: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4474: aload_2
    //   4475: invokevirtual 65	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   4478: getstatic 15	aova:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   4481: iconst_0
    //   4482: invokestatic 2640	bdiv:p	(Landroid/content/Context;Ljava/lang/String;I)V
    //   4485: ldc_w 2633
    //   4488: getstatic 15	aova:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   4491: invokestatic 2638	amln:a	(Ljava/lang/String;Ljava/lang/String;)Z
    //   4494: pop
    //   4495: aload 17
    //   4497: getfield 2648	com/tencent/mobileqq/app/upgrade/UpgradeDetailWrapper:jdField_b_of_type_ProtocolKQQConfigUpgradeInfo	Lprotocol/KQQConfig/UpgradeInfo;
    //   4500: iconst_0
    //   4501: putfield 2674	protocol/KQQConfig/UpgradeInfo:iUpgradeType	I
    //   4504: aload 19
    //   4506: aload 17
    //   4508: invokevirtual 2434	allq:a	(Lcom/tencent/mobileqq/app/upgrade/UpgradeDetailWrapper;)V
    //   4511: aload 19
    //   4513: invokevirtual 2675	allq:c	()V
    //   4516: goto +7625 -> 12141
    //   4519: aload 19
    //   4521: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   4524: iconst_0
    //   4525: invokevirtual 116	com/tencent/mobileqq/pb/PBRepeatField:get	(I)Ljava/lang/Object;
    //   4528: checkcast 118	java/lang/String
    //   4531: astore 16
    //   4533: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4536: ifeq +30 -> 4566
    //   4539: ldc 183
    //   4541: iconst_2
    //   4542: new 85	java/lang/StringBuilder
    //   4545: dup
    //   4546: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   4549: ldc_w 2677
    //   4552: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4555: aload 16
    //   4557: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4560: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4563: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4566: aload 16
    //   4568: invokestatic 126	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4571: ifeq +16 -> 4587
    //   4574: ldc_w 2633
    //   4577: getstatic 15	aova:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   4580: invokestatic 2638	amln:a	(Ljava/lang/String;Ljava/lang/String;)Z
    //   4583: pop
    //   4584: goto -319 -> 4265
    //   4587: ldc_w 2633
    //   4590: getstatic 15	aova:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   4593: aload 16
    //   4595: invokestatic 2680	amln:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   4598: goto -333 -> 4265
    //   4601: aload 17
    //   4603: astore 16
    //   4605: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4608: ifeq -328 -> 4280
    //   4611: ldc 183
    //   4613: iconst_2
    //   4614: ldc_w 2682
    //   4617: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4620: aload 17
    //   4622: astore 16
    //   4624: goto -344 -> 4280
    //   4627: aload_0
    //   4628: invokevirtual 47	aova:getAppRuntime	()Lmqq/app/AppRuntime;
    //   4631: invokevirtual 2602	mqq/app/AppRuntime:getApplication	()Lmqq/app/MobileQQ;
    //   4634: getstatic 15	aova:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   4637: invokestatic 2578	java/lang/System:currentTimeMillis	()J
    //   4640: invokestatic 2684	bdiv:a	(Landroid/content/Context;Ljava/lang/String;J)V
    //   4643: aload 17
    //   4645: monitorenter
    //   4646: aload 17
    //   4648: getfield 2685	com/tencent/mobileqq/app/upgrade/UpgradeDetailWrapper:jdField_a_of_type_Boolean	Z
    //   4651: ifne +27 -> 4678
    //   4654: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4657: ifeq +12 -> 4669
    //   4660: ldc 183
    //   4662: iconst_2
    //   4663: ldc_w 2687
    //   4666: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4669: aload 17
    //   4671: monitorexit
    //   4672: iconst_1
    //   4673: istore 10
    //   4675: goto +7466 -> 12141
    //   4678: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4681: ifeq +12 -> 4693
    //   4684: ldc 183
    //   4686: iconst_2
    //   4687: ldc_w 2689
    //   4690: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4693: aload 17
    //   4695: getfield 2691	com/tencent/mobileqq/app/upgrade/UpgradeDetailWrapper:jdField_b_of_type_Int	I
    //   4698: ifne +21 -> 4719
    //   4701: aload 17
    //   4703: getfield 2692	com/tencent/mobileqq/app/upgrade/UpgradeDetailWrapper:jdField_a_of_type_Int	I
    //   4706: iconst_1
    //   4707: if_icmpne +7456 -> 12163
    //   4710: iconst_1
    //   4711: istore 10
    //   4713: aload_2
    //   4714: iload 10
    //   4716: invokestatic 2693	allq:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Z)V
    //   4719: aload 19
    //   4721: invokevirtual 2675	allq:c	()V
    //   4724: invokestatic 2428	amlp:a	()Lamlp;
    //   4727: aload 17
    //   4729: getfield 2648	com/tencent/mobileqq/app/upgrade/UpgradeDetailWrapper:jdField_b_of_type_ProtocolKQQConfigUpgradeInfo	Lprotocol/KQQConfig/UpgradeInfo;
    //   4732: aload 19
    //   4734: invokevirtual 2696	amlp:a	(Lprotocol/KQQConfig/UpgradeInfo;Lamlr;)Z
    //   4737: pop
    //   4738: aload 17
    //   4740: monitorexit
    //   4741: iconst_1
    //   4742: istore 10
    //   4744: goto +7397 -> 12141
    //   4747: astore 16
    //   4749: aload 17
    //   4751: monitorexit
    //   4752: aload 16
    //   4754: athrow
    //   4755: astore 17
    //   4757: iconst_1
    //   4758: istore 10
    //   4760: goto -697 -> 4063
    //   4763: aload 19
    //   4765: invokevirtual 2675	allq:c	()V
    //   4768: aload 19
    //   4770: invokestatic 2428	amlp:a	()Lamlp;
    //   4773: invokevirtual 2431	amlp:a	()Lcom/tencent/mobileqq/app/upgrade/UpgradeDetailWrapper;
    //   4776: invokevirtual 2434	allq:a	(Lcom/tencent/mobileqq/app/upgrade/UpgradeDetailWrapper;)V
    //   4779: goto +7362 -> 12141
    //   4782: aload 19
    //   4784: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   4787: ifnull +141 -> 4928
    //   4790: aload 19
    //   4792: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   4795: invokevirtual 113	com/tencent/mobileqq/pb/PBRepeatField:size	()I
    //   4798: ifle +130 -> 4928
    //   4801: aload_0
    //   4802: invokevirtual 47	aova:getAppRuntime	()Lmqq/app/AppRuntime;
    //   4805: invokevirtual 2602	mqq/app/AppRuntime:getApplication	()Lmqq/app/MobileQQ;
    //   4808: aload 19
    //   4810: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   4813: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   4816: getstatic 15	aova:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   4819: invokestatic 2698	bdiv:f	(Landroid/content/Context;ILjava/lang/String;)V
    //   4822: iconst_0
    //   4823: istore 7
    //   4825: iload 7
    //   4827: aload 19
    //   4829: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   4832: invokevirtual 113	com/tencent/mobileqq/pb/PBRepeatField:size	()I
    //   4835: if_icmpge +7343 -> 12178
    //   4838: aload 19
    //   4840: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   4843: iload 7
    //   4845: invokevirtual 116	com/tencent/mobileqq/pb/PBRepeatField:get	(I)Ljava/lang/Object;
    //   4848: checkcast 118	java/lang/String
    //   4851: astore 16
    //   4853: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4856: ifeq +47 -> 4903
    //   4859: ldc 183
    //   4861: iconst_2
    //   4862: new 85	java/lang/StringBuilder
    //   4865: dup
    //   4866: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   4869: ldc_w 2700
    //   4872: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4875: aload 16
    //   4877: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4880: ldc_w 604
    //   4883: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4886: aload 19
    //   4888: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   4891: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   4894: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4897: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4900: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4903: aload 16
    //   4905: invokestatic 126	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4908: ifne +7261 -> 12169
    //   4911: aload_2
    //   4912: bipush 60
    //   4914: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   4917: checkcast 2702	com/tencent/mobileqq/app/HotChatManager
    //   4920: aload 16
    //   4922: invokevirtual 2704	com/tencent/mobileqq/app/HotChatManager:d	(Ljava/lang/String;)V
    //   4925: goto +7244 -> 12169
    //   4928: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4931: ifeq +7210 -> 12141
    //   4934: ldc 183
    //   4936: iconst_2
    //   4937: new 85	java/lang/StringBuilder
    //   4940: dup
    //   4941: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   4944: ldc_w 2706
    //   4947: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4950: aload 19
    //   4952: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   4955: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   4958: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4961: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4964: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4967: goto +7174 -> 12141
    //   4970: aload 19
    //   4972: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   4975: ifnull +142 -> 5117
    //   4978: aload 19
    //   4980: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   4983: invokevirtual 113	com/tencent/mobileqq/pb/PBRepeatField:size	()I
    //   4986: ifle +131 -> 5117
    //   4989: aload_0
    //   4990: invokevirtual 47	aova:getAppRuntime	()Lmqq/app/AppRuntime;
    //   4993: invokevirtual 2602	mqq/app/AppRuntime:getApplication	()Lmqq/app/MobileQQ;
    //   4996: aload 19
    //   4998: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   5001: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   5004: getstatic 15	aova:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   5007: invokestatic 2708	bdiv:d	(Landroid/content/Context;ILjava/lang/String;)V
    //   5010: iconst_0
    //   5011: istore 7
    //   5013: iload 7
    //   5015: aload 19
    //   5017: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   5020: invokevirtual 113	com/tencent/mobileqq/pb/PBRepeatField:size	()I
    //   5023: if_icmpge +7167 -> 12190
    //   5026: aload 19
    //   5028: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   5031: iload 7
    //   5033: invokevirtual 116	com/tencent/mobileqq/pb/PBRepeatField:get	(I)Ljava/lang/Object;
    //   5036: checkcast 118	java/lang/String
    //   5039: astore 16
    //   5041: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5044: ifeq +47 -> 5091
    //   5047: ldc 183
    //   5049: iconst_2
    //   5050: new 85	java/lang/StringBuilder
    //   5053: dup
    //   5054: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   5057: ldc_w 2710
    //   5060: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5063: aload 16
    //   5065: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5068: ldc_w 604
    //   5071: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5074: aload 19
    //   5076: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   5079: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   5082: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5085: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5088: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   5091: aload 16
    //   5093: invokestatic 126	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   5096: ifne +7085 -> 12181
    //   5099: aload_2
    //   5100: bipush 51
    //   5102: invokevirtual 206	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lalko;
    //   5105: checkcast 2712	zpa
    //   5108: aload 16
    //   5110: iconst_0
    //   5111: invokevirtual 2715	zpa:a	(Ljava/lang/String;Z)V
    //   5114: goto +7067 -> 12181
    //   5117: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5120: ifeq +7021 -> 12141
    //   5123: ldc 183
    //   5125: iconst_2
    //   5126: new 85	java/lang/StringBuilder
    //   5129: dup
    //   5130: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   5133: ldc_w 2717
    //   5136: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5139: aload 19
    //   5141: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   5144: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   5147: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5150: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5153: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   5156: goto +6985 -> 12141
    //   5159: aload 19
    //   5161: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   5164: ifnull +6977 -> 12141
    //   5167: aload_0
    //   5168: invokevirtual 47	aova:getAppRuntime	()Lmqq/app/AppRuntime;
    //   5171: invokevirtual 2602	mqq/app/AppRuntime:getApplication	()Lmqq/app/MobileQQ;
    //   5174: aload 19
    //   5176: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   5179: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   5182: getstatic 15	aova:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   5185: invokestatic 2719	bdiv:e	(Landroid/content/Context;ILjava/lang/String;)V
    //   5188: aload_2
    //   5189: bipush 51
    //   5191: invokevirtual 206	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lalko;
    //   5194: checkcast 2712	zpa
    //   5197: aload 19
    //   5199: invokevirtual 2721	zpa:a	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   5202: goto +6939 -> 12141
    //   5205: aload 19
    //   5207: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   5210: ifnull +276 -> 5486
    //   5213: aload 19
    //   5215: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   5218: invokevirtual 113	com/tencent/mobileqq/pb/PBRepeatField:size	()I
    //   5221: ifle +265 -> 5486
    //   5224: new 2723	java/io/File
    //   5227: dup
    //   5228: new 85	java/lang/StringBuilder
    //   5231: dup
    //   5232: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   5235: aload_0
    //   5236: invokevirtual 47	aova:getAppRuntime	()Lmqq/app/AppRuntime;
    //   5239: invokevirtual 2602	mqq/app/AppRuntime:getApplication	()Lmqq/app/MobileQQ;
    //   5242: invokevirtual 2729	mqq/app/MobileQQ:getFilesDir	()Ljava/io/File;
    //   5245: invokevirtual 2732	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   5248: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5251: ldc_w 2734
    //   5254: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5257: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5260: invokespecial 2735	java/io/File:<init>	(Ljava/lang/String;)V
    //   5263: astore 16
    //   5265: aload 16
    //   5267: invokevirtual 2738	java/io/File:exists	()Z
    //   5270: ifne +152 -> 5422
    //   5273: aload 16
    //   5275: invokevirtual 2741	java/io/File:mkdirs	()Z
    //   5278: pop
    //   5279: aload 19
    //   5281: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   5284: invokevirtual 1147	com/tencent/mobileqq/pb/PBRepeatField:get	()Ljava/util/List;
    //   5287: invokeinterface 233 1 0
    //   5292: astore 16
    //   5294: aload 16
    //   5296: invokeinterface 238 1 0
    //   5301: ifeq +6901 -> 12202
    //   5304: aload 16
    //   5306: invokeinterface 242 1 0
    //   5311: checkcast 118	java/lang/String
    //   5314: astore 17
    //   5316: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5319: ifeq +47 -> 5366
    //   5322: ldc 183
    //   5324: iconst_2
    //   5325: new 85	java/lang/StringBuilder
    //   5328: dup
    //   5329: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   5332: ldc_w 2743
    //   5335: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5338: aload 17
    //   5340: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5343: ldc_w 604
    //   5346: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5349: aload 19
    //   5351: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   5354: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   5357: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5360: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5363: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   5366: aload_0
    //   5367: aload 17
    //   5369: aload 19
    //   5371: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   5374: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   5377: invokespecial 2746	aova:e	(Ljava/lang/String;I)V
    //   5380: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5383: ifeq -89 -> 5294
    //   5386: ldc 183
    //   5388: iconst_2
    //   5389: new 85	java/lang/StringBuilder
    //   5392: dup
    //   5393: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   5396: ldc_w 2748
    //   5399: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5402: aload 19
    //   5404: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   5407: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   5410: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5413: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5416: invokestatic 199	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   5419: goto -125 -> 5294
    //   5422: aload 16
    //   5424: ifnull -145 -> 5279
    //   5427: aload 16
    //   5429: invokevirtual 2751	java/io/File:isDirectory	()Z
    //   5432: ifeq -153 -> 5279
    //   5435: aload 16
    //   5437: invokevirtual 2755	java/io/File:listFiles	()[Ljava/io/File;
    //   5440: astore 16
    //   5442: aload 16
    //   5444: arraylength
    //   5445: istore 8
    //   5447: iconst_0
    //   5448: istore 7
    //   5450: iload 7
    //   5452: iload 8
    //   5454: if_icmpge -175 -> 5279
    //   5457: aload 16
    //   5459: iload 7
    //   5461: aaload
    //   5462: astore 17
    //   5464: aload 17
    //   5466: ifnull +6727 -> 12193
    //   5469: aload 17
    //   5471: invokevirtual 2738	java/io/File:exists	()Z
    //   5474: ifeq +6719 -> 12193
    //   5477: aload 17
    //   5479: invokevirtual 2758	java/io/File:delete	()Z
    //   5482: pop
    //   5483: goto +6710 -> 12193
    //   5486: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5489: ifeq +36 -> 5525
    //   5492: ldc 183
    //   5494: iconst_2
    //   5495: new 85	java/lang/StringBuilder
    //   5498: dup
    //   5499: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   5502: ldc_w 2760
    //   5505: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5508: aload 19
    //   5510: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   5513: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   5516: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5519: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5522: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   5525: new 2723	java/io/File
    //   5528: dup
    //   5529: new 85	java/lang/StringBuilder
    //   5532: dup
    //   5533: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   5536: aload_0
    //   5537: invokevirtual 47	aova:getAppRuntime	()Lmqq/app/AppRuntime;
    //   5540: invokevirtual 2602	mqq/app/AppRuntime:getApplication	()Lmqq/app/MobileQQ;
    //   5543: invokevirtual 2729	mqq/app/MobileQQ:getFilesDir	()Ljava/io/File;
    //   5546: invokevirtual 2732	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   5549: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5552: ldc_w 2762
    //   5555: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5558: ldc_w 2764
    //   5561: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5564: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5567: invokespecial 2735	java/io/File:<init>	(Ljava/lang/String;)V
    //   5570: astore 16
    //   5572: aload 16
    //   5574: ifnull +9 -> 5583
    //   5577: aload 16
    //   5579: invokevirtual 2758	java/io/File:delete	()Z
    //   5582: pop
    //   5583: aload_0
    //   5584: invokevirtual 47	aova:getAppRuntime	()Lmqq/app/AppRuntime;
    //   5587: invokevirtual 2602	mqq/app/AppRuntime:getApplication	()Lmqq/app/MobileQQ;
    //   5590: aload 19
    //   5592: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   5595: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   5598: ldc_w 2766
    //   5601: ldc 13
    //   5603: invokestatic 2769	bdiv:a	(Landroid/content/Context;ILjava/lang/String;Ljava/lang/String;)V
    //   5606: goto +6535 -> 12141
    //   5609: aload 19
    //   5611: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   5614: ifnull +323 -> 5937
    //   5617: aload 19
    //   5619: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   5622: invokevirtual 113	com/tencent/mobileqq/pb/PBRepeatField:size	()I
    //   5625: ifle +312 -> 5937
    //   5628: getstatic 2774	aofs:a	Laovm;
    //   5631: invokevirtual 2777	aovm:b	()V
    //   5634: aload 19
    //   5636: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   5639: invokevirtual 1147	com/tencent/mobileqq/pb/PBRepeatField:get	()Ljava/util/List;
    //   5642: invokeinterface 233 1 0
    //   5647: astore 16
    //   5649: aload 16
    //   5651: invokeinterface 238 1 0
    //   5656: ifeq +82 -> 5738
    //   5659: aload 16
    //   5661: invokeinterface 242 1 0
    //   5666: checkcast 118	java/lang/String
    //   5669: astore 17
    //   5671: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5674: ifeq +47 -> 5721
    //   5677: ldc 183
    //   5679: iconst_2
    //   5680: new 85	java/lang/StringBuilder
    //   5683: dup
    //   5684: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   5687: ldc_w 2779
    //   5690: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5693: aload 17
    //   5695: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5698: ldc_w 604
    //   5701: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5704: aload 19
    //   5706: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   5709: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   5712: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5715: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5718: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   5721: aload_0
    //   5722: aload 17
    //   5724: aload 19
    //   5726: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   5729: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   5732: invokespecial 2781	aova:c	(Ljava/lang/String;I)V
    //   5735: goto -86 -> 5649
    //   5738: new 2783	aofu
    //   5741: dup
    //   5742: aload_0
    //   5743: invokevirtual 47	aova:getAppRuntime	()Lmqq/app/AppRuntime;
    //   5746: invokevirtual 2602	mqq/app/AppRuntime:getApplication	()Lmqq/app/MobileQQ;
    //   5749: getstatic 15	aova:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   5752: invokespecial 2785	aofu:<init>	(Landroid/content/Context;Ljava/lang/String;)V
    //   5755: astore 16
    //   5757: aload 16
    //   5759: ifnull +13 -> 5772
    //   5762: aload 16
    //   5764: invokevirtual 2786	aofu:b	()V
    //   5767: aload 16
    //   5769: invokevirtual 2787	aofu:c	()V
    //   5772: invokestatic 385	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   5775: ldc_w 2789
    //   5778: iconst_0
    //   5779: invokevirtual 340	com/tencent/qphone/base/util/BaseApplication:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   5782: astore 16
    //   5784: aload 16
    //   5786: invokeinterface 346 1 0
    //   5791: new 85	java/lang/StringBuilder
    //   5794: dup
    //   5795: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   5798: ldc_w 2791
    //   5801: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5804: aload_0
    //   5805: invokevirtual 47	aova:getAppRuntime	()Lmqq/app/AppRuntime;
    //   5808: invokevirtual 2792	mqq/app/AppRuntime:getAccount	()Ljava/lang/String;
    //   5811: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5814: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5817: iconst_1
    //   5818: invokeinterface 354 3 0
    //   5823: invokeinterface 726 1 0
    //   5828: pop
    //   5829: aload 16
    //   5831: invokeinterface 346 1 0
    //   5836: new 85	java/lang/StringBuilder
    //   5839: dup
    //   5840: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   5843: ldc_w 2794
    //   5846: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5849: aload_0
    //   5850: invokevirtual 47	aova:getAppRuntime	()Lmqq/app/AppRuntime;
    //   5853: invokevirtual 2792	mqq/app/AppRuntime:getAccount	()Ljava/lang/String;
    //   5856: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5859: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5862: iconst_1
    //   5863: invokeinterface 354 3 0
    //   5868: invokeinterface 726 1 0
    //   5873: pop
    //   5874: aload_0
    //   5875: invokevirtual 47	aova:getAppRuntime	()Lmqq/app/AppRuntime;
    //   5878: invokevirtual 2602	mqq/app/AppRuntime:getApplication	()Lmqq/app/MobileQQ;
    //   5881: aload 19
    //   5883: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   5886: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   5889: getstatic 15	aova:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   5892: invokestatic 2698	bdiv:f	(Landroid/content/Context;ILjava/lang/String;)V
    //   5895: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5898: ifeq +6307 -> 12205
    //   5901: ldc 183
    //   5903: iconst_2
    //   5904: new 85	java/lang/StringBuilder
    //   5907: dup
    //   5908: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   5911: ldc_w 2796
    //   5914: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5917: aload 19
    //   5919: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   5922: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   5925: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5928: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5931: invokestatic 199	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   5934: goto +6271 -> 12205
    //   5937: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5940: ifeq +36 -> 5976
    //   5943: ldc 183
    //   5945: iconst_2
    //   5946: new 85	java/lang/StringBuilder
    //   5949: dup
    //   5950: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   5953: ldc_w 2798
    //   5956: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5959: aload 19
    //   5961: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   5964: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   5967: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5970: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5973: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   5976: getstatic 2774	aofs:a	Laovm;
    //   5979: invokevirtual 2777	aovm:b	()V
    //   5982: getstatic 2774	aofs:a	Laovm;
    //   5985: invokevirtual 2799	aovm:c	()V
    //   5988: new 2783	aofu
    //   5991: dup
    //   5992: aload_0
    //   5993: invokevirtual 47	aova:getAppRuntime	()Lmqq/app/AppRuntime;
    //   5996: invokevirtual 2602	mqq/app/AppRuntime:getApplication	()Lmqq/app/MobileQQ;
    //   5999: getstatic 15	aova:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   6002: invokespecial 2785	aofu:<init>	(Landroid/content/Context;Ljava/lang/String;)V
    //   6005: astore 16
    //   6007: aload 16
    //   6009: ifnull +13 -> 6022
    //   6012: aload 16
    //   6014: invokevirtual 2786	aofu:b	()V
    //   6017: aload 16
    //   6019: invokevirtual 2787	aofu:c	()V
    //   6022: invokestatic 385	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   6025: ldc_w 2789
    //   6028: iconst_0
    //   6029: invokevirtual 340	com/tencent/qphone/base/util/BaseApplication:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   6032: invokeinterface 346 1 0
    //   6037: new 85	java/lang/StringBuilder
    //   6040: dup
    //   6041: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   6044: ldc_w 2794
    //   6047: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6050: aload_0
    //   6051: invokevirtual 47	aova:getAppRuntime	()Lmqq/app/AppRuntime;
    //   6054: invokevirtual 2792	mqq/app/AppRuntime:getAccount	()Ljava/lang/String;
    //   6057: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6060: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6063: iconst_0
    //   6064: invokeinterface 354 3 0
    //   6069: invokeinterface 726 1 0
    //   6074: pop
    //   6075: aload_0
    //   6076: invokevirtual 47	aova:getAppRuntime	()Lmqq/app/AppRuntime;
    //   6079: invokevirtual 2602	mqq/app/AppRuntime:getApplication	()Lmqq/app/MobileQQ;
    //   6082: aload 19
    //   6084: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   6087: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   6090: getstatic 15	aova:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   6093: invokestatic 2698	bdiv:f	(Landroid/content/Context;ILjava/lang/String;)V
    //   6096: goto +6045 -> 12141
    //   6099: aload 19
    //   6101: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   6104: ifnull +95 -> 6199
    //   6107: aload 19
    //   6109: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   6112: invokevirtual 113	com/tencent/mobileqq/pb/PBRepeatField:size	()I
    //   6115: ifle +84 -> 6199
    //   6118: aload 19
    //   6120: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   6123: iconst_0
    //   6124: invokevirtual 116	com/tencent/mobileqq/pb/PBRepeatField:get	(I)Ljava/lang/Object;
    //   6127: checkcast 118	java/lang/String
    //   6130: astore 16
    //   6132: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6135: ifeq +47 -> 6182
    //   6138: ldc 183
    //   6140: iconst_2
    //   6141: new 85	java/lang/StringBuilder
    //   6144: dup
    //   6145: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   6148: ldc_w 2801
    //   6151: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6154: aload 16
    //   6156: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6159: ldc_w 604
    //   6162: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6165: aload 19
    //   6167: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   6170: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   6173: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6176: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6179: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   6182: aload_0
    //   6183: aload 16
    //   6185: aload 19
    //   6187: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   6190: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   6193: invokespecial 2803	aova:d	(Ljava/lang/String;I)V
    //   6196: goto +5945 -> 12141
    //   6199: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6202: ifeq +36 -> 6238
    //   6205: ldc 183
    //   6207: iconst_2
    //   6208: new 85	java/lang/StringBuilder
    //   6211: dup
    //   6212: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   6215: ldc_w 2805
    //   6218: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6221: aload 19
    //   6223: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   6226: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   6229: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6232: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6235: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   6238: new 2723	java/io/File
    //   6241: dup
    //   6242: new 85	java/lang/StringBuilder
    //   6245: dup
    //   6246: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   6249: aload_0
    //   6250: invokevirtual 47	aova:getAppRuntime	()Lmqq/app/AppRuntime;
    //   6253: invokevirtual 2602	mqq/app/AppRuntime:getApplication	()Lmqq/app/MobileQQ;
    //   6256: invokevirtual 2729	mqq/app/MobileQQ:getFilesDir	()Ljava/io/File;
    //   6259: invokevirtual 2732	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   6262: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6265: ldc_w 2762
    //   6268: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6271: getstatic 15	aova:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   6274: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6277: ldc_w 2762
    //   6280: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6283: ldc_w 2807
    //   6286: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6289: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6292: invokespecial 2735	java/io/File:<init>	(Ljava/lang/String;)V
    //   6295: astore 16
    //   6297: aload 16
    //   6299: invokevirtual 2738	java/io/File:exists	()Z
    //   6302: ifeq +9 -> 6311
    //   6305: aload 16
    //   6307: invokevirtual 2758	java/io/File:delete	()Z
    //   6310: pop
    //   6311: aload_0
    //   6312: invokevirtual 47	aova:getAppRuntime	()Lmqq/app/AppRuntime;
    //   6315: invokevirtual 2602	mqq/app/AppRuntime:getApplication	()Lmqq/app/MobileQQ;
    //   6318: aload 19
    //   6320: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   6323: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   6326: ldc 13
    //   6328: getstatic 15	aova:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   6331: invokestatic 2809	bdiv:b	(Landroid/content/Context;ILjava/lang/String;Ljava/lang/String;)V
    //   6334: goto +5807 -> 12141
    //   6337: aload 19
    //   6339: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   6342: ifnull +178 -> 6520
    //   6345: aload 19
    //   6347: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   6350: invokevirtual 113	com/tencent/mobileqq/pb/PBRepeatField:size	()I
    //   6353: ifle +167 -> 6520
    //   6356: new 1125	java/util/ArrayList
    //   6359: dup
    //   6360: invokespecial 1126	java/util/ArrayList:<init>	()V
    //   6363: astore 16
    //   6365: iconst_0
    //   6366: istore 7
    //   6368: iload 7
    //   6370: aload 19
    //   6372: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   6375: invokevirtual 113	com/tencent/mobileqq/pb/PBRepeatField:size	()I
    //   6378: if_icmpge +92 -> 6470
    //   6381: aload 19
    //   6383: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   6386: iload 7
    //   6388: invokevirtual 116	com/tencent/mobileqq/pb/PBRepeatField:get	(I)Ljava/lang/Object;
    //   6391: checkcast 118	java/lang/String
    //   6394: astore 17
    //   6396: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6399: ifeq +47 -> 6446
    //   6402: ldc 183
    //   6404: iconst_2
    //   6405: new 85	java/lang/StringBuilder
    //   6408: dup
    //   6409: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   6412: ldc_w 2811
    //   6415: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6418: aload 17
    //   6420: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6423: ldc_w 604
    //   6426: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6429: aload 19
    //   6431: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   6434: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   6437: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6440: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6443: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   6446: aload_0
    //   6447: aload 17
    //   6449: invokespecial 2813	aova:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/config/operation/QQOperationViopTipTask;
    //   6452: astore 17
    //   6454: aload 17
    //   6456: ifnull +5752 -> 12208
    //   6459: aload 16
    //   6461: aload 17
    //   6463: invokevirtual 1159	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   6466: pop
    //   6467: goto +5741 -> 12208
    //   6470: aload_0
    //   6471: invokevirtual 47	aova:getAppRuntime	()Lmqq/app/AppRuntime;
    //   6474: checkcast 49	com/tencent/mobileqq/app/QQAppInterface
    //   6477: invokestatic 2818	aouu:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)Laouu;
    //   6480: aload_0
    //   6481: invokevirtual 47	aova:getAppRuntime	()Lmqq/app/AppRuntime;
    //   6484: checkcast 49	com/tencent/mobileqq/app/QQAppInterface
    //   6487: aload 16
    //   6489: invokevirtual 2821	aouu:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/util/ArrayList;)V
    //   6492: aload_0
    //   6493: invokevirtual 47	aova:getAppRuntime	()Lmqq/app/AppRuntime;
    //   6496: invokevirtual 2602	mqq/app/AppRuntime:getApplication	()Lmqq/app/MobileQQ;
    //   6499: aload_0
    //   6500: invokevirtual 47	aova:getAppRuntime	()Lmqq/app/AppRuntime;
    //   6503: invokevirtual 2792	mqq/app/AppRuntime:getAccount	()Ljava/lang/String;
    //   6506: aload 19
    //   6508: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   6511: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   6514: invokestatic 2822	bdiv:a	(Landroid/content/Context;Ljava/lang/String;I)V
    //   6517: goto +5624 -> 12141
    //   6520: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6523: ifeq +5618 -> 12141
    //   6526: ldc 183
    //   6528: iconst_2
    //   6529: new 85	java/lang/StringBuilder
    //   6532: dup
    //   6533: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   6536: ldc_w 2824
    //   6539: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6542: aload 19
    //   6544: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   6547: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   6550: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6553: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6556: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   6559: goto +5582 -> 12141
    //   6562: aload_2
    //   6563: bipush 74
    //   6565: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   6568: checkcast 1392	aovk
    //   6571: astore 16
    //   6573: aload 16
    //   6575: invokevirtual 2827	aovk:a	()Ljava/util/Set;
    //   6578: astore 20
    //   6580: new 2776	aovm
    //   6583: dup
    //   6584: bipush 21
    //   6586: iconst_2
    //   6587: invokespecial 2830	aovm:<init>	(SB)V
    //   6590: astore 17
    //   6592: aload 19
    //   6594: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   6597: ifnull +129 -> 6726
    //   6600: aload 19
    //   6602: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   6605: invokevirtual 113	com/tencent/mobileqq/pb/PBRepeatField:size	()I
    //   6608: ifle +118 -> 6726
    //   6611: aload 19
    //   6613: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   6616: invokevirtual 1147	com/tencent/mobileqq/pb/PBRepeatField:get	()Ljava/util/List;
    //   6619: invokeinterface 233 1 0
    //   6624: astore 21
    //   6626: aload 21
    //   6628: invokeinterface 238 1 0
    //   6633: ifeq +132 -> 6765
    //   6636: aload 21
    //   6638: invokeinterface 242 1 0
    //   6643: checkcast 118	java/lang/String
    //   6646: astore 22
    //   6648: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6651: ifeq +47 -> 6698
    //   6654: ldc 183
    //   6656: iconst_2
    //   6657: new 85	java/lang/StringBuilder
    //   6660: dup
    //   6661: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   6664: ldc_w 2832
    //   6667: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6670: aload 22
    //   6672: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6675: ldc_w 604
    //   6678: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6681: aload 19
    //   6683: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   6686: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   6689: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6692: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6695: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   6698: aload 17
    //   6700: aload 22
    //   6702: aload 20
    //   6704: invokestatic 2835	aova:a	(Laovm;Ljava/lang/String;Ljava/util/Set;)Z
    //   6707: pop
    //   6708: aload 16
    //   6710: aload 17
    //   6712: aload 19
    //   6714: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   6717: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   6720: invokevirtual 2838	aovk:a	(Laovm;I)V
    //   6723: goto -97 -> 6626
    //   6726: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6729: ifeq +36 -> 6765
    //   6732: ldc 183
    //   6734: iconst_2
    //   6735: new 85	java/lang/StringBuilder
    //   6738: dup
    //   6739: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   6742: ldc_w 2840
    //   6745: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6748: aload 19
    //   6750: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   6753: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   6756: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6759: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6762: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   6765: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6768: ifeq +76 -> 6844
    //   6771: new 85	java/lang/StringBuilder
    //   6774: dup
    //   6775: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   6778: ldc_w 2842
    //   6781: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6784: astore 20
    //   6786: aload 19
    //   6788: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   6791: ifnonnull +69 -> 6860
    //   6794: iconst_0
    //   6795: istore 7
    //   6797: ldc 183
    //   6799: iconst_2
    //   6800: aload 20
    //   6802: iload 7
    //   6804: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6807: ldc_w 2844
    //   6810: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6813: aload 17
    //   6815: invokevirtual 2845	aovm:a	()I
    //   6818: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6821: ldc_w 2847
    //   6824: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6827: aload 19
    //   6829: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   6832: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   6835: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6838: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6841: invokestatic 199	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   6844: aload 16
    //   6846: aload 19
    //   6848: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   6851: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   6854: invokevirtual 2848	aovk:a	(I)V
    //   6857: goto +5284 -> 12141
    //   6860: aload 19
    //   6862: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   6865: invokevirtual 1147	com/tencent/mobileqq/pb/PBRepeatField:get	()Ljava/util/List;
    //   6868: invokeinterface 400 1 0
    //   6873: istore 7
    //   6875: goto -78 -> 6797
    //   6878: aload_2
    //   6879: invokevirtual 65	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   6882: aload_2
    //   6883: invokevirtual 411	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   6886: invokestatic 1418	bdiv:j	(Landroid/content/Context;Ljava/lang/String;)I
    //   6889: istore 8
    //   6891: aload 19
    //   6893: ifnull +5324 -> 12217
    //   6896: aload 19
    //   6898: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   6901: ifnull +5316 -> 12217
    //   6904: aload 19
    //   6906: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   6909: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   6912: istore 7
    //   6914: aload 19
    //   6916: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   6919: ifnull +185 -> 7104
    //   6922: aload 19
    //   6924: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   6927: invokevirtual 113	com/tencent/mobileqq/pb/PBRepeatField:size	()I
    //   6930: ifle +174 -> 7104
    //   6933: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6936: ifeq +79 -> 7015
    //   6939: ldc 183
    //   6941: iconst_2
    //   6942: new 85	java/lang/StringBuilder
    //   6945: dup
    //   6946: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   6949: ldc_w 2850
    //   6952: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6955: iload 7
    //   6957: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6960: ldc_w 2852
    //   6963: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6966: iload 8
    //   6968: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6971: ldc_w 2854
    //   6974: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6977: aload 19
    //   6979: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   6982: invokevirtual 113	com/tencent/mobileqq/pb/PBRepeatField:size	()I
    //   6985: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6988: ldc_w 2856
    //   6991: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6994: aload 19
    //   6996: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   6999: iconst_0
    //   7000: invokevirtual 116	com/tencent/mobileqq/pb/PBRepeatField:get	(I)Ljava/lang/Object;
    //   7003: checkcast 118	java/lang/String
    //   7006: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7009: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7012: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   7015: new 522	java/util/HashSet
    //   7018: dup
    //   7019: invokespecial 523	java/util/HashSet:<init>	()V
    //   7022: astore 16
    //   7024: iconst_0
    //   7025: istore 8
    //   7027: iload 8
    //   7029: aload 19
    //   7031: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   7034: invokevirtual 113	com/tencent/mobileqq/pb/PBRepeatField:size	()I
    //   7037: if_icmpge +30 -> 7067
    //   7040: aload 16
    //   7042: aload 19
    //   7044: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   7047: iload 8
    //   7049: invokevirtual 116	com/tencent/mobileqq/pb/PBRepeatField:get	(I)Ljava/lang/Object;
    //   7052: invokeinterface 2859 2 0
    //   7057: pop
    //   7058: iload 8
    //   7060: iconst_1
    //   7061: iadd
    //   7062: istore 8
    //   7064: goto -37 -> 7027
    //   7067: aload_2
    //   7068: sipush 138
    //   7071: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   7074: checkcast 2861	agyc
    //   7077: aload 16
    //   7079: invokevirtual 2864	agyc:a	(Ljava/util/Set;)V
    //   7082: aload_0
    //   7083: invokevirtual 47	aova:getAppRuntime	()Lmqq/app/AppRuntime;
    //   7086: invokevirtual 2602	mqq/app/AppRuntime:getApplication	()Lmqq/app/MobileQQ;
    //   7089: aload_0
    //   7090: invokevirtual 47	aova:getAppRuntime	()Lmqq/app/AppRuntime;
    //   7093: invokevirtual 2792	mqq/app/AppRuntime:getAccount	()Ljava/lang/String;
    //   7096: iload 7
    //   7098: invokestatic 2865	bdiv:b	(Landroid/content/Context;Ljava/lang/String;I)V
    //   7101: goto +5123 -> 12224
    //   7104: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7107: ifeq +41 -> 7148
    //   7110: ldc 183
    //   7112: iconst_2
    //   7113: new 85	java/lang/StringBuilder
    //   7116: dup
    //   7117: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   7120: ldc_w 2867
    //   7123: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7126: iload 7
    //   7128: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7131: ldc_w 2852
    //   7134: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7137: iload 8
    //   7139: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7142: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7145: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   7148: iload 8
    //   7150: iload 7
    //   7152: if_icmpeq +5072 -> 12224
    //   7155: aload_2
    //   7156: sipush 138
    //   7159: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   7162: checkcast 2861	agyc
    //   7165: invokevirtual 2868	agyc:a	()V
    //   7168: aload_0
    //   7169: invokevirtual 47	aova:getAppRuntime	()Lmqq/app/AppRuntime;
    //   7172: invokevirtual 2602	mqq/app/AppRuntime:getApplication	()Lmqq/app/MobileQQ;
    //   7175: aload_0
    //   7176: invokevirtual 47	aova:getAppRuntime	()Lmqq/app/AppRuntime;
    //   7179: invokevirtual 2792	mqq/app/AppRuntime:getAccount	()Ljava/lang/String;
    //   7182: iload 7
    //   7184: invokestatic 2865	bdiv:b	(Landroid/content/Context;Ljava/lang/String;I)V
    //   7187: goto +5037 -> 12224
    //   7190: aload 19
    //   7192: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   7195: ifnull +4924 -> 12119
    //   7198: aload 19
    //   7200: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   7203: invokevirtual 113	com/tencent/mobileqq/pb/PBRepeatField:size	()I
    //   7206: ifle +4913 -> 12119
    //   7209: aload 19
    //   7211: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   7214: invokevirtual 1147	com/tencent/mobileqq/pb/PBRepeatField:get	()Ljava/util/List;
    //   7217: astore 16
    //   7219: aload 16
    //   7221: ifnull +195 -> 7416
    //   7224: aload 16
    //   7226: invokeinterface 400 1 0
    //   7231: ifle +185 -> 7416
    //   7234: aload 16
    //   7236: iconst_0
    //   7237: invokeinterface 447 2 0
    //   7242: checkcast 118	java/lang/String
    //   7245: astore 17
    //   7247: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7250: ifeq +47 -> 7297
    //   7253: ldc 183
    //   7255: iconst_2
    //   7256: new 85	java/lang/StringBuilder
    //   7259: dup
    //   7260: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   7263: ldc_w 2870
    //   7266: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7269: aload 17
    //   7271: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7274: ldc_w 604
    //   7277: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7280: aload 19
    //   7282: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   7285: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   7288: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7291: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7294: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   7297: aload 17
    //   7299: invokestatic 2873	nbp:a	(Ljava/lang/String;)V
    //   7302: aload 16
    //   7304: invokeinterface 233 1 0
    //   7309: astore 16
    //   7311: aload 16
    //   7313: invokeinterface 238 1 0
    //   7318: ifeq +73 -> 7391
    //   7321: aload 16
    //   7323: invokeinterface 242 1 0
    //   7328: checkcast 118	java/lang/String
    //   7331: astore 17
    //   7333: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7336: ifeq +47 -> 7383
    //   7339: ldc 183
    //   7341: iconst_2
    //   7342: new 85	java/lang/StringBuilder
    //   7345: dup
    //   7346: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   7349: ldc_w 2870
    //   7352: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7355: aload 17
    //   7357: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7360: ldc_w 604
    //   7363: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7366: aload 19
    //   7368: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   7371: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   7374: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7377: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7380: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   7383: aload 17
    //   7385: invokestatic 2876	agur:a	(Ljava/lang/String;)Z
    //   7388: ifeq -77 -> 7311
    //   7391: aload 19
    //   7393: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   7396: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   7399: istore 7
    //   7401: aload_0
    //   7402: invokevirtual 47	aova:getAppRuntime	()Lmqq/app/AppRuntime;
    //   7405: invokevirtual 2602	mqq/app/AppRuntime:getApplication	()Lmqq/app/MobileQQ;
    //   7408: iload 7
    //   7410: invokestatic 2879	bdiv:b	(Landroid/content/Context;I)V
    //   7413: goto +4728 -> 12141
    //   7416: aconst_null
    //   7417: invokestatic 2873	nbp:a	(Ljava/lang/String;)V
    //   7420: invokestatic 2880	agur:a	()V
    //   7423: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7426: ifeq -35 -> 7391
    //   7429: ldc 183
    //   7431: iconst_2
    //   7432: new 85	java/lang/StringBuilder
    //   7435: dup
    //   7436: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   7439: ldc_w 2882
    //   7442: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7445: aload 19
    //   7447: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   7450: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   7453: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7456: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7459: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   7462: goto -71 -> 7391
    //   7465: invokestatic 385	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   7468: aload_2
    //   7469: invokevirtual 69	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   7472: invokestatic 1430	cooperation/pluginbridge/BridgeHelper:a	(Landroid/content/Context;Ljava/lang/String;)Lcooperation/pluginbridge/BridgeHelper;
    //   7475: aload 19
    //   7477: invokevirtual 2883	cooperation/pluginbridge/BridgeHelper:a	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   7480: goto +4661 -> 12141
    //   7483: aload_0
    //   7484: aload_3
    //   7485: aload 19
    //   7487: invokespecial 2886	aova:l	(Landroid/content/Intent;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   7490: goto +4651 -> 12141
    //   7493: aload_0
    //   7494: aload_3
    //   7495: aload 19
    //   7497: invokespecial 2888	aova:j	(Landroid/content/Intent;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   7500: goto +4641 -> 12141
    //   7503: aload_0
    //   7504: aload_3
    //   7505: aload 19
    //   7507: invokespecial 2890	aova:k	(Landroid/content/Intent;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   7510: goto +4631 -> 12141
    //   7513: aload_0
    //   7514: aload 19
    //   7516: invokespecial 2892	aova:j	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   7519: goto +4622 -> 12141
    //   7522: aload_0
    //   7523: aload 19
    //   7525: invokespecial 2894	aova:i	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   7528: goto +4613 -> 12141
    //   7531: aload 19
    //   7533: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   7536: ifnull +103 -> 7639
    //   7539: aload 19
    //   7541: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   7544: invokevirtual 113	com/tencent/mobileqq/pb/PBRepeatField:size	()I
    //   7547: ifle +92 -> 7639
    //   7550: aload 19
    //   7552: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   7555: iconst_0
    //   7556: invokevirtual 116	com/tencent/mobileqq/pb/PBRepeatField:get	(I)Ljava/lang/Object;
    //   7559: checkcast 118	java/lang/String
    //   7562: astore 16
    //   7564: aload 19
    //   7566: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   7569: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   7572: istore 7
    //   7574: aload_2
    //   7575: invokevirtual 2897	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/av/gaudio/AVNotifyCenter;
    //   7578: aload_2
    //   7579: aload 16
    //   7581: iload 7
    //   7583: invokevirtual 2901	com/tencent/av/gaudio/AVNotifyCenter:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;I)V
    //   7586: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7589: ifeq +4638 -> 12227
    //   7592: ldc 183
    //   7594: iconst_2
    //   7595: new 85	java/lang/StringBuilder
    //   7598: dup
    //   7599: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   7602: ldc_w 2903
    //   7605: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7608: aload 16
    //   7610: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7613: ldc_w 604
    //   7616: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7619: aload 19
    //   7621: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   7624: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   7627: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7630: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7633: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   7636: goto +4591 -> 12227
    //   7639: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7642: ifeq +4499 -> 12141
    //   7645: ldc 183
    //   7647: iconst_2
    //   7648: new 85	java/lang/StringBuilder
    //   7651: dup
    //   7652: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   7655: ldc_w 2905
    //   7658: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7661: aload 19
    //   7663: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   7666: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   7669: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7672: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7675: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   7678: goto +4463 -> 12141
    //   7681: aload_2
    //   7682: sipush 177
    //   7685: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   7688: checkcast 2907	bdot
    //   7691: astore 16
    //   7693: aload 19
    //   7695: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   7698: ifnull +98 -> 7796
    //   7701: aload 19
    //   7703: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   7706: invokevirtual 113	com/tencent/mobileqq/pb/PBRepeatField:size	()I
    //   7709: ifle +87 -> 7796
    //   7712: aload 19
    //   7714: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   7717: iconst_0
    //   7718: invokevirtual 116	com/tencent/mobileqq/pb/PBRepeatField:get	(I)Ljava/lang/Object;
    //   7721: checkcast 118	java/lang/String
    //   7724: astore 17
    //   7726: aload 19
    //   7728: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   7731: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   7734: istore 7
    //   7736: aload 16
    //   7738: aload 17
    //   7740: aload_2
    //   7741: invokevirtual 411	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   7744: iload 7
    //   7746: invokevirtual 2910	bdot:a	(Ljava/lang/String;Ljava/lang/String;I)V
    //   7749: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7752: ifeq +4478 -> 12230
    //   7755: ldc 183
    //   7757: iconst_2
    //   7758: new 85	java/lang/StringBuilder
    //   7761: dup
    //   7762: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   7765: ldc_w 2912
    //   7768: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7771: aload 17
    //   7773: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7776: ldc_w 604
    //   7779: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7782: iload 7
    //   7784: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7787: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7790: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   7793: goto +4437 -> 12230
    //   7796: aload 16
    //   7798: aload 19
    //   7800: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   7803: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   7806: aload_2
    //   7807: invokevirtual 411	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   7810: invokevirtual 2915	bdot:a	(ILjava/lang/String;)V
    //   7813: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7816: ifeq +4417 -> 12233
    //   7819: ldc 183
    //   7821: iconst_2
    //   7822: new 85	java/lang/StringBuilder
    //   7825: dup
    //   7826: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   7829: ldc_w 2917
    //   7832: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7835: aload 19
    //   7837: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   7840: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   7843: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7846: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7849: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   7852: goto +4381 -> 12233
    //   7855: aload_0
    //   7856: aload_3
    //   7857: aload 19
    //   7859: invokespecial 2919	aova:i	(Landroid/content/Intent;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   7862: goto +4279 -> 12141
    //   7865: aload_0
    //   7866: aload_3
    //   7867: aload 19
    //   7869: invokespecial 2921	aova:e	(Landroid/content/Intent;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   7872: goto +4269 -> 12141
    //   7875: aload_0
    //   7876: aload_3
    //   7877: aload 19
    //   7879: invokespecial 2923	aova:f	(Landroid/content/Intent;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   7882: goto +4259 -> 12141
    //   7885: aload_0
    //   7886: aload_3
    //   7887: aload 19
    //   7889: invokespecial 2925	aova:g	(Landroid/content/Intent;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   7892: goto +4249 -> 12141
    //   7895: aload_0
    //   7896: aload_2
    //   7897: aload_3
    //   7898: aload 19
    //   7900: invokespecial 2928	aova:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Landroid/content/Intent;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   7903: goto +4238 -> 12141
    //   7906: aload_0
    //   7907: aload_3
    //   7908: aload 19
    //   7910: invokespecial 2930	aova:h	(Landroid/content/Intent;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   7913: goto +4228 -> 12141
    //   7916: aload_0
    //   7917: aload 19
    //   7919: invokespecial 2932	aova:g	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   7922: goto +4219 -> 12141
    //   7925: aload_0
    //   7926: aload 19
    //   7928: invokespecial 2934	aova:h	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   7931: goto +4210 -> 12141
    //   7934: aload_0
    //   7935: aload_2
    //   7936: aload 19
    //   7938: invokespecial 2936	aova:ae	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   7941: goto +4200 -> 12141
    //   7944: aload_2
    //   7945: invokestatic 1517	com/tencent/mobileqq/utils/BusinessCommonConfig:getInstance	(Lmqq/app/AppRuntime;)Lcom/tencent/mobileqq/utils/BusinessCommonConfig;
    //   7948: aload_2
    //   7949: aload 16
    //   7951: invokevirtual 1829	java/lang/Integer:intValue	()I
    //   7954: aload_3
    //   7955: aload 19
    //   7957: invokevirtual 2940	com/tencent/mobileqq/utils/BusinessCommonConfig:decodeConfig	(Lcom/tencent/mobileqq/app/QQAppInterface;ILandroid/content/Intent;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)Ljava/lang/Boolean;
    //   7960: pop
    //   7961: goto +4180 -> 12141
    //   7964: aload 19
    //   7966: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   7969: ifnull +164 -> 8133
    //   7972: aload 19
    //   7974: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   7977: invokevirtual 113	com/tencent/mobileqq/pb/PBRepeatField:size	()I
    //   7980: ifle +153 -> 8133
    //   7983: aload 19
    //   7985: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   7988: invokevirtual 1147	com/tencent/mobileqq/pb/PBRepeatField:get	()Ljava/util/List;
    //   7991: invokeinterface 233 1 0
    //   7996: astore 16
    //   7998: aload 16
    //   8000: invokeinterface 238 1 0
    //   8005: ifeq +167 -> 8172
    //   8008: aload 16
    //   8010: invokeinterface 242 1 0
    //   8015: checkcast 118	java/lang/String
    //   8018: astore 17
    //   8020: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   8023: ifeq +47 -> 8070
    //   8026: ldc 183
    //   8028: iconst_2
    //   8029: new 85	java/lang/StringBuilder
    //   8032: dup
    //   8033: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   8036: ldc_w 2942
    //   8039: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8042: aload 17
    //   8044: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8047: ldc_w 604
    //   8050: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8053: aload 19
    //   8055: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   8058: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   8061: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   8064: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8067: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   8070: aload_0
    //   8071: aload 17
    //   8073: aload 19
    //   8075: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   8078: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   8081: invokespecial 2944	aova:a	(Ljava/lang/String;I)V
    //   8084: goto -86 -> 7998
    //   8087: astore 16
    //   8089: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   8092: ifeq +33 -> 8125
    //   8095: ldc 183
    //   8097: iconst_2
    //   8098: new 85	java/lang/StringBuilder
    //   8101: dup
    //   8102: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   8105: ldc_w 2946
    //   8108: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8111: aload 16
    //   8113: invokevirtual 640	java/lang/Exception:toString	()Ljava/lang/String;
    //   8116: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8119: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8122: invokestatic 642	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   8125: aload 16
    //   8127: invokevirtual 458	java/lang/Exception:printStackTrace	()V
    //   8130: goto +4011 -> 12141
    //   8133: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   8136: ifeq +36 -> 8172
    //   8139: ldc 183
    //   8141: iconst_2
    //   8142: new 85	java/lang/StringBuilder
    //   8145: dup
    //   8146: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   8149: ldc_w 2948
    //   8152: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8155: aload 19
    //   8157: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   8160: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   8163: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   8166: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8169: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   8172: goto +3969 -> 12141
    //   8175: aload 19
    //   8177: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   8180: ifnull +164 -> 8344
    //   8183: aload 19
    //   8185: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   8188: invokevirtual 113	com/tencent/mobileqq/pb/PBRepeatField:size	()I
    //   8191: ifle +153 -> 8344
    //   8194: aload 19
    //   8196: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   8199: invokevirtual 1147	com/tencent/mobileqq/pb/PBRepeatField:get	()Ljava/util/List;
    //   8202: invokeinterface 233 1 0
    //   8207: astore 16
    //   8209: aload 16
    //   8211: invokeinterface 238 1 0
    //   8216: ifeq +167 -> 8383
    //   8219: aload 16
    //   8221: invokeinterface 242 1 0
    //   8226: checkcast 118	java/lang/String
    //   8229: astore 17
    //   8231: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   8234: ifeq +47 -> 8281
    //   8237: ldc 183
    //   8239: iconst_2
    //   8240: new 85	java/lang/StringBuilder
    //   8243: dup
    //   8244: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   8247: ldc_w 2950
    //   8250: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8253: aload 17
    //   8255: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8258: ldc_w 604
    //   8261: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8264: aload 19
    //   8266: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   8269: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   8272: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   8275: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8278: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   8281: aload_0
    //   8282: aload 17
    //   8284: aload 19
    //   8286: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   8289: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   8292: invokespecial 2952	aova:b	(Ljava/lang/String;I)V
    //   8295: goto -86 -> 8209
    //   8298: astore 16
    //   8300: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   8303: ifeq +33 -> 8336
    //   8306: ldc 183
    //   8308: iconst_2
    //   8309: new 85	java/lang/StringBuilder
    //   8312: dup
    //   8313: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   8316: ldc_w 2954
    //   8319: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8322: aload 16
    //   8324: invokevirtual 640	java/lang/Exception:toString	()Ljava/lang/String;
    //   8327: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8330: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8333: invokestatic 642	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   8336: aload 16
    //   8338: invokevirtual 458	java/lang/Exception:printStackTrace	()V
    //   8341: goto +3800 -> 12141
    //   8344: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   8347: ifeq +36 -> 8383
    //   8350: ldc 183
    //   8352: iconst_2
    //   8353: new 85	java/lang/StringBuilder
    //   8356: dup
    //   8357: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   8360: ldc_w 2956
    //   8363: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8366: aload 19
    //   8368: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   8371: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   8374: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   8377: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8380: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   8383: goto +3758 -> 12141
    //   8386: aload_0
    //   8387: aload 19
    //   8389: invokespecial 2958	aova:p	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8392: goto +3749 -> 12141
    //   8395: aload_0
    //   8396: aload 19
    //   8398: invokespecial 2960	aova:m	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8401: goto +3740 -> 12141
    //   8404: aload_0
    //   8405: aload 19
    //   8407: invokespecial 2962	aova:n	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8410: goto +3731 -> 12141
    //   8413: aload_0
    //   8414: aload 19
    //   8416: invokespecial 2964	aova:o	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8419: goto +3722 -> 12141
    //   8422: aload_0
    //   8423: aload 19
    //   8425: invokespecial 2966	aova:t	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8428: goto +3713 -> 12141
    //   8431: aload_0
    //   8432: aload 19
    //   8434: invokespecial 2968	aova:r	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8437: goto +3704 -> 12141
    //   8440: aload_0
    //   8441: aload 19
    //   8443: invokespecial 2970	aova:d	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8446: goto +3695 -> 12141
    //   8449: aload_0
    //   8450: aload 19
    //   8452: invokespecial 2972	aova:q	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8455: goto +3686 -> 12141
    //   8458: aload_0
    //   8459: aload 19
    //   8461: invokespecial 2974	aova:s	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8464: goto +3677 -> 12141
    //   8467: aload_0
    //   8468: aload 19
    //   8470: invokespecial 2976	aova:k	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8473: goto +3668 -> 12141
    //   8476: aload_0
    //   8477: aload 19
    //   8479: invokevirtual 2978	aova:b	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8482: goto +3659 -> 12141
    //   8485: aload_0
    //   8486: aload 19
    //   8488: invokevirtual 2980	aova:c	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8491: goto +3650 -> 12141
    //   8494: aload_0
    //   8495: aload 19
    //   8497: invokespecial 2982	aova:v	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8500: goto +3641 -> 12141
    //   8503: aload_0
    //   8504: aload 19
    //   8506: invokespecial 2984	aova:w	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8509: goto +3632 -> 12141
    //   8512: aload_0
    //   8513: aload 19
    //   8515: invokespecial 2986	aova:z	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8518: goto +3623 -> 12141
    //   8521: aload_0
    //   8522: aload 19
    //   8524: invokespecial 2988	aova:B	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8527: goto +3614 -> 12141
    //   8530: aload_0
    //   8531: aload 19
    //   8533: invokespecial 2990	aova:x	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8536: goto +3605 -> 12141
    //   8539: aload_0
    //   8540: aload 19
    //   8542: invokespecial 2992	aova:y	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8545: goto +3596 -> 12141
    //   8548: aload_0
    //   8549: aload 19
    //   8551: invokespecial 2994	aova:l	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8554: goto +3587 -> 12141
    //   8557: aload_0
    //   8558: aload 19
    //   8560: invokespecial 2996	aova:u	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8563: goto +3578 -> 12141
    //   8566: invokestatic 2999	com/tencent/mobileqq/app/DeviceProfileManager:a	()Lcom/tencent/mobileqq/app/DeviceProfileManager;
    //   8569: aload_1
    //   8570: ldc 13
    //   8572: invokevirtual 3002	com/tencent/mobileqq/app/DeviceProfileManager:a	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig;Ljava/lang/String;)Z
    //   8575: pop
    //   8576: goto +3565 -> 12141
    //   8579: aload_0
    //   8580: aload 19
    //   8582: invokespecial 3004	aova:e	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8585: goto +3556 -> 12141
    //   8588: aload_0
    //   8589: aload 19
    //   8591: invokespecial 3006	aova:f	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8594: goto +3547 -> 12141
    //   8597: aload_0
    //   8598: aload 19
    //   8600: invokevirtual 3007	aova:a	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8603: goto +3538 -> 12141
    //   8606: aload_0
    //   8607: aload 19
    //   8609: invokespecial 3009	aova:A	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8612: goto +3529 -> 12141
    //   8615: aload 19
    //   8617: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   8620: ifnull +141 -> 8761
    //   8623: aload 19
    //   8625: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   8628: invokevirtual 113	com/tencent/mobileqq/pb/PBRepeatField:size	()I
    //   8631: ifle +130 -> 8761
    //   8634: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   8637: ifeq +68 -> 8705
    //   8640: ldc 183
    //   8642: iconst_2
    //   8643: new 85	java/lang/StringBuilder
    //   8646: dup
    //   8647: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   8650: ldc_w 3011
    //   8653: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8656: aload 16
    //   8658: invokevirtual 798	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   8661: ldc_w 2856
    //   8664: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8667: aload 19
    //   8669: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   8672: iconst_0
    //   8673: invokevirtual 116	com/tencent/mobileqq/pb/PBRepeatField:get	(I)Ljava/lang/Object;
    //   8676: checkcast 118	java/lang/String
    //   8679: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8682: ldc_w 604
    //   8685: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8688: aload 19
    //   8690: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   8693: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   8696: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   8699: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8702: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   8705: aload_2
    //   8706: sipush 169
    //   8709: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   8712: checkcast 3013	cooperation/photoplus/PhotoPlusManager
    //   8715: aload 19
    //   8717: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   8720: iconst_0
    //   8721: invokevirtual 116	com/tencent/mobileqq/pb/PBRepeatField:get	(I)Ljava/lang/Object;
    //   8724: checkcast 118	java/lang/String
    //   8727: invokevirtual 3014	cooperation/photoplus/PhotoPlusManager:a	(Ljava/lang/String;)Z
    //   8730: ifeq +3411 -> 12141
    //   8733: aload_0
    //   8734: invokevirtual 47	aova:getAppRuntime	()Lmqq/app/AppRuntime;
    //   8737: invokevirtual 2602	mqq/app/AppRuntime:getApplication	()Lmqq/app/MobileQQ;
    //   8740: aload_0
    //   8741: invokevirtual 47	aova:getAppRuntime	()Lmqq/app/AppRuntime;
    //   8744: invokevirtual 2792	mqq/app/AppRuntime:getAccount	()Ljava/lang/String;
    //   8747: aload 19
    //   8749: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   8752: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   8755: invokestatic 3016	bdiv:r	(Landroid/content/Context;Ljava/lang/String;I)V
    //   8758: goto +3383 -> 12141
    //   8761: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   8764: ifeq +3377 -> 12141
    //   8767: ldc 183
    //   8769: iconst_2
    //   8770: new 85	java/lang/StringBuilder
    //   8773: dup
    //   8774: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   8777: ldc_w 3011
    //   8780: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8783: aload 16
    //   8785: invokevirtual 798	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   8788: ldc_w 3018
    //   8791: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8794: aload 19
    //   8796: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   8799: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   8802: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   8805: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8808: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   8811: goto +3330 -> 12141
    //   8814: aload_0
    //   8815: aload_2
    //   8816: aload 19
    //   8818: invokevirtual 3020	aova:e	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8821: goto +3320 -> 12141
    //   8824: aload_0
    //   8825: aload_3
    //   8826: iload 5
    //   8828: aload 19
    //   8830: aload_1
    //   8831: getfield 2392	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:result	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   8834: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   8837: invokevirtual 3023	aova:a	(Landroid/content/Intent;ZLcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;I)V
    //   8840: goto +3301 -> 12141
    //   8843: aload_0
    //   8844: aload_3
    //   8845: aload 19
    //   8847: invokespecial 3025	aova:c	(Landroid/content/Intent;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8850: goto +3291 -> 12141
    //   8853: aload_0
    //   8854: aload_3
    //   8855: aload 19
    //   8857: invokespecial 3027	aova:b	(Landroid/content/Intent;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8860: goto +3281 -> 12141
    //   8863: aload_0
    //   8864: aload_3
    //   8865: aload 19
    //   8867: invokespecial 3029	aova:d	(Landroid/content/Intent;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8870: goto +3271 -> 12141
    //   8873: aload_0
    //   8874: aload_3
    //   8875: aload 19
    //   8877: invokevirtual 3031	aova:a	(Landroid/content/Intent;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8880: goto +3261 -> 12141
    //   8883: aload_0
    //   8884: aload_2
    //   8885: aload_3
    //   8886: aload 19
    //   8888: invokevirtual 3033	aova:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Landroid/content/Intent;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8891: goto +3250 -> 12141
    //   8894: aload_0
    //   8895: aload_2
    //   8896: aload 19
    //   8898: invokespecial 3035	aova:U	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8901: goto +3240 -> 12141
    //   8904: aload_0
    //   8905: aload_2
    //   8906: aload 19
    //   8908: invokespecial 3037	aova:af	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8911: goto +3230 -> 12141
    //   8914: aload 16
    //   8916: invokevirtual 1829	java/lang/Integer:intValue	()I
    //   8919: aload_2
    //   8920: invokevirtual 1592	com/tencent/mobileqq/app/QQAppInterface:c	()Ljava/lang/String;
    //   8923: aload 19
    //   8925: invokestatic 3040	lfa:a	(ILjava/lang/String;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8928: goto +3213 -> 12141
    //   8931: aload_0
    //   8932: aload_2
    //   8933: aload 19
    //   8935: invokevirtual 3042	aova:d	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8938: goto +3203 -> 12141
    //   8941: aload_0
    //   8942: aload_3
    //   8943: iload 5
    //   8945: aload 19
    //   8947: aload_1
    //   8948: getfield 2392	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:result	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   8951: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   8954: invokevirtual 3044	aova:b	(Landroid/content/Intent;ZLcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;I)V
    //   8957: goto +3184 -> 12141
    //   8960: aload_0
    //   8961: aload_2
    //   8962: aload 19
    //   8964: invokespecial 3046	aova:Z	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8967: goto +3174 -> 12141
    //   8970: aload_0
    //   8971: aload_2
    //   8972: aload 19
    //   8974: invokespecial 3048	aova:V	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8977: goto +3164 -> 12141
    //   8980: aload_0
    //   8981: aload_2
    //   8982: aload 19
    //   8984: invokespecial 3050	aova:W	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8987: goto +3154 -> 12141
    //   8990: aload_0
    //   8991: aload_2
    //   8992: aload 19
    //   8994: invokespecial 3052	aova:X	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8997: goto +3144 -> 12141
    //   9000: aload_0
    //   9001: aload_2
    //   9002: aload 19
    //   9004: invokespecial 3054	aova:Y	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9007: goto +3134 -> 12141
    //   9010: aload_0
    //   9011: aload_2
    //   9012: aload 19
    //   9014: invokevirtual 3056	aova:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9017: goto +3124 -> 12141
    //   9020: aload_0
    //   9021: aload_2
    //   9022: aload 19
    //   9024: invokespecial 3058	aova:ag	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9027: goto +3114 -> 12141
    //   9030: aload_0
    //   9031: aload_2
    //   9032: aload 19
    //   9034: invokespecial 3060	aova:ah	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9037: goto +3104 -> 12141
    //   9040: aload_0
    //   9041: aload_2
    //   9042: aload 19
    //   9044: invokespecial 3062	aova:ai	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9047: goto +3094 -> 12141
    //   9050: aload_0
    //   9051: aload_2
    //   9052: aload 19
    //   9054: invokespecial 3064	aova:aj	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9057: goto +3084 -> 12141
    //   9060: aload 19
    //   9062: invokestatic 3065	ayra:a	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9065: goto +3076 -> 12141
    //   9068: aload_0
    //   9069: aload_2
    //   9070: aload 19
    //   9072: invokespecial 3067	aova:ak	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9075: goto +3066 -> 12141
    //   9078: aload_0
    //   9079: aload_2
    //   9080: aload 19
    //   9082: invokespecial 3069	aova:al	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9085: goto +3056 -> 12141
    //   9088: aload_0
    //   9089: aload_2
    //   9090: aload 19
    //   9092: invokespecial 3072	aova:am	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9095: goto +3046 -> 12141
    //   9098: aload_0
    //   9099: aload_2
    //   9100: aload 19
    //   9102: invokespecial 3074	aova:an	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9105: goto +3036 -> 12141
    //   9108: aload_0
    //   9109: aload_2
    //   9110: aload 19
    //   9112: invokevirtual 3076	aova:f	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9115: goto +3026 -> 12141
    //   9118: aload_0
    //   9119: aload_3
    //   9120: aload 19
    //   9122: invokespecial 3078	aova:m	(Landroid/content/Intent;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9125: goto +3016 -> 12141
    //   9128: aload_0
    //   9129: aload_2
    //   9130: aload 19
    //   9132: invokespecial 3081	aova:ao	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9135: goto +3006 -> 12141
    //   9138: aload_0
    //   9139: aload_2
    //   9140: aload 19
    //   9142: invokevirtual 3083	aova:l	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9145: goto +2996 -> 12141
    //   9148: aload_0
    //   9149: aload_2
    //   9150: aload 19
    //   9152: invokevirtual 3085	aova:i	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9155: goto +2986 -> 12141
    //   9158: aload_2
    //   9159: sipush 208
    //   9162: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   9165: checkcast 1853	xlf
    //   9168: getfield 1856	xlf:a	Lxle;
    //   9171: aload_2
    //   9172: aload 19
    //   9174: invokevirtual 3088	xle:a	(Lcom/tencent/common/app/AppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9177: goto +2964 -> 12141
    //   9180: aload_0
    //   9181: aload_2
    //   9182: aload 19
    //   9184: invokevirtual 3090	aova:h	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9187: goto +2954 -> 12141
    //   9190: aload_0
    //   9191: aload_2
    //   9192: aload 19
    //   9194: invokevirtual 3092	aova:j	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9197: goto +2944 -> 12141
    //   9200: aload_0
    //   9201: aload_2
    //   9202: aload 19
    //   9204: invokevirtual 3094	aova:m	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9207: goto +2934 -> 12141
    //   9210: aload_0
    //   9211: aload_2
    //   9212: aload 19
    //   9214: invokevirtual 3096	aova:n	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9217: goto +2924 -> 12141
    //   9220: aload_0
    //   9221: aload_2
    //   9222: aload 19
    //   9224: invokevirtual 3098	aova:o	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9227: goto +2914 -> 12141
    //   9230: aload_0
    //   9231: aload_2
    //   9232: aload 19
    //   9234: invokevirtual 3100	aova:q	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9237: goto +2904 -> 12141
    //   9240: aload_2
    //   9241: aload 19
    //   9243: invokestatic 3101	yqi:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9246: goto +2895 -> 12141
    //   9249: aload_0
    //   9250: aload_2
    //   9251: aload 19
    //   9253: invokespecial 3104	aova:ap	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9256: goto +2885 -> 12141
    //   9259: aload_0
    //   9260: aload_2
    //   9261: aload 19
    //   9263: invokevirtual 3106	aova:p	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9266: goto +2875 -> 12141
    //   9269: aload_0
    //   9270: aload_2
    //   9271: aload 19
    //   9273: invokevirtual 3108	aova:r	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9276: goto +2865 -> 12141
    //   9279: aload_0
    //   9280: aload_2
    //   9281: aload 19
    //   9283: invokevirtual 3110	aova:g	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9286: goto +2855 -> 12141
    //   9289: aload_0
    //   9290: aload_2
    //   9291: aload 19
    //   9293: invokevirtual 3112	aova:s	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9296: goto +2845 -> 12141
    //   9299: aload_0
    //   9300: aload_2
    //   9301: aload 19
    //   9303: invokespecial 3114	aova:aa	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9306: goto +2835 -> 12141
    //   9309: aload_0
    //   9310: aload_2
    //   9311: aload 19
    //   9313: invokespecial 3116	aova:ab	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9316: goto +2825 -> 12141
    //   9319: aload_0
    //   9320: aload_2
    //   9321: aload 19
    //   9323: invokevirtual 3118	aova:k	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9326: goto +2815 -> 12141
    //   9329: aload_0
    //   9330: aload_2
    //   9331: aload 19
    //   9333: invokevirtual 3120	aova:u	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9336: goto +2805 -> 12141
    //   9339: aload_2
    //   9340: aload 19
    //   9342: invokestatic 3122	aova:t	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9345: goto +2796 -> 12141
    //   9348: aload 19
    //   9350: aload_2
    //   9351: invokevirtual 1348	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   9354: invokestatic 1958	ajog:a	(Landroid/content/Context;)I
    //   9357: sipush 199
    //   9360: invokestatic 2280	aova:b	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;II)Ljava/lang/String;
    //   9363: astore 16
    //   9365: aload 16
    //   9367: ifnull +2774 -> 12141
    //   9370: aload_2
    //   9371: invokevirtual 1348	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   9374: aload 16
    //   9376: aload 19
    //   9378: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   9381: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   9384: invokestatic 3123	ajog:a	(Landroid/content/Context;Ljava/lang/String;I)V
    //   9387: goto +2754 -> 12141
    //   9390: aload 19
    //   9392: aload_2
    //   9393: invokevirtual 1348	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   9396: invokestatic 1961	axkd:a	(Landroid/content/Context;)I
    //   9399: sipush 225
    //   9402: invokestatic 2280	aova:b	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;II)Ljava/lang/String;
    //   9405: astore 16
    //   9407: aload 16
    //   9409: ifnull +2732 -> 12141
    //   9412: invokestatic 3126	axkd:a	()Laxkd;
    //   9415: aload_2
    //   9416: invokevirtual 1348	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   9419: aload 16
    //   9421: aload 19
    //   9423: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   9426: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   9429: invokevirtual 3127	axkd:a	(Landroid/content/Context;Ljava/lang/String;I)V
    //   9432: goto +2709 -> 12141
    //   9435: aload_0
    //   9436: aload_2
    //   9437: aload 19
    //   9439: invokevirtual 3129	aova:v	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9442: goto +2699 -> 12141
    //   9445: aload_0
    //   9446: aload_2
    //   9447: aload 19
    //   9449: invokevirtual 3131	aova:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9452: goto +2689 -> 12141
    //   9455: aload_0
    //   9456: aload_2
    //   9457: aload 19
    //   9459: invokespecial 3133	aova:aq	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9462: goto +2679 -> 12141
    //   9465: aload_2
    //   9466: aload 19
    //   9468: invokestatic 3135	aova:w	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9471: goto +2670 -> 12141
    //   9474: aload_2
    //   9475: aload 19
    //   9477: invokestatic 3137	aova:O	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9480: goto +2661 -> 12141
    //   9483: aload_0
    //   9484: aload_2
    //   9485: aload 19
    //   9487: invokespecial 3140	aova:as	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9490: goto +2651 -> 12141
    //   9493: aload_2
    //   9494: aload 19
    //   9496: invokestatic 3142	aova:P	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9499: goto +2642 -> 12141
    //   9502: aload_0
    //   9503: aload_2
    //   9504: aload 19
    //   9506: aload_3
    //   9507: ldc_w 2269
    //   9510: invokevirtual 1400	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   9513: invokespecial 3144	aova:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;Ljava/lang/String;)I
    //   9516: invokestatic 3145	com/tencent/mobileqq/shortvideo/ShortVideoResourceManager:b	(I)V
    //   9519: goto +2622 -> 12141
    //   9522: aload_2
    //   9523: sipush 238
    //   9526: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   9529: checkcast 3147	nmb
    //   9532: astore 16
    //   9534: aload 16
    //   9536: ifnull +2605 -> 12141
    //   9539: aload 16
    //   9541: aload_2
    //   9542: aload 19
    //   9544: invokevirtual 3148	nmb:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9547: goto +2594 -> 12141
    //   9550: aload_0
    //   9551: aload_2
    //   9552: aload 19
    //   9554: invokevirtual 3150	aova:y	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9557: goto +2584 -> 12141
    //   9560: aload_0
    //   9561: aload_2
    //   9562: aload 19
    //   9564: invokespecial 3152	aova:T	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9567: goto +2574 -> 12141
    //   9570: aload_2
    //   9571: sipush 231
    //   9574: getstatic 15	aova:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   9577: aload 19
    //   9579: invokestatic 3155	ajql:a	(Lcom/tencent/mobileqq/app/QQAppInterface;ILjava/lang/String;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9582: goto +2559 -> 12141
    //   9585: aload_0
    //   9586: aload_2
    //   9587: aload 19
    //   9589: invokevirtual 3157	aova:x	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9592: goto +2549 -> 12141
    //   9595: aload_0
    //   9596: aload_2
    //   9597: aload 19
    //   9599: invokevirtual 3159	aova:F	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9602: goto +2539 -> 12141
    //   9605: aload_0
    //   9606: aload_2
    //   9607: aload 19
    //   9609: invokevirtual 3161	aova:z	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9612: goto +2529 -> 12141
    //   9615: aload_0
    //   9616: aload_2
    //   9617: aload 19
    //   9619: invokevirtual 3163	aova:A	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9622: goto +2519 -> 12141
    //   9625: aload_0
    //   9626: aload_2
    //   9627: aload 19
    //   9629: invokevirtual 3165	aova:B	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9632: goto +2509 -> 12141
    //   9635: aload 19
    //   9637: ifnull +2602 -> 12239
    //   9640: aload 19
    //   9642: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   9645: ifnonnull +4 -> 9649
    //   9648: return
    //   9649: aload 19
    //   9651: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   9654: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   9657: aload_2
    //   9658: invokevirtual 65	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   9661: invokestatic 2013	bdiv:d	(Landroid/content/Context;)I
    //   9664: if_icmpeq +2575 -> 12239
    //   9667: aconst_null
    //   9668: astore 17
    //   9670: aload 17
    //   9672: astore 16
    //   9674: aload 19
    //   9676: getfield 221	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   9679: ifnull +79 -> 9758
    //   9682: aload 17
    //   9684: astore 16
    //   9686: aload 19
    //   9688: getfield 221	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   9691: invokevirtual 224	com/tencent/mobileqq/pb/PBRepeatMessageField:size	()I
    //   9694: ifle +64 -> 9758
    //   9697: aload 19
    //   9699: getfield 221	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   9702: iconst_0
    //   9703: invokevirtual 318	com/tencent/mobileqq/pb/PBRepeatMessageField:get	(I)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   9706: checkcast 244	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content
    //   9709: astore 16
    //   9711: aload 16
    //   9713: getfield 248	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content:compress	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   9716: invokevirtual 251	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   9719: iconst_1
    //   9720: if_icmpne +114 -> 9834
    //   9723: aload 16
    //   9725: getfield 255	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content:content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   9728: invokevirtual 260	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   9731: invokevirtual 266	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   9734: invokestatic 321	avxz:a	([B)[B
    //   9737: astore 17
    //   9739: aload 17
    //   9741: ifnull +2372 -> 12113
    //   9744: new 118	java/lang/String
    //   9747: dup
    //   9748: aload 17
    //   9750: ldc_w 323
    //   9753: invokespecial 326	java/lang/String:<init>	([BLjava/lang/String;)V
    //   9756: astore 16
    //   9758: aload 16
    //   9760: ifnull +33 -> 9793
    //   9763: new 128	org/json/JSONObject
    //   9766: dup
    //   9767: aload 16
    //   9769: invokespecial 131	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   9772: invokestatic 3168	abqk:a	(Lorg/json/JSONObject;)V
    //   9775: aload_0
    //   9776: invokevirtual 47	aova:getAppRuntime	()Lmqq/app/AppRuntime;
    //   9779: invokevirtual 2602	mqq/app/AppRuntime:getApplication	()Lmqq/app/MobileQQ;
    //   9782: aload 19
    //   9784: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   9787: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   9790: invokestatic 3170	bdiv:c	(Landroid/content/Context;I)V
    //   9793: goto +2348 -> 12141
    //   9796: astore 16
    //   9798: aconst_null
    //   9799: astore 16
    //   9801: goto -43 -> 9758
    //   9804: astore 16
    //   9806: invokestatic 2620	java/lang/System:gc	()V
    //   9809: new 118	java/lang/String
    //   9812: dup
    //   9813: aload 17
    //   9815: ldc_w 323
    //   9818: invokespecial 326	java/lang/String:<init>	([BLjava/lang/String;)V
    //   9821: astore 16
    //   9823: goto -65 -> 9758
    //   9826: astore 16
    //   9828: aconst_null
    //   9829: astore 16
    //   9831: goto -73 -> 9758
    //   9834: aload 16
    //   9836: getfield 255	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content:content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   9839: invokevirtual 260	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   9842: invokevirtual 280	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   9845: astore 16
    //   9847: goto -89 -> 9758
    //   9850: astore 16
    //   9852: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   9855: ifeq +2385 -> 12240
    //   9858: ldc 183
    //   9860: iconst_2
    //   9861: aload 16
    //   9863: iconst_0
    //   9864: anewarray 301	java/lang/Object
    //   9867: invokestatic 3172	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   9870: goto +2370 -> 12240
    //   9873: aload_0
    //   9874: aload_2
    //   9875: aload 19
    //   9877: invokevirtual 3174	aova:C	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9880: goto +2261 -> 12141
    //   9883: aload_0
    //   9884: aload_2
    //   9885: aload 19
    //   9887: invokevirtual 3176	aova:D	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9890: goto +2251 -> 12141
    //   9893: aload_0
    //   9894: aload_2
    //   9895: aload 19
    //   9897: invokevirtual 3178	aova:E	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9900: goto +2241 -> 12141
    //   9903: aload_0
    //   9904: aload_2
    //   9905: aload 19
    //   9907: invokespecial 3180	aova:ac	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9910: goto +2231 -> 12141
    //   9913: aload_0
    //   9914: aload_2
    //   9915: aload 19
    //   9917: invokespecial 3182	aova:ad	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9920: goto +2221 -> 12141
    //   9923: aload_0
    //   9924: aload_2
    //   9925: aload 19
    //   9927: invokespecial 3184	aova:S	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9930: goto +2211 -> 12141
    //   9933: aload_0
    //   9934: aload_2
    //   9935: aload 19
    //   9937: invokevirtual 3186	aova:G	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9940: goto +2201 -> 12141
    //   9943: aload_2
    //   9944: aload 19
    //   9946: invokestatic 3189	bccj:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9949: goto +2192 -> 12141
    //   9952: aload_2
    //   9953: bipush 52
    //   9955: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   9958: checkcast 2030	com/tencent/mobileqq/app/TroopManager
    //   9961: getfield 2033	com/tencent/mobileqq/app/TroopManager:jdField_a_of_type_Bbuv	Lbbuv;
    //   9964: aload_2
    //   9965: aload 19
    //   9967: invokevirtual 3190	bbuv:a	(Lcom/tencent/common/app/AppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9970: goto +2171 -> 12141
    //   9973: aload_2
    //   9974: bipush 52
    //   9976: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   9979: checkcast 2030	com/tencent/mobileqq/app/TroopManager
    //   9982: getfield 2041	com/tencent/mobileqq/app/TroopManager:jdField_a_of_type_Bbwz	Lbbwz;
    //   9985: aload_2
    //   9986: aload 19
    //   9988: invokevirtual 3191	bbwz:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9991: goto +2150 -> 12141
    //   9994: aload_2
    //   9995: invokestatic 3196	uhj:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)Luhj;
    //   9998: aload 19
    //   10000: invokevirtual 3197	uhj:a	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   10003: goto +2138 -> 12141
    //   10006: aload_2
    //   10007: sipush 197
    //   10010: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   10013: checkcast 3199	uhu
    //   10016: aload 19
    //   10018: invokevirtual 3200	uhu:a	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   10021: goto +2120 -> 12141
    //   10024: invokestatic 2052	asmt:a	()Lasmt;
    //   10027: getfield 2055	asmt:a	Lasmv;
    //   10030: aload 19
    //   10032: invokevirtual 3201	asmv:a	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   10035: goto +2106 -> 12141
    //   10038: astore 16
    //   10040: aload 16
    //   10042: invokevirtual 1833	java/lang/Throwable:printStackTrace	()V
    //   10045: goto +2096 -> 12141
    //   10048: aload_2
    //   10049: aload 19
    //   10051: invokestatic 3204	com/tencent/mobileqq/shortvideo/util/RecentDanceConfigMgr:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)I
    //   10054: pop
    //   10055: goto +2086 -> 12141
    //   10058: aload_2
    //   10059: aload 19
    //   10061: invokestatic 3205	dov/com/qq/im/ptv/LightVideoConfigMgr:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)I
    //   10064: pop
    //   10065: goto +2076 -> 12141
    //   10068: aload_0
    //   10069: aload_2
    //   10070: aload 19
    //   10072: invokevirtual 3207	aova:H	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   10075: goto +2066 -> 12141
    //   10078: aload_0
    //   10079: aload_2
    //   10080: aload 19
    //   10082: invokevirtual 3209	aova:I	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   10085: goto +2056 -> 12141
    //   10088: aload_0
    //   10089: aload_2
    //   10090: aload 19
    //   10092: invokevirtual 3211	aova:J	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   10095: goto +2046 -> 12141
    //   10098: aload_2
    //   10099: aload 19
    //   10101: aload 16
    //   10103: invokevirtual 1829	java/lang/Integer:intValue	()I
    //   10106: getstatic 15	aova:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   10109: invokestatic 3216	azmg:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;ILjava/lang/String;)V
    //   10112: goto +2029 -> 12141
    //   10115: aload_0
    //   10116: aload_2
    //   10117: aload 19
    //   10119: invokevirtual 3219	aova:M	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   10122: goto +2019 -> 12141
    //   10125: aload_2
    //   10126: aload 16
    //   10128: invokevirtual 1829	java/lang/Integer:intValue	()I
    //   10131: aload 19
    //   10133: invokestatic 3224	apbm:a	(Lcom/tencent/mobileqq/app/QQAppInterface;ILcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   10136: goto +2005 -> 12141
    //   10139: aload_2
    //   10140: invokestatic 3229	arsh:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)Larsh;
    //   10143: aload_2
    //   10144: aload 16
    //   10146: aload 19
    //   10148: invokevirtual 3232	arsh:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/Integer;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   10151: goto +1990 -> 12141
    //   10154: aload_0
    //   10155: aload_2
    //   10156: aload 19
    //   10158: invokevirtual 3234	aova:K	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   10161: goto +1980 -> 12141
    //   10164: aload_0
    //   10165: aload_2
    //   10166: aload 19
    //   10168: invokevirtual 3236	aova:L	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   10171: goto +1970 -> 12141
    //   10174: aload_2
    //   10175: sipush 181
    //   10178: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   10181: checkcast 2096	uhl
    //   10184: getfield 2099	uhl:a	Luqc;
    //   10187: aload_2
    //   10188: aload 19
    //   10190: invokevirtual 3237	uqc:a	(Lcom/tencent/common/app/AppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   10193: goto +1948 -> 12141
    //   10196: aload_0
    //   10197: aload_2
    //   10198: aload 19
    //   10200: invokespecial 3239	aova:R	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   10203: goto +1938 -> 12141
    //   10206: aload_2
    //   10207: aload 19
    //   10209: invokestatic 3241	aova:c	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   10212: goto +1929 -> 12141
    //   10215: aload_2
    //   10216: aload 16
    //   10218: invokevirtual 1829	java/lang/Integer:intValue	()I
    //   10221: aload 19
    //   10223: invokestatic 3244	bevd:a	(Lcom/tencent/mobileqq/app/QQAppInterface;ILcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   10226: goto +1915 -> 12141
    //   10229: aload_2
    //   10230: bipush 52
    //   10232: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   10235: checkcast 2030	com/tencent/mobileqq/app/TroopManager
    //   10238: getfield 2115	com/tencent/mobileqq/app/TroopManager:jdField_a_of_type_Yqe	Lyqe;
    //   10241: aload_2
    //   10242: aload 19
    //   10244: invokevirtual 3245	yqe:a	(Lcom/tencent/common/app/AppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   10247: goto +1894 -> 12141
    //   10250: aload_0
    //   10251: aload_2
    //   10252: aload 19
    //   10254: aload 16
    //   10256: invokevirtual 1829	java/lang/Integer:intValue	()I
    //   10259: invokespecial 3246	aova:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;I)V
    //   10262: goto +1879 -> 12141
    //   10265: aload_2
    //   10266: aload 19
    //   10268: invokestatic 3248	aova:N	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   10271: goto +1870 -> 12141
    //   10274: aload_0
    //   10275: aload_2
    //   10276: aload 19
    //   10278: invokespecial 3250	aova:Q	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   10281: goto +1860 -> 12141
    //   10284: aload_2
    //   10285: sipush 306
    //   10288: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   10291: checkcast 3252	asyy
    //   10294: aload 19
    //   10296: invokevirtual 3253	asyy:a	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   10299: goto +1842 -> 12141
    //   10302: aload_0
    //   10303: aload 19
    //   10305: invokespecial 3255	aova:C	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   10308: goto +1833 -> 12141
    //   10311: aload_2
    //   10312: sipush 236
    //   10315: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   10318: checkcast 3257	asvu
    //   10321: aload 19
    //   10323: invokevirtual 3258	asvu:a	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   10326: goto +1815 -> 12141
    //   10329: aload_0
    //   10330: aload_2
    //   10331: aload 19
    //   10333: invokespecial 3260	aova:ar	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   10336: goto +1805 -> 12141
    //   10339: aload_0
    //   10340: aload_2
    //   10341: aload 19
    //   10343: aload 16
    //   10345: invokevirtual 1829	java/lang/Integer:intValue	()I
    //   10348: invokespecial 3262	aova:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;I)V
    //   10351: goto +1790 -> 12141
    //   10354: aload_0
    //   10355: aload_2
    //   10356: aload 19
    //   10358: invokespecial 3264	aova:at	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   10361: goto +1780 -> 12141
    //   10364: aload 4
    //   10366: ifnull +309 -> 10675
    //   10369: iload 10
    //   10371: ifne +32 -> 10403
    //   10374: aload_2
    //   10375: invokevirtual 65	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   10378: ldc_w 2606
    //   10381: invokestatic 2609	bdem:a	(Landroid/content/Context;Ljava/lang/String;)Z
    //   10384: ifne +19 -> 10403
    //   10387: aload_2
    //   10388: sipush 256
    //   10391: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   10394: checkcast 3266	com/tencent/mobileqq/app/upgrade/UpgradeTIMManager
    //   10397: aload_2
    //   10398: aload 4
    //   10400: invokevirtual 3267	com/tencent/mobileqq/app/upgrade/UpgradeTIMManager:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/app/upgrade/UpgradeTIMWrapper;)V
    //   10403: invokestatic 2578	java/lang/System:currentTimeMillis	()J
    //   10406: lstore 14
    //   10408: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   10411: ifeq +44 -> 10455
    //   10414: ldc 183
    //   10416: iconst_2
    //   10417: new 85	java/lang/StringBuilder
    //   10420: dup
    //   10421: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   10424: ldc_w 3269
    //   10427: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10430: lload 14
    //   10432: lload 12
    //   10434: lsub
    //   10435: invokevirtual 3272	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   10438: ldc_w 3274
    //   10441: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10444: iload 10
    //   10446: invokevirtual 152	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   10449: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   10452: invokestatic 373	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   10455: aconst_null
    //   10456: astore 4
    //   10458: aload_3
    //   10459: ifnull +1642 -> 12101
    //   10462: aload_3
    //   10463: ldc_w 2302
    //   10466: iconst_0
    //   10467: invokevirtual 2238	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   10470: istore 10
    //   10472: iload 10
    //   10474: ifeq +220 -> 10694
    //   10477: aload_3
    //   10478: ldc_w 3276
    //   10481: iconst_0
    //   10482: invokevirtual 3279	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   10485: istore 8
    //   10487: ldc 183
    //   10489: iconst_2
    //   10490: iconst_2
    //   10491: anewarray 301	java/lang/Object
    //   10494: dup
    //   10495: iconst_0
    //   10496: ldc_w 3281
    //   10499: aastore
    //   10500: dup
    //   10501: iconst_1
    //   10502: iload 8
    //   10504: invokestatic 305	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   10507: aastore
    //   10508: invokestatic 1662	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   10511: iload 8
    //   10513: istore 6
    //   10515: iload 10
    //   10517: istore 5
    //   10519: aload 4
    //   10521: astore_3
    //   10522: iload 8
    //   10524: iconst_3
    //   10525: if_icmpge +179 -> 10704
    //   10528: aload_1
    //   10529: getfield 3284	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:next_req_types	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   10532: invokevirtual 1147	com/tencent/mobileqq/pb/PBRepeatField:get	()Ljava/util/List;
    //   10535: astore 16
    //   10537: iload 8
    //   10539: istore 6
    //   10541: iload 10
    //   10543: istore 5
    //   10545: aload 4
    //   10547: astore_3
    //   10548: aload 16
    //   10550: ifnull +154 -> 10704
    //   10553: iload 8
    //   10555: istore 6
    //   10557: iload 10
    //   10559: istore 5
    //   10561: aload 4
    //   10563: astore_3
    //   10564: aload 16
    //   10566: invokeinterface 400 1 0
    //   10571: ifle +133 -> 10704
    //   10574: aload 16
    //   10576: invokeinterface 400 1 0
    //   10581: newarray int
    //   10583: astore 4
    //   10585: aload 16
    //   10587: invokeinterface 400 1 0
    //   10592: istore 9
    //   10594: iconst_0
    //   10595: istore 7
    //   10597: iload 8
    //   10599: istore 6
    //   10601: iload 10
    //   10603: istore 5
    //   10605: aload 4
    //   10607: astore_3
    //   10608: iload 7
    //   10610: iload 9
    //   10612: if_icmpge +92 -> 10704
    //   10615: aload 16
    //   10617: iload 7
    //   10619: invokeinterface 447 2 0
    //   10624: checkcast 139	java/lang/Integer
    //   10627: invokevirtual 1829	java/lang/Integer:intValue	()I
    //   10630: istore 6
    //   10632: aload 4
    //   10634: iload 7
    //   10636: iload 6
    //   10638: iastore
    //   10639: aload 18
    //   10641: invokeinterface 400 1 0
    //   10646: ifle +20 -> 10666
    //   10649: aload 18
    //   10651: new 139	java/lang/Integer
    //   10654: dup
    //   10655: iload 6
    //   10657: invokespecial 2581	java/lang/Integer:<init>	(I)V
    //   10660: invokeinterface 2583 2 0
    //   10665: pop
    //   10666: iload 7
    //   10668: iconst_1
    //   10669: iadd
    //   10670: istore 7
    //   10672: goto -75 -> 10597
    //   10675: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   10678: ifeq -275 -> 10403
    //   10681: ldc_w 1787
    //   10684: iconst_2
    //   10685: ldc_w 3286
    //   10688: invokestatic 199	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   10691: goto -288 -> 10403
    //   10694: iconst_0
    //   10695: istore 6
    //   10697: aload 4
    //   10699: astore_3
    //   10700: iload 10
    //   10702: istore 5
    //   10704: aload 18
    //   10706: invokeinterface 233 1 0
    //   10711: astore 4
    //   10713: aload 4
    //   10715: invokeinterface 238 1 0
    //   10720: ifeq +1176 -> 11896
    //   10723: aload 4
    //   10725: invokeinterface 242 1 0
    //   10730: checkcast 139	java/lang/Integer
    //   10733: astore 16
    //   10735: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   10738: ifeq +46 -> 10784
    //   10741: ldc 183
    //   10743: iconst_2
    //   10744: new 85	java/lang/StringBuilder
    //   10747: dup
    //   10748: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   10751: ldc_w 3288
    //   10754: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10757: aload 16
    //   10759: invokevirtual 798	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   10762: ldc_w 2142
    //   10765: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10768: aload 18
    //   10770: invokeinterface 400 1 0
    //   10775: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   10778: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   10781: invokestatic 373	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   10784: aload 16
    //   10786: invokevirtual 1829	java/lang/Integer:intValue	()I
    //   10789: lookupswitch	default:+195->10984, 1:+653->11442, 38:+599->11388, 42:+932->11721, 46:+592->11381, 86:+886->11675, 87:+788->11577, 113:+940->11729, 116:+226->11015, 119:+1002->11791, 156:+-76->10713, 185:+1028->11817, 188:+831->11620, 191:+1056->11845, 202:+1037->11826, 205:+868->11657, 206:+850->11639, 215:+1072->11861, 223:+986->11775, 231:+1078->11867, 297:+1092->11881, 345:+1099->11888, 364:+986->11775, 365:+986->11775
    //   10985: iconst_2
    //   10986: ldc_w 6416
    //   10989: invokevirtual 1829	java/lang/Integer:intValue	()I
    //   10992: invokevirtual 1302	aogj:b	(I)Z
    //   10995: ifeq -282 -> 10713
    //   10998: invokestatic 1299	aogj:a	()Laogj;
    //   11001: aload 16
    //   11003: invokevirtual 1829	java/lang/Integer:intValue	()I
    //   11006: getstatic 15	aova:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   11009: invokevirtual 3289	aogj:a	(ILjava/lang/String;)V
    //   11012: goto -299 -> 10713
    //   11015: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11018: ifeq +12 -> 11030
    //   11021: ldc 183
    //   11023: iconst_2
    //   11024: ldc_w 3291
    //   11027: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   11030: aload_2
    //   11031: iconst_4
    //   11032: invokevirtual 206	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lalko;
    //   11035: checkcast 1781	allq
    //   11038: astore 17
    //   11040: ldc_w 2633
    //   11043: getstatic 15	aova:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   11046: invokestatic 3293	amln:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   11049: astore 19
    //   11051: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11054: ifeq +30 -> 11084
    //   11057: ldc 183
    //   11059: iconst_2
    //   11060: new 85	java/lang/StringBuilder
    //   11063: dup
    //   11064: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   11067: ldc_w 2677
    //   11070: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11073: aload 19
    //   11075: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11078: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   11081: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   11084: aload 19
    //   11086: invokestatic 126	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   11089: ifeq +53 -> 11142
    //   11092: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11095: ifeq +12 -> 11107
    //   11098: ldc 183
    //   11100: iconst_2
    //   11101: ldc_w 3295
    //   11104: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   11107: aload_2
    //   11108: invokevirtual 65	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   11111: getstatic 15	aova:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   11114: iconst_0
    //   11115: invokestatic 2640	bdiv:p	(Landroid/content/Context;Ljava/lang/String;I)V
    //   11118: ldc_w 2633
    //   11121: getstatic 15	aova:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   11124: invokestatic 2638	amln:a	(Ljava/lang/String;Ljava/lang/String;)Z
    //   11127: pop
    //   11128: aload 17
    //   11130: invokestatic 2428	amlp:a	()Lamlp;
    //   11133: invokevirtual 2431	amlp:a	()Lcom/tencent/mobileqq/app/upgrade/UpgradeDetailWrapper;
    //   11136: invokevirtual 2434	allq:a	(Lcom/tencent/mobileqq/app/upgrade/UpgradeDetailWrapper;)V
    //   11139: goto -426 -> 10713
    //   11142: invokestatic 2428	amlp:a	()Lamlp;
    //   11145: invokevirtual 2431	amlp:a	()Lcom/tencent/mobileqq/app/upgrade/UpgradeDetailWrapper;
    //   11148: astore 16
    //   11150: aload 16
    //   11152: aload 19
    //   11154: invokevirtual 2643	com/tencent/mobileqq/app/upgrade/UpgradeDetailWrapper:a	(Ljava/lang/String;)V
    //   11157: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11160: ifeq +42 -> 11202
    //   11163: ldc 183
    //   11165: iconst_2
    //   11166: ldc_w 2645
    //   11169: iconst_2
    //   11170: anewarray 301	java/lang/Object
    //   11173: dup
    //   11174: iconst_0
    //   11175: invokestatic 203	com/tencent/common/config/AppSetting:a	()I
    //   11178: invokestatic 305	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   11181: aastore
    //   11182: dup
    //   11183: iconst_1
    //   11184: aload 16
    //   11186: getfield 2648	com/tencent/mobileqq/app/upgrade/UpgradeDetailWrapper:jdField_b_of_type_ProtocolKQQConfigUpgradeInfo	Lprotocol/KQQConfig/UpgradeInfo;
    //   11189: getfield 2653	protocol/KQQConfig/UpgradeInfo:iUpgradeSdkId	I
    //   11192: invokestatic 305	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   11195: aastore
    //   11196: invokestatic 309	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   11199: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   11202: invokestatic 203	com/tencent/common/config/AppSetting:a	()I
    //   11205: aload 16
    //   11207: getfield 2648	com/tencent/mobileqq/app/upgrade/UpgradeDetailWrapper:jdField_b_of_type_ProtocolKQQConfigUpgradeInfo	Lprotocol/KQQConfig/UpgradeInfo;
    //   11210: getfield 2653	protocol/KQQConfig/UpgradeInfo:iUpgradeSdkId	I
    //   11213: if_icmplt +63 -> 11276
    //   11216: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11219: ifeq +12 -> 11231
    //   11222: ldc 183
    //   11224: iconst_2
    //   11225: ldc_w 3297
    //   11228: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   11231: aload_2
    //   11232: invokevirtual 65	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   11235: getstatic 15	aova:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   11238: iconst_0
    //   11239: invokestatic 2640	bdiv:p	(Landroid/content/Context;Ljava/lang/String;I)V
    //   11242: ldc_w 2633
    //   11245: getstatic 15	aova:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   11248: invokestatic 2638	amln:a	(Ljava/lang/String;Ljava/lang/String;)Z
    //   11251: pop
    //   11252: aload 16
    //   11254: getfield 2648	com/tencent/mobileqq/app/upgrade/UpgradeDetailWrapper:jdField_b_of_type_ProtocolKQQConfigUpgradeInfo	Lprotocol/KQQConfig/UpgradeInfo;
    //   11257: iconst_0
    //   11258: putfield 2674	protocol/KQQConfig/UpgradeInfo:iUpgradeType	I
    //   11261: aload 17
    //   11263: aload 16
    //   11265: invokevirtual 2434	allq:a	(Lcom/tencent/mobileqq/app/upgrade/UpgradeDetailWrapper;)V
    //   11268: aload 17
    //   11270: invokevirtual 2675	allq:c	()V
    //   11273: goto -560 -> 10713
    //   11276: aload 16
    //   11278: monitorenter
    //   11279: aload 16
    //   11281: getfield 2685	com/tencent/mobileqq/app/upgrade/UpgradeDetailWrapper:jdField_a_of_type_Boolean	Z
    //   11284: ifne +30 -> 11314
    //   11287: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11290: ifeq +12 -> 11302
    //   11293: ldc 183
    //   11295: iconst_2
    //   11296: ldc_w 2687
    //   11299: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   11302: aload 16
    //   11304: monitorexit
    //   11305: goto -592 -> 10713
    //   11308: astore_1
    //   11309: aload 16
    //   11311: monitorexit
    //   11312: aload_1
    //   11313: athrow
    //   11314: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11317: ifeq +12 -> 11329
    //   11320: ldc 183
    //   11322: iconst_2
    //   11323: ldc_w 2689
    //   11326: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   11329: aload 16
    //   11331: getfield 2691	com/tencent/mobileqq/app/upgrade/UpgradeDetailWrapper:jdField_b_of_type_Int	I
    //   11334: ifne +21 -> 11355
    //   11337: aload 16
    //   11339: getfield 2692	com/tencent/mobileqq/app/upgrade/UpgradeDetailWrapper:jdField_a_of_type_Int	I
    //   11342: iconst_1
    //   11343: if_icmpne +32 -> 11375
    //   11346: iconst_1
    //   11347: istore 10
    //   11349: aload_2
    //   11350: iload 10
    //   11352: invokestatic 2693	allq:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Z)V
    //   11355: invokestatic 2428	amlp:a	()Lamlp;
    //   11358: aload 16
    //   11360: getfield 2648	com/tencent/mobileqq/app/upgrade/UpgradeDetailWrapper:jdField_b_of_type_ProtocolKQQConfigUpgradeInfo	Lprotocol/KQQConfig/UpgradeInfo;
    //   11363: aload 17
    //   11365: invokevirtual 2696	amlp:a	(Lprotocol/KQQConfig/UpgradeInfo;Lamlr;)Z
    //   11368: pop
    //   11369: aload 16
    //   11371: monitorexit
    //   11372: goto -659 -> 10713
    //   11375: iconst_0
    //   11376: istore 10
    //   11378: goto -29 -> 11349
    //   11381: aload_2
    //   11382: invokestatic 2452	aarj:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   11385: goto -672 -> 10713
    //   11388: aload_2
    //   11389: invokevirtual 411	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   11392: invokestatic 3300	bdiv:b	(Ljava/lang/String;)Landroid/content/SharedPreferences;
    //   11395: astore 16
    //   11397: aload 16
    //   11399: invokeinterface 346 1 0
    //   11404: ldc_w 3302
    //   11407: invokeinterface 382 2 0
    //   11412: invokeinterface 726 1 0
    //   11417: pop
    //   11418: aload 16
    //   11420: invokeinterface 346 1 0
    //   11425: ldc_w 3304
    //   11428: invokeinterface 382 2 0
    //   11433: invokeinterface 726 1 0
    //   11438: pop
    //   11439: goto -726 -> 10713
    //   11442: new 85	java/lang/StringBuilder
    //   11445: dup
    //   11446: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   11449: aload_0
    //   11450: invokevirtual 47	aova:getAppRuntime	()Lmqq/app/AppRuntime;
    //   11453: invokevirtual 2602	mqq/app/AppRuntime:getApplication	()Lmqq/app/MobileQQ;
    //   11456: invokevirtual 2729	mqq/app/MobileQQ:getFilesDir	()Ljava/io/File;
    //   11459: invokevirtual 2732	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   11462: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11465: ldc_w 3306
    //   11468: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11471: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   11474: astore 16
    //   11476: new 2723	java/io/File
    //   11479: dup
    //   11480: aload 16
    //   11482: invokespecial 2735	java/io/File:<init>	(Ljava/lang/String;)V
    //   11485: astore 17
    //   11487: aload 17
    //   11489: ifnull -776 -> 10713
    //   11492: aload 17
    //   11494: invokevirtual 2738	java/io/File:exists	()Z
    //   11497: ifeq -784 -> 10713
    //   11500: aload 17
    //   11502: invokevirtual 2751	java/io/File:isDirectory	()Z
    //   11505: ifeq -792 -> 10713
    //   11508: aload 17
    //   11510: invokevirtual 2755	java/io/File:listFiles	()[Ljava/io/File;
    //   11513: astore 17
    //   11515: aload 17
    //   11517: ifnull -804 -> 10713
    //   11520: aload 17
    //   11522: arraylength
    //   11523: istore 8
    //   11525: iconst_0
    //   11526: istore 7
    //   11528: iload 7
    //   11530: iload 8
    //   11532: if_icmpge -819 -> 10713
    //   11535: aload 17
    //   11537: iload 7
    //   11539: aaload
    //   11540: astore 19
    //   11542: aload 19
    //   11544: ifnonnull +12 -> 11556
    //   11547: iload 7
    //   11549: iconst_1
    //   11550: iadd
    //   11551: istore 7
    //   11553: goto -25 -> 11528
    //   11556: new 3308	com/tencent/mobileqq/config/splashlogo/ConfigServlet$1
    //   11559: dup
    //   11560: aload_0
    //   11561: aload 19
    //   11563: aload 16
    //   11565: invokespecial 3311	com/tencent/mobileqq/config/splashlogo/ConfigServlet$1:<init>	(Laova;Ljava/io/File;Ljava/lang/String;)V
    //   11568: iconst_5
    //   11569: aconst_null
    //   11570: iconst_1
    //   11571: invokestatic 3317	com/tencent/mobileqq/app/ThreadManager:post	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   11574: goto -27 -> 11547
    //   11577: aload_2
    //   11578: sipush 168
    //   11581: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   11584: checkcast 1682	amsx
    //   11587: astore 16
    //   11589: aload 16
    //   11591: ifnull +10 -> 11601
    //   11594: aload 16
    //   11596: iconst_1
    //   11597: iconst_0
    //   11598: invokevirtual 2492	amsx:a	(ZZ)V
    //   11601: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11604: ifeq -891 -> 10713
    //   11607: ldc_w 1709
    //   11610: iconst_2
    //   11611: ldc_w 3319
    //   11614: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   11617: goto -904 -> 10713
    //   11620: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11623: ifeq -910 -> 10713
    //   11626: ldc_w 3321
    //   11629: iconst_2
    //   11630: ldc_w 3323
    //   11633: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   11636: goto -923 -> 10713
    //   11639: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11642: ifeq -929 -> 10713
    //   11645: ldc 183
    //   11647: iconst_2
    //   11648: ldc_w 3325
    //   11651: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   11654: goto -941 -> 10713
    //   11657: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11660: ifeq -947 -> 10713
    //   11663: ldc 183
    //   11665: iconst_2
    //   11666: ldc_w 3327
    //   11669: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   11672: goto -959 -> 10713
    //   11675: aload_2
    //   11676: sipush 167
    //   11679: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   11682: checkcast 1645	com/tencent/mobileqq/olympic/OlympicManager
    //   11685: astore 16
    //   11687: aload 16
    //   11689: ifnull +13 -> 11702
    //   11692: aload 16
    //   11694: invokevirtual 2500	com/tencent/mobileqq/olympic/OlympicManager:f	()V
    //   11697: aload 16
    //   11699: invokevirtual 2502	com/tencent/mobileqq/olympic/OlympicManager:g	()V
    //   11702: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11705: ifeq -992 -> 10713
    //   11708: ldc_w 1669
    //   11711: iconst_2
    //   11712: ldc_w 3329
    //   11715: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   11718: goto -1005 -> 10713
    //   11721: aload_0
    //   11722: aconst_null
    //   11723: invokespecial 2958	aova:p	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   11726: goto -1013 -> 10713
    //   11729: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11732: ifeq +12 -> 11744
    //   11735: ldc 183
    //   11737: iconst_2
    //   11738: ldc_w 2509
    //   11741: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   11744: aload_2
    //   11745: sipush 179
    //   11748: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   11751: checkcast 2511	awjh
    //   11754: astore 16
    //   11756: aload 16
    //   11758: ifnull -1045 -> 10713
    //   11761: aload 16
    //   11763: invokevirtual 2512	awjh:a	()V
    //   11766: aload 16
    //   11768: iconst_1
    //   11769: invokevirtual 2513	awjh:a	(Z)V
    //   11772: goto -1059 -> 10713
    //   11775: aload_2
    //   11776: invokestatic 1517	com/tencent/mobileqq/utils/BusinessCommonConfig:getInstance	(Lmqq/app/AppRuntime;)Lcom/tencent/mobileqq/utils/BusinessCommonConfig;
    //   11779: aload_2
    //   11780: aload 16
    //   11782: invokevirtual 1829	java/lang/Integer:intValue	()I
    //   11785: invokevirtual 3332	com/tencent/mobileqq/utils/BusinessCommonConfig:handleResp_Config_NoResp	(Lcom/tencent/mobileqq/app/QQAppInterface;I)V
    //   11788: goto -1075 -> 10713
    //   11791: aload_2
    //   11792: bipush 53
    //   11794: invokevirtual 206	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lalko;
    //   11797: checkcast 1793	aljv
    //   11800: astore 16
    //   11802: aload 16
    //   11804: ifnull -1091 -> 10713
    //   11807: aload 16
    //   11809: iconst_0
    //   11810: iconst_0
    //   11811: invokevirtual 2507	aljv:a	(ZZ)V
    //   11814: goto -1101 -> 10713
    //   11817: invokestatic 2557	com/tencent/mobileqq/scribble/ScribbleResMgr:a	()Lcom/tencent/mobileqq/scribble/ScribbleResMgr;
    //   11820: invokevirtual 3333	com/tencent/mobileqq/scribble/ScribbleResMgr:a	()V
    //   11823: goto -1110 -> 10713
    //   11826: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11829: ifeq -1116 -> 10713
    //   11832: ldc_w 2343
    //   11835: iconst_2
    //   11836: ldc_w 3335
    //   11839: invokestatic 199	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   11842: goto -1129 -> 10713
    //   11845: aload_2
    //   11846: sipush 218
    //   11849: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   11852: checkcast 3337	aeky
    //   11855: invokevirtual 3338	aeky:a	()V
    //   11858: goto -1145 -> 10713
    //   11861: invokestatic 3339	com/tencent/mobileqq/shortvideo/ShortVideoResourceManager:b	()V
    //   11864: goto -1151 -> 10713
    //   11867: aload_2
    //   11868: sipush 231
    //   11871: getstatic 15	aova:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   11874: aconst_null
    //   11875: invokestatic 3155	ajql:a	(Lcom/tencent/mobileqq/app/QQAppInterface;ILjava/lang/String;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   11878: goto -1165 -> 10713
    //   11881: iconst_1
    //   11882: invokestatic 3340	apbm:a	(Z)V
    //   11885: goto -1172 -> 10713
    //   11888: aload_2
    //   11889: iconst_1
    //   11890: invokestatic 3341	bevd:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Z)V
    //   11893: goto -1180 -> 10713
    //   11896: iload 5
    //   11898: ifeq +341 -> 12239
    //   11901: iload 6
    //   11903: iconst_3
    //   11904: if_icmpge +335 -> 12239
    //   11907: aload_3
    //   11908: ifnull +331 -> 12239
    //   11911: aload_3
    //   11912: arraylength
    //   11913: ifle +326 -> 12239
    //   11916: new 85	java/lang/StringBuilder
    //   11919: dup
    //   11920: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   11923: astore 4
    //   11925: aload 4
    //   11927: ldc_w 3343
    //   11930: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11933: pop
    //   11934: aload_3
    //   11935: arraylength
    //   11936: istore 8
    //   11938: iconst_0
    //   11939: istore 7
    //   11941: iload 7
    //   11943: iload 8
    //   11945: if_icmpge +28 -> 11973
    //   11948: aload 4
    //   11950: aload_3
    //   11951: iload 7
    //   11953: iaload
    //   11954: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   11957: ldc_w 3345
    //   11960: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11963: pop
    //   11964: iload 7
    //   11966: iconst_1
    //   11967: iadd
    //   11968: istore 7
    //   11970: goto -29 -> 11941
    //   11973: ldc 183
    //   11975: iconst_1
    //   11976: aload 4
    //   11978: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   11981: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   11984: new 1252	mqq/app/NewIntent
    //   11987: dup
    //   11988: aload_2
    //   11989: invokevirtual 65	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   11992: ldc 2
    //   11994: invokespecial 1255	mqq/app/NewIntent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   11997: astore 4
    //   11999: aload 4
    //   12001: ldc_w 1257
    //   12004: aload_3
    //   12005: invokevirtual 1261	mqq/app/NewIntent:putExtra	(Ljava/lang/String;[I)Landroid/content/Intent;
    //   12008: pop
    //   12009: aload 4
    //   12011: ldc_w 1267
    //   12014: getstatic 15	aova:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   12017: invokevirtual 1270	mqq/app/NewIntent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   12020: pop
    //   12021: aload 4
    //   12023: ldc_w 2234
    //   12026: iconst_1
    //   12027: invokevirtual 2305	mqq/app/NewIntent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   12030: pop
    //   12031: aload_1
    //   12032: getfield 3346	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:cookies	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   12035: invokevirtual 1130	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   12038: ifeq +22 -> 12060
    //   12041: aload 4
    //   12043: ldc_w 2243
    //   12046: aload_1
    //   12047: getfield 3346	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:cookies	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   12050: invokevirtual 260	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   12053: invokevirtual 266	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   12056: invokevirtual 3349	mqq/app/NewIntent:putExtra	(Ljava/lang/String;[B)Landroid/content/Intent;
    //   12059: pop
    //   12060: aload 4
    //   12062: ldc_w 2302
    //   12065: iload 5
    //   12067: invokevirtual 2305	mqq/app/NewIntent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   12070: pop
    //   12071: aload 4
    //   12073: ldc_w 3276
    //   12076: iload 6
    //   12078: iconst_1
    //   12079: iadd
    //   12080: invokevirtual 2300	mqq/app/NewIntent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   12083: pop
    //   12084: aload 4
    //   12086: ldc_w 2299
    //   12089: iconst_0
    //   12090: invokevirtual 2300	mqq/app/NewIntent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   12093: pop
    //   12094: aload_2
    //   12095: aload 4
    //   12097: invokevirtual 1280	com/tencent/mobileqq/app/QQAppInterface:startServlet	(Lmqq/app/NewIntent;)V
    //   12100: return
    //   12101: iconst_0
    //   12102: istore 5
    //   12104: iconst_0
    //   12105: istore 6
    //   12107: aload 4
    //   12109: astore_3
    //   12110: goto -1406 -> 10704
    //   12113: aconst_null
    //   12114: astore 16
    //   12116: goto -2358 -> 9758
    //   12119: aconst_null
    //   12120: astore 16
    //   12122: goto -4903 -> 7219
    //   12125: aload 4
    //   12127: astore 16
    //   12129: goto -8175 -> 3954
    //   12132: aconst_null
    //   12133: astore 16
    //   12135: goto -8311 -> 3824
    //   12138: goto -8474 -> 3664
    //   12141: aload 4
    //   12143: astore 16
    //   12145: iload 10
    //   12147: istore 11
    //   12149: goto -9974 -> 2175
    //   12152: aconst_null
    //   12153: astore 16
    //   12155: goto -8331 -> 3824
    //   12158: astore 17
    //   12160: goto -8097 -> 4063
    //   12163: iconst_0
    //   12164: istore 10
    //   12166: goto -7453 -> 4713
    //   12169: iload 7
    //   12171: iconst_1
    //   12172: iadd
    //   12173: istore 7
    //   12175: goto -7350 -> 4825
    //   12178: goto -37 -> 12141
    //   12181: iload 7
    //   12183: iconst_1
    //   12184: iadd
    //   12185: istore 7
    //   12187: goto -7174 -> 5013
    //   12190: goto -49 -> 12141
    //   12193: iload 7
    //   12195: iconst_1
    //   12196: iadd
    //   12197: istore 7
    //   12199: goto -6749 -> 5450
    //   12202: goto -61 -> 12141
    //   12205: goto -64 -> 12141
    //   12208: iload 7
    //   12210: iconst_1
    //   12211: iadd
    //   12212: istore 7
    //   12214: goto -5846 -> 6368
    //   12217: iload 8
    //   12219: istore 7
    //   12221: goto -5307 -> 6914
    //   12224: goto -83 -> 12141
    //   12227: goto -86 -> 12141
    //   12230: goto -89 -> 12141
    //   12233: goto -92 -> 12141
    //   12236: goto -95 -> 12141
    //   12239: return
    //   12240: goto -99 -> 12141
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	12243	0	this	aova
    //   0	12243	1	paramRespGetConfig	ConfigurationService.RespGetConfig
    //   0	12243	2	paramQQAppInterface	QQAppInterface
    //   0	12243	3	paramIntent	Intent
    //   0	12243	4	paramArrayOfInt	int[]
    //   0	12243	5	paramBoolean	boolean
    //   377	11729	6	i	int
    //   53	12167	7	j	int
    //   373	11845	8	k	int
    //   68	10545	9	m	int
    //   2136	10029	10	bool1	boolean
    //   2169	9979	11	bool2	boolean
    //   2073	8360	12	l1	long
    //   10406	25	14	l2	long
    //   2173	1782	16	localObject1	Object
    //   3961	9	16	localUnsupportedEncodingException1	UnsupportedEncodingException
    //   3977	9	16	localOutOfMemoryError1	OutOfMemoryError
    //   4005	1	16	str1	String
    //   4010	1	16	localThrowable1	Throwable
    //   4013	610	16	localObject2	Object
    //   4747	6	16	localObject3	Object
    //   4851	3158	16	localObject4	Object
    //   8087	39	16	localException1	Exception
    //   8207	13	16	localIterator1	Iterator
    //   8298	617	16	localException2	Exception
    //   9363	405	16	localObject5	Object
    //   9796	1	16	localUnsupportedEncodingException2	UnsupportedEncodingException
    //   9799	1	16	localObject6	Object
    //   9804	1	16	localOutOfMemoryError2	OutOfMemoryError
    //   9821	1	16	str2	String
    //   9826	1	16	localThrowable2	Throwable
    //   9829	17	16	str3	String
    //   9850	12	16	localException3	Exception
    //   10038	306	16	localThrowable3	Throwable
    //   10535	1619	16	localObject7	Object
    //   3684	314	17	localObject8	Object
    //   4061	33	17	localException4	Exception
    //   4209	541	17	localUpgradeDetailWrapper	com.tencent.mobileqq.app.upgrade.UpgradeDetailWrapper
    //   4755	1	17	localException5	Exception
    //   5314	6222	17	localObject9	Object
    //   12158	1	17	localException6	Exception
    //   2094	8675	18	localArrayList	ArrayList
    //   2160	9402	19	localObject10	Object
    //   6578	223	20	localObject11	Object
    //   6624	13	21	localIterator2	Iterator
    //   6646	55	22	str4	String
    // Exception table:
    //   from	to	target	type
    //   3810	3824	3961	java/io/UnsupportedEncodingException
    //   3810	3824	3977	java/lang/OutOfMemoryError
    //   3993	4007	4010	java/lang/Throwable
    //   3895	3939	4061	java/lang/Exception
    //   3939	3950	4061	java/lang/Exception
    //   4038	4054	4061	java/lang/Exception
    //   4646	4669	4747	finally
    //   4669	4672	4747	finally
    //   4678	4693	4747	finally
    //   4693	4710	4747	finally
    //   4713	4719	4747	finally
    //   4719	4741	4747	finally
    //   4749	4752	4747	finally
    //   4627	4646	4755	java/lang/Exception
    //   4752	4755	4755	java/lang/Exception
    //   7964	7998	8087	java/lang/Exception
    //   7998	8070	8087	java/lang/Exception
    //   8070	8084	8087	java/lang/Exception
    //   8133	8172	8087	java/lang/Exception
    //   8175	8209	8298	java/lang/Exception
    //   8209	8281	8298	java/lang/Exception
    //   8281	8295	8298	java/lang/Exception
    //   8344	8383	8298	java/lang/Exception
    //   9744	9758	9796	java/io/UnsupportedEncodingException
    //   9744	9758	9804	java/lang/OutOfMemoryError
    //   9809	9823	9826	java/lang/Throwable
    //   9763	9793	9850	java/lang/Exception
    //   10024	10035	10038	java/lang/Throwable
    //   11279	11302	11308	finally
    //   11302	11305	11308	finally
    //   11309	11312	11308	finally
    //   11314	11329	11308	finally
    //   11329	11346	11308	finally
    //   11349	11355	11308	finally
    //   11355	11372	11308	finally
    //   2282	3664	12158	java/lang/Exception
    //   3667	3713	12158	java/lang/Exception
    //   3721	3736	12158	java/lang/Exception
    //   3739	3772	12158	java/lang/Exception
    //   3777	3805	12158	java/lang/Exception
    //   3810	3824	12158	java/lang/Exception
    //   3829	3884	12158	java/lang/Exception
    //   3884	3891	12158	java/lang/Exception
    //   3963	3974	12158	java/lang/Exception
    //   3979	3990	12158	java/lang/Exception
    //   3990	3993	12158	java/lang/Exception
    //   3993	4007	12158	java/lang/Exception
    //   4018	4031	12158	java/lang/Exception
    //   4122	4138	12158	java/lang/Exception
    //   4145	4208	12158	java/lang/Exception
    //   4218	4237	12158	java/lang/Exception
    //   4237	4252	12158	java/lang/Exception
    //   4252	4262	12158	java/lang/Exception
    //   4265	4280	12158	java/lang/Exception
    //   4280	4358	12158	java/lang/Exception
    //   4358	4445	12158	java/lang/Exception
    //   4445	4474	12158	java/lang/Exception
    //   4474	4516	12158	java/lang/Exception
    //   4519	4566	12158	java/lang/Exception
    //   4566	4584	12158	java/lang/Exception
    //   4587	4598	12158	java/lang/Exception
    //   4605	4620	12158	java/lang/Exception
    //   4763	4779	12158	java/lang/Exception
    //   4782	4822	12158	java/lang/Exception
    //   4825	4903	12158	java/lang/Exception
    //   4903	4925	12158	java/lang/Exception
    //   4928	4967	12158	java/lang/Exception
    //   4970	5010	12158	java/lang/Exception
    //   5013	5091	12158	java/lang/Exception
    //   5091	5114	12158	java/lang/Exception
    //   5117	5156	12158	java/lang/Exception
    //   5159	5202	12158	java/lang/Exception
    //   5205	5279	12158	java/lang/Exception
    //   5279	5294	12158	java/lang/Exception
    //   5294	5366	12158	java/lang/Exception
    //   5366	5419	12158	java/lang/Exception
    //   5427	5447	12158	java/lang/Exception
    //   5469	5483	12158	java/lang/Exception
    //   5486	5525	12158	java/lang/Exception
    //   5525	5572	12158	java/lang/Exception
    //   5577	5583	12158	java/lang/Exception
    //   5583	5606	12158	java/lang/Exception
    //   5609	5649	12158	java/lang/Exception
    //   5649	5721	12158	java/lang/Exception
    //   5721	5735	12158	java/lang/Exception
    //   5738	5757	12158	java/lang/Exception
    //   5762	5772	12158	java/lang/Exception
    //   5772	5934	12158	java/lang/Exception
    //   5937	5976	12158	java/lang/Exception
    //   5976	6007	12158	java/lang/Exception
    //   6012	6022	12158	java/lang/Exception
    //   6022	6096	12158	java/lang/Exception
    //   6099	6182	12158	java/lang/Exception
    //   6182	6196	12158	java/lang/Exception
    //   6199	6238	12158	java/lang/Exception
    //   6238	6311	12158	java/lang/Exception
    //   6311	6334	12158	java/lang/Exception
    //   6337	6365	12158	java/lang/Exception
    //   6368	6446	12158	java/lang/Exception
    //   6446	6454	12158	java/lang/Exception
    //   6459	6467	12158	java/lang/Exception
    //   6470	6517	12158	java/lang/Exception
    //   6520	6559	12158	java/lang/Exception
    //   6562	6626	12158	java/lang/Exception
    //   6626	6698	12158	java/lang/Exception
    //   6698	6723	12158	java/lang/Exception
    //   6726	6765	12158	java/lang/Exception
    //   6765	6794	12158	java/lang/Exception
    //   6797	6844	12158	java/lang/Exception
    //   6844	6857	12158	java/lang/Exception
    //   6860	6875	12158	java/lang/Exception
    //   6878	6891	12158	java/lang/Exception
    //   6896	6914	12158	java/lang/Exception
    //   6914	7015	12158	java/lang/Exception
    //   7015	7024	12158	java/lang/Exception
    //   7027	7058	12158	java/lang/Exception
    //   7067	7101	12158	java/lang/Exception
    //   7104	7148	12158	java/lang/Exception
    //   7155	7187	12158	java/lang/Exception
    //   7190	7219	12158	java/lang/Exception
    //   7224	7297	12158	java/lang/Exception
    //   7297	7311	12158	java/lang/Exception
    //   7311	7383	12158	java/lang/Exception
    //   7383	7391	12158	java/lang/Exception
    //   7391	7413	12158	java/lang/Exception
    //   7416	7462	12158	java/lang/Exception
    //   7465	7480	12158	java/lang/Exception
    //   7483	7490	12158	java/lang/Exception
    //   7493	7500	12158	java/lang/Exception
    //   7503	7510	12158	java/lang/Exception
    //   7513	7519	12158	java/lang/Exception
    //   7522	7528	12158	java/lang/Exception
    //   7531	7636	12158	java/lang/Exception
    //   7639	7678	12158	java/lang/Exception
    //   7681	7793	12158	java/lang/Exception
    //   7796	7852	12158	java/lang/Exception
    //   7855	7862	12158	java/lang/Exception
    //   7865	7872	12158	java/lang/Exception
    //   7875	7882	12158	java/lang/Exception
    //   7885	7892	12158	java/lang/Exception
    //   7895	7903	12158	java/lang/Exception
    //   7906	7913	12158	java/lang/Exception
    //   7916	7922	12158	java/lang/Exception
    //   7925	7931	12158	java/lang/Exception
    //   7934	7941	12158	java/lang/Exception
    //   7944	7961	12158	java/lang/Exception
    //   8089	8125	12158	java/lang/Exception
    //   8125	8130	12158	java/lang/Exception
    //   8300	8336	12158	java/lang/Exception
    //   8336	8341	12158	java/lang/Exception
    //   8386	8392	12158	java/lang/Exception
    //   8395	8401	12158	java/lang/Exception
    //   8404	8410	12158	java/lang/Exception
    //   8413	8419	12158	java/lang/Exception
    //   8422	8428	12158	java/lang/Exception
    //   8431	8437	12158	java/lang/Exception
    //   8440	8446	12158	java/lang/Exception
    //   8449	8455	12158	java/lang/Exception
    //   8458	8464	12158	java/lang/Exception
    //   8467	8473	12158	java/lang/Exception
    //   8476	8482	12158	java/lang/Exception
    //   8485	8491	12158	java/lang/Exception
    //   8494	8500	12158	java/lang/Exception
    //   8503	8509	12158	java/lang/Exception
    //   8512	8518	12158	java/lang/Exception
    //   8521	8527	12158	java/lang/Exception
    //   8530	8536	12158	java/lang/Exception
    //   8539	8545	12158	java/lang/Exception
    //   8548	8554	12158	java/lang/Exception
    //   8557	8563	12158	java/lang/Exception
    //   8566	8576	12158	java/lang/Exception
    //   8579	8585	12158	java/lang/Exception
    //   8588	8594	12158	java/lang/Exception
    //   8597	8603	12158	java/lang/Exception
    //   8606	8612	12158	java/lang/Exception
    //   8615	8705	12158	java/lang/Exception
    //   8705	8758	12158	java/lang/Exception
    //   8761	8811	12158	java/lang/Exception
    //   8814	8821	12158	java/lang/Exception
    //   8824	8840	12158	java/lang/Exception
    //   8843	8850	12158	java/lang/Exception
    //   8853	8860	12158	java/lang/Exception
    //   8863	8870	12158	java/lang/Exception
    //   8873	8880	12158	java/lang/Exception
    //   8883	8891	12158	java/lang/Exception
    //   8894	8901	12158	java/lang/Exception
    //   8904	8911	12158	java/lang/Exception
    //   8914	8928	12158	java/lang/Exception
    //   8931	8938	12158	java/lang/Exception
    //   8941	8957	12158	java/lang/Exception
    //   8960	8967	12158	java/lang/Exception
    //   8970	8977	12158	java/lang/Exception
    //   8980	8987	12158	java/lang/Exception
    //   8990	8997	12158	java/lang/Exception
    //   9000	9007	12158	java/lang/Exception
    //   9010	9017	12158	java/lang/Exception
    //   9020	9027	12158	java/lang/Exception
    //   9030	9037	12158	java/lang/Exception
    //   9040	9047	12158	java/lang/Exception
    //   9050	9057	12158	java/lang/Exception
    //   9060	9065	12158	java/lang/Exception
    //   9068	9075	12158	java/lang/Exception
    //   9078	9085	12158	java/lang/Exception
    //   9088	9095	12158	java/lang/Exception
    //   9098	9105	12158	java/lang/Exception
    //   9108	9115	12158	java/lang/Exception
    //   9118	9125	12158	java/lang/Exception
    //   9128	9135	12158	java/lang/Exception
    //   9138	9145	12158	java/lang/Exception
    //   9148	9155	12158	java/lang/Exception
    //   9158	9177	12158	java/lang/Exception
    //   9180	9187	12158	java/lang/Exception
    //   9190	9197	12158	java/lang/Exception
    //   9200	9207	12158	java/lang/Exception
    //   9210	9217	12158	java/lang/Exception
    //   9220	9227	12158	java/lang/Exception
    //   9230	9237	12158	java/lang/Exception
    //   9240	9246	12158	java/lang/Exception
    //   9249	9256	12158	java/lang/Exception
    //   9259	9266	12158	java/lang/Exception
    //   9269	9276	12158	java/lang/Exception
    //   9279	9286	12158	java/lang/Exception
    //   9289	9296	12158	java/lang/Exception
    //   9299	9306	12158	java/lang/Exception
    //   9309	9316	12158	java/lang/Exception
    //   9319	9326	12158	java/lang/Exception
    //   9329	9336	12158	java/lang/Exception
    //   9339	9345	12158	java/lang/Exception
    //   9348	9365	12158	java/lang/Exception
    //   9370	9387	12158	java/lang/Exception
    //   9390	9407	12158	java/lang/Exception
    //   9412	9432	12158	java/lang/Exception
    //   9435	9442	12158	java/lang/Exception
    //   9445	9452	12158	java/lang/Exception
    //   9455	9462	12158	java/lang/Exception
    //   9465	9471	12158	java/lang/Exception
    //   9474	9480	12158	java/lang/Exception
    //   9483	9490	12158	java/lang/Exception
    //   9493	9499	12158	java/lang/Exception
    //   9502	9519	12158	java/lang/Exception
    //   9522	9534	12158	java/lang/Exception
    //   9539	9547	12158	java/lang/Exception
    //   9550	9557	12158	java/lang/Exception
    //   9560	9567	12158	java/lang/Exception
    //   9570	9582	12158	java/lang/Exception
    //   9585	9592	12158	java/lang/Exception
    //   9595	9602	12158	java/lang/Exception
    //   9605	9612	12158	java/lang/Exception
    //   9615	9622	12158	java/lang/Exception
    //   9625	9632	12158	java/lang/Exception
    //   9640	9648	12158	java/lang/Exception
    //   9649	9667	12158	java/lang/Exception
    //   9674	9682	12158	java/lang/Exception
    //   9686	9739	12158	java/lang/Exception
    //   9744	9758	12158	java/lang/Exception
    //   9806	9809	12158	java/lang/Exception
    //   9809	9823	12158	java/lang/Exception
    //   9834	9847	12158	java/lang/Exception
    //   9852	9870	12158	java/lang/Exception
    //   9873	9880	12158	java/lang/Exception
    //   9883	9890	12158	java/lang/Exception
    //   9893	9900	12158	java/lang/Exception
    //   9903	9910	12158	java/lang/Exception
    //   9913	9920	12158	java/lang/Exception
    //   9923	9930	12158	java/lang/Exception
    //   9933	9940	12158	java/lang/Exception
    //   9943	9949	12158	java/lang/Exception
    //   9952	9970	12158	java/lang/Exception
    //   9973	9991	12158	java/lang/Exception
    //   9994	10003	12158	java/lang/Exception
    //   10006	10021	12158	java/lang/Exception
    //   10024	10035	12158	java/lang/Exception
    //   10040	10045	12158	java/lang/Exception
    //   10048	10055	12158	java/lang/Exception
    //   10058	10065	12158	java/lang/Exception
    //   10068	10075	12158	java/lang/Exception
    //   10078	10085	12158	java/lang/Exception
    //   10088	10095	12158	java/lang/Exception
    //   10098	10112	12158	java/lang/Exception
    //   10115	10122	12158	java/lang/Exception
    //   10125	10136	12158	java/lang/Exception
    //   10139	10151	12158	java/lang/Exception
    //   10154	10161	12158	java/lang/Exception
    //   10164	10171	12158	java/lang/Exception
    //   10174	10193	12158	java/lang/Exception
    //   10196	10203	12158	java/lang/Exception
    //   10206	10212	12158	java/lang/Exception
    //   10215	10226	12158	java/lang/Exception
    //   10229	10247	12158	java/lang/Exception
    //   10250	10262	12158	java/lang/Exception
    //   10265	10271	12158	java/lang/Exception
    //   10274	10281	12158	java/lang/Exception
    //   10284	10299	12158	java/lang/Exception
    //   10302	10308	12158	java/lang/Exception
    //   10311	10326	12158	java/lang/Exception
    //   10329	10336	12158	java/lang/Exception
    //   10339	10351	12158	java/lang/Exception
    //   10354	10361	12158	java/lang/Exception
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
        localObject = bdiv.b(((QQAppInterface)getAppRuntime()).getCurrentAccountUin());
        ((SharedPreferences)localObject).edit().putString("qav_upgrade_invite_video", paramString).commit();
        ((SharedPreferences)localObject).edit().putString("qav_upgrade_invite_multi", str).commit();
        bdiv.i(getAppRuntime().getApplication(), paramInt, jdField_a_of_type_JavaLangString);
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
  
  public static boolean a(aovm paramaovm, String paramString, Set<String> paramSet)
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
      catch (Exception paramaovm)
      {
        bool1 = bool2;
        if (QLog.isColorLevel())
        {
          QLog.i("SPLASH_ConfigServlet", 2, "parseXML | NearbyBanner parse exception,", paramaovm);
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
        paramaovm.a(paramaovm.a(l1, str3, (byte)3, str2, ((StringBuffer)localObject).toString(), BaseApplication.getContext().getFilesDir().getAbsolutePath() + "/" + "NearbyBannerPic" + "/" + str1, l3 + "|" + l2, (short)k, str1));
        aush.a(jdField_a_of_type_JavaLangString, "has_new_banner", Boolean.valueOf(true));
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
    bdlr.a(arrayOfByte, 0, 4L + l);
    bdlr.a(arrayOfByte, 4, paramReqGetConfig, (int)l);
    return arrayOfByte;
  }
  
  public static byte[] a(byte[] paramArrayOfByte)
  {
    int i = paramArrayOfByte.length - 4;
    byte[] arrayOfByte = new byte[i];
    bdlr.a(arrayOfByte, 0, paramArrayOfByte, 4, i);
    return arrayOfByte;
  }
  
  private void aa(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    for (;;)
    {
      try
      {
        j = paramConfig.version.get();
        k = bdiv.a(paramQQAppInterface.getApp(), "change_machine_version", jdField_a_of_type_JavaLangString);
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
        bcgs localbcgs;
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
        localbcgs.a("");
        if (!QLog.isColorLevel()) {
          break label261;
        }
        QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 195,content_list is empty ,version: " + paramConfig.version.get());
        return;
        if (j != k) {
          continue;
        }
      }
      localbcgs = (bcgs)paramQQAppInterface.getManager(224);
      if (i > 0)
      {
        paramConfig = b(paramConfig, k, 195);
        localbcgs.a(paramConfig);
        if (!TextUtils.isEmpty(paramConfig))
        {
          bdiv.a(paramQQAppInterface.getApp(), "change_machine_version", jdField_a_of_type_JavaLangString, j);
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
        k = bdiv.a(paramQQAppInterface.getApp(), "nearby_auth_video_config_version", jdField_a_of_type_JavaLangString);
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
          auss.a(paramConfig);
          bdiv.a(paramQQAppInterface.getApp(), "nearby_auth_video_config_version", jdField_a_of_type_JavaLangString, j);
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
        k = bdiv.a(paramQQAppInterface.getApp(), "nearby_videochat_dialog_config_version", jdField_a_of_type_JavaLangString);
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
          ((bcgs)paramQQAppInterface.getManager(224)).c(paramConfig);
          bdiv.a(paramQQAppInterface.getApp(), "nearby_videochat_dialog_config_version", jdField_a_of_type_JavaLangString, j);
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
        k = bdiv.a(paramQQAppInterface.getApp(), "nearby_videochat_banner_config_version", jdField_a_of_type_JavaLangString);
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
          ((bcgs)paramQQAppInterface.getManager(224)).b(paramConfig);
          bdiv.a(paramQQAppInterface.getApp(), "nearby_videochat_banner_config_version", jdField_a_of_type_JavaLangString, j);
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
    int i = bdiv.aQ(((QQAppInterface)getAppRuntime()).getApp(), paramQQAppInterface);
    if (!blnu.a()) {
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
        bdiv.ag(((QQAppInterface)getAppRuntime()).getApp(), paramQQAppInterface, k);
        new blup().a(paramConfig, blnu.a.getAbsolutePath(), "temp_template_zip", new aovc(this));
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.d("QQSTORY_QUESTION_TAB_SPLASH_ConfigServlet", 2, "GetQQStoryQuestionTabConfig|type: 问答Tab配置回包内容为空");
    return;
    label229:
    if (QLog.isColorLevel()) {
      QLog.d("QQSTORY_QUESTION_TAB_SPLASH_ConfigServlet", 2, "GetQQStoryQuestionTabConfig|type: 问答Tab配置回包为空");
    }
    blnu.e();
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
      localaljv = (aljv)paramQQAppInterface.a(53);
      j = localaljv.a(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount());
      if ((paramConfig.content_list != null) && (paramConfig.content_list.size() > 0))
      {
        paramQQAppInterface = (String)paramConfig.content_list.get(0);
        if (QLog.isColorLevel()) {
          QLog.d("babyqConfig", 2, "received BabyQPlusPanelConfig configVersion:" + i + " ,localVersion:" + j + " ,configContent" + paramQQAppInterface);
        }
        if (i != j)
        {
          localaljv.a(i, paramQQAppInterface);
          return;
        }
        localaljv.a(false, false);
        return;
      }
    }
    catch (Exception paramQQAppInterface)
    {
      int i;
      aljv localaljv;
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
          localaljv.a(false, false);
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
    if (j == bdiv.R(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin())) {
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
          bdiv.c(paramQQAppInterface.getApp(), j, paramQQAppInterface.getCurrentAccountUin(), localConfig);
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
    if (j == bdiv.S(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin())) {
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
      paramConfig = avxz.a(paramConfig.content.get().toByteArray());
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
              bdiv.d(paramQQAppInterface.getApp(), j, paramQQAppInterface.getCurrentAccountUin(), localConfig);
              paramQQAppInterface = (ammg)paramQQAppInterface.getManager(199);
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
      j = bdiv.D(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount());
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
    bdiv.a(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount(), i, true, bool);
    return;
    if (i != j)
    {
      bdiv.a(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount(), i, false, true);
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
    aydn.jdField_a_of_type_JavaLangString = paramQQAppInterface.getCurrentAccountUin();
    int i = paramConfig.version.get();
    int j = aydn.a(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin());
    if (QLog.isColorLevel()) {
      QLog.d("Q.uniteSearch.SearchNetEntryConfig", 2, "handleSearchNetEntryConfig, version: " + i + " localVersion: " + j);
    }
    if (i == j) {
      return;
    }
    aydn.a(paramQQAppInterface.getApp(), i, paramQQAppInterface.getCurrentAccountUin());
    aydn.a(paramQQAppInterface.getApp(), paramConfig, paramQQAppInterface.c());
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
              bdiv.u(paramQQAppInterface.getApp(), j, paramQQAppInterface.getCurrentAccountUin());
              bdiv.w(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin(), i);
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
    int i1 = bdiv.a(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, 2);
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
          bdiv.d(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, 3, k);
          if (paramQQAppInterface.a(250)) {
            ((MedalWallMng)paramQQAppInterface.getManager(250)).a(k);
          }
        }
        bdiv.d(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, 2, n);
        localObject1 = paramConfig;
        if (QLog.isColorLevel()) {
          QLog.i("SPLASH_ConfigServlet", 2, String.format(Locale.getDefault(), "handleMedalStrongReminderConfig localVersion: %s, version: %s, result: %s, value: %s, strContent: %s", new Object[] { Integer.valueOf(i1), Integer.valueOf(n), Integer.valueOf(j), Integer.valueOf(k), localObject1 }));
        }
        return;
        if (paramConfig.compress.get() != 1) {
          continue;
        }
        paramConfig = avxz.a(paramConfig.content.get().toByteArray());
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
        int m = ((Integer)bdiv.a(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, 2)).intValue();
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
              bdiv.a(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, 3, localObject1);
              if (paramQQAppInterface.a(159)) {
                ((alro)paramQQAppInterface.getManager(159)).a((String)localObject1);
              }
            }
            bdiv.a(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, 2, Integer.valueOf(k));
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
          paramConfig = avxz.a(paramConfig.content.get().toByteArray());
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
          localObject3 = avxz.a(((ConfigurationService.Content)localObject4).content.get().toByteArray());
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
        ajog.a();
        ajog.a((String)localObject1);
        bdiv.t(paramQQAppInterface.getApp(), paramConfig.version.get(), jdField_a_of_type_JavaLangString);
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
      paramConfig = avxz.a(paramConfig.content.get().toByteArray());
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
        ((alws)paramQQAppInterface.getManager(22)).a(paramConfig, j);
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
    avqz localavqz = (avqz)paramQQAppInterface.getManager(228);
    int i = localavqz.a();
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
          paramQQAppInterface = avxz.a(paramConfig.content.get().toByteArray());
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
        localavqz.a(bool1, paramQQAppInterface);
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
    int i = bddr.a();
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
      paramConfig = avxz.a(paramConfig.content.get().toByteArray());
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
          bddr.a().a(paramQQAppInterface.getApp(), paramConfig, j);
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
    bddr.a().a(j);
  }
  
  private void as(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    int i = paramConfig.version.get();
    int j = bdiv.aa(BaseApplication.getContext(), jdField_a_of_type_JavaLangString);
    QLog.i("SPLASH_ConfigServlet", 1, "handleDevConfig: ,version: " + paramConfig.version.get() + "| localVersion: " + j);
    if (i != j)
    {
      bdiv.z(BaseApplication.getContext(), jdField_a_of_type_JavaLangString, i);
      paramQQAppInterface = a(paramConfig);
      if ((paramQQAppInterface != null) && (paramQQAppInterface.size() > 0)) {}
      try
      {
        paramQQAppInterface = (String)paramQQAppInterface.get(paramQQAppInterface.size() - 1);
        QLog.d("SPLASH_ConfigServlet", 1, new Object[] { "devConfig is ", paramQQAppInterface });
        bdiv.l(BaseApplication.getContext(), jdField_a_of_type_JavaLangString, paramQQAppInterface);
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
  
  private void at(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    boolean bool = false;
    int i = paramConfig.version.get();
    BaseApplication localBaseApplication = paramQQAppInterface.getApp();
    String str = paramQQAppInterface.c();
    int j = ((Integer)bdiv.a(localBaseApplication, str, "config_tim_team_version_code", Integer.valueOf(0))).intValue();
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
      bdiv.a(localBaseApplication, str, false, "config_tim_team_is_web", Boolean.valueOf(bool));
      bdiv.a(localBaseApplication, str, false, "config_tim_team_url", paramQQAppInterface);
      bdiv.a(localBaseApplication, str, true, "config_tim_team_version_code", Integer.valueOf(i));
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
        localObject2 = amsl.a((byte[])localObject1);
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
    amsx localamsx = (amsx)localQQAppInterface.getManager(168);
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
          paramIntent = amsl.a(paramIntent.content.get().toByteArray());
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
        if (localamsx != null) {
          localamsx.a(paramIntent);
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
      if (localamsx != null) {
        localamsx.b();
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
    paramIntent = axjt.a();
    int j = paramConfig.version.get();
    int i = bdiv.i(((QQAppInterface)getAppRuntime()).getApp());
    if (!axjt.a()) {
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
      bdiv.g(((QQAppInterface)getAppRuntime()).getApp(), j);
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
    int j = agug.a(paramQQAppInterface);
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
        agug.a(paramQQAppInterface, paramConfig.getBoolean("useRecommendedSticker"));
        agug.a(localBaseApplication, str, paramConfig.getInt("maxMatchLength"));
      }
      for (;;)
      {
        agug.a(paramQQAppInterface, i);
        return;
        agug.a(paramQQAppInterface, false);
      }
    }
    catch (Exception paramConfig)
    {
      for (;;)
      {
        agug.a(paramQQAppInterface, false);
        if (QLog.isColorLevel()) {
          QLog.d("SPLASH_ConfigServlet", 2, paramConfig.getMessage());
        }
      }
    }
  }
  
  public static void b(QQAppInterface paramQQAppInterface, String paramString)
  {
    jdField_a_of_type_JavaLangString = paramString;
    NewIntent localNewIntent = new NewIntent(paramQQAppInterface.getApp(), aova.class);
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
        bdiv.d(((QQAppInterface)getAppRuntime()).getCurrentAccountUin()).edit().putString("qav_anychat_time_value", paramString).commit();
        bdiv.j(getAppRuntime().getApplication(), paramInt, jdField_a_of_type_JavaLangString);
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
    amsx localamsx = (amsx)localQQAppInterface.getManager(168);
    if (localamsx == null)
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
      localamsx.a(i);
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
          paramIntent = amsl.a((byte[])localObject2);
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
      localamsx.b(j);
      localamsx.a(localNameNotFoundException);
      if (QLog.isColorLevel()) {
        QLog.d("ArConfig_configServlet", 2, "maxEndTimeArConfigInfo|| maxEndtime=" + localNameNotFoundException.aREnd);
      }
      OlympicServlet.a(localQQAppInterface, 87, j, 0, 0, 0, 0);
    }
    for (;;)
    {
      i = 0;
      label648:
      if ((i == 0) || (localamsx == null)) {
        break;
      }
      QLog.d("ArConfig_configServlet", 1, "arManager.downloadArResource");
      localamsx.a(true, false);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ArConfig_configServlet", 2, "handleResp_GetArResource|combineArConfigInfo is null");
      }
      OlympicServlet.a(localQQAppInterface, 87, j, 0, 0, 5, 0);
      continue;
      label707:
      localamsx.a();
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
    int j = bdiv.Q(BaseApplication.getContext(), jdField_a_of_type_JavaLangString);
    if (QLog.isColorLevel()) {
      QLog.i("SPLASH_ConfigServlet", 2, "handleRespNewBoatConfig: ,version: " + paramConfig.version.get() + "| localVersion: " + j);
    }
    if (i != j)
    {
      bdiv.s(BaseApplication.getContext(), i, jdField_a_of_type_JavaLangString);
      paramConfig = a(paramConfig);
      if ((paramConfig != null) && (paramConfig.size() > 0)) {
        aupg.a(paramQQAppInterface, (String)paramConfig.get(0));
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
          localObject5 = ((awbw)localObject3).a(ExpiredPushBanner.class);
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
      if (!aofw.a(paramString)) {
        ThreadManager.executeOnNetWorkThread(new ConfigServlet.4(this, (String)localObject1));
      }
      aofs.a.a(aofs.a.a(l1, (String)localObject2, (byte)3, (String)localObject1, (String)localObject4, (String)localObject5, l3 + "|" + l2, (short)k, paramString));
      paramInt = 1;
      k = 1;
    }
    for (;;)
    {
      try
      {
        localObject1 = ((awbw)localObject3).a(ReportedBanner.class, false, null, null, null, null, "endtime DESC", null);
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
                ((awbw)localObject3).b((awbv)localObject2);
                break label1064;
              }
            }
          }
        }
        if (j == 0) {
          break label1015;
        }
        azmj.b((QQAppInterface)getAppRuntime(), "dc00898", "", "", "0X80087C0", "0X80087C0", (int)l1, 0, "", "", "", "");
        localObject1 = new ReportedBanner();
        ((ReportedBanner)localObject1).cid = l1;
        ((ReportedBanner)localObject1).md5 = paramString;
        ((ReportedBanner)localObject1).endtime = l2;
        ((awbw)localObject3).a((awbv)localObject1);
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
    amnv localamnv = (amnv)((QQAppInterface)getAppRuntime()).getManager(220);
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
      arrayOfByte = avxz.a(paramIntent.content.get().toByteArray());
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
          if (localamnv.a(paramIntent))
          {
            localamnv.a(i);
            localamnv.a();
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
        if (localamnv != null) {
          localamnv.b();
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
    int j = bdiv.g(((QQAppInterface)getAppRuntime()).getApp());
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
        arrayOfByte = avxz.a(paramConfig.content.get().toByteArray());
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
          boolean bool = bbpo.a(paramConfig);
          if (bool) {
            bdiv.e(((QQAppInterface)getAppRuntime()).getApp(), i);
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
    //   0: invokestatic 913	javax/xml/parsers/DocumentBuilderFactory:newInstance	()Ljavax/xml/parsers/DocumentBuilderFactory;
    //   3: invokevirtual 917	javax/xml/parsers/DocumentBuilderFactory:newDocumentBuilder	()Ljavax/xml/parsers/DocumentBuilder;
    //   6: new 919	java/io/ByteArrayInputStream
    //   9: dup
    //   10: aload_1
    //   11: ldc_w 921
    //   14: invokevirtual 925	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   17: invokespecial 926	java/io/ByteArrayInputStream:<init>	([B)V
    //   20: invokevirtual 931	javax/xml/parsers/DocumentBuilder:parse	(Ljava/io/InputStream;)Lorg/w3c/dom/Document;
    //   23: astore 14
    //   25: aload 14
    //   27: ldc_w 4136
    //   30: invokeinterface 939 2 0
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
    //   59: ldc_w 4138
    //   62: astore_1
    //   63: ldc 13
    //   65: astore 13
    //   67: iconst_0
    //   68: istore 9
    //   70: iload 9
    //   72: aload 15
    //   74: invokeinterface 944 1 0
    //   79: if_icmpge +480 -> 559
    //   82: aload 14
    //   84: ldc_w 3387
    //   87: invokeinterface 939 2 0
    //   92: iload 9
    //   94: invokeinterface 950 2 0
    //   99: invokeinterface 956 1 0
    //   104: invokeinterface 959 1 0
    //   109: astore 13
    //   111: aload 14
    //   113: ldc_w 3393
    //   116: invokeinterface 939 2 0
    //   121: iload 9
    //   123: invokeinterface 950 2 0
    //   128: invokeinterface 956 1 0
    //   133: invokeinterface 959 1 0
    //   138: astore 12
    //   140: aload 14
    //   142: ldc_w 4139
    //   145: invokeinterface 939 2 0
    //   150: iload 9
    //   152: invokeinterface 950 2 0
    //   157: invokeinterface 956 1 0
    //   162: invokeinterface 959 1 0
    //   167: invokestatic 4145	java/lang/Float:parseFloat	(Ljava/lang/String;)F
    //   170: fstore 4
    //   172: aload 14
    //   174: ldc_w 4146
    //   177: invokeinterface 939 2 0
    //   182: iload 9
    //   184: invokeinterface 950 2 0
    //   189: invokeinterface 956 1 0
    //   194: invokeinterface 959 1 0
    //   199: invokestatic 4145	java/lang/Float:parseFloat	(Ljava/lang/String;)F
    //   202: fstore_3
    //   203: iconst_1
    //   204: istore 10
    //   206: aload 14
    //   208: ldc_w 4147
    //   211: invokeinterface 939 2 0
    //   216: iload 9
    //   218: invokeinterface 950 2 0
    //   223: invokeinterface 956 1 0
    //   228: invokeinterface 959 1 0
    //   233: invokestatic 4145	java/lang/Float:parseFloat	(Ljava/lang/String;)F
    //   236: fstore 5
    //   238: aload 14
    //   240: ldc_w 4148
    //   243: invokeinterface 939 2 0
    //   248: iload 9
    //   250: invokeinterface 950 2 0
    //   255: invokeinterface 956 1 0
    //   260: invokeinterface 959 1 0
    //   265: invokestatic 4145	java/lang/Float:parseFloat	(Ljava/lang/String;)F
    //   268: fstore 8
    //   270: aload 14
    //   272: ldc_w 4150
    //   275: invokeinterface 939 2 0
    //   280: iload 9
    //   282: invokeinterface 950 2 0
    //   287: invokeinterface 956 1 0
    //   292: invokeinterface 959 1 0
    //   297: astore 11
    //   299: aload 14
    //   301: ldc_w 4151
    //   304: invokeinterface 939 2 0
    //   309: iload 9
    //   311: invokeinterface 950 2 0
    //   316: invokeinterface 956 1 0
    //   321: invokeinterface 959 1 0
    //   326: invokestatic 4145	java/lang/Float:parseFloat	(Ljava/lang/String;)F
    //   329: fstore 7
    //   331: aload 14
    //   333: ldc_w 4147
    //   336: invokeinterface 939 2 0
    //   341: iload 9
    //   343: invokeinterface 950 2 0
    //   348: invokeinterface 956 1 0
    //   353: invokeinterface 959 1 0
    //   358: invokestatic 4145	java/lang/Float:parseFloat	(Ljava/lang/String;)F
    //   361: fstore 6
    //   363: aload 14
    //   365: ldc_w 4153
    //   368: invokeinterface 939 2 0
    //   373: iload 9
    //   375: invokeinterface 950 2 0
    //   380: invokeinterface 956 1 0
    //   385: invokeinterface 959 1 0
    //   390: astore_1
    //   391: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   394: ifeq +296 -> 690
    //   397: ldc 183
    //   399: iconst_2
    //   400: new 85	java/lang/StringBuilder
    //   403: dup
    //   404: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   407: ldc_w 4155
    //   410: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   413: aload 13
    //   415: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   418: ldc_w 4157
    //   421: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   424: aload 12
    //   426: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   429: ldc_w 4159
    //   432: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   435: fload 4
    //   437: invokevirtual 4162	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   440: ldc_w 4164
    //   443: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   446: fload_3
    //   447: invokevirtual 4162	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   450: ldc_w 4166
    //   453: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   456: iload 10
    //   458: invokevirtual 152	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   461: ldc_w 4168
    //   464: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   467: fload 5
    //   469: invokevirtual 4162	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   472: ldc_w 4170
    //   475: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   478: fload 8
    //   480: invokevirtual 4162	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   483: ldc_w 4172
    //   486: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   489: aload 11
    //   491: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   494: ldc_w 4174
    //   497: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   500: fload 7
    //   502: invokevirtual 4162	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   505: ldc_w 4176
    //   508: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   511: aload_1
    //   512: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   515: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   518: invokestatic 199	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   521: goto +169 -> 690
    //   524: astore_1
    //   525: aload 14
    //   527: ldc_w 4177
    //   530: invokeinterface 939 2 0
    //   535: iload 9
    //   537: invokeinterface 950 2 0
    //   542: invokeinterface 956 1 0
    //   547: invokeinterface 959 1 0
    //   552: invokestatic 4145	java/lang/Float:parseFloat	(Ljava/lang/String;)F
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
    //   585: invokevirtual 47	aova:getAppRuntime	()Lmqq/app/AppRuntime;
    //   588: invokevirtual 2602	mqq/app/AppRuntime:getApplication	()Lmqq/app/MobileQQ;
    //   591: invokevirtual 2729	mqq/app/MobileQQ:getFilesDir	()Ljava/io/File;
    //   594: invokevirtual 2732	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   597: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   600: ldc_w 2762
    //   603: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   606: getstatic 15	aova:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   609: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   612: ldc_w 2762
    //   615: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   618: ldc_w 2807
    //   621: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   624: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   627: astore 14
    //   629: ldc_w 4179
    //   632: aload 13
    //   634: invokestatic 4184	com/tencent/mobileqq/msf/sdk/MsfSdkUtils:insertMtype	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   637: astore 13
    //   639: fload_3
    //   640: fstore 7
    //   642: fload_3
    //   643: fconst_0
    //   644: fcmpg
    //   645: ifge +8 -> 653
    //   648: ldc_w 820
    //   651: fstore 7
    //   653: new 4186	com/tencent/mobileqq/config/splashlogo/ConfigServlet$5
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
    //   678: invokespecial 4189	com/tencent/mobileqq/config/splashlogo/ConfigServlet$5:<init>	(Laova;Ljava/lang/String;Ljava/lang/String;FFFLjava/lang/String;Ljava/lang/String;FZILjava/lang/String;)V
    //   681: iconst_2
    //   682: aconst_null
    //   683: iconst_0
    //   684: invokestatic 3317	com/tencent/mobileqq/app/ThreadManager:post	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
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
    //   710: ldc_w 4138
    //   713: astore_1
    //   714: goto -323 -> 391
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	717	0	this	aova
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
      int j = bdiv.q(((QQAppInterface)getAppRuntime()).getApp(), paramIntent);
      if (QLog.isColorLevel()) {
        QLog.d("nearby_flower_operation_gray_tips", 2, "serverVersion=" + i + "|localVersion=" + j);
      }
      if (i != j)
      {
        bdiv.c(((QQAppInterface)getAppRuntime()).getApp(), paramIntent, i);
        alsy localalsy = (alsy)((QQAppInterface)getAppRuntime()).getManager(124);
        if ((!paramConfig.content_list.has()) || (paramConfig.content_list.get().size() <= 0)) {
          break label246;
        }
        localList = paramConfig.content_list.get();
        if ((localList != null) && (localList.size() > 0))
        {
          localalsy.a(paramIntent, (String)localList.get(0));
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
      ausq.a("GENERAL_LBS_CONFIGS_CMD", new Object[] { "getGeneralLBSConfigs", paramString, Long.valueOf(l) });
    }
    paramString = new NewIntent(paramQQAppInterface.getApp(), aova.class);
    paramString.putExtra("k_cmd_type", new int[] { 87, 12, 174, 189 });
    paramQQAppInterface.startServlet(paramString);
  }
  
  private void e(ConfigurationService.Config paramConfig)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)getAppRuntime();
    int i = paramConfig.version.get();
    int j = bdiv.o(localQQAppInterface.getApp());
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
      bdiv.m(localQQAppInterface.getApp(), i, str);
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
          bdiv.a(getAppRuntime().getApplication(), paramInt, str2, paramString);
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
      int j = bdiv.r(((QQAppInterface)getAppRuntime()).getApp(), paramIntent);
      if (QLog.isColorLevel()) {
        QLog.d("HotChatManager", 2, "serverVersion=" + i + "|localVersion=" + j);
      }
      if (i != j)
      {
        bdiv.d(((QQAppInterface)getAppRuntime()).getApp(), paramIntent, i);
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
    paramString = (awjh)paramQQAppInterface.getManager(179);
    if ((paramString != null) && (paramString.a() != null) && (paramString.a().d * 1000L <= 0L)) {}
    paramString = new NewIntent(paramQQAppInterface.getApp(), aova.class);
    paramString.putExtra("k_cmd_type", new int[] { 113 });
    paramQQAppInterface.startServlet(paramString);
  }
  
  private void f(ConfigurationService.Config paramConfig)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)getAppRuntime();
    int i = paramConfig.version.get();
    int j = bdiv.p(localQQAppInterface.getApp());
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
      bdiv.n(localQQAppInterface.getApp(), i, str);
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
    int i = bdiv.h(((QQAppInterface)getAppRuntime()).getApp());
    if (!PtvTemplateManager.a()) {
      i = 0;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PtvTemplateManager", 2, "serverVersion=" + j + "|localVersion=" + i);
    }
    if (j != i)
    {
      bdiv.f(((QQAppInterface)getAppRuntime()).getApp(), j);
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
    int i = bdiv.k(((QQAppInterface)getAppRuntime()).getApp());
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
        bdiv.i(((QQAppInterface)getAppRuntime()).getApp(), k);
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
    int i = bdiv.j(((QQAppInterface)getAppRuntime()).getApp());
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
        bdiv.h(((QQAppInterface)getAppRuntime()).getApp(), j);
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
    bnlc localbnlc = bnlc.a();
    int k = paramConfig.version.get();
    int i = bdiv.F(((QQAppInterface)getAppRuntime()).getApp());
    if (!localbnlc.a()) {
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
      } while (!localbnlc.a(paramConfig, (QQAppInterface)getAppRuntime()));
      bdiv.u(((QQAppInterface)getAppRuntime()).getApp(), k);
      return;
    } while (!QLog.isColorLevel());
    label195:
    QLog.d("QQSTORY_FOLLOW_CAPTURE_SPLASH_ConfigServlet", 2, "GetQQStoryFollowCaptureConfig|type: 合拍配置回包内容为空");
    return;
    label212:
    if (QLog.isColorLevel()) {
      QLog.d("QQSTORY_FOLLOW_CAPTURE_SPLASH_ConfigServlet", 2, "GetQQStoryFollowCaptureConfig|type: 合拍配置回包为空");
    }
    localbnlc.a();
  }
  
  private void i(Intent paramIntent, ConfigurationService.Config paramConfig)
  {
    NearbyGrayTipsManager localNearbyGrayTipsManager;
    String str2;
    if (!TextUtils.isEmpty(paramIntent.getStringExtra("key_uin")))
    {
      int i = paramConfig.version.get();
      int j = bdiv.f(((QQAppInterface)getAppRuntime()).getApp());
      if (QLog.isColorLevel()) {
        QLog.d("nearby_aio_operation_gray_tips", 2, "serverVersion=" + i + "|localVersion=" + j);
      }
      if (i != j)
      {
        bdiv.d(((QQAppInterface)getAppRuntime()).getApp(), i);
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
          } while (bdje.a(str2));
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
        if (bdje.a(str1)) {
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
    bdiv.h(getAppRuntime().getApplication(), i, jdField_a_of_type_JavaLangString);
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
    if (i == bdiv.o(((QQAppInterface)getAppRuntime()).getApp(), jdField_a_of_type_JavaLangString)) {}
    for (;;)
    {
      return;
      bdiv.k(((QQAppInterface)getAppRuntime()).getApp(), i, jdField_a_of_type_JavaLangString);
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
                ((uhl)paramIntent.getManager(181)).h(Boolean.parseBoolean(paramConfig));
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
    alud localalud = (alud)localQQAppInterface.getManager(102);
    i = localalud.a();
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
        localaluc2 = new aluc();
      }
      catch (Throwable localThrowable2)
      {
        aluc localaluc2;
        XmlPullParser localXmlPullParser;
        int k;
        Object localObject3;
        aluc localaluc1 = null;
        i = 0;
        paramConfig = null;
        localObject1 = null;
        continue;
        localaluc1 = null;
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
        localaluc1 = localaluc2;
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
            localaluc2.jdField_b_of_type_JavaLangString = localXmlPullParser.getAttributeValue(j);
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
          localaluc2.jdField_a_of_type_JavaLangString = localXmlPullParser.getAttributeValue(j);
          continue;
          QLog.e("PhoneContact.Manager", 1, "", localThrowable1);
        }
        catch (Throwable localThrowable1)
        {
          localaluc1 = localaluc2;
        }
      }
      catch (Throwable localThrowable3)
      {
        i = 0;
        paramConfig = null;
        localObject1 = null;
        localaluc1 = localaluc2;
        continue;
        continue;
        continue;
      }
      localObject5 = localObject1;
      localObject3 = paramConfig;
      j = i;
      localalud.a(m, localObject6, localaluc1);
      ((PhoneContactManagerImp)localQQAppInterface.getManager(11)).a(j, localObject5, (String)localObject3);
      return;
      if ("dayNum".equals(localObject3)) {
        localaluc2.jdField_a_of_type_Int = Integer.valueOf(localXmlPullParser.getAttributeValue(j)).intValue();
      } else if ("dayIntervalNum".equals(localObject3)) {
        localaluc2.jdField_b_of_type_Int = Integer.valueOf(localXmlPullParser.getAttributeValue(j)).intValue();
      } else if ("totalNum".equals(localObject3)) {
        localaluc2.c = Integer.valueOf(localXmlPullParser.getAttributeValue(j)).intValue();
      } else if ("loginNum".equals(localObject3)) {
        localaluc2.e = Integer.valueOf(localXmlPullParser.getAttributeValue(j)).intValue();
      } else if ("banner".equals(localObject3)) {
        localaluc2.jdField_a_of_type_Boolean = "1".equals(localXmlPullParser.getAttributeValue(j));
      } else if ("setEntry".equals(localObject3)) {
        localaluc2.jdField_b_of_type_Boolean = "1".equals(localXmlPullParser.getAttributeValue(j));
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
        localaluc1 = localaluc2;
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
    int j = bdiv.p(((QQAppInterface)getAppRuntime()).getApp(), jdField_a_of_type_JavaLangString);
    if (i == j) {}
    label179:
    label195:
    do
    {
      do
      {
        return;
        bdiv.l(((QQAppInterface)getAppRuntime()).getApp(), i, jdField_a_of_type_JavaLangString);
        for (;;)
        {
          try
          {
            if (paramConfig.msg_content_list != null)
            {
              i = paramConfig.msg_content_list.size();
              paramIntent = (asyr)paramIntent.getManager(267);
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
            int k = bdiv.A(localQQAppInterface.getApp(), localQQAppInterface.getAccount());
            if (QLog.isColorLevel()) {
              QLog.d("SPLASH_ConfigServlet", 2, "received SUBSCRIPT_RECOMMEND_CMD remote version: " + j + " | localVersion: " + k);
            }
            if ((j != k) || (paramConfig.content_list.size() > 0))
            {
              if ((swy.a((QQAppInterface)getAppRuntime(), str)) && (QLog.isColorLevel())) {
                QLog.d("SPLASH_ConfigServlet", 2, "received SUBSCRIPT_RECOMMEND_CMD save version: " + j);
              }
              bdiv.l(getAppRuntime().getApplication(), localQQAppInterface.getAccount(), j);
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
            suk.d(localQQAppInterface, "1".equals(localObject3));
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
            bjxj.a((String)localObject2, localQQAppInterface);
          }
          localObject2 = (String)localHashMap.get("synchronize_to_qzone");
          if (localObject2 != null) {
            bjxj.b((String)localObject2, localQQAppInterface);
          }
          localObject2 = (String)localHashMap.get("merge_feeds");
          if (localObject2 != null) {
            bjxj.d((String)localObject2, localQQAppInterface);
          }
          localObject2 = (String)localHashMap.get("kandian_feeds");
          if (localObject2 != null) {
            bjxj.e((String)localObject2, localQQAppInterface);
          }
          i = paramConfig.version.get();
          bdiv.g(getAppRuntime().getApplication(), i, jdField_a_of_type_JavaLangString);
          if ((paramIntent != null) && (paramIntent.hasExtra("update101Version"))) {
            SettingCloneUtil.writeValueForInt(getAppRuntime().getApplication(), jdField_a_of_type_JavaLangString, null, "qqsetting_calltab_show_key_version", paramIntent.getIntExtra("update101Version", 0));
          }
          ArkAppCenter.a((String)localHashMap.get("arkapp_pa_nshow"));
          aush.a(localQQAppInterface.getAccount(), "supportHotChatDemo", Boolean.valueOf("1".equals(localHashMap.get("hotchat_demo"))));
          paramIntent = (awti)localQQAppInterface.getManager(89);
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
            azcw.a(paramIntent, true);
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
                paramConfig = ayqw.a();
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
              ayrd.jdField_b_of_type_Int = Integer.valueOf(paramIntent).intValue();
              ajyd.a((String)localHashMap.get("shortvideo_progressive_enable"));
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
              azls.a("pic_thumb_400Enable", paramIntent);
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
              astc.a();
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
      j = bdiv.E(localQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
      if (QLog.isColorLevel()) {
        QLog.d("SPLASH_ConfigServlet", 2, "received READINJOY_LOCAL_CHANNEL_CONFIG_CMD remote version: " + i + " | localVersion: " + j);
      }
      if (i != j)
      {
        bdiv.m(localQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, i);
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
    int i = bdiv.m(((QQAppInterface)getAppRuntime()).getApp());
    if (!PtvTemplateManager.d()) {
      i = 0;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PtvTemplateManager", 2, "GetBlessSpecialPendantConfig serverVersion=" + j + "|localVersion=" + i);
    }
    if (j != i)
    {
      bdiv.j(((QQAppInterface)getAppRuntime()).getApp(), j);
      if ((paramConfig.msg_content_list == null) || (paramConfig.msg_content_list.size() <= 0)) {
        break label269;
      }
      paramIntent = (ConfigurationService.Content)paramConfig.msg_content_list.get(0);
      if (paramIntent != null)
      {
        if (paramIntent.compress.get() != 1) {
          break label255;
        }
        paramIntent = avxz.a(paramIntent.content.get().toByteArray());
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
      int i = bdiv.s(((QQAppInterface)getAppRuntime()).getApp());
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
          aarq.a(BaseApplicationImpl.sApplication, paramConfig);
          i += 1;
          continue;
          if ((paramConfig.content_list != null) && (paramConfig.content_list.size() > 0)) {
            i = 0;
          }
          while (i < paramConfig.content_list.size())
          {
            localObject = (String)paramConfig.content_list.get(i);
            QLog.d("PatchLogTag", 1, "handlePatchConfigCmd content_list index=" + i + ", content=" + (String)localObject);
            aarq.a(BaseApplicationImpl.sApplication, (String)localObject);
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
        aarj.a(localQQAppInterface);
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
      j = bdiv.w(localQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
      if (QLog.isColorLevel()) {
        QLog.d("SPLASH_ConfigServlet", 2, "received SEARCH_CONFIG_CMD remote version: " + i + " | localVersion: " + j);
      }
      if (i != j)
      {
        bdiv.i(localQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, i);
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
      j = bdiv.t(localQQAppInterface.getApp());
      if (QLog.isColorLevel()) {
        QLog.d("SPLASH_ConfigServlet", 2, "received CAMERA_COMPATIBLE_LIST_CONFIG remote version: " + i + " | localVersion: " + j);
      }
      if (i != j)
      {
        bdiv.m(localQQAppInterface.getApp(), i);
        if (QLog.isColorLevel()) {
          QLog.d("SPLASH_ConfigServlet", 2, "received CAMERA_COMPATIBLE_LIST_CONFIG save version: " + i);
        }
        azcw.a(str, true);
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
      if (i != bdiv.v(localQQAppInterface.getApp()))
      {
        bdiv.n(localQQAppInterface.getApp(), i);
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
    int j = bdiv.ar(paramQQAppInterface.getApp().getBaseContext(), jdField_a_of_type_JavaLangString);
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
          arrayOfByte = avxz.a(((ConfigurationService.Content)localObject1).content.get().toByteArray());
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
      bdiv.v(paramQQAppInterface.getApp().getBaseContext(), k, jdField_a_of_type_JavaLangString);
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
            localObject = awjn.a((ConfigurationService.Content)localObject);
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
      awjn.a(localQQAppInterface.getApp(), paramConfig.version.get(), jdField_a_of_type_JavaLangString);
      paramConfig = (awjh)localQQAppInterface.getManager(179);
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
    int j = bdiv.B(localQQAppInterface.getApp(), localQQAppInterface.getAccount());
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
        aipw.a(localQQAppInterface, i, str);
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
    paramConfig = (aipw)localQQAppInterface.getManager(125);
    paramConfig.jdField_b_of_type_Boolean = true;
    paramConfig.c = MessageForFoldMsgGrayTips.PASSWD_REDBAG_MSG_SWITCH_DEFAULT;
    paramConfig.jdField_a_of_type_Int = MessageForFoldMsgGrayTips.PASSWD_REDBAG_MSG_DISPLAY_NUM_DEFAULT;
    paramConfig.d = MessageForFoldMsgGrayTips.PASSWD_REDBAG_MSG_SWITCH_INDEX;
    paramConfig.e = MessageForFoldMsgGrayTips.PASSWD_REDBAG_MSG_INDEX_WITH_ID;
    bdiv.a(localQQAppInterface.getApp(), localQQAppInterface.getAccount(), i, paramConfig.c, paramConfig.jdField_a_of_type_Int, paramConfig.d, paramConfig.e);
  }
  
  public static void w(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    int i = paramConfig.version.get();
    int j = bdiv.at(BaseApplication.getContext(), jdField_a_of_type_JavaLangString);
    if (QLog.isColorLevel()) {
      QLog.i("SPLASH_ConfigServlet", 2, "handleReceiptConfig: ,version: " + paramConfig.version.get() + "| localVersion: " + j);
    }
    if (i != j)
    {
      bdiv.Q(BaseApplication.getContext(), jdField_a_of_type_JavaLangString, i);
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
              bdiv.e(BaseApplication.getContext(), jdField_a_of_type_JavaLangString, "receipt_kReceiptMsgEnable", i);
            }
            if (((JSONObject)localObject).has("kReceiptMsgMaxSendTimes"))
            {
              i = ((JSONObject)localObject).getInt("kReceiptMsgMaxSendTimes");
              bdiv.e(BaseApplication.getContext(), jdField_a_of_type_JavaLangString, "receipt_kReceiptMsgSendTimes", i);
            }
          }
          catch (JSONException localJSONException)
          {
            localJSONException.printStackTrace();
          }
        }
        aekh.a(paramQQAppInterface);
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
      localObject = (alro)((QQAppInterface)localObject).getManager(159);
      if (paramConfig.content_list.size() < 0)
      {
        str = (String)paramConfig.content_list.get(0);
        i = paramConfig.version.get();
        j = ((alro)localObject).b();
        if (QLog.isColorLevel()) {
          QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 74,content: " + str + ",version: " + paramConfig.version.get());
        }
        if ((i != j) || (paramConfig.content_list.size() > 0)) {
          ((alro)localObject).a(i, str);
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
    //   1: invokevirtual 47	aova:getAppRuntime	()Lmqq/app/AppRuntime;
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
    //   28: invokestatic 1612	bdiv:au	(Landroid/content/Context;Ljava/lang/String;)I
    //   31: istore_2
    //   32: aload 71
    //   34: invokevirtual 65	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   37: aload 71
    //   39: invokevirtual 69	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   42: invokestatic 1615	bdiv:av	(Landroid/content/Context;Ljava/lang/String;)I
    //   45: istore_3
    //   46: invokestatic 203	com/tencent/common/config/AppSetting:a	()I
    //   49: istore 4
    //   51: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   54: ifeq +49 -> 103
    //   57: ldc 183
    //   59: iconst_2
    //   60: ldc_w 4936
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
    //   121: invokestatic 4938	bdiv:R	(Landroid/content/Context;Ljava/lang/String;I)V
    //   124: iconst_0
    //   125: istore_2
    //   126: iload 34
    //   128: iload_2
    //   129: if_icmpeq +3257 -> 3386
    //   132: aload_1
    //   133: iload_2
    //   134: sipush 228
    //   137: invokestatic 2280	aova:b	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;II)Ljava/lang/String;
    //   140: astore 72
    //   142: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   145: ifeq +12 -> 157
    //   148: ldc_w 4940
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
    //   377: invokestatic 913	javax/xml/parsers/DocumentBuilderFactory:newInstance	()Ljavax/xml/parsers/DocumentBuilderFactory;
    //   380: invokevirtual 917	javax/xml/parsers/DocumentBuilderFactory:newDocumentBuilder	()Ljavax/xml/parsers/DocumentBuilder;
    //   383: new 919	java/io/ByteArrayInputStream
    //   386: dup
    //   387: aload 72
    //   389: ldc_w 921
    //   392: invokevirtual 925	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   395: invokespecial 926	java/io/ByteArrayInputStream:<init>	([B)V
    //   398: invokevirtual 931	javax/xml/parsers/DocumentBuilder:parse	(Ljava/io/InputStream;)Lorg/w3c/dom/Document;
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
    //   523: ldc_w 4942
    //   526: invokeinterface 939 2 0
    //   531: iconst_0
    //   532: invokeinterface 950 2 0
    //   537: invokeinterface 956 1 0
    //   542: invokeinterface 959 1 0
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
    //   669: ldc_w 4944
    //   672: invokeinterface 939 2 0
    //   677: iconst_0
    //   678: invokeinterface 950 2 0
    //   683: invokeinterface 956 1 0
    //   688: invokeinterface 959 1 0
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
    //   815: ldc_w 4946
    //   818: invokeinterface 939 2 0
    //   823: iconst_0
    //   824: invokeinterface 950 2 0
    //   829: invokeinterface 956 1 0
    //   834: invokeinterface 959 1 0
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
    //   961: ldc_w 4948
    //   964: invokeinterface 939 2 0
    //   969: iconst_0
    //   970: invokeinterface 950 2 0
    //   975: invokeinterface 956 1 0
    //   980: invokeinterface 959 1 0
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
    //   1102: ldc_w 4950
    //   1105: invokeinterface 939 2 0
    //   1110: iconst_0
    //   1111: invokeinterface 950 2 0
    //   1116: invokeinterface 956 1 0
    //   1121: invokeinterface 959 1 0
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
    //   1244: ldc_w 4952
    //   1247: invokeinterface 939 2 0
    //   1252: iconst_0
    //   1253: invokeinterface 950 2 0
    //   1258: invokeinterface 956 1 0
    //   1263: invokeinterface 959 1 0
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
    //   1398: ldc_w 4954
    //   1401: invokeinterface 939 2 0
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
    //   1549: invokeinterface 944 1 0
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
    //   1686: invokeinterface 950 2 0
    //   1691: invokeinterface 956 1 0
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
    //   1835: invokeinterface 959 1 0
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
    //   2863: invokestatic 4406	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   2866: invokevirtual 1829	java/lang/Integer:intValue	()I
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
    //   2992: invokestatic 4406	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   2995: invokevirtual 1829	java/lang/Integer:intValue	()I
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
    //   3116: invokestatic 4406	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   3119: invokevirtual 1829	java/lang/Integer:intValue	()I
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
    //   3292: invokestatic 4959	aghg:a	()Laghg;
    //   3295: aload 71
    //   3297: invokevirtual 4962	aghg:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)Ljava/lang/String;
    //   3300: astore 39
    //   3302: invokestatic 4959	aghg:a	()Laghg;
    //   3305: aload 71
    //   3307: invokevirtual 4964	aghg:c	(Lcom/tencent/mobileqq/app/QQAppInterface;)Ljava/lang/String;
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
    //   3337: invokestatic 4959	aghg:a	()Laghg;
    //   3340: iload_3
    //   3341: iload 4
    //   3343: aload_1
    //   3344: aload 36
    //   3346: aload 38
    //   3348: aload 37
    //   3350: iload 35
    //   3352: iload 5
    //   3354: invokevirtual 4967	aghg:a	(IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZI)V
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
    //   3383: invokestatic 4970	bdiv:a	(Landroid/content/Context;Ljava/lang/String;IIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZI)V
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
    //   3411: ldc_w 4940
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
    //   3460: ldc_w 4940
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
    //   3509: ldc_w 4940
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
    //   3558: ldc_w 4940
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
    //   3607: ldc_w 4940
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
    //   3656: ldc_w 4940
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
    //   3710: ldc_w 4972
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
    //   0	3805	0	this	aova
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
    int i = bdiv.aw(localQQAppInterface.getApp(), localQQAppInterface.getAccount());
    int j = bdiv.ax(localQQAppInterface.getApp(), localQQAppInterface.getAccount());
    int k = AppSetting.a();
    if (QLog.isColorLevel()) {
      QLog.d("SPLASH_ConfigServlet", 2, String.format("received TimUserSpecial remote version: %d, localVersion: %d ,originalAppId:%d, currentAppId:%d", new Object[] { Integer.valueOf(n), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) }));
    }
    if (j != k)
    {
      bdiv.S(localQQAppInterface.getApp(), localQQAppInterface.getAccount(), k);
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
          paramConfig = agun.a().a(localQQAppInterface);
          localObject = agun.a().b(localQQAppInterface);
          bool = false;
          if ((!paramConfig.equals(localConfig)) || (!((String)localObject).equals(str))) {
            break label490;
          }
          agun.a().a(0, m, localConfig, "", str, "", bool, 0);
          bdiv.b(localQQAppInterface.getApp(), localQQAppInterface.getCurrentAccountUin(), n, 0, m, localConfig, str, "", "", bool, 0);
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
    int i = bdiv.C(localQQAppInterface.getApp(), localQQAppInterface.getAccount());
    int j = bdiv.y(localQQAppInterface.getApp(), localQQAppInterface.getAccount());
    int k = AppSetting.a();
    if (QLog.isColorLevel()) {
      QLog.d("pokeMsg", 2, String.format("handlePokeMsgConfig.received PokeMsgConfig remote version: %d, localVersion: %d ,originalAppId:%d, currentAppId:%d", new Object[] { Integer.valueOf(i58), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) }));
    }
    if (j != k)
    {
      bdiv.j(localQQAppInterface.getApp(), localQQAppInterface.getAccount(), k);
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
            localObject5 = afsw.a(localQQAppInterface, 5);
            localObject9 = afsw.a(localQQAppInterface, 6);
            if ((localObject4 == null) || (!((String)localObject4).equals(localObject5)) || (localObject3 == null) || (!((String)localObject3).equals(localObject9)))
            {
              afsw.jdField_b_of_type_Boolean = false;
              afsw.c = false;
              bdiv.a(false);
              afsw.a(localQQAppInterface, (String)localObject4, (String)localObject3, afsw.d);
            }
            bdiv.a(localQQAppInterface.getApp(), localQQAppInterface.getAccount(), k, (String)localObject4, (String)localObject3, (String)localObject1, (String)localObject7, j, m, n, i1);
            afsw.a(localQQAppInterface, k, (String)localObject4, (String)localObject3, (String)localObject1, (String)localObject7, j, n, i1);
            afsw.b(m);
          }
          if ((i10 != 0) && (i23 != 0) && (i8 != 0) && (i7 != 0) && (i6 != 0))
          {
            localQQAppInterface.getApp().getSharedPreferences(localQQAppInterface.getCurrentAccountUin(), 0).edit().putBoolean("chat_tool_poke_clicked", false).commit();
            afsw.b(localQQAppInterface, false);
            afsw.a(localQQAppInterface, false);
            afsw.a(i19, i25, i14, i13);
            bdiv.a(localQQAppInterface.getApp(), localQQAppInterface.getAccount(), i58, true, i19, i25, i14, i13);
            afsw.a((String)localObject2);
            bdiv.b(localQQAppInterface.getApp(), localQQAppInterface.getAccount(), i58, (String)localObject2);
            afsw.a(i3);
            bdiv.a(localQQAppInterface.getApp(), localQQAppInterface.getAccount(), i58, i3);
            afsw.c(i2);
            bdiv.b(localQQAppInterface.getApp(), localQQAppInterface.getAccount(), i58, i2);
            afsw.a(i35, i4);
            bdiv.a(localQQAppInterface.getApp(), localQQAppInterface.getAccount(), i58, i35, i4);
          }
          if ((i5 != 0) && (i36 != 0) && (i36 != 0))
          {
            localObject1 = PreferenceManager.getDefaultSharedPreferences(localQQAppInterface.getApp()).getString(localQQAppInterface.getAccount() + "_" + "aio_poke_res_url", "");
            bdiv.a(localQQAppInterface.getApp(), localQQAppInterface.getAccount(), i58, l2, (String)localObject13, (String)localObject17);
            if ((localObject13 != null) && (!((String)localObject13).equals(localObject1))) {
              ((PokeBigResHandler)localQQAppInterface.a(117)).a(true);
            }
          }
          afsw.c(i2);
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
          localObject9 = afsw.a(localObject19[1]);
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
          i16 = afsw.c(localObject19[1]);
        }
        try
        {
          i17 = afsw.b(localObject19[1]);
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
          i19 = afsw.a(localObject19[1]);
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
          i15 = afsw.d(localObject19[1]);
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
      i8 = afsw.h;
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
      i9 = afsw.i;
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
        if (bckj.a().a(paramConfig)) {
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
      ((aeky)paramQQAppInterface.getManager(218)).d();
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
    paramQQAppInterface = (aeky)paramQQAppInterface.getManager(218);
    paramQQAppInterface.a(paramConfig);
    paramQQAppInterface.c();
  }
  
  public void D(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    int i = paramConfig.version.get();
    if (i != azex.a(paramQQAppInterface.getApp()))
    {
      paramConfig = a(paramConfig);
      if ((paramConfig != null) && (paramConfig.size() > 0)) {
        azex.a((String)paramConfig.get(0), i, paramQQAppInterface.getApp());
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
      i = bdiv.a(paramQQAppInterface.getApp(), "sport_config", jdField_a_of_type_JavaLangString);
      j = paramConfig.version.get();
    } while (i == j);
    ((bduj)paramQQAppInterface.getManager(260)).a(paramConfig);
    bdiv.a(paramQQAppInterface.getApp(), "sport_config", jdField_a_of_type_JavaLangString, j);
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
        str = a(paramConfig, bdiv.a(paramQQAppInterface.getApp(), "troop_gift_anim_limit", "0"), 281);
      } while (TextUtils.isEmpty(str));
      if (QLog.isColorLevel()) {
        QLog.d("SPLASH_ConfigServlet", 2, "handleTroopGiftLimitConfig content: " + str);
      }
      int i = paramConfig.version.get();
      bdiv.a(paramQQAppInterface.getApp(), "troop_gift_anim_limit", "0", i);
      try
      {
        i = new JSONObject(str).getInt("limitGiftAnimCount");
        bcfr.jdField_b_of_type_Int = i;
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
      zdi.c();
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
      i = bdiv.a(paramQQAppInterface.getApp(), "task_entry_config_version", jdField_a_of_type_JavaLangString);
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
          bdiv.a(paramQQAppInterface.getApp(), "task_entry_config_version", jdField_a_of_type_JavaLangString, j);
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
    if (i != bngq.a().a(paramQQAppInterface.getApp()))
    {
      paramConfig = a(paramConfig);
      if ((paramConfig != null) && (paramConfig.size() > 0))
      {
        paramConfig = (String)paramConfig.get(paramConfig.size() - 1);
        bngq.a().a(paramConfig, i, paramQQAppInterface.getApp());
      }
    }
  }
  
  public void L(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    int i = paramConfig.version.get();
    if (i != bnky.a().a(paramQQAppInterface.getApp()))
    {
      paramConfig = a(paramConfig);
      if ((paramConfig != null) && (paramConfig.size() > 0))
      {
        paramConfig = (String)paramConfig.get(0);
        bnky.a().a(paramConfig, i, paramQQAppInterface.getApp());
      }
    }
  }
  
  public void M(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    int i = paramConfig.version.get();
    int j = bdiv.a(paramQQAppInterface.getApp(), "buluo_enter_config_version", jdField_a_of_type_JavaLangString);
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
                paramConfig = paramConfig + bdbi.encodeToString(((String)localObject2).getBytes(), 0);
                bdiv.c(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin(), paramConfig);
                if (QLog.isColorLevel()) {
                  QLog.e("SPLASH_ConfigServlet", 2, new Object[] { "handleBuluoEnterConfig. buluoEntryUrl: ", paramConfig });
                }
              }
            }
          }
          for (;;)
          {
            bdiv.a(paramQQAppInterface.getApp(), "buluo_enter_config_version", jdField_a_of_type_JavaLangString, i);
            return;
            if (paramConfig.has("tribe_summary_url"))
            {
              paramConfig = paramConfig.optJSONObject("tribe_summary_url");
              if (paramConfig.has("android"))
              {
                paramConfig = paramConfig.optString("android");
                bdiv.d(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin(), paramConfig);
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
    amnv localamnv = (amnv)((QQAppInterface)getAppRuntime()).getManager(220);
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
      arrayOfByte = avxz.a(paramIntent.content.get().toByteArray());
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
          if (localamnv.b(paramIntent)) {
            localamnv.b(i);
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
        if (localamnv != null) {
          localamnv.c();
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
                paramConfig = avxz.a(paramIntent.content.get().toByteArray());
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
      arrayOfByte = avxz.a(paramIntent.content.get().toByteArray());
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
        amtb.a(paramQQAppInterface, paramIntent, paramConfig.version.get());
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
      amtb.b(paramQQAppInterface);
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
          byte[] arrayOfByte = avxz.a(((ConfigurationService.Content)localObject1).content.get().toByteArray());
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
            if ((i == bdiv.a(paramQQAppInterface.getApp(), "nearby_glamour_level_config_version", jdField_a_of_type_JavaLangString)) || (TextUtils.isEmpty((CharSequence)localObject1))) {
              continue;
            }
            auqm.a((String)localObject1);
            auqm.b((String)localObject1);
            bdiv.h(paramQQAppInterface.getApp(), (String)localObject1);
            bdiv.a(paramQQAppInterface.getApp(), "nearby_glamour_level_config_version", jdField_a_of_type_JavaLangString, i);
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
  
  protected void a(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig, String paramString, aovd paramaovd)
  {
    int j = paramConfig.version.get();
    int i = paramaovd.a();
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
          arrayOfByte = avxz.a(paramQQAppInterface.content.get().toByteArray());
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
      paramaovd.a(j);
      paramaovd.a(localArrayList);
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
            if ((j != bdiv.L(localQQAppInterface.getApp(), localQQAppInterface.getCurrentAccountUin())) || (paramConfig.content_list.size() > 0))
            {
              str = str.split("=")[1];
              if (!TextUtils.isEmpty(str)) {
                bjxj.c(str, localQQAppInterface);
              }
              bdiv.o(localQQAppInterface.getApp(), j, localQQAppInterface.getCurrentAccountUin());
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
          anwv.a(BaseApplicationImpl.getContext(), k);
          if (QLog.isColorLevel()) {
            QLog.d("Q.camera.configServlet", 2, "[handleRespQCameraPhoneConfig] save version: " + k + " and check config version: " + anwv.a(BaseApplicationImpl.getContext()));
          }
          if ((paramConfig.msg_content_list == null) || (paramConfig.msg_content_list.size() <= 0)) {
            break label560;
          }
          paramIntent = (ConfigurationService.Content)paramConfig.msg_content_list.get(0);
          i = paramIntent.task_id.get();
          if (paramIntent.compress.get() != 1) {
            break label506;
          }
          paramIntent = anwv.a(paramIntent.content.get().toByteArray());
          if (paramIntent == null)
          {
            paramInt = 4;
            anwv.a(BaseApplicationImpl.getContext(), true);
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
          azmz.a(BaseApplication.getContext()).a(str, "qcamera_phone_config_pull_event", paramBoolean, 0L, 0L, paramIntent, String.valueOf(j));
          return;
          paramInt = 0;
          paramIntent = new String(paramIntent);
          if (QLog.isColorLevel()) {
            QLog.d("Q.camera.configServlet", 4, "[handleRespQCameraPhoneConfig] zip");
          }
          try
          {
            anwv.a(BaseApplicationImpl.getContext(), paramIntent, k);
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
          anwv.a(BaseApplicationImpl.getContext(), paramIntent, k);
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
      QLog.w("Q.camera.configServlet", 1, "[handleRespQCameraPhoneConfig] no data, current disableCameraSDK=" + anwv.a(BaseApplicationImpl.getContext()));
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
        aycr localaycr = (aycr)paramQQAppInterface.getManager(222);
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
                byte[] arrayOfByte = avxz.a(((ConfigurationService.Content)localObject1).content.get().toByteArray());
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
                  if ((j == bdiv.a(paramQQAppInterface.getApp(), "search_function_config_version", jdField_a_of_type_JavaLangString)) || (TextUtils.isEmpty((CharSequence)localObject1))) {
                    continue;
                  }
                  localaycr.b(new JSONObject((String)localObject1).optString("kFTSFunctionListUrlKey"));
                  bdiv.a(paramQQAppInterface.getApp(), "search_function_config_version", jdField_a_of_type_JavaLangString, j);
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
            if ((j != bdiv.K(localQQAppInterface.getApp(), localQQAppInterface.c())) || (paramConfig.content_list.size() > 0))
            {
              if (bjxj.a(localQQAppInterface, str))
              {
                if (QLog.isColorLevel()) {
                  QLog.d("SPLASH_ConfigServlet", 2, "received 72 ark config");
                }
                bdiv.s(getAppRuntime().getApplication(), localQQAppInterface.c(), j);
                break label304;
              }
              if ((!swy.b((QQAppInterface)getAppRuntime(), str)) || (!QLog.isColorLevel())) {
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
            if ((j != bdiv.x(localQQAppInterface.getApp())) || (paramConfig.content_list.size() > 0))
            {
              Object localObject2 = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new ByteArrayInputStream(((String)localObject1).getBytes("utf-8")));
              localObject1 = (Element)((Document)localObject2).getElementsByTagName("kandian_setting").item(0);
              localObject2 = (Element)((Document)localObject2).getElementsByTagName("url").item(0);
              localObject1 = ((Element)localObject1).getFirstChild().getNodeValue();
              localObject2 = ((Element)localObject2).getFirstChild().getNodeValue();
              if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!TextUtils.isEmpty((CharSequence)localObject2))) {
                bdiv.b(localQQAppInterface.getApp(), (String)localObject2, "1".equals(localObject1));
              }
              bdiv.o(localQQAppInterface.getApp(), j);
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
            byte[] arrayOfByte = avxz.a(((ConfigurationService.Content)localObject1).content.get().toByteArray());
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
              aupg.a(paramQQAppInterface, (String)localObject1, paramConfig.version.get());
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
      int i = bdiv.a(paramQQAppInterface.getApp(), "shop_tab", jdField_a_of_type_JavaLangString);
      int j = paramConfig.version.get();
      if ((i != j) && (paramConfig.content_list != null) && (paramConfig.content_list.size() > 0)) {
        try
        {
          paramConfig = new JSONObject((String)paramConfig.content_list.get(0));
          boolean bool = paramConfig.getBoolean("android");
          bdiv.a(paramQQAppInterface.getApp(), "shop_tab", jdField_a_of_type_JavaLangString, j);
          paramQQAppInterface = (ntw)paramQQAppInterface.getManager(88);
          paramQQAppInterface.b(bool);
          paramQQAppInterface.c = paramConfig.optBoolean("preload_web_process", false);
          paramQQAppInterface.a = paramConfig.optLong("stay_time", 5000L);
          paramQQAppInterface.d = paramConfig.optInt("day_limit", 3);
          ntw.a().edit().putBoolean("preload_web", paramQQAppInterface.c).putLong("stayTime", paramQQAppInterface.a).putInt("dayLimit", paramQQAppInterface.d).commit();
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
    int i = bdiv.X(paramQQAppInterface.getApp(), paramQQAppInterface.c());
    int j = paramConfig.version.get();
    if (i == j)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SPLASH_ConfigServlet", 2, "handleQuickShotShareToStoryConfig version code not changed .");
      }
      return;
    }
    bdiv.x(paramQQAppInterface.getApp(), paramQQAppInterface.c(), j);
    if ((paramConfig.msg_content_list == null) || (paramConfig.msg_content_list.size() < 1) || (paramConfig.msg_content_list.get(0) == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SPLASH_ConfigServlet", 2, "handleQuickShotShareToStoryConfig data is null!!!");
      }
      bdiv.h(paramQQAppInterface.getApp(), paramQQAppInterface.c(), null);
      return;
    }
    paramConfig = (ConfigurationService.Content)paramConfig.msg_content_list.get(0);
    byte[] arrayOfByte;
    if (paramConfig.compress.get() == 1)
    {
      arrayOfByte = avxz.a(paramConfig.content.get().toByteArray());
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
        bdiv.h(paramQQAppInterface.getApp(), paramQQAppInterface.c(), paramConfig);
        ((uhl)paramQQAppInterface.getManager(181)).a(paramConfig);
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
      bdiv.h(paramQQAppInterface.getApp(), paramQQAppInterface.c(), null);
    }
  }
  
  void g(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    int i = bdiv.ac(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
    int j = paramConfig.version.get();
    if ((i != j) && (paramConfig.msg_content_list != null) && (paramConfig.msg_content_list.size() > 0))
    {
      paramConfig = (ConfigurationService.Content)paramConfig.msg_content_list.get(0);
      if (paramConfig != null)
      {
        if (paramConfig.compress.get() != 1) {
          break label219;
        }
        paramConfig = avxz.a(paramConfig.content.get().toByteArray());
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
          bdiv.m(paramQQAppInterface.getApp(), "wifiAutoPreDown", "" + bool1);
          bdiv.m(paramQQAppInterface.getApp(), "noSafeDown", "" + bool2);
          bdiv.C(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, j);
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
    int i = bdiv.Z(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
    int j = paramConfig.version.get();
    if ((i != j) && (paramConfig.msg_content_list != null) && (paramConfig.msg_content_list.size() > 0))
    {
      paramConfig = (ConfigurationService.Content)paramConfig.msg_content_list.get(0);
      if (paramConfig != null)
      {
        if (paramConfig.compress.get() != 1) {
          break label206;
        }
        paramConfig = avxz.a(paramConfig.content.get().toByteArray());
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
          bdiv.k(paramQQAppInterface.getApp(), "url", paramConfig);
          bdiv.k(paramQQAppInterface.getApp(), "thxWord", (String)localObject);
          bdiv.k(paramQQAppInterface.getApp(), "wantWord", str);
          bdiv.B(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, j);
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
        i = bdiv.ad(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
        j = paramConfig.version.get();
      } while ((i == j) || (paramConfig.msg_content_list == null) || (paramConfig.msg_content_list.size() <= 0));
      paramConfig = (ConfigurationService.Content)paramConfig.msg_content_list.get(0);
    } while (paramConfig == null);
    if (paramConfig.compress.get() == 1)
    {
      paramConfig = avxz.a(paramConfig.content.get().toByteArray());
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
          bdiv.D(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, j);
          bdiv.e(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, bool);
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
          int k = swy.c(paramQQAppInterface);
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
                  localObject = avxz.a(((ConfigurationService.Content)localObject).content.get().toByteArray());
                  if (localObject == null) {
                    break label310;
                  }
                  try
                  {
                    localObject = new String((byte[])localObject, "UTF-8");
                    if (QLog.isColorLevel()) {
                      QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 184, version:" + paramConfig.version.get() + ", content:" + (String)localObject);
                    }
                    swy.a(paramQQAppInterface, (String)localObject, j);
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
    //   1: getfield 2579	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:type	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   4: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   7: sipush 191
    //   10: if_icmpeq +4 -> 14
    //   13: return
    //   14: aload_1
    //   15: invokevirtual 65	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   18: getstatic 15	aova:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   21: invokestatic 1950	bdiv:aq	(Landroid/content/Context;Ljava/lang/String;)I
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
    //   56: ldc_w 5638
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
    //   127: invokestatic 321	avxz:a	([B)[B
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
    //   167: ldc_w 5640
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
    //   200: invokevirtual 5641	org/json/JSONObject:length	()I
    //   203: ifle -190 -> 13
    //   206: new 1125	java/util/ArrayList
    //   209: dup
    //   210: invokespecial 1126	java/util/ArrayList:<init>	()V
    //   213: astore_2
    //   214: aload 5
    //   216: invokevirtual 5644	org/json/JSONObject:keys	()Ljava/util/Iterator;
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
    //   252: new 5173	com/tencent/mobileqq/data/AppGuideTipsConfig
    //   255: dup
    //   256: invokespecial 5174	com/tencent/mobileqq/data/AppGuideTipsConfig:<init>	()V
    //   259: astore 9
    //   261: aload 9
    //   263: aload 7
    //   265: putfield 5647	com/tencent/mobileqq/data/AppGuideTipsConfig:tipsType	Ljava/lang/String;
    //   268: aload 9
    //   270: aload 8
    //   272: ldc_w 5182
    //   275: invokevirtual 420	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   278: putfield 5185	com/tencent/mobileqq/data/AppGuideTipsConfig:switchKey	Ljava/lang/String;
    //   281: aload 9
    //   283: aload 8
    //   285: ldc_w 5187
    //   288: invokevirtual 420	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   291: invokestatic 4406	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   294: invokevirtual 1829	java/lang/Integer:intValue	()I
    //   297: putfield 5190	com/tencent/mobileqq/data/AppGuideTipsConfig:maxCount	I
    //   300: aload 9
    //   302: aload 8
    //   304: ldc_w 5192
    //   307: invokevirtual 420	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   310: invokestatic 5111	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   313: invokevirtual 5114	java/lang/Long:longValue	()J
    //   316: putfield 5194	com/tencent/mobileqq/data/AppGuideTipsConfig:duration	J
    //   319: aload 9
    //   321: aload 8
    //   323: ldc_w 779
    //   326: invokevirtual 420	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   329: putfield 5199	com/tencent/mobileqq/data/AppGuideTipsConfig:tipsUrl	Ljava/lang/String;
    //   332: aload 9
    //   334: aload 8
    //   336: ldc_w 5649
    //   339: invokevirtual 420	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   342: putfield 5651	com/tencent/mobileqq/data/AppGuideTipsConfig:opkey	Ljava/lang/String;
    //   345: aload 9
    //   347: aload 8
    //   349: ldc_w 5204
    //   352: invokevirtual 420	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   355: putfield 5207	com/tencent/mobileqq/data/AppGuideTipsConfig:msgTypeStr	Ljava/lang/String;
    //   358: ldc_w 622
    //   361: aload 7
    //   363: invokevirtual 620	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   366: ifeq +143 -> 509
    //   369: aload 8
    //   371: ldc_w 1025
    //   374: invokevirtual 405	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   377: ifeq +100 -> 477
    //   380: aload 9
    //   382: aload 8
    //   384: ldc_w 1025
    //   387: invokevirtual 420	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   390: putfield 5202	com/tencent/mobileqq/data/AppGuideTipsConfig:tipsMsg	Ljava/lang/String;
    //   393: aload 8
    //   395: ldc_w 734
    //   398: invokevirtual 405	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   401: ifeq +92 -> 493
    //   404: aload 9
    //   406: aload 8
    //   408: ldc_w 734
    //   411: invokevirtual 420	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   414: putfield 5654	com/tencent/mobileqq/data/AppGuideTipsConfig:tipsHighLight	Ljava/lang/String;
    //   417: aload_2
    //   418: aload 9
    //   420: invokeinterface 1135 2 0
    //   425: pop
    //   426: goto -205 -> 221
    //   429: astore_1
    //   430: ldc 183
    //   432: iconst_1
    //   433: new 85	java/lang/StringBuilder
    //   436: dup
    //   437: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   440: ldc_w 5656
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
    //   481: ldc_w 5658
    //   484: invokevirtual 420	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   487: putfield 5202	com/tencent/mobileqq/data/AppGuideTipsConfig:tipsMsg	Ljava/lang/String;
    //   490: goto -97 -> 393
    //   493: aload 9
    //   495: aload 8
    //   497: ldc_w 5660
    //   500: invokevirtual 420	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   503: putfield 5654	com/tencent/mobileqq/data/AppGuideTipsConfig:tipsHighLight	Ljava/lang/String;
    //   506: goto -89 -> 417
    //   509: aload 9
    //   511: aload 8
    //   513: ldc_w 5658
    //   516: invokevirtual 420	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   519: putfield 5202	com/tencent/mobileqq/data/AppGuideTipsConfig:tipsMsg	Ljava/lang/String;
    //   522: aload 9
    //   524: aload 8
    //   526: ldc_w 5660
    //   529: invokevirtual 420	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   532: putfield 5654	com/tencent/mobileqq/data/AppGuideTipsConfig:tipsHighLight	Ljava/lang/String;
    //   535: goto -118 -> 417
    //   538: aload_1
    //   539: sipush 218
    //   542: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   545: checkcast 3337	aeky
    //   548: astore 5
    //   550: aload 5
    //   552: aload_2
    //   553: invokevirtual 5661	aeky:a	(Ljava/util/List;)V
    //   556: aload 5
    //   558: invokevirtual 3338	aeky:a	()V
    //   561: aload_1
    //   562: invokevirtual 65	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   565: getstatic 15	aova:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   568: iload 4
    //   570: invokestatic 5663	bdiv:O	(Landroid/content/Context;Ljava/lang/String;I)V
    //   573: return
    //   574: aconst_null
    //   575: astore_2
    //   576: goto -429 -> 147
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	579	0	this	aova
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
    int i = bdiv.ab(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
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
        paramConfig = avxz.a(paramConfig.content.get().toByteArray());
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
        bdiv.A(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, j);
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
          i = bdiv.ai(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
          j = paramConfig.version.get();
          if (QLog.isColorLevel()) {
            QLog.d("DoutuSPLASH_ConfigServlet", 2, "handleDoutuConfig reqVersion = " + i + ", version=" + j);
          }
        } while (i == j);
        bdiv.J(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, j);
      } while ((paramConfig.msg_content_list == null) || (paramConfig.msg_content_list.size() <= 0));
      paramConfig = (ConfigurationService.Content)paramConfig.msg_content_list.get(0);
    } while (paramConfig == null);
    if (paramConfig.compress.get() == 1)
    {
      paramConfig = avxz.a(paramConfig.content.get().toByteArray());
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
            bdiv.g((Context)localObject, str2, bool1);
            bdiv.b(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, l1);
            bdiv.N(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, j);
            localObject = paramQQAppInterface.getApp();
            str2 = jdField_a_of_type_JavaLangString;
            if (k != 1) {
              break label1224;
            }
            bool1 = true;
            bdiv.i((Context)localObject, str2, bool1);
            localObject = paramQQAppInterface.getApp();
            str2 = jdField_a_of_type_JavaLangString;
            if (m != 1) {
              break label1230;
            }
            bool1 = true;
            bdiv.j((Context)localObject, str2, bool1);
            if (paramConfig != null) {
              bdiv.o(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, paramConfig);
            }
            if (str1 != null) {
              bdiv.p(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, str1);
            }
            bdiv.c(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, l2);
            bdiv.d(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, l3);
            bdiv.L(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, n);
            paramQQAppInterface = (apfp)getAppRuntime().getManager(214);
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
        bdiv.k(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
        bdiv.r(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
        bdiv.l(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
        bdiv.m(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
        bdiv.o(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
        bdiv.p(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
        bdiv.t(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
        bdiv.u(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
        bdiv.n(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
        bdiv.m(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
        bdiv.s(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
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
          i = bdiv.t(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
          j = paramConfig.version.get();
          if (QLog.isColorLevel()) {
            QLog.d("GreenVideoSPLASH_ConfigServlet", 2, "handleGreenVideoConfig reqVersion = " + i + ", version=" + j);
          }
        } while (i == j);
        bdiv.f(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, j);
      } while ((paramConfig.msg_content_list == null) || (paramConfig.msg_content_list.size() <= 0));
      paramConfig = (ConfigurationService.Content)paramConfig.msg_content_list.get(0);
    } while (paramConfig == null);
    if (paramConfig.compress.get() == 1)
    {
      paramConfig = avxz.a(paramConfig.content.get().toByteArray());
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
        bdiv.e(paramQQAppInterface.getApp(), paramConfig);
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
      bdiv.a(paramQQAppInterface.getApp());
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
    //   1: getfield 2579	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:type	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   4: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   7: sipush 272
    //   10: if_icmpeq +4 -> 14
    //   13: return
    //   14: aload_1
    //   15: invokevirtual 65	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   18: getstatic 15	aova:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   21: invokestatic 1917	bdiv:v	(Landroid/content/Context;Ljava/lang/String;)I
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
    //   50: ldc_w 5793
    //   53: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: iload_3
    //   57: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   60: ldc_w 5697
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
    //   87: getstatic 15	aova:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   90: iload 4
    //   92: invokestatic 1906	bdiv:h	(Landroid/content/Context;Ljava/lang/String;I)V
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
    //   149: invokestatic 321	avxz:a	([B)[B
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
    //   189: ldc_w 5795
    //   192: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   195: aload_2
    //   196: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   199: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   202: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   205: invokestatic 913	javax/xml/parsers/DocumentBuilderFactory:newInstance	()Ljavax/xml/parsers/DocumentBuilderFactory;
    //   208: invokevirtual 917	javax/xml/parsers/DocumentBuilderFactory:newDocumentBuilder	()Ljavax/xml/parsers/DocumentBuilder;
    //   211: new 919	java/io/ByteArrayInputStream
    //   214: dup
    //   215: aload_2
    //   216: ldc_w 921
    //   219: invokevirtual 925	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   222: invokespecial 926	java/io/ByteArrayInputStream:<init>	([B)V
    //   225: invokevirtual 931	javax/xml/parsers/DocumentBuilder:parse	(Ljava/io/InputStream;)Lorg/w3c/dom/Document;
    //   228: astore_2
    //   229: aload_2
    //   230: ldc_w 5797
    //   233: invokeinterface 939 2 0
    //   238: astore 5
    //   240: aload 5
    //   242: ifnull -229 -> 13
    //   245: aload 5
    //   247: invokeinterface 944 1 0
    //   252: ifle -239 -> 13
    //   255: new 85	java/lang/StringBuilder
    //   258: dup
    //   259: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   262: astore 5
    //   264: aload_2
    //   265: ldc_w 5799
    //   268: invokeinterface 939 2 0
    //   273: ifnull +42 -> 315
    //   276: aload 5
    //   278: aload_2
    //   279: ldc_w 5799
    //   282: invokeinterface 939 2 0
    //   287: iconst_0
    //   288: invokeinterface 950 2 0
    //   293: invokeinterface 956 1 0
    //   298: invokeinterface 959 1 0
    //   303: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   306: pop
    //   307: aload 5
    //   309: bipush 124
    //   311: invokevirtual 1057	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   314: pop
    //   315: aload_2
    //   316: ldc_w 5801
    //   319: invokeinterface 939 2 0
    //   324: ifnull +42 -> 366
    //   327: aload 5
    //   329: aload_2
    //   330: ldc_w 5801
    //   333: invokeinterface 939 2 0
    //   338: iconst_0
    //   339: invokeinterface 950 2 0
    //   344: invokeinterface 956 1 0
    //   349: invokeinterface 959 1 0
    //   354: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   357: pop
    //   358: aload 5
    //   360: bipush 124
    //   362: invokevirtual 1057	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   365: pop
    //   366: aload_2
    //   367: ldc_w 5803
    //   370: invokeinterface 939 2 0
    //   375: ifnull +42 -> 417
    //   378: aload 5
    //   380: aload_2
    //   381: ldc_w 5803
    //   384: invokeinterface 939 2 0
    //   389: iconst_0
    //   390: invokeinterface 950 2 0
    //   395: invokeinterface 956 1 0
    //   400: invokeinterface 959 1 0
    //   405: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   408: pop
    //   409: aload 5
    //   411: bipush 124
    //   413: invokevirtual 1057	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   416: pop
    //   417: aload_2
    //   418: ldc_w 5805
    //   421: invokeinterface 939 2 0
    //   426: ifnull +42 -> 468
    //   429: aload 5
    //   431: aload_2
    //   432: ldc_w 5805
    //   435: invokeinterface 939 2 0
    //   440: iconst_0
    //   441: invokeinterface 950 2 0
    //   446: invokeinterface 956 1 0
    //   451: invokeinterface 959 1 0
    //   456: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   459: pop
    //   460: aload 5
    //   462: bipush 124
    //   464: invokevirtual 1057	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   467: pop
    //   468: aload_2
    //   469: ldc_w 5807
    //   472: invokeinterface 939 2 0
    //   477: ifnull +42 -> 519
    //   480: aload 5
    //   482: aload_2
    //   483: ldc_w 5807
    //   486: invokeinterface 939 2 0
    //   491: iconst_0
    //   492: invokeinterface 950 2 0
    //   497: invokeinterface 956 1 0
    //   502: invokeinterface 959 1 0
    //   507: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   510: pop
    //   511: aload 5
    //   513: bipush 124
    //   515: invokevirtual 1057	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   518: pop
    //   519: aload_2
    //   520: ldc_w 5809
    //   523: invokeinterface 939 2 0
    //   528: ifnull +60 -> 588
    //   531: aload_2
    //   532: ldc_w 5809
    //   535: invokeinterface 939 2 0
    //   540: iconst_0
    //   541: invokeinterface 950 2 0
    //   546: ifnull +42 -> 588
    //   549: aload 5
    //   551: aload_2
    //   552: ldc_w 5809
    //   555: invokeinterface 939 2 0
    //   560: iconst_0
    //   561: invokeinterface 950 2 0
    //   566: invokeinterface 956 1 0
    //   571: invokeinterface 959 1 0
    //   576: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   579: pop
    //   580: aload 5
    //   582: bipush 124
    //   584: invokevirtual 1057	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   587: pop
    //   588: aload_2
    //   589: ldc_w 5811
    //   592: invokeinterface 939 2 0
    //   597: ifnull +60 -> 657
    //   600: aload_2
    //   601: ldc_w 5811
    //   604: invokeinterface 939 2 0
    //   609: iconst_0
    //   610: invokeinterface 950 2 0
    //   615: ifnull +42 -> 657
    //   618: aload 5
    //   620: aload_2
    //   621: ldc_w 5811
    //   624: invokeinterface 939 2 0
    //   629: iconst_0
    //   630: invokeinterface 950 2 0
    //   635: invokeinterface 956 1 0
    //   640: invokeinterface 959 1 0
    //   645: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   648: pop
    //   649: aload 5
    //   651: bipush 124
    //   653: invokevirtual 1057	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   656: pop
    //   657: aload_2
    //   658: ldc_w 5813
    //   661: invokeinterface 939 2 0
    //   666: ifnull +60 -> 726
    //   669: aload_2
    //   670: ldc_w 5813
    //   673: invokeinterface 939 2 0
    //   678: iconst_0
    //   679: invokeinterface 950 2 0
    //   684: ifnull +42 -> 726
    //   687: aload 5
    //   689: aload_2
    //   690: ldc_w 5813
    //   693: invokeinterface 939 2 0
    //   698: iconst_0
    //   699: invokeinterface 950 2 0
    //   704: invokeinterface 956 1 0
    //   709: invokeinterface 959 1 0
    //   714: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   717: pop
    //   718: aload 5
    //   720: bipush 124
    //   722: invokevirtual 1057	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   725: pop
    //   726: aload_2
    //   727: ldc_w 5815
    //   730: invokeinterface 939 2 0
    //   735: ifnull +52 -> 787
    //   738: aload_2
    //   739: ldc_w 5815
    //   742: invokeinterface 939 2 0
    //   747: iconst_0
    //   748: invokeinterface 950 2 0
    //   753: ifnull +34 -> 787
    //   756: aload 5
    //   758: aload_2
    //   759: ldc_w 5815
    //   762: invokeinterface 939 2 0
    //   767: iconst_0
    //   768: invokeinterface 950 2 0
    //   773: invokeinterface 956 1 0
    //   778: invokeinterface 959 1 0
    //   783: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   786: pop
    //   787: aload_1
    //   788: invokevirtual 65	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   791: getstatic 15	aova:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   794: aload 5
    //   796: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   799: invokestatic 5817	bdiv:q	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    //   802: return
    //   803: astore_1
    //   804: ldc 183
    //   806: iconst_1
    //   807: new 85	java/lang/StringBuilder
    //   810: dup
    //   811: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   814: ldc_w 5819
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
    //   841: ldc_w 5821
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
    //   875: ldc_w 5823
    //   878: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   881: aload_1
    //   882: invokevirtual 65	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   885: getstatic 15	aova:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   888: invokestatic 5825	bdiv:q	(Landroid/content/Context;Ljava/lang/String;)V
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
    //   0	941	0	this	aova
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
        aove.a("0", arrayOfInt, paramFromServiceMsg.getResultCode());
        aziy.a(arrayOfInt, paramFromServiceMsg);
        int k = arrayOfInt.length;
        i = j;
        while (i < k)
        {
          if (arrayOfInt[i] == 215)
          {
            ShortVideoResourceManager.a(-5);
            blfg.d("SPLASH_ConfigServlet", "【SHORT_VIDEO_RESOURCE_CONFIG】RES_OVERTIME");
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
            aars.a(((ConfigurationService.RespGetConfig)localObject).min_req_interval_for_reconnect.get());
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
    //   1: invokestatic 1936	azwd:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)I
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
    //   30: ldc_w 5891
    //   33: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: iload 4
    //   38: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   41: ldc_w 5893
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
    //   69: checkcast 1935	azwd
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
    //   128: invokestatic 321	avxz:a	([B)[B
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
    //   160: ldc_w 5895
    //   163: invokevirtual 408	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   166: istore 4
    //   168: aload 5
    //   170: iload 4
    //   172: invokevirtual 5896	azwd:a	(I)V
    //   175: ldc 183
    //   177: iconst_1
    //   178: new 85	java/lang/StringBuilder
    //   181: dup
    //   182: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   185: ldc_w 5898
    //   188: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   191: aload_2
    //   192: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   195: ldc_w 5900
    //   198: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   201: iload 4
    //   203: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   206: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   209: invokestatic 199	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   212: aload_1
    //   213: iload_3
    //   214: invokestatic 5901	azwd:a	(Lcom/tencent/mobileqq/app/QQAppInterface;I)V
    //   217: return
    //   218: astore_2
    //   219: ldc 183
    //   221: iconst_1
    //   222: new 85	java/lang/StringBuilder
    //   225: dup
    //   226: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   229: ldc_w 5903
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
    //   275: ldc_w 5905
    //   278: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   281: aload_2
    //   282: invokevirtual 798	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   285: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   288: invokestatic 642	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   291: goto -79 -> 212
    //   294: ldc 183
    //   296: iconst_1
    //   297: ldc_w 5907
    //   300: invokestatic 199	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   303: aload 5
    //   305: iconst_0
    //   306: invokevirtual 5896	azwd:a	(I)V
    //   309: goto -97 -> 212
    //   312: aconst_null
    //   313: astore_2
    //   314: goto -166 -> 148
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	317	0	this	aova
    //   0	317	1	paramQQAppInterface	QQAppInterface
    //   0	317	2	paramConfig	ConfigurationService.Config
    //   13	201	3	i	int
    //   4	198	4	j	int
    //   72	232	5	localazwd	azwd
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
    //   3: getstatic 15	aova:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   6: ldc_w 1926
    //   9: iconst_0
    //   10: invokestatic 305	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   13: invokestatic 1924	aush:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   16: checkcast 139	java/lang/Integer
    //   19: invokevirtual 1829	java/lang/Integer:intValue	()I
    //   22: istore 5
    //   24: aload_2
    //   25: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   28: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   31: istore 6
    //   33: new 85	java/lang/StringBuilder
    //   36: dup
    //   37: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   40: ldc_w 5909
    //   43: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: iload 5
    //   48: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   51: ldc_w 5893
    //   54: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: iload 6
    //   59: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   62: ldc_w 5911
    //   65: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: astore 7
    //   70: aload_2
    //   71: getfield 221	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   74: ifnonnull +109 -> 183
    //   77: iconst_0
    //   78: istore_3
    //   79: ldc_w 5913
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
    //   133: ldc_w 5913
    //   136: iconst_1
    //   137: new 85	java/lang/StringBuilder
    //   140: dup
    //   141: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   144: ldc_w 5915
    //   147: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: aload_2
    //   151: getfield 221	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   154: iload_3
    //   155: invokevirtual 318	com/tencent/mobileqq/pb/PBRepeatMessageField:get	(I)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   158: checkcast 244	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content
    //   161: getfield 3872	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content:task_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
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
    //   235: invokestatic 321	avxz:a	([B)[B
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
    //   270: ldc_w 5913
    //   273: iconst_1
    //   274: new 85	java/lang/StringBuilder
    //   277: dup
    //   278: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   281: ldc_w 5917
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
    //   311: ldc_w 5919
    //   314: invokevirtual 5922	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   317: astore 8
    //   319: aload 8
    //   321: invokevirtual 520	org/json/JSONArray:length	()I
    //   324: ifle +18 -> 342
    //   327: getstatic 15	aova:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   330: ldc_w 5924
    //   333: aload 8
    //   335: invokevirtual 5925	org/json/JSONArray:toString	()Ljava/lang/String;
    //   338: invokestatic 1929	aush:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)Z
    //   341: pop
    //   342: aload 7
    //   344: ldc_w 5927
    //   347: invokevirtual 732	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   350: astore 8
    //   352: aload 8
    //   354: ifnull +18 -> 372
    //   357: getstatic 15	aova:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   360: ldc_w 5929
    //   363: aload 8
    //   365: invokevirtual 5930	org/json/JSONObject:toString	()Ljava/lang/String;
    //   368: invokestatic 1929	aush:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)Z
    //   371: pop
    //   372: aload 7
    //   374: ldc_w 5932
    //   377: invokevirtual 474	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   380: istore_3
    //   381: aload 8
    //   383: ifnull +17 -> 400
    //   386: getstatic 15	aova:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   389: ldc_w 5934
    //   392: iload_3
    //   393: invokestatic 305	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   396: invokestatic 1929	aush:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)Z
    //   399: pop
    //   400: aload 7
    //   402: ldc_w 5936
    //   405: invokevirtual 732	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   408: astore 8
    //   410: aload 8
    //   412: ifnull +76 -> 488
    //   415: aload 8
    //   417: ldc_w 5938
    //   420: invokevirtual 474	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   423: istore_3
    //   424: aload 8
    //   426: ldc_w 5940
    //   429: invokevirtual 474	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   432: istore 4
    //   434: aload 8
    //   436: ldc_w 5942
    //   439: invokevirtual 474	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   442: istore 5
    //   444: getstatic 15	aova:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   447: ldc_w 5944
    //   450: iload_3
    //   451: invokestatic 305	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   454: invokestatic 1929	aush:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)Z
    //   457: pop
    //   458: getstatic 15	aova:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   461: ldc_w 5946
    //   464: iload 4
    //   466: invokestatic 305	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   469: invokestatic 1929	aush:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)Z
    //   472: pop
    //   473: getstatic 15	aova:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   476: ldc_w 5948
    //   479: iload 5
    //   481: invokestatic 305	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   484: invokestatic 1929	aush:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)Z
    //   487: pop
    //   488: aload 7
    //   490: ldc_w 5950
    //   493: invokevirtual 5922	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   496: astore 8
    //   498: aload 8
    //   500: ifnull +273 -> 773
    //   503: getstatic 15	aova:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   506: ldc_w 5952
    //   509: aload 8
    //   511: invokevirtual 5925	org/json/JSONArray:toString	()Ljava/lang/String;
    //   514: invokestatic 1929	aush:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)Z
    //   517: pop
    //   518: getstatic 15	aova:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   521: ldc_w 1926
    //   524: aload_2
    //   525: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   528: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   531: invokestatic 305	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   534: invokestatic 1929	aush:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)Z
    //   537: pop
    //   538: aload 7
    //   540: ldc_w 5954
    //   543: iconst_0
    //   544: invokevirtual 2286	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   547: istore_3
    //   548: aload 7
    //   550: ldc_w 5956
    //   553: iconst_m1
    //   554: invokevirtual 2286	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   557: istore 4
    //   559: aload 7
    //   561: ldc_w 5958
    //   564: iconst_0
    //   565: invokevirtual 2286	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   568: istore 5
    //   570: aload 7
    //   572: ldc_w 5960
    //   575: iconst_0
    //   576: invokevirtual 2286	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   579: istore 6
    //   581: aload 7
    //   583: ldc_w 5962
    //   586: invokevirtual 137	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   589: astore_2
    //   590: getstatic 15	aova:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   593: ldc_w 5954
    //   596: iload_3
    //   597: invokestatic 305	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   600: invokestatic 1929	aush:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)Z
    //   603: pop
    //   604: getstatic 15	aova:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   607: ldc_w 5956
    //   610: iload 4
    //   612: invokestatic 305	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   615: invokestatic 1929	aush:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)Z
    //   618: pop
    //   619: getstatic 15	aova:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   622: ldc_w 5958
    //   625: iload 5
    //   627: invokestatic 305	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   630: invokestatic 1929	aush:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)Z
    //   633: pop
    //   634: getstatic 15	aova:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   637: ldc_w 5960
    //   640: iload 6
    //   642: invokestatic 305	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   645: invokestatic 1929	aush:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)Z
    //   648: pop
    //   649: getstatic 15	aova:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   652: ldc_w 5964
    //   655: aload_2
    //   656: invokestatic 1929	aush:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)Z
    //   659: pop
    //   660: aload 7
    //   662: ldc_w 5966
    //   665: invokevirtual 474	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   668: istore_3
    //   669: getstatic 15	aova:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   672: ldc_w 5966
    //   675: iload_3
    //   676: invokestatic 305	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   679: invokestatic 1929	aush:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)Z
    //   682: pop
    //   683: aload 7
    //   685: ldc_w 5968
    //   688: invokevirtual 732	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   691: astore_2
    //   692: aload_2
    //   693: ifnull +17 -> 710
    //   696: getstatic 15	aova:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   699: ldc_w 5970
    //   702: aload_2
    //   703: invokevirtual 5930	org/json/JSONObject:toString	()Ljava/lang/String;
    //   706: invokestatic 1929	aush:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)Z
    //   709: pop
    //   710: aload_1
    //   711: ldc_w 5972
    //   714: iconst_1
    //   715: iconst_1
    //   716: aconst_null
    //   717: invokevirtual 5976	com/tencent/mobileqq/app/QQAppInterface:notifyObservers	(Ljava/lang/Class;IZLandroid/os/Bundle;)V
    //   720: return
    //   721: astore 7
    //   723: ldc_w 5913
    //   726: iconst_1
    //   727: new 85	java/lang/StringBuilder
    //   730: dup
    //   731: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   734: ldc_w 5978
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
    //   773: getstatic 15	aova:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   776: ldc_w 5952
    //   779: ldc 13
    //   781: invokestatic 1929	aush:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)Z
    //   784: pop
    //   785: goto -267 -> 518
    //   788: astore_1
    //   789: ldc_w 5913
    //   792: iconst_1
    //   793: new 85	java/lang/StringBuilder
    //   796: dup
    //   797: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   800: ldc_w 5980
    //   803: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   806: aload_1
    //   807: invokevirtual 798	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   810: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   813: invokestatic 642	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   816: return
    //   817: astore_1
    //   818: ldc_w 5913
    //   821: iconst_1
    //   822: ldc_w 5982
    //   825: aload_1
    //   826: invokestatic 188	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   829: return
    //   830: aconst_null
    //   831: astore 7
    //   833: goto -574 -> 259
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	836	0	this	aova
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
    int i = bdiv.ag(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
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
          arrayOfByte = avxz.a(paramConfig.content.get().toByteArray());
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
        bdiv.n(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, paramConfig);
        bdiv.G(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, j);
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
    //   9: ldc_w 6002
    //   12: iconst_1
    //   13: ldc_w 6004
    //   16: iconst_0
    //   17: anewarray 301	java/lang/Object
    //   20: invokestatic 309	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   23: invokestatic 199	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   26: aload_1
    //   27: invokevirtual 65	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   30: getstatic 15	aova:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   33: invokestatic 1945	aggh:a	(Landroid/content/Context;Ljava/lang/String;)I
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
    //   89: invokevirtual 1130	com/tencent/mobileqq/pb/PBBytesField:has	()Z
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
    //   116: invokestatic 321	avxz:a	([B)[B
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
    //   150: ldc_w 6002
    //   153: iconst_1
    //   154: new 85	java/lang/StringBuilder
    //   157: dup
    //   158: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   161: ldc_w 6006
    //   164: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   167: aload_2
    //   168: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   174: invokestatic 199	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   177: aload 9
    //   179: ldc_w 6008
    //   182: invokevirtual 408	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   185: istore_3
    //   186: aload 9
    //   188: ldc_w 6010
    //   191: invokevirtual 408	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   194: istore 4
    //   196: aload 9
    //   198: ldc_w 6012
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
    //   247: invokevirtual 6013	org/json/JSONArray:get	(I)Ljava/lang/Object;
    //   250: checkcast 128	org/json/JSONObject
    //   253: ldc_w 6015
    //   256: invokevirtual 420	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   259: astore 7
    //   261: aload 7
    //   263: invokestatic 126	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   266: ifne +12 -> 278
    //   269: aload_2
    //   270: aload 7
    //   272: invokeinterface 2859 2 0
    //   277: pop
    //   278: iload 5
    //   280: iconst_1
    //   281: iadd
    //   282: istore 5
    //   284: goto -51 -> 233
    //   287: astore_2
    //   288: ldc_w 6002
    //   291: iconst_1
    //   292: new 85	java/lang/StringBuilder
    //   295: dup
    //   296: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   299: ldc_w 6017
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
    //   341: invokestatic 6020	aggh:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)Laggh;
    //   344: aload_1
    //   345: iload 5
    //   347: iload_3
    //   348: aload_2
    //   349: invokevirtual 6023	aggh:a	(Lcom/tencent/mobileqq/app/QQAppInterface;IILjava/util/Set;)V
    //   352: aload_1
    //   353: invokevirtual 65	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   356: getstatic 15	aova:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   359: iload 6
    //   361: invokestatic 6024	aggh:a	(Landroid/content/Context;Ljava/lang/String;I)V
    //   364: return
    //   365: astore_2
    //   366: iconst_0
    //   367: istore 4
    //   369: iconst_0
    //   370: istore_3
    //   371: ldc_w 6002
    //   374: iconst_1
    //   375: new 85	java/lang/StringBuilder
    //   378: dup
    //   379: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   382: ldc_w 5905
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
    //   408: ldc_w 6002
    //   411: iconst_1
    //   412: ldc_w 6026
    //   415: invokestatic 199	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   418: goto -66 -> 352
    //   421: ldc_w 6002
    //   424: iconst_1
    //   425: ldc_w 6028
    //   428: invokestatic 199	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   431: aload_1
    //   432: invokestatic 6020	aggh:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)Laggh;
    //   435: aload_1
    //   436: iconst_0
    //   437: iconst_0
    //   438: aconst_null
    //   439: invokevirtual 6023	aggh:a	(Lcom/tencent/mobileqq/app/QQAppInterface;IILjava/util/Set;)V
    //   442: goto -90 -> 352
    //   445: ldc_w 6002
    //   448: iconst_1
    //   449: ldc_w 6030
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
    //   0	519	0	this	aova
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
    int i = bdiv.ak(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
    int j = paramConfig.version.get();
    if (i != j) {
      if ((paramConfig.msg_content_list != null) && (paramConfig.msg_content_list.size() > 0))
      {
        paramConfig = (ConfigurationService.Content)paramConfig.msg_content_list.get(0);
        if ((paramConfig != null) && (paramConfig.content.has())) {
          if (paramConfig.compress.get() == 1)
          {
            paramConfig = avxz.a(paramConfig.content.get().toByteArray());
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
        bdiv.I(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, j);
        ((atvg)paramQQAppInterface.getManager(221)).a(paramConfig);
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
      bool = bdem.a(paramQQAppInterface.getApp(), "com.tencent.tim");
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
      ((atwc)paramQQAppInterface.getManager(244)).a();
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
 * Qualified Name:     aova
 * JD-Core Version:    0.7.0.1
 */