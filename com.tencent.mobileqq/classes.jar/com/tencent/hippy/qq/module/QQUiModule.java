package com.tencent.hippy.qq.module;

import aady;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import awam;
import awar;
import com.tencent.biz.pubaccount.PublicAccountJavascriptInterface;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.jsp.UiApiPlugin;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.annotation.HippyMethod;
import com.tencent.mtt.hippy.annotation.HippyNativeModule;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;
import org.json.JSONObject;

@HippyNativeModule(name="QQUiModule")
public class QQUiModule
  extends QQBaseLifecycleModule
{
  static final String CLASSNAME = "QQUiModule";
  private static final int CODE_OPEN_VIEW = 101;
  aady mClient = null;
  private Promise mOpenViewPromise;
  private awam mShareMsgImpl;
  awar mShareMsgImplListener = new QQUiModule.5(this);
  private Promise mShareMsgPromise;
  
  public QQUiModule(HippyEngineContext paramHippyEngineContext)
  {
    super(paramHippyEngineContext);
  }
  
  /* Error */
  private void excuteOpenView(String paramString, Promise paramPromise)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: aload_0
    //   4: aconst_null
    //   5: putfield 52	com/tencent/hippy/qq/module/QQUiModule:mOpenViewPromise	Lcom/tencent/mtt/hippy/modules/Promise;
    //   8: new 54	org/json/JSONObject
    //   11: dup
    //   12: aload_1
    //   13: invokespecial 57	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   16: astore_1
    //   17: aload_0
    //   18: invokevirtual 61	com/tencent/hippy/qq/module/QQUiModule:getActivity	()Landroid/app/Activity;
    //   21: astore 6
    //   23: aload 6
    //   25: instanceof 63
    //   28: ifeq +11 -> 39
    //   31: aload 6
    //   33: invokevirtual 69	android/app/Activity:isFinishing	()Z
    //   36: ifeq +18 -> 54
    //   39: ldc 10
    //   41: iconst_1
    //   42: ldc 71
    //   44: invokestatic 77	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   47: return
    //   48: astore_1
    //   49: aconst_null
    //   50: astore_1
    //   51: goto -34 -> 17
    //   54: aload_1
    //   55: ifnull +742 -> 797
    //   58: aload 6
    //   60: instanceof 63
    //   63: ifeq +734 -> 797
    //   66: aload_1
    //   67: ldc 79
    //   69: ldc 81
    //   71: invokevirtual 85	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   74: astore 8
    //   76: aload_1
    //   77: ldc 86
    //   79: invokevirtual 89	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   82: astore 7
    //   84: aload_1
    //   85: ldc 91
    //   87: invokevirtual 89	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   90: astore 9
    //   92: aload_1
    //   93: ldc 93
    //   95: iconst_m1
    //   96: invokevirtual 97	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   99: istore_3
    //   100: aload_1
    //   101: ldc 99
    //   103: invokevirtual 103	org/json/JSONObject:optBoolean	(Ljava/lang/String;)Z
    //   106: istore 5
    //   108: new 54	org/json/JSONObject
    //   111: dup
    //   112: aload 9
    //   114: invokespecial 57	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   117: astore_1
    //   118: ldc 105
    //   120: aload 8
    //   122: invokevirtual 111	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   125: ifeq +173 -> 298
    //   128: new 113	android/os/Bundle
    //   131: dup
    //   132: invokespecial 116	android/os/Bundle:<init>	()V
    //   135: astore 8
    //   137: aload 8
    //   139: ldc 91
    //   141: aload_1
    //   142: invokevirtual 120	org/json/JSONObject:toString	()Ljava/lang/String;
    //   145: invokevirtual 124	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   148: ldc 126
    //   150: aload 7
    //   152: invokevirtual 111	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   155: ifeq +78 -> 233
    //   158: new 128	bewd
    //   161: dup
    //   162: aload 6
    //   164: checkcast 63	com/tencent/mobileqq/app/BaseActivity
    //   167: aload 8
    //   169: invokespecial 131	bewd:<init>	(Lcom/tencent/mobileqq/app/BaseActivity;Landroid/os/Bundle;)V
    //   172: aload 6
    //   174: invokevirtual 135	bewd:a	(Landroid/app/Activity;)V
    //   177: iconst_0
    //   178: istore 5
    //   180: iconst_1
    //   181: istore_3
    //   182: iload 5
    //   184: ifeq +7 -> 191
    //   187: iload_3
    //   188: ifne +637 -> 825
    //   191: new 137	com/tencent/mtt/hippy/common/HippyMap
    //   194: dup
    //   195: invokespecial 138	com/tencent/mtt/hippy/common/HippyMap:<init>	()V
    //   198: astore_1
    //   199: iload_3
    //   200: ifeq +620 -> 820
    //   203: iload 4
    //   205: istore_3
    //   206: aload_1
    //   207: ldc 140
    //   209: iload_3
    //   210: invokevirtual 144	com/tencent/mtt/hippy/common/HippyMap:pushInt	(Ljava/lang/String;I)V
    //   213: aload_2
    //   214: aload_1
    //   215: invokeinterface 150 2 0
    //   220: return
    //   221: astore_1
    //   222: new 54	org/json/JSONObject
    //   225: dup
    //   226: invokespecial 151	org/json/JSONObject:<init>	()V
    //   229: astore_1
    //   230: goto -112 -> 118
    //   233: ldc 153
    //   235: aload 7
    //   237: invokevirtual 111	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   240: ifeq -63 -> 177
    //   243: new 155	bexy
    //   246: dup
    //   247: aload 6
    //   249: checkcast 63	com/tencent/mobileqq/app/BaseActivity
    //   252: aload 8
    //   254: invokespecial 156	bexy:<init>	(Lcom/tencent/mobileqq/app/BaseActivity;Landroid/os/Bundle;)V
    //   257: aload 6
    //   259: invokevirtual 157	bexy:a	(Landroid/app/Activity;)V
    //   262: goto -85 -> 177
    //   265: astore_1
    //   266: iconst_0
    //   267: istore 5
    //   269: invokestatic 160	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   272: ifeq +21 -> 293
    //   275: ldc 10
    //   277: iconst_2
    //   278: ldc 162
    //   280: invokestatic 165	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   283: ldc 10
    //   285: iconst_2
    //   286: aload_1
    //   287: invokestatic 169	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   290: invokestatic 165	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   293: iconst_0
    //   294: istore_3
    //   295: goto -113 -> 182
    //   298: ldc 81
    //   300: aload 8
    //   302: invokevirtual 111	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   305: ifeq +295 -> 600
    //   308: new 171	android/content/Intent
    //   311: dup
    //   312: invokespecial 172	android/content/Intent:<init>	()V
    //   315: astore 8
    //   317: ldc 174
    //   319: aload 7
    //   321: invokevirtual 111	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   324: ifeq +106 -> 430
    //   327: aload 8
    //   329: new 176	android/content/ComponentName
    //   332: dup
    //   333: aload_0
    //   334: invokevirtual 61	com/tencent/hippy/qq/module/QQUiModule:getActivity	()Landroid/app/Activity;
    //   337: aload 7
    //   339: invokespecial 179	android/content/ComponentName:<init>	(Landroid/content/Context;Ljava/lang/String;)V
    //   342: invokevirtual 183	android/content/Intent:setComponent	(Landroid/content/ComponentName;)Landroid/content/Intent;
    //   345: pop
    //   346: aload 8
    //   348: ldc 185
    //   350: invokestatic 191	java/lang/System:currentTimeMillis	()J
    //   353: invokevirtual 195	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   356: pop
    //   357: aload 8
    //   359: ldc 91
    //   361: aload_1
    //   362: invokevirtual 120	org/json/JSONObject:toString	()Ljava/lang/String;
    //   365: invokevirtual 198	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   368: pop
    //   369: iload 5
    //   371: ifne +201 -> 572
    //   374: aload_0
    //   375: invokevirtual 202	com/tencent/hippy/qq/module/QQUiModule:getFragment	()Landroid/support/v4/app/Fragment;
    //   378: aload 8
    //   380: invokevirtual 208	android/support/v4/app/Fragment:startActivity	(Landroid/content/Intent;)V
    //   383: goto +448 -> 831
    //   386: ldc 210
    //   388: invokevirtual 215	java/lang/Class:getName	()Ljava/lang/String;
    //   391: aload 7
    //   393: invokevirtual 111	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   396: ifeq +459 -> 855
    //   399: aload_0
    //   400: getfield 28	com/tencent/hippy/qq/module/QQUiModule:mClient	Laady;
    //   403: ifnonnull +17 -> 420
    //   406: aload_0
    //   407: invokestatic 220	aady:a	()Laady;
    //   410: putfield 28	com/tencent/hippy/qq/module/QQUiModule:mClient	Laady;
    //   413: aload_0
    //   414: getfield 28	com/tencent/hippy/qq/module/QQUiModule:mClient	Laady;
    //   417: invokevirtual 222	aady:a	()V
    //   420: aload_0
    //   421: getfield 28	com/tencent/hippy/qq/module/QQUiModule:mClient	Laady;
    //   424: invokevirtual 225	aady:c	()V
    //   427: goto +428 -> 855
    //   430: ldc 227
    //   432: aload 7
    //   434: invokevirtual 111	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   437: ifeq +75 -> 512
    //   440: aload 8
    //   442: new 176	android/content/ComponentName
    //   445: dup
    //   446: aload 6
    //   448: aload 7
    //   450: invokespecial 179	android/content/ComponentName:<init>	(Landroid/content/Context;Ljava/lang/String;)V
    //   453: invokevirtual 183	android/content/Intent:setComponent	(Landroid/content/ComponentName;)Landroid/content/Intent;
    //   456: pop
    //   457: aload 8
    //   459: ldc 229
    //   461: iconst_0
    //   462: invokevirtual 232	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   465: pop
    //   466: aload 8
    //   468: ldc 234
    //   470: invokestatic 191	java/lang/System:currentTimeMillis	()J
    //   473: invokevirtual 195	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   476: pop
    //   477: aload 8
    //   479: getstatic 239	bmct:l	Ljava/lang/String;
    //   482: iconst_1
    //   483: invokevirtual 232	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   486: pop
    //   487: aload 8
    //   489: getstatic 241	bmct:e	Ljava/lang/String;
    //   492: ldc 243
    //   494: invokevirtual 198	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   497: pop
    //   498: aload 8
    //   500: getstatic 246	bmct:f	Ljava/lang/String;
    //   503: ldc 86
    //   505: invokevirtual 198	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   508: pop
    //   509: goto -152 -> 357
    //   512: ldc 248
    //   514: aload 7
    //   516: invokevirtual 111	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   519: ifeq +33 -> 552
    //   522: aload 8
    //   524: new 176	android/content/ComponentName
    //   527: dup
    //   528: aload 6
    //   530: aload 7
    //   532: invokespecial 179	android/content/ComponentName:<init>	(Landroid/content/Context;Ljava/lang/String;)V
    //   535: invokevirtual 183	android/content/Intent:setComponent	(Landroid/content/ComponentName;)Landroid/content/Intent;
    //   538: pop
    //   539: aload 8
    //   541: ldc 250
    //   543: ldc 252
    //   545: invokevirtual 198	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   548: pop
    //   549: goto -192 -> 357
    //   552: aload 8
    //   554: new 176	android/content/ComponentName
    //   557: dup
    //   558: aload 6
    //   560: aload 7
    //   562: invokespecial 179	android/content/ComponentName:<init>	(Landroid/content/Context;Ljava/lang/String;)V
    //   565: invokevirtual 183	android/content/Intent:setComponent	(Landroid/content/ComponentName;)Landroid/content/Intent;
    //   568: pop
    //   569: goto -212 -> 357
    //   572: aload_0
    //   573: invokevirtual 202	com/tencent/hippy/qq/module/QQUiModule:getFragment	()Landroid/support/v4/app/Fragment;
    //   576: aload 8
    //   578: bipush 101
    //   580: invokevirtual 256	android/support/v4/app/Fragment:startActivityForResult	(Landroid/content/Intent;I)V
    //   583: goto +248 -> 831
    //   586: aload 6
    //   588: ldc_w 257
    //   591: ldc_w 258
    //   594: invokevirtual 262	android/app/Activity:overridePendingTransition	(II)V
    //   597: goto -211 -> 386
    //   600: ldc_w 264
    //   603: aload 8
    //   605: invokevirtual 111	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   608: ifeq +276 -> 884
    //   611: aload 7
    //   613: ldc_w 266
    //   616: invokevirtual 111	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   619: ifeq +81 -> 700
    //   622: aload_1
    //   623: ldc_w 268
    //   626: iconst_0
    //   627: invokevirtual 97	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   630: iconst_1
    //   631: if_icmpne +231 -> 862
    //   634: aload_1
    //   635: ldc_w 270
    //   638: ldc_w 272
    //   641: invokevirtual 85	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   644: astore 7
    //   646: aload 6
    //   648: aload 6
    //   650: checkcast 63	com/tencent/mobileqq/app/BaseActivity
    //   653: invokevirtual 276	com/tencent/mobileqq/app/BaseActivity:getAppInterface	()Lcom/tencent/common/app/AppInterface;
    //   656: aload_1
    //   657: invokevirtual 120	org/json/JSONObject:toString	()Ljava/lang/String;
    //   660: bipush 101
    //   662: aload 7
    //   664: invokestatic 281	beub:a	(Landroid/app/Activity;Lcom/tencent/common/app/AppInterface;Ljava/lang/String;BLjava/lang/String;)Landroid/content/Intent;
    //   667: astore_1
    //   668: aload_1
    //   669: ifnull +193 -> 862
    //   672: aload_0
    //   673: invokevirtual 284	com/tencent/hippy/qq/module/QQUiModule:downloadShortVideoFilterSo	()V
    //   676: aload_0
    //   677: invokevirtual 202	com/tencent/hippy/qq/module/QQUiModule:getFragment	()Landroid/support/v4/app/Fragment;
    //   680: aload_1
    //   681: bipush 101
    //   683: invokevirtual 256	android/support/v4/app/Fragment:startActivityForResult	(Landroid/content/Intent;I)V
    //   686: aload 6
    //   688: ldc_w 257
    //   691: ldc_w 258
    //   694: invokevirtual 262	android/app/Activity:overridePendingTransition	(II)V
    //   697: goto +165 -> 862
    //   700: aload 7
    //   702: ldc_w 286
    //   705: invokevirtual 215	java/lang/Class:getName	()Ljava/lang/String;
    //   708: invokevirtual 111	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   711: ifeq +173 -> 884
    //   714: new 171	android/content/Intent
    //   717: dup
    //   718: invokespecial 172	android/content/Intent:<init>	()V
    //   721: astore 8
    //   723: aload 8
    //   725: new 176	android/content/ComponentName
    //   728: dup
    //   729: aload 6
    //   731: aload 7
    //   733: invokespecial 179	android/content/ComponentName:<init>	(Landroid/content/Context;Ljava/lang/String;)V
    //   736: invokevirtual 183	android/content/Intent:setComponent	(Landroid/content/ComponentName;)Landroid/content/Intent;
    //   739: pop
    //   740: aload 8
    //   742: ldc 91
    //   744: aload_1
    //   745: invokevirtual 120	org/json/JSONObject:toString	()Ljava/lang/String;
    //   748: invokevirtual 198	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   751: pop
    //   752: iload 5
    //   754: ifne +15 -> 769
    //   757: aload_0
    //   758: invokevirtual 202	com/tencent/hippy/qq/module/QQUiModule:getFragment	()Landroid/support/v4/app/Fragment;
    //   761: aload 8
    //   763: invokevirtual 208	android/support/v4/app/Fragment:startActivity	(Landroid/content/Intent;)V
    //   766: goto +99 -> 865
    //   769: aload_0
    //   770: invokevirtual 202	com/tencent/hippy/qq/module/QQUiModule:getFragment	()Landroid/support/v4/app/Fragment;
    //   773: aload 8
    //   775: bipush 101
    //   777: invokevirtual 256	android/support/v4/app/Fragment:startActivityForResult	(Landroid/content/Intent;I)V
    //   780: goto +85 -> 865
    //   783: aload 6
    //   785: ldc_w 257
    //   788: ldc_w 258
    //   791: invokevirtual 262	android/app/Activity:overridePendingTransition	(II)V
    //   794: goto +90 -> 884
    //   797: invokestatic 160	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   800: ifeq +12 -> 812
    //   803: ldc 10
    //   805: iconst_2
    //   806: ldc_w 288
    //   809: invokestatic 165	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   812: iconst_0
    //   813: istore 5
    //   815: iconst_0
    //   816: istore_3
    //   817: goto -635 -> 182
    //   820: iconst_m1
    //   821: istore_3
    //   822: goto -616 -> 206
    //   825: aload_0
    //   826: aload_2
    //   827: putfield 52	com/tencent/hippy/qq/module/QQUiModule:mOpenViewPromise	Lcom/tencent/mtt/hippy/modules/Promise;
    //   830: return
    //   831: iload_3
    //   832: tableswitch	default:+20 -> 852, 1001:+-246->586
    //   853: impdep1
    //   854: iaload
    //   855: goto -675 -> 180
    //   858: astore_1
    //   859: goto -590 -> 269
    //   862: goto -682 -> 180
    //   865: iload_3
    //   866: tableswitch	default:+18 -> 884, 1001:+-83->783
    //   885: <illegal opcode>
    //   886: lstore_1
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	887	0	this	QQUiModule
    //   0	887	1	paramString	String
    //   0	887	2	paramPromise	Promise
    //   99	767	3	i	int
    //   1	203	4	j	int
    //   106	708	5	bool	boolean
    //   21	763	6	localActivity	Activity
    //   82	650	7	str1	String
    //   74	700	8	localObject	Object
    //   90	23	9	str2	String
    // Exception table:
    //   from	to	target	type
    //   8	17	48	org/json/JSONException
    //   108	118	221	org/json/JSONException
    //   66	108	265	java/lang/Exception
    //   148	177	265	java/lang/Exception
    //   233	262	265	java/lang/Exception
    //   108	118	858	java/lang/Exception
    //   118	148	858	java/lang/Exception
    //   222	230	858	java/lang/Exception
    //   298	357	858	java/lang/Exception
    //   357	369	858	java/lang/Exception
    //   374	383	858	java/lang/Exception
    //   386	420	858	java/lang/Exception
    //   420	427	858	java/lang/Exception
    //   430	509	858	java/lang/Exception
    //   512	549	858	java/lang/Exception
    //   552	569	858	java/lang/Exception
    //   572	583	858	java/lang/Exception
    //   586	597	858	java/lang/Exception
    //   600	668	858	java/lang/Exception
    //   672	697	858	java/lang/Exception
    //   700	752	858	java/lang/Exception
    //   757	766	858	java/lang/Exception
    //   769	780	858	java/lang/Exception
    //   783	794	858	java/lang/Exception
  }
  
  public void destroy()
  {
    super.destroy();
    if (this.mShareMsgImpl != null) {
      this.mShareMsgImpl.a();
    }
    if (this.mClient != null) {
      this.mClient.b();
    }
  }
  
  public void downloadShortVideoFilterSo()
  {
    if (this.mClient == null) {
      this.mClient = aady.a();
    }
    this.mClient.e();
  }
  
  public void onActivityResult(Activity paramActivity, int paramInt1, int paramInt2, Intent paramIntent)
  {
    switch (paramInt1)
    {
    default: 
      if (this.mShareMsgImpl != null) {
        this.mShareMsgImpl.a(paramIntent, (byte)paramInt1, paramInt2);
      }
      break;
    }
    do
    {
      return;
    } while (this.mOpenViewPromise == null);
    HippyMap localHippyMap = new HippyMap();
    if (paramInt2 == -1) {
      if (paramIntent == null)
      {
        paramActivity = "";
        localHippyMap.pushInt("code", 0);
        localHippyMap.pushString("result", paramActivity);
      }
    }
    for (;;)
    {
      this.mOpenViewPromise.resolve(localHippyMap);
      return;
      paramActivity = paramIntent.getStringExtra("result");
      break;
      localHippyMap.pushInt("code", -1);
    }
  }
  
  @HippyMethod(name="openMiniApp")
  public void openMiniApp(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QQUiModule", 2, "openMiniApp:" + paramString);
    }
    Activity localActivity = getActivity();
    if (localActivity == null)
    {
      QLog.e("QQUiModule", 1, "openMiniApp activity is null");
      return;
    }
    try
    {
      MiniAppLauncher.startMiniApp(localActivity, paramString, 2016, null);
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("QQUiModule", 1, "openMiniApp error: " + paramString.getMessage());
    }
  }
  
  @HippyMethod(name="openUrl")
  public void openUrl(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QQUiModule", 2, "openUrl:" + paramString);
    }
    Activity localActivity = getActivity();
    if (!(localActivity instanceof BaseActivity))
    {
      QLog.e("QQUiModule", 1, "openUrl activity isvnot BaseActivity");
      return;
    }
    UiApiPlugin.a(localActivity, null, ((BaseActivity)localActivity).getAppInterface(), paramString, true, true);
  }
  
  @HippyMethod(name="openView")
  public void openView(String paramString, Promise paramPromise)
  {
    ThreadManager.getUIHandler().post(new QQUiModule.3(this, paramString, paramPromise));
  }
  
  @HippyMethod(name="setStatusBarDarkFont")
  public void setStatusBarDarkFont(boolean paramBoolean)
  {
    Activity localActivity = getActivity();
    if ((localActivity != null) && (!localActivity.isFinishing()))
    {
      localActivity.runOnUiThread(new QQUiModule.1(this, paramBoolean));
      return;
    }
    QLog.e("QQUiModule", 1, "setStatusBarDarkFont activity is null");
  }
  
  @HippyMethod(name="shareMessage")
  public void shareMessage(String paramString, Promise paramPromise)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      localObject = getActivity();
      if (!(localObject instanceof BaseActivity)) {
        QLog.e("QQUiModule", 1, "shareMessage activity isvnot BaseActivity");
      }
    }
    else
    {
      return;
    }
    Object localObject = (BaseActivity)localObject;
    if (this.mShareMsgImpl == null) {
      this.mShareMsgImpl = new awam((Context)localObject, (Activity)localObject, ((BaseActivity)localObject).getAppInterface(), this.mShareMsgImplListener);
    }
    try
    {
      this.mShareMsgPromise = null;
      paramString = new JSONObject(paramString);
      if (paramPromise != null)
      {
        paramString.put("callback", paramPromise.getCallId());
        this.mShareMsgPromise = paramPromise;
      }
      this.mShareMsgImpl.a(paramString.toString(), false);
      return;
    }
    catch (Throwable paramString)
    {
      QLog.e("QQUiModule", 1, "shareMessage error:" + paramString);
    }
  }
  
  @HippyMethod(name="showDialog")
  public void showDialog(String paramString, Promise paramPromise)
  {
    try
    {
      paramString = new JSONObject(paramString);
      if (paramString != null) {
        ThreadManager.getUIHandler().post(new QQUiModule.4(this, paramPromise, paramString));
      }
      return;
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  @HippyMethod(name="showProfile")
  public void showProfile(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      localObject = getActivity();
      if (!(localObject instanceof BaseActivity)) {
        QLog.e("QQUiModule", 1, "showProfile activity isvnot BaseActivity");
      }
    }
    else
    {
      return;
    }
    Object localObject = (BaseActivity)localObject;
    PublicAccountJavascriptInterface.excuteShowProfile(((BaseActivity)localObject).getAppInterface(), (Context)localObject, paramString);
  }
  
  @HippyMethod(name="showTips")
  public void showTips(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      ThreadManager.getUIHandler().post(new QQUiModule.2(this, paramString));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.hippy.qq.module.QQUiModule
 * JD-Core Version:    0.7.0.1
 */