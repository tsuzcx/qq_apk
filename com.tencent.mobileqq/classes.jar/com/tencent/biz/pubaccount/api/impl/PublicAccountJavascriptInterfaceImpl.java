package com.tencent.biz.pubaccount.api.impl;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.BitmapFactory;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.widget.ProgressBar;
import com.tencent.biz.common.util.Util;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.pubaccount.api.IPublicAccountJavascriptInterface;
import com.tencent.biz.pubaccount.api.IPublicAccountJavascriptInterface.ActionItem;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.biz.webviewbase.AbsBaseWebViewActivity;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BrowserAppInterface;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.PublicAccountDataManager;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.CouponH5Data;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.vaswebviewplugin.EmojiHomeUiPlugin;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.mobileqq.webview.swift.JsWebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebUiBaseInterface;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserScreenShotHandler;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserShareMenuHandler;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserUIStyleHandler;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.WebFeaturesInterface;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.WebProgressInterface;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.WebUiMethodInterface;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.WebviewReportSpeedInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import com.tencent.util.ThreeDes;
import cooperation.plugin.PluginBaseActivity;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppActivity;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class PublicAccountJavascriptInterfaceImpl
  extends JsWebViewPlugin
  implements IPublicAccountJavascriptInterface
{
  public static final int ANIM_STYLE_SHOW_UP_CLOSE_DOWN = 1001;
  public static final int ERROR_DATA_NOT_EXIST = -11;
  public static final int ERROR_EMPTY_DATA = -8;
  public static final int ERROR_EMPTY_KEY = -7;
  public static final int ERROR_EMPTY_PARAMS = -3;
  public static final int ERROR_EMPTY_PATH = -6;
  public static final int ERROR_EMPTY_URL = -4;
  public static final int ERROR_NO_PERMISSION_TO_DOMAIN = -5;
  public static final int ERROR_NO_SPACE_OR_NO_SDCARD = -9;
  public static final int ERROR_TOO_MANY_DATA = -12;
  public static final int ERROR_WRONG_IMAGE_DATA = -10;
  public static final int ERROR_WRONG_JSON = -2;
  protected static final String LBSDES_KEY = "nbyvie";
  protected static final String LBS_CALLER = "webview";
  private static final String METHOD_SET_NAVIGATION_BAR_STYLE = "setNavigationBarStyle";
  public static final String PUBACCOUNT_DATA_PATH = VFSAssistantUtils.getSDKPrivatePath(AppConstants.SDCARD_PATH + "pubaccount/");
  protected static final String SOSO_JSONEN_CRYPT_PUBKEY = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCrkUA+dDEQT52svdheRw04+xrExuTvNj3g7pjcyUkH3+86FiYNhHtyWJc11BywUZ2Ey3RomCyTb/szl5qQEJqR7UC5z4mhLrhgXlbRI0BgmI/LhaMRsfskGM7ziyQ2ZpS0qbHX2xoum6ou/541/VePIwmcnIk6eWUx6GYnA4euZQIDAQAB";
  protected static final String TAG = "PAjs";
  protected static final String TAG_LOCATION = "PAjs.location";
  private static long sH5DataUsage = 0L;
  protected static HashMap<String, String> storage = new HashMap();
  protected Activity context;
  boolean hasAsked = false;
  boolean isRegisteredBroadCast = false;
  private BroadcastReceiver mBroadcastReceiver = new PublicAccountJavascriptInterfaceImpl.2(this);
  QQCustomDialog mDialog;
  private WebUiUtils.WebviewReportSpeedInterface reportSpeedInterface = null;
  protected List<PublicAccountJavascriptInterfaceImpl.HttpTask> taskList;
  private WebUiUtils.WebUiMethodInterface uiMethodInterface = null;
  
  private String decrypt(String paramString1, String paramString2)
  {
    return ThreeDes.b(paramString1, paramString2);
  }
  
  private void deleteHash(String paramString)
  {
    Object localObject = this.mRuntime.a();
    if (localObject == null) {
      return;
    }
    localObject = ((AppInterface)localObject).getEntityManagerFactory(((AppInterface)localObject).getAccount()).createEntityManager();
    paramString = ((EntityManager)localObject).query(CouponH5Data.class, false, "mHost = ?", new String[] { paramString }, null, null, null, null);
    if (paramString != null)
    {
      paramString = paramString.iterator();
      while (paramString.hasNext()) {
        ((EntityManager)localObject).remove((CouponH5Data)paramString.next());
      }
    }
    ((EntityManager)localObject).close();
  }
  
  private void deleteHash(String paramString1, String paramString2)
  {
    Object localObject = this.mRuntime.a();
    if (localObject == null) {
      return;
    }
    localObject = ((AppInterface)localObject).getEntityManagerFactory(((AppInterface)localObject).getAccount()).createEntityManager();
    paramString1 = ((EntityManager)localObject).query(CouponH5Data.class, false, "mHost = ? AND mPath = ?", new String[] { paramString1, paramString2 }, null, null, null, null);
    if (paramString1 != null)
    {
      paramString1 = paramString1.iterator();
      while (paramString1.hasNext()) {
        ((EntityManager)localObject).remove((CouponH5Data)paramString1.next());
      }
    }
    ((EntityManager)localObject).close();
  }
  
  private void deleteHash(String paramString1, String paramString2, String paramString3)
  {
    Object localObject = this.mRuntime.a();
    if (localObject == null) {
      return;
    }
    localObject = ((AppInterface)localObject).getEntityManagerFactory(((AppInterface)localObject).getAccount()).createEntityManager();
    paramString1 = (CouponH5Data)((EntityManager)localObject).find(CouponH5Data.class, "mHost = ? AND mPath = ? AND mKey = ?", new String[] { paramString1, paramString2, paramString3 });
    if (paramString1 != null) {
      ((EntityManager)localObject).remove(paramString1);
    }
    ((EntityManager)localObject).close();
  }
  
  private String encrypt(String paramString1, String paramString2)
  {
    return ThreeDes.a(paramString1, paramString2);
  }
  
  /* Error */
  private String formatLocData(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: new 256	org/json/JSONObject
    //   3: dup
    //   4: invokespecial 257	org/json/JSONObject:<init>	()V
    //   7: astore 6
    //   9: new 208	java/lang/String
    //   12: dup
    //   13: aload_1
    //   14: ldc_w 259
    //   17: invokespecial 262	java/lang/String:<init>	([BLjava/lang/String;)V
    //   20: astore_3
    //   21: aload_3
    //   22: astore_1
    //   23: new 256	org/json/JSONObject
    //   26: dup
    //   27: aload_1
    //   28: invokespecial 264	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   31: astore_1
    //   32: aload_1
    //   33: astore 6
    //   35: new 256	org/json/JSONObject
    //   38: dup
    //   39: invokespecial 257	org/json/JSONObject:<init>	()V
    //   42: astore 8
    //   44: new 266	org/json/JSONArray
    //   47: dup
    //   48: invokespecial 267	org/json/JSONArray:<init>	()V
    //   51: astore 9
    //   53: new 266	org/json/JSONArray
    //   56: dup
    //   57: invokespecial 267	org/json/JSONArray:<init>	()V
    //   60: astore 10
    //   62: new 256	org/json/JSONObject
    //   65: dup
    //   66: invokespecial 257	org/json/JSONObject:<init>	()V
    //   69: astore 11
    //   71: new 256	org/json/JSONObject
    //   74: dup
    //   75: invokespecial 257	org/json/JSONObject:<init>	()V
    //   78: astore 12
    //   80: new 266	org/json/JSONArray
    //   83: dup
    //   84: invokespecial 267	org/json/JSONArray:<init>	()V
    //   87: astore_3
    //   88: new 266	org/json/JSONArray
    //   91: dup
    //   92: invokespecial 267	org/json/JSONArray:<init>	()V
    //   95: astore 5
    //   97: new 256	org/json/JSONObject
    //   100: dup
    //   101: invokespecial 257	org/json/JSONObject:<init>	()V
    //   104: astore 7
    //   106: new 256	org/json/JSONObject
    //   109: dup
    //   110: invokespecial 257	org/json/JSONObject:<init>	()V
    //   113: astore_1
    //   114: aload 6
    //   116: ldc_w 269
    //   119: invokevirtual 273	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   122: astore 4
    //   124: aload 4
    //   126: astore_1
    //   127: aload 6
    //   129: ldc_w 275
    //   132: invokevirtual 279	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   135: astore 4
    //   137: aload 6
    //   139: ldc_w 281
    //   142: invokevirtual 279	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   145: astore 5
    //   147: aload 6
    //   149: ldc_w 283
    //   152: invokevirtual 273	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   155: astore 6
    //   157: aload 4
    //   159: astore_3
    //   160: aload 5
    //   162: astore 4
    //   164: aload_3
    //   165: astore 5
    //   167: aload 6
    //   169: astore_3
    //   170: aload 12
    //   172: ldc_w 285
    //   175: aload_1
    //   176: ldc_w 287
    //   179: invokevirtual 290	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   182: invokevirtual 294	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   185: pop
    //   186: aload 12
    //   188: ldc_w 296
    //   191: aload_1
    //   192: ldc_w 298
    //   195: invokevirtual 290	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   198: invokevirtual 294	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   201: pop
    //   202: aload 12
    //   204: ldc_w 300
    //   207: aload_1
    //   208: ldc_w 302
    //   211: invokevirtual 290	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   214: invokevirtual 294	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   217: pop
    //   218: iconst_0
    //   219: istore_2
    //   220: iload_2
    //   221: aload 5
    //   223: invokevirtual 306	org/json/JSONArray:length	()I
    //   226: if_icmpge +166 -> 392
    //   229: new 256	org/json/JSONObject
    //   232: dup
    //   233: invokespecial 257	org/json/JSONObject:<init>	()V
    //   236: astore_1
    //   237: aload 5
    //   239: iload_2
    //   240: invokevirtual 310	org/json/JSONArray:get	(I)Ljava/lang/Object;
    //   243: checkcast 256	org/json/JSONObject
    //   246: astore 6
    //   248: aload_1
    //   249: ldc_w 312
    //   252: aload 6
    //   254: ldc_w 314
    //   257: invokevirtual 318	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   260: invokestatic 322	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   263: invokevirtual 294	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   266: pop
    //   267: aload_1
    //   268: ldc_w 324
    //   271: aload 6
    //   273: ldc_w 326
    //   276: invokevirtual 318	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   279: invokestatic 322	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   282: invokevirtual 294	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   285: pop
    //   286: aload_1
    //   287: ldc_w 328
    //   290: aload 6
    //   292: ldc_w 330
    //   295: invokevirtual 318	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   298: invokestatic 322	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   301: invokevirtual 294	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   304: pop
    //   305: aload_1
    //   306: ldc_w 332
    //   309: aload 6
    //   311: ldc_w 334
    //   314: invokevirtual 318	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   317: invokestatic 322	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   320: invokevirtual 294	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   323: pop
    //   324: aload_1
    //   325: ldc_w 336
    //   328: aload 6
    //   330: ldc_w 338
    //   333: invokevirtual 318	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   336: invokestatic 322	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   339: invokevirtual 294	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   342: pop
    //   343: aload 10
    //   345: aload_1
    //   346: invokevirtual 341	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   349: pop
    //   350: iload_2
    //   351: iconst_1
    //   352: iadd
    //   353: istore_2
    //   354: goto -134 -> 220
    //   357: astore_3
    //   358: new 208	java/lang/String
    //   361: dup
    //   362: aload_1
    //   363: invokespecial 344	java/lang/String:<init>	([B)V
    //   366: astore_1
    //   367: goto -344 -> 23
    //   370: astore_1
    //   371: goto -336 -> 35
    //   374: astore 4
    //   376: aload_3
    //   377: astore 4
    //   379: aload 5
    //   381: astore_3
    //   382: aload_3
    //   383: astore 5
    //   385: aload 7
    //   387: astore_3
    //   388: goto -218 -> 170
    //   391: astore_1
    //   392: iconst_0
    //   393: istore_2
    //   394: iload_2
    //   395: aload 4
    //   397: invokevirtual 306	org/json/JSONArray:length	()I
    //   400: if_icmpge +72 -> 472
    //   403: new 256	org/json/JSONObject
    //   406: dup
    //   407: invokespecial 257	org/json/JSONObject:<init>	()V
    //   410: astore_1
    //   411: aload 4
    //   413: iload_2
    //   414: invokevirtual 310	org/json/JSONArray:get	(I)Ljava/lang/Object;
    //   417: checkcast 256	org/json/JSONObject
    //   420: astore 5
    //   422: aload_1
    //   423: ldc_w 346
    //   426: aload 5
    //   428: ldc_w 348
    //   431: invokevirtual 290	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   434: invokevirtual 294	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   437: pop
    //   438: aload_1
    //   439: ldc_w 336
    //   442: aload 5
    //   444: ldc_w 350
    //   447: invokevirtual 318	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   450: invokestatic 322	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   453: invokevirtual 294	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   456: pop
    //   457: aload 9
    //   459: aload_1
    //   460: invokevirtual 341	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   463: pop
    //   464: iload_2
    //   465: iconst_1
    //   466: iadd
    //   467: istore_2
    //   468: goto -74 -> 394
    //   471: astore_1
    //   472: aload 11
    //   474: ldc_w 352
    //   477: aload_3
    //   478: ldc_w 354
    //   481: invokevirtual 318	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   484: invokestatic 322	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   487: invokevirtual 294	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   490: pop
    //   491: aload 11
    //   493: ldc_w 356
    //   496: aload_3
    //   497: ldc_w 358
    //   500: invokevirtual 318	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   503: invokestatic 322	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   506: invokevirtual 294	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   509: pop
    //   510: aload 11
    //   512: ldc_w 360
    //   515: aload_3
    //   516: ldc_w 362
    //   519: invokevirtual 318	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   522: invokestatic 322	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   525: invokevirtual 294	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   528: pop
    //   529: aload 11
    //   531: ldc_w 364
    //   534: aload_3
    //   535: ldc_w 366
    //   538: invokevirtual 318	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   541: invokestatic 322	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   544: invokevirtual 294	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   547: pop
    //   548: aload 8
    //   550: ldc_w 368
    //   553: aload 12
    //   555: invokevirtual 294	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   558: pop
    //   559: aload 8
    //   561: ldc_w 370
    //   564: aload 11
    //   566: invokevirtual 294	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   569: pop
    //   570: aload 8
    //   572: ldc_w 372
    //   575: aload 10
    //   577: invokevirtual 294	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   580: pop
    //   581: aload 8
    //   583: ldc_w 374
    //   586: aload 9
    //   588: invokevirtual 294	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   591: pop
    //   592: aload 8
    //   594: invokevirtual 375	org/json/JSONObject:toString	()Ljava/lang/String;
    //   597: areturn
    //   598: astore_1
    //   599: goto -7 -> 592
    //   602: astore_1
    //   603: goto -22 -> 581
    //   606: astore_1
    //   607: goto -37 -> 570
    //   610: astore_1
    //   611: goto -52 -> 559
    //   614: astore_1
    //   615: goto -67 -> 548
    //   618: astore_1
    //   619: goto -401 -> 218
    //   622: astore 4
    //   624: aload_3
    //   625: astore 4
    //   627: aload 5
    //   629: astore_3
    //   630: goto -248 -> 382
    //   633: astore 5
    //   635: aload_3
    //   636: astore 5
    //   638: aload 4
    //   640: astore_3
    //   641: aload 5
    //   643: astore 4
    //   645: goto -263 -> 382
    //   648: astore_3
    //   649: aload 4
    //   651: astore_3
    //   652: aload 5
    //   654: astore 4
    //   656: goto -274 -> 382
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	659	0	this	PublicAccountJavascriptInterfaceImpl
    //   0	659	1	paramArrayOfByte	byte[]
    //   219	249	2	i	int
    //   20	150	3	localObject1	Object
    //   357	20	3	localUnsupportedEncodingException1	UnsupportedEncodingException
    //   381	260	3	localObject2	Object
    //   648	1	3	localJSONException1	JSONException
    //   651	1	3	localObject3	Object
    //   122	41	4	localObject4	Object
    //   374	1	4	localJSONException2	JSONException
    //   377	35	4	localUnsupportedEncodingException2	UnsupportedEncodingException
    //   622	1	4	localJSONException3	JSONException
    //   625	30	4	localObject5	Object
    //   95	533	5	localObject6	Object
    //   633	1	5	localJSONException4	JSONException
    //   636	17	5	localObject7	Object
    //   7	322	6	localObject8	Object
    //   104	282	7	localJSONObject1	JSONObject
    //   42	551	8	localJSONObject2	JSONObject
    //   51	536	9	localJSONArray1	JSONArray
    //   60	516	10	localJSONArray2	JSONArray
    //   69	496	11	localJSONObject3	JSONObject
    //   78	476	12	localJSONObject4	JSONObject
    // Exception table:
    //   from	to	target	type
    //   9	21	357	java/io/UnsupportedEncodingException
    //   23	32	370	org/json/JSONException
    //   114	124	374	org/json/JSONException
    //   220	350	391	org/json/JSONException
    //   394	464	471	org/json/JSONException
    //   581	592	598	org/json/JSONException
    //   570	581	602	org/json/JSONException
    //   559	570	606	org/json/JSONException
    //   548	559	610	org/json/JSONException
    //   472	548	614	org/json/JSONException
    //   170	218	618	org/json/JSONException
    //   127	137	622	org/json/JSONException
    //   137	147	633	org/json/JSONException
    //   147	157	648	org/json/JSONException
  }
  
  private static String getBitmapBase64String(String paramString)
  {
    Object localObject = new ByteArrayOutputStream(1024);
    for (;;)
    {
      byte[] arrayOfByte;
      try
      {
        paramString = (HttpURLConnection)new URL(paramString).openConnection();
        paramString.setDoInput(true);
        paramString.connect();
        paramString = paramString.getInputStream();
        arrayOfByte = new byte[1024];
        int i = paramString.read(arrayOfByte);
        if (i == -1)
        {
          paramString.close();
          arrayOfByte = ((ByteArrayOutputStream)localObject).toByteArray();
          if (BitmapFactory.decodeByteArray(arrayOfByte, 0, arrayOfByte.length) == null) {
            return null;
          }
        }
        else
        {
          ((ByteArrayOutputStream)localObject).write(arrayOfByte, 0, i);
          continue;
        }
        if ((arrayOfByte[0] & 0xFF) != 66) {
          break label225;
        }
      }
      catch (IOException paramString)
      {
        paramString.printStackTrace();
        return null;
        localObject = "data:image;base64,";
        if (((arrayOfByte[0] & 0xFF) == 255) && ((arrayOfByte[1] & 0xFF) == 216))
        {
          paramString = "data:image/jpeg;base64,";
          return paramString + Base64Util.encodeToString(arrayOfByte, 2);
          paramString = (String)localObject;
          if ((arrayOfByte[0] & 0xFF) != 71) {
            continue;
          }
          paramString = (String)localObject;
          if ((arrayOfByte[1] & 0xFF) != 73) {
            continue;
          }
          paramString = "data:image/gif;base64,";
          continue;
        }
      }
      catch (OutOfMemoryError paramString)
      {
        paramString.printStackTrace();
        return null;
      }
      if ((arrayOfByte[1] & 0xFF) == 77) {
        paramString = "data:image/bmp;base64,";
      } else {
        label225:
        if (((arrayOfByte[0] & 0xFF) == 137) && ((arrayOfByte[1] & 0xFF) == 80)) {
          paramString = "data:image/png;base64,";
        }
      }
    }
  }
  
  private static long getH5DataUsage()
  {
    Object localObject = new File(PUBACCOUNT_DATA_PATH);
    if (!((File)localObject).exists()) {
      return 0L;
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(localObject);
    long l = 0L;
    while (!localArrayList.isEmpty())
    {
      localObject = (File)localArrayList.remove(0);
      if (((File)localObject).isFile())
      {
        l = ((File)localObject).length() + l;
      }
      else
      {
        localObject = ((File)localObject).listFiles();
        if (localObject != null)
        {
          int j = localObject.length;
          int i = 0;
          while (i < j)
          {
            localArrayList.add(localObject[i]);
            i += 1;
          }
        }
      }
    }
    return l;
  }
  
  private void getLocationImpl(String paramString, long paramLong)
  {
    ((AppActivity)this.context).requestPermissions(new PublicAccountJavascriptInterfaceImpl.6(this, paramString, paramLong), 1, new String[] { "android.permission.ACCESS_FINE_LOCATION" });
  }
  
  private void getRealLocationImpl(boolean paramBoolean, String paramString1, String paramString2)
  {
    int j = 0;
    boolean bool2 = false;
    long l1 = 0L;
    int i = j;
    boolean bool1 = bool2;
    try
    {
      paramString1 = new JSONObject(paramString1);
      i = j;
      bool1 = bool2;
      bool2 = paramString1.optBoolean("fallback", false);
      i = j;
      bool1 = bool2;
      j = paramString1.optInt("decrypt_padding", 0);
      i = j;
      bool1 = bool2;
      long l2 = paramString1.optLong("allowCacheTime", 0L);
      l1 = 1000L * l2;
      bool1 = bool2;
      i = j;
    }
    catch (JSONException paramString1)
    {
      label96:
      break label96;
    }
    ((AppActivity)this.context).requestPermissions(new PublicAccountJavascriptInterfaceImpl.10(this, paramBoolean, i, bool1, paramString2, l1), 1, new String[] { "android.permission.ACCESS_FINE_LOCATION" });
  }
  
  private void getRealLocationPrivate(boolean paramBoolean, String paramString1, String paramString2)
  {
    if (this.mRuntime.a() == null) {}
    String str;
    Object localObject;
    do
    {
      do
      {
        do
        {
          return;
        } while ((this.context == null) || (this.context.isFinishing()));
        if (!(this.context instanceof AppActivity)) {
          break label291;
        }
        if ((this.mDialog != null) && (this.mDialog.isShowing())) {
          this.mDialog.dismiss();
        }
        str = "";
        localObject = this.mRuntime.a();
        if (localObject != null) {
          str = ((AppInterface)localObject).getAccount();
        }
        localObject = "";
        if (this.mRuntime.a() != null) {
          localObject = Util.b(this.mRuntime.a().getUrl());
        }
        if (!getLocationPermissionGrant(str, (String)localObject)) {
          break;
        }
        getRealLocationImpl(paramBoolean, paramString1, paramString2);
      } while (!QLog.isColorLevel());
      QLog.d("PAjs", 2, "already grant");
      return;
      if (!this.hasAsked) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("PAjs", 2, "already ask");
    return;
    this.mDialog = DialogUtil.a(this.context, 0);
    this.mDialog.setMessage(this.context.getString(2131720650, new Object[] { localObject }));
    this.mDialog.setPositiveButton(2131720670, new PublicAccountJavascriptInterfaceImpl.7(this, paramBoolean, paramString1, paramString2, str, (String)localObject));
    this.mDialog.setNegativeButton(this.context.getString(2131720681), new PublicAccountJavascriptInterfaceImpl.8(this, paramString2));
    this.mDialog.setOnCancelListener(new PublicAccountJavascriptInterfaceImpl.9(this, paramString2));
    this.mDialog.show();
    return;
    label291:
    callJs(paramString2, new String[] { "-4", "{}" });
  }
  
  private String hash(String paramString)
  {
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      localMessageDigest.update(paramString.getBytes("UTF-8"));
      paramString = HexUtil.bytes2HexStr(localMessageDigest.digest());
      localMessageDigest.reset();
      return paramString;
    }
    catch (UnsupportedEncodingException paramString)
    {
      return "wronghash";
    }
    catch (NoSuchAlgorithmException paramString)
    {
      label33:
      break label33;
    }
  }
  
  private static boolean isParentDomain(String paramString1, String paramString2)
  {
    if (paramString2 == null) {}
    while ((!paramString2.equals(paramString1)) && ((paramString1.indexOf(".") <= 0) || (!paramString2.endsWith("." + paramString1)))) {
      return false;
    }
    return true;
  }
  
  private String readHash(String paramString1, String paramString2, String paramString3)
  {
    Object localObject = this.mRuntime.a();
    if (localObject == null) {
      return null;
    }
    localObject = ((AppInterface)localObject).getEntityManagerFactory(((AppInterface)localObject).getAccount()).createEntityManager();
    paramString1 = (CouponH5Data)((EntityManager)localObject).find(CouponH5Data.class, "mHost = ? AND mPath = ? AND mKey = ?", new String[] { paramString1, paramString2, paramString3 });
    ((EntityManager)localObject).close();
    if (paramString1 != null) {}
    for (paramString1 = paramString1.mData;; paramString1 = null) {
      return paramString1;
    }
  }
  
  public static void setLocationPermissionGrant(String paramString1, String paramString2, int paramInt)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      QLog.e("PAjs", 1, new Object[] { "uin:", paramString1, " host:", paramString2 });
      return;
    }
    BaseApplicationImpl.getApplication().getSharedPreferences(paramString1 + "LocationPermissionPref", 0).edit().putInt(paramString2 + "-location", paramInt).commit();
  }
  
  private void writeDataInMainThread(String paramString1, String paramString2, JSONObject paramJSONObject)
  {
    CustomWebView localCustomWebView = this.mRuntime.a();
    if (localCustomWebView == null) {
      return;
    }
    try
    {
      ThreadManager.post(new PublicAccountJavascriptInterfaceImpl.15(this, new URL(localCustomWebView.getUrl()), paramString1, paramString2, paramJSONObject), 5, null, false);
      return;
    }
    catch (MalformedURLException paramString1) {}
  }
  
  /* Error */
  private void writeDataWithURL(URL paramURL, String paramString1, String paramString2, JSONObject paramJSONObject)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 181	com/tencent/biz/pubaccount/api/impl/PublicAccountJavascriptInterfaceImpl:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   4: invokevirtual 515	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/biz/pubaccount/CustomWebView;
    //   7: ifnonnull +4 -> 11
    //   10: return
    //   11: aload_0
    //   12: getfield 181	com/tencent/biz/pubaccount/api/impl/PublicAccountJavascriptInterfaceImpl:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   15: invokevirtual 187	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/common/app/AppInterface;
    //   18: astore 7
    //   20: aload 7
    //   22: ifnull +864 -> 886
    //   25: aload 7
    //   27: invokevirtual 192	com/tencent/common/app/AppInterface:getAccount	()Ljava/lang/String;
    //   30: ifnull +856 -> 886
    //   33: new 256	org/json/JSONObject
    //   36: dup
    //   37: aload_2
    //   38: invokespecial 264	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   41: astore 9
    //   43: aload 9
    //   45: ldc_w 723
    //   48: invokevirtual 726	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   51: astore 6
    //   53: aload 6
    //   55: astore 5
    //   57: aload 6
    //   59: invokestatic 669	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   62: ifne +25 -> 87
    //   65: aload 6
    //   67: ldc_w 728
    //   70: ldc_w 730
    //   73: invokevirtual 734	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   76: ldc_w 736
    //   79: ldc_w 738
    //   82: invokevirtual 734	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   85: astore 5
    //   87: aload 4
    //   89: ldc_w 723
    //   92: aload 5
    //   94: invokevirtual 294	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   97: pop
    //   98: getstatic 109	com/tencent/biz/pubaccount/api/impl/PublicAccountJavascriptInterfaceImpl:sH5DataUsage	J
    //   101: ldc2_w 739
    //   104: lcmp
    //   105: ifle +63 -> 168
    //   108: new 742	com/tencent/biz/pubaccount/api/impl/PublicAccountJavascriptInterfaceImpl$16
    //   111: dup
    //   112: aload_0
    //   113: aload_3
    //   114: aload 4
    //   116: aload_2
    //   117: invokespecial 745	com/tencent/biz/pubaccount/api/impl/PublicAccountJavascriptInterfaceImpl$16:<init>	(Lcom/tencent/biz/pubaccount/api/impl/PublicAccountJavascriptInterfaceImpl;Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;)V
    //   120: invokestatic 749	com/tencent/mobileqq/app/ThreadManager:executeOnNetWorkThread	(Ljava/lang/Runnable;)V
    //   123: return
    //   124: astore_1
    //   125: aload_0
    //   126: aload_3
    //   127: iconst_1
    //   128: anewarray 208	java/lang/String
    //   131: dup
    //   132: iconst_0
    //   133: new 76	java/lang/StringBuilder
    //   136: dup
    //   137: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   140: ldc_w 751
    //   143: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   146: aload 4
    //   148: invokevirtual 375	org/json/JSONObject:toString	()Ljava/lang/String;
    //   151: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   154: ldc_w 753
    //   157: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   163: aastore
    //   164: invokevirtual 613	com/tencent/biz/pubaccount/api/impl/PublicAccountJavascriptInterfaceImpl:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   167: return
    //   168: aload 9
    //   170: ldc_w 755
    //   173: invokevirtual 726	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   176: astore 6
    //   178: aload 6
    //   180: invokestatic 669	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   183: ifeq +46 -> 229
    //   186: aload_0
    //   187: aload_3
    //   188: iconst_1
    //   189: anewarray 208	java/lang/String
    //   192: dup
    //   193: iconst_0
    //   194: new 76	java/lang/StringBuilder
    //   197: dup
    //   198: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   201: ldc_w 757
    //   204: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   207: aload 4
    //   209: invokevirtual 375	org/json/JSONObject:toString	()Ljava/lang/String;
    //   212: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   215: ldc_w 753
    //   218: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   221: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   224: aastore
    //   225: invokevirtual 613	com/tencent/biz/pubaccount/api/impl/PublicAccountJavascriptInterfaceImpl:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   228: return
    //   229: aload 9
    //   231: ldc_w 759
    //   234: invokevirtual 726	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   237: astore 5
    //   239: aload 5
    //   241: invokestatic 669	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   244: ifeq +46 -> 290
    //   247: aload_0
    //   248: aload_3
    //   249: iconst_1
    //   250: anewarray 208	java/lang/String
    //   253: dup
    //   254: iconst_0
    //   255: new 76	java/lang/StringBuilder
    //   258: dup
    //   259: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   262: ldc_w 761
    //   265: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   268: aload 4
    //   270: invokevirtual 375	org/json/JSONObject:toString	()Ljava/lang/String;
    //   273: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   276: ldc_w 753
    //   279: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   282: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   285: aastore
    //   286: invokevirtual 613	com/tencent/biz/pubaccount/api/impl/PublicAccountJavascriptInterfaceImpl:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   289: return
    //   290: aload 9
    //   292: ldc_w 763
    //   295: invokevirtual 726	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   298: astore 8
    //   300: aload 8
    //   302: invokestatic 669	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   305: ifeq +46 -> 351
    //   308: aload_0
    //   309: aload_3
    //   310: iconst_1
    //   311: anewarray 208	java/lang/String
    //   314: dup
    //   315: iconst_0
    //   316: new 76	java/lang/StringBuilder
    //   319: dup
    //   320: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   323: ldc_w 765
    //   326: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   329: aload 4
    //   331: invokevirtual 375	org/json/JSONObject:toString	()Ljava/lang/String;
    //   334: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   337: ldc_w 753
    //   340: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   343: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   346: aastore
    //   347: invokevirtual 613	com/tencent/biz/pubaccount/api/impl/PublicAccountJavascriptInterfaceImpl:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   350: return
    //   351: aload_1
    //   352: invokevirtual 768	java/net/URL:getHost	()Ljava/lang/String;
    //   355: astore_1
    //   356: aload 9
    //   358: ldc_w 770
    //   361: invokevirtual 726	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   364: astore_2
    //   365: aload_2
    //   366: invokestatic 669	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   369: ifne +514 -> 883
    //   372: aload_2
    //   373: aload_1
    //   374: invokestatic 772	com/tencent/biz/pubaccount/api/impl/PublicAccountJavascriptInterfaceImpl:isParentDomain	(Ljava/lang/String;Ljava/lang/String;)Z
    //   377: ifeq +279 -> 656
    //   380: aload_2
    //   381: astore_1
    //   382: aload_1
    //   383: astore_2
    //   384: aload_1
    //   385: invokestatic 669	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   388: ifeq +7 -> 395
    //   391: ldc_w 774
    //   394: astore_2
    //   395: aload_0
    //   396: aload 8
    //   398: invokespecial 776	com/tencent/biz/pubaccount/api/impl/PublicAccountJavascriptInterfaceImpl:hash	(Ljava/lang/String;)Ljava/lang/String;
    //   401: astore_1
    //   402: aload_0
    //   403: aload_2
    //   404: aload 6
    //   406: aload 5
    //   408: aload_1
    //   409: invokespecial 780	com/tencent/biz/pubaccount/api/impl/PublicAccountJavascriptInterfaceImpl:writeHash	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   412: aload_0
    //   413: aload 8
    //   415: aload_1
    //   416: invokespecial 782	com/tencent/biz/pubaccount/api/impl/PublicAccountJavascriptInterfaceImpl:encrypt	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   419: astore 8
    //   421: new 447	java/io/File
    //   424: dup
    //   425: new 76	java/lang/StringBuilder
    //   428: dup
    //   429: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   432: getstatic 102	com/tencent/biz/pubaccount/api/impl/PublicAccountJavascriptInterfaceImpl:PUBACCOUNT_DATA_PATH	Ljava/lang/String;
    //   435: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   438: ldc_w 784
    //   441: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   444: aload 7
    //   446: invokevirtual 192	com/tencent/common/app/AppInterface:getAccount	()Ljava/lang/String;
    //   449: invokestatic 787	com/tencent/mobileqq/utils/HexUtil:String2HexString	(Ljava/lang/String;)Ljava/lang/String;
    //   452: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   455: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   458: invokespecial 448	java/io/File:<init>	(Ljava/lang/String;)V
    //   461: astore_1
    //   462: aload_1
    //   463: invokevirtual 451	java/io/File:exists	()Z
    //   466: ifne +233 -> 699
    //   469: aload_1
    //   470: invokevirtual 790	java/io/File:mkdirs	()Z
    //   473: pop
    //   474: new 447	java/io/File
    //   477: dup
    //   478: aload_1
    //   479: aload_2
    //   480: invokespecial 793	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   483: astore_1
    //   484: aload_1
    //   485: invokevirtual 451	java/io/File:exists	()Z
    //   488: ifne +231 -> 719
    //   491: aload_1
    //   492: invokevirtual 790	java/io/File:mkdirs	()Z
    //   495: pop
    //   496: new 447	java/io/File
    //   499: dup
    //   500: aload_1
    //   501: aload 6
    //   503: invokestatic 787	com/tencent/mobileqq/utils/HexUtil:String2HexString	(Ljava/lang/String;)Ljava/lang/String;
    //   506: invokespecial 793	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   509: astore 6
    //   511: aload 6
    //   513: invokevirtual 451	java/io/File:exists	()Z
    //   516: ifne +223 -> 739
    //   519: aload 6
    //   521: invokevirtual 790	java/io/File:mkdirs	()Z
    //   524: pop
    //   525: aconst_null
    //   526: astore_1
    //   527: aload_0
    //   528: monitorenter
    //   529: aload_1
    //   530: astore_2
    //   531: new 447	java/io/File
    //   534: dup
    //   535: aload 6
    //   537: aload 5
    //   539: invokestatic 787	com/tencent/mobileqq/utils/HexUtil:String2HexString	(Ljava/lang/String;)Ljava/lang/String;
    //   542: invokespecial 793	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   545: astore 5
    //   547: aload_1
    //   548: astore_2
    //   549: aload 5
    //   551: invokevirtual 451	java/io/File:exists	()Z
    //   554: ifeq +11 -> 565
    //   557: aload_1
    //   558: astore_2
    //   559: aload 5
    //   561: invokevirtual 796	java/io/File:delete	()Z
    //   564: pop
    //   565: aload_1
    //   566: astore_2
    //   567: new 798	java/io/FileWriter
    //   570: dup
    //   571: aload 5
    //   573: invokespecial 801	java/io/FileWriter:<init>	(Ljava/io/File;)V
    //   576: astore_1
    //   577: aload_1
    //   578: aload 8
    //   580: invokevirtual 803	java/io/FileWriter:write	(Ljava/lang/String;)V
    //   583: getstatic 109	com/tencent/biz/pubaccount/api/impl/PublicAccountJavascriptInterfaceImpl:sH5DataUsage	J
    //   586: aload 5
    //   588: invokevirtual 468	java/io/File:length	()J
    //   591: ladd
    //   592: putstatic 109	com/tencent/biz/pubaccount/api/impl/PublicAccountJavascriptInterfaceImpl:sH5DataUsage	J
    //   595: aload_0
    //   596: monitorexit
    //   597: aload_1
    //   598: astore_2
    //   599: aload_0
    //   600: aload_3
    //   601: iconst_1
    //   602: anewarray 208	java/lang/String
    //   605: dup
    //   606: iconst_0
    //   607: new 76	java/lang/StringBuilder
    //   610: dup
    //   611: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   614: ldc_w 805
    //   617: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   620: aload 4
    //   622: invokevirtual 375	org/json/JSONObject:toString	()Ljava/lang/String;
    //   625: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   628: ldc_w 753
    //   631: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   634: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   637: aastore
    //   638: invokevirtual 613	com/tencent/biz/pubaccount/api/impl/PublicAccountJavascriptInterfaceImpl:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   641: aload_1
    //   642: ifnull +244 -> 886
    //   645: aload_1
    //   646: invokevirtual 806	java/io/FileWriter:close	()V
    //   649: return
    //   650: astore_1
    //   651: aload_1
    //   652: invokevirtual 428	java/io/IOException:printStackTrace	()V
    //   655: return
    //   656: aload_0
    //   657: aload_3
    //   658: iconst_1
    //   659: anewarray 208	java/lang/String
    //   662: dup
    //   663: iconst_0
    //   664: new 76	java/lang/StringBuilder
    //   667: dup
    //   668: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   671: ldc_w 808
    //   674: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   677: aload 4
    //   679: invokevirtual 375	org/json/JSONObject:toString	()Ljava/lang/String;
    //   682: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   685: ldc_w 753
    //   688: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   691: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   694: aastore
    //   695: invokevirtual 613	com/tencent/biz/pubaccount/api/impl/PublicAccountJavascriptInterfaceImpl:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   698: return
    //   699: aload_1
    //   700: invokevirtual 466	java/io/File:isFile	()Z
    //   703: ifeq -229 -> 474
    //   706: aload_1
    //   707: invokevirtual 796	java/io/File:delete	()Z
    //   710: pop
    //   711: aload_1
    //   712: invokevirtual 790	java/io/File:mkdirs	()Z
    //   715: pop
    //   716: goto -242 -> 474
    //   719: aload_1
    //   720: invokevirtual 466	java/io/File:isFile	()Z
    //   723: ifeq -227 -> 496
    //   726: aload_1
    //   727: invokevirtual 796	java/io/File:delete	()Z
    //   730: pop
    //   731: aload_1
    //   732: invokevirtual 790	java/io/File:mkdirs	()Z
    //   735: pop
    //   736: goto -240 -> 496
    //   739: aload 6
    //   741: invokevirtual 466	java/io/File:isFile	()Z
    //   744: ifeq -219 -> 525
    //   747: aload 6
    //   749: invokevirtual 796	java/io/File:delete	()Z
    //   752: pop
    //   753: aload 6
    //   755: invokevirtual 790	java/io/File:mkdirs	()Z
    //   758: pop
    //   759: goto -234 -> 525
    //   762: astore 5
    //   764: aload_2
    //   765: astore_1
    //   766: aload_1
    //   767: astore_2
    //   768: aload_0
    //   769: monitorexit
    //   770: aload 5
    //   772: athrow
    //   773: astore_2
    //   774: aload_1
    //   775: astore_2
    //   776: aload_0
    //   777: aload_3
    //   778: iconst_1
    //   779: anewarray 208	java/lang/String
    //   782: dup
    //   783: iconst_0
    //   784: new 76	java/lang/StringBuilder
    //   787: dup
    //   788: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   791: ldc_w 810
    //   794: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   797: aload 4
    //   799: invokevirtual 375	org/json/JSONObject:toString	()Ljava/lang/String;
    //   802: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   805: ldc_w 753
    //   808: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   811: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   814: aastore
    //   815: invokevirtual 613	com/tencent/biz/pubaccount/api/impl/PublicAccountJavascriptInterfaceImpl:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   818: aload_1
    //   819: ifnull +67 -> 886
    //   822: aload_1
    //   823: invokevirtual 806	java/io/FileWriter:close	()V
    //   826: return
    //   827: astore_1
    //   828: aload_1
    //   829: invokevirtual 428	java/io/IOException:printStackTrace	()V
    //   832: return
    //   833: astore_1
    //   834: aconst_null
    //   835: astore_2
    //   836: aload_2
    //   837: ifnull +7 -> 844
    //   840: aload_2
    //   841: invokevirtual 806	java/io/FileWriter:close	()V
    //   844: aload_1
    //   845: athrow
    //   846: astore_2
    //   847: aload_2
    //   848: invokevirtual 428	java/io/IOException:printStackTrace	()V
    //   851: goto -7 -> 844
    //   854: astore 5
    //   856: aload_1
    //   857: astore_2
    //   858: aload 5
    //   860: astore_1
    //   861: goto -25 -> 836
    //   864: astore_1
    //   865: goto -29 -> 836
    //   868: astore_1
    //   869: aconst_null
    //   870: astore_1
    //   871: goto -97 -> 774
    //   874: astore_2
    //   875: goto -101 -> 774
    //   878: astore 5
    //   880: goto -114 -> 766
    //   883: goto -501 -> 382
    //   886: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	887	0	this	PublicAccountJavascriptInterfaceImpl
    //   0	887	1	paramURL	URL
    //   0	887	2	paramString1	String
    //   0	887	3	paramString2	String
    //   0	887	4	paramJSONObject	JSONObject
    //   55	532	5	localObject1	Object
    //   762	9	5	localObject2	Object
    //   854	5	5	localObject3	Object
    //   878	1	5	localObject4	Object
    //   51	703	6	localObject5	Object
    //   18	427	7	localAppInterface	AppInterface
    //   298	281	8	str	String
    //   41	316	9	localJSONObject	JSONObject
    // Exception table:
    //   from	to	target	type
    //   0	10	124	org/json/JSONException
    //   11	20	124	org/json/JSONException
    //   25	53	124	org/json/JSONException
    //   57	87	124	org/json/JSONException
    //   87	123	124	org/json/JSONException
    //   168	228	124	org/json/JSONException
    //   229	289	124	org/json/JSONException
    //   290	350	124	org/json/JSONException
    //   351	380	124	org/json/JSONException
    //   384	391	124	org/json/JSONException
    //   395	474	124	org/json/JSONException
    //   474	496	124	org/json/JSONException
    //   496	525	124	org/json/JSONException
    //   645	649	124	org/json/JSONException
    //   651	655	124	org/json/JSONException
    //   656	698	124	org/json/JSONException
    //   699	716	124	org/json/JSONException
    //   719	736	124	org/json/JSONException
    //   739	759	124	org/json/JSONException
    //   822	826	124	org/json/JSONException
    //   828	832	124	org/json/JSONException
    //   840	844	124	org/json/JSONException
    //   844	846	124	org/json/JSONException
    //   847	851	124	org/json/JSONException
    //   645	649	650	java/io/IOException
    //   531	547	762	finally
    //   549	557	762	finally
    //   559	565	762	finally
    //   567	577	762	finally
    //   768	770	762	finally
    //   770	773	773	java/io/IOException
    //   822	826	827	java/io/IOException
    //   527	529	833	finally
    //   840	844	846	java/io/IOException
    //   770	773	854	finally
    //   599	641	864	finally
    //   776	818	864	finally
    //   527	529	868	java/io/IOException
    //   599	641	874	java/io/IOException
    //   577	597	878	finally
  }
  
  private void writeHash(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    Object localObject = this.mRuntime.a();
    if (localObject == null) {
      return;
    }
    localObject = ((AppInterface)localObject).getEntityManagerFactory(((AppInterface)localObject).getAccount()).createEntityManager();
    CouponH5Data localCouponH5Data = (CouponH5Data)((EntityManager)localObject).find(CouponH5Data.class, "mHost = ? AND mPath = ? AND mKey = ?", new String[] { paramString1, paramString2, paramString3 });
    if (localCouponH5Data == null) {
      ((EntityManager)localObject).persist(new CouponH5Data(paramString1, paramString2, paramString3, paramString4));
    }
    for (;;)
    {
      ((EntityManager)localObject).close();
      return;
      localCouponH5Data.mData = paramString4;
      ((EntityManager)localObject).update(localCouponH5Data);
    }
  }
  
  public void actionSheetAdditionalItems(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PAjs", 2, "actionSheetAdditionalItems->paramStr:" + paramString);
    }
    try
    {
      Object localObject = ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).parseString2Json(paramString);
      if (localObject != null)
      {
        paramString = (SwiftBrowserShareMenuHandler)super.getBrowserComponent(4);
        if (((JSONObject)localObject).has("pageType"))
        {
          int j = ((JSONObject)localObject).getInt("pageType");
          localObject = ((JSONObject)localObject).getJSONArray("itemList");
          ArrayList localArrayList = new ArrayList();
          if (localObject != null)
          {
            int i = 0;
            while (i < ((JSONArray)localObject).length())
            {
              JSONObject localJSONObject = ((JSONArray)localObject).getJSONObject(i);
              IPublicAccountJavascriptInterface.ActionItem localActionItem = new IPublicAccountJavascriptInterface.ActionItem();
              localActionItem.jdField_a_of_type_Int = localJSONObject.optInt("itemType");
              localActionItem.jdField_a_of_type_JavaLangString = localJSONObject.optString("itemName");
              localActionItem.b = localJSONObject.optString("itemActionData");
              localArrayList.add(localActionItem);
              i += 1;
            }
          }
          if (paramString != null)
          {
            if (j == 1) {
              paramString.e = true;
            }
            for (;;)
            {
              paramString.b = localArrayList;
              return;
              paramString.f = true;
            }
          }
        }
      }
      return;
    }
    catch (JSONException paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PAjs", 2, "actionSheetAdditionalItems->error:" + paramString);
      }
    }
  }
  
  public void close()
  {
    this.context.finish();
  }
  
  public void deleteAllH5Data(AppInterface paramAppInterface)
  {
    EntityManager localEntityManager = paramAppInterface.getEntityManagerFactory(paramAppInterface.getAccount()).createEntityManager();
    Object localObject1 = localEntityManager.query(CouponH5Data.class);
    if (localObject1 != null)
    {
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (CouponH5Data)((Iterator)localObject1).next();
        localObject2 = new File(PUBACCOUNT_DATA_PATH + "/" + HexUtil.String2HexString(paramAppInterface.getAccount()) + "/" + ((CouponH5Data)localObject2).mHost);
        if (((File)localObject2).exists()) {
          FileUtil.a((File)localObject2);
        }
      }
    }
    localEntityManager.drop(CouponH5Data.class);
    localEntityManager.close();
  }
  
  public void deleteH5Data(String paramString1, String paramString2)
  {
    CustomWebView localCustomWebView = this.mRuntime.a();
    if (localCustomWebView == null) {}
    AppInterface localAppInterface;
    do
    {
      return;
      localAppInterface = this.mRuntime.a();
    } while (localAppInterface == null);
    JSONObject localJSONObject1 = new JSONObject();
    if (TextUtils.isEmpty(paramString1))
    {
      callJs(paramString2, new String[] { "{ret:-3, response:" + localJSONObject1.toString() + "}" });
      return;
    }
    JSONObject localJSONObject2;
    String str2;
    try
    {
      localJSONObject2 = new JSONObject(paramString1);
      str1 = localJSONObject2.optString("callid");
      paramString1 = str1;
      if (!TextUtils.isEmpty(str1)) {
        paramString1 = str1.replace("\\", "\\\\").replace("'", "\\'");
      }
      localJSONObject1.put("callid", paramString1);
      str2 = localJSONObject2.optString("path");
      if (TextUtils.isEmpty(str2))
      {
        callJs(paramString2, new String[] { "{ret:-6, response:" + localJSONObject1.toString() + "}" });
        return;
      }
    }
    catch (JSONException paramString1)
    {
      callJs(paramString2, new String[] { "{ret:-2, response:" + localJSONObject1.toString() + "}" });
      return;
    }
    String str3 = localJSONObject2.optString("key");
    paramString1 = null;
    try
    {
      str1 = new URL(localCustomWebView.getUrl()).getHost();
      paramString1 = str1;
    }
    catch (MalformedURLException localMalformedURLException)
    {
      for (;;) {}
    }
    String str1 = localJSONObject2.optString("host");
    if (!TextUtils.isEmpty(str1))
    {
      if (isParentDomain(str1, paramString1))
      {
        paramString1 = str1;
        str1 = paramString1;
        if (TextUtils.isEmpty(paramString1)) {
          str1 = "defaulthost";
        }
        if (!TextUtils.isEmpty(str3)) {
          break label489;
        }
        deleteHash(str1, str2);
        FileUtil.a(new File(PUBACCOUNT_DATA_PATH + "/" + HexUtil.String2HexString(localAppInterface.getAccount()) + "/" + str1 + "/" + HexUtil.String2HexString(str2)));
      }
      for (;;)
      {
        callJs(paramString2, new String[] { "{ret:0, response:" + localJSONObject1.toString() + "}" });
        return;
        callJs(paramString2, new String[] { "{ret:-5, response:" + localJSONObject1.toString() + "}" });
        return;
        label489:
        deleteHash(str1, str2, str3);
        FileUtil.a(new File(PUBACCOUNT_DATA_PATH + "/" + HexUtil.String2HexString(localAppInterface.getAccount()) + "/" + str1 + "/" + HexUtil.String2HexString(str2) + "/" + HexUtil.String2HexString(str3)));
      }
    }
  }
  
  public void deleteH5DataByHost(String paramString1, String paramString2)
  {
    CustomWebView localCustomWebView = this.mRuntime.a();
    if (localCustomWebView == null) {}
    AppInterface localAppInterface;
    do
    {
      return;
      localAppInterface = this.mRuntime.a();
    } while (localAppInterface == null);
    JSONObject localJSONObject1 = new JSONObject();
    if (TextUtils.isEmpty(paramString1))
    {
      callJs(paramString2, new String[] { "{ret:-3, response:" + localJSONObject1.toString() + "}" });
      return;
    }
    try
    {
      localJSONObject2 = new JSONObject(paramString1);
      str = localJSONObject2.optString("callid");
      paramString1 = str;
      if (!TextUtils.isEmpty(str)) {
        paramString1 = str.replace("\\", "\\\\").replace("'", "\\'");
      }
      localJSONObject1.put("callid", paramString1);
      paramString1 = null;
    }
    catch (JSONException paramString1)
    {
      JSONObject localJSONObject2;
      String str;
      label166:
      label192:
      callJs(paramString2, new String[] { "{ret:-2, response:" + localJSONObject1.toString() + "}" });
      return;
    }
    try
    {
      str = new URL(localCustomWebView.getUrl()).getHost();
      paramString1 = str;
    }
    catch (MalformedURLException localMalformedURLException)
    {
      break label166;
      break label192;
    }
    str = localJSONObject2.optString("host");
    if (!TextUtils.isEmpty(str))
    {
      if (isParentDomain(str, paramString1))
      {
        paramString1 = str;
        str = paramString1;
        if (TextUtils.isEmpty(paramString1)) {
          str = "defaulthost";
        }
        deleteHash(str);
        FileUtil.a(new File(PUBACCOUNT_DATA_PATH + "/" + HexUtil.String2HexString(localAppInterface.getAccount()) + "/" + str));
        callJs(paramString2, new String[] { "{ret:0, response:" + localJSONObject1.toString() + "}" });
        return;
      }
      callJs(paramString2, new String[] { "{ret:-5, response:" + localJSONObject1.toString() + "}" });
      return;
    }
  }
  
  public void enableNotCare(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PAjs", 2, "enable share dian dian->paramStr:" + paramString);
    }
    try
    {
      Object localObject = ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).parseString2Json(paramString);
      if (localObject != null)
      {
        paramString = (SwiftBrowserShareMenuHandler)super.getBrowserComponent(4);
        if (((JSONObject)localObject).has("enable"))
        {
          localObject = ((JSONObject)localObject).getString("enable");
          if (paramString != null)
          {
            if ("1".equals(localObject))
            {
              paramString.e(true);
              return;
            }
            paramString.e(false);
            return;
          }
        }
      }
    }
    catch (JSONException paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PAjs", 2, "enable Share dian dian->error:" + paramString);
      }
    }
  }
  
  public void enableScreenshot(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PAjs", 2, "enableScreenshot->enable:" + paramString);
    }
    SwiftBrowserScreenShotHandler localSwiftBrowserScreenShotHandler = (SwiftBrowserScreenShotHandler)super.getBrowserComponent(64);
    if (localSwiftBrowserScreenShotHandler != null)
    {
      if ("1".equals(paramString)) {
        localSwiftBrowserScreenShotHandler.b("");
      }
    }
    else {
      return;
    }
    localSwiftBrowserScreenShotHandler.a();
  }
  
  public void enableShareDianDian(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PAjs", 2, "enable share dian dian->paramStr:" + paramString);
    }
    try
    {
      Object localObject = ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).parseString2Json(paramString);
      if (localObject != null)
      {
        paramString = (SwiftBrowserShareMenuHandler)super.getBrowserComponent(4);
        if (((JSONObject)localObject).has("enable"))
        {
          String str = ((JSONObject)localObject).getString("enable");
          if (paramString != null)
          {
            if (!"1".equals(str)) {
              break label136;
            }
            paramString.c(true);
          }
        }
        for (;;)
        {
          if (!((JSONObject)localObject).has("enableShortLink")) {
            return;
          }
          localObject = ((JSONObject)localObject).getString("enableShortLink");
          if (paramString == null) {
            return;
          }
          if (!"1".equals(localObject)) {
            break;
          }
          paramString.d(true);
          return;
          label136:
          paramString.c(false);
        }
      }
      return;
    }
    catch (JSONException paramString)
    {
      if (QLog.isColorLevel())
      {
        QLog.d("PAjs", 2, "enable Share dian dian->error:" + paramString);
        return;
        paramString.d(false);
      }
    }
  }
  
  public void enableShareSinaWeibo(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PAjs", 2, "enableShareSinaWeibo->paramStr:" + paramString);
    }
    try
    {
      paramString = ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).parseString2Json(paramString);
      if ((paramString != null) && (paramString.has("enable")))
      {
        paramString = paramString.getString("enable");
        SwiftBrowserShareMenuHandler localSwiftBrowserShareMenuHandler = (SwiftBrowserShareMenuHandler)super.getBrowserComponent(4);
        if (localSwiftBrowserShareMenuHandler != null)
        {
          if ("1".equals(paramString))
          {
            localSwiftBrowserShareMenuHandler.b(true);
            return;
          }
          localSwiftBrowserShareMenuHandler.b(false);
          return;
        }
      }
    }
    catch (JSONException paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PAjs", 2, "enableShareSinaWeibo->error:" + paramString);
      }
    }
  }
  
  public int excuteShowProfile(AppInterface paramAppInterface, Context paramContext, String paramString)
  {
    int k = 0;
    if (QLog.isColorLevel()) {
      QLog.i("PAjs", 2, "showProfile: " + paramString);
    }
    if (paramString == null) {
      return -1;
    }
    Object localObject1 = paramString.trim();
    Object localObject2 = "";
    String str1 = "";
    String str2 = null;
    if (((String)localObject1).startsWith("{")) {}
    for (;;)
    {
      Object localObject3;
      String str3;
      int j;
      Object localObject4;
      String str4;
      try
      {
        localObject3 = new JSONObject((String)localObject1);
        str3 = ((JSONObject)localObject3).getString("uin");
        int m = ((JSONObject)localObject3).optInt("uinType", 0);
        j = ((JSONObject)localObject3).optInt("isFinish", 0);
        if ("groupSearchOther".equals(((JSONObject)localObject3).optString("jump_from")))
        {
          paramString = "group";
          i = ((JSONObject)localObject3).optInt("subSourceID");
          localObject1 = str2;
          localObject2 = str1;
          if (((JSONObject)localObject3).optInt("colorScreen") != 0) {
            localObject2 = "&colorScreen=" + ((JSONObject)localObject3).optInt("colorScreen");
          }
          str2 = ((JSONObject)localObject3).optString("authKey");
          str1 = ((JSONObject)localObject3).optString("authSig");
          localObject3 = localObject2;
          localObject4 = localObject1;
          localObject1 = str3;
          localObject2 = paramString;
          paramString = (String)localObject3;
          if ((localObject1 == null) || (((String)localObject1).length() < 5)) {
            break;
          }
          if (localObject4 == null) {
            break label549;
          }
          paramContext.startActivity((Intent)localObject4);
          return j;
        }
        if (m == 1)
        {
          paramString = "group";
          i = ((JSONObject)localObject3).optInt("wSourceSubID");
          localObject1 = str2;
          continue;
        }
        localObject1 = str2;
        i = k;
        paramString = (String)localObject2;
        if (m != 0) {
          continue;
        }
        str4 = ((JSONObject)localObject3).optString("from");
        localObject4 = ((JSONObject)localObject3).optString("troopuin");
        if ((!"groupActivity".equals(str4)) || (TextUtils.isEmpty((CharSequence)localObject4))) {
          break label437;
        }
        localObject1 = new Intent(paramContext, FriendProfileCardActivity.class);
        paramString = new ProfileActivity.AllInOne(str3, 120);
        paramString.c = ((String)localObject4);
        ((Intent)localObject1).putExtra("AllInOne", paramString);
        paramString = new Bundle();
        paramString.putString("troop_uin", (String)localObject4);
        ((Intent)localObject1).putExtra("flc_extra_param", paramString);
        i = k;
        paramString = (String)localObject2;
        continue;
        if (!QLog.isDevelopLevel()) {
          break;
        }
      }
      catch (JSONException paramAppInterface) {}
      QLog.d("PAjs", 4, "showProfile param error");
      return -1;
      label437:
      localObject1 = str2;
      int i = k;
      paramString = (String)localObject2;
      if ("groupMembers".equals(str4))
      {
        localObject1 = str2;
        i = k;
        paramString = (String)localObject2;
        if (!TextUtils.isEmpty((CharSequence)localObject4))
        {
          localObject1 = new Intent(paramContext, FriendProfileCardActivity.class);
          ((Intent)localObject1).putExtra("troopUin", (String)localObject4);
          ((Intent)localObject1).putExtra("memberUin", str3);
          i = k;
          paramString = (String)localObject2;
          continue;
          i = 0;
          paramString = "";
          localObject4 = null;
          j = 0;
          str2 = "";
          str1 = "";
          continue;
          label549:
          localObject3 = new StringBuilder();
          if (!TextUtils.isEmpty(str2))
          {
            str2 = "&authKey=" + str2;
            label589:
            ((StringBuilder)localObject3).append(str2);
            if (TextUtils.isEmpty(str1)) {
              break label723;
            }
          }
          label723:
          for (str1 = "&authSig=" + str1;; str1 = "")
          {
            ((StringBuilder)localObject3).append(str1);
            paramString = "mqq://card/show_pslcard/?uin=" + (String)localObject1 + "&card_type=" + (String)localObject2 + "&wSourceSubID=" + i + ((StringBuilder)localObject3).toString() + paramString;
            if (!(paramAppInterface instanceof QQAppInterface)) {
              break label731;
            }
            JumpParser.a((QQAppInterface)paramAppInterface, paramContext, paramString).a();
            break;
            str2 = "";
            break label589;
          }
          label731:
          paramContext.startActivity(new Intent(paramContext, JumpActivity.class).setData(Uri.parse(paramString)));
        }
      }
    }
  }
  
  public String getDataPath()
  {
    return PUBACCOUNT_DATA_PATH;
  }
  
  public void getJson(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    callJs("clientCallback", new String[] { Util.a("{'r': -102, 'msg': 'no such method'}"), Util.a(paramString4) });
  }
  
  public void getLocation(String paramString)
  {
    long l = 0L;
    if (QLog.isColorLevel()) {
      QLog.d("PAjs.location", 2, "getLocation:" + paramString);
    }
    if (this.mRuntime.a() == null) {
      if (QLog.isColorLevel()) {
        QLog.w("PAjs.location", 2, "getWebView()==null, return");
      }
    }
    Object localObject1;
    Object localObject2;
    label332:
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            if ((this.context != null) && (!this.context.isFinishing())) {
              break;
            }
          } while (!QLog.isColorLevel());
          QLog.w("PAjs.location", 2, "context==null || isFinishing, return");
          return;
          if (paramString.charAt(0) == '{') {}
          for (;;)
          {
            try
            {
              localObject1 = new JSONObject(paramString);
              paramString = ((JSONObject)localObject1).getString("callback");
              l = ((JSONObject)localObject1).optLong("allowCacheTime", 0L) * 1000L;
              bool = ((JSONObject)localObject1).optBoolean("is_for_ecshop_map");
              localObject1 = "";
              localObject2 = this.mRuntime.a();
              if (localObject2 != null) {
                localObject1 = ((AppInterface)localObject2).getAccount();
              }
              if ((!bool) || (TextUtils.isEmpty((CharSequence)localObject1)) || (localObject2 == null)) {
                break label332;
              }
              localObject1 = ((AppInterface)localObject2).getApp().getSharedPreferences((String)localObject1, 0);
              double d1 = ((SharedPreferences)localObject1).getFloat("search_lbs_logitude", 0.0F);
              double d2 = ((SharedPreferences)localObject1).getFloat("search_lbs_latitude", 0.0F);
              if (QLog.isColorLevel()) {
                QLog.i("EcShopAssistantActivity", 2, String.format("'longitude:%1$1.15f,latitude:%2$1.15f'", new Object[] { Double.valueOf(d1), Double.valueOf(d2) }));
              }
              callJs(paramString, new String[] { String.format("'%1$1.15f,%2$1.15f'", new Object[] { Double.valueOf(d1), Double.valueOf(d2) }) });
              return;
            }
            catch (JSONException paramString) {}
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.w("PAjs.location", 2, "getLocation exception:", paramString);
            return;
            boolean bool = false;
          }
          localObject2 = "";
          if (this.mRuntime.a() != null) {
            localObject2 = Util.a(this.mRuntime.a().getUrl(), 2);
          }
        } while (TextUtils.isEmpty(paramString));
        if (!(this.context instanceof AppActivity)) {
          break label577;
        }
        if ((this.mDialog != null) && (this.mDialog.isShowing())) {
          this.mDialog.dismiss();
        }
        if (!getLocationPermissionGrant((String)localObject1, (String)localObject2)) {
          break;
        }
        getLocationImpl(paramString, l);
      } while (!QLog.isColorLevel());
      QLog.d("PAjs", 2, "already grant");
      return;
      if (!this.hasAsked) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("PAjs", 2, "already ask");
    return;
    this.mDialog = DialogUtil.a(this.context, 0);
    this.mDialog.setMessage(this.context.getString(2131720650, new Object[] { localObject2 }));
    this.mDialog.setPositiveButton(2131720670, new PublicAccountJavascriptInterfaceImpl.3(this, paramString, l, (String)localObject1, (String)localObject2));
    this.mDialog.setNegativeButton(this.context.getString(2131720681), new PublicAccountJavascriptInterfaceImpl.4(this, paramString));
    this.mDialog.setOnCancelListener(new PublicAccountJavascriptInterfaceImpl.5(this, paramString));
    this.mDialog.show();
    return;
    label577:
    callJs(paramString, new String[] { "-4", "{}" });
  }
  
  public boolean getLocationPermissionGrant(String paramString1, String paramString2)
  {
    boolean bool = true;
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      QLog.e("PAjs", 1, new Object[] { "uin:", paramString1, " host:", paramString2 });
      bool = false;
    }
    do
    {
      return bool;
      if (paramString2.contains("qq.com"))
      {
        QLog.d("PAjs", 1, "qq.com can grant");
        return true;
      }
    } while (BaseApplicationImpl.getApplication().getSharedPreferences(paramString1 + "LocationPermissionPref", 0).getInt(paramString2 + "-location", 0) == 1);
    return false;
  }
  
  public String getNameSpace()
  {
    return "publicAccount";
  }
  
  public int getNetworkState()
  {
    return NetworkUtil.b(BaseApplication.getContext());
  }
  
  public String getNetworkType()
  {
    NetworkInfo localNetworkInfo = AppNetConnInfo.getRecentNetworkInfo();
    if (localNetworkInfo != null)
    {
      switch (localNetworkInfo.getType())
      {
      default: 
        return "other";
      case 1: 
        return "WiFi";
      }
      String str;
      switch (localNetworkInfo.getSubtype())
      {
      case 7: 
      case 10: 
      case 11: 
      default: 
        str = "other_";
      }
      for (;;)
      {
        return str + localNetworkInfo.getExtraInfo();
        str = "CDMA_";
        continue;
        str = "EDGE_";
        continue;
        str = "GPRS";
        continue;
        str = "EVDO_0_";
        continue;
        str = "EVDO_A_";
        continue;
        str = "EVDO_B_";
        continue;
        str = "UMTS_";
        continue;
        str = "HSUPA_";
        continue;
        str = "HSDPA_";
      }
    }
    return "empty";
  }
  
  public void getPageLoadStamp(String paramString)
  {
    if (this.uiMethodInterface != null)
    {
      if (!TextUtils.isEmpty(this.uiMethodInterface.getCurrentUrl())) {}
      for (String str = this.uiMethodInterface.getCurrentUrl();; str = "")
      {
        if (this.reportSpeedInterface != null) {
          callJs(paramString, new String[] { "{ret:0, onCreateTime:" + this.reportSpeedInterface.getmOnCreateMilliTimeStamp() + ", startLoadUrlTime:" + this.reportSpeedInterface.getmStartLoadUrlMilliTimeStamp() + ", url:'" + str + "'}" });
        }
        return;
      }
    }
    callJs(paramString, new String[] { "{ret: -1}" });
  }
  
  public void getRealLocation(String paramString1, String paramString2)
  {
    getRealLocationPrivate(false, paramString1, paramString2);
  }
  
  public void getRealLocationDes(String paramString1, String paramString2)
  {
    getRealLocationPrivate(true, paramString1, paramString2);
  }
  
  public void getUrlImage(String paramString1, String paramString2)
  {
    JSONObject localJSONObject = new JSONObject();
    if (!TextUtils.isEmpty(paramString1))
    {
      new PublicAccountJavascriptInterfaceImpl.12(this, paramString1, localJSONObject, paramString2).start();
      return;
    }
    callJs(paramString2, new String[] { "{ret:-3, response:" + localJSONObject.toString() + "}" });
  }
  
  public WebViewPlugin getWebViewPlugin()
  {
    return this;
  }
  
  public void hideLoading()
  {
    Object localObject = this.mRuntime.a(this.mRuntime.a());
    if ((localObject != null) && ((localObject instanceof WebUiUtils.WebProgressInterface))) {
      ((WebUiUtils.WebProgressInterface)localObject).a();
    }
    do
    {
      return;
      localObject = (SwiftBrowserUIStyleHandler)super.getBrowserComponent(2);
    } while ((localObject == null) || (((SwiftBrowserUIStyleHandler)localObject).a == null));
    ((SwiftBrowserUIStyleHandler)localObject).a.setVisibility(8);
  }
  
  /* Error */
  protected String httpRequest(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 181	com/tencent/biz/pubaccount/api/impl/PublicAccountJavascriptInterfaceImpl:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   4: invokevirtual 187	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/common/app/AppInterface;
    //   7: astore 6
    //   9: aload 6
    //   11: ifnonnull +7 -> 18
    //   14: ldc_w 532
    //   17: areturn
    //   18: ldc_w 1284
    //   21: astore 4
    //   23: new 256	org/json/JSONObject
    //   26: dup
    //   27: aload_2
    //   28: invokespecial 264	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   31: astore 5
    //   33: aload 5
    //   35: astore_3
    //   36: invokestatic 550	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   39: ifeq +32 -> 71
    //   42: ldc 48
    //   44: iconst_2
    //   45: new 76	java/lang/StringBuilder
    //   48: dup
    //   49: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   52: ldc_w 1286
    //   55: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: aload_2
    //   59: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   65: invokestatic 949	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   68: aload 5
    //   70: astore_3
    //   71: new 1019	android/os/Bundle
    //   74: dup
    //   75: invokespecial 1020	android/os/Bundle:<init>	()V
    //   78: astore 5
    //   80: aload 5
    //   82: ldc_w 993
    //   85: ldc_w 1288
    //   88: invokevirtual 1025	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   91: aload 4
    //   93: astore_2
    //   94: aload_3
    //   95: ifnull +33 -> 128
    //   98: aload 4
    //   100: astore_2
    //   101: aload_3
    //   102: ldc_w 1290
    //   105: invokevirtual 842	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   108: ifeq +20 -> 128
    //   111: aload_3
    //   112: ldc_w 1290
    //   115: invokevirtual 290	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   118: astore_2
    //   119: aload_2
    //   120: invokevirtual 1293	java/lang/String:toUpperCase	()Ljava/lang/String;
    //   123: astore 4
    //   125: aload 4
    //   127: astore_2
    //   128: aload_3
    //   129: ifnull +70 -> 199
    //   132: aload_3
    //   133: ldc_w 1295
    //   136: invokevirtual 842	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   139: ifeq +60 -> 199
    //   142: aload_3
    //   143: ldc_w 1295
    //   146: invokevirtual 273	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   149: astore_3
    //   150: aload_3
    //   151: invokevirtual 1298	org/json/JSONObject:keys	()Ljava/util/Iterator;
    //   154: astore 4
    //   156: aload 4
    //   158: invokeinterface 226 1 0
    //   163: ifeq +36 -> 199
    //   166: aload 4
    //   168: invokeinterface 230 1 0
    //   173: invokevirtual 1299	java/lang/Object:toString	()Ljava/lang/String;
    //   176: astore 7
    //   178: aload 5
    //   180: aload 7
    //   182: aload_3
    //   183: aload 7
    //   185: invokevirtual 290	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   188: invokevirtual 1025	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   191: goto -35 -> 156
    //   194: astore_3
    //   195: aload_3
    //   196: invokevirtual 1300	org/json/JSONException:printStackTrace	()V
    //   199: aload 6
    //   201: invokevirtual 192	com/tencent/common/app/AppInterface:getAccount	()Ljava/lang/String;
    //   204: astore_3
    //   205: new 76	java/lang/StringBuilder
    //   208: dup
    //   209: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   212: ldc_w 1302
    //   215: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   218: aload_3
    //   219: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   222: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   225: astore_3
    //   226: new 1019	android/os/Bundle
    //   229: dup
    //   230: invokespecial 1020	android/os/Bundle:<init>	()V
    //   233: astore 4
    //   235: aload 4
    //   237: ldc_w 1304
    //   240: aload_3
    //   241: invokevirtual 1025	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   244: aload_0
    //   245: getfield 474	com/tencent/biz/pubaccount/api/impl/PublicAccountJavascriptInterfaceImpl:context	Landroid/app/Activity;
    //   248: invokevirtual 1308	android/app/Activity:getApplicationContext	()Landroid/content/Context;
    //   251: aload_1
    //   252: aload_2
    //   253: aload 5
    //   255: aload 4
    //   257: invokestatic 1314	com/tencent/biz/common/util/HttpUtil:openUrl	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;Landroid/os/Bundle;)Ljava/lang/String;
    //   260: astore_1
    //   261: aload_1
    //   262: areturn
    //   263: astore 4
    //   265: ldc_w 1284
    //   268: astore_2
    //   269: aload 4
    //   271: invokevirtual 1300	org/json/JSONException:printStackTrace	()V
    //   274: goto -146 -> 128
    //   277: astore_1
    //   278: aload_1
    //   279: invokevirtual 1315	org/apache/http/client/ClientProtocolException:printStackTrace	()V
    //   282: ldc_w 1317
    //   285: areturn
    //   286: astore_1
    //   287: aload_1
    //   288: invokevirtual 428	java/io/IOException:printStackTrace	()V
    //   291: ldc_w 1319
    //   294: areturn
    //   295: astore 4
    //   297: goto -28 -> 269
    //   300: astore_2
    //   301: aconst_null
    //   302: astore_3
    //   303: goto -232 -> 71
    //   306: astore_2
    //   307: aload 5
    //   309: astore_3
    //   310: goto -239 -> 71
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	313	0	this	PublicAccountJavascriptInterfaceImpl
    //   0	313	1	paramString1	String
    //   0	313	2	paramString2	String
    //   35	148	3	localObject1	Object
    //   194	2	3	localJSONException1	JSONException
    //   204	106	3	localObject2	Object
    //   21	235	4	localObject3	Object
    //   263	7	4	localJSONException2	JSONException
    //   295	1	4	localJSONException3	JSONException
    //   31	277	5	localObject4	Object
    //   7	193	6	localAppInterface	AppInterface
    //   176	8	7	str	String
    // Exception table:
    //   from	to	target	type
    //   132	156	194	org/json/JSONException
    //   156	191	194	org/json/JSONException
    //   101	119	263	org/json/JSONException
    //   244	261	277	org/apache/http/client/ClientProtocolException
    //   244	261	286	java/io/IOException
    //   119	125	295	org/json/JSONException
    //   23	33	300	org/json/JSONException
    //   36	68	306	org/json/JSONException
  }
  
  public void isFollowUin(String paramString1, String paramString2)
  {
    JSONObject localJSONObject = new JSONObject();
    if (TextUtils.isEmpty(paramString1)) {
      callJs(paramString2, new String[] { "{ret:-3, response:" + localJSONObject.toString() + "}" });
    }
    for (;;)
    {
      return;
      localObject = this.mRuntime.a();
      if (localObject != null) {
        try
        {
          paramString1 = new JSONObject(paramString1).optString("uin");
          if (!TextUtils.isEmpty(paramString1)) {
            if (((localObject instanceof BrowserAppInterface)) || (localObject.getClass().getSimpleName().equalsIgnoreCase("ReadInJoyInterfaceProxy")))
            {
              ThreadManager.executeOnSubThread(new PublicAccountJavascriptInterfaceImpl.18(this, (AppInterface)localObject, paramString1, localJSONObject, paramString2));
              return;
            }
          }
        }
        catch (JSONException paramString1)
        {
          callJs(paramString2, new String[] { "{ret:-2, response:" + localJSONObject.toString() + "}" });
          return;
        }
      }
    }
    Object localObject = (PublicAccountDataManager)((AppInterface)localObject).getManager(QQManagerFactory.PUBLICACCOUNTDATA_MANAGER);
    if (localObject != null) {}
    for (boolean bool = ((PublicAccountDataManager)localObject).a(Long.valueOf(paramString1));; bool = false)
    {
      localJSONObject.put("follow", bool);
      callJs(paramString2, new String[] { "{ret:0, response:" + localJSONObject.toString() + "}" });
      return;
    }
  }
  
  public void officalAccountShareRichMsg2QQ(String paramString)
  {
    try
    {
      Object localObject = new JSONObject(paramString);
      String str4 = ((JSONObject)localObject).getString("oaUin");
      String str5 = ((JSONObject)localObject).getString("title");
      String str6 = ((JSONObject)localObject).getString("summary");
      String str7 = ((JSONObject)localObject).getString("targetUrl");
      paramString = "";
      if (((JSONObject)localObject).has("imageUrl")) {
        paramString = ((JSONObject)localObject).getString("imageUrl");
      }
      String str1 = "";
      if (((JSONObject)localObject).has("sourceName")) {
        str1 = ((JSONObject)localObject).getString("sourceName");
      }
      String str2 = "false";
      if (((JSONObject)localObject).has("needback")) {
        str2 = ((JSONObject)localObject).getString("needback");
      }
      String str3 = "";
      if (((JSONObject)localObject).has("callback")) {
        str3 = ((JSONObject)localObject).getString("callback");
      }
      localObject = this.mRuntime.a(this.mRuntime.a());
      if ((localObject != null) && ((localObject instanceof WebUiUtils.WebFeaturesInterface))) {
        ((WebUiUtils.WebFeaturesInterface)localObject).shareStructMsgForH5(str4, str5, str6, str7, paramString, str1, str2, str3);
      }
      ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "mp_msg_sys_30", "share_click", 0, 0, str4, "", "", "");
      return;
    }
    catch (JSONException paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d(getClass().getSimpleName(), 2, paramString.getMessage());
    }
  }
  
  public void onCreate()
  {
    super.onCreate();
    this.context = this.mRuntime.a();
    this.taskList = new ArrayList();
    if (sH5DataUsage == 0L) {
      ThreadManager.executeOnNetWorkThread(new PublicAccountJavascriptInterfaceImpl.1(this));
    }
    WebUiBaseInterface localWebUiBaseInterface = this.mRuntime.a(this.mRuntime.a());
    if ((localWebUiBaseInterface != null) && ((localWebUiBaseInterface instanceof WebUiUtils.WebUiMethodInterface))) {
      this.uiMethodInterface = ((WebUiUtils.WebUiMethodInterface)localWebUiBaseInterface);
    }
    localWebUiBaseInterface = this.mRuntime.a(this.mRuntime.a());
    if ((localWebUiBaseInterface != null) && ((localWebUiBaseInterface instanceof WebUiUtils.WebviewReportSpeedInterface))) {
      this.reportSpeedInterface = ((WebUiUtils.WebviewReportSpeedInterface)localWebUiBaseInterface);
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    Iterator localIterator = this.taskList.iterator();
    while (localIterator.hasNext())
    {
      PublicAccountJavascriptInterfaceImpl.HttpTask localHttpTask = (PublicAccountJavascriptInterfaceImpl.HttpTask)localIterator.next();
      if (!localHttpTask.isCancelled()) {
        localHttpTask.cancel(true);
      }
    }
    this.taskList.clear();
    this.taskList = null;
    if (this.isRegisteredBroadCast) {
      this.context.unregisterReceiver(this.mBroadcastReceiver);
    }
    if ((this.mDialog != null) && (this.mDialog.isShowing())) {
      this.mDialog.dismiss();
    }
    super.onDestroy();
  }
  
  public void open(String paramString)
  {
    if ("com.tencent.mobileqq.activity.ChatBubbleSettingActivity".equals(paramString))
    {
      VasWebviewUtil.openQQBrowserWithoutAD(this.context, IndividuationUrlHelper.a(this.context, "bubble", ""), 64L, null, false, -1);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.setComponent(new ComponentName(this.context, paramString));
    this.context.startActivity(localIntent);
  }
  
  public void openAccountPageMore(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PAjs", 2, "openAccountPageMore->paramStr:" + paramString);
    }
    try
    {
      paramString = ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).parseString2Json(paramString);
      if (paramString != null)
      {
        long l = paramString.getLong("puin");
        if (this.context != null)
        {
          paramString = new ActivityURIRequest(this.context, "/pubaccount/detail");
          paramString.extra().putString("uin", "" + l);
          paramString.extra().putBoolean("from_js", true);
          QRoute.startUri(paramString, null);
        }
      }
      return;
    }
    catch (JSONException paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("PAjs", 2, "openAccountPageMore->error:" + paramString);
    }
  }
  
  public void openEmoji()
  {
    AppInterface localAppInterface = this.mRuntime.a();
    if (localAppInterface == null) {
      return;
    }
    EmojiHomeUiPlugin.openEmojiHomePage(this.context, localAppInterface.getAccount(), 2);
  }
  
  public void openInExternalBrowser(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("PAjs", 2, "openInExternalBrowser:" + paramString);
    }
    if (paramString != null) {
      paramString = new Intent("android.intent.action.VIEW", Uri.parse(paramString));
    }
    try
    {
      Thread.sleep(200L);
      this.context.startActivity(paramString);
      return;
    }
    catch (Exception paramString) {}catch (ActivityNotFoundException paramString) {}
  }
  
  public void openUrl(String paramString)
  {
    Object localObject;
    Intent localIntent;
    if (paramString != null)
    {
      localObject = this.context.getIntent();
      localIntent = new Intent(this.context, this.context.getClass());
      localObject = ((Intent)localObject).getExtras();
      if (localObject != null) {
        break label80;
      }
      localObject = new Bundle();
    }
    for (;;)
    {
      localIntent.putExtras((Bundle)localObject);
      localIntent.putExtra("url", paramString);
      localIntent.setFlags(0);
      this.context.startActivityForResult(localIntent, 100);
      return;
      label80:
      ((Bundle)localObject).remove("title");
      ((Bundle)localObject).remove("leftViewText");
      ((Bundle)localObject).remove("post_data");
      ((Bundle)localObject).remove("options");
    }
  }
  
  /* Error */
  protected void readData(String paramString1, String paramString2, JSONObject paramJSONObject, String paramString3)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 181	com/tencent/biz/pubaccount/api/impl/PublicAccountJavascriptInterfaceImpl:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   4: invokevirtual 187	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/common/app/AppInterface;
    //   7: astore 6
    //   9: aload 6
    //   11: ifnonnull +4 -> 15
    //   14: return
    //   15: new 256	org/json/JSONObject
    //   18: dup
    //   19: aload_1
    //   20: invokespecial 264	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   23: astore 7
    //   25: aload 7
    //   27: ldc_w 723
    //   30: invokevirtual 726	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   33: astore 5
    //   35: aload 5
    //   37: astore_1
    //   38: aload 5
    //   40: invokestatic 669	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   43: ifne +24 -> 67
    //   46: aload 5
    //   48: ldc_w 728
    //   51: ldc_w 730
    //   54: invokevirtual 734	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   57: ldc_w 736
    //   60: ldc_w 738
    //   63: invokevirtual 734	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   66: astore_1
    //   67: aload_3
    //   68: ldc_w 723
    //   71: aload_1
    //   72: invokevirtual 294	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   75: pop
    //   76: aload 7
    //   78: ldc_w 755
    //   81: invokevirtual 726	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   84: astore 5
    //   86: aload 5
    //   88: invokestatic 669	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   91: ifeq +88 -> 179
    //   94: aload_0
    //   95: aload_2
    //   96: iconst_1
    //   97: anewarray 208	java/lang/String
    //   100: dup
    //   101: iconst_0
    //   102: new 76	java/lang/StringBuilder
    //   105: dup
    //   106: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   109: ldc_w 757
    //   112: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: aload_3
    //   116: invokevirtual 375	org/json/JSONObject:toString	()Ljava/lang/String;
    //   119: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: ldc_w 753
    //   125: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   128: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   131: aastore
    //   132: invokevirtual 613	com/tencent/biz/pubaccount/api/impl/PublicAccountJavascriptInterfaceImpl:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   135: return
    //   136: astore_1
    //   137: aload_0
    //   138: aload_2
    //   139: iconst_1
    //   140: anewarray 208	java/lang/String
    //   143: dup
    //   144: iconst_0
    //   145: new 76	java/lang/StringBuilder
    //   148: dup
    //   149: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   152: ldc_w 751
    //   155: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   158: aload_3
    //   159: invokevirtual 375	org/json/JSONObject:toString	()Ljava/lang/String;
    //   162: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   165: ldc_w 753
    //   168: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   174: aastore
    //   175: invokevirtual 613	com/tencent/biz/pubaccount/api/impl/PublicAccountJavascriptInterfaceImpl:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   178: return
    //   179: new 386	java/net/URL
    //   182: dup
    //   183: aload 4
    //   185: invokespecial 387	java/net/URL:<init>	(Ljava/lang/String;)V
    //   188: invokevirtual 768	java/net/URL:getHost	()Ljava/lang/String;
    //   191: astore_1
    //   192: aload 7
    //   194: ldc_w 770
    //   197: invokevirtual 726	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   200: astore 4
    //   202: aload 4
    //   204: invokestatic 669	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   207: ifne +675 -> 882
    //   210: aload 4
    //   212: aload_1
    //   213: invokestatic 772	com/tencent/biz/pubaccount/api/impl/PublicAccountJavascriptInterfaceImpl:isParentDomain	(Ljava/lang/String;Ljava/lang/String;)Z
    //   216: ifeq +81 -> 297
    //   219: aload 4
    //   221: astore_1
    //   222: aload_1
    //   223: astore 4
    //   225: aload_1
    //   226: invokestatic 669	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   229: ifeq +8 -> 237
    //   232: ldc_w 774
    //   235: astore 4
    //   237: aload 7
    //   239: ldc_w 759
    //   242: invokevirtual 726	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   245: astore 7
    //   247: aload 7
    //   249: invokestatic 669	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   252: ifeq +87 -> 339
    //   255: aload_0
    //   256: aload_2
    //   257: iconst_1
    //   258: anewarray 208	java/lang/String
    //   261: dup
    //   262: iconst_0
    //   263: new 76	java/lang/StringBuilder
    //   266: dup
    //   267: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   270: ldc_w 761
    //   273: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   276: aload_3
    //   277: invokevirtual 375	org/json/JSONObject:toString	()Ljava/lang/String;
    //   280: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   283: ldc_w 753
    //   286: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   289: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   292: aastore
    //   293: invokevirtual 613	com/tencent/biz/pubaccount/api/impl/PublicAccountJavascriptInterfaceImpl:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   296: return
    //   297: aload_0
    //   298: aload_2
    //   299: iconst_1
    //   300: anewarray 208	java/lang/String
    //   303: dup
    //   304: iconst_0
    //   305: new 76	java/lang/StringBuilder
    //   308: dup
    //   309: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   312: ldc_w 808
    //   315: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   318: aload_3
    //   319: invokevirtual 375	org/json/JSONObject:toString	()Ljava/lang/String;
    //   322: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   325: ldc_w 753
    //   328: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   331: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   334: aastore
    //   335: invokevirtual 613	com/tencent/biz/pubaccount/api/impl/PublicAccountJavascriptInterfaceImpl:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   338: return
    //   339: aload_0
    //   340: aload 4
    //   342: aload 5
    //   344: aload 7
    //   346: invokespecial 1553	com/tencent/biz/pubaccount/api/impl/PublicAccountJavascriptInterfaceImpl:readHash	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   349: astore_1
    //   350: aload_1
    //   351: invokestatic 669	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   354: ifeq +45 -> 399
    //   357: aload_0
    //   358: aload_2
    //   359: iconst_1
    //   360: anewarray 208	java/lang/String
    //   363: dup
    //   364: iconst_0
    //   365: new 76	java/lang/StringBuilder
    //   368: dup
    //   369: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   372: ldc_w 1555
    //   375: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   378: aload_3
    //   379: invokevirtual 375	org/json/JSONObject:toString	()Ljava/lang/String;
    //   382: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   385: ldc_w 753
    //   388: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   391: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   394: aastore
    //   395: invokevirtual 613	com/tencent/biz/pubaccount/api/impl/PublicAccountJavascriptInterfaceImpl:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   398: return
    //   399: new 447	java/io/File
    //   402: dup
    //   403: new 76	java/lang/StringBuilder
    //   406: dup
    //   407: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   410: getstatic 102	com/tencent/biz/pubaccount/api/impl/PublicAccountJavascriptInterfaceImpl:PUBACCOUNT_DATA_PATH	Ljava/lang/String;
    //   413: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   416: ldc_w 784
    //   419: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   422: aload 6
    //   424: invokevirtual 192	com/tencent/common/app/AppInterface:getAccount	()Ljava/lang/String;
    //   427: invokestatic 787	com/tencent/mobileqq/utils/HexUtil:String2HexString	(Ljava/lang/String;)Ljava/lang/String;
    //   430: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   433: ldc_w 784
    //   436: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   439: aload 4
    //   441: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   444: ldc_w 784
    //   447: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   450: aload 5
    //   452: invokestatic 787	com/tencent/mobileqq/utils/HexUtil:String2HexString	(Ljava/lang/String;)Ljava/lang/String;
    //   455: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   458: ldc_w 784
    //   461: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   464: aload 7
    //   466: invokestatic 787	com/tencent/mobileqq/utils/HexUtil:String2HexString	(Ljava/lang/String;)Ljava/lang/String;
    //   469: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   472: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   475: invokespecial 448	java/io/File:<init>	(Ljava/lang/String;)V
    //   478: astore 6
    //   480: aload 6
    //   482: invokevirtual 451	java/io/File:exists	()Z
    //   485: ifne +45 -> 530
    //   488: aload_0
    //   489: aload_2
    //   490: iconst_1
    //   491: anewarray 208	java/lang/String
    //   494: dup
    //   495: iconst_0
    //   496: new 76	java/lang/StringBuilder
    //   499: dup
    //   500: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   503: ldc_w 1555
    //   506: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   509: aload_3
    //   510: invokevirtual 375	org/json/JSONObject:toString	()Ljava/lang/String;
    //   513: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   516: ldc_w 753
    //   519: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   522: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   525: aastore
    //   526: invokevirtual 613	com/tencent/biz/pubaccount/api/impl/PublicAccountJavascriptInterfaceImpl:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   529: return
    //   530: aload_0
    //   531: monitorenter
    //   532: new 1557	java/io/FileInputStream
    //   535: dup
    //   536: aload 6
    //   538: invokespecial 1558	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   541: astore 4
    //   543: aload 4
    //   545: astore 5
    //   547: aload 6
    //   549: invokevirtual 468	java/io/File:length	()J
    //   552: l2i
    //   553: newarray byte
    //   555: astore 6
    //   557: aload 4
    //   559: astore 5
    //   561: aload 4
    //   563: aload 6
    //   565: invokevirtual 410	java/io/InputStream:read	([B)I
    //   568: pop
    //   569: aload 4
    //   571: astore 5
    //   573: aload_0
    //   574: new 208	java/lang/String
    //   577: dup
    //   578: aload 6
    //   580: invokespecial 344	java/lang/String:<init>	([B)V
    //   583: aload_1
    //   584: invokespecial 1560	com/tencent/biz/pubaccount/api/impl/PublicAccountJavascriptInterfaceImpl:decrypt	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   587: astore_1
    //   588: aload_1
    //   589: ifnonnull +71 -> 660
    //   592: aload 4
    //   594: astore 5
    //   596: aload_0
    //   597: aload_2
    //   598: iconst_1
    //   599: anewarray 208	java/lang/String
    //   602: dup
    //   603: iconst_0
    //   604: new 76	java/lang/StringBuilder
    //   607: dup
    //   608: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   611: ldc_w 1555
    //   614: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   617: aload_3
    //   618: invokevirtual 375	org/json/JSONObject:toString	()Ljava/lang/String;
    //   621: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   624: ldc_w 753
    //   627: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   630: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   633: aastore
    //   634: invokevirtual 613	com/tencent/biz/pubaccount/api/impl/PublicAccountJavascriptInterfaceImpl:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   637: aload 4
    //   639: astore 5
    //   641: aload_0
    //   642: monitorexit
    //   643: aload 4
    //   645: ifnull +240 -> 885
    //   648: aload 4
    //   650: invokevirtual 411	java/io/InputStream:close	()V
    //   653: return
    //   654: astore_1
    //   655: aload_1
    //   656: invokevirtual 428	java/io/IOException:printStackTrace	()V
    //   659: return
    //   660: aload 4
    //   662: astore 5
    //   664: aload_3
    //   665: ldc_w 763
    //   668: aload_1
    //   669: ldc_w 728
    //   672: ldc_w 730
    //   675: invokevirtual 734	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   678: ldc_w 736
    //   681: ldc_w 738
    //   684: invokevirtual 734	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   687: invokevirtual 294	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   690: pop
    //   691: aload 4
    //   693: astore 5
    //   695: aload_0
    //   696: monitorexit
    //   697: aload 4
    //   699: astore 5
    //   701: aload 4
    //   703: astore_1
    //   704: aload_0
    //   705: aload_2
    //   706: iconst_1
    //   707: anewarray 208	java/lang/String
    //   710: dup
    //   711: iconst_0
    //   712: new 76	java/lang/StringBuilder
    //   715: dup
    //   716: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   719: ldc_w 805
    //   722: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   725: aload_3
    //   726: invokevirtual 375	org/json/JSONObject:toString	()Ljava/lang/String;
    //   729: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   732: ldc_w 753
    //   735: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   738: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   741: aastore
    //   742: invokevirtual 613	com/tencent/biz/pubaccount/api/impl/PublicAccountJavascriptInterfaceImpl:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   745: aload 4
    //   747: ifnull +138 -> 885
    //   750: aload 4
    //   752: invokevirtual 411	java/io/InputStream:close	()V
    //   755: return
    //   756: astore_1
    //   757: aload_1
    //   758: invokevirtual 428	java/io/IOException:printStackTrace	()V
    //   761: return
    //   762: astore 4
    //   764: aconst_null
    //   765: astore_1
    //   766: aload_1
    //   767: astore 5
    //   769: aload_0
    //   770: monitorexit
    //   771: aload_1
    //   772: astore 5
    //   774: aload 4
    //   776: athrow
    //   777: astore_1
    //   778: aload 5
    //   780: astore_1
    //   781: aload_0
    //   782: aload_2
    //   783: iconst_1
    //   784: anewarray 208	java/lang/String
    //   787: dup
    //   788: iconst_0
    //   789: new 76	java/lang/StringBuilder
    //   792: dup
    //   793: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   796: ldc_w 810
    //   799: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   802: aload_3
    //   803: invokevirtual 375	org/json/JSONObject:toString	()Ljava/lang/String;
    //   806: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   809: ldc_w 753
    //   812: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   815: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   818: aastore
    //   819: invokevirtual 613	com/tencent/biz/pubaccount/api/impl/PublicAccountJavascriptInterfaceImpl:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   822: aload 5
    //   824: ifnull +61 -> 885
    //   827: aload 5
    //   829: invokevirtual 411	java/io/InputStream:close	()V
    //   832: return
    //   833: astore_1
    //   834: aload_1
    //   835: invokevirtual 428	java/io/IOException:printStackTrace	()V
    //   838: return
    //   839: astore 4
    //   841: aconst_null
    //   842: astore_1
    //   843: aload_1
    //   844: ifnull +7 -> 851
    //   847: aload_1
    //   848: invokevirtual 411	java/io/InputStream:close	()V
    //   851: aload 4
    //   853: athrow
    //   854: astore_1
    //   855: aload_1
    //   856: invokevirtual 428	java/io/IOException:printStackTrace	()V
    //   859: goto -8 -> 851
    //   862: astore 4
    //   864: goto -21 -> 843
    //   867: astore_1
    //   868: aconst_null
    //   869: astore 5
    //   871: goto -93 -> 778
    //   874: astore 4
    //   876: aload 5
    //   878: astore_1
    //   879: goto -113 -> 766
    //   882: goto -660 -> 222
    //   885: return
    //   886: astore_1
    //   887: aconst_null
    //   888: astore_1
    //   889: goto -697 -> 192
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	892	0	this	PublicAccountJavascriptInterfaceImpl
    //   0	892	1	paramString1	String
    //   0	892	2	paramString2	String
    //   0	892	3	paramJSONObject	JSONObject
    //   0	892	4	paramString3	String
    //   33	844	5	str	String
    //   7	572	6	localObject1	Object
    //   23	442	7	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   0	9	136	org/json/JSONException
    //   15	35	136	org/json/JSONException
    //   38	67	136	org/json/JSONException
    //   67	135	136	org/json/JSONException
    //   179	192	136	org/json/JSONException
    //   192	219	136	org/json/JSONException
    //   225	232	136	org/json/JSONException
    //   237	296	136	org/json/JSONException
    //   297	338	136	org/json/JSONException
    //   339	398	136	org/json/JSONException
    //   399	529	136	org/json/JSONException
    //   648	653	136	org/json/JSONException
    //   655	659	136	org/json/JSONException
    //   750	755	136	org/json/JSONException
    //   757	761	136	org/json/JSONException
    //   827	832	136	org/json/JSONException
    //   834	838	136	org/json/JSONException
    //   847	851	136	org/json/JSONException
    //   851	854	136	org/json/JSONException
    //   855	859	136	org/json/JSONException
    //   648	653	654	java/io/IOException
    //   750	755	756	java/io/IOException
    //   532	543	762	finally
    //   704	745	777	java/io/IOException
    //   774	777	777	java/io/IOException
    //   827	832	833	java/io/IOException
    //   530	532	839	finally
    //   847	851	854	java/io/IOException
    //   704	745	862	finally
    //   774	777	862	finally
    //   781	822	862	finally
    //   530	532	867	java/io/IOException
    //   547	557	874	finally
    //   561	569	874	finally
    //   573	588	874	finally
    //   596	637	874	finally
    //   641	643	874	finally
    //   664	691	874	finally
    //   695	697	874	finally
    //   769	771	874	finally
    //   179	192	886	java/net/MalformedURLException
  }
  
  public void readH5Data(String paramString1, String paramString2)
  {
    JSONObject localJSONObject = new JSONObject();
    if (TextUtils.isEmpty(paramString1)) {
      callJs(paramString2, new String[] { "{ret:-3, response:" + localJSONObject.toString() + "}" });
    }
    CustomWebView localCustomWebView;
    do
    {
      return;
      localCustomWebView = this.mRuntime.a();
    } while (localCustomWebView == null);
    new Thread(new PublicAccountJavascriptInterfaceImpl.17(this, paramString1, paramString2, localJSONObject, localCustomWebView.getUrl())).start();
  }
  
  public void setNavigationBarStyle(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    WebViewFragment localWebViewFragment;
    do
    {
      return;
      localWebViewFragment = (WebViewFragment)this.mRuntime.a();
    } while (localWebViewFragment == null);
    try
    {
      switch (new JSONObject(paramString).optInt("style"))
      {
      case 0: 
        localWebViewFragment.mUIStyleHandler.a(false);
        return;
      }
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
      return;
    }
    localWebViewFragment.mUIStyleHandler.a(true);
    return;
  }
  
  public void setRightButton(String paramString1, String paramString2, String paramString3)
  {
    ((AbsBaseWebViewActivity)this.context).setRightButton(paramString3, paramString1, paramString2, false, 0, 0, null, null);
  }
  
  public void setScreenshotAttr(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PAjs", 2, "setScreenshotAttr->paramStr:" + paramString);
    }
    try
    {
      SwiftBrowserScreenShotHandler localSwiftBrowserScreenShotHandler = (SwiftBrowserScreenShotHandler)super.getBrowserComponent(64);
      paramString = ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).parseString2Json(paramString);
      String str;
      if ((paramString != null) && (paramString.has("title")))
      {
        str = paramString.getString("title");
        if (localSwiftBrowserScreenShotHandler != null) {
          localSwiftBrowserScreenShotHandler.c(str);
        }
      }
      if ((paramString != null) && (paramString.has("shareUrl")))
      {
        str = paramString.getString("shareUrl");
        if (localSwiftBrowserScreenShotHandler != null) {
          localSwiftBrowserScreenShotHandler.e(str);
        }
      }
      if ((paramString != null) && (paramString.has("sinaShareTitle")))
      {
        str = paramString.getString("sinaShareTitle");
        if (localSwiftBrowserScreenShotHandler != null) {
          localSwiftBrowserScreenShotHandler.d(str);
        }
      }
      if ((paramString != null) && (paramString.has("shareActionSheetTitle")))
      {
        paramString = paramString.optJSONArray("shareActionSheetTitle");
        if (localSwiftBrowserScreenShotHandler != null) {
          localSwiftBrowserScreenShotHandler.a(paramString);
        }
      }
      return;
    }
    catch (JSONException paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("PAjs", 2, "setScreenshotAttr->error:" + paramString);
    }
  }
  
  @Deprecated
  public void showDialog(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    boolean bool1 = "true".equals(paramString3);
    boolean bool2 = "true".equals(paramString4);
    paramString3 = DialogUtil.a(this.context, 0);
    paramString3.setTitle(paramString1);
    paramString3.setMessage(paramString2);
    paramString1 = new PublicAccountJavascriptInterfaceImpl.11(this, paramString6, paramString5);
    if (bool2) {
      paramString3.setNegativeButton(HardCodeUtil.a(2131708737), paramString1);
    }
    if (bool1) {
      paramString3.setPositiveButton(HardCodeUtil.a(2131708773), paramString1);
    }
    try
    {
      paramString3.show();
      return;
    }
    catch (Exception paramString1) {}
  }
  
  public void showLoading()
  {
    Object localObject = this.mRuntime.a(this.mRuntime.a());
    if ((localObject != null) && ((localObject instanceof WebUiUtils.WebProgressInterface))) {
      ((WebUiUtils.WebProgressInterface)localObject).b();
    }
    do
    {
      return;
      localObject = (SwiftBrowserUIStyleHandler)super.getBrowserComponent(2);
    } while ((localObject == null) || (((SwiftBrowserUIStyleHandler)localObject).a == null));
    ((SwiftBrowserUIStyleHandler)localObject).a.setVisibility(0);
  }
  
  public void showProfile(String paramString)
  {
    if (excuteShowProfile(this.mRuntime.a(), this.context, paramString) == 1)
    {
      paramString = new IntentFilter();
      paramString.addAction("start_recomend_page");
      this.context.registerReceiver(this.mBroadcastReceiver, paramString);
      this.isRegisteredBroadCast = true;
    }
  }
  
  public void startMultiShare(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PAjs", 2, "startMultiShare->paramStr:" + paramString);
    }
    try
    {
      localObject = ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).parseString2Json(paramString);
      if ((localObject == null) || (!((JSONObject)localObject).has("image_url"))) {
        break label160;
      }
      paramString = ((JSONObject)localObject).getString("image_url");
    }
    catch (JSONException paramString)
    {
      Object localObject;
      boolean bool;
      while (QLog.isColorLevel())
      {
        QLog.d("PAjs", 2, "startMultiShare->error:" + paramString);
        return;
        bool = false;
        continue;
        paramString = "";
      }
    }
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    if ((localObject != null) && (((JSONObject)localObject).has("isGif")))
    {
      bool = ((JSONObject)localObject).getBoolean("isGif");
      localObject = (SwiftBrowserScreenShotHandler)super.getBrowserComponent(64);
      if (localObject == null) {
        return;
      }
      ((SwiftBrowserScreenShotHandler)localObject).a(paramString, bool);
    }
    label160:
  }
  
  public void viewAccount(String paramString)
  {
    viewAccount(paramString, "false");
  }
  
  public void viewAccount(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {}
    AppInterface localAppInterface;
    do
    {
      return;
      localAppInterface = this.mRuntime.a();
    } while (localAppInterface == null);
    Object localObject;
    if ((localAppInterface instanceof BrowserAppInterface))
    {
      localObject = ((BrowserAppInterface)localAppInterface).getEntityManagerFactory(null).createEntityManager();
      if (localObject == null) {
        break label285;
      }
      localObject = (PublicAccountInfo)((EntityManager)localObject).find(PublicAccountInfo.class, "uin = ?", new String[] { paramString1 });
    }
    for (;;)
    {
      Activity localActivity = this.context;
      if ((this.context instanceof BasePluginActivity)) {
        localActivity = ((BasePluginActivity)this.context).getOutActivity();
      }
      if ((localObject != null) && ("true".equals(paramString2)))
      {
        paramString2 = new Intent(localActivity, ChatActivity.class);
        paramString2.putExtra("uin", paramString1);
        paramString2.putExtra("uintype", 1008);
        paramString2.putExtra("uinname", ((PublicAccountInfo)localObject).name);
        localActivity.startActivity(paramString2);
      }
      for (;;)
      {
        PublicAccountHandler.a(localAppInterface, paramString1, "Pb_account_lifeservice", "mp_msg_sys_5", "addpage_hot");
        return;
        localObject = (PublicAccountDataManager)localAppInterface.getManager(QQManagerFactory.PUBLICACCOUNTDATA_MANAGER);
        if (localObject == null) {
          break label280;
        }
        localObject = ((PublicAccountDataManager)localObject).b(paramString1);
        break;
        paramString2 = new ActivityURIRequest(localActivity, "/pubaccount/detail");
        paramString2.extra().putString("uin", paramString1);
        paramString2.extra().putString("report_src_param_type", "");
        paramString2.extra().putString("report_src_param_name", "");
        paramString2.extra().putBoolean("fromBrowser", true);
        paramString2.setFlags(67108864);
        QRoute.startUri(paramString2, null);
      }
      label280:
      localObject = null;
      continue;
      label285:
      localObject = null;
    }
  }
  
  public void viewAccount(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PAjs", 2, "func viewAccount(****), sopType:" + paramString3 + ",sopName:" + paramString4);
    }
    if (TextUtils.isEmpty(paramString1)) {}
    AppInterface localAppInterface;
    do
    {
      return;
      localAppInterface = this.mRuntime.a();
    } while (localAppInterface == null);
    Object localObject;
    if ((localAppInterface instanceof BrowserAppInterface))
    {
      localObject = ((BrowserAppInterface)localAppInterface).getEntityManagerFactory(null).createEntityManager();
      if (localObject == null) {
        break label326;
      }
      localObject = (PublicAccountInfo)((EntityManager)localObject).find(PublicAccountInfo.class, "uin = ?", new String[] { paramString1 });
    }
    for (;;)
    {
      Activity localActivity = this.context;
      if (this.context.getClass().getName().equalsIgnoreCase("com.tencent.qqreadinjoy.detailspage.ReadInJoyArticleDetailActivity")) {
        localActivity = ((PluginBaseActivity)this.context).getOutActivity();
      }
      if ((localObject != null) && ("true".equals(paramString2)))
      {
        paramString2 = new Intent(localActivity, ChatActivity.class);
        paramString2.putExtra("uin", paramString1);
        paramString2.putExtra("uintype", 1008);
        paramString2.putExtra("uinname", ((PublicAccountInfo)localObject).name);
        localActivity.startActivity(paramString2);
      }
      for (;;)
      {
        PublicAccountHandler.a(localAppInterface, paramString1, "Pb_account_lifeservice", "mp_msg_sys_5", "addpage_hot");
        return;
        localObject = (PublicAccountDataManager)localAppInterface.getManager(QQManagerFactory.PUBLICACCOUNTDATA_MANAGER);
        if (localObject == null) {
          break label320;
        }
        localObject = ((PublicAccountDataManager)localObject).b(paramString1);
        break;
        paramString2 = new ActivityURIRequest(localActivity, "/pubaccount/detail");
        paramString2.extra().putString("uin", paramString1);
        paramString2.extra().putString("report_src_param_type", paramString3);
        paramString2.extra().putString("report_src_param_name", paramString4);
        QRoute.startUri(paramString2, null);
      }
      label320:
      localObject = null;
      continue;
      label326:
      localObject = null;
    }
  }
  
  public void viewTroopBarAccount(String paramString)
  {
    viewAccount(paramString);
  }
  
  protected void writeData(String paramString1, String paramString2, JSONObject paramJSONObject)
  {
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() != localLooper.getThread())
    {
      new Handler(localLooper).post(new PublicAccountJavascriptInterfaceImpl.14(this, paramString1, paramString2, paramJSONObject));
      return;
    }
    writeDataInMainThread(paramString1, paramString2, paramJSONObject);
  }
  
  public void writeH5Data(String paramString1, String paramString2)
  {
    JSONObject localJSONObject = new JSONObject();
    if (TextUtils.isEmpty(paramString1))
    {
      callJs(paramString2, new String[] { "{ret:-3, response:" + localJSONObject.toString() + "}" });
      return;
    }
    ThreadManager.post(new PublicAccountJavascriptInterfaceImpl.13(this, paramString1, paramString2, localJSONObject), 5, null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.api.impl.PublicAccountJavascriptInterfaceImpl
 * JD-Core Version:    0.7.0.1
 */