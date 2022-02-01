package com.tencent.mobileqq.activity.contact.addcontact;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;
import mqq.app.QQPermissionDenied;
import mqq.app.QQPermissionGrant;

public class InvitationWebViewPlugin
  extends WebViewPlugin
  implements DialogInterface.OnDismissListener, AdapterView.OnItemClickListener
{
  private ShareActionSheetBuilder jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder;
  private String jdField_a_of_type_JavaLangString;
  private String b;
  private String c;
  
  public InvitationWebViewPlugin()
  {
    this.mPluginNameSpace = "newLogin";
  }
  
  private void a()
  {
    QLog.d("InvitationFriend", 1, "handleRegWithNickAndPwd");
    ReportController.a(null, "dc00898", "", "", "0X800B338", "0X800B338", 0, 0, "", "", "", "");
    Intent localIntent = new Intent();
    localIntent.putExtra("key_reg_from_phone_protect_h5", true);
    RouteUtils.a(this.mRuntime.a(), localIntent, "/base/safe/registerByNickAndPwd");
  }
  
  private void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    Intent localIntent = new Intent("android.intent.action.SENDTO", Uri.parse("smsto:"));
    localIntent.putExtra("sms_body", paramString);
    this.mRuntime.a().startActivity(localIntent);
  }
  
  private void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    QLog.d("InvitationFriend", 1, "METHOD_LOGIN_WITH_UIN_MASK success, jump to LoginActivity, enableLoginWithMask: " + paramBoolean + "uinMask: " + paramString1);
    ReportController.a(null, "dc00898", "", "", "0X800B337", "0X800B337", 0, 0, "", "", "", "");
    Intent localIntent = new Intent();
    if (paramBoolean)
    {
      localIntent.putExtra("is_need_login_with_mask", true);
      localIntent.putExtra("uinMask", paramString1);
      localIntent.putExtra("uinEncrpyt", paramString2);
    }
    RouteUtils.a(this.mRuntime.a(), localIntent, "/base/login");
  }
  
  private boolean a()
  {
    return (this.mRuntime == null) || (this.mRuntime.a() == null);
  }
  
  private boolean a(String[] paramArrayOfString)
  {
    return (paramArrayOfString == null) || (paramArrayOfString.length == 0);
  }
  
  private List<ShareActionSheetBuilder.ActionSheetItem>[] a()
  {
    ArrayList localArrayList = new ArrayList();
    ShareActionSheetBuilder.ActionSheetItem localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.label = BaseApplicationImpl.getApplication().getString(2131696401);
    localActionSheetItem.icon = 2130839218;
    localActionSheetItem.action = 9;
    localActionSheetItem.argus = "";
    localArrayList.add(localActionSheetItem);
    localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.label = BaseApplicationImpl.getApplication().getString(2131696383);
    localActionSheetItem.icon = 2130839212;
    localActionSheetItem.action = 10;
    localActionSheetItem.argus = "";
    localArrayList.add(localActionSheetItem);
    localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.label = HardCodeUtil.a(2131705853);
    localActionSheetItem.icon = 2130839210;
    localActionSheetItem.iconNeedBg = true;
    localActionSheetItem.action = 1;
    localActionSheetItem.argus = "";
    localArrayList.add(localActionSheetItem);
    localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.label = BaseApplicationImpl.getApplication().getString(2131696372);
    localActionSheetItem.icon = 2130839210;
    localActionSheetItem.iconNeedBg = true;
    localActionSheetItem.action = 1;
    localActionSheetItem.argus = "";
    localArrayList.add(localActionSheetItem);
    return (List[])new ArrayList[] { localArrayList };
  }
  
  @QQPermissionDenied(1)
  @TargetApi(23)
  public void denied()
  {
    QLog.d("InvitationFriend", 1, "CheckPermission user denied = sms");
    QQToast.a(this.mRuntime.a(), HardCodeUtil.a(2131705851), 1).a();
  }
  
  @QQPermissionGrant(1)
  public void grant()
  {
    QLog.d("InvitationFriend", 1, "CheckPermission user grant = sms");
    if (!TextUtils.isEmpty(this.c)) {
      a(this.c);
    }
  }
  
  /* Error */
  public boolean handleJsRequest(com.tencent.mobileqq.webview.swift.JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    // Byte code:
    //   0: invokestatic 220	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +57 -> 60
    //   6: ldc 25
    //   8: iconst_2
    //   9: new 103	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 104	java/lang/StringBuilder:<init>	()V
    //   16: ldc 222
    //   18: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: aload_2
    //   22: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: ldc 224
    //   27: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: aload 4
    //   32: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: ldc 226
    //   37: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: aload_3
    //   41: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: ldc 228
    //   46: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: aload 5
    //   51: invokevirtual 231	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   54: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   57: invokestatic 234	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   60: ldc 19
    //   62: aload_3
    //   63: invokevirtual 239	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   66: ifne +5 -> 71
    //   69: iconst_0
    //   70: ireturn
    //   71: ldc 241
    //   73: aload 4
    //   75: invokevirtual 245	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   78: ifeq +124 -> 202
    //   81: aload 5
    //   83: ifnull +10 -> 93
    //   86: aload 5
    //   88: arraylength
    //   89: iconst_1
    //   90: if_icmpeq +5 -> 95
    //   93: iconst_0
    //   94: ireturn
    //   95: aload 5
    //   97: iconst_0
    //   98: aaload
    //   99: astore_1
    //   100: new 247	org/json/JSONObject
    //   103: dup
    //   104: aload_1
    //   105: invokespecial 249	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   108: astore_1
    //   109: aload_1
    //   110: ldc 251
    //   112: invokevirtual 254	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   115: astore_2
    //   116: aload_0
    //   117: aload_1
    //   118: ldc_w 256
    //   121: invokevirtual 254	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   124: putfield 258	com/tencent/mobileqq/activity/contact/addcontact/InvitationWebViewPlugin:b	Ljava/lang/String;
    //   127: getstatic 263	android/os/Build$VERSION:SDK_INT	I
    //   130: bipush 23
    //   132: if_icmplt +62 -> 194
    //   135: aload_0
    //   136: getfield 57	com/tencent/mobileqq/activity/contact/addcontact/InvitationWebViewPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   139: invokevirtual 62	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   142: ldc_w 265
    //   145: invokevirtual 269	android/app/Activity:checkSelfPermission	(Ljava/lang/String;)I
    //   148: ifeq +38 -> 186
    //   151: aload_0
    //   152: aload_2
    //   153: putfield 209	com/tencent/mobileqq/activity/contact/addcontact/InvitationWebViewPlugin:c	Ljava/lang/String;
    //   156: aload_0
    //   157: getfield 57	com/tencent/mobileqq/activity/contact/addcontact/InvitationWebViewPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   160: invokevirtual 62	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   163: checkcast 271	mqq/app/AppActivity
    //   166: aload_0
    //   167: iconst_1
    //   168: iconst_1
    //   169: anewarray 236	java/lang/String
    //   172: dup
    //   173: iconst_0
    //   174: ldc_w 265
    //   177: aastore
    //   178: invokevirtual 275	mqq/app/AppActivity:requestPermissions	(Ljava/lang/Object;I[Ljava/lang/String;)V
    //   181: iconst_1
    //   182: ireturn
    //   183: astore_1
    //   184: iconst_0
    //   185: ireturn
    //   186: aload_0
    //   187: aload_2
    //   188: invokespecial 211	com/tencent/mobileqq/activity/contact/addcontact/InvitationWebViewPlugin:a	(Ljava/lang/String;)V
    //   191: goto -10 -> 181
    //   194: aload_0
    //   195: aload_2
    //   196: invokespecial 211	com/tencent/mobileqq/activity/contact/addcontact/InvitationWebViewPlugin:a	(Ljava/lang/String;)V
    //   199: goto -18 -> 181
    //   202: ldc_w 277
    //   205: aload 4
    //   207: invokevirtual 245	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   210: ifeq +190 -> 400
    //   213: aload 5
    //   215: ifnull +10 -> 225
    //   218: aload 5
    //   220: arraylength
    //   221: iconst_1
    //   222: if_icmpeq +5 -> 227
    //   225: iconst_0
    //   226: ireturn
    //   227: aload 5
    //   229: iconst_0
    //   230: aaload
    //   231: astore_1
    //   232: aload_0
    //   233: new 247	org/json/JSONObject
    //   236: dup
    //   237: aload_1
    //   238: invokespecial 249	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   241: ldc_w 256
    //   244: invokevirtual 254	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   247: putfield 279	com/tencent/mobileqq/activity/contact/addcontact/InvitationWebViewPlugin:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   250: aload_0
    //   251: getfield 57	com/tencent/mobileqq/activity/contact/addcontact/InvitationWebViewPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   254: invokevirtual 62	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   257: astore_1
    //   258: aload_0
    //   259: getfield 281	com/tencent/mobileqq/activity/contact/addcontact/InvitationWebViewPlugin:jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder	Lcom/tencent/mobileqq/utils/ShareActionSheetBuilder;
    //   262: ifnonnull +15 -> 277
    //   265: aload_0
    //   266: new 283	com/tencent/mobileqq/utils/ShareActionSheetBuilder
    //   269: dup
    //   270: aload_1
    //   271: invokespecial 286	com/tencent/mobileqq/utils/ShareActionSheetBuilder:<init>	(Landroid/content/Context;)V
    //   274: putfield 281	com/tencent/mobileqq/activity/contact/addcontact/InvitationWebViewPlugin:jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder	Lcom/tencent/mobileqq/utils/ShareActionSheetBuilder;
    //   277: aload_0
    //   278: getfield 281	com/tencent/mobileqq/activity/contact/addcontact/InvitationWebViewPlugin:jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder	Lcom/tencent/mobileqq/utils/ShareActionSheetBuilder;
    //   281: ldc_w 287
    //   284: invokestatic 174	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   287: invokevirtual 291	com/tencent/mobileqq/utils/ShareActionSheetBuilder:setActionSheetTitle	(Ljava/lang/CharSequence;)V
    //   290: aload_0
    //   291: getfield 281	com/tencent/mobileqq/activity/contact/addcontact/InvitationWebViewPlugin:jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder	Lcom/tencent/mobileqq/utils/ShareActionSheetBuilder;
    //   294: aload_0
    //   295: invokespecial 293	com/tencent/mobileqq/activity/contact/addcontact/InvitationWebViewPlugin:a	()[Ljava/util/List;
    //   298: invokevirtual 297	com/tencent/mobileqq/utils/ShareActionSheetBuilder:setActionSheetItems	([Ljava/util/List;)V
    //   301: aload_0
    //   302: getfield 281	com/tencent/mobileqq/activity/contact/addcontact/InvitationWebViewPlugin:jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder	Lcom/tencent/mobileqq/utils/ShareActionSheetBuilder;
    //   305: aload_0
    //   306: invokevirtual 301	com/tencent/mobileqq/utils/ShareActionSheetBuilder:setItemClickListener	(Landroid/widget/AdapterView$OnItemClickListener;)V
    //   309: aload_0
    //   310: getfield 281	com/tencent/mobileqq/activity/contact/addcontact/InvitationWebViewPlugin:jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder	Lcom/tencent/mobileqq/utils/ShareActionSheetBuilder;
    //   313: aload_0
    //   314: invokevirtual 305	com/tencent/mobileqq/utils/ShareActionSheetBuilder:setOnDismissListener	(Landroid/content/DialogInterface$OnDismissListener;)V
    //   317: aload_1
    //   318: invokevirtual 308	android/app/Activity:isFinishing	()Z
    //   321: ifne +77 -> 398
    //   324: aload_0
    //   325: getfield 281	com/tencent/mobileqq/activity/contact/addcontact/InvitationWebViewPlugin:jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder	Lcom/tencent/mobileqq/utils/ShareActionSheetBuilder;
    //   328: invokevirtual 311	com/tencent/mobileqq/utils/ShareActionSheetBuilder:show	()V
    //   331: aconst_null
    //   332: ldc 35
    //   334: ldc 37
    //   336: ldc 37
    //   338: ldc_w 313
    //   341: ldc_w 313
    //   344: iconst_0
    //   345: iconst_0
    //   346: ldc 37
    //   348: ldc 37
    //   350: ldc 37
    //   352: ldc 37
    //   354: invokestatic 315	com/tencent/mobileqq/statistics/ReportController:b	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   357: iconst_1
    //   358: ireturn
    //   359: astore_1
    //   360: iconst_0
    //   361: ireturn
    //   362: astore_1
    //   363: invokestatic 220	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   366: ifeq -9 -> 357
    //   369: ldc 25
    //   371: iconst_2
    //   372: new 103	java/lang/StringBuilder
    //   375: dup
    //   376: invokespecial 104	java/lang/StringBuilder:<init>	()V
    //   379: ldc_w 317
    //   382: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   385: aload_1
    //   386: invokevirtual 231	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   389: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   392: invokestatic 33	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   395: goto -38 -> 357
    //   398: iconst_0
    //   399: ireturn
    //   400: ldc_w 319
    //   403: aload 4
    //   405: invokevirtual 245	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   408: ifeq +121 -> 529
    //   411: invokestatic 220	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   414: ifeq +12 -> 426
    //   417: ldc 25
    //   419: iconst_2
    //   420: ldc_w 321
    //   423: invokestatic 33	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   426: aload_0
    //   427: getfield 57	com/tencent/mobileqq/activity/contact/addcontact/InvitationWebViewPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   430: ifnull +87 -> 517
    //   433: aload_0
    //   434: getfield 57	com/tencent/mobileqq/activity/contact/addcontact/InvitationWebViewPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   437: invokevirtual 62	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   440: ifnull +77 -> 517
    //   443: new 46	android/content/Intent
    //   446: dup
    //   447: invokespecial 47	android/content/Intent:<init>	()V
    //   450: astore_1
    //   451: aload_1
    //   452: ldc_w 323
    //   455: invokevirtual 327	android/content/Intent:setAction	(Ljava/lang/String;)Landroid/content/Intent;
    //   458: pop
    //   459: aload_1
    //   460: invokestatic 333	mqq/app/MobileQQ:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   463: invokevirtual 338	com/tencent/qphone/base/util/BaseApplication:getPackageName	()Ljava/lang/String;
    //   466: invokevirtual 341	android/content/Intent:setPackage	(Ljava/lang/String;)Landroid/content/Intent;
    //   469: pop
    //   470: aload_0
    //   471: getfield 57	com/tencent/mobileqq/activity/contact/addcontact/InvitationWebViewPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   474: invokevirtual 62	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   477: aload_1
    //   478: invokevirtual 344	android/app/Activity:sendBroadcast	(Landroid/content/Intent;)V
    //   481: goto -300 -> 181
    //   484: astore_1
    //   485: ldc 25
    //   487: iconst_1
    //   488: new 103	java/lang/StringBuilder
    //   491: dup
    //   492: invokespecial 104	java/lang/StringBuilder:<init>	()V
    //   495: ldc_w 346
    //   498: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   501: aload_1
    //   502: invokevirtual 349	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   505: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   508: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   511: invokestatic 352	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   514: goto -333 -> 181
    //   517: ldc 25
    //   519: iconst_1
    //   520: ldc_w 354
    //   523: invokestatic 352	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   526: goto -345 -> 181
    //   529: ldc_w 356
    //   532: aload 4
    //   534: invokevirtual 245	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   537: ifeq +134 -> 671
    //   540: ldc 25
    //   542: iconst_1
    //   543: ldc_w 358
    //   546: invokestatic 33	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   549: aload_0
    //   550: aload 5
    //   552: invokespecial 360	com/tencent/mobileqq/activity/contact/addcontact/InvitationWebViewPlugin:a	([Ljava/lang/String;)Z
    //   555: ifeq +14 -> 569
    //   558: ldc 25
    //   560: iconst_1
    //   561: ldc_w 362
    //   564: invokestatic 352	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   567: iconst_0
    //   568: ireturn
    //   569: aload_0
    //   570: invokespecial 364	com/tencent/mobileqq/activity/contact/addcontact/InvitationWebViewPlugin:a	()Z
    //   573: ifeq +14 -> 587
    //   576: ldc 25
    //   578: iconst_1
    //   579: ldc_w 366
    //   582: invokestatic 352	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   585: iconst_0
    //   586: ireturn
    //   587: new 247	org/json/JSONObject
    //   590: dup
    //   591: aload 5
    //   593: iconst_0
    //   594: aaload
    //   595: invokespecial 249	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   598: astore_1
    //   599: aload_1
    //   600: ldc 125
    //   602: invokevirtual 369	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   605: astore_2
    //   606: aload_1
    //   607: ldc 127
    //   609: invokevirtual 369	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   612: astore_3
    //   613: aload_1
    //   614: ldc_w 371
    //   617: invokevirtual 374	org/json/JSONObject:optBoolean	(Ljava/lang/String;)Z
    //   620: istore 6
    //   622: aload_2
    //   623: invokestatic 76	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   626: ifne +10 -> 636
    //   629: aload_3
    //   630: invokestatic 76	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   633: ifeq +27 -> 660
    //   636: ldc 25
    //   638: iconst_1
    //   639: ldc_w 376
    //   642: invokestatic 352	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   645: iconst_0
    //   646: ireturn
    //   647: astore_1
    //   648: ldc 25
    //   650: iconst_1
    //   651: ldc_w 378
    //   654: aload_1
    //   655: invokestatic 381	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   658: iconst_0
    //   659: ireturn
    //   660: aload_0
    //   661: aload_2
    //   662: aload_3
    //   663: iload 6
    //   665: invokespecial 383	com/tencent/mobileqq/activity/contact/addcontact/InvitationWebViewPlugin:a	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   668: goto -487 -> 181
    //   671: ldc_w 385
    //   674: aload 4
    //   676: invokevirtual 245	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   679: ifeq +37 -> 716
    //   682: ldc 25
    //   684: iconst_1
    //   685: ldc_w 387
    //   688: invokestatic 33	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   691: aload_0
    //   692: invokespecial 364	com/tencent/mobileqq/activity/contact/addcontact/InvitationWebViewPlugin:a	()Z
    //   695: ifeq +14 -> 709
    //   698: ldc 25
    //   700: iconst_1
    //   701: ldc_w 389
    //   704: invokestatic 352	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   707: iconst_0
    //   708: ireturn
    //   709: aload_0
    //   710: invokespecial 391	com/tencent/mobileqq/activity/contact/addcontact/InvitationWebViewPlugin:a	()V
    //   713: goto -532 -> 181
    //   716: ldc_w 393
    //   719: aload 4
    //   721: invokevirtual 239	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   724: ifeq -543 -> 181
    //   727: invokestatic 220	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   730: ifeq +12 -> 742
    //   733: ldc 25
    //   735: iconst_2
    //   736: ldc_w 395
    //   739: invokestatic 33	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   742: aload_0
    //   743: getfield 57	com/tencent/mobileqq/activity/contact/addcontact/InvitationWebViewPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   746: ifnull +54 -> 800
    //   749: aload_0
    //   750: getfield 57	com/tencent/mobileqq/activity/contact/addcontact/InvitationWebViewPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   753: invokevirtual 62	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   756: ifnull +44 -> 800
    //   759: new 46	android/content/Intent
    //   762: dup
    //   763: invokespecial 47	android/content/Intent:<init>	()V
    //   766: astore_1
    //   767: aload_1
    //   768: ldc_w 397
    //   771: invokevirtual 327	android/content/Intent:setAction	(Ljava/lang/String;)Landroid/content/Intent;
    //   774: pop
    //   775: aload_1
    //   776: invokestatic 333	mqq/app/MobileQQ:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   779: invokevirtual 338	com/tencent/qphone/base/util/BaseApplication:getPackageName	()Ljava/lang/String;
    //   782: invokevirtual 341	android/content/Intent:setPackage	(Ljava/lang/String;)Landroid/content/Intent;
    //   785: pop
    //   786: aload_0
    //   787: getfield 57	com/tencent/mobileqq/activity/contact/addcontact/InvitationWebViewPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   790: invokevirtual 62	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   793: aload_1
    //   794: invokevirtual 344	android/app/Activity:sendBroadcast	(Landroid/content/Intent;)V
    //   797: goto -616 -> 181
    //   800: ldc 25
    //   802: iconst_1
    //   803: ldc_w 354
    //   806: invokestatic 352	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   809: goto -628 -> 181
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	812	0	this	InvitationWebViewPlugin
    //   0	812	1	paramJsBridgeListener	com.tencent.mobileqq.webview.swift.JsBridgeListener
    //   0	812	2	paramString1	String
    //   0	812	3	paramString2	String
    //   0	812	4	paramString3	String
    //   0	812	5	paramVarArgs	String[]
    //   620	44	6	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   100	127	183	org/json/JSONException
    //   232	250	359	org/json/JSONException
    //   324	357	362	java/lang/Exception
    //   411	426	484	java/lang/Exception
    //   426	481	484	java/lang/Exception
    //   517	526	484	java/lang/Exception
    //   587	599	647	java/lang/Exception
  }
  
  public void onDismiss(DialogInterface paramDialogInterface) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    callJs(this.jdField_a_of_type_JavaLangString, new String[] { String.valueOf(paramInt) });
    String str = "";
    if (paramInt == 0) {
      str = "0X80096FA";
    }
    for (;;)
    {
      if (!"".equals(str)) {
        ReportController.b(null, "dc00898", "", "", str, str, 0, 0, "", "", "", "");
      }
      EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
      return;
      if (paramInt == 1) {
        str = "0X80096FB";
      } else if (paramInt == 2) {
        str = "0X80096FC";
      } else if (paramInt == 3) {
        str = "0X80096FD";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.InvitationWebViewPlugin
 * JD-Core Version:    0.7.0.1
 */