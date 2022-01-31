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

public class andt
  extends MSFServlet
{
  public static String a;
  private static final int[] jdField_a_of_type_ArrayOfInt = { 1, 2, 3, 5, 10, 13, 23, 31, 38, 42, 44, 46, 47, 49, 50, 53, 55, 56, 57, 61, 62, 63, 64, 65, 66, 69, 206, 205, 72, 73, 74, 75, 385, 94, 78, 79, 80, 84, 223, 82, 101, 102, 147, 86, 93, 88, 90, 96, 97, 108, 146, 111, 109, 115, 286, 118, 120, 119, 116, 130, 142, 121, 157, 211, 201, 129, 143, 140, 257, 232, 233, 231, 148, 139, 145, 153, 149, 155, 165, 185, 167, 166, 171, 180, 182, 177, 371, 181, 184, 187, 191, 193, 188, 195, 227, 202, 190, 210, 199, 212, 407, sxm.a(2131427352), sxm.a(2131427353), sxm.a(2131427354), sxm.a(2131427349), sxm.a(2131427350), 218, 226, 225, 222, 256, 228, 235, 234, 238, 247, 244, 245, 253, 295, 255, 254, 259, 260, 262, 204, 271, 267, 275, 358, 268, 269, 272, 274, 279, 308, 281, 283, 284, 280, 360, 289, 314, 297, 301, 296, 330, 347, 313, 312, 397, 321, 326, 320, 328, 331, 336, 329, 337, 345, 351, 349, 355, 372, 384, 379, 357, 378, 381, 273, 364, 365, 369, 387, 386, 392, 393, 394, 401, 400, 403, 404, 405, 408, 410, 194, 596 };
  private static String b;
  private boolean jdField_a_of_type_Boolean;
  
  static
  {
    jdField_a_of_type_JavaLangString = "";
    jdField_b_of_type_JavaLangString = ajya.a(2131702431);
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
        j = bbkb.O(localQQAppInterface.getApp(), localQQAppInterface.getAccount());
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
        paramConfig = (astu)localQQAppInterface.getManager(166);
        paramConfig.jdField_b_of_type_Boolean = true;
        paramConfig.c = bool3;
        localQQAppInterface.h = true;
        localQQAppInterface.i = bool4;
        bbkb.b(localQQAppInterface.getApp(), localQQAppInterface.getAccount(), i, bool3, bool4);
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
    bfod localbfod = (bfod)((QQAppInterface)localObject).a(146);
    int i = localbfod.b(BaseApplicationImpl.getContext(), ((QQAppInterface)localObject).getAccount());
    if (localbfod.a(BaseApplicationImpl.getContext(), ((QQAppInterface)localObject).getAccount()) != k) {
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
          paramConfig = localbfod.a(paramConfig.content.get().toByteArray());
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
          localbfod.a(paramConfig, j, k);
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
        localbfod.a(jdField_a_of_type_JavaLangString);
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
    //   1: invokevirtual 47	andt:getAppRuntime	()Lmqq/app/AppRuntime;
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
    //   27: invokestatic 292	bbkb:aT	(Landroid/content/Context;Ljava/lang/String;)I
    //   30: istore_2
    //   31: aload 8
    //   33: invokevirtual 65	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   36: aload 8
    //   38: invokevirtual 69	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   41: invokestatic 295	bbkb:aU	(Landroid/content/Context;Ljava/lang/String;)I
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
    //   123: invokestatic 313	bbkb:z	(Landroid/content/Context;ILjava/lang/String;)V
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
    //   186: invokestatic 321	augv:a	([B)[B
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
    //   272: getstatic 15	andt:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   275: invokestatic 360	bbkb:y	(Landroid/content/Context;ILjava/lang/String;)V
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
    //   0	485	0	this	andt
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
    int j = bbkb.aQ(BaseApplication.getContext(), jdField_a_of_type_JavaLangString);
    if (QLog.isColorLevel()) {
      QLog.i("SPLASH_ConfigServlet", 2, "handleWeiYunMiniAppConfig: ,version: " + paramConfig.version.get() + "| localVersion: " + j);
    }
    if (i != j)
    {
      bbkb.ag(BaseApplication.getContext(), jdField_a_of_type_JavaLangString, i);
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
              bbkb.w(BaseApplication.getContext(), i, paramQQAppInterface.getCurrentAccountUin());
              if (QLog.isColorLevel()) {
                QLog.d("SPLASH_ConfigServlet", 2, "handleWeiYunMiniAppConfig, enableMiniApp = " + i);
              }
            }
            if (((JSONObject)localObject).has("apkgUrl"))
            {
              String str = ((JSONObject)localObject).getString("apkgUrl");
              bbkb.u(BaseApplication.getContext(), str, paramQQAppInterface.getCurrentAccountUin());
              if (QLog.isColorLevel()) {
                QLog.d("SPLASH_ConfigServlet", 2, "handleWeiYunMiniAppConfig, apkgUrl = " + str);
              }
            }
            if (((JSONObject)localObject).has("miniVersion"))
            {
              i = ((JSONObject)localObject).getInt("miniVersion");
              bbkb.x(BaseApplication.getContext(), i, paramQQAppInterface.getCurrentAccountUin());
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
    int j = bbkb.aW(BaseApplication.getContext(), jdField_a_of_type_JavaLangString);
    if (QLog.isColorLevel()) {
      QLog.i("SPLASH_ConfigServlet", 2, "handleAIOConfig: ,version: " + paramConfig.version.get() + "| localVersion: " + j);
    }
    if (i != j)
    {
      bbkb.ai(BaseApplication.getContext(), jdField_a_of_type_JavaLangString, i);
      paramConfig = a(paramConfig);
      if ((paramConfig == null) || (paramConfig.size() <= 0)) {}
    }
    while (!QLog.isColorLevel()) {
      try
      {
        paramConfig = (String)paramConfig.get(paramConfig.size() - 1);
        bbkb.c(BaseApplication.getContext(), jdField_a_of_type_JavaLangString, "aio_config_key", paramConfig);
        acsx.a(paramQQAppInterface);
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
    int j = bbkb.aX(BaseApplication.getContext(), jdField_a_of_type_JavaLangString);
    if (QLog.isColorLevel()) {
      QLog.i("SPLASH_ConfigServlet", 2, "handleMultiMsgConfig: ,version: " + paramConfig.version.get() + "| localVersion: " + j);
    }
    if (i != j)
    {
      bbkb.aj(BaseApplication.getContext(), jdField_a_of_type_JavaLangString, i);
      paramConfig = a(paramConfig);
      if ((paramConfig == null) || (paramConfig.size() <= 0)) {}
    }
    while (!QLog.isColorLevel()) {
      try
      {
        i = new JSONObject((String)paramConfig.get(paramConfig.size() - 1)).optInt("max_multimsg_totalcount");
        bbkb.g(BaseApplication.getContext(), jdField_a_of_type_JavaLangString, "multimsg_config", i);
        if (QLog.isColorLevel()) {
          QLog.i("SPLASH_ConfigServlet", 2, "handleMultiMsgConfig:limitTotal =  " + i);
        }
        asua.a().a(paramQQAppInterface);
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
    int j = bbkb.ay(BaseApplication.getContext(), jdField_a_of_type_JavaLangString);
    if (QLog.isColorLevel()) {
      QLog.i("SPLASH_ConfigServlet", 2, "handleConversationPublicAccConfig: ,version: " + paramConfig.version.get() + "| localVersion: " + j);
    }
    if (i != j)
    {
      bbkb.T(BaseApplication.getContext(), jdField_a_of_type_JavaLangString, i);
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
            localObject3 = ahou.a();
            if (i == 1)
            {
              bool = true;
              ((ahou)localObject3).a(paramQQAppInterface, bool);
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
        ahou.a().a(paramQQAppInterface, false);
        continue;
        if (QLog.isColorLevel()) {
          QLog.i("SPLASH_ConfigServlet", 2, "handleConversationPublicAccConfig  error =" + localJSONException1.getMessage());
        }
        ahou.a().a(paramQQAppInterface, false);
        ahou.a().a(paramQQAppInterface, null);
      }
    }
    label406:
    label417:
    label443:
    label444:
    for (;;)
    {
      break;
      ahou.a().a(paramQQAppInterface, localJSONException1);
      paramConfig = localJSONException1;
      continue;
      Object localObject2;
      ahou.a().a(paramQQAppInterface, paramConfig);
      break label444;
      ahou.a().a(paramQQAppInterface, paramConfig);
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
    int j = bbkb.a();
    if (QLog.isColorLevel()) {
      QLog.i("SPLASH_ConfigServlet", 2, "handleBeancurdConfig: ,version: " + paramConfig.version.get() + "| localVersion: " + j);
    }
    if (i != j)
    {
      bbkb.a(i);
      paramConfig = a(paramConfig);
      if ((paramConfig != null) && (paramConfig.size() > 0))
      {
        paramConfig = (String)paramConfig.get(paramConfig.size() - 1);
        if (QLog.isColorLevel()) {
          QLog.i("SPLASH_ConfigServlet", 2, "handleBeancurdConfigStr: " + paramConfig);
        }
        bbkb.b(paramConfig);
        ((acuo)paramQQAppInterface.getManager(282)).a(paramConfig);
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
    int j = bbkb.ax(BaseApplication.getContext(), jdField_a_of_type_JavaLangString);
    if (QLog.isColorLevel()) {
      QLog.i("SPLASH_ConfigServlet", 2, "handleZhituConfig: ,version: " + paramConfig.version.get() + "| localVersion: " + j);
    }
    if (i != j)
    {
      bbkb.S(BaseApplication.getContext(), jdField_a_of_type_JavaLangString, i);
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
              aezl localaezl;
              if (((JSONObject)localObject).has("kMarioConfigEnable"))
              {
                i = ((JSONObject)localObject).getInt("kMarioConfigEnable");
                localaezl = aezl.a(paramQQAppInterface);
                if (i != 1) {
                  break label324;
                }
                bool = true;
                localaezl.a(bool);
              }
              if (((JSONObject)localObject).has("kMarioPageLen"))
              {
                i = ((JSONObject)localObject).getInt("kMarioPageLen");
                aezl.a(paramQQAppInterface).b(i);
              }
              if (((JSONObject)localObject).has("kMarioSaveAndShareEnable"))
              {
                i = ((JSONObject)localObject).getInt("kMarioSaveAndShareEnable");
                localaezl = aezl.a(paramQQAppInterface);
                if (i != 1) {
                  break label330;
                }
                bool = true;
                localaezl.b(bool);
              }
              if (!((JSONObject)localObject).has("kMarioSafeGateRequestInterval")) {
                break;
              }
              i = ((JSONObject)localObject).getInt("kMarioSafeGateRequestInterval");
              aezl.a(paramQQAppInterface).a(i);
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
    a(paramQQAppInterface, paramConfig, "handleShortVideoMsgTailConfig", new andu(this, paramQQAppInterface));
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
            if ((j == bbkb.a(paramQQAppInterface.getApp(), "readinjoy_interested_push_config", jdField_a_of_type_JavaLangString)) || (TextUtils.isEmpty((CharSequence)localObject))) {
              break label412;
            }
            localObject = ((String)localObject).split("=");
            if (localObject.length >= 2)
            {
              if (!"xqh_insert_into_feeds".equals(localObject[0])) {
                continue;
              }
              bhvy.c(paramQQAppInterface, "1".equals(localObject[1]));
              if (QLog.isColorLevel()) {
                QLog.d("SPLASH_ConfigServlet", 2, "update KANDIAN_INTERESTED_PUSH_CONFiG config , switch : " + "1".equals(localObject[1]));
              }
            }
            bbkb.a(paramQQAppInterface.getApp(), "readinjoy_interested_push_config", jdField_a_of_type_JavaLangString, j);
            break label469;
            if ("simple_switch_fm".equals(localObject[0]))
            {
              bhvy.c(paramQQAppInterface, "1".equals(localObject[1]));
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
        oyy.a(paramQQAppInterface, "1".equals(localObject[1]));
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
            if (k != bbkb.a(paramQQAppInterface.getApp(), "now_entrance_action_version", jdField_a_of_type_JavaLangString))
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
                    bbkb.c(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin(), localJSONObject.optInt("bid"), localJSONObject.optInt("actionType"));
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
                  bbkb.a(paramQQAppInterface.getApp(), "now_entrance_action_version", jdField_a_of_type_JavaLangString, k);
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
            if (j == bbkb.a(paramQQAppInterface.getApp(), "troop_common_config_version", jdField_a_of_type_JavaLangString)) {
              break label625;
            }
            boolean bool = TextUtils.isEmpty((CharSequence)localObject);
            if (bool) {
              break label625;
            }
            try
            {
              JSONObject localJSONObject = new JSONObject((String)localObject);
              bbkb.e(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin(), localJSONObject.optString("hot_chat_link"));
              bbkb.v(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin(), localJSONObject.optInt("aio_post_tab_plugin"));
              ((bamk)paramQQAppInterface.getManager(203)).a(localJSONObject);
              ((akue)paramQQAppInterface.getManager(126)).a(localJSONObject);
              bbkb.u(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin(), localJSONObject.optInt("create_troop_max_invite_num"));
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
            bbkb.a(paramQQAppInterface.getApp(), "troop_common_config_version", jdField_a_of_type_JavaLangString, j);
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
            if (j != bbkb.a(paramQQAppInterface.getApp(), "nearby_config_version", jdField_a_of_type_JavaLangString))
            {
              boolean bool = TextUtils.isEmpty((CharSequence)localObject);
              if (!bool) {
                try
                {
                  localObject = new JSONObject((String)localObject);
                  bbkb.a(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin(), (JSONObject)localObject);
                  bbkb.a(paramQQAppInterface.getApp(), "nearby_config_version", jdField_a_of_type_JavaLangString, j);
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
          if (j != bbkb.a(paramQQAppInterface.getApp(), "nearby_nowlive_tab_config_version", jdField_a_of_type_JavaLangString))
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
                bbkb.a(paramQQAppInterface.getApp(), "nearby_nowlive_tab_config_version", jdField_a_of_type_JavaLangString, j);
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
        bahw localbahw = (bahw)paramQQAppInterface.getManager(183);
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
            if ((j != bbkb.a(paramQQAppInterface.getApp(), "change_machine_version", jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty(str)))
            {
              if (BaseApplicationImpl.isFirstLogin) {
                localbahw.a(str);
              }
              bbkb.a(paramQQAppInterface.getApp(), "change_machine_version", jdField_a_of_type_JavaLangString, j);
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
    return paramFloat / (50.0F * 2.0F) * (float)bbdh.g();
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
              paramConfig = augv.a(paramConfig.content.get().toByteArray());
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
    //   0	1333	0	this	andt
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
      byte[] arrayOfByte = albv.a((byte[])localObject);
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
        localObject2 = albv.a((byte[])localObject1);
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
    //   13: getstatic 15	andt:jdField_a_of_type_JavaLangString	Ljava/lang/String;
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
    //   0	313	0	this	andt
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
    NewIntent localNewIntent = new NewIntent(paramQQAppInterface.getApp(), andt.class);
    localNewIntent.putExtra("k_cmd_type", new int[] { paramInt });
    if (!bbkk.a(paramString)) {
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
            if (ampl.a().b(i1))
            {
              localObject2 = ampl.a();
              localObject7 = ((ampl)localObject2).a(i1);
              i = j;
              if (localObject7 != null)
              {
                i = ((ampa)localObject7).b(((ampl)localObject2).a(i1, jdField_a_of_type_JavaLangString));
                bool = ((ampl)localObject2).a(paramQQAppInterface, i1);
                if (bool)
                {
                  ((ampl)localObject2).a(i1, 0);
                  i = 0;
                }
                if (QLog.isColorLevel()) {
                  QLog.d("QConfigManager", 2, "[Send] t=" + i1 + " v=" + i + " up=" + bool);
                }
                localConfigSeq.version.set(i);
                if (!((ampl)localObject2).a(i1)) {
                  break label9262;
                }
                localConfigSeq.compress.set(1);
                break label9262;
              }
            }
            if (i == 0) {
              paramQQAppInterface.a().a(localConfigSeq, paramQQAppInterface, i1);
            }
          }
          catch (Exception localException2)
          {
            Object localObject2;
            label1609:
            String str;
            long l;
            int m;
            label3474:
            int i2;
            QLog.d("QConfigManager", 1, "exception " + i1, localException2);
            continue;
          }
          localArrayList1.add(localConfigSeq);
          localArrayList2.add(Integer.valueOf(i1));
          k += 1;
          break;
          localConfigSeq.version.set(bbkb.c(paramQQAppInterface.getApp()));
          continue;
          localConfigSeq.version.set(bbkb.g(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
          continue;
          bbkb.a(paramQQAppInterface.getApplication(), paramQQAppInterface.getCurrentAccountUin());
          if (paramQQAppInterface.getCurrentAccountUin() != null)
          {
            jdField_b_of_type_JavaLangString = paramQQAppInterface.getCurrentNickname();
            localObject2 = bbac.a(paramQQAppInterface, paramQQAppInterface.getCurrentAccountUin());
            if (localObject2 != null)
            {
              if (QLog.isColorLevel()) {
                QLog.i("SPLASH_ConfigServlet_birth", 2, "card!=null");
              }
              j = (int)((Card)localObject2).lBirthday;
              i = axbb.b(j);
              j = axbb.c(j);
              bbkb.b(paramQQAppInterface.getApp(), a(i, j));
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
            localConfigSeq.version.set(bbkb.h(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
            continue;
            localObject2 = (aned)paramQQAppInterface.getManager(74);
            localConfigSeq.version.set(((aned)localObject2).a());
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
            localConfigSeq.version.set(bbkb.i(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin()));
            continue;
            localConfigSeq.version.set(bbkb.j(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin()));
            continue;
            localConfigSeq.version.set(bbkb.b(paramQQAppInterface.getApp()));
            continue;
            localConfigSeq.version.set(PatchSharedPreUtil.getPatchConfigVersion(paramQQAppInterface.getApp()));
            localConfigSeq.compress.set(1);
            continue;
            BridgeHelper.a(BaseApplication.getContext(), jdField_a_of_type_JavaLangString).a();
            localConfigSeq.version.set(bbkb.a(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount()));
            continue;
            i = aney.a(BaseApplicationImpl.getContext());
            if (SettingCloneUtil.readValueForInt(BaseApplicationImpl.getContext(), jdField_a_of_type_JavaLangString, null, "qqsetting_calltab_show_key_version", 0) < i)
            {
              localConfigSeq.version.set(0);
            }
            else
            {
              localConfigSeq.version.set(bbkb.l(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount()));
              continue;
              i = aney.a(BaseApplicationImpl.getContext());
              if (SettingCloneUtil.readValueForInt(BaseApplicationImpl.getContext(), jdField_a_of_type_JavaLangString, null, "qqsetting_calltab_show_key_version", 0) < i)
              {
                localConfigSeq.version.set(0);
                paramIntent.putExtra("update101Version", i);
              }
              else
              {
                localConfigSeq.version.set(bbkb.k(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount()));
                continue;
                localObject2 = (akco)paramQQAppInterface.getManager(102);
                localConfigSeq.version.set(((akco)localObject2).a());
                continue;
                localConfigSeq.version.set(bbkb.o(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
                continue;
                localConfigSeq.version.set(bbkb.p(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
                continue;
                localConfigSeq.version.set(bbkb.f(paramQQAppInterface.getApp()));
                continue;
                localConfigSeq.version.set(bbkb.q(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
                continue;
                localConfigSeq.version.set(bbkb.r(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
                continue;
                if (!PtvTemplateManager.a())
                {
                  localConfigSeq.version.set(0);
                }
                else
                {
                  localConfigSeq.version.set(bbkb.h(paramQQAppInterface.getApp()));
                  continue;
                  if (!PtvTemplateManager.b())
                  {
                    localConfigSeq.version.set(0);
                    localConfigSeq.compress.set(1);
                  }
                  else
                  {
                    localConfigSeq.version.set(bbkb.j(paramQQAppInterface.getApp()));
                    continue;
                    if (!avrv.a())
                    {
                      localConfigSeq.version.set(0);
                      localConfigSeq.compress.set(1);
                    }
                    else
                    {
                      localConfigSeq.version.set(bbkb.i(paramQQAppInterface.getApp()));
                      continue;
                      i = 0;
                      if (PtvTemplateManager.c()) {
                        i = bbkb.k(paramQQAppInterface.getApp());
                      }
                      localConfigSeq.version.set(i);
                      localConfigSeq.compress.set(1);
                      if (QLog.isDevelopLevel())
                      {
                        QLog.d("Doodle_Strokes_SPLASH_ConfigServlet", 4, String.format("个性笔触配置版本号[%s]", new Object[] { Integer.valueOf(i) }));
                        continue;
                        i = bbkb.E(paramQQAppInterface.getApp());
                        localConfigSeq.version.set(i);
                        localConfigSeq.compress.set(1);
                        if (QLog.isDevelopLevel())
                        {
                          QLog.d("QQSTORY_FOLLOW_CAPTURE_SPLASH_ConfigServlet", 4, String.format("日迹合拍版本号[%s]", new Object[] { Integer.valueOf(i) }));
                          continue;
                          i = bbkb.aP(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
                          localConfigSeq.version.set(i);
                          localConfigSeq.compress.set(1);
                          if (QLog.isDevelopLevel())
                          {
                            QLog.d("QQSTORY_QUESTION_TAB_SPLASH_ConfigServlet", 4, String.format("日迹问答版本号[%s]", new Object[] { Integer.valueOf(i) }));
                            continue;
                            BusinessCommonConfig.getInstance(paramQQAppInterface).fillConfigVersion(i1, localConfigSeq);
                            continue;
                            localConfigSeq.version.set(bbkb.b(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount()));
                            continue;
                            localConfigSeq.version.set(bbkb.c(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount()));
                            continue;
                            localConfigSeq.version.set(bbkb.m(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
                            continue;
                            localConfigSeq.version.set(bbkb.n(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
                            continue;
                            localConfigSeq.version.set(bbkb.d(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
                            continue;
                            localConfigSeq.version.set(bbkb.F(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
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
                            bool = ygk.a();
                            if (QLog.isColorLevel()) {
                              QLog.d("SPLASH_ConfigServlet", 2, "addAllConfigs, support ble=" + bool);
                            }
                            if (bool)
                            {
                              localConfigSeq.version.set(bbkb.e(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
                              continue;
                              bool = ygk.a();
                              if (QLog.isColorLevel()) {
                                QLog.d("SPLASH_ConfigServlet", 2, "addAllConfigs, support ble=" + bool);
                              }
                              if (bool)
                              {
                                localConfigSeq.version.set(bbkb.f(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
                                continue;
                                localConfigSeq.version.set(bbkb.s(paramQQAppInterface.getApp()));
                                continue;
                                i = bbkb.x(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
                                j = AppSetting.a();
                                if (i != j)
                                {
                                  bbkb.i(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, 0);
                                  bbkb.k(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, j);
                                  SearchConfigManager.a(paramQQAppInterface, jdField_a_of_type_JavaLangString);
                                }
                                localConfigSeq.version.set(bbkb.w(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
                                continue;
                                localConfigSeq.version.set(bbkb.G(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
                                continue;
                                localConfigSeq.version.set(bbkb.g(paramQQAppInterface.getApp()));
                                localConfigSeq.compress.set(1);
                                continue;
                                localConfigSeq.version.set(bbkb.t(paramQQAppInterface.getApp()));
                                continue;
                                localConfigSeq.version.set(bbkb.u(paramQQAppInterface.getApp()));
                                continue;
                                localConfigSeq.version.set(bbkb.v(paramQQAppInterface.getApp()));
                                continue;
                                localConfigSeq.version.set(bbkb.w(paramQQAppInterface.getApp()));
                                continue;
                                localConfigSeq.version.set(bbkb.A(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
                                continue;
                                localConfigSeq.version.set(bbkb.K(paramQQAppInterface.getApp(), paramQQAppInterface.c()));
                                continue;
                                localConfigSeq.version.set(bbkb.x(paramQQAppInterface.getApp()));
                                continue;
                                i = bbkb.B(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
                                localConfigSeq.version.set(i);
                                continue;
                                localConfigSeq.version.set(((akaa)paramQQAppInterface.getManager(159)).b());
                                continue;
                                i = bbkb.C(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
                                if (bbkb.y(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount()) != AppSetting.a()) {
                                  i = 0;
                                }
                                localConfigSeq.version.set(i);
                                continue;
                                localObject2 = (bfod)paramQQAppInterface.a(146);
                                i = ((bfod)localObject2).b(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
                                j = ((bfod)localObject2).a(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
                                m = AppSetting.a();
                                if (j != m)
                                {
                                  i = 0;
                                  QLog.i("NCtr", 1, String.format("request NOTIFICATION_LIMIT_CONFIG localVersion: %d ,originalAppId:%d, currentAppId:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(m) }));
                                  localConfigSeq.version.set(i);
                                  continue;
                                  i = bbkb.at(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
                                  if (bbkb.au(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount()) != AppSetting.a()) {
                                    i = 0;
                                  }
                                  localConfigSeq.version.set(i);
                                  continue;
                                  i = bbkb.av(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
                                  if (bbkb.aw(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount()) != AppSetting.a()) {
                                    i = 0;
                                  }
                                  localConfigSeq.version.set(i);
                                  continue;
                                  localObject1 = DeviceProfileManager.a(paramQQAppInterface);
                                  continue;
                                  localConfigSeq.version.set(bbkb.E(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
                                  continue;
                                  localConfigSeq.version.set(ausb.a(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
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
                                  localConfigSeq.version.set(bbkb.o(paramQQAppInterface.getApp()));
                                  continue;
                                  localConfigSeq.version.set(bbkb.p(paramQQAppInterface.getApp()));
                                  continue;
                                  localConfigSeq.version.set(bbkb.L(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin()));
                                  continue;
                                  localConfigSeq.version.set(bbkb.O(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
                                  continue;
                                  localConfigSeq.version.set(bbkb.J(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin()));
                                  continue;
                                  localConfigSeq.version.set(bbkb.a(paramQQAppInterface.getApp(), "shop_tab", jdField_a_of_type_JavaLangString));
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
                                  if (!augv.a(BaseApplicationImpl.getContext(), "olympic_config_act_get")) {
                                    continue;
                                  }
                                  if (QLog.isColorLevel()) {
                                    QLog.d("Olympic.configServlet", 2, new Object[] { "check24Hour, result=true, do Report, key=", "olympic_config_act_get" });
                                  }
                                  axrn.a(BaseApplicationImpl.getContext()).a("", "olympic_config_act_get", true, 0L, 0L, null, "", false);
                                  augv.a(BaseApplicationImpl.getContext(), "olympic_config_act_get");
                                  continue;
                                  localObject2 = (alch)paramQQAppInterface.getManager(168);
                                  if (localObject2 == null) {
                                    continue;
                                  }
                                  i2 = ((alch)localObject2).b();
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
            m = ((alch)localObject2).a();
            if ((m == 0) || (i3 != m)) {
              break label9268;
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
          Object localObject3 = (akxf)paramQQAppInterface.getManager(220);
          if (localObject3 == null) {
            break;
          }
          i = ((akxf)localObject3).b();
          if (QLog.isColorLevel()) {
            QLog.d("handleResp_GetArGlobalConfig", 2, " local version = " + i);
          }
          if (((akxf)localObject3).a()) {
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
          localObject3 = (akxf)paramQQAppInterface.getManager(220);
          if (localObject3 == null) {
            break;
          }
          i = ((akxf)localObject3).c();
          localConfigSeq.version.set(i);
          localConfigSeq.compress.set(1);
          paramIntent.putExtra("ar_scan_star_face_config_version", i);
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("SPLASH_ConfigServlet", 2, " get AR_SCAN_STAR_FACE_CONFIG, version = " + i);
          break;
          i = alcl.a(paramQQAppInterface);
          localConfigSeq.version.set(i);
          localConfigSeq.compress.set(1);
          paramIntent.putExtra("key_download_cfg_version", i);
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("SPLASH_ConfigServlet", 2, " get AR_SCAN_FACE_PRE_DOWN_CONFIG, version = " + i);
          break;
          localObject3 = (alch)paramQQAppInterface.getManager(168);
          if (localObject3 == null) {
            break;
          }
          i = ((alch)localObject3).c();
          localConfigSeq.version.set(i);
          localConfigSeq.compress.set(1);
          paramIntent.putExtra("key_ar_entrance_effect_version", i);
          break;
          i = bbkb.a(paramQQAppInterface.getApp(), "readinjoy_interested_push_config", jdField_a_of_type_JavaLangString);
          localConfigSeq.version.set(i);
          break;
          localObject3 = (PhoneContactManagerImp)paramQQAppInterface.getManager(11);
          localConfigSeq.version.set(((PhoneContactManagerImp)localObject3).f());
          break;
          lcw.a(i1, jdField_a_of_type_JavaLangString, localConfigSeq);
          break;
          i = amfv.a(BaseApplicationImpl.getContext());
          localConfigSeq.version.set(i);
          localConfigSeq.compress.set(1);
          paramIntent.putExtra("qcamera_conf_version", i);
          paramIntent.putExtra("uin", paramQQAppInterface.getCurrentAccountUin());
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.i("Q.camera.configServlet", 2, "request QCAMERA_PHONE_CONFIG version: " + i);
          break;
          i = bbkb.a(paramQQAppInterface.getApp(), "change_machine_version", jdField_a_of_type_JavaLangString);
          localConfigSeq.version.set(i);
          break;
          i = bbkb.H(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
          if (QLog.isColorLevel()) {
            QLog.d("SPLASH_ConfigServlet", 2, "addAllConfigs|GET_CONFIG_UPGRADE version=" + i);
          }
          localConfigSeq.version.set(i);
          paramQQAppInterface.o();
          bdjq.a(paramQQAppInterface.getApp(), String.valueOf(AppSetting.a()));
          ((ajud)paramQQAppInterface.a(4)).b();
          break;
          i = bbkb.I(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
          localConfigSeq.version.set(i);
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("UpgradeTIMWrapper", 2, "ConfigServlet req :193, version: " + i);
          break;
          i = bbkb.a(paramQQAppInterface.getApp(), "now_entrance_action_version", jdField_a_of_type_JavaLangString);
          localConfigSeq.version.set(i);
          break;
          i = bbkb.a(paramQQAppInterface.getApp(), "troop_common_config_version", jdField_a_of_type_JavaLangString);
          localConfigSeq.version.set(i);
          break;
          i = bbkb.a(paramQQAppInterface.getApp(), "nearby_config_version", jdField_a_of_type_JavaLangString);
          localConfigSeq.version.set(i);
          break;
          i = bbkb.a(paramQQAppInterface.getApp(), "nearby_nowlive_tab_config_version", jdField_a_of_type_JavaLangString);
          localConfigSeq.version.set(i);
          break;
          localConfigSeq.version.set(bbkb.P(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount()));
          localConfigSeq.compress.set(1);
          break;
          localObject3 = (ajsi)paramQQAppInterface.a(53);
          if (localObject3 == null) {
            break;
          }
          i = AppSetting.a();
          if (i != ((ajsi)localObject3).b(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString))
          {
            ((ajsi)localObject3).a(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, 0);
            ((ajsi)localObject3).b(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, i);
            ((ajsi)localObject3).a(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, true);
            ((ajsi)localObject3).c();
          }
          localConfigSeq.version.set(((ajsi)localObject3).a(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
          break;
          localConfigSeq.version.set(bbkb.R(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
          localConfigSeq.version.set(bbkb.S(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
          localConfigSeq.compress.set(1);
          break;
          localConfigSeq.version.set(bbkb.D(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
          break;
          localConfigSeq.version.set(awvx.a());
          break;
          i = awin.a(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin());
          localConfigSeq.version.set(i);
          break;
          i = bbkb.a(paramQQAppInterface.getApp(), "nearby_glamour_level_config_version", jdField_a_of_type_JavaLangString);
          localConfigSeq.version.set(i);
          localConfigSeq.compress.set(1);
          break;
          localConfigSeq.version.set(bbkb.U(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
          break;
          if (bbkb.a(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, 1) != AppSetting.a())
          {
            bbkb.d(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, 1, AppSetting.a());
            bbkb.d(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, 2, 0);
            localConfigSeq.version.set(0);
            break;
          }
          localConfigSeq.version.set(bbkb.a(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, 2));
          break;
          try
          {
            if (((Integer)bbkb.a(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, 1)).intValue() == AppSetting.a()) {
              break label5553;
            }
            bbkb.a(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, 1, Integer.valueOf(AppSetting.a()));
            bbkb.a(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, 2, Integer.valueOf(0));
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
        label5553:
        i = ((Integer)bbkb.a(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, 2)).intValue();
        localConfigSeq.version.set(i);
        break;
        localConfigSeq.version.set(bbkb.X(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
        break;
        if (!PtvTemplateManager.d()) {
          localConfigSeq.version.set(0);
        }
        for (;;)
        {
          localConfigSeq.compress.set(1);
          break;
          localConfigSeq.version.set(bbkb.m(paramQQAppInterface.getApp()));
        }
        localConfigSeq.version.set(bbkb.V(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
        break;
        localConfigSeq.version.set(bbkb.aa(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
        localConfigSeq.compress.set(1);
        break;
        localConfigSeq.version.set(bbkb.ac(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
        localConfigSeq.compress.set(1);
        break;
        Object localObject4 = (vwn)paramQQAppInterface.getManager(208);
        localConfigSeq.version.set(((vwn)localObject4).a.a(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
        break;
        localConfigSeq.version.set(bbkb.Z(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
        localConfigSeq.compress.set(1);
        break;
        localConfigSeq.version.set(sfe.c(paramQQAppInterface));
        break;
        i = bbkb.ak(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
        j = AppSetting.a();
        if (i != j)
        {
          bbkb.I(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, 0);
          bbkb.J(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, j);
        }
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("SPLASH_ConfigServlet", 2, "[Doutu]onsend : appIdRecord = " + i + ", appId = " + j + ", DOUTU_CONFI version = " + bbkb.ah(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
          }
          localConfigSeq.version.set(bbkb.ah(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
          localConfigSeq.compress.set(1);
          break;
          localObject4 = (anoi)getAppRuntime().getManager(214);
          if (localObject4 != null) {
            ((anoi)localObject4).b(false);
          }
        }
        i = bbkb.s(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
        j = AppSetting.a();
        if (i != j)
        {
          bbkb.f(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, 0);
          bbkb.e(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, j);
        }
        if (QLog.isColorLevel()) {
          QLog.d("SPLASH_ConfigServlet", 2, "[GreenVideo]onsend : appIdRecord = " + i + ", appId = " + j + ", GREEN_VIDEO_CONFI version = " + bbkb.t(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
        }
        localConfigSeq.version.set(bbkb.t(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
        localConfigSeq.compress.set(1);
        break;
        i = bbkb.u(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
        j = AppSetting.a();
        if (i != j)
        {
          bbkb.h(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, 0);
          bbkb.g(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, j);
        }
        if (QLog.isColorLevel()) {
          QLog.d("SPLASH_ConfigServlet", 2, "[VideoCompress]onsend : appIdRecord = " + i + ", appId = " + j + ", VIDEO_REDBAG_CONFI version = " + bbkb.am(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
        }
        localConfigSeq.version.set(bbkb.v(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
        localConfigSeq.compress.set(1);
        break;
        if (((Integer)atbi.a(jdField_a_of_type_JavaLangString, "key_app_id", Integer.valueOf(0))).intValue() != AppSetting.a())
        {
          atbi.a(jdField_a_of_type_JavaLangString, "key_tabs_config_version", Integer.valueOf(0));
          atbi.a(jdField_a_of_type_JavaLangString, "key_app_id", Integer.valueOf(AppSetting.a()));
        }
        i = ((Integer)atbi.a(jdField_a_of_type_JavaLangString, "key_tabs_config_version", Integer.valueOf(0))).intValue();
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
        i = xbp.a(jdField_a_of_type_JavaLangString);
        localConfigSeq.version.set(i);
        localConfigSeq.compress.set(1);
        break;
        localConfigSeq.version.set(ayaj.a(paramQQAppInterface));
        localConfigSeq.compress.set(1);
        break;
        localConfigSeq.version.set(bbkb.af(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
        localConfigSeq.compress.set(1);
        break;
        localConfigSeq.version.set(bbkb.ab(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
        localConfigSeq.compress.set(1);
        break;
        localConfigSeq.version.set(aejq.a(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
        localConfigSeq.compress.set(1);
        break;
        i = bbkb.a(paramQQAppInterface.getApp(), "change_machine_version", jdField_a_of_type_JavaLangString);
        localConfigSeq.version.set(i);
        break;
        i = bbkb.a(paramQQAppInterface.getApp(), "nearby_auth_video_config_version", jdField_a_of_type_JavaLangString);
        localConfigSeq.version.set(i);
        break;
        localConfigSeq.version.set(bbkb.ap(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
        break;
        localConfigSeq.version.set(bbkb.z(paramQQAppInterface.getApp()));
        break;
        localConfigSeq.version.set(bbkb.aq(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
        break;
        localConfigSeq.version.set(ahww.a(paramQQAppInterface.getApp()));
        localConfigSeq.compress.set(1);
        break;
        localConfigSeq.version.set(avsf.a(paramQQAppInterface.getApp()));
        localConfigSeq.compress.set(1);
        break;
        a((ConfigurationService.ReqGetConfig)localObject1, localConfigSeq, paramQQAppInterface);
        break;
        i = bbkb.a(paramQQAppInterface.getApp(), "search_function_config_version", jdField_a_of_type_JavaLangString);
        localConfigSeq.version.set(i);
        localConfigSeq.compress.set(1);
        break;
        i = ((atzv)paramQQAppInterface.getManager(228)).a();
        localConfigSeq.version.set(i);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("SPLASH_ConfigServlet", 2, "ConfigServlet OCR_CONFIG ocrVersion:" + i);
        break;
        i = bbkb.as(BaseApplicationImpl.getContext(), jdField_a_of_type_JavaLangString);
        localConfigSeq.version.set(i);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("SPLASH_ConfigServlet", 2, "ConfigServlet receipt ,receiptVersion:" + i);
        break;
        i = bbkb.aW(BaseApplicationImpl.getContext(), jdField_a_of_type_JavaLangString);
        localConfigSeq.version.set(i);
        break;
        i = bbkb.aX(BaseApplicationImpl.getContext(), jdField_a_of_type_JavaLangString);
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
        ahzb.a(paramQQAppInterface, localConfigSeq, true, jdField_a_of_type_JavaLangString);
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
        localObject4 = (aoeu)paramQQAppInterface.getManager(264);
        try
        {
          ((aoeu)localObject4).a();
        }
        catch (Exception localException1)
        {
          QLog.e("SPLASH_ConfigServlet", 1, "get local extend friend exception:", localException1);
        }
      }
      break label1609;
      i = bbkb.d(paramQQAppInterface.getApp());
      localConfigSeq.version.set(i);
      break label1609;
      i = paramQQAppInterface.getPreferences().getInt("tim_aio_tips_bar_version", 0);
      localConfigSeq.version.set(i);
      localConfigSeq.compress.set(1);
      break label1609;
      i = axjr.a(paramQQAppInterface.getApp());
      localConfigSeq.version.set(i);
      localConfigSeq.compress.set(1);
      break label1609;
      i = paramQQAppInterface.getPreferences().getInt("data_migration_tim_version", 0);
      localConfigSeq.version.set(i);
      localConfigSeq.compress.set(1);
      break label1609;
      i = bbkb.a(paramQQAppInterface.getApp(), "nearby_videochat_dialog_config_version", jdField_a_of_type_JavaLangString);
      localConfigSeq.version.set(i);
      break label1609;
      i = bbkb.a(paramQQAppInterface.getApp(), "nearby_videochat_banner_config_version", jdField_a_of_type_JavaLangString);
      localConfigSeq.version.set(i);
      break label1609;
      i = paramQQAppInterface.getPreferences().getInt("zhitu_config_version", 0);
      localConfigSeq.version.set(i);
      localConfigSeq.compress.set(1);
      break label1609;
      i = paramQQAppInterface.getPreferences().getInt("homework_troop_config_version", 0);
      localConfigSeq.version.set(i);
      localConfigSeq.compress.set(1);
      break label1609;
      Object localObject5 = (TroopManager)paramQQAppInterface.getManager(52);
      localConfigSeq.version.set(((TroopManager)localObject5).jdField_a_of_type_Azwm.a(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
      localConfigSeq.compress.set(1);
      break label1609;
      i = paramQQAppInterface.getPreferences().getInt("new_troop_recommend", 0);
      localConfigSeq.version.set(i);
      localConfigSeq.compress.set(1);
      break label1609;
      localObject5 = (TroopManager)paramQQAppInterface.getManager(52);
      localConfigSeq.version.set(((TroopManager)localObject5).jdField_a_of_type_Azyq.a(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
      localConfigSeq.compress.set(1);
      break label1609;
      i = RecentDanceConfigMgr.a();
      localConfigSeq.version.set(i);
      localConfigSeq.compress.set(1);
      break label1609;
      i = aqwf.a().a.a();
      localConfigSeq.version.set(i);
      localConfigSeq.compress.set(1);
      break label1609;
      i = LightVideoConfigMgr.a();
      localConfigSeq.version.set(i);
      localConfigSeq.compress.set(1);
      break label1609;
      localConfigSeq.version.set(bbkb.a(paramQQAppInterface.getApp(), "sport_config", jdField_a_of_type_JavaLangString));
      localConfigSeq.compress.set(1);
      break label1609;
      i = bbkb.a(paramQQAppInterface.getApplication(), "troop_gift_anim_limit", "0");
      localConfigSeq.version.set(i);
      break label1609;
      localConfigSeq.version.set(0);
      localConfigSeq.compress.set(1);
      break label1609;
      i = paramQQAppInterface.getPreferences().getInt("task_entry_config_version", 0);
      localConfigSeq.version.set(i);
      localConfigSeq.compress.set(1);
      break label1609;
      i = paramQQAppInterface.getPreferences().getInt("qzone_xp_config_version", 0);
      localConfigSeq.version.set(i);
      break label1609;
      i = paramQQAppInterface.getPreferences().getInt("buluo_enter_config_version" + paramQQAppInterface.c(), 0);
      localConfigSeq.version.set(i);
      localConfigSeq.compress.set(1);
      break label1609;
      localConfigSeq.version.set(bbkb.aC(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
      break label1609;
      i = bbkb.aE(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
      if (bbkb.aF(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount()) != AppSetting.a()) {
        i = 0;
      }
      localConfigSeq.version.set(i);
      break label1609;
      i = bkvg.a().a(paramQQAppInterface.getApp());
      localConfigSeq.version.set(i);
      localConfigSeq.compress.set(1);
      break label1609;
      i = bkzo.a().a(paramQQAppInterface.getApp());
      localConfigSeq.version.set(i);
      localConfigSeq.compress.set(1);
      break label1609;
      localObject5 = (sst)paramQQAppInterface.getManager(181);
      localConfigSeq.version.set(((sst)localObject5).a.a(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
      localConfigSeq.compress.set(1);
      break label1609;
      localConfigSeq.version.set(bbkb.a());
      localConfigSeq.compress.set(1);
      break label1609;
      i = bbkb.aH(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
      if (bbkb.aI(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount()) != AppSetting.a()) {
        i = 0;
      }
      localConfigSeq.version.set(i);
      break label1609;
      localConfigSeq.version.set(bbkb.Q(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount()));
      localConfigSeq.compress.set(1);
      break label1609;
      i = bbkb.a(paramQQAppInterface.getApp(), "wifi_connect_config_version", jdField_a_of_type_JavaLangString);
      localConfigSeq.version.set(i);
      break label1609;
      localObject5 = (TroopManager)paramQQAppInterface.getManager(52);
      localConfigSeq.version.set(((TroopManager)localObject5).jdField_a_of_type_Xbl.a(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
      localConfigSeq.compress.set(1);
      break label1609;
      i = bbkb.aQ(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
      localConfigSeq.version.set(i);
      break label1609;
      localConfigSeq.version.set(bbkb.ay(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
      localConfigSeq.compress.set(1);
      break label1609;
      i = bbkb.aT(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
      if (bbkb.aU(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount()) != AppSetting.a()) {
        i = 0;
      }
      localConfigSeq.version.set(i);
      break label1609;
      i = bbew.a();
      localConfigSeq.version.set(i);
      localConfigSeq.compress.set(1);
      if (!QLog.isColorLevel()) {
        break label1609;
      }
      QLog.i("JumpForwardPkgManager", 2, "JUMP_PKG_TOAST_CONFIG  ,version:" + i);
      break label1609;
      i = bhvx.a(paramQQAppInterface);
      localConfigSeq.version.set(i);
      localConfigSeq.compress.set(1);
      break label1609;
      i = aexb.a(paramQQAppInterface);
      localConfigSeq.version.set(i);
      localConfigSeq.compress.set(1);
      break label1609;
      localConfigSeq.version.set(((Integer)bbkb.a(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin(), "config_tim_team_version_code", Integer.valueOf(0))).intValue());
      break label1609;
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
        ((ConfigurationService.Screen)localObject7).width.set((int)bbdh.i());
        ((ConfigurationService.Screen)localObject7).height.set((int)bbdh.j());
        ((ConfigurationService.DeviceInfo)localObject6).screen = ((ConfigurationService.Screen)localObject7);
        ((ConfigurationService.DeviceInfo)localObject6).setHasFlag(true);
        ((ConfigurationService.ReqGetConfig)localObject1).device_info = ((ConfigurationService.DeviceInfo)localObject6);
      }
      if ((localArrayList2.contains(Integer.valueOf(47))) || (localArrayList2.contains(Integer.valueOf(65))) || (localArrayList2.contains(Integer.valueOf(156))) || (localArrayList2.contains(Integer.valueOf(297))))
      {
        localObject7 = new ConfigurationService.OS();
        ((ConfigurationService.OS)localObject7).setHasFlag(true);
        ((ConfigurationService.OS)localObject7).type.set(2);
        ((ConfigurationService.OS)localObject7).kernel.set(bbdh.m());
        ((ConfigurationService.OS)localObject7).sdk.set(String.valueOf(bbdh.a()));
        ((ConfigurationService.OS)localObject7).version.set(bbdh.e());
        ((ConfigurationService.OS)localObject7).rom.set(bbdh.j());
        ((ConfigurationService.DeviceInfo)localObject6).brand.set(bbdh.h());
        ((ConfigurationService.DeviceInfo)localObject6).model.set(bbdh.d());
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
          break label9244;
        }
      }
      label9244:
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
      break label3474;
      label9262:
      i = 1;
      break;
      label9268:
      i = 1;
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig, int paramInt)
  {
    int i = paramConfig.version.get();
    int j = bhvx.a(paramQQAppInterface);
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
      bhvx.a(paramQQAppInterface, new JSONObject(paramConfig).optInt("hot_video_enable", 0));
      bhvx.b(paramQQAppInterface, i);
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
    NewIntent localNewIntent = new NewIntent(paramQQAppInterface.getApp(), andt.class);
    int[] arrayOfInt = new int[jdField_a_of_type_ArrayOfInt.length + ampl.jdField_a_of_type_ArrayOfInt.length];
    System.arraycopy(jdField_a_of_type_ArrayOfInt, 0, arrayOfInt, 0, jdField_a_of_type_ArrayOfInt.length);
    System.arraycopy(ampl.jdField_a_of_type_ArrayOfInt, 0, arrayOfInt, jdField_a_of_type_ArrayOfInt.length, ampl.jdField_a_of_type_ArrayOfInt.length);
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
        if ((paramInt == -1) || (bbkb.s(paramQQAppInterface.getApp()) != paramInt)) {
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
    //   4: getstatic 15	andt:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   7: invokestatic 2324	bbkb:ai	(Landroid/content/Context;Ljava/lang/String;)I
    //   10: invokestatic 203	com/tencent/common/config/AppSetting:a	()I
    //   13: if_icmpeq +114 -> 127
    //   16: aload_3
    //   17: invokevirtual 65	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   20: getstatic 15	andt:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   23: invokestatic 203	com/tencent/common/config/AppSetting:a	()I
    //   26: invokestatic 2326	bbkb:G	(Landroid/content/Context;Ljava/lang/String;I)V
    //   29: aload_3
    //   30: invokevirtual 65	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   33: getstatic 15	andt:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   36: iconst_0
    //   37: invokestatic 2328	bbkb:H	(Landroid/content/Context;Ljava/lang/String;I)V
    //   40: iconst_0
    //   41: istore 4
    //   43: aload_2
    //   44: getfield 1327	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$ConfigSeq:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   47: iload 4
    //   49: invokevirtual 1294	com/tencent/mobileqq/pb/PBInt32Field:set	(I)V
    //   52: invokestatic 2330	bbdh:a	()Ljava/util/ArrayList;
    //   55: astore 5
    //   57: aload 5
    //   59: ifnull +119 -> 178
    //   62: aload 5
    //   64: invokevirtual 2331	java/util/ArrayList:size	()I
    //   67: ifle +111 -> 178
    //   70: aload 5
    //   72: invokevirtual 2332	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   75: astore_2
    //   76: aload_2
    //   77: invokeinterface 238 1 0
    //   82: ifeq +96 -> 178
    //   85: aload_2
    //   86: invokeinterface 242 1 0
    //   91: checkcast 139	java/lang/Integer
    //   94: astore 6
    //   96: aload_1
    //   97: getfield 2335	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$ReqGetConfig:carriers	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   100: aload 6
    //   102: invokevirtual 2338	com/tencent/mobileqq/pb/PBRepeatField:add	(Ljava/lang/Object;)V
    //   105: goto -29 -> 76
    //   108: astore_1
    //   109: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   112: ifeq +14 -> 126
    //   115: ldc_w 2340
    //   118: iconst_2
    //   119: ldc_w 2342
    //   122: aload_1
    //   123: invokestatic 1837	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   126: return
    //   127: aload_3
    //   128: invokevirtual 65	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   131: getstatic 15	andt:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   134: invokestatic 2344	bbkb:aj	(Landroid/content/Context;Ljava/lang/String;)I
    //   137: istore 4
    //   139: goto -96 -> 43
    //   142: astore_2
    //   143: ldc 183
    //   145: iconst_2
    //   146: new 85	java/lang/StringBuilder
    //   149: dup
    //   150: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   153: ldc_w 2346
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
    //   184: checkcast 2348	askn
    //   187: invokeinterface 2351 1 0
    //   192: astore 6
    //   194: aload 6
    //   196: ifnull +229 -> 425
    //   199: aload 6
    //   201: getfield 2356	SecurityAccountServer/RespondQueryQQBindingStat:nationCode	Ljava/lang/String;
    //   204: astore_3
    //   205: aload_3
    //   206: astore_2
    //   207: aload_3
    //   208: ifnull +21 -> 229
    //   211: aload_3
    //   212: astore_2
    //   213: aload_3
    //   214: ldc_w 2358
    //   217: invokevirtual 2361	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   220: ifeq +9 -> 229
    //   223: aload_3
    //   224: iconst_1
    //   225: invokevirtual 2364	java/lang/String:substring	(I)Ljava/lang/String;
    //   228: astore_2
    //   229: aload_2
    //   230: invokestatic 126	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   233: ifeq +130 -> 363
    //   236: aload 6
    //   238: getfield 2367	SecurityAccountServer/RespondQueryQQBindingStat:mobileNo	Ljava/lang/String;
    //   241: invokestatic 126	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   244: ifeq +119 -> 363
    //   247: ldc 13
    //   249: astore_2
    //   250: aload_2
    //   251: invokestatic 126	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   254: ifne +11 -> 265
    //   257: aload_1
    //   258: getfield 2370	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$ReqGetConfig:bind_phone_no	Lcom/tencent/mobileqq/pb/PBStringField;
    //   261: aload_2
    //   262: invokevirtual 1410	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   265: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   268: ifeq -142 -> 126
    //   271: new 85	java/lang/StringBuilder
    //   274: dup
    //   275: bipush 100
    //   277: invokespecial 2371	java/lang/StringBuilder:<init>	(I)V
    //   280: astore_1
    //   281: aload_1
    //   282: ldc_w 2373
    //   285: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   288: iload 4
    //   290: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   293: ldc_w 2375
    //   296: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   299: aload_2
    //   300: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   303: pop
    //   304: aload_1
    //   305: ldc_w 2377
    //   308: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   311: pop
    //   312: aload 5
    //   314: ifnull +91 -> 405
    //   317: aload 5
    //   319: invokevirtual 2331	java/util/ArrayList:size	()I
    //   322: ifle +83 -> 405
    //   325: aload 5
    //   327: invokevirtual 2332	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   330: astore_2
    //   331: aload_2
    //   332: invokeinterface 238 1 0
    //   337: ifeq +68 -> 405
    //   340: aload_1
    //   341: aload_2
    //   342: invokeinterface 242 1 0
    //   347: checkcast 139	java/lang/Integer
    //   350: invokevirtual 798	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   353: ldc_w 2379
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
    //   379: ldc_w 2381
    //   382: iconst_2
    //   383: anewarray 301	java/lang/Object
    //   386: dup
    //   387: iconst_0
    //   388: aload_3
    //   389: aastore
    //   390: dup
    //   391: iconst_1
    //   392: aload 6
    //   394: getfield 2367	SecurityAccountServer/RespondQueryQQBindingStat:mobileNo	Ljava/lang/String;
    //   397: aastore
    //   398: invokestatic 1091	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   401: astore_2
    //   402: goto -152 -> 250
    //   405: aload_1
    //   406: ldc_w 2217
    //   409: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   412: pop
    //   413: ldc_w 2340
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
    //   0	431	0	this	andt
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
    //   6: getfield 2389	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:result	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   9: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   12: ifne +20 -> 32
    //   15: aload_1
    //   16: getfield 2392	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:config_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   19: ifnull +13 -> 32
    //   22: aload_1
    //   23: getfield 2392	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:config_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   26: invokevirtual 224	com/tencent/mobileqq/pb/PBRepeatMessageField:size	()I
    //   29: ifne +2001 -> 2030
    //   32: iload 5
    //   34: ifne +426 -> 460
    //   37: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   40: ifeq +12 -> 52
    //   43: ldc 183
    //   45: iconst_2
    //   46: ldc_w 2394
    //   49: invokestatic 199	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   52: iconst_0
    //   53: istore 7
    //   55: iload 7
    //   57: aload 4
    //   59: arraylength
    //   60: if_icmpge +12119 -> 12179
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
    //   86: ldc_w 2396
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
    //   371: invokestatic 1299	ampl:a	()Lampl;
    //   374: iload 9
    //   376: invokevirtual 1302	ampl:b	(I)Z
    //   379: ifeq +48 -> 427
    //   382: invokestatic 1299	ampl:a	()Lampl;
    //   385: iload 9
    //   387: invokevirtual 1305	ampl:a	(I)Lampa;
    //   390: astore_3
    //   391: iload 8
    //   393: istore 6
    //   395: aload_3
    //   396: ifnull +31 -> 427
    //   399: aload_1
    //   400: getfield 2389	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:result	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   403: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   406: ifeq +1607 -> 2013
    //   409: bipush 254
    //   411: istore 6
    //   413: iload 6
    //   415: ifeq +9 -> 424
    //   418: aload_3
    //   419: iload 6
    //   421: invokevirtual 2397	ampa:a	(I)V
    //   424: iconst_1
    //   425: istore 6
    //   427: iload 6
    //   429: ifne +22 -> 451
    //   432: aload_2
    //   433: invokevirtual 1334	com/tencent/mobileqq/app/QQAppInterface:a	()Lamoq;
    //   436: aload_2
    //   437: iload 9
    //   439: iload 5
    //   441: aload_1
    //   442: getfield 2389	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:result	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   445: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   448: invokevirtual 2400	amoq:a	(Lcom/tencent/mobileqq/app/QQAppInterface;IZI)V
    //   451: iload 7
    //   453: iconst_1
    //   454: iadd
    //   455: istore 7
    //   457: goto -402 -> 55
    //   460: aload_1
    //   461: getfield 2389	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:result	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   464: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   467: ifeq +21 -> 488
    //   470: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   473: ifeq -421 -> 52
    //   476: ldc 183
    //   478: iconst_2
    //   479: ldc_w 2402
    //   482: invokestatic 199	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   485: goto -433 -> 52
    //   488: aload_1
    //   489: getfield 2392	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:config_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   492: ifnull +13 -> 505
    //   495: aload_1
    //   496: getfield 2392	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:config_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   499: invokevirtual 224	com/tencent/mobileqq/pb/PBRepeatMessageField:size	()I
    //   502: ifne -450 -> 52
    //   505: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   508: ifeq -456 -> 52
    //   511: ldc 183
    //   513: iconst_2
    //   514: ldc_w 2404
    //   517: invokestatic 199	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   520: goto -468 -> 52
    //   523: iload 9
    //   525: iload 5
    //   527: aload_1
    //   528: invokestatic 2407	lcw:a	(IZLcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig;)V
    //   531: goto -80 -> 451
    //   534: iload 5
    //   536: ifeq +13 -> 549
    //   539: aload_1
    //   540: getfield 2389	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:result	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   543: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   546: ifeq -95 -> 451
    //   549: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   552: ifeq +12 -> 564
    //   555: ldc 183
    //   557: iconst_2
    //   558: ldc_w 2409
    //   561: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   564: aload_0
    //   565: getfield 2411	andt:jdField_a_of_type_Boolean	Z
    //   568: ifne +35 -> 603
    //   571: aload_2
    //   572: ldc_w 2413
    //   575: ldc 13
    //   577: ldc 13
    //   579: ldc_w 2415
    //   582: ldc_w 2415
    //   585: iconst_0
    //   586: iconst_0
    //   587: ldc 13
    //   589: ldc 13
    //   591: ldc 13
    //   593: ldc 13
    //   595: invokestatic 2420	axqy:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   598: aload_0
    //   599: iconst_1
    //   600: putfield 2411	andt:jdField_a_of_type_Boolean	Z
    //   603: aload_2
    //   604: iconst_4
    //   605: invokevirtual 206	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lajtb;
    //   608: checkcast 1781	ajud
    //   611: invokestatic 2425	akuz:a	()Lakuz;
    //   614: invokevirtual 2428	akuz:a	()Lcom/tencent/mobileqq/app/upgrade/UpgradeDetailWrapper;
    //   617: invokevirtual 2431	ajud:a	(Lcom/tencent/mobileqq/app/upgrade/UpgradeDetailWrapper;)V
    //   620: goto -169 -> 451
    //   623: aload_1
    //   624: getfield 2389	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:result	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   627: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   630: ifeq +26 -> 656
    //   633: getstatic 2435	com/tencent/common/app/BaseApplicationImpl:sApplication	Lcom/tencent/common/app/BaseApplicationImpl;
    //   636: aload_2
    //   637: invokevirtual 1593	com/tencent/mobileqq/app/QQAppInterface:c	()Ljava/lang/String;
    //   640: ldc_w 2437
    //   643: bipush 101
    //   645: ldc 13
    //   647: invokestatic 2443	com/tencent/mobileqq/msf/core/net/patch/PatchReporter:reportPatchEvent	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)V
    //   650: invokestatic 2446	xop:c	()V
    //   653: goto -202 -> 451
    //   656: aload_1
    //   657: getfield 2392	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:config_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   660: ifnull +13 -> 673
    //   663: aload_1
    //   664: getfield 2392	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:config_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   667: invokevirtual 224	com/tencent/mobileqq/pb/PBRepeatMessageField:size	()I
    //   670: ifne -20 -> 650
    //   673: aload_2
    //   674: invokestatic 2449	zck:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   677: goto -27 -> 650
    //   680: invokestatic 2446	xop:c	()V
    //   683: goto -232 -> 451
    //   686: iload 5
    //   688: ifeq +13 -> 701
    //   691: aload_1
    //   692: getfield 2389	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:result	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   695: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   698: ifeq -247 -> 451
    //   701: aload_2
    //   702: bipush 125
    //   704: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   707: checkcast 2451	agvx
    //   710: astore_3
    //   711: aload_3
    //   712: iconst_1
    //   713: putfield 2452	agvx:jdField_b_of_type_Boolean	Z
    //   716: aload_3
    //   717: getstatic 2457	com/tencent/mobileqq/data/MessageForFoldMsgGrayTips:PASSWD_REDBAG_MSG_SWITCH_DEFAULT	Z
    //   720: putfield 2458	agvx:c	Z
    //   723: aload_3
    //   724: getstatic 2461	com/tencent/mobileqq/data/MessageForFoldMsgGrayTips:PASSWD_REDBAG_MSG_DISPLAY_NUM_DEFAULT	I
    //   727: putfield 2463	agvx:jdField_a_of_type_Int	I
    //   730: aload_3
    //   731: getstatic 2466	com/tencent/mobileqq/data/MessageForFoldMsgGrayTips:PASSWD_REDBAG_MSG_INDEX_WITH_ID	Z
    //   734: putfield 2468	agvx:e	Z
    //   737: aload_2
    //   738: invokevirtual 65	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   741: aload_2
    //   742: invokevirtual 69	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   745: iconst_0
    //   746: aload_3
    //   747: getfield 2458	agvx:c	Z
    //   750: aload_3
    //   751: getfield 2463	agvx:jdField_a_of_type_Int	I
    //   754: aload_3
    //   755: getfield 2470	agvx:d	Z
    //   758: aload_3
    //   759: getfield 2468	agvx:e	Z
    //   762: invokestatic 2473	bbkb:a	(Landroid/content/Context;Ljava/lang/String;IZIZZ)V
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
    //   781: invokestatic 2478	com/tencent/mobileqq/olympic/OlympicServlet:a	(Lmqq/app/AppRuntime;IIIIII)V
    //   784: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   787: ifeq -336 -> 451
    //   790: ldc_w 1709
    //   793: iconst_2
    //   794: new 85	java/lang/StringBuilder
    //   797: dup
    //   798: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   801: ldc_w 2480
    //   804: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   807: iload 5
    //   809: invokevirtual 152	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   812: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   815: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   818: goto -367 -> 451
    //   821: aload_1
    //   822: getfield 2389	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:result	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   825: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   828: ifeq +61 -> 889
    //   831: aload_1
    //   832: getfield 2389	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:result	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   835: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   838: istore 6
    //   840: aload_2
    //   841: bipush 88
    //   843: iconst_0
    //   844: iconst_0
    //   845: iconst_1
    //   846: iload 6
    //   848: iconst_0
    //   849: invokestatic 2478	com/tencent/mobileqq/olympic/OlympicServlet:a	(Lmqq/app/AppRuntime;IIIIII)V
    //   852: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   855: ifeq -404 -> 451
    //   858: ldc_w 1709
    //   861: iconst_2
    //   862: new 85	java/lang/StringBuilder
    //   865: dup
    //   866: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   869: ldc_w 2482
    //   872: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   875: iload 6
    //   877: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   880: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   883: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   886: goto -435 -> 451
    //   889: aload_1
    //   890: getfield 2392	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:config_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   893: ifnull +13 -> 906
    //   896: aload_1
    //   897: getfield 2392	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:config_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   900: invokevirtual 224	com/tencent/mobileqq/pb/PBRepeatMessageField:size	()I
    //   903: ifne -452 -> 451
    //   906: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   909: ifeq -458 -> 451
    //   912: ldc_w 1709
    //   915: iconst_2
    //   916: ldc_w 2484
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
    //   938: invokestatic 2478	com/tencent/mobileqq/olympic/OlympicServlet:a	(Lmqq/app/AppRuntime;IIIIII)V
    //   941: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   944: ifeq +31 -> 975
    //   947: ldc_w 1709
    //   950: iconst_2
    //   951: new 85	java/lang/StringBuilder
    //   954: dup
    //   955: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   958: ldc_w 2486
    //   961: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   964: iload 5
    //   966: invokevirtual 152	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   969: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   972: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   975: aload_2
    //   976: sipush 168
    //   979: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   982: checkcast 1682	alch
    //   985: astore_3
    //   986: aload_3
    //   987: ifnull -536 -> 451
    //   990: aload_3
    //   991: iconst_1
    //   992: iconst_0
    //   993: invokevirtual 2489	alch:a	(ZZ)V
    //   996: goto -545 -> 451
    //   999: aload_1
    //   1000: getfield 2389	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:result	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   1003: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   1006: ifeq +61 -> 1067
    //   1009: aload_1
    //   1010: getfield 2389	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:result	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   1013: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   1016: istore 6
    //   1018: aload_2
    //   1019: bipush 87
    //   1021: iconst_0
    //   1022: iconst_0
    //   1023: iconst_1
    //   1024: iload 6
    //   1026: iconst_0
    //   1027: invokestatic 2478	com/tencent/mobileqq/olympic/OlympicServlet:a	(Lmqq/app/AppRuntime;IIIIII)V
    //   1030: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1033: ifeq -58 -> 975
    //   1036: ldc_w 1709
    //   1039: iconst_2
    //   1040: new 85	java/lang/StringBuilder
    //   1043: dup
    //   1044: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   1047: ldc_w 2491
    //   1050: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1053: iload 6
    //   1055: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1058: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1061: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1064: goto -89 -> 975
    //   1067: aload_1
    //   1068: getfield 2392	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:config_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   1071: ifnull +13 -> 1084
    //   1074: aload_1
    //   1075: getfield 2392	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:config_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   1078: invokevirtual 224	com/tencent/mobileqq/pb/PBRepeatMessageField:size	()I
    //   1081: ifne -106 -> 975
    //   1084: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1087: ifeq -112 -> 975
    //   1090: ldc_w 1709
    //   1093: iconst_2
    //   1094: ldc_w 2493
    //   1097: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1100: goto -125 -> 975
    //   1103: iload 5
    //   1105: ifne +77 -> 1182
    //   1108: aload_0
    //   1109: invokevirtual 47	andt:getAppRuntime	()Lmqq/app/AppRuntime;
    //   1112: bipush 86
    //   1114: iconst_0
    //   1115: iconst_0
    //   1116: iconst_1
    //   1117: iconst_1
    //   1118: iconst_0
    //   1119: invokestatic 2478	com/tencent/mobileqq/olympic/OlympicServlet:a	(Lmqq/app/AppRuntime;IIIIII)V
    //   1122: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1125: ifeq +31 -> 1156
    //   1128: ldc_w 1669
    //   1131: iconst_2
    //   1132: new 85	java/lang/StringBuilder
    //   1135: dup
    //   1136: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   1139: ldc_w 2495
    //   1142: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1145: iload 5
    //   1147: invokevirtual 152	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1150: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1153: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1156: aload_2
    //   1157: sipush 167
    //   1160: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   1163: checkcast 1645	com/tencent/mobileqq/olympic/OlympicManager
    //   1166: astore_3
    //   1167: aload_3
    //   1168: ifnull -717 -> 451
    //   1171: aload_3
    //   1172: invokevirtual 2497	com/tencent/mobileqq/olympic/OlympicManager:f	()V
    //   1175: aload_3
    //   1176: invokevirtual 2499	com/tencent/mobileqq/olympic/OlympicManager:g	()V
    //   1179: goto -728 -> 451
    //   1182: aload_1
    //   1183: getfield 2389	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:result	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   1186: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   1189: ifeq +64 -> 1253
    //   1192: aload_1
    //   1193: getfield 2389	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:result	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   1196: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   1199: istore 6
    //   1201: aload_0
    //   1202: invokevirtual 47	andt:getAppRuntime	()Lmqq/app/AppRuntime;
    //   1205: bipush 86
    //   1207: iconst_0
    //   1208: iconst_0
    //   1209: iconst_1
    //   1210: iload 6
    //   1212: iconst_0
    //   1213: invokestatic 2478	com/tencent/mobileqq/olympic/OlympicServlet:a	(Lmqq/app/AppRuntime;IIIIII)V
    //   1216: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1219: ifeq -63 -> 1156
    //   1222: ldc_w 1669
    //   1225: iconst_2
    //   1226: new 85	java/lang/StringBuilder
    //   1229: dup
    //   1230: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   1233: ldc_w 2501
    //   1236: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1239: iload 6
    //   1241: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1244: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1247: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1250: goto -94 -> 1156
    //   1253: aload_1
    //   1254: getfield 2392	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:config_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   1257: ifnull +13 -> 1270
    //   1260: aload_1
    //   1261: getfield 2392	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:config_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   1264: invokevirtual 224	com/tencent/mobileqq/pb/PBRepeatMessageField:size	()I
    //   1267: ifne -111 -> 1156
    //   1270: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1273: ifeq -117 -> 1156
    //   1276: ldc_w 1669
    //   1279: iconst_2
    //   1280: ldc_w 2503
    //   1283: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1286: goto -130 -> 1156
    //   1289: aload_2
    //   1290: bipush 53
    //   1292: invokevirtual 206	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lajtb;
    //   1295: checkcast 1793	ajsi
    //   1298: astore_3
    //   1299: aload_3
    //   1300: ifnull -849 -> 451
    //   1303: aload_3
    //   1304: iconst_0
    //   1305: iconst_0
    //   1306: invokevirtual 2504	ajsi:a	(ZZ)V
    //   1309: goto -858 -> 451
    //   1312: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1315: ifeq +12 -> 1327
    //   1318: ldc 183
    //   1320: iconst_2
    //   1321: ldc_w 2506
    //   1324: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1327: aload_2
    //   1328: sipush 179
    //   1331: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   1334: checkcast 2508	aurv
    //   1337: astore_3
    //   1338: aload_3
    //   1339: ifnull -888 -> 451
    //   1342: aload_3
    //   1343: invokevirtual 2509	aurv:a	()V
    //   1346: aload_3
    //   1347: iconst_0
    //   1348: invokevirtual 2510	aurv:a	(Z)V
    //   1351: goto -900 -> 451
    //   1354: aload_2
    //   1355: invokestatic 1517	com/tencent/mobileqq/utils/BusinessCommonConfig:getInstance	(Lmqq/app/AppRuntime;)Lcom/tencent/mobileqq/utils/BusinessCommonConfig;
    //   1358: aload_2
    //   1359: iload 9
    //   1361: iload 5
    //   1363: aload_1
    //   1364: invokevirtual 2514	com/tencent/mobileqq/utils/BusinessCommonConfig:handleResp_Config_Fail	(Lcom/tencent/mobileqq/app/QQAppInterface;IZLcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig;)V
    //   1367: goto -916 -> 451
    //   1370: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1373: ifeq -922 -> 451
    //   1376: aload_1
    //   1377: getfield 2389	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:result	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   1380: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   1383: istore 6
    //   1385: ldc 183
    //   1387: iconst_2
    //   1388: new 85	java/lang/StringBuilder
    //   1391: dup
    //   1392: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   1395: ldc_w 2516
    //   1398: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1401: iload 6
    //   1403: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1406: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1409: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1412: goto -961 -> 451
    //   1415: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1418: ifeq -967 -> 451
    //   1421: aload_1
    //   1422: getfield 2389	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:result	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   1425: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   1428: istore 6
    //   1430: ldc 183
    //   1432: iconst_2
    //   1433: new 85	java/lang/StringBuilder
    //   1436: dup
    //   1437: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   1440: ldc_w 2518
    //   1443: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1446: iload 6
    //   1448: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1451: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1454: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1457: goto -1006 -> 451
    //   1460: aload_1
    //   1461: getfield 2389	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:result	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   1464: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   1467: istore 6
    //   1469: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1472: ifeq +30 -> 1502
    //   1475: ldc 183
    //   1477: iconst_2
    //   1478: new 85	java/lang/StringBuilder
    //   1481: dup
    //   1482: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   1485: ldc_w 2520
    //   1488: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1491: iload 6
    //   1493: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1496: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1499: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1502: new 2522	java/util/HashMap
    //   1505: dup
    //   1506: invokespecial 2523	java/util/HashMap:<init>	()V
    //   1509: astore_3
    //   1510: aload_3
    //   1511: ldc_w 2525
    //   1514: new 85	java/lang/StringBuilder
    //   1517: dup
    //   1518: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   1521: iload 6
    //   1523: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1526: ldc 13
    //   1528: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1531: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1534: invokevirtual 2528	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1537: pop
    //   1538: invokestatic 385	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1541: invokestatic 1676	axrn:a	(Landroid/content/Context;)Laxrn;
    //   1544: aconst_null
    //   1545: ldc_w 2530
    //   1548: iconst_0
    //   1549: lconst_0
    //   1550: lconst_0
    //   1551: aload_3
    //   1552: aconst_null
    //   1553: invokevirtual 2533	axrn:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;)V
    //   1556: goto -1105 -> 451
    //   1559: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1562: ifeq -1111 -> 451
    //   1565: aload_1
    //   1566: getfield 2389	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:result	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   1569: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   1572: istore 6
    //   1574: ldc 183
    //   1576: iconst_2
    //   1577: invokestatic 1086	java/util/Locale:getDefault	()Ljava/util/Locale;
    //   1580: ldc_w 2535
    //   1583: iconst_1
    //   1584: anewarray 301	java/lang/Object
    //   1587: dup
    //   1588: iconst_0
    //   1589: iload 6
    //   1591: invokestatic 305	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1594: aastore
    //   1595: invokestatic 1091	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   1598: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1601: goto -1150 -> 451
    //   1604: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1607: ifeq -1156 -> 451
    //   1610: aload_1
    //   1611: getfield 2389	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:result	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   1614: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   1617: istore 6
    //   1619: ldc 183
    //   1621: iconst_2
    //   1622: invokestatic 1086	java/util/Locale:getDefault	()Ljava/util/Locale;
    //   1625: ldc_w 2537
    //   1628: iconst_1
    //   1629: anewarray 301	java/lang/Object
    //   1632: dup
    //   1633: iconst_0
    //   1634: iload 6
    //   1636: invokestatic 305	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1639: aastore
    //   1640: invokestatic 1091	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   1643: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1646: goto -1195 -> 451
    //   1649: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1652: ifeq -1201 -> 451
    //   1655: aload_1
    //   1656: getfield 2389	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:result	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   1659: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   1662: istore 6
    //   1664: ldc 183
    //   1666: iconst_2
    //   1667: new 85	java/lang/StringBuilder
    //   1670: dup
    //   1671: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   1674: ldc_w 2539
    //   1677: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1680: iload 6
    //   1682: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1685: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1688: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1691: goto -1240 -> 451
    //   1694: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1697: ifeq -1246 -> 451
    //   1700: aload_1
    //   1701: getfield 2389	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:result	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   1704: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   1707: istore 6
    //   1709: ldc 183
    //   1711: iconst_2
    //   1712: new 85	java/lang/StringBuilder
    //   1715: dup
    //   1716: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   1719: ldc_w 2541
    //   1722: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1725: iload 6
    //   1727: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1730: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1733: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1736: goto -1285 -> 451
    //   1739: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1742: ifeq -1291 -> 451
    //   1745: aload_1
    //   1746: getfield 2389	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:result	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   1749: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   1752: istore 6
    //   1754: ldc_w 2543
    //   1757: iconst_2
    //   1758: new 85	java/lang/StringBuilder
    //   1761: dup
    //   1762: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   1765: ldc_w 2545
    //   1768: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1771: iload 6
    //   1773: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1776: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1779: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1782: goto -1331 -> 451
    //   1785: invokestatic 2550	com/tencent/mobileqq/scribble/ScribbleResMgr:a	()Lcom/tencent/mobileqq/scribble/ScribbleResMgr;
    //   1788: invokevirtual 2551	com/tencent/mobileqq/scribble/ScribbleResMgr:b	()V
    //   1791: goto -1340 -> 451
    //   1794: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1797: ifeq -1346 -> 451
    //   1800: aload_1
    //   1801: getfield 2389	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:result	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   1804: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   1807: istore 6
    //   1809: ldc 183
    //   1811: iconst_2
    //   1812: new 85	java/lang/StringBuilder
    //   1815: dup
    //   1816: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   1819: ldc_w 2553
    //   1822: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1825: iload 6
    //   1827: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1830: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1833: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1836: goto -1385 -> 451
    //   1839: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1842: ifeq -1391 -> 451
    //   1845: aload_1
    //   1846: getfield 2389	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:result	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   1849: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   1852: istore 6
    //   1854: ldc_w 2340
    //   1857: iconst_2
    //   1858: new 85	java/lang/StringBuilder
    //   1861: dup
    //   1862: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   1865: ldc_w 2555
    //   1868: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1871: iload 6
    //   1873: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1876: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1879: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1882: goto -1431 -> 451
    //   1885: aload_2
    //   1886: sipush 228
    //   1889: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   1892: checkcast 1965	atzv
    //   1895: astore_3
    //   1896: aload_1
    //   1897: getfield 2389	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:result	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   1900: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   1903: istore 6
    //   1905: ldc 183
    //   1907: iconst_1
    //   1908: new 85	java/lang/StringBuilder
    //   1911: dup
    //   1912: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   1915: ldc_w 2557
    //   1918: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1921: iload 6
    //   1923: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1926: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1929: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1932: aload_3
    //   1933: iconst_0
    //   1934: aconst_null
    //   1935: invokevirtual 2560	atzv:a	(ZLcom/tencent/mobileqq/ocr/data/OcrConfig;)V
    //   1938: goto -1487 -> 451
    //   1941: aload_1
    //   1942: getfield 2389	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:result	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   1945: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   1948: invokestatic 2561	com/tencent/mobileqq/shortvideo/ShortVideoResourceManager:a	(I)V
    //   1951: goto -1500 -> 451
    //   1954: aload_2
    //   1955: sipush 231
    //   1958: aload_1
    //   1959: getfield 2389	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:result	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   1962: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   1965: invokestatic 2564	ahzb:a	(Lcom/tencent/mobileqq/app/QQAppInterface;II)V
    //   1968: goto -1517 -> 451
    //   1971: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1974: ifeq -1523 -> 451
    //   1977: ldc_w 2566
    //   1980: iconst_2
    //   1981: new 85	java/lang/StringBuilder
    //   1984: dup
    //   1985: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   1988: ldc_w 2568
    //   1991: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1994: aload_1
    //   1995: getfield 2389	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:result	Lcom/tencent/mobileqq/pb/PBInt32Field;
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
    //   2030: invokestatic 2571	java/lang/System:currentTimeMillis	()J
    //   2033: lstore 12
    //   2035: aload_1
    //   2036: getfield 2392	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:config_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   2039: invokevirtual 224	com/tencent/mobileqq/pb/PBRepeatMessageField:size	()I
    //   2042: istore 9
    //   2044: new 1125	java/util/ArrayList
    //   2047: dup
    //   2048: aload 4
    //   2050: arraylength
    //   2051: invokespecial 1156	java/util/ArrayList:<init>	(I)V
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
    //   2077: invokeinterface 1135 2 0
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
    //   2105: if_icmpge +8201 -> 10306
    //   2108: aload_1
    //   2109: getfield 2392	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:config_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
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
    //   2162: getfield 2572	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:type	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   2165: invokevirtual 2573	com/tencent/mobileqq/pb/PBInt32Field:has	()Z
    //   2168: ifeq -33 -> 2135
    //   2171: new 139	java/lang/Integer
    //   2174: dup
    //   2175: aload 19
    //   2177: getfield 2572	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:type	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   2180: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   2183: invokespecial 2574	java/lang/Integer:<init>	(I)V
    //   2186: astore 16
    //   2188: aload 18
    //   2190: aload 16
    //   2192: invokeinterface 2576 2 0
    //   2197: pop
    //   2198: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2201: ifeq +41 -> 2242
    //   2204: ldc 183
    //   2206: iconst_2
    //   2207: new 85	java/lang/StringBuilder
    //   2210: dup
    //   2211: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   2214: ldc_w 2578
    //   2217: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2220: aload 16
    //   2222: invokevirtual 798	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2225: ldc_w 2580
    //   2228: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2231: iload 9
    //   2233: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2236: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2239: invokestatic 199	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   2242: aload 16
    //   2244: invokevirtual 1829	java/lang/Integer:intValue	()I
    //   2247: lookupswitch	default:+9831->12078, 1:+2910->5157, 2:+3314->5561, 3:+3804->6051, 5:+4042->6289, 6:+6271->8518, 10:+4895->7142, 12:+4267->6514, 13:+5170->7417, 23:+5560->7807, 31:+5236->7483, 34:+5218->7465, 38:+5669->7916, 42:+6091->8338, 43:+6253->8500, 44:+2487->4734, 46:+6109->8356, 47:+2675->4922, 49:+6100->8347, 50:+6118->8365, 53:+5570->7817, 55:+4583->6830, 56:+6127->8374, 61:+6136->8383, 63:+6154->8401, 64:+6163->8410, 65:+2864->5111, 66:+6172->8419, 69:+6199->8446, 72:+6181->8428, 73:+6190->8437, 74:+6208->8455, 75:+6217->8464, 78:+5580->7827, 79:+6302->8549, 80:+6284->8531, 82:+6311->8558, 84:+5590->7837, 86:+6529->8776, 87:+6548->8795, 88:+6558->8805, 90:+6320->8567, 93:+5880->8127, 94:+5386->7633, 96:+6599->8846, 97:+6609->8856, 101:+5188->7435, 102:+5227->7474, 109:+6646->8893, 111:+6293->8540, 113:+6262->8509, 115:+5198->7445, 116:+1850->4097, 118:+6675->8922, 119:+6725->8972, 120:+6665->8912, 121:+6735->8982, 129:+6705->8952, 130:+6755->9002, 139:+5621->7868, 140:+6783->9030, 142:+6685->8932, 143:+6715->8962, 145:+6823->9070, 146:+6636->8883, 147:+6519->8766, 148:+6145->8392, 149:+6619->8866, 153:+6813->9060, 155:+6833->9080, 156:+9929->12176, 157:+6745->8992, 165:+6853->9100, 166:+6863->9110, 167:+5611->7858, 171:+6885->9132, 174:+6935->9182, 177:+6984->9231, 180:+6619->8866, 181:+6905->9152, 182:+6964->9211, 184:+6895->9142, 185:+7034->9281, 187:+6994->9241, 188:+6568->8815, 190:+7150->9397, 191:+7024->9271, 193:+1444->3691, 194:+6843->9090, 195:+7004->9251, 199:+7053->9300, 201:+6695->8942, 202:+7140->9387, 204:+7618->9865, 205:+6588->8835, 206:+6578->8825, 210:+7160->9407, 211:+6773->9020, 212:+7170->9417, 215:+7197->9444, 218:+6619->8866, 222:+7217->9464, 223:+5649->7896, 225:+7095->9342, 226:+5600->7847, 227:+7014->9261, 228:+6235->8482, 231:+7265->9512, 232:+6765->9012, 234:+7245->9492, 235:+7255->9502, 238:+7280->9527, 244:+7290->9537, 245:+7300->9547, 247:+6915->9162, 253:+7310->9557, 254:+7568->9815, 255:+7330->9577, 256:+6244->8491, 257:+6793->9040, 259:+7578->9825, 260:+6803->9050, 262:+7588->9835, 267:+7628->9875, 268:+7598->9845, 269:+7608->9855, 272:+6925->9172, 273:+6945->9192, 274:+7638->9885, 279:+7647->9894, 280:+7743->9990, 281:+7763->10010, 283:+7773->10020, 284:+7783->10030, 286:+5208->7455, 289:+7810->10057, 295:+7320->9567, 297:+7820->10067, 301:+7793->10040, 308:+7668->9915, 312:+7701->9948, 313:+7689->9936, 314:+7849->10096, 320:+7869->10116, 321:+7044->9291, 328:+6954->9201, 329:+5630->7877, 331:+7891->10138, 336:+7901->10148, 337:+7834->10081, 345:+7910->10157, 347:+7859->10106, 349:+7924->10171, 351:+5639->7886, 360:+7753->10000, 364:+5649->7896, 365:+5649->7896, 371:+6974->9221, 384:+7960->10207, 385:+6226->8473, 386:+7979->10226, 387:+7969->10216, 392:+7997->10244, 393:+8006->10253, 394:+8024->10271, 397:+7719->9966, 400:+7945->10192, 403:+7179->9426, 404:+7188->9435, 410:+8034->10281, 596:+8049->10296
    //   3617: istore 7
    //   3619: invokestatic 1299	ampl:a	()Lampl;
    //   3622: aload 16
    //   3624: invokevirtual 1829	java/lang/Integer:intValue	()I
    //   3627: invokevirtual 1302	ampl:b	(I)Z
    //   3630: ifeq +38 -> 3668
    //   3633: invokestatic 1299	ampl:a	()Lampl;
    //   3636: astore 17
    //   3638: aload 19
    //   3640: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   3643: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   3646: istore 7
    //   3648: aload 17
    //   3650: aload 16
    //   3652: invokevirtual 1829	java/lang/Integer:intValue	()I
    //   3655: iload 7
    //   3657: aload 19
    //   3659: getstatic 15	andt:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   3662: invokevirtual 2583	ampl:a	(IILcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;Ljava/lang/String;)V
    //   3665: iconst_1
    //   3666: istore 7
    //   3668: iload 7
    //   3670: ifne +8411 -> 12081
    //   3673: aload_2
    //   3674: invokevirtual 1334	com/tencent/mobileqq/app/QQAppInterface:a	()Lamoq;
    //   3677: aload_2
    //   3678: aload 19
    //   3680: aload 16
    //   3682: invokevirtual 1829	java/lang/Integer:intValue	()I
    //   3685: invokevirtual 2585	amoq:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;I)V
    //   3688: goto +8393 -> 12081
    //   3691: aload 19
    //   3693: getfield 221	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   3696: ifnull +8385 -> 12081
    //   3699: aload 19
    //   3701: getfield 221	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   3704: invokevirtual 224	com/tencent/mobileqq/pb/PBRepeatMessageField:size	()I
    //   3707: ifle +8374 -> 12081
    //   3710: aload 19
    //   3712: getfield 221	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   3715: iconst_0
    //   3716: invokevirtual 318	com/tencent/mobileqq/pb/PBRepeatMessageField:get	(I)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   3719: checkcast 244	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content
    //   3722: astore 16
    //   3724: aload 16
    //   3726: ifnull +344 -> 4070
    //   3729: aload 16
    //   3731: getfield 248	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content:compress	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   3734: invokevirtual 251	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   3737: iconst_1
    //   3738: if_icmpne +232 -> 3970
    //   3741: aload 16
    //   3743: getfield 255	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content:content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   3746: invokevirtual 260	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   3749: invokevirtual 266	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   3752: invokestatic 321	augv:a	([B)[B
    //   3755: astore 17
    //   3757: aload 17
    //   3759: ifnull +8313 -> 12072
    //   3762: new 118	java/lang/String
    //   3765: dup
    //   3766: aload 17
    //   3768: ldc_w 323
    //   3771: invokespecial 326	java/lang/String:<init>	([BLjava/lang/String;)V
    //   3774: astore 16
    //   3776: aload 16
    //   3778: ifnull +8287 -> 12065
    //   3781: aload 19
    //   3783: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   3786: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   3789: istore 7
    //   3791: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3794: ifeq +42 -> 3836
    //   3797: ldc_w 1787
    //   3800: iconst_2
    //   3801: new 85	java/lang/StringBuilder
    //   3804: dup
    //   3805: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   3808: ldc_w 2587
    //   3811: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3814: iload 7
    //   3816: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3819: ldc_w 2589
    //   3822: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3825: aload 16
    //   3827: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3830: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3833: invokestatic 199	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   3836: aload 16
    //   3838: invokestatic 2594	com/tencent/mobileqq/app/upgrade/UpgradeTIMWrapper:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/app/upgrade/UpgradeTIMWrapper;
    //   3841: astore 17
    //   3843: aload 17
    //   3845: astore 4
    //   3847: aload_0
    //   3848: invokevirtual 47	andt:getAppRuntime	()Lmqq/app/AppRuntime;
    //   3851: invokevirtual 2595	mqq/app/AppRuntime:getApplication	()Lmqq/app/MobileQQ;
    //   3854: getstatic 15	andt:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   3857: iload 7
    //   3859: invokestatic 2597	bbkb:q	(Landroid/content/Context;Ljava/lang/String;I)V
    //   3862: aload_2
    //   3863: invokevirtual 65	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   3866: ldc_w 2599
    //   3869: invokestatic 2602	bbfr:a	(Landroid/content/Context;Ljava/lang/String;)Z
    //   3872: ifne +114 -> 3986
    //   3875: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3878: ifeq +13 -> 3891
    //   3881: ldc_w 1787
    //   3884: iconst_2
    //   3885: ldc_w 2604
    //   3888: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3891: aload 16
    //   3893: invokestatic 2605	com/tencent/mobileqq/app/upgrade/UpgradeTIMWrapper:a	(Ljava/lang/String;)V
    //   3896: aload_2
    //   3897: aload 4
    //   3899: invokestatic 2608	com/tencent/mobileqq/app/upgrade/UpgradeTIMWrapper:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/app/upgrade/UpgradeTIMWrapper;)V
    //   3902: aload 4
    //   3904: astore 16
    //   3906: aload 16
    //   3908: astore 4
    //   3910: goto +8171 -> 12081
    //   3913: astore 16
    //   3915: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3918: ifeq +8174 -> 12092
    //   3921: aload 16
    //   3923: invokevirtual 2609	java/io/UnsupportedEncodingException:printStackTrace	()V
    //   3926: goto +8166 -> 12092
    //   3929: astore 16
    //   3931: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3934: ifeq +8 -> 3942
    //   3937: aload 16
    //   3939: invokevirtual 2610	java/lang/OutOfMemoryError:printStackTrace	()V
    //   3942: invokestatic 2613	java/lang/System:gc	()V
    //   3945: new 118	java/lang/String
    //   3948: dup
    //   3949: aload 17
    //   3951: ldc_w 323
    //   3954: invokespecial 326	java/lang/String:<init>	([BLjava/lang/String;)V
    //   3957: astore 16
    //   3959: goto -183 -> 3776
    //   3962: astore 16
    //   3964: aconst_null
    //   3965: astore 16
    //   3967: goto -191 -> 3776
    //   3970: aload 16
    //   3972: getfield 255	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content:content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   3975: invokevirtual 260	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   3978: invokevirtual 280	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   3981: astore 16
    //   3983: goto -207 -> 3776
    //   3986: aload 4
    //   3988: astore 16
    //   3990: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3993: ifeq -87 -> 3906
    //   3996: ldc_w 1787
    //   3999: iconst_2
    //   4000: ldc_w 2615
    //   4003: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4006: aload 4
    //   4008: astore 16
    //   4010: goto -104 -> 3906
    //   4013: astore 17
    //   4015: aload 4
    //   4017: astore 16
    //   4019: iload 10
    //   4021: istore 11
    //   4023: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4026: ifeq -1891 -> 2135
    //   4029: ldc 183
    //   4031: iconst_2
    //   4032: new 85	java/lang/StringBuilder
    //   4035: dup
    //   4036: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   4039: ldc_w 2617
    //   4042: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4045: aload 17
    //   4047: invokevirtual 2287	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   4050: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4053: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4056: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4059: aload 4
    //   4061: astore 16
    //   4063: iload 10
    //   4065: istore 11
    //   4067: goto -1932 -> 2135
    //   4070: aload 4
    //   4072: astore 16
    //   4074: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4077: ifeq -171 -> 3906
    //   4080: ldc_w 1787
    //   4083: iconst_2
    //   4084: ldc_w 2619
    //   4087: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4090: aload 4
    //   4092: astore 16
    //   4094: goto -188 -> 3906
    //   4097: aload_0
    //   4098: invokevirtual 47	andt:getAppRuntime	()Lmqq/app/AppRuntime;
    //   4101: invokevirtual 2595	mqq/app/AppRuntime:getApplication	()Lmqq/app/MobileQQ;
    //   4104: getstatic 15	andt:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   4107: invokestatic 1768	bbkb:H	(Landroid/content/Context;Ljava/lang/String;)I
    //   4110: istore 7
    //   4112: aload 19
    //   4114: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   4117: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   4120: istore 8
    //   4122: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4125: ifeq +35 -> 4160
    //   4128: ldc 183
    //   4130: iconst_2
    //   4131: ldc_w 2621
    //   4134: iconst_2
    //   4135: anewarray 301	java/lang/Object
    //   4138: dup
    //   4139: iconst_0
    //   4140: iload 7
    //   4142: invokestatic 305	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   4145: aastore
    //   4146: dup
    //   4147: iconst_1
    //   4148: iload 8
    //   4150: invokestatic 305	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   4153: aastore
    //   4154: invokestatic 309	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   4157: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4160: aconst_null
    //   4161: astore 17
    //   4163: iload 7
    //   4165: iload 8
    //   4167: if_icmpeq +386 -> 4553
    //   4170: aload 19
    //   4172: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   4175: ifnull +14 -> 4189
    //   4178: aload 19
    //   4180: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   4183: invokevirtual 2622	com/tencent/mobileqq/pb/PBRepeatField:isEmpty	()Z
    //   4186: ifeq +285 -> 4471
    //   4189: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4192: ifeq +12 -> 4204
    //   4195: ldc 183
    //   4197: iconst_2
    //   4198: ldc_w 2624
    //   4201: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4204: ldc_w 2626
    //   4207: getstatic 15	andt:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   4210: invokestatic 2631	akux:a	(Ljava/lang/String;Ljava/lang/String;)Z
    //   4213: pop
    //   4214: aconst_null
    //   4215: astore 16
    //   4217: aload_0
    //   4218: invokevirtual 47	andt:getAppRuntime	()Lmqq/app/AppRuntime;
    //   4221: invokevirtual 2595	mqq/app/AppRuntime:getApplication	()Lmqq/app/MobileQQ;
    //   4224: getstatic 15	andt:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   4227: iload 8
    //   4229: invokestatic 2633	bbkb:p	(Landroid/content/Context;Ljava/lang/String;I)V
    //   4232: aload_2
    //   4233: iconst_4
    //   4234: invokevirtual 206	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lajtb;
    //   4237: checkcast 1781	ajud
    //   4240: astore 19
    //   4242: aload 16
    //   4244: invokestatic 126	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4247: ifne +468 -> 4715
    //   4250: invokestatic 2425	akuz:a	()Lakuz;
    //   4253: invokevirtual 2428	akuz:a	()Lcom/tencent/mobileqq/app/upgrade/UpgradeDetailWrapper;
    //   4256: astore 17
    //   4258: aload 17
    //   4260: aload 16
    //   4262: invokevirtual 2636	com/tencent/mobileqq/app/upgrade/UpgradeDetailWrapper:a	(Ljava/lang/String;)V
    //   4265: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4268: ifeq +42 -> 4310
    //   4271: ldc 183
    //   4273: iconst_2
    //   4274: ldc_w 2638
    //   4277: iconst_2
    //   4278: anewarray 301	java/lang/Object
    //   4281: dup
    //   4282: iconst_0
    //   4283: invokestatic 203	com/tencent/common/config/AppSetting:a	()I
    //   4286: invokestatic 305	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   4289: aastore
    //   4290: dup
    //   4291: iconst_1
    //   4292: aload 17
    //   4294: getfield 2641	com/tencent/mobileqq/app/upgrade/UpgradeDetailWrapper:jdField_b_of_type_ProtocolKQQConfigUpgradeInfo	Lprotocol/KQQConfig/UpgradeInfo;
    //   4297: getfield 2646	protocol/KQQConfig/UpgradeInfo:iUpgradeSdkId	I
    //   4300: invokestatic 305	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   4303: aastore
    //   4304: invokestatic 309	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   4307: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4310: aload_2
    //   4311: invokevirtual 65	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   4314: getstatic 15	andt:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   4317: invokestatic 2649	bbkb:aM	(Landroid/content/Context;Ljava/lang/String;)I
    //   4320: aload 17
    //   4322: getfield 2641	com/tencent/mobileqq/app/upgrade/UpgradeDetailWrapper:jdField_b_of_type_ProtocolKQQConfigUpgradeInfo	Lprotocol/KQQConfig/UpgradeInfo;
    //   4325: getfield 2646	protocol/KQQConfig/UpgradeInfo:iUpgradeSdkId	I
    //   4328: if_icmpeq +69 -> 4397
    //   4331: aload_2
    //   4332: invokevirtual 65	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   4335: aload_2
    //   4336: invokevirtual 1593	com/tencent/mobileqq/app/QQAppInterface:c	()Ljava/lang/String;
    //   4339: iconst_0
    //   4340: invokestatic 2652	bbkb:ad	(Landroid/content/Context;Ljava/lang/String;I)V
    //   4343: aload_2
    //   4344: invokevirtual 65	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   4347: aload_2
    //   4348: invokevirtual 1593	com/tencent/mobileqq/app/QQAppInterface:c	()Ljava/lang/String;
    //   4351: lconst_0
    //   4352: invokestatic 2655	bbkb:i	(Landroid/content/Context;Ljava/lang/String;J)V
    //   4355: aload_2
    //   4356: invokevirtual 65	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   4359: aload_2
    //   4360: invokevirtual 1593	com/tencent/mobileqq/app/QQAppInterface:c	()Ljava/lang/String;
    //   4363: iconst_0
    //   4364: invokestatic 2658	bbkb:ae	(Landroid/content/Context;Ljava/lang/String;I)V
    //   4367: aload_2
    //   4368: invokevirtual 65	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   4371: aload_2
    //   4372: invokevirtual 1593	com/tencent/mobileqq/app/QQAppInterface:c	()Ljava/lang/String;
    //   4375: lconst_0
    //   4376: invokestatic 2660	bbkb:j	(Landroid/content/Context;Ljava/lang/String;J)V
    //   4379: aload_2
    //   4380: invokevirtual 65	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   4383: getstatic 15	andt:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   4386: aload 17
    //   4388: getfield 2641	com/tencent/mobileqq/app/upgrade/UpgradeDetailWrapper:jdField_b_of_type_ProtocolKQQConfigUpgradeInfo	Lprotocol/KQQConfig/UpgradeInfo;
    //   4391: getfield 2646	protocol/KQQConfig/UpgradeInfo:iUpgradeSdkId	I
    //   4394: invokestatic 2662	bbkb:ac	(Landroid/content/Context;Ljava/lang/String;I)V
    //   4397: invokestatic 203	com/tencent/common/config/AppSetting:a	()I
    //   4400: aload 17
    //   4402: getfield 2641	com/tencent/mobileqq/app/upgrade/UpgradeDetailWrapper:jdField_b_of_type_ProtocolKQQConfigUpgradeInfo	Lprotocol/KQQConfig/UpgradeInfo;
    //   4405: getfield 2646	protocol/KQQConfig/UpgradeInfo:iUpgradeSdkId	I
    //   4408: if_icmplt +171 -> 4579
    //   4411: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4414: ifeq +12 -> 4426
    //   4417: ldc 183
    //   4419: iconst_2
    //   4420: ldc_w 2664
    //   4423: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4426: aload_2
    //   4427: invokevirtual 65	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   4430: getstatic 15	andt:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   4433: iconst_0
    //   4434: invokestatic 2633	bbkb:p	(Landroid/content/Context;Ljava/lang/String;I)V
    //   4437: ldc_w 2626
    //   4440: getstatic 15	andt:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   4443: invokestatic 2631	akux:a	(Ljava/lang/String;Ljava/lang/String;)Z
    //   4446: pop
    //   4447: aload 17
    //   4449: getfield 2641	com/tencent/mobileqq/app/upgrade/UpgradeDetailWrapper:jdField_b_of_type_ProtocolKQQConfigUpgradeInfo	Lprotocol/KQQConfig/UpgradeInfo;
    //   4452: iconst_0
    //   4453: putfield 2667	protocol/KQQConfig/UpgradeInfo:iUpgradeType	I
    //   4456: aload 19
    //   4458: aload 17
    //   4460: invokevirtual 2431	ajud:a	(Lcom/tencent/mobileqq/app/upgrade/UpgradeDetailWrapper;)V
    //   4463: aload 19
    //   4465: invokevirtual 2668	ajud:c	()V
    //   4468: goto +7613 -> 12081
    //   4471: aload 19
    //   4473: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   4476: iconst_0
    //   4477: invokevirtual 116	com/tencent/mobileqq/pb/PBRepeatField:get	(I)Ljava/lang/Object;
    //   4480: checkcast 118	java/lang/String
    //   4483: astore 16
    //   4485: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4488: ifeq +30 -> 4518
    //   4491: ldc 183
    //   4493: iconst_2
    //   4494: new 85	java/lang/StringBuilder
    //   4497: dup
    //   4498: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   4501: ldc_w 2670
    //   4504: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4507: aload 16
    //   4509: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4512: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4515: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4518: aload 16
    //   4520: invokestatic 126	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4523: ifeq +16 -> 4539
    //   4526: ldc_w 2626
    //   4529: getstatic 15	andt:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   4532: invokestatic 2631	akux:a	(Ljava/lang/String;Ljava/lang/String;)Z
    //   4535: pop
    //   4536: goto -319 -> 4217
    //   4539: ldc_w 2626
    //   4542: getstatic 15	andt:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   4545: aload 16
    //   4547: invokestatic 2673	akux:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   4550: goto -333 -> 4217
    //   4553: aload 17
    //   4555: astore 16
    //   4557: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4560: ifeq -328 -> 4232
    //   4563: ldc 183
    //   4565: iconst_2
    //   4566: ldc_w 2675
    //   4569: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4572: aload 17
    //   4574: astore 16
    //   4576: goto -344 -> 4232
    //   4579: aload_0
    //   4580: invokevirtual 47	andt:getAppRuntime	()Lmqq/app/AppRuntime;
    //   4583: invokevirtual 2595	mqq/app/AppRuntime:getApplication	()Lmqq/app/MobileQQ;
    //   4586: getstatic 15	andt:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   4589: invokestatic 2571	java/lang/System:currentTimeMillis	()J
    //   4592: invokestatic 2677	bbkb:a	(Landroid/content/Context;Ljava/lang/String;J)V
    //   4595: aload 17
    //   4597: monitorenter
    //   4598: aload 17
    //   4600: getfield 2678	com/tencent/mobileqq/app/upgrade/UpgradeDetailWrapper:jdField_a_of_type_Boolean	Z
    //   4603: ifne +27 -> 4630
    //   4606: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4609: ifeq +12 -> 4621
    //   4612: ldc 183
    //   4614: iconst_2
    //   4615: ldc_w 2680
    //   4618: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4621: aload 17
    //   4623: monitorexit
    //   4624: iconst_1
    //   4625: istore 10
    //   4627: goto +7454 -> 12081
    //   4630: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4633: ifeq +12 -> 4645
    //   4636: ldc 183
    //   4638: iconst_2
    //   4639: ldc_w 2682
    //   4642: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4645: aload 17
    //   4647: getfield 2684	com/tencent/mobileqq/app/upgrade/UpgradeDetailWrapper:jdField_b_of_type_Int	I
    //   4650: ifne +21 -> 4671
    //   4653: aload 17
    //   4655: getfield 2685	com/tencent/mobileqq/app/upgrade/UpgradeDetailWrapper:jdField_a_of_type_Int	I
    //   4658: iconst_1
    //   4659: if_icmpne +7444 -> 12103
    //   4662: iconst_1
    //   4663: istore 10
    //   4665: aload_2
    //   4666: iload 10
    //   4668: invokestatic 2686	ajud:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Z)V
    //   4671: aload 19
    //   4673: invokevirtual 2668	ajud:c	()V
    //   4676: invokestatic 2425	akuz:a	()Lakuz;
    //   4679: aload 17
    //   4681: getfield 2641	com/tencent/mobileqq/app/upgrade/UpgradeDetailWrapper:jdField_b_of_type_ProtocolKQQConfigUpgradeInfo	Lprotocol/KQQConfig/UpgradeInfo;
    //   4684: aload 19
    //   4686: invokevirtual 2689	akuz:a	(Lprotocol/KQQConfig/UpgradeInfo;Lakvb;)Z
    //   4689: pop
    //   4690: aload 17
    //   4692: monitorexit
    //   4693: iconst_1
    //   4694: istore 10
    //   4696: goto +7385 -> 12081
    //   4699: astore 16
    //   4701: aload 17
    //   4703: monitorexit
    //   4704: aload 16
    //   4706: athrow
    //   4707: astore 17
    //   4709: iconst_1
    //   4710: istore 10
    //   4712: goto -697 -> 4015
    //   4715: aload 19
    //   4717: invokevirtual 2668	ajud:c	()V
    //   4720: aload 19
    //   4722: invokestatic 2425	akuz:a	()Lakuz;
    //   4725: invokevirtual 2428	akuz:a	()Lcom/tencent/mobileqq/app/upgrade/UpgradeDetailWrapper;
    //   4728: invokevirtual 2431	ajud:a	(Lcom/tencent/mobileqq/app/upgrade/UpgradeDetailWrapper;)V
    //   4731: goto +7350 -> 12081
    //   4734: aload 19
    //   4736: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   4739: ifnull +141 -> 4880
    //   4742: aload 19
    //   4744: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   4747: invokevirtual 113	com/tencent/mobileqq/pb/PBRepeatField:size	()I
    //   4750: ifle +130 -> 4880
    //   4753: aload_0
    //   4754: invokevirtual 47	andt:getAppRuntime	()Lmqq/app/AppRuntime;
    //   4757: invokevirtual 2595	mqq/app/AppRuntime:getApplication	()Lmqq/app/MobileQQ;
    //   4760: aload 19
    //   4762: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   4765: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   4768: getstatic 15	andt:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   4771: invokestatic 2691	bbkb:f	(Landroid/content/Context;ILjava/lang/String;)V
    //   4774: iconst_0
    //   4775: istore 7
    //   4777: iload 7
    //   4779: aload 19
    //   4781: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   4784: invokevirtual 113	com/tencent/mobileqq/pb/PBRepeatField:size	()I
    //   4787: if_icmpge +7331 -> 12118
    //   4790: aload 19
    //   4792: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   4795: iload 7
    //   4797: invokevirtual 116	com/tencent/mobileqq/pb/PBRepeatField:get	(I)Ljava/lang/Object;
    //   4800: checkcast 118	java/lang/String
    //   4803: astore 16
    //   4805: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4808: ifeq +47 -> 4855
    //   4811: ldc 183
    //   4813: iconst_2
    //   4814: new 85	java/lang/StringBuilder
    //   4817: dup
    //   4818: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   4821: ldc_w 2693
    //   4824: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4827: aload 16
    //   4829: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4832: ldc_w 604
    //   4835: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4838: aload 19
    //   4840: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   4843: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   4846: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4849: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4852: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4855: aload 16
    //   4857: invokestatic 126	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4860: ifne +7249 -> 12109
    //   4863: aload_2
    //   4864: bipush 60
    //   4866: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   4869: checkcast 2695	com/tencent/mobileqq/app/HotChatManager
    //   4872: aload 16
    //   4874: invokevirtual 2697	com/tencent/mobileqq/app/HotChatManager:d	(Ljava/lang/String;)V
    //   4877: goto +7232 -> 12109
    //   4880: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4883: ifeq +7198 -> 12081
    //   4886: ldc 183
    //   4888: iconst_2
    //   4889: new 85	java/lang/StringBuilder
    //   4892: dup
    //   4893: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   4896: ldc_w 2699
    //   4899: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4902: aload 19
    //   4904: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   4907: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   4910: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4913: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4916: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4919: goto +7162 -> 12081
    //   4922: aload 19
    //   4924: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   4927: ifnull +142 -> 5069
    //   4930: aload 19
    //   4932: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   4935: invokevirtual 113	com/tencent/mobileqq/pb/PBRepeatField:size	()I
    //   4938: ifle +131 -> 5069
    //   4941: aload_0
    //   4942: invokevirtual 47	andt:getAppRuntime	()Lmqq/app/AppRuntime;
    //   4945: invokevirtual 2595	mqq/app/AppRuntime:getApplication	()Lmqq/app/MobileQQ;
    //   4948: aload 19
    //   4950: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   4953: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   4956: getstatic 15	andt:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   4959: invokestatic 2701	bbkb:d	(Landroid/content/Context;ILjava/lang/String;)V
    //   4962: iconst_0
    //   4963: istore 7
    //   4965: iload 7
    //   4967: aload 19
    //   4969: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   4972: invokevirtual 113	com/tencent/mobileqq/pb/PBRepeatField:size	()I
    //   4975: if_icmpge +7155 -> 12130
    //   4978: aload 19
    //   4980: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   4983: iload 7
    //   4985: invokevirtual 116	com/tencent/mobileqq/pb/PBRepeatField:get	(I)Ljava/lang/Object;
    //   4988: checkcast 118	java/lang/String
    //   4991: astore 16
    //   4993: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4996: ifeq +47 -> 5043
    //   4999: ldc 183
    //   5001: iconst_2
    //   5002: new 85	java/lang/StringBuilder
    //   5005: dup
    //   5006: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   5009: ldc_w 2703
    //   5012: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5015: aload 16
    //   5017: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5020: ldc_w 604
    //   5023: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5026: aload 19
    //   5028: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   5031: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   5034: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5037: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5040: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   5043: aload 16
    //   5045: invokestatic 126	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   5048: ifne +7073 -> 12121
    //   5051: aload_2
    //   5052: bipush 51
    //   5054: invokevirtual 206	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lajtb;
    //   5057: checkcast 2705	yah
    //   5060: aload 16
    //   5062: iconst_0
    //   5063: invokevirtual 2708	yah:a	(Ljava/lang/String;Z)V
    //   5066: goto +7055 -> 12121
    //   5069: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5072: ifeq +7009 -> 12081
    //   5075: ldc 183
    //   5077: iconst_2
    //   5078: new 85	java/lang/StringBuilder
    //   5081: dup
    //   5082: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   5085: ldc_w 2710
    //   5088: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5091: aload 19
    //   5093: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   5096: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   5099: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5102: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5105: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   5108: goto +6973 -> 12081
    //   5111: aload 19
    //   5113: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   5116: ifnull +6965 -> 12081
    //   5119: aload_0
    //   5120: invokevirtual 47	andt:getAppRuntime	()Lmqq/app/AppRuntime;
    //   5123: invokevirtual 2595	mqq/app/AppRuntime:getApplication	()Lmqq/app/MobileQQ;
    //   5126: aload 19
    //   5128: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   5131: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   5134: getstatic 15	andt:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   5137: invokestatic 2712	bbkb:e	(Landroid/content/Context;ILjava/lang/String;)V
    //   5140: aload_2
    //   5141: bipush 51
    //   5143: invokevirtual 206	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lajtb;
    //   5146: checkcast 2705	yah
    //   5149: aload 19
    //   5151: invokevirtual 2714	yah:a	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   5154: goto +6927 -> 12081
    //   5157: aload 19
    //   5159: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   5162: ifnull +276 -> 5438
    //   5165: aload 19
    //   5167: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   5170: invokevirtual 113	com/tencent/mobileqq/pb/PBRepeatField:size	()I
    //   5173: ifle +265 -> 5438
    //   5176: new 2716	java/io/File
    //   5179: dup
    //   5180: new 85	java/lang/StringBuilder
    //   5183: dup
    //   5184: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   5187: aload_0
    //   5188: invokevirtual 47	andt:getAppRuntime	()Lmqq/app/AppRuntime;
    //   5191: invokevirtual 2595	mqq/app/AppRuntime:getApplication	()Lmqq/app/MobileQQ;
    //   5194: invokevirtual 2722	mqq/app/MobileQQ:getFilesDir	()Ljava/io/File;
    //   5197: invokevirtual 2725	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   5200: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5203: ldc_w 2727
    //   5206: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5209: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5212: invokespecial 2728	java/io/File:<init>	(Ljava/lang/String;)V
    //   5215: astore 16
    //   5217: aload 16
    //   5219: invokevirtual 2731	java/io/File:exists	()Z
    //   5222: ifne +152 -> 5374
    //   5225: aload 16
    //   5227: invokevirtual 2734	java/io/File:mkdirs	()Z
    //   5230: pop
    //   5231: aload 19
    //   5233: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   5236: invokevirtual 1147	com/tencent/mobileqq/pb/PBRepeatField:get	()Ljava/util/List;
    //   5239: invokeinterface 233 1 0
    //   5244: astore 16
    //   5246: aload 16
    //   5248: invokeinterface 238 1 0
    //   5253: ifeq +6889 -> 12142
    //   5256: aload 16
    //   5258: invokeinterface 242 1 0
    //   5263: checkcast 118	java/lang/String
    //   5266: astore 17
    //   5268: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5271: ifeq +47 -> 5318
    //   5274: ldc 183
    //   5276: iconst_2
    //   5277: new 85	java/lang/StringBuilder
    //   5280: dup
    //   5281: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   5284: ldc_w 2736
    //   5287: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5290: aload 17
    //   5292: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5295: ldc_w 604
    //   5298: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5301: aload 19
    //   5303: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   5306: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   5309: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5312: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5315: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   5318: aload_0
    //   5319: aload 17
    //   5321: aload 19
    //   5323: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   5326: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   5329: invokespecial 2739	andt:e	(Ljava/lang/String;I)V
    //   5332: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5335: ifeq -89 -> 5246
    //   5338: ldc 183
    //   5340: iconst_2
    //   5341: new 85	java/lang/StringBuilder
    //   5344: dup
    //   5345: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   5348: ldc_w 2741
    //   5351: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5354: aload 19
    //   5356: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   5359: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   5362: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5365: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5368: invokestatic 199	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   5371: goto -125 -> 5246
    //   5374: aload 16
    //   5376: ifnull -145 -> 5231
    //   5379: aload 16
    //   5381: invokevirtual 2744	java/io/File:isDirectory	()Z
    //   5384: ifeq -153 -> 5231
    //   5387: aload 16
    //   5389: invokevirtual 2748	java/io/File:listFiles	()[Ljava/io/File;
    //   5392: astore 16
    //   5394: aload 16
    //   5396: arraylength
    //   5397: istore 8
    //   5399: iconst_0
    //   5400: istore 7
    //   5402: iload 7
    //   5404: iload 8
    //   5406: if_icmpge -175 -> 5231
    //   5409: aload 16
    //   5411: iload 7
    //   5413: aaload
    //   5414: astore 17
    //   5416: aload 17
    //   5418: ifnull +6715 -> 12133
    //   5421: aload 17
    //   5423: invokevirtual 2731	java/io/File:exists	()Z
    //   5426: ifeq +6707 -> 12133
    //   5429: aload 17
    //   5431: invokevirtual 2751	java/io/File:delete	()Z
    //   5434: pop
    //   5435: goto +6698 -> 12133
    //   5438: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5441: ifeq +36 -> 5477
    //   5444: ldc 183
    //   5446: iconst_2
    //   5447: new 85	java/lang/StringBuilder
    //   5450: dup
    //   5451: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   5454: ldc_w 2753
    //   5457: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5460: aload 19
    //   5462: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   5465: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   5468: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5471: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5474: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   5477: new 2716	java/io/File
    //   5480: dup
    //   5481: new 85	java/lang/StringBuilder
    //   5484: dup
    //   5485: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   5488: aload_0
    //   5489: invokevirtual 47	andt:getAppRuntime	()Lmqq/app/AppRuntime;
    //   5492: invokevirtual 2595	mqq/app/AppRuntime:getApplication	()Lmqq/app/MobileQQ;
    //   5495: invokevirtual 2722	mqq/app/MobileQQ:getFilesDir	()Ljava/io/File;
    //   5498: invokevirtual 2725	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   5501: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5504: ldc_w 2755
    //   5507: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5510: ldc_w 2757
    //   5513: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5516: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5519: invokespecial 2728	java/io/File:<init>	(Ljava/lang/String;)V
    //   5522: astore 16
    //   5524: aload 16
    //   5526: ifnull +9 -> 5535
    //   5529: aload 16
    //   5531: invokevirtual 2751	java/io/File:delete	()Z
    //   5534: pop
    //   5535: aload_0
    //   5536: invokevirtual 47	andt:getAppRuntime	()Lmqq/app/AppRuntime;
    //   5539: invokevirtual 2595	mqq/app/AppRuntime:getApplication	()Lmqq/app/MobileQQ;
    //   5542: aload 19
    //   5544: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   5547: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   5550: ldc_w 2759
    //   5553: ldc 13
    //   5555: invokestatic 2762	bbkb:a	(Landroid/content/Context;ILjava/lang/String;Ljava/lang/String;)V
    //   5558: goto +6523 -> 12081
    //   5561: aload 19
    //   5563: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   5566: ifnull +323 -> 5889
    //   5569: aload 19
    //   5571: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   5574: invokevirtual 113	com/tencent/mobileqq/pb/PBRepeatField:size	()I
    //   5577: ifle +312 -> 5889
    //   5580: getstatic 2767	amou:a	Lanef;
    //   5583: invokevirtual 2770	anef:b	()V
    //   5586: aload 19
    //   5588: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   5591: invokevirtual 1147	com/tencent/mobileqq/pb/PBRepeatField:get	()Ljava/util/List;
    //   5594: invokeinterface 233 1 0
    //   5599: astore 16
    //   5601: aload 16
    //   5603: invokeinterface 238 1 0
    //   5608: ifeq +82 -> 5690
    //   5611: aload 16
    //   5613: invokeinterface 242 1 0
    //   5618: checkcast 118	java/lang/String
    //   5621: astore 17
    //   5623: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5626: ifeq +47 -> 5673
    //   5629: ldc 183
    //   5631: iconst_2
    //   5632: new 85	java/lang/StringBuilder
    //   5635: dup
    //   5636: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   5639: ldc_w 2772
    //   5642: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5645: aload 17
    //   5647: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5650: ldc_w 604
    //   5653: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5656: aload 19
    //   5658: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   5661: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   5664: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5667: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5670: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   5673: aload_0
    //   5674: aload 17
    //   5676: aload 19
    //   5678: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   5681: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   5684: invokespecial 2774	andt:c	(Ljava/lang/String;I)V
    //   5687: goto -86 -> 5601
    //   5690: new 2776	amow
    //   5693: dup
    //   5694: aload_0
    //   5695: invokevirtual 47	andt:getAppRuntime	()Lmqq/app/AppRuntime;
    //   5698: invokevirtual 2595	mqq/app/AppRuntime:getApplication	()Lmqq/app/MobileQQ;
    //   5701: getstatic 15	andt:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   5704: invokespecial 2778	amow:<init>	(Landroid/content/Context;Ljava/lang/String;)V
    //   5707: astore 16
    //   5709: aload 16
    //   5711: ifnull +13 -> 5724
    //   5714: aload 16
    //   5716: invokevirtual 2779	amow:b	()V
    //   5719: aload 16
    //   5721: invokevirtual 2780	amow:c	()V
    //   5724: invokestatic 385	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   5727: ldc_w 2782
    //   5730: iconst_0
    //   5731: invokevirtual 340	com/tencent/qphone/base/util/BaseApplication:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   5734: astore 16
    //   5736: aload 16
    //   5738: invokeinterface 346 1 0
    //   5743: new 85	java/lang/StringBuilder
    //   5746: dup
    //   5747: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   5750: ldc_w 2784
    //   5753: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5756: aload_0
    //   5757: invokevirtual 47	andt:getAppRuntime	()Lmqq/app/AppRuntime;
    //   5760: invokevirtual 2785	mqq/app/AppRuntime:getAccount	()Ljava/lang/String;
    //   5763: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5766: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5769: iconst_1
    //   5770: invokeinterface 354 3 0
    //   5775: invokeinterface 726 1 0
    //   5780: pop
    //   5781: aload 16
    //   5783: invokeinterface 346 1 0
    //   5788: new 85	java/lang/StringBuilder
    //   5791: dup
    //   5792: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   5795: ldc_w 2787
    //   5798: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5801: aload_0
    //   5802: invokevirtual 47	andt:getAppRuntime	()Lmqq/app/AppRuntime;
    //   5805: invokevirtual 2785	mqq/app/AppRuntime:getAccount	()Ljava/lang/String;
    //   5808: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5811: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5814: iconst_1
    //   5815: invokeinterface 354 3 0
    //   5820: invokeinterface 726 1 0
    //   5825: pop
    //   5826: aload_0
    //   5827: invokevirtual 47	andt:getAppRuntime	()Lmqq/app/AppRuntime;
    //   5830: invokevirtual 2595	mqq/app/AppRuntime:getApplication	()Lmqq/app/MobileQQ;
    //   5833: aload 19
    //   5835: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   5838: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   5841: getstatic 15	andt:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   5844: invokestatic 2691	bbkb:f	(Landroid/content/Context;ILjava/lang/String;)V
    //   5847: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5850: ifeq +6295 -> 12145
    //   5853: ldc 183
    //   5855: iconst_2
    //   5856: new 85	java/lang/StringBuilder
    //   5859: dup
    //   5860: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   5863: ldc_w 2789
    //   5866: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5869: aload 19
    //   5871: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   5874: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   5877: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5880: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5883: invokestatic 199	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   5886: goto +6259 -> 12145
    //   5889: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5892: ifeq +36 -> 5928
    //   5895: ldc 183
    //   5897: iconst_2
    //   5898: new 85	java/lang/StringBuilder
    //   5901: dup
    //   5902: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   5905: ldc_w 2791
    //   5908: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5911: aload 19
    //   5913: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   5916: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   5919: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5922: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5925: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   5928: getstatic 2767	amou:a	Lanef;
    //   5931: invokevirtual 2770	anef:b	()V
    //   5934: getstatic 2767	amou:a	Lanef;
    //   5937: invokevirtual 2792	anef:c	()V
    //   5940: new 2776	amow
    //   5943: dup
    //   5944: aload_0
    //   5945: invokevirtual 47	andt:getAppRuntime	()Lmqq/app/AppRuntime;
    //   5948: invokevirtual 2595	mqq/app/AppRuntime:getApplication	()Lmqq/app/MobileQQ;
    //   5951: getstatic 15	andt:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   5954: invokespecial 2778	amow:<init>	(Landroid/content/Context;Ljava/lang/String;)V
    //   5957: astore 16
    //   5959: aload 16
    //   5961: ifnull +13 -> 5974
    //   5964: aload 16
    //   5966: invokevirtual 2779	amow:b	()V
    //   5969: aload 16
    //   5971: invokevirtual 2780	amow:c	()V
    //   5974: invokestatic 385	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   5977: ldc_w 2782
    //   5980: iconst_0
    //   5981: invokevirtual 340	com/tencent/qphone/base/util/BaseApplication:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   5984: invokeinterface 346 1 0
    //   5989: new 85	java/lang/StringBuilder
    //   5992: dup
    //   5993: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   5996: ldc_w 2787
    //   5999: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6002: aload_0
    //   6003: invokevirtual 47	andt:getAppRuntime	()Lmqq/app/AppRuntime;
    //   6006: invokevirtual 2785	mqq/app/AppRuntime:getAccount	()Ljava/lang/String;
    //   6009: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6012: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6015: iconst_0
    //   6016: invokeinterface 354 3 0
    //   6021: invokeinterface 726 1 0
    //   6026: pop
    //   6027: aload_0
    //   6028: invokevirtual 47	andt:getAppRuntime	()Lmqq/app/AppRuntime;
    //   6031: invokevirtual 2595	mqq/app/AppRuntime:getApplication	()Lmqq/app/MobileQQ;
    //   6034: aload 19
    //   6036: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   6039: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   6042: getstatic 15	andt:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   6045: invokestatic 2691	bbkb:f	(Landroid/content/Context;ILjava/lang/String;)V
    //   6048: goto +6033 -> 12081
    //   6051: aload 19
    //   6053: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   6056: ifnull +95 -> 6151
    //   6059: aload 19
    //   6061: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   6064: invokevirtual 113	com/tencent/mobileqq/pb/PBRepeatField:size	()I
    //   6067: ifle +84 -> 6151
    //   6070: aload 19
    //   6072: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   6075: iconst_0
    //   6076: invokevirtual 116	com/tencent/mobileqq/pb/PBRepeatField:get	(I)Ljava/lang/Object;
    //   6079: checkcast 118	java/lang/String
    //   6082: astore 16
    //   6084: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6087: ifeq +47 -> 6134
    //   6090: ldc 183
    //   6092: iconst_2
    //   6093: new 85	java/lang/StringBuilder
    //   6096: dup
    //   6097: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   6100: ldc_w 2794
    //   6103: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6106: aload 16
    //   6108: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6111: ldc_w 604
    //   6114: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6117: aload 19
    //   6119: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   6122: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   6125: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6128: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6131: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   6134: aload_0
    //   6135: aload 16
    //   6137: aload 19
    //   6139: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   6142: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   6145: invokespecial 2796	andt:d	(Ljava/lang/String;I)V
    //   6148: goto +5933 -> 12081
    //   6151: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6154: ifeq +36 -> 6190
    //   6157: ldc 183
    //   6159: iconst_2
    //   6160: new 85	java/lang/StringBuilder
    //   6163: dup
    //   6164: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   6167: ldc_w 2798
    //   6170: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6173: aload 19
    //   6175: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   6178: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   6181: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6184: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6187: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   6190: new 2716	java/io/File
    //   6193: dup
    //   6194: new 85	java/lang/StringBuilder
    //   6197: dup
    //   6198: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   6201: aload_0
    //   6202: invokevirtual 47	andt:getAppRuntime	()Lmqq/app/AppRuntime;
    //   6205: invokevirtual 2595	mqq/app/AppRuntime:getApplication	()Lmqq/app/MobileQQ;
    //   6208: invokevirtual 2722	mqq/app/MobileQQ:getFilesDir	()Ljava/io/File;
    //   6211: invokevirtual 2725	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   6214: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6217: ldc_w 2755
    //   6220: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6223: getstatic 15	andt:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   6226: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6229: ldc_w 2755
    //   6232: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6235: ldc_w 2800
    //   6238: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6241: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6244: invokespecial 2728	java/io/File:<init>	(Ljava/lang/String;)V
    //   6247: astore 16
    //   6249: aload 16
    //   6251: invokevirtual 2731	java/io/File:exists	()Z
    //   6254: ifeq +9 -> 6263
    //   6257: aload 16
    //   6259: invokevirtual 2751	java/io/File:delete	()Z
    //   6262: pop
    //   6263: aload_0
    //   6264: invokevirtual 47	andt:getAppRuntime	()Lmqq/app/AppRuntime;
    //   6267: invokevirtual 2595	mqq/app/AppRuntime:getApplication	()Lmqq/app/MobileQQ;
    //   6270: aload 19
    //   6272: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   6275: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   6278: ldc 13
    //   6280: getstatic 15	andt:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   6283: invokestatic 2802	bbkb:b	(Landroid/content/Context;ILjava/lang/String;Ljava/lang/String;)V
    //   6286: goto +5795 -> 12081
    //   6289: aload 19
    //   6291: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   6294: ifnull +178 -> 6472
    //   6297: aload 19
    //   6299: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   6302: invokevirtual 113	com/tencent/mobileqq/pb/PBRepeatField:size	()I
    //   6305: ifle +167 -> 6472
    //   6308: new 1125	java/util/ArrayList
    //   6311: dup
    //   6312: invokespecial 1126	java/util/ArrayList:<init>	()V
    //   6315: astore 16
    //   6317: iconst_0
    //   6318: istore 7
    //   6320: iload 7
    //   6322: aload 19
    //   6324: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   6327: invokevirtual 113	com/tencent/mobileqq/pb/PBRepeatField:size	()I
    //   6330: if_icmpge +92 -> 6422
    //   6333: aload 19
    //   6335: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   6338: iload 7
    //   6340: invokevirtual 116	com/tencent/mobileqq/pb/PBRepeatField:get	(I)Ljava/lang/Object;
    //   6343: checkcast 118	java/lang/String
    //   6346: astore 17
    //   6348: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6351: ifeq +47 -> 6398
    //   6354: ldc 183
    //   6356: iconst_2
    //   6357: new 85	java/lang/StringBuilder
    //   6360: dup
    //   6361: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   6364: ldc_w 2804
    //   6367: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6370: aload 17
    //   6372: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6375: ldc_w 604
    //   6378: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6381: aload 19
    //   6383: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   6386: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   6389: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6392: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6395: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   6398: aload_0
    //   6399: aload 17
    //   6401: invokespecial 2806	andt:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/config/operation/QQOperationViopTipTask;
    //   6404: astore 17
    //   6406: aload 17
    //   6408: ifnull +5740 -> 12148
    //   6411: aload 16
    //   6413: aload 17
    //   6415: invokevirtual 1159	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   6418: pop
    //   6419: goto +5729 -> 12148
    //   6422: aload_0
    //   6423: invokevirtual 47	andt:getAppRuntime	()Lmqq/app/AppRuntime;
    //   6426: checkcast 49	com/tencent/mobileqq/app/QQAppInterface
    //   6429: invokestatic 2811	andn:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)Landn;
    //   6432: aload_0
    //   6433: invokevirtual 47	andt:getAppRuntime	()Lmqq/app/AppRuntime;
    //   6436: checkcast 49	com/tencent/mobileqq/app/QQAppInterface
    //   6439: aload 16
    //   6441: invokevirtual 2814	andn:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/util/ArrayList;)V
    //   6444: aload_0
    //   6445: invokevirtual 47	andt:getAppRuntime	()Lmqq/app/AppRuntime;
    //   6448: invokevirtual 2595	mqq/app/AppRuntime:getApplication	()Lmqq/app/MobileQQ;
    //   6451: aload_0
    //   6452: invokevirtual 47	andt:getAppRuntime	()Lmqq/app/AppRuntime;
    //   6455: invokevirtual 2785	mqq/app/AppRuntime:getAccount	()Ljava/lang/String;
    //   6458: aload 19
    //   6460: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   6463: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   6466: invokestatic 2815	bbkb:a	(Landroid/content/Context;Ljava/lang/String;I)V
    //   6469: goto +5612 -> 12081
    //   6472: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6475: ifeq +5606 -> 12081
    //   6478: ldc 183
    //   6480: iconst_2
    //   6481: new 85	java/lang/StringBuilder
    //   6484: dup
    //   6485: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   6488: ldc_w 2817
    //   6491: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6494: aload 19
    //   6496: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   6499: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   6502: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6505: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6508: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   6511: goto +5570 -> 12081
    //   6514: aload_2
    //   6515: bipush 74
    //   6517: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   6520: checkcast 1392	aned
    //   6523: astore 16
    //   6525: aload 16
    //   6527: invokevirtual 2820	aned:a	()Ljava/util/Set;
    //   6530: astore 20
    //   6532: new 2769	anef
    //   6535: dup
    //   6536: bipush 21
    //   6538: iconst_2
    //   6539: invokespecial 2823	anef:<init>	(SB)V
    //   6542: astore 17
    //   6544: aload 19
    //   6546: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   6549: ifnull +129 -> 6678
    //   6552: aload 19
    //   6554: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   6557: invokevirtual 113	com/tencent/mobileqq/pb/PBRepeatField:size	()I
    //   6560: ifle +118 -> 6678
    //   6563: aload 19
    //   6565: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   6568: invokevirtual 1147	com/tencent/mobileqq/pb/PBRepeatField:get	()Ljava/util/List;
    //   6571: invokeinterface 233 1 0
    //   6576: astore 21
    //   6578: aload 21
    //   6580: invokeinterface 238 1 0
    //   6585: ifeq +132 -> 6717
    //   6588: aload 21
    //   6590: invokeinterface 242 1 0
    //   6595: checkcast 118	java/lang/String
    //   6598: astore 22
    //   6600: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6603: ifeq +47 -> 6650
    //   6606: ldc 183
    //   6608: iconst_2
    //   6609: new 85	java/lang/StringBuilder
    //   6612: dup
    //   6613: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   6616: ldc_w 2825
    //   6619: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6622: aload 22
    //   6624: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6627: ldc_w 604
    //   6630: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6633: aload 19
    //   6635: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   6638: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   6641: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6644: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6647: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   6650: aload 17
    //   6652: aload 22
    //   6654: aload 20
    //   6656: invokestatic 2828	andt:a	(Lanef;Ljava/lang/String;Ljava/util/Set;)Z
    //   6659: pop
    //   6660: aload 16
    //   6662: aload 17
    //   6664: aload 19
    //   6666: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   6669: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   6672: invokevirtual 2831	aned:a	(Lanef;I)V
    //   6675: goto -97 -> 6578
    //   6678: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6681: ifeq +36 -> 6717
    //   6684: ldc 183
    //   6686: iconst_2
    //   6687: new 85	java/lang/StringBuilder
    //   6690: dup
    //   6691: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   6694: ldc_w 2833
    //   6697: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6700: aload 19
    //   6702: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   6705: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   6708: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6711: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6714: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   6717: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6720: ifeq +76 -> 6796
    //   6723: new 85	java/lang/StringBuilder
    //   6726: dup
    //   6727: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   6730: ldc_w 2835
    //   6733: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6736: astore 20
    //   6738: aload 19
    //   6740: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   6743: ifnonnull +69 -> 6812
    //   6746: iconst_0
    //   6747: istore 7
    //   6749: ldc 183
    //   6751: iconst_2
    //   6752: aload 20
    //   6754: iload 7
    //   6756: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6759: ldc_w 2837
    //   6762: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6765: aload 17
    //   6767: invokevirtual 2838	anef:a	()I
    //   6770: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6773: ldc_w 2840
    //   6776: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6779: aload 19
    //   6781: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   6784: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   6787: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6790: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6793: invokestatic 199	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   6796: aload 16
    //   6798: aload 19
    //   6800: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   6803: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   6806: invokevirtual 2841	aned:a	(I)V
    //   6809: goto +5272 -> 12081
    //   6812: aload 19
    //   6814: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   6817: invokevirtual 1147	com/tencent/mobileqq/pb/PBRepeatField:get	()Ljava/util/List;
    //   6820: invokeinterface 400 1 0
    //   6825: istore 7
    //   6827: goto -78 -> 6749
    //   6830: aload_2
    //   6831: invokevirtual 65	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   6834: aload_2
    //   6835: invokevirtual 411	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   6838: invokestatic 1418	bbkb:j	(Landroid/content/Context;Ljava/lang/String;)I
    //   6841: istore 8
    //   6843: aload 19
    //   6845: ifnull +5312 -> 12157
    //   6848: aload 19
    //   6850: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   6853: ifnull +5304 -> 12157
    //   6856: aload 19
    //   6858: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   6861: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   6864: istore 7
    //   6866: aload 19
    //   6868: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   6871: ifnull +185 -> 7056
    //   6874: aload 19
    //   6876: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   6879: invokevirtual 113	com/tencent/mobileqq/pb/PBRepeatField:size	()I
    //   6882: ifle +174 -> 7056
    //   6885: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6888: ifeq +79 -> 6967
    //   6891: ldc 183
    //   6893: iconst_2
    //   6894: new 85	java/lang/StringBuilder
    //   6897: dup
    //   6898: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   6901: ldc_w 2843
    //   6904: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6907: iload 7
    //   6909: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6912: ldc_w 2845
    //   6915: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6918: iload 8
    //   6920: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6923: ldc_w 2847
    //   6926: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6929: aload 19
    //   6931: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   6934: invokevirtual 113	com/tencent/mobileqq/pb/PBRepeatField:size	()I
    //   6937: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6940: ldc_w 2849
    //   6943: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6946: aload 19
    //   6948: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   6951: iconst_0
    //   6952: invokevirtual 116	com/tencent/mobileqq/pb/PBRepeatField:get	(I)Ljava/lang/Object;
    //   6955: checkcast 118	java/lang/String
    //   6958: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6961: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6964: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   6967: new 522	java/util/HashSet
    //   6970: dup
    //   6971: invokespecial 523	java/util/HashSet:<init>	()V
    //   6974: astore 16
    //   6976: iconst_0
    //   6977: istore 8
    //   6979: iload 8
    //   6981: aload 19
    //   6983: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   6986: invokevirtual 113	com/tencent/mobileqq/pb/PBRepeatField:size	()I
    //   6989: if_icmpge +30 -> 7019
    //   6992: aload 16
    //   6994: aload 19
    //   6996: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   6999: iload 8
    //   7001: invokevirtual 116	com/tencent/mobileqq/pb/PBRepeatField:get	(I)Ljava/lang/Object;
    //   7004: invokeinterface 2852 2 0
    //   7009: pop
    //   7010: iload 8
    //   7012: iconst_1
    //   7013: iadd
    //   7014: istore 8
    //   7016: goto -37 -> 6979
    //   7019: aload_2
    //   7020: sipush 138
    //   7023: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   7026: checkcast 2854	afax
    //   7029: aload 16
    //   7031: invokevirtual 2857	afax:a	(Ljava/util/Set;)V
    //   7034: aload_0
    //   7035: invokevirtual 47	andt:getAppRuntime	()Lmqq/app/AppRuntime;
    //   7038: invokevirtual 2595	mqq/app/AppRuntime:getApplication	()Lmqq/app/MobileQQ;
    //   7041: aload_0
    //   7042: invokevirtual 47	andt:getAppRuntime	()Lmqq/app/AppRuntime;
    //   7045: invokevirtual 2785	mqq/app/AppRuntime:getAccount	()Ljava/lang/String;
    //   7048: iload 7
    //   7050: invokestatic 2858	bbkb:b	(Landroid/content/Context;Ljava/lang/String;I)V
    //   7053: goto +5111 -> 12164
    //   7056: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7059: ifeq +41 -> 7100
    //   7062: ldc 183
    //   7064: iconst_2
    //   7065: new 85	java/lang/StringBuilder
    //   7068: dup
    //   7069: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   7072: ldc_w 2860
    //   7075: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7078: iload 7
    //   7080: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7083: ldc_w 2845
    //   7086: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7089: iload 8
    //   7091: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7094: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7097: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   7100: iload 8
    //   7102: iload 7
    //   7104: if_icmpeq +5060 -> 12164
    //   7107: aload_2
    //   7108: sipush 138
    //   7111: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   7114: checkcast 2854	afax
    //   7117: invokevirtual 2861	afax:a	()V
    //   7120: aload_0
    //   7121: invokevirtual 47	andt:getAppRuntime	()Lmqq/app/AppRuntime;
    //   7124: invokevirtual 2595	mqq/app/AppRuntime:getApplication	()Lmqq/app/MobileQQ;
    //   7127: aload_0
    //   7128: invokevirtual 47	andt:getAppRuntime	()Lmqq/app/AppRuntime;
    //   7131: invokevirtual 2785	mqq/app/AppRuntime:getAccount	()Ljava/lang/String;
    //   7134: iload 7
    //   7136: invokestatic 2858	bbkb:b	(Landroid/content/Context;Ljava/lang/String;I)V
    //   7139: goto +5025 -> 12164
    //   7142: aload 19
    //   7144: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   7147: ifnull +4912 -> 12059
    //   7150: aload 19
    //   7152: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   7155: invokevirtual 113	com/tencent/mobileqq/pb/PBRepeatField:size	()I
    //   7158: ifle +4901 -> 12059
    //   7161: aload 19
    //   7163: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   7166: invokevirtual 1147	com/tencent/mobileqq/pb/PBRepeatField:get	()Ljava/util/List;
    //   7169: astore 16
    //   7171: aload 16
    //   7173: ifnull +195 -> 7368
    //   7176: aload 16
    //   7178: invokeinterface 400 1 0
    //   7183: ifle +185 -> 7368
    //   7186: aload 16
    //   7188: iconst_0
    //   7189: invokeinterface 447 2 0
    //   7194: checkcast 118	java/lang/String
    //   7197: astore 17
    //   7199: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7202: ifeq +47 -> 7249
    //   7205: ldc 183
    //   7207: iconst_2
    //   7208: new 85	java/lang/StringBuilder
    //   7211: dup
    //   7212: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   7215: ldc_w 2863
    //   7218: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7221: aload 17
    //   7223: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7226: ldc_w 604
    //   7229: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7232: aload 19
    //   7234: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   7237: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   7240: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7243: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7246: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   7249: aload 17
    //   7251: invokestatic 2866	myv:a	(Ljava/lang/String;)V
    //   7254: aload 16
    //   7256: invokeinterface 233 1 0
    //   7261: astore 16
    //   7263: aload 16
    //   7265: invokeinterface 238 1 0
    //   7270: ifeq +73 -> 7343
    //   7273: aload 16
    //   7275: invokeinterface 242 1 0
    //   7280: checkcast 118	java/lang/String
    //   7283: astore 17
    //   7285: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7288: ifeq +47 -> 7335
    //   7291: ldc 183
    //   7293: iconst_2
    //   7294: new 85	java/lang/StringBuilder
    //   7297: dup
    //   7298: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   7301: ldc_w 2863
    //   7304: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7307: aload 17
    //   7309: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7312: ldc_w 604
    //   7315: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7318: aload 19
    //   7320: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   7323: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   7326: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7329: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7332: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   7335: aload 17
    //   7337: invokestatic 2869	aexm:a	(Ljava/lang/String;)Z
    //   7340: ifeq -77 -> 7263
    //   7343: aload 19
    //   7345: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   7348: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   7351: istore 7
    //   7353: aload_0
    //   7354: invokevirtual 47	andt:getAppRuntime	()Lmqq/app/AppRuntime;
    //   7357: invokevirtual 2595	mqq/app/AppRuntime:getApplication	()Lmqq/app/MobileQQ;
    //   7360: iload 7
    //   7362: invokestatic 2872	bbkb:b	(Landroid/content/Context;I)V
    //   7365: goto +4716 -> 12081
    //   7368: aconst_null
    //   7369: invokestatic 2866	myv:a	(Ljava/lang/String;)V
    //   7372: invokestatic 2873	aexm:a	()V
    //   7375: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7378: ifeq -35 -> 7343
    //   7381: ldc 183
    //   7383: iconst_2
    //   7384: new 85	java/lang/StringBuilder
    //   7387: dup
    //   7388: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   7391: ldc_w 2875
    //   7394: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7397: aload 19
    //   7399: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   7402: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   7405: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7408: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7411: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   7414: goto -71 -> 7343
    //   7417: invokestatic 385	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   7420: aload_2
    //   7421: invokevirtual 69	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   7424: invokestatic 1430	cooperation/pluginbridge/BridgeHelper:a	(Landroid/content/Context;Ljava/lang/String;)Lcooperation/pluginbridge/BridgeHelper;
    //   7427: aload 19
    //   7429: invokevirtual 2876	cooperation/pluginbridge/BridgeHelper:a	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   7432: goto +4649 -> 12081
    //   7435: aload_0
    //   7436: aload_3
    //   7437: aload 19
    //   7439: invokespecial 2879	andt:l	(Landroid/content/Intent;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   7442: goto +4639 -> 12081
    //   7445: aload_0
    //   7446: aload_3
    //   7447: aload 19
    //   7449: invokespecial 2881	andt:j	(Landroid/content/Intent;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   7452: goto +4629 -> 12081
    //   7455: aload_0
    //   7456: aload_3
    //   7457: aload 19
    //   7459: invokespecial 2883	andt:k	(Landroid/content/Intent;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   7462: goto +4619 -> 12081
    //   7465: aload_0
    //   7466: aload 19
    //   7468: invokespecial 2885	andt:j	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   7471: goto +4610 -> 12081
    //   7474: aload_0
    //   7475: aload 19
    //   7477: invokespecial 2887	andt:i	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   7480: goto +4601 -> 12081
    //   7483: aload 19
    //   7485: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   7488: ifnull +103 -> 7591
    //   7491: aload 19
    //   7493: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   7496: invokevirtual 113	com/tencent/mobileqq/pb/PBRepeatField:size	()I
    //   7499: ifle +92 -> 7591
    //   7502: aload 19
    //   7504: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   7507: iconst_0
    //   7508: invokevirtual 116	com/tencent/mobileqq/pb/PBRepeatField:get	(I)Ljava/lang/Object;
    //   7511: checkcast 118	java/lang/String
    //   7514: astore 16
    //   7516: aload 19
    //   7518: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   7521: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   7524: istore 7
    //   7526: aload_2
    //   7527: invokevirtual 2890	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/av/gaudio/AVNotifyCenter;
    //   7530: aload_2
    //   7531: aload 16
    //   7533: iload 7
    //   7535: invokevirtual 2894	com/tencent/av/gaudio/AVNotifyCenter:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;I)V
    //   7538: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7541: ifeq +4626 -> 12167
    //   7544: ldc 183
    //   7546: iconst_2
    //   7547: new 85	java/lang/StringBuilder
    //   7550: dup
    //   7551: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   7554: ldc_w 2896
    //   7557: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7560: aload 16
    //   7562: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7565: ldc_w 604
    //   7568: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7571: aload 19
    //   7573: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   7576: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   7579: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7582: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7585: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   7588: goto +4579 -> 12167
    //   7591: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7594: ifeq +4487 -> 12081
    //   7597: ldc 183
    //   7599: iconst_2
    //   7600: new 85	java/lang/StringBuilder
    //   7603: dup
    //   7604: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   7607: ldc_w 2898
    //   7610: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7613: aload 19
    //   7615: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   7618: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   7621: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7624: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7627: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   7630: goto +4451 -> 12081
    //   7633: aload_2
    //   7634: sipush 177
    //   7637: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   7640: checkcast 2900	bbpz
    //   7643: astore 16
    //   7645: aload 19
    //   7647: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   7650: ifnull +98 -> 7748
    //   7653: aload 19
    //   7655: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   7658: invokevirtual 113	com/tencent/mobileqq/pb/PBRepeatField:size	()I
    //   7661: ifle +87 -> 7748
    //   7664: aload 19
    //   7666: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   7669: iconst_0
    //   7670: invokevirtual 116	com/tencent/mobileqq/pb/PBRepeatField:get	(I)Ljava/lang/Object;
    //   7673: checkcast 118	java/lang/String
    //   7676: astore 17
    //   7678: aload 19
    //   7680: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   7683: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   7686: istore 7
    //   7688: aload 16
    //   7690: aload 17
    //   7692: aload_2
    //   7693: invokevirtual 411	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   7696: iload 7
    //   7698: invokevirtual 2903	bbpz:a	(Ljava/lang/String;Ljava/lang/String;I)V
    //   7701: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7704: ifeq +4466 -> 12170
    //   7707: ldc 183
    //   7709: iconst_2
    //   7710: new 85	java/lang/StringBuilder
    //   7713: dup
    //   7714: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   7717: ldc_w 2905
    //   7720: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7723: aload 17
    //   7725: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7728: ldc_w 604
    //   7731: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7734: iload 7
    //   7736: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7739: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7742: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   7745: goto +4425 -> 12170
    //   7748: aload 16
    //   7750: aload 19
    //   7752: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   7755: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   7758: aload_2
    //   7759: invokevirtual 411	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   7762: invokevirtual 2908	bbpz:a	(ILjava/lang/String;)V
    //   7765: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7768: ifeq +4405 -> 12173
    //   7771: ldc 183
    //   7773: iconst_2
    //   7774: new 85	java/lang/StringBuilder
    //   7777: dup
    //   7778: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   7781: ldc_w 2910
    //   7784: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7787: aload 19
    //   7789: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   7792: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   7795: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7798: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7801: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   7804: goto +4369 -> 12173
    //   7807: aload_0
    //   7808: aload_3
    //   7809: aload 19
    //   7811: invokespecial 2912	andt:i	(Landroid/content/Intent;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   7814: goto +4267 -> 12081
    //   7817: aload_0
    //   7818: aload_3
    //   7819: aload 19
    //   7821: invokespecial 2914	andt:e	(Landroid/content/Intent;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   7824: goto +4257 -> 12081
    //   7827: aload_0
    //   7828: aload_3
    //   7829: aload 19
    //   7831: invokespecial 2916	andt:f	(Landroid/content/Intent;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   7834: goto +4247 -> 12081
    //   7837: aload_0
    //   7838: aload_3
    //   7839: aload 19
    //   7841: invokespecial 2918	andt:g	(Landroid/content/Intent;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   7844: goto +4237 -> 12081
    //   7847: aload_0
    //   7848: aload_2
    //   7849: aload_3
    //   7850: aload 19
    //   7852: invokespecial 2921	andt:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Landroid/content/Intent;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   7855: goto +4226 -> 12081
    //   7858: aload_0
    //   7859: aload_3
    //   7860: aload 19
    //   7862: invokespecial 2923	andt:h	(Landroid/content/Intent;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   7865: goto +4216 -> 12081
    //   7868: aload_0
    //   7869: aload 19
    //   7871: invokespecial 2925	andt:g	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   7874: goto +4207 -> 12081
    //   7877: aload_0
    //   7878: aload 19
    //   7880: invokespecial 2927	andt:h	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   7883: goto +4198 -> 12081
    //   7886: aload_0
    //   7887: aload_2
    //   7888: aload 19
    //   7890: invokespecial 2929	andt:ae	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   7893: goto +4188 -> 12081
    //   7896: aload_2
    //   7897: invokestatic 1517	com/tencent/mobileqq/utils/BusinessCommonConfig:getInstance	(Lmqq/app/AppRuntime;)Lcom/tencent/mobileqq/utils/BusinessCommonConfig;
    //   7900: aload_2
    //   7901: aload 16
    //   7903: invokevirtual 1829	java/lang/Integer:intValue	()I
    //   7906: aload_3
    //   7907: aload 19
    //   7909: invokevirtual 2933	com/tencent/mobileqq/utils/BusinessCommonConfig:decodeConfig	(Lcom/tencent/mobileqq/app/QQAppInterface;ILandroid/content/Intent;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)Ljava/lang/Boolean;
    //   7912: pop
    //   7913: goto +4168 -> 12081
    //   7916: aload 19
    //   7918: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   7921: ifnull +164 -> 8085
    //   7924: aload 19
    //   7926: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   7929: invokevirtual 113	com/tencent/mobileqq/pb/PBRepeatField:size	()I
    //   7932: ifle +153 -> 8085
    //   7935: aload 19
    //   7937: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   7940: invokevirtual 1147	com/tencent/mobileqq/pb/PBRepeatField:get	()Ljava/util/List;
    //   7943: invokeinterface 233 1 0
    //   7948: astore 16
    //   7950: aload 16
    //   7952: invokeinterface 238 1 0
    //   7957: ifeq +167 -> 8124
    //   7960: aload 16
    //   7962: invokeinterface 242 1 0
    //   7967: checkcast 118	java/lang/String
    //   7970: astore 17
    //   7972: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7975: ifeq +47 -> 8022
    //   7978: ldc 183
    //   7980: iconst_2
    //   7981: new 85	java/lang/StringBuilder
    //   7984: dup
    //   7985: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   7988: ldc_w 2935
    //   7991: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7994: aload 17
    //   7996: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7999: ldc_w 604
    //   8002: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8005: aload 19
    //   8007: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   8010: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   8013: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   8016: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8019: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   8022: aload_0
    //   8023: aload 17
    //   8025: aload 19
    //   8027: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   8030: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   8033: invokespecial 2937	andt:a	(Ljava/lang/String;I)V
    //   8036: goto -86 -> 7950
    //   8039: astore 16
    //   8041: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   8044: ifeq +33 -> 8077
    //   8047: ldc 183
    //   8049: iconst_2
    //   8050: new 85	java/lang/StringBuilder
    //   8053: dup
    //   8054: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   8057: ldc_w 2939
    //   8060: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8063: aload 16
    //   8065: invokevirtual 640	java/lang/Exception:toString	()Ljava/lang/String;
    //   8068: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8071: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8074: invokestatic 642	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   8077: aload 16
    //   8079: invokevirtual 458	java/lang/Exception:printStackTrace	()V
    //   8082: goto +3999 -> 12081
    //   8085: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   8088: ifeq +36 -> 8124
    //   8091: ldc 183
    //   8093: iconst_2
    //   8094: new 85	java/lang/StringBuilder
    //   8097: dup
    //   8098: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   8101: ldc_w 2941
    //   8104: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8107: aload 19
    //   8109: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   8112: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   8115: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   8118: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8121: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   8124: goto +3957 -> 12081
    //   8127: aload 19
    //   8129: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   8132: ifnull +164 -> 8296
    //   8135: aload 19
    //   8137: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   8140: invokevirtual 113	com/tencent/mobileqq/pb/PBRepeatField:size	()I
    //   8143: ifle +153 -> 8296
    //   8146: aload 19
    //   8148: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   8151: invokevirtual 1147	com/tencent/mobileqq/pb/PBRepeatField:get	()Ljava/util/List;
    //   8154: invokeinterface 233 1 0
    //   8159: astore 16
    //   8161: aload 16
    //   8163: invokeinterface 238 1 0
    //   8168: ifeq +167 -> 8335
    //   8171: aload 16
    //   8173: invokeinterface 242 1 0
    //   8178: checkcast 118	java/lang/String
    //   8181: astore 17
    //   8183: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   8186: ifeq +47 -> 8233
    //   8189: ldc 183
    //   8191: iconst_2
    //   8192: new 85	java/lang/StringBuilder
    //   8195: dup
    //   8196: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   8199: ldc_w 2943
    //   8202: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8205: aload 17
    //   8207: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8210: ldc_w 604
    //   8213: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8216: aload 19
    //   8218: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   8221: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   8224: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   8227: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8230: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   8233: aload_0
    //   8234: aload 17
    //   8236: aload 19
    //   8238: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   8241: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   8244: invokespecial 2945	andt:b	(Ljava/lang/String;I)V
    //   8247: goto -86 -> 8161
    //   8250: astore 16
    //   8252: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   8255: ifeq +33 -> 8288
    //   8258: ldc 183
    //   8260: iconst_2
    //   8261: new 85	java/lang/StringBuilder
    //   8264: dup
    //   8265: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   8268: ldc_w 2947
    //   8271: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8274: aload 16
    //   8276: invokevirtual 640	java/lang/Exception:toString	()Ljava/lang/String;
    //   8279: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8282: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8285: invokestatic 642	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   8288: aload 16
    //   8290: invokevirtual 458	java/lang/Exception:printStackTrace	()V
    //   8293: goto +3788 -> 12081
    //   8296: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   8299: ifeq +36 -> 8335
    //   8302: ldc 183
    //   8304: iconst_2
    //   8305: new 85	java/lang/StringBuilder
    //   8308: dup
    //   8309: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   8312: ldc_w 2949
    //   8315: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8318: aload 19
    //   8320: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   8323: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   8326: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   8329: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8332: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   8335: goto +3746 -> 12081
    //   8338: aload_0
    //   8339: aload 19
    //   8341: invokespecial 2951	andt:p	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8344: goto +3737 -> 12081
    //   8347: aload_0
    //   8348: aload 19
    //   8350: invokespecial 2953	andt:m	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8353: goto +3728 -> 12081
    //   8356: aload_0
    //   8357: aload 19
    //   8359: invokespecial 2955	andt:n	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8362: goto +3719 -> 12081
    //   8365: aload_0
    //   8366: aload 19
    //   8368: invokespecial 2957	andt:o	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8371: goto +3710 -> 12081
    //   8374: aload_0
    //   8375: aload 19
    //   8377: invokespecial 2959	andt:t	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8380: goto +3701 -> 12081
    //   8383: aload_0
    //   8384: aload 19
    //   8386: invokespecial 2961	andt:r	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8389: goto +3692 -> 12081
    //   8392: aload_0
    //   8393: aload 19
    //   8395: invokespecial 2963	andt:d	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8398: goto +3683 -> 12081
    //   8401: aload_0
    //   8402: aload 19
    //   8404: invokespecial 2965	andt:q	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8407: goto +3674 -> 12081
    //   8410: aload_0
    //   8411: aload 19
    //   8413: invokespecial 2967	andt:s	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8416: goto +3665 -> 12081
    //   8419: aload_0
    //   8420: aload 19
    //   8422: invokespecial 2969	andt:k	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8425: goto +3656 -> 12081
    //   8428: aload_0
    //   8429: aload 19
    //   8431: invokevirtual 2971	andt:b	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8434: goto +3647 -> 12081
    //   8437: aload_0
    //   8438: aload 19
    //   8440: invokevirtual 2973	andt:c	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8443: goto +3638 -> 12081
    //   8446: aload_0
    //   8447: aload 19
    //   8449: invokespecial 2975	andt:v	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8452: goto +3629 -> 12081
    //   8455: aload_0
    //   8456: aload 19
    //   8458: invokespecial 2977	andt:w	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8461: goto +3620 -> 12081
    //   8464: aload_0
    //   8465: aload 19
    //   8467: invokespecial 2979	andt:z	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8470: goto +3611 -> 12081
    //   8473: aload_0
    //   8474: aload 19
    //   8476: invokespecial 2981	andt:B	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8479: goto +3602 -> 12081
    //   8482: aload_0
    //   8483: aload 19
    //   8485: invokespecial 2983	andt:x	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8488: goto +3593 -> 12081
    //   8491: aload_0
    //   8492: aload 19
    //   8494: invokespecial 2985	andt:y	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8497: goto +3584 -> 12081
    //   8500: aload_0
    //   8501: aload 19
    //   8503: invokespecial 2987	andt:l	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8506: goto +3575 -> 12081
    //   8509: aload_0
    //   8510: aload 19
    //   8512: invokespecial 2989	andt:u	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8515: goto +3566 -> 12081
    //   8518: invokestatic 2992	com/tencent/mobileqq/app/DeviceProfileManager:a	()Lcom/tencent/mobileqq/app/DeviceProfileManager;
    //   8521: aload_1
    //   8522: ldc 13
    //   8524: invokevirtual 2995	com/tencent/mobileqq/app/DeviceProfileManager:a	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig;Ljava/lang/String;)Z
    //   8527: pop
    //   8528: goto +3553 -> 12081
    //   8531: aload_0
    //   8532: aload 19
    //   8534: invokespecial 2997	andt:e	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8537: goto +3544 -> 12081
    //   8540: aload_0
    //   8541: aload 19
    //   8543: invokespecial 2999	andt:f	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8546: goto +3535 -> 12081
    //   8549: aload_0
    //   8550: aload 19
    //   8552: invokevirtual 3000	andt:a	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8555: goto +3526 -> 12081
    //   8558: aload_0
    //   8559: aload 19
    //   8561: invokespecial 3002	andt:A	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8564: goto +3517 -> 12081
    //   8567: aload 19
    //   8569: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   8572: ifnull +141 -> 8713
    //   8575: aload 19
    //   8577: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   8580: invokevirtual 113	com/tencent/mobileqq/pb/PBRepeatField:size	()I
    //   8583: ifle +130 -> 8713
    //   8586: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   8589: ifeq +68 -> 8657
    //   8592: ldc 183
    //   8594: iconst_2
    //   8595: new 85	java/lang/StringBuilder
    //   8598: dup
    //   8599: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   8602: ldc_w 3004
    //   8605: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8608: aload 16
    //   8610: invokevirtual 798	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   8613: ldc_w 2849
    //   8616: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8619: aload 19
    //   8621: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   8624: iconst_0
    //   8625: invokevirtual 116	com/tencent/mobileqq/pb/PBRepeatField:get	(I)Ljava/lang/Object;
    //   8628: checkcast 118	java/lang/String
    //   8631: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8634: ldc_w 604
    //   8637: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8640: aload 19
    //   8642: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   8645: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   8648: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   8651: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8654: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   8657: aload_2
    //   8658: sipush 169
    //   8661: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   8664: checkcast 3006	cooperation/photoplus/PhotoPlusManager
    //   8667: aload 19
    //   8669: getfield 108	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   8672: iconst_0
    //   8673: invokevirtual 116	com/tencent/mobileqq/pb/PBRepeatField:get	(I)Ljava/lang/Object;
    //   8676: checkcast 118	java/lang/String
    //   8679: invokevirtual 3007	cooperation/photoplus/PhotoPlusManager:a	(Ljava/lang/String;)Z
    //   8682: ifeq +3399 -> 12081
    //   8685: aload_0
    //   8686: invokevirtual 47	andt:getAppRuntime	()Lmqq/app/AppRuntime;
    //   8689: invokevirtual 2595	mqq/app/AppRuntime:getApplication	()Lmqq/app/MobileQQ;
    //   8692: aload_0
    //   8693: invokevirtual 47	andt:getAppRuntime	()Lmqq/app/AppRuntime;
    //   8696: invokevirtual 2785	mqq/app/AppRuntime:getAccount	()Ljava/lang/String;
    //   8699: aload 19
    //   8701: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   8704: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   8707: invokestatic 3009	bbkb:r	(Landroid/content/Context;Ljava/lang/String;I)V
    //   8710: goto +3371 -> 12081
    //   8713: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   8716: ifeq +3365 -> 12081
    //   8719: ldc 183
    //   8721: iconst_2
    //   8722: new 85	java/lang/StringBuilder
    //   8725: dup
    //   8726: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   8729: ldc_w 3004
    //   8732: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8735: aload 16
    //   8737: invokevirtual 798	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   8740: ldc_w 3011
    //   8743: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8746: aload 19
    //   8748: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   8751: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   8754: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   8757: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8760: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   8763: goto +3318 -> 12081
    //   8766: aload_0
    //   8767: aload_2
    //   8768: aload 19
    //   8770: invokevirtual 3013	andt:e	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8773: goto +3308 -> 12081
    //   8776: aload_0
    //   8777: aload_3
    //   8778: iload 5
    //   8780: aload 19
    //   8782: aload_1
    //   8783: getfield 2389	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:result	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   8786: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   8789: invokevirtual 3016	andt:a	(Landroid/content/Intent;ZLcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;I)V
    //   8792: goto +3289 -> 12081
    //   8795: aload_0
    //   8796: aload_3
    //   8797: aload 19
    //   8799: invokespecial 3018	andt:c	(Landroid/content/Intent;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8802: goto +3279 -> 12081
    //   8805: aload_0
    //   8806: aload_3
    //   8807: aload 19
    //   8809: invokespecial 3020	andt:b	(Landroid/content/Intent;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8812: goto +3269 -> 12081
    //   8815: aload_0
    //   8816: aload_3
    //   8817: aload 19
    //   8819: invokespecial 3022	andt:d	(Landroid/content/Intent;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8822: goto +3259 -> 12081
    //   8825: aload_0
    //   8826: aload_3
    //   8827: aload 19
    //   8829: invokevirtual 3024	andt:a	(Landroid/content/Intent;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8832: goto +3249 -> 12081
    //   8835: aload_0
    //   8836: aload_2
    //   8837: aload_3
    //   8838: aload 19
    //   8840: invokevirtual 3026	andt:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Landroid/content/Intent;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8843: goto +3238 -> 12081
    //   8846: aload_0
    //   8847: aload_2
    //   8848: aload 19
    //   8850: invokespecial 3028	andt:U	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8853: goto +3228 -> 12081
    //   8856: aload_0
    //   8857: aload_2
    //   8858: aload 19
    //   8860: invokespecial 3030	andt:af	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8863: goto +3218 -> 12081
    //   8866: aload 16
    //   8868: invokevirtual 1829	java/lang/Integer:intValue	()I
    //   8871: aload_2
    //   8872: invokevirtual 1593	com/tencent/mobileqq/app/QQAppInterface:c	()Ljava/lang/String;
    //   8875: aload 19
    //   8877: invokestatic 3033	lcw:a	(ILjava/lang/String;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8880: goto +3201 -> 12081
    //   8883: aload_0
    //   8884: aload_2
    //   8885: aload 19
    //   8887: invokevirtual 3035	andt:d	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8890: goto +3191 -> 12081
    //   8893: aload_0
    //   8894: aload_3
    //   8895: iload 5
    //   8897: aload 19
    //   8899: aload_1
    //   8900: getfield 2389	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:result	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   8903: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   8906: invokevirtual 3037	andt:b	(Landroid/content/Intent;ZLcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;I)V
    //   8909: goto +3172 -> 12081
    //   8912: aload_0
    //   8913: aload_2
    //   8914: aload 19
    //   8916: invokespecial 3039	andt:Z	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8919: goto +3162 -> 12081
    //   8922: aload_0
    //   8923: aload_2
    //   8924: aload 19
    //   8926: invokespecial 3041	andt:V	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8929: goto +3152 -> 12081
    //   8932: aload_0
    //   8933: aload_2
    //   8934: aload 19
    //   8936: invokespecial 3043	andt:W	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8939: goto +3142 -> 12081
    //   8942: aload_0
    //   8943: aload_2
    //   8944: aload 19
    //   8946: invokespecial 3045	andt:X	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8949: goto +3132 -> 12081
    //   8952: aload_0
    //   8953: aload_2
    //   8954: aload 19
    //   8956: invokespecial 3047	andt:Y	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8959: goto +3122 -> 12081
    //   8962: aload_0
    //   8963: aload_2
    //   8964: aload 19
    //   8966: invokevirtual 3049	andt:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8969: goto +3112 -> 12081
    //   8972: aload_0
    //   8973: aload_2
    //   8974: aload 19
    //   8976: invokespecial 3051	andt:ag	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8979: goto +3102 -> 12081
    //   8982: aload_0
    //   8983: aload_2
    //   8984: aload 19
    //   8986: invokespecial 3053	andt:ah	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8989: goto +3092 -> 12081
    //   8992: aload_0
    //   8993: aload_2
    //   8994: aload 19
    //   8996: invokespecial 3055	andt:ai	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8999: goto +3082 -> 12081
    //   9002: aload_0
    //   9003: aload_2
    //   9004: aload 19
    //   9006: invokespecial 3057	andt:aj	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9009: goto +3072 -> 12081
    //   9012: aload 19
    //   9014: invokestatic 3058	awvx:a	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9017: goto +3064 -> 12081
    //   9020: aload_0
    //   9021: aload_2
    //   9022: aload 19
    //   9024: invokespecial 3060	andt:ak	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9027: goto +3054 -> 12081
    //   9030: aload_0
    //   9031: aload_2
    //   9032: aload 19
    //   9034: invokespecial 3063	andt:al	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9037: goto +3044 -> 12081
    //   9040: aload_0
    //   9041: aload_2
    //   9042: aload 19
    //   9044: invokespecial 3065	andt:am	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9047: goto +3034 -> 12081
    //   9050: aload_0
    //   9051: aload_2
    //   9052: aload 19
    //   9054: invokespecial 3068	andt:an	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9057: goto +3024 -> 12081
    //   9060: aload_0
    //   9061: aload_2
    //   9062: aload 19
    //   9064: invokevirtual 3070	andt:f	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9067: goto +3014 -> 12081
    //   9070: aload_0
    //   9071: aload_3
    //   9072: aload 19
    //   9074: invokespecial 3072	andt:m	(Landroid/content/Intent;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9077: goto +3004 -> 12081
    //   9080: aload_0
    //   9081: aload_2
    //   9082: aload 19
    //   9084: invokespecial 3075	andt:ao	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9087: goto +2994 -> 12081
    //   9090: aload_0
    //   9091: aload_2
    //   9092: aload 19
    //   9094: invokevirtual 3077	andt:l	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9097: goto +2984 -> 12081
    //   9100: aload_0
    //   9101: aload_2
    //   9102: aload 19
    //   9104: invokevirtual 3079	andt:i	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9107: goto +2974 -> 12081
    //   9110: aload_2
    //   9111: sipush 208
    //   9114: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   9117: checkcast 1853	vwn
    //   9120: getfield 1856	vwn:a	Lvwm;
    //   9123: aload_2
    //   9124: aload 19
    //   9126: invokevirtual 3082	vwm:a	(Lcom/tencent/common/app/AppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9129: goto +2952 -> 12081
    //   9132: aload_0
    //   9133: aload_2
    //   9134: aload 19
    //   9136: invokevirtual 3084	andt:h	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9139: goto +2942 -> 12081
    //   9142: aload_0
    //   9143: aload_2
    //   9144: aload 19
    //   9146: invokevirtual 3086	andt:j	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9149: goto +2932 -> 12081
    //   9152: aload_0
    //   9153: aload_2
    //   9154: aload 19
    //   9156: invokevirtual 3088	andt:m	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9159: goto +2922 -> 12081
    //   9162: aload_0
    //   9163: aload_2
    //   9164: aload 19
    //   9166: invokevirtual 3090	andt:n	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9169: goto +2912 -> 12081
    //   9172: aload_0
    //   9173: aload_2
    //   9174: aload 19
    //   9176: invokevirtual 3092	andt:o	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9179: goto +2902 -> 12081
    //   9182: aload_0
    //   9183: aload_2
    //   9184: aload 19
    //   9186: invokevirtual 3094	andt:q	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9189: goto +2892 -> 12081
    //   9192: aload_2
    //   9193: aload 19
    //   9195: invokestatic 3095	xbp:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9198: goto +2883 -> 12081
    //   9201: aload_0
    //   9202: aload_2
    //   9203: aload 19
    //   9205: invokespecial 3097	andt:ap	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9208: goto +2873 -> 12081
    //   9211: aload_0
    //   9212: aload_2
    //   9213: aload 19
    //   9215: invokevirtual 3099	andt:p	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9218: goto +2863 -> 12081
    //   9221: aload_0
    //   9222: aload_2
    //   9223: aload 19
    //   9225: invokevirtual 3101	andt:r	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9228: goto +2853 -> 12081
    //   9231: aload_0
    //   9232: aload_2
    //   9233: aload 19
    //   9235: invokevirtual 3103	andt:g	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9238: goto +2843 -> 12081
    //   9241: aload_0
    //   9242: aload_2
    //   9243: aload 19
    //   9245: invokevirtual 3105	andt:s	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9248: goto +2833 -> 12081
    //   9251: aload_0
    //   9252: aload_2
    //   9253: aload 19
    //   9255: invokespecial 3107	andt:aa	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9258: goto +2823 -> 12081
    //   9261: aload_0
    //   9262: aload_2
    //   9263: aload 19
    //   9265: invokespecial 3109	andt:ab	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9268: goto +2813 -> 12081
    //   9271: aload_0
    //   9272: aload_2
    //   9273: aload 19
    //   9275: invokevirtual 3111	andt:k	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9278: goto +2803 -> 12081
    //   9281: aload_0
    //   9282: aload_2
    //   9283: aload 19
    //   9285: invokevirtual 3113	andt:u	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9288: goto +2793 -> 12081
    //   9291: aload_2
    //   9292: aload 19
    //   9294: invokestatic 3115	andt:t	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9297: goto +2784 -> 12081
    //   9300: aload 19
    //   9302: aload_2
    //   9303: invokevirtual 1348	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   9306: invokestatic 1955	ahww:a	(Landroid/content/Context;)I
    //   9309: sipush 199
    //   9312: invokestatic 2277	andt:b	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;II)Ljava/lang/String;
    //   9315: astore 16
    //   9317: aload 16
    //   9319: ifnull +2762 -> 12081
    //   9322: aload_2
    //   9323: invokevirtual 1348	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   9326: aload 16
    //   9328: aload 19
    //   9330: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   9333: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   9336: invokestatic 3116	ahww:a	(Landroid/content/Context;Ljava/lang/String;I)V
    //   9339: goto +2742 -> 12081
    //   9342: aload 19
    //   9344: aload_2
    //   9345: invokevirtual 1348	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   9348: invokestatic 1958	avsf:a	(Landroid/content/Context;)I
    //   9351: sipush 225
    //   9354: invokestatic 2277	andt:b	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;II)Ljava/lang/String;
    //   9357: astore 16
    //   9359: aload 16
    //   9361: ifnull +2720 -> 12081
    //   9364: invokestatic 3119	avsf:a	()Lavsf;
    //   9367: aload_2
    //   9368: invokevirtual 1348	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   9371: aload 16
    //   9373: aload 19
    //   9375: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   9378: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   9381: invokevirtual 3120	avsf:a	(Landroid/content/Context;Ljava/lang/String;I)V
    //   9384: goto +2697 -> 12081
    //   9387: aload_0
    //   9388: aload_2
    //   9389: aload 19
    //   9391: invokevirtual 3122	andt:v	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9394: goto +2687 -> 12081
    //   9397: aload_0
    //   9398: aload_2
    //   9399: aload 19
    //   9401: invokevirtual 3124	andt:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9404: goto +2677 -> 12081
    //   9407: aload_0
    //   9408: aload_2
    //   9409: aload 19
    //   9411: invokespecial 3126	andt:aq	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9414: goto +2667 -> 12081
    //   9417: aload_2
    //   9418: aload 19
    //   9420: invokestatic 3128	andt:w	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9423: goto +2658 -> 12081
    //   9426: aload_2
    //   9427: aload 19
    //   9429: invokestatic 3130	andt:O	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9432: goto +2649 -> 12081
    //   9435: aload_2
    //   9436: aload 19
    //   9438: invokestatic 3132	andt:P	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9441: goto +2640 -> 12081
    //   9444: aload_0
    //   9445: aload_2
    //   9446: aload 19
    //   9448: aload_3
    //   9449: ldc_w 2266
    //   9452: invokevirtual 1400	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   9455: invokespecial 3134	andt:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;Ljava/lang/String;)I
    //   9458: invokestatic 3135	com/tencent/mobileqq/shortvideo/ShortVideoResourceManager:b	(I)V
    //   9461: goto +2620 -> 12081
    //   9464: aload_2
    //   9465: sipush 238
    //   9468: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   9471: checkcast 3137	njf
    //   9474: astore 16
    //   9476: aload 16
    //   9478: ifnull +2603 -> 12081
    //   9481: aload 16
    //   9483: aload_2
    //   9484: aload 19
    //   9486: invokevirtual 3138	njf:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9489: goto +2592 -> 12081
    //   9492: aload_0
    //   9493: aload_2
    //   9494: aload 19
    //   9496: invokevirtual 3140	andt:y	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9499: goto +2582 -> 12081
    //   9502: aload_0
    //   9503: aload_2
    //   9504: aload 19
    //   9506: invokespecial 3142	andt:T	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9509: goto +2572 -> 12081
    //   9512: aload_2
    //   9513: sipush 231
    //   9516: getstatic 15	andt:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   9519: aload 19
    //   9521: invokestatic 3145	ahzb:a	(Lcom/tencent/mobileqq/app/QQAppInterface;ILjava/lang/String;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9524: goto +2557 -> 12081
    //   9527: aload_0
    //   9528: aload_2
    //   9529: aload 19
    //   9531: invokevirtual 3147	andt:x	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9534: goto +2547 -> 12081
    //   9537: aload_0
    //   9538: aload_2
    //   9539: aload 19
    //   9541: invokevirtual 3149	andt:F	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9544: goto +2537 -> 12081
    //   9547: aload_0
    //   9548: aload_2
    //   9549: aload 19
    //   9551: invokevirtual 3151	andt:z	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9554: goto +2527 -> 12081
    //   9557: aload_0
    //   9558: aload_2
    //   9559: aload 19
    //   9561: invokevirtual 3153	andt:A	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9564: goto +2517 -> 12081
    //   9567: aload_0
    //   9568: aload_2
    //   9569: aload 19
    //   9571: invokevirtual 3155	andt:B	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9574: goto +2507 -> 12081
    //   9577: aload 19
    //   9579: ifnull +2600 -> 12179
    //   9582: aload 19
    //   9584: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   9587: ifnonnull +4 -> 9591
    //   9590: return
    //   9591: aload 19
    //   9593: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   9596: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   9599: aload_2
    //   9600: invokevirtual 65	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   9603: invokestatic 2010	bbkb:d	(Landroid/content/Context;)I
    //   9606: if_icmpeq +2573 -> 12179
    //   9609: aconst_null
    //   9610: astore 17
    //   9612: aload 17
    //   9614: astore 16
    //   9616: aload 19
    //   9618: getfield 221	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   9621: ifnull +79 -> 9700
    //   9624: aload 17
    //   9626: astore 16
    //   9628: aload 19
    //   9630: getfield 221	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   9633: invokevirtual 224	com/tencent/mobileqq/pb/PBRepeatMessageField:size	()I
    //   9636: ifle +64 -> 9700
    //   9639: aload 19
    //   9641: getfield 221	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   9644: iconst_0
    //   9645: invokevirtual 318	com/tencent/mobileqq/pb/PBRepeatMessageField:get	(I)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   9648: checkcast 244	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content
    //   9651: astore 16
    //   9653: aload 16
    //   9655: getfield 248	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content:compress	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   9658: invokevirtual 251	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   9661: iconst_1
    //   9662: if_icmpne +114 -> 9776
    //   9665: aload 16
    //   9667: getfield 255	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content:content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   9670: invokevirtual 260	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   9673: invokevirtual 266	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   9676: invokestatic 321	augv:a	([B)[B
    //   9679: astore 17
    //   9681: aload 17
    //   9683: ifnull +2370 -> 12053
    //   9686: new 118	java/lang/String
    //   9689: dup
    //   9690: aload 17
    //   9692: ldc_w 323
    //   9695: invokespecial 326	java/lang/String:<init>	([BLjava/lang/String;)V
    //   9698: astore 16
    //   9700: aload 16
    //   9702: ifnull +33 -> 9735
    //   9705: new 128	org/json/JSONObject
    //   9708: dup
    //   9709: aload 16
    //   9711: invokespecial 131	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   9714: invokestatic 3158	zzn:a	(Lorg/json/JSONObject;)V
    //   9717: aload_0
    //   9718: invokevirtual 47	andt:getAppRuntime	()Lmqq/app/AppRuntime;
    //   9721: invokevirtual 2595	mqq/app/AppRuntime:getApplication	()Lmqq/app/MobileQQ;
    //   9724: aload 19
    //   9726: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   9729: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   9732: invokestatic 3160	bbkb:c	(Landroid/content/Context;I)V
    //   9735: goto +2346 -> 12081
    //   9738: astore 16
    //   9740: aconst_null
    //   9741: astore 16
    //   9743: goto -43 -> 9700
    //   9746: astore 16
    //   9748: invokestatic 2613	java/lang/System:gc	()V
    //   9751: new 118	java/lang/String
    //   9754: dup
    //   9755: aload 17
    //   9757: ldc_w 323
    //   9760: invokespecial 326	java/lang/String:<init>	([BLjava/lang/String;)V
    //   9763: astore 16
    //   9765: goto -65 -> 9700
    //   9768: astore 16
    //   9770: aconst_null
    //   9771: astore 16
    //   9773: goto -73 -> 9700
    //   9776: aload 16
    //   9778: getfield 255	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content:content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   9781: invokevirtual 260	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   9784: invokevirtual 280	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   9787: astore 16
    //   9789: goto -89 -> 9700
    //   9792: astore 16
    //   9794: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   9797: ifeq +2383 -> 12180
    //   9800: ldc 183
    //   9802: iconst_2
    //   9803: aload 16
    //   9805: iconst_0
    //   9806: anewarray 301	java/lang/Object
    //   9809: invokestatic 3162	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   9812: goto +2368 -> 12180
    //   9815: aload_0
    //   9816: aload_2
    //   9817: aload 19
    //   9819: invokevirtual 3164	andt:C	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9822: goto +2259 -> 12081
    //   9825: aload_0
    //   9826: aload_2
    //   9827: aload 19
    //   9829: invokevirtual 3166	andt:D	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9832: goto +2249 -> 12081
    //   9835: aload_0
    //   9836: aload_2
    //   9837: aload 19
    //   9839: invokevirtual 3168	andt:E	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9842: goto +2239 -> 12081
    //   9845: aload_0
    //   9846: aload_2
    //   9847: aload 19
    //   9849: invokespecial 3170	andt:ac	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9852: goto +2229 -> 12081
    //   9855: aload_0
    //   9856: aload_2
    //   9857: aload 19
    //   9859: invokespecial 3172	andt:ad	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9862: goto +2219 -> 12081
    //   9865: aload_0
    //   9866: aload_2
    //   9867: aload 19
    //   9869: invokespecial 3174	andt:S	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9872: goto +2209 -> 12081
    //   9875: aload_0
    //   9876: aload_2
    //   9877: aload 19
    //   9879: invokevirtual 3176	andt:G	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9882: goto +2199 -> 12081
    //   9885: aload_2
    //   9886: aload 19
    //   9888: invokestatic 3179	badx:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9891: goto +2190 -> 12081
    //   9894: aload_2
    //   9895: bipush 52
    //   9897: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   9900: checkcast 2027	com/tencent/mobileqq/app/TroopManager
    //   9903: getfield 2030	com/tencent/mobileqq/app/TroopManager:jdField_a_of_type_Azwm	Lazwm;
    //   9906: aload_2
    //   9907: aload 19
    //   9909: invokevirtual 3180	azwm:a	(Lcom/tencent/common/app/AppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9912: goto +2169 -> 12081
    //   9915: aload_2
    //   9916: bipush 52
    //   9918: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   9921: checkcast 2027	com/tencent/mobileqq/app/TroopManager
    //   9924: getfield 2038	com/tencent/mobileqq/app/TroopManager:jdField_a_of_type_Azyq	Lazyq;
    //   9927: aload_2
    //   9928: aload 19
    //   9930: invokevirtual 3181	azyq:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9933: goto +2148 -> 12081
    //   9936: aload_2
    //   9937: invokestatic 3186	ssr:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)Lssr;
    //   9940: aload 19
    //   9942: invokevirtual 3187	ssr:a	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9945: goto +2136 -> 12081
    //   9948: aload_2
    //   9949: sipush 197
    //   9952: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   9955: checkcast 3189	stc
    //   9958: aload 19
    //   9960: invokevirtual 3190	stc:a	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9963: goto +2118 -> 12081
    //   9966: invokestatic 2049	aqwf:a	()Laqwf;
    //   9969: getfield 2052	aqwf:a	Laqwh;
    //   9972: aload 19
    //   9974: invokevirtual 3191	aqwh:a	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9977: goto +2104 -> 12081
    //   9980: astore 16
    //   9982: aload 16
    //   9984: invokevirtual 1833	java/lang/Throwable:printStackTrace	()V
    //   9987: goto +2094 -> 12081
    //   9990: aload_2
    //   9991: aload 19
    //   9993: invokestatic 3194	com/tencent/mobileqq/shortvideo/util/RecentDanceConfigMgr:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)I
    //   9996: pop
    //   9997: goto +2084 -> 12081
    //   10000: aload_2
    //   10001: aload 19
    //   10003: invokestatic 3195	dov/com/qq/im/ptv/LightVideoConfigMgr:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)I
    //   10006: pop
    //   10007: goto +2074 -> 12081
    //   10010: aload_0
    //   10011: aload_2
    //   10012: aload 19
    //   10014: invokevirtual 3197	andt:H	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   10017: goto +2064 -> 12081
    //   10020: aload_0
    //   10021: aload_2
    //   10022: aload 19
    //   10024: invokevirtual 3199	andt:I	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   10027: goto +2054 -> 12081
    //   10030: aload_0
    //   10031: aload_2
    //   10032: aload 19
    //   10034: invokevirtual 3201	andt:J	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   10037: goto +2044 -> 12081
    //   10040: aload_2
    //   10041: aload 19
    //   10043: aload 16
    //   10045: invokevirtual 1829	java/lang/Integer:intValue	()I
    //   10048: getstatic 15	andt:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   10051: invokestatic 3206	axqv:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;ILjava/lang/String;)V
    //   10054: goto +2027 -> 12081
    //   10057: aload_0
    //   10058: aload_2
    //   10059: aload 19
    //   10061: invokevirtual 3209	andt:M	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   10064: goto +2017 -> 12081
    //   10067: aload_2
    //   10068: aload 16
    //   10070: invokevirtual 1829	java/lang/Integer:intValue	()I
    //   10073: aload 19
    //   10075: invokestatic 3214	ankf:a	(Lcom/tencent/mobileqq/app/QQAppInterface;ILcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   10078: goto +2003 -> 12081
    //   10081: aload_2
    //   10082: invokestatic 3219	apzf:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)Lapzf;
    //   10085: aload_2
    //   10086: aload 16
    //   10088: aload 19
    //   10090: invokevirtual 3222	apzf:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/Integer;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   10093: goto +1988 -> 12081
    //   10096: aload_0
    //   10097: aload_2
    //   10098: aload 19
    //   10100: invokevirtual 3224	andt:K	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   10103: goto +1978 -> 12081
    //   10106: aload_0
    //   10107: aload_2
    //   10108: aload 19
    //   10110: invokevirtual 3226	andt:L	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   10113: goto +1968 -> 12081
    //   10116: aload_2
    //   10117: sipush 181
    //   10120: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   10123: checkcast 2093	sst
    //   10126: getfield 2096	sst:a	Ltbk;
    //   10129: aload_2
    //   10130: aload 19
    //   10132: invokevirtual 3227	tbk:a	(Lcom/tencent/common/app/AppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   10135: goto +1946 -> 12081
    //   10138: aload_0
    //   10139: aload_2
    //   10140: aload 19
    //   10142: invokespecial 3229	andt:R	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   10145: goto +1936 -> 12081
    //   10148: aload_2
    //   10149: aload 19
    //   10151: invokestatic 3231	andt:c	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   10154: goto +1927 -> 12081
    //   10157: aload_2
    //   10158: aload 16
    //   10160: invokevirtual 1829	java/lang/Integer:intValue	()I
    //   10163: aload 19
    //   10165: invokestatic 3234	bcwb:a	(Lcom/tencent/mobileqq/app/QQAppInterface;ILcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   10168: goto +1913 -> 12081
    //   10171: aload_2
    //   10172: bipush 52
    //   10174: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   10177: checkcast 2027	com/tencent/mobileqq/app/TroopManager
    //   10180: getfield 2112	com/tencent/mobileqq/app/TroopManager:jdField_a_of_type_Xbl	Lxbl;
    //   10183: aload_2
    //   10184: aload 19
    //   10186: invokevirtual 3235	xbl:a	(Lcom/tencent/common/app/AppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   10189: goto +1892 -> 12081
    //   10192: aload_0
    //   10193: aload_2
    //   10194: aload 19
    //   10196: aload 16
    //   10198: invokevirtual 1829	java/lang/Integer:intValue	()I
    //   10201: invokespecial 3236	andt:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;I)V
    //   10204: goto +1877 -> 12081
    //   10207: aload_2
    //   10208: aload 19
    //   10210: invokestatic 3238	andt:N	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   10213: goto +1868 -> 12081
    //   10216: aload_0
    //   10217: aload_2
    //   10218: aload 19
    //   10220: invokespecial 3240	andt:Q	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   10223: goto +1858 -> 12081
    //   10226: aload_2
    //   10227: sipush 306
    //   10230: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   10233: checkcast 3242	arik
    //   10236: aload 19
    //   10238: invokevirtual 3243	arik:a	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   10241: goto +1840 -> 12081
    //   10244: aload_0
    //   10245: aload 19
    //   10247: invokespecial 3245	andt:C	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   10250: goto +1831 -> 12081
    //   10253: aload_2
    //   10254: sipush 236
    //   10257: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   10260: checkcast 3247	arfg
    //   10263: aload 19
    //   10265: invokevirtual 3248	arfg:a	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   10268: goto +1813 -> 12081
    //   10271: aload_0
    //   10272: aload_2
    //   10273: aload 19
    //   10275: invokespecial 3251	andt:ar	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   10278: goto +1803 -> 12081
    //   10281: aload_0
    //   10282: aload_2
    //   10283: aload 19
    //   10285: aload 16
    //   10287: invokevirtual 1829	java/lang/Integer:intValue	()I
    //   10290: invokespecial 3253	andt:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;I)V
    //   10293: goto +1788 -> 12081
    //   10296: aload_0
    //   10297: aload_2
    //   10298: aload 19
    //   10300: invokespecial 3255	andt:as	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   10303: goto +1778 -> 12081
    //   10306: aload 4
    //   10308: ifnull +309 -> 10617
    //   10311: iload 10
    //   10313: ifne +32 -> 10345
    //   10316: aload_2
    //   10317: invokevirtual 65	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   10320: ldc_w 2599
    //   10323: invokestatic 2602	bbfr:a	(Landroid/content/Context;Ljava/lang/String;)Z
    //   10326: ifne +19 -> 10345
    //   10329: aload_2
    //   10330: sipush 256
    //   10333: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   10336: checkcast 3257	com/tencent/mobileqq/app/upgrade/UpgradeTIMManager
    //   10339: aload_2
    //   10340: aload 4
    //   10342: invokevirtual 3258	com/tencent/mobileqq/app/upgrade/UpgradeTIMManager:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/app/upgrade/UpgradeTIMWrapper;)V
    //   10345: invokestatic 2571	java/lang/System:currentTimeMillis	()J
    //   10348: lstore 14
    //   10350: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   10353: ifeq +44 -> 10397
    //   10356: ldc 183
    //   10358: iconst_2
    //   10359: new 85	java/lang/StringBuilder
    //   10362: dup
    //   10363: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   10366: ldc_w 3260
    //   10369: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10372: lload 14
    //   10374: lload 12
    //   10376: lsub
    //   10377: invokevirtual 3263	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   10380: ldc_w 3265
    //   10383: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10386: iload 10
    //   10388: invokevirtual 152	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   10391: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   10394: invokestatic 373	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   10397: aconst_null
    //   10398: astore 4
    //   10400: aload_3
    //   10401: ifnull +1640 -> 12041
    //   10404: aload_3
    //   10405: ldc_w 2299
    //   10408: iconst_0
    //   10409: invokevirtual 2235	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   10412: istore 10
    //   10414: iload 10
    //   10416: ifeq +220 -> 10636
    //   10419: aload_3
    //   10420: ldc_w 3267
    //   10423: iconst_0
    //   10424: invokevirtual 3270	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   10427: istore 8
    //   10429: ldc 183
    //   10431: iconst_2
    //   10432: iconst_2
    //   10433: anewarray 301	java/lang/Object
    //   10436: dup
    //   10437: iconst_0
    //   10438: ldc_w 3272
    //   10441: aastore
    //   10442: dup
    //   10443: iconst_1
    //   10444: iload 8
    //   10446: invokestatic 305	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   10449: aastore
    //   10450: invokestatic 1662	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   10453: iload 8
    //   10455: istore 6
    //   10457: iload 10
    //   10459: istore 5
    //   10461: aload 4
    //   10463: astore_3
    //   10464: iload 8
    //   10466: iconst_3
    //   10467: if_icmpge +179 -> 10646
    //   10470: aload_1
    //   10471: getfield 3275	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:next_req_types	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   10474: invokevirtual 1147	com/tencent/mobileqq/pb/PBRepeatField:get	()Ljava/util/List;
    //   10477: astore 16
    //   10479: iload 8
    //   10481: istore 6
    //   10483: iload 10
    //   10485: istore 5
    //   10487: aload 4
    //   10489: astore_3
    //   10490: aload 16
    //   10492: ifnull +154 -> 10646
    //   10495: iload 8
    //   10497: istore 6
    //   10499: iload 10
    //   10501: istore 5
    //   10503: aload 4
    //   10505: astore_3
    //   10506: aload 16
    //   10508: invokeinterface 400 1 0
    //   10513: ifle +133 -> 10646
    //   10516: aload 16
    //   10518: invokeinterface 400 1 0
    //   10523: newarray int
    //   10525: astore 4
    //   10527: aload 16
    //   10529: invokeinterface 400 1 0
    //   10534: istore 9
    //   10536: iconst_0
    //   10537: istore 7
    //   10539: iload 8
    //   10541: istore 6
    //   10543: iload 10
    //   10545: istore 5
    //   10547: aload 4
    //   10549: astore_3
    //   10550: iload 7
    //   10552: iload 9
    //   10554: if_icmpge +92 -> 10646
    //   10557: aload 16
    //   10559: iload 7
    //   10561: invokeinterface 447 2 0
    //   10566: checkcast 139	java/lang/Integer
    //   10569: invokevirtual 1829	java/lang/Integer:intValue	()I
    //   10572: istore 6
    //   10574: aload 4
    //   10576: iload 7
    //   10578: iload 6
    //   10580: iastore
    //   10581: aload 18
    //   10583: invokeinterface 400 1 0
    //   10588: ifle +20 -> 10608
    //   10591: aload 18
    //   10593: new 139	java/lang/Integer
    //   10596: dup
    //   10597: iload 6
    //   10599: invokespecial 2574	java/lang/Integer:<init>	(I)V
    //   10602: invokeinterface 2576 2 0
    //   10607: pop
    //   10608: iload 7
    //   10610: iconst_1
    //   10611: iadd
    //   10612: istore 7
    //   10614: goto -75 -> 10539
    //   10617: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   10620: ifeq -275 -> 10345
    //   10623: ldc_w 1787
    //   10626: iconst_2
    //   10627: ldc_w 3277
    //   10630: invokestatic 199	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   10633: goto -288 -> 10345
    //   10636: iconst_0
    //   10637: istore 6
    //   10639: aload 4
    //   10641: astore_3
    //   10642: iload 10
    //   10644: istore 5
    //   10646: aload 18
    //   10648: invokeinterface 233 1 0
    //   10653: astore 4
    //   10655: aload 4
    //   10657: invokeinterface 238 1 0
    //   10662: ifeq +1174 -> 11836
    //   10665: aload 4
    //   10667: invokeinterface 242 1 0
    //   10672: checkcast 139	java/lang/Integer
    //   10675: astore 16
    //   10677: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   10680: ifeq +46 -> 10726
    //   10683: ldc 183
    //   10685: iconst_2
    //   10686: new 85	java/lang/StringBuilder
    //   10689: dup
    //   10690: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   10693: ldc_w 3279
    //   10696: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10699: aload 16
    //   10701: invokevirtual 798	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   10704: ldc_w 2139
    //   10707: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10710: aload 18
    //   10712: invokeinterface 400 1 0
    //   10717: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   10720: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   10723: invokestatic 373	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   10726: aload 16
    //   10728: invokevirtual 1829	java/lang/Integer:intValue	()I
    //   10731: lookupswitch	default:+193->10924, 1:+651->11382, 38:+597->11328, 42:+930->11661, 46:+590->11321, 86:+884->11615, 87:+786->11517, 113:+938->11669, 116:+224->10955, 119:+1000->11731, 156:+-76->10655, 185:+1026->11757, 188:+829->11560, 191:+1054->11785, 202:+1035->11766, 205:+866->11597, 206:+848->11579, 215:+1070->11801, 223:+984->11715, 231:+1076->11807, 297:+1090->11821, 345:+1097->11828, 364:+984->11715, 365:+984->11715
    //   10925: iconst_2
    //   10926: ldc_w 6416
    //   10929: invokevirtual 1829	java/lang/Integer:intValue	()I
    //   10932: invokevirtual 1302	ampl:b	(I)Z
    //   10935: ifeq -280 -> 10655
    //   10938: invokestatic 1299	ampl:a	()Lampl;
    //   10941: aload 16
    //   10943: invokevirtual 1829	java/lang/Integer:intValue	()I
    //   10946: getstatic 15	andt:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   10949: invokevirtual 3280	ampl:a	(ILjava/lang/String;)V
    //   10952: goto -297 -> 10655
    //   10955: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   10958: ifeq +12 -> 10970
    //   10961: ldc 183
    //   10963: iconst_2
    //   10964: ldc_w 3282
    //   10967: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   10970: aload_2
    //   10971: iconst_4
    //   10972: invokevirtual 206	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lajtb;
    //   10975: checkcast 1781	ajud
    //   10978: astore 17
    //   10980: ldc_w 2626
    //   10983: getstatic 15	andt:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   10986: invokestatic 3284	akux:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   10989: astore 19
    //   10991: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   10994: ifeq +30 -> 11024
    //   10997: ldc 183
    //   10999: iconst_2
    //   11000: new 85	java/lang/StringBuilder
    //   11003: dup
    //   11004: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   11007: ldc_w 2670
    //   11010: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11013: aload 19
    //   11015: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11018: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   11021: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   11024: aload 19
    //   11026: invokestatic 126	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   11029: ifeq +53 -> 11082
    //   11032: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11035: ifeq +12 -> 11047
    //   11038: ldc 183
    //   11040: iconst_2
    //   11041: ldc_w 3286
    //   11044: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   11047: aload_2
    //   11048: invokevirtual 65	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   11051: getstatic 15	andt:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   11054: iconst_0
    //   11055: invokestatic 2633	bbkb:p	(Landroid/content/Context;Ljava/lang/String;I)V
    //   11058: ldc_w 2626
    //   11061: getstatic 15	andt:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   11064: invokestatic 2631	akux:a	(Ljava/lang/String;Ljava/lang/String;)Z
    //   11067: pop
    //   11068: aload 17
    //   11070: invokestatic 2425	akuz:a	()Lakuz;
    //   11073: invokevirtual 2428	akuz:a	()Lcom/tencent/mobileqq/app/upgrade/UpgradeDetailWrapper;
    //   11076: invokevirtual 2431	ajud:a	(Lcom/tencent/mobileqq/app/upgrade/UpgradeDetailWrapper;)V
    //   11079: goto -424 -> 10655
    //   11082: invokestatic 2425	akuz:a	()Lakuz;
    //   11085: invokevirtual 2428	akuz:a	()Lcom/tencent/mobileqq/app/upgrade/UpgradeDetailWrapper;
    //   11088: astore 16
    //   11090: aload 16
    //   11092: aload 19
    //   11094: invokevirtual 2636	com/tencent/mobileqq/app/upgrade/UpgradeDetailWrapper:a	(Ljava/lang/String;)V
    //   11097: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11100: ifeq +42 -> 11142
    //   11103: ldc 183
    //   11105: iconst_2
    //   11106: ldc_w 2638
    //   11109: iconst_2
    //   11110: anewarray 301	java/lang/Object
    //   11113: dup
    //   11114: iconst_0
    //   11115: invokestatic 203	com/tencent/common/config/AppSetting:a	()I
    //   11118: invokestatic 305	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   11121: aastore
    //   11122: dup
    //   11123: iconst_1
    //   11124: aload 16
    //   11126: getfield 2641	com/tencent/mobileqq/app/upgrade/UpgradeDetailWrapper:jdField_b_of_type_ProtocolKQQConfigUpgradeInfo	Lprotocol/KQQConfig/UpgradeInfo;
    //   11129: getfield 2646	protocol/KQQConfig/UpgradeInfo:iUpgradeSdkId	I
    //   11132: invokestatic 305	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   11135: aastore
    //   11136: invokestatic 309	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   11139: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   11142: invokestatic 203	com/tencent/common/config/AppSetting:a	()I
    //   11145: aload 16
    //   11147: getfield 2641	com/tencent/mobileqq/app/upgrade/UpgradeDetailWrapper:jdField_b_of_type_ProtocolKQQConfigUpgradeInfo	Lprotocol/KQQConfig/UpgradeInfo;
    //   11150: getfield 2646	protocol/KQQConfig/UpgradeInfo:iUpgradeSdkId	I
    //   11153: if_icmplt +63 -> 11216
    //   11156: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11159: ifeq +12 -> 11171
    //   11162: ldc 183
    //   11164: iconst_2
    //   11165: ldc_w 3288
    //   11168: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   11171: aload_2
    //   11172: invokevirtual 65	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   11175: getstatic 15	andt:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   11178: iconst_0
    //   11179: invokestatic 2633	bbkb:p	(Landroid/content/Context;Ljava/lang/String;I)V
    //   11182: ldc_w 2626
    //   11185: getstatic 15	andt:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   11188: invokestatic 2631	akux:a	(Ljava/lang/String;Ljava/lang/String;)Z
    //   11191: pop
    //   11192: aload 16
    //   11194: getfield 2641	com/tencent/mobileqq/app/upgrade/UpgradeDetailWrapper:jdField_b_of_type_ProtocolKQQConfigUpgradeInfo	Lprotocol/KQQConfig/UpgradeInfo;
    //   11197: iconst_0
    //   11198: putfield 2667	protocol/KQQConfig/UpgradeInfo:iUpgradeType	I
    //   11201: aload 17
    //   11203: aload 16
    //   11205: invokevirtual 2431	ajud:a	(Lcom/tencent/mobileqq/app/upgrade/UpgradeDetailWrapper;)V
    //   11208: aload 17
    //   11210: invokevirtual 2668	ajud:c	()V
    //   11213: goto -558 -> 10655
    //   11216: aload 16
    //   11218: monitorenter
    //   11219: aload 16
    //   11221: getfield 2678	com/tencent/mobileqq/app/upgrade/UpgradeDetailWrapper:jdField_a_of_type_Boolean	Z
    //   11224: ifne +30 -> 11254
    //   11227: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11230: ifeq +12 -> 11242
    //   11233: ldc 183
    //   11235: iconst_2
    //   11236: ldc_w 2680
    //   11239: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   11242: aload 16
    //   11244: monitorexit
    //   11245: goto -590 -> 10655
    //   11248: astore_1
    //   11249: aload 16
    //   11251: monitorexit
    //   11252: aload_1
    //   11253: athrow
    //   11254: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11257: ifeq +12 -> 11269
    //   11260: ldc 183
    //   11262: iconst_2
    //   11263: ldc_w 2682
    //   11266: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   11269: aload 16
    //   11271: getfield 2684	com/tencent/mobileqq/app/upgrade/UpgradeDetailWrapper:jdField_b_of_type_Int	I
    //   11274: ifne +21 -> 11295
    //   11277: aload 16
    //   11279: getfield 2685	com/tencent/mobileqq/app/upgrade/UpgradeDetailWrapper:jdField_a_of_type_Int	I
    //   11282: iconst_1
    //   11283: if_icmpne +32 -> 11315
    //   11286: iconst_1
    //   11287: istore 10
    //   11289: aload_2
    //   11290: iload 10
    //   11292: invokestatic 2686	ajud:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Z)V
    //   11295: invokestatic 2425	akuz:a	()Lakuz;
    //   11298: aload 16
    //   11300: getfield 2641	com/tencent/mobileqq/app/upgrade/UpgradeDetailWrapper:jdField_b_of_type_ProtocolKQQConfigUpgradeInfo	Lprotocol/KQQConfig/UpgradeInfo;
    //   11303: aload 17
    //   11305: invokevirtual 2689	akuz:a	(Lprotocol/KQQConfig/UpgradeInfo;Lakvb;)Z
    //   11308: pop
    //   11309: aload 16
    //   11311: monitorexit
    //   11312: goto -657 -> 10655
    //   11315: iconst_0
    //   11316: istore 10
    //   11318: goto -29 -> 11289
    //   11321: aload_2
    //   11322: invokestatic 2449	zck:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   11325: goto -670 -> 10655
    //   11328: aload_2
    //   11329: invokevirtual 411	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   11332: invokestatic 3291	bbkb:b	(Ljava/lang/String;)Landroid/content/SharedPreferences;
    //   11335: astore 16
    //   11337: aload 16
    //   11339: invokeinterface 346 1 0
    //   11344: ldc_w 3293
    //   11347: invokeinterface 382 2 0
    //   11352: invokeinterface 726 1 0
    //   11357: pop
    //   11358: aload 16
    //   11360: invokeinterface 346 1 0
    //   11365: ldc_w 3295
    //   11368: invokeinterface 382 2 0
    //   11373: invokeinterface 726 1 0
    //   11378: pop
    //   11379: goto -724 -> 10655
    //   11382: new 85	java/lang/StringBuilder
    //   11385: dup
    //   11386: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   11389: aload_0
    //   11390: invokevirtual 47	andt:getAppRuntime	()Lmqq/app/AppRuntime;
    //   11393: invokevirtual 2595	mqq/app/AppRuntime:getApplication	()Lmqq/app/MobileQQ;
    //   11396: invokevirtual 2722	mqq/app/MobileQQ:getFilesDir	()Ljava/io/File;
    //   11399: invokevirtual 2725	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   11402: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11405: ldc_w 3297
    //   11408: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11411: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   11414: astore 16
    //   11416: new 2716	java/io/File
    //   11419: dup
    //   11420: aload 16
    //   11422: invokespecial 2728	java/io/File:<init>	(Ljava/lang/String;)V
    //   11425: astore 17
    //   11427: aload 17
    //   11429: ifnull -774 -> 10655
    //   11432: aload 17
    //   11434: invokevirtual 2731	java/io/File:exists	()Z
    //   11437: ifeq -782 -> 10655
    //   11440: aload 17
    //   11442: invokevirtual 2744	java/io/File:isDirectory	()Z
    //   11445: ifeq -790 -> 10655
    //   11448: aload 17
    //   11450: invokevirtual 2748	java/io/File:listFiles	()[Ljava/io/File;
    //   11453: astore 17
    //   11455: aload 17
    //   11457: ifnull -802 -> 10655
    //   11460: aload 17
    //   11462: arraylength
    //   11463: istore 8
    //   11465: iconst_0
    //   11466: istore 7
    //   11468: iload 7
    //   11470: iload 8
    //   11472: if_icmpge -817 -> 10655
    //   11475: aload 17
    //   11477: iload 7
    //   11479: aaload
    //   11480: astore 19
    //   11482: aload 19
    //   11484: ifnonnull +12 -> 11496
    //   11487: iload 7
    //   11489: iconst_1
    //   11490: iadd
    //   11491: istore 7
    //   11493: goto -25 -> 11468
    //   11496: new 3299	com/tencent/mobileqq/config/splashlogo/ConfigServlet$1
    //   11499: dup
    //   11500: aload_0
    //   11501: aload 19
    //   11503: aload 16
    //   11505: invokespecial 3302	com/tencent/mobileqq/config/splashlogo/ConfigServlet$1:<init>	(Landt;Ljava/io/File;Ljava/lang/String;)V
    //   11508: iconst_5
    //   11509: aconst_null
    //   11510: iconst_1
    //   11511: invokestatic 3308	com/tencent/mobileqq/app/ThreadManager:post	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   11514: goto -27 -> 11487
    //   11517: aload_2
    //   11518: sipush 168
    //   11521: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   11524: checkcast 1682	alch
    //   11527: astore 16
    //   11529: aload 16
    //   11531: ifnull +10 -> 11541
    //   11534: aload 16
    //   11536: iconst_1
    //   11537: iconst_0
    //   11538: invokevirtual 2489	alch:a	(ZZ)V
    //   11541: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11544: ifeq -889 -> 10655
    //   11547: ldc_w 1709
    //   11550: iconst_2
    //   11551: ldc_w 3310
    //   11554: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   11557: goto -902 -> 10655
    //   11560: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11563: ifeq -908 -> 10655
    //   11566: ldc_w 3312
    //   11569: iconst_2
    //   11570: ldc_w 3314
    //   11573: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   11576: goto -921 -> 10655
    //   11579: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11582: ifeq -927 -> 10655
    //   11585: ldc 183
    //   11587: iconst_2
    //   11588: ldc_w 3316
    //   11591: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   11594: goto -939 -> 10655
    //   11597: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11600: ifeq -945 -> 10655
    //   11603: ldc 183
    //   11605: iconst_2
    //   11606: ldc_w 3318
    //   11609: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   11612: goto -957 -> 10655
    //   11615: aload_2
    //   11616: sipush 167
    //   11619: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   11622: checkcast 1645	com/tencent/mobileqq/olympic/OlympicManager
    //   11625: astore 16
    //   11627: aload 16
    //   11629: ifnull +13 -> 11642
    //   11632: aload 16
    //   11634: invokevirtual 2497	com/tencent/mobileqq/olympic/OlympicManager:f	()V
    //   11637: aload 16
    //   11639: invokevirtual 2499	com/tencent/mobileqq/olympic/OlympicManager:g	()V
    //   11642: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11645: ifeq -990 -> 10655
    //   11648: ldc_w 1669
    //   11651: iconst_2
    //   11652: ldc_w 3320
    //   11655: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   11658: goto -1003 -> 10655
    //   11661: aload_0
    //   11662: aconst_null
    //   11663: invokespecial 2951	andt:p	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   11666: goto -1011 -> 10655
    //   11669: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11672: ifeq +12 -> 11684
    //   11675: ldc 183
    //   11677: iconst_2
    //   11678: ldc_w 2506
    //   11681: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   11684: aload_2
    //   11685: sipush 179
    //   11688: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   11691: checkcast 2508	aurv
    //   11694: astore 16
    //   11696: aload 16
    //   11698: ifnull -1043 -> 10655
    //   11701: aload 16
    //   11703: invokevirtual 2509	aurv:a	()V
    //   11706: aload 16
    //   11708: iconst_1
    //   11709: invokevirtual 2510	aurv:a	(Z)V
    //   11712: goto -1057 -> 10655
    //   11715: aload_2
    //   11716: invokestatic 1517	com/tencent/mobileqq/utils/BusinessCommonConfig:getInstance	(Lmqq/app/AppRuntime;)Lcom/tencent/mobileqq/utils/BusinessCommonConfig;
    //   11719: aload_2
    //   11720: aload 16
    //   11722: invokevirtual 1829	java/lang/Integer:intValue	()I
    //   11725: invokevirtual 3323	com/tencent/mobileqq/utils/BusinessCommonConfig:handleResp_Config_NoResp	(Lcom/tencent/mobileqq/app/QQAppInterface;I)V
    //   11728: goto -1073 -> 10655
    //   11731: aload_2
    //   11732: bipush 53
    //   11734: invokevirtual 206	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lajtb;
    //   11737: checkcast 1793	ajsi
    //   11740: astore 16
    //   11742: aload 16
    //   11744: ifnull -1089 -> 10655
    //   11747: aload 16
    //   11749: iconst_0
    //   11750: iconst_0
    //   11751: invokevirtual 2504	ajsi:a	(ZZ)V
    //   11754: goto -1099 -> 10655
    //   11757: invokestatic 2550	com/tencent/mobileqq/scribble/ScribbleResMgr:a	()Lcom/tencent/mobileqq/scribble/ScribbleResMgr;
    //   11760: invokevirtual 3324	com/tencent/mobileqq/scribble/ScribbleResMgr:a	()V
    //   11763: goto -1108 -> 10655
    //   11766: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11769: ifeq -1114 -> 10655
    //   11772: ldc_w 2340
    //   11775: iconst_2
    //   11776: ldc_w 3326
    //   11779: invokestatic 199	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   11782: goto -1127 -> 10655
    //   11785: aload_2
    //   11786: sipush 218
    //   11789: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   11792: checkcast 3328	acto
    //   11795: invokevirtual 3329	acto:a	()V
    //   11798: goto -1143 -> 10655
    //   11801: invokestatic 3330	com/tencent/mobileqq/shortvideo/ShortVideoResourceManager:b	()V
    //   11804: goto -1149 -> 10655
    //   11807: aload_2
    //   11808: sipush 231
    //   11811: getstatic 15	andt:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   11814: aconst_null
    //   11815: invokestatic 3145	ahzb:a	(Lcom/tencent/mobileqq/app/QQAppInterface;ILjava/lang/String;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   11818: goto -1163 -> 10655
    //   11821: iconst_1
    //   11822: invokestatic 3331	ankf:a	(Z)V
    //   11825: goto -1170 -> 10655
    //   11828: aload_2
    //   11829: iconst_1
    //   11830: invokestatic 3332	bcwb:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Z)V
    //   11833: goto -1178 -> 10655
    //   11836: iload 5
    //   11838: ifeq +341 -> 12179
    //   11841: iload 6
    //   11843: iconst_3
    //   11844: if_icmpge +335 -> 12179
    //   11847: aload_3
    //   11848: ifnull +331 -> 12179
    //   11851: aload_3
    //   11852: arraylength
    //   11853: ifle +326 -> 12179
    //   11856: new 85	java/lang/StringBuilder
    //   11859: dup
    //   11860: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   11863: astore 4
    //   11865: aload 4
    //   11867: ldc_w 3334
    //   11870: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11873: pop
    //   11874: aload_3
    //   11875: arraylength
    //   11876: istore 8
    //   11878: iconst_0
    //   11879: istore 7
    //   11881: iload 7
    //   11883: iload 8
    //   11885: if_icmpge +28 -> 11913
    //   11888: aload 4
    //   11890: aload_3
    //   11891: iload 7
    //   11893: iaload
    //   11894: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   11897: ldc_w 3336
    //   11900: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11903: pop
    //   11904: iload 7
    //   11906: iconst_1
    //   11907: iadd
    //   11908: istore 7
    //   11910: goto -29 -> 11881
    //   11913: ldc 183
    //   11915: iconst_1
    //   11916: aload 4
    //   11918: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   11921: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   11924: new 1252	mqq/app/NewIntent
    //   11927: dup
    //   11928: aload_2
    //   11929: invokevirtual 65	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   11932: ldc 2
    //   11934: invokespecial 1255	mqq/app/NewIntent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   11937: astore 4
    //   11939: aload 4
    //   11941: ldc_w 1257
    //   11944: aload_3
    //   11945: invokevirtual 1261	mqq/app/NewIntent:putExtra	(Ljava/lang/String;[I)Landroid/content/Intent;
    //   11948: pop
    //   11949: aload 4
    //   11951: ldc_w 1267
    //   11954: getstatic 15	andt:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   11957: invokevirtual 1270	mqq/app/NewIntent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   11960: pop
    //   11961: aload 4
    //   11963: ldc_w 2231
    //   11966: iconst_1
    //   11967: invokevirtual 2302	mqq/app/NewIntent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   11970: pop
    //   11971: aload_1
    //   11972: getfield 3337	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:cookies	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   11975: invokevirtual 1130	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   11978: ifeq +22 -> 12000
    //   11981: aload 4
    //   11983: ldc_w 2240
    //   11986: aload_1
    //   11987: getfield 3337	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:cookies	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   11990: invokevirtual 260	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   11993: invokevirtual 266	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   11996: invokevirtual 3340	mqq/app/NewIntent:putExtra	(Ljava/lang/String;[B)Landroid/content/Intent;
    //   11999: pop
    //   12000: aload 4
    //   12002: ldc_w 2299
    //   12005: iload 5
    //   12007: invokevirtual 2302	mqq/app/NewIntent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   12010: pop
    //   12011: aload 4
    //   12013: ldc_w 3267
    //   12016: iload 6
    //   12018: iconst_1
    //   12019: iadd
    //   12020: invokevirtual 2297	mqq/app/NewIntent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   12023: pop
    //   12024: aload 4
    //   12026: ldc_w 2296
    //   12029: iconst_0
    //   12030: invokevirtual 2297	mqq/app/NewIntent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   12033: pop
    //   12034: aload_2
    //   12035: aload 4
    //   12037: invokevirtual 1280	com/tencent/mobileqq/app/QQAppInterface:startServlet	(Lmqq/app/NewIntent;)V
    //   12040: return
    //   12041: iconst_0
    //   12042: istore 5
    //   12044: iconst_0
    //   12045: istore 6
    //   12047: aload 4
    //   12049: astore_3
    //   12050: goto -1404 -> 10646
    //   12053: aconst_null
    //   12054: astore 16
    //   12056: goto -2356 -> 9700
    //   12059: aconst_null
    //   12060: astore 16
    //   12062: goto -4891 -> 7171
    //   12065: aload 4
    //   12067: astore 16
    //   12069: goto -8163 -> 3906
    //   12072: aconst_null
    //   12073: astore 16
    //   12075: goto -8299 -> 3776
    //   12078: goto -8462 -> 3616
    //   12081: aload 4
    //   12083: astore 16
    //   12085: iload 10
    //   12087: istore 11
    //   12089: goto -9954 -> 2135
    //   12092: aconst_null
    //   12093: astore 16
    //   12095: goto -8319 -> 3776
    //   12098: astore 17
    //   12100: goto -8085 -> 4015
    //   12103: iconst_0
    //   12104: istore 10
    //   12106: goto -7441 -> 4665
    //   12109: iload 7
    //   12111: iconst_1
    //   12112: iadd
    //   12113: istore 7
    //   12115: goto -7338 -> 4777
    //   12118: goto -37 -> 12081
    //   12121: iload 7
    //   12123: iconst_1
    //   12124: iadd
    //   12125: istore 7
    //   12127: goto -7162 -> 4965
    //   12130: goto -49 -> 12081
    //   12133: iload 7
    //   12135: iconst_1
    //   12136: iadd
    //   12137: istore 7
    //   12139: goto -6737 -> 5402
    //   12142: goto -61 -> 12081
    //   12145: goto -64 -> 12081
    //   12148: iload 7
    //   12150: iconst_1
    //   12151: iadd
    //   12152: istore 7
    //   12154: goto -5834 -> 6320
    //   12157: iload 8
    //   12159: istore 7
    //   12161: goto -5295 -> 6866
    //   12164: goto -83 -> 12081
    //   12167: goto -86 -> 12081
    //   12170: goto -89 -> 12081
    //   12173: goto -92 -> 12081
    //   12176: goto -95 -> 12081
    //   12179: return
    //   12180: goto -99 -> 12081
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	12183	0	this	andt
    //   0	12183	1	paramRespGetConfig	ConfigurationService.RespGetConfig
    //   0	12183	2	paramQQAppInterface	QQAppInterface
    //   0	12183	3	paramIntent	Intent
    //   0	12183	4	paramArrayOfInt	int[]
    //   0	12183	5	paramBoolean	boolean
    //   369	11677	6	i	int
    //   53	12107	7	j	int
    //   365	11793	8	k	int
    //   68	10487	9	m	int
    //   2096	10009	10	bool1	boolean
    //   2129	9959	11	bool2	boolean
    //   2033	8342	12	l1	long
    //   10348	25	14	l2	long
    //   2133	1774	16	localObject1	Object
    //   3913	9	16	localUnsupportedEncodingException1	UnsupportedEncodingException
    //   3929	9	16	localOutOfMemoryError1	OutOfMemoryError
    //   3957	1	16	str1	String
    //   3962	1	16	localThrowable1	Throwable
    //   3965	610	16	localObject2	Object
    //   4699	6	16	localObject3	Object
    //   4803	3158	16	localObject4	Object
    //   8039	39	16	localException1	Exception
    //   8159	13	16	localIterator1	Iterator
    //   8250	617	16	localException2	Exception
    //   9315	395	16	localObject5	Object
    //   9738	1	16	localUnsupportedEncodingException2	UnsupportedEncodingException
    //   9741	1	16	localObject6	Object
    //   9746	1	16	localOutOfMemoryError2	OutOfMemoryError
    //   9763	1	16	str2	String
    //   9768	1	16	localThrowable2	Throwable
    //   9771	17	16	str3	String
    //   9792	12	16	localException3	Exception
    //   9980	306	16	localThrowable3	Throwable
    //   10477	1617	16	localObject7	Object
    //   3636	314	17	localObject8	Object
    //   4013	33	17	localException4	Exception
    //   4161	541	17	localUpgradeDetailWrapper	com.tencent.mobileqq.app.upgrade.UpgradeDetailWrapper
    //   4707	1	17	localException5	Exception
    //   5266	6210	17	localObject9	Object
    //   12098	1	17	localException6	Exception
    //   2054	8657	18	localArrayList	ArrayList
    //   2120	9382	19	localObject10	Object
    //   6530	223	20	localObject11	Object
    //   6576	13	21	localIterator2	Iterator
    //   6598	55	22	str4	String
    // Exception table:
    //   from	to	target	type
    //   3762	3776	3913	java/io/UnsupportedEncodingException
    //   3762	3776	3929	java/lang/OutOfMemoryError
    //   3945	3959	3962	java/lang/Throwable
    //   3847	3891	4013	java/lang/Exception
    //   3891	3902	4013	java/lang/Exception
    //   3990	4006	4013	java/lang/Exception
    //   4598	4621	4699	finally
    //   4621	4624	4699	finally
    //   4630	4645	4699	finally
    //   4645	4662	4699	finally
    //   4665	4671	4699	finally
    //   4671	4693	4699	finally
    //   4701	4704	4699	finally
    //   4579	4598	4707	java/lang/Exception
    //   4704	4707	4707	java/lang/Exception
    //   7916	7950	8039	java/lang/Exception
    //   7950	8022	8039	java/lang/Exception
    //   8022	8036	8039	java/lang/Exception
    //   8085	8124	8039	java/lang/Exception
    //   8127	8161	8250	java/lang/Exception
    //   8161	8233	8250	java/lang/Exception
    //   8233	8247	8250	java/lang/Exception
    //   8296	8335	8250	java/lang/Exception
    //   9686	9700	9738	java/io/UnsupportedEncodingException
    //   9686	9700	9746	java/lang/OutOfMemoryError
    //   9751	9765	9768	java/lang/Throwable
    //   9705	9735	9792	java/lang/Exception
    //   9966	9977	9980	java/lang/Throwable
    //   11219	11242	11248	finally
    //   11242	11245	11248	finally
    //   11249	11252	11248	finally
    //   11254	11269	11248	finally
    //   11269	11286	11248	finally
    //   11289	11295	11248	finally
    //   11295	11312	11248	finally
    //   2242	3616	12098	java/lang/Exception
    //   3619	3665	12098	java/lang/Exception
    //   3673	3688	12098	java/lang/Exception
    //   3691	3724	12098	java/lang/Exception
    //   3729	3757	12098	java/lang/Exception
    //   3762	3776	12098	java/lang/Exception
    //   3781	3836	12098	java/lang/Exception
    //   3836	3843	12098	java/lang/Exception
    //   3915	3926	12098	java/lang/Exception
    //   3931	3942	12098	java/lang/Exception
    //   3942	3945	12098	java/lang/Exception
    //   3945	3959	12098	java/lang/Exception
    //   3970	3983	12098	java/lang/Exception
    //   4074	4090	12098	java/lang/Exception
    //   4097	4160	12098	java/lang/Exception
    //   4170	4189	12098	java/lang/Exception
    //   4189	4204	12098	java/lang/Exception
    //   4204	4214	12098	java/lang/Exception
    //   4217	4232	12098	java/lang/Exception
    //   4232	4310	12098	java/lang/Exception
    //   4310	4397	12098	java/lang/Exception
    //   4397	4426	12098	java/lang/Exception
    //   4426	4468	12098	java/lang/Exception
    //   4471	4518	12098	java/lang/Exception
    //   4518	4536	12098	java/lang/Exception
    //   4539	4550	12098	java/lang/Exception
    //   4557	4572	12098	java/lang/Exception
    //   4715	4731	12098	java/lang/Exception
    //   4734	4774	12098	java/lang/Exception
    //   4777	4855	12098	java/lang/Exception
    //   4855	4877	12098	java/lang/Exception
    //   4880	4919	12098	java/lang/Exception
    //   4922	4962	12098	java/lang/Exception
    //   4965	5043	12098	java/lang/Exception
    //   5043	5066	12098	java/lang/Exception
    //   5069	5108	12098	java/lang/Exception
    //   5111	5154	12098	java/lang/Exception
    //   5157	5231	12098	java/lang/Exception
    //   5231	5246	12098	java/lang/Exception
    //   5246	5318	12098	java/lang/Exception
    //   5318	5371	12098	java/lang/Exception
    //   5379	5399	12098	java/lang/Exception
    //   5421	5435	12098	java/lang/Exception
    //   5438	5477	12098	java/lang/Exception
    //   5477	5524	12098	java/lang/Exception
    //   5529	5535	12098	java/lang/Exception
    //   5535	5558	12098	java/lang/Exception
    //   5561	5601	12098	java/lang/Exception
    //   5601	5673	12098	java/lang/Exception
    //   5673	5687	12098	java/lang/Exception
    //   5690	5709	12098	java/lang/Exception
    //   5714	5724	12098	java/lang/Exception
    //   5724	5886	12098	java/lang/Exception
    //   5889	5928	12098	java/lang/Exception
    //   5928	5959	12098	java/lang/Exception
    //   5964	5974	12098	java/lang/Exception
    //   5974	6048	12098	java/lang/Exception
    //   6051	6134	12098	java/lang/Exception
    //   6134	6148	12098	java/lang/Exception
    //   6151	6190	12098	java/lang/Exception
    //   6190	6263	12098	java/lang/Exception
    //   6263	6286	12098	java/lang/Exception
    //   6289	6317	12098	java/lang/Exception
    //   6320	6398	12098	java/lang/Exception
    //   6398	6406	12098	java/lang/Exception
    //   6411	6419	12098	java/lang/Exception
    //   6422	6469	12098	java/lang/Exception
    //   6472	6511	12098	java/lang/Exception
    //   6514	6578	12098	java/lang/Exception
    //   6578	6650	12098	java/lang/Exception
    //   6650	6675	12098	java/lang/Exception
    //   6678	6717	12098	java/lang/Exception
    //   6717	6746	12098	java/lang/Exception
    //   6749	6796	12098	java/lang/Exception
    //   6796	6809	12098	java/lang/Exception
    //   6812	6827	12098	java/lang/Exception
    //   6830	6843	12098	java/lang/Exception
    //   6848	6866	12098	java/lang/Exception
    //   6866	6967	12098	java/lang/Exception
    //   6967	6976	12098	java/lang/Exception
    //   6979	7010	12098	java/lang/Exception
    //   7019	7053	12098	java/lang/Exception
    //   7056	7100	12098	java/lang/Exception
    //   7107	7139	12098	java/lang/Exception
    //   7142	7171	12098	java/lang/Exception
    //   7176	7249	12098	java/lang/Exception
    //   7249	7263	12098	java/lang/Exception
    //   7263	7335	12098	java/lang/Exception
    //   7335	7343	12098	java/lang/Exception
    //   7343	7365	12098	java/lang/Exception
    //   7368	7414	12098	java/lang/Exception
    //   7417	7432	12098	java/lang/Exception
    //   7435	7442	12098	java/lang/Exception
    //   7445	7452	12098	java/lang/Exception
    //   7455	7462	12098	java/lang/Exception
    //   7465	7471	12098	java/lang/Exception
    //   7474	7480	12098	java/lang/Exception
    //   7483	7588	12098	java/lang/Exception
    //   7591	7630	12098	java/lang/Exception
    //   7633	7745	12098	java/lang/Exception
    //   7748	7804	12098	java/lang/Exception
    //   7807	7814	12098	java/lang/Exception
    //   7817	7824	12098	java/lang/Exception
    //   7827	7834	12098	java/lang/Exception
    //   7837	7844	12098	java/lang/Exception
    //   7847	7855	12098	java/lang/Exception
    //   7858	7865	12098	java/lang/Exception
    //   7868	7874	12098	java/lang/Exception
    //   7877	7883	12098	java/lang/Exception
    //   7886	7893	12098	java/lang/Exception
    //   7896	7913	12098	java/lang/Exception
    //   8041	8077	12098	java/lang/Exception
    //   8077	8082	12098	java/lang/Exception
    //   8252	8288	12098	java/lang/Exception
    //   8288	8293	12098	java/lang/Exception
    //   8338	8344	12098	java/lang/Exception
    //   8347	8353	12098	java/lang/Exception
    //   8356	8362	12098	java/lang/Exception
    //   8365	8371	12098	java/lang/Exception
    //   8374	8380	12098	java/lang/Exception
    //   8383	8389	12098	java/lang/Exception
    //   8392	8398	12098	java/lang/Exception
    //   8401	8407	12098	java/lang/Exception
    //   8410	8416	12098	java/lang/Exception
    //   8419	8425	12098	java/lang/Exception
    //   8428	8434	12098	java/lang/Exception
    //   8437	8443	12098	java/lang/Exception
    //   8446	8452	12098	java/lang/Exception
    //   8455	8461	12098	java/lang/Exception
    //   8464	8470	12098	java/lang/Exception
    //   8473	8479	12098	java/lang/Exception
    //   8482	8488	12098	java/lang/Exception
    //   8491	8497	12098	java/lang/Exception
    //   8500	8506	12098	java/lang/Exception
    //   8509	8515	12098	java/lang/Exception
    //   8518	8528	12098	java/lang/Exception
    //   8531	8537	12098	java/lang/Exception
    //   8540	8546	12098	java/lang/Exception
    //   8549	8555	12098	java/lang/Exception
    //   8558	8564	12098	java/lang/Exception
    //   8567	8657	12098	java/lang/Exception
    //   8657	8710	12098	java/lang/Exception
    //   8713	8763	12098	java/lang/Exception
    //   8766	8773	12098	java/lang/Exception
    //   8776	8792	12098	java/lang/Exception
    //   8795	8802	12098	java/lang/Exception
    //   8805	8812	12098	java/lang/Exception
    //   8815	8822	12098	java/lang/Exception
    //   8825	8832	12098	java/lang/Exception
    //   8835	8843	12098	java/lang/Exception
    //   8846	8853	12098	java/lang/Exception
    //   8856	8863	12098	java/lang/Exception
    //   8866	8880	12098	java/lang/Exception
    //   8883	8890	12098	java/lang/Exception
    //   8893	8909	12098	java/lang/Exception
    //   8912	8919	12098	java/lang/Exception
    //   8922	8929	12098	java/lang/Exception
    //   8932	8939	12098	java/lang/Exception
    //   8942	8949	12098	java/lang/Exception
    //   8952	8959	12098	java/lang/Exception
    //   8962	8969	12098	java/lang/Exception
    //   8972	8979	12098	java/lang/Exception
    //   8982	8989	12098	java/lang/Exception
    //   8992	8999	12098	java/lang/Exception
    //   9002	9009	12098	java/lang/Exception
    //   9012	9017	12098	java/lang/Exception
    //   9020	9027	12098	java/lang/Exception
    //   9030	9037	12098	java/lang/Exception
    //   9040	9047	12098	java/lang/Exception
    //   9050	9057	12098	java/lang/Exception
    //   9060	9067	12098	java/lang/Exception
    //   9070	9077	12098	java/lang/Exception
    //   9080	9087	12098	java/lang/Exception
    //   9090	9097	12098	java/lang/Exception
    //   9100	9107	12098	java/lang/Exception
    //   9110	9129	12098	java/lang/Exception
    //   9132	9139	12098	java/lang/Exception
    //   9142	9149	12098	java/lang/Exception
    //   9152	9159	12098	java/lang/Exception
    //   9162	9169	12098	java/lang/Exception
    //   9172	9179	12098	java/lang/Exception
    //   9182	9189	12098	java/lang/Exception
    //   9192	9198	12098	java/lang/Exception
    //   9201	9208	12098	java/lang/Exception
    //   9211	9218	12098	java/lang/Exception
    //   9221	9228	12098	java/lang/Exception
    //   9231	9238	12098	java/lang/Exception
    //   9241	9248	12098	java/lang/Exception
    //   9251	9258	12098	java/lang/Exception
    //   9261	9268	12098	java/lang/Exception
    //   9271	9278	12098	java/lang/Exception
    //   9281	9288	12098	java/lang/Exception
    //   9291	9297	12098	java/lang/Exception
    //   9300	9317	12098	java/lang/Exception
    //   9322	9339	12098	java/lang/Exception
    //   9342	9359	12098	java/lang/Exception
    //   9364	9384	12098	java/lang/Exception
    //   9387	9394	12098	java/lang/Exception
    //   9397	9404	12098	java/lang/Exception
    //   9407	9414	12098	java/lang/Exception
    //   9417	9423	12098	java/lang/Exception
    //   9426	9432	12098	java/lang/Exception
    //   9435	9441	12098	java/lang/Exception
    //   9444	9461	12098	java/lang/Exception
    //   9464	9476	12098	java/lang/Exception
    //   9481	9489	12098	java/lang/Exception
    //   9492	9499	12098	java/lang/Exception
    //   9502	9509	12098	java/lang/Exception
    //   9512	9524	12098	java/lang/Exception
    //   9527	9534	12098	java/lang/Exception
    //   9537	9544	12098	java/lang/Exception
    //   9547	9554	12098	java/lang/Exception
    //   9557	9564	12098	java/lang/Exception
    //   9567	9574	12098	java/lang/Exception
    //   9582	9590	12098	java/lang/Exception
    //   9591	9609	12098	java/lang/Exception
    //   9616	9624	12098	java/lang/Exception
    //   9628	9681	12098	java/lang/Exception
    //   9686	9700	12098	java/lang/Exception
    //   9748	9751	12098	java/lang/Exception
    //   9751	9765	12098	java/lang/Exception
    //   9776	9789	12098	java/lang/Exception
    //   9794	9812	12098	java/lang/Exception
    //   9815	9822	12098	java/lang/Exception
    //   9825	9832	12098	java/lang/Exception
    //   9835	9842	12098	java/lang/Exception
    //   9845	9852	12098	java/lang/Exception
    //   9855	9862	12098	java/lang/Exception
    //   9865	9872	12098	java/lang/Exception
    //   9875	9882	12098	java/lang/Exception
    //   9885	9891	12098	java/lang/Exception
    //   9894	9912	12098	java/lang/Exception
    //   9915	9933	12098	java/lang/Exception
    //   9936	9945	12098	java/lang/Exception
    //   9948	9963	12098	java/lang/Exception
    //   9966	9977	12098	java/lang/Exception
    //   9982	9987	12098	java/lang/Exception
    //   9990	9997	12098	java/lang/Exception
    //   10000	10007	12098	java/lang/Exception
    //   10010	10017	12098	java/lang/Exception
    //   10020	10027	12098	java/lang/Exception
    //   10030	10037	12098	java/lang/Exception
    //   10040	10054	12098	java/lang/Exception
    //   10057	10064	12098	java/lang/Exception
    //   10067	10078	12098	java/lang/Exception
    //   10081	10093	12098	java/lang/Exception
    //   10096	10103	12098	java/lang/Exception
    //   10106	10113	12098	java/lang/Exception
    //   10116	10135	12098	java/lang/Exception
    //   10138	10145	12098	java/lang/Exception
    //   10148	10154	12098	java/lang/Exception
    //   10157	10168	12098	java/lang/Exception
    //   10171	10189	12098	java/lang/Exception
    //   10192	10204	12098	java/lang/Exception
    //   10207	10213	12098	java/lang/Exception
    //   10216	10223	12098	java/lang/Exception
    //   10226	10241	12098	java/lang/Exception
    //   10244	10250	12098	java/lang/Exception
    //   10253	10268	12098	java/lang/Exception
    //   10271	10278	12098	java/lang/Exception
    //   10281	10293	12098	java/lang/Exception
    //   10296	10303	12098	java/lang/Exception
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
        localObject = bbkb.b(((QQAppInterface)getAppRuntime()).getCurrentAccountUin());
        ((SharedPreferences)localObject).edit().putString("qav_upgrade_invite_video", paramString).commit();
        ((SharedPreferences)localObject).edit().putString("qav_upgrade_invite_multi", str).commit();
        bbkb.i(getAppRuntime().getApplication(), paramInt, jdField_a_of_type_JavaLangString);
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
  
  public static boolean a(anef paramanef, String paramString, Set<String> paramSet)
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
      catch (Exception paramanef)
      {
        bool1 = bool2;
        if (QLog.isColorLevel())
        {
          QLog.i("SPLASH_ConfigServlet", 2, "parseXML | NearbyBanner parse exception,", paramanef);
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
        paramanef.a(paramanef.a(l1, str3, (byte)3, str2, ((StringBuffer)localObject).toString(), BaseApplication.getContext().getFilesDir().getAbsolutePath() + "/" + "NearbyBannerPic" + "/" + str1, l3 + "|" + l2, (short)k, str1));
        atbi.a(jdField_a_of_type_JavaLangString, "has_new_banner", Boolean.valueOf(true));
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
    bbmx.a(arrayOfByte, 0, 4L + l);
    bbmx.a(arrayOfByte, 4, paramReqGetConfig, (int)l);
    return arrayOfByte;
  }
  
  public static byte[] a(byte[] paramArrayOfByte)
  {
    int i = paramArrayOfByte.length - 4;
    byte[] arrayOfByte = new byte[i];
    bbmx.a(arrayOfByte, 0, paramArrayOfByte, 4, i);
    return arrayOfByte;
  }
  
  private void aa(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    for (;;)
    {
      try
      {
        j = paramConfig.version.get();
        k = bbkb.a(paramQQAppInterface.getApp(), "change_machine_version", jdField_a_of_type_JavaLangString);
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
        baig localbaig;
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
        localbaig.a("");
        if (!QLog.isColorLevel()) {
          break label261;
        }
        QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 195,content_list is empty ,version: " + paramConfig.version.get());
        return;
        if (j != k) {
          continue;
        }
      }
      localbaig = (baig)paramQQAppInterface.getManager(224);
      if (i > 0)
      {
        paramConfig = b(paramConfig, k, 195);
        localbaig.a(paramConfig);
        if (!TextUtils.isEmpty(paramConfig))
        {
          bbkb.a(paramQQAppInterface.getApp(), "change_machine_version", jdField_a_of_type_JavaLangString, j);
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
        k = bbkb.a(paramQQAppInterface.getApp(), "nearby_auth_video_config_version", jdField_a_of_type_JavaLangString);
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
          atbt.a(paramConfig);
          bbkb.a(paramQQAppInterface.getApp(), "nearby_auth_video_config_version", jdField_a_of_type_JavaLangString, j);
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
        k = bbkb.a(paramQQAppInterface.getApp(), "nearby_videochat_dialog_config_version", jdField_a_of_type_JavaLangString);
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
          ((baig)paramQQAppInterface.getManager(224)).c(paramConfig);
          bbkb.a(paramQQAppInterface.getApp(), "nearby_videochat_dialog_config_version", jdField_a_of_type_JavaLangString, j);
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
        k = bbkb.a(paramQQAppInterface.getApp(), "nearby_videochat_banner_config_version", jdField_a_of_type_JavaLangString);
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
          ((baig)paramQQAppInterface.getManager(224)).b(paramConfig);
          bbkb.a(paramQQAppInterface.getApp(), "nearby_videochat_banner_config_version", jdField_a_of_type_JavaLangString, j);
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
    int i = bbkb.aP(((QQAppInterface)getAppRuntime()).getApp(), paramQQAppInterface);
    if (!bjck.a()) {
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
        bbkb.af(((QQAppInterface)getAppRuntime()).getApp(), paramQQAppInterface, k);
        new bjje().a(paramConfig, bjck.a.getAbsolutePath(), "temp_template_zip", new andv(this));
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.d("QQSTORY_QUESTION_TAB_SPLASH_ConfigServlet", 2, "GetQQStoryQuestionTabConfig|type: 问答Tab配置回包内容为空");
    return;
    label229:
    if (QLog.isColorLevel()) {
      QLog.d("QQSTORY_QUESTION_TAB_SPLASH_ConfigServlet", 2, "GetQQStoryQuestionTabConfig|type: 问答Tab配置回包为空");
    }
    bjck.e();
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
      localajsi = (ajsi)paramQQAppInterface.a(53);
      j = localajsi.a(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount());
      if ((paramConfig.content_list != null) && (paramConfig.content_list.size() > 0))
      {
        paramQQAppInterface = (String)paramConfig.content_list.get(0);
        if (QLog.isColorLevel()) {
          QLog.d("babyqConfig", 2, "received BabyQPlusPanelConfig configVersion:" + i + " ,localVersion:" + j + " ,configContent" + paramQQAppInterface);
        }
        if (i != j)
        {
          localajsi.a(i, paramQQAppInterface);
          return;
        }
        localajsi.a(false, false);
        return;
      }
    }
    catch (Exception paramQQAppInterface)
    {
      int i;
      ajsi localajsi;
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
          localajsi.a(false, false);
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
    if (j == bbkb.R(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin())) {
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
          bbkb.c(paramQQAppInterface.getApp(), j, paramQQAppInterface.getCurrentAccountUin(), localConfig);
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
    if (j == bbkb.S(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin())) {
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
      paramConfig = augv.a(paramConfig.content.get().toByteArray());
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
              bbkb.d(paramQQAppInterface.getApp(), j, paramQQAppInterface.getCurrentAccountUin(), localConfig);
              paramQQAppInterface = (akvq)paramQQAppInterface.getManager(199);
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
      j = bbkb.D(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount());
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
    bbkb.a(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount(), i, true, bool);
    return;
    if (i != j)
    {
      bbkb.a(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount(), i, false, true);
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
    awin.jdField_a_of_type_JavaLangString = paramQQAppInterface.getCurrentAccountUin();
    int i = paramConfig.version.get();
    int j = awin.a(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin());
    if (QLog.isColorLevel()) {
      QLog.d("Q.uniteSearch.SearchNetEntryConfig", 2, "handleSearchNetEntryConfig, version: " + i + " localVersion: " + j);
    }
    if (i == j) {
      return;
    }
    awin.a(paramQQAppInterface.getApp(), i, paramQQAppInterface.getCurrentAccountUin());
    awin.a(paramQQAppInterface.getApp(), paramConfig, paramQQAppInterface.c());
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
              bbkb.u(paramQQAppInterface.getApp(), j, paramQQAppInterface.getCurrentAccountUin());
              bbkb.w(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin(), i);
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
    int i1 = bbkb.a(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, 2);
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
          bbkb.d(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, 3, k);
          if (paramQQAppInterface.a(250)) {
            ((MedalWallMng)paramQQAppInterface.getManager(250)).a(k);
          }
        }
        bbkb.d(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, 2, n);
        localObject1 = paramConfig;
        if (QLog.isColorLevel()) {
          QLog.i("SPLASH_ConfigServlet", 2, String.format(Locale.getDefault(), "handleMedalStrongReminderConfig localVersion: %s, version: %s, result: %s, value: %s, strContent: %s", new Object[] { Integer.valueOf(i1), Integer.valueOf(n), Integer.valueOf(j), Integer.valueOf(k), localObject1 }));
        }
        return;
        if (paramConfig.compress.get() != 1) {
          continue;
        }
        paramConfig = augv.a(paramConfig.content.get().toByteArray());
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
        int m = ((Integer)bbkb.a(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, 2)).intValue();
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
              bbkb.a(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, 3, localObject1);
              if (paramQQAppInterface.a(159)) {
                ((akaa)paramQQAppInterface.getManager(159)).a((String)localObject1);
              }
            }
            bbkb.a(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, 2, Integer.valueOf(k));
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
          paramConfig = augv.a(paramConfig.content.get().toByteArray());
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
          localObject3 = augv.a(((ConfigurationService.Content)localObject4).content.get().toByteArray());
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
        ahww.a();
        ahww.a((String)localObject1);
        bbkb.t(paramQQAppInterface.getApp(), paramConfig.version.get(), jdField_a_of_type_JavaLangString);
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
      paramConfig = augv.a(paramConfig.content.get().toByteArray());
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
        ((akfc)paramQQAppInterface.getManager(22)).a(paramConfig, j);
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
    atzv localatzv = (atzv)paramQQAppInterface.getManager(228);
    int i = localatzv.a();
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
          paramQQAppInterface = augv.a(paramConfig.content.get().toByteArray());
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
        localatzv.a(bool1, paramQQAppInterface);
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
    int i = bbew.a();
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
      paramConfig = augv.a(paramConfig.content.get().toByteArray());
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
          bbew.a().a(paramQQAppInterface.getApp(), paramConfig, j);
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
    bbew.a().a(j);
  }
  
  private void as(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    boolean bool = false;
    int i = paramConfig.version.get();
    BaseApplication localBaseApplication = paramQQAppInterface.getApp();
    String str = paramQQAppInterface.c();
    int j = ((Integer)bbkb.a(localBaseApplication, str, "config_tim_team_version_code", Integer.valueOf(0))).intValue();
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
      bbkb.a(localBaseApplication, str, false, "config_tim_team_is_web", Boolean.valueOf(bool));
      bbkb.a(localBaseApplication, str, false, "config_tim_team_url", paramQQAppInterface);
      bbkb.a(localBaseApplication, str, true, "config_tim_team_version_code", Integer.valueOf(i));
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
        localObject2 = albv.a((byte[])localObject1);
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
    alch localalch = (alch)localQQAppInterface.getManager(168);
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
          paramIntent = albv.a(paramIntent.content.get().toByteArray());
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
        if (localalch != null) {
          localalch.a(paramIntent);
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
      if (localalch != null) {
        localalch.b();
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
    paramIntent = avrv.a();
    int j = paramConfig.version.get();
    int i = bbkb.i(((QQAppInterface)getAppRuntime()).getApp());
    if (!avrv.a()) {
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
      bbkb.g(((QQAppInterface)getAppRuntime()).getApp(), j);
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
    int j = aexb.a(paramQQAppInterface);
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
        aexb.a(paramQQAppInterface, paramConfig.getBoolean("useRecommendedSticker"));
        aexb.a(localBaseApplication, str, paramConfig.getInt("maxMatchLength"));
      }
      for (;;)
      {
        aexb.a(paramQQAppInterface, i);
        return;
        aexb.a(paramQQAppInterface, false);
      }
    }
    catch (Exception paramConfig)
    {
      for (;;)
      {
        aexb.a(paramQQAppInterface, false);
        if (QLog.isColorLevel()) {
          QLog.d("SPLASH_ConfigServlet", 2, paramConfig.getMessage());
        }
      }
    }
  }
  
  public static void b(QQAppInterface paramQQAppInterface, String paramString)
  {
    jdField_a_of_type_JavaLangString = paramString;
    NewIntent localNewIntent = new NewIntent(paramQQAppInterface.getApp(), andt.class);
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
        bbkb.d(((QQAppInterface)getAppRuntime()).getCurrentAccountUin()).edit().putString("qav_anychat_time_value", paramString).commit();
        bbkb.j(getAppRuntime().getApplication(), paramInt, jdField_a_of_type_JavaLangString);
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
    alch localalch = (alch)localQQAppInterface.getManager(168);
    if (localalch == null)
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
      localalch.a(i);
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
          paramIntent = albv.a((byte[])localObject2);
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
      localalch.b(j);
      localalch.a(localNameNotFoundException);
      if (QLog.isColorLevel()) {
        QLog.d("ArConfig_configServlet", 2, "maxEndTimeArConfigInfo|| maxEndtime=" + localNameNotFoundException.aREnd);
      }
      OlympicServlet.a(localQQAppInterface, 87, j, 0, 0, 0, 0);
    }
    for (;;)
    {
      i = 0;
      label648:
      if ((i == 0) || (localalch == null)) {
        break;
      }
      QLog.d("ArConfig_configServlet", 1, "arManager.downloadArResource");
      localalch.a(true, false);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ArConfig_configServlet", 2, "handleResp_GetArResource|combineArConfigInfo is null");
      }
      OlympicServlet.a(localQQAppInterface, 87, j, 0, 0, 5, 0);
      continue;
      label707:
      localalch.a();
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
    int j = bbkb.Q(BaseApplication.getContext(), jdField_a_of_type_JavaLangString);
    if (QLog.isColorLevel()) {
      QLog.i("SPLASH_ConfigServlet", 2, "handleRespNewBoatConfig: ,version: " + paramConfig.version.get() + "| localVersion: " + j);
    }
    if (i != j)
    {
      bbkb.s(BaseApplication.getContext(), i, jdField_a_of_type_JavaLangString);
      paramConfig = a(paramConfig);
      if ((paramConfig != null) && (paramConfig.size() > 0)) {
        asyj.a(paramQQAppInterface, (String)paramConfig.get(0));
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
          localObject5 = ((aukp)localObject3).a(ExpiredPushBanner.class);
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
      if (!amoy.a(paramString)) {
        ThreadManager.executeOnNetWorkThread(new ConfigServlet.4(this, (String)localObject1));
      }
      amou.a.a(amou.a.a(l1, (String)localObject2, (byte)3, (String)localObject1, (String)localObject4, (String)localObject5, l3 + "|" + l2, (short)k, paramString));
      paramInt = 1;
      k = 1;
    }
    for (;;)
    {
      try
      {
        localObject1 = ((aukp)localObject3).a(ReportedBanner.class, false, null, null, null, null, "endtime DESC", null);
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
                ((aukp)localObject3).b((auko)localObject2);
                break label1064;
              }
            }
          }
        }
        if (j == 0) {
          break label1015;
        }
        axqy.b((QQAppInterface)getAppRuntime(), "dc00898", "", "", "0X80087C0", "0X80087C0", (int)l1, 0, "", "", "", "");
        localObject1 = new ReportedBanner();
        ((ReportedBanner)localObject1).cid = l1;
        ((ReportedBanner)localObject1).md5 = paramString;
        ((ReportedBanner)localObject1).endtime = l2;
        ((aukp)localObject3).a((auko)localObject1);
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
    akxf localakxf = (akxf)((QQAppInterface)getAppRuntime()).getManager(220);
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
      arrayOfByte = augv.a(paramIntent.content.get().toByteArray());
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
          if (localakxf.a(paramIntent))
          {
            localakxf.a(i);
            localakxf.a();
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
        if (localakxf != null) {
          localakxf.b();
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
    int j = bbkb.g(((QQAppInterface)getAppRuntime()).getApp());
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
        arrayOfByte = augv.a(paramConfig.content.get().toByteArray());
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
          boolean bool = azrf.a(paramConfig);
          if (bool) {
            bbkb.e(((QQAppInterface)getAppRuntime()).getApp(), i);
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
    //   27: ldc_w 4115
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
    //   59: ldc_w 4117
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
    //   84: ldc_w 3378
    //   87: invokeinterface 939 2 0
    //   92: iload 9
    //   94: invokeinterface 950 2 0
    //   99: invokeinterface 956 1 0
    //   104: invokeinterface 959 1 0
    //   109: astore 13
    //   111: aload 14
    //   113: ldc_w 3384
    //   116: invokeinterface 939 2 0
    //   121: iload 9
    //   123: invokeinterface 950 2 0
    //   128: invokeinterface 956 1 0
    //   133: invokeinterface 959 1 0
    //   138: astore 12
    //   140: aload 14
    //   142: ldc_w 4118
    //   145: invokeinterface 939 2 0
    //   150: iload 9
    //   152: invokeinterface 950 2 0
    //   157: invokeinterface 956 1 0
    //   162: invokeinterface 959 1 0
    //   167: invokestatic 4124	java/lang/Float:parseFloat	(Ljava/lang/String;)F
    //   170: fstore 4
    //   172: aload 14
    //   174: ldc_w 4125
    //   177: invokeinterface 939 2 0
    //   182: iload 9
    //   184: invokeinterface 950 2 0
    //   189: invokeinterface 956 1 0
    //   194: invokeinterface 959 1 0
    //   199: invokestatic 4124	java/lang/Float:parseFloat	(Ljava/lang/String;)F
    //   202: fstore_3
    //   203: iconst_1
    //   204: istore 10
    //   206: aload 14
    //   208: ldc_w 4126
    //   211: invokeinterface 939 2 0
    //   216: iload 9
    //   218: invokeinterface 950 2 0
    //   223: invokeinterface 956 1 0
    //   228: invokeinterface 959 1 0
    //   233: invokestatic 4124	java/lang/Float:parseFloat	(Ljava/lang/String;)F
    //   236: fstore 5
    //   238: aload 14
    //   240: ldc_w 4127
    //   243: invokeinterface 939 2 0
    //   248: iload 9
    //   250: invokeinterface 950 2 0
    //   255: invokeinterface 956 1 0
    //   260: invokeinterface 959 1 0
    //   265: invokestatic 4124	java/lang/Float:parseFloat	(Ljava/lang/String;)F
    //   268: fstore 8
    //   270: aload 14
    //   272: ldc_w 4129
    //   275: invokeinterface 939 2 0
    //   280: iload 9
    //   282: invokeinterface 950 2 0
    //   287: invokeinterface 956 1 0
    //   292: invokeinterface 959 1 0
    //   297: astore 11
    //   299: aload 14
    //   301: ldc_w 4130
    //   304: invokeinterface 939 2 0
    //   309: iload 9
    //   311: invokeinterface 950 2 0
    //   316: invokeinterface 956 1 0
    //   321: invokeinterface 959 1 0
    //   326: invokestatic 4124	java/lang/Float:parseFloat	(Ljava/lang/String;)F
    //   329: fstore 7
    //   331: aload 14
    //   333: ldc_w 4126
    //   336: invokeinterface 939 2 0
    //   341: iload 9
    //   343: invokeinterface 950 2 0
    //   348: invokeinterface 956 1 0
    //   353: invokeinterface 959 1 0
    //   358: invokestatic 4124	java/lang/Float:parseFloat	(Ljava/lang/String;)F
    //   361: fstore 6
    //   363: aload 14
    //   365: ldc_w 4132
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
    //   407: ldc_w 4134
    //   410: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   413: aload 13
    //   415: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   418: ldc_w 4136
    //   421: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   424: aload 12
    //   426: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   429: ldc_w 4138
    //   432: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   435: fload 4
    //   437: invokevirtual 4141	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   440: ldc_w 4143
    //   443: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   446: fload_3
    //   447: invokevirtual 4141	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   450: ldc_w 4145
    //   453: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   456: iload 10
    //   458: invokevirtual 152	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   461: ldc_w 4147
    //   464: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   467: fload 5
    //   469: invokevirtual 4141	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   472: ldc_w 4149
    //   475: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   478: fload 8
    //   480: invokevirtual 4141	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   483: ldc_w 4151
    //   486: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   489: aload 11
    //   491: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   494: ldc_w 4153
    //   497: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   500: fload 7
    //   502: invokevirtual 4141	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   505: ldc_w 4155
    //   508: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   511: aload_1
    //   512: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   515: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   518: invokestatic 199	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   521: goto +169 -> 690
    //   524: astore_1
    //   525: aload 14
    //   527: ldc_w 4156
    //   530: invokeinterface 939 2 0
    //   535: iload 9
    //   537: invokeinterface 950 2 0
    //   542: invokeinterface 956 1 0
    //   547: invokeinterface 959 1 0
    //   552: invokestatic 4124	java/lang/Float:parseFloat	(Ljava/lang/String;)F
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
    //   585: invokevirtual 47	andt:getAppRuntime	()Lmqq/app/AppRuntime;
    //   588: invokevirtual 2595	mqq/app/AppRuntime:getApplication	()Lmqq/app/MobileQQ;
    //   591: invokevirtual 2722	mqq/app/MobileQQ:getFilesDir	()Ljava/io/File;
    //   594: invokevirtual 2725	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   597: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   600: ldc_w 2755
    //   603: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   606: getstatic 15	andt:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   609: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   612: ldc_w 2755
    //   615: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   618: ldc_w 2800
    //   621: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   624: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   627: astore 14
    //   629: ldc_w 4158
    //   632: aload 13
    //   634: invokestatic 4163	com/tencent/mobileqq/msf/sdk/MsfSdkUtils:insertMtype	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   637: astore 13
    //   639: fload_3
    //   640: fstore 7
    //   642: fload_3
    //   643: fconst_0
    //   644: fcmpg
    //   645: ifge +8 -> 653
    //   648: ldc_w 820
    //   651: fstore 7
    //   653: new 4165	com/tencent/mobileqq/config/splashlogo/ConfigServlet$5
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
    //   678: invokespecial 4168	com/tencent/mobileqq/config/splashlogo/ConfigServlet$5:<init>	(Landt;Ljava/lang/String;Ljava/lang/String;FFFLjava/lang/String;Ljava/lang/String;FZILjava/lang/String;)V
    //   681: iconst_2
    //   682: aconst_null
    //   683: iconst_0
    //   684: invokestatic 3308	com/tencent/mobileqq/app/ThreadManager:post	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
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
    //   710: ldc_w 4117
    //   713: astore_1
    //   714: goto -323 -> 391
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	717	0	this	andt
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
      int j = bbkb.q(((QQAppInterface)getAppRuntime()).getApp(), paramIntent);
      if (QLog.isColorLevel()) {
        QLog.d("nearby_flower_operation_gray_tips", 2, "serverVersion=" + i + "|localVersion=" + j);
      }
      if (i != j)
      {
        bbkb.c(((QQAppInterface)getAppRuntime()).getApp(), paramIntent, i);
        akbj localakbj = (akbj)((QQAppInterface)getAppRuntime()).getManager(124);
        if ((!paramConfig.content_list.has()) || (paramConfig.content_list.get().size() <= 0)) {
          break label246;
        }
        localList = paramConfig.content_list.get();
        if ((localList != null) && (localList.size() > 0))
        {
          localakbj.a(paramIntent, (String)localList.get(0));
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
      atbr.a("GENERAL_LBS_CONFIGS_CMD", new Object[] { "getGeneralLBSConfigs", paramString, Long.valueOf(l) });
    }
    paramString = new NewIntent(paramQQAppInterface.getApp(), andt.class);
    paramString.putExtra("k_cmd_type", new int[] { 87, 12, 174, 189 });
    paramQQAppInterface.startServlet(paramString);
  }
  
  private void e(ConfigurationService.Config paramConfig)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)getAppRuntime();
    int i = paramConfig.version.get();
    int j = bbkb.o(localQQAppInterface.getApp());
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
      bbkb.m(localQQAppInterface.getApp(), i, str);
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
          bbkb.a(getAppRuntime().getApplication(), paramInt, str2, paramString);
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
      int j = bbkb.r(((QQAppInterface)getAppRuntime()).getApp(), paramIntent);
      if (QLog.isColorLevel()) {
        QLog.d("HotChatManager", 2, "serverVersion=" + i + "|localVersion=" + j);
      }
      if (i != j)
      {
        bbkb.d(((QQAppInterface)getAppRuntime()).getApp(), paramIntent, i);
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
    paramString = (aurv)paramQQAppInterface.getManager(179);
    if ((paramString != null) && (paramString.a() != null) && (paramString.a().d * 1000L <= 0L)) {}
    paramString = new NewIntent(paramQQAppInterface.getApp(), andt.class);
    paramString.putExtra("k_cmd_type", new int[] { 113 });
    paramQQAppInterface.startServlet(paramString);
  }
  
  private void f(ConfigurationService.Config paramConfig)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)getAppRuntime();
    int i = paramConfig.version.get();
    int j = bbkb.p(localQQAppInterface.getApp());
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
      bbkb.n(localQQAppInterface.getApp(), i, str);
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
    int i = bbkb.h(((QQAppInterface)getAppRuntime()).getApp());
    if (!PtvTemplateManager.a()) {
      i = 0;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PtvTemplateManager", 2, "serverVersion=" + j + "|localVersion=" + i);
    }
    if (j != i)
    {
      bbkb.f(((QQAppInterface)getAppRuntime()).getApp(), j);
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
    int i = bbkb.k(((QQAppInterface)getAppRuntime()).getApp());
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
        bbkb.i(((QQAppInterface)getAppRuntime()).getApp(), k);
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
    int i = bbkb.j(((QQAppInterface)getAppRuntime()).getApp());
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
        bbkb.h(((QQAppInterface)getAppRuntime()).getApp(), j);
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
    bkzs localbkzs = bkzs.a();
    int k = paramConfig.version.get();
    int i = bbkb.E(((QQAppInterface)getAppRuntime()).getApp());
    if (!localbkzs.a()) {
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
      } while (!localbkzs.a(paramConfig, (QQAppInterface)getAppRuntime()));
      bbkb.u(((QQAppInterface)getAppRuntime()).getApp(), k);
      return;
    } while (!QLog.isColorLevel());
    label195:
    QLog.d("QQSTORY_FOLLOW_CAPTURE_SPLASH_ConfigServlet", 2, "GetQQStoryFollowCaptureConfig|type: 合拍配置回包内容为空");
    return;
    label212:
    if (QLog.isColorLevel()) {
      QLog.d("QQSTORY_FOLLOW_CAPTURE_SPLASH_ConfigServlet", 2, "GetQQStoryFollowCaptureConfig|type: 合拍配置回包为空");
    }
    localbkzs.a();
  }
  
  private void i(Intent paramIntent, ConfigurationService.Config paramConfig)
  {
    NearbyGrayTipsManager localNearbyGrayTipsManager;
    String str2;
    if (!TextUtils.isEmpty(paramIntent.getStringExtra("key_uin")))
    {
      int i = paramConfig.version.get();
      int j = bbkb.f(((QQAppInterface)getAppRuntime()).getApp());
      if (QLog.isColorLevel()) {
        QLog.d("nearby_aio_operation_gray_tips", 2, "serverVersion=" + i + "|localVersion=" + j);
      }
      if (i != j)
      {
        bbkb.d(((QQAppInterface)getAppRuntime()).getApp(), i);
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
          } while (bbkk.a(str2));
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
        if (bbkk.a(str1)) {
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
    bbkb.h(getAppRuntime().getApplication(), i, jdField_a_of_type_JavaLangString);
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
    if (i == bbkb.o(((QQAppInterface)getAppRuntime()).getApp(), jdField_a_of_type_JavaLangString)) {}
    for (;;)
    {
      return;
      bbkb.k(((QQAppInterface)getAppRuntime()).getApp(), i, jdField_a_of_type_JavaLangString);
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
                ((sst)paramIntent.getManager(181)).h(Boolean.parseBoolean(paramConfig));
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
    akco localakco = (akco)localQQAppInterface.getManager(102);
    i = localakco.a();
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
        localakcn2 = new akcn();
      }
      catch (Throwable localThrowable2)
      {
        akcn localakcn2;
        XmlPullParser localXmlPullParser;
        int k;
        Object localObject3;
        akcn localakcn1 = null;
        i = 0;
        paramConfig = null;
        localObject1 = null;
        continue;
        localakcn1 = null;
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
        localakcn1 = localakcn2;
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
            localakcn2.jdField_b_of_type_JavaLangString = localXmlPullParser.getAttributeValue(j);
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
          localakcn2.jdField_a_of_type_JavaLangString = localXmlPullParser.getAttributeValue(j);
          continue;
          QLog.e("PhoneContact.Manager", 1, "", localThrowable1);
        }
        catch (Throwable localThrowable1)
        {
          localakcn1 = localakcn2;
        }
      }
      catch (Throwable localThrowable3)
      {
        i = 0;
        paramConfig = null;
        localObject1 = null;
        localakcn1 = localakcn2;
        continue;
        continue;
        continue;
      }
      localObject5 = localObject1;
      localObject3 = paramConfig;
      j = i;
      localakco.a(m, localObject6, localakcn1);
      ((PhoneContactManagerImp)localQQAppInterface.getManager(11)).a(j, localObject5, (String)localObject3);
      return;
      if ("dayNum".equals(localObject3)) {
        localakcn2.jdField_a_of_type_Int = Integer.valueOf(localXmlPullParser.getAttributeValue(j)).intValue();
      } else if ("dayIntervalNum".equals(localObject3)) {
        localakcn2.jdField_b_of_type_Int = Integer.valueOf(localXmlPullParser.getAttributeValue(j)).intValue();
      } else if ("totalNum".equals(localObject3)) {
        localakcn2.c = Integer.valueOf(localXmlPullParser.getAttributeValue(j)).intValue();
      } else if ("loginNum".equals(localObject3)) {
        localakcn2.e = Integer.valueOf(localXmlPullParser.getAttributeValue(j)).intValue();
      } else if ("banner".equals(localObject3)) {
        localakcn2.jdField_a_of_type_Boolean = "1".equals(localXmlPullParser.getAttributeValue(j));
      } else if ("setEntry".equals(localObject3)) {
        localakcn2.jdField_b_of_type_Boolean = "1".equals(localXmlPullParser.getAttributeValue(j));
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
        localakcn1 = localakcn2;
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
    int j = bbkb.p(((QQAppInterface)getAppRuntime()).getApp(), jdField_a_of_type_JavaLangString);
    if (i == j) {}
    label179:
    label195:
    do
    {
      do
      {
        return;
        bbkb.l(((QQAppInterface)getAppRuntime()).getApp(), i, jdField_a_of_type_JavaLangString);
        for (;;)
        {
          try
          {
            if (paramConfig.msg_content_list != null)
            {
              i = paramConfig.msg_content_list.size();
              paramIntent = (arid)paramIntent.getManager(267);
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
            int k = bbkb.A(localQQAppInterface.getApp(), localQQAppInterface.getAccount());
            if (QLog.isColorLevel()) {
              QLog.d("SPLASH_ConfigServlet", 2, "received SUBSCRIPT_RECOMMEND_CMD remote version: " + j + " | localVersion: " + k);
            }
            if ((j != k) || (paramConfig.content_list.size() > 0))
            {
              if ((sfe.a((QQAppInterface)getAppRuntime(), str)) && (QLog.isColorLevel())) {
                QLog.d("SPLASH_ConfigServlet", 2, "received SUBSCRIPT_RECOMMEND_CMD save version: " + j);
              }
              bbkb.l(getAppRuntime().getApplication(), localQQAppInterface.getAccount(), j);
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
            scr.d(localQQAppInterface, "1".equals(localObject3));
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
            bhvy.a((String)localObject2, localQQAppInterface);
          }
          localObject2 = (String)localHashMap.get("synchronize_to_qzone");
          if (localObject2 != null) {
            bhvy.b((String)localObject2, localQQAppInterface);
          }
          localObject2 = (String)localHashMap.get("merge_feeds");
          if (localObject2 != null) {
            bhvy.d((String)localObject2, localQQAppInterface);
          }
          localObject2 = (String)localHashMap.get("kandian_feeds");
          if (localObject2 != null) {
            bhvy.e((String)localObject2, localQQAppInterface);
          }
          i = paramConfig.version.get();
          bbkb.g(getAppRuntime().getApplication(), i, jdField_a_of_type_JavaLangString);
          if ((paramIntent != null) && (paramIntent.hasExtra("update101Version"))) {
            SettingCloneUtil.writeValueForInt(getAppRuntime().getApplication(), jdField_a_of_type_JavaLangString, null, "qqsetting_calltab_show_key_version", paramIntent.getIntExtra("update101Version", 0));
          }
          ArkAppCenter.a((String)localHashMap.get("arkapp_pa_nshow"));
          atbi.a(localQQAppInterface.getAccount(), "supportHotChatDemo", Boolean.valueOf("1".equals(localHashMap.get("hotchat_demo"))));
          paramIntent = (avbv)localQQAppInterface.getManager(89);
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
            axhq.a(paramIntent, true);
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
                paramConfig = awvt.a();
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
              awwa.jdField_b_of_type_Int = Integer.valueOf(paramIntent).intValue();
              aigt.a((String)localHashMap.get("shortvideo_progressive_enable"));
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
              axqh.a("pic_thumb_400Enable", paramIntent);
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
              arco.a();
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
      j = bbkb.E(localQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
      if (QLog.isColorLevel()) {
        QLog.d("SPLASH_ConfigServlet", 2, "received READINJOY_LOCAL_CHANNEL_CONFIG_CMD remote version: " + i + " | localVersion: " + j);
      }
      if (i != j)
      {
        bbkb.m(localQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, i);
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
    int i = bbkb.m(((QQAppInterface)getAppRuntime()).getApp());
    if (!PtvTemplateManager.d()) {
      i = 0;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PtvTemplateManager", 2, "GetBlessSpecialPendantConfig serverVersion=" + j + "|localVersion=" + i);
    }
    if (j != i)
    {
      bbkb.j(((QQAppInterface)getAppRuntime()).getApp(), j);
      if ((paramConfig.msg_content_list == null) || (paramConfig.msg_content_list.size() <= 0)) {
        break label269;
      }
      paramIntent = (ConfigurationService.Content)paramConfig.msg_content_list.get(0);
      if (paramIntent != null)
      {
        if (paramIntent.compress.get() != 1) {
          break label255;
        }
        paramIntent = augv.a(paramIntent.content.get().toByteArray());
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
      int i = bbkb.s(((QQAppInterface)getAppRuntime()).getApp());
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
          zcr.a(BaseApplicationImpl.sApplication, paramConfig);
          i += 1;
          continue;
          if ((paramConfig.content_list != null) && (paramConfig.content_list.size() > 0)) {
            i = 0;
          }
          while (i < paramConfig.content_list.size())
          {
            localObject = (String)paramConfig.content_list.get(i);
            QLog.d("PatchLogTag", 1, "handlePatchConfigCmd content_list index=" + i + ", content=" + (String)localObject);
            zcr.a(BaseApplicationImpl.sApplication, (String)localObject);
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
        zck.a(localQQAppInterface);
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
      j = bbkb.w(localQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
      if (QLog.isColorLevel()) {
        QLog.d("SPLASH_ConfigServlet", 2, "received SEARCH_CONFIG_CMD remote version: " + i + " | localVersion: " + j);
      }
      if (i != j)
      {
        bbkb.i(localQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, i);
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
      j = bbkb.t(localQQAppInterface.getApp());
      if (QLog.isColorLevel()) {
        QLog.d("SPLASH_ConfigServlet", 2, "received CAMERA_COMPATIBLE_LIST_CONFIG remote version: " + i + " | localVersion: " + j);
      }
      if (i != j)
      {
        bbkb.m(localQQAppInterface.getApp(), i);
        if (QLog.isColorLevel()) {
          QLog.d("SPLASH_ConfigServlet", 2, "received CAMERA_COMPATIBLE_LIST_CONFIG save version: " + i);
        }
        axhq.a(str, true);
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
      if (i != bbkb.v(localQQAppInterface.getApp()))
      {
        bbkb.n(localQQAppInterface.getApp(), i);
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
    int j = bbkb.aq(paramQQAppInterface.getApp().getBaseContext(), jdField_a_of_type_JavaLangString);
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
          arrayOfByte = augv.a(((ConfigurationService.Content)localObject1).content.get().toByteArray());
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
      bbkb.v(paramQQAppInterface.getApp().getBaseContext(), k, jdField_a_of_type_JavaLangString);
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
            localObject = ausb.a((ConfigurationService.Content)localObject);
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
      ausb.a(localQQAppInterface.getApp(), paramConfig.version.get(), jdField_a_of_type_JavaLangString);
      paramConfig = (aurv)localQQAppInterface.getManager(179);
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
    int j = bbkb.B(localQQAppInterface.getApp(), localQQAppInterface.getAccount());
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
        agvx.a(localQQAppInterface, i, str);
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
    paramConfig = (agvx)localQQAppInterface.getManager(125);
    paramConfig.jdField_b_of_type_Boolean = true;
    paramConfig.c = MessageForFoldMsgGrayTips.PASSWD_REDBAG_MSG_SWITCH_DEFAULT;
    paramConfig.jdField_a_of_type_Int = MessageForFoldMsgGrayTips.PASSWD_REDBAG_MSG_DISPLAY_NUM_DEFAULT;
    paramConfig.d = MessageForFoldMsgGrayTips.PASSWD_REDBAG_MSG_SWITCH_INDEX;
    paramConfig.e = MessageForFoldMsgGrayTips.PASSWD_REDBAG_MSG_INDEX_WITH_ID;
    bbkb.a(localQQAppInterface.getApp(), localQQAppInterface.getAccount(), i, paramConfig.c, paramConfig.jdField_a_of_type_Int, paramConfig.d, paramConfig.e);
  }
  
  public static void w(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    int i = paramConfig.version.get();
    int j = bbkb.as(BaseApplication.getContext(), jdField_a_of_type_JavaLangString);
    if (QLog.isColorLevel()) {
      QLog.i("SPLASH_ConfigServlet", 2, "handleReceiptConfig: ,version: " + paramConfig.version.get() + "| localVersion: " + j);
    }
    if (i != j)
    {
      bbkb.P(BaseApplication.getContext(), jdField_a_of_type_JavaLangString, i);
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
              bbkb.e(BaseApplication.getContext(), jdField_a_of_type_JavaLangString, "receipt_kReceiptMsgEnable", i);
            }
            if (((JSONObject)localObject).has("kReceiptMsgMaxSendTimes"))
            {
              i = ((JSONObject)localObject).getInt("kReceiptMsgMaxSendTimes");
              bbkb.e(BaseApplication.getContext(), jdField_a_of_type_JavaLangString, "receipt_kReceiptMsgSendTimes", i);
            }
          }
          catch (JSONException localJSONException)
          {
            localJSONException.printStackTrace();
          }
        }
        acsx.a(paramQQAppInterface);
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
      localObject = (akaa)((QQAppInterface)localObject).getManager(159);
      if (paramConfig.content_list.size() < 0)
      {
        str = (String)paramConfig.content_list.get(0);
        i = paramConfig.version.get();
        j = ((akaa)localObject).b();
        if (QLog.isColorLevel()) {
          QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 74,content: " + str + ",version: " + paramConfig.version.get());
        }
        if ((i != j) || (paramConfig.content_list.size() > 0)) {
          ((akaa)localObject).a(i, str);
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
    //   1: invokevirtual 47	andt:getAppRuntime	()Lmqq/app/AppRuntime;
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
    //   28: invokestatic 1613	bbkb:at	(Landroid/content/Context;Ljava/lang/String;)I
    //   31: istore_2
    //   32: aload 71
    //   34: invokevirtual 65	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   37: aload 71
    //   39: invokevirtual 69	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   42: invokestatic 1616	bbkb:au	(Landroid/content/Context;Ljava/lang/String;)I
    //   45: istore_3
    //   46: invokestatic 203	com/tencent/common/config/AppSetting:a	()I
    //   49: istore 4
    //   51: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   54: ifeq +49 -> 103
    //   57: ldc 183
    //   59: iconst_2
    //   60: ldc_w 4917
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
    //   121: invokestatic 4919	bbkb:Q	(Landroid/content/Context;Ljava/lang/String;I)V
    //   124: iconst_0
    //   125: istore_2
    //   126: iload 34
    //   128: iload_2
    //   129: if_icmpeq +3257 -> 3386
    //   132: aload_1
    //   133: iload_2
    //   134: sipush 228
    //   137: invokestatic 2277	andt:b	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;II)Ljava/lang/String;
    //   140: astore 72
    //   142: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   145: ifeq +12 -> 157
    //   148: ldc_w 4921
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
    //   523: ldc_w 4923
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
    //   669: ldc_w 4925
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
    //   815: ldc_w 4927
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
    //   961: ldc_w 4929
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
    //   1102: ldc_w 4931
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
    //   1244: ldc_w 4933
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
    //   1398: ldc_w 4935
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
    //   2863: invokestatic 4385	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
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
    //   2992: invokestatic 4385	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
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
    //   3116: invokestatic 4385	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
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
    //   3292: invokestatic 4940	aekp:a	()Laekp;
    //   3295: aload 71
    //   3297: invokevirtual 4943	aekp:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)Ljava/lang/String;
    //   3300: astore 39
    //   3302: invokestatic 4940	aekp:a	()Laekp;
    //   3305: aload 71
    //   3307: invokevirtual 4945	aekp:c	(Lcom/tencent/mobileqq/app/QQAppInterface;)Ljava/lang/String;
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
    //   3337: invokestatic 4940	aekp:a	()Laekp;
    //   3340: iload_3
    //   3341: iload 4
    //   3343: aload_1
    //   3344: aload 36
    //   3346: aload 38
    //   3348: aload 37
    //   3350: iload 35
    //   3352: iload 5
    //   3354: invokevirtual 4948	aekp:a	(IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZI)V
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
    //   3383: invokestatic 4951	bbkb:a	(Landroid/content/Context;Ljava/lang/String;IIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZI)V
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
    //   3411: ldc_w 4921
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
    //   3460: ldc_w 4921
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
    //   3509: ldc_w 4921
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
    //   3558: ldc_w 4921
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
    //   3607: ldc_w 4921
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
    //   3656: ldc_w 4921
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
    //   3710: ldc_w 4953
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
    //   0	3805	0	this	andt
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
    int i = bbkb.av(localQQAppInterface.getApp(), localQQAppInterface.getAccount());
    int j = bbkb.aw(localQQAppInterface.getApp(), localQQAppInterface.getAccount());
    int k = AppSetting.a();
    if (QLog.isColorLevel()) {
      QLog.d("SPLASH_ConfigServlet", 2, String.format("received TimUserSpecial remote version: %d, localVersion: %d ,originalAppId:%d, currentAppId:%d", new Object[] { Integer.valueOf(n), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) }));
    }
    if (j != k)
    {
      bbkb.R(localQQAppInterface.getApp(), localQQAppInterface.getAccount(), k);
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
          paramConfig = aexi.a().a(localQQAppInterface);
          localObject = aexi.a().b(localQQAppInterface);
          bool = false;
          if ((!paramConfig.equals(localConfig)) || (!((String)localObject).equals(str))) {
            break label490;
          }
          aexi.a().a(0, m, localConfig, "", str, "", bool, 0);
          bbkb.b(localQQAppInterface.getApp(), localQQAppInterface.getCurrentAccountUin(), n, 0, m, localConfig, str, "", "", bool, 0);
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
    int i = bbkb.C(localQQAppInterface.getApp(), localQQAppInterface.getAccount());
    int j = bbkb.y(localQQAppInterface.getApp(), localQQAppInterface.getAccount());
    int k = AppSetting.a();
    if (QLog.isColorLevel()) {
      QLog.d("pokeMsg", 2, String.format("handlePokeMsgConfig.received PokeMsgConfig remote version: %d, localVersion: %d ,originalAppId:%d, currentAppId:%d", new Object[] { Integer.valueOf(i58), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) }));
    }
    if (j != k)
    {
      bbkb.j(localQQAppInterface.getApp(), localQQAppInterface.getAccount(), k);
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
            localObject5 = adwj.a(localQQAppInterface, 5);
            localObject9 = adwj.a(localQQAppInterface, 6);
            if ((localObject4 == null) || (!((String)localObject4).equals(localObject5)) || (localObject3 == null) || (!((String)localObject3).equals(localObject9)))
            {
              adwj.jdField_b_of_type_Boolean = false;
              adwj.c = false;
              bbkb.a(false);
              adwj.a(localQQAppInterface, (String)localObject4, (String)localObject3, adwj.d);
            }
            bbkb.a(localQQAppInterface.getApp(), localQQAppInterface.getAccount(), k, (String)localObject4, (String)localObject3, (String)localObject1, (String)localObject7, j, m, n, i1);
            adwj.a(localQQAppInterface, k, (String)localObject4, (String)localObject3, (String)localObject1, (String)localObject7, j, n, i1);
            adwj.b(m);
          }
          if ((i10 != 0) && (i23 != 0) && (i8 != 0) && (i7 != 0) && (i6 != 0))
          {
            localQQAppInterface.getApp().getSharedPreferences(localQQAppInterface.getCurrentAccountUin(), 0).edit().putBoolean("chat_tool_poke_clicked", false).commit();
            adwj.b(localQQAppInterface, false);
            adwj.a(localQQAppInterface, false);
            adwj.a(i19, i25, i14, i13);
            bbkb.a(localQQAppInterface.getApp(), localQQAppInterface.getAccount(), i58, true, i19, i25, i14, i13);
            adwj.a((String)localObject2);
            bbkb.b(localQQAppInterface.getApp(), localQQAppInterface.getAccount(), i58, (String)localObject2);
            adwj.a(i3);
            bbkb.a(localQQAppInterface.getApp(), localQQAppInterface.getAccount(), i58, i3);
            adwj.c(i2);
            bbkb.b(localQQAppInterface.getApp(), localQQAppInterface.getAccount(), i58, i2);
            adwj.a(i35, i4);
            bbkb.a(localQQAppInterface.getApp(), localQQAppInterface.getAccount(), i58, i35, i4);
          }
          if ((i5 != 0) && (i36 != 0) && (i36 != 0))
          {
            localObject1 = PreferenceManager.getDefaultSharedPreferences(localQQAppInterface.getApp()).getString(localQQAppInterface.getAccount() + "_" + "aio_poke_res_url", "");
            bbkb.a(localQQAppInterface.getApp(), localQQAppInterface.getAccount(), i58, l2, (String)localObject13, (String)localObject17);
            if ((localObject13 != null) && (!((String)localObject13).equals(localObject1))) {
              ((PokeBigResHandler)localQQAppInterface.a(117)).a(true);
            }
          }
          adwj.c(i2);
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
          localObject9 = adwj.a(localObject19[1]);
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
          i16 = adwj.c(localObject19[1]);
        }
        try
        {
          i17 = adwj.b(localObject19[1]);
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
          i19 = adwj.a(localObject19[1]);
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
          i15 = adwj.d(localObject19[1]);
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
      i8 = adwj.h;
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
      i9 = adwj.i;
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
        if (balw.a().a(paramConfig)) {
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
      ((acto)paramQQAppInterface.getManager(218)).d();
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
    paramQQAppInterface = (acto)paramQQAppInterface.getManager(218);
    paramQQAppInterface.a(paramConfig);
    paramQQAppInterface.c();
  }
  
  public void D(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    int i = paramConfig.version.get();
    if (i != axjr.a(paramQQAppInterface.getApp()))
    {
      paramConfig = a(paramConfig);
      if ((paramConfig != null) && (paramConfig.size() > 0)) {
        axjr.a((String)paramConfig.get(0), i, paramQQAppInterface.getApp());
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
      i = bbkb.a(paramQQAppInterface.getApp(), "sport_config", jdField_a_of_type_JavaLangString);
      j = paramConfig.version.get();
    } while (i == j);
    ((bbuw)paramQQAppInterface.getManager(260)).a(paramConfig);
    bbkb.a(paramQQAppInterface.getApp(), "sport_config", jdField_a_of_type_JavaLangString, j);
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
        str = a(paramConfig, bbkb.a(paramQQAppInterface.getApp(), "troop_gift_anim_limit", "0"), 281);
      } while (TextUtils.isEmpty(str));
      if (QLog.isColorLevel()) {
        QLog.d("SPLASH_ConfigServlet", 2, "handleTroopGiftLimitConfig content: " + str);
      }
      int i = paramConfig.version.get();
      bbkb.a(paramQQAppInterface.getApp(), "troop_gift_anim_limit", "0", i);
      try
      {
        i = new JSONObject(str).getInt("limitGiftAnimCount");
        bahf.jdField_b_of_type_Int = i;
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
      xop.c();
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
      i = bbkb.a(paramQQAppInterface.getApp(), "task_entry_config_version", jdField_a_of_type_JavaLangString);
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
          bbkb.a(paramQQAppInterface.getApp(), "task_entry_config_version", jdField_a_of_type_JavaLangString, j);
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
    if (i != bkvg.a().a(paramQQAppInterface.getApp()))
    {
      paramConfig = a(paramConfig);
      if ((paramConfig != null) && (paramConfig.size() > 0))
      {
        paramConfig = (String)paramConfig.get(paramConfig.size() - 1);
        bkvg.a().a(paramConfig, i, paramQQAppInterface.getApp());
      }
    }
  }
  
  public void L(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    int i = paramConfig.version.get();
    if (i != bkzo.a().a(paramQQAppInterface.getApp()))
    {
      paramConfig = a(paramConfig);
      if ((paramConfig != null) && (paramConfig.size() > 0))
      {
        paramConfig = (String)paramConfig.get(0);
        bkzo.a().a(paramConfig, i, paramQQAppInterface.getApp());
      }
    }
  }
  
  public void M(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    int i = paramConfig.version.get();
    int j = bbkb.a(paramQQAppInterface.getApp(), "buluo_enter_config_version", jdField_a_of_type_JavaLangString);
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
                paramConfig = paramConfig + bbco.encodeToString(((String)localObject2).getBytes(), 0);
                bbkb.c(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin(), paramConfig);
                if (QLog.isColorLevel()) {
                  QLog.e("SPLASH_ConfigServlet", 2, new Object[] { "handleBuluoEnterConfig. buluoEntryUrl: ", paramConfig });
                }
              }
            }
          }
          for (;;)
          {
            bbkb.a(paramQQAppInterface.getApp(), "buluo_enter_config_version", jdField_a_of_type_JavaLangString, i);
            return;
            if (paramConfig.has("tribe_summary_url"))
            {
              paramConfig = paramConfig.optJSONObject("tribe_summary_url");
              if (paramConfig.has("android"))
              {
                paramConfig = paramConfig.optString("android");
                bbkb.d(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin(), paramConfig);
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
    akxf localakxf = (akxf)((QQAppInterface)getAppRuntime()).getManager(220);
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
      arrayOfByte = augv.a(paramIntent.content.get().toByteArray());
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
          if (localakxf.b(paramIntent)) {
            localakxf.b(i);
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
        if (localakxf != null) {
          localakxf.c();
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
                paramConfig = augv.a(paramIntent.content.get().toByteArray());
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
      arrayOfByte = augv.a(paramIntent.content.get().toByteArray());
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
        alcl.a(paramQQAppInterface, paramIntent, paramConfig.version.get());
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
      alcl.b(paramQQAppInterface);
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
          byte[] arrayOfByte = augv.a(((ConfigurationService.Content)localObject1).content.get().toByteArray());
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
            if ((i == bbkb.a(paramQQAppInterface.getApp(), "nearby_glamour_level_config_version", jdField_a_of_type_JavaLangString)) || (TextUtils.isEmpty((CharSequence)localObject1))) {
              continue;
            }
            aszp.a((String)localObject1);
            aszp.b((String)localObject1);
            bbkb.h(paramQQAppInterface.getApp(), (String)localObject1);
            bbkb.a(paramQQAppInterface.getApp(), "nearby_glamour_level_config_version", jdField_a_of_type_JavaLangString, i);
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
  
  protected void a(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig, String paramString, andw paramandw)
  {
    int j = paramConfig.version.get();
    int i = paramandw.a();
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
          arrayOfByte = augv.a(paramQQAppInterface.content.get().toByteArray());
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
      paramandw.a(j);
      paramandw.a(localArrayList);
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
            if ((j != bbkb.L(localQQAppInterface.getApp(), localQQAppInterface.getCurrentAccountUin())) || (paramConfig.content_list.size() > 0))
            {
              str = str.split("=")[1];
              if (!TextUtils.isEmpty(str)) {
                bhvy.c(str, localQQAppInterface);
              }
              bbkb.o(localQQAppInterface.getApp(), j, localQQAppInterface.getCurrentAccountUin());
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
          amfv.a(BaseApplicationImpl.getContext(), k);
          if (QLog.isColorLevel()) {
            QLog.d("Q.camera.configServlet", 2, "[handleRespQCameraPhoneConfig] save version: " + k + " and check config version: " + amfv.a(BaseApplicationImpl.getContext()));
          }
          if ((paramConfig.msg_content_list == null) || (paramConfig.msg_content_list.size() <= 0)) {
            break label560;
          }
          paramIntent = (ConfigurationService.Content)paramConfig.msg_content_list.get(0);
          i = paramIntent.task_id.get();
          if (paramIntent.compress.get() != 1) {
            break label506;
          }
          paramIntent = amfv.a(paramIntent.content.get().toByteArray());
          if (paramIntent == null)
          {
            paramInt = 4;
            amfv.a(BaseApplicationImpl.getContext(), true);
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
          axrn.a(BaseApplication.getContext()).a(str, "qcamera_phone_config_pull_event", paramBoolean, 0L, 0L, paramIntent, String.valueOf(j));
          return;
          paramInt = 0;
          paramIntent = new String(paramIntent);
          if (QLog.isColorLevel()) {
            QLog.d("Q.camera.configServlet", 4, "[handleRespQCameraPhoneConfig] zip");
          }
          try
          {
            amfv.a(BaseApplicationImpl.getContext(), paramIntent, k);
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
          amfv.a(BaseApplicationImpl.getContext(), paramIntent, k);
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
      QLog.w("Q.camera.configServlet", 1, "[handleRespQCameraPhoneConfig] no data, current disableCameraSDK=" + amfv.a(BaseApplicationImpl.getContext()));
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
        awhn localawhn = (awhn)paramQQAppInterface.getManager(222);
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
                byte[] arrayOfByte = augv.a(((ConfigurationService.Content)localObject1).content.get().toByteArray());
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
                  if ((j == bbkb.a(paramQQAppInterface.getApp(), "search_function_config_version", jdField_a_of_type_JavaLangString)) || (TextUtils.isEmpty((CharSequence)localObject1))) {
                    continue;
                  }
                  localawhn.b(new JSONObject((String)localObject1).optString("kFTSFunctionListUrlKey"));
                  bbkb.a(paramQQAppInterface.getApp(), "search_function_config_version", jdField_a_of_type_JavaLangString, j);
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
            if ((j != bbkb.K(localQQAppInterface.getApp(), localQQAppInterface.c())) || (paramConfig.content_list.size() > 0))
            {
              if (bhvy.a(localQQAppInterface, str))
              {
                if (QLog.isColorLevel()) {
                  QLog.d("SPLASH_ConfigServlet", 2, "received 72 ark config");
                }
                bbkb.s(getAppRuntime().getApplication(), localQQAppInterface.c(), j);
                break label304;
              }
              if ((!sfe.b((QQAppInterface)getAppRuntime(), str)) || (!QLog.isColorLevel())) {
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
            if ((j != bbkb.x(localQQAppInterface.getApp())) || (paramConfig.content_list.size() > 0))
            {
              Object localObject2 = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new ByteArrayInputStream(((String)localObject1).getBytes("utf-8")));
              localObject1 = (Element)((Document)localObject2).getElementsByTagName("kandian_setting").item(0);
              localObject2 = (Element)((Document)localObject2).getElementsByTagName("url").item(0);
              localObject1 = ((Element)localObject1).getFirstChild().getNodeValue();
              localObject2 = ((Element)localObject2).getFirstChild().getNodeValue();
              if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!TextUtils.isEmpty((CharSequence)localObject2))) {
                bbkb.b(localQQAppInterface.getApp(), (String)localObject2, "1".equals(localObject1));
              }
              bbkb.o(localQQAppInterface.getApp(), j);
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
            byte[] arrayOfByte = augv.a(((ConfigurationService.Content)localObject1).content.get().toByteArray());
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
              asyj.a(paramQQAppInterface, (String)localObject1, paramConfig.version.get());
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
      int i = bbkb.a(paramQQAppInterface.getApp(), "shop_tab", jdField_a_of_type_JavaLangString);
      int j = paramConfig.version.get();
      if ((i != j) && (paramConfig.content_list != null) && (paramConfig.content_list.size() > 0)) {
        try
        {
          paramConfig = new JSONObject((String)paramConfig.content_list.get(0));
          boolean bool = paramConfig.getBoolean("android");
          bbkb.a(paramQQAppInterface.getApp(), "shop_tab", jdField_a_of_type_JavaLangString, j);
          paramQQAppInterface = (nqn)paramQQAppInterface.getManager(88);
          paramQQAppInterface.b(bool);
          paramQQAppInterface.c = paramConfig.optBoolean("preload_web_process", false);
          paramQQAppInterface.a = paramConfig.optLong("stay_time", 5000L);
          paramQQAppInterface.d = paramConfig.optInt("day_limit", 3);
          nqn.a().edit().putBoolean("preload_web", paramQQAppInterface.c).putLong("stayTime", paramQQAppInterface.a).putInt("dayLimit", paramQQAppInterface.d).commit();
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
    int i = bbkb.X(paramQQAppInterface.getApp(), paramQQAppInterface.c());
    int j = paramConfig.version.get();
    if (i == j)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SPLASH_ConfigServlet", 2, "handleQuickShotShareToStoryConfig version code not changed .");
      }
      return;
    }
    bbkb.x(paramQQAppInterface.getApp(), paramQQAppInterface.c(), j);
    if ((paramConfig.msg_content_list == null) || (paramConfig.msg_content_list.size() < 1) || (paramConfig.msg_content_list.get(0) == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SPLASH_ConfigServlet", 2, "handleQuickShotShareToStoryConfig data is null!!!");
      }
      bbkb.h(paramQQAppInterface.getApp(), paramQQAppInterface.c(), null);
      return;
    }
    paramConfig = (ConfigurationService.Content)paramConfig.msg_content_list.get(0);
    byte[] arrayOfByte;
    if (paramConfig.compress.get() == 1)
    {
      arrayOfByte = augv.a(paramConfig.content.get().toByteArray());
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
        bbkb.h(paramQQAppInterface.getApp(), paramQQAppInterface.c(), paramConfig);
        ((sst)paramQQAppInterface.getManager(181)).a(paramConfig);
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
      bbkb.h(paramQQAppInterface.getApp(), paramQQAppInterface.c(), null);
    }
  }
  
  void g(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    int i = bbkb.ab(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
    int j = paramConfig.version.get();
    if ((i != j) && (paramConfig.msg_content_list != null) && (paramConfig.msg_content_list.size() > 0))
    {
      paramConfig = (ConfigurationService.Content)paramConfig.msg_content_list.get(0);
      if (paramConfig != null)
      {
        if (paramConfig.compress.get() != 1) {
          break label219;
        }
        paramConfig = augv.a(paramConfig.content.get().toByteArray());
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
          bbkb.l(paramQQAppInterface.getApp(), "wifiAutoPreDown", "" + bool1);
          bbkb.l(paramQQAppInterface.getApp(), "noSafeDown", "" + bool2);
          bbkb.B(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, j);
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
    int i = bbkb.Z(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
    int j = paramConfig.version.get();
    if ((i != j) && (paramConfig.msg_content_list != null) && (paramConfig.msg_content_list.size() > 0))
    {
      paramConfig = (ConfigurationService.Content)paramConfig.msg_content_list.get(0);
      if (paramConfig != null)
      {
        if (paramConfig.compress.get() != 1) {
          break label206;
        }
        paramConfig = augv.a(paramConfig.content.get().toByteArray());
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
          bbkb.k(paramQQAppInterface.getApp(), "url", paramConfig);
          bbkb.k(paramQQAppInterface.getApp(), "thxWord", (String)localObject);
          bbkb.k(paramQQAppInterface.getApp(), "wantWord", str);
          bbkb.A(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, j);
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
        i = bbkb.ac(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
        j = paramConfig.version.get();
      } while ((i == j) || (paramConfig.msg_content_list == null) || (paramConfig.msg_content_list.size() <= 0));
      paramConfig = (ConfigurationService.Content)paramConfig.msg_content_list.get(0);
    } while (paramConfig == null);
    if (paramConfig.compress.get() == 1)
    {
      paramConfig = augv.a(paramConfig.content.get().toByteArray());
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
          bbkb.C(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, j);
          bbkb.d(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, bool);
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
          int k = sfe.c(paramQQAppInterface);
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
                  localObject = augv.a(((ConfigurationService.Content)localObject).content.get().toByteArray());
                  if (localObject == null) {
                    break label310;
                  }
                  try
                  {
                    localObject = new String((byte[])localObject, "UTF-8");
                    if (QLog.isColorLevel()) {
                      QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 184, version:" + paramConfig.version.get() + ", content:" + (String)localObject);
                    }
                    sfe.a(paramQQAppInterface, (String)localObject, j);
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
    //   1: getfield 2572	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:type	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   4: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   7: sipush 191
    //   10: if_icmpeq +4 -> 14
    //   13: return
    //   14: aload_1
    //   15: invokevirtual 65	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   18: getstatic 15	andt:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   21: invokestatic 1947	bbkb:ap	(Landroid/content/Context;Ljava/lang/String;)I
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
    //   56: ldc_w 5621
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
    //   127: invokestatic 321	augv:a	([B)[B
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
    //   167: ldc_w 5623
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
    //   200: invokevirtual 5624	org/json/JSONObject:length	()I
    //   203: ifle -190 -> 13
    //   206: new 1125	java/util/ArrayList
    //   209: dup
    //   210: invokespecial 1126	java/util/ArrayList:<init>	()V
    //   213: astore_2
    //   214: aload 5
    //   216: invokevirtual 5627	org/json/JSONObject:keys	()Ljava/util/Iterator;
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
    //   252: new 5154	com/tencent/mobileqq/data/AppGuideTipsConfig
    //   255: dup
    //   256: invokespecial 5155	com/tencent/mobileqq/data/AppGuideTipsConfig:<init>	()V
    //   259: astore 9
    //   261: aload 9
    //   263: aload 7
    //   265: putfield 5630	com/tencent/mobileqq/data/AppGuideTipsConfig:tipsType	Ljava/lang/String;
    //   268: aload 9
    //   270: aload 8
    //   272: ldc_w 5163
    //   275: invokevirtual 420	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   278: putfield 5166	com/tencent/mobileqq/data/AppGuideTipsConfig:switchKey	Ljava/lang/String;
    //   281: aload 9
    //   283: aload 8
    //   285: ldc_w 5168
    //   288: invokevirtual 420	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   291: invokestatic 4385	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   294: invokevirtual 1829	java/lang/Integer:intValue	()I
    //   297: putfield 5171	com/tencent/mobileqq/data/AppGuideTipsConfig:maxCount	I
    //   300: aload 9
    //   302: aload 8
    //   304: ldc_w 5173
    //   307: invokevirtual 420	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   310: invokestatic 5092	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   313: invokevirtual 5095	java/lang/Long:longValue	()J
    //   316: putfield 5175	com/tencent/mobileqq/data/AppGuideTipsConfig:duration	J
    //   319: aload 9
    //   321: aload 8
    //   323: ldc_w 779
    //   326: invokevirtual 420	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   329: putfield 5180	com/tencent/mobileqq/data/AppGuideTipsConfig:tipsUrl	Ljava/lang/String;
    //   332: aload 9
    //   334: aload 8
    //   336: ldc_w 5632
    //   339: invokevirtual 420	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   342: putfield 5634	com/tencent/mobileqq/data/AppGuideTipsConfig:opkey	Ljava/lang/String;
    //   345: aload 9
    //   347: aload 8
    //   349: ldc_w 5185
    //   352: invokevirtual 420	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   355: putfield 5188	com/tencent/mobileqq/data/AppGuideTipsConfig:msgTypeStr	Ljava/lang/String;
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
    //   390: putfield 5183	com/tencent/mobileqq/data/AppGuideTipsConfig:tipsMsg	Ljava/lang/String;
    //   393: aload 8
    //   395: ldc_w 734
    //   398: invokevirtual 405	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   401: ifeq +92 -> 493
    //   404: aload 9
    //   406: aload 8
    //   408: ldc_w 734
    //   411: invokevirtual 420	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   414: putfield 5637	com/tencent/mobileqq/data/AppGuideTipsConfig:tipsHighLight	Ljava/lang/String;
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
    //   440: ldc_w 5639
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
    //   481: ldc_w 5641
    //   484: invokevirtual 420	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   487: putfield 5183	com/tencent/mobileqq/data/AppGuideTipsConfig:tipsMsg	Ljava/lang/String;
    //   490: goto -97 -> 393
    //   493: aload 9
    //   495: aload 8
    //   497: ldc_w 5643
    //   500: invokevirtual 420	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   503: putfield 5637	com/tencent/mobileqq/data/AppGuideTipsConfig:tipsHighLight	Ljava/lang/String;
    //   506: goto -89 -> 417
    //   509: aload 9
    //   511: aload 8
    //   513: ldc_w 5641
    //   516: invokevirtual 420	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   519: putfield 5183	com/tencent/mobileqq/data/AppGuideTipsConfig:tipsMsg	Ljava/lang/String;
    //   522: aload 9
    //   524: aload 8
    //   526: ldc_w 5643
    //   529: invokevirtual 420	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   532: putfield 5637	com/tencent/mobileqq/data/AppGuideTipsConfig:tipsHighLight	Ljava/lang/String;
    //   535: goto -118 -> 417
    //   538: aload_1
    //   539: sipush 218
    //   542: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   545: checkcast 3328	acto
    //   548: astore 5
    //   550: aload 5
    //   552: aload_2
    //   553: invokevirtual 5644	acto:a	(Ljava/util/List;)V
    //   556: aload 5
    //   558: invokevirtual 3329	acto:a	()V
    //   561: aload_1
    //   562: invokevirtual 65	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   565: getstatic 15	andt:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   568: iload 4
    //   570: invokestatic 5646	bbkb:N	(Landroid/content/Context;Ljava/lang/String;I)V
    //   573: return
    //   574: aconst_null
    //   575: astore_2
    //   576: goto -429 -> 147
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	579	0	this	andt
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
    int i = bbkb.aa(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
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
        paramConfig = augv.a(paramConfig.content.get().toByteArray());
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
        bbkb.z(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, j);
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
          i = bbkb.ah(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
          j = paramConfig.version.get();
          if (QLog.isColorLevel()) {
            QLog.d("DoutuSPLASH_ConfigServlet", 2, "handleDoutuConfig reqVersion = " + i + ", version=" + j);
          }
        } while (i == j);
        bbkb.I(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, j);
      } while ((paramConfig.msg_content_list == null) || (paramConfig.msg_content_list.size() <= 0));
      paramConfig = (ConfigurationService.Content)paramConfig.msg_content_list.get(0);
    } while (paramConfig == null);
    if (paramConfig.compress.get() == 1)
    {
      paramConfig = augv.a(paramConfig.content.get().toByteArray());
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
            bbkb.f((Context)localObject, str2, bool1);
            bbkb.b(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, l1);
            bbkb.M(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, j);
            localObject = paramQQAppInterface.getApp();
            str2 = jdField_a_of_type_JavaLangString;
            if (k != 1) {
              break label1224;
            }
            bool1 = true;
            bbkb.h((Context)localObject, str2, bool1);
            localObject = paramQQAppInterface.getApp();
            str2 = jdField_a_of_type_JavaLangString;
            if (m != 1) {
              break label1230;
            }
            bool1 = true;
            bbkb.i((Context)localObject, str2, bool1);
            if (paramConfig != null) {
              bbkb.n(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, paramConfig);
            }
            if (str1 != null) {
              bbkb.o(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, str1);
            }
            bbkb.c(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, l2);
            bbkb.d(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, l3);
            bbkb.K(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, n);
            paramQQAppInterface = (anoi)getAppRuntime().getManager(214);
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
        bbkb.k(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
        bbkb.r(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
        bbkb.l(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
        bbkb.m(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
        bbkb.o(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
        bbkb.p(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
        bbkb.t(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
        bbkb.u(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
        bbkb.n(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
        bbkb.m(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
        bbkb.s(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
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
          i = bbkb.t(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
          j = paramConfig.version.get();
          if (QLog.isColorLevel()) {
            QLog.d("GreenVideoSPLASH_ConfigServlet", 2, "handleGreenVideoConfig reqVersion = " + i + ", version=" + j);
          }
        } while (i == j);
        bbkb.f(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, j);
      } while ((paramConfig.msg_content_list == null) || (paramConfig.msg_content_list.size() <= 0));
      paramConfig = (ConfigurationService.Content)paramConfig.msg_content_list.get(0);
    } while (paramConfig == null);
    if (paramConfig.compress.get() == 1)
    {
      paramConfig = augv.a(paramConfig.content.get().toByteArray());
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
        bbkb.e(paramQQAppInterface.getApp(), paramConfig);
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
      bbkb.a(paramQQAppInterface.getApp());
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
    //   1: getfield 2572	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:type	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   4: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   7: sipush 272
    //   10: if_icmpeq +4 -> 14
    //   13: return
    //   14: aload_1
    //   15: invokevirtual 65	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   18: getstatic 15	andt:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   21: invokestatic 1914	bbkb:v	(Landroid/content/Context;Ljava/lang/String;)I
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
    //   50: ldc_w 5776
    //   53: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: iload_3
    //   57: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   60: ldc_w 5680
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
    //   87: getstatic 15	andt:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   90: iload 4
    //   92: invokestatic 1903	bbkb:h	(Landroid/content/Context;Ljava/lang/String;I)V
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
    //   149: invokestatic 321	augv:a	([B)[B
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
    //   189: ldc_w 5778
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
    //   230: ldc_w 5780
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
    //   265: ldc_w 5782
    //   268: invokeinterface 939 2 0
    //   273: ifnull +42 -> 315
    //   276: aload 5
    //   278: aload_2
    //   279: ldc_w 5782
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
    //   316: ldc_w 5784
    //   319: invokeinterface 939 2 0
    //   324: ifnull +42 -> 366
    //   327: aload 5
    //   329: aload_2
    //   330: ldc_w 5784
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
    //   367: ldc_w 5786
    //   370: invokeinterface 939 2 0
    //   375: ifnull +42 -> 417
    //   378: aload 5
    //   380: aload_2
    //   381: ldc_w 5786
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
    //   418: ldc_w 5788
    //   421: invokeinterface 939 2 0
    //   426: ifnull +42 -> 468
    //   429: aload 5
    //   431: aload_2
    //   432: ldc_w 5788
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
    //   469: ldc_w 5790
    //   472: invokeinterface 939 2 0
    //   477: ifnull +42 -> 519
    //   480: aload 5
    //   482: aload_2
    //   483: ldc_w 5790
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
    //   520: ldc_w 5792
    //   523: invokeinterface 939 2 0
    //   528: ifnull +60 -> 588
    //   531: aload_2
    //   532: ldc_w 5792
    //   535: invokeinterface 939 2 0
    //   540: iconst_0
    //   541: invokeinterface 950 2 0
    //   546: ifnull +42 -> 588
    //   549: aload 5
    //   551: aload_2
    //   552: ldc_w 5792
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
    //   589: ldc_w 5794
    //   592: invokeinterface 939 2 0
    //   597: ifnull +60 -> 657
    //   600: aload_2
    //   601: ldc_w 5794
    //   604: invokeinterface 939 2 0
    //   609: iconst_0
    //   610: invokeinterface 950 2 0
    //   615: ifnull +42 -> 657
    //   618: aload 5
    //   620: aload_2
    //   621: ldc_w 5794
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
    //   658: ldc_w 5796
    //   661: invokeinterface 939 2 0
    //   666: ifnull +60 -> 726
    //   669: aload_2
    //   670: ldc_w 5796
    //   673: invokeinterface 939 2 0
    //   678: iconst_0
    //   679: invokeinterface 950 2 0
    //   684: ifnull +42 -> 726
    //   687: aload 5
    //   689: aload_2
    //   690: ldc_w 5796
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
    //   727: ldc_w 5798
    //   730: invokeinterface 939 2 0
    //   735: ifnull +52 -> 787
    //   738: aload_2
    //   739: ldc_w 5798
    //   742: invokeinterface 939 2 0
    //   747: iconst_0
    //   748: invokeinterface 950 2 0
    //   753: ifnull +34 -> 787
    //   756: aload 5
    //   758: aload_2
    //   759: ldc_w 5798
    //   762: invokeinterface 939 2 0
    //   767: iconst_0
    //   768: invokeinterface 950 2 0
    //   773: invokeinterface 956 1 0
    //   778: invokeinterface 959 1 0
    //   783: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   786: pop
    //   787: aload_1
    //   788: invokevirtual 65	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   791: getstatic 15	andt:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   794: aload 5
    //   796: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   799: invokestatic 5800	bbkb:p	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    //   802: return
    //   803: astore_1
    //   804: ldc 183
    //   806: iconst_1
    //   807: new 85	java/lang/StringBuilder
    //   810: dup
    //   811: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   814: ldc_w 5802
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
    //   841: ldc_w 5804
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
    //   875: ldc_w 5806
    //   878: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   881: aload_1
    //   882: invokevirtual 65	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   885: getstatic 15	andt:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   888: invokestatic 5808	bbkb:q	(Landroid/content/Context;Ljava/lang/String;)V
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
    //   0	941	0	this	andt
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
        andx.a("0", arrayOfInt, paramFromServiceMsg.getResultCode());
        axnq.a(arrayOfInt, paramFromServiceMsg);
        int k = arrayOfInt.length;
        i = j;
        while (i < k)
        {
          if (arrayOfInt[i] == 215)
          {
            ShortVideoResourceManager.a(-5);
            bjah.d("SPLASH_ConfigServlet", "【SHORT_VIDEO_RESOURCE_CONFIG】RES_OVERTIME");
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
            zct.a(((ConfigurationService.RespGetConfig)localObject).min_req_interval_for_reconnect.get());
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
    //   1: invokestatic 1933	ayaj:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)I
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
    //   30: ldc_w 5874
    //   33: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: iload 4
    //   38: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   41: ldc_w 5876
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
    //   69: checkcast 1932	ayaj
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
    //   128: invokestatic 321	augv:a	([B)[B
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
    //   160: ldc_w 5878
    //   163: invokevirtual 408	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   166: istore 4
    //   168: aload 5
    //   170: iload 4
    //   172: invokevirtual 5879	ayaj:a	(I)V
    //   175: ldc 183
    //   177: iconst_1
    //   178: new 85	java/lang/StringBuilder
    //   181: dup
    //   182: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   185: ldc_w 5881
    //   188: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   191: aload_2
    //   192: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   195: ldc_w 5883
    //   198: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   201: iload 4
    //   203: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   206: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   209: invokestatic 199	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   212: aload_1
    //   213: iload_3
    //   214: invokestatic 5884	ayaj:a	(Lcom/tencent/mobileqq/app/QQAppInterface;I)V
    //   217: return
    //   218: astore_2
    //   219: ldc 183
    //   221: iconst_1
    //   222: new 85	java/lang/StringBuilder
    //   225: dup
    //   226: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   229: ldc_w 5886
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
    //   275: ldc_w 5888
    //   278: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   281: aload_2
    //   282: invokevirtual 798	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   285: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   288: invokestatic 642	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   291: goto -79 -> 212
    //   294: ldc 183
    //   296: iconst_1
    //   297: ldc_w 5890
    //   300: invokestatic 199	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   303: aload 5
    //   305: iconst_0
    //   306: invokevirtual 5879	ayaj:a	(I)V
    //   309: goto -97 -> 212
    //   312: aconst_null
    //   313: astore_2
    //   314: goto -166 -> 148
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	317	0	this	andt
    //   0	317	1	paramQQAppInterface	QQAppInterface
    //   0	317	2	paramConfig	ConfigurationService.Config
    //   13	201	3	i	int
    //   4	198	4	j	int
    //   72	232	5	localayaj	ayaj
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
    //   3: getstatic 15	andt:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   6: ldc_w 1923
    //   9: iconst_0
    //   10: invokestatic 305	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   13: invokestatic 1921	atbi:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
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
    //   40: ldc_w 5892
    //   43: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: iload 5
    //   48: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   51: ldc_w 5876
    //   54: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: iload 6
    //   59: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   62: ldc_w 5894
    //   65: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: astore 7
    //   70: aload_2
    //   71: getfield 221	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   74: ifnonnull +109 -> 183
    //   77: iconst_0
    //   78: istore_3
    //   79: ldc_w 5896
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
    //   133: ldc_w 5896
    //   136: iconst_1
    //   137: new 85	java/lang/StringBuilder
    //   140: dup
    //   141: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   144: ldc_w 5898
    //   147: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: aload_2
    //   151: getfield 221	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   154: iload_3
    //   155: invokevirtual 318	com/tencent/mobileqq/pb/PBRepeatMessageField:get	(I)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   158: checkcast 244	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content
    //   161: getfield 3851	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content:task_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
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
    //   235: invokestatic 321	augv:a	([B)[B
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
    //   270: ldc_w 5896
    //   273: iconst_1
    //   274: new 85	java/lang/StringBuilder
    //   277: dup
    //   278: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   281: ldc_w 5900
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
    //   311: ldc_w 5902
    //   314: invokevirtual 5905	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   317: astore 8
    //   319: aload 8
    //   321: invokevirtual 520	org/json/JSONArray:length	()I
    //   324: ifle +18 -> 342
    //   327: getstatic 15	andt:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   330: ldc_w 5907
    //   333: aload 8
    //   335: invokevirtual 5908	org/json/JSONArray:toString	()Ljava/lang/String;
    //   338: invokestatic 1926	atbi:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)Z
    //   341: pop
    //   342: aload 7
    //   344: ldc_w 5910
    //   347: invokevirtual 732	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   350: astore 8
    //   352: aload 8
    //   354: ifnull +18 -> 372
    //   357: getstatic 15	andt:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   360: ldc_w 5912
    //   363: aload 8
    //   365: invokevirtual 5913	org/json/JSONObject:toString	()Ljava/lang/String;
    //   368: invokestatic 1926	atbi:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)Z
    //   371: pop
    //   372: aload 7
    //   374: ldc_w 5915
    //   377: invokevirtual 474	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   380: istore_3
    //   381: aload 8
    //   383: ifnull +17 -> 400
    //   386: getstatic 15	andt:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   389: ldc_w 5917
    //   392: iload_3
    //   393: invokestatic 305	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   396: invokestatic 1926	atbi:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)Z
    //   399: pop
    //   400: aload 7
    //   402: ldc_w 5919
    //   405: invokevirtual 732	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   408: astore 8
    //   410: aload 8
    //   412: ifnull +76 -> 488
    //   415: aload 8
    //   417: ldc_w 5921
    //   420: invokevirtual 474	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   423: istore_3
    //   424: aload 8
    //   426: ldc_w 5923
    //   429: invokevirtual 474	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   432: istore 4
    //   434: aload 8
    //   436: ldc_w 5925
    //   439: invokevirtual 474	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   442: istore 5
    //   444: getstatic 15	andt:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   447: ldc_w 5927
    //   450: iload_3
    //   451: invokestatic 305	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   454: invokestatic 1926	atbi:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)Z
    //   457: pop
    //   458: getstatic 15	andt:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   461: ldc_w 5929
    //   464: iload 4
    //   466: invokestatic 305	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   469: invokestatic 1926	atbi:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)Z
    //   472: pop
    //   473: getstatic 15	andt:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   476: ldc_w 5931
    //   479: iload 5
    //   481: invokestatic 305	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   484: invokestatic 1926	atbi:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)Z
    //   487: pop
    //   488: aload 7
    //   490: ldc_w 5933
    //   493: invokevirtual 5905	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   496: astore 8
    //   498: aload 8
    //   500: ifnull +273 -> 773
    //   503: getstatic 15	andt:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   506: ldc_w 5935
    //   509: aload 8
    //   511: invokevirtual 5908	org/json/JSONArray:toString	()Ljava/lang/String;
    //   514: invokestatic 1926	atbi:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)Z
    //   517: pop
    //   518: getstatic 15	andt:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   521: ldc_w 1923
    //   524: aload_2
    //   525: getfield 55	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   528: invokevirtual 61	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   531: invokestatic 305	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   534: invokestatic 1926	atbi:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)Z
    //   537: pop
    //   538: aload 7
    //   540: ldc_w 5937
    //   543: iconst_0
    //   544: invokevirtual 2283	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   547: istore_3
    //   548: aload 7
    //   550: ldc_w 5939
    //   553: iconst_m1
    //   554: invokevirtual 2283	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   557: istore 4
    //   559: aload 7
    //   561: ldc_w 5941
    //   564: iconst_0
    //   565: invokevirtual 2283	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   568: istore 5
    //   570: aload 7
    //   572: ldc_w 5943
    //   575: iconst_0
    //   576: invokevirtual 2283	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   579: istore 6
    //   581: aload 7
    //   583: ldc_w 5945
    //   586: invokevirtual 137	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   589: astore_2
    //   590: getstatic 15	andt:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   593: ldc_w 5937
    //   596: iload_3
    //   597: invokestatic 305	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   600: invokestatic 1926	atbi:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)Z
    //   603: pop
    //   604: getstatic 15	andt:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   607: ldc_w 5939
    //   610: iload 4
    //   612: invokestatic 305	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   615: invokestatic 1926	atbi:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)Z
    //   618: pop
    //   619: getstatic 15	andt:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   622: ldc_w 5941
    //   625: iload 5
    //   627: invokestatic 305	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   630: invokestatic 1926	atbi:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)Z
    //   633: pop
    //   634: getstatic 15	andt:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   637: ldc_w 5943
    //   640: iload 6
    //   642: invokestatic 305	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   645: invokestatic 1926	atbi:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)Z
    //   648: pop
    //   649: getstatic 15	andt:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   652: ldc_w 5947
    //   655: aload_2
    //   656: invokestatic 1926	atbi:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)Z
    //   659: pop
    //   660: aload 7
    //   662: ldc_w 5949
    //   665: invokevirtual 474	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   668: istore_3
    //   669: getstatic 15	andt:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   672: ldc_w 5949
    //   675: iload_3
    //   676: invokestatic 305	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   679: invokestatic 1926	atbi:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)Z
    //   682: pop
    //   683: aload 7
    //   685: ldc_w 5951
    //   688: invokevirtual 732	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   691: astore_2
    //   692: aload_2
    //   693: ifnull +17 -> 710
    //   696: getstatic 15	andt:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   699: ldc_w 5953
    //   702: aload_2
    //   703: invokevirtual 5913	org/json/JSONObject:toString	()Ljava/lang/String;
    //   706: invokestatic 1926	atbi:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)Z
    //   709: pop
    //   710: aload_1
    //   711: ldc_w 5955
    //   714: iconst_1
    //   715: iconst_1
    //   716: aconst_null
    //   717: invokevirtual 5959	com/tencent/mobileqq/app/QQAppInterface:notifyObservers	(Ljava/lang/Class;IZLandroid/os/Bundle;)V
    //   720: return
    //   721: astore 7
    //   723: ldc_w 5896
    //   726: iconst_1
    //   727: new 85	java/lang/StringBuilder
    //   730: dup
    //   731: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   734: ldc_w 5961
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
    //   773: getstatic 15	andt:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   776: ldc_w 5935
    //   779: ldc 13
    //   781: invokestatic 1926	atbi:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)Z
    //   784: pop
    //   785: goto -267 -> 518
    //   788: astore_1
    //   789: ldc_w 5896
    //   792: iconst_1
    //   793: new 85	java/lang/StringBuilder
    //   796: dup
    //   797: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   800: ldc_w 5963
    //   803: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   806: aload_1
    //   807: invokevirtual 798	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   810: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   813: invokestatic 642	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   816: return
    //   817: astore_1
    //   818: ldc_w 5896
    //   821: iconst_1
    //   822: ldc_w 5965
    //   825: aload_1
    //   826: invokestatic 188	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   829: return
    //   830: aconst_null
    //   831: astore 7
    //   833: goto -574 -> 259
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	836	0	this	andt
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
    int i = bbkb.af(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
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
          arrayOfByte = augv.a(paramConfig.content.get().toByteArray());
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
        bbkb.m(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, paramConfig);
        bbkb.F(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, j);
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
    //   9: ldc_w 5985
    //   12: iconst_1
    //   13: ldc_w 5987
    //   16: iconst_0
    //   17: anewarray 301	java/lang/Object
    //   20: invokestatic 309	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   23: invokestatic 199	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   26: aload_1
    //   27: invokevirtual 65	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   30: getstatic 15	andt:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   33: invokestatic 1942	aejq:a	(Landroid/content/Context;Ljava/lang/String;)I
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
    //   116: invokestatic 321	augv:a	([B)[B
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
    //   150: ldc_w 5985
    //   153: iconst_1
    //   154: new 85	java/lang/StringBuilder
    //   157: dup
    //   158: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   161: ldc_w 5989
    //   164: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   167: aload_2
    //   168: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   174: invokestatic 199	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   177: aload 9
    //   179: ldc_w 5991
    //   182: invokevirtual 408	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   185: istore_3
    //   186: aload 9
    //   188: ldc_w 5993
    //   191: invokevirtual 408	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   194: istore 4
    //   196: aload 9
    //   198: ldc_w 5995
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
    //   247: invokevirtual 5996	org/json/JSONArray:get	(I)Ljava/lang/Object;
    //   250: checkcast 128	org/json/JSONObject
    //   253: ldc_w 5998
    //   256: invokevirtual 420	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   259: astore 7
    //   261: aload 7
    //   263: invokestatic 126	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   266: ifne +12 -> 278
    //   269: aload_2
    //   270: aload 7
    //   272: invokeinterface 2852 2 0
    //   277: pop
    //   278: iload 5
    //   280: iconst_1
    //   281: iadd
    //   282: istore 5
    //   284: goto -51 -> 233
    //   287: astore_2
    //   288: ldc_w 5985
    //   291: iconst_1
    //   292: new 85	java/lang/StringBuilder
    //   295: dup
    //   296: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   299: ldc_w 6000
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
    //   341: invokestatic 6003	aejq:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)Laejq;
    //   344: aload_1
    //   345: iload 5
    //   347: iload_3
    //   348: aload_2
    //   349: invokevirtual 6006	aejq:a	(Lcom/tencent/mobileqq/app/QQAppInterface;IILjava/util/Set;)V
    //   352: aload_1
    //   353: invokevirtual 65	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   356: getstatic 15	andt:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   359: iload 6
    //   361: invokestatic 6007	aejq:a	(Landroid/content/Context;Ljava/lang/String;I)V
    //   364: return
    //   365: astore_2
    //   366: iconst_0
    //   367: istore 4
    //   369: iconst_0
    //   370: istore_3
    //   371: ldc_w 5985
    //   374: iconst_1
    //   375: new 85	java/lang/StringBuilder
    //   378: dup
    //   379: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   382: ldc_w 5888
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
    //   408: ldc_w 5985
    //   411: iconst_1
    //   412: ldc_w 6009
    //   415: invokestatic 199	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   418: goto -66 -> 352
    //   421: ldc_w 5985
    //   424: iconst_1
    //   425: ldc_w 6011
    //   428: invokestatic 199	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   431: aload_1
    //   432: invokestatic 6003	aejq:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)Laejq;
    //   435: aload_1
    //   436: iconst_0
    //   437: iconst_0
    //   438: aconst_null
    //   439: invokevirtual 6006	aejq:a	(Lcom/tencent/mobileqq/app/QQAppInterface;IILjava/util/Set;)V
    //   442: goto -90 -> 352
    //   445: ldc_w 5985
    //   448: iconst_1
    //   449: ldc_w 6013
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
    //   0	519	0	this	andt
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
    int i = bbkb.aj(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
    int j = paramConfig.version.get();
    if (i != j) {
      if ((paramConfig.msg_content_list != null) && (paramConfig.msg_content_list.size() > 0))
      {
        paramConfig = (ConfigurationService.Content)paramConfig.msg_content_list.get(0);
        if ((paramConfig != null) && (paramConfig.content.has())) {
          if (paramConfig.compress.get() == 1)
          {
            paramConfig = augv.a(paramConfig.content.get().toByteArray());
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
        bbkb.H(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, j);
        ((aseg)paramQQAppInterface.getManager(221)).a(paramConfig);
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
      bool = bbfr.a(paramQQAppInterface.getApp(), "com.tencent.tim");
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
      ((asfc)paramQQAppInterface.getManager(244)).a();
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
 * Qualified Name:     andt
 * JD-Core Version:    0.7.0.1
 */