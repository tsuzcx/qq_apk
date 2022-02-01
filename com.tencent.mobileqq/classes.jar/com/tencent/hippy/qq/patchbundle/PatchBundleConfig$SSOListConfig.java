package com.tencent.hippy.qq.patchbundle;

import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import mqq.app.AppRuntime;

public class PatchBundleConfig$SSOListConfig
{
  public static final transient String COOKIE = "Cookie";
  public static final transient String UA;
  public static final transient String USER_AGENT = "User-Agent";
  public String mCmd;
  public String mKey;
  public String mMethod;
  public boolean mNeedCookie;
  public String mParam;
  public String mRsp;
  public String mType;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("QQ/8.7.0 Android/0.17 Android/");
    localStringBuilder.append(Build.VERSION.RELEASE);
    UA = localStringBuilder.toString();
  }
  
  /* Error */
  private void handleHttp()
  {
    // Byte code:
    //   0: invokestatic 61	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +37 -> 40
    //   6: new 24	java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial 27	java/lang/StringBuilder:<init>	()V
    //   13: astore_2
    //   14: aload_2
    //   15: ldc 63
    //   17: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20: pop
    //   21: aload_2
    //   22: aload_0
    //   23: getfield 65	com/tencent/hippy/qq/patchbundle/PatchBundleConfig$SSOListConfig:mCmd	Ljava/lang/String;
    //   26: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: pop
    //   30: ldc 67
    //   32: iconst_2
    //   33: aload_2
    //   34: invokevirtual 42	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   37: invokestatic 71	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   40: aconst_null
    //   41: astore 5
    //   43: aconst_null
    //   44: astore 6
    //   46: aload_0
    //   47: getfield 65	com/tencent/hippy/qq/patchbundle/PatchBundleConfig$SSOListConfig:mCmd	Ljava/lang/String;
    //   50: invokestatic 77	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   53: ifeq +4 -> 57
    //   56: return
    //   57: aload_0
    //   58: getfield 65	com/tencent/hippy/qq/patchbundle/PatchBundleConfig$SSOListConfig:mCmd	Ljava/lang/String;
    //   61: astore_2
    //   62: aload_2
    //   63: astore 4
    //   65: aload_2
    //   66: ldc 79
    //   68: invokevirtual 84	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   71: ifne +30 -> 101
    //   74: new 24	java/lang/StringBuilder
    //   77: dup
    //   78: invokespecial 27	java/lang/StringBuilder:<init>	()V
    //   81: astore_3
    //   82: aload_3
    //   83: aload_2
    //   84: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: pop
    //   88: aload_3
    //   89: ldc 79
    //   91: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: pop
    //   95: aload_3
    //   96: invokevirtual 42	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   99: astore 4
    //   101: invokestatic 90	com/tencent/hippy/qq/patchbundle/PatchBundleConfig:access$000	()Lmqq/app/AppRuntime;
    //   104: astore_2
    //   105: aload_2
    //   106: ifnonnull +12 -> 118
    //   109: ldc 67
    //   111: iconst_1
    //   112: ldc 92
    //   114: invokestatic 95	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   117: return
    //   118: aload_2
    //   119: ifnull +877 -> 996
    //   122: aload_2
    //   123: iconst_2
    //   124: invokevirtual 101	mqq/app/AppRuntime:getManager	(I)Lmqq/manager/Manager;
    //   127: checkcast 103	mqq/manager/TicketManager
    //   130: astore_3
    //   131: aload_2
    //   132: invokevirtual 106	mqq/app/AppRuntime:getAccount	()Ljava/lang/String;
    //   135: astore_2
    //   136: aload_3
    //   137: aload_2
    //   138: invokeinterface 110 2 0
    //   143: astore_3
    //   144: goto +3 -> 147
    //   147: new 24	java/lang/StringBuilder
    //   150: dup
    //   151: invokespecial 27	java/lang/StringBuilder:<init>	()V
    //   154: astore 7
    //   156: aload 7
    //   158: aload 4
    //   160: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   163: pop
    //   164: aload 7
    //   166: ldc 112
    //   168: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: pop
    //   172: aload 7
    //   174: invokevirtual 42	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   177: astore 4
    //   179: new 24	java/lang/StringBuilder
    //   182: dup
    //   183: invokespecial 27	java/lang/StringBuilder:<init>	()V
    //   186: astore 7
    //   188: aload 7
    //   190: aload 4
    //   192: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   195: pop
    //   196: aload 7
    //   198: ldc 114
    //   200: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   203: pop
    //   204: aload 7
    //   206: invokevirtual 42	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   209: astore 4
    //   211: new 24	java/lang/StringBuilder
    //   214: dup
    //   215: invokespecial 27	java/lang/StringBuilder:<init>	()V
    //   218: astore 7
    //   220: aload 7
    //   222: aload 4
    //   224: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   227: pop
    //   228: aload 7
    //   230: ldc 116
    //   232: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   235: pop
    //   236: aload 7
    //   238: invokevirtual 42	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   241: astore 4
    //   243: new 24	java/lang/StringBuilder
    //   246: dup
    //   247: invokespecial 27	java/lang/StringBuilder:<init>	()V
    //   250: astore 7
    //   252: aload 7
    //   254: aload 4
    //   256: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   259: pop
    //   260: aload 7
    //   262: ldc 118
    //   264: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   267: pop
    //   268: aload 7
    //   270: invokevirtual 42	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   273: astore 4
    //   275: new 24	java/lang/StringBuilder
    //   278: dup
    //   279: invokespecial 27	java/lang/StringBuilder:<init>	()V
    //   282: astore 7
    //   284: aload 7
    //   286: aload 4
    //   288: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   291: pop
    //   292: aload 7
    //   294: ldc 120
    //   296: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   299: pop
    //   300: aload 7
    //   302: aload_3
    //   303: invokestatic 126	com/tencent/hippy/qq/patchbundle/PatchUtils:generateGTK	(Ljava/lang/String;)I
    //   306: invokevirtual 129	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   309: pop
    //   310: aload 7
    //   312: invokevirtual 42	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   315: astore 7
    //   317: aload 7
    //   319: astore 4
    //   321: aload_0
    //   322: getfield 131	com/tencent/hippy/qq/patchbundle/PatchBundleConfig$SSOListConfig:mMethod	Ljava/lang/String;
    //   325: invokestatic 77	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   328: ifne +75 -> 403
    //   331: aload 7
    //   333: astore 4
    //   335: ldc 133
    //   337: aload_0
    //   338: getfield 131	com/tencent/hippy/qq/patchbundle/PatchBundleConfig$SSOListConfig:mMethod	Ljava/lang/String;
    //   341: invokevirtual 137	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   344: ifeq +59 -> 403
    //   347: aload 7
    //   349: astore 4
    //   351: aload_0
    //   352: getfield 139	com/tencent/hippy/qq/patchbundle/PatchBundleConfig$SSOListConfig:mParam	Ljava/lang/String;
    //   355: invokestatic 77	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   358: ifne +45 -> 403
    //   361: new 24	java/lang/StringBuilder
    //   364: dup
    //   365: invokespecial 27	java/lang/StringBuilder:<init>	()V
    //   368: astore 4
    //   370: aload 4
    //   372: aload 7
    //   374: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   377: pop
    //   378: aload 4
    //   380: ldc 141
    //   382: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   385: pop
    //   386: aload 4
    //   388: aload_0
    //   389: getfield 139	com/tencent/hippy/qq/patchbundle/PatchBundleConfig$SSOListConfig:mParam	Ljava/lang/String;
    //   392: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   395: pop
    //   396: aload 4
    //   398: invokevirtual 42	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   401: astore 4
    //   403: invokestatic 61	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   406: ifeq +39 -> 445
    //   409: new 24	java/lang/StringBuilder
    //   412: dup
    //   413: invokespecial 27	java/lang/StringBuilder:<init>	()V
    //   416: astore 7
    //   418: aload 7
    //   420: ldc 143
    //   422: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   425: pop
    //   426: aload 7
    //   428: aload 4
    //   430: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   433: pop
    //   434: ldc 67
    //   436: iconst_2
    //   437: aload 7
    //   439: invokevirtual 42	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   442: invokestatic 71	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   445: new 145	java/net/URL
    //   448: dup
    //   449: aload 4
    //   451: invokespecial 148	java/net/URL:<init>	(Ljava/lang/String;)V
    //   454: invokevirtual 152	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   457: checkcast 154	java/net/HttpURLConnection
    //   460: astore 4
    //   462: aload 4
    //   464: iconst_0
    //   465: invokevirtual 158	java/net/HttpURLConnection:setUseCaches	(Z)V
    //   468: aload 4
    //   470: iconst_1
    //   471: invokevirtual 161	java/net/HttpURLConnection:setDoInput	(Z)V
    //   474: aload_0
    //   475: getfield 163	com/tencent/hippy/qq/patchbundle/PatchBundleConfig$SSOListConfig:mNeedCookie	Z
    //   478: ifeq +54 -> 532
    //   481: new 24	java/lang/StringBuilder
    //   484: dup
    //   485: invokespecial 27	java/lang/StringBuilder:<init>	()V
    //   488: astore 7
    //   490: aload 7
    //   492: ldc 165
    //   494: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   497: pop
    //   498: aload 7
    //   500: aload_2
    //   501: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   504: pop
    //   505: aload 7
    //   507: ldc 167
    //   509: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   512: pop
    //   513: aload 7
    //   515: aload_3
    //   516: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   519: pop
    //   520: aload 4
    //   522: ldc 8
    //   524: aload 7
    //   526: invokevirtual 42	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   529: invokevirtual 171	java/net/HttpURLConnection:addRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   532: aload 4
    //   534: ldc 12
    //   536: getstatic 44	com/tencent/hippy/qq/patchbundle/PatchBundleConfig$SSOListConfig:UA	Ljava/lang/String;
    //   539: invokevirtual 171	java/net/HttpURLConnection:addRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   542: aload_0
    //   543: getfield 131	com/tencent/hippy/qq/patchbundle/PatchBundleConfig$SSOListConfig:mMethod	Ljava/lang/String;
    //   546: invokestatic 77	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   549: ifne +69 -> 618
    //   552: ldc 173
    //   554: aload_0
    //   555: getfield 131	com/tencent/hippy/qq/patchbundle/PatchBundleConfig$SSOListConfig:mMethod	Ljava/lang/String;
    //   558: invokevirtual 176	java/lang/String:toUpperCase	()Ljava/lang/String;
    //   561: invokevirtual 137	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   564: ifeq +54 -> 618
    //   567: aload 4
    //   569: ldc 173
    //   571: invokevirtual 179	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   574: aload_0
    //   575: getfield 139	com/tencent/hippy/qq/patchbundle/PatchBundleConfig$SSOListConfig:mParam	Ljava/lang/String;
    //   578: ifnull +69 -> 647
    //   581: aload 4
    //   583: iconst_1
    //   584: invokevirtual 182	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   587: new 184	java/io/DataOutputStream
    //   590: dup
    //   591: aload 4
    //   593: invokevirtual 188	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   596: invokespecial 191	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   599: astore_2
    //   600: aload_2
    //   601: aload_0
    //   602: getfield 139	com/tencent/hippy/qq/patchbundle/PatchBundleConfig$SSOListConfig:mParam	Ljava/lang/String;
    //   605: invokevirtual 195	java/lang/String:getBytes	()[B
    //   608: invokevirtual 199	java/io/DataOutputStream:write	([B)V
    //   611: aload_2
    //   612: invokevirtual 202	java/io/DataOutputStream:close	()V
    //   615: goto +32 -> 647
    //   618: aload_0
    //   619: getfield 131	com/tencent/hippy/qq/patchbundle/PatchBundleConfig$SSOListConfig:mMethod	Ljava/lang/String;
    //   622: invokestatic 77	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   625: ifne +15 -> 640
    //   628: aload 4
    //   630: aload_0
    //   631: getfield 131	com/tencent/hippy/qq/patchbundle/PatchBundleConfig$SSOListConfig:mMethod	Ljava/lang/String;
    //   634: invokevirtual 179	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   637: goto +10 -> 647
    //   640: aload 4
    //   642: ldc 204
    //   644: invokevirtual 179	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   647: aload 4
    //   649: invokevirtual 208	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   652: astore_2
    //   653: new 210	java/io/ByteArrayOutputStream
    //   656: dup
    //   657: invokespecial 211	java/io/ByteArrayOutputStream:<init>	()V
    //   660: astore_3
    //   661: sipush 4096
    //   664: newarray byte
    //   666: astore 4
    //   668: aload_2
    //   669: aload 4
    //   671: invokevirtual 217	java/io/InputStream:read	([B)I
    //   674: istore_1
    //   675: iload_1
    //   676: iconst_m1
    //   677: if_icmpeq +14 -> 691
    //   680: aload_3
    //   681: aload 4
    //   683: iconst_0
    //   684: iload_1
    //   685: invokevirtual 220	java/io/ByteArrayOutputStream:write	([BII)V
    //   688: goto -20 -> 668
    //   691: aload_0
    //   692: aload_3
    //   693: invokevirtual 221	java/io/ByteArrayOutputStream:toString	()Ljava/lang/String;
    //   696: putfield 223	com/tencent/hippy/qq/patchbundle/PatchBundleConfig$SSOListConfig:mRsp	Ljava/lang/String;
    //   699: aload_2
    //   700: invokevirtual 224	java/io/InputStream:close	()V
    //   703: aload_3
    //   704: invokevirtual 225	java/io/ByteArrayOutputStream:close	()V
    //   707: invokestatic 61	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   710: ifeq +59 -> 769
    //   713: new 24	java/lang/StringBuilder
    //   716: dup
    //   717: invokespecial 27	java/lang/StringBuilder:<init>	()V
    //   720: astore 4
    //   722: aload 4
    //   724: ldc 227
    //   726: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   729: pop
    //   730: aload 4
    //   732: aload_0
    //   733: getfield 65	com/tencent/hippy/qq/patchbundle/PatchBundleConfig$SSOListConfig:mCmd	Ljava/lang/String;
    //   736: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   739: pop
    //   740: aload 4
    //   742: ldc 229
    //   744: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   747: pop
    //   748: aload 4
    //   750: aload_0
    //   751: getfield 223	com/tencent/hippy/qq/patchbundle/PatchBundleConfig$SSOListConfig:mRsp	Ljava/lang/String;
    //   754: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   757: pop
    //   758: ldc 67
    //   760: iconst_2
    //   761: aload 4
    //   763: invokevirtual 42	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   766: invokestatic 71	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   769: aload_2
    //   770: ifnull +22 -> 792
    //   773: aload_2
    //   774: invokevirtual 224	java/io/InputStream:close	()V
    //   777: goto +15 -> 792
    //   780: astore_2
    //   781: ldc 67
    //   783: iconst_1
    //   784: aload_2
    //   785: iconst_0
    //   786: anewarray 4	java/lang/Object
    //   789: invokestatic 232	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   792: aload_3
    //   793: invokevirtual 225	java/io/ByteArrayOutputStream:close	()V
    //   796: return
    //   797: astore_2
    //   798: ldc 67
    //   800: iconst_1
    //   801: aload_2
    //   802: iconst_0
    //   803: anewarray 4	java/lang/Object
    //   806: invokestatic 232	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   809: return
    //   810: astore 5
    //   812: aload_2
    //   813: astore 4
    //   815: aload 5
    //   817: astore_2
    //   818: goto +120 -> 938
    //   821: astore 4
    //   823: aload_2
    //   824: astore 5
    //   826: aload_3
    //   827: astore_2
    //   828: aload 5
    //   830: astore_3
    //   831: goto +40 -> 871
    //   834: astore_3
    //   835: aload_2
    //   836: astore 4
    //   838: aload_3
    //   839: astore_2
    //   840: aconst_null
    //   841: astore_3
    //   842: goto +96 -> 938
    //   845: astore 4
    //   847: aload_2
    //   848: astore_3
    //   849: aconst_null
    //   850: astore_2
    //   851: goto +20 -> 871
    //   854: astore_2
    //   855: aconst_null
    //   856: astore_3
    //   857: aload 5
    //   859: astore 4
    //   861: goto +77 -> 938
    //   864: astore 4
    //   866: aconst_null
    //   867: astore_2
    //   868: aload 6
    //   870: astore_3
    //   871: ldc 67
    //   873: iconst_1
    //   874: aload 4
    //   876: iconst_0
    //   877: anewarray 4	java/lang/Object
    //   880: invokestatic 232	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   883: aload_3
    //   884: ifnull +22 -> 906
    //   887: aload_3
    //   888: invokevirtual 224	java/io/InputStream:close	()V
    //   891: goto +15 -> 906
    //   894: astore_3
    //   895: ldc 67
    //   897: iconst_1
    //   898: aload_3
    //   899: iconst_0
    //   900: anewarray 4	java/lang/Object
    //   903: invokestatic 232	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   906: aload_2
    //   907: ifnull +20 -> 927
    //   910: aload_2
    //   911: invokevirtual 225	java/io/ByteArrayOutputStream:close	()V
    //   914: return
    //   915: astore_2
    //   916: ldc 67
    //   918: iconst_1
    //   919: aload_2
    //   920: iconst_0
    //   921: anewarray 4	java/lang/Object
    //   924: invokestatic 232	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   927: return
    //   928: astore 5
    //   930: aload_3
    //   931: astore 4
    //   933: aload_2
    //   934: astore_3
    //   935: aload 5
    //   937: astore_2
    //   938: aload 4
    //   940: ifnull +25 -> 965
    //   943: aload 4
    //   945: invokevirtual 224	java/io/InputStream:close	()V
    //   948: goto +17 -> 965
    //   951: astore 4
    //   953: ldc 67
    //   955: iconst_1
    //   956: aload 4
    //   958: iconst_0
    //   959: anewarray 4	java/lang/Object
    //   962: invokestatic 232	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   965: aload_3
    //   966: ifnull +22 -> 988
    //   969: aload_3
    //   970: invokevirtual 225	java/io/ByteArrayOutputStream:close	()V
    //   973: goto +15 -> 988
    //   976: astore_3
    //   977: ldc 67
    //   979: iconst_1
    //   980: aload_3
    //   981: iconst_0
    //   982: anewarray 4	java/lang/Object
    //   985: invokestatic 232	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   988: goto +5 -> 993
    //   991: aload_2
    //   992: athrow
    //   993: goto -2 -> 991
    //   996: aconst_null
    //   997: astore_2
    //   998: aload_2
    //   999: astore_3
    //   1000: goto -853 -> 147
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1003	0	this	SSOListConfig
    //   674	11	1	i	int
    //   13	761	2	localObject1	Object
    //   780	5	2	localIOException1	IOException
    //   797	16	2	localIOException2	IOException
    //   817	34	2	localObject2	Object
    //   854	1	2	localObject3	Object
    //   867	44	2	localObject4	Object
    //   915	19	2	localIOException3	IOException
    //   937	62	2	localObject5	Object
    //   81	750	3	localObject6	Object
    //   834	5	3	localObject7	Object
    //   841	47	3	localObject8	Object
    //   894	37	3	localIOException4	IOException
    //   934	36	3	localIOException5	IOException
    //   976	5	3	localIOException6	IOException
    //   999	1	3	localObject9	Object
    //   63	751	4	localObject10	Object
    //   821	1	4	localException1	java.lang.Exception
    //   836	1	4	localObject11	Object
    //   845	1	4	localException2	java.lang.Exception
    //   859	1	4	localObject12	Object
    //   864	11	4	localException3	java.lang.Exception
    //   931	13	4	localObject13	Object
    //   951	6	4	localIOException7	IOException
    //   41	1	5	localObject14	Object
    //   810	6	5	localObject15	Object
    //   824	34	5	localObject16	Object
    //   928	8	5	localObject17	Object
    //   44	825	6	localObject18	Object
    //   154	371	7	localObject19	Object
    // Exception table:
    //   from	to	target	type
    //   773	777	780	java/io/IOException
    //   792	796	797	java/io/IOException
    //   661	668	810	finally
    //   668	675	810	finally
    //   680	688	810	finally
    //   691	769	810	finally
    //   661	668	821	java/lang/Exception
    //   668	675	821	java/lang/Exception
    //   680	688	821	java/lang/Exception
    //   691	769	821	java/lang/Exception
    //   653	661	834	finally
    //   653	661	845	java/lang/Exception
    //   46	56	854	finally
    //   57	62	854	finally
    //   65	101	854	finally
    //   101	105	854	finally
    //   109	117	854	finally
    //   122	144	854	finally
    //   147	317	854	finally
    //   321	331	854	finally
    //   335	347	854	finally
    //   351	403	854	finally
    //   403	445	854	finally
    //   445	532	854	finally
    //   532	615	854	finally
    //   618	637	854	finally
    //   640	647	854	finally
    //   647	653	854	finally
    //   46	56	864	java/lang/Exception
    //   57	62	864	java/lang/Exception
    //   65	101	864	java/lang/Exception
    //   101	105	864	java/lang/Exception
    //   109	117	864	java/lang/Exception
    //   122	144	864	java/lang/Exception
    //   147	317	864	java/lang/Exception
    //   321	331	864	java/lang/Exception
    //   335	347	864	java/lang/Exception
    //   351	403	864	java/lang/Exception
    //   403	445	864	java/lang/Exception
    //   445	532	864	java/lang/Exception
    //   532	615	864	java/lang/Exception
    //   618	637	864	java/lang/Exception
    //   640	647	864	java/lang/Exception
    //   647	653	864	java/lang/Exception
    //   887	891	894	java/io/IOException
    //   910	914	915	java/io/IOException
    //   871	883	928	finally
    //   943	948	951	java/io/IOException
    //   969	973	976	java/io/IOException
  }
  
  public void handleSSOConfigData(PatchBundleConfig.SSOListConfig.OnSSODataFetchListener paramOnSSODataFetchListener)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("handleSSOConfigData mCmd:");
      localStringBuilder.append(this.mCmd);
      QLog.d("PatchBundleConfig", 2, localStringBuilder.toString());
    }
    ThreadManagerV2.excute(new PatchBundleConfig.SSOListConfig.1(this, paramOnSSODataFetchListener), 16, null, false);
  }
  
  public void loadCache()
  {
    if (TextUtils.isEmpty(this.mRsp))
    {
      long l = System.currentTimeMillis();
      Object localObject = PatchBundleConfig.access$000();
      if (localObject == null)
      {
        QLog.e("PatchBundleConfig", 1, "loadCache appRuntime == null");
        return;
      }
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append(PatchUtils.getSSOCacheFilePath(this.mKey));
      localStringBuilder1.append(((AppRuntime)localObject).getAccount());
      localStringBuilder1.append(".txt");
      localObject = new File(localStringBuilder1.toString());
      if (((File)localObject).exists()) {
        try
        {
          this.mRsp = FileUtils.readFileToString((File)localObject);
        }
        catch (IOException localIOException)
        {
          QLog.e("PatchBundleConfig", 1, localIOException, new Object[0]);
        }
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("loadCache path:");
        localStringBuilder2.append(((File)localObject).getAbsolutePath());
        localStringBuilder2.append(" use ");
        localStringBuilder2.append(System.currentTimeMillis() - l);
        QLog.d("PatchBundleConfig", 2, localStringBuilder2.toString());
      }
    }
  }
  
  public void saveCache()
  {
    if (!TextUtils.isEmpty(this.mRsp))
    {
      Object localObject = PatchBundleConfig.access$000();
      if (localObject == null)
      {
        QLog.e("PatchBundleConfig", 1, "saveCache appRuntime == null");
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(PatchUtils.getSSOCacheFilePath(this.mKey));
      localStringBuilder.append(((AppRuntime)localObject).getAccount());
      localStringBuilder.append(".txt");
      localObject = new File(localStringBuilder.toString());
      ((File)localObject).delete();
      FileUtils.writeFile(((File)localObject).getAbsolutePath(), this.mRsp);
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SSOListConfig{mType='");
    localStringBuilder.append(this.mType);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mCmd='");
    localStringBuilder.append(this.mCmd);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mMethod='");
    localStringBuilder.append(this.mMethod);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mNeedCookie=");
    localStringBuilder.append(this.mNeedCookie);
    localStringBuilder.append(", mParam='");
    localStringBuilder.append(this.mParam);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mRsp='");
    localStringBuilder.append(this.mRsp);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.hippy.qq.patchbundle.PatchBundleConfig.SSOListConfig
 * JD-Core Version:    0.7.0.1
 */