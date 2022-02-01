import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.text.TextUtils;
import android.widget.ImageView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.AddFriendLogicActivity;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.mobileqq.troop.data.VideoUploadTask;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppActivity;
import org.json.JSONException;
import org.json.JSONObject;

public class awhv
  extends WebViewPlugin
{
  int jdField_a_of_type_Int;
  aasb jdField_a_of_type_Aasb = null;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  aojs jdField_a_of_type_Aojs = new awhx(this);
  VideoUploadTask jdField_a_of_type_ComTencentMobileqqTroopDataVideoUploadTask;
  String jdField_a_of_type_JavaLangString;
  AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  int jdField_b_of_type_Int;
  aasb jdField_b_of_type_Aasb;
  String jdField_b_of_type_JavaLangString;
  String c;
  String d;
  String e;
  
  public awhv()
  {
    this.mPluginNameSpace = "troopApi";
  }
  
  private Context a()
  {
    for (Activity localActivity = this.mRuntime.a(); (localActivity != null) && ((localActivity instanceof BasePluginActivity)); localActivity = ((BasePluginActivity)localActivity).getOutActivity()) {}
    return localActivity;
  }
  
  private String a(String paramString)
  {
    String str;
    if (paramString != null)
    {
      str = paramString;
      if (!"Unknown".equals(paramString)) {}
    }
    else
    {
      str = "";
    }
    return str;
  }
  
  private void a(int paramInt)
  {
    a(paramInt, 0);
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    if (this.mRuntime.a() != null) {
      QQToast.a(this.mRuntime.a(), paramInt2, this.mRuntime.a().getString(paramInt1), 0).b(this.mRuntime.a().getResources().getDimensionPixelSize(2131299011));
    }
  }
  
  private void a(SosoInterface.SosoLbsInfo paramSosoLbsInfo, String paramString)
  {
    if ((paramSosoLbsInfo != null) && (paramSosoLbsInfo.a != null))
    {
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("lat", paramSosoLbsInfo.a.jdField_a_of_type_Double);
        localJSONObject.put("lon", paramSosoLbsInfo.a.b);
        localJSONObject.put("nation", a(paramSosoLbsInfo.a.c));
        localJSONObject.put("province", a(paramSosoLbsInfo.a.d));
        localJSONObject.put("city", a(paramSosoLbsInfo.a.e));
        localJSONObject.put("district", a(paramSosoLbsInfo.a.g));
        callJs(paramString, new String[] { "0", localJSONObject.toString() });
        return;
      }
      catch (Exception paramSosoLbsInfo)
      {
        QLog.e(this.TAG, 1, "onLocationFinish Failed!", paramSosoLbsInfo);
        callJs(paramString, new String[] { "-5", "{}" });
        return;
      }
    }
    callJs(paramString, new String[] { "-4", "{}" });
  }
  
  private void a(TroopInfo paramTroopInfo)
  {
    this.jdField_a_of_type_Aasb.a(paramTroopInfo.troopuin, this.jdField_b_of_type_Int, this.e);
  }
  
  private void b(TroopInfo paramTroopInfo)
  {
    if (paramTroopInfo.cGroupOption != 3)
    {
      Intent localIntent = AddFriendLogicActivity.a(a(), paramTroopInfo.troopuin, paramTroopInfo.getTroopName(), paramTroopInfo.cGroupOption, this.jdField_b_of_type_Int, paramTroopInfo.joinTroopQuestion, paramTroopInfo.joinTroopAnswer, null, this.c, this.d);
      this.jdField_a_of_type_Int = paramTroopInfo.cGroupOption;
      startActivityForResult(localIntent, (byte)3);
      return;
    }
    this.jdField_a_of_type_Int = -1;
    a(2131718941);
  }
  
  void a()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true))
    {
      this.jdField_a_of_type_Aasb = aasb.a();
      this.jdField_a_of_type_Aasb.a();
    }
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "getPois:" + paramString);
    }
    if (this.mRuntime.a() == null) {
      if (QLog.isColorLevel()) {
        QLog.w(this.TAG, 2, "getWebView()==null, return");
      }
    }
    Activity localActivity;
    String str;
    do
    {
      for (;;)
      {
        return;
        localActivity = this.mRuntime.a();
        if ((localActivity == null) || (localActivity.isFinishing()))
        {
          if (QLog.isColorLevel()) {
            QLog.w(this.TAG, 2, "context==null || isFinishing, return");
          }
        }
        else
        {
          str = paramString;
          if (paramString.charAt(0) == '{') {}
          try
          {
            str = new JSONObject(paramString).getString("callback");
            if (!TextUtils.isEmpty(str))
            {
              if (!(localActivity instanceof AppActivity)) {
                break label237;
              }
              paramString = apch.a("webview");
              if ((paramString == null) || (paramString.a == null) || (paramString.a.jdField_a_of_type_JavaUtilList == null) || (paramString.a.jdField_a_of_type_JavaUtilList.size() <= 0)) {
                break label209;
              }
              a(paramString, str);
              return;
            }
          }
          catch (JSONException paramString) {}
        }
      }
    } while (!QLog.isColorLevel());
    QLog.w(this.TAG, 2, "getLocation exception:", paramString);
    return;
    label209:
    ((AppActivity)localActivity).requestPermissions(new awhy(this, str), 1, new String[] { "android.permission.ACCESS_FINE_LOCATION" });
    return;
    label237:
    callJs(str, new String[] { "-4", "{}" });
  }
  
  /* Error */
  public boolean handleJsRequest(com.tencent.mobileqq.webview.swift.JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    // Byte code:
    //   0: ldc 38
    //   2: aload_3
    //   3: invokevirtual 69	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   6: ifne +5 -> 11
    //   9: iconst_0
    //   10: ireturn
    //   11: ldc_w 323
    //   14: aload 4
    //   16: invokevirtual 69	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   19: ifeq +5 -> 24
    //   22: iconst_1
    //   23: ireturn
    //   24: ldc_w 325
    //   27: aload 4
    //   29: invokevirtual 69	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   32: ifne -10 -> 22
    //   35: ldc_w 327
    //   38: aload 4
    //   40: invokevirtual 69	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   43: ifeq +136 -> 179
    //   46: new 121	org/json/JSONObject
    //   49: dup
    //   50: aload 5
    //   52: iconst_0
    //   53: aaload
    //   54: invokespecial 274	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   57: astore_3
    //   58: invokestatic 243	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   61: ifeq +30 -> 91
    //   64: ldc_w 329
    //   67: iconst_2
    //   68: new 245	java/lang/StringBuilder
    //   71: dup
    //   72: invokespecial 246	java/lang/StringBuilder:<init>	()V
    //   75: ldc_w 331
    //   78: invokevirtual 252	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: aload_3
    //   82: invokevirtual 334	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   85: invokevirtual 253	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   88: invokestatic 255	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   91: aload_3
    //   92: ldc_w 336
    //   95: invokevirtual 339	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   98: astore_1
    //   99: aload_3
    //   100: ldc_w 341
    //   103: invokevirtual 339	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   106: astore_2
    //   107: aload_3
    //   108: ldc_w 343
    //   111: invokevirtual 347	org/json/JSONObject:optLong	(Ljava/lang/String;)J
    //   114: lstore 8
    //   116: aload_3
    //   117: ldc_w 349
    //   120: invokevirtual 347	org/json/JSONObject:optLong	(Ljava/lang/String;)J
    //   123: lstore 10
    //   125: aload_3
    //   126: ldc_w 276
    //   129: invokevirtual 339	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   132: astore_3
    //   133: aload_0
    //   134: getfield 29	awhv:jdField_a_of_type_Aasb	Laasb;
    //   137: aload_1
    //   138: aload_2
    //   139: new 351	awhw
    //   142: dup
    //   143: aload_0
    //   144: lload 8
    //   146: lload 10
    //   148: aload_3
    //   149: invokespecial 354	awhw:<init>	(Lawhv;JJLjava/lang/String;)V
    //   152: invokevirtual 357	aasb:b	(Ljava/lang/String;Ljava/lang/String;Laasd;)V
    //   155: goto -133 -> 22
    //   158: astore_1
    //   159: invokestatic 243	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   162: ifeq -140 -> 22
    //   165: ldc_w 329
    //   168: iconst_2
    //   169: ldc_w 359
    //   172: aload_1
    //   173: invokestatic 306	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   176: goto -154 -> 22
    //   179: ldc_w 361
    //   182: aload 4
    //   184: invokevirtual 69	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   187: ifeq +382 -> 569
    //   190: new 121	org/json/JSONObject
    //   193: dup
    //   194: aload 5
    //   196: iconst_0
    //   197: aaload
    //   198: invokespecial 274	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   201: astore_2
    //   202: invokestatic 243	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   205: ifeq +30 -> 235
    //   208: ldc_w 363
    //   211: iconst_2
    //   212: new 245	java/lang/StringBuilder
    //   215: dup
    //   216: invokespecial 246	java/lang/StringBuilder:<init>	()V
    //   219: ldc_w 365
    //   222: invokevirtual 252	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   225: aload_2
    //   226: invokevirtual 334	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   229: invokevirtual 253	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   232: invokestatic 255	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   235: aload_2
    //   236: ldc_w 336
    //   239: invokevirtual 339	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   242: astore_1
    //   243: aload_2
    //   244: ldc_w 367
    //   247: invokevirtual 339	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   250: astore_2
    //   251: invokestatic 372	bftp:a	()Lbftp;
    //   254: aload_1
    //   255: aload_2
    //   256: invokevirtual 375	bftp:a	(Ljava/lang/String;Ljava/lang/String;)Z
    //   259: ifeq -237 -> 22
    //   262: aload_0
    //   263: getfield 47	awhv:mRuntime	Lbioy;
    //   266: invokevirtual 52	bioy:a	()Landroid/app/Activity;
    //   269: astore_2
    //   270: aload_0
    //   271: getfield 47	awhv:mRuntime	Lbioy;
    //   274: invokevirtual 378	bioy:a	()Lcom/tencent/mobileqq/webview/swift/WebViewFragment;
    //   277: astore_1
    //   278: aload_2
    //   279: ifnull +155 -> 434
    //   282: aload_2
    //   283: instanceof 380
    //   286: ifeq +148 -> 434
    //   289: aload_2
    //   290: checkcast 380	com/tencent/biz/webviewbase/AbsBaseWebViewActivity
    //   293: astore_1
    //   294: aload_1
    //   295: getfield 383	com/tencent/biz/webviewbase/AbsBaseWebViewActivity:rightViewImg	Landroid/widget/ImageView;
    //   298: iconst_0
    //   299: invokevirtual 388	android/widget/ImageView:setVisibility	(I)V
    //   302: aload_0
    //   303: new 385	android/widget/ImageView
    //   306: dup
    //   307: aload_1
    //   308: invokespecial 391	android/widget/ImageView:<init>	(Landroid/content/Context;)V
    //   311: putfield 393	awhv:jdField_a_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   314: aload_1
    //   315: ldc_w 394
    //   318: invokevirtual 398	com/tencent/biz/webviewbase/AbsBaseWebViewActivity:findViewById	(I)Landroid/view/View;
    //   321: checkcast 400	android/widget/RelativeLayout
    //   324: astore_2
    //   325: aload_2
    //   326: ifnull -304 -> 22
    //   329: new 402	android/widget/RelativeLayout$LayoutParams
    //   332: dup
    //   333: bipush 254
    //   335: bipush 254
    //   337: invokespecial 404	android/widget/RelativeLayout$LayoutParams:<init>	(II)V
    //   340: astore_3
    //   341: aload_3
    //   342: bipush 7
    //   344: ldc_w 405
    //   347: invokevirtual 408	android/widget/RelativeLayout$LayoutParams:addRule	(II)V
    //   350: aload_3
    //   351: iconst_0
    //   352: ldc_w 409
    //   355: aload_1
    //   356: invokevirtual 410	com/tencent/biz/webviewbase/AbsBaseWebViewActivity:getResources	()Landroid/content/res/Resources;
    //   359: invokestatic 415	agej:a	(FLandroid/content/res/Resources;)I
    //   362: ldc_w 409
    //   365: aload_1
    //   366: invokevirtual 410	com/tencent/biz/webviewbase/AbsBaseWebViewActivity:getResources	()Landroid/content/res/Resources;
    //   369: invokestatic 415	agej:a	(FLandroid/content/res/Resources;)I
    //   372: iconst_0
    //   373: invokevirtual 419	android/widget/RelativeLayout$LayoutParams:setMargins	(IIII)V
    //   376: aload_0
    //   377: getfield 393	awhv:jdField_a_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   380: aload_3
    //   381: invokevirtual 423	android/widget/ImageView:setLayoutParams	(Landroid/view/ViewGroup$LayoutParams;)V
    //   384: aload_0
    //   385: getfield 393	awhv:jdField_a_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   388: iconst_0
    //   389: invokevirtual 388	android/widget/ImageView:setVisibility	(I)V
    //   392: aload_0
    //   393: getfield 393	awhv:jdField_a_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   396: ldc_w 424
    //   399: invokevirtual 427	android/widget/ImageView:setImageResource	(I)V
    //   402: aload_2
    //   403: aload_0
    //   404: getfield 393	awhv:jdField_a_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   407: invokevirtual 431	android/widget/RelativeLayout:addView	(Landroid/view/View;)V
    //   410: goto -388 -> 22
    //   413: astore_1
    //   414: invokestatic 243	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   417: ifeq -395 -> 22
    //   420: ldc_w 363
    //   423: iconst_2
    //   424: ldc_w 433
    //   427: aload_1
    //   428: invokestatic 306	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   431: goto -409 -> 22
    //   434: aload_1
    //   435: ifnull -413 -> 22
    //   438: aload_1
    //   439: getfield 439	com/tencent/mobileqq/webview/swift/WebViewFragment:mSwiftTitleUI	Lbinq;
    //   442: getfield 442	binq:jdField_a_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   445: iconst_0
    //   446: invokevirtual 388	android/widget/ImageView:setVisibility	(I)V
    //   449: aload_0
    //   450: new 385	android/widget/ImageView
    //   453: dup
    //   454: aload_1
    //   455: invokevirtual 446	com/tencent/mobileqq/webview/swift/WebViewFragment:getActivity	()Landroid/support/v4/app/FragmentActivity;
    //   458: invokespecial 391	android/widget/ImageView:<init>	(Landroid/content/Context;)V
    //   461: putfield 393	awhv:jdField_a_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   464: aload_1
    //   465: getfield 450	com/tencent/mobileqq/webview/swift/WebViewFragment:mUIStyleHandler	Lbirg;
    //   468: getfield 455	birg:d	Landroid/view/ViewGroup;
    //   471: ldc_w 394
    //   474: invokevirtual 458	android/view/ViewGroup:findViewById	(I)Landroid/view/View;
    //   477: checkcast 400	android/widget/RelativeLayout
    //   480: astore_2
    //   481: aload_2
    //   482: ifnull -460 -> 22
    //   485: new 402	android/widget/RelativeLayout$LayoutParams
    //   488: dup
    //   489: bipush 254
    //   491: bipush 254
    //   493: invokespecial 404	android/widget/RelativeLayout$LayoutParams:<init>	(II)V
    //   496: astore_3
    //   497: aload_3
    //   498: bipush 7
    //   500: ldc_w 405
    //   503: invokevirtual 408	android/widget/RelativeLayout$LayoutParams:addRule	(II)V
    //   506: aload_3
    //   507: iconst_0
    //   508: ldc_w 409
    //   511: aload_1
    //   512: invokevirtual 459	com/tencent/mobileqq/webview/swift/WebViewFragment:getResources	()Landroid/content/res/Resources;
    //   515: invokestatic 415	agej:a	(FLandroid/content/res/Resources;)I
    //   518: ldc_w 409
    //   521: aload_1
    //   522: invokevirtual 459	com/tencent/mobileqq/webview/swift/WebViewFragment:getResources	()Landroid/content/res/Resources;
    //   525: invokestatic 415	agej:a	(FLandroid/content/res/Resources;)I
    //   528: iconst_0
    //   529: invokevirtual 419	android/widget/RelativeLayout$LayoutParams:setMargins	(IIII)V
    //   532: aload_0
    //   533: getfield 393	awhv:jdField_a_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   536: aload_3
    //   537: invokevirtual 423	android/widget/ImageView:setLayoutParams	(Landroid/view/ViewGroup$LayoutParams;)V
    //   540: aload_0
    //   541: getfield 393	awhv:jdField_a_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   544: iconst_0
    //   545: invokevirtual 388	android/widget/ImageView:setVisibility	(I)V
    //   548: aload_0
    //   549: getfield 393	awhv:jdField_a_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   552: ldc_w 424
    //   555: invokevirtual 427	android/widget/ImageView:setImageResource	(I)V
    //   558: aload_2
    //   559: aload_0
    //   560: getfield 393	awhv:jdField_a_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   563: invokevirtual 431	android/widget/RelativeLayout:addView	(Landroid/view/View;)V
    //   566: goto -544 -> 22
    //   569: ldc_w 461
    //   572: aload 4
    //   574: invokevirtual 69	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   577: ifeq +137 -> 714
    //   580: new 121	org/json/JSONObject
    //   583: dup
    //   584: aload 5
    //   586: iconst_0
    //   587: aaload
    //   588: invokespecial 274	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   591: astore_3
    //   592: aload_0
    //   593: aload_3
    //   594: ldc_w 276
    //   597: invokevirtual 278	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   600: putfield 463	awhv:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   603: invokestatic 243	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   606: ifeq +30 -> 636
    //   609: ldc_w 363
    //   612: iconst_2
    //   613: new 245	java/lang/StringBuilder
    //   616: dup
    //   617: invokespecial 246	java/lang/StringBuilder:<init>	()V
    //   620: ldc_w 465
    //   623: invokevirtual 252	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   626: aload_3
    //   627: invokevirtual 334	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   630: invokevirtual 253	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   633: invokestatic 255	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   636: aload_3
    //   637: ldc_w 336
    //   640: invokevirtual 339	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   643: astore_1
    //   644: aload_3
    //   645: ldc_w 367
    //   648: invokevirtual 339	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   651: astore_2
    //   652: aload_3
    //   653: ldc_w 467
    //   656: invokevirtual 471	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   659: istore 6
    //   661: aload_3
    //   662: ldc_w 473
    //   665: invokevirtual 339	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   668: astore_3
    //   669: aload_0
    //   670: aload_0
    //   671: getfield 47	awhv:mRuntime	Lbioy;
    //   674: invokevirtual 52	bioy:a	()Landroid/app/Activity;
    //   677: iconst_1
    //   678: aload_1
    //   679: aload_2
    //   680: iload 6
    //   682: aload_3
    //   683: invokestatic 478	com/tencent/biz/troop/EditUniqueTitleActivity:a	(Landroid/content/Context;ILjava/lang/String;Ljava/lang/String;ILjava/lang/String;)Landroid/content/Intent;
    //   686: iconst_4
    //   687: invokevirtual 226	awhv:startActivityForResult	(Landroid/content/Intent;B)V
    //   690: goto -668 -> 22
    //   693: astore_1
    //   694: invokestatic 243	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   697: ifeq -675 -> 22
    //   700: ldc_w 363
    //   703: iconst_2
    //   704: ldc_w 480
    //   707: aload_1
    //   708: invokestatic 306	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   711: goto -689 -> 22
    //   714: ldc_w 482
    //   717: aload 4
    //   719: invokevirtual 69	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   722: ifeq +122 -> 844
    //   725: aload_0
    //   726: invokestatic 234	aasb:a	()Laasb;
    //   729: putfield 484	awhv:jdField_b_of_type_Aasb	Laasb;
    //   732: aload_0
    //   733: getfield 484	awhv:jdField_b_of_type_Aasb	Laasb;
    //   736: invokevirtual 236	aasb:a	()V
    //   739: new 121	org/json/JSONObject
    //   742: dup
    //   743: aload 5
    //   745: iconst_0
    //   746: aaload
    //   747: invokespecial 274	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   750: astore_1
    //   751: invokestatic 243	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   754: ifeq +30 -> 784
    //   757: ldc_w 363
    //   760: iconst_2
    //   761: new 245	java/lang/StringBuilder
    //   764: dup
    //   765: invokespecial 246	java/lang/StringBuilder:<init>	()V
    //   768: ldc_w 486
    //   771: invokevirtual 252	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   774: aload_1
    //   775: invokevirtual 334	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   778: invokevirtual 253	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   781: invokestatic 255	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   784: aload_1
    //   785: ldc_w 336
    //   788: invokevirtual 339	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   791: astore_2
    //   792: aload_1
    //   793: ldc_w 367
    //   796: invokevirtual 339	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   799: astore_3
    //   800: aload_1
    //   801: ldc_w 488
    //   804: invokevirtual 471	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   807: istore 6
    //   809: aload_0
    //   810: getfield 484	awhv:jdField_b_of_type_Aasb	Laasb;
    //   813: aload_2
    //   814: aload_3
    //   815: iload 6
    //   817: invokevirtual 491	aasb:a	(Ljava/lang/String;Ljava/lang/String;I)V
    //   820: goto -798 -> 22
    //   823: astore_1
    //   824: invokestatic 243	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   827: ifeq -805 -> 22
    //   830: ldc_w 363
    //   833: iconst_2
    //   834: ldc_w 493
    //   837: aload_1
    //   838: invokestatic 306	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   841: goto -819 -> 22
    //   844: ldc_w 495
    //   847: aload 4
    //   849: invokevirtual 69	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   852: ifeq +117 -> 969
    //   855: new 121	org/json/JSONObject
    //   858: dup
    //   859: aload 5
    //   861: iconst_0
    //   862: aaload
    //   863: invokespecial 274	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   866: astore_2
    //   867: invokestatic 243	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   870: ifeq +30 -> 900
    //   873: ldc_w 363
    //   876: iconst_2
    //   877: new 245	java/lang/StringBuilder
    //   880: dup
    //   881: invokespecial 246	java/lang/StringBuilder:<init>	()V
    //   884: ldc_w 497
    //   887: invokevirtual 252	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   890: aload_2
    //   891: invokevirtual 334	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   894: invokevirtual 253	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   897: invokestatic 255	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   900: aload_2
    //   901: ldc_w 336
    //   904: invokevirtual 339	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   907: astore_1
    //   908: aload_2
    //   909: ldc_w 367
    //   912: invokevirtual 339	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   915: astore_2
    //   916: invokestatic 372	bftp:a	()Lbftp;
    //   919: aload_1
    //   920: aload_2
    //   921: invokevirtual 375	bftp:a	(Ljava/lang/String;Ljava/lang/String;)Z
    //   924: ifeq -902 -> 22
    //   927: aload_0
    //   928: getfield 393	awhv:jdField_a_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   931: bipush 8
    //   933: invokevirtual 388	android/widget/ImageView:setVisibility	(I)V
    //   936: invokestatic 372	bftp:a	()Lbftp;
    //   939: aload_1
    //   940: aload_2
    //   941: iconst_0
    //   942: invokevirtual 500	bftp:a	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   945: goto -923 -> 22
    //   948: astore_1
    //   949: invokestatic 243	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   952: ifeq -930 -> 22
    //   955: ldc_w 363
    //   958: iconst_2
    //   959: ldc_w 502
    //   962: aload_1
    //   963: invokestatic 306	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   966: goto -944 -> 22
    //   969: ldc_w 504
    //   972: aload 4
    //   974: invokevirtual 69	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   977: ifeq +522 -> 1499
    //   980: new 121	org/json/JSONObject
    //   983: dup
    //   984: aload 5
    //   986: iconst_0
    //   987: aaload
    //   988: invokespecial 274	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   991: astore_2
    //   992: invokestatic 243	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   995: ifeq +30 -> 1025
    //   998: ldc_w 329
    //   1001: iconst_2
    //   1002: new 245	java/lang/StringBuilder
    //   1005: dup
    //   1006: invokespecial 246	java/lang/StringBuilder:<init>	()V
    //   1009: ldc_w 506
    //   1012: invokevirtual 252	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1015: aload_2
    //   1016: invokevirtual 334	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1019: invokevirtual 253	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1022: invokestatic 255	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1025: aload_2
    //   1026: ldc_w 336
    //   1029: invokevirtual 339	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1032: astore_1
    //   1033: aload_0
    //   1034: aload_2
    //   1035: ldc_w 508
    //   1038: invokevirtual 339	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1041: invokestatic 513	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   1044: putfield 192	awhv:jdField_b_of_type_Int	I
    //   1047: aload_2
    //   1048: ldc_w 515
    //   1051: invokevirtual 339	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1054: astore 4
    //   1056: aload_2
    //   1057: ldc_w 517
    //   1060: invokevirtual 339	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1063: astore_3
    //   1064: aload_3
    //   1065: ifnull +87 -> 1152
    //   1068: aload 4
    //   1070: ifnull +82 -> 1152
    //   1073: aload_3
    //   1074: invokevirtual 519	java/lang/String:isEmpty	()Z
    //   1077: ifne +75 -> 1152
    //   1080: aload 4
    //   1082: invokevirtual 519	java/lang/String:isEmpty	()Z
    //   1085: istore 12
    //   1087: iload 12
    //   1089: ifne +63 -> 1152
    //   1092: aload_3
    //   1093: invokestatic 513	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   1096: istore 7
    //   1098: aload 4
    //   1100: invokestatic 513	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   1103: istore 6
    //   1105: iload 6
    //   1107: iconst_1
    //   1108: if_icmpne +196 -> 1304
    //   1111: iconst_1
    //   1112: istore 6
    //   1114: iload 7
    //   1116: tableswitch	default:+36 -> 1152, 1:+194->1310, 2:+315->1431, 3:+1039->2155, 4:+1060->2176, 5:+1081->2197
    //   1153: aload_2
    //   1154: ldc_w 521
    //   1157: invokevirtual 339	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1160: putfield 214	awhv:c	Ljava/lang/String;
    //   1163: aload_0
    //   1164: aload_2
    //   1165: ldc_w 523
    //   1168: invokevirtual 339	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1171: putfield 215	awhv:d	Ljava/lang/String;
    //   1174: aload_0
    //   1175: aload_2
    //   1176: ldc_w 525
    //   1179: invokevirtual 339	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1182: putfield 193	awhv:e	Ljava/lang/String;
    //   1185: aload_0
    //   1186: aload_2
    //   1187: ldc_w 276
    //   1190: invokevirtual 339	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1193: putfield 527	awhv:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1196: aload_0
    //   1197: getfield 47	awhv:mRuntime	Lbioy;
    //   1200: invokevirtual 530	bioy:a	()Lcom/tencent/common/app/AppInterface;
    //   1203: aload_0
    //   1204: getfield 47	awhv:mRuntime	Lbioy;
    //   1207: invokevirtual 530	bioy:a	()Lcom/tencent/common/app/AppInterface;
    //   1210: invokevirtual 535	com/tencent/common/app/AppInterface:getAccount	()Ljava/lang/String;
    //   1213: invokevirtual 539	com/tencent/common/app/AppInterface:getEntityManagerFactory	(Ljava/lang/String;)Lcom/tencent/mobileqq/persistence/EntityManagerFactory;
    //   1216: invokevirtual 545	com/tencent/mobileqq/persistence/EntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   1219: astore_2
    //   1220: aload_2
    //   1221: ldc 187
    //   1223: aload_1
    //   1224: invokevirtual 551	com/tencent/mobileqq/persistence/EntityManager:find	(Ljava/lang/Class;Ljava/lang/String;)Lcom/tencent/mobileqq/persistence/Entity;
    //   1227: checkcast 187	com/tencent/mobileqq/data/TroopInfo
    //   1230: astore_3
    //   1231: aload_2
    //   1232: invokevirtual 554	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   1235: aload_3
    //   1236: ifnull +249 -> 1485
    //   1239: aload_0
    //   1240: ldc_w 555
    //   1243: invokespecial 103	awhv:a	(I)V
    //   1246: goto -1224 -> 22
    //   1249: astore_1
    //   1250: invokestatic 243	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1253: ifeq +30 -> 1283
    //   1256: ldc_w 329
    //   1259: iconst_2
    //   1260: new 245	java/lang/StringBuilder
    //   1263: dup
    //   1264: invokespecial 246	java/lang/StringBuilder:<init>	()V
    //   1267: ldc_w 557
    //   1270: invokevirtual 252	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1273: aload_1
    //   1274: invokevirtual 334	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1277: invokevirtual 253	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1280: invokestatic 263	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1283: aload_0
    //   1284: aload_0
    //   1285: getfield 527	awhv:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1288: iconst_1
    //   1289: anewarray 65	java/lang/String
    //   1292: dup
    //   1293: iconst_0
    //   1294: ldc_w 559
    //   1297: aastore
    //   1298: invokevirtual 169	awhv:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   1301: goto -1279 -> 22
    //   1304: iconst_0
    //   1305: istore 6
    //   1307: goto -193 -> 1114
    //   1310: iload 6
    //   1312: ifeq +111 -> 1423
    //   1315: sipush 30003
    //   1318: istore 6
    //   1320: aload_0
    //   1321: iload 6
    //   1323: putfield 192	awhv:jdField_b_of_type_Int	I
    //   1326: goto -174 -> 1152
    //   1329: astore 4
    //   1331: invokestatic 243	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1334: ifeq -182 -> 1152
    //   1337: aload_0
    //   1338: getfield 172	awhv:TAG	Ljava/lang/String;
    //   1341: iconst_2
    //   1342: new 245	java/lang/StringBuilder
    //   1345: dup
    //   1346: invokespecial 246	java/lang/StringBuilder:<init>	()V
    //   1349: ldc_w 561
    //   1352: invokevirtual 252	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1355: aload_3
    //   1356: invokevirtual 252	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1359: invokevirtual 253	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1362: invokestatic 255	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1365: goto -213 -> 1152
    //   1368: astore_1
    //   1369: invokestatic 243	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1372: ifeq +30 -> 1402
    //   1375: ldc_w 329
    //   1378: iconst_2
    //   1379: new 245	java/lang/StringBuilder
    //   1382: dup
    //   1383: invokespecial 246	java/lang/StringBuilder:<init>	()V
    //   1386: ldc_w 563
    //   1389: invokevirtual 252	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1392: aload_1
    //   1393: invokevirtual 334	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1396: invokevirtual 253	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1399: invokestatic 263	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1402: aload_0
    //   1403: aload_0
    //   1404: getfield 527	awhv:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1407: iconst_1
    //   1408: anewarray 65	java/lang/String
    //   1411: dup
    //   1412: iconst_0
    //   1413: ldc_w 565
    //   1416: aastore
    //   1417: invokevirtual 169	awhv:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   1420: goto -1398 -> 22
    //   1423: sipush 30005
    //   1426: istore 6
    //   1428: goto -108 -> 1320
    //   1431: iload 6
    //   1433: ifeq +714 -> 2147
    //   1436: sipush 30003
    //   1439: istore 6
    //   1441: aload_0
    //   1442: iload 6
    //   1444: putfield 192	awhv:jdField_b_of_type_Int	I
    //   1447: goto -295 -> 1152
    //   1450: aload_0
    //   1451: iload 6
    //   1453: putfield 192	awhv:jdField_b_of_type_Int	I
    //   1456: goto -304 -> 1152
    //   1459: aload_0
    //   1460: iload 6
    //   1462: putfield 192	awhv:jdField_b_of_type_Int	I
    //   1465: goto -313 -> 1152
    //   1468: aload_0
    //   1469: iload 6
    //   1471: putfield 192	awhv:jdField_b_of_type_Int	I
    //   1474: goto -322 -> 1152
    //   1477: sipush 30019
    //   1480: istore 6
    //   1482: goto -14 -> 1468
    //   1485: aload_0
    //   1486: getfield 29	awhv:jdField_a_of_type_Aasb	Laasb;
    //   1489: aload_1
    //   1490: ldc_w 566
    //   1493: invokevirtual 569	aasb:a	(Ljava/lang/String;I)V
    //   1496: goto -1474 -> 22
    //   1499: ldc_w 571
    //   1502: aload 4
    //   1504: invokevirtual 69	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1507: ifeq +158 -> 1665
    //   1510: aload 5
    //   1512: iconst_0
    //   1513: aaload
    //   1514: astore_1
    //   1515: ldc_w 573
    //   1518: iconst_1
    //   1519: new 245	java/lang/StringBuilder
    //   1522: dup
    //   1523: invokespecial 246	java/lang/StringBuilder:<init>	()V
    //   1526: ldc_w 575
    //   1529: invokevirtual 252	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1532: aload_1
    //   1533: invokevirtual 252	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1536: invokevirtual 253	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1539: invokestatic 578	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1542: new 121	org/json/JSONObject
    //   1545: dup
    //   1546: aload_1
    //   1547: invokespecial 274	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1550: astore_1
    //   1551: aload_1
    //   1552: ldc_w 580
    //   1555: invokevirtual 471	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   1558: istore 6
    //   1560: aload_1
    //   1561: ldc_w 582
    //   1564: invokevirtual 339	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1567: pop
    //   1568: aload_1
    //   1569: ldc_w 336
    //   1572: invokevirtual 339	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1575: astore_1
    //   1576: iload 6
    //   1578: ifne -1556 -> 22
    //   1581: aload_0
    //   1582: getfield 47	awhv:mRuntime	Lbioy;
    //   1585: invokevirtual 52	bioy:a	()Landroid/app/Activity;
    //   1588: checkcast 584	com/tencent/mobileqq/app/BaseActivity
    //   1591: astore_2
    //   1592: aload_2
    //   1593: ifnonnull +5 -> 1598
    //   1596: iconst_0
    //   1597: ireturn
    //   1598: new 586	android/content/Intent
    //   1601: dup
    //   1602: invokespecial 587	android/content/Intent:<init>	()V
    //   1605: astore_3
    //   1606: aload_3
    //   1607: ldc_w 588
    //   1610: invokevirtual 592	android/content/Intent:addFlags	(I)Landroid/content/Intent;
    //   1613: pop
    //   1614: aload_3
    //   1615: ldc_w 594
    //   1618: iconst_2
    //   1619: invokevirtual 598	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   1622: pop
    //   1623: aload_3
    //   1624: ldc_w 600
    //   1627: aload_1
    //   1628: invokevirtual 603	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1631: pop
    //   1632: aload_2
    //   1633: aload_3
    //   1634: ldc_w 605
    //   1637: ldc_w 607
    //   1640: invokestatic 612	afez:a	(Landroid/content/Context;Landroid/content/Intent;Ljava/lang/Class;Ljava/lang/Class;)V
    //   1643: aload_2
    //   1644: iconst_0
    //   1645: iconst_0
    //   1646: invokevirtual 615	com/tencent/mobileqq/app/BaseActivity:overridePendingTransition	(II)V
    //   1649: goto -1627 -> 22
    //   1652: astore_1
    //   1653: invokestatic 243	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1656: ifeq +7 -> 1663
    //   1659: aload_1
    //   1660: invokevirtual 618	java/lang/Exception:printStackTrace	()V
    //   1663: iconst_0
    //   1664: ireturn
    //   1665: ldc_w 620
    //   1668: aload 4
    //   1670: invokevirtual 69	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1673: ifeq +146 -> 1819
    //   1676: aload 5
    //   1678: ifnull -1656 -> 22
    //   1681: aload 5
    //   1683: arraylength
    //   1684: ifle -1662 -> 22
    //   1687: invokestatic 243	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1690: ifeq +33 -> 1723
    //   1693: ldc_w 329
    //   1696: iconst_2
    //   1697: new 245	java/lang/StringBuilder
    //   1700: dup
    //   1701: invokespecial 246	java/lang/StringBuilder:<init>	()V
    //   1704: ldc_w 622
    //   1707: invokevirtual 252	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1710: aload 5
    //   1712: iconst_0
    //   1713: aaload
    //   1714: invokevirtual 252	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1717: invokevirtual 253	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1720: invokestatic 263	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1723: new 121	org/json/JSONObject
    //   1726: dup
    //   1727: aload 5
    //   1729: iconst_0
    //   1730: aaload
    //   1731: invokespecial 274	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1734: astore_1
    //   1735: aload_1
    //   1736: ldc_w 336
    //   1739: invokevirtual 339	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1742: aload_1
    //   1743: ldc_w 624
    //   1746: invokevirtual 471	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   1749: invokestatic 629	com/tencent/mobileqq/activity/TroopInfoActivity:a	(Ljava/lang/String;I)Landroid/os/Bundle;
    //   1752: astore_2
    //   1753: aload_2
    //   1754: ldc_w 523
    //   1757: aload_1
    //   1758: ldc_w 523
    //   1761: invokevirtual 339	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1764: invokevirtual 635	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1767: aload_0
    //   1768: getfield 47	awhv:mRuntime	Lbioy;
    //   1771: invokevirtual 52	bioy:a	()Landroid/app/Activity;
    //   1774: aload_2
    //   1775: iconst_2
    //   1776: invokestatic 640	bguq:a	(Landroid/content/Context;Landroid/os/Bundle;I)V
    //   1779: goto -1757 -> 22
    //   1782: astore_1
    //   1783: invokestatic 243	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1786: ifeq -1764 -> 22
    //   1789: ldc_w 329
    //   1792: iconst_2
    //   1793: new 245	java/lang/StringBuilder
    //   1796: dup
    //   1797: invokespecial 246	java/lang/StringBuilder:<init>	()V
    //   1800: ldc_w 642
    //   1803: invokevirtual 252	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1806: aload_1
    //   1807: invokevirtual 334	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1810: invokevirtual 253	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1813: invokestatic 263	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1816: goto -1794 -> 22
    //   1819: ldc_w 644
    //   1822: aload 4
    //   1824: invokevirtual 69	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1827: ifeq +124 -> 1951
    //   1830: new 121	org/json/JSONObject
    //   1833: dup
    //   1834: aload 5
    //   1836: iconst_0
    //   1837: aaload
    //   1838: invokespecial 274	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1841: astore_1
    //   1842: aload_1
    //   1843: ldc_w 646
    //   1846: invokevirtual 649	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   1849: istore 6
    //   1851: aload_1
    //   1852: ldc_w 651
    //   1855: invokevirtual 278	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1858: astore_1
    //   1859: invokestatic 243	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1862: ifeq +32 -> 1894
    //   1865: ldc_w 653
    //   1868: iconst_2
    //   1869: ldc_w 655
    //   1872: iconst_2
    //   1873: anewarray 657	java/lang/Object
    //   1876: dup
    //   1877: iconst_0
    //   1878: aload_1
    //   1879: aastore
    //   1880: dup
    //   1881: iconst_1
    //   1882: iload 6
    //   1884: invokestatic 661	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1887: aastore
    //   1888: invokestatic 665	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   1891: invokestatic 255	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1894: aload_1
    //   1895: invokestatic 284	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1898: ifne -1876 -> 22
    //   1901: aload_0
    //   1902: getfield 29	awhv:jdField_a_of_type_Aasb	Laasb;
    //   1905: astore_2
    //   1906: iload 6
    //   1908: iconst_1
    //   1909: if_icmpne +36 -> 1945
    //   1912: iconst_1
    //   1913: istore 12
    //   1915: aload_2
    //   1916: aload_1
    //   1917: iload 12
    //   1919: invokevirtual 668	aasb:d	(Ljava/lang/String;Z)V
    //   1922: goto -1900 -> 22
    //   1925: astore_1
    //   1926: aload_1
    //   1927: invokevirtual 618	java/lang/Exception:printStackTrace	()V
    //   1930: aload_0
    //   1931: getfield 172	awhv:TAG	Ljava/lang/String;
    //   1934: iconst_1
    //   1935: ldc_w 670
    //   1938: aload_1
    //   1939: invokestatic 672	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1942: goto -1920 -> 22
    //   1945: iconst_0
    //   1946: istore 12
    //   1948: goto -33 -> 1915
    //   1951: ldc_w 674
    //   1954: aload 4
    //   1956: invokevirtual 69	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1959: ifeq +166 -> 2125
    //   1962: aload 5
    //   1964: ifnull -1942 -> 22
    //   1967: aload 5
    //   1969: arraylength
    //   1970: ifle -1948 -> 22
    //   1973: aload_0
    //   1974: getfield 47	awhv:mRuntime	Lbioy;
    //   1977: invokevirtual 52	bioy:a	()Landroid/app/Activity;
    //   1980: astore_1
    //   1981: new 586	android/content/Intent
    //   1984: dup
    //   1985: invokespecial 587	android/content/Intent:<init>	()V
    //   1988: astore_2
    //   1989: new 121	org/json/JSONObject
    //   1992: dup
    //   1993: aload 5
    //   1995: iconst_0
    //   1996: aaload
    //   1997: invokespecial 274	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   2000: astore_3
    //   2001: aload_3
    //   2002: ldc_w 276
    //   2005: invokevirtual 339	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2008: astore 4
    //   2010: aload_3
    //   2011: invokevirtual 677	org/json/JSONObject:length	()I
    //   2014: ifle +88 -> 2102
    //   2017: aload_0
    //   2018: aload 4
    //   2020: iconst_1
    //   2021: anewarray 65	java/lang/String
    //   2024: dup
    //   2025: iconst_0
    //   2026: aload_1
    //   2027: ldc_w 678
    //   2030: invokevirtual 81	android/app/Activity:getString	(I)Ljava/lang/String;
    //   2033: aastore
    //   2034: invokevirtual 169	awhv:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   2037: aload_2
    //   2038: ldc_w 680
    //   2041: aload_3
    //   2042: ldc_w 682
    //   2045: invokevirtual 278	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   2048: invokevirtual 603	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   2051: pop
    //   2052: aload_2
    //   2053: ldc_w 651
    //   2056: aload_3
    //   2057: ldc_w 651
    //   2060: invokevirtual 278	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   2063: invokevirtual 603	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   2066: pop
    //   2067: aload_1
    //   2068: iconst_m1
    //   2069: aload_2
    //   2070: invokevirtual 686	android/app/Activity:setResult	(ILandroid/content/Intent;)V
    //   2073: aload_1
    //   2074: invokevirtual 689	android/app/Activity:finish	()V
    //   2077: goto -2055 -> 22
    //   2080: astore_1
    //   2081: invokestatic 692	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   2084: ifeq -2062 -> 22
    //   2087: aload_0
    //   2088: getfield 172	awhv:TAG	Ljava/lang/String;
    //   2091: iconst_4
    //   2092: ldc_w 694
    //   2095: aload_1
    //   2096: invokestatic 179	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   2099: goto -2077 -> 22
    //   2102: aload_0
    //   2103: aload 4
    //   2105: iconst_1
    //   2106: anewarray 65	java/lang/String
    //   2109: dup
    //   2110: iconst_0
    //   2111: aload_1
    //   2112: ldc_w 695
    //   2115: invokevirtual 81	android/app/Activity:getString	(I)Ljava/lang/String;
    //   2118: aastore
    //   2119: invokevirtual 169	awhv:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   2122: goto -85 -> 2037
    //   2125: ldc_w 697
    //   2128: aload 4
    //   2130: invokevirtual 69	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2133: ifeq -2111 -> 22
    //   2136: aload_0
    //   2137: aload 5
    //   2139: iconst_0
    //   2140: aaload
    //   2141: invokevirtual 699	awhv:a	(Ljava/lang/String;)V
    //   2144: goto -2122 -> 22
    //   2147: sipush 30007
    //   2150: istore 6
    //   2152: goto -711 -> 1441
    //   2155: iload 6
    //   2157: ifeq +11 -> 2168
    //   2160: sipush 30009
    //   2163: istore 6
    //   2165: goto -715 -> 1450
    //   2168: sipush 30011
    //   2171: istore 6
    //   2173: goto -723 -> 1450
    //   2176: iload 6
    //   2178: ifeq +11 -> 2189
    //   2181: sipush 30013
    //   2184: istore 6
    //   2186: goto -727 -> 1459
    //   2189: sipush 30015
    //   2192: istore 6
    //   2194: goto -735 -> 1459
    //   2197: iload 6
    //   2199: ifeq -722 -> 1477
    //   2202: sipush 30017
    //   2205: istore 6
    //   2207: goto -739 -> 1468
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2210	0	this	awhv
    //   0	2210	1	paramJsBridgeListener	com.tencent.mobileqq.webview.swift.JsBridgeListener
    //   0	2210	2	paramString1	String
    //   0	2210	3	paramString2	String
    //   0	2210	4	paramString3	String
    //   0	2210	5	paramVarArgs	String[]
    //   659	1547	6	i	int
    //   1096	19	7	j	int
    //   114	31	8	l1	long
    //   123	24	10	l2	long
    //   1085	862	12	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   46	91	158	java/lang/Exception
    //   91	155	158	java/lang/Exception
    //   190	235	413	java/lang/Exception
    //   235	278	413	java/lang/Exception
    //   282	325	413	java/lang/Exception
    //   329	410	413	java/lang/Exception
    //   438	481	413	java/lang/Exception
    //   485	566	413	java/lang/Exception
    //   580	636	693	java/lang/Exception
    //   636	690	693	java/lang/Exception
    //   725	784	823	java/lang/Exception
    //   784	820	823	java/lang/Exception
    //   855	900	948	java/lang/Exception
    //   900	945	948	java/lang/Exception
    //   980	1025	1249	org/json/JSONException
    //   1025	1064	1249	org/json/JSONException
    //   1073	1087	1249	org/json/JSONException
    //   1092	1105	1249	org/json/JSONException
    //   1152	1235	1249	org/json/JSONException
    //   1239	1246	1249	org/json/JSONException
    //   1320	1326	1249	org/json/JSONException
    //   1331	1365	1249	org/json/JSONException
    //   1441	1447	1249	org/json/JSONException
    //   1450	1456	1249	org/json/JSONException
    //   1459	1465	1249	org/json/JSONException
    //   1468	1474	1249	org/json/JSONException
    //   1485	1496	1249	org/json/JSONException
    //   1092	1105	1329	java/lang/NumberFormatException
    //   1320	1326	1329	java/lang/NumberFormatException
    //   1441	1447	1329	java/lang/NumberFormatException
    //   1450	1456	1329	java/lang/NumberFormatException
    //   1459	1465	1329	java/lang/NumberFormatException
    //   1468	1474	1329	java/lang/NumberFormatException
    //   980	1025	1368	java/lang/Exception
    //   1025	1064	1368	java/lang/Exception
    //   1073	1087	1368	java/lang/Exception
    //   1092	1105	1368	java/lang/Exception
    //   1152	1235	1368	java/lang/Exception
    //   1239	1246	1368	java/lang/Exception
    //   1320	1326	1368	java/lang/Exception
    //   1331	1365	1368	java/lang/Exception
    //   1441	1447	1368	java/lang/Exception
    //   1450	1456	1368	java/lang/Exception
    //   1459	1465	1368	java/lang/Exception
    //   1468	1474	1368	java/lang/Exception
    //   1485	1496	1368	java/lang/Exception
    //   1515	1576	1652	java/lang/Exception
    //   1581	1592	1652	java/lang/Exception
    //   1598	1649	1652	java/lang/Exception
    //   1681	1723	1782	org/json/JSONException
    //   1723	1779	1782	org/json/JSONException
    //   1830	1894	1925	java/lang/Exception
    //   1894	1906	1925	java/lang/Exception
    //   1915	1922	1925	java/lang/Exception
    //   1967	2037	2080	java/lang/Exception
    //   2037	2077	2080	java/lang/Exception
    //   2102	2122	2080	java/lang/Exception
  }
  
  public void onActivityResult(Intent paramIntent, byte paramByte, int paramInt)
  {
    super.onActivityResult(paramIntent, paramByte, paramInt);
    if (paramByte == 4)
    {
      if (paramInt != -1) {
        break label93;
      }
      if (paramIntent != null) {
        break label74;
      }
      paramIntent = "";
    }
    for (;;)
    {
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("code", 0);
        localJSONObject.put("uniqueTitle", paramIntent);
        callJs(this.jdField_b_of_type_JavaLangString, new String[] { localJSONObject.toString() });
        return;
        label74:
        paramIntent = paramIntent.getStringExtra("newUniqueTitle");
      }
      catch (JSONException paramIntent)
      {
        for (;;)
        {
          paramIntent.printStackTrace();
        }
      }
    }
    label93:
    callJs(this.jdField_b_of_type_JavaLangString, new String[] { "{\"code\":-1}" });
  }
  
  public void onCreate()
  {
    AppInterface localAppInterface = this.mRuntime.a();
    Activity localActivity = this.mRuntime.a();
    if ((localAppInterface == null) || (localActivity == null)) {}
    do
    {
      return;
      a();
    } while (this.jdField_a_of_type_Aasb == null);
    this.jdField_a_of_type_Aasb.a(this.jdField_a_of_type_Aojs);
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      this.jdField_a_of_type_Aasb.b(this.jdField_a_of_type_Aojs);
      this.jdField_a_of_type_Aasb.b();
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopDataVideoUploadTask != null) && (!this.jdField_a_of_type_ComTencentMobileqqTroopDataVideoUploadTask.a())) {
      this.jdField_a_of_type_ComTencentMobileqqTroopDataVideoUploadTask.a();
    }
    if (this.jdField_b_of_type_Aasb != null) {
      this.jdField_b_of_type_Aasb.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awhv
 * JD-Core Version:    0.7.0.1
 */