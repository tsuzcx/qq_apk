import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.widget.ImageView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.AddFriendLogicActivity;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.mobileqq.troop.data.VideoUploadTask;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.widget.QQToast;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

public class avpk
  extends WebViewPlugin
{
  int jdField_a_of_type_Int;
  aanz jdField_a_of_type_Aanz = null;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  anxg jdField_a_of_type_Anxg = new avpm(this);
  VideoUploadTask jdField_a_of_type_ComTencentMobileqqTroopDataVideoUploadTask;
  String jdField_a_of_type_JavaLangString;
  AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  int jdField_b_of_type_Int;
  aanz jdField_b_of_type_Aanz;
  String jdField_b_of_type_JavaLangString;
  String c;
  String d;
  String e;
  
  public avpk()
  {
    this.mPluginNameSpace = "troopApi";
  }
  
  private Context a()
  {
    for (Activity localActivity = this.mRuntime.a(); (localActivity != null) && ((localActivity instanceof BasePluginActivity)); localActivity = ((BasePluginActivity)localActivity).getOutActivity()) {}
    return localActivity;
  }
  
  private void a(int paramInt)
  {
    a(paramInt, 0);
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    if (this.mRuntime.a() != null) {
      QQToast.a(this.mRuntime.a(), paramInt2, this.mRuntime.a().getString(paramInt1), 0).b(this.mRuntime.a().getResources().getDimensionPixelSize(2131298998));
    }
  }
  
  private void a(TroopInfo paramTroopInfo)
  {
    this.jdField_a_of_type_Aanz.a(paramTroopInfo.troopuin, this.jdField_b_of_type_Int, this.e);
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
    a(2131718791);
  }
  
  void a()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true))
    {
      this.jdField_a_of_type_Aanz = aanz.a();
      this.jdField_a_of_type_Aanz.a();
    }
  }
  
  /* Error */
  public boolean handleJsRequest(com.tencent.mobileqq.webview.swift.JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    // Byte code:
    //   0: ldc 38
    //   2: aload_3
    //   3: invokevirtual 166	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   6: ifne +5 -> 11
    //   9: iconst_0
    //   10: ireturn
    //   11: ldc 168
    //   13: aload 4
    //   15: invokevirtual 166	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   18: ifeq +5 -> 23
    //   21: iconst_1
    //   22: ireturn
    //   23: ldc 170
    //   25: aload 4
    //   27: invokevirtual 166	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   30: ifne -9 -> 21
    //   33: ldc 172
    //   35: aload 4
    //   37: invokevirtual 166	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   40: ifeq +127 -> 167
    //   43: new 174	org/json/JSONObject
    //   46: dup
    //   47: aload 5
    //   49: iconst_0
    //   50: aaload
    //   51: invokespecial 177	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   54: astore_3
    //   55: invokestatic 183	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   58: ifeq +28 -> 86
    //   61: ldc 185
    //   63: iconst_2
    //   64: new 187	java/lang/StringBuilder
    //   67: dup
    //   68: invokespecial 188	java/lang/StringBuilder:<init>	()V
    //   71: ldc 190
    //   73: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: aload_3
    //   77: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   80: invokevirtual 200	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   83: invokestatic 202	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   86: aload_3
    //   87: ldc 204
    //   89: invokevirtual 208	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   92: astore_1
    //   93: aload_3
    //   94: ldc 210
    //   96: invokevirtual 208	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   99: astore_2
    //   100: aload_3
    //   101: ldc 212
    //   103: invokevirtual 216	org/json/JSONObject:optLong	(Ljava/lang/String;)J
    //   106: lstore 8
    //   108: aload_3
    //   109: ldc 218
    //   111: invokevirtual 216	org/json/JSONObject:optLong	(Ljava/lang/String;)J
    //   114: lstore 10
    //   116: aload_3
    //   117: ldc 220
    //   119: invokevirtual 208	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   122: astore_3
    //   123: aload_0
    //   124: getfield 29	avpk:jdField_a_of_type_Aanz	Laanz;
    //   127: aload_1
    //   128: aload_2
    //   129: new 222	avpl
    //   132: dup
    //   133: aload_0
    //   134: lload 8
    //   136: lload 10
    //   138: aload_3
    //   139: invokespecial 225	avpl:<init>	(Lavpk;JJLjava/lang/String;)V
    //   142: invokevirtual 228	aanz:b	(Ljava/lang/String;Ljava/lang/String;Laaob;)V
    //   145: goto -124 -> 21
    //   148: astore_1
    //   149: invokestatic 183	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   152: ifeq -131 -> 21
    //   155: ldc 185
    //   157: iconst_2
    //   158: ldc 230
    //   160: aload_1
    //   161: invokestatic 234	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   164: goto -143 -> 21
    //   167: ldc 236
    //   169: aload 4
    //   171: invokevirtual 166	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   174: ifeq +377 -> 551
    //   177: new 174	org/json/JSONObject
    //   180: dup
    //   181: aload 5
    //   183: iconst_0
    //   184: aaload
    //   185: invokespecial 177	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   188: astore_2
    //   189: invokestatic 183	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   192: ifeq +28 -> 220
    //   195: ldc 238
    //   197: iconst_2
    //   198: new 187	java/lang/StringBuilder
    //   201: dup
    //   202: invokespecial 188	java/lang/StringBuilder:<init>	()V
    //   205: ldc 240
    //   207: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   210: aload_2
    //   211: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   214: invokevirtual 200	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   217: invokestatic 202	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   220: aload_2
    //   221: ldc 204
    //   223: invokevirtual 208	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   226: astore_1
    //   227: aload_2
    //   228: ldc 242
    //   230: invokevirtual 208	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   233: astore_2
    //   234: invokestatic 247	beui:a	()Lbeui;
    //   237: aload_1
    //   238: aload_2
    //   239: invokevirtual 250	beui:a	(Ljava/lang/String;Ljava/lang/String;)Z
    //   242: ifeq -221 -> 21
    //   245: aload_0
    //   246: getfield 47	avpk:mRuntime	Lbhod;
    //   249: invokevirtual 52	bhod:a	()Landroid/app/Activity;
    //   252: astore_2
    //   253: aload_0
    //   254: getfield 47	avpk:mRuntime	Lbhod;
    //   257: invokevirtual 253	bhod:a	()Lcom/tencent/mobileqq/webview/swift/WebViewFragment;
    //   260: astore_1
    //   261: aload_2
    //   262: ifnull +154 -> 416
    //   265: aload_2
    //   266: instanceof 255
    //   269: ifeq +147 -> 416
    //   272: aload_2
    //   273: checkcast 255	com/tencent/biz/webviewbase/AbsBaseWebViewActivity
    //   276: astore_1
    //   277: aload_1
    //   278: getfield 258	com/tencent/biz/webviewbase/AbsBaseWebViewActivity:rightViewImg	Landroid/widget/ImageView;
    //   281: iconst_0
    //   282: invokevirtual 263	android/widget/ImageView:setVisibility	(I)V
    //   285: aload_0
    //   286: new 260	android/widget/ImageView
    //   289: dup
    //   290: aload_1
    //   291: invokespecial 266	android/widget/ImageView:<init>	(Landroid/content/Context;)V
    //   294: putfield 268	avpk:jdField_a_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   297: aload_1
    //   298: ldc_w 269
    //   301: invokevirtual 273	com/tencent/biz/webviewbase/AbsBaseWebViewActivity:findViewById	(I)Landroid/view/View;
    //   304: checkcast 275	android/widget/RelativeLayout
    //   307: astore_2
    //   308: aload_2
    //   309: ifnull -288 -> 21
    //   312: new 277	android/widget/RelativeLayout$LayoutParams
    //   315: dup
    //   316: bipush 254
    //   318: bipush 254
    //   320: invokespecial 279	android/widget/RelativeLayout$LayoutParams:<init>	(II)V
    //   323: astore_3
    //   324: aload_3
    //   325: bipush 7
    //   327: ldc_w 280
    //   330: invokevirtual 283	android/widget/RelativeLayout$LayoutParams:addRule	(II)V
    //   333: aload_3
    //   334: iconst_0
    //   335: ldc_w 284
    //   338: aload_1
    //   339: invokevirtual 285	com/tencent/biz/webviewbase/AbsBaseWebViewActivity:getResources	()Landroid/content/res/Resources;
    //   342: invokestatic 290	afur:a	(FLandroid/content/res/Resources;)I
    //   345: ldc_w 284
    //   348: aload_1
    //   349: invokevirtual 285	com/tencent/biz/webviewbase/AbsBaseWebViewActivity:getResources	()Landroid/content/res/Resources;
    //   352: invokestatic 290	afur:a	(FLandroid/content/res/Resources;)I
    //   355: iconst_0
    //   356: invokevirtual 294	android/widget/RelativeLayout$LayoutParams:setMargins	(IIII)V
    //   359: aload_0
    //   360: getfield 268	avpk:jdField_a_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   363: aload_3
    //   364: invokevirtual 298	android/widget/ImageView:setLayoutParams	(Landroid/view/ViewGroup$LayoutParams;)V
    //   367: aload_0
    //   368: getfield 268	avpk:jdField_a_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   371: iconst_0
    //   372: invokevirtual 263	android/widget/ImageView:setVisibility	(I)V
    //   375: aload_0
    //   376: getfield 268	avpk:jdField_a_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   379: ldc_w 299
    //   382: invokevirtual 302	android/widget/ImageView:setImageResource	(I)V
    //   385: aload_2
    //   386: aload_0
    //   387: getfield 268	avpk:jdField_a_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   390: invokevirtual 306	android/widget/RelativeLayout:addView	(Landroid/view/View;)V
    //   393: goto -372 -> 21
    //   396: astore_1
    //   397: invokestatic 183	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   400: ifeq -379 -> 21
    //   403: ldc 238
    //   405: iconst_2
    //   406: ldc_w 308
    //   409: aload_1
    //   410: invokestatic 234	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   413: goto -392 -> 21
    //   416: aload_1
    //   417: ifnull -396 -> 21
    //   420: aload_1
    //   421: getfield 314	com/tencent/mobileqq/webview/swift/WebViewFragment:mSwiftTitleUI	Lbhmv;
    //   424: getfield 317	bhmv:jdField_a_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   427: iconst_0
    //   428: invokevirtual 263	android/widget/ImageView:setVisibility	(I)V
    //   431: aload_0
    //   432: new 260	android/widget/ImageView
    //   435: dup
    //   436: aload_1
    //   437: invokevirtual 321	com/tencent/mobileqq/webview/swift/WebViewFragment:getActivity	()Landroid/support/v4/app/FragmentActivity;
    //   440: invokespecial 266	android/widget/ImageView:<init>	(Landroid/content/Context;)V
    //   443: putfield 268	avpk:jdField_a_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   446: aload_1
    //   447: getfield 325	com/tencent/mobileqq/webview/swift/WebViewFragment:mUIStyleHandler	Lbhql;
    //   450: getfield 330	bhql:d	Landroid/view/ViewGroup;
    //   453: ldc_w 269
    //   456: invokevirtual 333	android/view/ViewGroup:findViewById	(I)Landroid/view/View;
    //   459: checkcast 275	android/widget/RelativeLayout
    //   462: astore_2
    //   463: aload_2
    //   464: ifnull -443 -> 21
    //   467: new 277	android/widget/RelativeLayout$LayoutParams
    //   470: dup
    //   471: bipush 254
    //   473: bipush 254
    //   475: invokespecial 279	android/widget/RelativeLayout$LayoutParams:<init>	(II)V
    //   478: astore_3
    //   479: aload_3
    //   480: bipush 7
    //   482: ldc_w 280
    //   485: invokevirtual 283	android/widget/RelativeLayout$LayoutParams:addRule	(II)V
    //   488: aload_3
    //   489: iconst_0
    //   490: ldc_w 284
    //   493: aload_1
    //   494: invokevirtual 334	com/tencent/mobileqq/webview/swift/WebViewFragment:getResources	()Landroid/content/res/Resources;
    //   497: invokestatic 290	afur:a	(FLandroid/content/res/Resources;)I
    //   500: ldc_w 284
    //   503: aload_1
    //   504: invokevirtual 334	com/tencent/mobileqq/webview/swift/WebViewFragment:getResources	()Landroid/content/res/Resources;
    //   507: invokestatic 290	afur:a	(FLandroid/content/res/Resources;)I
    //   510: iconst_0
    //   511: invokevirtual 294	android/widget/RelativeLayout$LayoutParams:setMargins	(IIII)V
    //   514: aload_0
    //   515: getfield 268	avpk:jdField_a_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   518: aload_3
    //   519: invokevirtual 298	android/widget/ImageView:setLayoutParams	(Landroid/view/ViewGroup$LayoutParams;)V
    //   522: aload_0
    //   523: getfield 268	avpk:jdField_a_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   526: iconst_0
    //   527: invokevirtual 263	android/widget/ImageView:setVisibility	(I)V
    //   530: aload_0
    //   531: getfield 268	avpk:jdField_a_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   534: ldc_w 299
    //   537: invokevirtual 302	android/widget/ImageView:setImageResource	(I)V
    //   540: aload_2
    //   541: aload_0
    //   542: getfield 268	avpk:jdField_a_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   545: invokevirtual 306	android/widget/RelativeLayout:addView	(Landroid/view/View;)V
    //   548: goto -527 -> 21
    //   551: ldc_w 336
    //   554: aload 4
    //   556: invokevirtual 166	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   559: ifeq +132 -> 691
    //   562: new 174	org/json/JSONObject
    //   565: dup
    //   566: aload 5
    //   568: iconst_0
    //   569: aaload
    //   570: invokespecial 177	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   573: astore_3
    //   574: aload_0
    //   575: aload_3
    //   576: ldc 220
    //   578: invokevirtual 338	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   581: putfield 340	avpk:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   584: invokestatic 183	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   587: ifeq +29 -> 616
    //   590: ldc 238
    //   592: iconst_2
    //   593: new 187	java/lang/StringBuilder
    //   596: dup
    //   597: invokespecial 188	java/lang/StringBuilder:<init>	()V
    //   600: ldc_w 342
    //   603: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   606: aload_3
    //   607: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   610: invokevirtual 200	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   613: invokestatic 202	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   616: aload_3
    //   617: ldc 204
    //   619: invokevirtual 208	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   622: astore_1
    //   623: aload_3
    //   624: ldc 242
    //   626: invokevirtual 208	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   629: astore_2
    //   630: aload_3
    //   631: ldc_w 344
    //   634: invokevirtual 348	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   637: istore 6
    //   639: aload_3
    //   640: ldc_w 350
    //   643: invokevirtual 208	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   646: astore_3
    //   647: aload_0
    //   648: aload_0
    //   649: getfield 47	avpk:mRuntime	Lbhod;
    //   652: invokevirtual 52	bhod:a	()Landroid/app/Activity;
    //   655: iconst_1
    //   656: aload_1
    //   657: aload_2
    //   658: iload 6
    //   660: aload_3
    //   661: invokestatic 355	com/tencent/biz/troop/EditUniqueTitleActivity:a	(Landroid/content/Context;ILjava/lang/String;Ljava/lang/String;ILjava/lang/String;)Landroid/content/Intent;
    //   664: iconst_4
    //   665: invokevirtual 142	avpk:startActivityForResult	(Landroid/content/Intent;B)V
    //   668: goto -647 -> 21
    //   671: astore_1
    //   672: invokestatic 183	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   675: ifeq -654 -> 21
    //   678: ldc 238
    //   680: iconst_2
    //   681: ldc_w 357
    //   684: aload_1
    //   685: invokestatic 234	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   688: goto -667 -> 21
    //   691: ldc_w 359
    //   694: aload 4
    //   696: invokevirtual 166	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   699: ifeq +118 -> 817
    //   702: aload_0
    //   703: invokestatic 150	aanz:a	()Laanz;
    //   706: putfield 361	avpk:jdField_b_of_type_Aanz	Laanz;
    //   709: aload_0
    //   710: getfield 361	avpk:jdField_b_of_type_Aanz	Laanz;
    //   713: invokevirtual 152	aanz:a	()V
    //   716: new 174	org/json/JSONObject
    //   719: dup
    //   720: aload 5
    //   722: iconst_0
    //   723: aaload
    //   724: invokespecial 177	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   727: astore_1
    //   728: invokestatic 183	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   731: ifeq +29 -> 760
    //   734: ldc 238
    //   736: iconst_2
    //   737: new 187	java/lang/StringBuilder
    //   740: dup
    //   741: invokespecial 188	java/lang/StringBuilder:<init>	()V
    //   744: ldc_w 363
    //   747: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   750: aload_1
    //   751: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   754: invokevirtual 200	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   757: invokestatic 202	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   760: aload_1
    //   761: ldc 204
    //   763: invokevirtual 208	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   766: astore_2
    //   767: aload_1
    //   768: ldc 242
    //   770: invokevirtual 208	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   773: astore_3
    //   774: aload_1
    //   775: ldc_w 365
    //   778: invokevirtual 348	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   781: istore 6
    //   783: aload_0
    //   784: getfield 361	avpk:jdField_b_of_type_Aanz	Laanz;
    //   787: aload_2
    //   788: aload_3
    //   789: iload 6
    //   791: invokevirtual 368	aanz:a	(Ljava/lang/String;Ljava/lang/String;I)V
    //   794: goto -773 -> 21
    //   797: astore_1
    //   798: invokestatic 183	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   801: ifeq -780 -> 21
    //   804: ldc 238
    //   806: iconst_2
    //   807: ldc_w 370
    //   810: aload_1
    //   811: invokestatic 234	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   814: goto -793 -> 21
    //   817: ldc_w 372
    //   820: aload 4
    //   822: invokevirtual 166	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   825: ifeq +113 -> 938
    //   828: new 174	org/json/JSONObject
    //   831: dup
    //   832: aload 5
    //   834: iconst_0
    //   835: aaload
    //   836: invokespecial 177	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   839: astore_2
    //   840: invokestatic 183	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   843: ifeq +29 -> 872
    //   846: ldc 238
    //   848: iconst_2
    //   849: new 187	java/lang/StringBuilder
    //   852: dup
    //   853: invokespecial 188	java/lang/StringBuilder:<init>	()V
    //   856: ldc_w 374
    //   859: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   862: aload_2
    //   863: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   866: invokevirtual 200	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   869: invokestatic 202	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   872: aload_2
    //   873: ldc 204
    //   875: invokevirtual 208	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   878: astore_1
    //   879: aload_2
    //   880: ldc 242
    //   882: invokevirtual 208	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   885: astore_2
    //   886: invokestatic 247	beui:a	()Lbeui;
    //   889: aload_1
    //   890: aload_2
    //   891: invokevirtual 250	beui:a	(Ljava/lang/String;Ljava/lang/String;)Z
    //   894: ifeq -873 -> 21
    //   897: aload_0
    //   898: getfield 268	avpk:jdField_a_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   901: bipush 8
    //   903: invokevirtual 263	android/widget/ImageView:setVisibility	(I)V
    //   906: invokestatic 247	beui:a	()Lbeui;
    //   909: aload_1
    //   910: aload_2
    //   911: iconst_0
    //   912: invokevirtual 377	beui:a	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   915: goto -894 -> 21
    //   918: astore_1
    //   919: invokestatic 183	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   922: ifeq -901 -> 21
    //   925: ldc 238
    //   927: iconst_2
    //   928: ldc_w 379
    //   931: aload_1
    //   932: invokestatic 234	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   935: goto -914 -> 21
    //   938: ldc_w 381
    //   941: aload 4
    //   943: invokevirtual 166	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   946: ifeq +514 -> 1460
    //   949: new 174	org/json/JSONObject
    //   952: dup
    //   953: aload 5
    //   955: iconst_0
    //   956: aaload
    //   957: invokespecial 177	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   960: astore_2
    //   961: invokestatic 183	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   964: ifeq +29 -> 993
    //   967: ldc 185
    //   969: iconst_2
    //   970: new 187	java/lang/StringBuilder
    //   973: dup
    //   974: invokespecial 188	java/lang/StringBuilder:<init>	()V
    //   977: ldc_w 383
    //   980: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   983: aload_2
    //   984: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   987: invokevirtual 200	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   990: invokestatic 202	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   993: aload_2
    //   994: ldc 204
    //   996: invokevirtual 208	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   999: astore_1
    //   1000: aload_0
    //   1001: aload_2
    //   1002: ldc_w 385
    //   1005: invokevirtual 208	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1008: invokestatic 390	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   1011: putfield 104	avpk:jdField_b_of_type_Int	I
    //   1014: aload_2
    //   1015: ldc_w 392
    //   1018: invokevirtual 208	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1021: astore 4
    //   1023: aload_2
    //   1024: ldc_w 394
    //   1027: invokevirtual 208	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1030: astore_3
    //   1031: aload_3
    //   1032: ifnull +84 -> 1116
    //   1035: aload 4
    //   1037: ifnull +79 -> 1116
    //   1040: aload_3
    //   1041: invokevirtual 397	java/lang/String:isEmpty	()Z
    //   1044: ifne +72 -> 1116
    //   1047: aload 4
    //   1049: invokevirtual 397	java/lang/String:isEmpty	()Z
    //   1052: istore 12
    //   1054: iload 12
    //   1056: ifne +60 -> 1116
    //   1059: aload_3
    //   1060: invokestatic 390	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   1063: istore 7
    //   1065: aload 4
    //   1067: invokestatic 390	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   1070: istore 6
    //   1072: iload 6
    //   1074: iconst_1
    //   1075: if_icmpne +191 -> 1266
    //   1078: iconst_1
    //   1079: istore 6
    //   1081: iload 7
    //   1083: tableswitch	default:+33 -> 1116, 1:+189->1272, 2:+309->1392, 3:+833->1916, 4:+854->1937, 5:+875->1958
    //   1117: aload_2
    //   1118: ldc_w 399
    //   1121: invokevirtual 208	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1124: putfield 129	avpk:c	Ljava/lang/String;
    //   1127: aload_0
    //   1128: aload_2
    //   1129: ldc_w 401
    //   1132: invokevirtual 208	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1135: putfield 131	avpk:d	Ljava/lang/String;
    //   1138: aload_0
    //   1139: aload_2
    //   1140: ldc_w 403
    //   1143: invokevirtual 208	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1146: putfield 106	avpk:e	Ljava/lang/String;
    //   1149: aload_0
    //   1150: aload_2
    //   1151: ldc 220
    //   1153: invokevirtual 208	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1156: putfield 405	avpk:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1159: aload_0
    //   1160: getfield 47	avpk:mRuntime	Lbhod;
    //   1163: invokevirtual 408	bhod:a	()Lcom/tencent/common/app/AppInterface;
    //   1166: aload_0
    //   1167: getfield 47	avpk:mRuntime	Lbhod;
    //   1170: invokevirtual 408	bhod:a	()Lcom/tencent/common/app/AppInterface;
    //   1173: invokevirtual 413	com/tencent/common/app/AppInterface:getAccount	()Ljava/lang/String;
    //   1176: invokevirtual 417	com/tencent/common/app/AppInterface:getEntityManagerFactory	(Ljava/lang/String;)Lcom/tencent/mobileqq/persistence/EntityManagerFactory;
    //   1179: invokevirtual 423	com/tencent/mobileqq/persistence/EntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   1182: astore_2
    //   1183: aload_2
    //   1184: ldc 99
    //   1186: aload_1
    //   1187: invokevirtual 429	com/tencent/mobileqq/persistence/EntityManager:find	(Ljava/lang/Class;Ljava/lang/String;)Lcom/tencent/mobileqq/persistence/Entity;
    //   1190: checkcast 99	com/tencent/mobileqq/data/TroopInfo
    //   1193: astore_3
    //   1194: aload_2
    //   1195: invokevirtual 432	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   1198: aload_3
    //   1199: ifnull +247 -> 1446
    //   1202: aload_0
    //   1203: ldc_w 433
    //   1206: invokespecial 92	avpk:a	(I)V
    //   1209: goto -1188 -> 21
    //   1212: astore_1
    //   1213: invokestatic 183	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1216: ifeq +29 -> 1245
    //   1219: ldc 185
    //   1221: iconst_2
    //   1222: new 187	java/lang/StringBuilder
    //   1225: dup
    //   1226: invokespecial 188	java/lang/StringBuilder:<init>	()V
    //   1229: ldc_w 435
    //   1232: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1235: aload_1
    //   1236: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1239: invokevirtual 200	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1242: invokestatic 437	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1245: aload_0
    //   1246: aload_0
    //   1247: getfield 405	avpk:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1250: iconst_1
    //   1251: anewarray 162	java/lang/String
    //   1254: dup
    //   1255: iconst_0
    //   1256: ldc_w 439
    //   1259: aastore
    //   1260: invokevirtual 443	avpk:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   1263: goto -1242 -> 21
    //   1266: iconst_0
    //   1267: istore 6
    //   1269: goto -188 -> 1081
    //   1272: iload 6
    //   1274: ifeq +110 -> 1384
    //   1277: sipush 30003
    //   1280: istore 6
    //   1282: aload_0
    //   1283: iload 6
    //   1285: putfield 104	avpk:jdField_b_of_type_Int	I
    //   1288: goto -172 -> 1116
    //   1291: astore 4
    //   1293: invokestatic 183	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1296: ifeq -180 -> 1116
    //   1299: aload_0
    //   1300: getfield 446	avpk:TAG	Ljava/lang/String;
    //   1303: iconst_2
    //   1304: new 187	java/lang/StringBuilder
    //   1307: dup
    //   1308: invokespecial 188	java/lang/StringBuilder:<init>	()V
    //   1311: ldc_w 448
    //   1314: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1317: aload_3
    //   1318: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1321: invokevirtual 200	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1324: invokestatic 202	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1327: goto -211 -> 1116
    //   1330: astore_1
    //   1331: invokestatic 183	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1334: ifeq +29 -> 1363
    //   1337: ldc 185
    //   1339: iconst_2
    //   1340: new 187	java/lang/StringBuilder
    //   1343: dup
    //   1344: invokespecial 188	java/lang/StringBuilder:<init>	()V
    //   1347: ldc_w 450
    //   1350: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1353: aload_1
    //   1354: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1357: invokevirtual 200	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1360: invokestatic 437	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1363: aload_0
    //   1364: aload_0
    //   1365: getfield 405	avpk:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1368: iconst_1
    //   1369: anewarray 162	java/lang/String
    //   1372: dup
    //   1373: iconst_0
    //   1374: ldc_w 452
    //   1377: aastore
    //   1378: invokevirtual 443	avpk:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   1381: goto -1360 -> 21
    //   1384: sipush 30005
    //   1387: istore 6
    //   1389: goto -107 -> 1282
    //   1392: iload 6
    //   1394: ifeq +514 -> 1908
    //   1397: sipush 30003
    //   1400: istore 6
    //   1402: aload_0
    //   1403: iload 6
    //   1405: putfield 104	avpk:jdField_b_of_type_Int	I
    //   1408: goto -292 -> 1116
    //   1411: aload_0
    //   1412: iload 6
    //   1414: putfield 104	avpk:jdField_b_of_type_Int	I
    //   1417: goto -301 -> 1116
    //   1420: aload_0
    //   1421: iload 6
    //   1423: putfield 104	avpk:jdField_b_of_type_Int	I
    //   1426: goto -310 -> 1116
    //   1429: aload_0
    //   1430: iload 6
    //   1432: putfield 104	avpk:jdField_b_of_type_Int	I
    //   1435: goto -319 -> 1116
    //   1438: sipush 30019
    //   1441: istore 6
    //   1443: goto -14 -> 1429
    //   1446: aload_0
    //   1447: getfield 29	avpk:jdField_a_of_type_Aanz	Laanz;
    //   1450: aload_1
    //   1451: ldc_w 453
    //   1454: invokevirtual 456	aanz:a	(Ljava/lang/String;I)V
    //   1457: goto -1436 -> 21
    //   1460: ldc_w 458
    //   1463: aload 4
    //   1465: invokevirtual 166	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1468: ifeq +157 -> 1625
    //   1471: aload 5
    //   1473: iconst_0
    //   1474: aaload
    //   1475: astore_1
    //   1476: ldc_w 460
    //   1479: iconst_1
    //   1480: new 187	java/lang/StringBuilder
    //   1483: dup
    //   1484: invokespecial 188	java/lang/StringBuilder:<init>	()V
    //   1487: ldc_w 462
    //   1490: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1493: aload_1
    //   1494: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1497: invokevirtual 200	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1500: invokestatic 465	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1503: new 174	org/json/JSONObject
    //   1506: dup
    //   1507: aload_1
    //   1508: invokespecial 177	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1511: astore_1
    //   1512: aload_1
    //   1513: ldc_w 467
    //   1516: invokevirtual 348	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   1519: istore 6
    //   1521: aload_1
    //   1522: ldc_w 469
    //   1525: invokevirtual 208	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1528: pop
    //   1529: aload_1
    //   1530: ldc 204
    //   1532: invokevirtual 208	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1535: astore_1
    //   1536: iload 6
    //   1538: ifne -1517 -> 21
    //   1541: aload_0
    //   1542: getfield 47	avpk:mRuntime	Lbhod;
    //   1545: invokevirtual 52	bhod:a	()Landroid/app/Activity;
    //   1548: checkcast 471	com/tencent/mobileqq/app/BaseActivity
    //   1551: astore_2
    //   1552: aload_2
    //   1553: ifnonnull +5 -> 1558
    //   1556: iconst_0
    //   1557: ireturn
    //   1558: new 473	android/content/Intent
    //   1561: dup
    //   1562: invokespecial 474	android/content/Intent:<init>	()V
    //   1565: astore_3
    //   1566: aload_3
    //   1567: ldc_w 475
    //   1570: invokevirtual 479	android/content/Intent:addFlags	(I)Landroid/content/Intent;
    //   1573: pop
    //   1574: aload_3
    //   1575: ldc_w 481
    //   1578: iconst_2
    //   1579: invokevirtual 485	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   1582: pop
    //   1583: aload_3
    //   1584: ldc_w 487
    //   1587: aload_1
    //   1588: invokevirtual 490	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1591: pop
    //   1592: aload_2
    //   1593: aload_3
    //   1594: ldc_w 492
    //   1597: ldc_w 494
    //   1600: invokestatic 499	aevv:a	(Landroid/content/Context;Landroid/content/Intent;Ljava/lang/Class;Ljava/lang/Class;)V
    //   1603: aload_2
    //   1604: iconst_0
    //   1605: iconst_0
    //   1606: invokevirtual 502	com/tencent/mobileqq/app/BaseActivity:overridePendingTransition	(II)V
    //   1609: goto -1588 -> 21
    //   1612: astore_1
    //   1613: invokestatic 183	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1616: ifeq +7 -> 1623
    //   1619: aload_1
    //   1620: invokevirtual 505	java/lang/Exception:printStackTrace	()V
    //   1623: iconst_0
    //   1624: ireturn
    //   1625: ldc_w 507
    //   1628: aload 4
    //   1630: invokevirtual 166	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1633: ifeq +143 -> 1776
    //   1636: aload 5
    //   1638: ifnull -1617 -> 21
    //   1641: aload 5
    //   1643: arraylength
    //   1644: ifle -1623 -> 21
    //   1647: invokestatic 183	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1650: ifeq +32 -> 1682
    //   1653: ldc 185
    //   1655: iconst_2
    //   1656: new 187	java/lang/StringBuilder
    //   1659: dup
    //   1660: invokespecial 188	java/lang/StringBuilder:<init>	()V
    //   1663: ldc_w 509
    //   1666: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1669: aload 5
    //   1671: iconst_0
    //   1672: aaload
    //   1673: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1676: invokevirtual 200	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1679: invokestatic 437	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1682: new 174	org/json/JSONObject
    //   1685: dup
    //   1686: aload 5
    //   1688: iconst_0
    //   1689: aaload
    //   1690: invokespecial 177	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1693: astore_1
    //   1694: aload_1
    //   1695: ldc 204
    //   1697: invokevirtual 208	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1700: aload_1
    //   1701: ldc_w 511
    //   1704: invokevirtual 348	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   1707: invokestatic 516	com/tencent/mobileqq/activity/TroopInfoActivity:a	(Ljava/lang/String;I)Landroid/os/Bundle;
    //   1710: astore_2
    //   1711: aload_2
    //   1712: ldc_w 401
    //   1715: aload_1
    //   1716: ldc_w 401
    //   1719: invokevirtual 208	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1722: invokevirtual 522	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1725: aload_0
    //   1726: getfield 47	avpk:mRuntime	Lbhod;
    //   1729: invokevirtual 52	bhod:a	()Landroid/app/Activity;
    //   1732: aload_2
    //   1733: iconst_2
    //   1734: invokestatic 527	bfup:a	(Landroid/content/Context;Landroid/os/Bundle;I)V
    //   1737: goto -1716 -> 21
    //   1740: astore_1
    //   1741: invokestatic 183	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1744: ifeq -1723 -> 21
    //   1747: ldc 185
    //   1749: iconst_2
    //   1750: new 187	java/lang/StringBuilder
    //   1753: dup
    //   1754: invokespecial 188	java/lang/StringBuilder:<init>	()V
    //   1757: ldc_w 529
    //   1760: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1763: aload_1
    //   1764: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1767: invokevirtual 200	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1770: invokestatic 437	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1773: goto -1752 -> 21
    //   1776: ldc_w 531
    //   1779: aload 4
    //   1781: invokevirtual 166	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1784: ifeq -1763 -> 21
    //   1787: new 174	org/json/JSONObject
    //   1790: dup
    //   1791: aload 5
    //   1793: iconst_0
    //   1794: aaload
    //   1795: invokespecial 177	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1798: astore_1
    //   1799: aload_1
    //   1800: ldc_w 533
    //   1803: invokevirtual 536	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   1806: istore 6
    //   1808: aload_1
    //   1809: ldc_w 538
    //   1812: invokevirtual 338	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1815: astore_1
    //   1816: invokestatic 183	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1819: ifeq +32 -> 1851
    //   1822: ldc_w 540
    //   1825: iconst_2
    //   1826: ldc_w 542
    //   1829: iconst_2
    //   1830: anewarray 544	java/lang/Object
    //   1833: dup
    //   1834: iconst_0
    //   1835: aload_1
    //   1836: aastore
    //   1837: dup
    //   1838: iconst_1
    //   1839: iload 6
    //   1841: invokestatic 548	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1844: aastore
    //   1845: invokestatic 552	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   1848: invokestatic 202	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1851: aload_1
    //   1852: invokestatic 557	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1855: ifne -1834 -> 21
    //   1858: aload_0
    //   1859: getfield 29	avpk:jdField_a_of_type_Aanz	Laanz;
    //   1862: astore_2
    //   1863: iload 6
    //   1865: iconst_1
    //   1866: if_icmpne +36 -> 1902
    //   1869: iconst_1
    //   1870: istore 12
    //   1872: aload_2
    //   1873: aload_1
    //   1874: iload 12
    //   1876: invokevirtual 560	aanz:c	(Ljava/lang/String;Z)V
    //   1879: goto -1858 -> 21
    //   1882: astore_1
    //   1883: aload_1
    //   1884: invokevirtual 505	java/lang/Exception:printStackTrace	()V
    //   1887: aload_0
    //   1888: getfield 446	avpk:TAG	Ljava/lang/String;
    //   1891: iconst_1
    //   1892: ldc_w 562
    //   1895: aload_1
    //   1896: invokestatic 564	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1899: goto -1878 -> 21
    //   1902: iconst_0
    //   1903: istore 12
    //   1905: goto -33 -> 1872
    //   1908: sipush 30007
    //   1911: istore 6
    //   1913: goto -511 -> 1402
    //   1916: iload 6
    //   1918: ifeq +11 -> 1929
    //   1921: sipush 30009
    //   1924: istore 6
    //   1926: goto -515 -> 1411
    //   1929: sipush 30011
    //   1932: istore 6
    //   1934: goto -523 -> 1411
    //   1937: iload 6
    //   1939: ifeq +11 -> 1950
    //   1942: sipush 30013
    //   1945: istore 6
    //   1947: goto -527 -> 1420
    //   1950: sipush 30015
    //   1953: istore 6
    //   1955: goto -535 -> 1420
    //   1958: iload 6
    //   1960: ifeq -522 -> 1438
    //   1963: sipush 30017
    //   1966: istore 6
    //   1968: goto -539 -> 1429
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1971	0	this	avpk
    //   0	1971	1	paramJsBridgeListener	com.tencent.mobileqq.webview.swift.JsBridgeListener
    //   0	1971	2	paramString1	String
    //   0	1971	3	paramString2	String
    //   0	1971	4	paramString3	String
    //   0	1971	5	paramVarArgs	String[]
    //   637	1330	6	i	int
    //   1063	19	7	j	int
    //   106	29	8	l1	long
    //   114	23	10	l2	long
    //   1052	852	12	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   43	86	148	java/lang/Exception
    //   86	145	148	java/lang/Exception
    //   177	220	396	java/lang/Exception
    //   220	261	396	java/lang/Exception
    //   265	308	396	java/lang/Exception
    //   312	393	396	java/lang/Exception
    //   420	463	396	java/lang/Exception
    //   467	548	396	java/lang/Exception
    //   562	616	671	java/lang/Exception
    //   616	668	671	java/lang/Exception
    //   702	760	797	java/lang/Exception
    //   760	794	797	java/lang/Exception
    //   828	872	918	java/lang/Exception
    //   872	915	918	java/lang/Exception
    //   949	993	1212	org/json/JSONException
    //   993	1031	1212	org/json/JSONException
    //   1040	1054	1212	org/json/JSONException
    //   1059	1072	1212	org/json/JSONException
    //   1116	1198	1212	org/json/JSONException
    //   1202	1209	1212	org/json/JSONException
    //   1282	1288	1212	org/json/JSONException
    //   1293	1327	1212	org/json/JSONException
    //   1402	1408	1212	org/json/JSONException
    //   1411	1417	1212	org/json/JSONException
    //   1420	1426	1212	org/json/JSONException
    //   1429	1435	1212	org/json/JSONException
    //   1446	1457	1212	org/json/JSONException
    //   1059	1072	1291	java/lang/NumberFormatException
    //   1282	1288	1291	java/lang/NumberFormatException
    //   1402	1408	1291	java/lang/NumberFormatException
    //   1411	1417	1291	java/lang/NumberFormatException
    //   1420	1426	1291	java/lang/NumberFormatException
    //   1429	1435	1291	java/lang/NumberFormatException
    //   949	993	1330	java/lang/Exception
    //   993	1031	1330	java/lang/Exception
    //   1040	1054	1330	java/lang/Exception
    //   1059	1072	1330	java/lang/Exception
    //   1116	1198	1330	java/lang/Exception
    //   1202	1209	1330	java/lang/Exception
    //   1282	1288	1330	java/lang/Exception
    //   1293	1327	1330	java/lang/Exception
    //   1402	1408	1330	java/lang/Exception
    //   1411	1417	1330	java/lang/Exception
    //   1420	1426	1330	java/lang/Exception
    //   1429	1435	1330	java/lang/Exception
    //   1446	1457	1330	java/lang/Exception
    //   1476	1536	1612	java/lang/Exception
    //   1541	1552	1612	java/lang/Exception
    //   1558	1609	1612	java/lang/Exception
    //   1641	1682	1740	org/json/JSONException
    //   1682	1737	1740	org/json/JSONException
    //   1787	1851	1882	java/lang/Exception
    //   1851	1863	1882	java/lang/Exception
    //   1872	1879	1882	java/lang/Exception
  }
  
  public void onActivityResult(Intent paramIntent, byte paramByte, int paramInt)
  {
    super.onActivityResult(paramIntent, paramByte, paramInt);
    if (paramByte == 4)
    {
      if (paramInt != -1) {
        break label94;
      }
      if (paramIntent != null) {
        break label75;
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
        label75:
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
    label94:
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
    } while (this.jdField_a_of_type_Aanz == null);
    this.jdField_a_of_type_Aanz.a(this.jdField_a_of_type_Anxg);
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      this.jdField_a_of_type_Aanz.b(this.jdField_a_of_type_Anxg);
      this.jdField_a_of_type_Aanz.b();
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopDataVideoUploadTask != null) && (!this.jdField_a_of_type_ComTencentMobileqqTroopDataVideoUploadTask.a())) {
      this.jdField_a_of_type_ComTencentMobileqqTroopDataVideoUploadTask.a();
    }
    if (this.jdField_b_of_type_Aanz != null) {
      this.jdField_b_of_type_Aanz.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avpk
 * JD-Core Version:    0.7.0.1
 */