package com.tencent.mobileqq.activity.contact.addcontact;

import amtj;
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
import bcef;
import bgve;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.LoginActivity;
import com.tencent.mobileqq.activity.RegisterByNicknameAndPwdActivity;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
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
  public static final String ACTION = "com.tencent.mobileqq.InvitationWebViewPlugin";
  public static final String AUTHORITY_ACTION = "com.tencent.mobileqq.InvitationWebViewPlugin.accountIdentityNotify";
  public static final String ENABLE_LOGIN_WITH_MASK = "enableLoginWithUinMask";
  public static final String METHOD_LOGIN_WITH_UIN_MASK = "loginWithUinMask";
  public static final String METHOD_REG_WITH_NICK_PWD = "registerWithNickAndPwd";
  public static final String PLUGIN_METHOD_AUTHORITY_FINISH = "accountIdentityNotify";
  public static final String PLUGIN_METHOD_AUTO_LOGIN = "AutoLogin";
  public static final String PLUGIN_METHOD_SEND_MESSAGE = "shareSMS";
  public static final String PLUGIN_METHOD_SHOW_SHARE_DIALOG = "callShare";
  public static final String PLUGIN_NAMESPACE = "newLogin";
  public static final String TAG = "InvitationFriend";
  public static final String UIN_ENCRYPT = "uinEncrpyt";
  public static final String UIN_MASK = "uinMask";
  private String mSendMsgCallback;
  private String mShareCallback;
  private ShareActionSheetBuilder mShareDialogBuilder;
  private String mSmsContent;
  
  public InvitationWebViewPlugin()
  {
    this.mPluginNameSpace = "newLogin";
  }
  
  private List<ShareActionSheetBuilder.ActionSheetItem>[] getActionSheetItems()
  {
    ArrayList localArrayList = new ArrayList();
    ShareActionSheetBuilder.ActionSheetItem localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.label = BaseApplicationImpl.getApplication().getString(2131695898);
    localActionSheetItem.icon = 2130839130;
    localActionSheetItem.action = 9;
    localActionSheetItem.argus = "";
    localArrayList.add(localActionSheetItem);
    localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.label = BaseApplicationImpl.getApplication().getString(2131695881);
    localActionSheetItem.icon = 2130839124;
    localActionSheetItem.action = 10;
    localActionSheetItem.argus = "";
    localArrayList.add(localActionSheetItem);
    localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.label = amtj.a(2131704959);
    localActionSheetItem.icon = 2130839122;
    localActionSheetItem.iconNeedBg = true;
    localActionSheetItem.action = 1;
    localActionSheetItem.argus = "";
    localArrayList.add(localActionSheetItem);
    localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.label = BaseApplicationImpl.getApplication().getString(2131695870);
    localActionSheetItem.icon = 2130839122;
    localActionSheetItem.iconNeedBg = true;
    localActionSheetItem.action = 1;
    localActionSheetItem.argus = "";
    localArrayList.add(localActionSheetItem);
    return (List[])new ArrayList[] { localArrayList };
  }
  
  private void handleLoginWithMask(String paramString1, String paramString2, boolean paramBoolean)
  {
    QLog.d("InvitationFriend", 1, "METHOD_LOGIN_WITH_UIN_MASK success, jump to LoginActivity, enableLoginWithMask: " + paramBoolean + "uinMask: " + paramString1);
    bcef.a(null, "dc00898", "", "", "0X800B337", "0X800B337", 0, 0, "", "", "", "");
    Intent localIntent = new Intent(this.mRuntime.a(), LoginActivity.class);
    if (paramBoolean)
    {
      localIntent.putExtra("is_need_login_with_mask", true);
      localIntent.putExtra("uinMask", paramString1);
      localIntent.putExtra("uinEncrpyt", paramString2);
    }
    this.mRuntime.a().startActivity(localIntent);
  }
  
  private void handleRegWithNickAndPwd()
  {
    QLog.d("InvitationFriend", 1, "handleRegWithNickAndPwd");
    bcef.a(null, "dc00898", "", "", "0X800B338", "0X800B338", 0, 0, "", "", "", "");
    Intent localIntent = new Intent(this.mRuntime.a(), RegisterByNicknameAndPwdActivity.class);
    localIntent.putExtra("key_reg_from_phone_protect_h5", true);
    this.mRuntime.a().startActivity(localIntent);
  }
  
  private boolean isLoginWithMaskArgInvalid(String[] paramArrayOfString)
  {
    return (paramArrayOfString == null) || (paramArrayOfString.length == 0);
  }
  
  private boolean isRuntimeInvalid()
  {
    return (this.mRuntime == null) || (this.mRuntime.a() == null);
  }
  
  private void sendSMS(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    Intent localIntent = new Intent("android.intent.action.SENDTO", Uri.parse("smsto:"));
    localIntent.putExtra("sms_body", paramString);
    this.mRuntime.a().startActivity(localIntent);
  }
  
  @QQPermissionDenied(1)
  @TargetApi(23)
  public void denied()
  {
    QLog.d("InvitationFriend", 1, "CheckPermission user denied = sms");
    QQToast.a(this.mRuntime.a(), amtj.a(2131704957), 1).a();
  }
  
  @QQPermissionGrant(1)
  public void grant()
  {
    QLog.d("InvitationFriend", 1, "CheckPermission user grant = sms");
    if (!TextUtils.isEmpty(this.mSmsContent)) {
      sendSMS(this.mSmsContent);
    }
  }
  
  /* Error */
  public boolean handleJsRequest(com.tencent.mobileqq.webview.swift.JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    // Byte code:
    //   0: invokestatic 255	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +61 -> 64
    //   6: ldc 42
    //   8: iconst_2
    //   9: new 122	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   16: ldc_w 257
    //   19: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: aload_2
    //   23: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: ldc_w 259
    //   29: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: aload 4
    //   34: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: ldc_w 261
    //   40: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: aload_3
    //   44: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: ldc_w 263
    //   50: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: aload 5
    //   55: invokevirtual 266	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   58: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   61: invokestatic 269	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   64: ldc 39
    //   66: aload_3
    //   67: invokevirtual 274	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   70: ifne +5 -> 75
    //   73: iconst_0
    //   74: ireturn
    //   75: ldc 33
    //   77: aload 4
    //   79: invokevirtual 278	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   82: ifeq +125 -> 207
    //   85: aload 5
    //   87: ifnull +10 -> 97
    //   90: aload 5
    //   92: arraylength
    //   93: iconst_1
    //   94: if_icmpeq +5 -> 99
    //   97: iconst_0
    //   98: ireturn
    //   99: aload 5
    //   101: iconst_0
    //   102: aaload
    //   103: astore_1
    //   104: new 280	org/json/JSONObject
    //   107: dup
    //   108: aload_1
    //   109: invokespecial 282	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   112: astore_1
    //   113: aload_1
    //   114: ldc_w 284
    //   117: invokevirtual 287	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   120: astore_2
    //   121: aload_0
    //   122: aload_1
    //   123: ldc_w 289
    //   126: invokevirtual 287	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   129: putfield 291	com/tencent/mobileqq/activity/contact/addcontact/InvitationWebViewPlugin:mSendMsgCallback	Ljava/lang/String;
    //   132: getstatic 296	android/os/Build$VERSION:SDK_INT	I
    //   135: bipush 23
    //   137: if_icmplt +62 -> 199
    //   140: aload_0
    //   141: getfield 159	com/tencent/mobileqq/activity/contact/addcontact/InvitationWebViewPlugin:mRuntime	Lbgve;
    //   144: invokevirtual 164	bgve:a	()Landroid/app/Activity;
    //   147: ldc_w 298
    //   150: invokevirtual 302	android/app/Activity:checkSelfPermission	(Ljava/lang/String;)I
    //   153: ifeq +38 -> 191
    //   156: aload_0
    //   157: aload_2
    //   158: putfield 244	com/tencent/mobileqq/activity/contact/addcontact/InvitationWebViewPlugin:mSmsContent	Ljava/lang/String;
    //   161: aload_0
    //   162: getfield 159	com/tencent/mobileqq/activity/contact/addcontact/InvitationWebViewPlugin:mRuntime	Lbgve;
    //   165: invokevirtual 164	bgve:a	()Landroid/app/Activity;
    //   168: checkcast 304	mqq/app/AppActivity
    //   171: aload_0
    //   172: iconst_1
    //   173: iconst_1
    //   174: anewarray 271	java/lang/String
    //   177: dup
    //   178: iconst_0
    //   179: ldc_w 298
    //   182: aastore
    //   183: invokevirtual 308	mqq/app/AppActivity:requestPermissions	(Ljava/lang/Object;I[Ljava/lang/String;)V
    //   186: iconst_1
    //   187: ireturn
    //   188: astore_1
    //   189: iconst_0
    //   190: ireturn
    //   191: aload_0
    //   192: aload_2
    //   193: invokespecial 246	com/tencent/mobileqq/activity/contact/addcontact/InvitationWebViewPlugin:sendSMS	(Ljava/lang/String;)V
    //   196: goto -10 -> 186
    //   199: aload_0
    //   200: aload_2
    //   201: invokespecial 246	com/tencent/mobileqq/activity/contact/addcontact/InvitationWebViewPlugin:sendSMS	(Ljava/lang/String;)V
    //   204: goto -18 -> 186
    //   207: ldc 36
    //   209: aload 4
    //   211: invokevirtual 278	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   214: ifeq +190 -> 404
    //   217: aload 5
    //   219: ifnull +10 -> 229
    //   222: aload 5
    //   224: arraylength
    //   225: iconst_1
    //   226: if_icmpeq +5 -> 231
    //   229: iconst_0
    //   230: ireturn
    //   231: aload 5
    //   233: iconst_0
    //   234: aaload
    //   235: astore_1
    //   236: aload_0
    //   237: new 280	org/json/JSONObject
    //   240: dup
    //   241: aload_1
    //   242: invokespecial 282	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   245: ldc_w 289
    //   248: invokevirtual 287	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   251: putfield 310	com/tencent/mobileqq/activity/contact/addcontact/InvitationWebViewPlugin:mShareCallback	Ljava/lang/String;
    //   254: aload_0
    //   255: getfield 159	com/tencent/mobileqq/activity/contact/addcontact/InvitationWebViewPlugin:mRuntime	Lbgve;
    //   258: invokevirtual 164	bgve:a	()Landroid/app/Activity;
    //   261: astore_1
    //   262: aload_0
    //   263: getfield 312	com/tencent/mobileqq/activity/contact/addcontact/InvitationWebViewPlugin:mShareDialogBuilder	Lcom/tencent/mobileqq/utils/ShareActionSheetBuilder;
    //   266: ifnonnull +15 -> 281
    //   269: aload_0
    //   270: new 314	com/tencent/mobileqq/utils/ShareActionSheetBuilder
    //   273: dup
    //   274: aload_1
    //   275: invokespecial 317	com/tencent/mobileqq/utils/ShareActionSheetBuilder:<init>	(Landroid/content/Context;)V
    //   278: putfield 312	com/tencent/mobileqq/activity/contact/addcontact/InvitationWebViewPlugin:mShareDialogBuilder	Lcom/tencent/mobileqq/utils/ShareActionSheetBuilder;
    //   281: aload_0
    //   282: getfield 312	com/tencent/mobileqq/activity/contact/addcontact/InvitationWebViewPlugin:mShareDialogBuilder	Lcom/tencent/mobileqq/utils/ShareActionSheetBuilder;
    //   285: ldc_w 318
    //   288: invokestatic 108	amtj:a	(I)Ljava/lang/String;
    //   291: invokevirtual 322	com/tencent/mobileqq/utils/ShareActionSheetBuilder:setActionSheetTitle	(Ljava/lang/CharSequence;)V
    //   294: aload_0
    //   295: getfield 312	com/tencent/mobileqq/activity/contact/addcontact/InvitationWebViewPlugin:mShareDialogBuilder	Lcom/tencent/mobileqq/utils/ShareActionSheetBuilder;
    //   298: aload_0
    //   299: invokespecial 324	com/tencent/mobileqq/activity/contact/addcontact/InvitationWebViewPlugin:getActionSheetItems	()[Ljava/util/List;
    //   302: invokevirtual 328	com/tencent/mobileqq/utils/ShareActionSheetBuilder:setActionSheetItems	([Ljava/util/List;)V
    //   305: aload_0
    //   306: getfield 312	com/tencent/mobileqq/activity/contact/addcontact/InvitationWebViewPlugin:mShareDialogBuilder	Lcom/tencent/mobileqq/utils/ShareActionSheetBuilder;
    //   309: aload_0
    //   310: invokevirtual 332	com/tencent/mobileqq/utils/ShareActionSheetBuilder:setItemClickListener	(Landroid/widget/AdapterView$OnItemClickListener;)V
    //   313: aload_0
    //   314: getfield 312	com/tencent/mobileqq/activity/contact/addcontact/InvitationWebViewPlugin:mShareDialogBuilder	Lcom/tencent/mobileqq/utils/ShareActionSheetBuilder;
    //   317: aload_0
    //   318: invokevirtual 336	com/tencent/mobileqq/utils/ShareActionSheetBuilder:setOnDismissListener	(Landroid/content/DialogInterface$OnDismissListener;)V
    //   321: aload_1
    //   322: invokevirtual 339	android/app/Activity:isFinishing	()Z
    //   325: ifne +77 -> 402
    //   328: aload_0
    //   329: getfield 312	com/tencent/mobileqq/activity/contact/addcontact/InvitationWebViewPlugin:mShareDialogBuilder	Lcom/tencent/mobileqq/utils/ShareActionSheetBuilder;
    //   332: invokevirtual 342	com/tencent/mobileqq/utils/ShareActionSheetBuilder:show	()V
    //   335: aconst_null
    //   336: ldc 146
    //   338: ldc 93
    //   340: ldc 93
    //   342: ldc_w 344
    //   345: ldc_w 344
    //   348: iconst_0
    //   349: iconst_0
    //   350: ldc 93
    //   352: ldc 93
    //   354: ldc 93
    //   356: ldc 93
    //   358: invokestatic 347	bcef:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   361: iconst_1
    //   362: ireturn
    //   363: astore_1
    //   364: iconst_0
    //   365: ireturn
    //   366: astore_1
    //   367: invokestatic 255	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   370: ifeq -9 -> 361
    //   373: ldc 42
    //   375: iconst_2
    //   376: new 122	java/lang/StringBuilder
    //   379: dup
    //   380: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   383: ldc_w 349
    //   386: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   389: aload_1
    //   390: invokevirtual 266	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   393: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   396: invokestatic 144	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   399: goto -38 -> 361
    //   402: iconst_0
    //   403: ireturn
    //   404: ldc 30
    //   406: aload 4
    //   408: invokevirtual 278	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   411: ifeq +120 -> 531
    //   414: invokestatic 255	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   417: ifeq +12 -> 429
    //   420: ldc 42
    //   422: iconst_2
    //   423: ldc_w 351
    //   426: invokestatic 144	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   429: aload_0
    //   430: getfield 159	com/tencent/mobileqq/activity/contact/addcontact/InvitationWebViewPlugin:mRuntime	Lbgve;
    //   433: ifnull +86 -> 519
    //   436: aload_0
    //   437: getfield 159	com/tencent/mobileqq/activity/contact/addcontact/InvitationWebViewPlugin:mRuntime	Lbgve;
    //   440: invokevirtual 164	bgve:a	()Landroid/app/Activity;
    //   443: ifnull +76 -> 519
    //   446: new 155	android/content/Intent
    //   449: dup
    //   450: invokespecial 352	android/content/Intent:<init>	()V
    //   453: astore_1
    //   454: aload_1
    //   455: ldc 12
    //   457: invokevirtual 356	android/content/Intent:setAction	(Ljava/lang/String;)Landroid/content/Intent;
    //   460: pop
    //   461: aload_1
    //   462: invokestatic 362	mqq/app/MobileQQ:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   465: invokevirtual 367	com/tencent/qphone/base/util/BaseApplication:getPackageName	()Ljava/lang/String;
    //   468: invokevirtual 370	android/content/Intent:setPackage	(Ljava/lang/String;)Landroid/content/Intent;
    //   471: pop
    //   472: aload_0
    //   473: getfield 159	com/tencent/mobileqq/activity/contact/addcontact/InvitationWebViewPlugin:mRuntime	Lbgve;
    //   476: invokevirtual 164	bgve:a	()Landroid/app/Activity;
    //   479: aload_1
    //   480: invokevirtual 373	android/app/Activity:sendBroadcast	(Landroid/content/Intent;)V
    //   483: goto -297 -> 186
    //   486: astore_1
    //   487: ldc 42
    //   489: iconst_1
    //   490: new 122	java/lang/StringBuilder
    //   493: dup
    //   494: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   497: ldc_w 375
    //   500: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   503: aload_1
    //   504: invokevirtual 378	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   507: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   510: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   513: invokestatic 381	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   516: goto -330 -> 186
    //   519: ldc 42
    //   521: iconst_1
    //   522: ldc_w 383
    //   525: invokestatic 381	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   528: goto -342 -> 186
    //   531: ldc 21
    //   533: aload 4
    //   535: invokevirtual 278	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   538: ifeq +133 -> 671
    //   541: ldc 42
    //   543: iconst_1
    //   544: ldc_w 385
    //   547: invokestatic 144	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   550: aload_0
    //   551: aload 5
    //   553: invokespecial 387	com/tencent/mobileqq/activity/contact/addcontact/InvitationWebViewPlugin:isLoginWithMaskArgInvalid	([Ljava/lang/String;)Z
    //   556: ifeq +14 -> 570
    //   559: ldc 42
    //   561: iconst_1
    //   562: ldc_w 389
    //   565: invokestatic 381	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   568: iconst_0
    //   569: ireturn
    //   570: aload_0
    //   571: invokespecial 391	com/tencent/mobileqq/activity/contact/addcontact/InvitationWebViewPlugin:isRuntimeInvalid	()Z
    //   574: ifeq +14 -> 588
    //   577: ldc 42
    //   579: iconst_1
    //   580: ldc_w 393
    //   583: invokestatic 381	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   586: iconst_0
    //   587: ireturn
    //   588: new 280	org/json/JSONObject
    //   591: dup
    //   592: aload 5
    //   594: iconst_0
    //   595: aaload
    //   596: invokespecial 282	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   599: astore_1
    //   600: aload_1
    //   601: ldc 48
    //   603: invokevirtual 396	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   606: astore_2
    //   607: aload_1
    //   608: ldc 45
    //   610: invokevirtual 396	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   613: astore_3
    //   614: aload_1
    //   615: ldc 18
    //   617: invokevirtual 399	org/json/JSONObject:optBoolean	(Ljava/lang/String;)Z
    //   620: istore 6
    //   622: aload_2
    //   623: invokestatic 204	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   626: ifne +10 -> 636
    //   629: aload_3
    //   630: invokestatic 204	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   633: ifeq +27 -> 660
    //   636: ldc 42
    //   638: iconst_1
    //   639: ldc_w 401
    //   642: invokestatic 381	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   645: iconst_0
    //   646: ireturn
    //   647: astore_1
    //   648: ldc 42
    //   650: iconst_1
    //   651: ldc_w 403
    //   654: aload_1
    //   655: invokestatic 406	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   658: iconst_0
    //   659: ireturn
    //   660: aload_0
    //   661: aload_2
    //   662: aload_3
    //   663: iload 6
    //   665: invokespecial 408	com/tencent/mobileqq/activity/contact/addcontact/InvitationWebViewPlugin:handleLoginWithMask	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   668: goto -482 -> 186
    //   671: ldc 24
    //   673: aload 4
    //   675: invokevirtual 278	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   678: ifeq +37 -> 715
    //   681: ldc 42
    //   683: iconst_1
    //   684: ldc_w 410
    //   687: invokestatic 144	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   690: aload_0
    //   691: invokespecial 391	com/tencent/mobileqq/activity/contact/addcontact/InvitationWebViewPlugin:isRuntimeInvalid	()Z
    //   694: ifeq +14 -> 708
    //   697: ldc 42
    //   699: iconst_1
    //   700: ldc_w 412
    //   703: invokestatic 381	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   706: iconst_0
    //   707: ireturn
    //   708: aload_0
    //   709: invokespecial 414	com/tencent/mobileqq/activity/contact/addcontact/InvitationWebViewPlugin:handleRegWithNickAndPwd	()V
    //   712: goto -526 -> 186
    //   715: ldc 27
    //   717: aload 4
    //   719: invokevirtual 274	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   722: ifeq -536 -> 186
    //   725: invokestatic 255	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   728: ifeq +12 -> 740
    //   731: ldc 42
    //   733: iconst_2
    //   734: ldc_w 416
    //   737: invokestatic 144	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   740: aload_0
    //   741: getfield 159	com/tencent/mobileqq/activity/contact/addcontact/InvitationWebViewPlugin:mRuntime	Lbgve;
    //   744: ifnull +53 -> 797
    //   747: aload_0
    //   748: getfield 159	com/tencent/mobileqq/activity/contact/addcontact/InvitationWebViewPlugin:mRuntime	Lbgve;
    //   751: invokevirtual 164	bgve:a	()Landroid/app/Activity;
    //   754: ifnull +43 -> 797
    //   757: new 155	android/content/Intent
    //   760: dup
    //   761: invokespecial 352	android/content/Intent:<init>	()V
    //   764: astore_1
    //   765: aload_1
    //   766: ldc 15
    //   768: invokevirtual 356	android/content/Intent:setAction	(Ljava/lang/String;)Landroid/content/Intent;
    //   771: pop
    //   772: aload_1
    //   773: invokestatic 362	mqq/app/MobileQQ:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   776: invokevirtual 367	com/tencent/qphone/base/util/BaseApplication:getPackageName	()Ljava/lang/String;
    //   779: invokevirtual 370	android/content/Intent:setPackage	(Ljava/lang/String;)Landroid/content/Intent;
    //   782: pop
    //   783: aload_0
    //   784: getfield 159	com/tencent/mobileqq/activity/contact/addcontact/InvitationWebViewPlugin:mRuntime	Lbgve;
    //   787: invokevirtual 164	bgve:a	()Landroid/app/Activity;
    //   790: aload_1
    //   791: invokevirtual 373	android/app/Activity:sendBroadcast	(Landroid/content/Intent;)V
    //   794: goto -608 -> 186
    //   797: ldc 42
    //   799: iconst_1
    //   800: ldc_w 383
    //   803: invokestatic 381	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   806: goto -620 -> 186
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	809	0	this	InvitationWebViewPlugin
    //   0	809	1	paramJsBridgeListener	com.tencent.mobileqq.webview.swift.JsBridgeListener
    //   0	809	2	paramString1	String
    //   0	809	3	paramString2	String
    //   0	809	4	paramString3	String
    //   0	809	5	paramVarArgs	String[]
    //   620	44	6	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   104	132	188	org/json/JSONException
    //   236	254	363	org/json/JSONException
    //   328	361	366	java/lang/Exception
    //   414	429	486	java/lang/Exception
    //   429	483	486	java/lang/Exception
    //   519	528	486	java/lang/Exception
    //   588	600	647	java/lang/Exception
  }
  
  public void onDismiss(DialogInterface paramDialogInterface) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    callJs(this.mShareCallback, new String[] { String.valueOf(paramInt) });
    String str = "";
    if (paramInt == 0) {
      str = "0X80096FA";
    }
    for (;;)
    {
      if (!"".equals(str)) {
        bcef.b(null, "dc00898", "", "", str, str, 0, 0, "", "", "", "");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.InvitationWebViewPlugin
 * JD-Core Version:    0.7.0.1
 */