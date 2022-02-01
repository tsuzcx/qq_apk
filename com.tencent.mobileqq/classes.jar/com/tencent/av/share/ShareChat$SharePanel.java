package com.tencent.av.share;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.biz.qrcode.activity.QRDisplayActivity;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.DirectForwardActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.troop.data.TroopInfoData;
import com.tencent.mobileqq.troopshare.TroopShareUtility;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.widget.share.ShareActionSheetFactory;
import com.tencent.mobileqq.widget.share.ShareActionSheetV2.Param;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqfav.QfavBuilder;
import cooperation.qzone.QZoneShareManager;
import java.util.ArrayList;
import java.util.List;
import mqq.app.MobileQQ;

class ShareChat$SharePanel
{
  int jdField_a_of_type_Int = -1;
  final long jdField_a_of_type_Long;
  ShareChat.SharePanel.IHandle jdField_a_of_type_ComTencentAvShareShareChat$SharePanel$IHandle = null;
  ShareChat.SharePanel.MyOnItemClickListener jdField_a_of_type_ComTencentAvShareShareChat$SharePanel$MyOnItemClickListener;
  ShareActionSheet jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet;
  String jdField_a_of_type_JavaLangString = null;
  int b;
  
  ShareChat$SharePanel(long paramLong, int paramInt)
  {
    this.b = paramInt;
    this.jdField_a_of_type_Long = paramLong;
  }
  
  private void a(long paramLong, Context paramContext, boolean paramBoolean, int paramInt, String paramString, ShareChat.SharePanel.IHandle paramIHandle)
  {
    String str1 = String.valueOf(System.currentTimeMillis());
    if (paramIHandle != null) {
      localBitmap = paramIHandle.a(paramLong);
    } else {
      localBitmap = null;
    }
    Bitmap localBitmap = TroopShareUtility.a(localBitmap);
    String str2 = ShareChat.a(paramContext);
    paramIHandle = ShareChat.a(paramIHandle);
    int i;
    if (paramBoolean) {
      i = 3;
    } else {
      i = 2;
    }
    a(paramLong, paramContext, str1, i, paramInt);
    if (paramBoolean)
    {
      WXShareHelper.a().a(str1, str2, localBitmap, paramIHandle, paramString);
    }
    else
    {
      paramContext = TroopShareUtility.a(paramIHandle, paramContext);
      WXShareHelper.a().b(str1, str2, localBitmap, paramContext, paramString);
    }
    if (QLog.isColorLevel())
    {
      paramContext = new StringBuilder();
      paramContext.append("shareToWX, mWXTransaction[");
      paramContext.append(str1);
      paramContext.append("], bFriendCircle[");
      paramContext.append(paramBoolean);
      paramContext.append("], shareLink[");
      paramContext.append(paramString);
      paramContext.append("], seq[");
      paramContext.append(paramLong);
      paramContext.append("]");
      QLog.w("ShareChat", 1, paramContext.toString());
    }
  }
  
  private void b(long paramLong, Context paramContext, int paramInt, ShareChat.SharePanel.IHandle paramIHandle, String paramString)
  {
    Object localObject = ShareChat.b(paramIHandle);
    ArrayList localArrayList = new ArrayList();
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      localArrayList.add(localObject);
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramContext.getString(2131693112));
    ((StringBuilder)localObject).append(paramString);
    localObject = ((StringBuilder)localObject).toString();
    Bundle localBundle = new Bundle();
    localBundle.putString("title", ShareChat.a(paramContext));
    localBundle.putString("desc", ShareChat.a(paramIHandle));
    localBundle.putLong("req_share_id", 0L);
    localBundle.putString("detail_url", paramString);
    localBundle.putString("url", paramString);
    localBundle.putStringArrayList("image_url", localArrayList);
    localBundle.putString("troop_wording", (String)localObject);
    localBundle.putString("bizname", "JoinTroopLink");
    localBundle.putParcelable("PARAM_ActivityResultReceiver", new ShareChat.MyResultReceiver(new Handler(), this, 1, paramInt, paramLong));
    QZoneShareManager.jumpToQzoneShare((AppInterface)BaseApplicationImpl.getApplication().getRuntime(), paramContext, localBundle, null, 145);
    if (QLog.isColorLevel())
    {
      paramContext = new StringBuilder();
      paramContext.append("shareToQzone, shareLink[");
      paramContext.append(paramString);
      paramContext.append("], seq[");
      paramContext.append(paramLong);
      paramContext.append("]");
      QLog.w("ShareChat", 1, paramContext.toString());
    }
  }
  
  /* Error */
  private void b(long paramLong, Context paramContext, int paramInt, ShareChat.SharePanel.IHandle paramIHandle, String paramString, ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    // Byte code:
    //   0: aload 5
    //   2: ifnull +971 -> 973
    //   5: aload 7
    //   7: ifnonnull +4 -> 11
    //   10: return
    //   11: aload_3
    //   12: invokestatic 56	com/tencent/av/share/ShareChat:a	(Landroid/content/Context;)Ljava/lang/String;
    //   15: astore 9
    //   17: aload_3
    //   18: invokestatic 56	com/tencent/av/share/ShareChat:a	(Landroid/content/Context;)Ljava/lang/String;
    //   21: astore 11
    //   23: aload 5
    //   25: invokestatic 59	com/tencent/av/share/ShareChat:a	(Lcom/tencent/av/share/ShareChat$SharePanel$IHandle;)Ljava/lang/String;
    //   28: astore 12
    //   30: aload 5
    //   32: invokestatic 117	com/tencent/av/share/ShareChat:b	(Lcom/tencent/av/share/ShareChat$SharePanel$IHandle;)Ljava/lang/String;
    //   35: astore 13
    //   37: aload_3
    //   38: ldc 208
    //   40: invokevirtual 137	android/content/Context:getString	(I)Ljava/lang/String;
    //   43: astore 14
    //   45: new 210	org/json/JSONObject
    //   48: dup
    //   49: invokespecial 211	org/json/JSONObject:<init>	()V
    //   52: astore 8
    //   54: aload 8
    //   56: ldc 213
    //   58: aload 9
    //   60: invokevirtual 217	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   63: pop
    //   64: new 210	org/json/JSONObject
    //   67: dup
    //   68: invokespecial 211	org/json/JSONObject:<init>	()V
    //   71: astore 9
    //   73: aload 9
    //   75: ldc 219
    //   77: iconst_1
    //   78: invokevirtual 222	org/json/JSONObject:put	(Ljava/lang/String;Z)Lorg/json/JSONObject;
    //   81: pop
    //   82: aload 9
    //   84: ldc 224
    //   86: iconst_1
    //   87: invokevirtual 222	org/json/JSONObject:put	(Ljava/lang/String;Z)Lorg/json/JSONObject;
    //   90: pop
    //   91: aload 8
    //   93: ldc 226
    //   95: aload 9
    //   97: invokevirtual 217	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   100: pop
    //   101: aload 8
    //   103: ldc 228
    //   105: ldc 230
    //   107: invokevirtual 217	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   110: pop
    //   111: aload 8
    //   113: ldc 232
    //   115: ldc 234
    //   117: invokevirtual 217	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   120: pop
    //   121: aload 8
    //   123: ldc 236
    //   125: ldc 238
    //   127: invokevirtual 217	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   130: pop
    //   131: new 210	org/json/JSONObject
    //   134: dup
    //   135: invokespecial 211	org/json/JSONObject:<init>	()V
    //   138: astore 9
    //   140: new 210	org/json/JSONObject
    //   143: dup
    //   144: invokespecial 211	org/json/JSONObject:<init>	()V
    //   147: astore 10
    //   149: aload 10
    //   151: ldc 142
    //   153: aload 11
    //   155: invokevirtual 217	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   158: pop
    //   159: aload 10
    //   161: ldc 148
    //   163: aload 12
    //   165: invokevirtual 217	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   168: pop
    //   169: aload 10
    //   171: ldc 240
    //   173: aload 13
    //   175: invokevirtual 217	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   178: pop
    //   179: aload 10
    //   181: ldc 242
    //   183: aload 14
    //   185: invokevirtual 217	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   188: pop
    //   189: aload 10
    //   191: ldc 244
    //   193: aload 6
    //   195: invokevirtual 217	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   198: pop
    //   199: aload 5
    //   201: invokeinterface 247 1 0
    //   206: bipush 99
    //   208: if_icmpne +123 -> 331
    //   211: aload 5
    //   213: invokeinterface 250 1 0
    //   218: astore 6
    //   220: aload 10
    //   222: ldc 252
    //   224: ldc 254
    //   226: invokevirtual 217	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   229: pop
    //   230: aload 10
    //   232: ldc_w 256
    //   235: aload 6
    //   237: getfield 261	com/tencent/mobileqq/troop/data/TroopInfoData:troopName	Ljava/lang/String;
    //   240: invokevirtual 217	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   243: pop
    //   244: aload 10
    //   246: ldc_w 263
    //   249: aload 6
    //   251: getfield 267	com/tencent/mobileqq/troop/data/TroopInfoData:bOwner	Z
    //   254: invokevirtual 222	org/json/JSONObject:put	(Ljava/lang/String;Z)Lorg/json/JSONObject;
    //   257: pop
    //   258: aload 10
    //   260: ldc_w 269
    //   263: aload 6
    //   265: getfield 272	com/tencent/mobileqq/troop/data/TroopInfoData:bAdmin	Z
    //   268: invokevirtual 222	org/json/JSONObject:put	(Ljava/lang/String;Z)Lorg/json/JSONObject;
    //   271: pop
    //   272: aload 10
    //   274: ldc_w 274
    //   277: aload 6
    //   279: getfield 277	com/tencent/mobileqq/troop/data/TroopInfoData:troopCard	Ljava/lang/String;
    //   282: invokevirtual 217	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   285: pop
    //   286: aload 10
    //   288: ldc_w 279
    //   291: aload 5
    //   293: invokeinterface 281 1 0
    //   298: invokevirtual 284	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   301: pop
    //   302: aload 10
    //   304: ldc_w 286
    //   307: aload 5
    //   309: invokeinterface 288 1 0
    //   314: invokevirtual 291	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   317: pop
    //   318: aload 10
    //   320: ldc_w 293
    //   323: aload_0
    //   324: getfield 23	com/tencent/av/share/ShareChat$SharePanel:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   327: invokevirtual 217	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   330: pop
    //   331: aload 5
    //   333: iconst_0
    //   334: invokeinterface 295 2 0
    //   339: astore 5
    //   341: aload 5
    //   343: invokestatic 126	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   346: ifne +75 -> 421
    //   349: new 210	org/json/JSONObject
    //   352: dup
    //   353: invokespecial 211	org/json/JSONObject:<init>	()V
    //   356: astore 6
    //   358: aload 6
    //   360: ldc_w 297
    //   363: aload 5
    //   365: invokevirtual 217	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   368: pop
    //   369: aload 6
    //   371: ldc_w 299
    //   374: aload 5
    //   376: invokevirtual 217	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   379: pop
    //   380: aload 6
    //   382: ldc_w 301
    //   385: ldc_w 303
    //   388: invokevirtual 217	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   391: pop
    //   392: aload 6
    //   394: ldc_w 305
    //   397: ldc 106
    //   399: aload_0
    //   400: getfield 23	com/tencent/av/share/ShareChat$SharePanel:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   403: invokestatic 310	com/tencent/mobileqq/utils/StringUtil:a	(Ljava/lang/String;Ljava/lang/String;)J
    //   406: invokevirtual 284	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   409: pop
    //   410: aload 10
    //   412: ldc_w 312
    //   415: aload 6
    //   417: invokevirtual 217	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   420: pop
    //   421: aload 9
    //   423: ldc_w 314
    //   426: aload 10
    //   428: invokevirtual 217	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   431: pop
    //   432: aload 8
    //   434: ldc_w 316
    //   437: aload 9
    //   439: invokevirtual 217	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   442: pop
    //   443: aload 8
    //   445: invokevirtual 317	org/json/JSONObject:toString	()Ljava/lang/String;
    //   448: astore 12
    //   450: aload 8
    //   452: ldc 228
    //   454: invokevirtual 320	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   457: astore 5
    //   459: aload 8
    //   461: ldc 232
    //   463: invokevirtual 320	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   466: astore 6
    //   468: aload 8
    //   470: ldc 236
    //   472: invokevirtual 320	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   475: astore 9
    //   477: aload 8
    //   479: ldc 226
    //   481: invokevirtual 320	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   484: astore 10
    //   486: aload 8
    //   488: ldc_w 316
    //   491: invokevirtual 320	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   494: astore 11
    //   496: aload 8
    //   498: ldc 213
    //   500: invokevirtual 320	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   503: astore 8
    //   505: new 83	java/lang/StringBuilder
    //   508: dup
    //   509: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   512: astore 13
    //   514: aload 13
    //   516: ldc_w 322
    //   519: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   522: pop
    //   523: aload 13
    //   525: aload 12
    //   527: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   530: pop
    //   531: aload 13
    //   533: ldc_w 324
    //   536: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   539: pop
    //   540: aload 13
    //   542: aload 5
    //   544: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   547: pop
    //   548: aload 13
    //   550: ldc_w 326
    //   553: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   556: pop
    //   557: aload 13
    //   559: aload 6
    //   561: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   564: pop
    //   565: aload 13
    //   567: ldc_w 328
    //   570: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   573: pop
    //   574: aload 13
    //   576: aload 9
    //   578: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   581: pop
    //   582: aload 13
    //   584: ldc_w 330
    //   587: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   590: pop
    //   591: aload 13
    //   593: aload 10
    //   595: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   598: pop
    //   599: aload 13
    //   601: ldc_w 332
    //   604: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   607: pop
    //   608: aload 13
    //   610: aload 11
    //   612: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   615: pop
    //   616: aload 13
    //   618: ldc_w 334
    //   621: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   624: pop
    //   625: aload 13
    //   627: aload 8
    //   629: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   632: pop
    //   633: aload 13
    //   635: ldc 99
    //   637: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   640: pop
    //   641: aload 13
    //   643: lload_1
    //   644: invokevirtual 102	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   647: pop
    //   648: aload 13
    //   650: ldc 104
    //   652: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   655: pop
    //   656: ldc 106
    //   658: iconst_1
    //   659: aload 13
    //   661: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   664: invokestatic 114	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   667: new 336	android/content/Intent
    //   670: dup
    //   671: invokespecial 337	android/content/Intent:<init>	()V
    //   674: astore 12
    //   676: aload 12
    //   678: ldc_w 339
    //   681: bipush 27
    //   683: invokevirtual 343	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   686: pop
    //   687: aload 12
    //   689: ldc_w 345
    //   692: iconst_1
    //   693: invokevirtual 348	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   696: pop
    //   697: aload 12
    //   699: ldc_w 350
    //   702: aload 5
    //   704: invokevirtual 353	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   707: pop
    //   708: aload 12
    //   710: ldc_w 355
    //   713: aload 9
    //   715: invokevirtual 353	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   718: pop
    //   719: aload 12
    //   721: ldc_w 357
    //   724: aload 6
    //   726: invokevirtual 353	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   729: pop
    //   730: aload 12
    //   732: ldc_w 359
    //   735: aload 8
    //   737: invokevirtual 353	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   740: pop
    //   741: aload 12
    //   743: ldc_w 361
    //   746: aload 11
    //   748: invokevirtual 353	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   751: pop
    //   752: aload 12
    //   754: ldc_w 363
    //   757: aload 10
    //   759: invokevirtual 353	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   762: pop
    //   763: aload 5
    //   765: aload 9
    //   767: aload 6
    //   769: aload 11
    //   771: aload_3
    //   772: invokevirtual 367	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   775: invokevirtual 373	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   778: getfield 379	android/util/DisplayMetrics:scaledDensity	F
    //   781: aconst_null
    //   782: aconst_null
    //   783: invokestatic 384	com/tencent/mobileqq/utils/QQCustomArkDialog$AppInfo:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;FLjava/lang/String;Landroid/os/Bundle;)Landroid/os/Bundle;
    //   786: astore 5
    //   788: aload 5
    //   790: ldc_w 386
    //   793: iconst_1
    //   794: invokevirtual 390	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   797: aload 5
    //   799: ldc_w 392
    //   802: aload 7
    //   804: getfield 397	com/tencent/mobileqq/utils/ShareActionSheetBuilder$ActionSheetItem:uinType	I
    //   807: invokevirtual 390	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   810: aload 5
    //   812: ldc_w 399
    //   815: aload 7
    //   817: getfield 402	com/tencent/mobileqq/utils/ShareActionSheetBuilder$ActionSheetItem:uin	Ljava/lang/String;
    //   820: invokevirtual 146	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   823: aload 12
    //   825: aload 5
    //   827: invokevirtual 406	android/content/Intent:putExtras	(Landroid/os/Bundle;)Landroid/content/Intent;
    //   830: pop
    //   831: aload 12
    //   833: ldc 172
    //   835: new 174	com/tencent/av/share/ShareChat$MyResultReceiver
    //   838: dup
    //   839: new 176	android/os/Handler
    //   842: dup
    //   843: invokespecial 177	android/os/Handler:<init>	()V
    //   846: aload_0
    //   847: iconst_3
    //   848: iload 4
    //   850: lload_1
    //   851: invokespecial 180	com/tencent/av/share/ShareChat$MyResultReceiver:<init>	(Landroid/os/Handler;Lcom/tencent/av/share/ShareChat$SharePanel;IIJ)V
    //   854: invokevirtual 409	android/content/Intent:putExtra	(Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;
    //   857: pop
    //   858: aload_3
    //   859: checkcast 411	android/app/Activity
    //   862: aload 12
    //   864: ldc_w 413
    //   867: iconst_m1
    //   868: invokestatic 418	com/tencent/mobileqq/forward/ForwardBaseOption:a	(Landroid/app/Activity;Landroid/content/Intent;Ljava/lang/Class;I)V
    //   871: return
    //   872: astore 5
    //   874: goto +30 -> 904
    //   877: astore 5
    //   879: goto +25 -> 904
    //   882: astore 5
    //   884: goto +5 -> 889
    //   887: astore 5
    //   889: goto +10 -> 899
    //   892: astore 5
    //   894: goto +5 -> 899
    //   897: astore 5
    //   899: goto +5 -> 904
    //   902: astore 5
    //   904: new 83	java/lang/StringBuilder
    //   907: dup
    //   908: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   911: astore 6
    //   913: aload 6
    //   915: ldc_w 420
    //   918: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   921: pop
    //   922: aload 6
    //   924: lload_1
    //   925: invokevirtual 102	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   928: pop
    //   929: aload 6
    //   931: ldc 104
    //   933: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   936: pop
    //   937: ldc 106
    //   939: iconst_1
    //   940: aload 6
    //   942: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   945: aload 5
    //   947: invokestatic 423	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   950: aload_3
    //   951: ldc_w 424
    //   954: invokestatic 427	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   957: iconst_0
    //   958: invokestatic 432	com/tencent/mobileqq/widget/QQToast:a	(Landroid/content/Context;Ljava/lang/CharSequence;I)Lcom/tencent/mobileqq/widget/QQToast;
    //   961: invokevirtual 435	com/tencent/mobileqq/widget/QQToast:a	()Landroid/widget/Toast;
    //   964: pop
    //   965: aload_0
    //   966: iconst_0
    //   967: iload 4
    //   969: iconst_3
    //   970: invokevirtual 438	com/tencent/av/share/ShareChat$SharePanel:a	(III)V
    //   973: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	974	0	this	SharePanel
    //   0	974	1	paramLong	long
    //   0	974	3	paramContext	Context
    //   0	974	4	paramInt	int
    //   0	974	5	paramIHandle	ShareChat.SharePanel.IHandle
    //   0	974	6	paramString	String
    //   0	974	7	paramActionSheetItem	ShareActionSheetBuilder.ActionSheetItem
    //   52	684	8	localObject1	Object
    //   15	751	9	localObject2	Object
    //   147	611	10	localObject3	Object
    //   21	749	11	str1	String
    //   28	835	12	localObject4	Object
    //   35	625	13	localObject5	Object
    //   43	141	14	str2	String
    // Exception table:
    //   from	to	target	type
    //   858	871	872	java/lang/Exception
    //   648	858	877	java/lang/Exception
    //   641	648	882	java/lang/Exception
    //   73	331	887	java/lang/Exception
    //   331	421	887	java/lang/Exception
    //   421	641	887	java/lang/Exception
    //   37	73	892	java/lang/Exception
    //   30	37	897	java/lang/Exception
    //   11	30	902	java/lang/Exception
  }
  
  private void c(long paramLong, Context paramContext, int paramInt, ShareChat.SharePanel.IHandle paramIHandle, String paramString)
  {
    paramIHandle = new StringBuilder();
    paramIHandle.append(paramContext.getString(2131693112));
    paramIHandle.append(paramString);
    paramIHandle = paramIHandle.toString();
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("copyTroopLink, text[");
      paramString.append(paramIHandle);
      paramString.append("], seq[");
      paramString.append(paramLong);
      paramString.append("]");
      QLog.w("ShareChat", 1, paramString.toString());
    }
    ((ClipboardManager)paramContext.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("troop_url", paramIHandle));
    QQToast.a(paramContext, 2, 2131693113, 0).a();
    a(4, paramInt, 2);
  }
  
  private void c(long paramLong, Context paramContext, ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    Object localObject = this.jdField_a_of_type_ComTencentAvShareShareChat$SharePanel$IHandle;
    if (localObject == null)
    {
      QLog.w("ShareChat", 1, "tryToGetShareLink, mIHandle为空");
      return;
    }
    localObject = ((ShareChat.SharePanel.IHandle)localObject).a(paramLong, this.b);
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      boolean bool = NetworkUtil.isNetSupport(null);
      paramActionSheetItem = new StringBuilder();
      paramActionSheetItem.append("tryToGetShareLink, url为空, isConn[");
      paramActionSheetItem.append(bool);
      paramActionSheetItem.append("], mChoosedChannel[");
      paramActionSheetItem.append(this.jdField_a_of_type_Int);
      paramActionSheetItem.append("], mChoosedLinkType[");
      paramActionSheetItem.append(this.b);
      paramActionSheetItem.append("], seq[");
      paramActionSheetItem.append(paramLong);
      paramActionSheetItem.append("]");
      QLog.w("ShareChat", 1, paramActionSheetItem.toString());
      if ((!bool) && (this.jdField_a_of_type_Int != 4))
      {
        QQToast.a(paramContext, paramContext.getString(2131692183), 0).a();
        if (QLog.isColorLevel())
        {
          paramContext = new StringBuilder();
          paramContext.append("tryToGetShareLink, !isNetSupport, mChoosedChannel[");
          paramContext.append(this.jdField_a_of_type_Int);
          paramContext.append("]");
          QLog.w("ShareChat", 1, paramContext.toString());
        }
      }
      else
      {
        QQToast.a(paramContext, HardCodeUtil.a(2131713778), 0).a();
      }
      a(this.jdField_a_of_type_Int, this.b, 3);
      return;
    }
    int i = this.jdField_a_of_type_Int;
    if (i != 26)
    {
      if (i != 72)
      {
        if (i != 73) {
          switch (i)
          {
          default: 
            return;
          case 6: 
            if (!QfavBuilder.a((String)localObject).a(paramContext, paramActionSheetItem.uin, 103, null)) {
              break;
            }
            QQToast.a(paramContext, 2, 2131692185, 0).a();
            return;
          case 5: 
            a(paramLong, paramContext, this.b, this.jdField_a_of_type_ComTencentAvShareShareChat$SharePanel$IHandle, (String)localObject);
            return;
          case 4: 
            c(paramLong, paramContext, this.b, this.jdField_a_of_type_ComTencentAvShareShareChat$SharePanel$IHandle, (String)localObject);
            return;
          case 3: 
            a(paramLong, paramContext, true, this.b, (String)localObject, this.jdField_a_of_type_ComTencentAvShareShareChat$SharePanel$IHandle);
            return;
          case 2: 
            a(paramLong, paramContext, false, this.b, (String)localObject, this.jdField_a_of_type_ComTencentAvShareShareChat$SharePanel$IHandle);
            return;
          case 1: 
            b(paramLong, paramContext, this.b, this.jdField_a_of_type_ComTencentAvShareShareChat$SharePanel$IHandle, (String)localObject);
            return;
          }
        } else {
          a(paramLong, paramContext, this.b, this.jdField_a_of_type_ComTencentAvShareShareChat$SharePanel$IHandle, (String)localObject, paramActionSheetItem);
        }
      }
      else {
        b(paramLong, paramContext, this.b, this.jdField_a_of_type_ComTencentAvShareShareChat$SharePanel$IHandle, (String)localObject, paramActionSheetItem);
      }
    }
    else {
      d(paramLong, paramContext, this.b, this.jdField_a_of_type_ComTencentAvShareShareChat$SharePanel$IHandle, (String)localObject);
    }
  }
  
  private void d(long paramLong, Context paramContext, int paramInt, ShareChat.SharePanel.IHandle paramIHandle, String paramString)
  {
    if (paramIHandle == null) {
      return;
    }
    paramIHandle = new Intent(paramContext, DirectForwardActivity.class);
    paramIHandle.putExtra("isFromShare", true);
    paramIHandle.putExtra("isFromTeamWork", true);
    paramIHandle.putExtra("toUin", AppConstants.DATALINE_PC_UIN);
    paramIHandle.putExtra("uinType", 6000);
    paramIHandle.putExtra("forward_type", -1);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramContext.getResources().getText(2131693112));
    localStringBuilder.append(paramString);
    paramIHandle.putExtra("forward_text", localStringBuilder.toString());
    paramIHandle.putExtra("openerProc", MobileQQ.getMobileQQ().getQQProcessName());
    paramContext.startActivity(paramIHandle);
  }
  
  void a()
  {
    this.jdField_a_of_type_Int = -1;
  }
  
  void a(int paramInt1, int paramInt2, int paramInt3)
  {
    ShareChat.SharePanel.IHandle localIHandle = this.jdField_a_of_type_ComTencentAvShareShareChat$SharePanel$IHandle;
    if (localIHandle != null) {
      localIHandle.a(paramInt1, paramInt2, paramInt3);
    }
    a();
  }
  
  void a(long paramLong, Context paramContext, int paramInt, ShareChat.SharePanel.IHandle paramIHandle, String paramString)
  {
    TroopInfoData localTroopInfoData = paramIHandle.a();
    if (localTroopInfoData == null)
    {
      a(5, paramInt, 3);
      return;
    }
    Intent localIntent = new Intent(paramContext, QRDisplayActivity.class);
    localIntent.putExtra("title", paramContext.getString(2131716554));
    if (TextUtils.isEmpty(localTroopInfoData.troopName)) {
      localIntent.putExtra("nick", localTroopInfoData.newTroopName);
    } else {
      localIntent.putExtra("nick", localTroopInfoData.troopName);
    }
    paramIHandle = (AppInterface)BaseApplicationImpl.getApplication().getRuntime();
    localIntent.putExtra("url", paramString);
    localIntent.putExtra("uin", localTroopInfoData.troopUin);
    boolean bool2 = localTroopInfoData.bOwner;
    boolean bool1 = false;
    int i;
    if (bool2) {
      i = 0;
    } else if (localTroopInfoData.bAdmin) {
      i = 1;
    } else {
      i = 2;
    }
    localIntent.putExtra("adminLevel", i);
    localIntent.putExtra("type", 11);
    localIntent.putExtra("GroupFlagExt", localTroopInfoData.dwGroupFlagExt);
    localIntent.putExtra("AuthGroupType", localTroopInfoData.dwAuthGroupType);
    if ((paramIHandle instanceof QQAppInterface)) {
      paramIHandle = (QQAppInterface)paramIHandle;
    } else {
      paramIHandle = null;
    }
    if (paramIHandle != null) {
      bool1 = ((TroopManager)paramIHandle.getManager(QQManagerFactory.TROOP_MANAGER)).m(localTroopInfoData.troopUin);
    }
    localIntent.putExtra("isQidianPrivateTroop", bool1);
    if (bool1) {
      localIntent.putExtra("groupOwner", localTroopInfoData.troopowneruin);
    }
    localIntent.putExtra("PARAM_QRForwardReceiver", new ShareChat.MyResultReceiver(new Handler(), this, 4, paramInt, paramLong));
    localIntent.putExtra("PARAM_ActivityResultReceiver", new ShareChat.MyResultReceiver(new Handler(), this, 5, paramInt, paramLong));
    ThreadManager.post(new ShareChat.SharePanel.1(this, paramIHandle, localTroopInfoData, localIntent, paramContext, paramInt), 8, null, true);
  }
  
  /* Error */
  public void a(long paramLong, Context paramContext, int paramInt, ShareChat.SharePanel.IHandle paramIHandle, String paramString, ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    // Byte code:
    //   0: aload 5
    //   2: ifnonnull +4 -> 6
    //   5: return
    //   6: aload_3
    //   7: invokestatic 56	com/tencent/av/share/ShareChat:a	(Landroid/content/Context;)Ljava/lang/String;
    //   10: astore 8
    //   12: aload_3
    //   13: invokestatic 56	com/tencent/av/share/ShareChat:a	(Landroid/content/Context;)Ljava/lang/String;
    //   16: astore 10
    //   18: aload 5
    //   20: invokestatic 59	com/tencent/av/share/ShareChat:a	(Lcom/tencent/av/share/ShareChat$SharePanel$IHandle;)Ljava/lang/String;
    //   23: astore 11
    //   25: aload 5
    //   27: invokestatic 117	com/tencent/av/share/ShareChat:b	(Lcom/tencent/av/share/ShareChat$SharePanel$IHandle;)Ljava/lang/String;
    //   30: astore 12
    //   32: aload_3
    //   33: ldc 208
    //   35: invokevirtual 137	android/content/Context:getString	(I)Ljava/lang/String;
    //   38: astore 13
    //   40: new 210	org/json/JSONObject
    //   43: dup
    //   44: invokespecial 211	org/json/JSONObject:<init>	()V
    //   47: astore 7
    //   49: aload 7
    //   51: ldc 213
    //   53: aload 8
    //   55: invokevirtual 217	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   58: pop
    //   59: new 210	org/json/JSONObject
    //   62: dup
    //   63: invokespecial 211	org/json/JSONObject:<init>	()V
    //   66: astore 8
    //   68: aload 8
    //   70: ldc 219
    //   72: iconst_1
    //   73: invokevirtual 222	org/json/JSONObject:put	(Ljava/lang/String;Z)Lorg/json/JSONObject;
    //   76: pop
    //   77: aload 8
    //   79: ldc 224
    //   81: iconst_1
    //   82: invokevirtual 222	org/json/JSONObject:put	(Ljava/lang/String;Z)Lorg/json/JSONObject;
    //   85: pop
    //   86: aload 7
    //   88: ldc 226
    //   90: aload 8
    //   92: invokevirtual 217	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   95: pop
    //   96: aload 7
    //   98: ldc 228
    //   100: ldc 230
    //   102: invokevirtual 217	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   105: pop
    //   106: aload 7
    //   108: ldc 232
    //   110: ldc 234
    //   112: invokevirtual 217	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   115: pop
    //   116: aload 7
    //   118: ldc 236
    //   120: ldc 238
    //   122: invokevirtual 217	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   125: pop
    //   126: new 210	org/json/JSONObject
    //   129: dup
    //   130: invokespecial 211	org/json/JSONObject:<init>	()V
    //   133: astore 8
    //   135: new 210	org/json/JSONObject
    //   138: dup
    //   139: invokespecial 211	org/json/JSONObject:<init>	()V
    //   142: astore 9
    //   144: aload 9
    //   146: ldc 142
    //   148: aload 10
    //   150: invokevirtual 217	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   153: pop
    //   154: aload 9
    //   156: ldc 148
    //   158: aload 11
    //   160: invokevirtual 217	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   163: pop
    //   164: aload 9
    //   166: ldc 240
    //   168: aload 12
    //   170: invokevirtual 217	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   173: pop
    //   174: aload 9
    //   176: ldc 242
    //   178: aload 13
    //   180: invokevirtual 217	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   183: pop
    //   184: aload 9
    //   186: ldc 244
    //   188: aload 6
    //   190: invokevirtual 217	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   193: pop
    //   194: aload 5
    //   196: invokeinterface 247 1 0
    //   201: bipush 99
    //   203: if_icmpne +123 -> 326
    //   206: aload 5
    //   208: invokeinterface 250 1 0
    //   213: astore 6
    //   215: aload 9
    //   217: ldc 252
    //   219: ldc 254
    //   221: invokevirtual 217	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   224: pop
    //   225: aload 9
    //   227: ldc_w 256
    //   230: aload 6
    //   232: getfield 261	com/tencent/mobileqq/troop/data/TroopInfoData:troopName	Ljava/lang/String;
    //   235: invokevirtual 217	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   238: pop
    //   239: aload 9
    //   241: ldc_w 263
    //   244: aload 6
    //   246: getfield 267	com/tencent/mobileqq/troop/data/TroopInfoData:bOwner	Z
    //   249: invokevirtual 222	org/json/JSONObject:put	(Ljava/lang/String;Z)Lorg/json/JSONObject;
    //   252: pop
    //   253: aload 9
    //   255: ldc_w 269
    //   258: aload 6
    //   260: getfield 272	com/tencent/mobileqq/troop/data/TroopInfoData:bAdmin	Z
    //   263: invokevirtual 222	org/json/JSONObject:put	(Ljava/lang/String;Z)Lorg/json/JSONObject;
    //   266: pop
    //   267: aload 9
    //   269: ldc_w 274
    //   272: aload 6
    //   274: getfield 277	com/tencent/mobileqq/troop/data/TroopInfoData:troopCard	Ljava/lang/String;
    //   277: invokevirtual 217	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   280: pop
    //   281: aload 9
    //   283: ldc_w 279
    //   286: aload 5
    //   288: invokeinterface 281 1 0
    //   293: invokevirtual 284	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   296: pop
    //   297: aload 9
    //   299: ldc_w 286
    //   302: aload 5
    //   304: invokeinterface 288 1 0
    //   309: invokevirtual 291	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   312: pop
    //   313: aload 9
    //   315: ldc_w 293
    //   318: aload_0
    //   319: getfield 23	com/tencent/av/share/ShareChat$SharePanel:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   322: invokevirtual 217	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   325: pop
    //   326: aload 5
    //   328: iconst_0
    //   329: invokeinterface 295 2 0
    //   334: astore 5
    //   336: aload 5
    //   338: invokestatic 126	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   341: ifne +75 -> 416
    //   344: new 210	org/json/JSONObject
    //   347: dup
    //   348: invokespecial 211	org/json/JSONObject:<init>	()V
    //   351: astore 6
    //   353: aload 6
    //   355: ldc_w 297
    //   358: aload 5
    //   360: invokevirtual 217	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   363: pop
    //   364: aload 6
    //   366: ldc_w 299
    //   369: aload 5
    //   371: invokevirtual 217	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   374: pop
    //   375: aload 6
    //   377: ldc_w 301
    //   380: ldc_w 303
    //   383: invokevirtual 217	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   386: pop
    //   387: aload 6
    //   389: ldc_w 305
    //   392: ldc 106
    //   394: aload_0
    //   395: getfield 23	com/tencent/av/share/ShareChat$SharePanel:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   398: invokestatic 310	com/tencent/mobileqq/utils/StringUtil:a	(Ljava/lang/String;Ljava/lang/String;)J
    //   401: invokevirtual 284	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   404: pop
    //   405: aload 9
    //   407: ldc_w 312
    //   410: aload 6
    //   412: invokevirtual 217	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   415: pop
    //   416: aload 8
    //   418: ldc_w 314
    //   421: aload 9
    //   423: invokevirtual 217	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   426: pop
    //   427: aload 7
    //   429: ldc_w 316
    //   432: aload 8
    //   434: invokevirtual 217	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   437: pop
    //   438: aload 7
    //   440: invokevirtual 317	org/json/JSONObject:toString	()Ljava/lang/String;
    //   443: astore 11
    //   445: aload 7
    //   447: ldc 228
    //   449: invokevirtual 320	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   452: astore 5
    //   454: aload 7
    //   456: ldc 232
    //   458: invokevirtual 320	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   461: astore 6
    //   463: aload 7
    //   465: ldc 236
    //   467: invokevirtual 320	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   470: astore 8
    //   472: aload 7
    //   474: ldc 226
    //   476: invokevirtual 320	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   479: astore 9
    //   481: aload 7
    //   483: ldc_w 316
    //   486: invokevirtual 320	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   489: astore 10
    //   491: aload 7
    //   493: ldc 213
    //   495: invokevirtual 320	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   498: astore 7
    //   500: new 83	java/lang/StringBuilder
    //   503: dup
    //   504: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   507: astore 12
    //   509: aload 12
    //   511: ldc_w 322
    //   514: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   517: pop
    //   518: aload 12
    //   520: aload 11
    //   522: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   525: pop
    //   526: aload 12
    //   528: ldc_w 324
    //   531: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   534: pop
    //   535: aload 12
    //   537: aload 5
    //   539: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   542: pop
    //   543: aload 12
    //   545: ldc_w 326
    //   548: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   551: pop
    //   552: aload 12
    //   554: aload 6
    //   556: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   559: pop
    //   560: aload 12
    //   562: ldc_w 328
    //   565: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   568: pop
    //   569: aload 12
    //   571: aload 8
    //   573: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   576: pop
    //   577: aload 12
    //   579: ldc_w 330
    //   582: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   585: pop
    //   586: aload 12
    //   588: aload 9
    //   590: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   593: pop
    //   594: aload 12
    //   596: ldc_w 332
    //   599: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   602: pop
    //   603: aload 12
    //   605: aload 10
    //   607: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   610: pop
    //   611: aload 12
    //   613: ldc_w 334
    //   616: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   619: pop
    //   620: aload 12
    //   622: aload 7
    //   624: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   627: pop
    //   628: aload 12
    //   630: ldc 99
    //   632: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   635: pop
    //   636: aload 12
    //   638: lload_1
    //   639: invokevirtual 102	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   642: pop
    //   643: aload 12
    //   645: ldc 104
    //   647: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   650: pop
    //   651: ldc 106
    //   653: iconst_1
    //   654: aload 12
    //   656: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   659: invokestatic 114	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   662: new 336	android/content/Intent
    //   665: dup
    //   666: invokespecial 337	android/content/Intent:<init>	()V
    //   669: astore 11
    //   671: aload 11
    //   673: ldc_w 339
    //   676: bipush 27
    //   678: invokevirtual 343	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   681: pop
    //   682: aload 11
    //   684: ldc_w 345
    //   687: iconst_1
    //   688: invokevirtual 348	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   691: pop
    //   692: aload 11
    //   694: ldc_w 350
    //   697: aload 5
    //   699: invokevirtual 353	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   702: pop
    //   703: aload 11
    //   705: ldc_w 355
    //   708: aload 8
    //   710: invokevirtual 353	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   713: pop
    //   714: aload 11
    //   716: ldc_w 357
    //   719: aload 6
    //   721: invokevirtual 353	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   724: pop
    //   725: aload 11
    //   727: ldc_w 359
    //   730: aload 7
    //   732: invokevirtual 353	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   735: pop
    //   736: aload 11
    //   738: ldc_w 361
    //   741: aload 10
    //   743: invokevirtual 353	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   746: pop
    //   747: aload 11
    //   749: ldc_w 363
    //   752: aload 9
    //   754: invokevirtual 353	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   757: pop
    //   758: aload 11
    //   760: aload 5
    //   762: aload 8
    //   764: aload 6
    //   766: aload 10
    //   768: aload_3
    //   769: invokevirtual 367	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   772: invokevirtual 373	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   775: getfield 379	android/util/DisplayMetrics:scaledDensity	F
    //   778: aconst_null
    //   779: aconst_null
    //   780: invokestatic 384	com/tencent/mobileqq/utils/QQCustomArkDialog$AppInfo:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;FLjava/lang/String;Landroid/os/Bundle;)Landroid/os/Bundle;
    //   783: invokevirtual 406	android/content/Intent:putExtras	(Landroid/os/Bundle;)Landroid/content/Intent;
    //   786: pop
    //   787: aload 11
    //   789: ldc 172
    //   791: new 174	com/tencent/av/share/ShareChat$MyResultReceiver
    //   794: dup
    //   795: new 176	android/os/Handler
    //   798: dup
    //   799: invokespecial 177	android/os/Handler:<init>	()V
    //   802: aload_0
    //   803: iconst_2
    //   804: iload 4
    //   806: lload_1
    //   807: invokespecial 180	com/tencent/av/share/ShareChat$MyResultReceiver:<init>	(Landroid/os/Handler;Lcom/tencent/av/share/ShareChat$SharePanel;IIJ)V
    //   810: invokevirtual 409	android/content/Intent:putExtra	(Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;
    //   813: pop
    //   814: aload_3
    //   815: aload 11
    //   817: invokestatic 625	com/tencent/mobileqq/forward/ForwardBaseOption:a	(Landroid/content/Context;Landroid/content/Intent;)V
    //   820: return
    //   821: astore 5
    //   823: goto +30 -> 853
    //   826: astore 5
    //   828: goto +25 -> 853
    //   831: astore 5
    //   833: goto +5 -> 838
    //   836: astore 5
    //   838: goto +10 -> 848
    //   841: astore 5
    //   843: goto +5 -> 848
    //   846: astore 5
    //   848: goto +5 -> 853
    //   851: astore 5
    //   853: new 83	java/lang/StringBuilder
    //   856: dup
    //   857: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   860: astore 6
    //   862: aload 6
    //   864: ldc_w 420
    //   867: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   870: pop
    //   871: aload 6
    //   873: lload_1
    //   874: invokevirtual 102	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   877: pop
    //   878: aload 6
    //   880: ldc 104
    //   882: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   885: pop
    //   886: ldc 106
    //   888: iconst_1
    //   889: aload 6
    //   891: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   894: aload 5
    //   896: invokestatic 423	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   899: aload_3
    //   900: ldc_w 424
    //   903: invokestatic 427	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   906: iconst_0
    //   907: invokestatic 432	com/tencent/mobileqq/widget/QQToast:a	(Landroid/content/Context;Ljava/lang/CharSequence;I)Lcom/tencent/mobileqq/widget/QQToast;
    //   910: invokevirtual 435	com/tencent/mobileqq/widget/QQToast:a	()Landroid/widget/Toast;
    //   913: pop
    //   914: aload_0
    //   915: iconst_0
    //   916: iload 4
    //   918: iconst_3
    //   919: invokevirtual 438	com/tencent/av/share/ShareChat$SharePanel:a	(III)V
    //   922: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	923	0	this	SharePanel
    //   0	923	1	paramLong	long
    //   0	923	3	paramContext	Context
    //   0	923	4	paramInt	int
    //   0	923	5	paramIHandle	ShareChat.SharePanel.IHandle
    //   0	923	6	paramString	String
    //   0	923	7	paramActionSheetItem	ShareActionSheetBuilder.ActionSheetItem
    //   10	753	8	localObject1	Object
    //   142	611	9	localObject2	Object
    //   16	751	10	str1	String
    //   23	793	11	localObject3	Object
    //   30	625	12	localObject4	Object
    //   38	141	13	str2	String
    // Exception table:
    //   from	to	target	type
    //   814	820	821	java/lang/Exception
    //   643	814	826	java/lang/Exception
    //   636	643	831	java/lang/Exception
    //   68	326	836	java/lang/Exception
    //   326	416	836	java/lang/Exception
    //   416	636	836	java/lang/Exception
    //   32	68	841	java/lang/Exception
    //   25	32	846	java/lang/Exception
    //   6	25	851	java/lang/Exception
  }
  
  void a(long paramLong, Context paramContext, ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    this.b = 0;
    c(paramLong, paramContext, paramActionSheetItem);
  }
  
  void a(long paramLong, Context paramContext, String paramString, int paramInt1, int paramInt2)
  {
    WXShareHelper.a().a(new ShareChat.SharePanel.MyWXShareListener(this, paramLong, paramContext, paramString, paramInt1, paramInt2));
  }
  
  void a(Context paramContext, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet != null) {
      return;
    }
    Object localObject = new ShareActionSheetV2.Param();
    ((ShareActionSheetV2.Param)localObject).context = paramContext;
    ((ShareActionSheetV2.Param)localObject).fullScreen = false;
    this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet = ShareActionSheetFactory.create((ShareActionSheetV2.Param)localObject);
    this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setActionSheetTitle(paramContext.getString(2131719029));
    this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setIntentForStartForwardRecentActivity(((Activity)paramContext).getIntent());
    this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setRowVisibility(0, 0, 0);
    paramContext = new ArrayList();
    localObject = new ArrayList();
    paramContext.add(ShareActionSheetBuilder.ActionSheetItem.build(2));
    paramContext.add(ShareActionSheetBuilder.ActionSheetItem.build(9));
    paramContext.add(ShareActionSheetBuilder.ActionSheetItem.build(10));
    if (paramInt != 99) {
      paramContext.add(ShareActionSheetBuilder.ActionSheetItem.build(3));
    }
    paramContext.add(ShareActionSheetBuilder.ActionSheetItem.build(26));
    if (paramInt != 99)
    {
      ((List)localObject).add(ShareActionSheetBuilder.ActionSheetItem.build(1));
      ((List)localObject).add(ShareActionSheetBuilder.ActionSheetItem.build(6));
      ((List)localObject).add(ShareActionSheetBuilder.ActionSheetItem.build(123));
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setActionSheetItems(paramContext, (List)localObject);
    this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setOnDismissListener(new ShareChat.SharePanel.2(this));
    this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setItemClickListenerV2(this.jdField_a_of_type_ComTencentAvShareShareChat$SharePanel$MyOnItemClickListener);
  }
  
  void a(Context paramContext, String paramString, int paramInt, ShareChat.SharePanel.IHandle paramIHandle)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ComTencentAvShareShareChat$SharePanel$IHandle = paramIHandle;
    this.jdField_a_of_type_ComTencentAvShareShareChat$SharePanel$MyOnItemClickListener = new ShareChat.SharePanel.MyOnItemClickListener(this, paramContext);
    this.jdField_a_of_type_ComTencentAvShareShareChat$SharePanel$MyOnItemClickListener.jdField_a_of_type_Long = this.jdField_a_of_type_Long;
    a(paramContext, paramInt);
    this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.show();
  }
  
  void b(long paramLong, Context paramContext, ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    this.b = 1;
    c(paramLong, paramContext, paramActionSheetItem);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append("");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.av.share.ShareChat.SharePanel
 * JD-Core Version:    0.7.0.1
 */