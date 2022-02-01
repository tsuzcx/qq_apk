package com.tencent.biz.webviewplugin;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Window;
import com.tencent.biz.pubaccount.accountdetail.api.IPublicAccountDetailActivity;
import com.tencent.biz.pubaccount.api.IPublicAccountProxy;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.FriendProfileMoreInfoActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.pendant.AvatarPendantActivity;
import com.tencent.mobileqq.activity.photo.PhotoCropForPortraitActivity;
import com.tencent.mobileqq.addfriend.api.IAddFriendApi;
import com.tencent.mobileqq.apollo.statistics.product.api.IApolloDtReportHelper;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.face.util.FaceUtil;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView;
import com.tencent.mobileqq.config.business.avatar.DynamicAvatarConfBean;
import com.tencent.mobileqq.config.business.avatar.DynamicAvatarConfBean.DynamicAvatarConfig;
import com.tencent.mobileqq.config.business.avatar.DynamicAvatarConfProcessor;
import com.tencent.mobileqq.config.business.avatar.DynamicAvatarConfProcessor.Companion;
import com.tencent.mobileqq.emosm.DataFactory;
import com.tencent.mobileqq.emosm.OnRemoteRespObserver;
import com.tencent.mobileqq.emosm.api.IWebIPCOperatorApi;
import com.tencent.mobileqq.nearby.api.INearbySPUtil;
import com.tencent.mobileqq.nearby.profilecard.NearbyProfileCardConstants;
import com.tencent.mobileqq.profilecard.api.IProfileCardApi;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.utils.TroopInfoUIUtil;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.webview.swift.WebViewPluginContainer;
import com.tencent.mobileqq.widget.DispatchActionMoveScrollView;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import common.config.service.QzoneConfig;
import eipc.EIPCClient;
import eipc.EIPCResult;
import java.util.ArrayList;
import java.util.Arrays;
import org.json.JSONArray;
import org.json.JSONObject;

public class NewerGuidePlugin
  extends WebViewPlugin
{
  private Uri a;
  private QQProgressDialog b;
  private int c;
  private int d;
  private int e;
  private int f;
  private OnRemoteRespObserver g = new NewerGuidePlugin.1(this);
  private boolean h;
  private BroadcastReceiver i = new NewerGuidePlugin.2(this);
  
  public NewerGuidePlugin()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("NewerGuidePlugin this=");
      localStringBuilder.append(this);
      QLog.d("NewerGuidePlugin", 2, localStringBuilder.toString());
    }
    this.mPluginNameSpace = "newerguide";
  }
  
  public static String a()
  {
    return QzoneConfig.getInstance().getConfig("CMShow", "CMShowNewerGuideEntranceName", "创建专属形象");
  }
  
  public static JSONObject a(String paramString)
  {
    paramString = ((INearbySPUtil)QRoute.api(INearbySPUtil.class)).getSharedPreferences("upload_for_new_guide", paramString, 4).getString("upload_for_new_guide", "");
    try
    {
      paramString = new JSONObject(paramString);
      return paramString;
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3)
  {
    int m;
    int k;
    int j;
    if ((paramInt1 >= 1897) && (paramInt2 >= 1) && (paramInt2 <= 12) && (paramInt3 >= 1))
    {
      m = paramInt1;
      k = paramInt2;
      j = paramInt3;
      if (paramInt3 <= 31) {}
    }
    else
    {
      QLog.d("NewerGuidePlugin", 1, String.format("showDatePicker invalid params year=%s month=%s day=%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) }));
      m = 1900;
      k = 1;
      j = 1;
    }
    Object localObject1 = this.mRuntime.d();
    IphonePickerView localIphonePickerView = (IphonePickerView)((Activity)localObject1).getLayoutInflater().inflate(2131627482, null);
    localIphonePickerView.a(new NewerGuidePlugin.DatePickerAdapter(this, -1));
    localObject1 = ActionSheet.createMenuSheet((Context)localObject1);
    ((ActionSheet)localObject1).setCloseAutoRead(true);
    ((ActionSheet)localObject1).setActionContentView(localIphonePickerView, null);
    Object localObject2 = (DispatchActionMoveScrollView)((ActionSheet)localObject1).findViewById(2131427560);
    ((DispatchActionMoveScrollView)localObject2).a = true;
    ((DispatchActionMoveScrollView)localObject2).setBackgroundResource(17170445);
    if (Build.VERSION.SDK_INT >= 11)
    {
      localObject2 = ((ActionSheet)localObject1).getWindow();
      if (localObject2 != null) {
        ((Window)localObject2).setFlags(16777216, 16777216);
      }
    }
    localIphonePickerView.setPickListener(new NewerGuidePlugin.7(this, localIphonePickerView, (ActionSheet)localObject1));
    this.d = (m - 1897);
    this.e = (k - 1);
    this.f = (j - 1);
    localIphonePickerView.setSelection(0, this.d);
    localIphonePickerView.setSelection(1, this.e);
    localIphonePickerView.setSelection(2, this.f);
    try
    {
      ((ActionSheet)localObject1).show();
      return;
    }
    catch (Exception localException) {}
  }
  
  private void a(JSONObject paramJSONObject)
  {
    int j = Integer.parseInt(paramJSONObject.getString("type"));
    try
    {
      localObject = paramJSONObject.getString("uin");
    }
    catch (Exception localException)
    {
      Object localObject;
      label22:
      long l;
      int k;
      break label22;
    }
    localObject = null;
    if (QLog.isColorLevel()) {
      QLog.d("NewerGuidePlugin", 2, String.format("handleJumpCard type=%s uin=%s", new Object[] { Integer.valueOf(j), localObject }));
    }
    if ((j != 5) && (TextUtils.isEmpty((CharSequence)localObject))) {
      return;
    }
    if (j != 1)
    {
      if (j != 2)
      {
        if (j != 3)
        {
          if (j != 4)
          {
            if (j != 5) {
              return;
            }
            paramJSONObject = new AllInOne(this.mRuntime.b().getCurrentAccountUin(), 0);
            paramJSONObject.nickname = this.mRuntime.b().getCurrentNickname();
            paramJSONObject.profileEntryType = 100;
            paramJSONObject = ((IProfileCardApi)QRoute.api(IProfileCardApi.class)).getProfileCardIntentOnly(this.mRuntime.d(), paramJSONObject);
            paramJSONObject.putExtra("from_newer_guide", true);
            this.mRuntime.d().startActivity(paramJSONObject);
            return;
          }
          l = Long.parseLong((String)localObject);
          paramJSONObject = new AllInOne("0", 41);
          paramJSONObject.profileEntryType = 100;
          localObject = new Intent(this.mRuntime.d(), NearbyProfileCardConstants.class);
          ((Intent)localObject).putExtra("param_mode", 3);
          ((Intent)localObject).putExtra("AllInOne", paramJSONObject);
          ((Intent)localObject).putExtra("param_tiny_id", l);
          ((Intent)localObject).putExtra("from_newer_guide", true);
          startActivityForResult((Intent)localObject, (byte)j);
          return;
        }
        localObject = TroopInfoUIUtil.a(String.valueOf(localObject), 35);
        ((Bundle)localObject).putString("authSig", paramJSONObject.optString("authSig"));
        ((Bundle)localObject).putBoolean("from_newer_guide", true);
        TroopUtils.a(this.mRuntime.d(), (Bundle)localObject, 2, 3);
        return;
      }
      paramJSONObject = new Intent(this.mRuntime.d(), ((IPublicAccountProxy)QRoute.api(IPublicAccountProxy.class)).getImplClass(IPublicAccountDetailActivity.class));
      paramJSONObject.putExtra("uin", (String)localObject);
      paramJSONObject.putExtra("from_newer_guide", true);
      this.mRuntime.d().overridePendingTransition(2130772009, 2130772010);
      startActivityForResult(paramJSONObject, (byte)j);
      return;
    }
    paramJSONObject = QIPCClientHelper.getInstance().getClient().callServer("CommonModule", "getPhoneBindState", null);
    if (paramJSONObject.isSuccess())
    {
      k = paramJSONObject.data.getInt("selfBindState");
      j = 34;
      if (k <= 5) {
        j = 29;
      }
      paramJSONObject = new AllInOne((String)localObject, j);
      paramJSONObject.profileEntryType = 100;
      paramJSONObject = ((IProfileCardApi)QRoute.api(IProfileCardApi.class)).getProfileCardIntentOnly(this.mRuntime.d(), paramJSONObject);
      paramJSONObject.putExtra("from_newer_guide", true);
      startActivityForResult(paramJSONObject, (byte)1);
    }
  }
  
  /* Error */
  private void a(boolean paramBoolean, String paramString)
  {
    // Byte code:
    //   0: invokestatic 41	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +30 -> 33
    //   6: ldc 55
    //   8: iconst_2
    //   9: ldc_w 422
    //   12: iconst_2
    //   13: anewarray 135	java/lang/Object
    //   16: dup
    //   17: iconst_0
    //   18: iload_1
    //   19: invokestatic 427	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   22: aastore
    //   23: dup
    //   24: iconst_1
    //   25: aload_2
    //   26: aastore
    //   27: invokestatic 147	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   30: invokestatic 62	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   33: new 122	org/json/JSONObject
    //   36: dup
    //   37: invokespecial 428	org/json/JSONObject:<init>	()V
    //   40: astore 7
    //   42: aconst_null
    //   43: astore 4
    //   45: aconst_null
    //   46: astore 5
    //   48: aconst_null
    //   49: astore 6
    //   51: iload_1
    //   52: ifeq +320 -> 372
    //   55: iconst_1
    //   56: istore_3
    //   57: goto +3 -> 60
    //   60: aload 7
    //   62: ldc_w 430
    //   65: iload_3
    //   66: invokevirtual 434	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   69: pop
    //   70: iload_1
    //   71: ifeq +140 -> 211
    //   74: aload_2
    //   75: invokestatic 271	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   78: ifne +133 -> 211
    //   81: new 436	java/io/File
    //   84: dup
    //   85: aload_2
    //   86: invokespecial 437	java/io/File:<init>	(Ljava/lang/String;)V
    //   89: astore 8
    //   91: aload 8
    //   93: invokevirtual 440	java/io/File:exists	()Z
    //   96: ifeq +115 -> 211
    //   99: aload 8
    //   101: invokevirtual 444	java/io/File:length	()J
    //   104: l2i
    //   105: newarray byte
    //   107: astore 6
    //   109: new 446	java/io/FileInputStream
    //   112: dup
    //   113: aload 8
    //   115: invokespecial 449	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   118: astore_2
    //   119: new 451	java/io/BufferedInputStream
    //   122: dup
    //   123: aload_2
    //   124: invokespecial 454	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   127: astore 4
    //   129: aload 4
    //   131: aload 6
    //   133: invokevirtual 458	java/io/BufferedInputStream:read	([B)I
    //   136: ifle +18 -> 154
    //   139: aload 7
    //   141: ldc_w 460
    //   144: aload 6
    //   146: iconst_0
    //   147: invokestatic 466	com/tencent/mobileqq/utils/Base64Util:encodeToString	([BI)Ljava/lang/String;
    //   150: invokevirtual 469	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   153: pop
    //   154: aload 8
    //   156: invokevirtual 472	java/io/File:delete	()Z
    //   159: pop
    //   160: goto +57 -> 217
    //   163: astore 6
    //   165: aload 4
    //   167: astore 5
    //   169: aload 6
    //   171: astore 4
    //   173: goto +17 -> 190
    //   176: astore 5
    //   178: aload 4
    //   180: astore 6
    //   182: goto +20 -> 202
    //   185: astore 4
    //   187: aconst_null
    //   188: astore 5
    //   190: aload 4
    //   192: astore 6
    //   194: goto +127 -> 321
    //   197: astore 5
    //   199: aconst_null
    //   200: astore 6
    //   202: aload_2
    //   203: astore 4
    //   205: aload 6
    //   207: astore_2
    //   208: goto +54 -> 262
    //   211: aconst_null
    //   212: astore 4
    //   214: aload 6
    //   216: astore_2
    //   217: aload_2
    //   218: ifnull +10 -> 228
    //   221: aload_2
    //   222: invokevirtual 475	java/io/FileInputStream:close	()V
    //   225: goto +3 -> 228
    //   228: aload 4
    //   230: ifnull +63 -> 293
    //   233: aload 4
    //   235: astore_2
    //   236: aload_2
    //   237: invokevirtual 476	java/io/BufferedInputStream:close	()V
    //   240: goto +53 -> 293
    //   243: astore 6
    //   245: aconst_null
    //   246: astore 4
    //   248: aload 5
    //   250: astore_2
    //   251: aload 4
    //   253: astore 5
    //   255: goto +66 -> 321
    //   258: astore 5
    //   260: aconst_null
    //   261: astore_2
    //   262: ldc 55
    //   264: iconst_1
    //   265: ldc_w 478
    //   268: aload 5
    //   270: invokestatic 481	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   273: aload 4
    //   275: ifnull +11 -> 286
    //   278: aload 4
    //   280: invokevirtual 475	java/io/FileInputStream:close	()V
    //   283: goto +3 -> 286
    //   286: aload_2
    //   287: ifnull +6 -> 293
    //   290: goto -54 -> 236
    //   293: aload_0
    //   294: ldc_w 483
    //   297: iconst_1
    //   298: anewarray 143	java/lang/String
    //   301: dup
    //   302: iconst_0
    //   303: aload 7
    //   305: invokevirtual 484	org/json/JSONObject:toString	()Ljava/lang/String;
    //   308: aastore
    //   309: invokevirtual 488	com/tencent/biz/webviewplugin/NewerGuidePlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   312: return
    //   313: astore 6
    //   315: aload_2
    //   316: astore 5
    //   318: aload 4
    //   320: astore_2
    //   321: aload_2
    //   322: ifnull +10 -> 332
    //   325: aload_2
    //   326: invokevirtual 475	java/io/FileInputStream:close	()V
    //   329: goto +3 -> 332
    //   332: aload 5
    //   334: ifnull +8 -> 342
    //   337: aload 5
    //   339: invokevirtual 476	java/io/BufferedInputStream:close	()V
    //   342: goto +6 -> 348
    //   345: aload 6
    //   347: athrow
    //   348: goto -3 -> 345
    //   351: astore_2
    //   352: goto -124 -> 228
    //   355: astore_2
    //   356: goto -63 -> 293
    //   359: astore 4
    //   361: goto -75 -> 286
    //   364: astore_2
    //   365: goto -33 -> 332
    //   368: astore_2
    //   369: goto -27 -> 342
    //   372: iconst_0
    //   373: istore_3
    //   374: goto -314 -> 60
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	377	0	this	NewerGuidePlugin
    //   0	377	1	paramBoolean	boolean
    //   0	377	2	paramString	String
    //   56	318	3	j	int
    //   43	136	4	localObject1	Object
    //   185	6	4	localObject2	Object
    //   203	116	4	str1	String
    //   359	1	4	localException1	Exception
    //   46	122	5	localObject3	Object
    //   176	1	5	localException2	Exception
    //   188	1	5	localObject4	Object
    //   197	52	5	localException3	Exception
    //   253	1	5	str2	String
    //   258	11	5	localException4	Exception
    //   316	22	5	str3	String
    //   49	96	6	arrayOfByte	byte[]
    //   163	7	6	localObject5	Object
    //   180	35	6	localObject6	Object
    //   243	1	6	localObject7	Object
    //   313	33	6	localObject8	Object
    //   40	264	7	localJSONObject	JSONObject
    //   89	66	8	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   129	154	163	finally
    //   154	160	163	finally
    //   129	154	176	java/lang/Exception
    //   154	160	176	java/lang/Exception
    //   119	129	185	finally
    //   119	129	197	java/lang/Exception
    //   60	70	243	finally
    //   74	119	243	finally
    //   60	70	258	java/lang/Exception
    //   74	119	258	java/lang/Exception
    //   262	273	313	finally
    //   221	225	351	java/lang/Exception
    //   236	240	355	java/lang/Exception
    //   278	283	359	java/lang/Exception
    //   325	329	364	java/lang/Exception
    //   337	342	368	java/lang/Exception
  }
  
  private void a(String[] paramArrayOfString, int paramInt)
  {
    if ((paramArrayOfString != null) && (paramArrayOfString.length != 0))
    {
      int j;
      if (paramInt >= 0)
      {
        j = paramInt;
        if (paramInt < paramArrayOfString.length) {}
      }
      else
      {
        j = 0;
      }
      Object localObject = this.mRuntime.d();
      IphonePickerView localIphonePickerView = (IphonePickerView)((Activity)localObject).getLayoutInflater().inflate(2131627482, null);
      localIphonePickerView.a(new NewerGuidePlugin.5(this, paramArrayOfString));
      paramArrayOfString = ActionSheet.createMenuSheet((Context)localObject);
      paramArrayOfString.setCloseAutoRead(true);
      paramArrayOfString.setActionContentView(localIphonePickerView, null);
      localObject = (DispatchActionMoveScrollView)paramArrayOfString.findViewById(2131427560);
      ((DispatchActionMoveScrollView)localObject).a = true;
      ((DispatchActionMoveScrollView)localObject).setBackgroundResource(17170445);
      if (Build.VERSION.SDK_INT >= 11)
      {
        localObject = paramArrayOfString.getWindow();
        if (localObject != null) {
          ((Window)localObject).setFlags(16777216, 16777216);
        }
      }
      localIphonePickerView.setPickListener(new NewerGuidePlugin.6(this, paramArrayOfString));
      this.c = j;
      localIphonePickerView.setSelection(0, j);
    }
    try
    {
      paramArrayOfString.show();
      return;
    }
    catch (Exception paramArrayOfString) {}
    QLog.d("NewerGuidePlugin", 1, "showSelector invalid params");
    return;
  }
  
  private void b(JSONObject paramJSONObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewerGuidePlugin", 2, "handleUploadContacts");
    }
    Activity localActivity = this.mRuntime.d();
    if ((localActivity != null) && ((localActivity instanceof QBaseActivity)))
    {
      QBaseActivity localQBaseActivity = (QBaseActivity)localActivity;
      if (localQBaseActivity.checkSelfPermission("android.permission.READ_CONTACTS") == 0)
      {
        c(paramJSONObject);
        return;
      }
      localQBaseActivity.requestPermissions(new NewerGuidePlugin.8(this, paramJSONObject, localActivity), 1, new String[] { "android.permission.READ_CONTACTS" });
    }
  }
  
  public static boolean b()
  {
    return QzoneConfig.getInstance().getConfig("CMShow", "CMShowNewerGuideEntranceShow", 1) > 0;
  }
  
  public static String c()
  {
    return QzoneConfig.getInstance().getConfig("CMShow", "CMShowNewerGuideEntranceLink", "https://open.cmshow.qq.com/next/registerProcess.html?_wv=16777223&_wwv=8704");
  }
  
  private void c(JSONObject paramJSONObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewerGuidePlugin", 2, String.format("uploadContacts args=%s", new Object[] { paramJSONObject }));
    }
    paramJSONObject = new Bundle();
    paramJSONObject.putString("key_action", "uploadContacts");
    paramJSONObject = DataFactory.a("ipc_newer_guide", null, this.g.key, paramJSONObject);
    ((IWebIPCOperatorApi)QRoute.api(IWebIPCOperatorApi.class)).sendServiceIpcReq(paramJSONObject);
  }
  
  private void d()
  {
    if (!this.h)
    {
      if (QLog.isColorLevel()) {
        QLog.d("NewerGuidePlugin", 2, "registerAvatarReceiver");
      }
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("ACTION_NEWER_GUIDE_SELECT_AVATAR_RESULT");
      localIntentFilter.addAction("ACTION_NEWER_GUIDE_CMSHOW_AVATAR_RESULT");
      this.mRuntime.d().registerReceiver(this.i, localIntentFilter);
      this.h = true;
    }
  }
  
  private void d(JSONObject paramJSONObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewerGuidePlugin", 2, "handleGetRecommended");
    }
    Activity localActivity = this.mRuntime.d();
    if ((localActivity != null) && ((localActivity instanceof QBaseActivity)))
    {
      int j;
      if (Build.VERSION.SDK_INT >= 23) {
        j = ((QBaseActivity)localActivity).checkSelfPermission("android.permission.READ_CONTACTS");
      } else {
        j = 0;
      }
      if (j == 0)
      {
        e(paramJSONObject);
        return;
      }
      ((QBaseActivity)localActivity).requestPermissions(new NewerGuidePlugin.9(this, paramJSONObject, localActivity), 1, new String[] { "android.permission.READ_CONTACTS" });
    }
  }
  
  private void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewerGuidePlugin", 2, "unregisterAvatarReceiver");
    }
    this.mRuntime.d().unregisterReceiver(this.i);
    this.h = false;
  }
  
  private void e(JSONObject paramJSONObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewerGuidePlugin", 2, String.format("getRecommended args=%s", new Object[] { paramJSONObject }));
    }
    int j = Integer.parseInt(paramJSONObject.getString("wantCount"));
    paramJSONObject = new Bundle();
    paramJSONObject.putString("key_action", "getRecommendedList");
    paramJSONObject.putInt("wantCount", j);
    paramJSONObject = DataFactory.a("ipc_newer_guide", null, this.g.key, paramJSONObject);
    ((IWebIPCOperatorApi)QRoute.api(IWebIPCOperatorApi.class)).sendServiceIpcReq(paramJSONObject);
  }
  
  private void f()
  {
    QBaseActivity localQBaseActivity = (QBaseActivity)this.mRuntime.d();
    if (localQBaseActivity != null)
    {
      if (Build.VERSION.SDK_INT >= 23)
      {
        int j = localQBaseActivity.checkSelfPermission("android.permission.CAMERA");
        if (QLog.isColorLevel()) {
          QLog.d("NewerGuidePlugin", 2, String.format("handleSetAvatar permission=%s", new Object[] { Integer.valueOf(j) }));
        }
        if (j == 0)
        {
          g();
          return;
        }
        localQBaseActivity.requestPermissions(new NewerGuidePlugin.3(this, localQBaseActivity), 1, new String[] { "android.permission.CAMERA" });
        return;
      }
      g();
    }
  }
  
  private void f(JSONObject paramJSONObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewerGuidePlugin", 2, String.format("getRecommendedNew args=%s", new Object[] { paramJSONObject }));
    }
    long l = Long.parseLong(paramJSONObject.getString("uin"));
    int j = Integer.parseInt(paramJSONObject.getString("startIndex"));
    int k = Integer.parseInt(paramJSONObject.getString("num"));
    paramJSONObject = paramJSONObject.getString("callback");
    Bundle localBundle = new Bundle();
    localBundle.putString("key_action", "getRecommendedListNew");
    localBundle.putLong("uin", l);
    localBundle.putInt("startIndex", j);
    localBundle.putInt("num", k);
    localBundle.putString("callback", paramJSONObject);
    paramJSONObject = DataFactory.a("ipc_newer_guide", null, this.g.key, localBundle);
    ((IWebIPCOperatorApi)QRoute.api(IWebIPCOperatorApi.class)).sendServiceIpcReq(paramJSONObject);
  }
  
  private void g()
  {
    Activity localActivity = this.mRuntime.d();
    String[] arrayOfString = localActivity.getResources().getStringArray(2130968636);
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.b(localActivity, null);
    ArrayList localArrayList = new ArrayList();
    DynamicAvatarConfBean.DynamicAvatarConfig localDynamicAvatarConfig = DynamicAvatarConfProcessor.a.a().a();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("showSetAvatar config.isSupportDynamicAvatar(): ");
      localStringBuilder.append(localDynamicAvatarConfig.a());
      QLog.d("NewerGuidePlugin", 2, localStringBuilder.toString());
    }
    if (b())
    {
      localActionSheet.addButton(a());
      localArrayList.add(Integer.valueOf(33));
      ((IApolloDtReportHelper)QRoute.api(IApolloDtReportHelper.class)).report("set_profile", "photo_settings", "expo", null);
    }
    if (localDynamicAvatarConfig.a())
    {
      localActionSheet.addButton(arrayOfString[22]);
      localArrayList.add(Integer.valueOf(22));
    }
    localActionSheet.addButton(arrayOfString[24]);
    localArrayList.add(Integer.valueOf(24));
    localActionSheet.addButton(arrayOfString[13]);
    localArrayList.add(Integer.valueOf(13));
    localActionSheet.addCancelButton(arrayOfString[16]);
    localActionSheet.setOnButtonClickListener(new NewerGuidePlugin.4(this, localArrayList, localActionSheet, localActivity));
    if (!localActivity.isFinishing()) {}
    try
    {
      localActionSheet.show();
      return;
    }
    catch (Exception localException) {}
  }
  
  public void callJs(String paramString, String... paramVarArgs)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewerGuidePlugin", 2, String.format("callJs func=%s", new Object[] { paramString }));
    }
    super.callJs(paramString, paramVarArgs);
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    boolean bool2 = QLog.isColorLevel();
    boolean bool1 = true;
    int j = 0;
    if (bool2) {
      QLog.d("NewerGuidePlugin", 2, String.format("handleJsRequest pkgName=%s method=%s url=%s args=%s", new Object[] { paramString2, paramString3, paramString1, Arrays.toString(paramVarArgs) }));
    }
    if (("newerguide".equals(paramString2)) && (!TextUtils.isEmpty(paramString3)) && (!TextUtils.isEmpty(paramString1))) {}
    for (;;)
    {
      try
      {
        paramJsBridgeListener = new JSONObject(paramVarArgs[0]);
        if (paramString3.equals("uploadContacts"))
        {
          b(paramJsBridgeListener);
          return true;
        }
        if (paramString3.equals("getRecommendedList"))
        {
          d(paramJsBridgeListener);
          return true;
        }
        if (paramString3.equals("getRecommendedListNew"))
        {
          f(paramJsBridgeListener);
          return true;
        }
        if (paramString3.equals("skipGuide"))
        {
          paramJsBridgeListener = new Intent(this.mRuntime.d(), SplashActivity.class);
          paramJsBridgeListener.putExtra("main_tab_id", 1);
          paramJsBridgeListener.setFlags(603979776);
          this.mRuntime.d().startActivity(paramJsBridgeListener);
          return true;
        }
        bool2 = paramString3.equals("addFriend");
        paramString1 = null;
        if (bool2)
        {
          paramString1 = QIPCClientHelper.getInstance().getClient().callServer("CommonModule", "getPhoneBindState", null);
          if (!paramString1.isSuccess()) {
            break label1491;
          }
          if (paramString1.data.getInt("selfBindState") > 5) {
            break label1494;
          }
          j = 3075;
          k = 3;
          paramString1 = paramJsBridgeListener.getString("uin");
          paramJsBridgeListener = paramJsBridgeListener.getString("name");
          m = 7;
          paramString2 = this.mRuntime.a(this.mRuntime.d());
          if ((paramString2 instanceof WebViewPluginContainer)) {
            m = ((WebViewPluginContainer)paramString2).switchRequestCode(this, (byte)7);
          }
          paramJsBridgeListener = ((IAddFriendApi)QRoute.api(IAddFriendApi.class)).startAddFriend(this.mRuntime.d(), 2, paramString1, null, j, k, paramJsBridgeListener, null, null, null, null);
          paramJsBridgeListener.putExtra("from_newer_guide", true);
          ((IAddFriendApi)QRoute.api(IAddFriendApi.class)).launchAddFriendForResult(this.mRuntime.d(), paramJsBridgeListener, m);
          return true;
        }
        bool2 = paramString3.equals("followPublicAccount");
        if (bool2)
        {
          paramJsBridgeListener = paramJsBridgeListener.getString("uin");
          paramString1 = new Bundle();
          paramString1.putString("key_action", "followPublicAccount");
          paramString1.putString("uin", paramJsBridgeListener);
          paramJsBridgeListener = DataFactory.a("ipc_newer_guide", null, this.g.key, paramString1);
          ((IWebIPCOperatorApi)QRoute.api(IWebIPCOperatorApi.class)).sendServiceIpcReq(paramJsBridgeListener);
          return true;
        }
        bool2 = paramString3.equals("joinTroop");
        if (bool2)
        {
          paramString1 = paramJsBridgeListener.getString("uin");
          paramString2 = paramJsBridgeListener.getString("name");
          paramJsBridgeListener = paramJsBridgeListener.optString("authSig");
          paramString3 = new Bundle();
          paramString3.putString("key_action", "joinTroop");
          paramString3.putString("uin", paramString1);
          paramString3.putString("name", paramString2);
          paramString3.putString("authSig", paramJsBridgeListener);
          paramJsBridgeListener = DataFactory.a("ipc_newer_guide", null, this.g.key, paramString3);
          ((IWebIPCOperatorApi)QRoute.api(IWebIPCOperatorApi.class)).sendServiceIpcReq(paramJsBridgeListener);
          return true;
        }
        if (paramString3.equals("joinTroopByTap"))
        {
          paramString1 = paramJsBridgeListener.getString("uin");
          paramString2 = paramJsBridgeListener.getString("name");
          paramJsBridgeListener = paramJsBridgeListener.optString("authSig");
          paramString3 = new Bundle();
          paramString3.putString("key_action", "joinTroopByTap");
          paramString3.putString("uin", paramString1);
          paramString3.putString("name", paramString2);
          paramString3.putString("authSig", paramJsBridgeListener);
          paramJsBridgeListener = DataFactory.a("ipc_newer_guide", null, this.g.key, paramString3);
          ((IWebIPCOperatorApi)QRoute.api(IWebIPCOperatorApi.class)).sendServiceIpcReq(paramJsBridgeListener);
          return true;
        }
        if (paramString3.equals("sayHi"))
        {
          long l = Long.parseLong(paramJsBridgeListener.getString("uin"));
          paramJsBridgeListener = new Bundle();
          paramJsBridgeListener.putString("key_action", "sayHi");
          paramJsBridgeListener.putLong("tinyId", l);
          paramJsBridgeListener = DataFactory.a("ipc_newer_guide", null, this.g.key, paramJsBridgeListener);
          ((IWebIPCOperatorApi)QRoute.api(IWebIPCOperatorApi.class)).sendServiceIpcReq(paramJsBridgeListener);
          return true;
        }
        if (paramString3.equals("jumpCard"))
        {
          a(paramJsBridgeListener);
          return true;
        }
        if (paramString3.equals("setAvatar"))
        {
          f();
          return true;
        }
        if (paramString3.equals("selector"))
        {
          k = paramJsBridgeListener.getInt("index");
          paramString2 = paramJsBridgeListener.getJSONArray("options");
          paramJsBridgeListener = paramString1;
          if (paramString2 != null)
          {
            paramJsBridgeListener = paramString1;
            if (paramString2.length() > 0)
            {
              m = paramString2.length();
              paramString1 = new String[m];
              paramJsBridgeListener = paramString1;
              if (j < m)
              {
                paramString1[j] = paramString2.getString(j);
                j += 1;
                continue;
              }
            }
          }
          a(paramJsBridgeListener, k);
          return true;
        }
        if (paramString3.equals("datePicker"))
        {
          a(paramJsBridgeListener.getInt("year"), paramJsBridgeListener.getInt("month"), paramJsBridgeListener.getInt("date"));
          return true;
        }
        if (paramString3.equals("queryUploadProgress"))
        {
          paramJsBridgeListener = paramJsBridgeListener.getString("callback");
          paramString1 = a(this.mRuntime.b().getAccount());
          if (paramString1 == null) {
            break label1506;
          }
          k = paramString1.optInt("state");
          m = paramString1.optInt("total");
          n = paramString1.optInt("curPer");
          j = paramString1.optInt("expPer");
          if (QLog.isColorLevel()) {
            QLog.i("NewerGuidePlugin", 2, String.format("METHOD_QUERY_UPLOAD_PROGRESS [%s, %s, %s, %s]", new Object[] { Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(j) }));
          }
          double d1 = n / 100.0F;
          double d2 = m;
          Double.isNaN(d2);
          Double.isNaN(d1);
          j = (int)(d2 * d1);
          paramString1 = new JSONObject();
          paramString1.put("state", k);
          paramString1.put("total", m);
          paramString1.put("progress", d1);
          paramString1.put("upload_count", j);
          callJs(paramJsBridgeListener, new String[] { paramString1.toString() });
          return true;
        }
        if (paramString3.equals("profileAvatar"))
        {
          paramJsBridgeListener = new Intent(this.mRuntime.d(), AvatarPendantActivity.class);
          paramJsBridgeListener.putExtra("AllInOne", new AllInOne(this.mRuntime.b().getCurrentAccountUin(), 0));
          paramJsBridgeListener.putExtra("showActionSheet", true);
          this.mRuntime.d().startActivity(paramJsBridgeListener);
          return true;
        }
        bool2 = paramString3.equals("profileSex");
        if (bool2)
        {
          paramJsBridgeListener = new Intent(this.mRuntime.d(), FriendProfileMoreInfoActivity.class);
          paramJsBridgeListener.putExtra("profile_jump_to_edit", 1);
          this.mRuntime.d().startActivity(paramJsBridgeListener);
          return true;
        }
        if (paramString3.equals("profileBirthday"))
        {
          paramJsBridgeListener = new Intent(this.mRuntime.d(), FriendProfileMoreInfoActivity.class);
          paramJsBridgeListener.putExtra("profile_jump_to_edit", 2);
          this.mRuntime.d().startActivity(paramJsBridgeListener);
          return true;
        }
        if (paramString3.equals("profileLocation"))
        {
          paramJsBridgeListener = new Intent(this.mRuntime.d(), FriendProfileMoreInfoActivity.class);
          paramJsBridgeListener.putExtra("profile_jump_to_edit", 3);
          this.mRuntime.d().startActivity(paramJsBridgeListener);
          return true;
        }
        if (!paramString3.equals("profileSchool")) {
          break label1491;
        }
        paramJsBridgeListener = new Intent(this.mRuntime.d(), FriendProfileMoreInfoActivity.class);
        paramJsBridgeListener.putExtra("profile_jump_to_edit", 4);
        this.mRuntime.d().startActivity(paramJsBridgeListener);
        return true;
      }
      catch (Exception paramJsBridgeListener)
      {
        QLog.e("NewerGuidePlugin", 1, "handleJsRequest fail", paramJsBridgeListener);
        return true;
      }
      bool1 = false;
      label1491:
      return bool1;
      label1494:
      j = 3006;
      int k = 11;
      continue;
      label1506:
      j = 0;
      k = 0;
      int m = 0;
      int n = 0;
    }
  }
  
  public void onActivityResult(Intent paramIntent, byte paramByte, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewerGuidePlugin", 2, String.format("onActivityResult requestCode=%s resultCode=%s intent=%s", new Object[] { Byte.valueOf(paramByte), Integer.valueOf(paramInt), paramIntent }));
    }
    if ((paramByte != 100) || ((paramInt == -1) && (paramIntent != null)))
    {
      try
      {
        a(true, paramIntent.getStringExtra("key_photo_file_path"));
        return;
      }
      catch (Exception paramIntent)
      {
        String str;
        Intent localIntent;
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onActivityResult fail, requestCode=");
        ((StringBuilder)localObject).append(paramByte);
        QLog.e("NewerGuidePlugin", 1, ((StringBuilder)localObject).toString(), paramIntent);
      }
      if (paramByte == 101)
      {
        if (paramInt == -1)
        {
          paramIntent = this.mRuntime.d();
          localObject = ImageUtil.b(paramIntent, this.a);
          str = FaceUtil.a();
          paramInt = ProfileCardUtil.b(paramIntent);
          localIntent = new Intent();
          localIntent.setClass(paramIntent, PhotoCropForPortraitActivity.class);
          localIntent.putExtra("PhotoConst.DEST_BROADCAST_ACTION_NAME", "ACTION_NEWER_GUIDE_SELECT_AVATAR_RESULT");
          localIntent.putExtra("Business_Origin", 100);
          localIntent.putExtra("BUSINESS_ORIGIN_NEW", 100);
          localIntent.putExtra("PhotoConst.SOURCE_FROM", "FROM_TAKE_PHOTO");
          localIntent.putExtra("PhotoConst.EDIT_MASK_SHAPE_TYPE", 0);
          localIntent.putExtra("PhotoConst.SINGLE_PHOTO_PATH", (String)localObject);
          localIntent.putExtra("PhotoConst.TARGET_PATH", str);
          localIntent.putExtra("PhotoConst.CLIP_WIDTH", paramInt);
          localIntent.putExtra("PhotoConst.CLIP_HEIGHT", paramInt);
          localIntent.putExtra("PhotoConst.TARGET_WIDTH", 1080);
          localIntent.putExtra("PhotoConst.TARGET_HEIGHT", 1080);
          paramIntent.startActivity(localIntent);
        }
      }
      else if ((paramInt == -1) && (paramIntent != null))
      {
        localObject = new JSONObject();
        if (!paramIntent.getBooleanExtra("has_operation", false)) {
          break label458;
        }
        paramInt = 1;
        paramIntent = paramIntent.getStringExtra("uin");
        ((JSONObject)localObject).put("result", paramInt);
        ((JSONObject)localObject).put("uin", paramIntent);
        paramIntent = null;
        switch (paramByte)
        {
        case 1: 
        case 2: 
        case 3: 
        case 4: 
        case 5: 
          paramIntent = "respCard";
          ((JSONObject)localObject).put("type", paramByte);
        }
      }
    }
    for (;;)
    {
      if (paramIntent != null)
      {
        callJs(paramIntent, new String[] { ((JSONObject)localObject).toString() });
        return;
        if (QLog.isColorLevel())
        {
          QLog.d("NewerGuidePlugin", 1, "onActivityResult no result");
          return;
        }
      }
      return;
      label458:
      paramInt = 0;
      break;
      continue;
      paramIntent = "respSayHi";
      continue;
      paramIntent = "respFriend";
      continue;
      paramIntent = "respTroop";
    }
  }
  
  protected void onCreate()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onCreate this=");
      localStringBuilder.append(this);
      QLog.d("NewerGuidePlugin", 2, localStringBuilder.toString());
    }
    ((IWebIPCOperatorApi)QRoute.api(IWebIPCOperatorApi.class)).registerObserver(this.g);
    d();
  }
  
  protected void onDestroy()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onDestroy this=");
      localStringBuilder.append(this);
      QLog.d("NewerGuidePlugin", 2, localStringBuilder.toString());
    }
    super.onDestroy();
    ((IWebIPCOperatorApi)QRoute.api(IWebIPCOperatorApi.class)).unRegisterObserver(this.g);
    e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.NewerGuidePlugin
 * JD-Core Version:    0.7.0.1
 */