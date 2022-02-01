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
  final long a;
  int b = -1;
  int c;
  ShareActionSheet d;
  ShareChat.SharePanel.MyOnItemClickListener e;
  ShareChat.SharePanel.IHandle f = null;
  String g = null;
  
  ShareChat$SharePanel(long paramLong, int paramInt)
  {
    this.c = paramInt;
    this.a = paramLong;
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
    ((StringBuilder)localObject).append(paramContext.getString(2131890651));
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
    //   2: ifnull +973 -> 975
    //   5: aload 7
    //   7: ifnonnull +4 -> 11
    //   10: return
    //   11: aload_3
    //   12: invokestatic 61	com/tencent/av/share/ShareChat:a	(Landroid/content/Context;)Ljava/lang/String;
    //   15: astore 9
    //   17: aload_3
    //   18: invokestatic 61	com/tencent/av/share/ShareChat:a	(Landroid/content/Context;)Ljava/lang/String;
    //   21: astore 11
    //   23: aload 5
    //   25: invokestatic 64	com/tencent/av/share/ShareChat:a	(Lcom/tencent/av/share/ShareChat$SharePanel$IHandle;)Ljava/lang/String;
    //   28: astore 12
    //   30: aload 5
    //   32: invokestatic 122	com/tencent/av/share/ShareChat:b	(Lcom/tencent/av/share/ShareChat$SharePanel$IHandle;)Ljava/lang/String;
    //   35: astore 13
    //   37: aload_3
    //   38: ldc 213
    //   40: invokevirtual 142	android/content/Context:getString	(I)Ljava/lang/String;
    //   43: astore 14
    //   45: new 215	org/json/JSONObject
    //   48: dup
    //   49: invokespecial 216	org/json/JSONObject:<init>	()V
    //   52: astore 8
    //   54: aload 8
    //   56: ldc 218
    //   58: aload 9
    //   60: invokevirtual 222	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   63: pop
    //   64: new 215	org/json/JSONObject
    //   67: dup
    //   68: invokespecial 216	org/json/JSONObject:<init>	()V
    //   71: astore 9
    //   73: aload 9
    //   75: ldc 224
    //   77: iconst_1
    //   78: invokevirtual 227	org/json/JSONObject:put	(Ljava/lang/String;Z)Lorg/json/JSONObject;
    //   81: pop
    //   82: aload 9
    //   84: ldc 229
    //   86: iconst_1
    //   87: invokevirtual 227	org/json/JSONObject:put	(Ljava/lang/String;Z)Lorg/json/JSONObject;
    //   90: pop
    //   91: aload 8
    //   93: ldc 231
    //   95: aload 9
    //   97: invokevirtual 222	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   100: pop
    //   101: aload 8
    //   103: ldc 233
    //   105: ldc 235
    //   107: invokevirtual 222	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   110: pop
    //   111: aload 8
    //   113: ldc 237
    //   115: ldc 239
    //   117: invokevirtual 222	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   120: pop
    //   121: aload 8
    //   123: ldc 241
    //   125: ldc 243
    //   127: invokevirtual 222	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   130: pop
    //   131: new 215	org/json/JSONObject
    //   134: dup
    //   135: invokespecial 216	org/json/JSONObject:<init>	()V
    //   138: astore 9
    //   140: new 215	org/json/JSONObject
    //   143: dup
    //   144: invokespecial 216	org/json/JSONObject:<init>	()V
    //   147: astore 10
    //   149: aload 10
    //   151: ldc 147
    //   153: aload 11
    //   155: invokevirtual 222	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   158: pop
    //   159: aload 10
    //   161: ldc 153
    //   163: aload 12
    //   165: invokevirtual 222	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   168: pop
    //   169: aload 10
    //   171: ldc 245
    //   173: aload 13
    //   175: invokevirtual 222	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   178: pop
    //   179: aload 10
    //   181: ldc 247
    //   183: aload 14
    //   185: invokevirtual 222	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   188: pop
    //   189: aload 10
    //   191: ldc 249
    //   193: aload 6
    //   195: invokevirtual 222	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   198: pop
    //   199: aload 5
    //   201: invokeinterface 252 1 0
    //   206: bipush 99
    //   208: if_icmpne +125 -> 333
    //   211: aload 5
    //   213: invokeinterface 255 1 0
    //   218: astore 6
    //   220: aload 10
    //   222: ldc_w 257
    //   225: ldc_w 259
    //   228: invokevirtual 222	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   231: pop
    //   232: aload 10
    //   234: ldc_w 261
    //   237: aload 6
    //   239: getfield 266	com/tencent/mobileqq/troop/data/TroopInfoData:troopName	Ljava/lang/String;
    //   242: invokevirtual 222	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   245: pop
    //   246: aload 10
    //   248: ldc_w 268
    //   251: aload 6
    //   253: getfield 272	com/tencent/mobileqq/troop/data/TroopInfoData:bOwner	Z
    //   256: invokevirtual 227	org/json/JSONObject:put	(Ljava/lang/String;Z)Lorg/json/JSONObject;
    //   259: pop
    //   260: aload 10
    //   262: ldc_w 274
    //   265: aload 6
    //   267: getfield 277	com/tencent/mobileqq/troop/data/TroopInfoData:bAdmin	Z
    //   270: invokevirtual 227	org/json/JSONObject:put	(Ljava/lang/String;Z)Lorg/json/JSONObject;
    //   273: pop
    //   274: aload 10
    //   276: ldc_w 279
    //   279: aload 6
    //   281: getfield 282	com/tencent/mobileqq/troop/data/TroopInfoData:troopCard	Ljava/lang/String;
    //   284: invokevirtual 222	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   287: pop
    //   288: aload 10
    //   290: ldc_w 284
    //   293: aload 5
    //   295: invokeinterface 286 1 0
    //   300: invokevirtual 289	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   303: pop
    //   304: aload 10
    //   306: ldc_w 291
    //   309: aload 5
    //   311: invokeinterface 293 1 0
    //   316: invokevirtual 296	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   319: pop
    //   320: aload 10
    //   322: ldc_w 298
    //   325: aload_0
    //   326: getfield 28	com/tencent/av/share/ShareChat$SharePanel:g	Ljava/lang/String;
    //   329: invokevirtual 222	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   332: pop
    //   333: aload 5
    //   335: iconst_0
    //   336: invokeinterface 300 2 0
    //   341: astore 5
    //   343: aload 5
    //   345: invokestatic 131	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   348: ifne +75 -> 423
    //   351: new 215	org/json/JSONObject
    //   354: dup
    //   355: invokespecial 216	org/json/JSONObject:<init>	()V
    //   358: astore 6
    //   360: aload 6
    //   362: ldc_w 302
    //   365: aload 5
    //   367: invokevirtual 222	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   370: pop
    //   371: aload 6
    //   373: ldc_w 304
    //   376: aload 5
    //   378: invokevirtual 222	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   381: pop
    //   382: aload 6
    //   384: ldc_w 306
    //   387: ldc_w 308
    //   390: invokevirtual 222	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   393: pop
    //   394: aload 6
    //   396: ldc_w 310
    //   399: ldc 111
    //   401: aload_0
    //   402: getfield 28	com/tencent/av/share/ShareChat$SharePanel:g	Ljava/lang/String;
    //   405: invokestatic 316	com/tencent/mobileqq/utils/StringUtil:stringToLong	(Ljava/lang/String;Ljava/lang/String;)J
    //   408: invokevirtual 289	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   411: pop
    //   412: aload 10
    //   414: ldc_w 318
    //   417: aload 6
    //   419: invokevirtual 222	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   422: pop
    //   423: aload 9
    //   425: ldc_w 320
    //   428: aload 10
    //   430: invokevirtual 222	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   433: pop
    //   434: aload 8
    //   436: ldc_w 322
    //   439: aload 9
    //   441: invokevirtual 222	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   444: pop
    //   445: aload 8
    //   447: invokevirtual 323	org/json/JSONObject:toString	()Ljava/lang/String;
    //   450: astore 12
    //   452: aload 8
    //   454: ldc 233
    //   456: invokevirtual 326	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   459: astore 5
    //   461: aload 8
    //   463: ldc 237
    //   465: invokevirtual 326	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   468: astore 6
    //   470: aload 8
    //   472: ldc 241
    //   474: invokevirtual 326	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   477: astore 9
    //   479: aload 8
    //   481: ldc 231
    //   483: invokevirtual 326	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   486: astore 10
    //   488: aload 8
    //   490: ldc_w 322
    //   493: invokevirtual 326	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   496: astore 11
    //   498: aload 8
    //   500: ldc 218
    //   502: invokevirtual 326	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   505: astore 8
    //   507: new 88	java/lang/StringBuilder
    //   510: dup
    //   511: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   514: astore 13
    //   516: aload 13
    //   518: ldc_w 328
    //   521: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   524: pop
    //   525: aload 13
    //   527: aload 12
    //   529: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   532: pop
    //   533: aload 13
    //   535: ldc_w 330
    //   538: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   541: pop
    //   542: aload 13
    //   544: aload 5
    //   546: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   549: pop
    //   550: aload 13
    //   552: ldc_w 332
    //   555: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   558: pop
    //   559: aload 13
    //   561: aload 6
    //   563: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   566: pop
    //   567: aload 13
    //   569: ldc_w 334
    //   572: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   575: pop
    //   576: aload 13
    //   578: aload 9
    //   580: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   583: pop
    //   584: aload 13
    //   586: ldc_w 336
    //   589: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   592: pop
    //   593: aload 13
    //   595: aload 10
    //   597: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   600: pop
    //   601: aload 13
    //   603: ldc_w 338
    //   606: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   609: pop
    //   610: aload 13
    //   612: aload 11
    //   614: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   617: pop
    //   618: aload 13
    //   620: ldc_w 340
    //   623: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   626: pop
    //   627: aload 13
    //   629: aload 8
    //   631: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   634: pop
    //   635: aload 13
    //   637: ldc 104
    //   639: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   642: pop
    //   643: aload 13
    //   645: lload_1
    //   646: invokevirtual 107	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   649: pop
    //   650: aload 13
    //   652: ldc 109
    //   654: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   657: pop
    //   658: ldc 111
    //   660: iconst_1
    //   661: aload 13
    //   663: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   666: invokestatic 119	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   669: new 342	android/content/Intent
    //   672: dup
    //   673: invokespecial 343	android/content/Intent:<init>	()V
    //   676: astore 12
    //   678: aload 12
    //   680: ldc_w 345
    //   683: bipush 27
    //   685: invokevirtual 349	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   688: pop
    //   689: aload 12
    //   691: ldc_w 351
    //   694: iconst_1
    //   695: invokevirtual 354	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   698: pop
    //   699: aload 12
    //   701: ldc_w 356
    //   704: aload 5
    //   706: invokevirtual 359	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   709: pop
    //   710: aload 12
    //   712: ldc_w 361
    //   715: aload 9
    //   717: invokevirtual 359	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   720: pop
    //   721: aload 12
    //   723: ldc_w 363
    //   726: aload 6
    //   728: invokevirtual 359	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   731: pop
    //   732: aload 12
    //   734: ldc_w 365
    //   737: aload 8
    //   739: invokevirtual 359	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   742: pop
    //   743: aload 12
    //   745: ldc_w 367
    //   748: aload 11
    //   750: invokevirtual 359	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   753: pop
    //   754: aload 12
    //   756: ldc_w 369
    //   759: aload 10
    //   761: invokevirtual 359	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   764: pop
    //   765: aload 5
    //   767: aload 9
    //   769: aload 6
    //   771: aload 11
    //   773: aload_3
    //   774: invokevirtual 373	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   777: invokevirtual 379	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   780: getfield 385	android/util/DisplayMetrics:scaledDensity	F
    //   783: aconst_null
    //   784: aconst_null
    //   785: invokestatic 390	com/tencent/mobileqq/utils/QQCustomArkDialog$AppInfo:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;FLjava/lang/String;Landroid/os/Bundle;)Landroid/os/Bundle;
    //   788: astore 5
    //   790: aload 5
    //   792: ldc_w 392
    //   795: iconst_1
    //   796: invokevirtual 396	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   799: aload 5
    //   801: ldc_w 398
    //   804: aload 7
    //   806: getfield 403	com/tencent/mobileqq/utils/ShareActionSheetBuilder$ActionSheetItem:uinType	I
    //   809: invokevirtual 396	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   812: aload 5
    //   814: ldc_w 405
    //   817: aload 7
    //   819: getfield 408	com/tencent/mobileqq/utils/ShareActionSheetBuilder$ActionSheetItem:uin	Ljava/lang/String;
    //   822: invokevirtual 151	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   825: aload 12
    //   827: aload 5
    //   829: invokevirtual 412	android/content/Intent:putExtras	(Landroid/os/Bundle;)Landroid/content/Intent;
    //   832: pop
    //   833: aload 12
    //   835: ldc 177
    //   837: new 179	com/tencent/av/share/ShareChat$MyResultReceiver
    //   840: dup
    //   841: new 181	android/os/Handler
    //   844: dup
    //   845: invokespecial 182	android/os/Handler:<init>	()V
    //   848: aload_0
    //   849: iconst_3
    //   850: iload 4
    //   852: lload_1
    //   853: invokespecial 185	com/tencent/av/share/ShareChat$MyResultReceiver:<init>	(Landroid/os/Handler;Lcom/tencent/av/share/ShareChat$SharePanel;IIJ)V
    //   856: invokevirtual 415	android/content/Intent:putExtra	(Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;
    //   859: pop
    //   860: aload_3
    //   861: checkcast 417	android/app/Activity
    //   864: aload 12
    //   866: ldc_w 419
    //   869: iconst_m1
    //   870: invokestatic 424	com/tencent/mobileqq/forward/ForwardBaseOption:a	(Landroid/app/Activity;Landroid/content/Intent;Ljava/lang/Class;I)V
    //   873: return
    //   874: astore 5
    //   876: goto +30 -> 906
    //   879: astore 5
    //   881: goto +25 -> 906
    //   884: astore 5
    //   886: goto +5 -> 891
    //   889: astore 5
    //   891: goto +10 -> 901
    //   894: astore 5
    //   896: goto +5 -> 901
    //   899: astore 5
    //   901: goto +5 -> 906
    //   904: astore 5
    //   906: new 88	java/lang/StringBuilder
    //   909: dup
    //   910: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   913: astore 6
    //   915: aload 6
    //   917: ldc_w 426
    //   920: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   923: pop
    //   924: aload 6
    //   926: lload_1
    //   927: invokevirtual 107	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   930: pop
    //   931: aload 6
    //   933: ldc 109
    //   935: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   938: pop
    //   939: ldc 111
    //   941: iconst_1
    //   942: aload 6
    //   944: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   947: aload 5
    //   949: invokestatic 429	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   952: aload_3
    //   953: ldc_w 430
    //   956: invokestatic 433	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   959: iconst_0
    //   960: invokestatic 439	com/tencent/mobileqq/widget/QQToast:makeText	(Landroid/content/Context;Ljava/lang/CharSequence;I)Lcom/tencent/mobileqq/widget/QQToast;
    //   963: invokevirtual 443	com/tencent/mobileqq/widget/QQToast:show	()Landroid/widget/Toast;
    //   966: pop
    //   967: aload_0
    //   968: iconst_0
    //   969: iload 4
    //   971: iconst_3
    //   972: invokevirtual 446	com/tencent/av/share/ShareChat$SharePanel:a	(III)V
    //   975: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	976	0	this	SharePanel
    //   0	976	1	paramLong	long
    //   0	976	3	paramContext	Context
    //   0	976	4	paramInt	int
    //   0	976	5	paramIHandle	ShareChat.SharePanel.IHandle
    //   0	976	6	paramString	String
    //   0	976	7	paramActionSheetItem	ShareActionSheetBuilder.ActionSheetItem
    //   52	686	8	localObject1	Object
    //   15	753	9	localObject2	Object
    //   147	613	10	localObject3	Object
    //   21	751	11	str1	String
    //   28	837	12	localObject4	Object
    //   35	627	13	localObject5	Object
    //   43	141	14	str2	String
    // Exception table:
    //   from	to	target	type
    //   860	873	874	java/lang/Exception
    //   650	860	879	java/lang/Exception
    //   643	650	884	java/lang/Exception
    //   73	333	889	java/lang/Exception
    //   333	423	889	java/lang/Exception
    //   423	643	889	java/lang/Exception
    //   37	73	894	java/lang/Exception
    //   30	37	899	java/lang/Exception
    //   11	30	904	java/lang/Exception
  }
  
  private void c(long paramLong, Context paramContext, int paramInt, ShareChat.SharePanel.IHandle paramIHandle, String paramString)
  {
    paramIHandle = new StringBuilder();
    paramIHandle.append(paramContext.getString(2131890651));
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
    QQToast.makeText(paramContext, 2, 2131890652, 0).show();
    a(4, paramInt, 2);
  }
  
  private void c(long paramLong, Context paramContext, ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    Object localObject = this.f;
    if (localObject == null)
    {
      QLog.w("ShareChat", 1, "tryToGetShareLink, mIHandle为空");
      return;
    }
    localObject = ((ShareChat.SharePanel.IHandle)localObject).a(paramLong, this.c);
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      boolean bool = NetworkUtil.isNetSupport(null);
      paramActionSheetItem = new StringBuilder();
      paramActionSheetItem.append("tryToGetShareLink, url为空, isConn[");
      paramActionSheetItem.append(bool);
      paramActionSheetItem.append("], mChoosedChannel[");
      paramActionSheetItem.append(this.b);
      paramActionSheetItem.append("], mChoosedLinkType[");
      paramActionSheetItem.append(this.c);
      paramActionSheetItem.append("], seq[");
      paramActionSheetItem.append(paramLong);
      paramActionSheetItem.append("]");
      QLog.w("ShareChat", 1, paramActionSheetItem.toString());
      if ((!bool) && (this.b != 4))
      {
        QQToast.makeText(paramContext, paramContext.getString(2131889169), 0).show();
        if (QLog.isColorLevel())
        {
          paramContext = new StringBuilder();
          paramContext.append("tryToGetShareLink, !isNetSupport, mChoosedChannel[");
          paramContext.append(this.b);
          paramContext.append("]");
          QLog.w("ShareChat", 1, paramContext.toString());
        }
      }
      else
      {
        QQToast.makeText(paramContext, HardCodeUtil.a(2131911319), 0).show();
      }
      a(this.b, this.c, 3);
      return;
    }
    int i = this.b;
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
            QQToast.makeText(paramContext, 2, 2131889172, 0).show();
            return;
          case 5: 
            a(paramLong, paramContext, this.c, this.f, (String)localObject);
            return;
          case 4: 
            c(paramLong, paramContext, this.c, this.f, (String)localObject);
            return;
          case 3: 
            a(paramLong, paramContext, true, this.c, (String)localObject, this.f);
            return;
          case 2: 
            a(paramLong, paramContext, false, this.c, (String)localObject, this.f);
            return;
          case 1: 
            b(paramLong, paramContext, this.c, this.f, (String)localObject);
            return;
          }
        } else {
          a(paramLong, paramContext, this.c, this.f, (String)localObject, paramActionSheetItem);
        }
      }
      else {
        b(paramLong, paramContext, this.c, this.f, (String)localObject, paramActionSheetItem);
      }
    }
    else {
      d(paramLong, paramContext, this.c, this.f, (String)localObject);
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
    localStringBuilder.append(paramContext.getResources().getText(2131890651));
    localStringBuilder.append(paramString);
    paramIHandle.putExtra("forward_text", localStringBuilder.toString());
    paramIHandle.putExtra("openerProc", MobileQQ.getMobileQQ().getQQProcessName());
    paramContext.startActivity(paramIHandle);
  }
  
  void a()
  {
    this.b = -1;
  }
  
  void a(int paramInt1, int paramInt2, int paramInt3)
  {
    ShareChat.SharePanel.IHandle localIHandle = this.f;
    if (localIHandle != null) {
      localIHandle.a(paramInt1, paramInt2, paramInt3);
    }
    a();
  }
  
  void a(long paramLong, Context paramContext, int paramInt, ShareChat.SharePanel.IHandle paramIHandle, String paramString)
  {
    TroopInfoData localTroopInfoData = paramIHandle.f();
    if (localTroopInfoData == null)
    {
      a(5, paramInt, 3);
      return;
    }
    Intent localIntent = new Intent(paramContext, QRDisplayActivity.class);
    localIntent.putExtra("title", paramContext.getString(2131914017));
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
      bool1 = ((TroopManager)paramIHandle.getManager(QQManagerFactory.TROOP_MANAGER)).Z(localTroopInfoData.troopUin);
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
    //   7: invokestatic 61	com/tencent/av/share/ShareChat:a	(Landroid/content/Context;)Ljava/lang/String;
    //   10: astore 8
    //   12: aload_3
    //   13: invokestatic 61	com/tencent/av/share/ShareChat:a	(Landroid/content/Context;)Ljava/lang/String;
    //   16: astore 10
    //   18: aload 5
    //   20: invokestatic 64	com/tencent/av/share/ShareChat:a	(Lcom/tencent/av/share/ShareChat$SharePanel$IHandle;)Ljava/lang/String;
    //   23: astore 11
    //   25: aload 5
    //   27: invokestatic 122	com/tencent/av/share/ShareChat:b	(Lcom/tencent/av/share/ShareChat$SharePanel$IHandle;)Ljava/lang/String;
    //   30: astore 12
    //   32: aload_3
    //   33: ldc 213
    //   35: invokevirtual 142	android/content/Context:getString	(I)Ljava/lang/String;
    //   38: astore 13
    //   40: new 215	org/json/JSONObject
    //   43: dup
    //   44: invokespecial 216	org/json/JSONObject:<init>	()V
    //   47: astore 7
    //   49: aload 7
    //   51: ldc 218
    //   53: aload 8
    //   55: invokevirtual 222	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   58: pop
    //   59: new 215	org/json/JSONObject
    //   62: dup
    //   63: invokespecial 216	org/json/JSONObject:<init>	()V
    //   66: astore 8
    //   68: aload 8
    //   70: ldc 224
    //   72: iconst_1
    //   73: invokevirtual 227	org/json/JSONObject:put	(Ljava/lang/String;Z)Lorg/json/JSONObject;
    //   76: pop
    //   77: aload 8
    //   79: ldc 229
    //   81: iconst_1
    //   82: invokevirtual 227	org/json/JSONObject:put	(Ljava/lang/String;Z)Lorg/json/JSONObject;
    //   85: pop
    //   86: aload 7
    //   88: ldc 231
    //   90: aload 8
    //   92: invokevirtual 222	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   95: pop
    //   96: aload 7
    //   98: ldc 233
    //   100: ldc 235
    //   102: invokevirtual 222	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   105: pop
    //   106: aload 7
    //   108: ldc 237
    //   110: ldc 239
    //   112: invokevirtual 222	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   115: pop
    //   116: aload 7
    //   118: ldc 241
    //   120: ldc 243
    //   122: invokevirtual 222	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   125: pop
    //   126: new 215	org/json/JSONObject
    //   129: dup
    //   130: invokespecial 216	org/json/JSONObject:<init>	()V
    //   133: astore 8
    //   135: new 215	org/json/JSONObject
    //   138: dup
    //   139: invokespecial 216	org/json/JSONObject:<init>	()V
    //   142: astore 9
    //   144: aload 9
    //   146: ldc 147
    //   148: aload 10
    //   150: invokevirtual 222	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   153: pop
    //   154: aload 9
    //   156: ldc 153
    //   158: aload 11
    //   160: invokevirtual 222	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   163: pop
    //   164: aload 9
    //   166: ldc 245
    //   168: aload 12
    //   170: invokevirtual 222	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   173: pop
    //   174: aload 9
    //   176: ldc 247
    //   178: aload 13
    //   180: invokevirtual 222	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   183: pop
    //   184: aload 9
    //   186: ldc 249
    //   188: aload 6
    //   190: invokevirtual 222	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   193: pop
    //   194: aload 5
    //   196: invokeinterface 252 1 0
    //   201: bipush 99
    //   203: if_icmpne +125 -> 328
    //   206: aload 5
    //   208: invokeinterface 255 1 0
    //   213: astore 6
    //   215: aload 9
    //   217: ldc_w 257
    //   220: ldc_w 259
    //   223: invokevirtual 222	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   226: pop
    //   227: aload 9
    //   229: ldc_w 261
    //   232: aload 6
    //   234: getfield 266	com/tencent/mobileqq/troop/data/TroopInfoData:troopName	Ljava/lang/String;
    //   237: invokevirtual 222	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   240: pop
    //   241: aload 9
    //   243: ldc_w 268
    //   246: aload 6
    //   248: getfield 272	com/tencent/mobileqq/troop/data/TroopInfoData:bOwner	Z
    //   251: invokevirtual 227	org/json/JSONObject:put	(Ljava/lang/String;Z)Lorg/json/JSONObject;
    //   254: pop
    //   255: aload 9
    //   257: ldc_w 274
    //   260: aload 6
    //   262: getfield 277	com/tencent/mobileqq/troop/data/TroopInfoData:bAdmin	Z
    //   265: invokevirtual 227	org/json/JSONObject:put	(Ljava/lang/String;Z)Lorg/json/JSONObject;
    //   268: pop
    //   269: aload 9
    //   271: ldc_w 279
    //   274: aload 6
    //   276: getfield 282	com/tencent/mobileqq/troop/data/TroopInfoData:troopCard	Ljava/lang/String;
    //   279: invokevirtual 222	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   282: pop
    //   283: aload 9
    //   285: ldc_w 284
    //   288: aload 5
    //   290: invokeinterface 286 1 0
    //   295: invokevirtual 289	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   298: pop
    //   299: aload 9
    //   301: ldc_w 291
    //   304: aload 5
    //   306: invokeinterface 293 1 0
    //   311: invokevirtual 296	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   314: pop
    //   315: aload 9
    //   317: ldc_w 298
    //   320: aload_0
    //   321: getfield 28	com/tencent/av/share/ShareChat$SharePanel:g	Ljava/lang/String;
    //   324: invokevirtual 222	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   327: pop
    //   328: aload 5
    //   330: iconst_0
    //   331: invokeinterface 300 2 0
    //   336: astore 5
    //   338: aload 5
    //   340: invokestatic 131	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   343: ifne +75 -> 418
    //   346: new 215	org/json/JSONObject
    //   349: dup
    //   350: invokespecial 216	org/json/JSONObject:<init>	()V
    //   353: astore 6
    //   355: aload 6
    //   357: ldc_w 302
    //   360: aload 5
    //   362: invokevirtual 222	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   365: pop
    //   366: aload 6
    //   368: ldc_w 304
    //   371: aload 5
    //   373: invokevirtual 222	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   376: pop
    //   377: aload 6
    //   379: ldc_w 306
    //   382: ldc_w 308
    //   385: invokevirtual 222	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   388: pop
    //   389: aload 6
    //   391: ldc_w 310
    //   394: ldc 111
    //   396: aload_0
    //   397: getfield 28	com/tencent/av/share/ShareChat$SharePanel:g	Ljava/lang/String;
    //   400: invokestatic 316	com/tencent/mobileqq/utils/StringUtil:stringToLong	(Ljava/lang/String;Ljava/lang/String;)J
    //   403: invokevirtual 289	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   406: pop
    //   407: aload 9
    //   409: ldc_w 318
    //   412: aload 6
    //   414: invokevirtual 222	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   417: pop
    //   418: aload 8
    //   420: ldc_w 320
    //   423: aload 9
    //   425: invokevirtual 222	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   428: pop
    //   429: aload 7
    //   431: ldc_w 322
    //   434: aload 8
    //   436: invokevirtual 222	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   439: pop
    //   440: aload 7
    //   442: invokevirtual 323	org/json/JSONObject:toString	()Ljava/lang/String;
    //   445: astore 11
    //   447: aload 7
    //   449: ldc 233
    //   451: invokevirtual 326	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   454: astore 5
    //   456: aload 7
    //   458: ldc 237
    //   460: invokevirtual 326	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   463: astore 6
    //   465: aload 7
    //   467: ldc 241
    //   469: invokevirtual 326	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   472: astore 8
    //   474: aload 7
    //   476: ldc 231
    //   478: invokevirtual 326	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   481: astore 9
    //   483: aload 7
    //   485: ldc_w 322
    //   488: invokevirtual 326	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   491: astore 10
    //   493: aload 7
    //   495: ldc 218
    //   497: invokevirtual 326	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   500: astore 7
    //   502: new 88	java/lang/StringBuilder
    //   505: dup
    //   506: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   509: astore 12
    //   511: aload 12
    //   513: ldc_w 328
    //   516: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   519: pop
    //   520: aload 12
    //   522: aload 11
    //   524: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   527: pop
    //   528: aload 12
    //   530: ldc_w 330
    //   533: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   536: pop
    //   537: aload 12
    //   539: aload 5
    //   541: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   544: pop
    //   545: aload 12
    //   547: ldc_w 332
    //   550: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   553: pop
    //   554: aload 12
    //   556: aload 6
    //   558: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   561: pop
    //   562: aload 12
    //   564: ldc_w 334
    //   567: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   570: pop
    //   571: aload 12
    //   573: aload 8
    //   575: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   578: pop
    //   579: aload 12
    //   581: ldc_w 336
    //   584: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   587: pop
    //   588: aload 12
    //   590: aload 9
    //   592: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   595: pop
    //   596: aload 12
    //   598: ldc_w 338
    //   601: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   604: pop
    //   605: aload 12
    //   607: aload 10
    //   609: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   612: pop
    //   613: aload 12
    //   615: ldc_w 340
    //   618: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   621: pop
    //   622: aload 12
    //   624: aload 7
    //   626: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   629: pop
    //   630: aload 12
    //   632: ldc 104
    //   634: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   637: pop
    //   638: aload 12
    //   640: lload_1
    //   641: invokevirtual 107	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   644: pop
    //   645: aload 12
    //   647: ldc 109
    //   649: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   652: pop
    //   653: ldc 111
    //   655: iconst_1
    //   656: aload 12
    //   658: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   661: invokestatic 119	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   664: new 342	android/content/Intent
    //   667: dup
    //   668: invokespecial 343	android/content/Intent:<init>	()V
    //   671: astore 11
    //   673: aload 11
    //   675: ldc_w 345
    //   678: bipush 27
    //   680: invokevirtual 349	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   683: pop
    //   684: aload 11
    //   686: ldc_w 351
    //   689: iconst_1
    //   690: invokevirtual 354	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   693: pop
    //   694: aload 11
    //   696: ldc_w 356
    //   699: aload 5
    //   701: invokevirtual 359	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   704: pop
    //   705: aload 11
    //   707: ldc_w 361
    //   710: aload 8
    //   712: invokevirtual 359	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   715: pop
    //   716: aload 11
    //   718: ldc_w 363
    //   721: aload 6
    //   723: invokevirtual 359	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   726: pop
    //   727: aload 11
    //   729: ldc_w 365
    //   732: aload 7
    //   734: invokevirtual 359	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   737: pop
    //   738: aload 11
    //   740: ldc_w 367
    //   743: aload 10
    //   745: invokevirtual 359	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   748: pop
    //   749: aload 11
    //   751: ldc_w 369
    //   754: aload 9
    //   756: invokevirtual 359	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   759: pop
    //   760: aload 11
    //   762: aload 5
    //   764: aload 8
    //   766: aload 6
    //   768: aload 10
    //   770: aload_3
    //   771: invokevirtual 373	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   774: invokevirtual 379	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   777: getfield 385	android/util/DisplayMetrics:scaledDensity	F
    //   780: aconst_null
    //   781: aconst_null
    //   782: invokestatic 390	com/tencent/mobileqq/utils/QQCustomArkDialog$AppInfo:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;FLjava/lang/String;Landroid/os/Bundle;)Landroid/os/Bundle;
    //   785: invokevirtual 412	android/content/Intent:putExtras	(Landroid/os/Bundle;)Landroid/content/Intent;
    //   788: pop
    //   789: aload 11
    //   791: ldc 177
    //   793: new 179	com/tencent/av/share/ShareChat$MyResultReceiver
    //   796: dup
    //   797: new 181	android/os/Handler
    //   800: dup
    //   801: invokespecial 182	android/os/Handler:<init>	()V
    //   804: aload_0
    //   805: iconst_2
    //   806: iload 4
    //   808: lload_1
    //   809: invokespecial 185	com/tencent/av/share/ShareChat$MyResultReceiver:<init>	(Landroid/os/Handler;Lcom/tencent/av/share/ShareChat$SharePanel;IIJ)V
    //   812: invokevirtual 415	android/content/Intent:putExtra	(Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;
    //   815: pop
    //   816: aload_3
    //   817: aload 11
    //   819: invokestatic 630	com/tencent/mobileqq/forward/ForwardBaseOption:a	(Landroid/content/Context;Landroid/content/Intent;)V
    //   822: return
    //   823: astore 5
    //   825: goto +30 -> 855
    //   828: astore 5
    //   830: goto +25 -> 855
    //   833: astore 5
    //   835: goto +5 -> 840
    //   838: astore 5
    //   840: goto +10 -> 850
    //   843: astore 5
    //   845: goto +5 -> 850
    //   848: astore 5
    //   850: goto +5 -> 855
    //   853: astore 5
    //   855: new 88	java/lang/StringBuilder
    //   858: dup
    //   859: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   862: astore 6
    //   864: aload 6
    //   866: ldc_w 426
    //   869: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   872: pop
    //   873: aload 6
    //   875: lload_1
    //   876: invokevirtual 107	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   879: pop
    //   880: aload 6
    //   882: ldc 109
    //   884: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   887: pop
    //   888: ldc 111
    //   890: iconst_1
    //   891: aload 6
    //   893: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   896: aload 5
    //   898: invokestatic 429	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   901: aload_3
    //   902: ldc_w 430
    //   905: invokestatic 433	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   908: iconst_0
    //   909: invokestatic 439	com/tencent/mobileqq/widget/QQToast:makeText	(Landroid/content/Context;Ljava/lang/CharSequence;I)Lcom/tencent/mobileqq/widget/QQToast;
    //   912: invokevirtual 443	com/tencent/mobileqq/widget/QQToast:show	()Landroid/widget/Toast;
    //   915: pop
    //   916: aload_0
    //   917: iconst_0
    //   918: iload 4
    //   920: iconst_3
    //   921: invokevirtual 446	com/tencent/av/share/ShareChat$SharePanel:a	(III)V
    //   924: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	925	0	this	SharePanel
    //   0	925	1	paramLong	long
    //   0	925	3	paramContext	Context
    //   0	925	4	paramInt	int
    //   0	925	5	paramIHandle	ShareChat.SharePanel.IHandle
    //   0	925	6	paramString	String
    //   0	925	7	paramActionSheetItem	ShareActionSheetBuilder.ActionSheetItem
    //   10	755	8	localObject1	Object
    //   142	613	9	localObject2	Object
    //   16	753	10	str1	String
    //   23	795	11	localObject3	Object
    //   30	627	12	localObject4	Object
    //   38	141	13	str2	String
    // Exception table:
    //   from	to	target	type
    //   816	822	823	java/lang/Exception
    //   645	816	828	java/lang/Exception
    //   638	645	833	java/lang/Exception
    //   68	328	838	java/lang/Exception
    //   328	418	838	java/lang/Exception
    //   418	638	838	java/lang/Exception
    //   32	68	843	java/lang/Exception
    //   25	32	848	java/lang/Exception
    //   6	25	853	java/lang/Exception
  }
  
  void a(long paramLong, Context paramContext, ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    this.c = 0;
    c(paramLong, paramContext, paramActionSheetItem);
  }
  
  void a(long paramLong, Context paramContext, String paramString, int paramInt1, int paramInt2)
  {
    WXShareHelper.a().a(new ShareChat.SharePanel.MyWXShareListener(this, paramLong, paramContext, paramString, paramInt1, paramInt2));
  }
  
  void a(Context paramContext, int paramInt)
  {
    if (this.d != null) {
      return;
    }
    Object localObject = new ShareActionSheetV2.Param();
    ((ShareActionSheetV2.Param)localObject).context = paramContext;
    ((ShareActionSheetV2.Param)localObject).fullScreen = false;
    this.d = ShareActionSheetFactory.create((ShareActionSheetV2.Param)localObject);
    this.d.setActionSheetTitle(paramContext.getString(2131916565));
    this.d.setIntentForStartForwardRecentActivity(((Activity)paramContext).getIntent());
    this.d.setRowVisibility(0, 0, 0);
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
    this.d.setActionSheetItems(paramContext, (List)localObject);
    this.d.setOnDismissListener(new ShareChat.SharePanel.2(this));
    this.d.setItemClickListenerV2(this.e);
  }
  
  void a(Context paramContext, String paramString, int paramInt, ShareChat.SharePanel.IHandle paramIHandle)
  {
    this.g = paramString;
    this.f = paramIHandle;
    this.e = new ShareChat.SharePanel.MyOnItemClickListener(this, paramContext);
    this.e.a = this.a;
    a(paramContext, paramInt);
    this.d.show();
  }
  
  void b(long paramLong, Context paramContext, ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    this.c = 1;
    c(paramLong, paramContext, paramActionSheetItem);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.a);
    localStringBuilder.append("");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.av.share.ShareChat.SharePanel
 * JD-Core Version:    0.7.0.1
 */