import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.activity.JoinDiscussionActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webviewplugin.WebViewJumpPlugin.4;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.stat.MttLoader;
import java.util.HashMap;
import java.util.Map;

public class bbey
  extends WebViewPlugin
{
  public static final String a;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
  WebView jdField_a_of_type_ComTencentSmttSdkWebView;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  private boolean c = true;
  
  static
  {
    jdField_a_of_type_JavaLangString = bbey.class.getSimpleName();
  }
  
  public bbey()
  {
    this.mPluginNameSpace = jdField_a_of_type_JavaLangString;
  }
  
  private Activity a()
  {
    for (Activity localActivity = this.mRuntime.a(); (localActivity != null) && ((localActivity instanceof BasePluginActivity)); localActivity = ((BasePluginActivity)localActivity).getOutActivity()) {}
    return localActivity;
  }
  
  private void a(Intent paramIntent)
  {
    if (this.mRuntime == null) {}
    do
    {
      return;
      if (this.mRuntime.a() != null)
      {
        this.mRuntime.a().startActivity(paramIntent);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.d("WebViewJumpPlugin", 2, "Activity is null");
  }
  
  private void b(String paramString)
  {
    Object localObject = this.mRuntime.a();
    if (localObject == null) {}
    do
    {
      return;
      ((Activity)localObject).finish();
      if (vvp.c(paramString))
      {
        localObject = new Intent((Context)localObject, JoinDiscussionActivity.class);
        ((Intent)localObject).putExtra("innerSig", paramString);
        a((Intent)localObject);
        return;
      }
      paramString = bade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Context)localObject, paramString);
    } while (paramString == null);
    paramString.c();
  }
  
  private void c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return;
      if ((paramString.startsWith("mqqapi://armap_entry/map?src_type=web&version=1&from_type=0&service_id=1")) || (paramString.startsWith("mqqapi://personal_tag/tag_list"))) {}
      for (int i = 1; i != 0; i = 0)
      {
        new Handler().postDelayed(new WebViewJumpPlugin.4(this), 2000L);
        return;
      }
    }
  }
  
  public void a(String paramString)
  {
    paramString = bade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.mRuntime.a(), paramString);
    if (paramString != null) {
      paramString.c();
    }
  }
  
  protected boolean a(String paramString, boolean paramBoolean)
  {
    boolean bool = true;
    if (TextUtils.isEmpty(paramString))
    {
      paramBoolean = false;
      return paramBoolean;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("KEY_PID", String.valueOf(50079));
    localHashMap.put("KEY_EUSESTAT", String.valueOf(5));
    paramString = MttLoader.getValidQBUrl(this.mRuntime.a(), paramString);
    int i = MttLoader.loadUrl(this.mRuntime.a(), paramString, localHashMap, null);
    if (paramBoolean)
    {
      if ((this.jdField_a_of_type_ComTencentSmttSdkWebView == null) && (QLog.isColorLevel()))
      {
        QLog.d("WebViewJumpPlugin", 2, "webview is null");
        return true;
      }
      if (4 != i) {
        break label125;
      }
      this.jdField_a_of_type_ComTencentSmttSdkWebView.loadUrl("http://appchannel.html5.qq.com/directdown?app=qqbrowser&channel=50079");
    }
    for (;;)
    {
      paramBoolean = bool;
      if (i == 0) {
        break;
      }
      return false;
      label125:
      if (5 == i) {
        this.jdField_a_of_type_ComTencentSmttSdkWebView.loadUrl("http://appchannel.html5.qq.com/directdown?app=qqbrowser&channel=50079");
      } else if (i != 0) {
        this.jdField_a_of_type_ComTencentSmttSdkWebView.loadUrl("http://appchannel.html5.qq.com/directdown?app=qqbrowser&channel=50079");
      }
    }
  }
  
  public boolean handleEvent(String paramString, long paramLong, Map<String, Object> paramMap)
  {
    if (paramLong == 2L) {
      this.c = true;
    }
    for (;;)
    {
      return false;
      if (paramLong == 8589934597L) {
        this.c = false;
      } else if (paramLong == 8589934601L)
      {
        if ((!TextUtils.isEmpty(paramString)) && ((paramString.contains("chatplay/hall")) || (paramString.contains("avwithstranger/avchathall")) || (paramString.contains("chatplay/avchathall"))) && (paramString.endsWith("#child")))
        {
          if ((paramString.contains("adtag=client.tab")) && (this.mRuntime != null) && (this.mRuntime.a() != null))
          {
            if (!(this.mRuntime.a() instanceof IphoneTitleBarActivity)) {
              break label178;
            }
            ((IphoneTitleBarActivity)this.mRuntime.a()).setLeftViewName(2131654132);
          }
          while ((this.mRuntime != null) && (this.mRuntime.a() != null) && (this.mRuntime.a().canGoBack()))
          {
            this.mRuntime.a().goBack();
            return true;
            label178:
            if (((this.mRuntime.a() instanceof bazk)) && (!bbdc.a()))
            {
              paramString = this.mRuntime.a();
              if ((paramString != null) && (paramString.a.a != null)) {
                paramString.a.a.setText(2131654132);
              }
            }
          }
        }
      }
      else if ((paramLong == 8589934594L) && (!TextUtils.isEmpty(paramString)) && ((paramString.contains("chatplay/hall")) || (paramString.contains("avwithstranger/avchathall")) || (paramString.contains("chatplay/avchathall"))) && (paramString.endsWith("#child")) && (paramString.contains("adtag=client.tab")) && (this.mRuntime != null) && (this.mRuntime.a() != null)) {
        if ((this.mRuntime.a() instanceof IphoneTitleBarActivity))
        {
          ((IphoneTitleBarActivity)this.mRuntime.a()).setLeftViewName(2131625011);
        }
        else if (((this.mRuntime.a() instanceof bazk)) && (!bbdc.a()))
        {
          paramString = this.mRuntime.a();
          if ((paramString != null) && (paramString.a.a != null)) {
            paramString.a.a.setText(2131625011);
          }
        }
      }
    }
  }
  
  /* Error */
  public boolean handleSchemaRequest(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 6
    //   3: invokestatic 58	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6: ifeq +52 -> 58
    //   9: aload_0
    //   10: getfield 243	bbey:TAG	Ljava/lang/String;
    //   13: iconst_2
    //   14: new 245	java/lang/StringBuilder
    //   17: dup
    //   18: invokespecial 246	java/lang/StringBuilder:<init>	()V
    //   21: ldc 248
    //   23: invokevirtual 252	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: aload_1
    //   27: invokevirtual 252	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: ldc 254
    //   32: invokevirtual 252	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: aload_2
    //   36: invokevirtual 252	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: ldc_w 256
    //   42: invokevirtual 252	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: aload_0
    //   46: getfield 29	bbey:c	Z
    //   49: invokevirtual 259	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   52: invokevirtual 262	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   55: invokestatic 66	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   58: aload_0
    //   59: getfield 29	bbey:c	Z
    //   62: ifne +9 -> 71
    //   65: iconst_0
    //   66: istore 5
    //   68: iload 5
    //   70: ireturn
    //   71: aload_1
    //   72: invokestatic 264	vvp:a	(Ljava/lang/String;)Z
    //   75: ifeq +12 -> 87
    //   78: aload_1
    //   79: invokestatic 267	vup:a	(Ljava/lang/String;)Z
    //   82: ifeq +5 -> 87
    //   85: iconst_0
    //   86: ireturn
    //   87: aconst_null
    //   88: astore 11
    //   90: aload_0
    //   91: invokespecial 268	bbey:a	()Landroid/app/Activity;
    //   94: astore 12
    //   96: aload 11
    //   98: astore_2
    //   99: aload 12
    //   101: ifnull +27 -> 128
    //   104: aload 12
    //   106: invokevirtual 272	android/app/Activity:getIntent	()Landroid/content/Intent;
    //   109: astore 12
    //   111: aload 11
    //   113: astore_2
    //   114: aload 12
    //   116: ifnull +12 -> 128
    //   119: aload 12
    //   121: ldc_w 274
    //   124: invokevirtual 278	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   127: astore_2
    //   128: aload_1
    //   129: ldc_w 280
    //   132: invokevirtual 112	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   135: ifeq +57 -> 192
    //   138: new 77	android/content/Intent
    //   141: dup
    //   142: ldc_w 282
    //   145: aload_1
    //   146: invokestatic 288	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   149: invokespecial 291	android/content/Intent:<init>	(Ljava/lang/String;Landroid/net/Uri;)V
    //   152: astore_1
    //   153: aload_1
    //   154: ldc_w 274
    //   157: aload_2
    //   158: invokevirtual 88	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   161: pop
    //   162: getstatic 295	balh:jdField_a_of_type_Boolean	Z
    //   165: ifne +20 -> 185
    //   168: invokestatic 300	bale:a	()Lbale;
    //   171: invokevirtual 301	bale:a	()Z
    //   174: ifeq +11 -> 185
    //   177: invokestatic 300	bale:a	()Lbale;
    //   180: aload_1
    //   181: invokevirtual 304	bale:a	(Landroid/content/Intent;)Landroid/content/Intent;
    //   184: pop
    //   185: aload_0
    //   186: aload_1
    //   187: invokespecial 90	bbey:a	(Landroid/content/Intent;)V
    //   190: iconst_1
    //   191: ireturn
    //   192: aload_1
    //   193: ldc_w 306
    //   196: invokevirtual 112	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   199: ifeq +118 -> 317
    //   202: new 77	android/content/Intent
    //   205: dup
    //   206: ldc_w 308
    //   209: invokespecial 310	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   212: astore_2
    //   213: aload_1
    //   214: ldc_w 312
    //   217: invokevirtual 316	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   220: istore 4
    //   222: iload 4
    //   224: istore_3
    //   225: iload 4
    //   227: iconst_m1
    //   228: if_icmpne +8 -> 236
    //   231: aload_1
    //   232: invokevirtual 320	java/lang/String:length	()I
    //   235: istore_3
    //   236: aload_2
    //   237: ldc_w 322
    //   240: aload_1
    //   241: aload_1
    //   242: ldc_w 324
    //   245: invokevirtual 316	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   248: iconst_1
    //   249: iadd
    //   250: iload_3
    //   251: invokevirtual 328	java/lang/String:substring	(II)Ljava/lang/String;
    //   254: invokevirtual 88	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   257: pop
    //   258: aload_1
    //   259: ldc_w 330
    //   262: invokevirtual 316	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   265: istore 4
    //   267: iload 4
    //   269: istore_3
    //   270: iload 4
    //   272: iconst_m1
    //   273: if_icmpne +10 -> 283
    //   276: aload_1
    //   277: invokevirtual 320	java/lang/String:length	()I
    //   280: iconst_1
    //   281: isub
    //   282: istore_3
    //   283: aload_2
    //   284: ldc_w 332
    //   287: aload_1
    //   288: iload_3
    //   289: iconst_1
    //   290: iadd
    //   291: aload_1
    //   292: invokevirtual 320	java/lang/String:length	()I
    //   295: invokevirtual 328	java/lang/String:substring	(II)Ljava/lang/String;
    //   298: invokevirtual 88	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   301: pop
    //   302: aload_2
    //   303: ldc_w 334
    //   306: invokevirtual 338	android/content/Intent:setType	(Ljava/lang/String;)Landroid/content/Intent;
    //   309: pop
    //   310: aload_0
    //   311: aload_2
    //   312: invokespecial 90	bbey:a	(Landroid/content/Intent;)V
    //   315: iconst_1
    //   316: ireturn
    //   317: aload_1
    //   318: ldc_w 340
    //   321: invokevirtual 112	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   324: ifeq +222 -> 546
    //   327: invokestatic 58	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   330: ifeq +31 -> 361
    //   333: aload_0
    //   334: getfield 243	bbey:TAG	Ljava/lang/String;
    //   337: iconst_2
    //   338: new 245	java/lang/StringBuilder
    //   341: dup
    //   342: invokespecial 246	java/lang/StringBuilder:<init>	()V
    //   345: ldc_w 342
    //   348: invokevirtual 252	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   351: aload_1
    //   352: invokevirtual 252	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   355: invokevirtual 262	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   358: invokestatic 66	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   361: aload_1
    //   362: ldc_w 344
    //   365: invokevirtual 348	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   368: astore 11
    //   370: aload 11
    //   372: ifnull +1124 -> 1496
    //   375: aload 11
    //   377: arraylength
    //   378: iconst_5
    //   379: if_icmplt +1117 -> 1496
    //   382: aload 11
    //   384: iconst_2
    //   385: aaload
    //   386: ldc_w 330
    //   389: invokevirtual 348	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   392: astore_2
    //   393: aload 11
    //   395: iconst_3
    //   396: aaload
    //   397: ldc_w 330
    //   400: invokevirtual 348	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   403: astore_1
    //   404: aload 11
    //   406: iconst_4
    //   407: aaload
    //   408: ldc_w 330
    //   411: invokevirtual 348	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   414: astore 11
    //   416: aload_2
    //   417: ifnull +1079 -> 1496
    //   420: aload_2
    //   421: arraylength
    //   422: iconst_2
    //   423: if_icmpne +1073 -> 1496
    //   426: aload_1
    //   427: ifnull +1069 -> 1496
    //   430: aload_1
    //   431: arraylength
    //   432: iconst_2
    //   433: if_icmpne +1063 -> 1496
    //   436: aload 11
    //   438: ifnull +1058 -> 1496
    //   441: aload 11
    //   443: arraylength
    //   444: iconst_2
    //   445: if_icmpne +1051 -> 1496
    //   448: aload_2
    //   449: iconst_1
    //   450: aaload
    //   451: astore_2
    //   452: aload 11
    //   454: iconst_1
    //   455: aaload
    //   456: invokestatic 354	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   459: lstore 7
    //   461: aload_1
    //   462: iconst_1
    //   463: aaload
    //   464: invokestatic 354	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   467: lstore 9
    //   469: new 77	android/content/Intent
    //   472: dup
    //   473: ldc_w 356
    //   476: invokespecial 310	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   479: astore_1
    //   480: aload_1
    //   481: aload_0
    //   482: getfield 37	bbey:mRuntime	Lbbac;
    //   485: invokevirtual 41	bbac:a	()Landroid/app/Activity;
    //   488: invokevirtual 359	android/app/Activity:getPackageName	()Ljava/lang/String;
    //   491: invokevirtual 362	android/content/Intent:setPackage	(Ljava/lang/String;)Landroid/content/Intent;
    //   494: pop
    //   495: aload_1
    //   496: ldc_w 364
    //   499: iconst_1
    //   500: invokevirtual 367	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   503: pop
    //   504: aload_1
    //   505: ldc_w 369
    //   508: aload_2
    //   509: invokevirtual 88	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   512: pop
    //   513: aload_1
    //   514: ldc_w 371
    //   517: lload 9
    //   519: invokevirtual 374	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   522: pop
    //   523: aload_1
    //   524: ldc_w 376
    //   527: lload 7
    //   529: invokevirtual 374	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   532: pop
    //   533: aload_0
    //   534: getfield 37	bbey:mRuntime	Lbbac;
    //   537: invokevirtual 41	bbac:a	()Landroid/app/Activity;
    //   540: aload_1
    //   541: invokevirtual 379	android/app/Activity:sendBroadcast	(Landroid/content/Intent;)V
    //   544: iconst_1
    //   545: ireturn
    //   546: aload_1
    //   547: ldc_w 381
    //   550: invokevirtual 112	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   553: ifeq +103 -> 656
    //   556: aload_0
    //   557: iconst_3
    //   558: invokevirtual 385	bbey:getRequestCode	(B)I
    //   561: istore_3
    //   562: iload 6
    //   564: istore 5
    //   566: iload_3
    //   567: iconst_m1
    //   568: if_icmpeq -500 -> 68
    //   571: iload 6
    //   573: istore 5
    //   575: aload_0
    //   576: getfield 387	bbey:b	Z
    //   579: ifne -511 -> 68
    //   582: aload_0
    //   583: iconst_1
    //   584: putfield 387	bbey:b	Z
    //   587: aload_0
    //   588: getfield 27	bbey:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   591: aload_0
    //   592: getfield 37	bbey:mRuntime	Lbbac;
    //   595: invokevirtual 41	bbac:a	()Landroid/app/Activity;
    //   598: aload_1
    //   599: invokestatic 95	bade:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Landroid/content/Context;Ljava/lang/String;)Lbacn;
    //   602: astore_1
    //   603: iload 6
    //   605: istore 5
    //   607: aload_1
    //   608: ifnull -540 -> 68
    //   611: aload_1
    //   612: ldc_w 389
    //   615: invokevirtual 391	bacn:a	(Ljava/lang/String;)V
    //   618: aload_1
    //   619: ldc_w 393
    //   622: iload_3
    //   623: invokestatic 139	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   626: invokevirtual 396	bacn:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   629: aload_1
    //   630: ldc_w 398
    //   633: invokestatic 403	com/tencent/mobileqq/vaswebviewplugin/QWalletPayJsPlugin:getPayAppInfo	()Ljava/lang/String;
    //   636: invokevirtual 396	bacn:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   639: aload_1
    //   640: invokevirtual 99	bacn:c	()Z
    //   643: pop
    //   644: aload_0
    //   645: iconst_1
    //   646: putfield 404	bbey:jdField_a_of_type_Boolean	Z
    //   649: aload_0
    //   650: iconst_0
    //   651: putfield 387	bbey:b	Z
    //   654: iconst_1
    //   655: ireturn
    //   656: aload_1
    //   657: invokestatic 264	vvp:a	(Ljava/lang/String;)Z
    //   660: ifne +13 -> 673
    //   663: aload_1
    //   664: ldc_w 406
    //   667: invokevirtual 112	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   670: ifeq +83 -> 753
    //   673: aload_0
    //   674: getfield 37	bbey:mRuntime	Lbbac;
    //   677: invokevirtual 41	bbac:a	()Landroid/app/Activity;
    //   680: astore_2
    //   681: iload 6
    //   683: istore 5
    //   685: aload_2
    //   686: ifnull -618 -> 68
    //   689: aload_0
    //   690: getfield 27	bbey:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   693: aload_2
    //   694: aload_1
    //   695: invokestatic 95	bade:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Landroid/content/Context;Ljava/lang/String;)Lbacn;
    //   698: astore_2
    //   699: aload_2
    //   700: ifnull +15 -> 715
    //   703: aload_2
    //   704: ldc_w 389
    //   707: invokevirtual 391	bacn:a	(Ljava/lang/String;)V
    //   710: aload_2
    //   711: invokevirtual 99	bacn:c	()Z
    //   714: pop
    //   715: iload 6
    //   717: istore 5
    //   719: aload_1
    //   720: ldc_w 408
    //   723: invokevirtual 112	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   726: ifeq -658 -> 68
    //   729: new 116	android/os/Handler
    //   732: dup
    //   733: invokespecial 117	android/os/Handler:<init>	()V
    //   736: new 410	com/tencent/mobileqq/webviewplugin/WebViewJumpPlugin$1
    //   739: dup
    //   740: aload_0
    //   741: invokespecial 411	com/tencent/mobileqq/webviewplugin/WebViewJumpPlugin$1:<init>	(Lbbey;)V
    //   744: ldc2_w 123
    //   747: invokevirtual 128	android/os/Handler:postDelayed	(Ljava/lang/Runnable;J)Z
    //   750: pop
    //   751: iconst_1
    //   752: ireturn
    //   753: aload_1
    //   754: ldc_w 413
    //   757: invokevirtual 112	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   760: ifeq +110 -> 870
    //   763: aload_1
    //   764: invokestatic 288	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   767: ldc_w 415
    //   770: invokevirtual 418	android/net/Uri:getQueryParameter	(Ljava/lang/String;)Ljava/lang/String;
    //   773: astore_1
    //   774: aload_1
    //   775: invokestatic 105	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   778: ifeq +5 -> 783
    //   781: iconst_0
    //   782: ireturn
    //   783: new 245	java/lang/StringBuilder
    //   786: dup
    //   787: invokespecial 246	java/lang/StringBuilder:<init>	()V
    //   790: ldc_w 420
    //   793: invokevirtual 252	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   796: aload_1
    //   797: invokevirtual 252	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   800: invokevirtual 262	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   803: astore_1
    //   804: aload_0
    //   805: getfield 37	bbey:mRuntime	Lbbac;
    //   808: invokevirtual 41	bbac:a	()Landroid/app/Activity;
    //   811: astore_2
    //   812: iload 6
    //   814: istore 5
    //   816: aload_2
    //   817: ifnull -749 -> 68
    //   820: aload_0
    //   821: getfield 27	bbey:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   824: aload_2
    //   825: aload_1
    //   826: invokestatic 95	bade:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Landroid/content/Context;Ljava/lang/String;)Lbacn;
    //   829: astore_1
    //   830: aload_1
    //   831: ifnull +15 -> 846
    //   834: aload_1
    //   835: ldc_w 389
    //   838: invokevirtual 391	bacn:a	(Ljava/lang/String;)V
    //   841: aload_1
    //   842: invokevirtual 99	bacn:c	()Z
    //   845: pop
    //   846: new 116	android/os/Handler
    //   849: dup
    //   850: invokespecial 117	android/os/Handler:<init>	()V
    //   853: new 422	com/tencent/mobileqq/webviewplugin/WebViewJumpPlugin$2
    //   856: dup
    //   857: aload_0
    //   858: invokespecial 423	com/tencent/mobileqq/webviewplugin/WebViewJumpPlugin$2:<init>	(Lbbey;)V
    //   861: ldc2_w 123
    //   864: invokevirtual 128	android/os/Handler:postDelayed	(Ljava/lang/Runnable;J)Z
    //   867: pop
    //   868: iconst_1
    //   869: ireturn
    //   870: aload_1
    //   871: ldc_w 425
    //   874: invokevirtual 112	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   877: ifeq +113 -> 990
    //   880: aload_0
    //   881: getfield 157	bbey:jdField_a_of_type_ComTencentSmttSdkWebView	Lcom/tencent/smtt/sdk/WebView;
    //   884: ifnonnull +19 -> 903
    //   887: invokestatic 58	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   890: ifeq +13 -> 903
    //   893: ldc 60
    //   895: iconst_2
    //   896: ldc 159
    //   898: invokestatic 66	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   901: iconst_1
    //   902: ireturn
    //   903: aload_0
    //   904: getfield 157	bbey:jdField_a_of_type_ComTencentSmttSdkWebView	Lcom/tencent/smtt/sdk/WebView;
    //   907: invokevirtual 428	com/tencent/smtt/sdk/WebView:getUrl	()Ljava/lang/String;
    //   910: astore 11
    //   912: aload 11
    //   914: invokestatic 105	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   917: ifne +71 -> 988
    //   920: aload_1
    //   921: iconst_0
    //   922: anewarray 109	java/lang/String
    //   925: invokestatic 433	mpw:b	(Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/String;
    //   928: astore_2
    //   929: aload_2
    //   930: astore_1
    //   931: aload_2
    //   932: invokevirtual 320	java/lang/String:length	()I
    //   935: sipush 512
    //   938: if_icmple +12 -> 950
    //   941: aload_2
    //   942: iconst_0
    //   943: sipush 512
    //   946: invokevirtual 328	java/lang/String:substring	(II)Ljava/lang/String;
    //   949: astore_1
    //   950: aconst_null
    //   951: ldc_w 435
    //   954: ldc_w 437
    //   957: ldc_w 439
    //   960: ldc_w 441
    //   963: ldc_w 443
    //   966: iconst_0
    //   967: iconst_1
    //   968: iconst_0
    //   969: aload 11
    //   971: iconst_0
    //   972: anewarray 109	java/lang/String
    //   975: invokestatic 433	mpw:b	(Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/String;
    //   978: aload_1
    //   979: ldc_w 439
    //   982: ldc_w 439
    //   985: invokestatic 448	awqx:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   988: iconst_0
    //   989: ireturn
    //   990: aload_1
    //   991: ldc_w 450
    //   994: invokevirtual 112	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   997: ifeq +41 -> 1038
    //   1000: aload_0
    //   1001: getfield 27	bbey:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1004: aload_0
    //   1005: getfield 37	bbey:mRuntime	Lbbac;
    //   1008: invokevirtual 41	bbac:a	()Landroid/app/Activity;
    //   1011: aload_1
    //   1012: invokestatic 95	bade:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Landroid/content/Context;Ljava/lang/String;)Lbacn;
    //   1015: astore_1
    //   1016: iload 6
    //   1018: istore 5
    //   1020: aload_1
    //   1021: ifnull -953 -> 68
    //   1024: aload_1
    //   1025: ldc_w 389
    //   1028: invokevirtual 391	bacn:a	(Ljava/lang/String;)V
    //   1031: aload_1
    //   1032: invokevirtual 99	bacn:c	()Z
    //   1035: pop
    //   1036: iconst_1
    //   1037: ireturn
    //   1038: aload_1
    //   1039: ldc_w 452
    //   1042: invokevirtual 112	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   1045: ifeq +41 -> 1086
    //   1048: aload_0
    //   1049: getfield 27	bbey:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1052: aload_0
    //   1053: getfield 37	bbey:mRuntime	Lbbac;
    //   1056: invokevirtual 41	bbac:a	()Landroid/app/Activity;
    //   1059: aload_1
    //   1060: invokestatic 95	bade:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Landroid/content/Context;Ljava/lang/String;)Lbacn;
    //   1063: astore_1
    //   1064: iload 6
    //   1066: istore 5
    //   1068: aload_1
    //   1069: ifnull -1001 -> 68
    //   1072: aload_1
    //   1073: ldc_w 389
    //   1076: invokevirtual 391	bacn:a	(Ljava/lang/String;)V
    //   1079: aload_1
    //   1080: invokevirtual 99	bacn:c	()Z
    //   1083: pop
    //   1084: iconst_1
    //   1085: ireturn
    //   1086: aload_1
    //   1087: ldc_w 452
    //   1090: invokevirtual 112	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   1093: ifeq +52 -> 1145
    //   1096: aload_0
    //   1097: getfield 27	bbey:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1100: aload_0
    //   1101: getfield 37	bbey:mRuntime	Lbbac;
    //   1104: invokevirtual 41	bbac:a	()Landroid/app/Activity;
    //   1107: aload_1
    //   1108: invokestatic 95	bade:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Landroid/content/Context;Ljava/lang/String;)Lbacn;
    //   1111: astore_1
    //   1112: iload 6
    //   1114: istore 5
    //   1116: aload_1
    //   1117: ifnull -1049 -> 68
    //   1120: aload_1
    //   1121: ldc_w 389
    //   1124: invokevirtual 391	bacn:a	(Ljava/lang/String;)V
    //   1127: aload_1
    //   1128: aload_0
    //   1129: getfield 37	bbey:mRuntime	Lbbac;
    //   1132: invokevirtual 455	bbac:a	()Lcom/tencent/common/app/AppInterface;
    //   1135: invokevirtual 458	bacn:a	(Lcom/tencent/common/app/AppInterface;)V
    //   1138: aload_1
    //   1139: invokevirtual 99	bacn:c	()Z
    //   1142: pop
    //   1143: iconst_1
    //   1144: ireturn
    //   1145: aload_1
    //   1146: ldc_w 460
    //   1149: invokevirtual 112	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   1152: ifeq +52 -> 1204
    //   1155: aload_0
    //   1156: getfield 27	bbey:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1159: aload_0
    //   1160: getfield 37	bbey:mRuntime	Lbbac;
    //   1163: invokevirtual 41	bbac:a	()Landroid/app/Activity;
    //   1166: aload_1
    //   1167: invokestatic 95	bade:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Landroid/content/Context;Ljava/lang/String;)Lbacn;
    //   1170: astore_1
    //   1171: iload 6
    //   1173: istore 5
    //   1175: aload_1
    //   1176: ifnull -1108 -> 68
    //   1179: aload_1
    //   1180: ldc_w 389
    //   1183: invokevirtual 391	bacn:a	(Ljava/lang/String;)V
    //   1186: aload_1
    //   1187: aload_0
    //   1188: getfield 37	bbey:mRuntime	Lbbac;
    //   1191: invokevirtual 455	bbac:a	()Lcom/tencent/common/app/AppInterface;
    //   1194: invokevirtual 458	bacn:a	(Lcom/tencent/common/app/AppInterface;)V
    //   1197: aload_1
    //   1198: invokevirtual 99	bacn:c	()Z
    //   1201: pop
    //   1202: iconst_1
    //   1203: ireturn
    //   1204: aload_1
    //   1205: ldc_w 462
    //   1208: invokevirtual 112	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   1211: ifne +13 -> 1224
    //   1214: aload_1
    //   1215: ldc_w 464
    //   1218: invokevirtual 112	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   1221: ifeq +74 -> 1295
    //   1224: new 77	android/content/Intent
    //   1227: dup
    //   1228: aload_0
    //   1229: getfield 37	bbey:mRuntime	Lbbac;
    //   1232: invokevirtual 41	bbac:a	()Landroid/app/Activity;
    //   1235: ldc_w 466
    //   1238: invokespecial 82	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   1241: astore 11
    //   1243: aload 11
    //   1245: aload_1
    //   1246: invokestatic 288	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   1249: invokevirtual 470	android/content/Intent:setData	(Landroid/net/Uri;)Landroid/content/Intent;
    //   1252: pop
    //   1253: aload 11
    //   1255: ldc_w 472
    //   1258: ldc_w 389
    //   1261: invokevirtual 88	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1264: pop
    //   1265: aload_2
    //   1266: invokestatic 105	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1269: ifne +13 -> 1282
    //   1272: aload 11
    //   1274: ldc_w 274
    //   1277: aload_2
    //   1278: invokevirtual 88	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1281: pop
    //   1282: aload_0
    //   1283: aload 11
    //   1285: invokespecial 90	bbey:a	(Landroid/content/Intent;)V
    //   1288: aload_0
    //   1289: aload_1
    //   1290: invokespecial 474	bbey:c	(Ljava/lang/String;)V
    //   1293: iconst_1
    //   1294: ireturn
    //   1295: aload_1
    //   1296: ldc_w 476
    //   1299: invokevirtual 112	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   1302: ifeq +86 -> 1388
    //   1305: iload 6
    //   1307: istore 5
    //   1309: aload_0
    //   1310: aload_1
    //   1311: iconst_0
    //   1312: invokevirtual 478	bbey:a	(Ljava/lang/String;Z)Z
    //   1315: ifne -1247 -> 68
    //   1318: iload 6
    //   1320: istore 5
    //   1322: aload_0
    //   1323: getfield 37	bbey:mRuntime	Lbbac;
    //   1326: ifnull -1258 -> 68
    //   1329: iload 6
    //   1331: istore 5
    //   1333: aload_0
    //   1334: getfield 37	bbey:mRuntime	Lbbac;
    //   1337: invokevirtual 41	bbac:a	()Landroid/app/Activity;
    //   1340: ifnull -1272 -> 68
    //   1343: aload_0
    //   1344: getfield 37	bbey:mRuntime	Lbbac;
    //   1347: invokevirtual 41	bbac:a	()Landroid/app/Activity;
    //   1350: aload_1
    //   1351: invokestatic 151	com/tencent/smtt/sdk/stat/MttLoader:getValidQBUrl	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   1354: astore_1
    //   1355: aload_0
    //   1356: getfield 157	bbey:jdField_a_of_type_ComTencentSmttSdkWebView	Lcom/tencent/smtt/sdk/WebView;
    //   1359: ifnonnull +19 -> 1378
    //   1362: invokestatic 58	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1365: ifeq +13 -> 1378
    //   1368: ldc 60
    //   1370: iconst_2
    //   1371: ldc 159
    //   1373: invokestatic 66	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1376: iconst_1
    //   1377: ireturn
    //   1378: aload_0
    //   1379: getfield 157	bbey:jdField_a_of_type_ComTencentSmttSdkWebView	Lcom/tencent/smtt/sdk/WebView;
    //   1382: aload_1
    //   1383: invokevirtual 165	com/tencent/smtt/sdk/WebView:loadUrl	(Ljava/lang/String;)V
    //   1386: iconst_1
    //   1387: ireturn
    //   1388: aload_1
    //   1389: ldc_w 480
    //   1392: invokevirtual 112	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   1395: ifne +10 -> 1405
    //   1398: aload_1
    //   1399: invokestatic 482	vvp:b	(Ljava/lang/String;)Z
    //   1402: ifeq +10 -> 1412
    //   1405: aload_0
    //   1406: aload_1
    //   1407: invokespecial 484	bbey:b	(Ljava/lang/String;)V
    //   1410: iconst_1
    //   1411: ireturn
    //   1412: aload_1
    //   1413: ldc_w 486
    //   1416: invokevirtual 112	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   1419: ifeq +44 -> 1463
    //   1422: new 77	android/content/Intent
    //   1425: dup
    //   1426: ldc_w 308
    //   1429: aload_1
    //   1430: invokestatic 288	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   1433: invokespecial 291	android/content/Intent:<init>	(Ljava/lang/String;Landroid/net/Uri;)V
    //   1436: astore_1
    //   1437: aload_1
    //   1438: ldc_w 487
    //   1441: invokevirtual 491	android/content/Intent:addFlags	(I)Landroid/content/Intent;
    //   1444: pop
    //   1445: aload_1
    //   1446: ldc_w 472
    //   1449: ldc_w 389
    //   1452: invokevirtual 88	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1455: pop
    //   1456: aload_0
    //   1457: aload_1
    //   1458: invokespecial 90	bbey:a	(Landroid/content/Intent;)V
    //   1461: iconst_1
    //   1462: ireturn
    //   1463: aload_1
    //   1464: ldc_w 493
    //   1467: invokevirtual 112	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   1470: ifeq +28 -> 1498
    //   1473: aload_0
    //   1474: getfield 37	bbey:mRuntime	Lbbac;
    //   1477: invokevirtual 41	bbac:a	()Landroid/app/Activity;
    //   1480: astore_1
    //   1481: aload_1
    //   1482: ifnull +14 -> 1496
    //   1485: aload_1
    //   1486: sipush 8213
    //   1489: invokevirtual 496	android/app/Activity:setResult	(I)V
    //   1492: aload_1
    //   1493: invokevirtual 70	android/app/Activity:finish	()V
    //   1496: iconst_0
    //   1497: ireturn
    //   1498: aload_1
    //   1499: ldc_w 498
    //   1502: invokevirtual 112	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   1505: ifeq +11 -> 1516
    //   1508: aload_0
    //   1509: aload_1
    //   1510: invokevirtual 499	bbey:a	(Ljava/lang/String;)V
    //   1513: goto -17 -> 1496
    //   1516: aload_1
    //   1517: ldc_w 501
    //   1520: invokevirtual 112	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   1523: ifeq +236 -> 1759
    //   1526: aload_1
    //   1527: invokestatic 506	befm:a	(Ljava/lang/String;)Ljava/util/Map;
    //   1530: astore_2
    //   1531: aload_2
    //   1532: ldc_w 369
    //   1535: invokeinterface 512 2 0
    //   1540: ifeq +178 -> 1718
    //   1543: aload_2
    //   1544: ldc_w 369
    //   1547: invokeinterface 516 2 0
    //   1552: checkcast 109	java/lang/String
    //   1555: astore_1
    //   1556: aload_1
    //   1557: invokestatic 354	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   1560: lstore 7
    //   1562: invokestatic 520	bfpw:a	()Ljava/lang/String;
    //   1565: astore_1
    //   1566: invokestatic 58	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1569: ifeq +42 -> 1611
    //   1572: aload_0
    //   1573: getfield 243	bbey:TAG	Ljava/lang/String;
    //   1576: iconst_2
    //   1577: new 245	java/lang/StringBuilder
    //   1580: dup
    //   1581: invokespecial 246	java/lang/StringBuilder:<init>	()V
    //   1584: ldc_w 522
    //   1587: invokevirtual 252	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1590: lload 7
    //   1592: invokevirtual 525	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1595: ldc_w 527
    //   1598: invokevirtual 252	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1601: aload_1
    //   1602: invokevirtual 252	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1605: invokevirtual 262	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1608: invokestatic 66	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1611: aload_0
    //   1612: getfield 37	bbey:mRuntime	Lbbac;
    //   1615: invokevirtual 41	bbac:a	()Landroid/app/Activity;
    //   1618: astore_2
    //   1619: new 77	android/content/Intent
    //   1622: dup
    //   1623: invokespecial 528	android/content/Intent:<init>	()V
    //   1626: astore 11
    //   1628: aload 11
    //   1630: ldc_w 530
    //   1633: lload 7
    //   1635: invokevirtual 374	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   1638: pop
    //   1639: aload 11
    //   1641: ldc_w 532
    //   1644: ldc_w 534
    //   1647: invokevirtual 88	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1650: pop
    //   1651: aload 11
    //   1653: ldc_w 536
    //   1656: aload_1
    //   1657: invokevirtual 88	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1660: pop
    //   1661: aload 11
    //   1663: ldc_w 538
    //   1666: invokestatic 543	cooperation/qzone/QzonePluginProxyActivity:a	(Landroid/content/Intent;Ljava/lang/String;)V
    //   1669: aload_2
    //   1670: aload_0
    //   1671: getfield 37	bbey:mRuntime	Lbbac;
    //   1674: invokevirtual 455	bbac:a	()Lcom/tencent/common/app/AppInterface;
    //   1677: invokevirtual 548	com/tencent/common/app/AppInterface:getAccount	()Ljava/lang/String;
    //   1680: aload 11
    //   1682: iconst_0
    //   1683: invokestatic 551	cooperation/qzone/QzonePluginProxyActivity:a	(Landroid/app/Activity;Ljava/lang/String;Landroid/content/Intent;I)V
    //   1686: new 116	android/os/Handler
    //   1689: dup
    //   1690: invokespecial 117	android/os/Handler:<init>	()V
    //   1693: new 553	com/tencent/mobileqq/webviewplugin/WebViewJumpPlugin$3
    //   1696: dup
    //   1697: aload_0
    //   1698: invokespecial 554	com/tencent/mobileqq/webviewplugin/WebViewJumpPlugin$3:<init>	(Lbbey;)V
    //   1701: ldc2_w 123
    //   1704: invokevirtual 128	android/os/Handler:postDelayed	(Ljava/lang/Runnable;J)Z
    //   1707: pop
    //   1708: iconst_1
    //   1709: ireturn
    //   1710: astore_1
    //   1711: aload_1
    //   1712: invokevirtual 557	java/lang/NumberFormatException:printStackTrace	()V
    //   1715: goto -219 -> 1496
    //   1718: aload_1
    //   1719: bipush 63
    //   1721: invokevirtual 561	java/lang/String:lastIndexOf	(I)I
    //   1724: istore_3
    //   1725: iload_3
    //   1726: iconst_m1
    //   1727: if_icmpeq +18 -> 1745
    //   1730: aload_1
    //   1731: ldc_w 501
    //   1734: invokevirtual 320	java/lang/String:length	()I
    //   1737: iload_3
    //   1738: invokevirtual 328	java/lang/String:substring	(II)Ljava/lang/String;
    //   1741: astore_1
    //   1742: goto -186 -> 1556
    //   1745: aload_1
    //   1746: ldc_w 501
    //   1749: invokevirtual 320	java/lang/String:length	()I
    //   1752: invokevirtual 563	java/lang/String:substring	(I)Ljava/lang/String;
    //   1755: astore_1
    //   1756: goto -200 -> 1556
    //   1759: aload_1
    //   1760: ldc_w 565
    //   1763: invokevirtual 112	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   1766: ifeq +16 -> 1782
    //   1769: aload_0
    //   1770: getfield 37	bbey:mRuntime	Lbbac;
    //   1773: invokevirtual 41	bbac:a	()Landroid/app/Activity;
    //   1776: ifnull -280 -> 1496
    //   1779: goto -283 -> 1496
    //   1782: aload_1
    //   1783: ldc_w 567
    //   1786: invokevirtual 112	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   1789: ifeq -293 -> 1496
    //   1792: aload_0
    //   1793: getfield 27	bbey:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1796: aload_0
    //   1797: getfield 37	bbey:mRuntime	Lbbac;
    //   1800: invokevirtual 41	bbac:a	()Landroid/app/Activity;
    //   1803: aload_1
    //   1804: invokestatic 95	bade:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Landroid/content/Context;Ljava/lang/String;)Lbacn;
    //   1807: astore_1
    //   1808: aload_1
    //   1809: ifnull -313 -> 1496
    //   1812: aload_1
    //   1813: invokevirtual 99	bacn:c	()Z
    //   1816: pop
    //   1817: goto -321 -> 1496
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1820	0	this	bbey
    //   0	1820	1	paramString1	String
    //   0	1820	2	paramString2	String
    //   224	1514	3	i	int
    //   220	54	4	j	int
    //   66	1266	5	bool1	boolean
    //   1	1329	6	bool2	boolean
    //   459	1175	7	l1	long
    //   467	51	9	l2	long
    //   88	1593	11	localObject1	Object
    //   94	26	12	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   1556	1611	1710	java/lang/NumberFormatException
    //   1611	1708	1710	java/lang/NumberFormatException
  }
  
  public void onActivityReady()
  {
    if ((this.mRuntime.a() instanceof QQAppInterface)) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)this.mRuntime.a());
    }
    this.jdField_a_of_type_ComTencentSmttSdkWebView = this.mRuntime.a();
  }
  
  public void onActivityResult(Intent paramIntent, byte paramByte, int paramInt)
  {
    if (paramByte == 3)
    {
      if (paramInt != -1) {
        break label129;
      }
      if ((this.jdField_a_of_type_Boolean) && (paramIntent != null) && (this.jdField_a_of_type_ComTencentSmttSdkWebView != null))
      {
        str = paramIntent.getStringExtra("callback_type");
        if (!"javascript".equals(str)) {
          break label79;
        }
        callJs(paramIntent.getStringExtra("callback_name"), new String[] { paramIntent.getStringExtra("callback_data") });
      }
    }
    label79:
    while (paramInt != 0)
    {
      String str;
      for (;;)
      {
        this.jdField_a_of_type_Boolean = false;
        return;
        if ("url".equals(str))
        {
          if ((this.jdField_a_of_type_ComTencentSmttSdkWebView == null) && (QLog.isColorLevel()))
          {
            QLog.d("WebViewJumpPlugin", 2, "webview is null");
            return;
          }
          this.jdField_a_of_type_ComTencentSmttSdkWebView.loadUrl(paramIntent.getStringExtra("callback_url"));
        }
      }
    }
    label129:
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void onCreate()
  {
    wis.a().a();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    wis.a().b();
  }
  
  public void onWebViewCreated(CustomWebView paramCustomWebView)
  {
    super.onWebViewCreated(paramCustomWebView);
    this.jdField_a_of_type_ComTencentSmttSdkWebView = paramCustomWebView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     bbey
 * JD-Core Version:    0.7.0.1
 */