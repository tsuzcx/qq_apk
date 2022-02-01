package com.tencent.biz.pubaccount;

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
import android.os.Parcelable;
import android.text.TextUtils;
import android.widget.ProgressBar;
import anhk;
import anni;
import anrs;
import atwl;
import bcst;
import bgku;
import bglp;
import bgmj;
import bgmp;
import bgng;
import bgnt;
import bgpa;
import bgyg;
import bhgg;
import bhmn;
import bhni;
import bhod;
import bhpq;
import bhpv;
import bhql;
import bhsr;
import bhss;
import bhsx;
import bhsz;
import bkgf;
import com.tencent.biz.webviewbase.AbsBaseWebViewActivity;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.BrowserAppInterface;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.CouponH5Data;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.mobileqq.vaswebviewplugin.EmojiHomeUiPlugin;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
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
import nmj;
import nzm;
import nzn;
import nzo;
import nzp;
import nzq;
import nzr;
import nzs;
import nzt;
import nzu;
import nzv;
import nzw;
import nzx;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tzo;

public class PublicAccountJavascriptInterface
  extends bhmn
{
  private static long jdField_a_of_type_Long;
  public static final String a;
  protected static HashMap<String, String> a;
  public Activity a;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new nzo(this);
  bgpa jdField_a_of_type_Bgpa;
  private bhsx jdField_a_of_type_Bhsx;
  private bhsz jdField_a_of_type_Bhsz;
  protected List<nzx> a;
  public boolean a;
  boolean b = false;
  
  static
  {
    jdField_a_of_type_JavaLangString = bhgg.a(anhk.ba + "pubaccount/");
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  public PublicAccountJavascriptInterface()
  {
    this.jdField_a_of_type_Boolean = false;
  }
  
  private String a(String paramString1, String paramString2, String paramString3)
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
  
  /* Error */
  private String a(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: new 127	org/json/JSONObject
    //   3: dup
    //   4: invokespecial 128	org/json/JSONObject:<init>	()V
    //   7: astore 6
    //   9: new 109	java/lang/String
    //   12: dup
    //   13: aload_1
    //   14: ldc 130
    //   16: invokespecial 133	java/lang/String:<init>	([BLjava/lang/String;)V
    //   19: astore_3
    //   20: aload_3
    //   21: astore_1
    //   22: new 127	org/json/JSONObject
    //   25: dup
    //   26: aload_1
    //   27: invokespecial 136	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   30: astore_1
    //   31: aload_1
    //   32: astore 6
    //   34: new 127	org/json/JSONObject
    //   37: dup
    //   38: invokespecial 128	org/json/JSONObject:<init>	()V
    //   41: astore 8
    //   43: new 138	org/json/JSONArray
    //   46: dup
    //   47: invokespecial 139	org/json/JSONArray:<init>	()V
    //   50: astore 9
    //   52: new 138	org/json/JSONArray
    //   55: dup
    //   56: invokespecial 139	org/json/JSONArray:<init>	()V
    //   59: astore 10
    //   61: new 127	org/json/JSONObject
    //   64: dup
    //   65: invokespecial 128	org/json/JSONObject:<init>	()V
    //   68: astore 11
    //   70: new 127	org/json/JSONObject
    //   73: dup
    //   74: invokespecial 128	org/json/JSONObject:<init>	()V
    //   77: astore 12
    //   79: new 138	org/json/JSONArray
    //   82: dup
    //   83: invokespecial 139	org/json/JSONArray:<init>	()V
    //   86: astore_3
    //   87: new 138	org/json/JSONArray
    //   90: dup
    //   91: invokespecial 139	org/json/JSONArray:<init>	()V
    //   94: astore 5
    //   96: new 127	org/json/JSONObject
    //   99: dup
    //   100: invokespecial 128	org/json/JSONObject:<init>	()V
    //   103: astore 7
    //   105: new 127	org/json/JSONObject
    //   108: dup
    //   109: invokespecial 128	org/json/JSONObject:<init>	()V
    //   112: astore_1
    //   113: aload 6
    //   115: ldc 141
    //   117: invokevirtual 145	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   120: astore 4
    //   122: aload 4
    //   124: astore_1
    //   125: aload 6
    //   127: ldc 147
    //   129: invokevirtual 151	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   132: astore 4
    //   134: aload 6
    //   136: ldc 153
    //   138: invokevirtual 151	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   141: astore 5
    //   143: aload 6
    //   145: ldc 155
    //   147: invokevirtual 145	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   150: astore 6
    //   152: aload 4
    //   154: astore_3
    //   155: aload 5
    //   157: astore 4
    //   159: aload_3
    //   160: astore 5
    //   162: aload 6
    //   164: astore_3
    //   165: aload 12
    //   167: ldc 157
    //   169: aload_1
    //   170: ldc 159
    //   172: invokevirtual 162	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   175: invokevirtual 166	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   178: pop
    //   179: aload 12
    //   181: ldc 168
    //   183: aload_1
    //   184: ldc 170
    //   186: invokevirtual 162	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   189: invokevirtual 166	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   192: pop
    //   193: aload 12
    //   195: ldc 172
    //   197: aload_1
    //   198: ldc 174
    //   200: invokevirtual 162	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   203: invokevirtual 166	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   206: pop
    //   207: iconst_0
    //   208: istore_2
    //   209: iload_2
    //   210: aload 5
    //   212: invokevirtual 178	org/json/JSONArray:length	()I
    //   215: if_icmpge +156 -> 371
    //   218: new 127	org/json/JSONObject
    //   221: dup
    //   222: invokespecial 128	org/json/JSONObject:<init>	()V
    //   225: astore_1
    //   226: aload 5
    //   228: iload_2
    //   229: invokevirtual 182	org/json/JSONArray:get	(I)Ljava/lang/Object;
    //   232: checkcast 127	org/json/JSONObject
    //   235: astore 6
    //   237: aload_1
    //   238: ldc 184
    //   240: aload 6
    //   242: ldc 186
    //   244: invokevirtual 190	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   247: invokestatic 194	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   250: invokevirtual 166	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   253: pop
    //   254: aload_1
    //   255: ldc 196
    //   257: aload 6
    //   259: ldc 198
    //   261: invokevirtual 190	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   264: invokestatic 194	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   267: invokevirtual 166	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   270: pop
    //   271: aload_1
    //   272: ldc 200
    //   274: aload 6
    //   276: ldc 202
    //   278: invokevirtual 190	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   281: invokestatic 194	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   284: invokevirtual 166	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   287: pop
    //   288: aload_1
    //   289: ldc 204
    //   291: aload 6
    //   293: ldc 206
    //   295: invokevirtual 190	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   298: invokestatic 194	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   301: invokevirtual 166	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   304: pop
    //   305: aload_1
    //   306: ldc 208
    //   308: aload 6
    //   310: ldc 210
    //   312: invokevirtual 190	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   315: invokestatic 194	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   318: invokevirtual 166	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   321: pop
    //   322: aload 10
    //   324: aload_1
    //   325: invokevirtual 213	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   328: pop
    //   329: iload_2
    //   330: iconst_1
    //   331: iadd
    //   332: istore_2
    //   333: goto -124 -> 209
    //   336: astore_3
    //   337: new 109	java/lang/String
    //   340: dup
    //   341: aload_1
    //   342: invokespecial 216	java/lang/String:<init>	([B)V
    //   345: astore_1
    //   346: goto -324 -> 22
    //   349: astore_1
    //   350: goto -316 -> 34
    //   353: astore 4
    //   355: aload_3
    //   356: astore 4
    //   358: aload 5
    //   360: astore_3
    //   361: aload_3
    //   362: astore 5
    //   364: aload 7
    //   366: astore_3
    //   367: goto -202 -> 165
    //   370: astore_1
    //   371: iconst_0
    //   372: istore_2
    //   373: iload_2
    //   374: aload 4
    //   376: invokevirtual 178	org/json/JSONArray:length	()I
    //   379: if_icmpge +68 -> 447
    //   382: new 127	org/json/JSONObject
    //   385: dup
    //   386: invokespecial 128	org/json/JSONObject:<init>	()V
    //   389: astore_1
    //   390: aload 4
    //   392: iload_2
    //   393: invokevirtual 182	org/json/JSONArray:get	(I)Ljava/lang/Object;
    //   396: checkcast 127	org/json/JSONObject
    //   399: astore 5
    //   401: aload_1
    //   402: ldc 218
    //   404: aload 5
    //   406: ldc 220
    //   408: invokevirtual 162	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   411: invokevirtual 166	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   414: pop
    //   415: aload_1
    //   416: ldc 208
    //   418: aload 5
    //   420: ldc 222
    //   422: invokevirtual 190	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   425: invokestatic 194	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   428: invokevirtual 166	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   431: pop
    //   432: aload 9
    //   434: aload_1
    //   435: invokevirtual 213	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   438: pop
    //   439: iload_2
    //   440: iconst_1
    //   441: iadd
    //   442: istore_2
    //   443: goto -70 -> 373
    //   446: astore_1
    //   447: aload 11
    //   449: ldc 224
    //   451: aload_3
    //   452: ldc 226
    //   454: invokevirtual 190	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   457: invokestatic 194	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   460: invokevirtual 166	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   463: pop
    //   464: aload 11
    //   466: ldc 228
    //   468: aload_3
    //   469: ldc 230
    //   471: invokevirtual 190	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   474: invokestatic 194	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   477: invokevirtual 166	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   480: pop
    //   481: aload 11
    //   483: ldc 232
    //   485: aload_3
    //   486: ldc 234
    //   488: invokevirtual 190	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   491: invokestatic 194	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   494: invokevirtual 166	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   497: pop
    //   498: aload 11
    //   500: ldc 236
    //   502: aload_3
    //   503: ldc 238
    //   505: invokevirtual 190	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   508: invokestatic 194	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   511: invokevirtual 166	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   514: pop
    //   515: aload 8
    //   517: ldc 240
    //   519: aload 12
    //   521: invokevirtual 166	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   524: pop
    //   525: aload 8
    //   527: ldc 242
    //   529: aload 11
    //   531: invokevirtual 166	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   534: pop
    //   535: aload 8
    //   537: ldc 244
    //   539: aload 10
    //   541: invokevirtual 166	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   544: pop
    //   545: aload 8
    //   547: ldc 246
    //   549: aload 9
    //   551: invokevirtual 166	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   554: pop
    //   555: aload 8
    //   557: invokevirtual 247	org/json/JSONObject:toString	()Ljava/lang/String;
    //   560: areturn
    //   561: astore_1
    //   562: goto -7 -> 555
    //   565: astore_1
    //   566: goto -21 -> 545
    //   569: astore_1
    //   570: goto -35 -> 535
    //   573: astore_1
    //   574: goto -49 -> 525
    //   577: astore_1
    //   578: goto -63 -> 515
    //   581: astore_1
    //   582: goto -375 -> 207
    //   585: astore 4
    //   587: aload_3
    //   588: astore 4
    //   590: aload 5
    //   592: astore_3
    //   593: goto -232 -> 361
    //   596: astore 5
    //   598: aload_3
    //   599: astore 5
    //   601: aload 4
    //   603: astore_3
    //   604: aload 5
    //   606: astore 4
    //   608: goto -247 -> 361
    //   611: astore_3
    //   612: aload 4
    //   614: astore_3
    //   615: aload 5
    //   617: astore 4
    //   619: goto -258 -> 361
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	622	0	this	PublicAccountJavascriptInterface
    //   0	622	1	paramArrayOfByte	byte[]
    //   208	235	2	i	int
    //   19	146	3	localObject1	Object
    //   336	20	3	localUnsupportedEncodingException1	UnsupportedEncodingException
    //   360	244	3	localObject2	Object
    //   611	1	3	localJSONException1	JSONException
    //   614	1	3	localObject3	Object
    //   120	38	4	localObject4	Object
    //   353	1	4	localJSONException2	JSONException
    //   356	35	4	localUnsupportedEncodingException2	UnsupportedEncodingException
    //   585	1	4	localJSONException3	JSONException
    //   588	30	4	localObject5	Object
    //   94	497	5	localObject6	Object
    //   596	1	5	localJSONException4	JSONException
    //   599	17	5	localObject7	Object
    //   7	302	6	localObject8	Object
    //   103	262	7	localJSONObject1	JSONObject
    //   41	515	8	localJSONObject2	JSONObject
    //   50	500	9	localJSONArray1	JSONArray
    //   59	481	10	localJSONArray2	JSONArray
    //   68	462	11	localJSONObject3	JSONObject
    //   77	443	12	localJSONObject4	JSONObject
    // Exception table:
    //   from	to	target	type
    //   9	20	336	java/io/UnsupportedEncodingException
    //   22	31	349	org/json/JSONException
    //   113	122	353	org/json/JSONException
    //   209	329	370	org/json/JSONException
    //   373	439	446	org/json/JSONException
    //   545	555	561	org/json/JSONException
    //   535	545	565	org/json/JSONException
    //   525	535	569	org/json/JSONException
    //   515	525	573	org/json/JSONException
    //   447	515	577	org/json/JSONException
    //   165	207	581	org/json/JSONException
    //   125	134	585	org/json/JSONException
    //   134	143	596	org/json/JSONException
    //   143	152	611	org/json/JSONException
  }
  
  private void a(String paramString)
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
  
  private void a(String paramString, long paramLong)
  {
    ((AppActivity)this.jdField_a_of_type_AndroidAppActivity).requestPermissions(new nzs(this, paramString, paramLong), 1, new String[] { "android.permission.ACCESS_FINE_LOCATION" });
  }
  
  private void a(String paramString1, String paramString2)
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
  
  private void a(String paramString1, String paramString2, String paramString3)
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
  
  private void a(String paramString1, String paramString2, String paramString3, String paramString4)
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
  
  /* Error */
  private void a(URL paramURL, String paramString1, String paramString2, JSONObject paramJSONObject)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 83	com/tencent/biz/pubaccount/PublicAccountJavascriptInterface:mRuntime	Lbhod;
    //   4: invokevirtual 322	bhod:a	()Lcom/tencent/biz/pubaccount/CustomWebView;
    //   7: ifnonnull +4 -> 11
    //   10: return
    //   11: aload_0
    //   12: getfield 83	com/tencent/biz/pubaccount/PublicAccountJavascriptInterface:mRuntime	Lbhod;
    //   15: invokevirtual 88	bhod:a	()Lcom/tencent/common/app/AppInterface;
    //   18: astore 7
    //   20: aload 7
    //   22: ifnull +864 -> 886
    //   25: aload 7
    //   27: invokevirtual 93	com/tencent/common/app/AppInterface:getAccount	()Ljava/lang/String;
    //   30: ifnull +856 -> 886
    //   33: new 127	org/json/JSONObject
    //   36: dup
    //   37: aload_2
    //   38: invokespecial 136	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   41: astore 9
    //   43: aload 9
    //   45: ldc_w 324
    //   48: invokevirtual 327	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   51: astore 6
    //   53: aload 6
    //   55: astore 5
    //   57: aload 6
    //   59: invokestatic 333	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   62: ifne +25 -> 87
    //   65: aload 6
    //   67: ldc_w 335
    //   70: ldc_w 337
    //   73: invokevirtual 341	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   76: ldc_w 343
    //   79: ldc_w 345
    //   82: invokevirtual 341	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   85: astore 5
    //   87: aload 4
    //   89: ldc_w 324
    //   92: aload 5
    //   94: invokevirtual 166	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   97: pop
    //   98: getstatic 72	com/tencent/biz/pubaccount/PublicAccountJavascriptInterface:jdField_a_of_type_Long	J
    //   101: ldc2_w 346
    //   104: lcmp
    //   105: ifle +63 -> 168
    //   108: new 349	com/tencent/biz/pubaccount/PublicAccountJavascriptInterface$16
    //   111: dup
    //   112: aload_0
    //   113: aload_3
    //   114: aload 4
    //   116: aload_2
    //   117: invokespecial 352	com/tencent/biz/pubaccount/PublicAccountJavascriptInterface$16:<init>	(Lcom/tencent/biz/pubaccount/PublicAccountJavascriptInterface;Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;)V
    //   120: invokestatic 358	com/tencent/mobileqq/app/ThreadManager:executeOnNetWorkThread	(Ljava/lang/Runnable;)V
    //   123: return
    //   124: astore_1
    //   125: aload_0
    //   126: aload_3
    //   127: iconst_1
    //   128: anewarray 109	java/lang/String
    //   131: dup
    //   132: iconst_0
    //   133: new 22	java/lang/StringBuilder
    //   136: dup
    //   137: invokespecial 25	java/lang/StringBuilder:<init>	()V
    //   140: ldc_w 360
    //   143: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   146: aload 4
    //   148: invokevirtual 247	org/json/JSONObject:toString	()Ljava/lang/String;
    //   151: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   154: ldc_w 362
    //   157: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   163: aastore
    //   164: invokevirtual 366	com/tencent/biz/pubaccount/PublicAccountJavascriptInterface:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   167: return
    //   168: aload 9
    //   170: ldc_w 368
    //   173: invokevirtual 327	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   176: astore 6
    //   178: aload 6
    //   180: invokestatic 333	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   183: ifeq +46 -> 229
    //   186: aload_0
    //   187: aload_3
    //   188: iconst_1
    //   189: anewarray 109	java/lang/String
    //   192: dup
    //   193: iconst_0
    //   194: new 22	java/lang/StringBuilder
    //   197: dup
    //   198: invokespecial 25	java/lang/StringBuilder:<init>	()V
    //   201: ldc_w 370
    //   204: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   207: aload 4
    //   209: invokevirtual 247	org/json/JSONObject:toString	()Ljava/lang/String;
    //   212: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   215: ldc_w 362
    //   218: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   221: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   224: aastore
    //   225: invokevirtual 366	com/tencent/biz/pubaccount/PublicAccountJavascriptInterface:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   228: return
    //   229: aload 9
    //   231: ldc_w 372
    //   234: invokevirtual 327	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   237: astore 5
    //   239: aload 5
    //   241: invokestatic 333	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   244: ifeq +46 -> 290
    //   247: aload_0
    //   248: aload_3
    //   249: iconst_1
    //   250: anewarray 109	java/lang/String
    //   253: dup
    //   254: iconst_0
    //   255: new 22	java/lang/StringBuilder
    //   258: dup
    //   259: invokespecial 25	java/lang/StringBuilder:<init>	()V
    //   262: ldc_w 374
    //   265: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   268: aload 4
    //   270: invokevirtual 247	org/json/JSONObject:toString	()Ljava/lang/String;
    //   273: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   276: ldc_w 362
    //   279: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   282: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   285: aastore
    //   286: invokevirtual 366	com/tencent/biz/pubaccount/PublicAccountJavascriptInterface:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   289: return
    //   290: aload 9
    //   292: ldc_w 376
    //   295: invokevirtual 327	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   298: astore 8
    //   300: aload 8
    //   302: invokestatic 333	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   305: ifeq +46 -> 351
    //   308: aload_0
    //   309: aload_3
    //   310: iconst_1
    //   311: anewarray 109	java/lang/String
    //   314: dup
    //   315: iconst_0
    //   316: new 22	java/lang/StringBuilder
    //   319: dup
    //   320: invokespecial 25	java/lang/StringBuilder:<init>	()V
    //   323: ldc_w 378
    //   326: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   329: aload 4
    //   331: invokevirtual 247	org/json/JSONObject:toString	()Ljava/lang/String;
    //   334: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   337: ldc_w 362
    //   340: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   343: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   346: aastore
    //   347: invokevirtual 366	com/tencent/biz/pubaccount/PublicAccountJavascriptInterface:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   350: return
    //   351: aload_1
    //   352: invokevirtual 383	java/net/URL:getHost	()Ljava/lang/String;
    //   355: astore_1
    //   356: aload 9
    //   358: ldc_w 385
    //   361: invokevirtual 327	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   364: astore_2
    //   365: aload_2
    //   366: invokestatic 333	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   369: ifne +514 -> 883
    //   372: aload_2
    //   373: aload_1
    //   374: invokestatic 388	com/tencent/biz/pubaccount/PublicAccountJavascriptInterface:a	(Ljava/lang/String;Ljava/lang/String;)Z
    //   377: ifeq +279 -> 656
    //   380: aload_2
    //   381: astore_1
    //   382: aload_1
    //   383: astore_2
    //   384: aload_1
    //   385: invokestatic 333	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   388: ifeq +7 -> 395
    //   391: ldc_w 390
    //   394: astore_2
    //   395: aload_0
    //   396: aload 8
    //   398: invokespecial 392	com/tencent/biz/pubaccount/PublicAccountJavascriptInterface:b	(Ljava/lang/String;)Ljava/lang/String;
    //   401: astore_1
    //   402: aload_0
    //   403: aload_2
    //   404: aload 6
    //   406: aload 5
    //   408: aload_1
    //   409: invokespecial 394	com/tencent/biz/pubaccount/PublicAccountJavascriptInterface:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   412: aload_0
    //   413: aload 8
    //   415: aload_1
    //   416: invokespecial 397	com/tencent/biz/pubaccount/PublicAccountJavascriptInterface:b	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   419: astore 8
    //   421: new 399	java/io/File
    //   424: dup
    //   425: new 22	java/lang/StringBuilder
    //   428: dup
    //   429: invokespecial 25	java/lang/StringBuilder:<init>	()V
    //   432: getstatic 47	com/tencent/biz/pubaccount/PublicAccountJavascriptInterface:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   435: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   438: ldc_w 401
    //   441: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   444: aload 7
    //   446: invokevirtual 93	com/tencent/common/app/AppInterface:getAccount	()Ljava/lang/String;
    //   449: invokestatic 404	bgmj:b	(Ljava/lang/String;)Ljava/lang/String;
    //   452: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   455: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   458: invokespecial 405	java/io/File:<init>	(Ljava/lang/String;)V
    //   461: astore_1
    //   462: aload_1
    //   463: invokevirtual 408	java/io/File:exists	()Z
    //   466: ifne +233 -> 699
    //   469: aload_1
    //   470: invokevirtual 411	java/io/File:mkdirs	()Z
    //   473: pop
    //   474: new 399	java/io/File
    //   477: dup
    //   478: aload_1
    //   479: aload_2
    //   480: invokespecial 414	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   483: astore_1
    //   484: aload_1
    //   485: invokevirtual 408	java/io/File:exists	()Z
    //   488: ifne +231 -> 719
    //   491: aload_1
    //   492: invokevirtual 411	java/io/File:mkdirs	()Z
    //   495: pop
    //   496: new 399	java/io/File
    //   499: dup
    //   500: aload_1
    //   501: aload 6
    //   503: invokestatic 404	bgmj:b	(Ljava/lang/String;)Ljava/lang/String;
    //   506: invokespecial 414	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   509: astore 6
    //   511: aload 6
    //   513: invokevirtual 408	java/io/File:exists	()Z
    //   516: ifne +223 -> 739
    //   519: aload 6
    //   521: invokevirtual 411	java/io/File:mkdirs	()Z
    //   524: pop
    //   525: aconst_null
    //   526: astore_1
    //   527: aload_0
    //   528: monitorenter
    //   529: aload_1
    //   530: astore_2
    //   531: new 399	java/io/File
    //   534: dup
    //   535: aload 6
    //   537: aload 5
    //   539: invokestatic 404	bgmj:b	(Ljava/lang/String;)Ljava/lang/String;
    //   542: invokespecial 414	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   545: astore 5
    //   547: aload_1
    //   548: astore_2
    //   549: aload 5
    //   551: invokevirtual 408	java/io/File:exists	()Z
    //   554: ifeq +11 -> 565
    //   557: aload_1
    //   558: astore_2
    //   559: aload 5
    //   561: invokevirtual 417	java/io/File:delete	()Z
    //   564: pop
    //   565: aload_1
    //   566: astore_2
    //   567: new 419	java/io/FileWriter
    //   570: dup
    //   571: aload 5
    //   573: invokespecial 422	java/io/FileWriter:<init>	(Ljava/io/File;)V
    //   576: astore_1
    //   577: aload_1
    //   578: aload 8
    //   580: invokevirtual 425	java/io/FileWriter:write	(Ljava/lang/String;)V
    //   583: getstatic 72	com/tencent/biz/pubaccount/PublicAccountJavascriptInterface:jdField_a_of_type_Long	J
    //   586: aload 5
    //   588: invokevirtual 427	java/io/File:length	()J
    //   591: ladd
    //   592: putstatic 72	com/tencent/biz/pubaccount/PublicAccountJavascriptInterface:jdField_a_of_type_Long	J
    //   595: aload_0
    //   596: monitorexit
    //   597: aload_1
    //   598: astore_2
    //   599: aload_0
    //   600: aload_3
    //   601: iconst_1
    //   602: anewarray 109	java/lang/String
    //   605: dup
    //   606: iconst_0
    //   607: new 22	java/lang/StringBuilder
    //   610: dup
    //   611: invokespecial 25	java/lang/StringBuilder:<init>	()V
    //   614: ldc_w 429
    //   617: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   620: aload 4
    //   622: invokevirtual 247	org/json/JSONObject:toString	()Ljava/lang/String;
    //   625: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   628: ldc_w 362
    //   631: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   634: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   637: aastore
    //   638: invokevirtual 366	com/tencent/biz/pubaccount/PublicAccountJavascriptInterface:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   641: aload_1
    //   642: ifnull +244 -> 886
    //   645: aload_1
    //   646: invokevirtual 430	java/io/FileWriter:close	()V
    //   649: return
    //   650: astore_1
    //   651: aload_1
    //   652: invokevirtual 433	java/io/IOException:printStackTrace	()V
    //   655: return
    //   656: aload_0
    //   657: aload_3
    //   658: iconst_1
    //   659: anewarray 109	java/lang/String
    //   662: dup
    //   663: iconst_0
    //   664: new 22	java/lang/StringBuilder
    //   667: dup
    //   668: invokespecial 25	java/lang/StringBuilder:<init>	()V
    //   671: ldc_w 435
    //   674: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   677: aload 4
    //   679: invokevirtual 247	org/json/JSONObject:toString	()Ljava/lang/String;
    //   682: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   685: ldc_w 362
    //   688: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   691: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   694: aastore
    //   695: invokevirtual 366	com/tencent/biz/pubaccount/PublicAccountJavascriptInterface:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   698: return
    //   699: aload_1
    //   700: invokevirtual 438	java/io/File:isFile	()Z
    //   703: ifeq -229 -> 474
    //   706: aload_1
    //   707: invokevirtual 417	java/io/File:delete	()Z
    //   710: pop
    //   711: aload_1
    //   712: invokevirtual 411	java/io/File:mkdirs	()Z
    //   715: pop
    //   716: goto -242 -> 474
    //   719: aload_1
    //   720: invokevirtual 438	java/io/File:isFile	()Z
    //   723: ifeq -227 -> 496
    //   726: aload_1
    //   727: invokevirtual 417	java/io/File:delete	()Z
    //   730: pop
    //   731: aload_1
    //   732: invokevirtual 411	java/io/File:mkdirs	()Z
    //   735: pop
    //   736: goto -240 -> 496
    //   739: aload 6
    //   741: invokevirtual 438	java/io/File:isFile	()Z
    //   744: ifeq -219 -> 525
    //   747: aload 6
    //   749: invokevirtual 417	java/io/File:delete	()Z
    //   752: pop
    //   753: aload 6
    //   755: invokevirtual 411	java/io/File:mkdirs	()Z
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
    //   779: anewarray 109	java/lang/String
    //   782: dup
    //   783: iconst_0
    //   784: new 22	java/lang/StringBuilder
    //   787: dup
    //   788: invokespecial 25	java/lang/StringBuilder:<init>	()V
    //   791: ldc_w 440
    //   794: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   797: aload 4
    //   799: invokevirtual 247	org/json/JSONObject:toString	()Ljava/lang/String;
    //   802: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   805: ldc_w 362
    //   808: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   811: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   814: aastore
    //   815: invokevirtual 366	com/tencent/biz/pubaccount/PublicAccountJavascriptInterface:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   818: aload_1
    //   819: ifnull +67 -> 886
    //   822: aload_1
    //   823: invokevirtual 430	java/io/FileWriter:close	()V
    //   826: return
    //   827: astore_1
    //   828: aload_1
    //   829: invokevirtual 433	java/io/IOException:printStackTrace	()V
    //   832: return
    //   833: astore_1
    //   834: aconst_null
    //   835: astore_2
    //   836: aload_2
    //   837: ifnull +7 -> 844
    //   840: aload_2
    //   841: invokevirtual 430	java/io/FileWriter:close	()V
    //   844: aload_1
    //   845: athrow
    //   846: astore_2
    //   847: aload_2
    //   848: invokevirtual 433	java/io/IOException:printStackTrace	()V
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
    //   0	887	0	this	PublicAccountJavascriptInterface
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
  
  private void a(boolean paramBoolean, String paramString1, String paramString2)
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
        } while ((this.jdField_a_of_type_AndroidAppActivity == null) || (this.jdField_a_of_type_AndroidAppActivity.isFinishing()));
        if (!(this.jdField_a_of_type_AndroidAppActivity instanceof AppActivity)) {
          break label292;
        }
        if ((this.jdField_a_of_type_Bgpa != null) && (this.jdField_a_of_type_Bgpa.isShowing())) {
          this.jdField_a_of_type_Bgpa.dismiss();
        }
        str = "";
        localObject = this.mRuntime.a();
        if (localObject != null) {
          str = ((AppInterface)localObject).getAccount();
        }
        localObject = "";
        if (this.mRuntime.a() != null) {
          localObject = nmj.b(this.mRuntime.a().getUrl());
        }
        if (!getLocationPermissionGrant(str, (String)localObject)) {
          break;
        }
        b(paramBoolean, paramString1, paramString2);
      } while (!QLog.isColorLevel());
      QLog.d("PAjs", 2, "already grant");
      return;
      if (!this.jdField_a_of_type_Boolean) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("PAjs", 2, "already ask");
    return;
    this.jdField_a_of_type_Bgpa = bglp.a(this.jdField_a_of_type_AndroidAppActivity, 0);
    this.jdField_a_of_type_Bgpa.setMessage(this.jdField_a_of_type_AndroidAppActivity.getString(2131719133, new Object[] { localObject }));
    this.jdField_a_of_type_Bgpa.setPositiveButton(2131719152, new nzt(this, paramBoolean, paramString1, paramString2, str, (String)localObject));
    this.jdField_a_of_type_Bgpa.setNegativeButton(this.jdField_a_of_type_AndroidAppActivity.getString(2131719163), new nzu(this, paramString2));
    this.jdField_a_of_type_Bgpa.setOnCancelListener(new nzv(this, paramString2));
    this.jdField_a_of_type_Bgpa.show();
    return;
    label292:
    callJs(paramString2, new String[] { "-4", "{}" });
  }
  
  private static boolean a(String paramString1, String paramString2)
  {
    if (paramString2 == null) {}
    while ((!paramString2.equals(paramString1)) && ((paramString1.indexOf(".") <= 0) || (!paramString2.endsWith("." + paramString1)))) {
      return false;
    }
    return true;
  }
  
  private String b(String paramString)
  {
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      localMessageDigest.update(paramString.getBytes("UTF-8"));
      paramString = bgmj.a(localMessageDigest.digest());
      localMessageDigest.reset();
      return paramString;
    }
    catch (UnsupportedEncodingException paramString)
    {
      return "wronghash";
    }
    catch (NoSuchAlgorithmException paramString)
    {
      label32:
      break label32;
    }
  }
  
  private String b(String paramString1, String paramString2)
  {
    return bkgf.a(paramString1, paramString2);
  }
  
  private void b(String paramString1, String paramString2, JSONObject paramJSONObject)
  {
    CustomWebView localCustomWebView = this.mRuntime.a();
    if (localCustomWebView == null) {
      return;
    }
    try
    {
      ThreadManager.post(new PublicAccountJavascriptInterface.15(this, new URL(localCustomWebView.getUrl()), paramString1, paramString2, paramJSONObject), 5, null, false);
      return;
    }
    catch (MalformedURLException paramString1) {}
  }
  
  private void b(boolean paramBoolean, String paramString1, String paramString2)
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
    ((AppActivity)this.jdField_a_of_type_AndroidAppActivity).requestPermissions(new nzm(this, paramBoolean, i, bool1, paramString2, l1), 1, new String[] { "android.permission.ACCESS_FINE_LOCATION" });
  }
  
  private static long c()
  {
    Object localObject = new File(jdField_a_of_type_JavaLangString);
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
  
  private static String c(String paramString)
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
          return paramString + bgku.encodeToString(arrayOfByte, 2);
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
  
  private String c(String paramString1, String paramString2)
  {
    return bkgf.b(paramString1, paramString2);
  }
  
  public static void deleteAllH5Data(AppInterface paramAppInterface)
  {
    EntityManager localEntityManager = paramAppInterface.getEntityManagerFactory(paramAppInterface.getAccount()).createEntityManager();
    Object localObject1 = localEntityManager.query(CouponH5Data.class);
    if (localObject1 != null)
    {
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (CouponH5Data)((Iterator)localObject1).next();
        localObject2 = new File(jdField_a_of_type_JavaLangString + "/" + bgmj.b(paramAppInterface.getAccount()) + "/" + ((CouponH5Data)localObject2).mHost);
        if (((File)localObject2).exists()) {
          atwl.a((File)localObject2);
        }
      }
    }
    localEntityManager.drop(CouponH5Data.class);
    localEntityManager.close();
  }
  
  public static boolean getLocationPermissionGrant(String paramString1, String paramString2)
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
  
  public static void setLocationPermissionGrant(String paramString1, String paramString2, int paramInt)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      QLog.e("PAjs", 1, new Object[] { "uin:", paramString1, " host:", paramString2 });
      return;
    }
    BaseApplicationImpl.getApplication().getSharedPreferences(paramString1 + "LocationPermissionPref", 0).edit().putInt(paramString2 + "-location", paramInt).commit();
  }
  
  /* Error */
  public String a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 83	com/tencent/biz/pubaccount/PublicAccountJavascriptInterface:mRuntime	Lbhod;
    //   4: invokevirtual 88	bhod:a	()Lcom/tencent/common/app/AppInterface;
    //   7: astore 6
    //   9: aload 6
    //   11: ifnonnull +7 -> 18
    //   14: ldc_w 457
    //   17: areturn
    //   18: ldc_w 760
    //   21: astore 4
    //   23: new 127	org/json/JSONObject
    //   26: dup
    //   27: aload_2
    //   28: invokespecial 136	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   31: astore 5
    //   33: aload 5
    //   35: astore_3
    //   36: invokestatic 473	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   39: ifeq +33 -> 72
    //   42: ldc_w 475
    //   45: iconst_2
    //   46: new 22	java/lang/StringBuilder
    //   49: dup
    //   50: invokespecial 25	java/lang/StringBuilder:<init>	()V
    //   53: ldc_w 762
    //   56: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: aload_2
    //   60: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   66: invokestatic 765	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   69: aload 5
    //   71: astore_3
    //   72: new 767	android/os/Bundle
    //   75: dup
    //   76: invokespecial 768	android/os/Bundle:<init>	()V
    //   79: astore 5
    //   81: aload 5
    //   83: ldc_w 770
    //   86: ldc_w 772
    //   89: invokevirtual 775	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   92: aload 4
    //   94: astore_2
    //   95: aload_3
    //   96: ifnull +33 -> 129
    //   99: aload 4
    //   101: astore_2
    //   102: aload_3
    //   103: ldc_w 777
    //   106: invokevirtual 780	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   109: ifeq +20 -> 129
    //   112: aload_3
    //   113: ldc_w 777
    //   116: invokevirtual 162	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   119: astore_2
    //   120: aload_2
    //   121: invokevirtual 783	java/lang/String:toUpperCase	()Ljava/lang/String;
    //   124: astore 4
    //   126: aload 4
    //   128: astore_2
    //   129: aload_3
    //   130: ifnull +70 -> 200
    //   133: aload_3
    //   134: ldc_w 785
    //   137: invokevirtual 780	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   140: ifeq +60 -> 200
    //   143: aload_3
    //   144: ldc_w 785
    //   147: invokevirtual 145	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   150: astore_3
    //   151: aload_3
    //   152: invokevirtual 788	org/json/JSONObject:keys	()Ljava/util/Iterator;
    //   155: astore 4
    //   157: aload 4
    //   159: invokeinterface 281 1 0
    //   164: ifeq +36 -> 200
    //   167: aload 4
    //   169: invokeinterface 285 1 0
    //   174: invokevirtual 789	java/lang/Object:toString	()Ljava/lang/String;
    //   177: astore 7
    //   179: aload 5
    //   181: aload 7
    //   183: aload_3
    //   184: aload 7
    //   186: invokevirtual 162	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   189: invokevirtual 775	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   192: goto -35 -> 157
    //   195: astore_3
    //   196: aload_3
    //   197: invokevirtual 790	org/json/JSONException:printStackTrace	()V
    //   200: aload 6
    //   202: invokevirtual 93	com/tencent/common/app/AppInterface:getAccount	()Ljava/lang/String;
    //   205: astore_3
    //   206: new 22	java/lang/StringBuilder
    //   209: dup
    //   210: invokespecial 25	java/lang/StringBuilder:<init>	()V
    //   213: ldc_w 792
    //   216: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   219: aload_3
    //   220: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   223: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   226: astore_3
    //   227: new 767	android/os/Bundle
    //   230: dup
    //   231: invokespecial 768	android/os/Bundle:<init>	()V
    //   234: astore 4
    //   236: aload 4
    //   238: ldc_w 794
    //   241: aload_3
    //   242: invokevirtual 775	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   245: aload_0
    //   246: getfield 291	com/tencent/biz/pubaccount/PublicAccountJavascriptInterface:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   249: invokevirtual 798	android/app/Activity:getApplicationContext	()Landroid/content/Context;
    //   252: aload_1
    //   253: aload_2
    //   254: aload 5
    //   256: aload 4
    //   258: invokestatic 803	nlw:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;Landroid/os/Bundle;)Ljava/lang/String;
    //   261: astore_1
    //   262: aload_1
    //   263: areturn
    //   264: astore 4
    //   266: ldc_w 760
    //   269: astore_2
    //   270: aload 4
    //   272: invokevirtual 790	org/json/JSONException:printStackTrace	()V
    //   275: goto -146 -> 129
    //   278: astore_1
    //   279: aload_1
    //   280: invokevirtual 804	org/apache/http/client/ClientProtocolException:printStackTrace	()V
    //   283: ldc_w 806
    //   286: areturn
    //   287: astore_1
    //   288: aload_1
    //   289: invokevirtual 433	java/io/IOException:printStackTrace	()V
    //   292: ldc_w 808
    //   295: areturn
    //   296: astore 4
    //   298: goto -28 -> 270
    //   301: astore_2
    //   302: aconst_null
    //   303: astore_3
    //   304: goto -232 -> 72
    //   307: astore_2
    //   308: aload 5
    //   310: astore_3
    //   311: goto -239 -> 72
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	314	0	this	PublicAccountJavascriptInterface
    //   0	314	1	paramString1	String
    //   0	314	2	paramString2	String
    //   35	149	3	localObject1	Object
    //   195	2	3	localJSONException1	JSONException
    //   205	106	3	localObject2	Object
    //   21	236	4	localObject3	Object
    //   264	7	4	localJSONException2	JSONException
    //   296	1	4	localJSONException3	JSONException
    //   31	278	5	localObject4	Object
    //   7	194	6	localAppInterface	AppInterface
    //   177	8	7	str	String
    // Exception table:
    //   from	to	target	type
    //   133	157	195	org/json/JSONException
    //   157	192	195	org/json/JSONException
    //   102	120	264	org/json/JSONException
    //   245	262	278	org/apache/http/client/ClientProtocolException
    //   245	262	287	java/io/IOException
    //   120	126	296	org/json/JSONException
    //   23	33	301	org/json/JSONException
    //   36	69	307	org/json/JSONException
  }
  
  protected void a(String paramString1, String paramString2, JSONObject paramJSONObject)
  {
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() != localLooper.getThread())
    {
      new Handler(localLooper).post(new PublicAccountJavascriptInterface.14(this, paramString1, paramString2, paramJSONObject));
      return;
    }
    b(paramString1, paramString2, paramJSONObject);
  }
  
  /* Error */
  protected void a(String paramString1, String paramString2, JSONObject paramJSONObject, String paramString3)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 83	com/tencent/biz/pubaccount/PublicAccountJavascriptInterface:mRuntime	Lbhod;
    //   4: invokevirtual 88	bhod:a	()Lcom/tencent/common/app/AppInterface;
    //   7: astore 6
    //   9: aload 6
    //   11: ifnonnull +4 -> 15
    //   14: return
    //   15: new 127	org/json/JSONObject
    //   18: dup
    //   19: aload_1
    //   20: invokespecial 136	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   23: astore 7
    //   25: aload 7
    //   27: ldc_w 324
    //   30: invokevirtual 327	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   33: astore 5
    //   35: aload 5
    //   37: astore_1
    //   38: aload 5
    //   40: invokestatic 333	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   43: ifne +24 -> 67
    //   46: aload 5
    //   48: ldc_w 335
    //   51: ldc_w 337
    //   54: invokevirtual 341	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   57: ldc_w 343
    //   60: ldc_w 345
    //   63: invokevirtual 341	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   66: astore_1
    //   67: aload_3
    //   68: ldc_w 324
    //   71: aload_1
    //   72: invokevirtual 166	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   75: pop
    //   76: aload 7
    //   78: ldc_w 368
    //   81: invokevirtual 327	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   84: astore 5
    //   86: aload 5
    //   88: invokestatic 333	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   91: ifeq +88 -> 179
    //   94: aload_0
    //   95: aload_2
    //   96: iconst_1
    //   97: anewarray 109	java/lang/String
    //   100: dup
    //   101: iconst_0
    //   102: new 22	java/lang/StringBuilder
    //   105: dup
    //   106: invokespecial 25	java/lang/StringBuilder:<init>	()V
    //   109: ldc_w 370
    //   112: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: aload_3
    //   116: invokevirtual 247	org/json/JSONObject:toString	()Ljava/lang/String;
    //   119: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: ldc_w 362
    //   125: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   128: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   131: aastore
    //   132: invokevirtual 366	com/tencent/biz/pubaccount/PublicAccountJavascriptInterface:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   135: return
    //   136: astore_1
    //   137: aload_0
    //   138: aload_2
    //   139: iconst_1
    //   140: anewarray 109	java/lang/String
    //   143: dup
    //   144: iconst_0
    //   145: new 22	java/lang/StringBuilder
    //   148: dup
    //   149: invokespecial 25	java/lang/StringBuilder:<init>	()V
    //   152: ldc_w 360
    //   155: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   158: aload_3
    //   159: invokevirtual 247	org/json/JSONObject:toString	()Ljava/lang/String;
    //   162: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   165: ldc_w 362
    //   168: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   174: aastore
    //   175: invokevirtual 366	com/tencent/biz/pubaccount/PublicAccountJavascriptInterface:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   178: return
    //   179: new 380	java/net/URL
    //   182: dup
    //   183: aload 4
    //   185: invokespecial 585	java/net/URL:<init>	(Ljava/lang/String;)V
    //   188: invokevirtual 383	java/net/URL:getHost	()Ljava/lang/String;
    //   191: astore_1
    //   192: aload 7
    //   194: ldc_w 385
    //   197: invokevirtual 327	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   200: astore 4
    //   202: aload 4
    //   204: invokestatic 333	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   207: ifne +675 -> 882
    //   210: aload 4
    //   212: aload_1
    //   213: invokestatic 388	com/tencent/biz/pubaccount/PublicAccountJavascriptInterface:a	(Ljava/lang/String;Ljava/lang/String;)Z
    //   216: ifeq +81 -> 297
    //   219: aload 4
    //   221: astore_1
    //   222: aload_1
    //   223: astore 4
    //   225: aload_1
    //   226: invokestatic 333	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   229: ifeq +8 -> 237
    //   232: ldc_w 390
    //   235: astore 4
    //   237: aload 7
    //   239: ldc_w 372
    //   242: invokevirtual 327	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   245: astore 7
    //   247: aload 7
    //   249: invokestatic 333	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   252: ifeq +87 -> 339
    //   255: aload_0
    //   256: aload_2
    //   257: iconst_1
    //   258: anewarray 109	java/lang/String
    //   261: dup
    //   262: iconst_0
    //   263: new 22	java/lang/StringBuilder
    //   266: dup
    //   267: invokespecial 25	java/lang/StringBuilder:<init>	()V
    //   270: ldc_w 374
    //   273: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   276: aload_3
    //   277: invokevirtual 247	org/json/JSONObject:toString	()Ljava/lang/String;
    //   280: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   283: ldc_w 362
    //   286: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   289: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   292: aastore
    //   293: invokevirtual 366	com/tencent/biz/pubaccount/PublicAccountJavascriptInterface:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   296: return
    //   297: aload_0
    //   298: aload_2
    //   299: iconst_1
    //   300: anewarray 109	java/lang/String
    //   303: dup
    //   304: iconst_0
    //   305: new 22	java/lang/StringBuilder
    //   308: dup
    //   309: invokespecial 25	java/lang/StringBuilder:<init>	()V
    //   312: ldc_w 435
    //   315: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   318: aload_3
    //   319: invokevirtual 247	org/json/JSONObject:toString	()Ljava/lang/String;
    //   322: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   325: ldc_w 362
    //   328: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   331: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   334: aastore
    //   335: invokevirtual 366	com/tencent/biz/pubaccount/PublicAccountJavascriptInterface:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   338: return
    //   339: aload_0
    //   340: aload 4
    //   342: aload 5
    //   344: aload 7
    //   346: invokespecial 838	com/tencent/biz/pubaccount/PublicAccountJavascriptInterface:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   349: astore_1
    //   350: aload_1
    //   351: invokestatic 333	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   354: ifeq +45 -> 399
    //   357: aload_0
    //   358: aload_2
    //   359: iconst_1
    //   360: anewarray 109	java/lang/String
    //   363: dup
    //   364: iconst_0
    //   365: new 22	java/lang/StringBuilder
    //   368: dup
    //   369: invokespecial 25	java/lang/StringBuilder:<init>	()V
    //   372: ldc_w 840
    //   375: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   378: aload_3
    //   379: invokevirtual 247	org/json/JSONObject:toString	()Ljava/lang/String;
    //   382: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   385: ldc_w 362
    //   388: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   391: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   394: aastore
    //   395: invokevirtual 366	com/tencent/biz/pubaccount/PublicAccountJavascriptInterface:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   398: return
    //   399: new 399	java/io/File
    //   402: dup
    //   403: new 22	java/lang/StringBuilder
    //   406: dup
    //   407: invokespecial 25	java/lang/StringBuilder:<init>	()V
    //   410: getstatic 47	com/tencent/biz/pubaccount/PublicAccountJavascriptInterface:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   413: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   416: ldc_w 401
    //   419: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   422: aload 6
    //   424: invokevirtual 93	com/tencent/common/app/AppInterface:getAccount	()Ljava/lang/String;
    //   427: invokestatic 404	bgmj:b	(Ljava/lang/String;)Ljava/lang/String;
    //   430: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   433: ldc_w 401
    //   436: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   439: aload 4
    //   441: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   444: ldc_w 401
    //   447: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   450: aload 5
    //   452: invokestatic 404	bgmj:b	(Ljava/lang/String;)Ljava/lang/String;
    //   455: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   458: ldc_w 401
    //   461: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   464: aload 7
    //   466: invokestatic 404	bgmj:b	(Ljava/lang/String;)Ljava/lang/String;
    //   469: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   472: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   475: invokespecial 405	java/io/File:<init>	(Ljava/lang/String;)V
    //   478: astore 6
    //   480: aload 6
    //   482: invokevirtual 408	java/io/File:exists	()Z
    //   485: ifne +45 -> 530
    //   488: aload_0
    //   489: aload_2
    //   490: iconst_1
    //   491: anewarray 109	java/lang/String
    //   494: dup
    //   495: iconst_0
    //   496: new 22	java/lang/StringBuilder
    //   499: dup
    //   500: invokespecial 25	java/lang/StringBuilder:<init>	()V
    //   503: ldc_w 840
    //   506: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   509: aload_3
    //   510: invokevirtual 247	org/json/JSONObject:toString	()Ljava/lang/String;
    //   513: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   516: ldc_w 362
    //   519: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   522: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   525: aastore
    //   526: invokevirtual 366	com/tencent/biz/pubaccount/PublicAccountJavascriptInterface:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   529: return
    //   530: aload_0
    //   531: monitorenter
    //   532: new 842	java/io/FileInputStream
    //   535: dup
    //   536: aload 6
    //   538: invokespecial 843	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   541: astore 4
    //   543: aload 4
    //   545: astore 5
    //   547: aload 6
    //   549: invokevirtual 427	java/io/File:length	()J
    //   552: l2i
    //   553: newarray byte
    //   555: astore 6
    //   557: aload 4
    //   559: astore 5
    //   561: aload 4
    //   563: aload 6
    //   565: invokevirtual 660	java/io/InputStream:read	([B)I
    //   568: pop
    //   569: aload 4
    //   571: astore 5
    //   573: aload_0
    //   574: new 109	java/lang/String
    //   577: dup
    //   578: aload 6
    //   580: invokespecial 216	java/lang/String:<init>	([B)V
    //   583: aload_1
    //   584: invokespecial 845	com/tencent/biz/pubaccount/PublicAccountJavascriptInterface:c	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   587: astore_1
    //   588: aload_1
    //   589: ifnonnull +71 -> 660
    //   592: aload 4
    //   594: astore 5
    //   596: aload_0
    //   597: aload_2
    //   598: iconst_1
    //   599: anewarray 109	java/lang/String
    //   602: dup
    //   603: iconst_0
    //   604: new 22	java/lang/StringBuilder
    //   607: dup
    //   608: invokespecial 25	java/lang/StringBuilder:<init>	()V
    //   611: ldc_w 840
    //   614: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   617: aload_3
    //   618: invokevirtual 247	org/json/JSONObject:toString	()Ljava/lang/String;
    //   621: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   624: ldc_w 362
    //   627: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   630: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   633: aastore
    //   634: invokevirtual 366	com/tencent/biz/pubaccount/PublicAccountJavascriptInterface:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   637: aload 4
    //   639: astore 5
    //   641: aload_0
    //   642: monitorexit
    //   643: aload 4
    //   645: ifnull +240 -> 885
    //   648: aload 4
    //   650: invokevirtual 661	java/io/InputStream:close	()V
    //   653: return
    //   654: astore_1
    //   655: aload_1
    //   656: invokevirtual 433	java/io/IOException:printStackTrace	()V
    //   659: return
    //   660: aload 4
    //   662: astore 5
    //   664: aload_3
    //   665: ldc_w 376
    //   668: aload_1
    //   669: ldc_w 335
    //   672: ldc_w 337
    //   675: invokevirtual 341	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   678: ldc_w 343
    //   681: ldc_w 345
    //   684: invokevirtual 341	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   687: invokevirtual 166	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
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
    //   707: anewarray 109	java/lang/String
    //   710: dup
    //   711: iconst_0
    //   712: new 22	java/lang/StringBuilder
    //   715: dup
    //   716: invokespecial 25	java/lang/StringBuilder:<init>	()V
    //   719: ldc_w 429
    //   722: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   725: aload_3
    //   726: invokevirtual 247	org/json/JSONObject:toString	()Ljava/lang/String;
    //   729: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   732: ldc_w 362
    //   735: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   738: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   741: aastore
    //   742: invokevirtual 366	com/tencent/biz/pubaccount/PublicAccountJavascriptInterface:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   745: aload 4
    //   747: ifnull +138 -> 885
    //   750: aload 4
    //   752: invokevirtual 661	java/io/InputStream:close	()V
    //   755: return
    //   756: astore_1
    //   757: aload_1
    //   758: invokevirtual 433	java/io/IOException:printStackTrace	()V
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
    //   784: anewarray 109	java/lang/String
    //   787: dup
    //   788: iconst_0
    //   789: new 22	java/lang/StringBuilder
    //   792: dup
    //   793: invokespecial 25	java/lang/StringBuilder:<init>	()V
    //   796: ldc_w 440
    //   799: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   802: aload_3
    //   803: invokevirtual 247	org/json/JSONObject:toString	()Ljava/lang/String;
    //   806: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   809: ldc_w 362
    //   812: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   815: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   818: aastore
    //   819: invokevirtual 366	com/tencent/biz/pubaccount/PublicAccountJavascriptInterface:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   822: aload 5
    //   824: ifnull +61 -> 885
    //   827: aload 5
    //   829: invokevirtual 661	java/io/InputStream:close	()V
    //   832: return
    //   833: astore_1
    //   834: aload_1
    //   835: invokevirtual 433	java/io/IOException:printStackTrace	()V
    //   838: return
    //   839: astore 4
    //   841: aconst_null
    //   842: astore_1
    //   843: aload_1
    //   844: ifnull +7 -> 851
    //   847: aload_1
    //   848: invokevirtual 661	java/io/InputStream:close	()V
    //   851: aload 4
    //   853: athrow
    //   854: astore_1
    //   855: aload_1
    //   856: invokevirtual 433	java/io/IOException:printStackTrace	()V
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
    //   0	892	0	this	PublicAccountJavascriptInterface
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
  
  public void actionSheetAdditionalItems(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PAjs", 2, "actionSheetAdditionalItems->paramStr:" + paramString);
    }
    try
    {
      Object localObject = tzo.a(paramString);
      if (localObject != null)
      {
        paramString = (bhpv)super.getBrowserComponent(4);
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
              nzw localnzw = new nzw();
              localnzw.jdField_a_of_type_Int = localJSONObject.optInt("itemType");
              localnzw.jdField_a_of_type_JavaLangString = localJSONObject.optString("itemName");
              localnzw.b = localJSONObject.optString("itemActionData");
              localArrayList.add(localnzw);
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
    this.jdField_a_of_type_AndroidAppActivity.finish();
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
      if (a(str1, paramString1))
      {
        paramString1 = str1;
        str1 = paramString1;
        if (TextUtils.isEmpty(paramString1)) {
          str1 = "defaulthost";
        }
        if (!TextUtils.isEmpty(str3)) {
          break label489;
        }
        a(str1, str2);
        atwl.a(new File(jdField_a_of_type_JavaLangString + "/" + bgmj.b(localAppInterface.getAccount()) + "/" + str1 + "/" + bgmj.b(str2)));
      }
      for (;;)
      {
        callJs(paramString2, new String[] { "{ret:0, response:" + localJSONObject1.toString() + "}" });
        return;
        callJs(paramString2, new String[] { "{ret:-5, response:" + localJSONObject1.toString() + "}" });
        return;
        label489:
        a(str1, str2, str3);
        atwl.a(new File(jdField_a_of_type_JavaLangString + "/" + bgmj.b(localAppInterface.getAccount()) + "/" + str1 + "/" + bgmj.b(str2) + "/" + bgmj.b(str3)));
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
      if (a(str, paramString1))
      {
        paramString1 = str;
        str = paramString1;
        if (TextUtils.isEmpty(paramString1)) {
          str = "defaulthost";
        }
        a(str);
        atwl.a(new File(jdField_a_of_type_JavaLangString + "/" + bgmj.b(localAppInterface.getAccount()) + "/" + str));
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
      Object localObject = tzo.a(paramString);
      if (localObject != null)
      {
        paramString = (bhpv)super.getBrowserComponent(4);
        if (((JSONObject)localObject).has("enable"))
        {
          localObject = ((JSONObject)localObject).getString("enable");
          if (paramString != null)
          {
            if ("1".equals(localObject))
            {
              paramString.d(true);
              return;
            }
            paramString.d(false);
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
    bhpq localbhpq = (bhpq)super.getBrowserComponent(64);
    if (localbhpq != null)
    {
      if ("1".equals(paramString)) {
        localbhpq.b("");
      }
    }
    else {
      return;
    }
    localbhpq.a();
  }
  
  public void enableShareDianDian(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PAjs", 2, "enable share dian dian->paramStr:" + paramString);
    }
    try
    {
      Object localObject = tzo.a(paramString);
      if (localObject != null)
      {
        paramString = (bhpv)super.getBrowserComponent(4);
        if (((JSONObject)localObject).has("enable"))
        {
          String str = ((JSONObject)localObject).getString("enable");
          if (paramString != null)
          {
            if (!"1".equals(str)) {
              break label126;
            }
            paramString.b(true);
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
          paramString.c(true);
          return;
          label126:
          paramString.b(false);
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
        paramString.c(false);
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
      paramString = tzo.a(paramString);
      if ((paramString != null) && (paramString.has("enable")))
      {
        paramString = paramString.getString("enable");
        bhpv localbhpv = (bhpv)super.getBrowserComponent(4);
        if (localbhpv != null)
        {
          if ("1".equals(paramString))
          {
            localbhpv.a(true);
            return;
          }
          localbhpv.a(false);
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
  
  public void getJson(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    callJs("clientCallback", new String[] { nmj.a("{'r': -102, 'msg': 'no such method'}"), nmj.a(paramString4) });
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
    label331:
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            if ((this.jdField_a_of_type_AndroidAppActivity != null) && (!this.jdField_a_of_type_AndroidAppActivity.isFinishing())) {
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
              if ((!bool) || (TextUtils.isEmpty((CharSequence)localObject1))) {
                break label331;
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
            localObject2 = nmj.a(this.mRuntime.a().getUrl(), 2);
          }
        } while (TextUtils.isEmpty(paramString));
        if (!(this.jdField_a_of_type_AndroidAppActivity instanceof AppActivity)) {
          break label577;
        }
        if ((this.jdField_a_of_type_Bgpa != null) && (this.jdField_a_of_type_Bgpa.isShowing())) {
          this.jdField_a_of_type_Bgpa.dismiss();
        }
        if (!getLocationPermissionGrant((String)localObject1, (String)localObject2)) {
          break;
        }
        a(paramString, l);
      } while (!QLog.isColorLevel());
      QLog.d("PAjs", 2, "already grant");
      return;
      if (!this.jdField_a_of_type_Boolean) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("PAjs", 2, "already ask");
    return;
    this.jdField_a_of_type_Bgpa = bglp.a(this.jdField_a_of_type_AndroidAppActivity, 0);
    this.jdField_a_of_type_Bgpa.setMessage(this.jdField_a_of_type_AndroidAppActivity.getString(2131719133, new Object[] { localObject2 }));
    this.jdField_a_of_type_Bgpa.setPositiveButton(2131719152, new nzp(this, paramString, l, (String)localObject1, (String)localObject2));
    this.jdField_a_of_type_Bgpa.setNegativeButton(this.jdField_a_of_type_AndroidAppActivity.getString(2131719163), new nzq(this, paramString));
    this.jdField_a_of_type_Bgpa.setOnCancelListener(new nzr(this, paramString));
    this.jdField_a_of_type_Bgpa.show();
    return;
    label577:
    callJs(paramString, new String[] { "-4", "{}" });
  }
  
  public String getNameSpace()
  {
    return "publicAccount";
  }
  
  public int getNetworkState()
  {
    return bgnt.b(BaseApplication.getContext());
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
    if (this.jdField_a_of_type_Bhsx != null)
    {
      if (!TextUtils.isEmpty(this.jdField_a_of_type_Bhsx.getCurrentUrl())) {}
      for (String str = this.jdField_a_of_type_Bhsx.getCurrentUrl();; str = "")
      {
        if (this.jdField_a_of_type_Bhsz != null) {
          callJs(paramString, new String[] { "{ret:0, onCreateTime:" + this.jdField_a_of_type_Bhsz.getmOnCreateMilliTimeStamp() + ", startLoadUrlTime:" + this.jdField_a_of_type_Bhsz.getmStartLoadUrlMilliTimeStamp() + ", url:'" + str + "'}" });
        }
        return;
      }
    }
    callJs(paramString, new String[] { "{ret: -1}" });
  }
  
  public void getRealLocation(String paramString1, String paramString2)
  {
    a(false, paramString1, paramString2);
  }
  
  public void getRealLocationDes(String paramString1, String paramString2)
  {
    a(true, paramString1, paramString2);
  }
  
  public void getUrlImage(String paramString1, String paramString2)
  {
    JSONObject localJSONObject = new JSONObject();
    if (!TextUtils.isEmpty(paramString1))
    {
      new PublicAccountJavascriptInterface.12(this, paramString1, localJSONObject, paramString2).start();
      return;
    }
    callJs(paramString2, new String[] { "{ret:-3, response:" + localJSONObject.toString() + "}" });
  }
  
  public void hideLoading()
  {
    Object localObject = this.mRuntime.a(this.mRuntime.a());
    if ((localObject != null) && ((localObject instanceof bhss))) {
      ((bhss)localObject).a();
    }
    do
    {
      return;
      localObject = (bhql)super.getBrowserComponent(2);
    } while ((localObject == null) || (((bhql)localObject).a == null));
    ((bhql)localObject).a.setVisibility(8);
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
              ThreadManager.executeOnSubThread(new PublicAccountJavascriptInterface.18(this, (AppInterface)localObject, paramString1, localJSONObject, paramString2));
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
    Object localObject = (anrs)((AppInterface)localObject).getManager(56);
    if (localObject != null) {}
    for (boolean bool = ((anrs)localObject).a(Long.valueOf(paramString1));; bool = false)
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
      if ((localObject != null) && ((localObject instanceof bhsr))) {
        ((bhsr)localObject).shareStructMsgForH5(str4, str5, str6, str7, paramString, str1, str2, str3);
      }
      bcst.b(null, "P_CliOper", "Pb_account_lifeservice", "", "mp_msg_sys_30", "share_click", 0, 0, str4, "", "", "");
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
    this.jdField_a_of_type_AndroidAppActivity = this.mRuntime.a();
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    if (jdField_a_of_type_Long == 0L) {
      ThreadManager.executeOnNetWorkThread(new PublicAccountJavascriptInterface.1(this));
    }
    bhni localbhni = this.mRuntime.a(this.mRuntime.a());
    if ((localbhni != null) && ((localbhni instanceof bhsx))) {
      this.jdField_a_of_type_Bhsx = ((bhsx)localbhni);
    }
    localbhni = this.mRuntime.a(this.mRuntime.a());
    if ((localbhni != null) && ((localbhni instanceof bhsz))) {
      this.jdField_a_of_type_Bhsz = ((bhsz)localbhni);
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      nzx localnzx = (nzx)localIterator.next();
      if (!localnzx.isCancelled()) {
        localnzx.cancel(true);
      }
    }
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList = null;
    if (this.b) {
      this.jdField_a_of_type_AndroidAppActivity.unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
    }
    if ((this.jdField_a_of_type_Bgpa != null) && (this.jdField_a_of_type_Bgpa.isShowing())) {
      this.jdField_a_of_type_Bgpa.dismiss();
    }
    super.onDestroy();
  }
  
  public void open(String paramString)
  {
    if ("com.tencent.mobileqq.activity.ChatBubbleSettingActivity".equals(paramString))
    {
      VasWebviewUtil.openQQBrowserWithoutAD(this.jdField_a_of_type_AndroidAppActivity, bgyg.a(this.jdField_a_of_type_AndroidAppActivity, "bubble", ""), 64L, null, false, -1);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.setComponent(new ComponentName(this.jdField_a_of_type_AndroidAppActivity, paramString));
    this.jdField_a_of_type_AndroidAppActivity.startActivity(localIntent);
  }
  
  public void openAccountPageMore(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PAjs", 2, "openAccountPageMore->paramStr:" + paramString);
    }
    try
    {
      paramString = tzo.a(paramString);
      if (paramString != null)
      {
        long l = paramString.getLong("puin");
        if (this.jdField_a_of_type_AndroidAppActivity != null)
        {
          paramString = new Intent(this.jdField_a_of_type_AndroidAppActivity, AccountDetailActivity.class);
          paramString.putExtra("uin", "" + l);
          paramString.putExtra("from_js", true);
          this.jdField_a_of_type_AndroidAppActivity.startActivity(paramString);
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
    EmojiHomeUiPlugin.openEmojiHomePage(this.jdField_a_of_type_AndroidAppActivity, localAppInterface.getAccount(), 2);
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
      this.jdField_a_of_type_AndroidAppActivity.startActivity(paramString);
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
      localObject = this.jdField_a_of_type_AndroidAppActivity.getIntent();
      localIntent = new Intent(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidAppActivity.getClass());
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
      this.jdField_a_of_type_AndroidAppActivity.startActivityForResult(localIntent, 100);
      return;
      label80:
      ((Bundle)localObject).remove("title");
      ((Bundle)localObject).remove("leftViewText");
      ((Bundle)localObject).remove("post_data");
      ((Bundle)localObject).remove("options");
    }
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
    new Thread(new PublicAccountJavascriptInterface.17(this, paramString1, paramString2, localJSONObject, localCustomWebView.getUrl())).start();
  }
  
  public void setNavigationBarStyle(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    WebViewFragment localWebViewFragment;
    do
    {
      return;
      localWebViewFragment = this.mRuntime.a();
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
    ((AbsBaseWebViewActivity)this.jdField_a_of_type_AndroidAppActivity).a(paramString3, paramString1, paramString2, false, 0, 0, null, null);
  }
  
  public void setScreenshotAttr(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PAjs", 2, "setScreenshotAttr->paramStr:" + paramString);
    }
    try
    {
      bhpq localbhpq = (bhpq)super.getBrowserComponent(64);
      paramString = tzo.a(paramString);
      String str;
      if ((paramString != null) && (paramString.has("title")))
      {
        str = paramString.getString("title");
        if (localbhpq != null) {
          localbhpq.c(str);
        }
      }
      if ((paramString != null) && (paramString.has("shareUrl")))
      {
        str = paramString.getString("shareUrl");
        if (localbhpq != null) {
          localbhpq.e(str);
        }
      }
      if ((paramString != null) && (paramString.has("sinaShareTitle")))
      {
        str = paramString.getString("sinaShareTitle");
        if (localbhpq != null) {
          localbhpq.d(str);
        }
      }
      if ((paramString != null) && (paramString.has("shareActionSheetTitle")))
      {
        paramString = paramString.optJSONArray("shareActionSheetTitle");
        if (localbhpq != null) {
          localbhpq.a(paramString);
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
    paramString3 = bglp.a(this.jdField_a_of_type_AndroidAppActivity, 0);
    paramString3.setTitle(paramString1);
    paramString3.setMessage(paramString2);
    paramString1 = new nzn(this, paramString6, paramString5);
    if (bool2) {
      paramString3.setNegativeButton(anni.a(2131707522), paramString1);
    }
    if (bool1) {
      paramString3.setPositiveButton(anni.a(2131707558), paramString1);
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
    if ((localObject != null) && ((localObject instanceof bhss))) {
      ((bhss)localObject).b();
    }
    do
    {
      return;
      localObject = (bhql)super.getBrowserComponent(2);
    } while ((localObject == null) || (((bhql)localObject).a == null));
    ((bhql)localObject).a.setVisibility(0);
  }
  
  public void showProfile(String paramString)
  {
    int i = 0;
    int k = 0;
    if (QLog.isColorLevel()) {
      QLog.i("PAjs", 2, "showProfile: " + paramString);
    }
    if (paramString == null) {
      return;
    }
    String str1 = paramString.trim();
    Object localObject2 = "";
    String str2 = "";
    paramString = null;
    String str3 = null;
    if (str1.startsWith("{")) {}
    for (;;)
    {
      Object localObject3;
      int j;
      String str4;
      Object localObject4;
      try
      {
        localObject3 = new JSONObject(str1);
        str1 = ((JSONObject)localObject3).getString("uin");
        int m = ((JSONObject)localObject3).optInt("uinType", 0);
        j = ((JSONObject)localObject3).optInt("isFinish", 0);
        if ("groupSearchOther".equals(((JSONObject)localObject3).optString("jump_from")))
        {
          localObject1 = "group";
          i = ((JSONObject)localObject3).optInt("subSourceID");
          paramString = str3;
          localObject2 = str2;
          if (((JSONObject)localObject3).optInt("colorScreen") != 0) {
            localObject2 = "&colorScreen=" + ((JSONObject)localObject3).optInt("colorScreen");
          }
          str3 = ((JSONObject)localObject3).optString("authKey");
          str2 = ((JSONObject)localObject3).optString("authSig");
          localObject3 = localObject2;
          localObject2 = localObject1;
          localObject1 = localObject3;
          if ((str1 == null) || (str1.length() < 5)) {
            break;
          }
          if (paramString == null) {
            break label578;
          }
          this.jdField_a_of_type_AndroidAppActivity.startActivity(paramString);
          if (j != 1) {
            break;
          }
          paramString = new IntentFilter();
          paramString.addAction("start_recomend_page");
          this.jdField_a_of_type_AndroidAppActivity.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramString);
          this.b = true;
          return;
        }
        if (m == 1)
        {
          localObject1 = "group";
          i = ((JSONObject)localObject3).optInt("wSourceSubID");
          paramString = str3;
          continue;
        }
        paramString = str3;
        i = k;
        localObject1 = localObject2;
        if (m != 0) {
          continue;
        }
        str4 = ((JSONObject)localObject3).optString("from");
        localObject4 = ((JSONObject)localObject3).optString("troopuin");
        if ((!"groupActivity".equals(str4)) || (TextUtils.isEmpty((CharSequence)localObject4))) {
          break label474;
        }
        paramString = new Intent(this.jdField_a_of_type_AndroidAppActivity, FriendProfileCardActivity.class);
        localObject1 = new ProfileActivity.AllInOne(str1, 120);
        ((ProfileActivity.AllInOne)localObject1).c = ((String)localObject4);
        paramString.putExtra("AllInOne", (Parcelable)localObject1);
        localObject1 = new Bundle();
        ((Bundle)localObject1).putString("troop_uin", (String)localObject4);
        paramString.putExtra("flc_extra_param", (Bundle)localObject1);
        i = k;
        localObject1 = localObject2;
        continue;
        if (!QLog.isDevelopLevel()) {
          break;
        }
      }
      catch (JSONException paramString) {}
      QLog.d("PAjs", 4, "showProfile param error");
      return;
      label474:
      paramString = str3;
      i = k;
      Object localObject1 = localObject2;
      if ("groupMembers".equals(str4))
      {
        paramString = str3;
        i = k;
        localObject1 = localObject2;
        if (!TextUtils.isEmpty((CharSequence)localObject4))
        {
          paramString = new Intent(this.jdField_a_of_type_AndroidAppActivity, FriendProfileCardActivity.class);
          paramString.putExtra("troopUin", (String)localObject4);
          paramString.putExtra("memberUin", str1);
          i = k;
          localObject1 = localObject2;
          continue;
          j = 0;
          str2 = "";
          localObject1 = "";
          str3 = "";
          continue;
          label578:
          localObject3 = this.mRuntime.a();
          localObject4 = new StringBuilder();
          if (!TextUtils.isEmpty(str3))
          {
            paramString = "&authKey=" + str3;
            label626:
            ((StringBuilder)localObject4).append(paramString);
            if (TextUtils.isEmpty(str2)) {
              break label761;
            }
          }
          label761:
          for (paramString = "&authSig=" + str2;; paramString = "")
          {
            ((StringBuilder)localObject4).append(paramString);
            paramString = "mqq://card/show_pslcard/?uin=" + str1 + "&card_type=" + (String)localObject2 + "&wSourceSubID=" + i + ((StringBuilder)localObject4).toString() + (String)localObject1;
            if (!(localObject3 instanceof QQAppInterface)) {
              break label768;
            }
            bgng.a((QQAppInterface)localObject3, this.jdField_a_of_type_AndroidAppActivity, paramString).a();
            break;
            paramString = "";
            break label626;
          }
          label768:
          this.jdField_a_of_type_AndroidAppActivity.startActivity(new Intent(this.jdField_a_of_type_AndroidAppActivity, JumpActivity.class).setData(Uri.parse(paramString)));
        }
      }
    }
  }
  
  public void startMultiShare(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PAjs", 2, "startMultiShare->paramStr:" + paramString);
    }
    try
    {
      localObject = tzo.a(paramString);
      if ((localObject == null) || (!((JSONObject)localObject).has("image_url"))) {
        break label151;
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
      localObject = (bhpq)super.getBrowserComponent(64);
      if (localObject == null) {
        return;
      }
      ((bhpq)localObject).a(paramString, bool);
    }
    label151:
  }
  
  public void viewAccount(String paramString)
  {
    viewAccount(paramString, "false");
  }
  
  public void viewAccount(String paramString1, String paramString2)
  {
    Object localObject1 = null;
    if (TextUtils.isEmpty(paramString1)) {}
    AppInterface localAppInterface;
    do
    {
      return;
      localAppInterface = this.mRuntime.a();
    } while (localAppInterface == null);
    if ((localAppInterface instanceof BrowserAppInterface))
    {
      localObject1 = ((BrowserAppInterface)localAppInterface).getEntityManagerFactory(null).createEntityManager();
      if (localObject1 == null) {
        break label277;
      }
      localObject1 = (PublicAccountInfo)((EntityManager)localObject1).find(PublicAccountInfo.class, "uin = ?", new String[] { paramString1 });
    }
    for (;;)
    {
      Object localObject2 = this.jdField_a_of_type_AndroidAppActivity;
      if ((this.jdField_a_of_type_AndroidAppActivity instanceof BasePluginActivity)) {
        localObject2 = ((BasePluginActivity)this.jdField_a_of_type_AndroidAppActivity).getOutActivity();
      }
      if ((localObject1 != null) && ("true".equals(paramString2)))
      {
        paramString2 = new Intent((Context)localObject2, ChatActivity.class);
        paramString2.putExtra("uin", paramString1);
        paramString2.putExtra("uintype", 1008);
        paramString2.putExtra("uinname", ((PublicAccountInfo)localObject1).name);
        ((Activity)localObject2).startActivity(paramString2);
      }
      for (;;)
      {
        PublicAccountHandler.a(localAppInterface, paramString1, "Pb_account_lifeservice", "mp_msg_sys_5", "addpage_hot");
        return;
        localObject2 = (anrs)localAppInterface.getManager(56);
        if (localObject2 == null) {
          break;
        }
        localObject1 = ((anrs)localObject2).b(paramString1);
        break;
        paramString2 = new Intent((Context)localObject2, AccountDetailActivity.class);
        paramString2.putExtra("uin", paramString1);
        paramString2.putExtra("report_src_param_type", "");
        paramString2.putExtra("report_src_param_name", "");
        paramString2.putExtra("fromBrowser", true);
        paramString2.setFlags(67108864);
        ((Activity)localObject2).startActivity(paramString2);
      }
      label277:
      localObject1 = null;
    }
  }
  
  public void viewAccount(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    Object localObject1 = null;
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
    if ((localAppInterface instanceof BrowserAppInterface))
    {
      localObject1 = ((BrowserAppInterface)localAppInterface).getEntityManagerFactory(null).createEntityManager();
      if (localObject1 == null) {
        break label318;
      }
      localObject1 = (PublicAccountInfo)((EntityManager)localObject1).find(PublicAccountInfo.class, "uin = ?", new String[] { paramString1 });
    }
    for (;;)
    {
      Object localObject2 = this.jdField_a_of_type_AndroidAppActivity;
      if (this.jdField_a_of_type_AndroidAppActivity.getClass().getName().equalsIgnoreCase("com.tencent.qqreadinjoy.detailspage.ReadInJoyArticleDetailActivity")) {
        localObject2 = ((PluginBaseActivity)this.jdField_a_of_type_AndroidAppActivity).getOutActivity();
      }
      if ((localObject1 != null) && ("true".equals(paramString2)))
      {
        paramString2 = new Intent((Context)localObject2, ChatActivity.class);
        paramString2.putExtra("uin", paramString1);
        paramString2.putExtra("uintype", 1008);
        paramString2.putExtra("uinname", ((PublicAccountInfo)localObject1).name);
        ((Activity)localObject2).startActivity(paramString2);
      }
      for (;;)
      {
        PublicAccountHandler.a(localAppInterface, paramString1, "Pb_account_lifeservice", "mp_msg_sys_5", "addpage_hot");
        return;
        localObject2 = (anrs)localAppInterface.getManager(56);
        if (localObject2 == null) {
          break;
        }
        localObject1 = ((anrs)localObject2).b(paramString1);
        break;
        paramString2 = new Intent((Context)localObject2, AccountDetailActivity.class);
        paramString2.putExtra("uin", paramString1);
        paramString2.putExtra("report_src_param_type", paramString3);
        paramString2.putExtra("report_src_param_name", paramString4);
        ((Activity)localObject2).startActivity(paramString2);
      }
      label318:
      localObject1 = null;
    }
  }
  
  public void viewTroopBarAccount(String paramString)
  {
    viewAccount(paramString);
  }
  
  public void writeH5Data(String paramString1, String paramString2)
  {
    JSONObject localJSONObject = new JSONObject();
    if (TextUtils.isEmpty(paramString1))
    {
      callJs(paramString2, new String[] { "{ret:-3, response:" + localJSONObject.toString() + "}" });
      return;
    }
    ThreadManager.post(new PublicAccountJavascriptInterface.13(this, paramString1, paramString2, localJSONObject), 5, null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.PublicAccountJavascriptInterface
 * JD-Core Version:    0.7.0.1
 */