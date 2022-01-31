import android.app.Activity;
import android.content.ClipData;
import android.content.ClipData.Item;
import android.content.ClipboardManager;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity;
import com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment;
import com.tencent.mobileqq.activity.TeamWorkPicBrowserActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.activity.FMActivity;
import com.tencent.mobileqq.jsp.DocxApiPlugin.10;
import com.tencent.mobileqq.jsp.DocxApiPlugin.2;
import com.tencent.mobileqq.jsp.DocxApiPlugin.3;
import com.tencent.mobileqq.jsp.DocxApiPlugin.4;
import com.tencent.mobileqq.jsp.DocxApiPlugin.5;
import com.tencent.mobileqq.jsp.DocxApiPlugin.6;
import com.tencent.mobileqq.jsp.DocxApiPlugin.7;
import com.tencent.mobileqq.jsp.DocxApiPlugin.8;
import com.tencent.mobileqq.jsp.DocxApiPlugin.9;
import com.tencent.mobileqq.nearby.picbrowser.PicInfo;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.teamwork.TeamWorkForceShare;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.UnVisibleWebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.CookieManager;
import com.tencent.smtt.sdk.WebView;
import com.tencent.util.Pair;
import eipc.EIPCClient;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class aqrp
  extends WebViewPlugin
{
  private amxe jdField_a_of_type_Amxe;
  private amxj jdField_a_of_type_Amxj;
  private amxm jdField_a_of_type_Amxm;
  private String jdField_a_of_type_JavaLangString;
  
  public aqrp()
  {
    this.mPluginNameSpace = "docx";
  }
  
  private void a()
  {
    ThreadManager.excute(new DocxApiPlugin.6(this), 64, null, false);
  }
  
  public static void a(String paramString, TouchWebView paramTouchWebView)
  {
    if (!ammf.a().c()) {}
    while ((TextUtils.isEmpty(paramString)) || (axfz.a == null) || (axfz.a.get(paramString) == null) || (((Integer)axfz.a.get(paramString)).intValue() != 2)) {
      try
      {
        paramString = new JSONObject();
        paramString.put("retcode", 1);
        ThreadManager.getUIHandler().post(new DocxApiPlugin.7(paramTouchWebView, paramString));
        return;
      }
      catch (JSONException paramString)
      {
        QLog.e("DocxApiPlugin", 1, "JSONException ", paramString);
        return;
      }
    }
    axfz.a.remove(paramString);
    if (axfb.a(paramString))
    {
      ThreadManager.excute(new DocxApiPlugin.8(paramString, paramTouchWebView), 64, null, false);
      return;
    }
    try
    {
      paramString = new JSONObject();
      paramString.put("retcode", 1);
      ThreadManager.getUIHandler().post(new DocxApiPlugin.9(paramTouchWebView, paramString));
      return;
    }
    catch (JSONException paramString)
    {
      QLog.e("DocxApiPlugin", 1, "JSONException ", paramString);
    }
  }
  
  private void a(ArrayList<String> paramArrayList)
  {
    ThreadManager.excute(new DocxApiPlugin.5(this, paramArrayList), 128, null, false);
  }
  
  private void f(String paramString)
  {
    QLog.d("DocxApiPlugin", 2, "req json = " + paramString);
    try
    {
      paramString = new JSONObject(paramString);
      this.jdField_a_of_type_JavaLangString = paramString.optString("callback");
      new TeamWorkForceShare(this, paramString).a();
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void a(String paramString)
  {
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject(paramString);
        boolean bool = localJSONObject.optBoolean("success");
        String str2 = localJSONObject.optString("url");
        paramString = localJSONObject.optString("fileName");
        Bundle localBundle = new Bundle();
        localBundle.putBoolean("isSuccess", bool);
        localBundle.putString("url", str2);
        localBundle.putString("fileName", paramString);
        paramString = this.mRuntime.a();
        if ((!(paramString instanceof TeamWorkDocEditBrowserActivity)) || (((TeamWorkDocEditBrowserActivity)paramString).a() == null)) {
          break label203;
        }
        paramString = ((TeamWorkDocEditBrowserActivity)paramString).a().getUrl();
        String str1 = paramString;
        if (TextUtils.isEmpty(paramString)) {
          str1 = localJSONObject.optString("refer_url");
        }
        localBundle.putString("docUrl", str1);
        localBundle.putString("cookie", CookieManager.getInstance().getCookie(str2));
        QIPCClientHelper.getInstance().getClient().callServer("TeamWorkModule", "action_download_export_file", localBundle);
      }
      catch (Exception paramString)
      {
        QLog.e("DocxApiPlugin", 1, "downloadExportedFile exception e = " + paramString.toString());
        continue;
      }
      finally {}
      return;
      label203:
      paramString = null;
    }
  }
  
  /* Error */
  public boolean a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokestatic 88	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6: istore_3
    //   7: iload_3
    //   8: ifeq +7 -> 15
    //   11: aload_0
    //   12: monitorexit
    //   13: iconst_0
    //   14: ireturn
    //   15: new 132	java/lang/StringBuilder
    //   18: dup
    //   19: invokespecial 133	java/lang/StringBuilder:<init>	()V
    //   22: ldc 74
    //   24: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: getstatic 252	axdz:i	Ljava/lang/String;
    //   30: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: invokevirtual 143	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   36: iconst_1
    //   37: new 132	java/lang/StringBuilder
    //   40: dup
    //   41: invokespecial 133	java/lang/StringBuilder:<init>	()V
    //   44: ldc 254
    //   46: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: aload_1
    //   50: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: invokevirtual 143	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   56: invokestatic 256	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   59: ldc_w 258
    //   62: astore 8
    //   64: aconst_null
    //   65: astore 7
    //   67: ldc_w 260
    //   70: astore 6
    //   72: ldc2_w 261
    //   75: lstore 4
    //   77: new 50	org/json/JSONObject
    //   80: dup
    //   81: aload_1
    //   82: invokespecial 149	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   85: astore_1
    //   86: aload_1
    //   87: ldc_w 264
    //   90: invokevirtual 155	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   93: astore 10
    //   95: aload_1
    //   96: ldc_w 266
    //   99: invokevirtual 155	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   102: astore 9
    //   104: aload_1
    //   105: ldc_w 268
    //   108: invokevirtual 155	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   111: astore 15
    //   113: aload_1
    //   114: ldc_w 270
    //   117: invokevirtual 155	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   120: astore 11
    //   122: aload_1
    //   123: ldc_w 272
    //   126: invokevirtual 155	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   129: astore 16
    //   131: aload_1
    //   132: ldc_w 274
    //   135: invokevirtual 155	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   138: astore 17
    //   140: aload_1
    //   141: ldc_w 276
    //   144: invokevirtual 155	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   147: astore 12
    //   149: aload_1
    //   150: ldc_w 278
    //   153: invokevirtual 155	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   156: astore 13
    //   158: aload_1
    //   159: ldc_w 280
    //   162: invokevirtual 284	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   165: istore_2
    //   166: aload_0
    //   167: getfield 193	aqrp:mRuntime	Lbbac;
    //   170: invokevirtual 198	bbac:a	()Landroid/app/Activity;
    //   173: checkcast 286	com/tencent/mobileqq/activity/QQBrowserActivity
    //   176: astore 14
    //   178: aload 14
    //   180: invokevirtual 290	com/tencent/mobileqq/activity/QQBrowserActivity:getIntent	()Landroid/content/Intent;
    //   183: ldc_w 292
    //   186: invokevirtual 297	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   189: astore_1
    //   190: aload 15
    //   192: invokestatic 300	axfs:a	(Ljava/lang/String;)Z
    //   195: ifeq +30 -> 225
    //   198: ldc_w 302
    //   201: astore 8
    //   203: ldc_w 303
    //   206: invokestatic 308	ajjy:a	(I)Ljava/lang/String;
    //   209: astore_1
    //   210: getstatic 311	axfs:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   213: astore 6
    //   215: getstatic 313	axfs:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   218: astore 7
    //   220: getstatic 316	axfs:a	J
    //   223: lstore 4
    //   225: new 294	android/content/Intent
    //   228: dup
    //   229: invokespecial 317	android/content/Intent:<init>	()V
    //   232: astore 18
    //   234: aload 18
    //   236: ldc_w 272
    //   239: aload 16
    //   241: invokevirtual 321	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   244: pop
    //   245: aload 18
    //   247: ldc_w 274
    //   250: aload 17
    //   252: invokevirtual 321	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   255: pop
    //   256: aload 18
    //   258: ldc_w 323
    //   261: iconst_1
    //   262: invokevirtual 326	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   265: pop
    //   266: aload 18
    //   268: aload 14
    //   270: ldc_w 328
    //   273: invokevirtual 332	android/content/Intent:setClass	(Landroid/content/Context;Ljava/lang/Class;)Landroid/content/Intent;
    //   276: pop
    //   277: aload 18
    //   279: ldc_w 334
    //   282: iconst_1
    //   283: invokevirtual 326	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   286: pop
    //   287: aload 18
    //   289: ldc_w 336
    //   292: sipush 1001
    //   295: invokevirtual 339	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   298: pop
    //   299: aload 18
    //   301: ldc_w 341
    //   304: ldc_w 343
    //   307: invokevirtual 321	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   310: pop
    //   311: aload 18
    //   313: ldc_w 345
    //   316: bipush 95
    //   318: invokevirtual 339	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   321: pop
    //   322: aload 18
    //   324: ldc_w 347
    //   327: aload 15
    //   329: invokevirtual 321	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   332: pop
    //   333: aload 18
    //   335: ldc_w 349
    //   338: aload 11
    //   340: invokevirtual 321	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   343: pop
    //   344: lload 4
    //   346: ldc2_w 350
    //   349: lcmp
    //   350: ifeq +14 -> 364
    //   353: aload 18
    //   355: ldc_w 353
    //   358: lload 4
    //   360: invokevirtual 356	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   363: pop
    //   364: aload 18
    //   366: ldc_w 358
    //   369: aload 6
    //   371: invokevirtual 321	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   374: pop
    //   375: aload 18
    //   377: ldc_w 360
    //   380: aload_1
    //   381: invokevirtual 321	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   384: pop
    //   385: aload 18
    //   387: ldc_w 362
    //   390: aload 7
    //   392: invokevirtual 321	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   395: pop
    //   396: aload 18
    //   398: ldc_w 364
    //   401: aload 8
    //   403: invokevirtual 321	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   406: pop
    //   407: aload 18
    //   409: ldc_w 366
    //   412: ldc_w 368
    //   415: invokevirtual 321	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   418: pop
    //   419: aload 18
    //   421: ldc_w 370
    //   424: ldc_w 368
    //   427: invokevirtual 321	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   430: pop
    //   431: aload 10
    //   433: astore_1
    //   434: aload 10
    //   436: ifnull +44 -> 480
    //   439: aload 10
    //   441: astore_1
    //   442: aload 10
    //   444: invokevirtual 375	java/lang/String:length	()I
    //   447: bipush 45
    //   449: if_icmple +31 -> 480
    //   452: new 132	java/lang/StringBuilder
    //   455: dup
    //   456: invokespecial 133	java/lang/StringBuilder:<init>	()V
    //   459: aload 10
    //   461: iconst_0
    //   462: bipush 45
    //   464: invokevirtual 379	java/lang/String:substring	(II)Ljava/lang/String;
    //   467: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   470: ldc_w 381
    //   473: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   476: invokevirtual 143	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   479: astore_1
    //   480: aload 18
    //   482: ldc_w 264
    //   485: aload_1
    //   486: invokevirtual 321	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   489: pop
    //   490: aload 9
    //   492: astore 6
    //   494: aload 9
    //   496: ifnull +46 -> 542
    //   499: aload 9
    //   501: astore 6
    //   503: aload 9
    //   505: invokevirtual 375	java/lang/String:length	()I
    //   508: bipush 60
    //   510: if_icmple +32 -> 542
    //   513: new 132	java/lang/StringBuilder
    //   516: dup
    //   517: invokespecial 133	java/lang/StringBuilder:<init>	()V
    //   520: aload 9
    //   522: iconst_0
    //   523: bipush 60
    //   525: invokevirtual 379	java/lang/String:substring	(II)Ljava/lang/String;
    //   528: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   531: ldc_w 381
    //   534: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   537: invokevirtual 143	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   540: astore 6
    //   542: aload 18
    //   544: ldc_w 266
    //   547: aload 6
    //   549: invokevirtual 321	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   552: pop
    //   553: aload 18
    //   555: ldc_w 383
    //   558: aload 11
    //   560: invokevirtual 321	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   563: pop
    //   564: aload 18
    //   566: ldc_w 385
    //   569: ldc_w 302
    //   572: invokevirtual 321	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   575: pop
    //   576: aload 18
    //   578: ldc_w 353
    //   581: ldc2_w 350
    //   584: invokevirtual 356	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   587: pop
    //   588: aload 18
    //   590: ldc_w 387
    //   593: aload 14
    //   595: ldc_w 388
    //   598: iconst_1
    //   599: anewarray 390	java/lang/Object
    //   602: dup
    //   603: iconst_0
    //   604: aload_1
    //   605: aastore
    //   606: invokevirtual 394	com/tencent/mobileqq/activity/QQBrowserActivity:getString	(I[Ljava/lang/Object;)Ljava/lang/String;
    //   609: invokevirtual 321	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   612: pop
    //   613: aload 18
    //   615: ldc_w 278
    //   618: aload 13
    //   620: invokevirtual 321	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   623: pop
    //   624: aload 18
    //   626: ldc_w 280
    //   629: iload_2
    //   630: invokevirtual 339	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   633: pop
    //   634: aload 12
    //   636: invokestatic 88	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   639: ifne +37 -> 676
    //   642: aload 18
    //   644: ldc_w 396
    //   647: aload 12
    //   649: invokevirtual 321	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   652: pop
    //   653: invokestatic 228	com/tencent/mobileqq/qipc/QIPCClientHelper:getInstance	()Lcom/tencent/mobileqq/qipc/QIPCClientHelper;
    //   656: invokevirtual 232	com/tencent/mobileqq/qipc/QIPCClientHelper:getClient	()Leipc/EIPCClient;
    //   659: ldc 234
    //   661: ldc_w 398
    //   664: aload 18
    //   666: invokevirtual 402	android/content/Intent:getExtras	()Landroid/os/Bundle;
    //   669: invokevirtual 242	eipc/EIPCClient:callServer	(Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;)Leipc/EIPCResult;
    //   672: pop
    //   673: goto -662 -> 11
    //   676: new 132	java/lang/StringBuilder
    //   679: dup
    //   680: invokespecial 133	java/lang/StringBuilder:<init>	()V
    //   683: ldc 74
    //   685: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   688: getstatic 252	axdz:i	Ljava/lang/String;
    //   691: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   694: invokevirtual 143	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   697: iconst_1
    //   698: ldc_w 404
    //   701: invokestatic 256	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   704: goto -51 -> 653
    //   707: astore_1
    //   708: new 132	java/lang/StringBuilder
    //   711: dup
    //   712: invokespecial 133	java/lang/StringBuilder:<init>	()V
    //   715: ldc 74
    //   717: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   720: getstatic 252	axdz:i	Ljava/lang/String;
    //   723: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   726: invokevirtual 143	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   729: iconst_1
    //   730: ldc_w 406
    //   733: invokestatic 247	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   736: goto -725 -> 11
    //   739: astore_1
    //   740: aload_0
    //   741: monitorexit
    //   742: aload_1
    //   743: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	744	0	this	aqrp
    //   0	744	1	paramString	String
    //   165	465	2	i	int
    //   6	2	3	bool	boolean
    //   75	284	4	l	long
    //   70	478	6	localObject	Object
    //   65	326	7	str1	String
    //   62	340	8	str2	String
    //   102	419	9	str3	String
    //   93	367	10	str4	String
    //   120	439	11	str5	String
    //   147	501	12	str6	String
    //   156	463	13	str7	String
    //   176	418	14	localQQBrowserActivity	QQBrowserActivity
    //   111	217	15	str8	String
    //   129	111	16	str9	String
    //   138	113	17	str10	String
    //   232	433	18	localIntent	Intent
    // Exception table:
    //   from	to	target	type
    //   77	190	707	org/json/JSONException
    //   190	198	707	org/json/JSONException
    //   203	225	707	org/json/JSONException
    //   225	344	707	org/json/JSONException
    //   353	364	707	org/json/JSONException
    //   364	431	707	org/json/JSONException
    //   442	480	707	org/json/JSONException
    //   480	490	707	org/json/JSONException
    //   503	542	707	org/json/JSONException
    //   542	653	707	org/json/JSONException
    //   653	673	707	org/json/JSONException
    //   676	704	707	org/json/JSONException
    //   2	7	739	finally
    //   15	59	739	finally
    //   77	190	739	finally
    //   190	198	739	finally
    //   203	225	739	finally
    //   225	344	739	finally
    //   353	364	739	finally
    //   364	431	739	finally
    //   442	480	739	finally
    //   480	490	739	finally
    //   503	542	739	finally
    //   542	653	739	finally
    //   653	673	739	finally
    //   676	704	739	finally
    //   708	736	739	finally
  }
  
  public void b(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString).optString("fileName");
      new Bundle().putString("fileName", paramString);
      axeg.a(this.mRuntime.a(), paramString);
      return;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        QLog.e("DocxApiPlugin", 1, "startExportedFile exception e = " + paramString.toString());
      }
    }
    finally {}
  }
  
  public void c(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString).optString("folderId");
      QQBrowserActivity localQQBrowserActivity = (QQBrowserActivity)this.mRuntime.a();
      ThreadManager.postImmediately(new DocxApiPlugin.10(this, localQQBrowserActivity, localQQBrowserActivity.a().getUrl()), null, true);
      Intent localIntent = new Intent(localQQBrowserActivity, FMActivity.class);
      localIntent.putExtra(axdz.f, true);
      localIntent.addFlags(536870912);
      localIntent.putExtra("selectMode", true);
      localIntent.putExtra("busiType", 9);
      localIntent.putExtra("peerType", 10006);
      localIntent.putExtra("tab_tab_type", 7);
      localIntent.putExtra("only_show_local_tab", true);
      localIntent.putExtra(axdz.g, paramString);
      localIntent.putExtra("smart_device_support_flag", 8);
      localQQBrowserActivity.startActivity(localIntent);
      localQQBrowserActivity.overridePendingTransition(2130771979, 2130771980);
      return;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        QLog.e("DocxApiPlugin", 1, "openFMActivityToImport exception e = " + paramString.toString());
      }
    }
    finally {}
  }
  
  void d(String paramString)
  {
    Object localObject1;
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("DocxApiPlugin", 2, "handleWriteClipboard jsonString = " + paramString);
      }
      if (TextUtils.isEmpty(paramString))
      {
        QLog.d("DocxApiPlugin", 1, "handleWriteClipboard return for empty json");
        return;
      }
      localObject1 = this.mRuntime.a();
      if (localObject1 == null)
      {
        QLog.d("DocxApiPlugin", 1, "handleWriteClipboard return for null activity");
        return;
      }
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      QLog.d("DocxApiPlugin", 1, "handleWriteClipboard exception", paramString);
      return;
    }
    paramString = new JSONObject(paramString);
    String str1 = paramString.optString("plain");
    String str2 = paramString.optString("html");
    if (QLog.isColorLevel()) {
      QLog.d("DocxApiPlugin", 2, "handleWriteClipboard text = " + str1 + ",html = " + str2);
    }
    if ((TextUtils.isEmpty(str1)) && (TextUtils.isEmpty(str2)))
    {
      QLog.d("DocxApiPlugin", 1, "handleWriteClipboard return for empty text and html");
      return;
    }
    ClipboardManager localClipboardManager = (ClipboardManager)((Activity)localObject1).getSystemService("clipboard");
    Object localObject2 = null;
    ClipData.Item localItem;
    if (Build.VERSION.SDK_INT >= 16)
    {
      localItem = new ClipData.Item(str1, str2);
      if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2)))
      {
        paramString = new String[2];
        paramString[0] = "text/plain";
        paramString[1] = "text/html";
        localObject1 = localItem;
      }
    }
    for (;;)
    {
      localClipboardManager.setPrimaryClip(new ClipData("", paramString, (ClipData.Item)localObject1));
      return;
      if ((!TextUtils.isEmpty(str1)) && (TextUtils.isEmpty(str2)))
      {
        paramString = new String[1];
        paramString[0] = "text/plain";
        localObject1 = localItem;
      }
      else
      {
        paramString = localObject2;
        localObject1 = localItem;
        if (TextUtils.isEmpty(str1))
        {
          paramString = localObject2;
          localObject1 = localItem;
          if (!TextUtils.isEmpty(str2))
          {
            paramString = new String[1];
            paramString[0] = "text/html";
            localObject1 = localItem;
            continue;
            localObject1 = new ClipData.Item(str1);
            paramString = new String[1];
            paramString[0] = "text/plain";
          }
        }
      }
    }
  }
  
  void e(String paramString)
  {
    Object localObject1 = null;
    Object localObject3 = null;
    String str;
    JSONObject localJSONObject;
    Object localObject4;
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("DocxApiPlugin", 2, "handleReadClipboard jsonString = " + paramString);
      }
      if (TextUtils.isEmpty(paramString))
      {
        QLog.d("DocxApiPlugin", 1, "handleReadClipboard return for empty json");
        return;
      }
      str = new JSONObject(paramString).optString("callback");
      localJSONObject = new JSONObject();
      localObject4 = this.mRuntime.a();
      if (localObject4 == null)
      {
        QLog.d("DocxApiPlugin", 1, "handleReadClipboard return for null activity");
        callJs(str, new String[] { String.valueOf(-2), localJSONObject.toString() });
        return;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      QLog.d("DocxApiPlugin", 1, "handleReadClipboard exception", localException);
      try
      {
        callJs(new JSONObject(paramString).optString("callback"), new String[] { String.valueOf(-3), new JSONObject().toString() });
        return;
      }
      catch (Exception paramString)
      {
        QLog.d("DocxApiPlugin", 1, "handleReadClipboard Exception e1", paramString);
        return;
      }
      localObject4 = ((ClipboardManager)((Activity)localObject4).getSystemService("clipboard")).getPrimaryClip();
      if (QLog.isColorLevel()) {
        QLog.d("DocxApiPlugin", 2, "handleReadClipboard ClipData = " + localObject4);
      }
      if (localObject4 == null) {
        break label439;
      }
    }
    Object localObject2;
    if (((ClipData)localObject4).getItemCount() > 0)
    {
      localObject3 = ((ClipData)localObject4).getItemAt(0);
      localObject2 = ((ClipData.Item)localObject3).getText().toString();
      if (Build.VERSION.SDK_INT >= 16)
      {
        localObject4 = ((ClipData.Item)localObject3).getHtmlText();
        localObject3 = localObject2;
        localObject2 = localObject4;
        if (!QLog.isColorLevel()) {
          break label445;
        }
        QLog.d("DocxApiPlugin", 2, "handleReadClipboard text  = " + (String)localObject3 + ",html = " + (String)localObject2);
        break label445;
      }
    }
    label421:
    label439:
    label445:
    for (;;)
    {
      if ((TextUtils.isEmpty((CharSequence)localObject3)) && (TextUtils.isEmpty((CharSequence)localObject2)))
      {
        i = 1;
        if (i != 0) {
          break label421;
        }
        localJSONObject.put("plain", localObject3);
        localJSONObject.put("html", localObject2);
      }
      for (int i = 0;; i = -1)
      {
        callJs(str, new String[] { String.valueOf(i), localJSONObject.toString() });
        return;
        i = 0;
        break;
      }
      localObject3 = localObject2;
      localObject2 = null;
      break;
      localObject2 = null;
      break;
      localObject3 = null;
    }
  }
  
  public boolean handleEvent(String paramString, long paramLong, Map<String, Object> paramMap)
  {
    if (QLog.isColorLevel()) {
      QLog.i("DocxApiPlugin", 2, "handleEvent " + paramString + ", type=" + paramLong + ", info=" + paramMap);
    }
    if (paramLong == 8589934601L)
    {
      if ((this.mRuntime == null) || (this.mRuntime.a() == null) || (!(this.mRuntime.a() instanceof QQBrowserActivity)))
      {
        QLog.e("DocxApiPlugin", 1, "handleEvent sth is null or not instanceof QQBrowserActivity");
        return super.handleEvent(paramString, paramLong, paramMap);
      }
      if (!this.mRuntime.a().getIntent().getBooleanExtra("doc_from_aio", false)) {
        QLog.e("DocxApiPlugin", 1, "handleEvent not fromAIO, url=" + paramString);
      }
      if (this.jdField_a_of_type_Amxe != null)
      {
        QLog.e("DocxApiPlugin", 1, "handleEvent guide has shown");
        return super.handleEvent(paramString, paramLong, paramMap);
      }
      Pair localPair = amxa.a(this.mRuntime.a());
      boolean bool = ((Boolean)localPair.first).booleanValue();
      int i = ((Integer)localPair.second).intValue();
      int j = amxg.a(this.mRuntime.a(), this.mRuntime.a());
      if (QLog.isColorLevel()) {
        QLog.i("DocxApiPlugin", 2, "handleEvent enable=" + bool + ", total=" + i + ", shown=" + j);
      }
      if (!bool)
      {
        QLog.e("DocxApiPlugin", 1, "handleEvent not enable");
        return super.handleEvent(paramString, paramLong, paramMap);
      }
      if (j >= i)
      {
        QLog.e("DocxApiPlugin", 1, "handleEvent shown >= total");
        return super.handleEvent(paramString, paramLong, paramMap);
      }
      this.jdField_a_of_type_Amxe = new amxe(this.mRuntime.a());
      this.jdField_a_of_type_Amxe.a(new aqrq(this));
      amxg.a(this.mRuntime.a(), this.mRuntime.a(), j + 1);
      try
      {
        this.jdField_a_of_type_Amxe.show();
        awqx.b(null, "CliOper", "", "", "0X80094EA", "0X80094EA", 0, 0, "", "", "", "");
        return true;
      }
      catch (Throwable localThrowable)
      {
        QLog.e("DocxApiPlugin", 1, "", localThrowable);
        return super.handleEvent(paramString, paramLong, paramMap);
      }
    }
    if (paramLong == 8589934597L) {
      if (this.jdField_a_of_type_Amxm != null) {
        this.jdField_a_of_type_Amxm.b();
      }
    }
    for (;;)
    {
      return super.handleEvent(paramString, paramLong, paramMap);
      if (paramLong != 8589934611L) {}
    }
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DocxApiPlugin", 2, " handleJsRequest url = " + paramString1 + " pkgName = " + paramString2 + ",method = " + paramString3);
    }
    if ("docx".equals(paramString2))
    {
      addOpenApiListenerIfNeeded(paramString3, paramJsBridgeListener);
      if ((!"readyToInsertImageCallBack".equals(paramString3)) || (paramVarArgs.length > 1)) {}
    }
    else
    {
      try
      {
        if (paramVarArgs.length == 1)
        {
          paramString1 = new JSONObject(paramVarArgs[0]);
          paramJsBridgeListener = paramString1.getString("attachmentId");
          paramString1 = paramString1.getString("localpath");
          paramString2 = this.mRuntime.a();
          if (QLog.isColorLevel()) {
            QLog.i("TeamWorkDocEditBrowserActivity", 2, "回调id = " + paramJsBridgeListener + " localPath = " + paramString1);
          }
          if ((paramString2 != null) && ((paramString2 instanceof TeamWorkDocEditBrowserActivity))) {
            ThreadManager.postImmediately(new DocxApiPlugin.2(this, paramString2, paramString1, paramJsBridgeListener), null, false);
          }
        }
      }
      catch (Exception paramJsBridgeListener)
      {
        for (;;)
        {
          if (QLog.isDevelopLevel()) {
            QLog.d("DocxApiPlugin", 4, "readyToInsertImageCallBack failed:" + paramJsBridgeListener);
          }
        }
      }
      return false;
    }
    if (("getDocxImageIndex".equals(paramString3)) && (paramVarArgs.length <= 1)) {}
    for (;;)
    {
      for (;;)
      {
        for (;;)
        {
          for (;;)
          {
            for (;;)
            {
              try
              {
                if (paramVarArgs.length != 1) {
                  break;
                }
                paramString1 = new JSONObject(paramVarArgs[0]);
                paramJsBridgeListener = new ArrayList();
                if (!paramString1.has("currentImageIndex")) {
                  break label2051;
                }
                i = paramString1.getInt("currentImageIndex");
                if (paramString1.has("imageList"))
                {
                  paramString1 = paramString1.getJSONArray("imageList");
                  if (paramString1 != null)
                  {
                    j = 0;
                    if (j < paramString1.length())
                    {
                      paramJsBridgeListener.add((String)paramString1.get(j));
                      j += 1;
                      continue;
                    }
                  }
                }
                if (QLog.isColorLevel()) {
                  QLog.i("TeamWorkDocEditBrowserActivity", 2, " index = " + i + " urls.size = " + paramJsBridgeListener.size());
                }
                paramString1 = this.mRuntime.a();
                if ((paramString1 == null) || (!(paramString1 instanceof TeamWorkDocEditBrowserActivity)) || (i == -1)) {
                  break;
                }
                paramString2 = new ArrayList();
                int j = 0;
                if (j < paramJsBridgeListener.size())
                {
                  paramString3 = new PicInfo();
                  paramString3.jdField_a_of_type_JavaLangString = ((String)paramJsBridgeListener.get(j));
                  paramString3.jdField_b_of_type_JavaLangString = ((String)paramJsBridgeListener.get(j));
                  paramString2.add(paramString3);
                  j += 1;
                  continue;
                }
                paramJsBridgeListener = new Intent(paramString1, TeamWorkPicBrowserActivity.class);
                paramJsBridgeListener.putExtra("intent_param_index", i);
                paramJsBridgeListener.putExtra("intent_param_pic_infos", paramString2);
                paramJsBridgeListener.addFlags(536870912);
                paramString1.startActivity(paramJsBridgeListener);
              }
              catch (Exception paramJsBridgeListener) {}
              if (!QLog.isDevelopLevel()) {
                break;
              }
              QLog.d("DocxApiPlugin", 4, "getDocxImageList failed:" + paramJsBridgeListener);
              break;
              if ((!"setAuthForSharePad".equals(paramString3)) || (paramVarArgs.length > 1)) {
                break label995;
              }
              try
              {
                if ((paramVarArgs.length != 1) || (!(this.mRuntime.a() instanceof QQBrowserActivity))) {
                  break;
                }
                paramJsBridgeListener = new axdv();
                paramString1 = new JSONObject(paramVarArgs[0]);
                paramJsBridgeListener.jdField_a_of_type_JavaLangString = ((String)paramString1.opt("authFirstLineInfo"));
                paramJsBridgeListener.jdField_b_of_type_JavaLangString = ((String)paramString1.opt("authSecondLineInfo"));
                paramJsBridgeListener.jdField_a_of_type_Int = ((Integer)paramString1.opt("policy")).intValue();
                paramJsBridgeListener.jdField_a_of_type_Boolean = ((Boolean)paramString1.opt("isCreator")).booleanValue();
                paramJsBridgeListener.jdField_c_of_type_JavaLangString = ((String)paramString1.opt("docName"));
                paramJsBridgeListener.jdField_b_of_type_Int = ((Integer)paramString1.opt("docType")).intValue();
                paramJsBridgeListener.jdField_d_of_type_JavaLangString = ((String)paramString1.opt("docIconUrl"));
                paramJsBridgeListener.jdField_c_of_type_Int = ((Integer)paramString1.opt("taskType")).intValue();
                paramJsBridgeListener.e = ((String)paramString1.opt("share_url"));
                paramJsBridgeListener.jdField_d_of_type_Int = ((Integer)paramString1.opt("memLength")).intValue();
                paramJsBridgeListener.f = ((String)paramString1.opt("memListPrefix"));
                paramJsBridgeListener.g = ((String)paramString1.opt("descriptionSuffix"));
                paramJsBridgeListener.h = ((String)paramString1.opt("padId"));
                paramJsBridgeListener.i = ((String)paramString1.opt("domainId"));
                paramJsBridgeListener.j = ((String)paramString1.opt("padTitle"));
                paramJsBridgeListener.k = ((String)paramString1.opt("folderId"));
                paramString1 = (QQBrowserActivity)this.mRuntime.a();
                if ((paramString1 == null) || (paramString1.b() == null)) {
                  break;
                }
                paramString1 = paramString1.b();
                if (paramString1 == null) {
                  break;
                }
                paramString1.a().a(paramJsBridgeListener);
                paramJsBridgeListener = paramString1.b();
                if (paramJsBridgeListener == null) {
                  break;
                }
                paramJsBridgeListener = (bbbt)paramJsBridgeListener.a(4);
                if ((paramJsBridgeListener == null) || (!(paramJsBridgeListener.a instanceof axfo))) {
                  break;
                }
                paramJsBridgeListener.a.d();
              }
              catch (Exception paramJsBridgeListener)
              {
                QLog.d("DocxApiPlugin", 1, "setAuthForSharePad error:" + paramJsBridgeListener);
              }
            }
            break;
            label995:
            if (("sendDocToChat".equals(paramString3)) && (paramVarArgs.length <= 1)) {
              return a(paramVarArgs[0]);
            }
            if (("writeSystemClipboard".equals(paramString3)) && (paramVarArgs.length <= 1))
            {
              if (paramVarArgs.length != 1) {
                break;
              }
              d(paramVarArgs[0]);
              break;
            }
            if (("readSystemClipboard".equals(paramString3)) && (paramVarArgs.length <= 1))
            {
              if (paramVarArgs.length != 1) {
                break;
              }
              e(paramVarArgs[0]);
              break;
            }
            if (("eventShare".equals(paramString3)) && (paramVarArgs.length == 1))
            {
              f(paramVarArgs[0]);
              break;
            }
            if (("openLocalFilesToImport".equals(paramString3)) && (paramVarArgs.length <= 1))
            {
              c(paramVarArgs[0]);
              break;
            }
            if (("openExportedFile".equals(paramString3)) && (paramVarArgs.length <= 1))
            {
              a(paramVarArgs[0]);
              break;
            }
            if (("txDocsStartExport".equals(paramString3)) && (paramVarArgs.length <= 1))
            {
              if ((this.mRuntime == null) || (this.mRuntime.a() == null)) {
                break;
              }
              if (badq.d(this.mRuntime.a()))
              {
                b(paramVarArgs[0]);
                break;
              }
              bbmy.a(this.mRuntime.a(), this.mRuntime.a().getString(2131628303), 0).a();
              break;
            }
            if (("voiceInputSetup".equals(paramString3)) && (paramVarArgs.length <= 1))
            {
              if (this.jdField_a_of_type_Amxm != null) {
                break;
              }
              this.jdField_a_of_type_Amxm = new amxm(this);
              this.jdField_a_of_type_Amxm.a();
              break;
            }
            boolean bool;
            if (("voiceInputStart".equals(paramString3)) && (paramVarArgs.length <= 1))
            {
              if (this.jdField_a_of_type_Amxm != null)
              {
                if (paramVarArgs.length == 1)
                {
                  try
                  {
                    paramJsBridgeListener = new JSONObject(paramVarArgs[0]).optString("callback");
                    bool = this.jdField_a_of_type_Amxm.a(paramJsBridgeListener);
                    return bool;
                  }
                  catch (Throwable paramJsBridgeListener)
                  {
                    QLog.e("DocxApiPlugin", 1, "VoiceInputHelper start error", paramJsBridgeListener);
                  }
                  break;
                }
                QLog.e("DocxApiPlugin", 1, "VoiceInputHelper start args error.");
                break;
              }
              QLog.e("DocxApiPlugin", 1, "VoiceInputHelper has destroyed, start failed.");
              break;
            }
            if (("voiceInputStop".equals(paramString3)) && (paramVarArgs.length <= 1))
            {
              if (this.jdField_a_of_type_Amxm == null) {
                break;
              }
              this.jdField_a_of_type_Amxm.b();
              break;
            }
            if (("cameraCheckPermission".equals(paramString3)) && (paramVarArgs.length <= 1))
            {
              if (this.jdField_a_of_type_Amxj == null) {
                this.jdField_a_of_type_Amxj = new amxj(this);
              }
              if (paramVarArgs.length == 1)
              {
                try
                {
                  paramJsBridgeListener = new JSONObject(paramVarArgs[0]).optString("callback");
                  bool = this.jdField_a_of_type_Amxj.a(paramJsBridgeListener);
                  return bool;
                }
                catch (Throwable paramJsBridgeListener)
                {
                  QLog.e("DocxApiPlugin", 1, "CameraHelper checkPermission error", paramJsBridgeListener);
                }
                break;
              }
              QLog.e("DocxApiPlugin", 1, "CameraHelper checkPermission args error.");
              break;
            }
            if ((!"getTcntDocData".equals(paramString3)) || (paramVarArgs.length > 1)) {
              break label1636;
            }
            try
            {
              paramString1 = new JSONObject(paramVarArgs[0]);
              paramJsBridgeListener = paramString1.optString("url");
              paramString1 = paramString1.optString("callback");
              ThreadManager.excute(new DocxApiPlugin.3(this, axfb.a(paramJsBridgeListener), paramString1, paramJsBridgeListener), 64, null, false);
            }
            catch (Exception paramJsBridgeListener)
            {
              QLog.e("DocxApiPlugin", 1, "JSONException ", paramJsBridgeListener);
            }
          }
          break;
          label1636:
          if ((!"delTcntDocData".equals(paramString3)) || (paramVarArgs.length > 1)) {
            break label1704;
          }
          try
          {
            ThreadManager.excute(new DocxApiPlugin.4(this, axfb.a(new JSONObject(paramVarArgs[0]).optString("url"))), 64, null, false);
          }
          catch (JSONException paramJsBridgeListener)
          {
            QLog.e("DocxApiPlugin", 1, "JSONException ", paramJsBridgeListener);
          }
        }
        break;
        label1704:
        if ((!"preFetchTcntDocData".equals(paramString3)) || (paramVarArgs.length > 1)) {
          break label1985;
        }
        paramString1 = ammf.a();
        if ((!paramString1.a()) || (!paramString1.b())) {
          return false;
        }
        a();
        try
        {
          paramString2 = new JSONObject(paramVarArgs[0]).optJSONArray("keys");
          if (paramString2 == null) {
            break;
          }
          paramJsBridgeListener = new ArrayList(paramString2.length());
          i = 0;
          while (i < paramString2.length())
          {
            paramJsBridgeListener.add(paramString2.getJSONObject(i).optString("doc_url"));
            i += 1;
          }
          if ((paramString1.c()) && (!paramJsBridgeListener.isEmpty()))
          {
            paramString1 = (String)paramJsBridgeListener.get(0);
            if (((FragmentActivity)this.mRuntime.a()).getSupportFragmentManager().findFragmentByTag("doc_preload") == null)
            {
              QLog.e("DocxApiPlugin", 1, "tendocpreload UnVisibleWebViewFragment create ");
              axfy.a(paramString1);
              paramString2 = new Intent();
              paramString2.putExtra("url", paramString1);
              paramString2.putExtra("hide_more_button", true);
              paramString2.putExtra("webStyle", "noBottomBar");
              paramString2.putExtra("isScreenOrientationPortrait", true);
              paramString2.putExtra("title", " ");
              paramString1 = UnVisibleWebViewFragment.a(paramString2);
              ((FragmentActivity)this.mRuntime.a()).getSupportFragmentManager().beginTransaction().add(paramString1, "doc_preload").commitAllowingStateLoss();
            }
          }
          a(paramJsBridgeListener);
        }
        catch (JSONException paramJsBridgeListener)
        {
          QLog.e("DocxApiPlugin", 1, "JSONException ", paramJsBridgeListener);
        }
      }
      break;
      label1985:
      if ((!"showShareView".equals(paramString3)) || (paramVarArgs.length > 1)) {
        break;
      }
      paramJsBridgeListener = (QQBrowserActivity)this.mRuntime.a();
      if ((paramJsBridgeListener == null) || (paramJsBridgeListener.b() == null)) {
        break;
      }
      paramJsBridgeListener = paramJsBridgeListener.b();
      if ((paramJsBridgeListener == null) || (!(paramJsBridgeListener instanceof TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment))) {
        break;
      }
      ((TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment)paramJsBridgeListener).am_();
      break;
      label2051:
      int i = -1;
    }
  }
  
  public void onActivityResult(Intent paramIntent, byte paramByte, int paramInt)
  {
    super.onActivityResult(paramIntent, paramByte, paramInt);
    int i;
    int j;
    if ((this.jdField_a_of_type_JavaLangString != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)))
    {
      paramIntent = "ok";
      if (paramByte != 17) {
        break label125;
      }
      paramIntent = "user canceld share panel";
      i = 0;
      j = 0;
    }
    label172:
    for (;;)
    {
      label44:
      paramIntent = String.format("{\"type\":%d,\"action\":%d,\"ec\":%d,\"em\":\"%s\"}", new Object[] { Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(paramInt), paramIntent });
      QLog.d("DocxApiPlugin", 2, "rsp json = " + paramIntent);
      callJs(this.jdField_a_of_type_JavaLangString, new String[] { paramIntent });
      return;
      label125:
      if ((paramByte == 18) || (paramByte == 52))
      {
        if (paramByte == 18) {}
        for (i = 1;; i = 2)
        {
          if (paramInt != 0) {
            break label172;
          }
          paramInt = -1;
          paramIntent = "user canceled";
          j = i;
          i = 0;
          break;
        }
        paramInt = 0;
        j = i;
        i = 2;
      }
      else if ((paramByte == 86) || (paramByte == 120))
      {
        if (paramByte == 86) {}
        for (i = 3;; i = 4) {
          switch (paramInt)
          {
          default: 
            j = i;
            i = 0;
            break label44;
          }
        }
        j = i;
        i = 2;
        continue;
        paramIntent = "err comm";
        j = i;
        i = 0;
        continue;
        paramIntent = "user canceled";
        j = i;
        i = 0;
        continue;
        paramIntent = "sent failed";
        j = i;
        i = 0;
        continue;
        paramIntent = "auth denied";
        j = i;
        i = 0;
        continue;
        paramIntent = "unsupport";
        j = i;
        i = 0;
        continue;
        paramIntent = "err ban";
        j = i;
        i = 0;
      }
      else
      {
        paramInt = 0;
        i = 0;
        j = 0;
      }
    }
  }
  
  public void onCreate()
  {
    super.onCreate();
    if (this.mRuntime == null) {}
    for (AppInterface localAppInterface = null;; localAppInterface = this.mRuntime.a())
    {
      amxm.a(localAppInterface);
      return;
    }
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_Amxe = null;
    if (this.jdField_a_of_type_Amxj != null)
    {
      this.jdField_a_of_type_Amxj.a();
      this.jdField_a_of_type_Amxj = null;
    }
    if (this.jdField_a_of_type_Amxm != null)
    {
      this.jdField_a_of_type_Amxm.a();
      this.jdField_a_of_type_Amxm = null;
    }
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aqrp
 * JD-Core Version:    0.7.0.1
 */